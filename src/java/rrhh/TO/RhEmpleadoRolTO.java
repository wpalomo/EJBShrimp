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
public class RhEmpleadoRolTO implements Serializable{
    private Integer empDiasTrabajados;
    private Integer empDiasDescanso;
    private BigDecimal empSueldoIess;
    private Boolean empRetencion;
    private BigDecimal empUtilidades;
    private BigDecimal empSueldoOtraCompania;
    private BigDecimal empEducacion;
    private BigDecimal empAlimentacion;
    private BigDecimal empSalud;
    private BigDecimal empVivienda;
    private BigDecimal empVestuario;
    private String catNombre;

    public RhEmpleadoRolTO() {
    }

    public RhEmpleadoRolTO(Integer empDiasTrabajados, Integer empDiasDescanso, BigDecimal empSueldoIess, Boolean empRetencion, BigDecimal empUtilidades, BigDecimal empSueldoOtraCompania, BigDecimal empEducacion, BigDecimal empAlimentacion, BigDecimal empSalud, BigDecimal empVivienda, BigDecimal empVestuario, String catNombre) {
        this.empDiasTrabajados = empDiasTrabajados;
        this.empDiasDescanso = empDiasDescanso;
        this.empSueldoIess = empSueldoIess;
        this.empRetencion = empRetencion;
        this.empUtilidades = empUtilidades;
        this.empSueldoOtraCompania = empSueldoOtraCompania;
        this.empEducacion = empEducacion;
        this.empAlimentacion = empAlimentacion;
        this.empSalud = empSalud;
        this.empVivienda = empVivienda;
        this.empVestuario = empVestuario;
        this.catNombre = catNombre;
    }

    public BigDecimal getEmpAlimentacion() {
        return empAlimentacion;
    }

    public void setEmpAlimentacion(BigDecimal empAlimentacion) {
        this.empAlimentacion = empAlimentacion;
    }

    public Integer getEmpDiasDescanso() {
        return empDiasDescanso;
    }

    public void setEmpDiasDescanso(Integer empDiasDescanso) {
        this.empDiasDescanso = empDiasDescanso;
    }

    public Integer getEmpDiasTrabajados() {
        return empDiasTrabajados;
    }

    public void setEmpDiasTrabajados(Integer empDiasTrabajados) {
        this.empDiasTrabajados = empDiasTrabajados;
    }

    public BigDecimal getEmpEducacion() {
        return empEducacion;
    }

    public void setEmpEducacion(BigDecimal empEducacion) {
        this.empEducacion = empEducacion;
    }

    public Boolean getEmpRetencion() {
        return empRetencion;
    }

    public void setEmpRetencion(Boolean empRetencion) {
        this.empRetencion = empRetencion;
    }

    public BigDecimal getEmpSalud() {
        return empSalud;
    }

    public void setEmpSalud(BigDecimal empSalud) {
        this.empSalud = empSalud;
    }

    public BigDecimal getEmpSueldoOtraCompania() {
        return empSueldoOtraCompania;
    }

    public void setEmpSueldoOtraCompania(BigDecimal empSueldoOtraCompania) {
        this.empSueldoOtraCompania = empSueldoOtraCompania;
    }

    public BigDecimal getEmpSueldoIess() {
        return empSueldoIess;
    }

    public void setEmpSueldoIess(BigDecimal empSueldoReal) {
        this.empSueldoIess = empSueldoReal;
    }

    public BigDecimal getEmpUtilidades() {
        return empUtilidades;
    }

    public void setEmpUtilidades(BigDecimal empUtilidades) {
        this.empUtilidades = empUtilidades;
    }

    public BigDecimal getEmpVestuario() {
        return empVestuario;
    }

    public void setEmpVestuario(BigDecimal empVestuario) {
        this.empVestuario = empVestuario;
    }

    public BigDecimal getEmpVivienda() {
        return empVivienda;
    }

    public void setEmpVivienda(BigDecimal empVivienda) {
        this.empVivienda = empVivienda;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getInformacion(){
        return  "\nDias Trabajados: "+empDiasTrabajados+
                "\nDias Descanso: "+empDiasDescanso+
                "\nSueldo Real: "+empSueldoIess+
                "\nRetencion: "+empRetencion+
                "\nUtilidades: "+empUtilidades+
                "\nSueldo Otra Compañia: "+empSueldoOtraCompania+
                "\nEducacion: "+empEducacion+
                "\nAlimentacion: "+empAlimentacion+
                "\nSalud: "+empSalud+
                "\nVivienda: "+empVivienda+
                "\nVestuario: "+empVestuario;
    }
}
