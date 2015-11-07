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
@Table(name = "inv_consumos_detalle", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvConsumosDetalle.findAll", query = "SELECT i FROM InvConsumosDetalle i"),
    @NamedQuery(name = "InvConsumosDetalle.findByDetSecuencial", query = "SELECT i FROM InvConsumosDetalle i WHERE i.detSecuencial = :detSecuencial"),
    @NamedQuery(name = "InvConsumosDetalle.findByDetOrden", query = "SELECT i FROM InvConsumosDetalle i WHERE i.detOrden = :detOrden"),
    @NamedQuery(name = "InvConsumosDetalle.findByDetPendiente", query = "SELECT i FROM InvConsumosDetalle i WHERE i.detPendiente = :detPendiente"),
    @NamedQuery(name = "InvConsumosDetalle.findByDetCantidad", query = "SELECT i FROM InvConsumosDetalle i WHERE i.detCantidad = :detCantidad"),
    @NamedQuery(name = "InvConsumosDetalle.findByDetValorPromedio", query = "SELECT i FROM InvConsumosDetalle i WHERE i.detValorPromedio = :detValorPromedio"),
    @NamedQuery(name = "InvConsumosDetalle.findByDetValorUltimaCompra", query = "SELECT i FROM InvConsumosDetalle i WHERE i.detValorUltimaCompra = :detValorUltimaCompra"),
    @NamedQuery(name = "InvConsumosDetalle.findByDetSaldo", query = "SELECT i FROM InvConsumosDetalle i WHERE i.detSaldo = :detSaldo"),
    @NamedQuery(name = "InvConsumosDetalle.findBySecEmpresa", query = "SELECT i FROM InvConsumosDetalle i WHERE i.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "InvConsumosDetalle.findBySecCodigo", query = "SELECT i FROM InvConsumosDetalle i WHERE i.secCodigo = :secCodigo"),
    @NamedQuery(name = "InvConsumosDetalle.findByPisEmpresa", query = "SELECT i FROM InvConsumosDetalle i WHERE i.pisEmpresa = :pisEmpresa"),
    @NamedQuery(name = "InvConsumosDetalle.findByPisSector", query = "SELECT i FROM InvConsumosDetalle i WHERE i.pisSector = :pisSector"),
    @NamedQuery(name = "InvConsumosDetalle.findByPisNumero", query = "SELECT i FROM InvConsumosDetalle i WHERE i.pisNumero = :pisNumero")})
public class InvConsumosDetalle implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "det_cantidad")
    private BigDecimal detCantidad;
    @Column(name = "det_valor_promedio")
    private BigDecimal detValorPromedio;
    @Column(name = "det_valor_ultima_compra")
    private BigDecimal detValorUltimaCompra;
    @Column(name = "det_saldo")
    private BigDecimal detSaldo;
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
        @JoinColumn(name = "cons_empresa", referencedColumnName = "cons_empresa"),
        @JoinColumn(name = "cons_periodo", referencedColumnName = "cons_periodo"),
        @JoinColumn(name = "cons_motivo", referencedColumnName = "cons_motivo"),
        @JoinColumn(name = "cons_numero", referencedColumnName = "cons_numero")})
    @ManyToOne(optional = false)
    private InvConsumos invConsumos;
    @JoinColumns({
        @JoinColumn(name = "bod_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne(optional = false)
    private InvBodega invBodega;

    public InvConsumosDetalle() {
    }

    public InvConsumosDetalle(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public InvConsumosDetalle(Integer detSecuencial, int detOrden, boolean detPendiente, BigDecimal detCantidad) {
        this.detSecuencial = detSecuencial;
        this.detOrden = detOrden;
        this.detPendiente = detPendiente;
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

    public BigDecimal getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(BigDecimal detCantidad) {
        this.detCantidad = detCantidad;
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

    public InvConsumos getInvConsumos() {
        return invConsumos;
    }

    public void setInvConsumos(InvConsumos invConsumos) {
        this.invConsumos = invConsumos;
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
        if (!(object instanceof InvConsumosDetalle)) {
            return false;
        }
        InvConsumosDetalle other = (InvConsumosDetalle) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvConsumosDetalle[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
