/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer2
 */
@Entity
@Table(name = "car_pagos_forma", schema = "cartera")
@NamedQueries({
    @NamedQuery(name = "CarPagosForma.findAll", query = "SELECT c FROM CarPagosForma c"),
    @NamedQuery(name = "CarPagosForma.findByFpSecuencial", query = "SELECT c FROM CarPagosForma c WHERE c.fpSecuencial = :fpSecuencial"),
    @NamedQuery(name = "CarPagosForma.findByFpDetalle", query = "SELECT c FROM CarPagosForma c WHERE c.fpDetalle = :fpDetalle"),
    @NamedQuery(name = "CarPagosForma.findByFpInactivo", query = "SELECT c FROM CarPagosForma c WHERE c.fpInactivo = :fpInactivo"),
    @NamedQuery(name = "CarPagosForma.findBySecEmpresa", query = "SELECT c FROM CarPagosForma c WHERE c.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "CarPagosForma.findBySecCodigo", query = "SELECT c FROM CarPagosForma c WHERE c.secCodigo = :secCodigo"),
    @NamedQuery(name = "CarPagosForma.findByCtaEmpresa", query = "SELECT c FROM CarPagosForma c WHERE c.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "CarPagosForma.findByCtaCodigo", query = "SELECT c FROM CarPagosForma c WHERE c.ctaCodigo = :ctaCodigo"),
    @NamedQuery(name = "CarPagosForma.findByUsrEmpresa", query = "SELECT c FROM CarPagosForma c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "CarPagosForma.findByUsrCodigo", query = "SELECT c FROM CarPagosForma c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "CarPagosForma.findByUsrFechaInserta", query = "SELECT c FROM CarPagosForma c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class CarPagosForma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fp_secuencial")
    private Integer fpSecuencial;
    @Basic(optional = false)
    @Column(name = "fp_detalle")
    private String fpDetalle;
    @Basic(optional = false)
    @Column(name = "fp_inactivo")
    private boolean fpInactivo;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
    @Basic(optional = false)
    @Column(name = "cta_empresa")
    private String ctaEmpresa;
    @Basic(optional = false)
    @Column(name = "cta_codigo")
    private String ctaCodigo;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fpSecuencial")
    private List<CarPagosAnticipos> carPagosAnticiposList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fpSecuencial")
    private List<CarPagosDetalleForma> carPagosDetalleFormaList;

    public CarPagosForma() {
    }

    public CarPagosForma(Integer fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
    }

    public CarPagosForma(Integer fpSecuencial, String fpDetalle, boolean fpInactivo, String secEmpresa, String secCodigo, String ctaEmpresa, String ctaCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.fpSecuencial = fpSecuencial;
        this.fpDetalle = fpDetalle;
        this.fpInactivo = fpInactivo;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.ctaEmpresa = ctaEmpresa;
        this.ctaCodigo = ctaCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Integer getFpSecuencial() {
        return fpSecuencial;
    }

    public void setFpSecuencial(Integer fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
    }

    public String getFpDetalle() {
        return fpDetalle;
    }

    public void setFpDetalle(String fpDetalle) {
        this.fpDetalle = fpDetalle;
    }

    public boolean getFpInactivo() {
        return fpInactivo;
    }

    public void setFpInactivo(boolean fpInactivo) {
        this.fpInactivo = fpInactivo;
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

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getCtaCodigo() {
        return ctaCodigo;
    }

    public void setCtaCodigo(String ctaCodigo) {
        this.ctaCodigo = ctaCodigo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Date getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(Date usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }

    public List<CarPagosAnticipos> getCarPagosAnticiposList() {
        return carPagosAnticiposList;
    }

    public void setCarPagosAnticiposList(List<CarPagosAnticipos> carPagosAnticiposList) {
        this.carPagosAnticiposList = carPagosAnticiposList;
    }

    public List<CarPagosDetalleForma> getCarPagosDetalleFormaList() {
        return carPagosDetalleFormaList;
    }

    public void setCarPagosDetalleFormaList(List<CarPagosDetalleForma> carPagosDetalleFormaList) {
        this.carPagosDetalleFormaList = carPagosDetalleFormaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fpSecuencial != null ? fpSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarPagosForma)) {
            return false;
        }
        CarPagosForma other = (CarPagosForma) object;
        if ((this.fpSecuencial == null && other.fpSecuencial != null) || (this.fpSecuencial != null && !this.fpSecuencial.equals(other.fpSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarPagosForma[ fpSecuencial=" + fpSecuencial + " ]";
    }
    
}
