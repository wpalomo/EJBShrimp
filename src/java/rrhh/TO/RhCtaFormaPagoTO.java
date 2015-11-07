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
public class RhCtaFormaPagoTO implements Serializable{
    private String ctaCodigo;
    private String secCodigo;

    public RhCtaFormaPagoTO() {
    }

    public RhCtaFormaPagoTO(String ctaCodigo, String secCodigo) {
        this.ctaCodigo = ctaCodigo;
        this.secCodigo = secCodigo;
    }

    public String getCtaCodigo() {
        return ctaCodigo;
    }

    public void setCtaCodigo(String ctaCodigo) {
        this.ctaCodigo = ctaCodigo;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

}
