/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_porcentajeiva",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxPorcentajeiva.findAll", query = "SELECT a FROM AnxPorcentajeiva a"),
    @NamedQuery(name = "AnxPorcentajeiva.findByPiCodigo", query = "SELECT a FROM AnxPorcentajeiva a WHERE a.piCodigo = :piCodigo"),
    @NamedQuery(name = "AnxPorcentajeiva.findByPiPorcentaje", query = "SELECT a FROM AnxPorcentajeiva a WHERE a.piPorcentaje = :piPorcentaje"),
    @NamedQuery(name = "AnxPorcentajeiva.findByPiMontoMaximoConsumidorFinal", query = "SELECT a FROM AnxPorcentajeiva a WHERE a.piMontoMaximoConsumidorFinal = :piMontoMaximoConsumidorFinal"),
    @NamedQuery(name = "AnxPorcentajeiva.findByPiFechaInicio", query = "SELECT a FROM AnxPorcentajeiva a WHERE a.piFechaInicio = :piFechaInicio"),
    @NamedQuery(name = "AnxPorcentajeiva.findByPiFechaFin", query = "SELECT a FROM AnxPorcentajeiva a WHERE a.piFechaFin = :piFechaFin")})
public class AnxPorcentajeiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pi_codigo")
    private String piCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "pi_porcentaje")
    private BigDecimal piPorcentaje;
    @Basic(optional = false)
    @Column(name = "pi_monto_maximo_consumidor_final")
    private BigDecimal piMontoMaximoConsumidorFinal;
    @Basic(optional = false)
    @Column(name = "pi_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date piFechaInicio;
    @Column(name = "pi_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date piFechaFin;

    public AnxPorcentajeiva() {
    }

    public AnxPorcentajeiva(String piCodigo) {
        this.piCodigo = piCodigo;
    }

    public AnxPorcentajeiva(String piCodigo, BigDecimal piPorcentaje, BigDecimal piMontoMaximoConsumidorFinal, Date piFechaInicio) {
        this.piCodigo = piCodigo;
        this.piPorcentaje = piPorcentaje;
        this.piMontoMaximoConsumidorFinal = piMontoMaximoConsumidorFinal;
        this.piFechaInicio = piFechaInicio;
    }

    public String getPiCodigo() {
        return piCodigo;
    }

    public void setPiCodigo(String piCodigo) {
        this.piCodigo = piCodigo;
    }

    public BigDecimal getPiPorcentaje() {
        return piPorcentaje;
    }

    public void setPiPorcentaje(BigDecimal piPorcentaje) {
        this.piPorcentaje = piPorcentaje;
    }

    public BigDecimal getPiMontoMaximoConsumidorFinal() {
        return piMontoMaximoConsumidorFinal;
    }

    public void setPiMontoMaximoConsumidorFinal(BigDecimal piMontoMaximoConsumidorFinal) {
        this.piMontoMaximoConsumidorFinal = piMontoMaximoConsumidorFinal;
    }

    public Date getPiFechaInicio() {
        return piFechaInicio;
    }

    public void setPiFechaInicio(Date piFechaInicio) {
        this.piFechaInicio = piFechaInicio;
    }

    public Date getPiFechaFin() {
        return piFechaFin;
    }

    public void setPiFechaFin(Date piFechaFin) {
        this.piFechaFin = piFechaFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (piCodigo != null ? piCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxPorcentajeiva)) {
            return false;
        }
        AnxPorcentajeiva other = (AnxPorcentajeiva) object;
        if ((this.piCodigo == null && other.piCodigo != null) || (this.piCodigo != null && !this.piCodigo.equals(other.piCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxPorcentajeiva[ piCodigo=" + piCodigo + " ]";
    }
    
}
