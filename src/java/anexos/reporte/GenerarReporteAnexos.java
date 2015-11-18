/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.reporte;

import anexos.TO.AnxFunListadoDevolucionIvaTO;
import anexos.TO.AnxListaRetencionesTO;
import anexos.TO.AnxListadoRetencionesVentasTO;
import anexos.TO.AnxTalonResumenTO;
import anexos.TO.AnxTalonResumenVentaTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import sistema.TO.SisUsuarioEmpresaTO;
import sistema.business.OperacionesSistemaBusinessLocal;
import static util.UtilsArchivos.getRutaReportes;
import validaciones.Validacion;

/**
 *
 * @author paca94
 */
@Stateless
public class GenerarReporteAnexos implements GenerarReporteAnexosLocal {

    @EJB
    OperacionesSistemaBusinessLocal operacionesSistemaBusinessLocal;

    private <T> JasperPrint generarReporte(SisUsuarioEmpresaTO sisUsuario,
            String nombreReporte, Map parametros, List<T> list) throws Exception {
        try {

            String rutaReportes = getRutaReportes() + "anexos/";
            System.out.println("ruta anexos: " + rutaReportes + nombreReporte);
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

    public JasperPrint generarReporteTalonResumen(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String desde, String hasta, List<AnxTalonResumenTO> listaAnxTalonResumenTO) throws Exception {
        try {
            List<ReporteTalonResumenRetenciones> lista = new ArrayList();
            for (AnxTalonResumenTO plgTO : listaAnxTalonResumenTO) {
                ReporteTalonResumenRetenciones reporteTalonResumenRetencion = new ReporteTalonResumenRetenciones();
                reporteTalonResumenRetencion.setDesde(desde);
                reporteTalonResumenRetencion.setHasta(hasta);
                reporteTalonResumenRetencion.setRetConcepto((plgTO.getRetConcepto() == null ? "" : plgTO.getRetConcepto()));
                reporteTalonResumenRetencion.setRetCantidad((plgTO.getRetCantidad() == null ? 0 : plgTO.getRetCantidad()));
                reporteTalonResumenRetencion.setRetBaseImponible((plgTO.getRetBaseImponible() == null ? null : plgTO.getRetBaseImponible()));
                reporteTalonResumenRetencion.setRetPorcentaje((plgTO.getRetPorcentaje() == null ? null : plgTO.getRetPorcentaje()));
                reporteTalonResumenRetencion.setRetValorRetenido((plgTO.getRetValorRetenido() == null ? null : plgTO.getRetValorRetenido()));

                lista.add(reporteTalonResumenRetencion);
            }
            //reportListadoGrameaje
            return generarReporte(sisUsuarioEmpresaTO, "reportTalonResumenRetenciones.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteTalonResumenVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String desde, String hasta, List<AnxTalonResumenVentaTO> listaAnxTalonResumenVentaTO) throws Exception {
        try {
            //anexos.reporte.ReporteTalonResumenVentas
            List<ReporteTalonResumenVentas> lista = new ArrayList();
            for (AnxTalonResumenVentaTO plgTO : listaAnxTalonResumenVentaTO) {
                ReporteTalonResumenVentas reporteTalonResumenVentas = new ReporteTalonResumenVentas();
                reporteTalonResumenVentas.setDesde(desde);
                reporteTalonResumenVentas.setHasta(hasta);
                reporteTalonResumenVentas.setVenComprobante((plgTO.getVenComprobante() == null ? "" : plgTO.getVenComprobante()));
                reporteTalonResumenVentas.setVenEstablecimiento((plgTO.getVenEstablecimiento() == null ? "" : plgTO.getVenEstablecimiento()));
                reporteTalonResumenVentas.setVenPuntoEmision((plgTO.getVenPuntoEmision() == null ? "" : plgTO.getVenPuntoEmision()));
                reporteTalonResumenVentas.setVenBaseNoObjetoIva((plgTO.getVenBaseNoObjetoIva() == null ? new BigDecimal("0.00") : plgTO.getVenBaseNoObjetoIva()));
                reporteTalonResumenVentas.setVenBase0((plgTO.getVenBase0() == null ? new BigDecimal("0.00") : plgTO.getVenBase0()));
                reporteTalonResumenVentas.setVenBaseImponible((plgTO.getVenBaseNoObjetoIva() == null ? new BigDecimal("0.00") : plgTO.getVenBaseImponible()));
                reporteTalonResumenVentas.setVenMotoIva((plgTO.getVenMotoIva() == null ? new BigDecimal("0.00") : plgTO.getVenMotoIva()));
                reporteTalonResumenVentas.setVenValorRetenidoIva((plgTO.getVenValorRetenidoIva() == null ? new BigDecimal("0.00") : plgTO.getVenValorRetenidoIva()));
                reporteTalonResumenVentas.setVenValorRetenidoRenta((plgTO.getVenValorRetenidoRenta() == null ? new BigDecimal("0.00") : plgTO.getVenValorRetenidoRenta()));
                lista.add(reporteTalonResumenVentas);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportTalonResumenVentas.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListadoRetencionesPorNumero(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<AnxListaRetencionesTO> listaAnxListaRetencionesTO) throws Exception {
        try {
            List<ReporteAnxListaRetenciones> lista = new ArrayList();
            for (AnxListaRetencionesTO plgTO : listaAnxListaRetencionesTO) {
                ReporteAnxListaRetenciones reporteAnxListaRetencion = new ReporteAnxListaRetenciones();

                reporteAnxListaRetencion.setRetProveedorId((plgTO.getRetProveedorId() == null ? "" : plgTO.getRetProveedorId()));
                reporteAnxListaRetencion.setRetProveedorNombre((plgTO.getRetProveedorNombre() == null ? "" : plgTO.getRetProveedorNombre()));
                reporteAnxListaRetencion.setRetDocumentoNombre((plgTO.getRetDocumentoNombre() == null ? "" : plgTO.getRetDocumentoNombre()));
                reporteAnxListaRetencion.setRetDocumentoNumero((plgTO.getRetDocumentoNumero() == null ? "" : plgTO.getRetDocumentoNumero()));
                reporteAnxListaRetencion.setRetCompraFecha((plgTO.getRetCompraFecha() == null ? "" : plgTO.getRetCompraFecha()));
                reporteAnxListaRetencion.setRetCompraBase0((plgTO.getRetCompraBase0() == null ? null : plgTO.getRetCompraBase0()));
                reporteAnxListaRetencion.setRetCompraBaseImponible((plgTO.getRetCompraBaseImponible() == null ? null : plgTO.getRetCompraBaseImponible()));
                reporteAnxListaRetencion.setRetCompraMontoIva((plgTO.getRetCompraMontoIva() == null ? null : plgTO.getRetCompraMontoIva()));
                reporteAnxListaRetencion.setRetRetencionAutorizacion((plgTO.getRetRetencionAutorizacion() == null ? "" : plgTO.getRetRetencionAutorizacion()));
                reporteAnxListaRetencion.setRetRetencionNumero((plgTO.getRetRetencionNumero() == null ? "" : plgTO.getRetRetencionNumero()));
                reporteAnxListaRetencion.setRetRetencionFecha((plgTO.getRetRetencionFecha() == null ? "" : plgTO.getRetRetencionFecha()));
                reporteAnxListaRetencion.setRetValorRetenidoIr((plgTO.getRetValorRetenidoIr() == null ? null : plgTO.getRetValorRetenidoIr()));
                reporteAnxListaRetencion.setRetValorRetenidoIva((plgTO.getRetValorRetenidoIva() == null ? null : plgTO.getRetValorRetenidoIva()));
                reporteAnxListaRetencion.setRetTotalRetenido((plgTO.getRetTotalRetenido() == null ? null : plgTO.getRetTotalRetenido()));



                lista.add(reporteAnxListaRetencion);
            }
            //reportListadoGrameaje
            return generarReporte(sisUsuarioEmpresaTO, "reportListadoRetencionesComprasPorNumero.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListadoRetencionesVentas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta,
            List<AnxListadoRetencionesVentasTO> anxListadoRetencionesVentasTOs) throws Exception {
        try {
            List<ReporteListadoRetencionesVentas> lista = new ArrayList();
            for (AnxListadoRetencionesVentasTO plgTO : anxListadoRetencionesVentasTOs) {
                ReporteListadoRetencionesVentas reporteListadoRetencionesVentas = new ReporteListadoRetencionesVentas();

                reporteListadoRetencionesVentas.setDesde(fechaDesde);
                reporteListadoRetencionesVentas.setHasta(fechaHasta);
                reporteListadoRetencionesVentas.setVenFecha((plgTO.getVenFecha() == null ? "" : plgTO.getVenFecha()));
                reporteListadoRetencionesVentas.setVenIdentificacion((plgTO.getVenIdentificacion() == null ? "" : plgTO.getVenIdentificacion()));
                reporteListadoRetencionesVentas.setVenNombre((plgTO.getVenNombre() == null ? "" : plgTO.getVenNombre()));
                reporteListadoRetencionesVentas.setVenComprobanteTipo((plgTO.getVenComprobanteTipo() == null ? "" : plgTO.getVenComprobanteTipo()));
                reporteListadoRetencionesVentas.setVenComprobanteNumero((plgTO.getVenComprobanteNumero() == null ? "" : plgTO.getVenComprobanteNumero()));
                reporteListadoRetencionesVentas.setVenBaseNoObjetoIva((plgTO.getVenBaseNoObjetoIva() == null ? null : plgTO.getVenBaseNoObjetoIva()));
                reporteListadoRetencionesVentas.setVenBase0((plgTO.getVenBase0() == null ? null : plgTO.getVenBase0()));
                reporteListadoRetencionesVentas.setVenBaseImponible((plgTO.getVenBaseImponible() == null ? null : plgTO.getVenBaseImponible()));
                reporteListadoRetencionesVentas.setVenMontoIva((plgTO.getVenMontoIva() == null ? null : plgTO.getVenMontoIva()));
                reporteListadoRetencionesVentas.setVenValorRetenidoIva((plgTO.getVenValorRetenidoIva() == null ? null : plgTO.getVenValorRetenidoIva()));
                reporteListadoRetencionesVentas.setVenValorRetenidoRenta((plgTO.getVenValorRetenidoRenta() == null ? null : plgTO.getVenValorRetenidoRenta()));


                lista.add(reporteListadoRetencionesVentas);
            }
            //reportListadoGrameaje
            return generarReporte(sisUsuarioEmpresaTO, "reportListadoRetencionesVentas.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListadoDevolucionIva(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta,
            List<AnxFunListadoDevolucionIvaTO> anxFunListadoDevolucionIvaTOs) throws Exception {
        try {
            List<ReporteAnxFunListadoDevolucionIva> lista = new ArrayList();
            for (AnxFunListadoDevolucionIvaTO plgTO : anxFunListadoDevolucionIvaTOs) {
                ReporteAnxFunListadoDevolucionIva reporteAnxFunListadoDevolucionIva = new ReporteAnxFunListadoDevolucionIva();

                reporteAnxFunListadoDevolucionIva.setFechaDesde(fechaDesde);
                reporteAnxFunListadoDevolucionIva.setFechaHasta(fechaHasta);

                reporteAnxFunListadoDevolucionIva.setActSustentoTributario((plgTO.getActSustentoTributario() == null ? "" : plgTO.getActSustentoTributario()));
                reporteAnxFunListadoDevolucionIva.setActFecha((plgTO.getActFecha() == null ? "" : plgTO.getActFecha()));
                reporteAnxFunListadoDevolucionIva.setActProveedorNombre((plgTO.getActProveedorNombre() == null ? "" : plgTO.getActProveedorNombre()));
                reporteAnxFunListadoDevolucionIva.setActProveedorIdTipo((plgTO.getActProveedorIdTipo() == null ? null : plgTO.getActProveedorIdTipo()));
                reporteAnxFunListadoDevolucionIva.setActProveedorIdNumero((plgTO.getActProveedorIdNumero() == null ? "" : plgTO.getActProveedorIdNumero()));
                reporteAnxFunListadoDevolucionIva.setActDocumentoTipo((plgTO.getActDocumentoTipo() == null ? "" : plgTO.getActDocumentoTipo()));
                reporteAnxFunListadoDevolucionIva.setActDocumentoNumero((plgTO.getActDocumentoNumero() == null ? "" : plgTO.getActDocumentoNumero()));
                reporteAnxFunListadoDevolucionIva.setActAutorizacion((plgTO.getActAutorizacion() == null ? "" : plgTO.getActAutorizacion()));
                reporteAnxFunListadoDevolucionIva.setActBase0((plgTO.getActBase0() == null ? null : plgTO.getActBase0()));
                reporteAnxFunListadoDevolucionIva.setActBaseImponible((plgTO.getActBaseImponible() == null ? null : plgTO.getActBaseImponible()));
                reporteAnxFunListadoDevolucionIva.setActIva((plgTO.getActIva() == null ? null : plgTO.getActIva()));
                reporteAnxFunListadoDevolucionIva.setActTotal((plgTO.getActTotal() == null ? null : plgTO.getActTotal()));
//                reporteListadoRetencionesVentas.setVenFecha((plgTO.getVenFecha() == null ? "" : plgTO.getVenFecha()));
//                reporteListadoRetencionesVentas.setVenIdentificacion((plgTO.getVenIdentificacion() == null ? "" : plgTO.getVenIdentificacion()));
//                reporteListadoRetencionesVentas.setVenNombre((plgTO.getVenNombre() == null ? "" : plgTO.getVenNombre()));
//                reporteListadoRetencionesVentas.setVenComprobanteTipo((plgTO.getVenComprobanteTipo() == null ? "" : plgTO.getVenComprobanteTipo()));
//                reporteListadoRetencionesVentas.setVenComprobanteNumero((plgTO.getVenComprobanteNumero() == null ? "" : plgTO.getVenComprobanteNumero()));
//                reporteListadoRetencionesVentas.setVenBaseNoObjetoIva((plgTO.getVenBaseNoObjetoIva() == null ? null : plgTO.getVenBaseNoObjetoIva()));
//                reporteListadoRetencionesVentas.setVenBase0((plgTO.getVenBase0() == null ? null : plgTO.getVenBase0()));                
//                reporteListadoRetencionesVentas.setVenBaseImponible((plgTO.getVenBaseImponible() == null ? null : plgTO.getVenBaseImponible()));
//                reporteListadoRetencionesVentas.setVenMontoIva((plgTO.getVenMontoIva() == null ? null : plgTO.getVenMontoIva()));                
//                reporteListadoRetencionesVentas.setVenValorRetenidoIva((plgTO.getVenValorRetenidoIva() == null ? null : plgTO.getVenValorRetenidoIva()));                
//                reporteListadoRetencionesVentas.setVenValorRetenidoRenta((plgTO.getVenValorRetenidoRenta() == null ? null : plgTO.getVenValorRetenidoRenta()));                                  


                lista.add(reporteAnxFunListadoDevolucionIva);
            }
            //reportListadoGrameaje
            return generarReporte(sisUsuarioEmpresaTO, "reportListadoDevolucionIva.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
