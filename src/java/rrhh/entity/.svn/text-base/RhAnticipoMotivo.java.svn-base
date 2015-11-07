/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "rh_anticipo_motivo", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhAnticipoMotivo.findAll", query = "SELECT r FROM RhAnticipoMotivo r"),
    @NamedQuery(name = "RhAnticipoMotivo.findByMotEmpresa", query = "SELECT r FROM RhAnticipoMotivo r WHERE r.rhAnticipoMotivoPK.motEmpresa = :motEmpresa"),
    @NamedQuery(name = "RhAnticipoMotivo.findByMotDetalle", query = "SELECT r FROM RhAnticipoMotivo r WHERE r.rhAnticipoMotivoPK.motDetalle = :motDetalle"),
    @NamedQuery(name = "RhAnticipoMotivo.findByMotInactivo", query = "SELECT r FROM RhAnticipoMotivo r WHERE r.motInactivo = :motInactivo"),
    @NamedQuery(name = "RhAnticipoMotivo.findBySecEmpresa", query = "SELECT r FROM RhAnticipoMotivo r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhAnticipoMotivo.findBySecCodigo", query = "SELECT r FROM RhAnticipoMotivo r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhAnticipoMotivo.findByCtaEmpresa", query = "SELECT r FROM RhAnticipoMotivo r WHERE r.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "RhAnticipoMotivo.findByCtaCodigo", query = "SELECT r FROM RhAnticipoMotivo r WHERE r.ctaCodigo = :ctaCodigo"),
    @NamedQuery(name = "RhAnticipoMotivo.findByUsrEmpresa", query = "SELECT r FROM RhAnticipoMotivo r WHERE r.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "RhAnticipoMotivo.findByUsrCodigo", query = "SELECT r FROM RhAnticipoMotivo r WHERE r.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "RhAnticipoMotivo.findByUsrFechaInserta", query = "SELECT r FROM RhAnticipoMotivo r WHERE r.usrFechaInserta = :usrFechaInserta")})
public class RhAnticipoMotivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RhAnticipoMotivoPK rhAnticipoMotivoPK;
    @Basic(optional = false)
    @Column(name = "mot_inactivo")
    private boolean motInactivo;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
    @Basic(optional = false)
    @Column(name = "cta_empresa")
    private String ctaEmpresa;
    @Basic(optional = false)
    @Column(name = "cta_codigo")
    private String ctaCodigo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rhAnticipoMotivo")
    private List<RhEmpleadoDescuentosFijos> rhEmpleadoDescuentosFijosList;

    public RhAnticipoMotivo() {
    }

    public RhAnticipoMotivo(RhAnticipoMotivoPK rhAnticipoMotivoPK) {
        this.rhAnticipoMotivoPK = rhAnticipoMotivoPK;
    }

    public RhAnticipoMotivo(RhAnticipoMotivoPK rhAnticipoMotivoPK, boolean motInactivo, String secEmpresa, String secCodigo, String ctaEmpresa, String ctaCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.rhAnticipoMotivoPK = rhAnticipoMotivoPK;
        this.motInactivo = motInactivo;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.ctaEmpresa = ctaEmpresa;
        this.ctaCodigo = ctaCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public RhAnticipoMotivo(String motEmpresa, String motDetalle) {
        this.rhAnticipoMotivoPK = new RhAnticipoMotivoPK(motEmpresa, motDetalle);
    }

    public RhAnticipoMotivoPK getRhAnticipoMotivoPK() {
        return rhAnticipoMotivoPK;
    }

    public void setRhAnticipoMotivoPK(RhAnticipoMotivoPK rhAnticipoMotivoPK) {
        this.rhAnticipoMotivoPK = rhAnticipoMotivoPK;
    }

    public boolean getMotInactivo() {
        return motInactivo;
    }

    public void setMotInactivo(boolean motInactivo) {
        this.motInactivo = motInactivo;
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

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getCtaCodigo() {
        return ctaCodigo;
    }

    public void setCtaCodigo(String ctaCodigo) {
        this.ctaCodigo = ctaCodigo;
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

    public List<RhEmpleadoDescuentosFijos> getRhEmpleadoDescuentosFijosList() {
        return rhEmpleadoDescuentosFijosList;
    }

    public void setRhEmpleadoDescuentosFijosList(List<RhEmpleadoDescuentosFijos> rhEmpleadoDescuentosFijosList) {
        this.rhEmpleadoDescuentosFijosList = rhEmpleadoDescuentosFijosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rhAnticipoMotivoPK != null ? rhAnticipoMotivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhAnticipoMotivo)) {
            return false;
        }
        RhAnticipoMotivo other = (RhAnticipoMotivo) object;
        if ((this.rhAnticipoMotivoPK == null && other.rhAnticipoMotivoPK != null) || (this.rhAnticipoMotivoPK != null && !this.rhAnticipoMotivoPK.equals(other.rhAnticipoMotivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhAnticipoMotivo[ rhAnticipoMotivoPK=" + rhAnticipoMotivoPK + " ]";
    }
}
