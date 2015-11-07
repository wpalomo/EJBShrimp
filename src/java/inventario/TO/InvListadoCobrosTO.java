/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.TO;

/**
 *
 * @author jack
 */
public class InvListadoCobrosTO implements java.io.Serializable{
    private String cobPeriodo;
    private String cobTipo;
    private String cobNumero;
    private String cobFecha;
    private String cobCuentaCodigo;
    private String cobCuentaDetalle;
    private String cobDocumento;
    private String cobObservaciones;

    public InvListadoCobrosTO() {
    }

    public InvListadoCobrosTO(String cobPeriodo, String cobTipo, String cobNumero, String cobFecha, String cobCuentaCodigo, String cobCuentaDetalle, String cobDocumento, String cobObservaciones) {
        this.cobPeriodo = cobPeriodo;
        this.cobTipo = cobTipo;
        this.cobNumero = cobNumero;
        this.cobFecha = cobFecha;
        this.cobCuentaCodigo = cobCuentaCodigo;
        this.cobCuentaDetalle = cobCuentaDetalle;
        this.cobDocumento = cobDocumento;
        this.cobObservaciones = cobObservaciones;
    }

    public String getCobCuentaCodigo() {
        return cobCuentaCodigo;
    }

    public void setCobCuentaCodigo(String cobCuentaCodigo) {
        this.cobCuentaCodigo = cobCuentaCodigo;
    }

    public String getCobCuentaDetalle() {
        return cobCuentaDetalle;
    }

    public void setCobCuentaDetalle(String cobCuentaDetalle) {
        this.cobCuentaDetalle = cobCuentaDetalle;
    }

    public String getCobDocumento() {
        return cobDocumento;
    }

    public void setCobDocumento(String cobDocumento) {
        this.cobDocumento = cobDocumento;
    }

    public String getCobFecha() {
        return cobFecha;
    }

    public void setCobFecha(String cobFecha) {
        this.cobFecha = cobFecha;
    }

    public String getCobNumero() {
        return cobNumero;
    }

    public void setCobNumero(String cobNumero) {
        this.cobNumero = cobNumero;
    }

    public String getCobObservaciones() {
        return cobObservaciones;
    }

    public void setCobObservaciones(String cobObservaciones) {
        this.cobObservaciones = cobObservaciones;
    }

    public String getCobPeriodo() {
        return cobPeriodo;
    }

    public void setCobPeriodo(String cobPeriodo) {
        this.cobPeriodo = cobPeriodo;
    }

    public String getCobTipo() {
        return cobTipo;
    }

    public void setCobTipo(String cobTipo) {
        this.cobTipo = cobTipo;
    }
    
    @Override
    public String toString(){
        return this.cobPeriodo + "|" + this.cobTipo + "|" + this.cobNumero;
    }
}
