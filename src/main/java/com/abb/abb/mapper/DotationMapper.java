package com.abb.abb.mapper;

import org.springframework.stereotype.Component;

import com.abb.abb.dto.DotationDto;
import com.abb.abb.model.Dotation;
import com.abb.abb.model.Filleul;
import com.abb.abb.model.Parrain;

@Component
public class DotationMapper {

    public DotationDto toDto(Dotation dotation) {
        if (dotation == null)
            return null;
        DotationDto dto = new DotationDto();
        dto.setId(dotation.getId());
        dto.setDescription(dotation.getDescription());
        dto.setDateRemise(dotation.getDateRemise());
        if (dotation.getFilleul() != null)
            dto.setFilleulId(dotation.getFilleul().getId());
        if (dotation.getParrain() != null)
            dto.setParrainId(dotation.getParrain().getId());
        return dto;
    }

    public Dotation toEntity(DotationDto dto, Filleul filleul, Parrain parrain) {
        if (dto == null)
            return null;
        Dotation dotation = new Dotation();
        dotation.setId(dto.getId());
        dotation.setDescription(dto.getDescription());
        dotation.setDateRemise(dto.getDateRemise());
        dotation.setFilleul(filleul);
        dotation.setParrain(parrain);
        return dotation;
    }
}
