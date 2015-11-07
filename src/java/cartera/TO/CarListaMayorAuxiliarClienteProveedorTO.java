/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cartera.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class CarListaMayorAuxiliarClienteProveedorTO implements Serializable{
    private String maContable;
    private String maFecha;
    private String maClavePrincipal;
    private String maCp;
    private String maDocumento;
    private BigDecimal maDebe;
    private BigDecimal maHaber;
    private BigDecimal maSaldo;
    private String maObservaciones;
    private Integer maOrden;

    public CarListaMayorAuxiliarClienteProveedorTO() {
    }

    public CarListaMayorAuxiliarClienteProveedorTO(String maContable, String maFecha, String maClavePrincipal, String maCp, String maDocumento, BigDecimal maDebe, BigDecimal maHaber, BigDecimal maSaldo, String maObservaciones, Integer maOrden) {
        this.maContable = maContable;
        this.maFecha = maFecha;
        this.maClavePrincipal = maClavePrincipal;
        this.maCp = maCp;
        this.maDocumento = maDocumento;
        this.maDebe = maDebe;
        this.maHaber = maHaber;
        this.maSaldo = maSaldo;
        this.maObservaciones = maObservaciones;
        this.maOrden = maOrden;
    }

    public String getMaClavePrincipal() {
        return maClavePrincipal;
    }

    public void setMaClavePrincipal(String maClavePrincipal) {
        this.maClavePrincipal = maClavePrincipal;
    }

    public String getMaContable() {
        return maContable;
    }

    public void setMaContable(String maContable) {
        this.maContable = maContable;
    }

    public String getMaCp() {
        return maCp;
    }

    public void setMaCp(String maCp) {
        this.maCp = maCp;
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

    public BigDecimal getMaSaldo() {
        return maSaldo;
    }

    public void setMaSaldo(BigDecimal maSaldo) {
        this.maSaldo = maSaldo;
    }
    
}
