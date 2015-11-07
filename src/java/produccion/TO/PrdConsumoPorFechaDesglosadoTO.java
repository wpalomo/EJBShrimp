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
public class PrdConsumoPorFechaDesglosadoTO implements java.io.Serializable {
    private String consumoSector;
    private String consumoProducto;
    private String consumoCodigo;
    private String consumoMedida;
    private java.math.BigDecimal consumoTotal;

    public PrdConsumoPorFechaDesglosadoTO() {
    }

    public PrdConsumoPorFechaDesglosadoTO(String consumoSector, String consumoProducto, String consumoCodigo, String consumoMedida, BigDecimal consumoTotal) {
        this.consumoSector = consumoSector;
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

    public String getConsumoSector() {
        return consumoSector;
    }

    public void setConsumoSector(String consumoSector) {
        this.consumoSector = consumoSector;
    }

    public BigDecimal getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(BigDecimal consumoTotal) {
        this.consumoTotal = consumoTotal;
    }
}
