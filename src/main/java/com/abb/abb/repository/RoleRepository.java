package com.abb.abb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abb.abb.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByLibelle(String libelle);
}