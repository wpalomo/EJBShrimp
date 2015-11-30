/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cartera.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class CarCobrosDetalleFormaTO implements Serializable{

//    private Integer detSecuencial;
    private String detBanco;
    private String detCuenta;
    private String detFechaPst;
    private String detReferencia;
    private BigDecimal detValor;    
    private String detObservaciones;
   
    
    private String banEmpresa;
    private String banCodigo;
    
    private String cobEmpresa;
    private String cobPeriodo;
    private String cobMotivo;
    private String cobNumero;
    private String secCodigo;    
    private Integer fpSecuencial;

    

//    private String conDetDocumento;

    public CarCobrosDetalleFormaTO() {
    }

    public CarCobrosDetalleFormaTO(BigDecimal detValor, String detReferencia, String detObservaciones, String cobEmpresa, String cobPeriodo, String cobMotivo, String cobNumero, Integer fpSecuencial, String secCodigo) {
        this.detValor = detValor;
        this.detReferencia = detReferencia;
        this.detObservaciones = detObservaciones;
        this.cobEmpresa = cobEmpresa;
        this.cobPeriodo = cobPeriodo;
        this.cobMotivo = cobMotivo;
        this.cobNumero = cobNumero;
        this.fpSecuencial = fpSecuencial;
        this.secCodigo = secCodigo;
    }

    public String getCobEmpresa() {
        return cobEmpresa;
    }

    public void setCobEmpresa(String cobEmpresa) {
        this.cobEmpresa = cobEmpresa;
    }

    public String getCobMotivo() {
        return cobMotivo;
    }

    public void setCobMotivo(String cobMotivo) {
        this.cobMotivo = cobMotivo;
    }

    public String getCobNumero() {
        return cobNumero;
    }

    public void setCobNumero(String cobNumero) {
        this.cobNumero = cobNumero;
    }

    public String getCobPeriodo() {
        return cobPeriodo;
    }

    public void setCobPeriodo(String cobPeriodo) {
        this.cobPeriodo = cobPeriodo;
    }

    public String getDetObservaciones() {
        return detObservaciones;
    }

    public void setDetObservaciones(String detObservaciones) {
        this.detObservaciones = detObservaciones;
    }

    public String getDetReferencia() {
        return detReferencia;
    }

    public void setDetReferencia(String detReferencia) {
        this.detReferencia = detReferencia;
    }

    public BigDecimal getDetValor() {
        return detValor;
    }

    public void setDetValor(BigDecimal detValor) {
        this.detValor = detValor;
    }

    public Integer getFpSecuencial() {
        return fpSecuencial;
    }

    public void setFpSecuencial(Integer fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getDetBanco() {
        return detBanco;
    }

    public void setDetBanco(String detBanco) {
        this.detBanco = detBanco;
    }

    public String getDetCuenta() {
        return detCuenta;
    }

    public void setDetCuenta(String detCuenta) {
        this.detCuenta = detCuenta;
    }

    public String getDetFechaPst() {
        return detFechaPst;
    }

    public void setDetFechaPst(String detFechaPst) {
        this.detFechaPst = detFechaPst;
    }

    public String getBanCodigo() {
        return banCodigo;
    }

    public void setBanCodigo(String banCodigo) {
        this.banCodigo = banCodigo;
    }

    public String getBanEmpresa() {
        return banEmpresa;
    }

    public void setBanEmpresa(String banEmpresa) {
        this.banEmpresa = banEmpresa;
    }
    
    
}
