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
@Table(name = "anx_numeracion",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxNumeracion.findAll", query = "SELECT a FROM AnxNumeracion a"),
    @NamedQuery(name = "AnxNumeracion.findByNumSecuencial", query = "SELECT a FROM AnxNumeracion a WHERE a.numSecuencial = :numSecuencial"),
    @NamedQuery(name = "AnxNumeracion.findByNumEmpresa", query = "SELECT a FROM AnxNumeracion a WHERE a.numEmpresa = :numEmpresa"),
    @NamedQuery(name = "AnxNumeracion.findByNumComprobante", query = "SELECT a FROM AnxNumeracion a WHERE a.numComprobante = :numComprobante"),
    @NamedQuery(name = "AnxNumeracion.findByNumDesde", query = "SELECT a FROM AnxNumeracion a WHERE a.numDesde = :numDesde"),
    @NamedQuery(name = "AnxNumeracion.findByNumHasta", query = "SELECT a FROM AnxNumeracion a WHERE a.numHasta = :numHasta"),
    @NamedQuery(name = "AnxNumeracion.findByNumAutorizacion", query = "SELECT a FROM AnxNumeracion a WHERE a.numAutorizacion = :numAutorizacion"),
    @NamedQuery(name = "AnxNumeracion.findByNumCaduca", query = "SELECT a FROM AnxNumeracion a WHERE a.numCaduca = :numCaduca"),
    @NamedQuery(name = "AnxNumeracion.findByNumLineas", query = "SELECT a FROM AnxNumeracion a WHERE a.numLineas = :numLineas"),
    @NamedQuery(name = "AnxNumeracion.findByNumFormatoPos", query = "SELECT a FROM AnxNumeracion a WHERE a.numFormatoPos = :numFormatoPos"),
    @NamedQuery(name = "AnxNumeracion.findByNumDocumentoElectronico", query = "SELECT a FROM AnxNumeracion a WHERE a.numDocumentoElectronico = :numDocumentoElectronico"),
    @NamedQuery(name = "AnxNumeracion.findByNumAmbienteProduccion", query = "SELECT a FROM AnxNumeracion a WHERE a.numAmbienteProduccion = :numAmbienteProduccion"),
    @NamedQuery(name = "AnxNumeracion.findByNumMostrarDialogoImpresion", query = "SELECT a FROM AnxNumeracion a WHERE a.numMostrarDialogoImpresion = :numMostrarDialogoImpresion"),
    @NamedQuery(name = "AnxNumeracion.findBySecEmpresa", query = "SELECT a FROM AnxNumeracion a WHERE a.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "AnxNumeracion.findBySecCodigo", query = "SELECT a FROM AnxNumeracion a WHERE a.secCodigo = :secCodigo"),
    @NamedQuery(name = "AnxNumeracion.findByUsrEmpresa", query = "SELECT a FROM AnxNumeracion a WHERE a.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "AnxNumeracion.findByUsrCodigo", query = "SELECT a FROM AnxNumeracion a WHERE a.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "AnxNumeracion.findByUsrFechaInserta", query = "SELECT a FROM AnxNumeracion a WHERE a.usrFechaInserta = :usrFechaInserta")})
public class AnxNumeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_secuencial")
    private Integer numSecuencial;
    @Basic(optional = false)
    @Column(name = "num_empresa")
    private String numEmpresa;
    @Basic(optional = false)
    @Column(name = "num_comprobante")
    private String numComprobante;
    @Basic(optional = false)
    @Column(name = "num_desde")
    private String numDesde;
    @Basic(optional = false)
    @Column(name = "num_hasta")
    private String numHasta;
    @Column(name = "num_autorizacion")
    private String numAutorizacion;
    @Column(name = "num_caduca")
    private String numCaduca;
    @Column(name = "num_lineas")
    private Short numLineas;
    @Basic(optional = false)
    @Column(name = "num_formato_pos")
    private boolean numFormatoPos;
    @Basic(optional = false)
    @Column(name = "num_documento_electronico")
    private boolean numDocumentoElectronico;
    @Basic(optional = false)
    @Column(name = "num_ambiente_produccion")
    private boolean numAmbienteProduccion;
    @Basic(optional = false)
    @Column(name = "num_mostrar_dialogo_impresion")
    private boolean numMostrarDialogoImpresion;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
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

    public AnxNumeracion() {
    }

    public AnxNumeracion(Integer numSecuencial) {
        this.numSecuencial = numSecuencial;
    }

    public AnxNumeracion(Integer numSecuencial, String numEmpresa, String numComprobante, String numDesde, String numHasta, boolean numFormatoPos, boolean numDocumentoElectronico, boolean numAmbienteProduccion, boolean numMostrarDialogoImpresion, String secEmpresa, String secCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.numSecuencial = numSecuencial;
        this.numEmpresa = numEmpresa;
        this.numComprobante = numComprobante;
        this.numDesde = numDesde;
        this.numHasta = numHasta;
        this.numFormatoPos = numFormatoPos;
        this.numDocumentoElectronico = numDocumentoElectronico;
        this.numAmbienteProduccion = numAmbienteProduccion;
        this.numMostrarDialogoImpresion = numMostrarDialogoImpresion;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Integer getNumSecuencial() {
        return numSecuencial;
    }

    public void setNumSecuencial(Integer numSecuencial) {
        this.numSecuencial = numSecuencial;
    }

    public String getNumEmpresa() {
        return numEmpresa;
    }

    public void setNumEmpresa(String numEmpresa) {
        this.numEmpresa = numEmpresa;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public String getNumDesde() {
        return numDesde;
    }

    public void setNumDesde(String numDesde) {
        this.numDesde = numDesde;
    }

    public String getNumHasta() {
        return numHasta;
    }

    public void setNumHasta(String numHasta) {
        this.numHasta = numHasta;
    }

    public String getNumAutorizacion() {
        return numAutorizacion;
    }

    public void setNumAutorizacion(String numAutorizacion) {
        this.numAutorizacion = numAutorizacion;
    }

    public String getNumCaduca() {
        return numCaduca;
    }

    public void setNumCaduca(String numCaduca) {
        this.numCaduca = numCaduca;
    }

    public Short getNumLineas() {
        return numLineas;
    }

    public void setNumLineas(Short numLineas) {
        this.numLineas = numLineas;
    }

    public boolean getNumFormatoPos() {
        return numFormatoPos;
    }

    public void setNumFormatoPos(boolean numFormatoPos) {
        this.numFormatoPos = numFormatoPos;
    }

    public boolean getNumDocumentoElectronico() {
        return numDocumentoElectronico;
    }

    public void setNumDocumentoElectronico(boolean numDocumentoElectronico) {
        this.numDocumentoElectronico = numDocumentoElectronico;
    }

    public boolean getNumAmbienteProduccion() {
        return numAmbienteProduccion;
    }

    public void setNumAmbienteProduccion(boolean numAmbienteProduccion) {
        this.numAmbienteProduccion = numAmbienteProduccion;
    }

    public boolean getNumMostrarDialogoImpresion() {
        return numMostrarDialogoImpresion;
    }

    public void setNumMostrarDialogoImpresion(boolean numMostrarDialogoImpresion) {
        this.numMostrarDialogoImpresion = numMostrarDialogoImpresion;
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
        hash += (numSecuencial != null ? numSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxNumeracion)) {
            return false;
        }
        AnxNumeracion other = (AnxNumeracion) object;
        if ((this.numSecuencial == null && other.numSecuencial != null) || (this.numSecuencial != null && !this.numSecuencial.equals(other.numSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxNumeracion[ numSecuencial=" + numSecuencial + " ]";
    }
    
}
