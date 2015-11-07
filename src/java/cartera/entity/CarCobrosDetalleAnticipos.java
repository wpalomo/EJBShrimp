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
@Table(name = "car_cobros_detalle_anticipos", schema = "cartera")
@NamedQueries({
    @NamedQuery(name = "CarCobrosDetalleAnticipos.findAll", query = "SELECT c FROM CarCobrosDetalleAnticipos c"),
    @NamedQuery(name = "CarCobrosDetalleAnticipos.findByDetSecuencial", query = "SELECT c FROM CarCobrosDetalleAnticipos c WHERE c.detSecuencial = :detSecuencial"),
    @NamedQuery(name = "CarCobrosDetalleAnticipos.findByDetValor", query = "SELECT c FROM CarCobrosDetalleAnticipos c WHERE c.detValor = :detValor"),
    @NamedQuery(name = "CarCobrosDetalleAnticipos.findByDetObservaciones", query = "SELECT c FROM CarCobrosDetalleAnticipos c WHERE c.detObservaciones = :detObservaciones")})
public class CarCobrosDetalleAnticipos implements Serializable {
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
    @Column(name = "det_observaciones")
    private String detObservaciones;
    @JoinColumns({
        @JoinColumn(name = "ant_empresa", referencedColumnName = "ant_empresa"),
        @JoinColumn(name = "ant_periodo", referencedColumnName = "ant_periodo"),
        @JoinColumn(name = "ant_tipo", referencedColumnName = "ant_tipo"),
        @JoinColumn(name = "ant_numero", referencedColumnName = "ant_numero")})
    @ManyToOne(optional = false)
    private CarCobrosAnticipos carCobrosAnticipos;
    @JoinColumns({
        @JoinColumn(name = "cob_empresa", referencedColumnName = "cob_empresa"),
        @JoinColumn(name = "cob_periodo", referencedColumnName = "cob_periodo"),
        @JoinColumn(name = "cob_tipo", referencedColumnName = "cob_tipo"),
        @JoinColumn(name = "cob_numero", referencedColumnName = "cob_numero")})
    @ManyToOne(optional = false)
    private CarCobros carCobros;

    public CarCobrosDetalleAnticipos() {
    }

    public CarCobrosDetalleAnticipos(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public CarCobrosDetalleAnticipos(Integer detSecuencial, BigDecimal detValor) {
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

    public String getDetObservaciones() {
        return detObservaciones;
    }

    public void setDetObservaciones(String detObservaciones) {
        this.detObservaciones = detObservaciones;
    }

    public CarCobrosAnticipos getCarCobrosAnticipos() {
        return carCobrosAnticipos;
    }

    public void setCarCobrosAnticipos(CarCobrosAnticipos carCobrosAnticipos) {
        this.carCobrosAnticipos = carCobrosAnticipos;
    }

    public CarCobros getCarCobros() {
        return carCobros;
    }

    public void setCarCobros(CarCobros carCobros) {
        this.carCobros = carCobros;
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
        if (!(object instanceof CarCobrosDetalleAnticipos)) {
            return false;
        }
        CarCobrosDetalleAnticipos other = (CarCobrosDetalleAnticipos) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarCobrosDetalleAnticipos[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
