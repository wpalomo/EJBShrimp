/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "caj_caja", schema = "caja")
@NamedQueries({
    @NamedQuery(name = "CajCaja.findAll", query = "SELECT c FROM CajCaja c"),
    @NamedQuery(name = "CajCaja.findByCajaEmpresa", query = "SELECT c FROM CajCaja c WHERE c.cajCajaPK.cajaEmpresa = :cajaEmpresa"),
    @NamedQuery(name = "CajCaja.findByCajaCodigo", query = "SELECT c FROM CajCaja c WHERE c.cajCajaPK.cajaCodigo = :cajaCodigo"),
    @NamedQuery(name = "CajCaja.findByCajaNombre", query = "SELECT c FROM CajCaja c WHERE c.cajaNombre = :cajaNombre"),
    @NamedQuery(name = "CajCaja.findByCajaUsuarioResponsable", query = "SELECT c FROM CajCaja c WHERE c.cajaUsuarioResponsable = :cajaUsuarioResponsable"),
    @NamedQuery(name = "CajCaja.findByCajaCertificadoFirmaDigitalNombre", query = "SELECT c FROM CajCaja c WHERE c.cajaCertificadoFirmaDigitalNombre = :cajaCertificadoFirmaDigitalNombre"),
    @NamedQuery(name = "CajCaja.findByCajaCertificadoFirmaDigitalClave", query = "SELECT c FROM CajCaja c WHERE c.cajaCertificadoFirmaDigitalClave = :cajaCertificadoFirmaDigitalClave"),
    @NamedQuery(name = "CajCaja.findByCajaActiva", query = "SELECT c FROM CajCaja c WHERE c.cajaActiva = :cajaActiva"),
    @NamedQuery(name = "CajCaja.findByPermisoEliminarFilas", query = "SELECT c FROM CajCaja c WHERE c.permisoEliminarFilas = :permisoEliminarFilas"),
    @NamedQuery(name = "CajCaja.findByPermisoCambiarPrecio", query = "SELECT c FROM CajCaja c WHERE c.permisoCambiarPrecio = :permisoCambiarPrecio"),
    @NamedQuery(name = "CajCaja.findByPermisoAplicarDescuentos", query = "SELECT c FROM CajCaja c WHERE c.permisoAplicarDescuentos = :permisoAplicarDescuentos"),
    @NamedQuery(name = "CajCaja.findByPermisoCambiarFecha", query = "SELECT c FROM CajCaja c WHERE c.permisoCambiarFecha = :permisoCambiarFecha"),
    @NamedQuery(name = "CajCaja.findByPermisoCredito", query = "SELECT c FROM CajCaja c WHERE c.permisoCredito = :permisoCredito"),
    @NamedQuery(name = "CajCaja.findByPermisoMotivoPermitido", query = "SELECT c FROM CajCaja c WHERE c.permisoMotivoPermitido = :permisoMotivoPermitido"),
    @NamedQuery(name = "CajCaja.findByPermisoBodegaPermitida", query = "SELECT c FROM CajCaja c WHERE c.permisoBodegaPermitida = :permisoBodegaPermitida"),
    @NamedQuery(name = "CajCaja.findByPermisoDocumentoPermitido", query = "SELECT c FROM CajCaja c WHERE c.permisoDocumentoPermitido = :permisoDocumentoPermitido"),
    @NamedQuery(name = "CajCaja.findByPermisoSecuencialPermitido", query = "SELECT c FROM CajCaja c WHERE c.permisoSecuencialPermitido = :permisoSecuencialPermitido"),
    @NamedQuery(name = "CajCaja.findByPermisoFormaPagoPermitida", query = "SELECT c FROM CajCaja c WHERE c.permisoFormaPagoPermitida = :permisoFormaPagoPermitida"),
    @NamedQuery(name = "CajCaja.findByPermisoPrecioPermitido", query = "SELECT c FROM CajCaja c WHERE c.permisoPrecioPermitido = :permisoPrecioPermitido"),
    @NamedQuery(name = "CajCaja.findByUsrEmpresa", query = "SELECT c FROM CajCaja c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "CajCaja.findByUsrCodigo", query = "SELECT c FROM CajCaja c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "CajCaja.findByUsrFechaInserta", query = "SELECT c FROM CajCaja c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class CajCaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CajCajaPK cajCajaPK;
    @Basic(optional = false)
    @Column(name = "caja_nombre")
    private String cajaNombre;
    @Basic(optional = false)
    @Column(name = "caja_usuario_responsable")
    private String cajaUsuarioResponsable;
    @Column(name = "caja_certificado_firma_digital_nombre")
    private String cajaCertificadoFirmaDigitalNombre;
    @Column(name = "caja_certificado_firma_digital_clave")
    private String cajaCertificadoFirmaDigitalClave;
    @Basic(optional = false)
    @Column(name = "caja_activa")
    private boolean cajaActiva;
    @Basic(optional = false)
    @Column(name = "permiso_eliminar_filas")
    private boolean permisoEliminarFilas;
    @Basic(optional = false)
    @Column(name = "permiso_cambiar_precio")
    private boolean permisoCambiarPrecio;
    @Basic(optional = false)
    @Column(name = "permiso_aplicar_descuentos")
    private boolean permisoAplicarDescuentos;
    @Basic(optional = false)
    @Column(name = "permiso_cambiar_fecha")
    private boolean permisoCambiarFecha;
    @Basic(optional = false)
    @Column(name = "permiso_credito")
    private boolean permisoCredito;
    @Column(name = "permiso_motivo_permitido")
    private String permisoMotivoPermitido;
    @Column(name = "permiso_bodega_permitida")
    private String permisoBodegaPermitida;
    @Basic(optional = false)
    @Column(name = "permiso_documento_permitido")
    private String permisoDocumentoPermitido;
    @Basic(optional = false)
    @Column(name = "permiso_secuencial_permitido")
    private String permisoSecuencialPermitido;
    @Basic(optional = false)
    @Column(name = "permiso_forma_pago_permitida")
    private String permisoFormaPagoPermitida;
    @Column(name = "permiso_precio_permitido")
    private Integer permisoPrecioPermitido;
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

    public CajCaja() {
    }

    public CajCaja(CajCajaPK cajCajaPK) {
        this.cajCajaPK = cajCajaPK;
    }

    public CajCaja(CajCajaPK cajCajaPK, String cajaNombre, String cajaUsuarioResponsable, boolean cajaActiva, boolean permisoEliminarFilas, boolean permisoCambiarPrecio, boolean permisoAplicarDescuentos, boolean permisoCambiarFecha, boolean permisoCredito, String permisoDocumentoPermitido, String permisoSecuencialPermitido, String permisoFormaPagoPermitida, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.cajCajaPK = cajCajaPK;
        this.cajaNombre = cajaNombre;
        this.cajaUsuarioResponsable = cajaUsuarioResponsable;
        this.cajaActiva = cajaActiva;
        this.permisoEliminarFilas = permisoEliminarFilas;
        this.permisoCambiarPrecio = permisoCambiarPrecio;
        this.permisoAplicarDescuentos = permisoAplicarDescuentos;
        this.permisoCambiarFecha = permisoCambiarFecha;
        this.permisoCredito = permisoCredito;
        this.permisoDocumentoPermitido = permisoDocumentoPermitido;
        this.permisoSecuencialPermitido = permisoSecuencialPermitido;
        this.permisoFormaPagoPermitida = permisoFormaPagoPermitida;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public CajCaja(String cajaEmpresa, String cajaCodigo) {
        this.cajCajaPK = new CajCajaPK(cajaEmpresa, cajaCodigo);
    }

    public CajCajaPK getCajCajaPK() {
        return cajCajaPK;
    }

    public void setCajCajaPK(CajCajaPK cajCajaPK) {
        this.cajCajaPK = cajCajaPK;
    }

    public String getCajaNombre() {
        return cajaNombre;
    }

    public void setCajaNombre(String cajaNombre) {
        this.cajaNombre = cajaNombre;
    }

    public String getCajaUsuarioResponsable() {
        return cajaUsuarioResponsable;
    }

    public void setCajaUsuarioResponsable(String cajaUsuarioResponsable) {
        this.cajaUsuarioResponsable = cajaUsuarioResponsable;
    }

    public String getCajaCertificadoFirmaDigitalNombre() {
        return cajaCertificadoFirmaDigitalNombre;
    }

    public void setCajaCertificadoFirmaDigitalNombre(String cajaCertificadoFirmaDigitalNombre) {
        this.cajaCertificadoFirmaDigitalNombre = cajaCertificadoFirmaDigitalNombre;
    }

    public String getCajaCertificadoFirmaDigitalClave() {
        return cajaCertificadoFirmaDigitalClave;
    }

    public void setCajaCertificadoFirmaDigitalClave(String cajaCertificadoFirmaDigitalClave) {
        this.cajaCertificadoFirmaDigitalClave = cajaCertificadoFirmaDigitalClave;
    }

    public boolean getCajaActiva() {
        return cajaActiva;
    }

    public void setCajaActiva(boolean cajaActiva) {
        this.cajaActiva = cajaActiva;
    }

    public boolean getPermisoEliminarFilas() {
        return permisoEliminarFilas;
    }

    public void setPermisoEliminarFilas(boolean permisoEliminarFilas) {
        this.permisoEliminarFilas = permisoEliminarFilas;
    }

    public boolean getPermisoCambiarPrecio() {
        return permisoCambiarPrecio;
    }

    public void setPermisoCambiarPrecio(boolean permisoCambiarPrecio) {
        this.permisoCambiarPrecio = permisoCambiarPrecio;
    }

    public boolean getPermisoAplicarDescuentos() {
        return permisoAplicarDescuentos;
    }

    public void setPermisoAplicarDescuentos(boolean permisoAplicarDescuentos) {
        this.permisoAplicarDescuentos = permisoAplicarDescuentos;
    }

    public boolean getPermisoCambiarFecha() {
        return permisoCambiarFecha;
    }

    public void setPermisoCambiarFecha(boolean permisoCambiarFecha) {
        this.permisoCambiarFecha = permisoCambiarFecha;
    }

    public boolean getPermisoCredito() {
        return permisoCredito;
    }

    public void setPermisoCredito(boolean permisoCredito) {
        this.permisoCredito = permisoCredito;
    }

    public String getPermisoMotivoPermitido() {
        return permisoMotivoPermitido;
    }

    public void setPermisoMotivoPermitido(String permisoMotivoPermitido) {
        this.permisoMotivoPermitido = permisoMotivoPermitido;
    }

    public String getPermisoBodegaPermitida() {
        return permisoBodegaPermitida;
    }

    public void setPermisoBodegaPermitida(String permisoBodegaPermitida) {
        this.permisoBodegaPermitida = permisoBodegaPermitida;
    }

    public String getPermisoDocumentoPermitido() {
        return permisoDocumentoPermitido;
    }

    public void setPermisoDocumentoPermitido(String permisoDocumentoPermitido) {
        this.permisoDocumentoPermitido = permisoDocumentoPermitido;
    }

    public String getPermisoSecuencialPermitido() {
        return permisoSecuencialPermitido;
    }

    public void setPermisoSecuencialPermitido(String permisoSecuencialPermitido) {
        this.permisoSecuencialPermitido = permisoSecuencialPermitido;
    }

    public String getPermisoFormaPagoPermitida() {
        return permisoFormaPagoPermitida;
    }

    public void setPermisoFormaPagoPermitida(String permisoFormaPagoPermitida) {
        this.permisoFormaPagoPermitida = permisoFormaPagoPermitida;
    }

    public Integer getPermisoPrecioPermitido() {
        return permisoPrecioPermitido;
    }

    public void setPermisoPrecioPermitido(Integer permisoPrecioPermitido) {
        this.permisoPrecioPermitido = permisoPrecioPermitido;
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
        hash += (cajCajaPK != null ? cajCajaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajCaja)) {
            return false;
        }
        CajCaja other = (CajCaja) object;
        if ((this.cajCajaPK == null && other.cajCajaPK != null) || (this.cajCajaPK != null && !this.cajCajaPK.equals(other.cajCajaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "caja.entity.CajCaja[ cajCajaPK=" + cajCajaPK + " ]";
    }
    
}
