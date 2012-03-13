/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segana;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eddy
 */
@Entity
@Table(name = "rolusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rolusuario.findAll", query = "SELECT r FROM Rolusuario r"),
    @NamedQuery(name = "Rolusuario.findByIdrolusuario", query = "SELECT r FROM Rolusuario r WHERE r.idrolusuario = :idrolusuario")})
public class Rolusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrolusuario", nullable = false)
    private Integer idrolusuario;
    @JoinColumn(name = "rol_idrol", referencedColumnName = "idrol", nullable = false)
    @ManyToOne(optional = false)
    private Rol rolIdrol;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;

    public Rolusuario() {
    }

    public Rolusuario(Integer idrolusuario) {
        this.idrolusuario = idrolusuario;
    }

    public Integer getIdrolusuario() {
        return idrolusuario;
    }

    public void setIdrolusuario(Integer idrolusuario) {
        this.idrolusuario = idrolusuario;
    }

    public Rol getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(Rol rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrolusuario != null ? idrolusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolusuario)) {
            return false;
        }
        Rolusuario other = (Rolusuario) object;
        if ((this.idrolusuario == null && other.idrolusuario != null) || (this.idrolusuario != null && !this.idrolusuario.equals(other.idrolusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Rolusuario[ idrolusuario=" + idrolusuario + " ]";
    }
    
}
