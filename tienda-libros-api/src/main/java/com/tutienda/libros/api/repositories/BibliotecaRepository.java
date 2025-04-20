package com.tutienda.libros.api.repositories;

import com.tutienda.libros.api.models.Biblioteca;
import com.tutienda.libros.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer> {

    // Buscar biblioteca por usuario
    List<Biblioteca> findByIdFkUsuario(Usuario usuario);

    // Buscar biblioteca por idBiblioteca (en caso de que lo necesites en algún momento)
    Optional<Biblioteca> findByIdBiblioteca(Integer idBiblioteca);
}
