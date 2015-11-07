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
public class RhRolTO implements Serializable {

    private String empCodigo;
    private String perCodigo;
    private String tipCodigo;
    private String conNumero;
    private String secCodigo;
    private String empId;
    private String empCargo;
    private String rolFechaUltimoSueldo;
    private String rolDesde;//fecha
    private String rolHasta;//fecha
    private Integer rolDiasLaboradosReales;
    private Integer rolDiasFaltasReales;
    private BigDecimal rolDiasExtrasReales;
    private Integer rolDiasDescansoReales;
    private Integer rolDiasPagadosReales;
    private Integer rolDiasPermisoMedico;
    private BigDecimal empSueldo;
    private Integer empDiasLaborados;
    private Integer empDiasDescanso;
    private Boolean empCancelarXiiiSueldoMensualmente;
    private Boolean empCancelarXivSueldoMensualmente;
    private Boolean empCancelarFondoReservaMensualmente;
    private BigDecimal empDescuentoPermisoMedico;
    private BigDecimal rolSaldoAnterior;
    private BigDecimal rolIngresos;
    private BigDecimal rolBonos;
    private BigDecimal rolBonosnd;
    private BigDecimal rolViaticos;
    private BigDecimal rolLiqFondoReserva;
    private BigDecimal rolLiqXiii;
    private BigDecimal rolLiqXiv;
    private BigDecimal rolLiqVacaciones;
    private BigDecimal rolLiqSalarioDigno;
    private BigDecimal rolLiqBonificacion;//rol_liq_bonificacion
    private BigDecimal rolLiqDesahucio;
    private BigDecimal rolLiqDesahucioIntempestivo;
    private BigDecimal rolAnticipos;
    private BigDecimal rolPrestamos;
    private BigDecimal rolIess;
    private BigDecimal rolRetencionFuente;
    private BigDecimal rolDescuentoPermisoMedico;
    private BigDecimal rolTotal;
    private String rolFormaPago;
    private BigDecimal rolAportePatronal;
    private BigDecimal rolIece;
    private BigDecimal rolSecap;
    private BigDecimal rolXiii;
    private BigDecimal rolXiv;
    private BigDecimal rolFondoReserva;
    private BigDecimal rolVacaciones;
    private BigDecimal rolDesahucio;
    private String rolProvisionEmpresa;
    private String rolProvisionPeriodo;
    private String rolProvisionTipo;
    private String rolProvisionNumero;
    private BigDecimal rolBonosFijo;
    private BigDecimal rolBonosFijoNd;
    private BigDecimal empBonosFijo;
    private BigDecimal empBonosFijoNd;
    private Integer rolSecuencial;
    private Boolean reversar;
    //informacion
    private String empFormaPago;
    private Boolean empAfiliado;
    private Boolean empRetencion;
    private Boolean empFondoReserva;
    private Boolean empSalarioNeto;
    private String empFechaAfiliacionIess;
    private String empPrimerIngreso;
    private String empPrimeraSalida;
    private String empUltimoIngreso;
    private String empUltimaSalida;
    private BigDecimal empOtrosIngresos;
    private BigDecimal empOtrosIngresosNd;
    private BigDecimal rolOtrosIngresos;
    private BigDecimal rolOtrosIngresosNd;

    public RhRolTO() {
    }

