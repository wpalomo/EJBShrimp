/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.reporte;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author paca94
 */
public class ReportesRol implements Serializable{

    private String comprobante;
    private String cedula;
    private String nombres;
    private String fecha;
    private String rolCargo;
    private String rolDesde;//fecha
    private String rolHasta;//fecha
    private Integer rolDiasLaboradosReales;
    private Integer rolDiasFaltasReales;
    private Integer rolDiasExtrasReales;
    private Integer rolDiasDescansoReales;
    private Integer rolDiasPagadosReales;
    private Integer rolDiasPermisoMedico;
    private BigDecimal empSueldo;
    private boolean empAcumulaFondoReserva;
    private BigDecimal rolSaldoAnterior;
    private BigDecimal rolIngresos;
    private BigDecimal rolBonos;
    private BigDecimal rolBonosnd;
    private BigDecimal rolBonosFijo;
    private BigDecimal rolBonosFijoNd;
    private BigDecimal rolOtrosIngresos;
    private BigDecimal rolOtrosIngresosNd;
    private BigDecimal rolViaticos;
    private BigDecimal rolFondoReserva;
    private BigDecimal totalIngresos;
    private BigDecimal rolDescuento;
    private BigDecimal rolLiqXiii;
    private BigDecimal rolLiqXiv;
    private BigDecimal rolLiqVacaciones;
    private BigDecimal rolLiqSalarioDigno;
    private BigDecimal rolLiqDesahucio;
    private BigDecimal rolLiqDesahucioIntempestivo;
    private BigDecimal rolLiqBonificacion;
    private BigDecimal rolAnticipos;
    private BigDecimal rolPrestamos;
    private BigDecimal empDescuentoPermisoMedico;
    private BigDecimal rolIess;
    private BigDecimal rolRetencionFuente;
    private String sedConcepto;
    private String sedDetalle;
    private String sedCp;
    private String sedCc;
    private String sedFecha;
    private BigDecimal sedValor;
    private String sedObservaciones;
    private String formaPago;
    private String referencia;
    private BigDecimal valor;
    private String nacionalidad;
    private String nomSector;

