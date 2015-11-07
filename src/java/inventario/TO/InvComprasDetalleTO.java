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
public class InvComprasDetalleTO implements java.io.Serializable{
    private Integer detSecuencia;
    private Integer detOrden;
    private Boolean detPendiente;
    private Boolean detConfirnado;
    private BigDecimal detCantidad;
    private BigDecimal detPrecio;
    private BigDecimal detPorcentajeDescuento;
    private BigDecimal detOtrosImpuestos;
    private BigDecimal detValorPromedio;
    private BigDecimal detValorUltimaCompra;
    private BigDecimal detSaldo;
    private String bodEmpresa;
    private String bodCodigo;
    private String proEmpresa;
    private String proCodigoPrincipal;
    private String secEmpresa;
    private String secCodigo;
    private String pisEmpresa;
    private String pisSector;
    private String pisNumero;
    private String comEmpresa;
    private String comPeriodo;
    private String comMotivo;
    private String comNumero;
    private String proEstadoIva;
    private String proTipo;
    

    public InvComprasDetalleTO() {
    }

    public InvComprasDetalleTO(Integer detSecuencia, Integer detOrden, Boolean detPendiente, Boolean detConfirnado, BigDecimal detCantidad, BigDecimal detPrecio, BigDecimal detPorcentajeDescuento, BigDecimal detOtrosImpuestos, BigDecimal detValorPromedio, BigDecimal detValorUltimaCompra, BigDecimal detSaldo, String bodEmpresa, String bodCodigo, String proEmpresa, String proCodigoPrincipal, String secEmpresa, String secCodigo, String pisEmpresa, String pisSector, String pisNumero, String comEmpresa, String comPeriodo, String comMotivo, String comNumero, String proEstadoIva, String proTipo) {
        this.detSecuencia = detSecuencia;
        this.detOrden = detOrden;
        this.detPendiente = detPendiente;
        this.detConfirnado = detConfirnado;
        this.detCantidad = detCantidad;
        this.detPrecio = detPrecio;
        this.detPorcentajeDescuento = detPorcentajeDescuento;
        this.detOtrosImpuestos = detOtrosImpuestos;
        this.detValorPromedio = detValorPromedio;
        this.detValorUltimaCompra = detValorUltimaCompra;
        this.detSaldo = detSaldo;
        this.bodEmpresa = bodEmpresa;
        this.bodCodigo = bodCodigo;
        this.proEmpresa = proEmpresa;
        this.proCodigoPrincipal = proCodigoPrincipal;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.pisEmpresa = pisEmpresa;
        this.pisSector = pisSector;
        this.pisNumero = pisNumero;
        this.comEmpresa = comEmpresa;
        this.comPeriodo = comPeriodo;
        this.comMotivo = comMotivo;
        this.comNumero = comNumero;
        this.proEstadoIva = proEstadoIva;
        this.proTipo = proTipo;
    }

    public String getProEstadoIva() {
        return proEstadoIva;
    }

    public void setProEstadoIva(String proEstadoIva) {
        this.proEstadoIva = proEstadoIva;
    }

    public String getProTipo() {
        return proTipo;
    }

    public void setProTipo(String proTipo) {
        this.proTipo = proTipo;
    }

    public String getBodCodigo() {
        return bodCodigo;
    }

    public void setBodCodigo(String bodCodigo) {
        this.bodCodigo = bodCodigo;
    }

    public String getBodEmpresa() {
        return bodEmpresa;
    }

    public void setBodEmpresa(String bodEmpresa) {
        this.bodEmpresa = bodEmpresa;
    }

    public String getComEmpresa() {
        return comEmpresa;
    }

    public void setComEmpresa(String comEmpresa) {
        this.comEmpresa = comEmpresa;
    }

    public String getComMotivo() {
        return comMotivo;
    }

    public void setComMotivo(String comMotivo) {
        this.comMotivo = comMotivo;
    }

    public String getComNumero() {
        return comNumero;
    }

    public void setComNumero(String comNumero) {
        this.comNumero = comNumero;
    }

    public String getComPeriodo() {
        return comPeriodo;
    }

    public void setComPeriodo(String comPeriodo) {
        this.comPeriodo = comPeriodo;
    }

    public BigDecimal getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(BigDecimal detCantidad) {
        this.detCantidad = detCantidad;
    }

    public Boolean getDetConfirnado() {
        return detConfirnado;
    }

    public void setDetConfirnado(Boolean detConfirnado) {
        this.detConfirnado = detConfirnado;
    }

    public Integer getDetOrden() {
        return detOrden;
    }

    public void setDetOrden(Integer detOrden) {
        this.detOrden = detOrden;
    }

    public BigDecimal getDetOtrosImpuestos() {
        return detOtrosImpuestos;
    }

    public void setDetOtrosImpuestos(BigDecimal detOtrosImpuestos) {
        this.detOtrosImpuestos = detOtrosImpuestos;
    }

    public Boolean getDetPendiente() {
        return detPendiente;
    }

    public void setDetPendiente(Boolean detPendiente) {
        this.detPendiente = detPendiente;
    }

    public BigDecimal getDetPorcentajeDescuento() {
        return detPorcentajeDescuento;
    }

    public void setDetPorcentajeDescuento(BigDecimal detPorcentajeDescuento) {
        this.detPorcentajeDescuento = detPorcentajeDescuento;
    }

    public BigDecimal getDetPrecio() {
        return detPrecio;
    }

    public void setDetPrecio(BigDecimal detPrecio) {
        this.detPrecio = detPrecio;
    }

    public BigDecimal getDetSaldo() {
        return detSaldo;
    }

    public void setDetSaldo(BigDecimal detSaldo) {
        this.detSaldo = detSaldo;
    }

    public Integer getDetSecuencia() {
        return detSecuencia;
    }

    public void setDetSecuencia(Integer detSecuencia) {
        this.detSecuencia = detSecuencia;
    }

    public BigDecimal getDetValorPromedio() {
        return detValorPromedio;
    }

    public void setDetValorPromedio(BigDecimal detValorPromedio) {
        this.detValorPromedio = detValorPromedio;
    }

    public BigDecimal getDetValorUltimaCompra() {
        return detValorUltimaCompra;
    }

    public void setDetValorUltimaCompra(BigDecimal detValorUltimaCompra) {
        this.detValorUltimaCompra = detValorUltimaCompra;
    }

    public String getPisEmpresa() {
        return pisEmpresa;
    }

    public void setPisEmpresa(String pisEmpresa) {
        this.pisEmpresa = pisEmpresa;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
    }

    public String getPisSector() {
        return pisSector;
    }

    public void setPisSector(String pisSector) {
        this.pisSector = pisSector;
    }

    public String getProCodigoPrincipal() {
        return proCodigoPrincipal;
    }

    public void setProCodigoPrincipal(String proCodigoPrincipal) {
        this.proCodigoPrincipal = proCodigoPrincipal;
    }

    public String getProEmpresa() {
        return proEmpresa;
    }

    public void setProEmpresa(String proEmpresa) {
        this.proEmpresa = proEmpresa;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getSecEmpresa() {
        return secEmpresa;
    }

    public void setSecEmpresa(String secEmpresa) {
        this.secEmpresa = secEmpresa;
    }
}
