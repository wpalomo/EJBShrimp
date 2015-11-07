/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class BanListaConciliacionBancariaTO implements Serializable{
//    cb_contable, cb_secuencial, cb_fecha, cb_documento,
// cb_valor, cb_conciliado, cb_concepto, cb_observaciones
    private String cbContable;
    private Integer cbSecuencial;
    private String cbFecha;
    private String cbDocumento;
    private java.math.BigDecimal cbValor;
    private Boolean cbConciliado;
    private String cbConcepto;
    private String cbObservaciones;
    private char cbDc;

    public BanListaConciliacionBancariaTO() {
    }

    public BanListaConciliacionBancariaTO(String cbContable, Integer cbSecuencial, String cbFecha, String cbDocumento, BigDecimal cbValor, Boolean cbConciliado, String cbConcepto, String cbObservaciones, char cbDc) {
        this.cbContable = cbContable;
        this.cbSecuencial = cbSecuencial;
        this.cbFecha = cbFecha;
        this.cbDocumento = cbDocumento;
        this.cbValor = cbValor;
        this.cbConciliado = cbConciliado;
        this.cbConcepto = cbConcepto;
        this.cbObservaciones = cbObservaciones;
        this.cbDc = cbDc;
    }

    public BanListaConciliacionBancariaTO(String cbContable, Integer cbSecuencial, String cbFecha, String cbDocumento, BigDecimal cbValor, Boolean cbConciliado, String cbObservaciones) {
        this.cbContable = cbContable;
        this.cbSecuencial = cbSecuencial;
        this.cbFecha = cbFecha;
        this.cbDocumento = cbDocumento;
        this.cbValor = cbValor;
        this.cbConciliado = cbConciliado;
        this.cbObservaciones = cbObservaciones;
    }

    public String getCbConcepto() {
        return cbConcepto;
    }

    public void setCbConcepto(String cbConcepto) {
        this.cbConcepto = cbConcepto;
    }

    public Boolean getCbConciliado() {
        return cbConciliado;
    }

    public void setCbConciliado(Boolean cbConciliado) {
        this.cbConciliado = cbConciliado;
    }

    public String getCbContable() {
        return cbContable;
    }

    public void setCbContable(String cbContable) {
        this.cbContable = cbContable;
    }

    public char getCbDc() {
        return cbDc;
    }

    public void setCbDc(char cbDc) {
        this.cbDc = cbDc;
    }

    public String getCbDocumento() {
        return cbDocumento;
    }

    public void setCbDocumento(String cbDocumento) {
        this.cbDocumento = cbDocumento;
    }

    public String getCbFecha() {
        return cbFecha;
    }

    public void setCbFecha(String cbFecha) {
        this.cbFecha = cbFecha;
    }

    public String getCbObservaciones() {
        return cbObservaciones;
    }

    public void setCbObservaciones(String cbObservaciones) {
        this.cbObservaciones = cbObservaciones;
    }

    public Integer getCbSecuencial() {
        return cbSecuencial;
    }

    public void setCbSecuencial(Integer cbSecuencial) {
        this.cbSecuencial = cbSecuencial;
    }

    public BigDecimal getCbValor() {
        return cbValor;
    }

    public void setCbValor(BigDecimal cbValor) {
        this.cbValor = cbValor;
    }
    
}
