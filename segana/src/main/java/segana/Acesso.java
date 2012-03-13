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
@Table(name = "acesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acesso.findAll", query = "SELECT a FROM Acesso a"),
    @NamedQuery(name = "Acesso.findByIdacesso", query = "SELECT a FROM Acesso a WHERE a.idacesso = :idacesso")})
public class Acesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idacesso", nullable = false)
    private Integer idacesso;
    @JoinColumn(name = "opcion_idopcion", referencedColumnName = "idopcion", nullable = false)
    @ManyToOne(optional = false)
    private Opcion opcionIdopcion;
    @JoinColumn(name = "rol_idrol", referencedColumnName = "idrol", nullable = false)
    @ManyToOne(optional = false)
    private Rol rolIdrol;

    public Acesso() {
    }

    public Acesso(Integer idacesso) {
        this.idacesso = idacesso;
    }

    public Integer getIdacesso() {
        return idacesso;
    }

    public void setIdacesso(Integer idacesso) {
        this.idacesso = idacesso;
    }

    public Opcion getOpcionIdopcion() {
        return opcionIdopcion;
    }

    public void setOpcionIdopcion(Opcion opcionIdopcion) {
        this.opcionIdopcion = opcionIdopcion;
    }

    public Rol getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(Rol rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacesso != null ? idacesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.idacesso == null && other.idacesso != null) || (this.idacesso != null && !this.idacesso.equals(other.idacesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Acesso[ idacesso=" + idacesso + " ]";
    }
    
}
