package com.abb.abb.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abb.abb.dto.PropositionDto;
import com.abb.abb.mapper.PropositionMapper;
import com.abb.abb.model.AG;
import com.abb.abb.model.Proposition;
import com.abb.abb.repository.AgRepository;
import com.abb.abb.repository.PropositionRepository;
import com.abb.abb.service.PropositionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PropositionServiceImpl implements PropositionService {

    private final PropositionRepository propositionRepository;
    private final PropositionMapper propositionMapper;
    private final AgRepository agRepository;

    public PropositionServiceImpl(PropositionRepository propositionRepository,
            PropositionMapper propositionMapper,
            AgRepository agRepository) {
        this.propositionRepository = propositionRepository;
        this.propositionMapper = propositionMapper;
        this.agRepository = agRepository;
    }

    @Override
    public PropositionDto save(PropositionDto dto) {
        AG ag = dto.getAgId() != null ? agRepository.findById(dto.getAgId()).orElse(null) : null;
        Proposition proposition = propositionMapper.toEntity(dto, ag);
        Proposition saved = propositionRepository.save(proposition);
        return propositionMapper.toDto(saved);
    }

    @Override
    public PropositionDto update(Long id, PropositionDto dto) {
        Proposition existing = propositionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proposition non trouvée avec id " + id));

        existing.setDescription(dto.getDescription());
        if (dto.getAgId() != null) {
            AG ag = agRepository.findById(dto.getAgId())
                    .orElseThrow(() -> new RuntimeException("AG non trouvé avec id " + dto.getAgId()));
            existing.setAg(ag);
        }

        Proposition updated = propositionRepository.save(existing);
        return propositionMapper.toDto(updated);
    }

    @Override
    public PropositionDto findById(Long id) {
        return propositionRepository.findById(id)
                .map(propositionMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<PropositionDto> findAll() {
        return propositionRepository.findAll()
                .stream()
                .map(propositionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        propositionRepository.deleteById(id);
    }
}
