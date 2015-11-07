/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

/**
 *
 * @author jack
 */
public class AnxPaisTO implements java.io.Serializable{
    private String paisCodigo;
    private String paisNombre;

    public AnxPaisTO() {
    }

    public AnxPaisTO(String paisCodigo, String paisNombre) {
        this.paisCodigo = paisCodigo;
        this.paisNombre = paisNombre;
    }

    public String getPaisCodigo() {
        return paisCodigo;
    }

    public void setPaisCodigo(String paisCodigo) {
        this.paisCodigo = paisCodigo;
    }

    public String getPaisNombre() {
        return paisNombre;
    }

    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }
    
    @Override
    public String toString(){
        return this.paisNombre.trim();
    }
}