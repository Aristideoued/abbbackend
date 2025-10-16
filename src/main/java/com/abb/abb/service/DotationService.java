package com.abb.abb.service;

import java.util.List;

import com.abb.abb.dto.DotationDto;

public interface DotationService {
    DotationDto save(DotationDto dotationDto);

    DotationDto findById(Long id);

    List<DotationDto> findAll();

    void delete(Long id);
}
