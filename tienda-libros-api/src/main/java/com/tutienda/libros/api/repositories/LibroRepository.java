package com.tutienda.libros.api.repositories;

import com.tutienda.libros.api.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String>, JpaSpecificationExecutor<Libro> {
}
