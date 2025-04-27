package com.tutienda.libros.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tutienda.libros.api.models.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}
