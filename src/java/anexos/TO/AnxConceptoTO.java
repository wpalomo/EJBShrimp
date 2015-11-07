/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class AnxConceptoTO implements java.io.Serializable{
    private String conCodigo;
    private String conConcepto;
    private java.math.BigDecimal conPorcentaje;
    private String fechaInicio;
    private String fechaFin;

    public AnxConceptoTO() {
    }

    public AnxConceptoTO(String conCodigo, String conConcepto, BigDecimal conPorcentaje, String fechaInicio, String fechaFin) {
        this.conCodigo = conCodigo;
        this.conConcepto = conConcepto;
        this.conPorcentaje = conPorcentaje;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(String conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getConConcepto() {
        return conConcepto;
    }

    public void setConConcepto(String conConcepto) {
        this.conConcepto = conConcepto;
    }

    public BigDecimal getConPorcentaje() {
        return conPorcentaje;
    }

    public void setConPorcentaje(BigDecimal conPorcentaje) {
        this.conPorcentaje = conPorcentaje;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
