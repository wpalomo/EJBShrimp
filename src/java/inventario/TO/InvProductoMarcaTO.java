/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.TO;

/**
 *
 * @author developer2
 */
public class InvProductoMarcaTO implements java.io.Serializable{
    String marEmpresa;
    String marCodigo;
    String marDetalle;
    String marAbreviado;
    String usrEmpresa;
    String usrCodigo;
    String usrFechaInserta;

    public InvProductoMarcaTO() {
    }
    
    public InvProductoMarcaTO(String marEmpresa, String marCodigo, String marDetalle, String marAbreviado, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.marEmpresa = marEmpresa;
        this.marCodigo = marCodigo;
        this.marDetalle = marDetalle;
        this.marAbreviado = marAbreviado;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public String getMarAbreviado() {
        return marAbreviado;
    }

    public void setMarAbreviado(String marAbreviado) {
        this.marAbreviado = marAbreviado;
    }

    public String getMarCodigo() {
        return marCodigo;
    }

    public void setMarCodigo(String marCodigo) {
        this.marCodigo = marCodigo;
    }

    public String getMarDetalle() {
        return marDetalle;
    }

    public void setMarDetalle(String marDetalle) {
        this.marDetalle = marDetalle;
    }

    public String getMarEmpresa() {
        return marEmpresa;
    }

    public void setMarEmpresa(String marEmpresa) {
        this.marEmpresa = marEmpresa;
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
