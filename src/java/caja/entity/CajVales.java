/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "caj_vales", schema = "caja")
@NamedQueries({
    @NamedQuery(name = "CajVales.findAll", query = "SELECT c FROM CajVales c"),
    @NamedQuery(name = "CajVales.findByValeEmpresa", query = "SELECT c FROM CajVales c WHERE c.cajValesPK.valeEmpresa = :valeEmpresa"),
    @NamedQuery(name = "CajVales.findByValePeriodo", query = "SELECT c FROM CajVales c WHERE c.cajValesPK.valePeriodo = :valePeriodo"),
    @NamedQuery(name = "CajVales.findByValeMotivo", query = "SELECT c FROM CajVales c WHERE c.cajValesPK.valeMotivo = :valeMotivo"),
    @NamedQuery(name = "CajVales.findByValeNumero", query = "SELECT c FROM CajVales c WHERE c.cajValesPK.valeNumero = :valeNumero"),
    @NamedQuery(name = "CajVales.findByValeFecha", query = "SELECT c FROM CajVales c WHERE c.valeFecha = :valeFecha"),
    @NamedQuery(name = "CajVales.findByValeValor", query = "SELECT c FROM CajVales c WHERE c.valeValor = :valeValor"),
    @NamedQuery(name = "CajVales.findByValeAnulado", query = "SELECT c FROM CajVales c WHERE c.valeAnulado = :valeAnulado"),
    @NamedQuery(name = "CajVales.findByValeBeneficiario", query = "SELECT c FROM CajVales c WHERE c.valeBeneficiario = :valeBeneficiario"),
    @NamedQuery(name = "CajVales.findByValeObservaciones", query = "SELECT c FROM CajVales c WHERE c.valeObservaciones = :valeObservaciones"),
    @NamedQuery(name = "CajVales.findByUsrEmpresa", query = "SELECT c FROM CajVales c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "CajVales.findByUsrCodigo", query = "SELECT c FROM CajVales c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "CajVales.findByUsrFechaInserta", query = "SELECT c FROM CajVales c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class CajVales implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CajValesPK cajValesPK;
    @Basic(optional = false)
    @Column(name = "vale_fecha")
    @Temporal(TemporalType.DATE)
    private Date valeFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vale_valor")
    private BigDecimal valeValor;
    @Basic(optional = false)
    @Column(name = "vale_anulado")
    private boolean valeAnulado;
    @Basic(optional = false)
    @Column(name = "vale_beneficiario")
    private String valeBeneficiario;
    @Basic(optional = false)
    @Column(name = "vale_observaciones")
    private String valeObservaciones;
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
    @JoinColumns({
        @JoinColumn(name = "conc_empresa", referencedColumnName = "conc_empresa"),
        @JoinColumn(name = "conc_codigo", referencedColumnName = "conc_codigo")})
    @ManyToOne(optional = false)
    private CajValesConceptos cajValesConceptos;

    public CajVales() {
    }

    public CajVales(CajValesPK cajValesPK) {
        this.cajValesPK = cajValesPK;
    }

    public CajVales(CajValesPK cajValesPK, Date valeFecha, BigDecimal valeValor, boolean valeAnulado, String valeBeneficiario, String valeObservaciones, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.cajValesPK = cajValesPK;
        this.valeFecha = valeFecha;
        this.valeValor = valeValor;
        this.valeAnulado = valeAnulado;
        this.valeBeneficiario = valeBeneficiario;
        this.valeObservaciones = valeObservaciones;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public CajVales(String valeEmpresa, String valePeriodo, String valeMotivo, String valeNumero) {
        this.cajValesPK = new CajValesPK(valeEmpresa, valePeriodo, valeMotivo, valeNumero);
    }

    public CajValesPK getCajValesPK() {
        return cajValesPK;
    }

    public void setCajValesPK(CajValesPK cajValesPK) {
        this.cajValesPK = cajValesPK;
    }

    public Date getValeFecha() {
        return valeFecha;
    }

    public void setValeFecha(Date valeFecha) {
        this.valeFecha = valeFecha;
    }

    public BigDecimal getValeValor() {
        return valeValor;
    }

    public void setValeValor(BigDecimal valeValor) {
        this.valeValor = valeValor;
    }

    public boolean getValeAnulado() {
        return valeAnulado;
    }

    public void setValeAnulado(boolean valeAnulado) {
        this.valeAnulado = valeAnulado;
    }

    public String getValeBeneficiario() {
        return valeBeneficiario;
    }

    public void setValeBeneficiario(String valeBeneficiario) {
        this.valeBeneficiario = valeBeneficiario;
    }

    public String getValeObservaciones() {
        return valeObservaciones;
    }

    public void setValeObservaciones(String valeObservaciones) {
        this.valeObservaciones = valeObservaciones;
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

    public CajValesConceptos getCajValesConceptos() {
        return cajValesConceptos;
    }

    public void setCajValesConceptos(CajValesConceptos cajValesConceptos) {
        this.cajValesConceptos = cajValesConceptos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajValesPK != null ? cajValesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajVales)) {
            return false;
        }
        CajVales other = (CajVales) object;
        if ((this.cajValesPK == null && other.cajValesPK != null) || (this.cajValesPK != null && !this.cajValesPK.equals(other.cajValesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "caja.entity.CajVales[ cajValesPK=" + cajValesPK + " ]";
    }
    
}
