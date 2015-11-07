/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produccion.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class PrdListaCorridaTO implements Serializable{
    private String corNumero;
    private String corFechaDesde;
    private BigDecimal corHectareas;
    private Integer corNumeroLarvas;
    private String corLaboratorio;
    private String corNauplio;
    private Short corPellet;
    private String corFechaSiembra;
    private BigDecimal corBiomasa;
    private BigDecimal corValorVenta;
    private String corObservaciones;
    private String corFechaPesca;
    private String corFechaHasta;
    private Boolean corActiva;

    public PrdListaCorridaTO(String corNumero, String corFechaDesde, BigDecimal corHectareas, Integer corNumeroLarvas, String corLaboratorio, String corNauplio, Short corPellet, String corFechaSiembra, BigDecimal corBiomasa, BigDecimal corValorVenta, String corObservaciones, String corFechaPesca, String corFechaHasta, Boolean corActiva) {
        this.corNumero = corNumero;
        this.corFechaDesde = corFechaDesde;
        this.corHectareas = corHectareas;
        this.corNumeroLarvas = corNumeroLarvas;
        this.corLaboratorio = corLaboratorio;
        this.corNauplio = corNauplio;
        this.corPellet = corPellet;
        this.corFechaSiembra = corFechaSiembra;
        this.corBiomasa = corBiomasa;
        this.corValorVenta = corValorVenta;
        this.corObservaciones = corObservaciones;
        this.corFechaPesca = corFechaPesca;
        this.corFechaHasta = corFechaHasta;
        this.corActiva = corActiva;
    }

    public Boolean getCorActiva() {
        return corActiva;
    }

    public void setCorActiva(Boolean corActiva) {
        this.corActiva = corActiva;
    }

    public BigDecimal getCorBiomasa() {
        return corBiomasa;
    }

    public void setCorBiomasa(BigDecimal corBiomasa) {
        this.corBiomasa = corBiomasa;
    }

    public String getCorFechaDesde() {
        return corFechaDesde;
    }

    public void setCorFechaDesde(String corFechaDesde) {
        this.corFechaDesde = corFechaDesde;
    }

    public String getCorFechaHasta() {
        return corFechaHasta;
    }

    public void setCorFechaHasta(String corFechaHasta) {
        this.corFechaHasta = corFechaHasta;
    }

    public String getCorFechaPesca() {
        return corFechaPesca;
    }

    public void setCorFechaPesca(String corFechaPesca) {
        this.corFechaPesca = corFechaPesca;
    }

    public String getCorFechaSiembra() {
        return corFechaSiembra;
    }

    public void setCorFechaSiembra(String corFechaSiembra) {
        this.corFechaSiembra = corFechaSiembra;
    }

    public BigDecimal getCorHectareas() {
        return corHectareas;
    }

    public void setCorHectareas(BigDecimal corHectareas) {
        this.corHectareas = corHectareas;
    }

    public String getCorLaboratorio() {
        return corLaboratorio;
    }

    public void setCorLaboratorio(String corLaboratorio) {
        this.corLaboratorio = corLaboratorio;
    }

    public String getCorNauplio() {
        return corNauplio;
    }

    public void setCorNauplio(String corNauplio) {
        this.corNauplio = corNauplio;
    }

    public String getCorNumero() {
        return corNumero;
    }

    public void setCorNumero(String corNumero) {
        this.corNumero = corNumero;
    }

    public Integer getCorNumeroLarvas() {
        return corNumeroLarvas;
    }

    public void setCorNumeroLarvas(Integer corNumeroLarvas) {
        this.corNumeroLarvas = corNumeroLarvas;
    }

    public String getCorObservaciones() {
        return corObservaciones;
    }

    public void setCorObservaciones(String corObservaciones) {
        this.corObservaciones = corObservaciones;
    }

    public Short getCorPellet() {
        return corPellet;
    }

    public void setCorPellet(Short corPellet) {
        this.corPellet = corPellet;
    }

    public BigDecimal getCorValorVenta() {
        return corValorVenta;
    }

    public void setCorValorVenta(BigDecimal corValorVenta) {
        this.corValorVenta = corValorVenta;
    }
}
