/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "rh_categoria", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhCategoria.findAll", query = "SELECT r FROM RhCategoria r"),
    @NamedQuery(name = "RhCategoria.findByCatEmpresa", query = "SELECT r FROM RhCategoria r WHERE r.rhCategoriaPK.catEmpresa = :catEmpresa"),
    @NamedQuery(name = "RhCategoria.findByCatNombre", query = "SELECT r FROM RhCategoria r WHERE r.rhCategoriaPK.catNombre = :catNombre"),
    @NamedQuery(name = "RhCategoria.findByCtaAnticipos", query = "SELECT r FROM RhCategoria r WHERE r.ctaAnticipos = :ctaAnticipos"),
    @NamedQuery(name = "RhCategoria.findByCtaPrestamos", query = "SELECT r FROM RhCategoria r WHERE r.ctaPrestamos = :ctaPrestamos"),
    @NamedQuery(name = "RhCategoria.findByCtaPorPagarBonos", query = "SELECT r FROM RhCategoria r WHERE r.ctaPorPagarBonos = :ctaPorPagarBonos"),
    @NamedQuery(name = "RhCategoria.findByCtaPorPagarSueldo", query = "SELECT r FROM RhCategoria r WHERE r.ctaPorPagarSueldo = :ctaPorPagarSueldo"),
    @NamedQuery(name = "RhCategoria.findByCtaPorPagarImpuestoRenta", query = "SELECT r FROM RhCategoria r WHERE r.ctaPorPagarImpuestoRenta = :ctaPorPagarImpuestoRenta"),
    @NamedQuery(name = "RhCategoria.findByCtaPorPagarUtilidades", query = "SELECT r FROM RhCategoria r WHERE r.ctaPorPagarUtilidades = :ctaPorPagarUtilidades"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoBonos", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoBonos = :ctaGastoBonos"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoBonosNd", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoBonosNd = :ctaGastoBonosNd"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoBonoFijo", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoBonoFijo = :ctaGastoBonoFijo"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoBonoFijoNd", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoBonoFijoNd = :ctaGastoBonoFijoNd"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoOtrosIngresos", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoOtrosIngresos = :ctaGastoOtrosIngresos"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoOtrosIngresosNd", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoOtrosIngresosNd = :ctaGastoOtrosIngresosNd"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoSueldos", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoSueldos = :ctaGastoSueldos"),
    @NamedQuery(name = "RhCategoria.findByCtaAportepersonal", query = "SELECT r FROM RhCategoria r WHERE r.ctaAportepersonal = :ctaAportepersonal"),
    @NamedQuery(name = "RhCategoria.findByCtaAportepatronal", query = "SELECT r FROM RhCategoria r WHERE r.ctaAportepatronal = :ctaAportepatronal"),
    @NamedQuery(name = "RhCategoria.findByCtaIece", query = "SELECT r FROM RhCategoria r WHERE r.ctaIece = :ctaIece"),
    @NamedQuery(name = "RhCategoria.findByCtaSecap", query = "SELECT r FROM RhCategoria r WHERE r.ctaSecap = :ctaSecap"),
    @NamedQuery(name = "RhCategoria.findByCtaXiii", query = "SELECT r FROM RhCategoria r WHERE r.ctaXiii = :ctaXiii"),
    @NamedQuery(name = "RhCategoria.findByCtaXiv", query = "SELECT r FROM RhCategoria r WHERE r.ctaXiv = :ctaXiv"),
    @NamedQuery(name = "RhCategoria.findByCtaFondoreserva", query = "SELECT r FROM RhCategoria r WHERE r.ctaFondoreserva = :ctaFondoreserva"),
    @NamedQuery(name = "RhCategoria.findByCtaVacaciones", query = "SELECT r FROM RhCategoria r WHERE r.ctaVacaciones = :ctaVacaciones"),
    @NamedQuery(name = "RhCategoria.findByCtaDesahucio", query = "SELECT r FROM RhCategoria r WHERE r.ctaDesahucio = :ctaDesahucio"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoAporteindividual", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoAporteindividual = :ctaGastoAporteindividual"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoAportepatronal", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoAportepatronal = :ctaGastoAportepatronal"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoIece", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoIece = :ctaGastoIece"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoSecap", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoSecap = :ctaGastoSecap"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoXiii", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoXiii = :ctaGastoXiii"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoXiv", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoXiv = :ctaGastoXiv"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoFondoreserva", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoFondoreserva = :ctaGastoFondoreserva"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoVacaciones", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoVacaciones = :ctaGastoVacaciones"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoSalarioDigno", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoSalarioDigno = :ctaGastoSalarioDigno"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoDesahucio", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoDesahucio = :ctaGastoDesahucio"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoDesahucioIntempestivo", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoDesahucioIntempestivo = :ctaGastoDesahucioIntempestivo"),
    @NamedQuery(name = "RhCategoria.findByCtaGastoLiquidacionBono", query = "SELECT r FROM RhCategoria r WHERE r.ctaGastoLiquidacionBono = :ctaGastoLiquidacionBono"),
    @NamedQuery(name = "RhCategoria.findByTipEmpresa", query = "SELECT r FROM RhCategoria r WHERE r.tipEmpresa = :tipEmpresa"),
    @NamedQuery(name = "RhCategoria.findByTipCodigo", query = "SELECT r FROM RhCategoria r WHERE r.tipCodigo = :tipCodigo"),
    @NamedQuery(name = "RhCategoria.findByUsrEmpresa", query = "SELECT r FROM RhCategoria r WHERE r.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "RhCategoria.findByUsrCodigo", query = "SELECT r FROM RhCategoria r WHERE r.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "RhCategoria.findByUsrFechaInserta", query = "SELECT r FROM RhCategoria r WHERE r.usrFechaInserta = :usrFechaInserta")})
