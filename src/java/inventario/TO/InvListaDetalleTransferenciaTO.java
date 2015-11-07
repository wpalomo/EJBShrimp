/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class InvListaDetalleTransferenciaTO implements java.io.Serializable{
    private Integer detSecuencial;
    private String bodOrigenCodigo;
    private String bodDestinoCodigo;
    private String proCodigoPrincipal;
    private String proNombre;
    private java.math.BigDecimal detCantidad;
    private String medDetalle;
    private String cpOrigen;
    private String cpDestino;
    private java.math.BigDecimal cantidadCaja;
    private String empaque;
    private String presentacionUnidad;
    private String presentacionCaja;

    public InvListaDetalleTransferenciaTO() {
    }

    public InvListaDetalleTransferenciaTO(Integer detSecuencial, String bodOrigenCodigo, String bodDestinoCodigo, String proCodigoPrincipal, String proNombre, BigDecimal detCantidad, String medDetalle, String cpOrigen, String cpDestino, BigDecimal cantidadCaja, String empaque, String presentacionUnidad, String presentacionCaja) {
        this.detSecuencial = detSecuencial;
        this.bodOrigenCodigo = bodOrigenCodigo;
        this.bodDestinoCodigo = bodDestinoCodigo;
        this.proCodigoPrincipal = proCodigoPrincipal;
        this.proNombre = proNombre;
        this.detCantidad = detCantidad;
        this.medDetalle = medDetalle;
        this.cpOrigen = cpOrigen;
        this.cpDestino = cpDestino;
        this.cantidadCaja = cantidadCaja;
        this.empaque = empaque;
        this.presentacionUnidad = presentacionUnidad;
        this.presentacionCaja = presentacionCaja;
    }

    public String getBodDestinoCodigo() {
        return bodDestinoCodigo;
    }

    public void setBodDestinoCodigo(String bodDestinoCodigo) {
        this.bodDestinoCodigo = bodDestinoCodigo;
    }

    public String getBodOrigenCodigo() {
        return bodOrigenCodigo;
    }

    public void setBodOrigenCodigo(String bodOrigenCodigo) {
        this.bodOrigenCodigo = bodOrigenCodigo;
    }

    public BigDecimal getCantidadCaja() {
        return cantidadCaja;
    }

    public void setCantidadCaja(BigDecimal cantidadCaja) {
        this.cantidadCaja = cantidadCaja;
    }

    public String getCpDestino() {
        return cpDestino;
    }

    public void setCpDestino(String cpDestino) {
        this.cpDestino = cpDestino;
    }

    public String getCpOrigen() {
        return cpOrigen;
    }

    public void setCpOrigen(String cpOrigen) {
        this.cpOrigen = cpOrigen;
    }

    public BigDecimal getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(BigDecimal detCantidad) {
        this.detCantidad = detCantidad;
    }

    public Integer getDetSecuencial() {
        return detSecuencial;
    }

    public void setDetSecuencial(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public String getEmpaque() {
        return empaque;
    }

    public void setEmpaque(String empaque) {
        this.empaque = empaque;
    }

    public String getMedDetalle() {
        return medDetalle;
    }

    public void setMedDetalle(String medDetalle) {
        this.medDetalle = medDetalle;
    }

    public String getPresentacionCaja() {
        return presentacionCaja;
    }

    public void setPresentacionCaja(String presentacionCaja) {
        this.presentacionCaja = presentacionCaja;
    }

    public String getPresentacionUnidad() {
        return presentacionUnidad;
    }

    public void setPresentacionUnidad(String presentacionUnidad) {
        this.presentacionUnidad = presentacionUnidad;
    }

    public String getProCodigoPrincipal() {
        return proCodigoPrincipal;
    }

    public void setProCodigoPrincipal(String proCodigoPrincipal) {
        this.proCodigoPrincipal = proCodigoPrincipal;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }
}
