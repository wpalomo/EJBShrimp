/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class RhRolSueldoEmpleadoTO implements Serializable{

    
    private String empCargo;
    private String empFormaPago;
    private BigDecimal empSueldoReal;
    private String rolFechaUltimoSueldo;

    public RhRolSueldoEmpleadoTO() {
    }

    public RhRolSueldoEmpleadoTO(String empCargo, String empFormaPago, BigDecimal empSueldoReal, String rolFechaUltimoSueldo) {
        this.empCargo = empCargo;
        this.empFormaPago = empFormaPago;
        this.empSueldoReal = empSueldoReal;
        this.rolFechaUltimoSueldo = rolFechaUltimoSueldo;
    }

    public String getEmpCargo() {
        return empCargo;
    }

    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }

    public String getEmpFormaPago() {
        return empFormaPago;
    }

    public void setEmpFormaPago(String empFormaPago) {
        this.empFormaPago = empFormaPago;
    }

    public BigDecimal getEmpSueldoReal() {
        return empSueldoReal;
    }

    public void setEmpSueldoReal(BigDecimal empSueldoReal) {
        this.empSueldoReal = empSueldoReal;
    }

    public String getRolFechaUltimoSueldo() {
        return rolFechaUltimoSueldo;
    }

    public void setRolFechaUltimoSueldo(String rolFechaUltimoSueldo) {
        this.rolFechaUltimoSueldo = rolFechaUltimoSueldo;
    }

    public String getInformacion(){
        return "Cargo: "+empCargo+
                "\nForma Pago: "+empFormaPago+
                "\nSueldo Real: "+empSueldoReal+
                "\nFecha Ultimo Sueldo: "+rolFechaUltimoSueldo;
    }
}