    public ReportesRol(String comprobante, String cedula, String nombres, String fecha, String rolCargo, String rolDesde, String rolHasta, Integer rolDiasLaboradosReales, Integer rolDiasFaltasReales, Integer rolDiasExtrasReales, Integer rolDiasDescansoReales, Integer rolDiasPagadosReales, Integer rolDiasPermisoMedico, BigDecimal empSueldo, boolean empAcumulaFondoReserva, BigDecimal rolSaldoAnterior, BigDecimal rolIngresos, BigDecimal rolBonos, BigDecimal rolBonosnd, BigDecimal rolBonosFijo, BigDecimal rolBonosFijoNd, BigDecimal rolOtrosIngresos, BigDecimal rolOtrosIngresosNd, BigDecimal rolViaticos, BigDecimal rolFondoReserva, BigDecimal totalIngresos, BigDecimal rolDescuento, BigDecimal rolLiqXiii, BigDecimal rolLiqXiv, BigDecimal rolLiqVacaciones, BigDecimal rolLiqSalarioDigno, BigDecimal rolLiqDesahucio, BigDecimal rolLiqDesahucioIntempestivo, BigDecimal rolLiqBonificacion, BigDecimal rolAnticipos, BigDecimal rolPrestamos, BigDecimal empDescuentoPermisoMedico, BigDecimal rolIess, BigDecimal rolRetencionFuente, String sedConcepto, String sedDetalle, String sedCp, String sedCc, String sedFecha, BigDecimal sedValor, String sedObservaciones, String formaPago, String referencia, BigDecimal valor, String nacionalidad) {
        this.comprobante = comprobante;
        this.cedula = cedula;
        this.nombres = nombres;
        this.fecha = fecha;
        this.rolCargo = rolCargo;
        this.rolDesde = rolDesde;
        this.rolHasta = rolHasta;
        this.rolDiasLaboradosReales = rolDiasLaboradosReales;
        this.rolDiasFaltasReales = rolDiasFaltasReales;
        this.rolDiasExtrasReales = rolDiasExtrasReales;
        this.rolDiasDescansoReales = rolDiasDescansoReales;
        this.rolDiasPagadosReales = rolDiasPagadosReales;
        this.rolDiasPermisoMedico = rolDiasPermisoMedico;
        this.empSueldo = empSueldo;
        this.empAcumulaFondoReserva = empAcumulaFondoReserva;
        this.rolSaldoAnterior = rolSaldoAnterior;
        this.rolIngresos = rolIngresos;
        this.rolBonos = rolBonos;
        this.rolBonosnd = rolBonosnd;
        this.rolBonosFijo = rolBonosFijo;
        this.rolBonosFijoNd = rolBonosFijoNd;
        this.rolOtrosIngresos = rolOtrosIngresos;
        this.rolOtrosIngresosNd = rolOtrosIngresosNd;
        this.rolViaticos = rolViaticos;
        this.rolFondoReserva = rolFondoReserva;
        this.totalIngresos = totalIngresos;
        this.rolDescuento = rolDescuento;
        this.rolLiqXiii = rolLiqXiii;
        this.rolLiqXiv = rolLiqXiv;
        this.rolLiqVacaciones = rolLiqVacaciones;
        this.rolLiqSalarioDigno = rolLiqSalarioDigno;
        this.rolLiqDesahucio = rolLiqDesahucio;
        this.rolLiqDesahucioIntempestivo = rolLiqDesahucioIntempestivo;
        this.rolLiqBonificacion = rolLiqBonificacion;
        this.rolAnticipos = rolAnticipos;
        this.rolPrestamos = rolPrestamos;
        this.empDescuentoPermisoMedico = empDescuentoPermisoMedico;
        this.rolIess = rolIess;
        this.rolRetencionFuente = rolRetencionFuente;
        this.sedConcepto = sedConcepto;
        this.sedDetalle = sedDetalle;
        this.sedCp = sedCp;
        this.sedCc = sedCc;
        this.sedFecha = sedFecha;
        this.sedValor = sedValor;
        this.sedObservaciones = sedObservaciones;
        this.formaPago = formaPago;
        this.referencia = referencia;
        this.valor = valor;
        this.nacionalidad = nacionalidad;
    }

