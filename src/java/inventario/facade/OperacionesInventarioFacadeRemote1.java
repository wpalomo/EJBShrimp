/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.facade;

import inventario.TO.*;
import inventario.reporte.ReporteCompraDetalle;
import inventario.reporte.ReporteConsumoDetalle;
import inventario.reporte.ReporteTransferenciaDetalle;
import inventario.reporte.ReporteVentaDetalle;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */
@Remote
public interface OperacionesInventarioFacadeRemote1 {

    java.lang.String accionInvProveedorCategoria(
            inventario.TO.InvProveedorCategoriaTO invProveedorCategoriaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvProveedorCategoriaTO> getInvProveedorCategoriaTO(
            String empresa) throws Exception;

    java.lang.String accionInvClienteCategoria(
            inventario.TO.InvClienteCategoriaTO invClienteCategoriaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

       java.util.List<inventario.TO.InvClienteCategoriaTO> getInvClienteCategoriaTO(
            String empresa) throws Exception;

    java.lang.String accionInvProductoCategoria(
            inventario.TO.InvProductoCategoriaTO invProductoCategoriaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvProductoCategoriaTO> getInvProductoCategoriaTO(
            String empresa) throws Exception;

    java.lang.String accionInvProductoMedida(
            inventario.TO.InvProductoMedidaTO invProductoMedidaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvProductoMedidaTO> getInvProductoMedidaTO(
            String empresa) throws Exception;

    inventario.TO.InvProductoDAOTO buscarInvProductoDAOTO(
            java.lang.String empresa,
            java.lang.String codigoProducto) throws java.lang.Exception;

    java.util.List<inventario.TO.InvListaProductosTO> getListaProductosTO(
            String empresa,
            String busqueda,
            String bodega,
            String fecha,
            boolean incluirInactivos,
            boolean limite) throws Exception;

    java.util.List<inventario.TO.InvListaClienteTO> getListaClienteTO(
            String empresa,
            String busqueda,
            boolean activo_Cliente) throws Exception;

    java.util.List<inventario.TO.InvListaProveedoresTO> getListaProveedoresTO(
            String empresa,
            String busqueda,
            boolean activoProveedor) throws Exception;

    java.util.List<inventario.TO.InvListaBodegasTO> getListaBodegasTO(
            String empresa,
            boolean inactivo) throws Exception;

    java.util.List<inventario.TO.InvComboBodegaTO> getInvComboBodegaTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.util.List<inventario.TO.InvCategoriaComboProductoTO> getListaCategoriaComboTO(
            String empresa) throws Exception;

    java.util.List<inventario.TO.InvProductoPresentacionUnidadesComboListadoTO> getListaPresentacionUnidadComboTO(
            String empresa) throws Exception;

    java.lang.String accionInvProductoPresentacionUnidadesTO(
            inventario.TO.InvProductoPresentacionUnidadesTO invProductoPresentacionUnidadesTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvProductoMarcaComboListadoTO> getInvMarcaComboListadoTO(
            String empresa) throws Exception;

    java.lang.String accionInvProductoMarcaTO(
            inventario.TO.InvProductoMarcaTO invProductoMarcaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String accionInvVendedorTO(
            inventario.TO.InvVendedorTO invVendedorTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvProductoPresentacionCajasComboListadoTO> getListaPresentacionCajaComboTO(
            String empresa) throws Exception;

    java.lang.String accionInvProductoPresentacionCajasTO(
            inventario.TO.InvProductoPresentacionCajasTO invProductoPresentacionCajasTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvCategoriaProveedorComboTO> getListaCategoriaProveedorComboTO(
            String empresa) throws Exception;

    java.util.List<inventario.TO.InvCategoriaClienteComboTO> getListaCategoriaClienteComboTO(
            String empresa) throws Exception;

    java.util.List<inventario.TO.InvCompraMotivoComboTO> getListaCompraMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception;

    java.util.List<inventario.TO.InvVentaMotivoComboTO> getListaVentaMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception;

    java.util.List<inventario.TO.InvProformaMotivoComboTO> getListaProformaMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception;

    java.util.List<inventario.TO.InvBodegaTO> getBodegaTO(
            String empresa,
            String codigo) throws Exception;

    java.util.List<inventario.TO.InvProductoTO> getProductoTO(
            String empresa,
            String codigo) throws Exception;

    java.util.List<inventario.TO.InvClienteTO> getClienteTO(
            String empresa,
            String codigo) throws Exception;

    java.util.List<inventario.TO.InvProveedorTO> getProveedorTO(
            String empresa,
            String codigo) throws Exception;

    inventario.TO.InvProveedorTO getBuscaCedulaProveedorTO(
            String empresa,
            String cedRuc) throws Exception;

    boolean comprobarInvAplicaRetencionIva(
            String empresa,
            String codigo) throws Exception;

    inventario.TO.InvCompraCabeceraTO getInvCompraCabeceraTO(
            String empresa,
            String codigoPeriodo,
            String motivo,
            String numeroCompra) throws Exception;

    inventario.TO.InvVentaCabeceraTO getInvVentaCabeceraTO(
            String empresa,
            String codigoPeriodo,
            String motivo,
            String numeroVenta) throws Exception;

    inventario.TO.InvProformaCabeceraTO getInvProformaCabeceraTO(
            String empresa,
            String codigoPeriodo,
            String motivo,
            String numeroProforma) throws Exception;

    inventario.TO.InvConsumosTO getInvConsumoCabeceraTO(
            String empresa,
            String codigoPeriodo,
            String motivo,
            String numeroConsumo) throws Exception;

    java.util.List<inventario.TO.InvListaDetalleComprasTO> getListaInvCompraDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception;

    java.util.List<inventario.TO.InvListaDetalleVentasTO> getListaInvVentasDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroVentas) throws Exception;

    java.util.List<inventario.TO.InvListaDetalleProformasTO> getListaInvProformasDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroProformas) throws Exception;

    java.util.List<inventario.TO.InvListaDetalleConsumoTO> getListaInvConsumoDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroConsumos) throws Exception;

    String insertarProductoTO(
            inventario.TO.InvProductoTO invProductoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

     boolean productoRepetidoCodigoBarra(String empresa, String barras) throws Exception;

    String modificarProductoTO(
            inventario.TO.InvProductoTO invProductoTO,
            String codigoCambiarLlave,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String eliminarInvProductoTO(
            inventario.TO.InvProductoTO invProductoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String insertarClienteTO(
            inventario.TO.InvClienteTO invClienteTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String eliminarInvClienteTO(
            inventario.TO.InvClienteTO invClienteTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean getClienteRepetido(
            String empresa,
            String codigo,
            String id,
            String nombre,
            String razonSocial) throws Exception;

    String modificarClienteTO(
            inventario.TO.InvClienteTO invClienteTO,
            String codigoAnterio,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String insertarProveedorTO(
            inventario.TO.InvProveedorTO invProveedorT,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String modificarProveedorTO(
            inventario.TO.InvProveedorTO invProveedorTO,
            String codigoAnterior,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String insertarBodegaTO(
            inventario.TO.InvBodegaTO invBodegaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String modificarBodegaTO(
            inventario.TO.InvBodegaTO invBodegaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    inventario.TO.MensajeTO insertarInvComprasTO(
            inventario.TO.InvComprasTO invComprasTO,
            java.util.List<inventario.TO.InvComprasDetalleTO> listaInvComprasDetalleTO,
            anexos.TO.AnxCompraTO anxCompraTO,
            java.util.List<anexos.TO.AnxCompraDetalleTO> anxCompraDetalleTO,
            java.util.List<anexos.TO.AnxCompraReembolsoTO> anxCompraReembolsoTO,
            java.util.List<anexos.TO.AnxCompraFormaPagoTO> anxCompraFormaPagoTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    inventario.TO.MensajeTO insertarInvVentasTO(
            inventario.TO.InvVentasTO invVentasTO,
            java.util.List<inventario.TO.InvVentasDetalleTO> listaInvVentasDetalleTO,
            anexos.TO.AnxVentaTO anxVentasTO,
            String tipoDocumentoComplemento,
            String numeroDocumentoComplemento,
            String estadoVentaElectronica,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String getConteoNumeroFacturaVenta(
            String empresaCodigo,
            String compDocumentoTipo,
            String compDocumentoNumero) throws Exception;

    inventario.TO.MensajeTO insertarInvProformasTO(
            inventario.TO.InvProformasTO invProformasTO,
            java.util.List<inventario.TO.InvProformasDetalleTO> listaInvProformasDetalleTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    inventario.TO.MensajeTO insertarInvContableComprasTO(
            String empresa,
            String periodo,
            String motivo,
            String compraNumero,
            String codigoUsuario,
            boolean recontabilizar,
            String conNumero,
            boolean recontabilizarSinPendiente,
            String tipCodigo,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String insertarInvContableVentasTO(
            String empresa,
            String periodo,
            String motivo,
            String ventaNumero,
            String codigoUsuario,
            boolean recontabilizar,
            String conNumero,
            String tipCodigo,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    inventario.TO.MensajeTO modificarInvComprasTO(
            inventario.TO.InvComprasTO invComprasTO,
            java.util.List<inventario.TO.InvComprasDetalleTO> listaInvComprasDetalleTO,
            java.util.List<inventario.TO.InvComprasDetalleTO> listaInvComprasEliminarDetalleTO,
            anexos.TO.AnxCompraTO anxCompraTO,
            java.util.List<anexos.TO.AnxCompraDetalleTO> anxCompraDetalleTO,
            java.util.List<anexos.TO.AnxCompraDetalleTO> anxCompraDetalleEliminarTO,
            java.util.List<anexos.TO.AnxCompraReembolsoTO> anxCompraReembolsoTO,
            java.util.List<anexos.TO.AnxCompraReembolsoTO> anxCompraReembolsoEliminarTO,
            java.util.List<anexos.TO.AnxCompraFormaPagoTO> anxCompraFormaPagoTO,
            java.util.List<anexos.TO.AnxCompraFormaPagoTO> anxCompraFormaPagoEliminarTO,
            boolean desmayorizar,
            boolean quitarAnulado,
            inventario.entity.InvComprasMotivoAnulacion invComprasMotivoAnulacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    inventario.TO.MensajeTO modificarInvVentasTO(
            inventario.TO.InvVentasTO invVentasTO,
            java.util.List<inventario.TO.InvVentasDetalleTO> listaInvVentasDetalleTO,
            java.util.List<inventario.TO.InvVentasDetalleTO> listaInvVentasEliminarDetalleTO,
            boolean desmayorizar,
            anexos.TO.AnxVentaTO anxVentasTO,
            boolean quitarAnulado,
            String tipoDocumentoComplemento,
            String numeroDocumentoComplemento,
            inventario.entity.InvVentasMotivoAnulacion invVentasMotivoAnulacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    inventario.TO.MensajeTO modificarInvProformasTO(
            inventario.TO.InvProformasTO invProfromasTO,
            java.util.List<inventario.TO.InvProformasDetalleTO> listaInvProformasDetalleTO,
            java.util.List<inventario.TO.InvProformasDetalleTO> listaInvProformasEliminarDetalleTO,
            boolean quitarAnulado,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    inventario.TO.MensajeTO modificarInvConsumosTO(
            inventario.TO.InvConsumosTO invConsumosTO,
            java.util.List<inventario.TO.InvConsumosDetalleTO> listaInvConsumosDetalleTO,
            java.util.List<inventario.TO.InvConsumosDetalleTO> listaInvConsumosEliminarDetalleTO,
            boolean desmayorizar,
            inventario.entity.InvConsumosMotivoAnulacion invConsumosMotivoAnulacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String getConteoNumeroFacturaCompra(
            String empresaCodigo,
            String provCodigo,
            String compDocumentoTipo,
            String compDocumentoNumero) throws Exception;

    java.util.List<inventario.TO.InvComboFormaPagoTO> getComboFormaPagoCompra(
            String empresa) throws Exception;

    java.util.List<inventario.TO.InvComboFormaPagoTO> getComboFormaPagoVenta(
            String empresa) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaCompraTO> getFunComprasListado(
            String empresa,
            String fechaDesde,
            String fechaHasta, String status) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaCompraTO> getListaInvConsultaCompra(
            String empresa,
            String periodo,
            String motivo,
            String busqueda,
            String nRegistros) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaVentaTO> getFunVentasListado(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String status) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaVentaTO> getListaInvConsultaVenta(
            String empresa,
            String periodo,
            String motivo,
            String busqueda,
            String nRegistros) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaProformaTO> getListaInvConsultaProforma(
            String empresa,
            String periodo,
            String motivo,
            String busqueda) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaConsumosTO> getFunConsumosListado(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String status) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaConsumosTO> getListaInvConsultaConsumos(
            String empresa,
            String periodo,
            String motivo,
            String busqueda,
            String nRegistros) throws Exception;

    java.util.List<inventario.TO.InvConsumosImportarExportarTO> getListaInvConsumosImportarExportarTO(
            String empresa,
            String desde,
            String hasta) throws Exception;

    java.util.List<inventario.TO.InvConsumosMotivoComboTO> getListaConsumosMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception;

    inventario.TO.MensajeTO insertarInvConsumosTO(
            inventario.TO.InvConsumosTO invConsumosTO,
            java.util.List<inventario.TO.InvConsumosDetalleTO> listaInvConsumosDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<inventario.TO.InvMedidaComboTO> getListaInvMedidaTablaTO(
            String empresa) throws Exception;

    String insertarInvComprasMotivoTO(
            inventario.TO.InvComprasMotivoTO invCompraMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String modificarInvComprasMotivoTO(
            inventario.TO.InvComprasMotivoTO invCompraMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<inventario.TO.InvCompraMotivoTablaTO> getListaInvComprasMotivoTablaTO(
            java.lang.String empresa) throws java.lang.Exception;

    inventario.TO.InvComprasMotivoTO getInvComprasMotivoTO(
            String empresa,
            inventario.TO.InvCompraMotivoTablaTO invComprasMotivoTablaTO) throws java.lang.Exception;

    String insertarInvVentasMotivoTO(
            inventario.TO.InvVentaMotivoTO invVentaMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String modificarInvVentasMotivoTO(
            inventario.TO.InvVentaMotivoTO invVentaMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<inventario.TO.InvVentaMotivoTablaTO> getListaInvVentasMotivoTablaTO(
            java.lang.String empresa) throws java.lang.Exception;

    inventario.TO.InvVentaMotivoTO getInvVentasMotivoTO(
            String empresa,
            inventario.TO.InvVentaMotivoTablaTO invVentasMotivoTablaTO) throws java.lang.Exception;

    String insertarInvProformaMotivoTO(
            inventario.TO.InvProformaMotivoTO invProformaMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String modificarInvProformaMotivoTO(
            inventario.TO.InvProformaMotivoTO invProformaMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<inventario.TO.InvProformaMotivoTablaTO> getListaInvProformaMotivoTablaTO(
            java.lang.String empresa) throws java.lang.Exception;

    inventario.TO.InvProformaMotivoTO getInvProformasMotivoTO(
            String empresa,
            inventario.TO.InvProformaMotivoTablaTO invProformasMotivoTablaTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvListaConsumosMotivoTO> getInvListaConsumosMotivoTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.lang.String accionInvConsumosMotivo(
            inventario.TO.InvConsumosMotivoTO invConsumosMotivoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    inventario.TO.InvConsumosMotivoTO getInvConsumoMotivoTO(
            String empresa,
            inventario.TO.InvListaConsumosMotivoTO invListaConsumosMotivoTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvNumeracionCompraTO> getListaInvNumeracionCompraTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String motivo) throws java.lang.Exception;

    java.util.List<inventario.TO.InvNumeracionVentaTO> getListaInvNumeracionVentaTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String motivo) throws java.lang.Exception;

    java.util.List<inventario.TO.InvNumeracionConsumoTO> getListaInvNumeracionConsumoTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String motivo) throws java.lang.Exception;

    java.util.List<inventario.TO.InvListaComprasFormaPagoTO> getInvListaComprasFormaPagoTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.lang.String accionInvComprasPagosForma(
            inventario.TO.InvComprasFormaPagoTO invComprasFormaPagoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvListaVentasFormaPagoTO> getInvListaVentasFormaPagoTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.lang.String accionInvVentasPagosForma(
            inventario.TO.InvVentasFormaPagoTO invVentasFormaPagoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    inventario.entity.InvProductoSaldos getInvProductoSaldo(
            String empresa,
            String codigoBodega,
            String codigoProducto) throws Exception;

    java.util.List<inventario.TO.InvKardexTO> getListaInvKardexTO(
            java.lang.String empresa,
            java.lang.String bodega,
            java.lang.String producto,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String promedio) throws java.lang.Exception;

    java.util.List<inventario.TO.SaldoBodegaTO> getListaSaldoBodegaTO(
            java.lang.String empresa,
            java.lang.String bodega,
            java.lang.String hasta) throws java.lang.Exception;

    inventario.TO.InvComprasRecepcionTO getInvComprasRecepcionTO(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception;

    String insertarModificarComprasRecepcionTO(
            inventario.TO.InvComprasRecepcionTO invComprasRecepcionTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<inventario.TO.InvProductosConErrorTO> getListadoProductosConError(
            String empresa) throws Exception;

    Boolean getPrecioFijoCategoriaProducto(
            java.lang.String empresa,
            java.lang.String codigoCategoria) throws java.lang.Exception;

    inventario.TO.MensajeTO insertarInvTransferenciaTO(
            inventario.TO.InvTransferenciasTO invTransferenciasTO,
            java.util.List<inventario.TO.InvTransferenciasDetalleTO> listaInvTransferenciasDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<inventario.TO.InvListaTransferenciaMotivoTO> getInvListaTransferenciaMotivoTO(
            java.lang.String empresa) throws java.lang.Exception;

    inventario.TO.InvTransferenciaMotivoTO getInvTransferenciaMotivoTO(
            String empresa,
            inventario.TO.InvListaTransferenciaMotivoTO invListaTransferenciaMotivoTO) throws java.lang.Exception;

    java.lang.String accionInvTransferenciaMotivo(
            inventario.TO.InvTransferenciaMotivoTO invTransferenciaMotivoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvTransferenciaMotivoComboTO> getListaTransferenciaMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception;

    java.util.List<inventario.TO.InvListaDetalleTransferenciaTO> getListaInvTransferenciasDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroTransferencia) throws Exception;

    inventario.TO.InvTransferenciasTO getInvTransferenciasCabeceraTO(
            String empresa,
            String codigoPeriodo,
            String motivo,
            String numeroConsumo) throws Exception;

    inventario.TO.MensajeTO modificarInvTransferenciasTO(
            inventario.TO.InvTransferenciasTO invTransferenciasTO,
            java.util.List<inventario.TO.InvTransferenciasDetalleTO> listaInvTransferenciasDetalleTO,
            java.util.List<inventario.TO.InvTransferenciasDetalleTO> listaInvTransferenciasEliminarDetalleTO,
            boolean desmayorizar,
            inventario.entity.InvTransferenciasMotivoAnulacion invTransferenciasMotivoAnulacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaTransferenciaTO> getFunListadoTransferencias(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String status) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaTransferenciaTO> getListaInvConsultaTransferencias(
            String empresa,
            String periodo,
            String motivo,
            String busqueda, String nRegistros) throws Exception;

    java.util.List<inventario.TO.InvListaProductosCambiarPrecioTO> getListaProductosCambiarPrecioTO(
            String empresa,
            String busqueda,
            String bodega,
            String fecha) throws Exception;

    inventario.TO.MensajeTO invCambiarPrecioProducto(
            String empresa,
            String usuario,
            java.util.List<inventario.TO.InvListaProductosCambiarPrecioTO> invListaProductosCambiarPrecioTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    inventario.TO.MensajeTO invCambiarPrecioCantidadProducto(
            String empresa,
            String usuario,
            java.util.List<inventario.TO.InvListaProductosCambiarPrecioCantidadTO> invListaProductosCambiarPrecioCantidadTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    inventario.TO.InvEstadoCCCVT getEstadoCCCVT(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String motivo,
            java.lang.String numero,
            java.lang.String proceso) throws java.lang.Exception;

    java.util.List<inventario.TO.InvSincronizarTO> invProductoSincronizar(
            java.lang.String empresaOrigen,
            java.lang.String empresaDestino,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<inventario.TO.InvListadoPagosTO> invListadoPagosTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String motivo,
            java.lang.String numero) throws java.lang.Exception;

    java.util.List<inventario.TO.InvListadoCobrosTO> invListadoCobrosTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String motivo,
            java.lang.String numero) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunComprasTO> getInvFunComprasTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String motivo,
            java.lang.String proveedor,
            java.lang.String documento) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunVentasTO> getInvFunVentasTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String motivo,
            java.lang.String cliente,
            java.lang.String documento) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunComprasConsolidandoProductosTO> getInvFunComprasConsolidandoProductosTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String sector,
            java.lang.String motivo,
            java.lang.String proveedor) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunVentasConsolidandoProductosTO> getInvFunVentasConsolidandoProductosTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String sector,
            java.lang.String motivo,
            java.lang.String cliente) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunVentasVsCostoTO> getInvFunVentasVsCostoTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String bodega,
            java.lang.String cliente) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunListadoProductosTO> getInvFunListadoProductosTO(
            java.lang.String empresa,
            java.lang.String categoria,
            java.lang.String busqueda) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunListadoClientesTO> getInvFunListadoClientesTO(
            java.lang.String empresa,
            java.lang.String categoria) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunListadoProveedoresTO> getInvFunListadoProveedoresTO(
            java.lang.String empresa,
            java.lang.String categoria) throws java.lang.Exception;

    Boolean getPuedeEliminarProducto(
            String empresa,
            String producto) throws Exception;

    java.math.BigDecimal getPrecioProductoPorCantidad(
            java.lang.String empresa,
            java.lang.String codProducto,
            java.math.BigDecimal cantidad) throws java.lang.Exception;

    java.math.BigDecimal getCantidad3(
            String empresa,
            String codProducto) throws Exception;

    java.util.List<inventario.TO.InvSecuenciaComprobanteTO> getInvSecuenciaComprobanteTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<inventario.TO.InvListaProductosCambiarPrecioCantidadTO> getListaProductosCambiarPrecioCantidadTO(
            java.lang.String empresa, java.lang.String busqueda,
            java.lang.String bodega,
            java.lang.String fecha) throws java.lang.Exception;

    java.util.List<inventario.TO.InvProductoTipoComboTO> getInvProductoTipoComboListadoTO(
            java.lang.String empresa,
            String accion) throws java.lang.Exception;

    java.lang.String accionInvProductoTipo(
            inventario.TO.InvProductoTipoTO invProductoTipoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    Boolean buscarConteoCliente(
            String empCodigo,
            String codigoCliente) throws Exception;

    Boolean buscarConteoProveedor(
            String empCodigo,
            String codigoProveedor) throws Exception;

    java.util.List<inventario.TO.SaldoBodegaComprobacionTO> getInvFunSaldoBodegaComprobacionTO(
            java.lang.String empresa,
            java.lang.String bodega,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception;

    java.util.List<inventario.TO.SaldoBodegaComprobacionTO> getInvFunSaldoBodegaComprobacionCantidadesTO(
            java.lang.String empresa,
            java.lang.String bodega,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunConsumosTO> getInvFunConsumosTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String motivo) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunConsumosConsolidandoProductosTO> getInvFunConsumosConsolidandoProductosTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String sector,
            java.lang.String bodega) throws java.lang.Exception;

    Boolean reconstruirCostos(
            String empCodigo,
            String Producto,
            String periodoHasta,
            Boolean periodoEstado) throws Exception;

    java.util.List<inventario.TO.InvVendedorComboListadoTO> getComboinvListaVendedorTOs(
            String codigoEmpresa) throws Exception;

    java.util.List<inventario.TO.InvFunListaProductosImpresionPlacasTO> getInvFunListaProductosImpresionPlacasTO(
            String empresa,
            String producto,
            boolean estado) throws Exception;

    helper.RetornoTO getInvFunListaProductosSaldosGeneralTO(
            String empresa,
            String producto,
            String fecha,
            boolean estado,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<inventario.TO.InvFunUltimasComprasTO> getInvFunUltimasComprasTOs(
            java.lang.String empresa,
            java.lang.String producto) throws Exception;

    inventario.TO.InvVentaRetencionesTO getInvVentaRetencionesTO(
            String codigoEmpresa,
            String facturaNumero) throws Exception;

    inventario.TO.InvComprasTO getComprasTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception;

    java.util.List<inventario.TO.InvListaProductosCompraSustentoConceptoTO> getInvProductoSustentoConcepto(
            String empresa,
            java.util.List<inventario.TO.InvListaProductosCompraSustentoConceptoTO> invListaProductosCompraTOs) throws Exception;

    JasperPrint generarReporteInvKardex(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String nombreProducto, String fechaDesde,
            String fechaHasta, List<InvKardexTO> listInvKardexTO, boolean banderaCosto) throws Exception;

     JasperPrint generarReporteImpresionPlaca(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, LinkedList listProductosImpresionPlaca) throws Exception;

     JasperPrint generarReporteListadoCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String motivo, String proveedorId, String documento,
            List<InvFunComprasTO> listInvFunComprasTO) throws Exception;

     JasperPrint generarReporteConsolidadoCompraProducto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String bodega, String proveedor, List<InvFunComprasConsolidandoProductosTO> listInvFunComprasConsolidandoProductosTO) throws Exception;

     JasperPrint generarReporteListadoVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String motivo, String cliente, String documento,
            List<InvFunVentasTO> listInvFunVentasTO) throws Exception;

     JasperPrint generarReporteConsolidadoVentaProducto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String bodega, String cliente, List<InvFunVentasConsolidandoProductosTO> listInvFunVentasConsolidandoProductosTO) throws Exception;

     JasperPrint generarReporteListadoConsumos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta, List<InvFunConsumosTO> listInvFunConsumosTO) throws Exception;

     JasperPrint generarReporteListaProductos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega,
            List<InvListaProductosTO> listInvListaProductosTO) throws Exception;

     JasperPrint generarReporteSaldoBodega(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega, String fechaHasta,
            List<SaldoBodegaTO> listSaldoBodegaTO) throws Exception;
    
     JasperPrint generarReporteSaldoBodegaComprobacion(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega, 
            String fechaDesde, String fechaHasta, 
            List<SaldoBodegaComprobacionTO> lista) throws Exception;

     JasperPrint generarReporteInvProductosConError(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<InvProductosConErrorTO> listInvProductosConErrorTO) throws Exception;

     JasperPrint generarReporteTrasferencias(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteTransferenciaDetalle> listReporteTransferenciaDetalle) throws Exception;

     JasperPrint generarReporteConsumoDetalle(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            boolean ordenado,
            List<ReporteConsumoDetalle> reporteConsumoDetalles)throws Exception;

     JasperPrint generarReporteCompraDetalle(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<ReporteCompraDetalle> reporteCompraDetalles)throws Exception;

     JasperPrint generarReporteVentaDetalleImpresion(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteVentaDetalle> lista, 
            String nombreCliente, String nombreReporte)throws Exception;

     JasperPrint generarReporteInvFunVentasVsCosto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String fechaDesde, String fechaHasta, String bodega, String clienteId, 
            List<InvFunVentasVsCostoTO> invFunVentasVsCostoTO)throws Exception;

     JasperPrint generarReporteCompraDetalleImprimir(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<ReporteCompraDetalle> reporteCompraDetalles, String cmFormaImprimir)throws Exception;

    public Object[] getCompra(java.lang.String empresa, 
            java.lang.String perCodigo, java.lang.String motCodigo, 
            java.lang.String compNumero) throws java.lang.Exception;

    public Object[] getVenta(String empresa, String perCodigo, String motCodigo, String compNumero) throws java.lang.Exception;
    


    

}
