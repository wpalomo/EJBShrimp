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
@Table(name = "sis_pcs", schema = "sistemaweb")
@NamedQueries({
    @NamedQuery(name = "SisPcs.findAll", query = "SELECT s FROM SisPcs s"),
    @NamedQuery(name = "SisPcs.findByInfMac", query = "SELECT s FROM SisPcs s WHERE s.infMac = :infMac"),
    @NamedQuery(name = "SisPcs.findByInfIp", query = "SELECT s FROM SisPcs s WHERE s.infIp = :infIp"),
    @NamedQuery(name = "SisPcs.findByInfNombre", query = "SELECT s FROM SisPcs s WHERE s.infNombre = :infNombre"),
    @NamedQuery(name = "SisPcs.findByInfDescripcion", query = "SELECT s FROM SisPcs s WHERE s.infDescripcion = :infDescripcion"),
    @NamedQuery(name = "SisPcs.findByInfReporteRutaDefault", query = "SELECT s FROM SisPcs s WHERE s.infReporteRutaDefault = :infReporteRutaDefault"),
    @NamedQuery(name = "SisPcs.findByInfReporteFactura", query = "SELECT s FROM SisPcs s WHERE s.infReporteFactura = :infReporteFactura"),
    @NamedQuery(name = "SisPcs.findByInfReporteNotaCredito", query = "SELECT s FROM SisPcs s WHERE s.infReporteNotaCredito = :infReporteNotaCredito"),
    @NamedQuery(name = "SisPcs.findByInfReporteLiquidacion", query = "SELECT s FROM SisPcs s WHERE s.infReporteLiquidacion = :infReporteLiquidacion"),
    @NamedQuery(name = "SisPcs.findByInfReporteRetencion", query = "SELECT s FROM SisPcs s WHERE s.infReporteRetencion = :infReporteRetencion"),
    @NamedQuery(name = "SisPcs.findByInfReporteGuiaRemision", query = "SELECT s FROM SisPcs s WHERE s.infReporteGuiaRemision = :infReporteGuiaRemision"),
    @NamedQuery(name = "SisPcs.findByInfKeystoreRuta", query = "SELECT s FROM SisPcs s WHERE s.infKeystoreRuta = :infKeystoreRuta"),
    @NamedQuery(name = "SisPcs.findByInfKeystorePassword", query = "SELECT s FROM SisPcs s WHERE s.infKeystorePassword = :infKeystorePassword"),
    @NamedQuery(name = "SisPcs.findByInfEstado", query = "SELECT s FROM SisPcs s WHERE s.infEstado = :infEstado"),
    @NamedQuery(name = "SisPcs.findByUsrCodigo", query = "SELECT s FROM SisPcs s WHERE s.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "SisPcs.findByUsrFechaInsertaPc", query = "SELECT s FROM SisPcs s WHERE s.usrFechaInsertaPc = :usrFechaInsertaPc")})
public class SisPcs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "inf_mac")
    private String infMac;
    @Basic(optional = false)
    @Column(name = "inf_ip")
    private String infIp;
    @Basic(optional = false)
    @Column(name = "inf_nombre")
    private String infNombre;
    @Column(name = "inf_descripcion")
    private String infDescripcion;
    @Basic(optional = false)
    @Column(name = "inf_reporte_ruta_default")
    private String infReporteRutaDefault;
    @Basic(optional = false)
    @Column(name = "inf_reporte_factura")
    private String infReporteFactura;
    @Basic(optional = false)
    @Column(name = "inf_reporte_nota_credito")
    private String infReporteNotaCredito;
    @Basic(optional = false)
    @Column(name = "inf_reporte_liquidacion")
    private String infReporteLiquidacion;
    @Basic(optional = false)
    @Column(name = "inf_reporte_retencion")
    private String infReporteRetencion;
    @Basic(optional = false)
    @Column(name = "inf_reporte_guia_remision")
    private String infReporteGuiaRemision;
    @Basic(optional = false)
    @Column(name = "inf_keystore_ruta")
    private String infKeystoreRuta;
    @Basic(optional = false)
    @Column(name = "inf_keystore_password")
    private String infKeystorePassword;
    @Basic(optional = false)
    @Column(name = "inf_estado")
    private boolean infEstado;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta_pc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInsertaPc;

    public SisPcs() {
    }

    public SisPcs(String infMac) {
        this.infMac = infMac;
    }

    public SisPcs(String infMac, String infIp, String infNombre, String infReporteRutaDefault, String infReporteFactura, String infReporteNotaCredito, String infReporteLiquidacion, String infReporteRetencion, String infReporteGuiaRemision, String infKeystoreRuta, String infKeystorePassword, boolean infEstado, String usrCodigo, Date usrFechaInsertaPc) {
        this.infMac = infMac;
        this.infIp = infIp;
        this.infNombre = infNombre;
        this.infReporteRutaDefault = infReporteRutaDefault;
        this.infReporteFactura = infReporteFactura;
        this.infReporteNotaCredito = infReporteNotaCredito;
        this.infReporteLiquidacion = infReporteLiquidacion;
        this.infReporteRetencion = infReporteRetencion;
        this.infReporteGuiaRemision = infReporteGuiaRemision;
        this.infKeystoreRuta = infKeystoreRuta;
        this.infKeystorePassword = infKeystorePassword;
        this.infEstado = infEstado;
        this.usrCodigo = usrCodigo;
        this.usrFechaInsertaPc = usrFechaInsertaPc;
    }

    public String getInfMac() {
        return infMac;
    }

    public void setInfMac(String infMac) {
        this.infMac = infMac;
    }

    public String getInfIp() {
        return infIp;
    }

    public void setInfIp(String infIp) {
        this.infIp = infIp;
    }

    public String getInfNombre() {
        return infNombre;
    }

    public void setInfNombre(String infNombre) {
        this.infNombre = infNombre;
    }

    public String getInfDescripcion() {
        return infDescripcion;
    }

    public void setInfDescripcion(String infDescripcion) {
        this.infDescripcion = infDescripcion;
    }

    public String getInfReporteRutaDefault() {
        return infReporteRutaDefault;
    }

    public void setInfReporteRutaDefault(String infReporteRutaDefault) {
        this.infReporteRutaDefault = infReporteRutaDefault;
    }

    public String getInfReporteFactura() {
        return infReporteFactura;
    }

    public void setInfReporteFactura(String infReporteFactura) {
        this.infReporteFactura = infReporteFactura;
    }

    public String getInfReporteNotaCredito() {
        return infReporteNotaCredito;
    }

    public void setInfReporteNotaCredito(String infReporteNotaCredito) {
        this.infReporteNotaCredito = infReporteNotaCredito;
    }

    public String getInfReporteLiquidacion() {
        return infReporteLiquidacion;
    }

    public void setInfReporteLiquidacion(String infReporteLiquidacion) {
        this.infReporteLiquidacion = infReporteLiquidacion;
    }

    public String getInfReporteRetencion() {
        return infReporteRetencion;
    }

    public void setInfReporteRetencion(String infReporteRetencion) {
        this.infReporteRetencion = infReporteRetencion;
    }

    public String getInfReporteGuiaRemision() {
        return infReporteGuiaRemision;
    }

    public void setInfReporteGuiaRemision(String infReporteGuiaRemision) {
        this.infReporteGuiaRemision = infReporteGuiaRemision;
    }

    public String getInfKeystoreRuta() {
        return infKeystoreRuta;
    }

    public void setInfKeystoreRuta(String infKeystoreRuta) {
        this.infKeystoreRuta = infKeystoreRuta;
    }

    public String getInfKeystorePassword() {
        return infKeystorePassword;
    }

    public void setInfKeystorePassword(String infKeystorePassword) {
        this.infKeystorePassword = infKeystorePassword;
    }

    public boolean getInfEstado() {
        return infEstado;
    }

    public void setInfEstado(boolean infEstado) {
        this.infEstado = infEstado;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Date getUsrFechaInsertaPc() {
        return usrFechaInsertaPc;
    }

    public void setUsrFechaInsertaPc(Date usrFechaInsertaPc) {
        this.usrFechaInsertaPc = usrFechaInsertaPc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infMac != null ? infMac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisPcs)) {
            return false;
        }
        SisPcs other = (SisPcs) object;
        if ((this.infMac == null && other.infMac != null) || (this.infMac != null && !this.infMac.equals(other.infMac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisPcs[ infMac=" + infMac + " ]";
    }
    
}
