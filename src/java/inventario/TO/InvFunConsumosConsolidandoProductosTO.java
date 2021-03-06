/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class InvFunConsumosConsolidandoProductosTO implements java.io.Serializable{
    private String ccpProducto;
    private String ccpCodigo;
    private String ccpMedida;
    private java.math.BigDecimal ccpCantidad;  
    private java.math.BigDecimal ccpPorcentaje;

    public InvFunConsumosConsolidandoProductosTO() {
    }

    public InvFunConsumosConsolidandoProductosTO(String ccpProducto, String ccpCodigo, String ccpMedida, BigDecimal ccpCantidad, BigDecimal ccpPorcentaje) {
        this.ccpProducto = ccpProducto;
        this.ccpCodigo = ccpCodigo;
        this.ccpMedida = ccpMedida;
        this.ccpCantidad = ccpCantidad;     
        this.ccpPorcentaje = ccpPorcentaje;
    }

    public BigDecimal getCcpCantidad() {
        return ccpCantidad;
    }

    public void setCcpCantidad(BigDecimal ccpCantidad) {
        this.ccpCantidad = ccpCantidad;
    }

    public String getCcpCodigo() {
        return ccpCodigo;
    }

    public void setCcpCodigo(String ccpCodigo) {
        this.ccpCodigo = ccpCodigo;
    }

    public String getCcpMedida() {
        return ccpMedida;
    }

    public void setCcpMedida(String ccpMedida) {
        this.ccpMedida = ccpMedida;
    }

    public BigDecimal getCcpPorcentaje() {
        return ccpPorcentaje;
    }

    public void setCcpPorcentaje(BigDecimal ccpPorcentaje) {
        this.ccpPorcentaje = ccpPorcentaje;
    }

    public String getCcpProducto() {
        return ccpProducto;
    }

    public void setCcpProducto(String ccpProducto) {
        this.ccpProducto = ccpProducto;
    }
 
}
