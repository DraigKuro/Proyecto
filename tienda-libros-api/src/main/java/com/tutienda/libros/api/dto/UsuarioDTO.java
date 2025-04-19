package com.tutienda.libros.api.dto;

import java.math.BigDecimal;

public class UsuarioDTO {
    private String usuario;
    private String pass;  // Contraseña en texto plano para el registro
    private String nombre;
    private String apellidos;
    private BigDecimal cartera;

    // Constructor vacío
    public UsuarioDTO() {}

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

    // Método para transformar un DTO a entidad Usuario
    public static UsuarioDTO fromEntity(com.tutienda.libros.api.models.Usuario usuario) {
        return new UsuarioDTO(
                usuario.getUsuario(),
                null,  // La contraseña no se debe incluir en el DTO de la respuesta
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getCartera()
        );
    }

    // Método para convertir el DTO a una entidad Usuario (para crear un nuevo usuario)
    public com.tutienda.libros.api.models.Usuario toEntity(String semillaHashedPassword) {
        com.tutienda.libros.api.models.Usuario usuario = new com.tutienda.libros.api.models.Usuario();
        usuario.setUsuario(this.usuario);
        usuario.setPass(semillaHashedPassword);  // Se pasa la contraseña hasheada con la semilla
        usuario.setNombre(this.nombre);
        usuario.setApellidos(this.apellidos);
        usuario.setCartera(this.cartera);
        return usuario;
    }
}
