package com.abb.abb.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.abb.abb.model.User;
import com.abb.abb.repository.RoleRepository;
import com.abb.abb.repository.UserRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.get("email"),
                        request.get("password")));

        String token = jwtUtils.generateToken(request.get("email"));
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        var role = roleRepository.findByLibelle(request.get("role"))
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setNom(request.get("nom"));
        user.setPrenom(request.get("prenom"));
        user.setTelephone(request.get("telephone"));
        user.setEmail(request.get("email"));
        user.setPassword(passwordEncoder.encode(request.get("password")));
        user.setRole(role);

        userRepository.save(user);

        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }
}
