package com.abb.abb.service;

import java.util.List;

import com.abb.abb.dto.SoucisDto;

public interface SoucisService {
    SoucisDto save(SoucisDto dto);

    SoucisDto update(Long id, SoucisDto dto);

    SoucisDto findById(Long id);

    List<SoucisDto> findAll();

    void delete(Long id);
}
