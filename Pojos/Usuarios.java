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
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIDusuario", query = "SELECT u FROM Usuarios u WHERE u.iDusuario = :iDusuario"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.findByPass", query = "SELECT u FROM Usuarios u WHERE u.pass = :pass")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_usuario")
    private Integer iDusuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "pass")
    private String pass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDFKusuario")
    private Collection<Biblioteca> bibliotecaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDFKusuario")
    private Collection<Info> infoCollection;

    public Usuarios() {
    }

    public Usuarios(Integer iDusuario) {
        this.iDusuario = iDusuario;
    }

    public Usuarios(Integer iDusuario, String nombre, String apellidos, String usuario, String pass) {
        this.iDusuario = iDusuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.pass = pass;
    }

    public Integer getIDusuario() {
        return iDusuario;
    }

    public void setIDusuario(Integer iDusuario) {
        this.iDusuario = iDusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Collection<Biblioteca> getBibliotecaCollection() {
        return bibliotecaCollection;
    }

    public void setBibliotecaCollection(Collection<Biblioteca> bibliotecaCollection) {
        this.bibliotecaCollection = bibliotecaCollection;
    }

    public Collection<Info> getInfoCollection() {
        return infoCollection;
    }

    public void setInfoCollection(Collection<Info> infoCollection) {
        this.infoCollection = infoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDusuario != null ? iDusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.iDusuario == null && other.iDusuario != null) || (this.iDusuario != null && !this.iDusuario.equals(other.iDusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Pojos.Usuarios[ iDusuario=" + iDusuario + " ]";
    }

}
