/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class RhCategoriaTO implements Serializable {

    private String empCodigo;
    private String catNombre;
    //CUENTAS DE SUELDOS
    private String ctaAnticipos;
    private String ctaPrestamos;
    private String ctaPorPagarBonos;
    private String ctaPorPagarSueldo;
    private String ctaPorPagarImpuestoRenta;
    private String ctaPorPagarUtilidades;
    private String ctaGastoBonos;
    private String ctaGastoBonosNd;
    private String ctaGastoBonoFijo;
    private String ctaGastoBonoFijoNd;
    private String ctaGastoOtrosIngresos;
    private String ctaGastoOtrosIngresosNd;
    private String ctaGastoSueldos;
    private String ctaAportepersonal;
    //CUENTAS PROVISIONES POR PAGAR
    private String ctaAportepatronal;
    private String ctaIece;
    private String ctaSecap;
    private String ctaXiii;
    private String ctaXiv;
    private String ctaFondoreserva;
    private String ctaVacaciones;
    private String ctaDesahucio;
    //CUENTAS GASTO PROVISIONES
    private String ctaGastoAporteindividual;
    private String ctaGastoAportepatronal;
    private String ctaGastoIece;
    private String ctaGastoSecap;
    private String ctaGastoXiii;
    private String ctaGastoXiv;
    private String ctaGastoFondoreserva;
    private String ctaGastoVacaciones;
    private String ctaGastoSalarioDigno;
    private String ctaGastoBonoLiquidacion;
    private String ctaGastoDesahucio;
    private String ctaGastoDesahucioIntempestivo;
    private String tipCodigo;
    private String usrInsertaCategoria;
    private String usrFechaInsertaCategoria;

    public RhCategoriaTO() {
    }

    public RhCategoriaTO(String empCodigo, String catNombre, String ctaAnticipos, String ctaPrestamos, String ctaPorPagarBonos, String ctaPorPagarSueldo, String ctaPorPagarImpuestoRenta, String ctaPorPagarUtilidades, String ctaGastoBonos, String ctaGastoBonosNd, String ctaGastoBonoFijo, String ctaGastoBonoFijoNd, String ctaGastoOtrosIngresos, String ctaGastoOtrosIngresosNd, String ctaGastoSueldos, String ctaAportepersonal, String ctaAportepatronal, String ctaIece, String ctaSecap, String ctaXiii, String ctaXiv, String ctaFondoreserva, String ctaVacaciones, String ctaDesahucio, String ctaGastoAporteindividual, String ctaGastoAportepatronal, String ctaGastoIece, String ctaGastoSecap, String ctaGastoXiii, String ctaGastoXiv, String ctaGastoFondoreserva, String ctaGastoVacaciones, String ctaGastoSalarioDigno, String ctaGastoBonoLiquidacion, String ctaGastoDesahucio, String ctaGastoDesahucioIntempestivo, String tipCodigo, String usrInsertaCategoria, String usrFechaInsertaCategoria) {
        this.empCodigo = empCodigo;
        this.catNombre = catNombre;
        this.ctaAnticipos = ctaAnticipos;
        this.ctaPrestamos = ctaPrestamos;
        this.ctaPorPagarBonos = ctaPorPagarBonos;
        this.ctaPorPagarSueldo = ctaPorPagarSueldo;
        this.ctaPorPagarImpuestoRenta = ctaPorPagarImpuestoRenta;
        this.ctaPorPagarUtilidades = ctaPorPagarUtilidades;
        this.ctaGastoBonos = ctaGastoBonos;
        this.ctaGastoBonosNd = ctaGastoBonosNd;
        this.ctaGastoBonoFijo = ctaGastoBonoFijo;
        this.ctaGastoBonoFijoNd = ctaGastoBonoFijoNd;
        this.ctaGastoOtrosIngresos = ctaGastoOtrosIngresos;
        this.ctaGastoOtrosIngresosNd = ctaGastoOtrosIngresosNd;
        this.ctaGastoSueldos = ctaGastoSueldos;
        this.ctaAportepersonal = ctaAportepersonal;
        this.ctaAportepatronal = ctaAportepatronal;
        this.ctaIece = ctaIece;
        this.ctaSecap = ctaSecap;
        this.ctaXiii = ctaXiii;
        this.ctaXiv = ctaXiv;
        this.ctaFondoreserva = ctaFondoreserva;
        this.ctaVacaciones = ctaVacaciones;
        this.ctaDesahucio = ctaDesahucio;
        this.ctaGastoAporteindividual = ctaGastoAporteindividual;
        this.ctaGastoAportepatronal = ctaGastoAportepatronal;
        this.ctaGastoIece = ctaGastoIece;
        this.ctaGastoSecap = ctaGastoSecap;
        this.ctaGastoXiii = ctaGastoXiii;
        this.ctaGastoXiv = ctaGastoXiv;
        this.ctaGastoFondoreserva = ctaGastoFondoreserva;
        this.ctaGastoVacaciones = ctaGastoVacaciones;
        this.ctaGastoSalarioDigno = ctaGastoSalarioDigno;
        this.ctaGastoBonoLiquidacion = ctaGastoBonoLiquidacion;
        this.ctaGastoDesahucio = ctaGastoDesahucio;
        this.ctaGastoDesahucioIntempestivo = ctaGastoDesahucioIntempestivo;
        this.tipCodigo = tipCodigo;
        this.usrInsertaCategoria = usrInsertaCategoria;
        this.usrFechaInsertaCategoria = usrFechaInsertaCategoria;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getCtaAnticipos() {
        return ctaAnticipos;
    }

    public void setCtaAnticipos(String ctaAnticipos) {
        this.ctaAnticipos = ctaAnticipos;
    }

    public String getCtaAportepatronal() {
        return ctaAportepatronal;
    }

    public void setCtaAportepatronal(String ctaAportepatronal) {
        this.ctaAportepatronal = ctaAportepatronal;
    }

    public String getCtaAportepersonal() {
        return ctaAportepersonal;
    }

    public void setCtaAportepersonal(String ctaAportepersonal) {
        this.ctaAportepersonal = ctaAportepersonal;
    }

    public String getCtaDesahucio() {
        return ctaDesahucio;
    }

    public void setCtaDesahucio(String ctaDesahucio) {
        this.ctaDesahucio = ctaDesahucio;
    }

    public String getCtaFondoreserva() {
        return ctaFondoreserva;
    }

    public void setCtaFondoreserva(String ctaFondoreserva) {
        this.ctaFondoreserva = ctaFondoreserva;
    }

    public String getCtaGastoAporteindividual() {
        return ctaGastoAporteindividual;
    }

    public void setCtaGastoAporteindividual(String ctaGastoAporteindividual) {
        this.ctaGastoAporteindividual = ctaGastoAporteindividual;
    }

    public String getCtaGastoAportepatronal() {
        return ctaGastoAportepatronal;
    }

    public void setCtaGastoAportepatronal(String ctaGastoAportepatronal) {
        this.ctaGastoAportepatronal = ctaGastoAportepatronal;
    }

    public String getCtaGastoBonoFijo() {
        return ctaGastoBonoFijo;
    }

    public void setCtaGastoBonoFijo(String ctaGastoBonoFijo) {
        this.ctaGastoBonoFijo = ctaGastoBonoFijo;
    }

    public String getCtaGastoBonoFijoNd() {
        return ctaGastoBonoFijoNd;
    }

    public void setCtaGastoBonoFijoNd(String ctaGastoBonoFijoNd) {
        this.ctaGastoBonoFijoNd = ctaGastoBonoFijoNd;
    }

    public String getCtaGastoBonoLiquidacion() {
        return ctaGastoBonoLiquidacion;
    }

    public void setCtaGastoBonoLiquidacion(String ctaGastoBonoLiquidacion) {
        this.ctaGastoBonoLiquidacion = ctaGastoBonoLiquidacion;
    }

    public String getCtaGastoBonos() {
        return ctaGastoBonos;
    }

    public void setCtaGastoBonos(String ctaGastoBonos) {
        this.ctaGastoBonos = ctaGastoBonos;
    }

    public String getCtaGastoBonosNd() {
        return ctaGastoBonosNd;
    }

    public void setCtaGastoBonosNd(String ctaGastoBonosNd) {
        this.ctaGastoBonosNd = ctaGastoBonosNd;
    }

    public String getCtaGastoDesahucio() {
        return ctaGastoDesahucio;
    }

    public void setCtaGastoDesahucio(String ctaGastoDesahucio) {
        this.ctaGastoDesahucio = ctaGastoDesahucio;
    }

    public String getCtaGastoDesahucioIntempestivo() {
        return ctaGastoDesahucioIntempestivo;
    }

    public void setCtaGastoDesahucioIntempestivo(String ctaGastoDesahucioIntempestivo) {
        this.ctaGastoDesahucioIntempestivo = ctaGastoDesahucioIntempestivo;
    }

    public String getCtaGastoFondoreserva() {
        return ctaGastoFondoreserva;
    }

    public void setCtaGastoFondoreserva(String ctaGastoFondoreserva) {
        this.ctaGastoFondoreserva = ctaGastoFondoreserva;
    }

    public String getCtaGastoIece() {
        return ctaGastoIece;
    }

    public void setCtaGastoIece(String ctaGastoIece) {
        this.ctaGastoIece = ctaGastoIece;
    }

    public String getCtaGastoOtrosIngresos() {
        return ctaGastoOtrosIngresos;
    }

    public void setCtaGastoOtrosIngresos(String ctaGastoOtrosIngresos) {
        this.ctaGastoOtrosIngresos = ctaGastoOtrosIngresos;
    }

    public String getCtaGastoOtrosIngresosNd() {
        return ctaGastoOtrosIngresosNd;
    }

    public void setCtaGastoOtrosIngresosNd(String ctaGastoOtrosIngresosNd) {
        this.ctaGastoOtrosIngresosNd = ctaGastoOtrosIngresosNd;
    }

    public String getCtaGastoSalarioDigno() {
        return ctaGastoSalarioDigno;
    }

    public void setCtaGastoSalarioDigno(String ctaGastoSalarioDigno) {
        this.ctaGastoSalarioDigno = ctaGastoSalarioDigno;
    }

    public String getCtaGastoSecap() {
        return ctaGastoSecap;
    }

    public void setCtaGastoSecap(String ctaGastoSecap) {
        this.ctaGastoSecap = ctaGastoSecap;
    }

    public String getCtaGastoSueldos() {
        return ctaGastoSueldos;
    }

    public void setCtaGastoSueldos(String ctaGastoSueldos) {
        this.ctaGastoSueldos = ctaGastoSueldos;
    }

    public String getCtaGastoVacaciones() {
        return ctaGastoVacaciones;
    }

    public void setCtaGastoVacaciones(String ctaGastoVacaciones) {
        this.ctaGastoVacaciones = ctaGastoVacaciones;
    }

    public String getCtaGastoXiii() {
        return ctaGastoXiii;
    }

    public void setCtaGastoXiii(String ctaGastoXiii) {
        this.ctaGastoXiii = ctaGastoXiii;
    }

    public String getCtaGastoXiv() {
        return ctaGastoXiv;
    }

    public void setCtaGastoXiv(String ctaGastoXiv) {
        this.ctaGastoXiv = ctaGastoXiv;
    }

    public String getCtaIece() {
        return ctaIece;
    }

    public void setCtaIece(String ctaIece) {
        this.ctaIece = ctaIece;
    }

    public String getCtaPorPagarBonos() {
        return ctaPorPagarBonos;
    }

    public void setCtaPorPagarBonos(String ctaPorPagarBonos) {
        this.ctaPorPagarBonos = ctaPorPagarBonos;
    }

    public String getCtaPorPagarImpuestoRenta() {
        return ctaPorPagarImpuestoRenta;
    }

    public void setCtaPorPagarImpuestoRenta(String ctaPorPagarImpuestoRenta) {
        this.ctaPorPagarImpuestoRenta = ctaPorPagarImpuestoRenta;
    }

    public String getCtaPorPagarSueldo() {
        return ctaPorPagarSueldo;
    }

    public void setCtaPorPagarSueldo(String ctaPorPagarSueldo) {
        this.ctaPorPagarSueldo = ctaPorPagarSueldo;
    }

    public String getCtaPorPagarUtilidades() {
        return ctaPorPagarUtilidades;
    }

    public void setCtaPorPagarUtilidades(String ctaPorPagarUtilidades) {
        this.ctaPorPagarUtilidades = ctaPorPagarUtilidades;
    }

    public String getCtaPrestamos() {
        return ctaPrestamos;
    }

    public void setCtaPrestamos(String ctaPrestamos) {
        this.ctaPrestamos = ctaPrestamos;
    }

    public String getCtaSecap() {
        return ctaSecap;
    }

    public void setCtaSecap(String ctaSecap) {
        this.ctaSecap = ctaSecap;
    }

    public String getCtaVacaciones() {
        return ctaVacaciones;
    }

    public void setCtaVacaciones(String ctaVacaciones) {
        this.ctaVacaciones = ctaVacaciones;
    }

    public String getCtaXiii() {
        return ctaXiii;
    }

    public void setCtaXiii(String ctaXiii) {
        this.ctaXiii = ctaXiii;
    }

    public String getCtaXiv() {
        return ctaXiv;
    }

    public void setCtaXiv(String ctaXiv) {
        this.ctaXiv = ctaXiv;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getUsrFechaInsertaCategoria() {
        return usrFechaInsertaCategoria;
    }

    public void setUsrFechaInsertaCategoria(String usrFechaInsertaCategoria) {
        this.usrFechaInsertaCategoria = usrFechaInsertaCategoria;
    }

    public String getUsrInsertaCategoria() {
        return usrInsertaCategoria;
    }

    public void setUsrInsertaCategoria(String usrInsertaCategoria) {
        this.usrInsertaCategoria = usrInsertaCategoria;
    }
}
