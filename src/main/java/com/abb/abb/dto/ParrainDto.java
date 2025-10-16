package com.abb.abb.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParrainDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String statut;
    private String sexe;
    private List<Long> dotationIds;

}
