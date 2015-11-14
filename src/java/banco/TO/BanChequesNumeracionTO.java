/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.TO;

/**
 *
 * @author jack
 */
public class BanChequesNumeracionTO implements java.io.Serializable {

    private Integer banSecuencial;
    private Integer banDesde;
    private Integer banHasta;
    private String banCtaEmpresa;
    private String banCtaContable;

    public BanChequesNumeracionTO() {
    }

    public BanChequesNumeracionTO(Integer banSecuencial, Integer banDesde, Integer banHasta, String banCtaEmpresa, String banCtaContable) {
        this.banSecuencial = banSecuencial;
        this.banDesde = banDesde;
        this.banHasta = banHasta;
        this.banCtaEmpresa = banCtaEmpresa;
        this.banCtaContable = banCtaContable;
    }

    public String getBanCtaContable() {
        return banCtaContable;
    }

    public void setBanCtaContable(String banCtaContable) {
        this.banCtaContable = banCtaContable;
    }

    public String getBanCtaEmpresa() {
        return banCtaEmpresa;
    }

    public void setBanCtaEmpresa(String banCtaEmpresa) {
        this.banCtaEmpresa = banCtaEmpresa;
    }

    public Integer getBanDesde() {
        return banDesde;
    }

    public void setBanDesde(Integer banDesde) {
        this.banDesde = banDesde;
    }

    public Integer getBanHasta() {
        return banHasta;
    }

    public void setBanHasta(Integer banHasta) {
        this.banHasta = banHasta;
    }

    public Integer getBanSecuencial() {
        return banSecuencial;
    }

    public void setBanSecuencial(Integer banSecuencial) {
        this.banSecuencial = banSecuencial;
    }
}
