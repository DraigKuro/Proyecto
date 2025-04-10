package com.tutienda.libros.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Entity
@Table(name = "biblio_libro")
@NamedQueries({
    @NamedQuery(name = "BiblioLibro.findAll", query = "SELECT b FROM BiblioLibro b"),
    @NamedQuery(name = "BiblioLibro.findByIdFkBiblioteca", query = "SELECT b FROM BiblioLibro b WHERE b.biblioLibroPK.idFkBiblioteca = :idFkBiblioteca"),
    @NamedQuery(name = "BiblioLibro.findByIdFkLibro", query = "SELECT b FROM BiblioLibro b WHERE b.biblioLibroPK.idFkLibro = :idFkLibro"),
    @NamedQuery(name = "BiblioLibro.findByFechaCompra", query = "SELECT b FROM BiblioLibro b WHERE b.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "BiblioLibro.findByPrecio", query = "SELECT b FROM BiblioLibro b WHERE b.precio = :precio")})
public class BiblioLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BiblioLibroPK biblioLibroPK;
    @Basic(optional = false)
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @JoinColumn(name = "id_fk_biblioteca", referencedColumnName = "id_biblioteca", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Biblioteca biblioteca;
    @JoinColumn(name = "id_fk_libro", referencedColumnName = "id_libro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libro libro;

    public BiblioLibro() {
    }

    public BiblioLibro(BiblioLibroPK biblioLibroPK) {
        this.biblioLibroPK = biblioLibroPK;
    }

    public BiblioLibro(BiblioLibroPK biblioLibroPK, Date fechaCompra, BigDecimal precio) {
        this.biblioLibroPK = biblioLibroPK;
        this.fechaCompra = fechaCompra;
        this.precio = precio;
    }

    public BiblioLibro(int idFkBiblioteca, String idFkLibro) {
        this.biblioLibroPK = new BiblioLibroPK(idFkBiblioteca, idFkLibro);
    }

    public BiblioLibroPK getBiblioLibroPK() {
        return biblioLibroPK;
    }

    public void setBiblioLibroPK(BiblioLibroPK biblioLibroPK) {
        this.biblioLibroPK = biblioLibroPK;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biblioLibroPK != null ? biblioLibroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BiblioLibro)) {
            return false;
        }
        BiblioLibro other = (BiblioLibro) object;
        if ((this.biblioLibroPK == null && other.biblioLibroPK != null) || (this.biblioLibroPK != null && !this.biblioLibroPK.equals(other.biblioLibroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.models.BiblioLibro[ biblioLibroPK=" + biblioLibroPK + " ]";
    }

}
