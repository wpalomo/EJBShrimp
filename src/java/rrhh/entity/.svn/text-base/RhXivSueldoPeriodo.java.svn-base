/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "rh_xiv_sueldo_periodo", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhXivSueldoPeriodo.findAll", query = "SELECT r FROM RhXivSueldoPeriodo r"),
    @NamedQuery(name = "RhXivSueldoPeriodo.findByXivSecuencial", query = "SELECT r FROM RhXivSueldoPeriodo r WHERE r.xivSecuencial = :xivSecuencial"),
    @NamedQuery(name = "RhXivSueldoPeriodo.findByXivDescripcion", query = "SELECT r FROM RhXivSueldoPeriodo r WHERE r.xivDescripcion = :xivDescripcion"),
    @NamedQuery(name = "RhXivSueldoPeriodo.findByXivDesde", query = "SELECT r FROM RhXivSueldoPeriodo r WHERE r.xivDesde = :xivDesde"),
    @NamedQuery(name = "RhXivSueldoPeriodo.findByXivHasta", query = "SELECT r FROM RhXivSueldoPeriodo r WHERE r.xivHasta = :xivHasta"),
    @NamedQuery(name = "RhXivSueldoPeriodo.findByXivFechaMaximaPago", query = "SELECT r FROM RhXivSueldoPeriodo r WHERE r.xivFechaMaximaPago = :xivFechaMaximaPago")})
public class RhXivSueldoPeriodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "xiv_secuencial")
    private Integer xivSecuencial;
    @Column(name = "xiv_descripcion")
    private String xivDescripcion;
    @Column(name = "xiv_desde")
    @Temporal(TemporalType.DATE)
    private Date xivDesde;
    @Column(name = "xiv_hasta")
    @Temporal(TemporalType.DATE)
    private Date xivHasta;
    @Column(name = "xiv_fecha_maxima_pago")
    @Temporal(TemporalType.DATE)
    private Date xivFechaMaximaPago;

    public RhXivSueldoPeriodo() {
    }

    public RhXivSueldoPeriodo(Integer xivSecuencial) {
        this.xivSecuencial = xivSecuencial;
    }

    public Integer getXivSecuencial() {
        return xivSecuencial;
    }

    public void setXivSecuencial(Integer xivSecuencial) {
        this.xivSecuencial = xivSecuencial;
    }

    public String getXivDescripcion() {
        return xivDescripcion;
    }

    public void setXivDescripcion(String xivDescripcion) {
        this.xivDescripcion = xivDescripcion;
    }

    public Date getXivDesde() {
        return xivDesde;
    }

    public void setXivDesde(Date xivDesde) {
        this.xivDesde = xivDesde;
    }

    public Date getXivHasta() {
        return xivHasta;
    }

    public void setXivHasta(Date xivHasta) {
        this.xivHasta = xivHasta;
    }

    public Date getXivFechaMaximaPago() {
        return xivFechaMaximaPago;
    }

    public void setXivFechaMaximaPago(Date xivFechaMaximaPago) {
        this.xivFechaMaximaPago = xivFechaMaximaPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xivSecuencial != null ? xivSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhXivSueldoPeriodo)) {
            return false;
        }
        RhXivSueldoPeriodo other = (RhXivSueldoPeriodo) object;
        if ((this.xivSecuencial == null && other.xivSecuencial != null) || (this.xivSecuencial != null && !this.xivSecuencial.equals(other.xivSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhXivSueldoPeriodo[ xivSecuencial=" + xivSecuencial + " ]";
    }
}
