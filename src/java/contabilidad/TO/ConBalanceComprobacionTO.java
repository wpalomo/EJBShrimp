/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabilidad.TO;
import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ConBalanceComprobacionTO implements java.io.Serializable{
    private String bcCuenta;
    private String bcDetalle;
    private java.math.BigDecimal bcSaldoAnterior;
    private java.math.BigDecimal bcTotalDebito;
    private java.math.BigDecimal bcTotalCredito;
    private java.math.BigDecimal bcSaldoFinal;

    public ConBalanceComprobacionTO() {
    }

    public ConBalanceComprobacionTO(String bcCuenta, String bcDetalle, BigDecimal bcSaldoAnterior, BigDecimal bcTotalDebito, BigDecimal bcTotalCredito, BigDecimal bcSaldoFinal) {
        this.bcCuenta = bcCuenta;
        this.bcDetalle = bcDetalle;
        this.bcSaldoAnterior = bcSaldoAnterior;
        this.bcTotalDebito = bcTotalDebito;
        this.bcTotalCredito = bcTotalCredito;
        this.bcSaldoFinal = bcSaldoFinal;
    }

    public String getBcCuenta() {
        return bcCuenta;
    }

    public void setBcCuenta(String bcCuenta) {
        this.bcCuenta = bcCuenta;
    }

    public String getBcDetalle() {
        return bcDetalle;
    }

    public void setBcDetalle(String bcDetalle) {
        this.bcDetalle = bcDetalle;
    }

    public BigDecimal getBcSaldoAnterior() {
        return bcSaldoAnterior;
    }

    public void setBcSaldoAnterior(BigDecimal bcSaldoAnterior) {
        this.bcSaldoAnterior = bcSaldoAnterior;
    }

    public BigDecimal getBcSaldoFinal() {
        return bcSaldoFinal;
    }

    public void setBcSaldoFinal(BigDecimal bcSaldoFinal) {
        this.bcSaldoFinal = bcSaldoFinal;
    }

    public BigDecimal getBcTotalCredito() {
        return bcTotalCredito;
    }

    public void setBcTotalCredito(BigDecimal bcTotalCredito) {
        this.bcTotalCredito = bcTotalCredito;
    }

    public BigDecimal getBcTotalDebito() {
        return bcTotalDebito;
    }

    public void setBcTotalDebito(BigDecimal bcTotalDebito) {
        this.bcTotalDebito = bcTotalDebito;
    }
}
