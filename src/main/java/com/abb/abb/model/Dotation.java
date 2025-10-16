package com.abb.abb.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDate dateRemise;

    @ManyToOne
    private Filleul filleul;

    @ManyToOne
    private Parrain parrain;
}
