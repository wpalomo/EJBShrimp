/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class BanComboBancoTO implements Serializable{
    private String banNombre;
    private String ctaNumero;
    private String ctaTitular;
    private String ctaContable;
    private String ctaCodigoBancario;
    private String ctaPrefijoBancario;

    public BanComboBancoTO() {
    }

    public BanComboBancoTO(String banNombre, String ctaNumero, String ctaTitular, String ctaContable, String ctaCodigoBancario, String ctaPrefijoBancario) {
        this.banNombre = banNombre;
        this.ctaNumero = ctaNumero;
        this.ctaTitular = ctaTitular;
        this.ctaContable = ctaContable;
        this.ctaCodigoBancario = ctaCodigoBancario;
        this.ctaPrefijoBancario = ctaPrefijoBancario;
    }

    public String getBanNombre() {
        return banNombre;
    }

    public void setBanNombre(String banNombre) {
        this.banNombre = banNombre;
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

    public String getCtaNumero() {
        return ctaNumero;
    }

    public void setCtaNumero(String ctaNumero) {
        this.ctaNumero = ctaNumero;
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

    @Override
    public String toString(){
        return this.banNombre +" - "+ this.ctaNumero;
    }
}
