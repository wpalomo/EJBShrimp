/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class AnxListaRetencionesPendientesTO implements java.io.Serializable{
    private String retSustentoTributario;
    private String retProveedorTipo;
    private String retProveedorId;
    private String retProveedorNombre;
    private String retProveedorDireccion;
    private String retProveedorCiudad;
    private String retProveedorRelacionado;
    private String retDocumentoTipo;
    private String retDocumentoNombre;
    private String retDocumentoAutorizacion;
    private String retDocumentoNumero;
    private String retCompraFecha;
    private java.math.BigDecimal retCompraBase0;
    private java.math.BigDecimal retCompraBaseImponible;
    private java.math.BigDecimal retCompraBaseExenta;
    private java.math.BigDecimal retCompraMontoIce;
    private java.math.BigDecimal retCompraMontoIva;
    private String retRetencionAutorizacion;
    private String retRetencionNumero;
    private String retRetencionFecha;
    private java.math.BigDecimal retValorRetenidoIr;
    private java.math.BigDecimal retValorBienes10;
    private java.math.BigDecimal retValorServicios20;
    private java.math.BigDecimal retValorBienes;
    private java.math.BigDecimal retValorServicios;
    private java.math.BigDecimal retValorServiciosProfesionales;
    private java.math.BigDecimal retValorRetenidoIva;
    private java.math.BigDecimal retTotalRetenido;
    private String retModificadoDocumentoTipo;
    private String retModificadoDocumentonumero;
    private String retModificadoAutorizacion;
    private String retLlaveCompra;
    private String retLlaveContable;
    
    
    public AnxListaRetencionesPendientesTO() {
    }

    public AnxListaRetencionesPendientesTO(String retSustentoTributario, String retProveedorTipo, String retProveedorId, String retProveedorNombre, String retProveedorDireccion, String retProveedorCiudad, String retProveedorRelacionado, String retDocumentoTipo, String retDocumentoNombre, String retDocumentoAutorizacion, String retDocumentoNumero, String retCompraFecha, BigDecimal retCompraBase0, BigDecimal retCompraBaseImponible, BigDecimal retCompraBaseExenta, BigDecimal retCompraMontoIce, BigDecimal retCompraMontoIva, String retRetencionAutorizacion, String retRetencionNumero, String retRetencionFecha, BigDecimal retValorRetenidoIr, BigDecimal retValorBienes10, BigDecimal retValorBienes20, BigDecimal retValorBienes, BigDecimal retValorServicios, BigDecimal retValorServiciosProfesionales, BigDecimal retValorRetenidoIva, BigDecimal retTotalRetenido, String retModificadoDocumentoTipo, String retModificadoDocumentonumero, String retModificadoAutorizacion, String retLlaveCompra, String retLlaveContable) {
        this.retSustentoTributario = retSustentoTributario;
        this.retProveedorTipo = retProveedorTipo;
        this.retProveedorId = retProveedorId;
        this.retProveedorNombre = retProveedorNombre;
        this.retProveedorDireccion = retProveedorDireccion;
        this.retProveedorCiudad = retProveedorCiudad;
        this.retProveedorRelacionado = retProveedorRelacionado;
        this.retDocumentoTipo = retDocumentoTipo;
        this.retDocumentoNombre = retDocumentoNombre;
        this.retDocumentoAutorizacion = retDocumentoAutorizacion;
        this.retDocumentoNumero = retDocumentoNumero;
        this.retCompraFecha = retCompraFecha;
        this.retCompraBase0 = retCompraBase0;
        this.retCompraBaseImponible = retCompraBaseImponible;
        this.retCompraBaseExenta = retCompraBaseExenta;
        this.retCompraMontoIce = retCompraMontoIce;
        this.retCompraMontoIva = retCompraMontoIva;
        this.retRetencionAutorizacion = retRetencionAutorizacion;
        this.retRetencionNumero = retRetencionNumero;
        this.retRetencionFecha = retRetencionFecha;
        this.retValorRetenidoIr = retValorRetenidoIr;
        this.retValorBienes10 = retValorBienes10;
        this.retValorServicios20 = retValorBienes20;
        this.retValorBienes = retValorBienes;
        this.retValorServicios = retValorServicios;
        this.retValorServiciosProfesionales = retValorServiciosProfesionales;
        this.retValorRetenidoIva = retValorRetenidoIva;
        this.retTotalRetenido = retTotalRetenido;
        this.retModificadoDocumentoTipo = retModificadoDocumentoTipo;
        this.retModificadoDocumentonumero = retModificadoDocumentonumero;
        this.retModificadoAutorizacion = retModificadoAutorizacion;
        this.retLlaveCompra = retLlaveCompra;
        this.retLlaveContable = retLlaveContable;
    }

    public BigDecimal getRetCompraBaseExenta() {
        return retCompraBaseExenta;
    }

    public void setRetCompraBaseExenta(BigDecimal retCompraBaseExenta) {
        this.retCompraBaseExenta = retCompraBaseExenta;
    }

    public BigDecimal getRetCompraMontoIce() {
        return retCompraMontoIce;
    }

    public void setRetCompraMontoIce(BigDecimal retCompraMontoIce) {
        this.retCompraMontoIce = retCompraMontoIce;
    }

    public String getRetProveedorRelacionado() {
        return retProveedorRelacionado;
    }

    public void setRetProveedorRelacionado(String retProveedorRelacionado) {
        this.retProveedorRelacionado = retProveedorRelacionado;
    }

    public BigDecimal getRetValorBienes10() {
        return retValorBienes10;
    }

    public void setRetValorBienes10(BigDecimal retValorBienes10) {
        this.retValorBienes10 = retValorBienes10;
    }

    public BigDecimal getRetValorBienes20() {
        return retValorServicios20;
    }

    public void setRetValorBienes20(BigDecimal retValorBienes20) {
        this.retValorServicios20 = retValorBienes20;
    }

    public BigDecimal getRetCompraBase0() {
        return retCompraBase0;
    }

    public void setRetCompraBase0(BigDecimal retCompraBase0) {
        this.retCompraBase0 = retCompraBase0;
    }

    public BigDecimal getRetCompraBaseImponible() {
        return retCompraBaseImponible;
    }

    public void setRetCompraBaseImponible(BigDecimal retCompraBaseImponible) {
        this.retCompraBaseImponible = retCompraBaseImponible;
    }

    public String getRetCompraFecha() {
        return retCompraFecha;
    }

    public void setRetCompraFecha(String retCompraFecha) {
        this.retCompraFecha = retCompraFecha;
    }

    public BigDecimal getRetCompraMontoIva() {
        return retCompraMontoIva;
    }

    public void setRetCompraMontoIva(BigDecimal retCompraMontoIva) {
        this.retCompraMontoIva = retCompraMontoIva;
    }

    public String getRetDocumentoAutorizacion() {
        return retDocumentoAutorizacion;
    }

    public void setRetDocumentoAutorizacion(String retDocumentoAutorizacion) {
        this.retDocumentoAutorizacion = retDocumentoAutorizacion;
    }

    public String getRetDocumentoNombre() {
        return retDocumentoNombre;
    }

    public void setRetDocumentoNombre(String retDocumentoNombre) {
        this.retDocumentoNombre = retDocumentoNombre;
    }

    public String getRetDocumentoNumero() {
        return retDocumentoNumero;
    }

    public void setRetDocumentoNumero(String retDocumentoNumero) {
        this.retDocumentoNumero = retDocumentoNumero;
    }

    public String getRetDocumentoTipo() {
        return retDocumentoTipo;
    }

    public void setRetDocumentoTipo(String retDocumentoTipo) {
        this.retDocumentoTipo = retDocumentoTipo;
    }

    public String getRetLlaveCompra() {
        return retLlaveCompra;
    }

    public void setRetLlaveCompra(String retLlaveCompra) {
        this.retLlaveCompra = retLlaveCompra;
    }

    public String getRetLlaveContable() {
        return retLlaveContable;
    }

    public void setRetLlaveContable(String retLlaveContable) {
        this.retLlaveContable = retLlaveContable;
    }

    public String getRetProveedorCiudad() {
        return retProveedorCiudad;
    }

    public void setRetProveedorCiudad(String retProveedorCiudad) {
        this.retProveedorCiudad = retProveedorCiudad;
    }

    public String getRetProveedorDireccion() {
        return retProveedorDireccion;
    }

    public void setRetProveedorDireccion(String retProveedorDireccion) {
        this.retProveedorDireccion = retProveedorDireccion;
    }

    public String getRetProveedorId() {
        return retProveedorId;
    }

    public void setRetProveedorId(String retProveedorId) {
        this.retProveedorId = retProveedorId;
    }

    public String getRetProveedorNombre() {
        return retProveedorNombre;
    }

    public void setRetProveedorNombre(String retProveedorNombre) {
        this.retProveedorNombre = retProveedorNombre;
    }

    public String getRetProveedorTipo() {
        return retProveedorTipo;
    }

    public void setRetProveedorTipo(String retProveedorTipo) {
        this.retProveedorTipo = retProveedorTipo;
    }

    public String getRetRetencionAutorizacion() {
        return retRetencionAutorizacion;
    }

    public void setRetRetencionAutorizacion(String retRetencionAutorizacion) {
        this.retRetencionAutorizacion = retRetencionAutorizacion;
    }

    public String getRetRetencionFecha() {
        return retRetencionFecha;
    }

    public void setRetRetencionFecha(String retRetencionFecha) {
        this.retRetencionFecha = retRetencionFecha;
    }

    public String getRetRetencionNumero() {
        return retRetencionNumero;
    }

    public void setRetRetencionNumero(String retRetencionNumero) {
        this.retRetencionNumero = retRetencionNumero;
    }

    public String getRetSustentoTributario() {
        return retSustentoTributario;
    }

    public void setRetSustentoTributario(String retSustentoTributario) {
        this.retSustentoTributario = retSustentoTributario;
    }

    public BigDecimal getRetTotalRetenido() {
        return retTotalRetenido;
    }

    public void setRetTotalRetenido(BigDecimal retTotalRetenido) {
        this.retTotalRetenido = retTotalRetenido;
    }

    public BigDecimal getRetValorBienes() {
        return retValorBienes;
    }

    public void setRetValorBienes(BigDecimal retValorBienes) {
        this.retValorBienes = retValorBienes;
    }

    public BigDecimal getRetValorRetenidoIr() {
        return retValorRetenidoIr;
    }

    public void setRetValorRetenidoIr(BigDecimal retValorRetenidoIr) {
        this.retValorRetenidoIr = retValorRetenidoIr;
    }

    public BigDecimal getRetValorRetenidoIva() {
        return retValorRetenidoIva;
    }

    public void setRetValorRetenidoIva(BigDecimal retValorRetenidoIva) {
        this.retValorRetenidoIva = retValorRetenidoIva;
    }

    public BigDecimal getRetValorServicios() {
        return retValorServicios;
    }

    public void setRetValorServicios(BigDecimal retValorServicios) {
        this.retValorServicios = retValorServicios;
    }

    public BigDecimal getRetValorServiciosProfesionales() {
        return retValorServiciosProfesionales;
    }

    public void setRetValorServiciosProfesionales(BigDecimal retValorServiciosProfesionales) {
        this.retValorServiciosProfesionales = retValorServiciosProfesionales;
    }

    public String getRetModificadoAutorizacion() {
        return retModificadoAutorizacion;
    }

    public void setRetModificadoAutorizacion(String retModificadoAutorizacion) {
        this.retModificadoAutorizacion = retModificadoAutorizacion;
    }

    public String getRetModificadoDocumentoTipo() {
        return retModificadoDocumentoTipo;
    }

    public void setRetModificadoDocumentoTipo(String retModificadoDocumentoTipo) {
        this.retModificadoDocumentoTipo = retModificadoDocumentoTipo;
    }

    public String getRetModificadoDocumentonumero() {
        return retModificadoDocumentonumero;
    }

    public void setRetModificadoDocumentonumero(String retModificadoDocumentonumero) {
        this.retModificadoDocumentonumero = retModificadoDocumentonumero;
    }
    
    
}
