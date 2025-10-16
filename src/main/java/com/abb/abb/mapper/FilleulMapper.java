package com.abb.abb.mapper;

import org.springframework.stereotype.Component;

import com.abb.abb.dto.FilleulDto;
import com.abb.abb.model.Filleul;

import java.util.stream.Collectors;

@Component
public class FilleulMapper {

    public FilleulDto toDto(Filleul entity) {
        if (entity == null)
            return null;
        FilleulDto dto = new FilleulDto();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setTelephone(entity.getTelephone());
        dto.setEmail(entity.getEmail());
        dto.setNiveau(entity.getNiveau());
        dto.setClasse(entity.getClasse());
        dto.setStatut(entity.getStatut());
        dto.setDateNaissance(entity.getDateNaissance());
        dto.setSexe(entity.getSexe());

        if (entity.getDotations() != null) {
            dto.setDotationIds(entity.getDotations()
                    .stream()
                    .map(d -> d.getId())
                    .collect(Collectors.toList()));
        }
        if (entity.getSoucis() != null) {
            dto.setSoucisIds(entity.getSoucis()
                    .stream()
                    .map(s -> s.getId())
                    .collect(Collectors.toList()));
        }
        if (entity.getDocuments() != null) {
            dto.setDocumentIds(entity.getDocuments()
                    .stream()
                    .map(doc -> doc.getId())
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public Filleul toEntity(FilleulDto dto) {
        if (dto == null)
            return null;
        Filleul entity = new Filleul();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setTelephone(dto.getTelephone());
        entity.setEmail(dto.getEmail());
        entity.setNiveau(dto.getNiveau());
        entity.setClasse(dto.getClasse());
        entity.setStatut(dto.getStatut());
        entity.setDateNaissance(dto.getDateNaissance());
        entity.setSexe(dto.getSexe());
        return entity;
    }
}
