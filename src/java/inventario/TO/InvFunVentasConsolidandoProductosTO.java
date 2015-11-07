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
public class InvFunVentasConsolidandoProductosTO implements java.io.Serializable{
    private String vcpProducto;
    private String vcpCodigo;
    private String vcpMedida;
    private java.math.BigDecimal vcpCantidad;
    private java.math.BigDecimal vcpTotal;
    private java.math.BigDecimal vcpPorcentaje;

    public InvFunVentasConsolidandoProductosTO() {
    }

    public InvFunVentasConsolidandoProductosTO(String vcpProducto, String vcpCodigo, String vcpMedida, BigDecimal vcpCantidad, BigDecimal vcpTotal, BigDecimal vcpPorcentaje) {
        this.vcpProducto = vcpProducto;
        this.vcpCodigo = vcpCodigo;
        this.vcpMedida = vcpMedida;
        this.vcpCantidad = vcpCantidad;
        this.vcpTotal = vcpTotal;
        this.vcpPorcentaje = vcpPorcentaje;
    }

    public BigDecimal getVcpCantidad() {
        return vcpCantidad;
    }

    public void setVcpCantidad(BigDecimal vcpCantidad) {
        this.vcpCantidad = vcpCantidad;
    }

    public String getVcpCodigo() {
        return vcpCodigo;
    }

    public void setVcpCodigo(String vcpCodigo) {
        this.vcpCodigo = vcpCodigo;
    }

    public String getVcpMedida() {
        return vcpMedida;
    }

    public void setVcpMedida(String vcpMedida) {
        this.vcpMedida = vcpMedida;
    }

    public BigDecimal getVcpPorcentaje() {
        return vcpPorcentaje;
    }

    public void setVcpPorcentaje(BigDecimal vcpPorcentaje) {
        this.vcpPorcentaje = vcpPorcentaje;
    }

    public String getVcpProducto() {
        return vcpProducto;
    }

    public void setVcpProducto(String vcpProducto) {
        this.vcpProducto = vcpProducto;
    }

    public BigDecimal getVcpTotal() {
        return vcpTotal;
    }

    public void setVcpTotal(BigDecimal vcpTotal) {
        this.vcpTotal = vcpTotal;
    }
    
}
