package com.abb.abb.mapper;

import org.springframework.stereotype.Component;

import com.abb.abb.dto.DocumentDto;
import com.abb.abb.model.Document;
import com.abb.abb.model.Filleul;

@Component
public class DocumentMapper {

    public DocumentDto toDto(Document entity) {
        if (entity == null)
            return null;
        DocumentDto dto = new DocumentDto();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        if (entity.getFilleul() != null) {
            dto.setFilleulId(entity.getFilleul().getId());
        }
        return dto;
    }

    public Document toEntity(DocumentDto dto, Filleul filleul) {
        if (dto == null)
            return null;
        Document entity = new Document();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setFilleul(filleul);
        return entity;
    }
}
