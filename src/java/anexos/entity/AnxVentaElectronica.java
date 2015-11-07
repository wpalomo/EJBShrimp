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
@Table(name = "anx_venta_electronica",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxVentaElectronica.findAll", query = "SELECT a FROM AnxVentaElectronica a"),
    @NamedQuery(name = "AnxVentaElectronica.findByESecuencial", query = "SELECT a FROM AnxVentaElectronica a WHERE a.eSecuencial = :eSecuencial"),
    @NamedQuery(name = "AnxVentaElectronica.findByETipoAmbiente", query = "SELECT a FROM AnxVentaElectronica a WHERE a.eTipoAmbiente = :eTipoAmbiente"),
    @NamedQuery(name = "AnxVentaElectronica.findByEClaveAcceso", query = "SELECT a FROM AnxVentaElectronica a WHERE a.eClaveAcceso = :eClaveAcceso"),
    @NamedQuery(name = "AnxVentaElectronica.findByEEstado", query = "SELECT a FROM AnxVentaElectronica a WHERE a.eEstado = :eEstado"),
    @NamedQuery(name = "AnxVentaElectronica.findByEAutorizacionNumero", query = "SELECT a FROM AnxVentaElectronica a WHERE a.eAutorizacionNumero = :eAutorizacionNumero"),
    @NamedQuery(name = "AnxVentaElectronica.findByEAutorizacionFecha", query = "SELECT a FROM AnxVentaElectronica a WHERE a.eAutorizacionFecha = :eAutorizacionFecha"),
    @NamedQuery(name = "AnxVentaElectronica.findByEEnviadoPorCorreo", query = "SELECT a FROM AnxVentaElectronica a WHERE a.eEnviadoPorCorreo = :eEnviadoPorCorreo"),
    @NamedQuery(name = "AnxVentaElectronica.findByVtaEmpresa", query = "SELECT a FROM AnxVentaElectronica a WHERE a.vtaEmpresa = :vtaEmpresa"),
    @NamedQuery(name = "AnxVentaElectronica.findByVtaPeriodo", query = "SELECT a FROM AnxVentaElectronica a WHERE a.vtaPeriodo = :vtaPeriodo"),
    @NamedQuery(name = "AnxVentaElectronica.findByVtaMotivo", query = "SELECT a FROM AnxVentaElectronica a WHERE a.vtaMotivo = :vtaMotivo"),
    @NamedQuery(name = "AnxVentaElectronica.findByVtaNumero", query = "SELECT a FROM AnxVentaElectronica a WHERE a.vtaNumero = :vtaNumero"),
    @NamedQuery(name = "AnxVentaElectronica.findByUsrEmpresa", query = "SELECT a FROM AnxVentaElectronica a WHERE a.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "AnxVentaElectronica.findByUsrCodigo", query = "SELECT a FROM AnxVentaElectronica a WHERE a.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "AnxVentaElectronica.findByUsrFechaInserta", query = "SELECT a FROM AnxVentaElectronica a WHERE a.usrFechaInserta = :usrFechaInserta")})
