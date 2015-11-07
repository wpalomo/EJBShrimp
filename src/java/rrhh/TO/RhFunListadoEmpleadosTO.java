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
public class RhFunListadoEmpleadosTO implements Serializable{
    private Character empTipoId;
    private String empId;
    private String empNacionalidad;
    private String empApellidos;
    private String empNombres;
    private Character empGenero;
    private String empFechaNacimiento;
    private String empEstadoCivil;
    private Integer empCargasFamiliares;
    private String empProvincia;
    private String empCanton;
    private String empLugarNacimiento;
    private String empDomicilio;
    private String empNumero;
    private String empTelefono;
    private String secCodigo;
    private String catNombre;
    private String empFechaPrimerIngreso;
    private String empFechaPrimeraSalida;
    private String empFechaUltimoIngreso;
    private String empFechaUltimaSalida;
    private String empFechaAfiliacionIess;
    private String empCodigoAfiliacionIess;
    private String empCodigoCargo;
    private String empCargo;
    private java.math.BigDecimal empSueldoIess;
    private String empFormaPago;
    private Integer empDiasTrabajados;
    private Integer empDiasDescanso;
    private java.math.BigDecimal empSueldoReal;
    private Boolean empAcumulaFondoReserva;
    private Boolean empRetencion;
    private java.math.BigDecimal empEducacion;
    private java.math.BigDecimal empAlimentacion;
    private java.math.BigDecimal empSalud;
    private java.math.BigDecimal empVivienda;
    private java.math.BigDecimal empVestuario;
    private java.math.BigDecimal empSueldoOtraCompania;
    private java.math.BigDecimal empUtilidades;
    private String empBanco;
    private String empCuentaNumero;
    private String empObservaciones;
    private Boolean empInactivo;

    public RhFunListadoEmpleadosTO() {
    }

    public RhFunListadoEmpleadosTO(Character empTipoId, String empId, String empNacionalidad, String empApellidos, String empNombres, Character empGenero, String empFechaNacimiento, String empEstadoCivil, Integer empCargasFamiliares, String empProvincia, String empCanton, String empLugarNacimiento, String empDomicilio, String empNumero, String empTelefono, String secCodigo, String catNombre, String empFechaPrimerIngreso, String empFechaPrimeraSalida, String empFechaUltimoIngreso, String empFechaUltimaSalida, String empFechaAfiliacionIess, String empCodigoAfiliacionIess, String empCodigoCargo, String empCargo, BigDecimal empSueldoIess, String empFormaPago, Integer empDiasTrabajados, Integer empDiasDescanso, BigDecimal empSueldoReal, Boolean empAcumulaFondoReserva, Boolean empRetencion, BigDecimal empEducacion, BigDecimal empAlimentacion, BigDecimal empSalud, BigDecimal empVivienda, BigDecimal empVestuario, BigDecimal empSueldoOtraCompania, BigDecimal empUtilidades, String empBanco, String empCuentaNumero, String empObservaciones, Boolean empInactivo) {
        this.empTipoId = empTipoId;
        this.empId = empId;
        this.empNacionalidad = empNacionalidad;
        this.empApellidos = empApellidos;
        this.empNombres = empNombres;
        this.empGenero = empGenero;
        this.empFechaNacimiento = empFechaNacimiento;
        this.empEstadoCivil = empEstadoCivil;
        this.empCargasFamiliares = empCargasFamiliares;
        this.empProvincia = empProvincia;
        this.empCanton = empCanton;
        this.empLugarNacimiento = empLugarNacimiento;
        this.empDomicilio = empDomicilio;
        this.empNumero = empNumero;
        this.empTelefono = empTelefono;
        this.secCodigo = secCodigo;
        this.catNombre = catNombre;
        this.empFechaPrimerIngreso = empFechaPrimerIngreso;
        this.empFechaPrimeraSalida = empFechaPrimeraSalida;
        this.empFechaUltimoIngreso = empFechaUltimoIngreso;
        this.empFechaUltimaSalida = empFechaUltimaSalida;
        this.empFechaAfiliacionIess = empFechaAfiliacionIess;
        this.empCodigoAfiliacionIess = empCodigoAfiliacionIess;
        this.empCodigoCargo = empCodigoCargo;
        this.empCargo = empCargo;
        this.empSueldoIess = empSueldoIess;
        this.empFormaPago = empFormaPago;
        this.empDiasTrabajados = empDiasTrabajados;
        this.empDiasDescanso = empDiasDescanso;
        this.empSueldoReal = empSueldoReal;
        this.empAcumulaFondoReserva = empAcumulaFondoReserva;
        this.empRetencion = empRetencion;
        this.empEducacion = empEducacion;
        this.empAlimentacion = empAlimentacion;
        this.empSalud = empSalud;
        this.empVivienda = empVivienda;
        this.empVestuario = empVestuario;
        this.empSueldoOtraCompania = empSueldoOtraCompania;
        this.empUtilidades = empUtilidades;
        this.empBanco = empBanco;
        this.empCuentaNumero = empCuentaNumero;
        this.empObservaciones = empObservaciones;
        this.empInactivo = empInactivo;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public Boolean getEmpAcumulaFondoReserva() {
        return empAcumulaFondoReserva;
    }

    public void setEmpAcumulaFondoReserva(Boolean empAcumulaFondoReserva) {
        this.empAcumulaFondoReserva = empAcumulaFondoReserva;
    }

    public BigDecimal getEmpAlimentacion() {
        return empAlimentacion;
    }

    public void setEmpAlimentacion(BigDecimal empAlimentacion) {
        this.empAlimentacion = empAlimentacion;
    }

    public String getEmpApellidos() {
        return empApellidos;
    }

    public void setEmpApellidos(String empApellidos) {
        this.empApellidos = empApellidos;
    }

    public String getEmpBanco() {
        return empBanco;
    }

    public void setEmpBanco(String empBanco) {
        this.empBanco = empBanco;
    }

    public String getEmpCanton() {
        return empCanton;
    }

    public void setEmpCanton(String empCanton) {
        this.empCanton = empCanton;
    }

    public Integer getEmpCargasFamiliares() {
        return empCargasFamiliares;
    }

    public void setEmpCargasFamiliares(Integer empCargasFamiliares) {
        this.empCargasFamiliares = empCargasFamiliares;
    }

    public String getEmpCargo() {
        return empCargo;
    }

    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }

