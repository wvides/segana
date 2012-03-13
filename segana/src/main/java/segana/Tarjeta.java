/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segana;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eddy
 */
@Entity
@Table(name = "tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t"),
    @NamedQuery(name = "Tarjeta.findByIdtarjeta", query = "SELECT t FROM Tarjeta t WHERE t.idtarjeta = :idtarjeta"),
    @NamedQuery(name = "Tarjeta.findByDescripcion", query = "SELECT t FROM Tarjeta t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tarjeta.findByFechaVence", query = "SELECT t FROM Tarjeta t WHERE t.fechaVence = :fechaVence"),
    @NamedQuery(name = "Tarjeta.findByNombre", query = "SELECT t FROM Tarjeta t WHERE t.nombre = :nombre")})
public class Tarjeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtarjeta", nullable = false)
    private Integer idtarjeta;
    @Size(max = 145)
    @Column(name = "descripcion", length = 145)
    private String descripcion;
    @Column(name = "fecha_vence")
    @Temporal(TemporalType.DATE)
    private Date fechaVence;
    @Size(max = 75)
    @Column(name = "nombre", length = 75)
    private String nombre;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;

    public Tarjeta() {
    }

    public Tarjeta(Integer idtarjeta) {
        this.idtarjeta = idtarjeta;
    }

    public Integer getIdtarjeta() {
        return idtarjeta;
    }

    public void setIdtarjeta(Integer idtarjeta) {
        this.idtarjeta = idtarjeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(Date fechaVence) {
        this.fechaVence = fechaVence;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtarjeta != null ? idtarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.idtarjeta == null && other.idtarjeta != null) || (this.idtarjeta != null && !this.idtarjeta.equals(other.idtarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Tarjeta[ idtarjeta=" + idtarjeta + " ]";
    }
    
}
