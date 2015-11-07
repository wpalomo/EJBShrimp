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
public class RhCategoriaProvisionesTO implements Serializable{
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
    private String ctaGastoAportepatronal;
    private String ctaGastoIece;
    private String ctaGastoSecap;
    private String ctaGastoXiii;
    private String ctaGastoXiv;
    private String ctaGastoFondoreserva;
    private String ctaGastoVacaciones;
    private String ctaGastoDesahucio;

    public RhCategoriaProvisionesTO() {
    }

    public RhCategoriaProvisionesTO(String ctaAportepatronal, String ctaIece, String ctaSecap, String ctaXiii, String ctaXiv, String ctaFondoreserva, String ctaVacaciones, String ctaDesahucio, String ctaGastoAportepatronal, String ctaGastoIece, String ctaGastoSecap, String ctaGastoXiii, String ctaGastoXiv, String ctaGastoFondoreserva, String ctaGastoVacaciones, String ctaGastoDesahucio) {
        this.ctaAportepatronal = ctaAportepatronal;
        this.ctaIece = ctaIece;
        this.ctaSecap = ctaSecap;
        this.ctaXiii = ctaXiii;
        this.ctaXiv = ctaXiv;
        this.ctaFondoreserva = ctaFondoreserva;
        this.ctaVacaciones = ctaVacaciones;
        this.ctaDesahucio = ctaDesahucio;
        this.ctaGastoAportepatronal = ctaGastoAportepatronal;
        this.ctaGastoIece = ctaGastoIece;
        this.ctaGastoSecap = ctaGastoSecap;
        this.ctaGastoXiii = ctaGastoXiii;
        this.ctaGastoXiv = ctaGastoXiv;
        this.ctaGastoFondoreserva = ctaGastoFondoreserva;
        this.ctaGastoVacaciones = ctaGastoVacaciones;
        this.ctaGastoDesahucio = ctaGastoDesahucio;
    }

    public String getCtaAportepatronal() {
        return ctaAportepatronal;
    }

    public void setCtaAportepatronal(String ctaAportepatronal) {
        this.ctaAportepatronal = ctaAportepatronal;
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

    public String getCtaGastoAportepatronal() {
        return ctaGastoAportepatronal;
    }

    public void setCtaGastoAportepatronal(String ctaGastoAportepatronal) {
        this.ctaGastoAportepatronal = ctaGastoAportepatronal;
    }

    public String getCtaGastoDesahucio() {
        return ctaGastoDesahucio;
    }

    public void setCtaGastoDesahucio(String ctaGastoDesahucio) {
        this.ctaGastoDesahucio = ctaGastoDesahucio;
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

    public String getCtaGastoSecap() {
        return ctaGastoSecap;
    }

    public void setCtaGastoSecap(String ctaGastoSecap) {
        this.ctaGastoSecap = ctaGastoSecap;
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
}