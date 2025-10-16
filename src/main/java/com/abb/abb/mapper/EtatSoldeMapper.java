package com.abb.abb.mapper;

import org.springframework.stereotype.Component;

import com.abb.abb.dto.EtatSoldeDto;
import com.abb.abb.model.EtatSolde;

@Component
public class EtatSoldeMapper {

    public EtatSoldeDto toDto(EtatSolde entity) {
        if (entity == null)
            return null;
        EtatSoldeDto dto = new EtatSoldeDto();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setDescription(entity.getDescription());
        dto.setCompte(entity.getCompte());
        dto.setMontant(entity.getMontant());
        return dto;
    }

    public EtatSolde toEntity(EtatSoldeDto dto) {
        if (dto == null)
            return null;
        EtatSolde entity = new EtatSolde();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setDescription(dto.getDescription());
        entity.setCompte(dto.getCompte());
        entity.setMontant(dto.getMontant());
        return entity;
    }
}
