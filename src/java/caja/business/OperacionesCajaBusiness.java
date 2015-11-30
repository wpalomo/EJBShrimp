/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.business;

import caja.TO.CajCajaValesTO;
import caja.TO.CajCuadreCajaTO;
import caja.reporte.GenerarReporteCajaLocal;
import caja.reporte.ReporteCajCajaVales;
import java.util.List;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */

@Stateless
public class OperacionesCajaBusiness implements OperacionesCajaBusinessLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public sistema.TO.SisErrorTO sisErrorTO = null;
    boolean comprobar = false;
    String mensaje = "";
    private String susTabla;//
    private String susClave;//
    private String susSuceso;//
    private String susDetalle;//
    private java.math.BigDecimal cero = new java.math.BigDecimal("0.00");
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    @javax.ejb.EJB
    caja.DAO.OperacionesCajaDAOTransaccionLocal operacionesCajaDAOTransaccionLocal;
    @javax.ejb.EJB
    caja.DAO.OperacionesCajaDAOLocal operacionesCajaDAOLocal;
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @javax.ejb.EJB
    contabilidad.DAO.OperacionesContabilidadDAOLocal operacionesContabilidadDAOLocal;
    @javax.ejb.EJB
    produccion.DAO.OperacionesProduccionDAOLocal operacionesProduccionDAOLocal;
    @javax.ejb.EJB
    contabilidad.DAO.OperacionesContabilidadDAOTransaccionLocal operacionesContabilidadDAOTransaccionLocal;
    @javax.ejb.EJB
    inventario.DAO.OperacionesInventarioDAOLocal operacionesInventarioDAOLocal;
    @javax.ejb.EJB
    GenerarReporteCajaLocal generarReporteCajaLocal;

    @Override
    public caja.TO.MensajeTO accionCajCajaTO(
            caja.TO.CajCajaTO cajCajaTO,
            String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        java.util.List<String> mensajeClase = new java.util.ArrayList(1);
        caja.TO.MensajeTO mensajeTO = new caja.TO.MensajeTO();
        caja.entity.CajCaja cajCaja = null;
        caja.entity.CajCaja cajCajaAux = null;
        try {
            cajCajaAux = operacionesCajaDAOLocal.getCajCaja(cajCajaTO.getCajaEmpresa(), cajCajaTO.getCajaCodigo());
            if (accion.equals("I") && cajCajaAux == null || accion.equals("U") && cajCajaAux != null || accion.equals("D") && cajCajaAux != null) {
                ////////////DESPUES DE QUE CUMPLE LAS CONDICIONES DADAS SE CREAN LOS OBJETOS NECESARIOS
                susClave = cajCajaTO.getCajaCodigo() + " " + cajCajaTO.getCajaNombre();
                if (accion.equals("I")) {
                    susDetalle = "Se ingresó la Caja " + cajCajaTO.getCajaNombre() + " con código " + cajCajaTO.getCajaCodigo();
                    susSuceso = "INSERT";
                }
                if (accion.equals("U")) {
                    susDetalle = "Se modificó la Caja " + cajCajaTO.getCajaNombre() + " con código " + cajCajaTO.getCajaCodigo();
                    susSuceso = "UPDATE";
                }
                if (accion.equals("D")) {
                    susDetalle = "Se eliminó la Caja " + cajCajaTO.getCajaNombre() + " con código " + cajCajaTO.getCajaCodigo();
                    susSuceso = "DELETE";
                }
                susTabla = "caja.caj_caja";
                cajCajaTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                cajCaja = caja.helper.ConversionesCaja.convertirCajCajaTO_CajCaja(cajCajaTO);
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                comprobar = operacionesCajaDAOTransaccionLocal.accionCajCaja(cajCaja, sisSuceso, accion);
                if (comprobar) {
                    if (accion.equals("I")) {
                        mensaje = "T<html>Se guardó la información correctamente.</html>";
                    }
                    if (accion.equals("U")) {
                        mensaje = "T<html>Se actualizó la información correctamente.</html>";
                    }
                    if (accion.equals("D")) {
                        mensaje = "T<html>Se eliminó la información correctamente.</html>";
                    }
                } else {
                    mensaje = "F<html>Ocurrió un problema al guardar la información.<br>Intentelo de nuevo o contacte con el administrador.</html>";
                }
            } else {
                if (accion.equals("I") && cajCajaAux != null) {
                    mensaje = "F<html>La caja que va a ingresar ya existe.<br>Intente con otro.</html>";
                } else {
                    if (accion.equals("U") && cajCajaAux == null || accion.equals("D") && cajCajaAux == null) {
                        mensaje = "F<html>La caja que va a " + (accion.equals("U") ? "modificar" : "eliminar") + "ya no existe.<br>Intente con otro.";
                    }
                }
            }
        } catch (Exception e) {
            comprobar = false;
            mensaje = "F<html>Lo sentimos mucho, ocurrio un error inesperado al intentar procesar la información.</html>";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionCajCajaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            mensajeTO.setMensaje(mensaje);
            return mensajeTO;
        }
    }

    @Override
    public java.util.List<caja.TO.CajCajaTO> getListadoCajCajaTO(
            String empresa) throws java.lang.Exception {
        return operacionesCajaDAOLocal.getListadoCajCajaTO(empresa);
    }

    @Override
    public java.util.List<caja.TO.CajCajaComboTO> getCajCajaComboTO(
            String empresa) throws Exception {
        return operacionesCajaDAOLocal.getCajCajaComboTO(empresa);
    }

    @Override
    public java.util.List<caja.TO.CajValesConceptosComboTO> getCajValesConceptosComboTOs(
            String empresa) throws Exception {
        return operacionesCajaDAOLocal.getCajValesConceptosComboTOs(empresa);
    }
    //paso 3 del ejb

    @Override
    public String accionCajaValesTO(
            caja.TO.CajCajaValesTO cajCajaValesTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        boolean periodoCerrado = false;
        comprobar = false;
        try {

            if (!validaciones.Validacion.isFechaSuperior(cajCajaValesTO.getValeFecha(), "yyyy-MM-dd")) {
                ///// BUSCANDO vale
                java.util.List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList();
                listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(cajCajaValesTO.getValeEmpresa());//invVentasTO.getVtaEmpresa()
                for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                    if (validaciones.Validacion.fecha(cajCajaValesTO.getValeFecha(), "yyyy-MM-dd").getTime()
                            >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                            && validaciones.Validacion.fecha(cajCajaValesTO.getValeFecha(), "yyyy-MM-dd").getTime()
                            <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                        comprobar = true;
                        cajCajaValesTO.setValePeriodo(sisListaPeriodoTO.getPerCodigo());
                        periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                    }
                }
                if (comprobar) {
                    if (!periodoCerrado) {
                        susClave = cajCajaValesTO.getValeEmpresa() + cajCajaValesTO.getValePeriodo() + cajCajaValesTO.getValeMotivo() + cajCajaValesTO.getValeNumero();
                        if (accion == 'I') {
                            susDetalle = "Se insertó el vale de caja " + cajCajaValesTO.getValeEmpresa() + cajCajaValesTO.getValePeriodo() + cajCajaValesTO.getValeMotivo() + cajCajaValesTO.getValeNumero();
                            susSuceso = "INSERT";
                        }
                        if (accion == 'M') {
                            susDetalle = "Se Anulo el vale de caja " + cajCajaValesTO.getValeEmpresa() + cajCajaValesTO.getValePeriodo() + cajCajaValesTO.getValeMotivo() + cajCajaValesTO.getValeNumero();
                            susSuceso = "UPDATE";
                        }
                        if (accion == 'E') {
                            susDetalle = "Se Elimino el vale de caja " + cajCajaValesTO.getValeEmpresa() + cajCajaValesTO.getValePeriodo() + cajCajaValesTO.getValeMotivo() + cajCajaValesTO.getValeNumero();
                            susSuceso = "ANULO";
                        }
                        susTabla = "caja.cajVales";
                        /**
                         * **********CREAMOS LA ENTIDA****************
                         */
                        caja.entity.CajVales cajVales = caja.helper.ConversionesCaja.convertirCajCajaValesTO_CajVales(cajCajaValesTO);
                        caja.entity.CajValesNumeracion cajValesNumeracion = new caja.entity.CajValesNumeracion(new caja.entity.CajValesNumeracionPK(cajCajaValesTO.getValeEmpresa(),
                                cajCajaValesTO.getValePeriodo(),
                                cajCajaValesTO.getValeMotivo()));
                        if (accion == 'I') {
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            comprobar = operacionesCajaDAOTransaccionLocal.accionCajaValesTO(
                                    cajVales, sisSuceso, cajValesNumeracion, accion);
                        }
                        if (accion == 'M') {
                            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                    susTabla,
                                    susClave,
                                    susSuceso,
                                    susDetalle,
                                    sisInfoTO);
                            comprobar = operacionesCajaDAOTransaccionLocal.accionCajaValesTO(
                                    cajVales, sisSuceso, cajValesNumeracion, accion);
                        }
                        if (comprobar) {
                            if (accion == 'I') {
                                mensaje = "T<html>Se ha guardado el siguiente Vale de Caja:"
                                        + "<br>Número: <font size = 5>" + cajVales.getCajValesPK().getValeNumero() + "</font>"
                                        + "<br>Periodo: <font size = 5>" + cajVales.getCajValesPK().getValePeriodo() + "</font>"
                                        + "<br>Beneficiario: <font size = 5>" + cajVales.getValeBeneficiario() + "</font>"
                                        + "<br><font size = 6> Valor: " + cajVales.getValeValor().add(cero) + "</font>"
                                        + "<br>Fecha: <font size = 5>" + validaciones.Validacion.fechaSistema() + "</font></html>.";
                            }
                            //this.catCajaValesTo.getValeValor().add(cero).toString()
                            if (accion == 'M') {
                                mensaje = "T<html>Se ha Anulo el siguiente Vale de Caja:<br><br>Número: <font size = 5>"
                                        + cajVales.getCajValesPK().getValeNumero() + "</font>.<br>Beneficiario: <font size = 5>"
                                        + cajVales.getValeBeneficiario() + "</font>.</html>";
                            }
                            if (accion == 'E') {
                                mensaje = "T<html>Se ha Anulo el siguiente Vale de Caja:<br><br>Número: <font size = 5>"
                                        + cajVales.getCajValesPK().getValeNumero() + "</font>.<br>Beneficiario: <font size = 5>"
                                        + cajVales.getValeBeneficiario() + "</font>.</html>";
                            }
                        } else {
                            mensaje = "FHubo un error al guardar el Vale de Caja...\nIntente de nuevo o contacte con el administrador.";
                        }
                    } else {
                        mensaje = "F<html>El periodo que corresponde a la fecha que ingresó se encuentra cerrado...</html>";
                    }
                } else {
                    mensaje = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
                }
                /*
                 * }else mensaje="F<html>El Vale de caja que ingreso ya no está
                 * disponible...\nIntente de nuevo, escoja otro Cliente o
                 * contacte con el administrador</html>";
                 *
                 */

            } else {
                mensaje = "F<html>La fecha que ingresó es superior a la fecha actual del servidor.<br>Fecha actual del servidor: " + validaciones.Validacion.fechaSistema("dd-MM-yyyy") + "</html>";
            }

        } catch (Exception e) {
            mensaje = "FHubo un error al intentar guardar el Caja de Vales...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionCajaValesTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
            e.printStackTrace();
        }
        return mensaje;
    }

    @Override
    public String accionCajValesConceptosTO(
            caja.TO.CajValesConceptoTO cajValesConceptosTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = cajValesConceptosTO.getConcCodigo();
            if (accion == 'I') {
                susDetalle = "Se insertó Concepto vales de Caja  : " + cajValesConceptosTO.getConcDetalle();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó Concepto vales de Caja : " + cajValesConceptosTO.getConcDetalle();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó Concepto vales de Caja  : " + cajValesConceptosTO.getConcDetalle();
                susSuceso = "DELETE";
            }
            susTabla = "caja.caj_vales_conceptos";
            ///// CREANDO invProductoMedida
            cajValesConceptosTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
            caja.entity.CajValesConceptos cajValesConceptos = caja.helper.ConversionesCaja.convertirCajValesConceptosTO_cajValesConceptos(cajValesConceptosTO);

            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                if (!operacionesCajaDAOLocal.comprobarCajValesConceptos(
                        cajValesConceptosTO.getConcEmpresa(),
                        cajValesConceptosTO.getConcCodigo())) {
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    cajValesConceptos.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                    comprobar = operacionesCajaDAOTransaccionLocal.accionCajValesConceptos(
                            cajValesConceptos,
                            sisSuceso,
                            accion);
                } else {
                    mensaje = "FYa existe el Concepto de Vale de caja...";
                }
            }
            if (accion == 'M') {
                ////// BUSCANDO existencia Categoría
                if (operacionesCajaDAOLocal.comprobarCajValesConceptos(
                        cajValesConceptosTO.getConcEmpresa(),
                        cajValesConceptosTO.getConcCodigo())) {
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    cajValesConceptos.setUsrFechaInserta(
                            operacionesCajaDAOLocal.buscarCajValesConceptos(
                            cajValesConceptosTO.getConcEmpresa(),
                            cajValesConceptosTO.getConcCodigo()).getUsrFechaInserta());

                    comprobar = operacionesCajaDAOTransaccionLocal.accionCajValesConceptos(cajValesConceptos, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el Datos...";
                }
            }
            if (accion == 'E') {
                ////// BUSCANDO existencia Categoría
                if (operacionesCajaDAOLocal.comprobarCajValesConceptos(
                        cajValesConceptosTO.getConcEmpresa(),
                        cajValesConceptosTO.getConcCodigo())) {
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    cajValesConceptos.setUsrFechaInserta(
                            operacionesCajaDAOLocal.buscarCajValesConceptos(
                            cajValesConceptosTO.getConcEmpresa(),
                            cajValesConceptosTO.getConcCodigo()).getUsrFechaInserta());
                    comprobar = operacionesCajaDAOTransaccionLocal.accionCajValesConceptos(cajValesConceptos, sisSuceso, accion);
                } else {
                    mensaje = "FNo se encuentra el Datos...";
                }
            }
            if (comprobar) {
                if (accion == 'E') {
                    mensaje = "TSe eliminó correctamente el Concepto de Vale de caja";
                }
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente el Concepto de Vale de caja";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente  el Concepto de Vale de caja";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error en el Concepto de Vale de caja " + cajValesConceptosTO.getConcDetalle() + ", inténtelo de nuevo...";
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

    @Override
    public java.util.List<caja.TO.CajCajaValesTO> getListadoCajValesTO(
            java.lang.String empresa,
            java.lang.String motCodigo,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws Exception {
        return operacionesCajaDAOLocal.getListadoCajValesTO(empresa, motCodigo, fechaDesde, fechaHasta);
    }

    @Override
    public caja.TO.CajCajaValesTO getCajCajaValesTO(
            String empresa,
            String perCodigo,
            String motCodigo,
            String valeNumero) throws Exception {
        return operacionesCajaDAOLocal.getCajCajaValesTO(empresa, perCodigo, motCodigo, valeNumero);
    }

    @Override
    public java.util.List<caja.TO.CajCuadreCajaTO> getCajCuadreCajaTOs(
            String empresa,
            String codigoMotivo,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesCajaDAOLocal.getCajCuadreCajaTOs(empresa, codigoMotivo, fechaDesde, fechaHasta);
    }

    @Override
    public caja.TO.CajCajaTO getCajCajaTO(
            String empresa,
            String usuarioCodigo) throws Exception {
        return operacionesCajaDAOLocal.getCajCajaTO(empresa, usuarioCodigo);
    }
    //paso 3 caja bussines

    public JasperPrint generarReporteCajCuadreDeCaja(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaHasta, String codigoMotivo, String descripcionMotivo,
            List<CajCuadreCajaTO> listCajCuadreCajaTOs) throws Exception {
        return generarReporteCajaLocal.generarReporteCajCuadreDeCaja(
                sisUsuarioEmpresaTO, fechaHasta, codigoMotivo, descripcionMotivo,
                listCajCuadreCajaTOs);
    }

    public JasperPrint generarReporteCajVales(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String descripcionCajaConcepto, String codigoCajaConcepto,
            CajCajaValesTO cajCajaValesTo) throws Exception {
        return generarReporteCajaLocal.generarReporteCajVales(sisUsuarioEmpresaTO,
                descripcionCajaConcepto, codigoCajaConcepto, cajCajaValesTo);
    }

    public List<ReporteCajCajaVales> getReporteCajaValues() throws Exception {
        return generarReporteCajaLocal.getReporteCajaValues();
    }

    public JasperPrint generarReporteCajValesListado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<CajCajaValesTO> listaCajValesListaTOs) throws Exception {
        return generarReporteCajaLocal.generarReporteCajValesListado(sisUsuarioEmpresaTO,
                listaCajValesListaTOs);
    }
}
