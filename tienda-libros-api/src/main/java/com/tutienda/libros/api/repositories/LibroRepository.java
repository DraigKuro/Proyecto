package com.tutienda.libros.api.repositories;

import com.tutienda.libros.api.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {

    // Búsqueda exacta por ID (heredado de JpaRepository)
    Optional<Libro> findById(String idLibro);

    // Buscar libros por título que contenga una cadena (búsqueda parcial, case-insensitive)
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
}
