package com.abb.abb.mapper;

import org.springframework.stereotype.Component;

import com.abb.abb.dto.PropositionDto;
import com.abb.abb.model.AG;
import com.abb.abb.model.Proposition;

@Component
public class PropositionMapper {

    public PropositionDto toDto(Proposition proposition) {
        if (proposition == null)
            return null;
        PropositionDto dto = new PropositionDto();
        dto.setId(proposition.getId());
        dto.setDescription(proposition.getDescription());
        if (proposition.getAg() != null) {
            dto.setAgId(proposition.getAg().getId());
        }
        return dto;
    }

    public Proposition toEntity(PropositionDto dto, AG ag) {
        if (dto == null)
            return null;
        Proposition proposition = new Proposition();
        proposition.setId(dto.getId());
        proposition.setDescription(dto.getDescription());
        proposition.setAg(ag);
        return proposition;
    }
}
