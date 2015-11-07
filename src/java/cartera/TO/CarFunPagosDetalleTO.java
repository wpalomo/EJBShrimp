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
public class CarFunPagosDetalleTO implements Serializable{
    private String pagNumeroSistema;
    private String pagFecha;
    private String pagProveedor;
    private String pagFormaPago;
    private String pagReferencia;
    private java.math.BigDecimal pagValor;
    private String pagObservaciones;
    private Boolean pagPendiente;
    private Boolean pagAnulado;

    public CarFunPagosDetalleTO() {
    }

    public CarFunPagosDetalleTO(String pagNumeroSistema, String pagFecha, String pagProveedor, String pagFormaPago, String pagReferencia, BigDecimal pagValor, String pagObservaciones, Boolean pagPendiente, Boolean pagAnulado) {
        this.pagNumeroSistema = pagNumeroSistema;
        this.pagFecha = pagFecha;
        this.pagProveedor = pagProveedor;
        this.pagFormaPago = pagFormaPago;
        this.pagReferencia = pagReferencia;
        this.pagValor = pagValor;
        this.pagObservaciones = pagObservaciones;
        this.pagPendiente = pagPendiente;
        this.pagAnulado = pagAnulado;
    }

    public Boolean getPagAnulado() {
        return pagAnulado;
    }

    public void setPagAnulado(Boolean pagAnulado) {
        this.pagAnulado = pagAnulado;
    }

    public String getPagFecha() {
        return pagFecha;
    }

    public void setPagFecha(String pagFecha) {
        this.pagFecha = pagFecha;
    }

    public String getPagFormaPago() {
        return pagFormaPago;
    }

    public void setPagFormaPago(String pagFormaPago) {
        this.pagFormaPago = pagFormaPago;
    }

    public String getPagNumeroSistema() {
        return pagNumeroSistema;
    }

    public void setPagNumeroSistema(String pagNumeroSistema) {
        this.pagNumeroSistema = pagNumeroSistema;
    }

    public String getPagObservaciones() {
        return pagObservaciones;
    }

    public void setPagObservaciones(String pagObservaciones) {
        this.pagObservaciones = pagObservaciones;
    }

    public Boolean getPagPendiente() {
        return pagPendiente;
    }

    public void setPagPendiente(Boolean pagPendiente) {
        this.pagPendiente = pagPendiente;
    }

    public String getPagProveedor() {
        return pagProveedor;
    }

    public void setPagProveedor(String pagProveedor) {
        this.pagProveedor = pagProveedor;
    }

    public String getPagReferencia() {
        return pagReferencia;
    }

    public void setPagReferencia(String pagReferencia) {
        this.pagReferencia = pagReferencia;
    }

    public BigDecimal getPagValor() {
        return pagValor;
    }

    public void setPagValor(BigDecimal pagValor) {
        this.pagValor = pagValor;
    }
        
}
