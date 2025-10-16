package com.abb.abb.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abb.abb.dto.EtatSoldeDto;
import com.abb.abb.mapper.EtatSoldeMapper;
import com.abb.abb.model.EtatSolde;
import com.abb.abb.repository.EtatSoldeRepository;
import com.abb.abb.service.EtatSoldeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EtatSoldeServiceImpl implements EtatSoldeService {

    private final EtatSoldeRepository repository;
    private final EtatSoldeMapper mapper;

    public EtatSoldeServiceImpl(EtatSoldeRepository repository, EtatSoldeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EtatSoldeDto save(EtatSoldeDto dto) {
        EtatSolde entity = mapper.toEntity(dto);
        EtatSolde saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public EtatSoldeDto update(Long id, EtatSoldeDto dto) {
        EtatSolde existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("EtatSolde non trouvé avec id " + id));

        existing.setDate(dto.getDate());
        existing.setDescription(dto.getDescription());
        existing.setCompte(dto.getCompte());
        existing.setMontant(dto.getMontant());

        EtatSolde updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public EtatSoldeDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public List<EtatSoldeDto> findAll() {
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
