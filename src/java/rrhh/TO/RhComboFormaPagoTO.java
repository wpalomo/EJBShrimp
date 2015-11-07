/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class RhComboFormaPagoTO implements Serializable{
    private String fpDetalle;
    private String ctaCodigo;
    private Boolean validar;

    public RhComboFormaPagoTO() {
    }

    public RhComboFormaPagoTO(String fpDetalle, String ctaCodigo, Boolean validar) {
        this.fpDetalle = fpDetalle;
        this.ctaCodigo = ctaCodigo;
        this.validar = validar;
    }

    public String getCtaCodigo() {
        return ctaCodigo;
    }

    public void setCtaCodigo(String ctaCodigo) {
        this.ctaCodigo = ctaCodigo;
    }

    public String getFpDetalle() {
        return fpDetalle;
    }

    public void setFpDetalle(String fpDetalle) {
        this.fpDetalle = fpDetalle;
    }

    public Boolean getValidar() {
        return validar;
    }

    public void setValidar(Boolean validar) {
        this.validar = validar;
    }

    @Override
    public String toString(){
        return this.fpDetalle;
    }

}
