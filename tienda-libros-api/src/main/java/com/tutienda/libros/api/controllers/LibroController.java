package com.tutienda.libros.api.controllers;

import com.tutienda.libros.api.models.Libro;
import com.tutienda.libros.api.services.LibroService;
import com.tutienda.libros.api.dto.LibroDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Obtener todos los libros(GET)
    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodosLibros() {
        List<Libro> libros = libroService.obtenerTodosLosLibros();
        return ResponseEntity.ok(libros);
    }

    // Crear libro con archivos (POST)
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Libro> crearLibro(@ModelAttribute LibroDTO libroDTO) {
        try {
            Libro libroCreado = libroService.crearLibroDesdeDTO(libroDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(libroCreado);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener un libro por su ID(GET)
    @GetMapping("/{idLibro}")
    public ResponseEntity<Libro> buscarPorId(@PathVariable String idLibro) {
        Libro libro = libroService.buscarPorId(idLibro);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    // Actualizar libro con archivos (PUT)
    @PutMapping(value = "/{idLibro}", consumes = "multipart/form-data")
    public ResponseEntity<Libro> actualizarLibro(
            @PathVariable String idLibro,
            @ModelAttribute LibroDTO libroDTO) {
        try {
            Libro libroActualizado = libroService.actualizarLibroDesdeDTO(idLibro, libroDTO);
            if (libroActualizado == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(libroActualizado);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Eliminar libro (DELETE)
    @DeleteMapping("/{idLibro}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable String idLibro) {
        libroService.eliminarLibro(idLibro);
        return ResponseEntity.noContent().build();
    }
}
