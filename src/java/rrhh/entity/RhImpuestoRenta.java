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
@Table(name = "rh_impuesto_renta", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhImpuestoRenta.findAll", query = "SELECT r FROM RhImpuestoRenta r"),
    @NamedQuery(name = "RhImpuestoRenta.findByRtaSecuencial", query = "SELECT r FROM RhImpuestoRenta r WHERE r.rtaSecuencial = :rtaSecuencial"),
    @NamedQuery(name = "RhImpuestoRenta.findByRtaFraccionBasica", query = "SELECT r FROM RhImpuestoRenta r WHERE r.rtaFraccionBasica = :rtaFraccionBasica"),
    @NamedQuery(name = "RhImpuestoRenta.findByRtaFraccionExcedente", query = "SELECT r FROM RhImpuestoRenta r WHERE r.rtaFraccionExcedente = :rtaFraccionExcedente"),
    @NamedQuery(name = "RhImpuestoRenta.findByRtaImpuestoFraccionBasica", query = "SELECT r FROM RhImpuestoRenta r WHERE r.rtaImpuestoFraccionBasica = :rtaImpuestoFraccionBasica"),
    @NamedQuery(name = "RhImpuestoRenta.findByRtaImpuestoFraccionExcedente", query = "SELECT r FROM RhImpuestoRenta r WHERE r.rtaImpuestoFraccionExcedente = :rtaImpuestoFraccionExcedente"),
    @NamedQuery(name = "RhImpuestoRenta.findByRtaDesde", query = "SELECT r FROM RhImpuestoRenta r WHERE r.rtaDesde = :rtaDesde"),
    @NamedQuery(name = "RhImpuestoRenta.findByRtaHasta", query = "SELECT r FROM RhImpuestoRenta r WHERE r.rtaHasta = :rtaHasta")})
public class RhImpuestoRenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rta_secuencial")
    private Integer rtaSecuencial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "rta_fraccion_basica")
    private BigDecimal rtaFraccionBasica;
    @Basic(optional = false)
    @Column(name = "rta_fraccion_excedente")
    private BigDecimal rtaFraccionExcedente;
    @Basic(optional = false)
    @Column(name = "rta_impuesto_fraccion_basica")
    private BigDecimal rtaImpuestoFraccionBasica;
    @Basic(optional = false)
    @Column(name = "rta_impuesto_fraccion_excedente")
    private BigDecimal rtaImpuestoFraccionExcedente;
    @Basic(optional = false)
    @Column(name = "rta_desde")
    @Temporal(TemporalType.DATE)
    private Date rtaDesde;
    @Basic(optional = false)
    @Column(name = "rta_hasta")
    @Temporal(TemporalType.DATE)
    private Date rtaHasta;

    public RhImpuestoRenta() {
    }

    public RhImpuestoRenta(Integer rtaSecuencial) {
        this.rtaSecuencial = rtaSecuencial;
    }

    public RhImpuestoRenta(Integer rtaSecuencial, BigDecimal rtaFraccionBasica, BigDecimal rtaFraccionExcedente, BigDecimal rtaImpuestoFraccionBasica, BigDecimal rtaImpuestoFraccionExcedente, Date rtaDesde, Date rtaHasta) {
        this.rtaSecuencial = rtaSecuencial;
        this.rtaFraccionBasica = rtaFraccionBasica;
        this.rtaFraccionExcedente = rtaFraccionExcedente;
        this.rtaImpuestoFraccionBasica = rtaImpuestoFraccionBasica;
        this.rtaImpuestoFraccionExcedente = rtaImpuestoFraccionExcedente;
        this.rtaDesde = rtaDesde;
        this.rtaHasta = rtaHasta;
    }

    public Integer getRtaSecuencial() {
        return rtaSecuencial;
    }

    public void setRtaSecuencial(Integer rtaSecuencial) {
        this.rtaSecuencial = rtaSecuencial;
    }

    public BigDecimal getRtaFraccionBasica() {
        return rtaFraccionBasica;
    }

    public void setRtaFraccionBasica(BigDecimal rtaFraccionBasica) {
        this.rtaFraccionBasica = rtaFraccionBasica;
    }

    public BigDecimal getRtaFraccionExcedente() {
        return rtaFraccionExcedente;
    }

    public void setRtaFraccionExcedente(BigDecimal rtaFraccionExcedente) {
        this.rtaFraccionExcedente = rtaFraccionExcedente;
    }

    public BigDecimal getRtaImpuestoFraccionBasica() {
        return rtaImpuestoFraccionBasica;
    }

    public void setRtaImpuestoFraccionBasica(BigDecimal rtaImpuestoFraccionBasica) {
        this.rtaImpuestoFraccionBasica = rtaImpuestoFraccionBasica;
    }

    public BigDecimal getRtaImpuestoFraccionExcedente() {
        return rtaImpuestoFraccionExcedente;
    }

    public void setRtaImpuestoFraccionExcedente(BigDecimal rtaImpuestoFraccionExcedente) {
        this.rtaImpuestoFraccionExcedente = rtaImpuestoFraccionExcedente;
    }

    public Date getRtaDesde() {
        return rtaDesde;
    }

    public void setRtaDesde(Date rtaDesde) {
        this.rtaDesde = rtaDesde;
    }

    public Date getRtaHasta() {
        return rtaHasta;
    }

    public void setRtaHasta(Date rtaHasta) {
        this.rtaHasta = rtaHasta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rtaSecuencial != null ? rtaSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhImpuestoRenta)) {
            return false;
        }
        RhImpuestoRenta other = (RhImpuestoRenta) object;
        if ((this.rtaSecuencial == null && other.rtaSecuencial != null) || (this.rtaSecuencial != null && !this.rtaSecuencial.equals(other.rtaSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhImpuestoRenta[ rtaSecuencial=" + rtaSecuencial + " ]";
    }
}
