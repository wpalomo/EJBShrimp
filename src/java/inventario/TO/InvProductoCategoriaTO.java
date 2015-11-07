/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvProductoCategoriaTO implements java.io.Serializable{
    private String catEmpresa;
    private String catCodigo;
    private String catDetalle;
    private boolean catPrecioFijo;
    private boolean catActiva;
    private String ctaEmpresa;
    private String ctaCodigo;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public InvProductoCategoriaTO() {
    }

    public InvProductoCategoriaTO(String catEmpresa, String catCodigo, String catDetalle, boolean catPrecioFijo, boolean catActiva, String CtaEmpresa, String CtaCodigo, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.catEmpresa = catEmpresa;
        this.catCodigo = catCodigo;
        this.catDetalle = catDetalle;
        this.catPrecioFijo = catPrecioFijo;
        this.catActiva = catActiva;
        this.ctaEmpresa = CtaEmpresa;
        this.ctaCodigo = CtaCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public String getCtaCodigo() {
        return ctaCodigo;
    }

    public void setCtaCodigo(String CtaCodigo) {
        this.ctaCodigo = CtaCodigo;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String CtaEmpresa) {
        this.ctaEmpresa = CtaEmpresa;
    }

    public boolean isCatActiva() {
        return catActiva;
    }

    public void setCatActiva(boolean catActiva) {
        this.catActiva = catActiva;
    }

    public String getCatCodigo() {
        return catCodigo;
    }

    public void setCatCodigo(String catCodigo) {
        this.catCodigo = catCodigo;
    }

    public String getCatDetalle() {
        return catDetalle;
    }

    public void setCatDetalle(String catDetalle) {
        this.catDetalle = catDetalle;
    }

    public String getCatEmpresa() {
        return catEmpresa;
    }

    public void setCatEmpresa(String catEmpresa) {
        this.catEmpresa = catEmpresa;
    }

    public boolean isCatPrecioFijo() {
        return catPrecioFijo;
    }

    public void setCatPrecioFijo(boolean catPrecioFijo) {
        this.catPrecioFijo = catPrecioFijo;
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
