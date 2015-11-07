/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabilidad.TO;

import java.io.Serializable;

/**
 *
 * @author jack
 */
public class ConContableTO implements Serializable{
    private String empCodigo;
    private String perCodigo;
    private String tipCodigo;
    private String conNumero;
    private String conFecha;
    private Boolean conPendiente;
    private Boolean conBloqueado;
    private Boolean conAnulado;
    private Boolean conGenerado;
    private String conConcepto;
    private String conDetalle;
    private String conObservaciones;
    private String usrInsertaContable;
    private String usrFechaInsertaContable;

    public ConContableTO() {
    }

    public ConContableTO(String empCodigo, String perCodigo, String tipCodigo, String conNumero, String conFecha, Boolean conPendiente, Boolean conBloqueado, Boolean conAnulado, Boolean conGenerado, String conConcepto, String conDetalle, String conObservaciones, String usrInsertaContable, String usrFechaInsertaContable) {
        this.empCodigo = empCodigo;
        this.perCodigo = perCodigo;
        this.tipCodigo = tipCodigo;
        this.conNumero = conNumero;
        this.conFecha = conFecha;
        this.conPendiente = conPendiente;
        this.conBloqueado = conBloqueado;
        this.conAnulado = conAnulado;
        this.conGenerado = conGenerado;
        this.conConcepto = conConcepto;
        this.conDetalle = conDetalle;
        this.conObservaciones = conObservaciones;
        this.usrInsertaContable = usrInsertaContable;
        this.usrFechaInsertaContable = usrFechaInsertaContable;
    }

    public Boolean getConAnulado() {
        return conAnulado;
    }

    public void setConAnulado(Boolean conAnulado) {
        this.conAnulado = conAnulado;
    }

    public Boolean getConBloqueado() {
        return conBloqueado;
    }

    public void setConBloqueado(Boolean conBloqueado) {
        this.conBloqueado = conBloqueado;
    }

    public String getConConcepto() {
        return conConcepto;
    }

    public void setConConcepto(String conConcepto) {
        this.conConcepto = conConcepto;
    }

    public String getConDetalle() {
        return conDetalle;
    }

    public void setConDetalle(String conDetalle) {
        this.conDetalle = conDetalle;
    }

    public String getConFecha() {
        return conFecha;
    }

    public void setConFecha(String conFecha) {
        this.conFecha = conFecha;
    }

    public Boolean getConGenerado() {
        return conGenerado;
    }

    public void setConGenerado(Boolean conGenerado) {
        this.conGenerado = conGenerado;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConObservaciones() {
        return conObservaciones;
    }

    public void setConObservaciones(String conObservaciones) {
        this.conObservaciones = conObservaciones;
    }

    public Boolean getConPendiente() {
        return conPendiente;
    }

    public void setConPendiente(Boolean conPendiente) {
        this.conPendiente = conPendiente;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getUsrFechaInsertaContable() {
        return usrFechaInsertaContable;
    }

    public void setUsrFechaInsertaContable(String usrFechaInsertaContable) {
        this.usrFechaInsertaContable = usrFechaInsertaContable;
    }

    public String getUsrInsertaContable() {
        return usrInsertaContable;
    }

    public void setUsrInsertaContable(String usrInsertaContable) {
        this.usrInsertaContable = usrInsertaContable;
    }


    @Override
    public String toString(){
        return this.empCodigo + " " + this.perCodigo + " " + this.tipCodigo
                + " " + this.conNumero + " " + this.conFecha
                + " " + this.conPendiente + " " + this.conBloqueado
                + " " + this.conAnulado + " " + this.conGenerado
                + " " + this.conConcepto
                + " " + this.conDetalle + " " + this.conObservaciones
                + " " + this.usrInsertaContable + " " + this.usrFechaInsertaContable;
    }
}
