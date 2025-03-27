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
    @Column(name = "ID_FK_editorial")
    private int iDFKeditorial;
    @Basic(optional = false)
    @Column(name = "ID_FK_libro")
    private int iDFKlibro;

    public LibroEditPK() {
    }

    public LibroEditPK(int iDFKeditorial, int iDFKlibro) {
        this.iDFKeditorial = iDFKeditorial;
        this.iDFKlibro = iDFKlibro;
    }

    public int getIDFKeditorial() {
        return iDFKeditorial;
    }

    public void setIDFKeditorial(int iDFKeditorial) {
        this.iDFKeditorial = iDFKeditorial;
    }

    public int getIDFKlibro() {
        return iDFKlibro;
    }

    public void setIDFKlibro(int iDFKlibro) {
        this.iDFKlibro = iDFKlibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDFKeditorial;
        hash += (int) iDFKlibro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroEditPK)) {
            return false;
        }
        LibroEditPK other = (LibroEditPK) object;
        if (this.iDFKeditorial != other.iDFKeditorial) {
            return false;
        }
        if (this.iDFKlibro != other.iDFKlibro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Pojos.LibroEditPK[ iDFKeditorial=" + iDFKeditorial + ", iDFKlibro=" + iDFKlibro + " ]";
    }

}
