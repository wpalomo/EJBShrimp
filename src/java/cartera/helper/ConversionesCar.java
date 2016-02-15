/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.helper;

import cartera.TO.*;
import cartera.entity.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import validaciones.Validacion;

/**
 *
 * @author misael
 */
public class ConversionesCar {

    private static java.math.BigDecimal cero = new java.math.BigDecimal("0.00");

    // <editor-fold defaultstate="collapsed" desc="COBROS">
    public static CarCobros convertirCarCobrosTO_CarCobros(CarCobrosTO carCobrosTO) throws Exception {
        CarCobros carCobros = new CarCobros();
        carCobros.setCarCobrosPK(new CarCobrosPK(
                carCobrosTO.getUsrEmpresa(),
                carCobrosTO.getCobPeriodo(),
                carCobrosTO.getCobTipo(),
                carCobrosTO.getCobNumero()));
        carCobros.setCobReversado(carCobrosTO.getCobReversado());
        carCobros.setCliEmpresa(carCobrosTO.getUsrEmpresa());
        carCobros.setCliCodigo(carCobrosTO.getCliCodigo());
        carCobros.setUsrEmpresa(carCobrosTO.getUsrEmpresa());
        carCobros.setUsrCodigo(carCobrosTO.getUsrCodigo());
        carCobros.setUsrFechaInserta(Validacion.fechaString_Date(carCobrosTO.getUsrFechaInserta()));
        return carCobros;
    }

    public static CarCobros convertirCarCobros_CarCobros(CarCobros carCobrosAux) throws Exception {
        CarCobros carCobros = new CarCobros();
        carCobros.setCarCobrosPK(carCobros.getCarCobrosPK());
        carCobros.setCobReversado(carCobrosAux.getCobReversado());
        carCobros.setCliEmpresa(carCobrosAux.getUsrEmpresa());
        carCobros.setCliCodigo(carCobrosAux.getCliCodigo());
        carCobros.setUsrEmpresa(carCobrosAux.getUsrEmpresa());
        carCobros.setUsrCodigo(carCobrosAux.getUsrCodigo());
        carCobros.setUsrFechaInserta(carCobrosAux.getUsrFechaInserta());
        return carCobros;
    }

    public static CarCobrosAnticipos convertirCarCobrosAnticipos_CarCobrosAnticipos(CarCobrosAnticipos carCobrosAnticiposAux) throws Exception {
        CarCobrosAnticipos carCobrosAnticipos = new CarCobrosAnticipos();
        carCobrosAnticipos.setCarCobrosAnticiposPK(carCobrosAnticipos.getCarCobrosAnticiposPK());
        carCobrosAnticipos.setAntValor(carCobrosAnticiposAux.getAntValor());
        carCobrosAnticipos.setAntCobrado(carCobrosAnticiposAux.getAntCobrado());
        carCobrosAnticipos.setAntReversado(carCobrosAnticiposAux.getAntReversado());
        carCobrosAnticipos.setFpSecuencial(carCobrosAnticiposAux.getFpSecuencial());
        carCobrosAnticipos.setCliEmpresa(carCobrosAnticiposAux.getUsrEmpresa());
        carCobrosAnticipos.setCliCodigo(carCobrosAnticiposAux.getCliCodigo());
        carCobrosAnticipos.setSecEmpresa(carCobrosAnticiposAux.getUsrEmpresa());
        carCobrosAnticipos.setSecCodigo(carCobrosAnticiposAux.getSecCodigo());
        carCobrosAnticipos.setUsrEmpresa(carCobrosAnticiposAux.getUsrEmpresa());
        carCobrosAnticipos.setUsrCodigo(carCobrosAnticiposAux.getUsrCodigo());
        carCobrosAnticipos.setUsrFechaInserta(carCobrosAnticiposAux.getUsrFechaInserta());
        return carCobrosAnticipos;
    }

