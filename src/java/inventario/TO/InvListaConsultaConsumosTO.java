/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.TO;

import java.io.Serializable;

/**
 *
 * @author jack
 */
public class InvListaConsultaConsumosTO implements Serializable {

    private String consStatus;
    private String consFecha;
    private String consObservaciones;
    private String consNumero;

    public InvListaConsultaConsumosTO() {
    }

    public InvListaConsultaConsumosTO(String consStatus, String consFecha, String consObservaciones, String consNumero) {
        this.consStatus = consStatus;
        this.consFecha = consFecha;
        this.consObservaciones = consObservaciones;
        this.consNumero = consNumero;
    }

    public String getConsFecha() {
        return consFecha;
    }

    public void setConsFecha(String consFecha) {
        this.consFecha = consFecha;
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

    public String getConsStatus() {
        return consStatus;
    }

    public void setConsStatus(String consStatus) {
        this.consStatus = consStatus;
    }
}
