/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "rh_rol", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhRol.findAll", query = "SELECT r FROM RhRol r"),
    @NamedQuery(name = "RhRol.findByRolSecuencial", query = "SELECT r FROM RhRol r WHERE r.rolSecuencial = :rolSecuencial"),
    @NamedQuery(name = "RhRol.findByRolDesde", query = "SELECT r FROM RhRol r WHERE r.rolDesde = :rolDesde"),
    @NamedQuery(name = "RhRol.findByRolHasta", query = "SELECT r FROM RhRol r WHERE r.rolHasta = :rolHasta"),
    @NamedQuery(name = "RhRol.findByRolFechaUltimoSueldo", query = "SELECT r FROM RhRol r WHERE r.rolFechaUltimoSueldo = :rolFechaUltimoSueldo"),
    @NamedQuery(name = "RhRol.findByRolDiasLaboradosReales", query = "SELECT r FROM RhRol r WHERE r.rolDiasLaboradosReales = :rolDiasLaboradosReales"),
    @NamedQuery(name = "RhRol.findByRolDiasFaltasReales", query = "SELECT r FROM RhRol r WHERE r.rolDiasFaltasReales = :rolDiasFaltasReales"),
    @NamedQuery(name = "RhRol.findByRolDiasExtrasReales", query = "SELECT r FROM RhRol r WHERE r.rolDiasExtrasReales = :rolDiasExtrasReales"),
    @NamedQuery(name = "RhRol.findByRolDiasDescansoReales", query = "SELECT r FROM RhRol r WHERE r.rolDiasDescansoReales = :rolDiasDescansoReales"),
    @NamedQuery(name = "RhRol.findByRolDiasPagadosReales", query = "SELECT r FROM RhRol r WHERE r.rolDiasPagadosReales = :rolDiasPagadosReales"),
    @NamedQuery(name = "RhRol.findByRolDiasPermisoMedico", query = "SELECT r FROM RhRol r WHERE r.rolDiasPermisoMedico = :rolDiasPermisoMedico"),
    @NamedQuery(name = "RhRol.findByRolSaldoAnterior", query = "SELECT r FROM RhRol r WHERE r.rolSaldoAnterior = :rolSaldoAnterior"),
    @NamedQuery(name = "RhRol.findByRolIngresos", query = "SELECT r FROM RhRol r WHERE r.rolIngresos = :rolIngresos"),
    @NamedQuery(name = "RhRol.findByRolBonos", query = "SELECT r FROM RhRol r WHERE r.rolBonos = :rolBonos"),
    @NamedQuery(name = "RhRol.findByRolBonosnd", query = "SELECT r FROM RhRol r WHERE r.rolBonosnd = :rolBonosnd"),
    @NamedQuery(name = "RhRol.findByRolBonoFijo", query = "SELECT r FROM RhRol r WHERE r.rolBonoFijo = :rolBonoFijo"),
    @NamedQuery(name = "RhRol.findByRolBonoFijoNd", query = "SELECT r FROM RhRol r WHERE r.rolBonoFijoNd = :rolBonoFijoNd"),
    @NamedQuery(name = "RhRol.findByRolOtrosIngresos", query = "SELECT r FROM RhRol r WHERE r.rolOtrosIngresos = :rolOtrosIngresos"),
    @NamedQuery(name = "RhRol.findByRolOtrosIngresosNd", query = "SELECT r FROM RhRol r WHERE r.rolOtrosIngresosNd = :rolOtrosIngresosNd"),
    @NamedQuery(name = "RhRol.findByRolViaticos", query = "SELECT r FROM RhRol r WHERE r.rolViaticos = :rolViaticos"),
    @NamedQuery(name = "RhRol.findByRolLiqFondoReserva", query = "SELECT r FROM RhRol r WHERE r.rolLiqFondoReserva = :rolLiqFondoReserva"),
    @NamedQuery(name = "RhRol.findByRolLiqXiii", query = "SELECT r FROM RhRol r WHERE r.rolLiqXiii = :rolLiqXiii"),
    @NamedQuery(name = "RhRol.findByRolLiqXiv", query = "SELECT r FROM RhRol r WHERE r.rolLiqXiv = :rolLiqXiv"),
    @NamedQuery(name = "RhRol.findByRolLiqVacaciones", query = "SELECT r FROM RhRol r WHERE r.rolLiqVacaciones = :rolLiqVacaciones"),
    @NamedQuery(name = "RhRol.findByRolLiqSalarioDigno", query = "SELECT r FROM RhRol r WHERE r.rolLiqSalarioDigno = :rolLiqSalarioDigno"),
    @NamedQuery(name = "RhRol.findByRolLiqDesahucio", query = "SELECT r FROM RhRol r WHERE r.rolLiqDesahucio = :rolLiqDesahucio"),
    @NamedQuery(name = "RhRol.findByRolLiqDesahucioIntempestivo", query = "SELECT r FROM RhRol r WHERE r.rolLiqDesahucioIntempestivo = :rolLiqDesahucioIntempestivo"),
    @NamedQuery(name = "RhRol.findByRolLiqBonificacion", query = "SELECT r FROM RhRol r WHERE r.rolLiqBonificacion = :rolLiqBonificacion"),
    @NamedQuery(name = "RhRol.findByRolAnticipos", query = "SELECT r FROM RhRol r WHERE r.rolAnticipos = :rolAnticipos"),
    @NamedQuery(name = "RhRol.findByRolPrestamos", query = "SELECT r FROM RhRol r WHERE r.rolPrestamos = :rolPrestamos"),
    @NamedQuery(name = "RhRol.findByRolIess", query = "SELECT r FROM RhRol r WHERE r.rolIess = :rolIess"),
    @NamedQuery(name = "RhRol.findByRolRetencionFuente", query = "SELECT r FROM RhRol r WHERE r.rolRetencionFuente = :rolRetencionFuente"),
    @NamedQuery(name = "RhRol.findByRolDescuentoPermisoMedico", query = "SELECT r FROM RhRol r WHERE r.rolDescuentoPermisoMedico = :rolDescuentoPermisoMedico"),
    @NamedQuery(name = "RhRol.findByRolTotal", query = "SELECT r FROM RhRol r WHERE r.rolTotal = :rolTotal"),
    @NamedQuery(name = "RhRol.findByRolFormaPago", query = "SELECT r FROM RhRol r WHERE r.rolFormaPago = :rolFormaPago"),
    @NamedQuery(name = "RhRol.findByRolAportePatronal", query = "SELECT r FROM RhRol r WHERE r.rolAportePatronal = :rolAportePatronal"),
    @NamedQuery(name = "RhRol.findByRolIece", query = "SELECT r FROM RhRol r WHERE r.rolIece = :rolIece"),
    @NamedQuery(name = "RhRol.findByRolSecap", query = "SELECT r FROM RhRol r WHERE r.rolSecap = :rolSecap"),
    @NamedQuery(name = "RhRol.findByRolXiii", query = "SELECT r FROM RhRol r WHERE r.rolXiii = :rolXiii"),
    @NamedQuery(name = "RhRol.findByRolXiv", query = "SELECT r FROM RhRol r WHERE r.rolXiv = :rolXiv"),
    @NamedQuery(name = "RhRol.findByRolFondoReserva", query = "SELECT r FROM RhRol r WHERE r.rolFondoReserva = :rolFondoReserva"),
    @NamedQuery(name = "RhRol.findByRolVacaciones", query = "SELECT r FROM RhRol r WHERE r.rolVacaciones = :rolVacaciones"),
    @NamedQuery(name = "RhRol.findByRolDesahucio", query = "SELECT r FROM RhRol r WHERE r.rolDesahucio = :rolDesahucio"),
    @NamedQuery(name = "RhRol.findByRolReversado", query = "SELECT r FROM RhRol r WHERE r.rolReversado = :rolReversado"),
    @NamedQuery(name = "RhRol.findByEmpCargo", query = "SELECT r FROM RhRol r WHERE r.empCargo = :empCargo"),
    @NamedQuery(name = "RhRol.findByEmpSueldo", query = "SELECT r FROM RhRol r WHERE r.empSueldo = :empSueldo"),
    @NamedQuery(name = "RhRol.findByEmpBonoFijo", query = "SELECT r FROM RhRol r WHERE r.empBonoFijo = :empBonoFijo"),
    @NamedQuery(name = "RhRol.findByEmpBonoFijoNd", query = "SELECT r FROM RhRol r WHERE r.empBonoFijoNd = :empBonoFijoNd"),
    @NamedQuery(name = "RhRol.findByEmpOtrosIngresos", query = "SELECT r FROM RhRol r WHERE r.empOtrosIngresos = :empOtrosIngresos"),
    @NamedQuery(name = "RhRol.findByEmpOtrosIngresosNd", query = "SELECT r FROM RhRol r WHERE r.empOtrosIngresosNd = :empOtrosIngresosNd"),
    @NamedQuery(name = "RhRol.findByEmpDiasLaborados", query = "SELECT r FROM RhRol r WHERE r.empDiasLaborados = :empDiasLaborados"),
    @NamedQuery(name = "RhRol.findByEmpDiasDescanso", query = "SELECT r FROM RhRol r WHERE r.empDiasDescanso = :empDiasDescanso"),
    @NamedQuery(name = "RhRol.findByEmpCancelarXiiiSueldoMensualmente", query = "SELECT r FROM RhRol r WHERE r.empCancelarXiiiSueldoMensualmente = :empCancelarXiiiSueldoMensualmente"),
    @NamedQuery(name = "RhRol.findByEmpCancelarXivSueldoMensualmente", query = "SELECT r FROM RhRol r WHERE r.empCancelarXivSueldoMensualmente = :empCancelarXivSueldoMensualmente"),
    @NamedQuery(name = "RhRol.findByEmpCancelarFondoReservaMensualmente", query = "SELECT r FROM RhRol r WHERE r.empCancelarFondoReservaMensualmente = :empCancelarFondoReservaMensualmente"),
    @NamedQuery(name = "RhRol.findByEmpSalarioNeto", query = "SELECT r FROM RhRol r WHERE r.empSalarioNeto = :empSalarioNeto"),
    @NamedQuery(name = "RhRol.findBySecEmpresa", query = "SELECT r FROM RhRol r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhRol.findBySecCodigo", query = "SELECT r FROM RhRol r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhRol.findByConEmpresa", query = "SELECT r FROM RhRol r WHERE r.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "RhRol.findByConPeriodo", query = "SELECT r FROM RhRol r WHERE r.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "RhRol.findByConTipo", query = "SELECT r FROM RhRol r WHERE r.conTipo = :conTipo"),
    @NamedQuery(name = "RhRol.findByConNumero", query = "SELECT r FROM RhRol r WHERE r.conNumero = :conNumero"),
    @NamedQuery(name = "RhRol.findByConProvisionEmpresa", query = "SELECT r FROM RhRol r WHERE r.conProvisionEmpresa = :conProvisionEmpresa"),
    @NamedQuery(name = "RhRol.findByConProvisionPeriodo", query = "SELECT r FROM RhRol r WHERE r.conProvisionPeriodo = :conProvisionPeriodo"),
    @NamedQuery(name = "RhRol.findByConProvisionTipo", query = "SELECT r FROM RhRol r WHERE r.conProvisionTipo = :conProvisionTipo"),
    @NamedQuery(name = "RhRol.findByConProvisionNumero", query = "SELECT r FROM RhRol r WHERE r.conProvisionNumero = :conProvisionNumero")})
