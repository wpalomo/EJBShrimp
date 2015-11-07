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
public class RhListaProvisionesTO implements Serializable{
    private String provCategoria;
    private String provId;
    private String provNombres;
    private BigDecimal provSueldo;
    private BigDecimal provDiasPagados;
    private BigDecimal provAporteIndividual;
    private BigDecimal provAportePatronal;
    private BigDecimal provIece;
    private BigDecimal provSecap;
    private BigDecimal provXiii;
    private BigDecimal provXiv;
    private BigDecimal provFondoReserva;
    private BigDecimal provVacaciones;
    private BigDecimal provDesahucio;
    private Integer provSecuencial;
    private String provContableRol;
    private String provContableProvision;

    public RhListaProvisionesTO() {
    }

    public RhListaProvisionesTO(String provCategoria, String provId, String provNombres, BigDecimal provSueldo, BigDecimal provDiasPagados, BigDecimal provAporteIndividual, BigDecimal provAportePatronal, BigDecimal provIece, BigDecimal provSecap, BigDecimal provXiii, BigDecimal provXiv, BigDecimal provFondoReserva, BigDecimal provVacaciones, BigDecimal provDesahucio, Integer provSecuencial, String provContableRol, String provContableProvision) {
        this.provCategoria = provCategoria;
        this.provId = provId;
        this.provNombres = provNombres;
        this.provSueldo = provSueldo;
        this.provDiasPagados = provDiasPagados;
        this.provAporteIndividual = provAporteIndividual;
        this.provAportePatronal = provAportePatronal;
        this.provIece = provIece;
        this.provSecap = provSecap;
        this.provXiii = provXiii;
        this.provXiv = provXiv;
        this.provFondoReserva = provFondoReserva;
        this.provVacaciones = provVacaciones;
        this.provDesahucio = provDesahucio;
        this.provSecuencial = provSecuencial;
        this.provContableRol = provContableRol;
        this.provContableProvision = provContableProvision;
    }

    public BigDecimal getProvAporteIndividual() {
        return provAporteIndividual;
    }

    public void setProvAporteIndividual(BigDecimal provAporteIndividual) {
        this.provAporteIndividual = provAporteIndividual;
    }

    public BigDecimal getProvAportePatronal() {
        return provAportePatronal;
    }

    public void setProvAportePatronal(BigDecimal provAportePatronal) {
        this.provAportePatronal = provAportePatronal;
    }

    public String getProvCategoria() {
        return provCategoria;
    }

    public void setProvCategoria(String provCategoria) {
        this.provCategoria = provCategoria;
    }

    public String getProvContableProvision() {
        return provContableProvision;
    }

    public void setProvContableProvision(String provContableProvision) {
        this.provContableProvision = provContableProvision;
    }

    public String getProvContableRol() {
        return provContableRol;
    }

    public void setProvContableRol(String provContableRol) {
        this.provContableRol = provContableRol;
    }

    public BigDecimal getProvDesahucio() {
        return provDesahucio;
    }

    public void setProvDesahucio(BigDecimal provDesahucio) {
        this.provDesahucio = provDesahucio;
    }

    public BigDecimal getProvDiasPagados() {
        return provDiasPagados;
    }

    public void setProvDiasPagados(BigDecimal provDiasPagados) {
        this.provDiasPagados = provDiasPagados;
    }

    public BigDecimal getProvFondoReserva() {
        return provFondoReserva;
    }

    public void setProvFondoReserva(BigDecimal provFondoReserva) {
        this.provFondoReserva = provFondoReserva;
    }

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public BigDecimal getProvIece() {
        return provIece;
    }

    public void setProvIece(BigDecimal provIece) {
        this.provIece = provIece;
    }

    public String getProvNombres() {
        return provNombres;
    }

    public void setProvNombres(String provNombres) {
        this.provNombres = provNombres;
    }

    public BigDecimal getProvSecap() {
        return provSecap;
    }

    public void setProvSecap(BigDecimal provSecap) {
        this.provSecap = provSecap;
    }

    public Integer getProvSecuencial() {
        return provSecuencial;
    }

    public void setProvSecuencial(Integer provSecuencial) {
        this.provSecuencial = provSecuencial;
    }

    public BigDecimal getProvSueldo() {
        return provSueldo;
    }

    public void setProvSueldo(BigDecimal provSueldo) {
        this.provSueldo = provSueldo;
    }

    public BigDecimal getProvVacaciones() {
        return provVacaciones;
    }

    public void setProvVacaciones(BigDecimal provVacaciones) {
        this.provVacaciones = provVacaciones;
    }

    public BigDecimal getProvXiii() {
        return provXiii;
    }

    public void setProvXiii(BigDecimal provXiii) {
        this.provXiii = provXiii;
    }

    public BigDecimal getProvXiv() {
        return provXiv;
    }

    public void setProvXiv(BigDecimal provXiv) {
        this.provXiv = provXiv;
    }
}