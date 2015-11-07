/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import validaciones.Validacion;

/**
 *
 * @author jack
 */
public class ConversionesCaja {
    private static java.math.BigDecimal cero = new java.math.BigDecimal("0.00");
    
    public static caja.entity.CajCaja convertirCajCajaTO_CajCaja(caja.TO.CajCajaTO cajCajaTO) {
        caja.entity.CajCaja cajCaja = new caja.entity.CajCaja();
        cajCaja.setCajCajaPK(new caja.entity.CajCajaPK(cajCajaTO.getCajaEmpresa(), cajCajaTO.getCajaCodigo()));
        cajCaja.setCajaNombre(cajCajaTO.getCajaNombre());
        cajCaja.setCajaUsuarioResponsable(cajCajaTO.getCajaUsuarioResponsable());        
        cajCaja.setCajaCertificadoFirmaDigitalNombre(cajCajaTO.getCajaCertificadoFirmaDigitalNombre());        
        cajCaja.setCajaCertificadoFirmaDigitalClave(cajCajaTO.getCajaCertificadoFirmaDigitalClave());        
        cajCaja.setCajaActiva(cajCajaTO.getCajaActiva());
        cajCaja.setPermisoEliminarFilas(cajCajaTO.getPermisoEliminarFilas());
        cajCaja.setPermisoCambiarPrecio(cajCajaTO.getPermisoCambiarPrecio());
        cajCaja.setPermisoAplicarDescuentos(cajCajaTO.getPermisoAplicarDescuentos());
        cajCaja.setPermisoCambiarFecha(cajCajaTO.getPermisoCambiarFecha());
        cajCaja.setPermisoCredito(cajCajaTO.getPermisoCredito());
        cajCaja.setPermisoMotivoPermitido(cajCajaTO.getPermisoMotivoPermitido());
        cajCaja.setPermisoBodegaPermitida(cajCajaTO.getPermisoBodegaPermitida());
        cajCaja.setPermisoDocumentoPermitido(cajCajaTO.getPermisoDocumentoPermitido());
        cajCaja.setPermisoSecuencialPermitido(cajCajaTO.getPermisoSecuencialPermitido());
        cajCaja.setPermisoFormaPagoPermitida(cajCajaTO.getPermisoFormaPagoPermitida());
        cajCaja.setPermisoPrecioPermitido(cajCajaTO.getPermisoPrecioPermitido());
        
        cajCaja.setUsrEmpresa(cajCajaTO.getUsrEmpresa());
        cajCaja.setUsrCodigo(cajCajaTO.getUsrCodigo());
        cajCaja.setUsrFechaInserta(Validacion.fecha(cajCajaTO.getUsrFechaInserta(), "yyyy-MM-dd"));
        
        return cajCaja;
    }
    public static caja.entity.CajVales convertirCajCajaValesTO_CajVales(caja.TO.CajCajaValesTO cajCajaValesTO) {
        caja.entity.CajValesConceptos cajValesConceptos = new 
                                    caja.entity.CajValesConceptos( new caja.entity.
                                    CajValesConceptosPK(cajCajaValesTO.getConcEmpresa(),cajCajaValesTO.getConcCodigo()));
        caja.entity.CajVales cajVales = new caja.entity.CajVales();
        cajVales.setCajValesPK(new caja.entity.CajValesPK(
                cajCajaValesTO.getValeEmpresa(), 
                cajCajaValesTO.getValePeriodo(), 
                cajCajaValesTO.getValeMotivo(), 
                cajCajaValesTO.getValeNumero()));// la clave pk
        cajVales.setCajValesConceptos(cajValesConceptos);
        cajVales.setValeBeneficiario(cajCajaValesTO.getValeBeneficiario());
        cajVales.setValeObservaciones(cajCajaValesTO.getValeObservaciones());
        cajVales.setValeAnulado(cajCajaValesTO.getValeAnulado());
        cajVales.setValeFecha(validaciones.Validacion.fecha(cajCajaValesTO.getValeFecha(),"yyyy-MM-dd"));
        cajVales.setUsrEmpresa(cajCajaValesTO.getUsrEmpresa());     
        cajVales.setValeValor(cajCajaValesTO.getValeValor());
        cajVales.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
        cajVales.setUsrCodigo(cajCajaValesTO.getUsrCodigo());
        return cajVales;
    }
    /*
     private String concEmpresa;
    private String concCodigo;
    private String concDetalle;--
    private String concInactivo;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;
     
     */
    
