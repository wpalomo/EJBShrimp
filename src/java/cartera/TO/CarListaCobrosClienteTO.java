/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cartera.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class CarListaCobrosClienteTO implements Serializable{
    private String cliCodigo;
    private String cliNombre;
    private String cliRuc;
    private String cliDireccion;
    private String cliObservaciones;
    private String conFecha;
    private boolean conAnulado;

    public CarListaCobrosClienteTO() {
    }

    public CarListaCobrosClienteTO(String cliCodigo, String cliNombre, String cliRuc, String cliDireccion, String cliObservaciones, String conFecha, boolean conAnulado) {
        this.cliCodigo = cliCodigo;
        this.cliNombre = cliNombre;
        this.cliRuc = cliRuc;
        this.cliDireccion = cliDireccion;
        this.cliObservaciones = cliObservaciones;
        this.conFecha = conFecha;
        this.conAnulado = conAnulado;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliObservaciones() {
        return cliObservaciones;
    }

    public void setCliObservaciones(String cliObservaciones) {
        this.cliObservaciones = cliObservaciones;
    }

    public String getCliRuc() {
        return cliRuc;
    }

    public void setCliRuc(String cliRuc) {
        this.cliRuc = cliRuc;
    }

    public boolean getConAnulado() {
        return conAnulado;
    }

    public void setConAnulado(boolean conAnulado) {
        this.conAnulado = conAnulado;
    }

    public String getConFecha() {
        return conFecha;
    }

    public void setConFecha(String conFecha) {
        this.conFecha = conFecha;
    }
}