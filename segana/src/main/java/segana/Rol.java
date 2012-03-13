/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segana;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eddy
 */
@Entity
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByIdrol", query = "SELECT r FROM Rol r WHERE r.idrol = :idrol"),
    @NamedQuery(name = "Rol.findByDescripcion", query = "SELECT r FROM Rol r WHERE r.descripcion = :descripcion")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrol", nullable = false)
    private Integer idrol;
    @Size(max = 45)
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolIdrol")
    private Collection<Acesso> acessoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolIdrol")
    private Collection<Rolusuario> rolusuarioCollection;

    public Rol() {
    }

    public Rol(Integer idrol) {
        this.idrol = idrol;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Acesso> getAcessoCollection() {
        return acessoCollection;
    }

    public void setAcessoCollection(Collection<Acesso> acessoCollection) {
        this.acessoCollection = acessoCollection;
    }

    @XmlTransient
    public Collection<Rolusuario> getRolusuarioCollection() {
        return rolusuarioCollection;
    }

    public void setRolusuarioCollection(Collection<Rolusuario> rolusuarioCollection) {
        this.rolusuarioCollection = rolusuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Rol[ idrol=" + idrol + " ]";
    }
    
}
