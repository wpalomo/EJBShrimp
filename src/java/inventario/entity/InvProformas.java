/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_proformas", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProformas.findAll", query = "SELECT i FROM InvProformas i"),
    @NamedQuery(name = "InvProformas.findByProfEmpresa", query = "SELECT i FROM InvProformas i WHERE i.invProformasPK.profEmpresa = :profEmpresa"),
    @NamedQuery(name = "InvProformas.findByProfPeriodo", query = "SELECT i FROM InvProformas i WHERE i.invProformasPK.profPeriodo = :profPeriodo"),
    @NamedQuery(name = "InvProformas.findByProfMotivo", query = "SELECT i FROM InvProformas i WHERE i.invProformasPK.profMotivo = :profMotivo"),
    @NamedQuery(name = "InvProformas.findByProfNumero", query = "SELECT i FROM InvProformas i WHERE i.invProformasPK.profNumero = :profNumero"),
    @NamedQuery(name = "InvProformas.findByProfFecha", query = "SELECT i FROM InvProformas i WHERE i.profFecha = :profFecha"),
    @NamedQuery(name = "InvProformas.findByProfIvaVigente", query = "SELECT i FROM InvProformas i WHERE i.profIvaVigente = :profIvaVigente"),
    @NamedQuery(name = "InvProformas.findByProfObservaciones", query = "SELECT i FROM InvProformas i WHERE i.profObservaciones = :profObservaciones"),
    @NamedQuery(name = "InvProformas.findByProfPendiente", query = "SELECT i FROM InvProformas i WHERE i.profPendiente = :profPendiente"),
    @NamedQuery(name = "InvProformas.findByProfAnulado", query = "SELECT i FROM InvProformas i WHERE i.profAnulado = :profAnulado"),
    @NamedQuery(name = "InvProformas.findByProfBase0", query = "SELECT i FROM InvProformas i WHERE i.profBase0 = :profBase0"),
    @NamedQuery(name = "InvProformas.findByProfBaseimponible", query = "SELECT i FROM InvProformas i WHERE i.profBaseimponible = :profBaseimponible"),
    @NamedQuery(name = "InvProformas.findByProfDescuentoBase0", query = "SELECT i FROM InvProformas i WHERE i.profDescuentoBase0 = :profDescuentoBase0"),
    @NamedQuery(name = "InvProformas.findByProfDescuentoBaseimponible", query = "SELECT i FROM InvProformas i WHERE i.profDescuentoBaseimponible = :profDescuentoBaseimponible"),
    @NamedQuery(name = "InvProformas.findByProfSubtotalBase0", query = "SELECT i FROM InvProformas i WHERE i.profSubtotalBase0 = :profSubtotalBase0"),
    @NamedQuery(name = "InvProformas.findByProfSubtotalBaseimponible", query = "SELECT i FROM InvProformas i WHERE i.profSubtotalBaseimponible = :profSubtotalBaseimponible"),
    @NamedQuery(name = "InvProformas.findByProfMontoiva", query = "SELECT i FROM InvProformas i WHERE i.profMontoiva = :profMontoiva"),
    @NamedQuery(name = "InvProformas.findByProfTotal", query = "SELECT i FROM InvProformas i WHERE i.profTotal = :profTotal"),
    @NamedQuery(name = "InvProformas.findByUsrEmpresa", query = "SELECT i FROM InvProformas i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProformas.findByUsrCodigo", query = "SELECT i FROM InvProformas i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProformas.findByUsrFechaInserta", query = "SELECT i FROM InvProformas i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProformas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProformasPK invProformasPK;
    @Basic(optional = false)
    @Column(name = "prof_fecha")
    @Temporal(TemporalType.DATE)
    private Date profFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "prof_iva_vigente")
    private BigDecimal profIvaVigente;
    @Column(name = "prof_observaciones")
    private String profObservaciones;
    @Basic(optional = false)
    @Column(name = "prof_pendiente")
    private boolean profPendiente;
    @Basic(optional = false)
    @Column(name = "prof_anulado")
    private boolean profAnulado;
    @Basic(optional = false)
    @Column(name = "prof_base0")
    private BigDecimal profBase0;
    @Basic(optional = false)
    @Column(name = "prof_baseimponible")
    private BigDecimal profBaseimponible;
    @Basic(optional = false)
    @Column(name = "prof_descuento_base0")
    private BigDecimal profDescuentoBase0;
    @Basic(optional = false)
    @Column(name = "prof_descuento_baseimponible")
    private BigDecimal profDescuentoBaseimponible;
    @Basic(optional = false)
    @Column(name = "prof_subtotal_base0")
    private BigDecimal profSubtotalBase0;
    @Basic(optional = false)
    @Column(name = "prof_subtotal_baseimponible")
    private BigDecimal profSubtotalBaseimponible;
    @Basic(optional = false)
    @Column(name = "prof_montoiva")
    private BigDecimal profMontoiva;
    @Basic(optional = false)
    @Column(name = "prof_total")
    private BigDecimal profTotal;
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
        @JoinColumn(name = "cli_empresa", referencedColumnName = "cli_empresa"),
        @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo")})
    @ManyToOne(optional = false)
    private InvCliente invCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProformas")
    private List<InvProformasDetalle> invProformasDetalleList;

    public InvProformas() {
    }

    public InvProformas(InvProformasPK invProformasPK) {
        this.invProformasPK = invProformasPK;
    }

    public InvProformas(InvProformasPK invProformasPK, Date profFecha, BigDecimal profIvaVigente, boolean profPendiente, boolean profAnulado, BigDecimal profBase0, BigDecimal profBaseimponible, BigDecimal profDescuentoBase0, BigDecimal profDescuentoBaseimponible, BigDecimal profSubtotalBase0, BigDecimal profSubtotalBaseimponible, BigDecimal profMontoiva, BigDecimal profTotal, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invProformasPK = invProformasPK;
        this.profFecha = profFecha;
        this.profIvaVigente = profIvaVigente;
        this.profPendiente = profPendiente;
        this.profAnulado = profAnulado;
        this.profBase0 = profBase0;
        this.profBaseimponible = profBaseimponible;
        this.profDescuentoBase0 = profDescuentoBase0;
        this.profDescuentoBaseimponible = profDescuentoBaseimponible;
        this.profSubtotalBase0 = profSubtotalBase0;
        this.profSubtotalBaseimponible = profSubtotalBaseimponible;
        this.profMontoiva = profMontoiva;
        this.profTotal = profTotal;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvProformas(String profEmpresa, String profPeriodo, String profMotivo, String profNumero) {
        this.invProformasPK = new InvProformasPK(profEmpresa, profPeriodo, profMotivo, profNumero);
    }

    public InvProformasPK getInvProformasPK() {
        return invProformasPK;
    }

    public void setInvProformasPK(InvProformasPK invProformasPK) {
        this.invProformasPK = invProformasPK;
    }

    public Date getProfFecha() {
        return profFecha;
    }

    public void setProfFecha(Date profFecha) {
        this.profFecha = profFecha;
    }

    public BigDecimal getProfIvaVigente() {
        return profIvaVigente;
    }

    public void setProfIvaVigente(BigDecimal profIvaVigente) {
        this.profIvaVigente = profIvaVigente;
    }

    public String getProfObservaciones() {
        return profObservaciones;
    }

    public void setProfObservaciones(String profObservaciones) {
        this.profObservaciones = profObservaciones;
    }

    public boolean getProfPendiente() {
        return profPendiente;
    }

    public void setProfPendiente(boolean profPendiente) {
        this.profPendiente = profPendiente;
    }

    public boolean getProfAnulado() {
        return profAnulado;
    }

    public void setProfAnulado(boolean profAnulado) {
        this.profAnulado = profAnulado;
    }

    public BigDecimal getProfBase0() {
        return profBase0;
    }

    public void setProfBase0(BigDecimal profBase0) {
        this.profBase0 = profBase0;
    }

    public BigDecimal getProfBaseimponible() {
        return profBaseimponible;
    }

    public void setProfBaseimponible(BigDecimal profBaseimponible) {
        this.profBaseimponible = profBaseimponible;
    }

    public BigDecimal getProfDescuentoBase0() {
        return profDescuentoBase0;
    }

    public void setProfDescuentoBase0(BigDecimal profDescuentoBase0) {
        this.profDescuentoBase0 = profDescuentoBase0;
    }

    public BigDecimal getProfDescuentoBaseimponible() {
        return profDescuentoBaseimponible;
    }

    public void setProfDescuentoBaseimponible(BigDecimal profDescuentoBaseimponible) {
        this.profDescuentoBaseimponible = profDescuentoBaseimponible;
    }

    public BigDecimal getProfSubtotalBase0() {
        return profSubtotalBase0;
    }

    public void setProfSubtotalBase0(BigDecimal profSubtotalBase0) {
        this.profSubtotalBase0 = profSubtotalBase0;
    }

    public BigDecimal getProfSubtotalBaseimponible() {
        return profSubtotalBaseimponible;
    }

    public void setProfSubtotalBaseimponible(BigDecimal profSubtotalBaseimponible) {
        this.profSubtotalBaseimponible = profSubtotalBaseimponible;
    }

    public BigDecimal getProfMontoiva() {
        return profMontoiva;
    }

    public void setProfMontoiva(BigDecimal profMontoiva) {
        this.profMontoiva = profMontoiva;
    }

    public BigDecimal getProfTotal() {
        return profTotal;
    }

    public void setProfTotal(BigDecimal profTotal) {
        this.profTotal = profTotal;
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

    public InvCliente getInvCliente() {
        return invCliente;
    }

    public void setInvCliente(InvCliente invCliente) {
        this.invCliente = invCliente;
    }

    public List<InvProformasDetalle> getInvProformasDetalleList() {
        return invProformasDetalleList;
    }

    public void setInvProformasDetalleList(List<InvProformasDetalle> invProformasDetalleList) {
        this.invProformasDetalleList = invProformasDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invProformasPK != null ? invProformasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProformas)) {
            return false;
        }
        InvProformas other = (InvProformas) object;
        if ((this.invProformasPK == null && other.invProformasPK != null) || (this.invProformasPK != null && !this.invProformasPK.equals(other.invProformasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProformas[ invProformasPK=" + invProformasPK + " ]";
    }
    
}
