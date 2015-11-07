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
public class ConBalanceResultadosMensualizadosTO implements java.io.Serializable{
    private String brMes;
    private String brCuenta;
    private String brDetalle;
    private java.math.BigDecimal brSaldo;

    public ConBalanceResultadosMensualizadosTO() {
    }

    public ConBalanceResultadosMensualizadosTO(String brMes, String brCuenta, String brDetalle, BigDecimal brSaldo) {
        this.brMes = brMes;
        this.brCuenta = brCuenta;
        this.brDetalle = brDetalle;
        this.brSaldo = brSaldo;
    }

    public String getBrCuenta() {
        return brCuenta;
    }

    public void setBrCuenta(String brCuenta) {
        this.brCuenta = brCuenta;
    }

    public String getBrDetalle() {
        return brDetalle;
    }

    public void setBrDetalle(String brDetalle) {
        this.brDetalle = brDetalle;
    }

    public String getBrMes() {
        return brMes;
    }

    public void setBrMes(String brMes) {
        this.brMes = brMes;
    }

    public BigDecimal getBrSaldo() {
        return brSaldo;
    }

    public void setBrSaldo(BigDecimal brSaldo) {
        this.brSaldo = brSaldo;
    }
    
    @Override
    public String toString(){
        return this.brMes + " " + this.brCuenta + " " + this.brDetalle + " " + this.brSaldo;
    }
}
