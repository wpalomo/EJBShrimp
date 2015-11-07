/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.reporte;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ReporteEmpleado implements Serializable{  

    ////Detalle
    private String secCodigo;
    private String catNombre;
    private String empNacionalidad;
    private String empTipoId;
    private String empId;
    private String empNombres;
    private String empApellidos;
    private String empGenero;
    private String empFechaNacimiento;
    private String empProvincia;
    private String empCanton;
    private String empCiudad;
    private String empDomicilio;
    private String empNumero;
    private String empTelefono;
    private String empEstadoCivil;
    private String empCargasFamiliares;
    private String empObservaciones;
    private String empFechaPrimerIngreso;
    private String empFechaUltimoIngreso;
    private String empFechaPrimeraSalida;
    private String empFechaUltimaSalida;
    private String empFechaAfiliacionIess;
    private String empCodigoAfiliacionIess;
    private String empCodigoCargoIess;
    private String empCargo;
    private String empFormaPago;
    private String empDiasTrabajados;
    private String empDiasDescanso;
    private String empBonoFijo;
    private String empBonoFijoND;
    private String empOtrosIngresos;
    private String empOtrosIngresosNd;
    private BigDecimal empSueldoIess;
    
    private BigDecimal empEducacion;
    private BigDecimal empAlimentacion;
    private BigDecimal empSalud;
    private BigDecimal empVivienda;
    private BigDecimal empVestuario;
    private BigDecimal empUtilidades;
    
    private BigDecimal empRebajaDiscapacidad;
    private BigDecimal empRebajaTerceraEdad;
    private BigDecimal empSueldoOtraCompania;
    private BigDecimal empOtrasDeducciones;
    private BigDecimal empOtrasRebajas;
    
    private String empBanco;
    private String empCuentaTipo; 
    private String empCuentaNumero;


    public ReporteEmpleado() {
    }

    public ReporteEmpleado(String secCodigo, String catNombre, String empNacionalidad, String empTipoId, String empId, String empNombres, String empApellidos, String empGenero, String empFechaNacimiento, String empProvincia, String empCanton, String empCiudad, String empDomicilio, String empNumero, String empTelefono, String empEstadoCivil, String empCargasFamiliares, String empObservaciones, String empFechaPrimerIngreso, String empFechaUltimoIngreso, String empFechaPrimeraSalida, String empFechaUltimaSalida, String empFechaAfiliacionIess, String empCodigoAfiliacionIess, String empCodigoCargoIess, String empCargo, String empFormaPago, String empDiasTrabajados, String empDiasDescanso, String empBonoFijo, String empBonoFijoND, String empOtrosIngresos, String empOtrosIngresosNd, BigDecimal empSueldoIess, BigDecimal empEducacion, BigDecimal empAlimentacion, BigDecimal empSalud, BigDecimal empVivienda, BigDecimal empVestuario, BigDecimal empUtilidades, BigDecimal empRebajaDiscapacidad, BigDecimal empRebajaTerceraEdad, BigDecimal empSueldoOtraCompania, BigDecimal empOtrasDeducciones, BigDecimal empOtrasRebajas, String empBanco, String empCuentaTipo, String empCuentaNumero) {
        this.secCodigo = secCodigo;
        this.catNombre = catNombre;
        this.empNacionalidad = empNacionalidad;
        this.empTipoId = empTipoId;
        this.empId = empId;
        this.empNombres = empNombres;
        this.empApellidos = empApellidos;
        this.empGenero = empGenero;
        this.empFechaNacimiento = empFechaNacimiento;
        this.empProvincia = empProvincia;
        this.empCanton = empCanton;
        this.empCiudad = empCiudad;
        this.empDomicilio = empDomicilio;
        this.empNumero = empNumero;
        this.empTelefono = empTelefono;
        this.empEstadoCivil = empEstadoCivil;
        this.empCargasFamiliares = empCargasFamiliares;
        this.empObservaciones = empObservaciones;
        this.empFechaPrimerIngreso = empFechaPrimerIngreso;
        this.empFechaUltimoIngreso = empFechaUltimoIngreso;
        this.empFechaPrimeraSalida = empFechaPrimeraSalida;
        this.empFechaUltimaSalida = empFechaUltimaSalida;
        this.empFechaAfiliacionIess = empFechaAfiliacionIess;
        this.empCodigoAfiliacionIess = empCodigoAfiliacionIess;
        this.empCodigoCargoIess = empCodigoCargoIess;
        this.empCargo = empCargo;
        this.empFormaPago = empFormaPago;
        this.empDiasTrabajados = empDiasTrabajados;
        this.empDiasDescanso = empDiasDescanso;
        this.empBonoFijo = empBonoFijo;
        this.empBonoFijoND = empBonoFijoND;
        this.empOtrosIngresos = empOtrosIngresos;
        this.empOtrosIngresosNd = empOtrosIngresosNd;
        this.empSueldoIess = empSueldoIess;
        this.empEducacion = empEducacion;
        this.empAlimentacion = empAlimentacion;
        this.empSalud = empSalud;
        this.empVivienda = empVivienda;
        this.empVestuario = empVestuario;
        this.empUtilidades = empUtilidades;
        this.empRebajaDiscapacidad = empRebajaDiscapacidad;
        this.empRebajaTerceraEdad = empRebajaTerceraEdad;
        this.empSueldoOtraCompania = empSueldoOtraCompania;
        this.empOtrasDeducciones = empOtrasDeducciones;
        this.empOtrasRebajas = empOtrasRebajas;
        this.empBanco = empBanco;
        this.empCuentaTipo = empCuentaTipo;
        this.empCuentaNumero = empCuentaNumero;
    }

   

    public ReporteEmpleado(String empBanco, String empCuentaTipo, String empCuentaNumero) {
        this.empBanco = empBanco;
        this.empCuentaTipo = empCuentaTipo;
        this.empCuentaNumero = empCuentaNumero;
    }

    public BigDecimal getEmpEducacion() {
        return empEducacion;
    }

    public void setEmpEducacion(BigDecimal empEducacion) {
        this.empEducacion = empEducacion;
    }

    public BigDecimal getEmpAlimentacion() {
        return empAlimentacion;
    }

    public void setEmpAlimentacion(BigDecimal empAlimentacion) {
        this.empAlimentacion = empAlimentacion;
    }

    public BigDecimal getEmpSalud() {
        return empSalud;
    }

    public void setEmpSalud(BigDecimal empSalud) {
        this.empSalud = empSalud;
    }

    public BigDecimal getEmpVivienda() {
        return empVivienda;
    }

    public void setEmpVivienda(BigDecimal empVivienda) {
        this.empVivienda = empVivienda;
    }

    public BigDecimal getEmpVestuario() {
        return empVestuario;
    }

    public void setEmpVestuario(BigDecimal empVestuario) {
        this.empVestuario = empVestuario;
    }

    public BigDecimal getEmpUtilidades() {
        return empUtilidades;
    }

    public void setEmpUtilidades(BigDecimal empUtilidades) {
        this.empUtilidades = empUtilidades;
    }

    public BigDecimal getEmpRebajaDiscapacidad() {
        return empRebajaDiscapacidad;
    }

    public void setEmpRebajaDiscapacidad(BigDecimal empRebajaDiscapacidad) {
        this.empRebajaDiscapacidad = empRebajaDiscapacidad;
    }

    public BigDecimal getEmpRebajaTerceraEdad() {
        return empRebajaTerceraEdad;
    }

    public void setEmpRebajaTerceraEdad(BigDecimal empRebajaTerceraEdad) {
        this.empRebajaTerceraEdad = empRebajaTerceraEdad;
    }

    public BigDecimal getEmpSueldoOtraCompania() {
        return empSueldoOtraCompania;
    }

    public void setEmpSueldoOtraCompania(BigDecimal empSueldoOtraCompania) {
        this.empSueldoOtraCompania = empSueldoOtraCompania;
    }

    public BigDecimal getEmpOtrasDeducciones() {
        return empOtrasDeducciones;
    }

    public void setEmpOtrasDeducciones(BigDecimal empOtrasDeducciones) {
        this.empOtrasDeducciones = empOtrasDeducciones;
    }

    public BigDecimal getEmpOtrasRebajas() {
        return empOtrasRebajas;
    }

    public void setEmpOtrasRebajas(BigDecimal empOtrasRebajas) {
        this.empOtrasRebajas = empOtrasRebajas;
    }
   

    public BigDecimal getEmpSueldoIess() {
        return empSueldoIess;
    }

    public void setEmpSueldoIess(BigDecimal empSueldoIess) {
        this.empSueldoIess = empSueldoIess;
    }
    

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getEmpNacionalidad() {
        return empNacionalidad;
    }

    public void setEmpNacionalidad(String empNacionalidad) {
        this.empNacionalidad = empNacionalidad;
    }

    public String getEmpTipoId() {
        return empTipoId;
    }

    public void setEmpTipoId(String empTipoId) {
        this.empTipoId = empTipoId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpNombres() {
        return empNombres;
    }

    public void setEmpNombres(String empNombres) {
        this.empNombres = empNombres;
    }

    public String getEmpApellidos() {
        return empApellidos;
    }

    public void setEmpApellidos(String empApellidos) {
        this.empApellidos = empApellidos;
    }

    public String getEmpGenero() {
        return empGenero;
    }

    public void setEmpGenero(String empGenero) {
        this.empGenero = empGenero;
    }

    public String getEmpFechaNacimiento() {
        return empFechaNacimiento;
    }

    public void setEmpFechaNacimiento(String empFechaNacimiento) {
        this.empFechaNacimiento = empFechaNacimiento;
    }

    public String getEmpProvincia() {
        return empProvincia;
    }

    public void setEmpProvincia(String empProvincia) {
        this.empProvincia = empProvincia;
    }

    public String getEmpCanton() {
        return empCanton;
    }

    public void setEmpCanton(String empCanton) {
        this.empCanton = empCanton;
    }

    public String getEmpCiudad() {
        return empCiudad;
    }

    public void setEmpCiudad(String empCiudad) {
        this.empCiudad = empCiudad;
    }

    public String getEmpDomicilio() {
        return empDomicilio;
    }

    public void setEmpDomicilio(String empDomicilio) {
        this.empDomicilio = empDomicilio;
    }

    public String getEmpNumero() {
        return empNumero;
    }

    public void setEmpNumero(String empNumero) {
        this.empNumero = empNumero;
    }

    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    public String getEmpEstadoCivil() {
        return empEstadoCivil;
    }

    public void setEmpEstadoCivil(String empEstadoCivil) {
        this.empEstadoCivil = empEstadoCivil;
    }

    public String getEmpCargasFamiliares() {
        return empCargasFamiliares;
    }

    public void setEmpCargasFamiliares(String empCargasFamiliares) {
        this.empCargasFamiliares = empCargasFamiliares;
    }

    public String getEmpObservaciones() {
        return empObservaciones;
    }

    public void setEmpObservaciones(String empObservaciones) {
        this.empObservaciones = empObservaciones;
    }

    public String getEmpFechaPrimerIngreso() {
        return empFechaPrimerIngreso;
    }

    public void setEmpFechaPrimerIngreso(String empFechaPrimerIngreso) {
        this.empFechaPrimerIngreso = empFechaPrimerIngreso;
    }

    public String getEmpFechaUltimoIngreso() {
        return empFechaUltimoIngreso;
    }

    public void setEmpFechaUltimoIngreso(String empFechaUltimoIngreso) {
        this.empFechaUltimoIngreso = empFechaUltimoIngreso;
    }

    public String getEmpFechaPrimeraSalida() {
        return empFechaPrimeraSalida;
    }

    public void setEmpFechaPrimeraSalida(String empFechaPrimeraSalida) {
        this.empFechaPrimeraSalida = empFechaPrimeraSalida;
    }

    public String getEmpFechaUltimaSalida() {
        return empFechaUltimaSalida;
    }

    public void setEmpFechaUltimaSalida(String empFechaUltimaSalida) {
        this.empFechaUltimaSalida = empFechaUltimaSalida;
    }

    public String getEmpFechaAfiliacionIess() {
        return empFechaAfiliacionIess;
    }

    public void setEmpFechaAfiliacionIess(String empFechaAfiliacionIess) {
        this.empFechaAfiliacionIess = empFechaAfiliacionIess;
    }

    public String getEmpCodigoAfiliacionIess() {
        return empCodigoAfiliacionIess;
    }

    public void setEmpCodigoAfiliacionIess(String empCodigoAfiliacionIess) {
        this.empCodigoAfiliacionIess = empCodigoAfiliacionIess;
    }

    public String getEmpCodigoCargoIess() {
        return empCodigoCargoIess;
    }

    public void setEmpCodigoCargoIess(String empCodigoCargoIess) {
        this.empCodigoCargoIess = empCodigoCargoIess;
    }

    public String getEmpCargo() {
        return empCargo;
    }

    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }

    public String getEmpFormaPago() {
        return empFormaPago;
    }

    public void setEmpFormaPago(String empFormaPago) {
        this.empFormaPago = empFormaPago;
    }

    public String getEmpDiasTrabajados() {
        return empDiasTrabajados;
    }

    public void setEmpDiasTrabajados(String empDiasTrabajados) {
        this.empDiasTrabajados = empDiasTrabajados;
    }

    public String getEmpDiasDescanso() {
        return empDiasDescanso;
    }

    public void setEmpDiasDescanso(String empDiasDescanso) {
        this.empDiasDescanso = empDiasDescanso;
    }

    public String getEmpBonoFijo() {
        return empBonoFijo;
    }

    public void setEmpBonoFijo(String empBonoFijo) {
        this.empBonoFijo = empBonoFijo;
    }

    public String getEmpBonoFijoND() {
        return empBonoFijoND;
    }

    public void setEmpBonoFijoND(String empBonoFijoND) {
        this.empBonoFijoND = empBonoFijoND;
    }

    public String getEmpOtrosIngresos() {
        return empOtrosIngresos;
    }

    public void setEmpOtrosIngresos(String empOtrosIngresos) {
        this.empOtrosIngresos = empOtrosIngresos;
    }

    public String getEmpOtrosIngresosNd() {
        return empOtrosIngresosNd;
    }

    public void setEmpOtrosIngresosNd(String empOtrosIngresosNd) {
        this.empOtrosIngresosNd = empOtrosIngresosNd;
    }

    public String getEmpBanco() {
        return empBanco;
    }

    public void setEmpBanco(String empBanco) {
        this.empBanco = empBanco;
    }

    public String getEmpCuentaTipo() {
        return empCuentaTipo;
    }

    public void setEmpCuentaTipo(String empCuentaTipo) {
        this.empCuentaTipo = empCuentaTipo;
    }

    public String getEmpCuentaNumero() {
        return empCuentaNumero;
    }

    public void setEmpCuentaNumero(String empCuentaNumero) {
        this.empCuentaNumero = empCuentaNumero;
    }

   

   
}
