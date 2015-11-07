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
public class PrdConsumosPorPiscinaPeriodoTO {
    private String consumoFecha;
    private String consumoProducto;
    private String consumoCodigo;
    private String consumoMedida;
    private java.math.BigDecimal consumoTotal;

    public PrdConsumosPorPiscinaPeriodoTO() {
    }

    public PrdConsumosPorPiscinaPeriodoTO(String consumoFecha, String consumoProducto, String consumoCodigo, String consumoMedida, BigDecimal consumoTotal) {
        this.consumoFecha = consumoFecha;
        this.consumoProducto = consumoProducto;
        this.consumoCodigo = consumoCodigo;
        this.consumoMedida = consumoMedida;
        this.consumoTotal = consumoTotal;
    }

    public String getConsumoCodigo() {
        return consumoCodigo;
    }

    public void setConsumoCodigo(String consumoCodigo) {
        this.consumoCodigo = consumoCodigo;
    }

    public String getConsumoFecha() {
        return consumoFecha;
    }

    public void setConsumoFecha(String consumoFecha) {
        this.consumoFecha = consumoFecha;
    }

    public String getConsumoMedida() {
        return consumoMedida;
    }

    public void setConsumoMedida(String consumoMedida) {
        this.consumoMedida = consumoMedida;
    }

    public String getConsumoProducto() {
        return consumoProducto;
    }

    public void setConsumoProducto(String consumoProducto) {
        this.consumoProducto = consumoProducto;
    }

    public BigDecimal getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(BigDecimal consumoTotal) {
        this.consumoTotal = consumoTotal;
    }
}
