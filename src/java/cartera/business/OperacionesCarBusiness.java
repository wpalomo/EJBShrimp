/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.business;

import cartera.DAO.OperacionesCarDAOLocal;
import cartera.DAO.OperacionesCarDAOTransaccionLocal;
import cartera.TO.*;
import cartera.entity.*;
import cartera.reporte.*;
import contabilidad.TO.ConContableTO;
import inventario.DAO.OperacionesInventarioDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
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
public class OperacionesCarBusiness implements OperacionesCarBusinessLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    // <editor-fold defaultstate="collapsed" desc="DECLARACIONES EJB">
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @javax.ejb.EJB
    produccion.DAO.OperacionesProduccionDAOLocal operacionesProduccionDAOLocal;
    @EJB
    OperacionesInventarioDAOLocal operacionesInventarioDAOLocal;
    @EJB
    OperacionesSistemaDAOTransaccionLocal operacionesDAOTransaccionLocal;
    @EJB
    OperacionesCarDAOTransaccionLocal operacionesCarDAOTransaccionLocal;
    @EJB
    SisErrorFacadeLocal sisErrorFacadeLocal;
    @EJB
    OperacionesCarDAOLocal operacionesCarDAOLocal;
    @EJB
    contabilidad.DAO.OperacionesContabilidadDAOLocal operacionesContabilidadDAOLocal;
    @EJB
    contabilidad.DAO.OperacionesContabilidadDAOTransaccionLocal operacionesContabilidadDAOTransaccionLocal;
    @EJB
    contabilidad.business.OperacionesContabilidadBusinessLocal operacionesContabilidadBusinessLocal;
    @EJB
    anexos.DAO.OperacionesAnexoDAOLocal anexoDAOLocal;
    @EJB
    GenerarReporteCarteraLocal generarReporteCarteraLocal;
    // </editor-fold>
    Boolean comprobar = false;
    private String mensaje = "";
    private java.math.BigDecimal cero = new java.math.BigDecimal("0.00");
    public SisErrorTO sisErrorTO = null;
    private String susTabla;
    private String susClave;
    private String susSuceso;
    private String susDetalle;
    // <editor-fold defaultstate="collapsed" desc="PAGOS">

    public JasperPrint generarReporteCuentasPorCobrarDetallado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorCobrarDetallado> reporteCuentasPorCobrarDetallado) throws Exception {
        return generarReporteCarteraLocal.generarReporteCuentasPorCobrarDetallado(sisUsuarioEmpresaTO, reporteCuentasPorCobrarDetallado);
    }

    public JasperPrint generarReporteCuentasPorPagarDetallado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarDetallado> reporteCuentasPorPagarDetallado) throws Exception {
        return generarReporteCarteraLocal.generarReporteCuentasPorPagarDetallado(sisUsuarioEmpresaTO, reporteCuentasPorPagarDetallado);
    }

    public JasperPrint generarReporteCuentasPorCobrarGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorCobrarGeneral> reporteCuentasPorCobrarGeneral) throws Exception {
        return generarReporteCarteraLocal.generarReporteCuentasPorCobrarGeneral(sisUsuarioEmpresaTO, reporteCuentasPorCobrarGeneral);
    }

    public JasperPrint generarReporteCarFunCuentasPorCobrarListadoVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCarFunCuentasPorCobrarListadoVentas> reporteCarFunCuentasPorCobrarListadoVentas) throws Exception {
        return generarReporteCarteraLocal.generarReporteCarFunCuentasPorCobrarListadoVentas(sisUsuarioEmpresaTO, reporteCarFunCuentasPorCobrarListadoVentas);
    }

    public JasperPrint generarReporteCarFunCuentasPorPagarListadoCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCarFunCuentasPorPagarListadoCompras> reporteCarFunCuentasPorPagarListadoCompras) throws Exception {
        return generarReporteCarteraLocal.generarReporteCarFunCuentasPorPagarListadoCompras(sisUsuarioEmpresaTO, reporteCarFunCuentasPorPagarListadoCompras);
    }

    public JasperPrint generarReporteCuentasPorPagarGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarGeneral> reporteCuentasPorPagarGeneral) throws Exception {
        return generarReporteCarteraLocal.generarReporteCuentasPorPagarGeneral(sisUsuarioEmpresaTO, reporteCuentasPorPagarGeneral);
    }

    public JasperPrint generarReporteCuentasPorPagarAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarAnticipos> reporteCuentasPorPagarAnticipos) throws Exception {
        return generarReporteCarteraLocal.generarReporteCuentasPorPagarAnticipos(sisUsuarioEmpresaTO, reporteCuentasPorPagarAnticipos);
    }

    public JasperPrint generarReporteCuentasPorPagarSaldoAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarCobrarSaldoAnticipos> reporteCuentasPorPagarSaldoAnticipos) throws Exception {
        return generarReporteCarteraLocal.generarReporteCuentasPorPagarSaldoAnticipos(sisUsuarioEmpresaTO, reporteCuentasPorPagarSaldoAnticipos);
    }

    public JasperPrint generarReporteCuentasPorCobrarSaldoAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarCobrarSaldoAnticipos> reporteCuentasPorPagarSaldoAnticipos) throws Exception {
        return generarReporteCarteraLocal.generarReporteCuentasPorCobrarSaldoAnticipos(sisUsuarioEmpresaTO, reporteCuentasPorPagarSaldoAnticipos);
    }

    public JasperPrint generarReporteCuentasPorCobrarAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarAnticipos> reporteCuentasPorPagarAnticipos) throws Exception {
        return generarReporteCarteraLocal.generarReporteCuentasPorCobrarAnticipos(sisUsuarioEmpresaTO, reporteCuentasPorPagarAnticipos);
    }

    public JasperPrint generarReporteCobros(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCobros> reporteCobros) throws Exception {
        return generarReporteCarteraLocal.generarReporteCobros(sisUsuarioEmpresaTO, reporteCobros);
    }

    public JasperPrint generarReportePagos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReportePagos> reportePagos) throws Exception {
        return generarReporteCarteraLocal.generarReportePagos(sisUsuarioEmpresaTO, reportePagos);
    }

    public JasperPrint generarReporteMayorAuxiliarProveedorCliente(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteMayorAuxiliarProveedorCliente> reporteMayorAuxiliarProveedorCliente) throws Exception {
        return generarReporteCarteraLocal.generarReporteMayorAuxiliarProveedorCliente(sisUsuarioEmpresaTO, reporteMayorAuxiliarProveedorCliente);
    }

    public JasperPrint generarReporteListadoPagos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteListadoPagos> reporteListadoPagos) throws Exception {
        return generarReporteCarteraLocal.generarReporteListadoPagos(sisUsuarioEmpresaTO, reporteListadoPagos);
    }

    public JasperPrint generarReporteListadoCobros(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteListadoCobros> reporteListadoCobros) throws Exception {
        return generarReporteCarteraLocal.generarReporteListadoCobros(sisUsuarioEmpresaTO, reporteListadoCobros);
    }

    @Override
    public CarContableTO insertarCarPagos(CarPagosTO carPagosTO,
            List<CarPagosDetalleComprasTO> carPagosDetalleComprasTOs,
            java.util.List<cartera.TO.CarPagosDetalleAnticiposTO> carPagosDetalleAnticiposTOs,
            List<CarPagosDetalleFormaTO> carPagosDetalleFormaTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        mensaje = "";
        String tipDetalle = "C-PAG";
        String ctaProveedorPagos = "";
        String ctaProveedorAnticipos = "";
        String ctaFormaPago = "";
        CarContableTO carContableTO = new CarContableTO();
        List<String> listaDetalle = new java.util.ArrayList(1);
        List<String> listaAnticipo = new java.util.ArrayList(1);
        java.util.List<String> listaFacturaTO = new java.util.ArrayList(1);
        try {
            List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(carPagosTO.getUsrEmpresa());

            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (Validacion.fecha(carPagosTO.getPagFecha(), "yyyy-MM-dd").getTime()
                        >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && Validacion.fecha(carPagosTO.getPagFecha(), "yyyy-MM-dd").getTime()
                        <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                        && sisListaPeriodoTO.getPerCerrado() == false) {
                    comprobar = true;
                    carPagosTO.setPagPeriodo(sisListaPeriodoTO.getPerCodigo());
                    break;
                }
            }
            if (comprobar) {
                List<CarListaPagosCobrosTO> carListaPagosCobrosTOs = new java.util.ArrayList(1);
                carListaPagosCobrosTOs = operacionesCarDAOLocal.getCarListaPagosTO(carPagosTO.getUsrEmpresa(), carPagosTO.getProvCodigo());
                boolean documento;
                for (int k = 0; k < carPagosDetalleComprasTOs.size(); k++) {
                    documento = false;
                    for (int i = 0; i < carListaPagosCobrosTOs.size(); i++) {
                        if (carPagosDetalleComprasTOs.get(k).getCompPeriodo().equals(carListaPagosCobrosTOs.get(i).getCxccPeriodo())
                                && carPagosDetalleComprasTOs.get(k).getCompMotivo().equals(carListaPagosCobrosTOs.get(i).getCxccMotivo())
                                && carPagosDetalleComprasTOs.get(k).getCompNumero().equals(carListaPagosCobrosTOs.get(i).getCxccNumero())) {
                            documento = true;
                            if ((carPagosDetalleComprasTOs.get(k).getDetValor().compareTo(carListaPagosCobrosTOs.get(i).getCxccSaldo()) > 0)) {
                                listaDetalle.add(carPagosDetalleComprasTOs.get(k).getCompDocumento() + "     "
                                        + carPagosDetalleComprasTOs.get(k).getCompPeriodo() + " | "
                                        + carPagosDetalleComprasTOs.get(k).getCompMotivo() + " | "
                                        + carPagosDetalleComprasTOs.get(k).getCompNumero());
                            }
                        } else if (i == carListaPagosCobrosTOs.size() - 1
                                && !documento) {
                            listaDetalle.add(carPagosDetalleComprasTOs.get(k).getCompDocumento() + "     "
                                    + carPagosDetalleComprasTOs.get(k).getCompPeriodo() + " | "
                                    + carPagosDetalleComprasTOs.get(k).getCompMotivo() + " | "
                                    + carPagosDetalleComprasTOs.get(k).getCompNumero());
                        }
                    }
                }
                if (listaDetalle.isEmpty()) {
                    ////// CREANDO COMPRASoperacionesCarDAOLocal.getCarPagosForma(empresa)
                    List<inventario.entity.InvCompras> invComprases = new java.util.ArrayList(0);
                    inventario.entity.InvCompras invComprasBusqueda = null;
                    inventario.entity.InvCompras invCompras = null;
                    for (CarPagosDetalleComprasTO carPagosDetalleComprasTO : carPagosDetalleComprasTOs) {
                        invComprasBusqueda = operacionesInventarioDAOLocal.buscarInvCompras(
                                carPagosDetalleComprasTO.getCompEmpresa(),
                                carPagosDetalleComprasTO.getCompPeriodo(),
                                carPagosDetalleComprasTO.getCompMotivo(),
                                carPagosDetalleComprasTO.getCompNumero());
                        invCompras = inventario.helper.ConversionesInventario.convertirInvCompras_InvCompras(invComprasBusqueda);
                        if (invCompras == null) {
                            listaFacturaTO.add(carPagosDetalleComprasTO.getCompDocumento() + " (no encontrada)");
                        } else {
                            if (invCompras.getCompAnulado()) {
                                listaFacturaTO.add(carPagosDetalleComprasTO.getCompDocumento() + " (anulada)");
                            }
                            if (invCompras.getCompPendiente()) {
                                listaFacturaTO.add(carPagosDetalleComprasTO.getCompDocumento() + " (pendiente)");
                            }
                        }
                        if (invCompras != null
                                && !invCompras.getCompAnulado()
                                && !invCompras.getCompPendiente()) {
                            //////////////////////////////Por momento
                            //                            invCompras.getCompSaldo().compareTo(carPagosDetalleComprasTO.getDetValor()) > 0){
                            invCompras.setCompSaldo(invCompras.getCompSaldo().subtract(carPagosDetalleComprasTO.getDetValor()));
                            invComprases.add(invCompras);
                        }
                        invComprasBusqueda = null;
                        invCompras = null;
                    }
                    ////NO HAY ERRORES EN FACTURA
                    if (listaFacturaTO.isEmpty()) {
                        //llenar contable
                        ConContableTO conContableTO = new ConContableTO();
                        conContableTO.setEmpCodigo(carPagosTO.getUsrEmpresa());
                        conContableTO.setPerCodigo(carPagosTO.getPagPeriodo());
                        conContableTO.setTipCodigo(tipDetalle);
                        carPagosTO.setPagTipo(tipDetalle);
                        //                    conContableTO.setConNumero(rhPrestamoTO.getConNumero());
                        conContableTO.setConFecha(carPagosTO.getPagFecha());
                        conContableTO.setConPendiente(false);
                        conContableTO.setConBloqueado(false);
                        conContableTO.setConAnulado(false);
                        conContableTO.setConGenerado(true);
                        //                    conContableTO.setConDocOrigen("");
                        conContableTO.setConConcepto(carPagosTO.getConApellidosNombres());//nombre empleado
                        conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                        conContableTO.setConObservaciones(carPagosTO.getPagObservaciones().length() > 255 ? carPagosTO.getPagObservaciones().substring(0, 255) : carPagosTO.getPagObservaciones());
                        conContableTO.setUsrInsertaContable(carPagosTO.getUsrCodigo());
                        conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                        ///// CREANDO Suceso
                        susSuceso = "INSERT";
                        susTabla = "cartera.car_pagos";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        ////// CREANDO NUMERACION
                        contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                carPagosTO.getUsrEmpresa(),
                                carPagosTO.getPagPeriodo(),
                                carPagosTO.getPagTipo()));
                        ////// CREANDO CONTABLE
                        contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                        ////// CREANDO CarPagos
                        carPagosTO.setPagTipo(tipDetalle);
                        carPagosTO.setUsrFechaInserta(Validacion.fechaSistema());
                        CarPagos carPagos = cartera.helper.ConversionesCar.convertirCarPagosTO_CarPagos(carPagosTO);
                        ////// CREANDO Lista de CarPagosDetalleCompras
                        List<CarPagosDetalleCompras> carPagosDetalleCompras = new java.util.ArrayList(0);
                        for (CarPagosDetalleComprasTO carPagosDetalleComprasTO : carPagosDetalleComprasTOs) {
                            carPagosDetalleComprasTO.setDetSecuencial(0);
                            carPagosDetalleCompras.add(cartera.helper.ConversionesCar.convertirCarPagosDetalleComprasTO_CarPagosDetalleCompras(
                                    carPagosDetalleComprasTO));
                        }
                        ////// CREANDO Lista de CarPagosDetalleForma
                        List<CarPagosDetalleForma> carPagosDetalleForma = new java.util.ArrayList(0);
                        for (CarPagosDetalleFormaTO carPagosDetalleFormaTO : carPagosDetalleFormaTOs) {
                            carPagosDetalleForma.add(cartera.helper.ConversionesCar.convertirCarPagosDetalleFormaTO_CarPagosDetalleForma(
                                    carPagosDetalleFormaTO));
                        }
                        ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                        java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                        contabilidad.entity.ConDetalle conDetalle = null;
                        /////////////////////////////////////////////////////////////////////////////////
                        int contador = 0;

                        for (int i = 0; i < carPagosDetalleComprasTOs.size(); i++) {
                            conDetalle = new contabilidad.entity.ConDetalle();
                            conDetalle.setConContable(conContable);
                            conDetalle.setDetSecuencia(i);
                            conDetalle.setSecCodigo(carPagosDetalleComprasTOs.get(i).getCompSecCodigo());//pendiente
                            conDetalle.setPisNumero("");
                            conDetalle.setDetGenerado(true);

                            if (invComprases.get(i).getCompActivoFijo()) {
                                ctaProveedorPagos = anexoDAOLocal.getCuentasContablesTO(carPagosTO.getUsrEmpresa()).getCtaCuentasPorPagarActivoFijo();
                            } else {
                                ctaProveedorPagos = anexoDAOLocal.getCuentasContablesTO(carPagosTO.getUsrEmpresa()).getCtaCuentasPorPagar();
                            }
                          
                            conDetalle.setConCuentas(
                                    operacionesContabilidadDAOLocal.buscarCuentas(
                                    carPagosTO.getUsrEmpresa(),
                                    (ctaProveedorPagos == null) ? "" : ctaProveedorPagos));//categoria
                            ctaProveedorPagos = ctaProveedorPagos == null ? "" : ctaProveedorPagos;
                            if (ctaProveedorPagos.isEmpty()) {
                                mensaje = "FNo se encuentra la cuenta contable del Proveedor (Pagos)...";
                            }

                            conDetalle.setDetDebitoCredito(carPagosDetalleComprasTOs.get(i).getDetValor().compareTo(cero) > 0 ? 'D' : 'C');
                            conDetalle.setDetDocumento(carPagosDetalleComprasTOs.get(i).getCompDocumento());
                            conDetalle.setDetValor(carPagosDetalleComprasTOs.get(i).getDetValor().abs());
                            conDetalle.setDetReferencia("PAG");//

                            conDetalle.setDetOrden(contador++);//
                            listaConDetalle.add(contador - 1, conDetalle);
                            conDetalle = null;
                        }
                        for (int i = 0; i < carPagosDetalleFormaTOs.size(); i++) {
                            conDetalle = new contabilidad.entity.ConDetalle();
                            conDetalle.setConContable(conContable);
                            conDetalle.setDetSecuencia(i);
                            /////errror
                            //                        CarPagosForma carPagosForma = operacionesCarDAOLocal.buscarCarPagosForma(carPagosDetalleFormaTOs.get(i).getFpSecuencial());
                            //                        if(carPagosForma != null)
                            //                            conDetalle.setDetCentroProduccion(carPagosForma.getSecCodigo());//pendiente
                            conDetalle.setSecCodigo(carPagosDetalleFormaTOs.get(i).getSecCodigo());
                            conDetalle.setPisNumero("");
                            conDetalle.setDetGenerado(true);

                            ctaFormaPago = operacionesCarDAOLocal.buscarCtaFormaPago(
                                    carPagosTO.getUsrEmpresa(),
                                    carPagosDetalleFormaTOs.get(i).getFpSecuencial());

                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                    carPagosTO.getUsrEmpresa(),
                                    (ctaFormaPago == null) ? "" : ctaFormaPago));//categoria
                            ctaFormaPago = ctaFormaPago == null ? "" : ctaFormaPago;
                            if (ctaFormaPago.isEmpty()) {
                                mensaje = "FNo se encuentra la cuenta contable forma de pago...";
                            }

                            conDetalle.setDetDebitoCredito(carPagosDetalleFormaTOs.get(i).getDetValor().compareTo(cero) > 0 ? 'C' : 'D');
                            conDetalle.setDetDocumento(carPagosDetalleFormaTOs.get(i).getDetReferencia());
                            conDetalle.setDetValor(carPagosDetalleFormaTOs.get(i).getDetValor().abs());
                            conDetalle.setDetReferencia("FP");//
                            conDetalle.setDetObservaciones(carPagosDetalleFormaTOs.get(i).getDetObservaciones().length() > 255 ? carPagosDetalleFormaTOs.get(i).getDetObservaciones().substring(0, 255) : carPagosDetalleFormaTOs.get(i).getDetObservaciones());//

                            conDetalle.setDetOrden(contador++);//
                            listaConDetalle.add(contador - 1, conDetalle);
                            conDetalle = null;
                        }
                        for (int i = 0; i < carPagosDetalleAnticiposTOs.size(); i++) {
                            conDetalle = new contabilidad.entity.ConDetalle();
                            conDetalle.setConContable(conContable);
                            conDetalle.setDetSecuencia(i);
                            conDetalle.setSecCodigo(carPagosDetalleAnticiposTOs.get(i).getAntSector());
                            conDetalle.setPisNumero("");
                            conDetalle.setDetGenerado(true);
                            ctaProveedorAnticipos = anexoDAOLocal.getCuentasContablesTO(carPagosTO.getUsrEmpresa()).getCtaAnticiposAProveedores();
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                    carPagosTO.getUsrEmpresa(),
                                    (ctaProveedorAnticipos == null) ? "" : ctaProveedorAnticipos));//categoria
                            ctaProveedorAnticipos = ctaProveedorAnticipos == null ? "" : ctaProveedorAnticipos;
                            if (ctaProveedorAnticipos.isEmpty()) {
                                mensaje = "FNo se encuentra la cuenta contable del Proveedor (Anticipo)...";
                            }

                            conDetalle.setDetDebitoCredito(carPagosDetalleAnticiposTOs.get(i).getDetValor().compareTo(cero) > 0 ? 'C' : 'D');
                            conDetalle.setDetDocumento(carPagosDetalleAnticiposTOs.get(i).getAntPeriodo() + " | " + carPagosDetalleAnticiposTOs.get(i).getAntNumero());
                            conDetalle.setDetValor(carPagosDetalleAnticiposTOs.get(i).getDetValor().abs());
                            conDetalle.setDetReferencia("ANT-PRO");//

                            conDetalle.setDetOrden(contador++);//
                            listaConDetalle.add(contador - 1, conDetalle);
                            conDetalle = null;
                        }

                        ////// CREANDO Lista de CarPagosDetalleAnticipos
                        List<cartera.entity.CarPagosDetalleAnticipos> carPagosDetalleAnticipos = new java.util.ArrayList(0);
                        for (cartera.TO.CarPagosDetalleAnticiposTO carPagosDetalleAnticiposTO : carPagosDetalleAnticiposTOs) {
                            carPagosDetalleAnticipos.add(cartera.helper.ConversionesCar.convertirCarPagosDetalleAnticiposTO_CarPagosDetalleAnticipos(
                                    carPagosDetalleAnticiposTO));
                        }

                        comprobar = false;
                        if (mensaje.isEmpty()) {//revisar si estan llenos
                            comprobar = operacionesCarDAOTransaccionLocal.insertarTransaccionCarteraPagos(
                                    carPagos,
                                    carPagosDetalleCompras,
                                    carPagosDetalleForma,
                                    carPagosDetalleAnticipos,
                                    conContable,
                                    listaConDetalle,
                                    sisSuceso,
                                    conNumeracion,
                                    sisInfoTO);
                        }
                        if (comprobar) {
                            sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(
                                    conContableTO.getEmpCodigo(),
                                    conContable.getConContablePK().getConPeriodo());
                            contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(
                                    conContableTO.getEmpCodigo(),
                                    conContable.getConContablePK().getConTipo());
                            mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>"
                                    + carPagos.getCarPagosPK().getPagNumero();
                            carContableTO.setContPeriodo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                            carContableTO.setContTipo(conTipo.getConTipoPK().getTipCodigo());
                            carContableTO.setContNumero(conContable.getConContablePK().getConNumero());
                        }
                    } else {
                        mensaje = "FLos siguientes Documentos han tenido problemas:";
                        carContableTO.setListaFacturaTO(listaFacturaTO);
                    }
                } else {
                    mensaje = "FLos siguientes Documentos se esta pagando mas de lo que se debe:";
                    carContableTO.setListaFacturaTO(listaDetalle);
                }
            } else {
                mensaje = "FNo se encuentra ningún periodo para la fecha que ingresó\nNo esta creado o esta cerrado...";
            }
            carContableTO.setMensaje(mensaje);
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar el contable, inténtelo de nuevo...";
            carContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarCarPagos",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return carContableTO;
        }
    }

    @Override
    public CarListaPagosProveedorTO getPagosConsultaProveedorTO(String empresa, String periodo, String tipo, String numero) throws Exception {
        return operacionesCarDAOLocal.getPagosConsultaProveedor(empresa, periodo, tipo, numero);
    }

    @Override
    public CarListaPagosProveedorTO getPagosConsultaProveedorAnticipoTO(String empresa, String periodo, String tipo, String numero) throws Exception {
        return operacionesCarDAOLocal.getPagosConsultaProveedorAnticipo(empresa, periodo, tipo, numero);
    }

    @Override
    public List<CarListaPagosCobrosTO> getPagosConsultaDetalleComprasTO(String empresa, String periodo, String numero) throws Exception {
        return operacionesCarDAOLocal.getPagosConsultaDetalleCompras(empresa, periodo, numero);
    }

    @Override
    public List<CarListaPagosCobrosDetalleFormaTO> getPagosConsultaDetalleFormaTO(String empresa, String periodo, String numero) throws Exception {
        return operacionesCarDAOLocal.getPagosConsultaDetalleForma(empresa, periodo, numero);
    }

    @Override
    public List<CarListaPagosCobrosTO> getCarListaPagosTO(java.lang.String empresa, java.lang.String proveedor) throws Exception {
        return operacionesCarDAOLocal.getCarListaPagosTO(empresa, proveedor);
    }

    @Override
    public java.util.List<cartera.TO.CarFunPagosTO> getCarFunPagosTO(java.lang.String empresa, String sector, java.lang.String desde, java.lang.String hasta, java.lang.String proveedor) throws java.lang.Exception {
        return operacionesCarDAOLocal.getCarFunPagosTO(empresa, sector, desde, hasta, proveedor);
    }

    @Override
    public java.util.List<cartera.TO.CarFunPagosPruebaTO> getCarFunPagosPruebaTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String proveedor) throws java.lang.Exception {
        return operacionesCarDAOLocal.getCarFunPagosPruebaTO(empresa, desde, hasta, proveedor);
    }

    @Override
    public List<CarFunPagosDetalleTO> getCarFunPagosDetalleTO(String empresa, String sector, String desde, String hasta, String proveedor, String formaPago) throws Exception {
        return operacionesCarDAOLocal.getCarFunPagosDetalleTO(empresa, sector, desde, hasta, proveedor, formaPago);
    }

    @Override
    public java.util.List<cartera.TO.CarFunPagosSaldoAnticipoTO> getCarFunPagosSaldoAnticipoTO(java.lang.String empresa, java.lang.String proveedor) throws java.lang.Exception {
        return operacionesCarDAOLocal.getCarFunPagosSaldoAnticipoTO(empresa, proveedor);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="COBROS">

    @Override
    public CarContableTO insertarCarCobros(
            CarCobrosTO carCobrosTO,
            List<CarCobrosDetalleVentasTO> carCobrosDetalleVentasTOs,
            java.util.List<cartera.TO.CarCobrosDetalleAnticiposTO> carCobrosDetalleAnticiposTOs,
            List<CarCobrosDetalleFormaTO> carCobrosDetalleFormaTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        mensaje = "";
        String tipDetalle = "C-COB";
        String ctaClientePagos = "";
        String ctaClienteAnticipos = "";
        String ctaFormaCobro = "";
        CarContableTO carContableTO = new CarContableTO();
        List<String> lista = new java.util.ArrayList(1);
        java.util.List<String> listaFacturaTO = new java.util.ArrayList(1);
        try {
            List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList(1);
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(carCobrosTO.getUsrEmpresa());

            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (Validacion.fecha(carCobrosTO.getCobFecha(), "yyyy-MM-dd").getTime()
                        >= Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && Validacion.fecha(carCobrosTO.getCobFecha(), "yyyy-MM-dd").getTime()
                        <= Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()
                        && sisListaPeriodoTO.getPerCerrado() == false) {
                    comprobar = true;
                    carCobrosTO.setCobPeriodo(sisListaPeriodoTO.getPerCodigo());
                    break;
                }
            }
            if (comprobar) {
                List<CarListaPagosCobrosTO> carListaPagosCobrosTOs = new java.util.ArrayList(1);
                carListaPagosCobrosTOs = operacionesCarDAOLocal.getCarListaCobrosTO(carCobrosTO.getUsrEmpresa(), carCobrosTO.getCliCodigo());
                boolean documento;
                for (int k = 0; k < carCobrosDetalleVentasTOs.size(); k++) {
                    documento = false;
                    for (int i = 0; i < carListaPagosCobrosTOs.size(); i++) {
                        if (carCobrosDetalleVentasTOs.get(k).getVtaPeriodo().equals(carListaPagosCobrosTOs.get(i).getCxccPeriodo())
                                && carCobrosDetalleVentasTOs.get(k).getVtaMotivo().equals(carListaPagosCobrosTOs.get(i).getCxccMotivo())
                                && carCobrosDetalleVentasTOs.get(k).getVtaNumero().equals(carListaPagosCobrosTOs.get(i).getCxccNumero())) {
                            documento = true;
                            if ((carCobrosDetalleVentasTOs.get(k).getDetValor().compareTo(carListaPagosCobrosTOs.get(i).getCxccSaldo()) > 0)) {
                                lista.add(carCobrosDetalleVentasTOs.get(k).getVtaDocumento() + "     "
                                        + carCobrosDetalleVentasTOs.get(k).getVtaPeriodo() + " | "
                                        + carCobrosDetalleVentasTOs.get(k).getVtaMotivo() + " | "
                                        + carCobrosDetalleVentasTOs.get(k).getVtaNumero());
                            }
                        } else if (i == carListaPagosCobrosTOs.size() - 1
                                && !documento) {
                            lista.add(carCobrosDetalleVentasTOs.get(k).getVtaDocumento() + "     "
                                    + carCobrosDetalleVentasTOs.get(k).getVtaPeriodo() + " | "
                                    + carCobrosDetalleVentasTOs.get(k).getVtaMotivo() + " | "
                                    + carCobrosDetalleVentasTOs.get(k).getVtaNumero());
                        }
                    }
                }
                if (lista.isEmpty()) {
                    comprobar = false;
                    ////NO HAY ERRORES EN FACTURA
                    if (listaFacturaTO.isEmpty()) {
                        //llenar contable
                        ConContableTO conContableTO = new ConContableTO();
                        conContableTO.setEmpCodigo(carCobrosTO.getUsrEmpresa());
                        conContableTO.setPerCodigo(carCobrosTO.getCobPeriodo());
                        conContableTO.setTipCodigo(tipDetalle);
                        carCobrosTO.setCobTipo(tipDetalle);
                        conContableTO.setConFecha(carCobrosTO.getCobFecha());
                        conContableTO.setConPendiente(false);
                        conContableTO.setConBloqueado(false);
                        conContableTO.setConAnulado(false);
                        conContableTO.setConGenerado(true);
                        conContableTO.setConConcepto(carCobrosTO.getConApellidosNombres());//nombre empleado
                        conContableTO.setConDetalle("COMPROBANTE GENERADO POR EL SISTEMA");//
                        conContableTO.setConObservaciones(carCobrosTO.getCobObservaciones().length() > 255 ? carCobrosTO.getCobObservaciones().substring(0, 255) : carCobrosTO.getCobObservaciones());
                        conContableTO.setUsrInsertaContable(carCobrosTO.getUsrCodigo());
                        conContableTO.setUsrFechaInsertaContable(Validacion.fechaSistema());
                        ///// CREANDO Suceso (SE TERMINA DE LLENAR EN EL TRANSACCION)
                        susSuceso = "INSERT";
                        susTabla = "cartera.car_cobros";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        ////// CREANDO NUMERACION
                        contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                carCobrosTO.getUsrEmpresa(),
                                carCobrosTO.getCobPeriodo(),
                                carCobrosTO.getCobTipo()));
                        ////// CREANDO CONTABLE
                        contabilidad.entity.ConContable conContable = contabilidad.helper.ConversionesContabilidad.convertirConContableTO_ConContable(conContableTO);
                        ////// CREANDO CarPagos
                        carCobrosTO.setCobTipo(tipDetalle);
                        carCobrosTO.setUsrFechaInserta(Validacion.fechaSistema());
                        CarCobros carCobros = cartera.helper.ConversionesCar.convertirCarCobrosTO_CarCobros(carCobrosTO);
                        ////// CREANDO Lista de CarPagosDetalleCompras
                        List<CarCobrosDetalleVentas> carCobrosDetalleVentas = new java.util.ArrayList(0);
                        for (CarCobrosDetalleVentasTO carCobrosDetalleVentasTO : carCobrosDetalleVentasTOs) {
                            carCobrosDetalleVentasTO.setDetSecuencial(0);
                            carCobrosDetalleVentas.add(cartera.helper.ConversionesCar.convertirCarCobrosDetalleVentasTO_CarCobrosDetalleVentas(
                                    carCobrosDetalleVentasTO));
                        }
                        ////// CREANDO Lista de CarPagosDetalleForma
                        List<CarCobrosDetalleForma> carCobrosDetalleForma = new java.util.ArrayList(0);
                        for (CarCobrosDetalleFormaTO carCobrosDetalleFormaTO : carCobrosDetalleFormaTOs) {
                            carCobrosDetalleForma.add(cartera.helper.ConversionesCar.convertirCarCobrosDetalleFormaTO_CarCobrosDetalleForma(
                                    carCobrosDetalleFormaTO));
                        }
                        ////// CONVIRTIENDO A ENTIDAD EL DETALLE
                        java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList(0);
                        contabilidad.entity.ConDetalle conDetalle = null;
                        /////////////////////////////////////////////////////////////////////////////////
                        int contador = 0;
                        
                        for (int i = 0; i < carCobrosDetalleFormaTOs.size(); i++) {
                            conDetalle = new contabilidad.entity.ConDetalle();
                            conDetalle.setConContable(conContable);
                            conDetalle.setDetSecuencia(i);
                            conDetalle.setSecCodigo(carCobrosDetalleFormaTOs.get(i).getSecCodigo());
                            conDetalle.setPisNumero("");
                            conDetalle.setDetGenerado(true);

                            ctaFormaCobro = operacionesCarDAOLocal.buscarCtaFormaCobro(
                                    carCobrosTO.getUsrEmpresa(),
                                    carCobrosDetalleFormaTOs.get(i).getFpSecuencial());

                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                    carCobrosTO.getUsrEmpresa(),
                                    (ctaFormaCobro == null) ? "" : ctaFormaCobro));//categoria
                            ctaFormaCobro = ctaFormaCobro == null ? "" : ctaFormaCobro;
                            if (ctaFormaCobro.isEmpty()) {
                                mensaje = "FNo se encuentra la cuenta contable forma de cobro...";
                            }

                            conDetalle.setDetDebitoCredito(carCobrosDetalleFormaTOs.get(i).getDetValor().compareTo(cero) > 0 ? 'D' : 'C');
                            conDetalle.setDetDocumento(carCobrosDetalleFormaTOs.get(i).getDetReferencia());
                            conDetalle.setDetValor(carCobrosDetalleFormaTOs.get(i).getDetValor().abs());
                            conDetalle.setDetReferencia("FP");//
                            conDetalle.setDetObservaciones(carCobrosDetalleFormaTOs.get(i).getDetObservaciones().length() > 255 ? carCobrosDetalleFormaTOs.get(i).getDetObservaciones().substring(0, 255) : carCobrosDetalleFormaTOs.get(i).getDetObservaciones());//

                            conDetalle.setDetOrden(contador++);//
                            listaConDetalle.add(contador - 1, conDetalle);
                            conDetalle = null;
                        }
                        for (int i = 0; i < carCobrosDetalleAnticiposTOs.size(); i++) {
                            conDetalle = new contabilidad.entity.ConDetalle();
                            conDetalle.setConContable(conContable);
                            conDetalle.setDetSecuencia(i);
                            conDetalle.setSecCodigo(carCobrosDetalleAnticiposTOs.get(i).getAntSector());
                            conDetalle.setPisNumero("");
                            conDetalle.setDetGenerado(true);
                            ctaClienteAnticipos = anexoDAOLocal.getCuentasContablesTO(carCobrosTO.getUsrEmpresa()).getCtaAnticiposDeClientes();
                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                    carCobrosTO.getUsrEmpresa(),
                                    (ctaClienteAnticipos == null) ? "" : ctaClienteAnticipos));//categoria
                            ctaClienteAnticipos = ctaClienteAnticipos == null ? "" : ctaClienteAnticipos;
                            if (ctaClienteAnticipos.isEmpty()) {
                                mensaje = "FNo se encuentra la cuenta contable del Cliente (Anticipos)...";
                            }

                            conDetalle.setDetDebitoCredito(carCobrosDetalleAnticiposTOs.get(i).getDetValor().compareTo(cero) > 0 ? 'D' : 'C');
                            conDetalle.setDetDocumento(carCobrosDetalleAnticiposTOs.get(i).getAntPeriodo() + " | " + carCobrosDetalleAnticiposTOs.get(i).getAntNumero());
                            conDetalle.setDetValor(carCobrosDetalleAnticiposTOs.get(i).getDetValor().abs());
                            conDetalle.setDetReferencia("ANT-CLI");//

                            conDetalle.setDetOrden(contador++);//
                            listaConDetalle.add(contador - 1, conDetalle);
                            conDetalle = null;
                        }
                        
                        for (int i = 0; i < carCobrosDetalleVentasTOs.size(); i++) {
                            conDetalle = new contabilidad.entity.ConDetalle();
                            conDetalle.setConContable(conContable);
                            conDetalle.setDetSecuencia(i);
                            conDetalle.setSecCodigo(carCobrosDetalleVentasTOs.get(i).getVtaSecCodigo());//pendiente
                            conDetalle.setPisNumero("");
                            conDetalle.setDetGenerado(true);

                            ctaClientePagos = anexoDAOLocal.getCuentasContablesTO(carCobrosTO.getUsrEmpresa()).getCtaCuentasPorCobrar();

                            conDetalle.setConCuentas(operacionesContabilidadDAOLocal.buscarCuentas(
                                    carCobrosTO.getUsrEmpresa(),
                                    (ctaClientePagos == null) ? "" : ctaClientePagos));//categoria
                            ctaClientePagos = ctaClientePagos == null ? "" : ctaClientePagos;
                            if (ctaClientePagos.isEmpty()) {
                                mensaje = "FNo se encuentra la cuenta contable del Cliente (Pagos)...";
                            }

                            conDetalle.setDetDebitoCredito(carCobrosDetalleVentasTOs.get(i).getDetValor().compareTo(cero) > 0 ? 'C' : 'D');
                            conDetalle.setDetDocumento(carCobrosDetalleVentasTOs.get(i).getVtaDocumento());
                            conDetalle.setDetValor(carCobrosDetalleVentasTOs.get(i).getDetValor().abs());
                            conDetalle.setDetReferencia("COB");//

                            conDetalle.setDetOrden(contador++);//
                            listaConDetalle.add(contador - 1, conDetalle);
                            conDetalle = null;
                        }

                        ////// CREANDO Lista de CarCobrosDetalleAnticipos
                        List<cartera.entity.CarCobrosDetalleAnticipos> carCobrosDetalleAnticipos = new java.util.ArrayList(0);
                        for (cartera.TO.CarCobrosDetalleAnticiposTO carCobrosDetalleAnticiposTO : carCobrosDetalleAnticiposTOs) {
                            carCobrosDetalleAnticipos.add(cartera.helper.ConversionesCar.convertirCarCobrosDetalleAnticiposTO_CarCobrosDetalleAnticipos(
                                    carCobrosDetalleAnticiposTO));
                        }

                        comprobar = false;
                        if (mensaje.isEmpty()) {//revisar si estan llenos
                            comprobar = operacionesCarDAOTransaccionLocal.insertarTransaccionCarteraCobros(
                                    carCobros,
                                    carCobrosDetalleVentas,
                                    carCobrosDetalleForma,
                                    carCobrosDetalleAnticipos,
                                    conContable,
                                    listaConDetalle,
                                    sisSuceso,
                                    conNumeracion,
                                    sisInfoTO);
                            //                        comprobar = false;
                        }

                        if (comprobar) {
                            sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(
                                    conContableTO.getEmpCodigo(),
                                    conContable.getConContablePK().getConPeriodo());

                            contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(
                                    conContableTO.getEmpCodigo(),
                                    conContable.getConContablePK().getConTipo());

                            mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                    + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                    + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                    + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>"
                                    + carCobros.getCarCobrosPK().getCobNumero();

                            carContableTO.setContPeriodo(sisPeriodo.getSisPeriodoPK().getPerCodigo());
                            carContableTO.setContTipo(conTipo.getConTipoPK().getTipCodigo());
                            carContableTO.setContNumero(conContable.getConContablePK().getConNumero());
                        }
                    } else {
                        mensaje = "FLos siguientes Documentos han tenido problemas:";
                        carContableTO.setListaFacturaTO(listaFacturaTO);
                    }
                } else {
                    mensaje = "FLos siguientes Documentos se esta pagando mas de lo que se debe:";
                    carContableTO.setListaFacturaTO(lista);
                }
            } else {
                mensaje = "FNo se encuentra ningún periodo para la fecha que ingresó\nNo esta creado o esta cerrado...";
            }
            carContableTO.setMensaje(mensaje);
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar el contable, inténtelo de nuevo...";
            carContableTO.setMensaje(mensaje);
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarCarCobros",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);

        } finally {
            return carContableTO;
        }
    }

    @Override
    public CarListaCobrosClienteTO getCobrosConsultaClienteTO(String empresa, String periodo, String tipo, String numero) throws Exception {
        return operacionesCarDAOLocal.getCobrosConsultaCliente(empresa, periodo, tipo, numero);
    }

    @Override
    public CarListaCobrosClienteTO getCobrosConsultaClienteAnticipoTO(String empresa, String periodo, String tipo, String numero) throws Exception {
        return operacionesCarDAOLocal.getCobrosConsultaClienteAnticipo(empresa, periodo, tipo, numero);
    }

    @Override
    public List<CarListaPagosCobrosTO> getCobrosConsultaDetalleVentasTO(String empresa, String periodo, String numero) throws Exception {
        return operacionesCarDAOLocal.getCobrosConsultaDetalleVentas(empresa, periodo, numero);
    }

    @Override
    public List<CarListaPagosCobrosDetalleFormaTO> getCobrosConsultaDetalleFormaTO(String empresa, String periodo, String numero, boolean hayPostfechados) throws Exception {
        return operacionesCarDAOLocal.getCobrosConsultaDetalleForma(empresa, periodo, numero, hayPostfechados);
    }

    @Override
    public java.util.List<cartera.TO.CarListaPagosCobrosDetalleAnticipoTO> getCobrosConsultaDetalleAnticipo(String empresa, String periodo, String numero  ) throws Exception{
        return operacionesCarDAOLocal.getCobrosConsultaDetalleAnticipo(empresa, periodo, numero);
    }
    @Override
    public List<CarListaPagosCobrosTO> getCarListaCobrosTO(java.lang.String empresa, java.lang.String cliente) throws Exception {
        return operacionesCarDAOLocal.getCarListaCobrosTO(empresa, cliente);
    }

    @Override
    public java.util.List<cartera.TO.CarFunCobrosTO> getCarFunCobrosTO(java.lang.String empresa, 
    String sector,
    java.lang.String desde, java.lang.String hasta, java.lang.String cliente) throws java.lang.Exception {
        return operacionesCarDAOLocal.getCarFunCobrosTO(empresa, sector, desde, hasta, cliente);
    }

    @Override
    public java.util.List<cartera.TO.CarFunCobrosDetalleTO> getCarFunCobrosDetalleTO(java.lang.String empresa, 
    String sector,
    java.lang.String desde, java.lang.String hasta, java.lang.String cliente, java.lang.String formaPago) throws java.lang.Exception {
        return operacionesCarDAOLocal.getCarFunCobrosDetalleTO(empresa, sector, desde, hasta, cliente, formaPago);
    }

    @Override
    public java.util.List<cartera.TO.CarFunCobrosSaldoAnticipoTO> getCarFunCobrosSaldoAnticipoTO(java.lang.String empresa, java.lang.String cliente) throws java.lang.Exception {
        return operacionesCarDAOLocal.getCarFunCobrosSaldoAnticipoTO(empresa, cliente);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMAS">
    @Override
    public String accionCarPagosForma(
            CarPagosCobrosFormaTO carPagosCobrosFormaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        Boolean estadoCtaComprasForma = false;
        Boolean estadoSector = false;
        try {
            ///// BUSCANDO existencia cuentas
            estadoCtaComprasForma = operacionesContabilidadDAOLocal.buscarCuentas(
                    carPagosCobrosFormaTO.getUsrEmpresa(),
                    carPagosCobrosFormaTO.getCtaCodigo()) != null ? true : false;
            ///// BUSCANDO existencia sector
            estadoSector = operacionesProduccionDAOLocal.buscarSector(
                    carPagosCobrosFormaTO.getUsrEmpresa(),
                    carPagosCobrosFormaTO.getSecCodigo()) != null ? true : false;
            if (estadoCtaComprasForma && estadoSector) {//revisar si estan llenos
                ///// CREANDO Suceso
                susClave = carPagosCobrosFormaTO.getFpDetalle();
                if (accion == 'I') {
                    susDetalle = "Se insertó la FormaPago con el detalle " + carPagosCobrosFormaTO.getFpDetalle();
                    susSuceso = "INSERT";
                }
                if (accion == 'M') {
                    susDetalle = "Se modificó la FormaPago con el detalle " + carPagosCobrosFormaTO.getFpDetalle();
                    susSuceso = "UPDATE";
                }
                if (accion == 'E') {
                    susDetalle = "Se eliminó la FormaPago con el detalle " + carPagosCobrosFormaTO.getFpDetalle();
                    susSuceso = "DELETE";
                }
                susTabla = "cartera.car_pagos_forma";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                ///// CREANDO CarPagosForma
                carPagosCobrosFormaTO.setUsrFechaInserta(Validacion.fechaSistema());
                CarPagosForma carPagosForma = cartera.helper.ConversionesCar.convertirCarPagosFormaTO_CarPagosForma(carPagosCobrosFormaTO);
                if (accion == 'E') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesCarDAOLocal.buscarCarPagosForma(
                            carPagosCobrosFormaTO.getFpSecuencial()) != null) {
                        carPagosForma.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesCarDAOTransaccionLocal.accionCarFormaPago(carPagosForma, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra forma de pago...";
                    }
                }
                if (accion == 'M') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesCarDAOLocal.buscarCarPagosForma(
                            carPagosCobrosFormaTO.getFpSecuencial()) != null) {
                        carPagosForma.setUsrFechaInserta(
                                operacionesCarDAOLocal.buscarCarPagosForma(
                                carPagosCobrosFormaTO.getFpSecuencial()).getUsrFechaInserta());
                        comprobar = operacionesCarDAOTransaccionLocal.accionCarFormaPago(carPagosForma, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra forma de pago...";
                    }
                }
                if (accion == 'I') {
                    ////// BUSCANDO existencia PagosForma
                    if (!operacionesCarDAOLocal.buscarCarPagosForma(
                            carPagosCobrosFormaTO.getCtaCodigo(),
                            carPagosCobrosFormaTO.getUsrEmpresa())) {
                        carPagosForma.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesCarDAOTransaccionLocal.accionCarFormaPago(carPagosForma, sisSuceso, accion);
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
                    "accionCarPagosForma",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public String accionCarCobrosForma(
            CarPagosCobrosFormaTO carPagosCobrosFormaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        Boolean estadoCtaComprasForma = false;
        Boolean estadoSector = false;
        try {
            ///// BUSCANDO existencia cuentas
            estadoCtaComprasForma = operacionesContabilidadDAOLocal.buscarCuentas(
                    carPagosCobrosFormaTO.getUsrEmpresa(),
                    carPagosCobrosFormaTO.getCtaCodigo()) != null ? true : false;
            ///// BUSCANDO existencia sector
            estadoSector = operacionesProduccionDAOLocal.buscarSector(
                    carPagosCobrosFormaTO.getUsrEmpresa(),
                    carPagosCobrosFormaTO.getSecCodigo()) != null ? true : false;
            if (estadoCtaComprasForma && estadoSector) {//revisar si estan llenos
                ///// CREANDO Suceso
                susClave = carPagosCobrosFormaTO.getFpDetalle();
                if (accion == 'I') {
                    susDetalle = "Se insertó la FormaPago con el detalle " + carPagosCobrosFormaTO.getFpDetalle();
                    susSuceso = "INSERT";
                }
                if (accion == 'M') {
                    susDetalle = "Se modificó la FormaPago con el detalle " + carPagosCobrosFormaTO.getFpDetalle();
                    susSuceso = "UPDATE";
                }
                if (accion == 'E') {
                    susDetalle = "Se eliminó la FormaPago con el detalle " + carPagosCobrosFormaTO.getFpDetalle();
                    susSuceso = "DELETE";
                }
                susTabla = "cartera.car_cobros_forma";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                ///// CREANDO CarPagosForma
                carPagosCobrosFormaTO.setUsrFechaInserta(Validacion.fechaSistema());
                CarCobrosForma carCobrosForma = cartera.helper.ConversionesCar.convertirCarCobrosFormaTO_CarCobrosForma(carPagosCobrosFormaTO);
                if (accion == 'E') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesCarDAOLocal.buscarCarCobrosForma(
                            carPagosCobrosFormaTO.getFpSecuencial()) != null) {
                        carCobrosForma.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesCarDAOTransaccionLocal.accionCarFormaCobro(carCobrosForma, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra forma de pago...";
                    }
                }
                if (accion == 'M') {
                    ////// BUSCANDO existencia PagosForma
                    if (operacionesCarDAOLocal.buscarCarCobrosForma(
                            carPagosCobrosFormaTO.getFpSecuencial()) != null) {
                        carCobrosForma.setUsrFechaInserta(
                                operacionesCarDAOLocal.buscarCarCobrosForma(
                                carPagosCobrosFormaTO.getFpSecuencial()).getUsrFechaInserta());
                        comprobar = operacionesCarDAOTransaccionLocal.accionCarFormaCobro(carCobrosForma, sisSuceso, accion);
                    } else {
                        mensaje = "FNo se encuentra la compra forma de pago...";
                    }
                }
                if (accion == 'I') {
                    ////// BUSCANDO existencia PagosForma
                    if (!operacionesCarDAOLocal.buscarCarCobrosForma(
                            carPagosCobrosFormaTO.getCtaCodigo(),
                            carPagosCobrosFormaTO.getUsrEmpresa())) {
                        carCobrosForma.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
                        comprobar = operacionesCarDAOTransaccionLocal.accionCarFormaCobro(carCobrosForma, sisSuceso, accion);
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
                    "accionCarCobrosForma",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public List<CarComboPagosCobrosFormaTO> getCarComboPagosCobrosFormaTO(String empresa, char accion) throws Exception {
        return operacionesCarDAOLocal.getCarComboPagosCobrosForma(empresa, accion);
    }

    @Override
    public List<CarListaPagosCobrosFormaTO> getCarListaPagosCobrosFormaTO(String empresa, char accion) throws Exception {
        return operacionesCarDAOLocal.getCarListaPagosCobrosForma(empresa, accion);
    }
    // </editor-fold>

    @Override
    public cartera.TO.CarPagosCobrosAnticipoTO getCarPagosCobrosAnticipoTO(String empresa, String periodo, String tipo, String numero, char accion) throws Exception {
        return operacionesCarDAOLocal.getCarPagosCobrosAnticipoTO(empresa, periodo, tipo, numero, accion);
    }

    @Override
    public java.util.List<cartera.TO.CarListaMayorAuxiliarClienteProveedorTO> getCarListaMayorAuxiliarClienteProveedorTO(
            java.lang.String empresa, String sector, java.lang.String proveedor, java.lang.String desde, java.lang.String hasta, char accion) throws java.lang.Exception {
        return operacionesCarDAOLocal.getCarListaMayorAuxiliarClienteProveedorTO(empresa, sector, proveedor, desde, hasta, accion);
    }

    @Override
    public List<CarCuentasPorPagarCobrarDetalladoTO> getCarListaCuentasPorPagarDetalladoTO(String empresa, String sector, 
    String proveedor,
    String hasta) throws Exception {
        return operacionesCarDAOLocal.getCarListaCuentasPorPagarDetalladoTO(empresa, sector, proveedor, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarGeneralTO> getCarListaCuentasPorPagarGeneralTO(String empresa, String sector, String hasta) throws Exception {
        return operacionesCarDAOLocal.getCarListaCuentasPorPagarGeneralTO(empresa, sector, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarAnticiposTO> getCarListaCuentasPorPagarAnticiposTO(String empresa, String sector, String hasta) throws Exception {
        return operacionesCarDAOLocal.getCarListaCuentasPorPagarAnticiposTO(empresa, sector, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarAnticiposTO> getCarListaCuentasPorCobrarAnticiposTO(String empresa, String sector, String hasta) throws Exception {
        return operacionesCarDAOLocal.getCarListaCuentasPorCobrarAnticiposTO(empresa, sector, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarDetalladoTO> getCarListaCuentasPorCobrarDetalladoTO(String empresa,
            String sector,
            String cliente,
            String desde,
            String hasta,
            boolean ichfa) throws Exception {
        return operacionesCarDAOLocal.getCarListaCuentasPorCobrarDetalladoTO(empresa, sector, cliente,  desde, hasta, ichfa);
    }

    @Override
    public java.util.List<cartera.TO.CarFunCuentasPorCobrarListadoVentasTO> getCarFunCuentasPorCobrarListadoVentasTO(String empresa, String sector, String cliente, String desde, String hasta) throws Exception {
        return operacionesCarDAOLocal.getCarFunCuentasPorCobrarListadoVentasTO(empresa, sector, cliente, desde, hasta);
    }

    @Override
    public java.util.List<cartera.TO.CarFunCuentasPorPagarListadoComprasTO> getCarFunCuentasPorPagarListadoComprasTO(String empresa, String sector, String proveedor, String desde, String hasta) throws Exception {
        return operacionesCarDAOLocal.getCarFunCuentasPorPagarListadoComprasTO(empresa, sector, proveedor, desde, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarGeneralTO> getCarListaCuentasPorCobrarGeneralTO(String empresa, String sector, String hasta) throws Exception {
        return operacionesCarDAOLocal.getCarListaCuentasPorCobrarGeneralTO(empresa, sector, hasta);
    }

    @Override
    public java.lang.String anularReversarCarConContable(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String tipo,
            java.lang.String numero,
            java.lang.String usuario,
            java.lang.String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesContabilidadBusinessLocal.anularReversarConContable(empresa, periodo, tipo, numero, usuario, accion, sisInfoTO);
    }

    @Override
    public String insertarAnticiposPago(
            cartera.TO.CarPagosAnticipoTO carPagosAnticipoTO,
            String observaciones,
            String nombreProveedor,
            String fecha,
            String sectorProveedor,
            String documento,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        Boolean periodoCerrado = false;
        try {
            java.util.List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList();
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(carPagosAnticipoTO.getAntEmpresa());
            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (validaciones.Validacion.fecha(fecha, "yyyy-MM-dd").getTime()
                        >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && validaciones.Validacion.fecha(fecha, "yyyy-MM-dd").getTime()
                        <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                    comprobar = true;
                    carPagosAnticipoTO.setAntPeriodo(sisListaPeriodoTO.getPerCodigo());
                    periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                }
            }
            if (comprobar) {
                if (!periodoCerrado) {
                    if (operacionesProduccionDAOLocal.buscarSector(carPagosAnticipoTO.getAntEmpresa(), sectorProveedor) != null) {
                        //CREA EL SUSCESO EL DETALLE SE COMPLETA insertarTransaccionContable
                        susSuceso = "INSERT";
                        susTabla = "cartera.car_anticipos_pagos";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        carPagosAnticipoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());

                        if (operacionesContabilidadDAOLocal.buscarTipoContable(carPagosAnticipoTO.getAntEmpresa(), carPagosAnticipoTO.getAntTipo())) {
                            inventario.entity.InvProveedor invProveedor = operacionesInventarioDAOLocal.buscarInvProveedor(carPagosAnticipoTO.getProvEmpresa(), carPagosAnticipoTO.getProvCodigo());
                            if (invProveedor != null) {
                                cartera.entity.CarPagosForma carPagosForma = operacionesCarDAOLocal.buscarCarPagosForma(carPagosAnticipoTO.getFpSecuencial());
                                if (carPagosForma != null) {
                                    contabilidad.entity.ConCuentas conCuentaFormaPago = operacionesContabilidadDAOLocal.buscarCuentas2(carPagosForma.getCtaEmpresa(), carPagosForma.getCtaCodigo());
                                    contabilidad.entity.ConCuentas conCuentaAnticiposProveedores = operacionesContabilidadDAOLocal.buscarCuentas(invProveedor.getInvProveedorPK().getProvEmpresa(), anexoDAOLocal.getCuentasContablesTO(invProveedor.getInvProveedorPK().getProvEmpresa()).getCtaAnticiposAProveedores());// invProveedor.getInvProveedorCategoria().getCtaAntipos()
                                    if (conCuentaFormaPago != null) {
                                        if (conCuentaAnticiposProveedores != null) {
                                            contabilidad.entity.ConContable conContable = new contabilidad.entity.ConContable();
                                            conContable.setConContablePK(new contabilidad.entity.ConContablePK(carPagosAnticipoTO.getAntEmpresa(),
                                                    carPagosAnticipoTO.getAntPeriodo(), carPagosAnticipoTO.getAntTipo(), carPagosAnticipoTO.getAntNumero()));
                                            conContable.setConAnulado(false);
                                            conContable.setConBloqueado(false);
                                            conContable.setConConcepto(nombreProveedor);
                                            conContable.setConDetalle("CONTABLE GENERADO POR EL SISTEMA");
                                            conContable.setConObservaciones(observaciones);
                                            conContable.setConFecha(validaciones.Validacion.fecha(fecha, "yyyy-MM-dd"));
                                            conContable.setConGenerado(true);
                                            conContable.setConPendiente(false);
                                            conContable.setUsrCodigo(carPagosAnticipoTO.getUsrCodigo());
                                            conContable.setUsrEmpresa(carPagosAnticipoTO.getUsrEmpresa());
                                            conContable.setUsrFechaInserta(validaciones.Validacion.fecha(carPagosAnticipoTO.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));

                                            contabilidad.entity.ConDetalle conDetalle = null;
                                            java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList();

                                            conDetalle = new contabilidad.entity.ConDetalle();
                                            conDetalle.setConContable(conContable);
                                            conDetalle.setConCuentas(conCuentaAnticiposProveedores);
                                            conDetalle.setDetSecuencia(0);
                                            conDetalle.setSecCodigo(sectorProveedor);
                                            conDetalle.setPisNumero("");
                                            conDetalle.setDetDocumento("");
                                            conDetalle.setDetDebitoCredito('D');
                                            conDetalle.setDetValor(carPagosAnticipoTO.getAntValor());
                                            conDetalle.setDetGenerado(true);
                                            conDetalle.setDetReferencia("ANT-PRO");
                                            conDetalle.setDetObservaciones("");
                                            conDetalle.setDetOrden(1);
                                            listaConDetalle.add(conDetalle);

                                            conDetalle = new contabilidad.entity.ConDetalle();
                                            conDetalle.setConContable(conContable);
                                            conDetalle.setConCuentas(conCuentaFormaPago);
                                            conDetalle.setDetSecuencia(0);
                                            conDetalle.setSecCodigo(carPagosForma.getSecCodigo());
                                            conDetalle.setPisNumero("");
                                            conDetalle.setDetDocumento(documento);
                                            conDetalle.setDetDebitoCredito('C');
                                            conDetalle.setDetValor(carPagosAnticipoTO.getAntValor());
                                            conDetalle.setDetGenerado(true);
                                            conDetalle.setDetReferencia("FP");
                                            conDetalle.setDetObservaciones("");
                                            conDetalle.setDetOrden(2);
                                            listaConDetalle.add(conDetalle);
                                            contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                                    carPagosAnticipoTO.getAntEmpresa(), carPagosAnticipoTO.getAntPeriodo(),
                                                    carPagosAnticipoTO.getAntTipo()));
                                            carPagosAnticipoTO.setAntPagado(false);
                                            carPagosAnticipoTO.setSecEmpresa(carPagosAnticipoTO.getAntEmpresa());
                                            carPagosAnticipoTO.setSecCodigo(sectorProveedor);
                                            cartera.entity.CarPagosAnticipos carPagosAnticipos = cartera.helper.ConversionesCar.convertirCarPagosAnticiposTO_CarPagosAnticipos(carPagosAnticipoTO);
                                            carPagosAnticipos.setFpSecuencial(carPagosForma);
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
                                                    carPagosAnticipos,
                                                    null,
                                                    null,
                                                    sisInfoTO);
                                            if (comprobar) {
                                                sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(carPagosAnticipoTO.getAntEmpresa(), conContable.getConContablePK().getConPeriodo());

                                                contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(carPagosAnticipoTO.getAntEmpresa(), conContable.getConContablePK().getConTipo());
                                                mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                                        + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                        + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                                        + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>"
                                                        + conContable.getConContablePK().getConPeriodo() + ", " + conContable.getConContablePK().getConNumero();
                                            } else {
                                                mensaje = "F<html>Hubo un error al guardar el Anticipo de Pago.\nCódigo repetido: " + carPagosAnticipoTO.getAntNumero() + "\nIntentelo de nuevo...</html>";
                                            }
                                        } else {
                                            mensaje = "F<html>La CUENTA CONTABLE anticipo del PROVEEDOR ya\nno se encuentra disponible "
                                                    + "o no ha sido ingresada.\n</html>";
                                        }
                                    } else {
                                        mensaje = "F<html>La CUENTA CONTABLE de la FORMA DE PAGO ya\nno se encuentra disponible o no ha sido ingresada.\nCódigo contable: " + carPagosForma.getCtaCodigo() + "</html>";
                                    }
                                } else {
                                    mensaje = "F<html>La FORMA DE PAGO que ingresó ya no se encuentra disponible.</html>";
                                }
                            } else {
                                mensaje = "F<html>El PROVEEDOR que ingresó ya no se encuentra disponible.</html>";
                            }
                        } else {
                            mensaje = "F<html>El TIPO DE CONTABLE C-ACLI no ha sido creado aún.\nContacte con el administrador.</html>";
                        }
                    } else {
                        mensaje = "F<html>El CP " + sectorProveedor + "ya no esta disponible.\nContacte con el administrador.</html>";
                    }

                } else {
                    mensaje = "F<html>El periodo de la fecha que ingresó está cerrado.</html>";
                }
            } else {
                mensaje = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar el Anticipo de Pago, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarAnticiposPago",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public String insertarAnticiposCobro(
            cartera.TO.CarCobrosAnticipoTO carCobrosAnticipoTO,
            String observaciones,
            String nombreCliente,
            String fecha,
            String sectorCliente,
            String documento,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        Boolean periodoCerrado = false;
        try {
            java.util.List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = new java.util.ArrayList();
            listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(carCobrosAnticipoTO.getAntEmpresa());
            for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
                if (validaciones.Validacion.fecha(fecha, "yyyy-MM-dd").getTime()
                        >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                        && validaciones.Validacion.fecha(fecha, "yyyy-MM-dd").getTime()
                        <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                    comprobar = true;
                    carCobrosAnticipoTO.setAntPeriodo(sisListaPeriodoTO.getPerCodigo());
                    periodoCerrado = sisListaPeriodoTO.getPerCerrado();
                }
            }

            if (comprobar) {
                if (!periodoCerrado) {
                    if (operacionesProduccionDAOLocal.buscarSector(carCobrosAnticipoTO.getAntEmpresa(), sectorCliente) != null) {
                        /// SE CREA EL SUCESO
                        susSuceso = "INSERT";
                        susTabla = "cartera.car_anticipos_cobros";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        carCobrosAnticipoTO.setUsrFechaInserta(validaciones.Validacion.fechaSistema());

                        if (operacionesContabilidadDAOLocal.buscarTipoContable(carCobrosAnticipoTO.getAntEmpresa(), carCobrosAnticipoTO.getAntTipo())) {
                            inventario.entity.InvCliente invCliente = operacionesInventarioDAOLocal.buscarInvCliente(carCobrosAnticipoTO.getCliEmpresa(), carCobrosAnticipoTO.getCliCodigo());
                            if (invCliente != null) {
                                cartera.entity.CarCobrosForma carCobrosForma = operacionesCarDAOLocal.buscarCarCobrosForma(carCobrosAnticipoTO.getFpSecuencial());
                                if (carCobrosForma != null) {
                                    contabilidad.entity.ConCuentas conCuentaAnticiposClientes = operacionesContabilidadDAOLocal.buscarCuentas(invCliente.getInvClientePK().getCliEmpresa(), anexoDAOLocal.getCuentasContablesTO(invCliente.getInvClientePK().getCliEmpresa()).getCtaAnticiposDeClientes());// invCliente.getInvClienteCategoria().getCtaAntipos()
                                    contabilidad.entity.ConCuentas conCuentaFormaPago = operacionesContabilidadDAOLocal.buscarCuentas2(carCobrosForma.getCtaEmpresa(), carCobrosForma.getCtaCodigo());
                                    if (conCuentaFormaPago != null) {
                                        if (conCuentaAnticiposClientes != null) {
                                            contabilidad.entity.ConContable conContable = new contabilidad.entity.ConContable();
                                            conContable.setConContablePK(new contabilidad.entity.ConContablePK(carCobrosAnticipoTO.getAntEmpresa(),
                                                    carCobrosAnticipoTO.getAntPeriodo(), carCobrosAnticipoTO.getAntTipo(), carCobrosAnticipoTO.getAntNumero()));
                                            conContable.setConAnulado(false);
                                            conContable.setConBloqueado(false);
                                            conContable.setConConcepto(nombreCliente);
                                            conContable.setConDetalle("CONTABLE GENERADO POR EL SISTEMA");
                                            conContable.setConObservaciones(observaciones);
                                            conContable.setConFecha(validaciones.Validacion.fecha(fecha, "yyyy-MM-dd"));
                                            conContable.setConGenerado(true);
                                            conContable.setConPendiente(false);
                                            conContable.setUsrCodigo(carCobrosAnticipoTO.getUsrCodigo());
                                            conContable.setUsrEmpresa(carCobrosAnticipoTO.getUsrEmpresa());
                                            conContable.setUsrFechaInserta(validaciones.Validacion.fecha(carCobrosAnticipoTO.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));

                                            contabilidad.entity.ConDetalle conDetalle = null;
                                            java.util.List<contabilidad.entity.ConDetalle> listaConDetalle = new java.util.ArrayList();

                                            conDetalle = new contabilidad.entity.ConDetalle();
                                            conDetalle.setConContable(conContable);
                                            conDetalle.setConCuentas(conCuentaAnticiposClientes);
                                            conDetalle.setDetSecuencia(0);
                                            conDetalle.setSecCodigo(sectorCliente);
                                            conDetalle.setPisNumero("");
                                            conDetalle.setDetDocumento("");
                                            conDetalle.setDetDebitoCredito('C');
                                            conDetalle.setDetValor(carCobrosAnticipoTO.getAntValor());
                                            conDetalle.setDetGenerado(true);
                                            conDetalle.setDetReferencia("ANT-CLI");
                                            conDetalle.setDetObservaciones("");
                                            conDetalle.setDetOrden(2);
                                            listaConDetalle.add(conDetalle);

                                            conDetalle = new contabilidad.entity.ConDetalle();
                                            conDetalle.setConContable(conContable);
                                            conDetalle.setConCuentas(conCuentaFormaPago);
                                            conDetalle.setDetSecuencia(0);
                                            conDetalle.setSecCodigo(carCobrosForma.getSecCodigo());
                                            conDetalle.setPisNumero("");
                                            conDetalle.setDetDocumento(documento);
                                            conDetalle.setDetDebitoCredito('D');
                                            conDetalle.setDetValor(carCobrosAnticipoTO.getAntValor());
                                            conDetalle.setDetGenerado(true);
                                            conDetalle.setDetReferencia("FP");
                                            conDetalle.setDetObservaciones("");
                                            conDetalle.setDetOrden(1);
                                            listaConDetalle.add(conDetalle);

                                            contabilidad.entity.ConNumeracion conNumeracion = new contabilidad.entity.ConNumeracion(new contabilidad.entity.ConNumeracionPK(
                                                    carCobrosAnticipoTO.getAntEmpresa(), carCobrosAnticipoTO.getAntPeriodo(),
                                                    carCobrosAnticipoTO.getAntTipo()));

                                            carCobrosAnticipoTO.setAntCobrado(false);
                                            carCobrosAnticipoTO.setSecEmpresa(carCobrosAnticipoTO.getAntEmpresa());
                                            carCobrosAnticipoTO.setSecCodigo(sectorCliente);

                                            cartera.entity.CarCobrosAnticipos carCobrosAnticipos = cartera.helper.ConversionesCar.convertirCarCobrosAnticiposTO_CarCobrosAnticipos(carCobrosAnticipoTO);
                                            carCobrosAnticipos.setFpSecuencial(carCobrosForma);

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
                                                    carCobrosAnticipos,
                                                    null,
                                                    sisInfoTO);
                                            if (comprobar) {
                                                sistemaWeb.entity.SisPeriodo sisPeriodo = operacionesSistemaDAOLocal.buscarPeriodo(carCobrosAnticipoTO.getAntEmpresa(), conContable.getConContablePK().getConPeriodo());

                                                contabilidad.entity.ConTipo conTipo = operacionesContabilidadDAOLocal.buscarTipo(carCobrosAnticipoTO.getAntEmpresa(), conContable.getConContablePK().getConTipo());

                                                mensaje = "T<html>Se ingresó el contable con la siguiente información:<br><br>"
                                                        + "Periodo: <font size = 5>" + sisPeriodo.getPerDetalle()
                                                        + "</font>.<br> Tipo: <font size = 5>" + conTipo.getTipDetalle()
                                                        + "</font>.<br> Número: <font size = 5>" + conContable.getConContablePK().getConNumero() + "</font>.</html>"
                                                        + conContable.getConContablePK().getConPeriodo() + ", " + conContable.getConContablePK().getConNumero();

                                                //                                            mensaje = "F<html>Hubo un error al guardar el Anticipo de Pago.\nCódigo repetido: " + carPagosAnticipoTO.getAntNumero() + "\nIntentelo de nuevo...</html>";
                                            } else {
                                                mensaje = "F<html>Hubo un error al guardar el Anticipo de Cobro.\nCódigo repetido: " + carCobrosAnticipoTO.getAntNumero() + "\nIntentelo de nuevo...</html>";
                                            }
                                            //                                        if (operacionesCarDAOLocal.getCarCobrosAnticipos(carPagosAnticipoTO.getAntEmpresa(), 
                                            //                                                carPagosAnticipoTO.getAntPeriodo(), carPagosAnticipoTO.getAntTipo(), carPagosAnticipoTO.getAntNumero()) == null){
                                            //                                        } else {
                                            //                                            mensaje = "F<html>Hubo un error al guardar el Anticipo de Pago.\nCódigo repetido: " + carPagosAnticipoTO.getAntNumero() + "\nIntentelo de nuevo...</html>";
                                            //                                        }
                                        } else {
                                            mensaje = "F<html>La CUENTA CONTABLE anticipo del CLIENTE ya\nno se encuentra disponible "
                                                    + "o no ha sido ingresada.\n</html>";
                                        }
                                    } else {
                                        mensaje = "F<html>La CUENTA CONTABLE de la FORMA DE COBRO ya\nno se encuentra disponible o no ha sido ingresada.\nCódigo contable: " + carCobrosForma.getCtaCodigo() + "</html>";
                                    }
                                } else {
                                    mensaje = "F<html>La FORMA DE COBRO que ingresó ya no se encuentra disponible.</html>";
                                }
                            } else {
                                mensaje = "F<html>El CLIENTE que ingresó ya no se encuentra disponible.</html>";
                            }
                        } else {
                            mensaje = "F<html>El TIPO DE CONTABLE C-ACLI no ha sido creado aún.\nContacte con el administrador.</html>";
                        }
                    } else {
                        mensaje = "F<html>El CP " + sectorCliente + "ya no esta disponible.\nContacte con el administrador.</html>";
                    }
                } else {
                    mensaje = "F<html>El periodo de la fecha que ingresó está cerrado.</html>";
                }
            } else {
                mensaje = "F<html>No se encuentra ningún periodo para la fecha que ingresó...</html>";
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar el Anticipo de Cobro, inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarAnticiposPago",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    @Override
    public List<CarCuentasPorPagarCobrarSaldoAnticiposTO> getCarListaCuentasPorPagarSaldoAnticiposTO(String empresa, String sector,  String proveedorCodigo,String hasta) throws Exception {
        return operacionesCarDAOLocal.getCarListaCuentasPorPagarSaldoAnticiposTO(empresa, sector, proveedorCodigo, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarSaldoAnticiposTO> getCarListaCuentasPorCobrarSaldoAnticiposTO(String empresa, String sector, String clienteCodigo, String hasta) throws Exception {
        return operacionesCarDAOLocal.getCarListaCuentasPorCobrarSaldoAnticiposTO(empresa, sector,clienteCodigo, hasta);
    }

    public List<CarListaPagosCobrosDetalleAnticipoTO> getPagosConsultaDetalleAnticipo(String empresa, String periodo, String numero) throws Exception {
        return operacionesCarDAOLocal.getPagosConsultaDetalleAnticipo(empresa, periodo, numero);
    }
}
