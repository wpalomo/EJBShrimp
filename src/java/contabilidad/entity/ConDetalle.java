/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "con_detalle", schema = "contabilidad")
@NamedQueries({
    @NamedQuery(name = "ConDetalle.findAll", query = "SELECT c FROM ConDetalle c"),
    @NamedQuery(name = "ConDetalle.findByDetSecuencia", query = "SELECT c FROM ConDetalle c WHERE c.detSecuencia = :detSecuencia"),
    @NamedQuery(name = "ConDetalle.findByDetDocumento", query = "SELECT c FROM ConDetalle c WHERE c.detDocumento = :detDocumento"),
    @NamedQuery(name = "ConDetalle.findByDetDebitoCredito", query = "SELECT c FROM ConDetalle c WHERE c.detDebitoCredito = :detDebitoCredito"),
    @NamedQuery(name = "ConDetalle.findByDetValor", query = "SELECT c FROM ConDetalle c WHERE c.detValor = :detValor"),
    @NamedQuery(name = "ConDetalle.findByDetSaldo", query = "SELECT c FROM ConDetalle c WHERE c.detSaldo = :detSaldo"),
    @NamedQuery(name = "ConDetalle.findByDetGenerado", query = "SELECT c FROM ConDetalle c WHERE c.detGenerado = :detGenerado"),
    @NamedQuery(name = "ConDetalle.findByDetReferencia", query = "SELECT c FROM ConDetalle c WHERE c.detReferencia = :detReferencia"),
    @NamedQuery(name = "ConDetalle.findByDetObservaciones", query = "SELECT c FROM ConDetalle c WHERE c.detObservaciones = :detObservaciones"),
    @NamedQuery(name = "ConDetalle.findByDetOrden", query = "SELECT c FROM ConDetalle c WHERE c.detOrden = :detOrden"),
    @NamedQuery(name = "ConDetalle.findBySecEmpresa", query = "SELECT c FROM ConDetalle c WHERE c.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "ConDetalle.findBySecCodigo", query = "SELECT c FROM ConDetalle c WHERE c.secCodigo = :secCodigo"),
    @NamedQuery(name = "ConDetalle.findByPisEmpresa", query = "SELECT c FROM ConDetalle c WHERE c.pisEmpresa = :pisEmpresa"),
    @NamedQuery(name = "ConDetalle.findByPisSector", query = "SELECT c FROM ConDetalle c WHERE c.pisSector = :pisSector"),
    @NamedQuery(name = "ConDetalle.findByPisNumero", query = "SELECT c FROM ConDetalle c WHERE c.pisNumero = :pisNumero")})
public class ConDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_secuencia")
    private Integer detSecuencia;
    @Column(name = "det_documento")
    private String detDocumento;
    @Basic(optional = false)
    @Column(name = "det_debito_credito")
    private char detDebitoCredito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "det_valor")
    private BigDecimal detValor;
    @Basic(optional = false)
    @Column(name = "det_saldo")
    private BigDecimal detSaldo;
    @Basic(optional = false)
    @Column(name = "det_generado")
    private boolean detGenerado;
    @Column(name = "det_referencia")
    private String detReferencia;
    @Column(name = "det_observaciones")
    private String detObservaciones;
    @Basic(optional = false)
    @Column(name = "det_orden")
    private int detOrden;
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
    @JoinColumns({
        @JoinColumn(name = "cta_empresa", referencedColumnName = "cta_empresa"),
        @JoinColumn(name = "cta_codigo", referencedColumnName = "cta_codigo")})
    @ManyToOne(optional = false)
    private ConCuentas conCuentas;
    @JoinColumns({
        @JoinColumn(name = "con_empresa", referencedColumnName = "con_empresa"),
        @JoinColumn(name = "con_periodo", referencedColumnName = "con_periodo"),
        @JoinColumn(name = "con_tipo", referencedColumnName = "con_tipo"),
        @JoinColumn(name = "con_numero", referencedColumnName = "con_numero")})
    @ManyToOne(optional = false)
    private ConContable conContable;

    public ConDetalle() {
    }

    public ConDetalle(Integer detSecuencia) {
        this.detSecuencia = detSecuencia;
    }

    public ConDetalle(Integer detSecuencia, char detDebitoCredito, BigDecimal detValor, BigDecimal detSaldo, boolean detGenerado, int detOrden, String secEmpresa, String secCodigo) {
        this.detSecuencia = detSecuencia;
        this.detDebitoCredito = detDebitoCredito;
        this.detValor = detValor;
        this.detSaldo = detSaldo;
        this.detGenerado = detGenerado;
        this.detOrden = detOrden;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
    }

    public Integer getDetSecuencia() {
        return detSecuencia;
    }

    public void setDetSecuencia(Integer detSecuencia) {
        this.detSecuencia = detSecuencia;
    }

    public String getDetDocumento() {
        return detDocumento;
    }

    public void setDetDocumento(String detDocumento) {
        this.detDocumento = detDocumento;
    }

    public char getDetDebitoCredito() {
        return detDebitoCredito;
    }

    public void setDetDebitoCredito(char detDebitoCredito) {
        this.detDebitoCredito = detDebitoCredito;
    }

    public BigDecimal getDetValor() {
        return detValor;
    }

    public void setDetValor(BigDecimal detValor) {
        this.detValor = detValor;
    }

    public BigDecimal getDetSaldo() {
        return detSaldo;
    }

    public void setDetSaldo(BigDecimal detSaldo) {
        this.detSaldo = detSaldo;
    }

    public boolean getDetGenerado() {
        return detGenerado;
    }

    public void setDetGenerado(boolean detGenerado) {
        this.detGenerado = detGenerado;
    }

    public String getDetReferencia() {
        return detReferencia;
    }

    public void setDetReferencia(String detReferencia) {
        this.detReferencia = detReferencia;
    }

    public String getDetObservaciones() {
        return detObservaciones;
    }

    public void setDetObservaciones(String detObservaciones) {
        this.detObservaciones = detObservaciones;
    }

    public int getDetOrden() {
        return detOrden;
    }

    public void setDetOrden(int detOrden) {
        this.detOrden = detOrden;
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

    public ConCuentas getConCuentas() {
        return conCuentas;
    }

    public void setConCuentas(ConCuentas conCuentas) {
        this.conCuentas = conCuentas;
    }

    public ConContable getConContable() {
        return conContable;
    }

    public void setConContable(ConContable conContable) {
        this.conContable = conContable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detSecuencia != null ? detSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConDetalle)) {
            return false;
        }
        ConDetalle other = (ConDetalle) object;
        if ((this.detSecuencia == null && other.detSecuencia != null) || (this.detSecuencia != null && !this.detSecuencia.equals(other.detSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConDetalle[ detSecuencia=" + detSecuencia + " ]";
    }
    
}
