/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.business;

import cartera.entity.CarCobrosAnticiposPK;
import cartera.entity.CarCobrosPK;
import cartera.entity.CarPagosAnticiposPK;
import cartera.entity.CarPagosPK;
import contabilidad.DAO.OperacionesContabilidadDAOLocal;
import contabilidad.DAO.OperacionesContabilidadDAOTransaccionLocal;
import contabilidad.TO.*;
import contabilidad.entity.*;
import contabilidad.helper.ConversionesContabilidad;
import contabilidad.reporte.GenerarReporteContabilidadLocal;
import inventario.reporte.ReporteCompraDetalle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import rrhh.helper.ConversionesRRHH;
import sistema.DAO.OperacionesSistemaDAOLocal;
import sistema.TO.SisErrorTO;
import sistema.TO.SisListaPeriodoTO;
import sistema.TO.SisUsuarioEmpresaTO;
import sistemaWeb.entity.SisPeriodo;
import sistemaWeb.entity.SisSuceso;
import validaciones.Validacion;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesContabilidadBusiness implements OperacionesContabilidadBusinessLocal {

    // <editor-fold defaultstate="collapsed" desc="DECLARACIONES EJB">
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @EJB
    sistema.business.OperacionesSistemaBusinessLocal operacionesSistemaBusinessLocal;
    @EJB
    OperacionesContabilidadDAOLocal operacionesContabilidadDAOLocal;
    @EJB
    OperacionesContabilidadDAOTransaccionLocal operacionesContabilidadDAOTransaccionLocal;
    @EJB
    cartera.DAO.OperacionesCarDAOLocal operacionesCarDAOLocal;
    @EJB
    rrhh.DAO.OperacionesRRHHDAOLocal operacionesRRHHDAOLocal;
    @EJB
    GenerarReporteContabilidadLocal generarReporteContabilidadLocal;
    // </editor-fold>
    boolean comprobar = false;
    public SisErrorTO sisErrorTO = null;
    private String susTabla;//
    private String susClave;//
    private String susSuceso;//
    private String susDetalle;//

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA TIPO CONTABLE">
    @Override
    public boolean insertarConTipo(
            ConTipoTO conTipoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {

        try {
            comprobar = false;
            ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conTipoTO.getEmpCodigo(), conTipoTO.getTipCodigo());
            if (conTipo == null) {
                susClave = conTipoTO.getTipCodigo();
                susDetalle = "Se insertó al tipo contable " + conTipoTO.getTipCodigo() + " --> " + conTipoTO.getTipDetalle();
                susSuceso = "INSERT";
                susTabla = "contabilidad.con_tipo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);

                conTipoTO.setFechaInsertaTipo(Validacion.fechaSistema());
                conTipo = ConversionesContabilidad.convertirConTipoTO_ConTipo(conTipoTO);
                comprobar = operacionesContabilidadDAOTransaccionLocal.insertarConTipo(conTipo, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarConTipo",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean modificarConTipo(
            ConTipoTO conTipoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {

        try {
            comprobar = false;
            ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(
                    conTipoTO.getEmpCodigo().trim(), conTipoTO.getTipCodigo().trim());
            if (conTipo != null) {
                susClave = conTipoTO.getTipCodigo();
                susDetalle = "Se modificó al tipo contable con codigo " + conTipoTO.getTipCodigo();
                susSuceso = "UPDATE";
                susTabla = "contabilidad.con_tipo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);

                conTipoTO.setUsrInsertaTipo(conTipo.getUsrCodigo());
                conTipoTO.setFechaInsertaTipo(Validacion.fecha(conTipo.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                conTipo = ConversionesContabilidad.convertirConTipoTO_ConTipo(conTipoTO);
                comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConTipo(conTipo, sisSuceso);
            }
        } catch (Exception e) {

            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarConTipo",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean eliminarConTipo(
            ConTipoTO conTipoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        ConTipo conTipo = null;
        try {
            comprobar = false;
            if (operacionesContabilidadDAOLocal.buscarConteoNumeracionEliminarTipo(
                    conTipoTO.getEmpCodigo(), conTipoTO.getTipCodigo()) == 0) {
                susClave = conTipoTO.getTipCodigo();
                susDetalle = "Se eliminó al tipo " + conTipoTO.getTipDetalle();
                susSuceso = "DELETE";
                susTabla = "contabilidad.con_tipo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                conTipo = ConversionesContabilidad.convertirConTipoTO_ConTipo(conTipoTO);
                comprobar = operacionesContabilidadDAOTransaccionLocal.eliminarConTipo(conTipo, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarConTipo",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public List<ConTipoTO> getListaConTipoTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConTipoTO(empresa);
    }

    @Override
    public List<ConTipoTO> getListaConTipoRrhhTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConTipoRrhhTO(empresa);
    }

    @Override
    public List<ConTipoTO> getListaConTipoCarteraTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConTipoCarteraTO(empresa);
    }

    @Override
    public List<ConTipoTO> getListaConTipoCarteraAnticiposTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConTipoCarteraAnticiposTO(empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA PLAN DE CUENTAS">
    @Override
    public boolean insertarConCuenta(
            ConCuentasTO conCuentasTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            ConCuentas conCuentas = operacionesContabilidadDAOLocal.buscarCuentas(conCuentasTO.getEmpCodigo(), conCuentasTO.getCuentaCodigo());
            if (conCuentas == null) {
                susClave = conCuentasTO.getCuentaCodigo();
                susDetalle = "Se insertó cuenta " + conCuentasTO.getCuentaCodigo() + " --> " + conCuentasTO.getCuentaDetalle();
                susSuceso = "INSERT";
                susTabla = "contabilidad.con_cuentas";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);

                conCuentasTO.setUsrFechaInsertaCuenta(Validacion.fechaSistema());
                conCuentas = ConversionesContabilidad.convertirConCuentasTO_ConCuentas(conCuentasTO);
                comprobar = operacionesContabilidadDAOTransaccionLocal.insertarConCuenta(conCuentas, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarConCuenta",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean insertarConCuentaFlujo(
            ConCuentasFlujoTO conCuentasFlujoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            ConCuentasFlujo conCuentasFlujo = operacionesContabilidadDAOLocal.buscarCuentasFlujo(conCuentasFlujoTO.getFluCodigo(), conCuentasFlujoTO.getCuentaCodigo());
            if (conCuentasFlujo == null) {
                susClave = conCuentasFlujoTO.getCuentaCodigo();
                susDetalle = "Se insertó cuenta " + conCuentasFlujoTO.getCuentaCodigo() + " --> " + conCuentasFlujoTO.getCuentaDetalle();
                susSuceso = "INSERT";
                susTabla = "contabilidad.con_cuentas_flujo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                conCuentasFlujoTO.setUsrFechaInsertaCuenta(Validacion.fechaSistema());
                conCuentasFlujo = ConversionesContabilidad.convertirConCuentasFlujoTO_ConCuentasFlujo(conCuentasFlujoTO);
                comprobar = operacionesContabilidadDAOTransaccionLocal.insertarConCuentaFlujo(conCuentasFlujo, sisSuceso);

            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarConCuentaFlujo",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean insertarConCuentaFlujoDetalle(
            contabilidad.TO.ConCuentasFlujoDetalleTO conCuentasFlujoDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalle = operacionesContabilidadDAOLocal.buscarCuentasFlujoDetalle(conCuentasFlujoDetalleTO.getFluEmpresa(), conCuentasFlujoDetalleTO.getFluCodigo(), conCuentasFlujoDetalleTO.getDetDebitoCredito());
            if (conCuentasFlujoDetalle == null) {
                susClave = conCuentasFlujoDetalleTO.getFluCodigo();
                susDetalle = "Se insertó cuenta " + conCuentasFlujoDetalleTO.getFluCodigo() + " --> " + conCuentasFlujoDetalleTO.getDetCuentaContable();
                susSuceso = "INSERT";
                susTabla = "cont.con_cuentas_flujo_detalle";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                conCuentasFlujoDetalleTO.setUsrFechaInserta(Validacion.fechaSistema());
                conCuentasFlujoDetalle = ConversionesContabilidad.convertirConCuentasFlujoDetalleTO_ConCuentasFlujoDetalle(conCuentasFlujoDetalleTO);
                comprobar = operacionesContabilidadDAOTransaccionLocal.insertarConCuentaFlujoDetalle(conCuentasFlujoDetalle, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarConCuentaFlujoDetalle",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    private boolean moficiarEstadoContablesHijos(
            ConCuentasTO conCuentasTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        List<ConCuentasTO> listaCuentasTO = operacionesContabilidadDAOLocal.getListaConCuentasTO(conCuentasTO.getEmpCodigo());
        ConCuentas conCuentas = null;
        List<ConCuentas> listaCuentas = new ArrayList();
        listaCuentas.clear();
        int contador = 0;
        int indice = 0;
        for (ConCuentasTO conCuentasTO1 : listaCuentasTO) {
            if (conCuentasTO1.getCuentaCodigo().equals(conCuentasTO.getCuentaCodigo())) {
                if (((conCuentasTO1.getCuentaActivo() == true)
                        && (conCuentasTO.getCuentaActivo() == false))
                        || ((conCuentasTO1.getCuentaActivo() == false)
                        && (conCuentasTO.getCuentaActivo() == true))) {

                    ConCuentas conCuentasAux1 = operacionesContabilidadDAOLocal.buscarCuentas(
                            conCuentasTO.getEmpCodigo().trim(),
                            conCuentasTO.getCuentaCodigo().trim());

                    conCuentas = new ConCuentas();
                    conCuentas.setConCuentasPK(new ConCuentasPK(conCuentasTO.getEmpCodigo(), conCuentasTO.getCuentaCodigo()));
                    conCuentas.setCtaDetalle(conCuentasTO.getCuentaDetalle().trim());
                    conCuentas.setCtaActivo(conCuentasTO.getCuentaActivo());
                    conCuentas.setUsrCodigo(conCuentasAux1.getUsrCodigo());
                    conCuentas.setUsrEmpresa(conCuentasAux1.getUsrEmpresa());
                    conCuentas.setUsrFechaInserta(conCuentasAux1.getUsrFechaInserta());
                    listaCuentas.add(conCuentas);
                    conCuentas = null;
                    for (int i = contador + 1; i < listaCuentasTO.size(); i++) {
                        indice = listaCuentasTO.get(i).getCuentaCodigo().
                                lastIndexOf(conCuentasTO.getCuentaCodigo());
                        if (indice >= 0) {
                            conCuentas = new ConCuentas();
                            ConCuentas conCuentasAux2 = operacionesContabilidadDAOLocal.buscarCuentas(
                                    listaCuentasTO.get(i).getEmpCodigo().trim(),
                                    listaCuentasTO.get(i).getCuentaCodigo().trim());

                            conCuentas.setConCuentasPK(new ConCuentasPK(
                                    listaCuentasTO.get(i).getEmpCodigo(),
                                    listaCuentasTO.get(i).getCuentaCodigo()));
                            conCuentas.setCtaDetalle(listaCuentasTO.get(i).
                                    getCuentaDetalle().trim());
                            conCuentas.setCtaActivo(conCuentasTO.getCuentaActivo());
                            conCuentas.setUsrCodigo(conCuentasAux2.getUsrCodigo());
                            conCuentas.setUsrEmpresa(conCuentasAux2.getUsrEmpresa());
                            conCuentas.setUsrFechaInserta(conCuentasAux2.getUsrFechaInserta());
                            listaCuentas.add(conCuentas);
                            conCuentas = null;
                        } else {
                            break;
                        }
                    }
                }
            }
            contador++;
        }
        boolean modifico = false;
        if (listaCuentas.size() > 0) {
            modifico = operacionesContabilidadDAOTransaccionLocal.modificarListaConCuenta(listaCuentas);
        } else {
            modifico = false;
        }
        return modifico;
    }

    private boolean modificarEstadoContablesFlujoHijos(
            ConCuentasFlujoTO conCuentasFlujoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        List<ConCuentasFlujoTO> listaCuentasFlujoTO = operacionesContabilidadDAOLocal.getListaConCuentasFlujoTO(conCuentasFlujoTO.getFluCodigo());
        ConCuentasFlujo conCuentasFlujo = null;
        List<ConCuentasFlujo> listaCuentasFlujo = new ArrayList();

        listaCuentasFlujo.clear();
        int contador = 0;
        int indice = 0;
        for (ConCuentasFlujoTO conCuentasFlujoTO1 : listaCuentasFlujoTO) {
            if (conCuentasFlujoTO1.getCuentaCodigo().equals(conCuentasFlujoTO.getCuentaCodigo())) {
                if (((conCuentasFlujoTO1.getCuentaActivo() == true)
                        && (conCuentasFlujoTO.getCuentaActivo() == false))
                        || ((conCuentasFlujoTO1.getCuentaActivo() == false)
                        && (conCuentasFlujoTO.getCuentaActivo() == true))) {

                    ConCuentasFlujo conCuentasFlujoAux1 = operacionesContabilidadDAOLocal.buscarCuentasFlujo(
                            conCuentasFlujoTO.getFluCodigo().trim(),
                            conCuentasFlujoTO.getCuentaCodigo().trim());

                    conCuentasFlujo = new ConCuentasFlujo();
                    conCuentasFlujo.setConCuentasFlujoPK(new ConCuentasFlujoPK(conCuentasFlujoTO.getFluCodigo(), conCuentasFlujoTO.getCuentaCodigo()));
                    conCuentasFlujo.setFluDetalle(conCuentasFlujoTO.getCuentaDetalle().trim());
                    conCuentasFlujo.setFluActivo(conCuentasFlujoTO.getCuentaActivo());
                    conCuentasFlujo.setUsrCodigo(conCuentasFlujoAux1.getUsrCodigo());
                    conCuentasFlujo.setUsrEmpresa(conCuentasFlujoAux1.getUsrEmpresa());
                    conCuentasFlujo.setUsrFechaInserta(conCuentasFlujoAux1.getUsrFechaInserta());
                    listaCuentasFlujo.add(conCuentasFlujo);
                    conCuentasFlujo = null;
                    for (int i = contador + 1; i < listaCuentasFlujoTO.size(); i++) {
                        indice = listaCuentasFlujoTO.get(i).getCuentaCodigo().
                                lastIndexOf(conCuentasFlujoTO.getCuentaCodigo());
                        if (indice >= 0) {
                            conCuentasFlujo = new ConCuentasFlujo();
                            ConCuentas conCuentasAux2 = operacionesContabilidadDAOLocal.buscarCuentas(
                                    listaCuentasFlujoTO.get(i).getFluCodigo().trim(),
                                    listaCuentasFlujoTO.get(i).getCuentaCodigo().trim());

                            conCuentasFlujo.setConCuentasFlujoPK(new ConCuentasFlujoPK(
                                    listaCuentasFlujoTO.get(i).getFluCodigo(),
                                    listaCuentasFlujoTO.get(i).getCuentaCodigo()));
                            conCuentasFlujo.setFluDetalle(listaCuentasFlujoTO.get(i).
                                    getCuentaDetalle().trim());
                            conCuentasFlujo.setFluActivo(conCuentasFlujoTO.getCuentaActivo());
                            conCuentasFlujo.setUsrCodigo(conCuentasAux2.getUsrCodigo());
                            conCuentasFlujo.setUsrEmpresa(conCuentasAux2.getUsrEmpresa());
                            conCuentasFlujo.setUsrFechaInserta(conCuentasAux2.getUsrFechaInserta());
                            listaCuentasFlujo.add(conCuentasFlujo);
                            conCuentasFlujo = null;
                        } else {
                            break;
                        }
                    }
                }
            }
            contador++;
        }
        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                "contabilidad.con_cuentas",
                listaCuentasFlujo.get(0).getConCuentasFlujoPK().getFluCodigo(),
                "UPDATE",
                "Se modificó y desactivo a la cuenta contable" + " con codigo " + listaCuentasFlujo.get(0).getConCuentasFlujoPK().getFluCodigo() + " y a sus respectivos descendientes",
                sisInfoTO);
        boolean modifico = false;
        if (listaCuentasFlujo.size() > 0) {
            modifico = operacionesContabilidadDAOTransaccionLocal.modificarListaConCuentaFlujo(listaCuentasFlujo, sisSuceso);
        } else {
            modifico = false;
        }
        return modifico;
    }

    @Override
    public boolean modificarConCuenta(
            ConCuentasTO conCuentasTO,
            String codigoCambiarLlave,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            ConCuentas conCuentasAux = null;
            if (codigoCambiarLlave.trim().isEmpty()) {
                conCuentasAux = operacionesContabilidadDAOLocal.buscarCuentas(
                        conCuentasTO.getEmpCodigo().trim(), conCuentasTO.getCuentaCodigo().trim());
            } else {
                conCuentasAux = operacionesContabilidadDAOLocal.buscarCuentas(
                        conCuentasTO.getEmpCodigo().trim(), codigoCambiarLlave);
            }
            if (conCuentasAux != null && codigoCambiarLlave.trim().isEmpty()) {
                boolean prueba = moficiarEstadoContablesHijos(conCuentasTO, sisInfoTO);
                if (!prueba) {
                    susClave = conCuentasTO.getCuentaCodigo();
                    susDetalle = "Se modificó a la cuenta contable con codigo " + conCuentasTO.getCuentaCodigo();
                    susSuceso = "UPDATE";
                    susTabla = "contabilidad.con_cuentas";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    conCuentasTO.setUsrInsertaCuenta(conCuentasAux.getUsrCodigo());
                    conCuentasTO.setUsrFechaInsertaCuenta(Validacion.fecha(conCuentasAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                    ConCuentas conCuentas = ConversionesContabilidad.convertirConCuentasTO_ConCuentas(conCuentasTO);
                    comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuenta(conCuentas, sisSuceso);
                } else {
                    comprobar = true;
                }

            } else {
                if (conCuentasAux != null && !codigoCambiarLlave.trim().isEmpty()) {
                    boolean prueba = moficiarEstadoContablesHijos(conCuentasTO, sisInfoTO);
                    if (!prueba) {
                        susClave = conCuentasTO.getCuentaCodigo();
                        susDetalle = "Se modificó a la cuenta contable con codigo " + codigoCambiarLlave + " por el código " + conCuentasTO.getCuentaCodigo();
                        susSuceso = "UPDATE";
                        susTabla = "contabilidad.con_cuentas";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        conCuentasTO.setUsrInsertaCuenta(conCuentasAux.getUsrCodigo());
                        conCuentasTO.setUsrFechaInsertaCuenta(Validacion.fecha(conCuentasAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                        ConCuentas conCuentas = ConversionesContabilidad.convertirConCuentasTO_ConCuentas(conCuentasTO);
                        if (conCuentasAux.getConCuentasPK().getCtaCodigo().equals(conCuentas.getConCuentasPK().getCtaCodigo())) {
                            comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuenta(conCuentas, sisSuceso);
                        } else {
                            comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuentaLlavePrincipal(conCuentasAux, conCuentas, sisSuceso);
                        }
                    } else {
                        comprobar = true;
                    }
                } else {
                    if (conCuentasAux == null && codigoCambiarLlave.trim().isEmpty()) {
                        comprobar = false;
                    } else {
                        if (conCuentasAux == null && !codigoCambiarLlave.trim().isEmpty()) {
                            boolean prueba = moficiarEstadoContablesHijos(conCuentasTO, sisInfoTO);
                            if (!prueba) {
                                susClave = conCuentasTO.getCuentaCodigo();
                                susDetalle = "Se modificó a la cuenta contable con codigo " + codigoCambiarLlave + " por el código " + conCuentasTO.getCuentaCodigo();
                                susSuceso = "UPDATE";
                                susTabla = "contabilidad.con_cuentas";
                                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                        susTabla,
                                        susClave,
                                        susSuceso,
                                        susDetalle,
                                        sisInfoTO);
                                conCuentasTO.setUsrInsertaCuenta(conCuentasAux.getUsrCodigo());
                                conCuentasTO.setUsrFechaInsertaCuenta(Validacion.fecha(conCuentasAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                                ConCuentas conCuentas = ConversionesContabilidad.convertirConCuentasTO_ConCuentas(conCuentasTO);
                                comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuenta(conCuentas, sisSuceso);
                            } else {
                                comprobar = true;
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
                    "modificarConCuenta",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean modificarConCuentaFlujo(
            ConCuentasFlujoTO conCuentasFlujoTO,
            String codigoCambiarLlave,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            ConCuentasFlujo conCuentasFlujoAux = null;
            if (codigoCambiarLlave.trim().isEmpty()) {
                conCuentasFlujoAux = operacionesContabilidadDAOLocal.buscarCuentasFlujo(
                        conCuentasFlujoTO.getFluCodigo().trim(), conCuentasFlujoTO.getCuentaCodigo().trim());
            } else {
                conCuentasFlujoAux = operacionesContabilidadDAOLocal.buscarCuentasFlujo(
                        conCuentasFlujoTO.getFluCodigo().trim(), codigoCambiarLlave);
            }

            if (conCuentasFlujoAux != null && codigoCambiarLlave.trim().isEmpty()) {
                boolean prueba = modificarEstadoContablesFlujoHijos(conCuentasFlujoTO, sisInfoTO);
                if (!prueba) {
                    susClave = conCuentasFlujoTO.getCuentaCodigo();
                    susDetalle = "Se modificó a la cuenta contable con codigo " + conCuentasFlujoTO.getCuentaCodigo();
                    susSuceso = "UPDATE";
                    susTabla = "contabilidad.con_cuentas";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    conCuentasFlujoTO.setUsrInsertaCuenta(conCuentasFlujoAux.getUsrCodigo());
                    conCuentasFlujoTO.setUsrFechaInsertaCuenta(Validacion.fecha(conCuentasFlujoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                    ConCuentasFlujo conCuentasFlujo = ConversionesContabilidad.convertirConCuentasFlujoTO_ConCuentasFlujo(conCuentasFlujoTO);
                    comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuentaFlujo(conCuentasFlujo, sisSuceso);
                } else {
                    comprobar = true;
                }

            } else {
                if (conCuentasFlujoAux != null && !codigoCambiarLlave.trim().isEmpty()) {
                    boolean prueba = modificarEstadoContablesFlujoHijos(conCuentasFlujoTO, sisInfoTO);
                    if (!prueba) {
                        susClave = conCuentasFlujoTO.getCuentaCodigo();
                        susDetalle = "Se modificó a la cuenta contable con codigo " + codigoCambiarLlave + " por el código " + conCuentasFlujoTO.getCuentaCodigo();
                        susSuceso = "UPDATE";
                        susTabla = "contabilidad.con_cuentas";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        conCuentasFlujoTO.setUsrInsertaCuenta(conCuentasFlujoAux.getUsrCodigo());
                        conCuentasFlujoTO.setUsrFechaInsertaCuenta(Validacion.fecha(conCuentasFlujoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                        ConCuentasFlujo conCuentasFlujo = ConversionesContabilidad.convertirConCuentasFlujoTO_ConCuentasFlujo(conCuentasFlujoTO);
                        if (conCuentasFlujoAux.getConCuentasFlujoPK().getFluCodigo().equals(conCuentasFlujo.getConCuentasFlujoPK().getFluCodigo())) {
                            comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuentaFlujo(conCuentasFlujo, sisSuceso);
                        } else {
                            comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuentaFlujoLlavePrincipal(conCuentasFlujoAux, conCuentasFlujo, sisSuceso);
                        }
                    } else {
                        comprobar = true;
                    }
                } else {
                    if (conCuentasFlujoAux == null && codigoCambiarLlave.trim().isEmpty()) {
                        comprobar = false;
                    } else {
                        if (conCuentasFlujoAux == null && !codigoCambiarLlave.trim().isEmpty()) {
                            boolean prueba = modificarEstadoContablesFlujoHijos(conCuentasFlujoTO, sisInfoTO);
                            if (!prueba) {
                                susClave = conCuentasFlujoTO.getCuentaCodigo();
                                susDetalle = "Se modificó a la cuenta contable con codigo " + codigoCambiarLlave + " por el código " + conCuentasFlujoTO.getCuentaCodigo();
                                susSuceso = "UPDATE";
                                susTabla = "contabilidad.con_cuentas_flujo";
                                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                        susTabla,
                                        susClave,
                                        susSuceso,
                                        susDetalle,
                                        sisInfoTO);
                                conCuentasFlujoTO.setUsrInsertaCuenta(conCuentasFlujoAux.getUsrCodigo());
                                conCuentasFlujoTO.setUsrFechaInsertaCuenta(Validacion.fecha(conCuentasFlujoAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                                ConCuentasFlujo conCuentasFlujo = ConversionesContabilidad.convertirConCuentasFlujoTO_ConCuentasFlujo(conCuentasFlujoTO);
                                comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuentaFlujo(conCuentasFlujo, sisSuceso);
                            } else {
                                comprobar = true;
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
                    "modificarConCuentaFlujo",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean modificarConCuentaFlujoDetalle(
            contabilidad.TO.ConCuentasFlujoDetalleTO conCuentasFlujoDetalleTO,
            String codigoCambiarLlave,
            char formaPagoAnterior,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            comprobar = false;
            contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalleAux = null;
            if (codigoCambiarLlave.trim().isEmpty()) {
                conCuentasFlujoDetalleAux = operacionesContabilidadDAOLocal.buscarCuentasFlujoDetalle(
                        conCuentasFlujoDetalleTO.getFluEmpresa().trim(), conCuentasFlujoDetalleTO.getDetCuentaContable().trim(), conCuentasFlujoDetalleTO.getDetDebitoCredito());

            } else {
                conCuentasFlujoDetalleAux = operacionesContabilidadDAOLocal.buscarCuentasFlujoDetalle(
                        conCuentasFlujoDetalleTO.getFluEmpresa().trim(), codigoCambiarLlave, formaPagoAnterior);

            }
            if (conCuentasFlujoDetalleAux != null && codigoCambiarLlave.trim().isEmpty()) {
                susClave = conCuentasFlujoDetalleTO.getFluCodigo();
                susDetalle = "Se modificó a la cuenta flujo con código " + conCuentasFlujoDetalleTO.getFluCodigo();
                susSuceso = "UPDATE";
                susTabla = "cont.con_cuentas_flujo_detalle";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);

                conCuentasFlujoDetalleTO.setUsrFechaInserta(conCuentasFlujoDetalleAux.getUsrCodigo());
                conCuentasFlujoDetalleTO.setUsrFechaInserta(Validacion.fecha(conCuentasFlujoDetalleAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalle = ConversionesContabilidad.convertirConCuentasFlujoDetalleTO_ConCuentasFlujoDetalle(conCuentasFlujoDetalleTO);
                comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuentaFlujoDetalle(conCuentasFlujoDetalle, sisSuceso);

            } else {
                if (conCuentasFlujoDetalleAux != null && !codigoCambiarLlave.trim().isEmpty()) {
                    susClave = conCuentasFlujoDetalleTO.getFluCodigo();
                    susDetalle = "Se modificó a la cuenta contable con código " + codigoCambiarLlave + " por el código " + conCuentasFlujoDetalleTO.getFluCodigo();
                    susSuceso = "UPDATE";
                    susTabla = "cont.con_cuentas_flujo_detalle";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    conCuentasFlujoDetalleTO.setUsrCodigo(conCuentasFlujoDetalleAux.getUsrCodigo());
                    conCuentasFlujoDetalleTO.setUsrFechaInserta(Validacion.fecha(conCuentasFlujoDetalleAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                    contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalle = ConversionesContabilidad.convertirConCuentasFlujoDetalleTO_ConCuentasFlujoDetalle(conCuentasFlujoDetalleTO);
                    if (conCuentasFlujoDetalleAux.getConCuentasFlujoDetallePK().getDetCuentaContable().equals(conCuentasFlujoDetalle.getConCuentasFlujoDetallePK().getDetCuentaContable())
                            && conCuentasFlujoDetalleAux.getConCuentasFlujoDetallePK().getDetEmpresa().equals(conCuentasFlujoDetalle.getConCuentasFlujoDetallePK().getDetEmpresa())
                            && conCuentasFlujoDetalleAux.getConCuentasFlujoDetallePK().getDetDebitoCredito() == conCuentasFlujoDetalle.getConCuentasFlujoDetallePK().getDetDebitoCredito()) {
                        comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuentaFlujoDetalle(conCuentasFlujoDetalle, sisSuceso);
                    } else {
                        comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuentaLlavePrincipalFlujoDetalle(conCuentasFlujoDetalleAux, conCuentasFlujoDetalle, sisSuceso);
                    }
                } else {
                    if (conCuentasFlujoDetalleAux == null && codigoCambiarLlave.trim().isEmpty()) {
                        comprobar = false;
                    } else {
                        if (conCuentasFlujoDetalleAux == null && !codigoCambiarLlave.trim().isEmpty()) {
                            susClave = conCuentasFlujoDetalleTO.getFluCodigo();
                            susDetalle = "Se modificó a la cuenta contable con código " + codigoCambiarLlave + " por el código " + conCuentasFlujoDetalleTO.getFluCodigo();
                            susSuceso = "UPDATE";
                            susTabla = "cont.con_cuentas_flujo_detalle";
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            conCuentasFlujoDetalleTO.setUsrFechaInserta(conCuentasFlujoDetalleAux.getUsrCodigo());
                            conCuentasFlujoDetalleTO.setUsrFechaInserta(Validacion.fecha(conCuentasFlujoDetalleAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                            contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalle = ConversionesContabilidad.convertirConCuentasFlujoDetalleTO_ConCuentasFlujoDetalle(conCuentasFlujoDetalleTO);
                            comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConCuentaFlujoDetalle(conCuentasFlujoDetalle, sisSuceso);

                        }
                    }
                }
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarConCuentaFlujoDetalle",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }
//

    @Override
    public int buscarConteoDetalleEliminarCuenta(
            String empCodigo,
            String cuentaCodigo) throws Exception {
        return operacionesContabilidadDAOLocal.buscarConteoDetalleEliminarCuenta(empCodigo, cuentaCodigo);
    }
    private String mensaje;

    @Override
    public String eliminarConCuenta(
            ConCuentasTO conCuentasTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        ConCuentas conCuentas = null;
        mensaje = "FOcurrió un error en el lado del Servidor..";
        try {
            comprobar = false;
            if (operacionesContabilidadDAOLocal.buscarConteoDetalleEliminarCuenta(
                    conCuentasTO.getEmpCodigo(), conCuentasTO.getCuentaCodigo()) == 0) {
                susClave = conCuentasTO.getCuentaCodigo();
                susDetalle = "Se eliminó a la cuenta contable " + conCuentasTO.getCuentaDetalle();
                susSuceso = "DELETE";
                susTabla = "contabilidad.con_cuentas";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                conCuentas = ConversionesContabilidad.convertirConCuentasTO_ConCuentas(conCuentasTO);
                comprobar = operacionesContabilidadDAOTransaccionLocal.eliminarConCuenta(conCuentas, sisSuceso);
                if (comprobar) {
                    mensaje = "TSe eliminó correctamente la cuenta contable..";
                } else {
                    mensaje = "FLa cuenta contable tiene problemas..";
                }
            } else {
                mensaje = "FLa cuenta contable tiene movimientos..";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarConCuenta",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        }
        return mensaje;
    }

    @Override
    public String eliminarConCuentaFlujoDetalle(
            ConCuentasFlujoDetalleTO conCuentasFlujoDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        ConCuentasFlujoDetalle conCuentasFlujoDetalle = null;
        mensaje = "FOcurrió un error en el lado del Servidor..";
        try {
            comprobar = false;
            ConCuentasFlujo conCuentasFlujo = operacionesContabilidadDAOLocal.buscarCuentasFlujo(conCuentasFlujoDetalleTO.getFluEmpresa(), conCuentasFlujoDetalleTO.getFluCodigo());
            if (conCuentasFlujo != null) {
                susClave = conCuentasFlujoDetalleTO.getCtaCodigo();
                susDetalle = "Se eliminó a la cuenta flujo " + conCuentasFlujoDetalleTO.getDetCuentaFlujo();
                susSuceso = "DELETE";
                susTabla = "contabilidad.con_cuentas_flujo_detalle";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                conCuentasFlujoDetalle = ConversionesContabilidad.convertirConCuentasFlujoDetalleTO_ConCuentasFlujoDetalle(conCuentasFlujoDetalleTO);
                conCuentasFlujoDetalle.setConCuentasFlujo(conCuentasFlujo);
                comprobar = operacionesContabilidadDAOTransaccionLocal.eliminarConCuentaFlujoDetalle(conCuentasFlujoDetalle, sisSuceso);
                if (comprobar) {
                    mensaje = "TSe eliminó correctamente la cuenta contable de flujo detalle..";
                } else {
                    mensaje = "FLa cuenta contable de flujo detalle tiene problemas..";
                }
            } else {
                mensaje = "FLa cuenta contable de flujo detalle tiene movimientos..";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarConCuentaFlujoDetalle",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public String eliminarConCuentaFlujo(
            ConCuentasFlujoTO conCuentasFlujoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        ConCuentasFlujo conCuentasFlujo = null;
        mensaje = "FOcurrió un error en el lado del Servidor..";
        try {
            comprobar = false;
            if (operacionesContabilidadDAOLocal.buscarConteoDetalleEliminarCuenta(
                    conCuentasFlujoTO.getFluCodigo(), conCuentasFlujoTO.getCuentaCodigo()) == 0) {
                susClave = conCuentasFlujoTO.getCuentaCodigo();
                susDetalle = "Se eliminó a la cuenta contable flujo " + conCuentasFlujoTO.getCuentaDetalle();
                susSuceso = "DELETE";
                susTabla = "contabilidad.con_cuentas_flujo";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                conCuentasFlujo = ConversionesContabilidad.convertirConCuentasFlujoTO_ConCuentasFlujo(conCuentasFlujoTO);
                comprobar = operacionesContabilidadDAOTransaccionLocal.eliminarConCuentaFlujo(conCuentasFlujo, sisSuceso);
                if (comprobar) {
                    mensaje = "TSe eliminó correctamente la cuenta contable de flujo..";
                } else {
                    mensaje = "FLa cuenta contable de flujo tiene problemas..";
                }
            } else {
                mensaje = "FLa cuenta contable de flujo tiene movimientos..";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarConCuenta",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }
//

    @Override
    public List<ConCuentasTO> getListaConCuentasTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConCuentasTO(empresa);
    }

    @Override
    public List<ConCuentasTO> getRangoCuentasTO(
            String empresa,
            String codigoCuentaDesde,
            String codigoCuentaHasta,
            int largoCuenta,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        List<ConCuentasTO> conCuentasTOs = null;
        try {
            conCuentasTOs = operacionesContabilidadDAOLocal.getRangoCuentasTO(
                    empresa,
                    codigoCuentaDesde,
                    codigoCuentaHasta,
                    largoCuenta);
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getListaMayorAuxiliarMultipleTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        }
        return conCuentasTOs;
    }

    @Override
    public List<ConCuentasFlujoTO> getListaConCuentasFlujoTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConCuentasFlujoTO(empresa);
    }

    @Override
    public List<contabilidad.TO.ConCuentasFlujoDetalleTO> getListaConCuentasFlujoDetalleTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConCuentasFlujoDetalleTO(empresa);
    }

    @Override
    public List<ConCuentasTO> getListaBuscarConCuentasTO(
            String empresa,
            String buscar,
            String ctaGrupo) throws Exception {
        return operacionesContabilidadDAOLocal.getListaBuscarConCuentasTO(empresa, buscar, ctaGrupo);
    }

    @Override
    public List<contabilidad.TO.ConCuentasFlujoTO> getListaBuscarConCuentasFlujoTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getListaBuscarConCuentasFlujoTO(empresa);
    }

    @Override
    public List<contabilidad.TO.ConCuentasFlujoDetalleTO> getListaBuscarConCuentasFlujoDetalleTO(
            String empresa,
            String buscar) throws Exception {
        return operacionesContabilidadDAOLocal.getListaBuscarConCuentasFlujoDetalleTO(empresa, buscar);
    }
    // </editor-fold>

    @Override
    public List<ConEstructuraTO> getListaConEstructuraTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConEstructuraTO(empresa);
    }

    @Override
    public List<contabilidad.TO.ConEstructuraFlujoTO> getListaConEstructuraFlujoTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConEstructuraFlujoTO(empresa);
    }

    @Override
    public List<ListaConContableTO> getListaBusquedaConContableTO(
            String empresa,
            String perCodigo,
            String tipCodigo,
            String busqueda,
            String nRegistros) throws Exception {
        return operacionesContabilidadDAOLocal.getListaBusquedaConContableTO(empresa, perCodigo, tipCodigo, busqueda, nRegistros);
    }

    @Override
    public List<ConContableTO> getListaConContableTO(
            String empresa,
            String perCodigo,
            String tipCodigo,
            String numContable) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConContableTO(empresa, perCodigo, tipCodigo, numContable);
    }

    @Override
    public List<ConDetalleTablaTO> getListaConDetalleTO(
            String empresa,
            String perCodigo,
            String tipCodigo,
            String numContable) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConDetalleTO(empresa, perCodigo, tipCodigo, numContable);
    }

    @Override
    public java.lang.Boolean buscarConDetallesActivosBiologicos(
            java.lang.String empresa) throws java.lang.Exception {
        return operacionesContabilidadDAOLocal.buscarConDetallesActivosBiologicos(empresa);
    }

    @Override
    public java.util.List<contabilidad.TO.ConFunBalanceResultadosNecTO> getConFunBalanceResultadosNecTO(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta,
            java.lang.Integer columnasEstadosFinancieros,
            Boolean ocultarDetalle) throws java.lang.Exception {
        return operacionesContabilidadDAOLocal.getConFunBalanceResultadosNecTO(empresa, sector, fechaDesde, fechaHasta, columnasEstadosFinancieros, ocultarDetalle);
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceResultadoTO> getConFunBalanceFlujoEfectivo(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesContabilidadDAOLocal.getConFunBalanceFlujoEfectivo(empresa, sector, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<contabilidad.TO.ConFunBalanceGeneralNecTO> getConFunBalanceGeneralNecTO(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String fecha,
            java.lang.Boolean ocultar,
            java.lang.Boolean ocultarDetalle,
            java.lang.Integer columnasEstadosFinancieros) throws java.lang.Exception {
        return operacionesContabilidadDAOLocal.getConFunBalanceGeneralNecTO(
                empresa,
                sector,
                fecha,
                ocultar,
                ocultarDetalle,
                columnasEstadosFinancieros);
    }

    @Override
    public List<ConBalanceGeneralTO> getFunBalanceGeneralTO(
            String empresa,
            String secCodigo,
            String fecha,
            Boolean ocultar) throws Exception {
        return operacionesContabilidadDAOLocal.getFunBalanceGeneralTO(empresa, secCodigo, fecha, ocultar);
    }

    @Override
    public List<ConBalanceGeneralTO> getFunCuentasSobregiradasTO(
            String empresa,
            String secCodigo,
            String fecha) throws Exception {
        return operacionesContabilidadDAOLocal.getFunCuentasSobregiradasTO(empresa, secCodigo, fecha);
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceGeneralComparativoTO> getFunBalanceGeneralComparativoTO(
            String empresa,
            String secCodigo,
            String fechaAnterior,
            String fechaActual,
            Boolean ocultar) throws Exception {
        return operacionesContabilidadDAOLocal.getFunBalanceGeneralComparativoTO(empresa, secCodigo, fechaAnterior, fechaActual, ocultar);
    }

    @Override
    public List<ConBalanceComprobacionTO> getListaBalanceComprobacionTO(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            Boolean ocultarDetalle) throws Exception {
        return operacionesContabilidadDAOLocal.getListaBalanceComprobacionTO(empresa, codigoSector, fechaInicio, fechaFin, ocultarDetalle);
    }

    @Override
    public List<ConBalanceResultadoTO> getListaBalanceResultadoTO(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            Boolean ocultarDetalle) throws Exception {
        return operacionesContabilidadDAOLocal.getListaBalanceResultadoTO(empresa, codigoSector, fechaInicio, fechaFin, ocultarDetalle);
    }

    @Override
    public List<contabilidad.TO.ConMayorAuxiliarTO> getListaMayorAuxiliarTO(
            String empresa,
            String codigoCuenta,
            String fechaInicio,
            String fechaFin,
            String sector) throws Exception {
        return operacionesContabilidadDAOLocal.getListaMayorAuxiliarTO(
                empresa,
                codigoCuenta,
                fechaInicio,
                fechaFin,
                sector);
    }

    @Override
    public List<contabilidad.TO.ConMayorAuxiliarTO> getListaMayorAuxiliarMultipleTO(
            String empresa,
            String codigoCuentaDesde,
            String codigoCuentaHasta,
            String fechaInicio,
            String fechaFin,
            String sector,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        List<contabilidad.TO.ConMayorAuxiliarTO> conMayorAuxiliarMultipleTOs = new java.util.ArrayList(1);
        List<contabilidad.TO.ConMayorAuxiliarTO> conMayorAuxiliarMultipleAuxTOs = null;
        try {
            List<contabilidad.TO.ConEstructuraTO> conEstructuraTOs = getListaConEstructuraTO(empresa);
            int largoCuenta = conEstructuraTOs.get(0).getEstGrupo1()
                    + conEstructuraTOs.get(0).getEstGrupo2()
                    + conEstructuraTOs.get(0).getEstGrupo3()
                    + conEstructuraTOs.get(0).getEstGrupo4()
                    + conEstructuraTOs.get(0).getEstGrupo5()
                    + conEstructuraTOs.get(0).getEstGrupo6();
            List<ConCuentasTO> conCuentasTOs = getRangoCuentasTO(
                    empresa,
                    codigoCuentaDesde,
                    codigoCuentaHasta,
                    largoCuenta,
                    usuario,
                    sisInfoTO);
            for (ConCuentasTO conCuentasTO : conCuentasTOs) {
                conMayorAuxiliarMultipleAuxTOs = getListaMayorAuxiliarTO(empresa, conCuentasTO.getCuentaCodigo(), fechaInicio, fechaFin, sector);
                for (contabilidad.TO.ConMayorAuxiliarTO conMayorAuxiliarMultipleTO : conMayorAuxiliarMultipleAuxTOs) {
                    conMayorAuxiliarMultipleTOs.add(conMayorAuxiliarMultipleTO);
                }
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getListaMayorAuxiliarMultipleTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        }
        return conMayorAuxiliarMultipleTOs;
    }

    @Override
    public List<contabilidad.TO.ConMayorGeneralTO> getListaMayorGeneralTO(
            String empresa,
            String codigoSector,
            String codigoCuenta,
            String fechaFin) throws Exception {
        return operacionesContabilidadDAOLocal.getListaMayorGeneralTO(empresa, codigoSector, codigoCuenta, fechaFin);
    }

    @Override
    public List<contabilidad.TO.ConDiarioAuxiliarTO> getListaDiarioAuxiliarTO(
            String empresa,
            String codigoTipo,
            String fechaInicio,
            String fechaFin) throws Exception {
        return operacionesContabilidadDAOLocal.getListaDiarioAuxiliarTO(empresa, codigoTipo, fechaInicio, fechaFin);
    }

    @Override
    public contabilidad.TO.ConContableConDetalle buscarConContableConDetalle(Long detSecuencia) throws Exception {
        contabilidad.TO.ConContableConDetalle conContableConDetalleTO = null;
        contabilidad.entity.ConDetalle conDetalleAux = operacionesContabilidadDAOLocal.buscarDetalleContable(detSecuencia);
        if (conDetalleAux != null) {
            conContableConDetalleTO = new contabilidad.TO.ConContableConDetalle();
            contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContable_ConContable(conDetalleAux.getConContable());
            contabilidad.entity.ConCuentas conCuentas = conDetalleAux.getConCuentas();
            contabilidad.entity.ConDetalle conDetalle = contabilidad.helper.ConversionesContabilidad.convertirConDetalle_ConDetalle(conDetalleAux);
            conDetalle.setConContable(conContable);
            conDetalle.setConCuentas(conCuentas);
            ///////
            conContableConDetalleTO.setConContable(conContable);
            conContableConDetalleTO.setConDetalle(conDetalle);
        }
        return conContableConDetalleTO;
    }

    @Override
    public inventario.TO.MensajeTO insertarConContable(
            ConContableTO conContableTO,
            List<ConDetalleTO> listaConDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        java.util.List<String> mensaje = new java.util.ArrayList(1);
        String mensajeAux = "";
        boolean periodoCerrado = false;
        try {
            List<SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(conContableTO.getEmpCodigo());
            for (SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (Validacion.fecha(conContableTO.getConFecha(), "yyyy-MM-dd").getTime()
                        >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && Validacion.fecha(conContableTO.getConFecha(), "yyyy-MM-dd").getTime()
                        <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                    comprobar = true;
                    conContableTO.setPerCodigo(sisListaPeriodoTO.getPerCodigo());
                    periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                }
            }
            if (comprobar) {
                if (!periodoCerrado) {
                    if (operacionesContabilidadDAOLocal.buscarTipoContable(conContableTO.getEmpCodigo(), conContableTO.getTipCodigo())) {
                        ///// CREANDO UN SUCESO
                        susClave = conContableTO.getPerCodigo() + " "
                                + conContableTO.getTipCodigo() + " "
                                + conContableTO.getConNumero();
                        susSuceso = "INSERT";
                        susTabla = "contabilidad.con_contable";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        conContableTO.setUsrFechaInsertaContable(Validacion.fecha(sisSuceso.getSusFecha(), "yyyy-MM-dd HH:mm:ss"));
                        ////// CREANDO NUMERACION
                        ConNumeracion conNumeracion = new ConNumeracion(new ConNumeracionPK(
                                conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                                conContableTO.getTipCodigo()));
                        ////// CREANDO CONTABLE
                        ConContable conContable = ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                        ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                        List<ConDetalle> listConDetalle = new ArrayList(0);
                        ConDetalle conDetalle = null;
                        for (ConDetalleTO conDetalleTO : listaConDetalleTO) {
                            conDetalle = new ConDetalle();
                            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                            //                        conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                            conDetalle = ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTO);
                            conDetalle.setConContable(conContable);
                            contabilidad.entity.ConCuentas conCuentas = operacionesContabilidadDAOLocal.buscarCuentas(conDetalleTO.getEmpCodigo(),
                                    conDetalleTO.getConCtaCodigo());
                            if (conCuentas != null) {
                                conDetalle.setConCuentas(conCuentas);
                                listConDetalle.add(conDetalle);
                            } else {
                                mensajeAux = "F<html>No se encontraron las cuentas contables en la(s) línea(s):</html>";
                                mensaje.add(conDetalleTO.getDetOrden().toString() + " - " + conDetalleTO.getConCtaCodigo().toString());
                            }
                        }
                        if (mensaje.isEmpty()) {
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
                                    null,
                                    null,
                                    null,
                                    null,
                                    sisInfoTO);
                            if (comprobar) {
                                SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                                ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                                mensajeAux = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                        + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                        + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                        + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>, "
                                        + conContable.getConContablePK().getConPeriodo() + ", " + conContable.getConContablePK().getConNumero();
                                mensajeTO.setFechaCreacion(validaciones.Validacion.fecha(conContable.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                            } else {
                                mensajeAux = "F<html>Ocurrió un error al guardar el contable, inténtelo de nuevo...</html>";
                            }
                        } else {
                            mensajeTO.setMensaje(mensajeAux);
                            mensajeTO.setListaErrores(mensaje);
                        }
                    } else {
                        mensajeAux = "F<html>No se encuentra tipo de contable...</html>";
                    }
                } else {
                    mensajeAux = "F<html>El periodo que corresponde a la fecha que ingresó se encuentra cerrado...</html>";
                }
            } else {
                mensajeAux = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(mensajeAux);
            return mensajeTO;
        }
    }

    @Override
    public String modificarConContable(
            ConContableTO conContableTO,
            List<ConDetalleTO> listaConDetalleTO,
            List<ConDetalleTO> listaConDetalleEliminarTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        String mensaje = "";
        try {
            ////BUSCANDO CONTABLE YA CREADO
            contabilidad.entity.ConContable conContableTOAux = operacionesContabilidadDAOLocal.buscarContable(conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                    conContableTO.getTipCodigo(), conContableTO.getConNumero());
            ///// CREANDO UN SUCESO
            susClave = conContableTO.getPerCodigo() + " "
                    + conContableTO.getTipCodigo() + " " + conContableTO.getConNumero();
            susDetalle = "Se modificó contable del periodo "
                    + conContableTO.getPerCodigo() + ", del tipo contable "
                    + conContableTO.getTipCodigo() + ", de la numeracion "
                    + conContableTO.getConNumero();
            susSuceso = "UPDATE";
            susTabla = "contabilidad.con_contable";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            conContableTO.setUsrInsertaContable(conContableTOAux.getUsrCodigo());
            conContableTO.setUsrFechaInsertaContable(Validacion.fecha(conContableTOAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
            ////// CREANDO CONTABLE
            ConContable conContable = ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
            ////// CONVIRTIENDO A ENTIDAD EL DETALLE
            List<ConDetalle> listConDetalle = new ArrayList(1);
            ConDetalle conDetalle = null;
            for (ConDetalleTO conDetalleTO : listaConDetalleTO) {
                conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                conDetalle = ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTO);
                conDetalle.setConContable(conContable);
                conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(conDetalleTO.getEmpCodigo(),
                        conDetalleTO.getConCtaCodigo()));
                listConDetalle.add(conDetalle);
                conDetalle = null;
            }
            List<ConDetalle> listConDetalleEliminar = new ArrayList();
            if (listaConDetalleEliminarTO != null) {
                for (ConDetalleTO conDetalleTO : listaConDetalleEliminarTO) {
//                    conDetalleTO.setSecCodigo(null);
//                    conDetalleTO.setPisNumero(null);
                    conDetalleTO.setDetDocumento("");
                    conDetalleTO.setDetDebitoCredito('D');
                    conDetalleTO.setDetValor(new java.math.BigDecimal("10.10"));
                    conDetalleTO.setDetGenerado(true);
                    conDetalleTO.setDetReferencia("");
                    conDetalleTO.setDetOrden(2);
                    conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                    conDetalle = ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTO);
                    conDetalle.setConContable(conContable);
                    conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(conDetalleTO.getEmpCodigo(),
                            conDetalleTO.getConCtaCodigo()));
                    
                    listConDetalleEliminar.add(conDetalle);
                    conDetalle = null;
                }
            }
            String estado = "";
            comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConContable(conContable, listConDetalle, listConDetalleEliminar, sisSuceso);
            if (comprobar) {
                SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                if (conContable.getConAnulado()) {
                    estado = "anuló";
                } else {
                    estado = "actualizó";
                }

                mensaje = "T<html>Se " + estado + " el contable con la siguiente información:<br><br>"
                        + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                        + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                        + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>";
            } else {
                mensaje = "FOcurrió un error al guardar el contable, inténtelo de nuevo...";
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public java.util.List<contabilidad.TO.ConNumeracionTO> getListaConNumeracionTO(
            String empresa,
            String periodo,
            String tipo) throws Exception {
        return operacionesContabilidadDAOLocal.getListaConNumeracionTO(empresa, periodo, tipo);
    }

    @Override
    public ConDetalle buscarDetalleContable(
            Long codDetalle) throws Exception {
        return operacionesContabilidadDAOLocal.buscarDetalleContable(codDetalle);
    }

    @Override
    public List<ConDetalleTO> buscarConContable(
            String codEmpresa,
            String perCodigo,
            String tipCodigo,
            String conNumero) throws Exception {
        return operacionesContabilidadDAOLocal.getConDetalleTO(codEmpresa, perCodigo, tipCodigo, conNumero);
    }

    @Override
    public String modificarConDetalleTO(
            Long secuencial,
            String usuario,
            String empresa,
            String documento,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            susClave = secuencial.toString();
            susDetalle = "Se modificó el detalle de contable numero "
                    + secuencial.toString() + " ya que se modificó el valore en el formulario cheque";
            susSuceso = "UPDATE";
            susTabla = "contabilidad.con_detalle";
            ///// CREANDO UN SUCESO
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            contabilidad.entity.ConDetalle conDetalle = operacionesContabilidadDAOLocal.buscarDetalleContable(secuencial);
            conDetalle.setDetDocumento(documento);
            comprobar = false;
            if (conDetalle.getConContable().getConAnulado() || conDetalle.getConContable().getConPendiente()) {
                retorno = "FNo se ha podido cambiar el número de Cheque\nya que el Contable se ha marcado como pendiente o se ha anulado";
            } else {
                comprobar = operacionesContabilidadDAOTransaccionLocal.modificarConDetalleTO(conDetalle, sisSuceso);
                if (comprobar) {
                    retorno = "TDetalle de Contable modificado";
                } else {
                    retorno = "FOcurrio un error al modificar el Detalle de Contable";
                }
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarConDetalleTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="CONSULTAS">
    @Override
    public java.util.List<contabilidad.TO.ConListaBalanceResultadosVsInventarioTO> getConListaBalanceResultadosVsInventarioTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, String sector) throws java.lang.Exception {
        return operacionesContabilidadDAOLocal.getConListaBalanceResultadosVsInventarioTO(empresa, desde, hasta, sector);
    }

    @Override
    public helper.RetornoTO getBalanceResultadoMensualizado(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {

            java.util.List<contabilidad.TO.ConBalanceResultadosMensualizadosTO> conBalanceResultadosMensualizadosTOs = operacionesContabilidadDAOLocal.getBalanceResultadoMensualizado(empresa, codigoSector, fechaInicio, fechaFin);
            mensaje = "T";
            contabilidad.helper.NumeroColumnaDesconocidadBalanceResultadoMensualizado obj = new contabilidad.helper.NumeroColumnaDesconocidadBalanceResultadoMensualizado();

            obj.agruparCabeceraColumnas(conBalanceResultadosMensualizadosTOs);
            obj.agruparCuentas(conBalanceResultadosMensualizadosTOs);
            obj.llenarObjetoParaTabla(conBalanceResultadosMensualizadosTOs);
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
    // </editor-fold>

    @Override
    public String anularReversarConContable(
            String empresa,
            String periodo,
            String tipo,
            String numero,
            String usuario,
            java.lang.String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "F";
        comprobar = false;
        cartera.entity.CarPagos carPagos = null;
        cartera.entity.CarPagosAnticipos carPagosAnticipos = null;
        cartera.entity.CarCobros carCobros = null;
        cartera.entity.CarCobrosAnticipos carCobrosAnticipos = null;
        List<contabilidad.entity.ConDetalle> conDetalles = new java.util.ArrayList();
        List<rrhh.entity.RhAnticipo> rhAnticipos = new java.util.ArrayList();
        List<rrhh.entity.RhBono> rhBonos = new java.util.ArrayList();
        List<rrhh.entity.RhPrestamo> rhPrestamos = new java.util.ArrayList();
        List<rrhh.entity.RhRol> rhRols = new java.util.ArrayList();
        List<rrhh.entity.RhVacaciones> rhVacacioneses = new java.util.ArrayList();
        List<rrhh.entity.RhViatico> rhViaticos = new java.util.ArrayList();



        try {
            if (operacionesContabilidadDAOLocal.swCobrosAnticiposEliminar(empresa, periodo, tipo, numero)) {
                //periodo
                List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(empresa);
                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (periodo.equals(sisListaPeriodoTO.getPerCodigo())
                            && sisListaPeriodoTO.getPerCerrado() == false) {
                        comprobar = true;
                        break;
                    }
                }
                if (comprobar) {
                    contabilidad.entity.ConContable conContable = operacionesContabilidadDAOLocal.buscarContable(empresa, periodo, tipo, numero);
                    if (conContable != null) {
                        Boolean reversar = false;
                        if (tipo.equals("C-PAG") && (accion.equals("ANULAR") || accion.equals("REVERSAR"))) {
                            reversar = operacionesCarDAOLocal.getCarReversarPago(empresa, periodo, numero);
                            carPagos = cartera.helper.ConversionesCar.convertirCarPagos_CarPagos(operacionesCarDAOLocal.buscarCarPagos(empresa, periodo, tipo, numero));
                            carPagos.setCarPagosPK(new CarPagosPK(empresa, periodo, tipo, numero));
                            carPagos.setPagReversado(true);
                        }
                        if ((tipo.equals("C-APRO") || tipo.equals("C-PAG")) && (accion.equals("ANULARANTICIPO") || accion.equals("REVERSARANTICIPO"))) {

                            reversar = operacionesCarDAOLocal.getCarReversarPagoAnticipos(empresa, periodo, numero);
                            carPagosAnticipos = cartera.helper.ConversionesCar.convertirCarPagosAnticipos_CarPagosAnticipos(operacionesCarDAOLocal.buscarCarPagosAnticipos(empresa, periodo, tipo, numero));
                            carPagosAnticipos.setCarPagosAnticiposPK(new CarPagosAnticiposPK(empresa, periodo, tipo, numero));
                            carPagosAnticipos.setAntReversado(true);
                        }
                        if (tipo.equals("C-COB") && (accion.equals("ANULAR") || accion.equals("REVERSAR"))) {
                            reversar = operacionesCarDAOLocal.getCarReversarCobro(empresa, periodo, numero);
                            carCobros = cartera.helper.ConversionesCar.convertirCarCobros_CarCobros(operacionesCarDAOLocal.buscarCarCobros(empresa, periodo, tipo, numero));
                            carCobros.setCarCobrosPK(new CarCobrosPK(empresa, periodo, tipo, numero));
                            carCobros.setCobReversado(true);
                        }
                        if ((tipo.equals("C-ACLI") || tipo.equals("C-COB")) && (accion.equals("ANULARANTICIPO") || accion.equals("REVERSARANTICIPO"))) {
                            reversar = operacionesCarDAOLocal.getCarReversarCobroAnticipos(empresa, periodo, numero);
                            carCobrosAnticipos = cartera.helper.ConversionesCar.convertirCarCobrosAnticipos_CarCobrosAnticipos(operacionesCarDAOLocal.buscarCarCobrosAnticipos(empresa, periodo, tipo, numero));
                            carCobrosAnticipos.setCarCobrosAnticiposPK(new CarCobrosAnticiposPK(empresa, periodo, tipo, numero));
                            carCobrosAnticipos.setAntReversado(true);
                        }
                        if (tipo.equals("C-ANT")) {
                            rrhh.entity.RhAnticipo rhAnticipo = null;
                            List<rrhh.TO.RhAnticipoTO> rhAnticipoTOs = operacionesRRHHDAOLocal.getRhAnticipo(empresa, periodo, numero);
                            for (rrhh.TO.RhAnticipoTO rhAnticipoTO : rhAnticipoTOs) {
                                reversar = rhAnticipoTO.getReversar();
                                rhAnticipo = rrhh.helper.ConversionesRRHH.convertirRhAnticipoTO_RhAnticipo(rhAnticipoTO);
                                rhAnticipo.setSecEmpresa(empresa);
                                rhAnticipo.setConEmpresa(empresa);
                                rhAnticipo.setConPeriodo(periodo);
                                rhAnticipo.setConTipo(tipo);
                                rhAnticipo.setConNumero(numero);
                                rhAnticipo.setRhEmpleado(operacionesRRHHDAOLocal.buscarEmpleado(
                                        empresa, rhAnticipoTO.getEmpId()));
                                rhAnticipo.setAntReversado(true);
                                rhAnticipos.add(rhAnticipo);
                            }
                        }
                        if (tipo.equals("C-BON")) {
                            rrhh.entity.RhBono rhBono = null;
                            List<rrhh.TO.RhBonoTO> rhBonoTOs = operacionesRRHHDAOLocal.getRhBono(empresa, periodo, numero);
                            for (rrhh.TO.RhBonoTO rhBonoTO : rhBonoTOs) {
                                reversar = rhBonoTO.getReversar();
                                rhBono = rrhh.helper.ConversionesRRHH.convertirRhBonoTO_RhBono(rhBonoTO);
                                rhBono.setSecEmpresa(empresa);
                                rhBono.setPisEmpresa(empresa);
                                rhBono.setPisSector(rhBono.getSecCodigo());
                                rhBono.setConEmpresa(empresa);
                                rhBono.setConPeriodo(periodo);
                                rhBono.setConTipo(tipo);
                                rhBono.setConNumero(numero);
                                rhBono.setRhEmpleado(operacionesRRHHDAOLocal.buscarEmpleado(
                                        empresa, rhBonoTO.getEmpId()));
                                rhBono.setBonoReversado(true);
                                rhBonos.add(rhBono);
                            }
                        }
                        if (tipo.equals("C-PRE")) {
                            rrhh.entity.RhPrestamo rhPrestamo = null;
                            List<rrhh.TO.RhPrestamoTO> rhPrestamoTOs = operacionesRRHHDAOLocal.getRhPrestamo(empresa, periodo, numero);
                            for (rrhh.TO.RhPrestamoTO rhPrestamoTO : rhPrestamoTOs) {
                                reversar = rhPrestamoTO.getReversar();
                                rhPrestamo = rrhh.helper.ConversionesRRHH.convertirRhPrestamoTO_RhPrestamo(rhPrestamoTO);
                                rhPrestamo.setSecEmpresa(empresa);
                                rhPrestamo.setConEmpresa(empresa);
                                rhPrestamo.setConPeriodo(periodo);
                                rhPrestamo.setConTipo(tipo);
                                rhPrestamo.setConNumero(numero);
                                rhPrestamo.setRhEmpleado(operacionesRRHHDAOLocal.buscarEmpleado(
                                        empresa, rhPrestamoTO.getEmpId()));
                                rhPrestamo.setPreReversado(true);
                                rhPrestamos.add(rhPrestamo);
                            }
                        }
                        if (tipo.equals("C-ROL")) {
                            rrhh.entity.RhRol rhRol = null;
                            List<rrhh.TO.RhRolBDTO> rhRolTOs = operacionesRRHHDAOLocal.getRhRol(empresa, periodo, numero);
                            for (rrhh.TO.RhRolBDTO rhRolTO : rhRolTOs) {
                                reversar = rhRolTO.getRolReversado();
                                rhRol = ConversionesRRHH.convertirRhRolBDTO_RhRol(rhRolTO);
                                rhRol.setRhEmpleado(new rrhh.entity.RhEmpleado(
                                        empresa,
                                        rhRolTO.getEmpId()));
                                rhRol.setConProvisionEmpresa(empresa);
                                rhRol.setSecEmpresa(empresa);
                                rhRol.setConEmpresa(empresa);
                                rhRol.setConPeriodo(periodo);
                                rhRol.setConTipo(tipo);
                                rhRol.setConNumero(numero);
                                rhRol.setRhEmpleado(operacionesRRHHDAOLocal.buscarEmpleado(
                                        empresa, rhRolTO.getEmpId()));
                                rhRol.setRolReversado(true);
                                rhRols.add(rhRol);
                            }
                        }
                        if (tipo.equals("C-PRO")) {
                            rrhh.entity.RhRol rhRol = null;
                            List<rrhh.TO.RhListaProvisionesTO> rhListaProvisionesTOs = operacionesRRHHDAOLocal.getRhListaProvisionesComprobanteContableTO(empresa, periodo, tipo, numero);
                            for (rrhh.TO.RhListaProvisionesTO rhListaProvisionesTO : rhListaProvisionesTOs) {
                                Integer secuencial = rhListaProvisionesTO.getProvSecuencial();
                                reversar = rhListaProvisionesTOs.size() == 1;
                                if (secuencial != null) {
                                    rhRol = rrhh.helper.ConversionesRRHH.convertirRhRol_RhRol(operacionesRRHHDAOLocal.buscarRol(secuencial));
                                    rhRol.setRhEmpleado(new rrhh.entity.RhEmpleado(
                                            empresa,
                                            rhListaProvisionesTO.getProvId()));
                                    rhRol.setRhEmpleado(operacionesRRHHDAOLocal.buscarEmpleado(
                                            empresa, rhListaProvisionesTO.getProvId()));
                                    rhRol.setConProvisionEmpresa(null);
                                    rhRol.setConProvisionPeriodo(null);
                                    rhRol.setConProvisionTipo(null);
                                    rhRol.setConProvisionNumero(null);
                                    rhRols.add(rhRol);
                                }
                            }
                        }
                        if (tipo.equals("C-VAC")) {
                            rrhh.entity.RhVacaciones rhVacaciones = null;
                            List<rrhh.TO.RhVacacionesTO> rhVacacionesTOs = operacionesRRHHDAOLocal.getRhVacaciones(empresa, periodo, numero);
                            for (rrhh.TO.RhVacacionesTO rhVacacionesTO : rhVacacionesTOs) {
                                reversar = rhVacacionesTO.getReversar();
                                rhVacaciones = rrhh.helper.ConversionesRRHH.convertirRhVacacionesTO_RhVacaciones(rhVacacionesTO);
                                rhVacaciones.setSecEmpresa(empresa);
                                rhVacaciones.setConEmpresa(empresa);
                                rhVacaciones.setConPeriodo(periodo);
                                rhVacaciones.setConTipo(tipo);
                                rhVacaciones.setConNumero(numero);
                                rhVacaciones.setRhEmpleado(operacionesRRHHDAOLocal.buscarEmpleado(
                                        empresa, rhVacacionesTO.getEmpId()));
                                rhVacaciones.setVacReversado(true);
                                rhVacacioneses.add(rhVacaciones);
                            }
                        }
                        if (tipo.equals("C-VIA")) {
                            rrhh.entity.RhViatico rhViatico = null;
                            List<rrhh.TO.RhViaticoTO> rhViaticoTOs = operacionesRRHHDAOLocal.getRhViatico(empresa, periodo, numero);
                            for (rrhh.TO.RhViaticoTO rhViaticoTO : rhViaticoTOs) {
                                reversar = rhViaticoTO.getReversar();
                                rhViatico = rrhh.helper.ConversionesRRHH.convertirRhViaticoTO_RhViatico(rhViaticoTO);
                                rhViatico.setSecEmpresa(empresa);
                                rhViatico.setConEmpresa(empresa);
                                rhViatico.setConPeriodo(periodo);
                                rhViatico.setConTipo(tipo);
                                rhViatico.setConNumero(numero);
                                rhViatico.setRhEmpleado(operacionesRRHHDAOLocal.buscarEmpleado(
                                        empresa, rhViaticoTO.getEmpId()));
                                rhViatico.setViaReversado(true);
                                rhViaticos.add(rhViatico);
                            }
                        }
                        if (accion.equals("REVERSAR") || accion.equals("REVERSARANTICIPO")) {
                            if (reversar) {
                                retorno = "TEl contable:\n " + periodo + " | " + tipo + " | " + numero + "\nYa fué reversado";
                            } else {
                                if (rhAnticipos.size() > 1 || rhBonos.size() > 1 || rhPrestamos.size() > 1 || rhVacacioneses.size() > 1 || rhViaticos.size() > 1) {
                                    retorno = "TEl contable:\n " + periodo + " | " + tipo + " | " + numero + "\nNo se puede reversar porque esta por lote";
                                } else {
                                    List<contabilidad.TO.ConDetalleTO> conDetalleTOs = operacionesContabilidadDAOLocal.getConDetalleTO(empresa, periodo, tipo, numero);
                                    contabilidad.entity.ConDetalle conDetalle = null;
                                    int contador = 0;
                                    for (int i = 0; i < conDetalleTOs.size(); i++) {
                                        conDetalle = ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTOs.get(i));
                                        conDetalle.setPisNumero(conDetalleTOs.get(i).getPisNumero() != null ? conDetalleTOs.get(i).getPisNumero() : null);
                                        if (contador == 1) {
                                            conDetalle.setDetDebitoCredito(conDetalleTOs.get(i).getDetDebitoCredito() == 'D' ? 'C' : 'D');
                                            conDetalle.setDetReferencia("R" + conDetalleTOs.get(i).getDetReferencia());
                                            conDetalle.setDetReferencia(conDetalle.getDetReferencia().length() > 7
                                                    ? conDetalle.getDetReferencia().substring(0, 7)
                                                    : conDetalle.getDetReferencia());
                                            conDetalle.setDetOrden(conDetalleTOs.get(i).getDetOrden() + conDetalleTOs.size());
                                            conDetalle.setDetSecuencia(0);
                                            if (i == conDetalleTOs.size()) {
                                                i = conDetalleTOs.size();
                                            }
                                        }
                                        if (i != conDetalleTOs.size()) {
                                            conDetalle.setConContable(conContable);
                                            conDetalle.setConCuentas(new ConCuentas(new ConCuentasPK(empresa, conDetalleTOs.get(i).getConCtaCodigo())));
                                            conDetalles.add(conDetalle);
                                            if ((i == conDetalleTOs.size() - 1) && (contador == 0)) {
                                                i = -1;
                                                contador = 1;
                                            }
                                        }
                                    }

                                    ///////////////NUEVO SUCESO PARA CONTABLE
                                    susClave = periodo + " " + tipo + " " + numero;
                                    susDetalle = "Se reversó el contable del periodo " + periodo
                                            + ", del tipo " + tipo
                                            + ", de la numeración " + numero;
                                    susSuceso = "DELETE";
                                    susTabla = "contabilidad.con_contable";
                                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                            susTabla,
                                            susClave,
                                            susSuceso,
                                            susDetalle,
                                            sisInfoTO);
                                    comprobar = operacionesContabilidadDAOTransaccionLocal.anularReversarConContable(
                                            null,
                                            conDetalles,
                                            carPagos,
                                            carPagosAnticipos,
                                            carCobros,
                                            carCobrosAnticipos,
                                            rhAnticipos,
                                            rhBonos,
                                            rhPrestamos,
                                            rhRols,
                                            rhVacacioneses,
                                            rhViaticos,
                                            sisSuceso);
                                    if (comprobar) {
                                        retorno = "TEl contable:\n " + periodo + " | " + tipo + " | " + numero + "\nSe reversó correctamente";
                                    } else {
                                        retorno = "FOcurrio un error al anular el contable:\n " + periodo + " | " + tipo + " | " + numero;
                                    }
                                }
                            }
                        }
                        if (accion.equals("ANULAR") || accion.equals("ANULARANTICIPO")) {
                            if (conContable.getConAnulado() == true) {
                                retorno = "TEl contable:\n " + periodo + " | " + tipo + " | " + numero + "\nYa fué anulado";
                            } else {
                                contabilidad.entity.ConContable conContableAux = ConversionesContabilidad.convertirConContable_ConContable(conContable);
                                conContableAux.setConContablePK(new contabilidad.entity.ConContablePK(empresa, periodo, tipo, numero));
                                conContableAux.setConAnulado(true);
                                ///////////////NUEVO SUCESO PARA CONTABLE
                                susClave = periodo + " " + tipo + " " + numero;
                                susDetalle = "Se anuló el contable del periodo " + periodo
                                        + ", del tipo " + tipo
                                        + ", de la numeración " + numero;
                                susSuceso = "DELETE";
                                susTabla = "contabilidad.con_contable";
                                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                        susTabla,
                                        susClave,
                                        susSuceso,
                                        susDetalle,
                                        sisInfoTO);
                                comprobar = operacionesContabilidadDAOTransaccionLocal.anularReversarConContable(
                                        conContableAux,
                                        conDetalles,
                                        carPagos,
                                        carPagosAnticipos,
                                        carCobros,
                                        carCobrosAnticipos,
                                        rhAnticipos,
                                        rhBonos,
                                        rhPrestamos,
                                        rhRols,
                                        rhVacacioneses,
                                        rhViaticos,
                                        sisSuceso);
                                if (comprobar) {
                                    retorno = "TEl contable:\n " + periodo + " | " + tipo + " | " + numero + "\nSe anuló correctamente";
                                } else {
                                    retorno = "FOcurrio un error al anular el contable:\n " + periodo + " | " + tipo + " | " + numero;
                                }
                            }
                        }
                    } else {
                        retorno = "FNo se encontro el contable..";
                    }
                } else {
                    retorno = "FElperiodo está cerrado...";
                }
            } else {
                retorno = "FNo se puede anular un contable que es utilizado en otro contable";
            }
        } catch (Exception e) {
            retorno = "FOcurrió un error al guardar el contable, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "anularConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    @Override
    public String desbloquearConContable(
            String empresa,
            String periodo,
            String tipo,
            String numero,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "F";
        comprobar = false;
        try {
            contabilidad.entity.ConContable conContable = operacionesContabilidadDAOLocal.buscarContable(empresa, periodo, tipo, numero);
            if (conContable != null) {
                if (!conContable.getConBloqueado()) {
                    retorno = "TEl contable:\n " + periodo + " | " + tipo + " | " + numero + "\nYa fué desbloqueado";
                } else {
                    if (conContable.getConAnulado()) {
                        retorno = "TEl contable:\n " + periodo + " | " + tipo + " | " + numero + "\nEstá anulado";
                    } else {
                        if (conContable.getConPendiente()) {
                            retorno = "TEl contable:\n " + periodo + " | " + tipo + " | " + numero + "\nEstá pendiente";
                        } else {
                            contabilidad.entity.ConContable conContableAux = ConversionesContabilidad.convertirConContable_ConContable(conContable);
                            conContableAux.setConContablePK(new contabilidad.entity.ConContablePK(empresa, periodo, tipo, numero));
                            conContableAux.setConBloqueado(false);
                            ///////////////NUEVO SUCESO PARA CONTABLE
                            susClave = periodo + "|" + tipo + "|" + numero;
                            susDetalle = "Se desbloqueó el contable del periodo " + periodo
                                    + ", del tipo " + tipo
                                    + ", de la numeración " + numero;
                            susSuceso = "DELETE";
                            susTabla = "contabilidad.con_contable";
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            comprobar = operacionesContabilidadDAOTransaccionLocal.anularConContable(conContableAux, sisSuceso);
                            if (comprobar) {
                                retorno = "TEl contable:\n " + periodo + " | " + tipo + " | " + numero + "\nSe desbloqueó";
                            } else {
                                retorno = "FOcurrio un error al desbloquear el contable:\n " + periodo + " | " + tipo + " | " + numero;
                            }
                        }
                    }
                }
            } else {
                retorno = "FNo se encontro el contable..";
            }
        } catch (Exception e) {
            retorno = "FOcurrió un error al guardar el contable, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "bloquearConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String restaurarConContable(
            String empresa,
            String periodo,
            String tipo,
            String numero,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "F";
        comprobar = false;
        try {
            contabilidad.entity.ConContable conContable = operacionesContabilidadDAOLocal.buscarContable(empresa, periodo, tipo, numero);
            if (conContable != null) {
                String estadoPeriodo = operacionesSistemaBusinessLocal.estadoPeriodo(empresa, Validacion.fecha(conContable.getConFecha(), "yyyy-MM-dd"));
                if (estadoPeriodo.isEmpty()) {
                    if (conContable.getConGenerado()) {
                        retorno = "T<html>El contable: <font size = 5>" + periodo + " | " + tipo + " | " + numero + "</font> es GENERADO, y no puede ser RESTAURADO."
                                + "<br><br>Para RESTAURAR debe de hacerlo en el módulo correspondiente.</html>";
                    } else {
                        if (conContable.getConBloqueado()) {
                            retorno = "T<html>El contable: <font size = 5>" + periodo + " | " + tipo + " | " + numero + "</font> está bloqueado</html>";
                        } else {
                            if (!conContable.getConAnulado()) {
                                retorno = "T<html>El contable: <font size = 5>" + periodo + " | " + tipo + " | " + numero + "</font> no está anulado</html>";
                            } else {
                                contabilidad.entity.ConContable conContableAux = ConversionesContabilidad.convertirConContable_ConContable(conContable);
                                conContableAux.setConContablePK(new contabilidad.entity.ConContablePK(empresa, periodo, tipo, numero));
                                conContableAux.setConAnulado(false);
                                ///////////////NUEVO SUCESO PARA CONTABLE
                                susClave = periodo + "|" + tipo + "|" + numero;
                                susDetalle = "Se restauró el contable del periodo " + periodo
                                        + ", del tipo " + tipo
                                        + ", de la numeración " + numero;
                                susSuceso = "RESTORE";
                                susTabla = "contabilidad.con_contable";
                                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                        susTabla,
                                        susClave,
                                        susSuceso,
                                        susDetalle,
                                        sisInfoTO);
                                comprobar = operacionesContabilidadDAOTransaccionLocal.anularConContable(conContableAux, sisSuceso);
                                if (comprobar) {
                                    retorno = "T<html>El contable: <font size = 5>" + periodo + " | " + tipo + " | " + numero + "</font> se restauró</html>";
                                } else {
                                    retorno = "F<html>Ocurrio un error al restaurar el contable: <font size = 5>" + periodo + " | " + tipo + " | " + numero + "</font></html>";
                                }
                            }
                        }
                    }
                } else {
                    retorno = "F" + estadoPeriodo;
                }
            } else {
                retorno = "FNo se encontro el contable..";
            }
        } catch (Exception e) {
            retorno = "FOcurrió un error al guardar el contable, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "bloquearConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    @Override
    public java.util.List<contabilidad.TO.ConFunContablesVerificacionesTO> getFunContablesVerificacionesTO(
            String empresa) throws Exception {
        return operacionesContabilidadDAOLocal.getFunContablesVerificacionesTO(empresa);
    }

    @Override
    public helper.RetornoTO getFunContabilizarTransferencias(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            String parametro,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        java.util.List<String> mensajeConError = new java.util.ArrayList();
        helper.RetornoTO retornoTO = new helper.RetornoTO();
        try {

            java.util.List<contabilidad.TO.ConFunContabilizarTransferenciasTO> conFunContabilizarTransferenciasTOs = operacionesContabilidadDAOLocal.getFunContabilizarTransferencias(empresa, codigoSector, fechaInicio, fechaFin, parametro);

            int contadorEncuentraValido = 0;
            for (int i = 0; i < conFunContabilizarTransferenciasTOs.size(); i++) {
                if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() != null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() != null) {
                    contadorEncuentraValido = i;
                    i = conFunContabilizarTransferenciasTOs.size();
                } else {
                    if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() == null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() != null) {
                        mensajeConError.add("No existe cuenta del DÉBITO para el producto " + conFunContabilizarTransferenciasTOs.get(i).
                                getCostoCodigo() + " | " + (conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().substring(
                                conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().indexOf("|") + 1)) + " en la PISCINA "
                                + conFunContabilizarTransferenciasTOs.get(i).getCostoSectorPiscina());
                    }

                    if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() != null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() == null) {
                        mensajeConError.add("No existe cuenta del CRÉDITO para el producto " + conFunContabilizarTransferenciasTOs.get(i).
                                getCostoCodigo() + " | " + (conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().substring(
                                conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().indexOf("|") + 1)));
                    }
                }
            }

            java.util.List<contabilidad.TO.ConDetalleTO> conDetalleTOs = new java.util.ArrayList();
            java.util.List<String> sectorPiscina = validaciones.Validacion.separar(conFunContabilizarTransferenciasTOs.get(contadorEncuentraValido).getCostoSectorPiscina(), "|");
            //////////// revisar 
            conDetalleTOs.add(new contabilidad.TO.ConDetalleTO(
                    "", //empCodigo
                    conFunContabilizarTransferenciasTOs.get(contadorEncuentraValido).getCostoFecha(),//perCodigo 
                    "", //tipCodigo
                    "", //conNumero
                    0,  //detSecuencia
                    conFunContabilizarTransferenciasTOs.get(contadorEncuentraValido).getCostoCuentaD(),//conCtaCodigo
                    codigoSector, //secCodigo
                    null,//pisSector
                    sectorPiscina.get(1), //pisNumero
                    "", //detDocumento
                    'D', //detDebitoCredito
                    conFunContabilizarTransferenciasTOs.get(contadorEncuentraValido).getCostoTotal(),
                    true, 
                    "", 
                    "", 
                    0, 
                    new BigDecimal("0.00")));

            int contador = contadorEncuentraValido;
            boolean encontro = false;
            //ESTO ES PARA EL DEBITO
            for (int i = contadorEncuentraValido + 1; i < conFunContabilizarTransferenciasTOs.size(); i++) {
                contador = 0;
                if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() != null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() != null) {
                    for (contabilidad.TO.ConDetalleTO conDetalleTO : conDetalleTOs) {
                        if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD().equals(conDetalleTO.getConCtaCodigo())
                                && conFunContabilizarTransferenciasTOs.get(i).getCostoFecha().equals(conDetalleTO.getPerCodigo())) {
                            encontro = true;
                            break;
                        } else {
                            encontro = false;
                            contador++;
                        }
                    }
                } else {
                    encontro = false;
                }

                if (encontro) {
                    conDetalleTOs.get(contador).setDetValor(conDetalleTOs.get(contador).getDetValor().add(conFunContabilizarTransferenciasTOs.get(i).getCostoTotal()));
                } else {
                    if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() != null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() != null) {
                        sectorPiscina = validaciones.Validacion.separar(conFunContabilizarTransferenciasTOs.get(i).getCostoSectorPiscina(), "|");
                        // revisar 2015-09-18
                        conDetalleTOs.add(new contabilidad.TO.ConDetalleTO(
                                "", 
                                conFunContabilizarTransferenciasTOs.get(i).getCostoFecha(), 
                                "", 
                                "",
                                0, 
                                conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD(),
                                codigoSector, 
                                null,
                                sectorPiscina.get(1), 
                                "", 
                                'D', 
                                conFunContabilizarTransferenciasTOs.get(i).getCostoTotal(),
                                true, 
                                "", 
                                "", 
                                0, 
                                new BigDecimal("0.00")));
                    } else {
                        if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() == null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() != null) {
                            mensajeConError.add("No existe cuenta del DÉBITO para el producto " + conFunContabilizarTransferenciasTOs.get(i).
                                    getCostoCodigo() + " | " + (conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().substring(
                                    conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().indexOf("|") + 1)) + " en la PISCINA "
                                    + conFunContabilizarTransferenciasTOs.get(i).getCostoSectorPiscina());
                        }

                        if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() != null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() == null) {
                            mensajeConError.add("No existe cuenta del CRÉDITO para el producto " + conFunContabilizarTransferenciasTOs.get(i).
                                    getCostoCodigo() + " | " + (conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().substring(
                                    conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().indexOf("|") + 1)));
                        }
                    }
                }
            }


            ////ESTO ES PARA CREDITO
            contadorEncuentraValido = 0;
            for (int i = 1; i < conFunContabilizarTransferenciasTOs.size(); i++) {
                if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() != null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() != null) {
                    contadorEncuentraValido = i;
                    i = conFunContabilizarTransferenciasTOs.size();
                } else {
                    if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() == null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() != null) {
                        mensajeConError.add("No existe cuenta del DÉBITO para el producto " + conFunContabilizarTransferenciasTOs.get(i).
                                getCostoCodigo() + " | " + (conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().substring(
                                conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().indexOf("|") + 1)) + " en la PISCINA "
                                + conFunContabilizarTransferenciasTOs.get(i).getCostoSectorPiscina());
                    }

                    if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() != null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() == null) {
                        mensajeConError.add("No existe cuenta del CRÉDITO para el producto " + conFunContabilizarTransferenciasTOs.get(i).
                                getCostoCodigo() + " | " + (conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().substring(
                                conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().indexOf("|") + 1)));
                    }
                }
            }
            // revisar 2015-09-18
            conDetalleTOs.add(new contabilidad.TO.ConDetalleTO(
                    "", 
                    conFunContabilizarTransferenciasTOs.get(contadorEncuentraValido).getCostoFecha(), 
                    "", 
                    "",
                    0, 
                    conFunContabilizarTransferenciasTOs.get(contadorEncuentraValido).getCostoCuentaC(),
                    codigoSector, 
                    null, 
                    null,
                    "", 
                    'C', 
                    conFunContabilizarTransferenciasTOs.get(contadorEncuentraValido).getCostoTotal(),
                    true, 
                    "", 
                    "", 
                    0, 
                    new BigDecimal("0.00")));

            contador = contadorEncuentraValido;
            encontro = false;
            for (int i = contadorEncuentraValido + 1; i < conFunContabilizarTransferenciasTOs.size(); i++) {
                contador = 0;
                if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() != null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() != null) {
                    for (contabilidad.TO.ConDetalleTO conDetalleTO : conDetalleTOs) {
                        if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC().equals(conDetalleTO.getConCtaCodigo())
                                && conFunContabilizarTransferenciasTOs.get(i).getCostoFecha().equals(conDetalleTO.getPerCodigo())) {
                            encontro = true;
                            break;
                        } else {
                            encontro = false;
                            contador++;
                        }
                    }
                } else {
                    encontro = false;
                }

                if (encontro) {
                    conDetalleTOs.get(contador).setDetValor(conDetalleTOs.get(contador).getDetValor().add(conFunContabilizarTransferenciasTOs.get(i).getCostoTotal()));
                } else {
                    if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() != null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() != null) {
                        conDetalleTOs.add(new contabilidad.TO.ConDetalleTO(
                                "", 
                                conFunContabilizarTransferenciasTOs.get(i).getCostoFecha(), 
                                "", 
                                "",
                                0, 
                                conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC(),
                                codigoSector, 
                                null, 
                                null,
                                "", 
                                'C', 
                                conFunContabilizarTransferenciasTOs.get(i).getCostoTotal(),
                                true, 
                                "", 
                                "", 
                                0, 
                                new BigDecimal("0.00")));
                    } else {
                        if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() == null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() != null) {
                            mensajeConError.add("No existe cuenta del DÉBITO para el producto " + conFunContabilizarTransferenciasTOs.get(i).
                                    getCostoCodigo() + " | " + (conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().substring(
                                    conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().indexOf("|") + 1)) + " en la PISCINA "
                                    + conFunContabilizarTransferenciasTOs.get(i).getCostoSectorPiscina());
                        }

                        if (conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD() != null && conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC() == null) {
                            mensajeConError.add("No existe cuenta del CRÉDITO para el producto " + conFunContabilizarTransferenciasTOs.get(i).
                                    getCostoCodigo() + " | " + (conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().substring(
                                    conFunContabilizarTransferenciasTOs.get(i).getCostoProducto().toString().indexOf("|") + 1)));
                        }
                    }
                }
            }
            mensaje = "T";
            contabilidad.helper.NumeroColumnaDesconocidadContabilizarTransferencias obj = new contabilidad.helper.NumeroColumnaDesconocidadContabilizarTransferencias();
            obj.agruparCabeceraColumnas(conFunContabilizarTransferenciasTOs);
            obj.agruparProductos(conFunContabilizarTransferenciasTOs);
            obj.llenarObjetoParaTabla(conFunContabilizarTransferenciasTOs);
            retornoTO.setColumnasFaltantes(obj.getColumnasFaltantes());
            retornoTO.setColumnas(obj.getColumnas());
            retornoTO.setDatos(obj.getDatos());
            retornoTO.setConDetalleTO(mensajeConError.isEmpty() ? conDetalleTOs : new java.util.ArrayList());
            retornoTO.setMensajeConError(mensajeConError);
        } catch (Exception e) {
            comprobar = false;
            mensaje = "FOcurrió un error al obtener los datos de la Base de Datos. \nContacte con el administrador...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getFunContabilizarTransferencias",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            retornoTO.setMensaje(mensaje);
            return retornoTO;
        }
    }

    public inventario.TO.MensajeTO getListaInvConsultaConsumosPendientes(
            String empCodigo,
            String fechaDesde,
            String fechaHasta) throws Exception {
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        List<String> listaMensajes = new ArrayList();
        String mensajeAux = "";
        try {
            List<contabilidad.TO.InvListaConsultaConsumosTO> listaConsultaConsumosTOs = operacionesContabilidadDAOLocal.getListaInvConsultaConsumosPendientes(empCodigo, fechaDesde, fechaHasta);
            if (!listaConsultaConsumosTOs.isEmpty()) {
                listaMensajes.add("No se puede generar los contables, existen los siguientes consumos pendientes :");
                for (InvListaConsultaConsumosTO invListaConsultaConsumosTO : listaConsultaConsumosTOs) {
                    listaMensajes.add("Fecha    : " + invListaConsultaConsumosTO.getConsFecha());
                    listaMensajes.add("Motivo   : " + invListaConsultaConsumosTO.getConsMotivo());
                    listaMensajes.add("Número   : " + invListaConsultaConsumosTO.getConsNumero());
                    listaMensajes.add("Periodo  : " + invListaConsultaConsumosTO.getConsPeriodo());
                    listaMensajes.add("");
                }
                mensajeAux = "F<html>Existen consumos pendientes.</html>";
                mensajeTO.setListaMensajes(listaMensajes);
            } else {
                mensajeAux = "T<html>No existen consumos pendientes.</html>";
            }

        } catch (Exception e) {
            mensajeAux = "FOcurrió un error al obtener los datos de la Base de Datos. \nContacte con el administrador...";
        } finally {
            mensajeTO.setMensaje(mensajeAux);
            return mensajeTO;
        }
        //return operacionesContabilidadDAOLocal.getListaInvConsultaConsumosPendientes(empCodigo, fechaDesde, fechaHasta);

    }

    @Override
    public inventario.TO.MensajeTO insertarConContableAgrupado(
            List<ConContableTO> conContableTO,
            List<List<ConDetalleTO>> listaConDetalleTO,
            String fechaDesde,
            String fechaHasta,
            sistema.TO.SisInfoTO sisInfoTO,
            String conSector) throws Exception {
        comprobar = false;
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        java.util.List<String> mensaje = new java.util.ArrayList(1);
        String mensajeAux = "";
        boolean periodoCerrado = false;
        try {
            java.util.List<SisSuceso> sisSucesos = new java.util.ArrayList(1);
            java.util.List<SisSuceso> sisSucesosModificar = new java.util.ArrayList(1);
            java.util.List<SisSuceso> sisSucesosModificarAux = new java.util.ArrayList(1);
            List<SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();
            List<contabilidad.TO.ConContableTO> listaConContableTOs = new ArrayList();
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(conContableTO.get(0).getEmpCodigo());

            ///validamos el periodo de cada contable
            for (int i = 0; i < conContableTO.size(); i++) {
                for (SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (Validacion.fecha(conContableTO.get(i).getConFecha(), "yyyy-MM-dd").getTime()
                            >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && Validacion.fecha(conContableTO.get(i).getConFecha(), "yyyy-MM-dd").getTime()
                            <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                        comprobar = true;

                        conContableTO.get(i).setPerCodigo(sisListaPeriodoTO.getPerCodigo());
                        periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                    }
                }
                if (comprobar) {
                    if (periodoCerrado) {
                        mensaje.add("Se intenta generar un contable de fecha: " + conContableTO.get(i).getConFecha() + " pero el periodo se encuentra cerrado");
                    }
                } else {
                    mensaje.add("Se intenta generar un contable de fecha: " + conContableTO.get(i).getConFecha() + " pero el periodo no existe");
                }
            }

            List<List<ConDetalle>> listConDetalles = new ArrayList(0);
            List<List<ConDetalle>> listConDetallesModificars = new ArrayList(0);
            List<List<ConDetalle>> listConDetallesEliminars = new ArrayList(0);
            List<List<ConDetalle>> listConDetallesReversar = new ArrayList(0);
            java.util.List<ConContable> conContables = new java.util.ArrayList(1);
            java.util.List<ConContable> conContablesModificar = new java.util.ArrayList(1);
            java.util.List<ConContable> conContablesReversar = new java.util.ArrayList(1);
            java.util.List<ConNumeracion> conNumeracions = new java.util.ArrayList(1);


            if (mensaje.isEmpty()) {
                ///validamos si el tipo de contable existe en cada posicion
                listaConContableTOs = operacionesContabilidadDAOLocal.listaContableTrasferenciaPorPeriodoFecha(
                        conContableTO.get(0).getEmpCodigo(),
                        conContableTO.get(0).getTipCodigo(),
                        conContableTO.get(0).getConConcepto(),
                        fechaDesde,
                        fechaHasta,
                        conSector);
                for (int j = 0; j < conContableTO.size(); j++) {
                    String numerContableModificar = operacionesContabilidadDAOLocal.buscarContableTrasferencia(
                            conContableTO.get(j).getEmpCodigo(),
                            conContableTO.get(j).getTipCodigo(),
                            conContableTO.get(j).getConConcepto(),
                            conContableTO.get(j).getConFecha(),
                            conSector);
                    for (int i = 0; i < listaConContableTOs.size(); i++) {
                        if (listaConContableTOs.get(i).getConNumero().equals(numerContableModificar)) {
                            listaConContableTOs.remove(i);
                        }
                    }
                }

                for (int i = 0; i < listaConContableTOs.size(); i++) {
                    if (operacionesContabilidadDAOLocal.buscarTipoContable(listaConContableTOs.get(i).getEmpCodigo(), listaConContableTOs.get(i).getTipCodigo())) {
                        susClave = listaConContableTOs.get(i).getPerCodigo() + " "
                                + listaConContableTOs.get(i).getTipCodigo() + " "
                                + listaConContableTOs.get(i).getConNumero();
                        susDetalle = "Se Reversado el contable del periodo " + listaConContableTOs.get(i).getPerCodigo()
                                + ", del tipo contable " + listaConContableTOs.get(i).getTipCodigo()
                                + ", de la numeracion " + listaConContableTOs.get(i).getConNumero();
                        susSuceso = "DELETE";
                        susTabla = "contabilidad.con_contable";
                        //------- CREAMOS EL SUCESO
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        listaConContableTOs.get(i).setUsrFechaInsertaContable(Validacion.fecha(sisSuceso.getSusFecha(), "yyyy-MM-dd HH:mm:ss"));
                        sisSucesosModificarAux.add(sisSuceso);//lista de suscesos
                        ConContable conContableModificar = operacionesContabilidadDAOLocal.buscarContable(
                                listaConContableTOs.get(i).getEmpCodigo(),
                                listaConContableTOs.get(i).getPerCodigo(),
                                listaConContableTOs.get(i).getTipCodigo(),
                                listaConContableTOs.get(i).getConNumero());
                        conContablesReversar.add(conContableModificar);
                        /// GENERAMOS LOS DETALLE DEL CONTABLE
                        List<contabilidad.TO.ConDetalleTO> listaConDetalleReversarTO = operacionesContabilidadDAOLocal.getConDetalleTO(
                                listaConContableTOs.get(i).getEmpCodigo(),
                                listaConContableTOs.get(i).getPerCodigo(),
                                listaConContableTOs.get(i).getTipCodigo(),
                                listaConContableTOs.get(i).getConNumero());
                        ConDetalle conDetalle = null;

                        List<contabilidad.entity.ConDetalle> listConDetalleReversar = new ArrayList(0);
                        int numContable = listaConDetalleReversarTO.size() + 1;
                        for (contabilidad.TO.ConDetalleTO conDetalleTO : listaConDetalleReversarTO) {
                            contabilidad.entity.ConCuentas conCuentas = operacionesContabilidadDAOLocal.buscarCuentas(
                                    conDetalleTO.getEmpCodigo(),
                                    conDetalleTO.getConCtaCodigo());
                            if (conCuentas != null) {
                                conDetalle = new contabilidad.entity.ConDetalle();
                                conDetalleTO.setPerCodigo(listaConContableTOs.get(i).getPerCodigo());

                                conDetalleTO.setDetDebitoCredito(conDetalleTO.getDetDebitoCredito() == 'D' ? 'C' : 'D');
                                conDetalleTO.setDetOrden(numContable++);
                                conDetalleTO.setDetSecuencia(0);

                                conDetalle = contabilidad.helper.ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTO);
                                conDetalle.setConContable(conContableModificar);
                                conDetalle.setConCuentas(conCuentas);
                                listConDetalleReversar.add(conDetalle);
                                //existeCuentaContableDetalle = true;
                            } else {
                                mensajeAux = "F<html>No se encontraron las cuentas contables para modificar en la(s) línea(s) del contable numero " + (i + 1) + ":</html>";
                                mensaje.add(conDetalleTO.getDetOrden().toString() + " - " + conDetalleTO.getConCtaCodigo().toString());
                            }
                        }
                        if (!listConDetalleReversar.isEmpty()) {
                            listConDetallesReversar.add(listConDetalleReversar);
                        }

                    }
                }

                //
                for (int i = 0; i < conContableTO.size(); i++) {
                    if (operacionesContabilidadDAOLocal.buscarTipoContable(conContableTO.get(i).getEmpCodigo(), conContableTO.get(i).getTipCodigo())) {
                        ///// CREANDO UN SUCESO
                        String numerContableModificar = operacionesContabilidadDAOLocal.buscarContableTrasferencia(
                                conContableTO.get(i).getEmpCodigo(),
                                conContableTO.get(i).getTipCodigo(),
                                conContableTO.get(i).getConConcepto(),
                                conContableTO.get(i).getConFecha(),
                                conSector);
                        if (!numerContableModificar.isEmpty()) {
                            susClave = conContableTO.get(i).getPerCodigo() + " "
                                    + conContableTO.get(i).getTipCodigo() + " "
                                    + numerContableModificar;
                            susDetalle = "Se Actualizaron contable del periodo " + conContableTO.get(i).getPerCodigo()
                                    + ", del tipo contable " + conContableTO.get(i).getTipCodigo()
                                    + ", de la numeracion " + numerContableModificar;
                            susSuceso = "UPDATE";
                            susTabla = "contabilidad.con_contable";
                            ///CREA EL SUCESO
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            conContableTO.get(i).setUsrFechaInsertaContable(Validacion.fecha(sisSuceso.getSusFecha(), "yyyy-MM-dd HH:mm:ss"));
                            sisSucesosModificar.add(sisSuceso);

                        } else {
                            susClave = conContableTO.get(i).getPerCodigo() + " "
                                    + conContableTO.get(i).getTipCodigo() + " " + conContableTO.get(i).
                                    getConNumero();
                            susSuceso = "INSERT";
                            susDetalle = "FALTALLENAR";
                            susTabla = "contabilidad.con_contable";
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            conContableTO.get(i).setUsrFechaInsertaContable(Validacion.fecha(sisSuceso.getSusFecha(), "yyyy-MM-dd HH:mm:ss"));
                            sisSucesos.add(sisSuceso);
                        }
                        /////// CREANDO EL CONTABLE PARA MODIFICAR
                        ConDetalle conDetalle = null;
                        if (!numerContableModificar.isEmpty()) {
                            ConContable conContableModificar = operacionesContabilidadDAOLocal.buscarContable(
                                    conContableTO.get(i).getEmpCodigo(),
                                    conContableTO.get(i).getPerCodigo(),
                                    conContableTO.get(i).getTipCodigo(),
                                    numerContableModificar);
                            conContablesModificar.add(conContableModificar);
                            List<contabilidad.TO.ConDetalleTO> listaConDetalleEliminarTO = operacionesContabilidadDAOLocal.getConDetalleTO(
                                    conContableTO.get(i).getEmpCodigo(),
                                    conContableTO.get(i).getPerCodigo(),
                                    conContableTO.get(i).getTipCodigo(),
                                    numerContableModificar);
                            List<contabilidad.entity.ConDetalle> listConDetalleEliminar = new ArrayList(0);
                            int numContable = listaConDetalleEliminarTO.size() + 1;
                            for (contabilidad.TO.ConDetalleTO conDetalleTO : listaConDetalleEliminarTO) {
                                contabilidad.entity.ConCuentas conCuentas = operacionesContabilidadDAOLocal.buscarCuentas(
                                        conDetalleTO.getEmpCodigo(),
                                        conDetalleTO.getConCtaCodigo());
                                if (conCuentas != null) {
                                    conDetalle = new contabilidad.entity.ConDetalle();
                                    conDetalleTO.setPerCodigo(conContableTO.get(i).getPerCodigo());
                                    if (conContableModificar.getConAnulado()) {
                                        conDetalleTO.setDetDebitoCredito(conDetalleTO.getDetDebitoCredito() == 'D' ? 'C' : 'D');
                                        conDetalleTO.setDetOrden(numContable++);
                                        conDetalleTO.setDetSecuencia(0);
                                    }
                                    conDetalle = contabilidad.helper.ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTO);
                                    conDetalle.setConContable(conContableModificar);
                                    conDetalle.setConCuentas(conCuentas);
                                    listConDetalleEliminar.add(conDetalle);
                                } else {
                                    mensajeAux = "F<html>No se encontraron las cuentas contables para modificar en la(s) línea(s) del contable numero " + (i + 1) + ":</html>";
                                    mensaje.add(conDetalleTO.getDetOrden().toString() + " - " + conDetalleTO.getConCtaCodigo().toString());
                                }
                            }

                            if (!listConDetalleEliminar.isEmpty()) {
                                listConDetallesEliminars.add(listConDetalleEliminar);
                            }
                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                            List<ConDetalle> listConDetalleModificar = new ArrayList(0);
                            List<ConDetalleTO> listaDetalleDeLista = listaConDetalleTO.get(i);//esto permite sacar una posicion de la lista en la posicion deseada
                            for (ConDetalleTO conDetalleTO : listaDetalleDeLista) {
                                conDetalle = new ConDetalle();
                                conDetalleTO.setPerCodigo(conContableTO.get(i).getPerCodigo());
                                conDetalle = ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTO);
                                conDetalle.setConContable(conContableModificar);
                                contabilidad.entity.ConCuentas conCuentas = operacionesContabilidadDAOLocal.buscarCuentas(
                                        conContableTO.get(0).getEmpCodigo(),
                                        conDetalleTO.getConCtaCodigo());
                                if (conCuentas != null) {
                                    conDetalle.setConCuentas(conCuentas);
                                    listConDetalleModificar.add(conDetalle);
                                } else {
                                    mensajeAux = "F<html>No se encontraron las cuentas contables en la(s) línea(s) del contable numero " + (i + 1) + ":</html>";
                                    mensaje.add(conDetalleTO.getDetOrden().toString() + " - " + conDetalleTO.getConCtaCodigo().toString());
                                }
                            }

                            if (!listConDetalleModificar.isEmpty()) {
                                listConDetallesModificars.add(listConDetalleModificar);
                            }

                        } else {
                            ////// CREANDO NUMERACION
                            ConNumeracion conNumeracion = new ConNumeracion(new ConNumeracionPK(
                                    conContableTO.get(i).getEmpCodigo(), conContableTO.get(i).getPerCodigo(),
                                    conContableTO.get(i).getTipCodigo()));
                            conNumeracions.add(conNumeracion);
                            ////// CREANDO CONTABLE
                            ConContable conContable = ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO.get(i));
                            conContables.add(conContable);
                            ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                            List<ConDetalle> listConDetalle = new ArrayList(0);

                            List<ConDetalleTO> listaDetalleDeLista = listaConDetalleTO.get(i);//esto permite sacar una posicion de la lista en la posicion deseada
                            for (ConDetalleTO conDetalleTO : listaDetalleDeLista) {
                                conDetalle = new ConDetalle();
                                conDetalleTO.setPerCodigo(conContableTO.get(i).getPerCodigo());
                                conDetalle = ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTO);
                                conDetalle.setConContable(conContable);
                                contabilidad.entity.ConCuentas conCuentas = operacionesContabilidadDAOLocal.buscarCuentas(
                                        conContableTO.get(0).getEmpCodigo(),
                                        conDetalleTO.getConCtaCodigo());
                                if (conCuentas != null) {
                                    conDetalle.setConCuentas(conCuentas);
                                    listConDetalle.add(conDetalle);
                                } else {
                                    mensajeAux = "F<html>No se encontraron las cuentas contables en la(s) línea(s) del contable numero " + (i + 1) + ":</html>";
                                    mensaje.add(conDetalleTO.getDetOrden().toString() + " - " + conDetalleTO.getConCtaCodigo().toString());
                                }
                            }
                            if (!listConDetalle.isEmpty()) {
                                listConDetalles.add(listConDetalle);
                            }
                        }
                    } else {
                        mensaje.add("Se intenta generar un contable de tipo: " + conContableTO.get(i).getTipCodigo() + " pero no existe");
                    }
                }
                if (mensaje.isEmpty()) {
                    List<String> listaMensajes = new ArrayList();
                    if (!listConDetalles.isEmpty()) {
                        comprobar = operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContableAgrupado(conContables, listConDetalles, sisSucesos, conNumeracions);
                    }
                    if (!listConDetallesEliminars.isEmpty()) {
                        comprobar = operacionesContabilidadDAOTransaccionLocal.modificarTransaccionConContableAgrupado(conContablesModificar, listConDetallesModificars, listConDetallesEliminars, sisSucesosModificar);
                    }
                    if (!listConDetallesReversar.isEmpty()) {
                        comprobar = operacionesContabilidadDAOTransaccionLocal.ReversarTransaccionConContableAgrupado(conContablesReversar, listConDetallesReversar, sisSucesosModificarAux);
                    }
                    if (comprobar) {
                        if (!conContables.isEmpty()) {
                            listaMensajes.add("Se ingresaron los contables con la siguiente información:");
                            for (int i = 0; i < conContables.size(); i++) {
                                SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.get(i).getEmpCodigo(), conContables.get(i).
                                        getConContablePK().getConPeriodo());

                                ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.get(i).getEmpCodigo(), conContables.get(i).
                                        getConContablePK().getConTipo());

                                listaMensajes.add("Periodo: " + sisPeriodo.getPerDetalle());
                                listaMensajes.add("Tipo: " + conTipo.getTipDetalle());
                                listaMensajes.add("Número: " + conContables.get(i).getConContablePK().getConNumero());
                                listaMensajes.add("Estatus: Contable insertado");
                                listaMensajes.add("");
                            }
                        }
                        if (!conContablesModificar.isEmpty()) {
                            listaMensajes.add("Se modificaron los contables con la siguiente información:");
                            for (int i = 0; i < conContablesModificar.size(); i++) {
                                SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.get(i).getEmpCodigo(), conContablesModificar.get(i).
                                        getConContablePK().getConPeriodo());

                                ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.get(i).getEmpCodigo(), conContablesModificar.get(i).
                                        getConContablePK().getConTipo());

                                listaMensajes.add("Periodo: " + sisPeriodo.getPerDetalle());
                                listaMensajes.add("Tipo: " + conTipo.getTipDetalle());
                                listaMensajes.add("Número: " + conContablesModificar.get(i).getConContablePK().getConNumero());
                                listaMensajes.add("Estatus: Contable modificado");
                                listaMensajes.add("");
                            }
                        }

                        if (!conContablesReversar.isEmpty()) {
                            listaMensajes.add("Se reversado los contables con la siguiente información:");
                            for (int i = 0; i < conContablesReversar.size(); i++) {
                                SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(listaConContableTOs.get(i).getEmpCodigo(), conContablesReversar.get(i).
                                        getConContablePK().getConPeriodo());

                                ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(listaConContableTOs.get(i).getEmpCodigo(), conContablesReversar.get(i).
                                        getConContablePK().getConTipo());

                                listaMensajes.add("Periodo: " + sisPeriodo.getPerDetalle());
                                listaMensajes.add("Tipo: " + conTipo.getTipDetalle());
                                listaMensajes.add("Número: " + conContablesReversar.get(i).getConContablePK().getConNumero());
                                listaMensajes.add("Estatus: Contable reversado");
                                listaMensajes.add("");
                            }
                        }

                        mensajeTO.setListaMensajes(listaMensajes);
                        mensajeAux = "T<html>Se realizó el ingreso de " + conContableTO.size() + " Contables.</html>";
                        mensajeTO.setFechaCreacion(validaciones.Validacion.fecha(conContables.isEmpty() ? conContablesModificar.get(0).getConFecha() : conContables.get(0).getConFecha(), "yyyy-MM-dd HH:mm:ss"));
                    } else {
                        mensajeAux = "F<html>Ocurrió un error al generar los contables, inténtelo de nuevo o contacte con el administrador...</html>";
                    }
                } else {
                    mensajeTO.setMensaje(mensajeAux);
                    mensajeTO.setListaErrores(mensaje);
                }
            } else {
                mensajeAux = "F<html>Ocurrió un error al generar los contables, inténtelo de nuevo o contacte con el administrador...</html>";
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(mensajeAux);
            mensajeTO.setListaErrores(mensaje);
            return mensajeTO;
        }
    }

    @Override
    public inventario.TO.MensajeTO insertarConContableCierreCuentas(
            ConContableTO conContableTO,
            String centroProduccion,
            String conNumero_Contable,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        inventario.TO.MensajeTO mensajeTO = new inventario.TO.MensajeTO();
        java.util.List<String> mensaje = new java.util.ArrayList(1);
        String mensajeAux = "";
        boolean periodoCerrado = false;
        BigDecimal valorDebito = BigDecimal.ZERO;
        BigDecimal valorCredito = BigDecimal.ZERO;
        BigDecimal diferenciaDebitoCredito = BigDecimal.ZERO;
        try {
            List<SisListaPeriodoTO> listaSisPeriodoTO = new ArrayList();


            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(conContableTO.getEmpCodigo());

            for (SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (Validacion.fecha(conContableTO.getConFecha(), "yyyy-MM-dd").getTime()
                        >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && Validacion.fecha(conContableTO.getConFecha(), "yyyy-MM-dd").getTime()
                        <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                    comprobar = true;
                    conContableTO.setPerCodigo(sisListaPeriodoTO.getPerCodigo());
                    periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                }
            }

            if (comprobar) {
                if (!periodoCerrado) {
                    ///// CREANDO UN SUCESO
                    susClave = conContableTO.getPerCodigo() + " "
                            + conContableTO.getTipCodigo() + " "
                            + conContableTO.getConNumero();
                    susDetalle = "falta detalle";
                    susSuceso = "INSERT";
                    susTabla = "contabilidad.con_contable";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);

                    conContableTO.setUsrFechaInsertaContable(Validacion.fecha(sisSuceso.getSusFecha(), "yyyy-MM-dd HH:mm:ss"));
                    ////// CREANDO NUMERACION
                    ConNumeracion conNumeracion = new ConNumeracion(new ConNumeracionPK(
                            conContableTO.getEmpCodigo(), conContableTO.getPerCodigo(),
                            conContableTO.getTipCodigo()));
                    ////// CREANDO CONTABLE
                    ConContable conContable = ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                    List<ConDetalleTO> listaConDetalleTO = new ArrayList(1);
                    List<ConBalanceResultadoCierreTO> listaConBalanceResultadoCierreTO = new ArrayList(operacionesContabilidadDAOLocal.getfun_balance_resultados_cierre(conContableTO.getEmpCodigo(), centroProduccion, conContableTO.getConFecha()));
                    for (int i = 0; i < listaConBalanceResultadoCierreTO.size() + 1; i++) {

                        ConDetalleTO conDetalleTO = new ConDetalleTO();
                        if (i < listaConBalanceResultadoCierreTO.size()) {
                            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                            conDetalleTO.setConNumero(conContableTO.getConNumero());
                            conDetalleTO.setDetSecuencia(0);
                            conDetalleTO.setConCtaCodigo(listaConBalanceResultadoCierreTO.get(i).getBgCuenta());
                            conDetalleTO.setSecCodigo(centroProduccion);
                            conDetalleTO.setPisNumero("");
                            conDetalleTO.setDetDocumento("");
                            conDetalleTO.setDetDebitoCredito(listaConBalanceResultadoCierreTO.get(i).getBgCredito());
                            conDetalleTO.setDetValor(listaConBalanceResultadoCierreTO.get(i).getBgSaldo());
                            conDetalleTO.setDetGenerado(true);
                            conDetalleTO.setDetReferencia("A");
                            conDetalleTO.setDetObservaciones("");
                            conDetalleTO.setDetOrden(listaConBalanceResultadoCierreTO.get(i).getBgSecuencial());

                            if (listaConBalanceResultadoCierreTO.get(i).getBgCredito() == 'D') {
                                valorDebito = valorDebito.add(listaConBalanceResultadoCierreTO.get(i).getBgSaldo());
                            } else {
                                valorCredito = valorCredito.add(listaConBalanceResultadoCierreTO.get(i).getBgSaldo());
                            }
                            listaConDetalleTO.add(conDetalleTO);

                        }
                        if (i == listaConBalanceResultadoCierreTO.size()) {

                            diferenciaDebitoCredito = valorDebito.subtract(valorCredito);
                            conDetalleTO.setEmpCodigo(conContableTO.getEmpCodigo());
                            conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                            conDetalleTO.setTipCodigo(conContableTO.getTipCodigo());
                            conDetalleTO.setConNumero(conContableTO.getConNumero());
                            conDetalleTO.setDetSecuencia(0);
                            conDetalleTO.setConCtaCodigo(conNumero_Contable);
                            conDetalleTO.setSecCodigo(centroProduccion);
                            conDetalleTO.setPisNumero("");
                            conDetalleTO.setDetDocumento("");

                            if (diferenciaDebitoCredito.compareTo(BigDecimal.ZERO) > 0) {
                                conDetalleTO.setDetDebitoCredito('C');
                            } else {
                                conDetalleTO.setDetDebitoCredito('D');
                            }

                            conDetalleTO.setDetValor(diferenciaDebitoCredito.abs());
                            conDetalleTO.setDetGenerado(true);
                            conDetalleTO.setDetReferencia("A");
                            conDetalleTO.setDetObservaciones("");
                            conDetalleTO.setDetOrden(listaConBalanceResultadoCierreTO.size() + 1);
                            listaConDetalleTO.add(conDetalleTO);
                        }
                    }
                    ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                    List<ConDetalle> listConDetalle = new ArrayList(0);
                    ConDetalle conDetalle = null;

                    for (ConDetalleTO conDetalleTO : listaConDetalleTO) {
                        conDetalle = new ConDetalle();
                        conDetalleTO.setPerCodigo(conContableTO.getPerCodigo());
                        conDetalle = ConversionesContabilidad.convertirConDetalleTO_ConDetalle(conDetalleTO);
                        conDetalle.setConContable(conContable);
                        contabilidad.entity.ConCuentas conCuentas = operacionesContabilidadDAOLocal.buscarCuentas(conDetalleTO.getEmpCodigo(),
                                conDetalleTO.getConCtaCodigo());
                        if (conCuentas != null) {
                            conDetalle.setConCuentas(conCuentas);
                            listConDetalle.add(conDetalle);
                        } else {
                            mensajeAux = "F<html>No se encontraron las cuentas contables en la(s) línea(s):</html>";
                            mensaje.add(conDetalleTO.getDetOrden().toString() + " - " + conDetalleTO.getConCtaCodigo().toString());
                        }
                    }

                    if (mensaje.isEmpty()) {
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
                                null,
                                null,
                                null,
                                null,
                                sisInfoTO);
                        if (comprobar) {

                            SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConPeriodo());

                            ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(conContableTO.getEmpCodigo(), conContable.getConContablePK().getConTipo());

                            mensajeAux = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>, "
                                    + conContable.getConContablePK().getConPeriodo() + ", " + conContable.getConContablePK().getConNumero();
                            mensajeTO.setFechaCreacion(validaciones.Validacion.fecha(conContable.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                        } else {
                            mensajeAux = "F<html>Ocurrió un error al guardar el contable, inténtelo de nuevo...</html>";
                        }
                    } else {
                        mensajeTO.setMensaje(mensajeAux);
                        mensajeTO.setListaErrores(mensaje);
                    }
                } else {
                    mensajeAux = "F<html>El periodo que corresponde a la fecha que ingresó se encuentra cerrado...</html>";
                }
            } else {
                mensajeAux = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(mensajeAux);
            return mensajeTO;
        }
    }

    @Override
    public List<ConCuentasFlujoTO> getListaBuscarConCuentasFlujoTO(
            String empresa,
            String buscar) throws Exception {
        return operacionesContabilidadDAOLocal.getListaBuscarConCuentasFlujoTO(empresa, buscar);
    }

    @Override
    public java.util.List<contabilidad.TO.ConFunContablesVerificacionesComprasTO> getConFunContablesVerificacionesComprasTOs(
            java.lang.String empresa,
            java.lang.String fechaInicio,
            java.lang.String fechaFin) throws Exception {
        return operacionesContabilidadDAOLocal.getConFunContablesVerificacionesComprasTOs(empresa, fechaInicio, fechaFin);
    }

    @Override
    public java.util.List<contabilidad.TO.PersonaTO> getFunPersonaTOs(String empresa, String busquedad) throws Exception {
        return operacionesContabilidadDAOLocal.getFunPersonaTOs(empresa, busquedad);
    }

    @Override
    public JasperPrint generarReporteCompraContableDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteCompraDetalle> reporteCompraDetalles,
            List<ConContableReporteTO> list) throws Exception {
        return generarReporteContabilidadLocal.generarReporteCompraContableDetalle(
                sisUsuarioEmpresaTO, reporteCompraDetalles, list);
    }
}
