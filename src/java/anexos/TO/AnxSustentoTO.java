/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

/**
 *
 * @author jack
 */
public class AnxSustentoTO implements java.io.Serializable{
    private String susCodigo;
    private String susDescripcion;
    private String susComprobante;

    public AnxSustentoTO() {
    }

    public AnxSustentoTO(String susCodigo, String susDescripcion, String susComprobante) {
        this.susCodigo = susCodigo;
        this.susDescripcion = susDescripcion;
        this.susComprobante = susComprobante;
    }

    public String getSusCodigo() {
        return susCodigo;
    }

    public void setSusCodigo(String susCodigo) {
        this.susCodigo = susCodigo;
    }

    public String getSusComprobante() {
        return susComprobante;
    }

    public void setSusComprobante(String susComprobante) {
        this.susComprobante = susComprobante;
    }

    public String getSusDescripcion() {
        return susDescripcion;
    }

    public void setSusDescripcion(String susDescripcion) {
        this.susDescripcion = susDescripcion;
    }
}
