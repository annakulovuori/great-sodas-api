package com.example.service;

import com.example.entity.Soda;
import com.example.exception.ResourceNotFoundException;
import com.example.mapper.SodaMapper;
import com.example.repository.SodaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SodaService {

    private final SodaRepository repository;
    private final SodaMapper mapper;

    public Soda updateById(int id, Soda soda) {
        Soda foundSoda = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        int foundId = foundSoda.getId();

    // käy läpi sodan ja jos siellä on tyhjä niin pitää vanhan. Ylikirjoitetaan vanha eli palautetaan vanha.
        mapper.updateSoda(soda, foundSoda);
        foundSoda.setId(foundId);
        repository.save(foundSoda);
        return foundSoda;
    }
}
