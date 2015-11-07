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
public class RhFunPlantillaSueldosLoteTO implements Serializable{
    private String prCategoria;
    private String prId;//presentar
    private String prNombres;//presentar
    private String prCargo;//presentar
    private String prSector;
    private String prDesde;
    private String prHasta;
    private String rolFechaUltimoSueldo;
    private int rolDiasLaboradosReales;//Calcular
    private int rolDiasFaltasReales;//Ingresar
    private int rolDiasExtrasReales;//Ingresar
    private int rolDiasDescansoReales;//Calcular
    private int rolDiasPagadosReales;//Calcular
    private int rolDiasPermisoMedico;//Ingresar
    private java.math.BigDecimal rolSaldoAnterior;//presentar Ingresos
    private java.math.BigDecimal rolIngresos;//presentar Ingresos
    private java.math.BigDecimal rolBonos;//presentar Ingresos
    private java.math.BigDecimal rolBonosnd;//presentar Ingresos
    private java.math.BigDecimal rolBonoFijo;//presentar Ingresos
    private java.math.BigDecimal rolBonoFijoNd;//presentar Ingresos
    private java.math.BigDecimal rolOtrosIngresos;//presentar Ingresos
    private java.math.BigDecimal rolOtrosIngresosNd;//presentar Ingresos
    private java.math.BigDecimal rolViaticos;//presentar Ingresos
    private java.math.BigDecimal rolLiqFondoReserva;
    private java.math.BigDecimal rolLiqXiii;
    private java.math.BigDecimal rolLiqXiv;
    private java.math.BigDecimal rolLiqVacaciones;
    private java.math.BigDecimal rolLiqSalarioDigno;
    private java.math.BigDecimal rolLiqDesahucio;
    private java.math.BigDecimal rolLiqDesahucioIntempestivo;
    private java.math.BigDecimal rolAnticipos;//presentar Descuentos
    private java.math.BigDecimal rolPrestamos;//presentar Descuentos
    private java.math.BigDecimal rolIess;//presentar Descuentos
    private java.math.BigDecimal rolRetencionFuente;//presentar Descuentos
    private java.math.BigDecimal rolDescuentoPermisoMedico;//presentar Descuentos
    private java.math.BigDecimal rolTotal;
    private java.math.BigDecimal rolAportePatronal;
    private java.math.BigDecimal rolIece;
    private java.math.BigDecimal rolSecap;
    private java.math.BigDecimal rolXiii;
    private java.math.BigDecimal rolXiv;
    private java.math.BigDecimal rolFondoReserva;//presentar Ingres/Descuentos valor bool
    private java.math.BigDecimal rolVacaciones;
    private java.math.BigDecimal rolDesahucio;
    private boolean rolReversado;
    private java.math.BigDecimal empSueldo;
    private java.math.BigDecimal empBonoFijo;
    private java.math.BigDecimal empBonoFijoNd;
    private java.math.BigDecimal empOtrosIngresos;
    private java.math.BigDecimal empOtrosIngresosNd;
    private int empDiasLaborados;
    private int empDiasDescanso;
    private boolean empCancelarXiiiSueldoMensualmente;
    private boolean empCancelarXivSueldoMensualmente;
    private boolean empCancelarFondoReservaMensualmente;
    private String rolFormaPago;
    private rrhh.TO.RhRolesLoteValoresTO rhRolesLoteValoresTO;

    public RhFunPlantillaSueldosLoteTO() {
    }

