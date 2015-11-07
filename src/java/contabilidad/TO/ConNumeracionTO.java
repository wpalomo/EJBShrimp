/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabilidad.TO;

/**
 *
 * @author jack
 */
public class ConNumeracionTO implements java.io.Serializable{
    private String numEmpresa;
    private String numPeriodo;
    private String numTipo;
    private Integer numSecuencia;

    public ConNumeracionTO() {
    }

    public ConNumeracionTO(String numEmpresa, String numPeriodo, String numTipo, Integer numSecuencia) {
        this.numEmpresa = numEmpresa;
        this.numPeriodo = numPeriodo;
        this.numTipo = numTipo;
        this.numSecuencia = numSecuencia;
    }

    public String getNumEmpresa() {
        return numEmpresa;
    }

    public void setNumEmpresa(String numEmpresa) {
        this.numEmpresa = numEmpresa;
    }

    public String getNumPeriodo() {
        return numPeriodo;
    }

    public void setNumPeriodo(String numPeriodo) {
        this.numPeriodo = numPeriodo;
    }

    public Integer getNumSecuencia() {
        return numSecuencia;
    }

    public void setNumSecuencia(Integer numSecuencia) {
        this.numSecuencia = numSecuencia;
    }

    public String getNumTipo() {
        return numTipo;
    }

    public void setNumTipo(String numTipo) {
        this.numTipo = numTipo;
    }
}
