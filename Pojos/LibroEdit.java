package com.mycompany.proyecto.Pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Entity
@Table(name = "libro_edit")
@NamedQueries({
    @NamedQuery(name = "LibroEdit.findAll", query = "SELECT l FROM LibroEdit l"),
    @NamedQuery(name = "LibroEdit.findByIDFKeditorial", query = "SELECT l FROM LibroEdit l WHERE l.libroEditPK.iDFKeditorial = :iDFKeditorial"),
    @NamedQuery(name = "LibroEdit.findByIDFKlibro", query = "SELECT l FROM LibroEdit l WHERE l.libroEditPK.iDFKlibro = :iDFKlibro"),
    @NamedQuery(name = "LibroEdit.findByFechaAlta", query = "SELECT l FROM LibroEdit l WHERE l.fechaAlta = :fechaAlta")})
public class LibroEdit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LibroEditPK libroEditPK;
    @Basic(optional = false)
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @JoinColumn(name = "ID_FK_editorial", referencedColumnName = "ID_editorial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Editorial editorial;
    @JoinColumn(name = "ID_FK_libro", referencedColumnName = "ID_libro", insertable = false, updatable = false)
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

    public LibroEdit(int iDFKeditorial, int iDFKlibro) {
        this.libroEditPK = new LibroEditPK(iDFKeditorial, iDFKlibro);
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
        return "com.mycompany.proyecto.Pojos.LibroEdit[ libroEditPK=" + libroEditPK + " ]";
    }

}
