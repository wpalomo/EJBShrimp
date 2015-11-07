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
public class PrdCorridaTO implements Serializable{
    private String corEmpresa;
    private String corSector;
    private String corPiscina;
    private String corNumero;
    private BigDecimal corHectareas;
    private String corFechaDesde;
    private String corFechaSiembra;
    private String corFechaPesca;
    private String corFechaHasta;
    private Integer corNumeroLarvas;
    private String corLaboratorio;
    private String corNauplio;
    private Short corPellet;
    private BigDecimal corBiomasa;
    private BigDecimal corValorVenta;
    private String corObservaciones;
    private Boolean corActiva;
    private String pisEmpresa;
    private String pisSector;
    private String pisNumero;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInsertaCorrida;

    public PrdCorridaTO() {
    }

    public PrdCorridaTO(String corEmpresa, String corSector, String corPiscina, String corNumero, BigDecimal corHectareas, String corFechaDesde, String corFechaSiembra, String corFechaPesca, String corFechaHasta, Integer corNumeroLarvas, String corLaboratorio, String corNauplio, Short corPellet, BigDecimal corBiomasa, BigDecimal corValorVenta, String corObservaciones, Boolean corActiva, String pisEmpresa, String pisSector, String pisNumero, String usrEmpresa, String usrCodigo, String usrFechaInsertaCorrida) {
        this.corEmpresa = corEmpresa;
        this.corSector = corSector;
        this.corPiscina = corPiscina;
        this.corNumero = corNumero;
        this.corHectareas = corHectareas;
        this.corFechaDesde = corFechaDesde;
        this.corFechaSiembra = corFechaSiembra;
        this.corFechaPesca = corFechaPesca;
        this.corFechaHasta = corFechaHasta;
        this.corNumeroLarvas = corNumeroLarvas;
        this.corLaboratorio = corLaboratorio;
        this.corNauplio = corNauplio;
        this.corPellet = corPellet;
        this.corBiomasa = corBiomasa;
        this.corValorVenta = corValorVenta;
        this.corObservaciones = corObservaciones;
        this.corActiva = corActiva;
        this.pisEmpresa = pisEmpresa;
        this.pisSector = pisSector;
        this.pisNumero = pisNumero;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInsertaCorrida = usrFechaInsertaCorrida;
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

    public String getCorEmpresa() {
        return corEmpresa;
    }

    public void setCorEmpresa(String corEmpresa) {
        this.corEmpresa = corEmpresa;
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

    public String getCorPiscina() {
        return corPiscina;
    }

    public void setCorPiscina(String corPiscina) {
        this.corPiscina = corPiscina;
    }

    public String getCorSector() {
        return corSector;
    }

    public void setCorSector(String corSector) {
        this.corSector = corSector;
    }

    public BigDecimal getCorValorVenta() {
        return corValorVenta;
    }

    public void setCorValorVenta(BigDecimal corValorVenta) {
        this.corValorVenta = corValorVenta;
    }

    public String getPisEmpresa() {
        return pisEmpresa;
    }

    public void setPisEmpresa(String pisEmpresa) {
        this.pisEmpresa = pisEmpresa;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
    }

    public String getPisSector() {
        return pisSector;
    }

    public void setPisSector(String pisSector) {
        this.pisSector = pisSector;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrFechaInsertaCorrida() {
        return usrFechaInsertaCorrida;
    }

    public void setUsrFechaInsertaCorrida(String usrFechaInsertaCorrida) {
        this.usrFechaInsertaCorrida = usrFechaInsertaCorrida;
    }
}
