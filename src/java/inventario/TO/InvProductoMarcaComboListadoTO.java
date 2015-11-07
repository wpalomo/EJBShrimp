/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.TO;

/**
 *
 * @author jack
 */

public class InvProductoMarcaComboListadoTO implements java.io.Serializable {    
    private String marCodigo;
    private String marDetalle;
    private String marAbreviado;
    

    public InvProductoMarcaComboListadoTO() {
    }

    public InvProductoMarcaComboListadoTO(String marCodigo, String marDetalle, String marAbreviado) {
        this.marCodigo = marCodigo;
        this.marDetalle = marDetalle;
        this.marAbreviado = marAbreviado;
    }

    public String getMarAbreviado() {
        return marAbreviado;
    }

    public void setMarAbreviado(String marAbreviado) {
        this.marAbreviado = marAbreviado;
    }

    public String getMarCodigo() {
        return marCodigo;
    }

    public void setMarCodigo(String marCodigo) {
        this.marCodigo = marCodigo;
    }

    public String getMarDetalle() {
        return marDetalle;
    }

    public void setMarDetalle(String marDetalle) {
        this.marDetalle = marDetalle;
    }

    
    @Override
    public String toString(){
        return this.marDetalle;
    }
}
