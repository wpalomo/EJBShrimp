/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class RhParametrosTO implements Serializable{

    private String parDesde;
    private String parHasta;
    private BigDecimal parIessPorcentajeAporteIndividual;
    private BigDecimal parIessPorcentajeAporteExtendido;
    private BigDecimal parIessPorcentajeAportePatronal;
    private BigDecimal parIessPorcentajeIece;
    private BigDecimal parIessPorcentajeSecap;
    private BigDecimal parSalarioMinimoVital;

    public RhParametrosTO() {
    }

    public RhParametrosTO(String parDesde, String parHasta, BigDecimal parIessPorcentajeAporteIndividual, BigDecimal parIessPorcentajeAporteExtendido, BigDecimal parIessPorcentajeAportePatronal, BigDecimal parIessPorcentajeIece, BigDecimal parIessPorcentajeSecap, BigDecimal parSalarioMinimoVital) {
        this.parDesde = parDesde;
        this.parHasta = parHasta;
        this.parIessPorcentajeAporteIndividual = parIessPorcentajeAporteIndividual;
        this.parIessPorcentajeAporteExtendido = parIessPorcentajeAporteExtendido;
        this.parIessPorcentajeAportePatronal = parIessPorcentajeAportePatronal;
        this.parIessPorcentajeIece = parIessPorcentajeIece;
        this.parIessPorcentajeSecap = parIessPorcentajeSecap;
        this.parSalarioMinimoVital = parSalarioMinimoVital;
    }

    public String getParDesde() {
        return parDesde;
    }

    public void setParDesde(String parDesde) {
        this.parDesde = parDesde;
    }

    public String getParHasta() {
        return parHasta;
    }

    public void setParHasta(String parHasta) {
        this.parHasta = parHasta;
    }

    public BigDecimal getParIessPorcentajeAporteExtendido() {
        return parIessPorcentajeAporteExtendido;
    }

    public void setParIessPorcentajeAporteExtendido(BigDecimal parIessPorcentajeAporteExtendido) {
        this.parIessPorcentajeAporteExtendido = parIessPorcentajeAporteExtendido;
    }

    public BigDecimal getParIessPorcentajeAporteIndividual() {
        return parIessPorcentajeAporteIndividual;
    }

    public void setParIessPorcentajeAporteIndividual(BigDecimal parIessPorcentajeAporteIndividual) {
        this.parIessPorcentajeAporteIndividual = parIessPorcentajeAporteIndividual;
    }

    public BigDecimal getParIessPorcentajeAportePatronal() {
        return parIessPorcentajeAportePatronal;
    }

    public void setParIessPorcentajeAportePatronal(BigDecimal parIessPorcentajeAportePatronal) {
        this.parIessPorcentajeAportePatronal = parIessPorcentajeAportePatronal;
    }

    public BigDecimal getParIessPorcentajeIece() {
        return parIessPorcentajeIece;
    }

    public void setParIessPorcentajeIece(BigDecimal parIessPorcentajeIece) {
        this.parIessPorcentajeIece = parIessPorcentajeIece;
    }

    public BigDecimal getParIessPorcentajeSecap() {
        return parIessPorcentajeSecap;
    }

    public void setParIessPorcentajeSecap(BigDecimal parIessPorcentajeSecap) {
        this.parIessPorcentajeSecap = parIessPorcentajeSecap;
    }

    public BigDecimal getParSalarioMinimoVital() {
        return parSalarioMinimoVital;
    }

    public void setParSalarioMinimoVital(BigDecimal parSalarioMinimoVital) {
        this.parSalarioMinimoVital = parSalarioMinimoVital;
    }
}