public class RhCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RhCategoriaPK rhCategoriaPK;
    @Column(name = "cta_anticipos")
    private String ctaAnticipos;
    @Column(name = "cta_prestamos")
    private String ctaPrestamos;
    @Column(name = "cta_por_pagar_bonos")
    private String ctaPorPagarBonos;
    @Column(name = "cta_por_pagar_sueldo")
    private String ctaPorPagarSueldo;
    @Column(name = "cta_por_pagar_impuesto_renta")
    private String ctaPorPagarImpuestoRenta;
    @Column(name = "cta_por_pagar_utilidades")
    private String ctaPorPagarUtilidades;
    @Column(name = "cta_gasto_bonos")
    private String ctaGastoBonos;
    @Column(name = "cta_gasto_bonos_nd")
    private String ctaGastoBonosNd;
    @Column(name = "cta_gasto_bono_fijo")
    private String ctaGastoBonoFijo;
    @Column(name = "cta_gasto_bono_fijo_nd")
    private String ctaGastoBonoFijoNd;
    @Column(name = "cta_gasto_otros_ingresos")
    private String ctaGastoOtrosIngresos;
    @Column(name = "cta_gasto_otros_ingresos_nd")
    private String ctaGastoOtrosIngresosNd;
    @Column(name = "cta_gasto_sueldos")
    private String ctaGastoSueldos;
    @Column(name = "cta_aportepersonal")
    private String ctaAportepersonal;
    @Column(name = "cta_aportepatronal")
    private String ctaAportepatronal;
    @Column(name = "cta_iece")
    private String ctaIece;
    @Column(name = "cta_secap")
    private String ctaSecap;
    @Column(name = "cta_xiii")
    private String ctaXiii;
    @Column(name = "cta_xiv")
    private String ctaXiv;
    @Column(name = "cta_fondoreserva")
    private String ctaFondoreserva;
    @Column(name = "cta_vacaciones")
    private String ctaVacaciones;
    @Column(name = "cta_desahucio")
    private String ctaDesahucio;
    @Column(name = "cta_gasto_aporteindividual")
    private String ctaGastoAporteindividual;
    @Column(name = "cta_gasto_aportepatronal")
    private String ctaGastoAportepatronal;
    @Column(name = "cta_gasto_iece")
    private String ctaGastoIece;
    @Column(name = "cta_gasto_secap")
    private String ctaGastoSecap;
    @Column(name = "cta_gasto_xiii")
    private String ctaGastoXiii;
    @Column(name = "cta_gasto_xiv")
    private String ctaGastoXiv;
    @Column(name = "cta_gasto_fondoreserva")
    private String ctaGastoFondoreserva;
    @Column(name = "cta_gasto_vacaciones")
    private String ctaGastoVacaciones;
    @Column(name = "cta_gasto_salario_digno")
    private String ctaGastoSalarioDigno;
    @Column(name = "cta_gasto_desahucio")
    private String ctaGastoDesahucio;
    @Column(name = "cta_gasto_desahucio_intempestivo")
    private String ctaGastoDesahucioIntempestivo;
    @Column(name = "cta_gasto_liquidacion_bono")
    private String ctaGastoLiquidacionBono;
    @Column(name = "tip_empresa")
    private String tipEmpresa;
    @Column(name = "tip_codigo")
    private String tipCodigo;
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

    public RhCategoria() {
    }

    public RhCategoria(RhCategoriaPK rhCategoriaPK) {
        this.rhCategoriaPK = rhCategoriaPK;
    }

    public RhCategoria(RhCategoriaPK rhCategoriaPK, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.rhCategoriaPK = rhCategoriaPK;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public RhCategoria(String catEmpresa, String catNombre) {
        this.rhCategoriaPK = new RhCategoriaPK(catEmpresa, catNombre);
    }

    public RhCategoriaPK getRhCategoriaPK() {
        return rhCategoriaPK;
    }

    public void setRhCategoriaPK(RhCategoriaPK rhCategoriaPK) {
        this.rhCategoriaPK = rhCategoriaPK;
    }

    public String getCtaAnticipos() {
        return ctaAnticipos;
    }

    public void setCtaAnticipos(String ctaAnticipos) {
        this.ctaAnticipos = ctaAnticipos;
    }

    public String getCtaPrestamos() {
        return ctaPrestamos;
    }

    public void setCtaPrestamos(String ctaPrestamos) {
        this.ctaPrestamos = ctaPrestamos;
    }

    public String getCtaPorPagarBonos() {
        return ctaPorPagarBonos;
    }

    public void setCtaPorPagarBonos(String ctaPorPagarBonos) {
        this.ctaPorPagarBonos = ctaPorPagarBonos;
    }

    public String getCtaPorPagarSueldo() {
        return ctaPorPagarSueldo;
    }

    public void setCtaPorPagarSueldo(String ctaPorPagarSueldo) {
        this.ctaPorPagarSueldo = ctaPorPagarSueldo;
    }

    public String getCtaPorPagarImpuestoRenta() {
        return ctaPorPagarImpuestoRenta;
    }

    public void setCtaPorPagarImpuestoRenta(String ctaPorPagarImpuestoRenta) {
        this.ctaPorPagarImpuestoRenta = ctaPorPagarImpuestoRenta;
    }

    public String getCtaPorPagarUtilidades() {
        return ctaPorPagarUtilidades;
    }

    public void setCtaPorPagarUtilidades(String ctaPorPagarUtilidades) {
        this.ctaPorPagarUtilidades = ctaPorPagarUtilidades;
    }

    public String getCtaGastoBonos() {
        return ctaGastoBonos;
    }

    public void setCtaGastoBonos(String ctaGastoBonos) {
        this.ctaGastoBonos = ctaGastoBonos;
    }

    public String getCtaGastoBonosNd() {
        return ctaGastoBonosNd;
    }

    public void setCtaGastoBonosNd(String ctaGastoBonosNd) {
        this.ctaGastoBonosNd = ctaGastoBonosNd;
    }

    public String getCtaGastoBonoFijo() {
        return ctaGastoBonoFijo;
    }

    public void setCtaGastoBonoFijo(String ctaGastoBonoFijo) {
        this.ctaGastoBonoFijo = ctaGastoBonoFijo;
    }

    public String getCtaGastoBonoFijoNd() {
        return ctaGastoBonoFijoNd;
    }

    public void setCtaGastoBonoFijoNd(String ctaGastoBonoFijoNd) {
        this.ctaGastoBonoFijoNd = ctaGastoBonoFijoNd;
    }

    public String getCtaGastoOtrosIngresos() {
        return ctaGastoOtrosIngresos;
    }

    public void setCtaGastoOtrosIngresos(String ctaGastoOtrosIngresos) {
        this.ctaGastoOtrosIngresos = ctaGastoOtrosIngresos;
    }

    public String getCtaGastoOtrosIngresosNd() {
        return ctaGastoOtrosIngresosNd;
    }

    public void setCtaGastoOtrosIngresosNd(String ctaGastoOtrosIngresosNd) {
        this.ctaGastoOtrosIngresosNd = ctaGastoOtrosIngresosNd;
    }

    public String getCtaGastoSueldos() {
        return ctaGastoSueldos;
    }

    public void setCtaGastoSueldos(String ctaGastoSueldos) {
        this.ctaGastoSueldos = ctaGastoSueldos;
    }

    public String getCtaAportepersonal() {
        return ctaAportepersonal;
    }

    public void setCtaAportepersonal(String ctaAportepersonal) {
        this.ctaAportepersonal = ctaAportepersonal;
    }

    public String getCtaAportepatronal() {
        return ctaAportepatronal;
    }

    public void setCtaAportepatronal(String ctaAportepatronal) {
        this.ctaAportepatronal = ctaAportepatronal;
    }

    public String getCtaIece() {
        return ctaIece;
    }

    public void setCtaIece(String ctaIece) {
        this.ctaIece = ctaIece;
    }

    public String getCtaSecap() {
        return ctaSecap;
    }

    public void setCtaSecap(String ctaSecap) {
        this.ctaSecap = ctaSecap;
    }

    public String getCtaXiii() {
        return ctaXiii;
    }

    public void setCtaXiii(String ctaXiii) {
        this.ctaXiii = ctaXiii;
    }

    public String getCtaXiv() {
        return ctaXiv;
    }

    public void setCtaXiv(String ctaXiv) {
        this.ctaXiv = ctaXiv;
    }

    public String getCtaFondoreserva() {
        return ctaFondoreserva;
    }

    public void setCtaFondoreserva(String ctaFondoreserva) {
        this.ctaFondoreserva = ctaFondoreserva;
    }

    public String getCtaVacaciones() {
        return ctaVacaciones;
    }

    public void setCtaVacaciones(String ctaVacaciones) {
        this.ctaVacaciones = ctaVacaciones;
    }

    public String getCtaDesahucio() {
        return ctaDesahucio;
    }

    public void setCtaDesahucio(String ctaDesahucio) {
        this.ctaDesahucio = ctaDesahucio;
    }

    public String getCtaGastoAporteindividual() {
        return ctaGastoAporteindividual;
    }

    public void setCtaGastoAporteindividual(String ctaGastoAporteindividual) {
        this.ctaGastoAporteindividual = ctaGastoAporteindividual;
    }

    public String getCtaGastoAportepatronal() {
        return ctaGastoAportepatronal;
    }

    public void setCtaGastoAportepatronal(String ctaGastoAportepatronal) {
        this.ctaGastoAportepatronal = ctaGastoAportepatronal;
    }

    public String getCtaGastoIece() {
        return ctaGastoIece;
    }

    public void setCtaGastoIece(String ctaGastoIece) {
        this.ctaGastoIece = ctaGastoIece;
    }

    public String getCtaGastoSecap() {
        return ctaGastoSecap;
    }

    public void setCtaGastoSecap(String ctaGastoSecap) {
        this.ctaGastoSecap = ctaGastoSecap;
    }

    public String getCtaGastoXiii() {
        return ctaGastoXiii;
    }

    public void setCtaGastoXiii(String ctaGastoXiii) {
        this.ctaGastoXiii = ctaGastoXiii;
    }

    public String getCtaGastoXiv() {
        return ctaGastoXiv;
    }

    public void setCtaGastoXiv(String ctaGastoXiv) {
        this.ctaGastoXiv = ctaGastoXiv;
    }

    public String getCtaGastoFondoreserva() {
        return ctaGastoFondoreserva;
    }

    public void setCtaGastoFondoreserva(String ctaGastoFondoreserva) {
        this.ctaGastoFondoreserva = ctaGastoFondoreserva;
    }

    public String getCtaGastoVacaciones() {
        return ctaGastoVacaciones;
    }

    public void setCtaGastoVacaciones(String ctaGastoVacaciones) {
        this.ctaGastoVacaciones = ctaGastoVacaciones;
    }

    public String getCtaGastoSalarioDigno() {
        return ctaGastoSalarioDigno;
    }

    public void setCtaGastoSalarioDigno(String ctaGastoSalarioDigno) {
        this.ctaGastoSalarioDigno = ctaGastoSalarioDigno;
    }

    public String getCtaGastoDesahucio() {
        return ctaGastoDesahucio;
    }

    public void setCtaGastoDesahucio(String ctaGastoDesahucio) {
        this.ctaGastoDesahucio = ctaGastoDesahucio;
    }

    public String getCtaGastoDesahucioIntempestivo() {
        return ctaGastoDesahucioIntempestivo;
    }

    public void setCtaGastoDesahucioIntempestivo(String ctaGastoDesahucioIntempestivo) {
        this.ctaGastoDesahucioIntempestivo = ctaGastoDesahucioIntempestivo;
    }

    public String getCtaGastoLiquidacionBono() {
        return ctaGastoLiquidacionBono;
    }

    public void setCtaGastoLiquidacionBono(String ctaGastoLiquidacionBono) {
        this.ctaGastoLiquidacionBono = ctaGastoLiquidacionBono;
    }

    public String getTipEmpresa() {
        return tipEmpresa;
    }

    public void setTipEmpresa(String tipEmpresa) {
        this.tipEmpresa = tipEmpresa;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
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
        hash += (rhCategoriaPK != null ? rhCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhCategoria)) {
            return false;
        }
        RhCategoria other = (RhCategoria) object;
        if ((this.rhCategoriaPK == null && other.rhCategoriaPK != null) || (this.rhCategoriaPK != null && !this.rhCategoriaPK.equals(other.rhCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhCategoria[ rhCategoriaPK=" + rhCategoriaPK + " ]";
    }
}
