package com.abb.abb.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abb.abb.model.Role;
import com.abb.abb.repository.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void createRoleIfNotExists(String libelle) {
        roleRepository.findByLibelle(libelle).orElseGet(() -> {
            Role role = new Role();
            role.setLibelle(libelle);
            return roleRepository.save(role);
        });
    }
}
