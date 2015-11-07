/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class SisComboPeriodoTO implements Serializable{
    private String perCodigo;
    private String perDetalle;

    public SisComboPeriodoTO() {
    }

    public SisComboPeriodoTO(String perCodigo, String perDetalle) {
        this.perCodigo = perCodigo;
        this.perDetalle = perDetalle;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerDetalle() {
        return perDetalle;
    }

    public void setPerDetalle(String perDetalle) {
        this.perDetalle = perDetalle;
    }

    @Override
    public String toString(){
        return this.perDetalle;
    }
}
