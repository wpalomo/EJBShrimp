/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.DAO;

import inventario.TO.*;
import inventario.entity.InvProformasMotivo;
import inventario.helper.ConversionesInventario;
import java.util.List;
import javax.ejb.Stateless;
import produccion.TO.PrdConsumosPorPiscinaPeriodoTO;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesInventarioDAO implements OperacionesInventarioDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @javax.ejb.EJB
    inventario.entity.DAO.InvProductoFacadeLocal invProductoFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvClienteCategoriaFacadeLocal invClienteCategoriaFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProveedorCategoriaFacadeLocal invProveedorCategoriaFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProductoCategoriaFacadeLocal invProductoCategoriaFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvClienteFacadeLocal invClienteFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProveedorFacadeLocal invProveedorFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvBodegaFacadeLocal invBodegaFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvComprasFacadeLocal invComprasFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvVentasFacadeLocal invVentasFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProformasFacadeLocal invProformasFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProductoSaldosFacadeLocal invProductoSaldosFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvComprasMotivoFacadeLocal invComprasMotivoFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvVentasMotivoFacadeLocal invVentasMotivoFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProformasMotivoFacadeLocal invProformasMotivoFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvConsumosFacadeLocal invConsumosFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvConsumosMotivoFacadeLocal invConsumosMotivoFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProductoMedidaFacadeLocal invProductoMedidaFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProductoPresentacionUnidadesFacadeLocal invProductoPresentacionUnidadesFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProductoPresentacionCajasFacadeLocal invProductoPresentacionCajasFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProductoMarcaFacadeLocal invProductoMarcaFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvComprasFormaPagoFacadeLocal invComprasFormaPagoFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvVentasFormaPagoFacadeLocal invVentasFormaPagoFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvTransferenciasMotivoFacadeLocal invTransferenciasMotivoFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvTransferenciasFacadeLocal invTransferenciasFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvNumeracionVariosFacadeLocal invNumeracionVariosFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvProductoTipoFacadeLocal invProductoTipoFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvComprasMotivoAnulacionFacadeLocal invComprasMotivoAnulacionFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvVentasMotivoAnulacionFacadeLocal invVentasMotivoAnulacionFacadeLocal;
    @javax.ejb.EJB
    inventario.entity.DAO.InvVendedorFacadeLocal invVendedorFacadeLocal;
    @javax.persistence.PersistenceContext(unitName = "EJBShrimpPU")
    javax.persistence.EntityManager em;

    // <editor-fold defaultstate="collapsed" desc="PROVEEDOR CATEGORIA">
    public inventario.entity.InvProveedorCategoria buscarInvProveedorCategoria(String empresa, String codigo) throws Exception {
        return invProveedorCategoriaFacadeLocal.find(new inventario.entity.InvProveedorCategoriaPK(empresa, codigo));
    }

    public boolean comprobarInvProveedorCategoria(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 "
                + "FROM inventario.inv_proveedor_categoria "
                + "WHERE (pc_empresa = '" + empresa + "' AND pc_codigo = '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public boolean comprobarEliminarInvProveedorCategoria(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT inventario.fun_sw_proveedor_categoria_eliminar("
                + "'" + empresa + "', '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public java.util.List<inventario.TO.InvProveedorCategoriaTO> getInvProveedorCategoriaTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvProveedorCategoria_InvProveedorCategoriaTO(
                em.createNativeQuery("SELECT pc_codigo, pc_detalle, pc_aplica_retencion_iva "
                + "FROM inventario.inv_proveedor_categoria "
                + "WHERE (pc_empresa = '" + empresa + "') ORDER BY pc_codigo").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CLIENTE CATEGORIA">
    public inventario.entity.InvClienteCategoria buscarInvClienteCategoria(String empresa, String codigo) throws Exception {
        return invClienteCategoriaFacadeLocal.find(new inventario.entity.InvClienteCategoriaPK(empresa, codigo));
    }

    public boolean comprobarInvClienteCategoria(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 "
                + "FROM inventario.inv_cliente_categoria "
                + "WHERE (cc_empresa = '" + empresa + "' AND cc_codigo = '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public boolean comprobarEliminarInvClienteCategoria(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT inventario.fun_sw_cliente_categoria_eliminar("
                + "'" + empresa + "', '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public java.util.List<inventario.TO.InvClienteCategoriaTO> getInvClienteCategoriaTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvClienteCategoria_InvClienteCategoriaTO(
                em.createNativeQuery("SELECT cc_codigo, cc_detalle, cc_nivel "
                + "FROM inventario.inv_cliente_categoria "
                + "WHERE (cc_empresa = '" + empresa + "') ORDER BY cc_codigo;").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PRODUCTO CATEGORIA">
    public inventario.entity.InvProductoCategoria buscarInvProductoCategoria(String empresa, String codigo) throws Exception {
        inventario.entity.InvProductoCategoria invProductoCategoria = invProductoCategoriaFacadeLocal.find(new inventario.entity.InvProductoCategoriaPK(empresa, codigo));
        return invProductoCategoria != null ? inventario.helper.ConversionesInventario.convertirInvProductoCategoria_InvProductoCategoria(invProductoCategoria) : null;
    }

    public boolean comprobarInvProductoCategoria(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 "
                + "FROM inventario.inv_producto_categoria "
                + "WHERE (cat_empresa = '" + empresa + "' AND cat_codigo = '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public boolean comprobarEliminarInvProductoCategoria(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT inventario.fun_sw_producto_categoria_eliminar("
                + "'" + empresa + "', '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public java.util.List<inventario.TO.InvProductoCategoriaTO> getInvProductoCategoriaTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvProductoCategoria_InvProductoCategoriaTO(
                em.createNativeQuery("SELECT cat_codigo, cat_detalle, cat_precio_fijo, cat_activa, cta_codigo "
                + "FROM inventario.inv_producto_categoria "
                + "WHERE (usr_empresa = '" + empresa + "') ORDER BY cat_codigo;").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PRODUCTO MEDIDA">
    public inventario.entity.InvProductoMedida buscarInvProductoMedida(String empresa, String codigo) throws Exception {
        return invProductoMedidaFacadeLocal.find(new inventario.entity.InvProductoMedidaPK(empresa, codigo));
    }

    public boolean comprobarInvProductoMedida(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 "
                + "FROM inventario.inv_producto_medida "
                + "WHERE (med_empresa = '" + empresa + "' AND med_codigo = '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public boolean comprobarEliminarInvProductoMedida(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT inventario.fun_sw_producto_medida_eliminar("
                + "'" + empresa + "', '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public java.util.List<inventario.TO.InvProductoMedidaTO> getInvProductoMedidaTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvProductoMedida_InvProductoMedidaTO(
                em.createNativeQuery("SELECT med_codigo, med_detalle, med_conversion_libras, med_conversion_kilos "
                + "FROM inventario.inv_producto_medida "
                + "WHERE (usr_empresa = '" + empresa + "') ORDER BY med_detalle;").getResultList());
    }
    // </editor-fold>

    public inventario.entity.InvTransferenciasMotivo buscarInvTransferenciaMotivo(String empresa, String codigo) throws Exception {
        return invTransferenciasMotivoFacadeLocal.find(new inventario.entity.InvTransferenciasMotivoPK(empresa, codigo));
    }

    public inventario.entity.InvTransferencias buscarInvTransferencias(String empresa, String perCodigo, String transCodigo, String transNumero) throws Exception {
        return invTransferenciasFacadeLocal.find(new inventario.entity.InvTransferenciasPK(empresa, perCodigo, transCodigo, transNumero));
    }

    public Boolean comprobarInvTransferenciasMotivo(String empresa, String transCodigo) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) FROM inventario."
                + "inv_transferencias_motivo WHERE tm_empresa = ('" + empresa + "') AND tm_codigo = ('" + transCodigo + "')").
                getResultList(), 0)[0].toString()) == 0) ? false : true;
    }

    public int buscarConteoUltimaNumeracionTransferencias(String empCodigo, String perCodigo, String motCodigo) throws Exception {
        try {
            return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT num_secuencia FROM "
                    + "inventario.inv_transferencias_numeracion WHERE num_empresa = ('" + empCodigo + "') "
                    + "AND num_periodo = ('" + perCodigo + "') AND num_motivo = ('" + motCodigo + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return 0;
        }
    }
    
    public Object[] getCompra(String empresa, String periodo, String conTipo, String numero){          
            Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("select comp_empresa, comp_periodo, comp_motivo, comp_numero "+ 
            "from inventario.inv_compras where con_empresa='"+empresa+"' AND "+
                "con_periodo='"+periodo+"' AND con_tipo='"+conTipo+"' AND con_numero='"+numero+"';").getResultList(),0);
            if (array != null) {
                return array;
            } 
            return null;
        
    }
    
    public Object[] getVenta(String empresa, String periodo, String conTipo, String numero){
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("select vta_empresa, vta_periodo, vta_motivo, vta_numero "+ 
	"from inventario.inv_ventas where con_empresa='"+empresa+"' AND "+
	     "con_periodo='"+periodo+"' AND con_tipo='"+conTipo+"' AND con_numero='"+numero+"';").getResultList(),0);
            if (array != null) {
                return array;
            } 
            return null;
    }

    public inventario.TO.InvTransferenciasTO getInvTransferenciasCabeceraTO(String empresa, String periodo, String motivo, String numeroConsumo) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvTransferenciasCabecera_InvTransferenciasCabeceraTO(invTransferenciasFacadeLocal.find(new inventario.entity.InvTransferenciasPK(empresa, periodo, motivo, numeroConsumo)));
    }

    public List<InvListaConsultaTransferenciaTO> getFunListadoTransferencias(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception {
        String pendiente = null;
        String anulado = null;
        if (status.equals("PENDIENTE")) {
            pendiente = "'PENDIENTE'";
            anulado = null;
        }
        if (status.equals("ANULADO")) {
            pendiente = null;
            anulado = "'ANULADO'";
        }
        if (status.equals("AMBOS")) {
            pendiente = "'PENDIENTE'";
            anulado = "'ANULADO'";
        }
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesInventario.convertirInvListaConsultaTransferencia_InvListaConsultaTransferenciaTO(em.createNativeQuery("SELECT * FROM inventario.fun_listado_transferencias('" + empresa + "', null, null, null) "
                + "WHERE trans_fecha >= " + fechaDesde + " AND trans_fecha <= " + fechaHasta + " "
                + "AND trans_pendiente = " + pendiente + " OR trans_anulado = " + anulado + ";").getResultList());
    }

    public List<InvListaConsultaTransferenciaTO> getListaInvConsultaTransferencia(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception {
        String limit = "";
        if (nRegistros != null && nRegistros.compareTo("") != 0 && nRegistros.compareTo("0") != 0) {
            limit = " limit " + nRegistros;
        }
        return ConversionesInventario.convertirInvListaConsultaTransferencia_InvListaConsultaTransferenciaTO(em.createNativeQuery("SELECT * FROM inventario.fun_listado_transferencias('" + empresa + "','" + periodo + "','" + motivo + "','" + busqueda + "')" + limit).
                getResultList());
    }

    public java.util.List<inventario.TO.InvTransferenciaMotivoComboTO> getListaTransferenciaMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        if (filtrarInactivos) {
            return inventario.helper.ConversionesInventario.convertirListaTransferenciaMotivoCombo_ListaTransferenciaMotivoComboTO(em.createNativeQuery("SELECT tm_codigo, tm_detalle FROM inventario.inv_transferencias_motivo WHERE tm_empresa = ('" + empresa + "') "
                    + "AND NOT tm_inactivo ORDER BY tm_codigo").getResultList());
        } else {
            return inventario.helper.ConversionesInventario.convertirListaTransferenciaMotivoCombo_ListaTransferenciaMotivoComboTO(em.createNativeQuery("SELECT tm_codigo, tm_detalle FROM inventario.inv_transferencias_motivo WHERE tm_empresa = ('" + empresa + "') "
                    + "ORDER BY tm_codigo").getResultList());
        }
    }

    public java.util.List<inventario.TO.InvListaTransferenciaMotivoTO> getInvListaTransferenciaMotivoTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvListaTransferenciaMotivoTO_InvListaTransferenciaMotivo(em.createNativeQuery("SELECT tm_codigo, tm_detalle, tm_inactivo FROM inventario.inv_transferencias_motivo WHERE (tm_empresa = '" + empresa + "') ORDER BY tm_codigo").getResultList());
    }

    public inventario.TO.InvTransferenciaMotivoTO getInvTransferenciasMotivoTO(String empresa, inventario.TO.InvListaTransferenciaMotivoTO invListaTransferenciaMotivoTO) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvTransferenciaMotivo_InvTransferenciaMotivoTO(invTransferenciasMotivoFacadeLocal.find(new inventario.entity.InvTransferenciasMotivoPK(empresa, invListaTransferenciaMotivoTO.getTmCodigo())));
    }

    public java.util.List<inventario.TO.InvNumeracionTransferenciaTO> getListaInvNumeracionTransferenciaTO(String empresa, String periodo, String motivo) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaInvNumeracionTransferencia_ListaInvNumeracionTransferenciaTO(em.createNativeQuery("SELECT * FROM inventario.inv_transferencias_numeracion "
                + "WHERE (num_empresa = '" + empresa + "') AND CASE WHEN ('" + periodo + "') = '' THEN TRUE ELSE (num_periodo = '" + periodo + "') END "
                + "AND CASE WHEN ('" + motivo + "') = '' THEN TRUE ELSE num_motivo = ('" + motivo + "') END").getResultList());
    }

    public inventario.entity.InvConsumosMotivo buscarInvConsumosMotivo(String empresa, String codigo) throws Exception {
        return invConsumosMotivoFacadeLocal.find(new inventario.entity.InvConsumosMotivoPK(empresa, codigo));
    }

    public inventario.entity.InvProducto buscarInvProducto(String empresa, String codigoProducto) throws Exception {
        inventario.entity.InvProducto invProducto = invProductoFacadeLocal.find(new inventario.entity.InvProductoPK(empresa, codigoProducto));
        
        return invProducto != null ? inventario.helper.ConversionesInventario.convertirInvProducto_InvProducto(invProducto) : null;
    }

    public inventario.entity.InvProductoMedida buscarProductoMedida(String empresa, String codigoProducto) throws Exception {
        return invProductoMedidaFacadeLocal.find(new inventario.entity.InvProductoMedidaPK(empresa, codigoProducto));
    }

    public inventario.entity.InvProductoPresentacionUnidades buscarProductoPresentacionUnidades(String empresa, String codigoPresentacion) throws Exception {
        return invProductoPresentacionUnidadesFacadeLocal.find(new inventario.entity.InvProductoPresentacionUnidadesPK(empresa, codigoPresentacion));
    }

    public inventario.entity.InvProductoPresentacionCajas buscarProductoPresentacionCajas(String empresa, String codigoPresentacion) throws Exception {
        return invProductoPresentacionCajasFacadeLocal.find(new inventario.entity.InvProductoPresentacionCajasPK(empresa, codigoPresentacion));
    }

    public inventario.entity.InvProductoMarca buscarMarcaProducto(String empresa, String codigoMarca) throws Exception {
        return invProductoMarcaFacadeLocal.find(new inventario.entity.InvProductoMarcaPK(empresa, codigoMarca));
    }

    public inventario.entity.InvCliente buscarInvCliente(String empresa, String codigoCliente) throws Exception {
        return invClienteFacadeLocal.find(new inventario.entity.InvClientePK(empresa, codigoCliente));
    }

    public inventario.entity.InvProveedor buscarInvProveedor(String empresa, String codigoProveedor) throws Exception {
        return invProveedorFacadeLocal.find(new inventario.entity.InvProveedorPK(empresa, codigoProveedor));
    }

    public inventario.entity.InvBodega buscarInvBodega(String empresa, String codigoBodega) throws Exception {
        return invBodegaFacadeLocal.find(new inventario.entity.InvBodegaPK(empresa, codigoBodega));
    }

    public inventario.entity.InvCompras buscarInvCompras(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception {
        return invComprasFacadeLocal.find(new inventario.entity.InvComprasPK(empresa, perCodigo, motCodigo, compNumero));
    }

    public inventario.entity.InvVentas buscarInvVentas(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception {
        return invVentasFacadeLocal.find(new inventario.entity.InvVentasPK(empresa, perCodigo, motCodigo, compNumero));
    }

    public inventario.entity.InvProformas buscarInvProformas(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception {
        return invProformasFacadeLocal.find(new inventario.entity.InvProformasPK(empresa, perCodigo, motCodigo, compNumero));
    }

    public inventario.entity.InvConsumos buscarInvConsumos(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception {
        return invConsumosFacadeLocal.find(new inventario.entity.InvConsumosPK(empresa, perCodigo, motCodigo, compNumero));
    }

    public inventario.entity.InvProductoSaldos buscarProductosSaldosStock(String empresa, String bodega, String producto) throws Exception {
        inventario.entity.InvProductoSaldos invProductoSaldos = inventario.helper.ConversionesInventario.convertirInvProductoSaldosConsultaStock_InvProductoSaldosStock(em.createNativeQuery("SELECT stk_saldo FROM inventario.inv_producto_saldos where stk_empresa = '"
                + empresa + "' AND stk_bodega = '" + bodega + "' AND stk_producto = '" + producto + "'").getResultList());        
        return invProductoSaldos;
    }

    public inventario.entity.InvProductoSaldos buscarProductosSaldos(String empresa, String bodega, String producto) throws Exception {
        return invProductoSaldosFacadeLocal.find(new inventario.entity.InvProductoSaldosPK(empresa, bodega, producto));
    }

    public inventario.entity.InvConsumos buscarConsumos(String empresa, String perCodigo, String motCodigo, String consNumero) throws Exception {
        return invConsumosFacadeLocal.find(new inventario.entity.InvConsumosPK(empresa, perCodigo, motCodigo, consNumero));
    }

    public inventario.entity.InvComprasFormaPago buscarComprasFormaPago(Integer secuencial) throws Exception {
        return invComprasFormaPagoFacadeLocal.find(secuencial);
    }

    public inventario.entity.InvVentasFormaPago buscarVentasFormaPago(Integer secuencial) throws Exception {
        return invVentasFormaPagoFacadeLocal.find(secuencial);
    }

    public Boolean comprobarInvComprasMotivo(String empresa, String motCodigo) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) "
                + "FROM inventario.inv_compras_motivo WHERE cm_empresa = "
                + "('" + empresa + "') AND cm_codigo = ('" + motCodigo + "')").
                getResultList(), 0)[0].toString()) == 0) ? false : true;
    }

    public Boolean comprobarInvVentasMotivo(String empresa, String motCodigo) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) FROM inventario.inv_ventas_motivo "
                + "WHERE vm_empresa = ('" + empresa + "') AND vm_codigo = ('" + motCodigo + "')").
                getResultList(), 0)[0].toString()) == 0) ? false : true;
    }

    public Boolean comprobarInvProformasMotivo(String empresa, String motCodigo) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) FROM inventario.inv_proformas_motivo "
                + "WHERE pm_empresa = ('" + empresa + "') AND pm_codigo = ('" + motCodigo + "')").
                getResultList(), 0)[0].toString()) == 0) ? false : true;
    }

    public Boolean comprobarInvProformaMotivo(String empresa, String motCodigo) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) FROM inventario.inv_proformas_motivo "
                + "WHERE pm_empresa = ('" + empresa + "') AND pm_codigo = ('" + motCodigo + "')").
                getResultList(), 0)[0].toString()) == 0) ? false : true;
    }

    public Boolean comprobarInvConsumosMotivo(String empresa, String motCodigo) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) "
                + "FROM inventario.inv_consumos_motivo WHERE cm_empresa = "
                + "('" + empresa + "') AND cm_codigo = ('" + motCodigo + "')").
                getResultList(), 0)[0].toString()) == 0) ? false : true;
    }

    public Boolean buscarExisteNombreProducto(String empresa, String nombreProducto) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) FROM inventario.inv_producto "
                + "WHERE pro_nombre = ('" + nombreProducto + "') AND pro_empresa = ('" + empresa + "')").
                getResultList(), 0)[0].toString()) == 0) ? true : false;
    }

    public String getConteoNumeroFacturaCompra(String empresaCodigo, String provCodigo, String compDocumentoTipo, String compDocumentoNumero) throws Exception {
        String retorno = "";
        String empresa = "";
        String periodo = "";
        String motivo = "";
        String numero = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT comp_empresa, comp_periodo, "
                + "comp_motivo, comp_numero FROM inventario.inv_compras WHERE comp_empresa = ('" + empresaCodigo + "') "
                + "AND prov_codigo = ('" + provCodigo + "') AND comp_documento_tipo = ('" + compDocumentoTipo + "') "
                + "AND comp_documento_numero = ('" + compDocumentoNumero + "');").getResultList(), 0);

        if (array != null) {
            empresa = array[0].toString().trim();
            periodo = array[1].toString().trim();
            motivo = array[2].toString().trim();
            numero = array[3].toString().trim();
            retorno = empresa + periodo + motivo + numero;
        } else {
            retorno = "";
        }

        return retorno;
