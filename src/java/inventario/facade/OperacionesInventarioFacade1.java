/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.facade;

import anexos.TO.AnxVentaTO;
import inventario.TO.*;
import inventario.entity.InvVentasMotivoAnulacion;
import inventario.reporte.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisInfoTO;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */

@Stateless
public class OperacionesInventarioFacade1 implements OperacionesInventarioFacadeRemote1 {

    @javax.ejb.EJB
    inventario.business.OperacionesInventarioBusinessLocal1 operacionesInventarioBusinessLocal;


    public String accionInvProveedorCategoria(
            inventario.TO.InvProveedorCategoriaTO invProveedorCategoriaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.accionInvProveedorCategoria(invProveedorCategoriaTO, accion, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvProveedorCategoriaTO> getInvProveedorCategoriaTO(String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getInvProveedorCategoriaTO(empresa);
    }

    public String accionInvClienteCategoria(
            inventario.TO.InvClienteCategoriaTO invClienteCategoriaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.accionInvClienteCategoria(invClienteCategoriaTO, accion, sisInfoTO);
    }

    /// reportes
    

    public java.util.List<inventario.TO.InvClienteCategoriaTO> getInvClienteCategoriaTO(String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getInvClienteCategoriaTO(empresa);
    }

    public String accionInvProductoCategoria(
            inventario.TO.InvProductoCategoriaTO invProductoCategoriaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.accionInvProductoCategoria(invProductoCategoriaTO, accion, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvProductoCategoriaTO> getInvProductoCategoriaTO(String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getInvProductoCategoriaTO(empresa);
    }

    public String accionInvProductoMedida(
            inventario.TO.InvProductoMedidaTO invProductoMedidaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.accionInvProductoMedida(invProductoMedidaTO, accion, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvProductoMedidaTO> getInvProductoMedidaTO(String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getInvProductoMedidaTO(empresa);
    }

    public inventario.TO.InvProductoDAOTO buscarInvProductoDAOTO(String empresa, String codigoProducto) throws Exception {
        return operacionesInventarioBusinessLocal.buscarInvProductoDAOTO(empresa, codigoProducto);
    }

    public String insertarProductoTO(
            InvProductoTO invProductoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvProductoTO(invProductoTO, sisInfoTO);
    }

    public boolean productoRepetidoCodigoBarra(String empresa, String barras) throws Exception {
        return operacionesInventarioBusinessLocal.productoRepetidoCodigoBarra(empresa, barras);
    }

    public String modificarProductoTO(
            InvProductoTO invProductoTO,
            String codigoCambiarLlave,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvProductoTO(invProductoTO, codigoCambiarLlave, sisInfoTO);
    }

    public String eliminarInvProductoTO(
            InvProductoTO invProductoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.eliminarInvProductoTO(invProductoTO, sisInfoTO);
    }

    public String insertarClienteTO(
            InvClienteTO invClienteTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvClienteTO(invClienteTO, sisInfoTO);
    }

    public String eliminarInvClienteTO(inventario.TO.InvClienteTO invClienteTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.eliminarInvClienteTO(invClienteTO, sisInfoTO);
    }

    public boolean getClienteRepetido(String empresa, String codigo, String id, String nombre, String razonSocial) throws Exception {
        return operacionesInventarioBusinessLocal.getClienteRepetido(empresa, codigo, id, nombre, razonSocial);
    }

    public String modificarClienteTO(
            InvClienteTO invClienteTO,
            String codigoAnterior,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvClienteTO(invClienteTO, codigoAnterior, sisInfoTO);
    }

    public String insertarProveedorTO(
            InvProveedorTO invProveedorTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvProveedorTO(invProveedorTO, sisInfoTO);
    }

    public String modificarProveedorTO(
            InvProveedorTO invProveedorTO,
            String codigoAnterior,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvProveedorTO(invProveedorTO, codigoAnterior, sisInfoTO);
    }

    public String insertarBodegaTO(InvBodegaTO invBodegaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvBodegaTO(invBodegaTO, sisInfoTO);
    }

    public String modificarBodegaTO(
            InvBodegaTO invBodegaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvBodegaTO(invBodegaTO, sisInfoTO);
    }

    public inventario.TO.MensajeTO insertarInvComprasTO(
            InvComprasTO invComprasTO,
            java.util.List<inventario.TO.InvComprasDetalleTO> listaInvComprasDetalleTO,
            anexos.TO.AnxCompraTO anxCompraTO,
            java.util.List<anexos.TO.AnxCompraDetalleTO> anxCompraDetalleTO,
            java.util.List<anexos.TO.AnxCompraReembolsoTO> anxCompraReembolsoTO,
            java.util.List<anexos.TO.AnxCompraFormaPagoTO> anxCompraFormaPagoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvComprasTO(
                invComprasTO,
                listaInvComprasDetalleTO,
                anxCompraTO,
                anxCompraDetalleTO,
                anxCompraReembolsoTO,
                anxCompraFormaPagoTO,
                sisInfoTO);
    }

    public inventario.TO.MensajeTO insertarInvVentasTO(
            inventario.TO.InvVentasTO invVentasTO,
            java.util.List<inventario.TO.InvVentasDetalleTO> listaInvVentasDetalleTO,
            anexos.TO.AnxVentaTO anxVentasTO,
            String tipoDocumentoComplemento,
            String numeroDocumentoComplemento,
            String estadoVentaElectronica,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvVentasTO(
                invVentasTO,
                listaInvVentasDetalleTO,
                anxVentasTO,
                tipoDocumentoComplemento,
                numeroDocumentoComplemento,
                estadoVentaElectronica,
                sisInfoTO);
    }

    public String getConteoNumeroFacturaVenta(
            String empresaCodigo,
            String compDocumentoTipo,
            String compDocumentoNumero) throws Exception {
        return operacionesInventarioBusinessLocal.getConteoNumeroFacturaVenta(empresaCodigo, compDocumentoTipo, compDocumentoNumero);
    }

    public inventario.TO.MensajeTO insertarInvProformasTO(
            inventario.TO.InvProformasTO invProformasTO,
            java.util.List<inventario.TO.InvProformasDetalleTO> listaInvProformasDetalleTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvProformasTO(invProformasTO, listaInvProformasDetalleTOs, sisInfoTO);
    }

    public inventario.TO.MensajeTO insertarInvContableComprasTO(
            String empresa,
            String periodo,
            String motivo,
            String compraNumero,
            String codigoUsuario,
            boolean recontabilizar,
            String conNumero,
            boolean recontabilizarSinPendiente,
            String tipCodigo,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvContableComprasTO(
                empresa,
                periodo,
                motivo,
                compraNumero,
                codigoUsuario,
                recontabilizar,
                conNumero,
                recontabilizarSinPendiente,
                tipCodigo, sisInfoTO);
    }

    public String insertarInvContableVentasTO(
            String empresa,
            String periodo,
            String motivo,
            String ventaNumero,
            String codigoUsuario,
            boolean recontabilizar,
            String conNumero,
            String tipCodigo,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvContableVentasTO(
                empresa,
                periodo,
                motivo,
                ventaNumero,
                codigoUsuario,
                recontabilizar,
                conNumero,
                tipCodigo,
                sisInfoTO);

    }

    public inventario.TO.InvCompraCabeceraTO getInvCompraCabeceraTO(
            String empresa,
            String codigoPeriodo,
            String motivo,
            String numeroCompra) throws Exception {
        return operacionesInventarioBusinessLocal.getInvCompraCabeceraTO(empresa, codigoPeriodo, motivo, numeroCompra);
    }

    public inventario.TO.InvVentaCabeceraTO getInvVentaCabeceraTO(
            String empresa,
            String codigoPeriodo,
            String motivo,
            String numeroVenta) throws Exception {
        return operacionesInventarioBusinessLocal.getInvVentaCabeceraTO(empresa, codigoPeriodo, motivo, numeroVenta);
    }

    public inventario.TO.InvProformaCabeceraTO getInvProformaCabeceraTO(
            String empresa,
            String codigoPeriodo,
            String motivo,
            String numeroProforma) throws Exception {
        return operacionesInventarioBusinessLocal.getInvProformaCabeceraTO(empresa, codigoPeriodo, motivo, numeroProforma);
    }

    public inventario.TO.InvConsumosTO getInvConsumoCabeceraTO(
            String empresa,
            String codigoPeriodo,
            String motivo,
            String numeroConsumo) throws Exception {
        return operacionesInventarioBusinessLocal.getInvConsumoCabeceraTO(empresa, codigoPeriodo, motivo, numeroConsumo);
    }

    public java.util.List<inventario.TO.InvListaDetalleComprasTO> getListaInvCompraDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroCompra) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvCompraDetalleTO(empresa, periodo, motivo, numeroCompra);
    }

    public java.util.List<inventario.TO.InvListaDetalleVentasTO> getListaInvVentasDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroVentas) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvVentasDetalleTO(empresa, periodo, motivo, numeroVentas);
    }

    public java.util.List<inventario.TO.InvListaDetalleProformasTO> getListaInvProformasDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroProformas) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvProformasDetalleTO(empresa, periodo, motivo, numeroProformas);
    }

