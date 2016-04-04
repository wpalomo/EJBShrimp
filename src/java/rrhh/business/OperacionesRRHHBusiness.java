/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.business;

import contabilidad.TO.ConContableTO;
import contabilidad.entity.ConCuentas;
import contabilidad.entity.ConDetalle;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import rrhh.DAO.OperacionesRRHHDAOLocal;
import rrhh.DAO.OperacionesRRHHDAOTransaccionLocal;
import rrhh.TO.*;
import rrhh.entity.*;
import rrhh.helper.ConversionesRRHH;
import rrhh.reporte.*;
import sistema.DAO.OperacionesSistemaDAOLocal;
import sistema.DAO.OperacionesSistemaDAOTransaccionLocal;
import sistema.TO.SisErrorTO;
import sistema.TO.SisUsuarioEmpresaTO;
import sistemaWeb.entity.DAO.SisErrorFacadeLocal;
import static util.UtilsArchivos.*;
import validaciones.Validacion;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesRRHHBusiness implements OperacionesRRHHBusinessLocal {

    // <editor-fold defaultstate="collapsed" desc="DECLARACIONES EJB">
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @EJB
    OperacionesSistemaDAOTransaccionLocal operacionesDAOTransaccionLocal;
    @EJB
    OperacionesRRHHDAOTransaccionLocal operacionesRRHHDAOTransaccionLocal;
    @EJB
    SisErrorFacadeLocal sisErrorFacadeLocal;
    @EJB
    OperacionesRRHHDAOLocal operacionesRRHHDAOLocal;
    @EJB
    contabilidad.DAO.OperacionesContabilidadDAOLocal operacionesContabilidadDAOLocal;
    @EJB
    contabilidad.DAO.OperacionesContabilidadDAOTransaccionLocal operacionesContabilidadDAOTransaccionLocal;
    @EJB
    contabilidad.business.OperacionesContabilidadBusinessLocal operacionesContabilidadBusinessLocal;
    @javax.ejb.EJB
    produccion.DAO.OperacionesProduccionDAOLocal operacionesProduccionDAOLocal;
    @javax.ejb.EJB
    cartera.DAO.OperacionesCarDAOLocal operacionesCarDAOLocal;
    @javax.ejb.EJB
    banco.DAO.OperacionesBancoDAOTransaccionLocal operacionesBancoDAOTransaccionLocal;
    @javax.ejb.EJB
    sistema.business.OperacionesSistemaBusinessLocal operacionesSistemaBusinessLocal;
    @javax.ejb.EJB
    GenerarReporteRrhhLocal generarReporteRrhhLocal;
    // </editor-fold>
    Boolean comprobar = false;
    private String mensaje = "";
    private java.math.BigDecimal cero = new java.math.BigDecimal("0.00");
    public SisErrorTO sisErrorTO = null;
    private String susTabla;
    private String susClave;
    private String susSuceso;
    private String susDetalle;

    //private  generarReporteRrhhLocal;
    // <editor-fold defaultstate="collapsed" desc="CATEGORIA">
    @Override
    public String accionRhCategoria(
            RhCategoriaTO rhCategoriaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = rhCategoriaTO.getCatNombre();

            if (accion == 'I') {
                susDetalle = "Se insertó la categoría " + rhCategoriaTO.getCatNombre();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó la categoría " + rhCategoriaTO.getCatNombre();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó la categoría " + rhCategoriaTO.getCatNombre();
                susSuceso = "DELETE";
            }
            susTabla = "recursoshumanos.rh_categoria";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO RhCategoria
            RhCategoria rhCategoria = ConversionesRRHH.convertirRhCategoriaTO_RhCategoria(
                    rhCategoriaTO);

            if (accion == 'E') {
                ////// BUSCANDO existencia RhCategoria
                if (operacionesRRHHDAOLocal.buscarCategoria(
                        rhCategoriaTO.getEmpCodigo(),
                        rhCategoriaTO.getCatNombre()) != null) {
                    rhCategoria.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesRRHHDAOTransaccionLocal.accionRhCategoria(rhCategoria, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra la categoría...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia RhCategoria
                if (operacionesRRHHDAOLocal.buscarCategoria(
                        rhCategoriaTO.getEmpCodigo(),
                        rhCategoriaTO.getCatNombre()) != null) {
                    rhCategoria.setUsrFechaInserta(
                            operacionesRRHHDAOLocal.buscarCategoria(
                            rhCategoriaTO.getEmpCodigo(),
                            rhCategoriaTO.getCatNombre()).getUsrFechaInserta());
                    comprobar = operacionesRRHHDAOTransaccionLocal.accionRhCategoria(rhCategoria, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra la categoría...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia RhCategoria
                if (operacionesRRHHDAOLocal.buscarCategoria(
                        rhCategoriaTO.getEmpCodigo(),
                        rhCategoriaTO.getCatNombre()) == null) {
                    rhCategoria.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesRRHHDAOTransaccionLocal.accionRhCategoria(rhCategoria, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe la categoría...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente la categoría";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la categoría";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la categoría";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la categoría, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionRhCategoria",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public RhCategoriaTO getRhCategoriaTO(
            String empCodigo,
            String catNombre) throws Exception {
        return operacionesRRHHDAOLocal.getCategoria(
                empCodigo,
                catNombre);
    }

    @Override
    public List<RhComboCategoriaTO> getComboRhCategoriaTO(String empresa) throws Exception {
        return operacionesRRHHDAOLocal.getComboCategoria(empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="EMPLEADO">
    @Override
    public String insertarRhEmpleado(
            RhEmpleadoTO rhEmpleadoTO,
            List<RhEmpleadoDescuentosFijosTO> ListarhEmpleadoDescuentosFijosTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        mensaje = "";
        try {
            RhEmpleado rhEmpleado = operacionesRRHHDAOLocal.buscarEmpleado(
                    rhEmpleadoTO.getEmpCodigo(),
                    rhEmpleadoTO.getEmpId());
            if (rhEmpleado == null) {
                if (!operacionesRRHHDAOLocal.repetidoRhEmpleado(
                        rhEmpleadoTO.getEmpCodigo(),
                        rhEmpleadoTO.getEmpId(),
                        rhEmpleadoTO.getEmpApellidos(),
                        rhEmpleadoTO.getEmpNombres())) {

                    java.util.List<RhEmpleadoDescuentosFijos> listRhEmpleadoDescuentosFijos = new ArrayList();
                    RhEmpleadoDescuentosFijos obj = null;
                    boolean band = true;
                    RhAnticipoMotivo rhAnticipoMotivo = null;
                    for (RhEmpleadoDescuentosFijosTO rhEmpleadoDescuentosFijosTO : ListarhEmpleadoDescuentosFijosTO) {
                        //obj = operacionesRRHHDAOLocal.getRhEmpleadoDescuentosFijos(rhEmpleadoDescuentosFijosTO.getDescSecuencial());
                        rhAnticipoMotivo = operacionesRRHHDAOLocal.buscarAnticipoMotivo(rhEmpleadoDescuentosFijosTO.getMot_empresa(), rhEmpleadoDescuentosFijosTO.getMot_detalle());
                        if (rhAnticipoMotivo != null) {
                            obj = ConversionesRRHH.convertirRhEmpleadoDescuentosFijosTO_RhEmpleadoDescuentosFijos(rhEmpleadoDescuentosFijosTO);
                            listRhEmpleadoDescuentosFijos.add(obj);
                        } else {
                            band = false;
                            break;
                        }
                    }
                    if (band) {
                        ///// CREANDO Suceso
                        susClave = rhEmpleadoTO.getEmpId();
                        susDetalle = "Se ingresa a " + rhEmpleadoTO.getEmpApellidos() + " " + rhEmpleadoTO.getEmpNombres();
                        susSuceso = "INSERT";
                        susTabla = "recursoshumanos.rh_empleado";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);

                        rhEmpleadoTO.setUsrFechaInsertaEmpleado(Validacion.fechaSistema());
                        rhEmpleado = ConversionesRRHH.convertirRhEmpleadoTO_RhEmpleado(
                                rhEmpleadoTO);
                        comprobar = operacionesRRHHDAOTransaccionLocal.insertarRhEmpleado(rhEmpleado, sisSuceso, listRhEmpleadoDescuentosFijos);
                        mensaje = "TSe ingresó el empleado..";
                    } else {
                        mensaje = "FUno de los MOTIVO DE DESCUENTO ya no se encuentra disponible, inserte de NUEVO o cantactese con su administrador..";
                    }
                } else {
                    mensaje = "FEl empleado " + rhEmpleadoTO.getEmpApellidos() + " " + rhEmpleadoTO.getEmpNombres() + " ya existe..";
                }
            } else {
                mensaje = "FEl ID del empleado ya existe..";
            }
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhEmpleado",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public String guardarImagenEmpleado(byte[] imagen, String nombre) throws Exception {
        return guardarImagen(getRutaImagenEmpleado(), imagen, nombre, 510, 480);
    }

    @Override
    public String eliminarImagenEmpleado(String nombre) throws Exception {
        mensaje = "";
        if (eliminarArchivo(getRutaImagenEmpleado() + nombre + ".jpg")) {
            mensaje = "Imagen Eliminada con exito..";
        } else {
            mensaje = "No tiene una Imagen ah eliminar..";
        }
        return mensaje;
    }

    @Override
    public byte[] obtenerImagenEmpleado(String nombre) throws Exception {
        InputStream is = leerImagen(getRutaImagenEmpleado() + nombre + ".jpg");
        byte[] bytes = null;
        if (is != null) {
            bytes = new byte[is.available()];
            is.read(bytes);
        }
        return bytes;
    }

    @Override
    public String modificarRhEmpleado(
            RhEmpleadoTO rhEmpleadoTO, List<RhEmpleadoDescuentosFijosTO> listaModificar,
            List<RhEmpleadoDescuentosFijosTO> listaEliminar,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        mensaje = "";
        java.util.Date usrFechaInserta;
        try {
            RhEmpleado rhEmpleado = operacionesRRHHDAOLocal.buscarEmpleado(
                    rhEmpleadoTO.getEmpCodigo(),
                    rhEmpleadoTO.getEmpId());
            if (rhEmpleado != null) {
                if (!operacionesRRHHDAOLocal.repetidoRhEmpleado(
                        rhEmpleadoTO.getEmpCodigo(),
                        rhEmpleadoTO.getEmpId(),
                        rhEmpleadoTO.getEmpApellidos(),
                        rhEmpleadoTO.getEmpNombres())) {

                    java.util.List<RhEmpleadoDescuentosFijos> listModificarEntity = new ArrayList();
                    java.util.List<RhEmpleadoDescuentosFijos> listEliminarEntity = new ArrayList();
                    RhEmpleadoDescuentosFijos obj = null;
                    RhAnticipoMotivo rhAnticipoMotivo = null;
                    boolean band = true;
                    for (RhEmpleadoDescuentosFijosTO rhEmpleadoDescuentosFijosTO : listaModificar) {
                        rhAnticipoMotivo = operacionesRRHHDAOLocal.buscarAnticipoMotivo(rhEmpleadoDescuentosFijosTO.getMot_empresa(), rhEmpleadoDescuentosFijosTO.getMot_detalle());
                        if (rhAnticipoMotivo != null) {
                            obj = ConversionesRRHH.convertirRhEmpleadoDescuentosFijosTO_RhEmpleadoDescuentosFijos(rhEmpleadoDescuentosFijosTO);
                            listModificarEntity.add(obj);
                        } else {
                            band = false;
                            break;
                        }
                    }
                    for (RhEmpleadoDescuentosFijosTO rhEmpleadoDescuentosFijosTO : listaEliminar) {
                        rhAnticipoMotivo = operacionesRRHHDAOLocal.buscarAnticipoMotivo(rhEmpleadoDescuentosFijosTO.getMot_empresa(), rhEmpleadoDescuentosFijosTO.getMot_detalle());
                        if (rhAnticipoMotivo != null) {
                            obj = ConversionesRRHH.convertirRhEmpleadoDescuentosFijosTO_RhEmpleadoDescuentosFijos(rhEmpleadoDescuentosFijosTO);
                            listEliminarEntity.add(obj);
                        } else {
                            band = false;
                            break;
                        }
                    }

                    if (band) {
                        usrFechaInserta = rhEmpleado.getUsrFechaInserta();
                        ///// CREANDO Suceso
                        susClave = rhEmpleadoTO.getEmpId();
                        susDetalle = "Se modifica a " + rhEmpleadoTO.getEmpApellidos() + " " + rhEmpleadoTO.getEmpNombres();
                        susSuceso = "UPDATE";
                        susTabla = "recursoshumanos.rh_empleado";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);

                        rhEmpleado = ConversionesRRHH.convertirRhEmpleadoTO_RhEmpleado(rhEmpleadoTO);
                        rhEmpleado.setUsrFechaInserta(usrFechaInserta);
                        if (operacionesRRHHDAOLocal.getSwInactivaEmpleado(rhEmpleadoTO.getEmpCodigo(), rhEmpleadoTO.getEmpId())
                                || (!operacionesRRHHDAOLocal.getSwInactivaEmpleado(rhEmpleadoTO.getEmpCodigo(), rhEmpleadoTO.getEmpId()) && !rhEmpleadoTO.getEmpInactivo())) {
                            comprobar = operacionesRRHHDAOTransaccionLocal.modificarRhEmpleado(rhEmpleado, sisSuceso, listModificarEntity, listEliminarEntity);
                            mensaje = "TSe modificó el empleado..";
                        } else {
                            mensaje = "FNo se puede inactivar el empleado, tiene valores pendientes..";
                        }
                    } else {
                        mensaje = "FUno de los MOTIVO DE DESCUENTO ya no se encuentra disponible, inserte de NUEVO o cantactese con su administrador..";
                    }
                } else {
                    mensaje = "FEl empleado " + rhEmpleadoTO.getEmpApellidos() + " " + rhEmpleadoTO.getEmpNombres() + " ya existe..";
                }
            } else {
                mensaje = "FEl ID del empleado no existe..";
            }
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarRhEmpleado",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public String eliminarRhEmpleado(
            RhEmpleadoTO rhEmpleadoTO,
            List<RhEmpleadoDescuentosFijosTO> listaEliminar,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        mensaje = "";
        try {
            RhEmpleado rhEmpleado = operacionesRRHHDAOLocal.buscarEmpleado(
                    rhEmpleadoTO.getEmpCodigo(), rhEmpleadoTO.getEmpId());
            if (operacionesRRHHDAOLocal.eliminarRhEmpleado(rhEmpleadoTO) == true) {
                java.util.List<RhEmpleadoDescuentosFijos> listEliminarEntity = new ArrayList();
                RhEmpleadoDescuentosFijos obj = null;
                for (RhEmpleadoDescuentosFijosTO rhEmpleadoDescuentosFijosTO : listaEliminar) {
                    obj = ConversionesRRHH.convertirRhEmpleadoDescuentosFijosTO_RhEmpleadoDescuentosFijos(rhEmpleadoDescuentosFijosTO);
                    listEliminarEntity.add(obj);
                }
                ///// CREANDO Suceso
                susClave = rhEmpleadoTO.getEmpId();
                susDetalle = "Se elimina a " + rhEmpleadoTO.getEmpApellidos() + " " + rhEmpleadoTO.getEmpNombres();
                susSuceso = "DELETE";
                susTabla = "recursoshumanos.rh_empleado";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);

                rhEmpleadoTO.setUsrFechaInsertaEmpleado(Validacion.fechaSistema());
                rhEmpleado = ConversionesRRHH.convertirRhEmpleadoTO_RhEmpleado(rhEmpleadoTO);
                comprobar = operacionesRRHHDAOTransaccionLocal.eliminarRhEmpleado(rhEmpleado, sisSuceso, listEliminarEntity);
                mensaje = "TSe eliminó el empleado..";
            } else {
                mensaje = "FEl registro no se puede Eliminar puesto que tiene referencias..";
            }
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarRhEmpleado",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public List<RhEmpleadoTO> getListaRhEmpleadoTO(
            String empresa,
            String buscar,
            boolean estado) throws Exception {
        return operacionesRRHHDAOLocal.getListaEmpleado(
                empresa,
                buscar,
                estado);
    }

    @Override
    public List<RhListaEmpleadoTO> getListaConsultaEmpleadoTO(
            String empresa,
            String buscar,
            Boolean interno,
            boolean estado) throws Exception {
        return operacionesRRHHDAOLocal.getListaConsultaEmpleado(
                empresa,
                buscar,
                interno,
                estado);
    }

    @Override
    public List<RhListaEmpleadoLoteTO> getListaEmpleadoLoteTO(
            String empCodigo,
            String catNombre,
            String sector,
            String fechaHasta,
            String antMotivo) throws Exception {
        return operacionesRRHHDAOLocal.getListaEmpleadoLote(
                empCodigo,
                catNombre,
                sector,
                fechaHasta,
                antMotivo);
    }

    @Override
    public List<RhFunPlantillaSueldosLoteTO> getFunPlantillaSueldosLote(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String categoria,
            String sector) throws Exception {
        return operacionesRRHHDAOLocal.getFunPlantillaSueldosLote(
                empCodigo,
                fechaDesde,
                fechaHasta,
                categoria,
                sector);
    }

    @Override
    public List<RhFunPlantillaSueldosLotePreliminarTO> getFunPlantillaSueldosLotePreliminar(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String categoria,
            String sector) throws Exception {
        return operacionesRRHHDAOLocal.getFunPlantillaSueldosLotePreliminar(
                empCodigo,
                fechaDesde,
                fechaHasta,
                categoria,
                sector);
    }

    @Override
    public java.util.List<rrhh.TO.RhFunPlantillaRolesTO> getRhFunPlantillaRolesTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta,
            java.lang.String categoria,
            java.lang.String sector) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhFunPlantillaRolesTO(
                empresa,
                fechaDesde,
                fechaHasta,
                categoria,
                sector);
    }

    @Override
    public java.util.List<rrhh.TO.RhFunListadoEmpleadosTO> getRhFunListadoEmpleadosTO(
            java.lang.String empresa,
            java.lang.String provincia,
            java.lang.String canton,
            java.lang.String sector,
            java.lang.String categoria,
            boolean estado) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhFunListadoEmpleadosTO(
                empresa,
                provincia,
                canton,
                sector,
                categoria,
                estado);
    }
    // <editor-fold defaultstate="collapsed" desc="AVISO ENTRADA">

    @Override
    public String accionRhAvisosEntrada(
            RhAvisoEntradaTO rhAvisoEntradaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            rrhh.entity.RhEmpleado rhEmpleado = operacionesRRHHDAOLocal.buscarEmpleado(
                    rhAvisoEntradaTO.getEmpCodigo(),
                    rhAvisoEntradaTO.getUsrCodigo());
            if (rhEmpleado != null) {
                if (!rhEmpleado.getEmpInactivo()) {
                    ///// CREANDO Suceso
                    susClave = rhAvisoEntradaTO.getEmpId();
                    if (accion == 'I') {
                        susDetalle = "Se insertó Aviso Entrada para el empleado " + rhAvisoEntradaTO.getEmpNombres() + ":" + rhAvisoEntradaTO.getEmpId();
                        susSuceso = "INSERT";
                    }
                    if (accion == 'M') {
                        susDetalle = "Se modificó Aviso Entrada para el empleado " + rhAvisoEntradaTO.getEmpNombres() + ":" + rhAvisoEntradaTO.getEmpId();
                        susSuceso = "UPDATE";
                    }
                    if (accion == 'E') {
                        susDetalle = "Se eliminó Aviso Entrada para el empleado " + rhAvisoEntradaTO.getEmpNombres() + ":" + rhAvisoEntradaTO.getEmpId();
                        susSuceso = "DELETE";
                    }
                    susTabla = "recursoshumanos.rh_empleado";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    ///// CREANDO RhEmpleado
                    rrhh.TO.RhEmpleadoTO rhEmpleadoTO = rrhh.helper.ConversionesRRHH.convertirRhEmpleado_RhEmpleadoTO(rhEmpleado);
                    rhEmpleadoTO.setEmpCodigoAfiliacionIess(rhAvisoEntradaTO.getEmpCodigoAfiliacionIess());
                    rhEmpleadoTO.setEmpCodigoCargo(rhAvisoEntradaTO.getEmpCodigoCargoIess());
                    rhEmpleadoTO.setEmpFechaAfiliacionIess(rhAvisoEntradaTO.getEmpFechaAfiliacionIess());
                    rhEmpleadoTO.setEmpSueldoIess(rhAvisoEntradaTO.getEmpSueldoIess());
                    rrhh.entity.RhEmpleado rhEmpleadoAux = rrhh.helper.ConversionesRRHH.convertirRhEmpleadoTO_RhEmpleado(rhEmpleadoTO);
                    comprobar = operacionesRRHHDAOTransaccionLocal.accionRhAvisoEntrada(rhEmpleadoAux, sisSuceso, accion);
                    if (comprobar) {
                        if (accion == 'E') {
                            mensaje = "TSe eliminó correctamente Aviso Entrada:\n" + rhAvisoEntradaTO.getEmpNombres() + ":" + rhAvisoEntradaTO.getEmpId();
                        }
                        if (accion == 'M') {
                            mensaje = "TSe modificó correctamente Aviso Entrada:\n" + rhAvisoEntradaTO.getEmpNombres() + ":" + rhAvisoEntradaTO.getEmpId();
                        }
                        if (accion == 'I') {
                            mensaje = "TSe ingresó correctamente Aviso Entrada:\n" + rhAvisoEntradaTO.getEmpNombres() + ":" + rhAvisoEntradaTO.getEmpId();
                        }
                    }
                } else {
                    mensaje = "FEmpleado " + rhAvisoEntradaTO.getEmpNombres() + ":" + rhAvisoEntradaTO.getEmpId() + ", esta inactivo..";
                }
            } else {
                mensaje = "FNo existe el empleado " + rhAvisoEntradaTO.getEmpNombres() + ":" + rhAvisoEntradaTO.getEmpId() + "...";
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la compra forma pago, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionRhAvisosEntrada",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }
    // </editor-fold>
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMAPAGO">
    @Override
    public String accionRhFormaPago(
            RhFormaPagoTO rhFormaPagoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        Boolean estadoCtaComprasForma = false;
        Boolean estadoSector = false;
        try {
            ///// BUSCANDO existencia cuentas
            estadoCtaComprasForma = operacionesContabilidadDAOLocal.buscarCuentas(
                    rhFormaPagoTO.getUsrEmpresa(),
                    rhFormaPagoTO.getCtaCodigo()) != null ? true : false;
            ///// BUSCANDO existencia sector
            estadoSector = operacionesProduccionDAOLocal.buscarSector(
                    rhFormaPagoTO.getUsrEmpresa(),
                    rhFormaPagoTO.getSecCodigo()) != null ? true : false;
            if (estadoCtaComprasForma && estadoSector) {//revisar si estan llenos
                ///// CREANDO Suceso
                susClave = rhFormaPagoTO.getFpDetalle();
                if (accion == 'I') {
                    susDetalle = "Se insertó la FormaPago con el detalle " + rhFormaPagoTO.getFpDetalle();
                    susSuceso = "INSERT";
                }
                if (accion == 'M') {
                    susDetalle = "Se modificó la FormaPago con el detalle " + rhFormaPagoTO.getFpDetalle();
                    susSuceso = "UPDATE";
                }
                if (accion == 'E') {
                    susDetalle = "Se eliminó la FormaPago con el detalle " + rhFormaPagoTO.getFpDetalle();
                    susSuceso = "DELETE";
                }
                susTabla = "recursoshumanos.rh_forma_pago";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                ///// CREANDO CarPagosForma
                rhFormaPagoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                rrhh.entity.RhFormaPago rhFormaPago = rrhh.helper.ConversionesRRHH.convertirRhFormaPagoTO_RhFormaPago(rhFormaPagoTO);
                if (accion == 'E') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesRRHHDAOLocal.buscarFormaPago(
                            rhFormaPagoTO.getFpSecuencial()) != null) {
                        rhFormaPago.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesRRHHDAOTransaccionLocal.accionRhFormaPago(rhFormaPago, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra forma de pago...";
                    }
                }
                if (accion == 'M') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesRRHHDAOLocal.buscarFormaPago(
                            rhFormaPagoTO.getFpSecuencial()) != null) {
                        rhFormaPago.setUsrFechaInserta(
                                operacionesRRHHDAOLocal.buscarFormaPago(
                                rhFormaPagoTO.getFpSecuencial()).getUsrFechaInserta());
                        comprobar = operacionesRRHHDAOTransaccionLocal.accionRhFormaPago(rhFormaPago, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra forma de pago...";
                    }
                }
                if (accion == 'I') {
                    ////// BUSCANDO existencia PagosForma
                    if (!operacionesRRHHDAOLocal.buscarRhFormaPago(
                            rhFormaPagoTO.getCtaCodigo(),
                            rhFormaPagoTO.getUsrEmpresa())) {
                        rhFormaPago.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesRRHHDAOTransaccionLocal.accionRhFormaPago(rhFormaPago, sisSuceso, accion);
                    } else {
                        mensaje = "FYa existe la forma de pago...";
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
                    mensaje = "TSe eliminó correctamente la Forma de Pagos";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la Forma de Pagos";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la Forma de Pagos";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la compra forma pago, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionRhFormaPago",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public List<RhListaFormaPagoTO> getListaFormaPagoTO(String empresa) throws Exception {
        return operacionesRRHHDAOLocal.getListaFormaPago(empresa);
    }

    @Override
    public List<RhComboFormaPagoTO> getComboFormaPagoTO(String empresa) throws Exception {
        return operacionesRRHHDAOLocal.getComboFormaPago(empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMAPAGOBENEFICIOSOCIAL">
    @Override
    public String accionRhFormaPagoBeneficioSocial(
            RhFormaPagoBeneficioSocialTO rhFormaPagoBeneficioSocialTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        Boolean estadoCtaComprasForma = false;
        Boolean estadoSector = false;
        try {
            ///// BUSCANDO existencia cuentas
            estadoCtaComprasForma = operacionesContabilidadDAOLocal.buscarCuentas(
                    rhFormaPagoBeneficioSocialTO.getUsrEmpresa(),
                    rhFormaPagoBeneficioSocialTO.getCtaCodigo()) != null ? true : false;
            ///// BUSCANDO existencia sector
            estadoSector = operacionesProduccionDAOLocal.buscarSector(
                    rhFormaPagoBeneficioSocialTO.getUsrEmpresa(),
                    rhFormaPagoBeneficioSocialTO.getSecCodigo()) != null ? true : false;
            if (estadoCtaComprasForma && estadoSector) {//revisar si estan llenos
                ///// CREANDO Suceso
                susClave = rhFormaPagoBeneficioSocialTO.getFpDetalle();
                if (accion == 'I') {
                    susDetalle = "Se insertó la FormaPago con el detalle " + rhFormaPagoBeneficioSocialTO.getFpDetalle();
                    susSuceso = "INSERT";
                }
                if (accion == 'M') {
                    susDetalle = "Se modificó la FormaPago con el detalle " + rhFormaPagoBeneficioSocialTO.getFpDetalle();
                    susSuceso = "UPDATE";
                }
                if (accion == 'E') {
                    susDetalle = "Se eliminó la FormaPago con el detalle " + rhFormaPagoBeneficioSocialTO.getFpDetalle();
                    susSuceso = "DELETE";
                }
                susTabla = "recursoshumanos.rh_forma_pago";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                ///// CREANDO CarPagosForma
                rhFormaPagoBeneficioSocialTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                rrhh.entity.RhFormaPagoBeneficiosSociales rhFormaPagoBeneficiosSociales = rrhh.helper.ConversionesRRHH.convertirRhFormaPagoBeneficioSocialTO_RhFormaPagoBeneficioSocial(rhFormaPagoBeneficioSocialTO);

                if (accion == 'E') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesRRHHDAOLocal.buscarFormaPagoBeneficioSocial(
                            rhFormaPagoBeneficioSocialTO.getFpSecuencial()) != null) {
                        rhFormaPagoBeneficiosSociales.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesRRHHDAOTransaccionLocal.accionRhFormaPagoBeneficioSocial(rhFormaPagoBeneficiosSociales, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra forma de pago...";
                    }
                }
                if (accion == 'M') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesRRHHDAOLocal.buscarFormaPagoBeneficioSocial(
                            rhFormaPagoBeneficioSocialTO.getFpSecuencial()) != null) {
                        rhFormaPagoBeneficiosSociales.setUsrFechaInserta(
                                operacionesRRHHDAOLocal.buscarFormaPagoBeneficioSocial(
                                rhFormaPagoBeneficioSocialTO.getFpSecuencial()).getUsrFechaInserta());
                        comprobar = operacionesRRHHDAOTransaccionLocal.accionRhFormaPagoBeneficioSocial(rhFormaPagoBeneficiosSociales, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra forma de pago...";
                    }
                }
                if (accion == 'I') {
                    ////// BUSCANDO existencia PagosForma
                    if (!operacionesRRHHDAOLocal.buscarRhFormaPagoBeneficioSocial(
                            rhFormaPagoBeneficioSocialTO.getCtaCodigo(),
                            rhFormaPagoBeneficioSocialTO.getUsrEmpresa())) {
                        rhFormaPagoBeneficiosSociales.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesRRHHDAOTransaccionLocal.accionRhFormaPagoBeneficioSocial(rhFormaPagoBeneficiosSociales, sisSuceso, accion);
                    } else {
                        mensaje = "FYa existe la forma de pago...";
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
                    mensaje = "TSe eliminó correctamente la Forma de Pagos (BeneficioSocial)";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la Forma de Pagos (BeneficioSocial)";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la Forma de Pagos (BeneficioSocial)";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la compra forma pago, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionRhFormaPago",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public List<RhListaFormaPagoBeneficioSocialTO> getListaFormaPagoBeneficioSocialTO(String empresa) throws Exception {
        return operacionesRRHHDAOLocal.getListaFormaPagoBeneficioSocial(empresa);
    }

    @Override
    public List<RhComboFormaPagoBeneficioSocialTO> getComboFormaPagoBeneficioSocialTO(String empresa) throws Exception {
        return operacionesRRHHDAOLocal.getComboFormaPagoBeneficioSocial(empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ANTICIPO POR LOTES">
    @Override
    public RhContableTO insertarRhAnticipoConContable(
            RhAnticipoCabeceraTO rhAnticipoCabeceraTO,
            List<RhAnticipoDetalleTO> rhAnticipoDetalleTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        List<RhAnticipoTO> rhAnticipoTOs = new java.util.ArrayList();
        List<rrhh.entity.RhAnticipo> rhAnticipos = new java.util.ArrayList();
        List<String> listaEmpleadoTO = new java.util.ArrayList(1);
        java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
        RhAnticipoTO rhAnticipoTo = null;
        RhContableTO rhContableTO = new RhContableTO();
        RhCtaFormaPagoTO rhCtaFormaPagoTO = new RhCtaFormaPagoTO();
        mensaje = "F";
        String tipDetalle = "C-ANT";
        String perCodigo = "";
        String ctaRhFormasPago = null;
        String ctaRhAnticipo = "";
        BigDecimal antValor = cero;
        //Suceso
        String detalle = null;
        BigDecimal valor = cero;
        try {
            //periodo
            List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(rhAnticipoCabeceraTO.getEmpCodigo());
            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (Validacion.fecha(rhAnticipoCabeceraTO.getAntFecha(), "yyyy-MM-dd").getTime()
                        >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && Validacion.fecha(rhAnticipoCabeceraTO.getAntFecha(), "yyyy-MM-dd").getTime()
                        <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                        && sisListaPeriodoTO.getPerCerrado() == false) {
                    perCodigo = sisListaPeriodoTO.getPerCodigo();
                    break;
                }
            }
            for (RhAnticipoDetalleTO rhAnticipoDetalleTO : rhAnticipoDetalleTOs) {
                comprobar = false;
                rhAnticipoTo = new RhAnticipoTO();
                //fecha ultimo sueldo
                String fechaUltimoSueldo = operacionesRRHHDAOLocal.buscarFechaRhRol(
                        rhAnticipoCabeceraTO.getEmpCodigo(), rhAnticipoDetalleTO.getEmpId());
                if (fechaUltimoSueldo.isEmpty()) {
                    comprobar = true;
                } else {
                    comprobar = Validacion.fecha(rhAnticipoCabeceraTO.getAntFecha(), "yyyy-MM-dd").getTime()
                            > Validacion.fecha(fechaUltimoSueldo, "yyyy-MM-dd").getTime();
                }
                if (comprobar) {
                    //llenar rhAnticipoTO
//                    if(rhAnticipoDetalleTO.getAntFormasPago()!= null){
//                        rhAnticipoTo.setEmpCodigo(rhAnticipoCabeceraTO.getEmpCodigo());
//                        rhAnticipoTo.setPerCodigo(perCodigo);
//                        rhAnticipoTo.setTipCodigo(tipDetalle);
//                        rhAnticipoTo.setConNumero("");
//                        rhAnticipoTo.setSecCodigo(rhAnticipoDetalleTO.getSecCodigo());
//                        rhAnticipoTo.setEmpId(rhAnticipoDetalleTO.getEmpId());
//                        rhAnticipoTo.setEmpApellidosNombres(rhAnticipoDetalleTO.getEmpApellidosNombres());
//                        rhAnticipoTo.setAntFecha(rhAnticipoCabeceraTO.getAntFecha());
//                        rhAnticipoTo.setAntValor(rhAnticipoDetalleTO.getAntValor());
//                        rhAnticipoTo.setAntFormasPago(rhAnticipoDetalleTO.getAntFormasPago());
//                        rhAnticipoTo.setConDetDocumento(rhAnticipoDetalleTO.getConDetDocumento());
//                        rhAnticipoTo.setConObservaciones(rhAnticipoCabeceraTO.getConObservaciones());
//                        rhAnticipoTo.setReversar(rhAnticipoCabeceraTO.getReversar());
//                        rhAnticipoTo.setUsrInsertaAnticipo(rhAnticipoCabeceraTO.getUsrInsertaAnticipo());
//                    }else{
                    rhAnticipoTo.setEmpCodigo(rhAnticipoCabeceraTO.getEmpCodigo());
                    rhAnticipoTo.setPerCodigo(perCodigo);
                    rhAnticipoTo.setTipCodigo(tipDetalle);
                    rhAnticipoTo.setConNumero("");
                    rhAnticipoTo.setSecCodigo(rhAnticipoDetalleTO.getSecCodigo());
                    rhAnticipoTo.setEmpId(rhAnticipoDetalleTO.getEmpId());
                    rhAnticipoTo.setEmpApellidosNombres(rhAnticipoDetalleTO.getEmpApellidosNombres());
                    rhAnticipoTo.setAntFecha(rhAnticipoCabeceraTO.getAntFecha());
                    rhAnticipoTo.setAntValor(rhAnticipoDetalleTO.getAntValor());
                    rhAnticipoTo.setAntFormasPago(rhAnticipoCabeceraTO.getAntFormasPago());
                    rhAnticipoTo.setConDetDocumento(rhAnticipoCabeceraTO.getConDetDocumento());
                    rhAnticipoTo.setConObservaciones(rhAnticipoCabeceraTO.getConObservaciones());
                    rhAnticipoTo.setReversar(rhAnticipoCabeceraTO.getReversar());
                    rhAnticipoTo.setUsrInsertaAnticipo(rhAnticipoCabeceraTO.getUsrInsertaAnticipo());
                    rhAnticipoTo.setAntSecuencial(0);
                    //}

                    rhAnticipoTo.setAntSecuencial(0);

                    rhAnticipoTOs.add(rhAnticipoTo);
                    antValor = antValor.add(rhAnticipoDetalleTO.getAntValor());
                } else {
                    listaEmpleadoTO.add(rhAnticipoDetalleTO.getEmpApellidosNombres());
                }
            }
            if (!perCodigo.isEmpty()) {
                if (rhAnticipoDetalleTOs.size() == rhAnticipoTOs.size()) {
                    comprobar = false;
                    if (operacionesContabilidadDAOLocal.buscarTipoContable(rhAnticipoCabeceraTO.getEmpCodigo(), tipDetalle)) {
                        //llenar contable
                        ConContableTO conContableTO = new ConContableTO();
                        conContableTO.setEmpCodigo(rhAnticipoCabeceraTO.getEmpCodigo());
                        conContableTO.setPerCodigo(perCodigo);
                        conContableTO.setTipCodigo(tipDetalle);
                        conContableTO.setConFecha(rhAnticipoCabeceraTO.getAntFecha());
                        conContableTO.setConPendiente(false);
                        conContableTO.setConBloqueado(false);
                        conContableTO.setConAnulado(false);
                        conContableTO.setConGenerado(true);
                        if (rhAnticipoDetalleTOs.size() == 1) {
                            conContableTO.setConConcepto(rhAnticipoDetalleTOs.get(0).getEmpApellidosNombres());//nombre empleado
                        } else {
                            conContableTO.setConConcepto("ANTICIPOS POR LOTES");//nombre empleado
                        }
                        conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                        conContableTO.setConObservaciones(rhAnticipoCabeceraTO.getConObservaciones());
                        conContableTO.setUsrInsertaContable(rhAnticipoCabeceraTO.getUsrInsertaAnticipo());
                        conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                        ///// CREANDO UN SUCESO
                        susClave = "";
                        susSuceso = "INSERT";
                        susTabla = "recursoshumanos.rh_anticipo";
                        ////// CREANDO NUMERACION
                        contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                                conContableTO.getTipCodigo()));
                        ////// CREANDO CONTABLE
                        contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                        ////// CREANDO ANTICIPO
                        for (int j = 0; j < rhAnticipoTOs.size(); j++) {
                            rhAnticipos.add(rrhh.helper.ConversionesRRHH.convertirRhAnticipoTO_RhAnticipo(rhAnticipoTOs.get(j)));
                            rhAnticipos.get(j).setRhEmpleado(operacionesRRHHDAOLocal.buscarEmpleado(
                                    rhAnticipoTOs.get(j).getEmpCodigo(), rhAnticipoTOs.get(j).getEmpId()));
                            rhAnticipos.get(j).setAntReversado(false);
                            ConDetalle conDetalle = null;
                            if (j < 1) {
                                for (int i = 0; i < 2; i++) {
                                    ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                    conDetalle = new ConDetalle();
                                    conDetalle.setConContable(conContable);
                                    conDetalle.setDetSecuencia(0);
                                    conDetalle.setDetDocumento("");
                                    conDetalle.setSecCodigo(rhAnticipoTOs.get(j).getSecCodigo());
                                    conDetalle.setPisNumero("");
                                    conDetalle.setDetValor(antValor);
                                    conDetalle.setDetGenerado(true);
                                    if (i == 0) {
                                        ctaRhAnticipo = operacionesRRHHDAOLocal.buscarCtaRhAnticipo(
                                                rhAnticipoTOs.get(j).getEmpCodigo(),
                                                rhAnticipoTOs.get(j).getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhAnticipoTOs.get(j).getEmpCodigo(),
                                                (ctaRhAnticipo == null) ? "" : ctaRhAnticipo));//categoria
                                        conDetalle.setDetDebitoCredito(rhAnticipoTOs.get(j).getReversar() ? 'C' : 'D');
                                        conDetalle.setDetReferencia("ANT");//
                                        conDetalle.setDetOrden(i + 1);//
                                        listaConDetalle.add(i, conDetalle);
                                    }
                                    if (i == 1) {
                                        //FORMA PAGO////////////////////////
                                        rhCtaFormaPagoTO = operacionesRRHHDAOLocal.buscarCtaRhFormaPago(
                                                rhAnticipoTOs.get(j).getEmpCodigo(),
                                                rhAnticipoTOs.get(j).getAntFormasPago());
                                        if (rhCtaFormaPagoTO.getCtaCodigo() != null) {
                                            ctaRhFormasPago = rhCtaFormaPagoTO.getCtaCodigo();
                                            conDetalle.setSecCodigo(rhCtaFormaPagoTO.getSecCodigo());
                                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhAnticipoTOs.get(j).getEmpCodigo(),
                                                    (ctaRhFormasPago == null) ? "" : ctaRhFormasPago));//categoria
                                            conDetalle.setDetDebitoCredito(rhAnticipoTOs.get(j).getReversar() ? 'D' : 'C');
                                            conDetalle.setDetDocumento(rhAnticipoTOs.get(j).getConDetDocumento());
                                            conDetalle.setDetReferencia("FP");//
                                            conDetalle.setDetOrden(i + 1);//
                                            valor = valor.add(conDetalle.getDetValor());
                                            listaConDetalle.add(i, conDetalle);
                                        }
                                    }
                                    conDetalle = null;
                                }
                            }
                        }

                        ctaRhAnticipo = ctaRhAnticipo == null ? "" : ctaRhAnticipo;
                        ctaRhFormasPago = ctaRhFormasPago == null ? "" : ctaRhFormasPago;
                        comprobar = false;
                        if (!ctaRhAnticipo.isEmpty() && !ctaRhFormasPago.isEmpty()) {//revisar si estan llenos
                            if (rhAnticipos.size() == 1) {
                                susDetalle = "Anticipo a " + operacionesRRHHDAOLocal.getRhEmpleadoApellidosNombres(
                                        rhAnticipos.get(0).getRhEmpleado().getRhEmpleadoPK().getEmpEmpresa(),
                                        rhAnticipos.get(0).getRhEmpleado().getRhEmpleadoPK().getEmpId()) + " por $" + valor.toPlainString();
                            } else {
                                susDetalle = "Anticipo total a varios empleados por $" + valor.toPlainString();
                            }
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            comprobar = operacionesRRHHDAOTransaccionLocal.insertarRhAnticipo(
                                    rhAnticipos,
                                    conContable,
                                    listaConDetalle,
                                    sisSuceso,
                                    conNumeracion,
                                    sisInfoTO);
                        } else if (ctaRhAnticipo.isEmpty()) {
                            mensaje = "FNo se encuentra la cuenta contable de Anticipo...";
                        }
                        if (ctaRhFormasPago.isEmpty()) {
                            mensaje = "FNo se encuentra la cuenta contable de forma de pago__...";
                        }
                        if (comprobar) {
                            sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                            contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                            mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";

                            rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                            rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                            rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                        }
                    } else {
                        mensaje = "FNo se encuentra tipo de contable...";
                    }
                } else {
                    mensaje = "FFecha del anticipo incompatible con los siguientes empleado:";
                }
            } else {
                mensaje = "FNo se encuentra ningún periodo para la fecha que ingresó\nNo esta creado o esta cerrado...";
            }
            rhContableTO.setMensaje(mensaje);
            rhContableTO.setListaEmpleadoTO(listaEmpleadoTO);
            return rhContableTO;
//            }
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhAnticipoConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PRESTAMO">
    @Override
    public RhContableTO insertarRhPrestamoConContable(
            RhPrestamoTO rhPrestamoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        RhContableTO rhContableTO = new RhContableTO();
        RhCtaFormaPagoTO rhCtaFormaPagoTO = new RhCtaFormaPagoTO();
        String tipDetalle = "C-PRE";
        mensaje = "F";
        String ctaRhFormasPago = null;
        String ctaRhPrestamo = "";
        BigDecimal valor = cero;
        try {
            comprobar = false;
            //periodo
            List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(rhPrestamoTO.getEmpCodigo());

            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (Validacion.fecha(rhPrestamoTO.getPreFecha(), "yyyy-MM-dd").getTime()
                        >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && Validacion.fecha(rhPrestamoTO.getPreFecha(), "yyyy-MM-dd").getTime()
                        <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                        && sisListaPeriodoTO.getPerCerrado() == false) {
                    comprobar = true;
                    rhPrestamoTO.setPerCodigo(sisListaPeriodoTO.getPerCodigo());
                    break;
                }
            }
            if (comprobar) {
                comprobar = false;
                if (operacionesContabilidadDAOLocal.buscarTipoContable(rhPrestamoTO.getEmpCodigo(), tipDetalle)) {
                    //llenar contable
                    ConContableTO conContableTO = new ConContableTO();
                    conContableTO.setEmpCodigo(rhPrestamoTO.getEmpCodigo());
                    conContableTO.setPerCodigo(rhPrestamoTO.getPerCodigo());
                    conContableTO.setTipCodigo(tipDetalle);
                    rhPrestamoTO.setTipCodigo(tipDetalle);
                    conContableTO.setConFecha(rhPrestamoTO.getPreFecha());
                    conContableTO.setConPendiente(false);
                    conContableTO.setConBloqueado(false);
                    conContableTO.setConAnulado(false);
                    conContableTO.setConGenerado(true);
                    conContableTO.setConConcepto(rhPrestamoTO.getEmpApellidosNombres());//nombre empleado
                    conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                    conContableTO.setConObservaciones(rhPrestamoTO.getConObservaciones());
                    conContableTO.setUsrInsertaContable(rhPrestamoTO.getUsrInsertaPrestamo());
                    conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                    ///// CREANDO UN SUCESO
                    susClave = rhPrestamoTO.getPerCodigo() + " "
                            + rhPrestamoTO.getTipCodigo() + " "
                            + rhPrestamoTO.getConNumero();
                    susSuceso = "INSERT";
                    susTabla = "recursoshumanos.rh_Prestamo";
                    ////// CREANDO NUMERACION
                    contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                            conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                            conContableTO.getTipCodigo()));
                    ////// CREANDO CONTABLE
                    contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                    ////// CREANDO Prestamo
                    rrhh.entity.RhPrestamo rhPrestamo = rrhh.helper.ConversionesRRHH.convertirRhPrestamoTO_RhPrestamo(rhPrestamoTO);
                    rhPrestamo.setPreReversado(false);
                    ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                    java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                    ConDetalle conDetalle = null;
                    for (int i = 0; i < 2; i++) {
                        conDetalle = new ConDetalle();
                        conDetalle.setConContable(conContable);
                        conDetalle.setDetSecuencia(2);
                        conDetalle.setDetDocumento("");
                        conDetalle.setPisNumero(null);
                        conDetalle.setDetValor(rhPrestamoTO.getPreValor());
                        conDetalle.setDetGenerado(true);
                        conDetalle.setDetSaldo(new BigDecimal(20));
                        if (i == 0) {
                            conDetalle.setSecCodigo(rhPrestamoTO.getSecCodigo());
                            ctaRhPrestamo = operacionesRRHHDAOLocal.buscarCtaRhPrestamo(
                                    rhPrestamoTO.getEmpCodigo(),
                                    rhPrestamoTO.getEmpId());
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhPrestamoTO.getEmpCodigo(),
                                    (ctaRhPrestamo == null) ? "" : ctaRhPrestamo));//categoria
                            conDetalle.setDetDebitoCredito(rhPrestamoTO.getReversar() ? 'C' : 'D');
                            conDetalle.setDetReferencia("PRE");//
                            conDetalle.setDetOrden(i + 1);//
                            conDetalle.setDetSaldo(new BigDecimal(20));
                            listaConDetalle.add(i, conDetalle);
                        }
                        if (i == 1) {
                            rhCtaFormaPagoTO = operacionesRRHHDAOLocal.buscarCtaRhFormaPago(
                                    rhPrestamoTO.getEmpCodigo(),
                                    rhPrestamoTO.getPreFormasPago());
                            if (rhCtaFormaPagoTO.getCtaCodigo() != null) {
                                if (rhCtaFormaPagoTO.getCtaCodigo() != null) {
                                    ctaRhFormasPago = rhCtaFormaPagoTO.getCtaCodigo();
                                    conDetalle.setSecCodigo(rhCtaFormaPagoTO.getSecCodigo());
                                    conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhPrestamoTO.getEmpCodigo(),
                                            (ctaRhFormasPago == null) ? "" : ctaRhFormasPago));//forma pago
                                    conDetalle.setDetDebitoCredito(rhPrestamoTO.getReversar() ? 'D' : 'C');
                                    conDetalle.setDetDocumento(rhPrestamoTO.getConDetDocumento());
                                    conDetalle.setDetReferencia("FP");//
                                    conDetalle.setDetOrden(i + 1);//
                                    valor = valor.add(conDetalle.getDetValor());
                                    conDetalle.setDetSaldo(new BigDecimal(20));
                                    listaConDetalle.add(i, conDetalle);
                                }
                            }
                        }
                        conDetalle = null;
                    }

                    ctaRhPrestamo = ctaRhPrestamo == null ? "" : ctaRhPrestamo;
                    ctaRhFormasPago = ctaRhFormasPago == null ? "" : ctaRhFormasPago;
                    comprobar = false;
                    if (!ctaRhPrestamo.isEmpty() && !ctaRhFormasPago.isEmpty()) {//revisar si estan llenos
                        susDetalle = "Préstamo a " + operacionesRRHHDAOLocal.getRhEmpleadoApellidosNombres(
                                rhPrestamo.getRhEmpleado().getRhEmpleadoPK().getEmpEmpresa(),
                                rhPrestamo.getRhEmpleado().getRhEmpleadoPK().getEmpId()) + " por $" + valor.toPlainString();
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        comprobar = operacionesRRHHDAOTransaccionLocal.insertarRhPrestamo(
                                rhPrestamo,
                                conContable,
                                listaConDetalle,
                                sisSuceso,
                                conNumeracion,
                                sisInfoTO);
                    } else if (ctaRhPrestamo.isEmpty()) {
                        mensaje = "FNo se encuentra la cuenta contable de Préstamos...";
                    }
                    if (ctaRhFormasPago.isEmpty()) {
                        mensaje = "FNo se encuentra la cuenta contable de forma de pago...";
                    }
                    if (comprobar) {
                        sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                        contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                        mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";

                        rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                        rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                        rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                    }
                } else {
                    mensaje = "FNo se encuentra tipo de contable...";
                }
            } else {
                mensaje = "FNo se encuentra ningún periodo para la fecha que ingresó\nNo esta creado o esta cerrado...";
            }
//            }else
//                mensaje = "FFecha del Prestamo tiene que ser mayor a la fecha del ultimo sueldo...";
            rhContableTO.setMensaje(mensaje);
            return rhContableTO;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhPrestamoConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VIATICO">
    @Override
    public RhContableTO insertarRhViaticoConContable(
            RhViaticoTO rhViaticoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        RhContableTO rhContableTO = new RhContableTO();
        String tipDetalle = "C-VIA";
        mensaje = "F";
        String ctaRhFormasPago = null;
        String ctaRhViatico = "";
        BigDecimal valor = cero;
        try {
            //fecha ultimo sueldo
            String fechaUltimoSueldo = operacionesRRHHDAOLocal.buscarFechaRhRol(
                    rhViaticoTO.getEmpCodigo(), rhViaticoTO.getEmpId());
            if (fechaUltimoSueldo.isEmpty()) {
                comprobar = true;
            } else {
                comprobar = Validacion.fecha(rhViaticoTO.getViaFecha(), "yyyy-MM-dd").getTime()
                        > Validacion.fecha(fechaUltimoSueldo, "yyyy-MM-dd").getTime();
            }
            if (comprobar) {
                comprobar = false;
                //periodo
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(rhViaticoTO.getEmpCodigo());

                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (Validacion.fecha(rhViaticoTO.getViaFecha(), "yyyy-MM-dd").getTime()
                            >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && Validacion.fecha(rhViaticoTO.getViaFecha(), "yyyy-MM-dd").getTime()
                            <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                            && sisListaPeriodoTO.getPerCerrado() == false) {
                        comprobar = true;
                        rhViaticoTO.setPerCodigo(sisListaPeriodoTO.getPerCodigo());
                        break;
                    }
                }
                if (comprobar) {
                    comprobar = false;
                    if (operacionesContabilidadDAOLocal.buscarTipoContable(rhViaticoTO.getEmpCodigo(), tipDetalle)) {
                        //llenar contable
                        ConContableTO conContableTO = new ConContableTO();
                        conContableTO.setEmpCodigo(rhViaticoTO.getEmpCodigo());
                        conContableTO.setPerCodigo(rhViaticoTO.getPerCodigo());
                        conContableTO.setTipCodigo(tipDetalle);
                        rhViaticoTO.setTipCodigo(tipDetalle);
                        conContableTO.setConFecha(rhViaticoTO.getViaFecha());
                        conContableTO.setConPendiente(false);
                        conContableTO.setConBloqueado(false);
                        conContableTO.setConAnulado(false);
                        conContableTO.setConGenerado(true);
                        conContableTO.setConConcepto(rhViaticoTO.getEmpApellidosNombres());//nombre empleado
                        conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                        conContableTO.setConObservaciones(rhViaticoTO.getConObservaciones());
                        conContableTO.setUsrInsertaContable(rhViaticoTO.getUsrInsertaViatico());
                        conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                        ///// CREANDO UN SUCESO
                        susClave = rhViaticoTO.getPerCodigo() + " "
                                + rhViaticoTO.getTipCodigo() + " "
                                + rhViaticoTO.getConNumero();
                        susSuceso = "INSERT";
                        susTabla = "recursoshumanos.rh_Viatico";
                        ////// CREANDO NUMERACION
                        contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                                conContableTO.getTipCodigo()));
                        ////// CREANDO CONTABLE
                        contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                        ////// CREANDO Viatico
                        rrhh.entity.RhViatico rhViatico = rrhh.helper.ConversionesRRHH.convertirRhViaticoTO_RhViatico(rhViaticoTO);
                        rhViatico.setViaReversado(false);
                        ////// BUSCANDO AFILIACION
                        RhCtaIessTO rhCtaIessTO = operacionesRRHHDAOLocal.buscarCtaRhIess(
                                rhViaticoTO.getEmpCodigo(),
                                rhViaticoTO.getEmpId());
                        ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                        java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                        ConDetalle conDetalle = null;
                        for (int i = 0; i < 2; i++) {
                            conDetalle = new ConDetalle();
                            conDetalle.setConContable(conContable);
                            conDetalle.setDetSecuencia(0);
                            conDetalle.setDetDocumento("");
                            conDetalle.setSecCodigo(rhViaticoTO.getSecCodigo());
                            conDetalle.setPisNumero(null);
                            conDetalle.setDetValor(rhViaticoTO.getViaValor());
                            conDetalle.setDetGenerado(true);
                            if (i == 0) {
                                if (rhCtaIessTO != null) {
                                    if (rhCtaIessTO.getEmpFechaAfiliacionIess() != null) {
                                        ctaRhViatico = operacionesRRHHDAOLocal.buscarCtaRhGastoViaticos(
                                                rhViaticoTO.getEmpCodigo(),
                                                rhViaticoTO.getEmpId());
                                    } else {
                                        ctaRhViatico = operacionesRRHHDAOLocal.buscarCtaRhGastoBonosND(
                                                rhViaticoTO.getEmpCodigo(),
                                                rhViaticoTO.getEmpId());
                                    }
                                }
                                conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhViaticoTO.getEmpCodigo(),
                                        (ctaRhViatico == null) ? "" : ctaRhViatico));//categoria
                                conDetalle.setDetDebitoCredito(rhViaticoTO.getReversar() ? 'C' : 'D');
                                conDetalle.setDetReferencia("VIA");//
                                conDetalle.setDetOrden(i + 1);//
                                listaConDetalle.add(i, conDetalle);
                            }
                            if (i == 1) {
                                ctaRhFormasPago = operacionesRRHHDAOLocal.buscarCtaRhPorPagarViaticos(
                                        rhViaticoTO.getEmpCodigo(),
                                        rhViaticoTO.getEmpId());
                                conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhViaticoTO.getEmpCodigo(),
                                        (ctaRhFormasPago == null) ? "" : ctaRhFormasPago));//categoria
                                conDetalle.setDetDebitoCredito(rhViaticoTO.getReversar() ? 'D' : 'C');
                                conDetalle.setDetReferencia("FP");//
                                conDetalle.setDetOrden(i + 1);//
                                valor = valor.add(conDetalle.getDetValor());
                                listaConDetalle.add(i, conDetalle);
                            }
                            conDetalle = null;
                        }
                        ctaRhViatico = ctaRhViatico == null ? "" : ctaRhViatico;
                        ctaRhFormasPago = ctaRhFormasPago == null ? "" : ctaRhFormasPago;
                        comprobar = false;
                        if (!ctaRhViatico.isEmpty() && !ctaRhFormasPago.isEmpty()) {//revisar si estan llenos
                            susDetalle = "Viático a " + operacionesRRHHDAOLocal.getRhEmpleadoApellidosNombres(
                                    rhViatico.getRhEmpleado().getRhEmpleadoPK().getEmpEmpresa(),
                                    rhViatico.getRhEmpleado().getRhEmpleadoPK().getEmpId()) + " por $" + valor.toPlainString();
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            comprobar = operacionesRRHHDAOTransaccionLocal.insertarRhViatico(
                                    rhViatico,
                                    conContable,
                                    listaConDetalle,
                                    sisSuceso,
                                    conNumeracion,
                                    sisInfoTO);
                        } else if (ctaRhViatico.isEmpty()) {
                            mensaje = "FNo se encuentra la cuenta contable de Viáticos...";
                        }
                        if (ctaRhFormasPago.isEmpty()) {
                            mensaje = "FNo se encuentra la cuenta contable de forma de pago...";
                        }
                        if (comprobar) {
                            sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                            contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                            mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";

                            rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                            rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                            rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                        }
                    } else {
                        mensaje = "FNo se encuentra tipo de contable...";
                    }
                } else {
                    mensaje = "FNo se encuentra ningún periodo para la fecha que ingresó\nNo esta creado o esta cerrado...";
                }
            } else {
                mensaje = "FFecha del Viático tiene que ser mayor a la fecha del ultimo sueldo...";
            }
            rhContableTO.setMensaje(mensaje);
            return rhContableTO;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhViaticoConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BONO POR LOTES">
    @Override
    public RhContableTO insertarRhBonoConContable(
            RhBonoCabeceraTO rhBonoCabeceraTO,
            List<RhBonoDetalleTO> rhBonoDetalleTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        List<RhBonoTO> rhBonoTOs = new java.util.ArrayList();
        List<rrhh.entity.RhBono> rhBonos = new java.util.ArrayList();
        List<String> listaEmpleadoTO = new java.util.ArrayList(1);
        java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
        RhBonoTO rhBonoTo = null;
        RhContableTO rhContableTO = new RhContableTO();
        mensaje = "F";
        String tipDetalle = "C-BON";
        String perCodigo = "";
        String ctaRhFormasPago = null;
        String ctaBonoConcepto = "";
        String ctaRhBono = "";
        BigDecimal bonoValor = cero;
        BigDecimal valor = cero;
        try {
            //periodo
            List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(rhBonoCabeceraTO.getEmpCodigo());
            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (Validacion.fecha(rhBonoCabeceraTO.getBonoFecha(), "yyyy-MM-dd").getTime()
                        >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && Validacion.fecha(rhBonoCabeceraTO.getBonoFecha(), "yyyy-MM-dd").getTime()
                        <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                        && sisListaPeriodoTO.getPerCerrado() == false) {
                    perCodigo = sisListaPeriodoTO.getPerCodigo();
                    break;
                }
            }
            for (RhBonoDetalleTO rhBonoDetalleTO : rhBonoDetalleTOs) {
                comprobar = false;
                rhBonoTo = new RhBonoTO();
                //fecha ultimo sueldo
                String fechaUltimoSueldo = operacionesRRHHDAOLocal.buscarFechaRhRol(
                        rhBonoCabeceraTO.getEmpCodigo(), rhBonoDetalleTO.getEmpId());
                if (fechaUltimoSueldo.isEmpty()) {
                    comprobar = true;
                } else {
                    comprobar = Validacion.fecha(rhBonoCabeceraTO.getBonoFecha(), "yyyy-MM-dd").getTime()
                            > Validacion.fecha(fechaUltimoSueldo, "yyyy-MM-dd").getTime();
                }
                if (comprobar) {
                    //llenar rhBonoTO
                    rhBonoTo.setEmpCodigo(rhBonoCabeceraTO.getEmpCodigo());
                    rhBonoTo.setPerCodigo(perCodigo);
                    rhBonoTo.setTipCodigo(tipDetalle);
                    rhBonoTo.setConNumero("");
                    rhBonoTo.setSecCodigo(rhBonoDetalleTO.getSecCodigo());
                    rhBonoTo.setPisNumero(rhBonoDetalleTO.getPisNumero());
                    rhBonoTo.setEmpId(rhBonoDetalleTO.getEmpId());
                    rhBonoTo.setEmpApellidosNombres(rhBonoDetalleTO.getEmpApellidosNombres());
                    rhBonoTo.setBonoFecha(rhBonoCabeceraTO.getBonoFecha());
                    rhBonoTo.setBonoConcepto(rhBonoDetalleTO.getBonoConcepto());
                    rhBonoTo.setBonoDeducible(rhBonoDetalleTO.getBonoDeducible());
                    rhBonoTo.setBonoObservacion(rhBonoDetalleTO.getBonoObservacion());
                    rhBonoTo.setBonoCantidad(rhBonoDetalleTO.getBonoCantidad());
                    rhBonoTo.setBonoPrecio(rhBonoDetalleTO.getBonoPrecio());
                    rhBonoTo.setBonoValor(rhBonoDetalleTO.getBonoValor());
                    rhBonoTo.setConObservaciones(rhBonoCabeceraTO.getConObservaciones());
                    rhBonoTo.setReversar(rhBonoCabeceraTO.getReversar());
                    rhBonoTo.setUsrInsertaBono(rhBonoCabeceraTO.getUsrInsertaBono());
                    rhBonoTo.setBonoSecuencial(0);
                    rhBonoTOs.add(rhBonoTo);
                    bonoValor = bonoValor.add(rhBonoDetalleTO.getBonoValor());
                } else {
                    listaEmpleadoTO.add(rhBonoDetalleTO.getEmpApellidosNombres());
                }
            }
            if (!perCodigo.isEmpty()) {
                if (rhBonoDetalleTOs.size() == rhBonoTOs.size()) {
                    comprobar = false;
                    if (operacionesContabilidadDAOLocal.buscarTipoContable(rhBonoCabeceraTO.getEmpCodigo(), tipDetalle)) {
                        //llenar contable
                        ConContableTO conContableTO = new ConContableTO();
                        conContableTO.setEmpCodigo(rhBonoCabeceraTO.getEmpCodigo());
                        conContableTO.setPerCodigo(perCodigo);
                        conContableTO.setTipCodigo(tipDetalle);
                        conContableTO.setConFecha(rhBonoCabeceraTO.getBonoFecha());
                        conContableTO.setConPendiente(false);
                        conContableTO.setConBloqueado(false);
                        conContableTO.setConAnulado(false);
                        conContableTO.setConGenerado(true);
                        if (rhBonoDetalleTOs.size() == 1) {
                            conContableTO.setConConcepto(rhBonoDetalleTOs.get(0).getEmpApellidosNombres());//nombre empleado
                        } else {
                            conContableTO.setConConcepto("BONOS POR LOTES");//nombre empleado
                        }
                        conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                        conContableTO.setConObservaciones(rhBonoCabeceraTO.getConObservaciones());
                        conContableTO.setUsrInsertaContable(rhBonoCabeceraTO.getUsrInsertaBono());
                        conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                        ///// CREANDO UN SUCESO
                        susClave = "";
                        susSuceso = "INSERT";
                        susTabla = "recursoshumanos.rh_Bono";
                        ////// CREANDO NUMERACION
                        contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                                conContableTO.getTipCodigo()));
                        ////// CREANDO CONTABLE
                        contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                        ////// CREANDO BONO
                        for (int j = 0; j < rhBonoTOs.size(); j++) {
                            rhBonos.add(rrhh.helper.ConversionesRRHH.convertirRhBonoTO_RhBono(rhBonoTOs.get(j)));
                            rhBonos.get(j).setRhEmpleado(operacionesRRHHDAOLocal.buscarEmpleado(
                                    rhBonoTOs.get(j).getEmpCodigo(), rhBonoTOs.get(j).getEmpId()));
                            rhBonos.get(j).setBonoReversado(false);
                            ////// BUSCANDO AFILIACION
                            RhCtaIessTO rhCtaIessTO = operacionesRRHHDAOLocal.buscarCtaRhIess(
                                    rhBonoTOs.get(j).getEmpCodigo(),
                                    rhBonoTOs.get(j).getEmpId());
                            ConDetalle conDetalle = null;
                            if (j < 1) {
                                for (int i = 0; i < 2; i++) {
                                    ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                    conDetalle = new ConDetalle();
                                    conDetalle.setConContable(conContable);
                                    conDetalle.setDetSecuencia(0);
                                    conDetalle.setDetDocumento("");
                                    conDetalle.setSecCodigo(rhBonoTOs.get(j).getSecCodigo());
                                    conDetalle.setPisNumero("");
                                    conDetalle.setDetValor(bonoValor);
                                    conDetalle.setDetGenerado(true);
                                    if (i == 0) {
                                        if (rhCtaIessTO != null) {
                                            if (rhCtaIessTO.getEmpFechaAfiliacionIess() != null) {
                                                if (rhBonoTOs.get(j).getBonoDeducible()) {
                                                    ctaBonoConcepto = operacionesRRHHDAOLocal.buscarCtaRhGastoBonos(
                                                            rhBonoTOs.get(j).getEmpCodigo(),
                                                            rhBonoTOs.get(j).getEmpId());
                                                    conDetalle.setDetReferencia("BONO");//
                                                } else {
                                                    ctaBonoConcepto = operacionesRRHHDAOLocal.buscarCtaRhGastoBonosND(
                                                            rhBonoTOs.get(j).getEmpCodigo(),
                                                            rhBonoTOs.get(j).getEmpId());
                                                    conDetalle.setDetReferencia("BONO-ND");//
                                                }
                                            } else {
                                                ctaBonoConcepto = operacionesRRHHDAOLocal.buscarCtaRhGastoBonosND(
                                                        rhBonoTOs.get(j).getEmpCodigo(),
                                                        rhBonoTOs.get(j).getEmpId());
                                                conDetalle.setDetReferencia("BONO-ND");//
                                            }
                                        }
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhBonoTOs.get(j).getEmpCodigo(),
                                                (ctaBonoConcepto == null) ? "" : ctaBonoConcepto));//categoria
                                        conDetalle.setDetDebitoCredito(rhBonoTOs.get(j).getReversar() ? 'C' : 'D');

                                        conDetalle.setDetOrden(i + 1);//
                                        listaConDetalle.add(i, conDetalle);
                                    }
                                    if (i == 1) {
                                        ctaRhFormasPago = operacionesRRHHDAOLocal.buscarCtaRhPorPagarBonos(
                                                rhBonoTOs.get(j).getEmpCodigo(),
                                                rhBonoTOs.get(j).getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhBonoTOs.get(j).getEmpCodigo(),
                                                (ctaRhFormasPago == null) ? "" : ctaRhFormasPago));//categoria
                                        conDetalle.setDetDebitoCredito(rhBonoTOs.get(j).getReversar() ? 'D' : 'C');
                                        conDetalle.setDetDocumento(rhBonoDetalleTOs.get(j).getConDetDocumento());
                                        conDetalle.setDetReferencia("FP");//
                                        conDetalle.setDetOrden(i + 1);//
                                        valor = valor.add(conDetalle.getDetValor());
                                        listaConDetalle.add(i, conDetalle);
                                    }
                                    conDetalle = null;
                                }
                            }
                        }

                        ctaBonoConcepto = ctaBonoConcepto == null ? "" : ctaBonoConcepto;
                        ctaRhFormasPago = ctaRhFormasPago == null ? "" : ctaRhFormasPago;
                        comprobar = false;
                        if (!ctaBonoConcepto.isEmpty() && !ctaRhFormasPago.isEmpty()) {//revisar si estan llenos
                            if (rhBonos.size() == 1) {
                                susDetalle = "Bono a " + operacionesRRHHDAOLocal.getRhEmpleadoApellidosNombres(
                                        rhBonos.get(0).getRhEmpleado().getRhEmpleadoPK().getEmpEmpresa(),
                                        rhBonos.get(0).getRhEmpleado().getRhEmpleadoPK().getEmpId()) + " por $" + valor.toPlainString();
                            } else {
                                susDetalle = "Bono total a varios empleados " + " por $" + valor.toPlainString();
                            }
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            comprobar = operacionesRRHHDAOTransaccionLocal.insertarRhBono(
                                    rhBonos,
                                    conContable,
                                    listaConDetalle,
                                    sisSuceso,
                                    conNumeracion,
                                    sisInfoTO);
                        } else if (ctaBonoConcepto.isEmpty()) {
                            mensaje = "FNo se encuentra la cuenta contable Bono concepto...";
                        }
                        if (ctaRhFormasPago.isEmpty()) {
                            mensaje = "FNo se encuentra la cuenta contable forma de pago...";
                        }
                        if (comprobar) {
                            sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                            contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                            mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";

                            rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                            rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                            rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                            rhContableTO.setListaEmpleadoTO(listaEmpleadoTO);
                        }
                    } else {
                        mensaje = "FNo se encuentra tipo de contable...";
                    }
                } else {
                    mensaje = "FFecha del Bono incompatible con los siguientes empleado:";
                }
            } else {
                mensaje = "FNo se encuentra ningún periodo para la fecha que ingresó\nNo esta creado o esta cerrado...";
            }
            rhContableTO.setMensaje(mensaje);
            rhContableTO.setListaEmpleadoTO(listaEmpleadoTO);
            return rhContableTO;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhBonoConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VACACIONES">
    @Override
    public RhContableTO insertarRhVacacionesConContable(
            RhVacacionesTO rhVacacionesTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        RhContableTO rhContableTO = new RhContableTO();
        RhCtaFormaPagoTO rhCtaFormaPagoTO = new RhCtaFormaPagoTO();
        String tipDetalle = "C-VAC";
        mensaje = "F";
        String ctaRhFormasPago = null;
        String ctaRhVacaciones = "";
        int numerosDias = 0;
        BigDecimal valor = cero;
        try {
            //fecha ultimo sueldo
            String fechaUltimaVacaciones = operacionesRRHHDAOLocal.buscarFechaRhVacaciones(
                    rhVacacionesTO.getEmpEmpresa(), rhVacacionesTO.getEmpId());
            if (fechaUltimaVacaciones.isEmpty()) {
                comprobar = true;
            } else {
                comprobar = Validacion.fecha(rhVacacionesTO.getVacHasta(), "yyyy-MM-dd").getTime()
                        > Validacion.fecha(fechaUltimaVacaciones, "yyyy-MM-dd").getTime();
            }
            if (Validacion.fecha(rhVacacionesTO.getConFecha(), "yyyy-MM-dd").getTime()
                    > Validacion.fecha(rhVacacionesTO.getVacHasta(), "yyyy-MM-dd").getTime()) {
                numerosDias = Validacion.numeroDias(
                        "yyyy-MM-dd",
                        rhVacacionesTO.getVacDesde(),
                        rhVacacionesTO.getVacHasta());
                if (numerosDias >= 364 && numerosDias <= 366) {
                    if (comprobar) {
                        comprobar = false;
                        //periodo
                        List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
                        listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(rhVacacionesTO.getEmpEmpresa());

                        for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                            if (Validacion.fecha(rhVacacionesTO.getConFecha(), "yyyy-MM-dd").getTime()
                                    >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                                    && Validacion.fecha(rhVacacionesTO.getConFecha(), "yyyy-MM-dd").getTime()
                                    <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                                    && sisListaPeriodoTO.getPerCerrado() == false) {
                                comprobar = true;
                                rhVacacionesTO.setConPeriodo(sisListaPeriodoTO.getPerCodigo());
                                break;
                            }
                        }
                        if (comprobar) {
                            comprobar = false;
                            if (operacionesContabilidadDAOLocal.buscarTipoContable(rhVacacionesTO.getEmpEmpresa(), tipDetalle)) {
                                //llenar contable
                                ConContableTO conContableTO = new ConContableTO();
                                conContableTO.setEmpCodigo(rhVacacionesTO.getEmpEmpresa());
                                conContableTO.setPerCodigo(rhVacacionesTO.getConPeriodo());
                                conContableTO.setTipCodigo(tipDetalle);
                                rhVacacionesTO.setConTipo(tipDetalle);
                                conContableTO.setConFecha(rhVacacionesTO.getConFecha());
                                conContableTO.setConPendiente(false);
                                conContableTO.setConBloqueado(false);
                                conContableTO.setConAnulado(false);
                                conContableTO.setConGenerado(false); //deberia ser true, para elminar desde el modulo de contabilidad
                                conContableTO.setConConcepto(rhVacacionesTO.getEmpApellidosNombres());//nombre empleado
                                conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                                conContableTO.setConObservaciones(rhVacacionesTO.getConObservaciones());
                                conContableTO.setUsrInsertaContable(rhVacacionesTO.getUsrCodigo());
                                conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                                ///// CREANDO UN SUCESO
                                susClave =
                                        rhVacacionesTO.getConPeriodo() + " "
                                        + rhVacacionesTO.getConTipo() + " "
                                        + rhVacacionesTO.getConNumero();
                                susSuceso = "INSERT";
                                susTabla = "recursoshumanos.rh_vacaciones";
                                ////// CREANDO NUMERACION
                                contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                        conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                                        conContableTO.getTipCodigo()));
                                ////// CREANDO CONTABLE
                                contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                                ////// CREANDO Prestamo
                                rrhh.entity.RhVacaciones rhVacaciones = rrhh.helper.ConversionesRRHH.convertirRhVacacionesTO_RhVacaciones(rhVacacionesTO);
                                rhVacaciones.setVacReversado(false);
                                ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                                ConDetalle conDetalle = null;
                                /////////////////////////////////////////////////////////////////
                                ctaRhVacaciones = operacionesRRHHDAOLocal.buscarCtaRhVacaciones(
                                        rhVacacionesTO.getEmpEmpresa(),
                                        rhVacacionesTO.getEmpId());
                                ConCuentas obj1 = operacionesContabilidadDAOLocal.buscarCuentas(rhVacacionesTO.getEmpEmpresa(),
                                        (ctaRhVacaciones == null) ? "" : ctaRhVacaciones);
                                /////////////////////////////////////////////////////////////////

                                rhCtaFormaPagoTO = operacionesRRHHDAOLocal.buscarCtaRhFormaPago(
                                        rhVacacionesTO.getEmpEmpresa(),
                                        rhVacacionesTO.getVacFormaPago());
                                ctaRhFormasPago = rhCtaFormaPagoTO.getCtaCodigo();
                                ConCuentas obj2 = operacionesContabilidadDAOLocal.buscarCuentas(
                                        rhVacacionesTO.getEmpEmpresa(), (ctaRhFormasPago == null) ? "" : ctaRhFormasPago);

                                for (int i = 0; i < 2; i++) {
                                    conDetalle = new ConDetalle();
                                    conDetalle.setConContable(conContable);
                                    conDetalle.setDetSecuencia(0);
                                    conDetalle.setDetDocumento("");
                                    conDetalle.setPisNumero(null);
                                    conDetalle.setDetValor(rhVacacionesTO.getVacValor());
                                    conDetalle.setDetGenerado(true);
                                    if (i == 0) {
                                        if (rhVacacionesTO.getVacGozadas()) {
                                            conDetalle.setConCuentas(obj2);//categoria
                                            conDetalle.setSecCodigo(rhCtaFormaPagoTO.getSecCodigo());
                                        } else {
                                            conDetalle.setConCuentas(obj1);//categoria
                                            conDetalle.setSecCodigo(rhVacacionesTO.getSecCodigo());
                                        }
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("VAC");//
                                        conDetalle.setDetOrden(i + 1);//
                                        listaConDetalle.add(i, conDetalle);
                                    }
                                    if (i == 1) {
                                        if (rhCtaFormaPagoTO.getCtaCodigo() != null) {
                                            conDetalle.setSecCodigo(rhCtaFormaPagoTO.getSecCodigo());
                                            conDetalle.setConCuentas(obj2);//forma pago
                                            conDetalle.setDetDebitoCredito('C');
                                            conDetalle.setDetDocumento(rhVacacionesTO.getConDetDocumento());
                                            conDetalle.setDetReferencia("FP");//
                                            conDetalle.setDetOrden(i + 1);//
                                            valor = valor.add(conDetalle.getDetValor());
                                            listaConDetalle.add(i, conDetalle);
                                        }
                                    }
                                    conDetalle = null;
                                }

                                ctaRhVacaciones = ctaRhVacaciones == null ? "" : ctaRhVacaciones;
                                ctaRhFormasPago = ctaRhFormasPago == null ? "" : ctaRhFormasPago;
                                comprobar = false;
                                if (!ctaRhVacaciones.isEmpty() && !ctaRhFormasPago.isEmpty()) {//revisar si estan llenos
                                    susDetalle = "Vacaciones a " + operacionesRRHHDAOLocal.getRhEmpleadoApellidosNombres(
                                            rhVacaciones.getRhEmpleado().getRhEmpleadoPK().getEmpEmpresa(),
                                            rhVacaciones.getRhEmpleado().getRhEmpleadoPK().getEmpId()) + " por $" + valor.toPlainString();
                                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                            susTabla,
                                            susClave,
                                            susSuceso,
                                            susDetalle,
                                            sisInfoTO);
                                    comprobar = operacionesRRHHDAOTransaccionLocal.insertarRhVacaciones(
                                            rhVacaciones,
                                            conContable,
                                            listaConDetalle,
                                            sisSuceso,
                                            conNumeracion,
                                            sisInfoTO);
                                } else if (ctaRhVacaciones.isEmpty()) {
                                    mensaje = "FNo se encuentra la cuenta contable de Vacaciones...";
                                }
                                if (ctaRhFormasPago.isEmpty()) {
                                    mensaje = "FNo se encuentra la cuenta contable de forma de pago...";
                                }
                                if (comprobar) {
                                    sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                                    contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                                    mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                            + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                            + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                            + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";

                                    rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                                    rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                                    rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                                }
                            } else {
                                mensaje = "FNo se encuentra tipo de contable...";
                            }
                        } else {
                            mensaje = "FNo se encuentra ningún periodo para la fecha que ingresó\nNo esta creado o esta cerrado...";
                        }
                    } else {
                        mensaje = "FFecha del Vacaciones tiene que ser mayor a la fecha del ultima Vacaciones...";
                    }
                } else {
                    mensaje = "FDebe de haber mínimo 364 días y máximo 366 días...";
                }
            } else {
                mensaje = "FFecha Hasta debe ser menor a la del contable...";
            }
            rhContableTO.setMensaje(mensaje);
            return rhContableTO;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhVacacionesConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="RHSALARIODIGNO">
    @Override
    public RhContableTO insertarRhSalarioDignoContable(
            rrhh.TO.RhSalarioDignoTO rhSalarioDignoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        RhContableTO rhContableTO = new RhContableTO();
        RhCtaFormaPagoTO rhCtaFormaPagoTO = new RhCtaFormaPagoTO();
        String tipDetalle = "C-PSD";
        mensaje = "F";
        String ctaRhFormasPago = null;
        String ctaRhSalarioDigno = "";
        BigDecimal valor = cero;
        try {

            comprobar = false;
            //periodo
            List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(rhSalarioDignoTO.getEmpEmpresa());
            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (Validacion.fecha(rhSalarioDignoTO.getConFecha(), "yyyy-MM-dd").getTime()
                        >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && Validacion.fecha(rhSalarioDignoTO.getConFecha(), "yyyy-MM-dd").getTime()
                        <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                        && sisListaPeriodoTO.getPerCerrado() == false) {
                    comprobar = true;
                    rhSalarioDignoTO.setConPeriodo(sisListaPeriodoTO.getPerCodigo());
                    break;
                }
            }
            if (comprobar) {
                comprobar = false;
                if (operacionesContabilidadDAOLocal.buscarTipoContable(rhSalarioDignoTO.getEmpEmpresa(), tipDetalle)) {
                    //llenar contable
                    ConContableTO conContableTO = new ConContableTO();
                    conContableTO.setEmpCodigo(rhSalarioDignoTO.getEmpEmpresa());
                    conContableTO.setPerCodigo(rhSalarioDignoTO.getConPeriodo());
                    conContableTO.setTipCodigo(tipDetalle);
                    rhSalarioDignoTO.setConTipo(tipDetalle);
                    conContableTO.setConFecha(rhSalarioDignoTO.getConFecha());
                    conContableTO.setConPendiente(false);
                    conContableTO.setConBloqueado(false);
                    conContableTO.setConAnulado(false);
                    conContableTO.setConGenerado(false); //deberia ser true, para elminar desde el modulo de contabilidad
                    conContableTO.setConConcepto(rhSalarioDignoTO.getEmpApellidosNombres());//nombre empleado
                    conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                    conContableTO.setConObservaciones(rhSalarioDignoTO.getConObservaciones());
                    conContableTO.setUsrInsertaContable(rhSalarioDignoTO.getUsrCodigo());
                    conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                    ///// CREANDO UN SUCESO
                    susClave =
                            rhSalarioDignoTO.getConPeriodo() + " "
                            + rhSalarioDignoTO.getConTipo() + " "
                            + rhSalarioDignoTO.getConNumero();
                    susSuceso = "INSERT";
                    susTabla = "recursoshumanos.rh_salario_digno";
                    ////// CREANDO NUMERACION
                    contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                            conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                            conContableTO.getTipCodigo()));
                    ////// CREANDO CONTABLE
                    contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                    ////// CREANDO SALARIO DIGNO
                    rrhh.entity.RhSalarioDigno rhSalarioDigno = rrhh.helper.ConversionesRRHH.convertirRhSalarioDignoTO_RhSalarioDigno(rhSalarioDignoTO);
                    rhSalarioDigno.setSdigReversado(false);
                    ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                    java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                    ConDetalle conDetalle = null;
                    /////////////////////////////////////////////////////////////////
                    ctaRhSalarioDigno = operacionesRRHHDAOLocal.buscarCtaRhSalarioDigno(
                            rhSalarioDignoTO.getEmpEmpresa(),
                            rhSalarioDignoTO.getEmpId());
                    ConCuentas conCuentasSalariodigno = operacionesContabilidadDAOLocal.buscarCuentas(rhSalarioDignoTO.getEmpEmpresa(),
                            (ctaRhSalarioDigno == null) ? "" : ctaRhSalarioDigno);
                    /////////////////////////////////////////////////////////////////
                    rhCtaFormaPagoTO = operacionesRRHHDAOLocal.buscarCtaRhFormaPago(
                            rhSalarioDignoTO.getEmpEmpresa(),
                            rhSalarioDignoTO.getSdigFormaPago());
                    ctaRhFormasPago = rhCtaFormaPagoTO.getCtaCodigo();
                    ConCuentas conCuentasFormasPagos = operacionesContabilidadDAOLocal.buscarCuentas(
                            rhSalarioDignoTO.getEmpEmpresa(), (ctaRhFormasPago == null) ? "" : ctaRhFormasPago);

                    for (int i = 0; i < 2; i++) {
                        conDetalle = new ConDetalle();
                        conDetalle.setConContable(conContable);
                        conDetalle.setDetSecuencia(0);
                        conDetalle.setDetDocumento("");
                        conDetalle.setPisNumero("");
                        conDetalle.setDetValor(rhSalarioDignoTO.getSdigValor());
                        conDetalle.setDetGenerado(true);
                        if (i == 0) {
                            conDetalle.setSecCodigo(rhSalarioDignoTO.getSecCodigo());
                            conDetalle.setConCuentas(conCuentasSalariodigno);//categoria
                            conDetalle.setDetDebitoCredito('D');
                            conDetalle.setDetReferencia("SALDIG");//
                            conDetalle.setDetOrden(i + 1);//
                            listaConDetalle.add(i, conDetalle);
                        }
                        if (i == 1) {
                            if (rhCtaFormaPagoTO.getCtaCodigo() != null) {
                                conDetalle.setSecCodigo(rhCtaFormaPagoTO.getSecCodigo());
                                conDetalle.setConCuentas(conCuentasFormasPagos);//forma pago
                                conDetalle.setDetDebitoCredito('C');
                                conDetalle.setDetDocumento(rhSalarioDignoTO.getConDetDocumento());
                                conDetalle.setDetReferencia("FP");//
                                conDetalle.setDetOrden(i + 1);//
                                valor = valor.add(conDetalle.getDetValor());
                                listaConDetalle.add(i, conDetalle);
                            }
                        }
                        conDetalle = null;
                    }

                    ctaRhSalarioDigno = ctaRhSalarioDigno == null ? "" : ctaRhSalarioDigno;
                    ctaRhFormasPago = ctaRhFormasPago == null ? "" : ctaRhFormasPago;
                    comprobar = false;
                    if (!ctaRhSalarioDigno.isEmpty() && !ctaRhFormasPago.isEmpty()) {//revisar si estan llenos
                        susDetalle = "Salario Digno a " + operacionesRRHHDAOLocal.getRhEmpleadoApellidosNombres(
                                rhSalarioDigno.getRhEmpleado().getRhEmpleadoPK().getEmpEmpresa(),
                                rhSalarioDigno.getRhEmpleado().getRhEmpleadoPK().getEmpId()) + " por $" + valor.toPlainString();
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        comprobar = operacionesRRHHDAOTransaccionLocal.insertarRhSalarioDigno(
                                rhSalarioDigno,
                                conContable,
                                listaConDetalle,
                                sisSuceso,
                                conNumeracion,
                                sisInfoTO);
                    } else if (ctaRhSalarioDigno.isEmpty()) {
                        mensaje = "FNo se encuentra la cuenta contable de Salario Digno...";
                    }
                    if (ctaRhFormasPago.isEmpty()) {
                        mensaje = "FNo se encuentra la cuenta contable de forma de pago...";
                    }
                    if (comprobar) {
                        sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                        contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                        mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";

                        rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                        rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                        rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                    }
                } else {
                    mensaje = "FNo se encuentra tipo de contable...";
                }
            } else {
                mensaje = "FNo se encuentra ningún periodo para la fecha que ingresó\nNo esta creado o esta cerrado...";
            }

            rhContableTO.setMensaje(mensaje);
            return rhContableTO;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhVacacionesConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BONO CONCEPTO">
    @Override
    public boolean insertarRhBonoConcepto(
            RhBonoConceptoTO rhBonoConceptoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            susClave = rhBonoConceptoTO.getBcDetalle();
            susDetalle = "Se insertó el BonoConcepto con el detalle " + rhBonoConceptoTO.getBcDetalle();
            susSuceso = "INSERT";
            susTabla = "produccion.rh_BonoConcepto";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            rhBonoConceptoTO.setUsrFechaInsertaBonoConcepto(Validacion.fechaSistema());
            RhBonoConcepto rhBonoConcepto = ConversionesRRHH.convertirRhBonoConceptoTO_RhBonoConcepto(
                    rhBonoConceptoTO);
            comprobar = operacionesRRHHDAOTransaccionLocal.insertarRhBonoConcepto(rhBonoConcepto, sisSuceso);
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhBonoConcepto",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean modificarRhBonoConcepto(
            RhBonoConceptoTO rhBonoConceptoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            rhBonoConceptoTO.setUsrFechaInsertaBonoConcepto(Validacion.fechaSistema());
            comprobar = false;
            RhBonoConcepto rhBonoConcepto = operacionesRRHHDAOLocal.buscarBonoConcepto(
                    rhBonoConceptoTO.getBcSecuencia());
            if (rhBonoConcepto != null) {
                susClave = rhBonoConceptoTO.getBcDetalle();
                susDetalle = "Se modificó el BonoConcepto con detalle " + rhBonoConceptoTO.getBcDetalle();
                susSuceso = "UPDATE";
                susTabla = "produccion.rh_BonoConcepto";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                rhBonoConceptoTO.setUsrInsertaBonoConcepto(rhBonoConcepto.getUsrCodigo());
                rhBonoConceptoTO.setUsrFechaInsertaBonoConcepto(Validacion.fecha(rhBonoConcepto.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                rhBonoConcepto = ConversionesRRHH.convertirRhBonoConceptoTO_RhBonoConcepto(rhBonoConceptoTO);
                comprobar = operacionesRRHHDAOTransaccionLocal.modificarRhBonoConcepto(rhBonoConcepto, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarRhBonoConcepto",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean eliminarRhBonoConcepto(
            RhBonoConceptoTO rhBonoConceptoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            RhBonoConcepto rhBonoConcepto = operacionesRRHHDAOLocal.buscarBonoConcepto(
                    rhBonoConceptoTO.getBcSecuencia());
            if (operacionesRRHHDAOLocal.eliminarRhBonoConcepto(rhBonoConceptoTO) == true) {
                susClave = rhBonoConceptoTO.getBcDetalle();
                susDetalle = "Se eliminó la BonoConcepto con detalle " + rhBonoConceptoTO.getBcDetalle();
                susSuceso = "DELETE";
                susTabla = "produccion.rh_BonoConcepto";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                rhBonoConcepto = ConversionesRRHH.convertirRhBonoConceptoTO_RhBonoConcepto(rhBonoConceptoTO);
                comprobar = operacionesRRHHDAOTransaccionLocal.eliminarRhBonoConcepto(rhBonoConcepto, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarRhBonoConcepto",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public List<RhListaBonoConceptoTO> getListaBonoConceptoTO(String empresa) throws Exception {
        return operacionesRRHHDAOLocal.getListaBonoConcepto(empresa);
    }

    @Override
    public List<RhComboBonoConceptoTO> getComboBonoConceptoTO(String empresa) throws Exception {
        return operacionesRRHHDAOLocal.getComboBonoConcepto(empresa);
    }
    // </editor-fold>

    private BigDecimal redondeoDecimalBigDecimal(BigDecimal d) {
        java.text.DecimalFormat formato = new java.text.DecimalFormat("#.##");
        java.text.DecimalFormatSymbols dfs = formato.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        formato.setDecimalFormatSymbols(dfs);
        return BigDecimal.valueOf(Double.valueOf(formato.format(d)));
    }

    // <editor-fold defaultstate="collapsed" desc="ROL">
    @Override
    public RhParametrosTO getRhParametros(String fechaHasta) throws Exception {
        return operacionesRRHHDAOLocal.getRhParametros(fechaHasta);
    }

    @Override
    public boolean getRhEmpleadoRetencion(String empCodigo, String empId) throws Exception {
        return operacionesRRHHDAOLocal.getRhEmpleadoRetencion(empCodigo, empId);
    }

    @Override
    public RhCtaIessTO buscarCtaRhIess(String empCodigo, String empId) throws Exception {
        return operacionesRRHHDAOLocal.buscarCtaRhIess(empCodigo, empId);
    }

    @Override
    public RhCancelarBeneficioSocialTO getRhCancelarBeneficioSocialTO(String empCodigo, String empId) throws Exception {
        return operacionesRRHHDAOLocal.getRhCancelarBeneficioSocialTO(empCodigo, empId);
    }

    @Override
    public java.math.BigDecimal getRhValorImpuestoRenta(
            String empCodigo,
            String empId,
            String fechaHasta,
            Integer diasLaborados,
            java.math.BigDecimal rolIngresos) throws Exception {
        return operacionesRRHHDAOLocal.getRhValorImpuestoRenta(
                empCodigo,
                empId,
                fechaHasta,
                diasLaborados,
                rolIngresos);
    }

    @Override
    public RhContableTO insertarRhRolLoteConContable(
            java.util.List<RhFunPlantillaSueldosLoteTO> rhFunPlantillaSueldosLoteTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String tipDetalle = "C-ROL";
        String periodo = null;
        java.math.BigDecimal valorImpuestoRenta = cero;
        BigDecimal valor = cero;
        RhContableTO rhContableTO = new RhContableTO();
        RhCtaFormaPagoTO rhCtaFormaPagoTO = new RhCtaFormaPagoTO();
        RhCancelarBeneficioSocialTO rhCancelarBeneficioSocialTO;
        rrhh.entity.RhEmpleado rhEmpleado = null;
        String ctaRhFormasPago = null;
        //----------------------------------------------------------------------
        for (RhFunPlantillaSueldosLoteTO rhFunPlantillaSueldosLoteTO : rhFunPlantillaSueldosLoteTOs) {
            if (operacionesContabilidadDAOLocal.buscarTipoContable(sisInfoTO.getInfEmpresa(), tipDetalle)) {
                ////// BUSCANDO AFILIACION
                RhCtaIessTO rhCtaIessTO = operacionesRRHHDAOLocal.buscarCtaRhIess(
                        sisInfoTO.getInfEmpresa(),
                        rhFunPlantillaSueldosLoteTO.getPrId());
                ////// BUSCANDO Beneficio Social
                rhCancelarBeneficioSocialTO = operacionesRRHHDAOLocal.getRhCancelarBeneficioSocialTO(
                        sisInfoTO.getInfEmpresa(),
                        rhFunPlantillaSueldosLoteTO.getPrId());
                ///// BUSCANDO EMPLEADO
                rrhh.entity.RhEmpleado rhEmpleadoAux = operacionesRRHHDAOLocal.buscarEmpleado(
                        sisInfoTO.getInfEmpresa(),
                        rhFunPlantillaSueldosLoteTO.getPrId());
                rhEmpleado = ConversionesRRHH.convertirRhEmpleado_RhEmpleado(
                        rhEmpleadoAux);
                ////// BUSCANDO CATEGORIA
                RhCategoriaTO rhCategoriaTO = operacionesRRHHDAOLocal.getCategoria(
                        sisInfoTO.getInfEmpresa(),
                        rhEmpleado.getCatNombre());
                //periodo
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(sisInfoTO.getInfEmpresa());
                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (Validacion.fecha(rhFunPlantillaSueldosLoteTO.getPrHasta(), "yyyy-MM-dd").getTime()
                            >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && Validacion.fecha(rhFunPlantillaSueldosLoteTO.getPrHasta(), "yyyy-MM-dd").getTime()
                            <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                            && sisListaPeriodoTO.getPerCerrado() == false) {
                        comprobar = true;
                        periodo = sisListaPeriodoTO.getPerCodigo();
                        break;
                    }
                }
                //llenar contable
                ConContableTO conContableTO = new ConContableTO();
                conContableTO.setEmpCodigo(sisInfoTO.getInfEmpresa());
                conContableTO.setPerCodigo(periodo);
                conContableTO.setTipCodigo(tipDetalle);
                rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().setTipCodigo(periodo);
                rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().setTipCodigo(tipDetalle);
                java.util.List<String> fecha = validaciones.Validacion.separar(rhFunPlantillaSueldosLoteTO.getPrHasta(), "-");
                //licenciado
//                                fecha.set(2, (fecha.get(1).equals("12") && fecha.get(2).equals("31")) ? "30" : fecha.get(2));

                conContableTO.setConFecha(fecha.get(0) + "-" + fecha.get(1) + "-" + fecha.get(2));
                conContableTO.setConPendiente(false);
                conContableTO.setConBloqueado(false);
                conContableTO.setConAnulado(false);
                conContableTO.setConGenerado(true);
                conContableTO.setConConcepto(rhFunPlantillaSueldosLoteTO.getPrNombres());//nombre empleado
                conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                conContableTO.setConObservaciones(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getConObservaciones());
                conContableTO.setUsrInsertaContable(sisInfoTO.getInfUsuario());
                conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                ///// CREANDO UN SUCESO
                susClave = rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getPerCodigo() + " "
                        + rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getTipCodigo() + " "
                        + rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getConNumero();
                susSuceso = "INSERT";
                susTabla = "recursoshumanos.rh_rol";
                ////// CREANDO NUMERACION
                contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                        conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                        conContableTO.getTipCodigo()));
                ////// CREANDO CONTABLE
                contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                ////// CREANDO Rol
                rrhh.entity.RhRol rhRol = rrhh.helper.ConversionesRRHH.convertirRhFunPlantillaSueldosLoteTO_RhRol(rhFunPlantillaSueldosLoteTO, sisInfoTO);
                rhRol.setRolReversado(false);
                if (rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().isPorPagar()) {
                    rhRol.setRolFormaPago("POR PAGAR");
                } else {
                    rhRol.setRolFormaPago(rhFunPlantillaSueldosLoteTO.getRolFormaPago());
                }
                ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                ConDetalle conDetalle = null;
                int orden = 0;
                for (int i = 0; i <= 25; i++) {
                    conDetalle = new ConDetalle();
                    conDetalle.setConContable(conContable);
                    conDetalle.setDetSecuencia(0);
                    conDetalle.setDetDocumento("");
                    conDetalle.setSecCodigo(rhFunPlantillaSueldosLoteTO.getPrSector());
                    conDetalle.setPisNumero("");
                    conDetalle.setDetGenerado(true);
                    if (i == 0) {
                        //categoria, cuenta sueldos
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaGastoSueldos() == null) ? "" : rhCategoriaTO.getCtaGastoSueldos()));//categoria
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("ROL");//
                        conDetalle.setDetValor(rhFunPlantillaSueldosLoteTO.getRolIngresos());
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Rol)...";
                            }
                        }
                    }
                    if (i == 1) {
                        if (rhFunPlantillaSueldosLoteTO.getRolDiasPermisoMedico() > 0) {
                            //categoria, cuenta sueldos
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                    (rhCategoriaTO.getCtaGastoSueldos() == null) ? "" : rhCategoriaTO.getCtaGastoSueldos()));//categoria
                            conDetalle.setDetDebitoCredito('C');
                            conDetalle.setDetReferencia("ROL");//
                            conDetalle.setDetValor(rhRol.getRolDescuentoPermisoMedico());
                            conDetalle.setDetOrden(orden);//
                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                if (conDetalle.getConCuentas() != null) {
                                    listaConDetalle.add(conDetalle);
                                    orden++;
                                } else {
                                    mensaje = "FNo se encuentra la cuenta contable (Rol)...";
                                }
                            }
                        }
                    }
                    if (i == 2) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaXiii() == null) ? "" : rhCategoriaTO.getCtaXiii()));//categoria
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("XIII");//
                        conDetalle.setDetValor(rhRol.getRolLiqXiii());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (XIII)...";
                            }
                        }
                    }
                    if (i == 3) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaXiv() == null) ? "" : rhCategoriaTO.getCtaXiv()));//categoria
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("XIV");//
                        conDetalle.setDetValor(rhRol.getRolLiqXiv());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (XIV)...";
                            }
                        }
                    }
                    if (i == 4) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaVacaciones() == null) ? "" : rhCategoriaTO.getCtaVacaciones()));//categoria
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("VAC");//
                        conDetalle.setDetValor(rhRol.getRolLiqVacaciones());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Vacaciones)...";
                            }
                        }
                    }
                    if (i == 5) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaGastoSalarioDigno() == null) ? "" : rhCategoriaTO.getCtaGastoSalarioDigno()));//categoria
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("SAL-DIG");//
                        conDetalle.setDetValor(rhRol.getRolLiqSalarioDigno());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Gasto Salario Digno)...";
                            }
                        }
                    }
                    if (i == 6) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaDesahucio() == null) ? "" : rhCategoriaTO.getCtaDesahucio()));//categoria
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("DES");//
                        conDetalle.setDetValor(rhRol.getRolLiqDesahucio());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Desahucio)...";
                            }
                        }
                    }
                    if (i == 7) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaGastoDesahucioIntempestivo() == null) ? "" : rhCategoriaTO.getCtaGastoDesahucioIntempestivo()));//categoria
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("DES-INT");//
                        conDetalle.setDetValor(rhRol.getRolLiqDesahucioIntempestivo());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Desahucio Intempestivo)...";
                            }
                        }
                    }
                    if (i == 8) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaPorPagarBonos() == null) ? "" : rhCategoriaTO.getCtaPorPagarBonos()));//forma pago
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("BONO");//
                        conDetalle.setDetValor(rhRol.getRolBonos().subtract(
                                rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getEstadoCtaRhIess().equals("IESS") ? rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getRolIngresosExtras() : cero));////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Bono)...";
                            }
                        }
                    }
                    if (i == 9) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaPorPagarBonos() == null) ? "" : rhCategoriaTO.getCtaPorPagarBonos()));//forma pago
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("BONO-ND");
                        conDetalle.setDetValor(rhRol.getRolBonosnd().subtract(
                                rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getEstadoCtaRhIess().equals("IESS") ? cero : rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getRolIngresosExtras()));////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Bono ND)...";
                            }
                        }
                    }
                    if (i == 10) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaGastoBonoFijo() == null) ? "" : rhCategoriaTO.getCtaGastoBonoFijo()));//forma pago
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("BF");//
                        conDetalle.setDetValor(rhRol.getRolBonoFijo());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Bono Fijo)...";
                            }
                        }
                    }
                    if (i == 11) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaGastoBonoFijoNd() == null) ? "" : rhCategoriaTO.getCtaGastoBonoFijoNd()));//forma pago
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("BF-ND");
                        conDetalle.setDetValor(rhRol.getRolBonoFijoNd());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Bono Fijo ND)...";
                            }
                        }
                    }
                    if (i == 12) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaGastoOtrosIngresos() == null) ? "" : rhCategoriaTO.getCtaGastoOtrosIngresos()));//forma pago
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("OI");//
                        conDetalle.setDetValor(rhRol.getRolOtrosIngresos());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Otros Ingresos)...";
                            }
                        }
                    }
                    if (i == 13) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaGastoOtrosIngresosNd() == null) ? "" : rhCategoriaTO.getCtaGastoOtrosIngresosNd()));//forma pago
                        conDetalle.setDetDebitoCredito('D');
                        conDetalle.setDetReferencia("OI-ND");
                        conDetalle.setDetValor(rhRol.getRolOtrosIngresosNd());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Otros Ingresos ND)...";
                            }
                        }
                    }
                    if (i == 15) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaPorPagarSueldo() == null) ? "" : rhCategoriaTO.getCtaPorPagarSueldo()));//forma pago
                        conDetalle.setDetReferencia("SAL-ANT");//
                        conDetalle.setDetValor(rhRol.getRolSaldoAnterior());////////////
                        conDetalle.setDetOrden(orden);//
                        if (!(rhRol.getRolSaldoAnterior().compareTo(cero) == 0)) {
                            if (rhRol.getRolSaldoAnterior().compareTo(cero) < 0) {
                                conDetalle.setDetDebitoCredito('C');
                                conDetalle.setDetValor(rhRol.getRolSaldoAnterior().abs());////////////
                            }
                            if (rhRol.getRolSaldoAnterior().compareTo(cero) > 0) {
                                conDetalle.setDetDebitoCredito('D');
                                conDetalle.setDetValor(rhRol.getRolSaldoAnterior());////////////
                            }
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Saldo Anterior)...";
                            }
                        }
                    }
                    if (i == 16) {
                        if (rhCancelarBeneficioSocialTO.getEmpCancelarXiiiSueldoMensualmente()) {
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                    (rhCategoriaTO.getCtaGastoXiii() == null) ? "" : rhCategoriaTO.getCtaGastoXiii()));//categoria
                            conDetalle.setDetDebitoCredito('D');
                            conDetalle.setDetReferencia("GXIII");//
                            conDetalle.setDetValor(rhRol.getRolXiii());////////////
                            rhFunPlantillaSueldosLoteTO.setRolLiqXiii(rhRol.getRolXiii());
                            conDetalle.setDetOrden(orden);//
                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                if (conDetalle.getConCuentas() != null) {
                                    listaConDetalle.add(conDetalle);
                                    orden++;
                                } else {
                                    mensaje = "FNo se encuentra la cuenta contable (Gasto XIII)...";
                                }
                            }
                        }
                    }
                    if (i == 17) {
                        if (rhCancelarBeneficioSocialTO.getEmpCancelarXivSueldoMensualmente()) {
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                    (rhCategoriaTO.getCtaGastoXiv() == null) ? "" : rhCategoriaTO.getCtaGastoXiv()));//categoria
                            conDetalle.setDetDebitoCredito('D');
                            conDetalle.setDetReferencia("GXIV");//
                            conDetalle.setDetValor(rhRol.getRolXiv());////////////
                            rhFunPlantillaSueldosLoteTO.setRolLiqXiv(rhRol.getRolXiv());
                            conDetalle.setDetOrden(orden);//
                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                if (conDetalle.getConCuentas() != null) {
                                    listaConDetalle.add(conDetalle);
                                    orden++;
                                } else {
                                    mensaje = "FNo se encuentra la cuenta contable (Gasto XIV)...";
                                }
                            }
                        }
                    }
                    if (i == 18) {
                        if (rhCtaIessTO != null) {
                            if (rhCtaIessTO.getEmpFechaAfiliacionIess() != null) {
                                conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                        (rhCategoriaTO.getCtaGastoFondoreserva() == null) ? "" : rhCategoriaTO.getCtaGastoFondoreserva()));//forma pago
                                conDetalle.setDetDebitoCredito('D');
                                conDetalle.setDetReferencia("FR");//
                                conDetalle.setDetValor(rhRol.getRolFondoReserva());////////////
                                conDetalle.setDetOrden(orden);//
                                if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                    if (conDetalle.getConCuentas() != null) {
                                        listaConDetalle.add(conDetalle);
                                        orden++;
                                    } else {
                                        mensaje = "FNo se encuentra la cuenta contable (Gasto Fondo Reserva)...";
                                    }
                                }
                            }
                        }
                    }
