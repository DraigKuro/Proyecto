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
public class BiblioLibroPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_FK_biblioteca")
    private int iDFKbiblioteca;
    @Basic(optional = false)
    @Column(name = "ID_FK_libro")
    private int iDFKlibro;

    public BiblioLibroPK() {
    }

    public BiblioLibroPK(int iDFKbiblioteca, int iDFKlibro) {
        this.iDFKbiblioteca = iDFKbiblioteca;
        this.iDFKlibro = iDFKlibro;
    }

    public int getIDFKbiblioteca() {
        return iDFKbiblioteca;
    }

    public void setIDFKbiblioteca(int iDFKbiblioteca) {
        this.iDFKbiblioteca = iDFKbiblioteca;
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
        hash += (int) iDFKbiblioteca;
        hash += (int) iDFKlibro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BiblioLibroPK)) {
            return false;
        }
        BiblioLibroPK other = (BiblioLibroPK) object;
        if (this.iDFKbiblioteca != other.iDFKbiblioteca) {
            return false;
        }
        if (this.iDFKlibro != other.iDFKlibro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Pojos.BiblioLibroPK[ iDFKbiblioteca=" + iDFKbiblioteca + ", iDFKlibro=" + iDFKlibro + " ]";
    }

}
