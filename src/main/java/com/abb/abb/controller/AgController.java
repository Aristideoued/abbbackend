package com.abb.abb.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abb.abb.dto.AgDto;
import com.abb.abb.dto.AgRequest;
import com.abb.abb.service.AgService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ags")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AgController {

    private final AgService agService;

    @PostMapping
    public ResponseEntity<AgDto> createAg(@RequestBody AgRequest request) {
        return ResponseEntity.ok(agService.createAg(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgDto> getAg(@PathVariable Long id) {
        return ResponseEntity.ok(agService.getAgById(id));
    }

    @GetMapping
    public ResponseEntity<List<AgDto>> getAllAgs() {
        return ResponseEntity.ok(agService.getAllAgs());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgDto> updateAg(@PathVariable Long id, @RequestBody AgRequest request) {
        return ResponseEntity.ok(agService.updateAg(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAg(@PathVariable Long id) {
        agService.deleteAg(id);
        return ResponseEntity.noContent().build();
    }
}
