/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_ventas_detalle", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvVentasDetalle.findAll", query = "SELECT i FROM InvVentasDetalle i"),
    @NamedQuery(name = "InvVentasDetalle.findByDetSecuencial", query = "SELECT i FROM InvVentasDetalle i WHERE i.detSecuencial = :detSecuencial"),
    @NamedQuery(name = "InvVentasDetalle.findByDetOrden", query = "SELECT i FROM InvVentasDetalle i WHERE i.detOrden = :detOrden"),
    @NamedQuery(name = "InvVentasDetalle.findByDetPendiente", query = "SELECT i FROM InvVentasDetalle i WHERE i.detPendiente = :detPendiente"),
    @NamedQuery(name = "InvVentasDetalle.findByDetCantidad", query = "SELECT i FROM InvVentasDetalle i WHERE i.detCantidad = :detCantidad"),
    @NamedQuery(name = "InvVentasDetalle.findByDetPrecio", query = "SELECT i FROM InvVentasDetalle i WHERE i.detPrecio = :detPrecio"),
    @NamedQuery(name = "InvVentasDetalle.findByDetPorcentajeRecargo", query = "SELECT i FROM InvVentasDetalle i WHERE i.detPorcentajeRecargo = :detPorcentajeRecargo"),
    @NamedQuery(name = "InvVentasDetalle.findByDetPorcentajeDescuento", query = "SELECT i FROM InvVentasDetalle i WHERE i.detPorcentajeDescuento = :detPorcentajeDescuento"),
    @NamedQuery(name = "InvVentasDetalle.findByDetValorPromedio", query = "SELECT i FROM InvVentasDetalle i WHERE i.detValorPromedio = :detValorPromedio"),
    @NamedQuery(name = "InvVentasDetalle.findByDetValorUltimaCompra", query = "SELECT i FROM InvVentasDetalle i WHERE i.detValorUltimaCompra = :detValorUltimaCompra"),
    @NamedQuery(name = "InvVentasDetalle.findByDetSaldo", query = "SELECT i FROM InvVentasDetalle i WHERE i.detSaldo = :detSaldo"),
    @NamedQuery(name = "InvVentasDetalle.findByProNombre", query = "SELECT i FROM InvVentasDetalle i WHERE i.proNombre = :proNombre"),
    @NamedQuery(name = "InvVentasDetalle.findByProCreditoTributario", query = "SELECT i FROM InvVentasDetalle i WHERE i.proCreditoTributario = :proCreditoTributario"),
    @NamedQuery(name = "InvVentasDetalle.findBySecEmpresa", query = "SELECT i FROM InvVentasDetalle i WHERE i.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "InvVentasDetalle.findBySecCodigo", query = "SELECT i FROM InvVentasDetalle i WHERE i.secCodigo = :secCodigo"),
    @NamedQuery(name = "InvVentasDetalle.findByPisEmpresa", query = "SELECT i FROM InvVentasDetalle i WHERE i.pisEmpresa = :pisEmpresa"),
    @NamedQuery(name = "InvVentasDetalle.findByPisSector", query = "SELECT i FROM InvVentasDetalle i WHERE i.pisSector = :pisSector"),
    @NamedQuery(name = "InvVentasDetalle.findByPisNumero", query = "SELECT i FROM InvVentasDetalle i WHERE i.pisNumero = :pisNumero")})
