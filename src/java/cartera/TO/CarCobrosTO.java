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
public class CarCobrosTO implements Serializable{
    private String conApellidosNombres;
    private String cobPeriodo;
    private String cobTipo;
    private String cobNumero;
    private Boolean cobReversado;
    private String cobFecha;//EJB contable
    private String cobObservaciones;//EJB contable

    private String cliCodigo;

    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public CarCobrosTO() {
    }

    public CarCobrosTO(String conApellidosNombres, String cobPeriodo, String cobTipo, String cobNumero, Boolean cobReversado, String cobFecha, String cobObservaciones, String cliCodigo, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.conApellidosNombres = conApellidosNombres;
        this.cobPeriodo = cobPeriodo;
        this.cobTipo = cobTipo;
        this.cobNumero = cobNumero;
        this.cobReversado = cobReversado;
        this.cobFecha = cobFecha;
        this.cobObservaciones = cobObservaciones;
        this.cliCodigo = cliCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Boolean getCobReversado() {
        return cobReversado;
    }

    public void setCobReversado(Boolean cobReversado) {
        this.cobReversado = cobReversado;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCobFecha() {
        return cobFecha;
    }

    public void setCobFecha(String cobFecha) {
        this.cobFecha = cobFecha;
    }

    public String getCobNumero() {
        return cobNumero;
    }

    public void setCobNumero(String cobNumero) {
        this.cobNumero = cobNumero;
    }

    public String getCobObservaciones() {
        return cobObservaciones;
    }

    public void setCobObservaciones(String cobObservaciones) {
        this.cobObservaciones = cobObservaciones;
    }

    public String getCobPeriodo() {
        return cobPeriodo;
    }

    public void setCobPeriodo(String cobPeriodo) {
        this.cobPeriodo = cobPeriodo;
    }

    public String getCobTipo() {
        return cobTipo;
    }

    public void setCobTipo(String cobTipo) {
        this.cobTipo = cobTipo;
    }

    public String getConApellidosNombres() {
        return conApellidosNombres;
    }

    public void setConApellidosNombres(String conApellidosNombres) {
        this.conApellidosNombres = conApellidosNombres;
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
