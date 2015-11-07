/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ConDetalleTO implements Serializable {

    private String empCodigo;
    private String perCodigo;
    private String tipCodigo;
    private String conNumero;
    private Integer detSecuencia;
    private String conCtaCodigo;
    private String secCodigo;
    private String pisSector;
    private String pisNumero;
    private String detDocumento;
    private Character detDebitoCredito;
    private BigDecimal detValor;
    private Boolean detGenerado;
    private String detReferencia;
    private String detObservaciones;
    private Integer detOrden;
    private BigDecimal detSaldo;

    public ConDetalleTO() {
    }

    public ConDetalleTO(String empCodigo, String perCodigo, String tipCodigo, String conNumero, Integer detSecuencia, String conCtaCodigo, String secCodigo, String pisSector, String pisNumero, String detDocumento, Character detDebitoCredito, BigDecimal detValor, Boolean detGenerado, String detReferencia, String detObservaciones, Integer detOrden, BigDecimal detSaldo) {
        this.empCodigo = empCodigo;
        this.perCodigo = perCodigo;
        this.tipCodigo = tipCodigo;
        this.conNumero = conNumero;
        this.detSecuencia = detSecuencia;
        this.conCtaCodigo = conCtaCodigo;
        this.secCodigo = secCodigo;
        this.pisSector = pisSector;
        this.pisNumero = pisNumero;
        this.detDocumento = detDocumento;
        this.detDebitoCredito = detDebitoCredito;
        this.detValor = detValor;
        this.detGenerado = detGenerado;
        this.detReferencia = detReferencia;
        this.detObservaciones = detObservaciones;
        this.detOrden = detOrden;
        this.detSaldo = detSaldo;
    }

    public String getPisSector() {
        return pisSector;
    }

    public void setPisSector(String pisSector) {
        this.pisSector = pisSector;
    }

   

    public BigDecimal getDetSaldo() {
        return detSaldo;
    }

    public void setDetSaldo(BigDecimal detSaldo) {
        this.detSaldo = detSaldo;
    }

    public String getConCtaCodigo() {
        return conCtaCodigo;
    }

    public void setConCtaCodigo(String conCtaCodigo) {
        this.conCtaCodigo = conCtaCodigo;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public Character getDetDebitoCredito() {
        return detDebitoCredito;
    }

    public void setDetDebitoCredito(Character detDebitoCredito) {
        this.detDebitoCredito = detDebitoCredito;
    }

    public String getDetDocumento() {
        return detDocumento;
    }

    public void setDetDocumento(String detDocumento) {
        this.detDocumento = detDocumento;
    }

    public Boolean getDetGenerado() {
        return detGenerado;
    }

    public void setDetGenerado(Boolean detGenerado) {
        this.detGenerado = detGenerado;
    }

    public String getDetObservaciones() {
        return detObservaciones;
    }

    public void setDetObservaciones(String detObservaciones) {
        this.detObservaciones = detObservaciones;
    }

    public Integer getDetOrden() {
        return detOrden;
    }

    public void setDetOrden(Integer detOrden) {
        this.detOrden = detOrden;
    }

    public String getDetReferencia() {
        return detReferencia;
    }

    public void setDetReferencia(String detReferencia) {
        this.detReferencia = detReferencia;
    }

    public Integer getDetSecuencia() {
        return detSecuencia;
    }

    public void setDetSecuencia(Integer detSecuencia) {
        this.detSecuencia = detSecuencia;
    }

    public BigDecimal getDetValor() {
        return detValor;
    }

    public void setDetValor(BigDecimal detValor) {
        this.detValor = detValor;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    @Override
    public String toString() {
        return this.empCodigo + " " + this.perCodigo + " " + this.tipCodigo
                + " " + this.conNumero + " " + this.detSecuencia
                + " " + this.conCtaCodigo + " " + this.secCodigo
                + " " + this.pisNumero + " " + this.detDocumento
                + " " + this.detDebitoCredito + " " + this.detValor
                + " " + this.detGenerado + " " + this.detOrden;
    }
}
