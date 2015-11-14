/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.reporte;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ReporteListadoPagos implements Serializable {

    private String codigoCP;
    private String desde;
    private String hasta;
    private String proveedor;
    //////DETALLE
    private String pagNumeroSistema;
    private String pagFecha;
    private String pagProveedor;
    private java.math.BigDecimal pagValor;
    private String pagObservaciones;
    private Boolean pagPendiente;
    private Boolean pagAnulado;

    public ReporteListadoPagos() {
    }

    public ReporteListadoPagos(String desde, String hasta, String proveedor, String pagNumeroSistema, String pagFecha, String pagProveedor, BigDecimal pagValor, String pagObservaciones, Boolean pagPendiente, Boolean pagAnulado) {
//        this.codigoCP = codigoCP;
        this.desde = desde;
        this.hasta = hasta;
        this.proveedor = proveedor;
        this.pagNumeroSistema = pagNumeroSistema;
        this.pagFecha = pagFecha;
        this.pagProveedor = pagProveedor;
        this.pagValor = pagValor;
        this.pagObservaciones = pagObservaciones;
        this.pagPendiente = pagPendiente;
        this.pagAnulado = pagAnulado;
    }

    public String getDesde() {
        return desde;
    }

    public String getCodigoCP() {
        return codigoCP;
    }

    public void setCodigoCP(String codigoCP) {
        this.codigoCP = codigoCP;
    }

    
    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
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

    public BigDecimal getPagValor() {
        return pagValor;
    }

    public void setPagValor(BigDecimal pagValor) {
        this.pagValor = pagValor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}
