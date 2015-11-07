/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_sustento", schema = "anexo")
@NamedQueries({
    @NamedQuery(name = "AnxSustento.findAll", query = "SELECT a FROM AnxSustento a"),
    @NamedQuery(name = "AnxSustento.findBySusCodigo", query = "SELECT a FROM AnxSustento a WHERE a.susCodigo = :susCodigo"),
    @NamedQuery(name = "AnxSustento.findBySusDescripcion", query = "SELECT a FROM AnxSustento a WHERE a.susDescripcion = :susDescripcion"),
    @NamedQuery(name = "AnxSustento.findBySusComprobante", query = "SELECT a FROM AnxSustento a WHERE a.susComprobante = :susComprobante")})
public class AnxSustento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sus_codigo")
    private String susCodigo;
    @Column(name = "sus_descripcion")
    private String susDescripcion;
    @Column(name = "sus_comprobante")
    private String susComprobante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compSustentotributario")
    private List<AnxCompra> anxCompraList;

    public AnxSustento() {
    }

    public AnxSustento(String susCodigo) {
        this.susCodigo = susCodigo;
    }

    public String getSusCodigo() {
        return susCodigo;
    }

    public void setSusCodigo(String susCodigo) {
        this.susCodigo = susCodigo;
    }

    public String getSusDescripcion() {
        return susDescripcion;
    }

    public void setSusDescripcion(String susDescripcion) {
        this.susDescripcion = susDescripcion;
    }

    public String getSusComprobante() {
        return susComprobante;
    }

    public void setSusComprobante(String susComprobante) {
        this.susComprobante = susComprobante;
    }

    public List<AnxCompra> getAnxCompraList() {
        return anxCompraList;
    }

    public void setAnxCompraList(List<AnxCompra> anxCompraList) {
        this.anxCompraList = anxCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (susCodigo != null ? susCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxSustento)) {
            return false;
        }
        AnxSustento other = (AnxSustento) object;
        if ((this.susCodigo == null && other.susCodigo != null) || (this.susCodigo != null && !this.susCodigo.equals(other.susCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxSustento[ susCodigo=" + susCodigo + " ]";
    }
    
}
