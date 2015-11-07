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
public class ConBalanceGeneralTO implements java.io.Serializable{
    private String bgCuenta;
    private String bgDetalle;
    private java.math.BigDecimal bgSaldo;

    public ConBalanceGeneralTO() {
    }

    public ConBalanceGeneralTO(String bgCuenta, String bgDetalle, BigDecimal bgSaldo) {
        this.bgCuenta = bgCuenta;
        this.bgDetalle = bgDetalle;
        this.bgSaldo = bgSaldo;
    }

    public String getBgCuenta() {
        return bgCuenta;
    }

    public void setBgCuenta(String bgCuenta) {
        this.bgCuenta = bgCuenta;
    }

    public String getBgDetalle() {
        return bgDetalle;
    }

    public void setBgDetalle(String bgDetalle) {
        this.bgDetalle = bgDetalle;
    }

    public BigDecimal getBgSaldo() {
        return bgSaldo;
    }

    public void setBgSaldo(BigDecimal bgSaldo) {
        this.bgSaldo = bgSaldo;
    }
}
