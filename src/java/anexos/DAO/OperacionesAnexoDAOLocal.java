/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.DAO;

import anexos.TO.AnxEstablecimientoComboTO;
import inventario.TO.InvConsultaVentasFacturasPorNumeroTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesAnexoDAOLocal {
    
    List<AnxEstablecimientoComboTO> getEstablecimientos(String empresa) throws Exception;
    
    List<AnxEstablecimientoComboTO> getPuntosEmision(String empresa,String establecimiento) throws Exception;

    anexos.TO.AnxNumeracionLineaTO getNumeroAutorizacion(String empresa, String numeroRetencion, String numeroComprobante, String fechaVencimiento) throws Exception;

    String getConteoNumeroRetencion(String empresaCodigo, String numeroRetencion) throws Exception;

    String getConteoNumeroRetencionVenta(String empresaCodigo, String numeroRetencion, String cliente) throws Exception;

    java.util.List<anexos.TO.AnxSustentoComboTO> getListaAnxSustentoComboTO(String tipoComprobante) throws Exception;

    java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoTO() throws Exception;

    java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoTO(String fechaRetencion) throws Exception;

    java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoTO(java.lang.String fechaRetencion, java.lang.String busqueda) throws java.lang.Exception;

    java.lang.String getCodigoAnxTipoTransaccionTO(String codigoTipoIdentificacion, String tipoTransaccion) throws Exception;

    java.util.List<anexos.TO.AnxTipoComprobanteComboTO> getListaAnxTipoComprobanteComboTOCompleto() throws java.lang.Exception;

    java.math.BigDecimal getValorAnxPorcentajeIvaTO(String fechaFactura) throws Exception;

    java.math.BigDecimal getValorAnxMontoMaximoConsumidorFinalTO(String fechaFactura) throws Exception;

    anexos.TO.AnxCompraTO getAnexoCompraTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception;

    java.util.List<anexos.TO.AnxCompraDetalleTO> getAnexoCompraDetalleTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception;

    java.util.List<anexos.entity.AnxCompraDetalle> getAnexoCompraDetalle(String empresa, String periodo, String motivo, String numeroCompra) throws Exception;

    anexos.TO.AnxVentaTO getAnexoVentaTO(String empresa, String periodo, String motivo, String numeroVenta) throws Exception;

    anexos.entity.AnxCompra getAnexoCompra(String empresa, String periodo, String motivo, String numeroCompra) throws Exception;

    boolean comprobarEliminarAnxVentas(String empresa, String ventPeriodo, String ventMotivo, String ventaNumero) throws Exception;

    boolean comprobarAnxVentas(String empresa, String ventPeriodo, String ventMotivo, String ventaNumero) throws Exception;

    anexos.entity.AnxVenta buscarAnxVentas(String empresa, String ventPeriodo, String ventMotivo, String ventaNumero) throws Exception;

    java.util.List<anexos.TO.AnxListaRetencionesTO> getAnexoListaRetencionesTO(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception;

    java.util.List<anexos.TO.AnxListaRetencionesRentaTO> getAnexoListaRetencionesRentaTO(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String pOrden) throws Exception;
    java.util.List<anexos.TO.AnxListaRetencionesFuenteIvaTO> getAnexoListaRetencionesFuenteIvaTO(
            String empresa, 
            String fechaDesde, 
            String fechaHasta) throws Exception ;

    java.util.List<anexos.TO.AnxListaRetencionesTO> getAnexoFunListadoRetencionesPorNumero(String empresa, String fechaDesde, String fechaHasta, String parametroEstado) throws Exception;

    java.util.List<String> getAnexoFunListadoRetencionesHuerfanas(String empresa, String fechaDesde, String fechaHasta) throws Exception;
    
    java.util.List<String> getAnexoFunListadoComprobantesPendientes(String empresa, String fechaDesde, String fechaHasta) throws Exception;
    
    java.util.List<anexos.TO.AnxListaComprobanteAnuladoTO> getAnxListaComprobanteAnuladoTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxListaRetencionVentaTO> getAnxListaRetencionVentaTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxListaConsolidadoRetencionesVentasTO> getAnxListaConsolidadoRetencionesVentasTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxListaEstablecimientoRetencionesVentasTO> getAnxListaEstablecimientoRetencionesVentasTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxListadoRetencionesVentasTO> getAnxListadoRetencionesVentasTO(String empresa, String tipoDocumento, String establecimiento, String puntoEmision, String fechaDesde, String fechaHasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxTalonResumenTO> getAnexoTalonResumenTO(String empresa, String fechaDesde, String fechaHasta) throws Exception;

    java.util.List<anexos.TO.AnxTalonResumenVentaTO> getAnexoTalonResumenVentaTO(String empresa, String fechaDesde, String fechaHasta) throws Exception;
    
    anexos.TO.AnxCuentasContablesTO getCuentasContablesTO(String empresa) throws Exception;

    String getSectorAnexoNumeracion(String empresa, String numeroRetencion) throws Exception;
    //String getSectorAnexoNumeracionElectronica(String empresa, String numeroRetencion) throws Exception;

    java.util.List<anexos.TO.AnxNumeracionTablaTO> getListaAnexoNumeracionTO(String empresa) throws Exception;

    anexos.TO.AnxNumeracionTO getAnexoNumeracionTO(Integer secuencia) throws Exception;
    anexos.entity.AnxNumeracion getAnexoNumeracion(Integer secuencia) throws Exception;
    boolean comprobarAnexoNumeracion(String empresa, String numeroComprobante, String desde, String hasta) throws Exception;
    anexos.entity.AnxConcepto getAnexoConcepto(String codigo) throws Exception;

    anexos.TO.AnxConceptoTO getBuscarAnexoConceptoTO(String conceptoCodigo) throws Exception;

    java.util.List<anexos.TO.AnxConceptoTO> getAnexoConceptoTO() throws java.lang.Exception;

    java.util.List<anexos.TO.AnxSustentoTO> getAnexoSustentoTO() throws java.lang.Exception;

    java.util.List<anexos.TO.AnxTipoComprobanteTO> getAnexoTipoComprobanteTO() throws java.lang.Exception;

    java.util.List<anexos.TO.AnxTipoComprobanteTablaTO> getListaAnexoTipoComprobanteTO(String codigo) throws Exception;

    java.util.List<anexos.TO.AnxTipoIdentificacionTO> getListaAnxTipoIdentificacionTO() throws Exception;

    java.util.List<anexos.TO.AnxTipoComprobanteComboTO> getListaAnxTipoComprobanteComboTO(String codigoTipoTransaccion) throws Exception;

    java.util.List<anexos.TO.AnxTipoListaTransaccionTO> getAnexoTipoListaTransaccionTO() throws java.lang.Exception;

    java.util.List<anexos.TO.AnxAnuladoTablaTO> getListaAnxAnuladoTablaTO(String empresa) throws Exception;

    anexos.TO.AnxAnuladosTO getAnxAnuladosTO(Integer secuencial) throws Exception;

    anexos.entity.AnxTipocomprobante getAnexoTipoComprobante(String tcCodigo) throws Exception;

    boolean comprobarAnxCuentascontables(java.lang.String empresa) throws java.lang.Exception;

    anexos.TO.AnxCuentasContablesTO getAnxCuentasContablesTO(java.lang.String empresa, String nombreCuenta) throws java.lang.Exception;

    anexos.entity.AnxVenta getAnxVenta(java.lang.String empresa, java.lang.String periodo, java.lang.String motivo, java.lang.String numero) throws java.lang.Exception;

    java.lang.Boolean getComprobanteVerificarAutorizacion(java.lang.String empresa, java.lang.String comprobanteTipo, java.lang.String establecimiento, java.lang.String puntoEmision, java.lang.String secuencialInicio, java.lang.String secuencialFin) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxFunListadoDevolucionIvaTO> getAnxFunListadoDevolucionIvaTOs(java.lang.String empCodigo, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxCompraReembolsoTO> getAnexoCompraReembolsoTOs(String empresa, String periodo, String motivo, String numeroCompra) throws Exception;

    java.util.List<anexos.entity.AnxCompraReembolso> getAnexoCompraReembolsos(String empresa, String periodo, String motivo, String numeroCompra) throws Exception;

    anexos.entity.AnxFormaPago getAnexoFormaPago(String codigo) throws Exception;

    anexos.entity.AnxSustento getAnexoSustento(String codigo) throws Exception;
    
    java.util.List<anexos.TO.AnxFormaPagoTO> getAnexoFormaPagoTO() throws Exception;

    java.util.List<anexos.TO.AnxCompraFormaPagoTO> getAnexoCompraFormaPagoTO(String empresa, String periodo, String motivo, String numero) throws Exception;

    java.util.List<anexos.entity.AnxCompraFormaPago> getAnexoCompraFormaPago(String empresa, String periodo, String motivo, String numeroCompra) throws Exception;

    java.lang.String getUltimaNumeracionComprobante(String empresa, String comprobante, String secuencial) throws Exception;

//    java.util.List<String> getListadoUltimaNumeracionComprobante(String empresa, String comprobante, String secuencial) throws Exception;
    //5) Operaciones AnexosDaolocal
    java.util.List<anexos.TO.AnxPaisTO> getComboAnxPaisTO() throws Exception;

    java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxProvinciaTO() throws java.lang.Exception;

    java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxCantonTO(java.lang.String provincia) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxDpaProvinciaTO() throws Exception;

    java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxDpaCantonTO(java.lang.String codigoProvincia) throws Exception;

    java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxParroquiaTO(java.lang.String codigoProvincia, java.lang.String codigoCanton) throws Exception;

    java.lang.String getObtenerProvincia(String canton) throws Exception;

    java.util.List<anexos.TO.AnxFunRegistroDatosCrediticiosTO> getFunRegistroDatosCrediticiosTOs(java.lang.String codigoEmpresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws Exception;

    java.lang.String getCompAutorizacion(java.lang.String empCodigo, java.lang.String provCodigo, java.lang.String codTipoComprobante, java.lang.String numComplemento) throws Exception;

    anexos.TO.anxUrlWebServicesTO getAnxUrlWebServicesTO() throws Exception;

    boolean comprobarAnxDirectorio(String empresa) throws Exception;

    java.util.List<anexos.TO.AnxListaVentaElectronicaTO> getListaAnxVentaElectronicaTO(
            String empresa,
            String estado,
            String fechaDesde,
            String fechaHasta,
            String tipoDocumento) throws Exception;

    byte[] getXmlComprobanteRetencion(
            String empresa,
            String ePeriodo,
            String eMotivo,
            String eNumero) throws Exception;

    java.util.List<anexos.TO.AnxListadoCompraElectronicaTO> getListaAnxComprasElectronicaTO(
            String empresa,
            String estado,
            String fechaDesde,
            String fechaHasta) throws Exception;

    java.util.List<anexos.TO.AnxListaRetencionesPendientesTO> getAnexoListaRetencionesPendienteTO(String empresa) throws Exception;


    public byte[] getXmlComprobanteElectronico(
            String empresa,
            String ePeriodo,
            String eMotivo,
            String eNumero) throws Exception;

    boolean comprobarAnxVentaElectronica(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception;

    String  comprobarAnxVentaElectronicaAutorizacion(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception;

    anexos.entity.AnxVentaElectronica buscarAnxVentaElectronica(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception;

    java.lang.String getUltimaNumeracionComprobanteElectronicos(
            String empresa,
            String comprobante,
            String estaBlecimiento,
            String puntoEmision) throws Exception;

    java.util.List<anexos.TO.AnxListaConsultaVentaElectronicaTO> getListaAnxConsultaVentaElectronica(
            String empresa,
            String periodo,
            String motivo,
            String busqueda) throws Exception;

    anexos.TO.AnxUltimaAutorizacionTO getAnxUltimaAutorizacionTO(
            String empresa,
            String proveedor,
            String tipoDocumento,
            String secuencial,
            String fechaFactura) throws Exception;

    boolean comprobarAnxCompraElectronica(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception;

    boolean comprobarRetencionAutorizadaProcesamiento(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception;

    anexos.entity.AnxCompraElectronica buscarAnxCompraElectronica(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception;

    public InvConsultaVentasFacturasPorNumeroTO getConsultaPKRetencion(String codEmpresa, String numRetencion, String numAutorizacion) throws Exception;
}