////////////////////////////////////
                    if (i == 19) {
                        if (rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getEstadoCtaRhIess().equals("IESS")) {
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                    (rhCategoriaTO.getCtaGastoBonos() == null) ? "" : rhCategoriaTO.getCtaGastoBonos()));//forma pago
                            conDetalle.setDetDebitoCredito('D');
                            conDetalle.setDetReferencia("BONO");//
                            conDetalle.setDetValor(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getRolIngresosExtras());////////////
                            conDetalle.setDetOrden(orden);//
                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                if (conDetalle.getConCuentas() != null) {
                                    listaConDetalle.add(conDetalle);
                                    orden++;
                                } else {
                                    mensaje = "FNo se encuentra la cuenta contable (Bono)...";
                                }
                            }
                        }
                    }
                    if (i == 19) {
                        if (!rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getEstadoCtaRhIess().equals("IESS")) {
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                    (rhCategoriaTO.getCtaGastoBonosNd() == null) ? "" : rhCategoriaTO.getCtaGastoBonosNd()));//forma pago
                            conDetalle.setDetDebitoCredito('D');
                            conDetalle.setDetReferencia("BONO-ND");
                            conDetalle.setDetValor(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getRolIngresosExtras());////////////
                            conDetalle.setDetOrden(orden);//
                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                if (conDetalle.getConCuentas() != null) {
                                    listaConDetalle.add(conDetalle);
                                    orden++;
                                } else {
                                    mensaje = "FNo se encuentra la cuenta contable (Bono ND)...";
                                }
                            }
                        }
                    }
