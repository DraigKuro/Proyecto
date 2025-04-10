package com.tutienda.libros.models;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Entity
@Table(name = "biblioteca")
@NamedQueries({
    @NamedQuery(name = "Biblioteca.findAll", query = "SELECT b FROM Biblioteca b"),
    @NamedQuery(name = "Biblioteca.findByIdBiblioteca", query = "SELECT b FROM Biblioteca b WHERE b.idBiblioteca = :idBiblioteca"),
    @NamedQuery(name = "Biblioteca.findByUltimoRegistro", query = "SELECT b FROM Biblioteca b WHERE b.ultimoRegistro = :ultimoRegistro")})
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_biblioteca")
    private Integer idBiblioteca;
    @Column(name = "ultimo_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biblioteca")
    private Collection<BiblioLibro> biblioLibroCollection;
    @JoinColumn(name = "id_fk_usuario", referencedColumnName = "id_usuario")
    @OneToOne(optional = false)
    private Usuario idFkUsuario;

    public Biblioteca() {
    }

    public Biblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public Integer getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public Date getUltimoRegistro() {
        return ultimoRegistro;
    }

    public void setUltimoRegistro(Date ultimoRegistro) {
        this.ultimoRegistro = ultimoRegistro;
    }

    public Collection<BiblioLibro> getBiblioLibroCollection() {
        return biblioLibroCollection;
    }

    public void setBiblioLibroCollection(Collection<BiblioLibro> biblioLibroCollection) {
        this.biblioLibroCollection = biblioLibroCollection;
    }

    public Usuario getIdFkUsuario() {
        return idFkUsuario;
    }

    public void setIdFkUsuario(Usuario idFkUsuario) {
        this.idFkUsuario = idFkUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBiblioteca != null ? idBiblioteca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biblioteca)) {
            return false;
        }
        Biblioteca other = (Biblioteca) object;
        if ((this.idBiblioteca == null && other.idBiblioteca != null) || (this.idBiblioteca != null && !this.idBiblioteca.equals(other.idBiblioteca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.models.Biblioteca[ idBiblioteca=" + idBiblioteca + " ]";
    }

}
