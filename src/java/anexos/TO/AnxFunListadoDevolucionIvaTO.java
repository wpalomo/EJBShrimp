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
public class AnxFunListadoDevolucionIvaTO implements java.io.Serializable{
    private String actSustentoTributario;
    private String actFecha;
    private String actProveedorNombre;
    private Character actProveedorIdTipo;
    private String actProveedorIdNumero;
    private String actDocumentoTipo;
    private String actDocumentoNumero;
    private String actAutorizacion;
    private java.math.BigDecimal actBase0;
    private java.math.BigDecimal actBaseImponible;
    private java.math.BigDecimal actIva;
    private java.math.BigDecimal actTotal;
    private String actSecuencia;

    public AnxFunListadoDevolucionIvaTO() {
    }

    public AnxFunListadoDevolucionIvaTO(String actSustentoTributario, String actFecha, String actProveedorNombre, Character actProveedorIdTipo, String actProveedorIdNumero, String actDocumentoTipo, String actDocumentoNumero, String actAutorizacion, BigDecimal actBase0, BigDecimal actBaseImponible, BigDecimal actIva, BigDecimal actTotal, String actSecuencia) {
        this.actSustentoTributario = actSustentoTributario;
        this.actFecha = actFecha;
        this.actProveedorNombre = actProveedorNombre;
        this.actProveedorIdTipo = actProveedorIdTipo;
        this.actProveedorIdNumero = actProveedorIdNumero;
        this.actDocumentoTipo = actDocumentoTipo;
        this.actDocumentoNumero = actDocumentoNumero;
        this.actAutorizacion = actAutorizacion;
        this.actBase0 = actBase0;
        this.actBaseImponible = actBaseImponible;
        this.actIva = actIva;
        this.actTotal = actTotal;
        this.actSecuencia = actSecuencia;
    }

    public String getActAutorizacion() {
        return actAutorizacion;
    }

    public void setActAutorizacion(String actAutorizacion) {
        this.actAutorizacion = actAutorizacion;
    }

    public BigDecimal getActBase0() {
        return actBase0;
    }

    public void setActBase0(BigDecimal actBase0) {
        this.actBase0 = actBase0;
    }

    public BigDecimal getActBaseImponible() {
        return actBaseImponible;
    }

    public void setActBaseImponible(BigDecimal actBaseImponible) {
        this.actBaseImponible = actBaseImponible;
    }

    public String getActDocumentoNumero() {
        return actDocumentoNumero;
    }

    public void setActDocumentoNumero(String actDocumentoNumero) {
        this.actDocumentoNumero = actDocumentoNumero;
    }

    public String getActDocumentoTipo() {
        return actDocumentoTipo;
    }

    public void setActDocumentoTipo(String actDocumentoTipo) {
        this.actDocumentoTipo = actDocumentoTipo;
    }

    public String getActFecha() {
        return actFecha;
    }

    public void setActFecha(String actFecha) {
        this.actFecha = actFecha;
    }

    public BigDecimal getActIva() {
        return actIva;
    }

    public void setActIva(BigDecimal actIva) {
        this.actIva = actIva;
    }

    public String getActProveedorIdNumero() {
        return actProveedorIdNumero;
    }

    public void setActProveedorIdNumero(String actProveedorIdNumero) {
        this.actProveedorIdNumero = actProveedorIdNumero;
    }

    public Character getActProveedorIdTipo() {
        return actProveedorIdTipo;
    }

    public void setActProveedorIdTipo(Character actProveedorIdTipo) {
        this.actProveedorIdTipo = actProveedorIdTipo;
    }

    public String getActProveedorNombre() {
        return actProveedorNombre;
    }

    public void setActProveedorNombre(String actProveedorNombre) {
        this.actProveedorNombre = actProveedorNombre;
    }

    public String getActSecuencia() {
        return actSecuencia;
    }

    public void setActSecuencia(String actSecuencia) {
        this.actSecuencia = actSecuencia;
    }

    public String getActSustentoTributario() {
        return actSustentoTributario;
    }

    public void setActSustentoTributario(String actSustentoTributario) {
        this.actSustentoTributario = actSustentoTributario;
    }

    public BigDecimal getActTotal() {
        return actTotal;
    }

    public void setActTotal(BigDecimal actTotal) {
        this.actTotal = actTotal;
    }
    
}
