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
public class ReporteCuentasPorPagarAnticipos implements Serializable {

    private String codigoCP;
    private String fechaHasta;
    /////////DETALLE
    private String cxpgCodigo;
    private String cxpgNombre;
    private BigDecimal cxpgSaldo;
    private BigDecimal cxpgAnticipo;
    private BigDecimal cxpgTotal;

    public ReporteCuentasPorPagarAnticipos() {
    }

    public ReporteCuentasPorPagarAnticipos(String codigoCP, String fechaHasta, String cxpgCodigo, String cxpgNombre, BigDecimal cxpgSaldo, BigDecimal cxpgAnticipo, BigDecimal cxpgTotal) {
        this.codigoCP = codigoCP;
        this.fechaHasta = fechaHasta;
        this.cxpgCodigo = cxpgCodigo;
        this.cxpgNombre = cxpgNombre;
        this.cxpgSaldo = cxpgSaldo;
        this.cxpgAnticipo = cxpgAnticipo;
        this.cxpgTotal = cxpgTotal;
    }

    public String getCodigoCP() {
        return codigoCP;
    }

    public void setCodigoCP(String codigoCP) {
        this.codigoCP = codigoCP;
    }

    public BigDecimal getCxpgAnticipo() {
        return cxpgAnticipo;
    }

    public void setCxpgAnticipo(BigDecimal cxpgAnticipo) {
        this.cxpgAnticipo = cxpgAnticipo;
    }

    public String getCxpgCodigo() {
        return cxpgCodigo;
    }

    public void setCxpgCodigo(String cxpgCodigo) {
        this.cxpgCodigo = cxpgCodigo;
    }

    public String getCxpgNombre() {
        return cxpgNombre;
    }

    public void setCxpgNombre(String cxpgNombre) {
        this.cxpgNombre = cxpgNombre;
    }

    public BigDecimal getCxpgSaldo() {
        return cxpgSaldo;
    }

    public void setCxpgSaldo(BigDecimal cxpgSaldo) {
        this.cxpgSaldo = cxpgSaldo;
    }

    public BigDecimal getCxpgTotal() {
        return cxpgTotal;
    }

    public void setCxpgTotal(BigDecimal cxpgTotal) {
        this.cxpgTotal = cxpgTotal;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
}
