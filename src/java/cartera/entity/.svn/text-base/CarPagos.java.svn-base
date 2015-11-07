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
@Table(name = "car_pagos", schema = "cartera")
@NamedQueries({
    @NamedQuery(name = "CarPagos.findAll", query = "SELECT c FROM CarPagos c"),
    @NamedQuery(name = "CarPagos.findByPagEmpresa", query = "SELECT c FROM CarPagos c WHERE c.carPagosPK.pagEmpresa = :pagEmpresa"),
    @NamedQuery(name = "CarPagos.findByPagPeriodo", query = "SELECT c FROM CarPagos c WHERE c.carPagosPK.pagPeriodo = :pagPeriodo"),
    @NamedQuery(name = "CarPagos.findByPagTipo", query = "SELECT c FROM CarPagos c WHERE c.carPagosPK.pagTipo = :pagTipo"),
    @NamedQuery(name = "CarPagos.findByPagNumero", query = "SELECT c FROM CarPagos c WHERE c.carPagosPK.pagNumero = :pagNumero"),
    @NamedQuery(name = "CarPagos.findByPagReversado", query = "SELECT c FROM CarPagos c WHERE c.pagReversado = :pagReversado"),
    @NamedQuery(name = "CarPagos.findByProvEmpresa", query = "SELECT c FROM CarPagos c WHERE c.provEmpresa = :provEmpresa"),
    @NamedQuery(name = "CarPagos.findByProvCodigo", query = "SELECT c FROM CarPagos c WHERE c.provCodigo = :provCodigo"),
    @NamedQuery(name = "CarPagos.findByUsrEmpresa", query = "SELECT c FROM CarPagos c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "CarPagos.findByUsrCodigo", query = "SELECT c FROM CarPagos c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "CarPagos.findByUsrFechaInserta", query = "SELECT c FROM CarPagos c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class CarPagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarPagosPK carPagosPK;
    @Column(name = "pag_reversado")
    private Boolean pagReversado;
    @Basic(optional = false)
    @Column(name = "prov_empresa")
    private String provEmpresa;
    @Basic(optional = false)
    @Column(name = "prov_codigo")
    private String provCodigo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carPagos")
    private List<CarPagosDetalleCompras> carPagosDetalleComprasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carPagos")
    private List<CarPagosDetalleAnticipos> carPagosDetalleAnticiposList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carPagos")
    private List<CarPagosDetalleForma> carPagosDetalleFormaList;

    public CarPagos() {
    }

    public CarPagos(CarPagosPK carPagosPK) {
        this.carPagosPK = carPagosPK;
    }

    public CarPagos(CarPagosPK carPagosPK, String provEmpresa, String provCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.carPagosPK = carPagosPK;
        this.provEmpresa = provEmpresa;
        this.provCodigo = provCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public CarPagos(String pagEmpresa, String pagPeriodo, String pagTipo, String pagNumero) {
        this.carPagosPK = new CarPagosPK(pagEmpresa, pagPeriodo, pagTipo, pagNumero);
    }

    public CarPagosPK getCarPagosPK() {
        return carPagosPK;
    }

    public void setCarPagosPK(CarPagosPK carPagosPK) {
        this.carPagosPK = carPagosPK;
    }

    public Boolean getPagReversado() {
        return pagReversado;
    }

    public void setPagReversado(Boolean pagReversado) {
        this.pagReversado = pagReversado;
    }

    public String getProvEmpresa() {
        return provEmpresa;
    }

    public void setProvEmpresa(String provEmpresa) {
        this.provEmpresa = provEmpresa;
    }

    public String getProvCodigo() {
        return provCodigo;
    }

    public void setProvCodigo(String provCodigo) {
        this.provCodigo = provCodigo;
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

    public List<CarPagosDetalleCompras> getCarPagosDetalleComprasList() {
        return carPagosDetalleComprasList;
    }

    public void setCarPagosDetalleComprasList(List<CarPagosDetalleCompras> carPagosDetalleComprasList) {
        this.carPagosDetalleComprasList = carPagosDetalleComprasList;
    }

    public List<CarPagosDetalleAnticipos> getCarPagosDetalleAnticiposList() {
        return carPagosDetalleAnticiposList;
    }

    public void setCarPagosDetalleAnticiposList(List<CarPagosDetalleAnticipos> carPagosDetalleAnticiposList) {
        this.carPagosDetalleAnticiposList = carPagosDetalleAnticiposList;
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
        hash += (carPagosPK != null ? carPagosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarPagos)) {
            return false;
        }
        CarPagos other = (CarPagos) object;
        if ((this.carPagosPK == null && other.carPagosPK != null) || (this.carPagosPK != null && !this.carPagosPK.equals(other.carPagosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarPagos[ carPagosPK=" + carPagosPK + " ]";
    }
    
}
