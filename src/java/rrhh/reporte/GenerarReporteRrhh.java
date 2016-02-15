/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.reporte;

import java.math.BigDecimal;
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
import rrhh.TO.*;
import sistema.TO.SisUsuarioEmpresaTO;
import static util.UtilsArchivos.getRutaReportes;
import validaciones.Validacion;

/**
 *
 * @author developer2
 */
@Stateless
public class GenerarReporteRrhh implements GenerarReporteRrhhLocal {

    private <T> JasperPrint generarReporte(SisUsuarioEmpresaTO sisUsuario,
            String nombreReporte, Map parametros, List<T> list) {
        try {
//            SisUsuarioEmpresaTO sisUsuario = mDIShrimp.getSisUsuarioEmpresaTO();
            String rutaReportes = getRutaReportes() + "RRHH/";
            parametros.put("SUBREPORT_DIR", rutaReportes);
            //parametros.put("SUBREPORT_DIR", rutaReportes + "reportCabeceraGeneral.jasper");
            parametros.put("p_empresa_nombre", sisUsuario.getEmpNombre());
            parametros.put("p_empresa_ruc", sisUsuario.getEmpRuc());
            parametros.put("p_empresa_direccion", sisUsuario.getEmpDireccion());
            parametros.put("p_empresa_telefono", sisUsuario.getEmpTelefono());
            parametros.put("p_usuario_nick", sisUsuario.getUsrNick());
            parametros.put("p_fecha_hora", Validacion.fechaSistema());
//            parametros.put("p_", Validacion.fechaSistema());

            return JasperFillManager.fillReport(JasperCompileManager.compileReport(JRXmlLoader.load(rutaReportes + nombreReporte)),
                    parametros, new JRBeanCollectionDataSource(list));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListaDetalleVacaionesPagadas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String desde, String hasta,
            String empSector, List<RhDetalleVacionesPagadasGozadasTO> listaDetalleVacacionesPagadasGozadasTO) throws Exception {
        try {
            List<ReporteListaDetalleVacaionesPagadas> reporteListaDetalleVacaionesPagadas = new ArrayList();

//            List<ReporteListadoChequeEmisionVencimientoCobrarNumero> reporteListadoChequeEmisionVencimientoCobrarNumeros = new ArrayList();
            for (RhDetalleVacionesPagadasGozadasTO rldvpg : listaDetalleVacacionesPagadasGozadasTO) {
                ReporteListaDetalleVacaionesPagadas reporteListaDetalleVacaionesPagada =
                        new ReporteListaDetalleVacaionesPagadas(desde, hasta, empSector,
                        rldvpg.getVacApellidosNombres(),
                        rldvpg.getVacId(),
                        rldvpg.getVacApellidosNombres(),
                        rldvpg.getVacValor(),
                        rldvpg.getVacDesde(),
                        rldvpg.getVacHasta(),
                        rldvpg.getVacGozadasDesde(),
                        rldvpg.getVacGozadasHasta(),
                        rldvpg.getVacObservaciones(),
                        rldvpg.getVacContables());
                reporteListaDetalleVacaionesPagadas.add(reporteListaDetalleVacaionesPagada);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportListadoDetalleVacacionesPagadas.jrxml",
                    new HashMap(), reporteListaDetalleVacaionesPagadas);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteConsolidadoAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String fechaDesde,
            String fechaHasta,
            List<RhListaConsolidadoAnticiposPrestamosTO> listaConsolidadoAnticiposPrestamosTO) throws Exception {
        try {
            List<RhConsolidadoAnticiposPrestamos> rhConsolidadoAnticiposPrestamoses = new java.util.ArrayList();
            RhConsolidadoAnticiposPrestamos rhConsolidadoAnticiposPrestamos = null;
            for (int i = 0; i < listaConsolidadoAnticiposPrestamosTO.size(); i++) {
                rhConsolidadoAnticiposPrestamos = new RhConsolidadoAnticiposPrestamos();
                rhConsolidadoAnticiposPrestamos.setFechaDesde(fechaDesde);
                rhConsolidadoAnticiposPrestamos.setFechaHasta(fechaHasta);
                rhConsolidadoAnticiposPrestamos.setCapCategoria(listaConsolidadoAnticiposPrestamosTO.get(i).getCapCategoria());
                rhConsolidadoAnticiposPrestamos.setCapId(listaConsolidadoAnticiposPrestamosTO.get(i).getCapId());
                rhConsolidadoAnticiposPrestamos.setCapNombres(listaConsolidadoAnticiposPrestamosTO.get(i).getCapNombres());
                rhConsolidadoAnticiposPrestamos.setCapAnticipos(listaConsolidadoAnticiposPrestamosTO.get(i).getCapAnticipos());
                rhConsolidadoAnticiposPrestamos.setCapPrestamos(listaConsolidadoAnticiposPrestamosTO.get(i).getCapPrestamos());
                rhConsolidadoAnticiposPrestamos.setCapTotal(listaConsolidadoAnticiposPrestamosTO.get(i).getCapTotal());
                rhConsolidadoAnticiposPrestamos.setCapOrden(listaConsolidadoAnticiposPrestamosTO.get(i).getCapOrden());
                rhConsolidadoAnticiposPrestamoses.add(rhConsolidadoAnticiposPrestamos);
                
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportRRHHConsolidadoAnticiposPrestamos.jrxml",
                    new HashMap(), rhConsolidadoAnticiposPrestamoses);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteDetalleAnticipos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empId, String empCodigo,
            String empCategoria, String fechaDesde, String fechaHasta,
            List<RhListaDetalleAnticiposTO> listaDetalleAnticiposTO) throws Exception {
        try {
            List<ReporteDetalleAnticipos> reporteDetalleAnticipos = new ArrayList();
            for (RhListaDetalleAnticiposTO rldvpg : listaDetalleAnticiposTO) {
                ReporteDetalleAnticipos reporteDetalleAnticipo =
                        new ReporteDetalleAnticipos(empCodigo, fechaDesde,
                        fechaHasta, empCategoria, empId,
                        //                        plgTO.getGraFecha() == null ? "" : plgTO.getGraFecha(),
                        //                plgTO.getGratGrande() == null ? null : plgTO.getGratGrande(),
                        rldvpg.getDaCategoria() == null ? "" : rldvpg.getDaCategoria(),
                        rldvpg.getDaFecha() == null ? "" : rldvpg.getDaFecha(),
                        rldvpg.getDaId() == null ? "" : rldvpg.getDaId(),
                        rldvpg.getDaNombres() == null ? "" : rldvpg.getDaNombres(),
                        rldvpg.getDaValor() == null ? null : rldvpg.getDaValor(),
                        rldvpg.getDaFormaPago() == null ? "" : rldvpg.getDaFormaPago(),
                        rldvpg.getDaDocumento() == null ? "" : rldvpg.getDaDocumento(),
                        rldvpg.getDaContable() == null ? "" : rldvpg.getDaContable(),
                        rldvpg.getDaAnulado() == null ? false : rldvpg.getDaAnulado());
                reporteDetalleAnticipos.add(reporteDetalleAnticipo);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportRRHHDetalleAnticipos.jrxml",
                    new HashMap(), reporteDetalleAnticipos);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteDetalleAnticiposPrestamos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId,
            List<RhListaDetalleAnticiposPrestamosTO> listaDetalleAnticiposPrestamosTO) throws Exception {
        try {
            List<ReporteDetalleAnticiposPrestamos> reporteDetalleAnticiposPrestamos = new ArrayList();
            for (RhListaDetalleAnticiposPrestamosTO rldvpg : listaDetalleAnticiposPrestamosTO) {
                ReporteDetalleAnticiposPrestamos reporteDetalleAnticiposPrestamo =
                        new ReporteDetalleAnticiposPrestamos();
                reporteDetalleAnticiposPrestamo.setEmpCodigo(empCodigo);
                reporteDetalleAnticiposPrestamo.setFechaDesde(fechaDesde);
                reporteDetalleAnticiposPrestamo.setFechaHasta(fechaHasta);
                reporteDetalleAnticiposPrestamo.setEmpCategoria(empCategoria);
                reporteDetalleAnticiposPrestamo.setEmpId(empId);

                reporteDetalleAnticiposPrestamo.setDapTipo((rldvpg.getDapTipo() == null ? "" : rldvpg.getDapTipo()));
                reporteDetalleAnticiposPrestamo.setDapCategoria(rldvpg.getDapCategoria() == null ? "" : rldvpg.getDapCategoria());
                reporteDetalleAnticiposPrestamo.setDapFecha(rldvpg.getDapFecha() == null ? "" : rldvpg.getDapFecha());
                reporteDetalleAnticiposPrestamo.setDapId(rldvpg.getDapId() == null ? "" : rldvpg.getDapId());
                reporteDetalleAnticiposPrestamo.setDapNombres(rldvpg.getDapNombres() == null ? "" : rldvpg.getDapNombres());
                reporteDetalleAnticiposPrestamo.setDapValor((rldvpg.getDapValor() == null ? null : rldvpg.getDapValor()));
                reporteDetalleAnticiposPrestamo.setDapFormaPago(rldvpg.getDapFormaPago() == null ? "" : rldvpg.getDapFormaPago());
                reporteDetalleAnticiposPrestamo.setDapDocumento(rldvpg.getDapDocumento() == null ? "" : rldvpg.getDapDocumento());
                reporteDetalleAnticiposPrestamo.setDapContable(rldvpg.getDapContable() == null ? "" : rldvpg.getDapContable());
                reporteDetalleAnticiposPrestamo.setDapAnulado((rldvpg.getDapAnulado() == null ? false : rldvpg.getDapAnulado()));

                reporteDetalleAnticiposPrestamos.add(reporteDetalleAnticiposPrestamo);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportRRHHDetalleAnticiposPrestamos.jrxml",
                    new HashMap(), reporteDetalleAnticiposPrestamos);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteDetallePrestamos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empCodigo,
            String fechaDesde, String fechaHasta, String empCategoria, String empId,
            List<RhListaDetallePrestamosTO> listaDetallePrestamosTO) throws Exception {
        try {
            List<ReporteDetallePrestamos> reporteDetallePrestamos = new ArrayList();
            for (RhListaDetallePrestamosTO rldvpg : listaDetallePrestamosTO) {
                ReporteDetallePrestamos reporteDetallePrestamo =
                        new ReporteDetallePrestamos();
                reporteDetallePrestamo.setEmpCodigo(empCodigo);
                reporteDetallePrestamo.setFechaDesde(fechaDesde);
                reporteDetallePrestamo.setFechaHasta(fechaHasta);
                reporteDetallePrestamo.setEmpCategoria(empCategoria);
                reporteDetallePrestamo.setEmpId(empId);
//                
//                reporteDetallePrestamo.setDapTipo((rldvpg.getDapTipo() == null ? "" : rldvpg.getDapTipo()));
                reporteDetallePrestamo.setDpCategoria(rldvpg.getDpCategoria() == null ? "" : rldvpg.getDpCategoria());
                reporteDetallePrestamo.setDpFecha(rldvpg.getDpFecha() == null ? "" : rldvpg.getDpFecha());
                reporteDetallePrestamo.setDpId(rldvpg.getDpId() == null ? "" : rldvpg.getDpId());
                reporteDetallePrestamo.setDpNombres(rldvpg.getDpNombres() == null ? "" : rldvpg.getDpNombres());
                reporteDetallePrestamo.setDpValor((rldvpg.getDpValor() == null ? null : rldvpg.getDpValor()));
                reporteDetallePrestamo.setDpFormaPago(rldvpg.getDpFormaPago() == null ? "" : rldvpg.getDpFormaPago());
                reporteDetallePrestamo.setDpDocumento(rldvpg.getDpDocumento() == null ? "" : rldvpg.getDpDocumento());
                reporteDetallePrestamo.setDpContable(rldvpg.getDpContable() == null ? "" : rldvpg.getDpContable());

                reporteDetallePrestamos.add(reporteDetallePrestamo);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportRRHHDetallePrestamos.jrxml",
                    new HashMap(), reporteDetallePrestamos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteDetalleBonos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaDetalleBonosTO> listaDetalleBonosTO) throws Exception {
        try {
            List<ReporteDetalleBonos> reporteDetalleBonos = new ArrayList();
            for (RhListaDetalleBonosTO rldvpg : listaDetalleBonosTO) {
                ReporteDetalleBonos reporteDetalleBono =
                        new ReporteDetalleBonos();

                reporteDetalleBono.setDesde(fechaDesde);
                reporteDetalleBono.setHasta(fechaHasta);
                reporteDetalleBono.setCategoriaCabecera(empCategoria);
                reporteDetalleBono.setNombresCabecera(nombreEmpleado);

                reporteDetalleBono.setDbCategoria((rldvpg.getDbCategoria() == null ? "" : rldvpg.getDbCategoria()));
                reporteDetalleBono.setDbFecha(rldvpg.getDbFecha() == null ? "" : rldvpg.getDbFecha());
                reporteDetalleBono.setDbId(rldvpg.getDbId() == null ? "" : rldvpg.getDbId());
                reporteDetalleBono.setDbNombres(rldvpg.getDbNombres() == null ? "" : rldvpg.getDbNombres());
                reporteDetalleBono.setDbConcepto(rldvpg.getDbConcepto() == null ? "" : rldvpg.getDbConcepto());
                reporteDetalleBono.setDbSector(rldvpg.getDbSector() == null ? "" : rldvpg.getDbSector());

                reporteDetalleBono.setDbPiscina(rldvpg.getDbPiscina() == null ? "" : rldvpg.getDbPiscina());
                reporteDetalleBono.setDbValor(rldvpg.getDbValor() == null ? null : rldvpg.getDbValor());
                reporteDetalleBono.setDbReverso(rldvpg.getDbReverso() == null ? false : rldvpg.getDbReverso());

                reporteDetalleBono.setDbContable(rldvpg.getDbContable() == null ? "" : rldvpg.getDbContable());
                reporteDetalleBono.setDbAnulado(rldvpg.getDbAnulado() == null ? false : rldvpg.getDbAnulado());
                reporteDetalleBono.setDbDeducible(rldvpg.getDbDeducible() == null ? false : rldvpg.getDbDeducible());
                reporteDetalleBono.setDbObservaciones(rldvpg.getDbObservaciones() == null ? "" : rldvpg.getDbObservaciones());

                reporteDetalleBonos.add(reporteDetalleBono);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportDetalleBonos.jrxml",
                    new HashMap(), reporteDetalleBonos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteDetalleBonosLote(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String periodo, String tipo,
            String numero, List<RhListaDetalleBonosLoteTO> listaDetalleBonosLoteTO) throws Exception {
        try {
            List<ReporteConsultaBonosLote> reporteConsultaBonosLotes = new ArrayList();
            for (RhListaDetalleBonosLoteTO rldvpg : listaDetalleBonosLoteTO) {
                ReporteConsultaBonosLote reporteConsultaBonosLote =
                        new ReporteConsultaBonosLote();

                reporteConsultaBonosLote.setPeriodo(periodo);
                reporteConsultaBonosLote.setTipo(tipo);
                reporteConsultaBonosLote.setNumero(numero);

                reporteConsultaBonosLote.setDblFecha(rldvpg.getDblFecha() == null ? "" : rldvpg.getDblFecha());
                reporteConsultaBonosLote.setDblId(rldvpg.getDblId() == null ? "" : rldvpg.getDblId());
                reporteConsultaBonosLote.setDblNombres(rldvpg.getDblNombres() == null ? "" : rldvpg.getDblNombres());
                reporteConsultaBonosLote.setDblValor(rldvpg.getDblValor() == null ? null : rldvpg.getDblValor());

                reporteConsultaBonosLotes.add(reporteConsultaBonosLote);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportComprobanteBonosPorLote.jrxml",
                    new HashMap(), reporteConsultaBonosLotes);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteDetalleViaticos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria,
            String nombreEmpleado,
            List<RhListaDetalleViaticosTO> listaDetalleViaticosTO) throws Exception {
        try {
            List<ReporteDetalleViatico> reporteDetalleViaticos = new ArrayList();
            for (RhListaDetalleViaticosTO rldvpg : listaDetalleViaticosTO) {
                ReporteDetalleViatico reporteDetalleViatico =
                        new ReporteDetalleViatico();
                reporteDetalleViatico.setDesde(fechaDesde);
                reporteDetalleViatico.setHasta(fechaHasta);
                reporteDetalleViatico.setCategoriaCabecera(empCategoria);
                reporteDetalleViatico.setNombresCabecera(nombreEmpleado);

                reporteDetalleViatico.setCategoria((rldvpg.getDvCategoria() == null ? "" : rldvpg.getDvCategoria()));
                reporteDetalleViatico.setFecha((rldvpg.getDvFecha() == null ? "" : rldvpg.getDvFecha()));
                reporteDetalleViatico.setId((rldvpg.getDvId() == null ? "" : rldvpg.getDvId()));
                reporteDetalleViatico.setNombres((rldvpg.getDvNombres() == null ? "" : rldvpg.getDvNombres()));
                reporteDetalleViatico.setValor(rldvpg.getDvValor() == null ? null : rldvpg.getDvValor());
//                reporteDetalleViatico.setReverso(rldvpg.getDvReverso() == null ? false : rldvpg.getDvReverso());
                reporteDetalleViatico.setContable(rldvpg.getDvContable() == null ? "" : rldvpg.getDvContable());
                reporteDetalleViatico.setAnulado(rldvpg.getDvReverso() == null ? false : rldvpg.getDvReverso());
//                reporteDetalleViatico.setObservaciones(rldvpg.getDvContable() == null ? "" : rldvpg.getDvContable());

                reporteDetalleViaticos.add(reporteDetalleViatico);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportDetalleViatico.jrxml",
                    new HashMap(), reporteDetalleViaticos);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteConsolidadoBonosViatico(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<RhListaConsolidadoBonosViaticosTO> listaConsolidadoBonosViaticosTO) throws Exception {
        try {
            List<ReporteConsolidadoBonosViaticos> reporteConsolidadoBonosViaticos = new ArrayList();
            for (RhListaConsolidadoBonosViaticosTO rldvpg : listaConsolidadoBonosViaticosTO) {
                ReporteConsolidadoBonosViaticos reporteConsolidadoBonosViatico =
                        new ReporteConsolidadoBonosViaticos();

                reporteConsolidadoBonosViatico.setDesde(fechaDesde);
                reporteConsolidadoBonosViatico.setHasta(fechaHasta);

                reporteConsolidadoBonosViatico.setCbvCategoria((rldvpg.getCbvCategoria() == null ? "" : rldvpg.getCbvCategoria()));
                reporteConsolidadoBonosViatico.setCbvId((rldvpg.getCbvId() == null ? "" : rldvpg.getCbvId()));
                reporteConsolidadoBonosViatico.setCbvNombres((rldvpg.getCbvNombres() == null ? "" : rldvpg.getCbvNombres()));
                reporteConsolidadoBonosViatico.setCbvBonos((rldvpg.getCbvBonos() == null ? null : rldvpg.getCbvBonos()));
                reporteConsolidadoBonosViatico.setCbvBonosND((rldvpg.getCbvBonosND() == null ? null : rldvpg.getCbvBonosND()));
                reporteConsolidadoBonosViatico.setCbvBonoFijo((rldvpg.getCbvBonoFijo() == null ? null : rldvpg.getCbvBonoFijo()));
                reporteConsolidadoBonosViatico.setCbvBonoFijoND((rldvpg.getCbvBonoFijoND() == null ? null : rldvpg.getCbvBonoFijoND()));
                reporteConsolidadoBonosViatico.setCbvViaticos((rldvpg.getCbvViaticos() == null ? null : rldvpg.getCbvViaticos()));
                reporteConsolidadoBonosViatico.setCbvTotal((rldvpg.getCbvTotal() == null ? null : rldvpg.getCbvTotal()));
                reporteConsolidadoBonosViatico.setCbvOrden((rldvpg.getCbvOrden() == null ? "" : rldvpg.getCbvOrden()));

                reporteConsolidadoBonosViaticos.add(reporteConsolidadoBonosViatico);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportConsolidadoBonosViaticos.jrxml",
                    new HashMap(), reporteConsolidadoBonosViaticos);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListadoRolesPago(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaDetalleRolesTO> listaDetalleRolesTO) throws Exception {
        try {
            List<ReporteListadoRoles> reporteListadoRoles = new ArrayList();
            for (RhListaDetalleRolesTO rldvpg : listaDetalleRolesTO) {
                ReporteListadoRoles reporteListadoRol = new ReporteListadoRoles();

                reporteListadoRol.setDesde(fechaDesde);
                reporteListadoRol.setHasta(fechaHasta);
                reporteListadoRol.setCategoria(empCategoria);
                reporteListadoRol.setEmpleado(nombreEmpleado);
                reporteListadoRol.setLrpId((rldvpg.getLrpId() == null ? "" : rldvpg.getLrpId()));
                reporteListadoRol.setLrpNombres((rldvpg.getLrpNombres() == null ? "" : rldvpg.getLrpNombres()));
                reporteListadoRol.setLrpCargo((rldvpg.getLrpCargo() == null ? "" : rldvpg.getLrpCargo()));
                reporteListadoRol.setLrpDesde((rldvpg.getLrpDesde() == null ? "" : rldvpg.getLrpDesde()));
                reporteListadoRol.setLrpHasta((rldvpg.getLrpHasta() == null ? "" : rldvpg.getLrpHasta()));
                //reporteListadoRol.setLrpSueldo((rldvpg.getLrpSueldo() == null ? null: rldvpg.getLrpSueldo()));                
                reporteListadoRol.setLrpDl((rldvpg.getLrpDl() == null ? null : rldvpg.getLrpDl()));
                reporteListadoRol.setLrpDf((rldvpg.getLrpDf() == null ? null : rldvpg.getLrpDf()));
                reporteListadoRol.setLrpDe((rldvpg.getLrpDe() == null ? null : rldvpg.getLrpDe()));
                reporteListadoRol.setLrpDd((rldvpg.getLrpDd() == null ? null : rldvpg.getLrpDd()));

                reporteListadoRol.setLrpDp((rldvpg.getLrpDp() == null ? null : rldvpg.getLrpDp()));
                reporteListadoRol.setLrpSaldo(rldvpg.getLrpSaldo() == null ? null : rldvpg.getLrpSaldo());
                reporteListadoRol.setLrpIngresos((rldvpg.getLrpIngresos() == null ? null : rldvpg.getLrpIngresos()));
                reporteListadoRol.setLrpBonos((rldvpg.getLrpBonos() == null ? null : rldvpg.getLrpBonos()));
                reporteListadoRol.setLrpBonosnd((rldvpg.getLrpBonosnd() == null ? null : rldvpg.getLrpBonosnd()));
                reporteListadoRol.setLrpBonoFijo((rldvpg.getLrpBonosFijo() == null ? null : rldvpg.getLrpBonosFijo()));
                reporteListadoRol.setLrpBonoFijoNd((rldvpg.getLrpBonosFijoNd() == null ? null : rldvpg.getLrpBonosFijoNd()));
                reporteListadoRol.setLrpViaticos((rldvpg.getLrpViaticos() == null ? null : rldvpg.getLrpViaticos()));
                reporteListadoRol.setLrpLiquidacion((rldvpg.getLrpLiquidacion() == null ? null : rldvpg.getLrpLiquidacion()));
                reporteListadoRol.setLrpFondoReserva((rldvpg.getLrpFondoReserva() == null ? null : rldvpg.getLrpFondoReserva()));
                reporteListadoRol.setLrpTotalIngresos((rldvpg.getLrpTotalIngresos() == null ? null : rldvpg.getLrpTotalIngresos()));
                reporteListadoRol.setLrpAnticipos((rldvpg.getLrpAnticipos() == null ? null : rldvpg.getLrpAnticipos()));
                reporteListadoRol.setLrpPrestamos((rldvpg.getLrpPrestamos() == null ? null : rldvpg.getLrpPrestamos()));
                reporteListadoRol.setLrpIess((rldvpg.getLrpIess() == null ? null : rldvpg.getLrpIess()));
                reporteListadoRol.setLrpRetencion((rldvpg.getLrpRetencion() == null ? null : rldvpg.getLrpRetencion()));
                reporteListadoRol.setLrpDescuentos((rldvpg.getLrpDescuentos() == null ? null : rldvpg.getLrpDescuentos()));
                reporteListadoRol.setLrpTotal((rldvpg.getLrpTotal() == null ? null : rldvpg.getLrpTotal()));
                reporteListadoRol.setLrpFormaPago((rldvpg.getLrpFormaPago() == null ? "" : rldvpg.getLrpFormaPago()));
                reporteListadoRol.setLrpDocumento((rldvpg.getLrpDocumento() == null ? "" : rldvpg.getLrpDocumento()));
                reporteListadoRol.setLrpContable((rldvpg.getLrpContable() == null ? "" : rldvpg.getLrpContable()));
//                reporteListadoRol.setLrpAcumulaFondoReserva((rldvpg.getLrpAcumulaFondoReserva() == null ? null: rldvpg.getLrpAcumulaFondoReserva())); 
//                
//                reporteListadoRol.setLrpLiquidacionXiii((rldvpg.getLrpLiquidacionXiii() == null ? null: rldvpg.getLrpLiquidacionXiii())); 
//                reporteListadoRol.setLrpLiquidacionXiv((rldvpg.getLrpLiquidacionXiv() == null ? null: rldvpg.getLrpLiquidacionXiv())); 
//                reporteListadoRol.setLrpLiquidacionVacaciones((rldvpg.getLrpLiquidacionVacaciones() == null ? null: rldvpg.getLrpLiquidacionVacaciones())); 
//                reporteListadoRol.setLrpLiquidacionDesahucio((rldvpg.getLrpLiquidacionDesahucio() == null ? null: rldvpg.getLrpLiquidacionDesahucio())); 

                reporteListadoRoles.add(reporteListadoRol);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportDetalladoRolesPago.jrxml",
                    new HashMap(), reporteListadoRoles);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteConsolidadoRoles(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaConsolidadoRolesTO> listaConsolidadoRolesTO) throws Exception {
        try {
            List<ReporteConsolidadoRol> reporteConsolidadoRoles = new ArrayList();
            for (RhListaConsolidadoRolesTO rldvpg : listaConsolidadoRolesTO) {
                ReporteConsolidadoRol reporteConsolidadoRol =
                        new ReporteConsolidadoRol();
                reporteConsolidadoRol.setDesde(fechaDesde);
                reporteConsolidadoRol.setHasta(fechaHasta);
                reporteConsolidadoRol.setCategoria(empCategoria);
                reporteConsolidadoRol.setEmpleado(nombreEmpleado);

                reporteConsolidadoRol.setCrpCategoria((rldvpg.getCrpCategoria() == null ? "" : rldvpg.getCrpCategoria()));
                reporteConsolidadoRol.setCrpId((rldvpg.getCrpId() == null ? "" : rldvpg.getCrpId()));
                reporteConsolidadoRol.setCrpNombres((rldvpg.getCrpNombres() == null ? "" : rldvpg.getCrpNombres()));
                reporteConsolidadoRol.setCrpDl((rldvpg.getCrpDl() == null ? null : rldvpg.getCrpDl()));
                reporteConsolidadoRol.setCrpDf((rldvpg.getCrpDf() == null ? null : rldvpg.getCrpDf()));
                reporteConsolidadoRol.setCrpDe((rldvpg.getCrpDe() == null ? null : rldvpg.getCrpDe()));
                reporteConsolidadoRol.setCrpDd((rldvpg.getCrpDd() == null ? null : rldvpg.getCrpDd()));
                reporteConsolidadoRol.setCrpDp((rldvpg.getCrpDp() == null ? null : rldvpg.getCrpDp()));
                reporteConsolidadoRol.setCrpSueldo((rldvpg.getCrpSueldo() == null ? null : rldvpg.getCrpSueldo()));
                reporteConsolidadoRol.setCrpBonos((rldvpg.getCrpBonos() == null ? null : rldvpg.getCrpBonos()));
                reporteConsolidadoRol.setCrpBonosnd((rldvpg.getCrpBonosnd() == null ? null : rldvpg.getCrpBonosnd()));
                reporteConsolidadoRol.setCrpBonoFijo((rldvpg.getCrpBonoFijo() == null ? null : rldvpg.getCrpBonoFijo()));
                reporteConsolidadoRol.setCrpBonoFijoNd((rldvpg.getCrpBonoFijoNd() == null ? null : rldvpg.getCrpBonoFijoNd()));
                reporteConsolidadoRol.setCrpOtrosIngresos((rldvpg.getCrpOtrosIngresos() == null ? null : rldvpg.getCrpOtrosIngresos()));
                reporteConsolidadoRol.setCrpOtrosIngresosNd((rldvpg.getCrpOtrosIngresos() == null ? null : rldvpg.getCrpOtrosIngresosNd()));
                reporteConsolidadoRol.setCrpSubtotalBonos((rldvpg.getCrpSubtotalBonos() == null ? null : rldvpg.getCrpSubtotalBonos()));
                reporteConsolidadoRol.setCrpSubtotalIngresos((rldvpg.getCrpSubtotalIngresos() == null ? null : rldvpg.getCrpSubtotalIngresos()));
                reporteConsolidadoRol.setCrpViaticos((rldvpg.getCrpViaticos() == null ? null : rldvpg.getCrpViaticos()));
                reporteConsolidadoRol.setCrpFondoReserva((rldvpg.getCrpFondoReserva() == null ? null : rldvpg.getCrpFondoReserva()));
                reporteConsolidadoRol.setCrpLiquidacion((rldvpg.getCrpLiquidacion() == null ? null : rldvpg.getCrpLiquidacion()));
                reporteConsolidadoRol.setCrpIngresos((rldvpg.getCrpIngresos() == null ? null : rldvpg.getCrpIngresos()));
                reporteConsolidadoRol.setCrpAnticipos((rldvpg.getCrpAnticipos() == null ? null : rldvpg.getCrpAnticipos()));
                reporteConsolidadoRol.setCrpPrestamos((rldvpg.getCrpPrestamos() == null ? null : rldvpg.getCrpPrestamos()));
                reporteConsolidadoRol.setCrpIess((rldvpg.getCrpIess() == null ? null : rldvpg.getCrpIess()));
                reporteConsolidadoRol.setCrpRetencion((rldvpg.getCrpRetencion() == null ? null : rldvpg.getCrpRetencion()));
                reporteConsolidadoRol.setCrpDescuentosFondoReserva((rldvpg.getCrpDescuentosFondoReserva() == null ? null : rldvpg.getCrpDescuentosFondoReserva()));
                reporteConsolidadoRol.setCrpDescuentos((rldvpg.getCrpDescuentos() == null ? null : rldvpg.getCrpDescuentos()));
                reporteConsolidadoRol.setCrpTotal((rldvpg.getCrpTotal() == null ? null : rldvpg.getCrpTotal()));

                reporteConsolidadoRoles.add(reporteConsolidadoRol);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportConsolidadoRolesPago.jrxml",
                    new HashMap(), reporteConsolidadoRoles);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteSaldoIndividualAnticiposPrestamos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empId,
            List<RhListaSaldoIndividualAnticiposPrestamosTO> listaSaldoIndividualAnticiposPrestamosTO) throws Exception {
        try {
            List<ReporteSaldoIndividualAnticiposPrestamos> lista = new ArrayList();
            for (RhListaSaldoIndividualAnticiposPrestamosTO rldvpg : listaSaldoIndividualAnticiposPrestamosTO) {
                ReporteSaldoIndividualAnticiposPrestamos reporteSaldoIndividualAnticiposPrestamo =
                        new ReporteSaldoIndividualAnticiposPrestamos();

                reporteSaldoIndividualAnticiposPrestamo.setDesde(fechaDesde);
                reporteSaldoIndividualAnticiposPrestamo.setHasta(fechaHasta);
                reporteSaldoIndividualAnticiposPrestamo.setId(empId);

                reporteSaldoIndividualAnticiposPrestamo.setSiapTipo((rldvpg.getSiapTipo() == null ? "" : rldvpg.getSiapTipo()));
                reporteSaldoIndividualAnticiposPrestamo.setSiapFecha((rldvpg.getSiapFecha() == null ? "" : rldvpg.getSiapFecha()));
                reporteSaldoIndividualAnticiposPrestamo.setSiapObservaciones((rldvpg.getSiapObservaciones() == null ? "" : rldvpg.getSiapObservaciones()));
                reporteSaldoIndividualAnticiposPrestamo.setSiapDebitos((rldvpg.getSiapDebitos() == null ? null : rldvpg.getSiapDebitos()));
                reporteSaldoIndividualAnticiposPrestamo.setSiapCreditos((rldvpg.getSiapCreditos() == null ? null : rldvpg.getSiapCreditos()));
                reporteSaldoIndividualAnticiposPrestamo.setSiapSaldo((rldvpg.getSiapSaldo() == null ? null : rldvpg.getSiapSaldo()));
                reporteSaldoIndividualAnticiposPrestamo.setSiapContable((rldvpg.getSiapContable() == null ? "" : rldvpg.getSiapContable()));


                lista.add(reporteSaldoIndividualAnticiposPrestamo);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportSaldoIndividualAnticiposPrestamos.jrxml",
                    new HashMap(), lista);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteSaldoConsolidadoAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoAnticiposPrestamosTO> listaSaldoConsolidadoAnticiposPrestamosTO) throws Exception {
        try {
            List<ReporteSaldoConsolidadoAnticipoPrestamo> lista = new ArrayList();
            for (RhListaSaldoConsolidadoAnticiposPrestamosTO rldvpg : listaSaldoConsolidadoAnticiposPrestamosTO) {
                ReporteSaldoConsolidadoAnticipoPrestamo reporteSaldoConsolidadoAnticipoPrestamo =
                        new ReporteSaldoConsolidadoAnticipoPrestamo();

                reporteSaldoConsolidadoAnticipoPrestamo.setFechaHasta(fechaHasta);
                reporteSaldoConsolidadoAnticipoPrestamo.setScapCategoria((rldvpg.getScapCategoria() == null ? "" : rldvpg.getScapCategoria()));
                reporteSaldoConsolidadoAnticipoPrestamo.setScapId((rldvpg.getScapId() == null ? "" : rldvpg.getScapId()));
                reporteSaldoConsolidadoAnticipoPrestamo.setScapNombres((rldvpg.getScapNombres() == null ? "" : rldvpg.getScapNombres()));

                reporteSaldoConsolidadoAnticipoPrestamo.setScapAnticipos((rldvpg.getScapAnticipos() == null ? null : rldvpg.getScapAnticipos()));
                reporteSaldoConsolidadoAnticipoPrestamo.setScapPrestamos((rldvpg.getScapPrestamos() == null ? null : rldvpg.getScapPrestamos()));
                reporteSaldoConsolidadoAnticipoPrestamo.setScapTotal((rldvpg.getScapTotal() == null ? null : rldvpg.getScapTotal()));

                reporteSaldoConsolidadoAnticipoPrestamo.setScapOrden((rldvpg.getScapOrden() == null ? "" : rldvpg.getScapOrden()));

                lista.add(reporteSaldoConsolidadoAnticipoPrestamo);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportSaldoConsolidadoAnticiposPrestamos.jrxml",
                    new HashMap(), lista);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public JasperPrint generarReporteSaldoConsolidadoBonosViaticos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoBonosViaticosTO> listaSaldoConsolidadoBonosViaticosTO) throws Exception {
        try {
            List<ReporteSaldoConsolidadoBonosViaticos> lista = new ArrayList();
            for (RhListaSaldoConsolidadoBonosViaticosTO rldvpg : listaSaldoConsolidadoBonosViaticosTO) {
                ReporteSaldoConsolidadoBonosViaticos reporteSaldoConsolidadoBonoViatico =
                        new ReporteSaldoConsolidadoBonosViaticos();

                reporteSaldoConsolidadoBonoViatico.setFechaHasta(fechaHasta);
                reporteSaldoConsolidadoBonoViatico.setScbvCategoria((rldvpg.getScbvCategoria() == null ? "" : rldvpg.getScbvCategoria()));
                reporteSaldoConsolidadoBonoViatico.setScbvId((rldvpg.getScbvId() == null ? "" : rldvpg.getScbvId()));
                reporteSaldoConsolidadoBonoViatico.setScbvNombres((rldvpg.getScbvNombres() == null ? "" : rldvpg.getScbvNombres()));
                reporteSaldoConsolidadoBonoViatico.setScbvBonos((rldvpg.getScbvBonos() == null ? null : rldvpg.getScbvBonos()));
                reporteSaldoConsolidadoBonoViatico.setScbvViaticos((rldvpg.getScbvViaticos() == null ? null : rldvpg.getScbvViaticos()));
                reporteSaldoConsolidadoBonoViatico.setScbvTotal((rldvpg.getScbvTotal() == null ? null : rldvpg.getScbvTotal()));
                reporteSaldoConsolidadoBonoViatico.setScbvOrden((rldvpg.getScbvOrden() == null ? "" : rldvpg.getScbvOrden()));

                lista.add(reporteSaldoConsolidadoBonoViatico);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportSaldoConsolidadoBonosViaticos.jrxml",
                    new HashMap(), lista);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteSaldoConsolidadoSueldosPorPagar(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoSueldosPorPagarTO> listaSaldoConsolidadoSueldosPorPagarTO) throws Exception {
        try {
            List<ReporteSaldoConsolidadoSueldoPorPagar> lista = new ArrayList();
            for (RhListaSaldoConsolidadoSueldosPorPagarTO rldvpg : listaSaldoConsolidadoSueldosPorPagarTO) {
                ReporteSaldoConsolidadoSueldoPorPagar reporteSaldoConsolidadoSueldoPorPagar =
                        new ReporteSaldoConsolidadoSueldoPorPagar();

                reporteSaldoConsolidadoSueldoPorPagar.setFechaHasta(fechaHasta);
                reporteSaldoConsolidadoSueldoPorPagar.setScspCategoria((rldvpg.getScspCategoria() == null ? "" : rldvpg.getScspCategoria()));
                reporteSaldoConsolidadoSueldoPorPagar.setScspId((rldvpg.getScspId() == null ? "" : rldvpg.getScspId()));
                reporteSaldoConsolidadoSueldoPorPagar.setScspNombres((rldvpg.getScspNombres() == null ? "" : rldvpg.getScspNombres()));
                reporteSaldoConsolidadoSueldoPorPagar.setScspValor((rldvpg.getScspValor() == null ? null : rldvpg.getScspValor()));
                reporteSaldoConsolidadoSueldoPorPagar.setScspOrden((rldvpg.getScspOrden() == null ? "" : rldvpg.getScspOrden()));

                lista.add(reporteSaldoConsolidadoSueldoPorPagar);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportSaldoConsolidadoSueldosPorPagar.jrxml",
                    new HashMap(), lista);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteXiiiSueldoConsulta(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta,
            String fechaMaxima, List<RhFunXiiiSueldoConsultarTO> rhFunXiiiSueldoConsultarTO) throws Exception {
        try {
            List<ReporteXiiiSueldoConsulta> lista = new ArrayList();
            for (RhFunXiiiSueldoConsultarTO rldvpg : rhFunXiiiSueldoConsultarTO) {
                ReporteXiiiSueldoConsulta reporteXiiiSueldoConsulta =
                        new ReporteXiiiSueldoConsulta();

                reporteXiiiSueldoConsulta.setSector(sector);
                reporteXiiiSueldoConsulta.setPeriodo(periodo);
                reporteXiiiSueldoConsulta.setFechaDesde(fechaDesde);
                reporteXiiiSueldoConsulta.setFechaHasta(fechaHasta);
                reporteXiiiSueldoConsulta.setFechaMaxima(fechaMaxima);

                reporteXiiiSueldoConsulta.setXiiiCategoria((rldvpg.getXiiiCategoria() == null ? "" : rldvpg.getXiiiCategoria()));
                reporteXiiiSueldoConsulta.setXiiiSector((rldvpg.getXiiiSector() == null ? "" : rldvpg.getXiiiSector()));
                reporteXiiiSueldoConsulta.setXiiiId((rldvpg.getXiiiId() == null ? "" : rldvpg.getXiiiId()));
                reporteXiiiSueldoConsulta.setXiiiNombres((rldvpg.getXiiiNombres() == null ? "" : rldvpg.getXiiiNombres()));
                reporteXiiiSueldoConsulta.setXiiiApellidos((rldvpg.getXiiiApellidos() == null ? "" : rldvpg.getXiiiApellidos()));
                reporteXiiiSueldoConsulta.setXiiiGenero((rldvpg.getXiiiGenero() == null ? null : rldvpg.getXiiiGenero()));
                reporteXiiiSueldoConsulta.setXiiiFechaIngreso((rldvpg.getXiiiFechaIngreso() == null ? "" : rldvpg.getXiiiFechaIngreso()));
                reporteXiiiSueldoConsulta.setXiiiCargo((rldvpg.getXiiiCargo() == null ? "" : rldvpg.getXiiiCargo()));
                reporteXiiiSueldoConsulta.setXiiiTotalIngresos((rldvpg.getXiiiTotalIngresos() == null ? null : rldvpg.getXiiiTotalIngresos()));
                reporteXiiiSueldoConsulta.setXiiiDiasLaborados((rldvpg.getXiiiDiasLaborados() == null ? null : rldvpg.getXiiiDiasLaborados()));
                reporteXiiiSueldoConsulta.setXiiiValorXiiiSueldo((rldvpg.getXiiiValorXiiiSueldo() == null ? null : rldvpg.getXiiiValorXiiiSueldo()));
                reporteXiiiSueldoConsulta.setXiiiCodigoMinisterial((rldvpg.getXiiiCodigoMinisterial() == null ? null : rldvpg.getXiiiCodigoMinisterial()));
                //Contalbe
                reporteXiiiSueldoConsulta.setXiiiNumero((rldvpg.getXiiiNumero() == null ? "" : rldvpg.getXiiiNumero()));//                

                lista.add(reporteXiiiSueldoConsulta);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportXiiiSueldoConsulta.jrxml",
                    new HashMap(), lista);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteXivSueldoConsulta(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String sector, String periodo,
            String fechaDesde, String fechaHasta, String fechaMaxima,
            List<RhFunXivSueldoConsultarTO> rhFunXivSueldoConsultarTO) throws Exception {
        try {
            List<ReporteXivSueldoConsulta> lista = new ArrayList();
            for (RhFunXivSueldoConsultarTO rldvpg : rhFunXivSueldoConsultarTO) {
                ReporteXivSueldoConsulta reporteXivSueldoConsulta =
                        new ReporteXivSueldoConsulta();

                reporteXivSueldoConsulta.setSector(sector);
                reporteXivSueldoConsulta.setPeriodo(periodo);
                reporteXivSueldoConsulta.setFechaDesde(fechaDesde);
                reporteXivSueldoConsulta.setFechaHasta(fechaHasta);
                reporteXivSueldoConsulta.setFechaMaxima(fechaMaxima);

                reporteXivSueldoConsulta.setXivCategoria((rldvpg.getXivCategoria() == null ? "" : rldvpg.getXivCategoria()));
                reporteXivSueldoConsulta.setXivSector((rldvpg.getXivSector() == null ? "" : rldvpg.getXivSector()));
                reporteXivSueldoConsulta.setXivId((rldvpg.getXivId() == null ? "" : rldvpg.getXivId()));
                reporteXivSueldoConsulta.setXivNombres((rldvpg.getXivNombres() == null ? "" : rldvpg.getXivNombres()));
                reporteXivSueldoConsulta.setXivApellidos((rldvpg.getXivApellidos() == null ? "" : rldvpg.getXivApellidos()));
                reporteXivSueldoConsulta.setXivGenero((rldvpg.getXivGenero() == null ? null : rldvpg.getXivGenero()));
                reporteXivSueldoConsulta.setXivFechaIngreso((rldvpg.getXivFechaIngreso() == null ? "" : rldvpg.getXivFechaIngreso()));
                reporteXivSueldoConsulta.setXivCargo((rldvpg.getXivCargo() == null ? "" : rldvpg.getXivCargo()));
                reporteXivSueldoConsulta.setXivTotalIngresos((rldvpg.getXivTotalIngresos() == null ? null : rldvpg.getXivTotalIngresos()));
                reporteXivSueldoConsulta.setXivDiasLaborados((rldvpg.getXivDiasLaborados() == null ? null : rldvpg.getXivDiasLaborados()));
                reporteXivSueldoConsulta.setXivValorXivSueldo((rldvpg.getXivValorXivSueldo() == null ? null : rldvpg.getXivValorXivSueldo()));
                reporteXivSueldoConsulta.setXivCodigoMinisterial((rldvpg.getXivCodigoMinisterial() == null ? null : rldvpg.getXivCodigoMinisterial()));
                //Contalbe
                reporteXivSueldoConsulta.setXivNumero((rldvpg.getXivNumero() == null ? "" : rldvpg.getXivNumero()));//                

                lista.add(reporteXivSueldoConsulta);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportXivSueldoConsulta.jrxml",
                    new HashMap(), lista);
            //return null; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteUtilidadesPreCalculo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta, String fechaMaxima,
            List<RhFunUtilidadesCalcularTO> rhFunUtilidadesCalcularTOs) throws Exception {
        try {
            List<ReporteFunUtilidadesCalcular> lista = new ArrayList();
            for (RhFunUtilidadesCalcularTO rldvpg : rhFunUtilidadesCalcularTOs) {
                ReporteFunUtilidadesCalcular reporteFunUtilidadCalcular =
                        new ReporteFunUtilidadesCalcular();

                reporteFunUtilidadCalcular.setSector(sector);
                reporteFunUtilidadCalcular.setPeriodo(periodo);
                reporteFunUtilidadCalcular.setFechaDesde(fechaDesde);
                reporteFunUtilidadCalcular.setFechaHasta(fechaHasta);
                reporteFunUtilidadCalcular.setFechaMaxima(fechaMaxima);
                reporteFunUtilidadCalcular.setXivId((rldvpg.getUtiId() == null ? "" : rldvpg.getUtiId()));
                reporteFunUtilidadCalcular.setXivNombres((rldvpg.getUtiNombres() == null ? "" : rldvpg.getUtiNombres()));
                reporteFunUtilidadCalcular.setXivApellidos((rldvpg.getUtiApellidos() == null ? "" : rldvpg.getUtiApellidos()));
                reporteFunUtilidadCalcular.setXivGenero((rldvpg.getUtiGenero() == null ? null : rldvpg.getUtiGenero()));
                reporteFunUtilidadCalcular.setXivFechaIngreso((rldvpg.getUtiFechaIngreso() == null ? "" : rldvpg.getUtiFechaIngreso()));
                reporteFunUtilidadCalcular.setXivFechaSalida((rldvpg.getUtiFechaSalida() == null ? "" : rldvpg.getUtiFechaSalida()));
                reporteFunUtilidadCalcular.setXivCargo((rldvpg.getUtiCargo() == null ? "" : rldvpg.getUtiCargo()));
                reporteFunUtilidadCalcular.setXivCargasFamiliares((rldvpg.getUtiCargasFamiliares() == null ? 0 : rldvpg.getUtiCargasFamiliares()));
                reporteFunUtilidadCalcular.setXivDiasLaborados((rldvpg.getUtiDiasLaborados() == null ? 0 : rldvpg.getUtiDiasLaborados()));
                reporteFunUtilidadCalcular.setXivValorPersonal((rldvpg.getUtiValorPersonal() == null ? null : rldvpg.getUtiValorPersonal()));
                reporteFunUtilidadCalcular.setXivValorCargas((rldvpg.getUtiValorCargas() == null ? null : rldvpg.getUtiValorCargas()));
                reporteFunUtilidadCalcular.setXivValorUtilidades((rldvpg.getUtiValorUtilidades() == null ? null : rldvpg.getUtiValorUtilidades()));
                reporteFunUtilidadCalcular.setXivValorSueldos((rldvpg.getUtiValorSueldos() == null ? null : rldvpg.getUtiValorSueldos()));
                reporteFunUtilidadCalcular.setXivValorBonos((rldvpg.getUtiValorBonos() == null ? null : rldvpg.getUtiValorBonos()));
                reporteFunUtilidadCalcular.setXivValorXiii((rldvpg.getUtiValorXiii() == null ? null : rldvpg.getUtiValorXiii()));
                reporteFunUtilidadCalcular.setXivValorXiv((rldvpg.getUtiValorXiv() == null ? null : rldvpg.getUtiValorXiv()));
                reporteFunUtilidadCalcular.setXivValorFondoReserva((rldvpg.getUtiValorFondoReserva() == null ? null : rldvpg.getUtiValorFondoReserva()));
                reporteFunUtilidadCalcular.setXivValorSalarioDigno((rldvpg.getUtiValorSalarioDigno() == null ? null : rldvpg.getUtiValorSalarioDigno()));
                reporteFunUtilidadCalcular.setXivValorUtilidadAnterior((rldvpg.getUtiValorUtilidadAnterior() == null ? null : rldvpg.getUtiValorUtilidadAnterior()));
                reporteFunUtilidadCalcular.setXivValorImpuesto((rldvpg.getUtiValorImpuesto() == null ? null : rldvpg.getUtiValorImpuesto()));
                reporteFunUtilidadCalcular.setXivCategoria((rldvpg.getUtiCategoria() == null ? "" : rldvpg.getUtiCategoria()));
                reporteFunUtilidadCalcular.setXivCuenta((rldvpg.getUtiCuenta() == null ? "" : rldvpg.getUtiCuenta()));
                reporteFunUtilidadCalcular.setXivSector((rldvpg.getUtiSector() == null ? "" : rldvpg.getUtiSector()));
                reporteFunUtilidadCalcular.setEstado((rldvpg.isEstado() == false ? false : rldvpg.isEstado()));

                lista.add(reporteFunUtilidadCalcular);

            }
            return generarReporte(sisUsuarioEmpresaTO, "reportXivSueldoConsulta.jrxml",
                    new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public JasperPrint generarReporteProvisionesComprobanteContable(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String periodo, String tipo,
            String numero, List<RhListaProvisionesTO> listaProvisionesTO) throws Exception {
        try {
            List<ReporteProvisionesComprobanteContable> lista = new ArrayList();
            for (RhListaProvisionesTO rldvpg : listaProvisionesTO) {
                ReporteProvisionesComprobanteContable reporteProvisionesComprobanteContable =
                        new ReporteProvisionesComprobanteContable();

                reporteProvisionesComprobanteContable.setPeriodo(periodo);
                reporteProvisionesComprobanteContable.setTipo(tipo);
                reporteProvisionesComprobanteContable.setNumero(numero);

                reporteProvisionesComprobanteContable.setProvId((rldvpg.getProvId() == null ? "" : rldvpg.getProvId()));
                reporteProvisionesComprobanteContable.setProvNombres((rldvpg.getProvNombres() == null ? "" : rldvpg.getProvNombres()));
                reporteProvisionesComprobanteContable.setProvSueldo((rldvpg.getProvSueldo() == null ? null : rldvpg.getProvSueldo()));
                reporteProvisionesComprobanteContable.setProvDiasPagados((rldvpg.getProvDiasPagados() == null ? null : rldvpg.getProvDiasPagados()));
                reporteProvisionesComprobanteContable.setProvAporteIndividual((rldvpg.getProvAporteIndividual() == null ? null : rldvpg.getProvAporteIndividual()));
                reporteProvisionesComprobanteContable.setProvAportePatronal((rldvpg.getProvAportePatronal() == null ? null : rldvpg.getProvAportePatronal()));
                reporteProvisionesComprobanteContable.setProvIece((rldvpg.getProvIece() == null ? null : rldvpg.getProvIece()));
                reporteProvisionesComprobanteContable.setProvSecap((rldvpg.getProvSecap() == null ? null : rldvpg.getProvSecap()));
                reporteProvisionesComprobanteContable.setProvXiii((rldvpg.getProvXiii() == null ? null : rldvpg.getProvXiii()));
                reporteProvisionesComprobanteContable.setProvXiv((rldvpg.getProvXiv() == null ? null : rldvpg.getProvXiv()));
                reporteProvisionesComprobanteContable.setProvFondoReserva((rldvpg.getProvFondoReserva() == null ? null : rldvpg.getProvFondoReserva()));
                reporteProvisionesComprobanteContable.setProvVacaciones((rldvpg.getProvVacaciones() == null ? null : rldvpg.getProvVacaciones()));
                reporteProvisionesComprobanteContable.setProvDesahucio((rldvpg.getProvDesahucio() == null ? null : rldvpg.getProvDesahucio()));
                reporteProvisionesComprobanteContable.setProvContableRol((rldvpg.getProvContableRol() == null ? "" : rldvpg.getProvContableRol()));
                reporteProvisionesComprobanteContable.setProvContableProvision((rldvpg.getProvContableProvision() == null ? "" : rldvpg.getProvContableProvision()));

                lista.add(reporteProvisionesComprobanteContable);

            }
            return generarReporte(sisUsuarioEmpresaTO, "reportComprobanteProvisiones.jrxml",
                    new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteFormulario107(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaEntrega, String rucEmpleador, String razonSocial, String rucContador,
            RhFormulario107TO rhFormulario107TOGuardar) throws Exception {
        try {
            List<ReporteFormulario107> lista = new ArrayList();

            ReporteFormulario107 rhFormulario107 = new ReporteFormulario107();

            rhFormulario107.setF107Anio(rhFormulario107TOGuardar.getF107Anio());
            rhFormulario107.setF107Tipo(rhFormulario107TOGuardar.getF107Tipo());
            rhFormulario107.setF107Id(rhFormulario107TOGuardar.getF107Id());
            rhFormulario107.setF107Nombres(rhFormulario107TOGuardar.getF107Nombres());
            rhFormulario107.setF107Direccion(rhFormulario107TOGuardar.getF107Direccion());
            rhFormulario107.setF107Numero(rhFormulario107TOGuardar.getF107Direccion());
            rhFormulario107.setF107Canton(rhFormulario107TOGuardar.getF107Canton());
            rhFormulario107.setF107Provincia(rhFormulario107TOGuardar.getF107Provincia());
            rhFormulario107.setF107Telefono(rhFormulario107TOGuardar.getF107Telefono());
            rhFormulario107.setF107SalarioNeto(rhFormulario107TOGuardar.getF107SalarioNeto());
            rhFormulario107.setF107Sueldo(rhFormulario107TOGuardar.getF107Sueldo());
            rhFormulario107.setF107Bonos(rhFormulario107TOGuardar.getF107Bonos());
            rhFormulario107.setF107XiiiSueldo(rhFormulario107TOGuardar.getF107XiiiSueldo());
            rhFormulario107.setF107XivSueldo(rhFormulario107TOGuardar.getF107XivSueldo());
            rhFormulario107.setF107FondoReserva(rhFormulario107TOGuardar.getF107FondoReserva());
            rhFormulario107.setF107SalarioDigno(rhFormulario107TOGuardar.getF107SalarioDigno());
            rhFormulario107.setF107Utilidades(rhFormulario107TOGuardar.getF107Utilidades());
            rhFormulario107.setF107Desahucio(rhFormulario107TOGuardar.getF107Desahucio());
            rhFormulario107.setF107Iess(rhFormulario107TOGuardar.getF107Iess());
            rhFormulario107.setF107Vivienda(rhFormulario107TOGuardar.getF107Vivienda());
            rhFormulario107.setF107Salud(rhFormulario107TOGuardar.getF107Salud());
            rhFormulario107.setF107Educacion(rhFormulario107TOGuardar.getF107Educacion());
            rhFormulario107.setF107Alimentacion(rhFormulario107TOGuardar.getF107Alimentacion());
            rhFormulario107.setF107Vestuario(rhFormulario107TOGuardar.getF107Vestuario());
            rhFormulario107.setF107RebajaDiscapacitado(rhFormulario107TOGuardar.getF107RebajaDiscapacitado());
            rhFormulario107.setF107RebajaTerceraEdad(rhFormulario107TOGuardar.getF107RebajaTerceraEdad());
            rhFormulario107.setF107ImpuestoAsumido(rhFormulario107TOGuardar.getF107ImpuestoAsumido());
            rhFormulario107.setF107Subtotal(rhFormulario107TOGuardar.getF107Subtotal());
            rhFormulario107.setF107MesesTrabajados(rhFormulario107TOGuardar.getF107MesesTrabajados());
            rhFormulario107.setF107OtrosIngresos(rhFormulario107TOGuardar.getF107OtrosIngresos());
            rhFormulario107.setF107OtrasDeducciones(rhFormulario107TOGuardar.getF107OtrasDeducciones());
            rhFormulario107.setF107OtrasRebajas(rhFormulario107TOGuardar.getF107OtrasRebajas());
            rhFormulario107.setF107BaseImponible(rhFormulario107TOGuardar.getF107BaseImponible());
            rhFormulario107.setF107ImpuestoCausado(rhFormulario107TOGuardar.getF107ImpuestoCausado());
            rhFormulario107.setF107ValorRetenido(rhFormulario107TOGuardar.getF107ValorRetenido());
            rhFormulario107.setF107NumeroRetenciones(rhFormulario107TOGuardar.getF107NumeroRetenciones());
            rhFormulario107.setF107Impuesto(rhFormulario107TOGuardar.getF107Impuesto());
            rhFormulario107.setUsrCodigo(rhFormulario107TOGuardar.getUsrCodigo());
            rhFormulario107.setUsrFechaInserta(rhFormulario107TOGuardar.getUsrFechaInserta());

            rhFormulario107.setF107FechaEntrega(fechaEntrega);
            rhFormulario107.setF107RucEmpleador(rucEmpleador);
            rhFormulario107.setF107NombreEmpleador(razonSocial);
            rhFormulario107.setF107RucContador(rucContador);

            lista.add(rhFormulario107);


            return generarReporte(sisUsuarioEmpresaTO, "reportFormulario107.jrxml",
                    new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteAnticipo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteAnticipoOprestamo> rhReporteAnticipoOprestamos) throws Exception {

        return generarReporte(sisUsuarioEmpresaTO, "reportComprobanteAnticipo.jrxml",
                new HashMap(), rhReporteAnticipoOprestamos);
    }

    public JasperPrint generarReporteConsultaAnticiposLote(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteConsultaAnticiposLote> lista) throws Exception {


        return generarReporte(sisUsuarioEmpresaTO, "reportComprobanteAnticipoPorLote.jrxml",
                new HashMap(), lista);
    }

    public JasperPrint generarReportePrestamoVista(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteAnticipoOprestamo> lista) throws Exception {
        return generarReporte(sisUsuarioEmpresaTO, "reportComprobantePrestamo.jrxml",
                new HashMap(), lista);
    }

    public JasperPrint generarReporteRol(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReportesRol> lista) throws Exception {
        
        return generarReporte(sisUsuarioEmpresaTO, "reportComprobanteRol.jrxml",
                new HashMap(), lista);
    }

    public JasperPrint generarReporteEmpleado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteEmpleado> listReporteEmpleado) throws Exception {
        return generarReporte(sisUsuarioEmpresaTO, "reportEmpleado.jrxml",
                new HashMap(), listReporteEmpleado);
    }

    public JasperPrint generarReporteRol2(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<AuxiliarReporteDetalleRoles> lista) {
        return generarReporte(sisUsuarioEmpresaTO, "reportComprobanteRol.jrxml",
                new HashMap(), lista);
    }
}
