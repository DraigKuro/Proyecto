package com.tutienda.libros.api.services;

import com.tutienda.libros.api.dto.UsuarioDTO;
import com.tutienda.libros.api.models.Biblioteca;
import com.tutienda.libros.api.models.Libro;

import java.util.List;

public interface BibliotecaService {

    Biblioteca crearBiblioteca(UsuarioDTO usuario);

    Biblioteca obtenerBiblioteca(UsuarioDTO usuario);

    Biblioteca agregarLibrosABiblioteca(UsuarioDTO usuario, List<Libro> libro);

    Biblioteca eliminarLibrosDeBiblioteca(UsuarioDTO usuario, List<Libro> libro);
}
