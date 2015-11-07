/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.reporte;

import contabilidad.TO.ConContableReporteTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import sistema.TO.SisUsuarioEmpresaTO;
import sistema.business.OperacionesSistemaBusinessLocal;

/**
 *
 * @author developer2
 */
public class ReporteContabilidad {
    
    @EJB
    OperacionesSistemaBusinessLocal  operacionesSistemaBusinessLocal;
    
    //public static java.util.List<ReporteContableDetalle> listaContableDetalle = new java.util.ArrayList();
//    
//    public static java.util.List<ConContableReporteTO> rellenarValoresContableDetalle(java.util.List<ConContableReporteTO> lista) {
//        listaContableDetalle = lista;
//        return listaContableDetalle;
//    }
    
    
    public static java.util.List<ReporteContableDetalle> generarColeccionContableDetalle(
            SisUsuarioEmpresaTO su, List<ConContableReporteTO> listConContableReporteTO) {
        java.util.List<ReporteContableDetalle> listaContableDetalle = new java.util.ArrayList();
        try {
//                List<ReporteContableDetalle> listReporteContableDetalle = new ArrayList<ReporteContableDetalle>();
            for (ConContableReporteTO ccrto : listConContableReporteTO) {
                if (ccrto != null) {
                    for (int i = 0; i < ccrto.getListConDetalleTablaTO().size(); i++) {
                        ReporteContableDetalle reporteContableDetalle = new ReporteContableDetalle();
                        ///////////TITULO REPORTE
                        reporteContableDetalle.setTitulo(ccrto.getTitulo());
                        ///////////CABECERA
                        reporteContableDetalle.setEmpCodigo(ccrto.getConContableTO().getEmpCodigo());
                        reporteContableDetalle.setPerCodigo(ccrto.getConContableTO().getPerCodigo());
                        reporteContableDetalle.setTipCodigo(ccrto.getConContableTO().getTipCodigo());
                        reporteContableDetalle.setConNumero(ccrto.getConContableTO().getConNumero());
                        reporteContableDetalle.setConFecha(ccrto.getConContableTO().getConFecha());
                        reporteContableDetalle.setConPendiente(ccrto.getConContableTO().getConPendiente());
                        reporteContableDetalle.setConRevisado(ccrto.getConContableTO().getConAnulado());
                        reporteContableDetalle.setConAnulado(ccrto.getConContableTO().getConAnulado());
                        reporteContableDetalle.setConGenerado(ccrto.getConContableTO().getConGenerado());
                        reporteContableDetalle.setConConcepto(ccrto.getConContableTO().getConConcepto());
                        reporteContableDetalle.setConDetalle(ccrto.getConContableTO().getConDetalle());
                        reporteContableDetalle.setConObservaciones(ccrto.getConContableTO().getConObservaciones());
                        reporteContableDetalle.setUsrInserta(ccrto.getConContableTO().getUsrInsertaContable());
                        reporteContableDetalle.setUsrFechaInserta(ccrto.getConContableTO().getUsrFechaInsertaContable());

                        reporteContableDetalle.setImpElaborado(su.getEmpNombre());

                        reporteContableDetalle.setImpAprobado(su.getEmpGerente());
                        reporteContableDetalle.setImpRevisado("");
                        reporteContableDetalle.setImpContabilidad(su.getEmpContador());
                        /////////////DETALLE
                        reporteContableDetalle.setConCtaCodigoPadre(ccrto.getCuentaPadre().get(i).trim().toString().substring(0, ccrto.getCuentaPadre().get(i).trim().toString().indexOf("|")).trim());
                        reporteContableDetalle.setConNombreCuentaPadre(ccrto.getCuentaPadre().get(i).trim().toString().substring(ccrto.getCuentaPadre().get(i).trim().toString().indexOf("|") + 1).trim());
                        reporteContableDetalle.setConCtaCodigo(ccrto.getListConDetalleTablaTO().get(i).getCtaCodigo());
                        reporteContableDetalle.setConNombreCuenta(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalle());
                        reporteContableDetalle.setDetCentroProduccion(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleCentroProduccion());
                        reporteContableDetalle.setDetCentroCosto(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleCentroCosto() == null ? "" : ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleCentroCosto());
                        reporteContableDetalle.setDetDocumento(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleDocumento() == null ? "" : ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleDocumento());
                        if (ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleDebitoCredito() == 'D') {
                            reporteContableDetalle.setDetDebitoCredito('D');
                            reporteContableDetalle.setDetValor(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleValor());
                        } else {
                            reporteContableDetalle.setDetDebitoCredito('C');
                            reporteContableDetalle.setDetValor(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleValor());
                        }
                        reporteContableDetalle.setDetGenerado(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleGenerado());
                        reporteContableDetalle.setDetReferencia(ccrto.getListConDetalleTablaTO().get(i).getCtaDetalleReferencia());
                        reporteContableDetalle.setDetOrden(i + 1);
                        listaContableDetalle.add(reporteContableDetalle);
                    }
                }
            }
            return listaContableDetalle;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }     
}
