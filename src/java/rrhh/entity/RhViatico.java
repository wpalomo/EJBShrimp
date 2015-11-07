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
@Table(name = "rh_viatico", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhViatico.findAll", query = "SELECT r FROM RhViatico r"),
    @NamedQuery(name = "RhViatico.findByViaSecuencial", query = "SELECT r FROM RhViatico r WHERE r.viaSecuencial = :viaSecuencial"),
    @NamedQuery(name = "RhViatico.findByViaValor", query = "SELECT r FROM RhViatico r WHERE r.viaValor = :viaValor"),
    @NamedQuery(name = "RhViatico.findByViaReversado", query = "SELECT r FROM RhViatico r WHERE r.viaReversado = :viaReversado"),
    @NamedQuery(name = "RhViatico.findBySecEmpresa", query = "SELECT r FROM RhViatico r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhViatico.findBySecCodigo", query = "SELECT r FROM RhViatico r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhViatico.findByConEmpresa", query = "SELECT r FROM RhViatico r WHERE r.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "RhViatico.findByConPeriodo", query = "SELECT r FROM RhViatico r WHERE r.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "RhViatico.findByConTipo", query = "SELECT r FROM RhViatico r WHERE r.conTipo = :conTipo"),
    @NamedQuery(name = "RhViatico.findByConNumero", query = "SELECT r FROM RhViatico r WHERE r.conNumero = :conNumero")})
public class RhViatico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "via_secuencial")
    private Integer viaSecuencial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "via_valor")
    private BigDecimal viaValor;
    @Basic(optional = false)
    @Column(name = "via_reversado")
    private boolean viaReversado;
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

    public RhViatico() {
    }

    public RhViatico(Integer viaSecuencial) {
        this.viaSecuencial = viaSecuencial;
    }

    public RhViatico(Integer viaSecuencial, BigDecimal viaValor, boolean viaReversado, String secEmpresa, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.viaSecuencial = viaSecuencial;
        this.viaValor = viaValor;
        this.viaReversado = viaReversado;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
    }

    public Integer getViaSecuencial() {
        return viaSecuencial;
    }

    public void setViaSecuencial(Integer viaSecuencial) {
        this.viaSecuencial = viaSecuencial;
    }

    public BigDecimal getViaValor() {
        return viaValor;
    }

    public void setViaValor(BigDecimal viaValor) {
        this.viaValor = viaValor;
    }

    public boolean getViaReversado() {
        return viaReversado;
    }

    public void setViaReversado(boolean viaReversado) {
        this.viaReversado = viaReversado;
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
        hash += (viaSecuencial != null ? viaSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RhViatico)) {
            return false;
        }
        RhViatico other = (RhViatico) object;
        if ((this.viaSecuencial == null && other.viaSecuencial != null) || (this.viaSecuencial != null && !this.viaSecuencial.equals(other.viaSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhViatico[ viaSecuencial=" + viaSecuencial + " ]";
    }
}
