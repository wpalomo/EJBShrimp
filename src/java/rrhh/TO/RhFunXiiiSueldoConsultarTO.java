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
public class RhFunXiiiSueldoConsultarTO implements Serializable{
    private String xiiiCategoria;
    private String xiiiSector;
    private String xiiiId;
    private String xiiiNombres;
    private String xiiiApellidos;
    private Character xiiiGenero;
    private String xiiiFechaIngreso;
    private String xiiiCargo;
    private java.math.BigDecimal xiiiTotalIngresos;
    private Short xiiiDiasLaborados;
    private java.math.BigDecimal xiiiValorXiiiSueldo;
    private Character xiiiCodigoMinisterial;
    private String xiiiPeriodo;
    private String xiiiTipo;
    private String xiiiNumero;

    public RhFunXiiiSueldoConsultarTO() {
    }

    public RhFunXiiiSueldoConsultarTO(String xiiiCategoria, String xiiiSector, String xiiiId, String xiiiNombres, String xiiiApellidos, Character xiiiGenero, String xiiiFechaIngreso, String xiiiCargo, BigDecimal xiiiTotalIngresos, Short xiiiDiasLaborados, BigDecimal xiiiValorXiiiSueldo, Character xiiiCodigoMinisterial, String xiiiPeriodo, String xiiiTipo, String xiiiNumero) {
        this.xiiiCategoria = xiiiCategoria;
        this.xiiiSector = xiiiSector;
        this.xiiiId = xiiiId;
        this.xiiiNombres = xiiiNombres;
        this.xiiiApellidos = xiiiApellidos;
        this.xiiiGenero = xiiiGenero;
        this.xiiiFechaIngreso = xiiiFechaIngreso;
        this.xiiiCargo = xiiiCargo;
        this.xiiiTotalIngresos = xiiiTotalIngresos;
        this.xiiiDiasLaborados = xiiiDiasLaborados;
        this.xiiiValorXiiiSueldo = xiiiValorXiiiSueldo;
        this.xiiiCodigoMinisterial = xiiiCodigoMinisterial;
        this.xiiiPeriodo = xiiiPeriodo;
        this.xiiiTipo = xiiiTipo;
        this.xiiiNumero = xiiiNumero;
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

    public Character getXiiiCodigoMinisterial() {
        return xiiiCodigoMinisterial;
    }

    public void setXiiiCodigoMinisterial(Character xiiiCodigoMinisterial) {
        this.xiiiCodigoMinisterial = xiiiCodigoMinisterial;
    }

    public Short getXiiiDiasLaborados() {
        return xiiiDiasLaborados;
    }

    public void setXiiiDiasLaborados(Short xiiiDiasLaborados) {
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

    public String getXiiiNumero() {
        return xiiiNumero;
    }

    public void setXiiiNumero(String xiiiNumero) {
        this.xiiiNumero = xiiiNumero;
    }

    public String getXiiiPeriodo() {
        return xiiiPeriodo;
    }

    public void setXiiiPeriodo(String xiiiPeriodo) {
        this.xiiiPeriodo = xiiiPeriodo;
    }

    public String getXiiiSector() {
        return xiiiSector;
    }

    public void setXiiiSector(String xiiiSector) {
        this.xiiiSector = xiiiSector;
    }

    public String getXiiiTipo() {
        return xiiiTipo;
    }

    public void setXiiiTipo(String xiiiTipo) {
        this.xiiiTipo = xiiiTipo;
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
