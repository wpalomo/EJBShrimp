/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.TO;


import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class RhConsolidadoIngresosTabuladoTO implements java.io.Serializable{
    
   
    private String brCedula;
    private String brNombre;
    private String brFechaIngreso;
    private String brFechaSalida;
     private String brPeriodo;
    private java.math.BigDecimal brTotal;

    public RhConsolidadoIngresosTabuladoTO() {
    }

    public RhConsolidadoIngresosTabuladoTO(String brPeriodo, String brCedula, String brNombre, String brFechaIngreso, String brFechaSalida, BigDecimal brTotal) {
        this.brPeriodo = brPeriodo;
        this.brCedula = brCedula;
        this.brNombre = brNombre;
        this.brFechaIngreso = brFechaIngreso;
        this.brFechaSalida = brFechaSalida;
        this.brTotal = brTotal;
    }

    

    public String getBrPeriodo() {
        return brPeriodo;
    }

    public void setBrPeriodo(String brPeriodo) {
        this.brPeriodo = brPeriodo;
    }

    public String getBrCedula() {
        return brCedula;
    }

    public void setBrCedula(String brCedula) {
        this.brCedula = brCedula;
    }

    public String getBrNombre() {
        return brNombre;
    }

    public void setBrNombre(String brNombre) {
        this.brNombre = brNombre;
    }

    public String getBrFechaIngreso() {
        return brFechaIngreso;
    }

    public void setBrFechaIngreso(String brFechaIngreso) {
        this.brFechaIngreso = brFechaIngreso;
    }

    public String getBrFechaSalida() {
        return brFechaSalida;
    }

    public void setBrFechaSalida(String brFechaSalida) {
        this.brFechaSalida = brFechaSalida;
    }



    public BigDecimal getBrTotal() {
        return brTotal;
    }

    public void setBrTotal(BigDecimal brTotal) {
        this.brTotal = brTotal;
    }

    
    
    @Override
    public String toString(){
        return this.brPeriodo + " " + this.brCedula + " " + this.brNombre + " " + this.brFechaIngreso+ " " + this.brTotal;
    }
}
