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

public class RhListaConsolidadoRolesTO implements Serializable{
    private String crpCategoria;
    private String crpId;
    private String crpNombres;
    private BigDecimal crpDl;
    private BigDecimal crpDf;
    private BigDecimal crpDe;
    private BigDecimal crpDd;
    private BigDecimal crpDp;
    private BigDecimal crpSueldo;
    private BigDecimal crpBonos;
    private BigDecimal crpBonosnd;
    private BigDecimal crpBonoFijo;
    private BigDecimal crpBonoFijoNd;
    private BigDecimal crpOtrosIngresos;
    private BigDecimal crpOtrosIngresosNd;
    private BigDecimal crpSubtotalBonos;
    private BigDecimal crpSubtotalIngresos;
    private BigDecimal crpViaticos;
    private BigDecimal crpFondoReserva;
    private BigDecimal crpLiquidacion;
    private BigDecimal crpIngresos;
    private BigDecimal crpAnticipos;
    private BigDecimal crpPrestamos;
    private BigDecimal crpIess;
    private BigDecimal crpRetencion;
    private BigDecimal crpDescuentosFondoReserva;
    private BigDecimal crpDescuentos;
    private BigDecimal crpTotal;

    public RhListaConsolidadoRolesTO() {
    }

    public RhListaConsolidadoRolesTO(String crpCategoria, String crpId, String crpNombres, BigDecimal crpDl, BigDecimal crpDf, BigDecimal crpDe, BigDecimal crpDd, BigDecimal crpDp, BigDecimal crpSueldo, BigDecimal crpBonos, BigDecimal crpBonosnd, BigDecimal crpBonoFijo, BigDecimal crpBonoFijoNd, BigDecimal crpOtrosIngresos, BigDecimal crpOtrosIngresosNd, BigDecimal crpSubtotalBonos, BigDecimal crpSubtotalIngresos, BigDecimal crpViaticos, BigDecimal crpFondoReserva, BigDecimal crpLiquidacion, BigDecimal crpIngresos, BigDecimal crpAnticipos, BigDecimal crpPrestamos, BigDecimal crpIess, BigDecimal crpRetencion, BigDecimal crpDescuentosFondoReserva, BigDecimal crpDescuentos, BigDecimal crpTotal) {
        this.crpCategoria = crpCategoria;
        this.crpId = crpId;
        this.crpNombres = crpNombres;
        this.crpDl = crpDl;
        this.crpDf = crpDf;
        this.crpDe = crpDe;
        this.crpDd = crpDd;
        this.crpDp = crpDp;
        this.crpSueldo = crpSueldo;
        this.crpBonos = crpBonos;
        this.crpBonosnd = crpBonosnd;
        this.crpBonoFijo = crpBonoFijo;
        this.crpBonoFijoNd = crpBonoFijoNd;
        this.crpOtrosIngresos = crpOtrosIngresos;
        this.crpOtrosIngresosNd = crpOtrosIngresosNd;
        this.crpSubtotalBonos = crpSubtotalBonos;
        this.crpSubtotalIngresos = crpSubtotalIngresos;
        this.crpViaticos = crpViaticos;
        this.crpFondoReserva = crpFondoReserva;
        this.crpLiquidacion = crpLiquidacion;
        this.crpIngresos = crpIngresos;
        this.crpAnticipos = crpAnticipos;
        this.crpPrestamos = crpPrestamos;
        this.crpIess = crpIess;
        this.crpRetencion = crpRetencion;
        this.crpDescuentosFondoReserva = crpDescuentosFondoReserva;
        this.crpDescuentos = crpDescuentos;
        this.crpTotal = crpTotal;
    }

    public BigDecimal getCrpAnticipos() {
        return crpAnticipos;
    }

    public void setCrpAnticipos(BigDecimal crpAnticipos) {
        this.crpAnticipos = crpAnticipos;
    }

    public BigDecimal getCrpBonoFijo() {
        return crpBonoFijo;
    }

    public void setCrpBonoFijo(BigDecimal crpBonoFijo) {
        this.crpBonoFijo = crpBonoFijo;
    }

    public BigDecimal getCrpBonoFijoNd() {
        return crpBonoFijoNd;
    }

    public void setCrpBonoFijoNd(BigDecimal crpBonoFijoNd) {
        this.crpBonoFijoNd = crpBonoFijoNd;
    }

    public BigDecimal getCrpBonos() {
        return crpBonos;
    }

    public void setCrpBonos(BigDecimal crpBonos) {
        this.crpBonos = crpBonos;
    }

    public BigDecimal getCrpBonosnd() {
        return crpBonosnd;
    }

    public void setCrpBonosnd(BigDecimal crpBonosnd) {
        this.crpBonosnd = crpBonosnd;
    }