////////////////////////////////////
                    if (i == 20) {
                        if (!rhCancelarBeneficioSocialTO.getEmpCancelarFondoReservaMensualmente() && rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getEstadoCtaRhIess().equals("IESS")) {
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                    (rhCategoriaTO.getCtaFondoreserva() == null) ? "" : rhCategoriaTO.getCtaFondoreserva()));//categoria
                            conDetalle.setDetDebitoCredito('C');
                            conDetalle.setDetReferencia("FR");//
                            conDetalle.setDetValor(rhRol.getRolFondoReserva());////////////
                            conDetalle.setDetOrden(orden);//
                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                if (conDetalle.getConCuentas() != null) {
                                    listaConDetalle.add(conDetalle);
                                    orden++;
                                } else {
                                    mensaje = "FNo se encuentra la cuenta contable (Fondo Reserva)...";
                                }
                            }
                        }
                    }
                    if (i == 21) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaAportepersonal() == null) ? "" : rhCategoriaTO.getCtaAportepersonal()));//forma pago
                        conDetalle.setDetDebitoCredito('C');
                        conDetalle.setDetReferencia("IESS");//
                        conDetalle.setDetValor(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getValorIess());////////////
                        conDetalle.setDetOrden(orden);//
                        if (rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getEstadoCtaRhIess().equals("IESS")) {
                            listaConDetalle.add(conDetalle);
                            orden++;
                        }
                    }
                    if (i == 22) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaPorPagarImpuestoRenta() == null) ? "" : rhCategoriaTO.getCtaPorPagarImpuestoRenta()));//forma pago
                        conDetalle.setDetDebitoCredito('C');
                        conDetalle.setDetReferencia("IR");//
                        conDetalle.setDetValor(valorImpuestoRenta);////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Impuesto Renta)...";
                            }
                        }
                    }
                    if (i == 23) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaAnticipos() == null) ? "" : rhCategoriaTO.getCtaAnticipos()));//forma pago
                        conDetalle.setDetDebitoCredito('C');
                        conDetalle.setDetReferencia("ANT");//
                        conDetalle.setDetValor(rhRol.getRolAnticipos());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Anticipo)...";
                            }
                        }
                    }
                    if (i == 24) {
                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                (rhCategoriaTO.getCtaPrestamos() == null) ? "" : rhCategoriaTO.getCtaPrestamos()));//forma pago
                        conDetalle.setDetDebitoCredito('C');
                        conDetalle.setDetReferencia("PRE");//
                        conDetalle.setDetValor(rhRol.getRolPrestamos());////////////
                        conDetalle.setDetOrden(orden);//
                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                            if (conDetalle.getConCuentas() != null) {
                                listaConDetalle.add(conDetalle);
                                orden++;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (Prestamo)...";
                            }
                        }
                    }
                    if (i == 25) {
                        if (!rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().isPorPagar()) {
                            rhCtaFormaPagoTO = operacionesRRHHDAOLocal.buscarCtaRhFormaPago(
                                    sisInfoTO.getInfEmpresa(),
                                    rhFunPlantillaSueldosLoteTO.getRolFormaPago());
                            if (rhCtaFormaPagoTO.getCtaCodigo() != null) {
                                if (rhCtaFormaPagoTO.getCtaCodigo() != null) {
                                    ctaRhFormasPago = rhCtaFormaPagoTO.getCtaCodigo();
                                    conDetalle.setSecCodigo(rhCtaFormaPagoTO.getSecCodigo());
                                    conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                            (ctaRhFormasPago == null) ? "" : ctaRhFormasPago));//forma pago
                                    conDetalle.setDetDebitoCredito('C');
                                    conDetalle.setDetReferencia("FP");//
                                    conDetalle.setDetDocumento(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getConDetDocumento());
                                    if (rhCancelarBeneficioSocialTO.getEmpCancelarXiiiSueldoMensualmente()) {
                                        rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolXiii())));
                                    }
                                    if (rhCancelarBeneficioSocialTO.getEmpCancelarXivSueldoMensualmente()) {
                                        rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolXiv())));
                                    }
                                    if (rhCancelarBeneficioSocialTO.getEmpCancelarFondoReservaMensualmente()) {
                                        rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolFondoReserva())));
                                    }
                                    rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolBonoFijo()).add(rhRol.getRolBonoFijoNd()).add(rhRol.getRolOtrosIngresos()).add(rhRol.getRolOtrosIngresosNd())));
                                    if (rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getEstadoCtaRhIess().equals("IESS")) {
                                        rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().subtract(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getValorIess())));
                                    }
                                    conDetalle.setDetValor(rhRol.getRolTotal());////////////
                                    conDetalle.setDetOrden(orden);//
                                    if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                        if (conDetalle.getConCuentas() != null) {
                                            valor = valor.add(conDetalle.getDetValor());
                                            listaConDetalle.add(conDetalle);
                                            orden++;
                                        } else {
                                            mensaje = "FNo se encuentra la cuenta contable (Forma Pago)...";
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i == 25) {
                        if (rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().isPorPagar()) {
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(sisInfoTO.getInfEmpresa(),
                                    (rhCategoriaTO.getCtaPorPagarSueldo() == null) ? "" : rhCategoriaTO.getCtaPorPagarSueldo()));//forma pago
                            conDetalle.setDetDebitoCredito('C');
                            conDetalle.setDetReferencia("FP");//
                            conDetalle.setDetDocumento(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getConDetDocumento());
                            if (rhCancelarBeneficioSocialTO.getEmpCancelarXiiiSueldoMensualmente()) {
                                rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolXiii())));
                            }
                            if (rhCancelarBeneficioSocialTO.getEmpCancelarXivSueldoMensualmente()) {
                                rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolXiv())));
                            }
                            if (rhCancelarBeneficioSocialTO.getEmpCancelarFondoReservaMensualmente()) {
                                rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolFondoReserva())));
                            }
                            rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolBonoFijo()).add(rhRol.getRolBonoFijoNd()).add(rhRol.getRolOtrosIngresos()).add(rhRol.getRolOtrosIngresosNd())));
                            if (rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getEstadoCtaRhIess().equals("IESS")) {
                                rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().subtract(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getValorIess())));
                            }
                            conDetalle.setDetValor(rhRol.getRolTotal());////////////
                            conDetalle.setDetOrden(orden);//
                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                if (conDetalle.getConCuentas() != null) {
                                    listaConDetalle.add(conDetalle);
                                    orden++;
                                } else {
                                    mensaje = "FNo se encuentra la cuenta contable (Saldo Anterior)...";
                                }
                            }
                            if (conDetalle.getDetValor().compareTo(cero) < 0) {
                                if (conDetalle.getConCuentas() != null) {
                                    conDetalle.setDetDebitoCredito('D');
                                    conDetalle.setDetValor(conDetalle.getDetValor().abs());
                                    valor = valor.add(conDetalle.getDetValor());
                                    listaConDetalle.add(conDetalle);
                                    orden++;
                                } else {
                                    mensaje = "FNo se encuentra la cuenta contable (Saldo Anterior)...";
                                }
                            }
                            if (conDetalle.getDetValor().compareTo(cero) == 0) {
                                mensaje = "FNo se puede generar con valor cero";
                            }
                        }
                    }
                    conDetalle = null;
                }
                rhCategoriaTO.setCtaGastoSueldos(rhCategoriaTO.getCtaGastoSueldos() == null ? "" : rhCategoriaTO.getCtaGastoSueldos());
                ctaRhFormasPago = ctaRhFormasPago == null ? "" : ctaRhFormasPago;
                rhCategoriaTO.setCtaPorPagarSueldo(rhCategoriaTO.getCtaPorPagarSueldo() == null ? "" : rhCategoriaTO.getCtaPorPagarSueldo());
                comprobar = false;
                if (mensaje.isEmpty() && !rhCategoriaTO.getCtaGastoSueldos().isEmpty() && (!ctaRhFormasPago.isEmpty() || !rhCategoriaTO.getCtaPorPagarSueldo().isEmpty())) {//revisar si estan llenos
                    rhRol.setRolDiasLaboradosReales(new Short(String.valueOf(rhFunPlantillaSueldosLoteTO.getRolDiasFaltasReales() + rhFunPlantillaSueldosLoteTO.getRolDiasLaboradosReales())));
                    java.util.List<rrhh.entity.RhRol> rhRoles = new java.util.ArrayList(0);
                    rhRoles.add(rhRol);
                    if (rhRoles.size() == 1) {
                        susDetalle = "Rol a " + operacionesRRHHDAOLocal.getRhEmpleadoApellidosNombres(
                                rhRoles.get(0).getRhEmpleado().getRhEmpleadoPK().getEmpEmpresa(),
                                rhRoles.get(0).getRhEmpleado().getRhEmpleadoPK().getEmpId()) + " por $" + valor.toPlainString();
                    } else {
                        susDetalle = "Roles totales a varios empleados " + " por $" + valor.toPlainString();
                    }
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    comprobar = operacionesRRHHDAOTransaccionLocal.insertarRhRol(
                            rhRoles,
                            rhEmpleado,
                            conContable,
                            listaConDetalle,
                            sisSuceso,
                            conNumeracion,
                            sisInfoTO);
                } else if (rhCtaIessTO == null) {
                    mensaje = "FNo se encuentra la cuenta contable (IESS)...";
                } else if (rhCtaIessTO.getCtaAportepersonal() == null) {
                    mensaje = "FNo se encuentra la cuenta contable (IESS)...";
                }
                if (comprobar) {
                    sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                    contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                    mensaje = "T<html><font color = GREEN>" + mensaje + "Se ingresó el contable con la siguiente información:<br>"
                            + "Periodo: <font size = 5>"
                            + sisPeriodo.getPerDetalle()
                            + "</font><br> Tipo: <font size = 5>"
                            + conTipo.getTipDetalle()
                            + "</font><br> Número: <font size = 5>"
                            + conContable.getConContablePK().getConNumero()
                            + "</font></font></html>";
                }
            } else {
                mensaje = "FNo se encuentra tipo de contable...";
            }
        }
        return rhContableTO;
    }

    @Override
    public RhContableTO insertarRhRolConContable(
            RhRolEmpleadoTO rhRolEmpleadoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        RhParametrosTO rhParametrosTO = null;
        RhContableTO rhContableTO = new RhContableTO();
        RhCtaFormaPagoTO rhCtaFormaPagoTO = new RhCtaFormaPagoTO();
        String tipDetalle = "C-ROL";
        mensaje = "";
        String ctaRhFormasPago = null;
        String ctaRhGastoSueldo = "";
        String estadoCtaRhIess = "";
        String ctaRhGastoXiii = "";
        String ctaRhGastoXiv = "";
        String ctaRhFondoReserva = "";
        String ctaRhGastoFondoReserva = "";
        String ctaRhXiii = "";
        String ctaRhXiv = "";
        String ctaRhVacaciones = "";
        String ctaRhGastoSalarioDigno = "";
        String ctaRhDesahucio = "";
        String ctaRhDesahucioIntempestivo = "";
        String ctaRhAnticipo = "";
        String ctaRhBono = "";
        String ctaRhBonoND = "";
        String ctaRhBonoFijo = "";
        String ctaRhBonoFijoND = "";
        String ctaRhOtrosIngresos = "";
        String ctaRhOtrosIngresosND = "";
        String ctaRhPrestamo = "";
        String ctaRhViatico = "";
        String ctaRhPorPagarSueldos = "";
        String ctaRhAportePersonal = "";
        String ctaRhImpuestoRenta = "";
        Integer diasLaborados = 0;
        BigDecimal ingresoPermisoMedico = cero;
        BigDecimal rolIngresosExtras = cero;
        java.math.BigDecimal valorImpuestoRenta = cero;
        Boolean empleadoRetencion = false;
        RhCancelarBeneficioSocialTO rhCancelarBeneficioSocialTO;
        RhRolTO rhRolTO = null;
        RhEmpleadoRolTO rhEmpleadoRolTO = null;
        rrhh.entity.RhEmpleado rhEmpleado = null;
        BigDecimal valor = cero;
        try {
            ////// BUSCANDO EMPLEADO RETENCION
            empleadoRetencion = operacionesRRHHDAOLocal.getRhEmpleadoRetencion(
                    rhRolEmpleadoTO.getEmpCodigo(),
                    rhRolEmpleadoTO.getEmpId());
            ////// BUSCANDO AFILIACION
            RhCtaIessTO rhCtaIessTO = operacionesRRHHDAOLocal.buscarCtaRhIess(
                    rhRolEmpleadoTO.getEmpCodigo(),
                    rhRolEmpleadoTO.getEmpId());
            ////// BUSCANDO Beneficio Social
            rhCancelarBeneficioSocialTO = operacionesRRHHDAOLocal.getRhCancelarBeneficioSocialTO(
                    rhRolEmpleadoTO.getEmpCodigo(),
                    rhRolEmpleadoTO.getEmpId());
            ///// BUSCANDO EMPLEADO
            rrhh.entity.RhEmpleado rhEmpleadoAux = operacionesRRHHDAOLocal.buscarEmpleado(
                    rhRolEmpleadoTO.getEmpCodigo(),
                    rhRolEmpleadoTO.getEmpId());
            rhEmpleado = ConversionesRRHH.convertirRhEmpleado_RhEmpleado(
                    rhEmpleadoAux);
            if (rhRolEmpleadoTO.getLiquidacion() && rhRolEmpleadoTO.getGrabar()) {
                rhEmpleado.setEmpInactivo(true);
                if (rhEmpleado.getEmpFechaPrimeraSalida() == null) {
                    rhEmpleado.setEmpFechaPrimeraSalida(Validacion.fecha(rhRolEmpleadoTO.getFechaSalida(), "yyyy-MM-dd"));
                } else {
                    rhEmpleado.setEmpFechaUltimaSalida(Validacion.fecha(rhRolEmpleadoTO.getFechaSalida(), "yyyy-MM-dd"));
                }
                rhEmpleado.setEmpMotivoSalida(rhRolEmpleadoTO.getMotivoSalida());
            }
            ////// BUSCANDO PARAMETROS
            rhParametrosTO = operacionesRRHHDAOLocal.getRhParametros(
                    rhRolEmpleadoTO.getRolHasta());
            if (rhParametrosTO.getParSalarioMinimoVital() != null) {
                //fecha ultimo sueldo
//                String fechaUltimoSueldo = operacionesRRHHDAOLocal.buscarFechaRhRol(
//                        rhRolEmpleadoTO.getEmpCodigo(), rhRolEmpleadoTO.getEmpId());
                String fechaUltimoSueldo = getRhRolSueldoEmpleadoTO(
                        rhRolEmpleadoTO.getEmpCodigo(),
                        rhRolEmpleadoTO.getEmpId()).getRolFechaUltimoSueldo();
                if (fechaUltimoSueldo.isEmpty()) {
                    comprobar = true;
                } else {
                    comprobar = Validacion.fecha(rhRolEmpleadoTO.getRolDesde(), "yyyy-MM-dd").getTime()
                            > Validacion.fecha(fechaUltimoSueldo, "yyyy-MM-dd").getTime();
                }
                if (comprobar) {
                    comprobar = false;
                    //periodo
                    List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
                    listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(rhRolEmpleadoTO.getEmpCodigo());

                    for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                        if (Validacion.fecha(rhRolEmpleadoTO.getRolHasta(), "yyyy-MM-dd").getTime()
                                >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                                && Validacion.fecha(rhRolEmpleadoTO.getRolHasta(), "yyyy-MM-dd").getTime()
                                <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                                && sisListaPeriodoTO.getPerCerrado() == false) {
                            comprobar = true;
                            rhRolEmpleadoTO.setPerCodigo(sisListaPeriodoTO.getPerCodigo());
                            break;
                        }
                    }
                    if (comprobar) {
                        comprobar = false;
                        rhEmpleadoRolTO = operacionesRRHHDAOLocal.getEmpleadoRolTO(
                                rhRolEmpleadoTO.getEmpCodigo(), rhRolEmpleadoTO.getEmpId());
                        if (rhEmpleadoRolTO != null) {
                            //Llenar ROLTO
                            rhRolTO = new RhRolTO();
                            rhRolTO.setEmpCodigo(rhRolEmpleadoTO.getEmpCodigo());
                            rhRolTO.setPerCodigo(rhRolEmpleadoTO.getPerCodigo());
                            tipDetalle = operacionesRRHHDAOLocal.buscarCategoriaTipo(
                                    rhRolEmpleadoTO.getEmpCodigo(),
                                    rhRolEmpleadoTO.getEmpId(),
                                    rhEmpleadoRolTO.getCatNombre());
                            rhRolTO.setTipCodigo(tipDetalle);
                            rhRolTO.setConNumero(rhRolEmpleadoTO.getConNumero());
                            rhRolTO.setSecCodigo(rhRolEmpleadoTO.getSecCodigo());
                            rhRolTO.setEmpId(rhRolEmpleadoTO.getEmpId());
                            rhRolTO.setEmpCargo(rhRolEmpleadoTO.getRolCargo());
                            rhRolTO.setRolFechaUltimoSueldo(rhRolEmpleadoTO.getRolFechaUltimoSueldo());
                            rhRolTO.setRolDesde(rhRolEmpleadoTO.getRolDesde());
                            rhRolTO.setRolHasta(rhRolEmpleadoTO.getRolHasta());
                            rhRolTO.setRolDiasFaltasReales(rhRolEmpleadoTO.getRolDiasFaltasReales());
                            rhRolTO.setRolDiasExtrasReales(rhRolEmpleadoTO.getRolDiasExtrasReales());
                            rhRolTO.setEmpSueldo(rhRolEmpleadoTO.getRolSueldo());
                            rhRolTO.setRolLiqFondoReserva(rhRolEmpleadoTO.getRolLiqFondoReserva());
                            rhRolTO.setRolLiqXiii(rhRolEmpleadoTO.getRolLiqXiii());
                            rhRolTO.setRolLiqXiv(rhRolEmpleadoTO.getRolLiqXiv());
                            rhRolTO.setRolLiqVacaciones(rhRolEmpleadoTO.getRolLiqVacaciones());

                            rhRolTO.setRolLiqSalarioDigno(rhRolEmpleadoTO.getRolLiqSalarioDigno());
                            rhRolTO.setRolLiqDesahucio(rhRolEmpleadoTO.getRolLiqDesahucio());
                            rhRolTO.setRolLiqDesahucioIntempestivo(rhRolEmpleadoTO.getRolLiqDesahucioIntempestivo());
                            rhRolTO.setRolFormaPago(rhRolEmpleadoTO.getRolFormaPago());
                            rhRolTO.setRolDiasPermisoMedico(rhRolEmpleadoTO.getRolDiasPermisoMedico());
                            rhRolTO.setRolDescuentoPermisoMedico(cero);
                            rhRolTO.setReversar(rhRolEmpleadoTO.getReversar());
                            rhRolTO.setEmpSalarioNeto(rhEmpleado.getEmpSalarioNeto());
                            rhRolTO.setRolLiqBonificacion(rhRolEmpleadoTO.getRolLiqBonificacion());

                            //----------------------------------------------------------------------------------------------------------------------------------------
                            rhRolTO.setEmpCancelarXiiiSueldoMensualmente(rhCancelarBeneficioSocialTO.getEmpCancelarXiiiSueldoMensualmente());
                            rhRolTO.setEmpCancelarXivSueldoMensualmente(rhCancelarBeneficioSocialTO.getEmpCancelarXivSueldoMensualmente());
                            rhRolTO.setEmpBonosFijo(rhEmpleado.getEmpBonoFijo());
                            rhRolTO.setEmpBonosFijoNd(rhEmpleado.getEmpBonoFijoNd());
                            rhRolTO.setRolBonosFijo(rhEmpleado.getEmpBonoFijo());
                            rhRolTO.setRolBonosFijoNd(rhEmpleado.getEmpBonoFijoNd());
                            rhRolTO.setEmpOtrosIngresos(rhEmpleado.getEmpOtrosIngresos());
                            rhRolTO.setEmpOtrosIngresosNd(rhEmpleado.getEmpOtrosIngresosNd());
                            rhRolTO.setRolOtrosIngresos(rhEmpleado.getEmpOtrosIngresos());
                            rhRolTO.setRolOtrosIngresosNd(rhEmpleado.getEmpOtrosIngresosNd());
//----------------------------------------------------------------------------------------------------------------------------------------
                            rhRolTO.setEmpCancelarFondoReservaMensualmente(rhCancelarBeneficioSocialTO.getEmpCancelarFondoReservaMensualmente());
                            //conseguir saldos
                            String fechaDesde = (fechaUltimoSueldo.isEmpty()) ? rhRolEmpleadoTO.getRolDesde()
                                    : validaciones.Validacion.fechaSumarDias(java.sql.Date.valueOf(fechaUltimoSueldo), 1);
                            RhRolSaldoEmpleadoTO rhRolSaldoEmpleadoTO = operacionesRRHHDAOLocal.getRhRolSaldoEmpleado(
                                    rhRolEmpleadoTO.getEmpCodigo(), rhRolEmpleadoTO.getEmpId(),
                                    fechaDesde, rhRolEmpleadoTO.getRolHasta());
                            rhRolTO.setRolBonos(rhRolSaldoEmpleadoTO.getSaldoBono());
                            rhRolTO.setRolBonosnd(rhRolSaldoEmpleadoTO.getSaldoBonond());
                            rhRolTO.setRolViaticos(rhRolSaldoEmpleadoTO.getSaldoViaticos());
                            rhRolTO.setRolAnticipos(rhRolSaldoEmpleadoTO.getSaldoAnticipo());
                            rhRolTO.setRolSaldoAnterior(rhRolSaldoEmpleadoTO.getSaldoAnterior());
                            rhRolTO.setRolPrestamos(rhRolEmpleadoTO.getRolPrestamos());
                            //CALCULANDO SUELDO
                            //informacion de respaldo del empleado
                            rhRolTO.setEmpDiasLaborados(rhEmpleadoRolTO.getEmpDiasTrabajados());
                            rhRolTO.setEmpDiasDescanso(rhEmpleadoRolTO.getEmpDiasDescanso());
                            rhRolTO.setEmpSueldo(rhEmpleadoRolTO.getEmpSueldoIess());
                            //calculo de dias descanso
                            int primerosDias = validaciones.Validacion.obtenerDiasAAMMDD(rhRolTO.getRolDesde(), null);
                            int ultimosDias = validaciones.Validacion.obtenerDiasAAMMDD(null, rhRolTO.getRolHasta());

                            if (rhCtaIessTO != null) {
//                                if ((primerosDias==0 && ultimosDias==0)&&(rhCtaIessTO.getEmpFechaAfiliacionIess() != null))
//                                    diasLaborados = 30;
//                                else
//                                    diasLaborados = validaciones.Validacion.obtenerDiasAAMMDD(rhRolTO.getRolHasta(), rhRolTO.getRolDesde()) + 1;
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (IESS)...";
                            }

                            diasLaborados = 30 - primerosDias - ultimosDias;

                            /*
                             * if(primerosDias!=0 && ultimosDias == 0 &&
                             * rhRolTO.getRolHasta().trim().substring(5,
                             * 7).equals("02")){ //diasLaborados = 28 -
                             * primerosDias - ultimosDias; diasLaborados =
                             * validaciones.Validacion.obtenerDiasAAMMDD(rhRolTO.getRolHasta(),
                             * rhRolTO.getRolDesde())+1;
                             * System.out.println("diasLaborados if
                             * febrero:"+diasLaborados); }
                             */
                            if ((primerosDias == 0 && ultimosDias != 0) || (primerosDias != 0 && ultimosDias != 0)) {
                                diasLaborados = validaciones.Validacion.obtenerDiasAAMMDD(rhRolTO.getRolHasta(), rhRolTO.getRolDesde()) + 1;
                            }

                            if (rhRolEmpleadoTO.getEmpFormaPago().equals("MENSUAL")) {
                                //CALCULO DIAS LABORADOS REALES
                                rhRolTO.setRolDiasLaboradosReales(diasLaborados - rhRolTO.getRolDiasFaltasReales());
                                rhRolTO.setRolDiasDescansoReales(0);
                            }
                            if (rhRolEmpleadoTO.getEmpFormaPago().equals("DIARIO")) {
                                //CALCULO DIAS LABORADOS REALES
                                rhRolTO.setRolDiasLaboradosReales(diasLaborados - rhRolTO.getRolDiasFaltasReales());
                                rhRolTO.setRolDiasDescansoReales(Math.round((rhRolTO.getRolDiasLaboradosReales() * rhRolTO.getEmpDiasDescanso()) / (float) rhRolTO.getEmpDiasLaborados()));
                            }
                            //calculo sueldo
                            rhRolTO.setRolDiasPagadosReales(rhRolTO.getRolDiasLaboradosReales() + rhRolTO.getRolDiasDescansoReales());
                            //operaciones matematicas
                            rolIngresosExtras = rhRolTO.getRolDiasExtrasReales();
                            BigDecimal multiplicador = rhRolTO.getRolDiasPermisoMedico() >= 3 ? new BigDecimal("3") : new BigDecimal(rhRolTO.getRolDiasPermisoMedico());
                            BigDecimal ingresoPermisoMedico2=null;
                            if (rhRolEmpleadoTO.getEmpFormaPago().equals("MENSUAL")) {
                                //rolIngresosExtras = redondeoDecimalBigDecimal((rhRolTO.getEmpSueldo().divide(new BigDecimal(rhRolTO.getEmpDiasLaborados()), 9, RoundingMode.HALF_UP)).multiply(rhRolTO.getRolDiasExtrasReales()));
                                rhRolTO.setRolIngresos(redondeoDecimalBigDecimal((rhRolTO.getEmpSueldo().divide(new BigDecimal(rhRolTO.getEmpDiasLaborados()), 9, RoundingMode.HALF_UP)).multiply(new BigDecimal(rhRolTO.getRolDiasLaboradosReales()))));
                                ingresoPermisoMedico = redondeoDecimalBigDecimal((rhRolTO.getEmpSueldo().divide(new BigDecimal(rhRolTO.getEmpDiasLaborados()), 9, RoundingMode.HALF_UP)).multiply(new BigDecimal(rhRolTO.getRolDiasPermisoMedico())));
                                ingresoPermisoMedico2 = redondeoDecimalBigDecimal((rhRolTO.getEmpSueldo().divide(new BigDecimal(rhRolTO.getEmpDiasLaborados()), 9, RoundingMode.HALF_UP)).multiply(multiplicador));
                            }
                            if (rhRolEmpleadoTO.getEmpFormaPago().equals("DIARIO")) {
                                //rolIngresosExtras = redondeoDecimalBigDecimal((rhRolTO.getEmpSueldo().divide(new BigDecimal(rhRolTO.getEmpDiasLaborados() + rhRolTO.getEmpDiasDescanso()), 9, RoundingMode.HALF_UP)).multiply(rhRolTO.getRolDiasExtrasReales()));
                                rhRolTO.setRolIngresos(redondeoDecimalBigDecimal((rhRolTO.getEmpSueldo().divide(new BigDecimal(rhRolTO.getEmpDiasLaborados() + rhRolTO.getEmpDiasDescanso()), 9, RoundingMode.HALF_UP)).multiply(new BigDecimal(rhRolTO.getRolDiasPagadosReales()))));
                                ingresoPermisoMedico = redondeoDecimalBigDecimal((rhRolTO.getEmpSueldo().divide(new BigDecimal(rhRolTO.getEmpDiasLaborados() + rhRolTO.getEmpDiasDescanso()), 9, RoundingMode.HALF_UP)).multiply(new BigDecimal(rhRolTO.getRolDiasPermisoMedico())));
                                ingresoPermisoMedico2 = redondeoDecimalBigDecimal((rhRolTO.getEmpSueldo().divide(new BigDecimal(rhRolTO.getEmpDiasLaborados() + rhRolTO.getEmpDiasDescanso()), 9, RoundingMode.HALF_UP)).multiply(multiplicador));
                            }
                            if (rhRolTO.getRolDiasPermisoMedico() > 0) {
                                System.out.println("sisInfoTO.getInfEmpresaRuc() "+sisInfoTO.getInfEmpresaRuc());
                                if (sisInfoTO.getInfEmpresaRuc().equals("0791749891001")) {// minereicis MRC0791749891001  0791749891001
                                    rhRolTO.setRolDescuentoPermisoMedico(redondeoDecimalBigDecimal(ingresoPermisoMedico.multiply(new BigDecimal(1.00))));
                                    
                                    rhRolTO.setRolDescuentoPermisoMedico(rhRolTO.getRolDescuentoPermisoMedico().subtract(ingresoPermisoMedico2.multiply(new BigDecimal("1.0"))));
                                } else {
                                    rhRolTO.setRolDescuentoPermisoMedico(redondeoDecimalBigDecimal(ingresoPermisoMedico.multiply(new BigDecimal(0.75))));
                                }
                            }

                            rhRolTO.setRolTotal(redondeoDecimalBigDecimal(rhRolTO.getRolIngresos().add(rhRolSaldoEmpleadoTO.getSaldoBono().add(rhRolSaldoEmpleadoTO.getSaldoBonond().add(rhRolSaldoEmpleadoTO.getSaldoViaticos()).add(rhRolSaldoEmpleadoTO.getSaldoAnterior()).subtract(rhRolSaldoEmpleadoTO.getSaldoAnticipo()).subtract(rhRolTO.getRolPrestamos())))));
                            rhRolTO.setRolTotal(redondeoDecimalBigDecimal(rhRolTO.getRolTotal().add(rhRolTO.getRolLiqFondoReserva().add(rhRolTO.getRolLiqXiii()).add(rhRolTO.getRolLiqXiv()).add(rhRolTO.getRolLiqVacaciones()).add(rhRolTO.getRolLiqSalarioDigno()).add(rhRolTO.getRolLiqBonificacion()).add(rhRolTO.getRolLiqDesahucio()).add(rhRolTO.getRolLiqDesahucioIntempestivo()))));
                            rhRolTO.setRolTotal(redondeoDecimalBigDecimal(rhRolTO.getRolTotal().subtract(rhRolTO.getRolDescuentoPermisoMedico())));
                            rhRolTO.setEmpDescuentoPermisoMedico(redondeoDecimalBigDecimal(rhRolTO.getRolDescuentoPermisoMedico()));

                            //BONOS
                            rhRolTO.setRolBonosFijo(redondeoDecimalBigDecimal((rhEmpleado.getEmpBonoFijo().multiply(BigDecimal.valueOf(rhRolTO.getRolDiasLaboradosReales()))).divide(BigDecimal.valueOf(rhEmpleado.getEmpDiasTrabajados()), 9, RoundingMode.HALF_UP)));
                            rhRolTO.setRolBonosFijoNd(redondeoDecimalBigDecimal((rhEmpleado.getEmpBonoFijoNd().multiply(BigDecimal.valueOf(rhRolTO.getRolDiasLaboradosReales()))).divide(BigDecimal.valueOf(rhEmpleado.getEmpDiasTrabajados()), 9, RoundingMode.HALF_UP)));
                            rhRolTO.setRolOtrosIngresos(redondeoDecimalBigDecimal((rhEmpleado.getEmpOtrosIngresos().multiply(BigDecimal.valueOf(rhRolTO.getRolDiasLaboradosReales()))).divide(BigDecimal.valueOf(rhEmpleado.getEmpDiasTrabajados()), 9, RoundingMode.HALF_UP)));
                            rhRolTO.setRolOtrosIngresosNd(redondeoDecimalBigDecimal((rhEmpleado.getEmpOtrosIngresosNd().multiply(BigDecimal.valueOf(rhRolTO.getRolDiasLaboradosReales()))).divide(BigDecimal.valueOf(rhEmpleado.getEmpDiasTrabajados()), 9, RoundingMode.HALF_UP)));

                            //rhRolTO.setRolBonosFijo(redondeoDecimalBigDecimal((BigDecimal.valueOf(rhRolTO.getEmpDiasLaborados()).multiply(rhRolTO.getRolBonosFijo())).divide(new BigDecimal(31), 9, RoundingMode.HALF_UP)));
                            //rhRolTO.setRolBonosFijoNd(redondeoDecimalBigDecimal((rhRolTO.getRolIngresos().multiply(rhRolTO.getRolBonosFijoNd())).divide(rhRolTO.getEmpSueldo(), 9, RoundingMode.HALF_UP)));
                            //rhRolTO.setRolOtrosIngresos(redondeoDecimalBigDecimal((rhRolTO.getRolIngresos().multiply(rhRolTO.getRolOtrosIngresos())).divide(rhRolTO.getEmpSueldo(), 9, RoundingMode.HALF_UP)));
                            //rhRolTO.setRolOtrosIngresosNd(redondeoDecimalBigDecimal((rhRolTO.getRolIngresos().multiply(rhRolTO.getRolOtrosIngresosNd())).divide(rhRolTO.getEmpSueldo(), 9, RoundingMode.HALF_UP)));

                            BigDecimal valorBaseImponible = rhRolTO.getRolOtrosIngresos().add(rhRolTO.getRolIngresos().add(rhRolTO.getRolBonosFijo()).add(rhRolTO.getRolBonos().add(rolIngresosExtras)));

                            //CUADRO PROVICIONES
                            rhRolTO.setRolFondoReserva(redondeoDecimalBigDecimal(valorBaseImponible.multiply(new BigDecimal("8.33")).divide(new BigDecimal(100), 9, RoundingMode.HALF_UP)));
                            rhRolTO.setRolXiii(redondeoDecimalBigDecimal(valorBaseImponible.divide(new BigDecimal(12), 9, RoundingMode.HALF_UP)));
                            rhRolTO.setRolXiv(redondeoDecimalBigDecimal(rhParametrosTO.getParSalarioMinimoVital().divide(new BigDecimal(12), 9, RoundingMode.HALF_UP)));
                            //valor = valor proporcional entre sueldo e ingresos
                            java.math.BigDecimal valorQ = (rhRolTO.getRolIngresos().multiply(new BigDecimal(100))).divide(rhRolTO.getEmpSueldo(), 9, RoundingMode.HALF_UP);
                            rhRolTO.setRolXiv(redondeoDecimalBigDecimal((rhRolTO.getRolXiv().multiply(valorQ)).divide(new BigDecimal(100), 9, RoundingMode.HALF_UP)));
                            rhRolTO.setRolVacaciones(redondeoDecimalBigDecimal(valorBaseImponible.divide(new BigDecimal(24), 9, RoundingMode.HALF_UP)));
                            rhRolTO.setRolDesahucio(redondeoDecimalBigDecimal(valorBaseImponible.divide(new BigDecimal(4), 9, RoundingMode.HALF_UP).divide(new BigDecimal(12), 9, RoundingMode.HALF_UP)));

                            java.math.BigDecimal aporteIndividual = java.math.BigDecimal.ZERO;
                            if (rhCtaIessTO != null) {
                                if (rhCtaIessTO.getEmpExtensionCoberturaIess()) {
                                    aporteIndividual = rhParametrosTO.getParIessPorcentajeAporteIndividual().add(rhParametrosTO.getParIessPorcentajeAporteExtendido());
                                } else {
                                    aporteIndividual = rhParametrosTO.getParIessPorcentajeAporteIndividual();
                                }
                            } else {
                                mensaje = "No se encuentra la cuenta contable (IESS)...";
                            }


                            //BigDecimal valorIess = redondeoDecimalBigDecimal(rhRolTO.getRolIngresos().add(rhRolTO.getRolBonosFijo()).add(rhRolSaldoEmpleadoTO.getSaldoBono().add(rolIngresosExtras)).multiply(aporteIndividual.divide(new BigDecimal(100), 9, RoundingMode.HALF_UP)));
                            BigDecimal valorIess = redondeoDecimalBigDecimal(valorBaseImponible.multiply(aporteIndividual.divide(new BigDecimal(100), 9, RoundingMode.HALF_UP)));
                            BigDecimal valorAportePatronal = redondeoDecimalBigDecimal(valorBaseImponible.multiply(rhParametrosTO.getParIessPorcentajeAportePatronal().divide(new BigDecimal(100), 9, RoundingMode.HALF_UP)));
                            BigDecimal valorIece = redondeoDecimalBigDecimal(valorBaseImponible.multiply(rhParametrosTO.getParIessPorcentajeIece().divide(new BigDecimal(100), 9, RoundingMode.HALF_UP)));
                            BigDecimal valorSecap = redondeoDecimalBigDecimal(valorBaseImponible.multiply(rhParametrosTO.getParIessPorcentajeSecap().divide(new BigDecimal(100), 9, RoundingMode.HALF_UP)));

                            Integer diasTrabajadosTotales = 0;
                            if (rhCtaIessTO != null) {
                                if (rhCtaIessTO.getEmpFechaAfiliacionIess() != null) {
                                    valorImpuestoRenta = operacionesRRHHDAOLocal.getRhValorImpuestoRenta(
                                            rhRolEmpleadoTO.getEmpCodigo(),
                                            rhRolEmpleadoTO.getEmpId(),
                                            rhRolEmpleadoTO.getRolHasta(),
                                            diasLaborados,
                                            rhRolTO.getRolIngresos().add(rhRolTO.getRolBonosFijo()).add(rhRolTO.getRolOtrosIngresos()));
                                    if (valorImpuestoRenta == null) {
                                        valorImpuestoRenta = cero;
                                        mensaje = "<font size = +2 color = BLUE>No se puede calcular correctamente el Impuesto Renta, "
                                                + "</font>";
                                    }
                                    if (!empleadoRetencion) {
                                        valorImpuestoRenta = cero;
                                    }
                                    rhRolTO.setRolTotal(redondeoDecimalBigDecimal(rhRolTO.getRolTotal().subtract(valorImpuestoRenta)));

                                    if (rhCtaIessTO.getEmpFechaPrimerSalida() == null) {
                                        diasTrabajadosTotales = (validaciones.Validacion.obtenerDiasAAMMDD(rhRolEmpleadoTO.getRolDesde(), rhCtaIessTO.getEmpFechaPrimerIngreso()) + 1);
                                    } else if (rhCtaIessTO.getEmpFechaUltimoIngreso() != null) {
                                        diasTrabajadosTotales = (validaciones.Validacion.obtenerDiasAAMMDD(rhRolEmpleadoTO.getRolDesde(), rhCtaIessTO.getEmpFechaUltimoIngreso()) + 1)
                                                + (validaciones.Validacion.obtenerDiasAAMMDD(rhCtaIessTO.getEmpFechaPrimerSalida(), rhCtaIessTO.getEmpFechaPrimerIngreso()) + 1);
                                    }

                                    ctaRhAportePersonal = (rhCtaIessTO.getCtaAportepersonal() == null) ? ""
                                            : rhCtaIessTO.getCtaAportepersonal();//categoria
                                    if (Double.valueOf((valorIess).toString()) > 0) {
                                        if (!ctaRhAportePersonal.isEmpty()) {
                                            estadoCtaRhIess = "IESS";
                                        }
                                    }
                                    rhRolTO.setRolRetencionFuente(valorImpuestoRenta);
                                    rhRolTO.setRolIess(valorIess);
                                    rhRolTO.setRolAportePatronal(valorAportePatronal);
                                    rhRolTO.setRolIece(valorIece);
                                    rhRolTO.setRolSecap(valorSecap);
                                    rhRolTO.setRolBonos(rhRolTO.getRolBonos().add(rolIngresosExtras));
                                } else {
                                    rhRolTO.setRolRetencionFuente(cero);
                                    rhRolTO.setRolIess(cero);
                                    rhRolTO.setRolAportePatronal(cero);
                                    rhRolTO.setRolIece(cero);
                                    rhRolTO.setRolSecap(cero);
                                    rhRolTO.setRolBonosnd(rhRolTO.getRolBonosnd().add(rolIngresosExtras));
                                }
                            } else {
                                mensaje = "FNo se encuentra la cuenta contable (IESS)...";
                            }
                            if (diasTrabajadosTotales < 360) {
                                rhRolTO.setRolFondoReserva(BigDecimal.ZERO);
                            }
                            //sumar horas extras
                            rhRolTO.setRolTotal(rhRolTO.getRolTotal().add(rolIngresosExtras));
                            if (operacionesContabilidadDAOLocal.buscarTipoContable(rhRolEmpleadoTO.getEmpCodigo(), tipDetalle)) {
                                //llenar contable
                                ConContableTO conContableTO = new ConContableTO();
                                conContableTO.setEmpCodigo(rhRolEmpleadoTO.getEmpCodigo());
                                conContableTO.setPerCodigo(rhRolEmpleadoTO.getPerCodigo());
                                conContableTO.setTipCodigo(tipDetalle);
                                rhRolEmpleadoTO.setTipCodigo(tipDetalle);
                                java.util.List<String> fecha = validaciones.Validacion.separar(rhRolEmpleadoTO.getRolHasta(), "-");
                                //licenciado
//                                fecha.set(2, (fecha.get(1).equals("12") && fecha.get(2).equals("31")) ? "30" : fecha.get(2));

                                conContableTO.setConFecha(fecha.get(0) + "-" + fecha.get(1) + "-" + fecha.get(2));
                                conContableTO.setConPendiente(false);
                                conContableTO.setConBloqueado(false);
                                conContableTO.setConAnulado(false);
                                conContableTO.setConGenerado(true);
                                conContableTO.setConConcepto(rhRolEmpleadoTO.getEmpApellidosNombres());//nombre empleado
                                conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                                conContableTO.setConObservaciones(rhRolEmpleadoTO.getConObservaciones());
                                conContableTO.setUsrInsertaContable(rhRolEmpleadoTO.getUsrInsertaRol());
                                conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                                ///// CREANDO UN SUCESO
                                susClave = rhRolEmpleadoTO.getPerCodigo() + " "
                                        + rhRolEmpleadoTO.getTipCodigo() + " "
                                        + rhRolEmpleadoTO.getConNumero();
                                susSuceso = "INSERT";
                                susTabla = "recursoshumanos.rh_rol";
                                ////// CREANDO NUMERACION
                                contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                        conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                                        conContableTO.getTipCodigo()));
                                ////// CREANDO CONTABLE
                                contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                                ////// CREANDO Rol
                                rrhh.entity.RhRol rhRol = rrhh.helper.ConversionesRRHH.convertirRhRolTO_RhRol(rhRolTO);
                                rhRol.setRolReversado(false);
                                if (rhRolEmpleadoTO.getPorPagar()) {
                                    rhRol.setRolFormaPago("POR PAGAR");
                                } else {
                                    rhRol.setRolFormaPago(rhRolEmpleadoTO.getRolFormaPago());
                                }
                                ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                                java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                                ConDetalle conDetalle = null;
                                //conDetalle.setDetSaldo(new BigDecimal("0.00"));
                                //conDetalle.setSecEmpresa(rhRolEmpleadoTO.get);
                                int orden = 0;
                                for (int i = 0; i <= 26; i++) {
                                    conDetalle = new ConDetalle();
                                    conDetalle.setConContable(conContable);
                                    conDetalle.setDetSecuencia(0);
                                    conDetalle.setDetDocumento("");
                                    conDetalle.setSecCodigo(rhRolEmpleadoTO.getSecCodigo());
                                    conDetalle.setPisNumero("");
                                    conDetalle.setDetGenerado(true);
                                    if (i == 0) {
                                        //categoria, cuenta sueldos
                                        ctaRhGastoSueldo = operacionesRRHHDAOLocal.buscarCtaRhGastoSueldos(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhGastoSueldo == null) ? "" : ctaRhGastoSueldo));//categoria
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("ROL");//
                                        conDetalle.setDetValor(rhRolTO.getRolIngresos());
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Rol)...";
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                        if (rhRolTO.getRolDiasPermisoMedico() > 0) {
                                            //categoria, cuenta sueldos
                                            ctaRhGastoSueldo = operacionesRRHHDAOLocal.buscarCtaRhGastoSueldos(
                                                    rhRolEmpleadoTO.getEmpCodigo(),
                                                    rhRolEmpleadoTO.getEmpId());
                                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                    (ctaRhGastoSueldo == null) ? "" : ctaRhGastoSueldo));//categoria
                                            conDetalle.setDetDebitoCredito('C');
                                            conDetalle.setDetReferencia("ROL");//
                                            conDetalle.setDetValor(rhRol.getRolDescuentoPermisoMedico());
                                            conDetalle.setDetOrden(orden);//
                                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                                if (conDetalle.getConCuentas() != null) {
                                                    listaConDetalle.add(conDetalle);
                                                    orden++;
                                                } else {
                                                    mensaje = "FNo se encuentra la cuenta contable (Rol)...";
                                                }
                                            }
                                        }
                                    }
                                    if (i == 2) {
                                        ctaRhXiii = operacionesRRHHDAOLocal.buscarCtaRhXiii(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhXiii == null) ? "" : ctaRhXiii));//categoria
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("XIII");//
                                        conDetalle.setDetValor(rhRol.getRolLiqXiii());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (XIII)...";
                                            }
                                        }
                                    }
                                    if (i == 3) {
                                        ctaRhXiv = operacionesRRHHDAOLocal.buscarCtaRhXiv(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhXiv == null) ? "" : ctaRhXiv));//categoria
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("XIV");//
                                        conDetalle.setDetValor(rhRol.getRolLiqXiv());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (XIV)...";
                                            }
                                        }
                                    }
                                    if (i == 4) {
                                        ctaRhVacaciones = operacionesRRHHDAOLocal.buscarCtaRhVacaciones(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhVacaciones == null) ? "" : ctaRhVacaciones));//categoria
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("VAC");//
                                        conDetalle.setDetValor(rhRol.getRolLiqVacaciones());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Vacaciones)...";
                                            }
                                        }
                                    }
                                    if (i == 5) {
                                        ctaRhGastoSalarioDigno = operacionesRRHHDAOLocal.buscarCtaRhGastoSalarioDigno(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhGastoSalarioDigno == null) ? "" : ctaRhGastoSalarioDigno));//categoria
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("SAL-DIG");//
                                        conDetalle.setDetValor(rhRol.getRolLiqSalarioDigno());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Gasto Salario Digno)...";
                                            }
                                        }
                                    }
                                    if (i == 6) {
                                        ctaRhDesahucio = operacionesRRHHDAOLocal.buscarCtaRhDesahucio(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhDesahucio == null) ? "" : ctaRhDesahucio));//categoria
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("DES");//
                                        conDetalle.setDetValor(rhRol.getRolLiqDesahucio());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Desahucio)...";
                                            }
                                        }
                                    }
                                    if (i == 7) {
                                        ctaRhDesahucioIntempestivo = operacionesRRHHDAOLocal.buscarCtaRhGastoDesahucioIntempestivo(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhDesahucioIntempestivo == null) ? "" : ctaRhDesahucioIntempestivo));//categoria
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("DES-INT");//
                                        conDetalle.setDetValor(rhRol.getRolLiqDesahucioIntempestivo());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Desahucio Intempestivo)...";
                                            }
                                        }
                                    }
                                    if (i == 8) {
                                        ctaRhFondoReserva = operacionesRRHHDAOLocal.buscarCtaRhLiquidacionBonificacion(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhFondoReserva == null) ? "" : ctaRhFondoReserva));//categoria
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("LIQ-BON");//
                                        conDetalle.setDetValor(rhRol.getRolLiqBonificacion());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Bono Liquidación)...";
                                            }
                                        }
                                    }
                                    if (i == 9) {
                                        ctaRhBono = operacionesRRHHDAOLocal.buscarCtaRhPorPagarBonos(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhBono == null) ? "" : ctaRhBono));//forma pago
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("BONO");//
                                        conDetalle.setDetValor(rhRol.getRolBonos().subtract(
                                                estadoCtaRhIess.equals("IESS") ? rolIngresosExtras : cero));////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Bono)...";
                                            }
                                        }
                                    }
                                    if (i == 10) {
                                        ctaRhBonoND = operacionesRRHHDAOLocal.buscarCtaRhPorPagarBonos(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhBonoND == null) ? "" : ctaRhBonoND));//forma pago
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("BONO-ND");
                                        conDetalle.setDetValor(rhRol.getRolBonosnd().subtract(
                                                estadoCtaRhIess.equals("IESS") ? cero : rolIngresosExtras));////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Bono ND)...";
                                            }
                                        }
                                    }
                                    if (i == 11) {
                                        ctaRhBonoFijo = operacionesRRHHDAOLocal.buscarCtaRhGastoBonoFijo(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhBonoFijo == null) ? "" : ctaRhBonoFijo));//forma pago
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("BF");//
                                        conDetalle.setDetValor(rhRol.getRolBonoFijo());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Bono Fijo)...";
                                            }
                                        }
                                    }
                                    if (i == 12) {
                                        ctaRhBonoFijoND = operacionesRRHHDAOLocal.buscarCtaRhGastoBonoFijoND(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhBonoFijoND == null) ? "" : ctaRhBonoFijoND));//forma pago
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("BF-ND");
                                        conDetalle.setDetValor(rhRol.getRolBonoFijoNd());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Bono Fijo ND)...";
                                            }
                                        }
                                    }
                                    if (i == 13) {
                                        ctaRhOtrosIngresos = operacionesRRHHDAOLocal.buscarCtaRhGastoOtrosIngresos(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhOtrosIngresos == null) ? "" : ctaRhOtrosIngresos));//forma pago
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("OI");//
                                        conDetalle.setDetValor(rhRol.getRolOtrosIngresos());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Otros Ingresos)...";
                                            }
                                        }
                                    }
                                    if (i == 14) {
                                        ctaRhOtrosIngresosND = operacionesRRHHDAOLocal.buscarCtaRhGastoOtrosIngresosND(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhOtrosIngresosND == null) ? "" : ctaRhOtrosIngresosND));//forma pago
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("OI-ND");
                                        conDetalle.setDetValor(rhRol.getRolOtrosIngresosNd());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Otros Ingresos ND)...";
                                            }
                                        }
                                    }
                                    if (i == 15) {
//                                        ctaRhViatico = operacionesRRHHDAOLocal.buscarCtaRhGastoViaticos(
//                                                rhRolEmpleadoTO.getEmpCodigo(),
//                                                rhRolEmpleadoTO.getEmpId());
//                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
//                                                (ctaRhViatico == null) ? "" : ctaRhViatico));//forma pago
//                                        conDetalle.setDetDebitoCredito('D');
//                                        conDetalle.setDetReferencia("VIA");//
//                                        conDetalle.setDetValor(rhRol.getRolViaticos());////////////
//                                        conDetalle.setDetOrden(orden);//
//                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
//                                            if (conDetalle.getConCuentas() != null) {
//                                                listaConDetalle.add(conDetalle);
//                                                orden++;
//                                            } else {
//                                                mensaje = "FNo se encuentra la cuenta contable (Viático)...";
//                                            }
//                                        }
                                    }
                                    if (i == 15) {
                                        ctaRhPorPagarSueldos = operacionesRRHHDAOLocal.buscarCtaRhPorPagarSueldos(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhPorPagarSueldos == null) ? "" : ctaRhPorPagarSueldos));//forma pago
                                        conDetalle.setDetReferencia("SAL-ANT");//
                                        conDetalle.setDetValor(rhRol.getRolSaldoAnterior());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (!(rhRol.getRolSaldoAnterior().compareTo(cero) == 0)) {
                                            if (rhRol.getRolSaldoAnterior().compareTo(cero) < 0) {
                                                conDetalle.setDetDebitoCredito('C');
                                                conDetalle.setDetValor(rhRol.getRolSaldoAnterior().abs());////////////
                                            }
                                            if (rhRol.getRolSaldoAnterior().compareTo(cero) > 0) {
                                                conDetalle.setDetDebitoCredito('D');
                                                conDetalle.setDetValor(rhRol.getRolSaldoAnterior());////////////
                                            }
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Saldo Anterior)...";
                                            }
                                        }
                                    }
                                    if (i == 16) {
                                        if (rhCancelarBeneficioSocialTO.getEmpCancelarXiiiSueldoMensualmente()) {
                                            ctaRhGastoXiii = operacionesRRHHDAOLocal.buscarCtaRhGastoXiii(
                                                    rhRolEmpleadoTO.getEmpCodigo(),
                                                    rhRolEmpleadoTO.getEmpId());
                                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                    (ctaRhGastoXiii == null) ? "" : ctaRhGastoXiii));//categoria
                                            conDetalle.setDetDebitoCredito('D');
                                            conDetalle.setDetReferencia("GXIII");//
                                            conDetalle.setDetValor(rhRol.getRolXiii());////////////
                                            rhRolTO.setRolLiqXiii(rhRol.getRolXiii());
                                            conDetalle.setDetOrden(orden);//
                                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                                if (conDetalle.getConCuentas() != null) {
                                                    listaConDetalle.add(conDetalle);
                                                    orden++;
                                                } else {
                                                    mensaje = "FNo se encuentra la cuenta contable (Gasto XIII)...";
                                                }
                                            }
                                        }
                                    }
                                    if (i == 17) {
                                        if (rhCancelarBeneficioSocialTO.getEmpCancelarXivSueldoMensualmente()) {
                                            ctaRhGastoXiv = operacionesRRHHDAOLocal.buscarCtaRhGastoXiv(
                                                    rhRolEmpleadoTO.getEmpCodigo(),
                                                    rhRolEmpleadoTO.getEmpId());
                                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                    (ctaRhGastoXiv == null) ? "" : ctaRhGastoXiv));//categoria
                                            conDetalle.setDetDebitoCredito('D');
                                            conDetalle.setDetReferencia("GXIV");//
                                            conDetalle.setDetValor(rhRol.getRolXiv());////////////
                                            rhRolTO.setRolLiqXiv(rhRol.getRolXiv());
                                            conDetalle.setDetOrden(orden);//
                                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                                if (conDetalle.getConCuentas() != null) {
                                                    listaConDetalle.add(conDetalle);
                                                    orden++;
                                                } else {
                                                    mensaje = "FNo se encuentra la cuenta contable (Gasto XIV)...";
                                                }
                                            }
                                        }
                                    }
                                    if (i == 18) {
                                        if (rhCtaIessTO != null) {
                                            if (rhCtaIessTO.getEmpFechaAfiliacionIess() != null) {
                                                ctaRhGastoFondoReserva = operacionesRRHHDAOLocal.buscarCtaRhGastoFondoReserva(
                                                        rhRolEmpleadoTO.getEmpCodigo(),
                                                        rhRolEmpleadoTO.getEmpId());
                                                conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                        (ctaRhGastoFondoReserva == null) ? "" : ctaRhGastoFondoReserva));//forma pago
                                                conDetalle.setDetDebitoCredito('D');
                                                conDetalle.setDetReferencia("FR");//
                                                conDetalle.setDetValor(rhRol.getRolFondoReserva());////////////
                                                conDetalle.setDetOrden(orden);//
                                                if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                                    if (conDetalle.getConCuentas() != null) {
                                                        listaConDetalle.add(conDetalle);
                                                        orden++;
                                                    } else {
                                                        mensaje = "FNo se encuentra la cuenta contable (Gasto Fondo Reserva)...";
                                                    }
                                                }
                                            }
                                        }
                                    }
