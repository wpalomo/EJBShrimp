/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

import java.math.BigDecimal;

/**
 *
 * @author misayo
 */
public class AnxListaConsolidadoRetencionesVentasTO implements java.io.Serializable{
    private String rvcTransaccion;
    private String rvcIdentificacion;
    private String rvcRelacionado;
    private String rvcComprobanteTipo;
    private Integer rvcNumeroRetenciones;
    private BigDecimal rvcBaseNoObjetoIva;
    private BigDecimal rvcBase0;
    private BigDecimal venBaseImponible;
    private BigDecimal venMontoIva;
    private BigDecimal venMontoIce;
    private BigDecimal venValorRetenidoIva;
    private BigDecimal venValorRetenidoRenta;

    public AnxListaConsolidadoRetencionesVentasTO() {
    }

    public AnxListaConsolidadoRetencionesVentasTO(String rvcTransaccion, String rvcIdentificacion, String rvcRelacionado, String rvcComprobanteTipo, Integer rvcNumeroRetenciones, BigDecimal rvcBaseNoObjetoIva, BigDecimal rvcBase0, BigDecimal venBaseImponible, BigDecimal venMontoIva, BigDecimal venMontoIce, BigDecimal venValorRetenidoIva, BigDecimal venValorRetenidoRenta) {
        this.rvcTransaccion = rvcTransaccion;
        this.rvcIdentificacion = rvcIdentificacion;
        this.rvcRelacionado = rvcRelacionado;
        this.rvcComprobanteTipo = rvcComprobanteTipo;
        this.rvcNumeroRetenciones = rvcNumeroRetenciones;
        this.rvcBaseNoObjetoIva = rvcBaseNoObjetoIva;
        this.rvcBase0 = rvcBase0;
        this.venBaseImponible = venBaseImponible;
        this.venMontoIva = venMontoIva;
        this.venMontoIce = venMontoIce;
        this.venValorRetenidoIva = venValorRetenidoIva;
        this.venValorRetenidoRenta = venValorRetenidoRenta;
    }

    public String getRvcRelacionado() {
        return rvcRelacionado;
    }

    public void setRvcRelacionado(String rvcRelacionado) {
        this.rvcRelacionado = rvcRelacionado;
    }

    public BigDecimal getVenMontoIce() {
        return venMontoIce;
    }

    public void setVenMontoIce(BigDecimal venMontoIce) {
        this.venMontoIce = venMontoIce;
    }

    public BigDecimal getRvcBase0() {
        return rvcBase0;
    }

    public void setRvcBase0(BigDecimal rvcBase0) {
        this.rvcBase0 = rvcBase0;
    }

    public BigDecimal getRvcBaseNoObjetoIva() {
        return rvcBaseNoObjetoIva;
    }

    public void setRvcBaseNoObjetoIva(BigDecimal rvcBaseNoObjetoIva) {
        this.rvcBaseNoObjetoIva = rvcBaseNoObjetoIva;
    }

    public String getRvcComprobanteTipo() {
        return rvcComprobanteTipo;
    }

    public void setRvcComprobanteTipo(String rvcComprobanteTipo) {
        this.rvcComprobanteTipo = rvcComprobanteTipo;
    }

    public String getRvcIdentificacion() {
        return rvcIdentificacion;
    }

    public void setRvcIdentificacion(String rvcIdentificacion) {
        this.rvcIdentificacion = rvcIdentificacion;
    }

    public Integer getRvcNumeroRetenciones() {
        return rvcNumeroRetenciones;
    }

    public void setRvcNumeroRetenciones(Integer rvcNumeroRetenciones) {
        this.rvcNumeroRetenciones = rvcNumeroRetenciones;
    }

    public String getRvcTransaccion() {
        return rvcTransaccion;
    }

    public void setRvcTransaccion(String rvcTransaccion) {
        this.rvcTransaccion = rvcTransaccion;
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
    
}
