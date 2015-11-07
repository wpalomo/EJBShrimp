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
public class PrdListaPiscinaComboTO implements Serializable{
    private String pisNumero;
    private String pisNombre;
    private String pisSector;

    public PrdListaPiscinaComboTO() {
    }

    public PrdListaPiscinaComboTO(String pisNumero, String pisNombre, String pisSecotr) {
        this.pisNumero = pisNumero;
        this.pisNombre = pisNombre;
        this.pisSector = pisSecotr;
    }

    public String getPisNombre() {
        return pisNombre;
    }

    public void setPisNombre(String pisNombre) {
        this.pisNombre = pisNombre;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
    }

    @Override
    public String toString(){
        return this.pisSector+ " - " + this.pisNumero + " - " + this.pisNombre;
    }

    public String getPisSector() {
        return pisSector;
    }

    public void setPisSector(String pisSector) {
        this.pisSector = pisSector;
    }
    
    
}
