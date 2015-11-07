/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvConsumoMotivoTablaTO implements java.io.Serializable{
    private String cmCodigo;
    private String cmDetalle;

    public InvConsumoMotivoTablaTO() {
    }

    public InvConsumoMotivoTablaTO(String cmCodigo, String cmDetalle) {
        this.cmCodigo = cmCodigo;
        this.cmDetalle = cmDetalle;
    }

    public String getCmCodigo() {
        return cmCodigo;
    }

    public void setCmCodigo(String cmCodigo) {
        this.cmCodigo = cmCodigo;
    }

    public String getCmDetalle() {
        return cmDetalle;
    }

    public void setCmDetalle(String cmDetalle) {
        this.cmDetalle = cmDetalle;
    }
}
