/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.TO;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author jack
 */
public class BanListaChequeTO implements java.io.Serializable{
    private String chqCuentaCodigo;
    private String chqCuentaDetalle;
    private String chqBeneficiario;
    private String chqNumero;
    private BigDecimal chqValor;
    private String chqFechaEmision;
    private String chqFechaVencimiento;
    private Boolean chqImpreso;
    private Boolean chqRevisado;
    private Boolean chqEntregado;
    private String chqContablePeriodo;
    private String chqContableTipo;
    private String chqContableNumero;
    private BigInteger chqSecuencia;
    private BigInteger chqOrden;

    public BanListaChequeTO() {
    }

    public BanListaChequeTO(String chqCuentaCodigo, String chqCuentaDetalle, String chqBeneficiario, String chqNumero, BigDecimal chqValor, String chqFechaEmision, String chqFechaVencimiento, Boolean chqImpreso, Boolean chqRevisado, Boolean chqEntregado, String chqContablePeriodo, String chqContableTipo, String chqContableNumero, BigInteger chqSecuencia, BigInteger chqOrden) {
        this.chqCuentaCodigo = chqCuentaCodigo;
        this.chqCuentaDetalle = chqCuentaDetalle;
        this.chqBeneficiario = chqBeneficiario;
        this.chqNumero = chqNumero;
        this.chqValor = chqValor;
        this.chqFechaEmision = chqFechaEmision;
        this.chqFechaVencimiento = chqFechaVencimiento;
        this.chqImpreso = chqImpreso;
        this.chqRevisado = chqRevisado;
        this.chqEntregado = chqEntregado;
        this.chqContablePeriodo = chqContablePeriodo;
        this.chqContableTipo = chqContableTipo;
        this.chqContableNumero = chqContableNumero;
        this.chqSecuencia = chqSecuencia;
        this.chqOrden = chqOrden;
    }

    public String getChqBeneficiario() {
        return chqBeneficiario;
    }

    public void setChqBeneficiario(String chqBeneficiario) {
        this.chqBeneficiario = chqBeneficiario;
    }

    public String getChqContableNumero() {
        return chqContableNumero;
    }

    public void setChqContableNumero(String chqContableNumero) {
        this.chqContableNumero = chqContableNumero;
    }

    public String getChqContablePeriodo() {
        return chqContablePeriodo;
    }

    public void setChqContablePeriodo(String chqContablePeriodo) {
        this.chqContablePeriodo = chqContablePeriodo;
    }

    public String getChqContableTipo() {
        return chqContableTipo;
    }

    public void setChqContableTipo(String chqContableTipo) {
        this.chqContableTipo = chqContableTipo;
    }

    public String getChqCuentaCodigo() {
        return chqCuentaCodigo;
    }

    public void setChqCuentaCodigo(String chqCuentaCodigo) {
        this.chqCuentaCodigo = chqCuentaCodigo;
    }

    public String getChqCuentaDetalle() {
        return chqCuentaDetalle;
    }

    public void setChqCuentaDetalle(String chqCuentaDetalle) {
        this.chqCuentaDetalle = chqCuentaDetalle;
    }

    public Boolean getChqEntregado() {
        return chqEntregado;
    }

    public void setChqEntregado(Boolean chqEntregado) {
        this.chqEntregado = chqEntregado;
    }

    public String getChqFechaEmision() {
        return chqFechaEmision;
    }

    public void setChqFechaEmision(String chqFechaEmision) {
        this.chqFechaEmision = chqFechaEmision;
    }

    public String getChqFechaVencimiento() {
        return chqFechaVencimiento;
    }

    public void setChqFechaVencimiento(String chqFechaVencimiento) {
        this.chqFechaVencimiento = chqFechaVencimiento;
    }

    public Boolean getChqImpreso() {
        return chqImpreso;
    }

    public void setChqImpreso(Boolean chqImpreso) {
        this.chqImpreso = chqImpreso;
    }

    public String getChqNumero() {
        return chqNumero;
    }

    public void setChqNumero(String chqNumero) {
        this.chqNumero = chqNumero;
    }

    public BigInteger getChqOrden() {
        return chqOrden;
    }

    public void setChqOrden(BigInteger chqOrden) {
        this.chqOrden = chqOrden;
    }

    public Boolean getChqRevisado() {
        return chqRevisado;
    }

    public void setChqRevisado(Boolean chqRevisado) {
        this.chqRevisado = chqRevisado;
    }

    public BigInteger getChqSecuencia() {
        return chqSecuencia;
    }

    public void setChqSecuencia(BigInteger chqSecuencia) {
        this.chqSecuencia = chqSecuencia;
    }

    public BigDecimal getChqValor() {
        return chqValor;
    }

    public void setChqValor(BigDecimal chqValor) {
        this.chqValor = chqValor;
    }
    
}