//        return Integer.parseInt(((java.util.List) em.createNativeQuery("SELECT comp_empresa, comp_periodo, "
//                + "comp_motivo, comp_numero FROM inventario.inv_compras WHERE comp_empresa = ('" + empresaCodigo + "') "
//                + "AND prov_codigo = ('" + provCodigo + "') AND comp_documento_tipo = ('" + compDocumentoTipo + "') "
//                + "AND comp_documento_numero = ('" + compDocumentoNumero + "');").getResultList().get(0)).get(0).toString());
    }

    public String getConteoNumeroFacturaVenta(String empresaCodigo, String compDocumentoTipo, String compDocumentoNumero) throws Exception {
        String retorno = "";
        String empresa = "";
        String periodo = "";
        String motivo = "";
        String numero = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT vta_empresa, vta_periodo, vta_motivo, vta_numero "
                + "FROM inventario.inv_ventas WHERE vta_empresa = ('" + empresaCodigo + "') "
                + "AND vta_documento_tipo = ('" + compDocumentoTipo + "') "
                + "AND vta_documento_numero = ('" + compDocumentoNumero + "')").getResultList(), 0);

        if (array != null) {
            empresa = array[0].toString().trim();
            periodo = array[1].toString().trim();
            motivo = array[2].toString().trim();
            numero = array[3].toString().trim();
            retorno = empresa + periodo + motivo + numero;
        } else {
            retorno = "";
        }


        return retorno;
//        return Integer.parseInt(((java.util.List) em.createNativeQuery("SELECT comp_empresa, comp_periodo, "
//                + "comp_motivo, comp_numero FROM inventario.inv_compras WHERE comp_empresa = ('" + empresaCodigo + "') "
//                + "AND prov_codigo = ('" + provCodigo + "') AND comp_documento_tipo = ('" + compDocumentoTipo + "') "
//                + "AND comp_documento_numero = ('" + compDocumentoNumero + "');").getResultList().get(0)).get(0).toString());
    }

    public String getConteoNotaCreditoVenta(String empresaCodigo, String cliCodigo, String compDocumentoTipo, String compDocumentoNumero) throws Exception {
        String retorno = "";
        String empresa = "";
        String periodo = "";
        String motivo = "";
        String numero = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT vta_empresa, vta_periodo, vta_motivo, vta_numero "
                + "FROM inventario.inv_ventas WHERE vta_empresa = ('" + empresaCodigo + "') "
                + "AND cli_codigo = ('" + cliCodigo + "') AND vta_documento_tipo = ('" + compDocumentoTipo + "') "
                + "AND vta_documento_numero = ('" + compDocumentoNumero + "') AND NOT vta_anulado").getResultList(), 0);

        if (array != null) {
            empresa = array[0].toString().trim();
            periodo = array[1].toString().trim();
            motivo = array[2].toString().trim();
            numero = array[3].toString().trim();
            retorno = empresa + periodo + motivo + numero;
        } else {
            retorno = "";
        }

        return retorno;
    }

    public String getCuentaSectorFormaPagoCompra(String empresa, String detalleFormaPago) throws Exception {
        String retorno = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT sec_codigo, cta_codigo "
                + "FROM inventario.inv_compras_forma_pago "
                + "WHERE sec_empresa = ('" + empresa + "') AND fp_detalle = ('" + detalleFormaPago + "');").getResultList(), 0);

        if (array != null) {
            retorno = array[0].toString().trim() + "|" + array[1].toString().trim();
        } else {
            retorno = "";
        }


        return retorno;
    }

    public String getCuentaSectorFormaPagoVenta(String empresa, String detalleFormaPago) throws Exception {
        String retorno = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT sec_codigo, cta_codigo "
                + "FROM inventario.inv_ventas_forma_pago "
                + "WHERE sec_empresa = ('" + empresa + "') AND fp_detalle = ('" + detalleFormaPago + "');").getResultList(), 0);

        if (array != null) {
            retorno = array[0].toString().trim() + "|" + array[1].toString().trim();
        } else {
            retorno = "";
        }

        return retorno;
    }