    public static caja.entity.CajValesConceptos convertirCajValesConceptosTO_cajValesConceptos(caja.TO.CajValesConceptoTO cajValesConceptosTO) {
        caja.entity.CajValesConceptos cajValesConceptos = new caja.entity.CajValesConceptos();
        cajValesConceptos.setCajValesConceptosPK(new caja.entity.CajValesConceptosPK(
                cajValesConceptosTO.getConcEmpresa(), 
                cajValesConceptosTO.getConcCodigo()));
        
        cajValesConceptos.setConcDetalle(cajValesConceptosTO.getConcDetalle());
        cajValesConceptos.setConcInactivo(cajValesConceptosTO.getConcInactivo());
        cajValesConceptos.setUsrEmpresa(cajValesConceptosTO.getUsrEmpresa());
        cajValesConceptos.setUsrCodigo(cajValesConceptosTO.getUsrCodigo());
        cajValesConceptos.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
        return cajValesConceptos;
    }
    
    public static List<caja.TO.CajCajaTO> convertirListaCajCaja_CajCajaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            /*
                caja_empresa character(7) NOT NULL,
                caja_codigo character(7) NOT NULL,
                caja_nombre character(15) NOT NULL,
                caja_usuario_responsable character(7) NOT NULL,
                caja_certificado_firma_digital_nombre character(500),
                caja_certificado_firma_digital_clave character(500),
                * 
                caja_activa boolean NOT NULL,
                permiso_eliminar_filas boolean NOT NULL,
                * 
                permiso_cambiar_precio boolean NOT NULL,
                permiso_aplicar_descuentos boolean NOT NULL,
                * 
                permiso_cambiar_fecha boolean NOT NULL,
                * 
                permiso_credito boolean NOT NULL,
                * 
                permiso_motivo_permitido character(7),
                * 
                permiso_bodega_permitida character(7),
                * 
                permiso_documento_permitido character(2) NOT NULL,
                * 
                permiso_secuencial_permitido character(7) NOT NULL,
                * 
                permiso_forma_pago_permitida character(50) NOT NULL,
                * 
                permiso_precio_permitido integer,
                * 
                usr_empresa character(7) NOT NULL,
                * 
                usr_codigo character(7) NOT NULL,
                * 
                usr_fecha_inserta timestamp without time zone NOT NULL,
             
             */
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String caja_empresa;
            try {
                caja_empresa = array[0].toString();
            } catch (Exception e) {
                caja_empresa = null;
            }
            String caja_codigo;
            try {
                caja_codigo = array[1].toString();
            } catch (Exception e) {
                caja_codigo = null;
            }
            String caja_nombre;
            try {
                caja_nombre = array[2].toString();
            } catch (Exception e) {
                caja_nombre = null;
            }            
            String caja_usuario_responsable;
            try {
                caja_usuario_responsable = array[3].toString();
            } catch (Exception e) {
                caja_usuario_responsable = null;
            }
            String caja_certificado_firma_digital_nombre;
            try {
                caja_certificado_firma_digital_nombre = array[4].toString();
            } catch (Exception e) {
                caja_certificado_firma_digital_nombre = null;
            }
            String caja_certificado_firma_digital_clave;
            try {
                caja_certificado_firma_digital_clave = array[5].toString();
            } catch (Exception e) {
                caja_certificado_firma_digital_clave = null;
            }
            Boolean caja_activa;
            try {
                caja_activa = Boolean.parseBoolean(array[6].toString());
            } catch (Exception e) {
                caja_activa = null;
            }

            Boolean permiso_eliminar_filas;
            try {
                permiso_eliminar_filas = Boolean.parseBoolean(array[7].toString());
            } catch (Exception e) {
                permiso_eliminar_filas = null;
            }
            Boolean permiso_cambiar_precio;
            try {
                permiso_cambiar_precio = Boolean.parseBoolean(array[8].toString());
            } catch (Exception e) {
                permiso_cambiar_precio = null;
            }
            Boolean permiso_aplicar_descuentos;
            try {
                permiso_aplicar_descuentos = Boolean.parseBoolean(array[9].toString());
            } catch (Exception e) {
                permiso_aplicar_descuentos = null;
            }
            Boolean permiso_cambiar_fecha;
            try {
                permiso_cambiar_fecha = Boolean.parseBoolean(array[10].toString());
            } catch (Exception e) {
                permiso_cambiar_fecha = null;
            }
            
            Boolean permiso_credito;
            try {
                permiso_credito = Boolean.parseBoolean(array[11].toString());
            } catch (Exception e) {
                permiso_credito = null;
            }

