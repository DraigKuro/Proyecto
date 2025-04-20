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
public class DeseadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_fk_usuario")
    private int idFkUsuario;
    @Basic(optional = false)
    @Column(name = "id_fk_libro")
    private String idFkLibro;

    public DeseadoPK() {
    }

    public DeseadoPK(int idFkUsuario, String idFkLibro) {
        this.idFkUsuario = idFkUsuario;
        this.idFkLibro = idFkLibro;
    }

    public int getIdFkUsuario() {
        return idFkUsuario;
    }

    public void setIdFkUsuario(int idFkUsuario) {
        this.idFkUsuario = idFkUsuario;
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
        hash += (int) idFkUsuario;
        hash += (idFkLibro != null ? idFkLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeseadoPK)) {
            return false;
        }
        DeseadoPK other = (DeseadoPK) object;
        if (this.idFkUsuario != other.idFkUsuario) {
            return false;
        }
        if ((this.idFkLibro == null && other.idFkLibro != null) || (this.idFkLibro != null && !this.idFkLibro.equals(other.idFkLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.api.models.DeseadoPK[ idFkUsuario=" + idFkUsuario + ", idFkLibro=" + idFkLibro + " ]";
    }

}
