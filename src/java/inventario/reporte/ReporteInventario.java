/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.reporte;
//shrimp.inventario.reporte.ReporteVentaDetalle
import inventario.reporte.ReporteVentaDetalle;
import inventario.reporte.ReporteProformaDetalle;
import inventario.reporte.ReporteCompraDetalle;
import contabilidad.reporte.ReporteConListaBalanceResultadosVsInventario;
import inventario.reporte.ReporteCompraDetalleContableDetalle;

/**
 *
 * @author jack
 */
public class ReporteInventario {

    public static java.util.List<ReporteCompraDetalle> listaCompraDetalle = new java.util.ArrayList();
    public static java.util.List<ReporteCompraDetalleContableDetalle> listaCompraDetalleContableDetalles = new java.util.ArrayList();
    public static java.util.List<ReporteVentaDetalle> listaVentaDetalle = new java.util.ArrayList();
    public static java.util.List<ReporteProformaDetalle> listaProformaDetalle = new java.util.ArrayList();
    public static java.util.List<ReporteConListaBalanceResultadosVsInventario> listaSaldoBodegaDetallado = new java.util.ArrayList();
    public static java.util.List<inventario.TO.SaldoBodegaComprobacionTOOLD> reporteInvFunSaldoBodegaComprobacions = new java.util.ArrayList();
    public static java.util.List<inventario.reporte.InvListaConsultaCompra> invListaConsultaCompras = new java.util.ArrayList();
    public static java.util.List<inventario.reporte.InvListaConsultaVenta> invListaConsultaVentas = new java.util.ArrayList();
    public static java.util.List<inventario.reporte.InvListaConsultaConsumo> invListaConsultaConsumos = new java.util.ArrayList();
    public static java.util.List<inventario.reporte.InvListaConsultaTransferencia> invListaConsultaTransferencias = new java.util.ArrayList();

    public static java.util.List<ReporteCompraDetalle> rellenarValoresCompraDetalle(java.util.List<ReporteCompraDetalle> lista) {
        listaCompraDetalle = lista;
        return listaCompraDetalle;
    }
    public static java.util.Collection<ReporteCompraDetalle> generarColeccionCompraDetalle() {
        return listaCompraDetalle;
    }
    public static java.util.List<ReporteCompraDetalleContableDetalle> rellenarValoresCompraDetalleContableDetalle(java.util.List<ReporteCompraDetalleContableDetalle> lista) {
        listaCompraDetalleContableDetalles = lista;
        return listaCompraDetalleContableDetalles;
    }
    public static java.util.Collection<ReporteCompraDetalleContableDetalle> generarColeccionCompraDetalleContableDetalle() {
        return listaCompraDetalleContableDetalles;
    }

    public static java.util.List<ReporteVentaDetalle> rellenarValoresVentaDetalle(java.util.List<ReporteVentaDetalle> lista) {
        listaVentaDetalle = lista;
        return listaVentaDetalle;
    }

    public static java.util.List<ReporteProformaDetalle> rellenarValoresProformaDetalle(java.util.List<ReporteProformaDetalle> lista) {
        listaProformaDetalle = lista;
        return listaProformaDetalle;
    }

    public static java.util.List<inventario.reporte.InvListaConsultaCompra> rellenarValoresReporteInvListaConsultaCompra(java.util.List<inventario.reporte.InvListaConsultaCompra> lista) {
        invListaConsultaCompras = lista;
        return invListaConsultaCompras;
    }

    public static java.util.List<inventario.reporte.InvListaConsultaVenta> rellenarValoresReporteInvListaConsultaVenta(java.util.List<inventario.reporte.InvListaConsultaVenta> lista) {
        invListaConsultaVentas = lista;
        return invListaConsultaVentas;
    }

    public static java.util.List<inventario.reporte.InvListaConsultaConsumo> rellenarValoresReporteInvListaConsultaConsumo(java.util.List<inventario.reporte.InvListaConsultaConsumo> lista) {
        invListaConsultaConsumos = lista;
        return invListaConsultaConsumos;
    }

    public static java.util.List<inventario.reporte.InvListaConsultaTransferencia> rellenarValoresReporteInvListaConsultaTransferencia(java.util.List<inventario.reporte.InvListaConsultaTransferencia> lista) {
        invListaConsultaTransferencias = lista;
        return invListaConsultaTransferencias;
    }

    public static java.util.Collection<inventario.reporte.InvListaConsultaCompra> generarColeccionReporteInvListaConsultaCompra() {
        return invListaConsultaCompras;
    }

    public static java.util.Collection<inventario.reporte.InvListaConsultaVenta> generarColeccionReporteInvListaConsultaVenta() {
        return invListaConsultaVentas;
    }

    public static java.util.Collection<inventario.reporte.InvListaConsultaConsumo> generarColeccionReporteInvListaConsultaConsumo() {
        return invListaConsultaConsumos;
    }

    public static java.util.Collection<inventario.reporte.InvListaConsultaTransferencia> generarColeccionReporteInvListaConsultaTransferencia() {
        return invListaConsultaTransferencias;
    }

   

    public static java.util.Collection<ReporteVentaDetalle> generarColeccionVentaDetalle() {
        return listaVentaDetalle;
    }

    public static java.util.Collection<ReporteProformaDetalle> generarColeccionProformaDetalle() {
        return listaProformaDetalle;
    }

//    public static java.util.List<ReporteInvFunSaldoBodegaComprobacion> rellenarValoresReporteInvFunSaldoBodegaComprobacion(java.util.List<ReporteInvFunSaldoBodegaComprobacion> lista) {
//        reporteInvFunSaldoBodegaComprobacions = lista;
//        return reporteInvFunSaldoBodegaComprobacions;
//    }

    public static java.util.List<ReporteConListaBalanceResultadosVsInventario> rellenarValoresSaldoBodegaDetallado(java.util.List<ReporteConListaBalanceResultadosVsInventario> lista) {
        listaSaldoBodegaDetallado = lista;
        return listaSaldoBodegaDetallado;
    }

    public static java.util.Collection<ReporteConListaBalanceResultadosVsInventario> generarColeccionSaldoBodegaDetallado() {
//        java.util.List <ReporteCompraDetalle> listaCompraDetalle = new java.util.ArrayList();
        return listaSaldoBodegaDetallado;
    }

//    public static java.util.Collection<ReporteInvFunSaldoBodegaComprobacion> generarColeccionReporteInvFunSaldoBodegaComprobacion() {
////        java.util.List <ReporteCompraDetalle> listaCompraDetalle = new java.util.ArrayList();
//        return reporteInvFunSaldoBodegaComprobacions;
//    }
}
