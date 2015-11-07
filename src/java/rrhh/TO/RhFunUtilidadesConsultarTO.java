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
public class RhFunUtilidadesConsultarTO implements Serializable{
    
    private String utiCategoria;
    private String utiSector;
    private String utiId;
    private String utiNombres;
    private String utiApellidos;
    private Character utiGenero;
    private String utiFechaIngreso;
    private String utiCargo;
    private java.math.BigDecimal utiTotalIngresos;
    private Short utiDiasLaborados;
    private java.math.BigDecimal utiValorUtilidades;
    private Character utiCodigoMinisterial;
    private String utiPeriodo;
    private String utiTipo;
    private String utiNumero;

    public RhFunUtilidadesConsultarTO() {
    }

    public RhFunUtilidadesConsultarTO(String utiCategoria, String utiSector, String utiId, String utiNombres, String utiApellidos, Character utiGenero, String utiFechaIngreso, String utiCargo, BigDecimal utiTotalIngresos, Short utiDiasLaborados, BigDecimal utiValorUtilidades, Character utiCodigoMinisterial, String utiPeriodo, String utiTipo, String utiNumero) {
        this.utiCategoria = utiCategoria;
        this.utiSector = utiSector;
        this.utiId = utiId;
        this.utiNombres = utiNombres;
        this.utiApellidos = utiApellidos;
        this.utiGenero = utiGenero;
        this.utiFechaIngreso = utiFechaIngreso;
        this.utiCargo = utiCargo;
        this.utiTotalIngresos = utiTotalIngresos;
        this.utiDiasLaborados = utiDiasLaborados;
        this.utiValorUtilidades = utiValorUtilidades;
        this.utiCodigoMinisterial = utiCodigoMinisterial;
        this.utiPeriodo = utiPeriodo;
        this.utiTipo = utiTipo;
        this.utiNumero = utiNumero;
    }

    public String getUtiCategoria() {
        return utiCategoria;
    }

    public void setUtiCategoria(String utiCategoria) {
        this.utiCategoria = utiCategoria;
    }

    public String getUtiSector() {
        return utiSector;
    }

    public void setUtiSector(String utiSector) {
        this.utiSector = utiSector;
    }

    public String getUtiId() {
        return utiId;
    }

    public void setUtiId(String utiId) {
        this.utiId = utiId;
    }

    public String getUtiNombres() {
        return utiNombres;
    }

    public void setUtiNombres(String utiNombres) {
        this.utiNombres = utiNombres;
    }

    public String getUtiApellidos() {
        return utiApellidos;
    }

    public void setUtiApellidos(String utiApellidos) {
        this.utiApellidos = utiApellidos;
    }

    public Character getUtiGenero() {
        return utiGenero;
    }

    public void setUtiGenero(Character utiGenero) {
        this.utiGenero = utiGenero;
    }

    public String getUtiFechaIngreso() {
        return utiFechaIngreso;
    }

    public void setUtiFechaIngreso(String utiFechaIngreso) {
        this.utiFechaIngreso = utiFechaIngreso;
    }

    public String getUtiCargo() {
        return utiCargo;
    }

    public void setUtiCargo(String utiCargo) {
        this.utiCargo = utiCargo;
    }

    public BigDecimal getUtiTotalIngresos() {
        return utiTotalIngresos;
    }

    public void setUtiTotalIngresos(BigDecimal utiTotalIngresos) {
        this.utiTotalIngresos = utiTotalIngresos;
    }

    public Short getUtiDiasLaborados() {
        return utiDiasLaborados;
    }

    public void setUtiDiasLaborados(Short utiDiasLaborados) {
        this.utiDiasLaborados = utiDiasLaborados;
    }

    public BigDecimal getUtiValorUtilidades() {
        return utiValorUtilidades;
    }

    public void setUtiValorUtilidades(BigDecimal utiValorUtilidades) {
        this.utiValorUtilidades = utiValorUtilidades;
    }

    public Character getUtiCodigoMinisterial() {
        return utiCodigoMinisterial;
    }

    public void setUtiCodigoMinisterial(Character utiCodigoMinisterial) {
        this.utiCodigoMinisterial = utiCodigoMinisterial;
    }

    public String getUtiPeriodo() {
        return utiPeriodo;
    }

    public void setUtiPeriodo(String utiPeriodo) {
        this.utiPeriodo = utiPeriodo;
    }

    public String getUtiTipo() {
        return utiTipo;
    }

    public void setUtiTipo(String utiTipo) {
        this.utiTipo = utiTipo;
    }

    public String getUtiNumero() {
        return utiNumero;
    }

    public void setUtiNumero(String utiNumero) {
        this.utiNumero = utiNumero;
    }
  

}
