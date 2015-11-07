/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabilidad.reporte;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ReporteContableDetalle {

    //////////titulo reporte
    private String titulo;

    ///////////contable
    private String empCodigo;
    private String perCodigo;
    private String tipCodigo;
    private String conNumero;
    private String conFecha;
    private Boolean conPendiente;
    private Boolean conRevisado;
    private Boolean conAnulado;
    private Boolean conGenerado;
    private String conConcepto;
    private String conDetalle;
    private String conObservaciones;
    private String usrInserta;
    private String usrFechaInserta;
    
    private String impElaborado;
    private String impAprobado;
    private String impRevisado;
    private String impContabilidad;

    ///////////detalle
    private String conCtaCodigoPadre;
    private String conNombreCuentaPadre;
    private String conCtaCodigo;
    private String conNombreCuenta;
    private String detCentroProduccion;
    private String detCentroCosto;
    private String detDocumento;
    private Character detDebitoCredito;
    private java.math.BigDecimal detValor;
    private Boolean detGenerado;
    private String detReferencia;
    private Integer detOrden;
    private Integer detSecuencia;

    public ReporteContableDetalle() {
    }

    public ReporteContableDetalle(String titulo, String empCodigo, String perCodigo, String tipCodigo, String conNumero, String conFecha, Boolean conPendiente, Boolean conRevisado, Boolean conAnulado, Boolean conGenerado, String conConcepto, String conDetalle, String conObservaciones, String usrInserta, String usrFechaInserta, String conCtaCodigoPadre, String conNombreCuentaPadre, String conCtaCodigo, String conNombreCuenta, String detCentroProduccion, String detCentroCosto, String detDocumento, Character detDebitoCredito, BigDecimal detValor, Boolean detGenerado, String detReferencia, Integer detOrden, Integer detSecuencia) {
        this.titulo = titulo;
        this.empCodigo = empCodigo;
        this.perCodigo = perCodigo;
        this.tipCodigo = tipCodigo;
        this.conNumero = conNumero;
        this.conFecha = conFecha;
        this.conPendiente = conPendiente;
        this.conRevisado = conRevisado;
        this.conAnulado = conAnulado;
        this.conGenerado = conGenerado;
        this.conConcepto = conConcepto;
        this.conDetalle = conDetalle;
        this.conObservaciones = conObservaciones;
        this.usrInserta = usrInserta;
        this.usrFechaInserta = usrFechaInserta;
        this.conCtaCodigoPadre = conCtaCodigoPadre;
        this.conNombreCuentaPadre = conNombreCuentaPadre;
        this.conCtaCodigo = conCtaCodigo;
        this.conNombreCuenta = conNombreCuenta;
        this.detCentroProduccion = detCentroProduccion;
        this.detCentroCosto = detCentroCosto;
        this.detDocumento = detDocumento;
        this.detDebitoCredito = detDebitoCredito;
        this.detValor = detValor;
        this.detGenerado = detGenerado;
        this.detReferencia = detReferencia;
        this.detOrden = detOrden;
        this.detSecuencia = detSecuencia;
    }

    public Boolean getConAnulado() {
        return conAnulado;
    }

    public void setConAnulado(Boolean conAnulado) {
        this.conAnulado = conAnulado;
    }

    public String getConConcepto() {
        return conConcepto;
    }

    public void setConConcepto(String conConcepto) {
        this.conConcepto = conConcepto;
    }

    public String getConCtaCodigo() {
        return conCtaCodigo;
    }

    public void setConCtaCodigo(String conCtaCodigo) {
        this.conCtaCodigo = conCtaCodigo;
    }

    public String getConCtaCodigoPadre() {
        return conCtaCodigoPadre;
    }

    public void setConCtaCodigoPadre(String conCtaCodigoPadre) {
        this.conCtaCodigoPadre = conCtaCodigoPadre;
    }

    public String getConDetalle() {
        return conDetalle;
    }

    public void setConDetalle(String conDetalle) {
        this.conDetalle = conDetalle;
    }

    public String getConFecha() {
        return conFecha;
    }

    public void setConFecha(String conFecha) {
        this.conFecha = conFecha;
    }

    public Boolean getConGenerado() {
        return conGenerado;
    }

    public void setConGenerado(Boolean conGenerado) {
        this.conGenerado = conGenerado;
    }

    public String getConNombreCuenta() {
        return conNombreCuenta;
    }

    public void setConNombreCuenta(String conNombreCuenta) {
        this.conNombreCuenta = conNombreCuenta;
    }

    public String getConNombreCuentaPadre() {
        return conNombreCuentaPadre;
    }

    public void setConNombreCuentaPadre(String conNombreCuentaPadre) {
        this.conNombreCuentaPadre = conNombreCuentaPadre;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConObservaciones() {
        return conObservaciones;
    }

    public void setConObservaciones(String conObservaciones) {
        this.conObservaciones = conObservaciones;
    }

    public Boolean getConPendiente() {
        return conPendiente;
    }

    public void setConPendiente(Boolean conPendiente) {
        this.conPendiente = conPendiente;
    }

    public Boolean getConRevisado() {
        return conRevisado;
    }

    public void setConRevisado(Boolean conRevisado) {
        this.conRevisado = conRevisado;
    }

    public String getDetCentroCosto() {
        return detCentroCosto;
    }

    public void setDetCentroCosto(String detCentroCosto) {
        this.detCentroCosto = detCentroCosto;
    }

    public String getDetCentroProduccion() {
        return detCentroProduccion;
    }

    public void setDetCentroProduccion(String detCentroProduccion) {
        this.detCentroProduccion = detCentroProduccion;
    }

    public Character getDetDebitoCredito() {
        return detDebitoCredito;
    }

    public void setDetDebitoCredito(Character detDebitoCredito) {
        this.detDebitoCredito = detDebitoCredito;
    }

    public String getDetDocumento() {
        return detDocumento;
    }

    public void setDetDocumento(String detDocumento) {
        this.detDocumento = detDocumento;
    }

    public Boolean getDetGenerado() {
        return detGenerado;
    }

    public void setDetGenerado(Boolean detGenerado) {
        this.detGenerado = detGenerado;
    }

    public Integer getDetOrden() {
        return detOrden;
    }

    public void setDetOrden(Integer detOrden) {
        this.detOrden = detOrden;
    }

    public String getDetReferencia() {
        return detReferencia;
    }

    public void setDetReferencia(String detReferencia) {
        this.detReferencia = detReferencia;
    }

    public Integer getDetSecuencia() {
        return detSecuencia;
    }

    public void setDetSecuencia(Integer detSecuencia) {
        this.detSecuencia = detSecuencia;
    }

    public BigDecimal getDetValor() {
        return detValor;
    }

    public void setDetValor(BigDecimal detValor) {
        this.detValor = detValor;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }

    public String getUsrInserta() {
        return usrInserta;
    }

    public void setUsrInserta(String usrInserta) {
        this.usrInserta = usrInserta;
    }

    public String getImpAprobado() {
        return impAprobado;
    }

    public void setImpAprobado(String impAprobado) {
        this.impAprobado = impAprobado;
    }

    public String getImpContabilidad() {
        return impContabilidad;
    }

    public void setImpContabilidad(String impContabilidad) {
        this.impContabilidad = impContabilidad;
    }

    public String getImpElaborado() {
        return impElaborado;
    }

    public void setImpElaborado(String impElaborado) {
        this.impElaborado = impElaborado;
    }

    public String getImpRevisado() {
        return impRevisado;
    }

    public void setImpRevisado(String impRevisado) {
        this.impRevisado = impRevisado;
    }
    
}
