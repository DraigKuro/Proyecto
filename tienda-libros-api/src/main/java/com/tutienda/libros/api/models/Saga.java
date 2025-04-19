package com.tutienda.libros.api.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Entity
@Table(name = "saga")
@NamedQueries({
    @NamedQuery(name = "Saga.findAll", query = "SELECT s FROM Saga s"),
    @NamedQuery(name = "Saga.findByIdSaga", query = "SELECT s FROM Saga s WHERE s.idSaga = :idSaga"),
    @NamedQuery(name = "Saga.findByNombreSaga", query = "SELECT s FROM Saga s WHERE s.nombreSaga = :nombreSaga")})
public class Saga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_saga")
    private Integer idSaga;
    @Basic(optional = false)
    @Column(name = "nombre_saga")
    private String nombreSaga;
    @OneToMany(mappedBy = "idFkSaga")
    private Collection<Libro> libroCollection;

    public Saga() {
    }

    public Saga(Integer idSaga) {
        this.idSaga = idSaga;
    }

    public Saga(Integer idSaga, String nombreSaga) {
        this.idSaga = idSaga;
        this.nombreSaga = nombreSaga;
    }

    public Integer getIdSaga() {
        return idSaga;
    }

    public void setIdSaga(Integer idSaga) {
        this.idSaga = idSaga;
    }

    public String getNombreSaga() {
        return nombreSaga;
    }

    public void setNombreSaga(String nombreSaga) {
        this.nombreSaga = nombreSaga;
    }

    public Collection<Libro> getLibroCollection() {
        return libroCollection;
    }

    public void setLibroCollection(Collection<Libro> libroCollection) {
        this.libroCollection = libroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSaga != null ? idSaga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saga)) {
            return false;
        }
        Saga other = (Saga) object;
        if ((this.idSaga == null && other.idSaga != null) || (this.idSaga != null && !this.idSaga.equals(other.idSaga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.models.Saga[ idSaga=" + idSaga + " ]";
    }

}
