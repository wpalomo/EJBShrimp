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
@Table(name = "rh_xiv_sueldo", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhXivSueldo.findAll", query = "SELECT r FROM RhXivSueldo r"),
    @NamedQuery(name = "RhXivSueldo.findByXivSecuencial", query = "SELECT r FROM RhXivSueldo r WHERE r.xivSecuencial = :xivSecuencial"),
    @NamedQuery(name = "RhXivSueldo.findByXivDesde", query = "SELECT r FROM RhXivSueldo r WHERE r.xivDesde = :xivDesde"),
    @NamedQuery(name = "RhXivSueldo.findByXivHasta", query = "SELECT r FROM RhXivSueldo r WHERE r.xivHasta = :xivHasta"),
    @NamedQuery(name = "RhXivSueldo.findByXivDiasLaboradosEmpleado", query = "SELECT r FROM RhXivSueldo r WHERE r.xivDiasLaboradosEmpleado = :xivDiasLaboradosEmpleado"),
    @NamedQuery(name = "RhXivSueldo.findByXivDiasLaboradosGlobal", query = "SELECT r FROM RhXivSueldo r WHERE r.xivDiasLaboradosGlobal = :xivDiasLaboradosGlobal"),
    @NamedQuery(name = "RhXivSueldo.findByXivBaseImponible", query = "SELECT r FROM RhXivSueldo r WHERE r.xivBaseImponible = :xivBaseImponible"),
    @NamedQuery(name = "RhXivSueldo.findByXivValor", query = "SELECT r FROM RhXivSueldo r WHERE r.xivValor = :xivValor"),
    @NamedQuery(name = "RhXivSueldo.findByXivFormaPago", query = "SELECT r FROM RhXivSueldo r WHERE r.xivFormaPago = :xivFormaPago"),
    @NamedQuery(name = "RhXivSueldo.findByXivCodigoMinisterial", query = "SELECT r FROM RhXivSueldo r WHERE r.xivCodigoMinisterial = :xivCodigoMinisterial"),
    @NamedQuery(name = "RhXivSueldo.findByXivReversado", query = "SELECT r FROM RhXivSueldo r WHERE r.xivReversado = :xivReversado"),
    @NamedQuery(name = "RhXivSueldo.findByEmpCargo", query = "SELECT r FROM RhXivSueldo r WHERE r.empCargo = :empCargo"),
    @NamedQuery(name = "RhXivSueldo.findByEmpSueldo", query = "SELECT r FROM RhXivSueldo r WHERE r.empSueldo = :empSueldo"),
    @NamedQuery(name = "RhXivSueldo.findByEmpFechaIngreso", query = "SELECT r FROM RhXivSueldo r WHERE r.empFechaIngreso = :empFechaIngreso"),
    @NamedQuery(name = "RhXivSueldo.findBySecEmpresa", query = "SELECT r FROM RhXivSueldo r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhXivSueldo.findBySecCodigo", query = "SELECT r FROM RhXivSueldo r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhXivSueldo.findByConEmpresa", query = "SELECT r FROM RhXivSueldo r WHERE r.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "RhXivSueldo.findByConPeriodo", query = "SELECT r FROM RhXivSueldo r WHERE r.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "RhXivSueldo.findByConTipo", query = "SELECT r FROM RhXivSueldo r WHERE r.conTipo = :conTipo"),
    @NamedQuery(name = "RhXivSueldo.findByConNumero", query = "SELECT r FROM RhXivSueldo r WHERE r.conNumero = :conNumero")})
