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
public class InvVentasTO implements java.io.Serializable {
    private String vtaEmpresa;
    private String vtaPeriodo;
    private String vtaMotivo;
    private String vtaNumero;
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
    private java.math.BigDecimal vtaRecargoBase0;
    private java.math.BigDecimal vtaRecargoBaseImponible;
//    private java.math.BigDecimal vtaDescuentoGeneralBase0;
//    private java.math.BigDecimal vtaDescuentoGeneralBaseImponible;
    
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
    private java.math.BigDecimal vtaMontoIva;
    private java.math.BigDecimal vtaTotal;
    private java.math.BigDecimal vtaPagado;
    private String cliEmpresa;
    private String cliCodigo;
    private String bodEmpresa;
    private String bodCodigo;
    private String secEmpresa;
    private String secCodigo;
    private String ctaEmpresa;
    private String ctaCodigo;
    private String conEmpresa;
    private String conPeriodo;
    private String conTipo;
    private String conNumero;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public InvVentasTO() {
    }

    public InvVentasTO(String vtaEmpresa, String vtaPeriodo, String vtaMotivo, String vtaNumero, String vtaNumeroAlterno, String vtaDocumentoTipo, String vtaDocumentoNumero, String vtaFecha, String vtaFechaVencimiento, BigDecimal vtaIvaVigente, String vtaObservaciones, String vtaInformacionAdicional, Boolean vtaPendiente, Boolean vtaRevisado, Boolean vtaAnulado, String vtaFormaPago, BigDecimal vtaRecargoBase0, BigDecimal vtaRecargoBaseImponible, BigDecimal vtaBase0, BigDecimal vtaBaseImponible, BigDecimal vtaBaseNoObjeto, BigDecimal vtaBaseExenta, BigDecimal vtaDescuentoBase0, BigDecimal vtaDescuentoBaseImponible, BigDecimal vtaDescuentoBaseNoObjeto, BigDecimal vtaDescuentoBaseExenta, BigDecimal vtaSubtotalBase0, BigDecimal vtaSubtotalBaseImponible, BigDecimal vtaSubtotalBaseNoObjeto, BigDecimal vtaSubtotalBaseExenta, BigDecimal vtaMontoIva, BigDecimal vtaTotal, BigDecimal vtaPagado, String cliEmpresa, String cliCodigo, String bodEmpresa, String bodCodigo, String secEmpresa, String secCodigo, String ctaEmpresa, String ctaCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.vtaEmpresa = vtaEmpresa;
        this.vtaPeriodo = vtaPeriodo;
        this.vtaMotivo = vtaMotivo;
        this.vtaNumero = vtaNumero;
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
        this.vtaRecargoBase0 = vtaRecargoBase0;
        this.vtaRecargoBaseImponible = vtaRecargoBaseImponible;
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
        this.vtaMontoIva = vtaMontoIva;
        this.vtaTotal = vtaTotal;
        this.vtaPagado = vtaPagado;
        this.cliEmpresa = cliEmpresa;
        this.cliCodigo = cliCodigo;
        this.bodEmpresa = bodEmpresa;
        this.bodCodigo = bodCodigo;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.ctaEmpresa = ctaEmpresa;
        this.ctaCodigo = ctaCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public BigDecimal getVtaRecargoBase0() {
        return vtaRecargoBase0;
    }

    public void setVtaRecargoBase0(BigDecimal vtaRecargoBase0) {
        this.vtaRecargoBase0 = vtaRecargoBase0;
    }

    public BigDecimal getVtaRecargoBaseImponible() {
        return vtaRecargoBaseImponible;
    }

    public void setVtaRecargoBaseImponible(BigDecimal vtaRecargoBaseImponible) {
        this.vtaRecargoBaseImponible = vtaRecargoBaseImponible;
    }

    public String getConEmpresa() {
        return conEmpresa;
    }

    public void setConEmpresa(String conEmpresa) {
        this.conEmpresa = conEmpresa;
    }
    
    public String getBodCodigo() {
        return bodCodigo;
    }

    public void setBodCodigo(String bodCodigo) {
        this.bodCodigo = bodCodigo;
    }

    public String getBodEmpresa() {
        return bodEmpresa;
    }

    public void setBodEmpresa(String bodEmpresa) {
        this.bodEmpresa = bodEmpresa;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliEmpresa() {
        return cliEmpresa;
    }

    public void setCliEmpresa(String cliEmpresa) {
        this.cliEmpresa = cliEmpresa;
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

    public String getCtaCodigo() {
        return ctaCodigo;
    }

    public void setCtaCodigo(String ctaCodigo) {
        this.ctaCodigo = ctaCodigo;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getSecEmpresa() {
        return secEmpresa;
    }

    public void setSecEmpresa(String secEmpresa) {
        this.secEmpresa = secEmpresa;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
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

    public String getVtaEmpresa() {
        return vtaEmpresa;
    }

    public void setVtaEmpresa(String vtaEmpresa) {
        this.vtaEmpresa = vtaEmpresa;
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

    public BigDecimal getVtaMontoIva() {
        return vtaMontoIva;
    }

    public void setVtaMontoIva(BigDecimal vtaMontoIva) {
        this.vtaMontoIva = vtaMontoIva;
    }

    public String getVtaMotivo() {
        return vtaMotivo;
    }

    public void setVtaMotivo(String vtaMotivo) {
        this.vtaMotivo = vtaMotivo;
    }

    public String getVtaNumero() {
        return vtaNumero;
    }

    public void setVtaNumero(String vtaNumero) {
        this.vtaNumero = vtaNumero;
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

    public String getVtaPeriodo() {
        return vtaPeriodo;
    }

    public void setVtaPeriodo(String vtaPeriodo) {
        this.vtaPeriodo = vtaPeriodo;
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


    @Override
    public String toString(){
        return this.vtaEmpresa + " " + this.vtaPeriodo + " " + this.vtaMotivo + " " +
                this.vtaNumero + " " + this.vtaNumeroAlterno + " " + this.vtaDocumentoTipo + " " +
                this.vtaDocumentoNumero + " " + this.vtaFecha + " " + this.vtaFechaVencimiento + " " +
                this.vtaIvaVigente + " " + this.vtaObservaciones + " " + this.vtaPendiente + " " +
                this.vtaRevisado + " " + this.vtaAnulado + " " + this.vtaFormaPago + " " +
                this.vtaBase0 + " " + this.vtaBaseImponible + " " + this.vtaDescuentoBase0 + " " + this.vtaMontoIva + " " +
                this.vtaTotal + " " + this.cliEmpresa + " " + this.cliCodigo + " " + this.secEmpresa + " " +
                this.secCodigo + " " + this.conEmpresa + " " + this.conPeriodo + " " + this.conTipo + " " +
                this.conNumero + " " + this.usrEmpresa + " " + this.usrCodigo + " " + this.usrFechaInserta;
    }
}
