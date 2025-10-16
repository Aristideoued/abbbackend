package com.abb.abb.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String role;
}
