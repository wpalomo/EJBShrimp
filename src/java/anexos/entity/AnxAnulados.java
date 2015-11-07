/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_anulados",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxAnulados.findAll", query = "SELECT a FROM AnxAnulados a"),
    @NamedQuery(name = "AnxAnulados.findByAnuSecuencial", query = "SELECT a FROM AnxAnulados a WHERE a.anuSecuencial = :anuSecuencial"),
    @NamedQuery(name = "AnxAnulados.findByAnuComprobanteEstablecimiento", query = "SELECT a FROM AnxAnulados a WHERE a.anuComprobanteEstablecimiento = :anuComprobanteEstablecimiento"),
    @NamedQuery(name = "AnxAnulados.findByAnuComprobantePuntoEmision", query = "SELECT a FROM AnxAnulados a WHERE a.anuComprobantePuntoEmision = :anuComprobantePuntoEmision"),
    @NamedQuery(name = "AnxAnulados.findByAnuSecuencialInicio", query = "SELECT a FROM AnxAnulados a WHERE a.anuSecuencialInicio = :anuSecuencialInicio"),
    @NamedQuery(name = "AnxAnulados.findByAnuSecuencialFin", query = "SELECT a FROM AnxAnulados a WHERE a.anuSecuencialFin = :anuSecuencialFin"),
    @NamedQuery(name = "AnxAnulados.findByAnuAutorizacion", query = "SELECT a FROM AnxAnulados a WHERE a.anuAutorizacion = :anuAutorizacion"),
    @NamedQuery(name = "AnxAnulados.findByAnuFecha", query = "SELECT a FROM AnxAnulados a WHERE a.anuFecha = :anuFecha"),
    @NamedQuery(name = "AnxAnulados.findByUsrEmpresa", query = "SELECT a FROM AnxAnulados a WHERE a.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "AnxAnulados.findByUsrCodigo", query = "SELECT a FROM AnxAnulados a WHERE a.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "AnxAnulados.findByUsrFechaInserta", query = "SELECT a FROM AnxAnulados a WHERE a.usrFechaInserta = :usrFechaInserta")})
public class AnxAnulados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "anu_secuencial")
    private Integer anuSecuencial;
    @Column(name = "anu_comprobante_establecimiento")
    private String anuComprobanteEstablecimiento;
    @Column(name = "anu_comprobante_punto_emision")
    private String anuComprobantePuntoEmision;
    @Column(name = "anu_secuencial_inicio")
    private String anuSecuencialInicio;
    @Column(name = "anu_secuencial_fin")
    private String anuSecuencialFin;
    @Column(name = "anu_autorizacion")
    private String anuAutorizacion;
    @Column(name = "anu_fecha")
    @Temporal(TemporalType.DATE)
    private Date anuFecha;
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @JoinColumn(name = "tc_codigo", referencedColumnName = "tc_codigo")
    @ManyToOne
    private AnxTipocomprobante tcCodigo;

    public AnxAnulados() {
    }

    public AnxAnulados(Integer anuSecuencial) {
        this.anuSecuencial = anuSecuencial;
    }

    public Integer getAnuSecuencial() {
        return anuSecuencial;
    }

    public void setAnuSecuencial(Integer anuSecuencial) {
        this.anuSecuencial = anuSecuencial;
    }

    public String getAnuComprobanteEstablecimiento() {
        return anuComprobanteEstablecimiento;
    }

    public void setAnuComprobanteEstablecimiento(String anuComprobanteEstablecimiento) {
        this.anuComprobanteEstablecimiento = anuComprobanteEstablecimiento;
    }

    public String getAnuComprobantePuntoEmision() {
        return anuComprobantePuntoEmision;
    }

    public void setAnuComprobantePuntoEmision(String anuComprobantePuntoEmision) {
        this.anuComprobantePuntoEmision = anuComprobantePuntoEmision;
    }

    public String getAnuSecuencialInicio() {
        return anuSecuencialInicio;
    }

    public void setAnuSecuencialInicio(String anuSecuencialInicio) {
        this.anuSecuencialInicio = anuSecuencialInicio;
    }

    public String getAnuSecuencialFin() {
        return anuSecuencialFin;
    }

    public void setAnuSecuencialFin(String anuSecuencialFin) {
        this.anuSecuencialFin = anuSecuencialFin;
    }

    public String getAnuAutorizacion() {
        return anuAutorizacion;
    }

    public void setAnuAutorizacion(String anuAutorizacion) {
        this.anuAutorizacion = anuAutorizacion;
    }

    public Date getAnuFecha() {
        return anuFecha;
    }

    public void setAnuFecha(Date anuFecha) {
        this.anuFecha = anuFecha;
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

    public AnxTipocomprobante getTcCodigo() {
        return tcCodigo;
    }

    public void setTcCodigo(AnxTipocomprobante tcCodigo) {
        this.tcCodigo = tcCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anuSecuencial != null ? anuSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxAnulados)) {
            return false;
        }
        AnxAnulados other = (AnxAnulados) object;
        if ((this.anuSecuencial == null && other.anuSecuencial != null) || (this.anuSecuencial != null && !this.anuSecuencial.equals(other.anuSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxAnulados[ anuSecuencial=" + anuSecuencial + " ]";
    }
    
}
