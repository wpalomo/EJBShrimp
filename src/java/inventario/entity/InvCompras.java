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
@Table(name = "inv_compras", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvCompras.findAll", query = "SELECT i FROM InvCompras i"),
    @NamedQuery(name = "InvCompras.findByCompEmpresa", query = "SELECT i FROM InvCompras i WHERE i.invComprasPK.compEmpresa = :compEmpresa"),
    @NamedQuery(name = "InvCompras.findByCompPeriodo", query = "SELECT i FROM InvCompras i WHERE i.invComprasPK.compPeriodo = :compPeriodo"),
    @NamedQuery(name = "InvCompras.findByCompMotivo", query = "SELECT i FROM InvCompras i WHERE i.invComprasPK.compMotivo = :compMotivo"),
    @NamedQuery(name = "InvCompras.findByCompNumero", query = "SELECT i FROM InvCompras i WHERE i.invComprasPK.compNumero = :compNumero"),
    @NamedQuery(name = "InvCompras.findByCompNumeroAlterno", query = "SELECT i FROM InvCompras i WHERE i.compNumeroAlterno = :compNumeroAlterno"),
    @NamedQuery(name = "InvCompras.findByCompDocumentoEmpresa", query = "SELECT i FROM InvCompras i WHERE i.compDocumentoEmpresa = :compDocumentoEmpresa"),
    @NamedQuery(name = "InvCompras.findByCompDocumentoProveedor", query = "SELECT i FROM InvCompras i WHERE i.compDocumentoProveedor = :compDocumentoProveedor"),
    @NamedQuery(name = "InvCompras.findByCompDocumentoTipo", query = "SELECT i FROM InvCompras i WHERE i.compDocumentoTipo = :compDocumentoTipo"),
    @NamedQuery(name = "InvCompras.findByCompDocumentoNumero", query = "SELECT i FROM InvCompras i WHERE i.compDocumentoNumero = :compDocumentoNumero"),
    @NamedQuery(name = "InvCompras.findByCompFecha", query = "SELECT i FROM InvCompras i WHERE i.compFecha = :compFecha"),
    @NamedQuery(name = "InvCompras.findByCompFechaVencimiento", query = "SELECT i FROM InvCompras i WHERE i.compFechaVencimiento = :compFechaVencimiento"),
    @NamedQuery(name = "InvCompras.findByCompIvaVigente", query = "SELECT i FROM InvCompras i WHERE i.compIvaVigente = :compIvaVigente"),
    @NamedQuery(name = "InvCompras.findByCompObservaciones", query = "SELECT i FROM InvCompras i WHERE i.compObservaciones = :compObservaciones"),
    @NamedQuery(name = "InvCompras.findByCompElectronica", query = "SELECT i FROM InvCompras i WHERE i.compElectronica = :compElectronica"),
    @NamedQuery(name = "InvCompras.findByCompActivoFijo", query = "SELECT i FROM InvCompras i WHERE i.compActivoFijo = :compActivoFijo"),
    @NamedQuery(name = "InvCompras.findByCompImportacion", query = "SELECT i FROM InvCompras i WHERE i.compImportacion = :compImportacion"),
    @NamedQuery(name = "InvCompras.findByCompPendiente", query = "SELECT i FROM InvCompras i WHERE i.compPendiente = :compPendiente"),
    @NamedQuery(name = "InvCompras.findByCompRevisado", query = "SELECT i FROM InvCompras i WHERE i.compRevisado = :compRevisado"),
    @NamedQuery(name = "InvCompras.findByCompAnulado", query = "SELECT i FROM InvCompras i WHERE i.compAnulado = :compAnulado"),
    @NamedQuery(name = "InvCompras.findByCompFormaPago", query = "SELECT i FROM InvCompras i WHERE i.compFormaPago = :compFormaPago"),
    @NamedQuery(name = "InvCompras.findByCompDocumentoFormaPago", query = "SELECT i FROM InvCompras i WHERE i.compDocumentoFormaPago = :compDocumentoFormaPago"),
    @NamedQuery(name = "InvCompras.findByCompBase0", query = "SELECT i FROM InvCompras i WHERE i.compBase0 = :compBase0"),
    @NamedQuery(name = "InvCompras.findByCompBaseImponible", query = "SELECT i FROM InvCompras i WHERE i.compBaseImponible = :compBaseImponible"),
    @NamedQuery(name = "InvCompras.findByCompBaseNoObjeto", query = "SELECT i FROM InvCompras i WHERE i.compBaseNoObjeto = :compBaseNoObjeto"),
    @NamedQuery(name = "InvCompras.findByCompBaseExenta", query = "SELECT i FROM InvCompras i WHERE i.compBaseExenta = :compBaseExenta"),
    @NamedQuery(name = "InvCompras.findByCompMontoIva", query = "SELECT i FROM InvCompras i WHERE i.compMontoIva = :compMontoIva"),
    @NamedQuery(name = "InvCompras.findByCompOtrosImpuestos", query = "SELECT i FROM InvCompras i WHERE i.compOtrosImpuestos = :compOtrosImpuestos"),
    @NamedQuery(name = "InvCompras.findByCompTotal", query = "SELECT i FROM InvCompras i WHERE i.compTotal = :compTotal"),
    @NamedQuery(name = "InvCompras.findByCompValorRetenido", query = "SELECT i FROM InvCompras i WHERE i.compValorRetenido = :compValorRetenido"),
    @NamedQuery(name = "InvCompras.findByCompRetencionAsumida", query = "SELECT i FROM InvCompras i WHERE i.compRetencionAsumida = :compRetencionAsumida"),
    @NamedQuery(name = "InvCompras.findByCompSaldo", query = "SELECT i FROM InvCompras i WHERE i.compSaldo = :compSaldo"),
    @NamedQuery(name = "InvCompras.findBySecEmpresa", query = "SELECT i FROM InvCompras i WHERE i.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "InvCompras.findBySecCodigo", query = "SELECT i FROM InvCompras i WHERE i.secCodigo = :secCodigo"),
    @NamedQuery(name = "InvCompras.findByCtaEmpresa", query = "SELECT i FROM InvCompras i WHERE i.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "InvCompras.findByCtaCodigo", query = "SELECT i FROM InvCompras i WHERE i.ctaCodigo = :ctaCodigo"),
    @NamedQuery(name = "InvCompras.findByConEmpresa", query = "SELECT i FROM InvCompras i WHERE i.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "InvCompras.findByConPeriodo", query = "SELECT i FROM InvCompras i WHERE i.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "InvCompras.findByConTipo", query = "SELECT i FROM InvCompras i WHERE i.conTipo = :conTipo"),
    @NamedQuery(name = "InvCompras.findByConNumero", query = "SELECT i FROM InvCompras i WHERE i.conNumero = :conNumero"),
    @NamedQuery(name = "InvCompras.findByEmpCodigo", query = "SELECT i FROM InvCompras i WHERE i.empCodigo = :empCodigo"),
    @NamedQuery(name = "InvCompras.findByUsrCodigo", query = "SELECT i FROM InvCompras i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvCompras.findByUsrFechaInserta", query = "SELECT i FROM InvCompras i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvCompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvComprasPK invComprasPK;
    @Basic(optional = false)
    @Column(name = "comp_numero_alterno")
    private String compNumeroAlterno;
    @Column(name = "comp_documento_empresa")
    private String compDocumentoEmpresa;
    @Column(name = "comp_documento_proveedor")
    private String compDocumentoProveedor;
    @Column(name = "comp_documento_tipo")
    private String compDocumentoTipo;
    @Column(name = "comp_documento_numero")
    private String compDocumentoNumero;
    @Basic(optional = false)
    @Column(name = "comp_fecha")
    @Temporal(TemporalType.DATE)
    private Date compFecha;
    @Basic(optional = false)
    @Column(name = "comp_fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date compFechaVencimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "comp_iva_vigente")
    private BigDecimal compIvaVigente;
    @Column(name = "comp_observaciones")
    private String compObservaciones;
    @Basic(optional = false)
    @Column(name = "comp_electronica")
    private boolean compElectronica;
    @Basic(optional = false)
    @Column(name = "comp_activo_fijo")
    private boolean compActivoFijo;
    @Basic(optional = false)
    @Column(name = "comp_importacion")
    private boolean compImportacion;
    @Basic(optional = false)
    @Column(name = "comp_pendiente")
    private boolean compPendiente;
    @Basic(optional = false)
    @Column(name = "comp_revisado")
    private boolean compRevisado;
    @Basic(optional = false)
    @Column(name = "comp_anulado")
    private boolean compAnulado;
    @Column(name = "comp_forma_pago")
    private String compFormaPago;
    @Column(name = "comp_documento_forma_pago")
    private String compDocumentoFormaPago;
    @Basic(optional = false)
    @Column(name = "comp_base0")
    private BigDecimal compBase0;
    @Basic(optional = false)
    @Column(name = "comp_base_imponible")
    private BigDecimal compBaseImponible;
    @Basic(optional = false)
    @Column(name = "comp_base_no_objeto")
    private BigDecimal compBaseNoObjeto;
    @Basic(optional = false)
    @Column(name = "comp_base_exenta")
    private BigDecimal compBaseExenta;
    @Basic(optional = false)
    @Column(name = "comp_monto_iva")
    private BigDecimal compMontoIva;
    @Basic(optional = false)
    @Column(name = "comp_otros_impuestos")
    private BigDecimal compOtrosImpuestos;
    @Basic(optional = false)
    @Column(name = "comp_total")
    private BigDecimal compTotal;
    @Basic(optional = false)
    @Column(name = "comp_valor_retenido")
    private BigDecimal compValorRetenido;
    @Column(name = "comp_retencion_asumida")
    private Boolean compRetencionAsumida;
    @Basic(optional = false)
    @Column(name = "comp_saldo")
    private BigDecimal compSaldo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invCompras")
    private List<InvComprasRecepcion> invComprasRecepcionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invCompras")
    private List<InvComprasMotivoAnulacion> invComprasMotivoAnulacionList;
    @JoinColumns({
        @JoinColumn(name = "prov_empresa", referencedColumnName = "prov_empresa"),
        @JoinColumn(name = "prov_codigo", referencedColumnName = "prov_codigo")})
    @ManyToOne(optional = false)
    private InvProveedor invProveedor;
    @JoinColumns({
        @JoinColumn(name = "bod_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne
    private InvBodega invBodega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invCompras")
    private List<InvComprasDetalle> invComprasDetalleList;

    public InvCompras() {
    }

    public InvCompras(InvComprasPK invComprasPK) {
        this.invComprasPK = invComprasPK;
    }

    public InvCompras(InvComprasPK invComprasPK, String compNumeroAlterno, Date compFecha, Date compFechaVencimiento, BigDecimal compIvaVigente, boolean compElectronica, boolean compActivoFijo, boolean compImportacion, boolean compPendiente, boolean compRevisado, boolean compAnulado, BigDecimal compBase0, BigDecimal compBaseImponible, BigDecimal compBaseNoObjeto, BigDecimal compBaseExenta, BigDecimal compMontoIva, BigDecimal compOtrosImpuestos, BigDecimal compTotal, BigDecimal compValorRetenido, BigDecimal compSaldo, String secEmpresa, String secCodigo, String empCodigo, String usrCodigo, Date usrFechaInserta) {
        this.invComprasPK = invComprasPK;
        this.compNumeroAlterno = compNumeroAlterno;
        this.compFecha = compFecha;
        this.compFechaVencimiento = compFechaVencimiento;
        this.compIvaVigente = compIvaVigente;
        this.compElectronica = compElectronica;
        this.compActivoFijo = compActivoFijo;
        this.compImportacion = compImportacion;
        this.compPendiente = compPendiente;
        this.compRevisado = compRevisado;
        this.compAnulado = compAnulado;
        this.compBase0 = compBase0;
        this.compBaseImponible = compBaseImponible;
        this.compBaseNoObjeto = compBaseNoObjeto;
        this.compBaseExenta = compBaseExenta;
        this.compMontoIva = compMontoIva;
        this.compOtrosImpuestos = compOtrosImpuestos;
        this.compTotal = compTotal;
        this.compValorRetenido = compValorRetenido;
        this.compSaldo = compSaldo;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.empCodigo = empCodigo;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvCompras(String compEmpresa, String compPeriodo, String compMotivo, String compNumero) {
        this.invComprasPK = new InvComprasPK(compEmpresa, compPeriodo, compMotivo, compNumero);
    }

    public InvComprasPK getInvComprasPK() {
        return invComprasPK;
    }

    public void setInvComprasPK(InvComprasPK invComprasPK) {
        this.invComprasPK = invComprasPK;
    }

    public String getCompNumeroAlterno() {
        return compNumeroAlterno;
    }

    public void setCompNumeroAlterno(String compNumeroAlterno) {
        this.compNumeroAlterno = compNumeroAlterno;
    }

    public String getCompDocumentoEmpresa() {
        return compDocumentoEmpresa;
    }

    public void setCompDocumentoEmpresa(String compDocumentoEmpresa) {
        this.compDocumentoEmpresa = compDocumentoEmpresa;
    }

    public String getCompDocumentoProveedor() {
        return compDocumentoProveedor;
    }

    public void setCompDocumentoProveedor(String compDocumentoProveedor) {
        this.compDocumentoProveedor = compDocumentoProveedor;
    }

    public String getCompDocumentoTipo() {
        return compDocumentoTipo;
    }

    public void setCompDocumentoTipo(String compDocumentoTipo) {
        this.compDocumentoTipo = compDocumentoTipo;
    }

    public String getCompDocumentoNumero() {
        return compDocumentoNumero;
    }

    public void setCompDocumentoNumero(String compDocumentoNumero) {
        this.compDocumentoNumero = compDocumentoNumero;
    }

    public Date getCompFecha() {
        return compFecha;
    }

    public void setCompFecha(Date compFecha) {
        this.compFecha = compFecha;
    }

    public Date getCompFechaVencimiento() {
        return compFechaVencimiento;
    }

    public void setCompFechaVencimiento(Date compFechaVencimiento) {
        this.compFechaVencimiento = compFechaVencimiento;
    }

    public BigDecimal getCompIvaVigente() {
        return compIvaVigente;
    }

    public void setCompIvaVigente(BigDecimal compIvaVigente) {
        this.compIvaVigente = compIvaVigente;
    }

    public String getCompObservaciones() {
        return compObservaciones;
    }

    public void setCompObservaciones(String compObservaciones) {
        this.compObservaciones = compObservaciones;
    }

    public boolean getCompElectronica() {
        return compElectronica;
    }

    public void setCompElectronica(boolean compElectronica) {
        this.compElectronica = compElectronica;
    }

    public boolean getCompActivoFijo() {
        return compActivoFijo;
    }

    public void setCompActivoFijo(boolean compActivoFijo) {
        this.compActivoFijo = compActivoFijo;
    }

    public boolean getCompImportacion() {
        return compImportacion;
    }

    public void setCompImportacion(boolean compImportacion) {
        this.compImportacion = compImportacion;
    }

    public boolean getCompPendiente() {
        return compPendiente;
    }

    public void setCompPendiente(boolean compPendiente) {
        this.compPendiente = compPendiente;
    }

    public boolean getCompRevisado() {
        return compRevisado;
    }

    public void setCompRevisado(boolean compRevisado) {
        this.compRevisado = compRevisado;
    }

    public boolean getCompAnulado() {
        return compAnulado;
    }

    public void setCompAnulado(boolean compAnulado) {
        this.compAnulado = compAnulado;
    }

    public String getCompFormaPago() {
        return compFormaPago;
    }

    public void setCompFormaPago(String compFormaPago) {
        this.compFormaPago = compFormaPago;
    }

    public String getCompDocumentoFormaPago() {
        return compDocumentoFormaPago;
    }

    public void setCompDocumentoFormaPago(String compDocumentoFormaPago) {
        this.compDocumentoFormaPago = compDocumentoFormaPago;
    }

    public BigDecimal getCompBase0() {
        return compBase0;
    }

    public void setCompBase0(BigDecimal compBase0) {
        this.compBase0 = compBase0;
    }

    public BigDecimal getCompBaseImponible() {
        return compBaseImponible;
    }

    public void setCompBaseImponible(BigDecimal compBaseImponible) {
        this.compBaseImponible = compBaseImponible;
    }

    public BigDecimal getCompBaseNoObjeto() {
        return compBaseNoObjeto;
    }

    public void setCompBaseNoObjeto(BigDecimal compBaseNoObjeto) {
        this.compBaseNoObjeto = compBaseNoObjeto;
    }

    public BigDecimal getCompBaseExenta() {
        return compBaseExenta;
    }

    public void setCompBaseExenta(BigDecimal compBaseExenta) {
        this.compBaseExenta = compBaseExenta;
    }

    public BigDecimal getCompMontoIva() {
        return compMontoIva;
    }

    public void setCompMontoIva(BigDecimal compMontoIva) {
        this.compMontoIva = compMontoIva;
    }

    public BigDecimal getCompOtrosImpuestos() {
        return compOtrosImpuestos;
    }

    public void setCompOtrosImpuestos(BigDecimal compOtrosImpuestos) {
        this.compOtrosImpuestos = compOtrosImpuestos;
    }

    public BigDecimal getCompTotal() {
        return compTotal;
    }

    public void setCompTotal(BigDecimal compTotal) {
        this.compTotal = compTotal;
    }

    public BigDecimal getCompValorRetenido() {
        return compValorRetenido;
    }

    public void setCompValorRetenido(BigDecimal compValorRetenido) {
        this.compValorRetenido = compValorRetenido;
    }

    public Boolean getCompRetencionAsumida() {
        return compRetencionAsumida;
    }

    public void setCompRetencionAsumida(Boolean compRetencionAsumida) {
        this.compRetencionAsumida = compRetencionAsumida;
    }

    public BigDecimal getCompSaldo() {
        return compSaldo;
    }

    public void setCompSaldo(BigDecimal compSaldo) {
        this.compSaldo = compSaldo;
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

    public List<InvComprasRecepcion> getInvComprasRecepcionList() {
        return invComprasRecepcionList;
    }

    public void setInvComprasRecepcionList(List<InvComprasRecepcion> invComprasRecepcionList) {
        this.invComprasRecepcionList = invComprasRecepcionList;
    }

    public List<InvComprasMotivoAnulacion> getInvComprasMotivoAnulacionList() {
        return invComprasMotivoAnulacionList;
    }

    public void setInvComprasMotivoAnulacionList(List<InvComprasMotivoAnulacion> invComprasMotivoAnulacionList) {
        this.invComprasMotivoAnulacionList = invComprasMotivoAnulacionList;
    }

    public InvProveedor getInvProveedor() {
        return invProveedor;
    }

    public void setInvProveedor(InvProveedor invProveedor) {
        this.invProveedor = invProveedor;
    }

    public InvBodega getInvBodega() {
        return invBodega;
    }

    public void setInvBodega(InvBodega invBodega) {
        this.invBodega = invBodega;
    }

    public List<InvComprasDetalle> getInvComprasDetalleList() {
        return invComprasDetalleList;
    }

    public void setInvComprasDetalleList(List<InvComprasDetalle> invComprasDetalleList) {
        this.invComprasDetalleList = invComprasDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invComprasPK != null ? invComprasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvCompras)) {
            return false;
        }
        InvCompras other = (InvCompras) object;
        if ((this.invComprasPK == null && other.invComprasPK != null) || (this.invComprasPK != null && !this.invComprasPK.equals(other.invComprasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvCompras[ invComprasPK=" + invComprasPK + " ]";
    }
    
}
