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
@Table(name = "rh_prestamo", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhPrestamo.findAll", query = "SELECT r FROM RhPrestamo r"),
    @NamedQuery(name = "RhPrestamo.findByPreSecuencial", query = "SELECT r FROM RhPrestamo r WHERE r.preSecuencial = :preSecuencial"),
    @NamedQuery(name = "RhPrestamo.findByPreValor", query = "SELECT r FROM RhPrestamo r WHERE r.preValor = :preValor"),
    @NamedQuery(name = "RhPrestamo.findByPreNumeroPagos", query = "SELECT r FROM RhPrestamo r WHERE r.preNumeroPagos = :preNumeroPagos"),
    @NamedQuery(name = "RhPrestamo.findByPreFormaPago", query = "SELECT r FROM RhPrestamo r WHERE r.preFormaPago = :preFormaPago"),
    @NamedQuery(name = "RhPrestamo.findByPreReversado", query = "SELECT r FROM RhPrestamo r WHERE r.preReversado = :preReversado"),
    @NamedQuery(name = "RhPrestamo.findBySecEmpresa", query = "SELECT r FROM RhPrestamo r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhPrestamo.findBySecCodigo", query = "SELECT r FROM RhPrestamo r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhPrestamo.findByConEmpresa", query = "SELECT r FROM RhPrestamo r WHERE r.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "RhPrestamo.findByConPeriodo", query = "SELECT r FROM RhPrestamo r WHERE r.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "RhPrestamo.findByConTipo", query = "SELECT r FROM RhPrestamo r WHERE r.conTipo = :conTipo"),
    @NamedQuery(name = "RhPrestamo.findByConNumero", query = "SELECT r FROM RhPrestamo r WHERE r.conNumero = :conNumero")})
public class RhPrestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pre_secuencial")
    private Integer preSecuencial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "pre_valor")
    private BigDecimal preValor;
    @Basic(optional = false)
    @Column(name = "pre_numero_pagos")
    private short preNumeroPagos;
    @Basic(optional = false)
    @Column(name = "pre_forma_pago")
    private String preFormaPago;
    @Basic(optional = false)
    @Column(name = "pre_reversado")
    private boolean preReversado;
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

    public RhPrestamo() {
    }

    public RhPrestamo(Integer preSecuencial) {
        this.preSecuencial = preSecuencial;
    }

    public RhPrestamo(Integer preSecuencial, BigDecimal preValor, short preNumeroPagos, String preFormaPago, boolean preReversado, String secEmpresa, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.preSecuencial = preSecuencial;
        this.preValor = preValor;
        this.preNumeroPagos = preNumeroPagos;
        this.preFormaPago = preFormaPago;
        this.preReversado = preReversado;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
    }

    public Integer getPreSecuencial() {
        return preSecuencial;
    }

    public void setPreSecuencial(Integer preSecuencial) {
        this.preSecuencial = preSecuencial;
    }

    public BigDecimal getPreValor() {
        return preValor;
    }

    public void setPreValor(BigDecimal preValor) {
        this.preValor = preValor;
    }

    public short getPreNumeroPagos() {
        return preNumeroPagos;
    }

    public void setPreNumeroPagos(short preNumeroPagos) {
        this.preNumeroPagos = preNumeroPagos;
    }

    public String getPreFormaPago() {
        return preFormaPago;
    }

    public void setPreFormaPago(String preFormaPago) {
        this.preFormaPago = preFormaPago;
    }

    public boolean getPreReversado() {
        return preReversado;
    }

    public void setPreReversado(boolean preReversado) {
        this.preReversado = preReversado;
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
        hash += (preSecuencial != null ? preSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhPrestamo)) {
            return false;
        }
        RhPrestamo other = (RhPrestamo) object;
        if ((this.preSecuencial == null && other.preSecuencial != null) || (this.preSecuencial != null && !this.preSecuencial.equals(other.preSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhPrestamo[ preSecuencial=" + preSecuencial + " ]";
    }
}
