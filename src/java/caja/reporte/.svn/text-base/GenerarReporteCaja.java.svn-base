/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.reporte;

import caja.TO.CajCajaValesTO;
import caja.TO.CajCuadreCajaTO;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import sistema.TO.SisUsuarioEmpresaTO;
import static util.UtilsArchivos.getRutaReportes;
import validaciones.Validacion;

/**
 *
 * @author developer2
 */
@Stateless
public class GenerarReporteCaja implements GenerarReporteCajaLocal {

    private <T> JasperPrint generarReporte(SisUsuarioEmpresaTO sisUsuario, String nombreReporte, 
            Map parametros, List<T> list) throws Exception {
        try {
            String rutaReportes = getRutaReportes() + "caja/";
            parametros.put("SUBREPORT_DIR", rutaReportes);
            parametros.put("p_empresa_nombre", sisUsuario.getEmpNombre());
            parametros.put("p_empresa_ruc", sisUsuario.getEmpRuc());
            parametros.put("p_empresa_direccion", sisUsuario.getEmpDireccion());
            parametros.put("p_empresa_telefono", sisUsuario.getEmpTelefono());
            parametros.put("p_usuario_nick", sisUsuario.getUsrNick());
            parametros.put("p_fecha_hora", Validacion.fechaSistema());
            return JasperFillManager.fillReport(JasperCompileManager.compileReport(JRXmlLoader.load(rutaReportes + nombreReporte)),
                    parametros, new JRBeanCollectionDataSource(list));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public JasperPrint generarReporteCajCuadreDeCaja(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String fechaHasta, String codigoMotivo, String descripcionMotivo,
            List<CajCuadreCajaTO> listCajCuadreCajaTOs) throws Exception {
        try {
            List<ReporteCajCuadreDeCajaDetallado> lista = new ArrayList();
            for (CajCuadreCajaTO obj : listCajCuadreCajaTOs) {
                ReporteCajCuadreDeCajaDetallado reporteCajCuadreDeCajaDetallado = new ReporteCajCuadreDeCajaDetallado();
                reporteCajCuadreDeCajaDetallado.setCuadrarCaja(obj.getCuadrarCaja());
                reporteCajCuadreDeCajaDetallado.setCuaCantidad(obj.getCuaCantidad());
                reporteCajCuadreDeCajaDetallado.setCuaBase0(obj.getCuaBase0());
                reporteCajCuadreDeCajaDetallado.setCuaBaseImponible(obj.getCuaBaseImponible());
                reporteCajCuadreDeCajaDetallado.setCuaMontoIva(obj.getCuaMontoIva());
                reporteCajCuadreDeCajaDetallado.setCuaTotal(obj.getCuaTotal());
                reporteCajCuadreDeCajaDetallado.setCuaFecha(fechaHasta); 
                reporteCajCuadreDeCajaDetallado.setCuaMotivo(codigoMotivo);
                reporteCajCuadreDeCajaDetallado.setDescripcionMotivo((codigoMotivo == null ? "" : descripcionMotivo));
                                
                lista.add(reporteCajCuadreDeCajaDetallado);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportCajCuadreDeCajaDetallado.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public JasperPrint generarReporteCajVales(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String descripcionCajaConcepto, String codigoCajaConcepto, CajCajaValesTO cajCajaValesTo) throws Exception 
    {
        try {
            List<ReporteCajCajaVales> listareporteCajCajaValeses = new ArrayList();
            ReporteCajCajaVales reporteCajCajaVales = null;
            if (cajCajaValesTo != null) {
                reporteCajCajaVales = new ReporteCajCajaVales();
                reporteCajCajaVales.setValePeriodo(cajCajaValesTo.getValePeriodo());
                reporteCajCajaVales.setValeMotivo(cajCajaValesTo.getValeMotivo());
                reporteCajCajaVales.setValeNumero(cajCajaValesTo.getValeNumero());
                reporteCajCajaVales.setValeFecha(cajCajaValesTo.getUsrFechaInserta());
                reporteCajCajaVales.setValeValor(cajCajaValesTo.getValeValor().toString());
                reporteCajCajaVales.setValeBeneficiario(cajCajaValesTo.getValeBeneficiario());
                reporteCajCajaVales.setValeObservaciones(cajCajaValesTo.getValeObservaciones());
                reporteCajCajaVales.setConcCodigo(descripcionCajaConcepto);
                reporteCajCajaVales.setConcEmpresa(codigoCajaConcepto);
                reporteCajCajaVales.setCajeroNombre(sisUsuarioEmpresaTO.getUsrNick() 
                        + " - " + sisUsuarioEmpresaTO.getUsrNombre() + " " + 
                        sisUsuarioEmpresaTO.getUsrApellido());
                
                listareporteCajCajaValeses.add(reporteCajCajaVales);
            }                        
            String ruta = getRutaReportes()+"caja/reporteCajaVales.jrxml";
            File archivo = new File(ruta);
            if (archivo.exists()) {                
                return generarReporte(sisUsuarioEmpresaTO, "reporteCajaVales.jrxml", 
                    new HashMap(), listareporteCajCajaValeses);            
            } else{                
                return null;
            }                                  
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }   
    
    private List<ReporteCajCajaVales> listareporteCajCajaValeses;
    
    private void setReporteCajaValues(List<ReporteCajCajaVales> lista){
        listareporteCajCajaValeses = lista;
    }
    
    public List<ReporteCajCajaVales> getReporteCajaValues()throws Exception {
        return listareporteCajCajaValeses;
    }

    public JasperPrint generarReporteCajValesListado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<CajCajaValesTO> listaCajValesListaTOs) throws Exception 
    {
        try {
            List<ReporteCajValesListado> lista = new ArrayList();
            for (CajCajaValesTO obj : listaCajValesListaTOs) {
                ReporteCajValesListado reporteCajValesListado = new ReporteCajValesListado();
                reporteCajValesListado.setValePeriodo(obj.getValePeriodo());
                reporteCajValesListado.setValeFecha(obj.getValeFecha());
                reporteCajValesListado.setValeNumero(obj.getValeNumero());
                reporteCajValesListado.setValeValor(obj.getValeValor());
                reporteCajValesListado.setValeBeneficiario(obj.getValeBeneficiario());
                reporteCajValesListado.setValeObservaciones(obj.getValeObservaciones());
                reporteCajValesListado.setValeAnulado(obj.getValeAnulado());
                                
                lista.add(reporteCajValesListado);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reporteCajValesListado.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
