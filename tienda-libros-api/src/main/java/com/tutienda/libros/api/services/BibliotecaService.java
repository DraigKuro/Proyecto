package com.tutienda.libros.api.services;

import com.tutienda.libros.api.models.Biblioteca;
import com.tutienda.libros.api.models.Libro;
import com.tutienda.libros.api.models.Usuario;

public interface BibliotecaService {

    Biblioteca crearBiblioteca(Usuario usuario);

    Biblioteca obtenerBiblioteca(Usuario usuario);

    Biblioteca actualizarBiblioteca(Usuario usuario);
    
    Biblioteca eliminarBiblioteca(Usuario usuario);

    Biblioteca añadirLibro(Libro libro);

    Biblioteca eliminarLibro(Libro libro);
}
