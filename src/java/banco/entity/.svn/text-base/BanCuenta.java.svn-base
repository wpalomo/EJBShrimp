/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "ban_cuenta", schema = "banco")
@NamedQueries({
    @NamedQuery(name = "BanCuenta.findAll", query = "SELECT b FROM BanCuenta b"),
    @NamedQuery(name = "BanCuenta.findByCtaEmpresa", query = "SELECT b FROM BanCuenta b WHERE b.banCuentaPK.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "BanCuenta.findByCtaCuentaContable", query = "SELECT b FROM BanCuenta b WHERE b.banCuentaPK.ctaCuentaContable = :ctaCuentaContable"),
    @NamedQuery(name = "BanCuenta.findByCtaNumero", query = "SELECT b FROM BanCuenta b WHERE b.ctaNumero = :ctaNumero"),
    @NamedQuery(name = "BanCuenta.findByCtaTitular", query = "SELECT b FROM BanCuenta b WHERE b.ctaTitular = :ctaTitular"),
    @NamedQuery(name = "BanCuenta.findByCtaOficial", query = "SELECT b FROM BanCuenta b WHERE b.ctaOficial = :ctaOficial"),
    @NamedQuery(name = "BanCuenta.findByCtaCodigoBancario", query = "SELECT b FROM BanCuenta b WHERE b.ctaCodigoBancario = :ctaCodigoBancario"),
    @NamedQuery(name = "BanCuenta.findByCtaPrefijoBancario", query = "SELECT b FROM BanCuenta b WHERE b.ctaPrefijoBancario = :ctaPrefijoBancario"),
    @NamedQuery(name = "BanCuenta.findByCtaFormatoCheque", query = "SELECT b FROM BanCuenta b WHERE b.ctaFormatoCheque = :ctaFormatoCheque"),
    @NamedQuery(name = "BanCuenta.findByUsrEmpresa", query = "SELECT b FROM BanCuenta b WHERE b.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "BanCuenta.findByUsrCodigo", query = "SELECT b FROM BanCuenta b WHERE b.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "BanCuenta.findByUsrFechaInserta", query = "SELECT b FROM BanCuenta b WHERE b.usrFechaInserta = :usrFechaInserta")})
public class BanCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BanCuentaPK banCuentaPK;
    @Basic(optional = false)
    @Column(name = "cta_numero")
    private String ctaNumero;
    @Column(name = "cta_titular")
    private String ctaTitular;
    @Column(name = "cta_oficial")
    private String ctaOficial;
    @Column(name = "cta_codigo_bancario")
    private String ctaCodigoBancario;
    @Column(name = "cta_prefijo_bancario")
    private String ctaPrefijoBancario;
    @Column(name = "cta_formato_cheque")
    private String ctaFormatoCheque;
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
    @JoinColumns({
        @JoinColumn(name = "ban_empresa", referencedColumnName = "ban_empresa"),
        @JoinColumn(name = "ban_codigo", referencedColumnName = "ban_codigo")})
    @ManyToOne(optional = false)
    private BanBanco banBanco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banCuenta")
    private List<BanConciliacion> banConciliacionList;

    public BanCuenta() {
    }

    public BanCuenta(BanCuentaPK banCuentaPK) {
        this.banCuentaPK = banCuentaPK;
    }

    public BanCuenta(BanCuentaPK banCuentaPK, String ctaNumero, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.banCuentaPK = banCuentaPK;
        this.ctaNumero = ctaNumero;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public BanCuenta(String ctaEmpresa, String ctaCuentaContable) {
        this.banCuentaPK = new BanCuentaPK(ctaEmpresa, ctaCuentaContable);
    }

    public BanCuentaPK getBanCuentaPK() {
        return banCuentaPK;
    }

    public void setBanCuentaPK(BanCuentaPK banCuentaPK) {
        this.banCuentaPK = banCuentaPK;
    }

    public String getCtaNumero() {
        return ctaNumero;
    }

    public void setCtaNumero(String ctaNumero) {
        this.ctaNumero = ctaNumero;
    }

    public String getCtaTitular() {
        return ctaTitular;
    }

    public void setCtaTitular(String ctaTitular) {
        this.ctaTitular = ctaTitular;
    }

    public String getCtaOficial() {
        return ctaOficial;
    }

    public void setCtaOficial(String ctaOficial) {
        this.ctaOficial = ctaOficial;
    }

    public String getCtaCodigoBancario() {
        return ctaCodigoBancario;
    }

    public void setCtaCodigoBancario(String ctaCodigoBancario) {
        this.ctaCodigoBancario = ctaCodigoBancario;
    }

    public String getCtaPrefijoBancario() {
        return ctaPrefijoBancario;
    }

    public void setCtaPrefijoBancario(String ctaPrefijoBancario) {
        this.ctaPrefijoBancario = ctaPrefijoBancario;
    }

    public String getCtaFormatoCheque() {
        return ctaFormatoCheque;
    }

    public void setCtaFormatoCheque(String ctaFormatoCheque) {
        this.ctaFormatoCheque = ctaFormatoCheque;
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

    public BanBanco getBanBanco() {
        return banBanco;
    }

    public void setBanBanco(BanBanco banBanco) {
        this.banBanco = banBanco;
    }

    public List<BanConciliacion> getBanConciliacionList() {
        return banConciliacionList;
    }

    public void setBanConciliacionList(List<BanConciliacion> banConciliacionList) {
        this.banConciliacionList = banConciliacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banCuentaPK != null ? banCuentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BanCuenta)) {
            return false;
        }
        BanCuenta other = (BanCuenta) object;
        if ((this.banCuentaPK == null && other.banCuentaPK != null) || (this.banCuentaPK != null && !this.banCuentaPK.equals(other.banCuentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.entity.BanCuenta[ banCuentaPK=" + banCuentaPK + " ]";
    }
    
}
