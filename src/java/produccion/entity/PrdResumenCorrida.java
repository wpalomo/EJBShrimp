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
@Table(name = "prd_resumen_corrida", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdResumenCorrida.findAll", query = "SELECT p FROM PrdResumenCorrida p"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcEmpresa", query = "SELECT p FROM PrdResumenCorrida p WHERE p.prdResumenCorridaPK.rcEmpresa = :rcEmpresa"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcSector", query = "SELECT p FROM PrdResumenCorrida p WHERE p.prdResumenCorridaPK.rcSector = :rcSector"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcSectorNombre", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcSectorNombre = :rcSectorNombre"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcPiscina", query = "SELECT p FROM PrdResumenCorrida p WHERE p.prdResumenCorridaPK.rcPiscina = :rcPiscina"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcPiscinaNombre", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcPiscinaNombre = :rcPiscinaNombre"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcHectareaje", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcHectareaje = :rcHectareaje"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcCorrida", query = "SELECT p FROM PrdResumenCorrida p WHERE p.prdResumenCorridaPK.rcCorrida = :rcCorrida"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcFechaDesde", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcFechaDesde = :rcFechaDesde"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcFechaSiembra", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcFechaSiembra = :rcFechaSiembra"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcFechaPesca", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcFechaPesca = :rcFechaPesca"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcFechaHasta", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcFechaHasta = :rcFechaHasta"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcEdad", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcEdad = :rcEdad"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcDiasMuertos", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcDiasMuertos = :rcDiasMuertos"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcNumeroLarvas", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcNumeroLarvas = :rcNumeroLarvas"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcDensidad", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcDensidad = :rcDensidad"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcLaboratorio", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcLaboratorio = :rcLaboratorio"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcNauplio", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcNauplio = :rcNauplio"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcBalanceado", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcBalanceado = :rcBalanceado"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcBiomasa", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcBiomasa = :rcBiomasa"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcBiomasaReal", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcBiomasaReal = :rcBiomasaReal"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcConversion", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcConversion = :rcConversion"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcTallaGrande", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcTallaGrande = :rcTallaGrande"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcTallaMediano", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcTallaMediano = :rcTallaMediano"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcTallaPequeno", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcTallaPequeno = :rcTallaPequeno"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcTallaPromedio", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcTallaPromedio = :rcTallaPromedio"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcPesoIdeal", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcPesoIdeal = :rcPesoIdeal"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcSobrevivencia", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcSobrevivencia = :rcSobrevivencia"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcTotal", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcTotal = :rcTotal"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcDirecto", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcDirecto = :rcDirecto"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcIndirecto", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcIndirecto = :rcIndirecto"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcValorVenta", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcValorVenta = :rcValorVenta"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcResultado", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcResultado = :rcResultado"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcCostoHectarea", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcCostoHectarea = :rcCostoHectarea"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcVentaHectarea", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcVentaHectarea = :rcVentaHectarea"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcResultadoHectarea", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcResultadoHectarea = :rcResultadoHectarea"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcCostoLibra", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcCostoLibra = :rcCostoLibra"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcVentaLibra", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcVentaLibra = :rcVentaLibra"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcResultadoLibra", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcResultadoLibra = :rcResultadoLibra"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcCostoDirectoDia", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcCostoDirectoDia = :rcCostoDirectoDia"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcVentaIndirectoDia", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcVentaIndirectoDia = :rcVentaIndirectoDia"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcCostoTotalDia", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcCostoTotalDia = :rcCostoTotalDia"),
    @NamedQuery(name = "PrdResumenCorrida.findByRcFechaHora", query = "SELECT p FROM PrdResumenCorrida p WHERE p.rcFechaHora = :rcFechaHora")})
