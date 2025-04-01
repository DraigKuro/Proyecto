package com.mycompany.proyecto.Pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Embeddable
public class LibroEditPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_fk_editorial")
    private int idFkEditorial;
    @Basic(optional = false)
    @Column(name = "id_fk_libro")
    private int idFkLibro;

    public LibroEditPK() {
    }

    public LibroEditPK(int idFkEditorial, int idFkLibro) {
        this.idFkEditorial = idFkEditorial;
        this.idFkLibro = idFkLibro;
    }

    public int getIdFkEditorial() {
        return idFkEditorial;
    }

    public void setIdFkEditorial(int idFkEditorial) {
        this.idFkEditorial = idFkEditorial;
    }

    public int getIdFkLibro() {
        return idFkLibro;
    }

    public void setIdFkLibro(int idFkLibro) {
        this.idFkLibro = idFkLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFkEditorial;
        hash += (int) idFkLibro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroEditPK)) {
            return false;
        }
        LibroEditPK other = (LibroEditPK) object;
        if (this.idFkEditorial != other.idFkEditorial) {
            return false;
        }
        if (this.idFkLibro != other.idFkLibro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Pojos.LibroEditPK[ idFkEditorial=" + idFkEditorial + ", idFkLibro=" + idFkLibro + " ]";
    }

}
