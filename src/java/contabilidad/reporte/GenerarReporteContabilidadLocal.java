/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.reporte;

import contabilidad.TO.*;
import inventario.reporte.ReporteCompraDetalle;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author paca94
 */
@Local
public interface GenerarReporteContabilidadLocal {

     JasperPrint generarReporteContableDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ConContableReporteTO> listConContableReporteTO) throws Exception;

     JasperPrint generarReporteMayorAuxiliar(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String cuentaContable, String cuentaContablePadre, List<ConMayorAuxiliarTO> listConMayorAuxiliarTO) throws Exception;

     JasperPrint generarReporteMayorGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            String cuentaContable, Object[][] datos) throws Exception;//List<ConMayorGeneralTO> listConMayorGeneralTO) throws Exception;

     JasperPrint generarReporteDiarioAuxiliar(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String codigoTipo, List<ConDiarioAuxiliarTO> listConDiarioAuxiliarTO) throws Exception;

     JasperPrint generarReporteBalanceComprobacion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, List<ConBalanceComprobacionTO> listConBalanceComprobacionTO) throws Exception;

     JasperPrint generarReporteBalanceGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            String codigoSector, List<ConFunBalanceGeneralNecTO> listConFunBalanceGeneralNecTO, List<ConBalanceGeneralTO> listConBalanceGeneralTO) throws Exception;

     JasperPrint generarReporteBalanceGeneralComparativo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaAnterior, String fechaActual,
            String codigoSector, List<ConBalanceGeneralComparativoTO> listConBalanceGeneralComparativoTO) throws Exception;

     JasperPrint generarReporteBalanceResultado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String codigoSector, Integer columnasEstadosFinancieros, List<ConFunBalanceResultadosNecTO> listConFunBalanceResultadosNecTO) throws Exception;

     JasperPrint generarReporteContablesVerificacionesCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<ConFunContablesVerificacionesComprasTO> listConFunContablesVerificacionesComprasTO) throws Exception;

     JasperPrint generarReporteConListaBalanceResultadosVsInventario(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<ConListaBalanceResultadosVsInventarioTO> listConListaBalanceResultadosVsInventarioTO) throws Exception;

     JasperPrint generarReporteContablesVerificacionesErrores(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ConFunContablesVerificacionesTO> listConFunContablesVerificacionesTO) throws Exception;

     JasperPrint generarReporteMayorGeneral(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta, 
            String cuentaContable, List<ConMayorGeneralTO> listConMayorGeneralTO)throws Exception;

    JasperPrint generarReporteCompraContableDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<ReporteCompraDetalle> reporteCompraDetalles, 
            List<ConContableReporteTO> list)throws Exception;
}
