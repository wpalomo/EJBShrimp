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
public class ReporteVentaDetalle implements Serializable{
    
  
    ////////////////////COMPRAS CABECERA
    private String empCodigo;
    private String perCodigo;
    private String motCodigo;
    private String vtaNumero;
    private String vtaNumeroAlterno;
    private String vtaDocumentoTipo;
    private String vtaDocumentoNumero;
    private String vtaFecha;
    private String vtaFechaVencimiento;
    private java.math.BigDecimal vtaIvaVigente;
    private String vtaObservaciones;
    private Boolean vtaPendiente;
    private Boolean vtaRevisado;
    private Boolean vtaAnulado;
    private String vtaFormaPago;
    private java.math.BigDecimal vtaBase0;
    private java.math.BigDecimal vtaBaseimponible;
    private java.math.BigDecimal vtaBaseNoObjeto;
    private java.math.BigDecimal vtaBaseExenta;
    
    //vtaDescuentoGeneralBaseImponible
    private java.math.BigDecimal vtaRecargoBase0;
    private java.math.BigDecimal vtaRecargoImponible;
    
    private java.math.BigDecimal vtaDescuentoGeneralBase0;
    private java.math.BigDecimal vtaDescuentoGeneralBaseImponible;
    private java.math.BigDecimal vtaDescuentoIva;
    
    private java.math.BigDecimal vtaDescuentoBase0;
    private java.math.BigDecimal vtaDescuentoBaseImponible;
    private java.math.BigDecimal vtaDescuentoBaseNoObjeto;
    private java.math.BigDecimal vtaDescuentoBaseExenta;
    
    private java.math.BigDecimal vtaSubtotalBase0;
    private java.math.BigDecimal vtaSubtotalBaseImponible;
    private java.math.BigDecimal vtaSubtotalBaseNoObjeto;
    private java.math.BigDecimal vtaSubtotalBaseExenta;
    
    private java.math.BigDecimal vtaMontoiva;
    private java.math.BigDecimal vtaTotal;
    private java.math.BigDecimal vtaPagado;
    private String cliCodigo;
    private String cliNombre;
    private String cliDireccion;
    private String cliTelefono;
    private String cliRuc;
    private String cliCiudad;
    private String codigoSector;
    private String contPeriodo;
    private String contTipo;
    private String contNumero;
    private String usrInsertaCompra;
    private String usrFechaInsertaCompra;
    

    /////////////////VENTAS DETALLE
    private String bodCodigo;
    private Boolean detPendiente;
    private String proCodigoPrincipal;
    private String proNombre;
    private java.math.BigDecimal detCantidad;
    private String detMedida;
    private java.math.BigDecimal detPrecio;
    private java.math.BigDecimal detParcial;
    private java.math.BigDecimal detPorcentajeRecargo;
    private java.math.BigDecimal detPorcentajeDescuento;
    private java.math.BigDecimal detIvaCobrado;
    private java.math.BigDecimal detTotal;
    private String secCodigo;
    private String pisNumero;
    private Boolean detIva;
    private java.math.BigDecimal detCantidadCaja;
    private String detEmpaque;
    private String detPresentacionUnidad;
    private String detPresentacionCaja;
    //// datos RIDE Electronicos
//    private String docElectonicoNumeroAutorizacion;
//    private String docElectonicoFechaAutorizacion;
//    private String docElectonicoAmbiente;
//    private String docElectonicoEmision;
   private String docElectonicoClaveAcceso;
//    private String docElectonicoObligadoContabilidad;
//    private String docElectonicoNumeroContribuyenteEspecial;
//    private String cliMail;
//    

