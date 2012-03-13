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
@Table(name = "deporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deporte.findAll", query = "SELECT d FROM Deporte d"),
    @NamedQuery(name = "Deporte.findByIddeporte", query = "SELECT d FROM Deporte d WHERE d.iddeporte = :iddeporte"),
    @NamedQuery(name = "Deporte.findByNombre", query = "SELECT d FROM Deporte d WHERE d.nombre = :nombre")})
public class Deporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddeporte", nullable = false)
    private Integer iddeporte;
    @Size(max = 75)
    @Column(name = "nombre", length = 75)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deporte")
    private Collection<Torneo> torneoCollection;

    public Deporte() {
    }

    public Deporte(Integer iddeporte) {
        this.iddeporte = iddeporte;
    }

    public Integer getIddeporte() {
        return iddeporte;
    }

    public void setIddeporte(Integer iddeporte) {
        this.iddeporte = iddeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Torneo> getTorneoCollection() {
        return torneoCollection;
    }

    public void setTorneoCollection(Collection<Torneo> torneoCollection) {
        this.torneoCollection = torneoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddeporte != null ? iddeporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deporte)) {
            return false;
        }
        Deporte other = (Deporte) object;
        if ((this.iddeporte == null && other.iddeporte != null) || (this.iddeporte != null && !this.iddeporte.equals(other.iddeporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Deporte[ iddeporte=" + iddeporte + " ]";
    }
    
}
