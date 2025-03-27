package com.mycompany.proyecto.Pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
    @NamedQuery(name = "Libro.findByIDlibro", query = "SELECT l FROM Libro l WHERE l.iDlibro = :iDlibro"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libro.findByFechaPubli", query = "SELECT l FROM Libro l WHERE l.fechaPubli = :fechaPubli"),
    @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio"),
    @NamedQuery(name = "Libro.findByDrm", query = "SELECT l FROM Libro l WHERE l.drm = :drm"),
    @NamedQuery(name = "Libro.findByNpaginas", query = "SELECT l FROM Libro l WHERE l.npaginas = :npaginas"),
    @NamedQuery(name = "Libro.findByURLibro", query = "SELECT l FROM Libro l WHERE l.uRLibro = :uRLibro"),
    @NamedQuery(name = "Libro.findByURLportada", query = "SELECT l FROM Libro l WHERE l.uRLportada = :uRLportada")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_libro")
    private Integer iDlibro;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Lob
    @Column(name = "idioma")
    private String idioma;
    @Basic(optional = false)
    @Lob
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "fecha_publi")
    @Temporal(TemporalType.DATE)
    private Date fechaPubli;
    @Basic(optional = false)
    @Lob
    @Column(name = "autores")
    private String autores;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "DRM")
    private Boolean drm;
    @Basic(optional = false)
    @Column(name = "N_paginas")
    private int npaginas;
    @Basic(optional = false)
    @Lob
    @Column(name = "sinopsis")
    private String sinopsis;
    @Basic(optional = false)
    @Lob
    @Column(name = "valoracion")
    private String valoracion;
    @Basic(optional = false)
    @Column(name = "URLibro")
    private String uRLibro;
    @Basic(optional = false)
    @Column(name = "URLportada")
    private String uRLportada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<BiblioLibro> biblioLibroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<LibroEdit> libroEditCollection;

    public Libro() {
    }

    public Libro(Integer iDlibro) {
        this.iDlibro = iDlibro;
    }

    public Libro(Integer iDlibro, String titulo, String idioma, String genero, Date fechaPubli, String autores, BigDecimal precio, Boolean drm, int npaginas, String sinopsis, String valoracion, String uRLibro, String uRLportada) {
        this.iDlibro = iDlibro;
        this.titulo = titulo;
        this.idioma = idioma;
        this.genero = genero;
        this.fechaPubli = fechaPubli;
        this.autores = autores;
        this.precio = precio;
        this.drm = drm;
        this.npaginas = npaginas;
        this.sinopsis = sinopsis;
        this.valoracion = valoracion;
        this.uRLibro = uRLibro;
        this.uRLportada = uRLportada;
    }

    public Integer getIDlibro() {
        return iDlibro;
    }

    public void setIDlibro(Integer iDlibro) {
        this.iDlibro = iDlibro;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Boolean getDrm() {
        return drm;
    }

    public void setDrm(Boolean drm) {
        this.drm = drm;
    }

    public int getNpaginas() {
        return npaginas;
    }

    public void setNpaginas(int npaginas) {
        this.npaginas = npaginas;
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

    public String getURLibro() {
        return uRLibro;
    }

    public void setURLibro(String uRLibro) {
        this.uRLibro = uRLibro;
    }

    public String getURLportada() {
        return uRLportada;
    }

    public void setURLportada(String uRLportada) {
        this.uRLportada = uRLportada;
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
        hash += (iDlibro != null ? iDlibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.iDlibro == null && other.iDlibro != null) || (this.iDlibro != null && !this.iDlibro.equals(other.iDlibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Pojos.Libro[ iDlibro=" + iDlibro + " ]";
    }

}
