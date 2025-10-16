package com.abb.abb.mapper;

import org.springframework.stereotype.Component;

import com.abb.abb.dto.ParrainDto;
import com.abb.abb.model.Dotation;
import com.abb.abb.model.Parrain;

import java.util.stream.Collectors;

@Component
public class ParrainMapper {

    public ParrainDto toDto(Parrain parrain) {
        if (parrain == null)
            return null;
        ParrainDto dto = new ParrainDto();
        dto.setId(parrain.getId());
        dto.setNom(parrain.getNom());
        dto.setPrenom(parrain.getPrenom());
        dto.setEmail(parrain.getEmail());
        dto.setTelephone(parrain.getTelephone());
        dto.setStatut(parrain.getStatut());
        dto.setSexe(parrain.getSexe());
        if (parrain.getDotations() != null) {
            dto.setDotationIds(parrain.getDotations().stream()
                    .map(Dotation::getId)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public Parrain toEntity(ParrainDto dto) {
        if (dto == null)
            return null;
        Parrain parrain = new Parrain();
        parrain.setId(dto.getId());
        parrain.setNom(dto.getNom());
        parrain.setPrenom(dto.getPrenom());
        parrain.setEmail(dto.getEmail());
        parrain.setTelephone(dto.getTelephone());
        parrain.setStatut(dto.getStatut());
        parrain.setSexe(dto.getSexe());
        return parrain;
    }
}
