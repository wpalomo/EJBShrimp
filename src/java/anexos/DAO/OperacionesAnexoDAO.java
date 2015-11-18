/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.DAO;

import anexos.TO.AnxCuentasContablesTO;
import anexos.TO.AnxEstablecimientoComboTO;
import anexos.helper.ConversionesAnexos;
import inventario.TO.InvConsultaVentasFacturasPorNumeroTO;
import inventario.helper.ConversionesInventario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesAnexoDAO implements OperacionesAnexoDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @javax.ejb.EJB
    anexos.entity.DAO.AnxTipoidentificacionFacadeLocal anxTipoidentificacionFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxCompraFacadeLocal anxCompraFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxCompraDetalleFacadeLocal anxCompraDetalleFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxVentaFacadeLocal anxVentaFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxNumeracionFacadeLocal anxNumeracionFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxConceptoFacadeLocal anxConceptoFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxSustentoFacadeLocal anxSustentoFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxTipocomprobanteFacadeLocal anxTipoComprobanteFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxTipoidentificacionFacadeLocal anxTipoIdentificacionFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxTipotransaccionFacadeLocal anxTipoTransaccionFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxAnuladosFacadeLocal anxAnuladosFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxCuentascontablesFacadeLocal anxCuentascontablesFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxFormaPagoFacadeLocal anxFormaPagoFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxCompraFormaPagoFacadeLocal anxCompraFormaPagoFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxCompraReembolsoFacadeLocal anxCompraReembolsoFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxProvinciasFacadeLocal anxProvinciasFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxCompraElectronicaFacadeLocal anxCompraElectronicaFacadeLocal;
    @javax.ejb.EJB
    anexos.entity.DAO.AnxVentaElectronicaFacadeLocal anxVentaElectronicaFacadeLocal;
    @javax.persistence.PersistenceContext(unitName = "EJBShrimpPU")
    javax.persistence.EntityManager em;

    @Override
    public List<AnxEstablecimientoComboTO> getEstablecimientos(String empresa) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirListaAnxEstablecimientoCombo_ListaAnxEstablecimientoComboTO(em.createNativeQuery("SELECT * FROM anexo.fun_establecimientos('" + empresa + "')").getResultList());
    }

    @Override
    public List<AnxEstablecimientoComboTO> getPuntosEmision(String empresa, String establecimiento) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirListaAnxEstablecimientoCombo_ListaAnxEstablecimientoComboTO(em.createNativeQuery("SELECT * FROM anexo.fun_puntos_de_emision('" + empresa + "','" + establecimiento + "')").getResultList());
    }

    @Override
    public anexos.TO.AnxNumeracionLineaTO getNumeroAutorizacion(String empresa, String numeroRetencion, String numeroComprobante, String fechaVencimiento) throws Exception {
        anexos.TO.AnxNumeracionLineaTO anxNumeracionLineaTO = null;
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT * FROM anexo.fun_comprobante_verificar_autorizacion('" + empresa + "', '" + numeroComprobante + "', '" + numeroRetencion + "', " + fechaVencimiento + ")").getResultList(), 0);
        if (array != null) {
            anxNumeracionLineaTO = new anexos.TO.AnxNumeracionLineaTO(
                    array[0].toString().trim(),
                    array[1] == null ? null : Integer.parseInt(array[1].toString().trim()),
                    array[2] == null ? null : Boolean.parseBoolean(array[2].toString().trim()),
                    array[3] == null ? null : Boolean.parseBoolean(array[3].toString().trim()),
                    array[4] == null ? null : Boolean.parseBoolean(array[4].toString().trim()));

        } else {
            anxNumeracionLineaTO = null;
        }
        return anxNumeracionLineaTO;
    }

    @Override
    public String getConteoNumeroRetencion(String empresaCodigo, String numeroRetencion) throws Exception {
        String retorno = "";
        String empresa = "";
        String periodo = "";
        String motivo = "";
        String numero = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT anexo.anx_compra.comp_empresa, anexo.anx_compra.comp_periodo, "
                + "anexo.anx_compra.comp_motivo, anexo.anx_compra.comp_numero FROM anexo.anx_compra INNER JOIN inventario.inv_compras ON "
                + "anx_compra.comp_empresa = inv_compras.comp_empresa AND anx_compra.comp_periodo = "
                + "inv_compras.comp_periodo AND anx_compra.comp_motivo = inv_compras.comp_motivo AND "
                + "anx_compra.comp_numero = inv_compras.comp_numero WHERE anexo.anx_compra.comp_empresa = ('" + empresaCodigo + "') "
                + "AND comp_retencion_numero = ('" + numeroRetencion + "') AND NOT comp_anulado;").getResultList(), 0);

        if (array != null) {
            empresa = array[0].toString().trim();
            periodo = array[1].toString().trim();
            motivo = array[2].toString().trim();
            numero = array[3].toString().trim();
            retorno = empresa + periodo + motivo + numero;
        } else {
            retorno = "";
        }
        return retorno;
    }

    @Override
    public String getConteoNumeroRetencionVenta(String empresaCodigo, String numeroRetencion, String cliente) throws Exception {
        String retorno = "";
        String empresa = "";
        String periodo = "";
        String motivo = "";
        String numero = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT ven_empresa, ven_periodo, ven_motivo, ven_numero "
                + "FROM anexo.anx_venta INNER JOIN inventario.inv_ventas ON "
                + "anx_venta.ven_empresa = inv_ventas.vta_empresa AND anx_venta.ven_periodo = "
                + "inv_ventas.vta_periodo AND anx_venta.ven_motivo = inv_ventas.vta_motivo AND "
                + "anx_venta.ven_numero = inv_ventas.vta_numero WHERE ven_empresa = ('" + empresaCodigo + "') "
                + "AND cli_codigo = ('" + cliente + "') AND ven_retencionnumero = ('" + numeroRetencion + "') AND NOT vta_anulado").getResultList(), 0);
