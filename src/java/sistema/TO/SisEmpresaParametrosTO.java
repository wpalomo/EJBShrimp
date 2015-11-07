/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.TO;

/**
 *
 * @author jack
 */
public class SisEmpresaParametrosTO implements java.io.Serializable {
    private String parEmpresa;
    private String parActividad;
    private String parEscogerPrecioPor;

    public SisEmpresaParametrosTO() {
    }

    public SisEmpresaParametrosTO(String parEmpresa, String parActividad, String parEscogerPrecioPor) {
        this.parEmpresa = parEmpresa;
        this.parActividad = parActividad;
        this.parEscogerPrecioPor = parEscogerPrecioPor;
    }

    public String getParActividad() {
        return parActividad;
    }

    public void setParActividad(String parActividad) {
        this.parActividad = parActividad;
    }

    public String getParEmpresa() {
        return parEmpresa;
    }

    public void setParEmpresa(String parEmpresa) {
        this.parEmpresa = parEmpresa;
    }

    public String getParEscogerPrecioPor() {
        return parEscogerPrecioPor;
    }

    public void setParEscogerPrecioPor(String parEscogerPrecioPor) {
        this.parEscogerPrecioPor = parEscogerPrecioPor;
    }
}
