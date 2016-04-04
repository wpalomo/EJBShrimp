/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.helper;

import anexos.TO.AnxCuentasContablesTO;
import anexos.TO.AnxEstablecimientoComboTO;
import anexos.entity.AnxCompra;
import anexos.entity.AnxCuentascontables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jack
 */
public class ConversionesAnexos {

    public static anexos.entity.AnxCompra convertirAnxCompraTO_AnxCompra(anexos.TO.AnxCompraTO anxCompraTO) {
        anexos.entity.AnxCompra anxCompra = new anexos.entity.AnxCompra();

        anxCompra.setAnxCompraPK(new anexos.entity.AnxCompraPK(
                anxCompraTO.getEmpCodigo(),
                anxCompraTO.getPerCodigo(),
                anxCompraTO.getMotCodigo(),
                anxCompraTO.getCompNumero()));
        anxCompra.setCompSustentotributario(new anexos.entity.AnxSustento(anxCompraTO.getCompSustentotributario()));//revisar

        anxCompra.setCompAutorizacion(anxCompraTO.getCompAutorizacion());
        anxCompra.setCompFechaEmision(validaciones.Validacion.fecha(anxCompraTO.getCompEmision(), "dd-MM-yyyy"));
        anxCompra.setCompFechaCaduca(validaciones.Validacion.fecha(anxCompraTO.getCompCaduca(), "dd-MM-yyyy"));
        anxCompra.setCompFechaRecepcion(validaciones.Validacion.fecha(anxCompraTO.getCompCaduca(), "dd-MM-yyyy"));//revisar
        anxCompra.setCompBase0(anxCompraTO.getCompBase0());
        anxCompra.setCompBaseimponible(anxCompraTO.getCompBaseimponible());
        anxCompra.setCompBasenoobjetoiva(anxCompraTO.getCompBasenoobjetoiva());
        anxCompra.setCompMontoice(anxCompraTO.getCompMontoice());
        anxCompra.setCompMontoiva(anxCompraTO.getCompMontoiva());

        anxCompra.setCompBaseivabienes(anxCompraTO.getCompBaseivabienes());
        anxCompra.setCompBaseivaservicios(anxCompraTO.getCompBaseivaservicios());
        anxCompra.setCompBaseivaserviciosprofesionales(anxCompraTO.getCompBaseivaserviciosprofesionales());
        anxCompra.setCompPorcentajebienes(anxCompraTO.getCompPorcentajebienes());
        anxCompra.setCompPorcentajeservicios(anxCompraTO.getCompPorcentajeservicios());

        anxCompra.setCompPorcentajeserviciosprofesionales(anxCompraTO.getCompPorcentajeserviciosprofesionales());
        anxCompra.setCompValorbienes(anxCompraTO.getCompValorbienes());
        anxCompra.setCompValorservicios(anxCompraTO.getCompValorservicios());
        anxCompra.setCompValorserviciosprofesionales(anxCompraTO.getCompValorserviciosprofesionales());

        anxCompra.setCompRetencionEmpresa(anxCompraTO.getEmpCodigo());//revisar

        anxCompra.setCompRetencionNumero(anxCompraTO.getCompRetencionNumero());
        anxCompra.setCompRetencionAutorizacion(anxCompraTO.getCompRetencionAutorizacion());
        anxCompra.setCompRetencionFechaEmision(validaciones.Validacion.fecha(anxCompraTO.getCompRetencionFechaEmision(), "yyyy-MM-dd"));

        anxCompra.setCompModificadoDocumentoEmpresa(anxCompraTO.getEmpCodigo());
        anxCompra.setCompModificadoDocumentoTipo(anxCompraTO.getCompModificadoDocumentoTipo());
        anxCompra.setCompModificadoDocumentoNumero(anxCompraTO.getCompModificadoDocumentoNumero());
        anxCompra.setCompModificadoAutorizacion(anxCompraTO.getCompModificadoAutorizacion());
        anxCompra.setRetImpresa(anxCompraTO.getRetImpreso());
        anxCompra.setRetEntregada(anxCompraTO.getRetEntregado());
        anxCompra.setRetElectronica(anxCompraTO.getRetElectronica());
        return anxCompra;
    }

    public static anexos.entity.AnxCompraDetalle convertirAnxCompraDetalleTO_AnxCompraDetalle(anexos.TO.AnxCompraDetalleTO anxCompraDetalleTO) {
        anexos.entity.AnxCompraDetalle anxCompraDetalle = new anexos.entity.AnxCompraDetalle();
        anxCompraDetalle.setDetBase0(anxCompraDetalleTO.getDetBase0());
        anxCompraDetalle.setDetBaseimponible(anxCompraDetalleTO.getDetBaseImponible());
        anxCompraDetalle.setDetBasenoobjetoiva(anxCompraDetalleTO.getDetBaseNoObjetoIva());
        anxCompraDetalle.setDetOrden(anxCompraDetalleTO.getDetOrden());
        anxCompraDetalle.setDetPorcentaje(anxCompraDetalleTO.getDetPorcentaje());
        anxCompraDetalle.setDetSecuencial(anxCompraDetalleTO.getDetSecuencial());
        anxCompraDetalle.setDetValorretenido(anxCompraDetalleTO.getDetValorRetenido());
        return anxCompraDetalle;
    }

    public static anexos.entity.AnxCompraDividendo convertirAnxCompraDetalleTO_AnxCompraDividendo(anexos.TO.AnxCompraDetalleTO anxCompraDetalleTO) {
        anexos.entity.AnxCompraDividendo anxCompraDividendo = new anexos.entity.AnxCompraDividendo();
        anxCompraDividendo.setDivSecuencial(anxCompraDetalleTO.getDivSecuencial());
        /*
         * anxCompraDividendo.setAnxCompra(new anexos.entity.AnxCompra());
         * anxCompraDividendo.getAnxCompra().setAnxCompraPK(new
         * anexos.entity.AnxCompraPK( anxCompraDetalleTO.getCompEmpresa(),
         * anxCompraDetalleTO.getCompPeriodo(),
         * anxCompraDetalleTO.getCompMotivo(),
         * anxCompraDetalleTO.getCompNumero()));
         * anxCompraDividendo.setConCodigo(new
         * anexos.entity.AnxConcepto(anxCompraDetalleTO.getDetConcepto()));
         */
        anxCompraDividendo.setDivAnioUtilidades(anxCompraDetalleTO.getDivAnioUtilidades());
        anxCompraDividendo.setDivIrAsociado(anxCompraDetalleTO.getDivIrAsociado());
        anxCompraDividendo.setDivFechaPago(validaciones.Validacion.fecha(anxCompraDetalleTO.getDivFechaPago(), "dd-MM-yyyy"));
        return anxCompraDividendo;
    }

    public static anexos.entity.AnxCompraReembolso convertirAnxCompraReembolsoTO_AnxCompraReembolso(anexos.TO.AnxCompraReembolsoTO anxCompraReembolsoTO) {
        anexos.entity.AnxCompraReembolso anxCompraReembolso = new anexos.entity.AnxCompraReembolso(
                anxCompraReembolsoTO.getReembSecuencial(),
                anxCompraReembolsoTO.getProvEmpresa(),
                anxCompraReembolsoTO.getProvCodigo(),
                anxCompraReembolsoTO.getReembDocumentoTipo(),
                anxCompraReembolsoTO.getReembDocumentoNumero(),
                validaciones.Validacion.fecha(anxCompraReembolsoTO.getReembFechaemision(), "dd-MM-yyyy"),
                anxCompraReembolsoTO.getReembAutorizacion(),
                anxCompraReembolsoTO.getReembBaseimponible(),
                anxCompraReembolsoTO.getReembBaseimpgrav(),
                anxCompraReembolsoTO.getReembBasenograiva(),
                anxCompraReembolsoTO.getReembMontoice(),
                anxCompraReembolsoTO.getReembMontoiva(),
                anxCompraReembolsoTO.getProvEmpresa(),
                anxCompraReembolsoTO.getProvCodigo());
        anxCompraReembolso.setAnxCompra(
                new AnxCompra(new anexos.entity.AnxCompraPK(anxCompraReembolsoTO.getCompEmpresa(), anxCompraReembolsoTO.getCompPeriodo(), anxCompraReembolsoTO.getCompMotivo(), anxCompraReembolsoTO.getCompNumero())));
        return anxCompraReembolso;
    }
//    public static anexos.TO.AnxCompraDetalleTO convertirAnxCompraDetalle_AnxCompraDetalleTO(anexos.entity.AnxCompraDetalle anxCompraDetalle) {
//        anexos.TO.AnxCompraDetalleTO anxCompraDetalleTO = new anexos.TO.AnxCompraDetalleTO();
//        anxCompraDetalleTO.setDetSecuencial(anxCompraDetalle.getDetSecuencial());
//        anxCompraDetalleTO.setDetConcepto(anxCompraDetalle.getDetConcepto().getConCodigo());
//        anxCompraDetalleTO.setDetBase0(anxCompraDetalle.getDetBase0());
//        anxCompraDetalleTO.setDetBaseImponible(anxCompraDetalle.getDetBaseimponible());
//        anxCompraDetalleTO.setDetBaseNoObjetoIva(anxCompraDetalle.getDetBasenoobjetoiva());
//        anxCompraDetalleTO.setDetPorcentaje(anxCompraDetalle.getDetPorcentaje());
//        anxCompraDetalleTO.setDetValorRetenido(anxCompraDetalle.getDetValorretenido());
//        anxCompraDetalleTO.setDetOrden(anxCompraDetalle.getDetOrden());
//        anxCompraDetalleTO.setCompEmpresa(anxCompraDetalle.getAnxCompra().getAnxCompraPK().getCompEmpresa());
//        anxCompraDetalleTO.setCompPeriodo(anxCompraDetalle.getAnxCompra().getAnxCompraPK().getCompPeriodo());
//        anxCompraDetalleTO.setCompMotivo(anxCompraDetalle.getAnxCompra().getAnxCompraPK().getCompMotivo());
//        anxCompraDetalleTO.setCompNumero(anxCompraDetalle.getAnxCompra().getAnxCompraPK().getCompNumero());
//        
//        return anxCompraDetalleTO;
//    }

