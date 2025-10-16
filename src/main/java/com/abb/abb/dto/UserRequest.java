package com.abb.abb.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String password;
    private String role; // ex: "ADMIN" ou "USER"
}
