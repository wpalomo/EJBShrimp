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
@Table(name = "rh_utilidades", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhUtilidades.findAll", query = "SELECT r FROM RhUtilidades r"),
    @NamedQuery(name = "RhUtilidades.findByUtiSecuencial", query = "SELECT r FROM RhUtilidades r WHERE r.utiSecuencial = :utiSecuencial"),
    @NamedQuery(name = "RhUtilidades.findByUtiDesde", query = "SELECT r FROM RhUtilidades r WHERE r.utiDesde = :utiDesde"),
    @NamedQuery(name = "RhUtilidades.findByUtiHasta", query = "SELECT r FROM RhUtilidades r WHERE r.utiHasta = :utiHasta"),
    @NamedQuery(name = "RhUtilidades.findByUtiDiasLaborados", query = "SELECT r FROM RhUtilidades r WHERE r.utiDiasLaborados = :utiDiasLaborados"),
    @NamedQuery(name = "RhUtilidades.findByUtiValorPersonal", query = "SELECT r FROM RhUtilidades r WHERE r.utiValorPersonal = :utiValorPersonal"),
    @NamedQuery(name = "RhUtilidades.findByUtiValorCargas", query = "SELECT r FROM RhUtilidades r WHERE r.utiValorCargas = :utiValorCargas"),
    @NamedQuery(name = "RhUtilidades.findByUtiValorTotal", query = "SELECT r FROM RhUtilidades r WHERE r.utiValorTotal = :utiValorTotal"),
    @NamedQuery(name = "RhUtilidades.findByUtiFormaPago", query = "SELECT r FROM RhUtilidades r WHERE r.utiFormaPago = :utiFormaPago"),
    @NamedQuery(name = "RhUtilidades.findByUtiCodigoMinisterial", query = "SELECT r FROM RhUtilidades r WHERE r.utiCodigoMinisterial = :utiCodigoMinisterial"),
    @NamedQuery(name = "RhUtilidades.findByUtiReversado", query = "SELECT r FROM RhUtilidades r WHERE r.utiReversado = :utiReversado"),
    @NamedQuery(name = "RhUtilidades.findByEmpCargo", query = "SELECT r FROM RhUtilidades r WHERE r.empCargo = :empCargo"),
    @NamedQuery(name = "RhUtilidades.findByEmpFechaIngreso", query = "SELECT r FROM RhUtilidades r WHERE r.empFechaIngreso = :empFechaIngreso"),
    @NamedQuery(name = "RhUtilidades.findByEmpCargasFamiliares", query = "SELECT r FROM RhUtilidades r WHERE r.empCargasFamiliares = :empCargasFamiliares"),
    @NamedQuery(name = "RhUtilidades.findBySecEmpresa", query = "SELECT r FROM RhUtilidades r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhUtilidades.findBySecCodigo", query = "SELECT r FROM RhUtilidades r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhUtilidades.findByConEmpresa", query = "SELECT r FROM RhUtilidades r WHERE r.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "RhUtilidades.findByConPeriodo", query = "SELECT r FROM RhUtilidades r WHERE r.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "RhUtilidades.findByConTipo", query = "SELECT r FROM RhUtilidades r WHERE r.conTipo = :conTipo"),
    @NamedQuery(name = "RhUtilidades.findByConNumero", query = "SELECT r FROM RhUtilidades r WHERE r.conNumero = :conNumero")})
