/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class SisErrorTO implements Serializable {

    private Integer erSecuencia;
    private String erSentencia;
    private String erClase;
    private String erArchivo;
    private String erLinea;
    private String erMetodo;
    private String infMac;
    private String empCodigo;
    private String usrCodigo;
    private String erFecha;

    public SisErrorTO() {
    }

    public SisErrorTO(Integer erSecuencia, String erSentencia, String erClase, String erArchivo, String erLinea, String erMetodo, String infMac, String empCodigo, String usrCodigo, String erFecha) {
        this.erSecuencia = erSecuencia;
        this.erSentencia = erSentencia;
        this.erClase = erClase;
        this.erArchivo = erArchivo;
        this.erLinea = erLinea;
        this.erMetodo = erMetodo;
        this.infMac = infMac;
        this.empCodigo = empCodigo;
        this.usrCodigo = usrCodigo;
        this.erFecha = erFecha;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getErArchivo() {
        return erArchivo;
    }

    public void setErArchivo(String erArchivo) {
        this.erArchivo = erArchivo;
    }

    public String getErClase() {
        return erClase;
    }

    public void setErClase(String erClase) {
        this.erClase = erClase;
    }

    public String getErFecha() {
        return erFecha;
    }

    public void setErFecha(String erFecha) {
        this.erFecha = erFecha;
    }

    public String getErLinea() {
        return erLinea;
    }

    public void setErLinea(String erLinea) {
        this.erLinea = erLinea;
    }

    public String getErMetodo() {
        return erMetodo;
    }

    public void setErMetodo(String erMetodo) {
        this.erMetodo = erMetodo;
    }

    public Integer getErSecuencia() {
        return erSecuencia;
    }

    public void setErSecuencia(Integer erSecuencia) {
        this.erSecuencia = erSecuencia;
    }

    public String getErSentencia() {
        return erSentencia;
    }

    public void setErSentencia(String erSentencia) {
        this.erSentencia = erSentencia;
    }

    public String getInfMac() {
        return infMac;
    }

    public void setInfMac(String infMac) {
        this.infMac = infMac;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }
    
}