            String permiso_motivo_permitido;
            try {
                permiso_motivo_permitido = array[12].toString();
            } catch (Exception e) {
                permiso_motivo_permitido = null;
            }
            String permiso_bodega_permitida;
            try {
                permiso_bodega_permitida = array[13].toString();
            } catch (Exception e) {
                permiso_bodega_permitida = null;
            }
            String permiso_documento_permitido;
            try {
                permiso_documento_permitido = array[14].toString();
            } catch (Exception e) {
                permiso_documento_permitido = null;
            }
            String permiso_secuencial_permitido;
            try {
                permiso_secuencial_permitido = array[15].toString();
            } catch (Exception e) {
                permiso_secuencial_permitido = null;
            }            
            String permiso_forma_pago_permitida;
            try {
                permiso_forma_pago_permitida =  array[16].toString();
            } catch (Exception e) {
                permiso_forma_pago_permitida= null;
            }
            Integer permiso_precio_permitido;
            try {
                permiso_precio_permitido =  Integer.valueOf(array[17].toString());
            } catch (Exception e) {
                permiso_precio_permitido= null;
            }
             String usr_empresa;
            try {
                usr_empresa = array[18].toString();
            } catch (Exception e) {
                usr_empresa = null;
            }
            String usr_codigo;
            try {
                usr_codigo = array[19].toString();
            } catch (Exception e) {
                usr_codigo = null;
            }            
            String usr_fecha_inserta;
            try {
                usr_fecha_inserta = array[20].toString();
            } catch (Exception e) {
                usr_fecha_inserta = null;
            }                      
            lista.add(new caja.TO.CajCajaTO(
                    caja_empresa, 
                    caja_codigo, 
                    caja_nombre, 
                    caja_usuario_responsable,  
                    caja_certificado_firma_digital_nombre, 
                    caja_certificado_firma_digital_clave, 
                    caja_activa, 
                    permiso_eliminar_filas, 
                    permiso_cambiar_precio, 
                    permiso_aplicar_descuentos, 
                    permiso_cambiar_fecha, 
                    permiso_credito,
                    permiso_motivo_permitido, 
                    permiso_bodega_permitida, 
                    permiso_documento_permitido, 
                    permiso_secuencial_permitido, 
                    permiso_forma_pago_permitida,
                    permiso_precio_permitido,
                    usr_empresa,
                    usr_codigo,
                    usr_fecha_inserta));
        }
        return lista;
    }
    
    public static List<caja.TO.CajCajaComboTO> convertirListaCajCajaCombo_ListaCajCajaComboTO(List datos) {
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
            lista.add(new caja.TO.CajCajaComboTO(dato1, dato2));
        }
        return lista;
    }
    
    public static List<caja.TO.CajValesConceptosComboTO> convertirListaCajValesConceptosCombo_ListaCajValesConceptosComboTO(List datos) {
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
             Boolean dato4;
            try {
                dato4 = Boolean.parseBoolean(array[3].toString());
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
            lista.add(new caja.TO.CajValesConceptosComboTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }
    
    //  public static List<caja.TO.CajCajaTO> convertirListaCajCaja_CajCajaTO(List datos) {
    public static java.util.List<caja.TO.CajCajaValesTO> convertirCajCajaListaVales_CajCajaListaValesTO(List datos) {
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
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
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
            Boolean dato9;
            try {
                dato9 = Boolean.valueOf(array[8].toString());
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
            lista.add(new caja.TO.CajCajaValesTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14));
        }
        return lista;
    }
    
    public  static  caja.TO.CajCajaValesTO convertirCajCajaVales_CajCajaValesTO (java.util.List datos){
        
        caja.TO.CajCajaValesTO cajCajaValesTO = null;
        
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
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
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
            Boolean dato9;
            try {
                dato9 = Boolean.valueOf(array[8].toString());
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

            if(datos.isEmpty()){
                cajCajaValesTO = null;
            } else {
                cajCajaValesTO = new caja.TO.CajCajaValesTO (dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14);
            }
        }
        return cajCajaValesTO;
    }
    
    
     public  static  java.util.List<caja.TO.CajCuadreCajaTO> convertirCajCuadreCaja_CajCuadreCajaTO (java.util.List datos){
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
            Integer dato2;
            try {
                dato2 = new Integer (array[1].toString());
            } catch (Exception e) {
                dato2 = null;
            }
            
            BigDecimal dato3;
            try {
                dato3 = new BigDecimal(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            BigDecimal dato4;
            try {
                dato4 = new BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            BigDecimal dato5;
            try {
                dato5 = new BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
          
            lista.add(new caja.TO.CajCuadreCajaTO(dato1, dato2, dato3, dato4,dato5,dato6));
        }
        return lista;
    }
}
