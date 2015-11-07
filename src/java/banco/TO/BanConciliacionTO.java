/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class BanConciliacionTO implements java.io.Serializable{
    private String concEmpresa;
    private String concCuentaContable;
    private String concCodigo;
    private String concHasta;
    private java.math.BigDecimal concSaldoEstadoCuenta;
    private java.math.BigDecimal concChequesGiradosYNoCobrados;
    private java.math.BigDecimal concDepositosEnTransito;
    private boolean concPendiente;
//    private String ctaEmpresa;
//    private String ctaCuentaContable;
//    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public BanConciliacionTO() {
    }

    public BanConciliacionTO(String concEmpresa, String concCuentaContable, String concCodigo, String concHasta, BigDecimal concSaldoEstadoCuenta, BigDecimal concChequesGiradosYNoCobrados, BigDecimal concDepositosEnTransito, boolean concPendiente, String usrCodigo, String usrFechaInserta) {
        this.concEmpresa = concEmpresa;
        this.concCuentaContable = concCuentaContable;
        this.concCodigo = concCodigo;
        this.concHasta = concHasta;
        this.concSaldoEstadoCuenta = concSaldoEstadoCuenta;
        this.concChequesGiradosYNoCobrados = concChequesGiradosYNoCobrados;
        this.concDepositosEnTransito = concDepositosEnTransito;
        this.concPendiente = concPendiente;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public BigDecimal getConcChequesGiradosYNoCobrados() {
        return concChequesGiradosYNoCobrados;
    }

    public void setConcChequesGiradosYNoCobrados(BigDecimal concChequesGiradosYNoCobrados) {
        this.concChequesGiradosYNoCobrados = concChequesGiradosYNoCobrados;
    }

    public String getConcCodigo() {
        return concCodigo;
    }

    public void setConcCodigo(String concCodigo) {
        this.concCodigo = concCodigo;
    }

    public String getConcCuentaContable() {
        return concCuentaContable;
    }

    public void setConcCuentaContable(String concCuentaContable) {
        this.concCuentaContable = concCuentaContable;
    }

    public BigDecimal getConcDepositosEnTransito() {
        return concDepositosEnTransito;
    }

    public void setConcDepositosEnTransito(BigDecimal concDepositosEnTransito) {
        this.concDepositosEnTransito = concDepositosEnTransito;
    }

    public String getConcEmpresa() {
        return concEmpresa;
    }

    public void setConcEmpresa(String concEmpresa) {
        this.concEmpresa = concEmpresa;
    }

    public String getConcHasta() {
        return concHasta;
    }

    public void setConcHasta(String concHasta) {
        this.concHasta = concHasta;
    }

    public boolean isConcPendiente() {
        return concPendiente;
    }

    public void setConcPendiente(boolean concPendiente) {
        this.concPendiente = concPendiente;
    }

    public BigDecimal getConcSaldoEstadoCuenta() {
        return concSaldoEstadoCuenta;
    }

    public void setConcSaldoEstadoCuenta(BigDecimal concSaldoEstadoCuenta) {
        this.concSaldoEstadoCuenta = concSaldoEstadoCuenta;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }

}
