/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Charly
 */
public class RhSalarioDignoTO implements Serializable{
    
    private String empEmpresa;
    private String empId;
    private String empApellidosNombres;
    
    private String sdigDesde;
    private String sdigHasta;
    private BigDecimal sdigValor;
    private String sdigFormaPago;
    private Boolean sdigReversado;
    private String secCodigo;
    
    private String conEmpresa;
    private String conPeriodo;
    private String conTipo;
    private String conNumero;
    private String conFecha;
    private String conDetDocumento;
    private String conObservaciones;
    
    private String usrCodigo;
    private Integer sdigSecuencial;

    public RhSalarioDignoTO(String empEmpresa, String empId, String empApellidosNombres, String sdigDesde, String sdigHasta, BigDecimal sdigValor, String sdigFormaPago, Boolean sdigReversado, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero, String conFecha, String conDetDocumento, String conObservaciones, String usrCodigo, Integer sdigSecuencial) {
        this.empEmpresa = empEmpresa;
        this.empId = empId;
        this.empApellidosNombres = empApellidosNombres;
        this.sdigDesde = sdigDesde;
        this.sdigHasta = sdigHasta;
        this.sdigValor = sdigValor;
        this.sdigFormaPago = sdigFormaPago;
        this.sdigReversado = sdigReversado;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
        this.conFecha = conFecha;
        this.conDetDocumento = conDetDocumento;
        this.conObservaciones = conObservaciones;
        this.usrCodigo = usrCodigo;
        this.sdigSecuencial = sdigSecuencial;
    }

   

    

    public String getEmpApellidosNombres() {
        return empApellidosNombres;
    }

    public void setEmpApellidosNombres(String empApellidosNombres) {
        this.empApellidosNombres = empApellidosNombres;
    }

    public RhSalarioDignoTO() {
    }

    public String getConDetDocumento() {
        return conDetDocumento;
    }

    public void setConDetDocumento(String conDetDocumento) {
        this.conDetDocumento = conDetDocumento;
    }

    public String getConEmpresa() {
        return conEmpresa;
    }

    public void setConEmpresa(String conEmpresa) {
        this.conEmpresa = conEmpresa;
    }

    public String getConFecha() {
        return conFecha;
    }

    public void setConFecha(String conFecha) {
        this.conFecha = conFecha;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConObservaciones() {
        return conObservaciones;
    }

    public void setConObservaciones(String conObservaciones) {
        this.conObservaciones = conObservaciones;
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

    public String getEmpEmpresa() {
        return empEmpresa;
    }

    public void setEmpEmpresa(String empEmpresa) {
        this.empEmpresa = empEmpresa;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getSdigDesde() {
        return sdigDesde;
    }

    public void setSdigDesde(String sdigDesde) {
        this.sdigDesde = sdigDesde;
    }

    public String getSdigFormaPago() {
        return sdigFormaPago;
    }

    public void setSdigFormaPago(String sdigFormaPago) {
        this.sdigFormaPago = sdigFormaPago;
    }

    public String getSdigHasta() {
        return sdigHasta;
    }

    public void setSdigHasta(String sdigHasta) {
        this.sdigHasta = sdigHasta;
    }

    public Boolean getSdigReversado() {
        return sdigReversado;
    }

    public void setSdigReversado(Boolean sdigReversado) {
        this.sdigReversado = sdigReversado;
    }

    public Integer getSdigSecuencial() {
        return sdigSecuencial;
    }

    public void setSdigSecuencial(Integer sdigSecuencial) {
        this.sdigSecuencial = sdigSecuencial;
    }

    public BigDecimal getSdigValor() {
        return sdigValor;
    }

    public void setSdigValor(BigDecimal sdigValor) {
        this.sdigValor = sdigValor;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

}