public class RhXivSueldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "xiv_secuencial")
    private Integer xivSecuencial;
    @Column(name = "xiv_desde")
    @Temporal(TemporalType.DATE)
    private Date xivDesde;
    @Column(name = "xiv_hasta")
    @Temporal(TemporalType.DATE)
    private Date xivHasta;
    @Column(name = "xiv_dias_laborados_empleado")
    private Integer xivDiasLaboradosEmpleado;
    @Column(name = "xiv_dias_laborados_global")
    private Integer xivDiasLaboradosGlobal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "xiv_base_imponible")
    private BigDecimal xivBaseImponible;
    @Column(name = "xiv_valor")
    private BigDecimal xivValor;
    @Column(name = "xiv_forma_pago")
    private String xivFormaPago;
    @Column(name = "xiv_codigo_ministerial")
    private String xivCodigoMinisterial;
    @Basic(optional = false)
    @Column(name = "xiv_reversado")
    private boolean xivReversado;
    @Column(name = "emp_cargo")
    private String empCargo;
    @Column(name = "emp_sueldo")
    private BigDecimal empSueldo;
    @Basic(optional = false)
    @Column(name = "emp_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date empFechaIngreso;
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

    public RhXivSueldo() {
    }

    public RhXivSueldo(Integer xivSecuencial) {
        this.xivSecuencial = xivSecuencial;
    }

    public RhXivSueldo(Integer xivSecuencial, boolean xivReversado, Date empFechaIngreso, String secEmpresa, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.xivSecuencial = xivSecuencial;
        this.xivReversado = xivReversado;
        this.empFechaIngreso = empFechaIngreso;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
    }

    public Integer getXivSecuencial() {
        return xivSecuencial;
    }

    public void setXivSecuencial(Integer xivSecuencial) {
        this.xivSecuencial = xivSecuencial;
    }

    public Date getXivDesde() {
        return xivDesde;
    }

    public void setXivDesde(Date xivDesde) {
        this.xivDesde = xivDesde;
    }

    public Date getXivHasta() {
        return xivHasta;
    }

    public void setXivHasta(Date xivHasta) {
        this.xivHasta = xivHasta;
    }

    public Integer getXivDiasLaboradosEmpleado() {
        return xivDiasLaboradosEmpleado;
    }

    public void setXivDiasLaboradosEmpleado(Integer xivDiasLaboradosEmpleado) {
        this.xivDiasLaboradosEmpleado = xivDiasLaboradosEmpleado;
    }

    public Integer getXivDiasLaboradosGlobal() {
        return xivDiasLaboradosGlobal;
    }

    public void setXivDiasLaboradosGlobal(Integer xivDiasLaboradosGlobal) {
        this.xivDiasLaboradosGlobal = xivDiasLaboradosGlobal;
    }

    public BigDecimal getXivBaseImponible() {
        return xivBaseImponible;
    }

    public void setXivBaseImponible(BigDecimal xivBaseImponible) {
        this.xivBaseImponible = xivBaseImponible;
    }

    public BigDecimal getXivValor() {
        return xivValor;
    }

    public void setXivValor(BigDecimal xivValor) {
        this.xivValor = xivValor;
    }

    public String getXivFormaPago() {
        return xivFormaPago;
    }

    public void setXivFormaPago(String xivFormaPago) {
        this.xivFormaPago = xivFormaPago;
    }

    public String getXivCodigoMinisterial() {
        return xivCodigoMinisterial;
    }

    public void setXivCodigoMinisterial(String xivCodigoMinisterial) {
        this.xivCodigoMinisterial = xivCodigoMinisterial;
    }

    public boolean getXivReversado() {
        return xivReversado;
    }

    public void setXivReversado(boolean xivReversado) {
        this.xivReversado = xivReversado;
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

    public Date getEmpFechaIngreso() {
        return empFechaIngreso;
    }

    public void setEmpFechaIngreso(Date empFechaIngreso) {
        this.empFechaIngreso = empFechaIngreso;
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
        hash += (xivSecuencial != null ? xivSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhXivSueldo)) {
            return false;
        }
        RhXivSueldo other = (RhXivSueldo) object;
        if ((this.xivSecuencial == null && other.xivSecuencial != null) || (this.xivSecuencial != null && !this.xivSecuencial.equals(other.xivSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhXivSueldo[ xivSecuencial=" + xivSecuencial + " ]";
    }
}
