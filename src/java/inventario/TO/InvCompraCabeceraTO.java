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
public class InvCompraCabeceraTO implements java.io.Serializable{
    private String compNumeroAlterno;
    private String compDocumentoTipo;
    private String compDocumentoNumero;
    private String compfecha;
    private String compFechaVencimiento;
    private java.math.BigDecimal compIvaVigente;
    private String compObservaciones;
    private Boolean compElectronica;
    private Boolean compActivoFijo;
    private Boolean compImportacion;
    private Boolean compPendiente;
    private Boolean compRevisado;
    private Boolean compAnulado;
    private String compFormaPago;
    private java.math.BigDecimal compBase0;
    private java.math.BigDecimal compBaseimponible;
    private java.math.BigDecimal compBaseNoObjeto;
    private java.math.BigDecimal compBaseExenta;
    private java.math.BigDecimal compMontoiva;
    private java.math.BigDecimal compOtrosImpuestos;
    private java.math.BigDecimal compTotal;
    private java.math.BigDecimal compValorretenido;
    private java.math.BigDecimal compSaldo;
    private String provCodigo;
    private String secCodigo;
    private String conPeriodo;
    private String conTipo;
    private String conNumero;
    private String usuarioInserto;
    private String fechaUsuarioInserto;
    private boolean retencionAsumida;
    private String documentoFormaPago;
    private String comentarioAnulado;

    public InvCompraCabeceraTO() {
    }

    public InvCompraCabeceraTO(String compNumeroAlterno, String compDocumentoTipo, String compDocumentoNumero, String compfecha, String compFechaVencimiento, BigDecimal compIvaVigente, String compObservaciones, Boolean compElectronica, Boolean compActivoFijo, Boolean compImportacion, Boolean compPendiente, Boolean compRevisado, Boolean compAnulado, String compFormaPago, BigDecimal compBase0, BigDecimal compBaseimponible, BigDecimal compBaseNoObjeto, BigDecimal compBaseExenta, BigDecimal compMontoiva, BigDecimal compOtrosImpuestos, BigDecimal compTotal, BigDecimal compValorretenido, BigDecimal compSaldo, String provCodigo, String secCodigo, String conPeriodo, String conTipo, String conNumero, String usuarioInserto, String fechaUsuarioInserto, boolean retencionAsumida, String documentoFormaPago, String comentarioAnulado) {
        this.compNumeroAlterno = compNumeroAlterno;
        this.compDocumentoTipo = compDocumentoTipo;
        this.compDocumentoNumero = compDocumentoNumero;
        this.compfecha = compfecha;
        this.compFechaVencimiento = compFechaVencimiento;
        this.compIvaVigente = compIvaVigente;
        this.compObservaciones = compObservaciones;
        this.compElectronica = compElectronica;
        this.compActivoFijo = compActivoFijo;
        this.compImportacion = compImportacion;
        this.compPendiente = compPendiente;
        this.compRevisado = compRevisado;
        this.compAnulado = compAnulado;
        this.compFormaPago = compFormaPago;
        this.compBase0 = compBase0;
        this.compBaseimponible = compBaseimponible;
        this.compBaseNoObjeto = compBaseNoObjeto;
        this.compBaseExenta = compBaseExenta;
        this.compMontoiva = compMontoiva;
        this.compOtrosImpuestos = compOtrosImpuestos;
        this.compTotal = compTotal;
        this.compValorretenido = compValorretenido;
        this.compSaldo = compSaldo;
        this.provCodigo = provCodigo;
        this.secCodigo = secCodigo;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
        this.usuarioInserto = usuarioInserto;
        this.fechaUsuarioInserto = fechaUsuarioInserto;
        this.retencionAsumida = retencionAsumida;
        this.documentoFormaPago = documentoFormaPago;
        this.comentarioAnulado = comentarioAnulado;
    }

    public BigDecimal getCompBaseExenta() {
        return compBaseExenta;
    }

    public void setCompBaseExenta(BigDecimal compBaseExenta) {
        this.compBaseExenta = compBaseExenta;
    }

    public BigDecimal getCompBaseNoObjeto() {
        return compBaseNoObjeto;
    }

    public void setCompBaseNoObjeto(BigDecimal compBaseNoObjeto) {
        this.compBaseNoObjeto = compBaseNoObjeto;
    }

    public Boolean getCompImportacion() {
        return compImportacion;
    }

    public void setCompImportacion(Boolean compImportacion) {
        this.compImportacion = compImportacion;
    }

    public Boolean getCompElectronica() {
        return compElectronica;
    }

    public void setCompElectronica(Boolean compElectronica) {
        this.compElectronica = compElectronica;
    }

    public String getComentarioAnulado() {
        return comentarioAnulado;
    }

    public void setComentarioAnulado(String comentarioAnulado) {
        this.comentarioAnulado = comentarioAnulado;
    }

    public Boolean getCompActivoFijo() {
        return compActivoFijo;
    }

    public void setCompActivoFijo(Boolean compActivoFijo) {
        this.compActivoFijo = compActivoFijo;
    }

