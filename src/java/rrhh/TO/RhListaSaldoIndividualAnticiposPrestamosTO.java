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
public class RhListaSaldoIndividualAnticiposPrestamosTO  implements Serializable{
    private String siapTipo;
    private String siapFecha;
    private String siapObservaciones;
    private BigDecimal siapDebitos;
    private BigDecimal siapCreditos;
    private BigDecimal siapSaldo;
    private String siapContable;
    private BigDecimal siapSecuencial;

    public RhListaSaldoIndividualAnticiposPrestamosTO() {
    }

    public RhListaSaldoIndividualAnticiposPrestamosTO(String siapTipo, String siapFecha, String siapObservaciones, BigDecimal siapDebitos, BigDecimal siapCreditos, BigDecimal siapSaldo, String siapContable, BigDecimal siapSecuencial) {
        this.siapTipo = siapTipo;
        this.siapFecha = siapFecha;
        this.siapObservaciones = siapObservaciones;
        this.siapDebitos = siapDebitos;
        this.siapCreditos = siapCreditos;
        this.siapSaldo = siapSaldo;
        this.siapContable = siapContable;
        this.siapSecuencial = siapSecuencial;
    }

    public String getSiapContable() {
        return siapContable;
    }

    public void setSiapContable(String siapContable) {
        this.siapContable = siapContable;
    }

    public BigDecimal getSiapCreditos() {
        return siapCreditos;
    }

    public void setSiapCreditos(BigDecimal siapCreditos) {
        this.siapCreditos = siapCreditos;
    }

    public BigDecimal getSiapDebitos() {
        return siapDebitos;
    }

    public void setSiapDebitos(BigDecimal siapDebitos) {
        this.siapDebitos = siapDebitos;
    }

    public String getSiapFecha() {
        return siapFecha;
    }

    public void setSiapFecha(String siapFecha) {
        this.siapFecha = siapFecha;
    }

    public String getSiapObservaciones() {
        return siapObservaciones;
    }

    public void setSiapObservaciones(String siapObservaciones) {
        this.siapObservaciones = siapObservaciones;
    }

    public BigDecimal getSiapSaldo() {
        return siapSaldo;
    }

    public void setSiapSaldo(BigDecimal siapSaldo) {
        this.siapSaldo = siapSaldo;
    }

    public BigDecimal getSiapSecuencial() {
        return siapSecuencial;
    }

    public void setSiapSecuencial(BigDecimal siapSecuencial) {
        this.siapSecuencial = siapSecuencial;
    }

    public String getSiapTipo() {
        return siapTipo;
    }

    public void setSiapTipo(String siapTipo) {
        this.siapTipo = siapTipo;
    }
}
