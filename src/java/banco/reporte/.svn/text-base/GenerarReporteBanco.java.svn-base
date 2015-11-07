/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.reporte;

import banco.TO.BanChequeTO;
import banco.TO.BanListaChequeTO;
import banco.TO.BanListaConciliacionBancariaTO;
import contabilidad.entity.ConDetalle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
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
public class GenerarReporteBanco implements GenerarReporteBancoLocal {

    @EJB
    OperacionesSistemaBusinessLocal operacionesSistemaBusinessLocal;

    public JasperPrint generarReporteConciliacion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, int estado, ReporteConciliacionCabecera conciliacionCabecera,
            List<BanListaConciliacionBancariaTO> listConciliacionCredito, List<BanListaConciliacionBancariaTO> listConciliacionDebito) throws Exception {
        try {
            List<ReporteConciliacion> conciliaciones = new ArrayList();
            if (estado == 0) {
                for (BanListaConciliacionBancariaTO blcbto : listConciliacionCredito) {
                    if (blcbto.getCbConciliado()) {
                        conciliaciones.add(generarReporteConciliacion(blcbto, conciliacionCabecera));
                    }
                }
                for (BanListaConciliacionBancariaTO blcbto : listConciliacionDebito) {
                    if (blcbto.getCbConciliado()) {
                        conciliaciones.add(generarReporteConciliacion(blcbto, conciliacionCabecera));
                    }
                }
            }
            if (estado == 1) {
                for (BanListaConciliacionBancariaTO blcbto : listConciliacionCredito) {
                    if (!blcbto.getCbConciliado()) {
                        conciliaciones.add(generarReporteConciliacion(blcbto, conciliacionCabecera));
                    }
                }
                for (BanListaConciliacionBancariaTO blcbto : listConciliacionDebito) {
                    if (!blcbto.getCbConciliado()) {
                        conciliaciones.add(generarReporteConciliacion(blcbto, conciliacionCabecera));
                    }
                }
            }
            if (estado == 2) {
                for (BanListaConciliacionBancariaTO blcbto : listConciliacionCredito) {
                    conciliaciones.add(generarReporteConciliacion(blcbto, conciliacionCabecera));
                }
                for (BanListaConciliacionBancariaTO blcbto : listConciliacionDebito) {
                    conciliaciones.add(generarReporteConciliacion(blcbto, conciliacionCabecera));
                }
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportConciliacion.jrxml", new HashMap(), conciliaciones);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ReporteConciliacion generarReporteConciliacion(BanListaConciliacionBancariaTO blcbto, ReporteConciliacionCabecera cabecera) throws Exception {
        ReporteConciliacion conciliacion = new ReporteConciliacion();
        conciliacion.setCbContable(blcbto.getCbContable());
        conciliacion.setCbFecha(blcbto.getCbFecha());
        conciliacion.setCbDocumento(blcbto.getCbDocumento());
        conciliacion.setCbValor(blcbto.getCbValor());
        conciliacion.setCbObservaciones(blcbto.getCbObservaciones());
        conciliacion.setCbMarcaConciliado(blcbto.getCbConciliado() == true ? "*" : " ");
        conciliacion.setCbDC(String.valueOf(blcbto.getCbDc()));

        conciliacion.setConcHasta(cabecera.getConcHasta());
        conciliacion.setConcCodigoConciliacion(cabecera.getConcCodigoConciliacion());
        conciliacion.setConcBanco(cabecera.getConcBanco());
        conciliacion.setConcCuentaContable(cabecera.getConcCuentaContable());
        conciliacion.setConcCuentaBancaria(cabecera.getConcCuentaBancaria());
        conciliacion.setConcTitular(cabecera.getConcTitular());

        conciliacion.setConcSaldoEstadoCuenta(cabecera.getConcSaldoEstadoCuenta());
        conciliacion.setConcChequesEnTransito(cabecera.getConcChequesEnTransito());
        conciliacion.setConcDepositosEnTransito(cabecera.getConcDepositosEnTransito());
        conciliacion.setConcSaldoSistema(cabecera.getConcSaldoSistema());
        conciliacion.setConcDiferenciaNoConciliada(cabecera.getConcDiferenciaNoConciliada());
        return conciliacion;
    }

    public JasperPrint generarReporteListadoChequeEmisionVencimientoCobrarNumero(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String cuenta, String desde, String hasta, String tipo,
            List<BanListaChequeTO> listBanListaChequeTO) throws Exception {
        try {
            List<ReporteListadoChequeEmisionVencimientoCobrarNumero> reporteListadoChequeEmisionVencimientoCobrarNumeros = new ArrayList();
            for (BanListaChequeTO blcto : listBanListaChequeTO) {
                ReporteListadoChequeEmisionVencimientoCobrarNumero reporteListadoChequeEmisionVencimientoCobrarNumero = new ReporteListadoChequeEmisionVencimientoCobrarNumero(cuenta, desde, hasta, tipo,
                        blcto.getChqCuentaCodigo(),
                        blcto.getChqCuentaDetalle(),
                        blcto.getChqBeneficiario(),
                        blcto.getChqNumero(),
                        blcto.getChqValor(),
                        blcto.getChqFechaEmision(),
                        blcto.getChqFechaVencimiento(),
                        blcto.getChqContablePeriodo() == null ? null : blcto.getChqContablePeriodo().substring(0, blcto.getChqContablePeriodo().lastIndexOf("|")),
                        blcto.getChqContableTipo() == null ? null : blcto.getChqContableTipo().substring(0, blcto.getChqContableTipo().lastIndexOf("|")),
                        blcto.getChqContableNumero(),
                        blcto.getChqSecuencia(),
                        blcto.getChqOrden());
                reporteListadoChequeEmisionVencimientoCobrarNumeros.add(reporteListadoChequeEmisionVencimientoCobrarNumero);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportListadoChequeEVCN.jrxml", new HashMap(), reporteListadoChequeEmisionVencimientoCobrarNumeros);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T> JasperPrint generarReporte(SisUsuarioEmpresaTO sisUsuario, 
            String nombreReporte, Map parametros, List<T> list) throws Exception {
        try {
            
            String rutaReportes = getRutaReportes() + "banco/";

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

    public JasperPrint generarReporteCheque(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            BanChequeTO banChequeTO, String valorLetra1, String valorLetra2, 
            String nombreReporteCheque, ConDetalle conDetalle, String cuentaCodigo) throws Exception 
    {
        try {
            List<ObjetoCheque> lista = new ArrayList();
            ObjetoCheque objetoCheque = new ObjetoCheque();
            objetoCheque.setChqBeneficiario(banChequeTO.getChqBeneficiario());

            String asteriscos = "";
            for (int i = banChequeTO.getChqCantidad().trim().length(); i < 11; i++) {
                asteriscos += "*";
            }
            objetoCheque.setChqCantidad(asteriscos + banChequeTO.getChqCantidad().trim());
            objetoCheque.setChqCiudad(banChequeTO.getChqCiudad());
            objetoCheque.setChqCuenta(cuentaCodigo);
            objetoCheque.setChqEmpresa(conDetalle.getConContable().getUsrEmpresa() == null ? "" : conDetalle.getConContable().getUsrEmpresa());
            objetoCheque.setChqEntregado(banChequeTO.isChqEntregado());
            objetoCheque.setChqFecha(banChequeTO.getChqFecha());
            objetoCheque.setChqImpreso(banChequeTO.isChqImpreso());
            objetoCheque.setConcCodigo(banChequeTO.getConcCodigo());
            objetoCheque.setConcCuentaContable(banChequeTO.getConcCuentaContable());
            objetoCheque.setConcEmpresa(banChequeTO.getConcEmpresa());
            objetoCheque.setCtaCuentaContable(conDetalle.getConCuentas().getConCuentasPK().getCtaCodigo() == null ? "" : conDetalle.getConCuentas().getConCuentasPK().getCtaCodigo());
            objetoCheque.setCtaEmpresa(conDetalle.getConCuentas().getConCuentasPK().getCtaEmpresa() == null ? "" : conDetalle.getConCuentas().getConCuentasPK().getCtaEmpresa());

            objetoCheque.setValorLetra1(valorLetra1);
            objetoCheque.setValorLetra2(valorLetra2);

            lista.add(objetoCheque);

             String ruta = getRutaReportes() + "banco/"+nombreReporteCheque + ".jrxml";
            
            JasperReport jReporte = JasperCompileManager.compileReport(JRXmlLoader.load(ruta));
            return JasperFillManager.fillReport(jReporte, null, new JRBeanCollectionDataSource(lista));
            
        } catch (Exception e) {
             e.printStackTrace();
            return null;
        }
    }
}
