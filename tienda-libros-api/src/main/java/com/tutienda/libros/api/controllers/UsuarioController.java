package com.tutienda.libros.api.controllers;

import com.tutienda.libros.api.dto.*;
import com.tutienda.libros.api.models.Usuario;
import com.tutienda.libros.api.services.UsuarioService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Registrar un nuevo usuario
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        // Convertir DTO a entidad Usuario
        Usuario usuario = new Usuario();
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setPass(usuarioDTO.getPass());  // La contraseña recibida será hasheada en el servicio
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellidos(usuarioDTO.getApellidos());

        // Registrar usuario
        usuarioService.registrarUsuario(usuario);

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
        Usuario usuarioExistente = usuarioService.buscarPorUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Actualizar solo si el campo no está vacío o nulo
        if (usuarioDTO.getNombre() != null && !usuarioDTO.getNombre().isEmpty()) {
            usuarioExistente.setNombre(usuarioDTO.getNombre());
        }
        if (usuarioDTO.getApellidos() != null && !usuarioDTO.getApellidos().isEmpty()) {
            usuarioExistente.setApellidos(usuarioDTO.getApellidos());
        }

        // Guardar los cambios en el repositorio
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuarioExistente);
        UsuarioDTO respuestaDTO = UsuarioDTO.fromEntity(usuarioActualizado);

        return new ResponseEntity<>(respuestaDTO, HttpStatus.OK);
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
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorUsuario(usuario);

        if (usuarioOpt.isEmpty()) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }

        Usuario u = usuarioOpt.get();
        u.setCartera(u.getCartera().add(cantidad));
        usuarioService.actualizarUsuario(u);

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
