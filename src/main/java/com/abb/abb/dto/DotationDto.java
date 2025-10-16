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
public class DotationDto {
    private Long id;
    private String description;
    private LocalDate dateRemise;
    private Long filleulId;
    private Long parrainId;

}
