/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.reporte;

/**
 *
 * @author jack
 */
public class InvListaConsultaTransferencia {

    private String desde;
    private String hasta;
    private String status;
    /////////////DETALLE
    private String transStatus;
    private String transFecha;
    private String transObservaciones;
    private String transNumero;

    public InvListaConsultaTransferencia() {
    }

    public InvListaConsultaTransferencia(String desde, String hasta, String status, String transStatus, String transFecha, String transObservaciones, String transNumero) {
        this.desde = desde;
        this.hasta = hasta;
        this.status = status;
        this.transStatus = transStatus;
        this.transFecha = transFecha;
        this.transObservaciones = transObservaciones;
        this.transNumero = transNumero;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransFecha() {
        return transFecha;
    }

    public void setTransFecha(String transFecha) {
        this.transFecha = transFecha;
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

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }
}
