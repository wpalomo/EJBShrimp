/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvCompraMotivoTablaTO implements java.io.Serializable{
    private String cmCodigo;
    private String cmDetalle;
    private String tipNombre;

    public InvCompraMotivoTablaTO() {
    }

    public InvCompraMotivoTablaTO(String cmCodigo, String cmDetalle, String tipNombre) {
        this.cmCodigo = cmCodigo;
        this.cmDetalle = cmDetalle;
        this.tipNombre = tipNombre;
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

    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }
}
