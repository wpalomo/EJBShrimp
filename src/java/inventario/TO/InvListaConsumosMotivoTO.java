/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvListaConsumosMotivoTO implements java.io.Serializable{
    private String cmCodigo;
    private String cmDetalle;
    private Boolean cmInactivo;
    private String formaContabilisar;

    public InvListaConsumosMotivoTO() {
    }

    public InvListaConsumosMotivoTO(String cmCodigo, String cmDetalle, Boolean cmInactivo, String formaContabilisar) {
        this.cmCodigo = cmCodigo;
        this.cmDetalle = cmDetalle;
        this.cmInactivo = cmInactivo;
        this.formaContabilisar = formaContabilisar;
    }

    public String getFormaContabilisar() {
        return formaContabilisar;
    }

    public void setFormaContabilisar(String formaContabilisar) {
        this.formaContabilisar = formaContabilisar;
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
}
