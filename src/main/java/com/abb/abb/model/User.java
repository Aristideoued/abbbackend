package com.abb.abb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utilisateurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}
