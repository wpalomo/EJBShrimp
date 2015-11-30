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
public class CarListaPagosCobrosDetalleFormaTO implements Serializable{
    private String fpForma;
    private String fpBanco;
   private String fpCuenta;
   private String fpFecha;
    private String fpReferencia;
    private BigDecimal fpValor;
   private String fpObservaciones;
   
   

    public CarListaPagosCobrosDetalleFormaTO() {
    }

    public CarListaPagosCobrosDetalleFormaTO(String fpForma, String fpReferencia, BigDecimal fpValor, String fpObservaciones) {
        this.fpForma = fpForma;
        this.fpReferencia = fpReferencia;
        this.fpValor = fpValor;
        this.fpObservaciones = fpObservaciones;
    }

    public CarListaPagosCobrosDetalleFormaTO(String fpForma, String fpBanco, String fpCuenta, String fpFecha, String fpReferencia, BigDecimal fpValor, String fpObservaciones) {
        this.fpForma = fpForma;
        this.fpBanco = fpBanco;
        this.fpCuenta = fpCuenta;
        this.fpFecha = fpFecha;
        this.fpReferencia = fpReferencia;
        this.fpValor = fpValor;
        this.fpObservaciones = fpObservaciones;
    }


    
    

    public String getFpForma() {
        return fpForma;
    }

    public void setFpForma(String fpForma) {
        this.fpForma = fpForma;
    }

    public String getFpObservaciones() {
        return fpObservaciones;
    }

    public void setFpObservaciones(String fpObservaciones) {
        this.fpObservaciones = fpObservaciones;
    }

    public String getFpReferencia() {
        return fpReferencia;
    }

    public void setFpReferencia(String fpReferencia) {
        this.fpReferencia = fpReferencia;
    }

    public BigDecimal getFpValor() {
        return fpValor;
    }

    public void setFpValor(BigDecimal fpValor) {
        this.fpValor = fpValor;
    }

    public String getFpBanco() {
        return fpBanco;
    }

    public void setFpBanco(String fpBanco) {
        this.fpBanco = fpBanco;
    }

    public String getFpCuenta() {
        return fpCuenta;
    }

    public void setFpCuenta(String fpCuenta) {
        this.fpCuenta = fpCuenta;
    }

    public String getFpFecha() {
        return fpFecha;
    }

    public void setFpFecha(String fpFecha) {
        this.fpFecha = fpFecha;
    }
    
    
    
}