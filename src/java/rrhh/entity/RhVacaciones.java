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
@Table(name = "rh_vacaciones", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhVacaciones.findAll", query = "SELECT r FROM RhVacaciones r"),
    @NamedQuery(name = "RhVacaciones.findByVacSecuencial", query = "SELECT r FROM RhVacaciones r WHERE r.vacSecuencial = :vacSecuencial"),
    @NamedQuery(name = "RhVacaciones.findByVacDesde", query = "SELECT r FROM RhVacaciones r WHERE r.vacDesde = :vacDesde"),
    @NamedQuery(name = "RhVacaciones.findByVacHasta", query = "SELECT r FROM RhVacaciones r WHERE r.vacHasta = :vacHasta"),
    @NamedQuery(name = "RhVacaciones.findByVacGozadas", query = "SELECT r FROM RhVacaciones r WHERE r.vacGozadas = :vacGozadas"),
    @NamedQuery(name = "RhVacaciones.findByVacGozadasDesde", query = "SELECT r FROM RhVacaciones r WHERE r.vacGozadasDesde = :vacGozadasDesde"),
    @NamedQuery(name = "RhVacaciones.findByVacGozadasHasta", query = "SELECT r FROM RhVacaciones r WHERE r.vacGozadasHasta = :vacGozadasHasta"),
    @NamedQuery(name = "RhVacaciones.findByVacValor", query = "SELECT r FROM RhVacaciones r WHERE r.vacValor = :vacValor"),
    @NamedQuery(name = "RhVacaciones.findByVacFormaPago", query = "SELECT r FROM RhVacaciones r WHERE r.vacFormaPago = :vacFormaPago"),
    @NamedQuery(name = "RhVacaciones.findByVacReversado", query = "SELECT r FROM RhVacaciones r WHERE r.vacReversado = :vacReversado"),
    @NamedQuery(name = "RhVacaciones.findBySecEmpresa", query = "SELECT r FROM RhVacaciones r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhVacaciones.findBySecCodigo", query = "SELECT r FROM RhVacaciones r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhVacaciones.findByConEmpresa", query = "SELECT r FROM RhVacaciones r WHERE r.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "RhVacaciones.findByConPeriodo", query = "SELECT r FROM RhVacaciones r WHERE r.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "RhVacaciones.findByConTipo", query = "SELECT r FROM RhVacaciones r WHERE r.conTipo = :conTipo"),
    @NamedQuery(name = "RhVacaciones.findByConNumero", query = "SELECT r FROM RhVacaciones r WHERE r.conNumero = :conNumero")})
public class RhVacaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vac_secuencial")
    private Integer vacSecuencial;
    @Basic(optional = false)
    @Column(name = "vac_desde")
    @Temporal(TemporalType.DATE)
    private Date vacDesde;
    @Basic(optional = false)
    @Column(name = "vac_hasta")
    @Temporal(TemporalType.DATE)
    private Date vacHasta;
    @Basic(optional = false)
    @Column(name = "vac_gozadas")
    private boolean vacGozadas;
    @Column(name = "vac_gozadas_desde")
    @Temporal(TemporalType.DATE)
    private Date vacGozadasDesde;
    @Column(name = "vac_gozadas_hasta")
    @Temporal(TemporalType.DATE)
    private Date vacGozadasHasta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vac_valor")
    private BigDecimal vacValor;
    @Basic(optional = false)
    @Column(name = "vac_forma_pago")
    private String vacFormaPago;
    @Basic(optional = false)
    @Column(name = "vac_reversado")
    private boolean vacReversado;
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
    @ManyToOne(optional = false)
    private RhEmpleado rhEmpleado;

    public RhVacaciones() {
    }

    public RhVacaciones(Integer vacSecuencial) {
        this.vacSecuencial = vacSecuencial;
    }

    public RhVacaciones(Integer vacSecuencial, Date vacDesde, Date vacHasta, boolean vacGozadas, BigDecimal vacValor, String vacFormaPago, boolean vacReversado, String secEmpresa, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.vacSecuencial = vacSecuencial;
        this.vacDesde = vacDesde;
        this.vacHasta = vacHasta;
        this.vacGozadas = vacGozadas;
        this.vacValor = vacValor;
        this.vacFormaPago = vacFormaPago;
        this.vacReversado = vacReversado;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
    }

    public Integer getVacSecuencial() {
        return vacSecuencial;
    }

    public void setVacSecuencial(Integer vacSecuencial) {
        this.vacSecuencial = vacSecuencial;
    }

    public Date getVacDesde() {
        return vacDesde;
    }

    public void setVacDesde(Date vacDesde) {
        this.vacDesde = vacDesde;
    }

    public Date getVacHasta() {
        return vacHasta;
    }

    public void setVacHasta(Date vacHasta) {
        this.vacHasta = vacHasta;
    }

    public boolean getVacGozadas() {
        return vacGozadas;
    }

    public void setVacGozadas(boolean vacGozadas) {
        this.vacGozadas = vacGozadas;
    }

    public Date getVacGozadasDesde() {
        return vacGozadasDesde;
    }

    public void setVacGozadasDesde(Date vacGozadasDesde) {
        this.vacGozadasDesde = vacGozadasDesde;
    }

    public Date getVacGozadasHasta() {
        return vacGozadasHasta;
    }

    public void setVacGozadasHasta(Date vacGozadasHasta) {
        this.vacGozadasHasta = vacGozadasHasta;
    }

    public BigDecimal getVacValor() {
        return vacValor;
    }

    public void setVacValor(BigDecimal vacValor) {
        this.vacValor = vacValor;
    }

    public String getVacFormaPago() {
        return vacFormaPago;
    }

    public void setVacFormaPago(String vacFormaPago) {
        this.vacFormaPago = vacFormaPago;
    }

    public boolean getVacReversado() {
        return vacReversado;
    }

    public void setVacReversado(boolean vacReversado) {
        this.vacReversado = vacReversado;
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
        hash += (vacSecuencial != null ? vacSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhVacaciones)) {
            return false;
        }
        RhVacaciones other = (RhVacaciones) object;
        if ((this.vacSecuencial == null && other.vacSecuencial != null) || (this.vacSecuencial != null && !this.vacSecuencial.equals(other.vacSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhVacaciones[ vacSecuencial=" + vacSecuencial + " ]";
    }
}
