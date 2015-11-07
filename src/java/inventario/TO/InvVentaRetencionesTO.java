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
public class InvVentaRetencionesTO implements java.io.Serializable{
    
  
    private String cliCodigo;//
    private String cliNombre;//
    private String cliCedula;//  
    private String cliDireccion;
    private String cliTelefono;
   
    
    private String venEmpresa;
    private String venPeriodo;
    private String venMotivo;
    private String venNumero;
    private Boolean vtaPendiente;//
    private Boolean vtaRevisado;//
    private Boolean vtaAnulado;//
    //-------private Boolean venContabilizado;//
    
    private String vtaDocumentoNumero;//
    private String vtaFecha;//
    private String vtaFechaVencimiento;
    
    private java.math.BigDecimal venBase0;//
    private java.math.BigDecimal venBaseImponible;//
    //****private java.math.BigDecimal venBaseNoObjetoIva;//
    private java.math.BigDecimal venMontoIva;//
    //private java.math.BigDecimal venValorRetenidoIva;//
    private java.math.BigDecimal venValorRetenidoRenta;//

    public InvVentaRetencionesTO() {
    }

    public InvVentaRetencionesTO(String cliCodigo, String cliNombre, String cliCedula, String cliDireccion, String cliTelefono, String venEmpresa, String venPeriodo, String venMotivo, String venNumero, Boolean vtaPendiente, Boolean vtaRevisado, Boolean vtaAnulado, String vtaDocumentoNumero, String vtaFecha, String vtaFechaVencimiento, BigDecimal venBase0, BigDecimal venBaseImponible, BigDecimal venMontoIva, BigDecimal venValorRetenidoRenta) {
        this.cliCodigo = cliCodigo;
        this.cliNombre = cliNombre;
        this.cliCedula = cliCedula;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
        this.venEmpresa = venEmpresa;
        this.venPeriodo = venPeriodo;
        this.venMotivo = venMotivo;
        this.venNumero = venNumero;
        this.vtaPendiente = vtaPendiente;
        this.vtaRevisado = vtaRevisado;
        this.vtaAnulado = vtaAnulado;
        this.vtaDocumentoNumero = vtaDocumentoNumero;
        this.vtaFecha = vtaFecha;
        this.vtaFechaVencimiento = vtaFechaVencimiento;
        this.venBase0 = venBase0;
        this.venBaseImponible = venBaseImponible;
        this.venMontoIva = venMontoIva;
        this.venValorRetenidoRenta = venValorRetenidoRenta;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

   

    public String getCliCedula() {
        return cliCedula;
    }

    public void setCliCedula(String cliCedula) {
        this.cliCedula = cliCedula;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public BigDecimal getVenBase0() {
        return venBase0;
    }

    public void setVenBase0(BigDecimal venBase0) {
        this.venBase0 = venBase0;
    }

    public BigDecimal getVenBaseImponible() {
        return venBaseImponible;
    }

    public void setVenBaseImponible(BigDecimal venBaseImponible) {
        this.venBaseImponible = venBaseImponible;
    }

    public String getVenEmpresa() {
        return venEmpresa;
    }

    public void setVenEmpresa(String venEmpresa) {
        this.venEmpresa = venEmpresa;
    }

    public BigDecimal getVenMontoIva() {
        return venMontoIva;
    }

    public void setVenMontoIva(BigDecimal venMontoIva) {
        this.venMontoIva = venMontoIva;
    }

    public String getVenMotivo() {
        return venMotivo;
    }

    public void setVenMotivo(String venMotivo) {
        this.venMotivo = venMotivo;
    }

    public String getVenNumero() {
        return venNumero;
    }

    public void setVenNumero(String venNumero) {
        this.venNumero = venNumero;
    }

    public String getVenPeriodo() {
        return venPeriodo;
    }

    public void setVenPeriodo(String venPeriodo) {
        this.venPeriodo = venPeriodo;
    }

    public BigDecimal getVenValorRetenidoRenta() {
        return venValorRetenidoRenta;
    }

    public void setVenValorRetenidoRenta(BigDecimal venValorRetenidoRenta) {
        this.venValorRetenidoRenta = venValorRetenidoRenta;
    }

    public Boolean getVtaAnulado() {
        return vtaAnulado;
    }

    public void setVtaAnulado(Boolean vtaAnulado) {
        this.vtaAnulado = vtaAnulado;
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

    public String getVtaFechaVencimiento() {
        return vtaFechaVencimiento;
    }

    public void setVtaFechaVencimiento(String vtaFechaVencimiento) {
        this.vtaFechaVencimiento = vtaFechaVencimiento;
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

   
    
    
    
    
    /*
    @Override
    public String toString(){
        return this.vtaNumeroAlterno + " " + this.vtaDocumentoTipo + " " + this.vtaDocumentoNumero +
                " " + this.vtaFecha + " " + this.vtaFechaVencimiento + " " + this.vtaIvaVigente +
                " " + this.vtaObservaciones + " " + this.vtaPendiente + " " + this.vtaRevisado +
                " " + this.vtaAnulado + " " + this.vtaFormaPago + " " + this.vtaBase0 + " " + this.vtaBaseimponible +
                " " + this.vtaDescuentoBase0 + " " + this.vtaMontoiva + " " + this.vtaTotal + " " + this.cliCodigo +
                " " + this.secCodigo  + " " + this.conPeriodo  + " " + this.conTipo  + " " + this.conNumero + " " + 
                this.comDocumentoTipo + " " + this.comDocumentoNumero;
    }*/
}
