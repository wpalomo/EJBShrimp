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
@Table(name = "rh_xiii_sueldo", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhXiiiSueldo.findAll", query = "SELECT r FROM RhXiiiSueldo r"),
    @NamedQuery(name = "RhXiiiSueldo.findByXiiiSecuencial", query = "SELECT r FROM RhXiiiSueldo r WHERE r.xiiiSecuencial = :xiiiSecuencial"),
    @NamedQuery(name = "RhXiiiSueldo.findByXiiiDesde", query = "SELECT r FROM RhXiiiSueldo r WHERE r.xiiiDesde = :xiiiDesde"),
    @NamedQuery(name = "RhXiiiSueldo.findByXiiiHasta", query = "SELECT r FROM RhXiiiSueldo r WHERE r.xiiiHasta = :xiiiHasta"),
    @NamedQuery(name = "RhXiiiSueldo.findByXiiiDiasLaborados", query = "SELECT r FROM RhXiiiSueldo r WHERE r.xiiiDiasLaborados = :xiiiDiasLaborados"),
    @NamedQuery(name = "RhXiiiSueldo.findByXivDiasLaboradosGlobal", query = "SELECT r FROM RhXiiiSueldo r WHERE r.xivDiasLaboradosGlobal = :xivDiasLaboradosGlobal"),
    @NamedQuery(name = "RhXiiiSueldo.findByXiiiBaseImponible", query = "SELECT r FROM RhXiiiSueldo r WHERE r.xiiiBaseImponible = :xiiiBaseImponible"),
    @NamedQuery(name = "RhXiiiSueldo.findByXiiiValor", query = "SELECT r FROM RhXiiiSueldo r WHERE r.xiiiValor = :xiiiValor"),
    @NamedQuery(name = "RhXiiiSueldo.findByXiiiFormaPago", query = "SELECT r FROM RhXiiiSueldo r WHERE r.xiiiFormaPago = :xiiiFormaPago"),
    @NamedQuery(name = "RhXiiiSueldo.findByXiiiCodigoMinisterial", query = "SELECT r FROM RhXiiiSueldo r WHERE r.xiiiCodigoMinisterial = :xiiiCodigoMinisterial"),
    @NamedQuery(name = "RhXiiiSueldo.findByXiiiReversado", query = "SELECT r FROM RhXiiiSueldo r WHERE r.xiiiReversado = :xiiiReversado"),
    @NamedQuery(name = "RhXiiiSueldo.findByEmpCargo", query = "SELECT r FROM RhXiiiSueldo r WHERE r.empCargo = :empCargo"),
    @NamedQuery(name = "RhXiiiSueldo.findByEmpFechaIngreso", query = "SELECT r FROM RhXiiiSueldo r WHERE r.empFechaIngreso = :empFechaIngreso"),
    @NamedQuery(name = "RhXiiiSueldo.findBySecEmpresa", query = "SELECT r FROM RhXiiiSueldo r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhXiiiSueldo.findBySecCodigo", query = "SELECT r FROM RhXiiiSueldo r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhXiiiSueldo.findByConEmpresa", query = "SELECT r FROM RhXiiiSueldo r WHERE r.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "RhXiiiSueldo.findByConPeriodo", query = "SELECT r FROM RhXiiiSueldo r WHERE r.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "RhXiiiSueldo.findByConTipo", query = "SELECT r FROM RhXiiiSueldo r WHERE r.conTipo = :conTipo"),
    @NamedQuery(name = "RhXiiiSueldo.findByConNumero", query = "SELECT r FROM RhXiiiSueldo r WHERE r.conNumero = :conNumero")})
