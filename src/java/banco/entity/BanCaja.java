/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "ban_caja", schema = "banco")
@NamedQueries({
    @NamedQuery(name = "BanCaja.findAll", query = "SELECT b FROM BanCaja b"),
    @NamedQuery(name = "BanCaja.findByCajaEmpresa", query = "SELECT b FROM BanCaja b WHERE b.banCajaPK.cajaEmpresa = :cajaEmpresa"),
    @NamedQuery(name = "BanCaja.findByCajaCodigo", query = "SELECT b FROM BanCaja b WHERE b.banCajaPK.cajaCodigo = :cajaCodigo"),
    @NamedQuery(name = "BanCaja.findByCajaNombre", query = "SELECT b FROM BanCaja b WHERE b.cajaNombre = :cajaNombre"),
    @NamedQuery(name = "BanCaja.findByCtaEmpresa", query = "SELECT b FROM BanCaja b WHERE b.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "BanCaja.findByCtaCuentaContable", query = "SELECT b FROM BanCaja b WHERE b.ctaCuentaContable = :ctaCuentaContable"),
    @NamedQuery(name = "BanCaja.findByUsrEmpresa", query = "SELECT b FROM BanCaja b WHERE b.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "BanCaja.findByUsrCodigo", query = "SELECT b FROM BanCaja b WHERE b.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "BanCaja.findByUsrFechaInserta", query = "SELECT b FROM BanCaja b WHERE b.usrFechaInserta = :usrFechaInserta")})
public class BanCaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BanCajaPK banCajaPK;
    @Basic(optional = false)
    @Column(name = "caja_nombre")
    private String cajaNombre;
    @Basic(optional = false)
    @Column(name = "cta_empresa")
    private String ctaEmpresa;
    @Basic(optional = false)
    @Column(name = "cta_cuenta_contable")
    private String ctaCuentaContable;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;

    public BanCaja() {
    }

    public BanCaja(BanCajaPK banCajaPK) {
        this.banCajaPK = banCajaPK;
    }

    public BanCaja(BanCajaPK banCajaPK, String cajaNombre, String ctaEmpresa, String ctaCuentaContable, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.banCajaPK = banCajaPK;
        this.cajaNombre = cajaNombre;
        this.ctaEmpresa = ctaEmpresa;
        this.ctaCuentaContable = ctaCuentaContable;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public BanCaja(String cajaEmpresa, String cajaCodigo) {
        this.banCajaPK = new BanCajaPK(cajaEmpresa, cajaCodigo);
    }

    public BanCajaPK getBanCajaPK() {
        return banCajaPK;
    }

    public void setBanCajaPK(BanCajaPK banCajaPK) {
        this.banCajaPK = banCajaPK;
    }

    public String getCajaNombre() {
        return cajaNombre;
    }

    public void setCajaNombre(String cajaNombre) {
        this.cajaNombre = cajaNombre;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getCtaCuentaContable() {
        return ctaCuentaContable;
    }

    public void setCtaCuentaContable(String ctaCuentaContable) {
        this.ctaCuentaContable = ctaCuentaContable;
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
        hash += (banCajaPK != null ? banCajaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BanCaja)) {
            return false;
        }
        BanCaja other = (BanCaja) object;
        if ((this.banCajaPK == null && other.banCajaPK != null) || (this.banCajaPK != null && !this.banCajaPK.equals(other.banCajaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.entity.BanCaja[ banCajaPK=" + banCajaPK + " ]";
    }
    
}
