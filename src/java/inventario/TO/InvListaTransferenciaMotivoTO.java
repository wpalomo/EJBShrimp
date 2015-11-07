/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvListaTransferenciaMotivoTO implements java.io.Serializable{
    private String tmCodigo;
    private String tmDetalle;
    private Boolean tmInactivo;

    public InvListaTransferenciaMotivoTO() {
    }

    public InvListaTransferenciaMotivoTO(String tmCodigo, String tmDetalle, Boolean tmInactivo) {
        this.tmCodigo = tmCodigo;
        this.tmDetalle = tmDetalle;
        this.tmInactivo = tmInactivo;
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

    public Boolean getTmInactivo() {
        return tmInactivo;
    }

    public void setTmInactivo(Boolean tmInactivo) {
        this.tmInactivo = tmInactivo;
    }
}
