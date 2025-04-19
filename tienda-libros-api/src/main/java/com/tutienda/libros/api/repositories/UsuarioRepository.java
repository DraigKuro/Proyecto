package com.tutienda.libros.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tutienda.libros.api.models.Usuario;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Buscar usuario por su nombre de usuario
    Optional<Usuario> findByUsuario(String usuario);

}
