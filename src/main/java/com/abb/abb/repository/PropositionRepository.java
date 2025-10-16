package com.abb.abb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abb.abb.model.Proposition;

public interface PropositionRepository extends JpaRepository<Proposition, Long> {
}
