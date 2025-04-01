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
    @NamedQuery(name = "Info.findByIdInfo", query = "SELECT i FROM Info i WHERE i.idInfo = :idInfo"),
    @NamedQuery(name = "Info.findBySalt", query = "SELECT i FROM Info i WHERE i.salt = :salt"),
    @NamedQuery(name = "Info.findByCartera", query = "SELECT i FROM Info i WHERE i.cartera = :cartera")})
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_info")
    private Integer idInfo;
    @Basic(optional = false)
    @Column(name = "salt")
    private String salt;
    @Basic(optional = false)
    @Column(name = "cartera")
    private double cartera;
    @JoinColumn(name = "id_fk_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idFkUsuario;

    public Info() {
    }

    public Info(Integer idInfo) {
        this.idInfo = idInfo;
    }

    public Info(Integer idInfo, String salt, double cartera) {
        this.idInfo = idInfo;
        this.salt = salt;
        this.cartera = cartera;
    }

    public Integer getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(Integer idInfo) {
        this.idInfo = idInfo;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public double getCartera() {
        return cartera;
    }

    public void setCartera(double cartera) {
        this.cartera = cartera;
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
        hash += (idInfo != null ? idInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Info)) {
            return false;
        }
        Info other = (Info) object;
        if ((this.idInfo == null && other.idInfo != null) || (this.idInfo != null && !this.idInfo.equals(other.idInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Pojos.Info[ idInfo=" + idInfo + " ]";
    }

}
