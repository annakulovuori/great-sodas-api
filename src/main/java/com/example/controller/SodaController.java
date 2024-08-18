package com.example.controller;

import com.example.entity.Soda;
import com.example.repository.SodaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/sodas")
public class SodaController {

    SodaRepository sodaRepository;
    @Autowired
    public SodaController(SodaRepository sodaRepository) {
        this.sodaRepository = sodaRepository;
    }

    @GetMapping(value = "/api/sodas/{id}")
    public ResponseEntity<Soda> fetchById(@PathVariable int id) {
        Optional<Soda> optionalSoda =  sodaRepository.findById(id);
        if (optionalSoda.isEmpty()) {
            throw new IllegalArgumentException("cannot find with id");
        }
        return new ResponseEntity<Soda>(optionalSoda.get(), HttpStatus.OK);
    }

}
