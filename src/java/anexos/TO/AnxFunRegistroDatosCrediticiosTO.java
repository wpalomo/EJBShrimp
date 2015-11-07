/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.TO;

import java.math.BigDecimal;

/**
 *
 * @author charly
 */
public class AnxFunRegistroDatosCrediticiosTO implements java.io.Serializable{
    private String cliCodigoDinardap;
    private String cliFechaCorte;
    private Character cliTipoId;
    private String cliID;
    private String cliNombre;
    private Character cliClaseSujeto;
    private String cliProvincia;
    private String cliCiudad;
    private String cliParroquia;
    private String cliSexo;
    private String cliEstadoCivil;
    private String cliOrigenIngreso;
    private String vtaDocumentoNumero;
    private BigDecimal vtaTotal;
    private BigDecimal vtaSaldo;
    private String vtaFechaConcecion;
    private String VtaFechaVencimiento;
    private String vtaFechaExigible;
    private BigDecimal vtaPlazoOperacion;
    private BigDecimal vtaPeriodicidadPago;
    private BigDecimal vtaDiasMorosidad;
    private BigDecimal vtaMontoMorosidad;
    private BigDecimal vtaMontoInteresMora;
    private BigDecimal vtaValorPorVencer0130;
    private BigDecimal vtaValorPorVencer3190;
    private BigDecimal vtaValorPorVencer91180;
    private BigDecimal vtaValorporVencer181360;
    private BigDecimal vtaValorPorVencerMas360;
    private BigDecimal vtaValorVencido0130;
    private BigDecimal vtaValorVencido3190;
    private BigDecimal vtaValorVencido91180;
    private BigDecimal vtaValorVencido181360;
    private BigDecimal vtaValorVencidomas360;
    private BigDecimal vtaValorDemandaJudicial;
    private BigDecimal vtaCarteraCastigada;
    private BigDecimal vtaCuotaCredito;
    private String vtaFechaCancelacion;
    private Character vtaFormaCancelacion;

    public AnxFunRegistroDatosCrediticiosTO() {
    }

    public AnxFunRegistroDatosCrediticiosTO(String cliCodigoDinardap, String cliFechaCorte, Character cliTipoId, String cliID, String cliNombre, Character cliClaseSujeto, String cliProvincia, String cliCiudad, String cliParroquia, String cliSexo, String cliEstadoCivil, String cliOrigenIngreso, String vtaDocumentoNumero, BigDecimal vtaTotal, BigDecimal vtaSaldo, String vtaFechaConcecion, String VtaFechaVencimiento, String vtaFechaExigible, BigDecimal vtaPlazoOperacion, BigDecimal vtaPeriodicidadPago, BigDecimal vtaDiasMorosidad, BigDecimal vtaMontoMorosidad, BigDecimal vtaMontoInteresMora, BigDecimal vtaValorPorVencer0130, BigDecimal vtaValorPorVencer3190, BigDecimal vtaValorPorVencer91180, BigDecimal vtaValorporVencer181360, BigDecimal vtaValorPorVencerMas360, BigDecimal vtaValorVencido0130, BigDecimal vtaValorVencido3190, BigDecimal vtaValorVencido91180, BigDecimal vtaValorVencido181360, BigDecimal vtaValorVencidomas360, BigDecimal vtaValorDemandaJudicial, BigDecimal vtaCarteraCastigada, BigDecimal vtaCuotaCredito, String vtaFechaCancelacion, Character vtaFormaCancelacion) {
        this.cliCodigoDinardap = cliCodigoDinardap;
        this.cliFechaCorte = cliFechaCorte;
        this.cliTipoId = cliTipoId;
        this.cliID = cliID;
        this.cliNombre = cliNombre;
        this.cliClaseSujeto = cliClaseSujeto;
        this.cliProvincia = cliProvincia;
        this.cliCiudad = cliCiudad;
        this.cliParroquia = cliParroquia;
        this.cliSexo = cliSexo;
        this.cliEstadoCivil = cliEstadoCivil;
        this.cliOrigenIngreso = cliOrigenIngreso;
        this.vtaDocumentoNumero = vtaDocumentoNumero;
        this.vtaTotal = vtaTotal;
        this.vtaSaldo = vtaSaldo;
        this.vtaFechaConcecion = vtaFechaConcecion;
        this.VtaFechaVencimiento = VtaFechaVencimiento;
        this.vtaFechaExigible = vtaFechaExigible;
        this.vtaPlazoOperacion = vtaPlazoOperacion;
        this.vtaPeriodicidadPago = vtaPeriodicidadPago;
        this.vtaDiasMorosidad = vtaDiasMorosidad;
        this.vtaMontoMorosidad = vtaMontoMorosidad;
        this.vtaMontoInteresMora = vtaMontoInteresMora;
        this.vtaValorPorVencer0130 = vtaValorPorVencer0130;
        this.vtaValorPorVencer3190 = vtaValorPorVencer3190;
        this.vtaValorPorVencer91180 = vtaValorPorVencer91180;
        this.vtaValorporVencer181360 = vtaValorporVencer181360;
        this.vtaValorPorVencerMas360 = vtaValorPorVencerMas360;
        this.vtaValorVencido0130 = vtaValorVencido0130;
        this.vtaValorVencido3190 = vtaValorVencido3190;
        this.vtaValorVencido91180 = vtaValorVencido91180;
        this.vtaValorVencido181360 = vtaValorVencido181360;
        this.vtaValorVencidomas360 = vtaValorVencidomas360;
        this.vtaValorDemandaJudicial = vtaValorDemandaJudicial;
        this.vtaCarteraCastigada = vtaCarteraCastigada;
        this.vtaCuotaCredito = vtaCuotaCredito;
        this.vtaFechaCancelacion = vtaFechaCancelacion;
        this.vtaFormaCancelacion = vtaFormaCancelacion;
    }

