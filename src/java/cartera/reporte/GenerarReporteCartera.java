/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.reporte;

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
public class GenerarReporteCartera implements GenerarReporteCarteraLocal {

    @EJB
    OperacionesSistemaBusinessLocal operacionesSistemaBusinessLocal;

    public JasperPrint generarReporteCuentasPorCobrarDetallado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorCobrarDetallado> reporteCuentasPorCobrarDetallado) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCuentasPorCobrarDetallado.jrxml", new HashMap(), reporteCuentasPorCobrarDetallado);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCuentasPorPagarDetallado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarDetallado> reporteCuentasPorPagarDetallado) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCuentasPorPagarDetallado.jrxml", new HashMap(), reporteCuentasPorPagarDetallado);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCuentasPorCobrarGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorCobrarGeneral> reporteCuentasPorCobrarGeneral) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCuentasPorCobrarGeneral.jrxml", new HashMap(), reporteCuentasPorCobrarGeneral);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCarFunCuentasPorCobrarListadoVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCarFunCuentasPorCobrarListadoVentas> reporteCarFunCuentasPorCobrarListadoVentas) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCarFunCuentasPorCobrarListadoVentas.jrxml", new HashMap(), reporteCarFunCuentasPorCobrarListadoVentas);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCarFunCuentasPorPagarListadoCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCarFunCuentasPorPagarListadoCompras> reporteCarFunCuentasPorPagarListadoCompras) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCarFunCuentasPorPagarListadoCompras.jrxml", new HashMap(), reporteCarFunCuentasPorPagarListadoCompras);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCuentasPorPagarGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarGeneral> reporteCuentasPorPagarGeneral) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCuentasPorPagarGeneral.jrxml", new HashMap(), reporteCuentasPorPagarGeneral);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCuentasPorPagarAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarAnticipos> reporteCuentasPorPagarAnticipos) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCuentasPorPagarAnticipos.jrxml", new HashMap(), reporteCuentasPorPagarAnticipos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCuentasPorPagarSaldoAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarCobrarSaldoAnticipos> reporteCuentasPorPagarSaldoAnticipos) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCuentasPorPagarSaldoAnticipos.jrxml", new HashMap(), reporteCuentasPorPagarSaldoAnticipos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCuentasPorCobrarSaldoAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarCobrarSaldoAnticipos> reporteCuentasPorPagarSaldoAnticipos) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCuentasPorCobrarSaldoAnticipos.jrxml", new HashMap(), reporteCuentasPorPagarSaldoAnticipos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCuentasPorCobrarAnticipos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCuentasPorPagarAnticipos> reporteCuentasPorPagarAnticipos) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCuentasPorCobrarAnticipos.jrxml", new HashMap(), reporteCuentasPorPagarAnticipos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCobros(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteCobros> reporteCobros) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportCobros.jrxml", new HashMap(), reporteCobros);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReportePagos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReportePagos> reportePagos) throws Exception {
        try {
            System.out.println("jjjjjjjj");
            return generarReporte(sisUsuarioEmpresaTO, "reportPagos.jrxml", new HashMap(), reportePagos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteMayorAuxiliarProveedorCliente(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteMayorAuxiliarProveedorCliente> reporteMayorAuxiliarProveedorCliente) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportMayorAuxiliarProveedorCliente.jrxml", new HashMap(), reporteMayorAuxiliarProveedorCliente);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListadoPagos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteListadoPagos> reporteListadoPagos) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportListadoPago.jrxml", new HashMap(), reporteListadoPagos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListadoCobros(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteListadoCobros> reporteListadoCobros) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportListadoCobro.jrxml", new HashMap(), reporteListadoCobros);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T> JasperPrint generarReporte(SisUsuarioEmpresaTO sisUsuario, String nombreReporte, Map parametros, List<T> list) throws Exception {
        try {
            String rutaReportes = getRutaReportes() + "cartera/";
            System.out.println("ruta repot cartera: "+rutaReportes+nombreReporte);
            parametros.put("SUBREPORT_DIR", rutaReportes);
            parametros.put("p_empresa_nombre", sisUsuario.getEmpNombre());
            parametros.put("p_empresa_ruc", sisUsuario.getEmpRuc());
            parametros.put("p_empresa_direccion", sisUsuario.getEmpDireccion());
            parametros.put("p_empresa_telefono", sisUsuario.getEmpTelefono());
            parametros.put("p_usuario_nick", sisUsuario.getUsrNick());
            parametros.put("p_fecha_hora", Validacion.fechaSistema());
            for (T t : list) {
                System.out.println("fffffffff   "+t.toString());
            }
            return JasperFillManager.fillReport(JasperCompileManager.compileReport(JRXmlLoader.load(rutaReportes + nombreReporte)),
                    parametros, new JRBeanCollectionDataSource(list));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
