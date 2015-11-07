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
@Table(name = "anx_tipotransaccion",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxTipotransaccion.findAll", query = "SELECT a FROM AnxTipotransaccion a"),
    @NamedQuery(name = "AnxTipotransaccion.findByTtCodigo", query = "SELECT a FROM AnxTipotransaccion a WHERE a.ttCodigo = :ttCodigo"),
    @NamedQuery(name = "AnxTipotransaccion.findByTtTransaccion", query = "SELECT a FROM AnxTipotransaccion a WHERE a.ttTransaccion = :ttTransaccion"),
    @NamedQuery(name = "AnxTipotransaccion.findByTtId", query = "SELECT a FROM AnxTipotransaccion a WHERE a.ttId = :ttId")})
public class AnxTipotransaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tt_codigo")
    private String ttCodigo;
    @Basic(optional = false)
    @Column(name = "tt_transaccion")
    private String ttTransaccion;
    @Basic(optional = false)
    @Column(name = "tt_id")
    private char ttId;

    public AnxTipotransaccion() {
    }

    public AnxTipotransaccion(String ttCodigo) {
        this.ttCodigo = ttCodigo;
    }

    public AnxTipotransaccion(String ttCodigo, String ttTransaccion, char ttId) {
        this.ttCodigo = ttCodigo;
        this.ttTransaccion = ttTransaccion;
        this.ttId = ttId;
    }

    public String getTtCodigo() {
        return ttCodigo;
    }

    public void setTtCodigo(String ttCodigo) {
        this.ttCodigo = ttCodigo;
    }

    public String getTtTransaccion() {
        return ttTransaccion;
    }

    public void setTtTransaccion(String ttTransaccion) {
        this.ttTransaccion = ttTransaccion;
    }

    public char getTtId() {
        return ttId;
    }

    public void setTtId(char ttId) {
        this.ttId = ttId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttCodigo != null ? ttCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxTipotransaccion)) {
            return false;
        }
        AnxTipotransaccion other = (AnxTipotransaccion) object;
        if ((this.ttCodigo == null && other.ttCodigo != null) || (this.ttCodigo != null && !this.ttCodigo.equals(other.ttCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxTipotransaccion[ ttCodigo=" + ttCodigo + " ]";
    }
    
}
