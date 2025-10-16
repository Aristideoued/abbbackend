package com.abb.abb.service;

import java.util.List;

import com.abb.abb.dto.AgDto;
import com.abb.abb.dto.AgRequest;

public interface AgService {
    AgDto createAg(AgRequest request);

    AgDto getAgById(Long id);

    List<AgDto> getAllAgs();

    AgDto updateAg(Long id, AgRequest request);

    void deleteAg(Long id);
}
