/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.helper;


import banco.TO.BanFunChequesNoEntregadosTO;
import banco.TO.BanFunChequesNoRevisadosTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import validaciones.Validacion;

/**
 *
 * @author jack
 */
public class ConversionesBanco {
    private static java.math.BigDecimal cero = new java.math.BigDecimal("0.00");

    // <editor-fold defaultstate="collapsed" desc="CONVERSIONES BANCO">
    public static banco.entity.BanBanco convertirBanBancoTO_BanBanco(banco.TO.BanBancoTO banBancoTO) {
        banco.entity.BanBanco banBanco = new banco.entity.BanBanco();
        banBanco.setBanBancoPK(new banco.entity.BanBancoPK(banBancoTO.getEmpCodigo(), banBancoTO.getBanCodigo()));
        banBanco.setBanNombre(banBancoTO.getBanNombre());
        banBanco.setUsrEmpresa(banBancoTO.getEmpCodigo());
        banBanco.setUsrCodigo(banBancoTO.getUsrInsertaBanco());
        banBanco.setUsrFechaInserta(Validacion.fechaString_Date(banBancoTO.getUsrFechaInsertaBanco()));
        return banBanco;
    }
    
    public static banco.entity.BanConciliacion convertirBanConciliacionTO_BanConciliacion(banco.TO.BanConciliacionTO banConciliacionTO) {
        banco.entity.BanConciliacion banConciliacion = new banco.entity.BanConciliacion();
        banConciliacion.setBanConciliacionPK(new banco.entity.BanConciliacionPK(
                banConciliacionTO.getConcEmpresa(),
                banConciliacionTO.getConcCuentaContable(),
                banConciliacionTO.getConcCodigo()));
        banConciliacion.setConcHasta(Validacion.fecha(banConciliacionTO.getConcHasta(), "yyyy-MM-dd"));
        banConciliacion.setConcSaldoEstadoCuenta(banConciliacionTO.getConcSaldoEstadoCuenta());
        banConciliacion.setConcChequesGiradosYNoCobrados(banConciliacionTO.getConcChequesGiradosYNoCobrados());
        banConciliacion.setConcDepositosEnTransito(banConciliacionTO.getConcDepositosEnTransito());
        banConciliacion.setConcPendiente(banConciliacionTO.isConcPendiente());
        banConciliacion.setUsrEmpresa(banConciliacionTO.getConcEmpresa());
        banConciliacion.setUsrCodigo(banConciliacionTO.getUsrCodigo());
        banConciliacion.setUsrFechaInserta(Validacion.fechaString_Date(banConciliacionTO.getUsrFechaInserta()));
        return banConciliacion;
    }

    public static List<banco.TO.ListaBanBancoTO> convertirListaBanBanco_ListaBanBancoTO(List datos) {
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
            lista.add(new banco.TO.ListaBanBancoTO(dato1, dato2));
        }
        return lista;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONVERSIONES CAJA">
    public static banco.entity.BanCaja convertirBanCajaTO_BanCaja(banco.TO.BanCajaTO banCajaTO) {
        banco.entity.BanCaja banCaja = new banco.entity.BanCaja();
        banCaja.setBanCajaPK(new banco.entity.BanCajaPK(banCajaTO.getEmpCodigo(), banCajaTO.getCajaCodigo()));
//        banCaja.setCajaCuenta(banCajaTO.getCajaCuenta());
        banCaja.setCajaNombre(banCajaTO.getCajaNombre());
        banCaja.setCtaEmpresa(banCajaTO.getEmpCodigo());
        banCaja.setCtaCuentaContable(banCajaTO.getCajaCuenta());
        banCaja.setUsrEmpresa(banCajaTO.getEmpCodigo());
        banCaja.setUsrCodigo(banCajaTO.getUsrInsertaCaja());
        banCaja.setUsrFechaInserta(Validacion.fechaString_Date(banCajaTO.getUsrFechaInsertaCaja()));
        return banCaja;
    }

