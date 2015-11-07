/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.reporte;

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
import produccion.TO.*;
import sistema.TO.SisUsuarioEmpresaTO;
import sistema.business.OperacionesSistemaBusinessLocal;
import static util.UtilsArchivos.getRutaReportes;
import validaciones.Validacion;

/**
 *
 * @author paca94
 */
@Stateless
public class GenerarReporteProduccion implements GenerarReporteProduccionLocal {

    @EJB
    OperacionesSistemaBusinessLocal operacionesSistemaBusinessLocal;



    private <T> JasperPrint generarReporte(SisUsuarioEmpresaTO sisUsuario, 
            String nombreReporte, Map parametros, List<T> list) throws Exception {
        try {            
            String rutaReportes = getRutaReportes() + "produccion/";  
            //reportResumenSiembras.jrxml"+
            if(nombreReporte.compareTo("reportResumenSiembras.jrxml")==0)
                parametros.put("titulo_reporte", "RESUMEN DE SIEMBRA");
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

    public JasperPrint generarReporteListadoGramaje(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String codigoSector, String codigoPiscina, String codigoCorrida,
            String fechaDesde, String fechaHasta, 
            List<PrdListadoGrameajeTO> prdListadoGrameajeTO) throws Exception 
    {
        try {
            List<ReporteListadoGrameaje> lista = new ArrayList();
            for (PrdListadoGrameajeTO plgTO : prdListadoGrameajeTO) {
                ReporteListadoGrameaje reporteListadoGramaje = new ReporteListadoGrameaje(
                codigoSector, codigoPiscina, codigoCorrida, fechaDesde, fechaHasta,
                                
                plgTO.getGraFecha() == null ? "" : plgTO.getGraFecha(),
                plgTO.getGratGrande() == null ? null : plgTO.getGratGrande(),
                plgTO.getGratMediano() == null ? null : plgTO.getGratMediano(),
                plgTO.getGratMediano() == null ? null : plgTO.getGratPequeno(),
                plgTO.getGratPromedio()== null ? null : plgTO.getGratPromedio(),
                plgTO.getGraBiomasa() == null ? null : plgTO.getGraBiomasa(),
                plgTO.getGraSobrevivencia() == null ? null : plgTO.getGraSobrevivencia(),
                plgTO.getGraComentario() == null ? "" : plgTO.getGraComentario()
                        );
                lista.add(reporteListadoGramaje);
            }
                    //reportListadoGrameaje
            return generarReporte(sisUsuarioEmpresaTO, "reportListadoGrameaje.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListadoFunAnalisisPesos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String codigoSector, String fechaHasta, List<PrdListaFunAnalisisPesosTO> 
                    prdListaFunAnalisisPesosTO) throws Exception {
        try {
            List<ReporteListadoFunAnalisisPeso> lista = new ArrayList();
            for (PrdListaFunAnalisisPesosTO fapTO : prdListaFunAnalisisPesosTO) {
                ReporteListadoFunAnalisisPeso reporteListadoGramaje = new ReporteListadoFunAnalisisPeso(
                        fechaHasta, //codigoSector,                        
                        fapTO.getApSector() == null ? "" : fapTO.getApSector(),
                        fapTO.getApPiscina() == null ? "" : fapTO.getApPiscina(),
                        fapTO.getApCorrida() == null ? "" : fapTO.getApCorrida(),
                        fapTO.getApHectareas() == null ? null : fapTO.getApHectareas(),
                        fapTO.getApFechaSiembra() == null ? null : fapTO.getApFechaSiembra(),
                        fapTO.getApFormaSiembra() == null ? null : fapTO.getApFormaSiembra(),
                        fapTO.getApDensidadMetroCuadrado() == null ? null : fapTO.getApDensidadMetroCuadrado(),
                        fapTO.getApSobrevivenciaMetroCuadrado() == null ? null : fapTO.getApSobrevivenciaMetroCuadrado(),
                        
                        fapTO.getApRaleo() == null ? null : fapTO.getApRaleo(),
                        fapTO.getApEdad() == null ? null : fapTO.getApEdad(),
                        fapTO.getApPesoIdeal() == null ? null : fapTO.getApPesoIdeal(),
                        fapTO.getApPesoSobreIdeal()== null ? null : fapTO.getApPesoSobreIdeal(),
                        fapTO.getApPesoPromedioActual()== null ? null : fapTO.getApPesoPromedioActual(),
                        fapTO.getApPesoIncrementoSemana4()== null ? null : fapTO.getApPesoIncrementoSemana4(),
                        fapTO.getApPesoIncrementoSemana3()== null ? null : fapTO.getApPesoIncrementoSemana3(),
                        fapTO.getApPesoIncrementoSemana2()== null ? null : fapTO.getApPesoIncrementoSemana2(),
                        fapTO.getApPesoIncrementoSemana1()== null ? null : fapTO.getApPesoIncrementoSemana1(),
                        fapTO.getApPesoIncrementoPromedio()== null ? null : fapTO.getApPesoIncrementoPromedio(),
                        fapTO.getApBalanceadoTipo()== null ? "" : fapTO.getApBalanceadoTipo(),
                        fapTO.getApBalanceadoSacos()== null ? null : fapTO.getApBalanceadoSacos(),
                        fapTO.getApBalanceadoKilosHectarea()== null ? null : fapTO.getApBalanceadoKilosHectarea(),
                        fapTO.getApBalanceadoAcumulado()== null ? null : fapTO.getApBalanceadoAcumulado(),
                        fapTO.getApBiomasaProyectada()== null ? null : fapTO.getApBiomasaProyectada(),
                        fapTO.getApConversionAlimenticia()== null ? null : fapTO.getApConversionAlimenticia(),
                        fapTO.getApLaboratorio()== null ? "" : fapTO.getApLaboratorio(),
                        fapTO.getApNauplio()== null ? "" : fapTO.getApNauplio()                        
                        );
                
                lista.add(reporteListadoGramaje);
                
            }
            
                    //reportListadoGrameaje
            return generarReporte(sisUsuarioEmpresaTO, "reporteListadoFunAnalisisPesos.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteConsumoFecha(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String secCodigo, String fechaDesde, 
            String fechaHasta, 
            List<PrdConsumosTO> prdConsumosTO) throws Exception 
    {
        try {
            List<ReporteConsumoPorFecha> lista = new ArrayList();
            for (PrdConsumosTO pcTO : prdConsumosTO) {
                ReporteConsumoPorFecha reporteConsumoPorFecha = new ReporteConsumoPorFecha (
                        secCodigo, fechaDesde, fechaHasta, //codigoSector,                        
                        pcTO.getConsumoProducto() == null ? "" : pcTO.getConsumoProducto(),
                        pcTO.getConsumoCodigo() == null ? "" : pcTO.getConsumoCodigo(),
                        pcTO.getConsumoMedida() == null ? "" : pcTO.getConsumoMedida(),
                        pcTO.getConsumoCantidad() == null ? null : pcTO.getConsumoCantidad()                                               
                        );                
                lista.add(reporteConsumoPorFecha);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportConsumoPorFecha.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteConsumoPiscina(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String codigoSector, 
            String codigoPiscina, String numeroCorrida, String hectareas, 
            Integer numLarvas, String fechaDesde, String fechaHasta, 
            List<PrdConsumosTO> prdConsumosTO) throws Exception
    {
        try {
            List<ReporteConsumoPorPiscina> lista = new ArrayList();
            for (PrdConsumosTO fapTO : prdConsumosTO) {
                ReporteConsumoPorPiscina reporteConsumoPorPiscina = new ReporteConsumoPorPiscina (
                        codigoSector, codigoPiscina, numeroCorrida, 
                        new java.math.BigDecimal(hectareas), numLarvas, 
                        fechaDesde, fechaHasta,
                        fapTO.getConsumoProducto() == null ? "" : fapTO.getConsumoProducto(),
                        fapTO.getConsumoCodigo() == null ? "" : fapTO.getConsumoCodigo(),
                        fapTO.getConsumoMedida() == null ? "" : fapTO.getConsumoMedida(),
                        fapTO.getConsumoCantidad() == null ? null : fapTO.getConsumoCantidad()                                               
                        );                
                lista.add(reporteConsumoPorPiscina);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportConsumoPorPiscina.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteEconomicoPorFechas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, 
            String fechaHasta, 
            List<PrdCostoDetalleFechaTO> listaPrdCostoDetalleFechaTO) throws Exception 
    {
        try {
            List<ReporteCostoDetalleFecha> lista = new ArrayList();
            for (PrdCostoDetalleFechaTO fapTO : listaPrdCostoDetalleFechaTO) {
                ReporteCostoDetalleFecha reporteCostoDetalleFecha = new ReporteCostoDetalleFecha (
                        fechaDesde, fechaHasta,
                        fapTO.getCostoProducto() == null ? "" : fapTO.getCostoProducto(),
                        fapTO.getCostoCodigo() == null ? "" : fapTO.getCostoCodigo(),
                        fapTO.getCostoMedida() == null ? "" : fapTO.getCostoMedida(),
                        fapTO.getCostoCantidad() == null ? null : fapTO.getCostoCantidad(),
                        fapTO.getCostoTotal() == null ? null : fapTO.getCostoTotal(),
                        fapTO.getCostoPorcentaje() == null ? null : fapTO.getCostoPorcentaje()
                        );                
                lista.add(reporteCostoDetalleFecha);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportCostoDetalleFecha.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteEconomicoPorPiscinas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String codigoSector, String codigoPiscina, String codigoCorrida, 
            String hectareas, Integer numLarvas, String fechaDesde, 
            String fechaHasta, List<PrdListaCostosDetalleCorridaTO> 
                    prdListaCostosDetalleCorridaTO) throws Exception 
    {
        try {
            List<ReporteCostoDetalladoCorrida> lista = new ArrayList();
            for (PrdListaCostosDetalleCorridaTO fapTO : prdListaCostosDetalleCorridaTO) {
                ReporteCostoDetalladoCorrida reporteCostoDetalladoCorrida = new ReporteCostoDetalladoCorrida (
                        codigoSector, codigoPiscina, codigoCorrida, 
                        new java.math.BigDecimal(hectareas), numLarvas, 
                        fechaDesde, fechaHasta,
                        fapTO.getCostoProducto() == null ? "" : fapTO.getCostoProducto(),
                        fapTO.getCostoCodigo() == null ? "" : fapTO.getCostoCodigo(),
                        fapTO.getCostoMedida() == null ? "" : fapTO.getCostoMedida(),
                        fapTO.getCostoCantidad() == null ? null : fapTO.getCostoCantidad(),
                        fapTO.getCostoTotal() == null ? null : fapTO.getCostoTotal(),
                        fapTO.getCostoPorcentaje() == null ? null : fapTO.getCostoPorcentaje()                                                       
                        );                
                lista.add(reporteCostoDetalladoCorrida);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportCostoDetalleCorrida.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    //Económico
    public JasperPrint generarReporteResumenSiembra(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, Object[][] datos) throws Exception 
    {
        try {
            List<ReporteResumenSiembra> lista = new ArrayList();
            for (int i = 0; i < datos.length; i++) {
                ReporteResumenSiembra reporteResumenSiembra = new ReporteResumenSiembra();
                
                reporteResumenSiembra.setRcSector((datos[i][0] != null ? datos[i][0].toString() : ""));
                reporteResumenSiembra.setPisNumero((datos[i][1] != null ? datos[i][1].toString() : ""));
                reporteResumenSiembra.setRcCorrida((datos[i][2] != null ? datos[i][2].toString() : ""));
                reporteResumenSiembra.setRcHectareaje((new java.math.BigDecimal(datos[i][3] != null ? datos[i][3].toString() : "0.00")));
                reporteResumenSiembra.setRcFechaSiembra(datos[i][4] != null ? datos[i][4].toString() : "");
                reporteResumenSiembra.setRcDiasCultivo((new java.math.BigDecimal(datos[i][5] != null ? datos[i][5].toString() : "0.00")));
                reporteResumenSiembra.setRcDiasInactivos((new java.math.BigDecimal(datos[i][6] != null ? datos[i][6].toString() : "0.00")));
                reporteResumenSiembra.setRcDensidad((new java.math.BigDecimal(datos[i][7] != null ? datos[i][7].toString() : "0.00")));
                reporteResumenSiembra.setRcLaboratorio((datos[i][8] != null ? datos[i][8].toString() : ""));
                reporteResumenSiembra.setRcNauplio(datos[i][9] != null ? datos[i][9].toString() : "");
                reporteResumenSiembra.setRcBiomasaProy((new java.math.BigDecimal(datos[i][10] != null ? datos[i][10].toString() : "0.00")));
                reporteResumenSiembra.setRcBiomasaReal((new java.math.BigDecimal(datos[i][11] != null ? datos[i][11].toString() : "0.00")));
                reporteResumenSiembra.setRcConversionAlim((new java.math.BigDecimal(datos[i][12] != null ? datos[i][12].toString() : "0.00")));
                reporteResumenSiembra.setRcGramos((new java.math.BigDecimal(datos[i][13] != null ? datos[i][13].toString() : "0.00")));
                reporteResumenSiembra.setRcSobrevivencia(datos[i][14] != null ? datos[i][14].toString() : "");
                reporteResumenSiembra.setRcCosto((new java.math.BigDecimal(datos[i][15] != null ? datos[i][15].toString() : "0.00")));
                reporteResumenSiembra.setRcDirecto((new java.math.BigDecimal(datos[i][16] != null ? datos[i][16].toString() : "0.00")));
                reporteResumenSiembra.setRcAdministrativo((new java.math.BigDecimal(datos[i][17] != null ? datos[i][17].toString() : "0.00")));                        
                reporteResumenSiembra.setRcFinanciero((new java.math.BigDecimal(datos[i][18] != null ? datos[i][18].toString() : "0.00")));
                reporteResumenSiembra.setRcGND((new java.math.BigDecimal(datos[i][19] != null ? datos[i][19].toString() : "0.00")));        
                reporteResumenSiembra.setRcIndirecto(new java.math.BigDecimal(datos[i][20] != null ? datos[i][20].toString() : "0.00"));
                        
                lista.add(reporteResumenSiembra);
            }
            
            return generarReporte(sisUsuarioEmpresaTO, "reportResumenSiembrasNew.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteResumenSiembra(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<PrdResumenCorridaTO> listaPrdListaResumenCorridaTO) 
    {
        try {
//            List<ReporteResumenSiembra> lista = new ArrayList();
//            for (PrdResumenCorridaTO fapTO : listaPrdListaResumenCorridaTO) {
//                ReporteResumenSiembra reporteResumenSiembra = new ReporteResumenSiembra();
//                
//                reporteResumenSiembra.setRcSector((fapTO.getSecNombre()!= null ? "" : fapTO.getSecCodigo() ));
//                reporteResumenSiembra.setPisNumero((fapTO.getPisNumero()== null ? "" : fapTO.getPisNumero()));
//                reporteResumenSiembra.setRcCorrida((fapTO.getRcCorridaNumero()== null ? "" : fapTO.getRcCorridaNumero()));
//                reporteResumenSiembra.setRcHectareaje((fapTO.getRcHectareaje()!= null ? null : fapTO.getRcHectareaje()));
//                reporteResumenSiembra.setRcFechaSiembra((fapTO.getRcFechaSiembra()== null ? "" : fapTO.getRcFechaSiembra()));
//                reporteResumenSiembra.setRcDiasCultivo((fapTO.getRcEdad() == null ? null : fapTO.getRcEdad()));
//                reporteResumenSiembra.setRcDiasInactivos((fapTO.getRcDiasMuertos() == null ? null : fapTO.getRcDiasMuertos()));
//                reporteResumenSiembra.setRcDensidad((fapTO.getRcDensidad() == null ? null: fapTO.getRcDensidad()));
//                reporteResumenSiembra.setRcLaboratorio((fapTO.getRcLaboratorio() == null ? null : fapTO.getRcLaboratorio()));
//                reporteResumenSiembra.setRcNauplio((fapTO.getRcNauplio() == null ? null : fapTO.getRcNauplio()));
//                reporteResumenSiembra.setRcBiomasaProy((fapTO.getRcBiomasa() == null ? null : fapTO.getRcBiomasa()));
//                reporteResumenSiembra.setRcBiomasaReal((fapTO.getRcBiomasaReal() == null ? null : fapTO.getRcBiomasaReal()));
//                reporteResumenSiembra.setRcConversionAlim((fapTO.getRcConversion() == null ? null : fapTO.getRcConversion()));
//                reporteResumenSiembra.setRcGramos((fapTO.getRcTPromedio() == null ? null : fapTO.getRcTPromedio()));
////                reporteResumenSiembra.setRcTotal((fapTO.getRcTPromedio() == null ? null : fapTO.getRcTPromedio()));                
//                reporteResumenSiembra.setRcSobrevivencia((fapTO.getRcSobrevivencia() == null ? "" : fapTO.getRcSobrevivencia()));
//                reporteResumenSiembra.setRcCosto((fapTO.getRcCosto() == null ? null : fapTO.getRcCosto()));
//                reporteResumenSiembra.setRcDirecto((fapTO.getRcDirecto() == null ? null : fapTO.getRcDirecto()));
//                reporteResumenSiembra.setRcAdministrativo((fapTO.getRcCostoTotalDia() == null ? null : fapTO.getRcCostoTotalDia()));
//                reporteResumenSiembra.setRcFinanciero((fapTO.getRcCostoDirectoDia() == null ? null : fapTO.getRcCostoTotalDia()));
//                reporteResumenSiembra.setRcGND((fapTO.getRcCostoindirectoDia() == null ? null : fapTO.getRcCostoindirectoDia()));
//                reporteResumenSiembra.setRcIndirecto((fapTO.getRcIndirecto() == null ? null : fapTO.getRcIndirecto()));
//                
//                lista.add(reporteResumenSiembra);
//            }
            
            return generarReporte(sisUsuarioEmpresaTO, "reportResumenSiembras.jrxml", new HashMap(), listaPrdListaResumenCorridaTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }       
    }

    public JasperPrint generarReporteResumenPesca(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<PrdResumenCorridaTO> listaPrdListaResumenCorridaTO) throws Exception 
    {
    
        try {
//            List<ReporteResumenPesca> lista = new ArrayList();
//            for (PrdResumenCorridaTO fapTO : listaPrdListaResumenCorridaTO) {
//                ReporteResumenPesca reporteResumenPesca = new ReporteResumenPesca();
//                
//                reporteResumenPesca.setRcSector((fapTO.getSecNombre()!= null ? "" : fapTO.getSecCodigo() ));
//                reporteResumenPesca.setRcPiscina((fapTO.getPisNumero()== null ? "" : fapTO.getPisNumero()));
//                reporteResumenPesca.setRcCorrida((fapTO.getRcCorridaNumero()== null ? "" : fapTO.getRcCorridaNumero()));
//                reporteResumenPesca.setRcHectareaje((fapTO.getRcHectareaje()!= null ? null : fapTO.getRcHectareaje()));
//                reporteResumenPesca.setRcFechaSiembra((fapTO.getRcFechaSiembra()== null ? "" : fapTO.getRcFechaSiembra()));
//                reporteResumenPesca.setRcFechaPesca((fapTO.getRcFechaPesca()== null ? "" : fapTO.getRcFechaPesca()));
//                reporteResumenPesca.setRcDiasCultivo((fapTO.getRcEdad() == null ? null : fapTO.getRcEdad()));
//                reporteResumenPesca.setRcDiasInactivos((fapTO.getRcDiasMuertos() == null ? null : fapTO.getRcDiasMuertos()));
//                //Larvas............
//                reporteResumenPesca.setRcDensidad((fapTO.getRcDensidad() == null ? null: fapTO.getRcDensidad()));
//                reporteResumenPesca.setRcLaboratorio((fapTO.getRcLaboratorio() == null ? null : fapTO.getRcLaboratorio()));
//                //reporteResumenSiembra.setRcNauplio((fapTO.getRcNauplio() == null ? null : fapTO.getRcNauplio()));
//                reporteResumenPesca.setRcBiomasaProy((fapTO.getRcBiomasa() == null ? null : fapTO.getRcBiomasa()));
//                reporteResumenPesca.setRcBiomasaReal((fapTO.getRcBiomasaReal() == null ? null : fapTO.getRcBiomasaReal()));
//                //reporteResumenPesca.setRcHectareaje((fapTO.getRcConversion() == null ? null : fapTO.getRcConversion()));
//                
////                reporteResumenSiembra.setRcTotal((fapTO.getRcTPromedio() == null ? null : fapTO.getRcTPromedio())); 
//                reporteResumenPesca.setRcConversionAlim((fapTO.getRcConversion() == null ? null : fapTO.getRcConversion()));
//                reporteResumenPesca.setRcGramos((fapTO.getRcTPromedio() == null ? null : fapTO.getRcTPromedio()));
//                //reporteResumenPesca.setRc(fapTO.getRcTPromedio() == null ? null : fapTO.getRcTPromedio()));
//                reporteResumenPesca.setRcSobrevivencia((fapTO.getRcSobrevivencia() == null ? "" : fapTO.getRcSobrevivencia()));
//                reporteResumenPesca.setRcCosto((fapTO.getRcCosto() == null ? null : fapTO.getRcCosto()));
//                reporteResumenPesca.setRcDirecto((fapTO.getRcDirecto() == null ? null : fapTO.getRcDirecto()));
////                reporteResumenPesca.setRc((fapTO.getRcCostoTotalDia() == null ? null : fapTO.getRcCostoTotalDia()));
//                reporteResumenPesca.setRcFinanciero((fapTO.getRcCostoDirectoDia() == null ? null : fapTO.getRcCostoTotalDia()));
//                reporteResumenPesca.setRcGND((fapTO.getRcCostoindirectoDia() == null ? null : fapTO.getRcCostoindirectoDia()));
////                reporteResumenSiembra.setRcIndirecto((fapTO.getRcIndirecto() == null ? null : fapTO.getRcIndirecto()));
//                
//                lista.add(reporteResumenPesca);
//            }
            return generarReporte(sisUsuarioEmpresaTO, "reportResumenPescas.jrxml", new HashMap(), listaPrdListaResumenCorridaTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }       
    }

    public JasperPrint generarReporteResumenPescaEconomico(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            Object[][] datos) throws Exception {
        try {
            List<ReporteResumenPesca> lista = new ArrayList();
            for (int i = 0; i < datos.length; i++) {
                ReporteResumenPesca reporteResumenPesca = new ReporteResumenPesca();
                
                reporteResumenPesca.setRcSector((datos[i][0] != null ? datos[i][0].toString() : ""));
                reporteResumenPesca.setRcPiscina((datos[i][1] != null ? datos[i][1].toString() : ""));
                reporteResumenPesca.setRcCorrida((datos[i][2] != null ? datos[i][2].toString() : ""));
                reporteResumenPesca.setRcHectareaje((new java.math.BigDecimal(datos[i][3] != null ? datos[i][3].toString() : "0.00")));
                reporteResumenPesca.setRcFechaPesca(datos[i][4] != null ? datos[i][4].toString() : "");
                reporteResumenPesca.setRcDiasCultivo((new java.math.BigDecimal(datos[i][6] != null ? datos[i][6].toString() : "0.00")));
                reporteResumenPesca.setRcDiasInactivos((new java.math.BigDecimal(datos[i][7] != null ? datos[i][7].toString() : "0.00")));
                reporteResumenPesca.setRcDensidad((new java.math.BigDecimal(datos[i][8] != null ? datos[i][8].toString() : "0.00")));
                reporteResumenPesca.setRcLaboratorio((datos[i][9] != null ? datos[i][9].toString() : ""));
                reporteResumenPesca.setRcNauplio(datos[i][10] != null ? datos[i][10].toString() : "");
                //reporteResumenPesca.setRcBiomasaProy((new java.math.BigDecimal(datos[i][11] != null ? datos[i][11].toString() : "0.00")));
                reporteResumenPesca.setRcBiomasaReal((new java.math.BigDecimal(datos[i][11] != null ? datos[i][11].toString() : "0.00")));
                reporteResumenPesca.setRcConversionAlim((new java.math.BigDecimal(datos[i][12] != null ? datos[i][12].toString() : "0.00")));
                reporteResumenPesca.setRcGramos((new java.math.BigDecimal(datos[i][13] != null ? datos[i][13].toString() : "0.00")));
                reporteResumenPesca.setRcSobrevivencia(datos[i][14] != null ? datos[i][14].toString() : "");
                reporteResumenPesca.setRcCosto((new java.math.BigDecimal(datos[i][15] != null ? datos[i][15].toString() : "0.00")));
                reporteResumenPesca.setRcDirecto((new java.math.BigDecimal(datos[i][16] != null ? datos[i][16].toString() : "0.00")));
                reporteResumenPesca.setRcAdministrativo((new java.math.BigDecimal(datos[i][17] != null ? datos[i][17].toString() : "0.00")));                        
                reporteResumenPesca.setRcFinanciero((new java.math.BigDecimal(datos[i][18] != null ? datos[i][18].toString() : "0.00")));
                reporteResumenPesca.setRcGND((new java.math.BigDecimal(datos[i][19] != null ? datos[i][19].toString() : "0.00")));        
                reporteResumenPesca.setRcIndirecto(new java.math.BigDecimal(datos[i][20] != null ? datos[i][20].toString() : "0.00"));
                        
                lista.add(reporteResumenPesca);
                
            }
            
            return generarReporte(sisUsuarioEmpresaTO, "reportResumenPescasNew.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