//        java.util.List datoConsulta = (java.util.List) em.createNativeQuery("SELECT com_empresa, com_periodo, "
//                + "com_motivo, com_numero FROM anexo.anx_compra INNER JOIN inventario.inv_compras ON "
//                + "anx_compra.com_empresa = inv_compras.comp_empresa AND anx_compra.com_periodo = "
//                + "inv_compras.comp_periodo AND anx_compra.com_motivo = inv_compras.comp_motivo AND "
//                + "anx_compra.com_numero = inv_compras.comp_numero WHERE com_empresa = ('" + empresaCodigo + "') "
//                + "AND com_retencionnumero = ('" + numeroRetencion + "') AND NOT comp_anulado;").getResultList();

        if (array != null) {
            empresa = array[0].toString().trim();
            periodo = array[1].toString().trim();
            motivo = array[2].toString().trim();
            numero = array[3].toString().trim();
            retorno = empresa + periodo + motivo + numero;
        } else {
            retorno = "";
        }
        return retorno;
    }

    @Override
    public java.util.List<anexos.TO.AnxSustentoComboTO> getListaAnxSustentoComboTO(String tipoComprobante) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirListaAnxSustentoCombo_ListaAnxSustentoComboTO(
                em.createNativeQuery("SELECT sus_codigo, sus_descripcion FROM anexo.anx_sustento "
                + (tipoComprobante == null ? "" : "WHERE POSITION(('" + tipoComprobante + "') IN sus_comprobante)!=0 ORDER BY sus_codigo")).getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoTO() throws Exception {
        String fechaRetencion = validaciones.Validacion.fechaSistema();
        return anexos.helper.ConversionesAnexos.convertirListaAnxConceptoCombo_ListaAnxConceptoComboTO(
                em.createNativeQuery("SELECT con_codigo, con_concepto, con_porcentaje, con_ingresa_porcentaje "
                + "FROM anexo.anx_concepto WHERE CASE WHEN con_fecha_fin IS NULL THEN (('" + fechaRetencion + "') >= "
                + "con_fecha_inicio) ELSE (('" + fechaRetencion + "') >= con_fecha_inicio AND ('" + fechaRetencion + "') "
                + "<= con_fecha_fin) END ORDER BY con_concepto").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoTO(String fechaRetencion) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirListaAnxConceptoCombo_ListaAnxConceptoComboTO(
                em.createNativeQuery("SELECT con_codigo, con_concepto, con_porcentaje, con_ingresa_porcentaje "
                + "FROM anexo.anx_concepto WHERE CASE WHEN con_fecha_fin IS NULL THEN (('" + fechaRetencion + "') >= "
                + "con_fecha_inicio) ELSE (('" + fechaRetencion + "') >= con_fecha_inicio AND ('" + fechaRetencion + "') "
                + "<= con_fecha_fin) END").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoComboTO> getListaAnxConceptoTO(String fechaRetencion, String busqueda) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirListaAnxConceptoCombo_ListaAnxConceptoComboTO(
                em.createNativeQuery("SELECT con_codigo, con_concepto, con_porcentaje, con_ingresa_porcentaje "
                + "FROM anexo.anx_concepto WHERE CASE WHEN con_fecha_fin IS NULL THEN (('" + fechaRetencion + "') >= "
                + "con_fecha_inicio) ELSE (('" + fechaRetencion + "') >= con_fecha_inicio AND ('" + fechaRetencion + "') <= con_fecha_fin) END AND "
                + "UPPER(con_codigo || con_concepto || con_concepto || con_codigo) LIKE CASE WHEN '" + busqueda + "' IS NOT NULL "
                + "AND '" + busqueda + "' = '' THEN NULL ELSE '%' || TRANSLATE('" + busqueda + "', ' ', '%') || '%' END").getResultList());
    }

    @Override
    public String getCodigoAnxTipoTransaccionTO(String codigoTipoIdentificacion, String tipoTransaccion) throws Exception {
        if (tipoTransaccion.equals("COMPRA")) {
            return String.valueOf(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                    "SELECT tt_codigo "
                    + "FROM anexo.anx_tipotransaccion WHERE tt_codigo <= '03' AND tt_id = ('" + codigoTipoIdentificacion + "')").
                    getResultList(), 0)[0].toString());
        } else {
            return String.valueOf(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                    "SELECT tt_codigo "
                    + "FROM anexo.anx_tipotransaccion WHERE tt_codigo > '03' AND tt_id = ('" + codigoTipoIdentificacion + "')").
                    getResultList(), 0)[0].toString());
        }
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoComprobanteComboTO> getListaAnxTipoComprobanteComboTO(String codigoTipoTransaccion) throws Exception {
        if (codigoTipoTransaccion != null) {
            return anexos.helper.ConversionesAnexos.convertirListaAnxTipoComprobanteCombo_ListaAnxTipoComprobanteComboTO(
                    em.createNativeQuery("SELECT tc_codigo, tc_descripcion, tc_reporte FROM anexo."
                    + "anx_tipocomprobante WHERE POSITION(('" + codigoTipoTransaccion + "~') in tc_transaccion)!=0 ORDER BY tc_codigo").getResultList());
        } else {
            return anexos.helper.ConversionesAnexos.convertirListaAnxTipoComprobanteCombo_ListaAnxTipoComprobanteComboTO(
                    em.createNativeQuery("SELECT tc_codigo, tc_descripcion FROM anexo."
                    + "anx_tipocomprobante ORDER BY tc_codigo").getResultList());
        }

    }

    @Override
    public java.util.List<anexos.TO.AnxTipoComprobanteComboTO> getListaAnxTipoComprobanteComboTOCompleto() throws Exception {
        return anexos.helper.ConversionesAnexos.convertirListaAnxTipoComprobanteCombo_ListaAnxTipoComprobanteComboTO(
                em.createNativeQuery("SELECT tc_codigo, tc_descripcion FROM anexo."
                + "anx_tipocomprobante ORDER BY tc_codigo").getResultList());
    }

    @Override
    public java.math.BigDecimal getValorAnxPorcentajeIvaTO(String fechaFactura) throws Exception {
        fechaFactura = fechaFactura == null ? null : "'" + fechaFactura + "'";
        return new java.math.BigDecimal(String.valueOf(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT pi_porcentaje FROM anexo.anx_porcentajeiva "
                + "WHERE CASE WHEN pi_fecha_fin IS NULL THEN ((" + fechaFactura + ") >= pi_fecha_inicio) "
                + "ELSE ((" + fechaFactura + ") >= pi_fecha_inicio AND (" + fechaFactura + ") <= pi_fecha_fin) END").
                getResultList(), 0)[0].toString()));
    }

    @Override
    public java.math.BigDecimal getValorAnxMontoMaximoConsumidorFinalTO(String fechaFactura) throws Exception {
        fechaFactura = fechaFactura == null ? null : "'" + fechaFactura + "'";
        return new java.math.BigDecimal(String.valueOf(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT pi_monto_maximo_consumidor_final FROM anexo.anx_porcentajeiva "
                + "WHERE CASE WHEN pi_fecha_fin IS NULL THEN ((" + fechaFactura + ") >= pi_fecha_inicio) "
                + "ELSE ((" + fechaFactura + ") >= pi_fecha_inicio AND (" + fechaFactura + ") <= pi_fecha_fin) END").
                getResultList(), 0)[0].toString()));
    }

    @Override
    public anexos.entity.AnxCompra getAnexoCompra(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return anxCompraFacadeLocal.find(new anexos.entity.AnxCompraPK(empresa, periodo, motivo, numeroCompra));
    }

    @Override
    public anexos.TO.AnxCompraTO getAnexoCompraTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxCompra_AnxCompraTO(anxCompraFacadeLocal.find(new anexos.entity.AnxCompraPK(empresa, periodo, motivo, numeroCompra)));
    }

    @Override
    public java.util.List<anexos.TO.AnxCompraDetalleTO> getAnexoCompraDetalleTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxCompraDetalle_AnxCompraDetalleTO(em.createNativeQuery(""
                + "SELECT "
                + "det_secuencial, "
                + "det_concepto, "
                + "det_base0, "
                + "det_baseimponible, "
                + "det_basenoobjetoiva, "
                + "det_porcentaje, "
                + "det_valorretenido, "
                + "det_orden, "
                + "anx_compra_detalle.comp_empresa, "
                + "anx_compra_detalle.comp_periodo, "
                + "anx_compra_detalle.comp_motivo, "
                + "anx_compra_detalle.comp_numero, "
                + "div_secuencial, "
                + "div_fecha_pago, "
                + "div_ir_asociado, "
                + "div_anio_utilidades "
                + "FROM anexo.anx_compra_detalle LEFT JOIN anexo.anx_compra_dividendo "
                + "ON anx_compra_detalle.comp_empresa = anx_compra_dividendo.comp_empresa AND "
                + "anx_compra_detalle.comp_periodo = anx_compra_dividendo.comp_periodo AND "
                + "anx_compra_detalle.comp_motivo = anx_compra_dividendo.comp_motivo AND "
                + "anx_compra_detalle.comp_numero = anx_compra_dividendo.comp_numero AND "
                + "anx_compra_detalle.det_concepto = anx_compra_dividendo.con_codigo "
                + "WHERE anx_compra_detalle.comp_empresa='" + empresa + "' AND "
                + "anx_compra_detalle.comp_periodo='" + periodo + "' AND "
                + "anx_compra_detalle.comp_motivo='" + motivo + "' AND "
                + "anx_compra_detalle.comp_numero='" + numeroCompra + "' "
                + "ORDER BY det_orden").getResultList());
    }