    public ReportesRol(String comprobante, String cedula, String nombres, String fecha, String rolCargo, String rolDesde, String rolHasta, Integer rolDiasLaboradosReales, Integer rolDiasFaltasReales, Integer rolDiasExtrasReales, Integer rolDiasDescansoReales, Integer rolDiasPagadosReales, Integer rolDiasPermisoMedico, BigDecimal empSueldo, boolean empAcumulaFondoReserva, BigDecimal rolSaldoAnterior, BigDecimal rolIngresos, BigDecimal rolBonos, BigDecimal rolBonosnd, BigDecimal rolBonosFijo, BigDecimal rolBonosFijoNd, BigDecimal rolOtrosIngresos, BigDecimal rolOtrosIngresosNd, BigDecimal rolViaticos, BigDecimal rolFondoReserva, BigDecimal totalIngresos, BigDecimal rolDescuento, BigDecimal rolLiqXiii, BigDecimal rolLiqXiv, BigDecimal rolLiqVacaciones, BigDecimal rolLiqSalarioDigno, BigDecimal rolLiqDesahucio, BigDecimal rolLiqDesahucioIntempestivo, BigDecimal rolLiqBonificacion, BigDecimal rolAnticipos, BigDecimal rolPrestamos, BigDecimal empDescuentoPermisoMedico, BigDecimal rolIess, BigDecimal rolRetencionFuente, String sedConcepto, String sedDetalle, String sedCp, String sedCc, String sedFecha, BigDecimal sedValor, String sedObservaciones, String formaPago, String referencia, BigDecimal valor, String nacionalidad, String nomSector) {
        this.comprobante = comprobante;
        this.cedula = cedula;
        this.nombres = nombres;
        this.fecha = fecha;
        this.rolCargo = rolCargo;
        this.rolDesde = rolDesde;
        this.rolHasta = rolHasta;
        this.rolDiasLaboradosReales = rolDiasLaboradosReales;
        this.rolDiasFaltasReales = rolDiasFaltasReales;
        this.rolDiasExtrasReales = rolDiasExtrasReales;
        this.rolDiasDescansoReales = rolDiasDescansoReales;
        this.rolDiasPagadosReales = rolDiasPagadosReales;
        this.rolDiasPermisoMedico = rolDiasPermisoMedico;
        this.empSueldo = empSueldo;
        this.empAcumulaFondoReserva = empAcumulaFondoReserva;
        this.rolSaldoAnterior = rolSaldoAnterior;
        this.rolIngresos = rolIngresos;
        this.rolBonos = rolBonos;
        this.rolBonosnd = rolBonosnd;
        this.rolBonosFijo = rolBonosFijo;
        this.rolBonosFijoNd = rolBonosFijoNd;
        this.rolOtrosIngresos = rolOtrosIngresos;
        this.rolOtrosIngresosNd = rolOtrosIngresosNd;
        this.rolViaticos = rolViaticos;
        this.rolFondoReserva = rolFondoReserva;
        this.totalIngresos = totalIngresos;
        this.rolDescuento = rolDescuento;
        this.rolLiqXiii = rolLiqXiii;
        this.rolLiqXiv = rolLiqXiv;
        this.rolLiqVacaciones = rolLiqVacaciones;
        this.rolLiqSalarioDigno = rolLiqSalarioDigno;
        this.rolLiqDesahucio = rolLiqDesahucio;
        this.rolLiqDesahucioIntempestivo = rolLiqDesahucioIntempestivo;
        this.rolLiqBonificacion = rolLiqBonificacion;
        this.rolAnticipos = rolAnticipos;
        this.rolPrestamos = rolPrestamos;
        this.empDescuentoPermisoMedico = empDescuentoPermisoMedico;
        this.rolIess = rolIess;
        this.rolRetencionFuente = rolRetencionFuente;
        this.sedConcepto = sedConcepto;
        this.sedDetalle = sedDetalle;
        this.sedCp = sedCp;
        this.sedCc = sedCc;
        this.sedFecha = sedFecha;
        this.sedValor = sedValor;
        this.sedObservaciones = sedObservaciones;
        this.formaPago = formaPago;
        this.referencia = referencia;
        this.valor = valor;
        this.nacionalidad = nacionalidad;
        this.nomSector = nomSector;
    }

    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public boolean isEmpAcumulaFondoReserva() {
        return empAcumulaFondoReserva;
    }

    public void setEmpAcumulaFondoReserva(boolean empAcumulaFondoReserva) {
        this.empAcumulaFondoReserva = empAcumulaFondoReserva;
    }

    public BigDecimal getEmpDescuentoPermisoMedico() {
        return empDescuentoPermisoMedico;
    }

    public void setEmpDescuentoPermisoMedico(BigDecimal empDescuentoPermisoMedico) {
        this.empDescuentoPermisoMedico = empDescuentoPermisoMedico;
    }

    public BigDecimal getEmpSueldo() {
        return empSueldo;
    }