    public java.util.List<inventario.TO.InvListaDetalleConsumoTO> getListaInvConsumoDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroConsumos) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvConsumoDetalleTO(empresa, periodo, motivo, numeroConsumos);
    }

    public inventario.TO.MensajeTO modificarInvComprasTO(
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
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvComprasTO(
                invComprasTO,
                listaInvComprasDetalleTO,
                listaInvComprasEliminarDetalleTO,
                anxCompraTO, anxCompraDetalleTO,
                anxCompraDetalleEliminarTO,
                anxCompraReembolsoTO,
                anxCompraReembolsoEliminarTO,
                anxCompraFormaPagoTO,
                anxCompraFormaPagoEliminarTO,
                desmayorizar,
                quitarAnulado,
                invComprasMotivoAnulacion,
                sisInfoTO);
    }

    public MensajeTO modificarInvVentasTO(
            InvVentasTO invVentasTO,
            List<InvVentasDetalleTO> listaInvVentasDetalleTO,
            List<InvVentasDetalleTO> listaInvVentasEliminarDetalleTO,
            boolean desmayorizar,
            AnxVentaTO anxVentasTO,
            boolean quitarAnulado,
            String tipoDocumentoComplemento,
            String numeroDocumentoComplemento,
            InvVentasMotivoAnulacion invVentasMotivoAnulacion,
            SisInfoTO sisInfoTO) throws Exception {

        return operacionesInventarioBusinessLocal.modificarInvVentasTO(
                invVentasTO,
                listaInvVentasDetalleTO,
                listaInvVentasEliminarDetalleTO,
                desmayorizar, anxVentasTO,
                quitarAnulado,
                tipoDocumentoComplemento,
                numeroDocumentoComplemento,
                invVentasMotivoAnulacion,
                sisInfoTO);

    }

    public inventario.TO.MensajeTO modificarInvProformasTO(
            inventario.TO.InvProformasTO invProformasTO,
            java.util.List<inventario.TO.InvProformasDetalleTO> listaInvProformasDetalleTO,
            java.util.List<inventario.TO.InvProformasDetalleTO> listaInvProformasEliminarDetalleTO,
            boolean quitarAnulado,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvProformasTO(invProformasTO, listaInvProformasDetalleTO, listaInvProformasEliminarDetalleTO, quitarAnulado, sisInfoTO);
    }

    public inventario.TO.MensajeTO modificarInvConsumosTO(
            inventario.TO.InvConsumosTO invConsumosTO,
            java.util.List<inventario.TO.InvConsumosDetalleTO> listaInvConsumosDetalleTO,
            java.util.List<inventario.TO.InvConsumosDetalleTO> listaInvConsumosEliminarDetalleTO,
            boolean desmayorizar,
            inventario.entity.InvConsumosMotivoAnulacion invConsumosMotivoAnulacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvConsumosTO(invConsumosTO, listaInvConsumosDetalleTO, listaInvConsumosEliminarDetalleTO, desmayorizar, invConsumosMotivoAnulacion, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvListaProductosTO> getListaProductosTO(
            String empresa,
            String busqueda,
            String bodega,
            String categoria, 
            String fecha,
            boolean incluirInactivos,
            boolean limite) throws Exception {
        return operacionesInventarioBusinessLocal.getListaProductosTO(empresa, busqueda, bodega, categoria, fecha, incluirInactivos, limite);
    }

    public java.util.List<inventario.TO.InvListaClienteTO> getListaClienteTO(
            String empresa,
            String busqueda,
            boolean activo_Cliente) throws Exception {
        return operacionesInventarioBusinessLocal.getListaClienteTO(empresa, busqueda, activo_Cliente);
    }

    public java.util.List<inventario.TO.InvListaProveedoresTO> getListaProveedoresTO(
            String empresa,
            String busqueda,
            boolean activoProveedor) throws Exception {
        return operacionesInventarioBusinessLocal.getListaProveedoresTO(empresa, busqueda, activoProveedor);
    }

    public java.util.List<inventario.TO.InvListaBodegasTO> getListaBodegasTO(
            String empresa,
            boolean inactivo) throws Exception {
        return operacionesInventarioBusinessLocal.getListaBodegasTO(empresa, inactivo);
    }

    public java.util.List<inventario.TO.InvComboBodegaTO> getInvComboBodegaTO(
            java.lang.String empresa) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvComboBodegaTO(empresa);
    }

    public java.util.List<inventario.TO.InvCategoriaProveedorComboTO> getListaCategoriaProveedorComboTO(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getListaCategoriaProveedorComboTO(empresa);
    }

    public java.util.List<inventario.TO.InvCompraMotivoComboTO> getListaCompraMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception {
        return operacionesInventarioBusinessLocal.getListaCompraMotivoComboTO(empresa, filtrarInactivos);
    }

    public java.util.List<inventario.TO.InvVentaMotivoComboTO> getListaVentaMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception {
        return operacionesInventarioBusinessLocal.getListaVentaMotivoComboTO(empresa, filtrarInactivos);
    }

    public java.util.List<inventario.TO.InvProformaMotivoComboTO> getListaProformaMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception {
        return operacionesInventarioBusinessLocal.getListaProformaMotivoComboTO(empresa, filtrarInactivos);
    }

    public java.util.List<inventario.TO.InvCategoriaComboProductoTO> getListaCategoriaComboTO(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getListaCategoriaComboTO(empresa);
    }

    public java.util.List<inventario.TO.InvProductoPresentacionUnidadesComboListadoTO> getListaPresentacionUnidadComboTO(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getListaPresentacionUnidadComboTO(empresa);
    }

    public java.lang.String accionInvProductoPresentacionUnidadesTO(
            inventario.TO.InvProductoPresentacionUnidadesTO invProductoPresentacionUnidadesTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.accionInvProductoPresentacionUnidadesTO(invProductoPresentacionUnidadesTO, accion, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvProductoMarcaComboListadoTO> getInvMarcaComboListadoTO(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getInvMarcaComboListadoTO(empresa);
    }

    public java.lang.String accionInvProductoMarcaTO(
            inventario.TO.InvProductoMarcaTO invProductoMarcaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return this.operacionesInventarioBusinessLocal.accionInvProductoMarcaTO(invProductoMarcaTO, accion, sisInfoTO);
    }

    public java.lang.String accionInvVendedorTO(
            inventario.TO.InvVendedorTO invVendedorTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return this.operacionesInventarioBusinessLocal.accionInvVendedorTO(invVendedorTO, accion, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvProductoPresentacionCajasComboListadoTO> getListaPresentacionCajaComboTO(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getListaPresentacionCajaComboTO(empresa);
    }

    public java.lang.String accionInvProductoPresentacionCajasTO(
            inventario.TO.InvProductoPresentacionCajasTO invProductoPresentacionCajasTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.accionInvProductoPresentacionCajasTO(invProductoPresentacionCajasTO, accion, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvCategoriaClienteComboTO> getListaCategoriaClienteComboTO(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getListaCategoriaClienteComboTO(empresa);
    }

    public java.util.List<inventario.TO.InvBodegaTO> getBodegaTO(
            String empresa,
            String codigo) throws Exception {
        return operacionesInventarioBusinessLocal.getBodegaTO(empresa, codigo);
    }

    public java.util.List<inventario.TO.InvProductoTO> getProductoTO(
            String empresa,
            String codigo) throws Exception {
        return operacionesInventarioBusinessLocal.getProductoTO(empresa, codigo);
    }

    public java.util.List<inventario.TO.InvClienteTO> getClienteTO(
            String empresa,
            String codigo) throws Exception {
        return operacionesInventarioBusinessLocal.getClienteTO(empresa, codigo);
    }

    public java.util.List<inventario.TO.InvProveedorTO> getProveedorTO(
            String empresa,
            String codigo) throws Exception {
        return operacionesInventarioBusinessLocal.getProveedorTO(empresa, codigo);
    }

    public inventario.TO.InvProveedorTO getBuscaCedulaProveedorTO(String empresa, String cedRuc) throws Exception {
        return operacionesInventarioBusinessLocal.getBuscaCedulaProveedorTO(empresa, cedRuc);
    }

    public boolean comprobarInvAplicaRetencionIva(
            String empresa,
            String codigo) throws Exception {
        return operacionesInventarioBusinessLocal.comprobarInvAplicaRetencionIva(empresa, codigo);
    }

    public String getConteoNumeroFacturaCompra(
            String empresaCodigo,
            String provCodigo,
            String compDocumentoTipo,
            String compDocumentoNumero) throws Exception {
        return operacionesInventarioBusinessLocal.getConteoNumeroFacturaCompra(empresaCodigo, provCodigo, compDocumentoTipo, compDocumentoNumero);
    }

    public java.util.List<inventario.TO.InvComboFormaPagoTO> getComboFormaPagoCompra(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getComboFormaPagoCompra(empresa);
    }

    public java.util.List<inventario.TO.InvComboFormaPagoTO> getComboFormaPagoVenta(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getComboFormaPagoVenta(empresa);
    }

    public java.util.List<inventario.TO.InvListaConsultaCompraTO> getFunComprasListado(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String status) throws Exception {
        return operacionesInventarioBusinessLocal.getFunComprasListado(empresa, fechaDesde, fechaHasta, status);
    }

    public java.util.List<inventario.TO.InvListaConsultaCompraTO> getListaInvConsultaCompra(
            String empresa,
            String periodo,
            String motivo,
            String busqueda, String nRegistros) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvConsultaCompra(empresa, periodo, motivo, busqueda, nRegistros);
    }

    public java.util.List<inventario.TO.InvListaConsultaVentaTO> getFunVentasListado(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String status) throws Exception {
        return operacionesInventarioBusinessLocal.getFunVentasListado(empresa, fechaDesde, fechaHasta, status);
    }

    public java.util.List<inventario.TO.InvListaConsultaVentaTO> getListaInvConsultaVenta(
            String empresa,
            String periodo,
            String motivo,
            String busqueda, String nRegistros) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvConsultaVenta(empresa, periodo, motivo, busqueda, nRegistros);
    }

    public java.util.List<inventario.TO.InvListaConsultaProformaTO> getListaInvConsultaProforma(
            String empresa,
            String periodo,
            String motivo,
            String busqueda) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvConsultaProforma(empresa, periodo, motivo, busqueda);
    }

    public java.util.List<inventario.TO.InvListaConsultaConsumosTO> getFunConsumosListado(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String status) throws Exception {
        return operacionesInventarioBusinessLocal.getFunConsumosListado(empresa, fechaDesde, fechaHasta, status);
    }

    public java.util.List<inventario.TO.InvListaConsultaConsumosTO> getListaInvConsultaConsumos(
            String empresa,
            String periodo,
            String motivo,
            String busqueda, String nRegistros) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvConsultaConsumos(empresa, periodo, motivo, busqueda, nRegistros);
    }

    public java.util.List<inventario.TO.InvConsumosImportarExportarTO> getListaInvConsumosImportarExportarTO(
            String empresa,
            String desde,
            String hasta) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvConsumosImportarExportarTO(empresa, desde, hasta);
    }

    public java.util.List<inventario.TO.InvConsumosMotivoComboTO> getListaConsumosMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception {
        return operacionesInventarioBusinessLocal.getListaConsumosMotivoComboTO(empresa, filtrarInactivos);
    }

    public inventario.TO.MensajeTO insertarInvConsumosTO(
            inventario.TO.InvConsumosTO invConsumosTO,
            java.util.List<inventario.TO.InvConsumosDetalleTO> listaInvConsumosDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvConsumosTO(invConsumosTO, listaInvConsumosDetalleTO, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvMedidaComboTO> getListaInvMedidaTablaTO(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvMedidaTablaTO(empresa);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String insertarInvComprasMotivoTO(
            inventario.TO.InvComprasMotivoTO invCompraMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvComprasMotivoTO(invCompraMotivoTO, sisInfoTO);
    }

    public String modificarInvComprasMotivoTO(
            inventario.TO.InvComprasMotivoTO invCompraMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvComprasMotivoTO(invCompraMotivoTO, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvCompraMotivoTablaTO> getListaInvComprasMotivoTablaTO(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvComprasMotivoTablaTO(empresa);
    }

    public inventario.TO.InvComprasMotivoTO getInvComprasMotivoTO(
            String empresa,
            inventario.TO.InvCompraMotivoTablaTO invCompraMotivoTablaTO) throws Exception {
        return operacionesInventarioBusinessLocal.getInvComprasMotivoTO(empresa, invCompraMotivoTablaTO);
    }

    public String insertarInvVentasMotivoTO(
            inventario.TO.InvVentaMotivoTO invVentaMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvVentasMotivoTO(invVentaMotivoTO, sisInfoTO);
    }

    public String modificarInvVentasMotivoTO(
            inventario.TO.InvVentaMotivoTO invVentaMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvVentasMotivoTO(invVentaMotivoTO, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvVentaMotivoTablaTO> getListaInvVentasMotivoTablaTO(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvVentasMotivoTablaTO(empresa);
    }

    public inventario.TO.InvVentaMotivoTO getInvVentasMotivoTO(
            String empresa,
            inventario.TO.InvVentaMotivoTablaTO invVentaMotivoTablaTO) throws Exception {
        return operacionesInventarioBusinessLocal.getInvVentasMotivoTO(empresa, invVentaMotivoTablaTO);
    }

    public String insertarInvProformaMotivoTO(
            inventario.TO.InvProformaMotivoTO invProformaMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvProformaMotivoTO(invProformaMotivoTO, sisInfoTO);
    }

    public String modificarInvProformaMotivoTO(
            inventario.TO.InvProformaMotivoTO invProformaMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvProformaMotivoTO(invProformaMotivoTO, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvProformaMotivoTablaTO> getListaInvProformaMotivoTablaTO(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvProformaMotivoTablaTO(empresa);
    }

    public inventario.TO.InvProformaMotivoTO getInvProformasMotivoTO(
            String empresa,
            inventario.TO.InvProformaMotivoTablaTO invProformaMotivoTablaTO) throws Exception {
        return operacionesInventarioBusinessLocal.getInvProformasMotivoTO(empresa, invProformaMotivoTablaTO);
    }

    public java.util.List<inventario.TO.InvListaConsumosMotivoTO> getInvListaConsumosMotivoTO(
            java.lang.String empresa) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvListaConsumosMotivoTO(empresa);
    }

    public java.lang.String accionInvConsumosMotivo(
            inventario.TO.InvConsumosMotivoTO invConsumosMotivoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.accionInvConsumosMotivo(invConsumosMotivoTO, accion, sisInfoTO);
    }

    public inventario.TO.InvConsumosMotivoTO getInvConsumoMotivoTO(
            String empresa,
            inventario.TO.InvListaConsumosMotivoTO invListaConsumosMotivoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvConsumoMotivoTO(empresa, invListaConsumosMotivoTO);
    }

    public java.util.List<inventario.TO.InvNumeracionCompraTO> getListaInvNumeracionCompraTO(
            String empresa,
            String periodo,
            String motivo) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvNumeracionCompraTO(empresa, periodo, motivo);
    }

    public java.util.List<inventario.TO.InvNumeracionVentaTO> getListaInvNumeracionVentaTO(
            String empresa,
            String periodo,
            String motivo) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvNumeracionVentaTO(empresa, periodo, motivo);
    }

    public java.util.List<inventario.TO.InvNumeracionConsumoTO> getListaInvNumeracionConsumoTO(
            String empresa,
            String periodo,
            String motivo) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvNumeracionConsumoTO(empresa, periodo, motivo);
    }

    // <editor-fold defaultstate="collapsed" desc="COMPRASFORMAPAGO">
    public java.util.List<inventario.TO.InvListaComprasFormaPagoTO> getInvListaComprasFormaPagoTO(
            java.lang.String empresa) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvListaComprasFormaPagoTO(empresa);
    }

    public java.lang.String accionInvComprasPagosForma(
            inventario.TO.InvComprasFormaPagoTO invComprasFormaPagoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.accionInvComprasPagosForma(invComprasFormaPagoTO, accion, sisInfoTO);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VENTASFORMAPAGO">
    public java.util.List<inventario.TO.InvListaVentasFormaPagoTO> getInvListaVentasFormaPagoTO(
            java.lang.String empresa) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvListaVentasFormaPagoTO(empresa);
    }

    public java.lang.String accionInvVentasPagosForma(
            inventario.TO.InvVentasFormaPagoTO invVentasFormaPagoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.accionInvVentasPagosForma(invVentasFormaPagoTO, accion, sisInfoTO);
    }// </editor-fold>

    public inventario.entity.InvProductoSaldos getInvProductoSaldo(
            String empresa,
            String codigoBodega,
            String codigoProducto) throws Exception {
        return operacionesInventarioBusinessLocal.getInvProductoSaldo(empresa, codigoBodega, codigoProducto);
    }

    public java.util.List<inventario.TO.InvKardexTO> getListaInvKardexTO(
            java.lang.String empresa,
            java.lang.String bodega,
            java.lang.String producto,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String promedio) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getListaInvKardexTO(empresa, bodega, producto, desde, hasta, promedio);
    }

    public java.util.List<inventario.TO.SaldoBodegaTO> getListaSaldoBodegaTO(
            java.lang.String empresa,
            java.lang.String bodega,
            java.lang.String hasta) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getListaSaldoBodegaTO(empresa, bodega, hasta);
    }

    public inventario.TO.InvComprasRecepcionTO getInvComprasRecepcionTO(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception {
        return operacionesInventarioBusinessLocal.getInvComprasRecepcionTO(empresa, periodo, motivo, numero);
    }

    public String insertarModificarComprasRecepcionTO(
            inventario.TO.InvComprasRecepcionTO invComprasRecepcionTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarModificarComprasRecepcionTO(invComprasRecepcionTO, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvProductosConErrorTO> getListadoProductosConError(
            String empresa) throws Exception {
        return operacionesInventarioBusinessLocal.getListadoProductosConError(empresa);
    }

    public Boolean getPrecioFijoCategoriaProducto(
            String empresa,
            String codigoCategoria) throws Exception {
        return operacionesInventarioBusinessLocal.getPrecioFijoCategoriaProducto(empresa, codigoCategoria);
    }

    public inventario.TO.MensajeTO insertarInvTransferenciaTO(
            inventario.TO.InvTransferenciasTO invTransferenciasTO,
            java.util.List<inventario.TO.InvTransferenciasDetalleTO> listaInvTransferenciasDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.insertarInvTransferenciaTO(invTransferenciasTO, listaInvTransferenciasDetalleTO, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvListaTransferenciaMotivoTO> getInvListaTransferenciaMotivoTO(
            java.lang.String empresa) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvListaTransferenciaMotivoTO(empresa);
    }

    public inventario.TO.InvTransferenciaMotivoTO getInvTransferenciaMotivoTO(
            String empresa,
            inventario.TO.InvListaTransferenciaMotivoTO invListaTransferenciaMotivoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvTransferenciaMotivoTO(empresa, invListaTransferenciaMotivoTO);
    }

    public java.lang.String accionInvTransferenciaMotivo(
            inventario.TO.InvTransferenciaMotivoTO invTransferenciaMotivoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.accionInvTransferenciaMotivo(invTransferenciaMotivoTO, accion, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvTransferenciaMotivoComboTO> getListaTransferenciaMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception {
        return operacionesInventarioBusinessLocal.getListaTransferenciaMotivoComboTO(empresa, filtrarInactivos);
    }

    public java.util.List<inventario.TO.InvListaDetalleTransferenciaTO> getListaInvTransferenciasDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroTransferencia) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvTransferenciasDetalleTO(empresa, periodo, motivo, numeroTransferencia);
    }

    public inventario.TO.InvTransferenciasTO getInvTransferenciasCabeceraTO(
            String empresa,
            String codigoPeriodo,
            String motivo,
            String numeroTransferencia) throws Exception {
        return operacionesInventarioBusinessLocal.getInvTransferenciasCabeceraTO(empresa, codigoPeriodo, motivo, numeroTransferencia);
    }

    public inventario.TO.MensajeTO modificarInvTransferenciasTO(
            inventario.TO.InvTransferenciasTO invTransferenciasTO,
            java.util.List<inventario.TO.InvTransferenciasDetalleTO> listaInvTransferenciasDetalleTO,
            java.util.List<inventario.TO.InvTransferenciasDetalleTO> listaInvTransferenciasEliminarDetalleTO,
            boolean desmayorizar,
            inventario.entity.InvTransferenciasMotivoAnulacion invTransferenciasMotivoAnulacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.modificarInvTransferenciasTO(invTransferenciasTO, listaInvTransferenciasDetalleTO, listaInvTransferenciasEliminarDetalleTO, desmayorizar, invTransferenciasMotivoAnulacion, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvListaConsultaTransferenciaTO> getFunListadoTransferencias(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String status) throws Exception {
        return operacionesInventarioBusinessLocal.getFunListadoTransferencias(empresa, fechaDesde, fechaHasta, status);
    }

    public java.util.List<inventario.TO.InvListaConsultaTransferenciaTO> getListaInvConsultaTransferencias(
            String empresa,
            String periodo,
            String motivo,
            String busqueda, String nRegistros) throws Exception {
        return operacionesInventarioBusinessLocal.getListaInvConsultaTransferencias(empresa, periodo, motivo, busqueda, nRegistros);
    }

    public java.util.List<inventario.TO.InvListaProductosCambiarPrecioTO> getListaProductosCambiarPrecioTO(
            String empresa,
            String busqueda,
            String bodega,
            String fecha) throws Exception {
        return operacionesInventarioBusinessLocal.getListaProductosCambiarPrecioTO(empresa, busqueda, bodega, fecha);
    }

    public java.util.List<inventario.TO.InvListaProductosCambiarPrecioCantidadTO> getListaProductosCambiarPrecioCantidadTO(
            String empresa,
            String busqueda,
            String bodega,
            String fecha) throws Exception {
        return operacionesInventarioBusinessLocal.getListaProductosCambiarPrecioCantidadTO(empresa, busqueda, bodega, fecha);
    }

    public inventario.TO.MensajeTO invCambiarPrecioProducto(
            String empresa,
            String usuario,
            java.util.List<inventario.TO.InvListaProductosCambiarPrecioTO> invListaProductosCambiarPrecioTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.invCambiarPrecioProducto(empresa, usuario, invListaProductosCambiarPrecioTOs, sisInfoTO);
    }

    public inventario.TO.MensajeTO invCambiarPrecioCantidadProducto(
            String empresa,
            String usuario,
            java.util.List<inventario.TO.InvListaProductosCambiarPrecioCantidadTO> invListaProductosCambiarPrecioCantidadTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.invCambiarPrecioCantidadProducto(empresa, usuario, invListaProductosCambiarPrecioCantidadTOs, sisInfoTO);
    }

    public inventario.TO.InvEstadoCCCVT getEstadoCCCVT(
            String empresa,
            String periodo,
            String motivo,
            String numero,
            String proceso) throws Exception {
        return operacionesInventarioBusinessLocal.getEstadoCCCVT(empresa, periodo, motivo, numero, proceso);
    }

    public java.util.List<inventario.TO.InvSincronizarTO> invProductoSincronizar(
            java.lang.String empresaOrigen,
            java.lang.String empresaDestino,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.invProductoSincronizar(empresaOrigen, empresaDestino, usuario, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvListadoPagosTO> invListadoPagosTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String motivo,
            java.lang.String numero) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.invListadoPagosTO(empresa, periodo, motivo, numero);
    }

    public java.util.List<inventario.TO.InvListadoCobrosTO> invListadoCobrosTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String motivo,
            java.lang.String numero) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.invListadoCobrosTO(empresa, periodo, motivo, numero);
    }

    public java.util.List<inventario.TO.InvFunComprasTO> getInvFunComprasTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String motivo,
            java.lang.String proveedor,
            java.lang.String documento) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunComprasTO(empresa, desde, hasta, motivo, proveedor, documento);
    }

    public java.util.List<inventario.TO.InvFunVentasTO> getInvFunVentasTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String motivo,
            java.lang.String cliente,
            java.lang.String documento) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunVentasTO(empresa, desde, hasta, motivo, cliente, documento);
    }

    public java.util.List<inventario.TO.InvFunComprasConsolidandoProductosTO> getInvFunComprasConsolidandoProductosTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String sector,
            java.lang.String motivo,
            java.lang.String proveedor) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunComprasConsolidandoProductosTO(empresa, desde, hasta, sector, motivo, proveedor);
    }

    public java.util.List<inventario.TO.InvFunVentasConsolidandoProductosTO> getInvFunVentasConsolidandoProductosTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String sector,
            java.lang.String motivo,
            java.lang.String cliente) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunVentasConsolidandoProductosTO(empresa, desde, hasta, sector, motivo, cliente);
    }

    public java.util.List<inventario.TO.InvFunVentasVsCostoTO> getInvFunVentasVsCostoTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String bodega,
            java.lang.String cliente) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunVentasVsCostoTO(empresa, desde, hasta, bodega, cliente);
    }

    public java.util.List<inventario.TO.InvFunListadoProductosTO> getInvFunListadoProductosTO(
            java.lang.String empresa,
            java.lang.String categoria,
            java.lang.String busqueda) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunListadoProductosTO(empresa, categoria, busqueda);
    }

    public java.util.List<inventario.TO.InvFunListadoClientesTO> getInvFunListadoClientesTO(
            java.lang.String empresa,
            java.lang.String categoria) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunListadoClientesTO(empresa, categoria);
    }

    public java.util.List<inventario.TO.InvFunListadoProveedoresTO> getInvFunListadoProveedoresTO(
            java.lang.String empresa,
            java.lang.String categoria) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunListadoProveedoresTO(empresa, categoria);
    }

    public Boolean getPuedeEliminarProducto(
            String empresa,
            String producto) throws Exception {
        return operacionesInventarioBusinessLocal.getPuedeEliminarProducto(empresa, producto);
    }

    public java.math.BigDecimal getPrecioProductoPorCantidad(
            String empresa,
            String codProducto,
            java.math.BigDecimal cantidad) throws Exception {
        return operacionesInventarioBusinessLocal.getPrecioProductoPorCantidad(empresa, codProducto, cantidad);
    }

    public java.math.BigDecimal getCantidad3(
            String empresa,
            String codProducto) throws Exception {
        return operacionesInventarioBusinessLocal.getCantidad3(empresa, codProducto);
    }

    public java.util.List<inventario.TO.InvSecuenciaComprobanteTO> getInvSecuenciaComprobanteTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvSecuenciaComprobanteTO(empresa, fechaDesde, fechaHasta);
    }

    public java.util.List<inventario.TO.InvProductoTipoComboTO> getInvProductoTipoComboListadoTO(java.lang.String empresa,
            String accion) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvProductoTipoComboListadoTO(empresa, accion);
    }

    public java.lang.String accionInvProductoTipo(
            inventario.TO.InvProductoTipoTO invProductoTipoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return this.operacionesInventarioBusinessLocal.accionInvProductoTipo(invProductoTipoTO, accion, sisInfoTO);
    }

    @Override
    public Boolean buscarConteoCliente(
            String empCodigo,
            String codigoCliente) throws Exception {
        return operacionesInventarioBusinessLocal.buscarConteoCliente(empCodigo, codigoCliente);
    }

    @Override
    public Boolean buscarConteoProveedor(
            String empCodigo,
            String codigoProveedor) throws Exception {
        return operacionesInventarioBusinessLocal.buscarConteoProveedor(empCodigo, codigoProveedor);
    }

    @Override
    public java.util.List<inventario.TO.SaldoBodegaComprobacionTO> getInvFunSaldoBodegaComprobacionTO(
            java.lang.String empresa,
            java.lang.String bodega,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunSaldoBodegaComprobacionTO(empresa, bodega, desde, hasta);
    }

    public java.util.List<inventario.TO.InvFunConsumosTO> getInvFunConsumosTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String motivo) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunConsumosTO(empresa, desde, hasta, motivo);
    }

    public java.util.List<inventario.TO.InvFunConsumosConsolidandoProductosTO> getInvFunConsumosConsolidandoProductosTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String sector,
            java.lang.String bodega) throws java.lang.Exception {
        return operacionesInventarioBusinessLocal.getInvFunConsumosConsolidandoProductosTO(empresa, desde, hasta, sector, bodega);
    }

    public List<SaldoBodegaComprobacionTO> getInvFunSaldoBodegaComprobacionCantidadesTO(
            String empresa,
            String bodega,
            String desde, String hasta) throws Exception {
        return operacionesInventarioBusinessLocal.getInvFunSaldoBodegaComprobacionCantidadesTO(empresa, bodega, desde, hasta);
    }

    public Boolean reconstruirCostos(
            String empCodigo,
            String Producto,
            String periodoHasta,
            Boolean periodoEstado) throws Exception {
        return operacionesInventarioBusinessLocal.reconstruirCostos(empCodigo, Producto, periodoHasta, periodoEstado);
    }

    public java.util.List<inventario.TO.InvVendedorComboListadoTO> getComboinvListaVendedorTOs(
            String codigoEmpresa) throws Exception {
        return operacionesInventarioBusinessLocal.getComboinvListaVendedorTOs(codigoEmpresa);
    }

    public java.util.List<inventario.TO.InvFunListaProductosImpresionPlacasTO> getInvFunListaProductosImpresionPlacasTO(
            String empresa,
            String producto,
            boolean estado) throws Exception {
        return operacionesInventarioBusinessLocal.getInvFunListaProductosImpresionPlacasTO(empresa, producto, estado);
    }

    public helper.RetornoTO getInvFunListaProductosSaldosGeneralTO(
            String empresa,
            String producto,
            String fecha,
            boolean estado, String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesInventarioBusinessLocal.getInvFunListaProductosSaldosGeneralTO(empresa, producto, fecha, estado, usuario, sisInfoTO);
    }

    public java.util.List<inventario.TO.InvFunUltimasComprasTO> getInvFunUltimasComprasTOs(
            java.lang.String empresa,
            java.lang.String producto) throws Exception {
        return operacionesInventarioBusinessLocal.getInvFunUltimasComprasTOs(empresa, producto);
    }

    public inventario.TO.InvVentaRetencionesTO getInvVentaRetencionesTO(
            String codigoEmpresa,
            String facturaNumero) throws Exception {
        return operacionesInventarioBusinessLocal.getInvVentaRetencionesTO(codigoEmpresa, facturaNumero);
    }

    public inventario.TO.InvComprasTO getComprasTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return operacionesInventarioBusinessLocal.getComprasTO(empresa, periodo, motivo, numeroCompra);
    }
    
    public Object[] getCompra(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception {
        return operacionesInventarioBusinessLocal.getCompra(empresa, perCodigo, motCodigo, compNumero);
    }
    
    public Object[] getVenta(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception {
        return operacionesInventarioBusinessLocal.getVenta(empresa, perCodigo, motCodigo, compNumero);
    }

    public java.util.List<inventario.TO.InvListaProductosCompraSustentoConceptoTO> getInvProductoSustentoConcepto(String empresa, java.util.List<inventario.TO.InvListaProductosCompraSustentoConceptoTO> invListaProductosCompraTOs) throws Exception {
        return operacionesInventarioBusinessLocal.getInvProductoSustentoConcepto(
                empresa,
                invListaProductosCompraTOs);
    }

     // <editor-fold defaultstate="collapsed" desc="REPORTES INVENTARIO">
      
    public JasperPrint generarReporteInvKardex(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String nombreProducto, String fechaDesde,
            String fechaHasta, List<InvKardexTO> listInvKardexTO, boolean banderaCosto) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteInvKardex(sisUsuarioEmpresaTO, nombreProducto, fechaDesde, fechaHasta, listInvKardexTO, banderaCosto);
    }

    public JasperPrint generarReporteImpresionPlaca(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, LinkedList listProductosImpresionPlaca) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteImpresionPlaca(sisUsuarioEmpresaTO, listProductosImpresionPlaca);
    }

    public JasperPrint generarReporteListadoCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String motivo, String proveedorId, String documento,
            List<InvFunComprasTO> listInvFunComprasTO) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteListadoCompras(sisUsuarioEmpresaTO, fechaDesde,
                fechaHasta, motivo, proveedorId, documento, listInvFunComprasTO);
    }

    public JasperPrint generarReporteConsolidadoCompraProducto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String bodega, String proveedor, List<InvFunComprasConsolidandoProductosTO> listInvFunComprasConsolidandoProductosTO) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteConsolidadoCompraProducto(sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                bodega, proveedor, listInvFunComprasConsolidandoProductosTO);
    }

    public JasperPrint generarReporteListadoVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String motivo, String cliente, String documento,
            List<InvFunVentasTO> listInvFunVentasTO) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteListadoVentas(sisUsuarioEmpresaTO, fechaDesde,
                fechaHasta, motivo, cliente, documento, listInvFunVentasTO);
    }

    public JasperPrint generarReporteConsolidadoVentaProducto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String bodega, String cliente, List<InvFunVentasConsolidandoProductosTO> listInvFunVentasConsolidandoProductosTO) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteConsolidadoVentaProducto(sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                bodega, cliente, listInvFunVentasConsolidandoProductosTO);
    }

    public JasperPrint generarReporteListadoConsumos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta, List<InvFunConsumosTO> listInvFunConsumosTO) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteListadoConsumos(sisUsuarioEmpresaTO, fechaDesde, fechaHasta, listInvFunConsumosTO);
    }

    public JasperPrint generarReporteListaProductos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega,
            List<InvListaProductosTO> listInvListaProductosTO) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteListaProductos(sisUsuarioEmpresaTO, bodega, listInvListaProductosTO);
    }

    public JasperPrint generarReporteSaldoBodega(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega, String fechaHasta,
            List<SaldoBodegaTO> listSaldoBodegaTO) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteSaldoBodega(sisUsuarioEmpresaTO, bodega, fechaHasta, listSaldoBodegaTO);
    }

    public JasperPrint generarReporteSaldoBodegaComprobacion(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega,
            String fechaDesde, String fechaHasta,
            List<SaldoBodegaComprobacionTO> lista) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteSaldoBodegaComprobacion(
                sisUsuarioEmpresaTO, bodega, fechaDesde, fechaHasta, lista);
    }

    public JasperPrint generarReporteInvProductosConError(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<InvProductosConErrorTO> listInvProductosConErrorTO) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteInvProductosConError(sisUsuarioEmpresaTO, listInvProductosConErrorTO);
    }

    public JasperPrint generarReporteTrasferencias(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteTransferenciaDetalle> listReporteTransferenciaDetalle) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteTrasferencias(sisUsuarioEmpresaTO, listReporteTransferenciaDetalle);
    }
    
    
    public JasperPrint generarReporteConsumoDetalle(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            boolean ordenado,
            List<ReporteConsumoDetalle> reporteConsumoDetalles) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteConsumoDetalle(
                sisUsuarioEmpresaTO,ordenado, reporteConsumoDetalles);
    }

    public JasperPrint generarReporteCompraDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteCompraDetalle> reporteCompraDetalles) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteCompraDetalle(
                sisUsuarioEmpresaTO, reporteCompraDetalles);
    }

    public JasperPrint generarReporteVentaDetalleImpresion(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteVentaDetalle> lista, String nombreCliente, String nombreReporte) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteVentaDetalleImpresion(
                sisUsuarioEmpresaTO, lista, nombreCliente, nombreReporte);
    }
    public JasperPrint generarReporteProformaDetalleImpresion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<ReporteProformaDetalle> lista, String nombreReporte)throws Exception{
        return operacionesInventarioBusinessLocal.generarReporteProformaDetalleImpresion(sisUsuarioEmpresaTO, lista, nombreReporte);
        
    }

    public JasperPrint generarReporteInvFunVentasVsCosto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String bodega, String clienteId,
            List<InvFunVentasVsCostoTO> invFunVentasVsCostoTO) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteInvFunVentasVsCosto(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                bodega, clienteId, invFunVentasVsCostoTO);
    }

    public JasperPrint generarReporteCompraDetalleImprimir(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteCompraDetalle> reporteCompraDetalles,
            String cmFormaImprimir) throws Exception {
        return operacionesInventarioBusinessLocal.generarReporteCompraDetalleImprimir(
                sisUsuarioEmpresaTO, reporteCompraDetalles, cmFormaImprimir);
    }
    // </editor-fold>
}