//    @Override
//    public java.util.List<anexos.TO.AnxCompraDetalleTO> getAnexoCompraDetalleTO(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
//        java.util.List<anexos.entity.AnxCompraDetalle> anxCompraDetalles = em.createQuery("SELECT a FROM AnxCompraDetalle a WHERE "
//                + "a.anxCompra.anxCompraPK.compEmpresa = :empresa AND a.anxCompra.anxCompraPK.compPeriodo = :periodo AND a.anxCompra.anxCompraPK.compMotivo = :motivo "
//                + "AND a.anxCompra.anxCompraPK.compNumero = :numero ORDER BY a.detOrden").
//                setParameter("empresa", empresa).setParameter("periodo", periodo).setParameter("motivo", motivo).setParameter("numero", numeroCompra).getResultList();
//        java.util.List<anexos.TO.AnxCompraDetalleTO> anxCompraDetalleTO;
//        if(anxCompraDetalles != null){
//            if(!anxCompraDetalles.isEmpty()){
//                anxCompraDetalleTO = new java.util.ArrayList();
//                for (int i = 0; i < anxCompraDetalles.size(); i++){
//                    anxCompraDetalleTO.add(anexos.helper.ConversionesAnexos.convertirAnxCompraDetalle_AnxCompraDetalleTO(anxCompraDetalles.get(i)));
//                }
//            } else {
//                anxCompraDetalleTO = null;
//            }
//        } else {
//            anxCompraDetalleTO = null;
//        }
//        
//        return anxCompraDetalleTO;
//    }

    @Override
    public java.util.List<anexos.entity.AnxCompraDetalle> getAnexoCompraDetalle(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        java.util.List<anexos.entity.AnxCompraDetalle> anxCompraDetalles = em.createQuery("SELECT a FROM AnxCompraDetalle a WHERE "
                + "a.anxCompra.anxCompraPK.compEmpresa = :empresa AND a.anxCompra.anxCompraPK.compPeriodo = :periodo AND a.anxCompra.anxCompraPK.compMotivo = :motivo "
                + "AND a.anxCompra.anxCompraPK.compNumero = :numero ORDER BY a.detOrden").
                setParameter("empresa", empresa).setParameter("periodo", periodo).setParameter("motivo", motivo).setParameter("numero", numeroCompra).getResultList();
        return anxCompraDetalles;
    }

    @Override
    public anexos.TO.AnxVentaTO getAnexoVentaTO(String empresa, String periodo, String motivo, String numeroVenta) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxVenta_AnxVentaTO(anxVentaFacadeLocal.find(new anexos.entity.AnxVentaPK(empresa, periodo, motivo, numeroVenta)));
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesTO> getAnexoListaRetencionesTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirListaRetenciones_ListaRetencionesTO(
                em.createNativeQuery("SELECT * FROM anexo.fun_listado_retenciones"
                + "('" + empresa + "', '" + fechaDesde + "', '" + fechaHasta + "')").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesRentaTO> getAnexoListaRetencionesRentaTO(String empresa, String fechaDesde, String fechaHasta, String pOrden) throws Exception {
        pOrden = pOrden == null ? null : "'" + pOrden + "'";
        return anexos.helper.ConversionesAnexos.convertirListaRetenciones_ListaRetencionesRentaTO(
                em.createNativeQuery("SELECT * FROM anexo.fun_listado_retenciones_renta"
                + "('" + empresa + "', '" + fechaDesde + "', '" + fechaHasta + "' , " + pOrden + ")").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesFuenteIvaTO> getAnexoListaRetencionesFuenteIvaTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        String sql = "SELECT * FROM anexo.fun_listado_retenciones_iva"
                + "('" + empresa + "', '" + fechaDesde + "', '" + fechaHasta + "')";
        return anexos.helper.ConversionesAnexos.convertirListaRetencionesFuenteIva_ListaRetencionesFuenteIvaTO(
                em.createNativeQuery(sql).getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesTO> getAnexoFunListadoRetencionesPorNumero(String empresa, String fechaDesde, String fechaHasta, String parametroEstado) throws Exception {
        fechaDesde = (fechaDesde == null ? null : "'" + fechaDesde + "'");
        fechaHasta = (fechaHasta == null ? null : "'" + fechaHasta + "'");
        parametroEstado = (parametroEstado == null ? null : "'" + parametroEstado + "'");
        return anexos.helper.ConversionesAnexos.convertirListaRetenciones_ListaRetencionesTO(
                em.createNativeQuery("SELECT * FROM anexo.fun_listado_retenciones_por_numero"
                + "('" + empresa + "', " + fechaDesde + " , " + fechaHasta + " ,  " + parametroEstado + " )").getResultList());
    }

    @Override
    public java.util.List<String> getAnexoFunListadoRetencionesHuerfanas(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxFunRetencionesHuerfanas_AnxFunRetencionesHuerfanasTO(
                em.createNativeQuery("SELECT ret_retencionnumero FROM anexo.fun_listado_retenciones_por_numero "
                + "('" + empresa + "', '" + fechaDesde + "', '" + fechaHasta + "', 'ERROR')").getResultList());
        ///SELECT * FROM anexo.fun_retenciones_huerfanas('UTN', '2013-12-01', '2013-12-31');
    }

    @Override
    public java.util.List<String> getAnexoFunListadoComprobantesPendientes(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxFunRetencionesHuerfanas_AnxFunRetencionesHuerfanasTO(
                em.createNativeQuery("SELECT * FROM anexo.fun_validar_comprobantes_pendientes "
                + "('" + empresa + "', '" + fechaDesde + "', '" + fechaHasta + "')").getResultList());
        ///SELECT * FROM anexo.fun_retenciones_huerfanas('UTN', '2013-12-01', '2013-12-31');
    }

    @Override
    public boolean comprobarEliminarAnxVentas(String empresa, String ventPeriodo, String ventMotivo, String ventaNumero) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery(" SELECT COUNT(*)!=0 FROM anexo.anx_venta "
                + "WHERE (ven_empresa = '" + empresa + "' "
                + "AND ven_periodo = '" + ventPeriodo + "' "
                + "AND ven_motivo = '" + ventMotivo + "' "
                + "AND ven_numero ='" + ventaNumero + "');").
                getResultList(), 0)[0].toString());
    }

    @Override
    public boolean comprobarAnxVentas(String empresa, String ventPeriodo, String ventMotivo, String ventaNumero) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery(" SELECT COUNT(*)!=0 FROM anexo.anx_venta "
                + "WHERE (ven_empresa = '" + empresa + "' "
                + "AND ven_periodo = '" + ventPeriodo + "' "
                + "AND ven_motivo = '" + ventMotivo + "' "
                + "AND ven_numero ='" + ventaNumero + "');").
                getResultList(), 0)[0].toString());
    }

    @Override
    public anexos.entity.AnxVenta buscarAnxVentas(String empresa, String ventPeriodo, String ventMotivo, String ventaNumero) throws Exception {
        return anxVentaFacadeLocal.find(new anexos.entity.AnxVentaPK(empresa, ventPeriodo, ventMotivo, ventaNumero));
    }

    @Override
    public java.util.List<anexos.TO.AnxListaComprobanteAnuladoTO> getAnxListaComprobanteAnuladoTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxListaComprobanteAnulado_AnxListaComprobanteAnuladoTO(
                em.createNativeQuery("SELECT "
                + "anu_comprobante_tipo, "
                + "anu_comprobante_establecimiento, "
                + "anu_comprobante_punto_emision, "
                + "anu_secuencial_inicio, "
                + "anu_secuencial_fin, "
                + "anu_autorizacion "
                + "FROM anexo.fun_anulados('" + empresa + "','" + fechaDesde + "','" + fechaHasta + "');").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionVentaTO> getAnxListaRetencionVentaTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxListaRetencionVenta_AnxListaRetencionVentaTO(
                em.createNativeQuery("SELECT anx_tipotransaccion.tt_codigo, "
                + "inv_cliente.cli_id_numero, inv_ventas.vta_documento_tipo, "
                + "COUNT(*) n_retenciones, 0.00 ven_basenoobjetoiva, "
                + "ROUND(SUM(inv_ventas.vta_subtotal_base0), 2) ven_base0, "
                + "ROUND(SUM(inv_ventas.vta_subtotal_baseimponible), 2) ven_baseimponible, "
                + "SUM(inv_ventas.vta_montoiva) ven_montoiva, "
                + "SUM(ven_valorretenidoiva) ven_valorretenidoiva, "
                + "SUM(ven_valorretenidorenta) ven_valorretenidorenta "
                + "FROM inventario.inv_cliente INNER JOIN inventario.inv_ventas "
                + "LEFT JOIN anexo.anx_venta "
                + "ON inv_ventas.vta_empresa = anx_venta.ven_empresa "
                + "AND inv_ventas.vta_periodo = anx_venta.ven_periodo "
                + "AND inv_ventas.vta_motivo = anx_venta.ven_motivo "
                + "AND inv_ventas.vta_numero = anx_venta.ven_numero "
                + "ON inv_cliente.cli_empresa = inv_ventas.cli_empresa "
                + "AND inv_cliente.cli_codigo = inv_ventas.cli_codigo "
                + "INNER JOIN anexo.anx_tipotransaccion "
                + "ON inv_cliente.cli_tipo_id = anx_tipotransaccion.tt_id "
                + "AND anx_tipotransaccion.tt_codigo IN ('04','05','06','07') "
                + "WHERE vta_empresa='" + empresa + "' "
                + "AND vta_fecha>='" + fechaDesde + "' "
                + "AND vta_fecha<='" + fechaHasta + "' "
                + "AND NOT vta_anulado AND vta_documento_tipo != '00'"
                + "GROUP BY anx_tipotransaccion.tt_codigo, inv_cliente.cli_id_numero, "
                + "inv_ventas.vta_documento_tipo;").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxListaConsolidadoRetencionesVentasTO> getAnxListaConsolidadoRetencionesVentasTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        String sql = "SELECT * FROM "
                + "anexo.fun_consolidado_retenciones_ventas("
                + "'" + empresa + "', "
                + "'" + fechaDesde + "', "
                + "'" + fechaHasta + "');";
        return anexos.helper.ConversionesAnexos.convertirAnxListaConsolidadoRetencionesVentas_AnxListaConsolidadoRetencionesVentasTO(
                em.createNativeQuery(sql).getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxListaEstablecimientoRetencionesVentasTO> getAnxListaEstablecimientoRetencionesVentasTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxListaEstablecimientoRetencionesVentas_AnxListaEstablecimientoRetencionesVentasTO(
                em.createNativeQuery("SELECT * FROM "
                + "anexo.fun_consolidado_por_establecimiento_retenciones_ventas("
                + "'" + empresa + "', "
                + "'" + fechaDesde + "', "
                + "'" + fechaHasta + "');").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxListadoRetencionesVentasTO> getAnxListadoRetencionesVentasTO(String empresa, String tipoDocumento, String establecimiento, String puntoEmision, String fechaDesde, String fechaHasta) throws Exception {
        tipoDocumento = (tipoDocumento == null ? null : "'" + tipoDocumento + "'");
        establecimiento = (establecimiento == null ? null : "'" + establecimiento + "'");
        puntoEmision = (puntoEmision == null ? null : "'" + puntoEmision + "'");
        return anexos.helper.ConversionesAnexos.convertirAnxListadoRetencionesVentas_AnxListadoRetencionesVentasTO(
                em.createNativeQuery("SELECT * FROM "
                + "anexo.fun_listado_retenciones_ventas("
                + "'" + empresa + "', "
                + tipoDocumento + ", "
                + establecimiento + ", "
                + puntoEmision + ", "
                + "'" + fechaDesde + "', "
                + "'" + fechaHasta + "');").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxTalonResumenTO> getAnexoTalonResumenTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirTalonResumen_ListaTalonResumenTO(
                em.createNativeQuery("SELECT * FROM anexo.fun_talon_resumen"
                + "('" + empresa + "', '" + fechaDesde + "', '" + fechaHasta + "')").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxTalonResumenVentaTO> getAnexoTalonResumenVentaTO(String empresa, String fechaDesde, String fechaHasta) throws Exception {
        String sql = "SELECT * FROM anexo.fun_talon_resumen_ventas"
                + "('" + empresa + "',null, null, null, '" + fechaDesde + "', '" + fechaHasta + "')";
        return anexos.helper.ConversionesAnexos.convertirTalonResumenVenta_ListaTalonResumenVentaTO(
                em.createNativeQuery(sql).getResultList());
    }

    @Override
    public anexos.TO.AnxCuentasContablesTO getCuentasContablesTO(String empresa) throws Exception {
        anexos.TO.AnxCuentasContablesTO anxCuentasContablesTO = new anexos.TO.AnxCuentasContablesTO();
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM anexo.anx_cuentascontables "
                + "WHERE cta_empresa = ('" + empresa + "');").getResultList(), 0);
        /*
         * 0 cta_secuencial serial NOT NULL, 1 cta_empresa character(7) NOT
         * NULL, 2 cta_iva_pagado character(18), 3 cta_iva_cobrado
         * character(18), 4 cta_ret_fte_iva_pagado character(18), 5
         * cta_ret_fte_iva_cobrado character(18), 6 cta_ret_fte_iva_asumido
         * character(18), 7 cta_ret_fte_ir_pagado character(18), 8
         * cta_ret_fte_ir_cobrado character(18), 9 cta_ret_fte_ir_asumido
         * character(18), 10 cta_otros_impuestos character(18), 11
         * cta_cuentas_por_cobrar character(18), 12 cta_cuentas_por_pagar
         * character(18), 13 cta_cuentas_por_pagar_activo_fijo character(18), 14
         * cta_anticipos_de_clientes character(18), 15
         * cta_anticipos_a_proveedores character(18),
         *
         * 16 cta_venta_bienes_base0 character(18), 17
         * cta_venta_bienes_base_imponible character(18), 18
         * cta_venta_bienes_base_no_objeto character(18), 19
         * cta_venta_bienes_base_exenta character(18), 20
         * cta_venta_servicios_base0 character(18), 21
         * cta_venta_servicios_base_imponible character(18), 22
         * cta_venta_servicios_base_no_objeto character(18), 23
         * cta_venta_servicios_base_exenta character(18), 24 cta_diferencias
         * character(18),
         *
         */

        if (array != null) {
            anxCuentasContablesTO.setCtaSecuencial(array[0] == null ? 0 : new Integer(array[0].toString().trim()));
            anxCuentasContablesTO.setCtaEmpresa(array[1] == null ? "" : array[1].toString().trim());
            anxCuentasContablesTO.setCtaIvaPagado(array[2] == null ? "" : array[2].toString().trim());
            anxCuentasContablesTO.setCtaIvaCobrado(array[3] == null ? "" : array[3].toString().trim());

            anxCuentasContablesTO.setCtaRetFteIvaPagado(array[4] == null ? "" : array[4].toString().trim());
            anxCuentasContablesTO.setCtaRetFteIvaCobrado(array[5] == null ? "" : array[5].toString().trim());
            anxCuentasContablesTO.setCtaRetFteIvaAsumido(array[6] == null ? "" : array[6].toString().trim());

            anxCuentasContablesTO.setCtaRetFteIrPagado(array[7] == null ? "" : array[7].toString().trim());
            anxCuentasContablesTO.setCtaRetFteIrCobrado(array[8] == null ? "" : array[8].toString().trim());
            anxCuentasContablesTO.setCtaRetFteIrAsumido(array[9] == null ? "" : array[9].toString().trim());

            anxCuentasContablesTO.setCtaOtrosImpuestos(array[10] == null ? "" : array[10].toString().trim());
            anxCuentasContablesTO.setCtaCuentasPorCobrar(array[11] == null ? "" : array[11].toString().trim());
            anxCuentasContablesTO.setCtaCuentasPorPagar(array[12] == null ? "" : array[12].toString().trim());
            anxCuentasContablesTO.setCtaCuentasPorPagarActivoFijo(array[13] == null ? "" : array[13].toString().trim());
            anxCuentasContablesTO.setCtaAnticiposDeClientes(array[14] == null ? "" : array[14].toString().trim());
            anxCuentasContablesTO.setCtaAnticiposAProveedores(array[15] == null ? "" : array[15].toString().trim());
            anxCuentasContablesTO.setCtaVentaBienesBase0(array[16] == null ? "" : array[16].toString().trim());
            anxCuentasContablesTO.setCtaVentaBienesBaseImponible(array[17] == null ? "" : array[17].toString().trim());
            anxCuentasContablesTO.setCtaVentaBienesBaseNoObjeto(array[18] == null ? "" : array[18].toString().trim());
            anxCuentasContablesTO.setCtaVentaBienesBaseExenta(array[19] == null ? "" : array[19].toString().trim());
            anxCuentasContablesTO.setCtaVentaServiciosBase0(array[20] == null ? "" : array[20].toString().trim());
            anxCuentasContablesTO.setCtaVentaServiciosBaseImponible(array[21] == null ? "" : array[21].toString().trim());
            anxCuentasContablesTO.setCtaVentaServiciosBaseNoObjeto(array[22] == null ? "" : array[22].toString().trim());
            anxCuentasContablesTO.setCtaVentaServiciosBaseExenta(array[23] == null ? "" : array[23].toString().trim());

            anxCuentasContablesTO.setCtaDiferenciaRedondeo(array[24] == null ? "" : array[24].toString().trim());
        } else {
            anxCuentasContablesTO = null;
        }

        return anxCuentasContablesTO;
    }

    @Override
    public String getSectorAnexoNumeracion(String empresa, String numeroRetencion) throws Exception {
        String sectorCodigo = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT sec_codigo FROM anexo.anx_numeracion "
                + "WHERE num_empresa = ('" + empresa + "') AND num_comprobante = '07' AND ('" + numeroRetencion + "') >= num_desde "
                + "AND ('" + numeroRetencion + "') <= num_hasta").getResultList(), 0);

        if (array != null) {
            sectorCodigo = array[0].toString().trim();
        } else {
            sectorCodigo = "";
        }


        return sectorCodigo;
    }
//    @Override
//    public String getSectorAnexoNumeracionElectronica(String empresa, String numeroRetencion) throws Exception{
//        String sectorCodigo = "";
//        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
//                "SELECT sec_codigo "+ 
//                "FROM anexo.anx_documentos_electronicos_numeracion "+ 
//                "WHERE num_empresa = ('" + empresa +"') AND "+ 
//                "num_tipo_documento = '07' AND "+ 
//                "num_establecimiento = '" + numeroRetencion.substring(0, 3) +"' AND "+ 
//                "num_punto_emision = '" + numeroRetencion.substring(4, 7) +"'").getResultList(), 0);
//                
//        if (array != null){
//            sectorCodigo = array[0].toString().trim();
//        } else {
//            sectorCodigo = "";
//        }
//        return sectorCodigo;
//    }

    @Override
    public java.util.List<anexos.TO.AnxNumeracionTablaTO> getListaAnexoNumeracionTO(String empresa) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirNumeracionTabla_ListaNumeracionTablaTO(
                em.createNativeQuery("SELECT num_secuencial, num_comprobante, num_desde, num_hasta FROM anexo.anx_numeracion "
                + "WHERE num_empresa = ('" + empresa + "') ORDER BY 2, 3").
                getResultList());
    }

    @Override
    public anexos.TO.AnxNumeracionTO getAnexoNumeracionTO(Integer secuencia) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxNumeracion_AnxAnxNumeracionTO(
                anxNumeracionFacadeLocal.find(secuencia));
    }

    @Override
    public anexos.entity.AnxNumeracion getAnexoNumeracion(Integer secuencia) throws Exception {
        return anxNumeracionFacadeLocal.find(secuencia);
    }

    /*
     * num_empresa character(7) NOT NULL, num_comprobante character(2) NOT NULL,
     * num_desde character(17) NOT NULL, num_hasta character(17) NOT NULL,
     */
    @Override
    public boolean comprobarAnexoNumeracion(String empresa, String numeroComprobante, String desde, String hasta) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery(
                "SELECT COUNT(*)!=0 "
                + "FROM anexo.anx_numeracion WHERE (num_empresa = '" + empresa + "' AND  num_comprobante = '" + numeroComprobante + "' AND num_desde = '" + desde + "' AND num_hasta = '" + hasta + "')").getResultList(), 0)[0].toString());
    }

    @Override
    public anexos.entity.AnxConcepto getAnexoConcepto(String codigo) throws Exception {
        return anxConceptoFacadeLocal.find(codigo);
    }

    @Override
    public anexos.TO.AnxConceptoTO getBuscarAnexoConceptoTO(String conceptoCodigo) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxConcepto_AnxConceptoTO(anxConceptoFacadeLocal.find(conceptoCodigo));
    }

    @Override
    public java.util.List<anexos.TO.AnxConceptoTO> getAnexoConceptoTO() throws Exception {
        java.util.List<anexos.TO.AnxConceptoTO> listaAnxConceptoTO = new java.util.ArrayList(1);
        java.util.List<anexos.entity.AnxConcepto> listaAnxConcepto = anxConceptoFacadeLocal.findAll();
        if (!listaAnxConcepto.isEmpty()) {
            for (int i = 0; i < listaAnxConcepto.size(); i++) {
                listaAnxConceptoTO.add(anexos.helper.ConversionesAnexos.convertirAnxConcepto_AnxConceptoTO(listaAnxConcepto.get(i)));
            }
        }
        return listaAnxConceptoTO;
    }

    @Override
    public java.util.List<anexos.TO.AnxSustentoTO> getAnexoSustentoTO() throws Exception {
        java.util.List<anexos.TO.AnxSustentoTO> listaAnxSustentoTO = new java.util.ArrayList(1);
        java.util.List<anexos.entity.AnxSustento> listaAnxSustento = anxSustentoFacadeLocal.findAll();
        if (!listaAnxSustento.isEmpty()) {
            for (int i = 0; i < listaAnxSustento.size(); i++) {
                listaAnxSustentoTO.add(anexos.helper.ConversionesAnexos.convertirAnxSustento_AnxSustentoTO(listaAnxSustento.get(i)));
            }
        }
        return listaAnxSustentoTO;
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoComprobanteTO> getAnexoTipoComprobanteTO() throws Exception {
        java.util.List<anexos.TO.AnxTipoComprobanteTO> listaAnxTipoComprobanteTO = new java.util.ArrayList(1);
        java.util.List<anexos.entity.AnxTipocomprobante> listaAnxTipoComprobante = anxTipoComprobanteFacadeLocal.findAll();
        if (!listaAnxTipoComprobante.isEmpty()) {
            for (int i = 0; i < listaAnxTipoComprobante.size(); i++) {
                listaAnxTipoComprobanteTO.add(anexos.helper.ConversionesAnexos.convertirAnxTipoComprobante_AnxTipoComprobanteTO(listaAnxTipoComprobante.get(i)));
            }
        }
        return listaAnxTipoComprobanteTO;
    }

    @Override
    public List<anexos.TO.AnxTipoComprobanteTablaTO> getListaAnexoTipoComprobanteTO(String codigo) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirListaAnxTipoComprobanteTabla_ListaAnxTipoComprobanteTablaTO(
                em.createNativeQuery("SELECT tc_codigo, tc_descripcion, tc_abreviatura FROM anexo.anx_tipocomprobante "
                + "WHERE tc_codigo LIKE '%" + codigo + "%' OR tc_descripcion LIKE '%" + codigo + "%' OR tc_abreviatura LIKE '%" + codigo + "%' ORDER BY tc_codigo").
                getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoIdentificacionTO> getListaAnxTipoIdentificacionTO() throws Exception {
        return anexos.helper.ConversionesAnexos.convertirListaAnxTipoIdentificacion_ListaAnxTipoIdentificacionTO(
                em.createNativeQuery("SELECT * FROM anexo.anx_tipoidentificacion").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxTipoListaTransaccionTO> getAnexoTipoListaTransaccionTO() throws Exception {
        java.util.List<anexos.TO.AnxTipoListaTransaccionTO> listaAnxTipoListaTransaccionTO = new java.util.ArrayList(1);
        java.util.List<anexos.entity.AnxTipotransaccion> listaAnxTipoTransaccion = anxTipoTransaccionFacadeLocal.findAll();
        if (!listaAnxTipoTransaccion.isEmpty()) {
            for (int i = 0; i < listaAnxTipoTransaccion.size(); i++) {
                listaAnxTipoListaTransaccionTO.add(anexos.helper.ConversionesAnexos.convertirAnxTipoListaTransaccion_AnxTipoListaTransaccionTO(listaAnxTipoTransaccion.get(i)));
            }
        }
        return listaAnxTipoListaTransaccionTO;
    }

    @Override
    public java.util.List<anexos.TO.AnxAnuladoTablaTO> getListaAnxAnuladoTablaTO(String empresa) throws Exception {
        String fechaDesde = null;
        String fechaHasta = null;
        return anexos.helper.ConversionesAnexos.convertirListaAnxAnuladoTabla_ListaAnxAnuladoTablaTO(
                em.createNativeQuery("SELECT "
                + "anu_secuencial, "
                + "anu_comprobante_tipo, "
                + "anu_comprobante_establecimiento, "
                + "anu_comprobante_punto_emision, "
                + "anu_secuencial_inicio, "
                + "anu_secuencial_fin, "
                + "anu_comprobante_establecimiento || '-' || anu_comprobante_punto_emision || '-' || anu_secuencial_inicio anu_secuencial_inicial, "
                + "anu_comprobante_establecimiento || '-' || anu_comprobante_punto_emision || '-' || anu_secuencial_fin anu_secuencial_final, "
                + "anu_autorizacion, "
                + "anu_fecha, "
                + "anu_comprobante_nombre "
                + "FROM anexo.fun_anulados('" + empresa + "'," + fechaDesde + "," + fechaHasta + ");").getResultList());
    }

    @Override
    public anexos.TO.AnxAnuladosTO getAnxAnuladosTO(Integer secuencia) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxAnulados_AnxAnuladosTO(anxAnuladosFacadeLocal.find(secuencia));
    }

    @Override
    public anexos.entity.AnxTipocomprobante getAnexoTipoComprobante(String tcCodigo) throws Exception {
        return anxTipoComprobanteFacadeLocal.find(tcCodigo);
    }

    public boolean comprobarAnxCuentascontables(String empresa) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 "
                + "FROM anexo.anx_cuentascontables "
                + "WHERE (cta_empresa = '" + empresa + "');").
                getResultList(), 0)[0].toString());
    }

    public AnxCuentasContablesTO getAnxCuentasContablesTO(String empresa) throws Exception {
        return ConversionesAnexos.convertirAnxCuentasContables_AnxCuentasContablesTO(
                em.createNativeQuery("SELECT * "
                + "FROM anexo.anx_cuentascontables "
                + "WHERE (cta_empresa = '" + empresa + "');").getResultList());
    }

    public anexos.entity.AnxVenta getAnxVenta(String empresa, String periodo, String motivo, String numero) throws Exception {
        return anxVentaFacadeLocal.find(new anexos.entity.AnxVentaPK(empresa, periodo, motivo, numero));
    }

    @Override
    public Boolean getComprobanteVerificarAutorizacion(String empresa, String comprobanteTipo, String establecimiento, String puntoEmision, String secuencialInicio, String secuencialFin) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT * FROM anexo.fun_comprobante_verificar_utilizacion('" + empresa + "', '"
                + comprobanteTipo + "', '" + establecimiento + "', '" + puntoEmision + "', '" + secuencialInicio + "', '" + secuencialFin + "')").
                getResultList(), 0)[0].toString());
    }

    @Override
    public java.util.List<anexos.TO.AnxFunListadoDevolucionIvaTO> getAnxFunListadoDevolucionIvaTOs(String empCodigo, String desde, String hasta) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        return anexos.helper.ConversionesAnexos.convertirAnxFunListadoDevolucionIva_AnxFunListadoDevolucionIvaTO(em.createNativeQuery("SELECT * FROM anexo.fun_listado_devolucion_iva('"
                + empCodigo + "', "
                + desde + ", "
                + hasta + ");").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxCompraReembolsoTO> getAnexoCompraReembolsoTOs(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {

        String cad = "SELECT  anexo.anx_compra_reembolso.reemb_secuencial, anexo.anx_compra_reembolso.reemb_documento_tipo, "
                + " anexo.anx_compra_reembolso.reemb_documento_numero, "
                + " anexo.anx_compra_reembolso.reemb_fechaemision, "
                + " anexo.anx_compra_reembolso.reemb_autorizacion, "
                + " anexo.anx_compra_reembolso.reemb_baseimponible, "
                + " anexo.anx_compra_reembolso.reemb_baseimpgrav, "
                + " anexo.anx_compra_reembolso.reemb_basenograiva, "
                + " anexo.anx_compra_reembolso.reemb_montoice, "
                + " anexo.anx_compra_reembolso.reemb_montoiva, "
                + " anexo.anx_compra_reembolso.prov_empresa, "
                + " anexo.anx_compra_reembolso.prov_codigo, "
                + " anexo.anx_compra_reembolso.comp_empresa, "
                + " anexo.anx_compra_reembolso.comp_periodo, "
                + " anexo.anx_compra_reembolso.comp_motivo, "
                + " anexo.anx_compra_reembolso.comp_numero, "
                + " anexo.anx_tipocomprobante.tc_abreviatura, "
                + " inventario.inv_proveedor.prov_nombre, "
                + " inventario.inv_proveedor.prov_id_numero "
                + " FROM anexo.anx_compra_reembolso"
                + " INNER JOIN anexo.anx_tipocomprobante ON anexo.anx_compra_reembolso.reemb_documento_tipo = anexo.anx_tipocomprobante.tc_codigo"
                + " INNER JOIN inventario.inv_proveedor ON anexo.anx_compra_reembolso.prov_empresa = inventario.inv_proveedor.prov_empresa AND anexo.anx_compra_reembolso.prov_codigo = inventario.inv_proveedor.prov_codigo WHERE "
                + " anexo.anx_compra_reembolso.comp_empresa = '" + empresa + "' AND "
                + " anexo.anx_compra_reembolso.comp_periodo = '" + periodo + "' AND "
                + " anexo.anx_compra_reembolso.comp_motivo = '" + motivo + "' AND "
                + " anexo.anx_compra_reembolso.comp_numero = '" + numeroCompra + "'";

        java.util.List<anexos.TO.AnxCompraReembolsoTO> anxCompraReembolsos = anexos.helper.ConversionesAnexos.convertirListaObject_ListaAnxCompraReembolsoTO(
                em.createNativeQuery(cad).getResultList());
        for (int i = 0; i < anxCompraReembolsos.size(); i++) {
            anxCompraReembolsos.get(i).setReembFechaemision(validaciones.Validacion.convertirAaaaMmDdTODdMmAaaa(anxCompraReembolsos.get(i).getReembFechaemision()));
        }
        return anxCompraReembolsos;
    }

    @Override
    public java.util.List<anexos.entity.AnxCompraReembolso> getAnexoCompraReembolsos(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {
        java.util.List<anexos.entity.AnxCompraReembolso> anxCompraReembolsos = em.createQuery("SELECT a FROM AnxCompraReembolso a WHERE "
                + "a.anxCompra.anxCompraPK.compEmpresa = :empresa AND a.anxCompra.anxCompraPK.compPeriodo = :periodo AND a.anxCompra.anxCompraPK.compMotivo = :motivo "
                + "AND a.anxCompra.anxCompraPK.compNumero = :numero").
                setParameter("empresa", empresa).setParameter("periodo", periodo).setParameter("motivo", motivo).setParameter("numero", numeroCompra).getResultList();
        return anxCompraReembolsos;
    }

    @Override
    public anexos.entity.AnxSustento getAnexoSustento(String codigo) throws Exception {
        return anxSustentoFacadeLocal.find(codigo);
    }

    @Override
    public anexos.entity.AnxFormaPago getAnexoFormaPago(String codigo) throws Exception {
        return anxFormaPagoFacadeLocal.find(codigo);
    }

    @Override
    public java.util.List<anexos.TO.AnxFormaPagoTO> getAnexoFormaPagoTO() throws Exception {
        java.util.List<anexos.TO.AnxFormaPagoTO> listaAnxFormaPagoTO = new java.util.ArrayList(1);
        java.util.List<anexos.entity.AnxFormaPago> listaAnxFormaPago = anxFormaPagoFacadeLocal.findAll();
        if (!listaAnxFormaPago.isEmpty()) {
            for (int i = 0; i < listaAnxFormaPago.size(); i++) {
                listaAnxFormaPagoTO.add(anexos.helper.ConversionesAnexos.convertirAnxFormaPago_AnxFormaPagoTO(listaAnxFormaPago.get(i)));
            }
        }
        return listaAnxFormaPagoTO;
    }

    @Override
    public java.util.List<anexos.TO.AnxCompraFormaPagoTO> getAnexoCompraFormaPagoTO(String empresa, String periodo, String motivo, String numero) throws Exception {
        java.util.List<anexos.TO.AnxCompraFormaPagoTO> anxCompraFormaPagoTOs = anexos.helper.ConversionesAnexos.convertirListaObject_ListaAnxCompraFormaPagoTO(
                em.createNativeQuery("SELECT * FROM anexo.anx_compra_forma_pago WHERE anexo.anx_compra_forma_pago.comp_empresa = '" + empresa + "' AND "
                + " anexo.anx_compra_forma_pago.comp_periodo = '" + periodo + "' AND "
                + " anexo.anx_compra_forma_pago.comp_motivo = '" + motivo + "' AND "
                + " anexo.anx_compra_forma_pago.comp_numero = '" + numero + "'").getResultList(), new String[]{empresa, periodo, motivo, numero});
        return anxCompraFormaPagoTOs;
    }

    @Override
    public java.util.List<anexos.entity.AnxCompraFormaPago> getAnexoCompraFormaPago(String empresa, String periodo, String motivo, String numeroCompra) throws Exception {

        java.util.List<anexos.entity.AnxCompraFormaPago> anxCompraDetalles = em.createQuery("SELECT a FROM AnxCompraFormaPago a WHERE "
                + "a.anxCompra.anxCompraPK.compEmpresa = :empresa AND a.anxCompra.anxCompraPK.compPeriodo = :periodo AND a.anxCompra.anxCompraPK.compMotivo = :motivo "
                + "AND a.anxCompra.anxCompraPK.compNumero = :numero ORDER BY a.detOrden").
                setParameter("empresa", empresa).setParameter("periodo", periodo).setParameter("motivo", motivo).setParameter("numero", numeroCompra).getResultList();
        return anxCompraDetalles;
    }

    @Override
    public String getUltimaNumeracionComprobante(String empresa, String comprobante, String secuencial) throws Exception {
        String ultimoSecuencial = "";

        String sql = "SELECT * FROM anexo.fun_comprobante_obtener_ultima_numeracion('"
                + empresa + "', '"
                + comprobante + "', '"
                + secuencial + "');";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(sql).getResultList(), 0);

        if (array != null) {
            ultimoSecuencial = array[0].toString().trim();
        } else {
            ultimoSecuencial = "";
        }

        return ultimoSecuencial;
    }
//    @Override
//    public java.util.List<String> getListadoUltimaNumeracionComprobante(String empresa, String comprobante, String secuencial) throws Exception {
//          return anexos.helper.ConversionesAnexos.convertirfunComprobanteObtenerUltimaNumeracion_FunComprobanteObtenerUltimaNumeracionTO(
//                em.createNativeQuery("SELECT ret_retencionnumero FROM anexo.fun_comprobante_obtener_ultima_numeracion "
//                + "('" + empresa + "', '" + comprobante + "', '" + secuencial + "')").getResultList());
//    }

    //6) interfaz de OperacionesanexoDAO
    @Override
    public java.util.List<anexos.TO.AnxPaisTO> getComboAnxPaisTO() throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxPais_AnxPaisTO(
                em.createNativeQuery("SELECT pais_codigo, pais_nombre"
                + " FROM anexo.anx_pais;").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxProvinciaTO() throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxProvinciaCanton_AnxProvinciaCantonTO(
                em.createNativeQuery("SELECT provincia_codigo, provincia_nombre"
                + " FROM anexo.anx_provincias"
                + " GROUP BY provincia_codigo, provincia_nombre"
                + " ORDER BY provincia_nombre;").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxCantonTO(String provincia) throws Exception {
        provincia = provincia == null ? provincia : "'" + provincia + "'";
        return anexos.helper.ConversionesAnexos.convertirAnxProvinciaCanton_AnxProvinciaCantonTO(
                em.createNativeQuery("SELECT canton_codigo, canton_nombre "
                + "FROM anexo.anx_provincias "
                + "WHERE provincia_codigo=" + provincia + " "
                + "ORDER BY canton_nombre;").getResultList());
    }

    //////////////////////
    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxDpaProvinciaTO() throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxProvinciaCanton_AnxProvinciaCantonTO(
                em.createNativeQuery("SELECT codigo_provincia,nombre_provincia "
                + "FROM anexo.anx_dpa_ecuador "
                + "GROUP BY codigo_provincia,nombre_provincia "
                + "ORDER BY nombre_provincia ").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxDpaCantonTO(String codigoProvincia) throws Exception {
        codigoProvincia = codigoProvincia == null ? codigoProvincia : "'" + codigoProvincia + "'";
        return anexos.helper.ConversionesAnexos.convertirAnxProvinciaCanton_AnxProvinciaCantonTO(
                em.createNativeQuery("SELECT codigo_canton, nombre_canton "
                + "FROM anexo.anx_dpa_ecuador "
                + "WHERE codigo_provincia = " + codigoProvincia + " "
                + "GROUP BY codigo_canton, nombre_canton "
                + "ORDER BY nombre_canton;").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxProvinciaCantonTO> getComboAnxParroquiaTO(String codigoProvincia, String codigoCanton) throws Exception {
        codigoProvincia = codigoProvincia == null ? codigoProvincia : "'" + codigoProvincia + "'";
        codigoCanton = codigoCanton == null ? codigoCanton : "'" + codigoCanton + "'";
        return anexos.helper.ConversionesAnexos.convertirAnxProvinciaCanton_AnxProvinciaCantonTO(
                em.createNativeQuery("SELECT codigo_parroquia, nombre_parroquia "
                + "FROM anexo.anx_dpa_ecuador "
                + "WHERE codigo_canton = " + codigoCanton + " "
                + "AND codigo_provincia = " + codigoProvincia + " "
                + "ORDER BY nombre_parroquia;").getResultList());
    }

    @Override
    public String getObtenerProvincia(String canton) throws Exception {
        String provincia = "";

        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT * FROM anexo.fun_obtener_provincia('" + canton + "');").getResultList(), 0);

        if (array != null) {
            provincia = array[0].toString().trim();
        } else {
            provincia = "";
        }
        return provincia;
    }

    @Override
    public java.util.List<anexos.TO.AnxFunRegistroDatosCrediticiosTO> getFunRegistroDatosCrediticiosTOs(String codigoEmpresa, String fechaDesde, String fechaHasta) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxFunRegistroDatosCrediticios_AnxFunRegistroDatosCrediticiosTO(
                em.createNativeQuery("SELECT * FROM anexo.fun_registro_datos_crediticios('" + codigoEmpresa + "',"
                + (fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'") + ","
                + (fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'") + ");").getResultList());

    }

    @Override
    public java.lang.String getCompAutorizacion(java.lang.String empCodigo, java.lang.String provCodigo, java.lang.String codTipoComprobante, java.lang.String numComplemento) throws Exception {
        String compAutorizacion = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT anx_compra.comp_autorizacion "
                + "FROM inventario.inv_compras INNER JOIN anexo.anx_compra "
                + "ON inv_compras.comp_empresa = anx_compra.comp_empresa AND "
                + "inv_compras.comp_periodo = anx_compra.comp_periodo AND "
                + "inv_compras.comp_motivo = anx_compra.comp_motivo AND "
                + "inv_compras.comp_numero = anx_compra.comp_numero "
                + "WHERE prov_empresa = '" + empCodigo + "' AND "
                + "prov_codigo = '" + provCodigo + "' AND "
                + "comp_documento_tipo = '" + codTipoComprobante + "' AND "
                + "comp_documento_numero = '" + numComplemento + "' AND "
                + "NOT (comp_pendiente OR comp_anulado);").getResultList(), 0);
        if (array != null) {
            compAutorizacion = array[0].toString().trim();
        } else {
            compAutorizacion = "";
        }
        return compAutorizacion;
    }

    @Override
    public anexos.TO.anxUrlWebServicesTO getAnxUrlWebServicesTO() throws Exception {
        anexos.TO.anxUrlWebServicesTO anxUrlWebServicesTO = null;
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                " SELECT url_secuencial serial, url_ambiente_produccion, url_ambiente_pruebas FROM anexo.anx_url_web_services").getResultList(), 0);
        if (array != null) {
            anxUrlWebServicesTO = new anexos.TO.anxUrlWebServicesTO();
            anxUrlWebServicesTO.setUrlSecuencial(array[0] == null ? 0 : new Integer(array[0].toString().trim()));
            anxUrlWebServicesTO.setUrlAmbienteProduccion(array[1] == null ? null : array[1].toString().trim());
            anxUrlWebServicesTO.setUrlAmbientePruebas(array[2] == null ? null : array[2].toString().trim());
        } else {
            anxUrlWebServicesTO = null;
        }
        return anxUrlWebServicesTO;
    }

    @Override
    public boolean comprobarAnxDirectorio(String empresa) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery(
                "SELECT COUNT(*)!=0 "
                + "FROM anexo.anx_directorios WHERE (directorio_empresa = '" + empresa + "');").
                getResultList(), 0)[0].toString());
    }

    @Override
    public byte[] getXmlComprobanteRetencion(
            String empresa,
            String ePeriodo,
            String eMotivo,
            String eNumero) throws Exception {

        empresa = empresa == null ? empresa : "'" + empresa + "'";
        ePeriodo = ePeriodo == null ? ePeriodo : "'" + ePeriodo + "'";
        eMotivo = eMotivo == null ? eMotivo : "'" + eMotivo + "'";
        eNumero = eNumero == null ? eNumero : "'" + eNumero + "'";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT e_xml FROM anexo.anx_compra_electronica "
                + "WHERE comp_empresa = " + empresa + " and  comp_periodo = " + ePeriodo + " and comp_motivo = " + eMotivo + " and comp_numero = " + eNumero + ";").getResultList(), 0);
        return array[0] == null ? null : (byte[]) array[0];
    }

    @Override
    public java.util.List<anexos.TO.AnxListadoCompraElectronicaTO> getListaAnxComprasElectronicaTO(
            String empresa,
            String estado,
            String fechaDesde,
            String fechaHasta) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        String complemetoQuery = estado.equals("AUTORIZADO") ? "inv_compras.comp_fecha >= " + fechaDesde + " AND "
                + "inv_compras.comp_fecha <= " + fechaHasta + " AND e_estado = 'AUTORIZADO'" : "e_estado != 'AUTORIZADO'";
        /*
         * private Integer eSecuencial; private String compPeriodo; private
         * String compMotivo; private String compNumero; private String
         * provNombre; private String compRetencionNumero; private String
         * compRetencionFechaEmision; private String eAutorizacionFecha; private
         * String eAutorizacionNumero; private Boolean eEnviadoPorCorreo;
         */
        return anexos.helper.ConversionesAnexos.convertirAnxCompraElectronica_AnxCompraElectronicaTO(
                em.createNativeQuery(
                "SELECT  "
                + "e_secuencial, "
                + "anx_compra_electronica.comp_periodo, "
                + "anx_compra_electronica.comp_motivo, "
                + "anx_compra_electronica.comp_numero, "
                + "prov_nombre, "
                + "comp_retencion_numero, "
                + "comp_retencion_fecha_emision, "
                + "e_autorizacion_fecha, "
                + "e_autorizacion_numero, "
                + "e_enviado_por_correo "
                + "FROM inventario.inv_proveedor INNER JOIN inventario.inv_compras INNER "
                + "JOIN anexo.anx_compra INNER JOIN anexo.anx_compra_electronica "
                + "ON anx_compra.comp_empresa = anx_compra_electronica.comp_empresa AND "
                + "anx_compra.comp_periodo = anx_compra_electronica.comp_periodo AND "
                + "anx_compra.comp_motivo = anx_compra_electronica.comp_motivo AND "
                + "anx_compra.comp_numero = anx_compra_electronica.comp_numero "
                + "ON inv_compras.comp_empresa = anx_compra.comp_empresa AND "
                + "inv_compras.comp_periodo = anx_compra.comp_periodo AND "
                + "inv_compras.comp_motivo = anx_compra.comp_motivo AND "
                + "inv_compras.comp_numero = anx_compra.comp_numero "
                + "ON inv_proveedor.prov_empresa = inv_compras.prov_empresa AND "
                + "inv_proveedor.prov_codigo = inv_compras.prov_codigo "
                + "WHERE emp_codigo = " + empresa + " AND "
                + complemetoQuery + " AND "
                + "NOT (inv_compras.comp_pendiente OR inv_compras.comp_anulado) "
                + "ORDER BY anx_compra.comp_retencion_numero;").getResultList());
    }

    @Override
    public java.util.List<anexos.TO.AnxListaRetencionesPendientesTO> getAnexoListaRetencionesPendienteTO(String empresa) throws Exception {
        String sql = "SELECT * FROM anexo.fun_listado_retenciones_pendientes"
                + "('" + empresa + "')";
        return anexos.helper.ConversionesAnexos.convertirListaRetencionesPendientesAutorizacion_ListaRetencionesPendientesAutorizacionTO(
                em.createNativeQuery(sql).getResultList());
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< VENTAS ELECTRONICAS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public byte[] getXmlComprobanteElectronico(
            String empresa,
            String ePeriodo,
            String eMotivo,
            String eNumero) {

        empresa = empresa == null ? empresa : "'" + empresa + "'";
        ePeriodo = ePeriodo == null ? ePeriodo : "'" + ePeriodo + "'";
        eMotivo = eMotivo == null ? eMotivo : "'" + eMotivo + "'";
        eNumero = eNumero == null ? eNumero : "'" + eNumero + "'";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT e_xml FROM anexo.anx_venta_electronica "
                + "WHERE vta_empresa = " + empresa + " and  vta_periodo = " + ePeriodo + " and vta_motivo = " + eMotivo + " and vta_numero = " + eNumero + ";").getResultList(), 0);
        //dato11 = (byte[]) array[10];
        return array[0] == null ? null : (byte[]) array[0];
    }

    @Override
    public java.util.List<anexos.TO.AnxListaVentaElectronicaTO> getListaAnxVentaElectronicaTO(
            String empresa,
            String estado,
            String fechaDesde,
            String fechaHasta,
            String tipoDocumento) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        tipoDocumento = tipoDocumento == null || tipoDocumento.equals("TODOS") ? "" : "inv_ventas.vta_documento_tipo = '" + tipoDocumento + "' AND ";
        String complemetoQuery = estado.equals("AUTORIZADO") ? "inv_ventas.vta_fecha >= " + fechaDesde + " AND "
                + "inv_ventas.vta_fecha <= " + fechaHasta + " AND e_estado = 'AUTORIZADO' " : "e_estado != 'AUTORIZADO' AND e_estado != 'PENDIENTE' ";
        return anexos.helper.ConversionesAnexos.convertirAnxVentaElectronica_AnxVentaElectronicaTO(
                em.createNativeQuery("SELECT "
                + "anx_venta_electronica.e_secuencial, "
                + "anx_venta_electronica.vta_periodo,  "
                + "anx_venta_electronica.vta_motivo,  "
                + "anx_venta_electronica.vta_numero, "
                + "cli_nombre, "
                + "vta_documento_tipo, "
                + "vta_documento_numero, "
                + "vta_fecha, "
                + "e_autorizacion_fecha,  "
                + "e_autorizacion_numero, "
                + "e_enviado_por_correo "
                + "FROM inventario.inv_cliente INNER JOIN inventario.inv_ventas INNER "
                + "JOIN anexo.anx_venta_electronica ON inv_ventas.vta_empresa = anx_venta_electronica.vta_empresa AND "
                + "inv_ventas.vta_periodo = anx_venta_electronica.vta_periodo AND "
                + "inv_ventas.vta_motivo = anx_venta_electronica.vta_motivo AND "
                + "inv_ventas.vta_numero = anx_venta_electronica.vta_numero "
                + "ON inv_ventas.vta_empresa = inv_cliente.cli_empresa AND "
                + "inv_ventas.cli_codigo = inv_cliente.cli_codigo "
                + "WHERE inv_ventas.emp_codigo = " + empresa + " AND "
                + complemetoQuery + " AND "
                + tipoDocumento
                + "NOT (vta_pendiente OR vta_anulado) "
                + "ORDER BY inv_ventas.vta_documento_tipo, "
                + "inv_ventas.vta_documento_numero;").getResultList());
    }

    @Override
    public anexos.entity.AnxVentaElectronica buscarAnxVentaElectronica(String empresa, String periodo, String motivo, String numero) throws Exception {
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT e_secuencial  "
                + "FROM anexo.anx_venta_electronica  "
                + "WHERE vta_empresa = '" + empresa + "' AND vta_periodo = '" + periodo + "' AND   "
                + "vta_motivo = '" + motivo + "' and vta_numero = '" + numero + "';").getResultList(), 0);

        return anxVentaElectronicaFacadeLocal.find(new Integer(array[0].toString().trim()));
    }

    @Override
    public boolean comprobarAnxVentaElectronica(String empresa, String periodo, String motivo, String numero) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM anexo.anx_venta_electronica "
                + "WHERE (vta_empresa = '" + empresa + "' AND vta_periodo = '" + periodo + " 'AND vta_motivo = '" + motivo + " 'AND vta_numero = '" + numero + "');").
                getResultList(), 0)[0].toString());
    }

    @Override
    public boolean comprobarAnxVentaElectronicaAutorizacion(String empresa, String periodo, String motivo, String numero, String estado) throws Exception {
        /*
         * vta_empresa character(7) NOT NULL, vta_periodo character(7) NOT NULL,
         * vta_motivo character(7) NOT NULL, vta_numero character(7) NOT NULL,
         */
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM anexo.anx_venta_electronica "
                + "WHERE (vta_empresa = '" + empresa + "' AND vta_periodo = '" + periodo + " 'AND vta_motivo = '" + motivo + " 'AND vta_numero = '" + numero + "' AND e_estado = '" + estado + "');").
                getResultList(), 0)[0].toString());
    }