    public String getCrpCategoria() {
        return crpCategoria;
    }

    public void setCrpCategoria(String crpCategoria) {
        this.crpCategoria = crpCategoria;
    }

    public BigDecimal getCrpDd() {
        return crpDd;
    }

    public void setCrpDd(BigDecimal crpDd) {
        this.crpDd = crpDd;
    }

    public BigDecimal getCrpDe() {
        return crpDe;
    }

    public void setCrpDe(BigDecimal crpDe) {
        this.crpDe = crpDe;
    }

    public BigDecimal getCrpDescuentos() {
        return crpDescuentos;
    }

    public void setCrpDescuentos(BigDecimal crpDescuentos) {
        this.crpDescuentos = crpDescuentos;
    }

    public BigDecimal getCrpDescuentosFondoReserva() {
        return crpDescuentosFondoReserva;
    }

    public void setCrpDescuentosFondoReserva(BigDecimal crpDescuentosFondoReserva) {
        this.crpDescuentosFondoReserva = crpDescuentosFondoReserva;
    }

    public BigDecimal getCrpDf() {
        return crpDf;
    }

    public void setCrpDf(BigDecimal crpDf) {
        this.crpDf = crpDf;
    }

    public BigDecimal getCrpDl() {
        return crpDl;
    }

    public void setCrpDl(BigDecimal crpDl) {
        this.crpDl = crpDl;
    }

    public BigDecimal getCrpDp() {
        return crpDp;
    }

    public void setCrpDp(BigDecimal crpDp) {
        this.crpDp = crpDp;
    }

    public BigDecimal getCrpFondoReserva() {
        return crpFondoReserva;
    }

    public void setCrpFondoReserva(BigDecimal crpFondoReserva) {
        this.crpFondoReserva = crpFondoReserva;
    }

    public String getCrpId() {
        return crpId;
    }

    public void setCrpId(String crpId) {
        this.crpId = crpId;
    }

    public BigDecimal getCrpIess() {
        return crpIess;
    }

    public void setCrpIess(BigDecimal crpIess) {
        this.crpIess = crpIess;
    }

    public BigDecimal getCrpIngresos() {
        return crpIngresos;
    }

    public void setCrpIngresos(BigDecimal crpIngresos) {
        this.crpIngresos = crpIngresos;
    }

    public BigDecimal getCrpLiquidacion() {
        return crpLiquidacion;
    }

    public void setCrpLiquidacion(BigDecimal crpLiquidacion) {
        this.crpLiquidacion = crpLiquidacion;
    }

    public String getCrpNombres() {
        return crpNombres;
    }

    public void setCrpNombres(String crpNombres) {
        this.crpNombres = crpNombres;
    }

    public BigDecimal getCrpOtrosIngresos() {
        return crpOtrosIngresos;
    }

    public void setCrpOtrosIngresos(BigDecimal crpOtrosIngresos) {
        this.crpOtrosIngresos = crpOtrosIngresos;
    }

    public BigDecimal getCrpOtrosIngresosNd() {
        return crpOtrosIngresosNd;
    }

    public void setCrpOtrosIngresosNd(BigDecimal crpOtrosIngresosNd) {
        this.crpOtrosIngresosNd = crpOtrosIngresosNd;
    }

    public BigDecimal getCrpPrestamos() {
        return crpPrestamos;
    }

    public void setCrpPrestamos(BigDecimal crpPrestamos) {
        this.crpPrestamos = crpPrestamos;
    }

    public BigDecimal getCrpRetencion() {
        return crpRetencion;
    }

    public void setCrpRetencion(BigDecimal crpRetencion) {
        this.crpRetencion = crpRetencion;
    }

    public BigDecimal getCrpSubtotalBonos() {
        return crpSubtotalBonos;
    }

    public void setCrpSubtotalBonos(BigDecimal crpSubtotalBonos) {
        this.crpSubtotalBonos = crpSubtotalBonos;
    }

    public BigDecimal getCrpSubtotalIngresos() {
        return crpSubtotalIngresos;
    }

    public void setCrpSubtotalIngresos(BigDecimal crpSubtotalIngresos) {
        this.crpSubtotalIngresos = crpSubtotalIngresos;
    }

    public BigDecimal getCrpSueldo() {
        return crpSueldo;
    }

    public void setCrpSueldo(BigDecimal crpSueldo) {
        this.crpSueldo = crpSueldo;
    }

    public BigDecimal getCrpTotal() {
        return crpTotal;
    }

    public void setCrpTotal(BigDecimal crpTotal) {
        this.crpTotal = crpTotal;
    }

    public BigDecimal getCrpViaticos() {
        return crpViaticos;
    }

    public void setCrpViaticos(BigDecimal crpViaticos) {
        this.crpViaticos = crpViaticos;
    }

}
