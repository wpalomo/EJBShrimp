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

                                                                     
public class RhFunUtilidadesTO implements Serializable{

    private String utiId;
    private String utiNombres;
    private String utiApellidos;
    private Character utiGenero;
    private String utiFechaIngreso;
    private String utiFechaSalida;
    private String utiCargo;
    private Integer utiCargasFamiliares;
    private Integer utiDiasLaborados;
    private java.math.BigDecimal utiValorPersonal;
    private java.math.BigDecimal utiValorCargas;
    private java.math.BigDecimal utiValorUtilidades;
    private String utiCategoria;
    private String utiCuenta;
    private String utiSector;
    private boolean estado;
 
   

    public RhFunUtilidadesTO() {
    }

    public RhFunUtilidadesTO(String utiId, String utiNombres, String utiApellidos, Character utiGenero, String utiFechaIngreso, String utiFechaSalida, String utiCargo, Integer utiCargasFamiliares, Integer utiDiasLaborados, BigDecimal utiValorPersonal, BigDecimal utiValorCargas, BigDecimal utiValorUtilidades, String utiCategoria, String utiCuenta, String utiSector, boolean estado) {
        this.utiId = utiId;
        this.utiNombres = utiNombres;
        this.utiApellidos = utiApellidos;
        this.utiGenero = utiGenero;
        this.utiFechaIngreso = utiFechaIngreso;
        this.utiFechaSalida = utiFechaSalida;
        this.utiCargo = utiCargo;
        this.utiCargasFamiliares = utiCargasFamiliares;
        this.utiDiasLaborados = utiDiasLaborados;
        this.utiValorPersonal = utiValorPersonal;
        this.utiValorCargas = utiValorCargas;
        this.utiValorUtilidades = utiValorUtilidades;
        this.utiCategoria = utiCategoria;
        this.utiCuenta = utiCuenta;
        this.utiSector = utiSector;
        this.estado = estado;
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

    public String getUtiFechaSalida() {
        return utiFechaSalida;
    }

    public void setUtiFechaSalida(String utiFechaSalida) {
        this.utiFechaSalida = utiFechaSalida;
    }

    public String getUtiCargo() {
        return utiCargo;
    }

    public void setUtiCargo(String utiCargo) {
        this.utiCargo = utiCargo;
    }

    public Integer getUtiCargasFamiliares() {
        return utiCargasFamiliares;
    }

    public void setUtiCargasFamiliares(Integer utiCargasFamiliares) {
        this.utiCargasFamiliares = utiCargasFamiliares;
    }

    public Integer getUtiDiasLaborados() {
        return utiDiasLaborados;
    }

    public void setUtiDiasLaborados(Integer utiDiasLaborados) {
        this.utiDiasLaborados = utiDiasLaborados;
    }

    public BigDecimal getUtiValorPersonal() {
        return utiValorPersonal;
    }

    public void setUtiValorPersonal(BigDecimal utiValorPersonal) {
        this.utiValorPersonal = utiValorPersonal;
    }

    public BigDecimal getUtiValorCargas() {
        return utiValorCargas;
    }

    public void setUtiValorCargas(BigDecimal utiValorCargas) {
        this.utiValorCargas = utiValorCargas;
    }

    public BigDecimal getUtiValorUtilidades() {
        return utiValorUtilidades;
    }

    public void setUtiValorUtilidades(BigDecimal utiValorUtilidades) {
        this.utiValorUtilidades = utiValorUtilidades;
    }

    public String getUtiCategoria() {
        return utiCategoria;
    }

    public void setUtiCategoria(String utiCategoria) {
        this.utiCategoria = utiCategoria;
    }

    public String getUtiCuenta() {
        return utiCuenta;
    }

    public void setUtiCuenta(String utiCuenta) {
        this.utiCuenta = utiCuenta;
    }

    public String getUtiSector() {
        return utiSector;
    }

    public void setUtiSector(String utiSector) {
        this.utiSector = utiSector;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    

  
}