    public Boolean getCompAnulado() {
        return compAnulado;
    }

    public void setCompAnulado(Boolean compAnulado) {
        this.compAnulado = compAnulado;
    }

    public BigDecimal getCompBase0() {
        return compBase0;
    }

    public void setCompBase0(BigDecimal compBase0) {
        this.compBase0 = compBase0;
    }

    public BigDecimal getCompBaseimponible() {
        return compBaseimponible;
    }

    public void setCompBaseimponible(BigDecimal compBaseimponible) {
        this.compBaseimponible = compBaseimponible;
    }

    public String getCompDocumentoNumero() {
        return compDocumentoNumero;
    }

    public void setCompDocumentoNumero(String compDocumentoNumero) {
        this.compDocumentoNumero = compDocumentoNumero;
    }

    public String getCompDocumentoTipo() {
        return compDocumentoTipo;
    }

    public void setCompDocumentoTipo(String compDocumentoTipo) {
        this.compDocumentoTipo = compDocumentoTipo;
    }

    public String getCompFechaVencimiento() {
        return compFechaVencimiento;
    }

    public void setCompFechaVencimiento(String compFechaVencimiento) {
        this.compFechaVencimiento = compFechaVencimiento;
    }

    public String getCompFormaPago() {
        return compFormaPago;
    }

    public void setCompFormaPago(String compFormaPago) {
        this.compFormaPago = compFormaPago;
    }

    public BigDecimal getCompIvaVigente() {
        return compIvaVigente;
    }

    public void setCompIvaVigente(BigDecimal compIvaVigente) {
        this.compIvaVigente = compIvaVigente;
    }

    public BigDecimal getCompMontoiva() {
        return compMontoiva;
    }

    public void setCompMontoiva(BigDecimal compMontoiva) {
        this.compMontoiva = compMontoiva;
    }

    public String getCompNumeroAlterno() {
        return compNumeroAlterno;
    }

    public void setCompNumeroAlterno(String compNumeroAlterno) {
        this.compNumeroAlterno = compNumeroAlterno;
    }

    public String getCompObservaciones() {
        return compObservaciones;
    }

    public void setCompObservaciones(String compObservaciones) {
        this.compObservaciones = compObservaciones;
    }

    public BigDecimal getCompOtrosImpuestos() {
        return compOtrosImpuestos;
    }

    public void setCompOtrosImpuestos(BigDecimal compOtrosImpuestos) {
        this.compOtrosImpuestos = compOtrosImpuestos;
    }

    public Boolean getCompPendiente() {
        return compPendiente;
    }

    public void setCompPendiente(Boolean compPendiente) {
        this.compPendiente = compPendiente;
    }

    public Boolean getCompRevisado() {
        return compRevisado;
    }

    public void setCompRevisado(Boolean compRevisado) {
        this.compRevisado = compRevisado;
    }

    public BigDecimal getCompSaldo() {
        return compSaldo;
    }

    public void setCompSaldo(BigDecimal compSaldo) {
        this.compSaldo = compSaldo;
    }

    public BigDecimal getCompTotal() {
        return compTotal;
    }

    public void setCompTotal(BigDecimal compTotal) {
        this.compTotal = compTotal;
    }

    public BigDecimal getCompValorretenido() {
        return compValorretenido;
    }

    public void setCompValorretenido(BigDecimal compValorretenido) {
        this.compValorretenido = compValorretenido;
    }

    public String getCompfecha() {
        return compfecha;
    }

    public void setCompfecha(String compfecha) {
        this.compfecha = compfecha;
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

    public String getDocumentoFormaPago() {
        return documentoFormaPago;
    }

    public void setDocumentoFormaPago(String documentoFormaPago) {
        this.documentoFormaPago = documentoFormaPago;
    }

    public String getFechaUsuarioInserto() {
        return fechaUsuarioInserto;
    }

    public void setFechaUsuarioInserto(String fechaUsuarioInserto) {
        this.fechaUsuarioInserto = fechaUsuarioInserto;
    }

    public String getProvCodigo() {
        return provCodigo;
    }

    public void setProvCodigo(String provCodigo) {
        this.provCodigo = provCodigo;
    }

    public boolean isRetencionAsumida() {
        return retencionAsumida;
    }

    public void setRetencionAsumida(boolean retencionAsumida) {
        this.retencionAsumida = retencionAsumida;
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
    
    @Override
    public String toString(){
        return this.compNumeroAlterno + " " + this.compDocumentoTipo + " " + this.compDocumentoNumero +
                " " + this.compfecha + " " + this.compFechaVencimiento + " " + this.compIvaVigente +
                " " + this.compObservaciones + " " + this.compPendiente + " " + this.compRevisado +
                " " + this.compAnulado + " " + this.compFormaPago + " " + this.compBase0 + " " + this.compBaseimponible +
                " " + this.compMontoiva + " " + this.compTotal + " " + this.compValorretenido +
                " " + this.compSaldo + " " + this.provCodigo + " " + this.secCodigo + " " + this.conPeriodo + 
                " " + this.conTipo + " " + this.conNumero+ " " + this.comentarioAnulado;
    }
}