    public static java.util.List<anexos.TO.AnxCompraDetalleTO> convertirAnxCompraDetalle_AnxCompraDetalleTO(java.util.List<anexos.entity.AnxCompraDetalle> datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            Integer dato1;
            try {
                dato1 = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            java.math.BigDecimal dato3;
            try {
                dato3 = new java.math.BigDecimal(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            Integer dato8;
            try {
                dato8 = Integer.parseInt(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            Integer dato13;
            try {
                dato13 = Integer.parseInt(array[12].toString());
            } catch (Exception e) {
                dato13 = null;
            }
            String dato14;
            try {
                dato14 = array[13].toString();
            } catch (Exception e) {
                dato14 = null;
            }
            java.math.BigDecimal dato15;
            try {
                dato15 = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }
            String dato16;
            try {
                dato16 = array[15].toString();
            } catch (Exception e) {
                dato16 = null;
            }
            lista.add(new anexos.TO.AnxCompraDetalleTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12,
                    dato13, dato14, dato15, dato16));
        }
        return lista;
    }

    public static anexos.TO.AnxCompraTO convertirAnxCompra_AnxCompraTO(anexos.entity.AnxCompra anxCompra) {
        if (anxCompra != null) {
            anexos.TO.AnxCompraTO anxCompraTO = new anexos.TO.AnxCompraTO();
            anxCompraTO.setEmpCodigo(anxCompra.getAnxCompraPK().getCompEmpresa());
            anxCompraTO.setPerCodigo(anxCompra.getAnxCompraPK().getCompPeriodo());
            anxCompraTO.setMotCodigo(anxCompra.getAnxCompraPK().getCompMotivo());
            anxCompraTO.setCompNumero(anxCompra.getAnxCompraPK().getCompNumero());
            //        anxCompra.setAnxCompraPK(new anexos.entity.AnxCompraPK(anxCompraTO.getEmpCodigo(),
            //                anxCompraTO.getPerCodigo(), anxCompraTO.getMotCodigo(), anxCompraTO.getComppNumero()));
            anxCompraTO.setCompSustentotributario(anxCompra.getCompSustentotributario().getSusCodigo());
            anxCompraTO.setCompAutorizacion(anxCompra.getCompAutorizacion());
            anxCompraTO.setCompCaduca(validaciones.Validacion.fecha(anxCompra.getCompFechaCaduca(), "dd-MM-yyyy"));
            anxCompraTO.setCompEmision(anxCompra.getCompFechaEmision() != null ? validaciones.Validacion.fecha(anxCompra.getCompFechaEmision(), "dd-MM-yyyy") : null);
            anxCompraTO.setCompBase0(anxCompra.getCompBase0());
            anxCompraTO.setCompBaseimponible(anxCompra.getCompBaseimponible());
            anxCompraTO.setCompBasenoobjetoiva(anxCompra.getCompBasenoobjetoiva());
            anxCompraTO.setCompMontoice(anxCompra.getCompMontoice());
            anxCompraTO.setCompMontoiva(anxCompra.getCompMontoiva());
            anxCompraTO.setCompBaseivabienes(anxCompra.getCompBaseivabienes());
            anxCompraTO.setCompBaseivaservicios(anxCompra.getCompBaseivaservicios());
            anxCompraTO.setCompBaseivaserviciosprofesionales(anxCompra.getCompBaseivaserviciosprofesionales());
            anxCompraTO.setCompPorcentajebienes(anxCompra.getCompPorcentajebienes());
            anxCompraTO.setCompPorcentajeservicios(anxCompra.getCompPorcentajeservicios());
            anxCompraTO.setCompPorcentajeserviciosprofesionales(anxCompra.getCompPorcentajeserviciosprofesionales());
            anxCompraTO.setCompValorbienes(anxCompra.getCompValorbienes());
            anxCompraTO.setCompValorservicios(anxCompra.getCompValorservicios());
            anxCompraTO.setCompValorserviciosprofesionales(anxCompra.getCompValorserviciosprofesionales());
            anxCompraTO.setCompRetencionNumero(anxCompra.getCompRetencionNumero());
            anxCompraTO.setCompRetencionAutorizacion(anxCompra.getCompRetencionAutorizacion());

            //ava.text.DateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");
            //        return formato.format(fecha);
            //anxCompraTO.setCompRetencionFechaEmision(formato.format(anxCompra.getCompRetencionFechaEmision()));
            anxCompraTO.setCompRetencionFechaEmision(validaciones.Validacion.fecha(anxCompra.getCompRetencionFechaEmision(), "yyyy-MM-dd"));
            anxCompraTO.setCompModificadoDocumentoTipo(anxCompra.getCompModificadoDocumentoTipo());
            anxCompraTO.setCompModificadoDocumentoNumero(anxCompra.getCompModificadoDocumentoNumero());
            anxCompraTO.setCompModificadoAutorizacion(anxCompra.getCompModificadoAutorizacion());
            anxCompraTO.setRetImpreso(anxCompra.getRetImpresa());
            anxCompraTO.setRetEntregado(anxCompra.getRetEntregada());
            anxCompraTO.setRetElectronica(anxCompra.getRetElectronica());

            //        anxCompra.setUsrEmpresa(anxCompraTO.getEmpCodigo());
//            anxCompraTO.setUsrInsertaCompras(anxCompra.getUsrCodigo());
//            anxCompraTO.setUsrFechaInsertaCompras(validaciones.Validacion.fecha(anxCompra.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
            return anxCompraTO;
        } else {
            return null;
        }
    }

    public static anexos.entity.AnxVenta convertirAnxVentaTO_AnxVenta(anexos.TO.AnxVentaTO anxVentaTO) {
        anexos.entity.AnxVenta anxVenta = new anexos.entity.AnxVenta();
        anxVenta.setAnxVentaPK(new anexos.entity.AnxVentaPK(anxVentaTO.getVenEmpresa(),
                anxVentaTO.getVenPeriodo(), anxVentaTO.getVenMotivo(), anxVentaTO.getVenNumero()));
        anxVenta.setVenRetencionnumero(anxVentaTO.getVenRetencionNumero());
        anxVenta.setVenRetencionautorizacion(anxVentaTO.getVenRetencionAutorizacion());
        anxVenta.setVenRetencionfechaemision(validaciones.Validacion.fecha(anxVentaTO.getVenRetencionFechaEmision(), "yyyy-MM-dd"));
        anxVenta.setVenBase0(anxVentaTO.getVenBase0());
        anxVenta.setVenBaseimponible(anxVentaTO.getVenBaseImponible());
        anxVenta.setVenBasenoobjetoiva(anxVentaTO.getVenBaseNoObjetoIva());
        anxVenta.setVenMontoiva(anxVentaTO.getVenMontoIva());
        anxVenta.setVenValorretenidoiva(anxVentaTO.getVenValorRetenidoIva());
        anxVenta.setVenValorretenidorenta(anxVentaTO.getVenValorRetenidoRenta());
        anxVenta.setUsrEmpresa(anxVentaTO.getUsrEmpresa());
        anxVenta.setUsrCodigo(anxVentaTO.getUsrCodigo());
        anxVenta.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(anxVentaTO.getUsrFechaInserta()));
        return anxVenta;
    }

    public static anexos.TO.AnxVentaTO convertirAnxVenta_AnxVentaTO(anexos.entity.AnxVenta anxVenta) {
        if (anxVenta != null) {
            anexos.TO.AnxVentaTO anxVentaTO = new anexos.TO.AnxVentaTO();
            anxVentaTO.setVenEmpresa(anxVenta.getAnxVentaPK().getVenEmpresa());
            anxVentaTO.setVenPeriodo(anxVenta.getAnxVentaPK().getVenPeriodo());
            anxVentaTO.setVenMotivo(anxVenta.getAnxVentaPK().getVenMotivo());
            anxVentaTO.setVenNumero(anxVenta.getAnxVentaPK().getVenNumero());
            //        anxCompra.setAnxCompraPK(new anexos.entity.AnxCompraPK(anxCompraTO.getEmpCodigo(),
            //                anxCompraTO.getPerCodigo(), anxCompraTO.getMotCodigo(), anxCompraTO.getCompNumero()));
            anxVentaTO.setVenRetencionNumero(anxVenta.getVenRetencionnumero());
            anxVentaTO.setVenRetencionAutorizacion(anxVenta.getVenRetencionautorizacion());
//            anxVentaTO.setVenRetencionFechaEmision(validaciones.Validacion.fechaYyMmDdSinHora(anxVenta.getVenRetencionfechaemision()));
            anxVentaTO.setVenBase0(anxVenta.getVenBase0());
            anxVentaTO.setVenBaseImponible(anxVenta.getVenBaseimponible());
            anxVentaTO.setVenBaseNoObjetoIva(anxVenta.getVenBasenoobjetoiva());
            anxVentaTO.setVenMontoIva(anxVenta.getVenMontoiva());
            anxVentaTO.setVenValorRetenidoIva(anxVenta.getVenValorretenidoiva());
            anxVentaTO.setVenValorRetenidoRenta(anxVenta.getVenValorretenidorenta());

            //java.text.DateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");
            //        return formato.format(fecha);
            //anxVentaTO.setVenRetencionFechaEmision(formato.format(anxVenta.getVenRetencionfechaemision()));
            anxVentaTO.setVenRetencionFechaEmision(validaciones.Validacion.fecha(anxVenta.getVenRetencionfechaemision(), "yyyy-MM-dd"));
            //        anxCompra.setUsrEmpresa(anxCompraTO.getEmpCodigo());
            anxVentaTO.setUsrEmpresa(anxVenta.getUsrEmpresa());
            anxVentaTO.setUsrCodigo(anxVenta.getUsrCodigo());
            anxVentaTO.setUsrFechaInserta(validaciones.Validacion.fecha(anxVenta.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
            return anxVentaTO;
        } else {
            return null;
        }
    }

    public static anexos.entity.AnxNumeracion convertirAnxNumeracionTO_AnxAnxNumeracion(anexos.TO.AnxNumeracionTO anxNumeracionTO) {
        anexos.entity.AnxNumeracion anxNumeracion = new anexos.entity.AnxNumeracion();
        anxNumeracion.setNumSecuencial(anxNumeracionTO.getNumSecuencial());
        anxNumeracion.setNumEmpresa(anxNumeracionTO.getNumEmpresa());
        anxNumeracion.setNumComprobante(anxNumeracionTO.getNumComprobante());
        anxNumeracion.setNumDesde(anxNumeracionTO.getNumDesde());
        anxNumeracion.setNumHasta(anxNumeracionTO.getNumHasta());
        anxNumeracion.setNumAutorizacion(anxNumeracionTO.getNumAutorizacion());
        anxNumeracion.setNumCaduca(anxNumeracionTO.getNumCaduca());
        anxNumeracion.setNumLineas(anxNumeracionTO.getNumLineas());
        anxNumeracion.setNumFormatoPos(anxNumeracionTO.isNumFormatoPos());
        anxNumeracion.setNumDocumentoElectronico(anxNumeracionTO.isNumDocumentoElectronico());
        anxNumeracion.setNumAmbienteProduccion(anxNumeracionTO.isNumAmbienteProduccion());
        anxNumeracion.setNumMostrarDialogoImpresion(anxNumeracionTO.isNumMostrarDialogoImpresion());
        anxNumeracion.setSecEmpresa(anxNumeracionTO.getNumEmpresa());
        anxNumeracion.setSecCodigo(anxNumeracionTO.getSecCodigo());
        anxNumeracion.setUsrEmpresa(anxNumeracionTO.getNumEmpresa());
        anxNumeracion.setUsrCodigo(anxNumeracionTO.getUsrCodigo());
        anxNumeracion.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(anxNumeracionTO.getUsrFechaInserta()));
        return anxNumeracion;
    }

    public static anexos.TO.AnxNumeracionTO convertirAnxNumeracion_AnxAnxNumeracionTO(anexos.entity.AnxNumeracion anxNumeracion) {
        anexos.TO.AnxNumeracionTO anxNumeracionTO = new anexos.TO.AnxNumeracionTO();

        anxNumeracionTO.setNumSecuencial(anxNumeracion.getNumSecuencial());
        anxNumeracionTO.setNumEmpresa(anxNumeracion.getNumEmpresa());
        anxNumeracionTO.setNumComprobante(anxNumeracion.getNumComprobante());
        anxNumeracionTO.setNumDesde(anxNumeracion.getNumDesde());
        anxNumeracionTO.setNumHasta(anxNumeracion.getNumHasta());
        anxNumeracionTO.setNumAutorizacion(anxNumeracion.getNumAutorizacion());
        anxNumeracionTO.setNumCaduca(anxNumeracion.getNumCaduca());
        anxNumeracionTO.setNumLineas(anxNumeracion.getNumLineas());
        anxNumeracionTO.setNumFormatoPos(anxNumeracion.getNumFormatoPos());
        anxNumeracionTO.setNumDocumentoElectronico(anxNumeracion.getNumDocumentoElectronico());
        anxNumeracionTO.setNumAmbienteProduccion(anxNumeracion.getNumAmbienteProduccion());
        anxNumeracionTO.setNumMostrarDialogoImpresion(anxNumeracion.getNumMostrarDialogoImpresion());
        //anxNumeracionTO.setNumActual(anxNumeracion.getNumActual());
        anxNumeracionTO.setSecCodigo(anxNumeracion.getSecCodigo());
        anxNumeracionTO.setUsrCodigo(anxNumeracion.getUsrCodigo());
        anxNumeracionTO.setUsrFechaInserta(validaciones.Validacion.fecha(anxNumeracion.getUsrFechaInserta(), "yyyy-MM-dd"));
        return anxNumeracionTO;
    }

    // <editor-fold defaultstate="collapsed" desc="CONVERSIONES TIPO IDENTIFICACION">
    public static anexos.entity.AnxTipoidentificacion convertirAnxTipoIdentificacionTO_AnxTipoIdentificacion(anexos.TO.AnxTipoIdentificacionTO anxTipoIdentificacionTO) {
        anexos.entity.AnxTipoidentificacion anxTipoidentificacion = new anexos.entity.AnxTipoidentificacion();
        anxTipoidentificacion.setTiCodigo(anxTipoIdentificacionTO.getTiCodigo());
        anxTipoidentificacion.setTiDetalle(anxTipoIdentificacionTO.getTiDetalle());
        return anxTipoidentificacion;
    }

    public static List<AnxEstablecimientoComboTO> convertirListaAnxEstablecimientoCombo_ListaAnxEstablecimientoComboTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            lista.add(new anexos.TO.AnxEstablecimientoComboTO(dato1));
        }
        return lista;
    }

    public static List<anexos.TO.AnxSustentoComboTO> convertirListaAnxSustentoCombo_ListaAnxSustentoComboTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            lista.add(new anexos.TO.AnxSustentoComboTO(dato1, dato2));
        }
        return lista;
    }

    public static List<anexos.TO.AnxConceptoComboTO> convertirListaAnxConceptoCombo_ListaAnxConceptoComboTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            java.math.BigDecimal dato3;
            try {
                dato3 = new java.math.BigDecimal(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            Character dato4;
            try {
                dato4 = array[3].toString().charAt(0);
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new anexos.TO.AnxConceptoComboTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }// </editor-fold>

    public static List<anexos.TO.AnxTipoIdentificacionTO> convertirListaAnxTipoIdentificacion_ListaAnxTipoIdentificacionTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            Character dato1;
            try {
                dato1 = array[0].toString().charAt(0);
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            lista.add(new anexos.TO.AnxTipoIdentificacionTO(dato1, dato2));
        }
        return lista;
    }// </editor-fold>

    public static List<anexos.TO.AnxCompraReembolsoTO> convertirListaObject_ListaAnxCompraReembolsoTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            Integer dato1;
            try {
                dato1 = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            java.math.BigDecimal dato9;
            try {
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            java.math.BigDecimal dato10;
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            String dato14;
            try {
                dato14 = array[13].toString();
            } catch (Exception e) {
                dato14 = null;
            }
            String dato15;
            try {
                dato15 = array[14].toString();
            } catch (Exception e) {
                dato15 = null;
            }
            String dato16;
            try {
                dato16 = array[15].toString();
            } catch (Exception e) {
                dato16 = null;
            }
            String dato17;
            try {
                dato17 = array[16].toString();
            } catch (Exception e) {
                dato17 = null;
            }
            String dato18;
            try {
                dato18 = array[17].toString();
            } catch (Exception e) {
                dato18 = null;
            }
            String dato19;
            try {
                dato19 = array[18].toString();
            } catch (Exception e) {
                dato19 = null;
            }
            anexos.TO.AnxCompraReembolsoTO aux = new anexos.TO.AnxCompraReembolsoTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16);
            aux.setAuxDocTipo_Abreviatura(dato17);
            aux.setAuxProvNombre(dato18);
            aux.setAuxProvRUC(dato19);
            lista.add(aux);
        }
        return lista;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONVERSIONES COMPROBANTE">
    public static anexos.entity.AnxTipocomprobante convertirAnxTipoComprobanteTO_AnxTipoComprobante(anexos.TO.AnxTipoComprobanteTO anxTipoComprobanteTO) {
        anexos.entity.AnxTipocomprobante anxTipocomprobante = new anexos.entity.AnxTipocomprobante();
        anxTipocomprobante.setTcCodigo(anxTipoComprobanteTO.getTcCodigo());
        anxTipocomprobante.setTcDescripcion(anxTipoComprobanteTO.getTcDescripcion());
        anxTipocomprobante.setTcTransaccion(anxTipoComprobanteTO.getTcTransaccion());
        anxTipocomprobante.setTcSustento(anxTipoComprobanteTO.getTcSustento());
        anxTipocomprobante.setTcAbreviatura(anxTipoComprobanteTO.getTcAbreviatura());
        return anxTipocomprobante;
    }

    public static List<anexos.TO.AnxTipoComprobanteComboTO> convertirListaAnxTipoComprobanteCombo_ListaAnxTipoComprobanteComboTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            lista.add(new anexos.TO.AnxTipoComprobanteComboTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static List<anexos.TO.AnxTipoComprobanteTO> convertirListaAnxTipoComprobante_ListaAnxTipoComprobanteTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new anexos.TO.AnxTipoComprobanteTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }// </editor-fold>

    public static java.util.List<anexos.TO.AnxListaRetencionesTO> convertirListaRetenciones_ListaRetencionesTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            java.math.BigDecimal dato13;
            try {
                dato13 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                dato13 = null;
            }
            java.math.BigDecimal dato14;
            try {
                dato14 = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                dato14 = null;
            }
            java.math.BigDecimal dato15;
            try {
                dato15 = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }
            java.math.BigDecimal dato16;
            try {
                dato16 = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                dato16 = null;
            }
            java.math.BigDecimal dato17;
            try {
                dato17 = new java.math.BigDecimal(array[16].toString());
            } catch (Exception e) {
                dato17 = null;
            }
            String dato18;
            try {
                dato18 = array[17].toString();
            } catch (Exception e) {
                dato18 = null;
            }
            String dato19;
            try {
                dato19 = array[18].toString();
            } catch (Exception e) {
                dato19 = null;
            }
            String dato20;
            try {
                dato20 = array[19].toString();
            } catch (Exception e) {
                dato20 = null;
            }
            java.math.BigDecimal dato21;
            try {
                dato21 = new java.math.BigDecimal(array[20].toString());
            } catch (Exception e) {
                dato21 = null;
            }
            //////
            java.math.BigDecimal dato22;
            try {
                dato22 = new java.math.BigDecimal(array[21].toString());
            } catch (Exception e) {
                dato22 = null;
            }
            java.math.BigDecimal dato23;
            try {
                dato23 = new java.math.BigDecimal(array[22].toString());
            } catch (Exception e) {
                dato23 = null;
            }
            java.math.BigDecimal dato24;
            try {
                dato24 = new java.math.BigDecimal(array[23].toString());
            } catch (Exception e) {
                dato24 = null;
            }
            java.math.BigDecimal dato25;
            try {
                dato25 = new java.math.BigDecimal(array[24].toString());
            } catch (Exception e) {
                dato25 = null;
            }
            java.math.BigDecimal dato26;
            try {
                dato26 = new java.math.BigDecimal(array[25].toString());
            } catch (Exception e) {
                dato26 = null;
            }
            java.math.BigDecimal dato27;
            try {
                dato27 = new java.math.BigDecimal(array[26].toString());
            } catch (Exception e) {
                dato27 = null;
            }
            java.math.BigDecimal dato28;
            try {
                dato28 = new java.math.BigDecimal(array[27].toString());
            } catch (Exception e) {
                dato28 = null;
            }
            String dato29;
            try {
                dato29 = array[28].toString();
            } catch (Exception e) {
                dato29 = null;
            }
            String dato30;
            try {
                dato30 = array[29].toString();
            } catch (Exception e) {
                dato30 = null;
            }
            String dato31;
            try {
                dato31 = array[30].toString();
            } catch (Exception e) {
                dato31 = null;
            }
            String dato32;
            try {
                dato32 = array[31].toString();
            } catch (Exception e) {
                dato32 = null;
            }
            String dato33;
            try {
                dato33 = array[32].toString();
            } catch (Exception e) {
                dato33 = null;
            }

            lista.add(new anexos.TO.AnxListaRetencionesTO(
                    dato1,
                    dato2,
                    dato3,
                    dato4,
                    dato5,
                    dato6,
                    dato7,
                    dato8,
                    dato9,
                    dato10,
                    dato11,
                    dato12,
                    dato13,
                    dato14,
                    dato15,
                    dato16,
                    dato17,
                    dato18,
                    dato19,
                    dato20,
                    dato21,
                    dato22,
                    dato23,
                    dato24,
                    dato25,
                    dato26,
                    dato27,
                    dato28,
                    dato29,
                    dato30,
                    dato31,
                    dato32,
                    dato33));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxListaRetencionesPendientesTO> convertirListaRetencionesPendientesAutorizacion_ListaRetencionesPendientesAutorizacionTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String ret_sustentotributario;
            try {
                ret_sustentotributario = array[0].toString();
            } catch (Exception e) {
                ret_sustentotributario = null;
            }
            String ret_proveedor_id_tipo;
            try {
                ret_proveedor_id_tipo = array[1].toString();
            } catch (Exception e) {
                ret_proveedor_id_tipo = null;
            }
            String ret_proveedor_id_numero;
            try {
                ret_proveedor_id_numero = array[2].toString();
            } catch (Exception e) {
                ret_proveedor_id_numero = null;
            }
            String ret_proveedor_nombre;
            try {
                ret_proveedor_nombre = array[3].toString();
            } catch (Exception e) {
                ret_proveedor_nombre = null;
            }
            String ret_proveedor_direccion;
            try {
                ret_proveedor_direccion = array[4].toString();
            } catch (Exception e) {
                ret_proveedor_direccion = null;
            }
            String ret_proveedor_ciudad;
            try {
                ret_proveedor_ciudad = array[5].toString();
            } catch (Exception e) {
                ret_proveedor_ciudad = null;
            }
            String ret_proveedor_relacionado;
            try {
                ret_proveedor_relacionado = array[6].toString();
            } catch (Exception e) {
                ret_proveedor_relacionado = null;
            }
            String ret_documento_tipo;
            try {
                ret_documento_tipo = array[7].toString();
            } catch (Exception e) {
                ret_documento_tipo = null;
            }
            String ret_documento_nombre;
            try {
                ret_documento_nombre = array[8].toString();
            } catch (Exception e) {
                ret_documento_nombre = null;
            }
            String ret_documento_autorizacion;
            try {
                ret_documento_autorizacion = array[9].toString();
            } catch (Exception e) {
                ret_documento_autorizacion = null;
            }
            String ret_documento_numero;
            try {
                ret_documento_numero = array[10].toString();
            } catch (Exception e) {
                ret_documento_numero = null;
            }
            String ret_comprafecha;
            try {
                ret_comprafecha = array[11].toString();
            } catch (Exception e) {
                ret_comprafecha = null;
            }
            java.math.BigDecimal ret_comprabase0;
            try {
                ret_comprabase0 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                ret_comprabase0 = null;
            }

            java.math.BigDecimal ret_comprabaseimponible;
            try {
                ret_comprabaseimponible = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                ret_comprabaseimponible = null;
            }
            java.math.BigDecimal ret_comprabaseexenta;
            try {
                ret_comprabaseexenta = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                ret_comprabaseexenta = null;
            }
            java.math.BigDecimal ret_compramontoice;
            try {
                ret_compramontoice = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                ret_compramontoice = null;
            }
            java.math.BigDecimal ret_compramontoiva;
            try {
                ret_compramontoiva = new java.math.BigDecimal(array[16].toString());
            } catch (Exception e) {
                ret_compramontoiva = null;
            }
            String ret_retencionautorizacion;
            try {
                ret_retencionautorizacion = array[17].toString();
            } catch (Exception e) {
                ret_retencionautorizacion = null;
            }
            String ret_retencionnumero;
            try {
                ret_retencionnumero = array[18].toString();
            } catch (Exception e) {
                ret_retencionnumero = null;
            }
            String ret_retencionfecha;
            try {
                ret_retencionfecha = array[19].toString();
            } catch (Exception e) {
                ret_retencionfecha = null;
            }
            java.math.BigDecimal ret_valorretenidoir;
            try {
                ret_valorretenidoir = new java.math.BigDecimal(array[20].toString());
            } catch (Exception e) {
                ret_valorretenidoir = null;
            }
            //////
            java.math.BigDecimal ret_valorbienes10;
            try {
                ret_valorbienes10 = new java.math.BigDecimal(array[21].toString());
            } catch (Exception e) {
                ret_valorbienes10 = null;
            }
            java.math.BigDecimal ret_valorservicios20;
            try {
                ret_valorservicios20 = new java.math.BigDecimal(array[22].toString());
            } catch (Exception e) {
                ret_valorservicios20 = null;
            }
            java.math.BigDecimal ret_valorbienes;
            try {
                ret_valorbienes = new java.math.BigDecimal(array[23].toString());
            } catch (Exception e) {
                ret_valorbienes = null;
            }
            java.math.BigDecimal ret_valorservicios;
            try {
                ret_valorservicios = new java.math.BigDecimal(array[24].toString());
            } catch (Exception e) {
                ret_valorservicios = null;
            }
            java.math.BigDecimal ret_valorserviciosprofesionales;
            try {
                ret_valorserviciosprofesionales = new java.math.BigDecimal(array[25].toString());
            } catch (Exception e) {
                ret_valorserviciosprofesionales = null;
            }
            java.math.BigDecimal ret_valorretenidoiva;
            try {
                ret_valorretenidoiva = new java.math.BigDecimal(array[26].toString());
            } catch (Exception e) {
                ret_valorretenidoiva = null;
            }
            java.math.BigDecimal ret_totalretenido;
            try {
                ret_totalretenido = new java.math.BigDecimal(array[27].toString());
            } catch (Exception e) {
                ret_totalretenido = null;
            }
            String ret_modificado_documento_tipo;
            try {
                ret_modificado_documento_tipo = array[28].toString();
            } catch (Exception e) {
                ret_modificado_documento_tipo = null;
            }
            String ret_modificado_documento_numero;
            try {
                ret_modificado_documento_numero = array[29].toString();
            } catch (Exception e) {
                ret_modificado_documento_numero = null;
            }
            String ret_modificado_autorizacion;
            try {
                ret_modificado_autorizacion = array[30].toString();
            } catch (Exception e) {
                ret_modificado_autorizacion = null;
            }
            String ret_llavecompra;
            try {
                ret_llavecompra = array[31].toString();
            } catch (Exception e) {
                ret_llavecompra = null;
            }
            String ret_llavecontable;
            try {
                ret_llavecontable = array[32].toString();
            } catch (Exception e) {
                ret_llavecontable = null;
            }

            lista.add(new anexos.TO.AnxListaRetencionesPendientesTO(
                    ret_sustentotributario,
                    ret_proveedor_id_tipo,
                    ret_proveedor_id_numero,
                    ret_proveedor_nombre,
                    ret_proveedor_direccion,
                    ret_proveedor_ciudad,
                    ret_proveedor_relacionado,
                    ret_documento_tipo,
                    ret_documento_nombre,
                    ret_documento_autorizacion,
                    ret_documento_numero,
                    ret_comprafecha,
                    ret_comprabase0,
                    ret_comprabaseimponible,
                    ret_comprabaseexenta,
                    ret_compramontoice,
                    ret_compramontoiva,
                    ret_retencionautorizacion,
                    ret_retencionnumero,
                    ret_retencionfecha,
                    ret_valorretenidoir,
                    ret_valorbienes10,
                    ret_valorservicios20,
                    ret_valorbienes,
                    ret_valorservicios,
                    ret_valorserviciosprofesionales,
                    ret_valorretenidoiva,
                    ret_totalretenido,
                    ret_modificado_documento_tipo,
                    ret_modificado_documento_numero,
                    ret_modificado_autorizacion,
                    ret_llavecompra,
                    ret_llavecontable));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxListaRetencionesRentaTO> convertirListaRetenciones_ListaRetencionesRentaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();

            String ret_sustentotributario;
            try {
                ret_sustentotributario = array[0].toString();
            } catch (Exception e) {
                ret_sustentotributario = null;
            }
            String ret_concepto;
            try {
                ret_concepto = array[1].toString();
            } catch (Exception e) {
                ret_concepto = null;
            }
            String ret_proveedor_id;
            try {
                ret_proveedor_id = array[2].toString();
            } catch (Exception e) {
                ret_proveedor_id = null;
            }
            String ret_proveedor_nombre;
            try {
                ret_proveedor_nombre = array[3].toString();
            } catch (Exception e) {
                ret_proveedor_nombre = null;
            }
            String ret_documento_nombre;
            try {
                ret_documento_nombre = array[4].toString();
            } catch (Exception e) {
                ret_documento_nombre = null;
            }

            String ret_documento_autorizacion;
            try {
                ret_documento_autorizacion = array[5].toString();
            } catch (Exception e) {
                ret_documento_autorizacion = null;
            }
            String ret_documento_numero;
            try {
                ret_documento_numero = array[6].toString();
            } catch (Exception e) {
                ret_documento_numero = null;
            }
            String ret_comprafecha;
            try {
                ret_comprafecha = array[7].toString();
            } catch (Exception e) {
                ret_comprafecha = null;
            }
            java.math.BigDecimal ret_comprabase0;
            try {
                ret_comprabase0 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                ret_comprabase0 = null;
            }
            java.math.BigDecimal ret_comprabaseimponible;
            try {
                ret_comprabaseimponible = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                ret_comprabaseimponible = null;
            }

            String ret_retencionautorizacion;
            try {
                ret_retencionautorizacion = array[10].toString();
            } catch (Exception e) {
                ret_retencionautorizacion = null;
            }

            String ret_retencionnumero;
            try {
                ret_retencionnumero = array[11].toString();
            } catch (Exception e) {
                ret_retencionnumero = null;
            }
            String ret_retencionfecha;
            try {
                ret_retencionfecha = array[12].toString();
            } catch (Exception e) {
                ret_retencionfecha = null;
            }

            String ret_valorretenidoir;
            try {
                ret_valorretenidoir = array[13].toString();
            } catch (Exception e) {
                ret_valorretenidoir = null;
            }
            String ret_llavecompra;
            try {
                ret_llavecompra = array[14].toString();
            } catch (Exception e) {
                ret_llavecompra = null;
            }
            String ret_llavecontable;
            try {
                ret_llavecontable = array[15].toString();
            } catch (Exception e) {
                ret_llavecontable = null;
            }

            lista.add(new anexos.TO.AnxListaRetencionesRentaTO(
                    ret_sustentotributario,
                    ret_concepto,
                    ret_proveedor_id,
                    ret_proveedor_nombre,
                    ret_documento_nombre,
                    ret_documento_autorizacion,
                    ret_documento_numero,
                    ret_comprafecha,
                    ret_comprabase0,
                    ret_comprabaseimponible,
                    ret_retencionautorizacion,
                    ret_retencionnumero,
                    ret_retencionfecha,
                    ret_valorretenidoir,
                    ret_llavecompra,
                    ret_llavecontable));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxListaRetencionesFuenteIvaTO> convertirListaRetencionesFuenteIva_ListaRetencionesFuenteIvaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion

        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();

            String ret_sustentotributario;
            try {
                ret_sustentotributario = array[0].toString();
            } catch (Exception e) {
                ret_sustentotributario = null;
            }
            java.math.BigDecimal ret_porcentaje;
            try {
                ret_porcentaje = new java.math.BigDecimal(array[1].toString());
            } catch (Exception e) {
                ret_porcentaje = null;
            }
            String ret_proveedor_id;
            try {
                ret_proveedor_id = array[2].toString();
            } catch (Exception e) {
                ret_proveedor_id = null;
            }
            //////////////
            String ret_proveedor_nombre;
            try {
                ret_proveedor_nombre = array[3].toString();
            } catch (Exception e) {
                ret_proveedor_nombre = null;
            }
            String ret_documento_nombre;
            try {
                ret_documento_nombre = array[4].toString();
            } catch (Exception e) {
                ret_documento_nombre = null;
            }

            String ret_documento_autorizacion;
            try {
                ret_documento_autorizacion = array[5].toString();
            } catch (Exception e) {
                ret_documento_autorizacion = null;
            }
            String ret_documento_numero;
            try {
                ret_documento_numero = array[6].toString();
            } catch (Exception e) {
                ret_documento_numero = null;
            }
            String ret_comprafecha;
            try {
                ret_comprafecha = array[7].toString();
            } catch (Exception e) {
                ret_comprafecha = null;
            }
            java.math.BigDecimal ret_comprabase0;
            try {
                ret_comprabase0 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                ret_comprabase0 = null;
            }
            java.math.BigDecimal ret_comprabaseimponible;
            try {
                ret_comprabaseimponible = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                ret_comprabaseimponible = null;
            }

            String ret_retencionautorizacion;
            try {
                ret_retencionautorizacion = array[10].toString();
            } catch (Exception e) {
                ret_retencionautorizacion = null;
            }

            String ret_retencionnumero;
            try {
                ret_retencionnumero = array[11].toString();
            } catch (Exception e) {
                ret_retencionnumero = null;
            }
            String ret_retencionfecha;
            try {
                ret_retencionfecha = array[12].toString();
            } catch (Exception e) {
                ret_retencionfecha = null;
            }

            java.math.BigDecimal ret_valorretenidoir;
            try {
                ret_valorretenidoir = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                ret_valorretenidoir = null;
            }
            String ret_llavecompra;
            try {
                ret_llavecompra = array[14].toString();
            } catch (Exception e) {
                ret_llavecompra = null;
            }
            String ret_llavecontable;
            try {
                ret_llavecontable = array[15].toString();
            } catch (Exception e) {
                ret_llavecontable = null;
            }

            lista.add(new anexos.TO.AnxListaRetencionesFuenteIvaTO(
                    ret_sustentotributario,
                    ret_porcentaje,
                    ret_proveedor_id,
                    ret_proveedor_nombre,
                    ret_documento_nombre,
                    ret_documento_autorizacion,
                    ret_documento_numero,
                    ret_comprafecha,
                    ret_comprabase0,
                    ret_comprabaseimponible,
                    ret_retencionautorizacion,
                    ret_retencionnumero,
                    ret_retencionfecha,
                    ret_valorretenidoir,
                    ret_llavecompra,
                    ret_llavecontable));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxListaComprobanteAnuladoTO> convertirAnxListaComprobanteAnulado_AnxListaComprobanteAnuladoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            lista.add(new anexos.TO.AnxListaComprobanteAnuladoTO(dato1, dato2,
                    dato3, dato4, dato5, dato6));
        }
        return lista;
    }

    public static java.util.List<String> convertirAnxFunRetencionesHuerfanas_AnxFunRetencionesHuerfanasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }

            lista.add(dato1);
        }
        return lista;
    }

    public static java.util.List<String> convertirfunComprobanteObtenerUltimaNumeracion_FunComprobanteObtenerUltimaNumeracionTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }

            lista.add(dato1);
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxListaRetencionVentaTO> convertirAnxListaRetencionVenta_AnxListaRetencionVentaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            java.math.BigInteger dato4;
            try {
                dato4 = new java.math.BigInteger(array[3].toString());
            } catch (Exception e) {
                dato4 = java.math.BigInteger.ZERO;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            java.math.BigDecimal dato9;
            try {
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            java.math.BigDecimal dato10;
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            lista.add(new anexos.TO.AnxListaRetencionVentaTO(dato1, dato2,
                    dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxListaConsolidadoRetencionesVentasTO> convertirAnxListaConsolidadoRetencionesVentas_AnxListaConsolidadoRetencionesVentasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)



            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String rvc_transaccion;
            try {
                rvc_transaccion = array[0].toString();
            } catch (Exception e) {
                rvc_transaccion = null;
            }
            String rvc_identificacion;
            try {
                rvc_identificacion = array[1].toString();
            } catch (Exception e) {
                rvc_identificacion = null;
            }

            String rvc_relacionado;
            try {
                rvc_relacionado = array[2].toString();
            } catch (Exception e) {
                rvc_relacionado = null;
            }

            String rvc_comprobantetipo;
            try {
                rvc_comprobantetipo = array[3].toString();
            } catch (Exception e) {
                rvc_comprobantetipo = null;
            }
            Integer rvc_numeroretenciones;
            try {
                rvc_numeroretenciones = Integer.parseInt(array[4].toString());
            } catch (Exception e) {
                rvc_numeroretenciones = null;
            }
            java.math.BigDecimal rvc_basenoobjetoiva;
            try {
                rvc_basenoobjetoiva = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                rvc_basenoobjetoiva = null;
            }
            java.math.BigDecimal rvc_base0;
            try {
                rvc_base0 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                rvc_base0 = null;
            }
            java.math.BigDecimal ven_baseimponible;
            try {
                ven_baseimponible = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                ven_baseimponible = null;
            }
            java.math.BigDecimal ven_montoiva;
            try {
                ven_montoiva = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                ven_montoiva = null;
            }
            java.math.BigDecimal ven_montoice;
            try {
                ven_montoice = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                ven_montoice = null;
            }
            java.math.BigDecimal ven_valorretenidoiva;
            try {
                ven_valorretenidoiva = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                ven_valorretenidoiva = null;
            }
            java.math.BigDecimal ven_valorretenidorenta;
            try {
                ven_valorretenidorenta = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                ven_valorretenidorenta = null;
            }
            lista.add(new anexos.TO.AnxListaConsolidadoRetencionesVentasTO(
                    rvc_transaccion,
                    rvc_identificacion,
                    rvc_relacionado,
                    rvc_comprobantetipo,
                    rvc_numeroretenciones,
                    rvc_basenoobjetoiva,
                    rvc_base0,
                    ven_baseimponible,
                    ven_montoiva,
                    ven_montoice,
                    ven_valorretenidoiva,
                    ven_valorretenidorenta));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxListaEstablecimientoRetencionesVentasTO> convertirAnxListaEstablecimientoRetencionesVentas_AnxListaEstablecimientoRetencionesVentasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }

            java.math.BigDecimal dato2;
            try {
                dato2 = new java.math.BigDecimal(array[1].toString());
            } catch (Exception e) {
                dato2 = null;
            }
            lista.add(new anexos.TO.AnxListaEstablecimientoRetencionesVentasTO(dato1, dato2));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxListadoRetencionesVentasTO> convertirAnxListadoRetencionesVentas_AnxListadoRetencionesVentasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            java.math.BigDecimal dato9;
            try {
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            java.math.BigDecimal dato10;
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            java.math.BigDecimal dato11;
            try {
                dato11 = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            lista.add(new anexos.TO.AnxListadoRetencionesVentasTO(dato1, dato2,
                    dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxTalonResumenTO> convertirTalonResumen_ListaTalonResumenTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            Integer dato2;
            try {
                dato2 = Integer.parseInt(array[1].toString());
            } catch (Exception e) {
                dato2 = null;
            }
            java.math.BigDecimal dato3;
            try {
                dato3 = new java.math.BigDecimal(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }

            lista.add(new anexos.TO.AnxTalonResumenTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxTalonResumenVentaTO> convertirTalonResumenVenta_ListaTalonResumenVentaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String ven_comprobante;
            try {
                ven_comprobante = array[0].toString();
            } catch (Exception e) {
                ven_comprobante = null;
            }
            String ven_establecimiento;
            try {
                ven_establecimiento = array[1].toString();
            } catch (Exception e) {
                ven_establecimiento = null;
            }
            String ven_punto_emision;
            try {
                ven_punto_emision = array[2].toString();
            } catch (Exception e) {
                ven_punto_emision = null;
            }

            java.math.BigDecimal ven_basenoobjetoiva;
            try {
                ven_basenoobjetoiva = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                ven_basenoobjetoiva = null;
            }
            java.math.BigDecimal ven_base0;
            try {
                ven_base0 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                ven_base0 = null;
            }
            java.math.BigDecimal ven_baseimponible;
            try {
                ven_baseimponible = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                ven_baseimponible = null;
            }
            java.math.BigDecimal ven_motivoiva;
            try {
                ven_motivoiva = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                ven_motivoiva = null;
            }
            java.math.BigDecimal ven_valorretenidoIva;
            try {
                ven_valorretenidoIva = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                ven_valorretenidoIva = null;
            }
            java.math.BigDecimal ven_valorretenidorenta;
            try {
                ven_valorretenidorenta = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                ven_valorretenidorenta = null;
            }

            lista.add(new anexos.TO.AnxTalonResumenVentaTO(
                    ven_comprobante, ven_establecimiento, ven_punto_emision,
                    ven_basenoobjetoiva, ven_base0, ven_baseimponible, ven_motivoiva,
                    ven_valorretenidoIva, ven_valorretenidorenta));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxNumeracionTablaTO> convertirNumeracionTabla_ListaNumeracionTablaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            // num_secuencial, num_comprobante, num_desde, num_hasta
            Integer num_secuencial;
            try {
                num_secuencial = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                num_secuencial = null;
            }
            String num_comprobante;
            try {
                num_comprobante = array[1].toString();
            } catch (Exception e) {
                num_comprobante = null;
            }
            String num_desde;
            try {
                num_desde = array[2].toString();
            } catch (Exception e) {
                num_desde = null;
            }
            String num_hasta;
            try {
                num_hasta = array[3].toString();
            } catch (Exception e) {
                num_hasta = null;
            }

            lista.add(new anexos.TO.AnxNumeracionTablaTO(num_secuencial, num_comprobante, num_desde, num_hasta));
        }
        return lista;
    }

    public static anexos.TO.AnxConceptoTO convertirAnxConcepto_AnxConceptoTO(anexos.entity.AnxConcepto anxConcepto) {
        anexos.TO.AnxConceptoTO anxConceptoTO = new anexos.TO.AnxConceptoTO();
        anxConceptoTO.setConCodigo(anxConcepto.getConCodigo());
        anxConceptoTO.setConConcepto(anxConcepto.getConConcepto());
        anxConceptoTO.setConPorcentaje(anxConcepto.getConPorcentaje());
        anxConceptoTO.setFechaInicio(anxConcepto.getConFechaInicio() == null ? "" : validaciones.Validacion.fecha(anxConcepto.getConFechaInicio(), "yyyy-MM-dd"));
        anxConceptoTO.setFechaFin(anxConcepto.getConFechaFin() == null ? "" : validaciones.Validacion.fecha(anxConcepto.getConFechaFin(), "yyyy-MM-dd"));
        return anxConceptoTO;
    }

    public static anexos.TO.AnxFormaPagoTO convertirAnxFormaPago_AnxFormaPagoTO(anexos.entity.AnxFormaPago anxFormaPago) {
        anexos.TO.AnxFormaPagoTO anxFormaPagoTO = new anexos.TO.AnxFormaPagoTO();
        anxFormaPagoTO.setFpCodigo(anxFormaPago.getFpCodigo());
        anxFormaPagoTO.setFpDetalle(anxFormaPago.getFpDetalle());
        return anxFormaPagoTO;
    }

    public static anexos.TO.AnxSustentoTO convertirAnxSustento_AnxSustentoTO(anexos.entity.AnxSustento anxSustento) {
        anexos.TO.AnxSustentoTO anxSustentoTO = new anexos.TO.AnxSustentoTO();
        anxSustentoTO.setSusCodigo(anxSustento.getSusCodigo());
        anxSustentoTO.setSusDescripcion(anxSustento.getSusDescripcion());
        anxSustentoTO.setSusComprobante(anxSustento.getSusComprobante());
        return anxSustentoTO;
    }

    public static anexos.TO.AnxTipoComprobanteTO convertirAnxTipoComprobante_AnxTipoComprobanteTO(anexos.entity.AnxTipocomprobante anxTipoComprobante) {
        anexos.TO.AnxTipoComprobanteTO anxTipoComprobanteTO = new anexos.TO.AnxTipoComprobanteTO();
        anxTipoComprobanteTO.setTcCodigo(anxTipoComprobante.getTcCodigo());
        anxTipoComprobanteTO.setTcDescripcion(anxTipoComprobante.getTcDescripcion());
        anxTipoComprobanteTO.setTcTransaccion(anxTipoComprobante.getTcTransaccion());
        anxTipoComprobanteTO.setTcSustento(anxTipoComprobante.getTcSustento());
        anxTipoComprobanteTO.setTcAbreviatura(anxTipoComprobante.getTcAbreviatura());
        return anxTipoComprobanteTO;
    }

    public static java.util.List<anexos.TO.AnxTipoComprobanteTablaTO> convertirListaAnxTipoComprobanteTabla_ListaAnxTipoComprobanteTablaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }

            lista.add(new anexos.TO.AnxTipoComprobanteTablaTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static anexos.TO.AnxTipoIdentificacionTO convertirAnxTipoIdentificacion_AnxTipoIdentificacionTO(anexos.entity.AnxTipoidentificacion anxTipoIdentificacion) {
        anexos.TO.AnxTipoIdentificacionTO anxTipoIdentificacionTO = new anexos.TO.AnxTipoIdentificacionTO();
        anxTipoIdentificacionTO.setTiCodigo(anxTipoIdentificacion.getTiCodigo());
        anxTipoIdentificacionTO.setTiDetalle(anxTipoIdentificacion.getTiDetalle());
        return anxTipoIdentificacionTO;
    }

    public static anexos.TO.AnxTipoListaTransaccionTO convertirAnxTipoListaTransaccion_AnxTipoListaTransaccionTO(anexos.entity.AnxTipotransaccion anxTipoTransaccion) {
        anexos.TO.AnxTipoListaTransaccionTO anxTipoListaTransaccionTO = new anexos.TO.AnxTipoListaTransaccionTO();
        anxTipoListaTransaccionTO.setTtCodigo(anxTipoTransaccion.getTtCodigo());
        anxTipoListaTransaccionTO.setTtTransaccion(anxTipoTransaccion.getTtTransaccion());
        anxTipoListaTransaccionTO.setTtId(anxTipoTransaccion.getTtId());
        return anxTipoListaTransaccionTO;
    }

    public static List<anexos.TO.AnxAnuladoTablaTO> convertirListaAnxAnuladoTabla_ListaAnxAnuladoTablaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            Integer dato1;
            try {
                dato1 = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            lista.add(new anexos.TO.AnxAnuladoTablaTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11));
        }
        return lista;
    }

    public static anexos.TO.AnxAnuladosTO convertirAnxAnulados_AnxAnuladosTO(anexos.entity.AnxAnulados anxAnulados) {
        anexos.TO.AnxAnuladosTO anxAnuladosTO = new anexos.TO.AnxAnuladosTO();
        anxAnuladosTO.setAnuSecuencial(anxAnulados.getAnuSecuencial());
        anxAnuladosTO.setAnuComprobanteEstablecimiento(anxAnulados.getAnuComprobanteEstablecimiento());
        anxAnuladosTO.setAnuComprobantePuntoEmision(anxAnulados.getAnuComprobantePuntoEmision());
        anxAnuladosTO.setAnuSecuencialInicio(anxAnulados.getAnuSecuencialInicio());
        anxAnuladosTO.setAnuSecuencialFin(anxAnulados.getAnuSecuencialFin());
        anxAnuladosTO.setAnuAutorizacion(anxAnulados.getAnuAutorizacion());
        anxAnuladosTO.setAnuFecha(validaciones.Validacion.fecha(anxAnulados.getAnuFecha(), "yyyy-MM-dd"));
        anxAnuladosTO.setTcCodigo(anxAnulados.getTcCodigo().getTcCodigo());
        anxAnuladosTO.setUsrEmpresa(anxAnulados.getUsrEmpresa());
        anxAnuladosTO.setUsrCodigo(anxAnulados.getUsrCodigo());
        anxAnuladosTO.setUsrFechaInserta(validaciones.Validacion.fecha(anxAnulados.getUsrFechaInserta(), "yyyy-MM-dd"));

        return anxAnuladosTO;
    }

    public static anexos.entity.AnxAnulados convertirAnxAnuladosTO_AnxAnulados(anexos.TO.AnxAnuladosTO anxAnuladosTO) {
        anexos.entity.AnxAnulados anxAnulados = new anexos.entity.AnxAnulados();
        anxAnulados.setAnuSecuencial(anxAnuladosTO.getAnuSecuencial());
        anxAnulados.setAnuComprobanteEstablecimiento(anxAnuladosTO.getAnuComprobanteEstablecimiento());
        anxAnulados.setAnuComprobantePuntoEmision(anxAnuladosTO.getAnuComprobantePuntoEmision());
        anxAnulados.setAnuSecuencialInicio(anxAnuladosTO.getAnuSecuencialInicio());
        anxAnulados.setAnuSecuencialFin(anxAnuladosTO.getAnuSecuencialFin());
        anxAnulados.setAnuAutorizacion(anxAnuladosTO.getAnuAutorizacion());
        anxAnulados.setAnuFecha(validaciones.Validacion.fecha(anxAnuladosTO.getAnuFecha(), "yyyy-MM-dd"));
        anxAnulados.setUsrEmpresa(anxAnuladosTO.getUsrEmpresa());
        anxAnulados.setUsrCodigo(anxAnuladosTO.getUsrCodigo());
        anxAnulados.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(anxAnuladosTO.getUsrFechaInserta()));

        return anxAnulados;
    }

    public static List<anexos.TO.AnxPaisTO> convertirAnxPais_AnxPaisTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            lista.add(new anexos.TO.AnxPaisTO(dato1, dato2));
        }
        return lista;
    }

    public static List<anexos.TO.AnxProvinciaCantonTO> convertirAnxProvinciaCanton_AnxProvinciaCantonTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            lista.add(new anexos.TO.AnxProvinciaCantonTO(dato1, dato2));
        }
        return lista;
    }

    public static AnxCuentasContablesTO convertirAnxCuentasContables_AnxCuentasContablesTO(List datos) {
        AnxCuentasContablesTO anxCuentasContablesTO = null;
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;

            Integer ctaSecuencialSerial;
            try {
                ctaSecuencialSerial = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                ctaSecuencialSerial = null;
            }
            String ctaEmpresa;
            try {
                ctaEmpresa = array[1].toString();
            } catch (Exception e) {
                ctaEmpresa = null;
            }
            String ctaIvaPagado;
            try {
                ctaIvaPagado = array[2].toString();
            } catch (Exception e) {
                ctaIvaPagado = null;
            }
            String ctaIvaCobrado;
            try {
                ctaIvaCobrado = array[3].toString();
            } catch (Exception e) {
                ctaIvaCobrado = null;
            }
            String ctaRetFteIvaPagado;
            try {
                ctaRetFteIvaPagado = array[4].toString();
            } catch (Exception e) {
                ctaRetFteIvaPagado = null;
            }
            String ctaRetFteIvaCobrado;
            try {
                ctaRetFteIvaCobrado = array[5].toString();
            } catch (Exception e) {
                ctaRetFteIvaCobrado = null;
            }
            String ctaRetFteIvaAsumido;
            try {
                ctaRetFteIvaAsumido = array[6].toString();
            } catch (Exception e) {
                ctaRetFteIvaAsumido = null;
            }
            String ctaRetFteIrPagado;
            try {
                ctaRetFteIrPagado = array[7].toString();
            } catch (Exception e) {
                ctaRetFteIrPagado = null;
            }
            String ctaRetFteIrCobrado;
            try {
                ctaRetFteIrCobrado = array[8].toString();
            } catch (Exception e) {
                ctaRetFteIrCobrado = null;
            }
            String ctaRetFteIrAsumido;
            try {
                ctaRetFteIrAsumido = array[9].toString();
            } catch (Exception e) {
                ctaRetFteIrAsumido = null;
            }
            String ctaOtrosImpuestos;
            try {
                ctaOtrosImpuestos = array[10].toString();
            } catch (Exception e) {
                ctaOtrosImpuestos = null;
            }
            String ctaCuentasPorCobrar;
            try {
                ctaCuentasPorCobrar = array[11].toString();
            } catch (Exception e) {
                ctaCuentasPorCobrar = null;
            }
            String ctaCuentasPorPagar;
            try {
                ctaCuentasPorPagar = array[12].toString();
            } catch (Exception e) {
                ctaCuentasPorPagar = null;
            }
            String ctaCuentasPorPagarActivoFijo;
            try {
                ctaCuentasPorPagarActivoFijo = array[13].toString();
            } catch (Exception e) {
                ctaCuentasPorPagarActivoFijo = null;
            }
            String ctaAnticiposDeClientes;
            try {
                ctaAnticiposDeClientes = array[14].toString();
            } catch (Exception e) {
                ctaAnticiposDeClientes = null;
            }
            String ctaAnticiposProveedores;
            try {
                ctaAnticiposProveedores = array[15].toString();
            } catch (Exception e) {
                ctaAnticiposProveedores = null;
            }
            String ctaVentaBienesBase0;
            try {
                ctaVentaBienesBase0 = array[16].toString();
            } catch (Exception e) {
                ctaVentaBienesBase0 = null;
            }
            String ctaVentaBienesBaseImponible;
            try {
                ctaVentaBienesBaseImponible = array[17].toString();
            } catch (Exception e) {
                ctaVentaBienesBaseImponible = null;
            }
            String ctaVentaBienesBaseNoObjeto;
            try {
                ctaVentaBienesBaseNoObjeto = array[18].toString();
            } catch (Exception e) {
                ctaVentaBienesBaseNoObjeto = null;
            }
            String ctaVentaBienesBaseExenta;
            try {
                ctaVentaBienesBaseExenta = array[19].toString();
            } catch (Exception e) {
                ctaVentaBienesBaseExenta = null;
            }
            String ctaVentaServiciosBase0;
            try {
                ctaVentaServiciosBase0 = array[20].toString();
            } catch (Exception e) {
                ctaVentaServiciosBase0 = null;
            }
            String ctaVentaServiciosBaseImponible;
            try {
                ctaVentaServiciosBaseImponible = array[21].toString();
            } catch (Exception e) {
                ctaVentaServiciosBaseImponible = null;
            }
            String ctaVentaServiciosBaseNoObjeto;
            try {
                ctaVentaServiciosBaseNoObjeto = array[22].toString();
            } catch (Exception e) {
                ctaVentaServiciosBaseNoObjeto = null;
            }
            String ctaVentaServiciosBaseExenta;
            try {
                ctaVentaServiciosBaseExenta = array[23].toString();
            } catch (Exception e) {
                ctaVentaServiciosBaseExenta = null;
            }
            String ctaDiferencias;
            try {
                ctaDiferencias = array[24].toString();
            } catch (Exception e) {
                ctaDiferencias = null;
            }
            anxCuentasContablesTO = new AnxCuentasContablesTO(
                    ctaSecuencialSerial,
                    ctaEmpresa,
                    ctaIvaPagado,
                    ctaIvaCobrado,
                    ctaRetFteIvaPagado,
                    ctaRetFteIvaCobrado,
                    ctaRetFteIvaAsumido,
                    ctaRetFteIrPagado,
                    ctaRetFteIrCobrado,
                    ctaRetFteIrAsumido,
                    ctaOtrosImpuestos,
                    ctaCuentasPorCobrar,
                    ctaCuentasPorPagar,
                    ctaCuentasPorPagarActivoFijo,
                    ctaAnticiposDeClientes,
                    ctaAnticiposProveedores,
                    ctaVentaBienesBase0,
                    ctaVentaBienesBaseImponible,
                    ctaVentaBienesBaseNoObjeto,
                    ctaVentaBienesBaseExenta,
                    ctaVentaServiciosBase0,
                    ctaVentaServiciosBaseImponible,
                    ctaVentaServiciosBaseNoObjeto,
                    ctaVentaServiciosBaseExenta,
                    ctaDiferencias);
        }
        return anxCuentasContablesTO;
    }

    public static anexos.entity.AnxCuentascontables convertirAnxCuentasContablesTO_AnxCuentasContables(anexos.TO.AnxCuentasContablesTO anxCuentasContablesTO) {
        AnxCuentascontables anxCuentascontables = new AnxCuentascontables();

        anxCuentascontables.setCtaSecuencial(anxCuentasContablesTO.getCtaSecuencial());
        anxCuentascontables.setCtaEmpresa(anxCuentasContablesTO.getCtaEmpresa());
        anxCuentascontables.setCtaIvaPagado(anxCuentasContablesTO.getCtaIvaPagado());
        anxCuentascontables.setCtaIvaCobrado(anxCuentasContablesTO.getCtaIvaCobrado());
        anxCuentascontables.setCtaRetFteIvaPagado(anxCuentasContablesTO.getCtaRetFteIvaPagado());
        anxCuentascontables.setCtaRetFteIvaCobrado(anxCuentasContablesTO.getCtaRetFteIvaCobrado());
        anxCuentascontables.setCtaRetFteIvaAsumido(anxCuentasContablesTO.getCtaRetFteIvaAsumido());
        anxCuentascontables.setCtaRetFteIrPagado(anxCuentasContablesTO.getCtaRetFteIrPagado());
        anxCuentascontables.setCtaRetFteIrCobrado(anxCuentasContablesTO.getCtaRetFteIrCobrado());
        anxCuentascontables.setCtaRetFteIrAsumido(anxCuentasContablesTO.getCtaRetFteIrAsumido());
        anxCuentascontables.setCtaOtrosImpuestos(anxCuentasContablesTO.getCtaOtrosImpuestos());
        anxCuentascontables.setCtaCuentasPorCobrar(anxCuentasContablesTO.getCtaCuentasPorCobrar());
        anxCuentascontables.setCtaCuentasPorPagar(anxCuentasContablesTO.getCtaCuentasPorPagar());
        anxCuentascontables.setCtaCuentasPorPagarActivoFijo(anxCuentasContablesTO.getCtaCuentasPorPagarActivoFijo());
        anxCuentascontables.setCtaAnticiposDeClientes(anxCuentasContablesTO.getCtaAnticiposDeClientes());
        anxCuentascontables.setCtaAnticiposAProveedores(anxCuentasContablesTO.getCtaAnticiposAProveedores());
        anxCuentascontables.setCtaVentaBienesBase0(anxCuentasContablesTO.getCtaVentaBienesBase0());
        anxCuentascontables.setCtaVentaBienesBaseImponible(anxCuentasContablesTO.getCtaVentaBienesBaseImponible());
        anxCuentascontables.setCtaVentaBienesBaseNoObjeto(anxCuentasContablesTO.getCtaVentaBienesBaseNoObjeto());
        anxCuentascontables.setCtaVentaBienesBaseExenta(anxCuentasContablesTO.getCtaVentaBienesBaseExenta());
        anxCuentascontables.setCtaVentaServiciosBase0(anxCuentasContablesTO.getCtaVentaServiciosBase0());
        anxCuentascontables.setCtaVentaServiciosBaseImponible(anxCuentasContablesTO.getCtaVentaServiciosBaseImponible());
        anxCuentascontables.setCtaVentaServiciosBaseNoObjeto(anxCuentasContablesTO.getCtaVentaServiciosBaseNoObjeto());
        anxCuentascontables.setCtaVentaServiciosBaseExenta(anxCuentasContablesTO.getCtaVentaServiciosBaseExenta());
        anxCuentascontables.setCtaDiferencias(anxCuentasContablesTO.getCtaDiferenciaRedondeo());

        return anxCuentascontables;
    }

    public static List<anexos.TO.AnxFunListadoDevolucionIvaTO> convertirAnxFunListadoDevolucionIva_AnxFunListadoDevolucionIvaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            Character dato4;
            try {
                dato4 = array[3].toString().charAt(0);
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            java.math.BigDecimal dato9;
            try {
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            java.math.BigDecimal dato10;
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            java.math.BigDecimal dato11;
            try {
                dato11 = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            java.math.BigDecimal dato12;
            try {
                dato12 = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            lista.add(new anexos.TO.AnxFunListadoDevolucionIvaTO(dato1, dato2,
                    dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10,
                    dato11, dato12, dato13));
        }
        return lista;
    }

    public static anexos.entity.AnxCompra convertirAnxCompra_AnxCompra(anexos.entity.AnxCompra anxCompra) {
//        if (anxCompra != null){
        anexos.entity.AnxCompra anxCompras = new anexos.entity.AnxCompra();
        anxCompras.setAnxCompraPK(new anexos.entity.AnxCompraPK(
                anxCompra.getAnxCompraPK().getCompEmpresa(),
                anxCompra.getAnxCompraPK().getCompPeriodo(),
                anxCompra.getAnxCompraPK().getCompMotivo(),
                anxCompra.getAnxCompraPK().getCompNumero()));
        /*
         *
         *
         * comp_modificado_documento_empresa character(7),
         * comp_modificado_documento_tipo character(2),
         * comp_modificado_documento_numero character(17),
         * comp_modificado_autorizacion character(37), ret_impresa boolean NOT
         * NULL, ret_entregada boolean NOT NULL, ret_electronica boolean NOT
         * NULL,
         */

        anxCompras.setCompSustentotributario(anxCompra.getCompSustentotributario());
        anxCompras.setCompAutorizacion(anxCompra.getCompAutorizacion());
        anxCompras.setCompFechaEmision(anxCompra.getCompFechaEmision());
        anxCompras.setCompFechaCaduca(anxCompra.getCompFechaCaduca());
        anxCompras.setCompFechaRecepcion(anxCompra.getCompFechaRecepcion());
        anxCompras.setCompBase0(anxCompra.getCompBase0());
        anxCompras.setCompBaseimponible(anxCompra.getCompBaseimponible());
        anxCompras.setCompBasenoobjetoiva(anxCompra.getCompBasenoobjetoiva());
        anxCompras.setCompMontoice(anxCompra.getCompMontoice());
        anxCompras.setCompMontoiva(anxCompra.getCompMontoiva());
        anxCompras.setCompBaseivabienes(anxCompra.getCompBaseivabienes());
        anxCompras.setCompBaseivaservicios(anxCompra.getCompBaseivaservicios());
        anxCompras.setCompBaseivaserviciosprofesionales(anxCompra.getCompBaseivaserviciosprofesionales());

        anxCompras.setCompPorcentajebienes(anxCompra.getCompPorcentajebienes());
        anxCompras.setCompPorcentajeservicios(anxCompra.getCompPorcentajeservicios());
        anxCompras.setCompPorcentajeserviciosprofesionales(anxCompra.getCompPorcentajeserviciosprofesionales());
        anxCompras.setCompValorbienes(anxCompra.getCompValorbienes());
        anxCompras.setCompValorservicios(anxCompra.getCompValorservicios());
        anxCompras.setCompValorserviciosprofesionales(anxCompra.getCompValorserviciosprofesionales());
        anxCompras.setCompRetencionEmpresa(anxCompra.getCompRetencionEmpresa());
        anxCompras.setCompRetencionNumero(anxCompra.getCompRetencionNumero());
        anxCompras.setCompRetencionAutorizacion(anxCompra.getCompRetencionAutorizacion());

        anxCompras.setCompRetencionFechaEmision(anxCompra.getCompRetencionFechaEmision());

        anxCompras.setCompModificadoDocumentoEmpresa(anxCompra.getCompModificadoDocumentoEmpresa());
        anxCompras.setCompModificadoDocumentoTipo(anxCompra.getCompModificadoDocumentoTipo());
        anxCompras.setCompModificadoDocumentoNumero(anxCompra.getCompModificadoDocumentoNumero());
        anxCompras.setCompModificadoAutorizacion(anxCompra.getCompModificadoAutorizacion());
        anxCompras.setRetImpresa(anxCompra.getRetImpresa());
        anxCompras.setRetEntregada(anxCompra.getRetEntregada());
        anxCompras.setRetElectronica(anxCompra.getRetElectronica());

        return anxCompras;
    }

    public static anexos.TO.AnxCompraFormaPagoTO convertirAnxCompraFormaPago_AnxCompraFormaPagoTO(anexos.entity.AnxCompraFormaPago anxCompraFormaPago) {
        anexos.TO.AnxCompraFormaPagoTO anxCompraFormaPagoTO = new anexos.TO.AnxCompraFormaPagoTO();
        anxCompraFormaPagoTO.setDetSecuencial(anxCompraFormaPago.getDetSecuencial());
        anxCompraFormaPagoTO.setFpCodigo(anxCompraFormaPago.getFpCodigo().getFpCodigo());
        anxCompraFormaPagoTO.setCompEmpresa(anxCompraFormaPago.getAnxCompra().getAnxCompraPK().getCompEmpresa());
        anxCompraFormaPagoTO.setCompPeriodo(anxCompraFormaPago.getAnxCompra().getAnxCompraPK().getCompPeriodo());
        anxCompraFormaPagoTO.setCompMotivo(anxCompraFormaPago.getAnxCompra().getAnxCompraPK().getCompMotivo());
        anxCompraFormaPagoTO.setCompNumero(anxCompraFormaPago.getAnxCompra().getAnxCompraPK().getCompNumero());

        return anxCompraFormaPagoTO;
    }

    public static List<anexos.TO.AnxCompraFormaPagoTO> convertirListaObject_ListaAnxCompraFormaPagoTO(List datos, String[] parametros) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            Integer dato1;
            try {
                dato1 = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            anexos.TO.AnxCompraFormaPagoTO aux = new anexos.TO.AnxCompraFormaPagoTO(dato1, dato2, parametros[0], parametros[1], parametros[2], parametros[3]);
            lista.add(aux);
        }
        return lista;
    }

    public static anexos.entity.AnxCompraFormaPago convertirAnxCompraFormaPagoTO_AnxCompraFormaPago(anexos.TO.AnxCompraFormaPagoTO anxCompraFormaPagoTO) {
        anexos.entity.AnxCompraFormaPago anxCompraFormaPago = new anexos.entity.AnxCompraFormaPago();
        anxCompraFormaPago.setDetSecuencial(anxCompraFormaPagoTO.getDetSecuencial());
        return anxCompraFormaPago;
    }

    public static List<anexos.TO.AnxFunRegistroDatosCrediticiosTO> convertirAnxFunRegistroDatosCrediticios_AnxFunRegistroDatosCrediticiosTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;// private String cliCodigoDinardap;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;// private String cliCodigoDinardap;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }

            Character dato3;// private Character cliTipoId;//char 1
            try {
                dato3 = array[2].toString().charAt(0);
            } catch (Exception e) {
                dato3 = null;
            }

            String dato4;// private String cliID;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;// private String cliNombre;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            Character dato6;// private Character cliClaseSujeto;//char1
            try {
                dato6 = array[5].toString().charAt(0);
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;// private String cliProvincia;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;//private String cliCiudad;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9; //private String cliParroquia;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;//private String cliSexo;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;//private String cliEstadoCivil;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;//private String cliOrigenIngreso;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;//private String vtaDocumentoNumero;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }

            java.math.BigDecimal dato14;//private BigDecimal vtaTotal;
            try {
                dato14 = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                dato14 = null;
            }

            java.math.BigDecimal dato15;//private BigDecimal vtaSaldo;
            try {
                dato15 = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }

            String dato16;// private String vtaFecha;
            try {
                dato16 = array[15].toString();
            } catch (Exception e) {
                dato16 = null;
            }
            String dato17;//private String VtaFechaVencimiento;
            try {
                dato17 = array[16].toString();
            } catch (Exception e) {
                dato17 = null;
            }
            String dato18;//private String vtaFechaExigible;
            try {
                dato18 = array[17].toString();
            } catch (Exception e) {
                dato18 = null;
            }
            java.math.BigDecimal dato19;// private BigDecimal vtaPlazoOperacion;
            try {
                dato19 = new java.math.BigDecimal(array[18].toString());
            } catch (Exception e) {
                dato19 = null;
            }
            java.math.BigDecimal dato20;//private BigDecimal vtaPeriodicidadPago;
            try {
                dato20 = new java.math.BigDecimal(array[19].toString());
            } catch (Exception e) {
                dato20 = null;
            }
            java.math.BigDecimal dato21;//private BigDecimal vtaDiasMorosidad;
            try {
                dato21 = new java.math.BigDecimal(array[20].toString());
            } catch (Exception e) {
                dato21 = null;
            }
            java.math.BigDecimal dato22;//private BigDecimal vtaMontoMorosidad;
            try {
                dato22 = new java.math.BigDecimal(array[21].toString());
            } catch (Exception e) {
                dato22 = null;
            }
            java.math.BigDecimal dato23;// private BigDecimal vtaMontoInteresMora;
            try {
                dato23 = new java.math.BigDecimal(array[22].toString());
            } catch (Exception e) {
                dato23 = null;
            }
            java.math.BigDecimal dato24;// private BigDecimal vtaValorPorVencer0130;
            try {
                dato24 = new java.math.BigDecimal(array[23].toString());
            } catch (Exception e) {
                dato24 = null;
            }
            java.math.BigDecimal dato25;// private BigDecimal vtaValorPorVencer3109;
            try {
                dato25 = new java.math.BigDecimal(array[24].toString());
            } catch (Exception e) {
                dato25 = null;
            }
            java.math.BigDecimal dato26;// private BigDecimal vtaValorPorVencer91180;
            try {
                dato26 = new java.math.BigDecimal(array[25].toString());
            } catch (Exception e) {
                dato26 = null;
            }
            java.math.BigDecimal dato27;//private BigDecimal vtaValorporVencer181360;
            try {
                dato27 = new java.math.BigDecimal(array[26].toString());
            } catch (Exception e) {
                dato27 = null;
            }

            java.math.BigDecimal dato28;//private BigDecimal vtaValorPorVencerMas360;
            try {
                dato28 = new java.math.BigDecimal(array[27].toString());
            } catch (Exception e) {
                dato28 = null;
            }
            java.math.BigDecimal dato29;//private BigDecimal vtaValorVencido0130;
            try {
                dato29 = new java.math.BigDecimal(array[28].toString());
            } catch (Exception e) {
                dato29 = null;
            }
            java.math.BigDecimal dato30;//private BigDecimal vtaValorVencido3190;
            try {
                dato30 = new java.math.BigDecimal(array[29].toString());
            } catch (Exception e) {
                dato30 = null;
            }
            java.math.BigDecimal dato31;//private BigDecimal vtaValorVencido91180;
            try {
                dato31 = new java.math.BigDecimal(array[30].toString());
            } catch (Exception e) {
                dato31 = null;
            }
            java.math.BigDecimal dato32;// private BigDecimal vtaValorVencido181360;
            try {
                dato32 = new java.math.BigDecimal(array[31].toString());
            } catch (Exception e) {
                dato32 = null;
            }
            java.math.BigDecimal dato33;// private BigDecimal vtaValorVencidomas360;
            try {
                dato33 = new java.math.BigDecimal(array[32].toString());
            } catch (Exception e) {
                dato33 = null;
            }
            java.math.BigDecimal dato34;// private BigDecimal vtaValorDemandaJudicial;
            try {
                dato34 = new java.math.BigDecimal(array[33].toString());
            } catch (Exception e) {
                dato34 = null;
            }
            java.math.BigDecimal dato35;// private BigDecimal vtaCarteraCastigada;
            try {
                dato35 = new java.math.BigDecimal(array[34].toString());
            } catch (Exception e) {
                dato35 = null;
            }
            java.math.BigDecimal dato36;//private BigDecimal vtaCuotaCredito;
            try {
                dato36 = new java.math.BigDecimal(array[35].toString());
            } catch (Exception e) {
                dato36 = null;
            }

            String dato37;//private String vtaFechaCancelacion;
            try {
                dato37 = array[36].toString();
            } catch (Exception e) {
                dato37 = null;
            }
            Character dato38;// private Character vtaFormaCancelacion;
            try {
                dato38 = array[37].toString().charAt(0);
            } catch (Exception e) {
                dato38 = null;
            }

            lista.add(new anexos.TO.AnxFunRegistroDatosCrediticiosTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10,
                    dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18, dato19, dato20,
                    dato21, dato22, dato23, dato24, dato25, dato26, dato27, dato28, dato29, dato30,
                    dato31, dato32, dato33, dato34, dato35, dato36, dato37, dato38));
        }
        return lista;
    }

    public static anexos.entity.AnxUrlWebServices convertirAnxUrlWebServicesTO_AnxUrlWebServices(anexos.TO.anxUrlWebServicesTO anxUrlWebServicesTO) {
        anexos.entity.AnxUrlWebServices anxUrlWebServices = new anexos.entity.AnxUrlWebServices();
        anxUrlWebServices.setUrlSecuencial(anxUrlWebServicesTO.getUrlSecuencial());
        anxUrlWebServices.setUrlAmbienteProduccion(anxUrlWebServicesTO.getUrlAmbienteProduccion());
        anxUrlWebServices.setUrlAmbientePruebas(anxUrlWebServicesTO.getUrlAmbientePruebas());
        return anxUrlWebServices;
    }

    public static anexos.entity.AnxVentaElectronica convertirAnxVentaElectronicaTO_AnxVentaElectronica(anexos.TO.AnxVentaElectronicaTO anxVentaElectronicaTO) {
        anexos.entity.AnxVentaElectronica anxVentaElectronica = new anexos.entity.AnxVentaElectronica();
        anxVentaElectronica.setESecuencial(anxVentaElectronicaTO.geteSecuencial());
        anxVentaElectronica.setETipoAmbiente(anxVentaElectronicaTO.geteTipoAmbiente());
        anxVentaElectronica.setEClaveAcceso(anxVentaElectronicaTO.geteClaveAcceso());
        anxVentaElectronica.setEEstado(anxVentaElectronicaTO.geteEstado());
        anxVentaElectronica.setEAutorizacionNumero(anxVentaElectronicaTO.geteAutorizacionNumero());
        anxVentaElectronica.setEAutorizacionFecha(validaciones.Validacion.fecha(anxVentaElectronicaTO.geteAutorizacionFecha(), "yyyy-MM-dd HH:mm:ss"));//, "yyyy-mm-dd hh:mm:ss"
        anxVentaElectronica.setEXml(anxVentaElectronicaTO.geteXml());
        anxVentaElectronica.setEEnviadoPorCorreo(anxVentaElectronicaTO.geteEnviadoPorCorreo());
        anxVentaElectronica.setVtaEmpresa(anxVentaElectronicaTO.getVtaEmpresa());
        anxVentaElectronica.setVtaPeriodo(anxVentaElectronicaTO.getVtaPeriodo());
        anxVentaElectronica.setVtaMotivo(anxVentaElectronicaTO.getVtaMotivo());
        anxVentaElectronica.setVtaNumero(anxVentaElectronicaTO.getVtaNumero());
        anxVentaElectronica.setUsrEmpresa(anxVentaElectronicaTO.getUsrEmpresa());
        anxVentaElectronica.setUsrCodigo(anxVentaElectronicaTO.getUsrCodigo());
        anxVentaElectronica.setUsrFechaInserta(validaciones.Validacion.fecha(validaciones.Validacion.fechaSistema(), "yyyy-MM-dd HH:mm:ss"));
//        anxVentaElectronica.setUsrFechaInserta(anxVentaElectronicaTO.getUsrFechaInserta());
        return anxVentaElectronica;
    }

    public static anexos.entity.AnxCompraElectronica convertirAnxVentaElectronicaTO_AnxVentaElectronica(anexos.TO.AnxCompraElectronicaTO anxCompraElectronicaTO) {

        anexos.entity.AnxCompraElectronica anxCompraElectronica = new anexos.entity.AnxCompraElectronica();
        anxCompraElectronica.setESecuencial(anxCompraElectronicaTO.geteSecuencial());
        anxCompraElectronica.setETipoAmbiente(anxCompraElectronicaTO.geteTipoAmbiente());
        anxCompraElectronica.setEClaveAcceso(anxCompraElectronicaTO.geteClaveAcceso());
        anxCompraElectronica.setEEstado(anxCompraElectronicaTO.geteEstado());
        anxCompraElectronica.setEAutorizacionNumero(anxCompraElectronicaTO.geteAutorizacionNumero());
        anxCompraElectronica.setEAutorizacionFecha(validaciones.Validacion.fechaString_Date(anxCompraElectronicaTO.geteAutorizacionFecha()));//, "yyyy-mm-dd hh:mm:ss"
        anxCompraElectronica.setEXml(anxCompraElectronicaTO.geteXml());

        anxCompraElectronica.setEEnviadoPorCorreo(anxCompraElectronicaTO.geteEnviadoPorCorreo());
        anxCompraElectronica.setAnxCompra(new AnxCompra(anxCompraElectronicaTO.getCompEmpresa(), anxCompraElectronicaTO.getCompPeriodo(), anxCompraElectronicaTO.getCompMotivo(), anxCompraElectronicaTO.getCompNumero()));
        anxCompraElectronica.setUsrEmpresa(anxCompraElectronicaTO.getUsrEmpresa());
        anxCompraElectronica.setUsrCodigo(anxCompraElectronicaTO.getUsrCodigo());
        anxCompraElectronica.setUsrFechaInserta(validaciones.Validacion.fecha(validaciones.Validacion.fechaSistema(), "yyyy-MM-dd HH:mm:ss"));
//        anxVentaElectronica.setUsrFechaInserta(anxVentaElectronicaTO.getUsrFechaInserta());
        return anxCompraElectronica;
    }

    public static List<anexos.TO.AnxListaVentaElectronicaTO> convertirAnxVentaElectronica_AnxVentaElectronicaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();

            Integer e_secuencial;
            try {
                e_secuencial = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                e_secuencial = null;
            }

            String vta_periodo;
            try {
                vta_periodo = array[1].toString();
            } catch (Exception e) {
                vta_periodo = null;
            }
            String vta_motivo;
            try {
                vta_motivo = array[2].toString();
            } catch (Exception e) {
                vta_motivo = null;
            }
            String vta_numero;
            try {
                vta_numero = array[3].toString();
            } catch (Exception e) {
                vta_numero = null;
            }
            String cli_nombre;
            try {
                cli_nombre = array[4].toString();
            } catch (Exception e) {
                cli_nombre = null;
            }
            String vta_documento_tipo;
            try {
                vta_documento_tipo = array[5].toString();
            } catch (Exception e) {
                vta_documento_tipo = null;
            }
            String vta_documento_numero;
            try {
                vta_documento_numero = array[6].toString();
            } catch (Exception e) {
                vta_documento_numero = null;
            }
            String vta_fecha;
            try {
                vta_fecha = array[7].toString();
            } catch (Exception e) {
                vta_fecha = null;
            }
            String e_autorizacion_fecha;
            try {
                e_autorizacion_fecha = array[8].toString();
                //dato8 = array[7];
            } catch (Exception e) {
                e_autorizacion_fecha = null;
            }
            String e_autorizacion_numero;
            try {
                e_autorizacion_numero = array[9].toString();
            } catch (Exception e) {
                e_autorizacion_numero = null;
            }


            Boolean e_enviado_por_correo;
            try {
                e_enviado_por_correo = Boolean.valueOf(array[10].toString());
            } catch (Exception e) {
                e_enviado_por_correo = null;
            }


            lista.add(new anexos.TO.AnxListaVentaElectronicaTO(
                    e_secuencial,
                    vta_periodo,
                    vta_motivo,
                    vta_numero,
                    cli_nombre,
                    vta_documento_tipo,
                    vta_documento_numero,
                    vta_fecha,
                    e_autorizacion_fecha,
                    e_autorizacion_numero,
                    e_enviado_por_correo));
        }
        return lista;
    }

    public static List<anexos.TO.AnxListadoCompraElectronicaTO> convertirAnxCompraElectronica_AnxCompraElectronicaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion

        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            int indice = 0;
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            Integer e_secuencial;
            try {
                e_secuencial = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                e_secuencial = null;
            }
            String comp_periodo;
            try {
                comp_periodo = array[1].toString();
            } catch (Exception e) {
                comp_periodo = null;
            }
            String comp_motivo;
            try {
                comp_motivo = array[2].toString();
            } catch (Exception e) {
                comp_motivo = null;
            }
            String comp_numero;
            try {
                comp_numero = array[3].toString();
            } catch (Exception e) {
                comp_numero = null;
            }
            String prov_nombre;
            try {
                prov_nombre = array[4].toString();
            } catch (Exception e) {
                prov_nombre = null;
            }
            String comp_retencion_numero;
            try {
                comp_retencion_numero = array[5].toString();
            } catch (Exception e) {
                comp_retencion_numero = null;
            }
            String comp_retencion_fecha_emision;
            try {
                comp_retencion_fecha_emision = array[6].toString();
            } catch (Exception e) {
                comp_retencion_fecha_emision = null;
            }

            String e_autorizacion_fecha;
            try {
                e_autorizacion_fecha = array[7].toString();
            } catch (Exception e) {
                e_autorizacion_fecha = null;
            }
            String e_autorizacion_numero;
            try {
                e_autorizacion_numero = array[8].toString();
            } catch (Exception e) {
                e_autorizacion_numero = null;
            }
            Boolean e_enviado_por_correo;
            try {
                e_enviado_por_correo = Boolean.valueOf(array[9].toString());
            } catch (Exception e) {
                e_enviado_por_correo = null;
            }
            lista.add(new anexos.TO.AnxListadoCompraElectronicaTO(
                    e_secuencial,
                    comp_periodo,
                    comp_motivo,
                    comp_numero,
                    prov_nombre,
                    comp_retencion_numero,
                    comp_retencion_fecha_emision,
                    e_autorizacion_fecha,
                    e_autorizacion_numero,
                    e_enviado_por_correo));
        }
        return lista;
    }

    public static java.util.List<anexos.TO.AnxListaConsultaVentaElectronicaTO> convertirAnxListaConsultaVentaElectronica_AnxListaConsultaVentaElectronicaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = "";
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato9;
            try {
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato10;
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato11;
            try {
                dato11 = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = java.math.BigDecimal.ZERO;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            String dato14;
            try {
                dato14 = array[13].toString();
            } catch (Exception e) {
                dato14 = null;
            }
            String dato15;
            try {
                dato15 = array[14].toString();
            } catch (Exception e) {
                dato15 = null;
            }
            String dato16;
            try {
                dato16 = array[15].toString();
            } catch (Exception e) {
                dato16 = null;
            }
            lista.add(new anexos.TO.AnxListaConsultaVentaElectronicaTO(
                    dato1,
                    dato2,
                    dato3,
                    dato4,
                    dato5,
                    dato6,
                    dato7,
                    dato8,
                    dato9,
                    dato10,
                    dato11,
                    dato12,
                    dato13,
                    dato14,
                    dato15,
                    dato16));
        }
        return lista;
    }

    public static anexos.entity.AnxVentaElectronica convertirAnxVentaElectronica_AnxVentaElectronica(anexos.entity.AnxVentaElectronica anxVentaElectronica) {
        anexos.entity.AnxVentaElectronica anxVentaElectronicas = new anexos.entity.AnxVentaElectronica();
        anxVentaElectronicas.setESecuencial(anxVentaElectronica.getESecuencial());
        anxVentaElectronicas.setETipoAmbiente(anxVentaElectronica.getETipoAmbiente());
        anxVentaElectronicas.setEClaveAcceso(anxVentaElectronica.getEClaveAcceso());
        anxVentaElectronicas.setEEstado(anxVentaElectronica.getEEstado());
        anxVentaElectronicas.setEAutorizacionNumero(anxVentaElectronica.getEAutorizacionNumero());
        anxVentaElectronicas.setEAutorizacionFecha(anxVentaElectronica.getEAutorizacionFecha());
        anxVentaElectronicas.setEXml(anxVentaElectronica.getEXml());
        anxVentaElectronicas.setEEnviadoPorCorreo(anxVentaElectronica.getEEnviadoPorCorreo());
        anxVentaElectronicas.setVtaEmpresa(anxVentaElectronica.getVtaEmpresa());
        anxVentaElectronicas.setVtaPeriodo(anxVentaElectronica.getVtaPeriodo());
        anxVentaElectronicas.setVtaMotivo(anxVentaElectronica.getVtaMotivo());
        anxVentaElectronicas.setVtaNumero(anxVentaElectronica.getVtaNumero());
        anxVentaElectronicas.setUsrEmpresa(anxVentaElectronica.getUsrEmpresa());
        anxVentaElectronicas.setUsrCodigo(anxVentaElectronica.getUsrCodigo());
        anxVentaElectronicas.setUsrFechaInserta(anxVentaElectronica.getUsrFechaInserta());

        return anxVentaElectronicas;
    }
