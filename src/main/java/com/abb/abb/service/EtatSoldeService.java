package com.abb.abb.service;

import java.util.List;

import com.abb.abb.dto.EtatSoldeDto;

public interface EtatSoldeService {
    EtatSoldeDto save(EtatSoldeDto dto);

    EtatSoldeDto update(Long id, EtatSoldeDto dto);

    EtatSoldeDto findById(Long id);

    List<EtatSoldeDto> findAll();

    void delete(Long id);
}
