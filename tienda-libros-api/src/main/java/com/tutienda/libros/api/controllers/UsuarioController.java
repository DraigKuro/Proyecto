package com.tutienda.libros.api.controllers;

import com.tutienda.libros.api.dto.UsuarioDTO;
import com.tutienda.libros.api.models.Usuario;
import com.tutienda.libros.api.services.UsuarioService;
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
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        System.out.println(">>> Entró al método registrarUsuario");
        // Convertir DTO a entidad Usuario
        Usuario usuario = new Usuario();
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setPass(usuarioDTO.getPass());  // La contraseña recibida será hasheada en el servicio
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellidos(usuarioDTO.getApellidos());
        usuario.setCartera(usuarioDTO.getCartera());

        // Registrar usuario
        Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);

        // Convertir la entidad registrada a DTO
        UsuarioDTO respuestaDTO = UsuarioDTO.fromEntity(usuarioRegistrado);

        return new ResponseEntity<>(respuestaDTO, HttpStatus.CREATED);
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
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable String usuario, @RequestBody UsuarioDTO usuarioDTO) {
        // Buscar el usuario por nombre de usuario
        Usuario usuarioExistente = usuarioService.buscarPorUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Actualizar los campos del usuario existente
        usuarioExistente.setNombre(usuarioDTO.getNombre());
        usuarioExistente.setApellidos(usuarioDTO.getApellidos());
        usuarioExistente.setCartera(usuarioDTO.getCartera());

        // Guardar los cambios en el repositorio
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuarioExistente);

        // Convertir la entidad a DTO para la respuesta
        UsuarioDTO respuestaDTO = UsuarioDTO.fromEntity(usuarioActualizado);

        return new ResponseEntity<>(respuestaDTO, HttpStatus.OK);
    }

    // Eliminar un usuario por nombre de usuario
    @DeleteMapping("/eliminar/{usuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String usuario) {
        // Verificar si el usuario existe
        if (!usuarioService.buscarPorUsuario(usuario).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Usuario no encontrado
        }

        // Eliminar el usuario
        usuarioService.eliminarUsuarioPorUsuario(usuario);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Eliminación exitosa
    }
}
