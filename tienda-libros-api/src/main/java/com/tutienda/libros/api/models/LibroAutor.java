package com.tutienda.libros.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Entity
@Table(name = "libro_autor")
@NamedQueries({
    @NamedQuery(name = "LibroAutor.findAll", query = "SELECT l FROM LibroAutor l"),
    @NamedQuery(name = "LibroAutor.findByIdFkLibro", query = "SELECT l FROM LibroAutor l WHERE l.libroAutorPK.idFkLibro = :idFkLibro"),
    @NamedQuery(name = "LibroAutor.findByIdFkAutor", query = "SELECT l FROM LibroAutor l WHERE l.libroAutorPK.idFkAutor = :idFkAutor"),
    @NamedQuery(name = "LibroAutor.findByOrdenAutor", query = "SELECT l FROM LibroAutor l WHERE l.ordenAutor = :ordenAutor")})
public class LibroAutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LibroAutorPK libroAutorPK;
    @Column(name = "orden_autor")
    private Short ordenAutor;
    @JoinColumn(name = "id_fk_autor", referencedColumnName = "id_autor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autor autor;
    @JoinColumn(name = "id_fk_libro", referencedColumnName = "id_libro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libro libro;

    public LibroAutor() {
    }

    public LibroAutor(LibroAutorPK libroAutorPK) {
        this.libroAutorPK = libroAutorPK;
    }

    public LibroAutor(String idFkLibro, int idFkAutor) {
        this.libroAutorPK = new LibroAutorPK(idFkLibro, idFkAutor);
    }

    public LibroAutorPK getLibroAutorPK() {
        return libroAutorPK;
    }

    public void setLibroAutorPK(LibroAutorPK libroAutorPK) {
        this.libroAutorPK = libroAutorPK;
    }

    public Short getOrdenAutor() {
        return ordenAutor;
    }

    public void setOrdenAutor(Short ordenAutor) {
        this.ordenAutor = ordenAutor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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
        hash += (libroAutorPK != null ? libroAutorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroAutor)) {
            return false;
        }
        LibroAutor other = (LibroAutor) object;
        if ((this.libroAutorPK == null && other.libroAutorPK != null) || (this.libroAutorPK != null && !this.libroAutorPK.equals(other.libroAutorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.models.LibroAutor[ libroAutorPK=" + libroAutorPK + " ]";
    }

}
