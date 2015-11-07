/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.TO;

import java.math.BigDecimal;

/**
 *
 * @author misayo
 */
public class CarPagosCobrosAnticipoTO implements java.io.Serializable {
    private java.math.BigDecimal antValor;
    private Integer fpSecuencial;
    private String secCodigo;

    public CarPagosCobrosAnticipoTO() {
    }

    public CarPagosCobrosAnticipoTO(BigDecimal antValor, Integer fpSecuencial, String secCodigo) {
        this.antValor = antValor;
        this.fpSecuencial = fpSecuencial;
        this.secCodigo = secCodigo;
    }

    public BigDecimal getAntValor() {
        return antValor;
    }

    public void setAntValor(BigDecimal antValor) {
        this.antValor = antValor;
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

    
}
