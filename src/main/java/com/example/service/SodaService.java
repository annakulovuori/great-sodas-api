package com.example.service;

import com.example.entity.Soda;
import com.example.repository.SodaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SodaService {

    private final SodaRepository repository;

    public Soda updateById(int id, Soda soda) {
    }
}
