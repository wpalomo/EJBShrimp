/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class RhListaDetalleAnticiposLoteTO implements Serializable{
    private String dalFecha;
    private String dalId;
    private String dalNombres;
    private BigDecimal dalValor;
    private String dalFormaPagoDetalle;
    private String dalDocumento;
    private String dalObservaciones;

    public RhListaDetalleAnticiposLoteTO() {
    }

    public RhListaDetalleAnticiposLoteTO(String dalFecha, String dalId, String dalNombres, BigDecimal dalValor, String dalFormaPagoDetalle, String dalDocumento, String dalObservaciones) {
        this.dalFecha = dalFecha;
        this.dalId = dalId;
        this.dalNombres = dalNombres;
        this.dalValor = dalValor;
        this.dalFormaPagoDetalle = dalFormaPagoDetalle;
        this.dalDocumento = dalDocumento;
        this.dalObservaciones = dalObservaciones;
    }

    public String getDalDocumento() {
        return dalDocumento;
    }

    public void setDalDocumento(String dalDocumento) {
        this.dalDocumento = dalDocumento;
    }

    public String getDalFecha() {
        return dalFecha;
    }

    public void setDalFecha(String dalFecha) {
        this.dalFecha = dalFecha;
    }

    public String getDalFormaPagoDetalle() {
        return dalFormaPagoDetalle;
    }

    public void setDalFormaPagoDetalle(String dalFormaPagoDetalle) {
        this.dalFormaPagoDetalle = dalFormaPagoDetalle;
    }

    public String getDalId() {
        return dalId;
    }

    public void setDalId(String dalId) {
        this.dalId = dalId;
    }

    public String getDalNombres() {
        return dalNombres;
    }

    public void setDalNombres(String dalNombres) {
        this.dalNombres = dalNombres;
    }

    public String getDalObservaciones() {
        return dalObservaciones;
    }

    public void setDalObservaciones(String dalObservaciones) {
        this.dalObservaciones = dalObservaciones;
    }

    public BigDecimal getDalValor() {
        return dalValor;
    }

    public void setDalValor(BigDecimal dalValor) {
        this.dalValor = dalValor;
    }
}
