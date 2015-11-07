/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.reporte;

import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import produccion.TO.*;
import sistema.TO.SisUsuarioEmpresaTO;




/**
 *
 * @author paca94
 */
@Local
public interface GenerarReporteProduccionLocal {    

    public JasperPrint generarReporteListadoGramaje(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String codigoSector, String codigoPiscina, String codigoCorrida, String fechaDesde, 
            String fechaHasta, 
            List<PrdListadoGrameajeTO> prdListadoGrameajeTO) throws Exception;

    public JasperPrint generarReporteListadoFunAnalisisPesos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String codigoSector, String fechaHasta, 
            List<PrdListaFunAnalisisPesosTO> prdListaFunAnalisisPesosTO) throws Exception;

    public JasperPrint generarReporteConsumoFecha(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String secCodigo, String fechaDesde, 
            String fechaHasta, 
            List<PrdConsumosTO> prdConsumosTO)throws Exception;

    public JasperPrint generarReporteConsumoPiscina(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String codigoSector, 
            String codigoPiscina, String numeroCorrida, String hectareas, 
            Integer numLarvas, String fechaDesde, String fechaHasta, 
            List<PrdConsumosTO> prdConsumosTO) throws Exception;

    public JasperPrint generarReporteEconomicoPorFechas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String fechaDesde, String fechaHasta, 
            List<PrdCostoDetalleFechaTO> listaPrdCostoDetalleFechaTO) throws Exception;

    public JasperPrint generarReporteEconomicoPorPiscinas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String codigoSector, String codigoPiscina, 
            String codigoCorrida, String hectareas, 
            Integer numLarvas, String fechaDesde, 
            String fechaHasta, List<PrdListaCostosDetalleCorridaTO> prdListaCostosDetalleCorridaTO)
            throws Exception;

    public JasperPrint generarReporteResumenSiembra(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, Object[][] datos)throws Exception;

    public JasperPrint generarReporteResumenSiembra(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<PrdResumenCorridaTO> listaPrdListaResumenCorridaTO);

    public JasperPrint generarReporteResumenPesca(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<PrdResumenCorridaTO> listaPrdListaResumenCorridaTO)throws Exception;

    public JasperPrint generarReporteResumenPescaEconomico(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, Object[][] datos)throws Exception;
    
}
