/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.TO;

import java.io.Serializable;

/**
 *
 * @author jack
 */
public class SisListaPeriodoTO implements Serializable{
    private String perCodigo;
    private String perDetalle;
    private String perDesde;
    private String perHasta;
    private Boolean perCerrado;

    public SisListaPeriodoTO() {
    }

    public SisListaPeriodoTO(String perCodigo, String perDetalle, String perDesde, String perHasta, Boolean perCerrado) {
        this.perCodigo = perCodigo;
        this.perDetalle = perDetalle;
        this.perDesde = perDesde;
        this.perHasta = perHasta;
        this.perCerrado = perCerrado;
    }

    public Boolean getPerCerrado() {
        return perCerrado;
    }

    public void setPerCerrado(Boolean perCerrado) {
        this.perCerrado = perCerrado;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerDesde() {
        return perDesde;
    }

    public void setPerDesde(String perDesde) {
        this.perDesde = perDesde;
    }

    public String getPerDetalle() {
        return perDetalle;
    }

    public void setPerDetalle(String perDetalle) {
        this.perDetalle = perDetalle;
    }

    public String getPerHasta() {
        return perHasta;
    }

    public void setPerHasta(String perHasta) {
        this.perHasta = perHasta;
    }

    @Override
    public String toString(){
        return this.perDetalle;
    }

    
}
