/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class AnxListadoRetencionesVentasTO implements java.io.Serializable{
    private String venFecha;
    private String venIdentificacion;
    private String venNombre;
    private String venComprobanteTipo;
    private String venComprobanteNumero;
    private BigDecimal venBaseNoObjetoIva;
    private BigDecimal venBase0;
    private BigDecimal venBaseImponible;
    private BigDecimal venMontoIva;
    private BigDecimal venValorRetenidoIva;
    private BigDecimal venValorRetenidoRenta;
    private String venRetencion;

    public AnxListadoRetencionesVentasTO() {
    }

    public AnxListadoRetencionesVentasTO(String venFecha, String venIdentificacion, String venNombre, String venComprobanteTipo, String venComprobanteNumero, BigDecimal venBaseNoObjetoIva, BigDecimal venBase0, BigDecimal venBaseImponible, BigDecimal venMontoIva, BigDecimal venValorRetenidoIva, BigDecimal venValorRetenidoRenta, String venRetencion) {
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
        this.venRetencion = venRetencion;
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

    public String getVenNombre() {
        return venNombre;
    }

    public void setVenNombre(String venNombre) {
        this.venNombre = venNombre;
    }

    public String getVenComprobanteTipo() {
        return venComprobanteTipo;
    }

    public void setVenComprobanteTipo(String venComprobanteTipo) {
        this.venComprobanteTipo = venComprobanteTipo;
    }

    public String getVenComprobanteNumero() {
        return venComprobanteNumero;
    }

    public void setVenComprobanteNumero(String venComprobanteNumero) {
        this.venComprobanteNumero = venComprobanteNumero;
    }

    public BigDecimal getVenBaseNoObjetoIva() {
        return venBaseNoObjetoIva;
    }

    public void setVenBaseNoObjetoIva(BigDecimal venBaseNoObjetoIva) {
        this.venBaseNoObjetoIva = venBaseNoObjetoIva;
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

    public BigDecimal getVenMontoIva() {
        return venMontoIva;
    }

    public void setVenMontoIva(BigDecimal venMontoIva) {
        this.venMontoIva = venMontoIva;
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

    public String getVenRetencion() {
        return venRetencion;
    }

    public void setVenRetencion(String venRetencion) {
        this.venRetencion = venRetencion;
    }
}