    public RhFunPlantillaSueldosLoteTO(String prCategoria, String prId, String prNombres, String prCargo, String prSector, String prDesde, String prHasta, String rolFechaUltimoSueldo, int rolDiasLaboradosReales, int rolDiasFaltasReales, int rolDiasExtrasReales, int rolDiasDescansoReales, int rolDiasPagadosReales, int rolDiasPermisoMedico, BigDecimal rolSaldoAnterior, BigDecimal rolIngresos, BigDecimal rolBonos, BigDecimal rolBonosnd, BigDecimal rolBonoFijo, BigDecimal rolBonoFijoNd, BigDecimal rolOtrosIngresos, BigDecimal rolOtrosIngresosNd, BigDecimal rolViaticos, BigDecimal rolLiqFondoReserva, BigDecimal rolLiqXiii, BigDecimal rolLiqXiv, BigDecimal rolLiqVacaciones, BigDecimal rolLiqSalarioDigno, BigDecimal rolLiqDesahucio, BigDecimal rolLiqDesahucioIntempestivo, BigDecimal rolAnticipos, BigDecimal rolPrestamos, BigDecimal rolIess, BigDecimal rolRetencionFuente, BigDecimal rolDescuentoPermisoMedico, BigDecimal rolTotal, BigDecimal rolAportePatronal, BigDecimal rolIece, BigDecimal rolSecap, BigDecimal rolXiii, BigDecimal rolXiv, BigDecimal rolFondoReserva, BigDecimal rolVacaciones, BigDecimal rolDesahucio, boolean rolReversado, BigDecimal empSueldo, BigDecimal empBonoFijo, BigDecimal empBonoFijoNd, BigDecimal empOtrosIngresos, BigDecimal empOtrosIngresosNd, int empDiasLaborados, int empDiasDescanso, boolean empCancelarXiiiSueldoMensualmente, boolean empCancelarXivSueldoMensualmente, boolean empCancelarFondoReservaMensualmente, String rolFormaPago, rrhh.TO.RhRolesLoteValoresTO rhRolesLoteValoresTO) {
        this.prCategoria = prCategoria;
        this.prId = prId;
        this.prNombres = prNombres;
        this.prCargo = prCargo;
        this.prSector = prSector;
        this.prDesde = prDesde;
        this.prHasta = prHasta;
        this.rolFechaUltimoSueldo = rolFechaUltimoSueldo;
        this.rolDiasLaboradosReales = rolDiasLaboradosReales;
        this.rolDiasFaltasReales = rolDiasFaltasReales;
        this.rolDiasExtrasReales = rolDiasExtrasReales;
        this.rolDiasDescansoReales = rolDiasDescansoReales;
        this.rolDiasPagadosReales = rolDiasPagadosReales;
        this.rolDiasPermisoMedico = rolDiasPermisoMedico;
        this.rolSaldoAnterior = rolSaldoAnterior;
        this.rolIngresos = rolIngresos;
        this.rolBonos = rolBonos;
        this.rolBonosnd = rolBonosnd;
        this.rolBonoFijo = rolBonoFijo;
        this.rolBonoFijoNd = rolBonoFijoNd;
        this.rolOtrosIngresos = rolOtrosIngresos;
        this.rolOtrosIngresosNd = rolOtrosIngresosNd;
        this.rolViaticos = rolViaticos;
        this.rolLiqFondoReserva = rolLiqFondoReserva;
        this.rolLiqXiii = rolLiqXiii;
        this.rolLiqXiv = rolLiqXiv;
        this.rolLiqVacaciones = rolLiqVacaciones;
        this.rolLiqSalarioDigno = rolLiqSalarioDigno;
        this.rolLiqDesahucio = rolLiqDesahucio;
        this.rolLiqDesahucioIntempestivo = rolLiqDesahucioIntempestivo;
        this.rolAnticipos = rolAnticipos;
        this.rolPrestamos = rolPrestamos;
        this.rolIess = rolIess;
        this.rolRetencionFuente = rolRetencionFuente;
        this.rolDescuentoPermisoMedico = rolDescuentoPermisoMedico;
        this.rolTotal = rolTotal;
        this.rolAportePatronal = rolAportePatronal;
        this.rolIece = rolIece;
        this.rolSecap = rolSecap;
        this.rolXiii = rolXiii;
        this.rolXiv = rolXiv;
        this.rolFondoReserva = rolFondoReserva;
        this.rolVacaciones = rolVacaciones;
        this.rolDesahucio = rolDesahucio;
        this.rolReversado = rolReversado;
        this.empSueldo = empSueldo;
        this.empBonoFijo = empBonoFijo;
        this.empBonoFijoNd = empBonoFijoNd;
        this.empOtrosIngresos = empOtrosIngresos;
        this.empOtrosIngresosNd = empOtrosIngresosNd;
        this.empDiasLaborados = empDiasLaborados;
        this.empDiasDescanso = empDiasDescanso;
        this.empCancelarXiiiSueldoMensualmente = empCancelarXiiiSueldoMensualmente;
        this.empCancelarXivSueldoMensualmente = empCancelarXivSueldoMensualmente;
        this.empCancelarFondoReservaMensualmente = empCancelarFondoReservaMensualmente;
        this.rolFormaPago = rolFormaPago;
        this.rhRolesLoteValoresTO =rhRolesLoteValoresTO;
    }

    public BigDecimal getEmpBonoFijo() {
        return empBonoFijo;
    }

    public void setEmpBonoFijo(BigDecimal empBonoFijo) {
        this.empBonoFijo = empBonoFijo;
    }

    public BigDecimal getEmpBonoFijoNd() {
        return empBonoFijoNd;
    }

    public void setEmpBonoFijoNd(BigDecimal empBonoFijoNd) {
        this.empBonoFijoNd = empBonoFijoNd;
    }

    public boolean isEmpCancelarFondoReservaMensualmente() {
        return empCancelarFondoReservaMensualmente;
    }

    public void setEmpCancelarFondoReservaMensualmente(boolean empCancelarFondoReservaMensualmente) {
        this.empCancelarFondoReservaMensualmente = empCancelarFondoReservaMensualmente;
    }

