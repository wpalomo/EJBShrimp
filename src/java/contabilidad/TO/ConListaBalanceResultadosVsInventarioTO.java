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
public class ConListaBalanceResultadosVsInventarioTO implements java.io.Serializable{
    private String vriCuentaContable;
    private String vriNombre;
    private BigDecimal vriSaldoContable;
    private BigDecimal vriInventarioInicial;
    private BigDecimal vriDiferencia;

    public ConListaBalanceResultadosVsInventarioTO(String vriCuentaContable, String vriNombre, BigDecimal vriSaldoContable, BigDecimal vriInventarioInicial, BigDecimal vriDiferencia) {
        this.vriCuentaContable = vriCuentaContable;
        this.vriNombre = vriNombre;
        this.vriSaldoContable = vriSaldoContable;
        this.vriInventarioInicial = vriInventarioInicial;
        this.vriDiferencia = vriDiferencia;
    }


    public String getVriCuentaContable() {
        return vriCuentaContable;
    }

    public void setVriCuentaContable(String vriCuentaContable) {
        this.vriCuentaContable = vriCuentaContable;
    }

    public BigDecimal getVriDiferencia() {
        return vriDiferencia;
    }

    public void setVriDiferencia(BigDecimal vriDiferencia) {
        this.vriDiferencia = vriDiferencia;
    }

    public BigDecimal getVriInventarioInicial() {
        return vriInventarioInicial;
    }

    public void setVriInventarioInicial(BigDecimal vriInventarioInicial) {
        this.vriInventarioInicial = vriInventarioInicial;
    }

    public String getVriNombre() {
        return vriNombre;
    }

    public void setVriNombre(String vriNombre) {
        this.vriNombre = vriNombre;
    }

    public BigDecimal getVriSaldoContable() {
        return vriSaldoContable;
    }

    public void setVriSaldoContable(BigDecimal vriSaldoContable) {
        this.vriSaldoContable = vriSaldoContable;
    }
}
