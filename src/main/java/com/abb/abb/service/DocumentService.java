package com.abb.abb.service;

import org.springframework.web.multipart.MultipartFile;

import com.abb.abb.dto.DocumentDto;

import java.util.List;

public interface DocumentService {
    DocumentDto save(Long filleulId, MultipartFile file) throws Exception;

    List<DocumentDto> findByFilleul(Long filleulId);

    byte[] download(Long filleulId, String fileName) throws Exception;

    void delete(Long id) throws Exception;
}
