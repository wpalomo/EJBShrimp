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
public class ReporteCuentasPorPagarGeneral implements Serializable {

    private String codigoCP;
    private String fechaHasta;
    /////////DETALLE
    private String cxpgCodigo;
    private String cxpgNombre;
    private java.math.BigDecimal cxpgSaldo;

    public ReporteCuentasPorPagarGeneral() {
    }

    public ReporteCuentasPorPagarGeneral(String codigoCP, String fechaHasta, String cxpgCodigo, String cxpgNombre, BigDecimal cxpgSaldo) {
        this.codigoCP = codigoCP;
        this.fechaHasta = fechaHasta;
        this.cxpgCodigo = cxpgCodigo;
        this.cxpgNombre = cxpgNombre;
        this.cxpgSaldo = cxpgSaldo;
    }

    public String getCodigoCP() {
        return codigoCP;
    }

    public void setCodigoCP(String codigoCP) {
        this.codigoCP = codigoCP;
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

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
}
