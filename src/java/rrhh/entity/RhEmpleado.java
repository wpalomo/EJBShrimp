/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "rh_empleado", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhEmpleado.findAll", query = "SELECT r FROM RhEmpleado r"),
    @NamedQuery(name = "RhEmpleado.findByEmpEmpresa", query = "SELECT r FROM RhEmpleado r WHERE r.rhEmpleadoPK.empEmpresa = :empEmpresa"),
    @NamedQuery(name = "RhEmpleado.findByEmpId", query = "SELECT r FROM RhEmpleado r WHERE r.rhEmpleadoPK.empId = :empId"),
    @NamedQuery(name = "RhEmpleado.findByEmpTipoId", query = "SELECT r FROM RhEmpleado r WHERE r.empTipoId = :empTipoId"),
    @NamedQuery(name = "RhEmpleado.findByEmpResidenciaTipo", query = "SELECT r FROM RhEmpleado r WHERE r.empResidenciaTipo = :empResidenciaTipo"),
    @NamedQuery(name = "RhEmpleado.findByEmpResidenciaPais", query = "SELECT r FROM RhEmpleado r WHERE r.empResidenciaPais = :empResidenciaPais"),
    @NamedQuery(name = "RhEmpleado.findByEmpConvenio", query = "SELECT r FROM RhEmpleado r WHERE r.empConvenio = :empConvenio"),
    @NamedQuery(name = "RhEmpleado.findByEmpApellidos", query = "SELECT r FROM RhEmpleado r WHERE r.empApellidos = :empApellidos"),
    @NamedQuery(name = "RhEmpleado.findByEmpNombres", query = "SELECT r FROM RhEmpleado r WHERE r.empNombres = :empNombres"),
    @NamedQuery(name = "RhEmpleado.findByEmpGenero", query = "SELECT r FROM RhEmpleado r WHERE r.empGenero = :empGenero"),
    @NamedQuery(name = "RhEmpleado.findByEmpFechaNacimiento", query = "SELECT r FROM RhEmpleado r WHERE r.empFechaNacimiento = :empFechaNacimiento"),
    @NamedQuery(name = "RhEmpleado.findByEmpEstadoCivil", query = "SELECT r FROM RhEmpleado r WHERE r.empEstadoCivil = :empEstadoCivil"),
    @NamedQuery(name = "RhEmpleado.findByEmpCargasFamiliares", query = "SELECT r FROM RhEmpleado r WHERE r.empCargasFamiliares = :empCargasFamiliares"),
    @NamedQuery(name = "RhEmpleado.findByEmpProvincia", query = "SELECT r FROM RhEmpleado r WHERE r.empProvincia = :empProvincia"),
    @NamedQuery(name = "RhEmpleado.findByEmpCanton", query = "SELECT r FROM RhEmpleado r WHERE r.empCanton = :empCanton"),
    @NamedQuery(name = "RhEmpleado.findByEmpLugarNacimiento", query = "SELECT r FROM RhEmpleado r WHERE r.empLugarNacimiento = :empLugarNacimiento"),
    @NamedQuery(name = "RhEmpleado.findByEmpDomicilio", query = "SELECT r FROM RhEmpleado r WHERE r.empDomicilio = :empDomicilio"),
    @NamedQuery(name = "RhEmpleado.findByEmpNumero", query = "SELECT r FROM RhEmpleado r WHERE r.empNumero = :empNumero"),
    @NamedQuery(name = "RhEmpleado.findByEmpTelefono", query = "SELECT r FROM RhEmpleado r WHERE r.empTelefono = :empTelefono"),
    @NamedQuery(name = "RhEmpleado.findByEmpCorreoElectronico", query = "SELECT r FROM RhEmpleado r WHERE r.empCorreoElectronico = :empCorreoElectronico"),
    @NamedQuery(name = "RhEmpleado.findByEmpFechaPrimerIngreso", query = "SELECT r FROM RhEmpleado r WHERE r.empFechaPrimerIngreso = :empFechaPrimerIngreso"),
    @NamedQuery(name = "RhEmpleado.findByEmpFechaPrimeraSalida", query = "SELECT r FROM RhEmpleado r WHERE r.empFechaPrimeraSalida = :empFechaPrimeraSalida"),
    @NamedQuery(name = "RhEmpleado.findByEmpFechaUltimoIngreso", query = "SELECT r FROM RhEmpleado r WHERE r.empFechaUltimoIngreso = :empFechaUltimoIngreso"),
    @NamedQuery(name = "RhEmpleado.findByEmpFechaUltimaSalida", query = "SELECT r FROM RhEmpleado r WHERE r.empFechaUltimaSalida = :empFechaUltimaSalida"),
    @NamedQuery(name = "RhEmpleado.findByEmpMotivoSalida", query = "SELECT r FROM RhEmpleado r WHERE r.empMotivoSalida = :empMotivoSalida"),
    @NamedQuery(name = "RhEmpleado.findByEmpFechaAfiliacionIess", query = "SELECT r FROM RhEmpleado r WHERE r.empFechaAfiliacionIess = :empFechaAfiliacionIess"),
    @NamedQuery(name = "RhEmpleado.findByEmpCodigoAfiliacionIess", query = "SELECT r FROM RhEmpleado r WHERE r.empCodigoAfiliacionIess = :empCodigoAfiliacionIess"),
    @NamedQuery(name = "RhEmpleado.findByEmpCodigoCargo", query = "SELECT r FROM RhEmpleado r WHERE r.empCodigoCargo = :empCodigoCargo"),
    @NamedQuery(name = "RhEmpleado.findByEmpCargo", query = "SELECT r FROM RhEmpleado r WHERE r.empCargo = :empCargo"),
    @NamedQuery(name = "RhEmpleado.findByEmpSueldoIess", query = "SELECT r FROM RhEmpleado r WHERE r.empSueldoIess = :empSueldoIess"),
    @NamedQuery(name = "RhEmpleado.findByEmpFormaPago", query = "SELECT r FROM RhEmpleado r WHERE r.empFormaPago = :empFormaPago"),
    @NamedQuery(name = "RhEmpleado.findByEmpDiasTrabajados", query = "SELECT r FROM RhEmpleado r WHERE r.empDiasTrabajados = :empDiasTrabajados"),
    @NamedQuery(name = "RhEmpleado.findByEmpDiasDescanso", query = "SELECT r FROM RhEmpleado r WHERE r.empDiasDescanso = :empDiasDescanso"),
    @NamedQuery(name = "RhEmpleado.findByEmpBonoFijo", query = "SELECT r FROM RhEmpleado r WHERE r.empBonoFijo = :empBonoFijo"),
    @NamedQuery(name = "RhEmpleado.findByEmpBonoFijoNd", query = "SELECT r FROM RhEmpleado r WHERE r.empBonoFijoNd = :empBonoFijoNd"),
    @NamedQuery(name = "RhEmpleado.findByEmpOtrosIngresos", query = "SELECT r FROM RhEmpleado r WHERE r.empOtrosIngresos = :empOtrosIngresos"),
    @NamedQuery(name = "RhEmpleado.findByEmpOtrosIngresosNd", query = "SELECT r FROM RhEmpleado r WHERE r.empOtrosIngresosNd = :empOtrosIngresosNd"),
    @NamedQuery(name = "RhEmpleado.findByEmpExtensionCoberturaIess", query = "SELECT r FROM RhEmpleado r WHERE r.empExtensionCoberturaIess = :empExtensionCoberturaIess"),
    @NamedQuery(name = "RhEmpleado.findByEmpCancelarXiiiSueldoMensualmente", query = "SELECT r FROM RhEmpleado r WHERE r.empCancelarXiiiSueldoMensualmente = :empCancelarXiiiSueldoMensualmente"),
    @NamedQuery(name = "RhEmpleado.findByEmpCancelarXivSueldoMensualmente", query = "SELECT r FROM RhEmpleado r WHERE r.empCancelarXivSueldoMensualmente = :empCancelarXivSueldoMensualmente"),
    @NamedQuery(name = "RhEmpleado.findByEmpCancelarFondoReservaMensualmente", query = "SELECT r FROM RhEmpleado r WHERE r.empCancelarFondoReservaMensualmente = :empCancelarFondoReservaMensualmente"),
    @NamedQuery(name = "RhEmpleado.findByEmpRetencion", query = "SELECT r FROM RhEmpleado r WHERE r.empRetencion = :empRetencion"),
    @NamedQuery(name = "RhEmpleado.findByEmpEducacion", query = "SELECT r FROM RhEmpleado r WHERE r.empEducacion = :empEducacion"),
    @NamedQuery(name = "RhEmpleado.findByEmpAlimentacion", query = "SELECT r FROM RhEmpleado r WHERE r.empAlimentacion = :empAlimentacion"),
    @NamedQuery(name = "RhEmpleado.findByEmpSalud", query = "SELECT r FROM RhEmpleado r WHERE r.empSalud = :empSalud"),
    @NamedQuery(name = "RhEmpleado.findByEmpVivienda", query = "SELECT r FROM RhEmpleado r WHERE r.empVivienda = :empVivienda"),
    @NamedQuery(name = "RhEmpleado.findByEmpVestuario", query = "SELECT r FROM RhEmpleado r WHERE r.empVestuario = :empVestuario"),
    @NamedQuery(name = "RhEmpleado.findByEmpRebajaDiscapacidad", query = "SELECT r FROM RhEmpleado r WHERE r.empRebajaDiscapacidad = :empRebajaDiscapacidad"),
    @NamedQuery(name = "RhEmpleado.findByEmpRebajaTerceraEdad", query = "SELECT r FROM RhEmpleado r WHERE r.empRebajaTerceraEdad = :empRebajaTerceraEdad"),
    @NamedQuery(name = "RhEmpleado.findByEmpSueldoOtraCompania", query = "SELECT r FROM RhEmpleado r WHERE r.empSueldoOtraCompania = :empSueldoOtraCompania"),
    @NamedQuery(name = "RhEmpleado.findByEmpOtrasDeducciones", query = "SELECT r FROM RhEmpleado r WHERE r.empOtrasDeducciones = :empOtrasDeducciones"),
    @NamedQuery(name = "RhEmpleado.findByEmpOtrasRebajas", query = "SELECT r FROM RhEmpleado r WHERE r.empOtrasRebajas = :empOtrasRebajas"),
    @NamedQuery(name = "RhEmpleado.findByEmpUtilidades", query = "SELECT r FROM RhEmpleado r WHERE r.empUtilidades = :empUtilidades"),
    @NamedQuery(name = "RhEmpleado.findByEmpObservaciones", query = "SELECT r FROM RhEmpleado r WHERE r.empObservaciones = :empObservaciones"),
    @NamedQuery(name = "RhEmpleado.findByEmpDiscapacidadTipo", query = "SELECT r FROM RhEmpleado r WHERE r.empDiscapacidadTipo = :empDiscapacidadTipo"),
    @NamedQuery(name = "RhEmpleado.findByEmpDiscapacidadPorcentaje", query = "SELECT r FROM RhEmpleado r WHERE r.empDiscapacidadPorcentaje = :empDiscapacidadPorcentaje"),
    @NamedQuery(name = "RhEmpleado.findByEmpDiscapacidadIdTipo", query = "SELECT r FROM RhEmpleado r WHERE r.empDiscapacidadIdTipo = :empDiscapacidadIdTipo"),
    @NamedQuery(name = "RhEmpleado.findByEmpDiscapacidadIdNumero", query = "SELECT r FROM RhEmpleado r WHERE r.empDiscapacidadIdNumero = :empDiscapacidadIdNumero"),
    @NamedQuery(name = "RhEmpleado.findByEmpBanco", query = "SELECT r FROM RhEmpleado r WHERE r.empBanco = :empBanco"),
    @NamedQuery(name = "RhEmpleado.findByEmpCuentaTipo", query = "SELECT r FROM RhEmpleado r WHERE r.empCuentaTipo = :empCuentaTipo"),
    @NamedQuery(name = "RhEmpleado.findByEmpCuentaNumero", query = "SELECT r FROM RhEmpleado r WHERE r.empCuentaNumero = :empCuentaNumero"),
    @NamedQuery(name = "RhEmpleado.findByEmpSalarioNeto", query = "SELECT r FROM RhEmpleado r WHERE r.empSalarioNeto = :empSalarioNeto"),
    @NamedQuery(name = "RhEmpleado.findByEmpInactivo", query = "SELECT r FROM RhEmpleado r WHERE r.empInactivo = :empInactivo"),
    @NamedQuery(name = "RhEmpleado.findBySecEmpresa", query = "SELECT r FROM RhEmpleado r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhEmpleado.findBySecCodigo", query = "SELECT r FROM RhEmpleado r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhEmpleado.findByCatEmpresa", query = "SELECT r FROM RhEmpleado r WHERE r.catEmpresa = :catEmpresa"),
    @NamedQuery(name = "RhEmpleado.findByCatNombre", query = "SELECT r FROM RhEmpleado r WHERE r.catNombre = :catNombre"),
    @NamedQuery(name = "RhEmpleado.findByUsrEmpresa", query = "SELECT r FROM RhEmpleado r WHERE r.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "RhEmpleado.findByUsrCodigo", query = "SELECT r FROM RhEmpleado r WHERE r.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "RhEmpleado.findByUsrFechaInserta", query = "SELECT r FROM RhEmpleado r WHERE r.usrFechaInserta = :usrFechaInserta")})
