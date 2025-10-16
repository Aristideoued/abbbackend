package com.abb.abb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abb.abb.dto.DotationDto;
import com.abb.abb.service.DotationService;

import java.util.List;

@RestController
@RequestMapping("/api/dotations")
public class DotationController {

    private final DotationService dotationService;

    public DotationController(DotationService dotationService) {
        this.dotationService = dotationService;
    }

    @PostMapping
    public ResponseEntity<DotationDto> create(@RequestBody DotationDto dto) {
        return ResponseEntity.ok(dotationService.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DotationDto> getById(@PathVariable Long id) {
        DotationDto dto = dotationService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DotationDto>> getAll() {
        return ResponseEntity.ok(dotationService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dotationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
