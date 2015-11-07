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
@Table(name = "rh_bono_concepto", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhBonoConcepto.findAll", query = "SELECT r FROM RhBonoConcepto r"),
    @NamedQuery(name = "RhBonoConcepto.findByBcSecuencial", query = "SELECT r FROM RhBonoConcepto r WHERE r.bcSecuencial = :bcSecuencial"),
    @NamedQuery(name = "RhBonoConcepto.findByBcDetalle", query = "SELECT r FROM RhBonoConcepto r WHERE r.bcDetalle = :bcDetalle"),
    @NamedQuery(name = "RhBonoConcepto.findByBcValor", query = "SELECT r FROM RhBonoConcepto r WHERE r.bcValor = :bcValor"),
    @NamedQuery(name = "RhBonoConcepto.findByBcValorFijo", query = "SELECT r FROM RhBonoConcepto r WHERE r.bcValorFijo = :bcValorFijo"),
    @NamedQuery(name = "RhBonoConcepto.findByBcInactivo", query = "SELECT r FROM RhBonoConcepto r WHERE r.bcInactivo = :bcInactivo"),
    @NamedQuery(name = "RhBonoConcepto.findByUsrEmpresa", query = "SELECT r FROM RhBonoConcepto r WHERE r.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "RhBonoConcepto.findByUsrCodigo", query = "SELECT r FROM RhBonoConcepto r WHERE r.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "RhBonoConcepto.findByUsrFechaInserta", query = "SELECT r FROM RhBonoConcepto r WHERE r.usrFechaInserta = :usrFechaInserta")})
public class RhBonoConcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bc_secuencial")
    private Integer bcSecuencial;
    @Basic(optional = false)
    @Column(name = "bc_detalle")
    private String bcDetalle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "bc_valor")
    private BigDecimal bcValor;
    @Basic(optional = false)
    @Column(name = "bc_valor_fijo")
    private boolean bcValorFijo;
    @Basic(optional = false)
    @Column(name = "bc_inactivo")
    private boolean bcInactivo;
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

    public RhBonoConcepto() {
    }

    public RhBonoConcepto(Integer bcSecuencial) {
        this.bcSecuencial = bcSecuencial;
    }

    public RhBonoConcepto(Integer bcSecuencial, String bcDetalle, BigDecimal bcValor, boolean bcValorFijo, boolean bcInactivo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.bcSecuencial = bcSecuencial;
        this.bcDetalle = bcDetalle;
        this.bcValor = bcValor;
        this.bcValorFijo = bcValorFijo;
        this.bcInactivo = bcInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Integer getBcSecuencial() {
        return bcSecuencial;
    }

    public void setBcSecuencial(Integer bcSecuencial) {
        this.bcSecuencial = bcSecuencial;
    }

    public String getBcDetalle() {
        return bcDetalle;
    }

    public void setBcDetalle(String bcDetalle) {
        this.bcDetalle = bcDetalle;
    }

    public BigDecimal getBcValor() {
        return bcValor;
    }

    public void setBcValor(BigDecimal bcValor) {
        this.bcValor = bcValor;
    }

    public boolean getBcValorFijo() {
        return bcValorFijo;
    }

    public void setBcValorFijo(boolean bcValorFijo) {
        this.bcValorFijo = bcValorFijo;
    }

    public boolean getBcInactivo() {
        return bcInactivo;
    }

    public void setBcInactivo(boolean bcInactivo) {
        this.bcInactivo = bcInactivo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bcSecuencial != null ? bcSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhBonoConcepto)) {
            return false;
        }
        RhBonoConcepto other = (RhBonoConcepto) object;
        if ((this.bcSecuencial == null && other.bcSecuencial != null) || (this.bcSecuencial != null && !this.bcSecuencial.equals(other.bcSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhBonoConcepto[ bcSecuencial=" + bcSecuencial + " ]";
    }
}
