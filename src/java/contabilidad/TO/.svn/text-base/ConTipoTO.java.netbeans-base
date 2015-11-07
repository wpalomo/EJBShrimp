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
public class ConTipoTO implements Serializable {

    private String empCodigo;
    private String tipCodigo;
    private String tipDetalle;
    private Boolean tipInactivo;
    private String usrInsertaTipo;
    private String fechaInsertaTipo;

    public ConTipoTO() {
    }

    public ConTipoTO(String empCodigo, String tipCodigo, String tipDetalle, Boolean tipInactivo, String usrInsertaTipo, String fechaInsertaTipo) {
        this.empCodigo = empCodigo;
        this.tipCodigo = tipCodigo;
        this.tipDetalle = tipDetalle;
        this.tipInactivo = tipInactivo;
        this.usrInsertaTipo = usrInsertaTipo;
        this.fechaInsertaTipo = fechaInsertaTipo;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getFechaInsertaTipo() {
        return fechaInsertaTipo;
    }

    public void setFechaInsertaTipo(String fechaInsertaTipo) {
        this.fechaInsertaTipo = fechaInsertaTipo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipDetalle() {
        return tipDetalle;
    }

    public void setTipDetalle(String tipDetalle) {
        this.tipDetalle = tipDetalle;
    }

    public Boolean getTipInactivo() {
        return tipInactivo;
    }

    public void setTipInactivo(Boolean tipInactivo) {
        this.tipInactivo = tipInactivo;
    }

    public String getUsrInsertaTipo() {
        return usrInsertaTipo;
    }

    public void setUsrInsertaTipo(String usrInsertaTipo) {
        this.usrInsertaTipo = usrInsertaTipo;
    }
    
    @Override
    public String toString(){
        return this.tipCodigo + " - " + this.tipDetalle;
    }
}
