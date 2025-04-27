package com.tutienda.libros.api.controllers;

import com.tutienda.libros.api.models.Idioma;
import com.tutienda.libros.api.services.IdiomaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/idiomas")
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @GetMapping
    public ResponseEntity<List<Idioma>> obtenerIdiomas() {
        List<Idioma> idiomas = idiomaService.obtenerIdiomas();
        return ResponseEntity.ok(idiomas);
    }
}
