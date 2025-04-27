package com.tutienda.libros.api.services;

import com.tutienda.libros.api.dto.LibroDTO;
import com.tutienda.libros.api.models.Libro;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface LibroService {

    // Métodos originales
    Libro buscarPorId(String idLibro);
    Libro crearLibro(Libro libro);
    Libro actualizarLibro(String idLibro, Libro libro);
    void eliminarLibro(String idLibro);

    // métodos para DTOs y archivos
    Libro crearLibroDesdeDTO(LibroDTO libroDTO) throws IOException;
    Libro actualizarLibroDesdeDTO(String idLibro, LibroDTO libroDTO) throws IOException;

    //  método para búsqueda avanzada
    List<Libro> buscarLibrosConFiltros(
            String nombreLibro,
            String nombreAutor,
            String nombreGenero,
            String nombreSaga,
            LocalDate fechaPublicacion,
            Double valoracionMin,
            Double valoracionMax,
            BigDecimal precioMin,
            BigDecimal precioMax,
            String nombreIdioma
    );
}
