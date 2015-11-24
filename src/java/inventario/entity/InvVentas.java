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
@Table(name = "inv_ventas", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvVentas.findAll", query = "SELECT i FROM InvVentas i"),
    @NamedQuery(name = "InvVentas.findByVtaEmpresa", query = "SELECT i FROM InvVentas i WHERE i.invVentasPK.vtaEmpresa = :vtaEmpresa"),
    @NamedQuery(name = "InvVentas.findByVtaPeriodo", query = "SELECT i FROM InvVentas i WHERE i.invVentasPK.vtaPeriodo = :vtaPeriodo"),
    @NamedQuery(name = "InvVentas.findByVtaMotivo", query = "SELECT i FROM InvVentas i WHERE i.invVentasPK.vtaMotivo = :vtaMotivo"),
    @NamedQuery(name = "InvVentas.findByVtaNumero", query = "SELECT i FROM InvVentas i WHERE i.invVentasPK.vtaNumero = :vtaNumero"),
    @NamedQuery(name = "InvVentas.findByVtaNumeroAlterno", query = "SELECT i FROM InvVentas i WHERE i.vtaNumeroAlterno = :vtaNumeroAlterno"),
    @NamedQuery(name = "InvVentas.findByVtaDocumentoEmpresa", query = "SELECT i FROM InvVentas i WHERE i.vtaDocumentoEmpresa = :vtaDocumentoEmpresa"),
    @NamedQuery(name = "InvVentas.findByVtaDocumentoTipo", query = "SELECT i FROM InvVentas i WHERE i.vtaDocumentoTipo = :vtaDocumentoTipo"),
    @NamedQuery(name = "InvVentas.findByVtaDocumentoNumero", query = "SELECT i FROM InvVentas i WHERE i.vtaDocumentoNumero = :vtaDocumentoNumero"),
    @NamedQuery(name = "InvVentas.findByVtaFecha", query = "SELECT i FROM InvVentas i WHERE i.vtaFecha = :vtaFecha"),
    @NamedQuery(name = "InvVentas.findByVtaFechaVencimiento", query = "SELECT i FROM InvVentas i WHERE i.vtaFechaVencimiento = :vtaFechaVencimiento"),
    @NamedQuery(name = "InvVentas.findByVtaIvaVigente", query = "SELECT i FROM InvVentas i WHERE i.vtaIvaVigente = :vtaIvaVigente"),
    @NamedQuery(name = "InvVentas.findByVtaObservaciones", query = "SELECT i FROM InvVentas i WHERE i.vtaObservaciones = :vtaObservaciones"),
    @NamedQuery(name = "InvVentas.findByVtaInformacionAdicional", query = "SELECT i FROM InvVentas i WHERE i.vtaInformacionAdicional = :vtaInformacionAdicional"),
    @NamedQuery(name = "InvVentas.findByVtaPendiente", query = "SELECT i FROM InvVentas i WHERE i.vtaPendiente = :vtaPendiente"),
    @NamedQuery(name = "InvVentas.findByVtaRevisado", query = "SELECT i FROM InvVentas i WHERE i.vtaRevisado = :vtaRevisado"),
    @NamedQuery(name = "InvVentas.findByVtaAnulado", query = "SELECT i FROM InvVentas i WHERE i.vtaAnulado = :vtaAnulado"),
    @NamedQuery(name = "InvVentas.findByVtaFormaPago", query = "SELECT i FROM InvVentas i WHERE i.vtaFormaPago = :vtaFormaPago"),
    @NamedQuery(name = "InvVentas.findByVtaBase0", query = "SELECT i FROM InvVentas i WHERE i.vtaBase0 = :vtaBase0"),
    @NamedQuery(name = "InvVentas.findByVtaBaseImponible", query = "SELECT i FROM InvVentas i WHERE i.vtaBaseImponible = :vtaBaseImponible"),
    @NamedQuery(name = "InvVentas.findByVtaBaseNoObjeto", query = "SELECT i FROM InvVentas i WHERE i.vtaBaseNoObjeto = :vtaBaseNoObjeto"),
    @NamedQuery(name = "InvVentas.findByVtaBaseExenta", query = "SELECT i FROM InvVentas i WHERE i.vtaBaseExenta = :vtaBaseExenta"),
    @NamedQuery(name = "InvVentas.findByVtaDescuentoBase0", query = "SELECT i FROM InvVentas i WHERE i.vtaDescuentoBase0 = :vtaDescuentoBase0"),
    @NamedQuery(name = "InvVentas.findByVtaDescuentoBaseImponible", query = "SELECT i FROM InvVentas i WHERE i.vtaDescuentoBaseImponible = :vtaDescuentoBaseImponible"),
    @NamedQuery(name = "InvVentas.findByVtaDescuentoBaseNoObjeto", query = "SELECT i FROM InvVentas i WHERE i.vtaDescuentoBaseNoObjeto = :vtaDescuentoBaseNoObjeto"),
    @NamedQuery(name = "InvVentas.findByVtaDescuentoBaseExenta", query = "SELECT i FROM InvVentas i WHERE i.vtaDescuentoBaseExenta = :vtaDescuentoBaseExenta"),
    @NamedQuery(name = "InvVentas.findByVtaSubtotalBase0", query = "SELECT i FROM InvVentas i WHERE i.vtaSubtotalBase0 = :vtaSubtotalBase0"),
    @NamedQuery(name = "InvVentas.findByVtaSubtotalBaseImponible", query = "SELECT i FROM InvVentas i WHERE i.vtaSubtotalBaseImponible = :vtaSubtotalBaseImponible"),
    @NamedQuery(name = "InvVentas.findByVtaSubtotalBaseNoObjeto", query = "SELECT i FROM InvVentas i WHERE i.vtaSubtotalBaseNoObjeto = :vtaSubtotalBaseNoObjeto"),
    @NamedQuery(name = "InvVentas.findByVtaSubtotalBaseExenta", query = "SELECT i FROM InvVentas i WHERE i.vtaSubtotalBaseExenta = :vtaSubtotalBaseExenta"),
    @NamedQuery(name = "InvVentas.findByVtaMontoiva", query = "SELECT i FROM InvVentas i WHERE i.vtaMontoiva = :vtaMontoiva"),
    @NamedQuery(name = "InvVentas.findByVtaTotal", query = "SELECT i FROM InvVentas i WHERE i.vtaTotal = :vtaTotal"),
    @NamedQuery(name = "InvVentas.findByVtaPagado", query = "SELECT i FROM InvVentas i WHERE i.vtaPagado = :vtaPagado"),
    @NamedQuery(name = "InvVentas.findBySecEmpresa", query = "SELECT i FROM InvVentas i WHERE i.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "InvVentas.findBySecCodigo", query = "SELECT i FROM InvVentas i WHERE i.secCodigo = :secCodigo"),
    @NamedQuery(name = "InvVentas.findByCtaEmpresa", query = "SELECT i FROM InvVentas i WHERE i.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "InvVentas.findByCtaCodigo", query = "SELECT i FROM InvVentas i WHERE i.ctaCodigo = :ctaCodigo"),
    @NamedQuery(name = "InvVentas.findByConEmpresa", query = "SELECT i FROM InvVentas i WHERE i.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "InvVentas.findByConPeriodo", query = "SELECT i FROM InvVentas i WHERE i.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "InvVentas.findByConTipo", query = "SELECT i FROM InvVentas i WHERE i.conTipo = :conTipo"),
    @NamedQuery(name = "InvVentas.findByConNumero", query = "SELECT i FROM InvVentas i WHERE i.conNumero = :conNumero"),
    @NamedQuery(name = "InvVentas.findByEmpCodigo", query = "SELECT i FROM InvVentas i WHERE i.empCodigo = :empCodigo"),
    @NamedQuery(name = "InvVentas.findByUsrCodigo", query = "SELECT i FROM InvVentas i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvVentas.findByUsrFechaInserta", query = "SELECT i FROM InvVentas i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvVentas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvVentasPK invVentasPK;
    @Basic(optional = false)
    @Column(name = "vta_numero_alterno")
    private String vtaNumeroAlterno;
    @Column(name = "vta_documento_empresa")
    private String vtaDocumentoEmpresa;
    @Column(name = "vta_documento_tipo")
    private String vtaDocumentoTipo;
    @Column(name = "vta_documento_numero")
    private String vtaDocumentoNumero;
    @Basic(optional = false)
    @Column(name = "vta_fecha")
    @Temporal(TemporalType.DATE)
    private Date vtaFecha;
    @Basic(optional = false)
    @Column(name = "vta_fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date vtaFechaVencimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vta_iva_vigente")
    private BigDecimal vtaIvaVigente;
    @Column(name = "vta_observaciones")
    private String vtaObservaciones;
    @Column(name = "vta_informacion_adicional")
    private String vtaInformacionAdicional;
    @Basic(optional = false)
    @Column(name = "vta_pendiente")
    private boolean vtaPendiente;
    @Basic(optional = false)
    @Column(name = "vta_revisado")
    private boolean vtaRevisado;
    @Basic(optional = false)
    @Column(name = "vta_anulado")
    private boolean vtaAnulado;
    @Column(name = "vta_forma_pago")
    private String vtaFormaPago;
    @Basic(optional = false)
    @Column(name = "vta_base0")
    private BigDecimal vtaBase0;
    @Basic(optional = false)
    @Column(name = "vta_base_imponible")
    private BigDecimal vtaBaseImponible;
    @Basic(optional = false)
    @Column(name = "vta_base_no_objeto")
    private BigDecimal vtaBaseNoObjeto;
    @Basic(optional = false)
    @Column(name = "vta_base_exenta")
    private BigDecimal vtaBaseExenta;
    @Basic(optional = false)
    @Column(name = "vta_descuento_base0")
    private BigDecimal vtaDescuentoBase0;
    @Basic(optional = false)
    @Column(name = "vta_descuento_base_imponible")
    private BigDecimal vtaDescuentoBaseImponible;
    @Basic(optional = false)
    @Column(name = "vta_descuento_base_no_objeto")
    private BigDecimal vtaDescuentoBaseNoObjeto;
    @Basic(optional = false)
    @Column(name = "vta_descuento_base_exenta")
    private BigDecimal vtaDescuentoBaseExenta;
    @Basic(optional = false)
    @Column(name = "vta_subtotal_base0")
    private BigDecimal vtaSubtotalBase0;
    @Basic(optional = false)
    @Column(name = "vta_subtotal_base_imponible")
    private BigDecimal vtaSubtotalBaseImponible;
    @Basic(optional = false)
    @Column(name = "vta_subtotal_base_no_objeto")
    private BigDecimal vtaSubtotalBaseNoObjeto;
    @Basic(optional = false)
    @Column(name = "vta_subtotal_base_exenta")
    private BigDecimal vtaSubtotalBaseExenta;
    @Basic(optional = false)
    @Column(name = "vta_montoiva")
    private BigDecimal vtaMontoiva;
    @Basic(optional = false)
    @Column(name = "vta_total")
    private BigDecimal vtaTotal;
    @Basic(optional = false)
    @Column(name = "vta_pagado")
    private BigDecimal vtaPagado;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
    @Column(name = "cta_empresa")
    private String ctaEmpresa;
    @Column(name = "cta_codigo")
    private String ctaCodigo;
    @Column(name = "con_empresa")
    private String conEmpresa;
    @Column(name = "con_periodo")
    private String conPeriodo;
    @Column(name = "con_tipo")
    private String conTipo;
    @Column(name = "con_numero")
    private String conNumero;
    @Basic(optional = false)
    @Column(name = "emp_codigo")
    private String empCodigo;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invVentas")
    private List<InvVentasDetalle> invVentasDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invVentas")
    private List<InvVentasRecepcion> invVentasRecepcionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invVentas")
    private List<InvVentasMotivoAnulacion> invVentasMotivoAnulacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invVentas")
    private List<InvVentasComplemento> invVentasComplementoList;
    @JoinColumns({
        @JoinColumn(name = "cli_empresa", referencedColumnName = "cli_empresa"),
        @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo")})
    @ManyToOne(optional = false)
    private InvCliente invCliente;
    @JoinColumns({
        @JoinColumn(name = "bod_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne
    private InvBodega invBodega;

    public InvVentas() {
    }

    public InvVentas(InvVentasPK invVentasPK) {
        this.invVentasPK = invVentasPK;
    }

    public InvVentas(InvVentasPK invVentasPK, String vtaNumeroAlterno, Date vtaFecha, Date vtaFechaVencimiento, BigDecimal vtaIvaVigente, boolean vtaPendiente, boolean vtaRevisado, boolean vtaAnulado, BigDecimal vtaBase0, BigDecimal vtaBaseImponible, BigDecimal vtaBaseNoObjeto, BigDecimal vtaBaseExenta, BigDecimal vtaDescuentoBase0, BigDecimal vtaDescuentoBaseImponible, BigDecimal vtaDescuentoBaseNoObjeto, BigDecimal vtaDescuentoBaseExenta, BigDecimal vtaSubtotalBase0, BigDecimal vtaSubtotalBaseImponible, BigDecimal vtaSubtotalBaseNoObjeto, BigDecimal vtaSubtotalBaseExenta, BigDecimal vtaMontoiva, BigDecimal vtaTotal, BigDecimal vtaPagado, String secEmpresa, String secCodigo, String empCodigo, String usrCodigo, Date usrFechaInserta) {
        this.invVentasPK = invVentasPK;
        this.vtaNumeroAlterno = vtaNumeroAlterno;
        this.vtaFecha = vtaFecha;
        this.vtaFechaVencimiento = vtaFechaVencimiento;
        this.vtaIvaVigente = vtaIvaVigente;
        this.vtaPendiente = vtaPendiente;
        this.vtaRevisado = vtaRevisado;
        this.vtaAnulado = vtaAnulado;
        this.vtaBase0 = vtaBase0;
        this.vtaBaseImponible = vtaBaseImponible;
        this.vtaBaseNoObjeto = vtaBaseNoObjeto;
        this.vtaBaseExenta = vtaBaseExenta;
        this.vtaDescuentoBase0 = vtaDescuentoBase0;
        this.vtaDescuentoBaseImponible = vtaDescuentoBaseImponible;
        this.vtaDescuentoBaseNoObjeto = vtaDescuentoBaseNoObjeto;
        this.vtaDescuentoBaseExenta = vtaDescuentoBaseExenta;
        this.vtaSubtotalBase0 = vtaSubtotalBase0;
        this.vtaSubtotalBaseImponible = vtaSubtotalBaseImponible;
        this.vtaSubtotalBaseNoObjeto = vtaSubtotalBaseNoObjeto;
        this.vtaSubtotalBaseExenta = vtaSubtotalBaseExenta;
        this.vtaMontoiva = vtaMontoiva;
        this.vtaTotal = vtaTotal;
        this.vtaPagado = vtaPagado;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.empCodigo = empCodigo;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvVentas(String vtaEmpresa, String vtaPeriodo, String vtaMotivo, String vtaNumero) {
        this.invVentasPK = new InvVentasPK(vtaEmpresa, vtaPeriodo, vtaMotivo, vtaNumero);
    }

    public InvVentasPK getInvVentasPK() {
        return invVentasPK;
    }

    public void setInvVentasPK(InvVentasPK invVentasPK) {
        this.invVentasPK = invVentasPK;
    }

    public String getVtaNumeroAlterno() {
        return vtaNumeroAlterno;
    }

    public void setVtaNumeroAlterno(String vtaNumeroAlterno) {
        this.vtaNumeroAlterno = vtaNumeroAlterno;
    }

    public String getVtaDocumentoEmpresa() {
        return vtaDocumentoEmpresa;
    }

    public void setVtaDocumentoEmpresa(String vtaDocumentoEmpresa) {
        this.vtaDocumentoEmpresa = vtaDocumentoEmpresa;
    }

    public String getVtaDocumentoTipo() {
        return vtaDocumentoTipo;
    }

    public void setVtaDocumentoTipo(String vtaDocumentoTipo) {
        this.vtaDocumentoTipo = vtaDocumentoTipo;
    }

    public String getVtaDocumentoNumero() {
        return vtaDocumentoNumero;
    }

    public void setVtaDocumentoNumero(String vtaDocumentoNumero) {
        this.vtaDocumentoNumero = vtaDocumentoNumero;
    }

    public Date getVtaFecha() {
        return vtaFecha;
    }

    public void setVtaFecha(Date vtaFecha) {
        this.vtaFecha = vtaFecha;
    }

    public Date getVtaFechaVencimiento() {
        return vtaFechaVencimiento;
    }

    public void setVtaFechaVencimiento(Date vtaFechaVencimiento) {
        this.vtaFechaVencimiento = vtaFechaVencimiento;
    }

    public BigDecimal getVtaIvaVigente() {
        return vtaIvaVigente;
    }

    public void setVtaIvaVigente(BigDecimal vtaIvaVigente) {
        this.vtaIvaVigente = vtaIvaVigente;
    }

    public String getVtaObservaciones() {
        return vtaObservaciones;
    }

    public void setVtaObservaciones(String vtaObservaciones) {
        this.vtaObservaciones = vtaObservaciones;
    }

    public String getVtaInformacionAdicional() {
        return vtaInformacionAdicional;
    }

    public void setVtaInformacionAdicional(String vtaInformacionAdicional) {
        this.vtaInformacionAdicional = vtaInformacionAdicional;
    }

    public boolean getVtaPendiente() {
        return vtaPendiente;
    }

    public void setVtaPendiente(boolean vtaPendiente) {
        this.vtaPendiente = vtaPendiente;
    }

    public boolean getVtaRevisado() {
        return vtaRevisado;
    }

    public void setVtaRevisado(boolean vtaRevisado) {
        this.vtaRevisado = vtaRevisado;
    }

    public boolean getVtaAnulado() {
        return vtaAnulado;
    }

    public void setVtaAnulado(boolean vtaAnulado) {
        this.vtaAnulado = vtaAnulado;
    }

    public String getVtaFormaPago() {
        return vtaFormaPago;
    }

    public void setVtaFormaPago(String vtaFormaPago) {
        this.vtaFormaPago = vtaFormaPago;
    }

    public BigDecimal getVtaBase0() {
        return vtaBase0;
    }

    public void setVtaBase0(BigDecimal vtaBase0) {
        this.vtaBase0 = vtaBase0;
    }

    public BigDecimal getVtaBaseImponible() {
        return vtaBaseImponible;
    }

    public void setVtaBaseImponible(BigDecimal vtaBaseImponible) {
        this.vtaBaseImponible = vtaBaseImponible;
    }

    public BigDecimal getVtaBaseNoObjeto() {
        return vtaBaseNoObjeto;
    }

    public void setVtaBaseNoObjeto(BigDecimal vtaBaseNoObjeto) {
        this.vtaBaseNoObjeto = vtaBaseNoObjeto;
    }

    public BigDecimal getVtaBaseExenta() {
        return vtaBaseExenta;
    }

    public void setVtaBaseExenta(BigDecimal vtaBaseExenta) {
        this.vtaBaseExenta = vtaBaseExenta;
    }

    public BigDecimal getVtaDescuentoBase0() {
        return vtaDescuentoBase0;
    }

    public void setVtaDescuentoBase0(BigDecimal vtaDescuentoBase0) {
        this.vtaDescuentoBase0 = vtaDescuentoBase0;
    }

    public BigDecimal getVtaDescuentoBaseImponible() {
        return vtaDescuentoBaseImponible;
    }

    public void setVtaDescuentoBaseImponible(BigDecimal vtaDescuentoBaseImponible) {
        this.vtaDescuentoBaseImponible = vtaDescuentoBaseImponible;
    }

    public BigDecimal getVtaDescuentoBaseNoObjeto() {
        return vtaDescuentoBaseNoObjeto;
    }

    public void setVtaDescuentoBaseNoObjeto(BigDecimal vtaDescuentoBaseNoObjeto) {
        this.vtaDescuentoBaseNoObjeto = vtaDescuentoBaseNoObjeto;
    }

    public BigDecimal getVtaDescuentoBaseExenta() {
        return vtaDescuentoBaseExenta;
    }

    public void setVtaDescuentoBaseExenta(BigDecimal vtaDescuentoBaseExenta) {
        this.vtaDescuentoBaseExenta = vtaDescuentoBaseExenta;
    }

    public BigDecimal getVtaSubtotalBase0() {
        return vtaSubtotalBase0;
    }

    public void setVtaSubtotalBase0(BigDecimal vtaSubtotalBase0) {
        this.vtaSubtotalBase0 = vtaSubtotalBase0;
    }

    public BigDecimal getVtaSubtotalBaseImponible() {
        return vtaSubtotalBaseImponible;
    }

    public void setVtaSubtotalBaseImponible(BigDecimal vtaSubtotalBaseImponible) {
        this.vtaSubtotalBaseImponible = vtaSubtotalBaseImponible;
    }

    public BigDecimal getVtaSubtotalBaseNoObjeto() {
        return vtaSubtotalBaseNoObjeto;
    }

    public void setVtaSubtotalBaseNoObjeto(BigDecimal vtaSubtotalBaseNoObjeto) {
        this.vtaSubtotalBaseNoObjeto = vtaSubtotalBaseNoObjeto;
    }

    public BigDecimal getVtaSubtotalBaseExenta() {
        return vtaSubtotalBaseExenta;
    }

    public void setVtaSubtotalBaseExenta(BigDecimal vtaSubtotalBaseExenta) {
        this.vtaSubtotalBaseExenta = vtaSubtotalBaseExenta;
    }

    public BigDecimal getVtaMontoiva() {
        return vtaMontoiva;
    }

    public void setVtaMontoiva(BigDecimal vtaMontoiva) {
        this.vtaMontoiva = vtaMontoiva;
    }

    public BigDecimal getVtaTotal() {
        return vtaTotal;
    }

    public void setVtaTotal(BigDecimal vtaTotal) {
        this.vtaTotal = vtaTotal;
    }

    public BigDecimal getVtaPagado() {
        return vtaPagado;
    }

    public void setVtaPagado(BigDecimal vtaPagado) {
        this.vtaPagado = vtaPagado;
    }

    public String getSecEmpresa() {
        return secEmpresa;
    }

    public void setSecEmpresa(String secEmpresa) {
        this.secEmpresa = secEmpresa;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
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

    public String getConEmpresa() {
        return conEmpresa;
    }

    public void setConEmpresa(String conEmpresa) {
        this.conEmpresa = conEmpresa;
    }

    public String getConPeriodo() {
        return conPeriodo;
    }

    public void setConPeriodo(String conPeriodo) {
        this.conPeriodo = conPeriodo;
    }

    public String getConTipo() {
        return conTipo;
    }

    public void setConTipo(String conTipo) {
        this.conTipo = conTipo;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
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

    public List<InvVentasDetalle> getInvVentasDetalleList() {
        return invVentasDetalleList;
    }

    public void setInvVentasDetalleList(List<InvVentasDetalle> invVentasDetalleList) {
        this.invVentasDetalleList = invVentasDetalleList;
    }

    public List<InvVentasRecepcion> getInvVentasRecepcionList() {
        return invVentasRecepcionList;
    }

    public void setInvVentasRecepcionList(List<InvVentasRecepcion> invVentasRecepcionList) {
        this.invVentasRecepcionList = invVentasRecepcionList;
    }

    public List<InvVentasMotivoAnulacion> getInvVentasMotivoAnulacionList() {
        return invVentasMotivoAnulacionList;
    }

    public void setInvVentasMotivoAnulacionList(List<InvVentasMotivoAnulacion> invVentasMotivoAnulacionList) {
        this.invVentasMotivoAnulacionList = invVentasMotivoAnulacionList;
    }

    public List<InvVentasComplemento> getInvVentasComplementoList() {
        return invVentasComplementoList;
    }

    public void setInvVentasComplementoList(List<InvVentasComplemento> invVentasComplementoList) {
        this.invVentasComplementoList = invVentasComplementoList;
    }

    public InvCliente getInvCliente() {
        return invCliente;
    }

    public void setInvCliente(InvCliente invCliente) {
        this.invCliente = invCliente;
    }

    public InvBodega getInvBodega() {
        return invBodega;
    }

    public void setInvBodega(InvBodega invBodega) {
        this.invBodega = invBodega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invVentasPK != null ? invVentasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentas)) {
            return false;
        }
        InvVentas other = (InvVentas) object;
        if ((this.invVentasPK == null && other.invVentasPK != null) || (this.invVentasPK != null && !this.invVentasPK.equals(other.invVentasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentas[ invVentasPK=" + invVentasPK + " ]";
    }
    
}
