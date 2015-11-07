/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cartera.TO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author misael
 */
public class CarContableTO implements Serializable{
    private String contPeriodo;
    private String contTipo;
    private String contNumero;
    private String mensaje;
    private java.util.List <String> listaFacturaTO = new java.util.ArrayList(1);

    public CarContableTO() {
    }

    public CarContableTO(String contPeriodo, String contTipo, String contNumero, String mensaje) {
        this.contPeriodo = contPeriodo;
        this.contTipo = contTipo;
        this.contNumero = contNumero;
        this.mensaje = mensaje;
    }

    public String getContNumero() {
        return contNumero;
    }

    public void setContNumero(String contNumero) {
        this.contNumero = contNumero;
    }

    public String getContPeriodo() {
        return contPeriodo;
    }

    public void setContPeriodo(String contPeriodo) {
        this.contPeriodo = contPeriodo;
    }

    public String getContTipo() {
        return contTipo;
    }

    public void setContTipo(String contTipo) {
        this.contTipo = contTipo;
    }

    public List<String> getListaFacturaTO() {
        return listaFacturaTO;
    }

    public void setListaFacturaTO(List<String> listaFacturaTO) {
        this.listaFacturaTO = listaFacturaTO;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
