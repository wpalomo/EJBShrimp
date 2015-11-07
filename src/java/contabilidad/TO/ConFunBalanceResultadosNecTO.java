/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabilidad.TO;

import java.math.BigDecimal;

/**
 *
 * @author misayo
 */
public class ConFunBalanceResultadosNecTO implements java.io.Serializable{
    private String brCuenta;
    private String brDetalle;
    private java.math.BigDecimal brSaldo1;
    private java.math.BigDecimal brSaldo2;
    private java.math.BigDecimal brSaldo3;
    private java.math.BigDecimal brSaldo4;
    private java.math.BigDecimal brSaldo5;
    private java.math.BigDecimal brSaldo6;

    public ConFunBalanceResultadosNecTO() {
    }

    public ConFunBalanceResultadosNecTO(String brCuenta, String brDetalle, BigDecimal brSaldo1, BigDecimal brSaldo2, BigDecimal brSaldo3, BigDecimal brSaldo4, BigDecimal brSaldo5, BigDecimal brSaldo6) {
        this.brCuenta = brCuenta;
        this.brDetalle = brDetalle;
        this.brSaldo1 = brSaldo1;
        this.brSaldo2 = brSaldo2;
        this.brSaldo3 = brSaldo3;
        this.brSaldo4 = brSaldo4;
        this.brSaldo5 = brSaldo5;
        this.brSaldo6 = brSaldo6;
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

    public BigDecimal getBrSaldo1() {
        return brSaldo1;
    }

    public void setBrSaldo1(BigDecimal brSaldo1) {
        this.brSaldo1 = brSaldo1;
    }

    public BigDecimal getBrSaldo2() {
        return brSaldo2;
    }

    public void setBrSaldo2(BigDecimal brSaldo2) {
        this.brSaldo2 = brSaldo2;
    }

    public BigDecimal getBrSaldo3() {
        return brSaldo3;
    }

    public void setBrSaldo3(BigDecimal brSaldo3) {
        this.brSaldo3 = brSaldo3;
    }

    public BigDecimal getBrSaldo4() {
        return brSaldo4;
    }

    public void setBrSaldo4(BigDecimal brSaldo4) {
        this.brSaldo4 = brSaldo4;
    }

    public BigDecimal getBrSaldo5() {
        return brSaldo5;
    }

    public void setBrSaldo5(BigDecimal brSaldo5) {
        this.brSaldo5 = brSaldo5;
    }

    public BigDecimal getBrSaldo6() {
        return brSaldo6;
    }

    public void setBrSaldo6(BigDecimal brSaldo6) {
        this.brSaldo6 = brSaldo6;
    }

}
