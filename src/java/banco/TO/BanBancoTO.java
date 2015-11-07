/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.TO;

/**
 *
 * @author jack
 */
public class BanBancoTO implements java.io.Serializable {
    private String empCodigo;
    private String banCodigo;
    private String banNombre;
    private String usrInsertaBanco;
    private String usrFechaInsertaBanco;

    public BanBancoTO() {
    }

    public BanBancoTO(String empCodigo, String banCodigo, String banNombre, String usrInsertaBanco, String usrFechaInsertaBanco) {
        this.empCodigo = empCodigo;
        this.banCodigo = banCodigo;
        this.banNombre = banNombre;
        this.usrInsertaBanco = usrInsertaBanco;
        this.usrFechaInsertaBanco = usrFechaInsertaBanco;
    }

    public String getBanCodigo() {
        return banCodigo;
    }

    public void setBanCodigo(String banCodigo) {
        this.banCodigo = banCodigo;
    }

    public String getBanNombre() {
        return banNombre;
    }

    public void setBanNombre(String banNombre) {
        this.banNombre = banNombre;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getUsrFechaInsertaBanco() {
        return usrFechaInsertaBanco;
    }

    public void setUsrFechaInsertaBanco(String usrFechaInsertaBanco) {
        this.usrFechaInsertaBanco = usrFechaInsertaBanco;
    }

    public String getUsrInsertaBanco() {
        return usrInsertaBanco;
    }

    public void setUsrInsertaBanco(String usrInsertaBanco) {
        this.usrInsertaBanco = usrInsertaBanco;
    }

    public String retornoDatos(){
        return this.empCodigo + " " + this.banCodigo + " " + this.banNombre + " " +
                this.usrInsertaBanco + " " + this.usrFechaInsertaBanco;
    }

}