//    @Override
//    public anexos.TO.AnxVentaElectronicaTO AnxVentaElectronicaTO(String empresa, String periodo, String motivo, String numeroVenta) throws Exception {
//
//        return anexos.helper.ConversionesAnexos.convertirAnxVenta_AnxVentaTO(anxVentaFacadeLocal.find
//                (new anexos.entity.AnxVentaPK(empresa, periodo, motivo, numeroVenta)));
//        return anexos.helper.ConversionesAnexos.convertirAnxVentaElectronica_AnxVentaElectronicaTO(anxVentaFacadeLocal.find
//                (new anexos.entity.AnxVentaPK(empresa, periodo, motivo, numeroVenta)));
//    }
    @Override
    public java.util.List<anexos.TO.AnxListaConsultaVentaElectronicaTO> getListaAnxConsultaVentaElectronica(String empresa, String periodo, String motivo, String busqueda) throws Exception {
        return anexos.helper.ConversionesAnexos.convertirAnxListaConsultaVentaElectronica_AnxListaConsultaVentaElectronicaTO(em.createNativeQuery("SELECT * FROM anexo.fun_ventas_electronicas_listado('" + empresa + "', '" + periodo + "', '" + motivo + "', '" + busqueda + "')").getResultList());
    }

    @Override
    public anexos.TO.AnxUltimaAutorizacionTO getAnxUltimaAutorizacionTO(
            String empresa,
            String proveedor,
            String tipoDocumento,
            String secuencial,
            String fechaFactura) throws Exception {
        anexos.TO.AnxUltimaAutorizacionTO anxUltimaAutorizacionTO = null;
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        proveedor = proveedor == null ? proveedor : "'" + proveedor + "'";
        tipoDocumento = tipoDocumento == null ? tipoDocumento : "'" + tipoDocumento + "'";
        secuencial = secuencial == null ? secuencial : "'" + secuencial + "'";
        fechaFactura = fechaFactura == null ? fechaFactura : "'" + fechaFactura + "'";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                " SELECT comp_autorizacion, comp_fecha_emision, comp_fecha_caduca "
                + "FROM ( SELECT comp_fecha, comp_autorizacion, comp_fecha_emision, comp_fecha_caduca FROM inventario.inv_compras "
                + "INNER JOIN anexo.anx_compra ON inv_compras.comp_empresa = anx_compra.comp_empresa AND inv_compras.comp_periodo = anx_compra.comp_periodo AND "
                + "inv_compras.comp_motivo = anx_compra.comp_motivo AND inv_compras.comp_numero = anx_compra.comp_numero "
                + "WHERE inv_compras.prov_empresa = " + empresa + " AND inv_compras.prov_codigo = " + proveedor + " AND "
                + "inv_compras.comp_documento_tipo = " + tipoDocumento + " AND substring(inv_compras.comp_documento_numero,1,7) = " + secuencial + " AND NOT (comp_anulado OR comp_pendiente) "
                + "ORDER BY comp_fecha DESC LIMIT 1) ultima_factura "
                + "WHERE length(comp_autorizacion)=10 AND " + fechaFactura + " >= comp_fecha_emision AND " + fechaFactura + " <= comp_fecha_caduca;").getResultList(), 0);
        if (array != null) {
            anxUltimaAutorizacionTO = new anexos.TO.AnxUltimaAutorizacionTO();
            anxUltimaAutorizacionTO.setCompAutorizacion(array[0] == null ? null : array[0].toString().trim());
            anxUltimaAutorizacionTO.setCompEmision(array[1] == null ? null : array[1].toString().trim());
            anxUltimaAutorizacionTO.setCompCaduca(array[2] == null ? null : array[2].toString().trim());

        } else {
            anxUltimaAutorizacionTO = null;
        }
        return anxUltimaAutorizacionTO;
    }

    @Override
    public String getUltimaNumeracionComprobanteElectronicos(String empresa, String comprobante, String estaBlecimiento, String puntoEmision) throws Exception {
        String ultimoSecuencial = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT num_establecimiento,num_punto_emision,num_secuencial  "
                + "FROM anexo.anx_documentos_electronicos_numeracion  "
                + "WHERE num_empresa = '" + empresa + "' AND num_tipo_documento = '" + comprobante + "' AND   "
                + "num_establecimiento = '" + estaBlecimiento + "' and num_punto_emision = '" + puntoEmision + "';").getResultList(), 0);

        if (array != null) {
            ultimoSecuencial = array[0].toString().trim() + "-" + array[1].toString().trim() + "-" + array[2].toString().trim();
        } else {
            ultimoSecuencial = "";
        }

        return ultimoSecuencial;
    }
