/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.reporte;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ReporteListadoRetencionesVentas {
    private String desde;
    private String hasta;
    
    //////////DETALLE
    private String venFecha;
    private String venIdentificacion;
    private String venNombre;
    private String venComprobanteTipo;
    private String venComprobanteNumero;
    private java.math.BigDecimal venBaseNoObjetoIva;
    private java.math.BigDecimal venBase0;
    private java.math.BigDecimal venBaseImponible;
    private java.math.BigDecimal venMontoIva;
    private java.math.BigDecimal venValorRetenidoIva;
    private java.math.BigDecimal venValorRetenidoRenta;

    public ReporteListadoRetencionesVentas(){
        
    }
    
    public ReporteListadoRetencionesVentas(String desde, String hasta, String venFecha, String venIdentificacion, String venNombre, String venComprobanteTipo, String venComprobanteNumero, BigDecimal venBaseNoObjetoIva, BigDecimal venBase0, BigDecimal venBaseImponible, BigDecimal venMontoIva, BigDecimal venValorRetenidoIva, BigDecimal venValorRetenidoRenta) {
        this.desde = desde;
        this.hasta = hasta;
        this.venFecha = venFecha;
        this.venIdentificacion = venIdentificacion;
        this.venNombre = venNombre;
        this.venComprobanteTipo = venComprobanteTipo;
        this.venComprobanteNumero = venComprobanteNumero;
        this.venBaseNoObjetoIva = venBaseNoObjetoIva;
        this.venBase0 = venBase0;
        this.venBaseImponible = venBaseImponible;
        this.venMontoIva = venMontoIva;
        this.venValorRetenidoIva = venValorRetenidoIva;
        this.venValorRetenidoRenta = venValorRetenidoRenta;
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

    public BigDecimal getVenBaseNoObjetoIva() {
        return venBaseNoObjetoIva;
    }

    public void setVenBaseNoObjetoIva(BigDecimal venBaseNoObjetoIva) {
        this.venBaseNoObjetoIva = venBaseNoObjetoIva;
    }

    public String getVenComprobanteNumero() {
        return venComprobanteNumero;
    }

    public void setVenComprobanteNumero(String venComprobanteNumero) {
        this.venComprobanteNumero = venComprobanteNumero;
    }

    public String getVenComprobanteTipo() {
        return venComprobanteTipo;
    }

    public void setVenComprobanteTipo(String venComprobanteTipo) {
        this.venComprobanteTipo = venComprobanteTipo;
    }

    public String getVenFecha() {
        return venFecha;
    }

    public void setVenFecha(String venFecha) {
        this.venFecha = venFecha;
    }

    public String getVenIdentificacion() {
        return venIdentificacion;
    }

    public void setVenIdentificacion(String venIdentificacion) {
        this.venIdentificacion = venIdentificacion;
    }

    public BigDecimal getVenMontoIva() {
        return venMontoIva;
    }

    public void setVenMontoIva(BigDecimal venMontoIva) {
        this.venMontoIva = venMontoIva;
    }

    public String getVenNombre() {
        return venNombre;
    }

    public void setVenNombre(String venNombre) {
        this.venNombre = venNombre;
    }

    public BigDecimal getVenValorRetenidoIva() {
        return venValorRetenidoIva;
    }

    public void setVenValorRetenidoIva(BigDecimal venValorRetenidoIva) {
        this.venValorRetenidoIva = venValorRetenidoIva;
    }

    public BigDecimal getVenValorRetenidoRenta() {
        return venValorRetenidoRenta;
    }

    public void setVenValorRetenidoRenta(BigDecimal venValorRetenidoRenta) {
        this.venValorRetenidoRenta = venValorRetenidoRenta;
    }
}
