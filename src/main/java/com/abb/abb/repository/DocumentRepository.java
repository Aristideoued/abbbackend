package com.abb.abb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abb.abb.model.Document;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByFilleulId(Long filleulId);
}
