/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.reporte;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ReporteResumenSiembra {
    private String rcSector;
    private String pisNumero;
    private String rcCorrida;
    private java.math.BigDecimal rcHectareaje;
    private String rcFechaSiembra;
    private java.math.BigDecimal rcDiasCultivo;
    private java.math.BigDecimal rcDiasInactivos;
    private java.math.BigDecimal rcDensidad;
    private String rcLaboratorio;
    private String rcNauplio;
    private java.math.BigDecimal rcBiomasaProy;
    private java.math.BigDecimal rcBiomasaReal;
    private java.math.BigDecimal rcConversionAlim;
    private java.math.BigDecimal rcGramos;
    private String rcSobrevivencia;
    private java.math.BigDecimal rcCosto;
    private java.math.BigDecimal rcDirecto;
    private java.math.BigDecimal rcIndirecto;
    private java.math.BigDecimal rcSubtotal1;
    private java.math.BigDecimal rcAdministrativo;
    private java.math.BigDecimal rcFinanciero;
    private java.math.BigDecimal rcGND;
    private java.math.BigDecimal rcSubtotal2;
    private java.math.BigDecimal rcTotal;

    public ReporteResumenSiembra() {
    }

    public ReporteResumenSiembra(String rcSector, String pisNumero, String rcCorrida, BigDecimal rcHectareaje, String rcFechaSiembra, BigDecimal rcDiasCultivo, BigDecimal rcDiasInactivos, BigDecimal rcDensidad, String rcLaboratorio, String rcNauplio, BigDecimal rcBiomasaProy, BigDecimal rcBiomasaReal, BigDecimal rcConversionAlim, BigDecimal rcGramos, String rcSobrevivencia, BigDecimal rcCosto, BigDecimal rcDirecto, BigDecimal rcIndirecto, BigDecimal rcSubtotal1, BigDecimal rcAdministrativo, BigDecimal rcFinanciero, BigDecimal rcGND, BigDecimal rcSubtotal2, BigDecimal rcTotal) {
        this.rcSector = rcSector;
        this.pisNumero = pisNumero;
        this.rcCorrida = rcCorrida;
        this.rcHectareaje = rcHectareaje;
        this.rcFechaSiembra = rcFechaSiembra;
        this.rcDiasCultivo = rcDiasCultivo;
        this.rcDiasInactivos = rcDiasInactivos;
        this.rcDensidad = rcDensidad;
        this.rcLaboratorio = rcLaboratorio;
        this.rcNauplio = rcNauplio;
        this.rcBiomasaProy = rcBiomasaProy;
        this.rcBiomasaReal = rcBiomasaReal;
        this.rcConversionAlim = rcConversionAlim;
        this.rcGramos = rcGramos;
        this.rcSobrevivencia = rcSobrevivencia;
        this.rcCosto = rcCosto;
        this.rcDirecto = rcDirecto;
        this.rcIndirecto = rcIndirecto;
        this.rcSubtotal1 = rcSubtotal1;
        this.rcAdministrativo = rcAdministrativo;
        this.rcFinanciero = rcFinanciero;
        this.rcGND = rcGND;
        this.rcSubtotal2 = rcSubtotal2;
        this.rcTotal = rcTotal;
    }

    

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
    }

    public BigDecimal getRcBiomasaReal() {
        return rcBiomasaReal;
    }

    public void setRcBiomasaReal(BigDecimal rcBiomasaReal) {
        this.rcBiomasaReal = rcBiomasaReal;
    }

    
    
    public BigDecimal getRcCosto() {
        return rcCosto;
    }

    public void setRcCosto(BigDecimal rcCosto) {
        this.rcCosto = rcCosto;
    }

    

    public String getRcSector() {
        return rcSector;
    }

    public void setRcSector(String rcSector) {
        this.rcSector = rcSector;
    }

   

    public String getRcCorrida() {
        return rcCorrida;
    }

    public void setRcCorrida(String rcCorrida) {
        this.rcCorrida = rcCorrida;
    }

    public BigDecimal getRcHectareaje() {
        return rcHectareaje;
    }

    public void setRcHectareaje(BigDecimal rcHectareaje) {
        this.rcHectareaje = rcHectareaje;
    }

    public String getRcFechaSiembra() {
        return rcFechaSiembra;
    }

    public void setRcFechaSiembra(String rcFechaSiembra) {
        this.rcFechaSiembra = rcFechaSiembra;
    }

    public BigDecimal getRcDiasCultivo() {
        return rcDiasCultivo;
    }

    public void setRcDiasCultivo(BigDecimal rcDiasCultivo) {
        this.rcDiasCultivo = rcDiasCultivo;
    }

    public BigDecimal getRcDiasInactivos() {
        return rcDiasInactivos;
    }

    public void setRcDiasInactivos(BigDecimal rcDiasInactivos) {
        this.rcDiasInactivos = rcDiasInactivos;
    }

    public java.math.BigDecimal getRcDensidad() {
        return rcDensidad;
    }

    public void setRcDensidad(java.math.BigDecimal rcDensidad) {
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

    public BigDecimal getRcBiomasaProy() {
        return rcBiomasaProy;
    }

    public void setRcBiomasaProy(BigDecimal rcBiomasaProy) {
        this.rcBiomasaProy = rcBiomasaProy;
    }

    public BigDecimal getRcConversionAlim() {
        return rcConversionAlim;
    }

    public void setRcConversionAlim(BigDecimal rcConversionAlim) {
        this.rcConversionAlim = rcConversionAlim;
    }

    public BigDecimal getRcGramos() {
        return rcGramos;
    }

    public void setRcGramos(BigDecimal rcGramos) {
        this.rcGramos = rcGramos;
    }

    public String getRcSobrevivencia() {
        return rcSobrevivencia;
    }

    public void setRcSobrevivencia(String rcSobrevivencia) {
        this.rcSobrevivencia = rcSobrevivencia;
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

    public BigDecimal getRcSubtotal1() {
        return rcSubtotal1;
    }

    public void setRcSubtotal1(BigDecimal rcSubtotal1) {
        this.rcSubtotal1 = rcSubtotal1;
    }

    public BigDecimal getRcAdministrativo() {
        return rcAdministrativo;
    }

    public void setRcAdministrativo(BigDecimal rcAdministrativo) {
        this.rcAdministrativo = rcAdministrativo;
    }

    public BigDecimal getRcFinanciero() {
        return rcFinanciero;
    }

    public void setRcFinanciero(BigDecimal rcFinanciero) {
        this.rcFinanciero = rcFinanciero;
    }

    public BigDecimal getRcGND() {
        return rcGND;
    }

    public void setRcGND(BigDecimal rcGND) {
        this.rcGND = rcGND;
    }

    public BigDecimal getRcSubtotal2() {
        return rcSubtotal2;
    }

    public void setRcSubtotal2(BigDecimal rcSubtotal2) {
        this.rcSubtotal2 = rcSubtotal2;
    }

    public BigDecimal getRcTotal() {
        return rcTotal;
    }

    public void setRcTotal(BigDecimal rcTotal) {
        this.rcTotal = rcTotal;
    }
}
