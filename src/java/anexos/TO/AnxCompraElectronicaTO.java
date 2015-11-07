/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

import java.util.Date;

/**
 *
 * @author charly
 */

public class AnxCompraElectronicaTO implements java.io.Serializable{
    /*
  e_secuencial serial NOT NULL,
  e_tipo_ambiente character(10) NOT NULL,
  e_clave_acceso character(50) NOT NULL,
  e_estado character(35) NOT NULL,
  e_autorizacion_numero character(55) NOT NULL,
  e_autorizacion_fecha timestamp without time zone NOT NULL,
  e_xml bytea,
  e_enviado_por_correo boolean NOT NULL,
  comp_empresa character(7) NOT NULL,
  comp_periodo character(7) NOT NULL,
  comp_motivo character(7) NOT NULL,
  comp_numero character(7) NOT NULL,
  usr_empresa character(7) NOT NULL,
  usr_codigo character(7) NOT NULL,
  usr_fecha_inserta timestamp without time zone NOT NULL,
     */
    private Integer eSecuencial;
    private String eTipoAmbiente;
    private String eClaveAcceso;
    private String eEstado;
    private String eAutorizacionNumero;
    private String eAutorizacionFecha;
    private byte[] eXml;
    private Boolean eEnviadoPorCorreo;
    private String compEmpresa;
    private String compPeriodo;
    private String compMotivo;
    private String compNumero;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;
    public AnxCompraElectronicaTO() {
    }

    public AnxCompraElectronicaTO(Integer eSecuencial, String eTipoAmbiente, String eClaveAcceso, String eEstado, String eAutorizacionNumero, String eAutorizacionFecha, byte[] eXml, Boolean eEnviadoPorCorreo, String compEmpresa, String compPeriodo, String compMotivo, String compNumero, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.eSecuencial = eSecuencial;
        this.eTipoAmbiente = eTipoAmbiente;
        this.eClaveAcceso = eClaveAcceso;
        this.eEstado = eEstado;
        this.eAutorizacionNumero = eAutorizacionNumero;
        this.eAutorizacionFecha = eAutorizacionFecha;
        this.eXml = eXml;
        this.eEnviadoPorCorreo = eEnviadoPorCorreo;
        this.compEmpresa = compEmpresa;
        this.compPeriodo = compPeriodo;
        this.compMotivo = compMotivo;
        this.compNumero = compNumero;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public String getCompEmpresa() {
        return compEmpresa;
    }

    public void setCompEmpresa(String compEmpresa) {
        this.compEmpresa = compEmpresa;
    }

    public String getCompMotivo() {
        return compMotivo;
    }

    public void setCompMotivo(String compMotivo) {
        this.compMotivo = compMotivo;
    }

    public String getCompNumero() {
        return compNumero;
    }

    public void setCompNumero(String compNumero) {
        this.compNumero = compNumero;
    }

    public String getCompPeriodo() {
        return compPeriodo;
    }

    public void setCompPeriodo(String compPeriodo) {
        this.compPeriodo = compPeriodo;
    }

    public String geteAutorizacionFecha() {
        return eAutorizacionFecha;
    }

    public void seteAutorizacionFecha(String eAutorizacionFecha) {
        this.eAutorizacionFecha = eAutorizacionFecha;
    }

    public String geteAutorizacionNumero() {
        return eAutorizacionNumero;
    }

    public void seteAutorizacionNumero(String eAutorizacionNumero) {
        this.eAutorizacionNumero = eAutorizacionNumero;
    }

    public String geteClaveAcceso() {
        return eClaveAcceso;
    }

    public void seteClaveAcceso(String eClaveAcceso) {
        this.eClaveAcceso = eClaveAcceso;
    }

    public Boolean geteEnviadoPorCorreo() {
        return eEnviadoPorCorreo;
    }

    public void seteEnviadoPorCorreo(Boolean eEnviadoPorCorreo) {
        this.eEnviadoPorCorreo = eEnviadoPorCorreo;
    }

    public String geteEstado() {
        return eEstado;
    }

    public void seteEstado(String eEstado) {
        this.eEstado = eEstado;
    }

    public Integer geteSecuencial() {
        return eSecuencial;
    }

    public void seteSecuencial(Integer eSecuencial) {
        this.eSecuencial = eSecuencial;
    }

    public String geteTipoAmbiente() {
        return eTipoAmbiente;
    }

    public void seteTipoAmbiente(String eTipoAmbiente) {
        this.eTipoAmbiente = eTipoAmbiente;
    }

    public byte[] geteXml() {
        return eXml;
    }

    public void seteXml(byte[] eXml) {
        this.eXml = eXml;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }
}