package com.tutienda.libros.repositories;

import com.tutienda.libros.models.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
      // Buscar por usuario
    Optional<Usuario> findByUsuario(String usuario);
    
    // Buscar por correo
    Optional<Usuario> findByCorreo(String correo);
    
    // Buscar por nombre y apellido
    List<Usuario> findByNombreContainingIgnoreCaseAndApellidosContainingIgnoreCase(String nombre, String apellidos);
}
