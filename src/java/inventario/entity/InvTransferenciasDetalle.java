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
@Table(name = "inv_transferencias_detalle", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvTransferenciasDetalle.findAll", query = "SELECT i FROM InvTransferenciasDetalle i"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetSecuencial", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detSecuencial = :detSecuencial"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetOrden", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detOrden = :detOrden"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetPendiente", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detPendiente = :detPendiente"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetConfirmado", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detConfirmado = :detConfirmado"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetCantidad", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detCantidad = :detCantidad"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetOrigenValorPromedio", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detOrigenValorPromedio = :detOrigenValorPromedio"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetOrigenValorUltimaCompra", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detOrigenValorUltimaCompra = :detOrigenValorUltimaCompra"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetOrigenSaldo", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detOrigenSaldo = :detOrigenSaldo"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetDestinoValorPromedio", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detDestinoValorPromedio = :detDestinoValorPromedio"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetDestinoValorUltimaCompra", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detDestinoValorUltimaCompra = :detDestinoValorUltimaCompra"),
    @NamedQuery(name = "InvTransferenciasDetalle.findByDetDestinoSaldo", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.detDestinoSaldo = :detDestinoSaldo"),
    @NamedQuery(name = "InvTransferenciasDetalle.findBySecOrigenEmpresa", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.secOrigenEmpresa = :secOrigenEmpresa"),
    @NamedQuery(name = "InvTransferenciasDetalle.findBySecOrigenCodigo", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.secOrigenCodigo = :secOrigenCodigo"),
    @NamedQuery(name = "InvTransferenciasDetalle.findBySecDestinoEmpresa", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.secDestinoEmpresa = :secDestinoEmpresa"),
    @NamedQuery(name = "InvTransferenciasDetalle.findBySecDestinoCodigo", query = "SELECT i FROM InvTransferenciasDetalle i WHERE i.secDestinoCodigo = :secDestinoCodigo")})
public class InvTransferenciasDetalle implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "det_cantidad")
    private BigDecimal detCantidad;
    @Column(name = "det_origen_valor_promedio")
    private BigDecimal detOrigenValorPromedio;
    @Column(name = "det_origen_valor_ultima_compra")
    private BigDecimal detOrigenValorUltimaCompra;
    @Column(name = "det_origen_saldo")
    private BigDecimal detOrigenSaldo;
    @Column(name = "det_destino_valor_promedio")
    private BigDecimal detDestinoValorPromedio;
    @Column(name = "det_destino_valor_ultima_compra")
    private BigDecimal detDestinoValorUltimaCompra;
    @Column(name = "det_destino_saldo")
    private BigDecimal detDestinoSaldo;
    @Column(name = "sec_origen_empresa")
    private String secOrigenEmpresa;
    @Column(name = "sec_origen_codigo")
    private String secOrigenCodigo;
    @Column(name = "sec_destino_empresa")
    private String secDestinoEmpresa;
    @Column(name = "sec_destino_codigo")
    private String secDestinoCodigo;
    @JoinColumns({
        @JoinColumn(name = "trans_empresa", referencedColumnName = "trans_empresa"),
        @JoinColumn(name = "trans_periodo", referencedColumnName = "trans_periodo"),
        @JoinColumn(name = "trans_motivo", referencedColumnName = "trans_motivo"),
        @JoinColumn(name = "trans_numero", referencedColumnName = "trans_numero")})
    @ManyToOne(optional = false)
    private InvTransferencias invTransferencias;
    @JoinColumns({
        @JoinColumn(name = "pro_empresa", referencedColumnName = "pro_empresa"),
        @JoinColumn(name = "pro_codigo_principal", referencedColumnName = "pro_codigo_principal")})
    @ManyToOne(optional = false)
    private InvProducto invProducto;
    @JoinColumns({
        @JoinColumn(name = "bod_origen_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_origen_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne
    private InvBodega invBodega;
    @JoinColumns({
        @JoinColumn(name = "bod_destino_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_destino_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne
    private InvBodega invBodega1;

    public InvTransferenciasDetalle() {
    }

    public InvTransferenciasDetalle(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public InvTransferenciasDetalle(Integer detSecuencial, int detOrden, boolean detPendiente, boolean detConfirmado, BigDecimal detCantidad) {
        this.detSecuencial = detSecuencial;
        this.detOrden = detOrden;
        this.detPendiente = detPendiente;
        this.detConfirmado = detConfirmado;
        this.detCantidad = detCantidad;
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

    public BigDecimal getDetOrigenValorPromedio() {
        return detOrigenValorPromedio;
    }

    public void setDetOrigenValorPromedio(BigDecimal detOrigenValorPromedio) {
        this.detOrigenValorPromedio = detOrigenValorPromedio;
    }

    public BigDecimal getDetOrigenValorUltimaCompra() {
        return detOrigenValorUltimaCompra;
    }

    public void setDetOrigenValorUltimaCompra(BigDecimal detOrigenValorUltimaCompra) {
        this.detOrigenValorUltimaCompra = detOrigenValorUltimaCompra;
    }

    public BigDecimal getDetOrigenSaldo() {
        return detOrigenSaldo;
    }

    public void setDetOrigenSaldo(BigDecimal detOrigenSaldo) {
        this.detOrigenSaldo = detOrigenSaldo;
    }

    public BigDecimal getDetDestinoValorPromedio() {
        return detDestinoValorPromedio;
    }

    public void setDetDestinoValorPromedio(BigDecimal detDestinoValorPromedio) {
        this.detDestinoValorPromedio = detDestinoValorPromedio;
    }

    public BigDecimal getDetDestinoValorUltimaCompra() {
        return detDestinoValorUltimaCompra;
    }

    public void setDetDestinoValorUltimaCompra(BigDecimal detDestinoValorUltimaCompra) {
        this.detDestinoValorUltimaCompra = detDestinoValorUltimaCompra;
    }

    public BigDecimal getDetDestinoSaldo() {
        return detDestinoSaldo;
    }

    public void setDetDestinoSaldo(BigDecimal detDestinoSaldo) {
        this.detDestinoSaldo = detDestinoSaldo;
    }

    public String getSecOrigenEmpresa() {
        return secOrigenEmpresa;
    }

    public void setSecOrigenEmpresa(String secOrigenEmpresa) {
        this.secOrigenEmpresa = secOrigenEmpresa;
    }

    public String getSecOrigenCodigo() {
        return secOrigenCodigo;
    }

    public void setSecOrigenCodigo(String secOrigenCodigo) {
        this.secOrigenCodigo = secOrigenCodigo;
    }

    public String getSecDestinoEmpresa() {
        return secDestinoEmpresa;
    }

    public void setSecDestinoEmpresa(String secDestinoEmpresa) {
        this.secDestinoEmpresa = secDestinoEmpresa;
    }

    public String getSecDestinoCodigo() {
        return secDestinoCodigo;
    }

    public void setSecDestinoCodigo(String secDestinoCodigo) {
        this.secDestinoCodigo = secDestinoCodigo;
    }

    public InvTransferencias getInvTransferencias() {
        return invTransferencias;
    }

    public void setInvTransferencias(InvTransferencias invTransferencias) {
        this.invTransferencias = invTransferencias;
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

    public InvBodega getInvBodega1() {
        return invBodega1;
    }

    public void setInvBodega1(InvBodega invBodega1) {
        this.invBodega1 = invBodega1;
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
        if (!(object instanceof InvTransferenciasDetalle)) {
            return false;
        }
        InvTransferenciasDetalle other = (InvTransferenciasDetalle) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvTransferenciasDetalle[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
