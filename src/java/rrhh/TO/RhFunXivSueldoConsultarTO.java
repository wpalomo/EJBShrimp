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
public class RhFunXivSueldoConsultarTO implements Serializable{
    
    private String xivCategoria;
    private String xivSector;
    private String xivId;
    private String xivNombres;
    private String xivApellidos;
    private Character xivGenero;
    private String xivFechaIngreso;
    private String xivCargo;
    private java.math.BigDecimal xivTotalIngresos;
    private Short xivDiasLaborados;
    private java.math.BigDecimal xivValorXivSueldo;
    private Character xivCodigoMinisterial;
    private String xivPeriodo;
    private String xivTipo;
    private String xivNumero;

    public RhFunXivSueldoConsultarTO() {
    }

    public RhFunXivSueldoConsultarTO(String xivCategoria, String xivSector, String xivId, String xivNombres, String xivApellidos, Character xivGenero, String xivFechaIngreso, String xivCargo, BigDecimal xivTotalIngresos, Short xivDiasLaborados, BigDecimal xivValorXivSueldo, Character xivCodigoMinisterial, String xivPeriodo, String xivTipo, String xivNumero) {
        this.xivCategoria = xivCategoria;
        this.xivSector = xivSector;
        this.xivId = xivId;
        this.xivNombres = xivNombres;
        this.xivApellidos = xivApellidos;
        this.xivGenero = xivGenero;
        this.xivFechaIngreso = xivFechaIngreso;
        this.xivCargo = xivCargo;
        this.xivTotalIngresos = xivTotalIngresos;
        this.xivDiasLaborados = xivDiasLaborados;
        this.xivValorXivSueldo = xivValorXivSueldo;
        this.xivCodigoMinisterial = xivCodigoMinisterial;
        this.xivPeriodo = xivPeriodo;
        this.xivTipo = xivTipo;
        this.xivNumero = xivNumero;
    }

    public String getXivCategoria() {
        return xivCategoria;
    }

    public void setXivCategoria(String xivCategoria) {
        this.xivCategoria = xivCategoria;
    }

    public String getXivSector() {
        return xivSector;
    }

    public void setXivSector(String xivSector) {
        this.xivSector = xivSector;
    }

    public String getXivId() {
        return xivId;
    }

    public void setXivId(String xivId) {
        this.xivId = xivId;
    }

    public String getXivNombres() {
        return xivNombres;
    }

    public void setXivNombres(String xivNombres) {
        this.xivNombres = xivNombres;
    }

    public String getXivApellidos() {
        return xivApellidos;
    }

    public void setXivApellidos(String xivApellidos) {
        this.xivApellidos = xivApellidos;
    }

    public Character getXivGenero() {
        return xivGenero;
    }

    public void setXivGenero(Character xivGenero) {
        this.xivGenero = xivGenero;
    }

    public String getXivFechaIngreso() {
        return xivFechaIngreso;
    }

    public void setXivFechaIngreso(String xivFechaIngreso) {
        this.xivFechaIngreso = xivFechaIngreso;
    }

    public String getXivCargo() {
        return xivCargo;
    }

    public void setXivCargo(String xivCargo) {
        this.xivCargo = xivCargo;
    }

    public BigDecimal getXivTotalIngresos() {
        return xivTotalIngresos;
    }

    public void setXivTotalIngresos(BigDecimal xivTotalIngresos) {
        this.xivTotalIngresos = xivTotalIngresos;
    }

    public Short getXivDiasLaborados() {
        return xivDiasLaborados;
    }

    public void setXivDiasLaborados(Short xivDiasLaborados) {
        this.xivDiasLaborados = xivDiasLaborados;
    }

    public BigDecimal getXivValorXivSueldo() {
        return xivValorXivSueldo;
    }

    public void setXivValorXivSueldo(BigDecimal xivValorXivSueldo) {
        this.xivValorXivSueldo = xivValorXivSueldo;
    }

    public Character getXivCodigoMinisterial() {
        return xivCodigoMinisterial;
    }

    public void setXivCodigoMinisterial(Character xivCodigoMinisterial) {
        this.xivCodigoMinisterial = xivCodigoMinisterial;
    }

    public String getXivPeriodo() {
        return xivPeriodo;
    }

    public void setXivPeriodo(String xivPeriodo) {
        this.xivPeriodo = xivPeriodo;
    }

    public String getXivTipo() {
        return xivTipo;
    }

    public void setXivTipo(String xivTipo) {
        this.xivTipo = xivTipo;
    }

    public String getXivNumero() {
        return xivNumero;
    }

    public void setXivNumero(String xivNumero) {
        this.xivNumero = xivNumero;
    }

   

}
