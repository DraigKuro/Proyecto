package com.tutienda.libros.api.models;

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
@Table(name = "deseado")
@NamedQueries({
    @NamedQuery(name = "Deseado.findAll", query = "SELECT d FROM Deseado d"),
    @NamedQuery(name = "Deseado.findByIdFkUsuario", query = "SELECT d FROM Deseado d WHERE d.deseadoPK.idFkUsuario = :idFkUsuario"),
    @NamedQuery(name = "Deseado.findByIdFkLibro", query = "SELECT d FROM Deseado d WHERE d.deseadoPK.idFkLibro = :idFkLibro"),
    @NamedQuery(name = "Deseado.findByFechaRegistro", query = "SELECT d FROM Deseado d WHERE d.fechaRegistro = :fechaRegistro")})
public class Deseado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeseadoPK deseadoPK;
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @JoinColumn(name = "id_fk_libro", referencedColumnName = "id_libro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libro libro;
    @JoinColumn(name = "id_fk_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Deseado() {
    }

    public Deseado(DeseadoPK deseadoPK) {
        this.deseadoPK = deseadoPK;
    }

    public Deseado(DeseadoPK deseadoPK, Date fechaRegistro) {
        this.deseadoPK = deseadoPK;
        this.fechaRegistro = fechaRegistro;
    }

    public Deseado(int idFkUsuario, String idFkLibro) {
        this.deseadoPK = new DeseadoPK(idFkUsuario, idFkLibro);
    }

    public DeseadoPK getDeseadoPK() {
        return deseadoPK;
    }

    public void setDeseadoPK(DeseadoPK deseadoPK) {
        this.deseadoPK = deseadoPK;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deseadoPK != null ? deseadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deseado)) {
            return false;
        }
        Deseado other = (Deseado) object;
        if ((this.deseadoPK == null && other.deseadoPK != null) || (this.deseadoPK != null && !this.deseadoPK.equals(other.deseadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.api.models.Deseado[ deseadoPK=" + deseadoPK + " ]";
    }

}
