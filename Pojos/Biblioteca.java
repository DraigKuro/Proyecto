package com.mycompany.proyecto.Pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Entity
@Table(name = "biblioteca")
@NamedQueries({
    @NamedQuery(name = "Biblioteca.findAll", query = "SELECT b FROM Biblioteca b"),
    @NamedQuery(name = "Biblioteca.findByIDbiblioteca", query = "SELECT b FROM Biblioteca b WHERE b.iDbiblioteca = :iDbiblioteca")})
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_biblioteca")
    private Integer iDbiblioteca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biblioteca")
    private Collection<BiblioLibro> biblioLibroCollection;
    @JoinColumn(name = "ID_FK_usuario", referencedColumnName = "ID_usuario")
    @ManyToOne(optional = false)
    private Usuarios iDFKusuario;

    public Biblioteca() {
    }

    public Biblioteca(Integer iDbiblioteca) {
        this.iDbiblioteca = iDbiblioteca;
    }

    public Integer getIDbiblioteca() {
        return iDbiblioteca;
    }

    public void setIDbiblioteca(Integer iDbiblioteca) {
        this.iDbiblioteca = iDbiblioteca;
    }

    public Collection<BiblioLibro> getBiblioLibroCollection() {
        return biblioLibroCollection;
    }

    public void setBiblioLibroCollection(Collection<BiblioLibro> biblioLibroCollection) {
        this.biblioLibroCollection = biblioLibroCollection;
    }

    public Usuarios getIDFKusuario() {
        return iDFKusuario;
    }

    public void setIDFKusuario(Usuarios iDFKusuario) {
        this.iDFKusuario = iDFKusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDbiblioteca != null ? iDbiblioteca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biblioteca)) {
            return false;
        }
        Biblioteca other = (Biblioteca) object;
        if ((this.iDbiblioteca == null && other.iDbiblioteca != null) || (this.iDbiblioteca != null && !this.iDbiblioteca.equals(other.iDbiblioteca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Pojos.Biblioteca[ iDbiblioteca=" + iDbiblioteca + " ]";
    }

}
