/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.TO;

import java.io.Serializable;

/**
 *
 * @author javier tj
 */
public class PrdLiquidacionTallaTO implements Serializable{
    private String tallaEmpresa;
    private String tallaCodigo;
    private String tallaDetalle;
    private Boolean tallaInactivo;
    private String usrCodigo;
    private String usrFechaInserta;

    public PrdLiquidacionTallaTO() {
    }

    public PrdLiquidacionTallaTO(String tallaEmpresa, String tallaCodigo, String tallaDetalle, Boolean tallaInactivo, String usrCodigo, String usrFechaInserta) {
        this.tallaEmpresa = tallaEmpresa;
        this.tallaCodigo = tallaCodigo;
        this.tallaDetalle = tallaDetalle;
        this.tallaInactivo = tallaInactivo;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public String getTallaCodigo() {
        return tallaCodigo;
    }

    public void setTallaCodigo(String tallaCodigo) {
        this.tallaCodigo = tallaCodigo;
    }

    public String getTallaDetalle() {
        return tallaDetalle;
    }

    public void setTallaDetalle(String tallaDetalle) {
        this.tallaDetalle = tallaDetalle;
    }

    public String getTallaEmpresa() {
        return tallaEmpresa;
    }

    public void setTallaEmpresa(String tallaEmpresa) {
        this.tallaEmpresa = tallaEmpresa;
    }

    public Boolean getTallaInactivo() {
        return tallaInactivo;
    }

    public void setTallaInactivo(Boolean tallaInactivo) {
        this.tallaInactivo = tallaInactivo;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }
    
}
