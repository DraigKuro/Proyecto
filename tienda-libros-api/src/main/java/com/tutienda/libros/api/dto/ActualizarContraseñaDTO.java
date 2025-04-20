package com.tutienda.libros.api.dto;

public class ActualizarContraseñaDTO {
    private String contraseñaAntigua;  // Contraseña actual del usuario
    private String contraseñaNueva;    // Nueva contraseña

    // Constructor vacío
    public ActualizarContraseñaDTO() {}

    // Constructor con todos los parámetros
    public ActualizarContraseñaDTO(String contraseñaAntigua, String contraseñaNueva) {
        this.contraseñaAntigua = contraseñaAntigua;
        this.contraseñaNueva = contraseñaNueva;
    }

    // Getters y Setters
    public String getContraseñaAntigua() {
        return contraseñaAntigua;
    }

    public void setContraseñaAntigua(String contraseñaAntigua) {
        this.contraseñaAntigua = contraseñaAntigua;
    }

    public String getContraseñaNueva() {
        return contraseñaNueva;
    }

    public void setContraseñaNueva(String contraseñaNueva) {
        this.contraseñaNueva = contraseñaNueva;
    }
}
