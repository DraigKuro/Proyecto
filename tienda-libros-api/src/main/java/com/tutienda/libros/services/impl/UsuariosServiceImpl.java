package com.tutienda.libros.services.impl;

import com.tutienda.libros.models.Usuario;
import com.tutienda.libros.repositories.UsuariosRepository;
import com.tutienda.libros.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuario> getUsuarioById(int id) {
        return usuariosRepository.findById(id);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(int id, Usuario usuario) {
        if (usuariosRepository.existsById(id)) {
            usuario.setIdUsuario(id);  // Asegura que se está actualizando el usuario correcto
            return usuariosRepository.save(usuario);
        }
        return null;  // O lanzar una excepción personalizada si el usuario no existe
    }

    @Override
    public void deleteUsuario(int id) {
        usuariosRepository.deleteById(id);
    }
}
