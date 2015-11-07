/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jack
 */
public class MensajeTO implements java.io.Serializable{
    private Boolean correcto;
    private String mensaje;
    private String fechaCreacion;
    private java.util.List<String> listaErrores = new java.util.ArrayList();
    private java.util.List<String> listaMensajes = new java.util.ArrayList();
    private Map<String, Object> map = new HashMap<String, Object>();

    public MensajeTO() {
    }

    public MensajeTO(Boolean correcto, String mensaje, String fechaCreacion) {
        this.correcto = correcto;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Boolean getCorrecto() {
        return correcto;
    }

    public void setCorrecto(Boolean correcto) {
        this.correcto = correcto;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<String> getListaErrores() {
        return listaErrores;
    }

    public void setListaErrores(List<String> listaErrores) {
        this.listaErrores = listaErrores;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<String> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
    
    @Override
    public String toString(){
        return this.mensaje;
    }
}
