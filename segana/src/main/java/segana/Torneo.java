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
@Table(name = "torneo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Torneo.findAll", query = "SELECT t FROM Torneo t"),
    @NamedQuery(name = "Torneo.findByIdtorneo", query = "SELECT t FROM Torneo t WHERE t.torneoPK.idtorneo = :idtorneo"),
    @NamedQuery(name = "Torneo.findByNombre", query = "SELECT t FROM Torneo t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Torneo.findByEdicionIdedicion", query = "SELECT t FROM Torneo t WHERE t.edicionIdedicion = :edicionIdedicion"),
    @NamedQuery(name = "Torneo.findByDeporteIddeporte", query = "SELECT t FROM Torneo t WHERE t.torneoPK.deporteIddeporte = :deporteIddeporte")})
public class Torneo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TorneoPK torneoPK;
    @Size(max = 150)
    @Column(name = "nombre", length = 150)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edicion_idedicion", nullable = false)
    private int edicionIdedicion;
    @JoinColumn(name = "deporte_iddeporte", referencedColumnName = "iddeporte", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Deporte deporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "torneoIdtorneo")
    private Collection<Edicion> edicionCollection;

    public Torneo() {
    }

    public Torneo(TorneoPK torneoPK) {
        this.torneoPK = torneoPK;
    }

    public Torneo(TorneoPK torneoPK, int edicionIdedicion) {
        this.torneoPK = torneoPK;
        this.edicionIdedicion = edicionIdedicion;
    }

    public Torneo(int idtorneo, int deporteIddeporte) {
        this.torneoPK = new TorneoPK(idtorneo, deporteIddeporte);
    }

    public TorneoPK getTorneoPK() {
        return torneoPK;
    }

    public void setTorneoPK(TorneoPK torneoPK) {
        this.torneoPK = torneoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdicionIdedicion() {
        return edicionIdedicion;
    }

    public void setEdicionIdedicion(int edicionIdedicion) {
        this.edicionIdedicion = edicionIdedicion;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    @XmlTransient
    public Collection<Edicion> getEdicionCollection() {
        return edicionCollection;
    }

    public void setEdicionCollection(Collection<Edicion> edicionCollection) {
        this.edicionCollection = edicionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (torneoPK != null ? torneoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torneo)) {
            return false;
        }
        Torneo other = (Torneo) object;
        if ((this.torneoPK == null && other.torneoPK != null) || (this.torneoPK != null && !this.torneoPK.equals(other.torneoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Torneo[ torneoPK=" + torneoPK + " ]";
    }
    
}
