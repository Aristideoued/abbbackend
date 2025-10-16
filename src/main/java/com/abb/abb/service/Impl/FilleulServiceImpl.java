package com.abb.abb.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abb.abb.dto.FilleulDto;
import com.abb.abb.mapper.FilleulMapper;
import com.abb.abb.model.Filleul;
import com.abb.abb.repository.FilleulRepository;
import com.abb.abb.service.FilleulService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FilleulServiceImpl implements FilleulService {

    private final FilleulRepository repository;
    private final FilleulMapper mapper;

    public FilleulServiceImpl(FilleulRepository repository, FilleulMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FilleulDto save(FilleulDto dto) {
        Filleul entity = mapper.toEntity(dto);
        Filleul saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public FilleulDto update(Long id, FilleulDto dto) {
        Filleul existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filleul non trouvé avec id " + id));

        existing.setNom(dto.getNom());
        existing.setPrenom(dto.getPrenom());
        existing.setTelephone(dto.getTelephone());
        existing.setEmail(dto.getEmail());
        existing.setNiveau(dto.getNiveau());
        existing.setClasse(dto.getClasse());
        existing.setStatut(dto.getStatut());
        existing.setDateNaissance(dto.getDateNaissance());
        existing.setSexe(dto.getSexe());

        Filleul updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public FilleulDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public List<FilleulDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
