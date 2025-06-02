package com.tutienda.libros.api.controllers;

import com.tutienda.libros.api.models.Usuario;
import com.tutienda.libros.api.services.UsuarioService;
import com.tutienda.libros.api.dto.UsuarioDTO;
import com.tutienda.libros.api.dto.ActualizarContraseñaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Registrar un nuevo usuario
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.registrarUsuario(usuarioDTO);
        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
    }

    // Login de usuario
    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> iniciarSesion(@RequestBody UsuarioDTO usuarioDTO) {
        // Intentar iniciar sesión con el usuario y contraseña proporcionados
        Optional<Usuario> usuarioOpt = usuarioService.iniciarSesion(usuarioDTO.getUsuario(), usuarioDTO.getPass());

        if (usuarioOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // Si no se encuentra el usuario
        }

        // Convertir la entidad a DTO y devolverla
        UsuarioDTO respuestaDTO = UsuarioDTO.fromEntity(usuarioOpt.get());
        return new ResponseEntity<>(respuestaDTO, HttpStatus.OK);
    }

    // Actualizar datos de un usuario existente
    @PutMapping("/actualizar/{usuario}")
    public ResponseEntity<UsuarioDTO> actualizarDatosUsuario(@PathVariable String usuario, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuario, usuarioDTO);
        UsuarioDTO respuestaDTO = UsuarioDTO.fromEntity(usuarioActualizado);
        return new ResponseEntity<>(respuestaDTO, HttpStatus.OK);
    }

    // Actualizar solo el correo
    @PutMapping("/actualizar/correo/{usuario}")
    public ResponseEntity<String> actualizarCorreo(
            @PathVariable String usuario,
            @RequestParam String nuevoCorreo) {
        usuarioService.actualizarCorreo(usuario, nuevoCorreo);
        return new ResponseEntity<>("Correo actualizado exitosamente", HttpStatus.OK);
    }

    // Actualizar solo la contraseña
    @PutMapping("/actualizar/contraseña/{usuario}")
    public ResponseEntity<String> actualizarContraseña(@PathVariable String usuario, @RequestBody ActualizarContraseñaDTO actualizarContraseñaDTO) {
        boolean contraseñaActualizada = usuarioService.actualizarContraseña(usuario, actualizarContraseñaDTO.getContraseñaAntigua(), actualizarContraseñaDTO.getContraseñaNueva());

        if (!contraseñaActualizada) {
            return new ResponseEntity<>("Contraseña antigua incorrecta", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Contraseña actualizada exitosamente", HttpStatus.OK);
    }

    // Agregar fondos
    @PatchMapping("/fondos/{usuario}")
    public ResponseEntity<String> agregarFondos(@PathVariable String usuario, @RequestParam BigDecimal cantidad) {
        usuarioService.actualizarFondos(usuario, cantidad);
        return new ResponseEntity<>("Fondos agregados exitosamente", HttpStatus.OK);
    }

    // Eliminar un usuario por nombre de usuario
    @DeleteMapping("/eliminar/{usuario}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String usuario) {
        if (!usuarioService.buscarPorUsuario(usuario).isPresent()) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }

        usuarioService.eliminarUsuarioPorUsuario(usuario);
        return new ResponseEntity<>("Usuario eliminado exitosamente", HttpStatus.OK);
    }
}
