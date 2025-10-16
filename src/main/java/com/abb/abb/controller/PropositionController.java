package com.abb.abb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abb.abb.dto.PropositionDto;
import com.abb.abb.service.PropositionService;

import java.util.List;

@RestController
@RequestMapping("/api/propositions")
public class PropositionController {

    private final PropositionService propositionService;

    public PropositionController(PropositionService propositionService) {
        this.propositionService = propositionService;
    }

    @PostMapping
    public ResponseEntity<PropositionDto> create(@RequestBody PropositionDto dto) {
        return ResponseEntity.ok(propositionService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropositionDto> update(@PathVariable Long id, @RequestBody PropositionDto dto) {
        try {
            return ResponseEntity.ok(propositionService.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropositionDto> getById(@PathVariable Long id) {
        PropositionDto dto = propositionService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PropositionDto>> getAll() {
        return ResponseEntity.ok(propositionService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        propositionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