    public ReporteVentaDetalle(String empCodigo, String perCodigo, String motCodigo, String vtaNumero, String vtaNumeroAlterno, String vtaDocumentoTipo, String vtaDocumentoNumero, String vtaFecha, String vtaFechaVencimiento, BigDecimal vtaIvaVigente, String vtaObservaciones, Boolean vtaPendiente, Boolean vtaRevisado, Boolean vtaAnulado, String vtaFormaPago, BigDecimal vtaBase0, BigDecimal vtaBaseimponible, BigDecimal vtaBaseNoObjeto, BigDecimal vtaBaseExenta, BigDecimal vtaRecargoBase0, BigDecimal vtaRecargoImponible, BigDecimal vtaDescuentoGeneralBase0, BigDecimal vtaDescuentoBase0, BigDecimal vtaDescuentoBaseImponible, BigDecimal vtaDescuentoBaseNoObjeto, BigDecimal vtaDescuentoBaseExenta, BigDecimal vtaSubtotalBase0, BigDecimal vtaSubtotalBaseImponible, BigDecimal vtaSubtotalBaseNoObjeto, BigDecimal vtaSubtotalBaseExenta, BigDecimal vtaMontoiva, BigDecimal vtaTotal, BigDecimal vtaPagado, String cliCodigo, String cliNombre, String cliDireccion, String cliTelefono, String cliRuc, String cliCiudad, String codigoSector, String contPeriodo, String contTipo, String contNumero, String usrInsertaCompra, String usrFechaInsertaCompra, String bodCodigo, Boolean detPendiente, String proCodigoPrincipal, String proNombre, BigDecimal detCantidad, String detMedida, BigDecimal detPrecio, BigDecimal detParcial, BigDecimal detPorcentajeRecargo, BigDecimal detPorcentajeDescuento, BigDecimal detIvaCobrado, BigDecimal detTotal, String secCodigo, String pisNumero, Boolean detIva, BigDecimal detCantidadCaja, String detEmpaque, String detPresentacionUnidad, String detPresentacionCaja, String docElectonicoClaveAcceso) {
        this.empCodigo = empCodigo;
        this.perCodigo = perCodigo;
        this.motCodigo = motCodigo;
        this.vtaNumero = vtaNumero;
        this.vtaNumeroAlterno = vtaNumeroAlterno;
        this.vtaDocumentoTipo = vtaDocumentoTipo;
        this.vtaDocumentoNumero = vtaDocumentoNumero;
        this.vtaFecha = vtaFecha;
        this.vtaFechaVencimiento = vtaFechaVencimiento;
        this.vtaIvaVigente = vtaIvaVigente;
        this.vtaObservaciones = vtaObservaciones;
        this.vtaPendiente = vtaPendiente;
        this.vtaRevisado = vtaRevisado;
        this.vtaAnulado = vtaAnulado;
        this.vtaFormaPago = vtaFormaPago;
        this.vtaBase0 = vtaBase0;
        this.vtaBaseimponible = vtaBaseimponible;
        this.vtaBaseNoObjeto = vtaBaseNoObjeto;
        this.vtaBaseExenta = vtaBaseExenta;
        this.vtaRecargoBase0 = vtaRecargoBase0;
        this.vtaRecargoImponible = vtaRecargoImponible;
        this.vtaDescuentoGeneralBase0 = vtaDescuentoGeneralBase0;
        this.vtaDescuentoBase0 = vtaDescuentoBase0;
        this.vtaDescuentoBaseImponible = vtaDescuentoBaseImponible;
        this.vtaDescuentoBaseNoObjeto = vtaDescuentoBaseNoObjeto;
        this.vtaDescuentoBaseExenta = vtaDescuentoBaseExenta;
        this.vtaSubtotalBase0 = vtaSubtotalBase0;
        this.vtaSubtotalBaseImponible = vtaSubtotalBaseImponible;
        this.vtaSubtotalBaseNoObjeto = vtaSubtotalBaseNoObjeto;
        this.vtaSubtotalBaseExenta = vtaSubtotalBaseExenta;
        this.vtaMontoiva = vtaMontoiva;
        this.vtaTotal = vtaTotal;
        this.vtaPagado = vtaPagado;
        this.cliCodigo = cliCodigo;
        this.cliNombre = cliNombre;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
        this.cliRuc = cliRuc;
        this.cliCiudad = cliCiudad;
        this.codigoSector = codigoSector;
        this.contPeriodo = contPeriodo;
        this.contTipo = contTipo;
        this.contNumero = contNumero;
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
        this.detIvaCobrado = detIvaCobrado;
        this.detTotal = detTotal;
        this.secCodigo = secCodigo;
        this.pisNumero = pisNumero;
        this.detIva = detIva;
        this.detCantidadCaja = detCantidadCaja;
        this.detEmpaque = detEmpaque;
        this.detPresentacionUnidad = detPresentacionUnidad;
        this.detPresentacionCaja = detPresentacionCaja;
        this.docElectonicoClaveAcceso = docElectonicoClaveAcceso;
    }