    public static CarCobrosDetalleVentas convertirCarCobrosDetalleVentasTO_CarCobrosDetalleVentas(CarCobrosDetalleVentasTO carCobrosDetalleVentasTO) throws Exception {
        CarCobrosDetalleVentas carCobrosDetalleVentas = new CarCobrosDetalleVentas();
        carCobrosDetalleVentas.setDetSecuencial(carCobrosDetalleVentasTO.getDetSecuencial());
        carCobrosDetalleVentas.setDetValor(carCobrosDetalleVentasTO.getDetValor());
        carCobrosDetalleVentas.setCarCobros(
                new CarCobros(
                new CarCobrosPK(
                carCobrosDetalleVentasTO.getCobEmpresa(),
                carCobrosDetalleVentasTO.getCobPeriodo(),
                carCobrosDetalleVentasTO.getCobTipo(),
                carCobrosDetalleVentasTO.getCobNumero())));
        carCobrosDetalleVentas.setVtaEmpresa(carCobrosDetalleVentasTO.getVtaEmpresa());
        carCobrosDetalleVentas.setVtaPeriodo(carCobrosDetalleVentasTO.getVtaPeriodo());
        carCobrosDetalleVentas.setVtaMotivo(carCobrosDetalleVentasTO.getVtaMotivo());
        carCobrosDetalleVentas.setVtaNumero(carCobrosDetalleVentasTO.getVtaNumero());
        carCobrosDetalleVentas.setSecEmpresa(carCobrosDetalleVentasTO.getVtaEmpresa());
        carCobrosDetalleVentas.setSecCodigo(carCobrosDetalleVentasTO.getVtaSecCodigo());
        return carCobrosDetalleVentas;
    }

    public static CarCobrosDetalleForma convertirCarCobrosDetalleFormaTO_CarCobrosDetalleForma(CarCobrosDetalleFormaTO carCobrosDetalleFormaTO) throws Exception {
        CarCobrosDetalleForma carCobrosDetalleForma = new CarCobrosDetalleForma();
        carCobrosDetalleForma.setDetSecuencial(0);
        
        carCobrosDetalleForma.setDetBanco(carCobrosDetalleFormaTO.getDetBanco());
        carCobrosDetalleForma.setDetCuenta(carCobrosDetalleFormaTO.getDetCuenta());
//        invCompras.setCompFecha(validaciones.Validacion.fecha(invComprasTO.getCompFecha(), "yyyy-MM-dd"));
        carCobrosDetalleForma.setDetFechaVencimiento(validaciones.Validacion.fecha(
                carCobrosDetalleFormaTO.getDetFechaPst(),"yyyy-MM-dd"));
        
        carCobrosDetalleForma.setDetValor(carCobrosDetalleFormaTO.getDetValor());
        carCobrosDetalleForma.setDetReferencia(carCobrosDetalleFormaTO.getDetReferencia());
        carCobrosDetalleForma.setDetObservaciones(carCobrosDetalleFormaTO.getDetObservaciones());
        carCobrosDetalleForma.setBanCodigo(carCobrosDetalleFormaTO.getBanCodigo());
        carCobrosDetalleForma.setBanEmpresa(carCobrosDetalleFormaTO.getBanEmpresa());
        carCobrosDetalleForma.setCarCobros(
                new CarCobros(
                new CarCobrosPK(
                carCobrosDetalleFormaTO.getCobEmpresa(),
                carCobrosDetalleFormaTO.getCobPeriodo(),
                carCobrosDetalleFormaTO.getCobMotivo(),
                carCobrosDetalleFormaTO.getCobNumero())));
        carCobrosDetalleForma.setFpSecuencial(new CarCobrosForma(
                carCobrosDetalleFormaTO.getFpSecuencial()));
        return carCobrosDetalleForma;
        
//        CarPagosDetalleForma carPagosDetalleForma = new CarPagosDetalleForma();
//        carPagosDetalleForma.setDetSecuencial(0);
//        carPagosDetalleForma.setDetValor(carPagosDetalleFormaTO.getDetValor());
//        carPagosDetalleForma.setDetReferencia(carPagosDetalleFormaTO.getDetReferencia());
//        carPagosDetalleForma.setDetObservaciones(carPagosDetalleFormaTO.getDetObservaciones());
//        carPagosDetalleForma.setCarPagos(
//                new CarPagos(
//                new CarPagosPK(
//                carPagosDetalleFormaTO.getPagEmpresa(),
//                carPagosDetalleFormaTO.getPagPeriodo(),
//                carPagosDetalleFormaTO.getPagMotivo(),
//                carPagosDetalleFormaTO.getPagNumero())));
//        carPagosDetalleForma.setFpSecuencial(new CarPagosForma(
//                carPagosDetalleFormaTO.getFpSecuencial()));
//        return carPagosDetalleForma;
    }

