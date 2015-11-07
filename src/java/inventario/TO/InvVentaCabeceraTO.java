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
public class InvVentaCabeceraTO implements java.io.Serializable{
    private String vtaNumeroAlterno;
    private String vtaDocumentoTipo;
    private String vtaDocumentoNumero;
    private String vtaFecha;
    private String vtaFechaVencimiento;
    private java.math.BigDecimal vtaIvaVigente;
    private String vtaObservaciones;
    private String vtaInformacionAdicional;
    private Boolean vtaPendiente;
    private Boolean vtaRevisado;
    private Boolean vtaAnulado;
    private String vtaFormaPago;
    private java.math.BigDecimal vtaBase0;
    private java.math.BigDecimal vtaBaseImponible;
    private java.math.BigDecimal vtaBaseNoObjeto;
    private java.math.BigDecimal vtaBaseExenta;
    private java.math.BigDecimal vtaDescuentoBase0;
    private java.math.BigDecimal vtaDescuentoBaseImponible;
    private java.math.BigDecimal vtaDescuentoBaseNoObjeto;
    private java.math.BigDecimal vtaDescuentoBaseExenta;
    private java.math.BigDecimal vtaSubtotalBase0;
    private java.math.BigDecimal vtaSubtotalBaseImponible;
    private java.math.BigDecimal vtaSubtotalBaseNoObjeto;
    private java.math.BigDecimal vtaSubtotalBaseExenta;
    
    private java.math.BigDecimal vtaMontoiva;
    private java.math.BigDecimal vtaTotal;
    private String cliCodigo;
    private String secCodigo;
    private String conPeriodo;
    private String conTipo;
    private String conNumero;
    
    private String usuarioInserto;
    private String fechaUsuarioInserto;
    private String comDocumentoTipo;
    private String comDocumentoNumero;
    private java.math.BigDecimal vtaPagado;

    public InvVentaCabeceraTO() {
    }

