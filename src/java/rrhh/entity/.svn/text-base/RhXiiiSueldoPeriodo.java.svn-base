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
@Table(name = "rh_xiii_sueldo_periodo", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhXiiiSueldoPeriodo.findAll", query = "SELECT r FROM RhXiiiSueldoPeriodo r"),
    @NamedQuery(name = "RhXiiiSueldoPeriodo.findByXiiiSecuencial", query = "SELECT r FROM RhXiiiSueldoPeriodo r WHERE r.xiiiSecuencial = :xiiiSecuencial"),
    @NamedQuery(name = "RhXiiiSueldoPeriodo.findByXiiiDescripcion", query = "SELECT r FROM RhXiiiSueldoPeriodo r WHERE r.xiiiDescripcion = :xiiiDescripcion"),
    @NamedQuery(name = "RhXiiiSueldoPeriodo.findByXiiiDesde", query = "SELECT r FROM RhXiiiSueldoPeriodo r WHERE r.xiiiDesde = :xiiiDesde"),
    @NamedQuery(name = "RhXiiiSueldoPeriodo.findByXiiiHasta", query = "SELECT r FROM RhXiiiSueldoPeriodo r WHERE r.xiiiHasta = :xiiiHasta"),
    @NamedQuery(name = "RhXiiiSueldoPeriodo.findByXiiiFechaMaximaPago", query = "SELECT r FROM RhXiiiSueldoPeriodo r WHERE r.xiiiFechaMaximaPago = :xiiiFechaMaximaPago")})
public class RhXiiiSueldoPeriodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "xiii_secuencial")
    private Integer xiiiSecuencial;
    @Column(name = "xiii_descripcion")
    private String xiiiDescripcion;
    @Column(name = "xiii_desde")
    @Temporal(TemporalType.DATE)
    private Date xiiiDesde;
    @Column(name = "xiii_hasta")
    @Temporal(TemporalType.DATE)
    private Date xiiiHasta;
    @Column(name = "xiii_fecha_maxima_pago")
    @Temporal(TemporalType.DATE)
    private Date xiiiFechaMaximaPago;

    public RhXiiiSueldoPeriodo() {
    }

    public RhXiiiSueldoPeriodo(Integer xiiiSecuencial) {
        this.xiiiSecuencial = xiiiSecuencial;
    }

    public Integer getXiiiSecuencial() {
        return xiiiSecuencial;
    }

    public void setXiiiSecuencial(Integer xiiiSecuencial) {
        this.xiiiSecuencial = xiiiSecuencial;
    }

    public String getXiiiDescripcion() {
        return xiiiDescripcion;
    }

    public void setXiiiDescripcion(String xiiiDescripcion) {
        this.xiiiDescripcion = xiiiDescripcion;
    }

    public Date getXiiiDesde() {
        return xiiiDesde;
    }

    public void setXiiiDesde(Date xiiiDesde) {
        this.xiiiDesde = xiiiDesde;
    }

    public Date getXiiiHasta() {
        return xiiiHasta;
    }

    public void setXiiiHasta(Date xiiiHasta) {
        this.xiiiHasta = xiiiHasta;
    }

    public Date getXiiiFechaMaximaPago() {
        return xiiiFechaMaximaPago;
    }

    public void setXiiiFechaMaximaPago(Date xiiiFechaMaximaPago) {
        this.xiiiFechaMaximaPago = xiiiFechaMaximaPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xiiiSecuencial != null ? xiiiSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhXiiiSueldoPeriodo)) {
            return false;
        }
        RhXiiiSueldoPeriodo other = (RhXiiiSueldoPeriodo) object;
        if ((this.xiiiSecuencial == null && other.xiiiSecuencial != null) || (this.xiiiSecuencial != null && !this.xiiiSecuencial.equals(other.xiiiSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhXiiiSueldoPeriodo[ xiiiSecuencial=" + xiiiSecuencial + " ]";
    }
}
