/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segana;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eddy
 */
@Embeddable
public class TorneoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtorneo", nullable = false)
    private int idtorneo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deporte_iddeporte", nullable = false)
    private int deporteIddeporte;

    public TorneoPK() {
    }

    public TorneoPK(int idtorneo, int deporteIddeporte) {
        this.idtorneo = idtorneo;
        this.deporteIddeporte = deporteIddeporte;
    }

    public int getIdtorneo() {
        return idtorneo;
    }

    public void setIdtorneo(int idtorneo) {
        this.idtorneo = idtorneo;
    }

    public int getDeporteIddeporte() {
        return deporteIddeporte;
    }

    public void setDeporteIddeporte(int deporteIddeporte) {
        this.deporteIddeporte = deporteIddeporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtorneo;
        hash += (int) deporteIddeporte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TorneoPK)) {
            return false;
        }
        TorneoPK other = (TorneoPK) object;
        if (this.idtorneo != other.idtorneo) {
            return false;
        }
        if (this.deporteIddeporte != other.deporteIddeporte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.TorneoPK[ idtorneo=" + idtorneo + ", deporteIddeporte=" + deporteIddeporte + " ]";
    }
    
}
