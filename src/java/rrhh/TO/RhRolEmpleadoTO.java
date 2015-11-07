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
public class RhRolEmpleadoTO implements Serializable{

    private String empCodigo;
    private String perCodigo;
    private String tipCodigo;

    private String conNumero;
    private String secCodigo;
    private String empId;
    private String empApellidosNombres;//agregado
    private String rolCargo;
    private String rolFechaUltimoSueldo;
    private String rolDesde;//fecha
    private String rolHasta;//fecha
//    private Integer rolDiasLaboradosReales;//EJB
    private Integer rolDiasFaltasReales;
    private BigDecimal rolDiasExtrasReales;
    private Integer rolDiasPermisoMedico;
//    private Integer rolDiasDescansoReales;//EJB
//    private Integer rolDiasPagadosReales;//EJB
    private BigDecimal rolSueldo;//EJB-AC
//    private Integer rolDiasLaborados;//EJB
//    private Integer rolDiasDescanso;//EJB
//    private BigDecimal rolIngresos;//EJB
//    private BigDecimal rolBonos;//EJB
//    private BigDecimal rolViaticos;//EJB
    private BigDecimal rolLiqFondoReserva;//EJB
    private BigDecimal rolLiqXiii;//EJB
    private BigDecimal rolLiqXiv;//EJB
    private BigDecimal rolLiqVacaciones;//EJB
    private BigDecimal rolLiqSalarioDigno;//EJB
    private BigDecimal rolLiqBonificacion;//EJB
    private BigDecimal rolLiqDesahucio;//EJB
    private BigDecimal rolLiqDesahucioIntempestivo;//EJB
//    private BigDecimal rolAnticipos;//EJB
    private BigDecimal rolPrestamos;//EJB
//    private BigDecimal rolIess;//EJB
//    private BigDecimal rolRetencionFuente;//EJB
//    private BigDecimal rolTotal;//EJB
    private String rolFormaPago;//EJB-AC
//    private String rolObservaciones;//NO DEBE TENER
//    private BigDecimal rolAportePatronal;//EJB
//    private BigDecimal rolIece;//EJB
//    private BigDecimal rolSecap;//EJB
//    private BigDecimal rolXiii;//EJB
//    private BigDecimal rolXiv;//EJB
//    private BigDecimal rolVacaciones;//EJB
//    private BigDecimal rolDesahucio;//EJB
//    private String rolContableProvisiones;//EJB = null

    private String conDetDocumento;//agregado
    private String conObservaciones;//agregado
    private Boolean porPagar;//agregado
    private Boolean liquidacion;//agregado
    private String fechaSalida;//agregado
    private String motivoSalida;//agregado
    private String empFormaPago;//agregado
    private Boolean reversar;
    private Boolean grabar;//agregado
    RhContableTO rhContableTO;//agregado
    private String usrInsertaRol;//agregado
    
    private String nacionalidad;

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    

    public RhRolEmpleadoTO() {
    }

    public RhRolEmpleadoTO(
            String empCodigo, 
            String perCodigo, 
            String tipCodigo, 
            String conNumero, 
            String secCodigo, 
            String empId, 
            String empApellidosNombres, 
            String rolCargo, 
            String rolFechaUltimoSueldo, 
            String rolDesde, 
            String rolHasta, 
            Integer rolDiasFaltasReales, 
            BigDecimal rolDiasExtrasReales, 
            Integer rolDiasPermisoMedico, 
            BigDecimal rolSueldo, 
            BigDecimal rolLiqFondoReserva, 
            BigDecimal rolLiqXiii, 
            BigDecimal rolLiqXiv, 
            BigDecimal rolLiqVacaciones,
            BigDecimal rolLiqSalarioDigno,
            BigDecimal rolLiqBonificacion, 
            BigDecimal rolLiqDesahucio, 
            BigDecimal rolLiqDesahucioIntempestivo, 
            BigDecimal rolPrestamos, 
            String rolFormaPago, 
            String conDetDocumento, 
            String conObservaciones, 
            Boolean porPagar, 
            Boolean liquidacion, 
            String fechaSalida, 
            String motivoSalida, 
            String empFormaPago, 
            Boolean reversar, 
            Boolean grabar, 
            String usrInsertaRol, String nacionalidad) {
        this.empCodigo = empCodigo;
        this.perCodigo = perCodigo;
        this.tipCodigo = tipCodigo;
        this.conNumero = conNumero;
        this.secCodigo = secCodigo;
        this.empId = empId;
        this.empApellidosNombres = empApellidosNombres;
        this.rolCargo = rolCargo;
        this.rolFechaUltimoSueldo = rolFechaUltimoSueldo;
        this.rolDesde = rolDesde;
        this.rolHasta = rolHasta;
        this.rolDiasFaltasReales = rolDiasFaltasReales;
        this.rolDiasExtrasReales = rolDiasExtrasReales;
        this.rolDiasPermisoMedico = rolDiasPermisoMedico;
        this.rolSueldo = rolSueldo;
        this.rolLiqFondoReserva = rolLiqFondoReserva;
        this.rolLiqXiii = rolLiqXiii;
        this.rolLiqXiv = rolLiqXiv;
        this.rolLiqVacaciones = rolLiqVacaciones;
        this.rolLiqSalarioDigno = rolLiqSalarioDigno;
        this.rolLiqBonificacion = rolLiqBonificacion;
        this.rolLiqDesahucio = rolLiqDesahucio;
        this.rolLiqDesahucioIntempestivo = rolLiqDesahucioIntempestivo;
        this.rolPrestamos = rolPrestamos;
        this.rolFormaPago = rolFormaPago;
        this.conDetDocumento = conDetDocumento;
        this.conObservaciones = conObservaciones;
        this.porPagar = porPagar;
        this.liquidacion = liquidacion;
        this.fechaSalida = fechaSalida;
        this.motivoSalida = motivoSalida;
        this.empFormaPago = empFormaPago;
        this.reversar = reversar;
        this.grabar = grabar;
        this.usrInsertaRol = usrInsertaRol;
        this.nacionalidad = nacionalidad;
    }

