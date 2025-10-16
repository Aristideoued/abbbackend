package com.abb.abb.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abb.abb.dto.ParrainDto;
import com.abb.abb.mapper.ParrainMapper;
import com.abb.abb.model.Parrain;
import com.abb.abb.repository.ParrainRepository;
import com.abb.abb.service.ParrainService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParrainServiceImpl implements ParrainService {

    private final ParrainRepository parrainRepository;
    private final ParrainMapper parrainMapper;

    public ParrainServiceImpl(ParrainRepository parrainRepository,
            ParrainMapper parrainMapper) {
        this.parrainRepository = parrainRepository;
        this.parrainMapper = parrainMapper;
    }

    @Override
    public ParrainDto save(ParrainDto dto) {
        Parrain parrain = parrainMapper.toEntity(dto);
        Parrain saved = parrainRepository.save(parrain);
        return parrainMapper.toDto(saved);
    }

    @Override
    public ParrainDto update(Long id, ParrainDto dto) {
        Parrain existing = parrainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parrain non trouvé avec id " + id));

        existing.setNom(dto.getNom());
        existing.setPrenom(dto.getPrenom());
        existing.setEmail(dto.getEmail());
        existing.setTelephone(dto.getTelephone());
        existing.setStatut(dto.getStatut());
        existing.setSexe(dto.getSexe());
        // Si tu veux gérer les dotations, tu peux les mapper ici

        Parrain updated = parrainRepository.save(existing);
        return parrainMapper.toDto(updated);
    }

    @Override
    public ParrainDto findById(Long id) {
        return parrainRepository.findById(id)
                .map(parrainMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<ParrainDto> findAll() {
        return parrainRepository.findAll()
                .stream()
                .map(parrainMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        parrainRepository.deleteById(id);
    }
}
