package com.abb.abb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abb.abb.model.Dotation;

public interface DotationRepository extends JpaRepository<Dotation, Long> {
}
