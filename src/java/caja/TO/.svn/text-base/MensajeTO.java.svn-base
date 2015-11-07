/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package caja.TO;

import java.util.List;

/**
 *
 * @author jack
 */
public class MensajeTO implements java.io.Serializable{
    private Boolean correcto;
    private String mensaje;
    private String fechaCreacion;
    private String compra;          //periodo | motivo | numero
    private String venta;           //periodo | motivo | numero
    private String consumo;         //periodo | motivo | numero
    private String transferencia;   //periodo | motivo | numero
    private String contable;        //periodo | tipo | numero
    private java.util.List<String> listaErrores = new java.util.ArrayList();
    private Throwable ex;           //para mandar excepciones

    public MensajeTO() {
    }

    public MensajeTO(Boolean correcto, String mensaje, String fechaCreacion) {
        this.correcto = correcto;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
    }

    public MensajeTO(Boolean correcto, String mensaje, String fechaCreacion, String compra, String venta, String consumo, String transferencia, String contable, Throwable ex) {
        this.correcto = correcto;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.compra = compra;
        this.venta = venta;
        this.consumo = consumo;
        this.transferencia = transferencia;
        this.contable = contable;
        this.ex = ex;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getContable() {
        return contable;
    }

    public void setContable(String contable) {
        this.contable = contable;
    }

    public Boolean getCorrecto() {
        return correcto;
    }

    public void setCorrecto(Boolean correcto) {
        this.correcto = correcto;
    }

    public Throwable getEx() {
        return ex;
    }

    public void setEx(Throwable ex) {
        this.ex = ex;
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

    public String getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(String transferencia) {
        this.transferencia = transferencia;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }
    
    @Override
    public String toString(){
        return this.mensaje;
    }
}
