package com.tutienda.libros.api.dto;

import org.springframework.web.multipart.MultipartFile;
import java.math.BigDecimal;
import java.util.Date;

public class LibroDTO {

    private String idLibro;
    private String titulo;
    private Date fechaPubli;
    private BigDecimal precio;
    private Short descuento;
    private boolean drm;
    private int nPaginas;
    private String sinopsis;
    private Integer nVotos;
    private Short valoracion;

    // Campos para archivos (transient - no se persisten)
    private transient MultipartFile archivoPortada;
    private transient MultipartFile archivoLibro;

    // URIs resultantes
    private String urlPortada;
    private String urlLibro;

    // Getters y Setters para todos los campos
    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPubli() {
        return fechaPubli;
    }

    public void setFechaPubli(Date fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Short getDescuento() {
        return descuento;
    }

    public void setDescuento(Short descuento) {
        this.descuento = descuento;
    }

    public boolean isDrm() {
        return drm;
    }

    public void setDrm(boolean drm) {
        this.drm = drm;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Integer getnVotos() {
        return nVotos;
    }

    public void setnVotos(Integer nVotos) {
        this.nVotos = nVotos;
    }

    public Short getValoracion() {
        return valoracion;
    }

    public void setValoracion(Short valoracion) {
        this.valoracion = valoracion;
    }

    public MultipartFile getArchivoPortada() {
        return archivoPortada;
    }

    public void setArchivoPortada(MultipartFile archivoPortada) {
        this.archivoPortada = archivoPortada;
    }

    public MultipartFile getArchivoLibro() {
        return archivoLibro;
    }

    public void setArchivoLibro(MultipartFile archivoLibro) {
        this.archivoLibro = archivoLibro;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public String getUrlLibro() {
        return urlLibro;
    }

    public void setUrlLibro(String urlLibro) {
        this.urlLibro = urlLibro;
    }
}
