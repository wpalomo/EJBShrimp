/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.business;

import banco.TO.*;
import banco.entity.BanCheque;
import banco.helper.ConversionesBanco;
import banco.reporte.GenerarReporteBancoLocal;
import banco.reporte.ReporteConciliacionCabecera;
import contabilidad.entity.ConDetalle;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisInfoTO;
import sistema.TO.SisUsuarioEmpresaTO;
import sistemaWeb.entity.SisSuceso;
import validaciones.Excepciones;
import validaciones.Suceso;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesBancoBusiness1 implements OperacionesBancoBusinessLocal1 {

    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    @javax.ejb.EJB
    banco.DAO.OperacionesBancoDAOTransaccionLocal operacionesBancoDAOTransaccionLocal;
    @javax.ejb.EJB
    contabilidad.business.OperacionesContabilidadBusinessLocal operacionesContabilidadBusinessLocal;
    @javax.ejb.EJB
    banco.DAO.OperacionesBancoDAOLocal operacionesBancoDAOLocal;
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @javax.ejb.EJB
    contabilidad.DAO.OperacionesContabilidadDAOLocal operacionesContabilidadDAOLocal;
    @javax.ejb.EJB
    contabilidad.DAO.OperacionesContabilidadDAOTransaccionLocal operacionesContabilidadDAOTransaccionLocal;
    @javax.ejb.EJB
    sistema.business.OperacionesSistemaBusinessLocal operacionesSistemaBusinessLocal;
    @EJB
    GenerarReporteBancoLocal generarReporteBancoLocal;
    boolean comprobar = false;
    String mensaje = "";
    public sistema.TO.SisErrorTO sisErrorTO = null;
    private String susTabla;
    private String susClave;
    private String susSuceso;
    private String susDetalle;
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA OBETENER LISTA DE BANCOS, CAJAS Y CUENTAS">

    @Override
    public java.util.List<banco.TO.ListaBanBancoTO> getListaBanBancoTO(
            String empresa) throws Exception {
        return operacionesBancoDAOLocal.getListaBanBancoTO(empresa);
    }

    @Override
    public java.util.List<banco.TO.ListaBanCajaTO> getListaBanCajaTO(
            String empresa) throws Exception {
        return operacionesBancoDAOLocal.getListaBanCajaTO(empresa);
    }

    @Override
    public java.util.List<banco.TO.ListaBanCuentaTO> getListaBanCuentaTO(
            String empresa) throws Exception {
        return operacionesBancoDAOLocal.getListaBanCuentaTO(empresa);
    }

    @Override
    public java.util.List<banco.TO.BanListaChequesNoImpresosTO> getListaChequesNoImpresosTO(
            String empresa,
            String cuentaBancaria) throws Exception {
        return operacionesBancoDAOLocal.getListaChequesNoImpresosTO(empresa, cuentaBancaria);
    }

    @Override
    public banco.TO.ConsultaDatosBancoCuentaTO getConsultaDatosBancoCuentaTO(
            String empresa,
            String cuenta) throws Exception {
        return operacionesBancoDAOLocal.getConsultaDatosBancoCuentaTO(empresa, cuenta);
    }

    @Override
    public boolean isExisteChequeAimprimir(
            String empresa,
            String cuentaContable,
            String numeroCheque,
            Long detSecuencia) throws Exception {
        return operacionesBancoDAOLocal.isExisteChequeAimprimir(empresa, cuentaContable, numeroCheque, detSecuencia);
    }

    public boolean isExisteCheque(
            String empresa,
            String cuentaContable,
            String numeroCheque) throws Exception {
        return operacionesBancoDAOLocal.isExisteCheque(empresa, cuentaContable, numeroCheque);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA INSERTAR BANCOS, CAJAS Y CUENTAS">
    @Override
    public boolean insertarBanBancoTO(
            banco.TO.BanBancoTO banBancoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            susClave = banBancoTO.getBanCodigo() + " " + banBancoTO.getBanNombre();
            susDetalle = "Se ingreso el Banco " + banBancoTO.getBanNombre() + " con código " + banBancoTO.getBanCodigo();
            susSuceso = "INSERT";
            susTabla = "banco.ban_banco";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            banBancoTO.setUsrFechaInsertaBanco(validaciones.Validacion.fechaSistema());
            if (operacionesBancoDAOLocal.buscarBanBanco(banBancoTO.getEmpCodigo(), banBancoTO.getBanCodigo()) == null) {
                banco.entity.BanBanco banBanco = banco.helper.ConversionesBanco.convertirBanBancoTO_BanBanco(banBancoTO);
                comprobar = operacionesBancoDAOTransaccionLocal.insertarBanBanco(banBanco, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarBanBancoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean insertarBanCajaTO(
            BanCajaTO banCajaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            susClave = banCajaTO.getCajaCodigo() + " " + banCajaTO.getCajaNombre();
            susDetalle = "Se ingreso la Caja " + banCajaTO.getCajaNombre() + " con código " + banCajaTO.getCajaCodigo();
            susSuceso = "INSERT";
            susTabla = "banco.ban_caja";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            banCajaTO.setUsrFechaInsertaCaja(validaciones.Validacion.fechaSistema());
            banco.entity.BanCaja banCaja = banco.helper.ConversionesBanco.convertirBanCajaTO_BanCaja(banCajaTO);
            comprobar = operacionesBancoDAOTransaccionLocal.insertarBanCaja(banCaja, sisSuceso);
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarBanCajaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean insertarBanCuentaTO(
            BanCuentaTO banCuentaTO,
            String codigoBanco,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            susClave = "Se inserto la cuenta bancaria " + banCuentaTO.getCtaNumero();
            susSuceso = "INSERT";
            susTabla = "banco.ban_cuenta";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            banCuentaTO.setUsrFechaInsertaCuenta(validaciones.Validacion.fechaSistema());
            banco.entity.BanCuenta banCuenta = banco.helper.ConversionesBanco.convertirBanCuentaTO_BanCuenta(banCuentaTO);
            banco.entity.BanBanco banBanco = operacionesBancoDAOLocal.buscarBanBanco(banCuentaTO.getCtaEmpresa(), codigoBanco);
            if (banBanco != null) {
                banCuenta.setBanBanco(banBanco);
                comprobar = operacionesBancoDAOTransaccionLocal.insertarBanCuenta(banCuenta, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarBanCuentaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public String insertarBanChequeTO(
            BanChequeTO banChequeTO,
            String usrInserta,
            String numeroCheque,
            String empresa,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        String retorno = "";
        try {
            contabilidad.entity.ConDetalle conDetalleAux = operacionesContabilidadDAOLocal.buscarDetalleContable(banChequeTO.getDetSecuencia());
            if (conDetalleAux != null) {
                contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContable_ConContable(conDetalleAux.getConContable());
                contabilidad.entity.ConCuentas conCuentas = conDetalleAux.getConCuentas();
                contabilidad.entity.ConDetalle conDetalle = contabilidad.helper.ConversionesContabilidad.convertirConDetalle_ConDetalle(conDetalleAux);
                conDetalle.setConContable(conContable);
                conDetalle.setConCuentas(conCuentas);
                conDetalle.setDetSaldo(BigDecimal.ZERO);
                comprobar = false;
                banco.entity.BanCheque banChequeAux = operacionesBancoDAOLocal.buscarBanCheque(banChequeTO.getChqSecuencia());
                if (banChequeAux != null) {
                    banChequeTO.setConcEmpresa(banChequeAux.getConcEmpresa());
                    banChequeTO.setConcCuentaContable(banChequeAux.getConcCuentaContable());
                    banChequeTO.setConcCodigo(banChequeAux.getConcCodigo());
                }
                if (conDetalle.getConContable().getConAnulado() || conDetalle.getConContable().getConPendiente()) {
                    retorno = "FNo se ha podido cambiar el número de Cheque\nya que el Contable se ha marcado como pendiente o se ha anulado";
                } else {
                    susClave = conDetalle.getDetDocumento() == null ? "" : conDetalle.getDetDocumento();
                    susSuceso = "INSERT";
                    susTabla = "banco.ban_cheque";
                    susDetalle = numeroCheque.trim().equals(conDetalle.getDetDocumento()) ? "Se ingreso el cheque con número "
                            + (conDetalle.getDetDocumento() == null ? "" : conDetalle.getDetDocumento()) : "Se ingreso el cheque con número "
                            + numeroCheque + " reemplazando al cheque " + (conDetalle.getDetDocumento() == null ? "" : conDetalle.getDetDocumento());
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    banco.entity.BanCheque banCheque = banco.helper.ConversionesBanco.convertirBanChequeTO_BanCheque(banChequeTO);
                    conDetalle.setDetDocumento(numeroCheque.equals((conDetalle.getDetDocumento() == null ? ""
                            : conDetalle.getDetDocumento())) ? (conDetalle.getDetDocumento() == null ? "" : conDetalle.getDetDocumento()) : numeroCheque);
                    conDetalle.setDetGenerado(true);
                    comprobar = operacionesBancoDAOTransaccionLocal.insertarBanCheque(banCheque, sisSuceso, conContable, conDetalle);
                    if (comprobar) {
                        retorno = "TInformación del cheque guardada...";
                    } else {
                        retorno = "FHubo un error al guardar la información del cheque...";
                    }
//                    } else
//                        retorno = "FNo existe la cuenta contable del cheque...";
                }
            } else {
                retorno = "FHubo un error al guardar la información del cheque...\nConDetalle null...";
            }
        } catch (Exception e) {
            retorno = "FHubo un error al guardar la información del cheque...";
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarBanChequeTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarFechaBanChequeTO(
            String empresa,
            String cuenta,
            String numero,
            String fecha,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        String retorno = "";
        try {
            banco.TO.BanChequeTO banChequeTO = operacionesBancoDAOLocal.buscarBanChequeTO(empresa, cuenta, numero);
            if (banChequeTO.getChqSecuencia() != null) {
                susClave = banChequeTO.getChqSecuencia().toString();
                susSuceso = "UPDATE";
                susTabla = "banco.ban_cheque";
                susDetalle =
                        "El cheque numero " + numero
                        + " con la numeración " + banChequeTO.getChqSecuencia()
                        + " con fecha " + banChequeTO.getChqFecha()
                        + " por la fecha " + fecha;
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                banChequeTO.setChqFecha(fecha);
                banco.entity.BanCheque banCheque = banco.helper.ConversionesBanco.convertirBanChequeTO_BanCheque(banChequeTO);
                comprobar = operacionesBancoDAOTransaccionLocal.modificarBanCheque(banCheque, sisSuceso);
                if (comprobar) {
                    retorno = "TSe modifico la fecha del cheque " + numero + "...";
                } else {
                    retorno = "FHubo un error al modificar la fecha del cheque " + numero + "...";
                }
            } else {
                retorno = "FNo se encuentra el cheque " + numero + "...";
            }
        } catch (Exception e) {
            retorno = "FHubo un error al guardar la información del cheque...";
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarFechaBanChequeTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    public String modificarNumeroBanChequeTO(
            String empresa,
            String cuenta,
            String numero,
            String numeroNuevo,
            String usuario,
            SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        String retorno = "";
        try {
            BanChequeTO banChequeTO = operacionesBancoDAOLocal.buscarBanChequeTO(empresa, cuenta, numero);
            if (banChequeTO.getChqSecuencia() != null) {
                if (!operacionesBancoDAOLocal.isExisteChequeAimprimir(empresa, cuenta, numeroNuevo, null)) {
                    ConDetalle conDetalle = operacionesContabilidadDAOLocal.buscarDetalleContable(banChequeTO.getChqSecuencia());
                    if (conDetalle != null) {
                        susClave = banChequeTO.getChqSecuencia().toString();
                        susSuceso = "UPDATE";
                        susTabla = "banco.ban_cheque";
                        susDetalle = "El cheque numero " + numero
                                + " con la numeración " + banChequeTO.getChqSecuencia()
                                + " con fecha " + banChequeTO.getChqFecha()
                                + " por chqImpreso=false";
                        SisSuceso sisSuceso = Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);

                        banChequeTO.setChqImpreso(false);
                        BanCheque banCheque = ConversionesBanco.convertirBanChequeTO_BanCheque(banChequeTO);
                        comprobar = operacionesBancoDAOTransaccionLocal.modificarBanCheque(banCheque, sisSuceso);

                        susClave = conDetalle.getDetSecuencia().toString();
                        susSuceso = "UPDATE";
                        susTabla = "contabilidad.con_detalle";
                        susDetalle = "Se modifico el cheque numero " + numero
                                + " con la numeración " + banChequeTO.getChqSecuencia()
                                + " con fecha " + banChequeTO.getChqFecha()
                                + " por la numeración " + numeroNuevo;
                        sisSuceso = Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        conDetalle.setDetDocumento(numeroNuevo);
                        boolean comprobar1 = operacionesContabilidadDAOTransaccionLocal.modificarConDetalleTO(conDetalle, sisSuceso);
                        if (comprobar && comprobar1) {
                             retorno = "T<html>Se modificó correctamente el CHEQUE: " + numero + " al numero " + numeroNuevo + "<br><br>"
                                                    + "Periodo: <font size = 5>" + conDetalle.getConContable().getConContablePK().getConPeriodo()
                                                    + "</font>.<br> Tipo: <font size = 5>" + conDetalle.getConContable().getConContablePK().getConTipo()
                                                    + "</font>.<br> Número: <font size = 5>" + conDetalle.getConContable().getConContablePK().getConNumero() + "</font>.</html>"
                                                    + conDetalle.getConContable().getConContablePK().getConPeriodo() + ", " + conDetalle.getConContable().getConContablePK().getConNumero();
                            
                            
                            //retorno = "TSe modifico el numero del cheque " + numero + " al numero " + numeroNuevo + "...";
                        } else {
                            retorno = "F<html>Hubo un error al modificar el numero del cheque " + numero + "...</html>";
                        }
                    } else {
                        retorno = "F<html>No se pudo recuperar la información contable del cheque...</html>";
                    }
                } else {
                    retorno = "F<html>El nuevo numero de cheque ya esta registrado...</html>";
                }
            } else {
                retorno = "F<html>No se encuentra el cheque " + numero + "...</html>";
            }
        } catch (Exception e) {
            retorno = "FHubo un error al guardar la información del cheque...</html>";
            comprobar = false;
            Excepciones.guardarExcepcionesEJB(e, getClass().getName(),
                    "modificarFechaBanChequeTO",
                    sisInfoTO, operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA MODIFICAR BANCOS, CAJAS Y CUENTAS">

    @Override
    public boolean modificarBanBancoTO(
            banco.TO.BanBancoTO banBancoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            susClave = banBancoTO.getBanCodigo() + " " + banBancoTO.getBanNombre();
            susDetalle = "Se modificó el Banco " + banBancoTO.getBanNombre() + " con código " + banBancoTO.getBanCodigo();
            susSuceso = "UPDATE";
            susTabla = "banco.ban_banco";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            banBancoTO.setUsrFechaInsertaBanco(validaciones.Validacion.fechaSistema());
            banco.entity.BanBanco banBancoModificar = operacionesBancoDAOLocal.buscarBanBanco(banBancoTO.getEmpCodigo(), banBancoTO.getBanCodigo());
            if (banBancoModificar != null) {
                banBancoTO.setUsrInsertaBanco(banBancoModificar.getUsrCodigo());
                banBancoTO.setUsrFechaInsertaBanco(validaciones.Validacion.fecha(banBancoModificar.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                banco.entity.BanBanco banBanco = banco.helper.ConversionesBanco.convertirBanBancoTO_BanBanco(banBancoTO);
                comprobar = operacionesBancoDAOTransaccionLocal.modificarBanBanco(banBanco, sisSuceso);
            }

        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarBanBancoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);

        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean modificarBanCajaTO(
            BanCajaTO banCajaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            susClave = banCajaTO.getCajaCodigo() + " " + banCajaTO.getCajaNombre();
            susDetalle = "Se modificó la Caja " + banCajaTO.getCajaNombre() + " con código " + banCajaTO.getCajaCodigo();
            susSuceso = "UPDATE";
            susTabla = "banco.ban_caja";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            banCajaTO.setUsrFechaInsertaCaja(validaciones.Validacion.fechaSistema());
            banco.entity.BanCaja banCajaModificar = operacionesBancoDAOLocal.buscarBanCaja(banCajaTO.getEmpCodigo(), banCajaTO.getCajaCodigo());
            if (banCajaModificar != null) {
                banCajaTO.setUsrInsertaCaja(banCajaModificar.getUsrCodigo());
                banCajaTO.setUsrFechaInsertaCaja(validaciones.Validacion.fecha(banCajaModificar.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                banco.entity.BanCaja banCaja = banco.helper.ConversionesBanco.convertirBanCajaTO_BanCaja(banCajaTO);
                comprobar = operacionesBancoDAOTransaccionLocal.modificarBanCaja(banCaja, sisSuceso);
//                    }
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarBanCajaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean modificarBanCuentaTO(
            BanCuentaTO banCuentaTO,
            String codigoBanco,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            susClave = banCuentaTO.getCtaContable().toString();
            susDetalle = "Se modificó la Cuenta de la cuenta contable " + banCuentaTO.getCtaContable();
            susSuceso = "UPDATE";
            susTabla = "banco.ban_cuenta";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            banCuentaTO.setUsrFechaInsertaCuenta(validaciones.Validacion.fechaSistema());
            banco.entity.BanCuenta banCuentaModificar = operacionesBancoDAOLocal.buscarBanCuenta(banCuentaTO.getCtaEmpresa(), banCuentaTO.getCtaContable());
            if (banCuentaModificar != null) {
                banCuentaTO.setUsrInsertaCuenta(banCuentaModificar.getUsrCodigo());
                banCuentaTO.setUsrFechaInsertaCuenta(validaciones.Validacion.fecha(banCuentaModificar.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                banco.entity.BanCuenta banCuenta = banco.helper.ConversionesBanco.convertirBanCuentaTO_BanCuenta(banCuentaTO);
                banco.entity.BanBanco banBanco = operacionesBancoDAOLocal.buscarBanBanco(banCuentaTO.getCtaEmpresa(), codigoBanco);
                if (banBanco != null) {
                    banCuenta.setBanBanco(banBanco);
                    comprobar = operacionesBancoDAOTransaccionLocal.modificarBanCuenta(banCuenta, sisSuceso);
                }
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarBanCuentaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA ELIMINAR BANCOS, CAJAS Y CUENTAS">

    @Override
    public boolean eliminarBanBancoTO(
            BanBancoTO banBancoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            susClave = banBancoTO.getBanCodigo()
                    + " " + banBancoTO.getBanNombre();
            susDetalle = "Se eliminó el Banco " + banBancoTO.getBanNombre() + " con código " + banBancoTO.getBanCodigo();
            susSuceso = "UPDATE";
            susTabla = "banco.ban_banco";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            banBancoTO.setUsrFechaInsertaBanco(validaciones.Validacion.fechaSistema());
            banco.entity.BanBanco banBancoModificar = operacionesBancoDAOLocal.buscarBanBanco(banBancoTO.getEmpCodigo(), banBancoTO.getBanCodigo());
            if (banBancoModificar != null) {
                banBancoTO.setUsrInsertaBanco(banBancoModificar.getUsrCodigo());
                banBancoTO.setUsrFechaInsertaBanco(validaciones.Validacion.fecha(banBancoModificar.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                banco.entity.BanBanco banBanco = banco.helper.ConversionesBanco.convertirBanBancoTO_BanBanco(banBancoTO);
                comprobar = operacionesBancoDAOTransaccionLocal.eliminarBanBanco(banBanco, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarBanBancoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean eliminarBanCajaTO(
            BanCajaTO banCajaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            susClave = banCajaTO.getCajaCodigo()
                    + " " + banCajaTO.getCajaNombre();
            susDetalle = "Se eliminó la Caja " + banCajaTO.getCajaNombre() + " con código " + banCajaTO.getCajaCodigo();
            susSuceso = "UPDATE";
            susTabla = "banco.ban_caja";
            banCajaTO.setUsrFechaInsertaCaja(validaciones.Validacion.fechaSistema());
            banco.entity.BanCaja banCajaModificar = operacionesBancoDAOLocal.buscarBanCaja(banCajaTO.getEmpCodigo(), banCajaTO.getCajaCodigo());
            if (banCajaModificar != null) {
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                banCajaTO.setUsrInsertaCaja(banCajaModificar.getUsrCodigo());
                banCajaTO.setUsrFechaInsertaCaja(validaciones.Validacion.fecha(banCajaModificar.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                banco.entity.BanCaja banCaja = banco.helper.ConversionesBanco.convertirBanCajaTO_BanCaja(banCajaTO);
                comprobar = operacionesBancoDAOTransaccionLocal.eliminarBanCaja(banCaja, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarBanCajaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public boolean eliminarBanCuentaTO(
            BanCuentaTO banCuentaTO,
            String codigoBanco,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            if (!operacionesBancoDAOLocal.canDeleteCuenta(banCuentaTO.getCtaEmpresa(), banCuentaTO.getCtaContable())) {
                susClave = banCuentaTO.getCtaContable().toString();
                susDetalle = "Se eliminó la Cuenta de la cuenta contable " + banCuentaTO.getCtaContable();
                susSuceso = "UPDATE";
                susTabla = "banco.ban_cuenta";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                banCuentaTO.setUsrFechaInsertaCuenta(validaciones.Validacion.fechaSistema());
                banco.entity.BanCuenta banCuentaModificar = operacionesBancoDAOLocal.buscarBanCuenta(banCuentaTO.getCtaEmpresa(),
                        banCuentaTO.getCtaContable().toString());
                if (banCuentaModificar != null) {
                    banCuentaTO.setUsrInsertaCuenta(banCuentaModificar.getUsrCodigo());
                    banCuentaTO.setUsrFechaInsertaCuenta(validaciones.Validacion.fecha(banCuentaModificar.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                    banco.entity.BanCuenta banCuenta = banco.helper.ConversionesBanco.convertirBanCuentaTO_BanCuenta(banCuentaTO);
                    banco.entity.BanBanco banBanco = operacionesBancoDAOLocal.buscarBanBanco(banCuentaTO.getCtaEmpresa(), codigoBanco);
                    if (banBanco != null) {
                        banCuenta.setBanBanco(banBanco);
                        comprobar = operacionesBancoDAOTransaccionLocal.eliminarBanCuenta(banCuenta, sisSuceso);
                    }
                }
            }
        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarBanCuentaTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }
    // </editor-fold>

    @Override
    public java.lang.String getBanConciliacionFechaHasta(
            java.lang.String empresa,
            java.lang.String cuenta) throws java.lang.Exception {
        return operacionesBancoDAOLocal.getBanConciliacionFechaHasta(empresa, cuenta);
    }

    @Override
    public java.util.List<banco.TO.BanComboBancoTO> getBanComboBancoTO(
            String empresa) throws Exception {
        return operacionesBancoDAOLocal.getBanComboBancoTO(empresa);
    }

    @Override
    public java.lang.Boolean conciliacionHasta(
            java.lang.String empresa,
            java.lang.String hasta,
            String cuenta) throws java.lang.Exception {
        return operacionesBancoDAOLocal.conciliacionHasta(empresa, hasta, cuenta);
    }

    @Override
    public boolean conciliacionPendiente(
            java.lang.String empresa) throws Exception {
        return operacionesBancoDAOLocal.conciliacionPendiente(empresa);
    }

    @Override
    public java.util.List<banco.TO.BanListaConciliacionTO> getBanListaConciliacionTO(
            java.lang.String empresa,
            java.lang.String buscar) throws Exception {
        return operacionesBancoDAOLocal.getBanListaConciliacionTO(empresa, buscar);
    }

    @Override
    public java.util.List<banco.TO.BanListaConciliacionBancariaTO> getBanListaConciliacionBancariaDebitoTO(
            String empresa,
            String cuenta,
            String codigo,
            String hasta) throws Exception {
        return operacionesBancoDAOLocal.getBanListaConciliacionBancariaDebitoTO(empresa, cuenta, codigo, hasta);
    }

    @Override
    public java.util.List<banco.TO.BanListaConciliacionBancariaTO> getBanListaConciliacionBancariaCreditoTO(
            String empresa,
            String cuenta,
            String codigo,
            String hasta) throws Exception {
        return operacionesBancoDAOLocal.getBanListaConciliacionBancariaCreditoTO(empresa, cuenta, codigo, hasta);
    }

    @Override
    public java.math.BigDecimal getBanValorSaldoSistema(String empresa, String cuenta, String hasta) throws Exception {
        return operacionesBancoDAOLocal.getBanValorSaldoSistema(empresa, cuenta, hasta);
    }
//    BanConciliacionTO

    private java.util.List<banco.entity.BanCheque> listaCheques(
            java.util.List<banco.TO.BanChequeTO> banChequeTOs) throws Exception {
        banco.entity.BanCheque banCheque = null;
        banco.entity.BanCheque banChequeAux = null;
        java.util.List<banco.entity.BanCheque> banCheques = new java.util.ArrayList(0);
        for (banco.TO.BanChequeTO banChequeTO : banChequeTOs) {
            ///// BUSCANDO banCheque
            banChequeAux = operacionesBancoDAOLocal.buscarBanCheque(banChequeTO.getChqSecuencia());
            if (banChequeAux != null) {
                banCheque = banco.helper.ConversionesBanco.convertirBanCheque_BanCheque(banChequeAux);
                banCheque.setConcCodigo(banChequeTO.getConcCodigo());
                banCheque.setConcCuentaContable(banChequeTO.getConcCuentaContable());
                banCheque.setConcEmpresa(banChequeTO.getConcEmpresa());
            } else {
                banCheque = banco.helper.ConversionesBanco.convertirBanChequeTO_BanCheque(banChequeTO);
            }
            banCheques.add(banCheque);
            banCheque = null;
        }
        return banCheques;
    }

    @Override
    public String accionBanConciliacionTO(
            banco.TO.BanConciliacionTO banConciliacionTO,
            java.util.List<banco.TO.BanChequeTO> banChequeTOs,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        mensaje = "";

        try {
            ///// BUSCANDO banCuenta
            banco.entity.BanCuenta banCuenta = operacionesBancoDAOLocal.buscarBanCuenta(
                    banConciliacionTO.getConcEmpresa(),
                    banConciliacionTO.getConcCuentaContable());
            String estadoPeriodo = operacionesSistemaBusinessLocal.estadoPeriodo(banConciliacionTO.getConcEmpresa(), banConciliacionTO.getConcHasta());
            if (estadoPeriodo.isEmpty()) {
                if (banCuenta != null) {
                    ///// CREANDO Suceso
                    susClave = banConciliacionTO.getConcCodigo()
                            + " " + banConciliacionTO.getConcCuentaContable();
                    if (accion == 'I') {
                        susDetalle = "Se ingresó la conciliación con código " + banConciliacionTO.getConcCodigo() + " y cuenta contable " + banConciliacionTO.getConcCuentaContable();
                        susSuceso = "INSERT";
                    }
                    if (accion == 'M') {
                        susDetalle = "Se modificó la conciliación con código " + banConciliacionTO.getConcCodigo() + " y cuenta contable " + banConciliacionTO.getConcCuentaContable();
                        susSuceso = "UPDATE";
                    }
                    if (accion == 'E') {
                        susDetalle = "Se eliminó la conciliación con código " + banConciliacionTO.getConcCodigo() + " y cuenta contable " + banConciliacionTO.getConcCuentaContable();
                        susSuceso = "DELETE";
                    }
                    susTabla = "banco.ban_conciliacion";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);
                    ///// CREANDO BanConciliacion
                    banco.entity.BanConciliacion banConciliacion = banco.helper.ConversionesBanco.convertirBanConciliacionTO_BanConciliacion(banConciliacionTO);
                    banConciliacion.setBanCuenta(operacionesBancoDAOLocal.buscarBanCuenta(
                            banConciliacionTO.getConcEmpresa(),
                            banConciliacionTO.getConcCuentaContable()));

                    if (accion == 'E') {
                        ////// BUSCANDO existencia BanConciliacion
                        if (operacionesBancoDAOLocal.buscarBanConciliacion(
                                banConciliacionTO.getConcEmpresa(),
                                banConciliacionTO.getConcCuentaContable(),
                                banConciliacionTO.getConcCodigo()) != null) {
                            ////// BUSCANDO fecha hasta
                            String fechaHasta = operacionesBancoDAOLocal.getBanConciliacionFechaHasta(
                                    banConciliacionTO.getConcEmpresa(),
                                    banConciliacionTO.getConcCuentaContable());
                            if (banConciliacionTO.getConcHasta().equals(fechaHasta)) {
                                banConciliacion.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                                comprobar = operacionesBancoDAOTransaccionLocal.accionBanConciliacion(banConciliacion, listaCheques(banChequeTOs), sisSuceso, accion);
                            } else {
                                mensaje = "FNo se puede eliminar porque no es la última conciliación...";
                            }
                        } else {
                            mensaje = "FNo se encuentra la Conciliación...";
                        }
                    }
                    if (accion == 'M') {
                        ////// BUSCANDO existencia BanConciliacion
                        if (operacionesBancoDAOLocal.buscarBanConciliacion(
                                banConciliacionTO.getConcEmpresa(),
                                banConciliacionTO.getConcCuentaContable(),
                                banConciliacionTO.getConcCodigo()) != null) {
                            banConciliacion.setUsrFechaInserta(operacionesBancoDAOLocal.buscarBanConciliacion(
                                    banConciliacionTO.getConcEmpresa(),
                                    banConciliacionTO.getConcCuentaContable(),
                                    banConciliacionTO.getConcCodigo()).getUsrFechaInserta());
                            comprobar = operacionesBancoDAOTransaccionLocal.accionBanConciliacion(banConciliacion, listaCheques(banChequeTOs), sisSuceso, accion);
                        } else {
                            mensaje = "FNo se encuentra la Conciliación...";
                        }
                    }
                    if (accion == 'I') {
                        ///// VERIFICAR Conciliacion
                        if (operacionesBancoDAOLocal.conciliacionHasta(
                                banConciliacionTO.getConcEmpresa(),
                                banConciliacionTO.getConcHasta(),
                                banConciliacionTO.getConcCuentaContable())) {
                            ////// BUSCANDO existencia BanConciliacion
                            if (operacionesBancoDAOLocal.buscarBanConciliacion(
                                    banConciliacionTO.getConcEmpresa(),
                                    banConciliacionTO.getConcCuentaContable(),
                                    banConciliacionTO.getConcCodigo()) == null) {
                                ////// BUSCANDO existencia BanCuenta
                                if (operacionesBancoDAOLocal.buscarBanCuenta(
                                        banConciliacionTO.getConcEmpresa(),
                                        banConciliacionTO.getConcCuentaContable()) != null) {
                                    banConciliacion.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                                    comprobar = operacionesBancoDAOTransaccionLocal.accionBanConciliacion(banConciliacion, listaCheques(banChequeTOs), sisSuceso, accion);
                                } else {
                                    mensaje = "FLa cuenta contable para la Conciliación no existe...";
                                }
                            } else {
                                mensaje = "FYa existe la Conciliación...";
                            }
                        } else {
                            mensaje = "FLa fecha de conciliación tiene que ser mayor a la última registrada...";
                        }
                    }
                    if (comprobar) {
                        if (accion == 'E') {
                            mensaje = "TSe eliminó correctamente la Conciliación";
                        }
                        if (accion == 'M') {
                            mensaje = "TSe modificó correctamente la Conciliación";
                        }
                        if (accion == 'I') {
                            mensaje = "TSe ingresó correctamente la Conciliación";
                        }
                    }
                } else {
                    mensaje = "FNo se encuentra cuenta contable...";
                }
            } else {
                mensaje = "F" + estadoPeriodo;
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la conciliación, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionBanConciliacionTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public java.util.List<banco.TO.BanListaChequeTO> getBanListaChequeTO(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String tipo) throws java.lang.Exception {
        return operacionesBancoDAOLocal.getBanListaChequeTO(empresa, cuenta, desde, hasta, tipo);
    }

    @Override
    public java.util.List<banco.TO.BanComboCuentaTO> getBanComboCuentaTO(
            java.lang.String empresa) throws java.lang.Exception {
        return operacionesBancoDAOLocal.getBanComboCuentaTO(empresa);
    }

    @Override
    public java.util.List<banco.TO.BanFunChequesNoEntregadosTO> getBanFunChequesNoEntregadosTO(
            java.lang.String empresa,
            java.lang.String cuenta) throws java.lang.Exception {
        return operacionesBancoDAOLocal.getBanFunChequesNoEntregadosTO(empresa, cuenta);
    }

    @Override
    public java.util.List<String> insertarBanFunChequesNoEntregados(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.util.List<banco.TO.BanFunChequesNoEntregadosTO> banFunChequesNoEntregadosTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        java.util.List<String> lista = new java.util.ArrayList(1);
        mensaje = "";
        try {
            sistemaWeb.entity.SisEmpresa sisEmpresa = operacionesSistemaDAOLocal.buscarEmpresa(empresa);
            java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos = new java.util.ArrayList(0);
            sistemaWeb.entity.SisSuceso sisSuceso = null;
            ///// LISTA CHEQUES NO ENTREGADOS
            java.util.List<banco.TO.BanFunChequesNoEntregadosTO> banFunChequesNoEntregadosTOAuxs = operacionesBancoDAOLocal.getBanFunChequesNoEntregadosTO(empresa, cuenta);
            banco.entity.BanCheque banCheque = null;
            banco.entity.BanCheque banChequeAux = null;
            java.util.List<banco.entity.BanCheque> banCheques = new java.util.ArrayList(0);
            contabilidad.TO.ConContableConDetalle conContableConDetalle;
            java.util.List<contabilidad.TO.ConContableConDetalle> conContableConDetalles = new java.util.ArrayList(0);
            boolean estado;
            for (banco.TO.BanFunChequesNoEntregadosTO banFunChequesNoEntregadosTOAux : banFunChequesNoEntregadosTOAuxs) {
                estado = false;
                for (banco.TO.BanFunChequesNoEntregadosTO banFunChequesNoEntregadosTO : banFunChequesNoEntregadosTOs) {
                    //secuencia y valor son iguales
                    if (banFunChequesNoEntregadosTOAux.getChqSecuencia().equals(banFunChequesNoEntregadosTO.getChqSecuencia())) {
                        if (banFunChequesNoEntregadosTOAux.getChqValor().compareTo(banFunChequesNoEntregadosTO.getChqValor()) == 0) {
                            ///// BUSCANDO banCheque
                            banCheque = operacionesBancoDAOLocal.buscarBanCheque(new Long(banFunChequesNoEntregadosTO.getChqSecuencia().toString()));
                            if (banCheque != null) {
                                ///// BUSCANDO CONTABLE
                                conContableConDetalle = operacionesContabilidadBusinessLocal.buscarConContableConDetalle(Long.parseLong(banFunChequesNoEntregadosTO.getChqSecuencia().toString()));
                                if (conContableConDetalle != null) {
                                    if (!conContableConDetalle.getConContable().getConAnulado()
                                            && !conContableConDetalle.getConContable().getConPendiente()) {
                                        conContableConDetalle.getConContable().setConBloqueado(true);
                                        conContableConDetalle.getConDetalle().setDetGenerado(true);
                                        conContableConDetalles.add(conContableConDetalle);
                                    } else {
                                        mensaje = "FEl contable ya fué anulado y/o esta como pendiente el cheque " + banFunChequesNoEntregadosTO.getChqNumero();
                                    }
                                } else {
                                    mensaje = "FNo se encontro el contable del cheque " + banFunChequesNoEntregadosTO.getChqNumero();
                                }
                                if (mensaje.isEmpty()) {
                                    banChequeAux = banco.helper.ConversionesBanco.convertirBanCheque_BanCheque(banCheque);
                                    banChequeAux.setChqEntregado(banFunChequesNoEntregadosTO.isEstado());
                                    banChequeAux.setChqEntregadoObservacion(banFunChequesNoEntregadosTO.getChqObservacion());
                                    banChequeAux.setChqEntregadoFecha(validaciones.Validacion.fecha(validaciones.Validacion.fechaSistema(), "yyyy-MM-dd HH:mm:ss"));
                                    banCheques.add(banChequeAux);
                                    susDetalle = "";
                                    susClave = banFunChequesNoEntregadosTO.getChqSecuencia().toString();
                                    susSuceso = "UPDATE";
                                    susTabla = "banco.ban_cheque";
                                    sisSuceso = validaciones.Suceso.crearSisSuceso(
                                            susTabla,
                                            susClave,
                                            susSuceso,
                                            susDetalle,
                                            sisInfoTO);
                                    sisSucesos.add(sisSuceso);
                                }
                            } else {
                                ///// BUSCANDO CONTABLE
                                conContableConDetalle = operacionesContabilidadBusinessLocal.buscarConContableConDetalle(Long.parseLong(banFunChequesNoEntregadosTO.getChqSecuencia().toString()));
                                if (conContableConDetalle != null) {
                                    if (!conContableConDetalle.getConContable().getConAnulado()
                                            && !conContableConDetalle.getConContable().getConPendiente()) {
                                        conContableConDetalle.getConContable().setConBloqueado(true);
                                        conContableConDetalle.getConDetalle().setDetGenerado(true);
                                        conContableConDetalles.add(conContableConDetalle);
                                    } else {
                                        mensaje = "FEl contable ya fué anulado y/o esta como pendiente el cheque " + banFunChequesNoEntregadosTO.getChqNumero();
                                    }
                                } else {
                                    mensaje = "FNo se encontro el contable del cheque " + banFunChequesNoEntregadosTO.getChqNumero();
                                }
                                if (mensaje.isEmpty()) {
                                    banChequeAux = new banco.entity.BanCheque();
                                    banChequeAux.setChqBeneficiario(banFunChequesNoEntregadosTO.getChqBeneficiario().trim());
                                    banChequeAux.setChqCantidad(validaciones.NumberToLetterConverter.convertNumberToLetter(banFunChequesNoEntregadosTO.getChqValor().toPlainString()));
                                    banChequeAux.setChqCiudad(sisEmpresa.getEmpCiudad());
                                    banChequeAux.setChqFecha(validaciones.Validacion.fecha(banFunChequesNoEntregadosTO.getChqFechaEmision(), "yyyy-MM-dd"));
                                    banChequeAux.setChqImpreso(false);
                                    banChequeAux.setChqRevisado(false);
                                    banChequeAux.setChqEntregado(banFunChequesNoEntregadosTO.isEstado());
                                    banChequeAux.setChqEntregadoObservacion(banFunChequesNoEntregadosTO.getChqObservacion());
                                    banChequeAux.setChqEntregadoFecha(validaciones.Validacion.fecha(validaciones.Validacion.fechaSistema(), "yyyy-MM-dd HH:mm:ss"));
                                    banChequeAux.setConcEmpresa(null);
                                    banChequeAux.setConcCuentaContable(null);
                                    banChequeAux.setConcCodigo(null);
                                    banChequeAux.setDetSecuencia(banFunChequesNoEntregadosTO.getChqSecuencia().longValue());
                                    banChequeAux.setChqSecuencia(banFunChequesNoEntregadosTO.getChqSecuencia().longValue());
                                    banChequeAux.setChqCruzado(false);
                                    banChequeAux.setChqNoEsCheque(false);
                                    banCheques.add(banChequeAux);
                                }
                            }
                        } else {
                            mensaje = "FEl cheque: " + banFunChequesNoEntregadosTO.getChqNumero() + " tiene otro valor..";
                        }
                        break;
                    }
                }
                if (!mensaje.isEmpty()) {
                    if (lista.isEmpty()) {
                        lista.add("FProblemas con los siguientes cheques");
                        lista.add(mensaje);
                    } else {
                        lista.add(mensaje);
                    }
                }

                banCheque = null;
                sisSuceso = null;
                mensaje = "";
            }
            if (lista.isEmpty()) {
                comprobar = operacionesBancoDAOTransaccionLocal.accionBanCheques(banCheques, conContableConDetalles, sisSucesos, 'I');
                if (comprobar) {
                    lista.add("TLos cheques han sido guardados..");
                } else {
                    lista.add("Hubieron problemas al intentar guardar..\nContacte con el administrador..");
                }
            }
            return lista;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor..\nContacte con el administrador..";
            lista.add(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhXiiiSueldoConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return lista;
        }
    }

    @Override
    public java.util.List<banco.TO.BanFunChequesNoRevisadosTO> getBanFunChequesNoRevisadosTO(java.lang.String empresa, java.lang.String cuenta) throws java.lang.Exception {
        return operacionesBancoDAOLocal.getBanFunChequesNoRevisadosTO(empresa, cuenta);
    }

    @Override
    public java.util.List<String> insertarBanFunChequesNoRevisados(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.util.List<banco.TO.BanFunChequesNoRevisadosTO> banFunChequesNoRevisadosTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        java.util.List<String> lista = new java.util.ArrayList(1);
        mensaje = "";
        try {
            sistemaWeb.entity.SisEmpresa sisEmpresa = operacionesSistemaDAOLocal.buscarEmpresa(empresa);
            sistemaWeb.entity.SisSuceso sisSuceso = null;
            java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos = new java.util.ArrayList(0);
            ///// LISTA CHEQUES NO Revisados
            java.util.List<banco.TO.BanFunChequesNoRevisadosTO> banFunChequesNoRevisadosTOAuxs = operacionesBancoDAOLocal.getBanFunChequesNoRevisadosTO(empresa, cuenta);
            ///// 
            banco.entity.BanCheque banCheque = null;
            banco.entity.BanCheque banChequeAux = null;
            java.util.List<banco.entity.BanCheque> banCheques = new java.util.ArrayList(0);
            contabilidad.TO.ConContableConDetalle conContableConDetalle;
            java.util.List<contabilidad.TO.ConContableConDetalle> conContableConDetalles = new java.util.ArrayList(0);
            boolean estado;
            for (banco.TO.BanFunChequesNoRevisadosTO banFunChequesNoRevisadosTOAux : banFunChequesNoRevisadosTOAuxs) {
                estado = false;
                for (banco.TO.BanFunChequesNoRevisadosTO banFunChequesNoRevisadosTO : banFunChequesNoRevisadosTOs) {
                    //secuencia y valor son iguales
                    if (banFunChequesNoRevisadosTOAux.getChqSecuencia().equals(banFunChequesNoRevisadosTO.getChqSecuencia())) {
                        if (banFunChequesNoRevisadosTOAux.getChqValor().compareTo(banFunChequesNoRevisadosTO.getChqValor()) == 0) {
                            ///// BUSCANDO banCheque
                            banCheque = operacionesBancoDAOLocal.buscarBanCheque(new Long(banFunChequesNoRevisadosTO.getChqSecuencia().toString()));
                            if (banCheque != null) {
                                ///// BUSCANDO CONTABLE
                                conContableConDetalle = operacionesContabilidadBusinessLocal.buscarConContableConDetalle(Long.parseLong(banFunChequesNoRevisadosTO.getChqSecuencia().toString()));
                                if (conContableConDetalle != null) {
                                    if (!conContableConDetalle.getConContable().getConAnulado()
                                            && !conContableConDetalle.getConContable().getConPendiente()) {
                                        conContableConDetalle.getConContable().setConBloqueado(true);
                                        conContableConDetalles.add(conContableConDetalle);
                                    } else {
                                        mensaje = "FEl contable ya fué anulado y/o esta como pendiente el cheque " + banFunChequesNoRevisadosTO.getChqNumero();
                                    }
                                } else {
                                    mensaje = "FNo se encontro el contable del cheque " + banFunChequesNoRevisadosTO.getChqNumero();
                                }
                                if (mensaje.isEmpty()) {
                                    banChequeAux = banco.helper.ConversionesBanco.convertirBanCheque_BanCheque(banCheque);
                                    banChequeAux.setChqRevisado(banFunChequesNoRevisadosTO.isEstado());
                                    banChequeAux.setChqRevisadoObservacion(banFunChequesNoRevisadosTO.getChqObservacion());
                                    banChequeAux.setChqRevisadoFecha(validaciones.Validacion.fecha(validaciones.Validacion.fechaSistema(), "yyyy-MM-dd HH:mm:ss"));
                                    banCheques.add(banChequeAux);
                                    /////
                                    susDetalle = "";
                                    susClave = banFunChequesNoRevisadosTO.getChqSecuencia().toString();
                                    susSuceso = "UPDATE";
                                    susTabla = "banco.ban_cheque";
                                    sisSuceso = validaciones.Suceso.crearSisSuceso(
                                            susTabla,
                                            susClave,
                                            susSuceso,
                                            susDetalle,
                                            sisInfoTO);
                                    sisSucesos.add(sisSuceso);
                                }
                            } else {

                                ///// BUSCANDO CONTABLE
                                conContableConDetalle = operacionesContabilidadBusinessLocal.buscarConContableConDetalle(Long.parseLong(banFunChequesNoRevisadosTO.getChqSecuencia().toString()));
                                if (conContableConDetalle != null) {
                                    if (!conContableConDetalle.getConContable().getConAnulado()
                                            && !conContableConDetalle.getConContable().getConPendiente()) {
                                        conContableConDetalle.getConContable().setConBloqueado(true);
                                        conContableConDetalles.add(conContableConDetalle);
                                    } else {
                                        mensaje = "FEl contable ya fué anulado y/o esta como pendiente el cheque " + banFunChequesNoRevisadosTO.getChqNumero();
                                    }
                                } else {
                                    mensaje = "FNo se encontro el contable del cheque " + banFunChequesNoRevisadosTO.getChqNumero();
                                }
                                if (mensaje.isEmpty()) {
                                    banChequeAux = new banco.entity.BanCheque();
                                    banChequeAux.setChqBeneficiario(banFunChequesNoRevisadosTO.getChqBeneficiario().trim());
                                    banChequeAux.setChqCantidad(validaciones.NumberToLetterConverter.convertNumberToLetter(banFunChequesNoRevisadosTO.getChqValor().toPlainString()));
                                    banChequeAux.setChqCiudad(sisEmpresa.getEmpCiudad());
                                    banChequeAux.setChqFecha(validaciones.Validacion.fecha(banFunChequesNoRevisadosTO.getChqFechaEmision(), "yyyy-MM-dd"));
                                    banChequeAux.setChqImpreso(false);
                                    banChequeAux.setChqRevisado(banFunChequesNoRevisadosTO.isEstado());
                                    banChequeAux.setChqRevisadoFecha(validaciones.Validacion.fecha(validaciones.Validacion.fechaSistema(), "yyyy-MM-dd HH:mm:ss"));
                                    banChequeAux.setChqRevisadoObservacion(banFunChequesNoRevisadosTO.getChqObservacion());
                                    banChequeAux.setChqEntregado(false);
                                    banChequeAux.setConcEmpresa(null);
                                    banChequeAux.setConcCuentaContable(null);
                                    banChequeAux.setConcCodigo(null);
                                    banChequeAux.setDetSecuencia(banFunChequesNoRevisadosTO.getChqSecuencia().longValue());
                                    banChequeAux.setChqSecuencia(banFunChequesNoRevisadosTO.getChqSecuencia().longValue());
                                    banChequeAux.setChqCruzado(false);
                                    banChequeAux.setChqNoEsCheque(false);
                                    banCheques.add(banChequeAux);
                                }
                            }
                        } else {
                            mensaje = "El cheque: " + banFunChequesNoRevisadosTO.getChqNumero() + " tiene otro valor..";
                        }
                        break;
                    }
                }
                if (!mensaje.isEmpty()) {
                    if (lista.isEmpty()) {
                        lista.add("FProblemas con los siguientes cheques");
                    } else {
                        lista.add(mensaje);
                    }
                }

                banCheque = null;
                sisSuceso = null;
                mensaje = "";
            }
            if (lista.isEmpty()) {
                comprobar = operacionesBancoDAOTransaccionLocal.accionBanCheques(banCheques, conContableConDetalles, sisSucesos, 'I');
                if (comprobar) {
                    lista.add("TLos cheques han sido guardados..");
                } else {
                    lista.add("FHubieron problemas al intentar guardar..\nContacte con el administrador..");
                }
            }
            return lista;
        } catch (Exception e) {
            mensaje = "FHubo problemas en la validación del lado del servidor..\nContacte con el administrador..";
            lista.add(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhXiiiSueldoConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return lista;
        }
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Cuentas Contables en BANCOS
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<String> getBanCuentasContablesBancos(String empresa) throws Exception {
        return operacionesBancoDAOLocal.getBanCuentasContablesBancos(empresa);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Cheques Preavisados
     * @throws Exception Cualquier error inesperado
     */
    //4
    @Override
    public java.util.List<banco.TO.BanChequePreavisadoTO> getBanFunChequesPreavisados(String empresa, String cuenta) throws Exception {
        return operacionesBancoDAOLocal.getBanFunChequesPreavisados(empresa, cuenta, operacionesBancoDAOLocal.getNombreBanco(empresa, cuenta));
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return numero de registros de la tabla
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public int getConteoChequesPreavisados(String empresa, java.lang.String cuenta) throws Exception {
        return operacionesBancoDAOLocal.getConteoChequesPreavisados(empresa, cuenta);
    }

    /**
     * @autor jack krauser Metodo para ingresar informacion con respecto a
     * archivo de preaviso
     *
     * @param banPreavisosTO objeto con la informacion de preaviso
     * @param cantidaDePreavisos numero de preavisos que se generan
     * @return Mensaje con el estado de la transaccion
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String insertarPreaviso(
            banco.TO.BanPreavisosTO banPreavisosTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensajes = "";
        try {
            /// CREAR EL SUCESO
            susSuceso = "INSERT";
            susClave = banPreavisosTO.getPreCuentaContable();
            susDetalle = "Se inserta un preaviso de cheques.";
            susTabla = "banco.ban_preavisos";
            ///// CREANDO CarPagosForma
            banco.entity.BanPreavisos banPreavisos = banco.helper.ConversionesBanco.convertirBanPreavisosTO_BanPreavisos(banPreavisosTO);
            comprobar = false;
            if (operacionesBancoDAOLocal.getConteoChequesPreavisados(banPreavisosTO.getPreEmpresa(), banPreavisosTO.getPreCuentaContable(), banPreavisosTO.getPreNombreArchivoGenerado()) == 0) {
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                comprobar = operacionesBancoDAOTransaccionLocal.insertarPreaviso(banPreavisos, sisSuceso);
                if (comprobar) {
                    mensajes = "T";
                } else {
                    mensajes = "FHubo un error en el lado del servidor al intentar almacenar la información...";
                }
            } else {
                mensajes = "FEl registro que se intenta guardar ya existe. Contacte con el administrador...";
            }
        } catch (Exception e) {
            mensajes = "FOcurrió un error al INSERTAR EL PREAVISO DE CHEQUE, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPreaviso",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensajes;
        }
    }

    /**
     * @autor jack krauser Metodo para ingresar informacion con respecto a
     * archivo de preaviso
     *
     * @param empresa
     * @param usuario
     * @param cuenta cuenta contable
     * @return Mensaje con el estado de la transaccion
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.lang.String eliminarBanPreaviso(
            java.lang.String empresa,
            java.lang.String usuario,
            java.lang.String cuenta,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        String mensajes = "";
        try {
            ///// CREANDO Suceso
            susSuceso = "DELETE";
            susClave = cuenta;
            susTabla = "banco.ban_preavisos";
            banco.entity.BanPreavisos banPreavisos = operacionesBancoDAOLocal.getBanPreavisos(empresa, cuenta);
            if (banPreavisos != null) {
                susDetalle = "Se eliminó el archivo " + banPreavisos.getBanPreavisosPK().getPreNombreArchivoGenerado() + " de preaviso..";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                comprobar = operacionesBancoDAOTransaccionLocal.eliminarBanPreaviso(banPreavisos, sisSuceso);
                if (comprobar) {
                    mensajes = "TSe eliminó el preaviso\n" + banPreavisos.getBanPreavisosPK().getPreNombreArchivoGenerado();
                } else {
                    mensajes = "FHubo un error en el lado del servidor al intentar almacenar la información...";
                }
            } else {
                mensajes = "FNo existe preaviso para eliminar...";
            }
        } catch (Exception e) {
            mensajes = "FOcurrió un error al eliminar el ÚLTIMO PREAVISO DE CHEQUE, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPreaviso",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensajes;
        }
    }

    public String cambioDeCheque(
            String cuenta,
            String cuentaActual,
            String chequeAnterior,
            String chequeNuevo,
            String empresa,
            String usuario,
            String observaciones,
            String fecha,
            String con_tipo_cod,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensajes = "";
        try {
            ///// CREANDO Suceso
            susSuceso = "UPDATE";
            susClave = cuenta;
            susTabla = "banco.ban_cheque";
            java.util.List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList();
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(empresa);
            boolean periodoCerrado = false;
            String codPeriodo = "";
            comprobar = false;
            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (validaciones.Validacion.fecha(fecha, "yyyy-MM-dd").getTime()
                        >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && validaciones.Validacion.fecha(fecha, "yyyy-MM-dd").getTime()
                        <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                    comprobar = true;
                    codPeriodo = sisListaPeriodoTO.getPerCodigo();
                    periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                }
            }
            if (comprobar) {
                if (!periodoCerrado) {
                    if (operacionesContabilidadDAOLocal.buscarTipoContable(empresa, con_tipo_cod) != null) {
                        banco.TO.BanChequeTO banChequeTO = operacionesBancoDAOLocal.buscarBanChequeTO(empresa, cuenta, chequeAnterior);
                        if (banChequeTO.getChqSecuencia() != null/*
                                 * && !banChequeTO.getChqAnulado()
                                 */) {
                            if (!operacionesBancoDAOLocal.isExisteChequeAimprimir(empresa, cuentaActual, chequeNuevo, null)) {
                                contabilidad.entity.ConDetalle conDetalleAux = operacionesContabilidadDAOLocal.buscarDetalleContable(banChequeTO.getChqSecuencia());
                                if (conDetalleAux != null) {
                                    contabilidad.entity.ConCuentas conCuentas = operacionesContabilidadDAOLocal.buscarCuentas(empresa, cuenta);
                                    contabilidad.entity.ConCuentas conCuentasActual = operacionesContabilidadDAOLocal.buscarCuentas(empresa, cuentaActual);
                                    if (conCuentas != null) {
                                        banco.entity.BanCheque banCheque = banco.helper.ConversionesBanco.convertirBanChequeTO_BanCheque(banChequeTO);
                                        contabilidad.entity.ConContable conContable = new contabilidad.entity.ConContable();
                                        conContable.setConContablePK(new contabilidad.entity.ConContablePK(empresa, codPeriodo, con_tipo_cod, "0000001"));
                                        conContable.setConFecha(validaciones.Validacion.fecha(fecha, "yyyy-MM-dd"));
                                        conContable.setConPendiente(false);
                                        conContable.setConBloqueado(false);
                                        conContable.setConAnulado(false);
                                        conContable.setConGenerado(false);
                                        conContable.setConConcepto(banCheque.getChqBeneficiario());
                                        conContable.setConDetalle("CONTABLE GENERADO POR EL SISTEMA");
                                        conContable.setConObservaciones(observaciones);
                                        conContable.setUsrEmpresa(empresa);
                                        conContable.setUsrCodigo(usuario);
                                        conContable.setUsrFechaInserta(validaciones.Validacion.fecha(validaciones.Validacion.fechaSistema(), "yyyy-MM-dd HH:mm:ss"));
                                        contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion();
                                        conNumeracion.setConNumeracionPK(new contabilidad.entity.ConNumeracionPK(empresa, codPeriodo, con_tipo_cod));
                                        java.util.List<contabilidad.entity.ConDetalle> conDetalles = new java.util.ArrayList();
                                        contabilidad.entity.ConDetalle conDetalle = new contabilidad.entity.ConDetalle();
                                        conDetalle.setDetSecuencia(0);
                                        conDetalle.setSecCodigo(conDetalleAux.getSecCodigo());
                                        conDetalle.setPisNumero(conDetalleAux.getPisNumero());
                                        conDetalle.setDetDocumento(conDetalleAux.getDetDocumento());
                                        conDetalle.setDetDebitoCredito('D');
                                        conDetalle.setDetValor(conDetalleAux.getDetValor());
                                        conDetalle.setDetGenerado(true);
                                        conDetalle.setDetReferencia(conDetalleAux.getDetReferencia());
                                        conDetalle.setDetObservaciones(conDetalleAux.getDetObservaciones());
                                        conDetalle.setDetOrden(1);
                                        conDetalle.setConCuentas(conCuentas);
                                        conDetalle.setConContable(conContable);
                                        conDetalles.add(conDetalle);
                                        conDetalle = new contabilidad.entity.ConDetalle();
                                        conDetalle.setDetSecuencia(0);
                                        conDetalle.setSecCodigo(conDetalleAux.getSecCodigo());
                                        conDetalle.setPisNumero(conDetalleAux.getPisNumero());
                                        conDetalle.setDetDocumento(chequeNuevo);
                                        conDetalle.setDetDebitoCredito('C');
                                        conDetalle.setDetValor(conDetalleAux.getDetValor());
                                        conDetalle.setDetGenerado(true);
                                        conDetalle.setDetReferencia(conDetalleAux.getDetReferencia());
                                        conDetalle.setDetObservaciones(conDetalleAux.getDetObservaciones());
                                        conDetalle.setDetOrden(2);
                                        conDetalle.setConCuentas(conCuentasActual);
                                        conDetalle.setConContable(conContable);
                                        conDetalles.add(conDetalle);
                                        banCheque.setChqAnulado(true);
                                        banCheque.setChqAnuladoObservacion(observaciones);
                                        banCheque.setChqAnuladoFecha(validaciones.Validacion.fecha(validaciones.Validacion.fechaSistema(), "yyyy-MM-dd HH:mm:ss"));
                                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                susTabla,
                                                susClave,
                                                susSuceso,
                                                susDetalle,
                                                sisInfoTO);
                                        comprobar = false;
                                        comprobar = operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                                                conContable,
                                                conDetalles,
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
                                                banCheque,
                                                sisInfoTO);
                                        if (comprobar) {
                                            mensajes = "T<html>Se modificó correctamente el CHEQUE:<br><br>"
                                                    + "Periodo: <font size = 5>" + conContable.getConContablePK().getConPeriodo()
                                                    + "</font>.<br> Tipo: <font size = 5>" + conContable.getConContablePK().getConTipo()
                                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>"
                                                    + conContable.getConContablePK().getConPeriodo() + ", " + conContable.getConContablePK().getConNumero();
                                        } else {
                                            mensajes = "FHubo un error en el lado del servidor al intentar almacenar la información...";
                                        }

                                    } else {
                                        mensajes = "F<html>No se encuentra la CUENTA CONTABLE: " + cuenta + "</html>";
                                    }


                                } else {
                                    mensajes = "F<html>No se pudo recuperar la información contable del cheque...</html>";
                                }
                            } else {
                                mensajes = "F<html>El CHEQUE NUEVO ya existe...</html>";
                            }
                        } else {
                            mensajes = "F<html>El CHEQUE ANTERIOR no existe o ya esta anulado...</html>";
                        }
                    } else {
                        mensajes = "F<html>El TIPO DE CONTABLE 'CD' no se encuentra creado...</html>";
                    }
                } else {
                    mensajes = "F<html>El periodo que corresponde a la fecha " + fecha + " se encuentra cerrado...</html>";
                }
            } else {
                mensajes = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
            }

        } catch (Exception e) {
            mensajes = "FOcurrió un error al cambiar el NÚMERO DE CHEQUE, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarPreaviso",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensajes;
        }
    }

    @Override
    public banco.entity.BanCheque buscarBanCheque(Long secuencial) throws Exception {
        return operacionesBancoDAOLocal.buscarBanCheque(secuencial);
    }

    @Override
    public JasperPrint generarReporteConciliacion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, int estado, ReporteConciliacionCabecera conciliacionCabecera,
            List<BanListaConciliacionBancariaTO> listConciliacionCredito, List<BanListaConciliacionBancariaTO> listConciliacionDebito) throws Exception {
        return generarReporteBancoLocal.generarReporteConciliacion(sisUsuarioEmpresaTO, estado, conciliacionCabecera,
                listConciliacionCredito, listConciliacionDebito);
    }

    @Override
    public JasperPrint generarReporteListadoChequeEmisionVencimientoCobrarNumero(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String cuenta, String desde, String hasta, String tipo,
            List<BanListaChequeTO> listBanListaChequeTO) throws Exception {
        return generarReporteBancoLocal.generarReporteListadoChequeEmisionVencimientoCobrarNumero(sisUsuarioEmpresaTO, cuenta, desde, hasta, tipo, listBanListaChequeTO);
    }

    @Override
    public JasperPrint generarReporteCheque(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            BanChequeTO banChequeTO, String valorLetra1, String valorLetra2,
            String nombreReporteCheque, ConDetalle conDetalle, String cuentaCodigo) throws Exception {
        return generarReporteBancoLocal.generarReporteCheque(sisUsuarioEmpresaTO, banChequeTO, valorLetra1,
                valorLetra2, nombreReporteCheque, conDetalle, cuentaCodigo);
    }

    public Object getBanChequeSecuencial(String empresa, String cuenta) throws Exception {
        return operacionesBancoDAOLocal.getBanChequeSecuencial(empresa, cuenta);
    }
}
