/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class RhListaDetalleRolesTO implements Serializable {

    private String lrpId;
    private String lrpNombres;
    private String lrpCargo;
    private String lrpDesde;
    private String lrpHasta;
    private BigDecimal lrpSueldo;
    private Integer lrpDl;
    private Integer lrpDf;
    private Integer lrpDe;
    private Integer lrpDd;
    private Integer lrpDpm;
    private Integer lrpDp;
    private BigDecimal lrpSaldo;
    private BigDecimal lrpIngresos;
    private BigDecimal lrpBonos;
    private BigDecimal lrpBonosnd;
    private BigDecimal lrpBonosFijo;
    private BigDecimal lrpBonosFijoNd;
    private BigDecimal lrpOtrosIngresos;
    private BigDecimal lrpOtrosIngresosNd;
    private BigDecimal lrpViaticos;
    private BigDecimal lrpFondoReserva;
    private Boolean lrpAcumulaFondoReserva;
    private BigDecimal lrpLiquidacionXiii;
    private BigDecimal lrpLiquidacionXiv;
    private BigDecimal lrpLiquidacionVacaciones;
    private BigDecimal lrpLiquidacionSalarioDigno;
    private BigDecimal lrpLiquidacionDesahucio;
    private BigDecimal lrpLiquidacionDesahucioIntempestivo;
    private BigDecimal lrpLiquidacionBonificacion;
    private BigDecimal lrpLiquidacion;
    private BigDecimal lrpTotalIngresos;
    private BigDecimal lrpAnticipos;
    private BigDecimal lrpPrestamos;
    private BigDecimal lrpIess;
    private BigDecimal lrpRetencion;
    private BigDecimal lrpDescuentoPermisoMedico;
    private BigDecimal lrpDescuentos;
    private BigDecimal lrpTotal;
    private String lrpFormaPago;
    private String lrpDocumento;
    private String lrpContable;
    private String lrpObservaciones;
    private String nacionalidad;

    public RhListaDetalleRolesTO() {
    }

    public RhListaDetalleRolesTO(String lrpId, String lrpNombres, String lrpCargo, String lrpDesde, String lrpHasta, BigDecimal lrpSueldo, Integer lrpDl, Integer lrpDf, Integer lrpDe, Integer lrpDd, Integer lrpDpm, Integer lrpDp, BigDecimal lrpSaldo, BigDecimal lrpIngresos, BigDecimal lrpBonos, BigDecimal lrpBonosnd, BigDecimal lrpBonosFijo, BigDecimal lrpBonosFijoNd, BigDecimal lrpOtrosIngresos, BigDecimal lrpOtrosIngresosNd, BigDecimal lrpViaticos, BigDecimal lrpFondoReserva, Boolean lrpAcumulaFondoReserva, BigDecimal lrpLiquidacionXiii, BigDecimal lrpLiquidacionXiv, BigDecimal lrpLiquidacionVacaciones, BigDecimal lrpLiquidacionSalarioDigno, BigDecimal lrpLiquidacionDesahucio, BigDecimal lrpLiquidacionDesahucioIntempestivo, BigDecimal lrpLiquidacionBonificacion, BigDecimal lrpLiquidacion, BigDecimal lrpTotalIngresos, BigDecimal lrpAnticipos, BigDecimal lrpPrestamos, BigDecimal lrpIess, BigDecimal lrpRetencion, BigDecimal lrpDescuentoPermisoMedico, BigDecimal lrpDescuentos, BigDecimal lrpTotal, String lrpFormaPago, String lrpDocumento, String lrpContable, String lrpObservaciones, String nacionalidad) {
        this.lrpId = lrpId;
        this.lrpNombres = lrpNombres;
        this.lrpCargo = lrpCargo;
        this.lrpDesde = lrpDesde;
        this.lrpHasta = lrpHasta;
        this.lrpSueldo = lrpSueldo;
        this.lrpDl = lrpDl;
        this.lrpDf = lrpDf;
        this.lrpDe = lrpDe;
        this.lrpDd = lrpDd;
        this.lrpDpm = lrpDpm;
        this.lrpDp = lrpDp;
        this.lrpSaldo = lrpSaldo;
        this.lrpIngresos = lrpIngresos;
        this.lrpBonos = lrpBonos;
        this.lrpBonosnd = lrpBonosnd;
        this.lrpBonosFijo = lrpBonosFijo;
        this.lrpBonosFijoNd = lrpBonosFijoNd;
        this.lrpOtrosIngresos = lrpOtrosIngresos;
        this.lrpOtrosIngresosNd = lrpOtrosIngresosNd;
        this.lrpViaticos = lrpViaticos;
        this.lrpFondoReserva = lrpFondoReserva;
        this.lrpAcumulaFondoReserva = lrpAcumulaFondoReserva;
        this.lrpLiquidacionXiii = lrpLiquidacionXiii;
        this.lrpLiquidacionXiv = lrpLiquidacionXiv;
        this.lrpLiquidacionVacaciones = lrpLiquidacionVacaciones;
        this.lrpLiquidacionSalarioDigno = lrpLiquidacionSalarioDigno;
        this.lrpLiquidacionDesahucio = lrpLiquidacionDesahucio;
        this.lrpLiquidacionDesahucioIntempestivo = lrpLiquidacionDesahucioIntempestivo;
        this.lrpLiquidacionBonificacion = lrpLiquidacionBonificacion;
        this.lrpLiquidacion = lrpLiquidacion;
        this.lrpTotalIngresos = lrpTotalIngresos;
        this.lrpAnticipos = lrpAnticipos;
        this.lrpPrestamos = lrpPrestamos;
        this.lrpIess = lrpIess;
        this.lrpRetencion = lrpRetencion;
        this.lrpDescuentoPermisoMedico = lrpDescuentoPermisoMedico;
        this.lrpDescuentos = lrpDescuentos;
        this.lrpTotal = lrpTotal;
        this.lrpFormaPago = lrpFormaPago;
        this.lrpDocumento = lrpDocumento;
        this.lrpContable = lrpContable;
        this.lrpObservaciones = lrpObservaciones;
        this.nacionalidad = nacionalidad;
    }

    public Boolean getLrpAcumulaFondoReserva() {
        return lrpAcumulaFondoReserva;
    }

    public void setLrpAcumulaFondoReserva(Boolean lrpAcumulaFondoReserva) {
        this.lrpAcumulaFondoReserva = lrpAcumulaFondoReserva;
    }

    public BigDecimal getLrpAnticipos() {
        return lrpAnticipos;
    }

    public void setLrpAnticipos(BigDecimal lrpAnticipos) {
        this.lrpAnticipos = lrpAnticipos;
    }

    public BigDecimal getLrpBonos() {
        return lrpBonos;
    }

    public void setLrpBonos(BigDecimal lrpBonos) {
        this.lrpBonos = lrpBonos;
    }

    public BigDecimal getLrpBonosFijo() {
        return lrpBonosFijo;
    }

    public void setLrpBonosFijo(BigDecimal lrpBonosFijo) {
        this.lrpBonosFijo = lrpBonosFijo;
    }

    public BigDecimal getLrpBonosFijoNd() {
        return lrpBonosFijoNd;
    }

    public void setLrpBonosFijoNd(BigDecimal lrpBonosFijoNd) {
        this.lrpBonosFijoNd = lrpBonosFijoNd;
    }

    public BigDecimal getLrpBonosnd() {
        return lrpBonosnd;
    }

    public void setLrpBonosnd(BigDecimal lrpBonosnd) {
        this.lrpBonosnd = lrpBonosnd;
    }

    public String getLrpCargo() {
        return lrpCargo;
    }

    public void setLrpCargo(String lrpCargo) {
        this.lrpCargo = lrpCargo;
    }

    public String getLrpContable() {
        return lrpContable;
    }

    public void setLrpContable(String lrpContable) {
        this.lrpContable = lrpContable;
    }

    public Integer getLrpDd() {
        return lrpDd;
    }

    public void setLrpDd(Integer lrpDd) {
        this.lrpDd = lrpDd;
    }

    public Integer getLrpDe() {
        return lrpDe;
    }

    public void setLrpDe(Integer lrpDe) {
        this.lrpDe = lrpDe;
    }

    public BigDecimal getLrpDescuentoPermisoMedico() {
        return lrpDescuentoPermisoMedico;
    }

    public void setLrpDescuentoPermisoMedico(BigDecimal lrpDescuentoPermisoMedico) {
        this.lrpDescuentoPermisoMedico = lrpDescuentoPermisoMedico;
    }

    public BigDecimal getLrpDescuentos() {
        return lrpDescuentos;
    }

    public void setLrpDescuentos(BigDecimal lrpDescuentos) {
        this.lrpDescuentos = lrpDescuentos;
    }

    public String getLrpDesde() {
        return lrpDesde;
    }

    public void setLrpDesde(String lrpDesde) {
        this.lrpDesde = lrpDesde;
    }

    public Integer getLrpDf() {
        return lrpDf;
    }

    public void setLrpDf(Integer lrpDf) {
        this.lrpDf = lrpDf;
    }

    public Integer getLrpDl() {
        return lrpDl;
    }

    public void setLrpDl(Integer lrpDl) {
        this.lrpDl = lrpDl;
    }

    public String getLrpDocumento() {
        return lrpDocumento;
    }

    public void setLrpDocumento(String lrpDocumento) {
        this.lrpDocumento = lrpDocumento;
    }

    public Integer getLrpDp() {
        return lrpDp;
    }

    public void setLrpDp(Integer lrpDp) {
        this.lrpDp = lrpDp;
    }

    public Integer getLrpDpm() {
        return lrpDpm;
    }

    public void setLrpDpm(Integer lrpDpm) {
        this.lrpDpm = lrpDpm;
    }

    public BigDecimal getLrpFondoReserva() {
        return lrpFondoReserva;
    }

    public void setLrpFondoReserva(BigDecimal lrpFondoReserva) {
        this.lrpFondoReserva = lrpFondoReserva;
    }

    public String getLrpFormaPago() {
        return lrpFormaPago;
    }

    public void setLrpFormaPago(String lrpFormaPago) {
        this.lrpFormaPago = lrpFormaPago;
    }

    public String getLrpHasta() {
        return lrpHasta;
    }

    public void setLrpHasta(String lrpHasta) {
        this.lrpHasta = lrpHasta;
    }

    public String getLrpId() {
        return lrpId;
    }

    public void setLrpId(String lrpId) {
        this.lrpId = lrpId;
    }

    public BigDecimal getLrpIess() {
        return lrpIess;
    }

    public void setLrpIess(BigDecimal lrpIess) {
        this.lrpIess = lrpIess;
    }

    public BigDecimal getLrpIngresos() {
        return lrpIngresos;
    }

    public void setLrpIngresos(BigDecimal lrpIngresos) {
        this.lrpIngresos = lrpIngresos;
    }

    public BigDecimal getLrpLiquidacion() {
        return lrpLiquidacion;
    }

    public void setLrpLiquidacion(BigDecimal lrpLiquidacion) {
        this.lrpLiquidacion = lrpLiquidacion;
    }

    public BigDecimal getLrpLiquidacionBonificacion() {
        return lrpLiquidacionBonificacion;
    }

    public void setLrpLiquidacionBonificacion(BigDecimal lrpLiquidacionBonificacion) {
        this.lrpLiquidacionBonificacion = lrpLiquidacionBonificacion;
    }

    public BigDecimal getLrpLiquidacionDesahucio() {
        return lrpLiquidacionDesahucio;
    }

    public void setLrpLiquidacionDesahucio(BigDecimal lrpLiquidacionDesahucio) {
        this.lrpLiquidacionDesahucio = lrpLiquidacionDesahucio;
    }

    public BigDecimal getLrpLiquidacionDesahucioIntempestivo() {
        return lrpLiquidacionDesahucioIntempestivo;
    }

    public void setLrpLiquidacionDesahucioIntempestivo(BigDecimal lrpLiquidacionDesahucioIntempestivo) {
        this.lrpLiquidacionDesahucioIntempestivo = lrpLiquidacionDesahucioIntempestivo;
    }

    public BigDecimal getLrpLiquidacionSalarioDigno() {
        return lrpLiquidacionSalarioDigno;
    }

    public void setLrpLiquidacionSalarioDigno(BigDecimal lrpLiquidacionSalarioDigno) {
        this.lrpLiquidacionSalarioDigno = lrpLiquidacionSalarioDigno;
    }

    public BigDecimal getLrpLiquidacionVacaciones() {
        return lrpLiquidacionVacaciones;
    }

    public void setLrpLiquidacionVacaciones(BigDecimal lrpLiquidacionVacaciones) {
        this.lrpLiquidacionVacaciones = lrpLiquidacionVacaciones;
    }

    public BigDecimal getLrpLiquidacionXiii() {
        return lrpLiquidacionXiii;
    }

    public void setLrpLiquidacionXiii(BigDecimal lrpLiquidacionXiii) {
        this.lrpLiquidacionXiii = lrpLiquidacionXiii;
    }

    public BigDecimal getLrpLiquidacionXiv() {
        return lrpLiquidacionXiv;
    }

    public void setLrpLiquidacionXiv(BigDecimal lrpLiquidacionXiv) {
        this.lrpLiquidacionXiv = lrpLiquidacionXiv;
    }

    public String getLrpNombres() {
        return lrpNombres;
    }

    public void setLrpNombres(String lrpNombres) {
        this.lrpNombres = lrpNombres;
    }

    public String getLrpObservaciones() {
        return lrpObservaciones;
    }

    public void setLrpObservaciones(String lrpObservaciones) {
        this.lrpObservaciones = lrpObservaciones;
    }

    public BigDecimal getLrpOtrosIngresos() {
        return lrpOtrosIngresos;
    }

    public void setLrpOtrosIngresos(BigDecimal lrpOtrosIngresos) {
        this.lrpOtrosIngresos = lrpOtrosIngresos;
    }

    public BigDecimal getLrpOtrosIngresosNd() {
        return lrpOtrosIngresosNd;
    }

    public void setLrpOtrosIngresosNd(BigDecimal lrpOtrosIngresosNd) {
        this.lrpOtrosIngresosNd = lrpOtrosIngresosNd;
    }

    public BigDecimal getLrpPrestamos() {
        return lrpPrestamos;
    }

    public void setLrpPrestamos(BigDecimal lrpPrestamos) {
        this.lrpPrestamos = lrpPrestamos;
    }

    public BigDecimal getLrpRetencion() {
        return lrpRetencion;
    }

    public void setLrpRetencion(BigDecimal lrpRetencion) {
        this.lrpRetencion = lrpRetencion;
    }

    public BigDecimal getLrpSaldo() {
        return lrpSaldo;
    }

    public void setLrpSaldo(BigDecimal lrpSaldo) {
        this.lrpSaldo = lrpSaldo;
    }

    public BigDecimal getLrpSueldo() {
        return lrpSueldo;
    }

    public void setLrpSueldo(BigDecimal lrpSueldo) {
        this.lrpSueldo = lrpSueldo;
    }

    public BigDecimal getLrpTotal() {
        return lrpTotal;
    }

    public void setLrpTotal(BigDecimal lrpTotal) {
        this.lrpTotal = lrpTotal;
    }

    public BigDecimal getLrpTotalIngresos() {
        return lrpTotalIngresos;
    }

    public void setLrpTotalIngresos(BigDecimal lrpTotalIngresos) {
        this.lrpTotalIngresos = lrpTotalIngresos;
    }

    public BigDecimal getLrpViaticos() {
        return lrpViaticos;
    }

    public void setLrpViaticos(BigDecimal lrpViaticos) {
        this.lrpViaticos = lrpViaticos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