    public String getConDetDocumento() {
        return conDetDocumento;
    }

    public void setConDetDocumento(String conDetDocumento) {
        this.conDetDocumento = conDetDocumento;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConObservaciones() {
        return conObservaciones;
    }

    public void setConObservaciones(String conObservaciones) {
        this.conObservaciones = conObservaciones;
    }

    public String getEmpApellidosNombres() {
        return empApellidosNombres;
    }

    public void setEmpApellidosNombres(String empApellidosNombres) {
        this.empApellidosNombres = empApellidosNombres;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
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

    public Boolean getGrabar() {
        return grabar;
    }

    public void setGrabar(Boolean grabar) {
        this.grabar = grabar;
    }

    public Boolean getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(Boolean liquidacion) {
        this.liquidacion = liquidacion;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Boolean getPorPagar() {
        return porPagar;
    }

    public void setPorPagar(Boolean porPagar) {
        this.porPagar = porPagar;
    }

    public RhContableTO getRhContableTO() {
        return rhContableTO;
    }

    public void setRhContableTO(RhContableTO rhContableTO) {
        this.rhContableTO = rhContableTO;
    }

    public String getRolCargo() {
        return rolCargo;
    }

    public void setRolCargo(String rolCargo) {
        this.rolCargo = rolCargo;
    }

    public String getRolDesde() {
        return rolDesde;
    }

    public void setRolDesde(String rolDesde) {
        this.rolDesde = rolDesde;
    }

    public BigDecimal getRolDiasExtrasReales() {
        return rolDiasExtrasReales;
    }

    public void setRolDiasExtrasReales(BigDecimal rolDiasExtrasReales) {
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

    public String getRolFormaPago() {
        return rolFormaPago;
    }

    public void setRolFormaPago(String rolFormaPago) {
        this.rolFormaPago = rolFormaPago;
    }

    public String getRolHasta() {
        return rolHasta;
    }

    public void setRolHasta(String rolHasta) {
        this.rolHasta = rolHasta;
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

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getUsrInsertaRol() {
        return usrInsertaRol;
    }

    public void setUsrInsertaRol(String usrInsertaRol) {
        this.usrInsertaRol = usrInsertaRol;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public BigDecimal getRolLiqDesahucioIntempestivo() {
        return rolLiqDesahucioIntempestivo;
    }

    public void setRolLiqDesahucioIntempestivo(BigDecimal rolLiqDesahucioIntempestivo) {
        this.rolLiqDesahucioIntempestivo = rolLiqDesahucioIntempestivo;
    }

    public BigDecimal getRolLiqSalarioDigno() {
        return rolLiqSalarioDigno;
    }

    public void setRolLiqSalarioDigno(BigDecimal rolLiqSalarioDigno) {
        this.rolLiqSalarioDigno = rolLiqSalarioDigno;
    }

    public Boolean getReversar() {
        return reversar;
    }

    public void setReversar(Boolean reversar) {
        this.reversar = reversar;
    }

    public String getMotivoSalida() {
        return motivoSalida;
    }

    public void setMotivoSalida(String motivoSalida) {
        this.motivoSalida = motivoSalida;
    }

    public BigDecimal getRolLiqBonificacion() {
        return rolLiqBonificacion;
    }

    public void setRolLiqBonificacion(BigDecimal rolLiqBonificacion) {
        this.rolLiqBonificacion = rolLiqBonificacion;
    }
}
