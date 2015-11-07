/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.TO;

import java.io.Serializable;

/**
 *
 * @author javier tj
 */
public class PrdLiquidacionTallaTablaTO implements Serializable{
    private String tallaCodigo;
    private String tallaDetalle;

    public PrdLiquidacionTallaTablaTO() {
    }

    public PrdLiquidacionTallaTablaTO(String tallaCodigo, String tallaDetalle) {
        this.tallaCodigo = tallaCodigo;
        this.tallaDetalle = tallaDetalle;
    }

    public String getTallaCodigo() {
        return tallaCodigo;
    }

    public void setTallaCodigo(String tallaCodigo) {
        this.tallaCodigo = tallaCodigo;
    }

    public String getTallaDetalle() {
        return tallaDetalle;
    }

    public void setTallaDetalle(String tallaDetalle) {
        this.tallaDetalle = tallaDetalle;
    }
    
}
