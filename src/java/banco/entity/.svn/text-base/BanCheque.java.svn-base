/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "ban_cheque", schema = "banco")
@NamedQueries({
    @NamedQuery(name = "BanCheque.findAll", query = "SELECT b FROM BanCheque b"),
    @NamedQuery(name = "BanCheque.findByChqSecuencia", query = "SELECT b FROM BanCheque b WHERE b.chqSecuencia = :chqSecuencia"),
    @NamedQuery(name = "BanCheque.findByChqBeneficiario", query = "SELECT b FROM BanCheque b WHERE b.chqBeneficiario = :chqBeneficiario"),
    @NamedQuery(name = "BanCheque.findByChqCantidad", query = "SELECT b FROM BanCheque b WHERE b.chqCantidad = :chqCantidad"),
    @NamedQuery(name = "BanCheque.findByChqCiudad", query = "SELECT b FROM BanCheque b WHERE b.chqCiudad = :chqCiudad"),
    @NamedQuery(name = "BanCheque.findByChqFecha", query = "SELECT b FROM BanCheque b WHERE b.chqFecha = :chqFecha"),
    @NamedQuery(name = "BanCheque.findByChqCruzado", query = "SELECT b FROM BanCheque b WHERE b.chqCruzado = :chqCruzado"),
    @NamedQuery(name = "BanCheque.findByChqImpreso", query = "SELECT b FROM BanCheque b WHERE b.chqImpreso = :chqImpreso"),
    @NamedQuery(name = "BanCheque.findByChqImpresoFecha", query = "SELECT b FROM BanCheque b WHERE b.chqImpresoFecha = :chqImpresoFecha"),
    @NamedQuery(name = "BanCheque.findByChqRevisado", query = "SELECT b FROM BanCheque b WHERE b.chqRevisado = :chqRevisado"),
    @NamedQuery(name = "BanCheque.findByChqRevisadoFecha", query = "SELECT b FROM BanCheque b WHERE b.chqRevisadoFecha = :chqRevisadoFecha"),
    @NamedQuery(name = "BanCheque.findByChqRevisadoObservacion", query = "SELECT b FROM BanCheque b WHERE b.chqRevisadoObservacion = :chqRevisadoObservacion"),
    @NamedQuery(name = "BanCheque.findByChqEntregado", query = "SELECT b FROM BanCheque b WHERE b.chqEntregado = :chqEntregado"),
    @NamedQuery(name = "BanCheque.findByChqEntregadoFecha", query = "SELECT b FROM BanCheque b WHERE b.chqEntregadoFecha = :chqEntregadoFecha"),
    @NamedQuery(name = "BanCheque.findByChqEntregadoObservacion", query = "SELECT b FROM BanCheque b WHERE b.chqEntregadoObservacion = :chqEntregadoObservacion"),
    @NamedQuery(name = "BanCheque.findByChqReversado", query = "SELECT b FROM BanCheque b WHERE b.chqReversado = :chqReversado"),
    @NamedQuery(name = "BanCheque.findByChqReversadoFecha", query = "SELECT b FROM BanCheque b WHERE b.chqReversadoFecha = :chqReversadoFecha"),
    @NamedQuery(name = "BanCheque.findByChqReversadoObservacion", query = "SELECT b FROM BanCheque b WHERE b.chqReversadoObservacion = :chqReversadoObservacion"),
    @NamedQuery(name = "BanCheque.findByChqAnulado", query = "SELECT b FROM BanCheque b WHERE b.chqAnulado = :chqAnulado"),
    @NamedQuery(name = "BanCheque.findByChqAnuladoFecha", query = "SELECT b FROM BanCheque b WHERE b.chqAnuladoFecha = :chqAnuladoFecha"),
    @NamedQuery(name = "BanCheque.findByChqAnuladoObservacion", query = "SELECT b FROM BanCheque b WHERE b.chqAnuladoObservacion = :chqAnuladoObservacion"),
    @NamedQuery(name = "BanCheque.findByChqNoEsCheque", query = "SELECT b FROM BanCheque b WHERE b.chqNoEsCheque = :chqNoEsCheque"),
    @NamedQuery(name = "BanCheque.findByConcEmpresa", query = "SELECT b FROM BanCheque b WHERE b.concEmpresa = :concEmpresa"),
    @NamedQuery(name = "BanCheque.findByConcCuentaContable", query = "SELECT b FROM BanCheque b WHERE b.concCuentaContable = :concCuentaContable"),
    @NamedQuery(name = "BanCheque.findByConcCodigo", query = "SELECT b FROM BanCheque b WHERE b.concCodigo = :concCodigo"),
    @NamedQuery(name = "BanCheque.findByDetSecuencia", query = "SELECT b FROM BanCheque b WHERE b.detSecuencia = :detSecuencia")})
