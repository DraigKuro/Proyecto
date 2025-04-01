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
    @Column(name = "id_fk_biblioteca")
    private int idFkBiblioteca;
    @Basic(optional = false)
    @Column(name = "id_fk_libro")
    private int idFkLibro;

    public BiblioLibroPK() {
    }

    public BiblioLibroPK(int idFkBiblioteca, int idFkLibro) {
        this.idFkBiblioteca = idFkBiblioteca;
        this.idFkLibro = idFkLibro;
    }

    public int getIdFkBiblioteca() {
        return idFkBiblioteca;
    }

    public void setIdFkBiblioteca(int idFkBiblioteca) {
        this.idFkBiblioteca = idFkBiblioteca;
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
        hash += (int) idFkBiblioteca;
        hash += (int) idFkLibro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BiblioLibroPK)) {
            return false;
        }
        BiblioLibroPK other = (BiblioLibroPK) object;
        if (this.idFkBiblioteca != other.idFkBiblioteca) {
            return false;
        }
        if (this.idFkLibro != other.idFkLibro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Pojos.BiblioLibroPK[ idFkBiblioteca=" + idFkBiblioteca + ", idFkLibro=" + idFkLibro + " ]";
    }

}
