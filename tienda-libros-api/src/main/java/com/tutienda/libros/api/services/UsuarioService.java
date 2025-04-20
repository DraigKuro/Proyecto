package com.tutienda.libros.api.services;

import com.tutienda.libros.api.models.Usuario;

import java.util.Optional;

public interface UsuarioService {

    // Para login
    Optional<Usuario> iniciarSesion(String usuario, String pass);

    // Crear nuevo usuario (valida que el nombre de usuario no exista)
    Usuario registrarUsuario(Usuario usuario);

    // Actualizar usuario existente
    Usuario actualizarUsuario(Usuario usuario);

    // Eliminar por nombre de usuario
    void eliminarUsuarioPorUsuario(String usuario);

    // Buscar por nombre de usuario (para perfil, etc.)
    Optional<Usuario> buscarPorUsuario(String usuario);
    
    // Nuevo método para actualizar la contraseña
    boolean actualizarContraseña(String usuario, String contraseñaAntigua, String contraseñaNueva);
}
