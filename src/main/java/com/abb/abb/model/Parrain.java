package com.abb.abb.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String statut;
    private String sexe;

    @OneToMany(mappedBy = "parrain", cascade = CascadeType.ALL)
    private List<Dotation> dotations;

}
