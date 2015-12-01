/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cartera.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class CarComboPagosCobrosFormaTO implements Serializable{
    private Integer fpSecuencial;
    private String fpDetalle;
    private String ctaCodigo;
    private Boolean validar;
    private Boolean postFechados;
    

    public CarComboPagosCobrosFormaTO() {
    }

    public CarComboPagosCobrosFormaTO(Integer fpSecuencial, String fpDetalle, String ctaCodigo, Boolean validar,
            Boolean postFechados) {
        this.fpSecuencial = fpSecuencial;
        this.fpDetalle = fpDetalle;
        this.ctaCodigo = ctaCodigo;
        this.validar = validar;
        this.postFechados = postFechados;
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

    public Integer getFpSecuencial() {
        return fpSecuencial;
    }

    public void setFpSecuencial(Integer fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
    }

    public Boolean getValidar() {
        return validar;
    }

    public void setValidar(Boolean validar) {
        this.validar = validar;
    }

    public Boolean getPostFechados() {
        return postFechados;
    }

    public void setPostFechados(Boolean postFechados) {
        this.postFechados = postFechados;
    }
    
    
    
    @Override
    public String toString(){
        return this.fpDetalle;
    }
}
