/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.reporte;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ReporteConsolidadoProducto {
    ///CABECERA
    private String desde;
    private String hasta;
    private String bodega;
    private String proveedor;
    
    ///DETALLE
    private String ccpProducto;
    private String ccpCodigo;
    private String ccpMedida;
    private java.math.BigDecimal ccpCantidad;
    private java.math.BigDecimal ccpTotal;
    private java.math.BigDecimal ccpPorcentaje;

    public ReporteConsolidadoProducto() {
    }

    public ReporteConsolidadoProducto(String desde, String hasta, String bodega, String proveedor, String ccpProducto, String ccpCodigo, String ccpMedida, BigDecimal ccpCantidad, BigDecimal ccpTotal, BigDecimal ccpPorcentaje) {
        this.desde = desde;
        this.hasta = hasta;
        this.bodega = bodega;
        this.proveedor = proveedor;
        this.ccpProducto = ccpProducto;
        this.ccpCodigo = ccpCodigo;
        this.ccpMedida = ccpMedida;
        this.ccpCantidad = ccpCantidad;
        this.ccpTotal = ccpTotal;
        this.ccpPorcentaje = ccpPorcentaje;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
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

    public BigDecimal getCcpTotal() {
        return ccpTotal;
    }

    public void setCcpTotal(BigDecimal ccpTotal) {
        this.ccpTotal = ccpTotal;
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}
