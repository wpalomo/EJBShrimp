/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_tipoidentificacion",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxTipoidentificacion.findAll", query = "SELECT a FROM AnxTipoidentificacion a"),
    @NamedQuery(name = "AnxTipoidentificacion.findByTiCodigo", query = "SELECT a FROM AnxTipoidentificacion a WHERE a.tiCodigo = :tiCodigo"),
    @NamedQuery(name = "AnxTipoidentificacion.findByTiDetalle", query = "SELECT a FROM AnxTipoidentificacion a WHERE a.tiDetalle = :tiDetalle")})
public class AnxTipoidentificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ti_codigo")
    private Character tiCodigo;
    @Basic(optional = false)
    @Column(name = "ti_detalle")
    private String tiDetalle;

    public AnxTipoidentificacion() {
    }

    public AnxTipoidentificacion(Character tiCodigo) {
        this.tiCodigo = tiCodigo;
    }

    public AnxTipoidentificacion(Character tiCodigo, String tiDetalle) {
        this.tiCodigo = tiCodigo;
        this.tiDetalle = tiDetalle;
    }

    public Character getTiCodigo() {
        return tiCodigo;
    }

    public void setTiCodigo(Character tiCodigo) {
        this.tiCodigo = tiCodigo;
    }

    public String getTiDetalle() {
        return tiDetalle;
    }

    public void setTiDetalle(String tiDetalle) {
        this.tiDetalle = tiDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiCodigo != null ? tiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxTipoidentificacion)) {
            return false;
        }
        AnxTipoidentificacion other = (AnxTipoidentificacion) object;
        if ((this.tiCodigo == null && other.tiCodigo != null) || (this.tiCodigo != null && !this.tiCodigo.equals(other.tiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxTipoidentificacion[ tiCodigo=" + tiCodigo + " ]";
    }
    
}
