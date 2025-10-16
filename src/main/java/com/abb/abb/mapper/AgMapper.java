package com.abb.abb.mapper;

import org.springframework.stereotype.Component;

import com.abb.abb.dto.AgDto;
import com.abb.abb.model.AG;

import java.util.stream.Collectors;

@Component
public class AgMapper {

    public AgDto toDto(AG ag) {
        if (ag == null)
            return null;

        return AgDto.builder()
                .id(ag.getId())
                .date(ag.getDate())
                .lieu(ag.getLieu())
                .propositionsIds(ag.getPropositions() != null ? ag.getPropositions().stream()
                        .map(p -> p.getId())
                        .collect(Collectors.toList())
                        : null)
                .build();
    }
}