    public BigDecimal getVtaDescuentoGeneralBaseImponible() {
        return vtaDescuentoGeneralBaseImponible;
    }

    public void setVtaDescuentoGeneralBaseImponible(BigDecimal vtaDescuentoGeneralBaseImponible) {
        this.vtaDescuentoGeneralBaseImponible = vtaDescuentoGeneralBaseImponible;
    }

    public BigDecimal getVtaDescuentoGeneralBase0() {
        return vtaDescuentoGeneralBase0;
    }

    public void setVtaDescuentoGeneralBase0(BigDecimal vtaDescuentoGeneralBase0) {
        this.vtaDescuentoGeneralBase0 = vtaDescuentoGeneralBase0;
    }

    public BigDecimal getVtaDescuentoIva() {
        return vtaDescuentoIva;
    }

    public void setVtaDescuentoIva(BigDecimal vtaDescuentoIva) {
        this.vtaDescuentoIva = vtaDescuentoIva;
    }
    
    public BigDecimal getVtaRecargoBase0() {
        return vtaRecargoBase0;
    }

    public void setVtaRecargoBase0(BigDecimal vtaRecargoBase0) {
        this.vtaRecargoBase0 = vtaRecargoBase0;
    }

    public BigDecimal getVtaRecargoImponible() {
        return vtaRecargoImponible;
    }

    public void setVtaRecargoImponible(BigDecimal vtaRecargoImponible) {
        this.vtaRecargoImponible = vtaRecargoImponible;
    }

    public BigDecimal getVtaBaseExenta() {
        return vtaBaseExenta;
    }

    public void setVtaBaseExenta(BigDecimal vtaBaseExenta) {
        this.vtaBaseExenta = vtaBaseExenta;
    }

    public BigDecimal getVtaBaseimponible() {
        return vtaBaseimponible;
    }

    public void setVtaBaseimponible(BigDecimal vtaBaseimponible) {
        this.vtaBaseimponible = vtaBaseimponible;
    }

    public BigDecimal getVtaBaseNoObjeto() {
        return vtaBaseNoObjeto;
    }

    public void setVtaBaseNoObjeto(BigDecimal vtaBaseNoObjeto) {
        this.vtaBaseNoObjeto = vtaBaseNoObjeto;
    }

    

  

  
  
    public ReporteVentaDetalle() {
    }
    
    public String getDocElectonicoClaveAcceso() {
        return docElectonicoClaveAcceso;
    }

    public void setDocElectonicoClaveAcceso(String docElectonicoClaveAcceso) {
        this.docElectonicoClaveAcceso = docElectonicoClaveAcceso;
    }
  
    public BigDecimal getDetIvaCobrado() {
        return detIvaCobrado;
    }

