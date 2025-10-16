package com.abb.abb.service;

import java.util.List;

import com.abb.abb.dto.PropositionDto;

public interface PropositionService {
    PropositionDto save(PropositionDto dto);

    PropositionDto update(Long id, PropositionDto dto);

    PropositionDto findById(Long id);

    List<PropositionDto> findAll();

    void delete(Long id);
}
