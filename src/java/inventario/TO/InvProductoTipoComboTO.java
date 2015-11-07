/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.TO;

/**
 *
 * @author jack
 */
public class InvProductoTipoComboTO implements java.io.Serializable {
    private String tipCodigo;
    private String tipDetalle;
    private String tipTipo;
    private Boolean tipActivo;

    public InvProductoTipoComboTO() {
    }

    public InvProductoTipoComboTO(String tipCodigo, String tipDetalle, String tipTipo, Boolean tipActivo) {
        this.tipCodigo = tipCodigo;
        this.tipDetalle = tipDetalle;
        this.tipTipo = tipTipo;
        this.tipActivo = tipActivo;
    }

    public Boolean getTipActivo() {
        return tipActivo;
    }

    public void setTipActivo(Boolean tipActivo) {
        this.tipActivo = tipActivo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipDetalle() {
        return tipDetalle;
    }

    public void setTipDetalle(String tipDetalle) {
        this.tipDetalle = tipDetalle;
    }

    public String getTipTipo() {
        return tipTipo;
    }

    public void setTipTipo(String tipTipo) {
        this.tipTipo = tipTipo;
    }
    
    @Override
    public String toString(){
        return this.tipDetalle;
    }
}
