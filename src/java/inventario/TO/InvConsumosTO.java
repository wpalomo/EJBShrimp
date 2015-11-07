/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvConsumosTO implements java.io.Serializable{
    private String consEmpresa;
    private String consPeriodo;
    private String consMotivo;
    private String consNumero;
    private String consReferencia;
    private String consFecha;
    private String consObservaciones;
    private Boolean consPendiente;
    private Boolean consRevisado;
    private Boolean consAnulado;
    private String usrCodigo;
    private String usrFechaInserta;

    public InvConsumosTO() {
    }

    public InvConsumosTO(String consEmpresa, String consPeriodo, String consMotivo, String consNumero, String consReferencia, String consFecha, String consObservaciones, Boolean consPendiente, Boolean consRevisado, Boolean consAnulado, String usrCodigo, String usrFechaInserta) {
        this.consEmpresa = consEmpresa;
        this.consPeriodo = consPeriodo;
        this.consMotivo = consMotivo;
        this.consNumero = consNumero;
        this.consReferencia = consReferencia;
        this.consFecha = consFecha;
        this.consObservaciones = consObservaciones;
        this.consPendiente = consPendiente;
        this.consRevisado = consRevisado;
        this.consAnulado = consAnulado;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Boolean getConsAnulado() {
        return consAnulado;
    }

    public void setConsAnulado(Boolean consAnulado) {
        this.consAnulado = consAnulado;
    }

    public String getConsEmpresa() {
        return consEmpresa;
    }

    public void setConsEmpresa(String consEmpresa) {
        this.consEmpresa = consEmpresa;
    }

    public String getConsFecha() {
        return consFecha;
    }

    public void setConsFecha(String consFecha) {
        this.consFecha = consFecha;
    }

    public String getConsMotivo() {
        return consMotivo;
    }

    public void setConsMotivo(String consMotivo) {
        this.consMotivo = consMotivo;
    }

    public String getConsNumero() {
        return consNumero;
    }

    public void setConsNumero(String consNumero) {
        this.consNumero = consNumero;
    }

    public String getConsObservaciones() {
        return consObservaciones;
    }

    public void setConsObservaciones(String consObservaciones) {
        this.consObservaciones = consObservaciones;
    }

    public Boolean getConsPendiente() {
        return consPendiente;
    }

    public void setConsPendiente(Boolean consPendiente) {
        this.consPendiente = consPendiente;
    }

    public String getConsPeriodo() {
        return consPeriodo;
    }

    public void setConsPeriodo(String consPeriodo) {
        this.consPeriodo = consPeriodo;
    }

    public String getConsReferencia() {
        return consReferencia;
    }

    public void setConsReferencia(String consReferencia) {
        this.consReferencia = consReferencia;
    }

    public Boolean getConsRevisado() {
        return consRevisado;
    }

    public void setConsRevisado(Boolean consRevisado) {
        this.consRevisado = consRevisado;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }
    
    @Override
    public String toString(){
        return this.consEmpresa + " " + this.consPeriodo + " " + this.consMotivo + " " + this.consNumero +
                " " + this.consFecha + " " + this.consObservaciones + " " + this.consPendiente +
                " " + this.consRevisado + " " + this.consAnulado + " " + this.usrCodigo + " " + this.usrFechaInserta;
    }
}
