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
@Table(name = "rh_parametros", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhParametros.findAll", query = "SELECT r FROM RhParametros r"),
    @NamedQuery(name = "RhParametros.findByParSecuencial", query = "SELECT r FROM RhParametros r WHERE r.parSecuencial = :parSecuencial"),
    @NamedQuery(name = "RhParametros.findByParDesde", query = "SELECT r FROM RhParametros r WHERE r.parDesde = :parDesde"),
    @NamedQuery(name = "RhParametros.findByParHasta", query = "SELECT r FROM RhParametros r WHERE r.parHasta = :parHasta"),
    @NamedQuery(name = "RhParametros.findByParIessPorcentajeAporteIndividual", query = "SELECT r FROM RhParametros r WHERE r.parIessPorcentajeAporteIndividual = :parIessPorcentajeAporteIndividual"),
    @NamedQuery(name = "RhParametros.findByParIessPorcentajeAporteExtendido", query = "SELECT r FROM RhParametros r WHERE r.parIessPorcentajeAporteExtendido = :parIessPorcentajeAporteExtendido"),
    @NamedQuery(name = "RhParametros.findByParIessPorcentajeAportePatronal", query = "SELECT r FROM RhParametros r WHERE r.parIessPorcentajeAportePatronal = :parIessPorcentajeAportePatronal"),
    @NamedQuery(name = "RhParametros.findByParIessPorcentajeIece", query = "SELECT r FROM RhParametros r WHERE r.parIessPorcentajeIece = :parIessPorcentajeIece"),
    @NamedQuery(name = "RhParametros.findByParIessPorcentajeSecap", query = "SELECT r FROM RhParametros r WHERE r.parIessPorcentajeSecap = :parIessPorcentajeSecap"),
    @NamedQuery(name = "RhParametros.findByParSalarioMinimoVital", query = "SELECT r FROM RhParametros r WHERE r.parSalarioMinimoVital = :parSalarioMinimoVital")})
public class RhParametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "par_secuencial")
    private Integer parSecuencial;
    @Basic(optional = false)
    @Column(name = "par_desde")
    @Temporal(TemporalType.DATE)
    private Date parDesde;
    @Column(name = "par_hasta")
    @Temporal(TemporalType.DATE)
    private Date parHasta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "par_iess_porcentaje_aporte_individual")
    private BigDecimal parIessPorcentajeAporteIndividual;
    @Basic(optional = false)
    @Column(name = "par_iess_porcentaje_aporte_extendido")
    private BigDecimal parIessPorcentajeAporteExtendido;
    @Basic(optional = false)
    @Column(name = "par_iess_porcentaje_aporte_patronal")
    private BigDecimal parIessPorcentajeAportePatronal;
    @Basic(optional = false)
    @Column(name = "par_iess_porcentaje_iece")
    private BigDecimal parIessPorcentajeIece;
    @Basic(optional = false)
    @Column(name = "par_iess_porcentaje_secap")
    private BigDecimal parIessPorcentajeSecap;
    @Basic(optional = false)
    @Column(name = "par_salario_minimo_vital")
    private BigDecimal parSalarioMinimoVital;

    public RhParametros() {
    }

    public RhParametros(Integer parSecuencial) {
        this.parSecuencial = parSecuencial;
    }

    public RhParametros(Integer parSecuencial, Date parDesde, BigDecimal parIessPorcentajeAporteIndividual, BigDecimal parIessPorcentajeAporteExtendido, BigDecimal parIessPorcentajeAportePatronal, BigDecimal parIessPorcentajeIece, BigDecimal parIessPorcentajeSecap, BigDecimal parSalarioMinimoVital) {
        this.parSecuencial = parSecuencial;
        this.parDesde = parDesde;
        this.parIessPorcentajeAporteIndividual = parIessPorcentajeAporteIndividual;
        this.parIessPorcentajeAporteExtendido = parIessPorcentajeAporteExtendido;
        this.parIessPorcentajeAportePatronal = parIessPorcentajeAportePatronal;
        this.parIessPorcentajeIece = parIessPorcentajeIece;
        this.parIessPorcentajeSecap = parIessPorcentajeSecap;
        this.parSalarioMinimoVital = parSalarioMinimoVital;
    }

    public Integer getParSecuencial() {
        return parSecuencial;
    }

    public void setParSecuencial(Integer parSecuencial) {
        this.parSecuencial = parSecuencial;
    }

    public Date getParDesde() {
        return parDesde;
    }

    public void setParDesde(Date parDesde) {
        this.parDesde = parDesde;
    }

    public Date getParHasta() {
        return parHasta;
    }

    public void setParHasta(Date parHasta) {
        this.parHasta = parHasta;
    }

    public BigDecimal getParIessPorcentajeAporteIndividual() {
        return parIessPorcentajeAporteIndividual;
    }

    public void setParIessPorcentajeAporteIndividual(BigDecimal parIessPorcentajeAporteIndividual) {
        this.parIessPorcentajeAporteIndividual = parIessPorcentajeAporteIndividual;
    }

    public BigDecimal getParIessPorcentajeAporteExtendido() {
        return parIessPorcentajeAporteExtendido;
    }

    public void setParIessPorcentajeAporteExtendido(BigDecimal parIessPorcentajeAporteExtendido) {
        this.parIessPorcentajeAporteExtendido = parIessPorcentajeAporteExtendido;
    }

    public BigDecimal getParIessPorcentajeAportePatronal() {
        return parIessPorcentajeAportePatronal;
    }

    public void setParIessPorcentajeAportePatronal(BigDecimal parIessPorcentajeAportePatronal) {
        this.parIessPorcentajeAportePatronal = parIessPorcentajeAportePatronal;
    }

    public BigDecimal getParIessPorcentajeIece() {
        return parIessPorcentajeIece;
    }

    public void setParIessPorcentajeIece(BigDecimal parIessPorcentajeIece) {
        this.parIessPorcentajeIece = parIessPorcentajeIece;
    }

    public BigDecimal getParIessPorcentajeSecap() {
        return parIessPorcentajeSecap;
    }

    public void setParIessPorcentajeSecap(BigDecimal parIessPorcentajeSecap) {
        this.parIessPorcentajeSecap = parIessPorcentajeSecap;
    }

    public BigDecimal getParSalarioMinimoVital() {
        return parSalarioMinimoVital;
    }

    public void setParSalarioMinimoVital(BigDecimal parSalarioMinimoVital) {
        this.parSalarioMinimoVital = parSalarioMinimoVital;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parSecuencial != null ? parSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhParametros)) {
            return false;
        }
        RhParametros other = (RhParametros) object;
        if ((this.parSecuencial == null && other.parSecuencial != null) || (this.parSecuencial != null && !this.parSecuencial.equals(other.parSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhParametros[ parSecuencial=" + parSecuencial + " ]";
    }
}
