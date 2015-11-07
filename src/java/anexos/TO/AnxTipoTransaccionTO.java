/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

/**
 *
 * @author jack
 */
public class AnxTipoTransaccionTO implements java.io.Serializable{
    private String ttCodigo;

    public AnxTipoTransaccionTO() {
    }

    public AnxTipoTransaccionTO(String ttCodigo) {
        this.ttCodigo = ttCodigo;
    }

    public String getTtCodigo() {
        return ttCodigo;
    }

    public void setTtCodigo(String ttCodigo) {
        this.ttCodigo = ttCodigo;
    }
}
