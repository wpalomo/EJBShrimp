/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_producto_saldos", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProductoSaldos.findAll", query = "SELECT i FROM InvProductoSaldos i"),
    @NamedQuery(name = "InvProductoSaldos.findByStkEmpresa", query = "SELECT i FROM InvProductoSaldos i WHERE i.invProductoSaldosPK.stkEmpresa = :stkEmpresa"),
    @NamedQuery(name = "InvProductoSaldos.findByStkBodega", query = "SELECT i FROM InvProductoSaldos i WHERE i.invProductoSaldosPK.stkBodega = :stkBodega"),
    @NamedQuery(name = "InvProductoSaldos.findByStkProducto", query = "SELECT i FROM InvProductoSaldos i WHERE i.invProductoSaldosPK.stkProducto = :stkProducto"),
    @NamedQuery(name = "InvProductoSaldos.findByStkSaldoInicial", query = "SELECT i FROM InvProductoSaldos i WHERE i.stkSaldoInicial = :stkSaldoInicial"),
    @NamedQuery(name = "InvProductoSaldos.findByStkValorPromedioInicial", query = "SELECT i FROM InvProductoSaldos i WHERE i.stkValorPromedioInicial = :stkValorPromedioInicial"),
    @NamedQuery(name = "InvProductoSaldos.findByStkValorUltimaCompraInicial", query = "SELECT i FROM InvProductoSaldos i WHERE i.stkValorUltimaCompraInicial = :stkValorUltimaCompraInicial"),
    @NamedQuery(name = "InvProductoSaldos.findByStkFechaUltimaCompraInicial", query = "SELECT i FROM InvProductoSaldos i WHERE i.stkFechaUltimaCompraInicial = :stkFechaUltimaCompraInicial"),
    @NamedQuery(name = "InvProductoSaldos.findByStkSaldoFinal", query = "SELECT i FROM InvProductoSaldos i WHERE i.stkSaldoFinal = :stkSaldoFinal"),
    @NamedQuery(name = "InvProductoSaldos.findByStkValorPromedioFinal", query = "SELECT i FROM InvProductoSaldos i WHERE i.stkValorPromedioFinal = :stkValorPromedioFinal"),
    @NamedQuery(name = "InvProductoSaldos.findByStkValorUltimaCompraFinal", query = "SELECT i FROM InvProductoSaldos i WHERE i.stkValorUltimaCompraFinal = :stkValorUltimaCompraFinal"),
    @NamedQuery(name = "InvProductoSaldos.findByStkFechaUltimaCompraFinal", query = "SELECT i FROM InvProductoSaldos i WHERE i.stkFechaUltimaCompraFinal = :stkFechaUltimaCompraFinal")})
public class InvProductoSaldos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProductoSaldosPK invProductoSaldosPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "stk_saldo_inicial")
    private BigDecimal stkSaldoInicial;
    @Column(name = "stk_valor_promedio_inicial")
    private BigDecimal stkValorPromedioInicial;
    @Column(name = "stk_valor_ultima_compra_inicial")
    private BigDecimal stkValorUltimaCompraInicial;
    @Column(name = "stk_fecha_ultima_compra_inicial")
    @Temporal(TemporalType.DATE)
    private Date stkFechaUltimaCompraInicial;
    @Column(name = "stk_saldo_final")
    private BigDecimal stkSaldoFinal;
    @Column(name = "stk_valor_promedio_final")
    private BigDecimal stkValorPromedioFinal;
    @Column(name = "stk_valor_ultima_compra_final")
    private BigDecimal stkValorUltimaCompraFinal;
    @Column(name = "stk_fecha_ultima_compra_final")
    @Temporal(TemporalType.DATE)
    private Date stkFechaUltimaCompraFinal;
    @JoinColumns({
        @JoinColumn(name = "pro_empresa", referencedColumnName = "pro_empresa"),
        @JoinColumn(name = "pro_codigo_principal", referencedColumnName = "pro_codigo_principal")})
    @ManyToOne
    private InvProducto invProducto;
    @JoinColumns({
        @JoinColumn(name = "bod_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne
    private InvBodega invBodega;

    public InvProductoSaldos() {
    }

    public InvProductoSaldos(InvProductoSaldosPK invProductoSaldosPK) {
        this.invProductoSaldosPK = invProductoSaldosPK;
    }

    public InvProductoSaldos(String stkEmpresa, String stkBodega, String stkProducto) {
        this.invProductoSaldosPK = new InvProductoSaldosPK(stkEmpresa, stkBodega, stkProducto);
    }

    public InvProductoSaldosPK getInvProductoSaldosPK() {
        return invProductoSaldosPK;
    }

    public void setInvProductoSaldosPK(InvProductoSaldosPK invProductoSaldosPK) {
        this.invProductoSaldosPK = invProductoSaldosPK;
    }

    public BigDecimal getStkSaldoInicial() {
        return stkSaldoInicial;
    }

    public void setStkSaldoInicial(BigDecimal stkSaldoInicial) {
        this.stkSaldoInicial = stkSaldoInicial;
    }

    public BigDecimal getStkValorPromedioInicial() {
        return stkValorPromedioInicial;
    }

    public void setStkValorPromedioInicial(BigDecimal stkValorPromedioInicial) {
        this.stkValorPromedioInicial = stkValorPromedioInicial;
    }

    public BigDecimal getStkValorUltimaCompraInicial() {
        return stkValorUltimaCompraInicial;
    }

    public void setStkValorUltimaCompraInicial(BigDecimal stkValorUltimaCompraInicial) {
        this.stkValorUltimaCompraInicial = stkValorUltimaCompraInicial;
    }

    public Date getStkFechaUltimaCompraInicial() {
        return stkFechaUltimaCompraInicial;
    }

    public void setStkFechaUltimaCompraInicial(Date stkFechaUltimaCompraInicial) {
        this.stkFechaUltimaCompraInicial = stkFechaUltimaCompraInicial;
    }

    public BigDecimal getStkSaldoFinal() {
        return stkSaldoFinal;
    }

    public void setStkSaldoFinal(BigDecimal stkSaldoFinal) {
        this.stkSaldoFinal = stkSaldoFinal;
    }

    public BigDecimal getStkValorPromedioFinal() {
        return stkValorPromedioFinal;
    }

    public void setStkValorPromedioFinal(BigDecimal stkValorPromedioFinal) {
        this.stkValorPromedioFinal = stkValorPromedioFinal;
    }

    public BigDecimal getStkValorUltimaCompraFinal() {
        return stkValorUltimaCompraFinal;
    }

    public void setStkValorUltimaCompraFinal(BigDecimal stkValorUltimaCompraFinal) {
        this.stkValorUltimaCompraFinal = stkValorUltimaCompraFinal;
    }

    public Date getStkFechaUltimaCompraFinal() {
        return stkFechaUltimaCompraFinal;
    }

    public void setStkFechaUltimaCompraFinal(Date stkFechaUltimaCompraFinal) {
        this.stkFechaUltimaCompraFinal = stkFechaUltimaCompraFinal;
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
        hash += (invProductoSaldosPK != null ? invProductoSaldosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoSaldos)) {
            return false;
        }
        InvProductoSaldos other = (InvProductoSaldos) object;
        if ((this.invProductoSaldosPK == null && other.invProductoSaldosPK != null) || (this.invProductoSaldosPK != null && !this.invProductoSaldosPK.equals(other.invProductoSaldosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoSaldos[ invProductoSaldosPK=" + invProductoSaldosPK + " ]";
    }
    
}
