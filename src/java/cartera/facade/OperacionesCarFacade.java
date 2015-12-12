/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.facade;

import cartera.TO.*;
import cartera.business.OperacionesCarBusinessLocal;
import cartera.reporte.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesCarFacade implements OperacionesCarFacadeRemote {

    // Add business logic below. (Right-c|lick in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    OperacionesCarBusinessLocal operacionesCarBusinessLocal;

    // <editor-fold defaultstate="collapsed" desc="PAGOS">
    public JasperPrint generarReporteCuentasPorCobrarDetallado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorCobrarDetallado> reporteCuentasPorCobrarDetallado) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCuentasPorCobrarDetallado(sisUsuarioEmpresaTO, reporteCuentasPorCobrarDetallado);
    }

    public JasperPrint generarReporteCuentasPorPagarDetallado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarDetallado> reporteCuentasPorPagarDetallado) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCuentasPorPagarDetallado(sisUsuarioEmpresaTO, reporteCuentasPorPagarDetallado);
    }

    public JasperPrint generarReporteCuentasPorCobrarGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorCobrarGeneral> reporteCuentasPorCobrarGeneral) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCuentasPorCobrarGeneral(sisUsuarioEmpresaTO, reporteCuentasPorCobrarGeneral);
    }

    public JasperPrint generarReporteCarFunCuentasPorCobrarListadoVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCarFunCuentasPorCobrarListadoVentas> reporteCarFunCuentasPorCobrarListadoVentas) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCarFunCuentasPorCobrarListadoVentas(sisUsuarioEmpresaTO, reporteCarFunCuentasPorCobrarListadoVentas);
    }

    public JasperPrint generarReporteCarFunCuentasPorPagarListadoCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCarFunCuentasPorPagarListadoCompras> reporteCarFunCuentasPorPagarListadoCompras) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCarFunCuentasPorPagarListadoCompras(sisUsuarioEmpresaTO, reporteCarFunCuentasPorPagarListadoCompras);
    }

    public JasperPrint generarReporteCuentasPorPagarGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarGeneral> reporteCuentasPorPagarGeneral) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCuentasPorPagarGeneral(sisUsuarioEmpresaTO, reporteCuentasPorPagarGeneral);
    }

    public JasperPrint generarReporteCuentasPorPagarAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarAnticipos> reporteCuentasPorPagarAnticipos) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCuentasPorPagarAnticipos(sisUsuarioEmpresaTO, reporteCuentasPorPagarAnticipos);
    }

    public JasperPrint generarReporteCuentasPorPagarSaldoAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarCobrarSaldoAnticipos> reporteCuentasPorPagarSaldoAnticipos) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCuentasPorPagarSaldoAnticipos(sisUsuarioEmpresaTO, reporteCuentasPorPagarSaldoAnticipos);
    }

    public JasperPrint generarReporteCuentasPorCobrarSaldoAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarCobrarSaldoAnticipos> reporteCuentasPorPagarSaldoAnticipos) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCuentasPorCobrarSaldoAnticipos(sisUsuarioEmpresaTO, reporteCuentasPorPagarSaldoAnticipos);
    }

    public JasperPrint generarReporteCuentasPorCobrarAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarAnticipos> reporteCuentasPorPagarAnticipos) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCuentasPorCobrarAnticipos(sisUsuarioEmpresaTO, reporteCuentasPorPagarAnticipos);
    }

    public JasperPrint generarReporteCobros(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCobros> reporteCobros) throws Exception {
        return operacionesCarBusinessLocal.generarReporteCobros(sisUsuarioEmpresaTO, reporteCobros);
    }

    public JasperPrint generarReportePagos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReportePagos> reportePagos) throws Exception {
        return operacionesCarBusinessLocal.generarReportePagos(sisUsuarioEmpresaTO, reportePagos);
    }

    public JasperPrint generarReporteMayorAuxiliarProveedorCliente(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteMayorAuxiliarProveedorCliente> reporteMayorAuxiliarProveedorCliente) throws Exception {
        return operacionesCarBusinessLocal.generarReporteMayorAuxiliarProveedorCliente(sisUsuarioEmpresaTO, reporteMayorAuxiliarProveedorCliente);
    }

    public JasperPrint generarReporteListadoPagos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteListadoPagos> reporteListadoPagos) throws Exception {
        return operacionesCarBusinessLocal.generarReporteListadoPagos(sisUsuarioEmpresaTO, reporteListadoPagos);
    }

    public JasperPrint generarReporteListadoCobros(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteListadoCobros> reporteListadoCobros) throws Exception {
        return operacionesCarBusinessLocal.generarReporteListadoCobros(sisUsuarioEmpresaTO, reporteListadoCobros);
    }

    @Override
    public CarContableTO insertarCarPagos(
            CarPagosTO carPagosTO,
            List<CarPagosDetalleComprasTO> carPagosDetalleComprasTOs,
            java.util.List<cartera.TO.CarPagosDetalleAnticiposTO> carPagosDetalleAnticiposTOs,
            List<CarPagosDetalleFormaTO> carPagosDetalleFormaTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesCarBusinessLocal.insertarCarPagos(carPagosTO, carPagosDetalleComprasTOs, carPagosDetalleAnticiposTOs, carPagosDetalleFormaTOs, sisInfoTO);
    }

    @Override
    public CarListaPagosProveedorTO getPagosConsultaProveedorTO(
            String empresa,
            String periodo,
            String tipo,
            String numero) throws Exception {
        return operacionesCarBusinessLocal.getPagosConsultaProveedorTO(empresa, periodo, tipo, numero);
    }

    @Override
    public CarListaPagosProveedorTO getPagosConsultaProveedorAnticipoTO(
            String empresa,
            String periodo,
            String tipo,
            String numero) throws Exception {
        return operacionesCarBusinessLocal.getPagosConsultaProveedorAnticipoTO(empresa, periodo, tipo, numero);
    }

    @Override
    public List<CarListaPagosCobrosTO> getPagosConsultaDetalleComprasTO(
            String empresa,
            String periodo,
            String numero) throws Exception {
        return operacionesCarBusinessLocal.getPagosConsultaDetalleComprasTO(empresa, periodo, numero);
    }

    @Override
    public List<CarListaPagosCobrosDetalleFormaTO> getPagosConsultaDetalleFormaTO(
            String empresa,
            String periodo,
            String numero) throws Exception {
        return operacionesCarBusinessLocal.getPagosConsultaDetalleFormaTO(empresa, periodo, numero);
    }

    @Override
    public List<CarListaPagosCobrosTO> getCarListaPagosTO(
            java.lang.String empresa,
            java.lang.String proveedor) throws Exception {
        return operacionesCarBusinessLocal.getCarListaPagosTO(empresa, proveedor);
    }

    @Override
    public java.util.List<cartera.TO.CarFunPagosTO> getCarFunPagosTO(
            java.lang.String empresa,
            String sector,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String proveedor) throws java.lang.Exception {
        return operacionesCarBusinessLocal.getCarFunPagosTO(empresa, sector, desde, hasta, proveedor);
    }

    @Override
    public java.util.List<cartera.TO.CarFunPagosPruebaTO> getCarFunPagosPruebaTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String proveedor) throws java.lang.Exception {
        return operacionesCarBusinessLocal.getCarFunPagosPruebaTO(empresa, desde, hasta, proveedor);
    }

    @Override
    public List<CarFunPagosDetalleTO> getCarFunPagosDetalleTO(
            String empresa,
            String sector,
            String desde,
            String hasta,
            String proveedor,
            String formaPago) throws Exception {
        return operacionesCarBusinessLocal.getCarFunPagosDetalleTO(empresa, sector, desde, hasta, proveedor, formaPago);
    }

    @Override
    public java.util.List<cartera.TO.CarFunPagosSaldoAnticipoTO> getCarFunPagosSaldoAnticipoTO(
            java.lang.String empresa,
            java.lang.String proveedor) throws java.lang.Exception {
        return operacionesCarBusinessLocal.getCarFunPagosSaldoAnticipoTO(empresa, proveedor);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="COBROS">

    @Override
    public cartera.TO.CarContableTO insertarCarCobros(
            cartera.TO.CarCobrosTO carCobrosTO,
            java.util.List<cartera.TO.CarCobrosDetalleVentasTO> carCobrosDetalleVentasTOs,
            java.util.List<cartera.TO.CarCobrosDetalleAnticiposTO> carCobrosDetalleAnticiposTOs,
            java.util.List<cartera.TO.CarCobrosDetalleFormaTO> carCobrosDetalleFormaTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesCarBusinessLocal.insertarCarCobros(carCobrosTO, carCobrosDetalleVentasTOs, carCobrosDetalleAnticiposTOs, carCobrosDetalleFormaTOs, sisInfoTO);
    }

    @Override
    public CarListaCobrosClienteTO getCobrosConsultaClienteTO(
            String empresa,
            String periodo,
            String tipo,
            String numero) throws Exception {
        return operacionesCarBusinessLocal.getCobrosConsultaClienteTO(empresa, periodo, tipo, numero);
    }

    @Override
    public CarListaCobrosClienteTO getCobrosConsultaClienteAnticipoTO(
            String empresa,
            String periodo,
            String tipo,
            String numero) throws Exception {
        return operacionesCarBusinessLocal.getCobrosConsultaClienteAnticipoTO(empresa, periodo, tipo, numero);
    }

    @Override
    public List<CarListaPagosCobrosTO> getCobrosConsultaDetalleVentasTO(
            String empresa,
            String periodo,
            String numero) throws Exception {
        return operacionesCarBusinessLocal.getCobrosConsultaDetalleVentasTO(empresa, periodo, numero);
    }

    @Override
    public List<CarListaPagosCobrosDetalleFormaTO> getCobrosConsultaDetalleFormaTO(
            String empresa,
            String periodo,
            String numero,
            boolean hayPostfechados) throws Exception {
        return operacionesCarBusinessLocal.getCobrosConsultaDetalleFormaTO(empresa, periodo, numero, hayPostfechados);
    }

    @Override
    public java.util.List<cartera.TO.CarListaPagosCobrosDetalleAnticipoTO> getCobrosConsultaDetalleAnticipo(
            String empresa, 
            String periodo, 
            String numero) throws Exception{
        return operacionesCarBusinessLocal.getCobrosConsultaDetalleAnticipo(empresa, periodo, numero);
    }
    @Override
    public List<CarListaPagosCobrosTO> getCarListaCobrosTO(
            java.lang.String empresa,
            java.lang.String proveedor) throws Exception {
        return operacionesCarBusinessLocal.getCarListaCobrosTO(empresa, proveedor);
    }

    @Override
    public java.util.List<cartera.TO.CarFunCobrosTO> getCarFunCobrosTO(
            java.lang.String empresa,
            String sector,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String cliente) throws java.lang.Exception {
        return operacionesCarBusinessLocal.getCarFunCobrosTO(empresa, sector, desde, hasta, cliente);
    }

    @Override
    public java.util.List<cartera.TO.CarFunCobrosDetalleTO> getCarFunCobrosDetalleTO(
            java.lang.String empresa,
            String sector,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String cliente,
            java.lang.String formaPago) throws java.lang.Exception {
        return operacionesCarBusinessLocal.getCarFunCobrosDetalleTO(empresa, sector, desde, hasta, cliente, formaPago);
    }

    @Override
    public java.util.List<cartera.TO.CarFunCobrosSaldoAnticipoTO> getCarFunCobrosSaldoAnticipoTO(
            java.lang.String empresa,
            java.lang.String cliente) throws java.lang.Exception {
        return operacionesCarBusinessLocal.getCarFunCobrosSaldoAnticipoTO(empresa, cliente);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PAGOSFORMA">
    @Override
    public java.lang.String accionCarPagosForma(
            cartera.TO.CarPagosCobrosFormaTO carPagosFormaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesCarBusinessLocal.accionCarPagosForma(carPagosFormaTO, accion, sisInfoTO);
    }

    @Override
    public java.lang.String accionCarCobrosForma(
            cartera.TO.CarPagosCobrosFormaTO carCobrosFormaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesCarBusinessLocal.accionCarCobrosForma(carCobrosFormaTO, accion, sisInfoTO);
    }

    @Override
    public List<CarComboPagosCobrosFormaTO> getCarComboPagosCobrosFormaTO(
            String empresa,
            char accion) throws Exception {
        return operacionesCarBusinessLocal.getCarComboPagosCobrosFormaTO(empresa, accion);
    }

    @Override
    public List<CarListaPagosCobrosFormaTO> getCarListaPagosCobrosFormaTO(
            String empresa,
            char accion) throws Exception {
        return operacionesCarBusinessLocal.getCarListaPagosCobrosFormaTO(empresa, accion);
    }
    // </editor-fold>

    @Override
    public cartera.TO.CarPagosCobrosAnticipoTO getCarPagosCobrosAnticipoTO(
            String empresa,
            String periodo,
            String tipo,
            String numero,
            char accion) throws Exception {
        return operacionesCarBusinessLocal.getCarPagosCobrosAnticipoTO(empresa, periodo, tipo, numero, accion);
    }

    @Override
    public java.util.List<cartera.TO.CarListaMayorAuxiliarClienteProveedorTO> getCarListaMayorAuxiliarClienteProveedorTO(
            java.lang.String empresa,
            String sector,
            java.lang.String proveedor,
            java.lang.String desde,
            java.lang.String hasta,
            char accion) throws java.lang.Exception {
        return operacionesCarBusinessLocal.getCarListaMayorAuxiliarClienteProveedorTO(empresa, sector, proveedor, desde, hasta, accion);
    }

    @Override
    public List<CarCuentasPorPagarCobrarDetalladoTO> getCarListaCuentasPorPagarDetalladoTO(
            String empresa,
            String sector,
            String proveedor,
            String hasta) throws Exception {
        return operacionesCarBusinessLocal.getCarListaCuentasPorPagarDetalladoTO(empresa, sector, proveedor, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarGeneralTO> getCarListaCuentasPorPagarGeneralTO(
            String empresa,
            String sector,
            String hasta) throws Exception {
        return operacionesCarBusinessLocal.getCarListaCuentasPorPagarGeneralTO(empresa, sector, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarAnticiposTO> getCarListaCuentasPorPagarAnticiposTO(
            String empresa,
            String sector,
            String hasta) throws Exception {
        return operacionesCarBusinessLocal.getCarListaCuentasPorPagarAnticiposTO(empresa, sector, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarAnticiposTO> getCarListaCuentasPorCobrarAnticiposTO(
            String empresa,
            String sector,
            String hasta) throws Exception {
        return operacionesCarBusinessLocal.getCarListaCuentasPorCobrarAnticiposTO(empresa, sector, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarDetalladoTO> getCarListaCuentasPorCobrarDetalladoTO(
            String empresa,
            String sector,
            String cliente,
            String desde,
            String hasta,
            boolean ichfa) throws Exception {
        return operacionesCarBusinessLocal.getCarListaCuentasPorCobrarDetalladoTO(empresa, sector, cliente, desde, hasta, ichfa);
    }

    @Override
    public java.util.List<cartera.TO.CarFunCuentasPorCobrarListadoVentasTO> getCarFunCuentasPorCobrarListadoVentasTO(
            String empresa,
            String sector,
            String cliente,
            String desde,
            String hasta) throws Exception {
        return operacionesCarBusinessLocal.getCarFunCuentasPorCobrarListadoVentasTO(empresa, sector, cliente, desde, hasta);
    }

    @Override
    public java.util.List<cartera.TO.CarFunCuentasPorPagarListadoComprasTO> getCarFunCuentasPorPagarListadoComprasTO(
            String empresa,
            String sector,
            String proveedor,
            String desde,
            String hasta) throws Exception {
        return operacionesCarBusinessLocal.getCarFunCuentasPorPagarListadoComprasTO(empresa, sector, proveedor, desde, hasta);
    }

    @Override
    public List<CarCuentasPorPagarCobrarGeneralTO> getCarListaCuentasPorCobrarGeneralTO(
            String empresa,
            String sector,
            String hasta) throws Exception {
        return operacionesCarBusinessLocal.getCarListaCuentasPorCobrarGeneralTO(empresa, sector, hasta);
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
        return operacionesCarBusinessLocal.anularReversarCarConContable(empresa, periodo, tipo, numero, usuario, accion, sisInfoTO);
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
        return operacionesCarBusinessLocal.insertarAnticiposPago(carPagosAnticipoTO, observaciones, nombreProveedor, fecha, sectorProveedor, documento, sisInfoTO);
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
        return operacionesCarBusinessLocal.insertarAnticiposCobro(carCobrosAnticipoTO, observaciones, nombreCliente, fecha, sectorCliente, documento, sisInfoTO);
    }

    @Override
    public List<CarCuentasPorPagarCobrarSaldoAnticiposTO> getCarListaCuentasPorPagarSaldoAnticiposTO(
            String empresa,
            String sector,
            String proveedorCodigo,
            String hasta) throws Exception {
        return operacionesCarBusinessLocal.getCarListaCuentasPorPagarSaldoAnticiposTO(empresa, sector, proveedorCodigo, hasta);
    }

    public List<CarCuentasPorPagarCobrarSaldoAnticiposTO> getCarListaCuentasPorCobrarSaldoAnticiposTO(
            String empresa,
            String sector,
            String clienteCodigo,
            String hasta) throws Exception {
        return operacionesCarBusinessLocal.getCarListaCuentasPorCobrarSaldoAnticiposTO(empresa, sector, clienteCodigo,hasta);
    }

    public List<CarListaPagosCobrosDetalleAnticipoTO> getPagosConsultaDetalleAnticipo(String empresa, String periodo, String numero) throws Exception {
        return operacionesCarBusinessLocal.getPagosConsultaDetalleAnticipo(empresa, periodo, numero);
    }
}
