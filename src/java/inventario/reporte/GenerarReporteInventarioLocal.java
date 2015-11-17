/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.reporte;

import contabilidad.TO.*;
import inventario.TO.*;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author paca94
 */
@Local
public interface GenerarReporteInventarioLocal {

    public JasperPrint generarReporteInvKardex(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String nombreProducto, String fechaDesde,
            String fechaHasta, List<InvKardexTO> listInvKardexTO, boolean banderaCosto) throws Exception;

    public JasperPrint generarReporteImpresionPlaca(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, LinkedList listProductosImpresionPlaca) throws Exception;

    public JasperPrint generarReporteListadoCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String motivo, String proveedorId, String documento,
            List<InvFunComprasTO> listInvFunComprasTO) throws Exception;

    public JasperPrint generarReporteConsolidadoCompraProducto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String bodega, String proveedor, List<InvFunComprasConsolidandoProductosTO> listInvFunComprasConsolidandoProductosTO) throws Exception;

    public JasperPrint generarReporteListadoVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String motivo, String cliente, String documento,
            List<InvFunVentasTO> listInvFunVentasTO) throws Exception;

    public JasperPrint generarReporteConsolidadoVentaProducto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String bodega, String cliente, List<InvFunVentasConsolidandoProductosTO> listInvFunVentasConsolidandoProductosTO) throws Exception;

    public JasperPrint generarReporteListadoConsumos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta, List<InvFunConsumosTO> listInvFunConsumosTO) throws Exception;

    public JasperPrint generarReporteListaProductos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega,
            List<InvListaProductosTO> listInvListaProductosTO) throws Exception;

    public JasperPrint generarReporteSaldoBodega(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega, String fechaHasta,
            List<SaldoBodegaTO> listSaldoBodegaTO) throws Exception;
    
    public JasperPrint generarReporteSaldoBodegaComprobacion(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega, 
            String fechaDesde, String fechaHasta, 
            List<SaldoBodegaComprobacionTO> lista)throws Exception;

    public JasperPrint generarReporteInvProductosConError(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<InvProductosConErrorTO> listInvProductosConErrorTO) throws Exception;

    public JasperPrint generarReporteTrasferencias(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteTransferenciaDetalle> listReporteTransferenciaDetalle) throws Exception;

    public JasperPrint generarReporteConsumoDetalle(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            boolean ordenado,
            List<ReporteConsumoDetalle> reporteConsumoDetalles)throws Exception;

    public JasperPrint generarReporteCompraDetalle(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<ReporteCompraDetalle> reporteCompraDetalles)throws Exception;

    public JasperPrint generarReporteVentaDetalleImpresion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<ReporteVentaDetalle> lista, String nombreCliente, String nombreReporte)throws Exception;
    
    public JasperPrint generarReporteProformaDetalleImpresion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<ReporteProformaDetalle> lista, String nombreReporte)throws Exception;

    public JasperPrint generarReporteInvFunVentasVsCosto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String fechaDesde, String fechaHasta, String bodega, String clienteId, 
            List<InvFunVentasVsCostoTO> invFunVentasVsCostoTO)throws Exception;

    public JasperPrint generarReporteCompraDetalleImprimir(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<ReporteCompraDetalle> reporteCompraDetalles, String cmFormaImprimir)throws Exception;



    
}