////////////////////////////////////
                                    if (i == 19) {
                                        if (estadoCtaRhIess.equals("IESS")) {
                                            ctaRhBono = operacionesRRHHDAOLocal.buscarCtaRhGastoBonos(
                                                    rhRolEmpleadoTO.getEmpCodigo(),
                                                    rhRolEmpleadoTO.getEmpId());
                                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                    (ctaRhBono == null) ? "" : ctaRhBono));//forma pago
                                            conDetalle.setDetDebitoCredito('D');
                                            conDetalle.setDetReferencia("BONO");//
                                            conDetalle.setDetValor(rolIngresosExtras);////////////
                                            conDetalle.setDetOrden(orden);//
                                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                                if (conDetalle.getConCuentas() != null) {
                                                    listaConDetalle.add(conDetalle);
                                                    orden++;
                                                } else {
                                                    mensaje = "FNo se encuentra la cuenta contable (Bono)...";
                                                }
                                            }
                                        }
                                    }
                                    if (i == 19) {
                                        if (!estadoCtaRhIess.equals("IESS")) {
                                            ctaRhBonoND = operacionesRRHHDAOLocal.buscarCtaRhGastoBonosND(
                                                    rhRolEmpleadoTO.getEmpCodigo(),
                                                    rhRolEmpleadoTO.getEmpId());
                                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                    (ctaRhBonoND == null) ? "" : ctaRhBonoND));//forma pago
                                            conDetalle.setDetDebitoCredito('D');
                                            conDetalle.setDetReferencia("BONO-ND");
                                            conDetalle.setDetValor(rolIngresosExtras);////////////
                                            conDetalle.setDetOrden(orden);//
                                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                                if (conDetalle.getConCuentas() != null) {
                                                    listaConDetalle.add(conDetalle);
                                                    orden++;
                                                } else {
                                                    mensaje = "FNo se encuentra la cuenta contable (Bono ND)...";
                                                }
                                            }
                                        }
                                    }
