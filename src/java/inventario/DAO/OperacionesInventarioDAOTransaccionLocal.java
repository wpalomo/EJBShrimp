/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.DAO;

import javax.ejb.Local;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesInventarioDAOTransaccionLocal {

    java.lang.Boolean accionInvProveedorCategoria(inventario.entity.InvProveedorCategoria invProveedorCategoria, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionInvClienteCategoria(inventario.entity.InvClienteCategoria invClienteCategoria, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionInvProductoCategoria(inventario.entity.InvProductoCategoria invProductoCategoria, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionInvProductoMedida(inventario.entity.InvProductoMedida invProductoMedida, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    
    boolean insertarInvProducto(inventario.entity.InvProducto invProducto, sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvNumeracionVarios invNumeracionVarios) throws Exception;
    boolean modificarInvProducto(inventario.entity.InvProducto invProducto, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean modificarInvProductoLlavePrincipal(inventario.entity.InvProducto invProductoEliminar, inventario.entity.InvProducto invProducto, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean eliminarInvProducto(inventario.entity.InvProducto invProducto, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;

    boolean insertarInvCliente(inventario.entity.InvCliente invCliente, sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvNumeracionVarios invNumeracionVarios) throws Exception;
    boolean modificarInvCliente(inventario.entity.InvCliente invCliente, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean eliminarInvCliente(
            inventario.entity.InvCliente invCliente, 
            sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean modificarInvClienteLlavePrincipal(inventario.entity.InvCliente invClienteEliminar, inventario.entity.InvCliente invCliente, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;

    boolean insertarInvProveedor(inventario.entity.InvProveedor invProveedor, sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvNumeracionVarios invNumeracionVarios) throws Exception;
    boolean modificarInvProveedor(inventario.entity.InvProveedor invProveedor, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean modificarInvProveedorLlavePrincipal(inventario.entity.InvProveedor invProveedorEliminar, inventario.entity.InvProveedor invProveedor, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    
    boolean insertarInvBodega(inventario.entity.InvBodega invBodega, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean modificarInvBodega(inventario.entity.InvBodega invBodega, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    
    boolean insertarTransaccionInvCompra(
            inventario.entity.InvCompras invCompras, 
            java.util.List<inventario.entity.InvComprasDetalle> listaInvComprasDetalles, 
            sistemaWeb.entity.SisSuceso sisSuceso, 
            inventario.entity.InvComprasNumeracion invComprasNumeracion, 
            anexos.entity.AnxCompra anxCompra, 
            java.util.List<anexos.entity.AnxCompraDetalle> anxCompraDetalle, 
            java.util.List<anexos.entity.AnxCompraDividendo> anxCompraDividendos, 
            java.util.List<anexos.entity.AnxCompraReembolso> anxCompraReembolso, 
            java.util.List<anexos.entity.AnxCompraFormaPago> anxCompraFormaPago, 
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos) throws Exception;
    boolean insertarTransaccionInvVenta(
            inventario.entity.InvVentas invVentas, 
            java.util.List<inventario.entity.InvVentasDetalle> listaInvVentasDetalles, 
            sistemaWeb.entity.SisSuceso sisSuceso, 
            inventario.entity.InvVentasNumeracion invVentasNumeracion, 
            anexos.entity.AnxVenta anxVenta, 
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos, 
            inventario.entity.InvVentasComplemento invVentasComplemento,
            anexos.entity.AnxVentaElectronica anxVentaElectronica) throws Exception;
    
    boolean insertarTransaccionInvProformas(inventario.entity.InvProformas invProformas, java.util.List<inventario.entity.InvProformasDetalle> listaInvProformasDetalles, sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvProformasNumeracion invProformasNumeracion) throws Exception;

    boolean insertarTransaccionInvConsumos(inventario.entity.InvConsumos invConsumo, java.util.List<inventario.entity.InvConsumosDetalle> listaInvConsumosDetalles, sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvConsumosNumeracion invConsumosNumeracion, java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos) throws Exception;

    boolean modificarInvCompras(
            inventario.entity.InvCompras invCompras, 
            java.util.List<inventario.entity.InvComprasDetalle> listaInvDetalle, 
            java.util.List<inventario.entity.InvComprasDetalle> listaInvDetalleEliminar, 
            anexos.entity.AnxCompra anxCompra, 
            java.util.List<anexos.entity.AnxCompraDetalle> anxCompraDetalle, 
            java.util.List<anexos.entity.AnxCompraDetalle> anxCompraDetalleEliminar, 
            java.util.List<anexos.entity.AnxCompraDividendo> anxCompraDividendos, 
            java.util.List<anexos.entity.AnxCompraReembolso> anxCompraReembolsos, 
            java.util.List<anexos.entity.AnxCompraReembolso> anxCompraReembolsoEliminar, 
            java.util.List<anexos.entity.AnxCompraFormaPago> anxCompraFormaPago, 
            java.util.List<anexos.entity.AnxCompraFormaPago> anxCompraFormaPagoEliminar, 
            sistemaWeb.entity.SisSuceso sisSuceso, 
            java.util.List<sistemaWeb.entity.SisSuceso> listaSisSuceso, 
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos, 
            contabilidad.entity.ConContable conContable, 
            inventario.entity.InvComprasMotivoAnulacion invComprasMotivoAnulacion, 
            boolean eliminarMotivoAnulacion) throws Exception;
    boolean modificarInvVentas(inventario.entity.InvVentas invVentas, java.util.List<inventario.entity.InvVentasDetalle> listaInvDetalle, java.util.List<inventario.entity.InvVentasDetalle> listaInvDetalleEliminar, sistemaWeb.entity.SisSuceso sisSuceso, java.util.List<sistemaWeb.entity.SisSuceso> listaSisSuceso, java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos, contabilidad.entity.ConContable conContable, anexos.entity.AnxVenta anxVentas, inventario.entity.InvVentasComplemento invVentasComplemento, String complemento, inventario.entity.InvVentasMotivoAnulacion invVentasMotivoAnulacion, boolean eliminarMotivoAnulacion) throws Exception;
    boolean modificarInvProformas(inventario.entity.InvProformas invProformas, java.util.List<inventario.entity.InvProformasDetalle> listaInvProforma, java.util.List<inventario.entity.InvProformasDetalle> listaInvDetalleEliminar, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean modificarInvConsumos(inventario.entity.InvConsumos invConsumos, java.util.List<inventario.entity.InvConsumosDetalle> listaInvDetalle, java.util.List<inventario.entity.InvConsumosDetalle> listaInvDetalleEliminar, sistemaWeb.entity.SisSuceso sisSuceso, java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos, inventario.entity.InvConsumosMotivoAnulacion invConsumosMotivoAnulacion) throws Exception;

    java.lang.Boolean insertarInvConsumosMotivo(inventario.entity.InvConsumosMotivo invConsumosMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception;
    java.lang.Boolean modificarInvConsumosMotivo(inventario.entity.InvConsumosMotivo invConsumosMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception;
    java.lang.Boolean eliminarInvConsumosMotivo(inventario.entity.InvConsumosMotivo invConsumosMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception;

    java.lang.Boolean accionInvConsumosMotivo(inventario.entity.InvConsumosMotivo invConsumosMotivo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;

    java.lang.Boolean accionInvComprasFormaPago(inventario.entity.InvComprasFormaPago invComprasFormaPago, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionInvVentasFormaPago(inventario.entity.InvVentasFormaPago invVentasFormaPago, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    
    boolean insertarInvComprasMotivo(inventario.entity.InvComprasMotivo invComprasMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean modificarInvComprasMotivo(inventario.entity.InvComprasMotivo invComprasMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;

    boolean insertarInvVentasMotivo(inventario.entity.InvVentasMotivo invVentasMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean insertarInvProformaMotivo(inventario.entity.InvProformasMotivo invProformasMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean modificarInvVentasMotivo(inventario.entity.InvVentasMotivo invVentasMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean modificarInvProformaMotivo(inventario.entity.InvProformasMotivo invProformaMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean insertarModificarinvComprasRecepcion(inventario.entity.InvComprasRecepcion invComprasRecepcion, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;

    boolean insertarTransaccionInvTransferencias(inventario.entity.InvTransferencias invTransferencias, java.util.List<inventario.entity.InvTransferenciasDetalle> listaInvTransferenciasDetalles, sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvTransferenciasNumeracion invTransferenciasNumeracion, java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosOrigen, java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosDestino) throws Exception;
    boolean modificarInvTransferencias(inventario.entity.InvTransferencias invTransferencias, java.util.List<inventario.entity.InvTransferenciasDetalle> listaInvDetalle, java.util.List<inventario.entity.InvTransferenciasDetalle> listaInvDetalleEliminar, sistemaWeb.entity.SisSuceso sisSuceso, java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosOriginal, java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosDestino, inventario.entity.InvTransferenciasMotivoAnulacion invTransferenciasMotivoAnulacion) throws Exception;
    
    java.lang.Boolean accionInvTransferenciasMotivo(inventario.entity.InvTransferenciasMotivo invTransferenciasMotivo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;

    java.lang.Boolean invCambiarPrecioProductos(java.util.List<inventario.entity.InvProducto> invProductos, java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos) throws java.lang.Exception;

    java.lang.Boolean invSincronizarProductosCategorias(java.util.List<inventario.entity.InvProducto> invProductos, java.util.List<inventario.entity.InvProductoCategoria> invProductoCategorias, java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos) throws java.lang.Exception;

    java.lang.Boolean accionInvProductoPresentacionUnidades(inventario.entity.InvProductoPresentacionUnidades invProductoPresentacionUnidades, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionInvProductoMarca(inventario.entity.InvProductoMarca invProductoMarca, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionInvVendedor(inventario.entity.InvVendedor invVendedor, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionInvProductoPresentacionCajas(inventario.entity.InvProductoPresentacionCajas invProductoPresentacionCajas, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionInvProductoTipo(inventario.entity.InvProductoTipo invProductoTipo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
}
