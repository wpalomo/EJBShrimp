/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvTransferenciasTO implements java.io.Serializable {
    private String transEmpresa;
    private String transPeriodo;
    private String transMotivo;
    private String transNumero;
    private String transFecha;
    private String transObservaciones;
    private Boolean transPendiente;
    private Boolean transRevisado;
    private Boolean transAnulado;
    private String conEmpresa;
    private String conPeriodo;
    private String conTipo;
    private String conNumero;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public InvTransferenciasTO() {
    }

    public InvTransferenciasTO(String transEmpresa, String transPeriodo, String transMotivo, String transNumero, String transFecha, String transObservaciones, Boolean transPendiente, Boolean transRevisado, Boolean transAnulado, String conEmpresa, String conPeriodo, String conTipo, String conNumero, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.transEmpresa = transEmpresa;
        this.transPeriodo = transPeriodo;
        this.transMotivo = transMotivo;
        this.transNumero = transNumero;
        this.transFecha = transFecha;
        this.transObservaciones = transObservaciones;
        this.transPendiente = transPendiente;
        this.transRevisado = transRevisado;
        this.transAnulado = transAnulado;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public String getConEmpresa() {
        return conEmpresa;
    }

    public void setConEmpresa(String conEmpresa) {
        this.conEmpresa = conEmpresa;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConPeriodo() {
        return conPeriodo;
    }

    public void setConPeriodo(String conPeriodo) {
        this.conPeriodo = conPeriodo;
    }

    public String getConTipo() {
        return conTipo;
    }

    public void setConTipo(String conTipo) {
        this.conTipo = conTipo;
    }

    public Boolean getTransAnulado() {
        return transAnulado;
    }

    public void setTransAnulado(Boolean transAnulado) {
        this.transAnulado = transAnulado;
    }

    public String getTransEmpresa() {
        return transEmpresa;
    }

    public void setTransEmpresa(String transEmpresa) {
        this.transEmpresa = transEmpresa;
    }

    public String getTransFecha() {
        return transFecha;
    }

    public void setTransFecha(String transFecha) {
        this.transFecha = transFecha;
    }

    public String getTransMotivo() {
        return transMotivo;
    }

    public void setTransMotivo(String transMotivo) {
        this.transMotivo = transMotivo;
    }

    public String getTransNumero() {
        return transNumero;
    }

    public void setTransNumero(String transNumero) {
        this.transNumero = transNumero;
    }

    public String getTransObservaciones() {
        return transObservaciones;
    }

    public void setTransObservaciones(String transObservaciones) {
        this.transObservaciones = transObservaciones;
    }

    public Boolean getTransPendiente() {
        return transPendiente;
    }

    public void setTransPendiente(Boolean transPendiente) {
        this.transPendiente = transPendiente;
    }

    public String getTransPeriodo() {
        return transPeriodo;
    }

    public void setTransPeriodo(String transPeriodo) {
        this.transPeriodo = transPeriodo;
    }

    public Boolean getTransRevisado() {
        return transRevisado;
    }

    public void setTransRevisado(Boolean transRevisado) {
        this.transRevisado = transRevisado;
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
