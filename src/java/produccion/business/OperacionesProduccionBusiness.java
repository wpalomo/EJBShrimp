/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import produccion.DAO.OperacionesProduccionDAOLocal;
import produccion.DAO.OperacionesProduccionDAOTransaccionLocal;
import produccion.TO.*;
import produccion.entity.*;
import produccion.helper.ConversionesProduccion;
import produccion.reporte.GenerarReporteProduccionLocal;
import sistema.DAO.OperacionesSistemaDAOLocal;
import sistema.DAO.OperacionesSistemaDAOTransaccionLocal;
import sistema.TO.SisErrorTO;
import sistema.TO.SisUsuarioEmpresaTO;
import sistemaWeb.entity.DAO.SisErrorFacadeLocal;
import validaciones.Validacion;

/**
 *
 * @author misael
 */

@Stateless
public class OperacionesProduccionBusiness implements OperacionesProduccionBusinessLocal {

    private String susTabla;
    private String susClave;
    private String susSuceso;
    private String susDetalle;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    // <editor-fold defaultstate="collapsed" desc="DECLARACIONES EJB">
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @EJB
    OperacionesSistemaDAOTransaccionLocal operacionesDAOTransaccionLocal;
    @EJB
    OperacionesProduccionDAOTransaccionLocal operacionesProduccionDAOTransaccionLocal;
    @EJB
    SisErrorFacadeLocal sisErrorFacadeLocal;
    @EJB
    OperacionesProduccionDAOLocal operacionesProduccionDAOLocal;
    @EJB
    inventario.DAO.OperacionesInventarioDAOLocal operacionesInventarioDAOLocal;
    @EJB
    GenerarReporteProduccionLocal generarReporteProduccionLocal;
    // </editor-fold>
    Boolean comprobar = false;
    public SisErrorTO sisErrorTO = null;

