/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.reporte;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ReportePagos implements Serializable{
    ////////////CABECEREA
    private String fecha;
    private String proveedor;
    private String id;
    private String nombre;
    private String direccion;
    private String observaciones;
    private String numeroPago;
    
    ////////////DETALLE 1
    private String periodo;
    private String motivo;
    private String numero;
    private String alterno;
    private String documento;
    private String sector;
    private String fechaDetalle;
    private String vence;
    private java.math.BigDecimal total;
    private java.math.BigDecimal valor;
    private java.math.BigDecimal totalDetalleSuperior;
    
    ////////////DETALLE 2
    private String forma;
    private String referencia;
    private java.math.BigDecimal valorDetalleInferior;
    private String observacionesDetalleInferior;
    private java.math.BigDecimal totalDetalleInferior;

    public ReportePagos() {
    }

    public ReportePagos(String fecha, String proveedor, String id, String nombre, String direccion, String observaciones, String numeroPago, String periodo, String motivo, String numero, String alterno, String documento, String sector, String fechaDetalle, String vence, BigDecimal total, BigDecimal valor, BigDecimal totalDetalleSuperior, String forma, String referencia, BigDecimal valorDetalleInferior, String observacionesDetalleInferior, BigDecimal totalDetalleInferior) {
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.observaciones = observaciones;
        this.numeroPago = numeroPago;
        this.periodo = periodo;
        this.motivo = motivo;
        this.numero = numero;
        this.alterno = alterno;
        this.documento = documento;
        this.sector = sector;
        this.fechaDetalle = fechaDetalle;
        this.vence = vence;
        this.total = total;
        this.valor = valor;
        this.totalDetalleSuperior = totalDetalleSuperior;
        this.forma = forma;
        this.referencia = referencia;
        this.valorDetalleInferior = valorDetalleInferior;
        this.observacionesDetalleInferior = observacionesDetalleInferior;
        this.totalDetalleInferior = totalDetalleInferior;
    }

    public String getAlterno() {
        return alterno;
    }

    public void setAlterno(String alterno) {
        this.alterno = alterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaDetalle() {
        return fechaDetalle;
    }

    public void setFechaDetalle(String fechaDetalle) {
        this.fechaDetalle = fechaDetalle;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroPago() {
        return numeroPago;
    }

    public void setNumeroPago(String numeroPago) {
        this.numeroPago = numeroPago;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservacionesDetalleInferior() {
        return observacionesDetalleInferior;
    }

    public void setObservacionesDetalleInferior(String observacionesDetalleInferior) {
        this.observacionesDetalleInferior = observacionesDetalleInferior;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalDetalleInferior() {
        return totalDetalleInferior;
    }

    public void setTotalDetalleInferior(BigDecimal totalDetalleInferior) {
        this.totalDetalleInferior = totalDetalleInferior;
    }

    public BigDecimal getTotalDetalleSuperior() {
        return totalDetalleSuperior;
    }

    public void setTotalDetalleSuperior(BigDecimal totalDetalleSuperior) {
        this.totalDetalleSuperior = totalDetalleSuperior;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorDetalleInferior() {
        return valorDetalleInferior;
    }

    public void setValorDetalleInferior(BigDecimal valorDetalleInferior) {
        this.valorDetalleInferior = valorDetalleInferior;
    }

    public String getVence() {
        return vence;
    }

    public void setVence(String vence) {
        this.vence = vence;
    }
    
    @Override
    public String toString(){
        return this.fecha + " " + this.proveedor + " " + this.id + " " + this.nombre + " " + this.direccion + " " + 
                this.observaciones + " " + this.numeroPago + " " + this.periodo + " " + this.motivo + " " + this.numero + " " + 
                this.alterno + " " + this.documento + " " + this.sector + " " + this.fechaDetalle + " " + 
                this.vence + " " + this.total + " " + this.valor + " " + this.totalDetalleSuperior + " " + 
                this.forma + " " + this.referencia + " " + this.valorDetalleInferior + " " + 
                this.observacionesDetalleInferior + " " + this.totalDetalleInferior;
    }
}