public class BanCheque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "chq_secuencia")
    private Long chqSecuencia;
    @Basic(optional = false)
    @Column(name = "chq_beneficiario")
    private String chqBeneficiario;
    @Basic(optional = false)
    @Column(name = "chq_cantidad")
    private String chqCantidad;
    @Basic(optional = false)
    @Column(name = "chq_ciudad")
    private String chqCiudad;
    @Basic(optional = false)
    @Column(name = "chq_fecha")
    @Temporal(TemporalType.DATE)
    private Date chqFecha;
    @Column(name = "chq_cruzado")
    private Boolean chqCruzado;
    @Basic(optional = false)
    @Column(name = "chq_impreso")
    private boolean chqImpreso;
    @Column(name = "chq_impreso_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chqImpresoFecha;
    @Basic(optional = false)
    @Column(name = "chq_revisado")
    private boolean chqRevisado;
    @Column(name = "chq_revisado_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chqRevisadoFecha;
    @Column(name = "chq_revisado_observacion")
    private String chqRevisadoObservacion;
    @Basic(optional = false)
    @Column(name = "chq_entregado")
    private boolean chqEntregado;
    @Column(name = "chq_entregado_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chqEntregadoFecha;
    @Column(name = "chq_entregado_observacion")
    private String chqEntregadoObservacion;
    @Column(name = "chq_reversado")
    private Boolean chqReversado;
    @Column(name = "chq_reversado_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chqReversadoFecha;
    @Column(name = "chq_reversado_observacion")
    private String chqReversadoObservacion;
    @Column(name = "chq_anulado")
    private Boolean chqAnulado;
    @Column(name = "chq_anulado_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chqAnuladoFecha;
    @Column(name = "chq_anulado_observacion")
    private String chqAnuladoObservacion;
    @Column(name = "chq_no_es_cheque")
    private Boolean chqNoEsCheque;
    @Column(name = "conc_empresa")
    private String concEmpresa;
    @Column(name = "conc_cuenta_contable")
    private String concCuentaContable;
    @Column(name = "conc_codigo")
    private String concCodigo;
    @Basic(optional = false)
    @Column(name = "det_secuencia")
    private long detSecuencia;

    public BanCheque() {
    }

    public BanCheque(Long chqSecuencia) {
        this.chqSecuencia = chqSecuencia;
    }

    public BanCheque(Long chqSecuencia, String chqBeneficiario, String chqCantidad, String chqCiudad, Date chqFecha, boolean chqImpreso, boolean chqRevisado, boolean chqEntregado, long detSecuencia) {
        this.chqSecuencia = chqSecuencia;
        this.chqBeneficiario = chqBeneficiario;
        this.chqCantidad = chqCantidad;
        this.chqCiudad = chqCiudad;
        this.chqFecha = chqFecha;
        this.chqImpreso = chqImpreso;
        this.chqRevisado = chqRevisado;
        this.chqEntregado = chqEntregado;
        this.detSecuencia = detSecuencia;
    }

    public Long getChqSecuencia() {
        return chqSecuencia;
    }

    public void setChqSecuencia(Long chqSecuencia) {
        this.chqSecuencia = chqSecuencia;
    }

    public String getChqBeneficiario() {
        return chqBeneficiario;
    }

    public void setChqBeneficiario(String chqBeneficiario) {
        this.chqBeneficiario = chqBeneficiario;
    }

    public String getChqCantidad() {
        return chqCantidad;
    }

    public void setChqCantidad(String chqCantidad) {
        this.chqCantidad = chqCantidad;
    }

    public String getChqCiudad() {
        return chqCiudad;
    }

    public void setChqCiudad(String chqCiudad) {
        this.chqCiudad = chqCiudad;
    }

    public Date getChqFecha() {
        return chqFecha;
    }

    public void setChqFecha(Date chqFecha) {
        this.chqFecha = chqFecha;
    }

    public Boolean getChqCruzado() {
        return chqCruzado;
    }

    public void setChqCruzado(Boolean chqCruzado) {
        this.chqCruzado = chqCruzado;
    }

    public boolean getChqImpreso() {
        return chqImpreso;
    }

    public void setChqImpreso(boolean chqImpreso) {
        this.chqImpreso = chqImpreso;
    }

    public Date getChqImpresoFecha() {
        return chqImpresoFecha;
    }

    public void setChqImpresoFecha(Date chqImpresoFecha) {
        this.chqImpresoFecha = chqImpresoFecha;
    }

    public boolean getChqRevisado() {
        return chqRevisado;
    }

    public void setChqRevisado(boolean chqRevisado) {
        this.chqRevisado = chqRevisado;
    }

    public Date getChqRevisadoFecha() {
        return chqRevisadoFecha;
    }

    public void setChqRevisadoFecha(Date chqRevisadoFecha) {
        this.chqRevisadoFecha = chqRevisadoFecha;
    }

    public String getChqRevisadoObservacion() {
        return chqRevisadoObservacion;
    }

    public void setChqRevisadoObservacion(String chqRevisadoObservacion) {
        this.chqRevisadoObservacion = chqRevisadoObservacion;
    }

    public boolean getChqEntregado() {
        return chqEntregado;
    }

    public void setChqEntregado(boolean chqEntregado) {
        this.chqEntregado = chqEntregado;
    }

    public Date getChqEntregadoFecha() {
        return chqEntregadoFecha;
    }

    public void setChqEntregadoFecha(Date chqEntregadoFecha) {
        this.chqEntregadoFecha = chqEntregadoFecha;
    }

    public String getChqEntregadoObservacion() {
        return chqEntregadoObservacion;
    }

    public void setChqEntregadoObservacion(String chqEntregadoObservacion) {
        this.chqEntregadoObservacion = chqEntregadoObservacion;
    }

    public Boolean getChqReversado() {
        return chqReversado;
    }

    public void setChqReversado(Boolean chqReversado) {
        this.chqReversado = chqReversado;
    }

    public Date getChqReversadoFecha() {
        return chqReversadoFecha;
    }

    public void setChqReversadoFecha(Date chqReversadoFecha) {
        this.chqReversadoFecha = chqReversadoFecha;
    }

    public String getChqReversadoObservacion() {
        return chqReversadoObservacion;
    }

    public void setChqReversadoObservacion(String chqReversadoObservacion) {
        this.chqReversadoObservacion = chqReversadoObservacion;
    }

    public Boolean getChqAnulado() {
        return chqAnulado;
    }

    public void setChqAnulado(Boolean chqAnulado) {
        this.chqAnulado = chqAnulado;
    }

    public Date getChqAnuladoFecha() {
        return chqAnuladoFecha;
    }

    public void setChqAnuladoFecha(Date chqAnuladoFecha) {
        this.chqAnuladoFecha = chqAnuladoFecha;
    }

    public String getChqAnuladoObservacion() {
        return chqAnuladoObservacion;
    }

    public void setChqAnuladoObservacion(String chqAnuladoObservacion) {
        this.chqAnuladoObservacion = chqAnuladoObservacion;
    }

    public Boolean getChqNoEsCheque() {
        return chqNoEsCheque;
    }

    public void setChqNoEsCheque(Boolean chqNoEsCheque) {
        this.chqNoEsCheque = chqNoEsCheque;
    }

    public String getConcEmpresa() {
        return concEmpresa;
    }

    public void setConcEmpresa(String concEmpresa) {
        this.concEmpresa = concEmpresa;
    }

    public String getConcCuentaContable() {
        return concCuentaContable;
    }

    public void setConcCuentaContable(String concCuentaContable) {
        this.concCuentaContable = concCuentaContable;
    }

    public String getConcCodigo() {
        return concCodigo;
    }

    public void setConcCodigo(String concCodigo) {
        this.concCodigo = concCodigo;
    }

    public long getDetSecuencia() {
        return detSecuencia;
    }

    public void setDetSecuencia(long detSecuencia) {
        this.detSecuencia = detSecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chqSecuencia != null ? chqSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BanCheque)) {
            return false;
        }
        BanCheque other = (BanCheque) object;
        if ((this.chqSecuencia == null && other.chqSecuencia != null) || (this.chqSecuencia != null && !this.chqSecuencia.equals(other.chqSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.entity.BanCheque[ chqSecuencia=" + chqSecuencia + " ]";
    }
    
}
