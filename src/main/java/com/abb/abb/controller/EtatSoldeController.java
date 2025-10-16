package com.abb.abb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abb.abb.dto.EtatSoldeDto;
import com.abb.abb.service.EtatSoldeService;

import java.util.List;

@RestController
@RequestMapping("/api/etat-soldes")
public class EtatSoldeController {

    private final EtatSoldeService service;

    public EtatSoldeController(EtatSoldeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EtatSoldeDto> create(@RequestBody EtatSoldeDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtatSoldeDto> update(@PathVariable Long id, @RequestBody EtatSoldeDto dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatSoldeDto> getById(@PathVariable Long id) {
        EtatSoldeDto dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<EtatSoldeDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
