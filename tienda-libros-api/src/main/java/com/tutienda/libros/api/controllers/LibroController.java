package com.tutienda.libros.api.controllers;

import com.tutienda.libros.api.dto.LibroDTO;
import com.tutienda.libros.api.models.Libro;
import com.tutienda.libros.api.services.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Crear libro con archivos (POST)
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Libro> crearLibro(@ModelAttribute LibroDTO libroDTO) {
        try {
            Libro libroCreado = libroService.crearLibroDesdeDTO(libroDTO);
            return new ResponseEntity<>(libroCreado, HttpStatus.CREATED);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Actualizar libro con archivos (PUT)
    @PutMapping(value = "/{idLibro}", consumes = "multipart/form-data")
    public ResponseEntity<Libro> actualizarLibro(
            @PathVariable String idLibro,
            @ModelAttribute LibroDTO libroDTO) {
        try {
            Libro libroActualizado = libroService.actualizarLibroDesdeDTO(idLibro, libroDTO);
            return ResponseEntity.ok(libroActualizado);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Buscar por título (GET)
    @GetMapping("/buscar")
    public ResponseEntity<List<Libro>> buscarPorTitulo(@RequestParam String titulo) {
        List<Libro> libros = libroService.buscarPorTituloContiene(titulo);
        return ResponseEntity.ok(libros);
    }

    // Buscar por ID (GET)
    @GetMapping("/{idLibro}")
    public ResponseEntity<Libro> buscarPorId(@PathVariable String idLibro) {
        Libro libro = libroService.buscarPorId(idLibro);
        return ResponseEntity.ok(libro);
    }

    // Eliminar libro (DELETE)
    @DeleteMapping("/{idLibro}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable String idLibro) {
        libroService.eliminarLibro(idLibro);
        return ResponseEntity.noContent().build();
    }
}