    public static List<banco.TO.ListaBanCajaTO> convertirListaBanCaja_ListaBanCajaTO(List datos) {
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
            lista.add(new banco.TO.ListaBanCajaTO(dato1, dato2, dato3));
        }
        return lista;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONSULTAS BANCO">
    public static List<banco.TO.BanComboBancoTO> convertirBanComboBanco_BanComboBancoTO(List datos) {
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
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            lista.add(new banco.TO.BanComboBancoTO(dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }
    public static List<banco.TO.BanListaConciliacionTO> convertirBanListaConciliacion_BanListaConciliacionTO(List datos) {
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = cero;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = cero;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = cero;
            }
            Boolean dato8;
            try {
                dato8 = Boolean.valueOf(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            lista.add(new banco.TO.BanListaConciliacionTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }
    public static List<banco.TO.BanListaConciliacionBancariaTO> convertirBanListaConciliacionBancaria_BanListaConciliacionBancariaTO(List datos) {
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
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = cero;
            }
            Boolean dato6;
            try {
                dato6 = Boolean.valueOf(array[5].toString());
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
            Character dato9;
            try {
                dato9 = array[8].toString().charAt(0);
            } catch (Exception e) {
                dato9 = null;
            }
            lista.add(new banco.TO.BanListaConciliacionBancariaTO(dato1, dato2, 
                    dato3, dato4, dato5, dato6, dato7, dato8, dato9));
        }
        return lista;
    }
    public static List<banco.TO.BanListaChequeTO> convertirBanListaCheque_BanListaChequeTO(List datos) {
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
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
            Boolean dato8;
            try {
                dato8 = Boolean.valueOf(array[7].toString());
            } catch (Exception e) {
                dato8 = false;
            }
            Boolean dato9;
            try {
                dato9 = Boolean.valueOf(array[8].toString());
            } catch (Exception e) {
                dato9 = false;
            }
            Boolean dato10;
            try {
                dato10 = Boolean.valueOf(array[9].toString());
            } catch (Exception e) {
                dato10 = false;
            }
            String dato11;
            try {
                dato11 = array[10].toString()+" | ";
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString()+" | ";
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            java.math.BigInteger dato14;
            try {
                dato14 = new java.math.BigInteger(array[13].toString());
            } catch (Exception e) {
                dato14 = null;
            }
            java.math.BigInteger dato15;
            try {
                dato15 = new java.math.BigInteger(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }
            lista.add(new banco.TO.BanListaChequeTO(dato1, dato2, dato3, dato4, 
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, 
                    dato13, dato14, dato15));
        }
        return lista;
    }
    public static List<banco.TO.BanComboCuentaTO> convertirBanComboCuentaTO_BanComboCuentaTO(List datos) {
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
            lista.add(new banco.TO.BanComboCuentaTO(dato1, dato2));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONVERSIONES CUENTA">
    public static banco.TO.BanChequeTO convertirBanCheque_BanChequeTO(List datos) {
        banco.TO.BanChequeTO banChequeTO = new banco.TO.BanChequeTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();){//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); 
            //Object[] array = (Object[]) obj;
            Long dato1;
            try {
                dato1 = new Long(array[0].toString());
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
                        
            Boolean dato6;
            try {
                dato6 = Boolean.valueOf(array[5].toString());
            } catch (Exception e) {
                dato6 = false;
            }
            Boolean dato7;
            try {
                dato7 = Boolean.valueOf(array[6].toString());
            } catch (Exception e) {
                dato7 = false;
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
                dato9 = false;
            }
            
            //S S B S
            
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
            
            Boolean dato12;
            try {
                dato12 = Boolean.valueOf(array[11].toString());
            } catch (Exception e) {
                dato12 = false;
            }
                                  
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            
            ///sbss
             String dato14;
            try {
                dato14 = array[13].toString();
            } catch (Exception e) {
                dato14 = null;
            }            
             Boolean dato15;
            try {
                dato15 = Boolean.valueOf(array[14].toString());
            } catch (Exception e) {
                dato15 = false;
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
            
            //bssb            
            Boolean dato18;
            try {
                dato18 = Boolean.valueOf(array[17].toString());
            } catch (Exception e) {
                dato18 = false;
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
             Boolean dato21;
            try {
                dato21 = Boolean.valueOf(array[20].toString());
            } catch (Exception e) {
                dato21 = false;
            }
            
            //sss
             String dato22;
            try {
                dato22 = array[21].toString();
            } catch (Exception e) {
                dato22 = null;
            }                        
            String dato23;
            try {
                dato23 = array[22].toString();
            } catch (Exception e) {
                dato23 = null;
            }
            String dato24;
            try {
                dato24 = array[23].toString();
            } catch (Exception e) {
                dato24 = null;
            }
            
             Long dato25;
            try {
                dato25 = new Long(array[24].toString());
            } catch (Exception e) {
                dato25 = null;
            }
          
            banChequeTO.setChqSecuencia(dato1);
            banChequeTO.setChqBeneficiario(dato2);
            banChequeTO.setChqCantidad(dato3);
            banChequeTO.setChqCiudad(dato4);
            banChequeTO.setChqFecha(dato5);
            banChequeTO.setChqCruzado(dato6);
            banChequeTO.setChqImpreso(dato7);
            banChequeTO.setChqImpresoFecha(dato8);
            banChequeTO.setChqRevisado(dato9);
            banChequeTO.setChqRevisadoFecha(dato10);
            banChequeTO.setChqRevisadoObservacion(dato11);
            banChequeTO.setChqEntregado(dato12);
            banChequeTO.setChqEntregadoFecha(dato13);
            banChequeTO.setChqEntregadoObservacion(dato14);
            banChequeTO.setChqReversado(dato15);
            banChequeTO.setChqReversadoFecha(dato16);
            banChequeTO.setChqReversadoObservacion(dato17);
            banChequeTO.setChqAnulado(dato18);
            banChequeTO.setChqAnuladooFecha(dato19);
            banChequeTO.setChqAnuladoObservacion(dato20);
            banChequeTO.setChqNoCheque(dato21);            
            banChequeTO.setConcEmpresa(dato22);
            banChequeTO.setConcCuentaContable(dato23);
            banChequeTO.setConcCodigo(dato24);
            banChequeTO.setDetSecuencia(dato25);
        }
        return banChequeTO;
    }
    
    public static banco.entity.BanCheque convertirBanChequeTO_BanCheque(banco.TO.BanChequeTO banChequeTO) {
        banco.entity.BanCheque banCheque = new banco.entity.BanCheque();

//        banCheque.setBanChequePK(new banco.entity.BanChequePK(
//                banChequeTO.getChqEmpresa(),
//                banChequeTO.getChqCuenta(),
//                banChequeTO.getChqNumero(),
//                banChequeTO.getCbDc()));

        banCheque.setChqCruzado(banChequeTO.isChqCruzado());
        banCheque.setChqNoEsCheque(banChequeTO.isChqNoCheque());        
        banCheque.setChqBeneficiario(banChequeTO.getChqBeneficiario());
        banCheque.setChqCantidad(banChequeTO.getChqCantidad());
        banCheque.setChqCiudad(banChequeTO.getChqCiudad());
        banCheque.setChqFecha(validaciones.Validacion.fecha(banChequeTO.getChqFecha(), "yyyy-MM-dd"));
        banCheque.setChqImpreso(banChequeTO.isChqImpreso());
        banCheque.setChqRevisado(banChequeTO.isChqRevisado());        
        banCheque.setChqEntregado(banChequeTO.isChqEntregado());
        banCheque.setChqEntregadoFecha(validaciones.Validacion.fecha(banChequeTO.getChqEntregadoFecha(), "yyyy-MM-dd"));
        banCheque.setChqEntregadoObservacion(banChequeTO.getChqEntregadoObservacion());
        banCheque.setChqSecuencia(banChequeTO.getChqSecuencia());
        banCheque.setDetSecuencia(banChequeTO.getDetSecuencia());
        banCheque.setConcCodigo(banChequeTO.getConcCodigo());
        banCheque.setConcCuentaContable(banChequeTO.getConcCuentaContable());
        banCheque.setConcEmpresa(banChequeTO.getConcEmpresa());
        banCheque.setChqImpresoFecha(validaciones.Validacion.fecha(banChequeTO.getChqImpresoFecha(), "yyyy-MM-dd"));
        banCheque.setChqRevisadoFecha(validaciones.Validacion.fecha(banChequeTO.getChqRevisadoFecha(), "yyyy-MM-dd"));
        banCheque.setChqRevisadoObservacion(banChequeTO.getChqRevisadoObservacion());        
        banCheque.setChqReversado(banChequeTO.isChqReversado());
        banCheque.setChqReversadoFecha(validaciones.Validacion.fecha(banChequeTO.getChqReversadoFecha(), "yyyy-MM-dd"));
        banCheque.setChqReversadoObservacion(banChequeTO.getChqReversadoObservacion());        
        banCheque.setChqAnulado(banChequeTO.getChqAnulado());
        banCheque.setChqAnuladoFecha(validaciones.Validacion.fecha(banChequeTO.getChqAnuladooFecha(), "yyyy-MM-dd"));
        banCheque.setChqAnuladoObservacion(banChequeTO.getChqAnuladoObservacion());
        
        return banCheque;
    }
    
    public static banco.entity.BanCheque convertirBanCheque_BanCheque(banco.entity.BanCheque banCheque) {
        banco.entity.BanCheque banChequeAux = new banco.entity.BanCheque();
        
        banChequeAux.setChqSecuencia(banCheque.getChqSecuencia());
        banChequeAux.setChqBeneficiario(banCheque.getChqBeneficiario());
        banChequeAux.setChqCantidad(banCheque.getChqCantidad());
        banChequeAux.setChqCiudad(banCheque.getChqCiudad());
        banChequeAux.setChqFecha(banCheque.getChqFecha());
        banChequeAux.setChqCruzado(banCheque.getChqCruzado());
        banChequeAux.setChqImpreso(banCheque.getChqImpreso());
        banChequeAux.setChqImpresoFecha(banCheque.getChqImpresoFecha());
        banChequeAux.setChqRevisado(banCheque.getChqRevisado());
        banChequeAux.setChqRevisadoFecha(banCheque.getChqRevisadoFecha());
        banChequeAux.setChqRevisadoObservacion(banCheque.getChqRevisadoObservacion());
        banChequeAux.setChqEntregado(banCheque.getChqEntregado());
        banChequeAux.setChqEntregadoFecha(banCheque.getChqEntregadoFecha());
        banChequeAux.setChqEntregadoObservacion(banCheque.getChqEntregadoObservacion());
        banChequeAux.setChqReversado(banCheque.getChqReversado());
        banChequeAux.setChqReversadoFecha(banCheque.getChqReversadoFecha());
        banChequeAux.setChqReversadoObservacion(banCheque.getChqReversadoObservacion());
        banChequeAux.setChqAnulado(banCheque.getChqAnulado());
        banChequeAux.setChqAnuladoFecha(banCheque.getChqAnuladoFecha());
        banChequeAux.setChqAnuladoObservacion(banCheque.getChqAnuladoObservacion());
        banChequeAux.setChqNoEsCheque(banCheque.getChqNoEsCheque());
        banChequeAux.setDetSecuencia(banCheque.getDetSecuencia());
        banChequeAux.setConcCodigo(banCheque.getConcCodigo());
        banChequeAux.setConcCuentaContable(banCheque.getConcCuentaContable());
        banChequeAux.setConcEmpresa(banCheque.getConcEmpresa());
        
        return banChequeAux;
    }

    public static banco.entity.BanCuenta convertirBanCuentaTO_BanCuenta(banco.TO.BanCuentaTO banCuentaTO) {
        banco.entity.BanCuenta banCuenta = new banco.entity.BanCuenta();
        banCuenta.setBanCuentaPK(new banco.entity.BanCuentaPK(banCuentaTO.getCtaEmpresa(), banCuentaTO.getCtaContable()));
//        banCuenta.setEmpCodigo(banCuentaTO.getEmpCodigo());
//        banCuenta.setBanCodigo(banCuentaTO.getBanCodigo());
//        banCuenta.setCtaSecuencia(banCuentaTO.getCtaSecuencia() == 0 ? 0 : banCuentaTO.getCtaSecuencia());
        banCuenta.setCtaNumero(banCuentaTO.getCtaNumero());
        banCuenta.setCtaTitular(banCuentaTO.getCtaTitular());
        banCuenta.setCtaOficial(banCuentaTO.getCtaOficial());
        banCuenta.setCtaFormatoCheque(banCuentaTO.getCtaFormatoCheque());
        
        banCuenta.setCtaCodigoBancario(banCuentaTO.getCtaCodigoBancario());
        banCuenta.setCtaPrefijoBancario(banCuentaTO.getCtaPrefijoBancario());
//        banCuenta.setCtaCuenta(banCuentaTO.getCtaCuenta());
        banCuenta.setUsrEmpresa(banCuentaTO.getCtaEmpresa());
        banCuenta.setUsrCodigo(banCuentaTO.getUsrInsertaCuenta());
        banCuenta.setUsrFechaInserta(Validacion.fechaString_Date(banCuentaTO.getUsrFechaInsertaCuenta()));
        return banCuenta;
    }

    public static List<banco.TO.ListaBanCuentaTO> convertirListaBanCuenta_ListaBanCuentaTO(List datos) {
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
            lista.add(new banco.TO.ListaBanCuentaTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }

    public static List<banco.TO.BanListaChequesNoImpresosTO> convertirListaChequesNoImpresos_ListaChequesNoImpresosTO(List datos) {
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
            }///
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
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
            java.math.BigInteger dato11;
            try {
                dato11 = new java.math.BigInteger(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            java.math.BigInteger dato12;
            try {
                dato12 = new java.math.BigInteger(array[9].toString());
            } catch (Exception e) {
                dato12 = null;
            }
            lista.add(new banco.TO.BanListaChequesNoImpresosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12));
        }
        return lista;
    }// </editor-fold>

    public static List<BanFunChequesNoEntregadosTO> convertirBanFunChequesNoEntregados_BanFunChequesNoEntregadosTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();){//clase iteracion(no todo se puede iterar, solo listas)
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
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
            Boolean dato9;
            try {
                dato9 = Boolean.valueOf(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            Boolean dato10;
            try {
                dato10 = Boolean.valueOf(array[9].toString());
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
            java.math.BigInteger dato14;
            try {
                dato14 = new java.math.BigInteger(array[13].toString());
            } catch (Exception e) {
                dato14 = null;
            }
            java.math.BigInteger dato15;
            try {
                dato15 = new java.math.BigInteger(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }
            lista.add(new BanFunChequesNoEntregadosTO(dato1, dato2, dato3, dato4, 
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, 
                    dato13, dato14, dato15));
        }
        return lista;
    }
    public static List<BanFunChequesNoRevisadosTO> convertirBanFunChequesNoRevisados_BanFunChequesNoRevisadosTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();){//clase iteracion(no todo se puede iterar, solo listas)
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
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
            Boolean dato9;
            try {
                dato9 = Boolean.valueOf(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            Boolean dato10;
            try {
                dato10 = Boolean.valueOf(array[9].toString());
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
            java.math.BigInteger dato14;
            try {
                dato14 = new java.math.BigInteger(array[13].toString());
            } catch (Exception e) {
                dato14 = null;
            }
            java.math.BigInteger dato15;
            try {
                dato15 = new java.math.BigInteger(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }
            lista.add(new BanFunChequesNoRevisadosTO(dato1, dato2, dato3, dato4, 
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, 
                    dato13, dato14, dato15));
        }
        return lista;
    }
    public static List<String> convertirCuentasContablesConsulta_CuentasContablesString(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();){//clase iteracion(no todo se puede iterar, solo listas)
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
    public static List<banco.TO.BanChequePreavisadoTO> convertirChequePreavisado_ChequePreavisadoTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();){//clase iteracion(no todo se puede iterar, solo listas)
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
            lista.add(new banco.TO.BanChequePreavisadoTO(dato1, dato2, dato3, dato4, dato5, dato6, 
                    dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, 
                    dato15, dato16, dato17, dato18, dato19));
        }
        if (lista.size() > 0){
            ((banco.TO.BanChequePreavisadoTO)lista.get(lista.size() - 1)).setChqFechaRevision(
                    ((banco.TO.BanChequePreavisadoTO)lista.get(lista.size() - 1)).getChqFechaRevision() == null ? 
                    validaciones.Validacion.fechaSistema("yyyy-MM-dd HH:mm:ss") : 
                    ((banco.TO.BanChequePreavisadoTO)lista.get(lista.size() - 1)).getChqFechaRevision());

            lista.add(new banco.TO.BanChequePreavisadoTO(
                    validaciones.Validacion.fechaSistema("yyyy"), 
                    validaciones.Validacion.fechaSistema("MM"), 
                    validaciones.Validacion.fechaSistema("dd"), 
                    validaciones.Validacion.fechaSistema("dd-MM-yyyy HH:mm:ss"), 
                    "", 
                    "", 
                    "", 
                    "", 
                    "", 
                    "", 
                    "", 
                    "", 
                    "", 
                    "", 
                    "", 
                    "", 
                    "", 
                    "", 
                    ""));
        }
        
        return lista;
    }
    
    public static banco.entity.BanPreavisos convertirBanPreavisosTO_BanPreavisos(List datos) {
        banco.entity.BanPreavisos banPreavisos = null;
        for (Iterator i$ = datos.iterator(); i$.hasNext();){//clase iteracion(no todo se puede iterar, solo listas)
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
            banPreavisos = new banco.entity.BanPreavisos();
            banPreavisos.setBanPreavisosPK(new banco.entity.BanPreavisosPK(
                    dato1,//banPreavisosTO.getPreEmpresa(),
                    dato2,//banPreavisosTO.getPreCuentaContable(),
                    dato3));//banPreavisosTO.getPreNombreArchivoGenerado()));
            banPreavisos.setPreFechaRevisionUltimoCheque(validaciones.Validacion.fecha(dato4, "yyyy-MM-dd HH:mm:ss"));//banPreavisosTO.getPreFechaRevisionUltimoCheque(), "yyyy-MM-dd HH:mm:ss"));
            banPreavisos.setUsrEmpresa(dato5);//banPreavisosTO.getUsrEmpresa());
            banPreavisos.setUsrCodigo(dato6);//banPreavisosTO.getUsrCodigo());
            banPreavisos.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(dato7));//banPreavisosTO.getUsrFechaInserta()));
        }
        return banPreavisos;
    }
    
    public static banco.entity.BanPreavisos convertirBanPreavisosTO_BanPreavisos(
            banco.TO.BanPreavisosTO banPreavisosTO) {
        
       banco.entity.BanPreavisos banPreavisos = new banco.entity.BanPreavisos();
       
       banPreavisos.setBanPreavisosPK(new banco.entity.BanPreavisosPK(
                banPreavisosTO.getPreEmpresa(),
                banPreavisosTO.getPreCuentaContable(),
                banPreavisosTO.getPreNombreArchivoGenerado()));
        
        banPreavisos.setPreFechaRevisionUltimoCheque(validaciones.Validacion.fecha(banPreavisosTO.getPreFechaRevisionUltimoCheque(), "yyyy-MM-dd HH:mm:ss"));
        banPreavisos.setUsrEmpresa(banPreavisosTO.getUsrEmpresa());
        banPreavisos.setUsrCodigo(banPreavisosTO.getUsrCodigo());
        banPreavisos.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(banPreavisosTO.getUsrFechaInserta()));
        return banPreavisos;
    }
}