    public RhRolTO(String empCodigo, String perCodigo, String tipCodigo, String conNumero, String secCodigo, String empId, String empCargo, String rolFechaUltimoSueldo, String rolDesde, String rolHasta, Integer rolDiasLaboradosReales, Integer rolDiasFaltasReales, BigDecimal rolDiasExtrasReales, Integer rolDiasDescansoReales, Integer rolDiasPagadosReales, Integer rolDiasPermisoMedico, BigDecimal empSueldo, Integer empDiasLaborados, Integer empDiasDescanso, Boolean empCancelarXiiiSueldoMensualmente, Boolean empCancelarXivSueldoMensualmente, Boolean empCancelarFondoReservaMensualmente, BigDecimal empDescuentoPermisoMedico, BigDecimal rolSaldoAnterior, BigDecimal rolIngresos, BigDecimal rolBonos, BigDecimal rolBonosnd, BigDecimal rolViaticos, BigDecimal rolLiqFondoReserva, BigDecimal rolLiqXiii, BigDecimal rolLiqXiv, BigDecimal rolLiqVacaciones, BigDecimal rolLiqSalarioDigno, BigDecimal rolLiqBonificacion, BigDecimal rolLiqDesahucio, BigDecimal rolLiqDesahucioIntempestivo, BigDecimal rolAnticipos, BigDecimal rolPrestamos, BigDecimal rolIess, BigDecimal rolRetencionFuente, BigDecimal rolDescuentoPermisoMedico, BigDecimal rolTotal, String rolFormaPago, BigDecimal rolAportePatronal, BigDecimal rolIece, BigDecimal rolSecap, BigDecimal rolXiii, BigDecimal rolXiv, BigDecimal rolFondoReserva, BigDecimal rolVacaciones, BigDecimal rolDesahucio, String rolProvisionEmpresa, String rolProvisionPeriodo, String rolProvisionTipo, String rolProvisionNumero, BigDecimal rolBonosFijo, BigDecimal rolBonosFijoNd, BigDecimal empBonosFijo, BigDecimal empBonosFijoNd, Integer rolSecuencial, Boolean reversar, String empFormaPago, Boolean empAfiliado, Boolean empRetencion, Boolean empFondoReserva, Boolean empSalarioNeto, String empFechaAfiliacionIess, String empPrimerIngreso, String empPrimeraSalida, String empUltimoIngreso, String empUltimaSalida, BigDecimal empOtrosIngresos, BigDecimal empOtrosIngresosNd, BigDecimal rolOtrosIngresos, BigDecimal rolOtrosIngresosNd) {
        this.empCodigo = empCodigo;
        this.perCodigo = perCodigo;
        this.tipCodigo = tipCodigo;
        this.conNumero = conNumero;
        this.secCodigo = secCodigo;
        this.empId = empId;
        this.empCargo = empCargo;
        this.rolFechaUltimoSueldo = rolFechaUltimoSueldo;
        this.rolDesde = rolDesde;
        this.rolHasta = rolHasta;
        this.rolDiasLaboradosReales = rolDiasLaboradosReales;
        this.rolDiasFaltasReales = rolDiasFaltasReales;
        this.rolDiasExtrasReales = rolDiasExtrasReales;
        this.rolDiasDescansoReales = rolDiasDescansoReales;
        this.rolDiasPagadosReales = rolDiasPagadosReales;
        this.rolDiasPermisoMedico = rolDiasPermisoMedico;
        this.empSueldo = empSueldo;
        this.empDiasLaborados = empDiasLaborados;
        this.empDiasDescanso = empDiasDescanso;
        this.empCancelarXiiiSueldoMensualmente = empCancelarXiiiSueldoMensualmente;
        this.empCancelarXivSueldoMensualmente = empCancelarXivSueldoMensualmente;
        this.empCancelarFondoReservaMensualmente = empCancelarFondoReservaMensualmente;
        this.empDescuentoPermisoMedico = empDescuentoPermisoMedico;
        this.rolSaldoAnterior = rolSaldoAnterior;
        this.rolIngresos = rolIngresos;
        this.rolBonos = rolBonos;
        this.rolBonosnd = rolBonosnd;
        this.rolViaticos = rolViaticos;
        this.rolLiqFondoReserva = rolLiqFondoReserva;
        this.rolLiqXiii = rolLiqXiii;
        this.rolLiqXiv = rolLiqXiv;
        this.rolLiqVacaciones = rolLiqVacaciones;
        this.rolLiqSalarioDigno = rolLiqSalarioDigno;
        this.rolLiqBonificacion = rolLiqBonificacion;
        this.rolLiqDesahucio = rolLiqDesahucio;
        this.rolLiqDesahucioIntempestivo = rolLiqDesahucioIntempestivo;
        this.rolAnticipos = rolAnticipos;
        this.rolPrestamos = rolPrestamos;
        this.rolIess = rolIess;
        this.rolRetencionFuente = rolRetencionFuente;
        this.rolDescuentoPermisoMedico = rolDescuentoPermisoMedico;
        this.rolTotal = rolTotal;
        this.rolFormaPago = rolFormaPago;
        this.rolAportePatronal = rolAportePatronal;
        this.rolIece = rolIece;
        this.rolSecap = rolSecap;
        this.rolXiii = rolXiii;
        this.rolXiv = rolXiv;
        this.rolFondoReserva = rolFondoReserva;
        this.rolVacaciones = rolVacaciones;
        this.rolDesahucio = rolDesahucio;
        this.rolProvisionEmpresa = rolProvisionEmpresa;
        this.rolProvisionPeriodo = rolProvisionPeriodo;
        this.rolProvisionTipo = rolProvisionTipo;
        this.rolProvisionNumero = rolProvisionNumero;
        this.rolBonosFijo = rolBonosFijo;
        this.rolBonosFijoNd = rolBonosFijoNd;
        this.empBonosFijo = empBonosFijo;
        this.empBonosFijoNd = empBonosFijoNd;
        this.rolSecuencial = rolSecuencial;
        this.reversar = reversar;
        this.empFormaPago = empFormaPago;
        this.empAfiliado = empAfiliado;
        this.empRetencion = empRetencion;
        this.empFondoReserva = empFondoReserva;
        this.empSalarioNeto = empSalarioNeto;
        this.empFechaAfiliacionIess = empFechaAfiliacionIess;
        this.empPrimerIngreso = empPrimerIngreso;
        this.empPrimeraSalida = empPrimeraSalida;
        this.empUltimoIngreso = empUltimoIngreso;
        this.empUltimaSalida = empUltimaSalida;
        this.empOtrosIngresos = empOtrosIngresos;
        this.empOtrosIngresosNd = empOtrosIngresosNd;
        this.rolOtrosIngresos = rolOtrosIngresos;
        this.rolOtrosIngresosNd = rolOtrosIngresosNd;
    }

