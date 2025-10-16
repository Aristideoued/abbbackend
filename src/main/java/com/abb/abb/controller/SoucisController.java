package com.abb.abb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abb.abb.dto.SoucisDto;
import com.abb.abb.service.SoucisService;

import java.util.List;

@RestController
@RequestMapping("/api/soucis")
public class SoucisController {

    private final SoucisService service;

    public SoucisController(SoucisService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SoucisDto> create(@RequestBody SoucisDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoucisDto> update(@PathVariable Long id, @RequestBody SoucisDto dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoucisDto> getById(@PathVariable Long id) {
        SoucisDto dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<SoucisDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
