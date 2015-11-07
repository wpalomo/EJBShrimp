/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import contabilidad.TO.ConContableTO;
import contabilidad.TO.ConDetalleTO;
import java.util.List;

/**
 *
 * @author jack
 */
public class RetornoTO implements java.io.Serializable{
//    private java.util.List<CostoDetalleMultipleCorridaTO> costoDetalleMultipleCorridaTOs;
    private String[] columnas = null;
    private java.util.List<String> columnasFaltantes = null;
    private Object[][] datos = {};
    private String mensaje;
    private java.util.List<String> mensajeConError;
    private contabilidad.TO.ConContableTO conContableTO;
    private java.util.List<contabilidad.TO.ConDetalleTO> conDetalleTO;
    

    public RetornoTO() {
    }

    public List<String> getMensajeConError() {
        return mensajeConError;
    }

    public void setMensajeConError(List<String> mensajeConError) {
        this.mensajeConError = mensajeConError;
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    public List<String> getColumnasFaltantes() {
        return columnasFaltantes;
    }

    public void setColumnasFaltantes(List<String> columnasFaltantes) {
        this.columnasFaltantes = columnasFaltantes;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ConContableTO getConContableTO() {
        return conContableTO;
    }

    public void setConContableTO(ConContableTO conContableTO) {
        this.conContableTO = conContableTO;
    }

    public List<ConDetalleTO> getConDetalleTO() {
        return conDetalleTO;
    }

    public void setConDetalleTO(List<ConDetalleTO> conDetalleTO) {
        this.conDetalleTO = conDetalleTO;
    }
}
