package com.abb.abb.service;

import java.util.List;

import com.abb.abb.dto.FilleulDto;

public interface FilleulService {
    FilleulDto save(FilleulDto dto);

    FilleulDto update(Long id, FilleulDto dto);

    FilleulDto findById(Long id);

    List<FilleulDto> findAll();

    void delete(Long id);
}
