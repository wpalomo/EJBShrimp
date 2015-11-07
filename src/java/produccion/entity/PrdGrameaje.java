/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "prd_grameaje", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdGrameaje.findAll", query = "SELECT p FROM PrdGrameaje p"),
    @NamedQuery(name = "PrdGrameaje.findByGraEmpresa", query = "SELECT p FROM PrdGrameaje p WHERE p.prdGrameajePK.graEmpresa = :graEmpresa"),
    @NamedQuery(name = "PrdGrameaje.findByGraSector", query = "SELECT p FROM PrdGrameaje p WHERE p.prdGrameajePK.graSector = :graSector"),
    @NamedQuery(name = "PrdGrameaje.findByGraPiscina", query = "SELECT p FROM PrdGrameaje p WHERE p.prdGrameajePK.graPiscina = :graPiscina"),
    @NamedQuery(name = "PrdGrameaje.findByGraFecha", query = "SELECT p FROM PrdGrameaje p WHERE p.prdGrameajePK.graFecha = :graFecha"),
    @NamedQuery(name = "PrdGrameaje.findByGraTgrande", query = "SELECT p FROM PrdGrameaje p WHERE p.graTgrande = :graTgrande"),
    @NamedQuery(name = "PrdGrameaje.findByGraTmediano", query = "SELECT p FROM PrdGrameaje p WHERE p.graTmediano = :graTmediano"),
    @NamedQuery(name = "PrdGrameaje.findByGraTpequeno", query = "SELECT p FROM PrdGrameaje p WHERE p.graTpequeno = :graTpequeno"),
    @NamedQuery(name = "PrdGrameaje.findByGraTpromedio", query = "SELECT p FROM PrdGrameaje p WHERE p.graTpromedio = :graTpromedio"),
    @NamedQuery(name = "PrdGrameaje.findByGraItgrande", query = "SELECT p FROM PrdGrameaje p WHERE p.graItgrande = :graItgrande"),
    @NamedQuery(name = "PrdGrameaje.findByGraItmediano", query = "SELECT p FROM PrdGrameaje p WHERE p.graItmediano = :graItmediano"),
    @NamedQuery(name = "PrdGrameaje.findByGraItpequeno", query = "SELECT p FROM PrdGrameaje p WHERE p.graItpequeno = :graItpequeno"),
    @NamedQuery(name = "PrdGrameaje.findByGraIpromedio", query = "SELECT p FROM PrdGrameaje p WHERE p.graIpromedio = :graIpromedio"),
    @NamedQuery(name = "PrdGrameaje.findByGraBiomasa", query = "SELECT p FROM PrdGrameaje p WHERE p.graBiomasa = :graBiomasa"),
    @NamedQuery(name = "PrdGrameaje.findByGraSobrevivencia", query = "SELECT p FROM PrdGrameaje p WHERE p.graSobrevivencia = :graSobrevivencia"),
    @NamedQuery(name = "PrdGrameaje.findByGraAlimentacion", query = "SELECT p FROM PrdGrameaje p WHERE p.graAlimentacion = :graAlimentacion"),
    @NamedQuery(name = "PrdGrameaje.findByGraLibrasBalanceado", query = "SELECT p FROM PrdGrameaje p WHERE p.graLibrasBalanceado = :graLibrasBalanceado"),
    @NamedQuery(name = "PrdGrameaje.findByGraCostoDirecto", query = "SELECT p FROM PrdGrameaje p WHERE p.graCostoDirecto = :graCostoDirecto"),
    @NamedQuery(name = "PrdGrameaje.findByGraCostoIndirecto", query = "SELECT p FROM PrdGrameaje p WHERE p.graCostoIndirecto = :graCostoIndirecto"),
    @NamedQuery(name = "PrdGrameaje.findByGraComentario", query = "SELECT p FROM PrdGrameaje p WHERE p.graComentario = :graComentario"),
    @NamedQuery(name = "PrdGrameaje.findByGraAnulado", query = "SELECT p FROM PrdGrameaje p WHERE p.graAnulado = :graAnulado"),
    @NamedQuery(name = "PrdGrameaje.findByUsrEmpresa", query = "SELECT p FROM PrdGrameaje p WHERE p.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "PrdGrameaje.findByUsrCodigo", query = "SELECT p FROM PrdGrameaje p WHERE p.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "PrdGrameaje.findByUsrFechaInserta", query = "SELECT p FROM PrdGrameaje p WHERE p.usrFechaInserta = :usrFechaInserta")})
