package com.tutienda.libros.api.dto;

import com.tutienda.libros.api.models.Editorial;
import com.tutienda.libros.api.models.Usuario;
import java.math.BigDecimal;

public class UsuarioDTO {

    private String usuario;
    private String pass;
    private String nombre;
    private String apellidos;
    private BigDecimal cartera;
    private Editorial editorial;

    // Constructor vacío
    public UsuarioDTO() {
    }

    // Constructor con todos los parámetros
    public UsuarioDTO(String usuario, String pass, String nombre, String apellidos, BigDecimal cartera) {
        this.usuario = usuario;
        this.pass = pass;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cartera = cartera;
    }

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public BigDecimal getCartera() {
        return cartera;
    }

    public void setCartera(BigDecimal cartera) {
        this.cartera = cartera;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    // Método para transformar un DTO a entidad Usuario
    public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getUsuario(),
                null, // La contraseña no se debe incluir en el DTO de la respuesta
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getCartera()
        );
    }

    public Usuario toEntity(String semillaHashedPassword) {
        Usuario user = new Usuario();
        user.setUsuario(this.usuario);
        user.setPass(semillaHashedPassword);
        user.setNombre(this.nombre);
        user.setApellidos(this.apellidos);
        user.setEditorial(this.editorial);
        return user;
    }
}
