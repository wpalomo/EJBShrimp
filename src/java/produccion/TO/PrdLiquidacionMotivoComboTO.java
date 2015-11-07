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
public class PrdLiquidacionMotivoComboTO implements Serializable{
    private String lmCodigo;
    private String lmDetalle;

    public PrdLiquidacionMotivoComboTO() {
    }

    public PrdLiquidacionMotivoComboTO(String lmCodigo, String lmDetalle) {
        this.lmCodigo = lmCodigo;
        this.lmDetalle = lmDetalle;
    }

    public String getLmCodigo() {
        return lmCodigo;
    }

    public void setLmCodigo(String lmCodigo) {
        this.lmCodigo = lmCodigo;
    }

    public String getLmDetalle() {
        return lmDetalle;
    }

    public void setLmDetalle(String lmDetalle) {
        this.lmDetalle = lmDetalle;
    }

    @Override
    public String toString() {
        return lmDetalle;
    }
    
}
