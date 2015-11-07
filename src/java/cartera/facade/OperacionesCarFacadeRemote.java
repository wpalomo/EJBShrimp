/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.facade;

import cartera.TO.CarCuentasPorPagarCobrarSaldoAnticiposTO;
import cartera.TO.CarFunPagosDetalleTO;
import cartera.reporte.*;
import java.util.List;
import javax.ejb.Remote;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author misael
 */
@Remote
public interface OperacionesCarFacadeRemote {

    public JasperPrint generarReporteCuentasPorCobrarDetallado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorCobrarDetallado> reporteCuentasPorCobrarDetallado) throws Exception;

    public JasperPrint generarReporteCuentasPorPagarDetallado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarDetallado> reporteCuentasPorPagarDetallado) throws Exception;

    public JasperPrint generarReporteCuentasPorCobrarGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorCobrarGeneral> reporteCuentasPorCobrarGeneral) throws Exception;

    public JasperPrint generarReporteCarFunCuentasPorCobrarListadoVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCarFunCuentasPorCobrarListadoVentas> reporteCarFunCuentasPorCobrarListadoVentas) throws Exception;

    public JasperPrint generarReporteCarFunCuentasPorPagarListadoCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCarFunCuentasPorPagarListadoCompras> reporteCarFunCuentasPorPagarListadoCompras) throws Exception;

    public JasperPrint generarReporteCuentasPorPagarGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarGeneral> reporteCuentasPorPagarGeneral) throws Exception;

    public JasperPrint generarReporteCuentasPorPagarAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarAnticipos> reporteCuentasPorPagarAnticipos) throws Exception;

    public JasperPrint generarReporteCuentasPorPagarSaldoAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarCobrarSaldoAnticipos> reporteCuentasPorPagarSaldoAnticipos) throws Exception;

    public JasperPrint generarReporteCuentasPorCobrarSaldoAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarCobrarSaldoAnticipos> reporteCuentasPorPagarSaldoAnticipos) throws Exception;

    public JasperPrint generarReporteCuentasPorCobrarAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarAnticipos> reporteCuentasPorPagarAnticipos) throws Exception;

    public JasperPrint generarReporteCobros(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCobros> reporteCobros) throws Exception;

    public JasperPrint generarReportePagos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReportePagos> reportePagos) throws Exception;

    public JasperPrint generarReporteMayorAuxiliarProveedorCliente(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteMayorAuxiliarProveedorCliente> reporteMayorAuxiliarProveedorCliente) throws Exception;

    public JasperPrint generarReporteListadoPagos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteListadoPagos> reporteListadoPagos) throws Exception;

    public JasperPrint generarReporteListadoCobros(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteListadoCobros> reporteListadoCobros) throws Exception;

    cartera.TO.CarContableTO insertarCarPagos(
            cartera.TO.CarPagosTO carPagosTO,
            List<cartera.TO.CarPagosDetalleComprasTO> carPagosDetalleComprasTOs,
            java.util.List<cartera.TO.CarPagosDetalleAnticiposTO> carPagosDetalleAnticiposTOs,
            List<cartera.TO.CarPagosDetalleFormaTO> carPagosDetalleFormaTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    cartera.TO.CarListaPagosProveedorTO getPagosConsultaProveedorTO(
            java.lang.String empresa,
            java.lang.String periodo,
            String tipo,
            java.lang.String numero) throws java.lang.Exception;

    cartera.TO.CarListaPagosProveedorTO getPagosConsultaProveedorAnticipoTO(
            java.lang.String empresa,
            java.lang.String periodo,
            String tipo,
            java.lang.String numero) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosTO> getPagosConsultaDetalleComprasTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String numero) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosTO> getCarListaPagosTO(
            java.lang.String empresa,
            java.lang.String proveedor) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosDetalleFormaTO> getPagosConsultaDetalleFormaTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String numero) throws java.lang.Exception;

    java.util.List<cartera.TO.CarFunPagosTO> getCarFunPagosTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String proveedor) throws java.lang.Exception;

    java.util.List<cartera.TO.CarFunPagosPruebaTO> getCarFunPagosPruebaTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String proveedor) throws java.lang.Exception;

    List<CarFunPagosDetalleTO> getCarFunPagosDetalleTO(
            String empresa,
            String desde,
            String hasta,
            String proveedor,
            String formaPago) throws Exception;

    java.util.List<cartera.TO.CarFunPagosSaldoAnticipoTO> getCarFunPagosSaldoAnticipoTO(
            java.lang.String empresa,
            java.lang.String proveedor) throws java.lang.Exception;

    cartera.TO.CarContableTO insertarCarCobros(
            cartera.TO.CarCobrosTO carCobrosTO,
            java.util.List<cartera.TO.CarCobrosDetalleVentasTO> carCobrosDetalleVentasTOs,
            java.util.List<cartera.TO.CarCobrosDetalleAnticiposTO> carCobrosDetalleAnticiposTOs,
            java.util.List<cartera.TO.CarCobrosDetalleFormaTO> carCobrosDetalleFormaTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    cartera.TO.CarListaCobrosClienteTO getCobrosConsultaClienteTO(
            java.lang.String empresa,
            java.lang.String periodo,
            String tipo,
            java.lang.String numero) throws java.lang.Exception;

    cartera.TO.CarListaCobrosClienteTO getCobrosConsultaClienteAnticipoTO(
            java.lang.String empresa,
            java.lang.String periodo,
            String tipo,
            java.lang.String numero) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosTO> getCobrosConsultaDetalleVentasTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String numero) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosTO> getCarListaCobrosTO(
            java.lang.String empresa,
            java.lang.String cliente) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosDetalleFormaTO> getCobrosConsultaDetalleFormaTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String numero) throws java.lang.Exception;
    
    java.util.List<cartera.TO.CarListaPagosCobrosDetalleAnticipoTO> getCobrosConsultaDetalleAnticipo(
            String empresa, 
            String periodo, 
            String numero) throws Exception ;

    java.util.List<cartera.TO.CarFunCobrosTO> getCarFunCobrosTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String cliente) throws java.lang.Exception;

    java.util.List<cartera.TO.CarFunCobrosDetalleTO> getCarFunCobrosDetalleTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String cliente,
            java.lang.String formaPago) throws java.lang.Exception;

    java.util.List<cartera.TO.CarFunCobrosSaldoAnticipoTO> getCarFunCobrosSaldoAnticipoTO(
            java.lang.String empresa,
            java.lang.String cliente) throws java.lang.Exception;

    java.lang.String accionCarPagosForma(
            cartera.TO.CarPagosCobrosFormaTO carPagosFormaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String accionCarCobrosForma(
            cartera.TO.CarPagosCobrosFormaTO carCobrosFormaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<cartera.TO.CarComboPagosCobrosFormaTO> getCarComboPagosCobrosFormaTO(
            java.lang.String empresa,
            char accion) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosFormaTO> getCarListaPagosCobrosFormaTO(
            java.lang.String empresa,
            char accion) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaMayorAuxiliarClienteProveedorTO> getCarListaMayorAuxiliarClienteProveedorTO(
            java.lang.String empresa,
            java.lang.String proveedor,
            java.lang.String desde,
            java.lang.String hasta,
            char accion) throws java.lang.Exception;

    cartera.TO.CarPagosCobrosAnticipoTO getCarPagosCobrosAnticipoTO(
            String empresa,
            String periodo,
            String tipo,
            String numero,
            char accion) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarDetalladoTO> getCarListaCuentasPorPagarDetalladoTO(
            String empresa,
            String sector,
            String hasta) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarGeneralTO> getCarListaCuentasPorPagarGeneralTO(
            String empresa,
            String sector,
            String hasta) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarAnticiposTO> getCarListaCuentasPorPagarAnticiposTO(
            String empresa,
            String sector,
            String hasta) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarAnticiposTO> getCarListaCuentasPorCobrarAnticiposTO(
            String empresa,
            String sector,
            String hasta) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarDetalladoTO> getCarListaCuentasPorCobrarDetalladoTO(
            String empresa,
            String sector,
            String desde,
            String hasta,
            boolean ichfa) throws Exception;

    java.util.List<cartera.TO.CarFunCuentasPorCobrarListadoVentasTO> getCarFunCuentasPorCobrarListadoVentasTO(
            String empresa,
            String sector,
            String cliente,
            String desde,
            String hasta) throws Exception;

    java.util.List<cartera.TO.CarFunCuentasPorPagarListadoComprasTO> getCarFunCuentasPorPagarListadoComprasTO(
            String empresa,
            String sector,
            String proveedor,
            String desde,
            String hasta) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarGeneralTO> getCarListaCuentasPorCobrarGeneralTO(
            String empresa,
            String sector,
            String hasta) throws Exception;

    java.lang.String anularReversarCarConContable(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String tipo,
            java.lang.String numero,
            java.lang.String usuario,
            java.lang.String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String insertarAnticiposPago(
            cartera.TO.CarPagosAnticipoTO carPagosAnticipoTO,
            java.lang.String observaciones,
            java.lang.String nombreProveedor,
            java.lang.String fecha,
            java.lang.String sectorProveedor,
            java.lang.String documento,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String insertarAnticiposCobro(
            cartera.TO.CarCobrosAnticipoTO carCobrosAnticipoTO,
            java.lang.String observaciones,
            java.lang.String nombreCliente,
            java.lang.String fecha,
            java.lang.String sectorCliente,
            java.lang.String documento,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<CarCuentasPorPagarCobrarSaldoAnticiposTO> getCarListaCuentasPorPagarSaldoAnticiposTO(
            String empresa,
            String sector,
            String proveedorCodigo,
            String hasta) throws Exception;

    java.util.List<CarCuentasPorPagarCobrarSaldoAnticiposTO> getCarListaCuentasPorCobrarSaldoAnticiposTO(
            String empresa,
            String sector,
            String clienteCodigo,
            String hasta) throws Exception;
}
