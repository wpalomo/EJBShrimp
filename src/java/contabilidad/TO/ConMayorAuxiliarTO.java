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
public class ConMayorAuxiliarTO implements java.io.Serializable{
    private String maContable;
    private String maFecha;
    private Integer maSecuencia;
    private String maCuenta;
    private String maCuentaDetalle;
    private String maCP;
    private String maCC;
    private String maDocumento;
    private java.math.BigDecimal maDebe;
    private java.math.BigDecimal maHaber;
    private java.math.BigDecimal maSaldo;
    private String maObservaciones;
    private Boolean maGenerado;
    private String maReferencia;
    private Integer maOrden;

    public ConMayorAuxiliarTO() {
    }

    public ConMayorAuxiliarTO(String maContable, String maFecha, Integer maSecuencia, String maCuenta, String maCP, String maCC, String maDocumento, BigDecimal maDebe, BigDecimal maHaber, BigDecimal maSaldo, String maObservaciones, Boolean maGenerado, String maReferencia, Integer maOrden) {
        this.maContable = maContable;
        this.maFecha = maFecha;
        this.maSecuencia = maSecuencia;
        this.maCuenta = maCuenta;
        this.maCP = maCP;
        this.maCC = maCC;
        this.maDocumento = maDocumento;
        this.maDebe = maDebe;
        this.maHaber = maHaber;
        this.maSaldo = maSaldo;
        this.maObservaciones = maObservaciones;
        this.maGenerado = maGenerado;
        this.maReferencia = maReferencia;
        this.maOrden = maOrden;
    }

    public String getMaCuentaDetalle() {
        return maCuentaDetalle;
    }

    public void setMaCuentaDetalle(String maCuentaDetalle) {
        this.maCuentaDetalle = maCuentaDetalle;
    }

    public String getMaCC() {
        return maCC;
    }

    public void setMaCC(String maCC) {
        this.maCC = maCC;
    }

    public String getMaCP() {
        return maCP;
    }

    public void setMaCP(String maCP) {
        this.maCP = maCP;
    }

    public String getMaContable() {
        return maContable;
    }

    public void setMaContable(String maContable) {
        this.maContable = maContable;
    }

    public String getMaCuenta() {
        return maCuenta;
    }

    public void setMaCuenta(String maCuenta) {
        this.maCuenta = maCuenta;
    }

    public BigDecimal getMaDebe() {
        return maDebe;
    }

    public void setMaDebe(BigDecimal maDebe) {
        this.maDebe = maDebe;
    }

    public String getMaDocumento() {
        return maDocumento;
    }

    public void setMaDocumento(String maDocumento) {
        this.maDocumento = maDocumento;
    }

    public String getMaFecha() {
        return maFecha;
    }

    public void setMaFecha(String maFecha) {
        this.maFecha = maFecha;
    }

    public Boolean getMaGenerado() {
        return maGenerado;
    }

    public void setMaGenerado(Boolean maGenerado) {
        this.maGenerado = maGenerado;
    }

    public BigDecimal getMaHaber() {
        return maHaber;
    }

    public void setMaHaber(BigDecimal maHaber) {
        this.maHaber = maHaber;
    }

    public String getMaObservaciones() {
        return maObservaciones;
    }

    public void setMaObservaciones(String maObservaciones) {
        this.maObservaciones = maObservaciones;
    }

    public Integer getMaOrden() {
        return maOrden;
    }

    public void setMaOrden(Integer maOrden) {
        this.maOrden = maOrden;
    }

    public String getMaReferencia() {
        return maReferencia;
    }

    public void setMaReferencia(String maReferencia) {
        this.maReferencia = maReferencia;
    }

    public BigDecimal getMaSaldo() {
        return maSaldo;
    }

    public void setMaSaldo(BigDecimal maSaldo) {
        this.maSaldo = maSaldo;
    }

    public Integer getMaSecuencia() {
        return maSecuencia;
    }

    public void setMaSecuencia(Integer maSecuencia) {
        this.maSecuencia = maSecuencia;
    }
}