public class PrdGrameaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrdGrameajePK prdGrameajePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "gra_tgrande")
    private BigDecimal graTgrande;
    @Column(name = "gra_tmediano")
    private BigDecimal graTmediano;
    @Column(name = "gra_tpequeno")
    private BigDecimal graTpequeno;
    @Column(name = "gra_tpromedio")
    private BigDecimal graTpromedio;
    @Column(name = "gra_itgrande")
    private BigDecimal graItgrande;
    @Column(name = "gra_itmediano")
    private BigDecimal graItmediano;
    @Column(name = "gra_itpequeno")
    private BigDecimal graItpequeno;
    @Column(name = "gra_ipromedio")
    private BigDecimal graIpromedio;
    @Column(name = "gra_biomasa")
    private BigDecimal graBiomasa;
    @Column(name = "gra_sobrevivencia")
    private BigDecimal graSobrevivencia;
    @Column(name = "gra_alimentacion")
    private BigDecimal graAlimentacion;
    @Column(name = "gra_libras_balanceado")
    private BigDecimal graLibrasBalanceado;
    @Column(name = "gra_costo_directo")
    private BigDecimal graCostoDirecto;
    @Column(name = "gra_costo_indirecto")
    private BigDecimal graCostoIndirecto;
    @Column(name = "gra_comentario")
    private String graComentario;
    @Column(name = "gra_anulado")
    private Boolean graAnulado;
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
        @JoinColumn(name = "pis_empresa", referencedColumnName = "pis_empresa"),
        @JoinColumn(name = "pis_sector", referencedColumnName = "pis_sector"),
        @JoinColumn(name = "pis_numero", referencedColumnName = "pis_numero")})
    @ManyToOne(optional = false)
    private PrdPiscina prdPiscina;

    public PrdGrameaje() {
    }

    public PrdGrameaje(PrdGrameajePK prdGrameajePK) {
        this.prdGrameajePK = prdGrameajePK;
    }

    public PrdGrameaje(PrdGrameajePK prdGrameajePK, BigDecimal graTgrande, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.prdGrameajePK = prdGrameajePK;
        this.graTgrande = graTgrande;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public PrdGrameaje(String graEmpresa, String graSector, String graPiscina, Date graFecha) {
        this.prdGrameajePK = new PrdGrameajePK(graEmpresa, graSector, graPiscina, graFecha);
    }

    public PrdGrameajePK getPrdGrameajePK() {
        return prdGrameajePK;
    }

    public void setPrdGrameajePK(PrdGrameajePK prdGrameajePK) {
        this.prdGrameajePK = prdGrameajePK;
    }

    public BigDecimal getGraTgrande() {
        return graTgrande;
    }

    public void setGraTgrande(BigDecimal graTgrande) {
        this.graTgrande = graTgrande;
    }

    public BigDecimal getGraTmediano() {
        return graTmediano;
    }

    public void setGraTmediano(BigDecimal graTmediano) {
        this.graTmediano = graTmediano;
    }

    public BigDecimal getGraTpequeno() {
        return graTpequeno;
    }

    public void setGraTpequeno(BigDecimal graTpequeno) {
        this.graTpequeno = graTpequeno;
    }

    public BigDecimal getGraTpromedio() {
        return graTpromedio;
    }

    public void setGraTpromedio(BigDecimal graTpromedio) {
        this.graTpromedio = graTpromedio;
    }

    public BigDecimal getGraItgrande() {
        return graItgrande;
    }

    public void setGraItgrande(BigDecimal graItgrande) {
        this.graItgrande = graItgrande;
    }

    public BigDecimal getGraItmediano() {
        return graItmediano;
    }

    public void setGraItmediano(BigDecimal graItmediano) {
        this.graItmediano = graItmediano;
    }

    public BigDecimal getGraItpequeno() {
        return graItpequeno;
    }

    public void setGraItpequeno(BigDecimal graItpequeno) {
        this.graItpequeno = graItpequeno;
    }

    public BigDecimal getGraIpromedio() {
        return graIpromedio;
    }

    public void setGraIpromedio(BigDecimal graIpromedio) {
        this.graIpromedio = graIpromedio;
    }

    public BigDecimal getGraBiomasa() {
        return graBiomasa;
    }

    public void setGraBiomasa(BigDecimal graBiomasa) {
        this.graBiomasa = graBiomasa;
    }

    public BigDecimal getGraSobrevivencia() {
        return graSobrevivencia;
    }

    public void setGraSobrevivencia(BigDecimal graSobrevivencia) {
        this.graSobrevivencia = graSobrevivencia;
    }

    public BigDecimal getGraAlimentacion() {
        return graAlimentacion;
    }

    public void setGraAlimentacion(BigDecimal graAlimentacion) {
        this.graAlimentacion = graAlimentacion;
    }

    public BigDecimal getGraLibrasBalanceado() {
        return graLibrasBalanceado;
    }

    public void setGraLibrasBalanceado(BigDecimal graLibrasBalanceado) {
        this.graLibrasBalanceado = graLibrasBalanceado;
    }

    public BigDecimal getGraCostoDirecto() {
        return graCostoDirecto;
    }

    public void setGraCostoDirecto(BigDecimal graCostoDirecto) {
        this.graCostoDirecto = graCostoDirecto;
    }

    public BigDecimal getGraCostoIndirecto() {
        return graCostoIndirecto;
    }

    public void setGraCostoIndirecto(BigDecimal graCostoIndirecto) {
        this.graCostoIndirecto = graCostoIndirecto;
    }

    public String getGraComentario() {
        return graComentario;
    }

    public void setGraComentario(String graComentario) {
        this.graComentario = graComentario;
    }

    public Boolean getGraAnulado() {
        return graAnulado;
    }

    public void setGraAnulado(Boolean graAnulado) {
        this.graAnulado = graAnulado;
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

    public PrdPiscina getPrdPiscina() {
        return prdPiscina;
    }

    public void setPrdPiscina(PrdPiscina prdPiscina) {
        this.prdPiscina = prdPiscina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdGrameajePK != null ? prdGrameajePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdGrameaje)) {
            return false;
        }
        PrdGrameaje other = (PrdGrameaje) object;
        if ((this.prdGrameajePK == null && other.prdGrameajePK != null) || (this.prdGrameajePK != null && !this.prdGrameajePK.equals(other.prdGrameajePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdGrameaje[ prdGrameajePK=" + prdGrameajePK + " ]";
    }
    
}
