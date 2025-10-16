package com.abb.abb.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.abb.abb.dto.AgDto;
import com.abb.abb.dto.AgRequest;
import com.abb.abb.mapper.AgMapper;
import com.abb.abb.model.AG;
import com.abb.abb.repository.AgRepository;
import com.abb.abb.service.AgService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgServiceImpl implements AgService {

    private final AgRepository agRepository;
    private final AgMapper agMapper;

    @Override
    public AgDto createAg(AgRequest request) {
        AG ag = AG.builder()
                .date(request.getDate())
                .lieu(request.getLieu())
                .build();

        return agMapper.toDto(agRepository.save(ag));
    }

    @Override
    public AgDto getAgById(Long id) {
        return agRepository.findById(id)
                .map(agMapper::toDto)
                .orElseThrow(() -> new RuntimeException("AG not found"));
    }

    @Override
    public List<AgDto> getAllAgs() {
        return agRepository.findAll()
                .stream()
                .map(agMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AgDto updateAg(Long id, AgRequest request) {
        AG ag = agRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AG not found"));

        ag.setDate(request.getDate());
        ag.setLieu(request.getLieu());

        return agMapper.toDto(agRepository.save(ag));
    }

    @Override
    public void deleteAg(Long id) {
        agRepository.deleteById(id);
    }
}