/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.DAO;

import anexos.entity.AnxVenta;
import contabilidad.entity.ConContable;
import inventario.entity.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import sistema.DAO.OperacionesSistemaDAOLocal;
import sistema.DAO.OperacionesSistemaDAOTransaccionLocal;
import sistema.TO.SisErrorTO;
import sistemaWeb.entity.SisSuceso;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesInventarioDAOTransaccion implements OperacionesInventarioDAOTransaccionLocal {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "EJBShrimpPU")
    private EntityManager em;
    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @EJB
    OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    @EJB
    OperacionesInventarioDAOLocal operacionesInventarioDAOLocal;
    public SisErrorTO sisErrorTO = null;

    private void guardarExcepciones(sistema.TO.SisErrorTO sisErrorTO, String empresaCodigo) throws Exception {
        operacionesSistemaDAOTransaccionLocal.insertarSisErrorTO(sisErrorTO, empresaCodigo);
    }

    /**
     * @autor misayo Metodo para ingresar, modificar o eliminar
     * invProveedorCategoria
     *
     * @param invProveedorCategoria
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionInvProveedorCategoria(inventario.entity.InvProveedorCategoria invProveedorCategoria, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception {
        if (accion == 'I') {
            em.persist(invProveedorCategoria);
        }
        if (accion == 'M') {
            em.merge(invProveedorCategoria);
        }
        if (accion == 'E') {
            em.remove(em.merge(invProveedorCategoria));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor misayo Metodo para ingresar, modificar o eliminar
     * invClienteCategoria
     *
     * @param invClienteCategoria
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionInvClienteCategoria(inventario.entity.InvClienteCategoria invClienteCategoria, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception {
        if (accion == 'I') {
            em.persist(invClienteCategoria);
        }
        if (accion == 'M') {
            em.merge(invClienteCategoria);
        }
        if (accion == 'E') {
            em.remove(em.merge(invClienteCategoria));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor misayo Metodo para ingresar, modificar o eliminar
     * invProductoCategoria
     *
     * @param invProductoCategoria
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionInvProductoCategoria(inventario.entity.InvProductoCategoria invProductoCategoria, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception {
        if (accion == 'I') {
            em.persist(invProductoCategoria);
        }
        if (accion == 'M') {
            em.merge(invProductoCategoria);
        }
        if (accion == 'E') {
            em.remove(em.merge(invProductoCategoria));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor misayo Metodo para ingresar, modificar o eliminar
     * invProductoCategoria
     *
     * @param invProductoMedida
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionInvProductoMedida(inventario.entity.InvProductoMedida invProductoMedida, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception {
        if (accion == 'I') {
            em.persist(invProductoMedida);
        }
        if (accion == 'M') {
            em.merge(invProductoMedida);
        }
        if (accion == 'E') {
            em.remove(em.merge(invProductoMedida));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarInvProducto(inventario.entity.InvProducto invProducto, sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvNumeracionVarios invNumeracionVarios) throws Exception {
         System.out.println("-----------------------DAO------------------------");
                                System.out.println("1   " + invProducto.getProCodigoBarra());
                                System.out.println("2   " + invProducto.getProCodigoBarra2());
                                System.out.println("3   " + invProducto.getProCodigoBarra3());
                                System.out.println("4   " + invProducto.getProCodigoBarra4());
                                System.out.println("5   " + invProducto.getProCodigoBarra5());
        
        em.persist(invProducto);
        em.persist(sisSuceso);
        if (invNumeracionVarios != null) {
            em.merge(invNumeracionVarios);
        }
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarInvProducto(inventario.entity.InvProducto invProducto, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
         System.out.println("-----------------------DAO------------------------");
                                System.out.println("1   " + invProducto.getProCodigoBarra());
                                System.out.println("2   " + invProducto.getProCodigoBarra2());
                                System.out.println("3   " + invProducto.getProCodigoBarra3());
                                System.out.println("4   " + invProducto.getProCodigoBarra4());
                                System.out.println("5   " + invProducto.getProCodigoBarra5());
        em.merge(invProducto);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarInvProductoLlavePrincipal(inventario.entity.InvProducto invProductoEliminar, inventario.entity.InvProducto invProducto, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(invProductoEliminar));
        em.merge(invProducto);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean eliminarInvProducto(inventario.entity.InvProducto invProducto, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(invProducto));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarInvCliente(inventario.entity.InvCliente invCliente, sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvNumeracionVarios invNumeracionVarios) throws Exception {
        em.persist(invCliente);
        em.persist(sisSuceso);
        if (invNumeracionVarios != null) {
            em.merge(invNumeracionVarios);
        }
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarInvCliente(inventario.entity.InvCliente invCliente, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.merge(invCliente);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean eliminarInvCliente(inventario.entity.InvCliente invCliente, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(invCliente));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarInvClienteLlavePrincipal(inventario.entity.InvCliente invClienteEliminar, inventario.entity.InvCliente invCliente, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(invClienteEliminar));
        em.merge(invCliente);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarInvProveedor(inventario.entity.InvProveedor invProveedor, sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvNumeracionVarios invNumeracionVarios) throws Exception {
        em.persist(invProveedor);
        em.persist(sisSuceso);
        if (invNumeracionVarios != null) {
            em.merge(invNumeracionVarios);
        }
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarInvProveedor(inventario.entity.InvProveedor invProveedor, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.merge(invProveedor);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarInvProveedorLlavePrincipal(inventario.entity.InvProveedor invProveedorEliminar, inventario.entity.InvProveedor invProveedor, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(invProveedorEliminar));
        em.merge(invProveedor);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarInvBodega(inventario.entity.InvBodega invBodega, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(invBodega);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarInvBodega(inventario.entity.InvBodega invBodega, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.merge(invBodega);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public boolean modificarInvCompras(
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
            boolean eliminarMotivoAnulacion) throws Exception {
        em.merge(invCompras);
        for (int i = 0; i < listaInvDetalle.size(); i++) {
            listaInvDetalle.get(i).setInvCompras(invCompras);
            em.merge(listaInvDetalle.get(i));
        }

        if (!listaInvDetalleEliminar.isEmpty()) {
            for (int i = 0; i < listaInvDetalleEliminar.size(); i++) {
                listaInvDetalleEliminar.get(i).setInvCompras(invCompras);
                em.remove(em.merge(listaInvDetalleEliminar.get(i)));
            }
        }
        if (operacionesSistemaDAOLocal.buscarEmpresaParametros(invCompras.getInvComprasPK().
                getCompEmpresa()).getParObligadoLlevarContabilidad()) {
            if (!invCompras.getCompDocumentoTipo().equals("00")) {
                if (invCompras.getCompDocumentoTipo().equals("04")) {
                    if (anxCompra != null) {
                        em.merge(anxCompra);
                        if (anxCompraFormaPago != null) {
                            for (int i = 0; i < anxCompraFormaPago.size(); i++) {
                                em.merge(anxCompraFormaPago.get(i));
                            }
                        }
                        if (anxCompraFormaPagoEliminar != null) {
                            for (int i = 0; i < anxCompraFormaPagoEliminar.size(); i++) {
                                em.merge(anxCompraFormaPagoEliminar.get(i));
                            }
                        }
                        if (anxCompraDetalle != null) {
                            for (int i = 0; i < anxCompraDetalle.size(); i++) {
                                em.merge(anxCompraDetalle.get(i));
                            }
                            for (int i = 0; i < anxCompraDividendos.size(); i++) {
                                em.merge(anxCompraDividendos.get(i));
                            }
                        }
                        if (anxCompraDetalleEliminar != null) {
                            for (int i = 0; i < anxCompraDetalleEliminar.size(); i++) {
                                em.remove(em.merge(anxCompraDetalleEliminar.get(i)));
                            }
                        }
                    }
                } else {
                    if (anxCompra != null) {
                        em.merge(anxCompra);
                        if (anxCompraFormaPago != null) {
                            for (int i = 0; i < anxCompraFormaPago.size(); i++) {
                                em.merge(anxCompraFormaPago.get(i));
                            }
                        }
                        if (anxCompraFormaPagoEliminar != null) {
                            for (int i = 0; i < anxCompraFormaPagoEliminar.size(); i++) {
                                em.remove(em.merge(anxCompraFormaPagoEliminar.get(i)));
                            }
                        }

                        if (anxCompraDetalle != null) {
                            for (int i = 0; i < anxCompraDetalle.size(); i++) {
                                em.merge(anxCompraDetalle.get(i));
                            }
                            for (int i = 0; i < anxCompraDividendos.size(); i++) {
                                em.merge(anxCompraDividendos.get(i));
                            }
                        }
                        if (anxCompraDetalleEliminar != null) {
                            for (int i = 0; i < anxCompraDetalleEliminar.size(); i++) {
                                em.remove(em.merge(anxCompraDetalleEliminar.get(i)));
                            }
                        }

                        if (invCompras.getCompDocumentoTipo().equals("41")) {
                            if (anxCompraReembolsos != null) {
                                for (int i = 0; i < anxCompraReembolsos.size(); i++) {
                                    em.merge(anxCompraReembolsos.get(i));
                                }
                            }
                            if (anxCompraReembolsoEliminar != null) {
                                for (int i = 0; i < anxCompraReembolsoEliminar.size(); i++) {
                                    em.remove(em.merge(anxCompraReembolsoEliminar.get(i)));
                                }
                            }

                        }

                    }
                }
            }
        }

        if (!listaInvProductoSaldos.isEmpty()) {
            for (int i = 0; i < listaInvProductoSaldos.size(); i++) {
                em.merge(listaInvProductoSaldos.get(i));
            }
        }

        if (conContable != null) {
            em.merge(conContable);
        }

        if (sisSuceso != null) {
            em.persist(sisSuceso);
        }

        if (!listaSisSuceso.isEmpty()) {
            for (int i = 0; i < listaSisSuceso.size(); i++) {
                em.merge(listaSisSuceso.get(i));
            }
        }

        if (eliminarMotivoAnulacion) {
            if (invComprasMotivoAnulacion != null) {
                em.remove(em.merge(invComprasMotivoAnulacion));
            }
        } else {
            if (invComprasMotivoAnulacion != null) {
                em.persist(invComprasMotivoAnulacion);
            }
        }

        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean modificarInvVentas(
            InvVentas invVentas,
            List<InvVentasDetalle> listaInvDetalle,
            List<InvVentasDetalle> listaInvDetalleEliminar,
            SisSuceso sisSuceso,
            List<SisSuceso> listaSisSuceso,
            List<InvProductoSaldos> listaInvProductoSaldos,
            ConContable conContable,
            AnxVenta anxVentas,
            InvVentasComplemento invVentasComplemento,
            String complemento,
            InvVentasMotivoAnulacion invVentasMotivoAnulacion,
            boolean eliminarMotivoAnulacion) throws Exception {

        em.merge(invVentas);
        for (int i = 0; i < listaInvDetalle.size(); i++) {
            listaInvDetalle.get(i).setInvVentas(invVentas);
            em.merge(listaInvDetalle.get(i));
        }

        if (!listaInvDetalleEliminar.isEmpty()) {
            for (int i = 0; i < listaInvDetalleEliminar.size(); i++) {
                listaInvDetalleEliminar.get(i).setInvVentas(invVentas);
                em.remove(em.merge(listaInvDetalleEliminar.get(i)));
            }
        }

        if (anxVentas != null) {
            em.merge(anxVentas);
        }

        if (!listaInvProductoSaldos.isEmpty()) {
            for (int i = 0; i < listaInvProductoSaldos.size(); i++) {
                em.merge(listaInvProductoSaldos.get(i));
            }
        }

        //revisasr merge
//        if (conContable != null) {
//            em.merge(conContable);
//        }

        if (sisSuceso != null) {
            em.persist(sisSuceso);
        }

        if (!listaSisSuceso.isEmpty()) {
            for (int i = 0; i < listaSisSuceso.size(); i++) {
                em.merge(listaSisSuceso.get(i));
            }
        }

        if (invVentasComplemento != null) {
            if (complemento.trim().equals("CREAR")) {
                invVentasComplemento.setInvVentas(invVentas);
                invVentasComplemento.setInvVentasComplementoPK(new InvVentasComplementoPK(invVentas.getInvVentasPK().getVtaEmpresa(),
                        invVentas.getInvVentasPK().getVtaPeriodo(), invVentas.getInvVentasPK().getVtaMotivo(), invVentas.getInvVentasPK().getVtaNumero()));
                em.persist(invVentasComplemento);
            } else if (complemento.trim().equals("MODIFICAR")) {
                invVentasComplemento.setInvVentas(invVentas);
                invVentasComplemento.setInvVentasComplementoPK(new InvVentasComplementoPK(invVentas.getInvVentasPK().getVtaEmpresa(),
                        invVentas.getInvVentasPK().getVtaPeriodo(), invVentas.getInvVentasPK().getVtaMotivo(), invVentas.getInvVentasPK().getVtaNumero()));
                em.merge(invVentasComplemento);
            } else if (complemento.trim().equals("ELIMINAR")) {
                invVentasComplemento.setInvVentas(invVentas);
                invVentasComplemento.setInvVentasComplementoPK(new InvVentasComplementoPK(invVentas.getInvVentasPK().getVtaEmpresa(),
                        invVentas.getInvVentasPK().getVtaPeriodo(), invVentas.getInvVentasPK().getVtaMotivo(), invVentas.getInvVentasPK().getVtaNumero()));
                em.remove(em.merge(invVentasComplemento));
            }
        }
        if (invVentasMotivoAnulacion != null) {
            if (eliminarMotivoAnulacion) {
                em.remove(em.merge(invVentasMotivoAnulacion));
            } else {
                em.persist(invVentasMotivoAnulacion);
            }
        }
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public boolean modificarInvProformas(inventario.entity.InvProformas invProformas,
            java.util.List<inventario.entity.InvProformasDetalle> listaInvDetalle,
            java.util.List<inventario.entity.InvProformasDetalle> listaInvDetalleEliminar,
            sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
    
        em.merge(invProformas);
        for (int i = 0; i < listaInvDetalle.size(); i++) {
            listaInvDetalle.get(i).setInvProformas(invProformas);
            em.merge(listaInvDetalle.get(i));
        }

        if (!listaInvDetalleEliminar.isEmpty()) {
            for (int i = 0; i < listaInvDetalleEliminar.size(); i++) {
                listaInvDetalleEliminar.get(i).setInvProformas(invProformas);
                em.remove(em.merge(listaInvDetalleEliminar.get(i)));
            }
        }

        if (sisSuceso != null) {
            em.persist(sisSuceso);
        }

        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public boolean modificarInvConsumos(inventario.entity.InvConsumos invConsumos,
            java.util.List<inventario.entity.InvConsumosDetalle> listaInvDetalle,
            java.util.List<inventario.entity.InvConsumosDetalle> listaInvDetalleEliminar,
            sistemaWeb.entity.SisSuceso sisSuceso, java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos,
            inventario.entity.InvConsumosMotivoAnulacion invConsumosMotivoAnulacion) throws Exception {
        em.merge(invConsumos);
        for (int i = 0; i < listaInvDetalle.size(); i++) {
            listaInvDetalle.get(i).setInvConsumos(invConsumos);
            em.merge(listaInvDetalle.get(i));
        }

        if (!listaInvDetalleEliminar.isEmpty()) {
            for (int i = 0; i < listaInvDetalleEliminar.size(); i++) {
                listaInvDetalleEliminar.get(i).setInvConsumos(invConsumos);
                em.remove(em.merge(listaInvDetalleEliminar.get(i)));
            }
        }

        if (!listaInvProductoSaldos.isEmpty()) {
            for (int i = 0; i < listaInvProductoSaldos.size(); i++) {
                em.merge(listaInvProductoSaldos.get(i));
            }
        }

        em.persist(sisSuceso);

        if (invConsumosMotivoAnulacion != null) {
            em.persist(invConsumosMotivoAnulacion);
        }

        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public void insertarInvCompra(
            inventario.entity.InvCompras invCompras,
            java.util.List<inventario.entity.InvComprasDetalle> listaInvComprasDetalle,
            sistemaWeb.entity.SisSuceso sisSuceso,
            inventario.entity.InvComprasNumeracion invComprasNumeracion,
            boolean nuevo,
            anexos.entity.AnxCompra anxCompra,
            java.util.List<anexos.entity.AnxCompraDetalle> anxCompraDetalle,
            java.util.List<anexos.entity.AnxCompraDividendo> anxCompraDividendos,
            java.util.List<anexos.entity.AnxCompraReembolso> anxCompraReembolso,
            java.util.List<anexos.entity.AnxCompraFormaPago> anxCompraFormaPago,
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos) throws Exception {
//        estadoTransaccion = false;
        em.persist(invCompras);
        for (int i = 0; i < listaInvComprasDetalle.size(); i++) {
            listaInvComprasDetalle.get(i).setInvCompras(invCompras);
            em.persist(listaInvComprasDetalle.get(i));
        }

        if (nuevo) {
            em.persist(invComprasNumeracion);
        } else {
            em.merge(invComprasNumeracion);
        }

        if (operacionesSistemaDAOLocal.buscarEmpresaParametros(invCompras.getInvComprasPK().getCompEmpresa()).getParObligadoLlevarContabilidad()) {
            if (!invCompras.getCompDocumentoTipo().equals("00")) {
                if (invCompras.getCompDocumentoTipo().equals("04")) {
                    if (anxCompra != null) {
                        em.persist(anxCompra);
                        for (int i = 0; i < anxCompraDetalle.size(); i++) {
                            
                            em.persist(anxCompraDetalle.get(i));
                        }
                        for (int i = 0; i < anxCompraDividendos.size(); i++) {
                            em.persist(anxCompraDividendos.get(i));
                        }
                        for (int i = 0; i < anxCompraFormaPago.size(); i++) {
                            em.persist(anxCompraFormaPago.get(i));
                        }
                    }
                } else {
                    em.persist(anxCompra);
                    for (int i = 0; i < anxCompraDetalle.size(); i++) {
                        em.persist(anxCompraDetalle.get(i));
                    }
                    for (int i = 0; i < anxCompraDividendos.size(); i++) {
                        em.persist(anxCompraDividendos.get(i));
                    }
                    for (int i = 0; i < anxCompraFormaPago.size(); i++) {
                        em.persist(anxCompraFormaPago.get(i));
                    }

                    for (int i = 0; i < anxCompraReembolso.size(); i++) {
                        em.persist(anxCompraReembolso.get(i));
                    }
                }
            }
        }
        if (!listaInvProductoSaldos.isEmpty()) {
            for (int i = 0; i < listaInvProductoSaldos.size(); i++) {
                em.merge(listaInvProductoSaldos.get(i));
            }
        }
        em.persist(sisSuceso);
        em.flush();
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public void insertarInvVenta(
            inventario.entity.InvVentas invVentas,
            java.util.List<inventario.entity.InvVentasDetalle> listaInvVentasDetalle,
            sistemaWeb.entity.SisSuceso sisSuceso,
            inventario.entity.InvVentasNumeracion invVentasNumeracion,
            boolean nuevo,
            anexos.entity.AnxVenta anxVenta,
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos,
            inventario.entity.InvVentasComplemento invVentasComplemento,
            anexos.entity.AnxVentaElectronica anxVentaElectronica)
            throws Exception {
        em.persist(invVentas);
        for (int i = 0; i < listaInvVentasDetalle.size(); i++) {
            listaInvVentasDetalle.get(i).setInvVentas(invVentas);
            em.persist(listaInvVentasDetalle.get(i));
        }
        if (nuevo) {
            em.persist(invVentasNumeracion);
        } else {
            em.merge(invVentasNumeracion);
        }

        if (anxVenta != null) {
            em.persist(anxVenta);
        }

        if (!listaInvProductoSaldos.isEmpty()) {
            for (int i = 0; i < listaInvProductoSaldos.size(); i++) {
                em.merge(listaInvProductoSaldos.get(i));
            }
        }

        if (invVentasComplemento != null) {
            invVentasComplemento.setInvVentas(invVentas);
            invVentasComplemento.setInvVentasComplementoPK(new inventario.entity.InvVentasComplementoPK(invVentas.getInvVentasPK().getVtaEmpresa(),
                    invVentas.getInvVentasPK().getVtaPeriodo(), invVentas.getInvVentasPK().getVtaMotivo(), invVentas.getInvVentasPK().getVtaNumero()));
            em.persist(invVentasComplemento);
        }
        if (anxVentaElectronica != null) {
            em.persist(anxVentaElectronica);
        }
        em.persist(sisSuceso);
        em.flush();
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public void insertarInvProforma(inventario.entity.InvProformas invProformas, java.util.List<inventario.entity.InvProformasDetalle> listaInvProformasDetalles,
            sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvProformasNumeracion invProformasNumeracion, boolean nuevo)
            throws Exception {
        em.persist(invProformas);
        for (int i = 0; i < listaInvProformasDetalles.size(); i++) {
            listaInvProformasDetalles.get(i).setInvProformas(invProformas);
            em.persist(listaInvProformasDetalles.get(i));
        }

        if (nuevo) {
            em.persist(invProformasNumeracion);
        } else {
            em.merge(invProformasNumeracion);
        }

        em.persist(sisSuceso);
        em.flush();
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public void insertarInvConsumos(inventario.entity.InvConsumos invConsumos, java.util.List<inventario.entity.InvConsumosDetalle> listaInvConsumosDetalle,
            sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvConsumosNumeracion invConsumosNumeracion, boolean nuevo,
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos) throws Exception {
        em.persist(invConsumos);
        for (int i = 0; i < listaInvConsumosDetalle.size(); i++) {
            listaInvConsumosDetalle.get(i).setInvConsumos(invConsumos);
            em.persist(listaInvConsumosDetalle.get(i));
        }
        if (nuevo) {
            em.persist(invConsumosNumeracion);
        } else {
            em.merge(invConsumosNumeracion);
        }

        if (!listaInvProductoSaldos.isEmpty()) {
            for (int i = 0; i < listaInvProductoSaldos.size(); i++) {
                em.merge(listaInvProductoSaldos.get(i));
            }
        }
        em.persist(sisSuceso);
        em.flush();
    }

    public boolean insertarTransaccionInvCompra(inventario.entity.InvCompras invCompras,
            java.util.List<inventario.entity.InvComprasDetalle> listaInvComprasDetalles,
            sistemaWeb.entity.SisSuceso sisSuceso,
            inventario.entity.InvComprasNumeracion invComprasNumeracion,
            anexos.entity.AnxCompra anxCompra,
            java.util.List<anexos.entity.AnxCompraDetalle> anxCompraDetalle,
            java.util.List<anexos.entity.AnxCompraDividendo> anxCompraDividendos,
            java.util.List<anexos.entity.AnxCompraReembolso> anxCompraReembolso,
            java.util.List<anexos.entity.AnxCompraFormaPago> anxCompraFormaPago,
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos) throws Exception {

        String rellenarConCeros = "";
        int numeracion = operacionesInventarioDAOLocal.buscarConteoUltimaNumeracionCompra(
                invCompras.getInvComprasPK().getCompEmpresa(),
                invCompras.getInvComprasPK().getCompPeriodo(),
                invCompras.getInvComprasPK().getCompMotivo());
        boolean nuevo = false, retorno = false;
        if (numeracion == 0) {
            nuevo = true;
        }
        do {
            numeracion++;
            int numeroCerosAponer = 7 - String.valueOf(numeracion).trim().length();
            rellenarConCeros = "";
            for (int i = 0; i < numeroCerosAponer; i++) {
                rellenarConCeros = rellenarConCeros + "0";
            }

            invCompras.setInvComprasPK(new inventario.entity.InvComprasPK(invCompras.getInvComprasPK().getCompEmpresa(), invCompras.getInvComprasPK().getCompPeriodo(), invCompras.getInvComprasPK().getCompMotivo(), rellenarConCeros + numeracion));
            invComprasNumeracion.setNumSecuencia(rellenarConCeros + numeracion);

        } while (operacionesInventarioDAOLocal.buscarInvCompras(invCompras.getInvComprasPK().getCompEmpresa(), invCompras.getInvComprasPK().
                getCompPeriodo(), invCompras.getInvComprasPK().getCompMotivo(),
                rellenarConCeros + numeracion) != null);
        sisSuceso.setSusClave(invCompras.getInvComprasPK().getCompPeriodo() + " "
                + invCompras.getInvComprasPK().getCompMotivo() + " "
                + invCompras.getInvComprasPK().getCompNumero());
        String detalle = "";
        if (invCompras.getCompDocumentoTipo().equals("00")) {
            detalle = "Compra a " + invCompras.getInvProveedor().getProvNombre() + " por " + invCompras.getCompTotal().toPlainString();
        } else {
            detalle = "Compra a " + invCompras.getInvProveedor().getProvNombre() + " según documento # " + invCompras.getCompDocumentoNumero() + " por $" + invCompras.getCompTotal().toPlainString();
        }
        sisSuceso.setSusDetalle(detalle.length() > 300 ? detalle.substring(0, 300) : detalle);
//        sisSuceso.setSusDetalle("Se insertó la compra en el periodo " +
//                        invCompras.getInvComprasPK().getCompPeriodo() + ", del motivo "
//                        + invCompras.getInvComprasPK().getCompMotivo() + ", de la numeración "
//                        + invCompras.getInvComprasPK().getCompNumero());

        ///// LLAMAR METODOS PARA INGRESAR
        boolean llenarAnexo = true;
        if (!invCompras.getCompDocumentoTipo().equals("00")) {
            if (invCompras.getCompDocumentoTipo().equals("04")) {
                if (anxCompra == null) {
                    llenarAnexo = false;
                }
            }
            if (!operacionesSistemaDAOLocal.buscarEmpresaParametros(invCompras.getInvComprasPK().
                    getCompEmpresa()).getParObligadoLlevarContabilidad()) {
                llenarAnexo = false;
            }
            if (llenarAnexo) {
                anxCompra.setAnxCompraPK(new anexos.entity.AnxCompraPK(invCompras.getInvComprasPK().
                        getCompEmpresa(), invCompras.getInvComprasPK().getCompPeriodo(), invCompras.getInvComprasPK().getCompMotivo(), invCompras.getInvComprasPK().getCompNumero()));
                for (int i = 0; i < anxCompraDetalle.size(); i++) {
                    anxCompraDetalle.get(i).setAnxCompra(anxCompra);
                }
                for (int i = 0; i < anxCompraDividendos.size(); i++) {
                    anxCompraDividendos.get(i).setAnxCompra(anxCompra);
                }
                for (int i = 0; i < anxCompraFormaPago.size(); i++) {
                    anxCompraFormaPago.get(i).setAnxCompra(anxCompra);
                }
                if (anxCompraReembolso != null && !anxCompraReembolso.isEmpty()) {
                    for (int i = 0; i < anxCompraReembolso.size(); i++) {
                        anxCompraReembolso.get(i).setAnxCompra(anxCompra);
                    }
                }
            }
        }
        insertarInvCompra(
                invCompras,
                listaInvComprasDetalles,
                sisSuceso,
                invComprasNumeracion,
                nuevo,
                anxCompra,
                anxCompraDetalle,
                anxCompraDividendos,
                anxCompraReembolso,
                anxCompraFormaPago,
                listaInvProductoSaldos);
        return true;
    }

    public boolean insertarTransaccionInvVenta(inventario.entity.InvVentas invVentas,
            java.util.List<inventario.entity.InvVentasDetalle> listaInvVentasDetalles,
            sistemaWeb.entity.SisSuceso sisSuceso,
            inventario.entity.InvVentasNumeracion invVentasNumeracion, anexos.entity.AnxVenta anxVenta,
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos,
            inventario.entity.InvVentasComplemento invVentasComplemento,
            anexos.entity.AnxVentaElectronica anxVentaElectronica) throws Exception {

        String rellenarConCeros = "";
        int numeracion = operacionesInventarioDAOLocal.buscarConteoUltimaNumeracionVenta(
                invVentas.getInvVentasPK().getVtaEmpresa(),
                invVentas.getInvVentasPK().getVtaPeriodo(),
                invVentas.getInvVentasPK().getVtaMotivo());
        boolean nuevo = false, retorno = false;
        if (numeracion == 0) {
            nuevo = true;
        }
        do {
            numeracion++;
            int numeroCerosAponer = 7 - String.valueOf(numeracion).trim().length();
            rellenarConCeros = "";
            for (int i = 0; i < numeroCerosAponer; i++) {
                rellenarConCeros = rellenarConCeros + "0";
            }

            invVentas.setInvVentasPK(new inventario.entity.InvVentasPK(invVentas.getInvVentasPK().getVtaEmpresa(), invVentas.getInvVentasPK().getVtaPeriodo(), invVentas.getInvVentasPK().getVtaMotivo(), rellenarConCeros + numeracion));
            invVentasNumeracion.setNumSecuencia(rellenarConCeros + numeracion);

        } while (operacionesInventarioDAOLocal.buscarInvVentas(invVentas.getInvVentasPK().getVtaEmpresa(), invVentas.getInvVentasPK().
                getVtaPeriodo(), invVentas.getInvVentasPK().getVtaMotivo(),
                rellenarConCeros + numeracion) != null);
        sisSuceso.setSusClave(invVentas.getInvVentasPK().getVtaPeriodo() + " "
                + invVentas.getInvVentasPK().getVtaMotivo() + " "
                + invVentas.getInvVentasPK().getVtaNumero());
        String detalle = "";
        if (invVentas.getVtaDocumentoTipo().equals("00")) {
            detalle = "Venta a " + invVentas.getInvCliente().getCliNombre() + " por " + invVentas.getVtaTotal().toPlainString();
        } else {
            detalle = "Venta a " + invVentas.getInvCliente().getCliNombre() + " según documento # " + invVentas.getVtaDocumentoNumero() + " por $" + invVentas.getVtaTotal().toPlainString();
        }
        sisSuceso.setSusDetalle(detalle.length() > 300 ? detalle.substring(0, 300) : detalle);

        if (anxVenta != null) {
            anxVenta.setAnxVentaPK(new anexos.entity.AnxVentaPK(invVentas.getInvVentasPK().
                    getVtaEmpresa(), invVentas.getInvVentasPK().getVtaPeriodo(), invVentas.getInvVentasPK().getVtaMotivo(), invVentas.getInvVentasPK().getVtaNumero()));
        }
        if (anxVentaElectronica != null) {
            anxVentaElectronica.setVtaNumero(invVentas.getInvVentasPK().getVtaNumero());
            anxVentaElectronica.setVtaEmpresa(invVentas.getInvVentasPK().getVtaEmpresa());
            anxVentaElectronica.setVtaPeriodo(invVentas.getInvVentasPK().getVtaPeriodo());
            anxVentaElectronica.setVtaMotivo(invVentas.getInvVentasPK().getVtaMotivo());
            anxVentaElectronica.setVtaNumero(invVentas.getInvVentasPK().getVtaNumero());

        }
        insertarInvVenta(
                invVentas,
                listaInvVentasDetalles,
                sisSuceso,
                invVentasNumeracion,
                nuevo,
                anxVenta,
                listaInvProductoSaldos,
                invVentasComplemento,
                anxVentaElectronica);
        return true;
    }

    public boolean insertarTransaccionInvConsumos(inventario.entity.InvConsumos invConsumos,
            java.util.List<inventario.entity.InvConsumosDetalle> listaInvConsumosDetalles,
            sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvConsumosNumeracion invConsumosNumeracion,
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos) throws Exception {

        String rellenarConCeros = "";
        int numeracion = operacionesInventarioDAOLocal.buscarConteoUltimaNumeracionConsumo(
                invConsumos.getInvConsumosPK().getConsEmpresa(),
                invConsumos.getInvConsumosPK().getConsPeriodo(),
                invConsumos.getInvConsumosPK().getConsMotivo());
        boolean nuevo = false, retorno = false;
        if (numeracion == 0) {
            nuevo = true;
        }
        do {
            numeracion++;
            int numeroCerosAponer = 7 - String.valueOf(numeracion).trim().length();
            rellenarConCeros = "";
            for (int i = 0; i < numeroCerosAponer; i++) {
                rellenarConCeros = rellenarConCeros + "0";
            }

            invConsumos.setInvConsumosPK(new inventario.entity.InvConsumosPK(invConsumos.getInvConsumosPK().getConsEmpresa(), invConsumos.getInvConsumosPK().getConsPeriodo(), invConsumos.getInvConsumosPK().getConsMotivo(), rellenarConCeros + numeracion));
            invConsumosNumeracion.setNumSecuencia(rellenarConCeros + numeracion);

        } while (operacionesInventarioDAOLocal.buscarInvConsumos(invConsumos.getInvConsumosPK().getConsEmpresa(), invConsumos.getInvConsumosPK().
                getConsPeriodo(), invConsumos.getInvConsumosPK().getConsMotivo(),
                rellenarConCeros + numeracion) != null);

        sisSuceso.setSusClave(invConsumos.getInvConsumosPK().getConsPeriodo() + " "
                + invConsumos.getInvConsumosPK().getConsMotivo() + " "
                + invConsumos.getInvConsumosPK().getConsNumero());

        String detalle = "Consumo por " + invConsumos.getConsObservaciones();
        sisSuceso.setSusDetalle(detalle.trim().length() > 300 ? detalle.trim().substring(0, 300) : detalle);
//        sisSuceso.setSusDetalle("Se insertó el consumo en el periodo " +
//                        invConsumos.getInvConsumosPK().getConsPeriodo() + ", del motivo "
//                        + invConsumos.getInvConsumosPK().getConsMotivo() + ", de la numeración "
//                        + invConsumos.getInvConsumosPK().getConsNumero());

        ///// LLAMAR METODOS PARA INGRESAR
        insertarInvConsumos(invConsumos, listaInvConsumosDetalles, sisSuceso, invConsumosNumeracion, nuevo, listaInvProductoSaldos);
        return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    // <editor-fold defaultstate="collapsed" desc="COMPRASFORMAPAGO">
    /**
     * @autor misayo Metodo para ingresar, modificar o eliminar ComprasFormaPago
     *
     * @param invComprasFormaPago
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionInvComprasFormaPago(inventario.entity.InvComprasFormaPago invComprasFormaPago, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception {
        if (accion == 'I') {
            em.persist(invComprasFormaPago);
        }
        if (accion == 'M') {
            em.merge(invComprasFormaPago);
        }
        if (accion == 'E') {
            em.remove(em.merge(invComprasFormaPago));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VENTASFORMAPAGO">
    /**
     * @autor misayo Metodo para ingresar, modificar o eliminar ventasFormaPago
     *
     * @param invVentasFormaPago
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionInvVentasFormaPago(inventario.entity.InvVentasFormaPago invVentasFormaPago, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception {
        if (accion == 'I') {
            em.persist(invVentasFormaPago);
        }
        if (accion == 'M') {
            em.merge(invVentasFormaPago);
        }
        if (accion == 'E') {
            em.remove(em.merge(invVentasFormaPago));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONSUMOSMOTIVO">
    /**
     * @autor misayo Metodo para ingresar ConsumosMotrivo
     *
     * @param invConsumosMotivo
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean insertarInvConsumosMotivo(inventario.entity.InvConsumosMotivo invConsumosMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(invConsumosMotivo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor misayo Metodo para modificar ConsumosMotivo
     *
     * @param invConsumosMotivo
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean modificarInvConsumosMotivo(inventario.entity.InvConsumosMotivo invConsumosMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.merge(invConsumosMotivo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor misayo Metodo para eliminar ConsumosMotivo
     *
     * @param invConsumosMotivo
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean eliminarInvConsumosMotivo(inventario.entity.InvConsumosMotivo invConsumosMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.remove(invConsumosMotivo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor misayo Metodo para ingresar, modificar o eliminar
     * InvConsumosMotivo
     *
     * @param invConsumosMotivo
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionInvConsumosMotivo(inventario.entity.InvConsumosMotivo invConsumosMotivo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception {
        if (accion == 'I') {
            em.persist(invConsumosMotivo);
        }
        if (accion == 'M') {
            em.merge(invConsumosMotivo);
        }
        if (accion == 'E') {
            em.remove(em.merge(invConsumosMotivo));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    // </editor-fold>
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarInvComprasMotivo(inventario.entity.InvComprasMotivo invComprasMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(invComprasMotivo);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarInvComprasMotivo(inventario.entity.InvComprasMotivo invComprasMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(invComprasMotivo);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarInvVentasMotivo(inventario.entity.InvVentasMotivo invVentasMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(invVentasMotivo);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarInvVentasMotivo(inventario.entity.InvVentasMotivo invVentasMotivo, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(invVentasMotivo);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarModificarinvComprasRecepcion(inventario.entity.InvComprasRecepcion invComprasRecepcion, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(invComprasRecepcion);
        em.flush();
        return true;
    }

    public boolean insertarTransaccionInvTransferencias(inventario.entity.InvTransferencias invTransferencias,
            java.util.List<inventario.entity.InvTransferenciasDetalle> listaInvTransferenciasDetalles,
            sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvTransferenciasNumeracion invTransferenciasNumeracion,
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosOrigen,
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosDestino) throws Exception {

        String rellenarConCeros = "";
        int numeracion = operacionesInventarioDAOLocal.buscarConteoUltimaNumeracionTransferencias(
                invTransferencias.getInvTransferenciasPK().getTransEmpresa(),
                invTransferencias.getInvTransferenciasPK().getTransPeriodo(),
                invTransferencias.getInvTransferenciasPK().getTransMotivo());
        boolean nuevo = false, retorno = false;
        if (numeracion == 0) {
            nuevo = true;
        }
        do {
            numeracion++;
            int numeroCerosAponer = 7 - String.valueOf(numeracion).trim().length();
            rellenarConCeros = "";
            for (int i = 0; i < numeroCerosAponer; i++) {
                rellenarConCeros = rellenarConCeros + "0";
            }

            invTransferencias.setInvTransferenciasPK(new inventario.entity.InvTransferenciasPK(invTransferencias.getInvTransferenciasPK().getTransEmpresa(), invTransferencias.getInvTransferenciasPK().getTransPeriodo(), invTransferencias.getInvTransferenciasPK().getTransMotivo(), rellenarConCeros + numeracion));
            invTransferenciasNumeracion.setNumSecuencia(rellenarConCeros + numeracion);

        } while (operacionesInventarioDAOLocal.buscarInvConsumos(invTransferencias.getInvTransferenciasPK().getTransEmpresa(), invTransferencias.getInvTransferenciasPK().
                getTransPeriodo(), invTransferencias.getInvTransferenciasPK().getTransMotivo(),
                rellenarConCeros + numeracion) != null);
        sisSuceso.setSusClave(invTransferencias.getInvTransferenciasPK().getTransPeriodo() + " "
                + invTransferencias.getInvTransferenciasPK().getTransMotivo() + " "
                + invTransferencias.getInvTransferenciasPK().getTransNumero());
        sisSuceso.setSusDetalle("Se insertó la transferencia en el periodo "
                + invTransferencias.getInvTransferenciasPK().getTransPeriodo() + ", del motivo "
                + invTransferencias.getInvTransferenciasPK().getTransMotivo() + ", de la numeración "
                + invTransferencias.getInvTransferenciasPK().getTransNumero());

        ///// LLAMAR METODOS PARA INGRESAR
        insertarInvTransferencias(invTransferencias, listaInvTransferenciasDetalles, sisSuceso, invTransferenciasNumeracion, nuevo, listaInvProductoSaldosOrigen, listaInvProductoSaldosDestino);
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public void insertarInvTransferencias(inventario.entity.InvTransferencias invTransferencias, java.util.List<inventario.entity.InvTransferenciasDetalle> listaInvTransferenciasDetalle,
            sistemaWeb.entity.SisSuceso sisSuceso, inventario.entity.InvTransferenciasNumeracion invTransferenciasNumeracion, boolean nuevo,
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosOrigen, java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosDestino) throws Exception {
        em.persist(invTransferencias);
        for (int i = 0; i < listaInvTransferenciasDetalle.size(); i++) {
            listaInvTransferenciasDetalle.get(i).setInvTransferencias(invTransferencias);
            em.persist(listaInvTransferenciasDetalle.get(i));
        }

        if (nuevo) {
            em.persist(invTransferenciasNumeracion);
        } else {
            em.merge(invTransferenciasNumeracion);
        }

        if (!listaInvProductoSaldosOrigen.isEmpty()) {
            for (int i = 0; i < listaInvProductoSaldosOrigen.size(); i++) {
                em.merge(listaInvProductoSaldosOrigen.get(i));
            }
        }
        if (!listaInvProductoSaldosDestino.isEmpty()) {
            for (int i = 0; i < listaInvProductoSaldosDestino.size(); i++) {
                em.merge(listaInvProductoSaldosDestino.get(i));
            }
        }
        em.persist(sisSuceso);
        em.flush();
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public boolean modificarInvTransferencias(inventario.entity.InvTransferencias invTransferencias,
            java.util.List<inventario.entity.InvTransferenciasDetalle> listaInvDetalle,
            java.util.List<inventario.entity.InvTransferenciasDetalle> listaInvDetalleEliminar,
            sistemaWeb.entity.SisSuceso sisSuceso, java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosOrigen,
            java.util.List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosDestino,
            inventario.entity.InvTransferenciasMotivoAnulacion invTransferenciasMotivoAnulacion) throws Exception {
        em.merge(invTransferencias);
        for (int i = 0; i < listaInvDetalle.size(); i++) {
            listaInvDetalle.get(i).setInvTransferencias(invTransferencias);
            em.merge(listaInvDetalle.get(i));
        }

        if (!listaInvDetalleEliminar.isEmpty()) {
            for (int i = 0; i < listaInvDetalleEliminar.size(); i++) {
                listaInvDetalleEliminar.get(i).setInvTransferencias(invTransferencias);
                em.remove(em.merge(listaInvDetalleEliminar.get(i)));
            }
        }

        if (!listaInvProductoSaldosOrigen.isEmpty()) {
            for (int i = 0; i < listaInvProductoSaldosOrigen.size(); i++) {
                em.merge(listaInvProductoSaldosOrigen.get(i));
            }
        }
        if (!listaInvProductoSaldosDestino.isEmpty()) {
            for (int i = 0; i < listaInvProductoSaldosDestino.size(); i++) {
                em.merge(listaInvProductoSaldosDestino.get(i));
            }
        }

        em.persist(sisSuceso);

        if (invTransferenciasMotivoAnulacion != null) {
            em.persist(invTransferenciasMotivoAnulacion);
        }

        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionInvTransferenciasMotivo(inventario.entity.InvTransferenciasMotivo invTransferenciasMotivo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception {
        if (accion == 'I') {
            em.persist(invTransferenciasMotivo);
        }
        if (accion == 'M') {
            em.merge(invTransferenciasMotivo);
        }
        if (accion == 'E') {
            em.remove(em.merge(invTransferenciasMotivo));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean invCambiarPrecioProductos(java.util.List<inventario.entity.InvProducto> invProductos, java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos) throws Exception {
        for (inventario.entity.InvProducto invProducto : invProductos) {
            em.merge(invProducto);
        }
        for (sistemaWeb.entity.SisSuceso sisSuceso : sisSucesos) {
            em.merge(sisSuceso);
        }
//        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean invSincronizarProductosCategorias(
            java.util.List<inventario.entity.InvProducto> invProductos,
            java.util.List<inventario.entity.InvProductoCategoria> invProductoCategorias,
            java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos) throws Exception {
        for (inventario.entity.InvProducto invProducto : invProductos) {
            em.merge(invProducto);
        }
        for (inventario.entity.InvProductoCategoria invProductoCategoria : invProductoCategorias) {
            em.merge(invProductoCategoria);
        }
        for (sistemaWeb.entity.SisSuceso sisSuceso : sisSucesos) {
            em.merge(sisSuceso);
        }
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionInvProductoPresentacionUnidades(inventario.entity.InvProductoPresentacionUnidades invProductoPresentacionUnidades, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception {
        if (accion == 'I') {
            em.persist(invProductoPresentacionUnidades);
        }
        if (accion == 'M') {
            em.merge(invProductoPresentacionUnidades);
        }
        if (accion == 'E') {
            em.remove(em.merge(invProductoPresentacionUnidades));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionInvProductoMarca(inventario.entity.InvProductoMarca invProductoMarca, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception {
        if (accion == 'I') {
            em.persist(invProductoMarca);
        }
        if (accion == 'M') {
            em.merge(invProductoMarca);
        }
        if (accion == 'E') {
            em.remove(em.merge(invProductoMarca));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionInvVendedor(inventario.entity.InvVendedor invVendedor, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception {
        if (accion == 'I') {
            em.persist(invVendedor);
        }
        if (accion == 'M') {
            em.merge(invVendedor);
        }
        if (accion == 'E') {
            em.remove(em.merge(invVendedor));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionInvProductoPresentacionCajas(inventario.entity.InvProductoPresentacionCajas invProductoPresentacionCajas, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception {
        if (accion == 'I') {
            em.persist(invProductoPresentacionCajas);
        }
        if (accion == 'M') {
            em.merge(invProductoPresentacionCajas);
        }
        if (accion == 'E') {
            em.remove(em.merge(invProductoPresentacionCajas));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor Jack Krauser, Yessica Salinas Metodo para ingresar, modificar o
     * eliminar invProductoTipo
     *
     * @param invProductoTipo
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionInvProductoTipo(inventario.entity.InvProductoTipo invProductoTipo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception {
        if (accion == 'I') {
            em.persist(invProductoTipo);
        }
        if (accion == 'M') {
            em.merge(invProductoTipo);
        }
        if (accion == 'E') {
            em.remove(em.merge(invProductoTipo));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    public boolean insertarInvProformaMotivo(InvProformasMotivo invProformasMotivo, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(invProformasMotivo);
        em.flush();
        return true;
    }

    public boolean modificarInvProformaMotivo(InvProformasMotivo invProformaMotivo, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(invProformaMotivo);
        em.flush();
        return true;
    }

    public boolean insertarTransaccionInvProformas(InvProformas invProformas, List<InvProformasDetalle> listaInvProformasDetalles, SisSuceso sisSuceso, InvProformasNumeracion invProformasNumeracion) throws Exception {
        String rellenarConCeros = "";
        int numeracion = operacionesInventarioDAOLocal.buscarConteoUltimaNumeracionProforma(
                invProformas.getInvProformasPK().getProfEmpresa(),
                invProformas.getInvProformasPK().getProfPeriodo(),
                invProformas.getInvProformasPK().getProfMotivo());
        boolean nuevo = false;
        if (numeracion == 0) {
            nuevo = true;
        }

        numeracion++;
        int numeroCerosAponer = 7 - String.valueOf(numeracion).trim().length();
        rellenarConCeros = "";
        for (int i = 0; i < numeroCerosAponer; i++) {
            rellenarConCeros = rellenarConCeros + "0";
        }

        invProformas.setInvProformasPK(new inventario.entity.InvProformasPK(invProformas.getInvProformasPK().getProfEmpresa(), invProformas.getInvProformasPK().getProfPeriodo(), invProformas.getInvProformasPK().getProfMotivo(), rellenarConCeros + numeracion));
        invProformasNumeracion.setNumSecuencia(rellenarConCeros + numeracion);


        sisSuceso.setSusClave(invProformas.getInvProformasPK().getProfPeriodo() + " "
                + invProformas.getInvProformasPK().getProfMotivo() + " "
                + invProformas.getInvProformasPK().getProfNumero());
        String detalle = "Proforma con el cliente: " + invProformas.getInvCliente().getCliNombre();


        sisSuceso.setSusDetalle(detalle.length() > 300 ? detalle.substring(0, 300) : detalle);
//        sisSuceso.setSusDetalle("Se insertó la venta en el periodo " +
//                invVentas.getInvVentasPK().getVtaPeriodo() + ", del motivo "
//                + invVentas.getInvVentasPK().getVtaMotivo() + ", de la numeración "
//                + invVentas.getInvVentasPK().getVtaNumero());

        insertarInvProforma(invProformas, listaInvProformasDetalles, sisSuceso, invProformasNumeracion, nuevo);
        return true;
    }
}
