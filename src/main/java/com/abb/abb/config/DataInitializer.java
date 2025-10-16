package com.abb.abb.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.abb.abb.model.Role;
import com.abb.abb.model.User;
import com.abb.abb.repository.RoleRepository;
import com.abb.abb.repository.UserRepository;
import com.abb.abb.service.RoleService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(RoleRepository roleRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Créer le rôle ADMIN s'il n'existe pas
        Role adminRole = roleRepository.findByLibelle("ADMIN")
                .orElseGet(() -> {
                    Role r = new Role();
                    r.setLibelle("ADMIN");
                    return roleRepository.save(r);
                });

        // Créer le rôle USER s'il n'existe pas
        roleRepository.findByLibelle("USER")
                .orElseGet(() -> {
                    Role r = new Role();
                    r.setLibelle("USER");
                    return roleRepository.save(r);
                });

        // Créer l'utilisateur admin si inexistant
        userRepository.findByEmail("admin@abb.com")
                .orElseGet(() -> {
                    User admin = new User();
                    admin.setNom("Admin");
                    admin.setPrenom("ABB");
                    admin.setEmail("admin@abb.com");
                    admin.setPassword(passwordEncoder.encode("adminabb"));
                    admin.setTelephone("0000000000");
                    admin.setRole(adminRole); // rôle ADMIN
                    return userRepository.save(admin);
                });

        System.out.println("✅ Initialisation des rôles et de l'utilisateur ADMIN terminée.");
    }
}
