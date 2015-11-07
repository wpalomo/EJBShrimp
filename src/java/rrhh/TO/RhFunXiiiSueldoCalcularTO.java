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
public class RhFunXiiiSueldoCalcularTO implements Serializable{
    private String xiiiId;
    private String xiiiNombres;
    private String xiiiApellidos;
    private Character xiiiGenero;
    private String xiiiFechaIngreso;
    private String xiiiCargo;
    private java.math.BigDecimal xiiiTotalIngresos;
    private Integer xiiiDiasLaborados;
    private java.math.BigDecimal xiiiValorXiiiSueldo;
    private String xiiiCategoria;
    private String xiiiCuenta;
    private String xiiiSector;
    private boolean estado;

    public RhFunXiiiSueldoCalcularTO() {
    }

    public RhFunXiiiSueldoCalcularTO(String xiiiId, String xiiiNombres, String xiiiApellidos, Character xiiiGenero, String xiiiFechaIngreso, String xiiiCargo, BigDecimal xiiiTotalIngresos, Integer xiiiDiasLaborados, BigDecimal xiiiValorXiiiSueldo, String xiiiCategoria, String xiiiCuenta, String xiiiSector) {
        this.xiiiId = xiiiId;
        this.xiiiNombres = xiiiNombres;
        this.xiiiApellidos = xiiiApellidos;
        this.xiiiGenero = xiiiGenero;
        this.xiiiFechaIngreso = xiiiFechaIngreso;
        this.xiiiCargo = xiiiCargo;
        this.xiiiTotalIngresos = xiiiTotalIngresos;
        this.xiiiDiasLaborados = xiiiDiasLaborados;
        this.xiiiValorXiiiSueldo = xiiiValorXiiiSueldo;
        this.xiiiCategoria = xiiiCategoria;
        this.xiiiCuenta = xiiiCuenta;
        this.xiiiSector = xiiiSector;
    }

    public RhFunXiiiSueldoCalcularTO(String xiiiId, String xiiiNombres, String xiiiApellidos, Character xiiiGenero, String xiiiFechaIngreso, String xiiiCargo, BigDecimal xiiiTotalIngresos, Integer xiiiDiasLaborados, BigDecimal xiiiValorXiiiSueldo, String xiiiCategoria, String xiiiCuenta, String xiiiSector, boolean estado) {
        this.xiiiId = xiiiId;
        this.xiiiNombres = xiiiNombres;
        this.xiiiApellidos = xiiiApellidos;
        this.xiiiGenero = xiiiGenero;
        this.xiiiFechaIngreso = xiiiFechaIngreso;
        this.xiiiCargo = xiiiCargo;
        this.xiiiTotalIngresos = xiiiTotalIngresos;
        this.xiiiDiasLaborados = xiiiDiasLaborados;
        this.xiiiValorXiiiSueldo = xiiiValorXiiiSueldo;
        this.xiiiCategoria = xiiiCategoria;
        this.xiiiCuenta = xiiiCuenta;
        this.xiiiSector = xiiiSector;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getXiiiApellidos() {
        return xiiiApellidos;
    }

    public void setXiiiApellidos(String xiiiApellidos) {
        this.xiiiApellidos = xiiiApellidos;
    }

    public String getXiiiCargo() {
        return xiiiCargo;
    }

    public void setXiiiCargo(String xiiiCargo) {
        this.xiiiCargo = xiiiCargo;
    }

    public String getXiiiCategoria() {
        return xiiiCategoria;
    }

    public void setXiiiCategoria(String xiiiCategoria) {
        this.xiiiCategoria = xiiiCategoria;
    }

    public String getXiiiCuenta() {
        return xiiiCuenta;
    }

    public void setXiiiCuenta(String xiiiCuenta) {
        this.xiiiCuenta = xiiiCuenta;
    }

    public Integer getXiiiDiasLaborados() {
        return xiiiDiasLaborados;
    }

    public void setXiiiDiasLaborados(Integer xiiiDiasLaborados) {
        this.xiiiDiasLaborados = xiiiDiasLaborados;
    }

    public String getXiiiFechaIngreso() {
        return xiiiFechaIngreso;
    }

    public void setXiiiFechaIngreso(String xiiiFechaIngreso) {
        this.xiiiFechaIngreso = xiiiFechaIngreso;
    }

    public Character getXiiiGenero() {
        return xiiiGenero;
    }

    public void setXiiiGenero(Character xiiiGenero) {
        this.xiiiGenero = xiiiGenero;
    }

    public String getXiiiId() {
        return xiiiId;
    }

    public void setXiiiId(String xiiiId) {
        this.xiiiId = xiiiId;
    }

    public String getXiiiNombres() {
        return xiiiNombres;
    }

    public void setXiiiNombres(String xiiiNombres) {
        this.xiiiNombres = xiiiNombres;
    }

    public String getXiiiSector() {
        return xiiiSector;
    }

    public void setXiiiSector(String xiiiSector) {
        this.xiiiSector = xiiiSector;
    }

    public BigDecimal getXiiiTotalIngresos() {
        return xiiiTotalIngresos;
    }

    public void setXiiiTotalIngresos(BigDecimal xiiiTotalIngresos) {
        this.xiiiTotalIngresos = xiiiTotalIngresos;
    }

    public BigDecimal getXiiiValorXiiiSueldo() {
        return xiiiValorXiiiSueldo;
    }

    public void setXiiiValorXiiiSueldo(BigDecimal xiiiValorXiiiSueldo) {
        this.xiiiValorXiiiSueldo = xiiiValorXiiiSueldo;
    }

}
