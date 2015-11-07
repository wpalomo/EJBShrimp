/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "rh_salario_digno", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhSalarioDigno.findAll", query = "SELECT r FROM RhSalarioDigno r"),
    @NamedQuery(name = "RhSalarioDigno.findBySdigSecuencial", query = "SELECT r FROM RhSalarioDigno r WHERE r.sdigSecuencial = :sdigSecuencial"),
    @NamedQuery(name = "RhSalarioDigno.findBySdigDesde", query = "SELECT r FROM RhSalarioDigno r WHERE r.sdigDesde = :sdigDesde"),
    @NamedQuery(name = "RhSalarioDigno.findBySdigHasta", query = "SELECT r FROM RhSalarioDigno r WHERE r.sdigHasta = :sdigHasta"),
    @NamedQuery(name = "RhSalarioDigno.findBySdigValor", query = "SELECT r FROM RhSalarioDigno r WHERE r.sdigValor = :sdigValor"),
    @NamedQuery(name = "RhSalarioDigno.findBySdigFormaPago", query = "SELECT r FROM RhSalarioDigno r WHERE r.sdigFormaPago = :sdigFormaPago"),
    @NamedQuery(name = "RhSalarioDigno.findBySdigReversado", query = "SELECT r FROM RhSalarioDigno r WHERE r.sdigReversado = :sdigReversado"),
    @NamedQuery(name = "RhSalarioDigno.findBySecEmpresa", query = "SELECT r FROM RhSalarioDigno r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhSalarioDigno.findBySecCodigo", query = "SELECT r FROM RhSalarioDigno r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhSalarioDigno.findByConEmpresa", query = "SELECT r FROM RhSalarioDigno r WHERE r.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "RhSalarioDigno.findByConPeriodo", query = "SELECT r FROM RhSalarioDigno r WHERE r.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "RhSalarioDigno.findByConTipo", query = "SELECT r FROM RhSalarioDigno r WHERE r.conTipo = :conTipo"),
    @NamedQuery(name = "RhSalarioDigno.findByConNumero", query = "SELECT r FROM RhSalarioDigno r WHERE r.conNumero = :conNumero")})
public class RhSalarioDigno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sdig_secuencial")
    private Integer sdigSecuencial;
    @Basic(optional = false)
    @Column(name = "sdig_desde")
    @Temporal(TemporalType.DATE)
    private Date sdigDesde;
    @Basic(optional = false)
    @Column(name = "sdig_hasta")
    @Temporal(TemporalType.DATE)
    private Date sdigHasta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "sdig_valor")
    private BigDecimal sdigValor;
    @Basic(optional = false)
    @Column(name = "sdig_forma_pago")
    private String sdigFormaPago;
    @Basic(optional = false)
    @Column(name = "sdig_reversado")
    private boolean sdigReversado;
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

    public RhSalarioDigno() {
    }

    public RhSalarioDigno(Integer sdigSecuencial) {
        this.sdigSecuencial = sdigSecuencial;
    }

    public RhSalarioDigno(Integer sdigSecuencial, Date sdigDesde, Date sdigHasta, BigDecimal sdigValor, String sdigFormaPago, boolean sdigReversado, String secEmpresa, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.sdigSecuencial = sdigSecuencial;
        this.sdigDesde = sdigDesde;
        this.sdigHasta = sdigHasta;
        this.sdigValor = sdigValor;
        this.sdigFormaPago = sdigFormaPago;
        this.sdigReversado = sdigReversado;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
    }

    public Integer getSdigSecuencial() {
        return sdigSecuencial;
    }

    public void setSdigSecuencial(Integer sdigSecuencial) {
        this.sdigSecuencial = sdigSecuencial;
    }

    public Date getSdigDesde() {
        return sdigDesde;
    }

    public void setSdigDesde(Date sdigDesde) {
        this.sdigDesde = sdigDesde;
    }

    public Date getSdigHasta() {
        return sdigHasta;
    }

    public void setSdigHasta(Date sdigHasta) {
        this.sdigHasta = sdigHasta;
    }

    public BigDecimal getSdigValor() {
        return sdigValor;
    }

    public void setSdigValor(BigDecimal sdigValor) {
        this.sdigValor = sdigValor;
    }

    public String getSdigFormaPago() {
        return sdigFormaPago;
    }

    public void setSdigFormaPago(String sdigFormaPago) {
        this.sdigFormaPago = sdigFormaPago;
    }

    public boolean getSdigReversado() {
        return sdigReversado;
    }

    public void setSdigReversado(boolean sdigReversado) {
        this.sdigReversado = sdigReversado;
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
        hash += (sdigSecuencial != null ? sdigSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhSalarioDigno)) {
            return false;
        }
        RhSalarioDigno other = (RhSalarioDigno) object;
        if ((this.sdigSecuencial == null && other.sdigSecuencial != null) || (this.sdigSecuencial != null && !this.sdigSecuencial.equals(other.sdigSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhSalarioDigno[ sdigSecuencial=" + sdigSecuencial + " ]";
    }
}
