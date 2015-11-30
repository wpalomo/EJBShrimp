/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_ventas_forma_pago", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvVentasFormaPago.findAll", query = "SELECT i FROM InvVentasFormaPago i"),
    @NamedQuery(name = "InvVentasFormaPago.findByFpSecuencial", query = "SELECT i FROM InvVentasFormaPago i WHERE i.fpSecuencial = :fpSecuencial"),
    @NamedQuery(name = "InvVentasFormaPago.findByFpDetalle", query = "SELECT i FROM InvVentasFormaPago i WHERE i.fpDetalle = :fpDetalle"),
    @NamedQuery(name = "InvVentasFormaPago.findByFpInactivo", query = "SELECT i FROM InvVentasFormaPago i WHERE i.fpInactivo = :fpInactivo"),
    @NamedQuery(name = "InvVentasFormaPago.findBySecEmpresa", query = "SELECT i FROM InvVentasFormaPago i WHERE i.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "InvVentasFormaPago.findBySecCodigo", query = "SELECT i FROM InvVentasFormaPago i WHERE i.secCodigo = :secCodigo"),
    @NamedQuery(name = "InvVentasFormaPago.findByCtaEmpresa", query = "SELECT i FROM InvVentasFormaPago i WHERE i.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "InvVentasFormaPago.findByCtaCodigo", query = "SELECT i FROM InvVentasFormaPago i WHERE i.ctaCodigo = :ctaCodigo"),
    @NamedQuery(name = "InvVentasFormaPago.findByUsrEmpresa", query = "SELECT i FROM InvVentasFormaPago i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvVentasFormaPago.findByUsrCodigo", query = "SELECT i FROM InvVentasFormaPago i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvVentasFormaPago.findByUsrFechaInserta", query = "SELECT i FROM InvVentasFormaPago i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvVentasFormaPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fp_secuencial")
    private Integer fpSecuencial;
    @Basic(optional = false)
    @Column(name = "fp_detalle")
    private String fpDetalle;
    @Basic(optional = false)
    @Column(name = "fp_inactivo")
    private boolean fpInactivo;
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

    public InvVentasFormaPago() {
    }

    public InvVentasFormaPago(Integer fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
    }

    public InvVentasFormaPago(Integer fpSecuencial, String fpDetalle, boolean fpInactivo, String secEmpresa, String secCodigo, String ctaEmpresa, String ctaCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.fpSecuencial = fpSecuencial;
        this.fpDetalle = fpDetalle;
        this.fpInactivo = fpInactivo;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.ctaEmpresa = ctaEmpresa;
        this.ctaCodigo = ctaCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Integer getFpSecuencial() {
        return fpSecuencial;
    }

    public void setFpSecuencial(Integer fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
    }

    public String getFpDetalle() {
        return fpDetalle;
    }

    public void setFpDetalle(String fpDetalle) {
        this.fpDetalle = fpDetalle;
    }

    public boolean getFpInactivo() {
        return fpInactivo;
    }

    public void setFpInactivo(boolean fpInactivo) {
        this.fpInactivo = fpInactivo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fpSecuencial != null ? fpSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentasFormaPago)) {
            return false;
        }
        InvVentasFormaPago other = (InvVentasFormaPago) object;
        if ((this.fpSecuencial == null && other.fpSecuencial != null) || (this.fpSecuencial != null && !this.fpSecuencial.equals(other.fpSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentasFormaPago[ fpSecuencial=" + fpSecuencial + " ]";
    }
    
}
