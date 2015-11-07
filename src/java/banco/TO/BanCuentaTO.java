/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.TO;

/**
 *
 * @author jack
 */
public class BanCuentaTO implements java.io.Serializable{
    private String ctaEmpresa;
    private String ctaContable;
    private String ctaNumero;
    private String ctaTitular;
    private String ctaOficial;
    private String ctaCodigoBancario;
    private String ctaPrefijoBancario;
    private String ctaFormatoCheque;
    private String usrInsertaCuenta;
    private String usrInsertaEmpresa;
    private String usrFechaInsertaCuenta;

    public BanCuentaTO() {
    }

    public BanCuentaTO(String ctaEmpresa, String ctaContable, String ctaNumero, String ctaTitular, String ctaOficial, String ctaCodigoBancario, String ctaPrefijoBancario, String ctaFormatoCheque, String usrInsertaCuenta, String usrInsertaEmpresa, String usrFechaInsertaCuenta) {
        this.ctaEmpresa = ctaEmpresa;
        this.ctaContable = ctaContable;
        this.ctaNumero = ctaNumero;
        this.ctaTitular = ctaTitular;
        this.ctaOficial = ctaOficial;
        this.ctaCodigoBancario = ctaCodigoBancario;
        this.ctaPrefijoBancario = ctaPrefijoBancario;
        this.ctaFormatoCheque = ctaFormatoCheque;
        this.usrInsertaCuenta = usrInsertaCuenta;
        this.usrInsertaEmpresa = usrInsertaEmpresa;
        this.usrFechaInsertaCuenta = usrFechaInsertaCuenta;
    }

    public String getCtaCodigoBancario() {
        return ctaCodigoBancario;
    }

    public void setCtaCodigoBancario(String ctaCodigoBancario) {
        this.ctaCodigoBancario = ctaCodigoBancario;
    }

    public String getCtaContable() {
        return ctaContable;
    }

    public void setCtaContable(String ctaContable) {
        this.ctaContable = ctaContable;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getCtaFormatoCheque() {
        return ctaFormatoCheque;
    }

    public void setCtaFormatoCheque(String ctaFormatoCheque) {
        this.ctaFormatoCheque = ctaFormatoCheque;
    }

    public String getCtaNumero() {
        return ctaNumero;
    }

    public void setCtaNumero(String ctaNumero) {
        this.ctaNumero = ctaNumero;
    }

    public String getCtaOficial() {
        return ctaOficial;
    }

    public void setCtaOficial(String ctaOficial) {
        this.ctaOficial = ctaOficial;
    }

    public String getCtaPrefijoBancario() {
        return ctaPrefijoBancario;
    }

    public void setCtaPrefijoBancario(String ctaPrefijoBancario) {
        this.ctaPrefijoBancario = ctaPrefijoBancario;
    }

    public String getCtaTitular() {
        return ctaTitular;
    }

    public void setCtaTitular(String ctaTitular) {
        this.ctaTitular = ctaTitular;
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

    public String getUsrInsertaEmpresa() {
        return usrInsertaEmpresa;
    }

    public void setUsrInsertaEmpresa(String usrInsertaEmpresa) {
        this.usrInsertaEmpresa = usrInsertaEmpresa;
    }
}
