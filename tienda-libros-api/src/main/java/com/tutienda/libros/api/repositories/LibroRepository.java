package com.tutienda.libros.api.repositories;

import com.tutienda.libros.api.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {

    // Buscar libro por su ID
    Optional<Libro> findByIdLibro(String idLibro);

    // Crear/Actualizar libro (CRUD proporcionado por JpaRepository)
    Libro save(Libro libro);

    // Eliminar un libro de una biblioteca (no de la base de datos)
    void deleteByIdLibroAndBiblioteca_IdBiblioteca(String idLibro, Integer idBiblioteca);
}
