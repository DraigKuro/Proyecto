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
public class BiblioLibroPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_fk_biblioteca")
    private int idFkBiblioteca;
    @Basic(optional = false)
    @Column(name = "id_fk_libro")
    private String idFkLibro;

    public BiblioLibroPK() {
    }

    public BiblioLibroPK(int idFkBiblioteca, String idFkLibro) {
        this.idFkBiblioteca = idFkBiblioteca;
        this.idFkLibro = idFkLibro;
    }

    public int getIdFkBiblioteca() {
        return idFkBiblioteca;
    }

    public void setIdFkBiblioteca(int idFkBiblioteca) {
        this.idFkBiblioteca = idFkBiblioteca;
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
        hash += (int) idFkBiblioteca;
        hash += (idFkLibro != null ? idFkLibro.hashCode() : 0);
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
        if ((this.idFkLibro == null && other.idFkLibro != null) || (this.idFkLibro != null && !this.idFkLibro.equals(other.idFkLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.models.BiblioLibroPK[ idFkBiblioteca=" + idFkBiblioteca + ", idFkLibro=" + idFkLibro + " ]";
    }

}
