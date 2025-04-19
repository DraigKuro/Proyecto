package com.tutienda.libros.api.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Embeddable
public class LibroEditPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_fk_editorial")
    private String idFkEditorial;
    @Basic(optional = false)
    @Column(name = "id_fk_libro")
    private String idFkLibro;

    public LibroEditPK() {
    }

    public LibroEditPK(String idFkEditorial, String idFkLibro) {
        this.idFkEditorial = idFkEditorial;
        this.idFkLibro = idFkLibro;
    }

    public String getIdFkEditorial() {
        return idFkEditorial;
    }

    public void setIdFkEditorial(String idFkEditorial) {
        this.idFkEditorial = idFkEditorial;
    }

    public String getIdFkLibro() {
        return idFkLibro;
    }

    public void setIdFkLibro(String idFkLibro) {
        this.idFkLibro = idFkLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFkEditorial != null ? idFkEditorial.hashCode() : 0);
        hash += (idFkLibro != null ? idFkLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroEditPK)) {
            return false;
        }
        LibroEditPK other = (LibroEditPK) object;
        if ((this.idFkEditorial == null && other.idFkEditorial != null) || (this.idFkEditorial != null && !this.idFkEditorial.equals(other.idFkEditorial))) {
            return false;
        }
        if ((this.idFkLibro == null && other.idFkLibro != null) || (this.idFkLibro != null && !this.idFkLibro.equals(other.idFkLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.models.LibroEditPK[ idFkEditorial=" + idFkEditorial + ", idFkLibro=" + idFkLibro + " ]";
    }

}
