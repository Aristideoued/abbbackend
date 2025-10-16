package com.abb.abb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropositionDto {
    private Long id;
    private String description;
    private Long agId; // id de l'AG associé

}