    public String getVtaFechaVencimiento() {
        return VtaFechaVencimiento;
    }

    public void setVtaFechaVencimiento(String VtaFechaVencimiento) {
        this.VtaFechaVencimiento = VtaFechaVencimiento;
    }

    public String getCliCiudad() {
        return cliCiudad;
    }

    public void setCliCiudad(String cliCiudad) {
        this.cliCiudad = cliCiudad;
    }

    public Character getCliClaseSujeto() {
        return cliClaseSujeto;
    }

    public void setCliClaseSujeto(Character cliClaseSujeto) {
        this.cliClaseSujeto = cliClaseSujeto;
    }

    public String getCliCodigoDinardap() {
        return cliCodigoDinardap;
    }

    public void setCliCodigoDinardap(String cliCodigoDinardap) {
        this.cliCodigoDinardap = cliCodigoDinardap;
    }

    public String getCliEstadoCivil() {
        return cliEstadoCivil;
    }

    public void setCliEstadoCivil(String cliEstadoCivil) {
        this.cliEstadoCivil = cliEstadoCivil;
    }

    public String getCliFechaCorte() {
        return cliFechaCorte;
    }

    public void setCliFechaCorte(String cliFechaCorte) {
        this.cliFechaCorte = cliFechaCorte;
    }

    public String getCliID() {
        return cliID;
    }

