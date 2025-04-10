package com.tutienda.libros.models;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

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
    @NamedQuery(name = "Libro.findByFechaPubli", query = "SELECT l FROM Libro l WHERE l.fechaPubli = :fechaPubli"),
    @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio"),
    @NamedQuery(name = "Libro.findByDescuento", query = "SELECT l FROM Libro l WHERE l.descuento = :descuento"),
    @NamedQuery(name = "Libro.findByDrm", query = "SELECT l FROM Libro l WHERE l.drm = :drm"),
    @NamedQuery(name = "Libro.findByNPaginas", query = "SELECT l FROM Libro l WHERE l.nPaginas = :nPaginas"),
    @NamedQuery(name = "Libro.findBySinopsis", query = "SELECT l FROM Libro l WHERE l.sinopsis = :sinopsis"),
    @NamedQuery(name = "Libro.findByNVotos", query = "SELECT l FROM Libro l WHERE l.nVotos = :nVotos"),
    @NamedQuery(name = "Libro.findByValoracion", query = "SELECT l FROM Libro l WHERE l.valoracion = :valoracion"),
    @NamedQuery(name = "Libro.findByUrlibro", query = "SELECT l FROM Libro l WHERE l.urlibro = :urlibro"),
    @NamedQuery(name = "Libro.findByUrlportada", query = "SELECT l FROM Libro l WHERE l.urlportada = :urlportada")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_libro")
    private String idLibro;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "fecha_publi")
    @Temporal(TemporalType.DATE)
    private Date fechaPubli;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "descuento")
    private Short descuento;
    @Basic(optional = false)
    @Column(name = "drm")
    private boolean drm;
    @Basic(optional = false)
    @Column(name = "n_paginas")
    private int nPaginas;
    @Column(name = "sinopsis")
    private String sinopsis;
    @Column(name = "n_votos")
    private Integer nVotos;
    @Column(name = "valoracion")
    private Short valoracion;
    @Basic(optional = false)
    @Column(name = "urlibro")
    private String urlibro;
    @Basic(optional = false)
    @Column(name = "urlportada")
    private String urlportada;
    @ManyToMany(mappedBy = "libroCollection")
    private Collection<Genero> generoCollection;
    @ManyToMany(mappedBy = "libroCollection")
    private Collection<Idioma> idiomaCollection;
    @JoinColumn(name = "id_fk_saga", referencedColumnName = "id_saga")
    @ManyToOne
    private Saga idFkSaga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<BiblioLibro> biblioLibroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<Deseado> deseadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<LibroAutor> libroAutorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<LibroEdit> libroEditCollection;

    public Libro() {
    }

    public Libro(String idLibro) {
        this.idLibro = idLibro;
    }

    public Libro(String idLibro, String titulo, Date fechaPubli, BigDecimal precio, boolean drm, int nPaginas, String urlibro, String urlportada) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.fechaPubli = fechaPubli;
        this.precio = precio;
        this.drm = drm;
        this.nPaginas = nPaginas;
        this.urlibro = urlibro;
        this.urlportada = urlportada;
    }

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

    public Integer getNVotos() {
        return nVotos;
    }

    public void setNVotos(Integer nVotos) {
        this.nVotos = nVotos;
    }

    public Short getValoracion() {
        return valoracion;
    }

    public void setValoracion(Short valoracion) {
        this.valoracion = valoracion;
    }

    public String getUrlibro() {
        return urlibro;
    }

    public void setUrlibro(String urlibro) {
        this.urlibro = urlibro;
    }

    public String getUrlportada() {
        return urlportada;
    }

    public void setUrlportada(String urlportada) {
        this.urlportada = urlportada;
    }

    public Collection<Genero> getGeneroCollection() {
        return generoCollection;
    }

    public void setGeneroCollection(Collection<Genero> generoCollection) {
        this.generoCollection = generoCollection;
    }

    public Collection<Idioma> getIdiomaCollection() {
        return idiomaCollection;
    }

    public void setIdiomaCollection(Collection<Idioma> idiomaCollection) {
        this.idiomaCollection = idiomaCollection;
    }

    public Saga getIdFkSaga() {
        return idFkSaga;
    }

    public void setIdFkSaga(Saga idFkSaga) {
        this.idFkSaga = idFkSaga;
    }

    public Collection<BiblioLibro> getBiblioLibroCollection() {
        return biblioLibroCollection;
    }

    public void setBiblioLibroCollection(Collection<BiblioLibro> biblioLibroCollection) {
        this.biblioLibroCollection = biblioLibroCollection;
    }

    public Collection<Deseado> getDeseadoCollection() {
        return deseadoCollection;
    }

    public void setDeseadoCollection(Collection<Deseado> deseadoCollection) {
        this.deseadoCollection = deseadoCollection;
    }

    public Collection<LibroAutor> getLibroAutorCollection() {
        return libroAutorCollection;
    }

    public void setLibroAutorCollection(Collection<LibroAutor> libroAutorCollection) {
        this.libroAutorCollection = libroAutorCollection;
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
        return "com.tutienda.libros.models.Libro[ idLibro=" + idLibro + " ]";
    }

}
