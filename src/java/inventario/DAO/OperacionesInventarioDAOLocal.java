/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.DAO;

import inventario.TO.InvFunComprasConsolidandoProductosTO;
import inventario.TO.InvFunConsumosTO;
import inventario.TO.InvFunVentasTO;
import javax.ejb.Local;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesInventarioDAOLocal {

    inventario.entity.InvProveedorCategoria buscarInvProveedorCategoria(String empresa, String codigo) throws Exception;
    boolean comprobarInvProveedorCategoria(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarEliminarInvProveedorCategoria(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    java.util.List<inventario.TO.InvProveedorCategoriaTO> getInvProveedorCategoriaTO(java.lang.String empresa) throws java.lang.Exception;
    
    inventario.entity.InvClienteCategoria buscarInvClienteCategoria(String empresa, String codigo) throws Exception;
    boolean comprobarInvClienteCategoria(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarEliminarInvClienteCategoria(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    java.util.List<inventario.TO.InvClienteCategoriaTO> getInvClienteCategoriaTO(String empresa) throws Exception;
    
    inventario.entity.InvProductoCategoria buscarInvProductoCategoria(String empresa, String codigo) throws Exception;
    boolean comprobarInvProductoCategoria(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarEliminarInvProductoCategoria(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    java.util.List<inventario.TO.InvProductoCategoriaTO> getInvProductoCategoriaTO(String empresa) throws Exception;
    
    inventario.entity.InvProductoMedida buscarInvProductoMedida(String empresa, String codigo) throws Exception;
    boolean comprobarInvProductoMedida(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarEliminarInvProductoMedida(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    java.util.List<inventario.TO.InvProductoMedidaTO> getInvProductoMedidaTO(String empresa) throws Exception;
    
    inventario.entity.InvConsumosMotivo buscarInvConsumosMotivo(String empresa, String codigo) throws Exception;
    inventario.entity.InvProductoSaldos buscarProductosSaldosStock(String empresa, String bodega, String producto) throws Exception;
    inventario.entity.InvProductoSaldos buscarProductosSaldos(String empresa, String bodega, String producto) throws Exception;
    inventario.entity.InvProducto buscarInvProducto(String empresa, String codigoProducto) throws Exception;
    inventario.entity.InvProductoMedida buscarProductoMedida(String empresa, String codigo) throws Exception;
    inventario.entity.InvProductoPresentacionUnidades buscarProductoPresentacionUnidades(String empresa, String codigoPresentacion) throws Exception;
    inventario.entity.InvProductoPresentacionCajas buscarProductoPresentacionCajas(String empresa, String codigoPresentacion) throws Exception;
    inventario.entity.InvProductoMarca buscarMarcaProducto(String empresa, String codigoMarca) throws Exception;
    inventario.entity.InvCliente buscarInvCliente(String empresa, String codigoCliente) throws Exception;
    inventario.entity.InvProveedor buscarInvProveedor(String empresa, String codigoProveedor) throws Exception;
    inventario.entity.InvBodega buscarInvBodega(String empresa, String codigoBodega) throws Exception;
    inventario.entity.InvCompras buscarInvCompras(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception;
    inventario.entity.InvVentas buscarInvVentas(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception;
    inventario.entity.InvProformas buscarInvProformas(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception;
    inventario.entity.InvConsumos buscarInvConsumos(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception;
    inventario.entity.InvConsumos buscarConsumos(String empresa, String perCodigo, String motCodigo, String consNumero) throws Exception;
    Boolean comprobarInvComprasMotivo(String empresa, String motCodigo) throws Exception;
    Boolean comprobarInvVentasMotivo(String empresa, String motCodigo) throws Exception;
    Boolean comprobarInvProformasMotivo(String empresa, String motCodigo) throws Exception;
    Boolean comprobarInvConsumosMotivo(String empresa, String motCodigo) throws Exception;
    int buscarConteoUltimaNumeracionCompra(String empCodigo, String perCodigo, String motCodigo) throws Exception;
    int buscarConteoUltimaNumeracionVenta(String empCodigo, String perCodigo, String motCodigo) throws Exception;
    int buscarConteoUltimaNumeracionProforma(String empCodigo, String perCodigo, String motCodigo) throws Exception;
    int buscarConteoUltimaNumeracionConsumo(String empCodigo, String perCodigo, String motCodigo) throws Exception;
    String getConteoNumeroFacturaCompra(String empresaCodigo, String provCodigo, String compDocumentoTipo, String compDocumentoNumero) throws Exception;
    String getConteoNumeroFacturaVenta(String empresaCodigo, String compDocumentoTipo, String compDocumentoNumero) throws Exception;
    String getConteoNotaCreditoVenta(String empresaCodigo, String cliCodigo, String compDocumentoTipo, String compDocumentoNumero) throws Exception;
    String getCuentaSectorFormaPagoCompra(String empresa, String detalleFormaPago) throws Exception;
    String getCuentaSectorFormaPagoVenta(String empresa, String detalleFormaPago) throws Exception;
    inventario.entity.InvComprasFormaPago buscarComprasFormaPago(java.lang.Integer secuencial) throws java.lang.Exception;
    inventario.entity.InvVentasFormaPago buscarVentasFormaPago(java.lang.Integer secuencial) throws java.lang.Exception;


    java.util.List<inventario.TO.InvListaProductosTO> getListaProductosTO(String empresa, String busqueda, String bodega, String fecha, boolean incluirInactivos, boolean limite) throws Exception;
    java.util.List<inventario.TO.InvListaClienteTO> getListaClienteTO(String empresa, String busqueda, boolean incluirClienteInactivo) throws Exception;
    java.util.List<inventario.TO.InvListaProveedoresTO> getListaProveedoresTO(String empresa, String busqueda, boolean incluirProveedorInactivo) throws Exception;
    java.util.List<inventario.TO.InvListaBodegasTO> getListaBodegasTO(String empresa, boolean inacivo) throws Exception;
    java.util.List<inventario.TO.InvComboBodegaTO> getInvComboBodegaTO(java.lang.String empresa) throws java.lang.Exception;


    java.util.List<inventario.TO.InvCategoriaComboProductoTO> getListaCategoriaComboTO(String empresa) throws Exception;
    java.util.List<inventario.TO.InvProductoPresentacionUnidadesComboListadoTO> getListaPresentacionUnidadComboTO(String empresa) throws Exception;
    java.util.List<inventario.TO.InvProductoMarcaComboListadoTO> getInvMarcaComboListadoTO(String empresa) throws Exception;
    java.util.List<inventario.TO.InvProductoPresentacionCajasComboListadoTO> getListaPresentacionCajaComboTO(String empresa) throws Exception;
    java.util.List<inventario.TO.InvCompraMotivoComboTO> getListaCompraMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception;
    java.util.List<inventario.TO.InvVentaMotivoComboTO> getListaVentaMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception;
    java.util.List<inventario.TO.InvProformaMotivoComboTO> getListaProformaMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception;
    java.util.List<inventario.TO.InvCategoriaProveedorComboTO> getListaCategoriaProveedorComboTO(String empresa) throws Exception;
    java.util.List<inventario.TO.InvCategoriaClienteComboTO> getListaCategoriaClienteComboTO(String empresa) throws Exception;
    java.util.List<inventario.TO.InvBodegaTO> getBodegaTO(String empresa, String codigo) throws Exception;
    java.util.List<inventario.TO.InvProductoTO> getProductoTO(String empresa, String codigo) throws Exception;
    java.util.List<inventario.TO.InvClienteTO> getClienteTO(String empresa, String codigo) throws Exception;
    java.util.List<inventario.TO.InvProveedorTO> getProveedorTO(String empresa, String codigo) throws Exception;
    inventario.TO.InvProveedorTO getBuscaCedulaProveedorTO(String empresa, String cedRuc) throws Exception;
    boolean comprobarInvAplicaRetencionIva(String empresa, String codigo) throws Exception;

    java.util.List<inventario.TO.InvComboFormaPagoTO> getComboFormaPagoCompra(String empresa) throws Exception;
    java.util.List<inventario.TO.InvComboFormaPagoTO> getComboFormaPagoVenta(String empresa) throws Exception;

    inventario.TO.InvCompraCabeceraTO getInvCompraCabeceraTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception;

    inventario.TO.InvConsultaVentasFacturasPorNumeroTO getConsultaVentasFacturasPorNumeroTO (String codigoEmpresa, String numFactura) throws Exception;
    
    inventario.TO.InvVentaCabeceraTO getInvVentaCabeceraTO(String empresa, String periodo, String motivo, String numeroVenta) throws Exception;
    
    inventario.TO.InvProformaCabeceraTO getInvProformaCabeceraTO(String empresa, String periodo, String motivo, String numeroProforma) throws Exception;

    inventario.TO.InvConsumosTO getInvConsumoCabeceraTO(String empresa, String periodo, String motivo, String numeroConsumo) throws Exception;

    java.util.List<inventario.TO.InvListaDetalleComprasTO> getListaInvCompraDetalleTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception;

    java.util.List<inventario.TO.InvListaDetalleVentasTO> getListaInvVentasDetalleTO(String empresa, String periodo, String motivo, String numeroVentas) throws Exception;
    
    java.util.List<inventario.TO.InvListaDetalleProformasTO> getListaInvProformasDetalleTO(String empresa, String periodo, String motivo, String numeroProformas) throws Exception;

    java.util.List<inventario.TO.InvListaDetalleConsumoTO> getListaInvConsumoDetalleTO(String empresa, String periodo, String motivo, String numeroConsumos) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaCompraTO> getFunComprasListado(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception;
    java.util.List<inventario.TO.InvListaConsultaCompraTO> getListaInvConsultaCompra(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaVentaTO> getFunVentasListado(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception;
    java.util.List<inventario.TO.InvListaConsultaVentaTO> getListaInvConsultaVenta(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception;
    java.util.List<inventario.TO.InvListaConsultaProformaTO> getListaInvConsultaProforma(String empresa, String periodo, String motivo, String busqueda) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaConsumosTO> getFunConsumosListado(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception;
    java.util.List<inventario.TO.InvListaConsultaConsumosTO> getListaInvConsultaConsumos(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception;

    java.util.List<inventario.TO.InvConsumosImportarExportarTO> getListaInvConsumosImportarExportarTO(String empresa, String desde, String hasta) throws Exception;
    java.util.List<inventario.TO.InvConsumosMotivoComboTO> getListaConsumosMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception;

    java.util.List<inventario.TO.InvMedidaComboTO> getListaInvMedidaTablaTO(String empresa) throws Exception;

    

    inventario.TO.InvComprasMotivoTO getInvComprasMotivoTO(String empresa, inventario.TO.InvCompraMotivoTablaTO invCompraMotivoTablaTO) throws Exception;
    inventario.TO.InvVentaMotivoTO getInvVentasMotivoTO(String empresa, inventario.TO.InvVentaMotivoTablaTO invVentaMotivoTablaTO) throws Exception;
    inventario.TO.InvProformaMotivoTO getInvProformasMotivoTO(String empresa, inventario.TO.InvProformaMotivoTablaTO invProformaMotivoTablaTO) throws Exception;
    inventario.TO.InvConsumosMotivoTO getInvConsumosMotivoTO(String empresa, inventario.TO.InvListaConsumosMotivoTO invListaConsumosMotivoTO) throws Exception;
    inventario.entity.InvComprasMotivo getInvComprasMotivo(String empresa, String codigo) throws Exception;
    inventario.entity.InvVentasMotivo getInvVentasMotivo(String empresa, String codigo) throws Exception;
    inventario.entity.InvProformasMotivo getInvProformasMotivo(String empresa, String codigo) throws Exception;
    java.util.List<inventario.TO.InvCompraMotivoTablaTO> getListaInvComprasMotivoTablaTO(String empresa) throws Exception;
    java.util.List<inventario.TO.InvVentaMotivoTablaTO> getListaInvVentasMotivoTablaTO(String empresa) throws Exception;
    java.util.List<inventario.TO.InvProformaMotivoTablaTO> getListaInvProformaMotivoTablaTO(String empresa) throws Exception;
    java.util.List<inventario.TO.InvListaConsumosMotivoTO> getInvListaConsumosMotivoTO(java.lang.String empresa) throws java.lang.Exception;

    java.util.List<inventario.TO.InvNumeracionCompraTO> getListaInvNumeracionCompraTO(String empresa, String periodo, String motivo) throws java.lang.Exception;
    java.util.List<inventario.TO.InvNumeracionVentaTO> getListaInvNumeracionVentaTO(String empresa, String periodo, String motivo) throws Exception;
    java.util.List<inventario.TO.InvNumeracionConsumoTO> getListaInvNumeracionConsumoTO(String empresa, String periodo, String motivo) throws Exception;

    java.lang.Boolean buscarInvComprasFormaPago(java.lang.String ctaContable, java.lang.String empresa) throws java.lang.Exception;
    java.util.List<inventario.TO.InvListaComprasFormaPagoTO> getInvListaComprasFormaPagoTO(java.lang.String empresa) throws java.lang.Exception;

    java.lang.Boolean buscarInvVentasFormaPago(java.lang.String ctaContable, java.lang.String empresa) throws java.lang.Exception;
    java.util.List<inventario.TO.InvListaVentasFormaPagoTO> getInvListaVentasFormaPagoTO(java.lang.String empresa) throws java.lang.Exception;

    inventario.entity.InvProductoSaldos getInvProductoSaldo(String empresa, String codigoBodega, String codigoProducto) throws Exception;

    java.util.List<inventario.TO.InvKardexTO> getListaInvKardexTO(java.lang.String empresa, java.lang.String bodega, java.lang.String producto, java.lang.String desde, java.lang.String hasta, java.lang.String promedio) throws java.lang.Exception;

    java.util.List<inventario.TO.SaldoBodegaTO> getListaSaldoBodegaTO(String empresa, String bodega, String hasta) throws Exception;

    inventario.TO.InvComprasRecepcionTO getInvComprasRecepcionTO(String empresa, String periodo, String motivo, String numero) throws Exception;

    Boolean buscarExisteNombreProducto(String empresa, String nombreProducto) throws Exception;

    boolean getClienteRepetido(String empresa, String codigo, String id, String nombre, String razonSocial) throws Exception;

    boolean getProductoRepetido(String empresa, String codigo, String alterno, String barras, String barras2, String barras3, String barras4, String barras5, String nombre) throws Exception;

    boolean getProveedorRepetido(String empresa, String codigo, String id, String nombre, String razonSocial) throws Exception;

    java.util.List<inventario.TO.InvProductosConErrorTO> getListadoProductosConError(String empresa) throws Exception;

    java.lang.String getInvProximaNumeracionCliente(java.lang.String empresa, inventario.TO.InvClienteTO invClienteTO) throws Exception;
    
    java.lang.String getInvProximaNumeracionProveedor(java.lang.String empresa, inventario.TO.InvProveedorTO invProveedorTO) throws Exception;
    
    java.lang.String getInvProximaNumeracionProducto(java.lang.String empresa, inventario.TO.InvProductoTO invProductoTO) throws Exception;

    inventario.entity.InvNumeracionVarios getInvNumeracionVarios(java.lang.String empresa) throws java.lang.Exception;

    Boolean getPrecioFijoCategoriaProducto(java.lang.String empresa, java.lang.String codigoCategoria) throws java.lang.Exception;
    
    java.util.List<inventario.TO.InvListaTransferenciaMotivoTO> getInvListaTransferenciaMotivoTO(java.lang.String empresa) throws java.lang.Exception;
    
    Boolean comprobarInvTransferenciaMotivo(String empresa, String motCodigo) throws Exception;
    
    inventario.entity.InvTransferenciasMotivo buscarInvTransferenciaMotivo(String empresa, String codigo) throws Exception;

    inventario.entity.InvTransferencias buscarInvTransferencias(String empresa, String perCodigo, String transCodigo, String transNumero) throws Exception;

    Boolean comprobarInvTransferenciasMotivo(String empresa, String transCodigo) throws Exception;

    int buscarConteoUltimaNumeracionTransferencias(String empCodigo, String perCodigo, String motCodigo) throws Exception;

    inventario.TO.InvTransferenciasTO getInvTransferenciasCabeceraTO(String empresa, String periodo, String motivo, String numeroConsumo) throws Exception;

    java.util.List<inventario.TO.InvListaDetalleTransferenciaTO> getListaInvTransferenciasDetalleTO(String empresa, String periodo, String motivo, String numeroTrans) throws Exception;

    java.util.List<inventario.TO.InvListaConsultaTransferenciaTO> getFunListadoTransferencias(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception;
    java.util.List<inventario.TO.InvListaConsultaTransferenciaTO> getListaInvConsultaTransferencia(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception;

    java.util.List<inventario.TO.InvTransferenciaMotivoComboTO> getListaTransferenciaMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception;

    inventario.TO.InvTransferenciaMotivoTO getInvTransferenciasMotivoTO(String empresa, inventario.TO.InvListaTransferenciaMotivoTO invListaTransferenciaMotivoTO) throws Exception;

    java.util.List<inventario.TO.InvNumeracionTransferenciaTO> getListaInvNumeracionTransferenciaTO(String empresa, String periodo, String motivo) throws Exception;

    java.util.List<inventario.TO.InvListaProductosCambiarPrecioTO> getListaProductosCambiarPrecioTO(String empresa, String busqueda, String bodega, String fecha) throws Exception;

    inventario.TO.InvEstadoCCCVT getEstadoCCCVT(java.lang.String empresa, java.lang.String periodo, java.lang.String motivo, java.lang.String numero, java.lang.String proceso) throws java.lang.Exception;

    java.util.List<inventario.TO.InvProductoSincronizarTO> invProductoSincronizar(java.lang.String empresaOrigen, java.lang.String empresaDestino) throws java.lang.Exception;
    java.util.List<inventario.TO.InvCategoriaSincronizarTO> invCategoriasSincronizar(java.lang.String empresaOrigen, java.lang.String empresaDestino) throws java.lang.Exception;

    java.util.List<inventario.TO.InvListadoPagosTO> invListadoPagosTO(java.lang.String empresa, java.lang.String periodo, java.lang.String motivo, java.lang.String numero) throws java.lang.Exception;
    
    java.util.List<inventario.TO.InvListadoCobrosTO> invListadoCobrosTO(java.lang.String empresa, java.lang.String periodo, java.lang.String motivo, java.lang.String numero) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunComprasTO> getInvFunComprasTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String motivo, java.lang.String proveedor, java.lang.String documento) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunVentasTO> getInvFunVentasTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String motivo, java.lang.String cliente, java.lang.String documento) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunComprasConsolidandoProductosTO> getInvFunComprasConsolidandoProductosTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, String sector, java.lang.String bodega, java.lang.String proveedor) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunVentasConsolidandoProductosTO> getInvFunVentasConsolidandoProductosTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta,  java.lang.String sector, java.lang.String bodega, java.lang.String cliente) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunVentasVsCostoTO> getInvFunVentasVsCostoTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String bodega, java.lang.String cliente) throws java.lang.Exception;

    java.util.List<inventario.TO.InvFunListadoProductosTO> getInvFunListadoProductosTO(java.lang.String empresa, java.lang.String categoria, java.lang.String busqueda) throws java.lang.Exception;
    java.util.List<inventario.TO.InvFunListadoClientesTO> getInvFunListadoClientesTO(java.lang.String empresa, java.lang.String categoria) throws java.lang.Exception;
    java.util.List<inventario.TO.InvFunListadoProveedoresTO> getInvFunListadoProveedoresTO(java.lang.String empresa, java.lang.String categoria) throws java.lang.Exception;
    java.math.BigDecimal getInvVentaTotal(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String cliente) throws java.lang.Exception;

    java.lang.Boolean getPuedeEliminarProducto(java.lang.String empresa, java.lang.String producto) throws java.lang.Exception;

    java.util.List<inventario.entity.InvVentas> getVentasParaContabilizar(java.lang.String empresa, java.lang.String sector, java.lang.String fecha, java.lang.String usuario) throws java.lang.Exception;
    
    java.math.BigDecimal getPrecioProductoPorCantidad(String empresa, String codProducto, java.math.BigDecimal cantidad) throws Exception;
    
    java.math.BigDecimal getCantidad3(String empresa, String codProducto) throws Exception;

    java.util.List<inventario.TO.InvSecuenciaComprobanteTO> getInvSecuenciaComprobanteTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<inventario.TO.InvListaProductosCambiarPrecioCantidadTO> getListaProductosCambiarPrecioCantidadTO(java.lang.String empresa, java.lang.String busqueda, java.lang.String bodega, java.lang.String fecha) throws java.lang.Exception;

    java.util.List<inventario.TO.InvProductoTipoComboTO> getInvProductoTipoComboListadoTO(java.lang.String empresa, String accion) throws java.lang.Exception;

    inventario.entity.InvProductoPresentacionUnidades buscarInvProductoPresentacionUnidades(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarInvProductoPresentacionUnidades(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarEliminarInvProductoPresentacionUnidades(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    
    inventario.entity.InvProductoMarca buscarInvProductoMarca(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarInvProductoMarca(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarEliminarInvProductoMarca(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    
    inventario.entity.InvVendedor buscarInvVendedor(java.lang.String empresa, java.lang.String codigo) throws Exception;
    boolean comprobarInvVendedor(java.lang.String empresa, java.lang.String codigo) throws Exception;
    boolean comprobarEliminarInvVendedor(java.lang.String empresa, java.lang.String codigo) throws Exception;
    
    inventario.entity.InvProductoPresentacionCajas buscarInvProductoPresentacionCajas(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarInvProductoPresentacionCajas(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarEliminarInvProductoPresentacionCajas(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    
    inventario.entity.InvProductoTipo buscarInvProductoTipo(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarInvProductoTipo(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    boolean comprobarEliminarInvProductoTipo(java.lang.String empresa, java.lang.String codigo) throws java.lang.Exception;
    
    inventario.entity.InvVentasComplemento buscarVentasComplemento(String empresa, String periodo, String motivo, String numero) throws java.lang.Exception;
    
    Boolean buscarConteoCliente(String empCodigo, String codigoCliente) throws Exception;
    
    Boolean buscarConteoProveedor(String empCodigo, String codigoProveedor) throws Exception;
    
    inventario.entity.InvComprasMotivoAnulacion buscarCompraMotivo (String empresa, String periodo, String motivo, String numero) throws Exception;
    
    inventario.entity.InvVentasMotivoAnulacion buscarVentaMotivo (String empresa, String periodo, String motivo, String numero) throws Exception;

    java.util.List<inventario.TO.SaldoBodegaComprobacionTO> getInvFunSaldoBodegaComprobacionTO(java.lang.String empresa, java.lang.String bodega, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception;
    
    java.util.List<inventario.TO.SaldoBodegaComprobacionTO> getInvFunSaldoBodegaComprobacionCantidadesTO(java.lang.String empresa, java.lang.String bodega, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception;
    
    java.util.List<InvFunConsumosTO> getInvFunConsumosTO(String empresa, String desde, String hasta, String motivo) throws Exception;
    
    java.util.List<inventario.TO.InvFunConsumosConsolidandoProductosTO> getInvFunConsumosConsolidandoProductosTO(String empresa, String desde, String hasta, String sector, String bodega) throws Exception;
    
    Boolean reconstruirCostos(String empCodigo, String Producto, String periodoHasta, Boolean periodoEstado) throws Exception;
    inventario.entity.InvVendedor buscaInvVendedor(String empresa, String codigo) throws Exception;
    java.util.List<inventario.TO.InvVendedorComboListadoTO> getComboinvListaVendedorTOs(String codigoEmpresa) throws Exception;
    java.util.List<inventario.TO.InvFunListaProductosImpresionPlacasTO> getInvFunListaProductosImpresionPlacasTO(java.lang.String empresa, java.lang.String producto, boolean estado) throws Exception;
    java.util.List<inventario.TO.InvFunListaProductosSaldosGeneralTO> getInvFunListaProductosSaldosGeneralTO(String empresa, String producto, String fecha, boolean estado) throws Exception;
    java.util.List<inventario.TO.InvFunUltimasComprasTO> getInvFunUltimasComprasTOs(java.lang.String empresa, java.lang.String producto) throws Exception;
    inventario.TO.InvComprasTO getComprasTO (String empresa, String periodo, String motivo, String numeroCompra) throws Exception;

    //public java.lang.String getCompra(java.lang.String empresa, java.lang.String periodo, java.lang.String conTipo, java.lang.String numero);

    public Object[] getCompra(String empresa, String perCodigo, String motCodigo, String compNumero)throws Exception;

    public Object[] getVenta(String empresa, String perCodigo, String motCodigo, String compNumero)throws Exception;
}
