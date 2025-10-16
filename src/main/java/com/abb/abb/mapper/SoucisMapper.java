package com.abb.abb.mapper;

import org.springframework.stereotype.Component;

import com.abb.abb.dto.SoucisDto;
import com.abb.abb.model.Filleul;
import com.abb.abb.model.Soucis;

@Component
public class SoucisMapper {

    public SoucisDto toDto(Soucis entity) {
        if (entity == null)
            return null;
        SoucisDto dto = new SoucisDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setCreatedAt(entity.getCreatedAt());
        if (entity.getFilleul() != null) {
            dto.setFilleulId(entity.getFilleul().getId());
        }
        return dto;
    }

    public Soucis toEntity(SoucisDto dto, Filleul filleul) {
        if (dto == null)
            return null;
        Soucis entity = new Soucis();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setFilleul(filleul);
        return entity;
    }
}
