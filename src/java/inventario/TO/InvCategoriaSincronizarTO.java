/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author misayo
 */
public class InvCategoriaSincronizarTO implements java.io.Serializable{
    private String scCodigo;
    private String scNombre;
    private String scStatus;

    public InvCategoriaSincronizarTO() {
    }

    public InvCategoriaSincronizarTO(String scCodigo, String scNombre, String scStatus) {
        this.scCodigo = scCodigo;
        this.scNombre = scNombre;
        this.scStatus = scStatus;
    }

    public String getScCodigo() {
        return scCodigo;
    }

    public void setScCodigo(String scCodigo) {
        this.scCodigo = scCodigo;
    }

    public String getScNombre() {
        return scNombre;
    }

    public void setScNombre(String scNombre) {
        this.scNombre = scNombre;
    }

    public String getScStatus() {
        return scStatus;
    }

    public void setScStatus(String scStatus) {
        this.scStatus = scStatus;
    }
}