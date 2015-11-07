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
public class ReporteCuentasPorPagarDetallado implements Serializable {

    private String codigoCP;
    private String fechaHasta;
    /////////DETALLE
    private String cxpdPeriodo;
    private String cxpdMotivo;
    private String cxpdNumero;
    private String cxpdProveedor;
    private String cxpdFechaEmision;
    private String cxpdFechaVencimiento;
    private java.math.BigDecimal cxpdSaldo;

    public ReporteCuentasPorPagarDetallado() {
    }

    public ReporteCuentasPorPagarDetallado(String codigoCP, String fechaHasta, String cxpdPeriodo, String cxpdMotivo, String cxpdNumero, String cxpdProveedor, String cxpdFechaEmision, String cxpdFechaVencimiento, BigDecimal cxpdSaldo) {
        this.codigoCP = codigoCP;
        this.fechaHasta = fechaHasta;
        this.cxpdPeriodo = cxpdPeriodo;
        this.cxpdMotivo = cxpdMotivo;
        this.cxpdNumero = cxpdNumero;
        this.cxpdProveedor = cxpdProveedor;
        this.cxpdFechaEmision = cxpdFechaEmision;
        this.cxpdFechaVencimiento = cxpdFechaVencimiento;
        this.cxpdSaldo = cxpdSaldo;
    }

    public String getCodigoCP() {
        return codigoCP;
    }

    public void setCodigoCP(String codigoCP) {
        this.codigoCP = codigoCP;
    }

    public String getCxpdFechaEmision() {
        return cxpdFechaEmision;
    }

    public void setCxpdFechaEmision(String cxpdFechaEmision) {
        this.cxpdFechaEmision = cxpdFechaEmision;
    }

    public String getCxpdFechaVencimiento() {
        return cxpdFechaVencimiento;
    }

    public void setCxpdFechaVencimiento(String cxpdFechaVencimiento) {
        this.cxpdFechaVencimiento = cxpdFechaVencimiento;
    }

    public String getCxpdMotivo() {
        return cxpdMotivo;
    }

    public void setCxpdMotivo(String cxpdMotivo) {
        this.cxpdMotivo = cxpdMotivo;
    }

    public String getCxpdNumero() {
        return cxpdNumero;
    }

    public void setCxpdNumero(String cxpdNumero) {
        this.cxpdNumero = cxpdNumero;
    }

    public String getCxpdPeriodo() {
        return cxpdPeriodo;
    }

    public void setCxpdPeriodo(String cxpdPeriodo) {
        this.cxpdPeriodo = cxpdPeriodo;
    }

    public String getCxpdProveedor() {
        return cxpdProveedor;
    }

    public void setCxpdProveedor(String cxpdProveedor) {
        this.cxpdProveedor = cxpdProveedor;
    }

    public BigDecimal getCxpdSaldo() {
        return cxpdSaldo;
    }

    public void setCxpdSaldo(BigDecimal cxpdSaldo) {
        this.cxpdSaldo = cxpdSaldo;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
}
