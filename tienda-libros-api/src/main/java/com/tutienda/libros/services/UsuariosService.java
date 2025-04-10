package com.tutienda.libros.services;

import com.tutienda.libros.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {
    List<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuarioById(int id);
    Usuario saveUsuario(Usuario usuario);
    Usuario updateUsuario(int id, Usuario usuario);
    void deleteUsuario(int id);
}
