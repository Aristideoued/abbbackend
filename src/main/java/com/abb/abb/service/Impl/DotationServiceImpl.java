package com.abb.abb.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abb.abb.dto.DotationDto;
import com.abb.abb.mapper.DotationMapper;
import com.abb.abb.model.Dotation;
import com.abb.abb.model.Filleul;
import com.abb.abb.model.Parrain;
import com.abb.abb.repository.DotationRepository;
import com.abb.abb.repository.FilleulRepository;
import com.abb.abb.repository.ParrainRepository;
import com.abb.abb.service.DotationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DotationServiceImpl implements DotationService {

    private final DotationRepository dotationRepository;
    private final DotationMapper dotationMapper;
    private final FilleulRepository filleulRepository;
    private final ParrainRepository parrainRepository;

    public DotationServiceImpl(DotationRepository dotationRepository,
            DotationMapper dotationMapper,
            FilleulRepository filleulRepository,
            ParrainRepository parrainRepository) {
        this.dotationRepository = dotationRepository;
        this.dotationMapper = dotationMapper;
        this.filleulRepository = filleulRepository;
        this.parrainRepository = parrainRepository;
    }

    @Override
    public DotationDto save(DotationDto dto) {
        Filleul filleul = dto.getFilleulId() != null ? filleulRepository.findById(dto.getFilleulId()).orElse(null)
                : null;
        Parrain parrain = dto.getParrainId() != null ? parrainRepository.findById(dto.getParrainId()).orElse(null)
                : null;

        Dotation dotation = dotationMapper.toEntity(dto, filleul, parrain);
        Dotation saved = dotationRepository.save(dotation);
        return dotationMapper.toDto(saved);
    }

    @Override
    public DotationDto findById(Long id) {
        return dotationRepository.findById(id)
                .map(dotationMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<DotationDto> findAll() {
        return dotationRepository.findAll()
                .stream()
                .map(dotationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        dotationRepository.deleteById(id);
    }
}
