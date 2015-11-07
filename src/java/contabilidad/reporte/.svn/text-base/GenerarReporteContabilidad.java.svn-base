/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.reporte;

import contabilidad.TO.*;
import inventario.reporte.ReporteCompraDetalle;
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
public class GenerarReporteContabilidad implements GenerarReporteContabilidadLocal {

    @EJB
    OperacionesSistemaBusinessLocal operacionesSistemaBusinessLocal;

    
    private <T> JasperPrint generarReporte(SisUsuarioEmpresaTO sisUsuario, String nombreReporte, Map parametros, List<T> list) throws Exception {
        try {
            String rutaReportes = getRutaReportes() + "contabilidad/";
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
    
    public JasperPrint generarReporteContableDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ConContableReporteTO> listConContableReporteTO) throws Exception {
        try {
            //List<ReporteContableDetalle> listReporteContableDetalle = new ArrayList<ReporteContableDetalle>();            
            //ReporteContabilidad reporteContabilidad = new ReporteContabilidad();
            List<ReporteContableDetalle> listReporteContableDetalle = ReporteContabilidad.generarColeccionContableDetalle(sisUsuarioEmpresaTO, listConContableReporteTO);
            return generarReporte(sisUsuarioEmpresaTO, "reportComprobanteContable.jrxml", new HashMap(), listReporteContableDetalle);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteMayorAuxiliar(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String cuentaContable, String cuentaContablePadre, List<ConMayorAuxiliarTO> listConMayorAuxiliarTO) throws Exception {
        try {
            List<ReporteMayorAuxiliar> listaReporteMayorAuxiliarParametro = new ArrayList();
            for (ConMayorAuxiliarTO cma : listConMayorAuxiliarTO) {
                ReporteMayorAuxiliar reporteMayorAuxiliar = new ReporteMayorAuxiliar();
                reporteMayorAuxiliar.setFechaDesde(fechaDesde);
                reporteMayorAuxiliar.setFechaHasta(fechaHasta);
                reporteMayorAuxiliar.setCuentaContable(cuentaContable);
                reporteMayorAuxiliar.setCuentaContablePadre(cuentaContablePadre);
                reporteMayorAuxiliar.setMaContable(cma.getMaContable());
                reporteMayorAuxiliar.setMaFecha(cma.getMaFecha());
                reporteMayorAuxiliar.setMaSecuencia(cma.getMaSecuencia());
                reporteMayorAuxiliar.setMaCuenta(cma.getMaCuenta());
                reporteMayorAuxiliar.setMaCP(cma.getMaCP());
                reporteMayorAuxiliar.setMaCC(cma.getMaCC());
                reporteMayorAuxiliar.setMaDocumento(cma.getMaDocumento());
                reporteMayorAuxiliar.setMaDebe(cma.getMaDebe());
                reporteMayorAuxiliar.setMaHaber(cma.getMaHaber());
                reporteMayorAuxiliar.setMaSaldo(cma.getMaSaldo());
                reporteMayorAuxiliar.setMaObservaciones(cma.getMaObservaciones());
                reporteMayorAuxiliar.setMaGenerado(cma.getMaGenerado());
                reporteMayorAuxiliar.setMaReferencia(cma.getMaReferencia());
                reporteMayorAuxiliar.setMaOrden(cma.getMaOrden());
                listaReporteMayorAuxiliarParametro.add(reporteMayorAuxiliar);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportContabilidadMayorAuxiliar.jrxml", new HashMap(), listaReporteMayorAuxiliarParametro);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteMayorGeneral(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta, String cuentaContable, 
            Object[][] datos) throws Exception {
        try {
            List<ReporteMayorGeneral> listaReporteMayorGeneralParametro = new ArrayList();
            for (int i = 0; i < datos.length; i++) {
                ReporteMayorGeneral reporteMayorGeneral = new ReporteMayorGeneral();
                reporteMayorGeneral.setFechaHasta(fechaHasta);
                reporteMayorGeneral.setCuentaContable(cuentaContable);
                reporteMayorGeneral.setBgCuenta(  datos[i][0] != null ? datos[i][0].toString() : ""  );
                reporteMayorGeneral.setBgDetalle(datos[i][1] != null ? datos[i][1].toString() : "" );
                reporteMayorGeneral.setBgSaldo6(  new java.math.BigDecimal(datos[i][2] != null ? datos[i][2].toString() : "0.00")  );
                reporteMayorGeneral.setBgSaldo5(new java.math.BigDecimal(datos[i][3] != null ? datos[i][3].toString() : "0.00"));
                if (datos.length >=125){
                    reporteMayorGeneral.setBgSaldo4(new java.math.BigDecimal(datos[i][4] != null ? datos[i][4].toString() : "0.00"));
                }
                if(datos.length >=205){
                    reporteMayorGeneral.setBgSaldo3(new java.math.BigDecimal(datos[i][5] != null ? datos[i][5].toString() : "0.00"));
                }
                if(datos.length >=311){
                    reporteMayorGeneral.setBgSaldo2(new java.math.BigDecimal(datos[i][6] != null ? datos[i][6].toString() : "0.00"));
                }
                if(datos.length >=311){
                    reporteMayorGeneral.setBgSaldo1(new java.math.BigDecimal(datos[i][7] != null ? datos[i][7].toString() : "0.00"));
                }  
                listaReporteMayorGeneralParametro.add(reporteMayorGeneral);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportContabilidadMayorGeneral.jrxml", new HashMap(), listaReporteMayorGeneralParametro);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public JasperPrint generarReporteMayorGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            String cuentaContable, List<ConMayorGeneralTO> listConMayorGeneralTO) throws Exception {
        try {
            List<ReporteMayorGeneral> listaReporteMayorGeneralParametro = new ArrayList();
            for (ConMayorGeneralTO cmgto : listConMayorGeneralTO) {
                ReporteMayorGeneral reporteMayorGeneral = new ReporteMayorGeneral();
                reporteMayorGeneral.setFechaHasta(fechaHasta);
                reporteMayorGeneral.setCuentaContable(cuentaContable);
                reporteMayorGeneral.setBgCuenta(cmgto.getBgCuenta());
                reporteMayorGeneral.setBgDetalle(cmgto.getBgDetalle());
                reporteMayorGeneral.setBgSaldo6(cmgto.getBgSaldo6());
                reporteMayorGeneral.setBgSaldo5(cmgto.getBgSaldo5());
                reporteMayorGeneral.setBgSaldo4(cmgto.getBgSaldo4());
                reporteMayorGeneral.setBgSaldo3(cmgto.getBgSaldo3());
                reporteMayorGeneral.setBgSaldo2(cmgto.getBgSaldo2());
                reporteMayorGeneral.setBgSaldo1(cmgto.getBgSaldo1());
                listaReporteMayorGeneralParametro.add(reporteMayorGeneral);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportContabilidadMayorGeneral.jrxml", new HashMap(), listaReporteMayorGeneralParametro);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JasperPrint generarReporteDiarioAuxiliar(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String codigoTipo, List<ConDiarioAuxiliarTO> listConDiarioAuxiliarTO) throws Exception {
        try {
            List<ReporteDiarioAuxiliar> listaReporteDiarioAuxiliar = new ArrayList();
            for (ConDiarioAuxiliarTO cdato : listConDiarioAuxiliarTO) {
                ReporteDiarioAuxiliar reporteDiarioAuxiliar = new ReporteDiarioAuxiliar();
                reporteDiarioAuxiliar.setCodigoTipo(codigoTipo);
                reporteDiarioAuxiliar.setFechaDesde(fechaDesde);
                reporteDiarioAuxiliar.setFechaHasta(fechaHasta);
                reporteDiarioAuxiliar.setDaOrden(cdato.getDaOrden());
                reporteDiarioAuxiliar.setDaCuenta(cdato.getDaCuenta());
                reporteDiarioAuxiliar.setDaDetalle(cdato.getDaDetalle());
                reporteDiarioAuxiliar.setDaCP(cdato.getDaCP());
                reporteDiarioAuxiliar.setDaCC(cdato.getDaCC());
                reporteDiarioAuxiliar.setDaDocumento(cdato.getDaDocumento());
                reporteDiarioAuxiliar.setDaDebe(cdato.getDaDebe());
                reporteDiarioAuxiliar.setDaDHaber(cdato.getDaDHaber());
                listaReporteDiarioAuxiliar.add(reporteDiarioAuxiliar);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportContabilidadDiarioGeneral.jrxml", new HashMap(), listaReporteDiarioAuxiliar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JasperPrint generarReporteBalanceComprobacion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, List<ConBalanceComprobacionTO> listConBalanceComprobacionTO) throws Exception {
        try {
            List<ReporteBalanceComprobacion> listaReporteBalanceComprobacion = new ArrayList();
            for (ConBalanceComprobacionTO cbcto : listConBalanceComprobacionTO) {
                ReporteBalanceComprobacion reporteBalanceComprobacion = new ReporteBalanceComprobacion();
                reporteBalanceComprobacion.setFechaDesde(fechaDesde);
                reporteBalanceComprobacion.setFechaHasta(fechaHasta);
                reporteBalanceComprobacion.setBcCuenta(cbcto.getBcCuenta());
                reporteBalanceComprobacion.setBcDetalle(cbcto.getBcDetalle());
                reporteBalanceComprobacion.setBcSaldoAnterior(cbcto.getBcSaldoAnterior());
                reporteBalanceComprobacion.setBcTotalDebito(cbcto.getBcTotalDebito());
                reporteBalanceComprobacion.setBcTotalCredito(cbcto.getBcTotalCredito());
                reporteBalanceComprobacion.setBcSaldoFinal(cbcto.getBcSaldoFinal());
                listaReporteBalanceComprobacion.add(reporteBalanceComprobacion);
            }
            Map parametros = new HashMap();
            parametros.put("p_contador", sisUsuarioEmpresaTO.getEmpContador());
            parametros.put("p_gerente", sisUsuarioEmpresaTO.getEmpGerente());
            return generarReporte(sisUsuarioEmpresaTO, "reportContabilidadBalanceComprobacion.jrxml", parametros, listaReporteBalanceComprobacion);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JasperPrint generarReporteBalanceGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            String codigoSector, List<ConFunBalanceGeneralNecTO> listConFunBalanceGeneralNecTO, List<ConBalanceGeneralTO> listConBalanceGeneralTO) throws Exception {
        try {
            List<ReporteBalanceGeneral> listaReporteBalanceGeneral = new ArrayList();
            if (listConFunBalanceGeneralNecTO != null) {
                for (ConFunBalanceGeneralNecTO cfbgnto : listConFunBalanceGeneralNecTO) {
                    ReporteBalanceGeneral reporteBalanceGeneral = new ReporteBalanceGeneral();
                    reporteBalanceGeneral.setCodigoCP(codigoSector);
                    reporteBalanceGeneral.setFechaHasta(fechaHasta);
                    reporteBalanceGeneral.setBgCuenta(cfbgnto.getBgCuenta());
                    reporteBalanceGeneral.setBgDetalle(cfbgnto.getBgDetalle());
                    reporteBalanceGeneral.setBgSaldo1(cfbgnto.getBgSaldo1());
                    reporteBalanceGeneral.setBgSaldo2(cfbgnto.getBgSaldo2());
                    reporteBalanceGeneral.setBgSaldo3(cfbgnto.getBgSaldo3());
                    reporteBalanceGeneral.setBgSaldo4(cfbgnto.getBgSaldo4());
                    reporteBalanceGeneral.setBgSaldo5(cfbgnto.getBgSaldo5());
                    reporteBalanceGeneral.setBgSaldo6(cfbgnto.getBgSaldo6());
                    listaReporteBalanceGeneral.add(reporteBalanceGeneral);
                }
            } else if (listConBalanceGeneralTO != null) {
                for (ConBalanceGeneralTO cbgto : listConBalanceGeneralTO) {
                    ReporteBalanceGeneral reporteBalanceGeneral = new ReporteBalanceGeneral();
                    reporteBalanceGeneral.setCodigoCP(codigoSector);
                    reporteBalanceGeneral.setFechaHasta(fechaHasta);
                    reporteBalanceGeneral.setBgCuenta(cbgto.getBgCuenta());
                    reporteBalanceGeneral.setBgDetalle(cbgto.getBgDetalle());
                    reporteBalanceGeneral.setBgSaldo1(cbgto.getBgSaldo());
                    listaReporteBalanceGeneral.add(reporteBalanceGeneral);
                }
            }
            Map parametros = new HashMap();
            parametros.put("p_contador", sisUsuarioEmpresaTO.getEmpContador());
            parametros.put("p_gerente", sisUsuarioEmpresaTO.getEmpGerente());
            return generarReporte(sisUsuarioEmpresaTO, "reportContabilidadBalanceGeneral.jrxml", parametros, listaReporteBalanceGeneral);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JasperPrint generarReporteBalanceGeneralComparativo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaAnterior, String fechaActual,
            String codigoSector, List<ConBalanceGeneralComparativoTO> listConBalanceGeneralComparativoTO) throws Exception {
        try {
            List<ReporteBalanceGeneralComparativo> listaReporteBalanceGeneralComparativos = new ArrayList();
            for (ConBalanceGeneralComparativoTO cbgcto : listConBalanceGeneralComparativoTO) {
                ReporteBalanceGeneralComparativo reporteBalanceGeneralComparativo = new ReporteBalanceGeneralComparativo();
                reporteBalanceGeneralComparativo.setCodigoCP(codigoSector);
                reporteBalanceGeneralComparativo.setFechaAnterior(fechaAnterior);
                reporteBalanceGeneralComparativo.setFechaActual(fechaActual);
                reporteBalanceGeneralComparativo.setBgCuenta(cbgcto.getBgCuenta());
                reporteBalanceGeneralComparativo.setBgDetalle(cbgcto.getBgDetalle());
                reporteBalanceGeneralComparativo.setBgSaldoAnterior(cbgcto.getBgSaldoAnterior());
                reporteBalanceGeneralComparativo.setBgSaldoActual(cbgcto.getBgSaldoActual());
                listaReporteBalanceGeneralComparativos.add(reporteBalanceGeneralComparativo);
            }

            Map parametros = new HashMap();
            parametros.put("p_contador", sisUsuarioEmpresaTO.getEmpContador());
            parametros.put("p_gerente", sisUsuarioEmpresaTO.getEmpGerente());
            return generarReporte(sisUsuarioEmpresaTO, "reportContabilidadBalanceGeneralComparativo.jrxml", parametros, listaReporteBalanceGeneralComparativos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JasperPrint generarReporteBalanceResultado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String codigoSector, Integer columnasEstadosFinancieros, List<ConFunBalanceResultadosNecTO> listConFunBalanceResultadosNecTO) throws Exception {
        try {
            List<ReporteConFunBalanceResultadosNec> reporteConFunBalanceResultadosNecs = new ArrayList();
            for (ConFunBalanceResultadosNecTO cfbrnto : listConFunBalanceResultadosNecTO) {
                ReporteConFunBalanceResultadosNec reporteConFunBalanceResultadosNec = new ReporteConFunBalanceResultadosNec();
                reporteConFunBalanceResultadosNec.setFechaDesde(fechaDesde);
                reporteConFunBalanceResultadosNec.setFechaHasta(fechaHasta);
                reporteConFunBalanceResultadosNec.setCodigoCP(codigoSector);
                reporteConFunBalanceResultadosNec.setBrCuenta(cfbrnto.getBrCuenta());
                reporteConFunBalanceResultadosNec.setBrDetalle(cfbrnto.getBrDetalle());
                reporteConFunBalanceResultadosNec.setBrSaldo1(cfbrnto.getBrSaldo1());
                reporteConFunBalanceResultadosNec.setBrSaldo2(cfbrnto.getBrSaldo2());
                reporteConFunBalanceResultadosNec.setBrSaldo3(cfbrnto.getBrSaldo3());
                reporteConFunBalanceResultadosNec.setBrSaldo4(cfbrnto.getBrSaldo4());
                reporteConFunBalanceResultadosNec.setBrSaldo5(cfbrnto.getBrSaldo5());
                reporteConFunBalanceResultadosNec.setBrSaldo6(cfbrnto.getBrSaldo6());
                reporteConFunBalanceResultadosNecs.add(reporteConFunBalanceResultadosNec);
            }

            Map parametros = new HashMap();
            parametros.put("p_contador", sisUsuarioEmpresaTO.getEmpContador());
            parametros.put("p_gerente", sisUsuarioEmpresaTO.getEmpGerente());
            return generarReporte(sisUsuarioEmpresaTO, columnasEstadosFinancieros == 0 ? "reportContabilidadBalanceResultadosNec.jrxml" : "reportContabilidadBalanceResultados.jrxml",
                    parametros, reporteConFunBalanceResultadosNecs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JasperPrint generarReporteContablesVerificacionesCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<ConFunContablesVerificacionesComprasTO> listConFunContablesVerificacionesComprasTO) throws Exception {
        try {
            List<ReporteFunContablesVerificacionesCompras> listaFunContablesVerificacionesComprases = new ArrayList();
            for (ConFunContablesVerificacionesComprasTO cfcvcto : listConFunContablesVerificacionesComprasTO) {
                ReporteFunContablesVerificacionesCompras reporteFunContablesVerificacionesCompras = new ReporteFunContablesVerificacionesCompras();
                reporteFunContablesVerificacionesCompras.setFechaDesde(fechaDesde);
                reporteFunContablesVerificacionesCompras.setFechaHasta(fechaHasta);
                reporteFunContablesVerificacionesCompras.setContabilidadFecha(cfcvcto.getContabilidadFecha());
                reporteFunContablesVerificacionesCompras.setContabilidadSecuencial(cfcvcto.getContabilidadSecuencial());
                reporteFunContablesVerificacionesCompras.setInventarioFecha(cfcvcto.getInventarioFecha());
                reporteFunContablesVerificacionesCompras.setInventarioMonto(cfcvcto.getInventarioMonto());
                reporteFunContablesVerificacionesCompras.setInventarioSecuencial(cfcvcto.getInventarioSecuencial());
                reporteFunContablesVerificacionesCompras.setInventarioObservacion(cfcvcto.getInventarioObservacion());
                listaFunContablesVerificacionesComprases.add(reporteFunContablesVerificacionesCompras);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reporteFunContablesVerificacionesCompras.jrxml",
                    new HashMap(), listaFunContablesVerificacionesComprases);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JasperPrint generarReporteConListaBalanceResultadosVsInventario(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<ConListaBalanceResultadosVsInventarioTO> listConListaBalanceResultadosVsInventarioTO) throws Exception {
        try {
            List<ReporteConListaBalanceResultadosVsInventario> lista = new ArrayList();
            for (ConListaBalanceResultadosVsInventarioTO clbrvito : listConListaBalanceResultadosVsInventarioTO) {
                ReporteConListaBalanceResultadosVsInventario reporteSaldoBodegaDetallado = new ReporteConListaBalanceResultadosVsInventario(fechaDesde, fechaHasta,
                        clbrvito.getVriCuentaContable() == null ? "" : clbrvito.getVriCuentaContable(),
                        clbrvito.getVriNombre() == null ? "" : clbrvito.getVriNombre(),
                        clbrvito.getVriSaldoContable(), clbrvito.getVriInventarioInicial(),
                        clbrvito.getVriDiferencia());
                lista.add(reporteSaldoBodegaDetallado);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportBalanceResultadoVSInventario.jrxml",
                    new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JasperPrint generarReporteContablesVerificacionesErrores(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ConFunContablesVerificacionesTO> listConFunContablesVerificacionesTO) throws Exception {
        try {
            List<ReporteContablesVerificacion> lista = new ArrayList();
            for (ConFunContablesVerificacionesTO cfcvto : listConFunContablesVerificacionesTO) {
                ReporteContablesVerificacion reporteContablesVerificacion = new ReporteContablesVerificacion();
                reporteContablesVerificacion.setVcPeriodo(cfcvto.getVcPeriodo());
                reporteContablesVerificacion.setVcTipo(cfcvto.getVcTipo());
                reporteContablesVerificacion.setVcNumero(cfcvto.getVcNumero());
                reporteContablesVerificacion.setVcFecha(cfcvto.getVcFecha());
                reporteContablesVerificacion.setVcPendiente(cfcvto.getVcPendiente() ? "Sí" : "No");
                reporteContablesVerificacion.setVcBloqueado(cfcvto.getVcBloqueado() ? "Sí" : "No");
                reporteContablesVerificacion.setVcAnulado(cfcvto.getVcAnulado() ? "Sí" : "No");
                reporteContablesVerificacion.setVcDebitos(cfcvto.getVcDebitos());
                reporteContablesVerificacion.setVcCreditos(cfcvto.getVcCreditos());
                reporteContablesVerificacion.setVcObservaciones(cfcvto.getVcObservaciones());
                lista.add(reporteContablesVerificacion);
            }

            return generarReporte(sisUsuarioEmpresaTO, "ReporteContablesVerificacionesErrores.jrxml",
                    new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }


    public JasperPrint generarReporteCompraContableDetalle(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<ReporteCompraDetalle> reporteCompraDetalles, 
            List<ConContableReporteTO> list) throws Exception 
    {
        try {
//            List<Object> listReporteCompraContabilidad = new ArrayList<Object>();
//            listReporteCompraContabilidad.add(reporteCompraDetalles);                                  
                        
            
            List<ReporteCompraContableDetalle> listReporteCompraContableDetalle = new ArrayList<ReporteCompraContableDetalle>();         
            ReporteCompraContableDetalle reporteCompraContableDetalle= new ReporteCompraContableDetalle();
            for (ConContableReporteTO ccrto : list)
            {
                if (ccrto != null) {
                    for (int i = 0; i < ccrto.getListConDetalleTablaTO().size(); i++) {
                        
                        ///////////TITULO REPORTE
                        reporteCompraContableDetalle.setTitulo(ccrto.getTitulo());
                        ///////////CABECERA
                        reporteCompraContableDetalle.setEmpCodigo(ccrto.getConContableTO().getEmpCodigo());
                        reporteCompraContableDetalle.setPerCodigo(ccrto.getConContableTO().getPerCodigo());
                        reporteCompraContableDetalle.setTipCodigo(ccrto.getConContableTO().getTipCodigo());
                        reporteCompraContableDetalle.setConNumero(ccrto.getConContableTO().getConNumero());
                        reporteCompraContableDetalle.setConFecha(ccrto.getConContableTO().getConFecha());
                        reporteCompraContableDetalle.setConPendiente(ccrto.getConContableTO().getConPendiente());
                        reporteCompraContableDetalle.setConRevisado(ccrto.getConContableTO().getConAnulado());
                        reporteCompraContableDetalle.setConAnulado(ccrto.getConContableTO().getConAnulado());
                        reporteCompraContableDetalle.setConGenerado(ccrto.getConContableTO().getConGenerado());
                        reporteCompraContableDetalle.setConConcepto(ccrto.getConContableTO().getConConcepto());
                        reporteCompraContableDetalle.setConDetalle(ccrto.getConContableTO().getConDetalle());
                        reporteCompraContableDetalle.setConObservaciones(ccrto.getConContableTO().getConObservaciones());
                        reporteCompraContableDetalle.setUsrInserta(ccrto.getConContableTO().getUsrInsertaContable());
                        reporteCompraContableDetalle.setUsrFechaInserta(ccrto.getConContableTO().getUsrFechaInsertaContable());

                        reporteCompraContableDetalle.setImpElaborado(operacionesSistemaBusinessLocal.getUsuarioNombreApellido(sisUsuarioEmpresaTO.getEmpCodigo(), ccrto.getConContableTO().getUsrInsertaContable()));

                        reporteCompraContableDetalle.setImpAprobado(sisUsuarioEmpresaTO.getEmpGerente());
                        reporteCompraContableDetalle.setImpRevisado("");
                        reporteCompraContableDetalle.setImpContabilidad(sisUsuarioEmpresaTO.getEmpContador());
                        /////////////DETALLE
                        reporteCompraContableDetalle.setConCtaCodigoPadre(ccrto.getCuentaPadre().get(i).trim().toString().substring(0, ccrto.getCuentaPadre().get(i).trim().toString().indexOf("|")).trim());
                        reporteCompraContableDetalle.setConNombreCuentaPadre(ccrto.getCuentaPadre().get(i).trim().toString().substring(ccrto.getCuentaPadre().get(i).trim().toString().indexOf("|") + 1).trim());
                        reporteCompraContableDetalle.setConCtaCodigo(ccrto.getListConDetalleTablaTO().get(i).getCtaCodigo());
                        reporteCompraContableDetalle.setConNombreCuenta(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalle());
                        reporteCompraContableDetalle.setDetCentroProduccion(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleCentroProduccion());
                        reporteCompraContableDetalle.setDetCentroCosto(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleCentroCosto() == null ? "" : ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleCentroCosto());
                        reporteCompraContableDetalle.setDetDocumento(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleDocumento() == null ? "" : ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleDocumento());
                        if (ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleDebitoCredito() == 'D') {
                            reporteCompraContableDetalle.setDetDebitoCredito('D');
                            reporteCompraContableDetalle.setDetValor(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleValor());
                        } else {
                            reporteCompraContableDetalle.setDetDebitoCredito('C');
                            reporteCompraContableDetalle.setDetValor(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleValor());
                        }
                        reporteCompraContableDetalle.setDetGenerado(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleGenerado());
                        reporteCompraContableDetalle.setDetReferencia(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleReferencia());
                        reporteCompraContableDetalle.setDetOrden(i + 1);    
                        
                       
                        
                        ////////////////////////////////////////Compras Detalle
                        reporteCompraContableDetalle.setMotCodigo(reporteCompraDetalles.get(0).getMotCodigo());
                        reporteCompraContableDetalle.setCompNumero(reporteCompraDetalles.get(0).getCompNumero());
                        reporteCompraContableDetalle.setCompNumeroAlterno(reporteCompraDetalles.get(0).getCompNumeroAlterno());
                        reporteCompraContableDetalle.setCompDocumentoTipo(reporteCompraDetalles.get(0).getCompDocumentoTipo());
                        reporteCompraContableDetalle.setCompDocumentoNumero(reporteCompraDetalles.get(0).getCompDocumentoNumero());
                        reporteCompraContableDetalle.setProvCodigo(reporteCompraDetalles.get(0).getProvCodigo());
                        reporteCompraContableDetalle.setProvNombre(reporteCompraDetalles.get(0).getProvNombre());
                        reporteCompraContableDetalle.setCompFecha(reporteCompraDetalles.get(0).getCompFecha());
                        reporteCompraContableDetalle.setCompFechaVencimiento(reporteCompraDetalles.get(0).getCompFechaVencimiento());
                        reporteCompraContableDetalle.setCompIvaVigente(reporteCompraDetalles.get(0).getCompIvaVigente());
                        reporteCompraContableDetalle.setCompObservaciones(reporteCompraDetalles.get(0).getCompObservaciones());
                        reporteCompraContableDetalle.setCompPendiente(reporteCompraDetalles.get(0).getCompPendiente());
                        reporteCompraContableDetalle.setCompRevisado(reporteCompraDetalles.get(0).getCompRevisado());
                        reporteCompraContableDetalle.setCompAnulado(reporteCompraDetalles.get(0).getCompAnulado());
                        reporteCompraContableDetalle.setCompFormaPago(reporteCompraDetalles.get(0).getCompFormaPago());
                        reporteCompraContableDetalle.setCompBase0(reporteCompraDetalles.get(0).getCompBase0());
                        reporteCompraContableDetalle.setCompBaseimponible(reporteCompraDetalles.get(0).getCompBaseimponible());
                        reporteCompraContableDetalle.setCompMontoiva(reporteCompraDetalles.get(0).getCompMontoiva());
                        reporteCompraContableDetalle.setCompTotal(reporteCompraDetalles.get(0).getCompTotal());
                        reporteCompraContableDetalle.setCompValorretenido(reporteCompraDetalles.get(0).getCompValorretenido());
                        reporteCompraContableDetalle.setCompSaldo(reporteCompraDetalles.get(0).getCompSaldo());
                        reporteCompraContableDetalle.setCodigoSector(reporteCompraDetalles.get(0).getCodigoSector());
                        reporteCompraContableDetalle.setContPeriodo(reporteCompraDetalles.get(0).getContPeriodo());
                        reporteCompraContableDetalle.setContTipo(reporteCompraDetalles.get(0).getContTipo());
                        reporteCompraContableDetalle.setContNumero(reporteCompraDetalles.get(0).getContNumero());
                        reporteCompraContableDetalle.setUsrInsertaCompra(reporteCompraDetalles.get(0).getUsrInsertaCompra());
                        reporteCompraContableDetalle.setUsrFechaInsertaCompra(reporteCompraDetalles.get(0).getUsrFechaInsertaCompra());
                        reporteCompraContableDetalle.setCompElectronica(reporteCompraDetalles.get(0).getCompElectronica());
                        reporteCompraContableDetalle.setBodCodigo(reporteCompraDetalles.get(0).getBodCodigo());
                        reporteCompraContableDetalle.setProCodigoPrincipal(reporteCompraDetalles.get(0).getProCodigoPrincipal());
                        reporteCompraContableDetalle.setProNombre(reporteCompraDetalles.get(0).getProNombre());
                        reporteCompraContableDetalle.setDetCantidad(reporteCompraDetalles.get(0).getDetCantidad());
                        reporteCompraContableDetalle.setDetMedida(reporteCompraDetalles.get(0).getDetMedida());
                        reporteCompraContableDetalle.setDetPrecio(reporteCompraDetalles.get(0).getDetPrecio());
                        reporteCompraContableDetalle.setDetTotal(reporteCompraDetalles.get(0).getDetTotal());
                        reporteCompraContableDetalle.setDetPendiente(reporteCompraDetalles.get(0).getDetPendiente());
                        reporteCompraContableDetalle.setDetIva(reporteCompraDetalles.get(0).getDetIva());
                        reporteCompraContableDetalle.setSecCodigo(reporteCompraDetalles.get(0).getSecCodigo());
                        reporteCompraContableDetalle.setPisNumero(reporteCompraDetalles.get(0).getPisNumero());
                        reporteCompraContableDetalle.setDetFecha(reporteCompraDetalles.get(0).getDetFecha());
                        reporteCompraContableDetalle.setValorUltimaCompra(reporteCompraDetalles.get(0).getValorUltimaCompra());
                        reporteCompraContableDetalle.setDetCantidadCaja(reporteCompraDetalles.get(0).getDetCantidadCaja());
                        reporteCompraContableDetalle.setDetEmpaque(reporteCompraDetalles.get(0).getDetEmpaque());
                        reporteCompraContableDetalle.setDetPresentacionUnidad(reporteCompraDetalles.get(0).getDetPresentacionUnidad());
                        reporteCompraContableDetalle.setDetPresentacionCaja(reporteCompraDetalles.get(0).getDetPresentacionCaja());
                        
                        listReporteCompraContableDetalle.add(reporteCompraContableDetalle);
                    }
                }
            }           
            return generarReporte(sisUsuarioEmpresaTO, "reportComprobanteCompraContable.jrxml", new HashMap(), 
                     listReporteCompraContableDetalle);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    
}
