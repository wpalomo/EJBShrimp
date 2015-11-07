/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer2
 */
@Entity
@Table(name = "car_pagos_anticipos", schema = "cartera")
@NamedQueries({
    @NamedQuery(name = "CarPagosAnticipos.findAll", query = "SELECT c FROM CarPagosAnticipos c"),
    @NamedQuery(name = "CarPagosAnticipos.findByAntEmpresa", query = "SELECT c FROM CarPagosAnticipos c WHERE c.carPagosAnticiposPK.antEmpresa = :antEmpresa"),
    @NamedQuery(name = "CarPagosAnticipos.findByAntPeriodo", query = "SELECT c FROM CarPagosAnticipos c WHERE c.carPagosAnticiposPK.antPeriodo = :antPeriodo"),
    @NamedQuery(name = "CarPagosAnticipos.findByAntTipo", query = "SELECT c FROM CarPagosAnticipos c WHERE c.carPagosAnticiposPK.antTipo = :antTipo"),
    @NamedQuery(name = "CarPagosAnticipos.findByAntNumero", query = "SELECT c FROM CarPagosAnticipos c WHERE c.carPagosAnticiposPK.antNumero = :antNumero"),
    @NamedQuery(name = "CarPagosAnticipos.findByAntValor", query = "SELECT c FROM CarPagosAnticipos c WHERE c.antValor = :antValor"),
    @NamedQuery(name = "CarPagosAnticipos.findByAntPagado", query = "SELECT c FROM CarPagosAnticipos c WHERE c.antPagado = :antPagado"),
    @NamedQuery(name = "CarPagosAnticipos.findByAntReversado", query = "SELECT c FROM CarPagosAnticipos c WHERE c.antReversado = :antReversado"),
    @NamedQuery(name = "CarPagosAnticipos.findByProvEmpresa", query = "SELECT c FROM CarPagosAnticipos c WHERE c.provEmpresa = :provEmpresa"),
    @NamedQuery(name = "CarPagosAnticipos.findByProvCodigo", query = "SELECT c FROM CarPagosAnticipos c WHERE c.provCodigo = :provCodigo"),
    @NamedQuery(name = "CarPagosAnticipos.findBySecEmpresa", query = "SELECT c FROM CarPagosAnticipos c WHERE c.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "CarPagosAnticipos.findBySecCodigo", query = "SELECT c FROM CarPagosAnticipos c WHERE c.secCodigo = :secCodigo"),
    @NamedQuery(name = "CarPagosAnticipos.findByUsrEmpresa", query = "SELECT c FROM CarPagosAnticipos c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "CarPagosAnticipos.findByUsrCodigo", query = "SELECT c FROM CarPagosAnticipos c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "CarPagosAnticipos.findByUsrFechaInserta", query = "SELECT c FROM CarPagosAnticipos c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class CarPagosAnticipos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarPagosAnticiposPK carPagosAnticiposPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ant_valor")
    private BigDecimal antValor;
    @Basic(optional = false)
    @Column(name = "ant_pagado")
    private boolean antPagado;
    @Basic(optional = false)
    @Column(name = "ant_reversado")
    private boolean antReversado;
    @Basic(optional = false)
    @Column(name = "prov_empresa")
    private String provEmpresa;
    @Basic(optional = false)
    @Column(name = "prov_codigo")
    private String provCodigo;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
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
    @JoinColumn(name = "fp_secuencial", referencedColumnName = "fp_secuencial")
    @ManyToOne(optional = false)
    private CarPagosForma fpSecuencial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carPagosAnticipos")
    private List<CarPagosDetalleAnticipos> carPagosDetalleAnticiposList;

    public CarPagosAnticipos() {
    }

    public CarPagosAnticipos(CarPagosAnticiposPK carPagosAnticiposPK) {
        this.carPagosAnticiposPK = carPagosAnticiposPK;
    }

    public CarPagosAnticipos(CarPagosAnticiposPK carPagosAnticiposPK, BigDecimal antValor, boolean antPagado, boolean antReversado, String provEmpresa, String provCodigo, String secEmpresa, String secCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.carPagosAnticiposPK = carPagosAnticiposPK;
        this.antValor = antValor;
        this.antPagado = antPagado;
        this.antReversado = antReversado;
        this.provEmpresa = provEmpresa;
        this.provCodigo = provCodigo;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public CarPagosAnticipos(String antEmpresa, String antPeriodo, String antTipo, String antNumero) {
        this.carPagosAnticiposPK = new CarPagosAnticiposPK(antEmpresa, antPeriodo, antTipo, antNumero);
    }

    public CarPagosAnticiposPK getCarPagosAnticiposPK() {
        return carPagosAnticiposPK;
    }

    public void setCarPagosAnticiposPK(CarPagosAnticiposPK carPagosAnticiposPK) {
        this.carPagosAnticiposPK = carPagosAnticiposPK;
    }

    public BigDecimal getAntValor() {
        return antValor;
    }

    public void setAntValor(BigDecimal antValor) {
        this.antValor = antValor;
    }

    public boolean getAntPagado() {
        return antPagado;
    }

    public void setAntPagado(boolean antPagado) {
        this.antPagado = antPagado;
    }

    public boolean getAntReversado() {
        return antReversado;
    }

    public void setAntReversado(boolean antReversado) {
        this.antReversado = antReversado;
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

    public CarPagosForma getFpSecuencial() {
        return fpSecuencial;
    }

    public void setFpSecuencial(CarPagosForma fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
    }

    public List<CarPagosDetalleAnticipos> getCarPagosDetalleAnticiposList() {
        return carPagosDetalleAnticiposList;
    }

    public void setCarPagosDetalleAnticiposList(List<CarPagosDetalleAnticipos> carPagosDetalleAnticiposList) {
        this.carPagosDetalleAnticiposList = carPagosDetalleAnticiposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carPagosAnticiposPK != null ? carPagosAnticiposPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarPagosAnticipos)) {
            return false;
        }
        CarPagosAnticipos other = (CarPagosAnticipos) object;
        if ((this.carPagosAnticiposPK == null && other.carPagosAnticiposPK != null) || (this.carPagosAnticiposPK != null && !this.carPagosAnticiposPK.equals(other.carPagosAnticiposPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarPagosAnticipos[ carPagosAnticiposPK=" + carPagosAnticiposPK + " ]";
    }
    
}