public class RhRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_secuencial")
    private Integer rolSecuencial;
    @Basic(optional = false)
    @Column(name = "rol_desde")
    @Temporal(TemporalType.DATE)
    private Date rolDesde;
    @Basic(optional = false)
    @Column(name = "rol_hasta")
    @Temporal(TemporalType.DATE)
    private Date rolHasta;
    @Column(name = "rol_fecha_ultimo_sueldo")
    @Temporal(TemporalType.DATE)
    private Date rolFechaUltimoSueldo;
    @Basic(optional = false)
    @Column(name = "rol_dias_laborados_reales")
    private short rolDiasLaboradosReales;
    @Basic(optional = false)
    @Column(name = "rol_dias_faltas_reales")
    private short rolDiasFaltasReales;
    @Basic(optional = false)
    @Column(name = "rol_dias_extras_reales")
    private short rolDiasExtrasReales;
    @Basic(optional = false)
    @Column(name = "rol_dias_descanso_reales")
    private short rolDiasDescansoReales;
    @Basic(optional = false)
    @Column(name = "rol_dias_pagados_reales")
    private short rolDiasPagadosReales;
    @Basic(optional = false)
    @Column(name = "rol_dias_permiso_medico")
    private short rolDiasPermisoMedico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "rol_saldo_anterior")
    private BigDecimal rolSaldoAnterior;
    @Basic(optional = false)
    @Column(name = "rol_ingresos")
    private BigDecimal rolIngresos;
    @Basic(optional = false)
    @Column(name = "rol_bonos")
    private BigDecimal rolBonos;
    @Basic(optional = false)
    @Column(name = "rol_bonosnd")
    private BigDecimal rolBonosnd;
    @Basic(optional = false)
    @Column(name = "rol_bono_fijo")
    private BigDecimal rolBonoFijo;
    @Basic(optional = false)
    @Column(name = "rol_bono_fijo_nd")
    private BigDecimal rolBonoFijoNd;
    @Basic(optional = false)
    @Column(name = "rol_otros_ingresos")
    private BigDecimal rolOtrosIngresos;
    @Basic(optional = false)
    @Column(name = "rol_otros_ingresos_nd")
    private BigDecimal rolOtrosIngresosNd;
    @Basic(optional = false)
    @Column(name = "rol_viaticos")
    private BigDecimal rolViaticos;
    @Basic(optional = false)
    @Column(name = "rol_liq_fondo_reserva")
    private BigDecimal rolLiqFondoReserva;
    @Basic(optional = false)
    @Column(name = "rol_liq_xiii")
    private BigDecimal rolLiqXiii;
    @Basic(optional = false)
    @Column(name = "rol_liq_xiv")
    private BigDecimal rolLiqXiv;
    @Basic(optional = false)
    @Column(name = "rol_liq_vacaciones")
    private BigDecimal rolLiqVacaciones;
    @Basic(optional = false)
    @Column(name = "rol_liq_salario_digno")
    private BigDecimal rolLiqSalarioDigno;
    @Basic(optional = false)
    @Column(name = "rol_liq_desahucio")
    private BigDecimal rolLiqDesahucio;
    @Basic(optional = false)
    @Column(name = "rol_liq_desahucio_intempestivo")
    private BigDecimal rolLiqDesahucioIntempestivo;
    @Basic(optional = false)
    @Column(name = "rol_liq_bonificacion")
    private BigDecimal rolLiqBonificacion;
    @Basic(optional = false)
    @Column(name = "rol_anticipos")
    private BigDecimal rolAnticipos;
    @Basic(optional = false)
    @Column(name = "rol_prestamos")
    private BigDecimal rolPrestamos;
    @Basic(optional = false)
    @Column(name = "rol_iess")
    private BigDecimal rolIess;
    @Basic(optional = false)
    @Column(name = "rol_retencion_fuente")
    private BigDecimal rolRetencionFuente;
    @Basic(optional = false)
    @Column(name = "rol_descuento_permiso_medico")
    private BigDecimal rolDescuentoPermisoMedico;
    @Basic(optional = false)
    @Column(name = "rol_total")
    private BigDecimal rolTotal;
    @Basic(optional = false)
    @Column(name = "rol_forma_pago")
    private String rolFormaPago;
    @Basic(optional = false)
    @Column(name = "rol_aporte_patronal")
    private BigDecimal rolAportePatronal;
    @Basic(optional = false)
    @Column(name = "rol_iece")
    private BigDecimal rolIece;
    @Basic(optional = false)
    @Column(name = "rol_secap")
    private BigDecimal rolSecap;
    @Basic(optional = false)
    @Column(name = "rol_xiii")
    private BigDecimal rolXiii;
    @Basic(optional = false)
    @Column(name = "rol_xiv")
    private BigDecimal rolXiv;
    @Basic(optional = false)
    @Column(name = "rol_fondo_reserva")
    private BigDecimal rolFondoReserva;
    @Basic(optional = false)
    @Column(name = "rol_vacaciones")
    private BigDecimal rolVacaciones;
    @Basic(optional = false)
    @Column(name = "rol_desahucio")
    private BigDecimal rolDesahucio;
    @Basic(optional = false)
    @Column(name = "rol_reversado")
    private boolean rolReversado;
    @Basic(optional = false)
    @Column(name = "emp_cargo")
    private String empCargo;
    @Basic(optional = false)
    @Column(name = "emp_sueldo")
    private BigDecimal empSueldo;
    @Basic(optional = false)
    @Column(name = "emp_bono_fijo")
    private BigDecimal empBonoFijo;
    @Basic(optional = false)
    @Column(name = "emp_bono_fijo_nd")
    private BigDecimal empBonoFijoNd;
    @Basic(optional = false)
    @Column(name = "emp_otros_ingresos")
    private BigDecimal empOtrosIngresos;
    @Basic(optional = false)
    @Column(name = "emp_otros_ingresos_nd")
    private BigDecimal empOtrosIngresosNd;
    @Basic(optional = false)
    @Column(name = "emp_dias_laborados")
    private short empDiasLaborados;
    @Basic(optional = false)
    @Column(name = "emp_dias_descanso")
    private short empDiasDescanso;
    @Basic(optional = false)
    @Column(name = "emp_cancelar_xiii_sueldo_mensualmente")
    private boolean empCancelarXiiiSueldoMensualmente;
    @Basic(optional = false)
    @Column(name = "emp_cancelar_xiv_sueldo_mensualmente")
    private boolean empCancelarXivSueldoMensualmente;
    @Basic(optional = false)
    @Column(name = "emp_cancelar_fondo_reserva_mensualmente")
    private boolean empCancelarFondoReservaMensualmente;
    @Basic(optional = false)
    @Column(name = "emp_salario_neto")
    private boolean empSalarioNeto;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
    @Basic(optional = false)
    @Column(name = "con_empresa")
    private String conEmpresa;
    @Basic(optional = false)
    @Column(name = "con_periodo")
    private String conPeriodo;
    @Basic(optional = false)
    @Column(name = "con_tipo")
    private String conTipo;
    @Basic(optional = false)
    @Column(name = "con_numero")
    private String conNumero;
    @Column(name = "con_provision_empresa")
    private String conProvisionEmpresa;
    @Column(name = "con_provision_periodo")
    private String conProvisionPeriodo;
    @Column(name = "con_provision_tipo")
    private String conProvisionTipo;
    @Column(name = "con_provision_numero")
    private String conProvisionNumero;
    @JoinColumns({
        @JoinColumn(name = "emp_empresa", referencedColumnName = "emp_empresa"),
        @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")})
    @ManyToOne(optional = false)
    private RhEmpleado rhEmpleado;

    public RhRol() {
    }

    public RhRol(Integer rolSecuencial) {
        this.rolSecuencial = rolSecuencial;
    }

    public RhRol(Integer rolSecuencial, Date rolDesde, Date rolHasta, short rolDiasLaboradosReales, short rolDiasFaltasReales, short rolDiasExtrasReales, short rolDiasDescansoReales, short rolDiasPagadosReales, short rolDiasPermisoMedico, BigDecimal rolSaldoAnterior, BigDecimal rolIngresos, BigDecimal rolBonos, BigDecimal rolBonosnd, BigDecimal rolBonoFijo, BigDecimal rolBonoFijoNd, BigDecimal rolOtrosIngresos, BigDecimal rolOtrosIngresosNd, BigDecimal rolViaticos, BigDecimal rolLiqFondoReserva, BigDecimal rolLiqXiii, BigDecimal rolLiqXiv, BigDecimal rolLiqVacaciones, BigDecimal rolLiqSalarioDigno, BigDecimal rolLiqDesahucio, BigDecimal rolLiqDesahucioIntempestivo, BigDecimal rolLiqBonificacion, BigDecimal rolAnticipos, BigDecimal rolPrestamos, BigDecimal rolIess, BigDecimal rolRetencionFuente, BigDecimal rolDescuentoPermisoMedico, BigDecimal rolTotal, String rolFormaPago, BigDecimal rolAportePatronal, BigDecimal rolIece, BigDecimal rolSecap, BigDecimal rolXiii, BigDecimal rolXiv, BigDecimal rolFondoReserva, BigDecimal rolVacaciones, BigDecimal rolDesahucio, boolean rolReversado, String empCargo, BigDecimal empSueldo, BigDecimal empBonoFijo, BigDecimal empBonoFijoNd, BigDecimal empOtrosIngresos, BigDecimal empOtrosIngresosNd, short empDiasLaborados, short empDiasDescanso, boolean empCancelarXiiiSueldoMensualmente, boolean empCancelarXivSueldoMensualmente, boolean empCancelarFondoReservaMensualmente, boolean empSalarioNeto, String secEmpresa, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.rolSecuencial = rolSecuencial;
        this.rolDesde = rolDesde;
        this.rolHasta = rolHasta;
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
        this.rolLiqBonificacion = rolLiqBonificacion;
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
        this.rolReversado = rolReversado;
        this.empCargo = empCargo;
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
        this.empSalarioNeto = empSalarioNeto;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
    }

    public Integer getRolSecuencial() {
        return rolSecuencial;
    }

    public void setRolSecuencial(Integer rolSecuencial) {
        this.rolSecuencial = rolSecuencial;
    }

    public Date getRolDesde() {
        return rolDesde;
    }

    public void setRolDesde(Date rolDesde) {
        this.rolDesde = rolDesde;
    }

    public Date getRolHasta() {
        return rolHasta;
    }

    public void setRolHasta(Date rolHasta) {
        this.rolHasta = rolHasta;
    }

    public Date getRolFechaUltimoSueldo() {
        return rolFechaUltimoSueldo;
    }

    public void setRolFechaUltimoSueldo(Date rolFechaUltimoSueldo) {
        this.rolFechaUltimoSueldo = rolFechaUltimoSueldo;
    }

    public short getRolDiasLaboradosReales() {
        return rolDiasLaboradosReales;
    }

    public void setRolDiasLaboradosReales(short rolDiasLaboradosReales) {
        this.rolDiasLaboradosReales = rolDiasLaboradosReales;
    }

    public short getRolDiasFaltasReales() {
        return rolDiasFaltasReales;
    }

    public void setRolDiasFaltasReales(short rolDiasFaltasReales) {
        this.rolDiasFaltasReales = rolDiasFaltasReales;
    }

    public short getRolDiasExtrasReales() {
        return rolDiasExtrasReales;
    }

    public void setRolDiasExtrasReales(short rolDiasExtrasReales) {
        this.rolDiasExtrasReales = rolDiasExtrasReales;
    }

    public short getRolDiasDescansoReales() {
        return rolDiasDescansoReales;
    }

    public void setRolDiasDescansoReales(short rolDiasDescansoReales) {
        this.rolDiasDescansoReales = rolDiasDescansoReales;
    }

    public short getRolDiasPagadosReales() {
        return rolDiasPagadosReales;
    }

    public void setRolDiasPagadosReales(short rolDiasPagadosReales) {
        this.rolDiasPagadosReales = rolDiasPagadosReales;
    }

    public short getRolDiasPermisoMedico() {
        return rolDiasPermisoMedico;
    }

    public void setRolDiasPermisoMedico(short rolDiasPermisoMedico) {
        this.rolDiasPermisoMedico = rolDiasPermisoMedico;
    }

    public BigDecimal getRolSaldoAnterior() {
        return rolSaldoAnterior;
    }

    public void setRolSaldoAnterior(BigDecimal rolSaldoAnterior) {
        this.rolSaldoAnterior = rolSaldoAnterior;
    }

    public BigDecimal getRolIngresos() {
        return rolIngresos;
    }

    public void setRolIngresos(BigDecimal rolIngresos) {
        this.rolIngresos = rolIngresos;
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

    public BigDecimal getRolViaticos() {
        return rolViaticos;
    }

    public void setRolViaticos(BigDecimal rolViaticos) {
        this.rolViaticos = rolViaticos;
    }

    public BigDecimal getRolLiqFondoReserva() {
        return rolLiqFondoReserva;
    }

    public void setRolLiqFondoReserva(BigDecimal rolLiqFondoReserva) {
        this.rolLiqFondoReserva = rolLiqFondoReserva;
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

    public BigDecimal getRolLiqVacaciones() {
        return rolLiqVacaciones;
    }

    public void setRolLiqVacaciones(BigDecimal rolLiqVacaciones) {
        this.rolLiqVacaciones = rolLiqVacaciones;
    }

    public BigDecimal getRolLiqSalarioDigno() {
        return rolLiqSalarioDigno;
    }

    public void setRolLiqSalarioDigno(BigDecimal rolLiqSalarioDigno) {
        this.rolLiqSalarioDigno = rolLiqSalarioDigno;
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

    public BigDecimal getRolLiqBonificacion() {
        return rolLiqBonificacion;
    }

    public void setRolLiqBonificacion(BigDecimal rolLiqBonificacion) {
        this.rolLiqBonificacion = rolLiqBonificacion;
    }

    public BigDecimal getRolAnticipos() {
        return rolAnticipos;
    }

    public void setRolAnticipos(BigDecimal rolAnticipos) {
        this.rolAnticipos = rolAnticipos;
    }

    public BigDecimal getRolPrestamos() {
        return rolPrestamos;
    }

    public void setRolPrestamos(BigDecimal rolPrestamos) {
        this.rolPrestamos = rolPrestamos;
    }

    public BigDecimal getRolIess() {
        return rolIess;
    }

    public void setRolIess(BigDecimal rolIess) {
        this.rolIess = rolIess;
    }

    public BigDecimal getRolRetencionFuente() {
        return rolRetencionFuente;
    }

    public void setRolRetencionFuente(BigDecimal rolRetencionFuente) {
        this.rolRetencionFuente = rolRetencionFuente;
    }

    public BigDecimal getRolDescuentoPermisoMedico() {
        return rolDescuentoPermisoMedico;
    }

    public void setRolDescuentoPermisoMedico(BigDecimal rolDescuentoPermisoMedico) {
        this.rolDescuentoPermisoMedico = rolDescuentoPermisoMedico;
    }

    public BigDecimal getRolTotal() {
        return rolTotal;
    }

    public void setRolTotal(BigDecimal rolTotal) {
        this.rolTotal = rolTotal;
    }

    public String getRolFormaPago() {
        return rolFormaPago;
    }

    public void setRolFormaPago(String rolFormaPago) {
        this.rolFormaPago = rolFormaPago;
    }

    public BigDecimal getRolAportePatronal() {
        return rolAportePatronal;
    }

    public void setRolAportePatronal(BigDecimal rolAportePatronal) {
        this.rolAportePatronal = rolAportePatronal;
    }

    public BigDecimal getRolIece() {
        return rolIece;
    }

    public void setRolIece(BigDecimal rolIece) {
        this.rolIece = rolIece;
    }

    public BigDecimal getRolSecap() {
        return rolSecap;
    }

    public void setRolSecap(BigDecimal rolSecap) {
        this.rolSecap = rolSecap;
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

    public BigDecimal getRolFondoReserva() {
        return rolFondoReserva;
    }

    public void setRolFondoReserva(BigDecimal rolFondoReserva) {
        this.rolFondoReserva = rolFondoReserva;
    }

    public BigDecimal getRolVacaciones() {
        return rolVacaciones;
    }

    public void setRolVacaciones(BigDecimal rolVacaciones) {
        this.rolVacaciones = rolVacaciones;
    }

    public BigDecimal getRolDesahucio() {
        return rolDesahucio;
    }

    public void setRolDesahucio(BigDecimal rolDesahucio) {
        this.rolDesahucio = rolDesahucio;
    }

    public boolean getRolReversado() {
        return rolReversado;
    }

    public void setRolReversado(boolean rolReversado) {
        this.rolReversado = rolReversado;
    }

    public String getEmpCargo() {
        return empCargo;
    }

    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }

    public BigDecimal getEmpSueldo() {
        return empSueldo;
    }

    public void setEmpSueldo(BigDecimal empSueldo) {
        this.empSueldo = empSueldo;
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

    public short getEmpDiasLaborados() {
        return empDiasLaborados;
    }

    public void setEmpDiasLaborados(short empDiasLaborados) {
        this.empDiasLaborados = empDiasLaborados;
    }

    public short getEmpDiasDescanso() {
        return empDiasDescanso;
    }

    public void setEmpDiasDescanso(short empDiasDescanso) {
        this.empDiasDescanso = empDiasDescanso;
    }

    public boolean getEmpCancelarXiiiSueldoMensualmente() {
        return empCancelarXiiiSueldoMensualmente;
    }

    public void setEmpCancelarXiiiSueldoMensualmente(boolean empCancelarXiiiSueldoMensualmente) {
        this.empCancelarXiiiSueldoMensualmente = empCancelarXiiiSueldoMensualmente;
    }

    public boolean getEmpCancelarXivSueldoMensualmente() {
        return empCancelarXivSueldoMensualmente;
    }

    public void setEmpCancelarXivSueldoMensualmente(boolean empCancelarXivSueldoMensualmente) {
        this.empCancelarXivSueldoMensualmente = empCancelarXivSueldoMensualmente;
    }

    public boolean getEmpCancelarFondoReservaMensualmente() {
        return empCancelarFondoReservaMensualmente;
    }

    public void setEmpCancelarFondoReservaMensualmente(boolean empCancelarFondoReservaMensualmente) {
        this.empCancelarFondoReservaMensualmente = empCancelarFondoReservaMensualmente;
    }

    public boolean getEmpSalarioNeto() {
        return empSalarioNeto;
    }

    public void setEmpSalarioNeto(boolean empSalarioNeto) {
        this.empSalarioNeto = empSalarioNeto;
    }

    public String getSecEmpresa() {
        return secEmpresa;
    }

    public void setSecEmpresa(String secEmpresa) {
        this.secEmpresa = secEmpresa;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getConEmpresa() {
        return conEmpresa;
    }

    public void setConEmpresa(String conEmpresa) {
        this.conEmpresa = conEmpresa;
    }

    public String getConPeriodo() {
        return conPeriodo;
    }

    public void setConPeriodo(String conPeriodo) {
        this.conPeriodo = conPeriodo;
    }

    public String getConTipo() {
        return conTipo;
    }

    public void setConTipo(String conTipo) {
        this.conTipo = conTipo;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConProvisionEmpresa() {
        return conProvisionEmpresa;
    }

    public void setConProvisionEmpresa(String conProvisionEmpresa) {
        this.conProvisionEmpresa = conProvisionEmpresa;
    }

    public String getConProvisionPeriodo() {
        return conProvisionPeriodo;
    }

    public void setConProvisionPeriodo(String conProvisionPeriodo) {
        this.conProvisionPeriodo = conProvisionPeriodo;
    }

    public String getConProvisionTipo() {
        return conProvisionTipo;
    }

    public void setConProvisionTipo(String conProvisionTipo) {
        this.conProvisionTipo = conProvisionTipo;
    }

    public String getConProvisionNumero() {
        return conProvisionNumero;
    }

    public void setConProvisionNumero(String conProvisionNumero) {
        this.conProvisionNumero = conProvisionNumero;
    }

    public RhEmpleado getRhEmpleado() {
        return rhEmpleado;
    }

    public void setRhEmpleado(RhEmpleado rhEmpleado) {
        this.rhEmpleado = rhEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolSecuencial != null ? rolSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhRol)) {
            return false;
        }
        RhRol other = (RhRol) object;
        if ((this.rolSecuencial == null && other.rolSecuencial != null) || (this.rolSecuencial != null && !this.rolSecuencial.equals(other.rolSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhRol[ rolSecuencial=" + rolSecuencial + " ]";
    }
}
