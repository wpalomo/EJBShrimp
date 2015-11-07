/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.TO;

/**
 *
 * @author jack
 */
public class ConsultaDatosBancoCuentaTO implements java.io.Serializable{
    private String ctaNumero;
    private String ctaTitular;
    private String banNombre;
    private String rutaBanco;

    public ConsultaDatosBancoCuentaTO() {
    }

    public ConsultaDatosBancoCuentaTO(String ctaNumero, String ctaTitular, String banNombre, String rutaBanco) {
        this.ctaNumero = ctaNumero;
        this.ctaTitular = ctaTitular;
        this.banNombre = banNombre;
        this.rutaBanco = rutaBanco;
    }

    public String getBanNombre() {
        return banNombre;
    }

    public void setBanNombre(String banNombre) {
        this.banNombre = banNombre;
    }

    public String getCtaNumero() {
        return ctaNumero;
    }

    public void setCtaNumero(String ctaNumero) {
        this.ctaNumero = ctaNumero;
    }

    public String getCtaTitular() {
        return ctaTitular;
    }

    public void setCtaTitular(String ctaTitular) {
        this.ctaTitular = ctaTitular;
    }

    public String getRutaBanco() {
        return rutaBanco;
    }

    public void setRutaBanco(String rutaBanco) {
        this.rutaBanco = rutaBanco;
    }

    @Override
    public String toString(){
        return this.ctaNumero + " " + this.ctaTitular + " " + this.banNombre + " " + this.rutaBanco;
    }
}
