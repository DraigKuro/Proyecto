package com.tutienda.libros.api.controllers;

import com.tutienda.libros.api.models.Libro;
import com.tutienda.libros.api.services.LibroService;
import com.tutienda.libros.api.dto.LibroDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
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
            if (libroCreado != null) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Libro>> buscarPorFiltros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String saga,
            @RequestParam(required = false) LocalDate fechaPublicacion,
            @RequestParam(required = false) Double valoracionMin,
            @RequestParam(required = false) Double valoracionMax,
            @RequestParam(required = false) BigDecimal precioMin,
            @RequestParam(required = false) BigDecimal precioMax,
            @RequestParam(required = false) String idioma) {

        List<Libro> libros = libroService.buscarLibrosConFiltros(
                titulo, autor, genero, saga, fechaPublicacion,
                valoracionMin, valoracionMax, precioMin, precioMax, idioma);

        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{idLibro}")
    public ResponseEntity<Libro> buscarPorId(@PathVariable String idLibro) {
        Libro libro = libroService.buscarPorId(idLibro);
        return ResponseEntity.ok(libro);
    }

    // Actualizar libro con archivos (PUT)
    @PutMapping(value = "/{idLibro}", consumes = "multipart/form-data")
    public ResponseEntity<Libro> actualizarLibro(
            @PathVariable String idLibro,
            @ModelAttribute LibroDTO libroDTO) {
        try {
            Libro libroActualizado = libroService.actualizarLibroDesdeDTO(idLibro, libroDTO);
            if (libroActualizado != null) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Eliminar libro (DELETE)
    @DeleteMapping("/{idLibro}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable String idLibro) {
        libroService.eliminarLibro(idLibro);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
