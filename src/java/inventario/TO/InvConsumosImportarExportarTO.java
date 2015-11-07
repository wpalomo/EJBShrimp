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
public class InvConsumosImportarExportarTO implements java.io.Serializable{
    private String consEmpresa;
    private String consPeriodo;
    private String consMotivo;
    private String consNumero;
    private String consReferencia;
    private String consFecha;
    private String consObservaciones;
    private Boolean consPendiente;
    private Boolean consRevisado;
    private Boolean consAnulado;
    private String conEmpresa;
    private String conPeriodo;
    private String conTipo;
    private String conNumero;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;
    
    private Integer detSecuencial;
    private Integer detOrden;
    private java.math.BigDecimal detCantidad;
    private java.math.BigDecimal detValorPromedio;
    private java.math.BigDecimal detValorUltimaCompra;
    private java.math.BigDecimal detSaldo;
    private String bodEmpresa;
    private String bodCodigo;
    private String proEmpresa;
    private String proCodigoPrincipal;
    private String secEmpresa;
    private String secCodigo;
    private String pisEmpresa;
    private String pisSector;
    private String pisNumero;

    public InvConsumosImportarExportarTO() {
    }
    
    public InvConsumosImportarExportarTO(String consEmpresa, String consPeriodo, String consMotivo, String consNumero, String consReferencia, String consFecha, String consObservaciones, Boolean consPendiente, Boolean consRevisado, Boolean consAnulado, String conEmpresa, String conPeriodo, String conTipo, String conNumero, String usrEmpresa, String usrCodigo, String usrFechaInserta, Integer detSecuencial, Integer detOrden, BigDecimal detCantidad, BigDecimal detValorPromedio, BigDecimal detValorUltimaCompra, BigDecimal detSaldo, String bodEmpresa, String bodCodigo, String proEmpresa, String proCodigoPrincipal, String secEmpresa, String secCodigo, String pisEmpresa, String pisSector, String pisNumero) {
        this.consEmpresa = consEmpresa;
        this.consPeriodo = consPeriodo;
        this.consMotivo = consMotivo;
        this.consNumero = consNumero;
        this.consReferencia = consReferencia;
        this.consFecha = consFecha;
        this.consObservaciones = consObservaciones;
        this.consPendiente = consPendiente;
        this.consRevisado = consRevisado;
        this.consAnulado = consAnulado;
        this.conEmpresa = conEmpresa;
        this.conPeriodo = conPeriodo;
        this.conTipo = conTipo;
        this.conNumero = conNumero;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
        this.detSecuencial = detSecuencial;
        this.detOrden = detOrden;
        this.detCantidad = detCantidad;
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

    public String getConEmpresa() {
        return conEmpresa;
    }

    public void setConEmpresa(String conEmpresa) {
        this.conEmpresa = conEmpresa;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConPeriodo() {
        return conPeriodo;
    }

    public void setConPeriodo(String conPeriodo) {
        this.conPeriodo = conPeriodo;
    }

    public String getConTipo() {
        return conTipo;
    }

    public void setConTipo(String conTipo) {
        this.conTipo = conTipo;
    }

    public Boolean getConsAnulado() {
        return consAnulado;
    }

    public void setConsAnulado(Boolean consAnulado) {
        this.consAnulado = consAnulado;
    }

    public String getConsEmpresa() {
        return consEmpresa;
    }

    public void setConsEmpresa(String consEmpresa) {
        this.consEmpresa = consEmpresa;
    }

    public String getConsFecha() {
        return consFecha;
    }

    public void setConsFecha(String consFecha) {
        this.consFecha = consFecha;
    }

    public String getConsMotivo() {
        return consMotivo;
    }

    public void setConsMotivo(String consMotivo) {
        this.consMotivo = consMotivo;
    }

    public String getConsNumero() {
        return consNumero;
    }

    public void setConsNumero(String consNumero) {
        this.consNumero = consNumero;
    }

    public String getConsObservaciones() {
        return consObservaciones;
    }

    public void setConsObservaciones(String consObservaciones) {
        this.consObservaciones = consObservaciones;
    }

    public Boolean getConsPendiente() {
        return consPendiente;
    }

    public void setConsPendiente(Boolean consPendiente) {
        this.consPendiente = consPendiente;
    }

    public String getConsPeriodo() {
        return consPeriodo;
    }

    public void setConsPeriodo(String consPeriodo) {
        this.consPeriodo = consPeriodo;
    }

    public String getConsReferencia() {
        return consReferencia;
    }

    public void setConsReferencia(String consReferencia) {
        this.consReferencia = consReferencia;
    }

    public Boolean getConsRevisado() {
        return consRevisado;
    }

    public void setConsRevisado(Boolean consRevisado) {
        this.consRevisado = consRevisado;
    }

    public BigDecimal getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(BigDecimal detCantidad) {
        this.detCantidad = detCantidad;
    }

    public Integer getDetOrden() {
        return detOrden;
    }

    public void setDetOrden(Integer detOrden) {
        this.detOrden = detOrden;
    }

    public BigDecimal getDetSaldo() {
        return detSaldo;
    }

    public void setDetSaldo(BigDecimal detSaldo) {
        this.detSaldo = detSaldo;
    }

    public Integer getDetSecuencial() {
        return detSecuencial;
    }

    public void setDetSecuencial(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
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

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }
        
}
