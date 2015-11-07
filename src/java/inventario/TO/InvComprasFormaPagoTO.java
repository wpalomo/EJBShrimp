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
public class InvComprasFormaPagoTO implements Serializable{
    private Integer fpSecuencial;
    private String fpDetalle;
    private Boolean fpInactivo;
//    private String secEmpresa;
    private String secCodigo;
//    private String ctaEmpresa;
    private String ctaCodigo;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public InvComprasFormaPagoTO() {
    }

    public InvComprasFormaPagoTO(Integer fpSecuencial, String fpDetalle, Boolean fpInactivo, String secCodigo, String ctaCodigo, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.fpSecuencial = fpSecuencial;
        this.fpDetalle = fpDetalle;
        this.fpInactivo = fpInactivo;
        this.secCodigo = secCodigo;
        this.ctaCodigo = ctaCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
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

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }
}