    public void setDetIvaCobrado(BigDecimal detIvaCobrado) {
        this.detIvaCobrado = detIvaCobrado;
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

    public BigDecimal getVtaPagado() {
        return vtaPagado;
    }

    public void setVtaPagado(BigDecimal vtaPagado) {
        this.vtaPagado = vtaPagado;
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

    public String getDetPresentacionUnidad() {
        return detPresentacionUnidad;
    }

    public void setDetPresentacionUnidad(String detPresentacionUnidad) {
        this.detPresentacionUnidad = detPresentacionUnidad;
    }

    public String getDetPresentacionCaja() {
        return detPresentacionCaja;
    }

    public void setDetPresentacionCaja(String detPresentacionCaja) {
        this.detPresentacionCaja = detPresentacionCaja;
    }   

    public Boolean getDetIva() {
        return detIva;
    }

    public void setDetIva(Boolean detIva) {
        this.detIva = detIva;
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

    public String getMotCodigo() {
        return motCodigo;
    }

    public void setMotCodigo(String motCodigo) {
        this.motCodigo = motCodigo;
    }

    public String getVtaNumero() {
        return vtaNumero;
    }

    public void setVtaNumero(String vtaNumero) {
        this.vtaNumero = vtaNumero;
    }

    public String getVtaNumeroAlterno() {
        return vtaNumeroAlterno;
    }

    public void setVtaNumeroAlterno(String vtaNumeroAlterno) {
        this.vtaNumeroAlterno = vtaNumeroAlterno;
    }

    public String getVtaDocumentoTipo() {
        return vtaDocumentoTipo;
    }

    public void setVtaDocumentoTipo(String vtaDocumentoTipo) {
        this.vtaDocumentoTipo = vtaDocumentoTipo;
    }

    public String getVtaDocumentoNumero() {
        return vtaDocumentoNumero;
    }

    public void setVtaDocumentoNumero(String vtaDocumentoNumero) {
        this.vtaDocumentoNumero = vtaDocumentoNumero;
    }

    public String getVtaFecha() {
        return vtaFecha;
    }

    public void setVtaFecha(String vtaFecha) {
        this.vtaFecha = vtaFecha;
    }

    public String getVtaFechaVencimiento() {
        return vtaFechaVencimiento;
    }

    public void setVtaFechaVencimiento(String vtaFechaVencimiento) {
        this.vtaFechaVencimiento = vtaFechaVencimiento;
    }

    public BigDecimal getVtaIvaVigente() {
        return vtaIvaVigente;
    }

    public void setVtaIvaVigente(BigDecimal vtaIvaVigente) {
        this.vtaIvaVigente = vtaIvaVigente;
    }

    public String getVtaObservaciones() {
        return vtaObservaciones;
    }

    public void setVtaObservaciones(String vtaObservaciones) {
        this.vtaObservaciones = vtaObservaciones;
    }

    public Boolean getVtaPendiente() {
        return vtaPendiente;
    }

    public void setVtaPendiente(Boolean vtaPendiente) {
        this.vtaPendiente = vtaPendiente;
    }

    public Boolean getVtaRevisado() {
        return vtaRevisado;
    }

    public void setVtaRevisado(Boolean vtaRevisado) {
        this.vtaRevisado = vtaRevisado;
    }

    public Boolean getVtaAnulado() {
        return vtaAnulado;
    }

    public void setVtaAnulado(Boolean vtaAnulado) {
        this.vtaAnulado = vtaAnulado;
    }

    public String getVtaFormaPago() {
        return vtaFormaPago;
    }

    public void setVtaFormaPago(String vtaFormaPago) {
        this.vtaFormaPago = vtaFormaPago;
    }

    public BigDecimal getVtaBase0() {
        return vtaBase0;
    }

    public void setVtaBase0(BigDecimal vtaBase0) {
        this.vtaBase0 = vtaBase0;
    }

//    public BigDecimal getVtaBaseimponible() {
//        return vtaBaseimponible;
//    }
//
//    public void setVtaBaseimponible(BigDecimal vtaBaseimponible) {
//        this.vtaBaseimponible = vtaBaseimponible;
//    }

    public BigDecimal getVtaDescuentoBase0() {
        return vtaDescuentoBase0;
    }

    public void setVtaDescuentoBase0(BigDecimal vtaDescuentoBase0) {
        this.vtaDescuentoBase0 = vtaDescuentoBase0;
    }

    public BigDecimal getVtaDescuentoBaseImponible() {
        return vtaDescuentoBaseImponible;
    }

    public void setVtaDescuentoBaseImponible(BigDecimal vtaDescuentoBaseImponible) {
        this.vtaDescuentoBaseImponible = vtaDescuentoBaseImponible;
    }

    public BigDecimal getVtaDescuentoBaseExenta() {
        return vtaDescuentoBaseExenta;
    }

    public void setVtaDescuentoBaseExenta(BigDecimal vtaDescuentoBaseExenta) {
        this.vtaDescuentoBaseExenta = vtaDescuentoBaseExenta;
    }

    public BigDecimal getVtaDescuentoBaseNoObjeto() {
        return vtaDescuentoBaseNoObjeto;
    }

    public void setVtaDescuentoBaseNoObjeto(BigDecimal vtaDescuentoBaseNoObjeto) {
        this.vtaDescuentoBaseNoObjeto = vtaDescuentoBaseNoObjeto;
    }

    public BigDecimal getVtaSubtotalBaseExenta() {
        return vtaSubtotalBaseExenta;
    }

    public void setVtaSubtotalBaseExenta(BigDecimal vtaSubtotalBaseExenta) {
        this.vtaSubtotalBaseExenta = vtaSubtotalBaseExenta;
    }

    public BigDecimal getVtaSubtotalBaseNoObjeto() {
        return vtaSubtotalBaseNoObjeto;
    }

    public void setVtaSubtotalBaseNoObjeto(BigDecimal vtaSubtotalBaseNoObjeto) {
        this.vtaSubtotalBaseNoObjeto = vtaSubtotalBaseNoObjeto;
    }


    public BigDecimal getVtaSubtotalBase0() {
        return vtaSubtotalBase0;
    }

    public void setVtaSubtotalBase0(BigDecimal vtaSubtotalBase0) {
        this.vtaSubtotalBase0 = vtaSubtotalBase0;
    }

    public BigDecimal getVtaSubtotalBaseImponible() {
        return vtaSubtotalBaseImponible;
    }

    public void setVtaSubtotalBaseImponible(BigDecimal vtaSubtotalBaseImponible) {
        this.vtaSubtotalBaseImponible = vtaSubtotalBaseImponible;
    }

    public BigDecimal getVtaMontoiva() {
        return vtaMontoiva;
    }

    public void setVtaMontoiva(BigDecimal vtaMontoiva) {
        this.vtaMontoiva = vtaMontoiva;
    }

    public BigDecimal getVtaTotal() {
        return vtaTotal;
    }

    public void setVtaTotal(BigDecimal vtaTotal) {
        this.vtaTotal = vtaTotal;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliRuc() {
        return cliRuc;
    }

    public void setCliRuc(String cliRuc) {
        this.cliRuc = cliRuc;
    }

    public String getCliCiudad() {
        return cliCiudad;
    }

    public void setCliCiudad(String cliCiudad) {
        this.cliCiudad = cliCiudad;
    }

    public String getCodigoSector() {
        return codigoSector;
    }

    public void setCodigoSector(String codigoSector) {
        this.codigoSector = codigoSector;
    }

    public String getContPeriodo() {
        return contPeriodo;
    }

    public void setContPeriodo(String contPeriodo) {
        this.contPeriodo = contPeriodo;
    }

    public String getContTipo() {
        return contTipo;
    }

    public void setContTipo(String contTipo) {
        this.contTipo = contTipo;
    }

    public String getContNumero() {
        return contNumero;
    }

    public void setContNumero(String contNumero) {
        this.contNumero = contNumero;
    }

    public String getUsrInsertaCompra() {
        return usrInsertaCompra;
    }

    public void setUsrInsertaCompra(String usrInsertaCompra) {
        this.usrInsertaCompra = usrInsertaCompra;
    }

    public String getUsrFechaInsertaCompra() {
        return usrFechaInsertaCompra;
    }

    public void setUsrFechaInsertaCompra(String usrFechaInsertaCompra) {
        this.usrFechaInsertaCompra = usrFechaInsertaCompra;
    }

    public String getBodCodigo() {
        return bodCodigo;
    }

    public void setBodCodigo(String bodCodigo) {
        this.bodCodigo = bodCodigo;
    }

    public Boolean getDetPendiente() {
        return detPendiente;
    }

    public void setDetPendiente(Boolean detPendiente) {
        this.detPendiente = detPendiente;
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

    public BigDecimal getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(BigDecimal detCantidad) {
        this.detCantidad = detCantidad;
    }

    public String getDetMedida() {
        return detMedida;
    }

    public void setDetMedida(String detMedida) {
        this.detMedida = detMedida;
    }

    public BigDecimal getDetPrecio() {
        return detPrecio;
    }

    public void setDetPrecio(BigDecimal detPrecio) {
        this.detPrecio = detPrecio;
    }

    public BigDecimal getDetParcial() {
        return detParcial;
    }

    public void setDetParcial(BigDecimal detParcial) {
        this.detParcial = detParcial;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
    }
    }
