/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.reporte;

import inventario.TO.*;
import java.math.BigDecimal;
import java.util.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
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
public class GenerarReporteInventario implements GenerarReporteInventarioLocal {

    @EJB
    OperacionesSistemaBusinessLocal operacionesSistemaBusinessLocal;

    public JasperPrint generarReporteInvKardex(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String nombreProducto, String fechaDesde,
            String fechaHasta, List<InvKardexTO> listInvKardexTO, boolean banderaCosto) throws Exception {
        try {
            List<ReporteInvKardexDetalle> listaReporteInvKardexDetalleParametro = new ArrayList();
            for (InvKardexTO invKardexTO : listInvKardexTO) {
                ReporteInvKardexDetalle reporteInvKardexDetalle = new ReporteInvKardexDetalle();
                reporteInvKardexDetalle.setSisUsuarioEmpresaTO(sisUsuarioEmpresaTO.getEmpRazonSocial());
                reporteInvKardexDetalle.setNomProducto(nombreProducto);
                reporteInvKardexDetalle.setFechaDesde(fechaDesde);
                reporteInvKardexDetalle.setFechaHasta(fechaHasta);
                reporteInvKardexDetalle.setKtransaccion(invKardexTO.getkTransaccion().toString());
                reporteInvKardexDetalle.setkFecha(invKardexTO.getkFecha().toString());
                reporteInvKardexDetalle.setkEntradasCantidad((invKardexTO.getkEntradasCantidad() == null ? null : invKardexTO.getkEntradasCantidad()));
                reporteInvKardexDetalle.setkEntradasCosto((invKardexTO.getkEntradasCosto() == null ? null : invKardexTO.getkEntradasCosto()));//
                reporteInvKardexDetalle.setkSalidasCantidad(invKardexTO.getkSalidasCantidad());
                reporteInvKardexDetalle.setkSalidasCosto(invKardexTO.getkSalidasCosto());//
                reporteInvKardexDetalle.setkSaldosCantidad(invKardexTO.getkSalidasCantidad());
                reporteInvKardexDetalle.setkSaldosCosto(invKardexTO.getkSaldosCosto());//
                reporteInvKardexDetalle.setkCostoActual(invKardexTO.getkCostoActual());//
                reporteInvKardexDetalle.setkSectorPiscina(invKardexTO.getkSectorPiscina().toString());
                reporteInvKardexDetalle.setkNúmeroSistema(invKardexTO.getkNumeroSistema().toString());
                reporteInvKardexDetalle.setkDocumentoNumero(invKardexTO.getkDocumentoNumero() == null ? null : invKardexTO.getkDocumentoNumero().toString());
                reporteInvKardexDetalle.setkProveedor((invKardexTO.getkProveedor() == null ? null : invKardexTO.getkProveedor().toString()));
                reporteInvKardexDetalle.setkObservaciones(invKardexTO.getkObservaciones().toString());
                listaReporteInvKardexDetalleParametro.add(reporteInvKardexDetalle);
            }
            
     return generarReporte(sisUsuarioEmpresaTO, banderaCosto ? "reportInventarioKardexValorizado.jrxml" : "reportInventarioKardex.jrxml", new HashMap(), listaReporteInvKardexDetalleParametro);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteImpresionPlaca(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, LinkedList listProductosImpresionPlaca) throws Exception {
        try {
            List<ReporteProductosImpresionPlaca> listaProductosImpresionPlacas = new ArrayList();
            for (Object o : listProductosImpresionPlaca) {
                DatoFunListaProductosImpresionPlaca dflpip = (DatoFunListaProductosImpresionPlaca) o;
                if (dflpip.isEstado()) {
                    ReporteProductosImpresionPlaca rpip = new ReporteProductosImpresionPlaca();
                    rpip.setLpspCodigoPrincipal(dflpip.getLpspCodigoPrincipal());
                    rpip.setLpspCodigoBarra(dflpip.getLpspCodigoBarra());
                    rpip.setLpspNombre(dflpip.getLpspNombre());
                    rpip.setLpspPrecio1(dflpip.getLpspPrecio1());
                    rpip.setLpspPrecio2(dflpip.getLpspPrecio2());
                    rpip.setLpspPrecio3(dflpip.getLpspPrecio3());
                    listaProductosImpresionPlacas.add(rpip);
                }
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportInvImpresionPlaca.jrxml", new HashMap(), listaProductosImpresionPlacas);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    public JasperPrint generarReporteListadoCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String motivo, String proveedorId, String documento,
            List<InvFunComprasTO> listInvFunComprasTO) throws Exception {
        try {
            List<ReporteListadoCompras> reporteListadoComprases = new ArrayList();
            for (InvFunComprasTO ifcto : listInvFunComprasTO) {
                ReporteListadoCompras reporteListadoCompras = new ReporteListadoCompras();
                reporteListadoCompras.setDesde(fechaDesde);
                reporteListadoCompras.setHasta(fechaHasta);
                reporteListadoCompras.setMotivo(motivo);
                reporteListadoCompras.setProveedor(proveedorId);
                reporteListadoCompras.setTipoDocumento(documento);

                reporteListadoCompras.setCompNumeroSistema(ifcto.getCompNumeroSistema());
                reporteListadoCompras.setCompFecha(ifcto.getCompFecha());
                reporteListadoCompras.setCompProveedor(ifcto.getCompProveedor());
                reporteListadoCompras.setCompDocumentoNumero(ifcto.getCompDocumentoNumero());
                reporteListadoCompras.setCompBase0(ifcto.getCompBase0());
                reporteListadoCompras.setCompBaseImponible(ifcto.getCompBaseImponible());
                reporteListadoCompras.setCompMontoIva(ifcto.getCompMontoIva());
                reporteListadoCompras.setCompTotal(ifcto.getCompTotal());
                reporteListadoCompras.setCompFormaPago(ifcto.getCompFormaPago());
                reporteListadoCompras.setCompObservaciones(ifcto.getCompObservaciones());
                reporteListadoCompras.setCompPendiente(ifcto.getCompPendiente());
                reporteListadoCompras.setCompAnulado(ifcto.getCompAnulado());
                reporteListadoComprases.add(reporteListadoCompras);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportListadoCompras.jrxml", new HashMap(), reporteListadoComprases);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteConsolidadoCompraProducto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String bodega, String proveedor, List<InvFunComprasConsolidandoProductosTO> listInvFunComprasConsolidandoProductosTO) throws Exception {
        try {
            List<ReporteConsolidadoProducto> reporteConsolidadoProductos = new ArrayList();
            for (InvFunComprasConsolidandoProductosTO ifccpto : listInvFunComprasConsolidandoProductosTO) {
                ReporteConsolidadoProducto reporteConsolidadoProducto = new ReporteConsolidadoProducto();
                reporteConsolidadoProducto.setDesde(fechaDesde);
                reporteConsolidadoProducto.setHasta(fechaHasta);
                reporteConsolidadoProducto.setBodega(bodega);
                reporteConsolidadoProducto.setProveedor(proveedor);

                reporteConsolidadoProducto.setCcpProducto(ifccpto.getCcpProducto());
                reporteConsolidadoProducto.setCcpCodigo(ifccpto.getCcpCodigo());
                reporteConsolidadoProducto.setCcpMedida(ifccpto.getCcpMedida());
                reporteConsolidadoProducto.setCcpCantidad(ifccpto.getCcpCantidad());
                reporteConsolidadoProducto.setCcpTotal(ifccpto.getCcpTotal());
                reporteConsolidadoProducto.setCcpPorcentaje(ifccpto.getCcpPorcentaje());

                reporteConsolidadoProductos.add(reporteConsolidadoProducto);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportConsolidadoProducto.jrxml", new HashMap(), reporteConsolidadoProductos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListadoVentas(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String motivo, String cliente, String documento,
            List<InvFunVentasTO> listInvFunVentasTO) throws Exception {
        try {
            List<ReporteListadoVentas> reporteListadoVentases = new ArrayList();
            for (InvFunVentasTO ifvto : listInvFunVentasTO) {
                ReporteListadoVentas reporteListadoVentas = new ReporteListadoVentas();
                reporteListadoVentas.setDesde(fechaDesde);
                reporteListadoVentas.setHasta(fechaHasta);
                reporteListadoVentas.setMotivo(motivo);
                reporteListadoVentas.setCliente(cliente);
                reporteListadoVentas.setTipoDocumento(documento);

                reporteListadoVentas.setVtaNumeroSistema(ifvto.getVtaNumeroSistema());
                reporteListadoVentas.setVtaFecha(ifvto.getVtaFecha());
                reporteListadoVentas.setVtaCliente(ifvto.getVtaCliente());
                reporteListadoVentas.setVtaDocumentoNumero(ifvto.getVtaDocumentoNumero());
                reporteListadoVentas.setVtaBase0(ifvto.getVtaBase0());
                reporteListadoVentas.setVtaBaseImponible(ifvto.getVtaBaseImponible());
                reporteListadoVentas.setVtaMontoIva(ifvto.getVtaMontoIva());
                reporteListadoVentas.setVtaTotal(ifvto.getVtaTotal());
                reporteListadoVentas.setVtaFormaPago(ifvto.getVtaFormaPago());
                reporteListadoVentas.setVtaObservaciones(ifvto.getVtaObservaciones());
                reporteListadoVentas.setVtaPendiente(ifvto.getVtaPendiente());
                reporteListadoVentas.setVtaAnulado(ifvto.getVtaAnulado());
                reporteListadoVentases.add(reporteListadoVentas);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportListadoVentas.jrxml", new HashMap(), reporteListadoVentases);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteConsolidadoVentaProducto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String bodega, String cliente,
            List<InvFunVentasConsolidandoProductosTO> listInvFunVentasConsolidandoProductosTO) throws Exception {
        try {
            List<ReporteConsolidadoProducto> reporteConsolidadoProductos = new ArrayList();
            for (InvFunVentasConsolidandoProductosTO ifccpto : listInvFunVentasConsolidandoProductosTO) {
                ReporteConsolidadoProducto reporteConsolidadoProducto = new ReporteConsolidadoProducto();
                reporteConsolidadoProducto.setDesde(fechaDesde);
                reporteConsolidadoProducto.setHasta(fechaHasta);
                reporteConsolidadoProducto.setBodega(bodega);
                reporteConsolidadoProducto.setProveedor(cliente);

                reporteConsolidadoProducto.setCcpProducto(ifccpto.getVcpProducto());
                reporteConsolidadoProducto.setCcpCodigo(ifccpto.getVcpCodigo());
                reporteConsolidadoProducto.setCcpMedida(ifccpto.getVcpMedida());
                reporteConsolidadoProducto.setCcpCantidad(ifccpto.getVcpCantidad());
                reporteConsolidadoProducto.setCcpTotal(ifccpto.getVcpTotal());
                reporteConsolidadoProducto.setCcpPorcentaje(ifccpto.getVcpPorcentaje());

                reporteConsolidadoProductos.add(reporteConsolidadoProducto);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportConsolidadoProducto.jrxml", new HashMap(), reporteConsolidadoProductos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListadoConsumos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta, List<InvFunConsumosTO> listInvFunConsumosTO) throws Exception {
        try {
            List<ReporteListadoConsumos> reporteListadoConsumos = new ArrayList();
            for (InvFunConsumosTO ifvto : listInvFunConsumosTO) {
                ReporteListadoConsumos consumos = new ReporteListadoConsumos();
                consumos.setDesde(fechaDesde);
                consumos.setHasta(fechaHasta);

                consumos.setConNumeroSistema(ifvto.getCompNumeroSistema());
                consumos.setConFecha(ifvto.getCompFecha());
                consumos.setConObservaciones(ifvto.getCompObservaciones());
                consumos.setConPendiente(ifvto.getCompPendiente());
                consumos.setConAnulado(ifvto.getCompAnulado());
                reporteListadoConsumos.add(consumos);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportListadoConsumos.jrxml", new HashMap(), reporteListadoConsumos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteListaProductos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega,
            List<InvListaProductosTO> listInvListaProductosTO) throws Exception {
        try {
            List<ReporteListaProductos> reporteListaProductoses = new ArrayList();
            for (InvListaProductosTO ilpto : listInvListaProductosTO) {
                ReporteListaProductos reporteListaProductos = new ReporteListaProductos();
                reporteListaProductos.setBodega(bodega);
                reporteListaProductos.setProCodigoPrincipal(ilpto.getProCodigoPrincipal());
                reporteListaProductos.setProCodigoBarra(ilpto.getProCodigoBarra());
                reporteListaProductos.setProNombre(ilpto.getProNombre());
                reporteListaProductos.setProCategoria(ilpto.getProCategoria());
                reporteListaProductos.setStockSaldo(ilpto.getStockSaldo());
                reporteListaProductos.setStockCosto(ilpto.getStockCosto());
                reporteListaProductos.setDetalleMedida(ilpto.getDetalleMedida());
                reporteListaProductos.setStockPrecio1(ilpto.getStockPrecio1());
                reporteListaProductos.setStockPrecio2(ilpto.getStockPrecio2());
                reporteListaProductos.setStockPrecio3(ilpto.getStockPrecio3());
                reporteListaProductos.setStockPrecio4(ilpto.getStockPrecio4());
                reporteListaProductos.setStockPrecio5(ilpto.getStockPrecio5());
                reporteListaProductos.setProGravaIva(ilpto.getProGravaIva().equals("GRAVA") ? true : false);
                reporteListaProductoses.add(reporteListaProductos);
            }

            return generarReporte(sisUsuarioEmpresaTO, "reportListaProductos.jrxml", new HashMap(), reporteListaProductoses);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteSaldoBodega(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega, String fechaHasta,
            List<SaldoBodegaTO> listSaldoBodegaTO) throws Exception {
        try {
            List<ReporteSaldoBodega> lista = new ArrayList();
            for (SaldoBodegaTO sbto : listSaldoBodegaTO) {
                ReporteSaldoBodega reporteSaldoBodega = new ReporteSaldoBodega(bodega, fechaHasta,
                        sbto.getSbBodega() == null ? "" : sbto.getSbBodega(),
                        sbto.getSbProducto() == null ? "" : sbto.getSbProducto(),
                        sbto.getSbNombre() == null ? "" : sbto.getSbNombre(),
                        sbto.getSbMedida() == null ? "" : sbto.getSbMedida(),
                        sbto.getSbStock() == null ? null : sbto.getSbStock(),
                        sbto.getSbCosto() == null ? null : sbto.getSbCosto(),
                        sbto.getSbTotal() == null ? null : sbto.getSbTotal());
                lista.add(reporteSaldoBodega);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportSaldoBodega.jrxml", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteSaldoBodegaComprobacion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String bodega, String fechaDesde, String fechaHasta, List<SaldoBodegaComprobacionTO> lista) throws Exception {
        try {
            List<ReporteSaldoBodegaComprobacion> lt = new ArrayList();
            for (SaldoBodegaComprobacionTO sbcTO : lista) {
                ReporteSaldoBodegaComprobacion reporteSaldoBodega =
                        new ReporteSaldoBodegaComprobacion(bodega, fechaDesde, fechaHasta,
                        sbcTO.getSbcProductoNombre() == null ? "" : sbcTO.getSbcProductoNombre(),
                        sbcTO.getSbcProductoCodigo() == null ? "" : sbcTO.getSbcProductoCodigo(),
                        sbcTO.getSbcMedida() == null ? "" : sbcTO.getSbcMedida(),
                        sbcTO.getSbcInicial() == null ? null : sbcTO.getSbcInicial(),
                        sbcTO.getSbcCompra() == null ? null : sbcTO.getSbcCompra(),
                        sbcTO.getSbcVenta() == null ? null : sbcTO.getSbcVenta(),
                        sbcTO.getSbcConsumo() == null ? null : sbcTO.getSbcConsumo(),
                        sbcTO.getSbcTransferenciaI() == null ? null : sbcTO.getSbcTransferenciaI(),
                        sbcTO.getSbcTransferenciaE() == null ? null : sbcTO.getSbcTransferenciaE(),
                        sbcTO.getSbcDevolucionC() == null ? null : sbcTO.getSbcDevolucionC(),
                        sbcTO.getSbcDevolucionV() == null ? null : sbcTO.getSbcDevolucionV(),
                        sbcTO.getSbcFinal() == null ? null : sbcTO.getSbcFinal(),
                        sbcTO.getSbcDiferencia() == null ? null : sbcTO.getSbcDiferencia());
                lt.add(reporteSaldoBodega);
            }
            return generarReporte(sisUsuarioEmpresaTO, "reportSaldoBodega.jrxml", new HashMap(), lt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteInvProductosConError(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<InvProductosConErrorTO> listInvProductosConErrorTO) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportListadoProductosConError.jrxml", new HashMap(), listInvProductosConErrorTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteTrasferencias(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ReporteTransferenciaDetalle> listReporteTransferenciaDetalle) throws Exception {
        try {
            return generarReporte(sisUsuarioEmpresaTO, "reportComprobanteTrasferencias.jrxml", new HashMap(), listReporteTransferenciaDetalle);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T> JasperPrint generarReporte(SisUsuarioEmpresaTO sisUsuario, String nombreReporte, Map parametros, List<T> list) throws Exception {
        try {
            String rutaReportes = getRutaReportes() + "inventario/";
            System.out.println("ruta rep: "+rutaReportes+nombreReporte);
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

    public JasperPrint generarReporteConsumoDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, boolean ordenado,
            List<ReporteConsumoDetalle> reporteConsumoDetalles) throws Exception {
        try {
            String nombreReporte = "";
            if (ordenado) {
                Collections.sort(reporteConsumoDetalles, new Comparator<ReporteConsumoDetalle>() {
                    @Override
                    public int compare(ReporteConsumoDetalle reporteConsumoDetalle, ReporteConsumoDetalle reporteConsumoDetalle1) {
                        return reporteConsumoDetalle.getNombreProducto().compareTo(reporteConsumoDetalle1.getNombreProducto());
                    }
                });
                Collections.sort(reporteConsumoDetalles, new Comparator<ReporteConsumoDetalle>() {

                    @Override
                    public int compare(ReporteConsumoDetalle reporteConsumoDetalle, ReporteConsumoDetalle reporteConsumoDetalle1) {
                        return reporteConsumoDetalle.getConsNumero().compareTo(reporteConsumoDetalle1.getConsNumero());
                    }
                });
                nombreReporte = "reportComprobanteConsumoOrdenado.jrxml";
            } else {
                nombreReporte = "reportComprobanteConsumo.jrxml";
            }

            return generarReporte(sisUsuarioEmpresaTO, nombreReporte, new HashMap(), reporteConsumoDetalles);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCompraDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteCompraDetalle> reporteCompraDetalles) throws Exception {
        return generarReporte(sisUsuarioEmpresaTO, "reportComprobanteCompra.jrxml", new HashMap(), reporteCompraDetalles);
    }

    public JasperPrint generarReporteVentaDetalleImpresion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteVentaDetalle> lista, String nombreCliente, String nombreReporte) throws Exception {
        try {
            ReporteInventario.rellenarValoresVentaDetalle(lista);

            JRBeanCollectionDataSource ds =
                    new JRBeanCollectionDataSource(ReporteInventario.generarColeccionVentaDetalle());
            String ruta = getRutaReportes() + "inventario/";
            JasperDesign jd = JRXmlLoader.load(ruta + nombreReporte + ".jrxml");
            ////COMPILAR REPORTE
            JasperReport jReporte = JasperCompileManager.compileReport(jd);
            ///PARAMETROS SREPORTE
            Map parametros = new HashMap();
            parametros.put("SUBREPORT_DIR", ruta);
            parametros.put("p_empresa_nombre", sisUsuarioEmpresaTO.getEmpNombre());
            parametros.put("p_empresa_ruc", sisUsuarioEmpresaTO.getEmpRuc());
            parametros.put("p_empresa_direccion", sisUsuarioEmpresaTO.getEmpDireccion());
            parametros.put("p_empresa_telefono", sisUsuarioEmpresaTO.getEmpTelefono());
            parametros.put("p_usuario_nick", sisUsuarioEmpresaTO.getUsrNick());

            JasperPrint jLlenaReporte = JasperFillManager.fillReport(jReporte, parametros, ds);
            return jLlenaReporte;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public JasperPrint generarReporteProformaDetalleImpresion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteProformaDetalle> lista, String nombreReporte) throws Exception {
        try {
            
             return generarReporte(sisUsuarioEmpresaTO, "reportConsolidadoProducto.jrxml", new HashMap(), lista);
            
            
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteCompraDetalleImprimir(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteCompraDetalle> reporteCompraDetalles, String cmFormaImprimir) throws Exception {
        try {
            ReporteInventario.rellenarValoresCompraDetalle(reporteCompraDetalles);

            JRBeanCollectionDataSource ds =
                    new JRBeanCollectionDataSource(ReporteInventario.generarColeccionCompraDetalle());

            String ruta = getRutaReportes() + "inventario/";
            ////CARGAR REPORTE
            JasperDesign jd = JRXmlLoader.load(ruta + "reportComprobanteCompra.jrxml");
            ////COMPILAR REPORTE
            JasperReport jReporte = JasperCompileManager.compileReport(jd);
            ///PARAMETROS SREPORTE
            Map parametros = new HashMap();
            parametros.put("SUBREPORT_DIR", ruta);
            parametros.put("p_empresa_nombre", sisUsuarioEmpresaTO.getEmpNombre());
            parametros.put("p_empresa_ruc", sisUsuarioEmpresaTO.getEmpRuc());
            parametros.put("p_empresa_direccion", sisUsuarioEmpresaTO.getEmpDireccion());
            parametros.put("p_empresa_telefono", sisUsuarioEmpresaTO.getEmpTelefono());
            parametros.put("p_usuario_nick", sisUsuarioEmpresaTO.getUsrNick());

            JasperPrint jLlenaReporte = JasperFillManager.fillReport(jReporte, parametros, ds);
            return jLlenaReporte;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JasperPrint generarReporteInvFunVentasVsCosto(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String bodega, String clienteId,
            List<InvFunVentasVsCostoTO> invFunVentasVsCostoTO) throws Exception {
        try {
            List<ReporteInvFunVentasVsCosto> lista = new ArrayList();
            for (InvFunVentasVsCostoTO sbto : invFunVentasVsCostoTO) {
                ReporteInvFunVentasVsCosto reporteInvFunVentasVsCosto = new ReporteInvFunVentasVsCosto();

                reporteInvFunVentasVsCosto.setFechaDesde(fechaDesde);
                reporteInvFunVentasVsCosto.setFechaHasta(fechaHasta);
                reporteInvFunVentasVsCosto.setBodega(bodega);
                reporteInvFunVentasVsCosto.setCliente(clienteId);
                reporteInvFunVentasVsCosto.setVcPorcentaje(BigDecimal.ZERO);
                reporteInvFunVentasVsCosto.setVcCodigo(sbto.getVcCodigo());
                reporteInvFunVentasVsCosto.setVcMedida(sbto.getVcMedida());
                reporteInvFunVentasVsCosto.setVcCantidad(sbto.getVcCantidad());
                reporteInvFunVentasVsCosto.setVcTotalVentas(sbto.getVcTotalVentas());
                reporteInvFunVentasVsCosto.setVcTotalCosto(sbto.getVcTotalCosto());
                reporteInvFunVentasVsCosto.setVcPorcentaje(sbto.getVcPorcentaje());

                lista.add(reporteInvFunVentasVsCosto);
            }

            return generarReporte(sisUsuarioEmpresaTO, "No existe este reporte.__", new HashMap(), lista);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