public class RhXiiiSueldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "xiii_secuencial")
    private Integer xiiiSecuencial;
    @Column(name = "xiii_desde")
    @Temporal(TemporalType.DATE)
    private Date xiiiDesde;
    @Column(name = "xiii_hasta")
    @Temporal(TemporalType.DATE)
    private Date xiiiHasta;
    @Column(name = "xiii_dias_laborados")
    private Integer xiiiDiasLaborados;
    @Column(name = "xiv_dias_laborados_global")
    private Integer xivDiasLaboradosGlobal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "xiii_base_imponible")
    private BigDecimal xiiiBaseImponible;
    @Column(name = "xiii_valor")
    private BigDecimal xiiiValor;
    @Column(name = "xiii_forma_pago")
    private String xiiiFormaPago;
    @Column(name = "xiii_codigo_ministerial")
    private String xiiiCodigoMinisterial;
    @Basic(optional = false)
    @Column(name = "xiii_reversado")
    private boolean xiiiReversado;
    @Column(name = "emp_cargo")
    private String empCargo;
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

    public RhXiiiSueldo() {
    }

    public RhXiiiSueldo(Integer xiiiSecuencial) {
        this.xiiiSecuencial = xiiiSecuencial;
    }

    public RhXiiiSueldo(Integer xiiiSecuencial, boolean xiiiReversado, Date empFechaIngreso, String secEmpresa, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.xiiiSecuencial = xiiiSecuencial;
        this.xiiiReversado = xiiiReversado;
        this.empFechaIngreso = empFechaIngreso;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
    }

    public Integer getXiiiSecuencial() {
        return xiiiSecuencial;
    }

    public void setXiiiSecuencial(Integer xiiiSecuencial) {
        this.xiiiSecuencial = xiiiSecuencial;
    }

    public Date getXiiiDesde() {
        return xiiiDesde;
    }

    public void setXiiiDesde(Date xiiiDesde) {
        this.xiiiDesde = xiiiDesde;
    }

    public Date getXiiiHasta() {
        return xiiiHasta;
    }

    public void setXiiiHasta(Date xiiiHasta) {
        this.xiiiHasta = xiiiHasta;
    }

    public Integer getXiiiDiasLaborados() {
        return xiiiDiasLaborados;
    }

    public void setXiiiDiasLaborados(Integer xiiiDiasLaborados) {
        this.xiiiDiasLaborados = xiiiDiasLaborados;
    }

    public Integer getXivDiasLaboradosGlobal() {
        return xivDiasLaboradosGlobal;
    }

    public void setXivDiasLaboradosGlobal(Integer xivDiasLaboradosGlobal) {
        this.xivDiasLaboradosGlobal = xivDiasLaboradosGlobal;
    }

    public BigDecimal getXiiiBaseImponible() {
        return xiiiBaseImponible;
    }

    public void setXiiiBaseImponible(BigDecimal xiiiBaseImponible) {
        this.xiiiBaseImponible = xiiiBaseImponible;
    }

    public BigDecimal getXiiiValor() {
        return xiiiValor;
    }

    public void setXiiiValor(BigDecimal xiiiValor) {
        this.xiiiValor = xiiiValor;
    }

    public String getXiiiFormaPago() {
        return xiiiFormaPago;
    }

    public void setXiiiFormaPago(String xiiiFormaPago) {
        this.xiiiFormaPago = xiiiFormaPago;
    }

    public String getXiiiCodigoMinisterial() {
        return xiiiCodigoMinisterial;
    }

    public void setXiiiCodigoMinisterial(String xiiiCodigoMinisterial) {
        this.xiiiCodigoMinisterial = xiiiCodigoMinisterial;
    }

    public boolean getXiiiReversado() {
        return xiiiReversado;
    }

    public void setXiiiReversado(boolean xiiiReversado) {
        this.xiiiReversado = xiiiReversado;
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
        hash += (xiiiSecuencial != null ? xiiiSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhXiiiSueldo)) {
            return false;
        }
        RhXiiiSueldo other = (RhXiiiSueldo) object;
        if ((this.xiiiSecuencial == null && other.xiiiSecuencial != null) || (this.xiiiSecuencial != null && !this.xiiiSecuencial.equals(other.xiiiSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhXiiiSueldo[ xiiiSecuencial=" + xiiiSecuencial + " ]";
    }
}
