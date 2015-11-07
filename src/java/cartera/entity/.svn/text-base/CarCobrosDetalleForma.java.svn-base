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
@Table(name = "car_cobros_detalle_forma", schema = "cartera")
@NamedQueries({
    @NamedQuery(name = "CarCobrosDetalleForma.findAll", query = "SELECT c FROM CarCobrosDetalleForma c"),
    @NamedQuery(name = "CarCobrosDetalleForma.findByDetSecuencial", query = "SELECT c FROM CarCobrosDetalleForma c WHERE c.detSecuencial = :detSecuencial"),
    @NamedQuery(name = "CarCobrosDetalleForma.findByDetValor", query = "SELECT c FROM CarCobrosDetalleForma c WHERE c.detValor = :detValor"),
    @NamedQuery(name = "CarCobrosDetalleForma.findByDetReferencia", query = "SELECT c FROM CarCobrosDetalleForma c WHERE c.detReferencia = :detReferencia"),
    @NamedQuery(name = "CarCobrosDetalleForma.findByDetObservaciones", query = "SELECT c FROM CarCobrosDetalleForma c WHERE c.detObservaciones = :detObservaciones")})
public class CarCobrosDetalleForma implements Serializable {
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
    private CarCobrosForma fpSecuencial;
    @JoinColumns({
        @JoinColumn(name = "cob_empresa", referencedColumnName = "cob_empresa"),
        @JoinColumn(name = "cob_periodo", referencedColumnName = "cob_periodo"),
        @JoinColumn(name = "cob_tipo", referencedColumnName = "cob_tipo"),
        @JoinColumn(name = "cob_numero", referencedColumnName = "cob_numero")})
    @ManyToOne(optional = false)
    private CarCobros carCobros;

    public CarCobrosDetalleForma() {
    }

    public CarCobrosDetalleForma(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public CarCobrosDetalleForma(Integer detSecuencial, BigDecimal detValor) {
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

    public CarCobrosForma getFpSecuencial() {
        return fpSecuencial;
    }

    public void setFpSecuencial(CarCobrosForma fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
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
        if (!(object instanceof CarCobrosDetalleForma)) {
            return false;
        }
        CarCobrosDetalleForma other = (CarCobrosDetalleForma) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarCobrosDetalleForma[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
