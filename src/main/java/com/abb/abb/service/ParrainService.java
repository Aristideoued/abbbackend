package com.abb.abb.service;

import java.util.List;

import com.abb.abb.dto.ParrainDto;

public interface ParrainService {
    ParrainDto save(ParrainDto dto);

    ParrainDto findById(Long id);

    List<ParrainDto> findAll();

    void delete(Long id);

    ParrainDto update(Long id, ParrainDto dto);
}
