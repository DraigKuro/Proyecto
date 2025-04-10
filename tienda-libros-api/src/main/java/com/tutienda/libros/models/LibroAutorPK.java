package com.tutienda.libros.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Embeddable
public class LibroAutorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_fk_libro")
    private String idFkLibro;
    @Basic(optional = false)
    @Column(name = "id_fk_autor")
    private int idFkAutor;

    public LibroAutorPK() {
    }

    public LibroAutorPK(String idFkLibro, int idFkAutor) {
        this.idFkLibro = idFkLibro;
        this.idFkAutor = idFkAutor;
    }

    public String getIdFkLibro() {
        return idFkLibro;
    }

    public void setIdFkLibro(String idFkLibro) {
        this.idFkLibro = idFkLibro;
    }

    public int getIdFkAutor() {
        return idFkAutor;
    }

    public void setIdFkAutor(int idFkAutor) {
        this.idFkAutor = idFkAutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFkLibro != null ? idFkLibro.hashCode() : 0);
        hash += (int) idFkAutor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroAutorPK)) {
            return false;
        }
        LibroAutorPK other = (LibroAutorPK) object;
        if ((this.idFkLibro == null && other.idFkLibro != null) || (this.idFkLibro != null && !this.idFkLibro.equals(other.idFkLibro))) {
            return false;
        }
        if (this.idFkAutor != other.idFkAutor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.models.LibroAutorPK[ idFkLibro=" + idFkLibro + ", idFkAutor=" + idFkAutor + " ]";
    }

}