public class AnxVentaElectronica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "e_secuencial")
    private Integer eSecuencial;
    @Basic(optional = false)
    @Column(name = "e_tipo_ambiente")
    private String eTipoAmbiente;
    @Basic(optional = false)
    @Column(name = "e_clave_acceso")
    private String eClaveAcceso;
    @Basic(optional = false)
    @Column(name = "e_estado")
    private String eEstado;
    @Basic(optional = false)
    @Column(name = "e_autorizacion_numero")
    private String eAutorizacionNumero;
    @Basic(optional = false)
    @Column(name = "e_autorizacion_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eAutorizacionFecha;
    @Lob
    @Column(name = "e_xml")
    private byte[] eXml;
    @Basic(optional = false)
    @Column(name = "e_enviado_por_correo")
    private boolean eEnviadoPorCorreo;
    @Basic(optional = false)
    @Column(name = "vta_empresa")
    private String vtaEmpresa;
    @Basic(optional = false)
    @Column(name = "vta_periodo")
    private String vtaPeriodo;
    @Basic(optional = false)
    @Column(name = "vta_motivo")
    private String vtaMotivo;
    @Basic(optional = false)
    @Column(name = "vta_numero")
    private String vtaNumero;
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

    public AnxVentaElectronica() {
    }

    public AnxVentaElectronica(Integer eSecuencial) {
        this.eSecuencial = eSecuencial;
    }

    public AnxVentaElectronica(Integer eSecuencial, String eTipoAmbiente, String eClaveAcceso, String eEstado, String eAutorizacionNumero, Date eAutorizacionFecha, boolean eEnviadoPorCorreo, String vtaEmpresa, String vtaPeriodo, String vtaMotivo, String vtaNumero, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.eSecuencial = eSecuencial;
        this.eTipoAmbiente = eTipoAmbiente;
        this.eClaveAcceso = eClaveAcceso;
        this.eEstado = eEstado;
        this.eAutorizacionNumero = eAutorizacionNumero;
        this.eAutorizacionFecha = eAutorizacionFecha;
        this.eEnviadoPorCorreo = eEnviadoPorCorreo;
        this.vtaEmpresa = vtaEmpresa;
        this.vtaPeriodo = vtaPeriodo;
        this.vtaMotivo = vtaMotivo;
        this.vtaNumero = vtaNumero;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Integer getESecuencial() {
        return eSecuencial;
    }

    public void setESecuencial(Integer eSecuencial) {
        this.eSecuencial = eSecuencial;
    }

    public String getETipoAmbiente() {
        return eTipoAmbiente;
    }

    public void setETipoAmbiente(String eTipoAmbiente) {
        this.eTipoAmbiente = eTipoAmbiente;
    }

    public String getEClaveAcceso() {
        return eClaveAcceso;
    }

    public void setEClaveAcceso(String eClaveAcceso) {
        this.eClaveAcceso = eClaveAcceso;
    }

    public String getEEstado() {
        return eEstado;
    }

    public void setEEstado(String eEstado) {
        this.eEstado = eEstado;
    }

    public String getEAutorizacionNumero() {
        return eAutorizacionNumero;
    }

    public void setEAutorizacionNumero(String eAutorizacionNumero) {
        this.eAutorizacionNumero = eAutorizacionNumero;
    }

    public Date getEAutorizacionFecha() {
        return eAutorizacionFecha;
    }

    public void setEAutorizacionFecha(Date eAutorizacionFecha) {
        this.eAutorizacionFecha = eAutorizacionFecha;
    }

    public byte[] getEXml() {
        return eXml;
    }

    public void setEXml(byte[] eXml) {
        this.eXml = eXml;
    }

    public boolean getEEnviadoPorCorreo() {
        return eEnviadoPorCorreo;
    }

    public void setEEnviadoPorCorreo(boolean eEnviadoPorCorreo) {
        this.eEnviadoPorCorreo = eEnviadoPorCorreo;
    }

    public String getVtaEmpresa() {
        return vtaEmpresa;
    }

    public void setVtaEmpresa(String vtaEmpresa) {
        this.vtaEmpresa = vtaEmpresa;
    }

    public String getVtaPeriodo() {
        return vtaPeriodo;
    }

    public void setVtaPeriodo(String vtaPeriodo) {
        this.vtaPeriodo = vtaPeriodo;
    }

    public String getVtaMotivo() {
        return vtaMotivo;
    }

    public void setVtaMotivo(String vtaMotivo) {
        this.vtaMotivo = vtaMotivo;
    }

    public String getVtaNumero() {
        return vtaNumero;
    }

    public void setVtaNumero(String vtaNumero) {
        this.vtaNumero = vtaNumero;
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
        hash += (eSecuencial != null ? eSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxVentaElectronica)) {
            return false;
        }
        AnxVentaElectronica other = (AnxVentaElectronica) object;
        if ((this.eSecuencial == null && other.eSecuencial != null) || (this.eSecuencial != null && !this.eSecuencial.equals(other.eSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxVentaElectronica[ eSecuencial=" + eSecuencial + " ]";
    }
    
}
