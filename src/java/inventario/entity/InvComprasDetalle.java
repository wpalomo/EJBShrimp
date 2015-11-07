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
@Table(name = "inv_compras_detalle", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvComprasDetalle.findAll", query = "SELECT i FROM InvComprasDetalle i"),
    @NamedQuery(name = "InvComprasDetalle.findByDetSecuencial", query = "SELECT i FROM InvComprasDetalle i WHERE i.detSecuencial = :detSecuencial"),
    @NamedQuery(name = "InvComprasDetalle.findByDetOrden", query = "SELECT i FROM InvComprasDetalle i WHERE i.detOrden = :detOrden"),
    @NamedQuery(name = "InvComprasDetalle.findByDetPendiente", query = "SELECT i FROM InvComprasDetalle i WHERE i.detPendiente = :detPendiente"),
    @NamedQuery(name = "InvComprasDetalle.findByDetConfirmado", query = "SELECT i FROM InvComprasDetalle i WHERE i.detConfirmado = :detConfirmado"),
    @NamedQuery(name = "InvComprasDetalle.findByDetCantidad", query = "SELECT i FROM InvComprasDetalle i WHERE i.detCantidad = :detCantidad"),
    @NamedQuery(name = "InvComprasDetalle.findByDetPrecio", query = "SELECT i FROM InvComprasDetalle i WHERE i.detPrecio = :detPrecio"),
    @NamedQuery(name = "InvComprasDetalle.findByDetPorcentajeDescuento", query = "SELECT i FROM InvComprasDetalle i WHERE i.detPorcentajeDescuento = :detPorcentajeDescuento"),
    @NamedQuery(name = "InvComprasDetalle.findByDetOtrosImpuestos", query = "SELECT i FROM InvComprasDetalle i WHERE i.detOtrosImpuestos = :detOtrosImpuestos"),
    @NamedQuery(name = "InvComprasDetalle.findByDetValorPromedio", query = "SELECT i FROM InvComprasDetalle i WHERE i.detValorPromedio = :detValorPromedio"),
    @NamedQuery(name = "InvComprasDetalle.findByDetValorUltimaCompra", query = "SELECT i FROM InvComprasDetalle i WHERE i.detValorUltimaCompra = :detValorUltimaCompra"),
    @NamedQuery(name = "InvComprasDetalle.findByDetSaldo", query = "SELECT i FROM InvComprasDetalle i WHERE i.detSaldo = :detSaldo"),
    @NamedQuery(name = "InvComprasDetalle.findByProCreditoTributario", query = "SELECT i FROM InvComprasDetalle i WHERE i.proCreditoTributario = :proCreditoTributario"),
    @NamedQuery(name = "InvComprasDetalle.findBySecEmpresa", query = "SELECT i FROM InvComprasDetalle i WHERE i.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "InvComprasDetalle.findBySecCodigo", query = "SELECT i FROM InvComprasDetalle i WHERE i.secCodigo = :secCodigo"),
    @NamedQuery(name = "InvComprasDetalle.findByPisEmpresa", query = "SELECT i FROM InvComprasDetalle i WHERE i.pisEmpresa = :pisEmpresa"),
    @NamedQuery(name = "InvComprasDetalle.findByPisSector", query = "SELECT i FROM InvComprasDetalle i WHERE i.pisSector = :pisSector"),
    @NamedQuery(name = "InvComprasDetalle.findByPisNumero", query = "SELECT i FROM InvComprasDetalle i WHERE i.pisNumero = :pisNumero")})
public class InvComprasDetalle implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "det_confirmado")
    private boolean detConfirmado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "det_cantidad")
    private BigDecimal detCantidad;
    @Column(name = "det_precio")
    private BigDecimal detPrecio;
    @Column(name = "det_porcentaje_descuento")
    private BigDecimal detPorcentajeDescuento;
    @Column(name = "det_otros_impuestos")
    private BigDecimal detOtrosImpuestos;
    @Column(name = "det_valor_promedio")
    private BigDecimal detValorPromedio;
    @Column(name = "det_valor_ultima_compra")
    private BigDecimal detValorUltimaCompra;
    @Column(name = "det_saldo")
    private BigDecimal detSaldo;
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
        @JoinColumn(name = "pro_empresa", referencedColumnName = "pro_empresa"),
        @JoinColumn(name = "pro_codigo_principal", referencedColumnName = "pro_codigo_principal")})
    @ManyToOne(optional = false)
    private InvProducto invProducto;
    @JoinColumns({
        @JoinColumn(name = "comp_empresa", referencedColumnName = "comp_empresa"),
        @JoinColumn(name = "comp_periodo", referencedColumnName = "comp_periodo"),
        @JoinColumn(name = "comp_motivo", referencedColumnName = "comp_motivo"),
        @JoinColumn(name = "comp_numero", referencedColumnName = "comp_numero")})
    @ManyToOne(optional = false)
    private InvCompras invCompras;
    @JoinColumns({
        @JoinColumn(name = "bod_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne(optional = false)
    private InvBodega invBodega;

    public InvComprasDetalle() {
    }

    public InvComprasDetalle(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public InvComprasDetalle(Integer detSecuencial, int detOrden, boolean detPendiente, boolean detConfirmado, boolean proCreditoTributario) {
        this.detSecuencial = detSecuencial;
        this.detOrden = detOrden;
        this.detPendiente = detPendiente;
        this.detConfirmado = detConfirmado;
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

    public boolean getDetConfirmado() {
        return detConfirmado;
    }

    public void setDetConfirmado(boolean detConfirmado) {
        this.detConfirmado = detConfirmado;
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

    public BigDecimal getDetPorcentajeDescuento() {
        return detPorcentajeDescuento;
    }

    public void setDetPorcentajeDescuento(BigDecimal detPorcentajeDescuento) {
        this.detPorcentajeDescuento = detPorcentajeDescuento;
    }

    public BigDecimal getDetOtrosImpuestos() {
        return detOtrosImpuestos;
    }

    public void setDetOtrosImpuestos(BigDecimal detOtrosImpuestos) {
        this.detOtrosImpuestos = detOtrosImpuestos;
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

    public InvProducto getInvProducto() {
        return invProducto;
    }

    public void setInvProducto(InvProducto invProducto) {
        this.invProducto = invProducto;
    }

    public InvCompras getInvCompras() {
        return invCompras;
    }

    public void setInvCompras(InvCompras invCompras) {
        this.invCompras = invCompras;
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
        if (!(object instanceof InvComprasDetalle)) {
            return false;
        }
        InvComprasDetalle other = (InvComprasDetalle) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvComprasDetalle[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
