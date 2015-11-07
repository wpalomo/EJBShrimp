/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "con_tipo", schema = "contabilidad")
@NamedQueries({
    @NamedQuery(name = "ConTipo.findAll", query = "SELECT c FROM ConTipo c"),
    @NamedQuery(name = "ConTipo.findByTipEmpresa", query = "SELECT c FROM ConTipo c WHERE c.conTipoPK.tipEmpresa = :tipEmpresa"),
    @NamedQuery(name = "ConTipo.findByTipCodigo", query = "SELECT c FROM ConTipo c WHERE c.conTipoPK.tipCodigo = :tipCodigo"),
    @NamedQuery(name = "ConTipo.findByTipDetalle", query = "SELECT c FROM ConTipo c WHERE c.tipDetalle = :tipDetalle"),
    @NamedQuery(name = "ConTipo.findByTipInactivo", query = "SELECT c FROM ConTipo c WHERE c.tipInactivo = :tipInactivo"),
    @NamedQuery(name = "ConTipo.findByUsrEmpresa", query = "SELECT c FROM ConTipo c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "ConTipo.findByUsrCodigo", query = "SELECT c FROM ConTipo c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "ConTipo.findByUsrFechaInserta", query = "SELECT c FROM ConTipo c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class ConTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConTipoPK conTipoPK;
    @Basic(optional = false)
    @Column(name = "tip_detalle")
    private String tipDetalle;
    @Basic(optional = false)
    @Column(name = "tip_inactivo")
    private boolean tipInactivo;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;

    public ConTipo() {
    }

    public ConTipo(ConTipoPK conTipoPK) {
        this.conTipoPK = conTipoPK;
    }

    public ConTipo(ConTipoPK conTipoPK, String tipDetalle, boolean tipInactivo, String usrEmpresa, String usrCodigo) {
        this.conTipoPK = conTipoPK;
        this.tipDetalle = tipDetalle;
        this.tipInactivo = tipInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
    }

    public ConTipo(String tipEmpresa, String tipCodigo) {
        this.conTipoPK = new ConTipoPK(tipEmpresa, tipCodigo);
    }

    public ConTipoPK getConTipoPK() {
        return conTipoPK;
    }

    public void setConTipoPK(ConTipoPK conTipoPK) {
        this.conTipoPK = conTipoPK;
    }

    public String getTipDetalle() {
        return tipDetalle;
    }

    public void setTipDetalle(String tipDetalle) {
        this.tipDetalle = tipDetalle;
    }

    public boolean getTipInactivo() {
        return tipInactivo;
    }

    public void setTipInactivo(boolean tipInactivo) {
        this.tipInactivo = tipInactivo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Date getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(Date usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conTipoPK != null ? conTipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConTipo)) {
            return false;
        }
        ConTipo other = (ConTipo) object;
        if ((this.conTipoPK == null && other.conTipoPK != null) || (this.conTipoPK != null && !this.conTipoPK.equals(other.conTipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConTipo[ conTipoPK=" + conTipoPK + " ]";
    }
    
}
