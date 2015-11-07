/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "con_contable", schema = "contabilidad")
@NamedQueries({
    @NamedQuery(name = "ConContable.findAll", query = "SELECT c FROM ConContable c"),
    @NamedQuery(name = "ConContable.findByConEmpresa", query = "SELECT c FROM ConContable c WHERE c.conContablePK.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "ConContable.findByConPeriodo", query = "SELECT c FROM ConContable c WHERE c.conContablePK.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "ConContable.findByConTipo", query = "SELECT c FROM ConContable c WHERE c.conContablePK.conTipo = :conTipo"),
    @NamedQuery(name = "ConContable.findByConNumero", query = "SELECT c FROM ConContable c WHERE c.conContablePK.conNumero = :conNumero"),
    @NamedQuery(name = "ConContable.findByConFecha", query = "SELECT c FROM ConContable c WHERE c.conFecha = :conFecha"),
    @NamedQuery(name = "ConContable.findByConPendiente", query = "SELECT c FROM ConContable c WHERE c.conPendiente = :conPendiente"),
    @NamedQuery(name = "ConContable.findByConBloqueado", query = "SELECT c FROM ConContable c WHERE c.conBloqueado = :conBloqueado"),
    @NamedQuery(name = "ConContable.findByConAnulado", query = "SELECT c FROM ConContable c WHERE c.conAnulado = :conAnulado"),
    @NamedQuery(name = "ConContable.findByConGenerado", query = "SELECT c FROM ConContable c WHERE c.conGenerado = :conGenerado"),
    @NamedQuery(name = "ConContable.findByConConcepto", query = "SELECT c FROM ConContable c WHERE c.conConcepto = :conConcepto"),
    @NamedQuery(name = "ConContable.findByConDetalle", query = "SELECT c FROM ConContable c WHERE c.conDetalle = :conDetalle"),
    @NamedQuery(name = "ConContable.findByConObservaciones", query = "SELECT c FROM ConContable c WHERE c.conObservaciones = :conObservaciones"),
    @NamedQuery(name = "ConContable.findByUsrEmpresa", query = "SELECT c FROM ConContable c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "ConContable.findByUsrCodigo", query = "SELECT c FROM ConContable c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "ConContable.findByUsrFechaInserta", query = "SELECT c FROM ConContable c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class ConContable implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConContablePK conContablePK;
    @Basic(optional = false)
    @Column(name = "con_fecha")
    @Temporal(TemporalType.DATE)
    private Date conFecha;
    @Column(name = "con_pendiente")
    private Boolean conPendiente;
    @Column(name = "con_bloqueado")
    private Boolean conBloqueado;
    @Column(name = "con_anulado")
    private Boolean conAnulado;
    @Column(name = "con_generado")
    private Boolean conGenerado;
    @Column(name = "con_concepto")
    private String conConcepto;
    @Column(name = "con_detalle")
    private String conDetalle;
    @Column(name = "con_observaciones")
    private String conObservaciones;
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conContable")
    private List<ConDetalle> conDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conContable")
    private List<ConContableMotivoAnulacion> conContableMotivoAnulacionList;

    public ConContable() {
    }

    public ConContable(ConContablePK conContablePK) {
        this.conContablePK = conContablePK;
    }

    public ConContable(ConContablePK conContablePK, Date conFecha) {
        this.conContablePK = conContablePK;
        this.conFecha = conFecha;
    }

    public ConContable(String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.conContablePK = new ConContablePK(conEmpresa, conPeriodo, conTipo, conNumero);
    }

    public ConContablePK getConContablePK() {
        return conContablePK;
    }

    public void setConContablePK(ConContablePK conContablePK) {
        this.conContablePK = conContablePK;
    }

    public Date getConFecha() {
        return conFecha;
    }

    public void setConFecha(Date conFecha) {
        this.conFecha = conFecha;
    }

    public Boolean getConPendiente() {
        return conPendiente;
    }

    public void setConPendiente(Boolean conPendiente) {
        this.conPendiente = conPendiente;
    }

    public Boolean getConBloqueado() {
        return conBloqueado;
    }

    public void setConBloqueado(Boolean conBloqueado) {
        this.conBloqueado = conBloqueado;
    }

    public Boolean getConAnulado() {
        return conAnulado;
    }

    public void setConAnulado(Boolean conAnulado) {
        this.conAnulado = conAnulado;
    }

    public Boolean getConGenerado() {
        return conGenerado;
    }

    public void setConGenerado(Boolean conGenerado) {
        this.conGenerado = conGenerado;
    }

    public String getConConcepto() {
        return conConcepto;
    }

    public void setConConcepto(String conConcepto) {
        this.conConcepto = conConcepto;
    }

    public String getConDetalle() {
        return conDetalle;
    }

    public void setConDetalle(String conDetalle) {
        this.conDetalle = conDetalle;
    }

    public String getConObservaciones() {
        return conObservaciones;
    }

    public void setConObservaciones(String conObservaciones) {
        this.conObservaciones = conObservaciones;
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

    public List<ConDetalle> getConDetalleList() {
        return conDetalleList;
    }

    public void setConDetalleList(List<ConDetalle> conDetalleList) {
        this.conDetalleList = conDetalleList;
    }

    public List<ConContableMotivoAnulacion> getConContableMotivoAnulacionList() {
        return conContableMotivoAnulacionList;
    }

    public void setConContableMotivoAnulacionList(List<ConContableMotivoAnulacion> conContableMotivoAnulacionList) {
        this.conContableMotivoAnulacionList = conContableMotivoAnulacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conContablePK != null ? conContablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConContable)) {
            return false;
        }
        ConContable other = (ConContable) object;
        if ((this.conContablePK == null && other.conContablePK != null) || (this.conContablePK != null && !this.conContablePK.equals(other.conContablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConContable[ conContablePK=" + conContablePK + " ]";
    }
    
}
