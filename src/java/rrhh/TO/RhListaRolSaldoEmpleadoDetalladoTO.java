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
public class RhListaRolSaldoEmpleadoDetalladoTO implements Serializable{

    private String sedConcepto;
    private String sedDetalle;
    private String sedCp;
    private String sedCc;
    private String sedFecha;
    private BigDecimal sedValor;
    private String sedObservaciones;
    private String sedContable;

    public RhListaRolSaldoEmpleadoDetalladoTO() {
    }

    public RhListaRolSaldoEmpleadoDetalladoTO(String sedConcepto, String sedDetalle, String sedCp, String sedCc, String sedFecha, BigDecimal sedValor, String sedObservaciones, String sedContable) {
        this.sedConcepto = sedConcepto;
        this.sedDetalle = sedDetalle;
        this.sedCp = sedCp;
        this.sedCc = sedCc;
        this.sedFecha = sedFecha;
        this.sedValor = sedValor;
        this.sedObservaciones = sedObservaciones;
        this.sedContable = sedContable;
    }

    public String getSedCc() {
        return sedCc;
    }

    public void setSedCc(String sedCc) {
        this.sedCc = sedCc;
    }

    public String getSedConcepto() {
        return sedConcepto;
    }

    public void setSedConcepto(String sedConcepto) {
        this.sedConcepto = sedConcepto;
    }

    public String getSedContable() {
        return sedContable;
    }

    public void setSedContable(String sedContable) {
        this.sedContable = sedContable;
    }

    public String getSedCp() {
        return sedCp;
    }

    public void setSedCp(String sedCp) {
        this.sedCp = sedCp;
    }

    public String getSedDetalle() {
        return sedDetalle;
    }

    public void setSedDetalle(String sedDetalle) {
        this.sedDetalle = sedDetalle;
    }

    public String getSedFecha() {
        return sedFecha;
    }

    public void setSedFecha(String sedFecha) {
        this.sedFecha = sedFecha;
    }

    public String getSedObservaciones() {
        return sedObservaciones;
    }

    public void setSedObservaciones(String sedObservaciones) {
        this.sedObservaciones = sedObservaciones;
    }

    public BigDecimal getSedValor() {
        return sedValor;
    }

    public void setSedValor(BigDecimal sedValor) {
        this.sedValor = sedValor;
    }

    public String getInformacion(){
        return "Concepto: "+sedConcepto+
                "\nDetalle: "+sedDetalle+
                "\nCp: "+sedCp+
                "\nCc: "+sedCc+
                "\nFecha: "+sedFecha+
                "\nValor: "+sedValor+
                "\nObservaciones: "+sedObservaciones+
                "\nContable: "+sedContable;
    }
}
