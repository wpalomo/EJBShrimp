/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.reporte;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ReporteConsultaBonosLote {
    private String periodo;
    private String tipo;
    private String numero;

    /////DETALLE
    private String dblFecha;
    private String dblId;
    private String dblNombres;
    private java.math.BigDecimal dblValor;

    private String formaPago;
    private String documento;
    private String observaciones;

    public ReporteConsultaBonosLote() {
    }

    public ReporteConsultaBonosLote(String periodo, String tipo, String numero, String dblFecha, String dblId, String dblNombres, BigDecimal dblValor, String formaPago, String documento, String observaciones) {
        this.periodo = periodo;
        this.tipo = tipo;
        this.numero = numero;
        this.dblFecha = dblFecha;
        this.dblId = dblId;
        this.dblNombres = dblNombres;
        this.dblValor = dblValor;
        this.formaPago = formaPago;
        this.documento = documento;
        this.observaciones = observaciones;
    }

    public String getDblFecha() {
        return dblFecha;
    }

    public void setDblFecha(String dblFecha) {
        this.dblFecha = dblFecha;
    }

    public String getDblId() {
        return dblId;
    }

    public void setDblId(String dblId) {
        this.dblId = dblId;
    }

    public String getDblNombres() {
        return dblNombres;
    }

    public void setDblNombres(String dblNombres) {
        this.dblNombres = dblNombres;
    }

    public BigDecimal getDblValor() {
        return dblValor;
    }

    public void setDblValor(BigDecimal dblValor) {
        this.dblValor = dblValor;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
