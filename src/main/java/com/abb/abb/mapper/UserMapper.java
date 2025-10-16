package com.abb.abb.mapper;

import org.springframework.stereotype.Component;

import com.abb.abb.dto.UserDto;
import com.abb.abb.model.User;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        if (user == null)
            return null;
        return UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .telephone(user.getTelephone())
                .email(user.getEmail())
                .role(user.getRole() != null ? user.getRole().getLibelle() : null)
                .build();
    }
}
