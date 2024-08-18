package com.example.repository;

import com.example.entity.Soda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SodaRepository extends JpaRepository<Soda, Integer> {
}
