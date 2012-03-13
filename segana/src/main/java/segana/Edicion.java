/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segana;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eddy
 */
@Entity
@Table(name = "edicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edicion.findAll", query = "SELECT e FROM Edicion e"),
    @NamedQuery(name = "Edicion.findByIdedicion", query = "SELECT e FROM Edicion e WHERE e.idedicion = :idedicion"),
    @NamedQuery(name = "Edicion.findByAnio", query = "SELECT e FROM Edicion e WHERE e.anio = :anio")})
public class Edicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idedicion", nullable = false)
    private Integer idedicion;
    @Column(name = "anio")
    @Temporal(TemporalType.DATE)
    private Date anio;
    @JoinColumn(name = "torneo_idtorneo", referencedColumnName = "idtorneo", nullable = false)
    @ManyToOne(optional = false)
    private Torneo torneoIdtorneo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edicionIdedicion")
    private Collection<Encuentro> encuentroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edicionIdedicion")
    private Collection<Participacion> participacionCollection;

    public Edicion() {
    }

    public Edicion(Integer idedicion) {
        this.idedicion = idedicion;
    }

    public Integer getIdedicion() {
        return idedicion;
    }

    public void setIdedicion(Integer idedicion) {
        this.idedicion = idedicion;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public Torneo getTorneoIdtorneo() {
        return torneoIdtorneo;
    }

    public void setTorneoIdtorneo(Torneo torneoIdtorneo) {
        this.torneoIdtorneo = torneoIdtorneo;
    }

    @XmlTransient
    public Collection<Encuentro> getEncuentroCollection() {
        return encuentroCollection;
    }

    public void setEncuentroCollection(Collection<Encuentro> encuentroCollection) {
        this.encuentroCollection = encuentroCollection;
    }

    @XmlTransient
    public Collection<Participacion> getParticipacionCollection() {
        return participacionCollection;
    }

    public void setParticipacionCollection(Collection<Participacion> participacionCollection) {
        this.participacionCollection = participacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idedicion != null ? idedicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edicion)) {
            return false;
        }
        Edicion other = (Edicion) object;
        if ((this.idedicion == null && other.idedicion != null) || (this.idedicion != null && !this.idedicion.equals(other.idedicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Edicion[ idedicion=" + idedicion + " ]";
    }
    
}