public class PrdResumenCorrida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrdResumenCorridaPK prdResumenCorridaPK;
    @Column(name = "rc_sector_nombre")
    private String rcSectorNombre;
    @Column(name = "rc_piscina_nombre")
    private String rcPiscinaNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rc_hectareaje")
    private BigDecimal rcHectareaje;
    @Column(name = "rc_fecha_desde")
    private String rcFechaDesde;
    @Column(name = "rc_fecha_siembra")
    private String rcFechaSiembra;
    @Column(name = "rc_fecha_pesca")
    private String rcFechaPesca;
    @Column(name = "rc_fecha_hasta")
    private String rcFechaHasta;
    @Column(name = "rc_edad")
    private Integer rcEdad;
    @Column(name = "rc_dias_muertos")
    private Integer rcDiasMuertos;
    @Column(name = "rc_numero_larvas")
    private Integer rcNumeroLarvas;
    @Column(name = "rc_densidad")
    private Integer rcDensidad;
    @Column(name = "rc_laboratorio")
    private String rcLaboratorio;
    @Column(name = "rc_nauplio")
    private String rcNauplio;
    @Column(name = "rc_balanceado")
    private BigDecimal rcBalanceado;
    @Column(name = "rc_biomasa")
    private BigDecimal rcBiomasa;
    @Column(name = "rc_biomasa_real")
    private BigDecimal rcBiomasaReal;
    @Column(name = "rc_conversion")
    private BigDecimal rcConversion;
    @Column(name = "rc_talla_grande")
    private BigDecimal rcTallaGrande;
    @Column(name = "rc_talla_mediano")
    private BigDecimal rcTallaMediano;
    @Column(name = "rc_talla_pequeno")
    private BigDecimal rcTallaPequeno;
    @Column(name = "rc_talla_promedio")
    private BigDecimal rcTallaPromedio;
    @Column(name = "rc_peso_ideal")
    private BigDecimal rcPesoIdeal;
    @Column(name = "rc_sobrevivencia")
    private String rcSobrevivencia;
    @Column(name = "rc_total")
    private BigDecimal rcTotal;
    @Column(name = "rc_directo")
    private BigDecimal rcDirecto;
    @Column(name = "rc_indirecto")
    private BigDecimal rcIndirecto;
    @Column(name = "rc_valor_venta")
    private BigDecimal rcValorVenta;
    @Column(name = "rc_resultado")
    private BigDecimal rcResultado;
    @Column(name = "rc_costo_hectarea")
    private BigDecimal rcCostoHectarea;
    @Column(name = "rc_venta_hectarea")
    private BigDecimal rcVentaHectarea;
    @Column(name = "rc_resultado_hectarea")
    private BigDecimal rcResultadoHectarea;
    @Column(name = "rc_costo_libra")
    private BigDecimal rcCostoLibra;
    @Column(name = "rc_venta_libra")
    private BigDecimal rcVentaLibra;
    @Column(name = "rc_resultado_libra")
    private BigDecimal rcResultadoLibra;
    @Column(name = "rc_costo_directo_dia")
    private BigDecimal rcCostoDirectoDia;
    @Column(name = "rc_venta_indirecto_dia")
    private BigDecimal rcVentaIndirectoDia;
    @Column(name = "rc_costo_total_dia")
    private BigDecimal rcCostoTotalDia;
    @Basic(optional = false)
    @Column(name = "rc_fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rcFechaHora;

    public PrdResumenCorrida() {
    }

    public PrdResumenCorrida(PrdResumenCorridaPK prdResumenCorridaPK) {
        this.prdResumenCorridaPK = prdResumenCorridaPK;
    }

    public PrdResumenCorrida(PrdResumenCorridaPK prdResumenCorridaPK, Date rcFechaHora) {
        this.prdResumenCorridaPK = prdResumenCorridaPK;
        this.rcFechaHora = rcFechaHora;
    }

    public PrdResumenCorrida(String rcEmpresa, String rcSector, String rcPiscina, String rcCorrida) {
        this.prdResumenCorridaPK = new PrdResumenCorridaPK(rcEmpresa, rcSector, rcPiscina, rcCorrida);
    }

    public PrdResumenCorridaPK getPrdResumenCorridaPK() {
        return prdResumenCorridaPK;
    }

    public void setPrdResumenCorridaPK(PrdResumenCorridaPK prdResumenCorridaPK) {
        this.prdResumenCorridaPK = prdResumenCorridaPK;
    }

    public String getRcSectorNombre() {
        return rcSectorNombre;
    }

    public void setRcSectorNombre(String rcSectorNombre) {
        this.rcSectorNombre = rcSectorNombre;
    }

    public String getRcPiscinaNombre() {
        return rcPiscinaNombre;
    }

    public void setRcPiscinaNombre(String rcPiscinaNombre) {
        this.rcPiscinaNombre = rcPiscinaNombre;
    }

    public BigDecimal getRcHectareaje() {
        return rcHectareaje;
    }

    public void setRcHectareaje(BigDecimal rcHectareaje) {
        this.rcHectareaje = rcHectareaje;
    }

    public String getRcFechaDesde() {
        return rcFechaDesde;
    }

    public void setRcFechaDesde(String rcFechaDesde) {
        this.rcFechaDesde = rcFechaDesde;
    }

    public String getRcFechaSiembra() {
        return rcFechaSiembra;
    }

    public void setRcFechaSiembra(String rcFechaSiembra) {
        this.rcFechaSiembra = rcFechaSiembra;
    }

    public String getRcFechaPesca() {
        return rcFechaPesca;
    }

    public void setRcFechaPesca(String rcFechaPesca) {
        this.rcFechaPesca = rcFechaPesca;
    }

    public String getRcFechaHasta() {
        return rcFechaHasta;
    }

    public void setRcFechaHasta(String rcFechaHasta) {
        this.rcFechaHasta = rcFechaHasta;
    }

    public Integer getRcEdad() {
        return rcEdad;
    }

    public void setRcEdad(Integer rcEdad) {
        this.rcEdad = rcEdad;
    }

    public Integer getRcDiasMuertos() {
        return rcDiasMuertos;
    }

    public void setRcDiasMuertos(Integer rcDiasMuertos) {
        this.rcDiasMuertos = rcDiasMuertos;
    }

    public Integer getRcNumeroLarvas() {
        return rcNumeroLarvas;
    }

    public void setRcNumeroLarvas(Integer rcNumeroLarvas) {
        this.rcNumeroLarvas = rcNumeroLarvas;
    }

    public Integer getRcDensidad() {
        return rcDensidad;
    }

    public void setRcDensidad(Integer rcDensidad) {
        this.rcDensidad = rcDensidad;
    }

    public String getRcLaboratorio() {
        return rcLaboratorio;
    }

    public void setRcLaboratorio(String rcLaboratorio) {
        this.rcLaboratorio = rcLaboratorio;
    }

    public String getRcNauplio() {
        return rcNauplio;
    }

    public void setRcNauplio(String rcNauplio) {
        this.rcNauplio = rcNauplio;
    }

    public BigDecimal getRcBalanceado() {
        return rcBalanceado;
    }

    public void setRcBalanceado(BigDecimal rcBalanceado) {
        this.rcBalanceado = rcBalanceado;
    }

    public BigDecimal getRcBiomasa() {
        return rcBiomasa;
    }

    public void setRcBiomasa(BigDecimal rcBiomasa) {
        this.rcBiomasa = rcBiomasa;
    }

    public BigDecimal getRcBiomasaReal() {
        return rcBiomasaReal;
    }

    public void setRcBiomasaReal(BigDecimal rcBiomasaReal) {
        this.rcBiomasaReal = rcBiomasaReal;
    }

    public BigDecimal getRcConversion() {
        return rcConversion;
    }

    public void setRcConversion(BigDecimal rcConversion) {
        this.rcConversion = rcConversion;
    }

    public BigDecimal getRcTallaGrande() {
        return rcTallaGrande;
    }

    public void setRcTallaGrande(BigDecimal rcTallaGrande) {
        this.rcTallaGrande = rcTallaGrande;
    }

    public BigDecimal getRcTallaMediano() {
        return rcTallaMediano;
    }

    public void setRcTallaMediano(BigDecimal rcTallaMediano) {
        this.rcTallaMediano = rcTallaMediano;
    }

    public BigDecimal getRcTallaPequeno() {
        return rcTallaPequeno;
    }

    public void setRcTallaPequeno(BigDecimal rcTallaPequeno) {
        this.rcTallaPequeno = rcTallaPequeno;
    }

    public BigDecimal getRcTallaPromedio() {
        return rcTallaPromedio;
    }

    public void setRcTallaPromedio(BigDecimal rcTallaPromedio) {
        this.rcTallaPromedio = rcTallaPromedio;
    }

    public BigDecimal getRcPesoIdeal() {
        return rcPesoIdeal;
    }

    public void setRcPesoIdeal(BigDecimal rcPesoIdeal) {
        this.rcPesoIdeal = rcPesoIdeal;
    }

    public String getRcSobrevivencia() {
        return rcSobrevivencia;
    }

    public void setRcSobrevivencia(String rcSobrevivencia) {
        this.rcSobrevivencia = rcSobrevivencia;
    }

    public BigDecimal getRcTotal() {
        return rcTotal;
    }

    public void setRcTotal(BigDecimal rcTotal) {
        this.rcTotal = rcTotal;
    }

    public BigDecimal getRcDirecto() {
        return rcDirecto;
    }

    public void setRcDirecto(BigDecimal rcDirecto) {
        this.rcDirecto = rcDirecto;
    }

    public BigDecimal getRcIndirecto() {
        return rcIndirecto;
    }

    public void setRcIndirecto(BigDecimal rcIndirecto) {
        this.rcIndirecto = rcIndirecto;
    }

    public BigDecimal getRcValorVenta() {
        return rcValorVenta;
    }

    public void setRcValorVenta(BigDecimal rcValorVenta) {
        this.rcValorVenta = rcValorVenta;
    }

    public BigDecimal getRcResultado() {
        return rcResultado;
    }

    public void setRcResultado(BigDecimal rcResultado) {
        this.rcResultado = rcResultado;
    }

    public BigDecimal getRcCostoHectarea() {
        return rcCostoHectarea;
    }

    public void setRcCostoHectarea(BigDecimal rcCostoHectarea) {
        this.rcCostoHectarea = rcCostoHectarea;
    }

    public BigDecimal getRcVentaHectarea() {
        return rcVentaHectarea;
    }

    public void setRcVentaHectarea(BigDecimal rcVentaHectarea) {
        this.rcVentaHectarea = rcVentaHectarea;
    }

    public BigDecimal getRcResultadoHectarea() {
        return rcResultadoHectarea;
    }

    public void setRcResultadoHectarea(BigDecimal rcResultadoHectarea) {
        this.rcResultadoHectarea = rcResultadoHectarea;
    }

    public BigDecimal getRcCostoLibra() {
        return rcCostoLibra;
    }

    public void setRcCostoLibra(BigDecimal rcCostoLibra) {
        this.rcCostoLibra = rcCostoLibra;
    }

    public BigDecimal getRcVentaLibra() {
        return rcVentaLibra;
    }

    public void setRcVentaLibra(BigDecimal rcVentaLibra) {
        this.rcVentaLibra = rcVentaLibra;
    }

    public BigDecimal getRcResultadoLibra() {
        return rcResultadoLibra;
    }

    public void setRcResultadoLibra(BigDecimal rcResultadoLibra) {
        this.rcResultadoLibra = rcResultadoLibra;
    }

    public BigDecimal getRcCostoDirectoDia() {
        return rcCostoDirectoDia;
    }

    public void setRcCostoDirectoDia(BigDecimal rcCostoDirectoDia) {
        this.rcCostoDirectoDia = rcCostoDirectoDia;
    }

    public BigDecimal getRcVentaIndirectoDia() {
        return rcVentaIndirectoDia;
    }

    public void setRcVentaIndirectoDia(BigDecimal rcVentaIndirectoDia) {
        this.rcVentaIndirectoDia = rcVentaIndirectoDia;
    }

    public BigDecimal getRcCostoTotalDia() {
        return rcCostoTotalDia;
    }

    public void setRcCostoTotalDia(BigDecimal rcCostoTotalDia) {
        this.rcCostoTotalDia = rcCostoTotalDia;
    }

    public Date getRcFechaHora() {
        return rcFechaHora;
    }

    public void setRcFechaHora(Date rcFechaHora) {
        this.rcFechaHora = rcFechaHora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdResumenCorridaPK != null ? prdResumenCorridaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdResumenCorrida)) {
            return false;
        }
        PrdResumenCorrida other = (PrdResumenCorrida) object;
        if ((this.prdResumenCorridaPK == null && other.prdResumenCorridaPK != null) || (this.prdResumenCorridaPK != null && !this.prdResumenCorridaPK.equals(other.prdResumenCorridaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdResumenCorrida[ prdResumenCorridaPK=" + prdResumenCorridaPK + " ]";
    }
    
}