//    public static anexos.entity.AnxCompraElectronica convertirAnxCompraElectronica_AnxCompraElectronica(anexos.entity.AnxCompraElectronica anxCompraElectronica) {
//            anexos.entity.AnxCompraElectronica anxCompraElectronicas = new anexos.entity.AnxCompraElectronica();
//            
//            anxCompraElectronicas.setAnxCompraElectronicaPK(new anexos.entity.AnxCompraElectronicaPK(
//                                anxCompraElectronica.getAnxCompraElectronicaPK().getEEmpresa(), 
//                                anxCompraElectronica.getAnxCompraElectronicaPK().getEPeriodo(), 
//                                anxCompraElectronica.getAnxCompraElectronicaPK().getEMotivo(),
//                                anxCompraElectronica.getAnxCompraElectronicaPK().getENumero()));
//            
//            /*
//    
//    
// 
//
//
// 
//
//
//
//
//  comp_empresa character(7) NOT NULL,
//  comp_periodo character(7) NOT NULL,
//  comp_motivo character(7) NOT NULL,
//  comp_numero character(7) NOT NULL,
//  usr_empresa character(7) NOT NULL,
//  usr_codigo character(7) NOT NULL,
//  usr_fecha_inserta timestamp without time zone NOT NULL,
//             */
//            anxCompraElectronicas.setETipoAmbiente(anxCompraElectronica.getETipoAmbiente());
//            anxCompraElectronicas.setEClaveAcceso(anxCompraElectronica.getEClaveAcceso());
//            anxCompraElectronicas.setEEstado(anxCompraElectronica.getEEstado());
//            anxCompraElectronicas.setEAutorizacionNumero(anxCompraElectronica.getEAutorizacionNumero());
//            anxCompraElectronicas.setEAutorizacionFecha(anxCompraElectronica.getEAutorizacionFecha());
//            anxCompraElectronicas.setEXml(anxCompraElectronica.getEXml());
//            anxCompraElectronicas.setEClaveDescargaRide(anxCompraElectronica.getEClaveDescargaRide());
//            anxCompraElectronicas.setEEnviadoPorCorreo(anxCompraElectronica.getEEnviadoPorCorreo());
//            anxCompraElectronicas.setVtaEmpresa(anxCompraElectronica.getVtaEmpresa());
//            anxCompraElectronicas.setVtaPeriodo(anxCompraElectronica.getVtaPeriodo());
//            anxCompraElectronicas.setVtaMotivo(anxCompraElectronica.getVtaMotivo());
//            anxCompraElectronicas.setVtaNumero(anxCompraElectronica.getVtaNumero());
//            anxCompraElectronicas.setUsrEmpresa(anxCompraElectronica.getUsrEmpresa());
//            anxCompraElectronicas.setUsrCodigo(anxCompraElectronica.getUsrCodigo());
//            anxCompraElectronicas.setUsrFechaInserta(anxCompraElectronica.getUsrFechaInserta());
//          
//            return anxVentaElectronicas;
//    }
    /*
     * public static inventario.entity.InvProducto
     * convertirInvProducto_InvProducto(inventario.entity.InvProducto
     * invProductoOrigen) { inventario.entity.InvProducto invProducto = new
     * inventario.entity.InvProducto(); invProducto.setInvProductoPK(new
     * inventario.entity.InvProductoPK(invProductoOrigen.getInvProductoPK().getProEmpresa(),
     * invProductoOrigen.getInvProductoPK().getProCodigoPrincipal()));
     * invProducto.setProCodigoAlterno(invProductoOrigen.getProCodigoAlterno());
     * invProducto.setProCodigoBarra(invProductoOrigen.getProCodigoBarra());
     * invProducto.setProCodigoBarra2(invProductoOrigen.getProCodigoBarra2());
     * invProducto.setProCodigoBarra3(invProductoOrigen.getProCodigoBarra3());
     * invProducto.setProCodigoBarra4(invProductoOrigen.getProCodigoBarra4());
     * invProducto.setProCodigoBarra5(invProductoOrigen.getProCodigoBarra5());
     */
