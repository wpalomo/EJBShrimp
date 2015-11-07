/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author misael
 */
public class RhPersonaTO implements Serializable{  
    private String empCodigo;
    private String empCedula;     
    private String empNombres;
    private String empApellidos;
    private String empFechaNacimiento;
    private String empEstadoCivil;
    private BigDecimal empSueldo;
    private Boolean empAfiliado;
    private String empObservaciones;
    
    private String usrEmpresa;
    private String usrCodigo;
    private Date usrFechaInserta;
    
       

    public RhPersonaTO() {        
    }

    public RhPersonaTO(String empCodigo, String empCedula, String empNombres, String empApellidos, String empFechaNacimiento, String empEstadoCivil, BigDecimal empSueldo, Boolean empAfiliado, String empObservaciones, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.empCodigo = empCodigo;
        this.empCedula = empCedula;
        this.empNombres = empNombres;
        this.empApellidos = empApellidos;
        this.empFechaNacimiento = empFechaNacimiento;
        this.empEstadoCivil = empEstadoCivil;
        this.empSueldo = empSueldo;
        this.empAfiliado = empAfiliado;
        this.empObservaciones = empObservaciones;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getEmpCedula() {
        return empCedula;
    }

    public void setEmpCedula(String empCedula) {
        this.empCedula = empCedula;
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

    public String getEmpFechaNacimiento() {
        return empFechaNacimiento;
    }

    public void setEmpFechaNacimiento(String empFechaNacimiento) {
        this.empFechaNacimiento = empFechaNacimiento;
    }

    public String getEmpEstadoCivil() {
        return empEstadoCivil;
    }

    public void setEmpEstadoCivil(String empEstadoCivil) {
        this.empEstadoCivil = empEstadoCivil;
    }

    public BigDecimal getEmpSueldo() {
        return empSueldo;
    }

    public void setEmpSueldo(BigDecimal empSueldo) {
        this.empSueldo = empSueldo;
    }

    public Boolean getEmpAfiliado() {
        return empAfiliado;
    }

    public void setEmpAfiliado(Boolean empAfiliado) {
        this.empAfiliado = empAfiliado;
    }

    public String getEmpObservaciones() {
        return empObservaciones;
    }

    public void setEmpObservaciones(String empObservaciones) {
        this.empObservaciones = empObservaciones;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Date getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(Date usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }
    
}