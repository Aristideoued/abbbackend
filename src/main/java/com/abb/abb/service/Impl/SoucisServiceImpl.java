package com.abb.abb.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abb.abb.dto.SoucisDto;
import com.abb.abb.mapper.SoucisMapper;
import com.abb.abb.model.Filleul;
import com.abb.abb.model.Soucis;
import com.abb.abb.repository.FilleulRepository;
import com.abb.abb.repository.SoucisRepository;
import com.abb.abb.service.SoucisService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SoucisServiceImpl implements SoucisService {

    private final SoucisRepository repository;
    private final SoucisMapper mapper;
    private final FilleulRepository filleulRepository;

    public SoucisServiceImpl(SoucisRepository repository,
            SoucisMapper mapper,
            FilleulRepository filleulRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.filleulRepository = filleulRepository;
    }

    @Override
    public SoucisDto save(SoucisDto dto) {
        Filleul filleul = dto.getFilleulId() != null ? filleulRepository.findById(dto.getFilleulId()).orElse(null)
                : null;
        Soucis entity = mapper.toEntity(dto, filleul);
        Soucis saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public SoucisDto update(Long id, SoucisDto dto) {
        Soucis existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soucis non trouvé avec id " + id));

        existing.setDescription(dto.getDescription());
        existing.setCreatedAt(dto.getCreatedAt());
        if (dto.getFilleulId() != null) {
            Filleul filleul = filleulRepository.findById(dto.getFilleulId())
                    .orElseThrow(() -> new RuntimeException("Filleul non trouvé avec id " + dto.getFilleulId()));
            existing.setFilleul(filleul);
        }

        Soucis updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public SoucisDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public List<SoucisDto> findAll() {
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
