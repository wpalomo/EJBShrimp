/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class CarCobrosAnticipoTO implements java.io.Serializable {
    private String antEmpresa;
    private String antPeriodo;
    private String antTipo;
    private String antNumero;
    private java.math.BigDecimal antValor;
    private Boolean antCobrado;
    private Boolean antReversado;
    private Integer fpSecuencial;
    private String cliEmpresa;
    private String cliCodigo;
    private String secEmpresa;
    private String secCodigo;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public CarCobrosAnticipoTO() {
    }

    public CarCobrosAnticipoTO(String antEmpresa, String antPeriodo, String antTipo, String antNumero, BigDecimal antValor, Boolean antCobrado, Boolean antReversado, Integer fpSecuencial, String cliEmpresa, String cliCodigo, String secEmpresa, String secCodigo, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.antEmpresa = antEmpresa;
        this.antPeriodo = antPeriodo;
        this.antTipo = antTipo;
        this.antNumero = antNumero;
        this.antValor = antValor;
        this.antCobrado = antCobrado;
        this.antReversado = antReversado;
        this.fpSecuencial = fpSecuencial;
        this.cliEmpresa = cliEmpresa;
        this.cliCodigo = cliCodigo;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Boolean getAntCobrado() {
        return antCobrado;
    }

    public void setAntCobrado(Boolean antCobrado) {
        this.antCobrado = antCobrado;
    }

    public String getAntEmpresa() {
        return antEmpresa;
    }

    public void setAntEmpresa(String antEmpresa) {
        this.antEmpresa = antEmpresa;
    }

    public String getAntNumero() {
        return antNumero;
    }

    public void setAntNumero(String antNumero) {
        this.antNumero = antNumero;
    }

    public String getAntPeriodo() {
        return antPeriodo;
    }

    public void setAntPeriodo(String antPeriodo) {
        this.antPeriodo = antPeriodo;
    }

    public String getAntTipo() {
        return antTipo;
    }

    public void setAntTipo(String antTipo) {
        this.antTipo = antTipo;
    }

    public BigDecimal getAntValor() {
        return antValor;
    }

    public void setAntValor(BigDecimal antValor) {
        this.antValor = antValor;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliEmpresa() {
        return cliEmpresa;
    }

    public void setCliEmpresa(String cliEmpresa) {
        this.cliEmpresa = cliEmpresa;
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

    public String getSecEmpresa() {
        return secEmpresa;
    }

    public void setSecEmpresa(String secEmpresa) {
        this.secEmpresa = secEmpresa;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }

    public Boolean getAntReversado() {
        return antReversado;
    }

    public void setAntReversado(Boolean antReversado) {
        this.antReversado = antReversado;
    }
    
}