//    @Override
//    public anexos.TO.AnxDocumentosElectronicosNumeracionTO getUltimaNumeracionComprobanteElectronicos(String empresa, String comprobante, String estaBlecimiento, String puntoEmision){
//            anexos.TO.AnxDocumentosElectronicosNumeracionTO anxDocumentosElectronicosNumeracionTO = null;
//            Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
//                "SELECT num_establecimiento ,num_punto_emision ,num_secuencial ,sec_codigo  "
//                + "FROM anexo.anx_documentos_electronicos_numeracion  "
//                + "WHERE num_empresa = '"+empresa+"' AND num_tipo_documento = '"+comprobante+"' AND   "
//                + "num_establecimiento = '"+estaBlecimiento+"' and num_punto_emision = '"+puntoEmision+"';").getResultList(), 0);
//            anxDocumentosElectronicosNumeracionTO = new anexos.TO.AnxDocumentosElectronicosNumeracionTO();
//            if (array != null){
//                anxDocumentosElectronicosNumeracionTO.setNumEstablecimiento(array[0] == null ? null : array[0].toString().trim());
//                anxDocumentosElectronicosNumeracionTO.setNumPuntoEmision(array[1] == null ? null : array[1].toString().trim());
//                anxDocumentosElectronicosNumeracionTO.setNumSecuencial(array[2] == null ? null : array[2].toString().trim());
//                anxDocumentosElectronicosNumeracionTO.setSecCodigo(array[3] == null ? null : array[3].toString().trim());
//            } else {
//                anxDocumentosElectronicosNumeracionTO = null;
//            }
//            return anxDocumentosElectronicosNumeracionTO;
//        
//    }

