/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvListaProveedoresTO implements java.io.Serializable {
    private String provCodigo;
    private String provId;
    private String provNombre;
    private String catDetalle;

    public InvListaProveedoresTO() {
    }

    public InvListaProveedoresTO(String provCodigo, String provId, String provNombre, String catDetalle) {
        this.provCodigo = provCodigo;
        this.provId = provId;
        this.provNombre = provNombre;
        this.catDetalle = catDetalle;
    }

    public String getCatDetalle() {
        return catDetalle;
    }

    public void setCatDetalle(String catDetalle) {
        this.catDetalle = catDetalle;
    }

    public String getProvCodigo() {
        return provCodigo;
    }

    public void setProvCodigo(String provCodigo) {
        this.provCodigo = provCodigo;
    }

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public String getProvNombre() {
        return provNombre;
    }

    public void setProvNombre(String provNombre) {
        this.provNombre = provNombre;
    }
}
