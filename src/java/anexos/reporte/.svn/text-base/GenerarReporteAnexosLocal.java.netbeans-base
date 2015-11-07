/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.reporte;

import anexos.TO.*;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;




/**
 *
 * @author paca94
 */
@Local
public interface GenerarReporteAnexosLocal {    
    

    public JasperPrint generarReporteTalonResumen(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String desde, String hasta, List<AnxTalonResumenTO> listaAnxTalonResumenTO)throws Exception;
    public JasperPrint generarReporteTalonResumenVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String desde, String hasta, List<AnxTalonResumenVentaTO> listaAnxTalonResumenVentaTO) throws Exception;

    public JasperPrint generarReporteListadoRetencionesPorNumero(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<AnxListaRetencionesTO> listaAnxListaRetencionesTO)throws Exception;

    public JasperPrint generarReporteListadoRetencionesVentas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, 
            String fechaHasta, 
            List<AnxListadoRetencionesVentasTO> anxListadoRetencionesVentasTOs)throws Exception;

    public JasperPrint generarReporteListadoDevolucionIva(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta, 
            List<AnxFunListadoDevolucionIvaTO> anxFunListadoDevolucionIvaTOs)throws Exception;
    
}
