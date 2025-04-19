package com.tutienda.libros.models;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Entity
@Table(name = "editorial")
@NamedQueries({
    @NamedQuery(name = "Editorial.findAll", query = "SELECT e FROM Editorial e"),
    @NamedQuery(name = "Editorial.findByIdEditorial", query = "SELECT e FROM Editorial e WHERE e.idEditorial = :idEditorial"),
    @NamedQuery(name = "Editorial.findByNombre", query = "SELECT e FROM Editorial e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Editorial.findByDireccion", query = "SELECT e FROM Editorial e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Editorial.findByCorreo", query = "SELECT e FROM Editorial e WHERE e.correo = :correo"),
    @NamedQuery(name = "Editorial.findByTelefono", query = "SELECT e FROM Editorial e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Editorial.findByContacto", query = "SELECT e FROM Editorial e WHERE e.contacto = :contacto"),
    @NamedQuery(name = "Editorial.findByWeb", query = "SELECT e FROM Editorial e WHERE e.web = :web")})
public class Editorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_editorial")
    private String idEditorial;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "web")
    private String web;
    @JoinColumn(name = "id_fk_usuario", referencedColumnName = "id_usuario")
    @OneToOne(optional = false)
    private Usuario idFkUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editorial")
    private Collection<LibroEdit> libroEditCollection;

    public Editorial() {
    }

    public Editorial(String idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Editorial(String idEditorial, String nombre, String direccion, String correo, String telefono) {
        this.idEditorial = idEditorial;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(String idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Usuario getIdFkUsuario() {
        return idFkUsuario;
    }

    public void setIdFkUsuario(Usuario idFkUsuario) {
        this.idFkUsuario = idFkUsuario;
    }

    public Collection<LibroEdit> getLibroEditCollection() {
        return libroEditCollection;
    }

    public void setLibroEditCollection(Collection<LibroEdit> libroEditCollection) {
        this.libroEditCollection = libroEditCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEditorial != null ? idEditorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editorial)) {
            return false;
        }
        Editorial other = (Editorial) object;
        if ((this.idEditorial == null && other.idEditorial != null) || (this.idEditorial != null && !this.idEditorial.equals(other.idEditorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tutienda.libros.models.Editorial[ idEditorial=" + idEditorial + " ]";
    }

}
