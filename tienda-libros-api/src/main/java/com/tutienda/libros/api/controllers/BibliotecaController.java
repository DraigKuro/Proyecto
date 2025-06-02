package com.tutienda.libros.api.controllers;

import com.tutienda.libros.api.dto.UsuarioDTO;
import com.tutienda.libros.api.models.Biblioteca;
import com.tutienda.libros.api.models.Libro;
import com.tutienda.libros.api.services.BibliotecaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecas")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    // Crear biblioteca para un usuario
    @PostMapping
    public ResponseEntity<Biblioteca> crearBiblioteca(@RequestBody UsuarioDTO usuarioDTO) {
        Biblioteca biblioteca = bibliotecaService.crearBiblioteca(usuarioDTO);
        return new ResponseEntity<>(biblioteca, HttpStatus.CREATED);
    }

    // Obtener biblioteca de un usuario
    @GetMapping
    public ResponseEntity<Biblioteca> obtenerBiblioteca(@RequestBody UsuarioDTO usuarioDTO) {
        Biblioteca biblioteca = bibliotecaService.obtenerBiblioteca(usuarioDTO);
        return ResponseEntity.ok(biblioteca);
    }

    // Agregar libros a la biblioteca de un usuario
    @PostMapping("/agregar-libros")
    public ResponseEntity<Biblioteca> agregarLibros(
            @RequestBody UsuarioDTO usuarioDTO,
            @RequestBody List<Libro> libros
    ) {
        Biblioteca biblioteca = bibliotecaService.agregarLibrosABiblioteca(usuarioDTO, libros);
        return ResponseEntity.ok(biblioteca);
    }

    // Eliminar libros de la biblioteca de un usuario
    @PostMapping("/eliminar-libros")
    public ResponseEntity<Biblioteca> eliminarLibros(
            @RequestBody UsuarioDTO usuarioDTO,
            @RequestBody List<Libro> libros
    ) {
        Biblioteca biblioteca = bibliotecaService.eliminarLibrosDeBiblioteca(usuarioDTO, libros);
        return ResponseEntity.ok(biblioteca);
    }
}
