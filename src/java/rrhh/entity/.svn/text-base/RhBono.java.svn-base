/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "rh_bono", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhBono.findAll", query = "SELECT r FROM RhBono r"),
    @NamedQuery(name = "RhBono.findByBonoSecuencial", query = "SELECT r FROM RhBono r WHERE r.bonoSecuencial = :bonoSecuencial"),
    @NamedQuery(name = "RhBono.findByBonoConcepto", query = "SELECT r FROM RhBono r WHERE r.bonoConcepto = :bonoConcepto"),
    @NamedQuery(name = "RhBono.findByBonoCantidad", query = "SELECT r FROM RhBono r WHERE r.bonoCantidad = :bonoCantidad"),
    @NamedQuery(name = "RhBono.findByBonoPrecio", query = "SELECT r FROM RhBono r WHERE r.bonoPrecio = :bonoPrecio"),
    @NamedQuery(name = "RhBono.findByBonoValor", query = "SELECT r FROM RhBono r WHERE r.bonoValor = :bonoValor"),
    @NamedQuery(name = "RhBono.findByBonoDeducible", query = "SELECT r FROM RhBono r WHERE r.bonoDeducible = :bonoDeducible"),
    @NamedQuery(name = "RhBono.findByBonoObservacion", query = "SELECT r FROM RhBono r WHERE r.bonoObservacion = :bonoObservacion"),
    @NamedQuery(name = "RhBono.findByBonoReversado", query = "SELECT r FROM RhBono r WHERE r.bonoReversado = :bonoReversado"),
    @NamedQuery(name = "RhBono.findBySecEmpresa", query = "SELECT r FROM RhBono r WHERE r.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "RhBono.findBySecCodigo", query = "SELECT r FROM RhBono r WHERE r.secCodigo = :secCodigo"),
    @NamedQuery(name = "RhBono.findByPisEmpresa", query = "SELECT r FROM RhBono r WHERE r.pisEmpresa = :pisEmpresa"),
    @NamedQuery(name = "RhBono.findByPisSector", query = "SELECT r FROM RhBono r WHERE r.pisSector = :pisSector"),
    @NamedQuery(name = "RhBono.findByPisNumero", query = "SELECT r FROM RhBono r WHERE r.pisNumero = :pisNumero"),
    @NamedQuery(name = "RhBono.findByConEmpresa", query = "SELECT r FROM RhBono r WHERE r.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "RhBono.findByConPeriodo", query = "SELECT r FROM RhBono r WHERE r.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "RhBono.findByConTipo", query = "SELECT r FROM RhBono r WHERE r.conTipo = :conTipo"),
    @NamedQuery(name = "RhBono.findByConNumero", query = "SELECT r FROM RhBono r WHERE r.conNumero = :conNumero")})
public class RhBono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bono_secuencial")
    private Integer bonoSecuencial;
    @Basic(optional = false)
    @Column(name = "bono_concepto")
    private String bonoConcepto;
    @Basic(optional = false)
    @Column(name = "bono_cantidad")
    private short bonoCantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "bono_precio")
    private BigDecimal bonoPrecio;
    @Basic(optional = false)
    @Column(name = "bono_valor")
    private BigDecimal bonoValor;
    @Basic(optional = false)
    @Column(name = "bono_deducible")
    private boolean bonoDeducible;
    @Column(name = "bono_observacion")
    private String bonoObservacion;
    @Basic(optional = false)
    @Column(name = "bono_reversado")
    private boolean bonoReversado;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
    @Column(name = "pis_empresa")
    private String pisEmpresa;
    @Column(name = "pis_sector")
    private String pisSector;
    @Column(name = "pis_numero")
    private String pisNumero;
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

    public RhBono() {
    }

    public RhBono(Integer bonoSecuencial) {
        this.bonoSecuencial = bonoSecuencial;
    }

    public RhBono(Integer bonoSecuencial, String bonoConcepto, short bonoCantidad, BigDecimal bonoPrecio, BigDecimal bonoValor, boolean bonoDeducible, boolean bonoReversado, String secEmpresa, String secCodigo, String conEmpresa, String conPeriodo, String conTipo, String conNumero) {
        this.bonoSecuencial = bonoSecuencial;
        this.bonoConcepto = bonoConcepto;
        this.bonoCantidad = bonoCantidad;
        this.bonoPrecio = bonoPrecio;
        this.bonoValor = bonoValor;
        this.bonoDeducible = bonoDeducible;
        this.bonoReversado = bonoReversado;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
    }

    public Integer getBonoSecuencial() {
        return bonoSecuencial;
    }

    public void setBonoSecuencial(Integer bonoSecuencial) {
        this.bonoSecuencial = bonoSecuencial;
    }

    public String getBonoConcepto() {
        return bonoConcepto;
    }

    public void setBonoConcepto(String bonoConcepto) {
        this.bonoConcepto = bonoConcepto;
    }

    public short getBonoCantidad() {
        return bonoCantidad;
    }

    public void setBonoCantidad(short bonoCantidad) {
        this.bonoCantidad = bonoCantidad;
    }

    public BigDecimal getBonoPrecio() {
        return bonoPrecio;
    }

    public void setBonoPrecio(BigDecimal bonoPrecio) {
        this.bonoPrecio = bonoPrecio;
    }

    public BigDecimal getBonoValor() {
        return bonoValor;
    }

    public void setBonoValor(BigDecimal bonoValor) {
        this.bonoValor = bonoValor;
    }

    public boolean getBonoDeducible() {
        return bonoDeducible;
    }

    public void setBonoDeducible(boolean bonoDeducible) {
        this.bonoDeducible = bonoDeducible;
    }

    public String getBonoObservacion() {
        return bonoObservacion;
    }

    public void setBonoObservacion(String bonoObservacion) {
        this.bonoObservacion = bonoObservacion;
    }

    public boolean getBonoReversado() {
        return bonoReversado;
    }

    public void setBonoReversado(boolean bonoReversado) {
        this.bonoReversado = bonoReversado;
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

    public String getPisEmpresa() {
        return pisEmpresa;
    }

    public void setPisEmpresa(String pisEmpresa) {
        this.pisEmpresa = pisEmpresa;
    }

    public String getPisSector() {
        return pisSector;
    }

    public void setPisSector(String pisSector) {
        this.pisSector = pisSector;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
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
        hash += (bonoSecuencial != null ? bonoSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhBono)) {
            return false;
        }
        RhBono other = (RhBono) object;
        if ((this.bonoSecuencial == null && other.bonoSecuencial != null) || (this.bonoSecuencial != null && !this.bonoSecuencial.equals(other.bonoSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhBono[ bonoSecuencial=" + bonoSecuencial + " ]";
    }
}
