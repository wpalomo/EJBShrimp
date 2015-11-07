/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.TO;

/**
 *
 * @author jack
 */
public class InvComprasMotivoTO implements java.io.Serializable {

    private String cmEmpresa;
    private String cmCodigo;
    private String cmDetalle;
    private String cmFormaContabilizar;
    private String cmFormaImprimir;
    private Boolean cmAjustesDeInventario;
    private Boolean cmInactivo;
    private String tipCodigo;
    private String usrCodigo;
    private String usrFechaInserta;

    public InvComprasMotivoTO() {
    }

    public InvComprasMotivoTO(String cmEmpresa, String cmCodigo, String cmDetalle, String cmFormaContabilizar, String cmFormaImprimir, Boolean cmAjustesDeInventario, Boolean cmInactivo, String tipCodigo, String usrCodigo, String usrFechaInserta) {
        this.cmEmpresa = cmEmpresa;
        this.cmCodigo = cmCodigo;
        this.cmDetalle = cmDetalle;
        this.cmFormaContabilizar = cmFormaContabilizar;
        this.cmFormaImprimir = cmFormaImprimir;
        this.cmAjustesDeInventario = cmAjustesDeInventario;
        this.cmInactivo = cmInactivo;
        this.tipCodigo = tipCodigo;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Boolean getCmAjustesDeInventario() {
        return cmAjustesDeInventario;
    }

    public void setCmAjustesDeInventario(Boolean cmAjustesDeInventario) {
        this.cmAjustesDeInventario = cmAjustesDeInventario;
    }

    public String getCmFormaContabilizar() {
        return cmFormaContabilizar;
    }

    public void setCmFormaContabilizar(String cmFormaContabilizar) {
        this.cmFormaContabilizar = cmFormaContabilizar;
    }

    public String getCmFormaImprimir() {
        return cmFormaImprimir;
    }

    public void setCmFormaImprimir(String cmFormaImprimir) {
        this.cmFormaImprimir = cmFormaImprimir;
    }

    public String getCmEmpresa() {
        return cmEmpresa;
    }

    public void setCmEmpresa(String cmEmpresa) {
        this.cmEmpresa = cmEmpresa;
    }

    public String getCmCodigo() {
        return cmCodigo;
    }

    public void setCmCodigo(String cmCodigo) {
        this.cmCodigo = cmCodigo;
    }

    public String getCmDetalle() {
        return cmDetalle;
    }

    public void setCmDetalle(String cmDetalle) {
        this.cmDetalle = cmDetalle;
    }

    public Boolean getCmInactivo() {
        return cmInactivo;
    }

    public void setCmInactivo(Boolean cmInactivo) {
        this.cmInactivo = cmInactivo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
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
