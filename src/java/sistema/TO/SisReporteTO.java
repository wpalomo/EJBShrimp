/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.TO;

/**
 *
 * @author misael
 */
public class SisReporteTO implements java.io.Serializable {
    private String reporteRutaDefault;
    private String reporteFactura;
    private String reporteNotaCredito;
    private String reporteLiquidacion;
    private String reporteRetencion;
    private String reporteGuiaRemision;

    public SisReporteTO() {
    }

    public SisReporteTO(String reporteRutaDefault, String reporteFactura, String reporteNotaCredito, String reporteLiquidacion, String reporteRetencion, String reporteGuiaRemision) {
        this.reporteRutaDefault = reporteRutaDefault;
        this.reporteFactura = reporteFactura;
        this.reporteNotaCredito = reporteNotaCredito;
        this.reporteLiquidacion = reporteLiquidacion;
        this.reporteRetencion = reporteRetencion;
        this.reporteGuiaRemision = reporteGuiaRemision;
    }

    public String getReporteFactura() {
        return reporteFactura;
    }

    public void setReporteFactura(String reporteFactura) {
        this.reporteFactura = reporteFactura;
    }

    public String getReporteGuiaRemision() {
        return reporteGuiaRemision;
    }

    public void setReporteGuiaRemision(String reporteGuiaRemision) {
        this.reporteGuiaRemision = reporteGuiaRemision;
    }

    public String getReporteLiquidacion() {
        return reporteLiquidacion;
    }

    public void setReporteLiquidacion(String reporteLiquidacion) {
        this.reporteLiquidacion = reporteLiquidacion;
    }

    public String getReporteNotaCredito() {
        return reporteNotaCredito;
    }

    public void setReporteNotaCredito(String reporteNotaCredito) {
        this.reporteNotaCredito = reporteNotaCredito;
    }

    public String getReporteRetencion() {
        return reporteRetencion;
    }

    public void setReporteRetencion(String reporteRetencion) {
        this.reporteRetencion = reporteRetencion;
    }

    public String getReporteRutaDefault() {
        return reporteRutaDefault;
    }

    public void setReporteRutaDefault(String reporteRutaDefault) {
        this.reporteRutaDefault = reporteRutaDefault;
    }
}
