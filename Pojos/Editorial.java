package com.mycompany.proyecto.Pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    @NamedQuery(name = "Editorial.findByNif", query = "SELECT e FROM Editorial e WHERE e.nif = :nif"),
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
    private Integer idEditorial;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "nif")
    private String nif;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "web")
    private String web;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editorial")
    private Collection<LibroEdit> libroEditCollection;

    public Editorial() {
    }

    public Editorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Editorial(Integer idEditorial, String nombre, String nif, String direccion, String correo, int telefono) {
        this.idEditorial = idEditorial;
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
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
        return "com.mycompany.proyecto.Pojos.Editorial[ idEditorial=" + idEditorial + " ]";
    }

}
