package com.abb.abb.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilleulDto {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String niveau;
    private String classe;
    private String statut;
    private LocalDate dateNaissance;
    private String sexe;

    private List<Long> dotationIds;
    private List<Long> soucisIds;
    private List<Long> documentIds;

}
