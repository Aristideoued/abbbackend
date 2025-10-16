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
public class Filleul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "filleul", cascade = CascadeType.ALL)
    private List<Dotation> dotations;

    @OneToMany(mappedBy = "filleul", cascade = CascadeType.ALL)
    private List<Soucis> soucis;

    @OneToMany(mappedBy = "filleul", cascade = CascadeType.ALL)
    private List<Document> documents;
}
