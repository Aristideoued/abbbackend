package com.abb.abb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abb.abb.dto.ParrainDto;
import com.abb.abb.service.ParrainService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parrains")
public class ParrainController {

    private final ParrainService service;

    public ParrainController(ParrainService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ParrainDto> create(@RequestBody ParrainDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParrainDto> update(@PathVariable Long id, @RequestBody ParrainDto dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParrainDto> getById(@PathVariable Long id) {
        ParrainDto dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ParrainDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
