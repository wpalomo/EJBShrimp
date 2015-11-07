/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "sis_periodo", schema = "sistemaweb")
@NamedQueries({
    @NamedQuery(name = "SisPeriodo.findAll", query = "SELECT s FROM SisPeriodo s"),
    @NamedQuery(name = "SisPeriodo.findByPerEmpresa", query = "SELECT s FROM SisPeriodo s WHERE s.sisPeriodoPK.perEmpresa = :perEmpresa"),
    @NamedQuery(name = "SisPeriodo.findByPerCodigo", query = "SELECT s FROM SisPeriodo s WHERE s.sisPeriodoPK.perCodigo = :perCodigo"),
    @NamedQuery(name = "SisPeriodo.findByPerDetalle", query = "SELECT s FROM SisPeriodo s WHERE s.perDetalle = :perDetalle"),
    @NamedQuery(name = "SisPeriodo.findByPerDesde", query = "SELECT s FROM SisPeriodo s WHERE s.perDesde = :perDesde"),
    @NamedQuery(name = "SisPeriodo.findByPerHasta", query = "SELECT s FROM SisPeriodo s WHERE s.perHasta = :perHasta"),
    @NamedQuery(name = "SisPeriodo.findByPerCerrado", query = "SELECT s FROM SisPeriodo s WHERE s.perCerrado = :perCerrado"),
    @NamedQuery(name = "SisPeriodo.findByUsrCodigo", query = "SELECT s FROM SisPeriodo s WHERE s.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "SisPeriodo.findByUsrFechaInsertaPeriodo", query = "SELECT s FROM SisPeriodo s WHERE s.usrFechaInsertaPeriodo = :usrFechaInsertaPeriodo")})
public class SisPeriodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SisPeriodoPK sisPeriodoPK;
    @Basic(optional = false)
    @Column(name = "per_detalle")
    private String perDetalle;
    @Basic(optional = false)
    @Column(name = "per_desde")
    @Temporal(TemporalType.DATE)
    private Date perDesde;
    @Basic(optional = false)
    @Column(name = "per_hasta")
    @Temporal(TemporalType.DATE)
    private Date perHasta;
    @Basic(optional = false)
    @Column(name = "per_cerrado")
    private boolean perCerrado;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta_periodo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInsertaPeriodo;
    @JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
    @ManyToOne(optional = false)
    private SisEmpresa empCodigo;

    public SisPeriodo() {
    }

    public SisPeriodo(SisPeriodoPK sisPeriodoPK) {
        this.sisPeriodoPK = sisPeriodoPK;
    }

    public SisPeriodo(SisPeriodoPK sisPeriodoPK, String perDetalle, Date perDesde, Date perHasta, boolean perCerrado, String usrCodigo, Date usrFechaInsertaPeriodo) {
        this.sisPeriodoPK = sisPeriodoPK;
        this.perDetalle = perDetalle;
        this.perDesde = perDesde;
        this.perHasta = perHasta;
        this.perCerrado = perCerrado;
        this.usrCodigo = usrCodigo;
        this.usrFechaInsertaPeriodo = usrFechaInsertaPeriodo;
    }

    public SisPeriodo(String perEmpresa, String perCodigo) {
        this.sisPeriodoPK = new SisPeriodoPK(perEmpresa, perCodigo);
    }

    public SisPeriodoPK getSisPeriodoPK() {
        return sisPeriodoPK;
    }

    public void setSisPeriodoPK(SisPeriodoPK sisPeriodoPK) {
        this.sisPeriodoPK = sisPeriodoPK;
    }

    public String getPerDetalle() {
        return perDetalle;
    }

    public void setPerDetalle(String perDetalle) {
        this.perDetalle = perDetalle;
    }

    public Date getPerDesde() {
        return perDesde;
    }

    public void setPerDesde(Date perDesde) {
        this.perDesde = perDesde;
    }

    public Date getPerHasta() {
        return perHasta;
    }

    public void setPerHasta(Date perHasta) {
        this.perHasta = perHasta;
    }

    public boolean getPerCerrado() {
        return perCerrado;
    }

    public void setPerCerrado(boolean perCerrado) {
        this.perCerrado = perCerrado;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Date getUsrFechaInsertaPeriodo() {
        return usrFechaInsertaPeriodo;
    }

    public void setUsrFechaInsertaPeriodo(Date usrFechaInsertaPeriodo) {
        this.usrFechaInsertaPeriodo = usrFechaInsertaPeriodo;
    }

    public SisEmpresa getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(SisEmpresa empCodigo) {
        this.empCodigo = empCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisPeriodoPK != null ? sisPeriodoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisPeriodo)) {
            return false;
        }
        SisPeriodo other = (SisPeriodo) object;
        if ((this.sisPeriodoPK == null && other.sisPeriodoPK != null) || (this.sisPeriodoPK != null && !this.sisPeriodoPK.equals(other.sisPeriodoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisPeriodo[ sisPeriodoPK=" + sisPeriodoPK + " ]";
    }
    
}
