package com.example.repository;

import com.example.entity.Soda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SodaRepository extends JpaRepository<Soda, Integer> {

    Optional<Soda> findByNameIgnoreCase(String name);
}
