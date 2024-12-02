package com.example.controller;

import com.example.entity.Soda;
import com.example.repository.SodaRepository;
import com.example.exception.ResourceNotFoundException;
import com.example.service.SodaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/sodas")
public class SodaController {

    SodaRepository sodaRepository;
    SodaService sodaService;

    @Autowired
    public SodaController(SodaRepository sodaRepository) {
        this.sodaRepository = sodaRepository;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Iterable<Soda>> fetchAll() {
        Iterable<Soda> sodas = sodaRepository.findAll();
        return new ResponseEntity<Iterable<Soda>>(sodas, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Soda> fetchById(@PathVariable int id) {
        Optional<Soda> optionalSoda =  sodaRepository.findById(id);
        if (optionalSoda.isEmpty()) {
            throw new ResourceNotFoundException(id);
        }
        return new ResponseEntity<Soda>(optionalSoda.get(), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        if (sodaRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException(id);
        }
        sodaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Soda deleted");
    }

    @Transactional
    @PostMapping(value = {"", "/"})
    public ResponseEntity<String> addSoda(@RequestBody Soda soda) {
        sodaRepository.save(soda);
        return ResponseEntity.status(HttpStatus.CREATED).body("New soda created");
    }

    @Transactional
    @PatchMapping(value = "{id}")
    public ResponseEntity<Soda> updateSoda(@PathVariable int id, @RequestBody Soda soda) {
        Soda updatedSoda = sodaService.updateById(id, soda);
        return ResponseEntity.status(HttpStatus.OK).body(updatedSoda);
    }

}
