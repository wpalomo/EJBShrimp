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
@Table(name = "rh_empleado_descuentos_fijos", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhEmpleadoDescuentosFijos.findAll", query = "SELECT r FROM RhEmpleadoDescuentosFijos r"),
    @NamedQuery(name = "RhEmpleadoDescuentosFijos.findByDescSecuencial", query = "SELECT r FROM RhEmpleadoDescuentosFijos r WHERE r.descSecuencial = :descSecuencial"),
    @NamedQuery(name = "RhEmpleadoDescuentosFijos.findByDescValor", query = "SELECT r FROM RhEmpleadoDescuentosFijos r WHERE r.descValor = :descValor")})
public class RhEmpleadoDescuentosFijos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desc_secuencial")
    private Integer descSecuencial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "desc_valor")
    private BigDecimal descValor;
    @JoinColumns({
        @JoinColumn(name = "emp_empresa", referencedColumnName = "emp_empresa"),
        @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")})
    @ManyToOne(optional = false)
    private RhEmpleado rhEmpleado;
    @JoinColumns({
        @JoinColumn(name = "mot_empresa", referencedColumnName = "mot_empresa"),
        @JoinColumn(name = "mot_detalle", referencedColumnName = "mot_detalle")})
    @ManyToOne(optional = false)
    private RhAnticipoMotivo rhAnticipoMotivo;

    public RhEmpleadoDescuentosFijos() {
    }

    public RhEmpleadoDescuentosFijos(Integer descSecuencial) {
        this.descSecuencial = descSecuencial;
    }

    public RhEmpleadoDescuentosFijos(Integer descSecuencial, BigDecimal descValor) {
        this.descSecuencial = descSecuencial;
        this.descValor = descValor;
    }

    public Integer getDescSecuencial() {
        return descSecuencial;
    }

    public void setDescSecuencial(Integer descSecuencial) {
        this.descSecuencial = descSecuencial;
    }

    public BigDecimal getDescValor() {
        return descValor;
    }

    public void setDescValor(BigDecimal descValor) {
        this.descValor = descValor;
    }

    public RhEmpleado getRhEmpleado() {
        return rhEmpleado;
    }

    public void setRhEmpleado(RhEmpleado rhEmpleado) {
        this.rhEmpleado = rhEmpleado;
    }

    public RhAnticipoMotivo getRhAnticipoMotivo() {
        return rhAnticipoMotivo;
    }

    public void setRhAnticipoMotivo(RhAnticipoMotivo rhAnticipoMotivo) {
        this.rhAnticipoMotivo = rhAnticipoMotivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descSecuencial != null ? descSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhEmpleadoDescuentosFijos)) {
            return false;
        }
        RhEmpleadoDescuentosFijos other = (RhEmpleadoDescuentosFijos) object;
        if ((this.descSecuencial == null && other.descSecuencial != null) || (this.descSecuencial != null && !this.descSecuencial.equals(other.descSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhEmpleadoDescuentosFijos[ descSecuencial=" + descSecuencial + " ]";
    }
}
