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
@Table(name = "prd_corrida", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdCorrida.findAll", query = "SELECT p FROM PrdCorrida p"),
    @NamedQuery(name = "PrdCorrida.findByCorEmpresa", query = "SELECT p FROM PrdCorrida p WHERE p.prdCorridaPK.corEmpresa = :corEmpresa"),
    @NamedQuery(name = "PrdCorrida.findByCorSector", query = "SELECT p FROM PrdCorrida p WHERE p.prdCorridaPK.corSector = :corSector"),
    @NamedQuery(name = "PrdCorrida.findByCorPiscina", query = "SELECT p FROM PrdCorrida p WHERE p.prdCorridaPK.corPiscina = :corPiscina"),
    @NamedQuery(name = "PrdCorrida.findByCorNumero", query = "SELECT p FROM PrdCorrida p WHERE p.prdCorridaPK.corNumero = :corNumero"),
    @NamedQuery(name = "PrdCorrida.findByCorHectareas", query = "SELECT p FROM PrdCorrida p WHERE p.corHectareas = :corHectareas"),
    @NamedQuery(name = "PrdCorrida.findByCorFechaDesde", query = "SELECT p FROM PrdCorrida p WHERE p.corFechaDesde = :corFechaDesde"),
    @NamedQuery(name = "PrdCorrida.findByCorFechaSiembra", query = "SELECT p FROM PrdCorrida p WHERE p.corFechaSiembra = :corFechaSiembra"),
    @NamedQuery(name = "PrdCorrida.findByCorFechaPesca", query = "SELECT p FROM PrdCorrida p WHERE p.corFechaPesca = :corFechaPesca"),
    @NamedQuery(name = "PrdCorrida.findByCorFechaHasta", query = "SELECT p FROM PrdCorrida p WHERE p.corFechaHasta = :corFechaHasta"),
    @NamedQuery(name = "PrdCorrida.findByCorNumeroLarvas", query = "SELECT p FROM PrdCorrida p WHERE p.corNumeroLarvas = :corNumeroLarvas"),
    @NamedQuery(name = "PrdCorrida.findByCorLaboratorio", query = "SELECT p FROM PrdCorrida p WHERE p.corLaboratorio = :corLaboratorio"),
    @NamedQuery(name = "PrdCorrida.findByCorNauplio", query = "SELECT p FROM PrdCorrida p WHERE p.corNauplio = :corNauplio"),
    @NamedQuery(name = "PrdCorrida.findByCorPellet", query = "SELECT p FROM PrdCorrida p WHERE p.corPellet = :corPellet"),
    @NamedQuery(name = "PrdCorrida.findByCorBiomasa", query = "SELECT p FROM PrdCorrida p WHERE p.corBiomasa = :corBiomasa"),
    @NamedQuery(name = "PrdCorrida.findByCorValorVenta", query = "SELECT p FROM PrdCorrida p WHERE p.corValorVenta = :corValorVenta"),
    @NamedQuery(name = "PrdCorrida.findByCorObservaciones", query = "SELECT p FROM PrdCorrida p WHERE p.corObservaciones = :corObservaciones"),
    @NamedQuery(name = "PrdCorrida.findByCorActiva", query = "SELECT p FROM PrdCorrida p WHERE p.corActiva = :corActiva"),
    @NamedQuery(name = "PrdCorrida.findByUsrEmpresa", query = "SELECT p FROM PrdCorrida p WHERE p.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "PrdCorrida.findByUsrCodigo", query = "SELECT p FROM PrdCorrida p WHERE p.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "PrdCorrida.findByUsrFechaInserta", query = "SELECT p FROM PrdCorrida p WHERE p.usrFechaInserta = :usrFechaInserta")})
