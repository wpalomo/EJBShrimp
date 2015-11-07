/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

/**
 *
 * @author jack
 */
public class PiscinaNombres {
    private String graPiscina;
    private String graEdad;
    private String corFechaSiembra;

    public PiscinaNombres() {
    }

    public PiscinaNombres(String graPiscina, String graEdad, String corFechaSiembra) {
        this.graPiscina = graPiscina;
        this.graEdad = graEdad;
        this.corFechaSiembra = corFechaSiembra;
    }

    public String getCorFechaSiembra() {
        return corFechaSiembra;
    }

    public void setCorFechaSiembra(String corFechaSiembra) {
        this.corFechaSiembra = corFechaSiembra;
    }

    public String getGraEdad() {
        return graEdad;
    }

    public void setGraEdad(String graEdad) {
        this.graEdad = graEdad;
    }

    public String getGraPiscina() {
        return graPiscina;
    }

    public void setGraPiscina(String graPiscina) {
        this.graPiscina = graPiscina;
    }
}