//    public int getConteoNumeroFactura(String empresaCodigo, String provCodigo, String compDocumentoTipo, String compDocumentoNumero) throws Exception {
//        return Integer.parseInt(((java.util.List) em.createNativeQuery("SELECT COUNT(*) FROM inventario."
//                + "inv_compras WHERE comp_empresa = ('" + empresaCodigo + "') AND prov_codigo = ('" + provCodigo + "') "
//                + "AND comp_documento_tipo = ('" + compDocumentoTipo + "') AND comp_documento_numero = ('" + compDocumentoNumero + "');").
//                getResultList().get(0)).get(0).toString());
//    }
    public java.util.List<inventario.TO.InvListaProductosTO> getListaProductosTO(String empresa, 
            String busqueda, String bodega,  String categoria, String fecha, boolean incluirInactivos, boolean limite) throws Exception {
        String porcionConsulta = "";
        if (limite) {
            porcionConsulta = " LIMIT 30";
        }
        if(categoria == null){
            categoria = "";
        }
       
//        String sql = "SELECT * FROM inventario.fun_lista_productos_saldos_precios('"+empresa+"', '"+bodega+"', '"
//                +categoria+"', '"+busqueda+"', "+fecha+", "+incluirInactivos+");";
        String sql = "SELECT "
                + "lpsp_codigo_principal, "
                + "lpsp_codigo_barra, "
                + "lpsp_codigo_barra2, "
                + "lpsp_codigo_barra3, "
                + "lpsp_codigo_barra4, "
                + "lpsp_codigo_barra5, "
                + "lpsp_nombre, "
                + "lpsp_categoria, "
                + "lpsp_empaque, "
                + "lpsp_saldo, "
                + "lpsp_costo, "
                + "lpsp_medida, "
                + "lpsp_precio1, "
                + "lpsp_precio2, "
                + "lpsp_precio3, "
                + "lpsp_precio4, "
                + "lpsp_precio5, "
                + "lpsp_precio3 * lpsp_cantidad3 lpsp_precio_caja, "
                + "lpsp_iva "
                + "FROM inventario.fun_lista_productos_saldos_precios('"+empresa+"', '"+bodega+"', '"
                +categoria+"', '"+busqueda+"', "+fecha+", "+incluirInactivos+");";// + porcionConsulta;
        return inventario.helper.ConversionesInventario.convertirListaInvProducto_ListaInvProductoTO(em.createNativeQuery(sql).getResultList());
//        return inventario.helper.ConversionesInventario.convertirListaInvProducto_ListaInvProductoTO(em.
//                createNativeQuery("SELECT inv_producto.pro_codigo_principal, inv_producto.pro_nombre, inv_producto_categoria.cat_detalle, "
//                + "ROUND(CASE WHEN inv_producto_saldos.stk_saldo=0 THEN NULL ELSE inv_producto_saldos.stk_saldo END, 2) as stk_saldo, "
//                + "inv_producto_medida.med_detalle, inv_producto.pro_iva "
//                + "FROM inventario.inv_producto LEFT JOIN inventario.inv_producto_categoria "
//                + "ON inv_producto.pro_empresa = inv_producto_categoria.cat_empresa AND "
//                + "inv_producto.pro_categoria = inv_producto_categoria.cat_codigo "
//                + "INNER JOIN inventario.inv_producto_medida "
//                + "ON inv_producto.med_empresa = inv_producto_medida.med_empresa AND "
//                + "inv_producto.med_codigo = inv_producto_medida.med_codigo "
//                + "LEFT JOIN inventario.inv_producto_saldos "
//                + "ON inv_producto.pro_empresa = inv_producto_saldos.stk_empresa AND ('" + bodega + "') = inv_producto_saldos.stk_bodega AND "
//                + "inv_producto.pro_codigo_principal = inv_producto_saldos.stk_producto WHERE inv_producto.pro_empresa = ('" + empresa + "') AND "
//                + "(inv_producto.pro_codigo_principal || pro_nombre || CASE WHEN cat_detalle IS NULL THEN ('') ELSE (cat_detalle) END "
//                + "LIKE TRANSLATE(' ' || CASE WHEN ('" + busqueda + "') = '' THEN '~' ELSE ('" + busqueda + "') END || ' ', ' ', '%')) ORDER BY pro_nombre").getResultList());






//                createNativeQuery("SELECT inv_producto.pro_codigo_principal, inv_producto.pro_nombre, "
//                + "inv_producto_categoria.cat_detalle, inv_producto.pro_iva FROM inventario.inv_producto LEFT JOIN "
//                + "inventario.inv_producto_categoria ON inv_producto.emp_codigo || inv_producto.pro_categoria = "
//                + "inv_producto_categoria.emp_codigo || inv_producto_categoria.cat_codigo WHERE inv_producto.emp_codigo = "
//                + "('" + empresa + "') AND (pro_codigo_principal || pro_nombre || CASE WHEN cat_detalle IS NULL THEN ('') "
//                + "ELSE (cat_detalle) END LIKE TRANSLATE(' ' || CASE WHEN ('" + busqueda + "') = ''  THEN '~' "
//                + "ELSE ('" + busqueda + "') END || ' ', ' ', '%'))").getResultList());
//        return inventario.helper.ConversionesInventario.convertirListaInvProducto_ListaInvProductoTO(em.
//                createNativeQuery("SELECT inv_producto.pro_codigo_principal, inv_producto.pro_nombre, "
//                + "inv_producto_categoria.cat_detalle FROM inventario.inv_producto "
//                + "INNER JOIN inventario.inv_producto_categoria ON inv_producto.emp_codigo "
//                + "|| inv_producto.pro_categoria = inv_producto_categoria.emp_codigo || "
//                + "inv_producto_categoria.cat_codigo WHERE inv_producto_categoria.emp_codigo = ('" + empresa + "') "
//                + "AND (pro_codigo_principal||pro_nombre||cat_detalle LIKE TRANSLATE(' ' || "
//                + "CASE WHEN ('" + busqueda + "') = ''  THEN '~' ELSE ('" + busqueda + "') END || ' ', ' ', '%'))").getResultList());
    }

    public java.util.List<inventario.TO.InvListaClienteTO> getListaClienteTO(String empresa, String busqueda, boolean incluirClienteInactivo) throws Exception {

        return inventario.helper.ConversionesInventario.convertirListaInvCliente_ListaInvClienteTO(em.createNativeQuery(
                "SELECT "
                + "inv_cliente.cli_codigo, "
                + "inv_cliente.cli_id_numero, "
                + "inv_cliente.cli_nombre, "
                + "inv_cliente.cli_direccion "
                + "FROM inventario.inv_cliente "
                + "WHERE " + (incluirClienteInactivo ? "" : "NOT cli_inactivo "
                + "AND ") + "inv_cliente.cli_empresa = ('" + empresa + "') "
                + "AND (cli_codigo || COALESCE(cli_id_numero,'') || cli_nombre || cli_direccion "
                + "LIKE TRANSLATE(' ' || CASE WHEN ('" + busqueda + "') = ''  THEN '~' ELSE ('" + busqueda + "') END || ' ', ' ', '%')) ORDER BY cli_nombre").getResultList());
    }

    public java.util.List<inventario.TO.InvListaProveedoresTO> getListaProveedoresTO(String empresa, String busqueda, boolean incluirProveedorInactivo) throws Exception {

        return inventario.helper.ConversionesInventario.convertirListaInvProveedores_ListaInvProveedoresTO(em.createNativeQuery(
                "SELECT "
                + "inv_proveedor.prov_codigo, "
                + "inv_proveedor.prov_id_numero, "
                + "inv_proveedor.prov_nombre, "
                + "inv_proveedor_categoria.pc_detalle as prov_categoria "
                + "FROM inventario.inv_proveedor "
                + "LEFT JOIN inventario.inv_proveedor_categoria "
                + "ON inv_proveedor.pc_empresa = inv_proveedor_categoria.pc_empresa "
                + "AND inv_proveedor.pc_codigo = inv_proveedor_categoria.pc_codigo "
                + "WHERE " + (incluirProveedorInactivo ? "" : "NOT prov_inactivo "
                + "AND ") + " inv_proveedor.prov_empresa = ('" + empresa + "') "
                + "AND (prov_codigo || COALESCE(prov_id_numero,'') || prov_nombre || CASE WHEN pc_detalle IS NULL THEN ('') ELSE (pc_detalle) END "
                + "LIKE TRANSLATE(' ' || CASE WHEN ('" + busqueda + "') = ''  THEN '~' ELSE ('" + busqueda + "') END || ' ', ' ', '%')) ORDER BY prov_nombre").getResultList());


    }

    public java.util.List<inventario.TO.InvListaBodegasTO> getListaBodegasTO(String empresa, boolean inacivo) throws Exception {

        if (!inacivo) {
            return inventario.helper.ConversionesInventario.convertirListaInvBodegas_ListaInvBodegasTO(em.createNativeQuery(
                    " SELECT "
                    + "bod_codigo, "
                    + "bod_nombre, "
                    + "sis_usuario.usr_apellido ||' '||sis_usuario.usr_nombre bod_responsable, "
                    + "bod_inactiva, "
                    + "sec_codigo "
                    + "FROM inventario.inv_bodega LEFT JOIN sistemaweb.sis_usuario_detalle "
                    + "INNER JOIN sistemaweb.sis_usuario "
                    + "ON sis_usuario_detalle.usr_codigo = sis_usuario.usr_codigo "
                    + "ON inv_bodega.det_empresa = sis_usuario_detalle.det_empresa  AND "
                    + "sis_usuario_detalle.det_usuario = inv_bodega.det_usuario  "
                    + "WHERE (bod_empresa = '" + empresa + "') AND NOT bod_inactiva ORDER BY bod_codigo ").getResultList());
        } else {
            return inventario.helper.ConversionesInventario.convertirListaInvBodegas_ListaInvBodegasTO(em.createNativeQuery(
                    "SELECT "
                    + "bod_codigo, "
                    + "bod_nombre, "
                    + "sis_usuario.usr_apellido ||' '||sis_usuario.usr_nombre bod_responsable, "
                    + "bod_inactiva, "
                    + "sec_codigo "
                    + "FROM inventario.inv_bodega LEFT JOIN sistemaweb.sis_usuario_detalle "
                    + "INNER JOIN sistemaweb.sis_usuario "
                    + "ON sis_usuario_detalle.usr_codigo = sis_usuario.usr_codigo "
                    + "ON inv_bodega.det_empresa = sis_usuario_detalle.det_empresa  AND "
                    + "sis_usuario_detalle.det_usuario = inv_bodega.det_usuario  "
                    + "WHERE (bod_empresa = '" + empresa + "') ORDER BY bod_codigo").getResultList());
        }
    }

    //public java.util.List<inventario.TO>
    public java.util.List<inventario.TO.InvCategoriaComboProductoTO> getListaCategoriaComboTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaCategoriaCombo_ListaCategoriaComboTO(em.createNativeQuery("SELECT cat_codigo, cat_detalle, cta_codigo FROM inventario.inv_producto_categoria WHERE cat_empresa = ('" + empresa + "') ORDER BY cat_codigo").getResultList());
    }

    public java.util.List<inventario.TO.InvProductoPresentacionUnidadesComboListadoTO> getListaPresentacionUnidadComboTO(String empresa) throws Exception {

        return inventario.helper.ConversionesInventario.convertirListaComboPresentacionUnidad_ListaComboPresentacionUnidadTO(em.createNativeQuery("select presu_codigo, presu_detalle, presu_abreviado from inventario.inv_producto_presentacion_unidades "
                + "where presu_empresa = ('" + empresa + "') ORDER BY presu_codigo").getResultList());
    }

    public java.util.List<inventario.TO.InvProductoMarcaComboListadoTO> getInvMarcaComboListadoTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaComboMarca_ListaComboMarcaTO(em.createNativeQuery("select mar_codigo,mar_detalle,mar_abreviado from inventario.inv_producto_marca "
                + "where mar_empresa = ('" + empresa + "') ORDER BY mar_codigo").getResultList());
    }

    public java.util.List<inventario.TO.InvProductoPresentacionCajasComboListadoTO> getListaPresentacionCajaComboTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaComboPresentacionCaja_ListaComboPresentacionCajaTO(em.createNativeQuery("select presc_codigo, presc_detalle, presc_abreviado from inventario.inv_producto_presentacion_cajas where presc_empresa= ('" + empresa + "') ORDER BY presc_codigo").getResultList());
    }

    public java.util.List<inventario.TO.InvCategoriaProveedorComboTO> getListaCategoriaProveedorComboTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaCategoriaProveedorCombo_ListaCategoriaProveedorComboTO(em.createNativeQuery("SELECT pc_codigo, pc_detalle FROM inventario.inv_proveedor_categoria WHERE (pc_empresa = '" + empresa + "') ORDER BY pc_codigo").getResultList());
    }

    public java.util.List<inventario.TO.InvCategoriaClienteComboTO> getListaCategoriaClienteComboTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaCategoriaClienteCombo_ListaCategoriaClienteComboTO(em.createNativeQuery("SELECT cc_codigo, cc_detalle FROM inventario.inv_cliente_categoria WHERE (cc_empresa = '" + empresa + "') ORDER BY cc_codigo").getResultList());
    }

    public java.util.List<inventario.TO.InvBodegaTO> getBodegaTO(String empresa, String codigo) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaBodega_ListaCategoriaBodegaTO(em.createNativeQuery("SELECT "
                + "bod_codigo, "
                + "bod_nombre, "
                + "sec_codigo "
                + "FROM inventario.inv_bodega "
                + "WHERE bod_empresa = ('" + empresa + "') AND "
                + "bod_codigo = ('" + codigo + "') AND "
                + "bod_inactiva = FALSE AND "
                + "bod_anulada = FALSE").getResultList());
    }

    public java.util.List<inventario.TO.InvProductoTO> getProductoTO(String empresa, String codigo) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaProducto_ListaProductoTO(em.createNativeQuery(
                "SELECT "
                + "inv_producto.pro_empresa, "
                + "inv_producto.pro_codigo_principal, "
                + "pro_codigo_alterno, "
                + "pro_codigo_barra,"
                + "pro_codigo_barra2,"
                + "pro_codigo_barra3,"
                + "pro_codigo_barra4,"
                + "pro_codigo_barra5, "
                + "pro_empaque, "
                + "pro_nombre, "
                + "pro_detalle, "
                + "pro_cantidad1, "
                + "pro_cantidad2, "
                + "pro_cantidad3, "
                + "pro_cantidad4, "
                + "pro_cantidad5, "
                
                + "pro_precio1, "
                + "pro_precio2, "
                + "pro_precio3, "
                + "pro_precio4, "
                + "pro_precio5, "
                + "pro_descuento1, "
                + "pro_descuento2, "
                + "pro_descuento3, "
                + "pro_descuento4, "
                + "pro_descuento5,"
                + "pro_margen_utilidad1, "
                + "pro_margen_utilidad2, "
                + "pro_margen_utilidad3, "
                + "pro_margen_utilidad4, "
                + "pro_margen_utilidad5, "
                + "pro_minimo, "
                + "pro_maximo, "
                + "pro_iva, "
                + "pro_credito_tributario, "
                + "pro_stock_negativo, "
                + "pro_inactivo, "
                + "pro_cuenta_inventario, "
                + "pro_cuenta_gasto, "
                + "pro_cuenta_venta, "
                + "pro_cuenta_transferencia_ipp, "
                + "cat_empresa, "
                + "cat_codigo,"
                + "mar_empresa,"
                + "mar_codigo, "
                + "presu_empresa, "
                + "presu_codigo, "
                + "presc_empresa,"
                + "presc_codigo, "
                + "tip_empresa, "
                + "tip_codigo, "
                + "inv_producto.med_empresa, "
                + "inv_producto.med_codigo, "
                + "inv_producto.usr_empresa, "
                + "inv_producto.usr_codigo, "
                + "inv_producto.usr_fecha_inserta, "
                + "med_conversion_libras, "
                + "con_codigo ,"
                + "sus_codigo,  "
                + "pro_factor_caja_saco_bulto "
                + "FROM inventario.inv_producto INNER JOIN inventario.inv_producto_medida "
                + "ON inv_producto.med_empresa = inv_producto_medida.med_empresa AND "
                + "inv_producto.med_codigo = inv_producto_medida.med_codigo "
                + "WHERE inv_producto.pro_empresa = ('" + empresa + "') AND "
                + "inv_producto.pro_codigo_principal = ('" + codigo + "')").getResultList());
    }

    public java.util.List<inventario.TO.InvClienteTO> getClienteTO(String empresa, String codigo) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaCliente_ListaClienteTO(em.createNativeQuery(
                "SELECT * FROM inventario.inv_cliente WHERE cli_empresa = ('" + empresa + "') AND "
                + "cli_codigo = ('" + codigo + "')").getResultList());
        /*
         
                SELECT * FROM inventario.inv_cliente WHERE cli_empresa = ('" + empresa + "') AND "
               + "cli_codigo = ('" + codigo + "')"
         */
    }

    public java.util.List<inventario.TO.InvProveedorTO> getProveedorTO(String empresa, String codigo) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaProveedor_ListaProveedorTO(em.createNativeQuery(
                "SELECT * FROM inventario.inv_proveedor WHERE prov_empresa = ('" + empresa + "') AND "
                + "prov_codigo = ('" + codigo + "')").getResultList());
    }

    public inventario.TO.InvProveedorTO getBuscaCedulaProveedorTO(String empresa, String cedRuc) throws Exception {
        return inventario.helper.ConversionesInventario.convertirProveedor_ProveedorTO(em.createNativeQuery(
                "SELECT * FROM inventario.inv_proveedor WHERE prov_empresa = ('" + empresa + "') AND "
                + "prov_id_numero = ('" + cedRuc + "')").getResultList());
    }

    public boolean comprobarInvAplicaRetencionIva(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT inv_proveedor_categoria.pc_aplica_retencion_iva "
                + "FROM inventario.inv_proveedor INNER JOIN inventario.inv_proveedor_categoria "
                + "ON inv_proveedor.pc_empresa = inv_proveedor_categoria.pc_empresa "
                + "AND inv_proveedor.pc_codigo = inv_proveedor_categoria.pc_codigo "
                + "WHERE inv_proveedor.prov_empresa = '" + empresa + "' AND "
                + "inv_proveedor.prov_codigo = '" + codigo + "'").getResultList(), 0)[0].toString());
    }

    public java.util.List<inventario.TO.InvCompraMotivoComboTO> getListaCompraMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        if (filtrarInactivos) {
            return inventario.helper.ConversionesInventario.convertirListaCompraMotivoCombo_ListaCompraMotivoComboTO(em.createNativeQuery("SELECT cm_codigo, cm_detalle, tip_codigo, cm_forma_contabilizar, cm_forma_imprimir FROM inventario.inv_compras_motivo "
                    + "WHERE cm_empresa = ('" + empresa + "') AND NOT cm_inactivo ORDER BY cm_codigo").getResultList());
        } else {
            return inventario.helper.ConversionesInventario.convertirListaCompraMotivoCombo_ListaCompraMotivoComboTO(em.createNativeQuery("SELECT cm_codigo, cm_detalle, tip_codigo, cm_forma_contabilizar, cm_forma_imprimir  FROM inventario.inv_compras_motivo "
                    + "WHERE cm_empresa = ('" + empresa + "') ORDER BY cm_codigo").getResultList());
        }
    }

    public java.util.List<inventario.TO.InvVentaMotivoComboTO> getListaVentaMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        if (filtrarInactivos) {
            return inventario.helper.ConversionesInventario.convertirListaVentaMotivoCombo_ListaVentaMotivoComboTO(em.createNativeQuery("SELECT vm_codigo, vm_detalle, tip_codigo, vm_forma_contabilizar, vm_forma_imprimir FROM inventario.inv_ventas_motivo "
                    + "WHERE vm_empresa = ('" + empresa + "') AND NOT vm_inactivo ORDER BY vm_codigo").getResultList());
        } else {
            return inventario.helper.ConversionesInventario.convertirListaVentaMotivoCombo_ListaVentaMotivoComboTO(em.createNativeQuery("SELECT vm_codigo, vm_detalle, tip_codigo, vm_forma_contabilizar, vm_forma_imprimir FROM inventario.inv_ventas_motivo "
                    + "WHERE vm_empresa = ('" + empresa + "') ORDER BY vm_codigo").getResultList());
        }
    }

    public java.util.List<inventario.TO.InvProformaMotivoComboTO> getListaProformaMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        if (filtrarInactivos) {
            return inventario.helper.ConversionesInventario.convertirListaProformaMotivoCombo_ListaProformaMotivoComboTO(em.createNativeQuery("SELECT pm_codigo, pm_detalle FROM inventario.inv_proformas_motivo "
                    + "WHERE pm_empresa = ('" + empresa + "') AND NOT pm_inactivo ORDER BY pm_codigo").getResultList());
        } else {
            return inventario.helper.ConversionesInventario.convertirListaProformaMotivoCombo_ListaProformaMotivoComboTO(em.createNativeQuery("SELECT pm_codigo, pm_detalle FROM inventario.inv_proformas_motivo "
                    + "WHERE pm_empresa = ('" + empresa + "') ORDER BY pm_codigo").getResultList());
        }
    }

    public int buscarConteoUltimaNumeracionCompra(String empCodigo, String perCodigo, String motCodigo) throws Exception {
        try {
            return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT "
                    + "num_secuencia FROM inventario.inv_compras_numeracion "
                    + "WHERE num_empresa = ('" + empCodigo + "') AND num_periodo = "
                    + "('" + perCodigo + "') AND num_motivo = ('" + motCodigo + "') ").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public int buscarConteoUltimaNumeracionVenta(String empCodigo, String perCodigo, String motCodigo) throws Exception {
        try {
            return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT num_secuencia FROM inventario.inv_ventas_numeracion "
                    + "WHERE num_empresa = ('" + empCodigo + "') AND num_periodo = "
                    + "('" + perCodigo + "') AND num_motivo = ('" + motCodigo + "') ").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public int buscarConteoUltimaNumeracionProforma(String empCodigo, String perCodigo, String motCodigo) throws Exception {
        try {
            return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT num_secuencia FROM inventario.inv_proformas_numeracion "
                    + "WHERE num_empresa = ('" + empCodigo + "') AND num_periodo = "
                    + "('" + perCodigo + "') AND num_motivo = ('" + motCodigo + "') ").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public int buscarConteoUltimaNumeracionConsumo(String empCodigo, String perCodigo, String motCodigo) throws Exception {
        try {
            return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT "
                    + "num_secuencia FROM inventario.inv_consumos_numeracion "
                    + "WHERE num_empresa = ('" + empCodigo + "') AND num_periodo = "
                    + "('" + perCodigo + "') AND num_motivo = ('" + motCodigo + "') ").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public java.util.List<inventario.TO.InvComboFormaPagoTO> getComboFormaPagoCompra(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvComboFormaPago_InvComboFormaPagoTO(em.createNativeQuery("SELECT sec_codigo || ' | ' || fp_detalle fp_detalle, inv_compras_forma_pago.cta_codigo, ban_cuenta.cta_empresa IS NOT NULL validar "
                + "FROM inventario.inv_compras_forma_pago LEFT JOIN banco.ban_cuenta ON inv_compras_forma_pago.cta_empresa = ban_cuenta.cta_empresa AND "
                + "inv_compras_forma_pago.cta_codigo = ban_cuenta.cta_cuenta_contable WHERE inv_compras_forma_pago.cta_empresa = '" + empresa + "' AND NOT fp_inactivo ORDER BY 1").getResultList());
    }

    public java.util.List<inventario.TO.InvComboFormaPagoTO> getComboFormaPagoVenta(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvComboFormaPago_InvComboFormaPagoTO(em.createNativeQuery("SELECT sec_codigo || ' | ' || fp_detalle fp_detalle, fp_secuencial FROM inventario.inv_ventas_forma_pago "
                + "WHERE (cta_empresa = '" + empresa + "') AND (NOT fp_inactivo) ORDER BY fp_detalle").getResultList());
    }

    public inventario.TO.InvCompraCabeceraTO getInvCompraCabeceraTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvCompraCabecera_InvCompraCabeceraTO(em.createNativeQuery("SELECT "
                + "comp_numero_alterno, "
                + "comp_documento_tipo, "
                + "comp_documento_numero, "
                + "SUBSTRING(comp_fecha::TEXT, 1, 10), "
                + "SUBSTRING(comp_fecha_vencimiento::TEXT, 1, 10), "
                + "comp_iva_vigente, "
                + "comp_observaciones, "
                + "comp_electronica, "
                + "comp_pendiente, "
                + "comp_revisado, "
                + "comp_anulado, "
                + "comp_forma_pago, "
                + "comp_base0, "
                + "comp_base_imponible, "
                + "comp_base_no_objeto, "
                + "comp_base_exenta, "
                + "comp_monto_iva, "
                + "comp_total, "
                + "comp_valor_retenido, "
                + "comp_saldo, "
                + "prov_codigo, "
                + "sec_codigo, "
                + "con_periodo, "
                + "con_tipo, "
                + "con_numero, "
                + "usr_codigo, "
                + "usr_fecha_inserta::TEXT, "
                + "comp_retencion_asumida, "
                + "comp_documento_forma_pago, "
                + "anu_comentario, "
                + "comp_activo_fijo, "
                + "comp_importacion, "
                + "comp_otros_impuestos "
                + "FROM inventario.inv_compras LEFT JOIN inventario.inv_compras_motivo_anulacion "
                + "ON inv_compras.comp_empresa = inv_compras_motivo_anulacion.comp_empresa AND "
                + "inv_compras.comp_periodo = inv_compras_motivo_anulacion.comp_periodo AND "
                + "inv_compras.comp_motivo  = inv_compras_motivo_anulacion.comp_motivo  AND "
                + "inv_compras.comp_numero  = inv_compras_motivo_anulacion.comp_numero "
                + "WHERE (inv_compras.comp_empresa = '" + empresa + "') AND "
                + "inv_compras.comp_periodo = ('" + periodo + "') AND inv_compras.comp_motivo = ('" + motivo + "') "
                + "AND inv_compras.comp_numero = '" + numeroCompra + "'").getResultList());
    }

    public inventario.TO.InvConsultaVentasFacturasPorNumeroTO getConsultaVentasFacturasPorNumeroTO(String codigoEmpresa, String numFactura) throws Exception {
        return inventario.helper.ConversionesInventario.convertirIInvConsultaVentasFacturasPorNumero_InvConsultaVentasFacturasPorNumeroTO(em.createNativeQuery(
                "SELECT vta_empresa, vta_periodo, vta_motivo, vta_numero "
                + "FROM inventario.inv_ventas "
                + "WHERE (vta_empresa = '" + codigoEmpresa + "' AND vta_documento_tipo='18' AND vta_documento_numero = '" + numFactura + "' AND vta_anulado = false ); ").getResultList());
        //001-001-000006050
    }

    public inventario.TO.InvVentaCabeceraTO getInvVentaCabeceraTO(String empresa, String periodo, String motivo, String numeroVenta) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvVentaCabecera_InvVentaCabeceraTO(em.createNativeQuery(
                  "SELECT "
                + "vta_numero_alterno, "
                + "vta_documento_tipo, "
                + "vta_documento_numero, "
                + "SUBSTRING(vta_fecha::TEXT, 1, 10),"
                + "SUBSTRING(vta_fecha_vencimiento::TEXT, 1, 10), "
                + "vta_iva_vigente, "
                + "vta_observaciones, "
                + "vta_informacion_adicional, "
                + "vta_pendiente, "
                + "vta_revisado, "
                + "vta_anulado, "
                + "vta_forma_pago, "
                + "vta_base0, "
                + "vta_base_imponible, "
                + "vta_montoiva, "
                + "vta_descuento_base0, "
                + "vta_descuento_base_imponible, "
                + "vta_descuento_base_no_objeto, "
                + "vta_descuento_base_exenta, "
                + "vta_subtotal_base0, "
                + "vta_subtotal_base_imponible, "
                + "vta_subtotal_base_no_objeto, "
                + "vta_subtotal_base_exenta, "
                + "cli_codigo, "
                + "sec_codigo, "
                + "con_periodo, "
                + "con_tipo, "
                + "con_numero, "
                + "usr_codigo, "
                + "usr_fecha_inserta, "
                + "com_documento_tipo, "
                + "com_documento_numero, "
                + "vta_pagado "
                + "FROM inventario.inv_ventas LEFT JOIN inventario.inv_ventas_complemento "
                + "ON inv_ventas.vta_empresa = inv_ventas_complemento.vta_empresa AND "
                + "inv_ventas.vta_periodo = inv_ventas_complemento.vta_periodo AND "
                + "inv_ventas.vta_motivo = inv_ventas_complemento.vta_motivo AND "
                + "inv_ventas.vta_numero = inv_ventas_complemento.vta_numero "
                + "WHERE (inv_ventas.vta_empresa = '" + empresa + "') AND "
                + "inv_ventas.vta_periodo = ('" + periodo + "') AND inv_ventas.vta_motivo = ('" + motivo + "') "
                + "AND inv_ventas.vta_numero = ('" + numeroVenta + "')").getResultList());
//        return inventario.helper.ConversionesInventario.convertirInvVentaCabecera_InvVentaCabeceraTO(em.
//                createNativeQuery("SELECT vta_numero_alterno, vta_documento_tipo, "
//                + "vta_documento_numero, SUBSTRING(vta_fecha::TEXT, 1, 10), "
//                + "SUBSTRING(vta_fecha_vencimiento::TEXT, 1, 10), vta_iva_vigente, "
//                + "vta_observaciones, vta_pendiente, vta_revisado, vta_anulado, "
//                + "vta_forma_pago, vta_base0, vta_baseimponible, vta_montoiva, "
//                + "vta_descuento, vta_total, cli_codigo, sec_codigo, con_periodo, con_tipo, con_numero, "
//                + "usr_codigo, usr_fecha_inserta, com_documento_tipo, com_documento_numero "
//                + "FROM inventario.inv_ventas LEFT JOIN inventario.inv_ventas_complemento "
//                + "ON inv_ventas.vta_empresa = inv_ventas_complemento.vta_empresa AND "
//                + "inv_ventas.vta_periodo = inv_ventas_complemento.vta_periodo AND "
//                + "inv_ventas.vta_motivo = inv_ventas_complemento.vta_motivo AND "
//                + "inv_ventas.vta_numero = inv_ventas_complemento.vta_numero "
//                + "WHERE (inv_ventas.vta_empresa = '" + empresa + "') AND "
//                + "inv_ventas.vta_periodo = ('" + periodo + "') AND inv_ventas.vta_motivo = ('" + motivo + "') "
//                + "AND inv_ventas.vta_numero = ('" + numeroVenta + "')").getResultList());
    }

    public inventario.TO.InvProformaCabeceraTO getInvProformaCabeceraTO(String empresa, String periodo, String motivo, String numeroProforma) throws Exception {
        String sql = "SELECT SUBSTRING(prof_fecha::TEXT, 1, 10), "
                + "prof_iva_vigente, "
                + "prof_observaciones, "
                + "prof_pendiente, "
                + "prof_anulado, "
                + "prof_base0, "
                + "prof_baseimponible, "
                + "prof_descuento_base0, "
                + "prof_descuento_baseimponible, "
                + "prof_subtotal_base0, "
                + "prof_subtotal_baseimponible, "
                + "prof_montoiva, "
                + "prof_total, "
                + "cli_empresa, "
                + "cli_codigo, "
                + "usr_empresa, "
                + "usr_codigo, "
                + "usr_fecha_inserta FROM inventario.inv_proformas "
                + "WHERE (inventario.inv_proformas.prof_empresa = '" + empresa + "') AND "
                + "inventario.inv_proformas.prof_periodo = ('" + periodo + "') AND inventario.inv_proformas.prof_motivo = ('" + motivo + "') "
                + "AND inventario.inv_proformas.prof_numero = ('" + numeroProforma + "')";
        System.out.println(""+sql);
        return inventario.helper.ConversionesInventario.convertirInvProformaCabecera_InvProformaCabeceraTO(em.createNativeQuery(sql).getResultList());

    }

    public inventario.TO.InvConsumosTO getInvConsumoCabeceraTO(String empresa, String periodo, String motivo, String numeroConsumo) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvConsumosCabecera_InvConsumosCabeceraTO(invConsumosFacadeLocal.find(new inventario.entity.InvConsumosPK(empresa, periodo, motivo, numeroConsumo)));
    }


    public java.util.List<inventario.TO.InvListaDetalleComprasTO> getListaInvCompraDetalleTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvListaDetalle_InvListaDetalleTO(em.createNativeQuery("SELECT * FROM inventario.fun_compras_detalle('" + empresa + "', '" + periodo + "', '" + motivo + "', '" + numeroCompra + "')").getResultList());
//        return inventario.helper.ConversionesInventario.convertirInvListaDetalle_InvListaDetalleTO(em.
//                createNativeQuery("SELECT inv_compras_detalle.det_secuencial, inv_compras_detalle.bod_codigo, "
//                + "inv_compras_detalle.det_pendiente, inv_compras_detalle.pro_codigo_principal, inv_producto.pro_nombre, "
//                + "inv_compras_detalle.det_cantidad, inv_producto_medida.med_detalle, inv_compras_detalle.det_precio, "
//                + "(inv_compras_detalle.det_precio * inv_compras_detalle.det_cantidad) AS det_total, "
//                + "inv_compras_detalle.sec_codigo, inv_compras_detalle.pis_numero, inv_producto.pro_iva "
//                + "FROM inventario.inv_compras_detalle INNER JOIN inventario.inv_producto INNER JOIN inventario.inv_producto_medida "
//                + "ON inv_producto.med_empresa = inv_producto_medida.med_empresa AND "
//                + "inv_producto.med_codigo = inv_producto_medida.med_codigo "
//                + "ON inv_compras_detalle.pro_empresa = inv_producto.pro_empresa "
//                + "AND inv_compras_detalle.pro_codigo_principal = inv_producto.pro_codigo_principal "
//                + "WHERE (comp_empresa = '" + empresa + "') AND comp_periodo = ('" + periodo + "') "
//                + "AND comp_motivo = ('" + motivo + "') AND comp_numero = '" + numeroCompra + "' ORDER BY det_orden").getResultList());
    }

    public java.util.List<inventario.TO.InvListaDetalleVentasTO> getListaInvVentasDetalleTO(String empresa, String periodo, String motivo, String numeroVentas) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvListaVentasDetalle_InvListaVentasDetalleTO(em.createNativeQuery("SELECT * FROM inventario.fun_listado_ventas_detalle('" + empresa + "', "
                + "'" + periodo + "', '" + motivo + "', '" + numeroVentas + "')").getResultList());

