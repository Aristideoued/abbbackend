package com.abb.abb.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.abb.abb.dto.DocumentDto;
import com.abb.abb.service.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }

    @PostMapping("/upload/{filleulId}")
    public ResponseEntity<DocumentDto> upload(@PathVariable Long filleulId,
            @RequestParam("file") MultipartFile file) throws Exception {
        DocumentDto dto = service.save(filleulId, file);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/filleul/{filleulId}")
    public ResponseEntity<List<DocumentDto>> getByFilleul(@PathVariable Long filleulId) {
        return ResponseEntity.ok(service.findByFilleul(filleulId));
    }

    @GetMapping("/download/{filleulId}/{fileName}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable Long filleulId,
            @PathVariable String fileName) throws Exception {
        byte[] data = service.download(filleulId, fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
