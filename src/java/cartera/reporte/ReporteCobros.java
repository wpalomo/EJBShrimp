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
public class ReporteCobros implements Serializable {
    ////////////CABECEREA

    private String fecha;
    private String cliente;
    private String id;
    private String nombre;
    private String direccion;
    private String observaciones;
    private String numeroCobro;
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
    ////Detalle Anticipos
    private String antPeriodo;
    private String antTipo;
    private String antNumero;
    private String antFecha;
    private java.math.BigDecimal antValor;
    private java.math.BigDecimal antTotal;
    
    public ReporteCobros() {
    }

    public ReporteCobros(String fecha, String cliente, String id, String nombre, String direccion, String observaciones, String numeroCobro, String periodo, String motivo, String numero, String alterno, String documento, String sector, String fechaDetalle, String vence, BigDecimal total, BigDecimal valor, BigDecimal totalDetalleSuperior, String forma, String referencia, BigDecimal valorDetalleInferior, String observacionesDetalleInferior, BigDecimal totalDetalleInferior) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.observaciones = observaciones;
        this.numeroCobro = numeroCobro;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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

    public String getNumeroCobro() {
        return numeroCobro;
    }

    public void setNumeroCobro(String numeroCobro) {
        this.numeroCobro = numeroCobro;
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

    public String getAntFecha() {
        return antFecha;
    }

    public void setAntFecha(String antFecha) {
        this.antFecha = antFecha;
    }

    public String getAntNumero() {
        return antNumero;
    }

    public void setAntNumero(String antNumero) {
        this.antNumero = antNumero;
    }

    public String getAntPeriodo() {
        return antPeriodo;
    }

    public void setAntPeriodo(String antPeriodo) {
        this.antPeriodo = antPeriodo;
    }

    public String getAntTipo() {
        return antTipo;
    }

    public void setAntTipo(String antTipo) {
        this.antTipo = antTipo;
    }

    public BigDecimal getAntValor() {
        return antValor;
    }

    public void setAntValor(BigDecimal antValor) {
        this.antValor = antValor;
    }

    public BigDecimal getAntTotal() {
        return antTotal;
    }

    public void setAntTotal(BigDecimal antTotal) {
        this.antTotal = antTotal;
    }

    
    
    @Override
    public String toString() {
        return this.fecha + " " + this.cliente + " " + this.id + " " + this.nombre + " " + this.direccion + " "
                + this.observaciones + " " + this.periodo + " " + this.numeroCobro + " " + this.motivo + " " + this.numero + " "
                + this.alterno + " " + this.documento + " " + this.sector + " " + this.fechaDetalle + " "
                + this.vence + " " + this.total + " " + this.valor + " " + this.totalDetalleSuperior + " "
                + this.forma + " " + this.referencia + " " + this.valorDetalleInferior + " "
                + this.observacionesDetalleInferior + " " + this.totalDetalleInferior;
    }
}
