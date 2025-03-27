package com.mycompany.proyecto.Pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Andia Rosales Alexis damt208
 */
@Entity
@Table(name = "info")
@NamedQueries({
    @NamedQuery(name = "Info.findAll", query = "SELECT i FROM Info i"),
    @NamedQuery(name = "Info.findByIDinfo", query = "SELECT i FROM Info i WHERE i.iDinfo = :iDinfo"),
    @NamedQuery(name = "Info.findBySalt", query = "SELECT i FROM Info i WHERE i.salt = :salt")})
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_info")
    private Integer iDinfo;
    @Basic(optional = false)
    @Column(name = "salt")
    private String salt;
    @JoinColumn(name = "ID_FK_usuario", referencedColumnName = "ID_usuario")
    @ManyToOne(optional = false)
    private Usuarios iDFKusuario;

    public Info() {
    }

    public Info(Integer iDinfo) {
        this.iDinfo = iDinfo;
    }

    public Info(Integer iDinfo, String salt) {
        this.iDinfo = iDinfo;
        this.salt = salt;
    }

    public Integer getIDinfo() {
        return iDinfo;
    }

    public void setIDinfo(Integer iDinfo) {
        this.iDinfo = iDinfo;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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
        hash += (iDinfo != null ? iDinfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Info)) {
            return false;
        }
        Info other = (Info) object;
        if ((this.iDinfo == null && other.iDinfo != null) || (this.iDinfo != null && !this.iDinfo.equals(other.iDinfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Pojos.Info[ iDinfo=" + iDinfo + " ]";
    }

}
