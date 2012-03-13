/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segana;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eddy
 */
@Entity
@Table(name = "pronostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pronostico.findAll", query = "SELECT p FROM Pronostico p"),
    @NamedQuery(name = "Pronostico.findByIdpronostico", query = "SELECT p FROM Pronostico p WHERE p.idpronostico = :idpronostico"),
    @NamedQuery(name = "Pronostico.findByValor", query = "SELECT p FROM Pronostico p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pronostico.findByPronosticocol", query = "SELECT p FROM Pronostico p WHERE p.pronosticocol = :pronosticocol")})
public class Pronostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpronostico", nullable = false)
    private Integer idpronostico;
    @Column(name = "valor")
    private Integer valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pronosticocol", nullable = false, length = 45)
    private String pronosticocol;
    @JoinColumn(name = "equipo_idequipo", referencedColumnName = "idequipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipo equipoIdequipo;
    @JoinColumn(name = "apuesta_idapuesta", referencedColumnName = "idapuesta", nullable = false)
    @ManyToOne(optional = false)
    private Apuesta apuestaIdapuesta;

    public Pronostico() {
    }

    public Pronostico(Integer idpronostico) {
        this.idpronostico = idpronostico;
    }

    public Pronostico(Integer idpronostico, String pronosticocol) {
        this.idpronostico = idpronostico;
        this.pronosticocol = pronosticocol;
    }

    public Integer getIdpronostico() {
        return idpronostico;
    }

    public void setIdpronostico(Integer idpronostico) {
        this.idpronostico = idpronostico;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getPronosticocol() {
        return pronosticocol;
    }

    public void setPronosticocol(String pronosticocol) {
        this.pronosticocol = pronosticocol;
    }

    public Equipo getEquipoIdequipo() {
        return equipoIdequipo;
    }

    public void setEquipoIdequipo(Equipo equipoIdequipo) {
        this.equipoIdequipo = equipoIdequipo;
    }

    public Apuesta getApuestaIdapuesta() {
        return apuestaIdapuesta;
    }

    public void setApuestaIdapuesta(Apuesta apuestaIdapuesta) {
        this.apuestaIdapuesta = apuestaIdapuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpronostico != null ? idpronostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pronostico)) {
            return false;
        }
        Pronostico other = (Pronostico) object;
        if ((this.idpronostico == null && other.idpronostico != null) || (this.idpronostico != null && !this.idpronostico.equals(other.idpronostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Pronostico[ idpronostico=" + idpronostico + " ]";
    }
    
}
