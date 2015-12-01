/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.reporte;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ReporteProformaDetalle implements Serializable{

    ////////////////////COMPRAS CABECERA
    private String empCodigo;//
    private String perCodigo;//
    private String motCodigo;//
    private String profNumero;//
    private String profFecha;//
    private java.math.BigDecimal profIvaVigente;//
    private String profObservaciones;//
    private Boolean profPendiente;//--
    private java.math.BigDecimal profBase0;//--
    private java.math.BigDecimal profBaseimponible;//--
    private java.math.BigDecimal profDescuentoBase0;
    private java.math.BigDecimal profDescuentoBaseImponible;
    
    private java.math.BigDecimal profRecargoBase0;
    private java.math.BigDecimal profRecargoImponible;
    
//    private java.math.BigDecimal profDescuentoGeneralBase0;
//    private java.math.BigDecimal profDescuentoGeneralBaseImponible;
//    private java.math.BigDecimal profDescuentoIva;
    private java.math.BigDecimal profSubtotalBase0;
    private java.math.BigDecimal profSubtotalBaseImponible;
    private java.math.BigDecimal profMontoiva;//
    private java.math.BigDecimal profTotal;//
    private String cliCodigo;//
    private String cliNombre;//
    private String cliDireccion;//--
    private String cliTelefono;//
    private String cliRuc;//--
    private String cliCiudad; //
    private String usrInsertaCompra;//--
    private String usrFechaInsertaCompra;//
    /////////////////VENTAS DETALLE
    private String bodCodigo;//
    private Boolean detPendiente;//
    private String proCodigoPrincipal;//
    private String proNombre;//--
    private java.math.BigDecimal detCantidad;//
    private String detMedida;//
    private java.math.BigDecimal detPrecio;//
    private java.math.BigDecimal detParcial;//
    private java.math.BigDecimal detPorcentajeRecargo;//--
    private java.math.BigDecimal detPorcentajeDescuento;//
    private java.math.BigDecimal detTotal;//--
    private Boolean detIva;
    private java.math.BigDecimal detCantidadCaja;
    private String detEmpaque;
    private String detPresentacionUnidad;
    private String detPresentacionCaja;
    private String pisNumero;//

    public ReporteProformaDetalle() {
    }

    public ReporteProformaDetalle(String empCodigo, String perCodigo, String motCodigo, String profNumero, String profFecha, BigDecimal profIvaVigente, String profObservaciones, Boolean profPendiente, BigDecimal profBase0, BigDecimal profBaseimponible, BigDecimal profDescuentoBase0, BigDecimal profDescuentoBaseImponible, BigDecimal profRecargoBase0, BigDecimal profRecargoImponible, BigDecimal profSubtotalBase0, BigDecimal profSubtotalBaseImponible, BigDecimal profMontoiva, BigDecimal profTotal, String cliCodigo, String cliNombre, String cliDireccion, String cliTelefono, String cliRuc, String cliCiudad, String usrInsertaCompra, String usrFechaInsertaCompra, String bodCodigo, Boolean detPendiente, String proCodigoPrincipal, String proNombre, BigDecimal detCantidad, String detMedida, BigDecimal detPrecio, BigDecimal detParcial, BigDecimal detPorcentajeRecargo, BigDecimal detPorcentajeDescuento, BigDecimal detTotal, Boolean detIva, BigDecimal detCantidadCaja, String detEmpaque, String detPresentacionUnidad, String detPresentacionCaja, String pisNumero) {
        this.empCodigo = empCodigo;
        this.perCodigo = perCodigo;
        this.motCodigo = motCodigo;
        this.profNumero = profNumero;
        this.profFecha = profFecha;
        this.profIvaVigente = profIvaVigente;
        this.profObservaciones = profObservaciones;
        this.profPendiente = profPendiente;
        this.profBase0 = profBase0;
        this.profBaseimponible = profBaseimponible;
        this.profDescuentoBase0 = profDescuentoBase0;
        this.profDescuentoBaseImponible = profDescuentoBaseImponible;
        this.profRecargoBase0 = profRecargoBase0;
        this.profRecargoImponible = profRecargoImponible;
        this.profSubtotalBase0 = profSubtotalBase0;
        this.profSubtotalBaseImponible = profSubtotalBaseImponible;
        this.profMontoiva = profMontoiva;
        this.profTotal = profTotal;
        this.cliCodigo = cliCodigo;
        this.cliNombre = cliNombre;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
        this.cliRuc = cliRuc;
        this.cliCiudad = cliCiudad;
        this.usrInsertaCompra = usrInsertaCompra;
        this.usrFechaInsertaCompra = usrFechaInsertaCompra;
        this.bodCodigo = bodCodigo;
        this.detPendiente = detPendiente;
        this.proCodigoPrincipal = proCodigoPrincipal;
        this.proNombre = proNombre;
        this.detCantidad = detCantidad;
        this.detMedida = detMedida;
        this.detPrecio = detPrecio;
        this.detParcial = detParcial;
        this.detPorcentajeRecargo = detPorcentajeRecargo;
        this.detPorcentajeDescuento = detPorcentajeDescuento;
        this.detTotal = detTotal;
        this.detIva = detIva;
        this.detCantidadCaja = detCantidadCaja;
        this.detEmpaque = detEmpaque;
        this.detPresentacionUnidad = detPresentacionUnidad;
        this.detPresentacionCaja = detPresentacionCaja;
        this.pisNumero = pisNumero;
    }

    public BigDecimal getDetPorcentajeDescuento() {
        return detPorcentajeDescuento;
    }

    public void setDetPorcentajeDescuento(BigDecimal detPorcentajeDescuento) {
        this.detPorcentajeDescuento = detPorcentajeDescuento;
    }

    public BigDecimal getDetPorcentajeRecargo() {
        return detPorcentajeRecargo;
    }

    public void setDetPorcentajeRecargo(BigDecimal detPorcentajeRecargo) {
        this.detPorcentajeRecargo = detPorcentajeRecargo;
    }

    
    public BigDecimal getDetTotal() {
        return detTotal;
    }

    public void setDetTotal(BigDecimal detTotal) {
        this.detTotal = detTotal;
    }

    public BigDecimal getProfRecargoBase0() {
        return profRecargoBase0;
    }

    public void setProfRecargoBase0(BigDecimal profRecargoBase0) {
        this.profRecargoBase0 = profRecargoBase0;
    }

    public BigDecimal getProfRecargoImponible() {
        return profRecargoImponible;
    }

    public void setProfRecargoImponible(BigDecimal profRecargoImponible) {
        this.profRecargoImponible = profRecargoImponible;
    }


    public String getBodCodigo() {
        return bodCodigo;
    }

    public void setBodCodigo(String bodCodigo) {
        this.bodCodigo = bodCodigo;
    }

    public String getCliCiudad() {
        return cliCiudad;
    }

    public void setCliCiudad(String cliCiudad) {
        this.cliCiudad = cliCiudad;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliRuc() {
        return cliRuc;
    }

    public void setCliRuc(String cliRuc) {
        this.cliRuc = cliRuc;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public BigDecimal getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(BigDecimal detCantidad) {
        this.detCantidad = detCantidad;
    }

    public BigDecimal getDetCantidadCaja() {
        return detCantidadCaja;
    }

    public void setDetCantidadCaja(BigDecimal detCantidadCaja) {
        this.detCantidadCaja = detCantidadCaja;
    }

    

    public String getDetEmpaque() {
        return detEmpaque;
    }

    public void setDetEmpaque(String detEmpaque) {
        this.detEmpaque = detEmpaque;
    }

    public Boolean getDetIva() {
        return detIva;
    }

    public void setDetIva(Boolean detIva) {
        this.detIva = detIva;
    }

    public String getDetMedida() {
        return detMedida;
    }

    public void setDetMedida(String detMedida) {
        this.detMedida = detMedida;
    }

    public BigDecimal getDetParcial() {
        return detParcial;
    }

    public void setDetParcial(BigDecimal detParcial) {
        this.detParcial = detParcial;
    }

    public Boolean getDetPendiente() {
        return detPendiente;
    }

    public void setDetPendiente(Boolean detPendiente) {
        this.detPendiente = detPendiente;
    }

    

    public BigDecimal getDetPrecio() {
        return detPrecio;
    }

    public void setDetPrecio(BigDecimal detPrecio) {
        this.detPrecio = detPrecio;
    }

    public String getDetPresentacionCaja() {
        return detPresentacionCaja;
    }

    public void setDetPresentacionCaja(String detPresentacionCaja) {
        this.detPresentacionCaja = detPresentacionCaja;
    }

    public String getDetPresentacionUnidad() {
        return detPresentacionUnidad;
    }

    public void setDetPresentacionUnidad(String detPresentacionUnidad) {
        this.detPresentacionUnidad = detPresentacionUnidad;
    }


    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getMotCodigo() {
        return motCodigo;
    }

    public void setMotCodigo(String motCodigo) {
        this.motCodigo = motCodigo;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
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

    public BigDecimal getProfBase0() {
        return profBase0;
    }

    public void setProfBase0(BigDecimal profBase0) {
        this.profBase0 = profBase0;
    }

    public BigDecimal getProfBaseimponible() {
        return profBaseimponible;
    }

    public void setProfBaseimponible(BigDecimal profBaseimponible) {
        this.profBaseimponible = profBaseimponible;
    }

    public BigDecimal getProfDescuentoBase0() {
        return profDescuentoBase0;
    }

    public void setProfDescuentoBase0(BigDecimal profDescuentoBase0) {
        this.profDescuentoBase0 = profDescuentoBase0;
    }

    public BigDecimal getProfDescuentoBaseImponible() {
        return profDescuentoBaseImponible;
    }

    public void setProfDescuentoBaseImponible(BigDecimal profDescuentoBaseImponible) {
        this.profDescuentoBaseImponible = profDescuentoBaseImponible;
    }

    public String getProfFecha() {
        return profFecha;
    }

    public void setProfFecha(String profFecha) {
        this.profFecha = profFecha;
    }

    public BigDecimal getProfIvaVigente() {
        return profIvaVigente;
    }

    public void setProfIvaVigente(BigDecimal profIvaVigente) {
        this.profIvaVigente = profIvaVigente;
    }

    public BigDecimal getProfMontoiva() {
        return profMontoiva;
    }

    public void setProfMontoiva(BigDecimal profMontoiva) {
        this.profMontoiva = profMontoiva;
    }

    public String getProfNumero() {
        return profNumero;
    }

    public void setProfNumero(String profNumero) {
        this.profNumero = profNumero;
    }

    public String getProfObservaciones() {
        return profObservaciones;
    }

    public void setProfObservaciones(String profObservaciones) {
        this.profObservaciones = profObservaciones;
    }

    public Boolean getProfPendiente() {
        return profPendiente;
    }

    public void setProfPendiente(Boolean profPendiente) {
        this.profPendiente = profPendiente;
    }

    public BigDecimal getProfSubtotalBase0() {
        return profSubtotalBase0;
    }

    public void setProfSubtotalBase0(BigDecimal profSubtotalBase0) {
        this.profSubtotalBase0 = profSubtotalBase0;
    }

    public BigDecimal getProfSubtotalBaseImponible() {
        return profSubtotalBaseImponible;
    }

    public void setProfSubtotalBaseImponible(BigDecimal profSubtotalBaseImponible) {
        this.profSubtotalBaseImponible = profSubtotalBaseImponible;
    }

    public BigDecimal getProfTotal() {
        return profTotal;
    }

    public void setProfTotal(BigDecimal profTotal) {
        this.profTotal = profTotal;
    }

    public String getUsrFechaInsertaCompra() {
        return usrFechaInsertaCompra;
    }

    public void setUsrFechaInsertaCompra(String usrFechaInsertaCompra) {
        this.usrFechaInsertaCompra = usrFechaInsertaCompra;
    }

    public String getUsrInsertaCompra() {
        return usrInsertaCompra;
    }

    public void setUsrInsertaCompra(String usrInsertaCompra) {
        this.usrInsertaCompra = usrInsertaCompra;
    }
    
    

    

}
