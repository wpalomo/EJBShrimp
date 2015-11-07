/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class RhCtaIessTO implements Serializable{
    private String ctaAportepersonal;
    private String empFechaAfiliacionIess;
    private String empFechaPrimerIngreso;
    private String empFechaPrimerSalida;
    private String empFechaUltimoIngreso;
    private String empFechaUltimoSalida;
    private Boolean empExtensionCoberturaIess;

    public RhCtaIessTO() {
    }

    public RhCtaIessTO(String ctaAportepersonal, String empFechaAfiliacionIess, String empFechaPrimerIngreso, String empFechaPrimerSalida, String empFechaUltimoIngreso, String empFechaUltimoSalida, Boolean empExtensionCoberturaIess) {
        this.ctaAportepersonal = ctaAportepersonal;
        this.empFechaAfiliacionIess = empFechaAfiliacionIess;
        this.empFechaPrimerIngreso = empFechaPrimerIngreso;
        this.empFechaPrimerSalida = empFechaPrimerSalida;
        this.empFechaUltimoIngreso = empFechaUltimoIngreso;
        this.empFechaUltimoSalida = empFechaUltimoSalida;
        this.empExtensionCoberturaIess = empExtensionCoberturaIess;
    }

    public String getCtaAportepersonal() {
        return ctaAportepersonal;
    }

    public void setCtaAportepersonal(String ctaAportepersonal) {
        this.ctaAportepersonal = ctaAportepersonal;
    }

    public Boolean getEmpExtensionCoberturaIess() {
        return empExtensionCoberturaIess;
    }

    public void setEmpExtensionCoberturaIess(Boolean empExtensionCoberturaIess) {
        this.empExtensionCoberturaIess = empExtensionCoberturaIess;
    }

    public String getEmpFechaAfiliacionIess() {
        return empFechaAfiliacionIess;
    }

    public void setEmpFechaAfiliacionIess(String empFechaAfiliacionIess) {
        this.empFechaAfiliacionIess = empFechaAfiliacionIess;
    }

    public String getEmpFechaPrimerIngreso() {
        return empFechaPrimerIngreso;
    }

    public void setEmpFechaPrimerIngreso(String empFechaPrimerIngreso) {
        this.empFechaPrimerIngreso = empFechaPrimerIngreso;
    }

    public String getEmpFechaPrimerSalida() {
        return empFechaPrimerSalida;
    }

    public void setEmpFechaPrimerSalida(String empFechaPrimerSalida) {
        this.empFechaPrimerSalida = empFechaPrimerSalida;
    }

    public String getEmpFechaUltimoIngreso() {
        return empFechaUltimoIngreso;
    }

    public void setEmpFechaUltimoIngreso(String empFechaUltimoIngreso) {
        this.empFechaUltimoIngreso = empFechaUltimoIngreso;
    }

    public String getEmpFechaUltimoSalida() {
        return empFechaUltimoSalida;
    }

    public void setEmpFechaUltimoSalida(String empFechaUltimoSalida) {
        this.empFechaUltimoSalida = empFechaUltimoSalida;
    }
}