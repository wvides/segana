/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segana;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eddy
 */
@Entity
@Table(name = "apuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apuesta.findAll", query = "SELECT a FROM Apuesta a"),
    @NamedQuery(name = "Apuesta.findByIdapuesta", query = "SELECT a FROM Apuesta a WHERE a.idapuesta = :idapuesta"),
    @NamedQuery(name = "Apuesta.findByMonto", query = "SELECT a FROM Apuesta a WHERE a.monto = :monto")})
public class Apuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idapuesta", nullable = false)
    private Integer idapuesta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto", precision = 20, scale = 2)
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "fantasy", nullable = false)
    private byte[] fantasy;
    @JoinColumn(name = "encuentro_idencuentro", referencedColumnName = "idencuentro", nullable = false)
    @ManyToOne(optional = false)
    private Encuentro encuentroIdencuentro;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apuestaIdapuesta")
    private Collection<Pronostico> pronosticoCollection;

    public Apuesta() {
    }

    public Apuesta(Integer idapuesta) {
        this.idapuesta = idapuesta;
    }

    public Apuesta(Integer idapuesta, byte[] fantasy) {
        this.idapuesta = idapuesta;
        this.fantasy = fantasy;
    }

    public Integer getIdapuesta() {
        return idapuesta;
    }

    public void setIdapuesta(Integer idapuesta) {
        this.idapuesta = idapuesta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public byte[] getFantasy() {
        return fantasy;
    }

    public void setFantasy(byte[] fantasy) {
        this.fantasy = fantasy;
    }

    public Encuentro getEncuentroIdencuentro() {
        return encuentroIdencuentro;
    }

    public void setEncuentroIdencuentro(Encuentro encuentroIdencuentro) {
        this.encuentroIdencuentro = encuentroIdencuentro;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @XmlTransient
    public Collection<Pronostico> getPronosticoCollection() {
        return pronosticoCollection;
    }

    public void setPronosticoCollection(Collection<Pronostico> pronosticoCollection) {
        this.pronosticoCollection = pronosticoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idapuesta != null ? idapuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apuesta)) {
            return false;
        }
        Apuesta other = (Apuesta) object;
        if ((this.idapuesta == null && other.idapuesta != null) || (this.idapuesta != null && !this.idapuesta.equals(other.idapuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Apuesta[ idapuesta=" + idapuesta + " ]";
    }
    
}
