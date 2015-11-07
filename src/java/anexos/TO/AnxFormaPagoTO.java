/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.TO;

/**
 *
 * @author javier tj
 */
public class AnxFormaPagoTO  implements java.io.Serializable{
    private String fpCodigo;
    private String fpDetalle;

    public String getFpCodigo() {
        return fpCodigo;
    }

    public void setFpCodigo(String fpCodigo) {
        this.fpCodigo = fpCodigo;
    }

    public String getFpDetalle() {
        return fpDetalle;
    }

    public void setFpDetalle(String fpDetalle) {
        this.fpDetalle = fpDetalle;
    }

    public AnxFormaPagoTO() {
    }

    public AnxFormaPagoTO(String fpCodigo, String fpDetalle) {
        this.fpCodigo = fpCodigo;
        this.fpDetalle = fpDetalle;
    }

    @Override
    public String toString() {
        return fpDetalle;
    }
    
}