    public InvVentaCabeceraTO(String vtaNumeroAlterno, String vtaDocumentoTipo, String vtaDocumentoNumero, String vtaFecha, String vtaFechaVencimiento, BigDecimal vtaIvaVigente, String vtaObservaciones, String vtaInformacionAdicional, Boolean vtaPendiente, Boolean vtaRevisado, Boolean vtaAnulado, String vtaFormaPago, BigDecimal vtaBase0, BigDecimal vtaBaseImponible, BigDecimal vtaBaseNoObjeto, BigDecimal vtaBaseExenta, BigDecimal vtaDescuentoBase0, BigDecimal vtaDescuentoBaseImponible, BigDecimal vtaDescuentoBaseNoObjeto, BigDecimal vtaDescuentoBaseExenta, BigDecimal vtaSubtotalBase0, BigDecimal vtaSubtotalBaseImponible, BigDecimal vtaSubtotalBaseNoObjeto, BigDecimal vtaSubtotalBaseExenta, BigDecimal vtaMontoiva, BigDecimal vtaTotal, String cliCodigo, String secCodigo, String conPeriodo, String conTipo, String conNumero, String usuarioInserto, String fechaUsuarioInserto, String comDocumentoTipo, String comDocumentoNumero, BigDecimal vtaPagado) {
        this.vtaNumeroAlterno = vtaNumeroAlterno;
        this.vtaDocumentoTipo = vtaDocumentoTipo;
        this.vtaDocumentoNumero = vtaDocumentoNumero;
        this.vtaFecha = vtaFecha;
        this.vtaFechaVencimiento = vtaFechaVencimiento;
        this.vtaIvaVigente = vtaIvaVigente;
        this.vtaObservaciones = vtaObservaciones;
        this.vtaInformacionAdicional = vtaInformacionAdicional;
        this.vtaPendiente = vtaPendiente;
        this.vtaRevisado = vtaRevisado;
        this.vtaAnulado = vtaAnulado;
        this.vtaFormaPago = vtaFormaPago;
        this.vtaBase0 = vtaBase0;
        this.vtaBaseImponible = vtaBaseImponible;
        this.vtaBaseNoObjeto = vtaBaseNoObjeto;
        this.vtaBaseExenta = vtaBaseExenta;
        this.vtaDescuentoBase0 = vtaDescuentoBase0;
        this.vtaDescuentoBaseImponible = vtaDescuentoBaseImponible;
        this.vtaDescuentoBaseNoObjeto = vtaDescuentoBaseNoObjeto;
        this.vtaDescuentoBaseExenta = vtaDescuentoBaseExenta;
        this.vtaSubtotalBase0 = vtaSubtotalBase0;
        this.vtaSubtotalBaseImponible = vtaSubtotalBaseImponible;
        this.vtaSubtotalBaseNoObjeto = vtaSubtotalBaseNoObjeto;
        this.vtaSubtotalBaseExenta = vtaSubtotalBaseExenta;
        this.vtaMontoiva = vtaMontoiva;
        this.vtaTotal = vtaTotal;
        this.cliCodigo = cliCodigo;
        this.secCodigo = secCodigo;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
        this.usuarioInserto = usuarioInserto;
        this.fechaUsuarioInserto = fechaUsuarioInserto;
        this.comDocumentoTipo = comDocumentoTipo;
        this.comDocumentoNumero = comDocumentoNumero;
        this.vtaPagado = vtaPagado;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getComDocumentoNumero() {
        return comDocumentoNumero;
    }

    public void setComDocumentoNumero(String comDocumentoNumero) {
        this.comDocumentoNumero = comDocumentoNumero;
    }

    public String getComDocumentoTipo() {
        return comDocumentoTipo;
    }

    public void setComDocumentoTipo(String comDocumentoTipo) {
        this.comDocumentoTipo = comDocumentoTipo;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConPeriodo() {
        return conPeriodo;
    }

    public void setConPeriodo(String conPeriodo) {
        this.conPeriodo = conPeriodo;
    }

    public String getConTipo() {
        return conTipo;
    }

    public void setConTipo(String conTipo) {
        this.conTipo = conTipo;
    }

    public String getFechaUsuarioInserto() {
        return fechaUsuarioInserto;
    }

    public void setFechaUsuarioInserto(String fechaUsuarioInserto) {
        this.fechaUsuarioInserto = fechaUsuarioInserto;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getUsuarioInserto() {
        return usuarioInserto;
    }

    public void setUsuarioInserto(String usuarioInserto) {
        this.usuarioInserto = usuarioInserto;
    }

    public Boolean getVtaAnulado() {
        return vtaAnulado;
    }

    public void setVtaAnulado(Boolean vtaAnulado) {
        this.vtaAnulado = vtaAnulado;
    }

    public BigDecimal getVtaBase0() {
        return vtaBase0;
    }

    public void setVtaBase0(BigDecimal vtaBase0) {
        this.vtaBase0 = vtaBase0;
    }

    public BigDecimal getVtaBaseExenta() {
        return vtaBaseExenta;
    }

    public void setVtaBaseExenta(BigDecimal vtaBaseExenta) {
        this.vtaBaseExenta = vtaBaseExenta;
    }

    public BigDecimal getVtaBaseImponible() {
        return vtaBaseImponible;
    }

    public void setVtaBaseImponible(BigDecimal vtaBaseImponible) {
        this.vtaBaseImponible = vtaBaseImponible;
    }

    public BigDecimal getVtaBaseNoObjeto() {
        return vtaBaseNoObjeto;
    }

    public void setVtaBaseNoObjeto(BigDecimal vtaBaseNoObjeto) {
        this.vtaBaseNoObjeto = vtaBaseNoObjeto;
    }

    public BigDecimal getVtaDescuentoBase0() {
        return vtaDescuentoBase0;
    }

    public void setVtaDescuentoBase0(BigDecimal vtaDescuentoBase0) {
        this.vtaDescuentoBase0 = vtaDescuentoBase0;
    }

    public BigDecimal getVtaDescuentoBaseExenta() {
        return vtaDescuentoBaseExenta;
    }

    public void setVtaDescuentoBaseExenta(BigDecimal vtaDescuentoBaseExenta) {
        this.vtaDescuentoBaseExenta = vtaDescuentoBaseExenta;
    }

    public BigDecimal getVtaDescuentoBaseImponible() {
        return vtaDescuentoBaseImponible;
    }

    public void setVtaDescuentoBaseImponible(BigDecimal vtaDescuentoBaseImponible) {
        this.vtaDescuentoBaseImponible = vtaDescuentoBaseImponible;
    }

    public BigDecimal getVtaDescuentoBaseNoObjeto() {
        return vtaDescuentoBaseNoObjeto;
    }

    public void setVtaDescuentoBaseNoObjeto(BigDecimal vtaDescuentoBaseNoObjeto) {
        this.vtaDescuentoBaseNoObjeto = vtaDescuentoBaseNoObjeto;
    }

    public String getVtaDocumentoNumero() {
        return vtaDocumentoNumero;
    }

    public void setVtaDocumentoNumero(String vtaDocumentoNumero) {
        this.vtaDocumentoNumero = vtaDocumentoNumero;
    }

    public String getVtaDocumentoTipo() {
        return vtaDocumentoTipo;
    }

    public void setVtaDocumentoTipo(String vtaDocumentoTipo) {
        this.vtaDocumentoTipo = vtaDocumentoTipo;
    }

    public String getVtaFecha() {
        return vtaFecha;
    }

    public void setVtaFecha(String vtaFecha) {
        this.vtaFecha = vtaFecha;
    }

    public String getVtaFechaVencimiento() {
        return vtaFechaVencimiento;
    }

    public void setVtaFechaVencimiento(String vtaFechaVencimiento) {
        this.vtaFechaVencimiento = vtaFechaVencimiento;
    }

    public String getVtaFormaPago() {
        return vtaFormaPago;
    }

    public void setVtaFormaPago(String vtaFormaPago) {
        this.vtaFormaPago = vtaFormaPago;
    }

    public String getVtaInformacionAdicional() {
        return vtaInformacionAdicional;
    }

    public void setVtaInformacionAdicional(String vtaInformacionAdicional) {
        this.vtaInformacionAdicional = vtaInformacionAdicional;
    }

    public BigDecimal getVtaIvaVigente() {
        return vtaIvaVigente;
    }

    public void setVtaIvaVigente(BigDecimal vtaIvaVigente) {
        this.vtaIvaVigente = vtaIvaVigente;
    }

    public BigDecimal getVtaMontoiva() {
        return vtaMontoiva;
    }

    public void setVtaMontoiva(BigDecimal vtaMontoiva) {
        this.vtaMontoiva = vtaMontoiva;
    }

    public String getVtaNumeroAlterno() {
        return vtaNumeroAlterno;
    }

    public void setVtaNumeroAlterno(String vtaNumeroAlterno) {
        this.vtaNumeroAlterno = vtaNumeroAlterno;
    }

    public String getVtaObservaciones() {
        return vtaObservaciones;
    }

    public void setVtaObservaciones(String vtaObservaciones) {
        this.vtaObservaciones = vtaObservaciones;
    }

    public BigDecimal getVtaPagado() {
        return vtaPagado;
    }

    public void setVtaPagado(BigDecimal vtaPagado) {
        this.vtaPagado = vtaPagado;
    }

    public Boolean getVtaPendiente() {
        return vtaPendiente;
    }

    public void setVtaPendiente(Boolean vtaPendiente) {
        this.vtaPendiente = vtaPendiente;
    }

    public Boolean getVtaRevisado() {
        return vtaRevisado;
    }

    public void setVtaRevisado(Boolean vtaRevisado) {
        this.vtaRevisado = vtaRevisado;
    }

    public BigDecimal getVtaSubtotalBase0() {
        return vtaSubtotalBase0;
    }

    public void setVtaSubtotalBase0(BigDecimal vtaSubtotalBase0) {
        this.vtaSubtotalBase0 = vtaSubtotalBase0;
    }

    public BigDecimal getVtaSubtotalBaseExenta() {
        return vtaSubtotalBaseExenta;
    }

    public void setVtaSubtotalBaseExenta(BigDecimal vtaSubtotalBaseExenta) {
        this.vtaSubtotalBaseExenta = vtaSubtotalBaseExenta;
    }

    public BigDecimal getVtaSubtotalBaseImponible() {
        return vtaSubtotalBaseImponible;
    }

    public void setVtaSubtotalBaseImponible(BigDecimal vtaSubtotalBaseImponible) {
        this.vtaSubtotalBaseImponible = vtaSubtotalBaseImponible;
    }

    public BigDecimal getVtaSubtotalBaseNoObjeto() {
        return vtaSubtotalBaseNoObjeto;
    }

    public void setVtaSubtotalBaseNoObjeto(BigDecimal vtaSubtotalBaseNoObjeto) {
        this.vtaSubtotalBaseNoObjeto = vtaSubtotalBaseNoObjeto;
    }

    public BigDecimal getVtaTotal() {
        return vtaTotal;
    }

    public void setVtaTotal(BigDecimal vtaTotal) {
        this.vtaTotal = vtaTotal;
    }
}
