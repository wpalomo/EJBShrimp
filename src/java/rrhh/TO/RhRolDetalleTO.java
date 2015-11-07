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
public class RhRolDetalleTO implements Serializable{
    private String empId;
    private String empApellidosNombres;
    private String rolCargo;
    private String rolFechaUltimoSueldo;
    private String empFormaPago;
    private Integer rolDiasFaltasReales;
    private Integer rolDiasExtrasReales;
    private Integer rolDiasPermisoMedico;
    private BigDecimal rolSueldo;
    private BigDecimal rolLiqFondoReserva;
    private BigDecimal rolLiqXiii;
    private BigDecimal rolLiqXiv;
    private BigDecimal rolLiqVacaciones;
    private BigDecimal rolLiqDesahucio;
    private BigDecimal rolPrestamos;
    //consulta
    private Boolean prRetencion;
    private Boolean prFondoReserva;
    private String prFechaAfiliacionIess;
    private String prPrimerIngreso;
    private String prPrimeraSalida;
    private String prUltimoIngreso;
    private String prUltimaSalida;
    
    public RhRolDetalleTO() {
    }

    public RhRolDetalleTO(String empId, String empApellidosNombres, String rolCargo, String rolFechaUltimoSueldo, String empFormaPago, Integer rolDiasFaltasReales, Integer rolDiasExtrasReales, Integer rolDiasPermisoMedico, BigDecimal rolSueldo, BigDecimal rolLiqFondoReserva, BigDecimal rolLiqXiii, BigDecimal rolLiqXiv, BigDecimal rolLiqVacaciones, BigDecimal rolLiqDesahucio, BigDecimal rolPrestamos) {
        this.empId = empId;
        this.empApellidosNombres = empApellidosNombres;
        this.rolCargo = rolCargo;
        this.rolFechaUltimoSueldo = rolFechaUltimoSueldo;
        this.empFormaPago = empFormaPago;
        this.rolDiasFaltasReales = rolDiasFaltasReales;
        this.rolDiasExtrasReales = rolDiasExtrasReales;
        this.rolDiasPermisoMedico = rolDiasPermisoMedico;
        this.rolSueldo = rolSueldo;
        this.rolLiqFondoReserva = rolLiqFondoReserva;
        this.rolLiqXiii = rolLiqXiii;
        this.rolLiqXiv = rolLiqXiv;
        this.rolLiqVacaciones = rolLiqVacaciones;
        this.rolLiqDesahucio = rolLiqDesahucio;
        this.rolPrestamos = rolPrestamos;
    }

    public String getEmpApellidosNombres() {
        return empApellidosNombres;
    }

    public void setEmpApellidosNombres(String empApellidosNombres) {
        this.empApellidosNombres = empApellidosNombres;
    }

    public String getEmpFormaPago() {
        return empFormaPago;
    }

    public void setEmpFormaPago(String empFormaPago) {
        this.empFormaPago = empFormaPago;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getRolCargo() {
        return rolCargo;
    }

    public void setRolCargo(String rolCargo) {
        this.rolCargo = rolCargo;
    }

    public Integer getRolDiasExtrasReales() {
        return rolDiasExtrasReales;
    }

    public void setRolDiasExtrasReales(Integer rolDiasExtrasReales) {
        this.rolDiasExtrasReales = rolDiasExtrasReales;
    }

    public Integer getRolDiasFaltasReales() {
        return rolDiasFaltasReales;
    }

    public void setRolDiasFaltasReales(Integer rolDiasFaltasReales) {
        this.rolDiasFaltasReales = rolDiasFaltasReales;
    }

    public Integer getRolDiasPermisoMedico() {
        return rolDiasPermisoMedico;
    }

    public void setRolDiasPermisoMedico(Integer rolDiasPermisoMedico) {
        this.rolDiasPermisoMedico = rolDiasPermisoMedico;
    }

    public String getRolFechaUltimoSueldo() {
        return rolFechaUltimoSueldo;
    }

    public void setRolFechaUltimoSueldo(String rolFechaUltimoSueldo) {
        this.rolFechaUltimoSueldo = rolFechaUltimoSueldo;
    }

    public BigDecimal getRolLiqDesahucio() {
        return rolLiqDesahucio;
    }

    public void setRolLiqDesahucio(BigDecimal rolLiqDesahucio) {
        this.rolLiqDesahucio = rolLiqDesahucio;
    }

    public BigDecimal getRolLiqFondoReserva() {
        return rolLiqFondoReserva;
    }

    public void setRolLiqFondoReserva(BigDecimal rolLiqFondoReserva) {
        this.rolLiqFondoReserva = rolLiqFondoReserva;
    }

    public BigDecimal getRolLiqVacaciones() {
        return rolLiqVacaciones;
    }

    public void setRolLiqVacaciones(BigDecimal rolLiqVacaciones) {
        this.rolLiqVacaciones = rolLiqVacaciones;
    }

    public BigDecimal getRolLiqXiii() {
        return rolLiqXiii;
    }

    public void setRolLiqXiii(BigDecimal rolLiqXiii) {
        this.rolLiqXiii = rolLiqXiii;
    }

    public BigDecimal getRolLiqXiv() {
        return rolLiqXiv;
    }

    public void setRolLiqXiv(BigDecimal rolLiqXiv) {
        this.rolLiqXiv = rolLiqXiv;
    }

    public BigDecimal getRolPrestamos() {
        return rolPrestamos;
    }

    public void setRolPrestamos(BigDecimal rolPrestamos) {
        this.rolPrestamos = rolPrestamos;
    }

    public BigDecimal getRolSueldo() {
        return rolSueldo;
    }

    public void setRolSueldo(BigDecimal rolSueldo) {
        this.rolSueldo = rolSueldo;
    }

    public String getPrFechaAfiliacionIess() {
        return prFechaAfiliacionIess;
    }

    public void setPrFechaAfiliacionIess(String prFechaAfiliacionIess) {
        this.prFechaAfiliacionIess = prFechaAfiliacionIess;
    }

    public Boolean getPrFondoReserva() {
        return prFondoReserva;
    }

    public void setPrFondoReserva(Boolean prFondoReserva) {
        this.prFondoReserva = prFondoReserva;
    }

    public String getPrPrimerIngreso() {
        return prPrimerIngreso;
    }

    public void setPrPrimerIngreso(String prPrimerIngreso) {
        this.prPrimerIngreso = prPrimerIngreso;
    }

    public String getPrPrimeraSalida() {
        return prPrimeraSalida;
    }

    public void setPrPrimeraSalida(String prPrimeraSalida) {
        this.prPrimeraSalida = prPrimeraSalida;
    }

    public Boolean getPrRetencion() {
        return prRetencion;
    }

    public void setPrRetencion(Boolean prRetencion) {
        this.prRetencion = prRetencion;
    }

    public String getPrUltimaSalida() {
        return prUltimaSalida;
    }

    public void setPrUltimaSalida(String prUltimaSalida) {
        this.prUltimaSalida = prUltimaSalida;
    }

    public String getPrUltimoIngreso() {
        return prUltimoIngreso;
    }

    public void setPrUltimoIngreso(String prUltimoIngreso) {
        this.prUltimoIngreso = prUltimoIngreso;
    }

}
