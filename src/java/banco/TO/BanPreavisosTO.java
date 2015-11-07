/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.TO;

/**
 *
 * @author jack
 */
public class BanPreavisosTO implements java.io.Serializable {
    private String preEmpresa;
    private String preCuentaContable;
    private String preNombreArchivoGenerado;
    private String preFechaRevisionUltimoCheque;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public BanPreavisosTO() {
    }

    public BanPreavisosTO(String preEmpresa, String preCuentaContable, String preNombreArchivoGenerado, String preFechaRevisionUltimoCheque, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.preEmpresa = preEmpresa;
        this.preCuentaContable = preCuentaContable;
        this.preNombreArchivoGenerado = preNombreArchivoGenerado;
        this.preFechaRevisionUltimoCheque = preFechaRevisionUltimoCheque;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public String getPreCuentaContable() {
        return preCuentaContable;
    }

    public void setPreCuentaContable(String preCuentaContable) {
        this.preCuentaContable = preCuentaContable;
    }

    public String getPreEmpresa() {
        return preEmpresa;
    }

    public void setPreEmpresa(String preEmpresa) {
        this.preEmpresa = preEmpresa;
    }

    public String getPreFechaRevisionUltimoCheque() {
        return preFechaRevisionUltimoCheque;
    }

    public void setPreFechaRevisionUltimoCheque(String preFechaRevisionUltimoCheque) {
        this.preFechaRevisionUltimoCheque = preFechaRevisionUltimoCheque;
    }

    public String getPreNombreArchivoGenerado() {
        return preNombreArchivoGenerado;
    }

    public void setPreNombreArchivoGenerado(String preNombreArchivoGenerado) {
        this.preNombreArchivoGenerado = preNombreArchivoGenerado;
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
