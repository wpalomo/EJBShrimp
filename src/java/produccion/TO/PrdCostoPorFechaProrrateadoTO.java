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
public class PrdCostoPorFechaProrrateadoTO implements java.io.Serializable {
    private String costoSectorPiscina;
    private String costoProducto;
    private String costoCodigo;
    private String costoMedida;
    private java.math.BigDecimal costoTotal;

    public PrdCostoPorFechaProrrateadoTO() {
    }

    public PrdCostoPorFechaProrrateadoTO(String costoSectorPiscina, String costoProducto, String costoCodigo, String costoMedida, BigDecimal costoTotal) {
        this.costoSectorPiscina = costoSectorPiscina;
        this.costoProducto = costoProducto;
        this.costoCodigo = costoCodigo;
        this.costoMedida = costoMedida;
        this.costoTotal = costoTotal;
    }

    public String getCostoCodigo() {
        return costoCodigo;
    }

    public void setCostoCodigo(String costoCodigo) {
        this.costoCodigo = costoCodigo;
    }

    public String getCostoMedida() {
        return costoMedida;
    }

    public void setCostoMedida(String costoMedida) {
        this.costoMedida = costoMedida;
    }

    public String getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(String costoProducto) {
        this.costoProducto = costoProducto;
    }

    public String getCostoSectorPiscina() {
        return costoSectorPiscina;
    }

    public void setCostoSectorPiscina(String costoSectorPiscina) {
        this.costoSectorPiscina = costoSectorPiscina;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }
}
