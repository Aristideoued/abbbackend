package com.abb.abb.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgRequest {
    private LocalDate date;
    private String lieu;
}
