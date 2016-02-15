/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.TO;

/**
 *
 * @author misael
 */
public class SisInfoTO implements java.io.Serializable {
    private String infEmpresa;
    private String infUsuario;
    private String infMac;
    private String infEmpresaRuc;

    public SisInfoTO() {
    }

    public SisInfoTO(String infEmpresa, String infUsuario, String infMac, String infEmpresaRuc) {
        this.infEmpresa = infEmpresa;
        this.infUsuario = infUsuario;
        this.infMac = infMac;
        this.infEmpresaRuc = infEmpresaRuc;
    }

    public String getInfEmpresa() {
        return infEmpresa;
    }

    public void setInfEmpresa(String infEmpresa) {
        this.infEmpresa = infEmpresa;
    }

    public String getInfEmpresaRuc() {
        return infEmpresaRuc;
    }

    public void setInfEmpresaRuc(String infEmpresaRuc) {
        this.infEmpresaRuc = infEmpresaRuc;
    }

    public String getInfMac() {
        return infMac;
    }

    public void setInfMac(String infMac) {
        this.infMac = infMac;
    }

    public String getInfUsuario() {
        return infUsuario;
    }

    public void setInfUsuario(String infUsuario) {
        this.infUsuario = infUsuario;
    }
}
