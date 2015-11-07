/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "con_cuentas", schema = "contabilidad")
@NamedQueries({
    @NamedQuery(name = "ConCuentas.findAll", query = "SELECT c FROM ConCuentas c"),
    @NamedQuery(name = "ConCuentas.findByCtaEmpresa", query = "SELECT c FROM ConCuentas c WHERE c.conCuentasPK.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "ConCuentas.findByCtaCodigo", query = "SELECT c FROM ConCuentas c WHERE c.conCuentasPK.ctaCodigo = :ctaCodigo"),
    @NamedQuery(name = "ConCuentas.findByCtaDetalle", query = "SELECT c FROM ConCuentas c WHERE c.ctaDetalle = :ctaDetalle"),
    @NamedQuery(name = "ConCuentas.findByCtaActivo", query = "SELECT c FROM ConCuentas c WHERE c.ctaActivo = :ctaActivo"),
    @NamedQuery(name = "ConCuentas.findByUsrEmpresa", query = "SELECT c FROM ConCuentas c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "ConCuentas.findByUsrCodigo", query = "SELECT c FROM ConCuentas c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "ConCuentas.findByUsrFechaInserta", query = "SELECT c FROM ConCuentas c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class ConCuentas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConCuentasPK conCuentasPK;
    @Basic(optional = false)
    @Column(name = "cta_detalle")
    private String ctaDetalle;
    @Column(name = "cta_activo")
    private Boolean ctaActivo;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conCuentas")
    private List<ConCuentasFlujoDetalle> conCuentasFlujoDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conCuentas")
    private List<ConDetalle> conDetalleList;

    public ConCuentas() {
    }

    public ConCuentas(ConCuentasPK conCuentasPK) {
        this.conCuentasPK = conCuentasPK;
    }

    public ConCuentas(ConCuentasPK conCuentasPK, String ctaDetalle, String usrEmpresa) {
        this.conCuentasPK = conCuentasPK;
        this.ctaDetalle = ctaDetalle;
        this.usrEmpresa = usrEmpresa;
    }

    public ConCuentas(String ctaEmpresa, String ctaCodigo) {
        this.conCuentasPK = new ConCuentasPK(ctaEmpresa, ctaCodigo);
    }

    public ConCuentasPK getConCuentasPK() {
        return conCuentasPK;
    }

    public void setConCuentasPK(ConCuentasPK conCuentasPK) {
        this.conCuentasPK = conCuentasPK;
    }

    public String getCtaDetalle() {
        return ctaDetalle;
    }

    public void setCtaDetalle(String ctaDetalle) {
        this.ctaDetalle = ctaDetalle;
    }

    public Boolean getCtaActivo() {
        return ctaActivo;
    }

    public void setCtaActivo(Boolean ctaActivo) {
        this.ctaActivo = ctaActivo;
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

    public List<ConCuentasFlujoDetalle> getConCuentasFlujoDetalleList() {
        return conCuentasFlujoDetalleList;
    }

    public void setConCuentasFlujoDetalleList(List<ConCuentasFlujoDetalle> conCuentasFlujoDetalleList) {
        this.conCuentasFlujoDetalleList = conCuentasFlujoDetalleList;
    }

    public List<ConDetalle> getConDetalleList() {
        return conDetalleList;
    }

    public void setConDetalleList(List<ConDetalle> conDetalleList) {
        this.conDetalleList = conDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conCuentasPK != null ? conCuentasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConCuentas)) {
            return false;
        }
        ConCuentas other = (ConCuentas) object;
        if ((this.conCuentasPK == null && other.conCuentasPK != null) || (this.conCuentasPK != null && !this.conCuentasPK.equals(other.conCuentasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConCuentas[ conCuentasPK=" + conCuentasPK + " ]";
    }
    
}
