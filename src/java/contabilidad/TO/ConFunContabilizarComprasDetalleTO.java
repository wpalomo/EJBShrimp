/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author developer1
 */
public class ConFunContabilizarComprasDetalleTO implements Serializable  {

    private Long detSecuencia;
    private String detDocumento;
    private Character detDebitoCredito;
    private BigDecimal detValor;
    private BigDecimal detSaldo;
    private Boolean detGenerado;
    private String detReferencia;
    private String detObservaciones;
    private Integer detOrden;
    private String secEmpresa;
    private String secCodigo;
    private String pisEmpresa;
    private String pisSector;
    private String pisNumero;
    private String conEmpresa;
    private String conPeriodo;
    private String conTipo;
    private String conNumero;
    private String ctaEmpresa;
    private String ctaCodigo;

    public ConFunContabilizarComprasDetalleTO() {
    }

    public ConFunContabilizarComprasDetalleTO(Long detSecuencia, String detDocumento, Character detDebitoCredito, BigDecimal detValor, BigDecimal detSaldo, Boolean detGenerado, String detReferencia, String detObservaciones, Integer detOrden, String secEmpresa, String secCodigo, String pisEmpresa, String pisSector, String pisNumero, String conEmpresa, String conPeriodo, String conTipo, String conNumero, String ctaEmpresa, String ctaCodigo) {
        this.detSecuencia = detSecuencia;
        this.detDocumento = detDocumento;
        this.detDebitoCredito = detDebitoCredito;
        this.detValor = detValor;
        this.detSaldo = detSaldo;
        this.detGenerado = detGenerado;
        this.detReferencia = detReferencia;
        this.detObservaciones = detObservaciones;
        this.detOrden = detOrden;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.pisEmpresa = pisEmpresa;
        this.pisSector = pisSector;
        this.pisNumero = pisNumero;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
        this.ctaEmpresa = ctaEmpresa;
        this.ctaCodigo = ctaCodigo;
    }


    public String getConEmpresa() {
        return conEmpresa;
    }

    public void setConEmpresa(String conEmpresa) {
        this.conEmpresa = conEmpresa;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConPeriodo() {
        return conPeriodo;
    }

    public void setConPeriodo(String conPeriodo) {
        this.conPeriodo = conPeriodo;
    }

    public String getConTipo() {
        return conTipo;
    }

    public void setConTipo(String conTipo) {
        this.conTipo = conTipo;
    }

    public String getCtaCodigo() {
        return ctaCodigo;
    }

    public void setCtaCodigo(String ctaCodigo) {
        this.ctaCodigo = ctaCodigo;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getDetDocumento() {
        return detDocumento;
    }

    public void setDetDocumento(String detDocumento) {
        this.detDocumento = detDocumento;
    }

    public Character getDetDebitoCredito() {
        return detDebitoCredito;
    }

    public void setDetDebitoCredito(Character detDebitoCredito) {
        this.detDebitoCredito = detDebitoCredito;
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

    public BigDecimal getDetSaldo() {
        return detSaldo;
    }

    public void setDetSaldo(BigDecimal detSaldo) {
        this.detSaldo = detSaldo;
    }

    public Long getDetSecuencia() {
        return detSecuencia;
    }

    public void setDetSecuencia(Long detSecuencia) {
        this.detSecuencia = detSecuencia;
    }

    public BigDecimal getDetValor() {
        return detValor;
    }

    public void setDetValor(BigDecimal detValor) {
        this.detValor = detValor;
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

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getSecEmpresa() {
        return secEmpresa;
    }

    public void setSecEmpresa(String secEmpresa) {
        this.secEmpresa = secEmpresa;
    }
    
}