    public boolean isEmpCancelarXiiiSueldoMensualmente() {
        return empCancelarXiiiSueldoMensualmente;
    }

    public void setEmpCancelarXiiiSueldoMensualmente(boolean empCancelarXiiiSueldoMensualmente) {
        this.empCancelarXiiiSueldoMensualmente = empCancelarXiiiSueldoMensualmente;
    }

    public boolean isEmpCancelarXivSueldoMensualmente() {
        return empCancelarXivSueldoMensualmente;
    }

    public void setEmpCancelarXivSueldoMensualmente(boolean empCancelarXivSueldoMensualmente) {
        this.empCancelarXivSueldoMensualmente = empCancelarXivSueldoMensualmente;
    }

    public int getEmpDiasDescanso() {
        return empDiasDescanso;
    }

    public void setEmpDiasDescanso(int empDiasDescanso) {
        this.empDiasDescanso = empDiasDescanso;
    }

    public int getEmpDiasLaborados() {
        return empDiasLaborados;
    }

    public void setEmpDiasLaborados(int empDiasLaborados) {
        this.empDiasLaborados = empDiasLaborados;
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

    public BigDecimal getEmpSueldo() {
        return empSueldo;
    }

    public void setEmpSueldo(BigDecimal empSueldo) {
        this.empSueldo = empSueldo;
    }

    public String getPrCargo() {
        return prCargo;
    }

    public void setPrCargo(String prCargo) {
        this.prCargo = prCargo;
    }

    public String getPrCategoria() {
        return prCategoria;
    }

    public void setPrCategoria(String prCategoria) {
        this.prCategoria = prCategoria;
    }

    public String getPrDesde() {
        return prDesde;
    }

    public void setPrDesde(String prDesde) {
        this.prDesde = prDesde;
    }

    public String getPrHasta() {
        return prHasta;
    }

    public void setPrHasta(String prHasta) {
        this.prHasta = prHasta;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    public String getPrNombres() {
        return prNombres;
    }

    public void setPrNombres(String prNombres) {
        this.prNombres = prNombres;
    }

    public String getPrSector() {
        return prSector;
    }

    public void setPrSector(String prSector) {
        this.prSector = prSector;
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

    public BigDecimal getRolBonoFijo() {
        return rolBonoFijo;
    }

    public void setRolBonoFijo(BigDecimal rolBonoFijo) {
        this.rolBonoFijo = rolBonoFijo;
    }

    public BigDecimal getRolBonoFijoNd() {
        return rolBonoFijoNd;
    }

    public void setRolBonoFijoNd(BigDecimal rolBonoFijoNd) {
        this.rolBonoFijoNd = rolBonoFijoNd;
    }

    public BigDecimal getRolBonos() {
        return rolBonos;
    }

    public void setRolBonos(BigDecimal rolBonos) {
        this.rolBonos = rolBonos;
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

    public int getRolDiasDescansoReales() {
        return rolDiasDescansoReales;
    }

    public void setRolDiasDescansoReales(int rolDiasDescansoReales) {
        this.rolDiasDescansoReales = rolDiasDescansoReales;
    }

    public int getRolDiasExtrasReales() {
        return rolDiasExtrasReales;
    }

    public void setRolDiasExtrasReales(int rolDiasExtrasReales) {
        this.rolDiasExtrasReales = rolDiasExtrasReales;
    }

    public int getRolDiasFaltasReales() {
        return rolDiasFaltasReales;
    }

    public void setRolDiasFaltasReales(int rolDiasFaltasReales) {
        this.rolDiasFaltasReales = rolDiasFaltasReales;
    }

    public int getRolDiasLaboradosReales() {
        return rolDiasLaboradosReales;
    }

    public void setRolDiasLaboradosReales(int rolDiasLaboradosReales) {
        this.rolDiasLaboradosReales = rolDiasLaboradosReales;
    }

    public int getRolDiasPagadosReales() {
        return rolDiasPagadosReales;
    }

    public void setRolDiasPagadosReales(int rolDiasPagadosReales) {
        this.rolDiasPagadosReales = rolDiasPagadosReales;
    }

    public int getRolDiasPermisoMedico() {
        return rolDiasPermisoMedico;
    }

    public void setRolDiasPermisoMedico(int rolDiasPermisoMedico) {
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

    public boolean isRolReversado() {
        return rolReversado;
    }

    public void setRolReversado(boolean rolReversado) {
        this.rolReversado = rolReversado;
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

    public RhRolesLoteValoresTO getRhRolesLoteValoresTO() {
        return rhRolesLoteValoresTO;
    }

    public void setRhRolesLoteValoresTO(RhRolesLoteValoresTO rhRolesLoteValoresTO) {
        this.rhRolesLoteValoresTO = rhRolesLoteValoresTO;
    }
}
