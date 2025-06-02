package com.tutienda.libros.api.services.impl;

import com.tutienda.libros.api.dto.UsuarioDTO;
import com.tutienda.libros.api.models.Biblioteca;
import com.tutienda.libros.api.models.BiblioLibro;
import com.tutienda.libros.api.models.Libro;
import com.tutienda.libros.api.models.Usuario;
import com.tutienda.libros.api.repositories.BibliotecaRepository;
import com.tutienda.libros.api.repositories.UsuarioRepository;
import com.tutienda.libros.api.services.BibliotecaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BibliotecaServiceImpl implements BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Biblioteca crearBiblioteca(UsuarioDTO usuarioDTO) {
        // Buscar entidad de usuario
        Usuario usuario = usuarioRepository.findByUsuario(usuarioDTO.getUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Crear nueva biblioteca
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setIdFkUsuario(usuario);
        biblioteca.setUltimoRegistro(new Date());
        biblioteca.setBiblioLibroCollection(new ArrayList<>());

        return bibliotecaRepository.save(biblioteca);
    }

  @Override
    public Biblioteca obtenerBiblioteca(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findByUsuario(usuarioDTO.getUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Biblioteca> bibliotecas = bibliotecaRepository.findByIdFkUsuario(usuario);
        if (bibliotecas.isEmpty()) {
            throw new RuntimeException("Biblioteca no encontrada para el usuario");
        }
        return bibliotecas.get(0);
    }

    @Override
    public Biblioteca agregarLibrosABiblioteca(UsuarioDTO usuarioDTO, List<Libro> libros) {
        Biblioteca biblioteca = obtenerBiblioteca(usuarioDTO);

        // Inicializar colección si es null
        if (biblioteca.getBiblioLibroCollection() == null) {
            biblioteca.setBiblioLibroCollection(new ArrayList<>());
        }
        for (Libro libro : libros) {
            BiblioLibro bl = new BiblioLibro();
            bl.setBiblioteca(biblioteca);
            bl.setLibro(libro);
            biblioteca.getBiblioLibroCollection().add(bl);
        }
        biblioteca.setUltimoRegistro(new Date());
        return bibliotecaRepository.save(biblioteca);
    }

    @Override
    public Biblioteca eliminarLibrosDeBiblioteca(UsuarioDTO usuarioDTO, List<Libro> libros) {
        Biblioteca biblioteca = obtenerBiblioteca(usuarioDTO);
        if (biblioteca.getBiblioLibroCollection() != null) {
            biblioteca.getBiblioLibroCollection().removeIf(bl -> libros.contains(bl.getLibro()));
        }
        biblioteca.setUltimoRegistro(new Date());
        return bibliotecaRepository.save(biblioteca);
    }
}
