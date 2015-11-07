/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.TO;

import java.math.BigDecimal;

/**
 *
 * @author charly
 */
public class CajCuadreCajaTO implements java.io.Serializable{
    
    private String cuadrarCaja;
    private Integer cuaCantidad;
    private BigDecimal cuaBase0;
    private BigDecimal cuaBaseImponible;
    private BigDecimal cuaMontoIva;
    private BigDecimal cuaTotal;

    public CajCuadreCajaTO() {
    }

    public CajCuadreCajaTO(String cuadrarCaja, Integer cuaCantidad, BigDecimal cuaBase0, BigDecimal cuaBaseImponible, BigDecimal cuaMontoIva, BigDecimal cuaTotal) {
        this.cuadrarCaja = cuadrarCaja;
        this.cuaCantidad = cuaCantidad;
        this.cuaBase0 = cuaBase0;
        this.cuaBaseImponible = cuaBaseImponible;
        this.cuaMontoIva = cuaMontoIva;
        this.cuaTotal = cuaTotal;
    }

    public BigDecimal getCuaBase0() {
        return cuaBase0;
    }

    public void setCuaBase0(BigDecimal cuaBase0) {
        this.cuaBase0 = cuaBase0;
    }

    public BigDecimal getCuaBaseImponible() {
        return cuaBaseImponible;
    }

    public void setCuaBaseImponible(BigDecimal cuaBaseImponible) {
        this.cuaBaseImponible = cuaBaseImponible;
    }

    public BigDecimal getCuaMontoIva() {
        return cuaMontoIva;
    }

    public void setCuaMontoIva(BigDecimal cuaMontoIva) {
        this.cuaMontoIva = cuaMontoIva;
    }

    public Integer getCuaCantidad() {
        return cuaCantidad;
    }

    public void setCuaCantidad(Integer cuaCantidad) {
        this.cuaCantidad = cuaCantidad;
    }

    public BigDecimal getCuaTotal() {
        return cuaTotal;
    }

    public void setCuaTotal(BigDecimal cuaTotal) {
        this.cuaTotal = cuaTotal;
    }

    public String getCuadrarCaja() {
        return cuadrarCaja;
    }

    public void setCuadrarCaja(String cuadrarCaja) {
        this.cuadrarCaja = cuadrarCaja;
    }

    
   
    @Override
    public String toString(){
        return this.cuadrarCaja + " " + this.cuaCantidad + " " + this.cuaTotal ;
    }

  
}
