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
public class RhRolLoteTO implements Serializable{

    private String rlId;
    private String rlNombres;
    private String rlCargo;
    private Integer rlDiasExtra;
    private Integer rlDiasFalta;
    private Integer rlDiasPermiso;
    private java.math.BigDecimal rlPrestamos;
    private Boolean rlAplica;

    public RhRolLoteTO(String rlId, String rlNombres, String rlCargo, Integer rlDiasExtra, Integer rlDiasFalta, Integer rlDiasPermiso, BigDecimal rlPrestamos, Boolean rlAplica) {
        this.rlId = rlId;
        this.rlNombres = rlNombres;
        this.rlCargo = rlCargo;
        this.rlDiasExtra = rlDiasExtra;
        this.rlDiasFalta = rlDiasFalta;
        this.rlDiasPermiso = rlDiasPermiso;
        this.rlPrestamos = rlPrestamos;
        this.rlAplica = rlAplica;
    }

    public Boolean getRlAplica() {
        return rlAplica;
    }

    public void setRlAplica(Boolean rlAplica) {
        this.rlAplica = rlAplica;
    }

    public String getRlCargo() {
        return rlCargo;
    }

    public void setRlCargo(String rlCargo) {
        this.rlCargo = rlCargo;
    }

    public Integer getRlDiasExtra() {
        return rlDiasExtra;
    }

    public void setRlDiasExtra(Integer rlDiasExtra) {
        this.rlDiasExtra = rlDiasExtra;
    }

    public Integer getRlDiasFalta() {
        return rlDiasFalta;
    }

    public void setRlDiasFalta(Integer rlDiasFalta) {
        this.rlDiasFalta = rlDiasFalta;
    }

    public Integer getRlDiasPermiso() {
        return rlDiasPermiso;
    }

    public void setRlDiasPermiso(Integer rlDiasPermiso) {
        this.rlDiasPermiso = rlDiasPermiso;
    }

    public String getRlId() {
        return rlId;
    }

    public void setRlId(String rlId) {
        this.rlId = rlId;
    }

    public String getRlNombres() {
        return rlNombres;
    }

    public void setRlNombres(String rlNombres) {
        this.rlNombres = rlNombres;
    }

    public BigDecimal getRlPrestamos() {
        return rlPrestamos;
    }

    public void setRlPrestamos(BigDecimal rlPrestamos) {
        this.rlPrestamos = rlPrestamos;
    }
}
