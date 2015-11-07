/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class InvListaComprasFormaPagoTO implements Serializable{
    private Integer fpSecuencial;
    private String fpDetalle;
    private Boolean fpInactivo;
    private String secCodigo;
    private String ctaCodigo;

    public InvListaComprasFormaPagoTO() {
    }

    public InvListaComprasFormaPagoTO(Integer fpSecuencial, String fpDetalle, Boolean fpInactivo, String secCodigo, String ctaCodigo) {
        this.fpSecuencial = fpSecuencial;
        this.fpDetalle = fpDetalle;
        this.fpInactivo = fpInactivo;
        this.secCodigo = secCodigo;
        this.ctaCodigo = ctaCodigo;
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

    public Boolean getFpInactivo() {
        return fpInactivo;
    }

    public void setFpInactivo(Boolean fpInactivo) {
        this.fpInactivo = fpInactivo;
    }

    public Integer getFpSecuencial() {
        return fpSecuencial;
    }

    public void setFpSecuencial(Integer fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

}
