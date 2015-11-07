/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class RhListaConsolidadoAnticiposPrestamosTO implements Serializable{
    private String capCategoria;
    private String capId;
    private String capNombres;
    private BigDecimal capAnticipos;
    private BigDecimal capPrestamos;
    private BigDecimal capTotal;
    private String capOrden;

    public RhListaConsolidadoAnticiposPrestamosTO() {
    }

    public RhListaConsolidadoAnticiposPrestamosTO(String capCategoria, String capId, String capNombres, BigDecimal capAnticipos, BigDecimal capPrestamos, BigDecimal capTotal, String capOrden) {
        this.capCategoria = capCategoria;
        this.capId = capId;
        this.capNombres = capNombres;
        this.capAnticipos = capAnticipos;
        this.capPrestamos = capPrestamos;
        this.capTotal = capTotal;
        this.capOrden = capOrden;
    }

    public BigDecimal getCapAnticipos() {
        return capAnticipos;
    }

    public void setCapAnticipos(BigDecimal capAnticipos) {
        this.capAnticipos = capAnticipos;
    }

    public String getCapCategoria() {
        return capCategoria;
    }

    public void setCapCategoria(String capCategoria) {
        this.capCategoria = capCategoria;
    }

    public String getCapId() {
        return capId;
    }

    public void setCapId(String capId) {
        this.capId = capId;
    }

    public String getCapNombres() {
        return capNombres;
    }

    public void setCapNombres(String capNombres) {
        this.capNombres = capNombres;
    }

    public String getCapOrden() {
        return capOrden;
    }

    public void setCapOrden(String capOrden) {
        this.capOrden = capOrden;
    }

    public BigDecimal getCapPrestamos() {
        return capPrestamos;
    }

    public void setCapPrestamos(BigDecimal capPrestamos) {
        this.capPrestamos = capPrestamos;
    }

    public BigDecimal getCapTotal() {
        return capTotal;
    }

    public void setCapTotal(BigDecimal capTotal) {
        this.capTotal = capTotal;
    }
}
