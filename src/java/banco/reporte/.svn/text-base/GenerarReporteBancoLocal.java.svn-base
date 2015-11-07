/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.reporte;

import banco.TO.BanChequeTO;
import banco.TO.BanListaChequeTO;
import banco.TO.BanListaConciliacionBancariaTO;
import contabilidad.entity.ConDetalle;
import inventario.TO.*;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author paca94
 */
@Local
public interface GenerarReporteBancoLocal {

    public JasperPrint generarReporteConciliacion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, int estado, ReporteConciliacionCabecera conciliacionCabecera,
            List<BanListaConciliacionBancariaTO> listConciliacionCredito, List<BanListaConciliacionBancariaTO> listConciliacionDebito) throws Exception;

    public JasperPrint generarReporteListadoChequeEmisionVencimientoCobrarNumero(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String cuenta, String desde, String hasta, String tipo,
            List<BanListaChequeTO> listBanListaChequeTO) throws Exception;

    public JasperPrint generarReporteCheque(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            BanChequeTO banChequeTO, String valorLetra1, String valorLetra2, 
            String nombreReporteCheque, ConDetalle conDetalle, String cuentaCodigo)throws Exception;
}
