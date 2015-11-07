/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

/**
 *
 * @author jack
 */
public class AnxTipoListaTransaccionTO implements java.io.Serializable{
    private String ttCodigo;
    private String ttTransaccion;
    private Character ttId;

    public AnxTipoListaTransaccionTO() {
    }

    public AnxTipoListaTransaccionTO(String ttCodigo, String ttTransaccion, Character ttId) {
        this.ttCodigo = ttCodigo;
        this.ttTransaccion = ttTransaccion;
        this.ttId = ttId;
    }

    public String getTtCodigo() {
        return ttCodigo;
    }

    public void setTtCodigo(String ttCodigo) {
        this.ttCodigo = ttCodigo;
    }

    public Character getTtId() {
        return ttId;
    }

    public void setTtId(Character ttId) {
        this.ttId = ttId;
    }

    public String getTtTransaccion() {
        return ttTransaccion;
    }

    public void setTtTransaccion(String ttTransaccion) {
        this.ttTransaccion = ttTransaccion;
    }
}
