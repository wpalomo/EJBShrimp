/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.business;

import caja.TO.CajCajaValesTO;
import caja.TO.CajCuadreCajaTO;
import caja.reporte.ReporteCajCajaVales;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesCajaBusinessLocal {

    caja.TO.MensajeTO accionCajCajaTO(
            caja.TO.CajCajaTO cajCajaTO,
            String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<caja.TO.CajCajaTO> getListadoCajCajaTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.util.List<caja.TO.CajCajaComboTO> getCajCajaComboTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.util.List<caja.TO.CajValesConceptosComboTO> getCajValesConceptosComboTOs(
            String empresa) throws Exception;

    java.lang.String accionCajaValesTO(
            caja.TO.CajCajaValesTO cajCajaValesTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.lang.String accionCajValesConceptosTO(
            caja.TO.CajValesConceptoTO cajValesConceptosTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<caja.TO.CajCajaValesTO> getListadoCajValesTO(
            java.lang.String empresa,
            java.lang.String motCodigo,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws Exception;

    caja.TO.CajCajaValesTO getCajCajaValesTO(
            String empresa,
            String perCodigo,
            String motCodigo,
            String valeNumero) throws Exception;

    java.util.List<caja.TO.CajCuadreCajaTO> getCajCuadreCajaTOs(
            String empresa,
            String codigoMotivo,
            String fechaDesde,
            String fechaHasta) throws Exception;

    caja.TO.CajCajaTO getCajCajaTO(
            String empresa,
            String usuarioCodigo) throws Exception;

    JasperPrint generarReporteCajCuadreDeCaja(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String fechaHasta, String codigoMotivo, String descripcionMotivo,
            List<CajCuadreCajaTO> listCajCuadreCajaTOs)throws Exception;

    JasperPrint generarReporteCajVales(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String descripcionCajaConcepto, String codigoCajaConcepto, 
            CajCajaValesTO cajCajaValesTo)throws Exception;

    List<ReporteCajCajaVales> getReporteCajaValues()throws Exception;

    JasperPrint generarReporteCajValesListado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<CajCajaValesTO> listaCajValesListaTOs)throws Exception;
}
//paso 4 del ejb