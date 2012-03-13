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
@Table(name = "modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByIdmodulo", query = "SELECT m FROM Modulo m WHERE m.idmodulo = :idmodulo"),
    @NamedQuery(name = "Modulo.findByDescrpipcion", query = "SELECT m FROM Modulo m WHERE m.descrpipcion = :descrpipcion")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmodulo", nullable = false)
    private Integer idmodulo;
    @Size(max = 45)
    @Column(name = "descrpipcion", length = 45)
    private String descrpipcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduloIdmodulo")
    private Collection<Opcion> opcionCollection;

    public Modulo() {
    }

    public Modulo(Integer idmodulo) {
        this.idmodulo = idmodulo;
    }

    public Integer getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(Integer idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getDescrpipcion() {
        return descrpipcion;
    }

    public void setDescrpipcion(String descrpipcion) {
        this.descrpipcion = descrpipcion;
    }

    @XmlTransient
    public Collection<Opcion> getOpcionCollection() {
        return opcionCollection;
    }

    public void setOpcionCollection(Collection<Opcion> opcionCollection) {
        this.opcionCollection = opcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodulo != null ? idmodulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.idmodulo == null && other.idmodulo != null) || (this.idmodulo != null && !this.idmodulo.equals(other.idmodulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Modulo[ idmodulo=" + idmodulo + " ]";
    }
    
}