public class InvVentasDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_secuencial")
    private Integer detSecuencial;
    @Basic(optional = false)
    @Column(name = "det_orden")
    private int detOrden;
    @Basic(optional = false)
    @Column(name = "det_pendiente")
    private boolean detPendiente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "det_cantidad")
    private BigDecimal detCantidad;
    @Column(name = "det_precio")
    private BigDecimal detPrecio;
    @Column(name = "det_porcentaje_recargo")
    private BigDecimal detPorcentajeRecargo;
    @Column(name = "det_porcentaje_descuento")
    private BigDecimal detPorcentajeDescuento;
    @Column(name = "det_valor_promedio")
    private BigDecimal detValorPromedio;
    @Column(name = "det_valor_ultima_compra")
    private BigDecimal detValorUltimaCompra;
    @Column(name = "det_saldo")
    private BigDecimal detSaldo;
    @Basic(optional = false)
    @Column(name = "pro_nombre")
    private String proNombre;
    @Basic(optional = false)
    @Column(name = "pro_credito_tributario")
    private boolean proCreditoTributario;
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Column(name = "sec_codigo")
    private String secCodigo;
    @Column(name = "pis_empresa")
    private String pisEmpresa;
    @Column(name = "pis_sector")
    private String pisSector;
    @Column(name = "pis_numero")
    private String pisNumero;
    @JoinColumns({
        @JoinColumn(name = "vta_empresa", referencedColumnName = "vta_empresa"),
        @JoinColumn(name = "vta_periodo", referencedColumnName = "vta_periodo"),
        @JoinColumn(name = "vta_motivo", referencedColumnName = "vta_motivo"),
        @JoinColumn(name = "vta_numero", referencedColumnName = "vta_numero")})
    @ManyToOne(optional = false)
    private InvVentas invVentas;
    @JoinColumns({
        @JoinColumn(name = "pro_empresa", referencedColumnName = "pro_empresa"),
        @JoinColumn(name = "pro_codigo_principal", referencedColumnName = "pro_codigo_principal")})
    @ManyToOne(optional = false)
    private InvProducto invProducto;
    @JoinColumns({
        @JoinColumn(name = "bod_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne(optional = false)
    private InvBodega invBodega;

    public InvVentasDetalle() {
    }

    public InvVentasDetalle(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public InvVentasDetalle(Integer detSecuencial, int detOrden, boolean detPendiente, String proNombre, boolean proCreditoTributario) {
        this.detSecuencial = detSecuencial;
        this.detOrden = detOrden;
        this.detPendiente = detPendiente;
        this.proNombre = proNombre;
        this.proCreditoTributario = proCreditoTributario;
    }

    public Integer getDetSecuencial() {
        return detSecuencial;
    }

    public void setDetSecuencial(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public int getDetOrden() {
        return detOrden;
    }

    public void setDetOrden(int detOrden) {
        this.detOrden = detOrden;
    }

    public boolean getDetPendiente() {
        return detPendiente;
    }

    public void setDetPendiente(boolean detPendiente) {
        this.detPendiente = detPendiente;
    }

    public BigDecimal getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(BigDecimal detCantidad) {
        this.detCantidad = detCantidad;
    }

    public BigDecimal getDetPrecio() {
        return detPrecio;
    }

    public void setDetPrecio(BigDecimal detPrecio) {
        this.detPrecio = detPrecio;
    }

    public BigDecimal getDetPorcentajeRecargo() {
        return detPorcentajeRecargo;
    }

    public void setDetPorcentajeRecargo(BigDecimal detPorcentajeRecargo) {
        this.detPorcentajeRecargo = detPorcentajeRecargo;
    }

    public BigDecimal getDetPorcentajeDescuento() {
        return detPorcentajeDescuento;
    }

    public void setDetPorcentajeDescuento(BigDecimal detPorcentajeDescuento) {
        this.detPorcentajeDescuento = detPorcentajeDescuento;
    }

    public BigDecimal getDetValorPromedio() {
        return detValorPromedio;
    }

    public void setDetValorPromedio(BigDecimal detValorPromedio) {
        this.detValorPromedio = detValorPromedio;
    }

    public BigDecimal getDetValorUltimaCompra() {
        return detValorUltimaCompra;
    }

    public void setDetValorUltimaCompra(BigDecimal detValorUltimaCompra) {
        this.detValorUltimaCompra = detValorUltimaCompra;
    }

    public BigDecimal getDetSaldo() {
        return detSaldo;
    }

    public void setDetSaldo(BigDecimal detSaldo) {
        this.detSaldo = detSaldo;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public boolean getProCreditoTributario() {
        return proCreditoTributario;
    }

    public void setProCreditoTributario(boolean proCreditoTributario) {
        this.proCreditoTributario = proCreditoTributario;
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

    public InvVentas getInvVentas() {
        return invVentas;
    }

    public void setInvVentas(InvVentas invVentas) {
        this.invVentas = invVentas;
    }

    public InvProducto getInvProducto() {
        return invProducto;
    }

    public void setInvProducto(InvProducto invProducto) {
        this.invProducto = invProducto;
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
        hash += (detSecuencial != null ? detSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentasDetalle)) {
            return false;
        }
        InvVentasDetalle other = (InvVentasDetalle) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentasDetalle[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
