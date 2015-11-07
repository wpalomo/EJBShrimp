/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_producto_tipo_detalle_cuentas", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findAll", query = "SELECT i FROM InvProductoTipoDetalleCuentas i"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByDetEmpresa", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.invProductoTipoDetalleCuentasPK.detEmpresa = :detEmpresa"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByDetTipo", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.invProductoTipoDetalleCuentasPK.detTipo = :detTipo"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByDetSector", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.invProductoTipoDetalleCuentasPK.detSector = :detSector"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByDetPiscina", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.invProductoTipoDetalleCuentasPK.detPiscina = :detPiscina"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByDetCuenta", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.invProductoTipoDetalleCuentasPK.detCuenta = :detCuenta"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByPisEmpresa", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.pisEmpresa = :pisEmpresa"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByPisSector", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.pisSector = :pisSector"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByPisNumero", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.pisNumero = :pisNumero"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByCtaEmpresa", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByCtaCodigo", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.ctaCodigo = :ctaCodigo"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByUsrEmpresa", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByUsrCodigo", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProductoTipoDetalleCuentas.findByUsrFechaInserta", query = "SELECT i FROM InvProductoTipoDetalleCuentas i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProductoTipoDetalleCuentas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProductoTipoDetalleCuentasPK invProductoTipoDetalleCuentasPK;
    @Basic(optional = false)
    @Column(name = "pis_empresa")
    private String pisEmpresa;
    @Basic(optional = false)
    @Column(name = "pis_sector")
    private String pisSector;
    @Basic(optional = false)
    @Column(name = "pis_numero")
    private String pisNumero;
    @Basic(optional = false)
    @Column(name = "cta_empresa")
    private String ctaEmpresa;
    @Basic(optional = false)
    @Column(name = "cta_codigo")
    private String ctaCodigo;
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
        @JoinColumn(name = "tip_empresa", referencedColumnName = "tip_empresa"),
        @JoinColumn(name = "tip_codigo", referencedColumnName = "tip_codigo")})
    @ManyToOne(optional = false)
    private InvProductoTipo invProductoTipo;

    public InvProductoTipoDetalleCuentas() {
    }

    public InvProductoTipoDetalleCuentas(InvProductoTipoDetalleCuentasPK invProductoTipoDetalleCuentasPK) {
        this.invProductoTipoDetalleCuentasPK = invProductoTipoDetalleCuentasPK;
    }

    public InvProductoTipoDetalleCuentas(InvProductoTipoDetalleCuentasPK invProductoTipoDetalleCuentasPK, String pisEmpresa, String pisSector, String pisNumero, String ctaEmpresa, String ctaCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invProductoTipoDetalleCuentasPK = invProductoTipoDetalleCuentasPK;
        this.pisEmpresa = pisEmpresa;
        this.pisSector = pisSector;
        this.pisNumero = pisNumero;
        this.ctaEmpresa = ctaEmpresa;
        this.ctaCodigo = ctaCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvProductoTipoDetalleCuentas(String detEmpresa, String detTipo, String detSector, String detPiscina, String detCuenta) {
        this.invProductoTipoDetalleCuentasPK = new InvProductoTipoDetalleCuentasPK(detEmpresa, detTipo, detSector, detPiscina, detCuenta);
    }

    public InvProductoTipoDetalleCuentasPK getInvProductoTipoDetalleCuentasPK() {
        return invProductoTipoDetalleCuentasPK;
    }

    public void setInvProductoTipoDetalleCuentasPK(InvProductoTipoDetalleCuentasPK invProductoTipoDetalleCuentasPK) {
        this.invProductoTipoDetalleCuentasPK = invProductoTipoDetalleCuentasPK;
    }

    public String getPisEmpresa() {
        return pisEmpresa;
    }

    public void setPisEmpresa(String pisEmpresa) {
        this.pisEmpresa = pisEmpresa;
    }

    public String getPisSector() {
        return pisSector;
    }

    public void setPisSector(String pisSector) {
        this.pisSector = pisSector;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getCtaCodigo() {
        return ctaCodigo;
    }

    public void setCtaCodigo(String ctaCodigo) {
        this.ctaCodigo = ctaCodigo;
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

    public InvProductoTipo getInvProductoTipo() {
        return invProductoTipo;
    }

    public void setInvProductoTipo(InvProductoTipo invProductoTipo) {
        this.invProductoTipo = invProductoTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invProductoTipoDetalleCuentasPK != null ? invProductoTipoDetalleCuentasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoTipoDetalleCuentas)) {
            return false;
        }
        InvProductoTipoDetalleCuentas other = (InvProductoTipoDetalleCuentas) object;
        if ((this.invProductoTipoDetalleCuentasPK == null && other.invProductoTipoDetalleCuentasPK != null) || (this.invProductoTipoDetalleCuentasPK != null && !this.invProductoTipoDetalleCuentasPK.equals(other.invProductoTipoDetalleCuentasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoTipoDetalleCuentas[ invProductoTipoDetalleCuentasPK=" + invProductoTipoDetalleCuentasPK + " ]";
    }
    
}
