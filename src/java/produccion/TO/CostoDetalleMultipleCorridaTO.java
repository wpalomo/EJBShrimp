/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produccion.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class CostoDetalleMultipleCorridaTO implements java.io.Serializable{
    private String costoSector;
    private String costoPiscina;
    private String costoCorrida;
    private String costoProducto;
    private String costoCodigo;
    private String costoMedida;
    private java.math.BigDecimal costoCantidad;
    private java.math.BigDecimal costoTotal;
    private java.math.BigDecimal costoPorcentaje;

    public CostoDetalleMultipleCorridaTO() {
    }

    public CostoDetalleMultipleCorridaTO(String costoSector, String costoPiscina, String costoCorrida, String costoProducto, String costoCodigo, String costoMedida, BigDecimal costoCantidad, BigDecimal costoTotal, BigDecimal costoPorcentaje) {
        this.costoSector = costoSector;
        this.costoPiscina = costoPiscina;
        this.costoCorrida = costoCorrida;
        this.costoProducto = costoProducto;
        this.costoCodigo = costoCodigo;
        this.costoMedida = costoMedida;
        this.costoCantidad = costoCantidad;
        this.costoTotal = costoTotal;
        this.costoPorcentaje = costoPorcentaje;
    }

    public BigDecimal getCostoCantidad() {
        return costoCantidad;
    }

    public void setCostoCantidad(BigDecimal costoCantidad) {
        this.costoCantidad = costoCantidad;
    }

    public String getCostoCodigo() {
        return costoCodigo;
    }

    public void setCostoCodigo(String costoCodigo) {
        this.costoCodigo = costoCodigo;
    }

    public String getCostoCorrida() {
        return costoCorrida;
    }

    public void setCostoCorrida(String costoCorrida) {
        this.costoCorrida = costoCorrida;
    }

    public String getCostoMedida() {
        return costoMedida;
    }

    public void setCostoMedida(String costoMedida) {
        this.costoMedida = costoMedida;
    }

    public String getCostoPiscina() {
        return costoPiscina;
    }

    public void setCostoPiscina(String costoPiscina) {
        this.costoPiscina = costoPiscina;
    }

    public BigDecimal getCostoPorcentaje() {
        return costoPorcentaje;
    }

    public void setCostoPorcentaje(BigDecimal costoPorcentaje) {
        this.costoPorcentaje = costoPorcentaje;
    }

    public String getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(String costoProducto) {
        this.costoProducto = costoProducto;
    }

    public String getCostoSector() {
        return costoSector;
    }

    public void setCostoSector(String costoSector) {
        this.costoSector = costoSector;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }
}