    public static cartera.entity.CarCobrosDetalleAnticipos convertirCarCobrosDetalleAnticiposTO_CarCobrosDetalleAnticipos(cartera.TO.CarCobrosDetalleAnticiposTO carCobrosDetalleAnticiposTO) throws Exception {
        cartera.entity.CarCobrosDetalleAnticipos carCobrosDetalleAnticipos = new cartera.entity.CarCobrosDetalleAnticipos();
        carCobrosDetalleAnticipos.setDetSecuencial(0);
        carCobrosDetalleAnticipos.setDetValor(carCobrosDetalleAnticiposTO.getDetValor());
        carCobrosDetalleAnticipos.setDetObservaciones(carCobrosDetalleAnticiposTO.getDetObservaciones());
        carCobrosDetalleAnticipos.setCarCobrosAnticipos(
                new CarCobrosAnticipos(
                new CarCobrosAnticiposPK(
                carCobrosDetalleAnticiposTO.getAntEmpresa(),
                carCobrosDetalleAnticiposTO.getAntPeriodo(),
                carCobrosDetalleAnticiposTO.getAntTipo(),
                carCobrosDetalleAnticiposTO.getAntNumero())));
        return carCobrosDetalleAnticipos;
    }

    public static List<CarFunCobrosTO> convertirCarFunCobros_CarFunCobrosTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato4;
            try {
                dato4 = new BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = cero;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            Boolean dato6;
            try {
                dato6 = Boolean.valueOf(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            Boolean dato7;
            try {
                dato7 = Boolean.valueOf(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new CarFunCobrosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static List<CarFunCobrosDetalleTO> convertirCarFunCobrosDetalle_CarFunCobrosDetalleTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = cero;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            Boolean dato8;
            try {
                dato8 = Boolean.valueOf(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            Boolean dato9;
            try {
                dato9 = Boolean.valueOf(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            lista.add(new CarFunCobrosDetalleTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7, dato8, dato9));
        }
        return lista;
    }

    public static List<CarFunCobrosSaldoAnticipoTO> convertirCarFunCobrosSaldoAnticipo_CarFunCobrosSaldoAnticipoTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = cero;
            }
            lista.add(new CarFunCobrosSaldoAnticipoTO(dato1, dato2, dato3, dato4,
                    dato5, dato6));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PAGOS">
    public static CarPagos convertirCarPagosTO_CarPagos(CarPagosTO carPagosTO) throws Exception {
        CarPagos carPagos = new CarPagos();
        carPagos.setCarPagosPK(new CarPagosPK(
                carPagosTO.getUsrEmpresa(),
                carPagosTO.getPagPeriodo(),
                carPagosTO.getPagTipo(),
                carPagosTO.getPagNumero()));
        carPagos.setPagReversado(carPagosTO.getPagReversado());
        carPagos.setProvEmpresa(carPagosTO.getUsrEmpresa());
        carPagos.setProvCodigo(carPagosTO.getProvCodigo());
        carPagos.setUsrEmpresa(carPagosTO.getUsrEmpresa());
        carPagos.setUsrCodigo(carPagosTO.getUsrCodigo());
        carPagos.setUsrFechaInserta(Validacion.fechaString_Date(carPagosTO.getUsrFechaInserta()));
        return carPagos;
    }

    public static CarPagos convertirCarPagos_CarPagos(CarPagos carPagosAux) throws Exception {
        CarPagos carPagos = new CarPagos();
        carPagos.setCarPagosPK(carPagos.getCarPagosPK());
        carPagos.setPagReversado(carPagosAux.getPagReversado());
        carPagos.setProvEmpresa(carPagosAux.getUsrEmpresa());
        carPagos.setProvCodigo(carPagosAux.getProvCodigo());
        carPagos.setUsrEmpresa(carPagosAux.getUsrEmpresa());
        carPagos.setUsrCodigo(carPagosAux.getUsrCodigo());
        carPagos.setUsrFechaInserta(carPagosAux.getUsrFechaInserta());
        return carPagos;
    }

    public static CarPagosAnticipos convertirCarPagosAnticipos_CarPagosAnticipos(CarPagosAnticipos carPagosAnticiposAux) throws Exception {
        CarPagosAnticipos carPagosAnticipos = new CarPagosAnticipos();
        carPagosAnticipos.setCarPagosAnticiposPK(carPagosAnticipos.getCarPagosAnticiposPK());
        carPagosAnticipos.setAntValor(carPagosAnticiposAux.getAntValor());
        carPagosAnticipos.setAntPagado(carPagosAnticiposAux.getAntPagado());
        carPagosAnticipos.setAntReversado(carPagosAnticiposAux.getAntReversado());
        carPagosAnticipos.setFpSecuencial(carPagosAnticiposAux.getFpSecuencial());
        carPagosAnticipos.setProvEmpresa(carPagosAnticiposAux.getUsrEmpresa());
        carPagosAnticipos.setProvCodigo(carPagosAnticiposAux.getProvCodigo());
        carPagosAnticipos.setSecEmpresa(carPagosAnticiposAux.getSecEmpresa());
        carPagosAnticipos.setSecCodigo(carPagosAnticiposAux.getSecCodigo());
        carPagosAnticipos.setUsrEmpresa(carPagosAnticiposAux.getUsrEmpresa());
        carPagosAnticipos.setUsrCodigo(carPagosAnticiposAux.getUsrCodigo());
        carPagosAnticipos.setUsrFechaInserta(carPagosAnticiposAux.getUsrFechaInserta());
        return carPagosAnticipos;
    }

    public static CarPagosDetalleCompras convertirCarPagosDetalleComprasTO_CarPagosDetalleCompras(CarPagosDetalleComprasTO carPagosDetalleComprasTO) throws Exception {
        CarPagosDetalleCompras carPagosDetalleCompras = new CarPagosDetalleCompras();
        carPagosDetalleCompras.setDetSecuencial(carPagosDetalleComprasTO.getDetSecuencial());
        carPagosDetalleCompras.setDetValor(carPagosDetalleComprasTO.getDetValor());
        carPagosDetalleCompras.setCarPagos(
                new CarPagos(
                new CarPagosPK(
                carPagosDetalleComprasTO.getPagEmpresa(),
                carPagosDetalleComprasTO.getPagPeriodo(),
                carPagosDetalleComprasTO.getPagTipo(),
                carPagosDetalleComprasTO.getPagNumero())));
        carPagosDetalleCompras.setCompEmpresa(carPagosDetalleComprasTO.getCompEmpresa());
        carPagosDetalleCompras.setCompPeriodo(carPagosDetalleComprasTO.getCompPeriodo());
        carPagosDetalleCompras.setCompMotivo(carPagosDetalleComprasTO.getCompMotivo());
        carPagosDetalleCompras.setCompNumero(carPagosDetalleComprasTO.getCompNumero());
        carPagosDetalleCompras.setSecEmpresa(carPagosDetalleComprasTO.getCompEmpresa());
        carPagosDetalleCompras.setSecCodigo(carPagosDetalleComprasTO.getCompSecCodigo());
        return carPagosDetalleCompras;
    }

    public static CarPagosDetalleForma convertirCarPagosDetalleFormaTO_CarPagosDetalleForma(CarPagosDetalleFormaTO carPagosDetalleFormaTO) throws Exception {
        CarPagosDetalleForma carPagosDetalleForma = new CarPagosDetalleForma();
        carPagosDetalleForma.setDetSecuencial(0);
        carPagosDetalleForma.setDetValor(carPagosDetalleFormaTO.getDetValor());
        carPagosDetalleForma.setDetReferencia(carPagosDetalleFormaTO.getDetReferencia());
        carPagosDetalleForma.setDetObservaciones(carPagosDetalleFormaTO.getDetObservaciones());
        carPagosDetalleForma.setCarPagos(
                new CarPagos(
                new CarPagosPK(
                carPagosDetalleFormaTO.getPagEmpresa(),
                carPagosDetalleFormaTO.getPagPeriodo(),
                carPagosDetalleFormaTO.getPagMotivo(),
                carPagosDetalleFormaTO.getPagNumero())));
        carPagosDetalleForma.setFpSecuencial(new CarPagosForma(
                carPagosDetalleFormaTO.getFpSecuencial()));
        return carPagosDetalleForma;
    }

    public static cartera.entity.CarPagosDetalleAnticipos convertirCarPagosDetalleAnticiposTO_CarPagosDetalleAnticipos(cartera.TO.CarPagosDetalleAnticiposTO carPagosDetalleAnticiposTO) throws Exception {
        cartera.entity.CarPagosDetalleAnticipos carPagosDetalleAnticipos = new cartera.entity.CarPagosDetalleAnticipos();
        carPagosDetalleAnticipos.setDetSecuencial(0);
        carPagosDetalleAnticipos.setDetValor(carPagosDetalleAnticiposTO.getDetValor());
        carPagosDetalleAnticipos.setDetObservaciones(carPagosDetalleAnticiposTO.getDetObservaciones());
        carPagosDetalleAnticipos.setCarPagosAnticipos(
                new CarPagosAnticipos(
                new CarPagosAnticiposPK(
                carPagosDetalleAnticiposTO.getAntEmpresa(),
                carPagosDetalleAnticiposTO.getAntPeriodo(),
                carPagosDetalleAnticiposTO.getAntTipo(),
                carPagosDetalleAnticiposTO.getAntNumero())));
        return carPagosDetalleAnticipos;
    }

    public static List<CarComboPagosCobrosFormaTO> convertirCarComboPagosCobrosForma_CarComboPagosCobrosFormaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
     
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            Integer dato1;
            try {
                dato1 = Integer.valueOf(array[0].toString());
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
            Boolean dato4;
            try {
                dato4 = Boolean.parseBoolean(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            Boolean dato5;
            try {
                dato5 = Boolean.parseBoolean(array[2].toString());                
            } catch (Exception e) {                
                dato5 = null;
            }
            lista.add(new CarComboPagosCobrosFormaTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static List<CarListaPagosCobrosFormaTO> convertirCarListaPagosCobrosForma_CarListaPagosCobrosFormaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            Integer dato1;
            try {
                dato1 = Integer.valueOf(array[0].toString());
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
            Boolean dato5;
            try {
                dato5 = Boolean.valueOf(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new CarListaPagosCobrosFormaTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static CarListaPagosProveedorTO convertirCarListaPagosProveedor_CarListaPagosProveedorTO(List datos) {
        CarListaPagosProveedorTO carListaPagosProveedorTO = new CarListaPagosProveedorTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            Boolean dato7;
            try {
                dato7 = Boolean.valueOf(array[6].toString());
            } catch (Exception e) {
                dato7 = false;
            }
            carListaPagosProveedorTO.setProvCodigo(dato1);
            carListaPagosProveedorTO.setProvNombre(dato2);
            carListaPagosProveedorTO.setProvRuc(dato3);
            carListaPagosProveedorTO.setProvDireccion(dato4);
            carListaPagosProveedorTO.setProvObservaciones(dato5);
            carListaPagosProveedorTO.setConFecha(dato6);
            carListaPagosProveedorTO.setConAnulado(dato7);
        }
        return carListaPagosProveedorTO;
    }

    public static CarListaCobrosClienteTO convertirCarListaCobrosCliente_CarListaCobrosClienteTO(List datos) {
        CarListaCobrosClienteTO carListaCobrosClienteTO = new CarListaCobrosClienteTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            Boolean dato7;
            try {
                dato7 = Boolean.valueOf(array[6].toString());
            } catch (Exception e) {
                dato7 = false;
            }
            carListaCobrosClienteTO.setCliCodigo(dato1);
            carListaCobrosClienteTO.setCliNombre(dato2);
            carListaCobrosClienteTO.setCliRuc(dato3);
            carListaCobrosClienteTO.setCliDireccion(dato4);
            carListaCobrosClienteTO.setCliObservaciones(dato5);
            carListaCobrosClienteTO.setConFecha(dato6);
            carListaCobrosClienteTO.setConAnulado(dato7);
        }
        return carListaCobrosClienteTO;
    }

    public static List<CarListaPagosCobrosTO> convertirCarListaPagosCobros_CarListaPagosCobrosTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato9;
            try {
                dato9 = new BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = cero;
            }
            BigDecimal dato10;
            try {
                dato10 = new BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = cero;
            }
            BigDecimal dato11;
            try {
                dato11 = new BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = cero;
            }
            lista.add(new CarListaPagosCobrosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11));
        }
        return lista;
    }

    public static List<CarListaPagosCobrosTO> convertirCarListaPagosCobrosConsultaDetalle_CarListaPagosCobrosConsultaDetalleTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato8;
            try {
                dato8 = new BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = cero;
            }
            BigDecimal dato9;
            try {
                dato9 = new BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = cero;
            }
            BigDecimal dato10;
            try {
                dato10 = new BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = cero;
            }
            lista.add(new CarListaPagosCobrosTO(dato1, dato2, dato3, dato4, dato5, null, dato6, dato7, dato8, dato9, dato10));
        }
        return lista;
    }
    
    
      public static List<CarListaPagosCobrosDetalleFormaTO> convertirCarListaPagosCobrosDetalleForma_CarListaPagosCobrosDetalleFormaTO(List datos, boolean hayPostfechados) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion        
        
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
//            dfColumnas = {"Forma",   "Referencia",     "Valor",       "Observaciones"};
//            // =               {"Forma",    "Bacno",          "Cuenta",         "Fecha",                   "Referencia", "Valor", "Observaciones"};
            
            String forma;
            try {
                forma = array[0].toString();
            } catch (Exception e) {
                forma = null;
            }
            String  referencia;
            try {
                referencia = array[1].toString();
            } catch (Exception e) {
                referencia = null;
            } 
            
            BigDecimal valor;
            try {
                valor =  new BigDecimal(array[2].toString());
            } catch (Exception e) {
                valor = cero;
            }    
            
//             if(!hayPostfechados){                     
//                try {
//                    valor =  new BigDecimal(array[2].toString());
//                } catch (Exception e) {
//                    valor = cero;
//                }    
//            }else{                
//                try {
//                    valor =  new BigDecimal(array[2].toString());
//                } catch (Exception e) {
//                    valor = cero;
//                }   
//            } 
            String   observaciones;
            try {
                observaciones = array[3].toString();
            } catch (Exception e) {
                observaciones = null;
            }
            
            String ban_nombre;
            try {
                ban_nombre = array[4].toString();
            } catch (Exception e) {
                ban_nombre = null;
            }
            String cuenta;
            try {
                cuenta = array[5].toString();
            } catch (Exception e) {
                cuenta = null;
            }            
            String fecha;
            try {
                fecha = array[5].toString();
            } catch (Exception e) {
                fecha = null;
            }            
            lista.add(new CarListaPagosCobrosDetalleFormaTO(forma, referencia, valor, observaciones, ban_nombre, cuenta,fecha));
        }
        return lista;
    }
     
/*
    public static List<CarListaPagosCobrosDetalleFormaTO> convertirCarListaPagosCobrosDetalleForma_CarListaPagosCobrosDetalleFormaTO(List datos, boolean hayPostfechados) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion        
        
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
//            dfColumnas = {"Forma",   "Referencia",     "Valor",       "Observaciones"};
//            // =               {"Forma",    "Bacno",          "Cuenta",         "Fecha",                   "Referencia", "Valor", "Observaciones"};
            String dato1, dato2,  dato3,  dato4,  dato5, dato7;
            BigDecimal valor;
            
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }            
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            if(!hayPostfechados){                     
                try {
                    valor =  new BigDecimal(array[5].toString());
                } catch (Exception e) {
                    valor = cero;
                }    
            }else{                
                try {
                    valor =  new BigDecimal(array[5].toString());
                } catch (Exception e) {
                    valor = cero;
                }   
            }     
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }            
            lista.add(new CarListaPagosCobrosDetalleFormaTO(dato1, dato2, dato3, dato4, dato5, valor, dato7));
        }
        return lista;
    }*/
    public static List<CarListaPagosCobrosDetalleAnticipoTO> convertirCarListaPagosCobrosDetalleAnticipo_CarListaPagosCobrosDetalleAnticipoTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        /*
         ant_periodo, 
ant_tipo, 
ant_numero, 
con_contable.con_fecha,
car_cobros_detalle_anticipos.det_valor as valor
         */
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String ant_periodo;
            try {
                ant_periodo = array[0].toString();
            } catch (Exception e) {
                ant_periodo = null;
            }
            String ant_tipo;
            try {
                ant_tipo = array[1].toString();
            } catch (Exception e) {
                ant_tipo = null;
            }
            String ant_numero;
            try {
                ant_numero = array[2].toString();
            } catch (Exception e) {
                ant_numero = null;
            }
            String con_Fecha;
            try {
                con_Fecha = array[3].toString();
            } catch (Exception e) {
                con_Fecha = null;
            }
     
            BigDecimal valor;
            try {
                valor = new BigDecimal(array[4].toString());
            } catch (Exception e) {
                valor = cero;
            }
        
            lista.add(new CarListaPagosCobrosDetalleAnticipoTO(ant_periodo, ant_tipo, ant_numero, con_Fecha, valor));
        }
        return lista;
    }

    public static List<CarFunPagosTO> convertirCarFunPagos_CarFunPagosTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato4;
            try {
                dato4 = new BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = cero;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            Boolean dato6;
            try {
                dato6 = Boolean.valueOf(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            Boolean dato7;
            try {
                dato7 = Boolean.valueOf(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new CarFunPagosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static List<CarFunPagosPruebaTO> convertirCarFunPagosPrueba_CarFunPagosPruebaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato4;
            try {
                dato4 = new BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = cero;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            Boolean dato6;
            try {
                dato6 = Boolean.valueOf(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            Boolean dato7;
            try {
                dato7 = Boolean.valueOf(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new CarFunPagosPruebaTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static List<CarFunPagosDetalleTO> convertirCarFunPagosDetalle_CarFunPagosDetalleTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = cero;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            Boolean dato8;
            try {
                dato8 = Boolean.valueOf(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            Boolean dato9;
            try {
                dato9 = Boolean.valueOf(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            lista.add(new CarFunPagosDetalleTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7, dato8, dato9));
        }
        return lista;
    }

    public static List<CarFunPagosSaldoAnticipoTO> convertirCarFunPagosSaldoAnticipo_CarFunPagosSaldoAnticipoTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = cero;
            }
            lista.add(new CarFunPagosSaldoAnticipoTO(dato1, dato2, dato3, dato4,
                    dato5, dato6));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PAGOSFORMA">
    public static CarPagosForma convertirCarPagosFormaTO_CarPagosForma(CarPagosCobrosFormaTO carPagosFormaTO) throws Exception {
        CarPagosForma carPagosForma = new CarPagosForma();
        carPagosForma.setFpSecuencial(carPagosFormaTO.getFpSecuencial());
        carPagosForma.setFpDetalle(carPagosFormaTO.getFpDetalle());
        carPagosForma.setFpInactivo(carPagosFormaTO.getFpInactivo());
        carPagosForma.setSecEmpresa(carPagosFormaTO.getUsrEmpresa());
        carPagosForma.setSecCodigo(carPagosFormaTO.getSecCodigo());
        carPagosForma.setCtaEmpresa(carPagosFormaTO.getUsrEmpresa());
        carPagosForma.setCtaCodigo(carPagosFormaTO.getCtaCodigo());
        carPagosForma.setUsrEmpresa(carPagosFormaTO.getUsrEmpresa());
        carPagosForma.setUsrCodigo(carPagosFormaTO.getUsrCodigo());
        carPagosForma.setUsrFechaInserta(Validacion.fechaString_Date(carPagosFormaTO.getUsrFechaInserta()));
        return carPagosForma;
    }

    public static CarCobrosForma convertirCarCobrosFormaTO_CarCobrosForma(CarPagosCobrosFormaTO carPagosFormaTO) throws Exception {
        CarCobrosForma carCobrosForma = new CarCobrosForma();
        carCobrosForma.setFpSecuencial(carPagosFormaTO.getFpSecuencial());
        carCobrosForma.setFpDetalle(carPagosFormaTO.getFpDetalle());
        carCobrosForma.setFpInactivo(carPagosFormaTO.getFpInactivo());
        carCobrosForma.setSecEmpresa(carPagosFormaTO.getUsrEmpresa());
        carCobrosForma.setSecCodigo(carPagosFormaTO.getSecCodigo());
        carCobrosForma.setCtaEmpresa(carPagosFormaTO.getUsrEmpresa());
        carCobrosForma.setCtaCodigo(carPagosFormaTO.getCtaCodigo());
        carCobrosForma.setUsrEmpresa(carPagosFormaTO.getUsrEmpresa());
        carCobrosForma.setUsrCodigo(carPagosFormaTO.getUsrCodigo());
        carCobrosForma.setUsrFechaInserta(Validacion.fechaString_Date(carPagosFormaTO.getUsrFechaInserta()));
        return carCobrosForma;
    }
    // </editor-fold>

    public static cartera.TO.CarPagosCobrosAnticipoTO convertirCarPagosCobrosAnticipo_CarPagosCobrosAnticipoTO(List datos) {
        cartera.TO.CarPagosCobrosAnticipoTO carPagosCobrosAnticipoTO = new cartera.TO.CarPagosCobrosAnticipoTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            BigDecimal dato1;
            try {
                dato1 = new BigDecimal(array[0].toString());
            } catch (Exception e) {
                dato1 = cero;
            }
            Integer dato2;
            try {
                dato2 = Integer.valueOf(array[1].toString());
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            carPagosCobrosAnticipoTO.setAntValor(dato1);
            carPagosCobrosAnticipoTO.setFpSecuencial(dato2);
            carPagosCobrosAnticipoTO.setSecCodigo(dato3);
        }
        return carPagosCobrosAnticipoTO;
    }

    public static List<CarListaMayorAuxiliarClienteProveedorTO> convertirCarListaMayorAuxiliarClienteProveedor_CarListaMayorAuxiliarClienteProveedorTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = cero;
            }
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = cero;
            }
            BigDecimal dato8;
            try {
                dato8 = new BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = cero;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            Integer dato10;
            try {
                dato10 = Integer.valueOf(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            lista.add(new CarListaMayorAuxiliarClienteProveedorTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10));
        }
        return lista;
    }

    public static List<CarCuentasPorPagarCobrarDetalladoTO> convertirCarListaCuentasPorPagarDetallado_CarCuentasPorPagarDetalladoTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new CarCuentasPorPagarCobrarDetalladoTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static List<CarFunCuentasPorCobrarListadoVentasTO> convertirCarFunCuentasPorCobrarListadoVentas_CarFunCuentasPorCobrarListadoVentasTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new CarFunCuentasPorCobrarListadoVentasTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static List<CarFunCuentasPorPagarListadoComprasTO> convertirCarFunCuentasPorPagarListadoCompras_CarFunCuentasPorPagarListadoComprasTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new CarFunCuentasPorPagarListadoComprasTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static List<CarCuentasPorPagarCobrarGeneralTO> convertirCarListaCuentasPorPagarCobrarGeneral_CarCuentasPorPagarCobrarGeneralTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
            BigDecimal dato3;
            try {
                dato3 = new BigDecimal(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            lista.add(new CarCuentasPorPagarCobrarGeneralTO(dato1, dato2, dato3));
        }
        return lista;
    }

    private static String obtenerDatoString(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static List<CarCuentasPorPagarCobrarAnticiposTO> convertirCarListaCuentasPorPagarAnticipos_CarCuentasPorPagarAnticiposTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String dato1 = obtenerDatoString(array[0]);
            String dato2 = obtenerDatoString(array[1]);
            BigDecimal dato3 = new BigDecimal(obtenerDatoString(array[2]));
            BigDecimal dato4 = new BigDecimal(obtenerDatoString(array[3]));
            BigDecimal dato5 = new BigDecimal(obtenerDatoString(array[4]));

            lista.add(new CarCuentasPorPagarCobrarAnticiposTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static CarPagosAnticipos convertirCarPagosAnticiposTO_CarPagosAnticipos(CarPagosAnticipoTO carPagosAnticiposTO) throws Exception {
        CarPagosAnticipos carPagosAnticipos = new CarPagosAnticipos();
        carPagosAnticipos.setCarPagosAnticiposPK(new CarPagosAnticiposPK(carPagosAnticiposTO.getAntEmpresa(),
                carPagosAnticiposTO.getAntPeriodo(), carPagosAnticiposTO.getAntTipo(), carPagosAnticiposTO.getAntNumero()));
        carPagosAnticipos.setAntPagado(carPagosAnticiposTO.getAntPagado());
        carPagosAnticipos.setAntValor(carPagosAnticiposTO.getAntValor());
        carPagosAnticipos.setAntReversado(carPagosAnticiposTO.getAntReversado());
        carPagosAnticipos.setAntReversado(carPagosAnticiposTO.getAntReversado());
        carPagosAnticipos.setProvEmpresa(carPagosAnticiposTO.getProvEmpresa());
        carPagosAnticipos.setProvCodigo(carPagosAnticiposTO.getProvCodigo());
        carPagosAnticipos.setSecCodigo(carPagosAnticiposTO.getSecCodigo());
        carPagosAnticipos.setSecEmpresa(carPagosAnticiposTO.getSecEmpresa());
        carPagosAnticipos.setUsrCodigo(carPagosAnticiposTO.getUsrCodigo());
        carPagosAnticipos.setUsrEmpresa(carPagosAnticiposTO.getUsrEmpresa());
        carPagosAnticipos.setUsrFechaInserta(validaciones.Validacion.fecha(carPagosAnticiposTO.getUsrFechaInserta(), "yyyy-MM-dd"));
        return carPagosAnticipos;
    }

    public static CarCobrosAnticipos convertirCarCobrosAnticiposTO_CarCobrosAnticipos(CarCobrosAnticipoTO carCobrosAnticiposTO) throws Exception {
        CarCobrosAnticipos carCobrosAnticipos = new CarCobrosAnticipos();
        carCobrosAnticipos.setCarCobrosAnticiposPK(new CarCobrosAnticiposPK(carCobrosAnticiposTO.getAntEmpresa(),
                carCobrosAnticiposTO.getAntPeriodo(), carCobrosAnticiposTO.getAntTipo(), carCobrosAnticiposTO.getAntNumero()));
        carCobrosAnticipos.setAntCobrado(carCobrosAnticiposTO.getAntCobrado());
        carCobrosAnticipos.setAntValor(carCobrosAnticiposTO.getAntValor());
        carCobrosAnticipos.setCliEmpresa(carCobrosAnticiposTO.getCliEmpresa());
        carCobrosAnticipos.setCliCodigo(carCobrosAnticiposTO.getCliCodigo());
        carCobrosAnticipos.setSecCodigo(carCobrosAnticiposTO.getSecCodigo());
        carCobrosAnticipos.setSecEmpresa(carCobrosAnticiposTO.getSecEmpresa());
        carCobrosAnticipos.setUsrCodigo(carCobrosAnticiposTO.getUsrCodigo());
        carCobrosAnticipos.setUsrEmpresa(carCobrosAnticiposTO.getUsrEmpresa());
        carCobrosAnticipos.setUsrFechaInserta(validaciones.Validacion.fecha(carCobrosAnticiposTO.getUsrFechaInserta(), "yyyy-MM-dd"));
        return carCobrosAnticipos;
    }
}