package com.abb.abb.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String lieu;

    @OneToMany(mappedBy = "ag", cascade = CascadeType.ALL)
    private List<Proposition> propositions;
}