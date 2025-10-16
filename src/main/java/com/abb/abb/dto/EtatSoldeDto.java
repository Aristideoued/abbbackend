package com.abb.abb.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtatSoldeDto {
    private Long id;
    private LocalDate date;
    private String description;
    private String compte;
    private double montant;

}
