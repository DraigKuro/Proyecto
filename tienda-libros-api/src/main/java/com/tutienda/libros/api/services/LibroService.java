package com.tutienda.libros.api.services;

import com.tutienda.libros.api.dto.LibroDTO;
import com.tutienda.libros.api.models.Libro;
import java.io.IOException;
import java.util.List;

public interface LibroService {

    // Métodos originales
    List<Libro> buscarPorTituloContiene(String titulo);

    Libro buscarPorId(String idLibro);

    Libro crearLibro(Libro libro);

    Libro actualizarLibro(String idLibro, Libro libro);

    void eliminarLibro(String idLibro);

    // Nuevos métodos para DTOs y archivos
    Libro crearLibroDesdeDTO(LibroDTO libroDTO) throws IOException;

    Libro actualizarLibroDesdeDTO(String idLibro, LibroDTO libroDTO) throws IOException;
}