//     public static anexos.TO.AnxVentaElectronicaTO convertirAnxVentaElectronica_AnxVentaElectronicaTO(anexos.entity.AnxVentaElectronica anxVentaElectronica) {
//         /*
//            e_empresa character(7) NOT NULL,
//            e_periodo character(7) NOT NULL,
//            e_motivo character(7) NOT NULL,
//            e_numero character(7) NOT NULL,
//            
//            e_clave_acceso character(50) NOT NULL,
//            e_estado character(10) NOT NULL,
//            e_autorizacion_numero character(37) NOT NULL,
//            e_autorizacion_fecha timestamp without time zone NOT NULL,
//            
//            
//            e_xml bytea,
//            e_clave_descarga_ride character(10) NOT NULL,
//            e_enviado_por_correo boolean NOT NULL,
//            vta_empresa character(7) NOT NULL,
//            vta_periodo character(7) NOT NULL,
//            vta_motivo character(7) NOT NULL,
//            vta_numero character(7) NOT NULL,
//            usr_empresa character(7) NOT NULL,
//            usr_codigo character(7) NOT NULL,
//            usr_fecha_inserta timestamp without time zone NOT NULL,
//          */
//        if (anxVentaElectronica != null){
//            anexos.TO.AnxVentaElectronicaTO anxVentaElectronicaTO = new anexos.TO.AnxVentaElectronicaTO();
//            anxVentaElectronicaTO.seteEmpresa(anxVentaElectronica.getAnxVentaElectronicaPK().getEEmpresa());
//            anxVentaElectronicaTO.setePeriodo(anxVentaElectronica.getAnxVentaElectronicaPK().getEPeriodo());
//            anxVentaElectronicaTO.seteMotivo(anxVentaElectronica.getAnxVentaElectronicaPK().getEMotivo());
//            anxVentaElectronicaTO.seteNumero(anxVentaElectronica.getAnxVentaElectronicaPK().getENumero());
//            
//            anxVentaElectronicaTO.seteClaveAcceso(anxVentaElectronica.getEClaveAcceso());
//            anxVentaElectronicaTO.seteEstado(anxVentaElectronica.getEEstado());
//            anxVentaElectronicaTO.seteAutorizacionNumero(anxVentaElectronica.getEAutorizacionNumero());
//            anxVentaElectronicaTO.setUsrFechaInserta(validaciones.Validacion.fecha(anxVenta.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
//   
//            
//            
//            
//            java.text.DateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");
//    //        return formato.format(fecha);
//            anxVentaTO.setVenRetencionFechaEmision(formato.format(anxVenta.getVenRetencionfechaemision()));
//    //        anxCompra.setUsrEmpresa(anxCompraTO.getEmpCodigo());
//            anxVentaTO.setUsrEmpresa(anxVenta.getUsrEmpresa());
//            anxVentaTO.setUsrCodigo(anxVenta.getUsrCodigo());
//            anxVentaTO.setUsrFechaInserta(validaciones.Validacion.fecha(anxVenta.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
//            return anxVentaTO;
//        } else
//            return null;
//    }
}
