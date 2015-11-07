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
public class RhListaDetalleBonosLoteTO implements Serializable{
    private String dblFecha;
    private String dblId;
    private String dblNombres;
    private BigDecimal dblValor;
    private String dblFormaPagoDetalle;
    private String dblDocumento;
    private String dblObservaciones;

    public RhListaDetalleBonosLoteTO() {
    }

    public RhListaDetalleBonosLoteTO(String dblFecha, String dblId, String dblNombres, BigDecimal dblValor, String dblFormaPagoDetalle, String dblDocumento, String dblObservaciones) {
        this.dblFecha = dblFecha;
        this.dblId = dblId;
        this.dblNombres = dblNombres;
        this.dblValor = dblValor;
        this.dblFormaPagoDetalle = dblFormaPagoDetalle;
        this.dblDocumento = dblDocumento;
        this.dblObservaciones = dblObservaciones;
    }

    public String getDblDocumento() {
        return dblDocumento;
    }

    public void setDblDocumento(String dblDocumento) {
        this.dblDocumento = dblDocumento;
    }

    public String getDblFecha() {
        return dblFecha;
    }

    public void setDblFecha(String dblFecha) {
        this.dblFecha = dblFecha;
    }

    public String getDblFormaPagoDetalle() {
        return dblFormaPagoDetalle;
    }

    public void setDblFormaPagoDetalle(String dblFormaPagoDetalle) {
        this.dblFormaPagoDetalle = dblFormaPagoDetalle;
    }

    public String getDblId() {
        return dblId;
    }

    public void setDblId(String dblId) {
        this.dblId = dblId;
    }

    public String getDblNombres() {
        return dblNombres;
    }

    public void setDblNombres(String dblNombres) {
        this.dblNombres = dblNombres;
    }

    public String getDblObservaciones() {
        return dblObservaciones;
    }

    public void setDblObservaciones(String dblObservaciones) {
        this.dblObservaciones = dblObservaciones;
    }

    public BigDecimal getDblValor() {
        return dblValor;
    }

    public void setDblValor(BigDecimal dblValor) {
        this.dblValor = dblValor;
    }
}