////////////////////////////////////
                                    if (i == 20) {
                                        if (!rhCancelarBeneficioSocialTO.getEmpCancelarFondoReservaMensualmente() && estadoCtaRhIess.equals("IESS")) {
                                            ctaRhFondoReserva = operacionesRRHHDAOLocal.buscarCtaRhFondoReserva(
                                                    rhRolEmpleadoTO.getEmpCodigo(),
                                                    rhRolEmpleadoTO.getEmpId());
                                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                    (ctaRhFondoReserva == null) ? "" : ctaRhFondoReserva));//categoria
                                            conDetalle.setDetDebitoCredito('C');
                                            conDetalle.setDetReferencia("FR");//
                                            conDetalle.setDetValor(rhRol.getRolFondoReserva());////////////
                                            conDetalle.setDetOrden(orden);//
                                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                                if (conDetalle.getConCuentas() != null) {
                                                    listaConDetalle.add(conDetalle);
                                                    orden++;
                                                } else {
                                                    mensaje = "FNo se encuentra la cuenta contable (Fondo Reserva)...";
                                                }
                                            }
                                        }
                                    }
                                    if (i == 21) {
                                        if (rhEmpleado.getEmpSalarioNeto()) {
                                            String cuenta = operacionesRRHHDAOLocal.buscarCtaRhSalarioNeto(rhRolEmpleadoTO.getEmpCodigo(),
                                                    rhRolEmpleadoTO.getEmpId());
                                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                    (cuenta == null) ? "" : cuenta));//categoria
                                            conDetalle.setDetDebitoCredito('D');
                                            conDetalle.setDetReferencia("IESS");//
                                            conDetalle.setDetValor(valorIess);////////////
                                            conDetalle.setDetOrden(orden);//
                                            if (estadoCtaRhIess.equals("IESS") && cuenta != null && cuenta.compareToIgnoreCase("") != 0) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                if (valorIess.compareTo(new BigDecimal("0")) > 0) {
                                                    mensaje = "FNo se encuentra la cuenta contable (Salario Neto)...";
                                                }
                                            }
                                        }
                                    }
                                    if (i == 22) {
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                ctaRhAportePersonal));//categoria
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("IESS");//
                                        conDetalle.setDetValor(valorIess);////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (estadoCtaRhIess.equals("IESS")) {
                                            listaConDetalle.add(conDetalle);
                                            orden++;
                                        }
                                    }
                                    if (i == 23) {
                                        ctaRhImpuestoRenta = operacionesRRHHDAOLocal.buscarCtaRhPorPagarImpuestoRenta(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhImpuestoRenta == null) ? "" : ctaRhImpuestoRenta));//forma pago
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("IR");//
                                        conDetalle.setDetValor(valorImpuestoRenta);////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Impuesto Renta)...";
                                            }
                                        }
                                    }
                                    if (i == 24) {
                                        ctaRhAnticipo = operacionesRRHHDAOLocal.buscarCtaRhAnticipo(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhAnticipo == null) ? "" : ctaRhAnticipo));//forma pago
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("ANT");//
                                        conDetalle.setDetValor(rhRol.getRolAnticipos());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Anticipo)...";
                                            }
                                        }
                                    }
                                    if (i == 25) {
                                        ctaRhPrestamo = operacionesRRHHDAOLocal.buscarCtaRhPrestamo(
                                                rhRolEmpleadoTO.getEmpCodigo(),
                                                rhRolEmpleadoTO.getEmpId());
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                (ctaRhPrestamo == null) ? "" : ctaRhPrestamo));//forma pago
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("PRE");//
                                        conDetalle.setDetValor(rhRol.getRolPrestamos());////////////
                                        conDetalle.setDetOrden(orden);//
                                        if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                            if (conDetalle.getConCuentas() != null) {
                                                listaConDetalle.add(conDetalle);
                                                orden++;
                                            } else {
                                                mensaje = "FNo se encuentra la cuenta contable (Prestamo)...";
                                            }
                                        }
                                    }
                                    if (i == 26) {
                                        if (!rhRolEmpleadoTO.getPorPagar()) {
                                            rhCtaFormaPagoTO = operacionesRRHHDAOLocal.buscarCtaRhFormaPago(
                                                    rhRolEmpleadoTO.getEmpCodigo(),
                                                    rhRolEmpleadoTO.getRolFormaPago());
                                            if (rhCtaFormaPagoTO.getCtaCodigo() != null) {
                                                if (rhCtaFormaPagoTO.getCtaCodigo() != null) {
                                                    ctaRhFormasPago = rhCtaFormaPagoTO.getCtaCodigo();
                                                    conDetalle.setSecCodigo(rhCtaFormaPagoTO.getSecCodigo());
                                                    conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                            (ctaRhFormasPago == null) ? "" : ctaRhFormasPago));//forma pago
                                                    conDetalle.setDetDebitoCredito('C');
                                                    conDetalle.setDetReferencia("FP");//
                                                    conDetalle.setDetDocumento(rhRolEmpleadoTO.getConDetDocumento());
                                                    if (rhCancelarBeneficioSocialTO.getEmpCancelarXiiiSueldoMensualmente()) {
                                                        rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolXiii())));
                                                    }
                                                    if (rhCancelarBeneficioSocialTO.getEmpCancelarXivSueldoMensualmente()) {
                                                        rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolXiv())));
                                                    }
                                                    if (rhCancelarBeneficioSocialTO.getEmpCancelarFondoReservaMensualmente()) {
                                                        rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolFondoReserva())));
                                                    }
                                                    rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolBonoFijo()).add(rhRol.getRolBonoFijoNd()).add(rhRol.getRolOtrosIngresos()).add(rhRol.getRolOtrosIngresosNd())));
                                                    if (estadoCtaRhIess.equals("IESS")) {
                                                        rhRol.setRolTotal(redondeoDecimalBigDecimal(rhEmpleado.getEmpSalarioNeto() ? rhRol.getRolTotal() : rhRol.getRolTotal().subtract(valorIess)));
                                                    }
                                                    conDetalle.setDetValor(rhRol.getRolTotal());////////////
                                                    conDetalle.setDetOrden(orden);//
                                                    if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                                        if (conDetalle.getConCuentas() != null) {
                                                            valor = valor.add(conDetalle.getDetValor());
                                                            listaConDetalle.add(conDetalle);
                                                            orden++;
                                                        } else {
                                                            mensaje = "FNo se encuentra la cuenta contable (Forma Pago)...";
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (i == 26) {
                                        if (rhRolEmpleadoTO.getPorPagar()) {
                                            ctaRhPorPagarSueldos = operacionesRRHHDAOLocal.buscarCtaRhPorPagarSueldos(
                                                    rhRolEmpleadoTO.getEmpCodigo(),
                                                    rhRolEmpleadoTO.getEmpId());
                                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(rhRolEmpleadoTO.getEmpCodigo(),
                                                    (ctaRhPorPagarSueldos == null) ? "" : ctaRhPorPagarSueldos));//forma pago
                                            conDetalle.setDetDebitoCredito('C');
                                            conDetalle.setDetReferencia("FP");//
                                            conDetalle.setDetDocumento(rhRolEmpleadoTO.getConDetDocumento());
                                            if (rhCancelarBeneficioSocialTO.getEmpCancelarXiiiSueldoMensualmente()) {
                                                rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolXiii())));
                                            }
                                            if (rhCancelarBeneficioSocialTO.getEmpCancelarXivSueldoMensualmente()) {
                                                rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolXiv())));
                                            }
                                            if (rhCancelarBeneficioSocialTO.getEmpCancelarFondoReservaMensualmente()) {
                                                rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolFondoReserva())));
                                            }
                                            rhRol.setRolTotal(redondeoDecimalBigDecimal(rhRol.getRolTotal().add(rhRol.getRolBonoFijo()).add(rhRol.getRolBonoFijoNd()).add(rhRol.getRolOtrosIngresos()).add(rhRol.getRolOtrosIngresosNd())));
                                            if (estadoCtaRhIess.equals("IESS")) {
                                                rhRol.setRolTotal(redondeoDecimalBigDecimal(rhEmpleado.getEmpSalarioNeto() ? rhRol.getRolTotal() : rhRol.getRolTotal().subtract(valorIess)));
                                            }
                                            conDetalle.setDetValor(rhRol.getRolTotal());////////////
                                            conDetalle.setDetOrden(orden);//
                                            if (conDetalle.getDetValor().compareTo(cero) > 0) {
                                                if (conDetalle.getConCuentas() != null) {
                                                    listaConDetalle.add(conDetalle);
                                                    orden++;
                                                } else {
                                                    mensaje = "FNo se encuentra la cuenta contable (Saldo Anterior)...";
                                                }
                                            }
                                            if (conDetalle.getDetValor().compareTo(cero) < 0) {
                                                if (conDetalle.getConCuentas() != null) {
                                                    conDetalle.setDetDebitoCredito('D');
                                                    conDetalle.setDetValor(conDetalle.getDetValor().abs());
                                                    valor = valor.add(conDetalle.getDetValor());
                                                    listaConDetalle.add(conDetalle);
                                                    orden++;
                                                } else {
                                                    mensaje = "FNo se encuentra la cuenta contable (Saldo Anterior)...";
                                                }
                                            }
                                            if (conDetalle.getDetValor().compareTo(cero) == 0) {
                                                mensaje = "FNo se puede generar con valor cero";
                                            }
                                        }
                                    }
                                    conDetalle = null;
                                }
                                ctaRhGastoSueldo = ctaRhGastoSueldo == null ? "" : ctaRhGastoSueldo;
                                ctaRhFormasPago = ctaRhFormasPago == null ? "" : ctaRhFormasPago;
                                ctaRhPorPagarSueldos = ctaRhPorPagarSueldos == null ? "" : ctaRhPorPagarSueldos;
                                comprobar = false;
                                if (mensaje.isEmpty() && !ctaRhGastoSueldo.isEmpty() && (!ctaRhFormasPago.isEmpty() || !ctaRhPorPagarSueldos.isEmpty())) {//revisar si estan llenos
                                    if (rhRolEmpleadoTO.getGrabar()) {
                                        rhRol.setRolDiasLaboradosReales(new Short(String.valueOf(rhRolTO.getRolDiasFaltasReales() + rhRolTO.getRolDiasLaboradosReales())));
                                        java.util.List<rrhh.entity.RhRol> rhRoles = new java.util.ArrayList(0);
                                        rhRoles.add(rhRol);
                                        if (rhRoles.size() == 1) {
                                            susDetalle = "Rol a " + operacionesRRHHDAOLocal.getRhEmpleadoApellidosNombres(
                                                    rhRoles.get(0).getRhEmpleado().getRhEmpleadoPK().getEmpEmpresa(),
                                                    rhRoles.get(0).getRhEmpleado().getRhEmpleadoPK().getEmpId()) + " por $" + valor.toPlainString();
                                        } else {
                                            susDetalle = "Roles totales a varios empleados " + " por $" + valor.toPlainString();
                                        }
                                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                susTabla,
                                                susClave,
                                                susSuceso,
                                                susDetalle,
                                                sisInfoTO);
                                        comprobar = operacionesRRHHDAOTransaccionLocal.insertarRhRol(
                                                rhRoles,
                                                rhEmpleado,
                                                conContable,
                                                listaConDetalle,
                                                sisSuceso,
                                                conNumeracion,
                                                sisInfoTO);
                                    } else {
                                        mensaje = "T<html><font size = +2 color = RED>" + mensaje + "Estos valores podrian NO ser los finales.."
                                                + "</font></html>";
                                        rhContableTO.setRhRolTO(rhRolTO);
                                    }
                                } else if (rhCtaIessTO == null) {
                                    mensaje = "FNo se encuentra la cuenta contable (IESS)...";
                                } else if (rhCtaIessTO.getCtaAportepersonal() == null) {
                                    mensaje = "FNo se encuentra la cuenta contable (IESS)...";
                                }
                                if (comprobar) {
                                    sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                                    contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                                    mensaje = "T<html><font color = GREEN>" + mensaje + "Se ingresó el contable con la siguiente información:<br>"
                                            + "Periodo: <font size = 5>"
                                            + sisPeriodo.getPerDetalle()
                                            + "</font><br> Tipo: <font size = 5>"
                                            + conTipo.getTipDetalle()
                                            + "</font><br> Número: <font size = 5>"
                                            + conContable.getConContablePK().getConNumero()
                                            + "</font></font></html>";

                                    rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                                    rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                                    rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                                    rhContableTO.setRhRolTO(rhRolTO);
                                }
                            } else {
                                mensaje = "FNo se encuentra tipo de contable...";
                            }
                        } else {
                            mensaje = "FNo se encuentra empleado que ingresó...";
                        }
                    } else {
                        mensaje = "FNo se encuentra ningún periodo para la fecha que ingresó\nNo esta creado o esta cerrado...";
                    }
                } else {
                    mensaje = "FFecha del sueldo actual tiene que ser mayor a la fecha del ultimo sueldo...";
                }
            } else {
                mensaje = "FFaltan parametros para realizar la transacción...";
            }
            rhContableTO.setMensaje(mensaje);
            return rhContableTO;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhRolConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }
    }

    @Override
    public RhRolSueldoEmpleadoTO getRhRolSueldoEmpleadoTO(String empCodigo, String empId) throws Exception {
        RhRolSueldoEmpleadoTO rhRolSueldoEmpleadoTO = operacionesRRHHDAOLocal.getRhRolSueldoEmpleado(empCodigo, empId);
        if (rhRolSueldoEmpleadoTO != null && rhRolSueldoEmpleadoTO.getRolFechaUltimoSueldo() == null) {
            rrhh.entity.RhEmpleado rhEmpleado = operacionesRRHHDAOLocal.buscarEmpleado(empCodigo, empId);
            if (rhEmpleado != null && rhEmpleado.getEmpFechaUltimoIngreso() != null) {
                rhRolSueldoEmpleadoTO.setRolFechaUltimoSueldo(Validacion.fecha(rhEmpleado.getEmpFechaUltimoIngreso(), "yyyy-MM-dd"));
            } else {
                rhRolSueldoEmpleadoTO.setRolFechaUltimoSueldo(Validacion.fecha(rhEmpleado.getEmpFechaPrimerIngreso(), "yyyy-MM-dd"));
            }
        }
        rhRolSueldoEmpleadoTO.setRolFechaUltimoSueldo(rhRolSueldoEmpleadoTO.getRolFechaUltimoSueldo());
        return rhRolSueldoEmpleadoTO;
    }

    @Override
    public List<RhListaRolSaldoEmpleadoDetalladoTO> getRhRolSaldoEmpleadoDetalladoTO(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesRRHHDAOLocal.getRhRolSaldoEmpleadoDetallado(empCodigo, empId, fechaDesde, fechaHasta);
    }

    @Override
    public java.math.BigDecimal getRhRolSaldoPrestamo(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesRRHHDAOLocal.getRhRolSaldoPrestamo(empCodigo, empId, fechaDesde, fechaHasta);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ANULACIONES">
    @Override
    public java.util.List<rrhh.TO.RhAnulacionesTO> getRhAnulacionesTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws Exception {
        return operacionesRRHHDAOLocal.getRhAnulacionesTO(empresa, periodo, tipo, numero);
    }

    public java.util.List<String> anularReversarRhConContable(
            String empresa,
            String periodo,
            String tipo,
            String numero,
            String usuario,
            java.lang.String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        List<String> retorno = new java.util.ArrayList(1);
        comprobar = false;
        try {
            java.util.List<rrhh.TO.RhAnulacionesTO> rhAnulacionesTOs = new java.util.ArrayList(1);
            if (!tipo.equals("C-PRO")) {
                rhAnulacionesTOs = getRhAnulacionesTO(empresa, periodo, tipo, numero);
                for (rrhh.TO.RhAnulacionesTO rhAnulacionesTO : rhAnulacionesTOs) {
                    comprobar = false;
                    //fecha ultimo sueldo
                    String fechaUltimoSueldo = operacionesRRHHDAOLocal.buscarFechaRhRol(
                            empresa, rhAnulacionesTO.getAnuId());
                    if (fechaUltimoSueldo.isEmpty()) {
                        comprobar = true;
                    } else if (tipo.equals("C-ROL")) {
                        comprobar = Validacion.fecha(rhAnulacionesTO.getAnuFecha(), "yyyy-MM-dd").getTime()
                                == Validacion.fecha(fechaUltimoSueldo, "yyyy-MM-dd").getTime();
                    } else {
                        if (tipo.equals("C-VAC")) {
                            comprobar = true;
                        } else {
                            comprobar = Validacion.fecha(rhAnulacionesTO.getAnuFecha(), "yyyy-MM-dd").getTime()
                                    > Validacion.fecha(fechaUltimoSueldo, "yyyy-MM-dd").getTime();
                        }
                    }

                    if (!comprobar) {
                        if (retorno.isEmpty()) {
                            retorno.add("FFecha incompatible con los siguientes empleado:");
                        }
                        retorno.add(rhAnulacionesTO.getAnuNombres());
                    }
                }
            }
            if (retorno.isEmpty()) {
                retorno.add(operacionesContabilidadBusinessLocal.anularReversarConContable(empresa, periodo, tipo, numero, usuario, accion, sisInfoTO));
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "anularRhConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DETALLES">
    @Override
    public List<RhListaDetalleAnticiposTO> getRhDetalleAnticiposTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId, String formaPago) throws Exception {
        return operacionesRRHHDAOLocal.getRhDetalleAnticiposTO(empCodigo, fechaDesde, fechaHasta, empCategoria, empId, formaPago);
    }

    @Override
    public java.util.List<rrhh.TO.RhListaDetalleAnticiposLoteTO> getRhDetalleAnticiposLoteTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhDetalleAnticiposLoteTO(empresa, periodo, tipo, numero);
    }

    @Override
    public java.util.List<rrhh.TO.RhListaDetalleBonosLoteTO> getRhDetalleBonosLoteTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhDetalleBonosLoteTO(empresa, periodo, tipo, numero);
    }

    @Override
    public List<RhListaDetalleAnticiposPrestamosTO> getRhDetalleAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        return operacionesRRHHDAOLocal.getRhDetalleAnticiposPrestamosTO(empCodigo, fechaDesde, fechaHasta, empCategoria, empId);
    }

    @Override
    public List<RhListaDetallePrestamosTO> getRhDetallePrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        return operacionesRRHHDAOLocal.getRhDetallePrestamosTO(empCodigo, fechaDesde, fechaHasta, empCategoria, empId);
    }

    @Override
    public List<RhListaDetalleBonosTO> getRhDetalleBonosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empCategoria,
            String empId,
            String estadoDeducible) throws Exception {
        return operacionesRRHHDAOLocal.getRhDetalleBonosTO(
                empCodigo,
                fechaDesde,
                fechaHasta,
                empCategoria,
                empId,
                estadoDeducible);
    }

    @Override
    public List<RhListaDetalleViaticosTO> getRhDetalleViaticosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        return operacionesRRHHDAOLocal.getRhDetalleViaticosTO(empCodigo, fechaDesde, fechaHasta, empCategoria, empId);
    }

    @Override
    public List<RhListaDetalleRolesTO> getRhDetalleRolesTO(String empCodigo, String fechaDesde, String fechaHasta, String sector, String empCategoria, String empId) throws Exception {
        return operacionesRRHHDAOLocal.getRhDetalleRolesTO(empCodigo, fechaDesde, fechaHasta, sector, empCategoria, empId);
    }

    @Override
    public List<RhDetalleVacionesPagadasGozadasTO> getRhDetalleVacacionesPagadasGozadasTO(String empCodigo, String empId, String sector, String fechaDesde, String fechaHasta, String tipo) throws Exception {
        return operacionesRRHHDAOLocal.getRhDetalleVacacionesPagadasGozadasTO(empCodigo, empId, sector, fechaDesde, fechaHasta, tipo);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONSOLIDADOS">
    @Override
    public List<RhListaConsolidadoAnticiposPrestamosTO> getRhConsolidadoAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        return operacionesRRHHDAOLocal.getRhConsolidadoAnticiposPrestamosTO(empCodigo, fechaDesde, fechaHasta, empCategoria, empId);
    }

    @Override
    public List<RhListaConsolidadoBonosViaticosTO> getRhConsolidadoBonosViaticosTO(String empCodigo, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesRRHHDAOLocal.getRhConsolidadoBonosViaticosTO(empCodigo, fechaDesde, fechaHasta);
    }

    @Override
    public List<RhListaConsolidadoRolesTO> getRhConsolidadoRolesTO(String empCodigo, String fechaDesde, String fechaHasta, String sector, String empCategoria, String empId) throws Exception {
        return operacionesRRHHDAOLocal.getRhConsolidadoRolesTO(empCodigo, fechaDesde, fechaHasta, sector, empCategoria, empId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SALDOS CONSOLIDADOS">
    @Override
    public List<RhListaSaldoConsolidadoAnticiposPrestamosTO> getRhSaldoConsolidadoAnticiposPrestamosTO(String empCodigo, String fechaHasta) throws Exception {
        return operacionesRRHHDAOLocal.getRhSaldoConsolidadoAnticiposPrestamosTO(empCodigo, fechaHasta);
    }

    @Override
    public List<RhListaSaldoConsolidadoBonosViaticosTO> getRhSaldoConsolidadoBonosViaticosTO(String empCodigo, String fechaHasta) throws Exception {
        return operacionesRRHHDAOLocal.getRhSaldoConsolidadoBonosViaticosTO(empCodigo, fechaHasta);
    }

    @Override
    public List<RhListaSaldoConsolidadoSueldosPorPagarTO> getRhSaldoConsolidadoSueldosPorPagarTO(String empCodigo, String fechaHasta) throws Exception {
        return operacionesRRHHDAOLocal.getRhSaldoConsolidadoSueldosPorPagarTO(empCodigo, fechaHasta);
    }

    @Override
    public List<RhListaSaldoIndividualAnticiposPrestamosTO> getRhSaldoIndividualAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empId, String tipo) throws Exception {
        return operacionesRRHHDAOLocal.getRhSaldoIndividualAnticiposPrestamosTO(empCodigo, fechaDesde, fechaHasta, empId, tipo);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PROVISIONES">
    @Override
    public RhContableTO insertarRhListaProvisionesConContable(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String sector,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        String status = "SIN CONTABILIZAR";
        List<String> lista = new java.util.ArrayList(1);
        RhContableTO rhContableTO = new RhContableTO();
        String tipDetalle = "C-PRO";
        mensaje = "F";
        String perHasta = "";
        RhCategoriaProvisionesTO rhCategoriaProvisionesTO = new RhCategoriaProvisionesTO();
        String ctaGastoAportePatronal = "";
        String ctaAportePatronal = "";
        String ctaGastoIece = "";
        String ctaIece = "";
        String ctaGastoSecap = "";
        String ctaSecap = "";
        String ctaGastoXiii = "";
        String ctaXiii = "";
        String ctaGastoXiv = "";
        String ctaXiv = "";
        String ctaGastoFondoReserva = "";
        String ctaFondoReserva = "";
        String ctaGastoVacaciones = "";
        String ctaVacaciones = "";
        String ctaGastoDesahucio = "";
        String ctaDesahucio = "";
        try {
            //periodo
            List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(empresa);

            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (sisListaPeriodoTO.getPerCodigo().equals(periodo)
                        && sisListaPeriodoTO.getPerCerrado() == false) {
                    perHasta = sisListaPeriodoTO.getPerHasta();
                    comprobar = true;
                    break;
                }
            }
            if (comprobar) {
                comprobar = true;
                if (operacionesContabilidadDAOLocal.buscarTipoContable(empresa, tipDetalle)) {
                    //llenar contable
                    ConContableTO conContableTO = new ConContableTO();
                    conContableTO.setEmpCodigo(empresa);
                    conContableTO.setPerCodigo(periodo);
                    conContableTO.setTipCodigo(tipDetalle);
                    conContableTO.setConFecha(perHasta);
                    conContableTO.setConPendiente(true);
                    conContableTO.setConBloqueado(false);
                    conContableTO.setConAnulado(false);
                    conContableTO.setConGenerado(true);
                    conContableTO.setConConcepto("REGISTRO DE PROVISIONES");
                    conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                    conContableTO.setConObservaciones("CONTABLE DE PROVISIONES DEL PERIODO " + periodo + " DEL SECTOR " + sector);
                    conContableTO.setUsrInsertaContable(usuario);
                    conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                    ///// CREANDO UN SUCESO
                    susClave = "";
                    susSuceso = "INSERT";
                    susTabla = "recursoshumanos.con_contable";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    ////// CREANDO NUMERACION
                    contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                            conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                            conContableTO.getTipCodigo()));
                    ////// CREANDO CONTABLE
                    contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                    java.util.List<rrhh.TO.RhListaProvisionesTO> rhListaProvisionesTOs = operacionesRRHHDAOLocal.getRhListaProvisionesTO(empresa, periodo, sector, status);
                    java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                    java.util.List<rrhh.entity.RhRol> rhRoles = new java.util.ArrayList(0);
                    rrhh.entity.RhRol rhRol;
                    int orden = 0;
                    for (rrhh.TO.RhListaProvisionesTO rhListaProvisionesTO : rhListaProvisionesTOs) {
                        if (rhListaProvisionesTO.getProvId() != null
                                && rhListaProvisionesTO.getProvContableProvision() == null) {
                            rhRol = operacionesRRHHDAOLocal.buscarRol(rhListaProvisionesTO.getProvSecuencial());
                            rhRol.setConProvisionEmpresa(empresa);
                            rhRol.setConProvisionTipo(tipDetalle);
                            rhRol.setConProvisionPeriodo(periodo);
                            rhRoles.add(rhRol);
                        }
                        if (rhListaProvisionesTO.getProvCategoria() != null
                                && rhListaProvisionesTO.getProvId() == null) {
                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                            ConDetalle conDetalle = null;

                            // <editor-fold defaultstate="collapsed" desc="ConDetalle">
                            for (int i = 0; i < 16; i++) {
                                conDetalle = new ConDetalle();
                                conDetalle.setConContable(conContable);
                                conDetalle.setDetSecuencia(0);
                                conDetalle.setDetDocumento("");
                                conDetalle.setPisNumero(null);
                                conDetalle.setDetGenerado(false);
                                rhCategoriaProvisionesTO = operacionesRRHHDAOLocal.getRhCategoriaProvisionesTO(
                                        empresa,
                                        rhListaProvisionesTO.getProvCategoria());
                                ctaGastoAportePatronal = rhCategoriaProvisionesTO.getCtaGastoAportepatronal();
                                ctaAportePatronal = rhCategoriaProvisionesTO.getCtaAportepatronal();
                                ctaGastoIece = rhCategoriaProvisionesTO.getCtaGastoIece();
                                ctaIece = rhCategoriaProvisionesTO.getCtaIece();
                                ctaGastoSecap = rhCategoriaProvisionesTO.getCtaGastoSecap();
                                ctaSecap = rhCategoriaProvisionesTO.getCtaSecap();
                                ctaGastoXiii = rhCategoriaProvisionesTO.getCtaGastoXiii();
                                ctaXiii = rhCategoriaProvisionesTO.getCtaXiii();
                                ctaGastoXiv = rhCategoriaProvisionesTO.getCtaGastoXiv();
                                ctaXiv = rhCategoriaProvisionesTO.getCtaXiv();
                                ctaGastoFondoReserva = rhCategoriaProvisionesTO.getCtaGastoFondoreserva();
                                ctaFondoReserva = rhCategoriaProvisionesTO.getCtaFondoreserva();
                                ctaGastoVacaciones = rhCategoriaProvisionesTO.getCtaGastoVacaciones();
                                ctaVacaciones = rhCategoriaProvisionesTO.getCtaVacaciones();
                                ctaGastoDesahucio = rhCategoriaProvisionesTO.getCtaGastoDesahucio();
                                ctaDesahucio = rhCategoriaProvisionesTO.getCtaDesahucio();
                                //ctaGastoAportePatronal
                                if (rhListaProvisionesTO.getProvAportePatronal() != null) {
                                    if ((i == 0) && (rhListaProvisionesTO.getProvAportePatronal().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaGastoAportePatronal == null) ? "" : ctaGastoAportePatronal));
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("GAP");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvAportePatronal());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaGastoIece
                                if (rhListaProvisionesTO.getProvIece() != null) {
                                    if ((i == 1) && (rhListaProvisionesTO.getProvIece().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaGastoIece == null) ? "" : ctaGastoIece));
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("GIECE");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvIece());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaGastoSecap
                                if (rhListaProvisionesTO.getProvSecap() != null) {
                                    if ((i == 2) && (rhListaProvisionesTO.getProvSecap().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaGastoSecap == null) ? "" : ctaGastoSecap));
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("GSECAP");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvSecap());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaGastoXiii
                                if (rhListaProvisionesTO.getProvXiii() != null) {
                                    if ((i == 3) && (rhListaProvisionesTO.getProvXiii().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaGastoXiii == null) ? "" : ctaGastoXiii));
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("GXIII");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvXiii());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaGastoXiv
                                if (rhListaProvisionesTO.getProvXiv() != null) {
                                    if ((i == 4) && (rhListaProvisionesTO.getProvXiv().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaGastoXiv == null) ? "" : ctaGastoXiv));
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("GXIV");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvXiv());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaGastoFondoReserva
                                if (rhListaProvisionesTO.getProvFondoReserva() != null) {
                                    if ((i == 5) && (rhListaProvisionesTO.getProvFondoReserva().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaGastoFondoReserva == null) ? "" : ctaGastoFondoReserva));
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("GFR");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvFondoReserva());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaGastoVacaciones
                                if (rhListaProvisionesTO.getProvVacaciones() != null) {
                                    if ((i == 6) && (rhListaProvisionesTO.getProvVacaciones().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaGastoVacaciones == null) ? "" : ctaGastoVacaciones));
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("GVAC");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvVacaciones());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaGastoDesahucio
                                if (rhListaProvisionesTO.getProvDesahucio() != null) {
                                    if ((i == 7) && (rhListaProvisionesTO.getProvDesahucio().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaGastoDesahucio == null) ? "" : ctaGastoDesahucio));
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetReferencia("GDES");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvDesahucio());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaAportePatronal
                                if (rhListaProvisionesTO.getProvAportePatronal() != null) {
                                    if ((i == 8) && (rhListaProvisionesTO.getProvAportePatronal().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaAportePatronal == null) ? "" : ctaAportePatronal));
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("AP");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvAportePatronal());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaIece
                                if (rhListaProvisionesTO.getProvIece() != null) {
                                    if ((i == 9) && (rhListaProvisionesTO.getProvIece().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaIece == null) ? "" : ctaIece));
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("IECE");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvIece());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaSecap
                                if (rhListaProvisionesTO.getProvSecap() != null) {
                                    if ((i == 10) && (rhListaProvisionesTO.getProvSecap().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaSecap == null) ? "" : ctaSecap));
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("SECAP");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvSecap());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaXiii
                                if (rhListaProvisionesTO.getProvXiii() != null) {
                                    if ((i == 11) && (rhListaProvisionesTO.getProvXiii().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaXiii == null) ? "" : ctaXiii));
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("XIII");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvXiii());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaXiv
                                if (rhListaProvisionesTO.getProvXiv() != null) {
                                    if ((i == 12) && (rhListaProvisionesTO.getProvXiv().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaXiv == null) ? "" : ctaXiv));
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("XIV");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvXiv());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaFondoReserva
                                if (rhListaProvisionesTO.getProvFondoReserva() != null) {
                                    if ((i == 13) && (rhListaProvisionesTO.getProvFondoReserva().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaFondoReserva == null) ? "" : ctaFondoReserva));
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("FR");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvFondoReserva());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                //ctaVacaciones
                                if (rhListaProvisionesTO.getProvVacaciones() != null) {
                                    if ((i == 14) && (rhListaProvisionesTO.getProvVacaciones().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaVacaciones == null) ? "" : ctaVacaciones));
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("VAC");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvVacaciones());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
//                                    ctaDesahucio
                                if (rhListaProvisionesTO.getProvDesahucio() != null) {
                                    if ((i == 15) && (rhListaProvisionesTO.getProvDesahucio().compareTo(cero) > 0)) {
                                        conDetalle.setSecCodigo(sector);
                                        conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(empresa,
                                                (ctaDesahucio == null) ? "" : ctaDesahucio));
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetReferencia("DES");//
                                        conDetalle.setDetValor(rhListaProvisionesTO.getProvDesahucio());
                                        conDetalle.setDetOrden(orden++);//
                                        listaConDetalle.add(conDetalle);
                                    }
                                }
                                conDetalle = null;
                            }// </editor-fold>

                            ctaGastoAportePatronal = ctaGastoAportePatronal == null ? "" : ctaGastoAportePatronal;
                            ctaAportePatronal = ctaAportePatronal == null ? "" : ctaAportePatronal;
                            ctaGastoIece = ctaGastoIece == null ? "" : ctaGastoIece;
                            ctaIece = ctaIece == null ? "" : ctaIece;
                            ctaGastoSecap = ctaGastoSecap == null ? "" : ctaGastoSecap;
                            ctaSecap = ctaSecap == null ? "" : ctaSecap;
                            ctaGastoXiii = ctaGastoXiii == null ? "" : ctaGastoXiii;
                            ctaXiii = ctaXiii == null ? "" : ctaXiii;
                            ctaGastoXiv = ctaGastoXiv == null ? "" : ctaGastoXiv;
                            ctaXiv = ctaXiv == null ? "" : ctaXiv;
                            ctaGastoFondoReserva = ctaGastoFondoReserva == null ? "" : ctaGastoFondoReserva;
                            ctaFondoReserva = ctaFondoReserva == null ? "" : ctaFondoReserva;
                            ctaGastoVacaciones = ctaGastoVacaciones == null ? "" : ctaGastoVacaciones;
                            ctaVacaciones = ctaVacaciones == null ? "" : ctaVacaciones;
                            ctaGastoDesahucio = ctaGastoDesahucio == null ? "" : ctaGastoDesahucio;
                            ctaDesahucio = ctaDesahucio == null ? "" : ctaDesahucio;
                            if (!ctaGastoAportePatronal.isEmpty()
                                    && !ctaAportePatronal.isEmpty()
                                    && !ctaGastoIece.isEmpty()
                                    && !ctaIece.isEmpty()
                                    && !ctaGastoSecap.isEmpty()
                                    && !ctaSecap.isEmpty()
                                    && !ctaGastoXiii.isEmpty()
                                    && !ctaXiii.isEmpty()
                                    && !ctaGastoXiv.isEmpty()
                                    && !ctaXiv.isEmpty()
                                    && !ctaGastoFondoReserva.isEmpty()
                                    && !ctaFondoReserva.isEmpty()
                                    && !ctaGastoVacaciones.isEmpty()
                                    && !ctaVacaciones.isEmpty()
                                    && !ctaGastoDesahucio.isEmpty()
                                    && !ctaDesahucio.isEmpty()) {//revisar si estan llenos
                            } else {
                                comprobar = false;
                            }
                            mensaje = "FProblemas con las siguientes cuentas:";
                            if (ctaGastoAportePatronal.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Gasto Aporte Patronal");
                            }
                            if (ctaAportePatronal.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Aporte Patronal");
                            }
                            if (ctaGastoIece.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Gasto Iece");
                            }
                            if (ctaIece.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Iece");
                            }
                            if (ctaGastoSecap.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Gasto Secap");
                            }
                            if (ctaSecap.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Secap");
                            }
                            if (ctaGastoXiii.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Gasto XIII");
                            }
                            if (ctaXiii.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": XIII");
                            }
                            if (ctaGastoXiv.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Gasto XIV");
                            }
                            if (ctaXiv.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": XIV");
                            }
                            if (ctaGastoFondoReserva.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Gasto Fondo de Reserva");
                            }
                            if (ctaFondoReserva.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Fondo de Reserva");
                            }
                            if (ctaGastoVacaciones.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Gasto Vacaciones");
                            }
                            if (ctaVacaciones.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Vacaciones");
                            }
                            if (ctaGastoDesahucio.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Gasto Desahucio");
                            }
                            if (ctaDesahucio.isEmpty()) {
                                lista.add(rhListaProvisionesTO.getProvCategoria() + ": Desahucio");
                            }
                        }
                    }
                    if (comprobar) {
                        if (rhRoles.size() > 0) {
                            comprobar = operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                                    conContable,
                                    listaConDetalle,
                                    sisSuceso,
                                    conNumeracion,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    rhRoles,
                                    null,
                                    null,
                                    null,
                                    null,
                                    true,
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
                                    null,
                                    null,
                                    null,
                                    null,
                                    sisInfoTO);
                        } else {
                            comprobar = false;
                            mensaje = "FNo hay roles para provisionar...";
                        }
                    }
                    if (comprobar) {
                        sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                        contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                        mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";

                        rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                        rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                        rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                    }
                    rhContableTO.setListaEmpleadoTO(lista);
                } else {
                    mensaje = "FNo se encuentra tipo de contable...";
                }
            } else {
                mensaje = "FEl periodo seleccionado no se encuentra o esta cerrado...";
            }
            rhContableTO.setMensaje(mensaje);
