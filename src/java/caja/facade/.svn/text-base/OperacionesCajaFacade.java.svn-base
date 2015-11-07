/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.facade;

import caja.TO.CajCajaValesTO;
import caja.TO.CajCuadreCajaTO;
import caja.reporte.ReporteCajCajaVales;
import java.util.List;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesCajaFacade implements OperacionesCajaFacadeRemote {

    @javax.ejb.EJB
    caja.business.OperacionesCajaBusinessLocal operacionesCajaBusinessLocal;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public caja.TO.MensajeTO accionCajCajaTO(
            caja.TO.CajCajaTO cajCajaTO,
            String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesCajaBusinessLocal.accionCajCajaTO(cajCajaTO, accion, sisInfoTO);
    }

    @Override
    public java.util.List<caja.TO.CajCajaTO> getListadoCajCajaTO(
            String empresa) throws java.lang.Exception {
        return operacionesCajaBusinessLocal.getListadoCajCajaTO(empresa);
    }

    @Override
    public java.util.List<caja.TO.CajCajaComboTO> getCajCajaComboTO(
            String empresa) throws Exception {
        return operacionesCajaBusinessLocal.getCajCajaComboTO(empresa);
    }

    @Override
    public java.util.List<caja.TO.CajValesConceptosComboTO> getCajValesConceptosComboTOs(
            String empresa) throws Exception {
        return operacionesCajaBusinessLocal.getCajValesConceptosComboTOs(empresa);
    }

    @Override
    public String accionCajaValesTO(
            caja.TO.CajCajaValesTO cajCajaValesTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesCajaBusinessLocal.accionCajaValesTO(cajCajaValesTO, accion, sisInfoTO);
    }

    @Override
    public String accionCajValesConceptosTO(
            caja.TO.CajValesConceptoTO cajValesConceptosTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesCajaBusinessLocal.accionCajValesConceptosTO(cajValesConceptosTO, accion, sisInfoTO);
    }

    @Override
    public java.util.List<caja.TO.CajCajaValesTO> getListadoCajValesTO(
            java.lang.String empresa,
            java.lang.String motCodigo,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws Exception {
        return operacionesCajaBusinessLocal.getListadoCajValesTO(empresa, motCodigo, fechaDesde, fechaHasta);
    }

    @Override
    public caja.TO.CajCajaValesTO getCajCajaValesTO(
            String empresa,
            String perCodigo,
            String motCodigo,
            String valeNumero) throws Exception {
        return operacionesCajaBusinessLocal.getCajCajaValesTO(empresa, perCodigo, motCodigo, valeNumero);
    }

    @Override
    public java.util.List<caja.TO.CajCuadreCajaTO> getCajCuadreCajaTOs(
            String empresa,
            String codigoMotivo,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesCajaBusinessLocal.getCajCuadreCajaTOs(empresa, codigoMotivo, fechaDesde, fechaHasta);
    }

    @Override
    public caja.TO.CajCajaTO getCajCajaTO(
            String empresa,
            String usuarioCodigo) throws Exception {
        return operacionesCajaBusinessLocal.getCajCajaTO(empresa, usuarioCodigo);
    }

    @Override
    public JasperPrint generarReporteCajCuadreDeCaja(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaHasta, String codigoMotivo, String descripcionMotivo,
            List<CajCuadreCajaTO> listCajCuadreCajaTOs) throws Exception {
        return operacionesCajaBusinessLocal.generarReporteCajCuadreDeCaja(sisUsuarioEmpresaTO,
                fechaHasta, codigoMotivo, descripcionMotivo,
                listCajCuadreCajaTOs);
    }

    @Override
    public JasperPrint generarReporteCajVales(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String descripcionCajaConcepto, String codigoCajaConcepto,
            CajCajaValesTO cajCajaValesTo) throws Exception {
        return operacionesCajaBusinessLocal.generarReporteCajVales(sisUsuarioEmpresaTO,
                descripcionCajaConcepto, codigoCajaConcepto, cajCajaValesTo);
    }

    @Override
    public List<ReporteCajCajaVales> getReporteCajaValues() throws Exception {
        return operacionesCajaBusinessLocal.getReporteCajaValues();
    }

    @Override
    public JasperPrint generarReporteCajValesListado(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<CajCajaValesTO> listaCajValesListaTOs) throws Exception {
        return operacionesCajaBusinessLocal.generarReporteCajValesListado(sisUsuarioEmpresaTO,
                listaCajValesListaTOs);
    }
}