//        return inventario.helper.ConversionesInventario.convertirInvListaVentasDetalle_InvListaVentasDetalleTO(em.
//                createNativeQuery("SELECT inv_ventas_detalle.det_secuencial, inv_ventas_detalle.bod_codigo, "
//                + "inv_ventas_detalle.det_pendiente, inv_ventas_detalle.pro_codigo_principal, inv_producto.pro_nombre, "
//                + "inv_ventas_detalle.det_cantidad, inv_producto_medida.med_detalle, inv_ventas_detalle.det_precio, "
//                + "(inv_ventas_detalle.det_precio * inv_ventas_detalle.det_cantidad) AS det_parcial, "
//                + "inv_ventas_detalle.det_porcentaje_descuento, "
//                + "(((inv_ventas_detalle.det_precio * inv_ventas_detalle.det_cantidad)*inv_ventas_detalle.det_porcentaje_descuento)/100) AS det_descuento, "
//                + "(inv_ventas_detalle.det_precio * inv_ventas_detalle.det_cantidad) - (((inv_ventas_detalle.det_precio * inv_ventas_detalle.det_cantidad)*inv_ventas_detalle.det_porcentaje_descuento)/100) AS det_subtotal, "
//                + "inv_ventas_detalle.sec_codigo, inv_ventas_detalle.pis_numero, inv_producto.pro_iva "
//                + "FROM inventario.inv_ventas_detalle INNER JOIN inventario.inv_producto INNER JOIN inventario.inv_producto_medida "
//                + "ON inv_producto.med_empresa = inv_producto_medida.med_empresa AND "
//                + "inv_producto.med_codigo = inv_producto_medida.med_codigo "
//                + "ON inv_ventas_detalle.pro_empresa = inv_producto.pro_empresa "
//                + "AND inv_ventas_detalle.pro_codigo_principal = inv_producto.pro_codigo_principal "
//                + "WHERE (vta_empresa = '" + empresa + "') AND vta_periodo = ('" + periodo + "') "
//                + "AND vta_motivo = ('" + motivo + "') AND vta_numero = ('" + numeroVentas + "') ORDER BY det_orden").getResultList());
    }

    public java.util.List<inventario.TO.InvListaDetalleProformasTO> getListaInvProformasDetalleTO(String empresa, String periodo, String motivo, String numeroProformas) throws Exception { 
        
        String sql = "SELECT * FROM inventario.fun_listado_proformas_detalle('" + empresa + "', "+ "'" + periodo + "', '" + motivo + "', '" + numeroProformas + "')";
        System.out.println("sql :   "+sql);
        return inventario.helper.ConversionesInventario.convertirInvListaProformasDetalle_InvListaProformasDetalleTO(em.createNativeQuery(sql).getResultList());
//        return inventario.helper.ConversionesInventario.convertirInvListaVentasDetalle_InvListaVentasDetalleTO(em.
//                createNativeQuery("SELECT inv_ventas_detalle.det_secuencial, inv_ventas_detalle.bod_codigo, "
//                + "inv_ventas_detalle.det_pendiente, inv_ventas_detalle.pro_codigo_principal, inv_producto.pro_nombre, "
//                + "inv_ventas_detalle.det_cantidad, inv_producto_medida.med_detalle, inv_ventas_detalle.det_precio, "
//                + "(inv_ventas_detalle.det_precio * inv_ventas_detalle.det_cantidad) AS det_parcial, "
//                + "inv_ventas_detalle.det_porcentaje_descuento, "
//                + "(((inv_ventas_detalle.det_precio * inv_ventas_detalle.det_cantidad)*inv_ventas_detalle.det_porcentaje_descuento)/100) AS det_descuento, "
//                + "(inv_ventas_detalle.det_precio * inv_ventas_detalle.det_cantidad) - (((inv_ventas_detalle.det_precio * inv_ventas_detalle.det_cantidad)*inv_ventas_detalle.det_porcentaje_descuento)/100) AS det_subtotal, "
//                + "inv_ventas_detalle.sec_codigo, inv_ventas_detalle.pis_numero, inv_producto.pro_iva "
//                + "FROM inventario.inv_ventas_detalle INNER JOIN inventario.inv_producto INNER JOIN inventario.inv_producto_medida "
//                + "ON inv_producto.med_empresa = inv_producto_medida.med_empresa AND "
//                + "inv_producto.med_codigo = inv_producto_medida.med_codigo "
//                + "ON inv_ventas_detalle.pro_empresa = inv_producto.pro_empresa "
//                + "AND inv_ventas_detalle.pro_codigo_principal = inv_producto.pro_codigo_principal "
//                + "WHERE (vta_empresa = '" + empresa + "') AND vta_periodo = ('" + periodo + "') "
//                + "AND vta_motivo = ('" + motivo + "') AND vta_numero = ('" + numeroVentas + "') ORDER BY det_orden").getResultList());
    }
