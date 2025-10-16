package com.abb.abb.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgDto {
    private Long id;
    private LocalDate date;
    private String lieu;
    private List<Long> propositionsIds; // pour éviter les boucles infinies
}