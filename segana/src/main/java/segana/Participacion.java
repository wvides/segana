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
@Table(name = "participacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participacion.findAll", query = "SELECT p FROM Participacion p"),
    @NamedQuery(name = "Participacion.findByIdparticipacion", query = "SELECT p FROM Participacion p WHERE p.idparticipacion = :idparticipacion")})
public class Participacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idparticipacion", nullable = false)
    private Integer idparticipacion;
    @JoinColumn(name = "edicion_idedicion", referencedColumnName = "idedicion", nullable = false)
    @ManyToOne(optional = false)
    private Edicion edicionIdedicion;
    @JoinColumn(name = "equipo_idequipo", referencedColumnName = "idequipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipo equipoIdequipo;

    public Participacion() {
    }

    public Participacion(Integer idparticipacion) {
        this.idparticipacion = idparticipacion;
    }

    public Integer getIdparticipacion() {
        return idparticipacion;
    }

    public void setIdparticipacion(Integer idparticipacion) {
        this.idparticipacion = idparticipacion;
    }

    public Edicion getEdicionIdedicion() {
        return edicionIdedicion;
    }

    public void setEdicionIdedicion(Edicion edicionIdedicion) {
        this.edicionIdedicion = edicionIdedicion;
    }

    public Equipo getEquipoIdequipo() {
        return equipoIdequipo;
    }

    public void setEquipoIdequipo(Equipo equipoIdequipo) {
        this.equipoIdequipo = equipoIdequipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparticipacion != null ? idparticipacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participacion)) {
            return false;
        }
        Participacion other = (Participacion) object;
        if ((this.idparticipacion == null && other.idparticipacion != null) || (this.idparticipacion != null && !this.idparticipacion.equals(other.idparticipacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Participacion[ idparticipacion=" + idparticipacion + " ]";
    }
    
}