//    @Override
//    public String getUltimaNumeracionComprobanteElectronicos(String empresa, String comprobante, String estaBlecimiento, String puntoEmision) throws Exception {
//        String ultimoSecuencial = "";
//        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
//                "SELECT num_establecimiento,num_punto_emision,num_secuencial  "
//                + "FROM anexo.anx_documentos_electronicos_numeracion  "
//                + "WHERE num_empresa = '"+empresa+"' AND num_tipo_documento = '"+comprobante+"' AND   "
//                + "num_establecimiento = '"+estaBlecimiento+"' and num_punto_emision = '"+puntoEmision+"';").getResultList(), 0);
//        
//        if (array != null){
//            ultimoSecuencial = array[0].toString().trim()+"-"+array[1].toString().trim()+"-"+array[2].toString().trim();
//        } else {
//            ultimoSecuencial = "";
//        }
//        
//        return ultimoSecuencial;
//    }
    @Override
    //e_empresa , e_periodo , e_motivo , e_numero 
    public boolean comprobarAnxCompraElectronica(String empresa, String periodo, String motivo, String numero) throws Exception {

        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM anexo.anx_compra_electronica "
                + "WHERE (comp_empresa = '" + empresa + "' AND comp_periodo = '" + periodo + " 'AND comp_motivo = '" + motivo + " 'AND comp_numero = '" + numero + "');").
                getResultList(), 0)[0].toString());
    }

    @Override
    public boolean comprobarRetencionAutorizadaProcesamiento(String empresa, String periodo, String motivo, String numero) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM anexo.anx_compra_electronica "
                + "WHERE (comp_empresa = '" + empresa + "' AND comp_periodo = '" + periodo + " ' AND comp_motivo = '" + motivo + " ' AND comp_numero = '" + numero + "' AND  "
                + "(e_estado = 'AUTORIZADO' OR e_autorizacion_numero = 'CE(70): CLAVE DE ACCESO EN PROCESAMIENTO'))").
                getResultList(), 0)[0].toString());
    }

    @Override
    public anexos.entity.AnxCompraElectronica buscarAnxCompraElectronica(String empresa, String periodo, String motivo, String numero) throws Exception {

        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT e_secuencial  "
                + "FROM anexo.anx_compra_electronica  "
                + "WHERE comp_empresa = '" + empresa + "' AND comp_periodo = '" + periodo + "' AND   "
                + "comp_motivo = '" + motivo + "' and comp_numero = '" + numero + "';").getResultList(), 0);

        return anxCompraElectronicaFacadeLocal.find(new Integer(array[0].toString().trim()));
    }

    public InvConsultaVentasFacturasPorNumeroTO getConsultaPKRetencion(String codEmpresa, String numRetencion, String numAutorizacion) throws Exception {
        return ConversionesInventario.convertirIInvConsultaVentasFacturasPorNumero_InvConsultaVentasFacturasPorNumeroTO(em.createNativeQuery(
                "SELECT comp_empresa, comp_periodo, comp_motivo, comp_numero "
                + "FROM anexo.anx_compra_electronica "
                + "WHERE (comp_empresa = '" + codEmpresa + "' AND e_clave_acceso like '%" + numRetencion + "%' AND e_autorizacion_numero = '" + numAutorizacion + "');").getResultList());
    }
}
