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
import java.util.Date;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Entity
@Table(name = "libro_edit")
@NamedQueries({
    @NamedQuery(name = "LibroEdit.findAll", query = "SELECT l FROM LibroEdit l"),
    @NamedQuery(name = "LibroEdit.findByIdFkEditorial", query = "SELECT l FROM LibroEdit l WHERE l.libroEditPK.idFkEditorial = :idFkEditorial"),
    @NamedQuery(name = "LibroEdit.findByIdFkLibro", query = "SELECT l FROM LibroEdit l WHERE l.libroEditPK.idFkLibro = :idFkLibro"),
    @NamedQuery(name = "LibroEdit.findByFechaAlta", query = "SELECT l FROM LibroEdit l WHERE l.fechaAlta = :fechaAlta")})
public class LibroEdit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LibroEditPK libroEditPK;
    @Basic(optional = false)
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @JoinColumn(name = "id_fk_editorial", referencedColumnName = "id_editorial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Editorial editorial;
    @JoinColumn(name = "id_fk_libro", referencedColumnName = "id_libro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libro libro;

    public LibroEdit() {
    }

    public LibroEdit(LibroEditPK libroEditPK) {
        this.libroEditPK = libroEditPK;
    }

    public LibroEdit(LibroEditPK libroEditPK, Date fechaAlta) {
        this.libroEditPK = libroEditPK;
        this.fechaAlta = fechaAlta;
    }

    public LibroEdit(String idFkEditorial, String idFkLibro) {
        this.libroEditPK = new LibroEditPK(idFkEditorial, idFkLibro);
    }

    public LibroEditPK getLibroEditPK() {
        return libroEditPK;
    }

    public void setLibroEditPK(LibroEditPK libroEditPK) {
        this.libroEditPK = libroEditPK;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
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
        hash += (libroEditPK != null ? libroEditPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroEdit)) {
            return false;
        }
        LibroEdit other = (LibroEdit) object;
        if ((this.libroEditPK == null && other.libroEditPK != null) || (this.libroEditPK != null && !this.libroEditPK.equals(other.libroEditPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.models.LibroEdit[ libroEditPK=" + libroEditPK + " ]";
    }

}
