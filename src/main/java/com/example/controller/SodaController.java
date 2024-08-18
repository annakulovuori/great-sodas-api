package com.example.controller;

import com.example.entity.Soda;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/sodas")
public class SodaController {

    @GetMapping(value = "/api/sodas/{id}")
    public ResponseEntity<Soda> fetchById(@PathVariable int id) {
        return null;
    }

}
