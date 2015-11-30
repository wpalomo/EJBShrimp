/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.TO;

/**
 *
 * @author jack
 */
public class ListaBanBancoTO implements java.io.Serializable {
    private String banCodigo;
    private String banNombre;

    public ListaBanBancoTO() {
    }

    public ListaBanBancoTO(String banCodigo, String banNombre) {
        this.banCodigo = banCodigo;
        this.banNombre = banNombre;
    }

    public String getBanCodigo() {
        return banCodigo;
    }

    public void setBanCodigo(String banCodigo) {
        this.banCodigo = banCodigo;
    }

    public String getBanNombre() {
        return banNombre;
    }

    public void setBanNombre(String banNombre) {
        this.banNombre = banNombre;
    }

    public String retornoDatos(){
        return this.banCodigo + " " + this.banNombre + " ";
    }   
    
    

    @Override
    public String toString(){
        return this.banCodigo + " " + this.banNombre + " ";
    }
    
}
