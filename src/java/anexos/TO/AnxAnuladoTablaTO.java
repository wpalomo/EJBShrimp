/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

/**
 *
 * @author jack
 */
public class AnxAnuladoTablaTO implements java.io.Serializable{
    private Integer anuSecuencial;
    private String anuComprobanteTipo;
    private String anuComprobanteEstablecimiento;
    private String anuComprobantePuntoEmision;
    private String anuSecuencialInicio;
    private String anuSecuencialFin;
    private String anuSecuencialInicial;
    private String anuSecuencialFinal;
    private String anuAutorizacion;
    private String anuFecha;
    private String tcDescripcion;

    public AnxAnuladoTablaTO() {
    }

    public AnxAnuladoTablaTO(Integer anuSecuencial, String anuComprobanteTipo, String anuComprobanteEstablecimiento, String anuComprobantePuntoEmision, String anuSecuencialInicio, String anuSecuencialFin, String anuSecuencialInicial, String anuSecuencialFinal, String anuAutorizacion, String anuFecha, String tcDescripcion) {
        this.anuSecuencial = anuSecuencial;
        this.anuComprobanteTipo = anuComprobanteTipo;
        this.anuComprobanteEstablecimiento = anuComprobanteEstablecimiento;
        this.anuComprobantePuntoEmision = anuComprobantePuntoEmision;
        this.anuSecuencialInicio = anuSecuencialInicio;
        this.anuSecuencialFin = anuSecuencialFin;
        this.anuSecuencialInicial = anuSecuencialInicial;
        this.anuSecuencialFinal = anuSecuencialFinal;
        this.anuAutorizacion = anuAutorizacion;
        this.anuFecha = anuFecha;
        this.tcDescripcion = tcDescripcion;
    }

    public String getAnuAutorizacion() {
        return anuAutorizacion;
    }

    public void setAnuAutorizacion(String anuAutorizacion) {
        this.anuAutorizacion = anuAutorizacion;
    }

    public String getAnuComprobanteEstablecimiento() {
        return anuComprobanteEstablecimiento;
    }

    public void setAnuComprobanteEstablecimiento(String anuComprobanteEstablecimiento) {
        this.anuComprobanteEstablecimiento = anuComprobanteEstablecimiento;
    }

    public String getAnuComprobantePuntoEmision() {
        return anuComprobantePuntoEmision;
    }

    public void setAnuComprobantePuntoEmision(String anuComprobantePuntoEmision) {
        this.anuComprobantePuntoEmision = anuComprobantePuntoEmision;
    }

    public String getAnuComprobanteTipo() {
        return anuComprobanteTipo;
    }

    public void setAnuComprobanteTipo(String anuComprobanteTipo) {
        this.anuComprobanteTipo = anuComprobanteTipo;
    }

    public String getAnuFecha() {
        return anuFecha;
    }

    public void setAnuFecha(String anuFecha) {
        this.anuFecha = anuFecha;
    }

    public Integer getAnuSecuencial() {
        return anuSecuencial;
    }

    public void setAnuSecuencial(Integer anuSecuencial) {
        this.anuSecuencial = anuSecuencial;
    }

    public String getAnuSecuencialFin() {
        return anuSecuencialFin;
    }

    public void setAnuSecuencialFin(String anuSecuencialFin) {
        this.anuSecuencialFin = anuSecuencialFin;
    }

    public String getAnuSecuencialFinal() {
        return anuSecuencialFinal;
    }

    public void setAnuSecuencialFinal(String anuSecuencialFinal) {
        this.anuSecuencialFinal = anuSecuencialFinal;
    }

    public String getAnuSecuencialInicial() {
        return anuSecuencialInicial;
    }

    public void setAnuSecuencialInicial(String anuSecuencialInicial) {
        this.anuSecuencialInicial = anuSecuencialInicial;
    }

    public String getAnuSecuencialInicio() {
        return anuSecuencialInicio;
    }

    public void setAnuSecuencialInicio(String anuSecuencialInicio) {
        this.anuSecuencialInicio = anuSecuencialInicio;
    }

    public String getTcDescripcion() {
        return tcDescripcion;
    }

    public void setTcDescripcion(String tcDescripcion) {
        this.tcDescripcion = tcDescripcion;
    }
}