//    public java.util.List<inventario.TO.InvListaDetalleComprasTO> getListaInvCompraDetalleTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
//        return inventario.helper.ConversionesInventario.convertirInvListaDetalle_InvListaDetalleTO(em.
//                createNativeQuery("SELECT inv_compras_detalle.det_secuencial, inv_compras_detalle.bod_codigo, "
//                + "inv_compras_detalle.det_pendiente, inv_compras_detalle.pro_codigo_principal, inv_producto.pro_nombre, "
//                + "inv_compras_detalle.det_cantidad, inv_compras_detalle.det_precio, "
//                + "(inv_compras_detalle.det_precio * inv_compras_detalle.det_cantidad) AS det_total, "
//                + "inv_compras_detalle.sec_codigo, inv_compras_detalle.pis_numero, inv_compras_detalle.det_fecha, "
//                + "inv_producto.pro_iva FROM inventario.inv_compras_detalle INNER JOIN inventario.inv_producto "
//                + "ON inv_compras_detalle.pro_empresa = inv_producto.pro_empresa "
//                + "AND inv_compras_detalle.pro_codigo_principal = inv_producto.pro_codigo_principal "
//                + "WHERE (comp_empresa = '" + empresa + "') AND comp_periodo = ('" + periodo + "') "
//                + "AND comp_motivo = ('" + motivo + "') AND comp_numero = '" + numeroCompra + "' ORDER BY det_orden").getResultList());
//    }

    public java.util.List<inventario.TO.InvListaDetalleConsumoTO> getListaInvConsumoDetalleTO(String empresa, String periodo, String motivo, String numeroConsumo) throws Exception {
        /*
         * return
         * inventario.helper.ConversionesInventario.convertirInvListaDetalleConsumo_InvListaDetalleConsumoTO(em.
         * createNativeQuery("SELECT inv_consumos_detalle.det_secuencial,
         * inv_consumos_detalle.bod_codigo, " +
         * "inv_consumos_detalle.pro_codigo_principal, inv_producto.pro_nombre,
         * " + "inv_consumos_detalle.det_cantidad, inv_producto.med_codigo, " +
         * "inv_consumos_detalle.sec_codigo, inv_consumos_detalle.pis_numero, "
         * + "inv_producto.med_codigo2, inv_producto.pro_factor_conversion " +
         * "FROM inventario.inv_consumos_detalle " + "INNER JOIN
         * inventario.inv_producto INNER JOIN inventario.inv_producto_medida " +
         * "ON inv_producto.med_empresa = inv_producto_medida.med_empresa AND "
         * + "inv_producto.med_codigo = inv_producto_medida.med_codigo " + "ON
         * inv_consumos_detalle.pro_empresa = inv_producto.pro_empresa " + "AND
         * inv_consumos_detalle.pro_codigo_principal =
         * inv_producto.pro_codigo_principal " + "WHERE (cons_empresa = '" +
         * empresa + "') AND cons_periodo = ('" + periodo + "') " + "AND
         * cons_motivo = ('" + motivo + "') AND cons_numero = ('" +
         * numeroConsumo + "') ORDER BY det_orden").getResultList());
         */
        return inventario.helper.ConversionesInventario.convertirInvListaDetalleConsumo_InvListaDetalleConsumoTO(em.createNativeQuery("SELECT inv_consumos_detalle.det_secuencial, inv_consumos_detalle.bod_codigo, "
                + "inv_consumos_detalle.pro_codigo_principal, inv_producto.pro_nombre, "
                + "inv_consumos_detalle.det_cantidad, inv_producto_medida.med_detalle, "
                + "inv_consumos_detalle.sec_codigo, inv_consumos_detalle.pis_numero "
                + "FROM inventario.inv_consumos_detalle "
                + "INNER JOIN inventario.inv_producto INNER JOIN inventario.inv_producto_medida "
                + "ON inv_producto.med_empresa = inv_producto_medida.med_empresa AND "
                + "inv_producto.med_codigo = inv_producto_medida.med_codigo "
                + "ON inv_consumos_detalle.pro_empresa = inv_producto.pro_empresa "
                + "AND inv_consumos_detalle.pro_codigo_principal = inv_producto.pro_codigo_principal "
                + "WHERE (cons_empresa = '" + empresa + "') AND cons_periodo = ('" + periodo + "') "
                + "AND cons_motivo = ('" + motivo + "') AND cons_numero = ('" + numeroConsumo + "') ORDER BY det_orden").getResultList());
    }
