package com.tutienda.libros.api.services.impl;

import com.tutienda.libros.api.dto.UsuarioDTO;
import com.tutienda.libros.api.models.Usuario;
import com.tutienda.libros.api.repositories.UsuarioRepository;
import com.tutienda.libros.api.services.BibliotecaService;
import com.tutienda.libros.api.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.math.BigDecimal;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BibliotecaService bibliotecaService;

    @Override
    public Optional<Usuario> iniciarSesion(String usuario, String pass) {
        Optional<Usuario> userOpt = usuarioRepository.findByUsuario(usuario);
        if (userOpt.isEmpty()) {
            return Optional.empty();
        }

        Usuario user = userOpt.get();
        String combinado = pass + user.getSemilla();

        if (passwordEncoder.matches(combinado, user.getPass())) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Usuario registrarUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.findByUsuario(usuarioDTO.getUsuario()).isPresent()) {
            throw new RuntimeException("Nombre de usuario ya existe");
        }

        String semilla = generarSemilla();
        String combinado = usuarioDTO.getPass() + semilla;
        String passFinal = passwordEncoder.encode(combinado);

        Usuario usuario = usuarioDTO.toEntity(passFinal);
        usuario.setSemilla(semilla);
        usuario.setFechaRegistro(new Date());
        usuario.setCartera(BigDecimal.ZERO);
        
        bibliotecaService.crearBiblioteca(usuarioDTO);

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(String nombreUsuario, UsuarioDTO usuarioDTO) {
        Usuario existente = usuarioRepository.findByUsuario(nombreUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (usuarioDTO.getNombre() != null && !usuarioDTO.getNombre().isEmpty()) {
            existente.setNombre(usuarioDTO.getNombre());
        }
        if (usuarioDTO.getApellidos() != null && !usuarioDTO.getApellidos().isEmpty()) {
            existente.setApellidos(usuarioDTO.getApellidos());
        }
        if (usuarioDTO.getCartera() != null) {
            existente.setCartera(usuarioDTO.getCartera());
        }

        return usuarioRepository.save(existente);
    }

    @Override
    public Usuario actualizarCorreo(String nombreUsuario, String nuevoCorreo) {
        Usuario existente = usuarioRepository.findByUsuario(nombreUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Aquí podrías añadir validación de formato o unicidad del correo si lo deseas
        existente.setCorreo(nuevoCorreo);
        return usuarioRepository.save(existente);
    }

    @Override
    public boolean actualizarContraseña(String usuario, String contraseñaAntigua, String contraseñaNueva) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsuario(usuario);
        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Usuario usuarioExistente = usuarioOpt.get();
        String combinado = contraseñaAntigua + usuarioExistente.getSemilla();

        if (!passwordEncoder.matches(combinado, usuarioExistente.getPass())) {
            return false;
        }

        String nuevaContraseñaHasheada = passwordEncoder.encode(contraseñaNueva + usuarioExistente.getSemilla());
        usuarioExistente.setPass(nuevaContraseñaHasheada);

        usuarioRepository.save(usuarioExistente);
        return true;
    }

    @Override
    public Usuario actualizarFondos(String nombreUsuario, BigDecimal cantidad) {
        Usuario existente = usuarioRepository.findByUsuario(nombreUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        existente.setCartera(existente.getCartera().add(cantidad));

        return usuarioRepository.save(existente);
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
