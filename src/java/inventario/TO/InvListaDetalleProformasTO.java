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
public class InvListaDetalleProformasTO implements java.io.Serializable {
    
    private Integer secuencial;
    private String codigoProducto;
    private String nombreProducto;
    private java.math.BigDecimal cantidadProducto;
    private String medidaDetalle;
    private java.math.BigDecimal precioProducto;
    private java.math.BigDecimal parcialProducto;
    private java.math.BigDecimal porcentajeDescuento;
    private java.math.BigDecimal valordescuento;//10
    private java.math.BigDecimal detalleSubTotal;
    private Boolean grabaIva;
    private Boolean editarFila;
    private java.math.BigDecimal detCantidadCaja;
    private String detEmpaque;
    private String detPresentacionUnidad;
    private String detPresentacionCaja;
    private String detProductoTipo;
    

    public InvListaDetalleProformasTO() {
    }
    
    

  
//    @Override
//    public String toString(){
//        return this.secuencial + " " +this.codigoProducto + " " + this.nombreProducto + " " + this.cantidadProducto + " " + this.medidaDetalle + " " +
//                " " + this.precioProducto + " " + this.parcialProducto + " " + this.porcentajeDescuento + " " +
//                this.detalleDescuento + this.detalleSubtotal + " " + this.gravaIva;
//    }

    public InvListaDetalleProformasTO(Integer secuencial, String codigoProducto, String nombreProducto, BigDecimal cantidadProducto, String medidaDetalle, BigDecimal precioProducto, BigDecimal parcialProducto, BigDecimal porcentajeDescuento, BigDecimal valordescuento, BigDecimal detalleSubTotal, boolean grabaIva, Boolean editarFila, BigDecimal detCantidadCaja, String detEmpaque, String detPresentacionUnidad, String detPresentacionCaja, String detProductoTipo) {
        this.secuencial = secuencial;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.medidaDetalle = medidaDetalle;
        this.precioProducto = precioProducto;
        this.parcialProducto = parcialProducto;
        this.porcentajeDescuento = porcentajeDescuento;
        this.valordescuento = valordescuento;
        this.detalleSubTotal = detalleSubTotal;
        this.grabaIva = grabaIva;
        this.editarFila = editarFila;
        this.detCantidadCaja = detCantidadCaja;
        this.detEmpaque = detEmpaque;
        this.detPresentacionUnidad = detPresentacionUnidad;
        this.detPresentacionCaja = detPresentacionCaja;
        this.detProductoTipo = detProductoTipo;
    }

    public BigDecimal getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(BigDecimal cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public BigDecimal getDetCantidadCaja() {
        return detCantidadCaja;
    }

    public void setDetCantidadCaja(BigDecimal detCantidadCaja) {
        this.detCantidadCaja = detCantidadCaja;
    }

    public String getDetEmpaque() {
        return detEmpaque;
    }

    public void setDetEmpaque(String detEmpaque) {
        this.detEmpaque = detEmpaque;
    }

    public String getDetPresentacionCaja() {
        return detPresentacionCaja;
    }

    public void setDetPresentacionCaja(String detPresentacionCaja) {
        this.detPresentacionCaja = detPresentacionCaja;
    }

    public String getDetPresentacionUnidad() {
        return detPresentacionUnidad;
    }

    public void setDetPresentacionUnidad(String detPresentacionUnidad) {
        this.detPresentacionUnidad = detPresentacionUnidad;
    }

    public String getDetProductoTipo() {
        return detProductoTipo;
    }

    public void setDetProductoTipo(String detProductoTipo) {
        this.detProductoTipo = detProductoTipo;
    }

    public BigDecimal getDetalleSubTotal() {
        return detalleSubTotal;
    }

    public void setDetalleSubTotal(BigDecimal detalleSubTotal) {
        this.detalleSubTotal = detalleSubTotal;
    }

    public Boolean getEditarFila() {
        return editarFila;
    }

    public void setEditarFila(Boolean editarFila) {
        this.editarFila = editarFila;
    }

    public Boolean getGrabaIva() {
        return grabaIva;
    }

    public void setGrabaIva(Boolean grabaIva) {
        this.grabaIva = grabaIva;
    }

    public String getMedidaDetalle() {
        return medidaDetalle;
    }

    public void setMedidaDetalle(String medidaDetalle) {
        this.medidaDetalle = medidaDetalle;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getParcialProducto() {
        return parcialProducto;
    }

    public void setParcialProducto(BigDecimal parcialProducto) {
        this.parcialProducto = parcialProducto;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(Integer secuencial) {
        this.secuencial = secuencial;
    }

    public BigDecimal getValordescuento() {
        return valordescuento;
    }

    public void setValordescuento(BigDecimal valordescuento) {
        this.valordescuento = valordescuento;
    }
    
}
