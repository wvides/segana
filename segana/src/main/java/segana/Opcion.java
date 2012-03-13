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
@Table(name = "opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o"),
    @NamedQuery(name = "Opcion.findByIdopcion", query = "SELECT o FROM Opcion o WHERE o.idopcion = :idopcion"),
    @NamedQuery(name = "Opcion.findByTitulo", query = "SELECT o FROM Opcion o WHERE o.titulo = :titulo"),
    @NamedQuery(name = "Opcion.findByDescripcion", query = "SELECT o FROM Opcion o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "Opcion.findByLink", query = "SELECT o FROM Opcion o WHERE o.link = :link"),
    @NamedQuery(name = "Opcion.findByOrden", query = "SELECT o FROM Opcion o WHERE o.orden = :orden")})
public class Opcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idopcion", nullable = false)
    private Integer idopcion;
    @Size(max = 45)
    @Column(name = "titulo", length = 45)
    private String titulo;
    @Size(max = 245)
    @Column(name = "descripcion", length = 245)
    private String descripcion;
    @Size(max = 345)
    @Column(name = "link", length = 345)
    private String link;
    @Column(name = "orden")
    private Integer orden;
    @JoinColumn(name = "modulo_idmodulo", referencedColumnName = "idmodulo", nullable = false)
    @ManyToOne(optional = false)
    private Modulo moduloIdmodulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcionIdopcion")
    private Collection<Acesso> acessoCollection;

    public Opcion() {
    }

    public Opcion(Integer idopcion) {
        this.idopcion = idopcion;
    }

    public Integer getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(Integer idopcion) {
        this.idopcion = idopcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Modulo getModuloIdmodulo() {
        return moduloIdmodulo;
    }

    public void setModuloIdmodulo(Modulo moduloIdmodulo) {
        this.moduloIdmodulo = moduloIdmodulo;
    }

    @XmlTransient
    public Collection<Acesso> getAcessoCollection() {
        return acessoCollection;
    }

    public void setAcessoCollection(Collection<Acesso> acessoCollection) {
        this.acessoCollection = acessoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idopcion != null ? idopcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.idopcion == null && other.idopcion != null) || (this.idopcion != null && !this.idopcion.equals(other.idopcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segana.Opcion[ idopcion=" + idopcion + " ]";
    }
    
}
