package com.abb.abb.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abb.abb.dto.UserDto;
import com.abb.abb.dto.UserRequest;
import com.abb.abb.mapper.UserMapper;
import com.abb.abb.model.Role;
import com.abb.abb.model.User;
import com.abb.abb.repository.RoleRepository;
import com.abb.abb.repository.UserRepository;
import com.abb.abb.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserRequest request) {
        Role role = roleRepository.findByLibelle(request.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found: " + request.getRole()));

        User user = User.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .telephone(request.getTelephone())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setTelephone(request.getTelephone());
        user.setEmail(request.getEmail());

        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        if (request.getRole() != null) {
            Role role = roleRepository.findByLibelle(request.getRole())
                    .orElseThrow(() -> new RuntimeException("Role not found: " + request.getRole()));
            user.setRole(role);
        }

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
