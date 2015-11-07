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
public class RhListaDetalleViaticosTO implements Serializable{
    private String dvCategoria;
    private String dvFecha;
    private String dvId;
    private String dvNombres;
    private BigDecimal dvValor;
    private Boolean dvReverso;
    private String dvContable;
    private Boolean dvAnulado;
    private String dvObservaciones;

    public RhListaDetalleViaticosTO() {
    }

    public RhListaDetalleViaticosTO(String dvCategoria, String dvFecha, String dvId, String dvNombres, BigDecimal dvValor, Boolean dvReverso, String dvContable, Boolean dvAnulado, String dvObservaciones) {
        this.dvCategoria = dvCategoria;
        this.dvFecha = dvFecha;
        this.dvId = dvId;
        this.dvNombres = dvNombres;
        this.dvValor = dvValor;
        this.dvReverso = dvReverso;
        this.dvContable = dvContable;
        this.dvAnulado = dvAnulado;
        this.dvObservaciones = dvObservaciones;
    }

    public Boolean getDvAnulado() {
        return dvAnulado;
    }

    public void setDvAnulado(Boolean dvAnulado) {
        this.dvAnulado = dvAnulado;
    }

    public String getDvCategoria() {
        return dvCategoria;
    }

    public void setDvCategoria(String dvCategoria) {
        this.dvCategoria = dvCategoria;
    }

    public String getDvContable() {
        return dvContable;
    }

    public void setDvContable(String dvContable) {
        this.dvContable = dvContable;
    }

    public String getDvFecha() {
        return dvFecha;
    }

    public void setDvFecha(String dvFecha) {
        this.dvFecha = dvFecha;
    }

    public String getDvId() {
        return dvId;
    }

    public void setDvId(String dvId) {
        this.dvId = dvId;
    }

    public String getDvNombres() {
        return dvNombres;
    }

    public void setDvNombres(String dvNombres) {
        this.dvNombres = dvNombres;
    }

    public String getDvObservaciones() {
        return dvObservaciones;
    }

    public void setDvObservaciones(String dvObservaciones) {
        this.dvObservaciones = dvObservaciones;
    }

    public Boolean getDvReverso() {
        return dvReverso;
    }

    public void setDvReverso(Boolean dvReverso) {
        this.dvReverso = dvReverso;
    }

    public BigDecimal getDvValor() {
        return dvValor;
    }

    public void setDvValor(BigDecimal dvValor) {
        this.dvValor = dvValor;
    }
}