    public BigDecimal getRolLiqBonificacion() {
        return rolLiqBonificacion;
    }

    public void setRolLiqBonificacion(BigDecimal rolLiqBonificacion) {
        this.rolLiqBonificacion = rolLiqBonificacion;
    }

    public Boolean getEmpSalarioNeto() {
        return empSalarioNeto;
    }

    public void setEmpSalarioNeto(Boolean empSalarioNeto) {
        this.empSalarioNeto = empSalarioNeto;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public Boolean getEmpAfiliado() {
        return empAfiliado;
    }

    public void setEmpAfiliado(Boolean empAfiliado) {
        this.empAfiliado = empAfiliado;
    }

    public BigDecimal getEmpBonosFijo() {
        return empBonosFijo;
    }

    public void setEmpBonosFijo(BigDecimal empBonosFijo) {
        this.empBonosFijo = empBonosFijo;
    }

    public BigDecimal getEmpBonosFijoNd() {
        return empBonosFijoNd;
    }

    public void setEmpBonosFijoNd(BigDecimal empBonosFijoNd) {
        this.empBonosFijoNd = empBonosFijoNd;
    }

    public Boolean getEmpCancelarFondoReservaMensualmente() {
        return empCancelarFondoReservaMensualmente;
    }

    public void setEmpCancelarFondoReservaMensualmente(Boolean empCancelarFondoReservaMensualmente) {
        this.empCancelarFondoReservaMensualmente = empCancelarFondoReservaMensualmente;
    }

    public Boolean getEmpCancelarXiiiSueldoMensualmente() {
        return empCancelarXiiiSueldoMensualmente;
    }

    public void setEmpCancelarXiiiSueldoMensualmente(Boolean empCancelarXiiiSueldoMensualmente) {
        this.empCancelarXiiiSueldoMensualmente = empCancelarXiiiSueldoMensualmente;
    }

    public Boolean getEmpCancelarXivSueldoMensualmente() {
        return empCancelarXivSueldoMensualmente;
    }

    public void setEmpCancelarXivSueldoMensualmente(Boolean empCancelarXivSueldoMensualmente) {
        this.empCancelarXivSueldoMensualmente = empCancelarXivSueldoMensualmente;
    }

    public String getEmpCargo() {
        return empCargo;
    }

    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public BigDecimal getEmpDescuentoPermisoMedico() {
        return empDescuentoPermisoMedico;
    }

    public void setEmpDescuentoPermisoMedico(BigDecimal empDescuentoPermisoMedico) {
        this.empDescuentoPermisoMedico = empDescuentoPermisoMedico;
    }

    public Integer getEmpDiasDescanso() {
        return empDiasDescanso;
    }

    public void setEmpDiasDescanso(Integer empDiasDescanso) {
        this.empDiasDescanso = empDiasDescanso;
    }

    public Integer getEmpDiasLaborados() {
        return empDiasLaborados;
    }

    public void setEmpDiasLaborados(Integer empDiasLaborados) {
        this.empDiasLaborados = empDiasLaborados;
    }

    public String getEmpFechaAfiliacionIess() {
        return empFechaAfiliacionIess;
    }

    public void setEmpFechaAfiliacionIess(String empFechaAfiliacionIess) {
        this.empFechaAfiliacionIess = empFechaAfiliacionIess;
    }

    public Boolean getEmpFondoReserva() {
        return empFondoReserva;
    }

    public void setEmpFondoReserva(Boolean empFondoReserva) {
        this.empFondoReserva = empFondoReserva;
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

    public String getEmpPrimerIngreso() {
        return empPrimerIngreso;
    }

    public void setEmpPrimerIngreso(String empPrimerIngreso) {
        this.empPrimerIngreso = empPrimerIngreso;
    }

    public String getEmpPrimeraSalida() {
        return empPrimeraSalida;
    }

    public void setEmpPrimeraSalida(String empPrimeraSalida) {
        this.empPrimeraSalida = empPrimeraSalida;
    }

    public Boolean getEmpRetencion() {
        return empRetencion;
    }

    public void setEmpRetencion(Boolean empRetencion) {
        this.empRetencion = empRetencion;
    }

    public BigDecimal getEmpSueldo() {
        return empSueldo;
    }

    public void setEmpSueldo(BigDecimal empSueldo) {
        this.empSueldo = empSueldo;
    }

    public String getEmpUltimaSalida() {
        return empUltimaSalida;
    }

    public void setEmpUltimaSalida(String empUltimaSalida) {
        this.empUltimaSalida = empUltimaSalida;
    }

    public String getEmpUltimoIngreso() {
        return empUltimoIngreso;
    }

    public void setEmpUltimoIngreso(String empUltimoIngreso) {
        this.empUltimoIngreso = empUltimoIngreso;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public BigDecimal getRolAnticipos() {
        return rolAnticipos;
    }

    public void setRolAnticipos(BigDecimal rolAnticipos) {
        this.rolAnticipos = rolAnticipos;
    }

    public BigDecimal getRolAportePatronal() {
        return rolAportePatronal;
    }

    public void setRolAportePatronal(BigDecimal rolAportePatronal) {
        this.rolAportePatronal = rolAportePatronal;
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

    public BigDecimal getRolDesahucio() {
        return rolDesahucio;
    }

    public void setRolDesahucio(BigDecimal rolDesahucio) {
        this.rolDesahucio = rolDesahucio;
    }

    public BigDecimal getRolDescuentoPermisoMedico() {
        return rolDescuentoPermisoMedico;
    }

    public void setRolDescuentoPermisoMedico(BigDecimal rolDescuentoPermisoMedico) {
        this.rolDescuentoPermisoMedico = rolDescuentoPermisoMedico;
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

    public String getRolFechaUltimoSueldo() {
        return rolFechaUltimoSueldo;
    }

    public void setRolFechaUltimoSueldo(String rolFechaUltimoSueldo) {
        this.rolFechaUltimoSueldo = rolFechaUltimoSueldo;
    }

    public BigDecimal getRolFondoReserva() {
        return rolFondoReserva;
    }

    public void setRolFondoReserva(BigDecimal rolFondoReserva) {
        this.rolFondoReserva = rolFondoReserva;
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

    public BigDecimal getRolIece() {
        return rolIece;
    }

    public void setRolIece(BigDecimal rolIece) {
        this.rolIece = rolIece;
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

    public BigDecimal getRolLiqFondoReserva() {
        return rolLiqFondoReserva;
    }

    public void setRolLiqFondoReserva(BigDecimal rolLiqFondoReserva) {
        this.rolLiqFondoReserva = rolLiqFondoReserva;
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

    public BigDecimal getRolPrestamos() {
        return rolPrestamos;
    }

    public void setRolPrestamos(BigDecimal rolPrestamos) {
        this.rolPrestamos = rolPrestamos;
    }

    public String getRolProvisionEmpresa() {
        return rolProvisionEmpresa;
    }

    public void setRolProvisionEmpresa(String rolProvisionEmpresa) {
        this.rolProvisionEmpresa = rolProvisionEmpresa;
    }

    public String getRolProvisionNumero() {
        return rolProvisionNumero;
    }

    public void setRolProvisionNumero(String rolProvisionNumero) {
        this.rolProvisionNumero = rolProvisionNumero;
    }

    public String getRolProvisionPeriodo() {
        return rolProvisionPeriodo;
    }

    public void setRolProvisionPeriodo(String rolProvisionPeriodo) {
        this.rolProvisionPeriodo = rolProvisionPeriodo;
    }

    public String getRolProvisionTipo() {
        return rolProvisionTipo;
    }

    public void setRolProvisionTipo(String rolProvisionTipo) {
        this.rolProvisionTipo = rolProvisionTipo;
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

    public BigDecimal getRolSecap() {
        return rolSecap;
    }

    public void setRolSecap(BigDecimal rolSecap) {
        this.rolSecap = rolSecap;
    }

    public Integer getRolSecuencial() {
        return rolSecuencial;
    }

    public void setRolSecuencial(Integer rolSecuencial) {
        this.rolSecuencial = rolSecuencial;
    }

    public BigDecimal getRolTotal() {
        return rolTotal;
    }

    public void setRolTotal(BigDecimal rolTotal) {
        this.rolTotal = rolTotal;
    }

    public BigDecimal getRolVacaciones() {
        return rolVacaciones;
    }

    public void setRolVacaciones(BigDecimal rolVacaciones) {
        this.rolVacaciones = rolVacaciones;
    }

    public BigDecimal getRolViaticos() {
        return rolViaticos;
    }

    public void setRolViaticos(BigDecimal rolViaticos) {
        this.rolViaticos = rolViaticos;
    }

    public BigDecimal getRolXiii() {
        return rolXiii;
    }

    public void setRolXiii(BigDecimal rolXiii) {
        this.rolXiii = rolXiii;
    }

    public BigDecimal getRolXiv() {
        return rolXiv;
    }

    public void setRolXiv(BigDecimal rolXiv) {
        this.rolXiv = rolXiv;
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

    public Boolean getReversar() {
        return reversar;
    }

    public void setReversar(Boolean reversar) {
        this.reversar = reversar;
    }

    public BigDecimal getEmpOtrosIngresos() {
        return empOtrosIngresos;
    }

    public void setEmpOtrosIngresos(BigDecimal empOtrosIngresos) {
        this.empOtrosIngresos = empOtrosIngresos;
    }

    public BigDecimal getEmpOtrosIngresosNd() {
        return empOtrosIngresosNd;
    }

    public void setEmpOtrosIngresosNd(BigDecimal empOtrosIngresosNd) {
        this.empOtrosIngresosNd = empOtrosIngresosNd;
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
}