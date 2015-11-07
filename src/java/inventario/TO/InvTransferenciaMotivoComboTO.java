/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvTransferenciaMotivoComboTO implements java.io.Serializable{
    private String tmCodigo;
    private String tmDetalle;

    public InvTransferenciaMotivoComboTO() {
    }

    public InvTransferenciaMotivoComboTO(String tmCodigo, String tmDetalle) {
        this.tmCodigo = tmCodigo;
        this.tmDetalle = tmDetalle;
    }

    public String getTmCodigo() {
        return tmCodigo;
    }

    public void setTmCodigo(String tmCodigo) {
        this.tmCodigo = tmCodigo;
    }

    public String getTmDetalle() {
        return tmDetalle;
    }

    public void setTmDetalle(String tmDetalle) {
        this.tmDetalle = tmDetalle;
    }
    
    @Override
    public String toString(){
        return this.tmDetalle;
    }
}
