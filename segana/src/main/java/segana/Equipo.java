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
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdequipo", query = "SELECT e FROM Equipo e WHERE e.idequipo = :idequipo"),
    @NamedQuery(name = "Equipo.findByNombre", query = "SELECT e FROM Equipo e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Equipo.findByRankin", query = "SELECT e FROM Equipo e WHERE e.rankin = :rankin"),
    @NamedQuery(name = "Equipo.findByFundacion", query = "SELECT e FROM Equipo e WHERE e.fundacion = :fundacion")})
public class Equipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idequipo", nullable = false)
    private Integer idequipo;
    @Size(max = 150)
    @Column(name = "nombre", length = 150)
    private String nombre;
    @Column(name = "rankin")
    private Integer rankin;
    @Column(name = "fundacion")
    @Temporal(TemporalType.DATE)
    private Date fundacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoIdequipo")
    private Collection<Pronostico> pronosticoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoIdequipo1")
    private Collection<Encuentro> encuentroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoIdequipo")
    private Collection<Encuentro> encuentroCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoIdequipo")
    private Collection<Participacion> participacionCollection;

    public Equipo() {
    }

    public Equipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public Integer getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRankin() {
        return rankin;
    }

    public void setRankin(Integer rankin) {
        this.rankin = rankin;
    }

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }

    @XmlTransient
    public Collection<Pronostico> getPronosticoCollection() {
        return pronosticoCollection;
    }

    public void setPronosticoCollection(Collection<Pronostico> pronosticoCollection) {
        this.pronosticoCollection = pronosticoCollection;
    }

    @XmlTransient
    public Collection<Encuentro> getEncuentroCollection() {
        return encuentroCollection;
    }

    public void setEncuentroCollection(Collection<Encuentro> encuentroCollection) {
        this.encuentroCollection = encuentroCollection;
    }

    @XmlTransient
    public Collection<Encuentro> getEncuentroCollection1() {
        return encuentroCollection1;
    }

    public void setEncuentroCollection1(Collection<Encuentro> encuentroCollection1) {
        this.encuentroCollection1 = encuentroCollection1;
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
        hash += (idequipo != null ? idequipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idequipo == null && other.idequipo != null) || (this.idequipo != null && !this.idequipo.equals(other.idequipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Equipo[ idequipo=" + idequipo + " ]";
    }
    
}
