/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.business;

import anexos.TO.*;
import anexos.entity.*;
import anexos.helper.ConversionesAnexos;
import anexos.reporte.GenerarReporteAnexosLocal;
import anexos.sri.comprobantes.util.UtilsWebService;
import anexos.sri.ws.autorizacion.RespuestaComprobante;
import anexos.sri.ws.recepcion.RespuestaSolicitud;
import inventario.TO.InvConsultaVentasFacturasPorNumeroTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisInfoTO;
import sistema.TO.SisPckeystoreTO;
import sistema.TO.SisUsuarioEmpresaTO;
import sistemaWeb.entity.SisSuceso;
import validaciones.Excepciones;
import validaciones.Suceso;
import validaciones.Validacion;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesAnexoBusiness1 implements OperacionesAnexoBusinessLocal1 {

    @javax.ejb.EJB
    anexos.DAO.OperacionesAnexoDAOLocal operacionesAnexoDAOLocal;
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOLocal operacionessistemaWebDAOLocal;
    @javax.ejb.EJB
    anexos.DAO.OperacionesAnexoDAOTransaccionLocal operacionesAnexoDAOTransaccionLocal;
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionessistemaWebDAOTransaccionLocal;
    @javax.ejb.EJB
    sistema.business.OperacionesSistemaBusinessLocal operacionessistemaWebBusinessLocal;
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @javax.ejb.EJB
    inventario.DAO.OperacionesInventarioDAOLocal operacionesInventarioDAOLocal;
    @EJB
    GenerarReporteAnexosLocal generarReporteAnexosLocal;
    private String susClave;
    private String susDetalle;
    private String susSuceso;
    private String susTabla;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<AnxEstablecimientoComboTO> getEstablecimientos(String empresa) throws Exception {
        return operacionesAnexoDAOLocal.getEstablecimientos(empresa);
    }

    @Override
    public List<AnxEstablecimientoComboTO> getPuntosEmision(String empresa, String establecimiento) throws Exception {
        return operacionesAnexoDAOLocal.getPuntosEmision(empresa, establecimiento);
    }

    @Override
    public anexos.TO.AnxNumeracionLineaTO getNumeroAutorizacion(String empresa, String numeroRetencion, String numeroComprobante, String fechaVencimiento) throws Exception {
        return operacionesAnexoDAOLocal.getNumeroAutorizacion(empresa, numeroRetencion, numeroComprobante, fechaVencimiento);
    }

    @Override
    public java.util.List<anexos.TO.AnxSustentoComboTO> getListaAnxSustentoComboTO(String tipoComprobante) throws Exception {
        return operacionesAnexoDAOLocal.getListaAnxSustentoComboTO(tipoComprobante);
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoComprobanteTablaTO> getListaAnexoTipoComprobanteTO(String codigo) throws Exception {
        return operacionesAnexoDAOLocal.getListaAnexoTipoComprobanteTO(codigo);
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoComboTO() throws Exception {
        return operacionesAnexoDAOLocal.getListaAnxConceptoTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoComboTO(String fechaRetencion) throws Exception {
        return operacionesAnexoDAOLocal.getListaAnxConceptoTO(fechaRetencion);
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoTO(java.lang.String fechaRetencion, java.lang.String busqueda) throws java.lang.Exception {
        return operacionesAnexoDAOLocal.getListaAnxConceptoTO(fechaRetencion, busqueda);
    }

    @Override
    public String getCodigoAnxTipoTransaccionTO(String tipoIdentificacion, String tipoTransaccion) throws Exception {
        return operacionesAnexoDAOLocal.getCodigoAnxTipoTransaccionTO(tipoIdentificacion, tipoTransaccion);
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoComprobanteComboTO> getListaAnxTipoComprobanteComboTO(String codigoTipoTransaccion) throws Exception {
        return operacionesAnexoDAOLocal.getListaAnxTipoComprobanteComboTO(codigoTipoTransaccion);
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoComprobanteComboTO> getListaAnxTipoComprobanteComboTOCompleto() throws Exception {
        return operacionesAnexoDAOLocal.getListaAnxTipoComprobanteComboTOCompleto();
    }

    @Override
    public java.math.BigDecimal getValorAnxPorcentajeIvaTO(String fechaFactura) throws Exception {
        if (fechaFactura.trim().isEmpty()) {
            fechaFactura = validaciones.Validacion.fechaSistema("yyyy-MM-dd");
        }
        return operacionesAnexoDAOLocal.getValorAnxPorcentajeIvaTO(fechaFactura);
    }

    @Override
    public java.math.BigDecimal getValorAnxMontoMaximoConsumidorFinalTO(String fechaFactura) throws Exception {
        if (fechaFactura.trim().isEmpty()) {
            fechaFactura = validaciones.Validacion.fechaSistema("yyyy-MM-dd");
        }
        return operacionesAnexoDAOLocal.getValorAnxMontoMaximoConsumidorFinalTO(fechaFactura);
    }

    @Override
    public anexos.TO.AnxCompraTO getAnexoCompraTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoCompraTO(empresa, periodo, motivo, numeroCompra);
    }

    @Override
    public java.util.List<anexos.TO.AnxCompraDetalleTO> getAnexoCompraDetalleTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoCompraDetalleTO(empresa, periodo, motivo, numeroCompra);
    }

    @Override
    public java.util.List<anexos.TO.AnxCompraReembolsoTO> getAnexoCompraReembolsoTOs(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoCompraReembolsoTOs(empresa, periodo, motivo, numeroCompra);
    }

    @Override
    public anexos.TO.AnxVentaTO getAnexoVentaTO(
            String empresa,
            String periodo,
            String motivo,
            String numeroVenta) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoVentaTO(
                empresa,
                periodo,
                motivo,
                numeroVenta);
    }

    @Override
    public anexos.entity.AnxCompra getAnexoCompra(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoCompra(empresa, periodo, motivo, numeroCompra);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesTO> getAnexoListaRetencionesTO(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoListaRetencionesTO(
                empresa,
                fechaDesde,
                fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesRentaTO> getAnexoListaRetencionesRentaTO(
            String empresa,
            String fechaDesde,
            String fechaHasta,
            String pOrden) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoListaRetencionesRentaTO(
                empresa,
                fechaDesde,
                fechaHasta,
                pOrden);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesFuenteIvaTO> getAnexoListaRetencionesFuenteIvaTO(
            String empresa,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoListaRetencionesFuenteIvaTO(
                empresa,
                fechaDesde,
                fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesTO> getAnexoFunListadoRetencionesPorNumero(String empresa, String fechaDesde, String fechaHasta, String parametroEstado) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoFunListadoRetencionesPorNumero(empresa, fechaDesde, fechaHasta, parametroEstado);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaComprobanteAnuladoTO> getAnxListaComprobanteAnuladoTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesAnexoDAOLocal.getAnxListaComprobanteAnuladoTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionVentaTO> getAnxListaRetencionVentaTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesAnexoDAOLocal.getAnxListaRetencionVentaTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaConsolidadoRetencionesVentasTO> getAnxListaConsolidadoRetencionesVentasTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesAnexoDAOLocal.getAnxListaConsolidadoRetencionesVentasTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaEstablecimientoRetencionesVentasTO> getAnxListaEstablecimientoRetencionesVentasTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesAnexoDAOLocal.getAnxListaEstablecimientoRetencionesVentasTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListadoRetencionesVentasTO> getAnxListadoRetencionesVentasTO(String empresa, String tipoDocumento, String establecimiento, String puntoEmision, String fechaDesde, String fechaHasta) throws java.lang.Exception {
        return operacionesAnexoDAOLocal.getAnxListadoRetencionesVentasTO(empresa, tipoDocumento, establecimiento, puntoEmision, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxTalonResumenTO> getAnexoTalonResumenTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoTalonResumenTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxTalonResumenVentaTO> getAnexoTalonResumenVentaTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoTalonResumenVentaTO(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxNumeracionTablaTO> getListaAnexoNumeracionTO(String empresa) throws Exception {
        return operacionesAnexoDAOLocal.getListaAnexoNumeracionTO(empresa);
    }

    @Override
    public anexos.TO.AnxNumeracionTO getAnexoNumeracionTO(Integer secuencia) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoNumeracionTO(secuencia);
    }

    @Override
    public String insertarAnexoNumeracionTO(anexos.TO.AnxNumeracionTO anxNumeracionTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            if (operacionesAnexoDAOLocal.getAnexoNumeracion(anxNumeracionTO.getNumSecuencial()) == null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = anxNumeracionTO.getNumComprobante() + " | " + anxNumeracionTO.getNumDesde() + " | " + anxNumeracionTO.getNumHasta();
                susDetalle = "Se insertó una numeración con código " + anxNumeracionTO.getNumComprobante() + " " + anxNumeracionTO.getNumDesde() + " " + anxNumeracionTO.getNumHasta();
                susSuceso = "INSERT";
                susTabla = "anexos.anx_numeracion";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                anxNumeracionTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                anexos.entity.AnxNumeracion anxNumeracion = anexos.helper.ConversionesAnexos.convertirAnxNumeracionTO_AnxAnxNumeracion(anxNumeracionTO);
                if (operacionesAnexoDAOTransaccionLocal.insertarAnexoNumeracion(anxNumeracion, sisSuceso)) {
                    retorno = "TLa numeración se guardo correctamente...";
                } else {
                    retorno = "FHubo un error al guardar la numeración...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FLa numeración que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarAnexoNumeracionTO",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    @Override
    public String modificarAnexoNumeracionTO(anexos.TO.AnxNumeracionTO anxNumeracionTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        anexos.entity.AnxNumeracion anxNumeracionAux = operacionesAnexoDAOLocal.getAnexoNumeracion(anxNumeracionTO.getNumSecuencial());
        try {
            if (anxNumeracionAux != null) {
                susClave = anxNumeracionTO.getNumComprobante() + " | " + anxNumeracionTO.getNumDesde() + " | " + anxNumeracionTO.getNumHasta();
                susDetalle = "Se modificó una numeración con código " + anxNumeracionTO.getNumComprobante() + " " + anxNumeracionTO.getNumDesde() + " " + anxNumeracionTO.getNumHasta();
                susSuceso = "UPDATE";
                susTabla = "anexos.anx_numeracion";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                anxNumeracionTO.setUsrCodigo(anxNumeracionAux.getUsrCodigo());
                anxNumeracionTO.setUsrFechaInserta(validaciones.Validacion.fecha(anxNumeracionAux.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
                anexos.entity.AnxNumeracion anxNumeracion = anexos.helper.ConversionesAnexos.convertirAnxNumeracionTO_AnxAnxNumeracion(anxNumeracionTO);

                if (operacionesAnexoDAOTransaccionLocal.modificarAnexoNumeracion(anxNumeracion, sisSuceso)) {
                    retorno = "TLa numeración se modificó correctamente...";
                } else {
                    retorno = "FHubo un error al modificar la numeración...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FLa numeración que va a modificar ya no existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarAnexoNumeracionTO",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    //@Override
    public String eliminarAnexoNumeracionTO(anexos.TO.AnxNumeracionTO anxNumeracionTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        anexos.entity.AnxNumeracion anxNumeracionAux = operacionesAnexoDAOLocal.getAnexoNumeracion(anxNumeracionTO.getNumSecuencial());
        try {
            if (anxNumeracionAux != null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = anxNumeracionTO.getNumComprobante() + " | " + anxNumeracionTO.getNumDesde() + " | " + anxNumeracionTO.getNumHasta();
                susDetalle = "Se elimino una numeración con código " + anxNumeracionTO.getNumComprobante() + " " + anxNumeracionTO.getNumDesde() + " " + anxNumeracionTO.getNumHasta();
                susSuceso = "DELETE";
                susTabla = "anexos.anx_numeracion";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                anxNumeracionTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                anexos.entity.AnxNumeracion anxNumeracion = anexos.helper.ConversionesAnexos.convertirAnxNumeracionTO_AnxAnxNumeracion(anxNumeracionTO);

                if (operacionesAnexoDAOTransaccionLocal.eliminarAnexoNumeracion(anxNumeracion, sisSuceso)) {
                    retorno = "TLa numeración se eliminó correctamente...";
                } else {
                    retorno = "FHubo un error al eliminar la numeración...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "FLa numeración que va a modificar ya no existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarAnexoNumeracionTO",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    @Override
    public anexos.TO.AnxConceptoTO getBuscarAnexoConceptoTO(String conceptoCodigo) throws Exception {
        return operacionesAnexoDAOLocal.getBuscarAnexoConceptoTO(conceptoCodigo);
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoTO> getAnexoConceptoTO() throws Exception {
        return operacionesAnexoDAOLocal.getAnexoConceptoTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxSustentoTO> getAnexoSustentoTO() throws Exception {
        return operacionesAnexoDAOLocal.getAnexoSustentoTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoComprobanteTO> getAnexoTipoComprobanteTO() throws Exception {
        return operacionesAnexoDAOLocal.getAnexoTipoComprobanteTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoIdentificacionTO> getListaAnxTipoIdentificacionTO() throws Exception {
        return operacionesAnexoDAOLocal.getListaAnxTipoIdentificacionTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoListaTransaccionTO> getAnexoTipoListaTransaccionTO() throws Exception {
        return operacionesAnexoDAOLocal.getAnexoTipoListaTransaccionTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxAnuladoTablaTO> getListaAnxAnuladoTablaTO(String empresa) throws Exception {
        return operacionesAnexoDAOLocal.getListaAnxAnuladoTablaTO(empresa);
    }

    @Override
    public anexos.TO.AnxAnuladosTO getAnxAnuladosTO(Integer secuencial) throws Exception {
        return operacionesAnexoDAOLocal.getAnxAnuladosTO(secuencial);
    }

    @Override
    public String insertarAnexoAnuladoTO(AnxAnuladosTO anxAnuladosTO, SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            boolean sePuedeAnular = true;
            String estadoPeriodo = operacionessistemaWebBusinessLocal.estadoPeriodo(sisInfoTO.getInfEmpresa(), anxAnuladosTO.getAnuFecha());
            if (estadoPeriodo.isEmpty()) {
                Boolean comprobanteVerificarAutorizacion = operacionesAnexoDAOLocal.getComprobanteVerificarAutorizacion(anxAnuladosTO.getUsrEmpresa(),
                        anxAnuladosTO.getTcCodigo(), anxAnuladosTO.getAnuComprobanteEstablecimiento(), anxAnuladosTO.getAnuComprobantePuntoEmision(),
                        anxAnuladosTO.getAnuSecuencialInicio(), anxAnuladosTO.getAnuSecuencialFin());

                if (anxAnuladosTO.getTcCodigo().compareToIgnoreCase("07") == 0
                        && (anxAnuladosTO.getAnuAutorizacion().length() == 37 || anxAnuladosTO.getAnuAutorizacion().length() == 49)
                        && anxAnuladosTO.getAnuSecuencialInicio().compareToIgnoreCase(anxAnuladosTO.getAnuSecuencialFin()) == 0) {
                    comprobanteVerificarAutorizacion = false;
                }

                if (!comprobanteVerificarAutorizacion) {
                    List<AnxAnuladoTablaTO> listaAnuladoTablaTO =
                            operacionesAnexoDAOLocal.getListaAnxAnuladoTablaTO(anxAnuladosTO.getUsrEmpresa());
                    if (listaAnuladoTablaTO != null && listaAnuladoTablaTO.size() > 0) {
                        for (AnxAnuladoTablaTO aatto : listaAnuladoTablaTO) {
                            if (aatto.getAnuComprobanteTipo().equals(anxAnuladosTO.getTcCodigo())) {
                                if (aatto.getAnuComprobanteEstablecimiento().equals(anxAnuladosTO.getAnuComprobanteEstablecimiento())
                                        && aatto.getAnuComprobantePuntoEmision().equals(anxAnuladosTO.getAnuComprobantePuntoEmision())) {
                                    if (Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio()) >= Integer.parseInt(aatto.getAnuSecuencialInicio())
                                            && Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio()) <= Integer.parseInt(aatto.getAnuSecuencialFin())) {
                                        sePuedeAnular = false;
                                        break;
                                    } else if (Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin()) >= Integer.parseInt(aatto.getAnuSecuencialInicio())
                                            && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin()) <= Integer.parseInt(aatto.getAnuSecuencialFin())) {
                                        sePuedeAnular = false;
                                        break;
                                    }
                                }
                            }
                        }
                        if (sePuedeAnular) {
                            retorno = insertarAnexoAnulado(anxAnuladosTO, estadoPeriodo, sisInfoTO);
                        } else {
                            retorno = "FTodo o parte de la numeración ya ha sido anulado";
                        }
                    } else {
                        retorno = insertarAnexoAnulado(anxAnuladosTO, estadoPeriodo, sisInfoTO);
                    }
                } else {
                    retorno = "FLa NUMERACIÓN que esta eliminando se encuentra usada en una COMPRA o VENTA.\nIntente con otro o contacte con el administrador.";
                }
            } else {
                retorno = "F" + estadoPeriodo;
            }

        } catch (Exception e) {
            Excepciones.guardarExcepcionesEJB(e,
                    getClass().getName(), "insertarAnexoAnuladoTO",
                    sisInfoTO, operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    private String insertarAnexoAnulado(AnxAnuladosTO anxAnuladosTO, String periodo, SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            List<AnxNumeracionTablaTO> listaAnxNumeracionTablaTO =
                    operacionesAnexoDAOLocal.getListaAnexoNumeracionTO(anxAnuladosTO.getUsrEmpresa());
            boolean sePuedeGuardar = false;
            if (listaAnxNumeracionTablaTO != null && listaAnxNumeracionTablaTO.size() > 0) {
                for (AnxNumeracionTablaTO antto : listaAnxNumeracionTablaTO) {
                    if (antto.getNumeroComprobante().equals(anxAnuladosTO.getTcCodigo())) {
                        if (antto.getNumeroDesde().substring(0, antto.getNumeroDesde().lastIndexOf("-")).trim().
                                equals(anxAnuladosTO.getAnuComprobanteEstablecimiento() + "-" + anxAnuladosTO.getAnuComprobantePuntoEmision())) {
                            if (Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio())
                                    >= Integer.parseInt(antto.getNumeroDesde().
                                    substring(antto.getNumeroDesde().lastIndexOf("-") + 1).trim())
                                    && Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio())
                                    <= Integer.parseInt(antto.getNumeroHasta().
                                    substring(antto.getNumeroHasta().lastIndexOf("-") + 1).trim())
                                    && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin())
                                    >= Integer.parseInt(antto.getNumeroDesde().
                                    substring(antto.getNumeroDesde().lastIndexOf("-") + 1).trim())
                                    && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin())
                                    <= Integer.parseInt(antto.getNumeroHasta().
                                    substring(antto.getNumeroHasta().lastIndexOf("-") + 1).trim())) {
                                sePuedeGuardar = true;
                                break;
                            }
                        }
                    }
                }
                if (sePuedeGuardar) {
                    /// PREPARANDO OBJETO SISSUCESO
                    susClave = anxAnuladosTO.getTcCodigo() + " | " + anxAnuladosTO.getAnuSecuencialInicio() + " | " + anxAnuladosTO.getAnuSecuencialFin();
                    susDetalle = "Se insertó la anulación con código " + anxAnuladosTO.getTcCodigo() + " | " + anxAnuladosTO.getAnuSecuencialInicio() + " | " + anxAnuladosTO.getAnuSecuencialFin();
                    susSuceso = "INSERT";
                    susTabla = "anexos.anx_anulados";
                    SisSuceso sisSuceso = Suceso.crearSisSuceso(susTabla, susClave, susSuceso, susDetalle, sisInfoTO);
                    /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                    anxAnuladosTO.setUsrFechaInserta(Validacion.fechaSistema());

                    //proceso de anulacion de retencion electronica
                    if (anxAnuladosTO.getTcCodigo().compareToIgnoreCase("07") == 0
                            && (anxAnuladosTO.getAnuAutorizacion().length() == 37 || anxAnuladosTO.getAnuAutorizacion().length() == 49)
                            && anxAnuladosTO.getAnuSecuencialInicio().compareToIgnoreCase(anxAnuladosTO.getAnuSecuencialFin()) == 0) {
                        InvConsultaVentasFacturasPorNumeroTO retencionPK = operacionesAnexoDAOLocal.getConsultaPKRetencion(anxAnuladosTO.getUsrEmpresa(), anxAnuladosTO.getAnuComprobanteEstablecimiento()
                                + anxAnuladosTO.getAnuComprobantePuntoEmision() + anxAnuladosTO.getAnuSecuencialInicio(), anxAnuladosTO.getAnuAutorizacion());
                        if (retencionPK != null && retencionPK.getVtaEmpresa() != null && retencionPK.getVtaNumero() != null) {
                            AnxCompraElectronica ace = operacionesAnexoDAOLocal.buscarAnxCompraElectronica(retencionPK.getVtaEmpresa(), retencionPK.getVtaPeriodo(), retencionPK.getVtaMotivo(), retencionPK.getVtaNumero());
                            AnxCompra ac = ace.getAnxCompra();
//                            ac.setCompRetencionnumero("");
                            ac.setCompRetencionAutorizacion("ANULADA");
                            operacionesAnexoDAOTransaccionLocal.accionAnxCompraElectronica(ace, ac, sisSuceso, 'E');
                        } else {
                            sePuedeGuardar = false;
                        }
                    }

                    if (sePuedeGuardar) {
                        AnxAnulados anxAnulados = ConversionesAnexos.convertirAnxAnuladosTO_AnxAnulados(anxAnuladosTO);
                        anxAnulados.setTcCodigo(operacionesAnexoDAOLocal.getAnexoTipoComprobante(anxAnuladosTO.getTcCodigo()));
                        if (operacionesAnexoDAOTransaccionLocal.insertarAnexoAnulados(anxAnulados, sisSuceso)) {
                            retorno = "TLa anulación se guardó correctamente...";
                        } else {
                            retorno = "FHubo un error al guardar la anulación...\nIntente de nuevo o contacte con el administrador.";
                        }
                    }
                }
            }
            if (!sePuedeGuardar) {
                retorno = "FNo existe la Numeración que quiere anular o la Autorizacion esta erronea.\nIngrésela mediante el formulario de numeración en el módulo Anexos.";
            }
        } catch (Exception e) {
            Excepciones.guardarExcepcionesEJB(e, getClass().getName(),
                    "insertarAnexoAnuladoTO", sisInfoTO, operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    @Override
    public String modificarAnexoAnuladoTO(anexos.TO.AnxAnuladosTO anxAnuladosTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            boolean sePuedeConsultar = false;
            String estadoPeriodo = operacionessistemaWebBusinessLocal.estadoPeriodo(anxAnuladosTO.getUsrEmpresa(), anxAnuladosTO.getAnuFecha());
            if (estadoPeriodo.isEmpty()) {
                java.util.List<anexos.TO.AnxAnuladoTablaTO> listaAnuladoTablaTO =
                        operacionesAnexoDAOLocal.getListaAnxAnuladoTablaTO(anxAnuladosTO.getUsrEmpresa());
                if (listaAnuladoTablaTO != null) {
                    if (listaAnuladoTablaTO.size() > 0) {
                        for (int i = 0; i < listaAnuladoTablaTO.size(); i++) {
                            if (listaAnuladoTablaTO.get(i).getAnuComprobanteEstablecimiento().
                                    equals(anxAnuladosTO.getAnuComprobanteEstablecimiento())
                                    && listaAnuladoTablaTO.get(i).getAnuComprobantePuntoEmision().equals(anxAnuladosTO.getAnuComprobantePuntoEmision())) {
                                if (Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio())
                                        >= Integer.parseInt(listaAnuladoTablaTO.get(i).getAnuSecuencialInicio())
                                        && Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio())
                                        <= Integer.parseInt(listaAnuladoTablaTO.get(i).getAnuSecuencialFin())
                                        && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin())
                                        >= Integer.parseInt(listaAnuladoTablaTO.get(i).getAnuSecuencialInicio())
                                        && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin())
                                        <= Integer.parseInt(listaAnuladoTablaTO.get(i).getAnuSecuencialFin())) {
                                    if (anxAnuladosTO.getAnuSecuencial().compareTo(listaAnuladoTablaTO.get(i).getAnuSecuencial()) == 0) {
                                        //}
                                        //if (anxAnuladosTO.getAnuSecuencial() == listaAnuladoTablaTO.get(i).getAnuSecuencial()){
                                        sePuedeConsultar = true;
                                    } else {
                                        sePuedeConsultar = false;
                                        i = listaAnuladoTablaTO.size();
                                    }
                                } else {
                                    sePuedeConsultar = true;
                                }
                            }
                        }
                        if (sePuedeConsultar) {
                            java.util.List<anexos.TO.AnxNumeracionTablaTO> listaAnxNumeracionTablaTO =
                                    operacionesAnexoDAOLocal.getListaAnexoNumeracionTO(anxAnuladosTO.getUsrEmpresa());
                            boolean sePuedeGuardar = false;
                            if (listaAnxNumeracionTablaTO != null) {
                                if (listaAnxNumeracionTablaTO.size() > 0) {
                                    for (int i = 0; i < listaAnxNumeracionTablaTO.size(); i++) {
                                        if (listaAnxNumeracionTablaTO.get(i).getNumeroComprobante().equals(anxAnuladosTO.getTcCodigo())) {
                                            if (listaAnxNumeracionTablaTO.get(i).getNumeroDesde().
                                                    substring(0, listaAnxNumeracionTablaTO.get(i).getNumeroDesde().lastIndexOf("-")).trim().
                                                    equals(anxAnuladosTO.getAnuComprobanteEstablecimiento() + "-" + anxAnuladosTO.getAnuComprobantePuntoEmision())) {
                                                if (Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio())
                                                        >= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().
                                                        substring(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().lastIndexOf("-") + 1).trim())
                                                        && Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio())
                                                        <= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().
                                                        substring(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().lastIndexOf("-") + 1).trim())
                                                        && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin())
                                                        >= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().
                                                        substring(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().lastIndexOf("-") + 1).trim())
                                                        && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin())
                                                        <= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().
                                                        substring(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().lastIndexOf("-") + 1).trim())) {
                                                    sePuedeGuardar = true;
                                                    i = listaAnxNumeracionTablaTO.size();
                                                } else {
                                                    sePuedeGuardar = false;
                                                }
                                            }
                                        } else {
                                            sePuedeGuardar = false;
                                        }
                                    }
                                    if (sePuedeGuardar) {
                                        /// PREPARANDO OBJETO SISSUCESO
                                        susClave = anxAnuladosTO.getTcCodigo() + " | " + anxAnuladosTO.getAnuSecuencialInicio() + " | " + anxAnuladosTO.getAnuSecuencialFin();
                                        susDetalle = "Se modificó la anulación con código " + anxAnuladosTO.getTcCodigo() + " | " + anxAnuladosTO.getAnuSecuencialInicio() + " | " + anxAnuladosTO.getAnuSecuencialFin();
                                        susSuceso = "UPDATE";
                                        susTabla = "anexos.anx_anulados";
                                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                susTabla,
                                                susClave,
                                                susSuceso,
                                                susDetalle,
                                                sisInfoTO);
                                        /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                                        anxAnuladosTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                                        anexos.entity.AnxAnulados anxAnulados = anexos.helper.ConversionesAnexos.convertirAnxAnuladosTO_AnxAnulados(anxAnuladosTO);
                                        anxAnulados.setTcCodigo(operacionesAnexoDAOLocal.getAnexoTipoComprobante(anxAnuladosTO.getTcCodigo()));
                                        if (operacionesAnexoDAOTransaccionLocal.modificarAnexoAnulados(anxAnulados, sisSuceso)) {
                                            //if (operacionesAnexoDAOTransaccionLocal.insertarAnexoAnulados(anxAnulados, sisSuceso)){
                                            retorno = "TLa anulación se modificó correctamente...";
                                        } else {
                                            retorno = "FHubo un error al modificar la anulación...\nIntente de nuevo o contacte con el administrador";
                                        }
                                    } else {
                                        retorno = "FNo existe la numeración que quiere anular.\nIngrésela mediante el formulario de numeración en el módulo Anexos";
                                    }
                                } else {
                                    retorno = "FNo existe la numeración que quiere anular.\nIngrésela mediante el formulario de numeración en el módulo Anexos";
                                }
                            } else {
                                retorno = "FNo existe la numeración que quiere anular.\nIngrésela mediante el formulario de numeración en el módulo Anexos";
                            }
                        } else {
                            retorno = "FLa numeración que quiere anular ya ha sido anulada";
                        }
                    } else {
                        /////////////////////SE PUEDE INGRESAR
                        java.util.List<anexos.TO.AnxNumeracionTablaTO> listaAnxNumeracionTablaTO =
                                operacionesAnexoDAOLocal.getListaAnexoNumeracionTO(anxAnuladosTO.getUsrEmpresa());
                        boolean sePuedeGuardar = false;
                        if (listaAnxNumeracionTablaTO != null) {
                            if (listaAnxNumeracionTablaTO.size() > 0) {
                                for (int i = 0; i < listaAnxNumeracionTablaTO.size(); i++) {
                                    if (listaAnxNumeracionTablaTO.get(i).getNumeroComprobante().equals(anxAnuladosTO.getTcCodigo())) {
                                        if (listaAnxNumeracionTablaTO.get(i).getNumeroDesde().
                                                substring(0, listaAnxNumeracionTablaTO.get(i).getNumeroDesde().lastIndexOf("-")).trim().
                                                equals(anxAnuladosTO.getAnuComprobanteEstablecimiento() + "-" + anxAnuladosTO.getAnuComprobantePuntoEmision())) {
                                            if (Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio())
                                                    >= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().
                                                    substring(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().lastIndexOf("-") + 1).trim())
                                                    && Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio())
                                                    <= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().
                                                    substring(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().lastIndexOf("-") + 1).trim())
                                                    && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin())
                                                    >= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().
                                                    substring(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().lastIndexOf("-") + 1).trim())
                                                    && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin())
                                                    <= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().
                                                    substring(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().lastIndexOf("-") + 1).trim())) {
                                                sePuedeGuardar = true;
                                                i = listaAnxNumeracionTablaTO.size();
                                            } else {
                                                sePuedeGuardar = false;
                                            }
                                        }
                                    } else {
                                        sePuedeGuardar = false;
                                    }
                                }
                                if (sePuedeGuardar) {
                                    /// PREPARANDO OBJETO SISSUCESO
                                    susClave = anxAnuladosTO.getTcCodigo() + " | " + anxAnuladosTO.getAnuSecuencialInicio() + " | " + anxAnuladosTO.getAnuSecuencialFin();
                                    susDetalle = "Se modificó la anulación con código " + anxAnuladosTO.getTcCodigo() + " | " + anxAnuladosTO.getAnuSecuencialInicio() + " | " + anxAnuladosTO.getAnuSecuencialFin();
                                    susSuceso = "UPDATE";
                                    susTabla = "anexos.anx_anulados";
                                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                            susTabla,
                                            susClave,
                                            susSuceso,
                                            susDetalle,
                                            sisInfoTO);
                                    /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                                    anxAnuladosTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                                    anexos.entity.AnxAnulados anxAnulados = anexos.helper.ConversionesAnexos.convertirAnxAnuladosTO_AnxAnulados(anxAnuladosTO);
                                    anxAnulados.setTcCodigo(operacionesAnexoDAOLocal.getAnexoTipoComprobante(anxAnuladosTO.getTcCodigo()));

                                    if (operacionesAnexoDAOTransaccionLocal.insertarAnexoAnulados(anxAnulados, sisSuceso)) {
                                        retorno = "TLa anulación se modificó correctamente...";
                                    } else {
                                        retorno = "FHubo un error al modificar la anulación...\nIntente de nuevo o contacte con el administrador";
                                    }
                                } else {
                                    retorno = "FNo existe la numeración que quiere anular.\nIngrésela mediante el formulario de numeración en el módulo Anexos";
                                }
                            } else {
                                retorno = "FNo existe la numeración que quiere anular.\nIngrésela mediante el formulario de numeración en el módulo Anexos";
                            }
                        } else {
                            retorno = "FNo existe la numeración que quiere anular.\nIngrésela mediante el formulario de numeración en el módulo Anexos";
                        }
                    }
                } else {
                    /////////////////////SE PUEDE INGRESAR
                    java.util.List<anexos.TO.AnxNumeracionTablaTO> listaAnxNumeracionTablaTO =
                            operacionesAnexoDAOLocal.getListaAnexoNumeracionTO(anxAnuladosTO.getUsrEmpresa());
                    boolean sePuedeGuardar = false;
                    if (listaAnxNumeracionTablaTO != null) {
                        if (listaAnxNumeracionTablaTO.size() > 0) {
                            for (int i = 0; i < listaAnxNumeracionTablaTO.size(); i++) {
                                if (listaAnxNumeracionTablaTO.get(i).getNumeroComprobante().equals(anxAnuladosTO.getTcCodigo())) {
                                    if (listaAnxNumeracionTablaTO.get(i).getNumeroDesde().
                                            substring(0, listaAnxNumeracionTablaTO.get(i).getNumeroDesde().lastIndexOf("-")).trim().
                                            equals(anxAnuladosTO.getAnuComprobanteEstablecimiento() + "-" + anxAnuladosTO.getAnuComprobantePuntoEmision())) {
                                        if (Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio())
                                                >= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().
                                                substring(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().lastIndexOf("-") + 1).trim())
                                                && Integer.parseInt(anxAnuladosTO.getAnuSecuencialInicio())
                                                <= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().
                                                substring(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().lastIndexOf("-") + 1).trim())
                                                && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin())
                                                >= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().
                                                substring(listaAnxNumeracionTablaTO.get(i).getNumeroDesde().lastIndexOf("-") + 1).trim())
                                                && Integer.parseInt(anxAnuladosTO.getAnuSecuencialFin())
                                                <= Integer.parseInt(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().
                                                substring(listaAnxNumeracionTablaTO.get(i).getNumeroHasta().lastIndexOf("-") + 1).trim())) {
                                            sePuedeGuardar = true;
                                            i = listaAnxNumeracionTablaTO.size();
                                        } else {
                                            sePuedeGuardar = false;
                                        }
                                    }
                                } else {
                                    sePuedeGuardar = false;
                                }
                            }
                            if (sePuedeGuardar) {
                                /// PREPARANDO OBJETO SISSUCESO
                                susClave = anxAnuladosTO.getTcCodigo() + " | " + anxAnuladosTO.getAnuSecuencialInicio() + " | " + anxAnuladosTO.getAnuSecuencialFin();
                                susDetalle = "Se modificó la anulación con código " + anxAnuladosTO.getTcCodigo() + " | " + anxAnuladosTO.getAnuSecuencialInicio() + " | " + anxAnuladosTO.getAnuSecuencialFin();
                                susSuceso = "UPDATE";
                                susTabla = "anexos.anx_anulados";
                                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                        susTabla,
                                        susClave,
                                        susSuceso,
                                        susDetalle,
                                        sisInfoTO);
                                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                                anxAnuladosTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());

                                anexos.entity.AnxAnulados anxAnulados = anexos.helper.ConversionesAnexos.convertirAnxAnuladosTO_AnxAnulados(anxAnuladosTO);
                                anxAnulados.setTcCodigo(operacionesAnexoDAOLocal.getAnexoTipoComprobante(anxAnuladosTO.getTcCodigo()));

                                if (operacionesAnexoDAOTransaccionLocal.modificarAnexoAnulados(anxAnulados, sisSuceso)) {
                                    retorno = "TLa anulación se modificó correctamente...";
                                } else {
                                    retorno = "FHubo un error al modificar la anulación...\nIntente de nuevo o contacte con el administrador";
                                }
                            } else {
                                retorno = "FNo existe la numeración que quiere anular.\nIngrésela mediante el formulario de numeración en el módulo Anexos";
                            }
                        } else {
                            retorno = "FNo existe la numeración que quiere anular.\nIngrésela mediante el formulario de numeración en el módulo Anexos";
                        }
                    } else {
                        retorno = "FNo existe la numeración que quiere anular.\nIngrésela mediante el formulario de numeración en el módulo Anexos";
                    }
                }

            } else {
                retorno = "F" + estadoPeriodo;
            }

        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarAnexoAnuladoTO",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    @Override
    public String eliminarAnexoAnuladoTO(anexos.TO.AnxAnuladosTO anxAnuladosTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            String estadoPeriodo = operacionessistemaWebBusinessLocal.estadoPeriodo(anxAnuladosTO.getUsrEmpresa(), anxAnuladosTO.getAnuFecha());
            if (estadoPeriodo.isEmpty()) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = anxAnuladosTO.getTcCodigo() + " | " + anxAnuladosTO.getAnuSecuencialInicio() + " | " + anxAnuladosTO.getAnuSecuencialFin();
                susDetalle = "Se eliminó la anulación con código " + anxAnuladosTO.getTcCodigo() + " | " + anxAnuladosTO.getAnuSecuencialInicio() + " | " + anxAnuladosTO.getAnuSecuencialFin();
                susSuceso = "DELETE";
                susTabla = "anexos.anx_anulados";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                anxAnuladosTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());

                anexos.entity.AnxAnulados anxAnulados = anexos.helper.ConversionesAnexos.convertirAnxAnuladosTO_AnxAnulados(anxAnuladosTO);
                anxAnulados.setTcCodigo(operacionesAnexoDAOLocal.getAnexoTipoComprobante(anxAnuladosTO.getTcCodigo()));

                if (operacionesAnexoDAOTransaccionLocal.eliminarAnexoAnulados(anxAnulados, sisSuceso)) {
                    retorno = "TLa anulación se eliminó correctamente...";
                } else {
                    retorno = "FHubo un error al eliminar la anulación...\nIntente de nuevo o contacte con el administrador";
                }
            } else {
                retorno = "F" + estadoPeriodo;
            }

        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarAnexoAnuladoTO",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="ANEXOS CUENTAS CONTABLES">
    public anexos.TO.AnxCuentasContablesTO getAnxCuentasContablesTO(String empresa, String nombreCuenta) throws Exception {
        return operacionesAnexoDAOLocal.getAnxCuentasContablesTO(empresa, nombreCuenta);
    }

    @Override
    public String actualizarAnxCuentasContables(AnxCuentasContablesTO anxCuentasContablesTO, String empresa, String usuario, SisInfoTO sisInfoTO) throws java.lang.Exception {
        boolean comprobar = false;
        String mensaje = "";
        try {
            ///// CREANDO Suceso
            susClave = anxCuentasContablesTO.getCtaEmpresa();
            susDetalle = "Se modificó la(s) cuenta(s) contable(s)";
            susTabla = "anexos.anx_cuentascontables";
            susSuceso = "UPDATE";
            SisSuceso sisSuceso = Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO anxCuentasContables
            AnxCuentasContablesTO auxAnxCuentasContablesTO = getAnxCuentasContablesTO(anxCuentasContablesTO.getCtaEmpresa(), null);
            anxCuentasContablesTO.setCtaSecuencial(auxAnxCuentasContablesTO.getCtaSecuencial());

            AnxCuentascontables anxCuentascontables = ConversionesAnexos.convertirAnxCuentasContablesTO_AnxCuentasContables(anxCuentasContablesTO);
            ////// BUSCANDO existencia Categoría
            if (operacionesAnexoDAOLocal.comprobarAnxCuentascontables(empresa)) {
                comprobar = operacionesAnexoDAOTransaccionLocal.actualizarAnxCuentascontables(anxCuentascontables, sisSuceso);
            } else {
                mensaje = "FNo se encuentra...";
            }

            if (comprobar) {
                mensaje = "TSe modificó correctamente";
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar, inténtelo de nuevo...";
            Excepciones.guardarExcepcionesEJB(e, getClass().getName(),
                    "accionAnxCuentasContables", sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }
    // </editor-fold>

    @Override
    public String eliminarAnxVentas(anexos.TO.AnxVentaTO anxVentaTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {
            anexos.entity.AnxVenta anxVentaConsulta = operacionesAnexoDAOLocal.getAnxVenta(anxVentaTO.getVenEmpresa(),
                    anxVentaTO.getVenPeriodo(), anxVentaTO.getVenMotivo(), anxVentaTO.getVenNumero());
            if (anxVentaConsulta != null) {
                /// PREPARANDO OBJETO SISSUCESO
                susClave = anxVentaTO.getVenEmpresa() + " | " + anxVentaTO.getVenPeriodo() + " | " + anxVentaTO.getVenMotivo() + " | " + anxVentaTO.getVenNumero();
                susDetalle = "Se eliminó una RETENCIÓN EN VENTAS con código " + anxVentaTO.getVenEmpresa() + " | " + anxVentaTO.getVenPeriodo() + " | " + anxVentaTO.getVenMotivo() + " | " + anxVentaTO.getVenNumero();
                susSuceso = "DELETE";
                susTabla = "anexos.anx_venta";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
                anxVentaTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());

                anexos.entity.AnxVenta anxVenta = anexos.helper.ConversionesAnexos.convertirAnxVentaTO_AnxVenta(anxVentaTO);

                if (operacionesAnexoDAOTransaccionLocal.eliminarAnxVentas(anxVenta, sisSuceso)) {
                    retorno = "TLa RETENCIÓN EN VENTA fué eliminada correctamente...";
                } else {
                    retorno = "FHubo un error al eliminar la RETENCIÓN EN VENTA ...\nIntente de nuevo o contacte con el administrador.";
                }
            } else {
                retorno = "FLa RETENCIÓN EN VENTA no se encuentra aún en la Base de Datos...\nInténtelo de nuevo o contacte con el administrador.";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarAnxVentas",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);

        } finally {
            return retorno;
        }
    }
    boolean comprobar = false;
    private String mensaje;

    @Override
    public String accionAnxVenta(
            anexos.TO.AnxVentaTO anxVentaTO,
            String numeroFactura,
            String periodoFactura,
            String cliCodigo,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        boolean periodoCerrado = false;
        String numeroRetencion = "";
        try {
            java.util.List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList();
            listaSisPeriodoTO = operacionessistemaWebDAOLocal.getListaSisPeriodo(anxVentaTO.getVenEmpresa());
            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (validaciones.Validacion.fecha(periodoFactura, "yyyy-MM-dd").getTime()
                        >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && validaciones.Validacion.fecha(periodoFactura, "yyyy-MM-dd").getTime()
                        <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                    comprobar = true;
                    anxVentaTO.setVenPeriodo(sisListaPeriodoTO.getPerCodigo());
                    periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                }
            }
            if (comprobar) {



                if (!periodoCerrado) {
                    inventario.entity.InvCliente invCliente = operacionesInventarioDAOLocal.buscarInvCliente(anxVentaTO.getVenEmpresa(), cliCodigo);
                    ///// BUSCANDO CLIENTE
                    if (invCliente != null) {
                        inventario.entity.InvVentas invVentasCreadas = operacionesInventarioDAOLocal.buscarInvVentas(anxVentaTO.getVenEmpresa(), anxVentaTO.getVenPeriodo(),
                                anxVentaTO.getVenMotivo(), anxVentaTO.getVenNumero());
                        boolean noExiste = false;
                        ////////////COMPROBAR SI EL TIPO DE DOCUMENTO ES 00
                        if (anxVentaTO != null) {
                            ////////////COMPROBAR SI NO EXISTE NUMERO DE RETENCION
                            String codigoRetencion = "";
                            anxVentaTO.setVenRetencionNumero(anxVentaTO.getVenRetencionNumero() == null ? ""
                                    : anxVentaTO.getVenRetencionNumero());
                            if (!anxVentaTO.getVenRetencionNumero().isEmpty()) {
                                codigoRetencion = operacionesAnexoDAOLocal.getConteoNumeroRetencionVenta(anxVentaTO.getVenEmpresa(),
                                        anxVentaTO.getVenRetencionNumero(), invCliente.getInvClientePK().getCliCodigo());
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
                            ///// CREANDO Suceso
                            susClave = anxVentaTO.getVenPeriodo() + " " + anxVentaTO.getVenMotivo() + " " + anxVentaTO.getVenNumero();
                            numeroRetencion = anxVentaTO.getVenRetencionNumero();
                            if (accion == 'I') {
                                //Se insertó Retencio de la Venta 2014-01 | 0000003   
                                susDetalle = "Se Ingresa la Retención # " + anxVentaTO.getVenRetencionNumero() + " al comprobante de Venta # " + numeroFactura;
                                susSuceso = "INSERT";
                                //2014-01 002-002 0000003  
                            }
                            if (accion == 'M') {
                                susDetalle = "Se Modifico la Retención # " + anxVentaTO.getVenRetencionNumero() + " del compobante de Venta # " + numeroFactura;
                                susSuceso = "UPDATE";
                            }
                            if (accion == 'E') {
                                susDetalle = "Se Elimino la Retención # " + anxVentaTO.getVenRetencionNumero() + " del comprobante de Venta# " + numeroFactura;
                                susSuceso = "DELETE";
                            }
                            susTabla = "anexo.anx_venta";
                            ///// CREANDO anxVenta;
                            anxVentaTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());
                            anexos.entity.AnxVenta anxVenta = anexos.helper.ConversionesAnexos.convertirAnxVentaTO_AnxVenta(anxVentaTO);
                            if (accion == 'E') {
                                ////// BUSCANDO existencia la Retencion
                                if (operacionesAnexoDAOLocal.comprobarAnxVentas(
                                        anxVentaTO.getUsrEmpresa(),
                                        anxVentaTO.getVenPeriodo(),
                                        anxVentaTO.getVenMotivo(),
                                        anxVentaTO.getVenNumero())) {
                                    if (operacionesAnexoDAOLocal.comprobarEliminarAnxVentas(
                                            anxVentaTO.getUsrEmpresa(),
                                            anxVentaTO.getVenPeriodo(),
                                            anxVentaTO.getVenMotivo(),
                                            anxVentaTO.getVenNumero())) {

                                        anxVenta.setUsrFechaInserta(operacionesAnexoDAOLocal.buscarAnxVentas(
                                                anxVentaTO.getUsrEmpresa(),
                                                anxVentaTO.getVenPeriodo(),
                                                anxVentaTO.getVenMotivo(),
                                                anxVentaTO.getVenNumero()).getUsrFechaInserta());
                                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                                susTabla,
                                                susClave,
                                                susSuceso,
                                                susDetalle,
                                                sisInfoTO);

                                        comprobar = operacionesAnexoDAOTransaccionLocal.accionAnxVenta(anxVenta, sisSuceso, accion);
                                    } else {
                                        mensaje = "FNo se puede eliminar la Retencion, ya esta contabilizada...";
                                    }
                                } else {
                                    mensaje = "FNo se encuentra La retencion...";
                                }
                            }
                            if (accion == 'M') {
                                ////// BUSCANDO existencia Retencion
                                if (operacionesAnexoDAOLocal.comprobarAnxVentas(
                                        anxVentaTO.getUsrEmpresa(),
                                        anxVentaTO.getVenPeriodo(),
                                        anxVentaTO.getVenMotivo(),
                                        anxVentaTO.getVenNumero())) {

                                    anxVenta.setUsrFechaInserta(operacionesAnexoDAOLocal.buscarAnxVentas(
                                            anxVentaTO.getUsrEmpresa(),
                                            anxVentaTO.getVenPeriodo(),
                                            anxVentaTO.getVenMotivo(),
                                            anxVentaTO.getVenNumero()).getUsrFechaInserta());
                                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                            susTabla,
                                            susClave,
                                            susSuceso,
                                            susDetalle,
                                            sisInfoTO);
                                    comprobar = operacionesAnexoDAOTransaccionLocal.accionAnxVenta(anxVenta, sisSuceso, accion);
                                } else {
                                    mensaje = "FNo se encuentra La retencion...";
                                }
                            }
                            if (accion == 'I') {
                                ////// BUSCANDO existencia Retencion
                                if (!operacionesAnexoDAOLocal.comprobarAnxVentas(
                                        anxVentaTO.getUsrEmpresa(),
                                        anxVentaTO.getVenPeriodo(),
                                        anxVentaTO.getVenMotivo(),
                                        anxVentaTO.getVenNumero())) {

                                    anxVenta.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                            susTabla,
                                            susClave,
                                            susSuceso,
                                            susDetalle,
                                            sisInfoTO);
                                    comprobar = operacionesAnexoDAOTransaccionLocal.accionAnxVenta(anxVenta, sisSuceso, accion);
                                } else {
                                    mensaje = "FYa existe la Retencion...";
                                }
                            }
                            if (comprobar) {
                                if (accion == 'E') {
                                    mensaje = "TSe eliminó correctamente la Retención \nNº " + numeroRetencion;
                                }
                                if (accion == 'M') {
                                    mensaje = "TSe modificó correctamente la Retención \nNº " + numeroRetencion;
                                }
                                if (accion == 'I') {
                                    mensaje = "TSe ingresó correctamente  la Retención \nNº " + numeroRetencion;
                                }
                            }


                        } else {
                            mensaje = "FEl Número de Retención que ingresó ya existe...\nIntente de nuevo o contacte con el administrador";
                        }

                    } else {
                        mensaje = "FEl Cliente que escogió ya no está disponible...\nIntente de nuevo, escoja otro Cliente o contacte con el administrador";
                    }
                } else {
                    mensaje = "FEl periodo que corresponde a la fecha de La Factura se encuentra cerrado...";
                }
            } else {
                mensaje = "FNo se encuentra ningún periodo para la fecha que La Factura...";
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar  la Retencion " + anxVentaTO.getVenPeriodo() + "|" + anxVentaTO.getVenNumero() + ", inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionAnxVenta",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public java.util.List<anexos.TO.AnxFunListadoDevolucionIvaTO> getAnxFunListadoDevolucionIvaTOs(
            java.lang.String empCodigo,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception {
        return operacionesAnexoDAOLocal.getAnxFunListadoDevolucionIvaTOs(empCodigo, desde, hasta);
    }

    @Override
    public String reestructurarRetencion(anexos.TO.AnxCompraTO anxCompraTO, String usuario, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        try {

            anexos.entity.AnxCompra anxCompra = operacionesAnexoDAOLocal.getAnexoCompra(anxCompraTO.getEmpCodigo(),
                    anxCompraTO.getPerCodigo(), anxCompraTO.getMotCodigo(), anxCompraTO.getCompNumero());
            anexos.entity.AnxCompra anxCompraAux = anexos.helper.ConversionesAnexos.convertirAnxCompra_AnxCompra(anxCompra);
            anxCompraAux.setCompSustentotributario(operacionesAnexoDAOLocal.getAnexoSustento(anxCompraTO.getCompSustentotributario()));
            anxCompraAux.setCompAutorizacion(anxCompraTO.getCompAutorizacion());
            /// PREPARANDO OBJETO SISSUCESO
            susClave = anxCompraTO.getPerCodigo() + " " + anxCompraTO.getMotCodigo() + " " + anxCompraTO.getCompNumero();
            susDetalle = "Se reestructuró la retención con código: " + anxCompraTO.getPerCodigo() + " " + anxCompraTO.getMotCodigo() + " " + anxCompraTO.getCompNumero();
            susTabla = "anexos.anx_compras";
            susSuceso = "UPDATE";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            /// PONIENDOLE FECHA AL METODO Y CONVIRTIENDO DE TO A ENTITY
            if (operacionesAnexoDAOTransaccionLocal.reestructurarRetencion(anxCompraAux, sisSuceso)) {
                retorno = "TLa retención se reestructuró correctamente...";
            } else {
                retorno = "FHubo un error al reestructurar la retención...\nIntente de nuevo o contacte con el administrador";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarAnexoAnuladoTO",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    @Override
    public java.util.List<String> getAnexoFunListadoRetencionesHuerfanas(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoFunListadoRetencionesHuerfanas(empresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<String> getAnexoFunListadoComprobantesPendientes(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoFunListadoComprobantesPendientes(empresa, fechaDesde, fechaHasta);
    }

    public AnxFormaPago getAnexoFormaPago(String codigo) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoFormaPago(codigo);
    }

    public List<AnxFormaPagoTO> getAnexoFormaPagoTO() throws Exception {
        return operacionesAnexoDAOLocal.getAnexoFormaPagoTO();
    }

    public List<AnxCompraFormaPagoTO> getAnexoCompraFormaPagoTO(String empresa, String periodo, String motivo, String numero) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoCompraFormaPagoTO(empresa, periodo, motivo, numero);
    }

    public List<AnxCompraFormaPago> getAnexoCompraFormaPago(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoCompraFormaPago(empresa, periodo, motivo, numeroCompra);
    }

    @Override
    public String getUltimaNumeracionComprobante(String empresa, String comprobante, String secuencial) throws Exception {
        return operacionesAnexoDAOLocal.getUltimaNumeracionComprobante(empresa, comprobante, secuencial);
    }

//    @Override
//    public java.util.List<String> getListadoUltimaNumeracionComprobante(String empresa, String comprobante, String secuencial) throws Exception {
//          return anexos.helper.ConversionesAnexos.convertirfunComprobanteObtenerUltimaNumeracion_FunComprobanteObtenerUltimaNumeracionTO(
//                em.createNativeQuery("SELECT ret_retencionnumero FROM anexo.fun_comprobante_obtener_ultima_numeracion "
//                + "('" + empresa + "', '" + comprobante + "', '" + secuencial + "')").getResultList());
//    }
    @Override
    public java.util.List<anexos.TO.AnxPaisTO> getComboAnxPaisTO() throws Exception {
        return operacionesAnexoDAOLocal.getComboAnxPaisTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxProvinciaTO() throws java.lang.Exception {
        return operacionesAnexoDAOLocal.getComboAnxProvinciaTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxCantonTO(java.lang.String provincia) throws java.lang.Exception {
        return operacionesAnexoDAOLocal.getComboAnxCantonTO(provincia);
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxDpaProvinciaTO() throws Exception {
        return operacionesAnexoDAOLocal.getComboAnxDpaProvinciaTO();
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxDpaCantonTO(java.lang.String codigoProvincia) throws Exception {
        return operacionesAnexoDAOLocal.getComboAnxDpaCantonTO(codigoProvincia);
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxParroquiaTO(java.lang.String codigoProvincia, java.lang.String codigoCanton) throws Exception {
        return operacionesAnexoDAOLocal.getComboAnxParroquiaTO(codigoProvincia, codigoCanton);
    }

    @Override
    public String getObtenerProvincia(String canton) throws Exception {
        return operacionesAnexoDAOLocal.getObtenerProvincia(canton);
    }

    @Override
    public java.util.List<anexos.TO.AnxFunRegistroDatosCrediticiosTO> getFunRegistroDatosCrediticiosTOs(java.lang.String codigoEmpresa, java.lang.String fechaDesde, java.lang.String fechaHasta) throws Exception {
        return operacionesAnexoDAOLocal.getFunRegistroDatosCrediticiosTOs(codigoEmpresa, fechaDesde, fechaHasta);
    }

    @Override
    public java.lang.String getCompAutorizacion(
            java.lang.String empCodigo,
            java.lang.String provCodigo,
            java.lang.String codTipoComprobante,
            java.lang.String numComplemento) throws Exception {
        return operacionesAnexoDAOLocal.getCompAutorizacion(empCodigo, provCodigo, codTipoComprobante, numComplemento);
    }

    /**
     * ************falta los sucesos********************************
     */
    @Override
    public String accionAnxUrlWebServicesTO(anexos.TO.anxUrlWebServicesTO anxUrlWebServicesTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = anxUrlWebServicesTO.getUsrEmpresa() + " " + sisInfoTO.getInfEmpresa();
            if (accion == 'I') {
                susDetalle = "Se insertó la ruta de los directorios para los documentos electronico ";
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó la ruta de los directorios para los documentos electronico ";
                susSuceso = "UPDATE";
            }
            susTabla = "anexo.anx_url_web_services";
            ///// CREANDO invProductoMedida
            anexos.entity.AnxUrlWebServices anxUrlWebServices = anexos.helper.ConversionesAnexos.convertirAnxUrlWebServicesTO_AnxUrlWebServices(anxUrlWebServicesTO);
            if (accion == 'M') {
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                comprobar = operacionesAnexoDAOTransaccionLocal.accionAnxUrlWebServixce(anxUrlWebServices, sisSuceso, accion);
            }
            if (accion == 'I') {
                ////// BUSCANDO existencia Categoría
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                comprobar = operacionesAnexoDAOTransaccionLocal.accionAnxUrlWebServixce(anxUrlWebServices, sisSuceso, accion);
            }
            if (comprobar) {
                if (accion == 'M') {
                    mensaje = "TSe modificó correctamente  los datos...";
                }
                if (accion == 'I') {
                    mensaje = "TSe ingresó correctamente  los datos...";
                }
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar  el Directorio";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionAnexoDirectorio",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public anexos.TO.anxUrlWebServicesTO getAnxUrlWebServicesTO() throws Exception {
        return operacionesAnexoDAOLocal.getAnxUrlWebServicesTO();
    }

    @Override
    public String accionAnxVentaElectronica(anexos.TO.AnxVentaElectronicaTO anxVentaElectronicaTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        boolean periodoCerrado = false;
        try {
            java.util.List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList();
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(anxVentaElectronicaTO.getVtaEmpresa());
            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (validaciones.Validacion.fecha(anxVentaElectronicaTO.getVtaFecha(), "yyyy-MM-dd").getTime()
                        >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && validaciones.Validacion.fecha(anxVentaElectronicaTO.getVtaFecha(), "yyyy-MM-dd").getTime()
                        <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                    comprobar = true;
                    anxVentaElectronicaTO.setVtaPeriodo(sisListaPeriodoTO.getPerCodigo());
                    periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                }
            }
            if (!periodoCerrado) {
                susClave = "CE " + anxVentaElectronicaTO.getVtaPeriodo() + " " + anxVentaElectronicaTO.getVtaMotivo() + " " + anxVentaElectronicaTO.getVtaNumero();
                if (accion == 'I') {
                    susDetalle = "Se insertó Comprobante Electronica Autorizados: "
                            + " Tipo : Factura"
                            + " ,Clave de Autorizacion: " + anxVentaElectronicaTO.geteAutorizacionNumero()
                            + " ,Clave de Acceso" + anxVentaElectronicaTO.geteClaveAcceso();
                    susSuceso = "INSERT";
                }
                if (accion == 'M') {
                    susDetalle = "Se optienen la Autorizados: "
                            + " Tipo : Factura"
                            + " ,Clave de Autorizacion: " + anxVentaElectronicaTO.geteAutorizacionNumero()
                            + " ,Clave de Acceso" + anxVentaElectronicaTO.geteClaveAcceso();
                    susSuceso = "UPDATE";
                }

                susTabla = "anexo.anx_venta_electronica";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);

                anexos.entity.AnxVentaElectronica anxVentaElectronica = anexos.helper.ConversionesAnexos.convertirAnxVentaElectronicaTO_AnxVentaElectronica(anxVentaElectronicaTO);
                if (accion == 'I') {
                    comprobar = operacionesAnexoDAOTransaccionLocal.accionAnxVentaElectronica(anxVentaElectronica, sisSuceso, accion);
                }
                if (accion == 'M') {
                    ////// BUSCANDO existencia Categoría
                    if (operacionesAnexoDAOLocal.comprobarAnxVentaElectronica(
                            anxVentaElectronicaTO.getVtaEmpresa(),
                            anxVentaElectronicaTO.getVtaPeriodo(),
                            anxVentaElectronicaTO.getVtaMotivo(),
                            anxVentaElectronicaTO.getVtaNumero())) {
                        anexos.entity.AnxVentaElectronica anxVentaElectronicaAux = operacionesAnexoDAOLocal.buscarAnxVentaElectronica(
                                anxVentaElectronicaTO.getVtaEmpresa(),
                                anxVentaElectronicaTO.getVtaPeriodo(),
                                anxVentaElectronicaTO.getVtaMotivo(),
                                anxVentaElectronicaTO.getVtaNumero());
                        anxVentaElectronica.setUsrFechaInserta(anxVentaElectronicaAux.getUsrFechaInserta());
                        anxVentaElectronica.setESecuencial(anxVentaElectronicaAux.getESecuencial());
                        comprobar = operacionesAnexoDAOTransaccionLocal.accionAnxVentaElectronica(anxVentaElectronica, sisSuceso, accion);

                    } else {
                        comprobar = false;
                    }
                }

                if (comprobar) {
                    if (accion == 'I') {
                        mensaje = "TEl comprobante fue autorizado por el SRI y Guardado Correctamente...";
                    }
                    if (accion == 'M') {
                        mensaje = "TEl comprobante fue autorizado por el SRI y Guardado Correctamente...";
                    }
                } else {
                    mensaje = "FNo se encuentra la Venta Electronicica...";
                }

            } else {
                mensaje = "F<html>El periodo que corresponde a la fecha que ingresó se encuentra cerrado...</html>";
            }


        } catch (Exception e) {
            mensaje = "FEl comprobante fue autorizado por el SRI pero Ocurrió un error al guardar el comprobante electronico en la Base de dato Llamar al administrador";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionAnxVentaElectronica",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public String accionAnxCompraElectronica(anexos.TO.AnxCompraElectronicaTO anxCompraElectronicaTO, char accion, sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        comprobar = false;
        try {
            susClave = "CE " + anxCompraElectronicaTO.getCompPeriodo() + " " + anxCompraElectronicaTO.getCompMotivo() + " " + anxCompraElectronicaTO.getCompNumero();
            if (accion == 'I') {
                susDetalle = "Se insertó Comprobante Electronica Autorizados: "
                        + " Estado : " + anxCompraElectronicaTO.geteEstado()
                        + " Tipo : Retencion"
                        + " ,Tipo Ambiente: " + anxCompraElectronicaTO.geteTipoAmbiente()
                        + " ,Clave de Autorizacion: " + anxCompraElectronicaTO.geteAutorizacionNumero()
                        + " ,Clave de Acceso" + anxCompraElectronicaTO.geteClaveAcceso();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se Actualizo Comprobante Electronica : "
                        + " Estado : " + anxCompraElectronicaTO.geteEstado()
                        + " Tipo : Retencion"
                        + " ,Tipo Ambiente: " + anxCompraElectronicaTO.geteTipoAmbiente()
                        + " ,Clave de Autorizacion: " + anxCompraElectronicaTO.geteAutorizacionNumero()
                        + " ,Clave de Acceso" + anxCompraElectronicaTO.geteClaveAcceso();
                susSuceso = "UPDATE";
            }
            susTabla = "anexo.anx_compra_electronica";
            anexos.entity.AnxCompraElectronica anxCompraElectronica = anexos.helper.ConversionesAnexos.convertirAnxVentaElectronicaTO_AnxVentaElectronica(anxCompraElectronicaTO);

            anexos.entity.AnxCompra anxCompra = null;
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            //String empresa, String periodo, String motivo, String numeroCompra
            if (anxCompraElectronicaTO.geteEstado().equals("AUTORIZADO")
                    && anxCompraElectronicaTO.geteTipoAmbiente().equals("PRODUCCION")) {
                anxCompra = anexos.helper.ConversionesAnexos.convertirAnxCompra_AnxCompra(operacionesAnexoDAOLocal.getAnexoCompra(
                        anxCompraElectronicaTO.getCompEmpresa(),
                        anxCompraElectronicaTO.getCompPeriodo(),
                        anxCompraElectronicaTO.getCompMotivo(),
                        anxCompraElectronicaTO.getCompNumero()));
                anxCompra.setCompRetencionAutorizacion(anxCompraElectronicaTO.geteAutorizacionNumero());


            }
            if (accion == 'I') {
                comprobar = operacionesAnexoDAOTransaccionLocal.accionAnxCompraElectronica(
                        anxCompraElectronica,
                        anxCompra,
                        sisSuceso,
                        accion);
            }
            if (accion == 'M') {
                if (operacionesAnexoDAOLocal.comprobarAnxCompraElectronica(
                        anxCompraElectronicaTO.getCompEmpresa(),
                        anxCompraElectronicaTO.getCompPeriodo(),
                        anxCompraElectronicaTO.getCompMotivo(),
                        anxCompraElectronicaTO.getCompNumero())) {
                    anexos.entity.AnxCompraElectronica anxCompraElectronicaAux = operacionesAnexoDAOLocal.buscarAnxCompraElectronica(
                            anxCompraElectronicaTO.getCompEmpresa(),
                            anxCompraElectronicaTO.getCompPeriodo(),
                            anxCompraElectronicaTO.getCompMotivo(),
                            anxCompraElectronicaTO.getCompNumero());


                    anxCompraElectronica.setUsrFechaInserta(anxCompraElectronicaAux.getUsrFechaInserta());
                    anxCompraElectronica.setESecuencial(anxCompraElectronicaAux.getESecuencial());
                    comprobar = operacionesAnexoDAOTransaccionLocal.accionAnxCompraElectronica(
                            anxCompraElectronica,
                            anxCompra,
                            sisSuceso,
                            accion);
                } else {
                    mensaje = "FNo se encuentra la Compra Electronicica...";
                }
            }
            if (comprobar) {
                if (accion == 'I') {
                    mensaje = "TEl comprobante fue " + anxCompraElectronicaTO.geteEstado() + " por el SRI...";
                }
                if (accion == 'M') {
                    mensaje = "TEl comprobante se descargo y fue " + anxCompraElectronicaTO.geteEstado() + " por el SRI...";
                }
            }
        } catch (Exception e) {
            mensaje = "FEl comprobante fue " + anxCompraElectronicaTO.geteEstado() + " por el SRI pero Ocurrió un error al guardar el comprobante electronico en la Base de dato Llamar al administrador";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "anx_compra_electronica",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public java.util.List<anexos.TO.AnxListaVentaElectronicaTO> getListaAnxVentaElectronicaTO(
            String empresa,
            String estado,
            String fechaDesde,
            String fechaHasta,
            String tipoDocumento) throws Exception {
        return operacionesAnexoDAOLocal.getListaAnxVentaElectronicaTO(
                empresa,
                estado,
                fechaDesde,
                fechaHasta,
                tipoDocumento);
    }

    @Override
    public byte[] getXmlComprobanteRetencion(
            String empresa,
            String ePeriodo,
            String eMotivo,
            String eNumero) throws Exception {
        return operacionesAnexoDAOLocal.getXmlComprobanteRetencion(empresa, ePeriodo, eMotivo, eNumero);
    }

    @Override
    public java.util.List<anexos.TO.AnxListadoCompraElectronicaTO> getListaAnxComprasElectronicaTO(
            String empresa,
            String estado,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesAnexoDAOLocal.getListaAnxComprasElectronicaTO(
                empresa,
                estado,
                fechaDesde,
                fechaHasta);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesPendientesTO> getAnexoListaRetencionesPendienteTO(String empresa) throws Exception {
        return operacionesAnexoDAOLocal.getAnexoListaRetencionesPendienteTO(empresa);
    }

    public String getUltimaNumeracionComprobanteElectronicos(String empresa, String comprobante, String estaBlecimiento, String puntoEmision) throws Exception {
        return operacionesAnexoDAOLocal.getUltimaNumeracionComprobanteElectronicos(empresa, comprobante, estaBlecimiento, puntoEmision);
    }

    @Override
    public java.util.List<anexos.TO.AnxListaConsultaVentaElectronicaTO> getListaAnxConsultaVentaElectronica(String empresa, String periodo, String motivo, String busqueda) throws Exception {
        return operacionesAnexoDAOLocal.getListaAnxConsultaVentaElectronica(empresa, periodo, motivo, busqueda);
    }

    @Override
    public byte[] getXmlComprobanteElectronico(
            String empresa,
            String ePeriodo,
            String eMotivo,
            String eNumero) throws Exception {
        return operacionesAnexoDAOLocal.getXmlComprobanteElectronico(
                empresa,
                ePeriodo,
                eMotivo,
                eNumero);
    }

    @Override
    public boolean comprobarAnxVentaElectronica(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception {
        return operacionesAnexoDAOLocal.comprobarAnxVentaElectronica(empresa, periodo, motivo, numero);
    }

    @Override
    public boolean comprobarAnxCompraElectronica(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception {
        return operacionesAnexoDAOLocal.comprobarAnxCompraElectronica(empresa, periodo, motivo, numero);
    }

    @Override
    public String comprobarAnxVentaElectronicaAutorizacion(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception {
        return operacionesAnexoDAOLocal.comprobarAnxVentaElectronicaAutorizacion(
                empresa,
                periodo,
                motivo,
                numero);
    }

    @Override
    public boolean comprobarRetencionAutorizadaProcesamiento(
            String empresa,
            String periodo,
            String motivo,
            String numero) throws Exception {
        return operacionesAnexoDAOLocal.comprobarRetencionAutorizadaProcesamiento(empresa, periodo, motivo, numero);

    }

    @Override
    public anexos.TO.AnxUltimaAutorizacionTO getAnxUltimaAutorizacionTO(
            String empresa,
            String proveedor,
            String tipoDocumento,
            String secuencial,
            String fechaFactura) throws Exception {
        return operacionesAnexoDAOLocal.getAnxUltimaAutorizacionTO(empresa, proveedor, tipoDocumento, secuencial, fechaFactura);
    }

    @Override
    public JasperPrint generarReporteTalonResumen(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String desde, String hasta, List<AnxTalonResumenTO> listaAnxTalonResumenTO) throws Exception {
        return generarReporteAnexosLocal.generarReporteTalonResumen(
                sisUsuarioEmpresaTO, desde, hasta, listaAnxTalonResumenTO);
    }

    @Override
    public JasperPrint generarReporteTalonResumenVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String desde, String hasta, List<AnxTalonResumenVentaTO> listaAnxTalonResumenVentaTO) throws Exception {
        return generarReporteAnexosLocal.generarReporteTalonResumenVentas(sisUsuarioEmpresaTO, desde, hasta, listaAnxTalonResumenVentaTO);
    }

    @Override
    public JasperPrint generarReporteListadoRetencionesPorNumero(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<AnxListaRetencionesTO> listaAnxListaRetencionesTO) throws Exception {
        return generarReporteAnexosLocal.generarReporteListadoRetencionesPorNumero(
                sisUsuarioEmpresaTO, listaAnxListaRetencionesTO);
    }

    @Override
    public JasperPrint generarReporteListadoRetencionesVentas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<AnxListadoRetencionesVentasTO> anxListadoRetencionesVentasTOs) throws Exception {
        return generarReporteAnexosLocal.generarReporteListadoRetencionesVentas(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta, anxListadoRetencionesVentasTOs);
    }

    @Override
    public JasperPrint generarReporteListadoDevolucionIva(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<AnxFunListadoDevolucionIvaTO> anxFunListadoDevolucionIvaTOs) throws Exception {
        return generarReporteAnexosLocal.generarReporteListadoDevolucionIva(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                anxFunListadoDevolucionIvaTOs);
    }
    //////////////////////////////////////////////////////////////// comprobantes Electronicos ///////////////////////////////////
    
    @Override
    public RespuestaSolicitud getRecepcionComprobantes(byte[] eXmlFirmado, String tipoAmbiente, sistema.TO.SisInfoTO sisInfoTO) throws Exception {

        RespuestaSolicitud respuesta = new RespuestaSolicitud();
        try {
            SisPckeystoreTO sisPckeystoreTO = operacionesSistemaDAOLocal.getSisPckeystoreTO(sisInfoTO);
            UtilsWebService.devuelveUrlWs(tipoAmbiente, "RecepcionComprobantes", operacionesAnexoDAOLocal.getAnxUrlWebServicesTO(), sisPckeystoreTO);
            respuesta = UtilsWebService.validarComprobante(eXmlFirmado);
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getComprobanteAutorizado",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        }
        return respuesta;
    }

    @Override
    public RespuestaComprobante getAutorizadocionComprobantes(
            String claveAcceso, String tipoAmbiente, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        RespuestaComprobante respuestaComprobante = null;
        try {
            SisPckeystoreTO sisPckeystoreTO = operacionesSistemaDAOLocal.getSisPckeystoreTO(sisInfoTO);
            for (int i = 0; i < 5; i++) {
                UtilsWebService.devuelveUrlWs(tipoAmbiente, "AutorizacionComprobantes", operacionesAnexoDAOLocal.getAnxUrlWebServicesTO(), sisPckeystoreTO);
                respuestaComprobante = UtilsWebService.autorizacionComprobante(claveAcceso);
                if (!respuestaComprobante.getAutorizaciones().getAutorizacion().isEmpty()) {
                    break;
                }
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getComprobanteAutorizado",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        }
        return respuestaComprobante;
    }


    @Override
    public anexos.TO.AnxComprobanteElectronicoUtilTO getEnvioComprobanteElectronicosWS(
            byte[] eXmlFirmado, 
            String claveAcceso, 
            String tipoAmbiente, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        RespuestaSolicitud respuestaSolicitud = null;
        RespuestaComprobante respuestaComprobante = null;
        anexos.TO.AnxComprobanteElectronicoUtilTO anxComprobanteElectronicoUtilTO = new AnxComprobanteElectronicoUtilTO();
        try {
            respuestaSolicitud = getRecepcionComprobantes(eXmlFirmado, tipoAmbiente, sisInfoTO);
            if (respuestaSolicitud.getEstado().equals("RECIBIDA")) {
                respuestaComprobante = getAutorizadocionComprobantes(claveAcceso, tipoAmbiente, sisInfoTO);
                anxComprobanteElectronicoUtilTO.setRespuestaComprobante(respuestaComprobante);
            }
            anxComprobanteElectronicoUtilTO.setRespuestaSolicitud(respuestaSolicitud);
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "getEnvioComprobanteElectronicosWS",
                    sisInfoTO,
                    operacionessistemaWebDAOTransaccionLocal);
        }

        return anxComprobanteElectronicoUtilTO;

    }
//    @Override
//    public anexos.TO.AnxComprobanteAutorizadoTO getAutorizadocionComprobantes(
//            String claveAcceso, String tipoAmbiente, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
//     
//       
//        RespuestaComprobante respuestaComprobante = null;
//        anexos.TO.AnxComprobanteAutorizadoTO anxComprobanteAutorizadoTO = null;
//        try {
//            SisPckeystoreTO sisPckeystoreTO = operacionesSistemaDAOLocal.getSisPckeystoreTO(sisInfoTO);
//            for (int i = 0; i < 5; i++) {
//                UtilsWebService.devuelveUrlWs(tipoAmbiente, "AutorizacionComprobantes", operacionesAnexoDAOLocal.getAnxUrlWebServicesTO(), sisPckeystoreTO);
//                respuestaComprobante = UtilsWebService.autorizacionComprobante(claveAcceso);
//                if (!respuestaComprobante.getAutorizaciones().getAutorizacion().isEmpty()) {
//                    break;
//                }
//            }
//            if (respuestaComprobante != null) {
//                anxComprobanteAutorizadoTO = new AnxComprobanteAutorizadoTO();
//                for (Autorizacion item : respuestaComprobante.getAutorizaciones().getAutorizacion()) {
//                    if (item.getEstado().equals("AUTORIZADO")) {
//
//                        anxComprobanteAutorizadoTO.setClaveAcceso(claveAcceso);
//                        anxComprobanteAutorizadoTO.setRasonSocialEmisor(item.getComprobante().substring(item.getComprobante().lastIndexOf("<razonSocial>") + 13, item.getComprobante().lastIndexOf("</razonSocial>")).trim());
//                        anxComprobanteAutorizadoTO.setRucEmisor(item.getComprobante().substring(item.getComprobante().lastIndexOf("<ruc>") + 5, item.getComprobante().lastIndexOf("</ruc>")).trim());
//                        anxComprobanteAutorizadoTO.setNumeroAutorizacion(item.getNumeroAutorizacion());
//                        anxComprobanteAutorizadoTO.setFechaAutorizacion(item.getFechaAutorizacion().toString());
//                        anxComprobanteAutorizadoTO.setEstado(item.getEstado());
//                        anxComprobanteAutorizadoTO.setNumeroDocumento(item.getComprobante().substring(item.getComprobante().lastIndexOf("<estab>") + 7, item.getComprobante().lastIndexOf("</estab>")).trim() + "-"
//                                + item.getComprobante().substring(item.getComprobante().lastIndexOf("<ptoEmi>") + 8, item.getComprobante().lastIndexOf("</ptoEmi>")).trim() + "-"
//                                + item.getComprobante().substring(item.getComprobante().lastIndexOf("<secuencial>") + 12, item.getComprobante().lastIndexOf("</secuencial>")).trim());
//                        anxComprobanteAutorizadoTO.setFechaEmision(item.getComprobante().substring(item.getComprobante().lastIndexOf("<fechaEmision>") + 14, item.getComprobante().lastIndexOf("</fechaEmision>")).trim());
//                        anxComprobanteAutorizadoTO.setAmbiente(item.getComprobante().substring(item.getComprobante().lastIndexOf("<ambiente>") + 10, item.getComprobante().lastIndexOf("</ambiente>")).trim().equals(TipoAmbienteEnum.PRODUCCION.getCode())
//                                ? TipoAmbienteEnum.PRODUCCION.toString() : TipoAmbienteEnum.PRUEBAS.toString());
//                        String tipoComprobante = item.getComprobante().substring(item.getComprobante().lastIndexOf("<codDoc>") + 8, item.getComprobante().lastIndexOf("</codDoc>")).trim();
//                        if (tipoComprobante.equals(TipoComprobanteEnum.FACTURA.getCode())) {
//                            anxComprobanteAutorizadoTO.setTipo(TipoComprobanteEnum.FACTURA.getDescripcion());
//                            anxComprobanteAutorizadoTO.setTotal(item.getComprobante().substring(item.getComprobante().lastIndexOf("<importeTotal>") + 14, item.getComprobante().lastIndexOf("</importeTotal>")).trim());
//                        } else if (tipoComprobante.equals(TipoComprobanteEnum.NOTA_DE_CREDITO.getCode())) {
//                            anxComprobanteAutorizadoTO.setTipo(TipoComprobanteEnum.NOTA_DE_CREDITO.getDescripcion());
//                            anxComprobanteAutorizadoTO.setTotal(item.getComprobante().substring(item.getComprobante().lastIndexOf("<valorModificacion>") + 19, item.getComprobante().lastIndexOf("</valorModificacion>")).trim());
//                        } else if (tipoComprobante.equals(TipoComprobanteEnum.NOTA_DE_DEBITO.getCode())) {
//                            anxComprobanteAutorizadoTO.setTipo(TipoComprobanteEnum.NOTA_DE_DEBITO.getDescripcion());
//                            anxComprobanteAutorizadoTO.setTotal(item.getComprobante().substring(item.getComprobante().lastIndexOf("<valorTotal>") + 12, item.getComprobante().lastIndexOf("</valorTotal>")).trim());
//                        } else if (tipoComprobante.equals(TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode())) {
//                            anxComprobanteAutorizadoTO.setTipo(TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getDescripcion());
//                        }
//                        anxComprobanteAutorizadoTO.setComprobante(item);
//                        break;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            validaciones.Excepciones.guardarExcepcionesEJB(
//                    e,
//                    getClass().getName(),
//                    "getComprobanteAutorizado",
//                    sisInfoTO,
//                    operacionessistemaWebDAOTransaccionLocal);
//        }
//        return anxComprobanteAutorizadoTO;
//    }
}
