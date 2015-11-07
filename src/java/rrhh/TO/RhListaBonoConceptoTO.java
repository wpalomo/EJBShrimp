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
public class RhListaBonoConceptoTO implements Serializable{
    private Integer bcSecuencia;
    private String bcDetalle;
    private BigDecimal bcValor;
    private Boolean bcValorFijo;
    private Boolean bcInactivo;

    public RhListaBonoConceptoTO() {
    }

    public RhListaBonoConceptoTO(Integer bcSecuencia, String bcDetalle, BigDecimal bcValor, Boolean bcValorFijo, Boolean bcInactivo) {
        this.bcSecuencia = bcSecuencia;
        this.bcDetalle = bcDetalle;
        this.bcValor = bcValor;
        this.bcValorFijo = bcValorFijo;
        this.bcInactivo = bcInactivo;
    }

    public String getBcDetalle() {
        return bcDetalle;
    }

    public void setBcDetalle(String bcDetalle) {
        this.bcDetalle = bcDetalle;
    }

    public Boolean getBcInactivo() {
        return bcInactivo;
    }

    public void setBcInactivo(Boolean bcInactivo) {
        this.bcInactivo = bcInactivo;
    }

    public Integer getBcSecuencia() {
        return bcSecuencia;
    }

    public void setBcSecuencia(Integer bcSecuencia) {
        this.bcSecuencia = bcSecuencia;
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

}