public class RhEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RhEmpleadoPK rhEmpleadoPK;
    @Basic(optional = false)
    @Column(name = "emp_tipo_id")
    private char empTipoId;
    @Column(name = "emp_residencia_tipo")
    private String empResidenciaTipo;
    @Column(name = "emp_residencia_pais")
    private String empResidenciaPais;
    @Column(name = "emp_convenio")
    private String empConvenio;
    @Basic(optional = false)
    @Column(name = "emp_apellidos")
    private String empApellidos;
    @Basic(optional = false)
    @Column(name = "emp_nombres")
    private String empNombres;
    @Column(name = "emp_genero")
    private Character empGenero;
    @Basic(optional = false)
    @Column(name = "emp_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date empFechaNacimiento;
    @Basic(optional = false)
    @Column(name = "emp_estado_civil")
    private String empEstadoCivil;
    @Basic(optional = false)
    @Column(name = "emp_cargas_familiares")
    private int empCargasFamiliares;
    @Basic(optional = false)
    @Column(name = "emp_provincia")
    private String empProvincia;
    @Basic(optional = false)
    @Column(name = "emp_canton")
    private String empCanton;
    @Basic(optional = false)
    @Column(name = "emp_lugar_nacimiento")
    private String empLugarNacimiento;
    @Basic(optional = false)
    @Column(name = "emp_domicilio")
    private String empDomicilio;
    @Basic(optional = false)
    @Column(name = "emp_numero")
    private String empNumero;
    @Basic(optional = false)
    @Column(name = "emp_telefono")
    private String empTelefono;
    @Column(name = "emp_correo_electronico")
    private String empCorreoElectronico;
    @Basic(optional = false)
    @Column(name = "emp_fecha_primer_ingreso")
    @Temporal(TemporalType.DATE)
    private Date empFechaPrimerIngreso;
    @Column(name = "emp_fecha_primera_salida")
    @Temporal(TemporalType.DATE)
    private Date empFechaPrimeraSalida;
    @Column(name = "emp_fecha_ultimo_ingreso")
    @Temporal(TemporalType.DATE)
    private Date empFechaUltimoIngreso;
    @Column(name = "emp_fecha_ultima_salida")
    @Temporal(TemporalType.DATE)
    private Date empFechaUltimaSalida;
    @Column(name = "emp_motivo_salida")
    private String empMotivoSalida;
    @Column(name = "emp_fecha_afiliacion_iess")
    @Temporal(TemporalType.DATE)
    private Date empFechaAfiliacionIess;
    @Column(name = "emp_codigo_afiliacion_iess")
    private String empCodigoAfiliacionIess;
    @Column(name = "emp_codigo_cargo")
    private String empCodigoCargo;
    @Basic(optional = false)
    @Column(name = "emp_cargo")
    private String empCargo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "emp_sueldo_iess")
    private BigDecimal empSueldoIess;
    @Basic(optional = false)
    @Column(name = "emp_forma_pago")
    private String empFormaPago;
    @Basic(optional = false)
    @Column(name = "emp_dias_trabajados")
    private int empDiasTrabajados;
    @Basic(optional = false)
    @Column(name = "emp_dias_descanso")
    private int empDiasDescanso;
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
    @Column(name = "emp_extension_cobertura_iess")
    private boolean empExtensionCoberturaIess;
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
    @Column(name = "emp_retencion")
    private boolean empRetencion;
    @Basic(optional = false)
    @Column(name = "emp_educacion")
    private BigDecimal empEducacion;
    @Basic(optional = false)
    @Column(name = "emp_alimentacion")
    private BigDecimal empAlimentacion;
    @Basic(optional = false)
    @Column(name = "emp_salud")
    private BigDecimal empSalud;
    @Basic(optional = false)
    @Column(name = "emp_vivienda")
    private BigDecimal empVivienda;
    @Basic(optional = false)
    @Column(name = "emp_vestuario")
    private BigDecimal empVestuario;
    @Basic(optional = false)
    @Column(name = "emp_rebaja_discapacidad")
    private BigDecimal empRebajaDiscapacidad;
    @Basic(optional = false)
    @Column(name = "emp_rebaja_tercera_edad")
    private BigDecimal empRebajaTerceraEdad;
    @Basic(optional = false)
    @Column(name = "emp_sueldo_otra_compania")
    private BigDecimal empSueldoOtraCompania;
    @Basic(optional = false)
    @Column(name = "emp_otras_deducciones")
    private BigDecimal empOtrasDeducciones;
    @Basic(optional = false)
    @Column(name = "emp_otras_rebajas")
    private BigDecimal empOtrasRebajas;
    @Basic(optional = false)
    @Column(name = "emp_utilidades")
    private BigDecimal empUtilidades;
    @Column(name = "emp_observaciones")
    private String empObservaciones;
    @Column(name = "emp_discapacidad_tipo")
    private String empDiscapacidadTipo;
    @Column(name = "emp_discapacidad_porcentaje")
    private Short empDiscapacidadPorcentaje;
    @Column(name = "emp_discapacidad_id_tipo")
    private Character empDiscapacidadIdTipo;
    @Column(name = "emp_discapacidad_id_numero")
    private String empDiscapacidadIdNumero;
    @Column(name = "emp_banco")
    private String empBanco;
    @Column(name = "emp_cuenta_tipo")
    private String empCuentaTipo;
    @Column(name = "emp_cuenta_numero")
    private String empCuentaNumero;
    @Basic(optional = false)
    @Column(name = "emp_salario_neto")
    private boolean empSalarioNeto;
    @Basic(optional = false)
    @Column(name = "emp_inactivo")
    private boolean empInactivo;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
    @Basic(optional = false)
    @Column(name = "cat_empresa")
    private String catEmpresa;
    @Basic(optional = false)
    @Column(name = "cat_nombre")
    private String catNombre;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rhEmpleado")
    private List<RhViatico> rhViaticoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rhEmpleado")
    private List<RhRol> rhRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rhEmpleado")
    private List<RhEmpleadoDescuentosFijos> rhEmpleadoDescuentosFijosList;
    @OneToMany(mappedBy = "rhEmpleado")
    private List<RhXiiiSueldo> rhXiiiSueldoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rhEmpleado")
    private List<RhPrestamo> rhPrestamoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rhEmpleado")
    private List<RhVacaciones> rhVacacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rhEmpleado")
    private List<RhBono> rhBonoList;
    @OneToMany(mappedBy = "rhEmpleado")
    private List<RhXivSueldo> rhXivSueldoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rhEmpleado")
    private List<RhAnticipo> rhAnticipoList;
    @OneToMany(mappedBy = "rhEmpleado")
    private List<RhUtilidades> rhUtilidadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rhEmpleado")
    private List<RhSalarioDigno> rhSalarioDignoList;

    public RhEmpleado() {
    }

    public RhEmpleado(RhEmpleadoPK rhEmpleadoPK) {
        this.rhEmpleadoPK = rhEmpleadoPK;
    }

    public RhEmpleado(RhEmpleadoPK rhEmpleadoPK, char empTipoId, String empApellidos, String empNombres, Date empFechaNacimiento, String empEstadoCivil, int empCargasFamiliares, String empProvincia, String empCanton, String empLugarNacimiento, String empDomicilio, String empNumero, String empTelefono, Date empFechaPrimerIngreso, String empCargo, BigDecimal empSueldoIess, String empFormaPago, int empDiasTrabajados, int empDiasDescanso, BigDecimal empBonoFijo, BigDecimal empBonoFijoNd, BigDecimal empOtrosIngresos, BigDecimal empOtrosIngresosNd, boolean empExtensionCoberturaIess, boolean empCancelarXiiiSueldoMensualmente, boolean empCancelarXivSueldoMensualmente, boolean empCancelarFondoReservaMensualmente, boolean empRetencion, BigDecimal empEducacion, BigDecimal empAlimentacion, BigDecimal empSalud, BigDecimal empVivienda, BigDecimal empVestuario, BigDecimal empRebajaDiscapacidad, BigDecimal empRebajaTerceraEdad, BigDecimal empSueldoOtraCompania, BigDecimal empOtrasDeducciones, BigDecimal empOtrasRebajas, BigDecimal empUtilidades, boolean empSalarioNeto, boolean empInactivo, String secEmpresa, String secCodigo, String catEmpresa, String catNombre, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.rhEmpleadoPK = rhEmpleadoPK;
        this.empTipoId = empTipoId;
        this.empApellidos = empApellidos;
        this.empNombres = empNombres;
        this.empFechaNacimiento = empFechaNacimiento;
        this.empEstadoCivil = empEstadoCivil;
        this.empCargasFamiliares = empCargasFamiliares;
        this.empProvincia = empProvincia;
        this.empCanton = empCanton;
        this.empLugarNacimiento = empLugarNacimiento;
        this.empDomicilio = empDomicilio;
        this.empNumero = empNumero;
        this.empTelefono = empTelefono;
        this.empFechaPrimerIngreso = empFechaPrimerIngreso;
        this.empCargo = empCargo;
        this.empSueldoIess = empSueldoIess;
        this.empFormaPago = empFormaPago;
        this.empDiasTrabajados = empDiasTrabajados;
        this.empDiasDescanso = empDiasDescanso;
        this.empBonoFijo = empBonoFijo;
        this.empBonoFijoNd = empBonoFijoNd;
        this.empOtrosIngresos = empOtrosIngresos;
        this.empOtrosIngresosNd = empOtrosIngresosNd;
        this.empExtensionCoberturaIess = empExtensionCoberturaIess;
        this.empCancelarXiiiSueldoMensualmente = empCancelarXiiiSueldoMensualmente;
        this.empCancelarXivSueldoMensualmente = empCancelarXivSueldoMensualmente;
        this.empCancelarFondoReservaMensualmente = empCancelarFondoReservaMensualmente;
        this.empRetencion = empRetencion;
        this.empEducacion = empEducacion;
        this.empAlimentacion = empAlimentacion;
        this.empSalud = empSalud;
        this.empVivienda = empVivienda;
        this.empVestuario = empVestuario;
        this.empRebajaDiscapacidad = empRebajaDiscapacidad;
        this.empRebajaTerceraEdad = empRebajaTerceraEdad;
        this.empSueldoOtraCompania = empSueldoOtraCompania;
        this.empOtrasDeducciones = empOtrasDeducciones;
        this.empOtrasRebajas = empOtrasRebajas;
        this.empUtilidades = empUtilidades;
        this.empSalarioNeto = empSalarioNeto;
        this.empInactivo = empInactivo;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.catEmpresa = catEmpresa;
        this.catNombre = catNombre;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public RhEmpleado(String empEmpresa, String empId) {
        this.rhEmpleadoPK = new RhEmpleadoPK(empEmpresa, empId);
    }

    public RhEmpleadoPK getRhEmpleadoPK() {
        return rhEmpleadoPK;
    }

    public void setRhEmpleadoPK(RhEmpleadoPK rhEmpleadoPK) {
        this.rhEmpleadoPK = rhEmpleadoPK;
    }

    public char getEmpTipoId() {
        return empTipoId;
    }

    public void setEmpTipoId(char empTipoId) {
        this.empTipoId = empTipoId;
    }

    public String getEmpResidenciaTipo() {
        return empResidenciaTipo;
    }

    public void setEmpResidenciaTipo(String empResidenciaTipo) {
        this.empResidenciaTipo = empResidenciaTipo;
    }

    public String getEmpResidenciaPais() {
        return empResidenciaPais;
    }

    public void setEmpResidenciaPais(String empResidenciaPais) {
        this.empResidenciaPais = empResidenciaPais;
    }

    public String getEmpConvenio() {
        return empConvenio;
    }

    public void setEmpConvenio(String empConvenio) {
        this.empConvenio = empConvenio;
    }

    public String getEmpApellidos() {
        return empApellidos;
    }

    public void setEmpApellidos(String empApellidos) {
        this.empApellidos = empApellidos;
    }

    public String getEmpNombres() {
        return empNombres;
    }

    public void setEmpNombres(String empNombres) {
        this.empNombres = empNombres;
    }

    public Character getEmpGenero() {
        return empGenero;
    }

    public void setEmpGenero(Character empGenero) {
        this.empGenero = empGenero;
    }

    public Date getEmpFechaNacimiento() {
        return empFechaNacimiento;
    }

    public void setEmpFechaNacimiento(Date empFechaNacimiento) {
        this.empFechaNacimiento = empFechaNacimiento;
    }

    public String getEmpEstadoCivil() {
        return empEstadoCivil;
    }

    public void setEmpEstadoCivil(String empEstadoCivil) {
        this.empEstadoCivil = empEstadoCivil;
    }

    public int getEmpCargasFamiliares() {
        return empCargasFamiliares;
    }

    public void setEmpCargasFamiliares(int empCargasFamiliares) {
        this.empCargasFamiliares = empCargasFamiliares;
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

    public String getEmpLugarNacimiento() {
        return empLugarNacimiento;
    }

    public void setEmpLugarNacimiento(String empLugarNacimiento) {
        this.empLugarNacimiento = empLugarNacimiento;
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

    public String getEmpCorreoElectronico() {
        return empCorreoElectronico;
    }

    public void setEmpCorreoElectronico(String empCorreoElectronico) {
        this.empCorreoElectronico = empCorreoElectronico;
    }

    public Date getEmpFechaPrimerIngreso() {
        return empFechaPrimerIngreso;
    }

    public void setEmpFechaPrimerIngreso(Date empFechaPrimerIngreso) {
        this.empFechaPrimerIngreso = empFechaPrimerIngreso;
    }

    public Date getEmpFechaPrimeraSalida() {
        return empFechaPrimeraSalida;
    }

    public void setEmpFechaPrimeraSalida(Date empFechaPrimeraSalida) {
        this.empFechaPrimeraSalida = empFechaPrimeraSalida;
    }

    public Date getEmpFechaUltimoIngreso() {
        return empFechaUltimoIngreso;
    }

    public void setEmpFechaUltimoIngreso(Date empFechaUltimoIngreso) {
        this.empFechaUltimoIngreso = empFechaUltimoIngreso;
    }

    public Date getEmpFechaUltimaSalida() {
        return empFechaUltimaSalida;
    }

    public void setEmpFechaUltimaSalida(Date empFechaUltimaSalida) {
        this.empFechaUltimaSalida = empFechaUltimaSalida;
    }

    public String getEmpMotivoSalida() {
        return empMotivoSalida;
    }

    public void setEmpMotivoSalida(String empMotivoSalida) {
        this.empMotivoSalida = empMotivoSalida;
    }

    public Date getEmpFechaAfiliacionIess() {
        return empFechaAfiliacionIess;
    }

    public void setEmpFechaAfiliacionIess(Date empFechaAfiliacionIess) {
        this.empFechaAfiliacionIess = empFechaAfiliacionIess;
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

    public String getEmpCargo() {
        return empCargo;
    }

    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }

    public BigDecimal getEmpSueldoIess() {
        return empSueldoIess;
    }

    public void setEmpSueldoIess(BigDecimal empSueldoIess) {
        this.empSueldoIess = empSueldoIess;
    }

    public String getEmpFormaPago() {
        return empFormaPago;
    }

    public void setEmpFormaPago(String empFormaPago) {
        this.empFormaPago = empFormaPago;
    }

    public int getEmpDiasTrabajados() {
        return empDiasTrabajados;
    }

    public void setEmpDiasTrabajados(int empDiasTrabajados) {
        this.empDiasTrabajados = empDiasTrabajados;
    }

    public int getEmpDiasDescanso() {
        return empDiasDescanso;
    }

    public void setEmpDiasDescanso(int empDiasDescanso) {
        this.empDiasDescanso = empDiasDescanso;
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

    public boolean getEmpExtensionCoberturaIess() {
        return empExtensionCoberturaIess;
    }

    public void setEmpExtensionCoberturaIess(boolean empExtensionCoberturaIess) {
        this.empExtensionCoberturaIess = empExtensionCoberturaIess;
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

    public boolean getEmpRetencion() {
        return empRetencion;
    }

    public void setEmpRetencion(boolean empRetencion) {
        this.empRetencion = empRetencion;
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

    public BigDecimal getEmpUtilidades() {
        return empUtilidades;
    }

    public void setEmpUtilidades(BigDecimal empUtilidades) {
        this.empUtilidades = empUtilidades;
    }

    public String getEmpObservaciones() {
        return empObservaciones;
    }

    public void setEmpObservaciones(String empObservaciones) {
        this.empObservaciones = empObservaciones;
    }

    public String getEmpDiscapacidadTipo() {
        return empDiscapacidadTipo;
    }

    public void setEmpDiscapacidadTipo(String empDiscapacidadTipo) {
        this.empDiscapacidadTipo = empDiscapacidadTipo;
    }

    public Short getEmpDiscapacidadPorcentaje() {
        return empDiscapacidadPorcentaje;
    }

    public void setEmpDiscapacidadPorcentaje(Short empDiscapacidadPorcentaje) {
        this.empDiscapacidadPorcentaje = empDiscapacidadPorcentaje;
    }

    public Character getEmpDiscapacidadIdTipo() {
        return empDiscapacidadIdTipo;
    }

    public void setEmpDiscapacidadIdTipo(Character empDiscapacidadIdTipo) {
        this.empDiscapacidadIdTipo = empDiscapacidadIdTipo;
    }

    public String getEmpDiscapacidadIdNumero() {
        return empDiscapacidadIdNumero;
    }

    public void setEmpDiscapacidadIdNumero(String empDiscapacidadIdNumero) {
        this.empDiscapacidadIdNumero = empDiscapacidadIdNumero;
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

    public boolean getEmpSalarioNeto() {
        return empSalarioNeto;
    }

    public void setEmpSalarioNeto(boolean empSalarioNeto) {
        this.empSalarioNeto = empSalarioNeto;
    }

    public boolean getEmpInactivo() {
        return empInactivo;
    }

    public void setEmpInactivo(boolean empInactivo) {
        this.empInactivo = empInactivo;
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

    public String getCatEmpresa() {
        return catEmpresa;
    }

    public void setCatEmpresa(String catEmpresa) {
        this.catEmpresa = catEmpresa;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
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

    public List<RhViatico> getRhViaticoList() {
        return rhViaticoList;
    }

    public void setRhViaticoList(List<RhViatico> rhViaticoList) {
        this.rhViaticoList = rhViaticoList;
    }

    public List<RhRol> getRhRolList() {
        return rhRolList;
    }

    public void setRhRolList(List<RhRol> rhRolList) {
        this.rhRolList = rhRolList;
    }

    public List<RhEmpleadoDescuentosFijos> getRhEmpleadoDescuentosFijosList() {
        return rhEmpleadoDescuentosFijosList;
    }

    public void setRhEmpleadoDescuentosFijosList(List<RhEmpleadoDescuentosFijos> rhEmpleadoDescuentosFijosList) {
        this.rhEmpleadoDescuentosFijosList = rhEmpleadoDescuentosFijosList;
    }

    public List<RhXiiiSueldo> getRhXiiiSueldoList() {
        return rhXiiiSueldoList;
    }

    public void setRhXiiiSueldoList(List<RhXiiiSueldo> rhXiiiSueldoList) {
        this.rhXiiiSueldoList = rhXiiiSueldoList;
    }

    public List<RhPrestamo> getRhPrestamoList() {
        return rhPrestamoList;
    }

    public void setRhPrestamoList(List<RhPrestamo> rhPrestamoList) {
        this.rhPrestamoList = rhPrestamoList;
    }

    public List<RhVacaciones> getRhVacacionesList() {
        return rhVacacionesList;
    }

    public void setRhVacacionesList(List<RhVacaciones> rhVacacionesList) {
        this.rhVacacionesList = rhVacacionesList;
    }

    public List<RhBono> getRhBonoList() {
        return rhBonoList;
    }

    public void setRhBonoList(List<RhBono> rhBonoList) {
        this.rhBonoList = rhBonoList;
    }

    public List<RhXivSueldo> getRhXivSueldoList() {
        return rhXivSueldoList;
    }

    public void setRhXivSueldoList(List<RhXivSueldo> rhXivSueldoList) {
        this.rhXivSueldoList = rhXivSueldoList;
    }

    public List<RhAnticipo> getRhAnticipoList() {
        return rhAnticipoList;
    }

    public void setRhAnticipoList(List<RhAnticipo> rhAnticipoList) {
        this.rhAnticipoList = rhAnticipoList;
    }

    public List<RhUtilidades> getRhUtilidadesList() {
        return rhUtilidadesList;
    }

    public void setRhUtilidadesList(List<RhUtilidades> rhUtilidadesList) {
        this.rhUtilidadesList = rhUtilidadesList;
    }

    public List<RhSalarioDigno> getRhSalarioDignoList() {
        return rhSalarioDignoList;
    }

    public void setRhSalarioDignoList(List<RhSalarioDigno> rhSalarioDignoList) {
        this.rhSalarioDignoList = rhSalarioDignoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rhEmpleadoPK != null ? rhEmpleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhEmpleado)) {
            return false;
        }
        RhEmpleado other = (RhEmpleado) object;
        if ((this.rhEmpleadoPK == null && other.rhEmpleadoPK != null) || (this.rhEmpleadoPK != null && !this.rhEmpleadoPK.equals(other.rhEmpleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhEmpleado[ rhEmpleadoPK=" + rhEmpleadoPK + " ]";
    }
}
