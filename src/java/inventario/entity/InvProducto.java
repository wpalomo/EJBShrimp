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
@Table(name = "inv_producto", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProducto.findAll", query = "SELECT i FROM InvProducto i"),
    @NamedQuery(name = "InvProducto.findByProEmpresa", query = "SELECT i FROM InvProducto i WHERE i.invProductoPK.proEmpresa = :proEmpresa"),
    @NamedQuery(name = "InvProducto.findByProCodigoPrincipal", query = "SELECT i FROM InvProducto i WHERE i.invProductoPK.proCodigoPrincipal = :proCodigoPrincipal"),
    @NamedQuery(name = "InvProducto.findByProCodigoAlterno", query = "SELECT i FROM InvProducto i WHERE i.proCodigoAlterno = :proCodigoAlterno"),
    @NamedQuery(name = "InvProducto.findByProCodigoBarra", query = "SELECT i FROM InvProducto i WHERE i.proCodigoBarra = :proCodigoBarra"),
    @NamedQuery(name = "InvProducto.findByProCodigoBarra2", query = "SELECT i FROM InvProducto i WHERE i.proCodigoBarra2 = :proCodigoBarra2"),
    @NamedQuery(name = "InvProducto.findByProCodigoBarra3", query = "SELECT i FROM InvProducto i WHERE i.proCodigoBarra3 = :proCodigoBarra3"),
    @NamedQuery(name = "InvProducto.findByProCodigoBarra4", query = "SELECT i FROM InvProducto i WHERE i.proCodigoBarra4 = :proCodigoBarra4"),
    @NamedQuery(name = "InvProducto.findByProCodigoBarra5", query = "SELECT i FROM InvProducto i WHERE i.proCodigoBarra5 = :proCodigoBarra5"),
    @NamedQuery(name = "InvProducto.findByProEmpaque", query = "SELECT i FROM InvProducto i WHERE i.proEmpaque = :proEmpaque"),
    @NamedQuery(name = "InvProducto.findByProNombre", query = "SELECT i FROM InvProducto i WHERE i.proNombre = :proNombre"),
    @NamedQuery(name = "InvProducto.findByProDetalle", query = "SELECT i FROM InvProducto i WHERE i.proDetalle = :proDetalle"),
    @NamedQuery(name = "InvProducto.findByProCantidad1", query = "SELECT i FROM InvProducto i WHERE i.proCantidad1 = :proCantidad1"),
    @NamedQuery(name = "InvProducto.findByProCantidad2", query = "SELECT i FROM InvProducto i WHERE i.proCantidad2 = :proCantidad2"),
    @NamedQuery(name = "InvProducto.findByProCantidad3", query = "SELECT i FROM InvProducto i WHERE i.proCantidad3 = :proCantidad3"),
    @NamedQuery(name = "InvProducto.findByProCantidad4", query = "SELECT i FROM InvProducto i WHERE i.proCantidad4 = :proCantidad4"),
    @NamedQuery(name = "InvProducto.findByProCantidad5", query = "SELECT i FROM InvProducto i WHERE i.proCantidad5 = :proCantidad5"),
    @NamedQuery(name = "InvProducto.findByProPrecio1", query = "SELECT i FROM InvProducto i WHERE i.proPrecio1 = :proPrecio1"),
    @NamedQuery(name = "InvProducto.findByProPrecio2", query = "SELECT i FROM InvProducto i WHERE i.proPrecio2 = :proPrecio2"),
    @NamedQuery(name = "InvProducto.findByProPrecio3", query = "SELECT i FROM InvProducto i WHERE i.proPrecio3 = :proPrecio3"),
    @NamedQuery(name = "InvProducto.findByProPrecio4", query = "SELECT i FROM InvProducto i WHERE i.proPrecio4 = :proPrecio4"),
    @NamedQuery(name = "InvProducto.findByProPrecio5", query = "SELECT i FROM InvProducto i WHERE i.proPrecio5 = :proPrecio5"),
    @NamedQuery(name = "InvProducto.findByProDescuento1", query = "SELECT i FROM InvProducto i WHERE i.proDescuento1 = :proDescuento1"),
    @NamedQuery(name = "InvProducto.findByProDescuento2", query = "SELECT i FROM InvProducto i WHERE i.proDescuento2 = :proDescuento2"),
    @NamedQuery(name = "InvProducto.findByProDescuento3", query = "SELECT i FROM InvProducto i WHERE i.proDescuento3 = :proDescuento3"),
    @NamedQuery(name = "InvProducto.findByProDescuento4", query = "SELECT i FROM InvProducto i WHERE i.proDescuento4 = :proDescuento4"),
    @NamedQuery(name = "InvProducto.findByProDescuento5", query = "SELECT i FROM InvProducto i WHERE i.proDescuento5 = :proDescuento5"),
    @NamedQuery(name = "InvProducto.findByProMargenUtilidad1", query = "SELECT i FROM InvProducto i WHERE i.proMargenUtilidad1 = :proMargenUtilidad1"),
    @NamedQuery(name = "InvProducto.findByProMargenUtilidad2", query = "SELECT i FROM InvProducto i WHERE i.proMargenUtilidad2 = :proMargenUtilidad2"),
    @NamedQuery(name = "InvProducto.findByProMargenUtilidad3", query = "SELECT i FROM InvProducto i WHERE i.proMargenUtilidad3 = :proMargenUtilidad3"),
    @NamedQuery(name = "InvProducto.findByProMargenUtilidad4", query = "SELECT i FROM InvProducto i WHERE i.proMargenUtilidad4 = :proMargenUtilidad4"),
    @NamedQuery(name = "InvProducto.findByProMargenUtilidad5", query = "SELECT i FROM InvProducto i WHERE i.proMargenUtilidad5 = :proMargenUtilidad5"),
    @NamedQuery(name = "InvProducto.findByProMinimo", query = "SELECT i FROM InvProducto i WHERE i.proMinimo = :proMinimo"),
    @NamedQuery(name = "InvProducto.findByProMaximo", query = "SELECT i FROM InvProducto i WHERE i.proMaximo = :proMaximo"),
    @NamedQuery(name = "InvProducto.findByProIva", query = "SELECT i FROM InvProducto i WHERE i.proIva = :proIva"),
    @NamedQuery(name = "InvProducto.findByProCreditoTributario", query = "SELECT i FROM InvProducto i WHERE i.proCreditoTributario = :proCreditoTributario"),
    @NamedQuery(name = "InvProducto.findByProStockNegativo", query = "SELECT i FROM InvProducto i WHERE i.proStockNegativo = :proStockNegativo"),
    @NamedQuery(name = "InvProducto.findByProInactivo", query = "SELECT i FROM InvProducto i WHERE i.proInactivo = :proInactivo"),
    @NamedQuery(name = "InvProducto.findByProCuentaEmpresa", query = "SELECT i FROM InvProducto i WHERE i.proCuentaEmpresa = :proCuentaEmpresa"),
    @NamedQuery(name = "InvProducto.findByProCuentaInventario", query = "SELECT i FROM InvProducto i WHERE i.proCuentaInventario = :proCuentaInventario"),
    @NamedQuery(name = "InvProducto.findByProCuentaGasto", query = "SELECT i FROM InvProducto i WHERE i.proCuentaGasto = :proCuentaGasto"),
    @NamedQuery(name = "InvProducto.findByProCuentaVenta", query = "SELECT i FROM InvProducto i WHERE i.proCuentaVenta = :proCuentaVenta"),
    @NamedQuery(name = "InvProducto.findByProCuentaTransferenciaIpp", query = "SELECT i FROM InvProducto i WHERE i.proCuentaTransferenciaIpp = :proCuentaTransferenciaIpp"),
    @NamedQuery(name = "InvProducto.findByConCodigo", query = "SELECT i FROM InvProducto i WHERE i.conCodigo = :conCodigo"),
    @NamedQuery(name = "InvProducto.findBySusCodigo", query = "SELECT i FROM InvProducto i WHERE i.susCodigo = :susCodigo"),
    @NamedQuery(name = "InvProducto.findByProFactorCajaSacoBulto", query = "SELECT i FROM InvProducto i WHERE i.proFactorCajaSacoBulto = :proFactorCajaSacoBulto"),
    @NamedQuery(name = "InvProducto.findByUsrEmpresa", query = "SELECT i FROM InvProducto i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProducto.findByUsrCodigo", query = "SELECT i FROM InvProducto i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProducto.findByUsrFechaInserta", query = "SELECT i FROM InvProducto i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProductoPK invProductoPK;
    @Column(name = "pro_codigo_alterno")
    private String proCodigoAlterno;
    @Column(name = "pro_codigo_barra")
    private String proCodigoBarra;
    @Column(name = "pro_codigo_barra2")
    private String proCodigoBarra2;
    @Column(name = "pro_codigo_barra3")
    private String proCodigoBarra3;
    @Column(name = "pro_codigo_barra4")
    private String proCodigoBarra4;
    @Column(name = "pro_codigo_barra5")
    private String proCodigoBarra5;
    @Column(name = "pro_empaque")
    private String proEmpaque;
    @Basic(optional = false)
    @Column(name = "pro_nombre")
    private String proNombre;
    @Column(name = "pro_detalle")
    private String proDetalle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "pro_cantidad1")
    private BigDecimal proCantidad1;
    @Basic(optional = false)
    @Column(name = "pro_cantidad2")
    private BigDecimal proCantidad2;
    @Basic(optional = false)
    @Column(name = "pro_cantidad3")
    private BigDecimal proCantidad3;
    @Basic(optional = false)
    @Column(name = "pro_cantidad4")
    private BigDecimal proCantidad4;
    @Basic(optional = false)
    @Column(name = "pro_cantidad5")
    private BigDecimal proCantidad5;
    @Basic(optional = false)
    @Column(name = "pro_precio1")
    private BigDecimal proPrecio1;
    @Basic(optional = false)
    @Column(name = "pro_precio2")
    private BigDecimal proPrecio2;
    @Basic(optional = false)
    @Column(name = "pro_precio3")
    private BigDecimal proPrecio3;
    @Basic(optional = false)
    @Column(name = "pro_precio4")
    private BigDecimal proPrecio4;
    @Basic(optional = false)
    @Column(name = "pro_precio5")
    private BigDecimal proPrecio5;
    @Basic(optional = false)
    @Column(name = "pro_descuento1")
    private BigDecimal proDescuento1;
    @Basic(optional = false)
    @Column(name = "pro_descuento2")
    private BigDecimal proDescuento2;
    @Basic(optional = false)
    @Column(name = "pro_descuento3")
    private BigDecimal proDescuento3;
    @Basic(optional = false)
    @Column(name = "pro_descuento4")
    private BigDecimal proDescuento4;
    @Basic(optional = false)
    @Column(name = "pro_descuento5")
    private BigDecimal proDescuento5;
    @Basic(optional = false)
    @Column(name = "pro_margen_utilidad1")
    private BigDecimal proMargenUtilidad1;
    @Basic(optional = false)
    @Column(name = "pro_margen_utilidad2")
    private BigDecimal proMargenUtilidad2;
    @Basic(optional = false)
    @Column(name = "pro_margen_utilidad3")
    private BigDecimal proMargenUtilidad3;
    @Basic(optional = false)
    @Column(name = "pro_margen_utilidad4")
    private BigDecimal proMargenUtilidad4;
    @Basic(optional = false)
    @Column(name = "pro_margen_utilidad5")
    private BigDecimal proMargenUtilidad5;
    @Column(name = "pro_minimo")
    private Integer proMinimo;
    @Column(name = "pro_maximo")
    private Integer proMaximo;
    @Basic(optional = false)
    @Column(name = "pro_iva")
    private String proIva;
    @Basic(optional = false)
    @Column(name = "pro_credito_tributario")
    private boolean proCreditoTributario;
    @Basic(optional = false)
    @Column(name = "pro_stock_negativo")
    private boolean proStockNegativo;
    @Basic(optional = false)
    @Column(name = "pro_inactivo")
    private boolean proInactivo;
    @Column(name = "pro_cuenta_empresa")
    private String proCuentaEmpresa;
    @Column(name = "pro_cuenta_inventario")
    private String proCuentaInventario;
    @Column(name = "pro_cuenta_gasto")
    private String proCuentaGasto;
    @Column(name = "pro_cuenta_venta")
    private String proCuentaVenta;
    @Column(name = "pro_cuenta_transferencia_ipp")
    private String proCuentaTransferenciaIpp;
    @Column(name = "con_codigo")
    private String conCodigo;
    @Column(name = "sus_codigo")
    private String susCodigo;
    @Column(name = "pro_factor_caja_saco_bulto")
    private BigDecimal proFactorCajaSacoBulto;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProducto")
    private List<InvVentasDetalle> invVentasDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProducto")
    private List<InvConsumosDetalle> invConsumosDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProducto")
    private List<InvTransferenciasDetalle> invTransferenciasDetalleList;
    @OneToMany(mappedBy = "invProducto")
    private List<InvProductoSaldos> invProductoSaldosList;
    @JoinColumns({
        @JoinColumn(name = "tip_empresa", referencedColumnName = "tip_empresa"),
        @JoinColumn(name = "tip_codigo", referencedColumnName = "tip_codigo")})
    @ManyToOne(optional = false)
    private InvProductoTipo invProductoTipo;
    @JoinColumns({
        @JoinColumn(name = "presu_empresa", referencedColumnName = "presu_empresa"),
        @JoinColumn(name = "presu_codigo", referencedColumnName = "presu_codigo")})
    @ManyToOne(optional = false)
    private InvProductoPresentacionUnidades invProductoPresentacionUnidades;
    @JoinColumns({
        @JoinColumn(name = "presc_empresa", referencedColumnName = "presc_empresa"),
        @JoinColumn(name = "presc_codigo", referencedColumnName = "presc_codigo")})
    @ManyToOne(optional = false)
    private InvProductoPresentacionCajas invProductoPresentacionCajas;
    @JoinColumns({
        @JoinColumn(name = "med_empresa", referencedColumnName = "med_empresa"),
        @JoinColumn(name = "med_codigo", referencedColumnName = "med_codigo")})
    @ManyToOne(optional = false)
    private InvProductoMedida invProductoMedida;
    @JoinColumns({
        @JoinColumn(name = "mar_empresa", referencedColumnName = "mar_empresa"),
        @JoinColumn(name = "mar_codigo", referencedColumnName = "mar_codigo")})
    @ManyToOne(optional = false)
    private InvProductoMarca invProductoMarca;
    @JoinColumns({
        @JoinColumn(name = "cat_empresa", referencedColumnName = "cat_empresa"),
        @JoinColumn(name = "cat_codigo", referencedColumnName = "cat_codigo")})
    @ManyToOne(optional = false)
    private InvProductoCategoria invProductoCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProducto")
    private List<InvProformasDetalle> invProformasDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProducto")
    private List<InvComprasDetalle> invComprasDetalleList;

    public InvProducto() {
    }

    public InvProducto(InvProductoPK invProductoPK) {
        this.invProductoPK = invProductoPK;
    }

    public InvProducto(InvProductoPK invProductoPK, String proNombre, BigDecimal proCantidad1, BigDecimal proCantidad2, BigDecimal proCantidad3, BigDecimal proCantidad4, BigDecimal proCantidad5, BigDecimal proPrecio1, BigDecimal proPrecio2, BigDecimal proPrecio3, BigDecimal proPrecio4, BigDecimal proPrecio5, BigDecimal proDescuento1, BigDecimal proDescuento2, BigDecimal proDescuento3, BigDecimal proDescuento4, BigDecimal proDescuento5, BigDecimal proMargenUtilidad1, BigDecimal proMargenUtilidad2, BigDecimal proMargenUtilidad3, BigDecimal proMargenUtilidad4, BigDecimal proMargenUtilidad5, String proIva, boolean proCreditoTributario, boolean proStockNegativo, boolean proInactivo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invProductoPK = invProductoPK;
        this.proNombre = proNombre;
        this.proCantidad1 = proCantidad1;
        this.proCantidad2 = proCantidad2;
        this.proCantidad3 = proCantidad3;
        this.proCantidad4 = proCantidad4;
        this.proCantidad5 = proCantidad5;
        this.proPrecio1 = proPrecio1;
        this.proPrecio2 = proPrecio2;
        this.proPrecio3 = proPrecio3;
        this.proPrecio4 = proPrecio4;
        this.proPrecio5 = proPrecio5;
        this.proDescuento1 = proDescuento1;
        this.proDescuento2 = proDescuento2;
        this.proDescuento3 = proDescuento3;
        this.proDescuento4 = proDescuento4;
        this.proDescuento5 = proDescuento5;
        this.proMargenUtilidad1 = proMargenUtilidad1;
        this.proMargenUtilidad2 = proMargenUtilidad2;
        this.proMargenUtilidad3 = proMargenUtilidad3;
        this.proMargenUtilidad4 = proMargenUtilidad4;
        this.proMargenUtilidad5 = proMargenUtilidad5;
        this.proIva = proIva;
        this.proCreditoTributario = proCreditoTributario;
        this.proStockNegativo = proStockNegativo;
        this.proInactivo = proInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvProducto(String proEmpresa, String proCodigoPrincipal) {
        this.invProductoPK = new InvProductoPK(proEmpresa, proCodigoPrincipal);
    }

    public InvProductoPK getInvProductoPK() {
        return invProductoPK;
    }

    public void setInvProductoPK(InvProductoPK invProductoPK) {
        this.invProductoPK = invProductoPK;
    }

    public String getProCodigoAlterno() {
        return proCodigoAlterno;
    }

    public void setProCodigoAlterno(String proCodigoAlterno) {
        this.proCodigoAlterno = proCodigoAlterno;
    }

    public String getProCodigoBarra() {
        return proCodigoBarra;
    }

    public void setProCodigoBarra(String proCodigoBarra) {
        this.proCodigoBarra = proCodigoBarra;
    }

    public String getProCodigoBarra2() {
        return proCodigoBarra2;
    }

    public void setProCodigoBarra2(String proCodigoBarra2) {
        this.proCodigoBarra2 = proCodigoBarra2;
    }

    public String getProCodigoBarra3() {
        return proCodigoBarra3;
    }

    public void setProCodigoBarra3(String proCodigoBarra3) {
        this.proCodigoBarra3 = proCodigoBarra3;
    }

    public String getProCodigoBarra4() {
        return proCodigoBarra4;
    }

    public void setProCodigoBarra4(String proCodigoBarra4) {
        this.proCodigoBarra4 = proCodigoBarra4;
    }

    public String getProCodigoBarra5() {
        return proCodigoBarra5;
    }

    public void setProCodigoBarra5(String proCodigoBarra5) {
        this.proCodigoBarra5 = proCodigoBarra5;
    }

    public String getProEmpaque() {
        return proEmpaque;
    }

    public void setProEmpaque(String proEmpaque) {
        this.proEmpaque = proEmpaque;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProDetalle() {
        return proDetalle;
    }

    public void setProDetalle(String proDetalle) {
        this.proDetalle = proDetalle;
    }

    public BigDecimal getProCantidad1() {
        return proCantidad1;
    }

    public void setProCantidad1(BigDecimal proCantidad1) {
        this.proCantidad1 = proCantidad1;
    }

    public BigDecimal getProCantidad2() {
        return proCantidad2;
    }

    public void setProCantidad2(BigDecimal proCantidad2) {
        this.proCantidad2 = proCantidad2;
    }

    public BigDecimal getProCantidad3() {
        return proCantidad3;
    }

    public void setProCantidad3(BigDecimal proCantidad3) {
        this.proCantidad3 = proCantidad3;
    }

    public BigDecimal getProCantidad4() {
        return proCantidad4;
    }

    public void setProCantidad4(BigDecimal proCantidad4) {
        this.proCantidad4 = proCantidad4;
    }

    public BigDecimal getProCantidad5() {
        return proCantidad5;
    }

    public void setProCantidad5(BigDecimal proCantidad5) {
        this.proCantidad5 = proCantidad5;
    }

    public BigDecimal getProPrecio1() {
        return proPrecio1;
    }

    public void setProPrecio1(BigDecimal proPrecio1) {
        this.proPrecio1 = proPrecio1;
    }

    public BigDecimal getProPrecio2() {
        return proPrecio2;
    }

    public void setProPrecio2(BigDecimal proPrecio2) {
        this.proPrecio2 = proPrecio2;
    }

    public BigDecimal getProPrecio3() {
        return proPrecio3;
    }

    public void setProPrecio3(BigDecimal proPrecio3) {
        this.proPrecio3 = proPrecio3;
    }

    public BigDecimal getProPrecio4() {
        return proPrecio4;
    }

    public void setProPrecio4(BigDecimal proPrecio4) {
        this.proPrecio4 = proPrecio4;
    }

    public BigDecimal getProPrecio5() {
        return proPrecio5;
    }

    public void setProPrecio5(BigDecimal proPrecio5) {
        this.proPrecio5 = proPrecio5;
    }

    public BigDecimal getProDescuento1() {
        return proDescuento1;
    }

    public void setProDescuento1(BigDecimal proDescuento1) {
        this.proDescuento1 = proDescuento1;
    }

    public BigDecimal getProDescuento2() {
        return proDescuento2;
    }

    public void setProDescuento2(BigDecimal proDescuento2) {
        this.proDescuento2 = proDescuento2;
    }

    public BigDecimal getProDescuento3() {
        return proDescuento3;
    }

    public void setProDescuento3(BigDecimal proDescuento3) {
        this.proDescuento3 = proDescuento3;
    }

    public BigDecimal getProDescuento4() {
        return proDescuento4;
    }

    public void setProDescuento4(BigDecimal proDescuento4) {
        this.proDescuento4 = proDescuento4;
    }

    public BigDecimal getProDescuento5() {
        return proDescuento5;
    }

    public void setProDescuento5(BigDecimal proDescuento5) {
        this.proDescuento5 = proDescuento5;
    }

    public BigDecimal getProMargenUtilidad1() {
        return proMargenUtilidad1;
    }

    public void setProMargenUtilidad1(BigDecimal proMargenUtilidad1) {
        this.proMargenUtilidad1 = proMargenUtilidad1;
    }

    public BigDecimal getProMargenUtilidad2() {
        return proMargenUtilidad2;
    }

    public void setProMargenUtilidad2(BigDecimal proMargenUtilidad2) {
        this.proMargenUtilidad2 = proMargenUtilidad2;
    }

    public BigDecimal getProMargenUtilidad3() {
        return proMargenUtilidad3;
    }

    public void setProMargenUtilidad3(BigDecimal proMargenUtilidad3) {
        this.proMargenUtilidad3 = proMargenUtilidad3;
    }

    public BigDecimal getProMargenUtilidad4() {
        return proMargenUtilidad4;
    }

    public void setProMargenUtilidad4(BigDecimal proMargenUtilidad4) {
        this.proMargenUtilidad4 = proMargenUtilidad4;
    }

    public BigDecimal getProMargenUtilidad5() {
        return proMargenUtilidad5;
    }

    public void setProMargenUtilidad5(BigDecimal proMargenUtilidad5) {
        this.proMargenUtilidad5 = proMargenUtilidad5;
    }

    public Integer getProMinimo() {
        return proMinimo;
    }

    public void setProMinimo(Integer proMinimo) {
        this.proMinimo = proMinimo;
    }

    public Integer getProMaximo() {
        return proMaximo;
    }

    public void setProMaximo(Integer proMaximo) {
        this.proMaximo = proMaximo;
    }

    public String getProIva() {
        return proIva;
    }

    public void setProIva(String proIva) {
        this.proIva = proIva;
    }

    public boolean getProCreditoTributario() {
        return proCreditoTributario;
    }

    public void setProCreditoTributario(boolean proCreditoTributario) {
        this.proCreditoTributario = proCreditoTributario;
    }

    public boolean getProStockNegativo() {
        return proStockNegativo;
    }

    public void setProStockNegativo(boolean proStockNegativo) {
        this.proStockNegativo = proStockNegativo;
    }

    public boolean getProInactivo() {
        return proInactivo;
    }

    public void setProInactivo(boolean proInactivo) {
        this.proInactivo = proInactivo;
    }

    public String getProCuentaEmpresa() {
        return proCuentaEmpresa;
    }

    public void setProCuentaEmpresa(String proCuentaEmpresa) {
        this.proCuentaEmpresa = proCuentaEmpresa;
    }

    public String getProCuentaInventario() {
        return proCuentaInventario;
    }

    public void setProCuentaInventario(String proCuentaInventario) {
        this.proCuentaInventario = proCuentaInventario;
    }

    public String getProCuentaGasto() {
        return proCuentaGasto;
    }

    public void setProCuentaGasto(String proCuentaGasto) {
        this.proCuentaGasto = proCuentaGasto;
    }

    public String getProCuentaVenta() {
        return proCuentaVenta;
    }

    public void setProCuentaVenta(String proCuentaVenta) {
        this.proCuentaVenta = proCuentaVenta;
    }

    public String getProCuentaTransferenciaIpp() {
        return proCuentaTransferenciaIpp;
    }

    public void setProCuentaTransferenciaIpp(String proCuentaTransferenciaIpp) {
        this.proCuentaTransferenciaIpp = proCuentaTransferenciaIpp;
    }

    public String getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(String conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getSusCodigo() {
        return susCodigo;
    }

    public void setSusCodigo(String susCodigo) {
        this.susCodigo = susCodigo;
    }

    public BigDecimal getProFactorCajaSacoBulto() {
        return proFactorCajaSacoBulto;
    }

    public void setProFactorCajaSacoBulto(BigDecimal proFactorCajaSacoBulto) {
        this.proFactorCajaSacoBulto = proFactorCajaSacoBulto;
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

    public List<InvVentasDetalle> getInvVentasDetalleList() {
        return invVentasDetalleList;
    }

    public void setInvVentasDetalleList(List<InvVentasDetalle> invVentasDetalleList) {
        this.invVentasDetalleList = invVentasDetalleList;
    }

    public List<InvConsumosDetalle> getInvConsumosDetalleList() {
        return invConsumosDetalleList;
    }

    public void setInvConsumosDetalleList(List<InvConsumosDetalle> invConsumosDetalleList) {
        this.invConsumosDetalleList = invConsumosDetalleList;
    }

    public List<InvTransferenciasDetalle> getInvTransferenciasDetalleList() {
        return invTransferenciasDetalleList;
    }

    public void setInvTransferenciasDetalleList(List<InvTransferenciasDetalle> invTransferenciasDetalleList) {
        this.invTransferenciasDetalleList = invTransferenciasDetalleList;
    }

    public List<InvProductoSaldos> getInvProductoSaldosList() {
        return invProductoSaldosList;
    }

    public void setInvProductoSaldosList(List<InvProductoSaldos> invProductoSaldosList) {
        this.invProductoSaldosList = invProductoSaldosList;
    }

    public InvProductoTipo getInvProductoTipo() {
        return invProductoTipo;
    }

    public void setInvProductoTipo(InvProductoTipo invProductoTipo) {
        this.invProductoTipo = invProductoTipo;
    }

    public InvProductoPresentacionUnidades getInvProductoPresentacionUnidades() {
        return invProductoPresentacionUnidades;
    }

    public void setInvProductoPresentacionUnidades(InvProductoPresentacionUnidades invProductoPresentacionUnidades) {
        this.invProductoPresentacionUnidades = invProductoPresentacionUnidades;
    }

    public InvProductoPresentacionCajas getInvProductoPresentacionCajas() {
        return invProductoPresentacionCajas;
    }

    public void setInvProductoPresentacionCajas(InvProductoPresentacionCajas invProductoPresentacionCajas) {
        this.invProductoPresentacionCajas = invProductoPresentacionCajas;
    }

    public InvProductoMedida getInvProductoMedida() {
        return invProductoMedida;
    }

    public void setInvProductoMedida(InvProductoMedida invProductoMedida) {
        this.invProductoMedida = invProductoMedida;
    }

    public InvProductoMarca getInvProductoMarca() {
        return invProductoMarca;
    }

    public void setInvProductoMarca(InvProductoMarca invProductoMarca) {
        this.invProductoMarca = invProductoMarca;
    }

    public InvProductoCategoria getInvProductoCategoria() {
        return invProductoCategoria;
    }

    public void setInvProductoCategoria(InvProductoCategoria invProductoCategoria) {
        this.invProductoCategoria = invProductoCategoria;
    }

    public List<InvProformasDetalle> getInvProformasDetalleList() {
        return invProformasDetalleList;
    }

    public void setInvProformasDetalleList(List<InvProformasDetalle> invProformasDetalleList) {
        this.invProformasDetalleList = invProformasDetalleList;
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
        hash += (invProductoPK != null ? invProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProducto)) {
            return false;
        }
        InvProducto other = (InvProducto) object;
        if ((this.invProductoPK == null && other.invProductoPK != null) || (this.invProductoPK != null && !this.invProductoPK.equals(other.invProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProducto[ invProductoPK=" + invProductoPK + " ]";
    }
    
}