public class PrdCorrida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrdCorridaPK prdCorridaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cor_hectareas")
    private BigDecimal corHectareas;
    @Basic(optional = false)
    @Column(name = "cor_fecha_desde")
    @Temporal(TemporalType.DATE)
    private Date corFechaDesde;
    @Column(name = "cor_fecha_siembra")
    @Temporal(TemporalType.DATE)
    private Date corFechaSiembra;
    @Column(name = "cor_fecha_pesca")
    @Temporal(TemporalType.DATE)
    private Date corFechaPesca;
    @Column(name = "cor_fecha_hasta")
    @Temporal(TemporalType.DATE)
    private Date corFechaHasta;
    @Column(name = "cor_numero_larvas")
    private Integer corNumeroLarvas;
    @Column(name = "cor_laboratorio")
    private String corLaboratorio;
    @Column(name = "cor_nauplio")
    private String corNauplio;
    @Column(name = "cor_pellet")
    private Short corPellet;
    @Column(name = "cor_biomasa")
    private BigDecimal corBiomasa;
    @Column(name = "cor_valor_venta")
    private BigDecimal corValorVenta;
    @Column(name = "cor_observaciones")
    private String corObservaciones;
    @Column(name = "cor_activa")
    private Boolean corActiva;
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

    public PrdCorrida() {
    }

    public PrdCorrida(PrdCorridaPK prdCorridaPK) {
        this.prdCorridaPK = prdCorridaPK;
    }

    public PrdCorrida(PrdCorridaPK prdCorridaPK, Date corFechaDesde, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.prdCorridaPK = prdCorridaPK;
        this.corFechaDesde = corFechaDesde;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public PrdCorrida(String corEmpresa, String corSector, String corPiscina, String corNumero) {
        this.prdCorridaPK = new PrdCorridaPK(corEmpresa, corSector, corPiscina, corNumero);
    }

    public PrdCorridaPK getPrdCorridaPK() {
        return prdCorridaPK;
    }

    public void setPrdCorridaPK(PrdCorridaPK prdCorridaPK) {
        this.prdCorridaPK = prdCorridaPK;
    }

    public BigDecimal getCorHectareas() {
        return corHectareas;
    }

    public void setCorHectareas(BigDecimal corHectareas) {
        this.corHectareas = corHectareas;
    }

    public Date getCorFechaDesde() {
        return corFechaDesde;
    }

    public void setCorFechaDesde(Date corFechaDesde) {
        this.corFechaDesde = corFechaDesde;
    }

    public Date getCorFechaSiembra() {
        return corFechaSiembra;
    }

    public void setCorFechaSiembra(Date corFechaSiembra) {
        this.corFechaSiembra = corFechaSiembra;
    }

    public Date getCorFechaPesca() {
        return corFechaPesca;
    }

    public void setCorFechaPesca(Date corFechaPesca) {
        this.corFechaPesca = corFechaPesca;
    }

    public Date getCorFechaHasta() {
        return corFechaHasta;
    }

    public void setCorFechaHasta(Date corFechaHasta) {
        this.corFechaHasta = corFechaHasta;
    }

    public Integer getCorNumeroLarvas() {
        return corNumeroLarvas;
    }

    public void setCorNumeroLarvas(Integer corNumeroLarvas) {
        this.corNumeroLarvas = corNumeroLarvas;
    }

    public String getCorLaboratorio() {
        return corLaboratorio;
    }

    public void setCorLaboratorio(String corLaboratorio) {
        this.corLaboratorio = corLaboratorio;
    }

    public String getCorNauplio() {
        return corNauplio;
    }

    public void setCorNauplio(String corNauplio) {
        this.corNauplio = corNauplio;
    }

    public Short getCorPellet() {
        return corPellet;
    }

    public void setCorPellet(Short corPellet) {
        this.corPellet = corPellet;
    }

    public BigDecimal getCorBiomasa() {
        return corBiomasa;
    }

    public void setCorBiomasa(BigDecimal corBiomasa) {
        this.corBiomasa = corBiomasa;
    }

    public BigDecimal getCorValorVenta() {
        return corValorVenta;
    }

    public void setCorValorVenta(BigDecimal corValorVenta) {
        this.corValorVenta = corValorVenta;
    }

    public String getCorObservaciones() {
        return corObservaciones;
    }

    public void setCorObservaciones(String corObservaciones) {
        this.corObservaciones = corObservaciones;
    }

    public Boolean getCorActiva() {
        return corActiva;
    }

    public void setCorActiva(Boolean corActiva) {
        this.corActiva = corActiva;
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
        hash += (prdCorridaPK != null ? prdCorridaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdCorrida)) {
            return false;
        }
        PrdCorrida other = (PrdCorrida) object;
        if ((this.prdCorridaPK == null && other.prdCorridaPK != null) || (this.prdCorridaPK != null && !this.prdCorridaPK.equals(other.prdCorridaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdCorrida[ prdCorridaPK=" + prdCorridaPK + " ]";
    }
    
}
