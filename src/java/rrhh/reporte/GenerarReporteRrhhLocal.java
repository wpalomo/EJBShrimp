/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.reporte;

import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import rrhh.TO.*;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author developer2
 */
@Local
public interface GenerarReporteRrhhLocal {

    public JasperPrint generarReporteConsolidadoAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String fechaDesde,
            String fechaHasta,
            List<RhListaConsolidadoAnticiposPrestamosTO> listaConsolidadoAnticiposPrestamosTO) throws Exception ;

    public JasperPrint generarReporteListaDetalleVacaionesPagadas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String desde, String hasta,
            String empSector, List<RhDetalleVacionesPagadasGozadasTO> listaDetalleVacacionesPagadasGozadasTO) throws Exception;

    public JasperPrint generarReporteDetalleAnticipos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empId, String empCodigo,
            String empCategoria, String fechaDesde, String fechaHasta,
            List<RhListaDetalleAnticiposTO> listaDetalleAnticiposTO) throws Exception;

    public JasperPrint generarReporteDetalleAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empCodigo,
            String fechaDesde, String fechaHasta, String empCategoria,
            String empId,
            List<RhListaDetalleAnticiposPrestamosTO> listaDetalleAnticiposPrestamosTO) throws Exception;

    public JasperPrint generarReporteDetallePrestamos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String empCodigo, String fechaDesde, String fechaHasta, String empCategoria,
            String empId, List<RhListaDetallePrestamosTO> listaDetallePrestamosTO) throws Exception;

    public JasperPrint generarReporteDetalleBonos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String empCategoria, String nombreEmpleado,
            List<RhListaDetalleBonosTO> listaDetalleBonosTO) throws Exception;

    public JasperPrint generarReporteDetalleBonosLote(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String periodo, String tipo, String numero,
            List<RhListaDetalleBonosLoteTO> listaDetalleBonosLoteTO) throws Exception;

    public JasperPrint generarReporteDetalleViaticos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaDetalleViaticosTO> listaDetalleViaticosTO) throws Exception;

    public JasperPrint generarReporteConsolidadoBonosViatico(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<RhListaConsolidadoBonosViaticosTO> listaConsolidadoBonosViaticosTO) throws Exception;

    public JasperPrint generarReporteListadoRolesPago(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String empCategoria, String nombreEmpleado,
            List<RhListaDetalleRolesTO> listaDetalleRolesTO) throws Exception;

    public JasperPrint generarReporteConsolidadoRoles(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String empCategoria, String nombreEmpleado,
            List<RhListaConsolidadoRolesTO> listaConsolidadoRolesTO) throws Exception;

    public JasperPrint generarReporteSaldoIndividualAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String empId,
            List<RhListaSaldoIndividualAnticiposPrestamosTO> listaSaldoIndividualAnticiposPrestamosTO) throws Exception;

    public JasperPrint generarReporteSaldoConsolidadoAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoAnticiposPrestamosTO> listaSaldoConsolidadoAnticiposPrestamosTO) throws Exception;

    public JasperPrint generarReporteSaldoConsolidadoBonosViaticos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoBonosViaticosTO> listaSaldoConsolidadoBonosViaticosTO) throws Exception;

    public JasperPrint generarReporteSaldoConsolidadoSueldosPorPagar(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoSueldosPorPagarTO> listaSaldoConsolidadoSueldosPorPagarTO) throws Exception;

    public JasperPrint generarReporteXiiiSueldoConsulta(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta, String fechaMaxima,
            List<RhFunXiiiSueldoConsultarTO> rhFunXiiiSueldoConsultarTO) throws Exception;

    public JasperPrint generarReporteXivSueldoConsulta(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String sector, String periodo,
            String fechaDesde, String fechaHasta, String fechaMaxima,
            List<RhFunXivSueldoConsultarTO> rhFunXivSueldoConsultarTO) throws Exception;

    public JasperPrint generarReporteUtilidadesPreCalculo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta,
            String fechaMaxima,
            List<RhFunUtilidadesCalcularTO> rhFunUtilidadesCalcularTOs) throws Exception;

    public JasperPrint generarReporteProvisionesComprobanteContable(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String periodo, String tipo,
            String numero, List<RhListaProvisionesTO> listaProvisionesTO) throws Exception;

    public JasperPrint generarReporteFormulario107(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaEntrega, String rucEmpleador, String razonSocial, String rucContador,
            RhFormulario107TO rhFormulario107TOGuardar) throws Exception;

    public JasperPrint generarReporteAnticipo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteAnticipoOprestamo> rhReporteAnticipoOprestamos) throws Exception;

    public JasperPrint generarReporteConsultaAnticiposLote(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteConsultaAnticiposLote> lista) throws Exception;

    public JasperPrint generarReportePrestamoVista(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteAnticipoOprestamo> lista) throws Exception;

    public JasperPrint generarReporteRol(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReportesRol> lista) throws Exception;

    public JasperPrint generarReporteEmpleado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteEmpleado> listReporteEmpleado) throws Exception;

    public JasperPrint generarReporteRol2(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<AuxiliarReporteDetalleRoles> lista);
}
