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
public class CarPagosTO implements Serializable{
//    private String pagEmpresa;
    private String conApellidosNombres;
    private String pagPeriodo;
    private String pagTipo;
    private String pagNumero;
    private Boolean pagReversado;
    private String pagFecha;//EJB contable
    private String pagObservaciones;//EJB contable
//    private Boolean pagPendiente;
//    private Boolean pagAnulado;

//    private String provEmpresa;
    private String provCodigo;

//    private String contEmpresa;
//    private String contPeriodo;
//    private String contTipo;
//    private String contNumero;

    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public CarPagosTO() {
    }

    public CarPagosTO(String conApellidosNombres, String pagPeriodo, String pagTipo, String pagNumero, Boolean pagReversado, String pagFecha, String pagObservaciones, String provCodigo, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.conApellidosNombres = conApellidosNombres;
        this.pagPeriodo = pagPeriodo;
        this.pagTipo = pagTipo;
        this.pagNumero = pagNumero;
        this.pagReversado = pagReversado;
        this.pagFecha = pagFecha;
        this.pagObservaciones = pagObservaciones;
        this.provCodigo = provCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Boolean getPagReversado() {
        return pagReversado;
    }

    public void setPagReversado(Boolean pagReversado) {
        this.pagReversado = pagReversado;
    }

    public String getConApellidosNombres() {
        return conApellidosNombres;
    }

    public void setConApellidosNombres(String conApellidosNombres) {
        this.conApellidosNombres = conApellidosNombres;
    }

    public String getPagFecha() {
        return pagFecha;
    }

    public void setPagFecha(String pagFecha) {
        this.pagFecha = pagFecha;
    }

    public String getPagNumero() {
        return pagNumero;
    }

    public void setPagNumero(String pagNumero) {
        this.pagNumero = pagNumero;
    }

    public String getPagObservaciones() {
        return pagObservaciones;
    }

    public void setPagObservaciones(String pagObservaciones) {
        this.pagObservaciones = pagObservaciones;
    }

    public String getPagPeriodo() {
        return pagPeriodo;
    }

    public void setPagPeriodo(String pagPeriodo) {
        this.pagPeriodo = pagPeriodo;
    }

    public String getPagTipo() {
        return pagTipo;
    }

    public void setPagTipo(String pagTipo) {
        this.pagTipo = pagTipo;
    }

    public String getProvCodigo() {
        return provCodigo;
    }

    public void setProvCodigo(String provCodigo) {
        this.provCodigo = provCodigo;
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
