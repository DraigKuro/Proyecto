package com.tutienda.libros.api.services.impl;

import com.tutienda.libros.api.models.Usuario;
import com.tutienda.libros.api.repositories.UsuarioRepository;
import com.tutienda.libros.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<Usuario> iniciarSesion(String usuario, String pass) {
        Optional<Usuario> userOpt = usuarioRepository.findByUsuario(usuario);
        if (userOpt.isEmpty()) return Optional.empty();

        Usuario user = userOpt.get();
        String combinado = pass + user.getSemilla();

        if (passwordEncoder.matches(combinado, user.getPass())) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent()) {
            throw new RuntimeException("Nombre de usuario ya existe");
        }

        String semilla = generarSemilla();
        String combinado = usuario.getPass() + semilla;
        String passFinal = passwordEncoder.encode(combinado);

        usuario.setSemilla(semilla);
        usuario.setPass(passFinal);
        usuario.setFechaRegistro(new Date());

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Optional<Usuario> existente = usuarioRepository.findByUsuario(usuario.getUsuario());
        if (existente.isEmpty()) throw new RuntimeException("Usuario no encontrado");

        Usuario actualizado = existente.get();
        actualizado.setNombre(usuario.getNombre());
        actualizado.setApellidos(usuario.getApellidos());
        actualizado.setCartera(usuario.getCartera());
        return usuarioRepository.save(actualizado);
    }

    @Override
    public void eliminarUsuarioPorUsuario(String usuario) {
        Optional<Usuario> existente = usuarioRepository.findByUsuario(usuario);
        existente.ifPresent(usuarioRepository::delete);
    }

    @Override
    public Optional<Usuario> buscarPorUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    private String generarSemilla() {
        byte[] randomBytes = new byte[16];
        new SecureRandom().nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes);
    }
}
