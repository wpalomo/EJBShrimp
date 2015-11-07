/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "rh_anticipo", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhAnticipo.findAll", query = "SELECT r FROM RhAnticipo r"),
    @NamedQuery(name = "RhAnticipo.findByAntSecuencial", query = "SELECT r FROM RhAnticipo r WHERE r.antSecuencial = :antSecuencial"),
    @NamedQuery(name = "RhAnticipo.findByAntValor", query = "SELECT r FROM RhAnticipo r WHERE r.antValor = :antValor"),
    @NamedQuery(name = "RhAnticipo.findByAntFormaPago", query = "SELECT r FROM RhAnticipo r WHERE r.antFormaPago = :antFormaPago"),
    @NamedQuery(name = "RhAnticipo.findByAntReversado", query = "SELECT r FROM RhAnticipo r WHERE r.antReversado = :antReversado"),
    @NamedQuery(name = "RhAnticipo.findBySecEmpresa", query = "SELECT r FROM RhAnticipo r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhAnticipo.findBySecCodigo", query = "SELECT r FROM RhAnticipo r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhAnticipo.findByConEmpresa", query = "SELECT r FROM RhAnticipo r WHERE r.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "RhAnticipo.findByConPeriodo", query = "SELECT r FROM RhAnticipo r WHERE r.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "RhAnticipo.findByConTipo", query = "SELECT r FROM RhAnticipo r WHERE r.conTipo = :conTipo"),
    @NamedQuery(name = "RhAnticipo.findByConNumero", query = "SELECT r FROM RhAnticipo r WHERE r.conNumero = :conNumero")})
public class RhAnticipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ant_secuencial")
    private Integer antSecuencial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ant_valor")
    private BigDecimal antValor;
    @Basic(optional = false)
    @Column(name = "ant_forma_pago")
    private String antFormaPago;
    @Basic(optional = false)
    @Column(name = "ant_reversado")
    private boolean antReversado;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
    @Basic(optional = false)
    @Column(name = "con_empresa")
    private String conEmpresa;
    @Basic(optional = false)
    @Column(name = "con_periodo")
    private String conPeriodo;
    @Basic(optional = false)
    @Column(name = "con_tipo")
    private String conTipo;
    @Basic(optional = false)
    @Column(name = "con_numero")
    private String conNumero;
    @JoinColumns({
        @JoinColumn(name = "emp_empresa", referencedColumnName = "emp_empresa"),
        @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")})
    @ManyToOne(optional = false)
    private RhEmpleado rhEmpleado;

    public RhAnticipo() {
    }

    public RhAnticipo(Integer antSecuencial) {
        this.antSecuencial = antSecuencial;
    }

    public RhAnticipo(Integer antSecuencial, BigDecimal antValor, String antFormaPago, boolean antReversado, String secEmpresa, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.antSecuencial = antSecuencial;
        this.antValor = antValor;
        this.antFormaPago = antFormaPago;
        this.antReversado = antReversado;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
    }

    public Integer getAntSecuencial() {
        return antSecuencial;
    }

    public void setAntSecuencial(Integer antSecuencial) {
        this.antSecuencial = antSecuencial;
    }

    public BigDecimal getAntValor() {
        return antValor;
    }

    public void setAntValor(BigDecimal antValor) {
        this.antValor = antValor;
    }

    public String getAntFormaPago() {
        return antFormaPago;
    }

    public void setAntFormaPago(String antFormaPago) {
        this.antFormaPago = antFormaPago;
    }

    public boolean getAntReversado() {
        return antReversado;
    }

    public void setAntReversado(boolean antReversado) {
        this.antReversado = antReversado;
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

    public RhEmpleado getRhEmpleado() {
        return rhEmpleado;
    }

    public void setRhEmpleado(RhEmpleado rhEmpleado) {
        this.rhEmpleado = rhEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (antSecuencial != null ? antSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhAnticipo)) {
            return false;
        }
        RhAnticipo other = (RhAnticipo) object;
        if ((this.antSecuencial == null && other.antSecuencial != null) || (this.antSecuencial != null && !this.antSecuencial.equals(other.antSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhAnticipo[ antSecuencial=" + antSecuencial + " ]";
    }
}