public class RhUtilidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uti_secuencial")
    private Integer utiSecuencial;
    @Column(name = "uti_desde")
    @Temporal(TemporalType.DATE)
    private Date utiDesde;
    @Column(name = "uti_hasta")
    @Temporal(TemporalType.DATE)
    private Date utiHasta;
    @Column(name = "uti_dias_laborados")
    private Integer utiDiasLaborados;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "uti_valor_personal")
    private BigDecimal utiValorPersonal;
    @Column(name = "uti_valor_cargas")
    private BigDecimal utiValorCargas;
    @Column(name = "uti_valor_total")
    private BigDecimal utiValorTotal;
    @Column(name = "uti_forma_pago")
    private String utiFormaPago;
    @Column(name = "uti_codigo_ministerial")
    private String utiCodigoMinisterial;
    @Basic(optional = false)
    @Column(name = "uti_reversado")
    private boolean utiReversado;
    @Column(name = "emp_cargo")
    private String empCargo;
    @Basic(optional = false)
    @Column(name = "emp_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date empFechaIngreso;
    @Basic(optional = false)
    @Column(name = "emp_cargas_familiares")
    private int empCargasFamiliares;
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
    @JoinColumns({
        @JoinColumn(name = "emp_empresa", referencedColumnName = "emp_empresa"),
        @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")})
    @ManyToOne
    private RhEmpleado rhEmpleado;

    public RhUtilidades() {
    }

    public RhUtilidades(Integer utiSecuencial) {
        this.utiSecuencial = utiSecuencial;
    }

    public RhUtilidades(Integer utiSecuencial, boolean utiReversado, Date empFechaIngreso, int empCargasFamiliares, String secEmpresa, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.utiSecuencial = utiSecuencial;
        this.utiReversado = utiReversado;
        this.empFechaIngreso = empFechaIngreso;
        this.empCargasFamiliares = empCargasFamiliares;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
    }

    public Integer getUtiSecuencial() {
        return utiSecuencial;
    }

    public void setUtiSecuencial(Integer utiSecuencial) {
        this.utiSecuencial = utiSecuencial;
    }

    public Date getUtiDesde() {
        return utiDesde;
    }

    public void setUtiDesde(Date utiDesde) {
        this.utiDesde = utiDesde;
    }

    public Date getUtiHasta() {
        return utiHasta;
    }

    public void setUtiHasta(Date utiHasta) {
        this.utiHasta = utiHasta;
    }

    public Integer getUtiDiasLaborados() {
        return utiDiasLaborados;
    }

    public void setUtiDiasLaborados(Integer utiDiasLaborados) {
        this.utiDiasLaborados = utiDiasLaborados;
    }

    public BigDecimal getUtiValorPersonal() {
        return utiValorPersonal;
    }

    public void setUtiValorPersonal(BigDecimal utiValorPersonal) {
        this.utiValorPersonal = utiValorPersonal;
    }

    public BigDecimal getUtiValorCargas() {
        return utiValorCargas;
    }

    public void setUtiValorCargas(BigDecimal utiValorCargas) {
        this.utiValorCargas = utiValorCargas;
    }

    public BigDecimal getUtiValorTotal() {
        return utiValorTotal;
    }

    public void setUtiValorTotal(BigDecimal utiValorTotal) {
        this.utiValorTotal = utiValorTotal;
    }

    public String getUtiFormaPago() {
        return utiFormaPago;
    }

    public void setUtiFormaPago(String utiFormaPago) {
        this.utiFormaPago = utiFormaPago;
    }

    public String getUtiCodigoMinisterial() {
        return utiCodigoMinisterial;
    }

    public void setUtiCodigoMinisterial(String utiCodigoMinisterial) {
        this.utiCodigoMinisterial = utiCodigoMinisterial;
    }

    public boolean getUtiReversado() {
        return utiReversado;
    }

    public void setUtiReversado(boolean utiReversado) {
        this.utiReversado = utiReversado;
    }

    public String getEmpCargo() {
        return empCargo;
    }

    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }

    public Date getEmpFechaIngreso() {
        return empFechaIngreso;
    }

    public void setEmpFechaIngreso(Date empFechaIngreso) {
        this.empFechaIngreso = empFechaIngreso;
    }

    public int getEmpCargasFamiliares() {
        return empCargasFamiliares;
    }

    public void setEmpCargasFamiliares(int empCargasFamiliares) {
        this.empCargasFamiliares = empCargasFamiliares;
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

    public RhEmpleado getRhEmpleado() {
        return rhEmpleado;
    }

    public void setRhEmpleado(RhEmpleado rhEmpleado) {
        this.rhEmpleado = rhEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (utiSecuencial != null ? utiSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhUtilidades)) {
            return false;
        }
        RhUtilidades other = (RhUtilidades) object;
        if ((this.utiSecuencial == null && other.utiSecuencial != null) || (this.utiSecuencial != null && !this.utiSecuencial.equals(other.utiSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhUtilidades[ utiSecuencial=" + utiSecuencial + " ]";
    }
}
