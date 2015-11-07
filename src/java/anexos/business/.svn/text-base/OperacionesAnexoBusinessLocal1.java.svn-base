/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.business;

import anexos.TO.*;
import anexos.sri.ws.autorizacion.RespuestaComprobante;
import anexos.sri.ws.recepcion.RespuestaSolicitud;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisInfoTO;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesAnexoBusinessLocal1 {
    
    List<AnxEstablecimientoComboTO> getEstablecimientos(String empresa) throws Exception;
    
    List<AnxEstablecimientoComboTO> getPuntosEmision(String empresa,String establecimiento) throws Exception;

    anexos.TO.AnxNumeracionLineaTO getNumeroAutorizacion(
            String empresa,
            String numeroRetencion,
            String numeroComprobante,
            String fechaVencimiento) throws Exception;

    java.util.List<anexos.TO.AnxSustentoComboTO> getListaAnxSustentoComboTO(
            String tipoComprobante) throws Exception;

    java.util.List<anexos.TO.AnxTipoComprobanteTablaTO> getListaAnexoTipoComprobanteTO(
            String codigo) throws Exception;

    java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoComboTO() throws Exception;

    java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoComboTO(
            String fechaRetencion) throws Exception;

    java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoTO(
            java.lang.String fechaRetencion,
            java.lang.String busqueda) throws java.lang.Exception;

    String getCodigoAnxTipoTransaccionTO(
            String tipoIdentificacion,
            String tipoTransaccion) throws Exception;

    java.util.List<anexos.TO.AnxTipoComprobanteComboTO> getListaAnxTipoComprobanteComboTO(
            String codigoTipoTransaccion) throws Exception;

    java.util.List<anexos.TO.AnxTipoComprobanteComboTO> getListaAnxTipoComprobanteComboTOCompleto() throws java.lang.Exception;

    java.math.BigDecimal getValorAnxPorcentajeIvaTO(
            String fechaFactura) throws Exception;

    java.math.BigDecimal getValorAnxMontoMaximoConsumidorFinalTO(
            String fechaFactura) throws Exception;

    anexos.TO.AnxCompraTO getAnexoCompraTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception;

    java.util.List<anexos.TO.AnxCompraDetalleTO> getAnexoCompraDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception;

    java.util.List<anexos.TO.AnxCompraReembolsoTO> getAnexoCompraReembolsoTOs(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception;

    anexos.TO.AnxVentaTO getAnexoVentaTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroVenta) throws Exception;

    anexos.entity.AnxCompra getAnexoCompra(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception;

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
            String fechaHasta) throws Exception;

    java.util.List<anexos.TO.AnxListaRetencionesTO> getAnexoFunListadoRetencionesPorNumero(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String parametroEstado) throws Exception;

    java.util.List<anexos.TO.AnxListaComprobanteAnuladoTO> getAnxListaComprobanteAnuladoTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxListaRetencionVentaTO> getAnxListaRetencionVentaTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxListaConsolidadoRetencionesVentasTO> getAnxListaConsolidadoRetencionesVentasTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxListaEstablecimientoRetencionesVentasTO> getAnxListaEstablecimientoRetencionesVentasTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxListadoRetencionesVentasTO> getAnxListadoRetencionesVentasTO(String empresa,String tipoDocumento,String establecimiento,String puntoEmision, String fechaDesde, String fechaHasta) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxTalonResumenTO> getAnexoTalonResumenTO(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception;
    java.util.List<anexos.TO.AnxTalonResumenVentaTO> getAnexoTalonResumenVentaTO(
            String empresa, 
            String fechaDesde, 
            String fechaHasta) throws Exception;

    java.util.List<anexos.TO.AnxNumeracionTablaTO> getListaAnexoNumeracionTO(String empresa) throws Exception;

    anexos.TO.AnxNumeracionTO getAnexoNumeracionTO(Integer secuencia) throws Exception;

    String insertarAnexoNumeracionTO(
            anexos.TO.AnxNumeracionTO anxNumeracionTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String modificarAnexoNumeracionTO(
            anexos.TO.AnxNumeracionTO anxNumeracionTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String eliminarAnexoNumeracionTO(
            anexos.TO.AnxNumeracionTO anxNumeracionTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    anexos.TO.AnxConceptoTO getBuscarAnexoConceptoTO(String conceptoCodigo) throws Exception;

    java.util.List<anexos.TO.AnxConceptoTO> getAnexoConceptoTO() throws java.lang.Exception;

    java.util.List<anexos.TO.AnxSustentoTO> getAnexoSustentoTO() throws java.lang.Exception;

    java.util.List<anexos.TO.AnxTipoComprobanteTO> getAnexoTipoComprobanteTO() throws java.lang.Exception;

    java.util.List<anexos.TO.AnxTipoIdentificacionTO> getListaAnxTipoIdentificacionTO() throws Exception;

    java.util.List<anexos.TO.AnxTipoListaTransaccionTO> getAnexoTipoListaTransaccionTO() throws java.lang.Exception;

    java.util.List<anexos.TO.AnxAnuladoTablaTO> getListaAnxAnuladoTablaTO(
            String empresa) throws Exception;

    anexos.TO.AnxAnuladosTO getAnxAnuladosTO(
            Integer secuencial) throws Exception;

    String insertarAnexoAnuladoTO(AnxAnuladosTO anxAnuladosTO, SisInfoTO sisInfoTO) throws Exception;

    String modificarAnexoAnuladoTO(
            anexos.TO.AnxAnuladosTO anxAnuladosTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    anexos.TO.AnxCuentasContablesTO getAnxCuentasContablesTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.lang.String actualizarAnxCuentasContables(
            anexos.TO.AnxCuentasContablesTO anxCuentasContablesTO,
            java.lang.String empresa,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String eliminarAnxVentas(
            anexos.TO.AnxVentaTO anxVentaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String accionAnxVenta(
            anexos.TO.AnxVentaTO anxVentaTO,
            String numeroFactura,
            String periodoFactura,
            String cliCodigo,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String eliminarAnexoAnuladoTO(
            anexos.TO.AnxAnuladosTO anxAnuladosTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxFunListadoDevolucionIvaTO> getAnxFunListadoDevolucionIvaTOs(
            java.lang.String empCodigo,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception;

    java.lang.String reestructurarRetencion(
            anexos.TO.AnxCompraTO anxCompraTO,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<String> getAnexoFunListadoRetencionesHuerfanas(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception;
    
    java.util.List<String> getAnexoFunListadoComprobantesPendientes(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception;

    anexos.entity.AnxFormaPago getAnexoFormaPago(
            String codigo) throws Exception;

    java.util.List<anexos.TO.AnxFormaPagoTO> getAnexoFormaPagoTO() throws Exception;

    java.util.List<anexos.TO.AnxCompraFormaPagoTO> getAnexoCompraFormaPagoTO(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception;

    java.util.List<anexos.entity.AnxCompraFormaPago> getAnexoCompraFormaPago(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception;

    java.lang.String getUltimaNumeracionComprobante(
            String empresa,
            String comprobante,
            String secuencial) throws Exception;
//     java.util.List<String> getListadoUltimaNumeracionComprobante(String empresa, String comprobante, String secuencial) throws Exception {
//          return anexos.helper.ConversionesAnexos.convertirfunComprobanteObtenerUltimaNumeracion_FunComprobanteObtenerUltimaNumeracionTO(
//                em.createNativeQuery("SELECT ret_retencionnumero FROM anexo.fun_comprobante_obtener_ultima_numeracion "
//                + "('" + empresa + "', '" + comprobante + "', '" + secuencial + "')").getResultList());
//    }

    java.util.List<anexos.TO.AnxPaisTO> getComboAnxPaisTO() throws Exception;

    java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxProvinciaTO() throws java.lang.Exception;

    java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxCantonTO(
            java.lang.String provincia) throws java.lang.Exception;

    java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxDpaProvinciaTO() throws Exception;

    java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxDpaCantonTO(
            java.lang.String codigoProvincia) throws Exception;

    java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxParroquiaTO(
            java.lang.String codigoProvincia,
            java.lang.String codigoCanton) throws Exception;

    java.lang.String getObtenerProvincia(
            String canton) throws Exception;//

    java.util.List<anexos.TO.AnxFunRegistroDatosCrediticiosTO> getFunRegistroDatosCrediticiosTOs(
            java.lang.String codigoEmpresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws Exception;

    java.lang.String getCompAutorizacion(
            java.lang.String empCodigo,
            java.lang.String provCodigo,
            java.lang.String codTipoComprobante,
            java.lang.String numComplemento) throws Exception;

    java.lang.String accionAnxUrlWebServicesTO(
            anexos.TO.anxUrlWebServicesTO anxUrlWebServicesTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    anexos.TO.anxUrlWebServicesTO getAnxUrlWebServicesTO() throws Exception;


    java.lang.String accionAnxVentaElectronica(anexos.TO.AnxVentaElectronicaTO anxVentaElectronicaTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String accionAnxCompraElectronica(anexos.TO.AnxCompraElectronicaTO anxCompraElectronicaTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

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

    java.lang.String getUltimaNumeracionComprobanteElectronicos(String empresa, String comprobante, String estaBlecimiento, String puntoEmision) throws Exception;

    java.util.List<anexos.TO.AnxListaConsultaVentaElectronicaTO> getListaAnxConsultaVentaElectronica(String empresa, String periodo, String motivo, String busqueda) throws Exception;

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

    boolean comprobarAnxVentaElectronicaAutorizacion(
            String empresa,
            String periodo,
            String motivo,
            String numero,
            String estado) throws Exception;

    anexos.TO.AnxUltimaAutorizacionTO getAnxUltimaAutorizacionTO(
            String empresa,
            String proveedor,
            String tipoDocumento,
            String secuencial,
            String fechaFactura) throws Exception;

   JasperPrint generarReporteTalonResumen(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String desde, String hasta, List<AnxTalonResumenTO> listaAnxTalonResumenTO)throws Exception;
   
   JasperPrint generarReporteTalonResumenVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String desde, String hasta, List<AnxTalonResumenVentaTO> listaAnxTalonResumenVentaTO) throws Exception;

   JasperPrint generarReporteListadoRetencionesPorNumero(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<AnxListaRetencionesTO> listaAnxListaRetencionesTO)throws Exception;

   JasperPrint generarReporteListadoRetencionesVentas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta, 
            List<AnxListadoRetencionesVentasTO> anxListadoRetencionesVentasTOs)throws Exception;

   JasperPrint generarReporteListadoDevolucionIva(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String fechaDesde, String fechaHasta, 
            List<AnxFunListadoDevolucionIvaTO> anxFunListadoDevolucionIvaTOs)throws Exception;
   RespuestaComprobante getAutorizadocionComprobantes(
            String claveAcceso,  String tipoAmbiente, sistema.TO.SisInfoTO sisInfoTO) throws Exception;
   
   RespuestaSolicitud getRecepcionComprobantes(
           byte[] eXmlFirmado, 
           String tipoAmbiente,
           sistema.TO.SisInfoTO sisInfoTO) throws Exception;
   anexos.TO.AnxComprobanteElectronicoUtilTO getEnvioComprobanteElectronicosWS(
           byte[] eXmlFirmado, 
           String claveAcceso, 
           String tipoAmbiente, 
           sistema.TO.SisInfoTO sisInfoTO) throws Exception;
}