//            return rhContableTO;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhListaProvisionesConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }
    }

    @Override
    public java.util.List<rrhh.TO.RhListaProvisionesTO> getRhListaProvisionesTO(java.lang.String empresa, java.lang.String periodo, java.lang.String sector, java.lang.String status) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhListaProvisionesTO(empresa, periodo, sector, status);
    }

    @Override
    public java.util.List<rrhh.TO.RhListaProvisionesTO> getRhListaProvisionesComprobanteContableTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhListaProvisionesComprobanteContableTO(empresa, periodo, tipo, numero);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="XIII">
    public java.util.List<rrhh.TO.RhXiiiSueldoPeriodoTO> getRhComboXiiiSueldoPeriodoTO() throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhComboXiiiSueldoPeriodoTO();
    }

    public java.util.List<rrhh.TO.RhFunXiiiSueldoCalcularTO> getRhFunCalcularXiiiSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhFunCalcularXiiiSueldo(empresa, sector, desde, hasta);
    }

    public java.util.List<rrhh.TO.RhFunXiiiSueldoConsultarTO> getRhFunConsultarXiiiSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhFunConsultarXiiiSueldo(empresa, sector, desde, hasta);
    }

    @Override
    public RhContableTO insertarRhXiiiSueldoConContable(
            java.lang.String empresa,
            java.lang.String periodoXiii,
            java.lang.String formaPago,
            java.lang.String documento,
            java.lang.String observaciones,
            java.util.List<rrhh.TO.RhFunXiiiSueldoCalcularTO> rhFunXiiiSueldoCalcularTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        List<String> lista = new java.util.ArrayList(1);
        RhContableTO rhContableTO = new RhContableTO();
        String tipDetalle = "C-BEN";
        mensaje = "F";
        RhXiiiSueldoPeriodoTO rhXiiiSueldoPeriodoTO = null;
        String periodo = "";
        String ctaXiii = null;
        String ctaFormaPago = null;
        RhCtaFormaPagoBeneficioSocialTO rhCtaFormaPagoBeneficioSocialTO = null;
        java.math.BigDecimal valorFormaPago = cero;
        try {
            //periodo Xiii
            rhXiiiSueldoPeriodoTO = operacionesRRHHDAOLocal.buscarRhXiiiSueldoPeriodoTO(periodoXiii);
            if (rhXiiiSueldoPeriodoTO != null) {
                //periodo
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(empresa);

                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (Validacion.fecha(rhXiiiSueldoPeriodoTO.getXiiiFechaMaximaPago(), "yyyy-MM-dd").getTime()
                            >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && Validacion.fecha(rhXiiiSueldoPeriodoTO.getXiiiFechaMaximaPago(), "yyyy-MM-dd").getTime()
                            <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                            && sisListaPeriodoTO.getPerCerrado() == false) {
                        comprobar = true;
                        periodo = sisListaPeriodoTO.getPerCodigo();
                        break;
                    }
                }
                if (comprobar) {
                    comprobar = true;
                    if (operacionesContabilidadDAOLocal.buscarTipoContable(empresa, tipDetalle)) {
                        //llenar contable
                        ConContableTO conContableTO = new ConContableTO();
                        conContableTO.setEmpCodigo(empresa);
                        conContableTO.setPerCodigo(periodo);
                        conContableTO.setTipCodigo(tipDetalle);
                        conContableTO.setConFecha(rhXiiiSueldoPeriodoTO.getXiiiFechaMaximaPago());
                        conContableTO.setConPendiente(false);
                        conContableTO.setConBloqueado(false);
                        conContableTO.setConAnulado(false);
                        conContableTO.setConGenerado(false);//deberia ser true, para que se pueda elminiar del modulo contabilidad
                        conContableTO.setConConcepto(rhFunXiiiSueldoCalcularTOs.size() > 1 ? "REGISTRO DE XIII SUELDO" : rhFunXiiiSueldoCalcularTOs.get(0).getXiiiApellidos() + " " + rhFunXiiiSueldoCalcularTOs.get(0).getXiiiNombres());
                        conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                        conContableTO.setConObservaciones(observaciones);
                        conContableTO.setUsrInsertaContable(usuario);
                        conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                        ///// CREANDO UN SUCESO
                        susClave = "";
                        susSuceso = "INSERT";
                        susTabla = "contabilidad.con_contable";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        ////// CREANDO NUMERACION
                        contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                                conContableTO.getTipCodigo()));
                        ////// CREANDO CONTABLE
                        contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                        java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                        java.util.List<rrhh.entity.RhXiiiSueldo> rhXiiiSueldos = new java.util.ArrayList(0);
                        rrhh.entity.RhXiiiSueldo rhXiiiSueldo;
                        int orden = 0;
                        int contador = 0;
                        //-----------------
                        java.util.List listaObjetos = new java.util.ArrayList();
                        java.util.List<Object> objetos = new java.util.ArrayList();
                        //-----------------
                        if (!rhFunXiiiSueldoCalcularTOs.isEmpty()) {
                            //ctaFormaPagoBeneficioSocial
                            rhCtaFormaPagoBeneficioSocialTO = operacionesRRHHDAOLocal.buscarCtaRhFormaPagoBeneficioSocial(
                                    empresa,
                                    formaPago);
                            objetos.add(rhFunXiiiSueldoCalcularTOs.get(0).getXiiiCategoria());
                            objetos.add(rhFunXiiiSueldoCalcularTOs.get(0).getXiiiSector());
                            objetos.add(rhFunXiiiSueldoCalcularTOs.get(0).getXiiiValorXiiiSueldo());
                            objetos.add(rhFunXiiiSueldoCalcularTOs.get(0).getXiiiCuenta());
                            listaObjetos.add(objetos);
                            for (int i = 0; i < rhFunXiiiSueldoCalcularTOs.size(); i++) {
                                //armar entidad RhXiiiSueldo
                                rhXiiiSueldo = new RhXiiiSueldo();
                                rhXiiiSueldo.setXiiiSecuencial(0);
                                rhXiiiSueldo.setXiiiDesde(validaciones.Validacion.fecha(rhXiiiSueldoPeriodoTO.getXiiiDesde(), "yyyy-MM-dd"));
                                rhXiiiSueldo.setXiiiHasta(validaciones.Validacion.fecha(rhXiiiSueldoPeriodoTO.getXiiiHasta(), "yyyy-MM-dd"));
                                rhXiiiSueldo.setXiiiDiasLaborados(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiDiasLaborados());
                                rhXiiiSueldo.setXiiiBaseImponible(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiTotalIngresos());
                                rhXiiiSueldo.setXiiiValor(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiValorXiiiSueldo());
                                rhXiiiSueldo.setXiiiFormaPago(rhCtaFormaPagoBeneficioSocialTO.getCtaCodigo());
                                rhXiiiSueldo.setXiiiCodigoMinisterial(rhCtaFormaPagoBeneficioSocialTO.getFpCodigoMinisterial());
                                rhXiiiSueldo.setRhEmpleado(new RhEmpleado(
                                        empresa,
                                        rhFunXiiiSueldoCalcularTOs.get(i).getXiiiId()));
                                rhXiiiSueldo.setEmpCargo(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiCargo());
                                rhXiiiSueldo.setEmpFechaIngreso(validaciones.Validacion.fecha(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiFechaIngreso(), "yyyy-MM-dd"));
                                rhXiiiSueldo.setSecEmpresa(empresa);
                                rhXiiiSueldo.setSecCodigo(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiSector());
                                rhXiiiSueldo.setConEmpresa(empresa);
                                rhXiiiSueldo.setConPeriodo(periodo);
                                rhXiiiSueldo.setConTipo(tipDetalle);
                                rhXiiiSueldos.add(rhXiiiSueldo);
                                //armar datos para el contable (totalizar con categoria y sector)
                                int posicion = 0;
                                boolean estado = false;
                                for (Object objeto : listaObjetos) {
                                    if (((java.util.List<Object>) objeto).get(0).toString().equals(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiCategoria())
                                            && ((java.util.List<Object>) objeto).get(1).toString().equals(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiSector())) {
                                        estado = true;
                                        break;
                                    } else {
                                        estado = false;
                                        posicion++;
                                    }
                                }
                                if (i != 0) {
                                    if (estado) {
                                        ((java.util.List<Object>) listaObjetos.get(posicion)).set(2,
                                                rhFunXiiiSueldoCalcularTOs.get(i).getXiiiValorXiiiSueldo().add(
                                                new java.math.BigDecimal(((java.util.List<Object>) listaObjetos.get(posicion)).get(2).toString())).toPlainString());
                                    } else {
                                        objetos = new java.util.ArrayList();
                                        objetos.add(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiCategoria());
                                        objetos.add(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiSector());
                                        objetos.add(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiValorXiiiSueldo());
                                        objetos.add(rhFunXiiiSueldoCalcularTOs.get(i).getXiiiCuenta());
                                        listaObjetos.add(objetos);
                                    }
                                }
                            }
//                            //*System.out.println(listaObjetos.size());
//                            for(Object listaObjeto:listaObjetos){
//                                //*System.out.println(((java.util.List<Object>)listaObjeto).get(0));
//                                //*System.out.println(((java.util.List<Object>)listaObjeto).get(1));
//                                //*System.out.println(((java.util.List<Object>)listaObjeto).get(2));
//                                //*System.out.println(((java.util.List<Object>)listaObjeto).get(3));
//                            }
                        } else {
                            mensaje = "FNo hay Xiii's...";
                        }
                        if (!listaObjetos.isEmpty()) {
                            // <editor-fold defaultstate="collapsed" desc="ConDetalle">
                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                            ConDetalle conDetalle = null;
                            //(0) XiiiCategoria;
                            //(1) XiiiSector;
                            //(2) XiiiValorXiiiSueldo;
                            //(4) XiiiCuenta;
                            for (Object listaObjeto : listaObjetos) {
                                conDetalle = new ConDetalle();
                                conDetalle.setConContable(conContable);
                                conDetalle.setDetSecuencia(0);
                                conDetalle.setDetDocumento("");
                                conDetalle.setPisNumero(null);
                                conDetalle.setDetGenerado(false);
                                //ctaXiii
                                ctaXiii = operacionesRRHHDAOLocal.buscarCtaRhXiiiCategoria(
                                        empresa,
                                        ((java.util.List<Object>) listaObjeto).get(0).toString());
                                if (ctaXiii != null) {
                                    conDetalle.setSecCodigo(((java.util.List<Object>) listaObjeto).get(1).toString());
                                    conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                            empresa, (ctaXiii == null) ? "" : ctaXiii));
                                    conDetalle.setDetDebitoCredito('D');
                                    conDetalle.setDetReferencia("XIII");//
                                    conDetalle.setDetValor(new java.math.BigDecimal(((java.util.List<Object>) listaObjeto).get(2).toString()));
                                    conDetalle.setDetOrden(orden++);//
                                    listaConDetalle.add(conDetalle);
                                }
                                ctaXiii = ctaXiii == null ? "" : ctaXiii;
                                if (ctaXiii.isEmpty()) {
                                    comprobar = false;
                                    if (mensaje.isEmpty()) {
                                        mensaje = "FProblemas con las siguientes cuentas:";
                                    }
                                    lista.add("Categoría " + ((java.util.List<Object>) listaObjeto).get(0).toString() + " : XIII");
                                }
                                valorFormaPago = valorFormaPago.add(new java.math.BigDecimal(((java.util.List<Object>) listaObjeto).get(2).toString()));
                                conDetalle = null;
                            }

                            conDetalle = new ConDetalle();
                            conDetalle.setConContable(conContable);
                            conDetalle.setDetSecuencia(0);
                            conDetalle.setDetDocumento("");
                            conDetalle.setPisNumero(null);
                            conDetalle.setDetGenerado(false);
                            if (rhCtaFormaPagoBeneficioSocialTO != null) {
                                ctaFormaPago = rhCtaFormaPagoBeneficioSocialTO.getCtaCodigo();
                                conDetalle.setSecCodigo(rhCtaFormaPagoBeneficioSocialTO.getSecCodigo());
                                conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                        empresa, (ctaFormaPago == null) ? "" : ctaFormaPago));
                                conDetalle.setDetDebitoCredito('C');
                                conDetalle.setDetReferencia("FP");//
                                conDetalle.setDetDocumento(documento);
                                conDetalle.setDetValor(valorFormaPago);
                                conDetalle.setDetOrden(orden++);//
                                listaConDetalle.add(conDetalle);
                            }
                            ctaFormaPago = ctaFormaPago == null ? "" : ctaFormaPago;
                            if (ctaFormaPago.isEmpty()) {
                                comprobar = false;
                                if (mensaje.isEmpty()) {
                                    mensaje = "FProblemas con las siguientes cuentas:";
                                }
                                lista.add("Forma de Pago");
                            }
                            // </editor-fold>
                        } else {
                            mensaje = "FProblema al totalizar por categoria y sector..";
                        }
                        if (comprobar) {
                            if (rhXiiiSueldos.size() > 0) {
                                comprobar = operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                                        conContable,
                                        listaConDetalle,
                                        sisSuceso,
                                        conNumeracion,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        rhXiiiSueldos,
                                        null,
                                        null,
                                        null,
                                        true,
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
                                        null,
                                        null,
                                        null,
                                        null,
                                        sisInfoTO);
                            } else {
                                comprobar = false;
                                mensaje = "FNo hay xiii's para contabilizar...";
                            }
                        }
                        if (comprobar) {
                            sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                            contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                            mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";

                            rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                            rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                            rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                        }
                        rhContableTO.setListaEmpleadoTO(lista);
                    } else {
                        mensaje = "FNo se encuentra tipo de contable...";
                    }
                } else {
                    mensaje = "FEl periodo seleccionado no se encuentra o esta cerrado...";
                }
            } else {
                mensaje = "FEl periodo XIII seleccionado no se encuentra o esta cerrado...";
            }
            rhContableTO.setMensaje(mensaje);
            return rhContableTO;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhXiiiSueldoConContable()",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="XIV">
    public java.util.List<rrhh.TO.RhXivSueldoPeriodoTO> getRhComboXivSueldoPeriodoTO() throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhComboXivSueldoPeriodoTO();
    }

    public java.util.List<rrhh.TO.RhUtilidadesPeriodoTO> getRhComboUtilidadesPeriodoTO(java.lang.String empresa) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhComboUtilidadesPeriodoTO(empresa);
    }

    public java.util.List<rrhh.TO.RhFunXivSueldoCalcularTO> getRhFunCalcularXivSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhFunCalcularXivSueldo(empresa, sector, desde, hasta);
    }

    public java.util.List<rrhh.TO.RhFunUtilidadesCalcularTO> getRhFunCalcularUtilidades(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta, java.lang.Integer totalDias, java.lang.Integer totalCargas, java.math.BigDecimal totalPagar) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhFunCalcularUtilidades(empresa, sector, desde, hasta, totalDias, totalCargas, totalPagar);
    }

    public java.util.List<rrhh.TO.RhFunXivSueldoConsultarTO> getRhFunConsultarXivSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhFunConsultarXivSueldo(empresa, sector, desde, hasta);
    }

    public java.util.List<rrhh.TO.RhFunUtilidadesConsultarTO> getRhFunConsultarUtilidades(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getRhFunConsultarUtilidades(empresa, sector, desde, hasta);
    }

    @Override
    public RhContableTO insertarRhXivSueldoConContable(
            java.lang.String empresa,
            java.lang.String periodoXiv,
            java.lang.String formaPago,
            java.lang.String documento,
            java.lang.String observaciones,
            java.util.List<rrhh.TO.RhFunXivSueldoCalcularTO> rhFunXivSueldoCalcularTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        List<String> lista = new java.util.ArrayList(1);
        RhContableTO rhContableTO = new RhContableTO();
        String tipDetalle = "C-BEN";
        mensaje = "F";
        RhXivSueldoPeriodoTO rhXivSueldoPeriodoTO = null;
        String periodo = "";
        String ctaXiv = null;
        String ctaFormaPago = null;
        RhCtaFormaPagoBeneficioSocialTO rhCtaFormaPagoBeneficioSocialTO = null;
        java.math.BigDecimal valorFormaPago = cero;
        try {
            //periodo Xiv
            rhXivSueldoPeriodoTO = operacionesRRHHDAOLocal.buscarRhXivSueldoPeriodoTO(periodoXiv);
            if (rhXivSueldoPeriodoTO != null) {
                //periodo
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(empresa);

                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (Validacion.fecha(rhXivSueldoPeriodoTO.getXivFechaMaximaPago(), "yyyy-MM-dd").getTime()
                            >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && Validacion.fecha(rhXivSueldoPeriodoTO.getXivFechaMaximaPago(), "yyyy-MM-dd").getTime()
                            <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                            && sisListaPeriodoTO.getPerCerrado() == false) {
                        comprobar = true;
                        periodo = sisListaPeriodoTO.getPerCodigo();
                        break;
                    }
                }
                if (comprobar) {
                    comprobar = true;
                    if (operacionesContabilidadDAOLocal.buscarTipoContable(empresa, tipDetalle)) {
                        //llenar contable
                        ConContableTO conContableTO = new ConContableTO();
                        conContableTO.setEmpCodigo(empresa);
                        conContableTO.setPerCodigo(periodo);
                        conContableTO.setTipCodigo(tipDetalle);
                        conContableTO.setConFecha(rhXivSueldoPeriodoTO.getXivFechaMaximaPago());
                        conContableTO.setConPendiente(false);
                        conContableTO.setConBloqueado(false);
                        conContableTO.setConAnulado(false);
                        conContableTO.setConGenerado(false); //deberia ser true, para elminar desde el modulo de contabilidad
                        conContableTO.setConConcepto(rhFunXivSueldoCalcularTOs.size() > 1 ? "REGISTRO DE XIV SUELDO" : rhFunXivSueldoCalcularTOs.get(0).getXivApellidos() + " " + rhFunXivSueldoCalcularTOs.get(0).getXivNombres());
                        conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                        conContableTO.setConObservaciones(observaciones);
                        conContableTO.setUsrInsertaContable(usuario);
                        conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                        ///// CREANDO UN SUCESO
                        susClave = "";
                        susSuceso = "INSERT";
                        susTabla = "contabilidad.con_contable";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        ////// CREANDO NUMERACION
                        contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                                conContableTO.getTipCodigo()));
                        ////// CREANDO CONTABLE
                        contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);

                        java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                        java.util.List<rrhh.entity.RhXivSueldo> rhXivSueldos = new java.util.ArrayList(0);
                        rrhh.entity.RhXivSueldo rhXivSueldo;
                        int orden = 0;
                        int contador = 0;
                        //-----------------
                        java.util.List listaObjetos = new java.util.ArrayList();
                        java.util.List<Object> objetos = new java.util.ArrayList();
                        //-----------------
                        if (!rhFunXivSueldoCalcularTOs.isEmpty()) {
                            //ctaFormaPagoBeneficioSocial
                            rhCtaFormaPagoBeneficioSocialTO = operacionesRRHHDAOLocal.buscarCtaRhFormaPagoBeneficioSocial(
                                    empresa,
                                    formaPago);
                            objetos.add(rhFunXivSueldoCalcularTOs.get(0).getXivCategoria());
                            objetos.add(rhFunXivSueldoCalcularTOs.get(0).getXivSector());
                            objetos.add(rhFunXivSueldoCalcularTOs.get(0).getXivValorXivSueldo());
                            objetos.add(rhFunXivSueldoCalcularTOs.get(0).getXivCuenta());
                            listaObjetos.add(objetos);
                            for (int i = 0; i < rhFunXivSueldoCalcularTOs.size(); i++) {
                                //armar entidad RhXivSueldo
                                rhXivSueldo = new RhXivSueldo();
                                rhXivSueldo.setXivSecuencial(0);
                                rhXivSueldo.setXivDesde(validaciones.Validacion.fecha(rhXivSueldoPeriodoTO.getXivDesde(), "yyyy-MM-dd"));
                                rhXivSueldo.setXivHasta(validaciones.Validacion.fecha(rhXivSueldoPeriodoTO.getXivHasta(), "yyyy-MM-dd"));
                                rhXivSueldo.setXivDiasLaboradosEmpleado(null);
                                rhXivSueldo.setXivDiasLaboradosEmpleado(rhFunXivSueldoCalcularTOs.get(i).getXivDiasLaborados());
                                rhXivSueldo.setXivBaseImponible(rhFunXivSueldoCalcularTOs.get(i).getXivTotalIngresos());
                                rhXivSueldo.setXivValor(rhFunXivSueldoCalcularTOs.get(i).getXivValorXivSueldo());
                                rhXivSueldo.setXivFormaPago(rhCtaFormaPagoBeneficioSocialTO.getCtaCodigo());
                                rhXivSueldo.setXivCodigoMinisterial(rhCtaFormaPagoBeneficioSocialTO.getFpCodigoMinisterial());
                                rhXivSueldo.setRhEmpleado(new RhEmpleado(
                                        empresa,
                                        rhFunXivSueldoCalcularTOs.get(i).getXivId()));
                                rhXivSueldo.setEmpCargo(rhFunXivSueldoCalcularTOs.get(i).getXivCargo());
                                rhXivSueldo.setEmpFechaIngreso(validaciones.Validacion.fecha(rhFunXivSueldoCalcularTOs.get(i).getXivFechaIngreso(), "yyyy-MM-dd"));
                                rhXivSueldo.setSecEmpresa(empresa);
                                rhXivSueldo.setSecCodigo(rhFunXivSueldoCalcularTOs.get(i).getXivSector());
                                rhXivSueldo.setConEmpresa(empresa);
                                rhXivSueldo.setConPeriodo(periodo);
                                rhXivSueldo.setConTipo(tipDetalle);
                                rhXivSueldos.add(rhXivSueldo);
                                //armar datos para el contable (totalizar con categoria y sector)
                                int posicion = 0;
                                boolean estado = false;
                                for (Object objeto : listaObjetos) {
                                    if (((java.util.List<Object>) objeto).get(0).toString().equals(rhFunXivSueldoCalcularTOs.get(i).getXivCategoria())
                                            && ((java.util.List<Object>) objeto).get(1).toString().equals(rhFunXivSueldoCalcularTOs.get(i).getXivSector())) {
                                        estado = true;
                                        break;
                                    } else {
                                        estado = false;
                                        posicion++;
                                    }
                                }
                                if (i != 0) {
                                    if (estado) {
                                        ((java.util.List<Object>) listaObjetos.get(posicion)).set(2,
                                                rhFunXivSueldoCalcularTOs.get(i).getXivValorXivSueldo().add(
                                                new java.math.BigDecimal(((java.util.List<Object>) listaObjetos.get(posicion)).get(2).toString())).toPlainString());
                                    } else {
                                        objetos = new java.util.ArrayList();
                                        objetos.add(rhFunXivSueldoCalcularTOs.get(i).getXivCategoria());
                                        objetos.add(rhFunXivSueldoCalcularTOs.get(i).getXivSector());
                                        objetos.add(rhFunXivSueldoCalcularTOs.get(i).getXivValorXivSueldo());
                                        objetos.add(rhFunXivSueldoCalcularTOs.get(i).getXivCuenta());
                                        listaObjetos.add(objetos);
                                    }
                                }
                            }
//                            //*System.out.println(listaObjetos.size());
//                            for(Object listaObjeto:listaObjetos){
//                                //*System.out.println(((java.util.List<Object>)listaObjeto).get(0));
//                                //*System.out.println(((java.util.List<Object>)listaObjeto).get(1));
//                                //*System.out.println(((java.util.List<Object>)listaObjeto).get(2));
//                                //*System.out.println(((java.util.List<Object>)listaObjeto).get(3));
//                            }
                        } else {
                            mensaje = "FNo hay Xiv's...";
                        }
                        if (!listaObjetos.isEmpty()) {
                            // <editor-fold defaultstate="collapsed" desc="ConDetalle">
                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                            ConDetalle conDetalle = null;
                            //(0) XivCategoria;
                            //(1) XivSector;
                            //(2) XivValorXivSueldo;
                            //(4) XivCuenta;
                            for (Object listaObjeto : listaObjetos) {
                                conDetalle = new ConDetalle();
                                conDetalle.setConContable(conContable);
                                conDetalle.setDetSecuencia(0);
                                conDetalle.setDetDocumento("");
                                conDetalle.setPisNumero(null);
                                conDetalle.setDetGenerado(false);
                                //ctaXiv
                                ctaXiv = operacionesRRHHDAOLocal.buscarCtaRhXivCategoria(
                                        empresa,
                                        ((java.util.List<Object>) listaObjeto).get(0).toString());
                                if (ctaXiv != null) {
                                    conDetalle.setSecCodigo(((java.util.List<Object>) listaObjeto).get(1).toString());
                                    conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                            empresa, (ctaXiv == null) ? "" : ctaXiv));
                                    conDetalle.setDetDebitoCredito('D');
                                    conDetalle.setDetReferencia("Xiv");//
                                    conDetalle.setDetValor(new java.math.BigDecimal(((java.util.List<Object>) listaObjeto).get(2).toString()));
                                    conDetalle.setDetOrden(orden++);//
                                    listaConDetalle.add(conDetalle);
                                }
                                ctaXiv = ctaXiv == null ? "" : ctaXiv;
                                if (ctaXiv.isEmpty()) {
                                    comprobar = false;
                                    if (mensaje.isEmpty()) {
                                        mensaje = "FProblemas con las siguientes cuentas:";
                                    }
                                    lista.add("Categoría " + ((java.util.List<Object>) listaObjeto).get(0).toString() + " : Xiv");
                                }
                                valorFormaPago = valorFormaPago.add(new java.math.BigDecimal(((java.util.List<Object>) listaObjeto).get(2).toString()));
                                conDetalle = null;
                            }

                            conDetalle = new ConDetalle();
                            conDetalle.setConContable(conContable);
                            conDetalle.setDetSecuencia(0);
                            conDetalle.setDetDocumento("");
                            conDetalle.setPisNumero(null);
                            conDetalle.setDetGenerado(false);
                            if (rhCtaFormaPagoBeneficioSocialTO != null) {
                                ctaFormaPago = rhCtaFormaPagoBeneficioSocialTO.getCtaCodigo();
                                conDetalle.setSecCodigo(rhCtaFormaPagoBeneficioSocialTO.getSecCodigo());
                                conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                        empresa, (ctaFormaPago == null) ? "" : ctaFormaPago));
                                conDetalle.setDetDebitoCredito('C');
                                conDetalle.setDetReferencia("FP");//
                                conDetalle.setDetDocumento(documento);
                                conDetalle.setDetValor(valorFormaPago);
                                conDetalle.setDetOrden(orden++);//
                                listaConDetalle.add(conDetalle);
                            }
                            ctaFormaPago = ctaFormaPago == null ? "" : ctaFormaPago;
                            if (ctaFormaPago.isEmpty()) {
                                comprobar = false;
                                if (mensaje.isEmpty()) {
                                    mensaje = "FProblemas con las siguientes cuentas:";
                                }
                                lista.add("Forma de Pago");
                            }
                            // </editor-fold>
                        } else {
                            mensaje = "FProblema al totalizar por categoria y sector..";
                        }
                        if (comprobar) {
                            if (rhXivSueldos.size() > 0) {
                                comprobar = operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                                        conContable,
                                        listaConDetalle,
                                        sisSuceso,
                                        conNumeracion,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        rhXivSueldos,
                                        null,
                                        null,
                                        true,
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
                                        null,
                                        null,
                                        null,
                                        null,
                                        sisInfoTO);
                            } else {
                                comprobar = false;
                                mensaje = "FNo hay xiv's para contabilizar...";
                            }
                        }
                        if (comprobar) {
                            sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                            contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                            mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";

                            rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                            rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                            rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                        }
                        rhContableTO.setListaEmpleadoTO(lista);
                    } else {
                        mensaje = "FNo se encuentra tipo de contable...";
                    }
                } else {
                    mensaje = "FEl periodo seleccionado no se encuentra o esta cerrado...";
                }
            } else {
                mensaje = "FEl periodo Xiv seleccionado no se encuentra o esta cerrado...";
            }
            rhContableTO.setMensaje(mensaje);
            return rhContableTO;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhXivSueldoConContable()",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="UTILIDAD">
    @Override
    public RhContableTO insertarRhUtilidadesConContable(
            java.lang.String empresa,
            java.lang.String periodoUtilidades,
            java.lang.String formaPago,
            java.lang.String documento,
            java.lang.String observaciones,
            java.util.List<rrhh.TO.RhFunUtilidadesTO> rhFunUtilidadesCalcularTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {

        comprobar = false;
        List<String> lista = new java.util.ArrayList(1);
        RhContableTO rhContableTO = new RhContableTO();
        String tipDetalle = "C-BEN";
        mensaje = "F";
        RhUtilidadesPeriodoTO rhUtilidadesPeriodoTO = null;
        String periodo = "";
        String ctaPorPagarUtilidades = null;
        String ctaFormaPago = null;
        RhCtaFormaPagoBeneficioSocialTO rhCtaFormaPagoBeneficioSocialTO = null;
        java.math.BigDecimal valorFormaPago = cero;
        try {
            //periodo Utilidades
            rhUtilidadesPeriodoTO = operacionesRRHHDAOLocal.buscarRhUtilidadesPeriodoTO(periodoUtilidades);
            if (rhUtilidadesPeriodoTO != null) {
                //periodo
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(empresa);

                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (Validacion.fecha(rhUtilidadesPeriodoTO.getUtiFechaMaximaPago(), "yyyy-MM-dd").getTime()
                            >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && Validacion.fecha(rhUtilidadesPeriodoTO.getUtiFechaMaximaPago(), "yyyy-MM-dd").getTime()
                            <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                            && sisListaPeriodoTO.getPerCerrado() == false) {
                        comprobar = true;
                        periodo = sisListaPeriodoTO.getPerCodigo();
                        break;
                    }
                }
                if (comprobar) {
                    comprobar = true;
                    if (operacionesContabilidadDAOLocal.buscarTipoContable(empresa, tipDetalle)) {
                        //llenar contable
                        ConContableTO conContableTO = new ConContableTO();
                        conContableTO.setEmpCodigo(empresa);
                        conContableTO.setPerCodigo(periodo);
                        conContableTO.setTipCodigo(tipDetalle);
                        conContableTO.setConFecha(rhUtilidadesPeriodoTO.getUtiFechaMaximaPago());
                        conContableTO.setConPendiente(false);
                        conContableTO.setConBloqueado(false);
                        conContableTO.setConAnulado(false);
                        conContableTO.setConGenerado(false); //deberia ser true, para elminar desde el modulo de contabilidad
                        conContableTO.setConConcepto(rhFunUtilidadesCalcularTOs.size() > 1 ? "REGISTRO DE UTILIDADES" : rhFunUtilidadesCalcularTOs.get(0).getUtiApellidos() + " " + rhFunUtilidadesCalcularTOs.get(0).getUtiNombres());
                        conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                        conContableTO.setConObservaciones(observaciones);
                        conContableTO.setUsrInsertaContable(usuario);
                        conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                        ///// CREANDO UN SUCESO
                        susClave = "";
                        susSuceso = "INSERT";
                        susTabla = "contabilidad.con_contable";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        ////// CREANDO NUMERACION
                        contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                                conContableTO.getTipCodigo()));
                        ////// CREANDO CONTABLE
                        contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                        java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                        java.util.List<rrhh.entity.RhUtilidades> rhUtilidades = new java.util.ArrayList(0);
                        rrhh.entity.RhUtilidades rhUtilidad;
                        int orden = 0;
                        int contador = 0;
                        //-----------------
                        java.util.List listaObjetos = new java.util.ArrayList();
                        java.util.List<Object> objetos = new java.util.ArrayList();
                        //-----------------
                        if (!rhFunUtilidadesCalcularTOs.isEmpty()) {
                            //ctaFormaPagoBeneficioSocial
                            rhCtaFormaPagoBeneficioSocialTO = operacionesRRHHDAOLocal.buscarCtaRhFormaPagoBeneficioSocial(
                                    empresa,
                                    formaPago);
                            objetos.add(rhFunUtilidadesCalcularTOs.get(0).getUtiId());
                            objetos.add(rhFunUtilidadesCalcularTOs.get(0).getUtiCategoria());
                            objetos.add(rhFunUtilidadesCalcularTOs.get(0).getUtiSector());
                            objetos.add(rhFunUtilidadesCalcularTOs.get(0).getUtiValorUtilidades());
                            listaObjetos.add(objetos);
                            for (int i = 0; i < rhFunUtilidadesCalcularTOs.size(); i++) {
                                //armar entidad RhUtilidad
                                rhUtilidad = new RhUtilidades();
                                rhUtilidad.setUtiSecuencial(0);
                                rhUtilidad.setUtiDesde(validaciones.Validacion.fecha(rhUtilidadesPeriodoTO.getUtiDesde(), "yyyy-MM-dd"));
                                rhUtilidad.setUtiHasta(validaciones.Validacion.fecha(rhUtilidadesPeriodoTO.getUtiHasta(), "yyyy-MM-dd"));
                                rhUtilidad.setUtiDiasLaborados(null);
                                rhUtilidad.setUtiDiasLaborados(rhFunUtilidadesCalcularTOs.get(i).getUtiDiasLaborados());
                                rhUtilidad.setEmpCargasFamiliares(rhFunUtilidadesCalcularTOs.get(i).getUtiCargasFamiliares());
                                rhUtilidad.setUtiValorTotal(rhFunUtilidadesCalcularTOs.get(i).getUtiValorUtilidades());
                                rhUtilidad.setUtiFormaPago(rhCtaFormaPagoBeneficioSocialTO.getCtaCodigo());
                                rhUtilidad.setUtiCodigoMinisterial(rhCtaFormaPagoBeneficioSocialTO.getFpCodigoMinisterial());
                                rhUtilidad.setRhEmpleado(new RhEmpleado(
                                        empresa,
                                        rhFunUtilidadesCalcularTOs.get(i).getUtiId()));
                                rhUtilidad.setEmpCargo(rhFunUtilidadesCalcularTOs.get(i).getUtiCargo());
                                rhUtilidad.setEmpFechaIngreso(validaciones.Validacion.fecha(rhFunUtilidadesCalcularTOs.get(i).getUtiFechaIngreso(), "yyyy-MM-dd"));
                                rhUtilidad.setSecEmpresa(empresa);
                                rhUtilidad.setSecCodigo(rhFunUtilidadesCalcularTOs.get(i).getUtiSector());
                                rhUtilidad.setConEmpresa(empresa);
                                rhUtilidad.setConPeriodo(periodo);
                                rhUtilidad.setConTipo(tipDetalle);
                                rhUtilidades.add(rhUtilidad);
                                //armar datos para el contable (totalizar con categoria y sector)
                                int posicion = 0;
                                boolean estado = false;
                                for (Object objeto : listaObjetos) {
                                    if (((java.util.List<Object>) objeto).get(0).toString().equals(rhFunUtilidadesCalcularTOs.get(i).getUtiCategoria())
                                            && ((java.util.List<Object>) objeto).get(1).toString().equals(rhFunUtilidadesCalcularTOs.get(i).getUtiSector())) {
                                        estado = true;
                                        break;
                                    } else {
                                        estado = false;
                                        posicion++;
                                    }
                                }
                                if (i != 0) {
                                    if (estado) {
                                        ((java.util.List<Object>) listaObjetos.get(posicion)).set(2,
                                                rhFunUtilidadesCalcularTOs.get(i).getUtiValorUtilidades().add(
                                                new java.math.BigDecimal(((java.util.List<Object>) listaObjetos.get(posicion)).get(2).toString())).toPlainString());
                                    } else {
                                        objetos = new java.util.ArrayList();
                                        objetos.add(rhFunUtilidadesCalcularTOs.get(i).getUtiId());
                                        objetos.add(rhFunUtilidadesCalcularTOs.get(i).getUtiCategoria());
                                        objetos.add(rhFunUtilidadesCalcularTOs.get(i).getUtiSector());
                                        objetos.add(rhFunUtilidadesCalcularTOs.get(i).getUtiValorUtilidades());
                                        listaObjetos.add(objetos);
                                    }
                                }
                            }
                        } else {
                            mensaje = "FNo hay Utilidades...";
                        }
                        if (!listaObjetos.isEmpty()) {
                            // <editor-fold defaultstate="collapsed" desc="ConDetalle">
                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                            ConDetalle conDetalle = null;
                            for (Object listaObjeto : listaObjetos) {
                                conDetalle = new ConDetalle();
                                conDetalle.setConContable(conContable);
                                conDetalle.setDetSecuencia(0);
                                conDetalle.setDetDocumento("");
                                conDetalle.setPisNumero("");
                                conDetalle.setDetGenerado(false);
                                ctaPorPagarUtilidades = operacionesRRHHDAOLocal.buscarCtaRhPorPagarUtilidades(
                                        empresa,
                                        ((java.util.List<Object>) listaObjeto).get(0).toString());

                                if (ctaPorPagarUtilidades != null) {
                                    conDetalle.setSecCodigo(((java.util.List<Object>) listaObjeto).get(2).toString());
                                    conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                            empresa, (ctaPorPagarUtilidades == null) ? "" : ctaPorPagarUtilidades));
                                    conDetalle.setDetDebitoCredito('D');
                                    conDetalle.setDetReferencia("UTI");//
                                    conDetalle.setDetValor(new java.math.BigDecimal(((java.util.List<Object>) listaObjeto).get(3).toString()));
                                    conDetalle.setDetOrden(orden++);//
                                    listaConDetalle.add(conDetalle);
                                }
                                ctaPorPagarUtilidades = ctaPorPagarUtilidades == null ? "" : ctaPorPagarUtilidades;
                                if (ctaPorPagarUtilidades.isEmpty()) {
                                    comprobar = false;
                                    if (mensaje.isEmpty()) {
                                        mensaje = "FProblemas con las siguientes cuentas:";
                                    }
                                    lista.add("Categoría " + ((java.util.List<Object>) listaObjeto).get(1).toString() + " : Utilidades");
                                }
                                valorFormaPago = valorFormaPago.add(new java.math.BigDecimal(((java.util.List<Object>) listaObjeto).get(3).toString()));
                                conDetalle = null;
                            }

                            conDetalle = new ConDetalle();
                            conDetalle.setConContable(conContable);
                            conDetalle.setDetSecuencia(0);
                            conDetalle.setDetDocumento("");
                            conDetalle.setPisNumero("");
                            conDetalle.setDetGenerado(false);
                            if (rhCtaFormaPagoBeneficioSocialTO != null) {
                                ctaFormaPago = rhCtaFormaPagoBeneficioSocialTO.getCtaCodigo();
                                conDetalle.setSecCodigo(rhCtaFormaPagoBeneficioSocialTO.getSecCodigo());
                                conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                        empresa, (ctaFormaPago == null) ? "" : ctaFormaPago));
                                conDetalle.setDetDebitoCredito('C');
                                conDetalle.setDetReferencia("FP");//
                                conDetalle.setDetDocumento(documento);
                                conDetalle.setDetValor(valorFormaPago);
                                conDetalle.setDetOrden(orden++);//
                                listaConDetalle.add(conDetalle);
                            }
                            ctaFormaPago = ctaFormaPago == null ? "" : ctaFormaPago;
                            if (ctaFormaPago.isEmpty()) {
                                comprobar = false;
                                if (mensaje.isEmpty()) {
                                    mensaje = "FProblemas con las siguientes cuentas:";
                                }
                                lista.add("Forma de Pago");
                            }
                            // </editor-fold>
                        } else {
                            mensaje = "FProblema al totalizar por categoria y sector..";
                        }
                        if (comprobar) {
                            if (rhUtilidades.size() > 0) {
                                comprobar = operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                                        conContable,
                                        listaConDetalle,
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
                                        rhUtilidades,
                                        null,
                                        true,
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
                                        null,
                                        null,
                                        null,
                                        null,
                                        sisInfoTO);
                            } else {
                                comprobar = false;
                                mensaje = "FNo hay Utilidades para contabilizar...";
                            }
                        }
                        if (comprobar) {
                            sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                            contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                            mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";

                            rhContableTO.setPerCodigo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                            rhContableTO.setTipCodigo(conTipo.getConTipoPK().getTipCodigo());
                            rhContableTO.setConNumero(conContable.getConContablePK().getConNumero());
                        }
                        rhContableTO.setListaEmpleadoTO(lista);
                    } else {
                        mensaje = "FNo se encuentra tipo de contable...";
                    }
                } else {
                    mensaje = "FEl periodo seleccionado no se encuentra o esta cerrado...";
                }
            } else {
                mensaje = "FEl periodo Utilidades seleccionado no se encuentra o esta cerrado...";
            }
            rhContableTO.setMensaje(mensaje);
            return rhContableTO;

        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor...\nContacte con el administrador..";
            rhContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhUtilidades()",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return rhContableTO;
        }


    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMULARIO 107">
    /**
     * @autor Jack Krauser
     *
     * @param empresa La empresa
     * @param desde Una fecha
     * <code>desde</code> con formato
     * <code>yyyy-MM-dd</code>
     * @param hasta Una fecha
     * <code>hasta</code> con formato
     * <code>yyyy-MM-dd</code>
     * @param empleadoID La cedula o pasaporte del empleado a consultar
     * @return Datos del empleado para ser llenado en el formulario en el lado
     * del cliente
     * @throws Exception Cualquier error inesperado
     */
    public rrhh.TO.RhFormulario107TO getRhFormulario107ConsultaTO(String empresa, String desde, String hasta, String empleadoID) throws Exception {
        return operacionesRRHHDAOLocal.getRhFormulario107ConsultaTO(empresa, desde, hasta, empleadoID);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa La empresa
     * @param anio El año del ejercicio fiscal
     * @param empleadoID La cedula o pasaporte del empleado a consultar
     * @return Datos del empleado para ser llenado en el formulario en el lado
     * del cliente para poder ser impreso
     * @throws Exception Cualquier error inesperado
     */
    public rrhh.TO.RhFormulario107TO getRhFormulario107TO(String empresa, String anio, String empleadoID) throws Exception {
        return operacionesRRHHDAOLocal.getRhFormulario107TO(empresa, anio, empleadoID);
    }

    /**
     * @autor Jack Krauser
     *
     * @param rrhh.TO.RhFormulario107TO El objeto que viene formado desde el
     * Cliente
     * @return Mensaje que expresa el exito de la transaccion
     * @throws Exception Cualquier error inesperado
     */
    public String insertarRhFormulario107TO(
            rrhh.TO.RhFormulario107TO rhFormulario107TO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensajeRetorno = "";
        try {

            rrhh.entity.RhFormulario107 rhFormulario107Consulta = operacionesRRHHDAOLocal.getRhFormulario107(rhFormulario107TO.getF107Empresa(), rhFormulario107TO.getF107Anio(), rhFormulario107TO.getF107Id());
            if (rhFormulario107Consulta == null) {
                susClave =
                        rhFormulario107TO.getF107Empresa() + " | "
                        + rhFormulario107TO.getF107Anio() + " | "
                        + rhFormulario107TO.getF107Id();
                susDetalle = "Se insertó el Formulario107 " + rhFormulario107TO.getF107Empresa() + " | " + rhFormulario107TO.getF107Anio() + " | " + rhFormulario107TO.getF107Id();
                susSuceso = "INSERT";
                susTabla = "rh_formulario_107";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);

                rhFormulario107TO.setUsrFechaInserta(validaciones.Validacion.fechaSistema("yyyy-MM-dd"));
                rrhh.entity.RhFormulario107 rhFormulario107 = rrhh.helper.ConversionesRRHH.convertirRhFormulario107TO_RhFormulario107(rhFormulario107TO);

                if (operacionesRRHHDAOTransaccionLocal.insertarRhFormulario107(rhFormulario107, sisSuceso)) {
                    mensajeRetorno = "T<html>Se ha guardado la información</font>.</html>";
                } else {
                    mensajeRetorno = "FHubo un error al guardar la información...\nIntente de nuevo o contacte con el administrador.";
                }
            } else {
                mensajeRetorno = "FLa información ya existe en la Base de Datos.\nIntente con otro.";
            }


        } catch (Exception e) {
            e.printStackTrace();
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarSisUsuarioTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensajeRetorno;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PERIODO FISCAL FORMULARIO 107">
    /**
     * @autor Jack Krauser
     *
     * @return Periodo Fiscal en forma de Lista para un combo
     * @throws Exception Cualquier error inesperado
     */
    public java.util.List<rrhh.TO.RhFormulario107PeriodoFiscalTO> getRhFormulario107PeriodoFiscalComboTO() throws Exception {
        return operacionesRRHHDAOLocal.getRhFormulario107PeriodoFiscalComboTO();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="RECALCULO IR">
    /**
     *
     * @param valor El valor sobre el cual se va a recalcular el IR (impuesto a
     * la renta)
     * @param desde La fecha desde del periodo fiscal
     * @param hasta La fecha desde del periodo fiscal
     * @return un BigDecimal con el valor recalculado del IR
     * @throws Exception Cualquier error inesperado
     */
    public java.math.BigDecimal getValorRecalculadoIR(java.math.BigDecimal valor, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getValorRecalculadoIR(valor, desde, hasta);
    }
    // </editor-fold>

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Xiiis Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoXiiis(String empresa, String fecha, String cuenta) throws Exception {
        return operacionesRRHHDAOLocal.getRhFunPreavisoXiiis(empresa, fecha, cuenta);
    }

    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoXivs(String empresa, String fecha, String cuenta) throws Exception {
        return operacionesRRHHDAOLocal.getRhFunPreavisoXivs(empresa, fecha, cuenta);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Anticipos Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoAnticipos(
            String empresa,
            String fecha,
            String cuenta,
            String tipoPreAviso,
            String servicio) throws Exception {
        return operacionesRRHHDAOLocal.getRhFunPreavisoAnticipos(
                empresa,
                fecha,
                cuenta,
                tipoPreAviso,
                servicio);

    }

    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoPichinchaTO> getRhFunPreavisoAnticiposPichincha(String empresa, String fecha, String cuenta, String tipo) throws Exception {
        return operacionesRRHHDAOLocal.getRhFunPreavisoAnticiposPichincha(empresa, fecha, cuenta, tipo);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Prestamos Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoPrestamos(String empresa, String fecha, String cuenta) throws Exception {
        return operacionesRRHHDAOLocal.getRhFunPreavisoPrestamos(empresa, fecha, cuenta);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Sueldos Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoSueldos(String empresa, String fecha, String cuenta) throws Exception {
        return operacionesRRHHDAOLocal.getRhFunPreavisoSueldos(empresa, fecha, cuenta);
    }

    @Override
    public java.util.List<rrhh.TO.RhFunFormulario107TO> getRhFunFormulario107(String empresa, String desde, String hasta, Character status) throws Exception {
        return operacionesRRHHDAOLocal.getRhFunFormulario107(empresa, desde, hasta, status);
    }

    @Override
    public java.util.List<rrhh.TO.RhFunFormulario107_2013TO> getRhFunFormulario107_2013(String empresa, String desde, String hasta, Character status) throws Exception {
        return operacionesRRHHDAOLocal.getRhFunFormulario107_2013(empresa, desde, hasta, status);
    }

    @Override
    public boolean getSwInactivaEmpleado(java.lang.String empresa, java.lang.String empleado) throws java.lang.Exception {
        return operacionesRRHHDAOLocal.getSwInactivaEmpleado(empresa, empleado);
    }

    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoVacaciones(String empresa, String fecha, String cuenta) throws Exception {
        return operacionesRRHHDAOLocal.getRhFunPreavisoVacaciones(empresa, fecha, cuenta);
    }

    @Override
    public helper.RetornoTO getConsolidadoIngresosTabulado(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {

            java.util.List<rrhh.TO.RhConsolidadoIngresosTabuladoTO> rhConsolidadoIngresosTabuladoTOs = operacionesRRHHDAOLocal.getConsolidadoIngresosTabulado(empresa, codigoSector, fechaInicio, fechaFin);
            mensaje = "T";
            rrhh.helper.NumeroColumnaDesconocidadConsolidadoIngresosTabulado obj = new rrhh.helper.NumeroColumnaDesconocidadConsolidadoIngresosTabulado();

            obj.agruparCabeceraColumnas(rhConsolidadoIngresosTabuladoTOs);
            obj.agruparCuentas(rhConsolidadoIngresosTabuladoTOs);
            obj.llenarObjetoParaTabla(rhConsolidadoIngresosTabuladoTOs);
            retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
            retornoTO.setColumnas(obj.getColumnas());
            retornoTO.setDatos(obj.getDatos());
        } catch (Exception e) {
            comprobar = false;
            mensaje = "FOcurrió un error al obtener los datos de la Base de Datos. \nContacte con el administrador...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getBalanceResultadoMensualizado",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            retornoTO.setMensaje(mensaje);
            return retornoTO;
        }

    }

    public List<RhEmpleadoDescuentosFijosTO> getRhEmpleadoDescuentosFijosTO(String empresa, String empresaID) throws Exception {
        return operacionesRRHHDAOLocal.getRhEmpleadoDescuentosFijosTO(empresa, empresaID);
    }

    public List<RhEmpleadoDescuentosFijos> getRhEmpleadoDescuentosFijos(String empresa, String empresaID) throws Exception {
        return operacionesRRHHDAOLocal.getRhEmpleadoDescuentosFijos(empresa, empresaID);
    }

    @Override
    public helper.RetornoTO getProvisionPorFechas(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String agrupacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {

            java.util.List<rrhh.TO.RhProvisionFechasTO> rhProvisionFechasTOs = operacionesRRHHDAOLocal.getProvisionPorFechas(empresa, codigoSector, fechaInicio, fechaFin, agrupacion);
            mensaje = "T";
            rrhh.helper.NumeroColumnaDesconocidadProvisionFechas obj = new rrhh.helper.NumeroColumnaDesconocidadProvisionFechas();

            obj.agruparCabeceraColumnas(rhProvisionFechasTOs);
            obj.agruparCuentas(rhProvisionFechasTOs);
            obj.llenarObjetoParaTabla(rhProvisionFechasTOs);
            retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
            retornoTO.setColumnas(obj.getColumnas());
            retornoTO.setDatos(obj.getDatos());
        } catch (Exception e) {
            comprobar = false;
            mensaje = "FOcurrió un error al obtener los datos de la Base de Datos. \nContacte con el administrador...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getBalanceResultadoMensualizado",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            retornoTO.setMensaje(mensaje);
            return retornoTO;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="ANTICIPO MOTIVO">
    @Override
    public String accionRhAnticipoMotivo(
            rrhh.TO.RhAnticipoMotivoTO rhAnticipoMotivoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        Boolean estadoCtaCodigo = false;
        Boolean estadoSector = false;
        try {
            ///// BUSCANDO existencia cuentas
            estadoCtaCodigo = operacionesContabilidadDAOLocal.buscarCuentas(
                    rhAnticipoMotivoTO.getUsrEmpresa(),
                    rhAnticipoMotivoTO.getCtaCodigo()) != null ? true : false;
            ///// BUSCANDO existencia sector
            estadoSector = operacionesProduccionDAOLocal.buscarSector(
                    rhAnticipoMotivoTO.getUsrEmpresa(),
                    rhAnticipoMotivoTO.getSecCodigo()) != null ? true : false;
            if (estadoCtaCodigo && estadoSector) {//revisar si estan llenos
                ///// CREANDO Suceso
                susClave = rhAnticipoMotivoTO.getMotDetalle();
                if (accion == 'I') {
                    susDetalle = "Se insertó el AnticipoMotivo con el detalle " + rhAnticipoMotivoTO.getMotDetalle();
                    susSuceso = "INSERT";
                }
                if (accion == 'M') {
                    susDetalle = "Se modificó el AnticipoMotivo con el detalle " + rhAnticipoMotivoTO.getMotDetalle();
                    susSuceso = "UPDATE";
                }
                if (accion == 'E') {
                    susDetalle = "Se eliminó el AnticipoMotivo con el detalle " + rhAnticipoMotivoTO.getMotDetalle();
                    susSuceso = "DELETE";
                }
                susTabla = "recursoshumanos.rh_anticipo_motivo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                ///// CREANDO RhAnticipoMotivo
                rhAnticipoMotivoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                rrhh.entity.RhAnticipoMotivo rhAnticipoMotivo = rrhh.helper.ConversionesRRHH.convertirRhAnticipoMotivoTO_RhAnticipoMotivo(rhAnticipoMotivoTO);
                if (accion == 'E') {
                    ////// BUSCANDO existencia RhAnticipoMotivo
                    if (operacionesRRHHDAOLocal.buscarAnticipoMotivo(
                            rhAnticipoMotivoTO.getMotEmpresa(),
                            rhAnticipoMotivoTO.getMotDetalle()) != null) {
                        if (operacionesRRHHDAOLocal.comprobarEliminarRhAnticipoMotivo(
                                rhAnticipoMotivoTO.getMotEmpresa(),
                                rhAnticipoMotivoTO.getMotDetalle())) {
                            rhAnticipoMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                            comprobar = operacionesRRHHDAOTransaccionLocal.accionRhAnticipoMotivo(rhAnticipoMotivo, sisSuceso, accion);
                        } else {
                            mensaje = "FNo se puede eliminar, el AnticipoMotivo, está asignado con algun empleado...";
                        }
                    } else {
                        mensaje = "FNo se encuentra el AnticipoMotivo...";
                    }
                }
                if (accion == 'M') {
                    ////// BUSCANDO existencia RhAnticipoMotivo
                    if (operacionesRRHHDAOLocal.buscarAnticipoMotivo(
                            rhAnticipoMotivoTO.getMotEmpresa(), rhAnticipoMotivoTO.getMotDetalle()) != null) {
                        rhAnticipoMotivo.setUsrFechaInserta(
                                operacionesRRHHDAOLocal.buscarAnticipoMotivo(
                                rhAnticipoMotivoTO.getMotEmpresa(), rhAnticipoMotivoTO.getMotDetalle()).getUsrFechaInserta());
                        comprobar = operacionesRRHHDAOTransaccionLocal.accionRhAnticipoMotivo(rhAnticipoMotivo, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra el AnticipoMotivo...";
                    }
                }
                if (accion == 'I') {
                    ////// BUSCANDO existencia RhAnticipoMotivo
                    if (!operacionesRRHHDAOLocal.buscarRhAnticipoMotivo(
                            rhAnticipoMotivoTO.getMotEmpresa(),
                            rhAnticipoMotivoTO.getMotDetalle())) {
                        rhAnticipoMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesRRHHDAOTransaccionLocal.accionRhAnticipoMotivo(rhAnticipoMotivo, sisSuceso, accion);
                    } else {
                        mensaje = "FYa existe el AnticipoMotivo...";
                    }
                }
            } else {
                if (!estadoCtaCodigo) {
                    mensaje = "FNo se encuentra la cuenta contable...";
                }
                if (!estadoSector) {
                    mensaje = "FNo se encuentra el sector...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el AnticipoMotivo";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el AnticipoMotivo";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente el AnticipoMotivo";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar el AnticipoMotivo, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionRhAnticipoMotivo",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    public List<RhAnticipoMotivoTO> getListaRhAnticipoMotivoTablaTO(String empresa) throws Exception {
        return operacionesRRHHDAOLocal.getListaRhAnticipoMotivoTablaTO(empresa);
    }

    public List<RhAnticipoMotivoTO> getListaRhAnticipoMotivoTOTablaTO(String empresa, String codigo) throws Exception {
        return operacionesRRHHDAOLocal.getListaRhAnticipoMotivoTOTablaTO(empresa, codigo);
    }

    public rrhh.TO.RhAnticipoMotivoTO getRhAnticipoMotivoTO(String empresa, String detalle) throws Exception {
        return operacionesRRHHDAOLocal.getRhAnticipoMotivoTO(empresa, detalle);
    }

    public rrhh.entity.RhAnticipoMotivo getRhAnticipoMotivo(String empresa, String codigo) throws Exception {
        return operacionesRRHHDAOLocal.getRhAnticipoMotivo(empresa, codigo);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="periodo de XIII sueldo">
    @Override
    public String accionRhXiiiSueldoPeriodo(
            rrhh.TO.RhXiiiSueldoPeriodoTO rhXiiiSueldoPeriodoTO,
            String codigoEmpresa,
            String codigoUsuario,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = rhXiiiSueldoPeriodoTO.getXiiiDescripcion();
            if (accion == 'I') {
                susDetalle = "Se insertó Periodo " + rhXiiiSueldoPeriodoTO.getXiiiDescripcion();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se Modificó Periodo " + rhXiiiSueldoPeriodoTO.getXiiiDescripcion();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó Periodo " + rhXiiiSueldoPeriodoTO.getXiiiDescripcion();
                susSuceso = "DELETE";
            }
            susTabla = "recursoshumanos.rh_xiii_sueldo_periodo";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invProductoMedida
            rrhh.entity.RhXiiiSueldoPeriodo RhXiiiSueldoPeriodo = rrhh.helper.ConversionesRRHH.convertirRhXiiiSueldoPeriodoTO_RhXiiiSueldoPeriodo(rhXiiiSueldoPeriodoTO);
            if (accion == 'E') {
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesRRHHDAOLocal.buscarRhXiiiSueldoPeriodo(rhXiiiSueldoPeriodoTO.getPeriodoSecuencial()) != null) {
                    comprobar = operacionesRRHHDAOTransaccionLocal.accionRhXiiiSueldoPeriodo(RhXiiiSueldoPeriodo, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el Vendedor...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesRRHHDAOLocal.comprobarRhXiiiSueldoPeriodoTO(RhXiiiSueldoPeriodo.getXiiiDescripcion())) {
                    //invVendedor.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));, char accion
                    comprobar = operacionesRRHHDAOTransaccionLocal.accionRhXiiiSueldoPeriodo(RhXiiiSueldoPeriodo, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe el Periodo...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el Periodo";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el Periodo";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente  el Periodo";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar  el Periodo:" + rhXiiiSueldoPeriodoTO.getXiiiDescripcion() + ", inténtelo de nuevo...";
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="periodo de XIV sueldo">
    @Override
    public String accionRhXivSueldoPeriodo(
            rrhh.TO.RhXivSueldoPeriodoTO rhXivSueldoPeriodoTO,
            String codigoEmpresa,
            String codigoUsuario,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = rhXivSueldoPeriodoTO.getXivDescripcion();
            if (accion == 'I') {
                susDetalle = "Se insertó Periodo " + rhXivSueldoPeriodoTO.getXivDescripcion();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se Modificó Periodo " + rhXivSueldoPeriodoTO.getXivDescripcion();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó Periodo " + rhXivSueldoPeriodoTO.getXivDescripcion();
                susSuceso = "DELETE";
            }
            susTabla = "recursoshumanos.rh_xiv_sueldo_periodo";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO invProductoMedida
            rrhh.entity.RhXivSueldoPeriodo RhXivSueldoPeriodo = rrhh.helper.ConversionesRRHH.convertirRhXivSueldoPeriodoTO_RhXivSueldoPeriodo(rhXivSueldoPeriodoTO);
            if (accion == 'E') {
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesRRHHDAOLocal.buscarRhXivSueldoPeriodo(rhXivSueldoPeriodoTO.getPeriodoSecuencial()) != null) {
                    comprobar = operacionesRRHHDAOTransaccionLocal.accionRhXivSueldoPeriodo(RhXivSueldoPeriodo, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el Vendedor...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesRRHHDAOLocal.comprobarRhXivSueldoPeriodoTO(RhXivSueldoPeriodo.getXivDescripcion())) {
                    comprobar = operacionesRRHHDAOTransaccionLocal.accionRhXivSueldoPeriodo(RhXivSueldoPeriodo, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe el Periodo...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el Periodo";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el Periodo";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente  el Periodo";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar  el Periodo:" + rhXivSueldoPeriodoTO.getXivDescripcion() + ", inténtelo de nuevo...";
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="formulario Utilidades periodo"> 
    @Override
    public String accionRhUtilidadesPeriodo(
            rrhh.TO.RhUtilidadesPeriodoTO rhUtilidadesPeriodoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = rhUtilidadesPeriodoTO.getUsrCodigo() + " " + rhUtilidadesPeriodoTO.getUsrEmpresa();
            if (accion == 'I') {
                susDetalle = "Se insertó Utilidades periodo" + rhUtilidadesPeriodoTO.getUtiDescripcion();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se Modificó Utilidades periodo" + rhUtilidadesPeriodoTO.getUtiDescripcion();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se elimino Utilidades periodo" + rhUtilidadesPeriodoTO.getUtiDescripcion();
                susSuceso = "DELETE";
            }
            susTabla = "recursoshumanos.rh_utilidades_periodo";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO accionRhUtilidadesPeriodo
            rrhh.entity.RhUtilidadesPeriodo rhUtilidadesPeriodo = rrhh.helper.ConversionesRRHH.convertirRhUtilidadesPeriodoTO_RhUtilidadesPeriodo(rhUtilidadesPeriodoTO);
            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesRRHHDAOLocal.comprobarRhUtilidadesPeriodo(
                        rhUtilidadesPeriodoTO.getUtiEmpresa(),
                        rhUtilidadesPeriodoTO.getUtiDescripcion())) {
                } else {
                    mensaje = "FNo se encuentra el Marca Periodo...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesRRHHDAOLocal.comprobarRhUtilidadesPeriodo(
                        rhUtilidadesPeriodoTO.getUsrEmpresa(),
                        rhUtilidadesPeriodoTO.getUtiDescripcion())) {
                    comprobar = operacionesRRHHDAOTransaccionLocal.accionRhUtilidadesPeriodo(rhUtilidadesPeriodo, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el Periodo...";
                }
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesRRHHDAOLocal.comprobarRhUtilidadesPeriodo(
                        rhUtilidadesPeriodoTO.getUsrEmpresa(),
                        rhUtilidadesPeriodoTO.getUtiDescripcion())) {
                    comprobar = operacionesRRHHDAOTransaccionLocal.accionRhUtilidadesPeriodo(rhUtilidadesPeriodo, sisSuceso, accion);
                } else {
                    mensaje = "FYa existe el Marca Periodo...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el Utilidades Periodo";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el Utilidades Periodo";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente  el Utilidades Periodo";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar  el Periodo: " + rhUtilidadesPeriodoTO.getUtiDescripcion() + ", inténtelo de nuevo...";

            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionRhUtilidadesPeriodo",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }
    // </editor-fold>

    public JasperPrint generarReporteListaDetalleVacaionesPagadas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String desde, String hasta,
            String empSector, List<RhDetalleVacionesPagadasGozadasTO> listaDetalleVacacionesPagadasGozadasTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteListaDetalleVacaionesPagadas(
                sisUsuarioEmpresaTO, desde, hasta, empSector, listaDetalleVacacionesPagadasGozadasTO);
        //return generarReporteBancoLocal.generarReporteListadoChequeEmisionVencimientoCobrarNumero(sisUsuarioEmpresaTO, cuenta, desde, hasta, tipo, listBanListaChequeTO);
    }

    public JasperPrint generarReporteConsolidadoAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde,
            String fechaHasta,
            List<RhListaConsolidadoAnticiposPrestamosTO> listaConsolidadoAnticiposPrestamosTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteConsolidadoAnticiposPrestamos(
                sisUsuarioEmpresaTO,
                fechaDesde,
                fechaHasta,
                listaConsolidadoAnticiposPrestamosTO);
    }

    public JasperPrint generarReporteDetalleAnticipos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empId,
            String empCodigo, String empCategoria, String fechaDesde,
            String fechaHasta, List<RhListaDetalleAnticiposTO> listaDetalleAnticiposTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteDetalleAnticipos(
                sisUsuarioEmpresaTO, empId, empCodigo, empCategoria, fechaDesde,
                fechaHasta, listaDetalleAnticiposTO);
    }

    public JasperPrint generarReporteDetalleAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empCodigo,
            String fechaDesde, String fechaHasta, String empCategoria,
            String empId,
            List<RhListaDetalleAnticiposPrestamosTO> listaDetalleAnticiposPrestamosTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteDetalleAnticiposPrestamos(
                sisUsuarioEmpresaTO, empCodigo, fechaDesde, fechaHasta, empCategoria,
                empId, listaDetalleAnticiposPrestamosTO);
    }

    public JasperPrint generarReporteDetallePrestamos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String empCodigo, String fechaDesde, String fechaHasta, String empCategoria,
            String empId, List<RhListaDetallePrestamosTO> listaDetallePrestamosTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteDetallePrestamos(
                sisUsuarioEmpresaTO, empCodigo, fechaDesde, fechaHasta, empCategoria, empId,
                listaDetallePrestamosTO);
    }

    public JasperPrint generarReporteDetalleBonos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria,
            String nombreEmpleado,
            List<RhListaDetalleBonosTO> listaDetalleBonosTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteDetalleBonos(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                empCategoria, nombreEmpleado, listaDetalleBonosTO);
    }

    public JasperPrint generarReporteDetalleBonosLote(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String periodo, String tipo,
            String numero, List<RhListaDetalleBonosLoteTO> listaDetalleBonosLoteTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteDetalleBonosLote(
                sisUsuarioEmpresaTO, periodo, tipo,
                numero, listaDetalleBonosLoteTO);
    }

    public JasperPrint generarReporteDetalleViaticos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaDetalleViaticosTO> listaDetalleViaticosTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteDetalleViaticos(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                empCategoria, nombreEmpleado, listaDetalleViaticosTO);
    }

    public JasperPrint generarReporteConsolidadoBonosViatico(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta,
            List<RhListaConsolidadoBonosViaticosTO> listaConsolidadoBonosViaticosTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteConsolidadoBonosViatico(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                listaConsolidadoBonosViaticosTO);
    }

    public JasperPrint generarReporteListadoRolesPago(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaDetalleRolesTO> listaDetalleRolesTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteListadoRolesPago(
                sisUsuarioEmpresaTO,
                fechaDesde, fechaHasta, empCategoria, nombreEmpleado, listaDetalleRolesTO);
    }

    public JasperPrint generarReporteConsolidadoRoles(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaConsolidadoRolesTO> listaConsolidadoRolesTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteConsolidadoRoles(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                empCategoria, nombreEmpleado, listaConsolidadoRolesTO);
    }

    public JasperPrint generarReporteSaldoIndividualAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String empId,
            List<RhListaSaldoIndividualAnticiposPrestamosTO> listaSaldoIndividualAnticiposPrestamosTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteSaldoIndividualAnticiposPrestamos(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                empId, listaSaldoIndividualAnticiposPrestamosTO);
    }

    public JasperPrint generarReporteSaldoConsolidadoAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoAnticiposPrestamosTO> listaSaldoConsolidadoAnticiposPrestamosTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteSaldoConsolidadoAnticiposPrestamos(
                sisUsuarioEmpresaTO, fechaHasta,
                listaSaldoConsolidadoAnticiposPrestamosTO);
    }

    public JasperPrint generarReporteSaldoConsolidadoBonosViaticos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoBonosViaticosTO> listaSaldoConsolidadoBonosViaticosTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteSaldoConsolidadoBonosViaticos(
                sisUsuarioEmpresaTO, fechaHasta, listaSaldoConsolidadoBonosViaticosTO);
    }

    public JasperPrint generarReporteSaldoConsolidadoSueldosPorPagar(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoSueldosPorPagarTO> listaSaldoConsolidadoSueldosPorPagarTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteSaldoConsolidadoSueldosPorPagar(
                sisUsuarioEmpresaTO, fechaHasta,
                listaSaldoConsolidadoSueldosPorPagarTO);
    }

    public JasperPrint generarReporteXiiiSueldoConsulta(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta,
            String fechaMaxima,
            List<RhFunXiiiSueldoConsultarTO> rhFunXiiiSueldoConsultarTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteXiiiSueldoConsulta(
                sisUsuarioEmpresaTO, sector, periodo, fechaDesde,
                fechaHasta, fechaMaxima, rhFunXiiiSueldoConsultarTO);
    }

    public JasperPrint generarReporteXivSueldoConsulta(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta,
            String fechaMaxima,
            List<RhFunXivSueldoConsultarTO> rhFunXivSueldoConsultarTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteXivSueldoConsulta(
                sisUsuarioEmpresaTO, sector, periodo, fechaDesde,
                fechaHasta, fechaMaxima, rhFunXivSueldoConsultarTO);
    }

    public JasperPrint generarReporteUtilidadesPreCalculo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta,
            String fechaMaxima,
            List<RhFunUtilidadesCalcularTO> rhFunUtilidadesCalcularTOs) throws Exception {
        return generarReporteRrhhLocal.generarReporteUtilidadesPreCalculo(
                sisUsuarioEmpresaTO, sector, periodo, fechaDesde,
                fechaHasta, fechaMaxima, rhFunUtilidadesCalcularTOs);
    }

    public JasperPrint generarReporteProvisionesComprobanteContable(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String periodo, String tipo, String numero,
            List<RhListaProvisionesTO> listaProvisionesTO) throws Exception {
        return generarReporteRrhhLocal.generarReporteProvisionesComprobanteContable(
                sisUsuarioEmpresaTO, periodo, tipo, numero, listaProvisionesTO);
    }

    public JasperPrint generarReporteFormulario107(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaEntrega, String rucEmpleador, String razonSocial, String rucContador,
            RhFormulario107TO rhFormulario107TOGuardar) throws Exception {
        return generarReporteRrhhLocal.generarReporteFormulario107(sisUsuarioEmpresaTO,
                fechaEntrega, rucEmpleador, razonSocial, rucContador, rhFormulario107TOGuardar);
    }

    public JasperPrint generarReporteAnticipo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteAnticipoOprestamo> rhReporteAnticipoOprestamos) throws Exception {
        return generarReporteRrhhLocal.generarReporteAnticipo(
                sisUsuarioEmpresaTO, rhReporteAnticipoOprestamos);
    }

    public JasperPrint generarReporteConsultaAnticiposLote(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteConsultaAnticiposLote> lista) throws Exception {
        return generarReporteRrhhLocal.generarReporteConsultaAnticiposLote(
                sisUsuarioEmpresaTO, lista);
    }

    public JasperPrint generarReportePrestamoVista(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteAnticipoOprestamo> lista) throws Exception {
        return generarReporteRrhhLocal.generarReportePrestamoVista(sisUsuarioEmpresaTO, lista);
    }

    public JasperPrint generarReporteRol(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReportesRol> lista) throws Exception {
        return generarReporteRrhhLocal.generarReporteRol(sisUsuarioEmpresaTO, lista);
    }

    public JasperPrint generarReporteEmpleado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteEmpleado> listReporteEmpleado) throws Exception {
        return generarReporteRrhhLocal.generarReporteEmpleado(sisUsuarioEmpresaTO,
                listReporteEmpleado);
    }

    public JasperPrint generarReporteRol2(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<AuxiliarReporteDetalleRoles> lista) {
        return generarReporteRrhhLocal.generarReporteRol2(sisUsuarioEmpresaTO, lista);
    }
}
