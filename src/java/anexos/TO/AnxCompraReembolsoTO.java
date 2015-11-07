/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author javier tj
 */
public class AnxCompraReembolsoTO implements Serializable{
    private Integer reembSecuencial;
    private String reembDocumentoTipo;
    private String reembDocumentoNumero;
    private String reembFechaemision;
    private String reembAutorizacion;
    private BigDecimal reembBaseimponible;
    private BigDecimal reembBaseimpgrav;
    private BigDecimal reembBasenograiva;
    private BigDecimal reembMontoice;
    private BigDecimal reembMontoiva;
    private String provEmpresa;
    private String provCodigo;
    private String compEmpresa;
    private String compPeriodo;
    private String compMotivo;
    private String compNumero;
    private String auxDocTipo_Abreviatura;
    private String auxProvNombre;
    private String auxProvRUC;

    public AnxCompraReembolsoTO() {
    }

    public AnxCompraReembolsoTO(
            Integer reembSecuencial, 
            String reembDocumentoTipo, 
            String reembDocumentoNumero, 
            String reembFechaemision, 
            String reembAutorizacion, 
            BigDecimal reembBaseimponible, 
            BigDecimal reembBaseimpgrav, 
            BigDecimal reembBasenograiva, 
            BigDecimal reembMontoice, 
            BigDecimal reembMontoiva, 
            String provEmpresa, 
            String provCodigo, 
            String compEmpresa, 
            String compPeriodo, 
            String compMotivo, 
            String compNumero) {
        this.reembSecuencial = reembSecuencial;
        this.reembDocumentoTipo = reembDocumentoTipo;
        this.reembDocumentoNumero = reembDocumentoNumero;
        this.reembFechaemision = reembFechaemision;
        this.reembAutorizacion = reembAutorizacion;
        this.reembBaseimponible = reembBaseimponible;
        this.reembBaseimpgrav = reembBaseimpgrav;
        this.reembBasenograiva = reembBasenograiva;
        this.reembMontoice = reembMontoice;
        this.reembMontoiva = reembMontoiva;
        this.provEmpresa = provEmpresa;
        this.provCodigo = provCodigo;
        this.compEmpresa = compEmpresa;
        this.compPeriodo = compPeriodo;
        this.compMotivo = compMotivo;
        this.compNumero = compNumero;
    }

    public String getCompEmpresa() {
        return compEmpresa;
    }

    public void setCompEmpresa(String compEmpresa) {
        this.compEmpresa = compEmpresa;
    }

    public String getCompMotivo() {
        return compMotivo;
    }

    public void setCompMotivo(String compMotivo) {
        this.compMotivo = compMotivo;
    }

    public String getCompNumero() {
        return compNumero;
    }

    public void setCompNumero(String compNumero) {
        this.compNumero = compNumero;
    }

    public String getCompPeriodo() {
        return compPeriodo;
    }

    public void setCompPeriodo(String compPeriodo) {
        this.compPeriodo = compPeriodo;
    }

    public String getProvCodigo() {
        return provCodigo;
    }

    public void setProvCodigo(String provCodigo) {
        this.provCodigo = provCodigo;
    }

    public String getProvEmpresa() {
        return provEmpresa;
    }

    public void setProvEmpresa(String provEmpresa) {
        this.provEmpresa = provEmpresa;
    }

    public String getReembAutorizacion() {
        return reembAutorizacion;
    }

    public void setReembAutorizacion(String reembAutorizacion) {
        this.reembAutorizacion = reembAutorizacion;
    }

    public BigDecimal getReembBaseimpgrav() {
        return reembBaseimpgrav;
    }

    public void setReembBaseimpgrav(BigDecimal reembBaseimpgrav) {
        this.reembBaseimpgrav = reembBaseimpgrav;
    }

    public BigDecimal getReembBaseimponible() {
        return reembBaseimponible;
    }

    public void setReembBaseimponible(BigDecimal reembBaseimponible) {
        this.reembBaseimponible = reembBaseimponible;
    }

    public BigDecimal getReembBasenograiva() {
        return reembBasenograiva;
    }

    public void setReembBasenograiva(BigDecimal reembBasenograiva) {
        this.reembBasenograiva = reembBasenograiva;
    }

    public String getReembDocumentoNumero() {
        return reembDocumentoNumero;
    }

    public void setReembDocumentoNumero(String reembDocumentoNumero) {
        this.reembDocumentoNumero = reembDocumentoNumero;
    }

    public String getReembDocumentoTipo() {
        return reembDocumentoTipo;
    }

    public void setReembDocumentoTipo(String reembDocumentoTipo) {
        this.reembDocumentoTipo = reembDocumentoTipo;
    }

    public String getReembFechaemision() {
        return reembFechaemision;
    }

    public void setReembFechaemision(String reembFechaemision) {
        this.reembFechaemision = reembFechaemision;
    }

    public BigDecimal getReembMontoice() {
        return reembMontoice;
    }

    public void setReembMontoice(BigDecimal reembMontoice) {
        this.reembMontoice = reembMontoice;
    }

    public BigDecimal getReembMontoiva() {
        return reembMontoiva;
    }

    public void setReembMontoiva(BigDecimal reembMontoiva) {
        this.reembMontoiva = reembMontoiva;
    }

    public Integer getReembSecuencial() {
        return reembSecuencial;
    }

    public void setReembSecuencial(Integer reembSecuencial) {
        this.reembSecuencial = reembSecuencial;
    }

    public String getAuxDocTipo_Abreviatura() {
        return auxDocTipo_Abreviatura;
    }

    public void setAuxDocTipo_Abreviatura(String auxDocTipo_Abreviatura) {
        this.auxDocTipo_Abreviatura = auxDocTipo_Abreviatura;
    }

    public String getAuxProvNombre() {
        return auxProvNombre;
    }

    public void setAuxProvNombre(String auxProvNombre) {
        this.auxProvNombre = auxProvNombre;
    }

    public String getAuxProvRUC() {
        return auxProvRUC;
    }

    public void setAuxProvRUC(String auxProvRUC) {
        this.auxProvRUC = auxProvRUC;
    }
    
}
