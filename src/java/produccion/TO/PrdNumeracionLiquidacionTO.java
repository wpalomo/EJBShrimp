/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.TO;

import java.io.Serializable;

/**
 *
 * @author javier tj
 */
public class PrdNumeracionLiquidacionTO implements Serializable{
    private String numEmpresa;
    private String numMotivo;
    private String numSecuencia;

    public PrdNumeracionLiquidacionTO() {
    }

    public PrdNumeracionLiquidacionTO(String numEmpresa, String numMotivo, String numSecuencia) {
        this.numEmpresa = numEmpresa;
        this.numMotivo = numMotivo;
        this.numSecuencia = numSecuencia;
    }

    public String getNumEmpresa() {
        return numEmpresa;
    }

    public void setNumEmpresa(String numEmpresa) {
        this.numEmpresa = numEmpresa;
    }

    public String getNumMotivo() {
        return numMotivo;
    }

    public void setNumMotivo(String numMotivo) {
        this.numMotivo = numMotivo;
    }

    public String getNumSecuencia() {
        return numSecuencia;
    }

    public void setNumSecuencia(String numSecuencia) {
        this.numSecuencia = numSecuencia;
    }
    
}
