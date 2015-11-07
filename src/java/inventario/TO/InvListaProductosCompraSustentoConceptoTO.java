/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

import java.math.BigDecimal;



/**
 *
 * @author Carlos
 */
public class InvListaProductosCompraSustentoConceptoTO implements java.io.Serializable{
    
   
    private String proCodigoPrincipal;
    private java.math.BigDecimal subtotal;
    private String conCodigo;
    private String susCodigo;
    private java.math.BigDecimal base0;
    private java.math.BigDecimal baseImponible;
    private java.math.BigDecimal detPorcentaje;
    private java.math.BigDecimal detValorRetenido;
    private java.math.BigDecimal detBaseNoObjetoIva;

    public InvListaProductosCompraSustentoConceptoTO() {
    }

    public InvListaProductosCompraSustentoConceptoTO(String proCodigoPrincipal, BigDecimal subtotal, String conCodigo, String susCodigo, BigDecimal base0, BigDecimal baseImponible, BigDecimal detPorcentaje, BigDecimal detValorRetenido, BigDecimal detBaseNoObjetoIva) {
        this.proCodigoPrincipal = proCodigoPrincipal;
        this.subtotal = subtotal;
        this.conCodigo = conCodigo;
        this.susCodigo = susCodigo;
        this.base0 = base0;
        this.baseImponible = baseImponible;
        this.detPorcentaje = detPorcentaje;
        this.detValorRetenido = detValorRetenido;
        this.detBaseNoObjetoIva = detBaseNoObjetoIva;
    }
    

    public BigDecimal getBase0() {
        return base0;
    }

    public void setBase0(BigDecimal base0) {
        this.base0 = base0;
    }

    public BigDecimal getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(BigDecimal baseImponible) {
        this.baseImponible = baseImponible;
    }

    public String getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(String conCodigo) {
        this.conCodigo = conCodigo;
    }

    public BigDecimal getDetBaseNoObjetoIva() {
        return detBaseNoObjetoIva;
    }

    public void setDetBaseNoObjetoIva(BigDecimal detBaseNoObjetoIva) {
        this.detBaseNoObjetoIva = detBaseNoObjetoIva;
    }

    public BigDecimal getDetPorcentaje() {
        return detPorcentaje;
    }

    public void setDetPorcentaje(BigDecimal detPorcentaje) {
        this.detPorcentaje = detPorcentaje;
    }

    public BigDecimal getDetValorRetenido() {
        return detValorRetenido;
    }

    public void setDetValorRetenido(BigDecimal detValorRetenido) {
        this.detValorRetenido = detValorRetenido;
    }

    public String getProCodigoPrincipal() {
        return proCodigoPrincipal;
    }

    public void setProCodigoPrincipal(String proCodigoPrincipal) {
        this.proCodigoPrincipal = proCodigoPrincipal;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getSusCodigo() {
        return susCodigo;
    }

    public void setSusCodigo(String susCodigo) {
        this.susCodigo = susCodigo;
    }
}