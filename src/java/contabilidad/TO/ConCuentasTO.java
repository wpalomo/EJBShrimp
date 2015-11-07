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
public class ConCuentasTO implements Serializable{
    private String empCodigo;
    private String cuentaCodigo;
    private String cuentaDetalle;
    private Boolean cuentaActivo;
    private String usrInsertaCuenta;
    private String usrFechaInsertaCuenta;

    public ConCuentasTO() {
    }

    public ConCuentasTO(String cuentaCodigo, String cuentaDetalle) {
        this.cuentaCodigo = cuentaCodigo;
        this.cuentaDetalle = cuentaDetalle;
    }
    
    public ConCuentasTO(String empCodigo, String cuentaCodigo, String cuentaDetalle, Boolean cuentaActivo, String usrInsertaCuenta, String usrFechaInsertaCuenta) {
        this.empCodigo = empCodigo;
        this.cuentaCodigo = cuentaCodigo;
        this.cuentaDetalle = cuentaDetalle;
        this.cuentaActivo = cuentaActivo;
        this.usrInsertaCuenta = usrInsertaCuenta;
        this.usrFechaInsertaCuenta = usrFechaInsertaCuenta;
    }

    public Boolean getCuentaActivo() {
        return cuentaActivo;
    }

    public void setCuentaActivo(Boolean cuentaActivo) {
        this.cuentaActivo = cuentaActivo;
    }

    public String getCuentaCodigo() {
        return cuentaCodigo;
    }

    public void setCuentaCodigo(String cuentaCodigo) {
        this.cuentaCodigo = cuentaCodigo;
    }

    public String getCuentaDetalle() {
        return cuentaDetalle;
    }

    public void setCuentaDetalle(String cuentaDetalle) {
        this.cuentaDetalle = cuentaDetalle;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getUsrFechaInsertaCuenta() {
        return usrFechaInsertaCuenta;
    }

    public void setUsrFechaInsertaCuenta(String usrFechaInsertaCuenta) {
        this.usrFechaInsertaCuenta = usrFechaInsertaCuenta;
    }

    public String getUsrInsertaCuenta() {
        return usrInsertaCuenta;
    }

    public void setUsrInsertaCuenta(String usrInsertaCuenta) {
        this.usrInsertaCuenta = usrInsertaCuenta;
    }
    @Override
    public String toString(){
        return this.cuentaCodigo + " " + this.cuentaDetalle;
    }
}
