/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvComprasRecepcionTO implements java.io.Serializable{
    private String recepEmpresa;
    private String recepPeriodo;
    private String recepMotivo;
    private String recepNumero;
    private String recepFecha;
    private String compEmpresa;
    private String compPeriodo;
    private String compMotivo;
    private String compNumero;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public InvComprasRecepcionTO() {
    }

    public InvComprasRecepcionTO(String recepEmpresa, String recepPeriodo, String recepMotivo, String recepNumero, String recepFecha, String compEmpresa, String compPeriodo, String compMotivo, String compNumero, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.recepEmpresa = recepEmpresa;
        this.recepPeriodo = recepPeriodo;
        this.recepMotivo = recepMotivo;
        this.recepNumero = recepNumero;
        this.recepFecha = recepFecha;
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

    public String getRecepEmpresa() {
        return recepEmpresa;
    }

    public void setRecepEmpresa(String recepEmpresa) {
        this.recepEmpresa = recepEmpresa;
    }

    public String getRecepFecha() {
        return recepFecha;
    }

    public void setRecepFecha(String recepFecha) {
        this.recepFecha = recepFecha;
    }

    public String getRecepMotivo() {
        return recepMotivo;
    }

    public void setRecepMotivo(String recepMotivo) {
        this.recepMotivo = recepMotivo;
    }

    public String getRecepNumero() {
        return recepNumero;
    }

    public void setRecepNumero(String recepNumero) {
        this.recepNumero = recepNumero;
    }

    public String getRecepPeriodo() {
        return recepPeriodo;
    }

    public void setRecepPeriodo(String recepPeriodo) {
        this.recepPeriodo = recepPeriodo;
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

    @Override
    public String toString(){
        return this.recepEmpresa + " " + this.recepPeriodo + " " + this.recepMotivo  + " " + this.recepNumero  + " " + this.recepFecha  + " " +
                this.compEmpresa  + " " + this.compPeriodo  + " " + this.compMotivo  + " " + this.compNumero  + " " + this.usrEmpresa  + " " +
                this.usrCodigo  + " " + this.usrFechaInserta;
    }
}
