/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.reporte;

import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author paca94
 */
@Local
public interface GenerarReporteCarteraLocal {

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
}
