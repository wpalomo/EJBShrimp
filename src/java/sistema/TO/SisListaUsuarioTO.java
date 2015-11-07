/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.TO;

import java.io.Serializable;

/**
 *
 * @author jack
 */
public class SisListaUsuarioTO implements Serializable {
    private String usrCodigo;
    private String usrNombre;
    private String usrApellido;

    public SisListaUsuarioTO() {
    }

    public SisListaUsuarioTO(String usrCodigo, String usrNombre, String usrApellido) {
        this.usrCodigo = usrCodigo;
        this.usrNombre = usrNombre;
        this.usrApellido = usrApellido;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }


    @Override
    public String toString(){
        return (getUsrNombre() + " " + getUsrApellido());
    }


}
