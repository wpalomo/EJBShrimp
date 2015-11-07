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
public class ReporteListadoVentas {
    private String desde;
    private String hasta;
    private String motivo;
    private String cliente;
    private String tipoDocumento;
    
    
    /////////////DETALLE
    private String vtaNumeroSistema;
    private String vtaFecha;
    private String vtaCliente;
    private String vtaDocumentoNumero;
    private java.math.BigDecimal vtaBase0;
    private java.math.BigDecimal vtaBaseImponible;
    private java.math.BigDecimal vtaMontoIva;
    private java.math.BigDecimal vtaTotal;
    private String vtaFormaPago;
    private String vtaObservaciones;
    private Boolean vtaPendiente;
    private Boolean vtaAnulado;

    public ReporteListadoVentas() {
    }

    public ReporteListadoVentas(String desde, String hasta, String motivo, String cliente, String tipoDocumento, String vtaNumeroSistema, String vtaFecha, String vtaCliente, String vtaDocumentoNumero, BigDecimal vtaBase0, BigDecimal vtaBaseImponible, BigDecimal vtaMontoIva, BigDecimal vtaTotal, String vtaFormaPago, String vtaObservaciones, Boolean vtaPendiente, Boolean vtaAnulado) {
        this.desde = desde;
        this.hasta = hasta;
        this.motivo = motivo;
        this.cliente = cliente;
        this.tipoDocumento = tipoDocumento;
        this.vtaNumeroSistema = vtaNumeroSistema;
        this.vtaFecha = vtaFecha;
        this.vtaCliente = vtaCliente;
        this.vtaDocumentoNumero = vtaDocumentoNumero;
        this.vtaBase0 = vtaBase0;
        this.vtaBaseImponible = vtaBaseImponible;
        this.vtaMontoIva = vtaMontoIva;
        this.vtaTotal = vtaTotal;
        this.vtaFormaPago = vtaFormaPago;
        this.vtaObservaciones = vtaObservaciones;
        this.vtaPendiente = vtaPendiente;
        this.vtaAnulado = vtaAnulado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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

    public BigDecimal getVtaBaseImponible() {
        return vtaBaseImponible;
    }

    public void setVtaBaseImponible(BigDecimal vtaBaseImponible) {
        this.vtaBaseImponible = vtaBaseImponible;
    }

    public String getVtaCliente() {
        return vtaCliente;
    }

    public void setVtaCliente(String vtaCliente) {
        this.vtaCliente = vtaCliente;
    }

    public String getVtaDocumentoNumero() {
        return vtaDocumentoNumero;
    }

    public void setVtaDocumentoNumero(String vtaDocumentoNumero) {
        this.vtaDocumentoNumero = vtaDocumentoNumero;
    }

    public String getVtaFecha() {
        return vtaFecha;
    }

    public void setVtaFecha(String vtaFecha) {
        this.vtaFecha = vtaFecha;
    }

    public String getVtaFormaPago() {
        return vtaFormaPago;
    }

    public void setVtaFormaPago(String vtaFormaPago) {
        this.vtaFormaPago = vtaFormaPago;
    }

    public BigDecimal getVtaMontoIva() {
        return vtaMontoIva;
    }

    public void setVtaMontoIva(BigDecimal vtaMontoIva) {
        this.vtaMontoIva = vtaMontoIva;
    }

    public String getVtaNumeroSistema() {
        return vtaNumeroSistema;
    }

    public void setVtaNumeroSistema(String vtaNumeroSistema) {
        this.vtaNumeroSistema = vtaNumeroSistema;
    }

    public String getVtaObservaciones() {
        return vtaObservaciones;
    }

    public void setVtaObservaciones(String vtaObservaciones) {
        this.vtaObservaciones = vtaObservaciones;
    }

    public Boolean getVtaPendiente() {
        return vtaPendiente;
    }

    public void setVtaPendiente(Boolean vtaPendiente) {
        this.vtaPendiente = vtaPendiente;
    }

    public BigDecimal getVtaTotal() {
        return vtaTotal;
    }

    public void setVtaTotal(BigDecimal vtaTotal) {
        this.vtaTotal = vtaTotal;
    }
}
