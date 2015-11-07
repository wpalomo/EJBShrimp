/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author developer2
 */
@Entity
@Table(name = "car_pagos_detalle_compras", schema = "cartera")
@NamedQueries({
    @NamedQuery(name = "CarPagosDetalleCompras.findAll", query = "SELECT c FROM CarPagosDetalleCompras c"),
    @NamedQuery(name = "CarPagosDetalleCompras.findByDetSecuencial", query = "SELECT c FROM CarPagosDetalleCompras c WHERE c.detSecuencial = :detSecuencial"),
    @NamedQuery(name = "CarPagosDetalleCompras.findByDetValor", query = "SELECT c FROM CarPagosDetalleCompras c WHERE c.detValor = :detValor"),
    @NamedQuery(name = "CarPagosDetalleCompras.findByCompEmpresa", query = "SELECT c FROM CarPagosDetalleCompras c WHERE c.compEmpresa = :compEmpresa"),
    @NamedQuery(name = "CarPagosDetalleCompras.findByCompPeriodo", query = "SELECT c FROM CarPagosDetalleCompras c WHERE c.compPeriodo = :compPeriodo"),
    @NamedQuery(name = "CarPagosDetalleCompras.findByCompMotivo", query = "SELECT c FROM CarPagosDetalleCompras c WHERE c.compMotivo = :compMotivo"),
    @NamedQuery(name = "CarPagosDetalleCompras.findByCompNumero", query = "SELECT c FROM CarPagosDetalleCompras c WHERE c.compNumero = :compNumero"),
    @NamedQuery(name = "CarPagosDetalleCompras.findBySecEmpresa", query = "SELECT c FROM CarPagosDetalleCompras c WHERE c.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "CarPagosDetalleCompras.findBySecCodigo", query = "SELECT c FROM CarPagosDetalleCompras c WHERE c.secCodigo = :secCodigo")})
public class CarPagosDetalleCompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_secuencial")
    private Integer detSecuencial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "det_valor")
    private BigDecimal detValor;
    @Basic(optional = false)
    @Column(name = "comp_empresa")
    private String compEmpresa;
    @Basic(optional = false)
    @Column(name = "comp_periodo")
    private String compPeriodo;
    @Basic(optional = false)
    @Column(name = "comp_motivo")
    private String compMotivo;
    @Basic(optional = false)
    @Column(name = "comp_numero")
    private String compNumero;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
    @JoinColumns({
        @JoinColumn(name = "pag_empresa", referencedColumnName = "pag_empresa"),
        @JoinColumn(name = "pag_periodo", referencedColumnName = "pag_periodo"),
        @JoinColumn(name = "pag_tipo", referencedColumnName = "pag_tipo"),
        @JoinColumn(name = "pag_numero", referencedColumnName = "pag_numero")})
    @ManyToOne(optional = false)
    private CarPagos carPagos;

    public CarPagosDetalleCompras() {
    }

    public CarPagosDetalleCompras(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public CarPagosDetalleCompras(Integer detSecuencial, BigDecimal detValor, String compEmpresa, String compPeriodo, String compMotivo, String compNumero, String secEmpresa, String secCodigo) {
        this.detSecuencial = detSecuencial;
        this.detValor = detValor;
        this.compEmpresa = compEmpresa;
        this.compPeriodo = compPeriodo;
        this.compMotivo = compMotivo;
        this.compNumero = compNumero;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
    }

    public Integer getDetSecuencial() {
        return detSecuencial;
    }

    public void setDetSecuencial(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public BigDecimal getDetValor() {
        return detValor;
    }

    public void setDetValor(BigDecimal detValor) {
        this.detValor = detValor;
    }

    public String getCompEmpresa() {
        return compEmpresa;
    }

    public void setCompEmpresa(String compEmpresa) {
        this.compEmpresa = compEmpresa;
    }

    public String getCompPeriodo() {
        return compPeriodo;
    }

    public void setCompPeriodo(String compPeriodo) {
        this.compPeriodo = compPeriodo;
    }

    public String getCompMotivo() {
        return compMotivo;
    }

    public void setCompMotivo(String compMotivo) {
        this.compMotivo = compMotivo;
    }

    public String getCompNumero() {
        return compNumero;
    }

    public void setCompNumero(String compNumero) {
        this.compNumero = compNumero;
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

    public CarPagos getCarPagos() {
        return carPagos;
    }

    public void setCarPagos(CarPagos carPagos) {
        this.carPagos = carPagos;
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
        if (!(object instanceof CarPagosDetalleCompras)) {
            return false;
        }
        CarPagosDetalleCompras other = (CarPagosDetalleCompras) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarPagosDetalleCompras[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
