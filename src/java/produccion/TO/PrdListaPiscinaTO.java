/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produccion.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class PrdListaPiscinaTO implements Serializable{

    private String pisNumero;
    private String pisNombre;
    private BigDecimal pisHectareaje;
    private Boolean pisActiva;

    public PrdListaPiscinaTO() {
    }

    public PrdListaPiscinaTO(String pisNumero, String pisNombre, BigDecimal pisHectareaje, Boolean pisActiva) {
        this.pisNumero = pisNumero;
        this.pisNombre = pisNombre;
        this.pisHectareaje = pisHectareaje;
        this.pisActiva = pisActiva;
    }

    public Boolean getPisActiva() {
        return pisActiva;
    }

    public void setPisActiva(Boolean pisActiva) {
        this.pisActiva = pisActiva;
    }

    public BigDecimal getPisHectareaje() {
        return pisHectareaje;
    }

    public void setPisHectareaje(BigDecimal pisHectareaje) {
        this.pisHectareaje = pisHectareaje;
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
        return this.pisNumero + " " + this.pisNombre;
    }

}
