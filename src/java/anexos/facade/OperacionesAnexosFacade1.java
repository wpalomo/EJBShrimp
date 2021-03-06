/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.facade;

import anexos.TO.*;
import anexos.entity.AnxCompraFormaPago;
import anexos.entity.AnxFormaPago;
import anexos.sri.ws.autorizacion.RespuestaComprobante;
import anexos.sri.ws.recepcion.RespuestaSolicitud;
import java.util.List;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisInfoTO;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesAnexosFacade1 implements OperacionesAnexosFacadeRemote1 {

    @javax.ejb.EJB
    anexos.business.OperacionesAnexoBusinessLocal1 operacionesAnexoBusinessLocal;

    @Override
    public List<AnxEstablecimientoComboTO> getEstablecimientos(String empresa) throws Exception {
        return operacionesAnexoBusinessLocal.getEstablecimientos(empresa);
    }

    @Override
    public List<AnxEstablecimientoComboTO> getPuntosEmision(String empresa, String establecimiento) throws Exception {
        return operacionesAnexoBusinessLocal.getPuntosEmision(empresa, establecimiento);
    }

    @Override
    public anexos.TO.AnxNumeracionLineaTO getNumeroAutorizacion(
            String empresa,
            String numeroRetencion,
            String numeroComprobante,
            String fechaVencimiento) throws Exception {
        return operacionesAnexoBusinessLocal.getNumeroAutorizacion(empresa, numeroRetencion, numeroComprobante, fechaVencimiento);
    }

    @Override
    public java.util.List<anexos.TO.AnxSustentoComboTO> getListaAnxSustentoComboTO(
            String tipoComprobante) throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnxSustentoComboTO(tipoComprobante);
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoComboTO() throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnxConceptoComboTO();
    }

    public java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoComboTO(
            String fechaRetencion) throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnxConceptoComboTO(fechaRetencion);
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoTO(
            java.lang.String fechaRetencion,
            java.lang.String busqueda) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.getListaAnxConceptoTO(fechaRetencion, busqueda);
    }

    @Override
    public String getCodigoAnxTipoTransaccionTO(
            String tipoIdentificacion,
            String tipoTransaccion) throws Exception {
        return operacionesAnexoBusinessLocal.getCodigoAnxTipoTransaccionTO(tipoIdentificacion, tipoTransaccion);
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoComprobanteComboTO> getListaAnxTipoComprobanteComboTO(
            String codigoTipoTransaccion) throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnxTipoComprobanteComboTO(codigoTipoTransaccion);
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoComprobanteComboTO> getListaAnxTipoComprobanteComboTOCompleto() throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnxTipoComprobanteComboTOCompleto();
    }

    @Override
    public java.math.BigDecimal getValorAnxPorcentajeIvaTO(
            String fechaFactura) throws Exception {
        return operacionesAnexoBusinessLocal.getValorAnxPorcentajeIvaTO(fechaFactura);
    }

    @Override
    public java.math.BigDecimal getValorAnxMontoMaximoConsumidorFinalTO(
            String fechaFactura) throws Exception {
        return operacionesAnexoBusinessLocal.getValorAnxMontoMaximoConsumidorFinalTO(fechaFactura);
    }

    @Override
    public anexos.TO.AnxCompraTO getAnexoCompraTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoCompraTO(empresa, periodo, motivo, numeroCompra);
    }

    @Override
    public java.util.List<anexos.TO.AnxCompraDetalleTO> getAnexoCompraDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoCompraDetalleTO(empresa, periodo, motivo, numeroCompra);
    }

    @Override
    public java.util.List<anexos.TO.AnxCompraReembolsoTO> getAnexoCompraReembolsoTOs(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoCompraReembolsoTOs(empresa, periodo, motivo, numeroCompra);
    }

    @Override
    public anexos.TO.AnxVentaTO getAnexoVentaTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroVenta) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoVentaTO(empresa, periodo, motivo, numeroVenta);
    }

    @Override
    public anexos.entity.AnxCompra getAnexoCompra(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoCompra(empresa, periodo, motivo, numeroCompra);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesTO> getAnexoListaRetencionesTO(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoListaRetencionesTO(
                empresa,
                fechaDesde,
                fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesRentaTO> getAnexoListaRetencionesRentaTO(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String pOrden) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoListaRetencionesRentaTO(
                empresa,
                fechaDesde,
                fechaHasta,
                pOrden);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesFuenteIvaTO> getAnexoListaRetencionesFuenteIvaTO(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoListaRetencionesFuenteIvaTO(
                empresa,
                fechaDesde,
                fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesTO> getAnexoFunListadoRetencionesPorNumero(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String parametroEstado) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoFunListadoRetencionesPorNumero(empresa, fechaDesde, fechaHasta, parametroEstado);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaComprobanteAnuladoTO> getAnxListaComprobanteAnuladoTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.getAnxListaComprobanteAnuladoTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionVentaTO> getAnxListaRetencionVentaTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.getAnxListaRetencionVentaTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaConsolidadoRetencionesVentasTO> getAnxListaConsolidadoRetencionesVentasTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.getAnxListaConsolidadoRetencionesVentasTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaEstablecimientoRetencionesVentasTO> getAnxListaEstablecimientoRetencionesVentasTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.getAnxListaEstablecimientoRetencionesVentasTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListadoRetencionesVentasTO> getAnxListadoRetencionesVentasTO(String empresa, String tipoDocumento, String establecimiento, String puntoEmision, String fechaDesde, String fechaHasta) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.getAnxListadoRetencionesVentasTO(empresa, tipoDocumento, establecimiento, puntoEmision, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxTalonResumenTO> getAnexoTalonResumenTO(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoTalonResumenTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxTalonResumenVentaTO> getAnexoTalonResumenVentaTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoTalonResumenVentaTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxNumeracionTablaTO> getListaAnexoNumeracionTO(String empresa) throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnexoNumeracionTO(empresa);
    }

    @Override
    public anexos.TO.AnxNumeracionTO getAnexoNumeracionTO(Integer secuencia) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoNumeracionTO(secuencia);
    }

    @Override
    public String insertarAnexoNumeracionTO(
            anexos.TO.AnxNumeracionTO anxNumeracionTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesAnexoBusinessLocal.insertarAnexoNumeracionTO(anxNumeracionTO, sisInfoTO);
    }

    @Override
    public String modificarAnexoNumeracionTO(
            anexos.TO.AnxNumeracionTO anxNumeracionTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesAnexoBusinessLocal.modificarAnexoNumeracionTO(anxNumeracionTO, sisInfoTO);
    }

    @Override
    public String eliminarAnexoNumeracionTO(
            anexos.TO.AnxNumeracionTO anxNumeracionTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesAnexoBusinessLocal.eliminarAnexoNumeracionTO(anxNumeracionTO, sisInfoTO);
    }

    @Override
    public anexos.TO.AnxConceptoTO getBuscarAnexoConceptoTO(String conceptoCodigo) throws Exception {
        return operacionesAnexoBusinessLocal.getBuscarAnexoConceptoTO(conceptoCodigo);
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoTO> getAnexoConceptoTO() throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoConceptoTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxSustentoTO> getAnexoSustentoTO() throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoSustentoTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoComprobanteTO> getAnexoTipoComprobanteTO() throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoTipoComprobanteTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoIdentificacionTO> getListaAnxTipoIdentificacionTO() throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnxTipoIdentificacionTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoListaTransaccionTO> getAnexoTipoListaTransaccionTO() throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoTipoListaTransaccionTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxAnuladoTablaTO> getListaAnxAnuladoTablaTO(
            String empresa) throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnxAnuladoTablaTO(empresa);
    }

    @Override
    public anexos.TO.AnxAnuladosTO getAnxAnuladosTO(
            Integer secuencial) throws Exception {
        return operacionesAnexoBusinessLocal.getAnxAnuladosTO(secuencial);
    }

    @Override
    public String insertarAnexoAnuladoTO(AnxAnuladosTO anxAnuladosTO, SisInfoTO sisInfoTO) throws Exception {
        return operacionesAnexoBusinessLocal.insertarAnexoAnuladoTO(anxAnuladosTO, sisInfoTO);
    }

    @Override
    public String modificarAnexoAnuladoTO(anexos.TO.AnxAnuladosTO anxAnuladosTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesAnexoBusinessLocal.modificarAnexoAnuladoTO(anxAnuladosTO, sisInfoTO);
    }

    @Override
    public java.lang.String eliminarAnexoAnuladoTO(
            anexos.TO.AnxAnuladosTO anxAnuladosTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesAnexoBusinessLocal.eliminarAnexoAnuladoTO(anxAnuladosTO, sisInfoTO);
    }

    @Override
    public anexos.TO.AnxCuentasContablesTO getAnxCuentasContablesTO(
            java.lang.String empresa, String nombreCuenta) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.getAnxCuentasContablesTO(empresa, nombreCuenta);
    }

    @Override
    public java.lang.String actualizarAnxCuentasContables(
            anexos.TO.AnxCuentasContablesTO anxCuentasContablesTO,
            java.lang.String empresa,
            java.lang.String usuario, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.actualizarAnxCuentasContables(anxCuentasContablesTO, empresa, usuario, sisInfoTO);
    }

    @Override
    public String eliminarAnxVentas(
            anexos.TO.AnxVentaTO anxVentaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesAnexoBusinessLocal.eliminarAnxVentas(anxVentaTO, sisInfoTO);
    }

    @Override
    public String accionAnxVenta(
            anexos.TO.AnxVentaTO anxVentaTO,
            String numeroFactura,
            String periodoFactura,
            String cliCodigo,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.accionAnxVenta(anxVentaTO, numeroFactura, periodoFactura, cliCodigo, accion, sisInfoTO);
    }

    @Override
    public java.util.List<anexos.TO.AnxFunListadoDevolucionIvaTO> getAnxFunListadoDevolucionIvaTOs(
            java.lang.String empCodigo,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.getAnxFunListadoDevolucionIvaTOs(empCodigo, desde, hasta);
    }

    @Override
    public java.lang.String reestructurarRetencion(
            anexos.TO.AnxCompraTO anxCompraTO,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesAnexoBusinessLocal.reestructurarRetencion(anxCompraTO, usuario, sisInfoTO);
    }

    public java.util.List<anexos.TO.AnxTipoComprobanteTablaTO> getListaAnexoTipoComprobanteTO(String codigo) throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnexoTipoComprobanteTO(codigo);
    }

    public AnxFormaPago getAnexoFormaPago(
            String codigo) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoFormaPago(codigo);
    }

    public List<AnxFormaPagoTO> getAnexoFormaPagoTO() throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoFormaPagoTO();
    }

    public List<AnxCompraFormaPagoTO> getAnexoCompraFormaPagoTO(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoCompraFormaPagoTO(empresa, periodo, motivo, numero);
    }

    public List<AnxCompraFormaPago> getAnexoCompraFormaPago(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoCompraFormaPago(empresa, periodo, motivo, numeroCompra);
    }

    @Override
    public String getUltimaNumeracionComprobante(
            String empresa,
            String comprobante,
            String secuencial) throws Exception {
        return operacionesAnexoBusinessLocal.getUltimaNumeracionComprobante(empresa, comprobante, secuencial);
    }

    @Override
    public java.util.List<anexos.TO.AnxPaisTO> getComboAnxPaisTO() throws Exception {
        return operacionesAnexoBusinessLocal.getComboAnxPaisTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxProvinciaTO() throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.getComboAnxProvinciaTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxCantonTO(
            java.lang.String provincia) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.getComboAnxCantonTO(provincia);
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxDpaProvinciaTO() throws Exception {
        return operacionesAnexoBusinessLocal.getComboAnxDpaProvinciaTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxDpaCantonTO(
            java.lang.String codigoProvincia) throws Exception {
        return operacionesAnexoBusinessLocal.getComboAnxDpaCantonTO(codigoProvincia);
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxParroquiaTO(
            java.lang.String codigoProvincia,
            java.lang.String codigoCanton) throws Exception {
        return operacionesAnexoBusinessLocal.getComboAnxParroquiaTO(codigoProvincia, codigoCanton);
    }

    @Override
    public String getObtenerProvincia(String canton) throws Exception {
        return operacionesAnexoBusinessLocal.getObtenerProvincia(canton);
    }

    @Override
    public java.util.List<anexos.TO.AnxFunRegistroDatosCrediticiosTO> getFunRegistroDatosCrediticiosTOs(
            java.lang.String codigoEmpresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws Exception {
        return operacionesAnexoBusinessLocal.getFunRegistroDatosCrediticiosTOs(codigoEmpresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<String> getAnexoFunListadoRetencionesHuerfanas(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoFunListadoRetencionesHuerfanas(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<String> getAnexoFunListadoComprobantesPendientes(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoFunListadoComprobantesPendientes(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.lang.String accionAnxUrlWebServicesTO(
            anexos.TO.anxUrlWebServicesTO anxUrlWebServicesTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.accionAnxUrlWebServicesTO(anxUrlWebServicesTO, accion, sisInfoTO);
    }

    @Override
    public anexos.TO.anxUrlWebServicesTO getAnxUrlWebServicesTO() throws Exception {
        return operacionesAnexoBusinessLocal.getAnxUrlWebServicesTO();
    }

    @Override
    public java.lang.String getCompAutorizacion(
            java.lang.String empCodigo,
            java.lang.String provCodigo,
            java.lang.String codTipoComprobante,
            java.lang.String numComplemento) throws Exception {
        return operacionesAnexoBusinessLocal.getCompAutorizacion(empCodigo, provCodigo, codTipoComprobante, numComplemento);
    }

    @Override
    public String accionAnxVentaElectronica(
            anexos.TO.AnxVentaElectronicaTO anxVentaElectronicaTO,
            char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.accionAnxVentaElectronica(anxVentaElectronicaTO, accion, sisInfoTO);
    }

    @Override
    public String accionAnxCompraElectronica(
            anexos.TO.AnxCompraElectronicaTO anxCompraElectronicaTO,
            char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesAnexoBusinessLocal.accionAnxCompraElectronica(anxCompraElectronicaTO, accion, sisInfoTO);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaVentaElectronicaTO> getListaAnxVentaElectronicaTO(
            String empresa,
            String estado,
            String fechaDesde,
            String fechaHasta,
            String tipoDocumento) throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnxVentaElectronicaTO(
                empresa,
                estado,
                fechaDesde,
                fechaHasta,
                tipoDocumento);
    }

    @Override
    public byte[] getXmlComprobanteRetencion(
            String empresa,
            String ePeriodo,
            String eMotivo,
            String eNumero) throws Exception {
        return operacionesAnexoBusinessLocal.getXmlComprobanteRetencion(empresa, ePeriodo, eMotivo, eNumero);
    }

    @Override
    public java.util.List<anexos.TO.AnxListadoCompraElectronicaTO> getListaAnxComprasElectronicaTO(
            String empresa,
            String estado,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnxComprasElectronicaTO(
                empresa,
                estado,
                fechaDesde,
                fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesPendientesTO> getAnexoListaRetencionesPendienteTO(String empresa) throws Exception {
        return operacionesAnexoBusinessLocal.getAnexoListaRetencionesPendienteTO(empresa);
    }

    @Override
    public String getUltimaNumeracionComprobanteElectronicos(String empresa, String comprobante, String estaBlecimiento, String puntoEmision) throws Exception {
        return operacionesAnexoBusinessLocal.getUltimaNumeracionComprobanteElectronicos(empresa, comprobante, estaBlecimiento, puntoEmision);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaConsultaVentaElectronicaTO> getListaAnxConsultaVentaElectronica(String empresa, String periodo, String motivo, String busqueda) throws Exception {
        return operacionesAnexoBusinessLocal.getListaAnxConsultaVentaElectronica(empresa, periodo, motivo, busqueda);
    }

    @Override
    public boolean comprobarAnxVentaElectronica(String empresa, String periodo, String motivo, String numero) throws Exception {
        return operacionesAnexoBusinessLocal.comprobarAnxVentaElectronica(empresa, periodo, motivo, numero);
    }

    @Override
    public boolean comprobarAnxCompraElectronica(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception {
        return operacionesAnexoBusinessLocal.comprobarAnxCompraElectronica(empresa, periodo, motivo, numero);
    }

    @Override
    public boolean comprobarRetencionAutorizadaProcesamiento(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception {
        return operacionesAnexoBusinessLocal.comprobarRetencionAutorizadaProcesamiento(
                empresa,
                periodo,
                motivo,
                numero);
    }

    @Override
    public byte[] getXmlComprobanteElectronico(
            String empresa,
            String ePeriodo,
            String eMotivo,
            String eNumero) throws Exception {
        return operacionesAnexoBusinessLocal.getXmlComprobanteElectronico(
                empresa,
                ePeriodo,
                eMotivo,
                eNumero);
    }

    @Override
    public String comprobarAnxVentaElectronicaAutorizacion(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception {
        return operacionesAnexoBusinessLocal.comprobarAnxVentaElectronicaAutorizacion(
                empresa,
                periodo,
                motivo,
                numero);
    }

    @Override
    public anexos.TO.AnxUltimaAutorizacionTO getAnxUltimaAutorizacionTO(
            String empresa,
            String proveedor,
            String tipoDocumento,
            String secuencial,
            String fechaFactura) throws Exception {
        return operacionesAnexoBusinessLocal.getAnxUltimaAutorizacionTO(
                empresa,
                proveedor,
                tipoDocumento,
                secuencial,
                fechaFactura);
    }

    public JasperPrint generarReporteTalonResumen(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String desde, String hasta, List<AnxTalonResumenTO> listaAnxTalonResumenTO) throws Exception {
        return operacionesAnexoBusinessLocal.generarReporteTalonResumen(
                sisUsuarioEmpresaTO, desde, hasta, listaAnxTalonResumenTO);
    }

    public JasperPrint generarReporteTalonResumenVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String desde, String hasta, List<AnxTalonResumenVentaTO> listaAnxTalonResumenVentaTO) throws Exception {
        return operacionesAnexoBusinessLocal.generarReporteTalonResumenVentas(
                sisUsuarioEmpresaTO, desde, hasta, listaAnxTalonResumenVentaTO);
    }

    public JasperPrint generarReporteListadoRetencionesPorNumero(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<AnxListaRetencionesTO> listaAnxListaRetencionesTO) throws Exception {
        return operacionesAnexoBusinessLocal.generarReporteListadoRetencionesPorNumero(
                sisUsuarioEmpresaTO, listaAnxListaRetencionesTO);
    }

    public JasperPrint generarReporteListadoRetencionesVentas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta,
            List<AnxListadoRetencionesVentasTO> anxListadoRetencionesVentasTOs) throws Exception {
        return operacionesAnexoBusinessLocal.generarReporteListadoRetencionesVentas(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta, anxListadoRetencionesVentasTOs);
    }

    public JasperPrint generarReporteListadoDevolucionIva(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<AnxFunListadoDevolucionIvaTO> anxFunListadoDevolucionIvaTOs) throws Exception {
        return operacionesAnexoBusinessLocal.generarReporteListadoDevolucionIva(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                anxFunListadoDevolucionIvaTOs);
    }

    @Override
    public RespuestaComprobante getAutorizadocionComprobantes(
            String claveAcceso, String tipoAmbiente, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesAnexoBusinessLocal.getAutorizadocionComprobantes(claveAcceso, tipoAmbiente, sisInfoTO);

    }

    @Override
    public RespuestaSolicitud getRecepcionComprobantes(
            byte[] eXmlFirmado, 
            String tipoAmbiente, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesAnexoBusinessLocal.getRecepcionComprobantes(
                eXmlFirmado, 
                tipoAmbiente, 
                sisInfoTO);
    }
    @Override
    public anexos.TO.AnxComprobanteElectronicoUtilTO getEnvioComprobanteElectronicosWS(
            byte[] eXmlFirmado, 
            String claveAcceso, 
            String tipoAmbiente, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception{
        return operacionesAnexoBusinessLocal.getEnvioComprobanteElectronicosWS(
                eXmlFirmado, 
                claveAcceso, 
                tipoAmbiente, 
                sisInfoTO);
    }
}