/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvProveedorCategoriaTO implements java.io.Serializable{
    private String pcEmpresa;
    private String pcCodigo;
    private String pcDetalle;
    private Boolean pcAplicaRetencionIva;
    
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public InvProveedorCategoriaTO() {
    }

    public InvProveedorCategoriaTO(
            String pcEmpresa,               //(1)
            String pcCodigo,                //(2)
            String pcDetalle,               //(3)
            Boolean pcAplicaRetencionIva,   //(4)   
            String usrEmpresa,              //(9)
            String usrCodigo,               //(10)
            String usrFechaInserta) {       //(11)
        this.pcEmpresa = pcEmpresa;
        this.pcCodigo = pcCodigo;
        this.pcDetalle = pcDetalle;
        this.pcAplicaRetencionIva = pcAplicaRetencionIva;
        
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

  

    public String getPcCodigo() {
        return pcCodigo;
    }

    public void setPcCodigo(String pcCodigo) {
        this.pcCodigo = pcCodigo;
    }

    public String getPcDetalle() {
        return pcDetalle;
    }

    public void setPcDetalle(String pcDetalle) {
        this.pcDetalle = pcDetalle;
    }

    public String getPcEmpresa() {
        return pcEmpresa;
    }

    public void setPcEmpresa(String pcEmpresa) {
        this.pcEmpresa = pcEmpresa;
    }

    public Boolean getPcAplicaRetencionIva() {
        return pcAplicaRetencionIva;
    }

    public void setPcAplicaRetencionIva(Boolean pcAplicaRetencionIva) {
        this.pcAplicaRetencionIva = pcAplicaRetencionIva;
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