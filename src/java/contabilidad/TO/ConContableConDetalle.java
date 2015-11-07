/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabilidad.TO;

import contabilidad.entity.ConContable;
import contabilidad.entity.ConDetalle;
import java.io.Serializable;

/**
 *
 * @author misael
 */
public class ConContableConDetalle implements Serializable{
    private contabilidad.entity.ConContable conContable;
    private contabilidad.entity.ConDetalle conDetalle;

    public ConContableConDetalle() {
    }

    public ConContableConDetalle(ConContable conContable, ConDetalle conDetalle) {
        this.conContable = conContable;
        this.conDetalle = conDetalle;
    }

    public ConContable getConContable() {
        return conContable;
    }

    public void setConContable(ConContable conContable) {
        this.conContable = conContable;
    }

    public ConDetalle getConDetalle() {
        return conDetalle;
    }

    public void setConDetalle(ConDetalle conDetalle) {
        this.conDetalle = conDetalle;
    }
    
}
