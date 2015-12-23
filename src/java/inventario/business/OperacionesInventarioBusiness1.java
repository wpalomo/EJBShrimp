/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.business;

import anexos.TO.*;
import banco.DAO.OperacionesBancoDAOLocal;
import banco.DAO.OperacionesBancoDAOTransaccionLocal;
import banco.TO.BanChequeTO;
import banco.entity.BanCheque;
import banco.helper.ConversionesBanco;
import contabilidad.TO.ConDetalleTO;
import contabilidad.TO.ConFunContabilizarComprasDetalleTO;

import contabilidad.entity.ConContablePK;
import contabilidad.entity.ConDetalle;
import helper.RetornoTO;

import inventario.TO.*;
import inventario.entity.InvComprasMotivoAnulacion;
import inventario.entity.InvProductoSaldos;
import inventario.entity.InvVentasMotivoAnulacion;
import inventario.helper.ConversionesInventario;
import inventario.reporte.*;
import java.io.File;
import java.math.BigDecimal;
import java.sql.SQLDataException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;

import sistema.TO.SisInfoTO;
import sistema.TO.SisListaPeriodoTO;
import sistema.TO.SisUsuarioEmpresaTO;
import sistemaWeb.entity.SisSuceso;
import validaciones.Validacion;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesInventarioBusiness1 implements OperacionesInventarioBusinessLocal1 {

    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @javax.ejb.EJB
    OperacionesBancoDAOLocal operacionesBancoDAOLocal;
    @javax.ejb.EJB
    OperacionesBancoDAOTransaccionLocal operacionesBancoDAOTransaccionLocal;
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    @javax.ejb.EJB
    inventario.DAO.OperacionesInventarioDAOLocal operacionesInventarioDAOLocal;
    @javax.ejb.EJB
    inventario.DAO.OperacionesInventarioDAOTransaccionLocal operacionesInventarioDAOTransaccionLocal;
    @javax.ejb.EJB
    contabilidad.DAO.OperacionesContabilidadDAOLocal operacionesContabilidadDAOLocal;
    @javax.ejb.EJB
    contabilidad.DAO.OperacionesContabilidadDAOTransaccionLocal operacionesContabilidadDAOTransaccionLocal;
    @javax.ejb.EJB
    anexos.DAO.OperacionesAnexoDAOLocal operacionesAnexoDAOLocal;
    @javax.ejb.EJB
    produccion.DAO.OperacionesProduccionDAOLocal operacionesProduccionDAOLocal;
    @javax.ejb.EJB
    cartera.DAO.OperacionesCarDAOLocal operacionesCarDAOLocal;
    @javax.ejb.EJB
    anexos.DAO.OperacionesAnexoDAOTransaccionLocal operacionesAnexoDAOTransaccionLocal;
    @javax.ejb.EJB
    inventario.reporte.GenerarReporteInventarioLocal generarReporteInventarioLocal;
    boolean comprobar = false;
    private String mensaje;
    public sistema.TO.SisErrorTO sisErrorTO = null;
    private java.math.BigDecimal cero = new java.math.BigDecimal("0.00");
    private String susTabla;
    private String susClave;
    private String susSuceso;
    private String susDetalle;

    // <editor-fold defaultstate="collapsed" desc="PROVEEDOR CATEGORIA">
    public List<inventario.TO.InvProveedorCategoriaTO> getInvProveedorCategoriaTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getInvProveedorCategoriaTO(empresa);
    }

    @Override
    public String accionInvProveedorCategoria(inventario.TO.InvProveedorCategoriaTO invProveedorCategoriaTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = invProveedorCategoriaTO.getPcCodigo() + " : " + invProveedorCategoriaTO.getPcDetalle();
            if (accion == 'I') {
                susDetalle = "Se insertó categoría Proveedor " + invProveedorCategoriaTO.getPcDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó categoría Proveedor " + invProveedorCategoriaTO.getPcDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó categoría Proveedor " + invProveedorCategoriaTO.getPcDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_proveedor_categ";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invProveedorCategoria
            invProveedorCategoriaTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
            inventario.entity.InvProveedorCategoria invProveedorCategoria = inventario.helper.ConversionesInventario.convertirInvProveedorCategoriaTO_InvProveedorCategoria(invProveedorCategoriaTO);

            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProveedorCategoria(
                        invProveedorCategoriaTO.getPcEmpresa(),
                        invProveedorCategoriaTO.getPcCodigo())) {
                    if (operacionesInventarioDAOLocal.comprobarEliminarInvProveedorCategoria(
                            invProveedorCategoriaTO.getPcEmpresa(),
                            invProveedorCategoriaTO.getPcCodigo())) {
                        invProveedorCategoria.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarInvProveedorCategoria(
                                invProveedorCategoriaTO.getPcEmpresa(),
                                invProveedorCategoriaTO.getPcCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProveedorCategoria(invProveedorCategoria, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se puede eliminar, la Categoría ya tiene Proveedores...";
                    }
                } else {
                    mensaje = "FNo se encuentra la Categoría Proveedor...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProveedorCategoria(
                        invProveedorCategoriaTO.getPcEmpresa(),
                        invProveedorCategoriaTO.getPcCodigo())) {
                    invProveedorCategoria.setUsrFechaInserta(
                            operacionesInventarioDAOLocal.buscarInvProveedorCategoria(
                            invProveedorCategoriaTO.getPcEmpresa(),
                            invProveedorCategoriaTO.getPcCodigo()).getUsrFechaInserta());
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProveedorCategoria(invProveedorCategoria, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra la Categoría Proveedor...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesInventarioDAOLocal.comprobarInvProveedorCategoria(
                        invProveedorCategoriaTO.getPcEmpresa(),
                        invProveedorCategoriaTO.getPcCodigo())) {
                    invProveedorCategoria.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProveedorCategoria(invProveedorCategoria, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe la Categoría Proveedor...";
                }
            }

            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente la Categoría Proveedor";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la Categoría Proveedor";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la Categoría Proveedor";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la Categoría " + invProveedorCategoriaTO.getPcDetalle() + ", inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvProveedorCategoria",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CLIENTE CATEGORIA">
    public List<inventario.TO.InvClienteCategoriaTO> getInvClienteCategoriaTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getInvClienteCategoriaTO(empresa);
    }

    @Override
    public String accionInvClienteCategoria(inventario.TO.InvClienteCategoriaTO invClienteCategoriaTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;

        try {
            ///// CREANDO Suceso
            susClave = invClienteCategoriaTO.getCcCodigo() + " : " + invClienteCategoriaTO.getCcDetalle();
            if (accion == 'I') {
                susDetalle = "Se insertó categoría cliente " + invClienteCategoriaTO.getCcDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó categoría cliente " + invClienteCategoriaTO.getCcDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó categoría cliente " + invClienteCategoriaTO.getCcDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_cliente_categor";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invClienteCategoria
            invClienteCategoriaTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
            inventario.entity.InvClienteCategoria invClienteCategoria = inventario.helper.ConversionesInventario.convertirInvClienteCategoriaTO_InvClienteCategoria(invClienteCategoriaTO);

            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvClienteCategoria(
                        invClienteCategoriaTO.getCcEmpresa(),
                        invClienteCategoriaTO.getCcCodigo())) {
                    if (operacionesInventarioDAOLocal.comprobarEliminarInvClienteCategoria(
                            invClienteCategoriaTO.getCcEmpresa(),
                            invClienteCategoriaTO.getCcCodigo())) {
                        invClienteCategoria.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarInvClienteCategoria(
                                invClienteCategoriaTO.getCcEmpresa(),
                                invClienteCategoriaTO.getCcCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvClienteCategoria(invClienteCategoria, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se puede eliminar, la Categoría ya tiene Clientes...";
                    }
                } else {
                    mensaje = "FNo se encuentra la Categoría cliente...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvClienteCategoria(
                        invClienteCategoriaTO.getCcEmpresa(),
                        invClienteCategoriaTO.getCcCodigo())) {
                    invClienteCategoria.setUsrFechaInserta(
                            operacionesInventarioDAOLocal.buscarInvClienteCategoria(
                            invClienteCategoriaTO.getCcEmpresa(),
                            invClienteCategoriaTO.getCcCodigo()).getUsrFechaInserta());
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvClienteCategoria(invClienteCategoria, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra la Categoría cliente...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesInventarioDAOLocal.comprobarInvClienteCategoria(
                        invClienteCategoriaTO.getCcEmpresa(),
                        invClienteCategoriaTO.getCcCodigo())) {
                    invClienteCategoria.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvClienteCategoria(invClienteCategoria, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe la Categoría cliente...";
                }
            }

            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente la Categoría cliente";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la Categoría cliente";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la Categoría cliente";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la Categoría " + invClienteCategoriaTO.getCcDetalle() + ", inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvClienteCategoria",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PRODUCTO CATEGORIA">
    public List<inventario.TO.InvProductoCategoriaTO> getInvProductoCategoriaTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getInvProductoCategoriaTO(empresa);
    }

    @Override
    public String accionInvProductoCategoria(inventario.TO.InvProductoCategoriaTO invProductoCategoriaTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = invProductoCategoriaTO.getCatCodigo() + " : " + invProductoCategoriaTO.getCatDetalle();
            if (accion == 'I') {
                susDetalle = "Se insertó categoría producto " + invProductoCategoriaTO.getCatDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó categoría producto " + invProductoCategoriaTO.getCatDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó categoría producto " + invProductoCategoriaTO.getCatDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_producto_catego";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invProductoCategoria
            invProductoCategoriaTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
            inventario.entity.InvProductoCategoria invProductoCategoria = inventario.helper.ConversionesInventario.convertirInvProductoCategoriaTO_InvProductoCategoria(invProductoCategoriaTO);

            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoCategoria(
                        invProductoCategoriaTO.getCatEmpresa(),
                        invProductoCategoriaTO.getCatCodigo())) {
                    if (operacionesInventarioDAOLocal.comprobarEliminarInvProductoCategoria(
                            invProductoCategoriaTO.getCatEmpresa(),
                            invProductoCategoriaTO.getCatCodigo())) {
                        invProductoCategoria.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarInvProductoCategoria(
                                invProductoCategoriaTO.getCatEmpresa(),
                                invProductoCategoriaTO.getCatCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoCategoria(invProductoCategoria, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se puede eliminar, la Categoría ya tiene Productos...";
                    }
                } else {
                    mensaje = "FNo se encuentra la Categoría Producto...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoCategoria(
                        invProductoCategoriaTO.getCatEmpresa(),
                        invProductoCategoriaTO.getCatCodigo())) {
                    invProductoCategoria.setUsrFechaInserta(
                            operacionesInventarioDAOLocal.buscarInvProductoCategoria(
                            invProductoCategoriaTO.getCatEmpresa(),
                            invProductoCategoriaTO.getCatCodigo()).getUsrFechaInserta());
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoCategoria(invProductoCategoria, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra la Categoría Producto...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesInventarioDAOLocal.comprobarInvProductoCategoria(
                        invProductoCategoriaTO.getCatEmpresa(),
                        invProductoCategoriaTO.getCatCodigo())) {
                    invProductoCategoria.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoCategoria(invProductoCategoria, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe la Categoría Producto...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente la Categoría Producto";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la Categoría Producto";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la Categoría Producto";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la Categoría " + invProductoCategoriaTO.getCatDetalle() + ", inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvProductoCategoria",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PRODUCTO MEDIDA">
    public List<inventario.TO.InvProductoMedidaTO> getInvProductoMedidaTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getInvProductoMedidaTO(empresa);
    }

    @Override
    public String accionInvProductoMedida(inventario.TO.InvProductoMedidaTO invProductoMedidaTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = invProductoMedidaTO.getMedCodigo() + " : " + invProductoMedidaTO.getMedDetalle();
            if (accion == 'I') {
                susDetalle = "Se insertó medida producto " + invProductoMedidaTO.getMedDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó medida producto " + invProductoMedidaTO.getMedDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó medida producto " + invProductoMedidaTO.getMedDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_producto_medida";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invProductoMedida
            invProductoMedidaTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
            inventario.entity.InvProductoMedida invProductoMedida = inventario.helper.ConversionesInventario.convertirInvProductoMedidaTO_InvProductoMedida(invProductoMedidaTO);

            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoMedida(
                        invProductoMedidaTO.getMedEmpresa(),
                        invProductoMedidaTO.getMedCodigo())) {
                    if (operacionesInventarioDAOLocal.comprobarEliminarInvProductoMedida(
                            invProductoMedidaTO.getMedEmpresa(),
                            invProductoMedidaTO.getMedCodigo())) {
                        invProductoMedida.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarInvProductoMedida(
                                invProductoMedidaTO.getMedEmpresa(),
                                invProductoMedidaTO.getMedCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoMedida(invProductoMedida, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se puede eliminar, la Medida ya tiene Productos...";
                    }
                } else {
                    mensaje = "FNo se encuentra la Medida Producto...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoMedida(
                        invProductoMedidaTO.getMedEmpresa(),
                        invProductoMedidaTO.getMedCodigo())) {
                    invProductoMedida.setUsrFechaInserta(
                            operacionesInventarioDAOLocal.buscarInvProductoMedida(
                            invProductoMedidaTO.getMedEmpresa(),
                            invProductoMedidaTO.getMedCodigo()).getUsrFechaInserta());
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoMedida(invProductoMedida, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra la Medida Producto...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesInventarioDAOLocal.comprobarInvProductoMedida(
                        invProductoMedidaTO.getMedEmpresa(),
                        invProductoMedidaTO.getMedCodigo())) {
                    invProductoMedida.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoMedida(invProductoMedida, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe la Medida Producto...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente la Medida Producto";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la Medida Producto";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la Medida Producto";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la Medida " + invProductoMedidaTO.getMedDetalle() + ", inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvProductoMedida",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }
    // </editor-fold>
//    
//    // <editor-fold defaultstate="collapsed" desc="PRODUCTO">
//    public List<inventario.TO.InvProductoPresentacionUnidadesComboListadoTO> getListaPresentacionUnidadComboTO(String empresa) throws Exception{
//        return operacionesInventarioDAOLocal.getListaPresentacionUnidadComboTO(empresa);
//    }
//    
//    @Override
//    public String accionInvProductoTO(inventario.TO.InvProductoTO invProductoTO, char accion) throws java.lang.Exception{
//        comprobar = false;
//        try {
//            sistema.entity.SisSuceso sisSuceso = new sistema.entity.SisSuceso();
//            ///// CREANDO Suceso
//            sisUsuario = operacionesSistemaDAOLocal.buscarUsuario(
//                    invProductoTO.getUsrEmpresa(),
//                    invProductoTO.getUsrCodigo());
//            susClave = invProductoTO.getPresuCodigo()+" : "+invProductoTO.getPresuDetalle();
//            if(accion == 'I'){
//                susDetalle = "Se insertó Producto Presentación Caja " + invProductoTO.getPresuDetalle();
//                susSuceso = "INSERT";
//            }
//            if(accion == 'M'){
//                susDetalle = "Se modificó Producto Presentación Caja " + invProductoTO.getPresuDetalle();
//                susSuceso = "UPDATE";
//            }
//            if(accion == 'E'){
//                susDetalle = "Se eliminó Producto Presentación Caja " + invProductoTO.getPresuDetalle();
//                susSuceso = "DELETE";
//            }
//            usrCodigo = sisUsuario;
//            susTabla = "inventario.inv_producto_presentacion_Unidad";
//            ///// CREANDO invProductoMedida
//            invProductoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
//            inventario.entity.InvProductoPresentacionUnidades invProductoPresentacionUnidades = inventario.helper.ConversionesInventario.
//                    convertirInvProductoPresentacionUnidadesTO_InvProductoPresentacionUnidades(invProductoTO);
//
//            if(accion == 'E'){
//                ////// BUSCANDO existencia Categoría
//                if (operacionesInventarioDAOLocal.comprobarInvProductoPresentacionUnidades(
//                        invProductoTO.getPresuEmpresa(), 
//                        invProductoTO.getPresuCodigo())){
//                    if (operacionesInventarioDAOLocal.comprobarEliminarInvProductoPresentacionUnidades(
//                                invProductoTO.getPresuEmpresa(), 
//                                invProductoTO.getPresuCodigo())){
//                        invProductoPresentacionUnidades.setUsrFechaInserta(
//                                operacionesInventarioDAOLocal.buscarInvProductoPresentacionUnidades(
//                                invProductoTO.getPresuEmpresa(), 
//                                invProductoTO.getPresuCodigo()).getUsrFechaInserta());
//                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoPresentacionUnidades(invProductoPresentacionUnidades, sisSuceso, accion);
//                    }else
//                        mensaje = "FNo se puede eliminar, el Presentación Caja ya esta asignado a algunos Productos...";
//                }else
//                    mensaje = "FNo se encuentra el Producto Presentación Caja...";
//            }
//            if(accion == 'M'){
//                ////// BUSCANDO existencia Categoría
//                if (operacionesInventarioDAOLocal.comprobarInvProductoPresentacionUnidades(
//                        invProductoTO.getPresuEmpresa(), 
//                        invProductoTO.getPresuCodigo())){
//                    invProductoPresentacionUnidades.setUsrFechaInserta(
//                            operacionesInventarioDAOLocal.buscarInvProductoPresentacionUnidades(
//                            invProductoTO.getPresuEmpresa(), 
//                            invProductoTO.getPresuCodigo()).getUsrFechaInserta());
//                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoPresentacionUnidades(invProductoPresentacionUnidades, sisSuceso, accion);
//                }else
//                    mensaje = "FNo se encuentra el Producto Presentación Caja...";
//            }
//            if(accion == 'I'){
//                ////// BUSCANDO existencia Categoría
//                if (!operacionesInventarioDAOLocal.comprobarInvProductoPresentacionUnidades(
//                        invProductoTO.getPresuEmpresa(), 
//                        invProductoTO.getPresuCodigo())){
//                    invProductoPresentacionUnidades.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
//                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoPresentacionUnidades(invProductoPresentacionUnidades, sisSuceso, accion);
//                }else
//                    mensaje = "FYa existe el Unidad Producto...";
//            }
//            if (comprobar){
//                if(accion == 'E')
//                    mensaje = "TSe eliminó correctamente el Producto Presentación Caja";
//                if(accion == 'M')
//                    mensaje = "TSe modificó correctamente el Producto Presentación Caja";
//                if(accion == 'I')
//                    mensaje = "TSe ingresó correctamente  el Producto Presentación Caja";
//            }
//        } catch (Exception e) {
//            mensaje = "FOcurrió un error al guardar  el Unidad "+invProductoTO.getPresuDetalle()+", inténtelo de nuevo...";
//            validaciones.Excepciones.guardarExcepcionesEJB(e, invProductoTO.getUsrCodigo(),
//                    invProductoTO.getUsrEmpresa(), getClass().getName(), "accionInvProductoPresentacionUnidadTO", 
//                    operacionesSistemaDAOTransaccionLocal);
//        } finally {
//            return mensaje;
//        }
//    }
//    // </editor-fold>
//    

    public inventario.TO.InvProductoDAOTO buscarInvProductoDAOTO(String empresa, String codigoProducto) throws Exception {
        return inventario.helper.ConversionesInventario.convertirInvProducto_InvProductoDAOTO(operacionesInventarioDAOLocal.buscarInvProducto(empresa, codigoProducto));
    }

    public String insertarInvProductoTO(InvProductoTO invProductoTO, SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        String codigoGenerado = "";
        try {
            if (invProductoTO.getProCodigoPrincipal().trim().isEmpty()) {
                invProductoTO.setProCodigoPrincipal(operacionesInventarioDAOLocal.getInvProximaNumeracionProducto(invProductoTO.getProEmpresa(), invProductoTO));
                codigoGenerado = invProductoTO.getProCodigoPrincipal();
            }

            if (operacionesInventarioDAOLocal.buscarInvProducto(invProductoTO.getProEmpresa(), invProductoTO.getProCodigoPrincipal()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = invProductoTO.getProCodigoPrincipal();
                susDetalle = "Se insertó el producto " + invProductoTO.getProNombre() + " con código " + invProductoTO.getProCodigoPrincipal();
                susSuceso = "INSERT";
                susTabla = "inventario.inv_producto";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invProductoTO.setUsrFechaInsertaProducto(validaciones.Validacion.fechaSistema());
                inventario.entity.InvProducto invProducto = inventario.helper.ConversionesInventario.convertirInvProductoTO_InvProducto(invProductoTO);

//                if (invProductoTO.getProNombre().lastIndexOf("BALANCEADO") != -1) {
//                    if (!operacionesProduccionDAOLocal.comprobarPrdBalanceado(invProductoTO.getProEmpresa(), invProductoTO.getProNombre())) {
//                    
//                          if (invProductoTO.getBalFactorLibras() > 0) {
//                            produccion.TO.PrdBalanceadoTO prdBalanceadoTO = new
//                            produccion.TO.PrdBalanceadoTO();
//                            prdBalanceadoTO.setBalEmpresa(invProductoTO.getProEmpresa());
//                            prdBalanceadoTO.setBalCodigoPrincipal(invProductoTO.getProCodigoPrincipal());
//                            prdBalanceadoTO.setBalFactorLibras(invProductoTO.getBalFactorLibras());
//                            prdBalanceado =
//                            produccion.helper.ConversionesProduccion.convertirPrdBalanceadoTO_PrdBalanceado(prdBalanceadoTO);
//                         }
//                        
//                    }
//                }

                /////BUSCAR POR ALTERNO
                if (operacionesInventarioDAOLocal.getProductoRepetido("'" + invProductoTO.getProEmpresa() + "'", null, (invProductoTO.getProCodigoAlterno().trim().isEmpty() ? null : "'" + invProductoTO.getProCodigoAlterno() + "'"), null, null, null, null, null, null)) {
                    retorno = "FEl Código Alterno del producto ya existe en los registros.\nIntente ingresando otro Código...";
                } else {
                    /////BUSCAR POR BARRAS
                    if (operacionesInventarioDAOLocal.getProductoRepetido("'" + invProductoTO.getProEmpresa() + "'", null, null, "'" + invProductoTO.getProCodigoBarra() + "'", "'" + invProductoTO.getProCodigoBarra2() + "'",
                            "'" + invProductoTO.getProCodigoBarra3() + "'", "'" + invProductoTO.getProCodigoBarra4() + "'", "'" + invProductoTO.getProCodigoBarra5() + "'", null)) {
                        retorno = "FEl Código de Barras que ingresó ya existe en los registros.\nIntente ingresando otro Código...";
                    } else {
                        ////BUSCAR POR NOMBRE
                        if (operacionesInventarioDAOLocal.getProductoRepetido("'" + invProductoTO.getProEmpresa() + "'", null, null, null, null, null, null, null, (invProductoTO.getProNombre().trim().isEmpty() ? null : "'" + invProductoTO.getProNombre() + "'"))) {
                            retorno = "FEl Nombre del producto ya existe en los registros.\nIntente ingresando otro Nombre...";
                        } else {
                            retorno = "T";
                        }
                    }
                }

                /*
                 * if (invProductoMedida != null) {
                 * invProducto.setInvProductoMedida(invProductoMedida);
                 * inventario.entity.InvProductoCategoria invProductoCategoria =
                 * operacionesInventarioDAOLocal.buscarInvProductoCategoria(invProductoTO.getCatEmpresa(),
                 * invProductoTO.getCatCodigo()); if (invProductoCategoria !=
                 * null) {
                 * invProducto.setInvProductoCategoria(invProductoCategoria);
                 * inventario.entity.InvProductoTipo invProductoTipo =
                 * operacionesInventarioDAOLocal.buscarInvProductoTipo(invProductoTO.getTipEmpresa(),
                 * invProductoTO.getTipCodigo()); if (invProductoTipo != null) {
                 * invProducto.setInvProductoTipo(invProductoTipo); } } }
                 */

                if (retorno.charAt(0) == 'T') {
                    inventario.entity.InvProductoMedida invProductoMedida = operacionesInventarioDAOLocal.buscarProductoMedida(invProductoTO.getMedEmpresa(), invProductoTO.getMedCodigo());

                    inventario.entity.InvProductoPresentacionUnidades invProductoPresentacionUnidades = operacionesInventarioDAOLocal.buscarProductoPresentacionUnidades(invProductoTO.getPresUEmpresa(), invProductoTO.getPresUCodigo());
                    inventario.entity.InvProductoPresentacionCajas invProductoPresentacionCajas = operacionesInventarioDAOLocal.buscarProductoPresentacionCajas(invProductoTO.getPresCEmpresa(), invProductoTO.getPresCCodigo());
                    inventario.entity.InvProductoMarca invProductoMarca = operacionesInventarioDAOLocal.buscarMarcaProducto(invProductoTO.getMarEmpresa(), invProductoTO.getMarCodigo());

                    if (invProductoMedida != null) {
                        invProducto.setInvProductoMedida(invProductoMedida);
                        invProducto.setInvProductoPresentacionUnidades(invProductoPresentacionUnidades);
                        invProducto.setInvProductoPresentacionCajas(invProductoPresentacionCajas);
                        invProducto.setInvProductoMarca(invProductoMarca);

                        //  invProducto.setInvProductoMedida2(invProductoMedida2);
                        inventario.entity.InvProductoCategoria invProductoCategoria = operacionesInventarioDAOLocal.buscarInvProductoCategoria(invProductoTO.getCatEmpresa(), invProductoTO.getCatCodigo());
                        if (invProductoCategoria != null) {
                            invProducto.setInvProductoCategoria(invProductoCategoria);
                            inventario.entity.InvProductoTipo invProductoTipo = operacionesInventarioDAOLocal.buscarInvProductoTipo(invProductoTO.getTipEmpresa(), invProductoTO.getTipCodigo());
                            if (invProductoTipo != null) {
                                invProducto.setInvProductoTipo(invProductoTipo);
                                inventario.entity.InvNumeracionVarios invNumeracionVariosAux = operacionesInventarioDAOLocal.getInvNumeracionVarios(invProductoTO.getProEmpresa());
                                inventario.entity.InvNumeracionVarios invNumeracionVarios = inventario.helper.ConversionesInventario.convertirInvNumeracionVarios_InvNumeracionVarios(invNumeracionVariosAux);

                                if (invNumeracionVarios == null && codigoGenerado.trim().isEmpty()) {
                                    invNumeracionVarios = null;
                                } else {
                                    if (invNumeracionVarios == null && !codigoGenerado.trim().isEmpty()) {
                                        invNumeracionVarios = new inventario.entity.InvNumeracionVarios(invProductoTO.getProEmpresa(), "00000", "00000", codigoGenerado, invProductoTO.getProEmpresa());
                                    } else {
                                        if (invNumeracionVarios != null && codigoGenerado.trim().isEmpty()) {
                                            invNumeracionVarios = null;
                                        } else {
                                            if (invNumeracionVarios != null && !codigoGenerado.trim().isEmpty()) {
                                                invNumeracionVarios.setNumProductos(codigoGenerado);
                                            }
                                        }
                                    }
                                }
                                if (operacionesInventarioDAOLocal.buscarExisteNombreProducto(invProductoTO.getProEmpresa(), invProductoTO.getProNombre().trim())) {
                                    if (operacionesInventarioDAOTransaccionLocal.insertarInvProducto(invProducto, sisSuceso, invNumeracionVarios)) {
                                        retorno = "T<html>Se ha guardado el siguiente producto:<br><br>Código: <font size = 5>" + invProducto.getInvProductoPK().
                                                getProCodigoPrincipal().trim() + "</font>.<br>Nombre: <font size = 5>" + invProducto.getProNombre().trim() + "</font>.</html>";
                                    } else {
                                        retorno = "FHubo un error al guardar el producto...\nIntente de nuevo o contacte con el administrador.";
                                    }
                                } else {
                                    retorno = "FEl nombre del producto ya existe.\nIntente con otro.";
                                }
                            } else {
                                retorno = "FEl Tipo de Producto que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                            }
                        } else {
                            retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        if (invProductoMedida == null) {
                            retorno = "FLa Medida que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador.";
                        }
                        /*
                         * if(invProductoMedida2==null){ retorno = "FLa Medida 2
                         * que escogió ya no se encuentra disponible...\nIntente
                         * de nuevo o contacte con el administrador."; }
                         */

                    }
                }
            } else {
                retorno = "FEl código del producto que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            retorno = "FHubo un error al intentar guardar el Producto...";
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvProductoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public boolean productoRepetidoCodigoBarra(String empresa, String barras) throws Exception {
        return operacionesInventarioDAOLocal.getProductoRepetido("'" + empresa + "'", null, null, "'" + barras + "'", null,
                null, null, null, null);
    }

    public inventario.entity.InvProductoMedida entidadBalanceado(InvProductoTO invProductoTO, char accionBalanceado) throws Exception {
        inventario.entity.InvProductoMedida prdBalanceado = null;
        return prdBalanceado;
    }

    public String modificarInvProductoTO(InvProductoTO invProductoTO, String codigoCambiarLlave, sistema.TO.SisInfoTO sisInfoTO) throws Exception {

        String retorno = "";
        inventario.entity.InvProducto invProductoAux = null;
//        inventario.entity.InvProducto invProductoAux = operacionesInventarioDAOLocal.buscarInvProducto(invProductoTO.getProEmpresa(), invProductoTO.getProCodigoPrincipal());

        if (codigoCambiarLlave.trim().isEmpty()) {
            invProductoAux = operacionesInventarioDAOLocal.buscarInvProducto(invProductoTO.getProEmpresa(), invProductoTO.getProCodigoPrincipal());
        } else {
            invProductoAux = operacionesInventarioDAOLocal.buscarInvProducto(invProductoTO.getProEmpresa(), codigoCambiarLlave);
        }

        try {
            if (codigoCambiarLlave.trim().isEmpty()) {
                /////BUSCAR POR ALTERNO
                if (operacionesInventarioDAOLocal.getProductoRepetido("'" + invProductoTO.getProEmpresa() + "'", null, (invProductoTO.getProCodigoAlterno().trim().isEmpty() ? null : "'" + invProductoTO.getProCodigoAlterno() + "'"), null, null, null, null, null, null)) {
                    retorno = "FEl Código Alterno del producto ya existe en los registros.\nIntente ingresando otro Código...";
                } else {
                    /////BUSCAR POR BARRAS
                    if (operacionesInventarioDAOLocal.getProductoRepetido("'" + invProductoTO.getProEmpresa() + "'", (invProductoTO.getProCodigoPrincipal().trim().isEmpty() ? null : "'" + invProductoTO.getProCodigoPrincipal() + "'"), null, "'" + invProductoTO.getProCodigoBarra() + "'", "'" + invProductoTO.getProCodigoBarra2() + "'",
                            "'" + invProductoTO.getProCodigoBarra3() + "'", "'" + invProductoTO.getProCodigoBarra4() + "'", "'" + invProductoTO.getProCodigoBarra5() + "'", null)) {
                        retorno = "FEl Código de Barras que ingresó ya existe en los registros.\nIntente ingresando otro Código...";
                    } else {
                        ////BUSCAR POR NOMBRE
                        if (operacionesInventarioDAOLocal.getProductoRepetido("'" + invProductoTO.getProEmpresa() + "'", (invProductoTO.getProCodigoPrincipal().trim().isEmpty() ? null : "'" + invProductoTO.getProCodigoPrincipal() + "'"), null, null, null, null, null, null, (invProductoTO.getProNombre().trim().isEmpty() ? null : "'" + invProductoTO.getProNombre() + "'"))) {
                            retorno = "FEl Nombre del producto ya existe en los registros.\nIntente ingresando otro Nombre...";
                        } else {
                            retorno = "T";
                        }
                    }
                }
            } else {
                /////BUSCAR POR ALTERNO
                if (operacionesInventarioDAOLocal.getProductoRepetido("'" + invProductoTO.getProEmpresa() + "'", (codigoCambiarLlave.trim().isEmpty() ? null : "'" + codigoCambiarLlave + "'"), (invProductoTO.getProCodigoAlterno().trim().isEmpty() ? null : "'" + invProductoTO.getProCodigoAlterno() + "'"), null, null, null, null, null, null)) {
                    retorno = "FEl Código Alterno del producto ya existe en los registros.\nIntente ingresando otro Código...";
                } else {
                    /////BUSCAR POR BARRAS
                    if (operacionesInventarioDAOLocal.getProductoRepetido("'" + invProductoTO.getProEmpresa() + "'", (codigoCambiarLlave.trim().isEmpty() ? null : "'" + codigoCambiarLlave + "'"), null, "'" + invProductoTO.getProCodigoBarra() + "'", "'" + invProductoTO.getProCodigoBarra2() + "'",
                            "'" + invProductoTO.getProCodigoBarra3() + "'", "'" + invProductoTO.getProCodigoBarra4() + "'", "'" + invProductoTO.getProCodigoBarra5() + "'", null)) {
                        retorno = "FEl Código de Barras que ingresó ya existe en los registros.\nIntente ingresando otro Código...";
                    } else {
                        ////BUSCAR POR NOMBRE
                        if (operacionesInventarioDAOLocal.getProductoRepetido("'" + invProductoTO.getProEmpresa() + "'", (codigoCambiarLlave.trim().isEmpty() ? null : "'" + codigoCambiarLlave + "'"), null, null, null, null, null, null, (invProductoTO.getProNombre().trim().isEmpty() ? null : "'" + invProductoTO.getProNombre() + "'"))) {
                            retorno = "FEl Nombre del producto ya existe en los registros.\nIntente ingresando otro Nombre...";
                        } else {
                            retorno = "T";
                        }
                    }
                }
            }


            if (retorno.charAt(0) == 'T') {
                if (invProductoAux != null && codigoCambiarLlave.trim().isEmpty()) {
                    /// PREPARANDO OBJETO SISSUCESO
                    susClave = invProductoTO.getProCodigoPrincipal();
                    susDetalle = "Se modificó el producto " + invProductoTO.getProNombre() + " con código " + invProductoTO.getProCodigoPrincipal();
                    susSuceso = "UPDATE";
                    susTabla = "inventario.inv_producto";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                    invProductoTO.setUsrInsertaProducto(invProductoAux.getUsrCodigo());
                    invProductoTO.setUsrFechaInsertaProducto(validaciones.Validacion.fecha(invProductoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                    inventario.entity.InvProducto invProducto = inventario.helper.ConversionesInventario.convertirInvProductoTO_InvProducto(invProductoTO);
                    ///SI CONTIENE LA PALABRA "BALANCEADO" EN EL NOMBRE DEL PRODUCTO
                    inventario.entity.InvProductoMedida invProductoMedida = operacionesInventarioDAOLocal.buscarProductoMedida(invProductoTO.getMedEmpresa(), invProductoTO.getMedCodigo());
                    inventario.entity.InvProductoPresentacionUnidades invProductoPresentacionUnidades = operacionesInventarioDAOLocal.buscarProductoPresentacionUnidades(invProductoTO.getPresUEmpresa(), invProductoTO.getPresUCodigo());
                    inventario.entity.InvProductoPresentacionCajas invProductoPresentacionCajas = operacionesInventarioDAOLocal.buscarProductoPresentacionCajas(invProductoTO.getPresCEmpresa(), invProductoTO.getPresCCodigo());
                    inventario.entity.InvProductoMarca invProductoMarca = operacionesInventarioDAOLocal.buscarMarcaProducto(invProductoTO.getMarEmpresa(), invProductoTO.getMarCodigo());

                    /*
                     * cat_empresa character(7) NOT NULL, cat_codigo
                     * character(10) NOT NULL, mar_empresa character(7) NOT
                     * NULL, mar_codigo character(7) NOT NULL, presu_empresa
                     * character(7) NOT NULL, presu_codigo character(7) NOT
                     * NULL, presc_empresa character(7) NOT NULL, presc_codigo
                     * character(7) NOT NULL, tip_empresa character(7) NOT NULL,
                     * tip_codigo character(25) NOT NULL, med_empresa
                     * character(7) NOT NULL, med_codigo character(7) NOT NULL,
                     */
                    if (invProductoMedida != null) {
                        invProducto.setInvProductoMedida(invProductoMedida);
                        invProducto.setInvProductoPresentacionUnidades(invProductoPresentacionUnidades);
                        invProducto.setInvProductoPresentacionCajas(invProductoPresentacionCajas);
                        invProducto.setInvProductoMarca(invProductoMarca);
                        inventario.entity.InvProductoCategoria invProductoCategoria = operacionesInventarioDAOLocal.buscarInvProductoCategoria(invProductoTO.getCatEmpresa(), invProductoTO.getCatCodigo());
                        if (invProductoCategoria != null) {
                            invProducto.setInvProductoCategoria(invProductoCategoria);
                            inventario.entity.InvProductoTipo invProductoTipo = operacionesInventarioDAOLocal.buscarInvProductoTipo(invProductoTO.getTipEmpresa(), invProductoTO.getTipCodigo());
                            if (invProductoTipo != null) {
                                invProducto.setInvProductoTipo(invProductoTipo);

                                if (operacionesInventarioDAOTransaccionLocal.modificarInvProducto(invProducto, sisSuceso)) {
                                    retorno = "TEl producto se modificó correctamente...";
                                } else {
                                    retorno = "FHubo un error al modificar el producto...\nIntente de nuevo o contacte con el administrador";
                                }
                            } else {
                                retorno = "FEl Tipo de Producto que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                            }
                        } else {
                            retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        retorno = "FLa Medida que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                    }


                } else {
                    if (invProductoAux != null && !codigoCambiarLlave.trim().isEmpty()) {
                        /// PREPARANDO OBJETO SISSUCESO
                        susClave = invProductoTO.getProCodigoPrincipal();
                        susDetalle = "Se modificó el código " + codigoCambiarLlave + " del producto " + invProductoTO.getProNombre() + " por el código " + invProductoTO.getProCodigoPrincipal();
                        susSuceso = "UPDATE";
                        susTabla = "inventario.inv_producto";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                        invProductoTO.setUsrInsertaProducto(invProductoAux.getUsrCodigo());
                        invProductoTO.setUsrFechaInsertaProducto(validaciones.Validacion.fecha(invProductoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                        inventario.entity.InvProducto invProducto = inventario.helper.ConversionesInventario.convertirInvProductoTO_InvProducto(invProductoTO);
                        ///SI CONTIENE LA PALABRA "BALANCEADO" EN EL NOMBRE DEL PRODUCTO
                        inventario.entity.InvProductoMedida invProductoMedida = operacionesInventarioDAOLocal.buscarProductoMedida(invProductoTO.getMedEmpresa(), invProductoTO.getMedCodigo());
                        inventario.entity.InvProductoPresentacionUnidades invProductoPresentacionUnidades = operacionesInventarioDAOLocal.buscarProductoPresentacionUnidades(invProductoTO.getPresUEmpresa(), invProductoTO.getPresUCodigo());
                        inventario.entity.InvProductoPresentacionCajas invProductoPresentacionCajas = operacionesInventarioDAOLocal.buscarProductoPresentacionCajas(invProductoTO.getPresCEmpresa(), invProductoTO.getPresCCodigo());
                        inventario.entity.InvProductoMarca invProductoMarca = operacionesInventarioDAOLocal.buscarMarcaProducto(invProductoTO.getMarEmpresa(), invProductoTO.getMarCodigo());

                        if (invProductoMedida != null) {
                            invProducto.setInvProductoMedida(invProductoMedida);
                            invProducto.setInvProductoPresentacionUnidades(invProductoPresentacionUnidades);
                            invProducto.setInvProductoPresentacionCajas(invProductoPresentacionCajas);
                            invProducto.setInvProductoMarca(invProductoMarca);
                            inventario.entity.InvProductoCategoria invProductoCategoria = operacionesInventarioDAOLocal.buscarInvProductoCategoria(invProductoTO.getCatEmpresa(), invProductoTO.getCatCodigo());
                            if (invProductoCategoria != null) {
                                invProducto.setInvProductoCategoria(invProductoCategoria);
                                inventario.entity.InvProductoTipo invProductoTipo = operacionesInventarioDAOLocal.buscarInvProductoTipo(invProductoTO.getTipEmpresa(), invProductoTO.getTipCodigo());
                                if (invProductoTipo != null) {
                                    invProducto.setInvProductoTipo(invProductoTipo);
                                    if (invProductoAux.getInvProductoPK().getProCodigoPrincipal().equals(invProducto.getInvProductoPK().getProCodigoPrincipal())) {
                                        if (operacionesInventarioDAOTransaccionLocal.modificarInvProducto(invProducto, sisSuceso)) {
                                            retorno = "TEl producto se modificó correctamente...";
                                        } else {
                                            retorno = "FHubo un error al modificar el producto...\nIntente de nuevo o contacte con el administrador";
                                        }
                                    } else {
                                        if (operacionesInventarioDAOTransaccionLocal.modificarInvProductoLlavePrincipal(invProductoAux, invProducto, sisSuceso)) {
                                            retorno = "TEl producto se modificó correctamente...";
                                        } else {
                                            retorno = "FHubo un error al modificar el producto...\nIntente de nuevo o contacte con el administrador";
                                        }
                                    }

                                } else {
                                    retorno = "FEl Tipo de Producto que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                                }
                            } else {
                                retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                            }
                        } else {
                            retorno = "FLa Medida que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        if (invProductoAux == null && codigoCambiarLlave.trim().isEmpty()) {
                            retorno = "FEl código del producto que va a modificar ya no está disponible...\nIntente con otro...";
                        } else {
                            /// PREPARANDO OBJETO SISSUCESO
                            susClave = invProductoTO.getProCodigoPrincipal();
                            susDetalle = "Se modificó el código " + codigoCambiarLlave + " del producto " + invProductoTO.getProNombre() + " por el código " + invProductoTO.getProCodigoPrincipal();
                            susSuceso = "UPDATE";
                            susTabla = "inventario.inv_producto";
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                            invProductoTO.setUsrInsertaProducto(invProductoAux.getUsrCodigo());
                            invProductoTO.setUsrFechaInsertaProducto(validaciones.Validacion.fecha(invProductoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                            inventario.entity.InvProducto invProducto = inventario.helper.ConversionesInventario.convertirInvProductoTO_InvProducto(invProductoTO);

                            ///SI CONTIENE LA PALABRA "BALANCEADO" EN EL NOMBRE DEL PRODUCTO
                            inventario.entity.InvProductoMedida invProductoMedida = operacionesInventarioDAOLocal.buscarProductoMedida(invProductoTO.getMedEmpresa(), invProductoTO.getMedCodigo());
                            inventario.entity.InvProductoPresentacionUnidades invProductoPresentacionUnidades = operacionesInventarioDAOLocal.buscarProductoPresentacionUnidades(invProductoTO.getPresUEmpresa(), invProductoTO.getPresUCodigo());
                            inventario.entity.InvProductoPresentacionCajas invProductoPresentacionCajas = operacionesInventarioDAOLocal.buscarProductoPresentacionCajas(invProductoTO.getPresCEmpresa(), invProductoTO.getPresCCodigo());
                            inventario.entity.InvProductoMarca invProductoMarca = operacionesInventarioDAOLocal.buscarMarcaProducto(invProductoTO.getMarEmpresa(), invProductoTO.getMarCodigo());

                            if (invProductoMedida != null) {
                                invProducto.setInvProductoMedida(invProductoMedida);
                                invProducto.setInvProductoPresentacionUnidades(invProductoPresentacionUnidades);
                                invProducto.setInvProductoPresentacionCajas(invProductoPresentacionCajas);
                                invProducto.setInvProductoMarca(invProductoMarca);

                                inventario.entity.InvProductoCategoria invProductoCategoria = operacionesInventarioDAOLocal.buscarInvProductoCategoria(invProductoTO.getCatEmpresa(), invProductoTO.getCatCodigo());
                                if (invProductoCategoria != null) {
                                    invProducto.setInvProductoCategoria(invProductoCategoria);
                                    inventario.entity.InvProductoTipo invProductoTipo = operacionesInventarioDAOLocal.buscarInvProductoTipo(invProductoTO.getTipEmpresa(), invProductoTO.getTipCodigo());
                                    if (invProductoTipo != null) {
                                        invProducto.setInvProductoTipo(invProductoTipo);
                                        if (invProductoAux.getInvProductoPK().getProCodigoPrincipal().equals(invProducto.getInvProductoPK().getProCodigoPrincipal())) {
                                            if (operacionesInventarioDAOTransaccionLocal.modificarInvProducto(invProducto, sisSuceso)) {
                                                retorno = "TEl producto se modificó correctamente...";
                                            } else {
                                                retorno = "FHubo un error al modificar el producto...\nIntente de nuevo o contacte con el administrador";
                                            }
                                        } else {
                                            if (operacionesInventarioDAOTransaccionLocal.modificarInvProductoLlavePrincipal(invProductoAux, invProducto, sisSuceso)) {
                                                retorno = "TEl producto se modificó correctamente...";
                                            } else {
                                                retorno = "FHubo un error al modificar el producto...\nIntente de nuevo o contacte con el administrador";
                                            }
                                        }

                                    } else {
                                        retorno = "FEl Tipo de Producto que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                                    }
                                } else {
                                    retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                                }
                            } else {
                                retorno = "FLa Medida que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvProductoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String eliminarInvProductoTO(InvProductoTO invProductoTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        Boolean puedeEliminar = false;
        try {
            inventario.entity.InvProducto invProductoAux = operacionesInventarioDAOLocal.buscarInvProducto(invProductoTO.getProEmpresa(), invProductoTO.getProCodigoPrincipal());
            if (invProductoAux != null) {
                puedeEliminar = operacionesInventarioDAOLocal.getPuedeEliminarProducto(invProductoTO.getProEmpresa(), invProductoTO.getProCodigoPrincipal());
                if (puedeEliminar) {
                    /// PREPARANDO OBJETO SISSUCESO
                    susClave = invProductoTO.getProCodigoPrincipal();
                    susDetalle = "Se eliminó el producto " + invProductoTO.getProNombre() + " con código " + invProductoTO.getProCodigoPrincipal();
                    susSuceso = "DELETE";
                    susTabla = "inventario.inv_producto";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                    invProductoTO.setUsrInsertaProducto(invProductoAux.getUsrCodigo());
                    invProductoTO.setUsrFechaInsertaProducto(validaciones.Validacion.fecha(invProductoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                    inventario.entity.InvProducto invProducto = inventario.helper.ConversionesInventario.convertirInvProductoTO_InvProducto(invProductoTO);
                    inventario.entity.InvProductoMedida invProductoMedida = operacionesInventarioDAOLocal.buscarProductoMedida(invProductoTO.getMedEmpresa(), invProductoTO.getMedCodigo());
                    invProducto.setInvProductoMedida(invProductoMedida);
                    inventario.entity.InvProductoPresentacionUnidades invProductoPresentacionUnidades = operacionesInventarioDAOLocal.buscarProductoPresentacionUnidades(invProductoTO.getPresUEmpresa(), invProductoTO.getPresUCodigo());
                    invProducto.setInvProductoPresentacionUnidades(invProductoPresentacionUnidades);
                    inventario.entity.InvProductoPresentacionCajas invProductoPresentacionCajas = operacionesInventarioDAOLocal.buscarProductoPresentacionCajas(invProductoTO.getPresCEmpresa(), invProductoTO.getPresCCodigo());
                    invProducto.setInvProductoPresentacionCajas(invProductoPresentacionCajas);
                    inventario.entity.InvProductoMarca invProductoMarca = operacionesInventarioDAOLocal.buscarMarcaProducto(invProductoTO.getMarEmpresa(), invProductoTO.getMarCodigo());
                    invProducto.setInvProductoMarca(invProductoMarca);

                    if (invProductoTO.getProNombre().lastIndexOf("BALANCEADO") != -1) {
                        if (operacionesProduccionDAOLocal.comprobarPrdBalanceado(invProductoTO.getProEmpresa(), invProductoTO.getProNombre())) {
                            if (invProductoTO.getBalFactorLibras() > 0) {
                                produccion.TO.PrdBalanceadoTO prdBalanceadoTO = new produccion.TO.PrdBalanceadoTO();
                                prdBalanceadoTO.setBalEmpresa(invProductoTO.getProEmpresa());
                                prdBalanceadoTO.setBalCodigoPrincipal(invProductoTO.getProCodigoPrincipal());
                                prdBalanceadoTO.setBalFactorLibras(invProductoTO.getBalFactorLibras());

                            }
                        }
                    }

                    if (invProductoMedida != null) {
                        invProducto.setInvProductoMedida(invProductoMedida);
                        inventario.entity.InvProductoCategoria invProductoCategoria = operacionesInventarioDAOLocal.buscarInvProductoCategoria(invProductoTO.getCatEmpresa(), invProductoTO.getCatCodigo());
                        if (invProductoCategoria != null) {
                            invProducto.setInvProductoCategoria(invProductoCategoria);
                            inventario.entity.InvProductoTipo invProductoTipo = operacionesInventarioDAOLocal.buscarInvProductoTipo(invProductoTO.getTipEmpresa(), invProductoTO.getTipCodigo());
                            if (invProductoTipo != null) {
                                invProducto.setInvProductoTipo(invProductoTipo);
                                if (operacionesInventarioDAOTransaccionLocal.eliminarInvProducto(invProducto, sisSuceso)) {
                                    retorno = "TEl producto se eliminó correctamente...";
                                } else {
                                    retorno = "FHubo un error al eliminar el producto...\nIntente de nuevo o contacte con el administrador";
                                }
                            } else {
                                retorno = "FEl Tipo de Producto que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                            }
                        } else {
                            retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        if (invProductoMedida == null) {
                            retorno = "FNo se puede eliminar este producto porque la Medida de este Producto ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                        }
                    }
                } else {
                    retorno = "FNo se puede eliminar este producto debido a que tiene movimientos en Inventarios.\nIntente con otro...";
                }
            } else {
                retorno = "FEl Producto que va a eliminar ya no está disponible...\nIntente con otro...";
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarInvProductoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public boolean getClienteRepetido(String empresa, String codigo, String id, String nombre, String razonSocial) throws Exception {
        return operacionesInventarioDAOLocal.getClienteRepetido(empresa, codigo, id, nombre, razonSocial);
    }

    public String insertarInvClienteTO(InvClienteTO invClienteTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        String codigoGenerado = "";
        try {
            if (invClienteTO.getCliCodigo().trim().isEmpty()) {
                invClienteTO.setCliCodigo(operacionesInventarioDAOLocal.getInvProximaNumeracionCliente(invClienteTO.getEmpCodigo(), invClienteTO));
                codigoGenerado = invClienteTO.getCliCodigo();
            }
            if (operacionesInventarioDAOLocal.buscarInvCliente(invClienteTO.getEmpCodigo(), invClienteTO.getCliCodigo()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = invClienteTO.getCliCodigo();
                susDetalle = "Se ingresó al cliente" + invClienteTO.getCliNombre() + " con código " + invClienteTO.getCliCodigo();
                susSuceso = "INSERT";
                susTabla = "inventario.inv_cliente";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invClienteTO.setUsrFechaInsertaCliente(validaciones.Validacion.fechaSistema());
                inventario.entity.InvCliente invCliente = inventario.helper.ConversionesInventario.convertirInvClienteTO_InvCliente(invClienteTO);
                /////BUSCAR POR ID
                boolean var = operacionesInventarioDAOLocal.getClienteRepetido("'" + invClienteTO.getEmpCodigo() + "'", null, (invClienteTO.getCliId().trim().isEmpty() ? null : "'" + invClienteTO.getCliId() + "'"), null, null);
                if (var && !("F".equals(invClienteTO.getCliTipoId().toString()) && "9999999999999".equals(invClienteTO.getCliId()))) {
                    retorno = "FEl ID del Cliente ya existe en los registros.\nIntente ingresando otro ID...";
                } else {
                    /////BUSCAR POR NOMBRE
                    if (operacionesInventarioDAOLocal.getClienteRepetido("'" + invClienteTO.getEmpCodigo() + "'", null, null, (invClienteTO.getCliNombre().trim().isEmpty() ? null : "'" + invClienteTO.getCliNombre() + "'"), null)) {
                        retorno = "FEl Nombre del Cliente ya existe en los registros.\nIntente ingresando otro Nombre...";
                    } else {
                        ////BUSCAR POR RAZON SOCIAL
                        if (operacionesInventarioDAOLocal.getClienteRepetido("'" + invClienteTO.getEmpCodigo() + "'", null, null, null, (invClienteTO.getCliRazonSocial().trim().isEmpty() ? null : "'" + invClienteTO.getCliRazonSocial() + "'"))) {
                            retorno = "FLa Razón Social ya existe en los registros.\nIntente ingresando otro nombre...";
                        } else {
                            retorno = "T";
                        }
                    }
                }


                if (retorno.charAt(0) == 'T') {
                    inventario.entity.InvClienteCategoria invClienteCategoria = operacionesInventarioDAOLocal.buscarInvClienteCategoria(invClienteTO.getEmpCodigo(), invClienteTO.getCliCategoria());
                    inventario.entity.InvVendedor invVendedor = operacionesInventarioDAOLocal.buscaInvVendedor(invClienteTO.getEmpCodigo(), invClienteTO.getVendCodigo());

                    if (invClienteCategoria != null && invVendedor != null) {
                        invCliente.setInvClienteCategoria(invClienteCategoria);
                        invCliente.setInvVendedor(invVendedor);
                        inventario.entity.InvNumeracionVarios invNumeracionVariosAux = operacionesInventarioDAOLocal.getInvNumeracionVarios(invClienteTO.getEmpCodigo());
                        inventario.entity.InvNumeracionVarios invNumeracionVarios = inventario.helper.ConversionesInventario.convertirInvNumeracionVarios_InvNumeracionVarios(invNumeracionVariosAux);

                        if (invNumeracionVarios == null && codigoGenerado.trim().isEmpty()) {
                            invNumeracionVarios = null;
                        } else {
                            if (invNumeracionVarios == null && !codigoGenerado.trim().isEmpty()) {
                                invNumeracionVarios = new inventario.entity.InvNumeracionVarios(invClienteTO.getEmpCodigo(), "00000", "00000", codigoGenerado, invClienteTO.getEmpCodigo());
                            } else {
                                if (invNumeracionVarios != null && codigoGenerado.trim().isEmpty()) {
                                    invNumeracionVarios = null;
                                } else {
                                    if (invNumeracionVarios != null && !codigoGenerado.trim().isEmpty()) {
                                        invNumeracionVarios.setNumClientes(codigoGenerado);
                                    }
                                }
                            }
                        }
                        if (operacionesInventarioDAOTransaccionLocal.insertarInvCliente(invCliente, sisSuceso, invNumeracionVarios)) {
                            retorno = "T<html>Se ha guardado el siguiente cliente:<br><br>Código: <font size = 5>" + invCliente.getInvClientePK().getCliCodigo().trim()
                                    + "</font>.<br>Nombre: <font size = 5>" + invCliente.getCliNombre().trim() + "</font>.</html>";
                        } else {
                            retorno = "FHubo un error al ingresar al cliente...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                    }
                }
            } else {
                retorno = "FEl código del cliente que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            comprobar = false;
            retorno = "FHubo un error al ingresar al cliente...\nIntente de nuevo o contacte con el administrador";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvClienteTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String eliminarInvClienteTO(InvClienteTO invClienteTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            inventario.entity.InvCliente invClienteAux = operacionesInventarioDAOLocal.buscarInvCliente(invClienteTO.getEmpCodigo(), invClienteTO.getCliCodigo());
            if (invClienteAux != null) {
                if (operacionesInventarioDAOLocal.buscarConteoCliente(invClienteTO.getEmpCodigo(), invClienteTO.getCliCodigo())) {
                    ///     PREPARANDO OBJETO SISSUCESO
                    susClave = invClienteTO.getCliCodigo();
                    susDetalle = "Se Elimino al cliente " + invClienteTO.getCliNombre() + " con código " + invClienteTO.getCliCodigo();
                    susSuceso = "DELETE";
                    susTabla = "inventario.inv_cliente";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    ///     PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY

//                    inventario.entity.InvClienteCategoria invClienteCategoria = operacionesInventarioDAOLocal.
//                            buscarInvClienteCategoria(invClienteTO.getEmpCodigo(), invClienteTO.getCliCategoria());
//                    inventario.entity.InvVendedor invVendedor = operacionesInventarioDAOLocal.
//                             buscaInvVendedor(invClienteTO.getEmpCodigo(), invClienteTO.getVendCodigo());

                    invClienteTO.setUsrInsertaCliente(invClienteAux.getUsrCodigo());
                    invClienteTO.setUsrFechaInsertaCliente(validaciones.Validacion.fecha(invClienteAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                    inventario.entity.InvCliente invCliente = inventario.helper.ConversionesInventario.convertirInvClienteTO_InvCliente(invClienteTO);
                    invCliente.setInvClienteCategoria(invClienteAux.getInvClienteCategoria());
                    if (operacionesInventarioDAOTransaccionLocal.eliminarInvCliente(invCliente, sisSuceso)) {
                        retorno = "TEl Cliente se eliminó correctamente...";
                    } else {
                        retorno = "FHubo un error al eliminar al cliente...\nIntente de nuevo o contacte con el administrador";
                    }
                } else {
                    retorno = "FNo se puede eliminar este Cliente debido a que tiene movimientos en Inventarios.\nIntente con otro...";
                }
            } else {
                retorno = "FEl Cliente que va a eliminar ya no está disponible...\nIntente con otro...";
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarInvClienteTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarInvClienteTO(InvClienteTO invClienteTO, String codigoAnterior, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        inventario.entity.InvCliente invClienteAux = null;

        if (codigoAnterior.trim().isEmpty()) {
            invClienteAux = operacionesInventarioDAOLocal.buscarInvCliente(invClienteTO.getEmpCodigo(), invClienteTO.getCliCodigo());
        } else {
            invClienteAux = operacionesInventarioDAOLocal.buscarInvCliente(invClienteTO.getEmpCodigo(), codigoAnterior);
        }

        try {
            if (codigoAnterior.trim().isEmpty()) {
                /////BUSCAR POR ID
                boolean var = operacionesInventarioDAOLocal.getClienteRepetido("'" + invClienteTO.getEmpCodigo() + "'", (invClienteTO.getCliCodigo().trim().isEmpty() ? null : "'" + invClienteTO.getCliCodigo() + "'"), (invClienteTO.getCliId().trim().isEmpty() ? null : "'" + invClienteTO.getCliId() + "'"), null, null);
                if (var && !("F".equals(invClienteTO.getCliTipoId().toString()) && "9999999999999".equals(invClienteTO.getCliId()))) {
                    retorno = "FEl ID del Cliente ya existe en los registros.\nIntente ingresando otro ID...";
                } else {
                    /////BUSCAR POR NOMBRE
                    if (operacionesInventarioDAOLocal.getClienteRepetido("'" + invClienteTO.getEmpCodigo() + "'", (invClienteTO.getCliCodigo().trim().isEmpty() ? null : "'" + invClienteTO.getCliCodigo() + "'"), null, (invClienteTO.getCliNombre().trim().isEmpty() ? null : "'" + invClienteTO.getCliNombre() + "'"), null)) {
                        retorno = "FEl Nombre del Cliente ya existe en los registros.\nIntente ingresando otro Nombre...";
                    } else {
                        ////BUSCAR POR RAZON SOCIAL
                        if (operacionesInventarioDAOLocal.getClienteRepetido("'" + invClienteTO.getEmpCodigo() + "'", (invClienteTO.getCliCodigo().trim().isEmpty() ? null : "'" + invClienteTO.getCliCodigo() + "'"), null, null, (invClienteTO.getCliRazonSocial().trim().isEmpty() ? null : "'" + invClienteTO.getCliRazonSocial() + "'"))) {
                            retorno = "FLa Razón Social ya existe en los registros.\nIntente ingresando otro nombre...";
                        } else {
                            retorno = "T";
                        }
                    }
                }
            } else {
                /////BUSCAR POR ID
                boolean var = operacionesInventarioDAOLocal.getClienteRepetido("'" + invClienteTO.getEmpCodigo() + "'", (codigoAnterior.trim().isEmpty() ? null : "'" + codigoAnterior + "'"), (invClienteTO.getCliId().trim().isEmpty() ? null : "'" + invClienteTO.getCliId() + "'"), null, null);
                if (var && !("F".equals(invClienteTO.getCliTipoId().toString()) && "9999999999999".equals(invClienteTO.getCliId()))) {
                    retorno = "FEl ID del Cliente ya existe en los registros.\nIntente ingresando otro ID...";
                } else {
                    /////BUSCAR POR NOMBRE
                    if (operacionesInventarioDAOLocal.getClienteRepetido("'" + invClienteTO.getEmpCodigo() + "'", (codigoAnterior.trim().isEmpty() ? null : "'" + codigoAnterior + "'"), null, (invClienteTO.getCliNombre().trim().isEmpty() ? null : "'" + invClienteTO.getCliNombre() + "'"), null)) {
                        retorno = "FEl Nombre del Cliente ya existe en los registros.\nIntente ingresando otro Nombre...";
                    } else {
                        ////BUSCAR POR RAZON SOCIAL
                        if (operacionesInventarioDAOLocal.getClienteRepetido("'" + invClienteTO.getEmpCodigo() + "'", (codigoAnterior.trim().isEmpty() ? null : "'" + codigoAnterior + "'"), null, null, (invClienteTO.getCliRazonSocial().trim().isEmpty() ? null : "'" + invClienteTO.getCliRazonSocial() + "'"))) {
                            retorno = "FLa Razón Social ya existe en los registros.\nIntente ingresando otro nombre...";
                        } else {
                            retorno = "T";
                        }
                    }
                }
            }


            if (retorno.charAt(0) == 'T') {
                if (invClienteAux != null && codigoAnterior.trim().isEmpty()) {
                    /// PREPARANDO OBJETO SISSUCESO
                    susClave = invClienteTO.getCliCodigo();
                    susDetalle = "Se modificó al cliente " + invClienteTO.getCliNombre() + " con código " + invClienteTO.getCliCodigo();
                    susSuceso = "UPDATE";
                    susTabla = "inventario.inv_cliente";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                    invClienteTO.setUsrInsertaCliente(invClienteAux.getUsrCodigo());
                    invClienteTO.setUsrFechaInsertaCliente(validaciones.Validacion.fecha(invClienteAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                    inventario.entity.InvCliente invCliente = inventario.helper.ConversionesInventario.convertirInvClienteTO_InvCliente(invClienteTO);
//
                    inventario.entity.InvClienteCategoria invClienteCategoria = operacionesInventarioDAOLocal.buscarInvClienteCategoria(invClienteTO.getEmpCodigo(), invClienteTO.getCliCategoria());
                    if (invClienteCategoria != null) {
                        invCliente.setInvClienteCategoria(invClienteCategoria);


                        inventario.entity.InvVendedor invVendedor = operacionesInventarioDAOLocal.buscaInvVendedor(invClienteTO.getEmpCodigo(), invClienteTO.getVendCodigo());

                        invCliente.setInvVendedor(invVendedor);
                        if (invCliente.getCliIdTipo() == 'F') {
                            invCliente.setCliIdNumero(null);
                        }
                        if (operacionesInventarioDAOTransaccionLocal.modificarInvCliente(invCliente, sisSuceso)) {
                            retorno = "TEl cliente se modificó correctamente...";
                        } else {
                            retorno = "FHubo un error al modificar el cliente...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                    }
                } else {
                    if (invClienteAux != null && !codigoAnterior.trim().isEmpty()) {
                        /// PREPARANDO OBJETO SISSUCESO
                        susClave = invClienteTO.getCliCodigo();
                        susDetalle = "Se modificó el código " + codigoAnterior + " del cliente " + invClienteTO.getCliNombre() + " por el código " + invClienteTO.getCliCodigo();
                        susSuceso = "UPDATE";
                        susTabla = "inventario.inv_cliente";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                        invClienteTO.setUsrInsertaCliente(invClienteAux.getUsrCodigo());
                        invClienteTO.setUsrFechaInsertaCliente(validaciones.Validacion.fecha(invClienteAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                        inventario.entity.InvCliente invCliente = inventario.helper.ConversionesInventario.convertirInvClienteTO_InvCliente(invClienteTO);

                        inventario.entity.InvClienteCategoria invClienteCategoria = operacionesInventarioDAOLocal.buscarInvClienteCategoria(invClienteTO.getEmpCodigo(), invClienteTO.getCliCategoria());
                        if (invClienteCategoria != null) {
                            invCliente.setInvClienteCategoria(invClienteCategoria);
                            inventario.entity.InvVendedor invVendedor = operacionesInventarioDAOLocal.buscaInvVendedor(invClienteTO.getEmpCodigo(), invClienteTO.getVendCodigo());
                            invCliente.setInvVendedor(invVendedor);


                            if (invClienteAux.getInvClientePK().getCliCodigo().equals(invCliente.getInvClientePK().getCliCodigo())) {
                                if (invCliente.getCliIdTipo() == 'F') {
                                    invCliente.setCliIdNumero(null);
                                }
                                if (operacionesInventarioDAOTransaccionLocal.modificarInvCliente(invCliente, sisSuceso)) {
                                    retorno = "TEl cliente se modificó correctamente...";
                                } else {
                                    retorno = "FHubo un error al modificar el cliente...\nIntente de nuevo o contacte con el administrador";
                                }
                            } else {
                                if (operacionesInventarioDAOTransaccionLocal.modificarInvClienteLlavePrincipal(invClienteAux, invCliente, sisSuceso)) {
                                    retorno = "TEl cliente se modificó correctamente...";
                                } else {
                                    retorno = "FHubo un error al modificar el cliente...\nIntente de nuevo o contacte con el administrador";
                                }
                            }

                        } else {
                            retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        if (invClienteAux == null && codigoAnterior.trim().isEmpty()) {
                            retorno = "FEl código del cliente que va a modificar ya no está disponible...\nIntente con otro...";
                        } else {
                            /// PREPARANDO OBJETO SISSUCESO
                            susClave = invClienteTO.getCliCodigo();
                            susDetalle = "Se modificó el código " + codigoAnterior + " del cliente " + invClienteTO.getCliNombre() + " por el código " + invClienteTO.getCliCodigo();
                            susSuceso = "UPDATE";
                            susTabla = "inventario.inv_cliente";
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                            invClienteTO.setUsrInsertaCliente(invClienteAux.getUsrCodigo());
                            invClienteTO.setUsrFechaInsertaCliente(validaciones.Validacion.fecha(invClienteAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                            inventario.entity.InvCliente invCliente = inventario.helper.ConversionesInventario.convertirInvClienteTO_InvCliente(invClienteTO);

                            inventario.entity.InvClienteCategoria invClienteCategoria = operacionesInventarioDAOLocal.buscarInvClienteCategoria(invClienteTO.getEmpCodigo(), invClienteTO.getCliCategoria());
                            if (invClienteCategoria != null) {
                                invCliente.setInvClienteCategoria(invClienteCategoria);
                                inventario.entity.InvVendedor invVendedor = operacionesInventarioDAOLocal.buscaInvVendedor(invClienteTO.getEmpCodigo(), invClienteTO.getVendCodigo());
                                invCliente.setInvVendedor(invVendedor);

                                if (invClienteAux.getInvClientePK().getCliCodigo().equals(invCliente.getInvClientePK().getCliCodigo())) {
                                    if (operacionesInventarioDAOTransaccionLocal.modificarInvCliente(invCliente, sisSuceso)) {
                                        retorno = "TEl cliente se modificó correctamente...";
                                    } else {
                                        retorno = "FHubo un error al modificar el cliente...\nIntente de nuevo o contacte con el administrador";
                                    }
                                } else {
                                    if (operacionesInventarioDAOTransaccionLocal.modificarInvClienteLlavePrincipal(invClienteAux, invCliente, sisSuceso)) {
                                        retorno = "TEl cliente se modificó correctamente...";
                                    } else {
                                        retorno = "FHubo un error al modificar el cliente...\nIntente de nuevo o contacte con el administrador";
                                    }
                                }

                            } else {
                                retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            comprobar = false;
            retorno = "FHubo un error al modificar el cliente...\nIntente de nuevo o contacte con el administrador";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvClienteTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String insertarInvProveedorTO(InvProveedorTO invProveedorTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        String codigoGenerado = "";
        try {
            if (invProveedorTO.getProvCodigo().trim().isEmpty()) {
                invProveedorTO.setProvCodigo(operacionesInventarioDAOLocal.getInvProximaNumeracionProveedor(invProveedorTO.getEmpCodigo(), invProveedorTO));
                codigoGenerado = invProveedorTO.getProvCodigo();
            }
            if (operacionesInventarioDAOLocal.buscarInvProveedor(invProveedorTO.getEmpCodigo(), invProveedorTO.getProvCodigo()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = invProveedorTO.getProvCodigo();
                susDetalle = "Se ingresó al proveedor" + invProveedorTO.getProvNombre() + " con código " + invProveedorTO.getProvCodigo();
                susSuceso = "INSERT";
                susTabla = "inventario.inv_proveedor";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invProveedorTO.setUsrFechaInsertaProveedor(validaciones.Validacion.fechaSistema());
                inventario.entity.InvProveedor invProveedor = inventario.helper.ConversionesInventario.convertirInvProveedorTO_InvProveedor(invProveedorTO);

                /////BUSCAR POR ID
                if (operacionesInventarioDAOLocal.getProveedorRepetido("'" + invProveedorTO.getEmpCodigo() + "'", null, (invProveedorTO.getProvId().trim().isEmpty() ? null : "'" + invProveedorTO.getProvId() + "'"), null, null)) {
                    retorno = "FEl ID del proveedor que ingresó ya existe en los registros.\nIntente ingresando otro ID...";
                } else {
                    ////BUSCAR POR NOMBRE
                    if (operacionesInventarioDAOLocal.getProveedorRepetido("'" + invProveedorTO.getEmpCodigo() + "'", null, null, (invProveedorTO.getProvNombre().trim().isEmpty() ? null : "'" + invProveedorTO.getProvNombre() + "'"), null)) {
                        retorno = "FEl Nombre del proveedor ya existe en los registros.\nIntente ingresando otro Nombre...";
                    } else {
                        ////BUSCAR POR RAZONSOCIAL
                        if (operacionesInventarioDAOLocal.getProveedorRepetido("'" + invProveedorTO.getEmpCodigo() + "'", null, null, null, (invProveedorTO.getProvRazonSocial().trim().isEmpty() ? null : "'" + invProveedorTO.getProvRazonSocial() + "'"))) {
                            retorno = "FLa Razón Social del proveedor ya existe en los registros.\nIntente ingresando otro Razón Social...";
                        } else {
                            retorno = "T";
                        }
                    }
                }
                if (retorno.charAt(0) == 'T') {
                    inventario.entity.InvProveedorCategoria invProveedorCategoria = operacionesInventarioDAOLocal.buscarInvProveedorCategoria(invProveedorTO.getEmpCodigo(), invProveedorTO.getProvCategoria());

                    if (invProveedorCategoria != null) {
                        invProveedor.setInvProveedorCategoria(invProveedorCategoria);
                        inventario.entity.InvNumeracionVarios invNumeracionVariosAux = operacionesInventarioDAOLocal.getInvNumeracionVarios(invProveedorTO.getEmpCodigo());
                        inventario.entity.InvNumeracionVarios invNumeracionVarios = inventario.helper.ConversionesInventario.convertirInvNumeracionVarios_InvNumeracionVarios(invNumeracionVariosAux);

                        if (invNumeracionVarios == null && codigoGenerado.trim().isEmpty()) {
                            invNumeracionVarios = null;
                        } else {
                            if (invNumeracionVarios == null && !codigoGenerado.trim().isEmpty()) {
                                invNumeracionVarios = new inventario.entity.InvNumeracionVarios(invProveedorTO.getEmpCodigo(), "00000", "00000", codigoGenerado, invProveedorTO.getEmpCodigo());
                            } else {
                                if (invNumeracionVarios != null && codigoGenerado.trim().isEmpty()) {
                                    invNumeracionVarios = null;
                                } else {
                                    if (invNumeracionVarios != null && !codigoGenerado.trim().isEmpty()) {
                                        invNumeracionVarios.setNumProveedores(codigoGenerado);
                                    }
                                }
                            }
                        }
                        if (operacionesInventarioDAOTransaccionLocal.insertarInvProveedor(invProveedor, sisSuceso, invNumeracionVarios)) {
                            retorno = "T<html>Se ha guardado el siguiente proveedor:<br><br>Código: <font size = 5>" + invProveedor.getInvProveedorPK().getProvCodigo().trim()
                                    + "</font>.<br>Nombre: <font size = 5>" + invProveedor.getProvNombre().trim() + "</font></html>";
                        } else {
                            retorno = "FHubo un error al ingresar al Proveedor...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                    }
                }
            } else {
                retorno = "FEl código del proveedor que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            comprobar = false;
            retorno = "FHubo un error al ingresar al Proveedor...\nIntente de nuevo o contacte con el administrador";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvProveedorTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarInvProveedorTO(InvProveedorTO invProveedorTO, String codigoAnterior, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        inventario.entity.InvProveedor invProveedorAux = null;

        if (codigoAnterior.trim().isEmpty()) {
            invProveedorAux = operacionesInventarioDAOLocal.buscarInvProveedor(invProveedorTO.getEmpCodigo(), invProveedorTO.getProvCodigo());
        } else {
            invProveedorAux = operacionesInventarioDAOLocal.buscarInvProveedor(invProveedorTO.getEmpCodigo(), codigoAnterior);
        }

        try {
            if (codigoAnterior.trim().isEmpty()) {
                /////BUSCAR POR ID
                if (operacionesInventarioDAOLocal.getProveedorRepetido("'" + invProveedorTO.getEmpCodigo() + "'", (invProveedorTO.getProvCodigo().trim().isEmpty() ? null : "'" + invProveedorTO.getProvCodigo() + "'"), (invProveedorTO.getProvId().trim().isEmpty() ? null : "'" + invProveedorTO.getProvId() + "'"), null, null)) {
                    retorno = "FEl ID del proveedor que ingresó ya existe en los registros.\nIntente ingresando otro ID...";
                } else {
                    ////BUSCAR POR NOMBRE
                    if (operacionesInventarioDAOLocal.getProveedorRepetido("'" + invProveedorTO.getEmpCodigo() + "'", (invProveedorTO.getProvCodigo().trim().isEmpty() ? null : "'" + invProveedorTO.getProvCodigo() + "'"), null, (invProveedorTO.getProvNombre().trim().isEmpty() ? null : "'" + invProveedorTO.getProvNombre() + "'"), null)) {
                        retorno = "FEl Nombre del proveedor ya existe en los registros.\nIntente ingresando otro Nombre...";
                    } else {
                        ////BUSCAR POR RAZONSOCIAL
                        if (operacionesInventarioDAOLocal.getProveedorRepetido("'" + invProveedorTO.getEmpCodigo() + "'", (invProveedorTO.getProvCodigo().trim().isEmpty() ? null : "'" + invProveedorTO.getProvCodigo() + "'"), null, null, (invProveedorTO.getProvRazonSocial().trim().isEmpty() ? null : "'" + invProveedorTO.getProvRazonSocial() + "'"))) {
                            retorno = "FLa Razón Social del proveedor ya existe en los registros.\nIntente ingresando otro Razón Social...";
                        } else {
                            retorno = "T";
                        }
                    }
                }
            } else {
                /////BUSCAR POR ID
                if (operacionesInventarioDAOLocal.getProveedorRepetido("'" + invProveedorTO.getEmpCodigo() + "'", (codigoAnterior.trim().isEmpty() ? null : "'" + codigoAnterior + "'"), (invProveedorTO.getProvId().trim().isEmpty() ? null : "'" + invProveedorTO.getProvId() + "'"), null, null)) {
                    retorno = "FEl ID del proveedor que ingresó ya existe en los registros.\nIntente ingresando otro ID...";
                } else {
                    ////BUSCAR POR NOMBRE
                    if (operacionesInventarioDAOLocal.getProveedorRepetido("'" + invProveedorTO.getEmpCodigo() + "'", (codigoAnterior.trim().isEmpty() ? null : "'" + codigoAnterior + "'"), null, (invProveedorTO.getProvNombre().trim().isEmpty() ? null : "'" + invProveedorTO.getProvNombre() + "'"), null)) {
                        retorno = "FEl Nombre del proveedor ya existe en los registros.\nIntente ingresando otro Nombre...";
                    } else {
                        ////BUSCAR POR RAZONSOCIAL
                        if (operacionesInventarioDAOLocal.getProveedorRepetido("'" + invProveedorTO.getEmpCodigo() + "'", (codigoAnterior.trim().isEmpty() ? null : "'" + codigoAnterior + "'"), null, null, (invProveedorTO.getProvRazonSocial().trim().isEmpty() ? null : "'" + invProveedorTO.getProvRazonSocial() + "'"))) {
                            retorno = "FLa Razón Social del proveedor ya existe en los registros.\nIntente ingresando otro Razón Social...";
                        } else {
                            retorno = "T";
                        }
                    }
                }
            }

            if (retorno.charAt(0) == 'T') {
                if (invProveedorAux != null && codigoAnterior.trim().isEmpty()) {
                    /// PREPARANDO OBJETO SISSUCESO
                    susClave = invProveedorTO.getProvCodigo();
                    susDetalle = "Se modificó al proveedor " + invProveedorTO.getProvNombre() + " con código " + invProveedorTO.getProvCodigo();
                    susSuceso = "UPDATE";
                    susTabla = "inventario.inv_proveedor";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                    invProveedorTO.setProvSecuencia(invProveedorAux.getProvSecuencia());
                    invProveedorTO.setUsrInsertaProveedor(invProveedorAux.getUsrCodigo());
                    invProveedorTO.setUsrFechaInsertaProveedor(validaciones.Validacion.fecha(invProveedorAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                    inventario.entity.InvProveedor invProveedor = inventario.helper.ConversionesInventario.convertirInvProveedorTO_InvProveedor(invProveedorTO);

                    inventario.entity.InvProveedorCategoria invProveedorCategoria = operacionesInventarioDAOLocal.buscarInvProveedorCategoria(invProveedorTO.getEmpCodigo(), invProveedorTO.getProvCategoria());
                    if (invProveedorCategoria != null) {
                        invProveedor.setInvProveedorCategoria(invProveedorCategoria);
                        if (operacionesInventarioDAOTransaccionLocal.modificarInvProveedor(invProveedor, sisSuceso)) {
                            retorno = "TEl proveedor se modificó correctamente...";
                        } else {
                            retorno = "FHubo un error al modificar al proveedor...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                    }
                } else {
                    if (invProveedorAux != null && !codigoAnterior.trim().isEmpty()) {
                        /// PREPARANDO OBJETO SISSUCESO
                        susClave = invProveedorTO.getProvCodigo();
                        susDetalle = "Se modificó el código " + codigoAnterior + " del proveedor " + invProveedorTO.getProvNombre() + " por el código " + invProveedorTO.getProvCodigo();
                        susSuceso = "UPDATE";
                        susTabla = "inventario.inv_proveedor";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                        invProveedorTO.setProvSecuencia(invProveedorAux.getProvSecuencia());
                        invProveedorTO.setUsrInsertaProveedor(invProveedorAux.getUsrCodigo());
                        invProveedorTO.setUsrFechaInsertaProveedor(validaciones.Validacion.fecha(invProveedorAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                        inventario.entity.InvProveedor invProveedor = inventario.helper.ConversionesInventario.convertirInvProveedorTO_InvProveedor(invProveedorTO);

                        inventario.entity.InvProveedorCategoria invProveedorCategoria = operacionesInventarioDAOLocal.buscarInvProveedorCategoria(invProveedorTO.getEmpCodigo(), invProveedorTO.getProvCategoria());
                        if (invProveedorCategoria != null) {
                            invProveedor.setInvProveedorCategoria(invProveedorCategoria);

                            if (invProveedorAux.getInvProveedorPK().getProvCodigo().equals(invProveedor.getInvProveedorPK().getProvCodigo())) {
                                if (operacionesInventarioDAOTransaccionLocal.modificarInvProveedor(invProveedor, sisSuceso)) {
                                    retorno = "TEl proveedor se modificó correctamente...";
                                } else {
                                    retorno = "FHubo un error al modificar al proveedor...\nIntente de nuevo o contacte con el administrador";
                                }
                            } else {
                                if (operacionesInventarioDAOTransaccionLocal.modificarInvProveedorLlavePrincipal(invProveedorAux, invProveedor, sisSuceso)) {
                                    retorno = "TEl proveedor se modificó correctamente...";
                                } else {
                                    retorno = "FHubo un error al modificar al proveedor...\nIntente de nuevo o contacte con el administrador";
                                }
                            }

                        } else {
                            retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        if (invProveedorAux == null && codigoAnterior.trim().isEmpty()) {
                            retorno = "FEl código del proveedor que va a modificar ya no está disponible...\nIntente con otro...";
                        } else {
                            /// PREPARANDO OBJETO SISSUCESO
                            susClave = invProveedorTO.getProvCodigo();
                            susDetalle = "Se modificó el código " + codigoAnterior + " del proveedor " + invProveedorTO.getProvNombre() + " por el código " + invProveedorTO.getProvCodigo();
                            susSuceso = "UPDATE";
                            susTabla = "inventario.inv_proveedor";
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                            invProveedorTO.setProvSecuencia(invProveedorAux.getProvSecuencia());
                            invProveedorTO.setUsrInsertaProveedor(invProveedorAux.getUsrCodigo());
                            invProveedorTO.setUsrFechaInsertaProveedor(validaciones.Validacion.fecha(invProveedorAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                            inventario.entity.InvProveedor invProveedor = inventario.helper.ConversionesInventario.convertirInvProveedorTO_InvProveedor(invProveedorTO);

                            inventario.entity.InvProveedorCategoria invProveedorCategoria = operacionesInventarioDAOLocal.buscarInvProveedorCategoria(invProveedorTO.getEmpCodigo(), invProveedorTO.getProvCategoria());
                            if (invProveedorCategoria != null) {
                                invProveedor.setInvProveedorCategoria(invProveedorCategoria);

                                if (invProveedorAux.getInvProveedorPK().getProvCodigo().equals(invProveedor.getInvProveedorPK().getProvCodigo())) {
                                    if (operacionesInventarioDAOTransaccionLocal.modificarInvProveedor(invProveedor, sisSuceso)) {
                                        retorno = "TEl proveedor se modificó correctamente...";
                                    } else {
                                        retorno = "FHubo un error al modificar al proveedor...\nIntente de nuevo o contacte con el administrador";
                                    }
                                } else {
                                    if (operacionesInventarioDAOTransaccionLocal.modificarInvProveedorLlavePrincipal(invProveedorAux, invProveedor, sisSuceso)) {
                                        retorno = "TEl proveedor se modificó correctamente...";
                                    } else {
                                        retorno = "FHubo un error al modificar al proveedor...\nIntente de nuevo o contacte con el administrador";
                                    }
                                }
                            } else {
                                retorno = "FLa Categoría que escogió ya no se encuentra disponible...\nIntente de nuevo o contacte con el administrador";
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            comprobar = false;
            retorno = "FHubo un error al modificar al proveedor...\nIntente de nuevo o contacte con el administrador";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvProveedorTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String insertarInvBodegaTO(InvBodegaTO invBodegaTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            if (operacionesInventarioDAOLocal.buscarInvBodega(invBodegaTO.getEmpCodigo(), invBodegaTO.getBodCodigo()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = invBodegaTO.getBodCodigo();
                susDetalle = "Se ingresó la bodega" + invBodegaTO.getBodNombre() + " con código " + invBodegaTO.getBodCodigo();
                susSuceso = "INSERT";
                susTabla = "inventario.inv_bodega";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invBodegaTO.setUsrFechaInsertaBodega(validaciones.Validacion.fechaSistema());
                inventario.entity.InvBodega invBodega = inventario.helper.ConversionesInventario.convertirInvBodegaTO_InvBodega(invBodegaTO);

                if (operacionesInventarioDAOTransaccionLocal.insertarInvBodega(invBodega, sisSuceso)) {
                    retorno = "TBodega ingresada correctamente...";
                } else {
                    retorno = "FHubo un error al ingresar la Bodega...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl código de la bodega que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            comprobar = false;
            retorno = "FHubo un error al ingresar la Bodega...\nIntente de nuevo o contacte con el administrador";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvBodegaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarInvBodegaTO(InvBodegaTO invBodegaTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {

        String retorno = "";
        inventario.entity.InvBodega invBodegaAux = operacionesInventarioDAOLocal.buscarInvBodega(invBodegaTO.getEmpCodigo(), invBodegaTO.getBodCodigo());
        try {
            if (invBodegaAux != null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = invBodegaTO.getBodCodigo();
                susDetalle = "Se modificó la bodega " + invBodegaTO.getBodNombre() + " con código " + invBodegaTO.getBodCodigo();
                susSuceso = "UPDATE";
                susTabla = "inventario.inv_bodega";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);

                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invBodegaTO.setUsrInsertaBodega(invBodegaAux.getUsrCodigo());
                invBodegaTO.setUsrFechaInsertaBodega(validaciones.Validacion.fecha(invBodegaAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                inventario.entity.InvBodega invBodega = inventario.helper.ConversionesInventario.convertirInvBodegaTO_InvBodega(invBodegaTO);

                if (operacionesInventarioDAOTransaccionLocal.modificarInvBodega(invBodega, sisSuceso)) {
                    retorno = "TLa bodega se modificó correctamente...";
                } else {
                    retorno = "FHubo un error al modificar la bodega...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl código del bodega que va a modificar ya no está disponible...\nIntente con otro...";
            }
        } catch (Exception e) {
            comprobar = false;
            retorno = "FHubo un error al modificar la bodega...\nIntente de nuevo o contacte con el administrador";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvBodegaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    private List<inventario.entity.InvComprasDetalle> agrupraProductosBodegaCompra(List<inventario.entity.InvComprasDetalle> comprasDetalle) throws Exception {

        List<inventario.entity.InvComprasDetalle> listaDetalleFinal = new ArrayList();
        listaDetalleFinal.add(inventario.helper.ConversionesInventario.convertirInvCompraDetalle_InvCompraDetalle(comprasDetalle.get(0)));

        int contador = 0;
        boolean encontro = false;

        for (int i = 1; i < comprasDetalle.size(); i++) {
            contador = 0;
            for (inventario.entity.InvComprasDetalle invComprasDetalleAux : listaDetalleFinal) {
                if (comprasDetalle.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal().equals(invComprasDetalleAux.getInvProducto().getInvProductoPK().getProCodigoPrincipal())
                        && comprasDetalle.get(i).getInvBodega().getInvBodegaPK().getBodCodigo().equals(invComprasDetalleAux.getInvBodega().getInvBodegaPK().getBodCodigo())) {
                    encontro = true;
                    break;
                } else {
                    encontro = false;
                    contador++;
                }
            }

            if (encontro) {
                listaDetalleFinal.get(contador).setDetCantidad(listaDetalleFinal.get(contador).getDetCantidad().add(comprasDetalle.get(i).getDetCantidad()));
                listaDetalleFinal.get(contador).setDetPrecio(comprasDetalle.get(i).getDetPrecio());
//                listaDetalleFinal.get(contador).setDetPrecio(listaDetalleFinal.get(contador).getDetPrecio().add(comprasDetalle.get(i).getDetPrecio()));
            } else {
                listaDetalleFinal.add(inventario.helper.ConversionesInventario.convertirInvCompraDetalle_InvCompraDetalle(comprasDetalle.get(i)));
            }
        }

        return listaDetalleFinal;
    }

    private List<inventario.entity.InvVentasDetalle> agrupraProductosBodegaVenta(List<inventario.entity.InvVentasDetalle> ventasDetalle) throws Exception {
        List<inventario.entity.InvVentasDetalle> listaDetalleFinal = new ArrayList();
        listaDetalleFinal.add(inventario.helper.ConversionesInventario.convertirInvVentaDetalle_InvVentaDetalle(ventasDetalle.get(0)));

        int contador = 0;
        boolean encontro = false;

        for (int i = 1; i < ventasDetalle.size(); i++) {
            contador = 0;
            for (inventario.entity.InvVentasDetalle invVentasDetalleAux : listaDetalleFinal) {
                if (ventasDetalle.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal().equals(invVentasDetalleAux.getInvProducto().getInvProductoPK().getProCodigoPrincipal())
                        && ventasDetalle.get(i).getInvBodega().getInvBodegaPK().getBodCodigo().equals(invVentasDetalleAux.getInvBodega().getInvBodegaPK().getBodCodigo())) {
                    encontro = true;
                    break;
                } else {
                    encontro = false;
                    contador++;
                }
            }

            if (encontro) {
                listaDetalleFinal.get(contador).setDetCantidad(listaDetalleFinal.get(contador).getDetCantidad().add(ventasDetalle.get(i).getDetCantidad()));
                listaDetalleFinal.get(contador).setDetPrecio(listaDetalleFinal.get(contador).getDetPrecio().add(ventasDetalle.get(i).getDetPrecio()));
            } else {
                listaDetalleFinal.add(inventario.helper.ConversionesInventario.convertirInvVentaDetalle_InvVentaDetalle(ventasDetalle.get(i)));
            }
        }

        return listaDetalleFinal;
    }

    private List<inventario.entity.InvProformasDetalle> agrupraProductosBodegaProforma(List<inventario.entity.InvProformasDetalle> ProformasDetalle) throws Exception {
        List<inventario.entity.InvProformasDetalle> listaDetalleFinal = new ArrayList();
        listaDetalleFinal.add(inventario.helper.ConversionesInventario.convertirInvProformaDetalle_InvProformaDetalle(ProformasDetalle.get(0)));

        int contador = 0;
        boolean encontro = false;

        for (int i = 1; i < ProformasDetalle.size(); i++) {
            contador = 0;
            for (inventario.entity.InvProformasDetalle invProformasDetalleAux : listaDetalleFinal) {
                if (ProformasDetalle.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal().equals(invProformasDetalleAux.getInvProducto().getInvProductoPK().getProCodigoPrincipal())) {
                    encontro = true;
                    break;
                } else {
                    encontro = false;
                    contador++;
                }
            }

            if (encontro) {
                listaDetalleFinal.get(contador).setDetCantidad(listaDetalleFinal.get(contador).getDetCantidad().add(ProformasDetalle.get(i).getDetCantidad()));
                listaDetalleFinal.get(contador).setDetPrecio(listaDetalleFinal.get(contador).getDetPrecio().add(ProformasDetalle.get(i).getDetPrecio()));
            } else {
//                listaDetalleFinal.add(proformasDetalle.get(i));
                listaDetalleFinal.add(inventario.helper.ConversionesInventario.convertirInvProformaDetalle_InvProformaDetalle(ProformasDetalle.get(i)));
            }
        }

        return listaDetalleFinal;
    }

    private List<inventario.entity.InvConsumosDetalle> agrupraProductosBodegaConsumo(List<inventario.entity.InvConsumosDetalle> consumosDetalle) throws Exception {
        List<inventario.entity.InvConsumosDetalle> listaDetalleFinal = new ArrayList();
//        listaDetalleFinal.add(consumosDetalle.get(0));
        listaDetalleFinal.add(inventario.helper.ConversionesInventario.convertirInvConsumoDetalle_InvConsumoDetalle(consumosDetalle.get(0)));

        int contador = 0;
        boolean encontro = false;

        for (int i = 1; i < consumosDetalle.size(); i++) {
            contador = 0;
            for (inventario.entity.InvConsumosDetalle invConsumosDetalleAux : listaDetalleFinal) {
                if (consumosDetalle.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal().equals(invConsumosDetalleAux.getInvProducto().getInvProductoPK().getProCodigoPrincipal())
                        && consumosDetalle.get(i).getInvBodega().getInvBodegaPK().getBodCodigo().equals(invConsumosDetalleAux.getInvBodega().getInvBodegaPK().getBodCodigo())) {
                    encontro = true;
                    break;
                } else {
                    encontro = false;
                    contador++;
                }
            }

            if (encontro) {
                listaDetalleFinal.get(contador).setDetCantidad(listaDetalleFinal.get(contador).getDetCantidad().add(consumosDetalle.get(i).getDetCantidad()));
//                listaDetalleFinal.get(contador).setDetPrecio(listaDetalleFinal.get(contador).getDetPrecio() + consumosDetalle.get(i).getDetPrecio());
            } else {
//                listaDetalleFinal.add(consumosDetalle.get(i));
                listaDetalleFinal.add(inventario.helper.ConversionesInventario.convertirInvConsumoDetalle_InvConsumoDetalle(consumosDetalle.get(i)));
            }
        }

        return listaDetalleFinal;
    }

    private List<inventario.entity.InvTransferenciasDetalle> agrupraProductosBodegaTransferencia(List<inventario.entity.InvTransferenciasDetalle> transferenciasDetalle) throws Exception {
        List<inventario.entity.InvTransferenciasDetalle> listaDetalleFinal = new ArrayList();
        listaDetalleFinal.add(inventario.helper.ConversionesInventario.convertirInvTransferenciasDetalle_InvTransferenciasDetalle(transferenciasDetalle.get(0)));

        int contador = 0;
        boolean encontro = false;

        for (int i = 1; i < transferenciasDetalle.size(); i++) {
            contador = 0;
            for (inventario.entity.InvTransferenciasDetalle invTransferenciasDetalleAux : listaDetalleFinal) {
                if (transferenciasDetalle.get(i).getInvBodega().getInvBodegaPK().getBodCodigo().
                        equals(invTransferenciasDetalleAux.getInvBodega().getInvBodegaPK().getBodCodigo())
                        && transferenciasDetalle.get(i).getInvBodega1().getInvBodegaPK().getBodCodigo().
                        equals(invTransferenciasDetalleAux.getInvBodega1().getInvBodegaPK().getBodCodigo())
                        && transferenciasDetalle.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal().
                        equals(invTransferenciasDetalleAux.getInvProducto().getInvProductoPK().getProCodigoPrincipal())) {
//                if(transferenciasDetalle.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal().equals(invTransferenciasDetalleAux.getInvProducto().getInvProductoPK().getProCodigoPrincipal()) &&
//                        transferenciasDetalle.get(i).getInvBodega().getInvBodegaPK().getBodCodigo().equals(invTransferenciasDetalleAux.getInvBodega().getInvBodegaPK().getBodCodigo())){
                    encontro = true;
                    break;
                } else {
                    encontro = false;
                    contador++;
                }
            }

            if (encontro) {
                listaDetalleFinal.get(contador).setDetCantidad(listaDetalleFinal.get(contador).getDetCantidad().add(transferenciasDetalle.get(i).getDetCantidad()));
//                listaDetalleFinal.get(contador).setDetPrecio(listaDetalleFinal.get(contador).getDetPrecio() + consumosDetalle.get(i).getDetPrecio());
            } else {
//                listaDetalleFinal.add(consumosDetalle.get(i));
                listaDetalleFinal.add(inventario.helper.ConversionesInventario.convertirInvTransferenciasDetalle_InvTransferenciasDetalle(transferenciasDetalle.get(i)));
            }
        }

        return listaDetalleFinal;
    }

    public inventario.TO.MensajeTO insertarInvComprasTO(
            InvComprasTO invComprasTO,
            List<InvComprasDetalleTO> listaInvComprasDetalleTO,
            anexos.TO.AnxCompraTO anxCompraTO,
            List<anexos.TO.AnxCompraDetalleTO> anxCompraDetalleTO,
            List<anexos.TO.AnxCompraReembolsoTO> anxCompraReembolsoTO,
            List<anexos.TO.AnxCompraFormaPagoTO> anxCompraFormaPagoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        inventario.entity.InvProductoSaldos invProductoSaldos = null;
        List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos = new ArrayList(1);
        boolean periodoCerrado = false;
        List<String> mensajeClase = new ArrayList(1);
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        try {
            //ojo -
            if (!validaciones.Validacion.isFechaSuperior(invComprasTO.getCompFecha(), "yyyy-MM-dd")) {
                comprobar = false;
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invComprasTO.getEmpCodigo());
                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (validaciones.Validacion.fecha(invComprasTO.getCompFecha(), "yyyy-MM-dd").getTime()
                            >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && validaciones.Validacion.fecha(invComprasTO.getCompFecha(), "yyyy-MM-dd").getTime()
                            <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                        comprobar = true;
                        invComprasTO.setCompPeriodo(sisListaPeriodoTO.getPerCodigo());
                        periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                    }
                }
                if (comprobar) {
                    if (!periodoCerrado) {
                        boolean continuar = false;
                        if (anxCompraTO != null) {
                            if (anxCompraTO.getCompRetencionNumero() != null) {
                                anexos.TO.AnxNumeracionLineaTO anxNumeracionLineaTO = operacionesAnexoDAOLocal.getNumeroAutorizacion(invComprasTO.getEmpCodigo(),
                                        anxCompraTO.getCompRetencionNumero(), "07", ("'" + anxCompraTO.getCompRetencionFechaEmision() + "'"));
                                if (!anxNumeracionLineaTO.getNumeroAutorizacion().trim().equals("ANULADO")) {
                                    continuar = true;
                                }

                            } else {
                                continuar = true;
                            }
                        } else {
                            continuar = true;
                        }
                        if (continuar) {
                            if (operacionesInventarioDAOLocal.comprobarInvComprasMotivo(
                                    invComprasTO.getEmpCodigo(),
                                    invComprasTO.getCompMotivo())) {
                                /// PREPARANDO OBJETO SISSUCESO (susClave y susDetalle se llenan en DAOTransaccion)
                                susSuceso = "INSERT";
                                susTabla = "inventario.inv_compra";
                                invComprasTO.setUsrFechaInsertaCompra(validaciones.Validacion.fechaSistema());
                                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                        susTabla,
                                        susClave,
                                        susSuceso,
                                        susDetalle,
                                        sisInfoTO);
                                ////// CREANDO NUMERACION DE COMPRA
                                inventario.entity.InvComprasNumeracion invComprasNumeracion = new inventario.entity.InvComprasNumeracion(
                                        new inventario.entity.InvComprasNumeracionPK(invComprasTO.getEmpCodigo(), invComprasTO.getCompPeriodo(),
                                        invComprasTO.getCompMotivo()));
                                ///// BUSCANDO PROVEEDOR
                                inventario.entity.InvProveedor invProveedor = operacionesInventarioDAOLocal.buscarInvProveedor(invComprasTO.getEmpCodigo(), invComprasTO.getProvCodigo());
                                if (invProveedor != null) {
                                    ////// CREANDO COMPRAS
                                    invComprasTO.setCompImportacion(false);
                                    inventario.entity.InvCompras invCompras = inventario.helper.ConversionesInventario.convertirInvComprasTO_InvCompras(invComprasTO);
                                    invCompras.setInvProveedor(operacionesInventarioDAOLocal.buscarInvProveedor(invComprasTO.getEmpCodigo(), invComprasTO.getProvCodigo()));
                                    ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                    List<inventario.entity.InvComprasDetalle> listInvComprasDetalle = new ArrayList(0);
                                    inventario.entity.InvComprasDetalle invComprasDetalle = null;
                                    int estadoDetalle = 0;
                                    for (inventario.TO.InvComprasDetalleTO invComprasDetalleTO : listaInvComprasDetalleTO) {
                                        invComprasDetalle = new inventario.entity.InvComprasDetalle();
                                        invComprasDetalleTO.setDetConfirnado(true);
                                        invComprasDetalle = inventario.helper.ConversionesInventario.convertirInvComprasDetalleTO_InvComprasDetalle(invComprasDetalleTO);
                                        ///// BUSCANDO EL PRODUCTO EN DETALLE
                                        inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invComprasDetalleTO.getProEmpresa(),
                                                invComprasDetalleTO.getProCodigoPrincipal());
                                        if (invProducto != null) {
                                            invComprasDetalle.setInvProducto(invProducto);
                                            invComprasDetalle.setProCreditoTributario(invProducto.getProCreditoTributario());
                                            ////// BUSCANDO LA BODEGA EN EL DETALLE
                                            inventario.entity.InvBodega invBodega = operacionesInventarioDAOLocal.buscarInvBodega(invComprasDetalleTO.getProEmpresa(),
                                                    invComprasDetalleTO.getBodCodigo());
                                            if (invBodega != null) {
                                                invComprasDetalle.setInvBodega(invBodega);
                                                listInvComprasDetalle.add(invComprasDetalle);
                                            } else {
                                                estadoDetalle = 2;
                                            }
                                        } else {
                                            estadoDetalle = 1;
                                        }

                                        if (estadoDetalle == 1 || estadoDetalle == 2) {
                                            break;
                                        } else {
                                            invProducto = null;
                                        }
                                    }

                                    boolean existeConcepto = false;
                                    if (estadoDetalle == 0) {
                                        anexos.entity.AnxCompra anxCompra = null;
                                        anexos.entity.AnxCompraDetalle anxCompraDetalle = null;
                                        anexos.entity.AnxCompraDividendo anxCompraDividendo = null;
                                        anexos.entity.AnxCompraFormaPago anxCompraFormaPago = null;
                                        anexos.entity.AnxCompraReembolso anxCompraReembolso = null;
                                        List<anexos.entity.AnxCompraDetalle> anxCompraDetalles = new ArrayList();
                                        List<anexos.entity.AnxCompraDividendo> anxCompraDividendos = new ArrayList();
                                        List<anexos.entity.AnxCompraReembolso> anxCompraReembolsos = new ArrayList();
                                        List<anexos.entity.AnxCompraFormaPago> anxCompraFormaPagos = new ArrayList();

                                        if (invComprasTO.getCompDocumentoTipo().equals("00")
                                                || (invComprasTO.getCompDocumentoTipo().equals("04") && anxCompraTO == null)
                                                || invComprasTO.getCompDocumentoTipo().equals("99")) {
                                            existeConcepto = true;
                                        } else {
                                            for (int i = 0; i < anxCompraFormaPagoTO.size(); i++) {
                                                anexos.entity.AnxFormaPago anxFormaPago = operacionesAnexoDAOLocal.getAnexoFormaPago(anxCompraFormaPagoTO.get(i).getFpCodigo());
                                                if (anxFormaPago != null) {
                                                    anxCompraFormaPago = anexos.helper.ConversionesAnexos.convertirAnxCompraFormaPagoTO_AnxCompraFormaPago(anxCompraFormaPagoTO.get(i));
                                                    anxCompraFormaPago.setAnxCompra(anxCompra);
                                                    anxCompraFormaPago.setFpCodigo(anxFormaPago);
                                                    existeConcepto = true;
                                                } else {
                                                    existeConcepto = false;
                                                }
                                                if (!existeConcepto) {
                                                    i = anxCompraFormaPagoTO.size();
                                                } else {
                                                    anxCompraFormaPagos.add(anxCompraFormaPago);
                                                }
                                            }
                                            if (existeConcepto) {
                                                if (operacionesSistemaDAOLocal.buscarEmpresaParametros(invComprasTO.getEmpCodigo()).getParObligadoLlevarContabilidad()) {
                                                    anxCompra = anexos.helper.ConversionesAnexos.convertirAnxCompraTO_AnxCompra(anxCompraTO);
                                                    if (!invComprasTO.getCompDocumentoTipo().equals("04") && !invComprasTO.getCompDocumentoTipo().equals("05")) {
                                                        anxCompra.setCompModificadoDocumentoEmpresa(null);
                                                        anxCompra.setCompModificadoDocumentoTipo(null);
                                                        anxCompra.setCompModificadoDocumentoNumero(null);
                                                        anxCompra.setCompModificadoAutorizacion(null);
                                                    }

                                                    ///
                                                    for (int i = 0; i < anxCompraDetalleTO.size(); i++) {
                                                        anexos.entity.AnxConcepto anxConcepto = operacionesAnexoDAOLocal.getAnexoConcepto(anxCompraDetalleTO.get(i).getDetConcepto());
                                                        if (anxConcepto != null) {
                                                            anxCompraDividendo = null;
                                                            anxCompraDetalle = anexos.helper.ConversionesAnexos.convertirAnxCompraDetalleTO_AnxCompraDetalle(anxCompraDetalleTO.get(i));
                                                            anxCompraDetalle.setAnxCompra(anxCompra);
                                                            anxCompraDetalle.setDetConcepto(anxConcepto);
                                                            if (anxCompraDetalleTO.get(i).getDivIrAsociado().compareTo(cero) > 0) {
                                                                anxCompraDividendo = anexos.helper.ConversionesAnexos.convertirAnxCompraDetalleTO_AnxCompraDividendo(anxCompraDetalleTO.get(i));
                                                                anxCompraDividendo.setAnxCompra(anxCompra);
                                                                anxCompraDividendo.setConCodigo(anxConcepto);
                                                            }
                                                            existeConcepto = true;
                                                        } else {
                                                            existeConcepto = false;
                                                        }
                                                        if (!existeConcepto) {
                                                            i = anxCompraDetalleTO.size();
                                                        } else {
                                                            anxCompraDetalles.add(anxCompraDetalle);
                                                            if (anxCompraDividendo != null) {
                                                                anxCompraDividendos.add(anxCompraDividendo);
                                                            }
                                                        }
                                                    }
                                                    if (invComprasTO.getCompDocumentoTipo().equals("41")) {
                                                        for (anexos.TO.AnxCompraReembolsoTO o : anxCompraReembolsoTO) {
                                                            System.out.println("o.getProvCodigo() " + o.getProvCodigo());
                                                            anxCompraReembolso = anexos.helper.ConversionesAnexos.convertirAnxCompraReembolsoTO_AnxCompraReembolso(o);
                                                            anxCompraReembolsos.add(anxCompraReembolso);
                                                        }
                                                    }

                                                } else {
                                                    existeConcepto = false;
                                                }
                                            } else {
                                                retorno = "F<html>Algunas de las FORMAS DE PAGO que ha escogido no se encuentra disponible.<br>Contacte con el administrador.</html>";
                                            }
                                        }
                                        if (existeConcepto) {
                                            ////////////COMPROBAR SI NO EXISTE NUMERO DE FACTURA
                                            String codigoFactura = operacionesInventarioDAOLocal.getConteoNumeroFacturaCompra(invComprasTO.getEmpCodigo(),
                                                    invComprasTO.getProvCodigo(), invComprasTO.getCompDocumentoTipo(),
                                                    invComprasTO.getCompDocumentoNumero());

                                            if (codigoFactura.trim().isEmpty() || invComprasTO.getCompDocumentoNumero().equals("999-999-999999999")
                                                    || invComprasTO.getCompDocumentoTipo().equals("00") && invComprasTO.getCompDocumentoTipo().equals("99")) {
                                                boolean noExiste = false;
                                                ////////////COMPROBAR SI EL TIPO DE DOCUMENTO ES 00
                                                boolean continua = true;
                                                if (!invComprasTO.getCompDocumentoTipo().equals("00") && !invComprasTO.getCompDocumentoTipo().equals("99")
                                                        && operacionesSistemaDAOLocal.buscarEmpresaParametros(invComprasTO.getEmpCodigo()).getParObligadoLlevarContabilidad()) {
                                                    if (invComprasTO.getCompDocumentoTipo().equals("04")) {
                                                        if (anxCompraTO == null) {
                                                            continua = false;
                                                            noExiste = true;
                                                        }
                                                    }
                                                    if (continua) {
                                                        ////////////COMPROBAR SI NO EXISTE NUMERO DE RETENCION
                                                        String codigoRetencion = "";
                                                        anxCompraTO.setCompRetencionNumero(anxCompraTO.getCompRetencionNumero() == null ? ""
                                                                : anxCompraTO.getCompRetencionNumero());
                                                        if (!anxCompraTO.getCompRetencionNumero().isEmpty()) {
                                                            codigoRetencion = operacionesAnexoDAOLocal.getConteoNumeroRetencion(anxCompraTO.getEmpCodigo(),
                                                                    anxCompraTO.getCompRetencionNumero());
                                                        } else {
                                                            codigoRetencion = "";
                                                        }
                                                        if (codigoRetencion.trim().isEmpty()) {
                                                            noExiste = true;
                                                        }
                                                    }
                                                } else {
                                                    noExiste = true;
                                                }
                                                if (noExiste) {
                                                    if (!invCompras.getCompPendiente()) {

//                                                        if (invCompras.getCompDocumentoTipo().equals("04")) {
//
//                                                            List<inventario.entity.InvComprasDetalle> listadoDetalleCompra = agrupraProductosBodegaCompra(listInvComprasDetalle);
//                                                            for (int i = 0; i < listadoDetalleCompra.size(); i++) {
//                                                                if (!listadoDetalleCompra.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTOO GASTO")) {
//                                                                    if (!listadoDetalleCompra.get(i).getDetPendiente()) {
//                                                                        invProductoSaldos = new inventario.entity.InvProductoSaldos();
//                                                                        invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invCompras.getInvComprasPK().getCompEmpresa(),
//                                                                                listadoDetalleCompra.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(), listadoDetalleCompra.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
//
//                                                                        ////BUSCO LA BODEGA
//                                                                        invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invCompras.getInvComprasPK().
//                                                                                getCompEmpresa(), listadoDetalleCompra.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
//
//                                                                        ////PONGO EL PRODUCTO
//                                                                        invProductoSaldos.setInvProducto(listadoDetalleCompra.get(i).getInvProducto());
//                                                                        inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
//                                                                                invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
//                                                                                invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
//                                                                        if (invProductoSaldosConsulta != null) { ///Como si
//                                                                            //existe el dato se le suma la nueva cantidad con lo que se va a ingresar //
//                                                                            invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
//                                                                                    subtract(listadoDetalleCompra.get(i).getDetCantidad()));
//                                                                            invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
//                                                                                    add(listadoDetalleCompra.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTOO GASTO") ? cero
//                                                                                    : listadoDetalleCompra.get(i).getDetCantidad()));
//                                                                            if (listadoDetalleCompra.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("INVENTARIO")
//                                                                                    && invProductoSaldos.getStkSaldoFinal().compareTo(cero) >= 0) {
//                                                                                invProductoSaldos.setStkFechaUltimaCompraFinal(invCompras.getCompFecha());
//                                                                                invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());
//                                                                                invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
//                                                                                invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
//                                                                                invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());
//                                                                                listaInvProductoSaldos.add(invProductoSaldos);
//                                                                            } else {
//                                                                                retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
//                                                                                mensajeClase.add("- " + listadoDetalleCompra.get(i).getInvProducto().getProNombre());
//                                                                            }
//                                                                        } else {
//                                                                            retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
//                                                                            mensajeClase.add("- " + listadoDetalleCompra.get(i).getInvProducto().getProNombre());
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//
//                                                        } else {

                                                        List<inventario.entity.InvComprasDetalle> listadoDetalleCompra = agrupraProductosBodegaCompra(listInvComprasDetalle);
                                                        for (int i = 0; i < listadoDetalleCompra.size(); i++) {
                                                            //if (!listadoDetalleCompra.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                            if (!listadoDetalleCompra.get(i).getDetPendiente()) {
                                                                invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                                                invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invCompras.getInvComprasPK().getCompEmpresa(), listadoDetalleCompra.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                        listadoDetalleCompra.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                                ////BUSCO LA BODEGA
                                                                invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(
                                                                        invCompras.getInvComprasPK().getCompEmpresa(),
                                                                        listadoDetalleCompra.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                                ////PONGO EL PRODUCTO
                                                                invProductoSaldos.setInvProducto(listadoDetalleCompra.get(i).getInvProducto());
                                                                inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                                        invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                                        invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                                                if (invProductoSaldosConsulta == null) {
                                                                    /////Cuando no existe el registro se pone crea la cantidad
                                                                    //invProductoSaldos.setStkSaldoFinal(listadoDetalleCompra.get(i).getDetCantidad());

                                                                    invProductoSaldos.setStkSaldoFinal(listadoDetalleCompra.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO") ? cero
                                                                            : listadoDetalleCompra.get(i).getDetCantidad());

                                                                    invProductoSaldos.setStkValorUltimaCompraFinal(listadoDetalleCompra.get(i).getDetPrecio());
                                                                    ///Se pone la fecha de la compra
                                                                    invProductoSaldos.setStkFechaUltimaCompraFinal(invCompras.getCompFecha());
                                                                    invProductoSaldos.setStkSaldoInicial(cero);
                                                                    invProductoSaldos.setStkValorPromedioInicial(cero);
                                                                    invProductoSaldos.setStkValorPromedioFinal(cero);
                                                                    //invProductoSaldos.setStkSaldoFinal(cero);
                                                                } else {
                                                                    if (invProductoSaldosConsulta.getStkFechaUltimaCompraFinal() == null
                                                                            || invCompras.getCompFecha().getTime() >= invProductoSaldosConsulta.getStkFechaUltimaCompraFinal().getTime()) {
                                                                        invProductoSaldos.setStkValorUltimaCompraFinal(listadoDetalleCompra.get(i).getDetPrecio());
                                                                        invProductoSaldos.setStkFechaUltimaCompraFinal(invCompras.getCompFecha());
                                                                    } else {
                                                                        invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());
                                                                        invProductoSaldos.setStkFechaUltimaCompraFinal(invProductoSaldosConsulta.getStkFechaUltimaCompraFinal());
                                                                    }
                                                                    invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                                    invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                                    invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());

                                                                    ///Como si existe el dato se le suma la nueva cantidad con lo que se va a ingresar
//                                                                            invProductoSaldos.setStkSaldoFinal(listadoDetalleCompra.get(i).getDetCantidad().
//                                                                                    add(invProductoSaldosConsulta.getStkSaldoFinal()));
                                                                    invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                            add(listadoDetalleCompra.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO") ? cero
                                                                            : listadoDetalleCompra.get(i).getDetCantidad()));
                                                                }
                                                            }
                                                            listaInvProductoSaldos.add(invProductoSaldos);
                                                            // }
                                                            //}
                                                        }
                                                    }
                                                    if (mensajeClase.isEmpty()) {
                                                        if (invCompras.getCompDocumentoTipo().equals("00") || invCompras.getCompDocumentoTipo().equals("19")) {
                                                            invCompras.setCompDocumentoNumero(null);
                                                        }
                                                        comprobar = operacionesInventarioDAOTransaccionLocal.insertarTransaccionInvCompra(
                                                                invCompras,
                                                                listInvComprasDetalle,
                                                                sisSuceso,
                                                                invComprasNumeracion,
                                                                anxCompra,
                                                                anxCompraDetalles,
                                                                anxCompraDividendos,
                                                                anxCompraReembolsos,
                                                                anxCompraFormaPagos,
                                                                listaInvProductoSaldos);
                                                        if (comprobar) {
                                                            sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(invComprasTO.getEmpCodigo(), invCompras.getInvComprasPK().getCompPeriodo());
                                                            retorno = "T<html>Se ingresó la compra con la siguiente información:<br><br>"
                                                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                                    + "</font>.<br> Motivo: <font size = 5>" + invCompras.getInvComprasPK().
                                                                    getCompMotivo()
                                                                    + "</font>.<br> Número: <font size = 5>" + invCompras.getInvComprasPK().getCompNumero() + "</font>.</html>"
                                                                    + invCompras.getInvComprasPK().getCompNumero() + "," + sisPeriodo.getSisPeriodoPK().getPerCodigo();
                                                        } else {
                                                            retorno = "F<html>Hubo un error al guardar la Compra...\nIntente de nuevo o contacte con el administrador</html>";
                                                        }
                                                    } else {
                                                        mensajeTO.setMensaje(retorno);
                                                        mensajeTO.setListaErrores(mensajeClase);
                                                    }
                                                } else {
                                                    retorno = "F<html>El Número de Retención que ingresó ya existe...\nIntente de nuevo o contacte con el administrador</html>";
                                                }
                                            } else {
                                                retorno = "F<html>El Número de Documento que ingresó ya existe...\nIntente de nuevo o contacte con el administrador</html>";
                                            }
                                        } else {
                                            retorno = "F<html>El Concepto de Retención que ha escogido no se encuentra disponible.<br>Contacte con el administrador.</html>";
                                        }

                                        //}

                                    } else {
                                        if (estadoDetalle == 1) {
                                            retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                        } else {
                                            retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                        }
                                    }
                                } else {
                                    retorno = "F<html>El proveedor que escogió ya no está disponible...\nIntente de nuevo, escoja otro Proveedor o contacte con el administrador</html>";
                                }
                            } else {
                                retorno = "F<html>No se encuentra el motivo...</html>";
                            }
                        } else {
                            retorno = "F<html>El NÚMERO DE RETENCIÓN que ingresó se encuentra ANULADO</html>";
                        }
                    } else {
                        retorno = "F<html>El periodo que corresponde a la fecha que ingresó se encuentra cerrado...</html>";
                    }
                } else {
                    retorno = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
                }
            } else {
                retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
            }
        } catch (Exception e) {
            retorno = "F<html>Error al guardar datos...</html>";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvComprasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
//            return retorno;
        }
    }

    public String getConteoNumeroFacturaVenta(String empresaCodigo, String compDocumentoTipo, String compDocumentoNumero) throws Exception {
        return operacionesInventarioDAOLocal.getConteoNumeroFacturaVenta(empresaCodigo,
                compDocumentoTipo, compDocumentoNumero);
    }

    public inventario.TO.MensajeTO insertarInvVentasTO(
            inventario.TO.InvVentasTO invVentasTO,
            List<inventario.TO.InvVentasDetalleTO> listaInvVentasDetalleTO,
            anexos.TO.AnxVentaTO anxVentasTO,
            String tipoDocumentoComplemento,
            String numeroDocumentoComplemento,
            String estadoVentaElectronica,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        inventario.entity.InvProductoSaldos invProductoSaldos = null;
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        List<String> mensajeClase = new ArrayList(1);
        List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos = new ArrayList(1);
        boolean periodoCerrado = false;
        try {

            boolean continuar = false;
            sistemaWeb.entity.SisEmpresaParametros sisEmpresaParametros = operacionesSistemaDAOLocal.buscarEmpresaParametros(invVentasTO.getVtaEmpresa());
            if (!sisEmpresaParametros.getParActividad().trim().equals("COMISARIATO")) {
                if (!invVentasTO.getVtaAnulado() && !invVentasTO.getVtaPendiente()) {
                    anexos.TO.AnxNumeracionLineaTO anxNumeracionLineaTO = operacionesAnexoDAOLocal.getNumeroAutorizacion(invVentasTO.getVtaEmpresa(),
                            invVentasTO.getVtaDocumentoNumero(), invVentasTO.getVtaDocumentoTipo(), ("'" + invVentasTO.getVtaFecha() + "'"));
                    if (anxNumeracionLineaTO != null) {
                        if (!anxNumeracionLineaTO.getNumeroAutorizacion().trim().equals("ANULADO")) {
                            continuar = true;
                        }
                    } else {
                        continuar = true;
                    }
                } else {
                    continuar = true;
                }
            } else {
                continuar = true;
            }


            if (continuar) {
                List<cartera.TO.CarListaPagosCobrosTO> carListaPagosCobrosTOs = new ArrayList();
                List<cartera.TO.CarListaPagosCobrosTO> carListaPagosCobrosVencidosTOs = new ArrayList();
                if (invVentasTO.getVtaFormaPago().equals("POR PAGAR")) {
                    carListaPagosCobrosTOs = operacionesCarDAOLocal.getCarListaCobrosVentasTO(invVentasTO.getVtaEmpresa(), invVentasTO.getCliCodigo());
                    if (!carListaPagosCobrosTOs.isEmpty()) {
                        for (int i = 0; i < carListaPagosCobrosTOs.size(); i++) {
                            if (validaciones.Validacion.fecha(carListaPagosCobrosTOs.get(i).getCxccFechaVencimiento(), "yyyy-MM-dd").getTime()
                                    <= new Date().getTime()) {
                                carListaPagosCobrosVencidosTOs.add(carListaPagosCobrosTOs.get(i));
                            }
                        }
                    }
                }

                if (carListaPagosCobrosVencidosTOs.isEmpty() || !invVentasTO.getVtaEmpresa().trim().equals("AA")) {
                    if (!validaciones.Validacion.isFechaSuperior(invVentasTO.getVtaFecha(), "yyyy-MM-dd")) {
                        /**
                         *
                         */
                        ///// BUSCANDO CLIENTE
                        inventario.entity.InvCliente invCliente = operacionesInventarioDAOLocal.buscarInvCliente(invVentasTO.getVtaEmpresa(), invVentasTO.getCliCodigo());

                        if (invCliente != null) {
                            /**
                             *
                             */
                            boolean puedeContinuar = true;
                            if (invVentasTO.getVtaFormaPago().equals("POR PAGAR")) {
                                if (validaciones.Validacion.numeroDias("yyyy-MM-dd", invVentasTO.getVtaFecha(),
                                        invVentasTO.getVtaFechaVencimiento()) <= invCliente.getCliDiasCredito()) {
                                    puedeContinuar = true;
                                } else {
                                    puedeContinuar = false;
                                }
                            }
                            if (puedeContinuar) {
                                puedeContinuar = true;
                                java.math.BigDecimal saldoTotalVentaCobros = cero;
                                if (invVentasTO.getVtaFormaPago().equals("POR PAGAR")) {
                                    if (false)//invVentasTO.getVtaEmpresa().trim().equals("AA"))
                                    {
                                        int diaSemana = validaciones.Validacion.getNumeroDia(invVentasTO.getVtaFecha(), "yyyy-MM-dd");
                                        String fechaDesde;
                                        String fechaHasta;
                                        if (diaSemana == 1) {
                                            fechaDesde = validaciones.Validacion.fechaSumarRestarDias(validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd"), diaSemana, 7);
                                            fechaHasta = validaciones.Validacion.fechaSumarRestarDias(validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd"), diaSemana, 1);
                                        } else {
                                            fechaDesde = validaciones.Validacion.fechaSumarRestarDias(validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd"), diaSemana, 2);
                                            fechaHasta = validaciones.Validacion.fechaSumarRestarDias(validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd"), diaSemana, 8);
                                        }
                                        saldoTotalVentaCobros = operacionesInventarioDAOLocal.getInvVentaTotal(invVentasTO.getVtaEmpresa(),
                                                fechaDesde, fechaHasta, invCliente.getInvClientePK().getCliCodigo()).add(invVentasTO.getVtaTotal());
                                    } else {
                                        java.math.BigDecimal saldoTotalCobros = cero;
                                        for (int i = 0; i < carListaPagosCobrosTOs.size(); i++) {
                                            saldoTotalCobros = saldoTotalCobros.add(carListaPagosCobrosTOs.get(i).getCxccSaldo());
                                        }
                                        saldoTotalVentaCobros = saldoTotalCobros.add(invVentasTO.getVtaTotal());
                                    }

                                    if (sisEmpresaParametros.getParActividad().equals("COMERCIAL") || sisEmpresaParametros.getParActividad().trim().equals("COMISARIATO")) {
                                        if (saldoTotalVentaCobros.compareTo(invCliente.getCliCupoCredito()) <= 0) {
                                            puedeContinuar = true;
                                        } else {
                                            puedeContinuar = false;
                                        }
                                    } else {
                                        puedeContinuar = true;
                                    }
                                }
                                if (puedeContinuar) {//
                                    comprobar = false;
                                    List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                                    listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invVentasTO.getVtaEmpresa());

                                    for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                                        if (validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd").getTime()
                                                >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                                                && validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd").getTime()
                                                <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                                            comprobar = true;
                                            invVentasTO.setVtaPeriodo(sisListaPeriodoTO.getPerCodigo());
                                            periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                                        }
                                    }

                                    if (comprobar) {
                                        /**
                                         *
                                         */
                                        if (!periodoCerrado) {
                                            /**
                                             *
                                             */
                                            if (operacionesInventarioDAOLocal.comprobarInvVentasMotivo(invVentasTO.getVtaEmpresa(), invVentasTO.getVtaMotivo())) {
                                                /**
                                                 *
                                                 */
                                                /// PREPARANDO OBJETO SISSUCESO (susClave y susDetalle se llenan en DAOTransaccion)
                                                susSuceso = "INSERT";
                                                susTabla = "inventario.inv_ventas";
                                                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                        susTabla,
                                                        susClave,
                                                        susSuceso,
                                                        susDetalle,
                                                        sisInfoTO);

                                                invVentasTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                                                ////// CREANDO NUMERACION DE VENTA
                                                inventario.entity.InvVentasNumeracion invVentasNumeracion = new inventario.entity.InvVentasNumeracion(new inventario.entity.InvVentasNumeracionPK(invVentasTO.getVtaEmpresa(), invVentasTO.getVtaPeriodo(),
                                                        invVentasTO.getVtaMotivo()));
                                                ////// CREANDO VENTAS
                                                inventario.entity.InvVentas invVentas = inventario.helper.ConversionesInventario.convertirInvVentasTO_InvVentas(invVentasTO);
                                                invVentas.setInvCliente(operacionesInventarioDAOLocal.buscarInvCliente(invVentasTO.getCliEmpresa(), invVentasTO.getCliCodigo()));
                                                ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                                List<inventario.entity.InvVentasDetalle> listInvVentasDetalle = new ArrayList(0);
                                                inventario.entity.InvVentasDetalle invVentasDetalle = null;

                                                int estadoDetalle = 0;
                                                for (inventario.TO.InvVentasDetalleTO invVentasDetalleTO : listaInvVentasDetalleTO) {
                                                    invVentasDetalle = new inventario.entity.InvVentasDetalle();
                                                    invVentasDetalleTO.setVtaPeriodo(invVentasTO.getVtaPeriodo());
                                                    invVentasDetalle = inventario.helper.ConversionesInventario.convertirInvVentasDetalleTO_InvVentasDetalle(invVentasDetalleTO);
                                                    ///// BUSCANDO EL PRODUCTO EN DETALLE
                                                    inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invVentasDetalleTO.getVtaEmpresa(),
                                                            invVentasDetalleTO.getProCodigoPrincipal());
                                                    if (invProducto != null) {
                                                        invVentasDetalle.setInvProducto(invProducto);
                                                        invVentasDetalle.setProCreditoTributario(invProducto.getProCreditoTributario());
                                                        ////// BUSCANDO LA BODEGA EN EL DETALLE
                                                        inventario.entity.InvBodega invBodega = operacionesInventarioDAOLocal.buscarInvBodega(invVentasDetalleTO.getVtaEmpresa(),
                                                                invVentasDetalleTO.getBodCodigo());

                                                        if (invBodega != null) {
                                                            invVentasDetalle.setInvBodega(invBodega);
                                                            listInvVentasDetalle.add(invVentasDetalle);
                                                        } else {
                                                            estadoDetalle = 2;
                                                        }
                                                    } else {
                                                        estadoDetalle = 1;
                                                    }

                                                    if (estadoDetalle == 1 || estadoDetalle == 2) {
                                                        break;
                                                    } else {
                                                        invProducto = null;
                                                    }
                                                }
                                                if (estadoDetalle == 0) {
                                                    /**
                                                     *
                                                     */
                                                    anexos.entity.AnxVenta anxVenta = null;
                                                    if (anxVentasTO != null) {
                                                        anxVentasTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                                                        anxVenta = anexos.helper.ConversionesAnexos.convertirAnxVentaTO_AnxVenta(anxVentasTO);
                                                    }

                                                    ////////////COMPROBAR SI NO EXISTE NUMERO DE FACTURA Y SI ES EMPRESA COMERCIAL YA NO SE PREGUNTA ESO
                                                    String codigoFactura = "";
                                                    codigoFactura = operacionesInventarioDAOLocal.getConteoNumeroFacturaVenta(invVentasTO.getVtaEmpresa(),
                                                            invVentasTO.getVtaDocumentoTipo(), invVentasTO.getVtaDocumentoNumero());

                                                    if (codigoFactura.trim().isEmpty() || invVentasTO.getVtaDocumentoNumero().equals("999-999-999999999")
                                                            || invVentasTO.getVtaDocumentoTipo().equals("00")) {
                                                        boolean noExiste = false;
                                                        ////////////COMPROBAR SI EL TIPO DE DOCUMENTO ES 00
                                                        if (anxVentasTO != null) {
                                                            ////////////COMPROBAR SI NO EXISTE NUMERO DE RETENCION
                                                            String codigoRetencion = "";
                                                            anxVentasTO.setVenRetencionNumero(anxVentasTO.getVenRetencionNumero() == null ? ""
                                                                    : anxVentasTO.getVenRetencionNumero());
                                                            if (!anxVentasTO.getVenRetencionNumero().isEmpty()) {
                                                                codigoRetencion = operacionesAnexoDAOLocal.getConteoNumeroRetencionVenta(anxVentasTO.getVenEmpresa(),
                                                                        anxVentasTO.getVenRetencionNumero(), invCliente.getInvClientePK().getCliCodigo());
                                                            } else {
                                                                codigoRetencion = "";
                                                            }
                                                            if (codigoRetencion.trim().isEmpty()) {
                                                                noExiste = true;
                                                            }
                                                        } else {
                                                            noExiste = true;
                                                        }
                                                        if (noExiste) {
                                                            if (!invVentas.getVtaPendiente()) {
                                                                if (invVentas.getVtaDocumentoTipo().equals("04")) {
                                                                    List<inventario.entity.InvVentasDetalle> listadoDetalleVenta = agrupraProductosBodegaVenta(listInvVentasDetalle);
                                                                    for (int i = 0; i < listadoDetalleVenta.size(); i++) {
                                                                        if (!listadoDetalleVenta.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                                            if (!listadoDetalleVenta.get(i).getDetPendiente()) {
                                                                                invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                                                                invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invVentas.getInvVentasPK().getVtaEmpresa(), listadoDetalleVenta.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                                        listadoDetalleVenta.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                                                ////BUSCO LA BODEGA
                                                                                invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invVentas.getInvVentasPK().
                                                                                        getVtaEmpresa(), listadoDetalleVenta.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                                                ////PONGO EL PRODUCTO
                                                                                invProductoSaldos.setInvProducto(listadoDetalleVenta.get(i).getInvProducto());
                                                                                inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                                                        invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                                                        invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                                                                if (invProductoSaldosConsulta == null) {
                                                                                    /////Cuando no existe el registro se pone crea la cantidad
                                                                                    invProductoSaldos.setStkSaldoFinal(listadoDetalleVenta.get(i).getDetCantidad());
                                                                                    invProductoSaldos.setStkValorUltimaCompraFinal(listadoDetalleVenta.get(i).getDetPrecio());

                                                                                    invProductoSaldos.setStkSaldoInicial(cero);
                                                                                    invProductoSaldos.setStkValorPromedioInicial(cero);
                                                                                    invProductoSaldos.setStkValorPromedioFinal(cero);
                                                                                    ///Se pone la fecha de la compra
                                                                                    invProductoSaldos.setStkFechaUltimaCompraFinal(invVentas.getVtaFecha());
                                                                                } else {
                                                                                    invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());
                                                                                    invProductoSaldos.setStkFechaUltimaCompraFinal(invProductoSaldosConsulta.getStkFechaUltimaCompraFinal());

                                                                                    invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                                                    invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                                                    invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());
                                                                                    ///Como si existe el dato se le suma la nueva cantidad con lo que se va a ingresar
                                                                                    invProductoSaldos.setStkSaldoFinal(listadoDetalleVenta.get(i).getDetCantidad().
                                                                                            add(invProductoSaldosConsulta.getStkSaldoFinal()));
                                                                                }
                                                                            }
                                                                            listaInvProductoSaldos.add(invProductoSaldos);
                                                                        }
                                                                    }
                                                                } else {
                                                                    List<inventario.entity.InvVentasDetalle> listadoDetalleVentas = agrupraProductosBodegaVenta(listInvVentasDetalle);
                                                                    for (int i = 0; i < listadoDetalleVentas.size(); i++) {
                                                                        if (!listadoDetalleVentas.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                                            if (!listadoDetalleVentas.get(i).getDetPendiente()) {
                                                                                invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                                                                invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invVentas.getInvVentasPK().getVtaEmpresa(), listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                                        listadoDetalleVentas.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                                                ////BUSCO LA BODEGA
                                                                                invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invVentas.getInvVentasPK().
                                                                                        getVtaEmpresa(), listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                                                ////PONGO EL PRODUCTO
                                                                                invProductoSaldos.setInvProducto(listadoDetalleVentas.get(i).getInvProducto());
                                                                                inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                                                        invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                                                        invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                                                                if (invProductoSaldosConsulta != null) {
                                                                                    ///Como si existe el dato se le suma la nueva cantidad con lo que se va a ingresar
                                                                                    invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                            subtract(listadoDetalleVentas.get(i).getDetCantidad()));
                                                                                    if (invProductoSaldos.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                                                        invProductoSaldos.setStkFechaUltimaCompraFinal(invVentas.getVtaFecha());
                                                                                        invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());

                                                                                        invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                                                        invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                                                        invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());

                                                                                        listaInvProductoSaldos.add(invProductoSaldos);
                                                                                    } else {
                                                                                        retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                        mensajeClase.add(listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo() + "|" + listadoDetalleVentas.get(i).getInvBodega().getBodNombre() + "\t\t"
                                                                                                + listadoDetalleVentas.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleVentas.get(i).getInvProducto().getProNombre());
                                                                                    }
                                                                                } else {
                                                                                    retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                    mensajeClase.add(listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo() + "|" + listadoDetalleVentas.get(i).getInvBodega().getBodNombre() + "\t\t"
                                                                                            + listadoDetalleVentas.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleVentas.get(i).getInvProducto().getProNombre());
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (mensajeClase.isEmpty()) {
                                                                inventario.entity.InvVentasComplemento invVentasComplemento = null;
                                                                puedeContinuar = false;
                                                                if ((invVentas.getVtaDocumentoTipo().equals("04") || invVentas.getVtaDocumentoTipo().equals("05"))
                                                                        && (!numeroDocumentoComplemento.trim().isEmpty() && !tipoDocumentoComplemento.trim().isEmpty())) {
                                                                    invVentasComplemento = new inventario.entity.InvVentasComplemento();
                                                                    invVentasComplemento.setComDocumentoNumero(numeroDocumentoComplemento);
                                                                    invVentasComplemento.setComDocumentoTipo(tipoDocumentoComplemento);
                                                                    codigoFactura = operacionesInventarioDAOLocal.getConteoNotaCreditoVenta(invVentasTO.getVtaEmpresa(),
                                                                            invVentasTO.getCliCodigo(), tipoDocumentoComplemento, numeroDocumentoComplemento);
                                                                    if (!codigoFactura.trim().isEmpty() || invVentasTO.getVtaDocumentoNumero().equals("999-999-999999999")) {
                                                                        puedeContinuar = true;
                                                                    }
                                                                } else {
                                                                    puedeContinuar = true;
                                                                }
                                                                if (puedeContinuar) {
                                                                    anexos.TO.AnxVentaElectronicaTO anxVentaElectronicaTO = new anexos.TO.AnxVentaElectronicaTO();
                                                                    anexos.entity.AnxVentaElectronica anxVentaElectronica = null;
                                                                    //anexos.entity.AnxDocumentosElectronicosNumeracion anxDocumentosElectronicosNumeracion = null;
                                                                    if (estadoVentaElectronica.equals("ELECTRONICO")) {
                                                                        File file = new File("auxxml.xml");
                                                                        byte[] buffer = new byte[(int) file.length()];
                                                                        //************************clave primaria ****************
                                                                        anxVentaElectronicaTO.seteSecuencial(0);
                                                                        anxVentaElectronicaTO.seteTipoAmbiente("");
                                                                        anxVentaElectronicaTO.seteClaveAcceso("");
                                                                        anxVentaElectronicaTO.seteEstado("PENDIENTE");
                                                                        anxVentaElectronicaTO.seteAutorizacionNumero("");//, "yyyy-mm-dd hh:mm:ss"
                                                                        anxVentaElectronicaTO.seteAutorizacionFecha(validaciones.Validacion.fechaSistema());//16/08/2014 11:38:12.880
                                                                        anxVentaElectronicaTO.seteXml(buffer);
                                                                        anxVentaElectronicaTO.seteEnviadoPorCorreo(false);
                                                                        anxVentaElectronicaTO.setVtaEmpresa("");
                                                                        anxVentaElectronicaTO.setVtaPeriodo("");
                                                                        anxVentaElectronicaTO.setVtaMotivo("");
                                                                        anxVentaElectronicaTO.setVtaNumero("");
                                                                        anxVentaElectronicaTO.setUsrEmpresa(sisInfoTO.getInfEmpresa());
                                                                        anxVentaElectronicaTO.setUsrCodigo(invVentasTO.getUsrCodigo());
                                                                        anxVentaElectronicaTO.setUsrFechaInserta(validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "dd-MM-yyyy", "yyyy-MM-dd"));
                                                                        anxVentaElectronicaTO.setVtaFecha(validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "dd-MM-yyyy", "yyyy-MM-dd"));
                                                                        anxVentaElectronica = anexos.helper.ConversionesAnexos.convertirAnxVentaElectronicaTO_AnxVentaElectronica(anxVentaElectronicaTO);
//                                                                            anxDocumentosElectronicosNumeracion = anexos.helper.ConversionesAnexos.
//                                                                            convertiranxDocumentosElectronicosNumeracionTO_anxDocumentosElectronicosNumeracion(anxDocumentosElectronicosNumeracionTO);

                                                                    }
                                                                    if (invVentas.getVtaDocumentoTipo().equals("00")
                                                                            || (invVentas.getVtaDocumentoNumero().equals("999-999-999999999") && invVentas.getVtaDocumentoTipo().equals("04"))
                                                                            || (invVentas.getVtaDocumentoNumero().equals("999-999-999999999") && invVentas.getVtaDocumentoTipo().equals("05"))) {
                                                                        invVentas.setVtaDocumentoNumero(null);
                                                                    }
                                                                    comprobar = operacionesInventarioDAOTransaccionLocal.insertarTransaccionInvVenta(
                                                                            invVentas,
                                                                            listInvVentasDetalle,
                                                                            sisSuceso,
                                                                            invVentasNumeracion,
                                                                            anxVenta,
                                                                            listaInvProductoSaldos,
                                                                            invVentasComplemento,
                                                                            anxVentaElectronica);

                                                                    if (comprobar) {
                                                                        sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(invVentasTO.getVtaEmpresa(), invVentas.getInvVentasPK().getVtaPeriodo());
                                                                        retorno = "T<html>Se ingresó la venta con la siguiente información:<br><br>"
                                                                                + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                                                + "</font>.<br> Motivo: <font size = 5>" + invVentas.getInvVentasPK().
                                                                                getVtaMotivo()
                                                                                + "</font>.<br> Número: <font size = 5>" + invVentas.getInvVentasPK().getVtaNumero() + "</font>.</html>"
                                                                                + invVentas.getInvVentasPK().getVtaNumero() + "," + sisPeriodo.getSisPeriodoPK().getPerCodigo();

                                                                        if (!carListaPagosCobrosVencidosTOs.isEmpty()) {
                                                                            mensajeClase.add("<html>Cliente tiene deudas vencidas! Avise al cliente que\nse acerque a cancelar lo más pronto...</html>");
                                                                            mensajeClase.add("Número de Sistema\tValor\tFecha de Vencimiento");
                                                                            for (int i = 0; i < carListaPagosCobrosVencidosTOs.size(); i++) {
                                                                                mensajeClase.add(carListaPagosCobrosVencidosTOs.get(i).getCxccPeriodo() + " | "
                                                                                        + carListaPagosCobrosVencidosTOs.get(i).getCxccMotivo() + " | " + carListaPagosCobrosVencidosTOs.get(i).getCxccNumero() + "\t"
                                                                                        + carListaPagosCobrosVencidosTOs.get(i).getCxccSaldo() + "\t" + carListaPagosCobrosVencidosTOs.get(i).getCxccFechaVencimiento());
                                                                            }
                                                                            mensajeTO.setListaErrores(mensajeClase);
                                                                        }
                                                                    } else {
                                                                        retorno = "F<html>Hubo un error al guardar la Venta...\nIntente de nuevo o contacte con el administrador</html>";
                                                                    }
                                                                } else {
                                                                    retorno = "F<html>El Número de Documento del Complemento que ingresó no existe...\nIntente de nuevo o contacte con el administrador</html>";
                                                                }
                                                            } else {
                                                                mensajeTO.setMensaje(retorno);
                                                                mensajeTO.setListaErrores(mensajeClase);
                                                            }
                                                        } else {
                                                            retorno = "F<html>El Número de Retención que ingresó ya existe...\nIntente de nuevo o contacte con el administrador</html>";
                                                        }
                                                    } else {
                                                        retorno = "F<html>El Número de Documento que ingresó ya existe...\nIntente de nuevo o contacte con el administrador</html>";
                                                    }
                                                } else {
                                                    if (estadoDetalle == 1) {
                                                        retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                                    } else {
                                                        retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                                    }
                                                }
                                            } else {
                                                retorno = "F<html>No se encuentra el motivo...</html>";
                                            }
                                        } else {
                                            retorno = "F<html>El periodo que corresponde a la fecha que ingresó se encuentra cerrado...</html>";
                                        }
                                    } else {
                                        retorno = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
                                    }
                                } else {
                                    retorno = "F<html>Se superó el limite del monto del crédito...</html>";
                                }
                            } else {
                                retorno = "F<html>Los días de crédito del Cliente es superior al que se le permite...</html>";
                            }
                        } else {
                            retorno = "F<html>El Cliente que escogió ya no está disponible...\nIntente de nuevo, escoja otro Cliente o contacte con el administrador</html>";
                        }
                    } else {
                        retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
                    }
                } else {
                    retorno = "F<html>Cliente tiene deudas vencidas! Avise al cliente que\nse acerque a cancelar lo más pronto...</html>";
                    mensajeTO.setMensaje(retorno);
                    mensajeClase.add("Número de Sistema\tValor\tFecha de Vencimiento");
                    for (int i = 0; i < carListaPagosCobrosVencidosTOs.size(); i++) {
                        mensajeClase.add(carListaPagosCobrosVencidosTOs.get(i).getCxccPeriodo() + " | "
                                + carListaPagosCobrosVencidosTOs.get(i).getCxccMotivo() + " | " + carListaPagosCobrosVencidosTOs.get(i).getCxccNumero() + "\t"
                                + carListaPagosCobrosVencidosTOs.get(i).getCxccSaldo() + "\t" + carListaPagosCobrosVencidosTOs.get(i).getCxccFechaVencimiento());
                    }
                    mensajeTO.setListaErrores(mensajeClase);
                }
            } else {
                retorno = "F<html>El NÚMERO DE DOCUMENTO que ingresó se encuentra ANULADO</html>";
            }
        } catch (Exception e) {
            retorno = "F<html>Error al guardar datos...</html>";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvVentasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
//            return retorno;
        }
    }

    public inventario.TO.MensajeTO insertarInvProformasTO(inventario.TO.InvProformasTO invProformasTO,
            List<inventario.TO.InvProformasDetalleTO> listaInvProformasDetalleTOs, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        List<String> mensajeClase = new ArrayList(1);
        boolean periodoCerrado = false;
        try {

            if (!validaciones.Validacion.isFechaSuperior(invProformasTO.getProfFecha(), "yyyy-MM-dd")) {
                ///// BUSCANDO CLIENTE
                inventario.entity.InvCliente invCliente = operacionesInventarioDAOLocal.buscarInvCliente(invProformasTO.getProfEmpresa(), invProformasTO.getCliCodigo());

                if (invCliente != null) {
                    boolean puedeContinuar = true;

                    puedeContinuar = true;


                    comprobar = false;
                    List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                    listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invProformasTO.getProfEmpresa());

                    for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                        if (validaciones.Validacion.fecha(invProformasTO.getProfFecha(), "yyyy-MM-dd").getTime()
                                >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                                && validaciones.Validacion.fecha(invProformasTO.getProfFecha(), "yyyy-MM-dd").getTime()
                                <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                            comprobar = true;
                            invProformasTO.setProfPeriodo(sisListaPeriodoTO.getPerCodigo());
                            periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                        }
                    }

                    if (comprobar) {
                        if (!periodoCerrado) {
                            if (operacionesInventarioDAOLocal.comprobarInvProformasMotivo(invProformasTO.getProfEmpresa(), invProformasTO.getProfMotivo())) {
                                /// PREPARANDO OBJETO SISSUCESO (susClave y susDetalle se llenan en DAOTransaccion)
                                susSuceso = "INSERT";
                                susTabla = "inventario.inv_proformas";
                                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                        susTabla,
                                        susClave,
                                        susSuceso,
                                        susDetalle,
                                        sisInfoTO);

                                invProformasTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                                ////// CREANDO NUMERACION DE PROFORMA
                                inventario.entity.InvProformasNumeracion invProformasNumeracion = new inventario.entity.InvProformasNumeracion(new inventario.entity.InvProformasNumeracionPK(invProformasTO.getProfEmpresa(), invProformasTO.getProfPeriodo(),
                                        invProformasTO.getProfMotivo()));
                                ////// CREANDO PROFORMA
                                inventario.entity.InvProformas invProformas = inventario.helper.ConversionesInventario.convertirInvProformasTO_InvProformas(invProformasTO);
                                //invProformas.setInvCliente(operacionesInventarioDAOLocal.buscarInvCliente(invProformasTO.getCliEmpresa(), invProformasTO.getCliCodigo()));
                                invProformas.setInvCliente(invCliente);
                                ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                List<inventario.entity.InvProformasDetalle> listInvProformasDetalle = new ArrayList(0);
                                inventario.entity.InvProformasDetalle invProformasDetalle = null;

                                int estadoDetalle = 0;
                                for (inventario.TO.InvProformasDetalleTO invProformasDetalleTO : listaInvProformasDetalleTOs) {
                                    invProformasDetalle = new inventario.entity.InvProformasDetalle();
                                    invProformasDetalleTO.setProfPeriodo(invProformasTO.getProfPeriodo());
                                    invProformasDetalle = inventario.helper.ConversionesInventario.convertirInvProformasDetalleTO_InvProformasDetalle(invProformasDetalleTO);
                                    ///// BUSCANDO EL PRODUCTO EN DETALLE
                                    inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invProformasDetalleTO.getProfEmpresa(),
                                            invProformasDetalleTO.getProCodigoPrincipal());
                                    if (invProducto != null) {
                                        invProformasDetalle.setInvProducto(invProducto);
                                        if (!invProducto.getProInactivo()) {
                                            listInvProformasDetalle.add(invProformasDetalle);
                                        } else {
                                            estadoDetalle = 2;
                                        }
                                    } else {
                                        estadoDetalle = 1;
                                    }

                                    if (estadoDetalle == 1 || estadoDetalle == 2) {
                                        break;
                                    } else {
                                        invProducto = null;
                                    }
                                }
                                if (estadoDetalle == 0) {
                                    ////////////COMPROBAR SI NO EXISTE NUMERO DE FACTURA Y SI ES EMPRESA COMERCIAL YA NO SE PREGUNTA ESO
                                    comprobar = operacionesInventarioDAOTransaccionLocal.insertarTransaccionInvProformas(invProformas, listInvProformasDetalle,
                                            sisSuceso, invProformasNumeracion);
                                    if (comprobar) {
                                        sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(invProformasTO.getProfEmpresa(), invProformas.getInvProformasPK().getProfPeriodo());
                                        inventario.entity.InvProformasMotivo invProformaMotivo = operacionesInventarioDAOLocal.getInvProformasMotivo(invProformasTO.getProfEmpresa(), invProformas.getInvProformasPK().getProfMotivo());
                                        retorno = "T<html>Se ingresó la proforma con la siguiente información:<br><br>"
                                                + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                + "</font>.<br> Motivo: <font size = 5>" + invProformaMotivo.getPmDetalle()
                                                + "</font>.<br> Número: <font size = 5>" + invProformas.getInvProformasPK().getProfNumero() + "</font>.</html>"
                                                + invProformas.getInvProformasPK().getProfNumero() + "," + sisPeriodo.getSisPeriodoPK().getPerCodigo();
                                    } else {
                                        retorno = "F<html>Hubo un error al guardar la Proforma...\nIntente de nuevo o contacte con el administrador</html>";
                                    }
                                } else {
                                    if (estadoDetalle == 1) {
                                        retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                    } else {
                                        retorno = "F<html>Uno de los Productos que escogió esta como inactivo...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                    }
                                }
                            } else {
                                retorno = "F<html>No se encuentra el motivo...</html>";
                            }
                        } else {
                            retorno = "F<html>El periodo que corresponde a la fecha que ingresó se encuentra cerrado...</html>";
                        }
                    } else {
                        retorno = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
                    }


                } else {
                    retorno = "F<html>El Cliente que escogió ya no está disponible...\nIntente de nuevo, escoja otro Cliente o contacte con el administrador</html>";
                }
            } else {
                retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
            }

        } catch (Exception e) {
            retorno = "F<html>Error al guardar datos...</html>";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvVentasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
//            return retorno;
        }
    }

    public Object[] getCompra(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception {
        return operacionesInventarioDAOLocal.getCompra(empresa, perCodigo, motCodigo, compNumero);
    }

    public Object[] getVenta(String empresa, String perCodigo, String motCodigo, String compNumero) throws Exception {
        return operacionesInventarioDAOLocal.getVenta(empresa, perCodigo, motCodigo, compNumero);
    }

    public inventario.TO.MensajeTO modificarInvComprasTO(
            InvComprasTO invComprasTO,
            List<InvComprasDetalleTO> listaInvComprasDetalleTO,
            List<InvComprasDetalleTO> listaInvComprasEliminarDetalleTO,
            anexos.TO.AnxCompraTO anxCompraTO,
            List<AnxCompraDetalleTO> anxCompraDetalleTO,
            List<AnxCompraDetalleTO> anxCompraDetalleEliminarTO,
            List<AnxCompraReembolsoTO> anxCompraReembolsoTO,
            List<AnxCompraReembolsoTO> anxCompraReembolsoEliminarTO,
            List<AnxCompraFormaPagoTO> anxCompraFormaPagoTO,
            List<AnxCompraFormaPagoTO> anxCompraFormaPagoEliminarTO,
            boolean desmayorizar,
            boolean quitarMotivoAnulacion,
            InvComprasMotivoAnulacion invComprasMotivoAnulacion,
            SisInfoTO sisInfoTO) throws Exception {
        boolean eliminarMotivoAnulacion = false, periodoCerrado = false;
        String retorno = "";
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        try {
            if (!Validacion.isFechaSuperior(invComprasTO.getCompFecha(), "yyyy-MM-dd")) {
                List<SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invComprasTO.getEmpCodigo());

                for (SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (Validacion.fecha(invComprasTO.getCompFecha(), "yyyy-MM-dd").getTime()
                            >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && Validacion.fecha(invComprasTO.getCompFecha(), "yyyy-MM-dd").getTime()
                            <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                        comprobar = true;
                        periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                    }
                }
                if (comprobar) {
                    if (!periodoCerrado) {
                        InvProductoSaldos invProductoSaldos = null;
                        List<InvProductoSaldos> listaInvProductoSaldos = new ArrayList(1);
                        SisSuceso sisSuceso = new SisSuceso();
                        List<String> mensajeClase = new ArrayList(1);

                        boolean continuar = false;
                        if (anxCompraTO != null && (!invComprasTO.getCompAnulado() || !invComprasTO.getCompPendiente())) {
                            if (anxCompraTO.getCompRetencionNumero() != null) {

//                                if(tipoAmbiente!= null && tipoAmbiente.equals("PRODUCCION")){
//                                      continuar = true;
//                                }else{
                                if (anxCompraTO.getRetElectronica()) {
                                    continuar = true;
                                } else {
                                    AnxNumeracionLineaTO anxNumeracionLineaTO = operacionesAnexoDAOLocal.getNumeroAutorizacion(invComprasTO.getEmpCodigo(),
                                            anxCompraTO.getCompRetencionNumero() == null ? "" : anxCompraTO.getCompRetencionNumero(), "07", ("'" + anxCompraTO.getCompRetencionFechaEmision() + "'"));
                                    if (!anxNumeracionLineaTO.getNumeroAutorizacion().trim().equals("ANULADO")) {
                                        continuar = true;
                                    }
                                }
                                // }

                            } else {
                                continuar = true;
                            }
                        } else {
                            continuar = true;
                        }

                        if (continuar) {
                            if (operacionesInventarioDAOLocal.comprobarInvComprasMotivo(invComprasTO.getEmpCodigo(), invComprasTO.getCompMotivo())) {
                                inventario.entity.InvCompras invComprasCreadas = operacionesInventarioDAOLocal.buscarInvCompras(invComprasTO.getEmpCodigo(), invComprasTO.getCompPeriodo(),
                                        invComprasTO.getCompMotivo(), invComprasTO.getCompNumero());
                                boolean validacionModificar = (invComprasCreadas != null && !quitarMotivoAnulacion);
                                boolean validacionRestaurar = (invComprasCreadas != null && invComprasCreadas.getCompAnulado() && quitarMotivoAnulacion);
                                if (validacionModificar || validacionRestaurar) {
                                    ////CREANDO SUCESO
                                    susClave = invComprasTO.getCompPeriodo() + " "
                                            + invComprasTO.getCompMotivo() + " " + invComprasTO.getCompNumero();
                                    String estado = "";
                                    if (invComprasTO.getCompAnulado()) {
                                        estado = "anuló";
                                    } else {
                                        estado = "modificó";
                                    }

                                    if (quitarMotivoAnulacion) {
                                        eliminarMotivoAnulacion = true;
                                        inventario.entity.InvComprasMotivoAnulacion invComprasMotivoAnulacionTmp = operacionesInventarioDAOLocal.buscarCompraMotivo(invComprasTO.getEmpCodigo(), invComprasTO.getCompPeriodo(), invComprasTO.getCompMotivo(), invComprasTO.getCompNumero());
                                        invComprasMotivoAnulacion = new inventario.entity.InvComprasMotivoAnulacion();
                                        invComprasMotivoAnulacion.setAnuComentario(invComprasMotivoAnulacionTmp.getAnuComentario());
                                        invComprasMotivoAnulacion.setInvCompras(invComprasMotivoAnulacionTmp.getInvCompras());
                                        invComprasMotivoAnulacion.setInvComprasMotivoAnulacionPK(invComprasMotivoAnulacionTmp.getInvComprasMotivoAnulacionPK());

                                        estado = "restauró";

                                        susDetalle = "Se " + estado + " la compra en el periodo "
                                                + invComprasTO.getCompPeriodo() + ", del motivo "
                                                + invComprasTO.getCompMotivo() + ", de la numeración "
                                                + invComprasTO.getCompNumero();
                                        susSuceso = "RESTORE";
                                        susTabla = "inventario.inv_compra";
                                        invComprasTO.setCompDocumentoFormaPago(invComprasTO.getCompDocumentoFormaPago() == null ? invComprasCreadas.getCompDocumentoFormaPago() : invComprasTO.getCompDocumentoFormaPago().trim().isEmpty() ? invComprasCreadas.getCompDocumentoFormaPago() : invComprasTO.getCompDocumentoFormaPago());
                                        invComprasTO.setUsrInsertaCompra(invComprasCreadas.getUsrCodigo());
                                        invComprasTO.setUsrFechaInsertaCompra(validaciones.Validacion.fecha(invComprasCreadas.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                                    } else {
                                        susDetalle = "";
                                        if (estado.trim().equals("anuló")) {
                                            susDetalle = "Compra número " + invComprasTO.getCompNumero() + "se anuló por " + invComprasMotivoAnulacion.getAnuComentario();
                                        } else {
                                            susDetalle = "Se " + estado + " la compra en el periodo "
                                                    + invComprasTO.getCompPeriodo() + ", del motivo "
                                                    + invComprasTO.getCompMotivo() + ", de la numeración "
                                                    + invComprasTO.getCompNumero();
                                        }
                                        susSuceso = "UPDATE";
                                        susTabla = "inventario.inv_compra";
                                        invComprasTO.setCompDocumentoFormaPago(invComprasTO.getCompDocumentoFormaPago() == null ? invComprasCreadas.getCompDocumentoFormaPago() : invComprasTO.getCompDocumentoFormaPago().trim().isEmpty() ? invComprasCreadas.getCompDocumentoFormaPago() : invComprasTO.getCompDocumentoFormaPago());
                                        invComprasTO.setUsrInsertaCompra(invComprasCreadas.getUsrCodigo());
                                        invComprasTO.setUsrFechaInsertaCompra(validaciones.Validacion.fecha(invComprasCreadas.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                                    }
                                    sisSuceso = validaciones.Suceso.crearSisSuceso(
                                            susTabla,
                                            susClave,
                                            susSuceso,
                                            susDetalle,
                                            sisInfoTO);
                                    ////// CREANDO COMPRAS
                                    inventario.entity.InvCompras invCompras = ConversionesInventario.convertirInvComprasTO_InvCompras(invComprasTO);
                                    ///// BUSCANDO PROVEEDOR
                                    inventario.entity.InvProveedor invProveedor = operacionesInventarioDAOLocal.buscarInvProveedor(invComprasTO.getEmpCodigo(), invComprasTO.getProvCodigo());

                                    invCompras.setInvProveedor(invProveedor);

                                    String detalleError = "";
                                    if (invProveedor != null) {
                                        if (desmayorizar && listaInvComprasDetalleTO == null) {
                                            List<inventario.TO.InvListaDetalleComprasTO> invListaDetalleTO = operacionesInventarioDAOLocal.getListaInvCompraDetalleTO(invComprasTO.getEmpCodigo(), invComprasTO.getCompPeriodo(), invComprasTO.getCompMotivo(), invComprasTO.getCompNumero());
                                            if (invListaDetalleTO != null) {
                                                listaInvComprasDetalleTO = new ArrayList();
                                                for (int i = 0; i < invListaDetalleTO.size(); i++) {
                                                    inventario.TO.InvComprasDetalleTO invComprasDetalleTO = new inventario.TO.InvComprasDetalleTO();

                                                    invComprasDetalleTO.setDetSecuencia(invListaDetalleTO.get(i).getSecuencial());
                                                    invComprasDetalleTO.setDetOrden(i + 1);
                                                    invComprasDetalleTO.setDetPendiente(invListaDetalleTO.get(i).getPendiente());
                                                    invComprasDetalleTO.setDetCantidad(invListaDetalleTO.get(i).getCantidadProducto());
                                                    invComprasDetalleTO.setDetPrecio(invListaDetalleTO.get(i).getPrecioProducto());
                                                    invComprasDetalleTO.setDetPorcentajeDescuento(invListaDetalleTO.get(i).getPorcentajeDescuento());
                                                    invComprasDetalleTO.setDetConfirnado(true);
                                                    invComprasDetalleTO.setBodEmpresa(invComprasTO.getEmpCodigo());
                                                    invComprasDetalleTO.setBodCodigo(invListaDetalleTO.get(i).getCodigoBodega());
                                                    invComprasDetalleTO.setProEmpresa(invComprasTO.getEmpCodigo());
                                                    invComprasDetalleTO.setProCodigoPrincipal(invListaDetalleTO.get(i).getCodigoProducto());
                                                    invComprasDetalleTO.setSecEmpresa(invComprasTO.getEmpCodigo());
                                                    invComprasDetalleTO.setSecCodigo(invListaDetalleTO.get(i).getCodigoCP());
                                                    invComprasDetalleTO.setPisEmpresa(invComprasTO.getEmpCodigo());
                                                    invComprasDetalleTO.setPisSector(invListaDetalleTO.get(i).getCodigoCP());
                                                    invComprasDetalleTO.setPisNumero(invListaDetalleTO.get(i).getCodigoCC());
                                                    invComprasDetalleTO.setComEmpresa(invComprasTO.getEmpCodigo());
                                                    invComprasDetalleTO.setComPeriodo(invComprasTO.getCompPeriodo());
                                                    invComprasDetalleTO.setComMotivo(invComprasTO.getCompMotivo());
                                                    invComprasDetalleTO.setComNumero(invComprasTO.getCompNumero());

                                                    listaInvComprasDetalleTO.add(invComprasDetalleTO);
                                                }
                                            } else {
                                                detalleError = "Hubo en error al recuperar el detalle de la compra.\nContacte con el administrador...";
                                            }
                                        }
                                        if (quitarMotivoAnulacion && listaInvComprasDetalleTO == null) {
                                            List<inventario.TO.InvListaDetalleComprasTO> invListaDetalleTO = operacionesInventarioDAOLocal.getListaInvCompraDetalleTO(invComprasTO.getEmpCodigo(), invComprasTO.getCompPeriodo(), invComprasTO.getCompMotivo(), invComprasTO.getCompNumero());
                                            if (invListaDetalleTO != null) {
                                                listaInvComprasDetalleTO = new ArrayList();
                                                for (int i = 0; i < invListaDetalleTO.size(); i++) {
                                                    inventario.TO.InvComprasDetalleTO invComprasDetalleTO = new inventario.TO.InvComprasDetalleTO();
                                                    invComprasDetalleTO.setDetSecuencia(invListaDetalleTO.get(i).getSecuencial());
                                                    invComprasDetalleTO.setDetOrden(i + 1);
                                                    invComprasDetalleTO.setDetPendiente(invListaDetalleTO.get(i).getPendiente());
                                                    invComprasDetalleTO.setDetCantidad(invListaDetalleTO.get(i).getCantidadProducto());
                                                    invComprasDetalleTO.setDetPrecio(invListaDetalleTO.get(i).getPrecioProducto());
                                                    invComprasDetalleTO.setDetPorcentajeDescuento(invListaDetalleTO.get(i).getPorcentajeDescuento());
                                                    invComprasDetalleTO.setDetConfirnado(true);
                                                    invComprasDetalleTO.setBodEmpresa(invComprasTO.getEmpCodigo());
                                                    invComprasDetalleTO.setBodCodigo(invListaDetalleTO.get(i).getCodigoBodega());
                                                    invComprasDetalleTO.setProEmpresa(invComprasTO.getEmpCodigo());
                                                    invComprasDetalleTO.setProCodigoPrincipal(invListaDetalleTO.get(i).getCodigoProducto());
                                                    invComprasDetalleTO.setSecEmpresa(invComprasTO.getEmpCodigo());
                                                    invComprasDetalleTO.setSecCodigo(invListaDetalleTO.get(i).getCodigoCP());
                                                    invComprasDetalleTO.setPisEmpresa(invComprasTO.getEmpCodigo());
                                                    invComprasDetalleTO.setPisSector(invListaDetalleTO.get(i).getCodigoCP());
                                                    invComprasDetalleTO.setPisNumero(invListaDetalleTO.get(i).getCodigoCC());
                                                    invComprasDetalleTO.setComEmpresa(invComprasTO.getEmpCodigo());
                                                    invComprasDetalleTO.setComPeriodo(invComprasTO.getCompPeriodo());
                                                    invComprasDetalleTO.setComMotivo(invComprasTO.getCompMotivo());
                                                    invComprasDetalleTO.setComNumero(invComprasTO.getCompNumero());

                                                    listaInvComprasDetalleTO.add(invComprasDetalleTO);
                                                }
                                            } else {
                                                detalleError = "Hubo en error al recuperar el detalle de la compra.\nContacte con el administrador...";
                                            }
                                        }
                                        if (detalleError.trim().isEmpty()) {
                                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                            List<inventario.entity.InvComprasDetalle> listInvComprasDetalle = new ArrayList(0);
                                            inventario.entity.InvComprasDetalle invComprasDetalle = null;

                                            int estadoDetalle = 0;
                                            for (inventario.TO.InvComprasDetalleTO invComprasDetalleTO : listaInvComprasDetalleTO) {
                                                invComprasDetalle = new inventario.entity.InvComprasDetalle();
//                                                invComprasDetalleTO.setPerCodigo(invComprasTO.getCompPeriodo());
                                                invComprasDetalleTO.setDetConfirnado(true);
                                                invComprasDetalle = inventario.helper.ConversionesInventario.convertirInvComprasDetalleTO_InvComprasDetalle(invComprasDetalleTO);
                                                invComprasDetalle.setInvCompras(invCompras);

                                                ///// BUSCANDO EL PRODUCTO EN DETALLE
                                                inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invComprasDetalleTO.getComEmpresa(),
                                                        invComprasDetalleTO.getProCodigoPrincipal());
                                                if (invProducto != null) {
                                                    invComprasDetalle.setInvProducto(invProducto);
                                                    invComprasDetalle.setProCreditoTributario(invProducto.getProCreditoTributario());
                                                    ////// BUSCANDO LA BODEGA EN EL DETALLE
                                                    inventario.entity.InvBodega invBodega = operacionesInventarioDAOLocal.buscarInvBodega(invComprasDetalleTO.getComEmpresa(),
                                                            invComprasDetalleTO.getBodCodigo());

                                                    if (invBodega != null) {
                                                        invComprasDetalle.setInvBodega(invBodega);
                                                        listInvComprasDetalle.add(invComprasDetalle);
                                                    } else {
                                                        estadoDetalle = 2;
                                                    }
                                                } else {
                                                    estadoDetalle = 1;
                                                }

                                                if (estadoDetalle == 1 || estadoDetalle == 2) {
                                                    break;
                                                } else {
                                                    invProducto = null;
                                                }
                                            }
                                            if (estadoDetalle == 0) {

                                                ////// CONVIRTIENDO A ENTIDAD EL DETALLE A ELIMINAR
                                                List<inventario.entity.InvComprasDetalle> listInvComprasDetalleEliminar = new ArrayList(0);
                                                inventario.entity.InvComprasDetalle invComprasDetalleEliminar = null;

                                                int estadoDetalleEliminar = 0;
                                                if (listaInvComprasEliminarDetalleTO != null) {
                                                    for (inventario.TO.InvComprasDetalleTO invComprasDetalleTO : listaInvComprasEliminarDetalleTO) {
                                                        invComprasDetalleEliminar = new inventario.entity.InvComprasDetalle();
//                                                        invComprasDetalleTO.setPerCodigo(invComprasTO.getCompPeriodo());
                                                        invComprasDetalleTO.setDetConfirnado(true);
                                                        invComprasDetalleEliminar = inventario.helper.ConversionesInventario.convertirInvComprasDetalleTO_InvComprasDetalle(invComprasDetalleTO);
                                                        invComprasDetalleEliminar.setProCreditoTributario(false);
                                                        invComprasDetalleEliminar.setInvCompras(invCompras);

                                                        ///// BUSCANDO EL PRODUCTO EN DETALLE
                                                        inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invComprasDetalleTO.getComEmpresa(),
                                                                invComprasDetalleTO.getProCodigoPrincipal());
                                                        if (invProducto != null) {
                                                            invComprasDetalleEliminar.setInvProducto(invProducto);
                                                            ////// BUSCANDO LA BODEGA EN EL DETALLE
                                                            inventario.entity.InvBodega invBodega = operacionesInventarioDAOLocal.buscarInvBodega(invComprasDetalleTO.getComEmpresa(),
                                                                    invComprasDetalleTO.getBodCodigo());

                                                            if (invBodega != null) {
                                                                invComprasDetalleEliminar.setInvBodega(invBodega);
                                                                listInvComprasDetalleEliminar.add(invComprasDetalleEliminar);
                                                            } else {
                                                                estadoDetalleEliminar = 2;
                                                            }
                                                        } else {
                                                            estadoDetalleEliminar = 1;
                                                        }

                                                        if (estadoDetalleEliminar == 1 || estadoDetalleEliminar == 2) {
                                                            break;
                                                        } else {
                                                            invProducto = null;
                                                        }
                                                    }
                                                }
                                                if (estadoDetalleEliminar == 0) {
                                                    boolean existeConcepto = false;
                                                    String nombreConcepto = "";
                                                    anexos.entity.AnxCompra anxCompra = null;
                                                    anexos.entity.AnxCompraDetalle anxCompraDetalle = null;
                                                    anexos.entity.AnxCompraDetalle anxCompraDetalleEliminar = null;
                                                    anexos.entity.AnxCompraDividendo anxCompraDividendo = null;
                                                    anexos.entity.AnxCompraReembolso anxCompraReembolso = null;
                                                    anexos.entity.AnxCompraReembolso anxCompraReembolsoEliminar = null;
                                                    anexos.entity.AnxCompraFormaPago anxCompraFormaPago = null;
                                                    anexos.entity.AnxCompraFormaPago anxCompraFormaPagoEliminar = null;
                                                    List<anexos.entity.AnxCompraDetalle> anxCompraDetalles = new ArrayList();
                                                    List<anexos.entity.AnxCompraDetalle> anxCompraDetallesEliminar = new ArrayList();
                                                    List<anexos.entity.AnxCompraDividendo> anxCompraDividendos = new ArrayList();

                                                    List<anexos.entity.AnxCompraReembolso> anxCompraReembolsos = new ArrayList();
                                                    List<anexos.entity.AnxCompraReembolso> anxCompraReembolsosEliminar = new ArrayList();

                                                    List<anexos.entity.AnxCompraFormaPago> anxCompraFormaPagos = new ArrayList();
                                                    List<anexos.entity.AnxCompraFormaPago> anxCompraFormaPagosEliminar = new ArrayList();
                                                    int estadoError = 0;
                                                    if (!invComprasTO.getCompDocumentoTipo().equals("00") && !invComprasTO.getCompDocumentoTipo().equals("99")
                                                            && operacionesSistemaDAOLocal.buscarEmpresaParametros(invComprasTO.getEmpCodigo()).getParObligadoLlevarContabilidad()) {
                                                        if (invComprasTO.getCompDocumentoTipo().equals("04")) {
                                                            if (anxCompraTO != null) {
                                                                anxCompra = anexos.helper.ConversionesAnexos.convertirAnxCompraTO_AnxCompra(anxCompraTO);
                                                                if (!invComprasTO.getCompDocumentoTipo().equals("04") && !invComprasTO.getCompDocumentoTipo().equals("05")) {
                                                                    anxCompra.setCompModificadoDocumentoEmpresa(null);
                                                                    anxCompra.setCompModificadoDocumentoTipo(null);
                                                                    anxCompra.setCompModificadoDocumentoNumero(null);
                                                                    anxCompra.setCompModificadoAutorizacion(null);
                                                                }
                                                                for (int i = 0; i < anxCompraFormaPagoTO.size(); i++) {
                                                                    anexos.entity.AnxFormaPago anxFormaPago = operacionesAnexoDAOLocal.getAnexoFormaPago(anxCompraFormaPagoTO.get(i).getFpCodigo());
                                                                    if (anxFormaPago != null) {
                                                                        anxCompraFormaPago = anexos.helper.ConversionesAnexos.convertirAnxCompraFormaPagoTO_AnxCompraFormaPago(anxCompraFormaPagoTO.get(i));
                                                                        anxCompraFormaPago.setAnxCompra(anxCompra);
                                                                        anxCompraFormaPago.setFpCodigo(anxFormaPago);
                                                                        existeConcepto = true;
                                                                    } else {
                                                                        existeConcepto = false;
                                                                        estadoError = 2;
                                                                    }
                                                                    if (!existeConcepto) {
                                                                        i = anxCompraFormaPagoTO.size();
                                                                    } else {
                                                                        anxCompraFormaPagos.add(anxCompraFormaPago);
                                                                    }
                                                                }
                                                                if (anxCompraFormaPagoEliminarTO != null && !anxCompraFormaPagoEliminarTO.isEmpty()) {
                                                                    for (int i = 0; i < anxCompraFormaPagoEliminarTO.size(); i++) {
                                                                        anexos.entity.AnxFormaPago anxFormaPago = operacionesAnexoDAOLocal.getAnexoFormaPago(anxCompraFormaPagoEliminarTO.get(i).getFpCodigo());
                                                                        if (anxFormaPago != null) {
                                                                            anxCompraFormaPagoEliminar = anexos.helper.ConversionesAnexos.convertirAnxCompraFormaPagoTO_AnxCompraFormaPago(anxCompraFormaPagoEliminarTO.get(i));
                                                                            anxCompraFormaPagoEliminar.setAnxCompra(anxCompra);
                                                                            anxCompraFormaPagoEliminar.setFpCodigo(anxFormaPago);
                                                                            existeConcepto = true;
                                                                        } else {
                                                                            existeConcepto = false;
                                                                            estadoError = 2;
                                                                        }
                                                                        if (!existeConcepto) {
                                                                            i = anxCompraFormaPagoEliminarTO.size();
                                                                        } else {
                                                                            anxCompraFormaPagos.add(anxCompraFormaPagoEliminar);
                                                                        }
                                                                    }
                                                                }
                                                                //// Esto se modifica cuando ya este funcionando la tabla anxcompradetalle (se le tiene que quitar el if)
                                                                if (anxCompraDetalleTO != null) {
                                                                    for (int i = 0; i < anxCompraDetalleTO.size(); i++) {
                                                                        anexos.entity.AnxConcepto anxConcepto = operacionesAnexoDAOLocal.getAnexoConcepto(anxCompraDetalleTO.get(i).getDetConcepto());
                                                                        if (anxConcepto != null) {
                                                                            anxCompraDividendo = null;
                                                                            anxCompraDetalle = anexos.helper.ConversionesAnexos.convertirAnxCompraDetalleTO_AnxCompraDetalle(anxCompraDetalleTO.get(i));
                                                                            anxCompraDetalle.setAnxCompra(anxCompra);
                                                                            anxCompraDetalle.setDetConcepto(anxConcepto);
                                                                            if ((anxCompraDetalleTO.get(i).getDivIrAsociado() != null) && (anxCompraDetalleTO.get(i).getDivIrAsociado().compareTo(cero) > 0)) {
                                                                                anxCompraDividendo = anexos.helper.ConversionesAnexos.convertirAnxCompraDetalleTO_AnxCompraDividendo(anxCompraDetalleTO.get(i));
                                                                                anxCompraDividendo.setAnxCompra(anxCompra);
                                                                                anxCompraDividendo.setConCodigo(anxConcepto);
                                                                            }
                                                                            existeConcepto = true;
                                                                        } else {
                                                                            existeConcepto = false;
                                                                            estadoError = 1;
                                                                        }
                                                                        if (!existeConcepto) {
                                                                            nombreConcepto = anxCompraDetalleTO.get(i).getDetConcepto();
                                                                            i = anxCompraDetalleTO.size();
                                                                        } else {
                                                                            anxCompraDetalles.add(anxCompraDetalle);
                                                                            if (anxCompraDividendo != null) {
                                                                                anxCompraDividendos.add(anxCompraDividendo);
                                                                            }

                                                                        }
                                                                    }
                                                                    if (anxCompraFormaPagoEliminarTO != null && !anxCompraFormaPagoEliminarTO.isEmpty()) {
                                                                        for (int i = 0; i < anxCompraDetalleEliminarTO.size(); i++) {
                                                                            anexos.entity.AnxConcepto anxConcepto = operacionesAnexoDAOLocal.getAnexoConcepto(anxCompraDetalleEliminarTO.get(i).getDetConcepto());
                                                                            if (anxConcepto != null) {
                                                                                anxCompraDetalleEliminar = anexos.helper.ConversionesAnexos.convertirAnxCompraDetalleTO_AnxCompraDetalle(anxCompraDetalleEliminarTO.get(i));
                                                                                anxCompraDetalleEliminar.setAnxCompra(anxCompra);
                                                                                anxCompraDetalleEliminar.setDetConcepto(anxConcepto);
                                                                                existeConcepto = true;
                                                                            } else {
                                                                                existeConcepto = false;
                                                                                estadoError = 1;
                                                                            }
                                                                            if (!existeConcepto) {
                                                                                nombreConcepto = anxCompraDetalleTO.get(i).getDetConcepto();
                                                                                i = anxCompraDetalleEliminarTO.size();
                                                                            } else {
                                                                                anxCompraDetallesEliminar.add(anxCompraDetalleEliminar);
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    existeConcepto = true;
                                                                }
                                                            } else {
                                                                existeConcepto = true;
                                                            }
                                                        } else { // No es "04 - NOTA DE CREDITO"
                                                            anxCompra = anexos.helper.ConversionesAnexos.convertirAnxCompraTO_AnxCompra(anxCompraTO);

                                                            for (int i = 0; i < anxCompraFormaPagoTO.size(); i++) {
                                                                anexos.entity.AnxFormaPago anxFormaPago = operacionesAnexoDAOLocal.getAnexoFormaPago(anxCompraFormaPagoTO.get(i).getFpCodigo());
                                                                if (anxFormaPago != null) {
                                                                    anxCompraFormaPago = anexos.helper.ConversionesAnexos.convertirAnxCompraFormaPagoTO_AnxCompraFormaPago(anxCompraFormaPagoTO.get(i));
                                                                    anxCompraFormaPago.setAnxCompra(anxCompra);
                                                                    anxCompraFormaPago.setFpCodigo(anxFormaPago);
                                                                    existeConcepto = true;
                                                                } else {
                                                                    existeConcepto = false;
                                                                    estadoError = 2;
                                                                }
                                                                if (!existeConcepto) {
                                                                    i = anxCompraFormaPagoTO.size();
                                                                } else {
                                                                    anxCompraFormaPagos.add(anxCompraFormaPago);
                                                                }
                                                            }
                                                            if (anxCompraFormaPagoEliminarTO != null && !anxCompraFormaPagoEliminarTO.isEmpty()) {
                                                                for (int i = 0; i < anxCompraFormaPagoEliminarTO.size(); i++) {
                                                                    anexos.entity.AnxFormaPago anxFormaPago = operacionesAnexoDAOLocal.getAnexoFormaPago(anxCompraFormaPagoEliminarTO.get(i).getFpCodigo());
                                                                    if (anxFormaPago != null) {
                                                                        anxCompraFormaPagoEliminar = anexos.helper.ConversionesAnexos.convertirAnxCompraFormaPagoTO_AnxCompraFormaPago(anxCompraFormaPagoEliminarTO.get(i));
                                                                        anxCompraFormaPagoEliminar.setAnxCompra(anxCompra);
                                                                        anxCompraFormaPagoEliminar.setFpCodigo(anxFormaPago);
                                                                        existeConcepto = true;
                                                                    } else {
                                                                        existeConcepto = false;
                                                                        estadoError = 2;
                                                                    }
                                                                    if (!existeConcepto) {
                                                                        i = anxCompraFormaPagoEliminarTO.size();
                                                                    } else {
                                                                        anxCompraFormaPagos.add(anxCompraFormaPagoEliminar);
                                                                    }
                                                                }
                                                            }

                                                            if (anxCompraDetalleTO != null) {
                                                                for (int i = 0; i < anxCompraDetalleTO.size(); i++) {
                                                                    anexos.entity.AnxConcepto anxConcepto = operacionesAnexoDAOLocal.getAnexoConcepto(anxCompraDetalleTO.get(i).getDetConcepto());
                                                                    if (anxConcepto != null) {
                                                                        anxCompraDividendo = null;
                                                                        anxCompraDetalle = anexos.helper.ConversionesAnexos.convertirAnxCompraDetalleTO_AnxCompraDetalle(anxCompraDetalleTO.get(i));
                                                                        anxCompraDetalle.setAnxCompra(anxCompra);
                                                                        anxCompraDetalle.setDetConcepto(anxConcepto);
                                                                        if ((anxCompraDetalleTO.get(i).getDivIrAsociado() != null) && (anxCompraDetalleTO.get(i).getDivIrAsociado().compareTo(cero) > 0)) {
                                                                            anxCompraDividendo = anexos.helper.ConversionesAnexos.convertirAnxCompraDetalleTO_AnxCompraDividendo(anxCompraDetalleTO.get(i));
                                                                            anxCompraDividendo.setAnxCompra(anxCompra);
                                                                            anxCompraDividendo.setConCodigo(anxConcepto);
                                                                        }
                                                                        existeConcepto = true;
                                                                    } else {
                                                                        existeConcepto = false;
                                                                        estadoError = 1;
                                                                    }
                                                                    if (!existeConcepto) {
                                                                        nombreConcepto = anxCompraDetalleTO.get(i).getDetConcepto();
                                                                        i = anxCompraDetalleTO.size();
                                                                    } else {
                                                                        anxCompraDetalles.add(anxCompraDetalle);
                                                                        if (anxCompraDividendo != null) {
                                                                            anxCompraDividendos.add(anxCompraDividendo);
                                                                        }
                                                                    }
                                                                }
                                                                for (int i = 0; i < anxCompraDetalleEliminarTO.size(); i++) {
                                                                    anexos.entity.AnxConcepto anxConcepto = operacionesAnexoDAOLocal.getAnexoConcepto(anxCompraDetalleEliminarTO.get(i).getDetConcepto());
                                                                    if (anxConcepto != null) {
                                                                        anxCompraDetalleEliminar = anexos.helper.ConversionesAnexos.convertirAnxCompraDetalleTO_AnxCompraDetalle(anxCompraDetalleEliminarTO.get(i));
                                                                        anxCompraDetalleEliminar.setAnxCompra(anxCompra);
                                                                        anxCompraDetalleEliminar.setDetConcepto(anxConcepto);
                                                                        existeConcepto = true;
                                                                    } else {
                                                                        existeConcepto = false;
                                                                        estadoError = 1;
                                                                    }
                                                                    if (!existeConcepto) {
                                                                        nombreConcepto = anxCompraDetalleTO.get(i).getDetConcepto();
                                                                        i = anxCompraDetalleEliminarTO.size();
                                                                    } else {
                                                                        anxCompraDetallesEliminar.add(anxCompraDetalleEliminar);
                                                                    }
                                                                }
                                                            } else {
                                                                existeConcepto = true;
                                                            }
                                                            //**************************************************
                                                            if (invComprasTO.getCompDocumentoTipo().equals("41")) {
                                                                if (anxCompraReembolsoTO != null) {
                                                                    for (anexos.TO.AnxCompraReembolsoTO o : anxCompraReembolsoTO) {
                                                                        anxCompraReembolso = anexos.helper.ConversionesAnexos.convertirAnxCompraReembolsoTO_AnxCompraReembolso(o);
                                                                        anxCompraReembolsos.add(anxCompraReembolso);
                                                                    }
                                                                    for (anexos.TO.AnxCompraReembolsoTO o : anxCompraReembolsoEliminarTO) {
                                                                        anxCompraReembolsoEliminar = anexos.helper.ConversionesAnexos.convertirAnxCompraReembolsoTO_AnxCompraReembolso(o);
                                                                        anxCompraReembolsosEliminar.add(anxCompraReembolsoEliminar);
                                                                    }
                                                                }
                                                            }
                                                            //**************************************************
                                                        }
                                                    } else {
                                                        existeConcepto = true;
                                                    }

                                                    if (existeConcepto) {
                                                        ////////////COMPROBAR SI NO EXISTE NUMERO DE FACTURA
                                                        String codigoFactura = operacionesInventarioDAOLocal.getConteoNumeroFacturaCompra(invComprasTO.getEmpCodigo(),
                                                                invComprasTO.getProvCodigo(), invComprasTO.getCompDocumentoTipo(),
                                                                invComprasTO.getCompDocumentoNumero());

                                                        if ((codigoFactura.trim().isEmpty() || codigoFactura.trim().equals(invComprasCreadas.getInvComprasPK().getCompEmpresa().trim().
                                                                concat(invComprasCreadas.getInvComprasPK().getCompPeriodo().trim().concat(invComprasCreadas.getInvComprasPK().
                                                                getCompMotivo().trim().concat(invComprasCreadas.getInvComprasPK().getCompNumero().trim())))))
                                                                || (invComprasTO.getCompDocumentoNumero().equals("999-999-999999999") || invComprasTO.getCompDocumentoTipo().equals("00")
                                                                && invComprasTO.getCompDocumentoTipo().equals("99"))) {
                                                            boolean existe = false;
                                                            ////////////COMPROBAR SI EL TIPO DE DOCUMENTO ES 00
                                                            boolean continua = true;
                                                            if (!invComprasTO.getCompDocumentoTipo().equals("00") && !invComprasTO.getCompDocumentoTipo().equals("99")
                                                                    && operacionesSistemaDAOLocal.buscarEmpresaParametros(invComprasTO.getEmpCodigo()).getParObligadoLlevarContabilidad()) {
                                                                if (invComprasTO.getCompDocumentoTipo().equals("04")) {
                                                                    if (anxCompraTO == null) {
                                                                        continua = false;
                                                                        existe = true;
                                                                    }
                                                                }
                                                                if (continua) {
                                                                    ////////////COMPROBAR SI NO EXISTE NUMERO DE RETENCION
                                                                    String codigoRetencion = "";
                                                                    anxCompraTO.setCompRetencionNumero(anxCompraTO.getCompRetencionNumero() == null ? ""
                                                                            : anxCompraTO.getCompRetencionNumero());
                                                                    if (!anxCompraTO.getCompRetencionNumero().isEmpty()) {
                                                                        codigoRetencion = operacionesAnexoDAOLocal.getConteoNumeroRetencion(anxCompraTO.getEmpCodigo(),
                                                                                anxCompraTO.getCompRetencionNumero());
                                                                        if (codigoRetencion.trim().isEmpty() || codigoRetencion.trim().equals(invComprasCreadas.getInvComprasPK().getCompEmpresa().trim().
                                                                                concat(invComprasCreadas.getInvComprasPK().getCompPeriodo().trim().concat(invComprasCreadas.getInvComprasPK().
                                                                                getCompMotivo().trim().concat(invComprasCreadas.getInvComprasPK().getCompNumero().trim()))))) {
                                                                            existe = true;
                                                                        } else {
                                                                            retorno = "F<html>El Número de Retención que ingresó ya existe...\nIntente de nuevo o contacte con el administrador</html>";
                                                                            existe = false;
                                                                        }
                                                                    } else {
                                                                        existe = true;
                                                                    }
                                                                }
                                                            } else {
                                                                existe = true;
                                                            }
                                                            if (existe) {
                                                                if (!invCompras.getCompPendiente() && !invCompras.getCompAnulado()) {
                                                                    if (invCompras.getCompDocumentoTipo().equals("04")) {
                                                                        List<inventario.entity.InvComprasDetalle> listadoDetalleCompras = agrupraProductosBodegaCompra(listInvComprasDetalle);
                                                                        for (int i = 0; i < listadoDetalleCompras.size(); i++) {
                                                                            if (!listadoDetalleCompras.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                                                invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                                                                invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invCompras.getInvComprasPK().getCompEmpresa(), listadoDetalleCompras.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                                        listadoDetalleCompras.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                                                ////BUSCO LA BODEGA
                                                                                invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invCompras.getInvComprasPK().
                                                                                        getCompEmpresa(), listadoDetalleCompras.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                                                ////PONGO EL PRODUCTO
                                                                                invProductoSaldos.setInvProducto(listadoDetalleCompras.get(i).getInvProducto());
                                                                                inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                                                        invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                                                        invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                                                                if (invProductoSaldosConsulta != null) {
                                                                                    ///Como si existe el dato se le suma la nueva cantidad con lo que se va a ingresar
                                                                                    if (desmayorizar || invCompras.getCompAnulado()) {
                                                                                        invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                                add(listadoDetalleCompras.get(i).getDetCantidad()));
                                                                                    } else {
                                                                                        invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                                subtract(listadoDetalleCompras.get(i).getDetCantidad()));
                                                                                    }
                                                                                    if (invProductoSaldos.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                                                        invProductoSaldos.setStkFechaUltimaCompraFinal(invCompras.getCompFecha());
                                                                                        invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());

                                                                                        invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                                                        invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                                                        invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());

                                                                                        listaInvProductoSaldos.add(invProductoSaldos);
                                                                                    } else {
                                                                                        retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                        mensajeClase.add(listadoDetalleCompras.get(i).getInvBodega().getInvBodegaPK().getBodCodigo() + "|" + listadoDetalleCompras.get(i).getInvBodega().getBodNombre() + "\t\t"
                                                                                                + listadoDetalleCompras.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleCompras.get(i).getInvProducto().getProNombre());
                                                                                    }
                                                                                } else {
                                                                                    retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                    mensajeClase.add(listadoDetalleCompras.get(i).getInvBodega().getInvBodegaPK().getBodCodigo() + "|" + listadoDetalleCompras.get(i).getInvBodega().getBodNombre() + "\t\t"
                                                                                            + listadoDetalleCompras.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleCompras.get(i).getInvProducto().getProNombre());
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        List<inventario.entity.InvComprasDetalle> listadoDetalleCompras = agrupraProductosBodegaCompra(listInvComprasDetalle);
                                                                        for (int i = 0; i < listadoDetalleCompras.size(); i++) {
                                                                            if (!listadoDetalleCompras.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                                                if (!listadoDetalleCompras.get(i).getDetPendiente()) {
                                                                                    invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                                                                    invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invCompras.getInvComprasPK().getCompEmpresa(), listadoDetalleCompras.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                                            listadoDetalleCompras.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                                                    ////BUSCO LA BODEGA
                                                                                    invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invCompras.getInvComprasPK().
                                                                                            getCompEmpresa(), listadoDetalleCompras.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                                                    ////PONGO EL PRODUCTO
                                                                                    invProductoSaldos.setInvProducto(listadoDetalleCompras.get(i).getInvProducto());
                                                                                    inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                                                            invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                                                            invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                                                                    if (invProductoSaldosConsulta == null) {
                                                                                        /////Cuando no existe el registro se pone crea la cantidad
                                                                                        invProductoSaldos.setStkSaldoFinal(listadoDetalleCompras.get(i).getDetCantidad());
                                                                                        invProductoSaldos.setStkValorUltimaCompraFinal(listadoDetalleCompras.get(i).getDetPrecio());
                                                                                        ///Se pone la fecha de la compra
                                                                                        invProductoSaldos.setStkFechaUltimaCompraFinal(invCompras.getCompFecha());

                                                                                        invProductoSaldos.setStkSaldoInicial(cero);
                                                                                        invProductoSaldos.setStkValorPromedioInicial(cero);
                                                                                        invProductoSaldos.setStkValorPromedioFinal(cero);

                                                                                    } else {
                                                                                        if (invProductoSaldosConsulta.getStkFechaUltimaCompraFinal() == null || invCompras.getCompFecha().getTime() >= invProductoSaldosConsulta.getStkFechaUltimaCompraFinal().getTime()) {
                                                                                            invProductoSaldos.setStkValorUltimaCompraFinal(listadoDetalleCompras.get(i).getDetPrecio());
                                                                                            invProductoSaldos.setStkFechaUltimaCompraFinal(invCompras.getCompFecha());
                                                                                        } else {
                                                                                            invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());
                                                                                            invProductoSaldos.setStkFechaUltimaCompraFinal(invProductoSaldosConsulta.getStkFechaUltimaCompraFinal());
                                                                                        }

                                                                                        invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                                                        invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                                                        invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());

                                                                                        ///Como si existe el dato se le suma la nueva cantidad con lo que se va a ingresar
                                                                                        invProductoSaldos.setStkSaldoFinal(listadoDetalleCompras.get(i).getDetCantidad().
                                                                                                add(invProductoSaldosConsulta.getStkSaldoFinal()));
                                                                                    }
                                                                                    listaInvProductoSaldos.add(invProductoSaldos);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (desmayorizar || invCompras.getCompAnulado()) {

                                                                        if (invCompras.getCompDocumentoTipo().equals("04")) {
                                                                            List<inventario.entity.InvComprasDetalle> listadoDetalleCompras = agrupraProductosBodegaCompra(listInvComprasDetalle);
                                                                            for (int i = 0; i < listadoDetalleCompras.size(); i++) {
                                                                                if (!listadoDetalleCompras.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                                                    if (!listadoDetalleCompras.get(i).getDetPendiente()) {
                                                                                        invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                                                                        invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invCompras.getInvComprasPK().getCompEmpresa(), listadoDetalleCompras.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                                                listadoDetalleCompras.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                                                        ////BUSCO LA BODEGA
                                                                                        invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invCompras.getInvComprasPK().
                                                                                                getCompEmpresa(), listadoDetalleCompras.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                                                        ////PONGO EL PRODUCTO
                                                                                        invProductoSaldos.setInvProducto(listadoDetalleCompras.get(i).getInvProducto());
                                                                                        inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                                                                invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                                                                invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                                                                        if (invProductoSaldosConsulta != null) {
                                                                                            ///Como si existe el dato se le suma la nueva cantidad con lo que se va a ingresar
                                                                                            if (desmayorizar || invCompras.getCompAnulado()) {
                                                                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                                        add(listadoDetalleCompras.get(i).getDetCantidad()));
                                                                                            } else {
                                                                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                                        subtract(listadoDetalleCompras.get(i).getDetCantidad()));
                                                                                            }
                                                                                            if (invProductoSaldos.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                                                                invProductoSaldos.setStkFechaUltimaCompraFinal(invCompras.getCompFecha());
                                                                                                invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());

                                                                                                invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                                                                invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                                                                invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());

                                                                                                listaInvProductoSaldos.add(invProductoSaldos);
                                                                                            } else {
                                                                                                retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                                mensajeClase.add(listadoDetalleCompras.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleCompras.get(i).getInvProducto().getProNombre());
                                                                                            }
                                                                                        } else {
                                                                                            retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                            mensajeClase.add(listadoDetalleCompras.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleCompras.get(i).getInvProducto().getProNombre());
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            List<inventario.entity.InvComprasDetalle> listadoDetalleCompras = agrupraProductosBodegaCompra(listInvComprasDetalle);
                                                                            for (int i = 0; i < listadoDetalleCompras.size(); i++) {
                                                                                if (!listadoDetalleCompras.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                                                    if (!listadoDetalleCompras.get(i).getDetPendiente()) {
                                                                                        invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                                                                        invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invCompras.getInvComprasPK().getCompEmpresa(), listadoDetalleCompras.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                                                listadoDetalleCompras.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                                                        ////BUSCO LA BODEGA
                                                                                        invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invCompras.getInvComprasPK().
                                                                                                getCompEmpresa(), listadoDetalleCompras.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                                                        ////PONGO EL PRODUCTO
                                                                                        invProductoSaldos.setInvProducto(listadoDetalleCompras.get(i).getInvProducto());
                                                                                        inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                                                                invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                                                                invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                                                                        if (invProductoSaldosConsulta != null) {
                                                                                            ///Como si existe el dato se le resta la nueva cantidad con lo que se va a ingresar
                                                                                            if (desmayorizar || invCompras.getCompAnulado()) {
                                                                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                                        subtract(listadoDetalleCompras.get(i).getDetCantidad()));
                                                                                            } else {
                                                                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                                        add(listadoDetalleCompras.get(i).getDetCantidad()));
                                                                                            }
                                                                                            if (invProductoSaldos.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                                                                //                                                                                if (invProductoSaldos.getStkSaldo().compareTo(cero) >= 0 && desmayorizar || invCompras.getCompAnulado()){
                                                                                                invProductoSaldos.setStkFechaUltimaCompraFinal(invCompras.getCompFecha());
                                                                                                invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());

                                                                                                invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                                                                invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                                                                invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());

                                                                                                listaInvProductoSaldos.add(invProductoSaldos);
                                                                                            } else {
                                                                                                retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                                mensajeClase.add(listadoDetalleCompras.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleCompras.get(i).getInvProducto().getProNombre());
                                                                                            }
                                                                                        } else {
                                                                                            retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                            mensajeClase.add(listadoDetalleCompras.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleCompras.get(i).getInvProducto().getProNombre());
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                                contabilidad.entity.ConContable conContable = null;
                                                                List<sistemaWeb.entity.SisSuceso> listaSisSuceso = new ArrayList();

                                                                if (mensajeClase.isEmpty()) {
                                                                    if (invCompras.getCompAnulado()) {
                                                                        conContable = operacionesContabilidadDAOLocal.buscarContable(invCompras.getConEmpresa(), invCompras.getConPeriodo(), invCompras.getConTipo(), invCompras.getConNumero());
                                                                        if (conContable != null) {
                                                                            conContable.setConAnulado(true);
                                                                            susSuceso = "DELETE";
                                                                            sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                                                    susTabla,
                                                                                    susClave,
                                                                                    susSuceso,
                                                                                    susDetalle,
                                                                                    sisInfoTO);
                                                                            listaSisSuceso.add(sisSuceso);
                                                                            ///////////////NUEVO SUCESO PARA CONTABLE
                                                                            sistemaWeb.entity.SisSuceso sisSucesoContable = validaciones.Suceso.crearSisSuceso(
                                                                                    "contabilidad.con_contable",
                                                                                    conContable.getConContablePK().getConPeriodo() + " " + conContable.getConContablePK().getConTipo() + " " + conContable.getConContablePK().getConNumero(),
                                                                                    "DELETE",
                                                                                    "Se anuló el contable del periodo " + conContable.getConContablePK().getConPeriodo() + ", del tipo " + conContable.getConContablePK().getConTipo() + ", de la numeración " + conContable.getConContablePK().getConNumero(),
                                                                                    sisInfoTO);
                                                                            listaSisSuceso.add(sisSucesoContable);
                                                                            sisSuceso = null;
                                                                        }
                                                                    } else {
                                                                        if (desmayorizar) {
                                                                            conContable = operacionesContabilidadDAOLocal.buscarContable(invCompras.getConEmpresa(), invCompras.getConPeriodo(), invCompras.getConTipo(), invCompras.getConNumero());
                                                                            if (conContable != null) {
                                                                                conContable.setConPendiente(true);
                                                                            }
                                                                        } else {
                                                                            conContable = operacionesContabilidadDAOLocal.buscarContable(invCompras.getConEmpresa(), invCompras.getConPeriodo(), invCompras.getConTipo(), invCompras.getConNumero());
                                                                            if (conContable != null) {
                                                                                conContable.setConPendiente(false);
                                                                            }
                                                                        }
                                                                    }

                                                                    if (quitarMotivoAnulacion) {
                                                                        conContable = operacionesContabilidadDAOLocal.buscarContable(invCompras.getConEmpresa(), invCompras.getConPeriodo(), invCompras.getConTipo(), invCompras.getConNumero());
                                                                        if (conContable != null) {
                                                                            conContable.setConAnulado(false);
                                                                            susSuceso = "RESTORE";
                                                                            sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                                                    susTabla,
                                                                                    susClave,
                                                                                    susSuceso,
                                                                                    susDetalle,
                                                                                    sisInfoTO);
                                                                            listaSisSuceso.add(sisSuceso);
                                                                            ///////////////NUEVO SUCESO PARA CONTABLE
                                                                            sistemaWeb.entity.SisSuceso sisSucesoContable = validaciones.Suceso.crearSisSuceso(
                                                                                    "contabilidad.con_contable",
                                                                                    conContable.getConContablePK().getConPeriodo() + " " + conContable.getConContablePK().getConTipo() + " " + conContable.getConContablePK().getConNumero(),
                                                                                    "RESTORE",
                                                                                    "Se restauró el contable del periodo " + conContable.getConContablePK().getConPeriodo() + ", del tipo " + conContable.getConContablePK().getConTipo() + ", de la numeración " + conContable.getConContablePK().getConNumero(),
                                                                                    sisInfoTO);
                                                                            listaSisSuceso.add(sisSucesoContable);
                                                                            sisSuceso = null;
                                                                        }
                                                                    }

                                                                    if (invCompras.getCompAnulado()) {
                                                                        invComprasMotivoAnulacion.setInvCompras(invCompras);
                                                                    }

                                                                    if (invCompras.getCompDocumentoTipo().equals("00") || invCompras.getCompDocumentoTipo().equals("19")) {
                                                                        invCompras.setCompDocumentoNumero(null);
                                                                    }

                                                                    comprobar = operacionesInventarioDAOTransaccionLocal.modificarInvCompras(
                                                                            invCompras,
                                                                            listInvComprasDetalle,
                                                                            listInvComprasDetalleEliminar,
                                                                            anxCompra,
                                                                            anxCompraDetalles,
                                                                            anxCompraDetallesEliminar,
                                                                            anxCompraDividendos,
                                                                            anxCompraReembolsos,
                                                                            anxCompraReembolsosEliminar,
                                                                            anxCompraFormaPagos,
                                                                            anxCompraFormaPagosEliminar,
                                                                            sisSuceso,
                                                                            listaSisSuceso,
                                                                            listaInvProductoSaldos,
                                                                            conContable,
                                                                            invComprasMotivoAnulacion,
                                                                            eliminarMotivoAnulacion);

                                                                    if (comprobar) {
                                                                        sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(invComprasTO.getEmpCodigo(), invCompras.getInvComprasPK().getCompPeriodo());

                                                                        retorno = "T<html>Se " + estado + " la compra con la siguiente información:<br><br>"
                                                                                + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                                                + "</font>.<br> Motivo: <font size = 5>" + invCompras.getInvComprasPK().
                                                                                getCompMotivo()
                                                                                + "</font>.<br> Número: <font size = 5>" + invCompras.getInvComprasPK().getCompNumero() + "</font>.</html>"
                                                                                + invCompras.getInvComprasPK().getCompNumero() + "," + sisPeriodo.getSisPeriodoPK().getPerCodigo();
                                                                    } else {
                                                                        retorno = "F<html>Hubo un error al modificar la Compra...\nIntente de nuevo o contacte con el administrador</html>";
                                                                    }
                                                                } else {
                                                                    mensajeTO.setMensaje(retorno);
                                                                    mensajeTO.setListaErrores(mensajeClase);
                                                                }


                                                            } else//retorno = "F<html>El Número de Retención que ingresó ya existe...\nIntente de nuevo o contacte con el administrador</html>";
                                                            {
                                                                retorno = "F<html>El Número de Retención que ingresó ya existe.<br>Intente de nuevo o contacte con el administrador</html>";
                                                            }
                                                        } else {
                                                            retorno = "F<html>El Número de comprobante que ingresó ya existe..<br>Intente de nuevo o contacte con el administrador</html>";
                                                        }

                                                    } else {
                                                        if (estadoError == 1) {
                                                            retorno = "F<html>El Concepto de Retención " + nombreConcepto + " que ha escogido no se encuentra disponible.<br>Contacte con el administrador.</html>";
                                                        } else {
                                                            retorno = "F<html>El Concepto de Retención " + nombreConcepto + " que ha escogido no se encuentra disponible.<br>Contacte con el administrador.</html>";
                                                        }
                                                    }
                                                } else {
                                                    if (estadoDetalleEliminar == 1) {
                                                        retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                                    } else {
                                                        retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                                    }
                                                }
                                            } else {
                                                if (estadoDetalle == 1) {
                                                    retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                                } else {
                                                    retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                                }
                                            }
                                        } else {
                                            retorno = "F<html>" + detalleError + "</html>";
                                        }
                                    } else {
                                        retorno = "F<html>El Proveedor que escogió ya no está disponible...\nIntente de nuevo, escoja otro Proveedor o contacte con el administrador</html>";
                                    }
                                } else {
                                    if (validacionModificar) {
                                        retorno = "F<html>La compra que quiere modificar ya no se encuentra disponible.</html>";
                                    } else {
                                        retorno = "F<html>La compra que desea restaurar NO existe o NO está anulada</html>";
                                    }
                                }
                            } else {
                                retorno = "F<html>No se encuentra el Motivo...</html>";
                            }
                        } else {
                            retorno = "F<html>El NÚMERO DE RETENCIÓN que ingresó se encuentra ANULADO</html>";
                        }
                    } else {
                        retorno = "F<html>No se puede MAYORIZAR, DESMAYORIZAR o ANULAR debido a que el periodo se encuentra cerrado</html>";
                    }
                } else {
                    retorno = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
                }
            } else {
                retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
            }
        } catch (Exception e) {
            retorno = "F<html>Error al guardar datos...</html>";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvComprasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
        }
    }

    public inventario.TO.MensajeTO modificarInvVentasTO(
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
        boolean eliminarMotivoAnulacion = false;
        MensajeTO mensajeTO = new MensajeTO();
        List<String> mensajeClase = new ArrayList(1);
        SisSuceso sisSuceso;

        InvProductoSaldos invProductoSaldos = null;
        List<InvProductoSaldos> listaInvProductoSaldos = new ArrayList(1);
        String retorno = "";
        boolean periodoCerrado = false;
        try {
            boolean continuar = false;

            sistemaWeb.entity.SisEmpresaParametros sisEmpresaParametros = operacionesSistemaDAOLocal.buscarEmpresaParametros(invVentasTO.getVtaEmpresa());
            if (!sisEmpresaParametros.getParActividad().trim().equals("COMISARIATO")) {
                if (!invVentasTO.getVtaAnulado() && !invVentasTO.getVtaPendiente()) {
                    anexos.TO.AnxNumeracionLineaTO anxNumeracionLineaTO = operacionesAnexoDAOLocal.getNumeroAutorizacion(invVentasTO.getVtaEmpresa(),
                            invVentasTO.getVtaDocumentoNumero(), invVentasTO.getVtaDocumentoTipo(), ("'" + invVentasTO.getVtaFecha() + "'"));
                    if (anxNumeracionLineaTO != null) {
                        if (!anxNumeracionLineaTO.getNumeroAutorizacion().trim().equals("ANULADO")) {
                            continuar = true;
                        }
                    } else {
                        continuar = true;
                    }
                } else {
                    continuar = true;
                }
            } else {
                continuar = true;
            }
            if (continuar) {
                List<cartera.TO.CarListaPagosCobrosTO> carListaPagosCobrosTOs = new ArrayList();
                List<cartera.TO.CarListaPagosCobrosTO> carListaPagosCobrosVencidosTOs = new ArrayList();
                if (invVentasTO.getVtaFormaPago().equals("POR PAGAR") && !desmayorizar && !invVentasTO.getVtaAnulado() && !invVentasTO.getVtaPendiente()) {
                    carListaPagosCobrosTOs = operacionesCarDAOLocal.getCarListaCobrosVentasTO(invVentasTO.getVtaEmpresa(), invVentasTO.getCliCodigo());
                    if (!carListaPagosCobrosTOs.isEmpty()) {
                        for (int i = 0; i < carListaPagosCobrosTOs.size(); i++) {
                            if (validaciones.Validacion.fecha(carListaPagosCobrosTOs.get(i).getCxccFechaVencimiento(), "yyyy-MM-dd").getTime()
                                    <= new Date().getTime()) {
                                carListaPagosCobrosVencidosTOs.add(carListaPagosCobrosTOs.get(i));
                            }
                        }
                    }
                }

                if (carListaPagosCobrosVencidosTOs.isEmpty() || !invVentasTO.getVtaEmpresa().trim().equals("AA")) {
                    if (!validaciones.Validacion.isFechaSuperior(invVentasTO.getVtaFecha(), "yyyy-MM-dd")) {
                        /**
                         *
                         */
                        ///// BUSCANDO CLIENTE
                        inventario.entity.InvCliente invCliente = operacionesInventarioDAOLocal.buscarInvCliente(invVentasTO.getVtaEmpresa(), invVentasTO.getCliCodigo());

                        if (invCliente != null) {
                            String detalleError = "";
                            if (desmayorizar && listaInvVentasDetalleTO == null) {
                                List<inventario.TO.InvListaDetalleVentasTO> invListaDetalleTO = operacionesInventarioDAOLocal.getListaInvVentasDetalleTO(invVentasTO.getVtaEmpresa(), invVentasTO.getVtaPeriodo(), invVentasTO.getVtaMotivo(), invVentasTO.getVtaNumero());
                                if (invListaDetalleTO != null) {
                                    listaInvVentasDetalleTO = new ArrayList();
                                    for (int i = 0; i < invListaDetalleTO.size(); i++) {
                                        inventario.TO.InvVentasDetalleTO invVentasDetalleTO = new inventario.TO.InvVentasDetalleTO();
                                        invVentasDetalleTO.setDetSecuencia(invListaDetalleTO.get(i).getSecuencial());
                                        invVentasDetalleTO.setDetOrden(i + 1);
                                        invVentasDetalleTO.setDetPendiente(invListaDetalleTO.get(i).getPendiente());
                                        invVentasDetalleTO.setDetCantidad(invListaDetalleTO.get(i).getCantidadProducto());
                                        invVentasDetalleTO.setDetPrecio(invListaDetalleTO.get(i).getPrecioProducto());
                                        invVentasDetalleTO.setDetPorcentajeRecargo(invListaDetalleTO.get(i).getPorcentajeRecargo());
                                        invVentasDetalleTO.setDetPorcentajeDescuento(invListaDetalleTO.get(i).getPorcentajeDescuento());

//                                        invVentasDetalleTO.setDetValorPromedio(cero);// revisar
//                                        invVentasDetalleTO.setDetValorUltimaCompra(cero);// revisar
//                                        invVentasDetalleTO.setDetSaldo(cero);// revisar

                                        invVentasDetalleTO.setBodEmpresa(invVentasTO.getVtaEmpresa());
                                        invVentasDetalleTO.setBodCodigo(invListaDetalleTO.get(i).getCodigoBodega());
                                        invVentasDetalleTO.setProEmpresa(invVentasTO.getVtaEmpresa());
                                        invVentasDetalleTO.setProCodigoPrincipal(invListaDetalleTO.get(i).getCodigoProducto());
                                        invVentasDetalleTO.setProNombre(invListaDetalleTO.get(i).getNombreProducto());

//                                        invVentasDetalleTO.setProCreditoTributario(false);// revisa
                                        invVentasDetalleTO.setSecEmpresa(invVentasTO.getVtaEmpresa());
                                        invVentasDetalleTO.setSecCodigo(invListaDetalleTO.get(i).getCodigoCP());
                                        invVentasDetalleTO.setPisEmpresa(invVentasTO.getVtaEmpresa());
                                        invVentasDetalleTO.setPisSector(invListaDetalleTO.get(i).getCodigoCP());
                                        invVentasDetalleTO.setPisNumero(invListaDetalleTO.get(i).getCodigoCC());
                                        invVentasDetalleTO.setVtaEmpresa(invVentasTO.getVtaEmpresa());
                                        invVentasDetalleTO.setVtaPeriodo(invVentasTO.getVtaPeriodo());
                                        invVentasDetalleTO.setVtaMotivo(invVentasTO.getVtaMotivo());
                                        invVentasDetalleTO.setVtaNumero(invVentasTO.getVtaNumero());

                                        listaInvVentasDetalleTO.add(invVentasDetalleTO);
                                    }
                                } else {
                                    detalleError = "Hubo en error al recuperar el detalle de la VENTA.\nContacte con el administrador...";
                                }
                            }

                            if (quitarAnulado && listaInvVentasDetalleTO == null) {
                                List<InvListaDetalleVentasTO> invListaDetalleTO = operacionesInventarioDAOLocal.getListaInvVentasDetalleTO(invVentasTO.getVtaEmpresa(), invVentasTO.getVtaPeriodo(), invVentasTO.getVtaMotivo(), invVentasTO.getVtaNumero());
                                if (invListaDetalleTO != null) {
                                    listaInvVentasDetalleTO = new ArrayList();
                                    for (int i = 0; i < invListaDetalleTO.size(); i++) {
                                        InvVentasDetalleTO invVentasDetalleTO = new InvVentasDetalleTO();
                                        invVentasDetalleTO.setDetSecuencia(invListaDetalleTO.get(i).getSecuencial());
                                        invVentasDetalleTO.setDetOrden(i + 1);
                                        invVentasDetalleTO.setDetPendiente(invListaDetalleTO.get(i).getPendiente());
                                        invVentasDetalleTO.setDetCantidad(invListaDetalleTO.get(i).getCantidadProducto());
                                        invVentasDetalleTO.setDetPrecio(invListaDetalleTO.get(i).getPrecioProducto());
                                        invVentasDetalleTO.setDetPorcentajeDescuento(invListaDetalleTO.get(i).getPorcentajeDescuento());

//                                        invVentasDetalleTO.setDetValorPromedio(cero);// revisar
//                                        invVentasDetalleTO.setDetValorUltimaCompra(cero);// revisar
//                                        invVentasDetalleTO.setDetSaldo(cero);// revisar

                                        invVentasDetalleTO.setDetPorcentajeRecargo(invListaDetalleTO.get(i).getPorcentajeRecargo());
                                        invVentasDetalleTO.setBodEmpresa(invVentasTO.getVtaEmpresa());
                                        invVentasDetalleTO.setBodCodigo(invListaDetalleTO.get(i).getCodigoBodega());
                                        invVentasDetalleTO.setProEmpresa(invVentasTO.getVtaEmpresa());
                                        invVentasDetalleTO.setProCodigoPrincipal(invListaDetalleTO.get(i).getCodigoProducto());
                                        invVentasDetalleTO.setProNombre(invListaDetalleTO.get(i).getNombreProducto());


                                        //                                        invVentasDetalleTO.setProCreditoTributario(false);// revisa

                                        invVentasDetalleTO.setSecEmpresa(invVentasTO.getVtaEmpresa());
                                        invVentasDetalleTO.setSecCodigo(invListaDetalleTO.get(i).getCodigoCP());
                                        invVentasDetalleTO.setPisEmpresa(invVentasTO.getVtaEmpresa());
                                        invVentasDetalleTO.setPisSector(invListaDetalleTO.get(i).getCodigoCP());
                                        invVentasDetalleTO.setPisNumero(invListaDetalleTO.get(i).getCodigoCC());
                                        invVentasDetalleTO.setVtaEmpresa(invVentasTO.getVtaEmpresa());
                                        invVentasDetalleTO.setVtaPeriodo(invVentasTO.getVtaPeriodo());
                                        invVentasDetalleTO.setVtaMotivo(invVentasTO.getVtaMotivo());
                                        invVentasDetalleTO.setVtaNumero(invVentasTO.getVtaNumero());

                                        listaInvVentasDetalleTO.add(invVentasDetalleTO);
                                    }
                                } else {
                                    detalleError = "Hubo en error al recuperar el detalle de la VENTA.\nContacte con el administrador...";
                                }
                            }

                            if (detalleError.trim().isEmpty()) {
                                /**
                                 *
                                 */
                                boolean puedeContinuar = true;
                                if (invVentasTO.getVtaFormaPago().equals("POR PAGAR") && !desmayorizar && !invVentasTO.getVtaAnulado() && !invVentasTO.getVtaPendiente()) {
                                    if (validaciones.Validacion.numeroDias("yyyy-MM-dd", invVentasTO.getVtaFecha(), invVentasTO.getVtaFechaVencimiento()) <= invCliente.getCliDiasCredito()) {
                                        puedeContinuar = true;
                                    } else {
                                        puedeContinuar = false;
                                    }
                                }
                                if (puedeContinuar) {
                                    puedeContinuar = true;
                                    if (invVentasTO.getVtaFormaPago().equals("POR PAGAR") && !desmayorizar && !invVentasTO.getVtaAnulado() && !invVentasTO.getVtaPendiente()) {
                                        BigDecimal saldoTotalVentaCobros = cero;
                                        if (false)/*
                                         * (invVentasTO.getVtaEmpresa().trim().equals("AA"))
                                         */ {
                                            int diaSemana = validaciones.Validacion.getNumeroDia(invVentasTO.getVtaFecha(), "yyyy-MM-dd");
                                            String fechaDesde = validaciones.Validacion.fechaSumarRestarDias(validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd"), diaSemana, 2);
                                            String fechaHasta = validaciones.Validacion.fechaSumarRestarDias(validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd"), diaSemana, 8);
                                            saldoTotalVentaCobros = operacionesInventarioDAOLocal.getInvVentaTotal(invVentasTO.getVtaEmpresa(),
                                                    fechaDesde, fechaHasta, invCliente.getInvClientePK().getCliCodigo()).add(invVentasTO.getVtaTotal());
                                        } else {
                                            BigDecimal saldoTotalCobros = cero;
                                            for (int i = 0; i < carListaPagosCobrosTOs.size(); i++) {
                                                saldoTotalCobros = saldoTotalCobros.add(carListaPagosCobrosTOs.get(i).getCxccSaldo());
                                            }
                                            saldoTotalVentaCobros = saldoTotalCobros.add(invVentasTO.getVtaTotal());
                                        }
                                        if (invCliente.getCliCupoCredito() != null) {
                                            if (saldoTotalVentaCobros.compareTo(invCliente.getCliCupoCredito()) <= 0) {
                                                puedeContinuar = true;
                                            } else {
                                                puedeContinuar = false;
                                            }
                                        } else {
                                            puedeContinuar = true;
                                        }

                                    }
                                    if (puedeContinuar) {
                                        comprobar = false;
                                        List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                                        listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invVentasTO.getVtaEmpresa());

                                        for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                                            if (validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd").getTime() >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime() && validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd").getTime()
                                                    <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                                                comprobar = true;
                                                invVentasTO.setVtaPeriodo(sisListaPeriodoTO.getPerCodigo());
                                                periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                                            }
                                        }

                                        if (comprobar) {
                                            if (!periodoCerrado) {
                                                if (operacionesInventarioDAOLocal.comprobarInvVentasMotivo(invVentasTO.getVtaEmpresa(), invVentasTO.getVtaMotivo())) {
                                                    /**
                                                     *
                                                     */
                                                    inventario.entity.InvVentas invVentasCreadas = operacionesInventarioDAOLocal.buscarInvVentas(invVentasTO.getVtaEmpresa(), invVentasTO.getVtaPeriodo(),
                                                            invVentasTO.getVtaMotivo(), invVentasTO.getVtaNumero());
                                                    String estado = "";
                                                    if (invVentasTO.getVtaAnulado()) {
                                                        estado = "anuló";
                                                    } else {
                                                        estado = "modificó";
                                                    }
                                                    boolean validacionModificar = invVentasCreadas != null && !quitarAnulado;
                                                    boolean validacionRestaurar = invVentasCreadas != null && invVentasCreadas.getVtaAnulado() && quitarAnulado;
                                                    if (validacionModificar || validacionRestaurar) {
                                                        if (quitarAnulado) {
                                                            eliminarMotivoAnulacion = true;
                                                            inventario.entity.InvVentasMotivoAnulacion invVentasMotivoAnulacionTmp = operacionesInventarioDAOLocal.buscarVentaMotivo(invVentasTO.getVtaEmpresa(), invVentasTO.getVtaPeriodo(), invVentasTO.getVtaMotivo(), invVentasTO.getVtaNumero());
                                                            invVentasMotivoAnulacion = new inventario.entity.InvVentasMotivoAnulacion();
                                                            invVentasMotivoAnulacion.setAnuComentario(invVentasMotivoAnulacionTmp.getAnuComentario());
                                                            invVentasMotivoAnulacion.setInvVentas(invVentasMotivoAnulacionTmp.getInvVentas());
                                                            invVentasMotivoAnulacion.setInvVentasMotivoAnulacionPK(invVentasMotivoAnulacionTmp.getInvVentasMotivoAnulacionPK());

                                                            estado = "restauró";
                                                            ////CREANDO SUCESO
                                                            susClave = invVentasTO.getVtaPeriodo() + " "
                                                                    + invVentasTO.getVtaMotivo() + " " + invVentasTO.getVtaNumero();
                                                            susDetalle = "Se " + estado + " la venta en el periodo "
                                                                    + invVentasTO.getVtaPeriodo() + ", del motivo "
                                                                    + invVentasTO.getVtaMotivo() + ", de la numeración "
                                                                    + invVentasTO.getVtaNumero();
                                                            susSuceso = "UPDATE";
                                                            susTabla = "inventario.inv_ventas";
                                                            sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                                    susTabla,
                                                                    susClave,
                                                                    susSuceso,
                                                                    susDetalle,
                                                                    sisInfoTO);
                                                            invVentasTO.setUsrCodigo(invVentasCreadas.getUsrCodigo());
                                                            invVentasTO.setUsrFechaInserta(validaciones.Validacion.fecha(invVentasCreadas.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                                                        } else {

                                                            susDetalle = "";
                                                            if (estado.trim().equals("anuló")) {
                                                                susDetalle = "Venta número " + invVentasTO.getVtaNumero() + "se anuló por " + invVentasMotivoAnulacion.getAnuComentario();
                                                            } else {
                                                                susDetalle = "Se " + estado + " la ventas en el periodo "
                                                                        + invVentasTO.getVtaPeriodo() + ", del motivo "
                                                                        + invVentasTO.getVtaMotivo() + ", de la numeración "
                                                                        + invVentasTO.getVtaNumero();
                                                            }

                                                            ////CREANDO SUCESO
                                                            susClave = invVentasTO.getVtaPeriodo() + " "
                                                                    + invVentasTO.getVtaMotivo() + " " + invVentasTO.getVtaNumero();
                                                            susSuceso = "UPDATE";
                                                            susTabla = "inventario.inv_ventas";
                                                            sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                                    susTabla,
                                                                    susClave,
                                                                    susSuceso,
                                                                    susDetalle,
                                                                    sisInfoTO);
                                                            //                                                    invVentasTO.setVtaDocumentoFormaPago(invVentasTO.getVtaDocumentoFormaPago() == null ? invVentasCreadas.getVtaDocumentoFormaPago() : invComprasTO.getCompDocumentoFormaPago().trim().isEmpty() ? invComprasCreadas.getCompDocumentoFormaPago() : invComprasTO.getCompDocumentoFormaPago());
                                                            invVentasTO.setUsrCodigo(invVentasCreadas.getUsrCodigo());
                                                            invVentasTO.setUsrFechaInserta(validaciones.Validacion.fecha(invVentasCreadas.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                                                        }

                                                        ////// CREANDO NUMERACION DE VENTA
                                                        inventario.entity.InvVentasNumeracion invVentasNumeracion = new inventario.entity.InvVentasNumeracion(new inventario.entity.InvVentasNumeracionPK(invVentasTO.getVtaEmpresa(), invVentasTO.getVtaPeriodo(), invVentasTO.getVtaMotivo()));
                                                        ////// CREANDO VENTAS


                                                        inventario.entity.InvVentas invVentas = inventario.helper.ConversionesInventario.convertirInvVentasTO_InvVentas(invVentasTO);
                                                        invVentas.setInvCliente(operacionesInventarioDAOLocal.buscarInvCliente(invVentasTO.getCliEmpresa(), invVentasTO.getCliCodigo()));

                                                        ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                                        List<inventario.entity.InvVentasDetalle> listInvVentasDetalle = new ArrayList(0);
                                                        inventario.entity.InvVentasDetalle invVentasDetalle = null;
                                                        int estadoDetalle = 0;
                                                        for (inventario.TO.InvVentasDetalleTO invVentasDetalleTO : listaInvVentasDetalleTO) {
                                                            invVentasDetalle = new inventario.entity.InvVentasDetalle();
                                                            invVentasDetalleTO.setVtaPeriodo(invVentasTO.getVtaPeriodo());
                                                            invVentasDetalle = inventario.helper.ConversionesInventario.convertirInvVentasDetalleTO_InvVentasDetalle(invVentasDetalleTO);

                                                            ///// BUSCANDO EL PRODUCTO EN DETALLE
                                                            inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invVentasDetalleTO.getVtaEmpresa(),
                                                                    invVentasDetalleTO.getProCodigoPrincipal());
                                                            if (invProducto != null) {
                                                                invVentasDetalle.setInvProducto(invProducto);
                                                                invVentasDetalle.setProCreditoTributario(invProducto.getProCreditoTributario());
                                                                ////// BUSCANDO LA BODEGA EN EL DETALLE
                                                                inventario.entity.InvBodega invBodega = operacionesInventarioDAOLocal.buscarInvBodega(invVentasDetalleTO.getVtaEmpresa(), invVentasDetalleTO.getBodCodigo());

                                                                if (invBodega != null) {
                                                                    invVentasDetalle.setInvBodega(invBodega);
                                                                    System.out.println("invVentasDetalle.getInvBodega().getBodNombre()  " + invVentasDetalle.getInvBodega().getBodNombre());
                                                                    listInvVentasDetalle.add(invVentasDetalle);
                                                                } else {
                                                                    estadoDetalle = 2;
                                                                }
                                                            } else {
                                                                estadoDetalle = 1;
                                                            }

                                                            if (estadoDetalle == 1 || estadoDetalle == 2) {
                                                                break;
                                                            } else {
                                                                invProducto = null;
                                                            }
                                                        }

                                                        if (estadoDetalle == 0) {
                                                            /**
                                                             *
                                                             */
                                                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE A ELIMINAR
                                                            List<inventario.entity.InvVentasDetalle> listInvVentasDetalleEliminar = new ArrayList(0);
                                                            inventario.entity.InvVentasDetalle invVentasDetalleEliminar = null;

                                                            int estadoDetalleEliminar = 0;
                                                            if (listaInvVentasEliminarDetalleTO != null) {
                                                                for (inventario.TO.InvVentasDetalleTO invVentasDetalleTO : listaInvVentasEliminarDetalleTO) {
                                                                    invVentasDetalleEliminar = new inventario.entity.InvVentasDetalle();
                                                                    invVentasDetalleTO.setVtaPeriodo(invVentasTO.getVtaPeriodo());
                                                                    invVentasDetalleEliminar = inventario.helper.ConversionesInventario.convertirInvVentasDetalleTO_InvVentasDetalle(invVentasDetalleTO);
                                                                    invVentasDetalleEliminar.setProCreditoTributario(false);
                                                                    invVentasDetalleEliminar.setInvVentas(invVentas);

                                                                    ///// BUSCANDO EL PRODUCTO EN DETALLE
                                                                    inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invVentasDetalleTO.getVtaEmpresa(),
                                                                            invVentasDetalleTO.getProCodigoPrincipal());
                                                                    if (invProducto != null) {
                                                                        invVentasDetalleEliminar.setInvProducto(invProducto);
                                                                        ////// BUSCANDO LA BODEGA EN EL DETALLE
                                                                        inventario.entity.InvBodega invBodega = operacionesInventarioDAOLocal.buscarInvBodega(invVentasDetalleTO.getVtaEmpresa(),
                                                                                invVentasDetalleTO.getBodCodigo());

                                                                        if (invBodega != null) {
                                                                            invVentasDetalleEliminar.setInvBodega(invBodega);
                                                                            listInvVentasDetalleEliminar.add(invVentasDetalleEliminar);
                                                                        } else {
                                                                            estadoDetalleEliminar = 2;
                                                                        }
                                                                    } else {
                                                                        estadoDetalleEliminar = 1;
                                                                    }

                                                                    if (estadoDetalleEliminar == 1 || estadoDetalleEliminar == 2) {
                                                                        break;
                                                                    } else {
                                                                        invProducto = null;
                                                                    }
                                                                }
                                                            }
                                                            if (estadoDetalleEliminar == 0) {
                                                                /**
                                                                 *
                                                                 */
                                                                anexos.entity.AnxVenta anxVenta = null;
                                                                if (anxVentasTO != null) {
                                                                    anxVentasTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                                                                    anxVenta = anexos.helper.ConversionesAnexos.convertirAnxVentaTO_AnxVenta(anxVentasTO);
                                                                }
                                                                ////////////COMPROBAR SI NO EXISTE NUMERO DE FACTURA
                                                                String codigoFactura;
                                                                if (!sisEmpresaParametros.getParActividad().equals("COMISARIATO")) {
                                                                    codigoFactura = operacionesInventarioDAOLocal.getConteoNumeroFacturaVenta(invVentasTO.getVtaEmpresa(),
                                                                            invVentasTO.getVtaDocumentoTipo(),
                                                                            invVentasTO.getVtaDocumentoNumero());
                                                                } else {
                                                                    codigoFactura = "";
                                                                }

                                                                if ((codigoFactura.trim().isEmpty() || codigoFactura.trim().equals(invVentasCreadas.getInvVentasPK().getVtaEmpresa().trim().concat(invVentasCreadas.getInvVentasPK().getVtaPeriodo().trim().concat(invVentasCreadas.getInvVentasPK().
                                                                        getVtaMotivo().trim().concat(invVentasCreadas.getInvVentasPK().getVtaNumero().trim())))))
                                                                        || (invVentasTO.getVtaDocumentoNumero().equals("999-999-999999999")
                                                                        || invVentasTO.getVtaDocumentoTipo().equals("00"))) {
                                                                    boolean noExiste = false;
                                                                    ////////////COMPROBAR SI EL TIPO DE DOCUMENTO ES 00
                                                                    if (anxVentasTO != null) {
                                                                        ////////////COMPROBAR SI NO EXISTE NUMERO DE RETENCION
                                                                        String codigoRetencion = "";
                                                                        anxVentasTO.setVenRetencionNumero(anxVentasTO.getVenRetencionNumero() == null ? ""
                                                                                : anxVentasTO.getVenRetencionNumero());
                                                                        if (!anxVentasTO.getVenRetencionNumero().isEmpty()) {
                                                                            codigoRetencion = operacionesAnexoDAOLocal.getConteoNumeroRetencionVenta(anxVentasTO.getVenEmpresa(),
                                                                                    anxVentasTO.getVenRetencionNumero(), invCliente.getInvClientePK().getCliCodigo());
                                                                        } else {
                                                                            codigoRetencion = "";
                                                                        }
                                                                        if (codigoRetencion.trim().isEmpty() || codigoRetencion.trim().equals(invVentasCreadas.getInvVentasPK().getVtaEmpresa().trim().
                                                                                concat(invVentasCreadas.getInvVentasPK().getVtaPeriodo().trim().concat(invVentasCreadas.getInvVentasPK().
                                                                                getVtaMotivo().trim().concat(invVentasCreadas.getInvVentasPK().getVtaNumero().trim()))))) {
                                                                            noExiste = true;
                                                                        }
                                                                    } else {
                                                                        noExiste = true;
                                                                    }
                                                                    if (noExiste) {
                                                                        if (!invVentas.getVtaPendiente() || desmayorizar || invVentas.getVtaAnulado()) {

                                                                            if (invVentas.getVtaDocumentoTipo().equals("04")) {
                                                                                List<inventario.entity.InvVentasDetalle> listadoDetalleVentas = agrupraProductosBodegaVenta(listInvVentasDetalle);
                                                                                for (int i = 0; i < listadoDetalleVentas.size(); i++) {
                                                                                    if (!listadoDetalleVentas.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                                                        invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                                                                        invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invVentas.getInvVentasPK().getVtaEmpresa(), listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                                                listadoDetalleVentas.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                                                        ////BUSCO LA BODEGA
                                                                                        invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invVentas.getInvVentasPK().
                                                                                                getVtaEmpresa(), listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                                                        ////PONGO EL PRODUCTO
                                                                                        invProductoSaldos.setInvProducto(listadoDetalleVentas.get(i).getInvProducto());
                                                                                        inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                                                                invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                                                                invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                                                                        if (invProductoSaldosConsulta != null) {
                                                                                            ///Como si existe el dato se le suma la nueva cantidad con lo que se va a ingresar
                                                                                            if (desmayorizar || invVentas.getVtaAnulado()) {
                                                                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                                        subtract(listadoDetalleVentas.get(i).getDetCantidad()));
                                                                                            } else {
                                                                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                                        add(listadoDetalleVentas.get(i).getDetCantidad()));
                                                                                            }
                                                                                            if (invProductoSaldos.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                                                                invProductoSaldos.setStkFechaUltimaCompraFinal(invVentas.getVtaFecha());
                                                                                                invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());

                                                                                                invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                                                                invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                                                                invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());

                                                                                                listaInvProductoSaldos.add(invProductoSaldos);
                                                                                            } else {
                                                                                                retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                                mensajeClase.add(listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo() + "\t"
                                                                                                        + listadoDetalleVentas.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleVentas.get(i).getInvProducto().getProNombre());
                                                                                            }
                                                                                        } else {
                                                                                            retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                            mensajeClase.add(listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo() + "\t"
                                                                                                    + listadoDetalleVentas.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleVentas.get(i).getInvProducto().getProNombre());
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                List<inventario.entity.InvVentasDetalle> listadoDetalleVentas = agrupraProductosBodegaVenta(listInvVentasDetalle);
                                                                                for (int i = 0; i < listadoDetalleVentas.size(); i++) {
                                                                                    if (!listadoDetalleVentas.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                                                        invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                                                                        invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invVentas.getInvVentasPK().getVtaEmpresa(), listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                                                listadoDetalleVentas.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                                                        ////BUSCO LA BODEGA
                                                                                        invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invVentas.getInvVentasPK().
                                                                                                getVtaEmpresa(), listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                                                        ////PONGO EL PRODUCTO
                                                                                        invProductoSaldos.setInvProducto(listadoDetalleVentas.get(i).getInvProducto());
                                                                                        inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                                                                invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                                                                invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                                                                        if (invProductoSaldosConsulta != null) {
                                                                                            ///Como si existe el dato se le suma la nueva cantidad con lo que se va a ingresar
                                                                                            if (desmayorizar || invVentas.getVtaAnulado()) {
                                                                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                                        add(listadoDetalleVentas.get(i).getDetCantidad()));
                                                                                            } else {
                                                                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                                                        subtract(listadoDetalleVentas.get(i).getDetCantidad()));
                                                                                            }
                                                                                            if (invProductoSaldos.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                                                                invProductoSaldos.setStkFechaUltimaCompraFinal(invVentas.getVtaFecha());
                                                                                                invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());

                                                                                                invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                                                                invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                                                                invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());

                                                                                                listaInvProductoSaldos.add(invProductoSaldos);
                                                                                            } else {
                                                                                                retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                                mensajeClase.add(listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo() + "\t"
                                                                                                        + listadoDetalleVentas.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleVentas.get(i).getInvProducto().getProNombre());
                                                                                            }
                                                                                        } else {
                                                                                            retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                                            mensajeClase.add(listadoDetalleVentas.get(i).getInvBodega().getInvBodegaPK().getBodCodigo() + "\t"
                                                                                                    + listadoDetalleVentas.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleVentas.get(i).getInvProducto().getProNombre());
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        if (mensajeClase.isEmpty()) {
                                                                            contabilidad.entity.ConContable conContable = null;
                                                                            List<sistemaWeb.entity.SisSuceso> listaSisSuceso = new ArrayList();

                                                                            if (invVentas.getVtaAnulado()) {
                                                                                conContable = operacionesContabilidadDAOLocal.buscarContable(invVentas.getConEmpresa(), invVentas.getConPeriodo(), invVentas.getConTipo(), invVentas.getConNumero());
                                                                                if (conContable != null) {
                                                                                    conContable.setConAnulado(true);
                                                                                    susSuceso = "DELETE";
                                                                                    sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                                                            susTabla,
                                                                                            susClave,
                                                                                            susSuceso,
                                                                                            susDetalle,
                                                                                            sisInfoTO);
                                                                                    listaSisSuceso.add(sisSuceso);
                                                                                    ///////////////NUEVO SUCESO PARA CONTABLE
                                                                                    sistemaWeb.entity.SisSuceso sisSucesoContable = validaciones.Suceso.crearSisSuceso(
                                                                                            "contabilidad.con_contable",
                                                                                            conContable.getConContablePK().getConPeriodo() + " " + conContable.getConContablePK().getConTipo() + " " + conContable.getConContablePK().getConNumero(),
                                                                                            "DELETE",
                                                                                            "Se anuló el contable del periodo " + conContable.getConContablePK().getConPeriodo() + ", del tipo " + conContable.getConContablePK().getConTipo() + ", de la numeración " + conContable.getConContablePK().getConNumero(),
                                                                                            sisInfoTO);
                                                                                    listaSisSuceso.add(sisSucesoContable);
                                                                                    sisSuceso = null;
                                                                                }
                                                                            }

                                                                            if (quitarAnulado) {
                                                                                conContable = operacionesContabilidadDAOLocal.buscarContable(invVentas.getConEmpresa(), invVentas.getConPeriodo(), invVentas.getConTipo(), invVentas.getConNumero());
                                                                                if (conContable != null) {
                                                                                    conContable.setConAnulado(false);
                                                                                    susSuceso = "RESTORE";
                                                                                    sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                                                            susTabla,
                                                                                            susClave,
                                                                                            susSuceso,
                                                                                            susDetalle,
                                                                                            sisInfoTO);
                                                                                    listaSisSuceso.add(sisSuceso);
                                                                                    ///////////////NUEVO SUCESO PARA CONTABLE                                        
                                                                                    sistemaWeb.entity.SisSuceso sisSucesoContable = validaciones.Suceso.crearSisSuceso(
                                                                                            "contabilidad.con_contable",
                                                                                            conContable.getConContablePK().getConPeriodo() + " " + conContable.getConContablePK().getConTipo() + " " + conContable.getConContablePK().getConNumero(),
                                                                                            "RESTORE",
                                                                                            "Se restauró el contable del periodo " + conContable.getConContablePK().getConPeriodo() + ", del tipo " + conContable.getConContablePK().getConTipo() + ", de la numeración " + conContable.getConContablePK().getConNumero(),
                                                                                            sisInfoTO);
                                                                                    listaSisSuceso.add(sisSucesoContable);
                                                                                    sisSuceso = null;
                                                                                }
                                                                            }

                                                                            inventario.entity.InvVentasComplemento invVentasComplemento = null;
                                                                            inventario.entity.InvVentasComplemento invVentasComplementoAux = null;
                                                                            puedeContinuar = false;
                                                                            String complemento = "";
                                                                            if (!invVentas.getVtaAnulado()) {
                                                                                invVentasComplementoAux = operacionesInventarioDAOLocal.buscarVentasComplemento(invVentas.getInvVentasPK().getVtaEmpresa(),
                                                                                        invVentas.getInvVentasPK().getVtaPeriodo(), invVentas.getInvVentasPK().getVtaMotivo(),
                                                                                        invVentas.getInvVentasPK().getVtaNumero());

                                                                                if (invVentasComplementoAux != null && (!invVentas.getVtaDocumentoTipo().equals("04") && !invVentas.getVtaDocumentoTipo().equals("05"))) {
                                                                                    puedeContinuar = true;
                                                                                    complemento = "ELIMINAR";
                                                                                    invVentasComplemento = new inventario.entity.InvVentasComplemento();
                                                                                    invVentasComplemento.setComDocumentoNumero(invVentasComplementoAux.getComDocumentoNumero());
                                                                                    invVentasComplemento.setComDocumentoTipo(invVentasComplementoAux.getComDocumentoTipo());
                                                                                } else {
                                                                                    if (invVentasComplementoAux == null && (invVentas.getVtaDocumentoTipo().equals("04") || invVentas.getVtaDocumentoTipo().equals("05"))
                                                                                            && (!numeroDocumentoComplemento.trim().isEmpty() && !tipoDocumentoComplemento.trim().isEmpty())) {
                                                                                        complemento = "CREAR";
                                                                                        invVentasComplemento = new inventario.entity.InvVentasComplemento();
                                                                                        invVentasComplemento.setComDocumentoNumero(numeroDocumentoComplemento);
                                                                                        invVentasComplemento.setComDocumentoTipo(tipoDocumentoComplemento);
                                                                                        codigoFactura = operacionesInventarioDAOLocal.getConteoNotaCreditoVenta(invVentasTO.getVtaEmpresa(),
                                                                                                invVentasTO.getCliCodigo(), tipoDocumentoComplemento, numeroDocumentoComplemento);
                                                                                        if (!codigoFactura.trim().isEmpty() || invVentasTO.getVtaDocumentoNumero().equals("999-999-999999999")) {
                                                                                            puedeContinuar = true;
                                                                                        }
                                                                                    } else {
                                                                                        if (invVentasComplementoAux != null && (invVentas.getVtaDocumentoTipo().equals("04") || invVentas.getVtaDocumentoTipo().equals("05"))
                                                                                                && (!numeroDocumentoComplemento.trim().isEmpty() && !tipoDocumentoComplemento.trim().isEmpty())) {
                                                                                            complemento = "MODIFICAR";
                                                                                            invVentasComplemento = new inventario.entity.InvVentasComplemento();
                                                                                            invVentasComplemento.setComDocumentoNumero(numeroDocumentoComplemento);
                                                                                            invVentasComplemento.setComDocumentoTipo(tipoDocumentoComplemento);
                                                                                            codigoFactura = operacionesInventarioDAOLocal.getConteoNotaCreditoVenta(invVentasTO.getVtaEmpresa(),
                                                                                                    invVentasTO.getCliCodigo(), tipoDocumentoComplemento, numeroDocumentoComplemento);
                                                                                            if (!codigoFactura.trim().isEmpty() || invVentasTO.getVtaDocumentoNumero().equals("999-999-999999999")) {
                                                                                                puedeContinuar = true;
                                                                                            }
                                                                                        } else {
                                                                                            puedeContinuar = true;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                puedeContinuar = true;
                                                                            }


                                                                            if (puedeContinuar) {
                                                                                invVentas.setVtaBaseExenta(cero);
                                                                                invVentas.setVtaBaseNoObjeto(cero);
                                                                                invVentas.setVtaSubtotalBaseExenta(cero);
                                                                                invVentas.setVtaSubtotalBaseNoObjeto(cero);
                                                                                invVentas.setVtaDescuentoBaseExenta(cero);
                                                                                invVentas.setVtaDescuentoBaseNoObjeto(cero);

                                                                                if (invVentas.getVtaAnulado()) {
                                                                                    invVentasMotivoAnulacion.setInvVentas(invVentas);
                                                                                }

                                                                                if (invVentas.getVtaDocumentoTipo().equals("00")) {
                                                                                    invVentas.setVtaDocumentoNumero(null);
                                                                                }

                                                                                comprobar = operacionesInventarioDAOTransaccionLocal.modificarInvVentas(
                                                                                        invVentas,
                                                                                        listInvVentasDetalle,
                                                                                        listInvVentasDetalleEliminar,
                                                                                        sisSuceso,
                                                                                        listaSisSuceso,
                                                                                        listaInvProductoSaldos,
                                                                                        conContable,
                                                                                        anxVenta,
                                                                                        invVentasComplemento,
                                                                                        complemento,
                                                                                        invVentasMotivoAnulacion,
                                                                                        eliminarMotivoAnulacion);
                                                                                if (comprobar) {
                                                                                    sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(invVentasTO.getVtaEmpresa(), invVentas.getInvVentasPK().getVtaPeriodo());

                                                                                    retorno = "T<html>Se  " + (invVentasTO.getVtaAnulado() ? "anuló" : "modificó") + "  la Venta con la siguiente información:<br><br>"
                                                                                            + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                                                            + "</font>.<br> Motivo: <font size = 5>" + invVentas.getInvVentasPK().
                                                                                            getVtaMotivo()
                                                                                            + "</font>.<br> Número: <font size = 5>" + invVentas.getInvVentasPK().getVtaNumero() + "</font>.</html>"
                                                                                            + invVentas.getInvVentasPK().getVtaNumero() + "," + sisPeriodo.getSisPeriodoPK().getPerCodigo();
                                                                                    mensajeTO.setFechaCreacion(invVentas.getUsrFechaInserta().toString());

                                                                                    if (!carListaPagosCobrosVencidosTOs.isEmpty()) {
                                                                                        mensajeClase.add("<html>Cliente tiene deudas vencidas! Avise al cliente que\nse acerque a cancelar lo más pronto...</html>");
                                                                                        mensajeClase.add("Número de Sistema\tValor\tFecha de Vencimiento");
                                                                                        for (int i = 0; i < carListaPagosCobrosVencidosTOs.size(); i++) {
                                                                                            mensajeClase.add(carListaPagosCobrosVencidosTOs.get(i).getCxccPeriodo() + " | "
                                                                                                    + carListaPagosCobrosVencidosTOs.get(i).getCxccMotivo() + " | " + carListaPagosCobrosVencidosTOs.get(i).getCxccNumero() + "\t"
                                                                                                    + carListaPagosCobrosVencidosTOs.get(i).getCxccSaldo() + "\t" + carListaPagosCobrosVencidosTOs.get(i).getCxccFechaVencimiento());
                                                                                        }
                                                                                        mensajeTO.setListaErrores(mensajeClase);
                                                                                    }

                                                                                } else {
                                                                                    retorno = "FHubo un error al modificar la Venta...\nIntente de nuevo o contacte con el administrador";
                                                                                }

                                                                            } else {
                                                                                retorno = "F<html>El Número de Documento del Complemento que ingresó no existe...\nIntente de nuevo o contacte con el administrador</html>";
                                                                            }
                                                                        } else {
                                                                            mensajeTO.setMensaje(retorno);
                                                                            mensajeTO.setListaErrores(mensajeClase);
                                                                        }
                                                                    } else {
                                                                        retorno = "F<html>El Número de Retención que ingresó ya existe...\nIntente de nuevo o contacte con el administrador</html>";
                                                                    }
                                                                } else {
                                                                    retorno = "F<html>No se puede realizar la acción solicitada sobre la venta.</html>";
                                                                }
                                                            } else {
                                                                if (estadoDetalleEliminar == 1) {
                                                                    retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                                                } else {
                                                                    retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                                                }
                                                            }
                                                        } else {
                                                            if (estadoDetalle == 1) {
                                                                retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                                            } else {
                                                                retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                                            }
                                                        }
                                                    } else {
                                                        if (validacionModificar) {
                                                            retorno = "F<html>La venta que quiere modificar ya no se encuentra disponible.</html>";
                                                        } else {
                                                            retorno = "F<html>La venta que desea restaurar NO existe o NO está anulada</html>";
                                                        }
                                                    }
                                                } else {
                                                    retorno = "F<html>No se encuentra el motivo...</html>";
                                                }
                                            } else {
                                                retorno = "F<html>No se puede MAYORIZAR, DESMAYORIZAR o ANULAR debido a que el período se encuentra cerrado...</html>";
                                            }
                                        } else {
                                            retorno = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
                                        }
                                    } else {
                                        retorno = "F<html>Se superó el limite del monto del crédito...</html>";
                                    }
                                } else {
                                    retorno = "F<html>Los días de crédito del Cliente es superior al que se le permite...</html>";
                                }
                            } else {
                                retorno = "F<html>" + detalleError + "</html>";
                            }
                        } else {
                            retorno = "F<html>El Cliente que escogió ya no está disponible...\nIntente de nuevo, escoja otro Cliente o contacte con el administrador</html>";
                        }
                    } else {
                        retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
                    }
                } else {
                    retorno = "F<html>Cliente tiene deudas vencidas! Avise al cliente que\nse acerque a cancelar lo más pronto...</html>";
                    mensajeTO.setMensaje(retorno);
                    mensajeClase.add("Número de Sistema\tValor\tFecha de Vencimiento");
                    for (int i = 0; i < carListaPagosCobrosVencidosTOs.size(); i++) {
                        mensajeClase.add(carListaPagosCobrosVencidosTOs.get(i).getCxccPeriodo() + " | "
                                + carListaPagosCobrosVencidosTOs.get(i).getCxccMotivo() + " | " + carListaPagosCobrosVencidosTOs.get(i).getCxccNumero() + "\t"
                                + carListaPagosCobrosVencidosTOs.get(i).getCxccSaldo() + "\t" + carListaPagosCobrosVencidosTOs.get(i).getCxccFechaVencimiento());
                    }
                    mensajeTO.setListaErrores(mensajeClase);
                }
            } else {
                retorno = "F<html>El NÚMERO DE DOCUMENTO que ingresó se encuentra ANULADO</html>";
            }
        } catch (Exception e) {
            retorno = "F<html>Error al guardar datos...</html>";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvVentasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
//            return retorno;
        }
    }

    // -
    public inventario.TO.MensajeTO modificarInvProformasTO(
            inventario.TO.InvProformasTO invProformasTO,
            List<inventario.TO.InvProformasDetalleTO> listaInvProformasDetalleTO,
            List<inventario.TO.InvProformasDetalleTO> listaInvProformasEliminarDetalleTO,
            boolean quitarAnulado,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        boolean bandAux = false;
        bandAux = listaInvProformasDetalleTO == null ? true : false;
        String retorno = "";
        boolean periodoCerrado = false;
        try {
            if (!validaciones.Validacion.isFechaSuperior(invProformasTO.getProfFecha(), "yyyy-MM-dd")) {
                ///// BUSCANDO CLIENTE
                inventario.entity.InvCliente invCliente = operacionesInventarioDAOLocal.buscarInvCliente(invProformasTO.getProfEmpresa(), invProformasTO.getCliCodigo());
                if (invCliente != null) {
                    String detalleError = "";
                    if (quitarAnulado && listaInvProformasDetalleTO == null) {
                        List<inventario.TO.InvListaDetalleProformasTO> invListaDetalleTO = operacionesInventarioDAOLocal.getListaInvProformasDetalleTO(invProformasTO.getProfEmpresa(), invProformasTO.getProfPeriodo(), invProformasTO.getProfMotivo(), invProformasTO.getProfNumero());
                        if (invListaDetalleTO != null) {
                            listaInvProformasDetalleTO = new ArrayList();
                            for (int i = 0; i < invListaDetalleTO.size(); i++) {
                                inventario.TO.InvProformasDetalleTO invProformasDetalleTO = new inventario.TO.InvProformasDetalleTO();
                                invProformasDetalleTO.setDetSecuencia(invListaDetalleTO.get(i).getSecuencial());
                                invProformasDetalleTO.setDetOrden(i + 1);
                                invProformasDetalleTO.setDetCantidad(invListaDetalleTO.get(i).getCantidadProducto());
                                invProformasDetalleTO.setDetPrecio(invListaDetalleTO.get(i).getPrecioProducto());
                                invProformasDetalleTO.setDetPorcentajeDescuento(invListaDetalleTO.get(i).getPorcentajeDescuento());
                                invProformasDetalleTO.setProEmpresa(invProformasTO.getProfEmpresa());
                                invProformasDetalleTO.setProCodigoPrincipal(invListaDetalleTO.get(i).getCodigoProducto());
                                invProformasDetalleTO.setProNombre(invListaDetalleTO.get(i).getNombreProducto());
                                invProformasDetalleTO.setProfEmpresa(invProformasTO.getProfEmpresa());
                                invProformasDetalleTO.setProfPeriodo(invProformasTO.getProfPeriodo());
                                invProformasDetalleTO.setProfMotivo(invProformasTO.getProfMotivo());
                                invProformasDetalleTO.setProfNumero(invProformasTO.getProfNumero());

                                listaInvProformasDetalleTO.add(invProformasDetalleTO);

                            }
                        } else {
                            detalleError = "Hubo en error al recuperar el detalle de la PROFORMA.\nContacte con el administrador...";
                        }
                    }
                    if (detalleError.trim().isEmpty()) {
                        comprobar = false;
                        List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                        listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invProformasTO.getProfEmpresa());

                        for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                            if (validaciones.Validacion.fecha(invProformasTO.getProfFecha(), "yyyy-MM-dd").getTime() >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                                    && validaciones.Validacion.fecha(invProformasTO.getProfFecha(), "yyyy-MM-dd").getTime()
                                    <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                                comprobar = true;
                                invProformasTO.setProfPeriodo(sisListaPeriodoTO.getPerCodigo());
                                periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                            }
                        }

                        if (comprobar) {
                            if (!periodoCerrado) {
                                if (operacionesInventarioDAOLocal.comprobarInvProformasMotivo(invProformasTO.getProfEmpresa(), invProformasTO.getProfMotivo())) {
                                    inventario.entity.InvProformas invProformasCreadas = operacionesInventarioDAOLocal.buscarInvProformas(invProformasTO.getProfEmpresa(), invProformasTO.getProfPeriodo(), invProformasTO.getProfMotivo(), invProformasTO.getProfNumero());
                                    String estado = "";
                                    if (invProformasTO.getProfAnulado()) {
                                        estado = "anuló";
                                    } else {
                                        estado = "modificó";
                                    }
                                    if (invProformasCreadas != null) {
                                        if (quitarAnulado) {
                                            estado = "restauró";
                                            ////CREANDO SUCESO
                                            susClave = invProformasTO.getProfPeriodo() + " " + invProformasTO.getProfMotivo() + " " + invProformasTO.getProfNumero();
                                            susDetalle = "Se " + estado + " la proformas en el periodo " + invProformasTO.getProfPeriodo() + ", del motivo " + invProformasTO.getProfMotivo() + ", de la numeración " + invProformasTO.getProfNumero();
                                            susSuceso = "UPDATE";
                                            susTabla = "inventario.inv_proformas";
                                            //                                  invProformasTO.setVtaDocumentoFormaPago(invProformasTO.getVtaDocumentoFormaPago() == null ? invProformasCreadas.getVtaDocumentoFormaPago() : invComprasTO.getCompDocumentoFormaPago().trim().isEmpty() ? invComprasCreadas.getCompDocumentoFormaPago() : invComprasTO.getCompDocumentoFormaPago());
                                            invProformasTO.setUsrCodigo(invProformasCreadas.getUsrCodigo());
                                            invProformasTO.setUsrFechaInserta(validaciones.Validacion.fecha(invProformasCreadas.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                                        } else {
                                            susDetalle = "";
                                            if (estado.trim().equals("anuló")) {
                                                susDetalle = "Proforma número " + invProformasTO.getProfNumero() + "se anuló";
                                            } else {
                                                susDetalle = "Se " + estado + " la proforma en el periodo " + invProformasTO.getProfPeriodo() + ", del motivo " + invProformasTO.getProfMotivo() + ", de la numeración " + invProformasTO.getProfNumero();
                                            }
                                            ////CREANDO SUCESO
                                            susClave = invProformasTO.getProfPeriodo() + " " + invProformasTO.getProfMotivo() + " " + invProformasTO.getProfNumero();
                                            susSuceso = "UPDATE";
                                            susTabla = "inventario.inv_proformas";
                                            //                                  invProformasTO.setVtaDocumentoFormaPago(invProformasTO.getVtaDocumentoFormaPago() == null ? invProformasCreadas.getVtaDocumentoFormaPago() : invComprasTO.getCompDocumentoFormaPago().trim().isEmpty() ? invComprasCreadas.getCompDocumentoFormaPago() : invComprasTO.getCompDocumentoFormaPago());
                                            invProformasTO.setUsrCodigo(invProformasCreadas.getUsrCodigo());
                                            invProformasTO.setUsrFechaInserta(validaciones.Validacion.fecha(invProformasCreadas.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                                        }
                                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                susTabla,
                                                susClave,
                                                susSuceso,
                                                susDetalle,
                                                sisInfoTO);
                                        ////// CREANDO NUMERACION DE PROFORMA
                                        inventario.entity.InvProformasNumeracion invProformasNumeracion = new inventario.entity.InvProformasNumeracion(new inventario.entity.InvProformasNumeracionPK(invProformasTO.getProfEmpresa(), invProformasTO.getProfPeriodo(), invProformasTO.getProfMotivo()));

                                        inventario.entity.InvProformas invProformas = inventario.helper.ConversionesInventario.convertirInvProformasTO_InvProformas(invProformasTO);
                                        invProformas.setInvCliente(operacionesInventarioDAOLocal.buscarInvCliente(invProformasTO.getCliEmpresa(), invProformasTO.getCliCodigo()));
                                        ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                        List<inventario.entity.InvProformasDetalle> listInvProformasDetalle = new ArrayList(0);
                                        inventario.entity.InvProformasDetalle invProformasDetalle = null;
                                        int estadoDetalle = 0;
                                        if (listaInvProformasDetalleTO != null) {
                                            for (inventario.TO.InvProformasDetalleTO invProformasDetalleTO : listaInvProformasDetalleTO) {
                                                invProformasDetalle = new inventario.entity.InvProformasDetalle();
                                                invProformasDetalleTO.setProfPeriodo(invProformasTO.getProfPeriodo());

                                                invProformasDetalle = inventario.helper.ConversionesInventario.convertirInvProformasDetalleTO_InvProformasDetalle(invProformasDetalleTO);

                                                ///// BUSCANDO EL PRODUCTO EN DETALLE
                                                inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invProformasDetalleTO.getProfEmpresa(), invProformasDetalleTO.getProCodigoPrincipal());

                                                if (invProducto != null) {
                                                    invProformasDetalle.setInvProducto(invProducto);
                                                    if (!invProducto.getProInactivo()) {
                                                        listInvProformasDetalle.add(invProformasDetalle);
                                                    } else {
                                                        estadoDetalle = 2;
                                                    }
                                                } else {
                                                    estadoDetalle = 1;
                                                }
                                                if (estadoDetalle == 1 || estadoDetalle == 2) {
                                                    break;
                                                } else {
                                                    invProducto = null;
                                                }
                                            }
                                        }
                                        if (estadoDetalle == 0) {
                                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE A ELIMINAR
                                            List<inventario.entity.InvProformasDetalle> listInvProformasDetalleEliminar = new ArrayList(0);
                                            inventario.entity.InvProformasDetalle invProformasDetalleEliminar = null;
                                            int estadoDetalleEliminar = 0;
                                            if (listaInvProformasEliminarDetalleTO != null) {
                                                for (inventario.TO.InvProformasDetalleTO invProformasDetalleTO : listaInvProformasEliminarDetalleTO) {
                                                    invProformasDetalleEliminar = new inventario.entity.InvProformasDetalle();
                                                    invProformasDetalleTO.setProfPeriodo(invProformasTO.getProfPeriodo());
                                                    invProformasDetalleEliminar = inventario.helper.ConversionesInventario.convertirInvProformasDetalleTO_InvProformasDetalle(invProformasDetalleTO);
                                                    ///// BUSCANDO EL PRODUCTO EN DETALLE
                                                    inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invProformasDetalleTO.getProfEmpresa(),
                                                            invProformasDetalleTO.getProCodigoPrincipal());
                                                    if (invProducto != null) {
                                                        invProformasDetalleEliminar.setInvProducto(invProducto);
                                                        if (!invProducto.getProInactivo()) {
                                                            listInvProformasDetalleEliminar.add(invProformasDetalleEliminar);
                                                        } else {
                                                            estadoDetalleEliminar = 2;
                                                        }
                                                    } else {
                                                        estadoDetalleEliminar = 1;
                                                    }
                                                    if (estadoDetalleEliminar == 1 || estadoDetalleEliminar == 2) {
                                                        break;
                                                    } else {
                                                        invProducto = null;
                                                    }
                                                }
                                            }
                                            if (estadoDetalleEliminar == 0) {
                                                if (invProformas.getProfAnulado()) {
                                                    comprobar = operacionesInventarioDAOTransaccionLocal.modificarInvProformas(invProformas, listInvProformasDetalle, listInvProformasDetalleEliminar, sisSuceso);
                                                }
                                                if (comprobar) {

                                                    sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(invProformasTO.getProfEmpresa(), invProformas.getInvProformasPK().getProfPeriodo());
                                                    inventario.entity.InvProformasMotivo invProformaMotivo = operacionesInventarioDAOLocal.getInvProformasMotivo(invProformasTO.getProfEmpresa(), invProformas.getInvProformasPK().getProfMotivo());
                                                    retorno = "T<html>Se  " + (invProformasTO.getProfAnulado() ? "anuló" : "modificó") + "  la Proforma con la siguiente información:<br><br>"
                                                            + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                            + "</font>.<br> Motivo: <font size = 5>" + invProformaMotivo.getPmDetalle()
                                                            + "</font>.<br> Número: <font size = 5>" + invProformas.getInvProformasPK().getProfNumero()
                                                            + "</font>.</html>" + invProformas.getInvProformasPK().getProfNumero() + "," + sisPeriodo.getSisPeriodoPK().getPerCodigo();
                                                    mensajeTO.setFechaCreacion(invProformas.getUsrFechaInserta().toString());
                                                } else {
                                                    retorno = "FHubo un error al modificar la Proforma...\nIntente de nuevo o contacte con el administrador";
                                                }
                                                if (invProformas.getProfPendiente()) {
                                                    if (!bandAux) {
                                                        operacionesInventarioDAOTransaccionLocal.modificarInvProformas(invProformas, listInvProformasDetalle, listInvProformasDetalleEliminar, sisSuceso);
                                                    } else {
                                                        operacionesInventarioDAOTransaccionLocal.modificarInvProformas(invProformas, new ArrayList(), new ArrayList(), sisSuceso);
                                                    }
                                                } else if (!invProformas.getProfAnulado()) {
                                                    operacionesInventarioDAOTransaccionLocal.modificarInvProformas(invProformas, listInvProformasDetalle, listInvProformasDetalleEliminar, sisSuceso);
                                                }
                                            } else {
                                                if (estadoDetalleEliminar == 1) {
                                                    retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                                } else {
                                                    retorno = "F<html>Uno de los Productos no esta disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                                }
                                            }
                                        } else {
                                            if (estadoDetalle == 1) {
                                                retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                            } else {
                                                retorno = "F<html>Uno de los Productos no esta disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                            }
                                        }
                                    } else {
                                        retorno = "F<html>La Proforma que quiere modificar ya no se encuentra disponible</html>";
                                    }
                                } else {
                                    retorno = "F<html>No se encuentra el motivo...</html>";
                                }
                            } else {
                                retorno = "F<html>No se puede modificar debido a que el período se encuentra cerrado...</html>";
                            }
                        } else {
                            retorno = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
                        }
                    } else {
                        retorno = "F<html>" + detalleError + "</html>";
                    }
                } else {
                    retorno = "F<html>El Cliente que escogió ya no está disponible...\nIntente de nuevo, escoja otro Cliente o contacte con el administrador</html>";
                }
            } else {
                retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
            }
        } catch (Exception e) {
            retorno = "F<html>Error al guardar datos...</html>";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvProformasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
//            return retorno;
        }
    }

    private List<contabilidad.TO.ConDetalleTO> agruparProductoSectorParaContableCompras(
            String empresa,
            String numeroDocumento,
            List<inventario.TO.InvListaDetalleComprasTO> listaDetalle,
            contabilidad.TO.ConContableTO conContableTO,
            inventario.entity.InvCompras invCompras,
            anexos.TO.AnxCompraTO anxCompraTO,
            List<anexos.TO.AnxCompraDetalleTO> anxCompraDetalleTOs) throws Exception {

        List<inventario.TO.InvListaDetalleComprasTO> listaDetalleFinal = new ArrayList();
        listaDetalleFinal.add(listaDetalle.get(0));
        int contador = 0;
        boolean encontro = false;
        for (int i = 1; i < listaDetalle.size(); i++) {
            contador = 0;
            for (inventario.TO.InvListaDetalleComprasTO invComprasDetalleTOAux : listaDetalleFinal) {
                if (listaDetalle.get(i).getCodigoProducto().equals(invComprasDetalleTOAux.getCodigoProducto())
                        && listaDetalle.get(i).getCodigoCP().equals(invComprasDetalleTOAux.getCodigoCP())) {
                    encontro = true;
                    break;
                } else {
                    encontro = false;
                    contador++;
                }
            }
            if (encontro) {
                listaDetalleFinal.get(contador).setCantidadProducto(listaDetalleFinal.get(contador).getCantidadProducto().add(listaDetalle.get(i).getCantidadProducto()));
                listaDetalleFinal.get(contador).setDetalleSubtotal(listaDetalleFinal.get(contador).getDetalleSubtotal().add(listaDetalle.get(i).getDetalleSubtotal()));
            } else {
                listaDetalleFinal.add(listaDetalle.get(i));
            }
        }
        contador = 1;

        List<contabilidad.TO.ConDetalleTO> listaDetalleTO = new ArrayList();

        java.math.BigDecimal acumulador = new java.math.BigDecimal("0.00");
        java.math.BigDecimal acumuladorAnterior = new java.math.BigDecimal("0.00");

        /////ESTO ES PARA HACER EL PRIMER BLOQUE
        for (inventario.TO.InvListaDetalleComprasTO invComprasDetalleTO : listaDetalleFinal) {
            contabilidad.TO.ConDetalleTO conDetalleTO = new contabilidad.TO.ConDetalleTO();
            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
            //        conDetalleTO.setConNumero(conContableTO.getConNumero());
            conDetalleTO.setDetSecuencia(0);
            inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(empresa, invComprasDetalleTO.getCodigoProducto());
            conDetalleTO.setConCtaCodigo(invProducto.getProCuentaInventario());
//            conDetalleTO.setConCtaCodigo(operacionesInventarioDAOLocal.buscarInvProducto(empresa, invComprasDetalleTO.getCodigoProducto()).
//                    getProCuentaGasto());
            conDetalleTO.setSecCodigo(invComprasDetalleTO.getCodigoCP());
            conDetalleTO.setPisNumero(null);
            conDetalleTO.setDetDocumento(numeroDocumento);
            conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
            if (invCompras.getCompDocumentoTipo().equals("04")) {
                conDetalleTO.setDetDebitoCredito('C');
            } else {
                conDetalleTO.setDetDebitoCredito('D');
            }
            if (!invProducto.getProCreditoTributario() && invProducto.getProIva().equals("GRAVA")) {
                java.math.BigDecimal iva = new java.math.BigDecimal("0.00");
                iva = invComprasDetalleTO.getDetalleSubtotal().multiply(invCompras.getCompIvaVigente()).
                        divide(new java.math.BigDecimal("100.00"), java.math.RoundingMode.HALF_UP);
//                iva = validaciones.Validacion.redondeoDecimalBigDecimal(invComprasDetalleTO.
//                        getTotalProducto().multiply(invCompras.getCompIvaVigente()).
//                        divide(new java.math.BigDecimal("100.00"), java.math.RoundingMode.HALF_UP));
                acumulador = acumulador.add(iva);
                conDetalleTO.setDetValor(invComprasDetalleTO.getDetalleSubtotal().
                        add(validaciones.Validacion.redondeoDecimalBigDecimal(acumulador).
                        subtract(validaciones.Validacion.redondeoDecimalBigDecimal(acumuladorAnterior))));
                acumuladorAnterior = acumulador;
            } else {
                conDetalleTO.setDetValor(invComprasDetalleTO.getDetalleSubtotal());
            }

            //////////////////////PENDIENTE DE CORRECCION
//            
//            if (!invProducto.getProCreditoTributario() && invProducto.getProIva()){
//                java.math.BigDecimal iva = new java.math.BigDecimal("0.00");
//                java.math.BigDecimal multipĺicar = new java.math.BigDecimal("0.00");
//                java.math.BigDecimal dividir = new java.math.BigDecimal("0.00");
//                multipĺicar = invComprasDetalleTO.getTotalProducto().multiply(invCompras.getCompIvaVigente());
//                //*System.out.println(invComprasDetalleTO.getTotalProducto() + " multiplicado por " + invCompras.getCompIvaVigente() + " da: " + multipĺicar);
//                dividir = multipĺicar.divide(new java.math.BigDecimal("100.00"), java.math.RoundingMode.HALF_UP);
//                //*System.out.println(multipĺicar + " dividido para 100 da: " + dividir);
//                iva = dividir;
////                iva = invComprasDetalleTO.
////                        getTotalProducto().multiply(invCompras.getCompIvaVigente()).
////                        divide(new java.math.BigDecimal("100.00"), java.math.RoundingMode.HALF_UP);
//                
////                iva = validaciones.Validacion.redondeoDecimalBigDecimal(invComprasDetalleTO.
////                        getTotalProducto().multiply(invCompras.getCompIvaVigente()).
////                        divide(new java.math.BigDecimal("100.00"), java.math.RoundingMode.HALF_UP));
//
//                //*System.out.println("iva: " + iva.toPlainString());
//                
//                acumulador = acumulador.add(iva);
//                
//                //*System.out.println("acumulador: " + acumulador.toPlainString());
//
//                ////////PARA SOLUCIONAR PROBLEMA DE LA COMPRA 275 DE RODLAROK-SEPTIEMBRE-MOTIVO 101
//                //*System.out.println(invComprasDetalleTO.getTotalProducto().toPlainString() + " mas " + 
//                        acumulador.toPlainString() + " menos " + acumuladorAnterior.toPlainString() + " = " + 
//                        invComprasDetalleTO.getTotalProducto().
//                        add(acumulador).
//                        subtract(acumuladorAnterior) + "; y redondeado da: " + validaciones.Validacion.redondeoDecimalBigDecimal(invComprasDetalleTO.getTotalProducto().
//                        add(acumulador).
//                        subtract(acumuladorAnterior)));
//                conDetalleTO.setDetValor(validaciones.Validacion.redondeoDecimalBigDecimal(invComprasDetalleTO.getTotalProducto().
//                        add(acumulador).
//                        subtract(acumuladorAnterior)));
//                
////                conDetalleTO.setDetValor(invComprasDetalleTO.getTotalProducto().
////                        add(validaciones.Validacion.redondeoDecimalBigDecimal(acumulador).
////                        subtract(validaciones.Validacion.redondeoDecimalBigDecimal(acumuladorAnterior))));
//                
//                //*System.out.println("dentro del if: " + conDetalleTO.getDetValor());
//                
//                acumuladorAnterior = acumulador;
//                //*System.out.println("acumuladorAnterior: " + acumuladorAnterior.toPlainString());
//            } else {
//                conDetalleTO.setDetValor(invComprasDetalleTO.getTotalProducto());
//                //*System.out.println("fuera del if: " + conDetalleTO.getDetValor());
//            }

            conDetalleTO.setDetGenerado(true);
            conDetalleTO.setDetReferencia("COM");
            conDetalleTO.setDetOrden(contador);
            contador++;
            if (conDetalleTO.getDetValor().compareTo(cero) > 0) {
                listaDetalleTO.add(conDetalleTO);
            }
//            listaDetalleTO.add(conDetalleTO);
        }

        contabilidad.TO.ConDetalleTO conDetalleTO = new contabilidad.TO.ConDetalleTO();
        conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
        conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
        conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
        conDetalleTO.setDetSecuencia(0);
        conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaIvaPagado());
        conDetalleTO.setSecCodigo(invCompras.getSecCodigo());
        conDetalleTO.setPisNumero(null);
        conDetalleTO.setDetDocumento(numeroDocumento);
        conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
        if (invCompras.getCompDocumentoTipo().equals("04")) {
            conDetalleTO.setDetDebitoCredito('C');
        } else {
            conDetalleTO.setDetDebitoCredito('D');
        }
        conDetalleTO.setDetValor(invCompras.getCompMontoIva().subtract(validaciones.Validacion.redondeoDecimalBigDecimal(acumulador)));
        conDetalleTO.setDetGenerado(true);
        conDetalleTO.setDetReferencia("IVA-PAG");
        conDetalleTO.setDetOrden(contador);
        contador++;
        if (conDetalleTO.getDetValor().compareTo(cero) > 0) {
            listaDetalleTO.add(conDetalleTO);
        }
////////OTROS IMPUESTOS(IMPUESTO VERDDE, ICE, IRBP)////////////////////////
        conDetalleTO = new contabilidad.TO.ConDetalleTO();
        conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
        conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
        conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
        conDetalleTO.setDetSecuencia(0);
        conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaOtrosImpuestos());
        conDetalleTO.setSecCodigo(invCompras.getSecCodigo());
        conDetalleTO.setPisNumero(null);
        conDetalleTO.setDetDocumento(numeroDocumento);
        conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
        if (invCompras.getCompDocumentoTipo().equals("04")) {
            conDetalleTO.setDetDebitoCredito('C');
        } else {
            conDetalleTO.setDetDebitoCredito('D');
        }
        conDetalleTO.setDetValor(invCompras.getCompOtrosImpuestos());
        conDetalleTO.setDetGenerado(true);
        conDetalleTO.setDetReferencia("OTR-IMP");
        conDetalleTO.setDetOrden(contador);
        contador++;
        if (conDetalleTO.getDetValor().compareTo(cero) > 0) {
            listaDetalleTO.add(conDetalleTO);
        }
        if (anxCompraTO != null) {
            if (anxCompraTO.getCompValorbienes().compareTo(cero) > 0) {
                conDetalleTO = new contabilidad.TO.ConDetalleTO();
                conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                conDetalleTO.setDetSecuencia(0);
                conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIvaCobrado());

                conDetalleTO.setSecCodigo(operacionesAnexoDAOLocal.getSectorAnexoNumeracion(empresa, anxCompraTO.getCompRetencionNumero()));
                conDetalleTO.setPisNumero(null);


                conDetalleTO.setDetDocumento(anxCompraTO.getCompRetencionNumero());
                conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
                conDetalleTO.setDetDebitoCredito('C');
                conDetalleTO.setDetValor(anxCompraTO.getCompValorbienes());
                conDetalleTO.setDetGenerado(true);
                conDetalleTO.setDetReferencia("IVA-PAG");
                conDetalleTO.setDetOrden(contador);
                contador++;
                listaDetalleTO.add(conDetalleTO);
            }

            if (anxCompraTO.getCompValorservicios().compareTo(cero) > 0) {
                conDetalleTO = new contabilidad.TO.ConDetalleTO();
                conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                conDetalleTO.setDetSecuencia(0);
                conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIvaCobrado());

                conDetalleTO.setSecCodigo(operacionesAnexoDAOLocal.getSectorAnexoNumeracion(empresa, anxCompraTO.getCompRetencionNumero()));
                conDetalleTO.setPisNumero(null);


                conDetalleTO.setDetDocumento(anxCompraTO.getCompRetencionNumero());
                conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
                conDetalleTO.setDetDebitoCredito('C');
                conDetalleTO.setDetValor(anxCompraTO.getCompValorservicios());
                conDetalleTO.setDetGenerado(true);
                conDetalleTO.setDetReferencia("IVA-PAG");
                conDetalleTO.setDetOrden(contador);
                contador++;
                listaDetalleTO.add(conDetalleTO);
            }

            if (anxCompraTO.getCompValorserviciosprofesionales().compareTo(cero) > 0) {
                conDetalleTO = new contabilidad.TO.ConDetalleTO();
                conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                conDetalleTO.setDetSecuencia(0);
                conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIvaCobrado());

                conDetalleTO.setSecCodigo(operacionesAnexoDAOLocal.getSectorAnexoNumeracion(empresa, anxCompraTO.getCompRetencionNumero()));
                conDetalleTO.setPisNumero(null);


                conDetalleTO.setDetDocumento(anxCompraTO.getCompRetencionNumero());
                conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
                conDetalleTO.setDetDebitoCredito('C');
                conDetalleTO.setDetValor(anxCompraTO.getCompValorserviciosprofesionales());
                conDetalleTO.setDetGenerado(true);
                conDetalleTO.setDetReferencia("RET");
                conDetalleTO.setDetOrden(contador);
                contador++;
                listaDetalleTO.add(conDetalleTO);
            }
            String cuentaIrCobrados = operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIrCobrado();
            for (int i = 0; i < anxCompraDetalleTOs.size(); i++) {
                if (anxCompraDetalleTOs.get(i).getDetValorRetenido().compareTo(cero) > 0) {
                    conDetalleTO = new contabilidad.TO.ConDetalleTO();
                    conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                    conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                    conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                    conDetalleTO.setDetSecuencia(0);
                    conDetalleTO.setConCtaCodigo(cuentaIrCobrados);

                    conDetalleTO.setSecCodigo(operacionesAnexoDAOLocal.getSectorAnexoNumeracion(empresa, anxCompraTO.getCompRetencionNumero()));
                    conDetalleTO.setPisNumero(null);


                    conDetalleTO.setDetDocumento(anxCompraTO.getCompRetencionNumero());
                    conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
                    conDetalleTO.setDetDebitoCredito('C');
                    conDetalleTO.setDetValor(anxCompraDetalleTOs.get(i).getDetValorRetenido());
                    conDetalleTO.setDetGenerado(true);
                    conDetalleTO.setDetReferencia("RET");
                    conDetalleTO.setDetOrden(contador);
                    contador++;
                    listaDetalleTO.add(conDetalleTO);
                }
            }
        }


        if (invCompras.getCompFormaPago().equals("POR PAGAR")) {
            String codigoCuenta = operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaCuentasPorPagar();

            String codigoCuenta2 = operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaCuentasPorPagarActivoFijo();
            if (codigoCuenta != null || !codigoCuenta.trim().isEmpty()) {
                conDetalleTO = new contabilidad.TO.ConDetalleTO();
                conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                //        conDetalleTO.setConNumero(conContableTO.getConNumero());
                conDetalleTO.setDetSecuencia(0);
                conDetalleTO.setConCtaCodigo(invCompras.getCompActivoFijo() ? codigoCuenta2 : codigoCuenta);
                conDetalleTO.setSecCodigo(invCompras.getSecCodigo());
                conDetalleTO.setPisNumero(null);
                invCompras.setCompDocumentoFormaPago(invCompras.getCompDocumentoFormaPago() == null ? "" : invCompras.getCompDocumentoFormaPago());
                conDetalleTO.setDetDocumento(invCompras.getCompDocumentoFormaPago().trim().isEmpty() ? numeroDocumento
                        : invCompras.getCompDocumentoFormaPago());
                if (invCompras.getCompDocumentoTipo().equals("04")) {
                    conDetalleTO.setDetDebitoCredito('D');
                } else {
                    conDetalleTO.setDetDebitoCredito('C');
                }
                if (invCompras.getCompRetencionAsumida()) {
                    conDetalleTO.setDetValor(invCompras.getCompTotal());
                } else {
                    conDetalleTO.setDetValor(invCompras.getCompTotal().subtract(invCompras.getCompValorRetenido()));
                }
                conDetalleTO.setDetGenerado(true);
                conDetalleTO.setDetReferencia("CXP");
                conDetalleTO.setDetOrden(contador);
                contador++;
                listaDetalleTO.add(conDetalleTO);
            } else {
                listaDetalleTO = null;
            }

        } else {
            String aux = operacionesInventarioDAOLocal.getCuentaSectorFormaPagoCompra(empresa, invCompras.getCompFormaPago());
            conDetalleTO = new contabilidad.TO.ConDetalleTO();
            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
            conDetalleTO.setDetSecuencia(0);
            conDetalleTO.setConCtaCodigo(aux.trim().isEmpty() ? "" : aux.substring(aux.lastIndexOf("|") + 1).toString());
            conDetalleTO.setSecCodigo(aux.trim().isEmpty() ? "" : aux.substring(0, aux.lastIndexOf("|")).toString());
            conDetalleTO.setPisNumero(null);
            invCompras.setCompDocumentoFormaPago(invCompras.getCompDocumentoFormaPago() == null ? "" : invCompras.getCompDocumentoFormaPago());
            conDetalleTO.setDetDocumento(invCompras.getCompDocumentoFormaPago().trim().isEmpty() ? numeroDocumento
                    : invCompras.getCompDocumentoFormaPago());
            if (invCompras.getCompDocumentoTipo().equals("04")) {
                conDetalleTO.setDetDebitoCredito('D');
            } else {
                conDetalleTO.setDetDebitoCredito('C');
            }
            if (invCompras.getCompRetencionAsumida()) {
                conDetalleTO.setDetValor(invCompras.getCompTotal());
            } else {
                conDetalleTO.setDetValor(invCompras.getCompTotal().subtract(invCompras.getCompValorRetenido()));
            }
            conDetalleTO.setDetGenerado(true);
            conDetalleTO.setDetReferencia("CXP");
            conDetalleTO.setDetOrden(contador);
            contador++;
            listaDetalleTO.add(conDetalleTO);
        }

        if (invCompras.getCompRetencionAsumida() && invCompras.getCompValorRetenido().compareTo(cero) > 0) {
            conDetalleTO = new contabilidad.TO.ConDetalleTO();
            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
            conDetalleTO.setDetSecuencia(0);
            conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIrAsumido());

            conDetalleTO.setSecCodigo(operacionesAnexoDAOLocal.getSectorAnexoNumeracion(empresa, anxCompraTO.getCompRetencionNumero()));
            conDetalleTO.setPisNumero(null);


            conDetalleTO.setDetDocumento(anxCompraTO.getCompRetencionNumero());
            conDetalleTO.setDetDebitoCredito('D');
            conDetalleTO.setDetValor(invCompras.getCompValorRetenido());
            conDetalleTO.setDetGenerado(true);
            conDetalleTO.setDetReferencia("RET-ASU");
            conDetalleTO.setDetOrden(contador);
            contador++;
            listaDetalleTO.add(conDetalleTO);
        }
        BigDecimal acumHaber = cero;
        BigDecimal acumDebe = cero;
        for (ConDetalleTO conDetalleTOAux : listaDetalleTO) {
            if (conDetalleTOAux.getDetDebitoCredito().equals('C')) {
                acumHaber = acumHaber.add(validaciones.Validacion.redondeoDecimalBigDecimal(
                        conDetalleTOAux.getDetValor(), 2, java.math.RoundingMode.HALF_UP));
            }
            if (conDetalleTOAux.getDetDebitoCredito().equals('D')) {
                acumDebe = acumDebe.add(validaciones.Validacion.redondeoDecimalBigDecimal(
                        conDetalleTOAux.getDetValor(), 2, java.math.RoundingMode.HALF_UP));
            }
        }
        if (acumDebe.compareTo(acumHaber) != 0) {
            conDetalleTO = new contabilidad.TO.ConDetalleTO();
            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
            conDetalleTO.setDetSecuencia(0);
            conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaDiferenciaRedondeo());

            conDetalleTO.setSecCodigo(invCompras.getSecCodigo());
            conDetalleTO.setPisNumero(null);


            conDetalleTO.setDetDocumento(numeroDocumento);
            conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
            BigDecimal detValor = acumDebe.subtract(acumHaber);

            if (detValor.compareTo(cero) < 0) {
                conDetalleTO.setDetDebitoCredito('D');
            } else {
                conDetalleTO.setDetDebitoCredito('C');
            }

            conDetalleTO.setDetValor(detValor.abs());
            conDetalleTO.setDetGenerado(true);
            conDetalleTO.setDetReferencia("DIF");
            conDetalleTO.setDetOrden(contador);
            contador++;
            listaDetalleTO.add(conDetalleTO);
        }
        return listaDetalleTO;
    }

    private List<contabilidad.TO.ConDetalleTO> agruparProductoSectorParaRecontabilizarCompras(String empresa, String numeroDocumento,
            List<inventario.TO.InvListaDetalleComprasTO> listaDetalle, contabilidad.TO.ConContableTO conContableTO,
            inventario.entity.InvCompras invCompras, anexos.TO.AnxCompraTO anxCompraTO, List<anexos.TO.AnxCompraDetalleTO> anxCompraDetalleTOs) throws Exception {
        List<inventario.TO.InvListaDetalleComprasTO> listaDetalleFinal = new ArrayList();
        listaDetalleFinal.add(listaDetalle.get(0));

        int contador = 0;
        boolean encontro = false;

        for (int i = 1; i < listaDetalle.size(); i++) {
            contador = 0;
            for (inventario.TO.InvListaDetalleComprasTO invComprasDetalleTOAux : listaDetalleFinal) {
                if (listaDetalle.get(i).getCodigoProducto().equals(invComprasDetalleTOAux.getCodigoProducto())
                        && listaDetalle.get(i).getCodigoCP().equals(invComprasDetalleTOAux.getCodigoCP())) {
                    encontro = true;
                    break;
                } else {
                    encontro = false;
                    contador++;
                }
            }

            if (encontro) {
                listaDetalleFinal.get(contador).setCantidadProducto(listaDetalleFinal.get(contador).getCantidadProducto().add(listaDetalle.get(i).getCantidadProducto()));
                listaDetalleFinal.get(contador).setDetalleSubtotal(listaDetalleFinal.get(contador).getDetalleSubtotal().add(listaDetalle.get(i).getDetalleSubtotal()));
            } else {
                listaDetalleFinal.add(listaDetalle.get(i));
            }
        }
        contador = 1;

        List<contabilidad.TO.ConDetalleTO> listaDetalleTO = new ArrayList();

        java.math.BigDecimal acumulador = new java.math.BigDecimal("0.00");
        java.math.BigDecimal acumuladorAnterior = new java.math.BigDecimal("0.00");
        /////ESTO ES PARA HACER EL PRIMER BLOQUE
        for (inventario.TO.InvListaDetalleComprasTO invComprasDetalleTO : listaDetalleFinal) {
            contabilidad.TO.ConDetalleTO conDetalleTO = new contabilidad.TO.ConDetalleTO();
            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
            conDetalleTO.setDetSecuencia(0);
            inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(empresa, invComprasDetalleTO.getCodigoProducto());
            conDetalleTO.setConCtaCodigo(invProducto.getProCuentaInventario());
            conDetalleTO.setSecCodigo(invComprasDetalleTO.getCodigoCP());
            conDetalleTO.setPisNumero(null);
            conDetalleTO.setDetDocumento(numeroDocumento);
            if (invCompras.getCompDocumentoTipo().equals("04")) {
                conDetalleTO.setDetDebitoCredito('C');
            } else {
                conDetalleTO.setDetDebitoCredito('D');
            }
            if (!invProducto.getProCreditoTributario() && invProducto.getProIva().equals("GRAVA")) {
                java.math.BigDecimal iva = new java.math.BigDecimal("0.00");
                iva = invComprasDetalleTO.getDetalleSubtotal().multiply(invCompras.getCompIvaVigente()).
                        divide(new java.math.BigDecimal("100.00"), java.math.RoundingMode.HALF_UP);
                acumulador = acumulador.add(iva);

                conDetalleTO.setDetValor(invComprasDetalleTO.getDetalleSubtotal().
                        add(validaciones.Validacion.redondeoDecimalBigDecimal(acumulador).
                        subtract(validaciones.Validacion.redondeoDecimalBigDecimal(acumuladorAnterior))));
                acumuladorAnterior = acumulador;
            } else {
                conDetalleTO.setDetValor(invComprasDetalleTO.getDetalleSubtotal());
            }

            conDetalleTO.setDetGenerado(true);
            conDetalleTO.setDetReferencia("RCOM");
            conDetalleTO.setDetOrden(contador);
            contador++;
            if (conDetalleTO.getDetValor().compareTo(cero) > 0) {
                listaDetalleTO.add(conDetalleTO);
            }

        }

        contabilidad.TO.ConDetalleTO conDetalleTO = new contabilidad.TO.ConDetalleTO();
        conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
        conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
        conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
        conDetalleTO.setDetSecuencia(0);
        conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaIvaPagado());
        conDetalleTO.setSecCodigo(invCompras.getSecCodigo());
        conDetalleTO.setPisNumero(null);
        conDetalleTO.setDetDocumento(numeroDocumento);
        if (invCompras.getCompDocumentoTipo().equals("04")) {
            conDetalleTO.setDetDebitoCredito('C');
        } else {
            conDetalleTO.setDetDebitoCredito('D');
        }
        conDetalleTO.setDetValor(invCompras.getCompMontoIva().subtract(validaciones.Validacion.redondeoDecimalBigDecimal(acumulador)));
        conDetalleTO.setDetGenerado(true);
        conDetalleTO.setDetReferencia("RIVA-PA");
        conDetalleTO.setDetOrden(contador);
        contador++;
        if (conDetalleTO.getDetValor().compareTo(cero) > 0) {
            listaDetalleTO.add(conDetalleTO);
        }
////////OTROS IMPUESTOS(IMPUESTO VERDDE, ICE, IRBP)////////////////////////
        conDetalleTO = new contabilidad.TO.ConDetalleTO();
        conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
        conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
        conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
        conDetalleTO.setDetSecuencia(0);
        conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaOtrosImpuestos());
        conDetalleTO.setSecCodigo(invCompras.getSecCodigo());
        conDetalleTO.setPisNumero("");
        conDetalleTO.setDetDocumento(numeroDocumento);
        if (invCompras.getCompDocumentoTipo().equals("04")) {
            conDetalleTO.setDetDebitoCredito('C');
        } else {
            conDetalleTO.setDetDebitoCredito('D');
        }
        conDetalleTO.setDetValor(invCompras.getCompOtrosImpuestos());
        conDetalleTO.setDetGenerado(true);
        conDetalleTO.setDetReferencia("ROTR-IM");
        conDetalleTO.setDetOrden(contador);
        contador++;
        if (conDetalleTO.getDetValor().compareTo(cero) > 0) {
            listaDetalleTO.add(conDetalleTO);
        }

        if (anxCompraTO != null) {
            if (anxCompraTO.getCompValorbienes().compareTo(cero) > 0) {
                conDetalleTO = new contabilidad.TO.ConDetalleTO();
                conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                conDetalleTO.setDetSecuencia(0);
                conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIvaCobrado());

                conDetalleTO.setSecCodigo(operacionesAnexoDAOLocal.getSectorAnexoNumeracion(empresa, anxCompraTO.getCompRetencionNumero()));
                conDetalleTO.setPisNumero(null);

                conDetalleTO.setDetDocumento(anxCompraTO.getCompRetencionNumero());
                conDetalleTO.setDetDebitoCredito('C');
                conDetalleTO.setDetValor(anxCompraTO.getCompValorbienes());
                conDetalleTO.setDetGenerado(true);
                conDetalleTO.setDetReferencia("RIVA-PA");
                conDetalleTO.setDetOrden(contador);
                contador++;
                listaDetalleTO.add(conDetalleTO);
            }
            if (anxCompraTO.getCompValorservicios().compareTo(cero) > 0) {
                conDetalleTO = new contabilidad.TO.ConDetalleTO();
                conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                conDetalleTO.setDetSecuencia(0);
                conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIvaCobrado());

                conDetalleTO.setSecCodigo(operacionesAnexoDAOLocal.getSectorAnexoNumeracion(empresa, anxCompraTO.getCompRetencionNumero()));
                conDetalleTO.setPisNumero(null);

                conDetalleTO.setDetDocumento(anxCompraTO.getCompRetencionNumero());
                conDetalleTO.setDetDebitoCredito('C');
                conDetalleTO.setDetValor(anxCompraTO.getCompValorservicios());
                conDetalleTO.setDetGenerado(true);
                conDetalleTO.setDetReferencia("RIVA-PA");
                conDetalleTO.setDetOrden(contador);
                contador++;
                listaDetalleTO.add(conDetalleTO);
            }

            if (anxCompraTO.getCompValorserviciosprofesionales().compareTo(cero) > 0) {
                conDetalleTO = new contabilidad.TO.ConDetalleTO();
                conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                conDetalleTO.setDetSecuencia(0);
                conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIvaCobrado());

                conDetalleTO.setSecCodigo(operacionesAnexoDAOLocal.getSectorAnexoNumeracion(empresa, anxCompraTO.getCompRetencionNumero()));
                conDetalleTO.setPisNumero(null);

                conDetalleTO.setDetDocumento(anxCompraTO.getCompRetencionNumero());
                conDetalleTO.setDetDebitoCredito('C');
                conDetalleTO.setDetValor(anxCompraTO.getCompValorserviciosprofesionales());
                conDetalleTO.setDetGenerado(true);
                conDetalleTO.setDetReferencia("RRET");
                conDetalleTO.setDetOrden(contador);
                contador++;
                listaDetalleTO.add(conDetalleTO);
            }
            String cuentaIrCobrados = operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIrCobrado();
            for (int i = 0; i < anxCompraDetalleTOs.size(); i++) {
                if (anxCompraDetalleTOs.get(i).getDetValorRetenido().compareTo(cero) > 0) {
                    conDetalleTO = new contabilidad.TO.ConDetalleTO();
                    conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                    conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                    conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                    conDetalleTO.setDetSecuencia(0);
                    conDetalleTO.setConCtaCodigo(cuentaIrCobrados);

                    conDetalleTO.setSecCodigo(operacionesAnexoDAOLocal.getSectorAnexoNumeracion(empresa, anxCompraTO.getCompRetencionNumero()));
                    conDetalleTO.setPisNumero(null);

                    conDetalleTO.setDetDocumento(anxCompraTO.getCompRetencionNumero());
                    conDetalleTO.setDetDebitoCredito('C');
                    conDetalleTO.setDetValor(anxCompraDetalleTOs.get(i).getDetValorRetenido());
                    conDetalleTO.setDetGenerado(true);
                    conDetalleTO.setDetReferencia("RRET");
                    conDetalleTO.setDetOrden(contador);
                    contador++;
                    listaDetalleTO.add(conDetalleTO);
                }
            }
        }


        if (invCompras.getCompFormaPago().equals("POR PAGAR")) {
            String codigoCuenta = operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaCuentasPorPagar();
            String codigoCuenta2 = operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaCuentasPorPagarActivoFijo();
            if (codigoCuenta != null || !codigoCuenta.trim().isEmpty()) {
                conDetalleTO = new contabilidad.TO.ConDetalleTO();
                conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                conDetalleTO.setDetSecuencia(0);
                conDetalleTO.setConCtaCodigo(invCompras.getCompActivoFijo() ? codigoCuenta2 : codigoCuenta);
                conDetalleTO.setSecCodigo(invCompras.getSecCodigo());
                conDetalleTO.setPisNumero(null);
                invCompras.setCompDocumentoFormaPago(invCompras.getCompDocumentoFormaPago() == null ? "" : invCompras.getCompDocumentoFormaPago());
                conDetalleTO.setDetDocumento(invCompras.getCompDocumentoFormaPago().trim().isEmpty() ? numeroDocumento
                        : invCompras.getCompDocumentoFormaPago());
                if (invCompras.getCompDocumentoTipo().equals("04")) {
                    conDetalleTO.setDetDebitoCredito('D');
                } else {
                    conDetalleTO.setDetDebitoCredito('C');
                }
                if (invCompras.getCompRetencionAsumida()) {
                    conDetalleTO.setDetValor(invCompras.getCompTotal());
                } else {
                    conDetalleTO.setDetValor(invCompras.getCompTotal().subtract(invCompras.getCompValorRetenido()));
                }
                conDetalleTO.setDetGenerado(true);
                conDetalleTO.setDetReferencia("RCXP");
                conDetalleTO.setDetOrden(contador);
                contador++;
                listaDetalleTO.add(conDetalleTO);
            } else {
                listaDetalleTO = null;
            }

        } else {
            String aux = operacionesInventarioDAOLocal.getCuentaSectorFormaPagoCompra(empresa, invCompras.getCompFormaPago());
            conDetalleTO = new contabilidad.TO.ConDetalleTO();
            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
            conDetalleTO.setDetSecuencia(0);
            conDetalleTO.setConCtaCodigo(aux.trim().isEmpty() ? "" : aux.substring(aux.lastIndexOf("|") + 1).toString());
            conDetalleTO.setSecCodigo(aux.trim().isEmpty() ? "" : aux.substring(0, aux.lastIndexOf("|")).toString());
            conDetalleTO.setPisNumero(null);
            invCompras.setCompDocumentoFormaPago(invCompras.getCompDocumentoFormaPago() == null ? "" : invCompras.getCompDocumentoFormaPago());
            conDetalleTO.setDetDocumento(invCompras.getCompDocumentoFormaPago().trim().isEmpty() ? numeroDocumento
                    : invCompras.getCompDocumentoFormaPago());
            if (invCompras.getCompDocumentoTipo().equals("04")) {
                conDetalleTO.setDetDebitoCredito('D');
            } else {
                conDetalleTO.setDetDebitoCredito('C');
            }
            if (invCompras.getCompRetencionAsumida()) {
                conDetalleTO.setDetValor(invCompras.getCompTotal());
            } else {
                conDetalleTO.setDetValor(invCompras.getCompTotal().subtract(invCompras.getCompValorRetenido()));
            }
            conDetalleTO.setDetGenerado(true);
            conDetalleTO.setDetReferencia("RCXP");
            conDetalleTO.setDetOrden(contador);
            contador++;
            listaDetalleTO.add(conDetalleTO);
        }

        if (invCompras.getCompRetencionAsumida() && invCompras.getCompValorRetenido().compareTo(cero) > 0) {
            conDetalleTO = new contabilidad.TO.ConDetalleTO();
            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
            conDetalleTO.setDetSecuencia(0);
            conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIrAsumido());

            conDetalleTO.setSecCodigo(operacionesAnexoDAOLocal.getSectorAnexoNumeracion(empresa, anxCompraTO.getCompRetencionNumero()));
            conDetalleTO.setPisNumero(null);

            conDetalleTO.setDetDocumento(anxCompraTO.getCompRetencionNumero());
            conDetalleTO.setDetDebitoCredito('D');
            conDetalleTO.setDetValor(invCompras.getCompValorRetenido());
            conDetalleTO.setDetGenerado(true);
            conDetalleTO.setDetReferencia("RRET-AS");
            conDetalleTO.setDetOrden(contador);
            contador++;
            listaDetalleTO.add(conDetalleTO);
        }

        return listaDetalleTO;
    }
    /*
     * - Estado del Iva - Tipo Producto ("Inventario" o "Costo o Gasto") -
     * Sector - Piscina
     *
     */

    private List<contabilidad.TO.ConDetalleTO> agruparProductoEstadoIvaTipoSectorPiscinaContableVentas(String empresa, String numeroDocumento,
            List<inventario.TO.InvListaDetalleVentasTO> listaDetalle,
            contabilidad.TO.ConContableTO conContableTO,
            inventario.entity.InvVentas invVentas,
            anexos.TO.AnxVentaTO anxVentaTO) throws Exception {
        List<inventario.TO.InvListaDetalleVentasTO> listaDetalleFinal = new ArrayList();
        listaDetalleFinal.add(listaDetalle.get(0));
        int contador = 0;
        boolean encontro = false;
        for (int i = 1; i < listaDetalle.size(); i++) {
            contador = 0;
            for (inventario.TO.InvListaDetalleVentasTO invVentasDetalleTOAux : listaDetalleFinal) {
                System.out.println(listaDetalle.get(i).getGravaIva());
                System.out.println(invVentasDetalleTOAux.getGravaIva());
                System.out.println(invVentasDetalleTOAux.getDetProductoTipo());
                System.out.println(listaDetalle.get(i).getDetProductoTipo());
                System.out.println(listaDetalle.get(i).getCodigoCC());
                System.out.println(invVentasDetalleTOAux.getCodigoCC());
                if (listaDetalle.get(i).getGravaIva().equals(invVentasDetalleTOAux.getGravaIva())
                        && listaDetalle.get(i).getDetProductoTipo().equals(invVentasDetalleTOAux.getDetProductoTipo())
                        && listaDetalle.get(i).getCodigoCP().equals(invVentasDetalleTOAux.getCodigoCP())
                        && ((listaDetalle.get(i).getCodigoCC() == null && invVentasDetalleTOAux.getCodigoCC() == null)
                        || (listaDetalle.get(i).getCodigoCC().equals(invVentasDetalleTOAux.getCodigoCC())))) {
                    encontro = true;
                    break;
                } else {
                    encontro = false;
                    contador++;
                }
            }
            if (encontro) {
                listaDetalleFinal.get(contador).setCantidadProducto(listaDetalleFinal.get(contador).
                        getCantidadProducto().add(listaDetalle.get(i).getCantidadProducto()));
                listaDetalleFinal.get(contador).setDetalleTotal(listaDetalleFinal.get(contador).
                        getDetalleTotal().add(listaDetalle.get(i).getDetalleTotal()));
                listaDetalleFinal.get(contador).setIvaCobrado(listaDetalleFinal.get(contador).
                        getIvaCobrado().add(listaDetalle.get(i).getIvaCobrado()));
            } else {
                listaDetalleFinal.add(listaDetalle.get(i));
            }
        }
        contador = 1;

        List<contabilidad.TO.ConDetalleTO> listaDetalleTO = new ArrayList();
        java.math.BigDecimal acumulador = new java.math.BigDecimal("0.00");
        contabilidad.TO.ConDetalleTO conDetalleTO = new contabilidad.TO.ConDetalleTO();

        conDetalleTO = new contabilidad.TO.ConDetalleTO();
        conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
        conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
        conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
        conDetalleTO.setDetSecuencia(0);

        conDetalleTO.setSecCodigo(invVentas.getSecCodigo());
        conDetalleTO.setPisNumero(null);
        conDetalleTO.setDetDocumento(numeroDocumento);
        conDetalleTO.setDetSaldo(new BigDecimal("0.00"));

        if (invVentas.getVtaDocumentoTipo().equals("04")) {
            conDetalleTO.setDetDebitoCredito('C');
        } else {
            conDetalleTO.setDetDebitoCredito('D');
        }
        java.math.BigDecimal suma = cero;
        if (anxVentaTO != null) {
            suma = anxVentaTO.getVenValorRetenidoIva().add(anxVentaTO.getVenValorRetenidoRenta());
        }
        conDetalleTO.setDetValor(invVentas.getVtaTotal().subtract(suma));
        conDetalleTO.setDetGenerado(true);
        conDetalleTO.setDetReferencia("VXP");
        conDetalleTO.setDetOrden(contador);
        contador++;

        ///////////////ESTO ES PARA EL CLIENTE
        if (invVentas.getVtaFormaPago().equals("POR PAGAR")) {
            conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaCuentasPorCobrar());
        } else {
            String aux = operacionesInventarioDAOLocal.getCuentaSectorFormaPagoVenta(empresa, invVentas.getVtaFormaPago());
            conDetalleTO.setConCtaCodigo(aux.trim().isEmpty() ? "" : aux.substring(aux.lastIndexOf("|") + 1).toString());
            conDetalleTO.setSecCodigo(aux.trim().isEmpty() ? "" : aux.substring(0, aux.lastIndexOf("|")).toString());
        }
        listaDetalleTO.add(conDetalleTO);
        /////ESTO ES PARA HACER EL PRIMER BLOQUE
        for (inventario.TO.InvListaDetalleVentasTO invVentasDetalleTO : listaDetalleFinal) {
            conDetalleTO = new contabilidad.TO.ConDetalleTO();
            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
            conDetalleTO.setDetSecuencia(0);
            conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
            inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(empresa, invVentasDetalleTO.getCodigoProducto());

            conDetalleTO.setConCtaCodigo(operacionesInventarioDAOLocal.buscarInvProducto(empresa, invVentasDetalleTO.getCodigoProducto()).getProCuentaVenta());
            conDetalleTO.setSecCodigo(invVentasDetalleTO.getCodigoCP());
            conDetalleTO.setPisNumero(invVentasDetalleTO.getCodigoCC() == null ? null : invVentasDetalleTO.getCodigoCC());
            conDetalleTO.setDetDocumento(numeroDocumento);

            if (invVentas.getVtaDocumentoTipo().equals("04")) {
                conDetalleTO.setDetDebitoCredito('D');
            } else {
                conDetalleTO.setDetDebitoCredito('C');
            }

            if (!invProducto.getProCreditoTributario() && invProducto.getProIva().equals("GRAVA")) {
                java.math.BigDecimal iva = new java.math.BigDecimal("0.00");
                //iva = invVentasDetalleTO.getIvaCobrado();
                iva = invVentasDetalleTO.getDetalleTotal().divide(
                        new java.math.BigDecimal("1.00").add(
                        invVentas.getVtaIvaVigente().divide(new java.math.BigDecimal("100.00"), java.math.RoundingMode.HALF_UP)), java.math.RoundingMode.HALF_UP).multiply(invVentas.getVtaIvaVigente()).
                        divide(new java.math.BigDecimal("100.00"), java.math.RoundingMode.HALF_UP);

//                iva = invVentasDetalleTO.getDetalleSubtotal().multiply(invVentas.getVtaIvaVigente()).
//                        divide(new java.math.BigDecimal("100.00"), java.math.RoundingMode.HALF_UP);
                acumulador = acumulador.add(iva);
                conDetalleTO.setDetValor(invVentasDetalleTO.getDetalleTotal());

//                conDetalleTO.setDetValor(
//                        invVentasDetalleTO.getDetalleTotal().subtract(
//                        validaciones.Validacion.redondeoDecimalBigDecimal(acumulador).subtract(validaciones.Validacion.redondeoDecimalBigDecimal(acumuladorAnterior))));
//
//                
//                conDetalleTO.setDetValor(
//                        invVentasDetalleTO.getDetalleTotal().add(//1200+72-0 =1272
//                                                                 //120+144-72   
//                        validaciones.Validacion.redondeoDecimalBigDecimal(acumulador).//
//                        subtract(
//                        validaciones.Validacion.redondeoDecimalBigDecimal(acumuladorAnterior))));

            } else {
                conDetalleTO.setDetValor(invProducto.getProIva().equals("GRAVA") ? invVentasDetalleTO.getDetalleTotal().subtract(invVentasDetalleTO.getIvaCobrado()) : invVentasDetalleTO.getDetalleTotal());
            }

            conDetalleTO.setDetGenerado(true);
            conDetalleTO.setDetReferencia("VEN");
            conDetalleTO.setDetOrden(contador);
            contador++;
            listaDetalleTO.add(conDetalleTO);
        }
        //////////ESTO ES PARA EL IVA
        //contabilidad.TO.ConDetalleTO conDetalleTO = new contabilidad.TO.ConDetalleTO();
        conDetalleTO = new contabilidad.TO.ConDetalleTO();
        conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
        conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
        conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
        conDetalleTO.setDetSecuencia(0);
        conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaIvaCobrado());
        conDetalleTO.setSecCodigo(invVentas.getSecCodigo());
        conDetalleTO.setPisNumero(null);
        conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
        conDetalleTO.setDetDocumento(numeroDocumento);
        if (invVentas.getVtaDocumentoTipo().equals("04")) {
            conDetalleTO.setDetDebitoCredito('D');
        } else {
            conDetalleTO.setDetDebitoCredito('C');
        }
        //conDetalleTO.setDetValor(invVentas.getVtaMontoiva());//invVentas.getVtaMontoiva().subtract(validaciones.Validacion.redondeoDecimalBigDecimal(acumulador))
        conDetalleTO.setDetValor(invVentas.getVtaMontoiva().subtract(acumulador));//

        conDetalleTO.setDetGenerado(true);
        conDetalleTO.setDetReferencia("IVA-COB");
        conDetalleTO.setDetOrden(contador);
        contador++;
        if (conDetalleTO.getDetValor().compareTo(cero) > 0) {
            listaDetalleTO.add(conDetalleTO);
        }

        if (anxVentaTO != null) {
            if (anxVentaTO.getVenValorRetenidoIva().compareTo(cero) > 0) {
                conDetalleTO = new contabilidad.TO.ConDetalleTO();
                conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
                conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                conDetalleTO.setDetSecuencia(0);
                conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIvaPagado());
                conDetalleTO.setSecCodigo(invVentas.getSecCodigo());
                conDetalleTO.setPisNumero(null);
                conDetalleTO.setDetDocumento(anxVentaTO.getVenRetencionNumero());
                if (invVentas.getVtaDocumentoTipo().equals("04")) {
                    conDetalleTO.setDetDebitoCredito('C');
                } else {
                    conDetalleTO.setDetDebitoCredito('D');
                }
                conDetalleTO.setDetValor(anxVentaTO.getVenValorRetenidoIva());
                conDetalleTO.setDetGenerado(true);
                conDetalleTO.setDetReferencia("IR-IVA");
                conDetalleTO.setDetOrden(contador);
                contador++;
                listaDetalleTO.add(conDetalleTO);
            }

            if (anxVentaTO.getVenValorRetenidoRenta().compareTo(cero) > 0) {
                conDetalleTO = new contabilidad.TO.ConDetalleTO();
                conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
                conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                conDetalleTO.setDetSecuencia(0);
                conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaRetFteIrPagado());
                conDetalleTO.setSecCodigo(invVentas.getSecCodigo());
                conDetalleTO.setPisNumero(null);
                conDetalleTO.setDetDocumento(anxVentaTO.getVenRetencionNumero());
                if (invVentas.getVtaDocumentoTipo().equals("04")) {
                    conDetalleTO.setDetDebitoCredito('C');
                } else {
                    conDetalleTO.setDetDebitoCredito('D');
                }
                conDetalleTO.setDetValor(anxVentaTO.getVenValorRetenidoRenta());
                conDetalleTO.setDetGenerado(true);
                conDetalleTO.setDetReferencia("IR-RTA");
                conDetalleTO.setDetOrden(contador);
                contador++;
                listaDetalleTO.add(conDetalleTO);
            }
        }

        BigDecimal acumHaber = cero;
        BigDecimal acumDebe = cero;
        for (ConDetalleTO conDetalleTOAux : listaDetalleTO) {
            if (conDetalleTOAux.getDetDebitoCredito().equals('C')) {
                acumHaber = acumHaber.add(validaciones.Validacion.redondeoDecimalBigDecimal(
                        conDetalleTOAux.getDetValor(), 2, java.math.RoundingMode.HALF_UP));
            }
            if (conDetalleTOAux.getDetDebitoCredito().equals('D')) {
                acumDebe = acumDebe.add(validaciones.Validacion.redondeoDecimalBigDecimal(
                        conDetalleTOAux.getDetValor(), 2, java.math.RoundingMode.HALF_UP));
            }
        }

        if (acumDebe.compareTo(acumHaber) != 0) {
            conDetalleTO = new contabilidad.TO.ConDetalleTO();
            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
            conDetalleTO.setDetSecuencia(0);
            conDetalleTO.setConCtaCodigo(operacionesAnexoDAOLocal.getCuentasContablesTO(empresa).getCtaDiferenciaRedondeo());
            conDetalleTO.setSecCodigo(invVentas.getSecCodigo());
            conDetalleTO.setPisNumero(null);
            conDetalleTO.setDetDocumento(numeroDocumento);
            conDetalleTO.setDetSaldo(new BigDecimal("0.00"));
            BigDecimal detValor = cero;
            if (invVentas.getVtaTotal().compareTo(acumDebe) > 0) {
                conDetalleTO.setDetDebitoCredito('C');
                detValor = invVentas.getVtaTotal().subtract(acumDebe);
            } else {
                detValor = invVentas.getVtaTotal().subtract(acumHaber);
                conDetalleTO.setDetDebitoCredito('D');
            }

            conDetalleTO.setDetValor(detValor.abs());
            conDetalleTO.setDetGenerado(true);
            conDetalleTO.setDetReferencia("DIF");
            conDetalleTO.setDetOrden(contador);
            contador++;
            listaDetalleTO.add(conDetalleTO);
        }
        return listaDetalleTO;
    }

//    -
    ///- CREAR LA VALIDACION PRA VERIFICAR LOS PRODUCTOS
    public inventario.TO.MensajeTO validarInvContableComprasDetalleTO(
            String empresa,
            String periodo,
            String motivo,
            String compraNumero,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        List<String> mensajeClase = new ArrayList(1);
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        String retorno = "";
        try {
            List<contabilidad.TO.ConFunContabilizarComprasDetalleTO> validarConDetalle = operacionesContabilidadDAOLocal.getConFunContabilizarComprasDetalle(
                    empresa,
                    periodo,
                    motivo,
                    compraNumero,
                    "VALIDAR");
            boolean banderaValidar = true;
            for (ConFunContabilizarComprasDetalleTO conFunContabilizarComprasDetalleTO : validarConDetalle) {
                if (conFunContabilizarComprasDetalleTO.getDetObservaciones() != null) {
                    mensajeClase.add(conFunContabilizarComprasDetalleTO.getDetObservaciones());
                    banderaValidar = false;
                }
            }
            if (banderaValidar) {
                retorno = "T<html>Correctamente</html>";
            } else {
                retorno = "F<html>Existen los Siguientes Errores...</html>";
                mensajeTO.setListaErrores(mensajeClase);
            }
        } catch (Exception e) {
            retorno = "F<html>Error al validar DetalleContable...</html>";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvContableComprasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);

        } finally {
            //map.put("mensaje", retorno);
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
        }

    }

    public inventario.TO.MensajeTO insertarInvContableComprasTO(
            //    public Map<String, Object> insertarInvContableComprasTO(
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
        Map<String, Object> map = new HashMap<String, Object>();
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        List<String> mensajeClase = new ArrayList(1);
        String retorno = "";
        try {
            comprobar = false;
            boolean contablePendiente = false;
            String tipoCodigo = "";
            if (!recontabilizar) {
                tipoCodigo = operacionesContabilidadDAOLocal.buscarTipoContablePorMotivoCompra(empresa, motivo);
            } else {
                tipoCodigo = tipCodigo;
            }
            if (operacionesContabilidadDAOLocal.buscarTipoContable(empresa, tipoCodigo)) {
                System.out.println("compras    "+empresa+"  "+periodo+"  "+motivo+"  "+compraNumero);
                inventario.entity.InvCompras invCompras = operacionesInventarioDAOLocal.buscarInvCompras(empresa, periodo, motivo, compraNumero);
                if (invCompras.getCompRevisado() || (invCompras.getConNumero() != null && !recontabilizar)) {
                    retorno = "F<html>La compra ya ha sido recontabilizada.</html>";
                } else {
                    List<inventario.TO.InvListaDetalleComprasTO> listaDetalleTO = operacionesInventarioDAOLocal.getListaInvCompraDetalleTO(empresa, periodo, motivo, compraNumero);

                    List<inventario.TO.InvListaDetalleComprasTO> listaDetalleFinal = new ArrayList();
                    listaDetalleFinal.add(listaDetalleTO.get(0));
                    boolean puedeContinuar = true;
                    List<anexos.TO.AnxCompraDetalleTO> anxCompraDetalleTOs = null;
                    anexos.TO.AnxCompraTO anxCompraTO = null;
                    if (!invCompras.getCompDocumentoTipo().equals("00")) {
                        anxCompraTO = operacionesAnexoDAOLocal.getAnexoCompraTO(empresa, periodo, motivo, compraNumero);
                        if (anxCompraTO != null) {
                            anxCompraDetalleTOs = operacionesAnexoDAOLocal.getAnexoCompraDetalleTO(empresa, periodo, motivo, compraNumero);
                        }
                    }
                    //////CREANDO CONTABLE TO
                    contabilidad.TO.ConContableTO conContableTO = new contabilidad.TO.ConContableTO();
                    conContableTO.setEmpCodigo(empresa);
                    conContableTO.setPerCodigo(periodo);
                    conContableTO.setTipCodigo(tipoCodigo);
                    conContableTO.setConFecha(validaciones.Validacion.fecha(invCompras.getCompFecha(), "yyyy-MM-dd"));//"yyyy-MM-dd"
                    //conContableTO.setConFecha(anxCompraTO != null ? anxCompraTO.getCompRetencionFechaEmision() : validaciones.Validacion.fecha(invCompras.getCompFecha(), "yyyy-MM-dd"));
                    conContableTO.setConPendiente(false);
                    conContableTO.setConBloqueado(false);
                    conContableTO.setConAnulado(false);
                    conContableTO.setConGenerado(true);
                    conContableTO.setConConcepto(invCompras.getInvProveedor().getProvNombre().toString().trim());
                    conContableTO.setConDetalle("CONTABLE GENERADO POR EL SISTEMA");
                    conContableTO.setConObservaciones(invCompras.getCompObservaciones());
                    conContableTO.setUsrFechaInsertaContable(validaciones.Validacion.fechaSistema());
                    conContableTO.setUsrInsertaContable(invCompras.getUsrCodigo());
                    ////// CREANDO SUCESO
                    susSuceso = "INSERT";
                    susTabla = "contabilidad.con_contable";
                    conContableTO.setUsrFechaInsertaContable(validaciones.Validacion.fechaSistema());
                    ////// CREANDO NUMERACION
                    contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                            conContableTO.getEmpCodigo(),
                            conContableTO.getPerCodigo(),
                            conContableTO.getTipCodigo()));
                    conNumeracion.setNumSecuencia(new Integer(invCompras.getInvComprasPK().getCompNumero()));
                    ////// CREANDO CONTABLE
                    contabilidad.entity.ConContable conContable;
                    if (!recontabilizar) {
                        conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                    } else {
                        conContable = operacionesContabilidadDAOLocal.buscarContable(empresa, periodo, tipoCodigo, conNumero);
                        conContable.setConConcepto(invCompras.getInvProveedor().getProvNombre().toString().trim());
                        conContable.setConObservaciones(invCompras.getCompObservaciones());
                        conContable.setConFecha(invCompras.getCompFecha());///----------
                    }
                    ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                    List<contabilidad.entity.ConDetalle> listConDetalle = new ArrayList(0);
                    List<contabilidad.entity.ConDetalle> listConDetalleEliminar = new ArrayList(0);
                    List<banco.entity.BanCheque> listBanChequeEliminar = new ArrayList(0);
                    contabilidad.entity.ConDetalle conDetalle = null;

                    List<contabilidad.TO.ConFunContabilizarComprasDetalleTO> listaConDetalleTO = operacionesContabilidadDAOLocal.getConFunContabilizarComprasDetalle(
                            empresa,
                            periodo,
                            motivo,
                            compraNumero,
                            null);
                    for (ConFunContabilizarComprasDetalleTO conDetalleTO : listaConDetalleTO) {
                        conDetalle = new contabilidad.entity.ConDetalle();
                        conDetalle = contabilidad.helper.ConversionesContabilidad.convertirConFunContabilizarDetalleTO_ConDetalle(conDetalleTO);
                        listConDetalle.add(conDetalle);

                    }
                    susDetalle = "Se recontabilizó contable del periodo "
                            + conContable.getConContablePK().getConPeriodo() + ", del tipo contable "
                            + conContable.getConContablePK().getConTipo() + ", de la numeracion "
                            + conNumero;
                    susClave = conContable.getConContablePK().getConPeriodo() + " "
                            + conContable.getConContablePK().getConTipo() + " "
                            + conNumero;
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    if (!recontabilizar) {
                        comprobar = operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                                conContable,
                                listConDetalle,
                                sisSuceso,
                                conNumeracion,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                false,
                                null,
                                null,
                                null,
                                null,
                                null,
                                invCompras,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                sisInfoTO);
                    } else {
                        inventario.entity.InvCompras invComprasAux = inventario.helper.ConversionesInventario.convertirInvCompras_InvCompras(invCompras);
                        invComprasAux.setCompRevisado(true);
                        if (!recontabilizarSinPendiente) {
                            comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConContableCompras(conContable, listConDetalle, invComprasAux, sisSuceso);
                        } else {
                            System.out.println("else recontabilizarSinPendiente");
                            List<contabilidad.TO.ConFunContabilizarComprasDetalleTO> listaConDetalleEliminar = operacionesContabilidadDAOLocal.getConDetalleEliminarTO(empresa, periodo, tipoCodigo, conNumero);
                            for (ConFunContabilizarComprasDetalleTO conDetalleEliminarTO : listaConDetalleEliminar) {
                                listConDetalleEliminar.add(operacionesContabilidadDAOLocal.buscarDetalleContable(conDetalleEliminarTO.getDetSecuencia()));
                                listBanChequeEliminar.add(operacionesBancoDAOLocal.buscarBanCheque(conDetalleEliminarTO.getDetSecuencia()));
                            }
                            if (listConDetalleEliminar != null) {
                                comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConContableComprasMayorizar(conContable, listConDetalle, listConDetalleEliminar, invComprasAux, listBanChequeEliminar,sisSuceso);
                            } 
                        }
                    }
                    if (comprobar) {
                        sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());
                        contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());
                        if (!recontabilizar) {
                            retorno = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero()
                                    + (contablePendiente == true ? "</font>.<font size = 5 color= " + "red" + " ><br><b><small>Observación: PENDIENTE POR DIFERENCIA</small></b></font>" : "") + ".</html>"
                                    + conTipo.getConTipoPK().getTipCodigo() + ", " + conContable.getConContablePK().getConNumero() + "*  " + conContable.getConContablePK().getConPeriodo();
                        } else {
                            retorno = "T<html>Se recontabilizó el contable de esta compra con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero()
                                    + (contablePendiente == true ? "</font>.<font size = 5 color= " + "red" + " ><br><b><small>Observación: PENDIENTE POR DIFERENCIA</small></b></font>" : "") + ".</html>"
                                    + conTipo.getConTipoPK().getTipCodigo() + ", " + conContable.getConContablePK().getConNumero() + "*  " + conContable.getConContablePK().getConPeriodo();
                        }
                    } else {
                        retorno = "F<html>Ocurrió un error al recontabilizar, inténtelo de nuevo...</html>";
                    }
                }
            } else {
                retorno = "F<html>No se encuentra tipo de contable...</html>";
            }
        } catch (Exception e) {
            retorno = "F<html>Error al guardar datos...+" + e.getStackTrace().toString() + "</html>";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvContableComprasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);

        } finally {
            //map.put("mensaje", retorno);
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
        }
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
        try {
            String tipoCodigo = "";
            boolean contablePendiente = false;
            if (!recontabilizar) {
                tipoCodigo = operacionesContabilidadDAOLocal.buscarTipoContablePorMotivoVenta(empresa, motivo);
            } else {
                tipoCodigo = tipCodigo;
            }
            if (operacionesContabilidadDAOLocal.buscarTipoContable(empresa, tipoCodigo)) {
                inventario.entity.InvVentas invVentas = operacionesInventarioDAOLocal.buscarInvVentas(empresa, periodo, motivo, ventaNumero);
                if (invVentas.getConNumero() != null && !recontabilizar) {
                    mensaje = "F<html>La venta ya ha sido recontabilizada.</html>";
                } else {
                    List<inventario.TO.InvListaDetalleVentasTO> listaDetalleTO = operacionesInventarioDAOLocal.getListaInvVentasDetalleTO(empresa, periodo, motivo, ventaNumero);
                    //////CREANDO CONTABLE TO
                    contabilidad.TO.ConContableTO conContableTO = new contabilidad.TO.ConContableTO();
                    conContableTO.setEmpCodigo(empresa);
                    conContableTO.setPerCodigo(periodo);
                    conContableTO.setTipCodigo(tipoCodigo);
                    conContableTO.setConFecha(validaciones.Validacion.fecha(invVentas.getVtaFecha(), "yyyy-MM-dd"));
                    conContableTO.setConPendiente(false);
                    conContableTO.setConBloqueado(false);
                    conContableTO.setConAnulado(false);
                    conContableTO.setConGenerado(true);
                    conContableTO.setConConcepto(invVentas.getInvCliente().getCliNombre().toString().trim());
                    conContableTO.setConDetalle("CONTABLE GENERADO POR EL SISTEMA");
                    conContableTO.setConObservaciones(invVentas.getVtaObservaciones());
                    conContableTO.setUsrFechaInsertaContable(validaciones.Validacion.fechaSistema());
                    conContableTO.setUsrInsertaContable(codigoUsuario);
                    ///// CREANDO UN SUCESO
                    susSuceso = "INSERT";
                    susTabla = "contabilidad.con_contable";
                    conContableTO.setUsrFechaInsertaContable(validaciones.Validacion.fechaSistema());
                    ////// CREANDO NUMERACION
                    contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                            conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                            conContableTO.getTipCodigo()));
                    conNumeracion.setNumSecuencia(new Integer(invVentas.getInvVentasPK().getVtaNumero()));

                    ////// CREANDO CONTABLE
                    contabilidad.entity.ConContable conContable;
                    if (!recontabilizar) {
                        conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                    } else {
                        conContable = operacionesContabilidadDAOLocal.buscarContable(empresa, periodo, tipoCodigo, conNumero);
                        conContable.setConConcepto(invVentas.getInvCliente().getCliNombre().toString().trim());
                        conContable.setConObservaciones(invVentas.getVtaObservaciones());
                        conContable.setConFecha(invVentas.getVtaFecha());
                    }
                    ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                    List<contabilidad.entity.ConDetalle> listConDetalle = new ArrayList(0);
                    contabilidad.entity.ConDetalle conDetalle = null;

                    anexos.TO.AnxVentaTO anxVentaTO = null;
                    if (!invVentas.getVtaDocumentoTipo().equals("00")) {
                        anxVentaTO = operacionesAnexoDAOLocal.getAnexoVentaTO(empresa, periodo, motivo, ventaNumero);
                    }
                    List<contabilidad.TO.ConDetalleTO> listaConDetalleTO = agruparProductoEstadoIvaTipoSectorPiscinaContableVentas(empresa, invVentas.getVtaDocumentoNumero(), listaDetalleTO, conContableTO, invVentas, anxVentaTO);
                    List<contabilidad.entity.ConDetalle> listConDetalleEliminar = new ArrayList(0);
                    BigDecimal acumHaber = cero;
                    BigDecimal acumDebe = cero;
                    for (ConDetalleTO conDetalleTO : listaConDetalleTO) {
                        if (conDetalleTO.getDetDebitoCredito().equals('C')) {
                            acumHaber = acumHaber.add(validaciones.Validacion.redondeoDecimalBigDecimal(
                                    conDetalleTO.getDetValor(), 2, java.math.RoundingMode.HALF_UP));
                        }
                        if (conDetalleTO.getDetDebitoCredito().equals('D')) {
                            acumDebe = acumDebe.add(validaciones.Validacion.redondeoDecimalBigDecimal(
                                    conDetalleTO.getDetValor(), 2, java.math.RoundingMode.HALF_UP));
                        }
                    }
                    if (acumDebe.compareTo(acumHaber) != 0) {
                        conContable.setConPendiente(true);
                        contablePendiente = true;
                    } else {
                        conContable.setConPendiente(false);
                    }
                    boolean existeCuentaContableDetalle = false;
                    String cuentaContableProblemas = "";
                    for (contabilidad.TO.ConDetalleTO conDetalleTO : listaConDetalleTO) {
                        contabilidad.entity.ConCuentas conCuentas = operacionesContabilidadDAOLocal.buscarCuentas(conDetalleTO.getEmpCodigo(),
                                conDetalleTO.getConCtaCodigo());
                        if (conCuentas != null) {
                            conDetalle = new contabilidad.entity.ConDetalle();
                            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                            conDetalle = contabilidad.helper.ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTO);
                            conDetalle.setConContable(conContable);
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(conDetalleTO.getEmpCodigo(),
                                    conDetalleTO.getConCtaCodigo()));
                            conDetalle.setDetSaldo(cero);
                            listConDetalle.add(conDetalle);
                            existeCuentaContableDetalle = true;
                        } else {
                            existeCuentaContableDetalle = false;
                            cuentaContableProblemas = conDetalleTO.getConCtaCodigo();
                            break;
                        }
                    }
                    if (existeCuentaContableDetalle) {
                        susDetalle = "Se recontabilizó contable del periodo "
                                + conContable.getConContablePK().getConPeriodo() + ", del tipo contable "
                                + conContable.getConContablePK().getConTipo() + ", de la numeracion "
                                + conNumero;
                        susClave = conContable.getConContablePK().getConPeriodo() + " "
                                + conContable.getConContablePK().getConTipo() + " "
                                + conNumero;
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        if (existeCuentaContableDetalle) {
                            List<inventario.entity.InvVentas> invVentases = new ArrayList();
                            invVentases.add(invVentas);

                            if (!recontabilizar) {
                                comprobar = operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                                        conContable,
                                        listConDetalle,
                                        sisSuceso,
                                        conNumeracion,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        false,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        invVentases,
                                        null,
                                        null,
                                        null,
                                        sisInfoTO);
                            } else {
                                inventario.entity.InvVentas invVentasAux = inventario.helper.ConversionesInventario.convertirInvVentas_InvVentas(invVentas);
                                invVentasAux.setVtaRevisado(true);
                                List<contabilidad.TO.ConDetalleTO> listaConDetalleEliminar = operacionesContabilidadDAOLocal.getConDetalleTO(empresa, periodo, tipoCodigo, conNumero);
                                existeCuentaContableDetalle = false;
                                cuentaContableProblemas = "";
                                for (contabilidad.TO.ConDetalleTO conDetalleTO : listaConDetalleEliminar) {
                                    contabilidad.entity.ConCuentas conCuentas = operacionesContabilidadDAOLocal.buscarCuentas(conDetalleTO.getEmpCodigo(),
                                            conDetalleTO.getConCtaCodigo());
                                    if (conCuentas != null) {
                                        conDetalle = new contabilidad.entity.ConDetalle();
                                        conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                                        conDetalle = contabilidad.helper.ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTO);
                                        conDetalle.setConContable(conContable);
                                        conDetalle.setDetSaldo(cero);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(conDetalleTO.getEmpCodigo(),
                                                conDetalleTO.getConCtaCodigo()));
                                        listConDetalleEliminar.add(conDetalle);
                                        existeCuentaContableDetalle = true;
                                    } else {
                                        cuentaContableProblemas = conDetalleTO.getConCtaCodigo();
                                        existeCuentaContableDetalle = false;
                                        break;
                                    }
                                }
                                if (existeCuentaContableDetalle) {
                                    comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConContableVentasMayorizar(conContable, listConDetalle, listConDetalleEliminar, invVentasAux, sisSuceso);
                                } else {
                                    mensaje = "F<html>La cuenta: " + cuentaContableProblemas + " no está en el Plan de Cuentas.<br>Corrija el error...</html>";
                                }
                            }

                            if (comprobar) {
                                sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                                contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                                mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                        + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                        + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                        + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>."
                                        + (contablePendiente == true ? "</font>.<font size = 5 color= " + "red" + " ><br><b><small>Observación: PENDIENTE POR DIFERENCIA</small></b></font>" : "")
                                        + "</html>" + conTipo.getConTipoPK().getTipCodigo() + ", " + conContable.getConContablePK().getConNumero();

                            } else {
                                mensaje = "F<html>Ocurrió un error al guardar el contable, inténtelo de nuevo...</html>";
                            }
                        } else {
                            mensaje = "F<html>La cuenta: " + cuentaContableProblemas + " no está en el Plan de Cuentas.<br>Corrija el error...</html>";
                        }
                    } else {
                        mensaje = "F<html>Uno de los productos no tiene Cuenta Contable.<br>Corrija el error...</html>";
                    }
                }
            } else {
                mensaje = "F<html>No se encuentra tipo de contable...</html>";
            }

        } catch (Exception e) {
            mensaje = "F<html>Error al guardar datos...</html>";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvContableVentasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    public inventario.TO.MensajeTO insertarInvConsumosTO(inventario.TO.InvConsumosTO invConsumosTO, List<inventario.TO.InvConsumosDetalleTO> listaInvConsumosDetalleTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        inventario.entity.InvProductoSaldos invProductoSaldos = null;
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        List<String> mensajeClase = new ArrayList(1);
        List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos = new ArrayList(1);
        boolean periodoCerrado = false;
        try {
            if (!validaciones.Validacion.isFechaSuperior(invConsumosTO.getConsFecha(), "yyyy-MM-dd")) {
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invConsumosTO.getConsEmpresa());
                comprobar = false;
                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (validaciones.Validacion.fecha(invConsumosTO.getConsFecha(), "yyyy-MM-dd").getTime()
                            >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && validaciones.Validacion.fecha(invConsumosTO.getConsFecha(), "yyyy-MM-dd").getTime()
                            <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                        comprobar = true;
                        invConsumosTO.setConsPeriodo(sisListaPeriodoTO.getPerCodigo());
                        periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                    }
                }

                if (comprobar) {
                    if (!periodoCerrado) {
                        if (operacionesInventarioDAOLocal.comprobarInvConsumosMotivo(invConsumosTO.getConsEmpresa(), invConsumosTO.getConsMotivo())) {
                            susSuceso = "INSERT";
                            susTabla = "inventario.inv_consumo";
                            invConsumosTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                            ////// CREANDO NUMERACION DE CONSUMO
                            inventario.entity.InvConsumosNumeracion invConsumosNumeracion = new inventario.entity.InvConsumosNumeracion(new inventario.entity.InvConsumosNumeracionPK(invConsumosTO.getConsEmpresa(), invConsumosTO.getConsPeriodo(),
                                    invConsumosTO.getConsMotivo()));
                            ////// CREANDO CONSUMOS
                            inventario.entity.InvConsumos invConsumos = inventario.helper.ConversionesInventario.convertirInvConsumosTO_InvConsumos(invConsumosTO);
                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                            List<inventario.entity.InvConsumosDetalle> listInvConsumosDetalle = new ArrayList(0);
                            inventario.entity.InvConsumosDetalle invConsumosDetalle = null;

                            int estadoDetalle = 0;
                            for (inventario.TO.InvConsumosDetalleTO invConsumosDetalleTO : listaInvConsumosDetalleTO) {
                                invConsumosDetalle = new inventario.entity.InvConsumosDetalle();
                                invConsumosDetalle = inventario.helper.ConversionesInventario.convertirInvConsumosDetalleTO_InvConsumosDetalle(invConsumosDetalleTO);
                                ///// BUSCANDO EL PRODUCTO EN DETALLE
                                inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invConsumosDetalleTO.getConsEmpresa(),
                                        invConsumosDetalleTO.getProCodigoPrincipal());
                                if (invProducto != null) {
                                    invConsumosDetalle.setInvProducto(invProducto);
                                    ////// BUSCANDO LA BODEGA EN EL DETALLE
                                    inventario.entity.InvBodega invBodega = operacionesInventarioDAOLocal.buscarInvBodega(invConsumosDetalleTO.getConsEmpresa(),
                                            invConsumosDetalleTO.getBodCodigo());

                                    if (invBodega != null) {
                                        invConsumosDetalle.setInvBodega(invBodega);
                                        listInvConsumosDetalle.add(invConsumosDetalle);
                                    } else {
                                        estadoDetalle = 2;
                                    }
                                } else {
                                    estadoDetalle = 1;
                                }

                                if (estadoDetalle == 1 || estadoDetalle == 2) {
                                    break;
                                } else {
                                    invProducto = null;
                                }
                            }

                            if (estadoDetalle == 0) {

                                if (!invConsumos.getConsPendiente()) {
                                    List<inventario.entity.InvConsumosDetalle> listadoDetalleConsumos = agrupraProductosBodegaConsumo(listInvConsumosDetalle);
                                    for (int i = 0; i < listadoDetalleConsumos.size(); i++) {
                                        if (!listadoDetalleConsumos.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                            invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                            invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invConsumos.getInvConsumosPK().getConsEmpresa(), listadoDetalleConsumos.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                    listadoDetalleConsumos.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                            ////BUSCO LA BODEGA
                                            invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invConsumos.getInvConsumosPK().
                                                    getConsEmpresa(), listadoDetalleConsumos.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                            ////PONGO EL PRODUCTO
                                            invProductoSaldos.setInvProducto(listadoDetalleConsumos.get(i).getInvProducto());
                                            inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                    invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                    invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                            if (invProductoSaldosConsulta != null) {
                                                ///Como si existe el dato se le suma la nueva cantidad con lo que se va a ingresar
                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                        subtract(listadoDetalleConsumos.get(i).getDetCantidad()));
                                                if (invProductoSaldos.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                    invProductoSaldos.setStkFechaUltimaCompraFinal(invConsumos.getConsFecha());
                                                    invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());

                                                    invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                    invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                    invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());

                                                    listaInvProductoSaldos.add(invProductoSaldos);
                                                } else {
                                                    retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                    mensajeClase.add(listadoDetalleConsumos.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleConsumos.get(i).getInvProducto().getProNombre());
                                                }
                                            } else {
                                                retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                mensajeClase.add(listadoDetalleConsumos.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleConsumos.get(i).getInvProducto().getProNombre());
                                            }
                                        }
                                    }
                                }
                                if (mensajeClase.isEmpty()) {
                                    boolean comprobacionCc = false;
                                    String ccNumero = "";
                                    for (int i = 0; i < listInvConsumosDetalle.size(); i++) {
                                        ccNumero = "";
                                        List<produccion.TO.PrdListaPiscinaTO> prdListaPiscinaTOs = operacionesProduccionDAOLocal.getListaPiscinaBusqueda(invConsumos.getInvConsumosPK().getConsEmpresa(),
                                                listInvConsumosDetalle.get(i).getSecCodigo(), validaciones.Validacion.fecha(invConsumos.getConsFecha(), "yyyy-MM-dd"));
                                        for (int j = 0; j < prdListaPiscinaTOs.size(); j++) {
                                            ccNumero = listInvConsumosDetalle.get(i).getPisNumero();
                                            if (listInvConsumosDetalle.get(i).getPisNumero().equals(prdListaPiscinaTOs.get(j).getPisNumero())) {
                                                comprobacionCc = true;
                                                j = prdListaPiscinaTOs.size();
                                            } else {
                                                comprobacionCc = false;
                                            }
                                        }
                                        if (!comprobacionCc) {
                                            boolean anadirNuevo = true;
                                            for (int k = 0; k < mensajeClase.size(); k++) {
                                                if (!mensajeClase.get(k).equals("No existe un PERIODO DE CONSUMO para la PISCINA " + ccNumero)) {
                                                    anadirNuevo = true;
                                                } else {
                                                    anadirNuevo = false;
                                                }
                                            }
                                            if (anadirNuevo) {
                                                mensajeClase.add("No existe un PERIODO DE CONSUMO para la PISCINA " + ccNumero);
                                                retorno = "FHubo un error al guardar el Consumo...";
                                            }
                                        }
                                    }

                                    if (mensajeClase.isEmpty()) {
                                        /// PREPARANDO OBJETO SISSUCESO (susClave y susDetalle se llenan en DAOTransaccion)
                                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                susTabla,
                                                susClave,
                                                susSuceso,
                                                susDetalle,
                                                sisInfoTO);
                                        comprobar = operacionesInventarioDAOTransaccionLocal.insertarTransaccionInvConsumos(invConsumos, listInvConsumosDetalle,
                                                sisSuceso, invConsumosNumeracion, listaInvProductoSaldos);
                                        if (comprobar) {
                                            sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(invConsumosTO.getConsEmpresa(), invConsumos.getInvConsumosPK().getConsPeriodo());
                                            retorno = "T<html>Se ingresó el consumo con la siguiente información:<br><br>"
                                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                    + "</font>.<br> Motivo: <font size = 5>" + invConsumos.getInvConsumosPK().
                                                    getConsMotivo()
                                                    + "</font>.<br> Número: <font size = 5>" + invConsumos.getInvConsumosPK().getConsNumero() + "</font>.</html>"
                                                    + invConsumos.getInvConsumosPK().getConsNumero() + "," + sisPeriodo.getSisPeriodoPK().getPerCodigo();
                                            mensajeTO.setFechaCreacion(invConsumos.getUsrFechaInserta().toString());
                                        } else {
                                            retorno = "FHubo un error al guardar el Consumo...\nIntente de nuevo o contacte con el administrador";
                                        }
                                    } else {
                                        mensajeTO.setMensaje(retorno);
                                        mensajeTO.setListaErrores(mensajeClase);
                                    }
                                } else {
                                    mensajeTO.setMensaje(retorno);
                                    mensajeTO.setListaErrores(mensajeClase);
                                }
                            } else {
                                if (estadoDetalle == 1) {
                                    retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                } else {
                                    retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                }
                            }
                        }
                    } else {
                        retorno = "F<html>El periodo que corresponde a la fecha que ingresó se encuentra cerrado...</html>";
                    }
                } else {
                    retorno = "FNo se encuentra ningún periodo para la fecha que ingresó...";
                }
            } else {
                retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
            }
        } catch (Exception e) {
            retorno = "FError al guardar datos...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvConsumosTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
//            return retorno;
        }
    }

    public inventario.TO.InvVentaRetencionesTO getInvVentaRetencionesTO(String codigoEmpresa, String facturaNumero) throws Exception {
        inventario.entity.InvVentas invVentasCreadas = null;
        inventario.TO.InvVentaRetencionesTO invVentaRetencionesTO = null;
        inventario.TO.InvConsultaVentasFacturasPorNumeroTO consultaVentasFacturasPorNumeroTO = new inventario.TO.InvConsultaVentasFacturasPorNumeroTO();
        consultaVentasFacturasPorNumeroTO = operacionesInventarioDAOLocal.getConsultaVentasFacturasPorNumeroTO(codigoEmpresa, facturaNumero);
        if (consultaVentasFacturasPorNumeroTO != null) {
            invVentasCreadas = new inventario.entity.InvVentas();
            invVentasCreadas = operacionesInventarioDAOLocal.buscarInvVentas(
                    consultaVentasFacturasPorNumeroTO.getVtaEmpresa(),
                    consultaVentasFacturasPorNumeroTO.getVtaPeriodo(),
                    consultaVentasFacturasPorNumeroTO.getVtaMotivo(),
                    consultaVentasFacturasPorNumeroTO.getVtaNumero());
            if (invVentasCreadas != null) {
                invVentasCreadas = inventario.helper.ConversionesInventario.convertirInvVentas_InvVentas(invVentasCreadas);
                invVentaRetencionesTO = inventario.helper.ConversionesInventario.convertirInvVentaRetenciones_InvVentaRetencionesTO(invVentasCreadas);
            }
        } else {
            return null;
        }
        return invVentaRetencionesTO;
    }

    public inventario.TO.MensajeTO modificarInvConsumosTO(InvConsumosTO invConsumosTO,
            List<InvConsumosDetalleTO> listaInvConsumosDetalleTO,
            List<InvConsumosDetalleTO> listaInvConsumosEliminarDetalleTO,
            boolean desmayorizar, inventario.entity.InvConsumosMotivoAnulacion invConsumosMotivoAnulacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        List<String> mensajeClase = new ArrayList(1);
        boolean periodoCerrado = false;
        String retorno = "";
        inventario.entity.InvProductoSaldos invProductoSaldos = null;
        List<inventario.entity.InvProductoSaldos> listaInvProductoSaldos = new ArrayList(1);
        try {
            if (!validaciones.Validacion.isFechaSuperior(invConsumosTO.getConsFecha(), "yyyy-MM-dd")) {
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invConsumosTO.getConsEmpresa());

                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (validaciones.Validacion.fecha(invConsumosTO.getConsFecha(), "yyyy-MM-dd").getTime()
                            >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && validaciones.Validacion.fecha(invConsumosTO.getConsFecha(), "yyyy-MM-dd").getTime()
                            <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                        comprobar = true;
                        periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                    }
                }

                if (comprobar) {
                    if (!periodoCerrado) {
                        if (operacionesInventarioDAOLocal.comprobarInvConsumosMotivo(invConsumosTO.getConsEmpresa(), invConsumosTO.getConsMotivo())) {
                            inventario.entity.InvConsumos invConsumosCreados = operacionesInventarioDAOLocal.buscarInvConsumos(invConsumosTO.getConsEmpresa(), invConsumosTO.getConsPeriodo(),
                                    invConsumosTO.getConsMotivo(), invConsumosTO.getConsNumero());
                            if (invConsumosCreados != null) {

                                String detalleError = "";
                                if (desmayorizar && listaInvConsumosDetalleTO == null) {
                                    List<inventario.TO.InvListaDetalleConsumoTO> invListaDetalleTO = operacionesInventarioDAOLocal.getListaInvConsumoDetalleTO(invConsumosTO.getConsEmpresa(), invConsumosTO.getConsPeriodo(), invConsumosTO.getConsMotivo(), invConsumosTO.getConsNumero());
                                    if (invListaDetalleTO != null) {
                                        listaInvConsumosDetalleTO = new ArrayList();
                                        for (int i = 0; i < invListaDetalleTO.size(); i++) {
                                            inventario.TO.InvConsumosDetalleTO invConsumosDetalleTO = new inventario.TO.InvConsumosDetalleTO();
                                            invConsumosDetalleTO.setConsEmpresa(invConsumosTO.getConsEmpresa());
                                            invConsumosDetalleTO.setConsPeriodo(invConsumosTO.getConsPeriodo());
                                            invConsumosDetalleTO.setConsMotivo(invConsumosTO.getConsMotivo());
                                            invConsumosDetalleTO.setConsNumero(invConsumosTO.getConsNumero());
                                            invConsumosDetalleTO.setDetSecuencial(invListaDetalleTO.get(i).getSecuencial());
                                            invConsumosDetalleTO.setDetOrden(i + 1);
                                            invConsumosDetalleTO.setDetCantidad(invListaDetalleTO.get(i).getCantidadProducto());
                                            invConsumosDetalleTO.setBodEmpresa(invConsumosTO.getConsEmpresa());
                                            invConsumosDetalleTO.setBodCodigo(invListaDetalleTO.get(i).getCodigoBodega());
                                            invConsumosDetalleTO.setProEmpresa(invConsumosTO.getConsEmpresa());
                                            invConsumosDetalleTO.setProCodigoPrincipal(invListaDetalleTO.get(i).getCodigoProducto());
                                            invConsumosDetalleTO.setSecEmpresa(invConsumosTO.getConsEmpresa());
                                            invConsumosDetalleTO.setSecCodigo(invListaDetalleTO.get(i).getCodigoCP());
                                            invConsumosDetalleTO.setPisEmpresa(invConsumosTO.getConsEmpresa());
                                            invConsumosDetalleTO.setPisSector(invListaDetalleTO.get(i).getCodigoCP());
                                            invConsumosDetalleTO.setPisNumero(invListaDetalleTO.get(i).getCodigoCC());
                                            listaInvConsumosDetalleTO.add(invConsumosDetalleTO);
                                        }
                                    } else {
                                        detalleError = "Hubo en error al recuperar el detalle del CONSUMO.\nContacte con el administrador...";
                                    }
                                }

                                if (detalleError.trim().isEmpty()) {
                                    //preparando suceso
                                    susClave = invConsumosTO.getConsPeriodo() + " "
                                            + invConsumosTO.getConsMotivo() + " " + invConsumosTO.getConsNumero();

                                    susDetalle = invConsumosTO.getConsAnulado() ? "Consumo número " + invConsumosTO.getConsNumero()
                                            + " se anuló por " + invConsumosMotivoAnulacion.getAnuComentario() : "Se modificó el consumo en el periodo "
                                            + invConsumosTO.getConsPeriodo() + ", del motivo "
                                            + invConsumosTO.getConsMotivo() + ", de la numeración "
                                            + invConsumosTO.getConsNumero();
                                    susSuceso = "UPDATE";
                                    susTabla = "inventario.inv_consumo";
                                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                            susTabla,
                                            susClave,
                                            susSuceso,
                                            susDetalle,
                                            sisInfoTO);
                                    invConsumosTO.setUsrCodigo(invConsumosCreados.getUsrCodigo());
                                    invConsumosTO.setUsrFechaInserta(validaciones.Validacion.fecha(invConsumosCreados.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));

                                    ////// CREANDO NUMERACION DE CONSUMO
                                    inventario.entity.InvConsumosNumeracion invConsumosNumeracion = new inventario.entity.InvConsumosNumeracion(new inventario.entity.InvConsumosNumeracionPK(invConsumosTO.getConsEmpresa(), invConsumosTO.getConsPeriodo(),
                                            invConsumosTO.getConsMotivo()));

                                    ////// CREANDO CONSUMOS
                                    inventario.entity.InvConsumos invConsumos = inventario.helper.ConversionesInventario.convertirInvConsumosTO_InvConsumos(invConsumosTO);

                                    ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                    List<inventario.entity.InvConsumosDetalle> listInvConsumosDetalle = new ArrayList(0);
                                    inventario.entity.InvConsumosDetalle invConsumosDetalle = null;

                                    int estadoDetalle = 0;
                                    for (inventario.TO.InvConsumosDetalleTO invConsumosDetalleTO : listaInvConsumosDetalleTO) {
                                        invConsumosDetalle = new inventario.entity.InvConsumosDetalle();
                                        invConsumosDetalle = inventario.helper.ConversionesInventario.convertirInvConsumosDetalleTO_InvConsumosDetalle(invConsumosDetalleTO);

                                        ///// BUSCANDO EL PRODUCTO EN DETALLE
                                        inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invConsumosDetalleTO.getConsEmpresa(),
                                                invConsumosDetalleTO.getProCodigoPrincipal());
                                        if (invProducto != null) {
                                            invConsumosDetalle.setInvProducto(invProducto);
                                            ////// BUSCANDO LA BODEGA EN EL DETALLE
                                            inventario.entity.InvBodega invBodega = operacionesInventarioDAOLocal.buscarInvBodega(invConsumosDetalleTO.getConsEmpresa(),
                                                    invConsumosDetalleTO.getBodCodigo());

                                            if (invBodega != null) {
                                                invConsumosDetalle.setInvBodega(invBodega);
                                                listInvConsumosDetalle.add(invConsumosDetalle);
                                            } else {
                                                estadoDetalle = 2;
                                            }
                                        } else {
                                            estadoDetalle = 1;
                                        }

                                        if (estadoDetalle == 1 || estadoDetalle == 2) {
                                            break;
                                        } else {
                                            invProducto = null;
                                        }
                                    }

                                    if (estadoDetalle == 0) {
                                        ////// CONVIRTIENDO A ENTIDAD EL DETALLE A ELIMINAR
                                        List<inventario.entity.InvConsumosDetalle> listInvConsumosDetalleEliminar = new ArrayList(0);
                                        inventario.entity.InvConsumosDetalle invConsumosDetalleEliminar = null;

                                        int estadoDetalleEliminar = 0;
                                        if (listaInvConsumosEliminarDetalleTO != null) {
                                            for (inventario.TO.InvConsumosDetalleTO invConsumosDetalleTO : listaInvConsumosEliminarDetalleTO) {
                                                invConsumosDetalleEliminar = new inventario.entity.InvConsumosDetalle();
                                                invConsumosDetalleTO.setConsPeriodo(invConsumosTO.getConsPeriodo());
                                                invConsumosDetalleEliminar = inventario.helper.ConversionesInventario.convertirInvConsumosDetalleTO_InvConsumosDetalle(invConsumosDetalleTO);
                                                invConsumosDetalleEliminar.setInvConsumos(invConsumos);

                                                ///// BUSCANDO EL PRODUCTO EN DETALLE
                                                inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invConsumosDetalleTO.getConsEmpresa(),
                                                        invConsumosDetalleTO.getProCodigoPrincipal());
                                                if (invProducto != null) {
                                                    invConsumosDetalleEliminar.setInvProducto(invProducto);
                                                    ////// BUSCANDO LA BODEGA EN EL DETALLE
                                                    inventario.entity.InvBodega invBodega = operacionesInventarioDAOLocal.buscarInvBodega(invConsumosDetalleTO.getConsEmpresa(),
                                                            invConsumosDetalleTO.getBodCodigo());

                                                    if (invBodega != null) {
                                                        invConsumosDetalleEliminar.setInvBodega(invBodega);
                                                        listInvConsumosDetalleEliminar.add(invConsumosDetalleEliminar);
                                                    } else {
                                                        estadoDetalleEliminar = 2;
                                                    }
                                                } else {
                                                    estadoDetalleEliminar = 1;
                                                }

                                                if (estadoDetalleEliminar == 1 || estadoDetalleEliminar == 2) {
                                                    break;
                                                } else {
                                                    invProducto = null;
                                                }
                                            }
                                        }
                                        if (estadoDetalleEliminar == 0) {

                                            if (!invConsumos.getConsPendiente() || desmayorizar) {
                                                List<inventario.entity.InvConsumosDetalle> listadoDetalleConsumos = agrupraProductosBodegaConsumo(listInvConsumosDetalle);
                                                for (int i = 0; i < listadoDetalleConsumos.size(); i++) {
                                                    if (!listadoDetalleConsumos.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                        invProductoSaldos = new inventario.entity.InvProductoSaldos();
                                                        invProductoSaldos.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invConsumos.getInvConsumosPK().getConsEmpresa(), listadoDetalleConsumos.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                listadoDetalleConsumos.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                        ////BUSCO LA BODEGA
                                                        invProductoSaldos.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invConsumos.getInvConsumosPK().
                                                                getConsEmpresa(), listadoDetalleConsumos.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                        ////PONGO EL PRODUCTO
                                                        invProductoSaldos.setInvProducto(listadoDetalleConsumos.get(i).getInvProducto());
                                                        inventario.entity.InvProductoSaldos invProductoSaldosConsulta = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldos.getInvProductoSaldosPK().getStkEmpresa(),
                                                                invProductoSaldos.getInvProductoSaldosPK().getStkBodega(),
                                                                invProductoSaldos.getInvProductoSaldosPK().getStkProducto());
                                                        if (invProductoSaldosConsulta != null) {
                                                            ///Como si existe el dato se le suma la nueva cantidad con lo que se va a ingresar
                                                            if (desmayorizar || invConsumos.getConsAnulado()) {
                                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                        add(listadoDetalleConsumos.get(i).getDetCantidad()));
                                                            } else {
                                                                invProductoSaldos.setStkSaldoFinal(invProductoSaldosConsulta.getStkSaldoFinal().
                                                                        subtract(listadoDetalleConsumos.get(i).getDetCantidad()));
                                                            }
                                                            if (invProductoSaldos.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                                invProductoSaldos.setStkFechaUltimaCompraFinal(invConsumos.getConsFecha());
                                                                invProductoSaldos.setStkValorUltimaCompraFinal(invProductoSaldosConsulta.getStkValorUltimaCompraFinal());

                                                                invProductoSaldos.setStkSaldoInicial(invProductoSaldosConsulta.getStkSaldoInicial());
                                                                invProductoSaldos.setStkValorPromedioInicial(invProductoSaldosConsulta.getStkValorPromedioInicial());
                                                                invProductoSaldos.setStkValorPromedioFinal(invProductoSaldosConsulta.getStkValorPromedioFinal());

                                                                listaInvProductoSaldos.add(invProductoSaldos);
                                                            } else {
                                                                retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                mensajeClase.add(listadoDetalleConsumos.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleConsumos.get(i).getInvProducto().getProNombre());
                                                            }
                                                        } else {
                                                            retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                            mensajeClase.add(listadoDetalleConsumos.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleConsumos.get(i).getInvProducto().getProNombre());
                                                        }
                                                    }
                                                }
                                            }
                                            if (mensajeClase.isEmpty()) {
                                                boolean comprobacionCc = false;
                                                String ccNumero = "";
                                                for (int i = 0; i < listInvConsumosDetalle.size(); i++) {
                                                    ccNumero = "";

                                                    List<produccion.TO.PrdListaPiscinaTO> prdListaPiscinaTOs = operacionesProduccionDAOLocal.getListaPiscinaBusqueda(invConsumos.getInvConsumosPK().getConsEmpresa(),
                                                            listInvConsumosDetalle.get(i).getSecCodigo(), validaciones.Validacion.fecha(invConsumos.getConsFecha(), "yyyy-MM-dd"));

                                                    for (int j = 0; j < prdListaPiscinaTOs.size(); j++) {
                                                        ccNumero = listInvConsumosDetalle.get(i).getPisNumero();
                                                        if (listInvConsumosDetalle.get(i).getPisNumero().equals(prdListaPiscinaTOs.get(j).getPisNumero())) {
                                                            comprobacionCc = true;
                                                            j = prdListaPiscinaTOs.size();
                                                        } else {
                                                            comprobacionCc = false;
                                                        }
                                                    }
                                                    if (!comprobacionCc) {
                                                        boolean anadirNuevo = false;
                                                        for (int k = 0; k < mensajeClase.size(); k++) {
                                                            if (!mensajeClase.get(k).equals("No existe un PERIODO DE CONSUMO para la PISCINA " + ccNumero)) {
                                                                anadirNuevo = true;
                                                            } else {
                                                                anadirNuevo = false;
                                                            }
                                                        }
                                                        if (anadirNuevo) {
                                                            mensajeClase.add("No existe un PERIODO DE CONSUMO para la PISCINA " + ccNumero);
                                                            retorno = "FHubo un error al guardar el Consumo.";
                                                        }
                                                    }
                                                }
                                                if (mensajeClase.isEmpty()) {
                                                    if (invConsumos.getConsAnulado()) {
                                                        invConsumosMotivoAnulacion.setInvConsumos(invConsumos);
                                                    }
                                                    comprobar = operacionesInventarioDAOTransaccionLocal.modificarInvConsumos(invConsumos, listInvConsumosDetalle,
                                                            listInvConsumosDetalleEliminar, sisSuceso, listaInvProductoSaldos, invConsumosMotivoAnulacion);
                                                    if (comprobar) {
                                                        sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(invConsumosTO.getConsEmpresa(), invConsumos.getInvConsumosPK().getConsPeriodo());
                                                        retorno = "T<html>Se  " + (invConsumosTO.getConsAnulado() ? "anuló" : "modificó") + "  el consumo con la siguiente información:<br><br>"
                                                                + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                                + "</font>.<br> Motivo: <font size = 5>" + invConsumos.getInvConsumosPK().
                                                                getConsMotivo()
                                                                + "</font>.<br> Número: <font size = 5>" + invConsumos.getInvConsumosPK().getConsNumero() + "</font>.</html>";
                                                        mensajeTO.setFechaCreacion(invConsumos.getUsrFechaInserta().toString());
                                                    } else {
                                                        retorno = "FHubo un error al guardar el Consumo...\nIntente de nuevo o contacte con el administrador";
                                                    }
                                                } else {
                                                    mensajeTO.setMensaje(retorno);
                                                    mensajeTO.setListaErrores(mensajeClase);
                                                }
                                            } else {
                                                mensajeTO.setMensaje(retorno);
                                                mensajeTO.setListaErrores(mensajeClase);
                                            }
                                        } else {
                                            if (estadoDetalleEliminar == 1) {
                                                retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                            } else {
                                                retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                            }
                                        }
                                    } else {
                                        if (estadoDetalle == 1) {
                                            retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                        } else {
                                            retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                        }
                                    }
                                } else {
                                    retorno = "F<html>" + detalleError + "</html>";
                                }
                            }
                        } else {
                            retorno = "FNo se encuentra el motivo...";
                        }
                    } else {
                        retorno = "F<html>No se puede MAYORIZAR, DESMAYORIZAR o ANULAR debido a que el período se encuentra cerrado...</html>";
                    }
                } else {
                    retorno = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
                }
            } else {
                retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
            }
        } catch (Exception e) {
            retorno = "FError al guardar datos...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvConsumosTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
        }
    }

    public inventario.TO.InvCompraCabeceraTO getInvCompraCabeceraTO(String empresa, String codigoPeriodo, String motivo, String numeroCompra) throws Exception {
        return operacionesInventarioDAOLocal.getInvCompraCabeceraTO(empresa, codigoPeriodo, motivo, numeroCompra);
    }

    public inventario.TO.InvVentaCabeceraTO getInvVentaCabeceraTO(String empresa, String codigoPeriodo, String motivo, String numeroVenta) throws Exception {
        return operacionesInventarioDAOLocal.getInvVentaCabeceraTO(empresa, codigoPeriodo, motivo, numeroVenta);
    }

    public inventario.TO.InvProformaCabeceraTO getInvProformaCabeceraTO(String empresa, String codigoPeriodo, String motivo, String numeroProforma) throws Exception {
        return operacionesInventarioDAOLocal.getInvProformaCabeceraTO(empresa, codigoPeriodo, motivo, numeroProforma);
    }

    public inventario.TO.InvConsumosTO getInvConsumoCabeceraTO(String empresa, String codigoPeriodo, String motivo, String numeroConsumo) throws Exception {
        return operacionesInventarioDAOLocal.getInvConsumoCabeceraTO(empresa, codigoPeriodo, motivo, numeroConsumo);
    }

    public List<inventario.TO.InvListaDetalleComprasTO> getListaInvCompraDetalleTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvCompraDetalleTO(empresa, periodo, motivo, numeroCompra);
    }

    public List<inventario.TO.InvListaDetalleVentasTO> getListaInvVentasDetalleTO(String empresa, String periodo, String motivo, String numeroVentas) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvVentasDetalleTO(empresa, periodo, motivo, numeroVentas);
    }

    public List<inventario.TO.InvListaDetalleProformasTO> getListaInvProformasDetalleTO(String empresa, String periodo, String motivo, String numeroProformas) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvProformasDetalleTO(empresa, periodo, motivo, numeroProformas);
    }

    public List<inventario.TO.InvListaDetalleConsumoTO> getListaInvConsumoDetalleTO(String empresa, String periodo, String motivo, String numeroConsumos) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvConsumoDetalleTO(empresa, periodo, motivo, numeroConsumos);
    }

    public List<inventario.TO.InvListaProductosTO> getListaProductosTO(String empresa, String busqueda, String bodega, String categoria, String fecha, boolean incluirInactivos, boolean limite) throws Exception {
        return operacionesInventarioDAOLocal.getListaProductosTO(empresa, busqueda, bodega, categoria, fecha, incluirInactivos, limite);
    }

    public List<inventario.TO.InvListaClienteTO> getListaClienteTO(String empresa, String busqueda, boolean activo_Cliente) throws Exception {
        return operacionesInventarioDAOLocal.getListaClienteTO(empresa, busqueda, activo_Cliente);
    }

    public List<inventario.TO.InvListaProveedoresTO> getListaProveedoresTO(String empresa, String busqueda, boolean activoProveedor) throws Exception {
        return operacionesInventarioDAOLocal.getListaProveedoresTO(empresa, busqueda, activoProveedor);
    }

    public List<inventario.TO.InvListaBodegasTO> getListaBodegasTO(String empresa, boolean inacivo) throws Exception {
        return operacionesInventarioDAOLocal.getListaBodegasTO(empresa, inacivo);
    }

    public List<inventario.TO.InvComboBodegaTO> getInvComboBodegaTO(java.lang.String empresa) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvComboBodegaTO(empresa);
    }

    public List<inventario.TO.InvCategoriaComboProductoTO> getListaCategoriaComboTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getListaCategoriaComboTO(empresa);
    }

    public List<inventario.TO.InvProductoPresentacionUnidadesComboListadoTO> getListaPresentacionUnidadComboTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getListaPresentacionUnidadComboTO(empresa);
    }

    @Override
    public String accionInvProductoPresentacionUnidadesTO(inventario.TO.InvProductoPresentacionUnidadesTO invProductoPresentacionUnidadesTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = invProductoPresentacionUnidadesTO.getPresuCodigo() + " : " + invProductoPresentacionUnidadesTO.getPresuDetalle();
            if (accion == 'I') {
                susDetalle = "Se insertó Producto Presentación Caja " + invProductoPresentacionUnidadesTO.getPresuDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó Producto Presentación Caja " + invProductoPresentacionUnidadesTO.getPresuDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó Producto Presentación Caja " + invProductoPresentacionUnidadesTO.getPresuDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_producto_presentacion_Unidad";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invProductoMedida
            invProductoPresentacionUnidadesTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
            inventario.entity.InvProductoPresentacionUnidades invProductoPresentacionUnidades = inventario.helper.ConversionesInventario.convertirInvProductoPresentacionUnidadesTO_InvProductoPresentacionUnidades(invProductoPresentacionUnidadesTO);

            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoPresentacionUnidades(
                        invProductoPresentacionUnidadesTO.getPresuEmpresa(),
                        invProductoPresentacionUnidadesTO.getPresuCodigo())) {
                    if (operacionesInventarioDAOLocal.comprobarEliminarInvProductoPresentacionUnidades(
                            invProductoPresentacionUnidadesTO.getPresuEmpresa(),
                            invProductoPresentacionUnidadesTO.getPresuCodigo())) {
                        invProductoPresentacionUnidades.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarInvProductoPresentacionUnidades(
                                invProductoPresentacionUnidadesTO.getPresuEmpresa(),
                                invProductoPresentacionUnidadesTO.getPresuCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoPresentacionUnidades(invProductoPresentacionUnidades, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se puede eliminar, el Presentación Caja ya esta asignado a algunos Productos...";
                    }
                } else {
                    mensaje = "FNo se encuentra el Producto Presentación Caja...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoPresentacionUnidades(
                        invProductoPresentacionUnidadesTO.getPresuEmpresa(),
                        invProductoPresentacionUnidadesTO.getPresuCodigo())) {
                    invProductoPresentacionUnidades.setUsrFechaInserta(
                            operacionesInventarioDAOLocal.buscarInvProductoPresentacionUnidades(
                            invProductoPresentacionUnidadesTO.getPresuEmpresa(),
                            invProductoPresentacionUnidadesTO.getPresuCodigo()).getUsrFechaInserta());
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoPresentacionUnidades(invProductoPresentacionUnidades, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el Producto Presentación Caja...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesInventarioDAOLocal.comprobarInvProductoPresentacionUnidades(
                        invProductoPresentacionUnidadesTO.getPresuEmpresa(),
                        invProductoPresentacionUnidadesTO.getPresuCodigo())) {
                    invProductoPresentacionUnidades.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoPresentacionUnidades(invProductoPresentacionUnidades, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe el Unidad Producto...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el Producto Presentación Caja";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el Producto Presentación Caja";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente  el Producto Presentación Caja";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar  el Unidad " + invProductoPresentacionUnidadesTO.getPresuDetalle() + ", inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvProductoPresentacionUnidadTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    public List<inventario.TO.InvProductoMarcaComboListadoTO> getInvMarcaComboListadoTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getInvMarcaComboListadoTO(empresa);
    }

    @Override
    public String accionInvProductoMarcaTO(inventario.TO.InvProductoMarcaTO invProductoMarcaTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = invProductoMarcaTO.getMarCodigo() + " : " + invProductoMarcaTO.getMarDetalle();
            if (accion == 'I') {
                susDetalle = "Se insertó Marca producto " + invProductoMarcaTO.getMarDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó Marca producto " + invProductoMarcaTO.getMarDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó Marca producto " + invProductoMarcaTO.getMarDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_producto_marca";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invProductoMedida
            invProductoMarcaTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
            inventario.entity.InvProductoMarca invProductoMarca = inventario.helper.ConversionesInventario.convertirInvProductoMarcaTO_InvProductoMarca(invProductoMarcaTO);

            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoMarca(
                        invProductoMarcaTO.getMarEmpresa(),
                        invProductoMarcaTO.getMarCodigo())) {
                    if (operacionesInventarioDAOLocal.comprobarEliminarInvProductoMarca(
                            invProductoMarcaTO.getMarEmpresa(),
                            invProductoMarcaTO.getMarCodigo())) {

                        invProductoMarca.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarInvProductoMarca(
                                invProductoMarcaTO.getMarEmpresa(),
                                invProductoMarcaTO.getMarCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoMarca(invProductoMarca, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se puede eliminar, el Marca ya esta asignado a algunos Productos...";
                    }
                } else {
                    mensaje = "FNo se encuentra el Marca Producto...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoMarca(
                        invProductoMarcaTO.getMarEmpresa(),
                        invProductoMarcaTO.getMarCodigo())) {
                    invProductoMarca.setUsrFechaInserta(
                            operacionesInventarioDAOLocal.buscarInvProductoMarca(
                            invProductoMarcaTO.getMarEmpresa(),
                            invProductoMarcaTO.getMarCodigo()).getUsrFechaInserta());
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoMarca(invProductoMarca, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el Marca del Producto...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesInventarioDAOLocal.comprobarInvProductoMarca(
                        invProductoMarcaTO.getMarEmpresa(),
                        invProductoMarcaTO.getMarCodigo())) {
                    invProductoMarca.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoMarca(invProductoMarca, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe el Marca Producto...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el Marca de Producto";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el Marca de Producto";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente  el Marca de Producto";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar  el Marca " + invProductoMarcaTO.getMarDetalle() + ", inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvProductoMarca",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    public List<inventario.TO.InvProductoPresentacionCajasComboListadoTO> getListaPresentacionCajaComboTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getListaPresentacionCajaComboTO(empresa);
    }

    @Override
    public String accionInvProductoPresentacionCajasTO(inventario.TO.InvProductoPresentacionCajasTO invProductoPresentacionCajasTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = invProductoPresentacionCajasTO.getPrescCodigo() + " : " + invProductoPresentacionCajasTO.getPrescDetalle();
            if (accion == 'I') {
                susDetalle = "Se insertó Producto Presentación Caja " + invProductoPresentacionCajasTO.getPrescDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó Producto Presentación Caja " + invProductoPresentacionCajasTO.getPrescDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó Producto Presentación Caja " + invProductoPresentacionCajasTO.getPrescDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_producto_presentacion_cajas";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invProductoMedida
            invProductoPresentacionCajasTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
            inventario.entity.InvProductoPresentacionCajas invProductoPresentacionCajas = inventario.helper.ConversionesInventario.convertirInvProductoPresentacionCajasTO_InvProductoPresentacionCajas(invProductoPresentacionCajasTO);

            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoPresentacionCajas(
                        invProductoPresentacionCajasTO.getPrescEmpresa(),
                        invProductoPresentacionCajasTO.getPrescCodigo())) {
                    if (operacionesInventarioDAOLocal.comprobarEliminarInvProductoPresentacionCajas(
                            invProductoPresentacionCajasTO.getPrescEmpresa(),
                            invProductoPresentacionCajasTO.getPrescCodigo())) {
                        invProductoPresentacionCajas.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarInvProductoPresentacionCajas(
                                invProductoPresentacionCajasTO.getPrescEmpresa(),
                                invProductoPresentacionCajasTO.getPrescCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoPresentacionCajas(invProductoPresentacionCajas, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se puede eliminar, el Presentación Caja ya esta asignado a algunos Productos...";
                    }
                } else {
                    mensaje = "FNo se encuentra el Producto Presentación Caja...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoPresentacionCajas(
                        invProductoPresentacionCajasTO.getPrescEmpresa(),
                        invProductoPresentacionCajasTO.getPrescCodigo())) {
                    invProductoPresentacionCajas.setUsrFechaInserta(
                            operacionesInventarioDAOLocal.buscarInvProductoPresentacionCajas(
                            invProductoPresentacionCajasTO.getPrescEmpresa(),
                            invProductoPresentacionCajasTO.getPrescCodigo()).getUsrFechaInserta());
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoPresentacionCajas(invProductoPresentacionCajas, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el Producto Presentación Caja...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesInventarioDAOLocal.comprobarInvProductoPresentacionCajas(
                        invProductoPresentacionCajasTO.getPrescEmpresa(),
                        invProductoPresentacionCajasTO.getPrescCodigo())) {
                    invProductoPresentacionCajas.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoPresentacionCajas(invProductoPresentacionCajas, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe el Unidad Producto...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el Producto Presentación Caja";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el Producto Presentación Caja";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente  el Producto Presentación Caja";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar  el Unidad " + invProductoPresentacionCajasTO.getPrescDetalle() + ", inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvProductoPresentacionCajasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    public List<inventario.TO.InvCompraMotivoComboTO> getListaCompraMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        return operacionesInventarioDAOLocal.getListaCompraMotivoComboTO(empresa, filtrarInactivos);
    }

    public List<inventario.TO.InvVentaMotivoComboTO> getListaVentaMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        return operacionesInventarioDAOLocal.getListaVentaMotivoComboTO(empresa, filtrarInactivos);
    }

    public List<inventario.TO.InvProformaMotivoComboTO> getListaProformaMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        return operacionesInventarioDAOLocal.getListaProformaMotivoComboTO(empresa, filtrarInactivos);
    }

    public List<inventario.TO.InvCategoriaProveedorComboTO> getListaCategoriaProveedorComboTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getListaCategoriaProveedorComboTO(empresa);
    }

    public List<inventario.TO.InvCategoriaClienteComboTO> getListaCategoriaClienteComboTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getListaCategoriaClienteComboTO(empresa);
    }

    public List<inventario.TO.InvBodegaTO> getBodegaTO(String empresa, String codigo) throws Exception {
        return operacionesInventarioDAOLocal.getBodegaTO(empresa, codigo);
    }

    public List<inventario.TO.InvProductoTO> getProductoTO(String empresa, String codigo) throws Exception {
        return operacionesInventarioDAOLocal.getProductoTO(empresa, codigo);
    }

    public List<inventario.TO.InvClienteTO> getClienteTO(String empresa, String codigo) throws Exception {
        return operacionesInventarioDAOLocal.getClienteTO(empresa, codigo);
    }

    public List<inventario.TO.InvProveedorTO> getProveedorTO(String empresa, String codigo) throws Exception {
        return operacionesInventarioDAOLocal.getProveedorTO(empresa, codigo);
    }

    public inventario.TO.InvProveedorTO getBuscaCedulaProveedorTO(String empresa, String cedRuc) throws Exception {
        return operacionesInventarioDAOLocal.getBuscaCedulaProveedorTO(empresa, cedRuc);
    }

    public boolean comprobarInvAplicaRetencionIva(
            String empresa,
            String codigo) throws Exception {
        return operacionesInventarioDAOLocal.comprobarInvAplicaRetencionIva(empresa, codigo);
    }

    public String getConteoNumeroFacturaCompra(String empresaCodigo, String provCodigo, String compDocumentoTipo, String compDocumentoNumero) throws Exception {
        return operacionesInventarioDAOLocal.getConteoNumeroFacturaCompra(empresaCodigo, provCodigo, compDocumentoTipo, compDocumentoNumero);
    }

    public List<inventario.TO.InvComboFormaPagoTO> getComboFormaPagoCompra(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getComboFormaPagoCompra(empresa);
    }

    public List<inventario.TO.InvComboFormaPagoTO> getComboFormaPagoVenta(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getComboFormaPagoVenta(empresa);
    }

    public List<inventario.TO.InvListaConsultaCompraTO> getFunComprasListado(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception {
        return operacionesInventarioDAOLocal.getFunComprasListado(empresa, fechaDesde, fechaHasta, status);
    }

    public List<inventario.TO.InvListaConsultaCompraTO> getListaInvConsultaCompra(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvConsultaCompra(empresa, periodo, motivo, busqueda, nRegistros);
    }

    public List<inventario.TO.InvListaConsultaVentaTO> getFunVentasListado(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception {
        return operacionesInventarioDAOLocal.getFunVentasListado(empresa, fechaDesde, fechaHasta, status);
    }

    public List<inventario.TO.InvListaConsultaVentaTO> getListaInvConsultaVenta(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvConsultaVenta(empresa, periodo, motivo, busqueda, nRegistros);
    }

    public List<inventario.TO.InvListaConsultaProformaTO> getListaInvConsultaProforma(String empresa, String periodo, String motivo, String busqueda) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvConsultaProforma(empresa, periodo, motivo, busqueda);
    }

    public List<inventario.TO.InvListaConsultaConsumosTO> getFunConsumosListado(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception {
        return operacionesInventarioDAOLocal.getFunConsumosListado(empresa, fechaDesde, fechaHasta, status);
    }

    public List<inventario.TO.InvListaConsultaConsumosTO> getListaInvConsultaConsumos(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvConsultaConsumos(empresa, periodo, motivo, busqueda, nRegistros);
    }

    public List<inventario.TO.InvConsumosImportarExportarTO> getListaInvConsumosImportarExportarTO(String empresa, String desde, String hasta) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvConsumosImportarExportarTO(empresa, desde, hasta);
    }

    public List<inventario.TO.InvConsumosMotivoComboTO> getListaConsumosMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        return operacionesInventarioDAOLocal.getListaConsumosMotivoComboTO(empresa, filtrarInactivos);
    }

    public List<inventario.TO.InvMedidaComboTO> getListaInvMedidaTablaTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvMedidaTablaTO(empresa);
    }

    // <editor-fold defaultstate="collapsed" desc="CONSUMOSMOTIVO">
    public List<inventario.TO.InvListaConsumosMotivoTO> getInvListaConsumosMotivoTO(java.lang.String empresa) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvListaConsumosMotivoTO(empresa);
    }

    public String accionInvConsumosMotivo(inventario.TO.InvConsumosMotivoTO invConsumosMotivoTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            ///// CREANDO Suceso
            susClave = invConsumosMotivoTO.getCmDetalle();
            if (accion == 'I') {
                susDetalle = "Se insertó el ConsumosMotivo con el detalle " + invConsumosMotivoTO.getCmDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó el ConsumosMotivo con el detalle " + invConsumosMotivoTO.getCmDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó el ConsumosMotivo con el detalle " + invConsumosMotivoTO.getCmDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_consumos_motivo";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO CarPagosForma
            inventario.entity.InvConsumosMotivo invConsumosMotivo = inventario.helper.ConversionesInventario.convertirInvConsumosMotivoTO_InvConsumosMotivo(invConsumosMotivoTO);
            comprobar = false;

            if (accion == 'E') {
                ////// BUSCANDO existencia PagosForma
                if (operacionesInventarioDAOLocal.comprobarInvConsumosMotivo(
                        invConsumosMotivoTO.getUsrEmpresa(),
                        invConsumosMotivoTO.getCmCodigo())) {
                    invConsumosMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvConsumosMotivo(invConsumosMotivo, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el ConsumosMotivo...";
                }
            } else {
                if (accion == 'I') {
                    if (!operacionesInventarioDAOLocal.comprobarInvConsumosMotivo(
                            invConsumosMotivoTO.getUsrEmpresa(),
                            invConsumosMotivoTO.getCmCodigo())) {
                        invConsumosMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvConsumosMotivo(invConsumosMotivo, sisSuceso, accion);
                    } else {
                        mensaje = "FSe encuentra creado el ConsumosMotivo...";
                    }
                }
                if (accion == 'M') {
                    if (operacionesInventarioDAOLocal.comprobarInvConsumosMotivo(
                            invConsumosMotivoTO.getUsrEmpresa(),
                            invConsumosMotivoTO.getCmCodigo())) {
                        invConsumosMotivo.setUsrFechaInserta(operacionesInventarioDAOLocal.buscarInvConsumosMotivo(
                                invConsumosMotivoTO.getUsrEmpresa(),
                                invConsumosMotivoTO.getCmCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvConsumosMotivo(invConsumosMotivo, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra creado el ConsumosMotivo...";
                    }
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente la ConsumosMotivo";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la ConsumosMotivo";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la ConsumosMotivo";
                }
            }

        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la forma pago, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvConsumosMotivo",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="COMPRASFORMAPAGO">
    public List<inventario.TO.InvListaComprasFormaPagoTO> getInvListaComprasFormaPagoTO(java.lang.String empresa) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvListaComprasFormaPagoTO(empresa);
    }

    public String accionInvComprasPagosForma(inventario.TO.InvComprasFormaPagoTO invComprasFormaPagoTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        Boolean estadoCtaComprasForma = false;
        Boolean estadoSector = false;
        try {
            ///// BUSCANDO existencia cuentas
            estadoCtaComprasForma = operacionesContabilidadDAOLocal.buscarCuentas(
                    invComprasFormaPagoTO.getUsrEmpresa(),
                    invComprasFormaPagoTO.getCtaCodigo()) != null ? true : false;
            ///// BUSCANDO existencia sector
            estadoSector = operacionesProduccionDAOLocal.buscarSector(
                    invComprasFormaPagoTO.getUsrEmpresa(),
                    invComprasFormaPagoTO.getSecCodigo()) != null ? true : false;
            if (estadoCtaComprasForma && estadoSector) {//revisar si estan llenos
                ///// CREANDO Suceso
                susClave = invComprasFormaPagoTO.getFpDetalle();
                if (accion == 'I') {
                    susDetalle = "Se insertó la compra FormaPago con el detalle " + invComprasFormaPagoTO.getFpDetalle();
                    susSuceso = "INSERT";
                }
                if (accion == 'M') {
                    susDetalle = "Se modificó la compra FormaPago con el detalle " + invComprasFormaPagoTO.getFpDetalle();
                    susSuceso = "UPDATE";
                }
                if (accion == 'E') {
                    susDetalle = "Se eliminó la compra FormaPago con el detalle " + invComprasFormaPagoTO.getFpDetalle();
                    susSuceso = "DELETE";
                }
                susTabla = "inventario.invComprasFormaPag";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                ///// CREANDO CarPagosForma
                invComprasFormaPagoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                inventario.entity.InvComprasFormaPago invComprasFormaPago = inventario.helper.ConversionesInventario.convertirInvComprasFormaPagoTO_InvComprasFormaPago(invComprasFormaPagoTO);

                if (accion == 'E') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesInventarioDAOLocal.buscarComprasFormaPago(
                            invComprasFormaPagoTO.getFpSecuencial()) != null) {
                        invComprasFormaPago.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvComprasFormaPago(invComprasFormaPago, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra forma de pago...";
                    }
                }
                if (accion == 'M') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesInventarioDAOLocal.buscarComprasFormaPago(
                            invComprasFormaPagoTO.getFpSecuencial()) != null) {
                        invComprasFormaPago.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarComprasFormaPago(
                                invComprasFormaPagoTO.getFpSecuencial()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvComprasFormaPago(invComprasFormaPago, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra forma de pago...";
                    }
                }
                if (accion == 'I') {
                    ////// BUSCANDO existencia PagosForma
                    if (!operacionesInventarioDAOLocal.buscarInvComprasFormaPago(
                            invComprasFormaPagoTO.getCtaCodigo(),
                            invComprasFormaPagoTO.getUsrEmpresa())) {
                        invComprasFormaPago.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvComprasFormaPago(invComprasFormaPago, sisSuceso, accion);
                    } else {
                        mensaje = "FYa existe la compra forma de pago...";
                    }
                }
            } else {
                if (!estadoCtaComprasForma) {
                    mensaje = "FNo se encuentra la cuenta contable forma de pago...";
                }
                if (!estadoSector) {
                    mensaje = "FNo se encuentra el sector...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente la compra Pagos Forma";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la compra Pagos Forma";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la compra Pagos Forma";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la compra forma pago, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvComprasPagosForma",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VENTASFORMAPAGO">
    public List<inventario.TO.InvListaVentasFormaPagoTO> getInvListaVentasFormaPagoTO(java.lang.String empresa) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvListaVentasFormaPagoTO(empresa);
    }

    public String accionInvVentasPagosForma(inventario.TO.InvVentasFormaPagoTO invVentasFormaPagoTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        Boolean estadoCtaVentasForma = false;
        Boolean estadoSector = false;
        try {
            ///// BUSCANDO existencia cuentas
            estadoCtaVentasForma = operacionesContabilidadDAOLocal.buscarCuentas(
                    invVentasFormaPagoTO.getUsrEmpresa(),
                    invVentasFormaPagoTO.getCtaCodigo()) != null ? true : false;
            ///// BUSCANDO existencia sector
            estadoSector = operacionesProduccionDAOLocal.buscarSector(
                    invVentasFormaPagoTO.getUsrEmpresa(),
                    invVentasFormaPagoTO.getSecCodigo()) != null ? true : false;
            if (estadoCtaVentasForma && estadoSector) {//revisar si estan llenos
                ///// CREANDO Suceso
                susClave = invVentasFormaPagoTO.getFpDetalle();
                if (accion == 'I') {
                    susDetalle = "Se insertó la Venta FormaPago con el detalle " + invVentasFormaPagoTO.getFpDetalle();
                    susSuceso = "INSERT";
                }
                if (accion == 'M') {
                    susDetalle = "Se modificó la Venta FormaPago con el detalle " + invVentasFormaPagoTO.getFpDetalle();
                    susSuceso = "UPDATE";
                }
                if (accion == 'E') {
                    susDetalle = "Se eliminó la Venta FormaPago con el detalle " + invVentasFormaPagoTO.getFpDetalle();
                    susSuceso = "DELETE";
                }
                susTabla = "inventario.invVentasFormaPago";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                ///// CREANDO CarPagosForma
                invVentasFormaPagoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                inventario.entity.InvVentasFormaPago invVentasFormaPago = inventario.helper.ConversionesInventario.convertirInvVentasFormaPagoTO_InvVentasFormaPago(invVentasFormaPagoTO);

                if (accion == 'E') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesInventarioDAOLocal.buscarVentasFormaPago(
                            invVentasFormaPagoTO.getFpSecuencial()) != null) {
                        invVentasFormaPago.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvVentasFormaPago(invVentasFormaPago, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la Venta forma de pago...";
                    }
                }
                if (accion == 'M') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesInventarioDAOLocal.buscarVentasFormaPago(
                            invVentasFormaPagoTO.getFpSecuencial()) != null) {
                        invVentasFormaPago.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarVentasFormaPago(
                                invVentasFormaPagoTO.getFpSecuencial()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvVentasFormaPago(invVentasFormaPago, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la Venta forma de pago...";
                    }
                }
                if (accion == 'I') {
                    ////// BUSCANDO existencia PagosForma
                    if (!operacionesInventarioDAOLocal.buscarInvVentasFormaPago(
                            invVentasFormaPagoTO.getCtaCodigo(),
                            invVentasFormaPagoTO.getUsrEmpresa())) {
                        invVentasFormaPago.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvVentasFormaPago(invVentasFormaPago, sisSuceso, accion);
                    } else {
                        mensaje = "FYa existe la Venta forma de pago...";
                    }
                }
            } else {
                if (!estadoCtaVentasForma) {
                    mensaje = "FNo se encuentra la cuenta contable forma de pago...";
                }
                if (!estadoSector) {
                    mensaje = "FNo se encuentra el sector...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente la Venta Pagos Forma";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la Venta Pagos Forma";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la Venta Pagos Forma";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la Venta forma pago, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvVentasPagosForma",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }// </editor-fold>

    public inventario.TO.InvComprasMotivoTO getInvComprasMotivoTO(String empresa, inventario.TO.InvCompraMotivoTablaTO invCompraMotivoTablaTO) throws Exception {
        return operacionesInventarioDAOLocal.getInvComprasMotivoTO(empresa, invCompraMotivoTablaTO);
    }

    public List<inventario.TO.InvCompraMotivoTablaTO> getListaInvComprasMotivoTablaTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvComprasMotivoTablaTO(empresa);
    }

    public String insertarInvComprasMotivoTO(inventario.TO.InvComprasMotivoTO invComprasMotivoTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            if (operacionesInventarioDAOLocal.getInvComprasMotivo(invComprasMotivoTO.getCmEmpresa(),
                    invComprasMotivoTO.getCmCodigo()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = invComprasMotivoTO.getTipCodigo();
                susDetalle = "Se insertó el motivo de compra: " + invComprasMotivoTO.getCmDetalle() + " con código " + invComprasMotivoTO.getCmCodigo();
                susSuceso = "INSERT";
                susTabla = "inventario.inv_compras_motivo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invComprasMotivoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());

                inventario.entity.InvComprasMotivo invComprasMotivo = inventario.helper.ConversionesInventario.convertirInvComprasMotivoTO_InvComprasMotivo(invComprasMotivoTO);

                if (operacionesInventarioDAOTransaccionLocal.insertarInvComprasMotivo(invComprasMotivo, sisSuceso)) {
                    retorno = "TEl motivo de compra se guardo correctamente...";
                } else {
                    retorno = "FHubo un error al guardar el motivo de compra...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl motivo de compra que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvComprasMotivoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarInvComprasMotivoTO(inventario.TO.InvComprasMotivoTO invComprasMotivoTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        inventario.entity.InvComprasMotivo invComprasMotivoAux = operacionesInventarioDAOLocal.getInvComprasMotivo(invComprasMotivoTO.getCmEmpresa(),
                invComprasMotivoTO.getCmCodigo());
        try {
            if (invComprasMotivoAux != null) {
                // PREPARANDO OBJETO SISSUCESO
                susClave = invComprasMotivoTO.getTipCodigo();
                susDetalle = "Se modificó el motivo de compra: " + invComprasMotivoTO.getCmDetalle() + " con código " + invComprasMotivoTO.getCmCodigo();
                susSuceso = "UPDATE";
                susTabla = "inventario.inv_compras_motivo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invComprasMotivoTO.setUsrCodigo(invComprasMotivoAux.getUsrCodigo());
                invComprasMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(invComprasMotivoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));

                inventario.entity.InvComprasMotivo invComprasMotivo = inventario.helper.ConversionesInventario.convertirInvComprasMotivoTO_InvComprasMotivo(invComprasMotivoTO);

                if (operacionesInventarioDAOTransaccionLocal.modificarInvComprasMotivo(invComprasMotivo, sisSuceso)) {
                    retorno = "TEl motivo de compra se modificó correctamente...";
                } else {
                    retorno = "FHubo un error al modificar el motivo de compra...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl motivo de compra que va a modificar ya no existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvComprasMotivoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public inventario.TO.InvVentaMotivoTO getInvVentasMotivoTO(String empresa, inventario.TO.InvVentaMotivoTablaTO invVentaMotivoTablaTO) throws Exception {
        return operacionesInventarioDAOLocal.getInvVentasMotivoTO(empresa, invVentaMotivoTablaTO);
    }

    public List<inventario.TO.InvVentaMotivoTablaTO> getListaInvVentasMotivoTablaTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvVentasMotivoTablaTO(empresa);
    }

    public String insertarInvVentasMotivoTO(inventario.TO.InvVentaMotivoTO invVentaMotivoTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            if (operacionesInventarioDAOLocal.getInvVentasMotivo(invVentaMotivoTO.getVmEmpresa(),
                    invVentaMotivoTO.getVmCodigo()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = invVentaMotivoTO.getTipCodigo();
                susDetalle = "Se insertó el motivo de venta: " + invVentaMotivoTO.getVmDetalle() + " con código " + invVentaMotivoTO.getVmCodigo();
                susSuceso = "INSERT";
                susTabla = "inventario.inv_ventas_motivo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invVentaMotivoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());

                inventario.entity.InvVentasMotivo invVentasMotivo = inventario.helper.ConversionesInventario.convertirInvVentasMotivoTO_InvVentasMotivo(invVentaMotivoTO);

                if (operacionesInventarioDAOTransaccionLocal.insertarInvVentasMotivo(invVentasMotivo, sisSuceso)) {
                    retorno = "TEl motivo de venta se guardo correctamente...";
                } else {
                    retorno = "FHubo un error al guardar el motivo de venta...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl motivo de venta que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvVentasMotivoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarInvVentasMotivoTO(inventario.TO.InvVentaMotivoTO invVentaMotivoTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        inventario.entity.InvVentasMotivo invVentasMotivoAux = operacionesInventarioDAOLocal.getInvVentasMotivo(invVentaMotivoTO.getVmEmpresa(),
                invVentaMotivoTO.getVmCodigo());
        try {
            if (invVentasMotivoAux != null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = invVentaMotivoTO.getTipCodigo();
                susDetalle = "Se modificó el motivo de venta: " + invVentaMotivoTO.getVmDetalle() + " con código " + invVentaMotivoTO.getVmCodigo();
                susSuceso = "UPDATE";
                susTabla = "inventario.inv_ventas_motivo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invVentaMotivoTO.setUsrCodigo(invVentasMotivoAux.getUsrCodigo());
                invVentaMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(invVentasMotivoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));

                inventario.entity.InvVentasMotivo invVentasMotivo = inventario.helper.ConversionesInventario.convertirInvVentasMotivoTO_InvVentasMotivo(invVentaMotivoTO);

                if (operacionesInventarioDAOTransaccionLocal.modificarInvVentasMotivo(invVentasMotivo, sisSuceso)) {
                    retorno = "TEl motivo de venta se modificó correctamente...";
                } else {
                    retorno = "FHubo un error al modificar el motivo de venta...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl motivo de venta que va a modificar ya no existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvVentasMotivoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public inventario.TO.InvProformaMotivoTO getInvProformasMotivoTO(String empresa, inventario.TO.InvProformaMotivoTablaTO invProformaMotivoTablaTO) throws Exception {
        return operacionesInventarioDAOLocal.getInvProformasMotivoTO(empresa, invProformaMotivoTablaTO);
    }

    public List<inventario.TO.InvProformaMotivoTablaTO> getListaInvProformaMotivoTablaTO(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvProformaMotivoTablaTO(empresa);
    }

    public String insertarInvProformaMotivoTO(inventario.TO.InvProformaMotivoTO invProformaMotivoTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            if (operacionesInventarioDAOLocal.getInvProformasMotivo(invProformaMotivoTO.getpmEmpresa(),
                    invProformaMotivoTO.getpmCodigo()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = invProformaMotivoTO.getpmCodigo();
                susDetalle = "Se insertó el motivo de proforma: " + invProformaMotivoTO.getpmDetalle();
                susSuceso = "INSERT";
                susTabla = "inventario.inv_proformas_motivo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invProformaMotivoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());

                inventario.entity.InvProformasMotivo invProformasMotivo = inventario.helper.ConversionesInventario.convertirInvProformasMotivoTO_InvProformasMotivo(invProformaMotivoTO);

                if (operacionesInventarioDAOTransaccionLocal.insertarInvProformaMotivo(invProformasMotivo, sisSuceso)) {
                    retorno = "TEl motivo de proforma se guardo correctamente...";
                } else {
                    retorno = "FHubo un error al guardar el motivo de proforma...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl motivo de proforma que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvProformaMotivoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarInvProformaMotivoTO(inventario.TO.InvProformaMotivoTO invProformaMotivoTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        inventario.entity.InvProformasMotivo invProformasMotivoAux = operacionesInventarioDAOLocal.getInvProformasMotivo(invProformaMotivoTO.getpmEmpresa(),
                invProformaMotivoTO.getpmCodigo());
        try {
            if (invProformasMotivoAux != null) {
                susClave = invProformaMotivoTO.getpmCodigo();
                susDetalle = "Se modificó el motivo de proforma: " + invProformaMotivoTO.getpmDetalle();
                susSuceso = "UPDATE";
                susTabla = "inventario.inv_proformas_motivo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                invProformaMotivoTO.setUsrCodigo(invProformasMotivoAux.getUsrCodigo());
                invProformaMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(invProformasMotivoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));

                inventario.entity.InvProformasMotivo invProformasMotivo = inventario.helper.ConversionesInventario.convertirInvProformasMotivoTO_InvProformasMotivo(invProformaMotivoTO);

                if (operacionesInventarioDAOTransaccionLocal.modificarInvProformaMotivo(invProformasMotivo, sisSuceso)) {
                    retorno = "TEl motivo de proforma se modificó correctamente...";
                } else {
                    retorno = "Hubo un error al modificar el motivo de la proforma...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl motivo de proforma que va a modificar ya no existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvProformasMotivoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public inventario.TO.InvConsumosMotivoTO getInvConsumoMotivoTO(String empresa, inventario.TO.InvListaConsumosMotivoTO invListaConsumosMotivoTO) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvConsumosMotivoTO(empresa, invListaConsumosMotivoTO);
    }

    public List<inventario.TO.InvNumeracionCompraTO> getListaInvNumeracionCompraTO(String empresa, String periodo, String motivo) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvNumeracionCompraTO(empresa, periodo, motivo);
    }

    public List<inventario.TO.InvNumeracionVentaTO> getListaInvNumeracionVentaTO(String empresa, String periodo, String motivo) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvNumeracionVentaTO(empresa, periodo, motivo);
    }

    public List<inventario.TO.InvNumeracionConsumoTO> getListaInvNumeracionConsumoTO(String empresa, String periodo, String motivo) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvNumeracionConsumoTO(empresa, periodo, motivo);
    }

    public inventario.entity.InvProductoSaldos getInvProductoSaldo(String empresa, String codigoBodega, String codigoProducto) throws Exception {
        return operacionesInventarioDAOLocal.getInvProductoSaldo(empresa, codigoBodega, codigoProducto);
    }

    public List<inventario.TO.InvKardexTO> getListaInvKardexTO(java.lang.String empresa, java.lang.String bodega, java.lang.String producto, java.lang.String desde, java.lang.String hasta, java.lang.String promedio) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getListaInvKardexTO(empresa, bodega, producto, desde, hasta, promedio);
    }

    public List<inventario.TO.SaldoBodegaTO> getListaSaldoBodegaTO(
            java.lang.String empresa, 
            java.lang.String bodega, 
            java.lang.String hasta,
            java.lang.String categoria,
            boolean resumido) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getListaSaldoBodegaTO(
                empresa, 
                bodega, 
                hasta,
                categoria,
                resumido);
    }

    public inventario.TO.InvComprasRecepcionTO getInvComprasRecepcionTO(String empresa, String periodo, String motivo, String numero) throws Exception {
        return operacionesInventarioDAOLocal.getInvComprasRecepcionTO(empresa, periodo, motivo, numero);
    }

    public String insertarModificarComprasRecepcionTO(inventario.TO.InvComprasRecepcionTO invComprasRecepcionTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        boolean periodoCerrado = false;
        try {
            if (!validaciones.Validacion.isFechaSuperior(invComprasRecepcionTO.getRecepFecha(), "yyyy-MM-dd")) {
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invComprasRecepcionTO.getCompEmpresa());
                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (validaciones.Validacion.fecha(invComprasRecepcionTO.getRecepFecha(), "yyyy-MM-dd").getTime()
                            >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && validaciones.Validacion.fecha(invComprasRecepcionTO.getRecepFecha(), "yyyy-MM-dd").getTime()
                            <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                        periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                    }
                }

                if (!periodoCerrado) {
                    inventario.entity.InvCompras invCompras = operacionesInventarioDAOLocal.buscarInvCompras(invComprasRecepcionTO.getCompEmpresa(), invComprasRecepcionTO.getCompPeriodo(),
                            invComprasRecepcionTO.getCompMotivo(), invComprasRecepcionTO.getCompNumero());
                    if (invCompras != null && !invCompras.getCompAnulado() && !invCompras.getCompPendiente()) {
                        String mensajeAux1 = "";
                        String mensajeAux2 = "";
                        inventario.TO.InvComprasRecepcionTO invComprasRecepcionTOAux = operacionesInventarioDAOLocal.getInvComprasRecepcionTO(invComprasRecepcionTO.getRecepEmpresa(), invComprasRecepcionTO.getRecepPeriodo(),
                                invComprasRecepcionTO.getRecepMotivo(), invComprasRecepcionTO.getRecepNumero());
                        if (invComprasRecepcionTOAux != null) {
                            mensajeAux1 = "modificó";
                            mensajeAux2 = "UPDATE";
                        } else {
                            mensajeAux1 = "ingresó";
                            mensajeAux2 = "INSERT";
                        }
                        /// PREPARANDO OBJETO SISSUCESO
                        susClave = invComprasRecepcionTO.getRecepFecha();
                        susDetalle = "Se " + mensajeAux1 + " la compra recepcion: " + invComprasRecepcionTO.getRecepEmpresa() + " | " + invComprasRecepcionTO.getRecepMotivo() + " | " + invComprasRecepcionTO.getRecepNumero();
                        susSuceso = mensajeAux2;
                        susTabla = "inventar.inv_compras_recepcion";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                        if (invComprasRecepcionTOAux != null) {
                            invComprasRecepcionTO.setUsrCodigo(invComprasRecepcionTOAux.getUsrCodigo());
                            invComprasRecepcionTO.setUsrFechaInserta(validaciones.Validacion.convertirAaaaMmDdTODdMmAaaa(invComprasRecepcionTOAux.getUsrFechaInserta()));
                        }

                        inventario.entity.InvComprasRecepcion invComprasRecepcion = inventario.helper.ConversionesInventario.convertirInvComprasRecepcion_InvComprasRecepcionTO(invComprasRecepcionTO);
                        invComprasRecepcion.setInvCompras(invCompras);
                        if (operacionesInventarioDAOTransaccionLocal.insertarModificarinvComprasRecepcion(invComprasRecepcion, sisSuceso)) {
                            retorno = "TEl dato ha sido guardado correctamente...";
                        } else {
                            retorno = "FHubo un error al guardar la información...\nIntente de nuevo o contacte con el administrador";
                        }
                    } else {
                        retorno = "FNo se pudo obtener la relación con la Compra, puede que este:\n - Anulada.\n - Pendiente.\n - No existe.\n\nIntente de nuevo o contacte con el administrador";
                    }
                } else {

                    retorno = "F<html>No se puede cambiar la fecha de recepción de la compra debido a que el período se encuentra cerrado...</html>";
                }
            } else {
                retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
            }
        } catch (Exception e) {
            retorno = "FHubo un error al guardar la información...\nIntente de nuevo o contacte con el administrador";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarModificarComprasRecepcionTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public List<inventario.TO.InvProductosConErrorTO> getListadoProductosConError(String empresa) throws Exception {
        return operacionesInventarioDAOLocal.getListadoProductosConError(empresa);
    }

    public inventario.TO.MensajeTO insertarInvTransferenciaTO(inventario.TO.InvTransferenciasTO invTransferenciasTO,
            List<inventario.TO.InvTransferenciasDetalleTO> listaInvTransferenciasDetalleTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        inventario.entity.InvProductoSaldos invProductoSaldosOrigen = null;
        inventario.entity.InvProductoSaldos invProductoSaldosDestino = null;
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        List<String> mensajeClase = new ArrayList(1);
        List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosOrigen = new ArrayList(1);
        List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosDestino = new ArrayList(1);
        boolean periodoCerrado = false;
        try {
            if (!validaciones.Validacion.isFechaSuperior(invTransferenciasTO.getTransFecha(), "yyyy-MM-dd")) {
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invTransferenciasTO.getTransEmpresa());
                comprobar = false;
                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (validaciones.Validacion.fecha(invTransferenciasTO.getTransFecha(), "yyyy-MM-dd").getTime()
                            >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && validaciones.Validacion.fecha(invTransferenciasTO.getTransFecha(), "yyyy-MM-dd").getTime()
                            <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                        comprobar = true;
                        invTransferenciasTO.setTransPeriodo(sisListaPeriodoTO.getPerCodigo());
                        periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                    }
                }

                if (comprobar) {
                    if (!periodoCerrado) {
                        if (operacionesInventarioDAOLocal.comprobarInvTransferenciasMotivo(invTransferenciasTO.getTransEmpresa(), invTransferenciasTO.getTransMotivo())) {

                            susSuceso = "INSERT";
                            susTabla = "inventario.inv_transferencias";
                            invTransferenciasTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                            ////// CREANDO NUMERACION DE TRANSFERENCIAS
                            inventario.entity.InvTransferenciasNumeracion invTransferenciasNumeracion = new inventario.entity.InvTransferenciasNumeracion(new inventario.entity.InvTransferenciasNumeracionPK(invTransferenciasTO.getTransEmpresa(), invTransferenciasTO.getTransPeriodo(),
                                    invTransferenciasTO.getTransMotivo()));
                            ////// CREANDO TRANSFERENCIAS
                            inventario.entity.InvTransferencias invTransferencias = inventario.helper.ConversionesInventario.convertirInvTransferenciasTO_InvTransferencias(invTransferenciasTO);
                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                            List<inventario.entity.InvTransferenciasDetalle> listInvTransferenciasDetalle = new ArrayList(0);
                            inventario.entity.InvTransferenciasDetalle invTransferenciasDetalle = null;

                            int estadoDetalle = 0;
                            for (inventario.TO.InvTransferenciasDetalleTO invTransferenciasDetalleTO : listaInvTransferenciasDetalleTO) {
                                invTransferenciasDetalle = new inventario.entity.InvTransferenciasDetalle();
                                invTransferenciasDetalle = inventario.helper.ConversionesInventario.convertirInvTransferenciasDetalleTO_InvTransferenciasDetalle(invTransferenciasDetalleTO);
                                ///// BUSCANDO EL PRODUCTO EN DETALLE
                                inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invTransferenciasDetalleTO.getTransEmpresa(),
                                        invTransferenciasDetalleTO.getProCodigoPrincipal());
                                if (invProducto != null) {
                                    invTransferenciasDetalle.setInvProducto(invProducto);
                                    ////// BUSCANDO LA BODEGA EN EL DETALLE ORIGEN
                                    inventario.entity.InvBodega invBodegaOrigen = operacionesInventarioDAOLocal.buscarInvBodega(invTransferenciasDetalleTO.getTransEmpresa(),
                                            invTransferenciasDetalleTO.getBodOrigenCodigo());
                                    ////// BUSCANDO LA BODEGA EN EL DETALLE DESTINO
                                    inventario.entity.InvBodega invBodegaDestino = operacionesInventarioDAOLocal.buscarInvBodega(invTransferenciasDetalleTO.getTransEmpresa(),
                                            invTransferenciasDetalleTO.getBodDestinoCodigo());

                                    if (invBodegaOrigen != null && invBodegaDestino != null) {
                                        invTransferenciasDetalle.setInvBodega(invBodegaOrigen);
                                        invTransferenciasDetalle.setInvBodega1(invBodegaDestino);
                                        listInvTransferenciasDetalle.add(invTransferenciasDetalle);
                                    } else {
                                        estadoDetalle = 2;
                                    }
                                } else {
                                    estadoDetalle = 1;
                                }

                                if (estadoDetalle == 1 || estadoDetalle == 2) {
                                    break;
                                } else {
                                    invProducto = null;
                                }
                            }
                            if (estadoDetalle == 0) {
                                if (!invTransferencias.getTransPendiente()) {
                                    List<inventario.entity.InvTransferenciasDetalle> listadoDetalleTransferencias = agrupraProductosBodegaTransferencia(listInvTransferenciasDetalle);
                                    for (int i = 0; i < listadoDetalleTransferencias.size(); i++) {
                                        if (!listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                            invProductoSaldosOrigen = new inventario.entity.InvProductoSaldos();
                                            invProductoSaldosDestino = new inventario.entity.InvProductoSaldos();
                                            ////CREO LA LLAVE DE ORIGEN
                                            invProductoSaldosOrigen.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invTransferencias.getInvTransferenciasPK().getTransEmpresa(), listadoDetalleTransferencias.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                    listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                            ////CREO LA LLAVE DE DESTINO
                                            invProductoSaldosDestino.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invTransferencias.getInvTransferenciasPK().getTransEmpresa(), listadoDetalleTransferencias.get(i).getInvBodega1().getInvBodegaPK().getBodCodigo(),
                                                    listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                            ////BUSCO LA BODEGA DE ORIGEN
                                            invProductoSaldosOrigen.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invTransferencias.getInvTransferenciasPK().
                                                    getTransEmpresa(), listadoDetalleTransferencias.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                            ////BUSCO LA BODEGA DE DESTINO
                                            invProductoSaldosDestino.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invTransferencias.getInvTransferenciasPK().
                                                    getTransEmpresa(), listadoDetalleTransferencias.get(i).getInvBodega1().getInvBodegaPK().getBodCodigo()));
                                            ////PONGO EL PRODUCTO EN ORIGEN
                                            invProductoSaldosOrigen.setInvProducto(listadoDetalleTransferencias.get(i).getInvProducto());
                                            ////PONGO EL PRODUCTO EN DESTINO
                                            invProductoSaldosDestino.setInvProducto(listadoDetalleTransferencias.get(i).getInvProducto());
                                            ////BUSQUEDA DE LA ENTIDAD ORIGEN
                                            inventario.entity.InvProductoSaldos invProductoSaldosConsultaOrigen = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldosOrigen.getInvProductoSaldosPK().getStkEmpresa(),
                                                    invProductoSaldosOrigen.getInvProductoSaldosPK().getStkBodega(),
                                                    invProductoSaldosOrigen.getInvProductoSaldosPK().getStkProducto());
                                            ////BUSQUEDA DE LA ENTIDAD DESTINO
                                            inventario.entity.InvProductoSaldos invProductoSaldosConsultaDestino = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldosDestino.getInvProductoSaldosPK().getStkEmpresa(),
                                                    invProductoSaldosDestino.getInvProductoSaldosPK().getStkBodega(),
                                                    invProductoSaldosDestino.getInvProductoSaldosPK().getStkProducto());

                                            if (invProductoSaldosConsultaOrigen != null) {
                                                ///COMO SI EXISTE EN LA TABLA SE LE RESTA AL ORIGEN
                                                invProductoSaldosOrigen.setStkSaldoFinal(invProductoSaldosConsultaOrigen.getStkSaldoFinal().
                                                        subtract(listadoDetalleTransferencias.get(i).getDetCantidad()));
                                                ///COMO SI EXISTE EL ORIGEN EN LA TABLA SE LE SUMA AL DESTINO PERO NO SIN ANTES PREGUNTAR SI YA EXISTE EL DESTINO, SINO PARA CREARLO
                                                if (invProductoSaldosConsultaDestino == null) {
                                                    invProductoSaldosDestino.setStkSaldoFinal(listadoDetalleTransferencias.get(i).getDetCantidad());
                                                } else {
                                                    invProductoSaldosDestino.setStkSaldoFinal(invProductoSaldosConsultaDestino.getStkSaldoFinal().
                                                            add(listadoDetalleTransferencias.get(i).getDetCantidad()));
                                                }

                                                if (invProductoSaldosOrigen.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                    invProductoSaldosOrigen.setStkFechaUltimaCompraFinal(invProductoSaldosConsultaOrigen.getStkFechaUltimaCompraFinal());
                                                    invProductoSaldosDestino.setStkFechaUltimaCompraFinal(invTransferencias.getTransFecha());

                                                    invProductoSaldosOrigen.setStkValorUltimaCompraFinal(invProductoSaldosConsultaOrigen.getStkValorUltimaCompraFinal());

                                                    invProductoSaldosOrigen.setStkSaldoInicial(invProductoSaldosConsultaOrigen.getStkSaldoInicial());
                                                    invProductoSaldosOrigen.setStkValorPromedioInicial(invProductoSaldosConsultaOrigen.getStkValorPromedioInicial());
                                                    invProductoSaldosOrigen.setStkValorPromedioFinal(invProductoSaldosConsultaOrigen.getStkValorPromedioFinal());

                                                    invProductoSaldosDestino.setStkValorUltimaCompraFinal(invProductoSaldosConsultaDestino == null
                                                            ? cero : invProductoSaldosConsultaDestino.getStkValorUltimaCompraFinal());

                                                    invProductoSaldosDestino.setStkSaldoInicial(invProductoSaldosConsultaDestino == null ? cero : invProductoSaldosConsultaDestino.getStkSaldoInicial());
                                                    invProductoSaldosDestino.setStkValorPromedioInicial(invProductoSaldosConsultaDestino == null ? cero : invProductoSaldosConsultaDestino.getStkValorPromedioInicial());
                                                    invProductoSaldosDestino.setStkValorPromedioFinal(invProductoSaldosConsultaDestino == null ? cero : invProductoSaldosConsultaDestino.getStkValorPromedioFinal());

                                                    listaInvProductoSaldosOrigen.add(invProductoSaldosOrigen);
                                                    listaInvProductoSaldosDestino.add(invProductoSaldosDestino);
                                                } else {
                                                    retorno = "F<html>No se puede transferir porque no hay stock suficiente en los siguientes productos:</html>";
                                                    mensajeClase.add(listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleTransferencias.get(i).getInvProducto().getProNombre());
                                                }
                                            } else {
                                                retorno = "F<html>No se puede transferir porque no hay stock suficiente en los siguientes productos:</html>";
                                                mensajeClase.add(listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleTransferencias.get(i).getInvProducto().getProNombre());
                                            }
                                        }
                                    }
                                }
                                if (mensajeClase.isEmpty()) {
                                    /// PREPARANDO OBJETO SISSUCESO (susClave y susDetalle se llenan en DAOTransaccion)
                                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                            susTabla,
                                            susClave,
                                            susSuceso,
                                            susDetalle,
                                            sisInfoTO);
                                    comprobar = operacionesInventarioDAOTransaccionLocal.insertarTransaccionInvTransferencias(invTransferencias, listInvTransferenciasDetalle,
                                            sisSuceso, invTransferenciasNumeracion, listaInvProductoSaldosOrigen, listaInvProductoSaldosDestino);
                                    if (comprobar) {
                                        sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(invTransferenciasTO.getTransEmpresa(), invTransferencias.getInvTransferenciasPK().getTransPeriodo());
                                        retorno = "T<html>Se ingresó el consumo con la siguiente información:<br><br>"
                                                + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                + "</font>.<br> Motivo: <font size = 5>" + invTransferencias.getInvTransferenciasPK().
                                                getTransMotivo()
                                                + "</font>.<br> Número: <font size = 5>" + invTransferencias.getInvTransferenciasPK().getTransNumero() + "</font>.</html>"
                                                + invTransferencias.getInvTransferenciasPK().getTransNumero() + ","
                                                + sisPeriodo.getSisPeriodoPK().getPerCodigo();
                                        mensajeTO.setFechaCreacion(invTransferencias.getUsrFechaInserta().toString());
                                    } else {
                                        retorno = "FHubo un error al guardar la Transferencia...\nIntente de nuevo o contacte con el administrador";
                                    }
                                } else {
                                    mensajeTO.setMensaje(retorno);
                                    mensajeTO.setListaErrores(mensajeClase);
                                }
                            } else {
                                if (estadoDetalle == 1) {
                                    retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                } else {
                                    retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                }
                            }
                        }
                    } else {
                        retorno = "F<html>El periodo que corresponde a la fecha que ingresó se encuentra cerrado...</html>";
                    }
                } else {
                    retorno = "FNo se encuentra ningún periodo para la fecha que ingresó...";
                }
            } else {
                retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
            }
        } catch (Exception e) {
            retorno = "FError al guardar datos...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarInvTransferenciaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
//            return retorno;
        }
    }

    public inventario.TO.MensajeTO modificarInvTransferenciasTO(inventario.TO.InvTransferenciasTO invTransferenciasTO,
            List<inventario.TO.InvTransferenciasDetalleTO> listaInvTransferenciasDetalleTO,
            List<inventario.TO.InvTransferenciasDetalleTO> listaInvTransferenciasEliminarDetalleTO,
            boolean desmayorizar, inventario.entity.InvTransferenciasMotivoAnulacion invTransferenciasMotivoAnulacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        List<String> mensajeClase = new ArrayList(1);
        String retorno = "";
        inventario.entity.InvProductoSaldos invProductoSaldosOrigen = null;
        inventario.entity.InvProductoSaldos invProductoSaldosDestino = null;
        List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosOrigen = new ArrayList(1);
        List<inventario.entity.InvProductoSaldos> listaInvProductoSaldosDestino = new ArrayList(1);
        boolean periodoCerrado = false;
        try {
            if (!validaciones.Validacion.isFechaSuperior(invTransferenciasTO.getTransFecha(), "yyyy-MM-dd")) {

                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(invTransferenciasTO.getTransEmpresa());

                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (validaciones.Validacion.fecha(invTransferenciasTO.getTransFecha(), "yyyy-MM-dd").getTime()
                            >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && validaciones.Validacion.fecha(invTransferenciasTO.getTransFecha(), "yyyy-MM-dd").getTime()
                            <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                        comprobar = true;
//                        invVentasTO.setVtaPeriodo(sisListaPeriodoTO.getPerCodigo());
                        periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                    }
                }

                if (comprobar) {
                    if (!periodoCerrado) {
                        if (operacionesInventarioDAOLocal.comprobarInvTransferenciasMotivo(invTransferenciasTO.getTransEmpresa(), invTransferenciasTO.getTransMotivo())) {
                            inventario.entity.InvTransferencias invTransferenciasCreados = operacionesInventarioDAOLocal.buscarInvTransferencias(invTransferenciasTO.getTransEmpresa(), invTransferenciasTO.getTransPeriodo(),
                                    invTransferenciasTO.getTransMotivo(), invTransferenciasTO.getTransNumero());
                            if (invTransferenciasCreados != null) {

                                String detalleError = "";
                                if (desmayorizar && listaInvTransferenciasDetalleTO == null) {
                                    List<inventario.TO.InvListaDetalleTransferenciaTO> invListaDetalleTO = operacionesInventarioDAOLocal.getListaInvTransferenciasDetalleTO(invTransferenciasTO.getTransEmpresa(), invTransferenciasTO.getTransPeriodo(), invTransferenciasTO.getTransMotivo(), invTransferenciasTO.getTransNumero());
                                    if (invListaDetalleTO != null) {
                                        listaInvTransferenciasDetalleTO = new ArrayList();
                                        for (int i = 0; i < invListaDetalleTO.size(); i++) {
                                            inventario.TO.InvTransferenciasDetalleTO invTransferenciasDetalleTO = new inventario.TO.InvTransferenciasDetalleTO();
                                            invTransferenciasDetalleTO.setTransEmpresa(invTransferenciasTO.getTransEmpresa());
                                            invTransferenciasDetalleTO.setTransPeriodo(invTransferenciasTO.getTransPeriodo());
                                            invTransferenciasDetalleTO.setTransMotivo(invTransferenciasTO.getTransMotivo());
                                            invTransferenciasDetalleTO.setTransNumero(invTransferenciasTO.getTransNumero());

                                            invTransferenciasDetalleTO.setDetSecuencial(invListaDetalleTO.get(i).getDetSecuencial());
                                            invTransferenciasDetalleTO.setDetOrden(i + 1);
                                            invTransferenciasDetalleTO.setDetCantidad(invListaDetalleTO.get(i).getDetCantidad());
                                            invTransferenciasDetalleTO.setBodOrigenEmpresa(invTransferenciasTO.getTransEmpresa());
                                            invTransferenciasDetalleTO.setBodOrigenCodigo(invListaDetalleTO.get(i).getBodOrigenCodigo());
                                            invTransferenciasDetalleTO.setBodDestinoEmpresa(invTransferenciasTO.getTransEmpresa());
                                            invTransferenciasDetalleTO.setBodDestinoCodigo(invListaDetalleTO.get(i).getBodDestinoCodigo());
                                            invTransferenciasDetalleTO.setSecOrigenEmpresa(invTransferenciasTO.getTransEmpresa());
                                            invTransferenciasDetalleTO.setSecOrigenCodigo(invListaDetalleTO.get(i).getCpOrigen());
                                            invTransferenciasDetalleTO.setSecDestinoEmpresa(invTransferenciasTO.getTransEmpresa());
                                            invTransferenciasDetalleTO.setSecDestinoCodigo(invListaDetalleTO.get(i).getCpDestino());
                                            invTransferenciasDetalleTO.setProEmpresa(invTransferenciasTO.getTransEmpresa());
                                            invTransferenciasDetalleTO.setProCodigoPrincipal(invListaDetalleTO.get(i).getProCodigoPrincipal());
                                            listaInvTransferenciasDetalleTO.add(invTransferenciasDetalleTO);
                                        }
                                    } else {
                                        detalleError = "Hubo en error al recuperar el detalle de la TRANSFERENCIA.\nContacte con el administrador...";
                                    }
                                }

                                if (detalleError.trim().isEmpty()) {
                                    susClave = invTransferenciasTO.getTransPeriodo() + " "
                                            + invTransferenciasTO.getTransMotivo() + " " + invTransferenciasTO.getTransNumero();


                                    susDetalle = invTransferenciasTO.getTransAnulado() ? "Transferencia número " + invTransferenciasTO.getTransNumero()
                                            + " se anuló por " + invTransferenciasMotivoAnulacion.getAnuComentario() : "Se modificó la transferencia en el periodo "
                                            + invTransferenciasTO.getTransPeriodo() + ", del motivo "
                                            + invTransferenciasTO.getTransMotivo() + ", de la numeración "
                                            + invTransferenciasTO.getTransNumero();
                                    susSuceso = "UPDATE";
                                    susTabla = "inventario.inv_transferencias";
                                    invTransferenciasTO.setUsrCodigo(invTransferenciasCreados.getUsrCodigo());
                                    invTransferenciasTO.setUsrFechaInserta(validaciones.Validacion.fecha(invTransferenciasCreados.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                                    ////// CREANDO NUMERACION DE CONSUMO
                                    inventario.entity.InvTransferenciasNumeracion invTransferenciasNumeracion = new inventario.entity.InvTransferenciasNumeracion(new inventario.entity.InvTransferenciasNumeracionPK(invTransferenciasTO.getTransEmpresa(), invTransferenciasTO.getTransPeriodo(),
                                            invTransferenciasTO.getTransMotivo()));
                                    ////// CREANDO CONSUMOS
                                    inventario.entity.InvTransferencias invTransferencias = inventario.helper.ConversionesInventario.convertirInvTransferenciasTO_InvTransferencias(invTransferenciasTO);
                                    ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                    List<inventario.entity.InvTransferenciasDetalle> listInvTransferenciasDetalle = new ArrayList(0);
                                    inventario.entity.InvTransferenciasDetalle invTransferenciasDetalle = null;

                                    int estadoDetalle = 0;
                                    for (inventario.TO.InvTransferenciasDetalleTO invTransferenciasDetalleTO : listaInvTransferenciasDetalleTO) {
                                        invTransferenciasDetalle = new inventario.entity.InvTransferenciasDetalle();
                                        invTransferenciasDetalle = inventario.helper.ConversionesInventario.convertirInvTransferenciasDetalleTO_InvTransferenciasDetalle(invTransferenciasDetalleTO);

                                        ///// BUSCANDO EL PRODUCTO EN DETALLE
                                        inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invTransferenciasDetalleTO.getTransEmpresa(),
                                                invTransferenciasDetalleTO.getProCodigoPrincipal());
                                        if (invProducto != null) {
                                            invTransferenciasDetalle.setInvProducto(invProducto);
                                            ////// BUSCANDO LA BODEGA EN EL DETALLE ORIGEN
                                            inventario.entity.InvBodega invBodegaOrigen = operacionesInventarioDAOLocal.buscarInvBodega(invTransferenciasDetalleTO.getTransEmpresa(),
                                                    invTransferenciasDetalleTO.getBodOrigenCodigo());
                                            ////// BUSCANDO LA BODEGA EN EL DETALLE DESTINO
                                            inventario.entity.InvBodega invBodegaDestino = operacionesInventarioDAOLocal.buscarInvBodega(invTransferenciasDetalleTO.getTransEmpresa(),
                                                    invTransferenciasDetalleTO.getBodDestinoCodigo());
                                            if (invBodegaOrigen != null && invBodegaDestino != null) {
                                                invTransferenciasDetalle.setInvBodega(invBodegaOrigen);
                                                invTransferenciasDetalle.setInvBodega1(invBodegaDestino);
                                                listInvTransferenciasDetalle.add(invTransferenciasDetalle);
                                            } else {
                                                estadoDetalle = 2;
                                            }
                                        } else {
                                            estadoDetalle = 1;
                                        }

                                        if (estadoDetalle == 1 || estadoDetalle == 2) {
                                            break;
                                        } else {
                                            invProducto = null;
                                        }
                                    }
                                    if (estadoDetalle == 0) {
                                        ////// CONVIRTIENDO A ENTIDAD EL DETALLE A ELIMINAR
                                        List<inventario.entity.InvTransferenciasDetalle> listInvTransferenciasDetalleEliminar = new ArrayList(0);
                                        inventario.entity.InvTransferenciasDetalle invTransferenciasDetalleEliminar = null;

                                        int estadoDetalleEliminar = 0;
                                        if (listaInvTransferenciasEliminarDetalleTO != null) {
                                            for (inventario.TO.InvTransferenciasDetalleTO invTransferenciasEliminarDetalleTO : listaInvTransferenciasEliminarDetalleTO) {
                                                invTransferenciasDetalleEliminar = new inventario.entity.InvTransferenciasDetalle();
                                                invTransferenciasEliminarDetalleTO.setTransPeriodo(invTransferenciasTO.getTransPeriodo());
                                                invTransferenciasDetalleEliminar = inventario.helper.ConversionesInventario.convertirInvTransferenciasDetalleTO_InvTransferenciasDetalle(invTransferenciasEliminarDetalleTO);
                                                invTransferenciasDetalleEliminar.setInvTransferencias(invTransferencias);
                                                ///// BUSCANDO EL PRODUCTO EN DETALLE
                                                inventario.entity.InvProducto invProducto = operacionesInventarioDAOLocal.buscarInvProducto(invTransferenciasEliminarDetalleTO.getTransEmpresa(), invTransferenciasEliminarDetalleTO.getProCodigoPrincipal());
                                                if (invProducto != null) {
                                                    invTransferenciasDetalleEliminar.setInvProducto(invProducto);
                                                    ////// BUSCANDO LA BODEGA EN EL DETALLE ORIGEN
                                                    inventario.entity.InvBodega invBodegaOrigen = operacionesInventarioDAOLocal.buscarInvBodega(invTransferenciasEliminarDetalleTO.getTransEmpresa(),
                                                            invTransferenciasEliminarDetalleTO.getBodOrigenCodigo());
                                                    ////// BUSCANDO LA BODEGA EN EL DETALLE DESTINO
                                                    inventario.entity.InvBodega invBodegaDestino = operacionesInventarioDAOLocal.buscarInvBodega(invTransferenciasEliminarDetalleTO.getTransEmpresa(),
                                                            invTransferenciasEliminarDetalleTO.getBodDestinoCodigo());

                                                    if (invBodegaOrigen != null && invBodegaDestino != null) {
                                                        invTransferenciasDetalleEliminar.setInvBodega1(invBodegaOrigen);
                                                        invTransferenciasDetalleEliminar.setInvBodega(invBodegaDestino);
                                                        listInvTransferenciasDetalleEliminar.add(invTransferenciasDetalleEliminar);
                                                    } else {
                                                        estadoDetalle = 2;
                                                    }
                                                } else {
                                                    estadoDetalleEliminar = 1;
                                                }

                                                if (estadoDetalleEliminar == 1 || estadoDetalleEliminar == 2) {
                                                    break;
                                                } else {
                                                    invProducto = null;
                                                }
                                            }
                                        }
                                        if (estadoDetalleEliminar == 0) {

                                            if (!invTransferencias.getTransPendiente() || desmayorizar) {
                                                List<inventario.entity.InvTransferenciasDetalle> listadoDetalleTransferencias = agrupraProductosBodegaTransferencia(listInvTransferenciasDetalle);
                                                for (int i = 0; i < listadoDetalleTransferencias.size(); i++) {
                                                    if (!listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoTipo().getTipTipo().equals("COSTO O GASTO")) {
                                                        invProductoSaldosOrigen = new inventario.entity.InvProductoSaldos();
                                                        invProductoSaldosDestino = new inventario.entity.InvProductoSaldos();
                                                        ////CREO LA LLAVE DE ORIGEN
                                                        invProductoSaldosOrigen.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invTransferencias.getInvTransferenciasPK().getTransEmpresa(), listadoDetalleTransferencias.get(i).getInvBodega().getInvBodegaPK().getBodCodigo(),
                                                                listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                        ////CREO LA LLAVE DE DESTINO
                                                        invProductoSaldosDestino.setInvProductoSaldosPK(new inventario.entity.InvProductoSaldosPK(invTransferencias.getInvTransferenciasPK().getTransEmpresa(), listadoDetalleTransferencias.get(i).getInvBodega1().getInvBodegaPK().getBodCodigo(),
                                                                listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal()));
                                                        ////BUSCO LA BODEGA DE ORIGEN
                                                        invProductoSaldosOrigen.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invTransferencias.getInvTransferenciasPK().
                                                                getTransEmpresa(), listadoDetalleTransferencias.get(i).getInvBodega().getInvBodegaPK().getBodCodigo()));
                                                        ////BUSCO LA BODEGA DE DESTINO
                                                        invProductoSaldosDestino.setInvBodega(operacionesInventarioDAOLocal.buscarInvBodega(invTransferencias.getInvTransferenciasPK().
                                                                getTransEmpresa(), listadoDetalleTransferencias.get(i).getInvBodega1().getInvBodegaPK().getBodCodigo()));
                                                        ////PONGO EL PRODUCTO EN ORIGEN
                                                        invProductoSaldosOrigen.setInvProducto(listadoDetalleTransferencias.get(i).getInvProducto());
                                                        ////PONGO EL PRODUCTO EN DESTINO
                                                        invProductoSaldosDestino.setInvProducto(listadoDetalleTransferencias.get(i).getInvProducto());
                                                        ////BUSQUEDA DE LA ENTIDAD ORIGEN
                                                        inventario.entity.InvProductoSaldos invProductoSaldosConsultaOrigen = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldosOrigen.getInvProductoSaldosPK().getStkEmpresa(),
                                                                invProductoSaldosOrigen.getInvProductoSaldosPK().getStkBodega(),
                                                                invProductoSaldosOrigen.getInvProductoSaldosPK().getStkProducto());
                                                        ////BUSQUEDA DE LA ENTIDAD DESTINO                                                        
                                                        inventario.entity.InvProductoSaldos invProductoSaldosConsultaDestino = operacionesInventarioDAOLocal.buscarProductosSaldos(invProductoSaldosDestino.getInvProductoSaldosPK().getStkEmpresa(),
                                                                invProductoSaldosDestino.getInvProductoSaldosPK().getStkBodega(),
                                                                invProductoSaldosDestino.getInvProductoSaldosPK().getStkProducto());
                                                        if (desmayorizar || invTransferencias.getTransAnulado()) {
                                                            if (invProductoSaldosConsultaDestino != null) {
                                                                //COMO SI EXISTE EN LA TABLA SE LE RESTA AL DESTINO
                                                                invProductoSaldosDestino.setStkSaldoFinal(invProductoSaldosConsultaDestino.getStkSaldoFinal().
                                                                        subtract(listadoDetalleTransferencias.get(i).getDetCantidad()));
                                                                ///COMO SI EXISTE EL DESTINO EN LA TABLA SE LE SUMA AL ORIGEN PERO NO SIN ANTES PREGUNTAR SI YA EXISTE EL ORIGEN, SINO PARA CREARLO
                                                                if (invProductoSaldosConsultaOrigen == null) {
                                                                    invProductoSaldosOrigen.setStkSaldoFinal(listadoDetalleTransferencias.get(i).getDetCantidad());
                                                                } else {
                                                                    invProductoSaldosOrigen.setStkSaldoFinal(invProductoSaldosConsultaOrigen.getStkSaldoFinal().
                                                                            add(listadoDetalleTransferencias.get(i).getDetCantidad()));
                                                                }
                                                                if (invProductoSaldosDestino.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                                    invProductoSaldosDestino.setStkFechaUltimaCompraFinal(invTransferencias.getTransFecha());

                                                                    invProductoSaldosOrigen.setStkFechaUltimaCompraFinal(invProductoSaldosConsultaOrigen.getStkFechaUltimaCompraFinal());

                                                                    invProductoSaldosDestino.setStkValorUltimaCompraFinal(invProductoSaldosConsultaDestino.getStkValorUltimaCompraFinal());

                                                                    invProductoSaldosDestino.setStkSaldoInicial(invProductoSaldosConsultaDestino.getStkSaldoInicial());
                                                                    invProductoSaldosDestino.setStkValorPromedioInicial(invProductoSaldosConsultaDestino.getStkValorPromedioInicial());
                                                                    invProductoSaldosDestino.setStkValorPromedioFinal(invProductoSaldosConsultaDestino.getStkValorPromedioFinal());

                                                                    invProductoSaldosOrigen.setStkValorUltimaCompraFinal(invProductoSaldosConsultaOrigen.getStkValorUltimaCompraFinal());

                                                                    invProductoSaldosOrigen.setStkSaldoInicial(invProductoSaldosConsultaOrigen.getStkSaldoInicial());
                                                                    invProductoSaldosOrigen.setStkValorPromedioInicial(invProductoSaldosConsultaOrigen.getStkValorPromedioInicial());
                                                                    invProductoSaldosOrigen.setStkValorPromedioFinal(invProductoSaldosConsultaOrigen.getStkValorPromedioFinal());

                                                                    listaInvProductoSaldosOrigen.add(invProductoSaldosOrigen);
                                                                    listaInvProductoSaldosDestino.add(invProductoSaldosDestino);
                                                                } else {
                                                                    retorno = "F<html>No se puede transferir porque no hay stock suficiente en los siguientes productos:</html>";
                                                                    mensajeClase.add(listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleTransferencias.get(i).getInvProducto().getProNombre());
                                                                }
                                                            } else {
                                                                retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                mensajeClase.add(listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleTransferencias.get(i).getInvProducto().getProNombre());
                                                            }
                                                        } else {
                                                            if (invProductoSaldosConsultaOrigen != null) {
                                                                ///COMO SI EXISTE EN LA TABLA SE LE RESTA AL ORIGEN
                                                                invProductoSaldosOrigen.setStkSaldoFinal(invProductoSaldosConsultaOrigen.getStkSaldoFinal().
                                                                        subtract(listadoDetalleTransferencias.get(i).getDetCantidad()));
                                                                ///COMO SI EXISTE EL ORIGEN EN LA TABLA SE LE SUMA AL DESTINO PERO NO SIN ANTES PREGUNTAR SI YA EXISTE EL DESTINO, SINO PARA CREARLO
                                                                if (invProductoSaldosConsultaDestino == null) {
                                                                    invProductoSaldosDestino.setStkSaldoFinal(listadoDetalleTransferencias.get(i).getDetCantidad());
                                                                } else {
                                                                    invProductoSaldosDestino.setStkSaldoFinal(invProductoSaldosConsultaDestino.getStkSaldoFinal().
                                                                            add(listadoDetalleTransferencias.get(i).getDetCantidad()));
                                                                }
                                                                if (invProductoSaldosOrigen.getStkSaldoFinal().compareTo(cero) >= 0) {
                                                                    invProductoSaldosOrigen.setStkFechaUltimaCompraFinal(invProductoSaldosConsultaOrigen.getStkFechaUltimaCompraFinal());

                                                                    invProductoSaldosOrigen.setStkValorUltimaCompraFinal(invProductoSaldosConsultaOrigen.getStkValorUltimaCompraFinal());

                                                                    invProductoSaldosOrigen.setStkSaldoInicial(invProductoSaldosConsultaOrigen.getStkSaldoInicial());
                                                                    invProductoSaldosOrigen.setStkValorPromedioInicial(invProductoSaldosConsultaOrigen.getStkValorPromedioInicial());
                                                                    invProductoSaldosOrigen.setStkValorPromedioFinal(invProductoSaldosConsultaOrigen.getStkValorPromedioFinal());

                                                                    invProductoSaldosDestino.setStkValorUltimaCompraFinal(invProductoSaldosConsultaDestino == null
                                                                            ? cero : invProductoSaldosConsultaDestino.getStkValorUltimaCompraFinal());

                                                                    invProductoSaldosDestino.setStkFechaUltimaCompraFinal(invProductoSaldosConsultaDestino == null
                                                                            ? invTransferencias.getTransFecha() : invTransferencias.getTransFecha());

                                                                    invProductoSaldosDestino.setStkSaldoInicial(invProductoSaldosConsultaDestino == null
                                                                            ? cero : invProductoSaldosConsultaDestino.getStkSaldoInicial());
                                                                    invProductoSaldosDestino.setStkValorPromedioInicial(invProductoSaldosConsultaDestino == null
                                                                            ? cero : invProductoSaldosConsultaDestino.getStkValorPromedioInicial());
                                                                    invProductoSaldosDestino.setStkValorPromedioFinal(invProductoSaldosConsultaDestino == null
                                                                            ? cero : invProductoSaldosConsultaDestino.getStkValorPromedioFinal());

                                                                    invProductoSaldosOrigen.setStkValorUltimaCompraFinal(invProductoSaldosConsultaOrigen.getStkValorUltimaCompraFinal());

                                                                    listaInvProductoSaldosOrigen.add(invProductoSaldosOrigen);
                                                                    listaInvProductoSaldosDestino.add(invProductoSaldosDestino);
                                                                } else {
                                                                    retorno = "F<html>No se puede transferir porque no hay stock suficiente en los siguientes productos:</html>";
                                                                    mensajeClase.add(listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleTransferencias.get(i).getInvProducto().getProNombre());
                                                                }
                                                            } else {
                                                                retorno = "F<html>No hay stock suficiente en los siguientes productos:</html>";
                                                                mensajeClase.add(listadoDetalleTransferencias.get(i).getInvProducto().getInvProductoPK().getProCodigoPrincipal() + " \t\t" + listadoDetalleTransferencias.get(i).getInvProducto().getProNombre());
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            if (mensajeClase.isEmpty()) {
                                                if (invTransferencias.getTransAnulado()) {
                                                    invTransferenciasMotivoAnulacion.setInvTransferencias(invTransferencias);
                                                }
                                                /// PREPARANDO OBJETO SISSUCESO (susClave y susDetalle se llenan en DAOTransaccion)
                                                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                        susTabla,
                                                        susClave,
                                                        susSuceso,
                                                        susDetalle,
                                                        sisInfoTO);
                                                comprobar = operacionesInventarioDAOTransaccionLocal.modificarInvTransferencias(invTransferencias, listInvTransferenciasDetalle,
                                                        listInvTransferenciasDetalleEliminar, sisSuceso, listaInvProductoSaldosOrigen, listaInvProductoSaldosDestino, invTransferenciasMotivoAnulacion);
                                                if (comprobar) {
                                                    sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(invTransferenciasTO.getTransEmpresa(), invTransferencias.getInvTransferenciasPK().getTransPeriodo());
                                                    retorno = "T<html>Se  " + (invTransferenciasTO.getTransAnulado() ? "anuló" : "modificó") + "  la transferencia con la siguiente información:<br><br>"
                                                            + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                            + "</font>.<br> Motivo: <font size = 5>" + invTransferencias.getInvTransferenciasPK().
                                                            getTransMotivo()
                                                            + "</font>.<br> Número: <font size = 5>" + invTransferencias.getInvTransferenciasPK().getTransNumero() + "</font>.</html>";
                                                    mensajeTO.setFechaCreacion(invTransferencias.getUsrFechaInserta().toString());
                                                } else {
                                                    retorno = "FHubo un error al guardar la Transferencia...\nIntente de nuevo o contacte con el administrador";
                                                }
                                            } else {
                                                mensajeTO.setMensaje(retorno);
                                                mensajeTO.setListaErrores(mensajeClase);
                                            }
                                        } else {
                                            if (estadoDetalleEliminar == 1) {
                                                retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                            } else {
                                                retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                            }
                                        }
                                    } else {
                                        if (estadoDetalle == 1) {
                                            retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                        } else {
                                            retorno = "F<html>Una de las Bodega que escogió ya no está disponible...\nIntente de nuevo, escoja otra Bodega o contacte con el administrador</html>";
                                        }
                                    }
                                } else {
                                    retorno = "F<html>" + detalleError + "</html>";
                                }
                            }
                        } else {
                            retorno = "FNo se encuentra el motivo...";
                        }
                    } else {
                        retorno = "F<html>No se puede MAYORIZAR, DESMAYORIZAR o ANULAR debido a que el período se encuentra cerrado...</html>";
                    }
                } else {
                    retorno = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
                }
            } else {
                retorno = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
            }
        } catch (Exception e) {
            retorno = "FError al guardar datos...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarInvTransferenciasTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(retorno);
            return mensajeTO;
        }
    }

    public Boolean getPrecioFijoCategoriaProducto(String empresa, String codigoCategoria) throws Exception {
        return operacionesInventarioDAOLocal.getPrecioFijoCategoriaProducto(empresa, codigoCategoria);
    }

    public List<inventario.TO.InvListaTransferenciaMotivoTO> getInvListaTransferenciaMotivoTO(java.lang.String empresa) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvListaTransferenciaMotivoTO(empresa);
    }

    public inventario.TO.InvTransferenciaMotivoTO getInvTransferenciaMotivoTO(String empresa, inventario.TO.InvListaTransferenciaMotivoTO invListaTransferenciaMotivoTO) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvTransferenciasMotivoTO(empresa, invListaTransferenciaMotivoTO);
    }

    public String accionInvTransferenciaMotivo(inventario.TO.InvTransferenciaMotivoTO invTransferenciaMotivoTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            ///// CREANDO Suceso
            susClave = invTransferenciaMotivoTO.getTmDetalle();
            if (accion == 'I') {
                susDetalle = "Se insertó la TransferenciaMotivo con el detalle " + invTransferenciaMotivoTO.getTmDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó el TransferenciaMotivo con el detalle " + invTransferenciaMotivoTO.getTmDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó el TransferenciaMotivo con el detalle " + invTransferenciaMotivoTO.getTmDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_consumos_motivo";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO CarPagosForma
            inventario.entity.InvTransferenciasMotivo invTransferenciaMotivo = inventario.helper.ConversionesInventario.convertirInvTransferenciasMotivoTO_InvTransferenciasMotivo(invTransferenciaMotivoTO);
            comprobar = false;

            if (accion == 'E') {
                ////// BUSCANDO existencia PagosForma
                if (operacionesInventarioDAOLocal.comprobarInvTransferenciaMotivo(
                        invTransferenciaMotivoTO.getUsrEmpresa(),
                        invTransferenciaMotivoTO.getTmCodigo())) {
                    invTransferenciaMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvTransferenciasMotivo(invTransferenciaMotivo, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra la TransferenciaMotivo...";
                }
            } else {
                if (accion == 'I') {
                    if (!operacionesInventarioDAOLocal.comprobarInvTransferenciaMotivo(
                            invTransferenciaMotivoTO.getUsrEmpresa(),
                            invTransferenciaMotivoTO.getTmCodigo())) {
                        invTransferenciaMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvTransferenciasMotivo(invTransferenciaMotivo, sisSuceso, accion);
                    } else {
                        mensaje = "FSe encuentra creado el ConsumosMotivo...";
                    }
                }
                if (accion == 'M') {
                    if (operacionesInventarioDAOLocal.comprobarInvTransferenciaMotivo(
                            invTransferenciaMotivoTO.getUsrEmpresa(),
                            invTransferenciaMotivoTO.getTmCodigo())) {
                        invTransferenciaMotivo.setUsrFechaInserta(operacionesInventarioDAOLocal.buscarInvTransferenciaMotivo(
                                invTransferenciaMotivoTO.getUsrEmpresa(),
                                invTransferenciaMotivoTO.getTmCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvTransferenciasMotivo(invTransferenciaMotivo, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra creado la TransferenciaMotivo...";
                    }
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente la TransferenciaMotivo";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la TransferenciaMotivo";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la TransferenciaMotivo";
                }
            }

        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la forma pago, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvTransferenciaMotivo",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    public List<inventario.TO.InvTransferenciaMotivoComboTO> getListaTransferenciaMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        return operacionesInventarioDAOLocal.getListaTransferenciaMotivoComboTO(empresa, filtrarInactivos);
    }

    public List<inventario.TO.InvListaDetalleTransferenciaTO> getListaInvTransferenciasDetalleTO(String empresa, String periodo, String motivo, String numeroTransferencia) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvTransferenciasDetalleTO(empresa, periodo, motivo, numeroTransferencia);
    }

    public inventario.TO.InvTransferenciasTO getInvTransferenciasCabeceraTO(String empresa, String codigoPeriodo, String motivo, String numeroTransferencia) throws Exception {
        return operacionesInventarioDAOLocal.getInvTransferenciasCabeceraTO(empresa, codigoPeriodo, motivo, numeroTransferencia);
    }

    public List<inventario.TO.InvListaConsultaTransferenciaTO> getFunListadoTransferencias(String empresa, String fechaDesde, String fechaHasta, String status) throws Exception {
        return operacionesInventarioDAOLocal.getFunListadoTransferencias(empresa, fechaDesde, fechaHasta, status);
    }

    public List<inventario.TO.InvListaConsultaTransferenciaTO> getListaInvConsultaTransferencias(String empresa, String periodo, String motivo, String busqueda, String nRegistros) throws Exception {
        return operacionesInventarioDAOLocal.getListaInvConsultaTransferencia(empresa, periodo, motivo, busqueda, nRegistros);
    }

    public List<inventario.TO.InvListaProductosCambiarPrecioTO> getListaProductosCambiarPrecioTO(String empresa, String busqueda, String bodega, String fecha) throws Exception {
        return operacionesInventarioDAOLocal.getListaProductosCambiarPrecioTO(empresa, busqueda, bodega, fecha);
    }

    public List<inventario.TO.InvListaProductosCambiarPrecioCantidadTO> getListaProductosCambiarPrecioCantidadTO(String empresa, String busqueda, String bodega, String fecha) throws Exception {
        return operacionesInventarioDAOLocal.getListaProductosCambiarPrecioCantidadTO(empresa, busqueda, bodega, fecha);
    }

    public inventario.TO.MensajeTO invCambiarPrecioProducto(
            String empresa,
            String usuario,
            List<inventario.TO.InvListaProductosCambiarPrecioTO> invListaProductosCambiarPrecioTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        List<String> mensajeClase = new ArrayList(1);
        List<inventario.entity.InvProducto> invProductos = new ArrayList();
        int contador = 0;
        try {
            List<sistemaWeb.entity.SisSuceso> sisSucesos = new ArrayList();
            for (inventario.TO.InvListaProductosCambiarPrecioTO invListaProductosCambiarPrecioTO : invListaProductosCambiarPrecioTOs) {
                inventario.entity.InvProducto invProductoBusqueda = operacionesInventarioDAOLocal.buscarInvProducto(empresa, invListaProductosCambiarPrecioTO.getProCodigoPrincipal());
                if (invProductoBusqueda != null) {
                    inventario.entity.InvProducto invProducto = inventario.helper.ConversionesInventario.convertirInvProducto_InvProducto(invProductoBusqueda);
                    invListaProductosCambiarPrecioTO.setStockPrecio1(invListaProductosCambiarPrecioTO.getStockPrecio1() == null ? cero : invListaProductosCambiarPrecioTO.getStockPrecio1());
                    invListaProductosCambiarPrecioTO.setStockPrecio2(invListaProductosCambiarPrecioTO.getStockPrecio2() == null ? cero : invListaProductosCambiarPrecioTO.getStockPrecio2());
                    invListaProductosCambiarPrecioTO.setStockPrecio3(invListaProductosCambiarPrecioTO.getStockPrecio3() == null ? cero : invListaProductosCambiarPrecioTO.getStockPrecio3());
                    invListaProductosCambiarPrecioTO.setStockPrecio4(invListaProductosCambiarPrecioTO.getStockPrecio4() == null ? cero : invListaProductosCambiarPrecioTO.getStockPrecio4());
                    invListaProductosCambiarPrecioTO.setStockPrecio5(invListaProductosCambiarPrecioTO.getStockPrecio5() == null ? cero : invListaProductosCambiarPrecioTO.getStockPrecio5());

                    invListaProductosCambiarPrecioTO.setStockDescuento1(invListaProductosCambiarPrecioTO.getStockDescuento1() == null ? cero : invListaProductosCambiarPrecioTO.getStockDescuento1());
                    invListaProductosCambiarPrecioTO.setStockDescuento2(invListaProductosCambiarPrecioTO.getStockDescuento2() == null ? cero : invListaProductosCambiarPrecioTO.getStockDescuento2());
                    invListaProductosCambiarPrecioTO.setStockDescuento3(invListaProductosCambiarPrecioTO.getStockDescuento3() == null ? cero : invListaProductosCambiarPrecioTO.getStockDescuento3());
                    invListaProductosCambiarPrecioTO.setStockDescuento4(invListaProductosCambiarPrecioTO.getStockDescuento4() == null ? cero : invListaProductosCambiarPrecioTO.getStockDescuento4());
                    invListaProductosCambiarPrecioTO.setStockDescuento5(invListaProductosCambiarPrecioTO.getStockDescuento5() == null ? cero : invListaProductosCambiarPrecioTO.getStockDescuento5());

                    invProducto.setProPrecio1(invProducto.getProPrecio1() == null ? cero : invProducto.getProPrecio1());
                    invProducto.setProPrecio2(invProducto.getProPrecio2() == null ? cero : invProducto.getProPrecio2());
                    invProducto.setProPrecio3(invProducto.getProPrecio3() == null ? cero : invProducto.getProPrecio3());
                    invProducto.setProPrecio4(invProducto.getProPrecio4() == null ? cero : invProducto.getProPrecio4());
                    invProducto.setProPrecio5(invProducto.getProPrecio5() == null ? cero : invProducto.getProPrecio5());

                    invProducto.setProDescuento1(invProducto.getProDescuento1() == null ? cero : invProducto.getProDescuento1());
                    invProducto.setProDescuento2(invProducto.getProDescuento2() == null ? cero : invProducto.getProDescuento2());
                    invProducto.setProDescuento3(invProducto.getProDescuento3() == null ? cero : invProducto.getProDescuento3());
                    invProducto.setProDescuento4(invProducto.getProDescuento4() == null ? cero : invProducto.getProDescuento4());
                    invProducto.setProDescuento5(invProducto.getProDescuento5() == null ? cero : invProducto.getProDescuento5());

                    if (!invProducto.getProNombre().equals(invListaProductosCambiarPrecioTO.getProNombre())
                            || invProducto.getProPrecio1().compareTo(invListaProductosCambiarPrecioTO.getStockPrecio1()) != 0
                            || invProducto.getProDescuento1().compareTo(invListaProductosCambiarPrecioTO.getStockDescuento1()) != 0
                            || invProducto.getProPrecio2().compareTo(invListaProductosCambiarPrecioTO.getStockPrecio2()) != 0
                            || invProducto.getProDescuento2().compareTo(invListaProductosCambiarPrecioTO.getStockDescuento2()) != 0
                            || invProducto.getProPrecio3().compareTo(invListaProductosCambiarPrecioTO.getStockPrecio3()) != 0
                            || invProducto.getProDescuento3().compareTo(invListaProductosCambiarPrecioTO.getStockDescuento3()) != 0
                            || invProducto.getProPrecio4().compareTo(invListaProductosCambiarPrecioTO.getStockPrecio4()) != 0
                            || invProducto.getProDescuento4().compareTo(invListaProductosCambiarPrecioTO.getStockDescuento4()) != 0
                            || invProducto.getProPrecio5().compareTo(invListaProductosCambiarPrecioTO.getStockPrecio5()) != 0
                            || invProducto.getProDescuento5().compareTo(invListaProductosCambiarPrecioTO.getStockDescuento5()) != 0) {

                        invProducto.setProPrecio1(invListaProductosCambiarPrecioTO.getStockPrecio1());
                        invProducto.setProPrecio2(invListaProductosCambiarPrecioTO.getStockPrecio2());
                        invProducto.setProPrecio3(invListaProductosCambiarPrecioTO.getStockPrecio3());
                        invProducto.setProPrecio4(invListaProductosCambiarPrecioTO.getStockPrecio4());
                        invProducto.setProPrecio5(invListaProductosCambiarPrecioTO.getStockPrecio5());

                        invProducto.setProDescuento1(invListaProductosCambiarPrecioTO.getStockDescuento1());
                        invProducto.setProDescuento2(invListaProductosCambiarPrecioTO.getStockDescuento2());
                        invProducto.setProDescuento3(invListaProductosCambiarPrecioTO.getStockDescuento3());
                        invProducto.setProDescuento4(invListaProductosCambiarPrecioTO.getStockDescuento4());
                        invProducto.setProDescuento5(invListaProductosCambiarPrecioTO.getStockDescuento5());

                        invProducto.setProNombre(invListaProductosCambiarPrecioTO.getProNombre());
                        invProductos.add(invProducto);
                        contador++;
                        susClave = invProducto.getInvProductoPK().getProCodigoPrincipal();
                        susDetalle = "Se actualiza el precio: " + invProducto.getProNombre();
                        susSuceso = "UPDATE";
                        susTabla = "inventario.inv_producto";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        sisSucesos.add(sisSuceso);
                    }
                } else {
                    mensajeClase.add("El producto " + invListaProductosCambiarPrecioTO.getProNombre() + " no se encuentra disponible.");
                }
            }

            if (mensajeClase.isEmpty()) {
                if (operacionesInventarioDAOTransaccionLocal.invCambiarPrecioProductos(invProductos, sisSucesos)) {
                    mensajeTO.setMensaje("T<html>Los precios de los Productos fueron actualizados correctamente...</html>");
                } else {
                    mensajeTO.setMensaje("F<html>Hubo un error al actualizar los precios de los productos...<br>Contacte con el administrador o intentelo de nuevo</html>");
                }
            } else {
                mensajeTO.setMensaje("F<html>Hubo un error al actualizar los precios de los productos...</html>");
                mensajeTO.setListaErrores(mensajeClase);
            }
        } catch (Exception e) {
            mensajeTO.setMensaje("F<html>FError al guardar datos...</html>");
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "invCambiarPrecioProducto",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensajeTO;
        }
    }

    public inventario.TO.MensajeTO invCambiarPrecioCantidadProducto(
            String empresa,
            String usuario,
            List<inventario.TO.InvListaProductosCambiarPrecioCantidadTO> invListaProductosCambiarPrecioCantidadTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        List<String> mensajeClase = new ArrayList(1);
        List<inventario.entity.InvProducto> invProductos = new ArrayList();
        int contador = 0;
        try {
            List<sistemaWeb.entity.SisSuceso> sisSucesos = new ArrayList();
            for (inventario.TO.InvListaProductosCambiarPrecioCantidadTO invListaProductosCambiarPrecioCantidadTO : invListaProductosCambiarPrecioCantidadTOs) {
                inventario.entity.InvProducto invProductoBusqueda = operacionesInventarioDAOLocal.buscarInvProducto(empresa, invListaProductosCambiarPrecioCantidadTO.getProCodigoPrincipal());
                if (invProductoBusqueda != null) {
                    inventario.entity.InvProducto invProducto = inventario.helper.ConversionesInventario.convertirInvProducto_InvProducto(invProductoBusqueda);
                    invListaProductosCambiarPrecioCantidadTO.setStockPrecio1(invListaProductosCambiarPrecioCantidadTO.getStockPrecio1() == null ? cero : invListaProductosCambiarPrecioCantidadTO.getStockPrecio1());
                    invListaProductosCambiarPrecioCantidadTO.setStockPrecio2(invListaProductosCambiarPrecioCantidadTO.getStockPrecio2() == null ? cero : invListaProductosCambiarPrecioCantidadTO.getStockPrecio2());
                    invListaProductosCambiarPrecioCantidadTO.setStockPrecio3(invListaProductosCambiarPrecioCantidadTO.getStockPrecio3() == null ? cero : invListaProductosCambiarPrecioCantidadTO.getStockPrecio3());
                    invListaProductosCambiarPrecioCantidadTO.setStockPrecio4(invListaProductosCambiarPrecioCantidadTO.getStockPrecio4() == null ? cero : invListaProductosCambiarPrecioCantidadTO.getStockPrecio4());
                    invListaProductosCambiarPrecioCantidadTO.setStockPrecio5(invListaProductosCambiarPrecioCantidadTO.getStockPrecio5() == null ? cero : invListaProductosCambiarPrecioCantidadTO.getStockPrecio5());

                    invListaProductosCambiarPrecioCantidadTO.setStockCantidad1(invListaProductosCambiarPrecioCantidadTO.getStockCantidad1() == null ? cero : invListaProductosCambiarPrecioCantidadTO.getStockCantidad1());
                    invListaProductosCambiarPrecioCantidadTO.setStockCantidad2(invListaProductosCambiarPrecioCantidadTO.getStockCantidad2() == null ? cero : invListaProductosCambiarPrecioCantidadTO.getStockCantidad2());
                    invListaProductosCambiarPrecioCantidadTO.setStockCantidad3(invListaProductosCambiarPrecioCantidadTO.getStockCantidad3() == null ? cero : invListaProductosCambiarPrecioCantidadTO.getStockCantidad3());
                    invListaProductosCambiarPrecioCantidadTO.setStockCantidad4(invListaProductosCambiarPrecioCantidadTO.getStockCantidad4() == null ? cero : invListaProductosCambiarPrecioCantidadTO.getStockCantidad4());
                    invListaProductosCambiarPrecioCantidadTO.setStockCantidad5(invListaProductosCambiarPrecioCantidadTO.getStockCantidad5() == null ? cero : invListaProductosCambiarPrecioCantidadTO.getStockCantidad5());

                    invProducto.setProPrecio1(invProducto.getProPrecio1() == null ? cero : invProducto.getProPrecio1());
                    invProducto.setProPrecio2(invProducto.getProPrecio2() == null ? cero : invProducto.getProPrecio2());
                    invProducto.setProPrecio3(invProducto.getProPrecio3() == null ? cero : invProducto.getProPrecio3());
                    invProducto.setProPrecio4(invProducto.getProPrecio4() == null ? cero : invProducto.getProPrecio4());
                    invProducto.setProPrecio5(invProducto.getProPrecio5() == null ? cero : invProducto.getProPrecio5());

                    invProducto.setProCantidad1(invProducto.getProCantidad1() == null ? cero : invProducto.getProCantidad1());
                    invProducto.setProCantidad2(invProducto.getProCantidad2() == null ? cero : invProducto.getProCantidad2());
                    invProducto.setProCantidad3(invProducto.getProCantidad3() == null ? cero : invProducto.getProCantidad3());
                    invProducto.setProCantidad4(invProducto.getProCantidad4() == null ? cero : invProducto.getProCantidad4());
                    invProducto.setProCantidad5(invProducto.getProCantidad5() == null ? cero : invProducto.getProCantidad5());

                    if (invProducto.getProPrecio1().compareTo(invListaProductosCambiarPrecioCantidadTO.getStockPrecio1()) != 0
                            || invProducto.getProPrecio2().compareTo(invListaProductosCambiarPrecioCantidadTO.getStockPrecio2()) != 0
                            || invProducto.getProPrecio3().compareTo(invListaProductosCambiarPrecioCantidadTO.getStockPrecio3()) != 0
                            || invProducto.getProPrecio4().compareTo(invListaProductosCambiarPrecioCantidadTO.getStockPrecio4()) != 0
                            || invProducto.getProPrecio5().compareTo(invListaProductosCambiarPrecioCantidadTO.getStockPrecio5()) != 0
                            || invProducto.getProCantidad1().compareTo(invListaProductosCambiarPrecioCantidadTO.getStockCantidad1()) != 0
                            || invProducto.getProCantidad2().compareTo(invListaProductosCambiarPrecioCantidadTO.getStockCantidad2()) != 0
                            || invProducto.getProCantidad3().compareTo(invListaProductosCambiarPrecioCantidadTO.getStockCantidad3()) != 0
                            || invProducto.getProCantidad4().compareTo(invListaProductosCambiarPrecioCantidadTO.getStockCantidad4()) != 0
                            || invProducto.getProCantidad5().compareTo(invListaProductosCambiarPrecioCantidadTO.getStockCantidad5()) != 0) {

                        invProducto.setProPrecio1(invListaProductosCambiarPrecioCantidadTO.getStockPrecio1());
                        invProducto.setProPrecio2(invListaProductosCambiarPrecioCantidadTO.getStockPrecio2());
                        invProducto.setProPrecio3(invListaProductosCambiarPrecioCantidadTO.getStockPrecio3());
                        invProducto.setProPrecio4(invListaProductosCambiarPrecioCantidadTO.getStockPrecio4());
                        invProducto.setProPrecio5(invListaProductosCambiarPrecioCantidadTO.getStockPrecio5());

                        invProducto.setProCantidad1(invListaProductosCambiarPrecioCantidadTO.getStockCantidad1());
                        invProducto.setProCantidad2(invListaProductosCambiarPrecioCantidadTO.getStockCantidad2());
                        invProducto.setProCantidad3(invListaProductosCambiarPrecioCantidadTO.getStockCantidad3());
                        invProducto.setProCantidad4(invListaProductosCambiarPrecioCantidadTO.getStockCantidad4());
                        invProducto.setProCantidad5(invListaProductosCambiarPrecioCantidadTO.getStockCantidad5());
                        invProductos.add(invProducto);
                        contador++;
                        susClave = invProducto.getInvProductoPK().getProCodigoPrincipal();
                        susDetalle = "Se actualiza el precio: " + invProducto.getProNombre();
                        susSuceso = "UPDATE";
                        susTabla = "inventario.inv_producto";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        sisSucesos.add(sisSuceso);
                    }
                } else {
                    mensajeClase.add("El producto " + invListaProductosCambiarPrecioCantidadTO.getProNombre() + " no se encuentra disponible.");
                }
            }

            if (mensajeClase.isEmpty()) {
                if (operacionesInventarioDAOTransaccionLocal.invCambiarPrecioProductos(invProductos, sisSucesos)) {
                    mensajeTO.setMensaje("T<html>Los precios de los Productos fueron actualizados correctamente...</html>");
                } else {
                    mensajeTO.setMensaje("F<html>Hubo un error al actualizar los precios de los productos...<br>Contacte con el administrador o intentelo de nuevo</html>");
                }
            } else {
                mensajeTO.setMensaje("F<html>Hubo un error al actualizar los precios de los productos...</html>");
                mensajeTO.setListaErrores(mensajeClase);
            }
        } catch (Exception e) {
            mensajeTO.setMensaje("F<html>FError al guardar datos...</html>");
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "invCambiarPrecioProducto",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensajeTO;
        }
    }

    public inventario.TO.InvEstadoCCCVT getEstadoCCCVT(String empresa, String periodo, String motivo, String numero, String proceso) throws Exception {
        return operacionesInventarioDAOLocal.getEstadoCCCVT(empresa, periodo, motivo, numero, proceso);
    }

    public List<inventario.TO.InvSincronizarTO> invProductoSincronizar(java.lang.String empresaOrigen, java.lang.String empresaDestino, java.lang.String usuario, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        List<inventario.entity.InvProducto> invListaProductoFinal = new ArrayList();
        inventario.entity.InvProducto invProductoOrigen;
        inventario.entity.InvProducto invProductoDestino;
        List<inventario.TO.InvProductoSincronizarTO> invProductoSincronizarTOs = operacionesInventarioDAOLocal.invProductoSincronizar(empresaOrigen, empresaDestino);

        List<inventario.entity.InvProductoCategoria> invListaProductoCategoriaFinal = new ArrayList();
        inventario.entity.InvProductoCategoria invProductoCategoriaOrigen;
        inventario.entity.InvProductoCategoria invProductoCategoriaDestino;
        List<inventario.TO.InvCategoriaSincronizarTO> invCategoriaSincronizarTOs = operacionesInventarioDAOLocal.invCategoriasSincronizar(empresaOrigen, empresaDestino);

        List<sistemaWeb.entity.SisSuceso> sisListaSucesoFinal = new ArrayList();
        List<inventario.TO.InvSincronizarTO> invSincronizarTOs = new ArrayList();
        //CATEGORIAS
        if (invCategoriaSincronizarTOs != null) {
            if (!invCategoriaSincronizarTOs.isEmpty()) {
                //CREACION ENTIDAD CATEGORIA
                for (int i = 0; i < invCategoriaSincronizarTOs.size(); i++) {
                    if (invCategoriaSincronizarTOs.get(i).getScStatus().equals("UPDATE")) {
                        invProductoCategoriaOrigen = operacionesInventarioDAOLocal.buscarInvProductoCategoria(empresaOrigen, invCategoriaSincronizarTOs.get(i).getScCodigo());
                        invProductoCategoriaDestino = operacionesInventarioDAOLocal.buscarInvProductoCategoria(empresaDestino, invCategoriaSincronizarTOs.get(i).getScCodigo());
                        invProductoCategoriaDestino.setCatActiva(invProductoCategoriaOrigen.getCatActiva());
                        invProductoCategoriaDestino.setCatDetalle(invProductoCategoriaOrigen.getCatDetalle());
                        invProductoCategoriaDestino.setCatPrecioFijo(invProductoCategoriaOrigen.getCatPrecioFijo());
                        invListaProductoCategoriaFinal.add(invProductoCategoriaDestino);
                        susClave = invProductoCategoriaDestino.getInvProductoCategoriaPK().getCatCodigo();
                        susDetalle = "Se actualizó la categoría: " + invProductoCategoriaDestino.getCatDetalle();
                        susSuceso = "UPDATE";
                        susTabla = "inventario.inv_producto_categoria";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        sisListaSucesoFinal.add(sisSuceso);
                    } else {
                        invProductoCategoriaOrigen = operacionesInventarioDAOLocal.buscarInvProductoCategoria(empresaOrigen, invCategoriaSincronizarTOs.get(i).getScCodigo());
                        invProductoCategoriaDestino = invProductoCategoriaOrigen;
                        invProductoCategoriaDestino.setInvProductoCategoriaPK(new inventario.entity.InvProductoCategoriaPK(empresaDestino, invCategoriaSincronizarTOs.get(i).getScCodigo()));

                        invProductoCategoriaDestino.setUsrEmpresa(empresaDestino);
                        invProductoCategoriaDestino.setUsrCodigo(usuario);
                        invProductoCategoriaDestino.setUsrFechaInserta(validaciones.Validacion.fecha(validaciones.Validacion.fechaSistema("yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));
                        invListaProductoCategoriaFinal.add(invProductoCategoriaDestino);
                        susClave = invProductoCategoriaDestino.getInvProductoCategoriaPK().getCatCodigo();
                        susDetalle = "Se insertó el producto: " + invProductoCategoriaDestino.getCatDetalle();
                        susSuceso = "INSERT";
                        susTabla = "inventario.inv_producto";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        sisListaSucesoFinal.add(sisSuceso);
                    }
                }
            }
        }
        //PRODUCTOS
        if (invProductoSincronizarTOs != null) {
            if (!invProductoSincronizarTOs.isEmpty()) {
                for (int i = 0; i < invProductoSincronizarTOs.size(); i++) {
                    //CREACION ENTIDAD PRODUCTO
                    if (invProductoSincronizarTOs.get(i).getSpStatus().equals("UPDATE")) {
                        invProductoOrigen = inventario.helper.ConversionesInventario.convertirInvProducto_InvProducto(operacionesInventarioDAOLocal.buscarInvProducto(empresaOrigen, invProductoSincronizarTOs.get(i).getSpCodigo()));
                        invProductoDestino = inventario.helper.ConversionesInventario.convertirInvProducto_InvProducto(operacionesInventarioDAOLocal.buscarInvProducto(empresaDestino, invProductoSincronizarTOs.get(i).getSpCodigo()));
                        invProductoDestino.setProPrecio1(invProductoOrigen.getProPrecio1());
                        invProductoDestino.setProPrecio2(invProductoOrigen.getProPrecio2());
                        invProductoDestino.setProPrecio3(invProductoOrigen.getProPrecio3());
                        invProductoDestino.setProPrecio4(invProductoOrigen.getProPrecio4());
                        invProductoDestino.setProPrecio5(invProductoOrigen.getProPrecio5());
                        invListaProductoFinal.add(invProductoDestino);

                        susClave = invProductoDestino.getInvProductoPK().getProCodigoPrincipal();
                        susDetalle = "Se actualizó el/los precios del producto: " + invProductoDestino.getProNombre();
                        susSuceso = "UPDATE";
                        susTabla = "inventario.inv_producto";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        sisListaSucesoFinal.add(sisSuceso);
                    } else {
                        invProductoOrigen = inventario.helper.ConversionesInventario.convertirInvProducto_InvProducto(operacionesInventarioDAOLocal.buscarInvProducto(empresaOrigen, invProductoSincronizarTOs.get(i).getSpCodigo()));
                        invProductoDestino = invProductoOrigen;
                        invProductoDestino.setInvProductoPK(new inventario.entity.InvProductoPK(empresaDestino, invProductoSincronizarTOs.get(i).getSpCodigo()));

                        invProductoDestino.setInvProductoCategoria(new inventario.entity.InvProductoCategoria(empresaDestino, invProductoDestino.getInvProductoCategoria().getInvProductoCategoriaPK().getCatCodigo()));
                        invProductoDestino.setInvProductoTipo(new inventario.entity.InvProductoTipo(empresaDestino, invProductoDestino.getInvProductoTipo().getInvProductoTipoPK().getTipCodigo()));
                        invProductoDestino.setInvProductoMedida(new inventario.entity.InvProductoMedida(empresaDestino, invProductoDestino.getInvProductoMedida().getInvProductoMedidaPK().getMedCodigo()));
                        invProductoDestino.setUsrEmpresa(empresaDestino);
                        invProductoDestino.setUsrCodigo(usuario);
                        invProductoDestino.setUsrFechaInserta(validaciones.Validacion.fecha(validaciones.Validacion.fechaSistema("yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));
                        invListaProductoFinal.add(invProductoDestino);
                        susClave = invProductoDestino.getInvProductoPK().getProCodigoPrincipal();
                        susDetalle = "Se insertó el producto: " + invProductoDestino.getProNombre();
                        susSuceso = "INSERT";
                        susTabla = "inventario.inv_producto";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        sisListaSucesoFinal.add(sisSuceso);
                    }
                }
            }
        }
        if (!invListaProductoFinal.isEmpty() || !invListaProductoFinal.isEmpty()) {
            if (!operacionesInventarioDAOTransaccionLocal.invSincronizarProductosCategorias(invListaProductoFinal, invListaProductoCategoriaFinal, sisListaSucesoFinal)) {
                invProductoSincronizarTOs = null;
            }
        }
        //UNION DE CATEGORIAS Y PRODUCTOS EN UNA SOLA LISTA
        for (inventario.TO.InvCategoriaSincronizarTO invCategoriaSincronizarTO : invCategoriaSincronizarTOs) {
            inventario.TO.InvSincronizarTO invSincronizarTO = new inventario.TO.InvSincronizarTO();
            invSincronizarTO.setsCodigo(invCategoriaSincronizarTO.getScCodigo());
            invSincronizarTO.setsNombre(invCategoriaSincronizarTO.getScNombre());
            invSincronizarTO.setsStatus(invCategoriaSincronizarTO.getScStatus());
            invSincronizarTO.setsTipo("CATEGORIA");
            invSincronizarTOs.add(invSincronizarTO);
        }
        for (inventario.TO.InvProductoSincronizarTO invProductoSincronizarTO : invProductoSincronizarTOs) {
            inventario.TO.InvSincronizarTO invSincronizarTO = new inventario.TO.InvSincronizarTO();
            invSincronizarTO.setsCodigo(invProductoSincronizarTO.getSpCodigo());
            invSincronizarTO.setsNombre(invProductoSincronizarTO.getSpNombre());
            invSincronizarTO.setsStatus(invProductoSincronizarTO.getSpStatus());
            invSincronizarTO.setsTipo("PRODUCTO");
            invSincronizarTOs.add(invSincronizarTO);
        }
        return invSincronizarTOs;
    }

    public List<inventario.TO.InvListadoPagosTO> invListadoPagosTO(String empresa, String periodo, String motivo, String numero) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.invListadoPagosTO(empresa, periodo, motivo, numero);
    }

    public List<inventario.TO.InvListadoCobrosTO> invListadoCobrosTO(String empresa, String periodo, String motivo, String numero) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.invListadoCobrosTO(empresa, periodo, motivo, numero);
    }

    public List<inventario.TO.InvFunComprasTO> getInvFunComprasTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String motivo, java.lang.String proveedor, java.lang.String documento) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunComprasTO(empresa, desde, hasta, motivo, proveedor, documento);
    }

    public List<inventario.TO.InvFunVentasTO> getInvFunVentasTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String motivo, java.lang.String cliente, java.lang.String documento) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunVentasTO(empresa, desde, hasta, motivo, cliente, documento);
    }

    public List<inventario.TO.InvFunComprasConsolidandoProductosTO> getInvFunComprasConsolidandoProductosTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, String sector, java.lang.String motivo, java.lang.String proveedor) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunComprasConsolidandoProductosTO(empresa, desde, hasta, sector, motivo, proveedor);
    }

    public List<inventario.TO.InvFunConsumosConsolidandoProductosTO> getInvFunConsumosConsolidandoProductosTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String sector, java.lang.String bodega) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunConsumosConsolidandoProductosTO(empresa, desde, hasta, sector, bodega);
    }

    public List<inventario.TO.InvFunVentasConsolidandoProductosTO> getInvFunVentasConsolidandoProductosTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String sector, java.lang.String motivo, java.lang.String cliente) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunVentasConsolidandoProductosTO(empresa, desde, hasta, sector, motivo, cliente);
    }

    public List<inventario.TO.InvFunVentasVsCostoTO> getInvFunVentasVsCostoTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String bodega, java.lang.String cliente) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunVentasVsCostoTO(empresa, desde, hasta, bodega, cliente);
    }

    public List<inventario.TO.InvFunListadoProductosTO> getInvFunListadoProductosTO(java.lang.String empresa, java.lang.String categoria, java.lang.String busqueda) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunListadoProductosTO(empresa, categoria, busqueda);
    }

    public List<inventario.TO.InvFunListadoClientesTO> getInvFunListadoClientesTO(java.lang.String empresa, java.lang.String categoria) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunListadoClientesTO(empresa, categoria);
    }

    public List<inventario.TO.InvFunListadoProveedoresTO> getInvFunListadoProveedoresTO(java.lang.String empresa, java.lang.String categoria) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunListadoProveedoresTO(empresa, categoria);
    }

    public Boolean getPuedeEliminarProducto(String empresa, String producto) throws Exception {
        return operacionesInventarioDAOLocal.getPuedeEliminarProducto(empresa, producto);
    }

    public java.math.BigDecimal getPrecioProductoPorCantidad(String empresa, String codProducto, java.math.BigDecimal cantidad) throws Exception {
        return operacionesInventarioDAOLocal.getPrecioProductoPorCantidad(empresa, codProducto, cantidad);
    }

    public java.math.BigDecimal getCantidad3(String empresa, String codProducto) throws Exception {
        return operacionesInventarioDAOLocal.getCantidad3(empresa, codProducto);
    }

    public List<inventario.TO.InvSecuenciaComprobanteTO> getInvSecuenciaComprobanteTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvSecuenciaComprobanteTO(empresa, fechaDesde, fechaHasta);
    }

    public List<inventario.TO.InvProductoTipoComboTO> getInvProductoTipoComboListadoTO(java.lang.String empresa, String accion) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvProductoTipoComboListadoTO(empresa, accion);
    }

    @Override
    public String accionInvProductoTipo(inventario.TO.InvProductoTipoTO invProductoTipoTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = invProductoTipoTO.getTipCodigo() + " : " + invProductoTipoTO.getTipDetalle();
            if (accion == 'I') {
                susDetalle = "Se insertó tipo producto " + invProductoTipoTO.getTipDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó tipo producto " + invProductoTipoTO.getTipDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó tipo producto " + invProductoTipoTO.getTipDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_producto_medida";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invProductoMedida
            invProductoTipoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
            inventario.entity.InvProductoTipo invProductoTipo = inventario.helper.ConversionesInventario.convertirInvProductoTipoTO_InvProductoTipo(invProductoTipoTO);

            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoTipo(
                        invProductoTipoTO.getTipEmpresa(),
                        invProductoTipoTO.getTipCodigo())) {
                    if (operacionesInventarioDAOLocal.comprobarEliminarInvProductoTipo(
                            invProductoTipoTO.getTipEmpresa(),
                            invProductoTipoTO.getTipCodigo())) {
                        invProductoTipo.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarInvProductoTipo(
                                invProductoTipoTO.getTipEmpresa(),
                                invProductoTipoTO.getTipCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoTipo(invProductoTipo, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se puede eliminar, el Tipo ya esta asignado a algunos Productos...";
                    }
                } else {
                    mensaje = "FNo se encuentra el Tipo Producto...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvProductoTipo(
                        invProductoTipoTO.getTipEmpresa(),
                        invProductoTipoTO.getTipCodigo())) {
                    invProductoTipo.setUsrFechaInserta(
                            operacionesInventarioDAOLocal.buscarInvProductoTipo(
                            invProductoTipoTO.getTipEmpresa(),
                            invProductoTipoTO.getTipCodigo()).getUsrFechaInserta());
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoTipo(invProductoTipo, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el Tipo del Producto...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesInventarioDAOLocal.comprobarInvProductoTipo(
                        invProductoTipoTO.getTipEmpresa(),
                        invProductoTipoTO.getTipCodigo())) {
                    invProductoTipo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvProductoTipo(invProductoTipo, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe el Tipo Producto...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el Tipo de Producto";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el Tipo de Producto";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente  el Tipo de Producto";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar  el Tipo " + invProductoTipoTO.getTipDetalle() + ", inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvProductoTipo",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public Boolean buscarConteoCliente(String empCodigo, String codigoCliente) throws Exception {
        return operacionesInventarioDAOLocal.buscarConteoCliente(empCodigo, codigoCliente);
    }

    @Override
    public Boolean buscarConteoProveedor(String empCodigo, String codigoProveedor) throws Exception {
        return operacionesInventarioDAOLocal.buscarConteoProveedor(empCodigo, codigoProveedor);
    }

    @Override
    public List<inventario.TO.SaldoBodegaComprobacionTO> getInvFunSaldoBodegaComprobacionTO(java.lang.String empresa, java.lang.String bodega, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunSaldoBodegaComprobacionTO(empresa, bodega, desde, hasta);
    }

    public List<inventario.TO.InvFunConsumosTO> getInvFunConsumosTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String bodega) throws java.lang.Exception {
        return operacionesInventarioDAOLocal.getInvFunConsumosTO(empresa, desde, hasta, bodega);
    }

    public List<SaldoBodegaComprobacionTO> getInvFunSaldoBodegaComprobacionCantidadesTO(String empresa, String bodega, String desde, String hasta) throws Exception {
        return operacionesInventarioDAOLocal.getInvFunSaldoBodegaComprobacionCantidadesTO(empresa, bodega, desde, hasta);
    }

    public Boolean reconstruirCostos(String empCodigo, String Producto, String periodoHasta, Boolean periodoEstado) throws Exception {
        return operacionesInventarioDAOLocal.reconstruirCostos(empCodigo, Producto, periodoHasta, periodoEstado);
    }

    public List<inventario.TO.InvVendedorComboListadoTO> getComboinvListaVendedorTOs(java.lang.String codigoEmpresa) throws Exception {
        return operacionesInventarioDAOLocal.getComboinvListaVendedorTOs(codigoEmpresa);
    }

    @Override
    public String accionInvVendedorTO(inventario.TO.InvVendedorTO invVendedorTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = invVendedorTO.getVendCodigo() + " : " + invVendedorTO.getVendNombre();
            if (accion == 'I') {
                susDetalle = "Se insertó Vendedor " + invVendedorTO.getVendNombre();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó Vendedor " + invVendedorTO.getVendNombre();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó Vendedor " + invVendedorTO.getVendNombre();
                susSuceso = "DELETE";
            }
            susTabla = "inventario.inv_vendedor";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invProductoMedida
            invVendedorTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
            inventario.entity.InvVendedor invVendedor = inventario.helper.ConversionesInventario.convertirInvVendedorTO_InvVendedor(invVendedorTO);
            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvVendedor(
                        invVendedorTO.getVendEmpresa(),
                        invVendedorTO.getVendCodigo())) {
                    if (operacionesInventarioDAOLocal.comprobarEliminarInvVendedor(
                            invVendedorTO.getVendEmpresa(),
                            invVendedorTO.getVendCodigo())) {
                        invVendedor.setUsrFechaInserta(
                                operacionesInventarioDAOLocal.buscarInvVendedor(
                                invVendedorTO.getVendEmpresa(),
                                invVendedorTO.getVendCodigo()).getUsrFechaInserta());
                        comprobar = operacionesInventarioDAOTransaccionLocal.accionInvVendedor(invVendedor, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se puede eliminar, el Vendedor ya esta asignado a algunos Clientes...";
                    }
                } else {
                    mensaje = "FNo se encuentra el Vendedor...";
                }
            }
            if (accion == 'M') {

                ////// BUSCANDO existencia Categoría
                if (operacionesInventarioDAOLocal.comprobarInvVendedor(
                        invVendedorTO.getVendEmpresa(),
                        invVendedorTO.getVendCodigo())) {
                    invVendedor.setUsrFechaInserta(
                            operacionesInventarioDAOLocal.buscarInvVendedor(
                            invVendedorTO.getVendEmpresa(),
                            invVendedorTO.getVendCodigo()).getUsrFechaInserta());
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvVendedor(invVendedor, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el Vendedor...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesInventarioDAOLocal.comprobarInvVendedor(
                        invVendedorTO.getVendEmpresa(),
                        invVendedorTO.getVendCodigo())) {
                    invVendedor.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesInventarioDAOTransaccionLocal.accionInvVendedor(invVendedor, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe el Vendedor...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el Vendedor";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el Vendedor";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente  el Vendedor";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar  el Vendedor codigo:" + invVendedorTO.getVendCodigo() + "Nombre: " + invVendedorTO.getVendNombre() + ", inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionInvVendedor",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    public List<inventario.TO.InvFunListaProductosImpresionPlacasTO> getInvFunListaProductosImpresionPlacasTO(String empresa, String producto, boolean estado) throws Exception {
        return operacionesInventarioDAOLocal.getInvFunListaProductosImpresionPlacasTO(empresa, producto, estado);
    }

    public List<inventario.TO.InvFunListaProductosSaldosGeneralTO> getInvFunListaProductosSaldosGeneralTO(String empresa, String producto, String fecha, boolean estado) throws Exception {
        return operacionesInventarioDAOLocal.getInvFunListaProductosSaldosGeneralTO(empresa, producto, fecha, estado);
    }

    @Override
    public helper.RetornoTO getInvFunListaProductosSaldosGeneralTO(String empresa, String producto, String fecha, boolean estado, String usuario, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {

            List<inventario.TO.InvFunListaProductosSaldosGeneralTO> funListaProductosSaldosGeneralTOs = operacionesInventarioDAOLocal.getInvFunListaProductosSaldosGeneralTO(empresa, producto, fecha, estado);

            mensaje = "T";
            inventario.helper.NumeroColumnaDesconocidadFunListaProductosSaldosGeneral obj = new inventario.helper.NumeroColumnaDesconocidadFunListaProductosSaldosGeneral();

            obj.agruparCabeceraColumnas(funListaProductosSaldosGeneralTOs);
            obj.agruparProductos(funListaProductosSaldosGeneralTOs);
            obj.llenarObjetoParaTabla(funListaProductosSaldosGeneralTOs);
            retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
            retornoTO.setColumnas(obj.getColumnas());
            retornoTO.setDatos(obj.getDatos());
        } catch (Exception e) {
            comprobar = false;
            mensaje = "FOcurrió un error al obtener los datos de la Base de Datos. \nContacte con el administrador...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getConsumoPorFechaDesglosado",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            retornoTO.setMensaje(mensaje);
            return retornoTO;
        }

    }

    public List<inventario.TO.InvFunUltimasComprasTO> getInvFunUltimasComprasTOs(java.lang.String empresa, java.lang.String producto) throws Exception {
        return operacionesInventarioDAOLocal.getInvFunUltimasComprasTOs(empresa, producto);
    }

    public inventario.TO.InvComprasTO getComprasTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return operacionesInventarioDAOLocal.getComprasTO(empresa, periodo, motivo, numeroCompra);
    }

    public List<inventario.TO.InvListaProductosCompraSustentoConceptoTO> getInvProductoSustentoConcepto(String empresa, List<inventario.TO.InvListaProductosCompraSustentoConceptoTO> invListaProductosCompraTOs) throws Exception {
        inventario.entity.InvProducto invProducto = null;
        List<inventario.TO.InvListaProductosCompraSustentoConceptoTO> listaSumaSubtotalesSustento = new ArrayList();
        List<inventario.TO.InvListaProductosCompraSustentoConceptoTO> listaSumaSubtotalesConcepto = new ArrayList();
        List<inventario.TO.InvListaProductosCompraSustentoConceptoTO> listaSustentoConcepto = new ArrayList();
        inventario.TO.InvListaProductosCompraSustentoConceptoTO sumaSubtotalesSustento;
        inventario.TO.InvListaProductosCompraSustentoConceptoTO sumaSubtotalesConcepto;
        anexos.TO.AnxConceptoTO anxConceptoTO = new AnxConceptoTO();
        String sustentoCodigo = "";
        String auxAustentoCodigo = "";
        String conceptoCodigo = "";
        String auxConceptoCodigo = "";
        BigDecimal acumSubtotalSustentoNull = cero;
        BigDecimal acumBaseImponibleConceptoNull = cero;
        BigDecimal acumBase0ConceptoNull = cero;
        for (InvListaProductosCompraSustentoConceptoTO invListaProductosCompraTO : invListaProductosCompraTOs) {
            invProducto = operacionesInventarioDAOLocal.buscarInvProducto(empresa, invListaProductosCompraTO.getProCodigoPrincipal());
            BigDecimal acumSubtotalSustento = cero;
            BigDecimal acumBaseImponible = cero;
            BigDecimal acumBase0 = cero;
            boolean banderaSustento = false;
            boolean banderaConcepto = false;
            for (InvListaProductosCompraSustentoConceptoTO invListaProductosCompraTOInterno : invListaProductosCompraTOs) {
                inventario.entity.InvProducto invProductoAux = operacionesInventarioDAOLocal.buscarInvProducto(empresa, invListaProductosCompraTOInterno.getProCodigoPrincipal());
                /////SACAR EL CODIGO DE LOS SUSTENTOS, SUMA LOS TOTALES
                if (invProductoAux.getSusCodigo() != null && invProducto.getSusCodigo() != null) {
                    if (invProducto.getSusCodigo().equals(invProductoAux.getSusCodigo())
                            && !invProducto.getSusCodigo().equals(auxAustentoCodigo)) {
                        acumSubtotalSustento = acumSubtotalSustento.add(validaciones.Validacion.redondeoDecimalBigDecimal(invListaProductosCompraTOInterno.getSubtotal(), 15, java.math.RoundingMode.HALF_UP));
                        sustentoCodigo = invProductoAux.getSusCodigo();
                        banderaSustento = true;
                    }
                }
                if (invProductoAux.getConCodigo() != null && invProducto.getConCodigo() != null) {
                    if (invProducto.getConCodigo().equals(invProductoAux.getConCodigo())
                            && !invProducto.getConCodigo().equals(auxConceptoCodigo)) {
                        conceptoCodigo = invProductoAux.getConCodigo();
                        if (invProductoAux.getProIva().equals("GRAVA")) {
                            banderaConcepto = true;
                            acumBaseImponible = acumBaseImponible.add(validaciones.Validacion.redondeoDecimalBigDecimal(invListaProductosCompraTOInterno.getSubtotal(), 15, java.math.RoundingMode.HALF_UP));
                            //acumBaseImponible = acumBaseImponible.add(validaciones.Validacion.redondeoDecimalBigDecimal(invListaProductosCompraTOInterno.getSubtotal()));
                        } else {
                            banderaConcepto = true;
                            acumBase0 = acumBase0.add(validaciones.Validacion.redondeoDecimalBigDecimal(invListaProductosCompraTOInterno.getSubtotal(), 15, java.math.RoundingMode.HALF_UP));
                            //acumBase0 = acumBase0.add(validaciones.Validacion.redondeoDecimalBigDecimal(invListaProductosCompraTOInterno.getSubtotal()));
                        }
                    }
                }
            }
            if (invProducto.getSusCodigo() == null) {
                acumSubtotalSustentoNull = acumSubtotalSustentoNull.add(validaciones.Validacion.redondeoDecimalBigDecimal(invListaProductosCompraTO.getSubtotal(), 15, java.math.RoundingMode.HALF_UP));
            }
            if (invProducto.getConCodigo() == null) {
                if (invProducto.getProIva().equals("GRAVA")) {
                    acumBaseImponibleConceptoNull = acumBaseImponibleConceptoNull.add(validaciones.Validacion.redondeoDecimalBigDecimal(invListaProductosCompraTO.getSubtotal(), 15, java.math.RoundingMode.HALF_UP));
                } else {
                    acumBase0ConceptoNull = acumBase0ConceptoNull.add(validaciones.Validacion.redondeoDecimalBigDecimal(invListaProductosCompraTO.getSubtotal(), 15, java.math.RoundingMode.HALF_UP));
                }
            }
            if (banderaSustento) {
                sumaSubtotalesSustento = new InvListaProductosCompraSustentoConceptoTO();
                sumaSubtotalesSustento.setSusCodigo(sustentoCodigo);
                sumaSubtotalesSustento.setConCodigo("-");
                sumaSubtotalesSustento.setSubtotal(validaciones.Validacion.redondeoDecimalBigDecimal(acumSubtotalSustento, 2, java.math.RoundingMode.HALF_UP));
                sumaSubtotalesSustento.setBaseImponible(cero);
                sumaSubtotalesSustento.setBase0(cero);
                listaSumaSubtotalesSustento.add(sumaSubtotalesSustento);
                auxAustentoCodigo = sustentoCodigo;
            }
            if (banderaConcepto) {
                sumaSubtotalesConcepto = new InvListaProductosCompraSustentoConceptoTO();
                sumaSubtotalesConcepto.setSusCodigo("-");
                sumaSubtotalesConcepto.setConCodigo(conceptoCodigo);
                sumaSubtotalesConcepto.setBaseImponible(validaciones.Validacion.redondeoDecimalBigDecimal(acumBaseImponible, 2, java.math.RoundingMode.HALF_UP));
                sumaSubtotalesConcepto.setBase0(validaciones.Validacion.redondeoDecimalBigDecimal(acumBase0, 2, java.math.RoundingMode.HALF_UP));
                listaSumaSubtotalesConcepto.add(sumaSubtotalesConcepto);
                auxConceptoCodigo = conceptoCodigo;
            }
        }
        BigDecimal mayor = cero;
        if (acumSubtotalSustentoNull.compareTo(cero) == 1) {
            sumaSubtotalesSustento = new InvListaProductosCompraSustentoConceptoTO();
            sumaSubtotalesSustento.setSusCodigo(null);
            sumaSubtotalesSustento.setConCodigo("-");
            sumaSubtotalesSustento.setBaseImponible(cero);
            sumaSubtotalesSustento.setBase0(cero);
            sumaSubtotalesSustento.setSubtotal(validaciones.Validacion.redondeoDecimalBigDecimal(acumSubtotalSustentoNull, 2, java.math.RoundingMode.HALF_UP));
            listaSumaSubtotalesSustento.add(sumaSubtotalesSustento);
        }
        if (acumBaseImponibleConceptoNull.compareTo(cero) == 1 || acumBase0ConceptoNull.compareTo(cero) == 1) {
            sumaSubtotalesConcepto = new InvListaProductosCompraSustentoConceptoTO();
            sumaSubtotalesConcepto.setSusCodigo("-");
            sumaSubtotalesConcepto.setConCodigo(null);
            sumaSubtotalesConcepto.setBaseImponible(validaciones.Validacion.redondeoDecimalBigDecimal(acumBaseImponibleConceptoNull, 2, java.math.RoundingMode.HALF_UP));
            sumaSubtotalesConcepto.setBase0(validaciones.Validacion.redondeoDecimalBigDecimal(acumBase0ConceptoNull, 2, java.math.RoundingMode.HALF_UP));
            listaSumaSubtotalesConcepto.add(sumaSubtotalesConcepto);
        }
        for (InvListaProductosCompraSustentoConceptoTO invListaProductosCompraTO : listaSumaSubtotalesSustento) {
            if (invListaProductosCompraTO.getSubtotal().compareTo(mayor) > -1) {
                mayor = invListaProductosCompraTO.getSubtotal();
                sustentoCodigo = invListaProductosCompraTO.getSusCodigo();
            }
        }
        sumaSubtotalesSustento = new InvListaProductosCompraSustentoConceptoTO();
        sumaSubtotalesSustento.setSusCodigo(sustentoCodigo);
        sumaSubtotalesSustento.setConCodigo("-");
        sumaSubtotalesSustento.setSubtotal(mayor);
        listaSustentoConcepto.add(sumaSubtotalesSustento);

        for (InvListaProductosCompraSustentoConceptoTO invListaProductosCompraTO : listaSumaSubtotalesConcepto) {
            if (invListaProductosCompraTO.getConCodigo() != null && !invListaProductosCompraTO.getConCodigo().equals("-")) {
                invListaProductosCompraTO.setDetBaseNoObjetoIva(cero);
                anxConceptoTO = operacionesAnexoDAOLocal.getBuscarAnexoConceptoTO(invListaProductosCompraTO.getConCodigo());
                invListaProductosCompraTO.setDetPorcentaje(anxConceptoTO.getConPorcentaje());
                invListaProductosCompraTO.setDetValorRetenido(
                        invListaProductosCompraTO.getBaseImponible().add(
                        invListaProductosCompraTO.getBase0()).multiply(
                        anxConceptoTO.getConPorcentaje().divide(new java.math.BigDecimal("100"))));
            }
            listaSustentoConcepto.add(invListaProductosCompraTO);
        }
        return listaSustentoConcepto;
    }

    // <editor-fold defaultstate="collapsed" desc="REPORTES INVENTARIO">
    @Override
    public JasperPrint generarReporteInvKardex(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String nombreProducto, String fechaDesde,
            String fechaHasta, List<InvKardexTO> listInvKardexTO, boolean banderaCosto) throws Exception {
        return generarReporteInventarioLocal.generarReporteInvKardex(sisUsuarioEmpresaTO, nombreProducto, fechaDesde, fechaHasta, listInvKardexTO, banderaCosto);
    }

    @Override
    public JasperPrint generarReporteImpresionPlaca(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, LinkedList listProductosImpresionPlaca) throws Exception {
        return generarReporteInventarioLocal.generarReporteImpresionPlaca(sisUsuarioEmpresaTO, listProductosImpresionPlaca);
    }

    @Override
    public JasperPrint generarReporteListadoCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String motivo, String proveedorId, String documento,
            List<InvFunComprasTO> listInvFunComprasTO) throws Exception {
        return generarReporteInventarioLocal.generarReporteListadoCompras(sisUsuarioEmpresaTO, fechaDesde,
                fechaHasta, motivo, proveedorId, documento, listInvFunComprasTO);
    }

    @Override
    public JasperPrint generarReporteConsolidadoCompraProducto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String bodega, String proveedor, List<InvFunComprasConsolidandoProductosTO> listInvFunComprasConsolidandoProductosTO) throws Exception {
        return generarReporteInventarioLocal.generarReporteConsolidadoCompraProducto(sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                bodega, proveedor, listInvFunComprasConsolidandoProductosTO);
    }

    @Override
    public JasperPrint generarReporteListadoVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String motivo, String cliente, String documento,
            List<InvFunVentasTO> listInvFunVentasTO) throws Exception {
        return generarReporteInventarioLocal.generarReporteListadoVentas(sisUsuarioEmpresaTO, fechaDesde,
                fechaHasta, motivo, cliente, documento, listInvFunVentasTO);
    }

    @Override
    public JasperPrint generarReporteConsolidadoVentaProducto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String bodega, String cliente, List<InvFunVentasConsolidandoProductosTO> listInvFunVentasConsolidandoProductosTO) throws Exception {
        return generarReporteInventarioLocal.generarReporteConsolidadoVentaProducto(sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                bodega, cliente, listInvFunVentasConsolidandoProductosTO);
    }

    @Override
    public JasperPrint generarReporteListadoConsumos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta, List<InvFunConsumosTO> listInvFunConsumosTO) throws Exception {
        return generarReporteInventarioLocal.generarReporteListadoConsumos(sisUsuarioEmpresaTO, fechaDesde, fechaHasta, listInvFunConsumosTO);
    }

    @Override
    public JasperPrint generarReporteListaProductos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega,
            List<InvListaProductosTO> listInvListaProductosTO) throws Exception {
        return generarReporteInventarioLocal.generarReporteListaProductos(sisUsuarioEmpresaTO, bodega, listInvListaProductosTO);
    }

    @Override
    public JasperPrint generarReporteSaldoBodega(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega, String fechaHasta,
            List<SaldoBodegaTO> listSaldoBodegaTO) throws Exception {
        return generarReporteInventarioLocal.generarReporteSaldoBodega(sisUsuarioEmpresaTO, bodega, fechaHasta, listSaldoBodegaTO);
    }

    @Override
    public JasperPrint generarReporteSaldoBodegaComprobacion(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega,
            String fechaDesde, String fechaHasta,
            List<SaldoBodegaComprobacionTO> lista) throws Exception {
        return generarReporteInventarioLocal.generarReporteSaldoBodegaComprobacion(
                sisUsuarioEmpresaTO, bodega, fechaDesde, fechaHasta, lista);
    }

    @Override
    public JasperPrint generarReporteInvProductosConError(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<InvProductosConErrorTO> listInvProductosConErrorTO) throws Exception {
        return generarReporteInventarioLocal.generarReporteInvProductosConError(sisUsuarioEmpresaTO, listInvProductosConErrorTO);
    }

    public JasperPrint generarReporteTrasferencias(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteTransferenciaDetalle> listReporteTransferenciaDetalle) throws Exception {
        return generarReporteInventarioLocal.generarReporteTrasferencias(sisUsuarioEmpresaTO, listReporteTransferenciaDetalle);
    }

    @Override
    public JasperPrint generarReporteConsumoDetalle(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            boolean ordenado,
            List<ReporteConsumoDetalle> reporteConsumoDetalles) throws Exception {
        return generarReporteInventarioLocal.generarReporteConsumoDetalle(
                sisUsuarioEmpresaTO, ordenado, reporteConsumoDetalles);
    }

    @Override
    public JasperPrint generarReporteCompraDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteCompraDetalle> reporteCompraDetalles) throws Exception {
        return generarReporteInventarioLocal.generarReporteCompraDetalle(
                sisUsuarioEmpresaTO, reporteCompraDetalles);
    }

    @Override
    public JasperPrint generarReporteVentaDetalleImpresion(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteVentaDetalle> lista, String nombreCliente, String nombreReporte) throws Exception {
        return generarReporteInventarioLocal.generarReporteVentaDetalleImpresion(
                sisUsuarioEmpresaTO, lista, nombreCliente, nombreReporte);
    }

    @Override
    public JasperPrint generarReporteProformaDetalleImpresion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteProformaDetalle> lista, String nombreReporte) throws Exception {
        return generarReporteInventarioLocal.generarReporteProformaDetalleImpresion(sisUsuarioEmpresaTO, lista, nombreReporte);
    }

    @Override
    public JasperPrint generarReporteInvFunVentasVsCosto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String bodega, String clienteId,
            List<InvFunVentasVsCostoTO> invFunVentasVsCostoTO) throws Exception {
        return generarReporteInventarioLocal.generarReporteInvFunVentasVsCosto(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                bodega, clienteId, invFunVentasVsCostoTO);
    }

    @Override
    public JasperPrint generarReporteCompraDetalleImprimir(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteCompraDetalle> reporteCompraDetalles,
            String cmFormaImprimir) throws Exception {
        return generarReporteInventarioLocal.generarReporteCompraDetalleImprimir(
                sisUsuarioEmpresaTO, reporteCompraDetalles, cmFormaImprimir);
    }
    // </editor-fold>

    public RetornoTO getComprasPorPeriodo(String empresa, String codigoSector, String fechaInicio,  
            String fechaFin,  boolean chk, SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {
            java.util.List<inventario.TO.InvComprasPorPeriodoTO> prdComprasPorPeriodoTOs = operacionesInventarioDAOLocal.getComprasPorPeriodo(
                    empresa, codigoSector, fechaInicio, fechaFin, chk);
            mensaje = "T";
            inventario.helper.NumeroColumnaDesconocidadComprasPorPeriodo obj = new inventario.helper.NumeroColumnaDesconocidadComprasPorPeriodo();
            obj.agruparCabeceraColumnas(prdComprasPorPeriodoTOs);
            obj.agruparProductos(prdComprasPorPeriodoTOs);
            obj.llenarObjetoParaTabla(prdComprasPorPeriodoTOs);
            retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
            retornoTO.setColumnas(obj.getColumnas());
            retornoTO.setDatos(obj.getDatos());
        } catch (Exception e) {
            comprobar = false;
            mensaje = "FOcurrió un error al obtener los datos de la Base de Datos. \nContacte con el administrador...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getConsumoProductosProceso",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            retornoTO.setMensaje(mensaje);
            return retornoTO;
        }
        
    }
}
