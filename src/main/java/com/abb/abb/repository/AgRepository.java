package com.abb.abb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abb.abb.model.AG;

@Repository
public interface AgRepository extends JpaRepository<AG, Long> {
}
