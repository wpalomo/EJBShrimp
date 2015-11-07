/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cartera.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class CarFunCobrosDetalleTO implements Serializable{
    private String cobNumeroSistema;
    private String cobFecha;
    private String cobCliente;
    private String cobFormaPago;
    private String cobReferencia;
    private java.math.BigDecimal cobValor;
    private String cobObservaciones;
    private Boolean cobPendiente;
    private Boolean cobAnulado;

    public CarFunCobrosDetalleTO() {
    }

    public CarFunCobrosDetalleTO(String cobNumeroSistema, String cobFecha, String cobCliente, String cobFormaPago, String cobReferencia, BigDecimal cobValor, String cobObservaciones, Boolean cobPendiente, Boolean cobAnulado) {
        this.cobNumeroSistema = cobNumeroSistema;
        this.cobFecha = cobFecha;
        this.cobCliente = cobCliente;
        this.cobFormaPago = cobFormaPago;
        this.cobReferencia = cobReferencia;
        this.cobValor = cobValor;
        this.cobObservaciones = cobObservaciones;
        this.cobPendiente = cobPendiente;
        this.cobAnulado = cobAnulado;
    }

    public Boolean getCobAnulado() {
        return cobAnulado;
    }

    public void setCobAnulado(Boolean cobAnulado) {
        this.cobAnulado = cobAnulado;
    }

    public String getCobCliente() {
        return cobCliente;
    }

    public void setCobCliente(String cobCliente) {
        this.cobCliente = cobCliente;
    }

    public String getCobFecha() {
        return cobFecha;
    }

    public void setCobFecha(String cobFecha) {
        this.cobFecha = cobFecha;
    }

    public String getCobFormaPago() {
        return cobFormaPago;
    }

    public void setCobFormaPago(String cobFormaPago) {
        this.cobFormaPago = cobFormaPago;
    }

    public String getCobNumeroSistema() {
        return cobNumeroSistema;
    }

    public void setCobNumeroSistema(String cobNumeroSistema) {
        this.cobNumeroSistema = cobNumeroSistema;
    }

    public String getCobObservaciones() {
        return cobObservaciones;
    }

    public void setCobObservaciones(String cobObservaciones) {
        this.cobObservaciones = cobObservaciones;
    }

    public Boolean getCobPendiente() {
        return cobPendiente;
    }

    public void setCobPendiente(Boolean cobPendiente) {
        this.cobPendiente = cobPendiente;
    }

    public String getCobReferencia() {
        return cobReferencia;
    }

    public void setCobReferencia(String cobReferencia) {
        this.cobReferencia = cobReferencia;
    }

    public BigDecimal getCobValor() {
        return cobValor;
    }

    public void setCobValor(BigDecimal cobValor) {
        this.cobValor = cobValor;
    }
    
}
