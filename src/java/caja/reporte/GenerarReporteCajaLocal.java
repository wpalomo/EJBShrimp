/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.reporte;

import caja.TO.CajCajaValesTO;
import caja.TO.CajCuadreCajaTO;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author developer2
 */
@Local
public interface GenerarReporteCajaLocal {

    public JasperPrint generarReporteCajCuadreDeCaja(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String fechaHasta, String codigoMotivo, String descripcionMotivo,
            List<CajCuadreCajaTO> listCajCuadreCajaTOs) throws Exception ;

    public JasperPrint generarReporteCajVales(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String descripcionCajaConcepto, String codigoCajaConcepto, 
            CajCajaValesTO cajCajaValesTo)throws Exception ;

//    public caja.reporte.ReporteCajCajaVales setReporteCajaValues();

    public java.util.List<caja.reporte.ReporteCajCajaVales> getReporteCajaValues()throws Exception;

    public JasperPrint generarReporteCajValesListado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<CajCajaValesTO> listaCajValesListaTOs)throws Exception;
    
}
