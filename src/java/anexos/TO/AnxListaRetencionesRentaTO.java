/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

import java.math.BigDecimal;

/**
 *
 * @author carlos
 */
public class AnxListaRetencionesRentaTO implements java.io.Serializable{
    private String retSustentotributario;
    private String retConcepto;
    private String retProveedorId;
    private String retProveedorNombre;
    private String retDocumentoNombre;
    private String retDocumentoAutorizacion;
    private String retDocumentoNumero;
    private String retCompraFecha;
    private java.math.BigDecimal retCompraBase0;
    private java.math.BigDecimal retComprabaseImponible;
    private String retRetencionAutorizacion;
    private String retRetencionNumero;
    private String retRetencionFecha;
    private String retValorRetenidoIr;
    private String retLlaveCompra;
    private String retLlavecontable;

    public AnxListaRetencionesRentaTO() {
    }

    public AnxListaRetencionesRentaTO(String retSustentotributario, String retConcepto, String retProveedorId, String retProveedorNombre, String retDocumentoNombre, String retDocumentoAutorizacion, String retDocumentoNumero, String retCompraFecha, BigDecimal retCompraBase0, BigDecimal retComprabaseImponible, String retRetencionAutorizacion, String retRetencionNumero, String retRetencionFecha, String retValorRetenidoIr, String retLlaveCompra, String retLlavecontable) {
        this.retSustentotributario = retSustentotributario;
        this.retConcepto = retConcepto;
        this.retProveedorId = retProveedorId;
        this.retProveedorNombre = retProveedorNombre;
        this.retDocumentoNombre = retDocumentoNombre;
        this.retDocumentoAutorizacion = retDocumentoAutorizacion;
        this.retDocumentoNumero = retDocumentoNumero;
        this.retCompraFecha = retCompraFecha;
        this.retCompraBase0 = retCompraBase0;
        this.retComprabaseImponible = retComprabaseImponible;
        this.retRetencionAutorizacion = retRetencionAutorizacion;
        this.retRetencionNumero = retRetencionNumero;
        this.retRetencionFecha = retRetencionFecha;
        this.retValorRetenidoIr = retValorRetenidoIr;
        this.retLlaveCompra = retLlaveCompra;
        this.retLlavecontable = retLlavecontable;
    }

    
    public BigDecimal getRetCompraBase0() {
        return retCompraBase0;
    }

    public void setRetCompraBase0(BigDecimal retCompraBase0) {
        this.retCompraBase0 = retCompraBase0;
    }

    public BigDecimal getRetComprabaseImponible() {
        return retComprabaseImponible;
    }

    public void setRetComprabaseImponible(BigDecimal retComprabaseImponible) {
        this.retComprabaseImponible = retComprabaseImponible;
    }

    public String getRetCompraFecha() {
        return retCompraFecha;
    }

    public void setRetCompraFecha(String retCompraFecha) {
        this.retCompraFecha = retCompraFecha;
    }

    public String getRetConcepto() {
        return retConcepto;
    }

    public void setRetConcepto(String retConcepto) {
        this.retConcepto = retConcepto;
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

    public String getRetLlaveCompra() {
        return retLlaveCompra;
    }

    public void setRetLlaveCompra(String retLlaveCompra) {
        this.retLlaveCompra = retLlaveCompra;
    }

    public String getRetLlavecontable() {
        return retLlavecontable;
    }

    public void setRetLlavecontable(String retLlavecontable) {
        this.retLlavecontable = retLlavecontable;
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

    public String getRetSustentotributario() {
        return retSustentotributario;
    }

    public void setRetSustentotributario(String retSustentotributario) {
        this.retSustentotributario = retSustentotributario;
    }

    public String getRetValorRetenidoIr() {
        return retValorRetenidoIr;
    }

    public void setRetValorRetenidoIr(String retValorRetenidoIr) {
        this.retValorRetenidoIr = retValorRetenidoIr;
    }

}
