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
    @NamedQuery(name = "Biblioteca.findByIdBiblioteca", query = "SELECT b FROM Biblioteca b WHERE b.idBiblioteca = :idBiblioteca"),
    @NamedQuery(name = "Biblioteca.findByCantidadLibros", query = "SELECT b FROM Biblioteca b WHERE b.cantidadLibros = :cantidadLibros")})
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_biblioteca")
    private Integer idBiblioteca;
    @Basic(optional = false)
    @Column(name = "cantidad_libros")
    private int cantidadLibros;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biblioteca")
    private Collection<BiblioLibro> biblioLibroCollection;
    @JoinColumn(name = "id_fk_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idFkUsuario;

    public Biblioteca() {
    }

    public Biblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public Biblioteca(Integer idBiblioteca, int cantidadLibros) {
        this.idBiblioteca = idBiblioteca;
        this.cantidadLibros = cantidadLibros;
    }

    public Integer getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    public Collection<BiblioLibro> getBiblioLibroCollection() {
        return biblioLibroCollection;
    }

    public void setBiblioLibroCollection(Collection<BiblioLibro> biblioLibroCollection) {
        this.biblioLibroCollection = biblioLibroCollection;
    }

    public Usuarios getIdFkUsuario() {
        return idFkUsuario;
    }

    public void setIdFkUsuario(Usuarios idFkUsuario) {
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
        return "com.mycompany.proyecto.Pojos.Biblioteca[ idBiblioteca=" + idBiblioteca + " ]";
    }

}