//    public java.util.List<inventario.TO.InvListaDetalleConsumoTO> getListaInvConsumoDetalleTO(String empresa, String periodo, String motivo, String numeroConsumo) throws Exception {
//        return inventario.helper.ConversionesInventario.convertirInvListaDetalleConsumo_InvListaDetalleConsumoTO(em.
//                createNativeQuery("SELECT inv_consumos_detalle.det_secuencial, inv_consumos_detalle.bod_codigo, "
//                + "inv_consumos_detalle.pro_codigo_principal, inv_producto.pro_nombre, "
//                + "inv_consumos_detalle.det_cantidad, inv_consumos_detalle.sec_codigo, "
//                + "inv_consumos_detalle.pis_numero FROM inventario.inv_consumos_detalle "
//                + "INNER JOIN inventario.inv_producto "
//                + "ON inv_consumos_detalle.pro_empresa = inv_producto.pro_empresa "
//                + "AND inv_consumos_detalle.pro_codigo_principal = inv_producto.pro_codigo_principal "
//                + "WHERE (cons_empresa = '" + empresa + "') AND cons_periodo = ('" + periodo + "') "
//                + "AND cons_motivo = ('" + motivo + "') AND cons_numero = ('" + numeroConsumo + "') ORDER BY det_orden ").getResultList());
//    }

    public java.util.List<inventario.TO.InvListaConsultaCompraTO> getFunComprasListado(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception {
        String pendiente = null;
        String anulado = null;
        if (status.equals("PENDIENTE")) {
            pendiente = "'PENDIENTE'";
            anulado = null;
        }
        if (status.equals("ANULADO")) {
            pendiente = null;
            anulado = "'ANULADO'";
        }
        if (status.equals("AMBOS")) {
            pendiente = "'PENDIENTE'";
            anulado = "'ANULADO'";
        }
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return inventario.helper.ConversionesInventario.convertirInvListaConsultaCompra_InvListaConsultaCompraTO(em.createNativeQuery("SELECT * FROM inventario.fun_compras_listado('" + empresa + "', null, null, null) "
                + "WHERE comp_fecha >= " + fechaDesde + " AND comp_fecha <= " + fechaHasta + " "
                + "AND comp_pendiente = " + pendiente + " OR comp_anulado = " + anulado + ";").getResultList());
    }

    public List<inventario.TO.InvListaConsultaCompraTO> getListaInvConsultaCompra(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception {
        String limit = "";
        if (nRegistros != null && nRegistros.compareTo("") != 0 && nRegistros.compareTo("0") != 0) {
            limit = " limit " + nRegistros;
        }
        return ConversionesInventario.convertirInvListaConsultaCompra_InvListaConsultaCompraTO(em.createNativeQuery("SELECT * FROM inventario.fun_compras_listado('" + empresa + "', '" + periodo + "', '" + motivo + "', '" + busqueda + "')" + limit).getResultList());
    }

    public java.util.List<inventario.TO.InvListaConsultaVentaTO> getFunVentasListado(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception {
        String pendiente = null;
        String anulado = null;
        if (status.equals("PENDIENTE")) {
            pendiente = "'PENDIENTE'";
            anulado = null;
        }
        if (status.equals("ANULADO")) {
            pendiente = null;
            anulado = "'ANULADO'";
        }
        if (status.equals("AMBOS")) {
            pendiente = "'PENDIENTE'";
            anulado = "'ANULADO'";
        }
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return inventario.helper.ConversionesInventario.convertirInvListaConsultaVenta_InvListaConsultaVentaTO(em.createNativeQuery("SELECT * FROM inventario.fun_ventas_listado('" + empresa + "', null, null, null) "
                + "WHERE vta_fecha >= " + fechaDesde + " AND vta_fecha <= " + fechaHasta + " "
                + "AND vta_pendiente = " + pendiente + " OR vta_anulado = " + anulado + ";").getResultList());
    }

    public List<InvListaConsultaVentaTO> getListaInvConsultaVenta(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception {
        String limit = "";
        if (nRegistros != null && nRegistros.compareTo("") != 0 && nRegistros.compareTo("0") != 0) {
            limit = " limit " + nRegistros;
        }
        return ConversionesInventario.convertirInvListaConsultaVenta_InvListaConsultaVentaTO(em.createNativeQuery("SELECT * FROM inventario.fun_ventas_listado('" + empresa + "', '" + periodo + "', '" + motivo + "', '" + busqueda + "')" + limit).getResultList());
    }

    public java.util.List<inventario.TO.InvListaConsultaProformaTO> getListaInvConsultaProforma(String empresa, String periodo, String motivo, String busqueda) throws Exception {
        String sql = "SELECT * FROM inventario.fun_proformas_listado('" + empresa + "', '" + periodo + "', '" + motivo + "', '" + busqueda + "')";
        return inventario.helper.ConversionesInventario.convertirInvListaConsultaVProforma_InvListaConsultaProformaTO(em.createNativeQuery(sql).getResultList());
    }

    public java.util.List<inventario.TO.InvListaConsultaConsumosTO> getFunConsumosListado(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception {
        String pendiente = null;
        String anulado = null;
        if (status.equals("PENDIENTE")) {
            pendiente = "'PENDIENTE'";
            anulado = null;
        }
        if (status.equals("ANULADO")) {
            pendiente = null;
            anulado = "'ANULADO'";
        }
        if (status.equals("AMBOS")) {
            pendiente = "'PENDIENTE'";
            anulado = "'ANULADO'";
        }
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesInventario.convertirInvListaConsultaConsumos_InvListaConsultaConsumosTO(em.createNativeQuery("SELECT * FROM inventario.fun_consumos_listado('" + empresa + "', null, null, null) "
                + "WHERE cons_fecha >= " + fechaDesde + " AND cons_fecha <= " + fechaHasta + " "
                + "AND cons_pendiente = " + pendiente + " OR cons_anulado = " + anulado + ";").getResultList());
    }

    public List<inventario.TO.InvListaConsultaConsumosTO> getListaInvConsultaConsumos(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception {
        String limit = "";
        if (nRegistros != null && nRegistros.compareTo("") != 0 && nRegistros.compareTo("0") != 0) {
            limit = " limit " + nRegistros;
        }
        return ConversionesInventario.convertirInvListaConsultaConsumos_InvListaConsultaConsumosTO(em.createNativeQuery("SELECT * FROM inventario.fun_consumos_listado('" + empresa + "', '" + periodo + "', '" + motivo + "', '" + busqueda + "')" + limit).
                getResultList());
    }

    public java.util.List<inventario.TO.InvConsumosImportarExportarTO> getListaInvConsumosImportarExportarTO(String empresa, String desde, String hasta) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        return inventario.helper.ConversionesInventario.convertirListaInvConsumosImportarExportar_ListaInvConsumosImportarExportarTO(em.createNativeQuery("SELECT inv_consumos.cons_empresa, inv_consumos.cons_periodo, "
                + "inv_consumos.cons_motivo, inv_consumos.cons_numero, cons_referencia, cons_fecha, "
                + "cons_observaciones, cons_pendiente, cons_revisado, cons_anulado, con_empresa, "
                + "con_periodo, con_tipo, con_numero, usr_empresa, usr_codigo, usr_fecha_inserta, "
                + "0 det_secuencial, det_orden, det_cantidad, det_valor_promedio, "
                + "det_valor_ultima_compra, det_saldo, bod_empresa, bod_codigo, pro_empresa, "
                + "pro_codigo_principal, sec_empresa, sec_codigo, pis_empresa, pis_sector, "
                + "pis_numero "
                + "FROM inventario.inv_consumos INNER JOIN inventario.inv_consumos_detalle "
                + "ON inv_consumos.cons_empresa = inv_consumos_detalle.cons_empresa AND "
                + "inv_consumos.cons_periodo = inv_consumos_detalle.cons_periodo AND "
                + "inv_consumos.cons_motivo = inv_consumos_detalle.cons_motivo AND "
                + "inv_consumos.cons_numero = inv_consumos_detalle.cons_numero "
                + "WHERE inv_consumos.cons_empresa='" + empresa + "' AND cons_fecha BETWEEN " + desde + " AND " + hasta + "AND NOT cons_pendiente").getResultList());
    }

    public java.util.List<inventario.TO.InvConsumosMotivoComboTO> getListaConsumosMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        if (filtrarInactivos) {
            return inventario.helper.ConversionesInventario.convertirListaConsumosMotivoCombo_ListaConsumosMotivoComboTO(em.createNativeQuery(
                    "SELECT cm_codigo, cm_detalle FROM inventario.inv_consumos_motivo "
                    + "WHERE cm_empresa = ('" + empresa + "') AND NOT cm_inactivo ORDER BY cm_codigo").getResultList());
        } else {
            return inventario.helper.ConversionesInventario.convertirListaConsumosMotivoCombo_ListaConsumosMotivoComboTO(em.createNativeQuery("SELECT cm_codigo, cm_detalle FROM inventario.inv_consumos_motivo "
                    + "WHERE cm_empresa = ('" + empresa + "') ORDER BY cm_codigo").getResultList());
        }
    }

    public java.util.List<inventario.TO.InvMedidaComboTO> getListaInvMedidaTablaTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaMedida_ListaMedidaTO(em.createNativeQuery("SELECT med_codigo, med_detalle , med_conversion_libras FROM "
                + "inventario.inv_producto_medida WHERE med_empresa = ('" + empresa + "') ORDER BY med_detalle").getResultList());
    }

    public java.util.List<inventario.TO.InvListaConsumosMotivoTO> getInvListaConsumosMotivoTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvListaConsumosMotivoTO_InvListaConsumosMotivo(em.createNativeQuery("SELECT cm_codigo, cm_detalle, cm_inactivo "
                + "FROM inventario.inv_consumos_motivo "
                + "WHERE (cm_empresa = '" + empresa + "') ORDER BY cm_codigo").getResultList());
    }

    public inventario.entity.InvComprasMotivo getInvComprasMotivo(String empresa, String codigo) throws Exception {
        return invComprasMotivoFacadeLocal.find(new inventario.entity.InvComprasMotivoPK(empresa, codigo));
    }

    public inventario.entity.InvVentasMotivo getInvVentasMotivo(String empresa, String codigo) throws Exception {
        return invVentasMotivoFacadeLocal.find(new inventario.entity.InvVentasMotivoPK(empresa, codigo));
    }

    public inventario.TO.InvComprasMotivoTO getInvComprasMotivoTO(String empresa, inventario.TO.InvCompraMotivoTablaTO invCompraMotivoTablaTO) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvComprasMotivo_InvComprasMotivoTO(invComprasMotivoFacadeLocal.find(new inventario.entity.InvComprasMotivoPK(empresa, invCompraMotivoTablaTO.getCmCodigo())));
    }

    public inventario.TO.InvVentaMotivoTO getInvVentasMotivoTO(String empresa, inventario.TO.InvVentaMotivoTablaTO invVentaMotivoTablaTO) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvVentasMotivo_InvVentasMotivoTO(invVentasMotivoFacadeLocal.find(new inventario.entity.InvVentasMotivoPK(empresa, invVentaMotivoTablaTO.getVmCodigo())));
    }

    public inventario.TO.InvConsumosMotivoTO getInvConsumosMotivoTO(String empresa, inventario.TO.InvListaConsumosMotivoTO invListaConsumosMotivoTO) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvConsumosMotivo_InvConsumosMotivoTO(invConsumosMotivoFacadeLocal.find(new inventario.entity.InvConsumosMotivoPK(empresa, invListaConsumosMotivoTO.getCmCodigo())));
    }

    public java.util.List<inventario.TO.InvCompraMotivoTablaTO> getListaInvComprasMotivoTablaTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaInvComprasMotivo_ListaInvComprasMotivoTO(
                em.createNativeQuery("SELECT cm_codigo, cm_detalle, tip_detalle FROM inventario.inv_compras_motivo "
                + "INNER JOIN contabilidad.con_tipo ON inv_compras_motivo.tip_empresa = con_tipo.tip_empresa "
                + "AND inv_compras_motivo.tip_codigo = con_tipo.tip_codigo WHERE cm_empresa = ('" + empresa + "') ORDER BY cm_codigo").
                getResultList());
    }

    public java.util.List<inventario.TO.InvVentaMotivoTablaTO> getListaInvVentasMotivoTablaTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaInvVentasMotivo_ListaInvVentasMotivoTO(
                em.createNativeQuery("SELECT vm_codigo, vm_detalle, tip_detalle FROM inventario.inv_ventas_motivo "
                + "INNER JOIN contabilidad.con_tipo ON inv_ventas_motivo.tip_empresa = con_tipo.tip_empresa "
                + "AND inv_ventas_motivo.tip_codigo = con_tipo.tip_codigo "
                + "WHERE vm_empresa = ('" + empresa + "') ORDER BY vm_codigo").
                getResultList());
    }

    public java.util.List<inventario.TO.InvNumeracionCompraTO> getListaInvNumeracionCompraTO(String empresa, String periodo, String motivo) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaInvNumeracionCompra_ListaInvNumeracionCompraTO(em.createNativeQuery("SELECT * FROM inventario.inv_compras_numeracion "
                + "WHERE (num_empresa = '" + empresa + "') "
                + "AND CASE WHEN ('" + periodo + "') = '' THEN TRUE ELSE (num_periodo = '" + periodo + "') END "
                + "AND CASE WHEN ('" + motivo + "') = '' THEN TRUE ELSE num_motivo = ('" + motivo + "') END").getResultList());
    }

    public java.util.List<inventario.TO.InvNumeracionVentaTO> getListaInvNumeracionVentaTO(String empresa, String periodo, String motivo) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaInvNumeracionVenta_ListaInvNumeracionVentaTO(em.createNativeQuery("SELECT * FROM inventario.inv_ventas_numeracion "
                + "WHERE (num_empresa = '" + empresa + "') "
                + "AND CASE WHEN ('" + periodo + "') = '' THEN TRUE ELSE (num_periodo = '" + periodo + "') END "
                + "AND CASE WHEN ('" + motivo + "') = '' THEN TRUE ELSE num_motivo = ('" + motivo + "') END").getResultList());
    }

    public java.util.List<inventario.TO.InvNumeracionConsumoTO> getListaInvNumeracionConsumoTO(String empresa, String periodo, String motivo) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaInvNumeracionConsumo_ListaInvNumeracionConsumoTO(em.createNativeQuery("SELECT * FROM inventario.inv_consumos_numeracion "
                + "WHERE (num_empresa = '" + empresa + "') "
                + "AND CASE WHEN ('" + periodo + "') = '' THEN TRUE ELSE (num_periodo = '" + periodo + "') END "
                + "AND CASE WHEN ('" + motivo + "') = '' THEN TRUE ELSE num_motivo = ('" + motivo + "') END").getResultList());
    }

    // <editor-fold defaultstate="collapsed" desc="COMPRASFORMAPAGO">
    public Boolean buscarInvComprasFormaPago(String ctaContable, String empresa) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) "
                + "FROM inventario.inv_compras_forma_pago "
                + "WHERE (cta_codigo = '" + ctaContable + "') AND (cta_empresa = '" + empresa + "');").
                getResultList(), 0)[0].toString()) == 1 ? true : false;
    }

    public java.util.List<inventario.TO.InvListaComprasFormaPagoTO> getInvListaComprasFormaPagoTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvListaComprasFormaPago_InvListaComprasFormaPagoTO(em.createNativeQuery("SELECT fp_secuencial, fp_detalle, fp_inactivo, sec_codigo, cta_codigo "
                + "FROM inventario.inv_compras_forma_pago "
                + "WHERE (usr_empresa = '" + empresa + "') ORDER BY fp_detalle;").getResultList());
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VENTASFORMAPAGO">
    public Boolean buscarInvVentasFormaPago(String ctaContable, String empresa) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) "
                + "FROM inventario.inv_ventas_forma_pago "
                + "WHERE (cta_codigo = '" + ctaContable + "') AND (cta_empresa = '" + empresa + "');").
                getResultList(), 0)[0].toString()) == 1 ? true : false;
    }

    public java.util.List<inventario.TO.InvListaVentasFormaPagoTO> getInvListaVentasFormaPagoTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvListaVentasFormaPago_InvListaVentasFormaPagoTO(em.createNativeQuery("SELECT fp_secuencial, fp_detalle, fp_inactivo, sec_codigo, cta_codigo "
                + "FROM inventario.inv_ventas_forma_pago "
                + "WHERE (usr_empresa = '" + empresa + "') ORDER BY fp_detalle;").getResultList());
    }// </editor-fold>

    public inventario.entity.InvProductoSaldos getInvProductoSaldo(String empresa, String codigoBodega, String codigoProducto) throws Exception {
        return invProductoSaldosFacadeLocal.find(new inventario.entity.InvProductoSaldosPK(empresa, codigoBodega, codigoProducto));
    }

    public java.util.List<inventario.TO.InvComboBodegaTO> getInvComboBodegaTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvComboBodega_InvComboBodegaTO(
                em.createNativeQuery("SELECT bod_codigo, bod_nombre, sec_codigo "
                + "FROM inventario.inv_bodega "
                + "WHERE (bod_empresa = '" + empresa + "') ORDER BY bod_codigo;").getResultList());
    }

    public java.util.List<inventario.TO.InvKardexTO> getListaInvKardexTO(String empresa, String bodega, String producto, String desde, String hasta, String promedio) throws Exception {
        producto = producto == null ? producto : "'" + producto + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";       
        String sql = "SELECT * FROM inventario.fun_kardex("
                + "'" + empresa + "', "
                + "'" + bodega + "', "
                + "" + producto + ", "
                + "" + desde + ", "
                + "" + hasta + ", "
                + "CASE WHEN '" + promedio + "' = 'SERVICIOS' THEN TRUE ELSE FALSE END);";
        System.out.println(sql);
        return ConversionesInventario.convertirListaInvKardex_ListaInvKardexTO(
                em.createNativeQuery(sql).getResultList());
    }

    public inventario.TO.InvComprasRecepcionTO getInvComprasRecepcionTO(String empresa, String periodo, String motivo, String numero) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvComprasRecepcion_InvComprasRecepcionTO(em.createNativeQuery("SELECT recep_empresa, recep_periodo, recep_motivo, recep_numero, "
                + "SUBSTRING(recep_fecha::TEXT, 1, 10), comp_empresa, comp_periodo, "
                + "comp_motivo, comp_numero, usr_empresa, usr_codigo, "
                + "SUBSTRING(usr_fecha_inserta::TEXT, 1, 10) FROM inventario.inv_compras_recepcion "
                + "WHERE recep_empresa = '" + empresa + "' AND recep_periodo = '" + periodo + "' "
                + "AND recep_motivo = '" + motivo + "' AND recep_numero = '" + numero + "'").getResultList());

    }

    public boolean getClienteRepetido(String empresa, String codigo, String id, String nombre, String razonSocial) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM inventario."
                + "fun_sw_cliente_repetido(" + empresa + ", " + codigo + ", " + id + ", " + nombre + ", " + razonSocial + ")").
                getResultList(), 0)[0].toString());
    }

    public boolean getProductoRepetido(String empresa, String codigo, String alterno, String barras, String barras2, String barras3, String barras4, String barras5, String nombre) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM inventario."
                + "fun_sw_producto_repetido(" + empresa + ", " + codigo + ", " + alterno + ", " + barras + ", " + barras2 + ", " + barras3 + ", " + barras4 + ", " + barras5 + ", " + nombre + ")").
                getResultList(), 0)[0].toString());
    }

    public boolean getProveedorRepetido(String empresa, String codigo, String id, String nombre, String razonSocial) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM inventario."
                + "fun_sw_proveedor_repetido(" + empresa + ", " + codigo + ", " + id + ", " + nombre + ", " + razonSocial + ")").
                getResultList(), 0)[0].toString());
    }

    public java.util.List<inventario.TO.InvProductosConErrorTO> getListadoProductosConError(String empresa) throws Exception {
        String sql = "SELECT * FROM inventario.fun_errores('" + empresa + "')";
        return inventario.helper.ConversionesInventario.convertirInvListaProductosConError_InvListaProductosConErrorTO(em.createNativeQuery(sql).
                getResultList());
    }

    public String getInvProximaNumeracionCliente(String empresa, inventario.TO.InvClienteTO invClienteTO) throws Exception {
        Object[] consulta = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT num_clientes FROM "
                + "inventario.inv_numeracion_varios WHERE (num_empresa = '" + empresa + "')").getResultList(), 0);
        if (consulta != null) {
            invClienteTO.setCliCodigo(consulta[0].toString());
        } else {
            invClienteTO.setCliCodigo("00000");
        }

        int numeracion = Integer.parseInt(invClienteTO.getCliCodigo());
        String rellenarConCeros = "";
        do {
            numeracion++;
            int numeroCerosAponer = 5 - String.valueOf(numeracion).trim().length();
            rellenarConCeros = "";
            for (int i = 0; i < numeroCerosAponer; i++) {
                rellenarConCeros = rellenarConCeros + "0";
            }

            invClienteTO.setCliCodigo(rellenarConCeros + numeracion);

        } while (buscarInvCliente(invClienteTO.getEmpCodigo(), invClienteTO.getCliCodigo()) != null);
        return rellenarConCeros + numeracion;
    }

    public String getInvProximaNumeracionProveedor(String empresa, inventario.TO.InvProveedorTO invProveedorTO) throws Exception {
        Object[] consulta = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT num_proveedores FROM "
                + "inventario.inv_numeracion_varios WHERE (num_empresa = '" + empresa + "')").getResultList(), 0);
        if (consulta != null) {
            invProveedorTO.setProvCodigo(consulta[0].toString());
        } else {
            invProveedorTO.setProvCodigo("00000");
        }

        int numeracion = Integer.parseInt(invProveedorTO.getProvCodigo());
        String rellenarConCeros = "";
        do {
            numeracion++;
            int numeroCerosAponer = 5 - String.valueOf(numeracion).trim().length();
            rellenarConCeros = "";
            for (int i = 0; i < numeroCerosAponer; i++) {
                rellenarConCeros = rellenarConCeros + "0";
            }

            invProveedorTO.setProvCodigo(rellenarConCeros + numeracion);

        } while (buscarInvProveedor(invProveedorTO.getEmpCodigo(), invProveedorTO.getProvCodigo()) != null);
        return rellenarConCeros + numeracion;
    }

    public String getInvProximaNumeracionProducto(String empresa, inventario.TO.InvProductoTO invProductoTO) throws Exception {
        Object[] consulta = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT num_productos FROM "
                + "inventario.inv_numeracion_varios WHERE (num_empresa = '" + empresa + "')").getResultList(), 0);
        if (consulta != null) {
            invProductoTO.setProCodigoPrincipal(consulta[0].toString());
        } else {
            invProductoTO.setProCodigoPrincipal("00000");
        }

        int numeracion = Integer.parseInt(invProductoTO.getProCodigoPrincipal());
        String rellenarConCeros = "";
        do {
            numeracion++;
            int numeroCerosAponer = 5 - String.valueOf(numeracion).trim().length();
            rellenarConCeros = "";
            for (int i = 0; i < numeroCerosAponer; i++) {
                rellenarConCeros = rellenarConCeros + "0";
            }

            invProductoTO.setProCodigoPrincipal(rellenarConCeros + numeracion);

        } while (buscarInvProducto(invProductoTO.getProEmpresa(), invProductoTO.getProCodigoPrincipal()) != null);
        return rellenarConCeros + numeracion;
    }

    public inventario.entity.InvNumeracionVarios getInvNumeracionVarios(String empresa) throws Exception {
        return invNumeracionVariosFacadeLocal.find(empresa);
    }

    public Boolean getPrecioFijoCategoriaProducto(String empresa, String codigoCategoria) throws Exception {
        java.util.List lista = em.createNativeQuery("SELECT inv_producto_categoria.cat_precio_fijo FROM "
                + "inventario.inv_producto_categoria WHERE cat_empresa = ('" + empresa + "') "
                + "AND cat_codigo = ('" + codigoCategoria + "')").
                getResultList();
        if (!lista.isEmpty()) {
            return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(lista, 0)[0].toString());
        } else {
            return null;
        }
//        String retorno = validaciones.ConvertirListaObject.convertirListToArray(em.
//                createNativeQuery("SELECT inv_producto_categoria.cat_precio_fijo FROM inventario.inv_producto_categoria "
//                + "WHERE cat_empresa = ('" + empresa + "') AND cat_codigo = ('" + codigoCategoria + "')").
//                getResultList(), 0)[0].toString();
//        if (retorno != null){
//            return Boolean.parseBoolean(retorno);
//        } else {
//            return null;
//        }

    }

    public Boolean comprobarInvTransferenciaMotivo(String empresa, String motCodigo) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) "
                + "FROM inventario.inv_transferencias_motivo WHERE tm_empresa = "
                + "('" + empresa + "') AND tm_codigo = ('" + motCodigo + "')").
                getResultList(), 0)[0].toString()) == 0) ? false : true;
    }

    public java.util.List<inventario.TO.InvListaDetalleTransferenciaTO> getListaInvTransferenciasDetalleTO(String empresa, String periodo, String motivo, String numeroTrans) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvListaDetalleTransferencia_InvListaDetalleTransferenciaTO(em.createNativeQuery("SELECT * FROM inventario.fun_listado_transferencias_detalle('" + empresa + "', '" + periodo + "', "
                + "'" + motivo + "', '" + numeroTrans + "')").getResultList());
