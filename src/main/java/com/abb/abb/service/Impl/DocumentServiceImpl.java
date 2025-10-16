package com.abb.abb.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.abb.abb.dto.DocumentDto;
import com.abb.abb.mapper.DocumentMapper;
import com.abb.abb.model.Document;
import com.abb.abb.model.Filleul;
import com.abb.abb.repository.DocumentRepository;
import com.abb.abb.repository.FilleulRepository;
import com.abb.abb.service.DocumentService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final FilleulRepository filleulRepository;
    private final DocumentMapper mapper;

    private final String baseDir = "documents"; // dossier de base

    public DocumentServiceImpl(DocumentRepository documentRepository,
            FilleulRepository filleulRepository,
            DocumentMapper mapper) {
        this.documentRepository = documentRepository;
        this.filleulRepository = filleulRepository;
        this.mapper = mapper;
    }

    @Override
    public DocumentDto save(Long filleulId, MultipartFile file) throws Exception {
        Filleul filleul = filleulRepository.findById(filleulId)
                .orElseThrow(() -> new RuntimeException("Filleul non trouvé"));

        // Créer le sous-dossier si nécessaire
        Path dirPath = Paths.get(baseDir, String.valueOf(filleulId));
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        // Sauvegarder le fichier
        Path filePath = dirPath.resolve(file.getOriginalFilename());
        file.transferTo(filePath.toFile());

        // Enregistrer dans la BD
        Document doc = new Document();
        doc.setNom(file.getOriginalFilename());
        doc.setFilleul(filleul);
        Document saved = documentRepository.save(doc);

        return mapper.toDto(saved);
    }

    @Override
    public List<DocumentDto> findByFilleul(Long filleulId) {
        return documentRepository.findByFilleulId(filleulId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public byte[] download(Long filleulId, String fileName) throws IOException {
        Path filePath = Paths.get(baseDir, String.valueOf(filleulId), fileName);
        if (!Files.exists(filePath)) {
            throw new RuntimeException("Fichier non trouvé");
        }
        return Files.readAllBytes(filePath);
    }

    @Override
    public void delete(Long id) throws IOException {
        Document doc = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document non trouvé"));
        Path filePath = Paths.get(baseDir, String.valueOf(doc.getFilleul().getId()), doc.getNom());
        Files.deleteIfExists(filePath);
        documentRepository.deleteById(id);
    }
}
