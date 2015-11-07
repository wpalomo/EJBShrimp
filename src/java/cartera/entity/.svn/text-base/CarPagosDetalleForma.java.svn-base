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
@Table(name = "car_pagos_detalle_forma", schema = "cartera")
@NamedQueries({
    @NamedQuery(name = "CarPagosDetalleForma.findAll", query = "SELECT c FROM CarPagosDetalleForma c"),
    @NamedQuery(name = "CarPagosDetalleForma.findByDetSecuencial", query = "SELECT c FROM CarPagosDetalleForma c WHERE c.detSecuencial = :detSecuencial"),
    @NamedQuery(name = "CarPagosDetalleForma.findByDetValor", query = "SELECT c FROM CarPagosDetalleForma c WHERE c.detValor = :detValor"),
    @NamedQuery(name = "CarPagosDetalleForma.findByDetReferencia", query = "SELECT c FROM CarPagosDetalleForma c WHERE c.detReferencia = :detReferencia"),
    @NamedQuery(name = "CarPagosDetalleForma.findByDetObservaciones", query = "SELECT c FROM CarPagosDetalleForma c WHERE c.detObservaciones = :detObservaciones")})
public class CarPagosDetalleForma implements Serializable {
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
    @Column(name = "det_referencia")
    private String detReferencia;
    @Column(name = "det_observaciones")
    private String detObservaciones;
    @JoinColumn(name = "fp_secuencial", referencedColumnName = "fp_secuencial")
    @ManyToOne(optional = false)
    private CarPagosForma fpSecuencial;
    @JoinColumns({
        @JoinColumn(name = "pag_empresa", referencedColumnName = "pag_empresa"),
        @JoinColumn(name = "pag_periodo", referencedColumnName = "pag_periodo"),
        @JoinColumn(name = "pag_tipo", referencedColumnName = "pag_tipo"),
        @JoinColumn(name = "pag_numero", referencedColumnName = "pag_numero")})
    @ManyToOne(optional = false)
    private CarPagos carPagos;

    public CarPagosDetalleForma() {
    }

    public CarPagosDetalleForma(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public CarPagosDetalleForma(Integer detSecuencial, BigDecimal detValor) {
        this.detSecuencial = detSecuencial;
        this.detValor = detValor;
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

    public String getDetReferencia() {
        return detReferencia;
    }

    public void setDetReferencia(String detReferencia) {
        this.detReferencia = detReferencia;
    }

    public String getDetObservaciones() {
        return detObservaciones;
    }

    public void setDetObservaciones(String detObservaciones) {
        this.detObservaciones = detObservaciones;
    }

    public CarPagosForma getFpSecuencial() {
        return fpSecuencial;
    }

    public void setFpSecuencial(CarPagosForma fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
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
        if (!(object instanceof CarPagosDetalleForma)) {
            return false;
        }
        CarPagosDetalleForma other = (CarPagosDetalleForma) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarPagosDetalleForma[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
