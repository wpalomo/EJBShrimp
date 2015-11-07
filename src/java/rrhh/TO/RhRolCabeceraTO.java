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
public class RhRolCabeceraTO implements Serializable{

    private String empresa;
    private String perCodigo;//null
    private String tipCodigo;//null
    private String conNumero;//null
    private String fechaDesde;
    private String fechaHasta;
    private String categoria;
    private String sector;
    private String formaPago;
    private String documento;
    private String observaciones;
    private String usuario;
    private Boolean porPagar;//agregado
    private Boolean liquidacion;//agregado
    private Boolean grabar;//agregado
    RhContableTO rhContableTO;//agregado

    public RhRolCabeceraTO() {
    }

    public RhRolCabeceraTO(String empresa, String perCodigo, String tipCodigo, String conNumero, String fechaDesde, String fechaHasta, String categoria, String sector, String formaPago, String documento, String observaciones, String usuario, Boolean porPagar, Boolean liquidacion, Boolean grabar) {
        this.empresa = empresa;
        this.perCodigo = perCodigo;
        this.tipCodigo = tipCodigo;
        this.conNumero = conNumero;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.categoria = categoria;
        this.sector = sector;
        this.formaPago = formaPago;
        this.documento = documento;
        this.observaciones = observaciones;
        this.usuario = usuario;
        this.porPagar = porPagar;
        this.liquidacion = liquidacion;
        this.grabar = grabar;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Boolean getGrabar() {
        return grabar;
    }

    public void setGrabar(Boolean grabar) {
        this.grabar = grabar;
    }

    public Boolean getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(Boolean liquidacion) {
        this.liquidacion = liquidacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Boolean getPorPagar() {
        return porPagar;
    }

    public void setPorPagar(Boolean porPagar) {
        this.porPagar = porPagar;
    }

    public RhContableTO getRhContableTO() {
        return rhContableTO;
    }

    public void setRhContableTO(RhContableTO rhContableTO) {
        this.rhContableTO = rhContableTO;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
