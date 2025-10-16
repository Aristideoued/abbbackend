package com.abb.abb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abb.abb.dto.FilleulDto;
import com.abb.abb.service.FilleulService;

import java.util.List;

@RestController
@RequestMapping("/api/filleuls")
public class FilleulController {

    private final FilleulService service;

    public FilleulController(FilleulService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FilleulDto> create(@RequestBody FilleulDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilleulDto> update(@PathVariable Long id, @RequestBody FilleulDto dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilleulDto> getById(@PathVariable Long id) {
        FilleulDto dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<FilleulDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
