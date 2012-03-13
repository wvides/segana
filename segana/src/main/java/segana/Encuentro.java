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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eddy
 */
@Entity
@Table(name = "encuentro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuentro.findAll", query = "SELECT e FROM Encuentro e"),
    @NamedQuery(name = "Encuentro.findByIdencuentro", query = "SELECT e FROM Encuentro e WHERE e.idencuentro = :idencuentro"),
    @NamedQuery(name = "Encuentro.findByEscenario", query = "SELECT e FROM Encuentro e WHERE e.escenario = :escenario"),
    @NamedQuery(name = "Encuentro.findByFecha", query = "SELECT e FROM Encuentro e WHERE e.fecha = :fecha")})
public class Encuentro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idencuentro", nullable = false)
    private Integer idencuentro;
    @Size(max = 150)
    @Column(name = "escenario", length = 150)
    private String escenario;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encuentroIdencuentro")
    private Collection<Apuesta> apuestaCollection;
    @JoinColumn(name = "equipo_idequipo1", referencedColumnName = "idequipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipo equipoIdequipo1;
    @JoinColumn(name = "equipo_idequipo", referencedColumnName = "idequipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipo equipoIdequipo;
    @JoinColumn(name = "edicion_idedicion", referencedColumnName = "idedicion", nullable = false)
    @ManyToOne(optional = false)
    private Edicion edicionIdedicion;

    public Encuentro() {
    }

    public Encuentro(Integer idencuentro) {
        this.idencuentro = idencuentro;
    }

    public Integer getIdencuentro() {
        return idencuentro;
    }

    public void setIdencuentro(Integer idencuentro) {
        this.idencuentro = idencuentro;
    }

    public String getEscenario() {
        return escenario;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Apuesta> getApuestaCollection() {
        return apuestaCollection;
    }

    public void setApuestaCollection(Collection<Apuesta> apuestaCollection) {
        this.apuestaCollection = apuestaCollection;
    }

    public Equipo getEquipoIdequipo1() {
        return equipoIdequipo1;
    }

    public void setEquipoIdequipo1(Equipo equipoIdequipo1) {
        this.equipoIdequipo1 = equipoIdequipo1;
    }

    public Equipo getEquipoIdequipo() {
        return equipoIdequipo;
    }

    public void setEquipoIdequipo(Equipo equipoIdequipo) {
        this.equipoIdequipo = equipoIdequipo;
    }

    public Edicion getEdicionIdedicion() {
        return edicionIdedicion;
    }

    public void setEdicionIdedicion(Edicion edicionIdedicion) {
        this.edicionIdedicion = edicionIdedicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idencuentro != null ? idencuentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuentro)) {
            return false;
        }
        Encuentro other = (Encuentro) object;
        if ((this.idencuentro == null && other.idencuentro != null) || (this.idencuentro != null && !this.idencuentro.equals(other.idencuentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Encuentro[ idencuentro=" + idencuentro + " ]";
    }
    
}