    public void setCliID(String cliID) {
        this.cliID = cliID;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliOrigenIngreso() {
        return cliOrigenIngreso;
    }

    public void setCliOrigenIngreso(String cliOrigenIngreso) {
        this.cliOrigenIngreso = cliOrigenIngreso;
    }

    public String getCliParroquia() {
        return cliParroquia;
    }

    public void setCliParroquia(String cliParroquia) {
        this.cliParroquia = cliParroquia;
    }

    public String getCliProvincia() {
        return cliProvincia;
    }

    public void setCliProvincia(String cliProvincia) {
        this.cliProvincia = cliProvincia;
    }

    public String getCliSexo() {
        return cliSexo;
    }

    public void setCliSexo(String cliSexo) {
        this.cliSexo = cliSexo;
    }

    public Character getCliTipoId() {
        return cliTipoId;
    }

    public void setCliTipoId(Character cliTipoId) {
        this.cliTipoId = cliTipoId;
    }

    public BigDecimal getVtaCarteraCastigada() {
        return vtaCarteraCastigada;
    }

    public void setVtaCarteraCastigada(BigDecimal vtaCarteraCastigada) {
        this.vtaCarteraCastigada = vtaCarteraCastigada;
    }

    public BigDecimal getVtaCuotaCredito() {
        return vtaCuotaCredito;
    }

    public void setVtaCuotaCredito(BigDecimal vtaCuotaCredito) {
        this.vtaCuotaCredito = vtaCuotaCredito;
    }

    public BigDecimal getVtaDiasMorosidad() {
        return vtaDiasMorosidad;
    }

    public void setVtaDiasMorosidad(BigDecimal vtaDiasMorosidad) {
        this.vtaDiasMorosidad = vtaDiasMorosidad;
    }

    public String getVtaDocumentoNumero() {
        return vtaDocumentoNumero;
    }

    public void setVtaDocumentoNumero(String vtaDocumentoNumero) {
        this.vtaDocumentoNumero = vtaDocumentoNumero;
    }

    public String getVtaFechaCancelacion() {
        return vtaFechaCancelacion;
    }

    public void setVtaFechaCancelacion(String vtaFechaCancelacion) {
        this.vtaFechaCancelacion = vtaFechaCancelacion;
    }

    public String getVtaFechaConcecion() {
        return vtaFechaConcecion;
    }

    public void setVtaFechaConcecion(String vtaFechaConcecion) {
        this.vtaFechaConcecion = vtaFechaConcecion;
    }

    public String getVtaFechaExigible() {
        return vtaFechaExigible;
    }

    public void setVtaFechaExigible(String vtaFechaExigible) {
        this.vtaFechaExigible = vtaFechaExigible;
    }

    public Character getVtaFormaCancelacion() {
        return vtaFormaCancelacion;
    }

    public void setVtaFormaCancelacion(Character vtaFormaCancelacion) {
        this.vtaFormaCancelacion = vtaFormaCancelacion;
    }

    public BigDecimal getVtaMontoInteresMora() {
        return vtaMontoInteresMora;
    }

    public void setVtaMontoInteresMora(BigDecimal vtaMontoInteresMora) {
        this.vtaMontoInteresMora = vtaMontoInteresMora;
    }

    public BigDecimal getVtaMontoMorosidad() {
        return vtaMontoMorosidad;
    }

    public void setVtaMontoMorosidad(BigDecimal vtaMontoMorosidad) {
        this.vtaMontoMorosidad = vtaMontoMorosidad;
    }

    public BigDecimal getVtaPeriodicidadPago() {
        return vtaPeriodicidadPago;
    }

    public void setVtaPeriodicidadPago(BigDecimal vtaPeriodicidadPago) {
        this.vtaPeriodicidadPago = vtaPeriodicidadPago;
    }

    public BigDecimal getVtaPlazoOperacion() {
        return vtaPlazoOperacion;
    }

    public void setVtaPlazoOperacion(BigDecimal vtaPlazoOperacion) {
        this.vtaPlazoOperacion = vtaPlazoOperacion;
    }

    public BigDecimal getVtaSaldo() {
        return vtaSaldo;
    }

    public void setVtaSaldo(BigDecimal vtaSaldo) {
        this.vtaSaldo = vtaSaldo;
    }

    public BigDecimal getVtaTotal() {
        return vtaTotal;
    }

    public void setVtaTotal(BigDecimal vtaTotal) {
        this.vtaTotal = vtaTotal;
    }

    public BigDecimal getVtaValorDemandaJudicial() {
        return vtaValorDemandaJudicial;
    }

    public void setVtaValorDemandaJudicial(BigDecimal vtaValorDemandaJudicial) {
        this.vtaValorDemandaJudicial = vtaValorDemandaJudicial;
    }

    public BigDecimal getVtaValorPorVencer0130() {
        return vtaValorPorVencer0130;
    }

    public void setVtaValorPorVencer0130(BigDecimal vtaValorPorVencer0130) {
        this.vtaValorPorVencer0130 = vtaValorPorVencer0130;
    }

    public BigDecimal getVtaValorPorVencer3190() {
        return vtaValorPorVencer3190;
    }

    public void setVtaValorPorVencer3190(BigDecimal vtaValorPorVencer3190) {
        this.vtaValorPorVencer3190 = vtaValorPorVencer3190;
    }

    public BigDecimal getVtaValorPorVencer91180() {
        return vtaValorPorVencer91180;
    }

    public void setVtaValorPorVencer91180(BigDecimal vtaValorPorVencer91180) {
        this.vtaValorPorVencer91180 = vtaValorPorVencer91180;
    }

    public BigDecimal getVtaValorPorVencerMas360() {
        return vtaValorPorVencerMas360;
    }

    public void setVtaValorPorVencerMas360(BigDecimal vtaValorPorVencerMas360) {
        this.vtaValorPorVencerMas360 = vtaValorPorVencerMas360;
    }

    public BigDecimal getVtaValorVencido0130() {
        return vtaValorVencido0130;
    }

    public void setVtaValorVencido0130(BigDecimal vtaValorVencido0130) {
        this.vtaValorVencido0130 = vtaValorVencido0130;
    }

    public BigDecimal getVtaValorVencido181360() {
        return vtaValorVencido181360;
    }

    public void setVtaValorVencido181360(BigDecimal vtaValorVencido181360) {
        this.vtaValorVencido181360 = vtaValorVencido181360;
    }

    public BigDecimal getVtaValorVencido3190() {
        return vtaValorVencido3190;
    }

    public void setVtaValorVencido3190(BigDecimal vtaValorVencido3190) {
        this.vtaValorVencido3190 = vtaValorVencido3190;
    }

    public BigDecimal getVtaValorVencido91180() {
        return vtaValorVencido91180;
    }

    public void setVtaValorVencido91180(BigDecimal vtaValorVencido91180) {
        this.vtaValorVencido91180 = vtaValorVencido91180;
    }

    public BigDecimal getVtaValorVencidomas360() {
        return vtaValorVencidomas360;
    }

    public void setVtaValorVencidomas360(BigDecimal vtaValorVencidomas360) {
        this.vtaValorVencidomas360 = vtaValorVencidomas360;
    }

    public BigDecimal getVtaValorporVencer181360() {
        return vtaValorporVencer181360;
    }

    public void setVtaValorporVencer181360(BigDecimal vtaValorporVencer181360) {
        this.vtaValorporVencer181360 = vtaValorporVencer181360;
    }
}