    public String getEmpCodigoAfiliacionIess() {
        return empCodigoAfiliacionIess;
    }

    public void setEmpCodigoAfiliacionIess(String empCodigoAfiliacionIess) {
        this.empCodigoAfiliacionIess = empCodigoAfiliacionIess;
    }

    public String getEmpCodigoCargo() {
        return empCodigoCargo;
    }

    public void setEmpCodigoCargo(String empCodigoCargo) {
        this.empCodigoCargo = empCodigoCargo;
    }

    public String getEmpCuentaNumero() {
        return empCuentaNumero;
    }

    public void setEmpCuentaNumero(String empCuentaNumero) {
        this.empCuentaNumero = empCuentaNumero;
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

    public String getEmpDomicilio() {
        return empDomicilio;
    }

    public void setEmpDomicilio(String empDomicilio) {
        this.empDomicilio = empDomicilio;
    }

    public BigDecimal getEmpEducacion() {
        return empEducacion;
    }

    public void setEmpEducacion(BigDecimal empEducacion) {
        this.empEducacion = empEducacion;
    }

    public String getEmpEstadoCivil() {
        return empEstadoCivil;
    }

    public void setEmpEstadoCivil(String empEstadoCivil) {
        this.empEstadoCivil = empEstadoCivil;
    }

    public String getEmpFechaAfiliacionIess() {
        return empFechaAfiliacionIess;
    }

    public void setEmpFechaAfiliacionIess(String empFechaAfiliacionIess) {
        this.empFechaAfiliacionIess = empFechaAfiliacionIess;
    }

    public String getEmpFechaNacimiento() {
        return empFechaNacimiento;
    }

    public void setEmpFechaNacimiento(String empFechaNacimiento) {
        this.empFechaNacimiento = empFechaNacimiento;
    }

    public String getEmpFechaPrimerIngreso() {
        return empFechaPrimerIngreso;
    }

    public void setEmpFechaPrimerIngreso(String empFechaPrimerIngreso) {
        this.empFechaPrimerIngreso = empFechaPrimerIngreso;
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

    public String getEmpFechaUltimoIngreso() {
        return empFechaUltimoIngreso;
    }

    public void setEmpFechaUltimoIngreso(String empFechaUltimoIngreso) {
        this.empFechaUltimoIngreso = empFechaUltimoIngreso;
    }

    public String getEmpFormaPago() {
        return empFormaPago;
    }

    public void setEmpFormaPago(String empFormaPago) {
        this.empFormaPago = empFormaPago;
    }

    public Character getEmpGenero() {
        return empGenero;
    }

    public void setEmpGenero(Character empGenero) {
        this.empGenero = empGenero;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Boolean getEmpInactivo() {
        return empInactivo;
    }

    public void setEmpInactivo(Boolean empInactivo) {
        this.empInactivo = empInactivo;
    }

    public String getEmpLugarNacimiento() {
        return empLugarNacimiento;
    }

    public void setEmpLugarNacimiento(String empLugarNacimiento) {
        this.empLugarNacimiento = empLugarNacimiento;
    }

    public String getEmpNacionalidad() {
        return empNacionalidad;
    }

    public void setEmpNacionalidad(String empNacionalidad) {
        this.empNacionalidad = empNacionalidad;
    }

    public String getEmpNombres() {
        return empNombres;
    }

    public void setEmpNombres(String empNombres) {
        this.empNombres = empNombres;
    }

    public String getEmpNumero() {
        return empNumero;
    }

    public void setEmpNumero(String empNumero) {
        this.empNumero = empNumero;
    }

    public String getEmpObservaciones() {
        return empObservaciones;
    }

    public void setEmpObservaciones(String empObservaciones) {
        this.empObservaciones = empObservaciones;
    }

    public String getEmpProvincia() {
        return empProvincia;
    }

    public void setEmpProvincia(String empProvincia) {
        this.empProvincia = empProvincia;
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

    public BigDecimal getEmpSueldoIess() {
        return empSueldoIess;
    }

    public void setEmpSueldoIess(BigDecimal empSueldoIess) {
        this.empSueldoIess = empSueldoIess;
    }

    public BigDecimal getEmpSueldoOtraCompania() {
        return empSueldoOtraCompania;
    }

    public void setEmpSueldoOtraCompania(BigDecimal empSueldoOtraCompania) {
        this.empSueldoOtraCompania = empSueldoOtraCompania;
    }

    public BigDecimal getEmpSueldoReal() {
        return empSueldoReal;
    }

    public void setEmpSueldoReal(BigDecimal empSueldoReal) {
        this.empSueldoReal = empSueldoReal;
    }

    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    public Character getEmpTipoId() {
        return empTipoId;
    }

    public void setEmpTipoId(Character empTipoId) {
        this.empTipoId = empTipoId;
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

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

}