    public void setEmpSueldo(BigDecimal empSueldo) {
        this.empSueldo = empSueldo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigDecimal getRolAnticipos() {
        return rolAnticipos;
    }

    public void setRolAnticipos(BigDecimal rolAnticipos) {
        this.rolAnticipos = rolAnticipos;
    }

    public BigDecimal getRolBonos() {
        return rolBonos;
    }

    public void setRolBonos(BigDecimal rolBonos) {
        this.rolBonos = rolBonos;
    }

    public BigDecimal getRolBonosFijo() {
        return rolBonosFijo;
    }

    public void setRolBonosFijo(BigDecimal rolBonosFijo) {
        this.rolBonosFijo = rolBonosFijo;
    }

    public BigDecimal getRolBonosFijoNd() {
        return rolBonosFijoNd;
    }

    public void setRolBonosFijoNd(BigDecimal rolBonosFijoNd) {
        this.rolBonosFijoNd = rolBonosFijoNd;
    }

    public BigDecimal getRolBonosnd() {
        return rolBonosnd;
    }

    public void setRolBonosnd(BigDecimal rolBonosnd) {
        this.rolBonosnd = rolBonosnd;
    }

    public String getRolCargo() {
        return rolCargo;
    }

    public void setRolCargo(String rolCargo) {
        this.rolCargo = rolCargo;
    }

    public BigDecimal getRolDescuento() {
        return rolDescuento;
    }

    public void setRolDescuento(BigDecimal rolDescuento) {
        this.rolDescuento = rolDescuento;
    }

    public String getRolDesde() {
        return rolDesde;
    }

    public void setRolDesde(String rolDesde) {
        this.rolDesde = rolDesde;
    }

    public Integer getRolDiasDescansoReales() {
        return rolDiasDescansoReales;
    }

    public void setRolDiasDescansoReales(Integer rolDiasDescansoReales) {
        this.rolDiasDescansoReales = rolDiasDescansoReales;
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

    public Integer getRolDiasLaboradosReales() {
        return rolDiasLaboradosReales;
    }

    public void setRolDiasLaboradosReales(Integer rolDiasLaboradosReales) {
        this.rolDiasLaboradosReales = rolDiasLaboradosReales;
    }

    public Integer getRolDiasPagadosReales() {
        return rolDiasPagadosReales;
    }

    public void setRolDiasPagadosReales(Integer rolDiasPagadosReales) {
        this.rolDiasPagadosReales = rolDiasPagadosReales;
    }

    public Integer getRolDiasPermisoMedico() {
        return rolDiasPermisoMedico;
    }

    public void setRolDiasPermisoMedico(Integer rolDiasPermisoMedico) {
        this.rolDiasPermisoMedico = rolDiasPermisoMedico;
    }

    public BigDecimal getRolFondoReserva() {
        return rolFondoReserva;
    }

    public void setRolFondoReserva(BigDecimal rolFondoReserva) {
        this.rolFondoReserva = rolFondoReserva;
    }

    public String getRolHasta() {
        return rolHasta;
    }

    public void setRolHasta(String rolHasta) {
        this.rolHasta = rolHasta;
    }

    public BigDecimal getRolIess() {
        return rolIess;
    }

    public void setRolIess(BigDecimal rolIess) {
        this.rolIess = rolIess;
    }

    public BigDecimal getRolIngresos() {
        return rolIngresos;
    }

    public void setRolIngresos(BigDecimal rolIngresos) {
        this.rolIngresos = rolIngresos;
    }

    public BigDecimal getRolLiqBonificacion() {
        return rolLiqBonificacion;
    }

    public void setRolLiqBonificacion(BigDecimal rolLiqBonificacion) {
        this.rolLiqBonificacion = rolLiqBonificacion;
    }

    public BigDecimal getRolLiqDesahucio() {
        return rolLiqDesahucio;
    }

    public void setRolLiqDesahucio(BigDecimal rolLiqDesahucio) {
        this.rolLiqDesahucio = rolLiqDesahucio;
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

    public BigDecimal getRolOtrosIngresos() {
        return rolOtrosIngresos;
    }

    public void setRolOtrosIngresos(BigDecimal rolOtrosIngresos) {
        this.rolOtrosIngresos = rolOtrosIngresos;
    }

    public BigDecimal getRolOtrosIngresosNd() {
        return rolOtrosIngresosNd;
    }

    public void setRolOtrosIngresosNd(BigDecimal rolOtrosIngresosNd) {
        this.rolOtrosIngresosNd = rolOtrosIngresosNd;
    }

    public BigDecimal getRolPrestamos() {
        return rolPrestamos;
    }

    public void setRolPrestamos(BigDecimal rolPrestamos) {
        this.rolPrestamos = rolPrestamos;
    }

    public BigDecimal getRolRetencionFuente() {
        return rolRetencionFuente;
    }

    public void setRolRetencionFuente(BigDecimal rolRetencionFuente) {
        this.rolRetencionFuente = rolRetencionFuente;
    }

    public BigDecimal getRolSaldoAnterior() {
        return rolSaldoAnterior;
    }

    public void setRolSaldoAnterior(BigDecimal rolSaldoAnterior) {
        this.rolSaldoAnterior = rolSaldoAnterior;
    }

    public BigDecimal getRolViaticos() {
        return rolViaticos;
    }

    public void setRolViaticos(BigDecimal rolViaticos) {
        this.rolViaticos = rolViaticos;
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

    public BigDecimal getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(BigDecimal totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    
    
    
}
