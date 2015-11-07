/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "prd_liquidacion", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdLiquidacion.findAll", query = "SELECT p FROM PrdLiquidacion p"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqEmpresa", query = "SELECT p FROM PrdLiquidacion p WHERE p.prdLiquidacionPK.liqEmpresa = :liqEmpresa"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqMotivo", query = "SELECT p FROM PrdLiquidacion p WHERE p.prdLiquidacionPK.liqMotivo = :liqMotivo"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqNumero", query = "SELECT p FROM PrdLiquidacion p WHERE p.prdLiquidacionPK.liqNumero = :liqNumero"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqLote", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqLote = :liqLote"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqFecha", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqFecha = :liqFecha"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqLibrasEnviadas", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqLibrasEnviadas = :liqLibrasEnviadas"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqLibrasRecibidas", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqLibrasRecibidas = :liqLibrasRecibidas"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqLibrasBasura", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqLibrasBasura = :liqLibrasBasura"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqLibrasRetiradas", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqLibrasRetiradas = :liqLibrasRetiradas"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqLibrasNetas", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqLibrasNetas = :liqLibrasNetas"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqLibrasEntero", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqLibrasEntero = :liqLibrasEntero"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqLibrasCola", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqLibrasCola = :liqLibrasCola"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqLibrasColaProcesadas", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqLibrasColaProcesadas = :liqLibrasColaProcesadas"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqAnimalesCosechados", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqAnimalesCosechados = :liqAnimalesCosechados"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqTotalMonto", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqTotalMonto = :liqTotalMonto"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqPendiente", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqPendiente = :liqPendiente"),
    @NamedQuery(name = "PrdLiquidacion.findByLiqAnulado", query = "SELECT p FROM PrdLiquidacion p WHERE p.liqAnulado = :liqAnulado"),
    @NamedQuery(name = "PrdLiquidacion.findByCliEmpresa", query = "SELECT p FROM PrdLiquidacion p WHERE p.cliEmpresa = :cliEmpresa"),
    @NamedQuery(name = "PrdLiquidacion.findByCliCodigo", query = "SELECT p FROM PrdLiquidacion p WHERE p.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "PrdLiquidacion.findByUsrEmpresa", query = "SELECT p FROM PrdLiquidacion p WHERE p.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "PrdLiquidacion.findByUsrCodigo", query = "SELECT p FROM PrdLiquidacion p WHERE p.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "PrdLiquidacion.findByUsrFechaInserta", query = "SELECT p FROM PrdLiquidacion p WHERE p.usrFechaInserta = :usrFechaInserta")})
public class PrdLiquidacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrdLiquidacionPK prdLiquidacionPK;
    @Basic(optional = false)
    @Column(name = "liq_lote")
    private String liqLote;
    @Basic(optional = false)
    @Column(name = "liq_fecha")
    @Temporal(TemporalType.DATE)
    private Date liqFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "liq_libras_enviadas")
    private BigDecimal liqLibrasEnviadas;
    @Basic(optional = false)
    @Column(name = "liq_libras_recibidas")
    private BigDecimal liqLibrasRecibidas;
    @Basic(optional = false)
    @Column(name = "liq_libras_basura")
    private BigDecimal liqLibrasBasura;
    @Basic(optional = false)
    @Column(name = "liq_libras_retiradas")
    private BigDecimal liqLibrasRetiradas;
    @Basic(optional = false)
    @Column(name = "liq_libras_netas")
    private BigDecimal liqLibrasNetas;
    @Basic(optional = false)
    @Column(name = "liq_libras_entero")
    private BigDecimal liqLibrasEntero;
    @Basic(optional = false)
    @Column(name = "liq_libras_cola")
    private BigDecimal liqLibrasCola;
    @Basic(optional = false)
    @Column(name = "liq_libras_cola_procesadas")
    private BigDecimal liqLibrasColaProcesadas;
    @Basic(optional = false)
    @Column(name = "liq_animales_cosechados")
    private BigDecimal liqAnimalesCosechados;
    @Basic(optional = false)
    @Column(name = "liq_total_monto")
    private BigDecimal liqTotalMonto;
    @Basic(optional = false)
    @Column(name = "liq_pendiente")
    private boolean liqPendiente;
    @Basic(optional = false)
    @Column(name = "liq_anulado")
    private boolean liqAnulado;
    @Basic(optional = false)
    @Column(name = "cli_empresa")
    private String cliEmpresa;
    @Basic(optional = false)
    @Column(name = "cli_codigo")
    private String cliCodigo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdLiquidacion")
    private List<PrdLiquidacionDetalle> prdLiquidacionDetalleList;

    public PrdLiquidacion() {
    }

    public PrdLiquidacion(PrdLiquidacionPK prdLiquidacionPK) {
        this.prdLiquidacionPK = prdLiquidacionPK;
    }

    public PrdLiquidacion(PrdLiquidacionPK prdLiquidacionPK, String liqLote, Date liqFecha, BigDecimal liqLibrasEnviadas, BigDecimal liqLibrasRecibidas, BigDecimal liqLibrasBasura, BigDecimal liqLibrasRetiradas, BigDecimal liqLibrasNetas, BigDecimal liqLibrasEntero, BigDecimal liqLibrasCola, BigDecimal liqLibrasColaProcesadas, BigDecimal liqAnimalesCosechados, BigDecimal liqTotalMonto, boolean liqPendiente, boolean liqAnulado, String cliEmpresa, String cliCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.prdLiquidacionPK = prdLiquidacionPK;
        this.liqLote = liqLote;
        this.liqFecha = liqFecha;
        this.liqLibrasEnviadas = liqLibrasEnviadas;
        this.liqLibrasRecibidas = liqLibrasRecibidas;
        this.liqLibrasBasura = liqLibrasBasura;
        this.liqLibrasRetiradas = liqLibrasRetiradas;
        this.liqLibrasNetas = liqLibrasNetas;
        this.liqLibrasEntero = liqLibrasEntero;
        this.liqLibrasCola = liqLibrasCola;
        this.liqLibrasColaProcesadas = liqLibrasColaProcesadas;
        this.liqAnimalesCosechados = liqAnimalesCosechados;
        this.liqTotalMonto = liqTotalMonto;
        this.liqPendiente = liqPendiente;
        this.liqAnulado = liqAnulado;
        this.cliEmpresa = cliEmpresa;
        this.cliCodigo = cliCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public PrdLiquidacion(String liqEmpresa, String liqMotivo, String liqNumero) {
        this.prdLiquidacionPK = new PrdLiquidacionPK(liqEmpresa, liqMotivo, liqNumero);
    }

    public PrdLiquidacionPK getPrdLiquidacionPK() {
        return prdLiquidacionPK;
    }

    public void setPrdLiquidacionPK(PrdLiquidacionPK prdLiquidacionPK) {
        this.prdLiquidacionPK = prdLiquidacionPK;
    }

    public String getLiqLote() {
        return liqLote;
    }

    public void setLiqLote(String liqLote) {
        this.liqLote = liqLote;
    }

    public Date getLiqFecha() {
        return liqFecha;
    }

    public void setLiqFecha(Date liqFecha) {
        this.liqFecha = liqFecha;
    }

    public BigDecimal getLiqLibrasEnviadas() {
        return liqLibrasEnviadas;
    }

    public void setLiqLibrasEnviadas(BigDecimal liqLibrasEnviadas) {
        this.liqLibrasEnviadas = liqLibrasEnviadas;
    }

    public BigDecimal getLiqLibrasRecibidas() {
        return liqLibrasRecibidas;
    }

    public void setLiqLibrasRecibidas(BigDecimal liqLibrasRecibidas) {
        this.liqLibrasRecibidas = liqLibrasRecibidas;
    }

    public BigDecimal getLiqLibrasBasura() {
        return liqLibrasBasura;
    }

    public void setLiqLibrasBasura(BigDecimal liqLibrasBasura) {
        this.liqLibrasBasura = liqLibrasBasura;
    }

    public BigDecimal getLiqLibrasRetiradas() {
        return liqLibrasRetiradas;
    }

    public void setLiqLibrasRetiradas(BigDecimal liqLibrasRetiradas) {
        this.liqLibrasRetiradas = liqLibrasRetiradas;
    }

    public BigDecimal getLiqLibrasNetas() {
        return liqLibrasNetas;
    }

    public void setLiqLibrasNetas(BigDecimal liqLibrasNetas) {
        this.liqLibrasNetas = liqLibrasNetas;
    }

    public BigDecimal getLiqLibrasEntero() {
        return liqLibrasEntero;
    }

    public void setLiqLibrasEntero(BigDecimal liqLibrasEntero) {
        this.liqLibrasEntero = liqLibrasEntero;
    }

    public BigDecimal getLiqLibrasCola() {
        return liqLibrasCola;
    }

    public void setLiqLibrasCola(BigDecimal liqLibrasCola) {
        this.liqLibrasCola = liqLibrasCola;
    }

    public BigDecimal getLiqLibrasColaProcesadas() {
        return liqLibrasColaProcesadas;
    }

    public void setLiqLibrasColaProcesadas(BigDecimal liqLibrasColaProcesadas) {
        this.liqLibrasColaProcesadas = liqLibrasColaProcesadas;
    }

    public BigDecimal getLiqAnimalesCosechados() {
        return liqAnimalesCosechados;
    }

    public void setLiqAnimalesCosechados(BigDecimal liqAnimalesCosechados) {
        this.liqAnimalesCosechados = liqAnimalesCosechados;
    }

    public BigDecimal getLiqTotalMonto() {
        return liqTotalMonto;
    }

    public void setLiqTotalMonto(BigDecimal liqTotalMonto) {
        this.liqTotalMonto = liqTotalMonto;
    }

    public boolean getLiqPendiente() {
        return liqPendiente;
    }

    public void setLiqPendiente(boolean liqPendiente) {
        this.liqPendiente = liqPendiente;
    }

    public boolean getLiqAnulado() {
        return liqAnulado;
    }

    public void setLiqAnulado(boolean liqAnulado) {
        this.liqAnulado = liqAnulado;
    }

    public String getCliEmpresa() {
        return cliEmpresa;
    }

    public void setCliEmpresa(String cliEmpresa) {
        this.cliEmpresa = cliEmpresa;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
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

    public List<PrdLiquidacionDetalle> getPrdLiquidacionDetalleList() {
        return prdLiquidacionDetalleList;
    }

    public void setPrdLiquidacionDetalleList(List<PrdLiquidacionDetalle> prdLiquidacionDetalleList) {
        this.prdLiquidacionDetalleList = prdLiquidacionDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdLiquidacionPK != null ? prdLiquidacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdLiquidacion)) {
            return false;
        }
        PrdLiquidacion other = (PrdLiquidacion) object;
        if ((this.prdLiquidacionPK == null && other.prdLiquidacionPK != null) || (this.prdLiquidacionPK != null && !this.prdLiquidacionPK.equals(other.prdLiquidacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdLiquidacion[ prdLiquidacionPK=" + prdLiquidacionPK + " ]";
    }
    
}