//                + "inv_transferencias_detalle.det_secuencial, "
//                + "inv_transferencias_detalle.bod_origen_codigo, inv_transferencias_detalle.bod_destino_codigo, "
//                + "inv_transferencias_detalle.pro_codigo_principal, inv_producto.pro_nombre, "
//                + "inv_transferencias_detalle.det_cantidad, inv_producto_medida.med_detalle "
//                + "FROM inventario.inv_transferencias_detalle INNER JOIN inventario.inv_producto "
//                + "INNER JOIN inventario.inv_producto_medida "
//                + "ON inv_producto.med_empresa = inv_producto_medida.med_empresa AND "
//                + "inv_producto.med_codigo = inv_producto_medida.med_codigo "
//                + "ON inv_transferencias_detalle.pro_empresa = inv_producto.pro_empresa AND "
//                + "inv_transferencias_detalle.pro_codigo_principal = inv_producto.pro_codigo_principal "
//                + "WHERE (trans_empresa = '" + empresa + "') AND trans_periodo = ('" + periodo + "') AND "
//                + "trans_motivo = ('" + motivo + "') AND trans_numero = ('" + numeroTrans + "') ORDER BY det_orden").getResultList());
    }

    public java.util.List<inventario.TO.InvListaProductosCambiarPrecioTO> getListaProductosCambiarPrecioTO(String empresa, String busqueda, String bodega, String fecha) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaInvProductoCambiarPrecio_ListaInvProductoCambiarPrecioTO(em.createNativeQuery(
                "SELECT "
                + "lpsp_codigo_principal, "
                + "lpsp_nombre, "
                + "lpsp_categoria, "
                + "lpsp_saldo, lpsp_costo, lpsp_medida, lpsp_precio1, lpsp_descuento1, "
                + "lpsp_precio2, lpsp_descuento2, lpsp_precio3, lpsp_descuento3, lpsp_precio4, lpsp_descuento4, lpsp_precio5, lpsp_descuento5, lpsp_iva FROM "
                + "inventario.fun_lista_productos_saldos_precios('" + empresa + "', '" + bodega + "', '', '" + busqueda + "', " + fecha + ", FALSE)").getResultList());
    }

    public java.util.List<inventario.TO.InvListaProductosCambiarPrecioCantidadTO> getListaProductosCambiarPrecioCantidadTO(String empresa, String busqueda, String bodega, String fecha) throws Exception {
        String sql = "SELECT lpsp_codigo_principal, lpsp_nombre, lpsp_categoria, lpsp_saldo, lpsp_costo, lpsp_medida, lpsp_precio1, lpsp_cantidad1, "
                + "lpsp_precio2, lpsp_cantidad2, lpsp_precio3, lpsp_cantidad3, lpsp_precio4, lpsp_cantidad4, lpsp_precio5, lpsp_cantidad5, lpsp_iva FROM "
                + "inventario.fun_lista_productos_saldos_precios('" + empresa + "', '" + bodega + "', '', '" + busqueda + "', " + fecha + ", FALSE)";
        return inventario.helper.ConversionesInventario.convertirListaInvProductoCambiarPrecioCantidad_ListaInvProductoCambiarPrecioCantidadTO(
                em.createNativeQuery(sql).getResultList());
    }

    public inventario.TO.InvEstadoCCCVT getEstadoCCCVT(String empresa, String periodo, String motivoTipo, String numero, String proceso) throws Exception {
        inventario.TO.InvEstadoCCCVT invEstadoCCVT = null;
        if (proceso.trim().equals("COMPRA")) {
            invEstadoCCVT = inventario.helper.ConversionesInventario.convertirInvEstadoCCVTConsulta_InvEstadoCCVT(em.createNativeQuery("SELECT comp_pendiente, comp_anulado, comp_activo_fijo FROM inventario.inv_compras WHERE "
                    + "comp_empresa = '" + empresa + "' AND comp_periodo = '" + periodo + "' "
                    + "AND comp_motivo = '" + motivoTipo + "' AND comp_numero = '" + numero + "'").getResultList());
        } else if (proceso.trim().equals("CONSUMO")) {
            invEstadoCCVT = inventario.helper.ConversionesInventario.convertirInvEstadoCCVTConsulta_InvEstadoCCVT(em.createNativeQuery("SELECT cons_pendiente, cons_anulado FROM inventario.inv_consumos WHERE "
                    + "cons_empresa = '" + empresa + "' AND cons_periodo = '" + periodo + "' "
                    + "AND cons_motivo = '" + motivoTipo + "' AND cons_numero = '" + numero + "'").getResultList());
        } else if (proceso.trim().equals("VENTA")) {
            invEstadoCCVT = inventario.helper.ConversionesInventario.convertirInvEstadoCCVTConsulta_InvEstadoCCVT(em.createNativeQuery("SELECT vta_pendiente, vta_anulado FROM inventario.inv_ventas WHERE "
                    + "vta_empresa = '" + empresa + "' AND vta_periodo = '" + periodo + "' "
                    + "AND vta_motivo = '" + motivoTipo + "' AND vta_numero = '" + numero + "'").getResultList());
        } else if (proceso.trim().equals("PROFORMA")) {
            invEstadoCCVT = inventario.helper.ConversionesInventario.convertirInvEstadoCCVTConsulta_InvEstadoCCVT(em.createNativeQuery("SELECT prof_pendiente, prof_anulado FROM inventario.inv_proformas WHERE "
                    + "prof_empresa = '" + empresa + "' AND prof_periodo = '" + periodo + "' "
                    + "AND prof_motivo = '" + motivoTipo + "' AND prof_numero = '" + numero + "'").getResultList());
        } else if (proceso.trim().equals("TRANSFERENCIA")) {
            invEstadoCCVT = inventario.helper.ConversionesInventario.convertirInvEstadoCCVTConsulta_InvEstadoCCVT(em.createNativeQuery("SELECT trans_pendiente, trans_anulado FROM inventario.inv_transferencias WHERE "
                    + "trans_empresa = '" + empresa + "' AND trans_periodo = '" + periodo + "' "
                    + "AND trans_motivo = '" + motivoTipo + "' AND trans_numero = '" + numero + "'").getResultList());
        } else if (proceso.trim().equals("CONTABLE")) {
            invEstadoCCVT = inventario.helper.ConversionesInventario.convertirInvEstadoCCVTConsulta_InvEstadoCCVT(em.createNativeQuery("SELECT con_pendiente, con_anulado, con_bloqueado, con_generado FROM contabilidad.con_contable "
                    + "WHERE con_empresa = '" + empresa + "' AND con_periodo = '" + periodo + "' AND con_tipo = '" + motivoTipo + "' AND con_numero = '" + numero + "'").getResultList());
        }
        return invEstadoCCVT;
    }

    public java.util.List<inventario.TO.InvProductoSincronizarTO> invProductoSincronizar(java.lang.String empresaOrigen, java.lang.String empresaDestino) throws java.lang.Exception {
        return inventario.helper.ConversionesInventario.convertirInvProductoSincronizar_InvProductoSincronizarTO(
                em.createNativeQuery("SELECT * from inventario.fun_sincronizar_productos('"
                + empresaOrigen + "', '"
                + empresaDestino + "');").getResultList());
    }

    public java.util.List<inventario.TO.InvCategoriaSincronizarTO> invCategoriasSincronizar(java.lang.String empresaOrigen, java.lang.String empresaDestino) throws java.lang.Exception {
        return inventario.helper.ConversionesInventario.convertirInvCategoriaSincronizar_InvCategoriaSincronizarTO(
                em.createNativeQuery("SELECT * from inventario.fun_sincronizar_categorias('"
                + empresaOrigen + "', '"
                + empresaDestino + "');").getResultList());
    }

    public java.util.List<inventario.TO.InvListadoPagosTO> invListadoPagosTO(String empresa, String periodo, String motivo, String numero) throws java.lang.Exception {
        return inventario.helper.ConversionesInventario.convertirInvListadoPagos_InvListadoPagosTO(
                em.createNativeQuery("SELECT * FROM cartera.fun_obtener_pagos('" + empresa + "', '" + periodo + "', '"
                + motivo + "', '" + numero + "')").getResultList());
    }

    public java.util.List<inventario.TO.InvListadoCobrosTO> invListadoCobrosTO(String empresa, String periodo, String motivo, String numero) throws java.lang.Exception {
        return inventario.helper.ConversionesInventario.convertirInvListadoCobros_InvListadoCobrosTO(
                em.createNativeQuery("SELECT * FROM cartera.fun_obtener_cobros('" + empresa + "', '" + periodo + "', '"
                + motivo + "', '" + numero + "')").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @param motivo
     * @param proveedor
     * @param documento
     * @return lista de InvFunComprasTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<InvFunComprasTO> getInvFunComprasTO(String empresa, String desde, String hasta, String motivo, String proveedor, String documento) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        motivo = motivo == null ? motivo : "'" + motivo + "'";
        proveedor = proveedor == null ? proveedor : "'" + proveedor + "'";
        documento = documento == null ? documento : "'" + documento + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunCompras_InvFunComprasTO(em.createNativeQuery("SELECT * FROM inventario.fun_compras('" + empresa + "', " + desde + ", " + hasta + ", " + motivo + ", " + proveedor + ", " + documento + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @param motivo
     * @param cliente
     * @param documento
     * @return lista de InvFunVentasTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<InvFunVentasTO> getInvFunVentasTO(String empresa, String desde, String hasta, String motivo, String cliente, String documento) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        motivo = motivo == null ? motivo : "'" + motivo + "'";
        cliente = cliente == null ? cliente : "'" + cliente + "'";
        documento = documento == null ? documento : "'" + documento + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunVentas_InvFunVentasTO(em.createNativeQuery("SELECT * FROM inventario.fun_ventas('" + empresa + "', " + desde + ", " + hasta + ", " + motivo + ", " + cliente + ", " + documento + ");").getResultList());
    }

    @Override
    public java.util.List<InvFunConsumosTO> getInvFunConsumosTO(String empresa, String desde, String hasta, String motivo) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        motivo = motivo == null ? motivo : "'" + motivo + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunConsumos_InvFunConsumosTO(em.createNativeQuery("SELECT * FROM inventario.fun_consumos('" + empresa + "', " + desde + ", " + hasta + ", " + motivo + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @param bodega
     * @param proveedor
     * @return lista de InvFunComprasConsolidandoProductosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<InvFunComprasConsolidandoProductosTO> getInvFunComprasConsolidandoProductosTO(String empresa, String desde, String hasta, String sector, String bodega, String proveedor) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        bodega = bodega == null ? bodega : "'" + bodega + "'";
        proveedor = proveedor == null ? proveedor : "'" + proveedor + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunComprasConsolidandoProductos_InvFunComprasConsolidandoProductosTO(em.createNativeQuery("SELECT * FROM inventario.fun_compras_consolidando_productos('" + empresa + "', " + desde + ", " + hasta + ", " + sector + ", " + bodega + ", " + proveedor + ");").getResultList());
    }

    @Override
    public java.util.List<inventario.TO.InvFunConsumosConsolidandoProductosTO> getInvFunConsumosConsolidandoProductosTO(String empresa, String desde, String hasta, String sector, String bodega) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        bodega = bodega == null ? bodega : "'" + bodega + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunConsumosConsolidandoProductos_InvFunConsumosConsolidandoProductosTO(em.createNativeQuery("SELECT * FROM inventario.fun_consumos_consolidando_productos('" + empresa + "', " + desde + ", " + hasta + ", " + sector + ", " + bodega + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @param bodega
     * @param cliente
     * @return lista de InvFunVentasConsolidandoProductosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<InvFunVentasConsolidandoProductosTO> getInvFunVentasConsolidandoProductosTO(String empresa, String desde, String hasta, String sector, String bodega, String cliente) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        bodega = bodega == null ? bodega : "'" + bodega + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        cliente = cliente == null ? cliente : "'" + cliente + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunVentasConsolidandoProductos_InvFunVentasConsolidandoProductosTO(em.createNativeQuery("SELECT * FROM inventario.fun_ventas_consolidando_productos('" + empresa + "', " + desde + ", " + hasta + ", " + sector + ", " + bodega + ", " + cliente + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @param bodega
     * @param cliente
     * @return lista de InvFunVentasVsCostoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<InvFunVentasVsCostoTO> getInvFunVentasVsCostoTO(String empresa, String desde, String hasta, String bodega, String cliente) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        bodega = bodega == null ? bodega : "'" + bodega + "'";
        cliente = cliente == null ? cliente : "'" + cliente + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunVentasVsCosto_InvFunVentasVsCostoTO(
                em.createNativeQuery("SELECT * FROM inventario.fun_ventas_vs_costo('"
                + empresa + "', "
                + desde + ", "
                + hasta + ", "
                + bodega + ", "
                + cliente + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param categoria
     * @param busqueda
     * @param cliente
     * @return lista de InvFunListadoProductosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<InvFunListadoProductosTO> getInvFunListadoProductosTO(String empresa, String categoria, String busqueda) throws Exception {
        categoria = categoria == null ? categoria : "'" + categoria + "'";
        busqueda = busqueda == null ? busqueda : "'" + busqueda + "'";
        String fecha = "'" + validaciones.Validacion.fechaSistema("yyyy-MM-dd") + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunListadoProductos_InvFunListadoProductosTO(
                em.createNativeQuery("SELECT * FROM inventario.fun_listado_productos('"
                + empresa + "', "
                + categoria + ", "
                + busqueda + ", "
                + fecha + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param categoria
     * @param cliente
     * @return lista de InvFunListadoClientesTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<InvFunListadoClientesTO> getInvFunListadoClientesTO(String empresa, String categoria) throws Exception {
        categoria = categoria == null ? categoria : "'" + categoria + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunListadoClientes_InvFunListadoClientesTO(
                em.createNativeQuery("SELECT * FROM inventario.fun_listado_clientes('"
                + empresa + "', "
                + categoria + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param categoria
     * @param cliente
     * @return lista de InvFunListadoProveedoresTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<InvFunListadoProveedoresTO> getInvFunListadoProveedoresTO(String empresa, String categoria) throws Exception {
        categoria = categoria == null ? categoria : "'" + categoria + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunListadoProveedores_InvFunListadoProveedoresTO(
                em.createNativeQuery("SELECT * FROM inventario.fun_listado_proveedores('"
                + empresa + "', "
                + categoria + ");").getResultList());
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @return El total de las compras por pagar del cliente en determinada
     * fecha
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.math.BigDecimal getInvVentaTotal(String empresa, String desde, String hasta, String cliente) throws Exception {
        java.math.BigDecimal cero = new java.math.BigDecimal("0.00");
        java.math.BigDecimal retorno = null;
        java.util.List lista = em.createNativeQuery("SELECT COALESCE(SUM(vta_total), 0.00) FROM inventario."
                + "fun_ventas('" + empresa + "', '" + desde + "', '" + hasta + "', NULL, '" + cliente + "', NULL) "
                + "WHERE not vta_pendiente AND not vta_anulado and vta_forma_pago = 'POR PAGAR'").getResultList();
        if (lista != null) {
            if (!lista.isEmpty()) {
                retorno = new java.math.BigDecimal(validaciones.ConvertirListaObject.convertirListToArray(lista, 0)[0].toString());
            } else {
                retorno = cero;
            }
        } else {
            retorno = cero;
        }
        return retorno;
    }

    /**
     * @autor Jack Krauser
     *
     * @param EMPRESA
     * @param PRODUCTO
     * @return
     * <code>true</code> o
     * <code>false</code>, si se puede o no eliminar el PRODUCTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public Boolean getPuedeEliminarProducto(String empresa, String producto) throws Exception {
        Boolean retorno = null;
        java.util.List lista = em.createNativeQuery("SELECT * FROM inventario.fun_sw_producto_eliminar('" + empresa + "', '" + producto + "')").getResultList();
        if (lista != null) {
            if (!lista.isEmpty()) {
                retorno = Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(lista, 0)[0].toString());
            } else {
                retorno = false;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }

    @Override
    public java.util.List<inventario.entity.InvVentas> getVentasParaContabilizar(String empresa, String sector, String fecha, String usuario) throws Exception {
        java.util.List<inventario.entity.InvVentas> invVentasConsulta = em.createQuery("SELECT inv FROM InvVentas inv WHERE "
                + "inv.invVentasPK.vtaEmpresa = :empresa AND inv.secCodigo = :sector AND inv.vtaFecha = :fecha "
                + "AND inv.usrCodigo = :usuario AND inv.vtaAnulado = false AND inv.vtaPendiente = false").
                setParameter("empresa", empresa).setParameter("sector", sector).setParameter("fecha", validaciones.Validacion.fecha(fecha, "yyyy-MM-dd")).setParameter("usuario", usuario).getResultList();
        java.util.List<inventario.entity.InvVentas> invVentas;
        if (invVentasConsulta != null) {
            if (!invVentasConsulta.isEmpty()) {
                invVentas = new java.util.ArrayList();
                for (int i = 0; i < invVentasConsulta.size(); i++) {
                    invVentas.add(inventario.helper.ConversionesInventario.convertirInvVentas_InvVentas(invVentasConsulta.get(i)));
                }
            } else {
                invVentas = null;
            }
        } else {
            invVentas = null;
        }

        return invVentas;
    }

    /**
     * @autor Jack Krauser, Yessica Salinas
     *
     * @param empresa El código de la empresa de la cual se quiere obtener la
     * información
     * @param codProducto El código del producto del cual se quiere obtener la
     * información
     * @param cantidad La cantidad de la que se quiere obtener el precio
     * @return El precio de acuerdo a la cantidad
     * @throws Exception Cualquier error inesperado
     */
    public java.math.BigDecimal getPrecioProductoPorCantidad(String empresa, String codProducto, java.math.BigDecimal cantidad) throws Exception {
        java.math.BigDecimal cero = new java.math.BigDecimal("0.00");
        java.math.BigDecimal retorno = null;
        java.util.List lista = em.createNativeQuery("SELECT * FROM inventario.fun_obtener_precio_venta('" + empresa + "', '" + codProducto + "', '" + cantidad + "')").getResultList();
        if (lista != null) {
            if (!lista.isEmpty()) {
                retorno = new java.math.BigDecimal(validaciones.ConvertirListaObject.convertirListToArray(lista, 0)[0] == null ? "0.00" : validaciones.ConvertirListaObject.convertirListToArray(lista, 0)[0].toString());
            } else {
                retorno = cero;
            }
        } else {
            retorno = cero;
        }
        return retorno;
    }

    public java.math.BigDecimal getCantidad3(String empresa, String codProducto) throws Exception {
        java.math.BigDecimal cero = new java.math.BigDecimal("0.00");
        java.math.BigDecimal retorno = null;
        java.util.List lista = em.createNativeQuery("SELECT pro_factor_caja_saco_bulto FROM inventario.inv_producto where (pro_empresa='" + empresa + "') and (pro_codigo_principal= '" + codProducto + "')").getResultList();
//        java.util.List lista= em.createNativeQuery("SELECT pro_cantidad3 FROM inventario.inv_producto where (pro_empresa='" + empresa + "') and (pro_codigo_principal= '" + codProducto + "')").getResultList();
        if (lista != null) {
            if (!lista.isEmpty()) {
                retorno = new java.math.BigDecimal(validaciones.ConvertirListaObject.convertirListToArray(lista, 0)[0] == null ? "0.00" : validaciones.ConvertirListaObject.convertirListToArray(lista, 0)[0].toString());
            } else {
                retorno = cero;
            }
        } else {
            retorno = cero;
        }

        return retorno;
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param fechaDesde
     * @param fechaHasta
     * @return lista de InvSecuenciaComprobanteTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<inventario.TO.InvSecuenciaComprobanteTO> getInvSecuenciaComprobanteTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception {
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return inventario.helper.ConversionesInventario.convertirInvSecuenciaComprobante_InvSecuenciaComprobanteTO(
                em.createNativeQuery(
                "SELECT inv_compras.comp_empresa || '|' || "
                + "inv_compras.comp_periodo || '|' || "
                + "inv_compras.comp_motivo || '|' || "
                + "inv_compras.comp_numero sec_compra, "
                + "CASE WHEN comp_anulado THEN NULL ELSE comp_fecha END sec_fecha, "
                + "CASE WHEN comp_anulado THEN 'ANULADO' ELSE comp_documento_numero END sec_comprobante, "
                + "CASE WHEN comp_anulado THEN NULL ELSE comp_total END sec_total_comprobante, "
                + "CASE WHEN comp_anulado THEN NULL ELSE comp_retencionnumero END sec_retencion, "
                + "CASE WHEN comp_anulado THEN NULL ELSE comp_valorretenido END sec_total_retencion, "
                + "CASE WHEN con_contable.con_anulado THEN 'ANULADO' "
                + "ELSE con_contable.con_empresa || '|' || "
                + "con_contable.con_periodo || '|' || "
                + "con_contable.con_tipo || '|' || "
                + "con_contable.con_numero END sec_contable "
                + "FROM inventario.inv_compras INNER JOIN anexo.anx_compra "
                + "ON inv_compras.comp_empresa = anx_compra.comp_empresa AND "
                + "inv_compras.comp_periodo = anx_compra.comp_periodo AND "
                + "inv_compras.comp_motivo = anx_compra.comp_motivo AND "
                + "inv_compras.comp_numero = anx_compra.comp_numero "
                + "LEFT JOIN contabilidad.con_contable "
                + "ON inv_compras.con_empresa = con_contable.con_empresa AND "
                + "inv_compras.con_periodo = con_contable.con_periodo AND "
                + "inv_compras.con_tipo = con_contable.con_tipo AND "
                + "inv_compras.con_numero = con_contable.con_numero "
                + "WHERE inv_compras.comp_empresa='"
                + empresa + "' AND comp_fecha>="
                + fechaDesde + " AND comp_fecha<="
                + fechaHasta + " ORDER BY 1;").getResultList());
    }

    /**
     * @autor Jack Krauser, Yessica Salinas
     *
     * @param empresa El código de la empresa de la cual se quiere obtener la
     * información
     * @return Una lista con información básica de los tipos de productos
     * @throws Exception Cualquier error inesperado
     */
    public java.util.List<inventario.TO.InvProductoTipoComboTO> getInvProductoTipoComboListadoTO(String empresa, String accion) throws Exception {
        if (accion.trim().equals("COMBO")) {
            return inventario.helper.ConversionesInventario.convertirInvProductoTipoCombo_InvProductoTipoComboTO(em.createNativeQuery("SELECT tip_codigo, tip_detalle, tip_tipo, tip_activo FROM inventario.inv_producto_tipo WHERE "
                    + "tip_empresa= ('" + empresa + "') AND tip_activo ORDER BY tip_codigo").getResultList());
        } else {
            return inventario.helper.ConversionesInventario.convertirInvProductoTipoCombo_InvProductoTipoComboTO(em.createNativeQuery("SELECT tip_codigo, tip_detalle, tip_tipo, tip_activo FROM inventario.inv_producto_tipo WHERE tip_empresa= ('" + empresa + "')").getResultList());
        }
    }

    public inventario.entity.InvProductoPresentacionUnidades buscarInvProductoPresentacionUnidades(String empresa, String codigo) throws Exception {
        return invProductoPresentacionUnidadesFacadeLocal.find(new inventario.entity.InvProductoPresentacionUnidadesPK(empresa, codigo));
    }

    public boolean comprobarInvProductoPresentacionUnidades(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM inventario.inv_producto_presentacion_unidades "
                + "WHERE (presu_empresa = '" + empresa + "' AND presu_codigo = '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public boolean comprobarEliminarInvProductoPresentacionUnidades(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT inventario.fun_sw_producto_presentacion_unidades_eliminar("
                + "'" + empresa + "', '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public inventario.entity.InvProductoMarca buscarInvProductoMarca(String empresa, String codigo) throws Exception {
        return invProductoMarcaFacadeLocal.find(new inventario.entity.InvProductoMarcaPK(empresa, codigo));
    }

    public boolean comprobarInvProductoMarca(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM inventario.inv_producto_marca "
                + "WHERE (mar_empresa = '" + empresa + "' AND mar_codigo = '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public boolean comprobarEliminarInvProductoMarca(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT inventario.fun_sw_producto_marca_eliminar("
                + "'" + empresa + "', '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public inventario.entity.InvVendedor buscarInvVendedor(String empresa, String codigo) throws Exception {
        return invVendedorFacadeLocal.find(new inventario.entity.InvVendedorPK(empresa, codigo));
    }

    public boolean comprobarInvVendedor(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM inventario.inv_vendedor "
                + "WHERE (vend_empresa = '" + empresa + "' AND vend_codigo = '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public boolean comprobarEliminarInvVendedor(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT inventario.fun_sw_vendedor_eliminar("
                + "'" + empresa + "', '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public inventario.entity.InvProductoPresentacionCajas buscarInvProductoPresentacionCajas(String empresa, String codigo) throws Exception {
        return invProductoPresentacionCajasFacadeLocal.find(new inventario.entity.InvProductoPresentacionCajasPK(empresa, codigo));
    }

    public boolean comprobarInvProductoPresentacionCajas(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM inventario.inv_producto_presentacion_cajas "
                + "WHERE (presc_empresa = '" + empresa + "' AND presc_codigo = '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public boolean comprobarEliminarInvProductoPresentacionCajas(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT inventario.fun_sw_producto_presentacion_cajas_eliminar("
                + "'" + empresa + "', '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public inventario.entity.InvProductoTipo buscarInvProductoTipo(String empresa, String codigo) throws Exception {
        return invProductoTipoFacadeLocal.find(new inventario.entity.InvProductoTipoPK(empresa, codigo));
    }

    public boolean comprobarInvProductoTipo(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM inventario.inv_producto_tipo "
                + "WHERE (tip_empresa = '" + empresa + "' AND tip_codigo = '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public boolean comprobarEliminarInvProductoTipo(String empresa, String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT inventario.fun_sw_producto_tipo_eliminar("
                + "'" + empresa + "', '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public inventario.entity.InvVentasComplemento buscarVentasComplemento(String empresa, String periodo, String motivo, String numero) throws java.lang.Exception {
        return inventario.helper.ConversionesInventario.convertirInvVentasComplemento_InvVentasComplemento(em.createNativeQuery("SELECT com_empresa, com_periodo, com_motivo, com_numero, com_documento_tipo, "
                + "com_documento_numero, vta_empresa, vta_periodo, vta_motivo, vta_numero FROM inventario.inv_ventas_complemento "
                + "WHERE com_empresa = '" + empresa + "' AND com_periodo = '" + periodo + "' AND com_motivo = '" + motivo + "' AND com_numero = '" + numero + "'").getResultList());
    }

    @Override
    public Boolean buscarConteoCliente(String empCodigo, String codigoCliente) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM "
                + "inventario.fun_sw_cliente_eliminar('" + empCodigo + "', '" + codigoCliente + "')").getResultList(), 0)[0].toString());
    }

    @Override
    public Boolean buscarConteoProveedor(String empCodigo, String codigoProveedor) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM "
                + "inventario.fun_sw_proveedor_eliminar('" + empCodigo + "', '" + codigoProveedor + "')").getResultList(), 0)[0].toString());
    }

    @Override
    public inventario.entity.InvComprasMotivoAnulacion buscarCompraMotivo(String empresa, String periodo, String motivo, String numero) throws Exception {
        return invComprasMotivoAnulacionFacadeLocal.find(new inventario.entity.InvComprasMotivoAnulacionPK(empresa, periodo, motivo, numero));
    }

    @Override
    public inventario.entity.InvVentasMotivoAnulacion buscarVentaMotivo(String empresa, String periodo, String motivo, String numero) throws Exception {
        return invVentasMotivoAnulacionFacadeLocal.find(new inventario.entity.InvVentasMotivoAnulacionPK(empresa, periodo, motivo, numero));
    }

    public java.util.List<inventario.TO.SaldoBodegaTO> getListaSaldoBodegaTO(String empresa, String bodega, String hasta, String categoria, boolean resumido ) throws Exception {
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        categoria = categoria == null ? categoria : "'" + categoria + "'";
        String sql = "SELECT * FROM inventario.fun_saldo_bodega('" + empresa + "', "
                + "'" + bodega + "', "+categoria+", " + hasta + ", "+resumido+")";
        return inventario.helper.ConversionesInventario.convertirListaSaldoBodega_ListaSaldoBodegaTO(em.createNativeQuery(sql).getResultList());
    }

    public java.util.List<inventario.TO.SaldoBodegaComprobacionTO> getInvFunSaldoBodegaComprobacionTO(String empresa, String bodega, String desde, String hasta) throws java.lang.Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        bodega = bodega == null ? bodega : "'" + bodega + "'";
        String sql ="SELECT * FROM inventario.fun_saldo_bodega_comprobacion("
                + "'" + empresa + "', " + bodega + ", " + desde + ", " + hasta + ");";
        return inventario.helper.ConversionesInventario.convertirInvFunSaldoBodegaComprobacion_InvFunSaldoBodegaComprobacionTO(
                em.createNativeQuery(sql).getResultList());
    }

    public List<SaldoBodegaComprobacionTO> getInvFunSaldoBodegaComprobacionCantidadesTO(String empresa, String bodega, String desde, String hasta) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        bodega = "'¬'".equals(bodega) ? bodega : "'" + bodega + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunSaldoBodegaComprobacion_InvFunSaldoBodegaComprobacionTO(
                em.createNativeQuery("SELECT * FROM inventario.fun_saldo_bodega_comprobacion_cantidades("
                + "'" + empresa + "', " + bodega + ", " + desde + ", " + hasta + ");").getResultList());
    }

    public InvProformaMotivoTO getInvProformasMotivoTO(String empresa, InvProformaMotivoTablaTO invProformaMotivoTablaTO) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvProformaMotivo_InvProformaMotivoTO(invProformasMotivoFacadeLocal.find(new inventario.entity.InvProformasMotivoPK(empresa, invProformaMotivoTablaTO.getpmCodigo())));
    }

    public InvProformasMotivo getInvProformasMotivo(String empresa, String codigo) throws Exception {
        return invProformasMotivoFacadeLocal.find(new inventario.entity.InvProformasMotivoPK(empresa, codigo));
    }

    public List<InvProformaMotivoTablaTO> getListaInvProformaMotivoTablaTO(String empresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirListaInvProformaMotivo_ListaInvProformasMotivoTO(
                em.createNativeQuery("SELECT pm_codigo, pm_detalle FROM inventario.inv_proformas_motivo "
                + "WHERE pm_empresa = ('" + empresa + "') ORDER BY pm_codigo").
                getResultList());
    }

    @Override
    public Boolean reconstruirCostos(String empCodigo, String Producto, String periodoHasta, Boolean periodoEstado) throws Exception {
        periodoHasta = periodoHasta == null ? periodoHasta : "'" + periodoHasta + "'";
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM "
                + "inventario.fun_reconstruir_costos('" + empCodigo + "', " + Producto + ", " + periodoHasta + ", " + periodoEstado + ")").getResultList(), 0)[0].toString());
    }

    @Override
    public inventario.entity.InvVendedor buscaInvVendedor(String empresa, String codigo) throws Exception {
        return invVendedorFacadeLocal.find(new inventario.entity.InvVendedorPK(empresa, codigo));
    }

    @Override
    public java.util.List<inventario.TO.InvVendedorComboListadoTO> getComboinvListaVendedorTOs(String codigoEmpresa) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvListaVendedor_invListaVendedorTOs(
                em.createNativeQuery("select * from inventario.inv_vendedor where usr_empresa = '" + codigoEmpresa + "'").getResultList());
    }

    @Override
    public java.util.List<inventario.TO.InvFunListaProductosImpresionPlacasTO> getInvFunListaProductosImpresionPlacasTO(String empresa, String producto, boolean estado) throws Exception {
        producto = producto == null ? producto : "'" + producto + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunListaProductosImpresionPlacas_InvFunListaProductosImpresionPlacasTO(em.createNativeQuery("SELECT * FROM inventario.fun_lista_productos_impresion_placas('" + empresa + "', " + producto + ", '" + validaciones.Validacion.fechaSistema() + "'," + estado + ");").getResultList());
    }

    @Override
    public java.util.List<inventario.TO.InvFunListaProductosSaldosGeneralTO> getInvFunListaProductosSaldosGeneralTO(String empresa, String producto, String fecha, boolean estado) throws Exception {
        producto = producto == null ? producto : "'" + producto + "'";
        fecha = fecha == null ? fecha : "'" + fecha + "'";

        return inventario.helper.ConversionesInventario.convertirInvFunListaProductosSaldosGeneral_InvFunListaProductosSaldosGeneralTO(em.createNativeQuery("SELECT * FROM inventario.fun_lista_productos_saldos_general('" + empresa + "', " + producto + ", " + fecha + ", " + estado + " );").getResultList());
        /*
         * return
         * inventario.helper.ConversionesInventario.convertirInvFunListaProductosSaldosGeneral_InvFunListaProductosSaldosGeneralTO(em.
         * createNativeQuery("SELECT * FROM
         * inventario.fun_lista_productos_saldos_general('AA','BROCHAS',
         * '2014-03-20', true)").getResultList());
         */
    }

    @Override
    public java.util.List<inventario.TO.InvFunUltimasComprasTO> getInvFunUltimasComprasTOs(java.lang.String empresa, java.lang.String producto) throws Exception {
        producto = producto == null ? "" : "'" + producto + "'";
        return inventario.helper.ConversionesInventario.convertirInvFunUltimasCompras_InvFunUltimasComprasTO(em.createNativeQuery("SELECT * FROM inventario.fun_ultimas_compras('" + empresa + "', " + producto + ");").getResultList());
    }

    @Override
    public inventario.TO.InvComprasTO getComprasTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvCompras_InvComprasTO(invComprasFacadeLocal.find(new inventario.entity.InvComprasPK(empresa, periodo, motivo, numeroCompra)));
    }

    public java.util.List<inventario.TO.InvComprasPorPeriodoTO> getComprasPorPeriodo(String empresa, 
            String codigoSector, String fechaInicio, String fechaFin, boolean chk) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";        

        //inventario.fun_compras_consolidando_productos_mensual('UTN', 'IN', '2015-05-15', '2015-11-30', false);        
        String sql = "SELECT * FROM inventario.fun_compras_consolidando_productos_mensual('" + empresa + "', " + codigoSector + ", "
                + fechaInicio + ", " + fechaFin + ", "+chk+");";
        
        
        return inventario.helper.ConversionesInventario.convertirInvComprasPorPeriodo_InvComprasPorPeriodoTO(em.createNativeQuery(
                sql).getResultList());
        
    }
}
