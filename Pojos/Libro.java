package com.mycompany.proyecto.Pojos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Entity
@Table(name = "libro")
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIdLibro", query = "SELECT l FROM Libro l WHERE l.idLibro = :idLibro"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libro.findByIdioma", query = "SELECT l FROM Libro l WHERE l.idioma = :idioma"),
    @NamedQuery(name = "Libro.findByGenero", query = "SELECT l FROM Libro l WHERE l.genero = :genero"),
    @NamedQuery(name = "Libro.findByFechaPubli", query = "SELECT l FROM Libro l WHERE l.fechaPubli = :fechaPubli"),
    @NamedQuery(name = "Libro.findByAutores", query = "SELECT l FROM Libro l WHERE l.autores = :autores"),
    @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio"),
    @NamedQuery(name = "Libro.findByDrm", query = "SELECT l FROM Libro l WHERE l.drm = :drm"),
    @NamedQuery(name = "Libro.findByNPaginas", query = "SELECT l FROM Libro l WHERE l.nPaginas = :nPaginas"),
    @NamedQuery(name = "Libro.findBySinopsis", query = "SELECT l FROM Libro l WHERE l.sinopsis = :sinopsis"),
    @NamedQuery(name = "Libro.findByValoracion", query = "SELECT l FROM Libro l WHERE l.valoracion = :valoracion"),
    @NamedQuery(name = "Libro.findByUrllibro", query = "SELECT l FROM Libro l WHERE l.urllibro = :urllibro"),
    @NamedQuery(name = "Libro.findByUrlportada", query = "SELECT l FROM Libro l WHERE l.urlportada = :urlportada")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_libro")
    private Integer idLibro;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "idioma")
    private String idioma;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "fecha_publi")
    @Temporal(TemporalType.DATE)
    private Date fechaPubli;
    @Basic(optional = false)
    @Column(name = "autores")
    private String autores;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @Column(name = "drm")
    private boolean drm;
    @Basic(optional = false)
    @Column(name = "n_paginas")
    private int nPaginas;
    @Basic(optional = false)
    @Column(name = "sinopsis")
    private String sinopsis;
    @Basic(optional = false)
    @Column(name = "valoracion")
    private String valoracion;
    @Basic(optional = false)
    @Column(name = "urllibro")
    private String urllibro;
    @Basic(optional = false)
    @Column(name = "urlportada")
    private String urlportada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<BiblioLibro> biblioLibroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<LibroEdit> libroEditCollection;

    public Libro() {
    }

    public Libro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Libro(Integer idLibro, String titulo, String idioma, String genero, Date fechaPubli, String autores, double precio, boolean drm, int nPaginas, String sinopsis, String valoracion, String urllibro, String urlportada) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.idioma = idioma;
        this.genero = genero;
        this.fechaPubli = fechaPubli;
        this.autores = autores;
        this.precio = precio;
        this.drm = drm;
        this.nPaginas = nPaginas;
        this.sinopsis = sinopsis;
        this.valoracion = valoracion;
        this.urllibro = urllibro;
        this.urlportada = urlportada;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaPubli() {
        return fechaPubli;
    }

    public void setFechaPubli(Date fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getDrm() {
        return drm;
    }

    public void setDrm(boolean drm) {
        this.drm = drm;
    }

    public int getNPaginas() {
        return nPaginas;
    }

    public void setNPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getUrllibro() {
        return urllibro;
    }

    public void setUrllibro(String urllibro) {
        this.urllibro = urllibro;
    }

    public String getUrlportada() {
        return urlportada;
    }

    public void setUrlportada(String urlportada) {
        this.urlportada = urlportada;
    }

    public Collection<BiblioLibro> getBiblioLibroCollection() {
        return biblioLibroCollection;
    }

    public void setBiblioLibroCollection(Collection<BiblioLibro> biblioLibroCollection) {
        this.biblioLibroCollection = biblioLibroCollection;
    }

    public Collection<LibroEdit> getLibroEditCollection() {
        return libroEditCollection;
    }

    public void setLibroEditCollection(Collection<LibroEdit> libroEditCollection) {
        this.libroEditCollection = libroEditCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Pojos.Libro[ idLibro=" + idLibro + " ]";
    }

}
