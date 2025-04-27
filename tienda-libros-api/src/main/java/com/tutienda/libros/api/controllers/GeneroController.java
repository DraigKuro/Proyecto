package com.tutienda.libros.api.controllers;

import com.tutienda.libros.api.models.Genero;
import com.tutienda.libros.api.services.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<Genero>> obtenerGeneros() {
        List<Genero> generos = generoService.obtenerGeneros();
        return ResponseEntity.ok(generos);
    }
}
