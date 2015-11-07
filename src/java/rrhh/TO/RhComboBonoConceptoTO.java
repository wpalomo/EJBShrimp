/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class RhComboBonoConceptoTO implements Serializable{
    private String bcDetalle;
    private BigDecimal bcValor;
    private Boolean bcValorFijo;

    public RhComboBonoConceptoTO() {
    }

    public RhComboBonoConceptoTO(String bcDetalle, BigDecimal bcValor, Boolean bcValorFijo) {
        this.bcDetalle = bcDetalle;
        this.bcValor = bcValor;
        this.bcValorFijo = bcValorFijo;
    }

    public String getBcDetalle() {
        return bcDetalle;
    }

    public void setBcDetalle(String bcDetalle) {
        this.bcDetalle = bcDetalle;
    }

    public BigDecimal getBcValor() {
        return bcValor;
    }

    public void setBcValor(BigDecimal bcValor) {
        this.bcValor = bcValor;
    }

    public Boolean getBcValorFijo() {
        return bcValorFijo;
    }

    public void setBcValorFijo(Boolean bcValorFijo) {
        this.bcValorFijo = bcValorFijo;
    }

    @Override
    public String toString(){
        return this.bcDetalle;
    }

}