    // <editor-fold defaultstate="collapsed" desc="SECTOR">
    @Override
    public boolean insertarPrdSector(
            PrdSectorTO prdSectorTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            PrdSector prdSector = operacionesProduccionDAOLocal.buscarSector(prdSectorTO.getSecEmpresa(), prdSectorTO.getSecCodigo());
            if (prdSector == null) {
                susClave = prdSectorTO.getSecCodigo();
                susDetalle = "Se insertó al sector " + prdSectorTO.getSecNombre();
                susSuceso = "INSERT";
                susTabla = "produccion.prd_sector";

                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                prdSectorTO.setUsrFechaInsertaSector(Validacion.fechaSistema());
                prdSector = ConversionesProduccion.convertirPrdSectorTO_PrdSector(
                        prdSectorTO);
                comprobar = operacionesProduccionDAOTransaccionLocal.insertarPrdSector(prdSector, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPrdSector",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean modificarPrdSector(
            PrdSectorTO prdSectorTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            prdSectorTO.setUsrFechaInsertaSector(Validacion.fechaSistema());
            comprobar = false;
            PrdSector prdSector = operacionesProduccionDAOLocal.buscarSector(
                    prdSectorTO.getSecEmpresa(), prdSectorTO.getSecCodigo());
            if (prdSector != null) {
                susClave = prdSectorTO.getSecCodigo();
                susDetalle = "Se modificó al sector con codigo " + prdSectorTO.getSecCodigo();
                susSuceso = "UPDATE";
                susTabla = "produccion.prd_sector";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                prdSectorTO.setUsrCodigo(prdSector.getUsrCodigo());
                prdSectorTO.setUsrFechaInsertaSector(Validacion.fecha(prdSector.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                prdSector = ConversionesProduccion.convertirPrdSectorTO_PrdSector(prdSectorTO);
                comprobar = operacionesProduccionDAOTransaccionLocal.modificarPrdSector(prdSector, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarPrdSector",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean eliminarPrdSector(
            PrdSectorTO prdSectorTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            PrdSector prdSector = operacionesProduccionDAOLocal.buscarSector(
                    prdSectorTO.getSecEmpresa(), prdSectorTO.getSecCodigo());
            if (operacionesProduccionDAOLocal.eliminarPrdSector(prdSectorTO) == true) {
                susClave = prdSectorTO.getSecCodigo();
                susDetalle = "Se eliminó al sector " + prdSectorTO.getSecNombre();
                susSuceso = "DELETE";
                susTabla = "produccion.prd_sector";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                prdSectorTO.setUsrFechaInsertaSector(validaciones.Validacion.fechaSistema());
                prdSector = ConversionesProduccion.convertirPrdSectorTO_PrdSector(prdSectorTO);
                comprobar = operacionesProduccionDAOTransaccionLocal.eliminarPrdSector(prdSector, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarPrdSector",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public List<PrdListaSectorTO> getListaSectorTO(String empresa, boolean activo) throws Exception {
        return operacionesProduccionDAOLocal.getListaSector(empresa, activo);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PISCINA">
    @Override
    public boolean insertarPrdPiscina(
            PrdPiscinaTO prdPiscinaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            PrdSector prdSector = operacionesProduccionDAOLocal.buscarSector(
                    prdPiscinaTO.getSecEmpresa(), prdPiscinaTO.getSecCodigo());

            PrdPiscina prdPiscina = operacionesProduccionDAOLocal.buscarPiscina(prdPiscinaTO.getPisEmpresa(),
                    prdPiscinaTO.getPisSector(), prdPiscinaTO.getPisNumero());
            if ((prdPiscina == null) && (prdSector != null)) {
                // CREAR EL SUCESO
                susClave = prdPiscinaTO.getPisNombre();
                susDetalle = "Se insertó a la piscina " + prdPiscinaTO.getPisNombre() + ", del sector con codigo " + prdPiscinaTO.getPisSector();
                susSuceso = "INSERT";
                susTabla = "produccion.prd_piscina";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                prdPiscinaTO.setUsrFechaInsertaPiscina(Validacion.fechaSistema());
                prdPiscina = ConversionesProduccion.convertirPrdPiscinaTO_PrdPiscina(prdPiscinaTO);
                prdPiscina.setPrdSector(prdSector);
                comprobar = operacionesProduccionDAOTransaccionLocal.insertarPrdPiscina(prdPiscina, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPrdPiscina",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean modificarPrdPiscina(
            PrdPiscinaTO prdPiscinaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            prdPiscinaTO.setUsrFechaInsertaPiscina(Validacion.fechaSistema());
            comprobar = false;
            PrdSector prdSector = operacionesProduccionDAOLocal.buscarSector(
                    prdPiscinaTO.getSecEmpresa(), prdPiscinaTO.getSecCodigo());
            PrdPiscina prdPiscina = operacionesProduccionDAOLocal.buscarPiscina(prdPiscinaTO.getPisEmpresa(),
                    prdPiscinaTO.getPisSector(), prdPiscinaTO.getPisNumero());
            if ((prdPiscina != null) && (prdSector != null)) {
                susClave = prdPiscinaTO.getPisNombre();
                susDetalle = "Se modificó a la piscina con codigo " + prdPiscinaTO.getPisNumero() + ", del sector con código " + prdPiscinaTO.getPisSector();
                susSuceso = "UPDATE";
                susTabla = "produccion.prd_piscina";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                prdPiscinaTO.setUsrCodigo(prdPiscina.getUsrCodigo());
                prdPiscinaTO.setUsrFechaInsertaPiscina(Validacion.fecha(prdPiscina.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                prdPiscina = ConversionesProduccion.convertirPrdPiscinaTO_PrdPiscina(prdPiscinaTO);
                prdPiscina.setPrdSector(prdSector);
                comprobar = operacionesProduccionDAOTransaccionLocal.modificarPrdPiscina(prdPiscina, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarPrdPiscina",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean eliminarPrdPiscina(
            PrdPiscinaTO prdPiscinaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            PrdSector prdSector = operacionesProduccionDAOLocal.buscarSector(
                    prdPiscinaTO.getSecEmpresa(), prdPiscinaTO.getSecCodigo());
            PrdPiscina prdPiscina = operacionesProduccionDAOLocal.buscarPiscina(prdPiscinaTO.getPisEmpresa(),
                    prdPiscinaTO.getPisSector(), prdPiscinaTO.getPisNumero());
            if (operacionesProduccionDAOLocal.eliminarPrdPiscina(prdPiscinaTO) == true) {
                susClave = prdPiscinaTO.getPisNumero();
                susDetalle = "Se eliminó a la piscina con codigo " + prdPiscinaTO.getPisNumero() + ", del sector con codigo " + prdPiscinaTO.getPisSector();
                susSuceso = "DELETE";
                susTabla = "produccion.prd_piscina";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                prdPiscinaTO.setUsrFechaInsertaPiscina(validaciones.Validacion.fechaSistema());
                prdPiscina = ConversionesProduccion.convertirPrdPiscinaTO_PrdPiscina(
                        prdPiscinaTO);
                prdPiscina.setPrdSector(prdSector);
                comprobar = operacionesProduccionDAOTransaccionLocal.eliminarPrdPiscina(prdPiscina, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarPrdPiscina",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public List<PrdListaPiscinaTO> getListaPiscinaTO(
            String empresa,
            String sector) throws Exception {
        return operacionesProduccionDAOLocal.getListaPiscina(empresa, sector);
    }

    @Override
    public List<PrdListaPiscinaComboTO> getListaPiscinaTO(
            String empresa,
            boolean activo) throws Exception {
        return operacionesProduccionDAOLocal.getListaPiscina(empresa, activo);
    }

    @Override
    public List<PrdListaPiscinaTO> getListaPiscinaTOBusqueda(
            String empresa,
            String sector,
            String fecha) throws Exception {
        return operacionesProduccionDAOLocal.getListaPiscinaBusqueda(empresa, sector, fecha);
    }

    @Override
    public List<PrdComboPiscinaTO> getComboPiscinaTO(
            String empresa,
            String sector) throws Exception {
        return operacionesProduccionDAOLocal.getComboPiscina(empresa, sector);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CORRIDA">
    @Override
    public String accionPrdCorrida(
            PrdCorridaTO prdCorridaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        String mensaje = "";
        PrdCorrida prdCorrida = null;
        try {
            ///// BUSCANDO existencia piscina
            PrdPiscina prdPiscina = operacionesProduccionDAOLocal.buscarPiscina(
                    prdCorridaTO.getPisEmpresa(),
                    prdCorridaTO.getPisSector(),
                    prdCorridaTO.getPisNumero());
            if (prdPiscina != null) {//revisar si estan llenos
                ///// CREANDO Suceso
                susClave = prdCorridaTO.getCorSector() + " " + prdCorridaTO.getCorPiscina() + " " + prdCorridaTO.getCorNumero();
                if (accion == 'I') {
                    susDetalle = "Se insertó corrida Nº " + prdCorridaTO.getCorNumero()
                            + ", de la piscina con codigo " + prdCorridaTO.getCorPiscina()
                            + ", del sector con codigo " + prdCorridaTO.getCorSector();
                    susSuceso = "INSERT";
                }
                if (accion == 'M') {
                    susDetalle = "Se Modifico corrida Nº " + prdCorridaTO.getCorNumero()
                            + ", de la piscina con codigo " + prdCorridaTO.getCorPiscina()
                            + ", del sector con codigo " + prdCorridaTO.getCorSector();
                    susSuceso = "UPDATE";
                }
                if (accion == 'E') {
                    susDetalle = "Se Elimino corrida Nº " + prdCorridaTO.getCorNumero()
                            + ", de la piscina con codigo " + prdCorridaTO.getCorPiscina()
                            + ", del sector con codigo " + prdCorridaTO.getCorSector();
                    susSuceso = "DELETE";
                }
                susTabla = "produccion.prd_corrida";
                ///// CREANDO CarPagosForma
                prdCorrida = ConversionesProduccion.convertirPrdCorridaTO_PrdCorrida(prdCorridaTO);
                prdCorrida.setPrdPiscina(prdPiscina);

                if (accion == 'E') {
                    ////// BUSCANDO existencia Corrida
                    if (operacionesProduccionDAOLocal.buscarCorrida(
                            prdCorridaTO.getCorEmpresa(),
                            prdCorridaTO.getCorSector(),
                            prdCorridaTO.getCorPiscina(),
                            prdCorridaTO.getCorNumero()) != null) {
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        prdCorrida.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesProduccionDAOTransaccionLocal.accionPrdCorrida(prdCorrida, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la Corrida...";
                    }
                }
                if (accion == 'M') {
                    ////// BUSCANDO existencia Corrida
                    if (operacionesProduccionDAOLocal.buscarCorrida(
                            prdCorridaTO.getCorEmpresa(),
                            prdCorridaTO.getCorSector(),
                            prdCorridaTO.getCorPiscina(),
                            prdCorridaTO.getCorNumero()) != null) {
                        prdCorrida.setUsrFechaInserta(
                                operacionesProduccionDAOLocal.buscarCorrida(
                                prdCorridaTO.getCorEmpresa(),
                                prdCorridaTO.getCorSector(),
                                prdCorridaTO.getCorPiscina(),
                                prdCorridaTO.getCorNumero()).getUsrFechaInserta());
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        comprobar = operacionesProduccionDAOTransaccionLocal.accionPrdCorrida(prdCorrida, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra Corrida...";
                    }
                }
                if (accion == 'I') {
                    ////// BUSCANDO existencia Corrida
                    if (operacionesProduccionDAOLocal.buscarCorrida(
                            prdCorridaTO.getCorEmpresa(),
                            prdCorridaTO.getCorSector(),
                            prdCorridaTO.getCorPiscina(),
                            prdCorridaTO.getCorNumero()) == null) {
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        prdCorrida.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesProduccionDAOTransaccionLocal.accionPrdCorrida(prdCorrida, sisSuceso, accion);
                    } else {
                        mensaje = "FYa existe la Corrida...";
                    }
                }
            } else {
                if (prdPiscina != null) {
                    mensaje = "FNo se encuentra la piscina...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente la Corrida";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente la Corrida";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente la Corrida";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la Corrida, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionPrdCorrida",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public List<PrdListaCorridaTO> getListaCorridaTO(
            String empresa,
            String sector,
            String piscina) throws Exception {
        return operacionesProduccionDAOLocal.getListaCorrida(empresa, sector, piscina);
    }

    @Override
    public List<PrdListaCorridaTO> getListaCorridaTO(
            String empresa,
            String sector,
            String piscina,
            String corrida) throws Exception {
        return operacionesProduccionDAOLocal.getListaCorrida(empresa, sector, piscina, corrida);
    }

    @Override
    public PrdFunAnalisisVentasTO getPrdFunAnalisisVentasTO(
            String empresa,
            String sector,
            String piscina,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesProduccionDAOLocal.getPrdFunAnalisisVentasTO(empresa, sector, piscina, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<produccion.TO.PrdListaCostosDetalleCorridaTO> getPrdListaCostosDetalleCorridaTO(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String piscina,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String agrupadoPor) throws java.lang.Exception {
        return operacionesProduccionDAOLocal.getPrdListaCostosDetalleCorridaTO(empresa, sector, piscina, desde, hasta, agrupadoPor);
    }

    @Override
    public List<PrdComboCorridaTO> getComboPrdCorridaTO(
            String empresa,
            String sector,
            String piscina) throws Exception {
        return operacionesProduccionDAOLocal.getComboPrdCorrida(empresa, sector, piscina);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VEHICULOS">
    @Override
    public String accionPrdVehiculos(
            PrdVehiculosTO prdVehiculosTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        String mensaje = "";
        PrdVehiculos prdVehiculos = null;
        try {
            ///// BUSCANDO existencia piscina
            PrdSector prdSector = operacionesProduccionDAOLocal.buscarSector(
                    sisInfoTO.getInfEmpresa(),
                    prdVehiculosTO.getVehCentroProduccion());
            if (prdSector != null) {//revisar si estan llenos
                ///// CREANDO Suceso
                susClave = prdVehiculosTO.getVehPlaca();
                if (accion == 'I') {
                    susDetalle = "Se insertó Vehiculo Nº " + prdVehiculosTO.getVehPlaca();
                    susSuceso = "INSERT";
                }
                if (accion == 'M') {
                    susDetalle = "Se Modifico Vehiculo Nº " + prdVehiculosTO.getVehPlaca();
                    susSuceso = "UPDATE";
                }
                if (accion == 'E') {
                    susDetalle = "Se Elimino Vehiculo Nº " + prdVehiculosTO.getVehPlaca();
                    susSuceso = "DELETE";
                }
                susTabla = "produccion.prd_vehiculos";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                ///// CREANDO PrdPiscina
                PrdPiscina prdPiscina = new PrdPiscina();
                prdPiscina.setPrdPiscinaPK(new PrdPiscinaPK(
                        sisInfoTO.getInfEmpresa(),
                        prdVehiculosTO.getVehCentroProduccion(),
                        prdVehiculosTO.getVehPlaca()));
                prdPiscina.setPrdSector(prdSector);
                prdPiscina.setUsrEmpresa(sisInfoTO.getInfEmpresa());
                prdPiscina.setUsrCodigo(sisInfoTO.getInfUsuario());
                prdPiscina.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                ///// CREANDO PrdVehiculos
                prdVehiculos = ConversionesProduccion.convertirPrdVehiculosTO_PrdVehiculos(prdVehiculosTO);

                prdVehiculos.setPrdPiscina(prdPiscina);

                if (accion == 'E') {
                    ////// BUSCANDO existencia Vehiculos
                    if (operacionesProduccionDAOLocal.buscarVehiculos(
                            sisInfoTO.getInfEmpresa(),
                            prdVehiculosTO.getVehEstablecimiento(),
                            prdVehiculosTO.getVehPlaca()) != null) {
                        comprobar = operacionesProduccionDAOTransaccionLocal.accionPrdVehiculos(prdVehiculos, prdPiscina, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la Vehiculos...";
                    }
                }
                if (accion == 'M') {
                    ////// BUSCANDO existencia Vehiculos
                    if (operacionesProduccionDAOLocal.buscarVehiculos(
                            sisInfoTO.getInfEmpresa(),
                            prdVehiculosTO.getVehCentroProduccion(),
                            prdVehiculosTO.getVehPlaca()) != null) {
                        comprobar = operacionesProduccionDAOTransaccionLocal.accionPrdVehiculos(prdVehiculos, prdPiscina, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra Vehiculos...";
                    }
                }
                if (accion == 'I') {
                    ////// BUSCANDO existencia Vehiculos
                    if (operacionesProduccionDAOLocal.buscarVehiculos(
                            sisInfoTO.getInfEmpresa(),
                            prdVehiculosTO.getVehCentroProduccion(),
                            prdVehiculosTO.getVehPlaca()) == null) {
                        comprobar = operacionesProduccionDAOTransaccionLocal.accionPrdVehiculos(prdVehiculos, prdPiscina, sisSuceso, accion);
                    } else {
                        mensaje = "FYa existe la Vehiculos...";
                    }
                }
            } else {
                if (prdSector != null) {
                    mensaje = "FNo se encuentra el sector...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el Vehículo";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el Vehículo";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente el Vehículo";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la Vehiculos, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionPrdVehiculos",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

//    @Override
//    public List<PrdListaVehiculosTO> getListaVehiculosTO(
//            String empresa, 
//            String sector, 
//            String piscina) throws Exception {
//        return operacionesProduccionDAOLocal.getListaVehiculos(empresa, sector, piscina);
//    }
//
//    @Override
//    public java.util.List<produccion.TO.PrdListaCostosDetalleVehiculosTO> getPrdListaCostosDetalleVehiculosTO(
//            java.lang.String empresa, 
//            java.lang.String sector, 
//            java.lang.String piscina, 
//            java.lang.String desde, 
//            java.lang.String hasta, 
//            java.lang.String agrupadoPor) throws java.lang.Exception {
//        return operacionesProduccionDAOLocal.getPrdListaCostosDetalleVehiculosTO(empresa, sector, piscina, desde, hasta, agrupadoPor);
//    }
//    @Override
//    public List<PrdComboVehiculosTO> getComboPrdVehiculosTO(
//            String empresa, 
//            String sector, 
//            String piscina) throws Exception {
//        return operacionesProduccionDAOLocal.getComboPrdVehiculos(empresa, sector, piscina);
//    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="LISTA RESUMEN CORRIDA">
    @Override
    public List<PrdResumenCorridaTO> getListaResumenCorridaTO(
            String empresa,
            String sector,
            String desde,
            String hasta,
            String tipoResumen) throws Exception {
        return operacionesProduccionDAOLocal.getListaResumenCorridaTO(empresa, sector, desde, hasta, tipoResumen);
    }

    @Override
    public String consultarFechaMaxMin(
            String empresa,
            String tipoResumen) throws Exception {
        return operacionesProduccionDAOLocal.consultarFechaMaxMin(empresa, tipoResumen);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SOBREVIVENCIA">
    @Override
    public boolean insertarPrdSobrevivencia(
            PrdSobrevivenciaTO prdSobrevivenciaTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            PrdSector prdSector = operacionesProduccionDAOLocal.buscarSector(
                    prdSobrevivenciaTO.getSecEmpresa(),
                    prdSobrevivenciaTO.getSecCodigo());
            if (prdSector != null) {
                susClave = prdSobrevivenciaTO.getSecCodigo();
                susDetalle = "Se insertó la Sobrevivencia " + prdSobrevivenciaTO.getSobCodigo();
                susSuceso = "INSERT";
                susTabla = "produccion.prd_Sobrevivencia";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                prdSobrevivenciaTO.setUsrFechaInsertaSobrevivencia(Validacion.fechaSistema());
                PrdSobrevivencia prdSobrevivencia = ConversionesProduccion.convertirPrdSobrevivenciaTO_PrdSobrevivencia(prdSobrevivenciaTO);
                prdSobrevivencia.setPrdSector(prdSector);
                comprobar = operacionesProduccionDAOTransaccionLocal.insertarPrdSobrevivencia(prdSobrevivencia, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPrdSobrevivencia",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean modificarPrdSobrevivencia(
            PrdSobrevivenciaTO prdSobrevivenciaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            PrdSector prdSector = operacionesProduccionDAOLocal.buscarSector(
                    prdSobrevivenciaTO.getSecEmpresa(),
                    prdSobrevivenciaTO.getSecCodigo());
            PrdSobrevivencia prdSobrevivencia = operacionesProduccionDAOLocal.buscarSobrevivencia(
                    prdSobrevivenciaTO.getSobCodigo());
            if ((prdSobrevivencia != null) && (prdSector != null)) {
                susClave = prdSobrevivenciaTO.getSecCodigo();
                susDetalle = "Se modificó la Sobrevivencia " + prdSobrevivenciaTO.getSobCodigo();
                susSuceso = "UPDATE";
                susTabla = "produccion.prd_Sobrevivencia";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                prdSobrevivenciaTO.setUsrCodigo(prdSobrevivencia.getUsrCodigo());
                prdSobrevivenciaTO.setUsrFechaInsertaSobrevivencia(Validacion.fecha(prdSobrevivencia.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
//                prdSobrevivenciaTO.setUsrFechaInsertaSobrevivencia(Validacion.fechaSistema());
                prdSobrevivencia = ConversionesProduccion.convertirPrdSobrevivenciaTO_PrdSobrevivencia(prdSobrevivenciaTO);
                prdSobrevivencia.setPrdSector(prdSector);
                comprobar = operacionesProduccionDAOTransaccionLocal.modificarPrdSobrevivencia(prdSobrevivencia, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarPrdSobrevivencia",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean eliminarPrdSobrevivencia(
            PrdSobrevivenciaTO prdSobrevivenciaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            PrdSector prdSector = operacionesProduccionDAOLocal.buscarSector(
                    prdSobrevivenciaTO.getSecEmpresa(),
                    prdSobrevivenciaTO.getSecCodigo());
            /// CREAR SUCESO
            susDetalle = "Se eliminó la Sobrevivencia " + prdSobrevivenciaTO.getSobCodigo();
            susClave = prdSobrevivenciaTO.getSobCodigo().toString();
            susSuceso = "DELETE";
            susTabla = "produccion.prd_Sobrevivencia";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            prdSobrevivenciaTO.setUsrFechaInsertaSobrevivencia(validaciones.Validacion.fechaSistema());
            PrdSobrevivencia prdSobrevivencia = ConversionesProduccion.convertirPrdSobrevivenciaTO_PrdSobrevivencia(prdSobrevivenciaTO);
            prdSobrevivencia.setPrdSector(prdSector);
            comprobar = operacionesProduccionDAOTransaccionLocal.eliminarPrdSobrevivencia(prdSobrevivencia, sisSuceso);
//            em.flush();
//            tx.commit();
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarPrdSobrevivencia",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public List<PrdListaSobrevivenciaTO> getListaSobrevivenciaTO(String empresa, String sector) throws Exception {
        return operacionesProduccionDAOLocal.getListaSobrevivencia(empresa, sector);
    }
    // </editor-fold>

    @Override
    public List<produccion.TO.PrdListadoGrameajeTO> getPrdListadoGrameajeTO(
            String empresa,
            String sector,
            String piscina,
            String desde,
            String hasta) throws Exception {
        return operacionesProduccionDAOLocal.getPrdListadoGrameajeTO(empresa, sector, piscina, desde, hasta);
    }

    @Override
    public boolean getIsFechaGrameajeSuperior(
            String empresa,
            String sector,
            String numPiscina,
            String fecha) throws Exception {
        return operacionesProduccionDAOLocal.getIsFechaGrameajeSuperior(empresa, sector, numPiscina, fecha);
    }

    @Override
    public boolean insertarPrdGrameaje(
            PrdGrameajeTO prdGrameajeTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        PrdPiscina prdPiscina = null;
        try {
            comprobar = false;
            prdPiscina = operacionesProduccionDAOLocal.buscarPiscina(prdGrameajeTO.getPisEmpresa(),
                    prdGrameajeTO.getPisSector(), prdGrameajeTO.getPisNumero());
            susDetalle = "Se insertó grameaje de fecha " + prdGrameajeTO.getGraFecha()
                    + ", de la piscina con codigo " + prdGrameajeTO.getGraPiscina() + ", del sector con codigo " + prdGrameajeTO.getGraSector();
            susSuceso = "INSERT";
            susTabla = "produccion.prd_grameaje";
            susClave = prdGrameajeTO.getGraSector() + " " + prdGrameajeTO.getGraPiscina() + " " + prdGrameajeTO.getGraFecha();
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            prdGrameajeTO.setUsrFechaInsertaGrameaje(Validacion.fechaSistema());
            PrdGrameaje prdGrameaje = ConversionesProduccion.convertirPrdGrameajeTO_PrdGrameaje(prdGrameajeTO);
            prdGrameaje.setPrdPiscina(prdPiscina);
            comprobar = operacionesProduccionDAOTransaccionLocal.insertarPrdGrameaje(prdGrameaje, sisSuceso);
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPrdGrameaje",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public String eliminarPrdGrameaje(
            produccion.TO.PrdGrameajeTO prdGrameajeTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        String mensaje = "";
        produccion.entity.PrdGrameaje prdGrameaje = null;
        try {
            ///// BUSCANDO existencia piscina
            PrdPiscina prdPiscina = operacionesProduccionDAOLocal.buscarPiscina(
                    prdGrameajeTO.getGraEmpresa(),
                    prdGrameajeTO.getGraSector(),
                    prdGrameajeTO.getGraPiscina());
            if (prdPiscina != null) {//revisar si estan llenos
                ///// CREANDO Suceso
                susClave = prdGrameajeTO.getGraSector() + "|"
                        + prdGrameajeTO.getGraPiscina() + "|"
                        + prdGrameajeTO.getGraFecha();
                susDetalle = "Se eliminó grameaje del sector " + prdGrameajeTO.getGraSector()
                        + ", de la piscina " + prdGrameajeTO.getGraPiscina()
                        + ", con fecha " + prdGrameajeTO.getGraFecha();
                susSuceso = "DELETE";
                susTabla = "produccion.prd_grameaje";
                ///// CREANDO PrdGrameaje
                prdGrameaje = ConversionesProduccion.convertirPrdGrameaje_PrdGrameaje(operacionesProduccionDAOLocal.buscarGrameaje(
                        prdGrameajeTO.getGraEmpresa(),
                        prdGrameajeTO.getGraSector(),
                        prdGrameajeTO.getGraPiscina(),
                        validaciones.Validacion.fecha(prdGrameajeTO.getGraFecha(), "dd-MM-yyyy", "yyyy-MM-dd")));
                ////// BUSCANDO existencia PrdGrameaje
                if (prdGrameaje != null) {
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    prdGrameaje.setPrdPiscina(prdPiscina);
                    comprobar = operacionesProduccionDAOTransaccionLocal.eliminarPrdGrameaje(prdGrameaje, sisSuceso);
                } else {
                    mensaje = "FNo se encuentra el grameaje "
                            + "\ndel sector " + prdGrameajeTO.getGraSector()
                            + ", \nde la piscina " + prdGrameajeTO.getGraPiscina()
                            + ", \ncon fecha " + prdGrameajeTO.getGraFecha();
                }
            } else {
                if (prdPiscina != null) {
                    mensaje = "FNo se encuentra la piscina...";
                }
            }
            if (comprobar) {
                mensaje = "TSe eliminó correctamente el grameaje "
                        + "\ndel sector " + prdGrameajeTO.getGraSector()
                        + ", \nde la piscina " + prdGrameajeTO.getGraPiscina()
                        + ", \ncon fecha " + prdGrameajeTO.getGraFecha();
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la Grameaje, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarPrdGrameaje",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public List<produccion.TO.PrdCostoDetalleFechaTO> getPrdListadoCostoDetalleFechaTO(
            String empresa,
            java.lang.String secCodigo,
            String desde,
            String hasta,
            java.lang.String agrupadoPor) throws Exception {
        return operacionesProduccionDAOLocal.getPrdListadoCostoDetalleFechaTO(empresa, secCodigo, desde, hasta, agrupadoPor);
    }

    @Override
    public boolean insertarPrdLiquidacionLotesValorizada(LiquidacionLotesValorizadaTO liquidacionLotesValorizadaTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        PrdPiscina prdPiscina = null;
        PrdSector prdSector = null;
        try {
            comprobar = false;
            prdSector = operacionesProduccionDAOLocal.buscarSector(liquidacionLotesValorizadaTO.getSecEmpresa(), liquidacionLotesValorizadaTO.getSecCodigo());

            prdPiscina = operacionesProduccionDAOLocal.buscarPiscina(liquidacionLotesValorizadaTO.getPisEmpresa(),
                    liquidacionLotesValorizadaTO.getPisSector(), liquidacionLotesValorizadaTO.getPisNumero());
            susClave = liquidacionLotesValorizadaTO.getLiqCliente() + " " + liquidacionLotesValorizadaTO.getLiqNumero();
            susDetalle = "Se insertó la liquidación de lotes valorizada con código " + liquidacionLotesValorizadaTO.getLiqCliente()
                    + " | " + liquidacionLotesValorizadaTO.getLiqNumero() + " de la piscina " + liquidacionLotesValorizadaTO.getPisNumero()
                    + " del sector " + liquidacionLotesValorizadaTO.getSecCodigo();
            susSuceso = "INSERT";
            susTabla = "produccion.prd_liquidacion";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            liquidacionLotesValorizadaTO.setUsrFechaInserta(Validacion.fechaSistema());
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPrdLiquidacionLotesValorizada",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public helper.RetornoTO modificarBooleanoCorrida(
            String empresa,
            java.util.List<produccion.TO.MultiplePiscinaCorrida> multiplePiscinaCorrida,
            String usuario,
            String hasta,
            String proceso,
            java.lang.String agrupadoPor,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {

        java.util.List<PrdCorrida> prdCorridaGuardar = new java.util.ArrayList();
        java.util.List<PrdCorrida> prdCorridas = null;
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        comprobar = false;
        String mensaje = "";
        try {
            prdCorridas = operacionesProduccionDAOLocal.buscarTodasCorrida(empresa);
            for (int i = 0; i < prdCorridas.size(); i++) {
                prdCorridas.get(i).setCorActiva(false);
            }
            operacionesProduccionDAOTransaccionLocal.modificarCorrida(prdCorridas);
//            operacionesProduccionDAOLocal.ponerCorridaFalse(empresa);
            prdCorridas = operacionesProduccionDAOLocal.buscarTodasCorrida(empresa);
            for (int i = 0; i < prdCorridas.size(); i++) {
                for (int j = 0; j < multiplePiscinaCorrida.size(); j++) {
                    if (prdCorridas.get(i).getPrdCorridaPK().getCorEmpresa().
                            concat(prdCorridas.get(i).getPrdCorridaPK().getCorSector()).
                            concat(prdCorridas.get(i).getPrdCorridaPK().getCorPiscina()).
                            concat(prdCorridas.get(i).getPrdCorridaPK().getCorNumero()).equals(
                            empresa.concat(multiplePiscinaCorrida.get(j).getSector()).
                            concat(multiplePiscinaCorrida.get(j).getPiscina()).
                            concat(multiplePiscinaCorrida.get(j).getCorrida()))) {
                        prdCorridas.get(i).setCorActiva(true);
                        prdCorridaGuardar.add(prdCorridas.get(i));
                    }
                }
            }
            comprobar = operacionesProduccionDAOTransaccionLocal.modificarBooleanoCorrida(prdCorridaGuardar);
            if (comprobar) {
                mensaje = "TModificado...";
                retornoTO.setMensaje(mensaje);
                if (proceso.equals("COSTO")) {
                    java.util.List<produccion.TO.CostoDetalleMultipleCorridaTO> costoDetalleMultipleCorridaTOs = operacionesProduccionDAOLocal.getCostoDetalleMultipleCorridaTO(empresa, hasta, agrupadoPor);
                    produccion.helper.NumeroColumnaDesconocidadPiscinaCorrida obj = new produccion.helper.NumeroColumnaDesconocidadPiscinaCorrida();
                    obj.agruparCabeceraColumnas(costoDetalleMultipleCorridaTOs);
                    obj.agruparProductos(costoDetalleMultipleCorridaTOs);
                    obj.llenarObjetoParaTabla(costoDetalleMultipleCorridaTOs);
                    retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
                    retornoTO.setColumnas(obj.getColumnas());
                    retornoTO.setDatos(obj.getDatos());
                } else {
                    if (proceso.equals("PRODUCTO")) {
                        java.util.List<produccion.TO.PrdConsumoProductoEnProcesoTO> prdConsumoProductoEnProcesoTOs = operacionesProduccionDAOLocal.getConsumoProductosProceso(empresa, hasta);
                        produccion.helper.NumeroColumnaDesconocidadConsumoProductoEnProceso obj = new produccion.helper.NumeroColumnaDesconocidadConsumoProductoEnProceso();
                        obj.agruparCabeceraColumnas(prdConsumoProductoEnProcesoTOs);
                        obj.agruparProductos(prdConsumoProductoEnProcesoTOs);
                        obj.llenarObjetoParaTabla(prdConsumoProductoEnProcesoTOs);
                        retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
                        retornoTO.setColumnas(obj.getColumnas());
                        retornoTO.setDatos(obj.getDatos());
                    } else {
                        java.util.List<produccion.TO.PrdConsumoMultiplePiscinaTO> prdConsumoMultiplePiscinaTOs = operacionesProduccionDAOLocal.getConsumoMultiplePiscina(empresa);
                        produccion.helper.NumeroColumnaDesconocidadConsumoMultiplePiscina obj = new produccion.helper.NumeroColumnaDesconocidadConsumoMultiplePiscina();
                        obj.agruparCabeceraColumnas(prdConsumoMultiplePiscinaTOs);
                        obj.agruparProductos(prdConsumoMultiplePiscinaTOs);
                        obj.llenarObjetoParaTabla(prdConsumoMultiplePiscinaTOs);
                        retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
                        retornoTO.setColumnas(obj.getColumnas());
                        retornoTO.setDatos(obj.getDatos());
                    }
                }
            } else {
                mensaje = "FOcurrió un error al obtener la información...";
                retornoTO.setMensaje(mensaje);
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al obtener la información...";
            retornoTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarBooleanoCorrida",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            retornoTO.setMensaje(mensaje);
            return retornoTO;
        }
    }

    @Override
    public produccion.TO.PrdCorridaTO getPrdCorridaTO(String empresa, String sector, String piscina, String fecha) throws Exception {
        return operacionesProduccionDAOLocal.getPrdCorridaTO(empresa, sector, piscina, fecha);
    }

    @Override
    public produccion.TO.PrdGrameajeTO getPrdGrameajeTO(String empresa, String sector, String piscina, String fecha) throws Exception {
        return operacionesProduccionDAOLocal.getPrdGrameajeTO(empresa, sector, piscina, fecha);
    }

    @Override
    public produccion.TO.PrdGrameajeTO getPrdGrameajeTO(String empresa, String sector, String piscina, String desde, String hasta) throws Exception {
        return operacionesProduccionDAOLocal.getPrdGrameajeTO(empresa, sector, piscina, desde, hasta);
    }

    @Override
    public java.util.List<produccion.TO.MultiplePiscinaCorrida> getCostoDetallePersonalizado(String empresa, String sector, String fecha) {
        return operacionesProduccionDAOLocal.getCostoDetallePersonalizado(empresa, sector, fecha);
    }

    @Override
    public helper.RetornoTO getCostoPorFechaProrrateado(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            java.lang.String agrupadoPor,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {
            java.util.List<produccion.TO.PrdCostoPorFechaProrrateadoTO> prdCostoPorFechaProrrateadoTOs = operacionesProduccionDAOLocal.getCostoPorFechaProrrateado(empresa, codigoSector, fechaInicio, fechaFin, agrupadoPor);
            mensaje = "T";
            produccion.helper.NumeroColumnaDesconocidadCostoPorFechaProrrateado obj = new produccion.helper.NumeroColumnaDesconocidadCostoPorFechaProrrateado();
            obj.agruparCabeceraColumnas(prdCostoPorFechaProrrateadoTOs);
            obj.agruparProductos(prdCostoPorFechaProrrateadoTOs);
            obj.llenarObjetoParaTabla(prdCostoPorFechaProrrateadoTOs);
            retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
            retornoTO.setColumnas(obj.getColumnas());
            retornoTO.setDatos(obj.getDatos());
        } catch (Exception e) {
            comprobar = false;
            mensaje = "FOcurrió un error al obtener los datos de la Base de Datos. \nContacte con el administrador...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getCostoPorFechaProrrateado",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            retornoTO.setMensaje(mensaje);
            return retornoTO;
        }

    }

    @Override
    public java.util.List<produccion.TO.PrdFunCostosPorFechaSimpleTO> getPrdFunCostosPorFechaSimpleTO(
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        java.util.List<produccion.TO.PrdFunCostosPorFechaSimpleTO> prdFunCostosPorFechaSimpleTOs = null;
        try {
            prdFunCostosPorFechaSimpleTOs = operacionesProduccionDAOLocal.getPrdFunCostosPorFechaSimpleTO(codigoSector, fechaInicio, fechaFin, sisInfoTO);
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getPrdFunCostosPorFechaSimpleTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        }
        return prdFunCostosPorFechaSimpleTOs;
    }

    @Override
    public helper.RetornoTO getCostoPorPiscinaSemanal(
            String empresa,
            String codigoSector,
            String numeroPiscina,
            String fechaInicio,
            String fechaFin,
            String usuario,
            java.lang.String agrupadoPor,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {

            java.util.List<produccion.TO.PrdCostoPorPiscinaSemanalTO> prdCostoPorPiscinaSemanalTOs = operacionesProduccionDAOLocal.getCostoPorPorPiscinaSemanal(empresa, codigoSector, numeroPiscina, fechaInicio, fechaFin, agrupadoPor);

            mensaje = "T";
            produccion.helper.NumeroColumnaDesconocidadCostoPorPiscinalSemanal obj = new produccion.helper.NumeroColumnaDesconocidadCostoPorPiscinalSemanal();

            obj.agruparCabeceraColumnas(prdCostoPorPiscinaSemanalTOs);
            obj.agruparProductos(prdCostoPorPiscinaSemanalTOs);
            obj.llenarObjetoParaTabla(prdCostoPorPiscinaSemanalTOs);
            retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
            retornoTO.setColumnas(obj.getColumnas());
            retornoTO.setDatos(obj.getDatos());
        } catch (Exception e) {
            comprobar = false;
            mensaje = "FOcurrió un error al obtener los datos de la Base de Datos. \nContacte con el administrador...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getCostoPorPiscinaSemanal",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            retornoTO.setMensaje(mensaje);
            return retornoTO;
        }
    }

    @Override
    public helper.RetornoTO getConsumoPorFechaDesglosado(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {
            java.util.List<produccion.TO.PrdConsumoPorFechaDesglosadoTO> prdConsumoPorFechaDesglosadoTOs = operacionesProduccionDAOLocal.getConsumoPorFechaDesglosado(empresa, codigoSector, fechaInicio, fechaFin);
            mensaje = "T";
            produccion.helper.NumeroColumnaDesconocidadConsumoPorFechaDesglosado obj = new produccion.helper.NumeroColumnaDesconocidadConsumoPorFechaDesglosado();
            obj.agruparCabeceraColumnas(prdConsumoPorFechaDesglosadoTOs);
            obj.agruparProductos(prdConsumoPorFechaDesglosadoTOs);
            obj.llenarObjetoParaTabla(prdConsumoPorFechaDesglosadoTOs);
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

    @Override
    public helper.RetornoTO getConsumoProductosProceso(
            String empresa,
            String fecha,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {
            java.util.List<produccion.TO.PrdConsumoProductoEnProcesoTO> prdConsumoProductoEnProcesoTOs = operacionesProduccionDAOLocal.getConsumoProductosProceso(empresa, fecha);
            mensaje = "T";
            produccion.helper.NumeroColumnaDesconocidadConsumoProductoEnProceso obj = new produccion.helper.NumeroColumnaDesconocidadConsumoProductoEnProceso();
            obj.agruparCabeceraColumnas(prdConsumoProductoEnProcesoTOs);
            obj.agruparProductos(prdConsumoProductoEnProcesoTOs);
            obj.llenarObjetoParaTabla(prdConsumoProductoEnProcesoTOs);
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

    @Override
    public java.util.List<produccion.TO.PrdConsumosTO> getPrdConsumosFechaTO(
            String empresa,
            String sector,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesProduccionDAOLocal.getPrdConsumosFechaTO(empresa, sector, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<produccion.TO.PrdConsumosTO> getPrdConsumosPiscinaTO(
            String empresa,
            String sector,
            java.lang.String piscina,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesProduccionDAOLocal.getPrdConsumosPiscinaTO(empresa, sector, piscina, fechaDesde, fechaHasta);
    }

    @Override
    public helper.RetornoTO getConsumoPorPiscinaPeriodo(
            String empresa,
            String codigoSector,
            String numeroPiscina,
            String fechaInicio,
            String fechaFin,
            String periodo,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {
            java.util.List<produccion.TO.PrdConsumosPorPiscinaPeriodoTO> prdConsumosPorPiscinaPeriodoTOs = operacionesProduccionDAOLocal.getConsumoPorPiscinaPeriodo(empresa, codigoSector, numeroPiscina, fechaInicio, fechaFin, periodo);
            mensaje = "T";
            produccion.helper.NumeroColumnaDesconocidadConsumoPorPiscinaPeriodo obj = new produccion.helper.NumeroColumnaDesconocidadConsumoPorPiscinaPeriodo();
            obj.agruparCabeceraColumnas(prdConsumosPorPiscinaPeriodoTOs);
            obj.agruparProductos(prdConsumosPorPiscinaPeriodoTOs);
            obj.llenarObjetoParaTabla(prdConsumosPorPiscinaPeriodoTOs);
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

    @Override
    public List<PrdListaSectorConHectareajeTO> getListaSectorConHectareaje(
            String empresa,
            String fecha) throws Exception {
        return operacionesProduccionDAOLocal.getListaSectorConHectareaje(empresa, fecha);
    }

    @Override
    public List<produccion.TO.PrdResumenFinancieroTO> getPrdResumenFinancieroTO(
            String empresa,
            java.lang.String secCodigo,
            String desde,
            String hasta) throws Exception {
        return operacionesProduccionDAOLocal.getPrdResumenFinancieroTO(empresa, secCodigo, desde, hasta);
    }

    @Override
    public helper.RetornoTO getResumenPesca(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {
            java.util.List<produccion.TO.PrdResumenPescaTO> prdResumenPescaTOs = operacionesProduccionDAOLocal.getResumenPesca(empresa, codigoSector, fechaInicio, fechaFin);
            mensaje = "T";
            produccion.helper.NumeroColumnaDesconocidadResumenPesca obj = new produccion.helper.NumeroColumnaDesconocidadResumenPesca();
            obj.agruparCabeceraColumnas(prdResumenPescaTOs);
            obj.agruparResumenPesca(prdResumenPescaTOs);
            obj.llenarObjetoParaTabla(prdResumenPescaTOs);
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

    @Override
    public helper.RetornoTO getResumenSiembra(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {

            java.util.List<produccion.TO.PrdResumenSiembraTO> prdResumenSiembraTOs = operacionesProduccionDAOLocal.getResumenSiembra(empresa, codigoSector, fechaInicio, fechaFin);

            mensaje = "T";
            produccion.helper.NumeroColumnaDesconocidadResumenSiembra obj = new produccion.helper.NumeroColumnaDesconocidadResumenSiembra();

            obj.agruparCabeceraColumnas(prdResumenSiembraTOs);
            obj.agruparResumenPesca(prdResumenSiembraTOs);
            obj.llenarObjetoParaTabla(prdResumenSiembraTOs);
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

    public produccion.TO.PrdLiquidacionMotivoTO getPrdLiquidacionMotivoTO(
            String empresa,
            produccion.TO.PrdLiquidacionMotivoTablaTO prdLiquidacionMotivoTablaTO) throws Exception {
        return operacionesProduccionDAOLocal.getPrdLiquidacionMotivoTO(empresa, prdLiquidacionMotivoTablaTO);
    }

    public java.util.List<produccion.TO.PrdLiquidacionMotivoTablaTO> getListaPrdLiquidacionMotivoTablaTO(
            String empresa) throws Exception {
        return operacionesProduccionDAOLocal.getListaPrdLiquidacionMotivoTablaTO(empresa);
    }

    public String insertarPrdLiquidacionMotivoTO(
            produccion.TO.PrdLiquidacionMotivoTO prdLiquidacionMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            if (operacionesProduccionDAOLocal.getPrdLiquidacionMotivo(prdLiquidacionMotivoTO.getLmEmpresa(),
                    prdLiquidacionMotivoTO.getLmCodigo()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susDetalle = "Se insertó el motivo de la liquidacion: " + prdLiquidacionMotivoTO.getLmDetalle();
                susClave = prdLiquidacionMotivoTO.getLmCodigo();
                susSuceso = "INSERT";
                susTabla = "produccion.prd_liquidacion_motivo";
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                prdLiquidacionMotivoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                produccion.entity.PrdLiquidacionMotivo prdLiquidacionMotivo = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionMotivoTO_PrdLiquidacionMotivo(prdLiquidacionMotivoTO);
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                if (operacionesProduccionDAOTransaccionLocal.insertarPrdLiquidacionMotivo(prdLiquidacionMotivo, sisSuceso)) {
                    retorno = "TEl motivo de la liquidacion se guardo correctamente...";
                } else {
                    retorno = "FHubo un error al guardar el motivo de la liquidacion...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl motivo de la liquidacion que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPrdLiquidacionMotivoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarPrdLiquidacionMotivoTO(produccion.TO.PrdLiquidacionMotivoTO prdLiquidacionMotivoTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        produccion.entity.PrdLiquidacionMotivo prdLiquidacionMotivoAux = operacionesProduccionDAOLocal.getPrdLiquidacionMotivo(prdLiquidacionMotivoTO.getLmEmpresa(),
                prdLiquidacionMotivoTO.getLmCodigo());
        try {
            if (prdLiquidacionMotivoAux != null) {
                susDetalle = "Se modificó el motivo de la liquidacion: " + prdLiquidacionMotivoTO.getLmDetalle();
                susClave = prdLiquidacionMotivoTO.getLmCodigo();
                susSuceso = "UPDATE";
                susTabla = "produccion.prd_liquidacion_motivo";

                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                prdLiquidacionMotivoTO.setUsrCodigo(prdLiquidacionMotivoAux.getUsrCodigo());
                prdLiquidacionMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(prdLiquidacionMotivoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                produccion.entity.PrdLiquidacionMotivo prdLiquidacionMotivo = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionMotivoTO_PrdLiquidacionMotivo(prdLiquidacionMotivoTO);

                if (operacionesProduccionDAOTransaccionLocal.modificarPrdLiquidacionMotivo(prdLiquidacionMotivo, sisSuceso)) {
                    retorno = "TEl motivo de la liquidacion se modificó correctamente...";
                } else {
                    retorno = "Hubo un error al modificar el motivo de la liquidacion...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl motivo de la liquidacion que va a modificar ya no existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarPrdLiquidacionMotivoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public produccion.TO.PrdLiquidacionTallaTO getPrdLiquidacionTallaTO(String empresa, produccion.TO.PrdLiquidacionTallaTablaTO prdLiquidacionTallaTablaTO) throws Exception {
        return operacionesProduccionDAOLocal.getPrdLiquidacionTallaTO(empresa, prdLiquidacionTallaTablaTO);
    }

    public java.util.List<produccion.TO.PrdLiquidacionTallaTablaTO> getListaPrdLiquidacionTallaTablaTO(String empresa) throws Exception {
        return operacionesProduccionDAOLocal.getListaPrdLiquidacionTallaTablaTO(empresa);
    }

    public java.util.List<produccion.TO.PrdLiquidacionTallaTablaTO> getListaPrdLiquidacionTallaTablaTO(String empresa, String codigo) throws Exception {
        return operacionesProduccionDAOLocal.getListaPrdLiquidacionTallaTablaTO(empresa, codigo);
    }

    public String insertarPrdLiquidacionTallaTO(produccion.TO.PrdLiquidacionTallaTO prdLiquidacionTallaTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            if (operacionesProduccionDAOLocal.getPrdLiquidacionTalla(prdLiquidacionTallaTO.getTallaEmpresa(),
                    prdLiquidacionTallaTO.getTallaCodigo()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susDetalle = "Se insertó el Talla de la liquidacion: " + prdLiquidacionTallaTO.getTallaDetalle();
                susClave = prdLiquidacionTallaTO.getTallaCodigo();
                susTabla = "produccion.prd_liquidacion_Talla";
                susSuceso = "INSERT";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                prdLiquidacionTallaTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                produccion.entity.PrdLiquidacionTalla prdLiquidacionTalla = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionTallaTO_PrdLiquidacionTalla(prdLiquidacionTallaTO);
                if (operacionesProduccionDAOTransaccionLocal.insertarPrdLiquidacionTalla(prdLiquidacionTalla, sisSuceso)) {
                    retorno = "TEl Talla de la liquidacion se guardo correctamente...";
                } else {
                    retorno = "FHubo un error al guardar el Talla de la liquidacion...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl Talla de la liquidacion que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPrdLiquidacionTallaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarPrdLiquidacionTallaTO(
            produccion.TO.PrdLiquidacionTallaTO prdLiquidacionTallaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        produccion.entity.PrdLiquidacionTalla prdLiquidacionTallaAux = operacionesProduccionDAOLocal.getPrdLiquidacionTalla(prdLiquidacionTallaTO.getTallaEmpresa(),
                prdLiquidacionTallaTO.getTallaCodigo());
        try {
            if (prdLiquidacionTallaAux != null) {
                /// CREAR EL SUSCESO
                susDetalle = "Se modificó el Talla de la liquidacion: " + prdLiquidacionTallaTO.getTallaDetalle();
                susClave = prdLiquidacionTallaTO.getTallaCodigo();
                susSuceso = "UPDATE";
                susTabla = "produccion.prd_liquidacion_Talla";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                prdLiquidacionTallaTO.setUsrCodigo(prdLiquidacionTallaAux.getUsrCodigo());
                prdLiquidacionTallaTO.setUsrFechaInserta(validaciones.Validacion.fecha(prdLiquidacionTallaAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                produccion.entity.PrdLiquidacionTalla prdLiquidacionTalla = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionTallaTO_PrdLiquidacionTalla(prdLiquidacionTallaTO);
                if (operacionesProduccionDAOTransaccionLocal.modificarPrdLiquidacionTalla(prdLiquidacionTalla, sisSuceso)) {
                    retorno = "TEl Talla de la liquidacion se modificó correctamente...";
                } else {
                    retorno = "Hubo un error al modificar el Talla de la liquidacion...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl Talla de la liquidacion que va a modificar ya no existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarPrdLiquidacionTallaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public produccion.TO.PrdLiquidacionProductoTO getPrdLiquidacionProductoTO(String empresa, produccion.TO.PrdLiquidacionProductoTablaTO prdLiquidacionProductoTablaTO) throws Exception {
        return operacionesProduccionDAOLocal.getPrdLiquidacionProductoTO(empresa, prdLiquidacionProductoTablaTO);
    }

    public java.util.List<produccion.TO.PrdLiquidacionProductoTablaTO> getListaPrdLiquidacionProductoTablaTO(String empresa) throws Exception {
        return operacionesProduccionDAOLocal.getListaPrdLiquidacionProductoTablaTO(empresa);
    }

    public java.util.List<produccion.TO.PrdLiquidacionProductoTablaTO> getListaPrdLiquidacionProductoTablaTO(String empresa, String codigo) throws Exception {
        return operacionesProduccionDAOLocal.getListaPrdLiquidacionProductoTablaTO(empresa, codigo);
    }

    public String insertarPrdLiquidacionProductoTO(
            produccion.TO.PrdLiquidacionProductoTO prdLiquidacionProductoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            if (operacionesProduccionDAOLocal.getPrdLiquidacionProducto(prdLiquidacionProductoTO.getProdEmpresa(),
                    prdLiquidacionProductoTO.getProdCodigo()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = prdLiquidacionProductoTO.getProdCodigo();
                susDetalle = "Se insertó el Producto de la liquidacion: " + prdLiquidacionProductoTO.getProdDetalle();
                susSuceso = "INSERT";
                susTabla = "produccion.prd_liquidacion_Producto";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                prdLiquidacionProductoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());

                produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionProductoTO_PrdLiquidacionProducto(prdLiquidacionProductoTO);

                if (operacionesProduccionDAOTransaccionLocal.insertarPrdLiquidacionProducto(prdLiquidacionProducto, sisSuceso)) {
                    retorno = "TEl Producto de la liquidacion se guardo correctamente...";
                } else {
                    retorno = "FHubo un error al guardar el Producto de la liquidacion...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl Producto de la liquidacion que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPrdLiquidacionProductoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarPrdLiquidacionProductoTO(produccion.TO.PrdLiquidacionProductoTO prdLiquidacionProductoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        produccion.entity.PrdLiquidacionProducto prdLiquidacionProductoAux = operacionesProduccionDAOLocal.getPrdLiquidacionProducto(prdLiquidacionProductoTO.getProdEmpresa(),
                prdLiquidacionProductoTO.getProdCodigo());
        try {
            if (prdLiquidacionProductoAux != null) {
                susClave = prdLiquidacionProductoTO.getProdCodigo();
                susDetalle = "Se modificó el Producto de la liquidacion: " + prdLiquidacionProductoTO.getProdDetalle();
                susSuceso = "UPDATE";
                susTabla = "produccion.prd_liquidacion_Producto";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                prdLiquidacionProductoTO.setUsrCodigo(prdLiquidacionProductoAux.getUsrCodigo());
                prdLiquidacionProductoTO.setUsrFechaInserta(validaciones.Validacion.fecha(prdLiquidacionProductoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionProductoTO_PrdLiquidacionProducto(prdLiquidacionProductoTO);
                if (operacionesProduccionDAOTransaccionLocal.modificarPrdLiquidacionProducto(prdLiquidacionProducto, sisSuceso)) {
                    retorno = "TEl Producto de la liquidacion se modificó correctamente...";
                } else {
                    retorno = "Hubo un error al modificar el Producto de la liquidacion...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FEl Producto de la liquidacion que va a modificar ya no existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarPrdLiquidacionProductoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String insertarPrdLiquidacionTO(
            produccion.TO.PrdLiquidacionTO prdLiquidacionTO,
            java.util.List<produccion.TO.PrdLiquidacionDetalleTO> listaPrdLiquidacionDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            if (!validaciones.Validacion.isFechaSuperior(prdLiquidacionTO.getLiqFecha(), "yyyy-MM-dd")) {
                inventario.entity.InvCliente invCliente = operacionesInventarioDAOLocal.buscarInvCliente(prdLiquidacionTO.getLiqEmpresa(), prdLiquidacionTO.getCliCodigo());
                if (invCliente != null) {
                    if (operacionesProduccionDAOLocal.comprobarPrdLiquidacionMotivo(prdLiquidacionTO.getLiqEmpresa(), prdLiquidacionTO.getLiqMotivo())) {
                        // CREAR SUCESO
                        susClave = prdLiquidacionTO.getLiqMotivo() + " " + prdLiquidacionTO.getLiqNumero();
                        susDetalle = "";//EL DETALLE SE GENERA EN EL TRANSACCION
                        susSuceso = "INSERT";
                        susTabla = "produccion.prd_liquidacion";

                        prdLiquidacionTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());

                        produccion.entity.PrdLiquidacionNumeracion prdLiquidacionNumeracion = new produccion.entity.PrdLiquidacionNumeracion(new produccion.entity.PrdLiquidacionNumeracionPK(prdLiquidacionTO.getLiqEmpresa(), prdLiquidacionTO.getLiqMotivo()));

                        produccion.entity.PrdLiquidacion prdLiquidacion = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionTO_PrdLiquidacion(prdLiquidacionTO);
                        prdLiquidacion.setCliEmpresa(invCliente.getInvClientePK().getCliEmpresa());
                        prdLiquidacion.setCliCodigo(invCliente.getInvClientePK().getCliCodigo());

                        java.util.List<produccion.entity.PrdLiquidacionDetalle> listPrdLiquidacionDetalle = new java.util.ArrayList(0);
                        produccion.entity.PrdLiquidacionDetalle prdLiquidacionDetalle = null;
                        int estadoDetalle = 0;
                        int contador = 0;
                        for (produccion.TO.PrdLiquidacionDetalleTO prdLiquidacionDetalleTO : listaPrdLiquidacionDetalleTO) {
                            prdLiquidacionDetalleTO.setDetOrden(contador);
                            prdLiquidacionDetalle = new produccion.entity.PrdLiquidacionDetalle();
                            prdLiquidacionDetalle = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionDetalleTO_PrdLiquidacionDetalle(prdLiquidacionDetalleTO);
                            produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto = operacionesProduccionDAOLocal.buscarPrdLiquidacionProducto(prdLiquidacionDetalleTO.getProdEmpresa(), prdLiquidacionDetalleTO.getProdCodigo());
                            if (prdLiquidacionProducto != null) {
                                prdLiquidacionDetalle.setPrdLiquidacionProducto(prdLiquidacionProducto);
                                produccion.entity.PrdLiquidacionTalla prdLiquidacionTalla = operacionesProduccionDAOLocal.buscarPrdLiquidacionTalla(prdLiquidacionDetalleTO.getTallaEmpresa(), prdLiquidacionDetalleTO.getTallaCodigo());
                                if (prdLiquidacionTalla != null) {
                                    prdLiquidacionDetalle.setPrdLiquidacionTalla(prdLiquidacionTalla);
                                    listPrdLiquidacionDetalle.add(prdLiquidacionDetalle);
                                } else {
                                    estadoDetalle = 2;
                                }
                            } else {
                                estadoDetalle = 1;
                            }
                            if (estadoDetalle == 1 || estadoDetalle == 2) {
                                break;
                            } else {
                                prdLiquidacionProducto = null;
                            }
                            contador++;
                        }
                        if (estadoDetalle == 0) {
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            if (operacionesProduccionDAOTransaccionLocal.insertarTransaccionPrdLiquidacion(prdLiquidacion, listPrdLiquidacionDetalle, sisSuceso, prdLiquidacionNumeracion)) {
                                retorno = "T<html>Se ingresó la liquidacion con la siguiente información:<br><br>" + "Fecha: <font size = 5>" + prdLiquidacionTO.getLiqFecha()
                                        + "</font>.<br> Motivo: <font size = 5>" + prdLiquidacion.getPrdLiquidacionPK().
                                        getLiqMotivo()
                                        + "</font>.<br> Número: <font size = 5>" + prdLiquidacion.getPrdLiquidacionPK().
                                        getLiqNumero() + "</font>.</html>";
                            }
                        } else {
                            if (estadoDetalle == 1) {
                                retorno = "F<html>Uno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                            } else {
                                retorno = "F<html>Una de las Tallas que escogió ya no está disponible...\nIntente de nuevo, escoja otra Talla o contacte con el administrador</html>";
                            }
                        }

                    } else {
                        retorno = "F<html>No se encuentra el motivo...</html>";
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
                    "insertarPrdLiquidacionTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarPrdLiquidacionTO(
            produccion.TO.PrdLiquidacionTO prdLiquidacionTO,
            java.util.List<produccion.TO.PrdLiquidacionDetalleTO> listaPrdLiquidacionDetalleTO,
            java.util.List<produccion.TO.PrdLiquidacionDetalleTO> listaPrdLiquidacionEliminarDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            if (!validaciones.Validacion.isFechaSuperior(prdLiquidacionTO.getLiqFecha(), "yyyy-MM-dd")) {
                inventario.entity.InvCliente invCliente = operacionesInventarioDAOLocal.buscarInvCliente(prdLiquidacionTO.getCliEmpresa(), prdLiquidacionTO.getCliCodigo());
                if (invCliente != null) {
                    if (operacionesProduccionDAOLocal.comprobarPrdLiquidacionMotivo(prdLiquidacionTO.getLiqEmpresa(), prdLiquidacionTO.getLiqMotivo())) {
                        produccion.entity.PrdLiquidacion prdLiquidacionCreada = operacionesProduccionDAOLocal.buscarPrdLiquidacion(prdLiquidacionTO.getLiqEmpresa(), prdLiquidacionTO.getLiqMotivo(), prdLiquidacionTO.getLiqNumero());
                        String estado = "";
                        if (prdLiquidacionTO.isLiqAnulado()) {
                            estado = "anuló";
                        } else {
                            estado = "modificó";
                        }
                        if (prdLiquidacionCreada != null) {
                            // CREAR EL SUCESO
                            susClave = prdLiquidacionTO.getLiqMotivo() + " " + prdLiquidacionTO.getLiqNumero();
                            susDetalle = "Se " + estado + " la Liquidacion con el motivo " + prdLiquidacionTO.getLiqMotivo() + ", de la numeración " + prdLiquidacionTO.getLiqNumero();
                            susSuceso = "UPDATE";
                            susTabla = "produccion.prd_liquidacion";
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            prdLiquidacionTO.setUsrCodigo(prdLiquidacionCreada.getUsrCodigo());
                            prdLiquidacionTO.setUsrFechaInserta(validaciones.Validacion.fecha(prdLiquidacionCreada.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));

                            produccion.entity.PrdLiquidacion prdLiquidacion = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionTO_PrdLiquidacion(prdLiquidacionTO);
                            prdLiquidacion.setCliEmpresa(invCliente.getInvClientePK().getCliEmpresa());
                            prdLiquidacion.setCliCodigo(invCliente.getInvClientePK().getCliCodigo());

                            java.util.List<produccion.entity.PrdLiquidacionDetalle> listaPrdLiquidacionDetalle = new java.util.ArrayList(0);
                            produccion.entity.PrdLiquidacionDetalle prdLiquidacionDetalle = null;
                            int estadoDetalle = 0;
                            if (listaPrdLiquidacionDetalleTO != null) {
                                for (produccion.TO.PrdLiquidacionDetalleTO prdLiquidacionDetalleTO : listaPrdLiquidacionDetalleTO) {
                                    prdLiquidacionDetalle = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionDetalleTO_PrdLiquidacionDetalle(prdLiquidacionDetalleTO);
                                    produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto = operacionesProduccionDAOLocal.buscarPrdLiquidacionProducto(prdLiquidacionDetalleTO.getProdEmpresa(), prdLiquidacionDetalleTO.getProdCodigo());
                                    if (prdLiquidacionProducto != null) {
                                        prdLiquidacionDetalle.setPrdLiquidacionProducto(prdLiquidacionProducto);
                                        produccion.entity.PrdLiquidacionTalla prdLiquidacionTalla = operacionesProduccionDAOLocal.buscarPrdLiquidacionTalla(prdLiquidacionDetalleTO.getTallaEmpresa(), prdLiquidacionDetalleTO.getTallaCodigo());
                                        if (prdLiquidacionTalla != null) {
                                            prdLiquidacionDetalle.setPrdLiquidacionTalla(prdLiquidacionTalla);
                                            listaPrdLiquidacionDetalle.add(prdLiquidacionDetalle);
                                        } else {
                                            estadoDetalle = 2;
                                        }
                                    } else {
                                        estadoDetalle = 1;
                                    }
                                    if (estadoDetalle == 1 || estadoDetalle == 2) {
                                        break;
                                    } else {
                                        prdLiquidacionProducto = null;
                                    }
                                }
                            }
                            if (estadoDetalle == 0) {
                                java.util.List<produccion.entity.PrdLiquidacionDetalle> listaPrdLiquidacionDetalleEliminar = new java.util.ArrayList(0);
                                produccion.entity.PrdLiquidacionDetalle prdLiquidacionDetalleEliminar = null;

                                int estadoDetalleEliminar = 0;
                                if (listaPrdLiquidacionEliminarDetalleTO != null) {
                                    for (produccion.TO.PrdLiquidacionDetalleTO prdLiquidacionDetalleTO : listaPrdLiquidacionEliminarDetalleTO) {
                                        prdLiquidacionDetalleEliminar = produccion.helper.ConversionesProduccion.convertirPrdLiquidacionDetalleTO_PrdLiquidacionDetalle(prdLiquidacionDetalleTO);
                                        produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto = operacionesProduccionDAOLocal.buscarPrdLiquidacionProducto(prdLiquidacionDetalleTO.getLiqEmpresa(), prdLiquidacionDetalleTO.getProdCodigo());

                                        if (prdLiquidacionProducto != null) {
                                            prdLiquidacionDetalleEliminar.setPrdLiquidacionProducto(prdLiquidacionProducto);
                                            produccion.entity.PrdLiquidacionTalla prdLiquidacionTalla = operacionesProduccionDAOLocal.buscarPrdLiquidacionTalla(prdLiquidacionDetalleTO.getTallaEmpresa(), prdLiquidacionDetalleTO.getTallaCodigo());
                                            if (prdLiquidacionTalla != null) {
                                                prdLiquidacionDetalleEliminar.setPrdLiquidacionTalla(prdLiquidacionTalla);
                                                listaPrdLiquidacionDetalleEliminar.add(prdLiquidacionDetalleEliminar);
                                            } else {
                                                estadoDetalleEliminar = 2;
                                            }
                                        } else {
                                            estadoDetalleEliminar = 1;
                                        }
                                        if (estadoDetalleEliminar == 1 || estadoDetalleEliminar == 2) {
                                            break;
                                        } else {
                                            prdLiquidacionProducto = null;
                                        }
                                    }
                                }
                                if (estadoDetalleEliminar == 0) {
                                    if (operacionesProduccionDAOTransaccionLocal.modificarPrdLiquidacion(prdLiquidacion, listaPrdLiquidacionDetalle, listaPrdLiquidacionDetalleEliminar, sisSuceso)) {
                                        retorno = "T<html>Se  " + (prdLiquidacionTO.isLiqAnulado() ? "anuló" : "modificó") + "  la Liquidacion con la siguiente información:<br><br>"
                                                + "Motivo: <font size = 5>" + prdLiquidacion.getPrdLiquidacionPK().getLiqMotivo()
                                                + "</font>.<br> Número: <font size = 5>" + prdLiquidacion.getPrdLiquidacionPK().getLiqNumero() + "</font>.</html>";
                                    } else {
                                        retorno = "FHubo un error al modificar la Liquidacion...\nIntente de nuevo o contacte con el administrador";
                                    }
                                } else {
                                    if (estadoDetalleEliminar == 1) {
                                        retorno = "F<html>EUno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                    } else {
                                        retorno = "F<html>Una de las Tallas que escogió ya no está disponible...\nIntente de nuevo, escoja otra Talla o contacte con el administrador</html>";
                                    }
                                }
                            } else {
                                if (estadoDetalle == 1) {
                                    retorno = "F<html>MUno de los Productos que escogió ya no está disponible...\nIntente de nuevo, escoja otro Producto o contacte con el administrador</html>";
                                } else {
                                    retorno = "F<html>Una de las Tallas que escogió ya no está disponible...\nIntente de nuevo, escoja otra Talla o contacte con el administrador</html>";
                                }
                            }

                        } else {
                            retorno = "F<html>La liquidacion que quiere modificar ya no se encuentra disponible</html>";
                        }
                    } else {
                        retorno = "F<html>No se encuentra el motivo...</html>";
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
                    "modificarPrdLiquidacionTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public java.util.List<produccion.TO.PrdLiquidacionMotivoComboTO> getListaLiquidacionMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        return operacionesProduccionDAOLocal.getListaLiquidacionMotivoComboTO(empresa, filtrarInactivos);
    }

    public java.util.List<produccion.TO.PrdListaConsultaLiquidacionTO> getListaPrdConsultaLiquidacion(String empresa, String sector, String piscina, String busqueda) throws Exception {
        return operacionesProduccionDAOLocal.getListaPrdConsultaLiquidacion(empresa, sector, piscina, busqueda);
    }

    public produccion.TO.PrdEstadoCCCVT getEstadoCCCVT(String empresa, String motivoTipo, String numero) throws Exception {
        return operacionesProduccionDAOLocal.getEstadoCCCVT(empresa, motivoTipo, numero);
    }

    public produccion.TO.PrdLiquidacionCabeceraTO getPrdLiquidacionCabeceraTO(String empresa, String motivo, String numeroLiquidacion) throws Exception {
        return operacionesProduccionDAOLocal.getPrdLiquidacionCabeceraTO(empresa, motivo, numeroLiquidacion);
    }

    public java.util.List<produccion.TO.PrdListaFunAnalisisPesosTO> getFunAnalisisPesos(String empresa, String sector, String fecha) throws Exception {
        return operacionesProduccionDAOLocal.getFunAnalisisPesos(empresa, sector, fecha);
    }
    
    public List<String> getFunFechaSemanas(String empresa, String sector, String fecha) throws Exception {
        return operacionesProduccionDAOLocal.getFunFechaSemanas(empresa, sector, fecha);
    }

    public java.util.List<produccion.TO.PrdListaDetalleLiquidacionTO> getListaPrdLiquidacionDetalleTO(String empresa, String motivo, String numero) throws Exception {
        return operacionesProduccionDAOLocal.getListaPrdLiquidacionDetalleTO(empresa, motivo, numero);
    }

    public java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> getListaConsultaGrameajePromedioPorPiscinaTOs(String empresa, String sector) throws Exception {
        return operacionesProduccionDAOLocal.getListaConsultaGrameajePromedioPorPiscinaTOs(empresa, sector);
    }

    public helper.RetornoTO getConsultaGrameajePromedioPorPiscina(
            String empresa,
            String sector,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {
            java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> prdListaConsultaGrameajePromedioPorPiscinaTOs =
                    operacionesProduccionDAOLocal.getListaConsultaGrameajePromedioPorPiscinaTOs(empresa, sector);
            mensaje = "T";
            produccion.helper.NumeroColumnaDesconocidadGrameajePromedioPorPiscina obj = new produccion.helper.NumeroColumnaDesconocidadGrameajePromedioPorPiscina();

            obj.agruparCabeceraColumnas(prdListaConsultaGrameajePromedioPorPiscinaTOs);
            obj.agruparPisina(prdListaConsultaGrameajePromedioPorPiscinaTOs);
            obj.llenarObjetoParaTabla(prdListaConsultaGrameajePromedioPorPiscinaTOs);
            retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
            retornoTO.setColumnas(obj.getColumnas());
            retornoTO.setDatos(obj.getDatos());
        } catch (Exception e) {
            comprobar = false;
            mensaje = "FOcurrió un error al obtener los datos de la Base de Datos. \nContacte con el administrador...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getCostoPorFechaProrrateado",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            retornoTO.setMensaje(mensaje);
            return retornoTO;
        }

    }

    public JasperPrint generarReporteListadoFunAnalisisPesos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String codigoSector, String fechaHasta,
            List<PrdListaFunAnalisisPesosTO> prdListaFunAnalisisPesosTO) throws Exception {
        return generarReporteProduccionLocal.generarReporteListadoFunAnalisisPesos(sisUsuarioEmpresaTO,
                codigoSector, fechaHasta, prdListaFunAnalisisPesosTO);
    }

    public JasperPrint generarReporteListadoGramaje(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String codigoSector, String codigoPiscina,
            String codigoCorrida, String fechaDesde, String fechaHasta,
            List<PrdListadoGrameajeTO> prdListadoGrameajeTO) throws Exception {
        return generarReporteProduccionLocal.generarReporteListadoGramaje(
                sisUsuarioEmpresaTO, codigoSector, codigoPiscina, codigoCorrida,
                fechaDesde, fechaHasta, prdListadoGrameajeTO);
    }

    public JasperPrint generarReporteConsumoFecha(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String secCodigo, String fechaDesde,
            String fechaHasta,
            List<PrdConsumosTO> prdConsumosTO) throws Exception {
        return generarReporteProduccionLocal.generarReporteConsumoFecha(
                sisUsuarioEmpresaTO, secCodigo, fechaDesde,
                fechaHasta, prdConsumosTO);
    }

    public JasperPrint generarReporteConsumoPiscina(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String codigoSector,
            String codigoPiscina, String numeroCorrida, String hectareas,
            Integer numLarvas, String fechaDesde, String fechaHasta,
            List<PrdConsumosTO> prdConsumosTO) throws Exception {
        return generarReporteProduccionLocal.generarReporteConsumoPiscina(
                sisUsuarioEmpresaTO, codigoSector, codigoPiscina, numeroCorrida,
                hectareas, numLarvas, fechaDesde, fechaHasta, prdConsumosTO);
    }

    public JasperPrint generarReporteEconomicoPorFechas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta,
            List<PrdCostoDetalleFechaTO> listaPrdCostoDetalleFechaTO) throws Exception {
        return generarReporteProduccionLocal.generarReporteEconomicoPorFechas(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                listaPrdCostoDetalleFechaTO);
    }

    public JasperPrint generarReporteEconomicoPorPiscinas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String codigoSector, String codigoPiscina,
            String codigoCorrida, String hectareas,
            Integer numLarvas, String fechaDesde,
            String fechaHasta,
            List<PrdListaCostosDetalleCorridaTO> prdListaCostosDetalleCorridaTO) throws Exception {
        return generarReporteProduccionLocal.generarReporteEconomicoPorPiscinas(
                sisUsuarioEmpresaTO, codigoSector, codigoPiscina, codigoCorrida,
                hectareas, numLarvas, fechaDesde, fechaHasta,
                prdListaCostosDetalleCorridaTO);
    }

    public JasperPrint generarReporteResumenSiembra(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, Object[][] datos) throws Exception {
        return generarReporteProduccionLocal.generarReporteResumenSiembra(
                sisUsuarioEmpresaTO, datos);
    }

    public JasperPrint generarReporteResumenSiembra(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<PrdResumenCorridaTO> listaPrdListaResumenCorridaTO) throws Exception {
        return generarReporteProduccionLocal.generarReporteResumenSiembra(
                sisUsuarioEmpresaTO, listaPrdListaResumenCorridaTO);
    }

    public JasperPrint generarResumenPesca(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<PrdResumenCorridaTO> listaPrdListaResumenCorridaTO) throws Exception {
        return generarReporteProduccionLocal.generarReporteResumenPesca(
                sisUsuarioEmpresaTO, listaPrdListaResumenCorridaTO);
    }

    public JasperPrint generarReporteResumenPescaEconomico(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, Object[][] datos) throws Exception {
        return generarReporteProduccionLocal.generarReporteResumenPescaEconomico(
                sisUsuarioEmpresaTO, datos);
    }
}