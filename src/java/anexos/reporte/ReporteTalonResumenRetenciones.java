/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.reporte;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ReporteTalonResumenRetenciones {
    private String desde;
    private String hasta;


    /////
    private String retConcepto;
    private Integer retCantidad;
    private java.math.BigDecimal retBaseImponible;
    private java.math.BigDecimal retPorcentaje;
    private java.math.BigDecimal retValorRetenido;

    public ReporteTalonResumenRetenciones() {
    }

    public ReporteTalonResumenRetenciones(String desde, String hasta, String retConcepto, Integer retCantidad, BigDecimal retBaseImponible, BigDecimal retPorcentaje, BigDecimal retValorRetenido) {
        this.desde = desde;
        this.hasta = hasta;
        this.retConcepto = retConcepto;
        this.retCantidad = retCantidad;
        this.retBaseImponible = retBaseImponible;
        this.retPorcentaje = retPorcentaje;
        this.retValorRetenido = retValorRetenido;
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

    public BigDecimal getRetBaseImponible() {
        return retBaseImponible;
    }

    public void setRetBaseImponible(BigDecimal retBaseImponible) {
        this.retBaseImponible = retBaseImponible;
    }

    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }

    public String getRetConcepto() {
        return retConcepto;
    }

    public void setRetConcepto(String retConcepto) {
        this.retConcepto = retConcepto;
    }

    public BigDecimal getRetPorcentaje() {
        return retPorcentaje;
    }

    public void setRetPorcentaje(BigDecimal retPorcentaje) {
        this.retPorcentaje = retPorcentaje;
    }

    public BigDecimal getRetValorRetenido() {
        return retValorRetenido;
    }

    public void setRetValorRetenido(BigDecimal retValorRetenido) {
        this.retValorRetenido = retValorRetenido;
    }
}
