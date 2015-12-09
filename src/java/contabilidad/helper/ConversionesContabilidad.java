/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.helper;

import cartera.TO.CarCuentasPorPagarCobrarSaldoAnticiposTO;
import contabilidad.TO.*;
import contabilidad.entity.ConContable;
import contabilidad.entity.ConContablePK;
import contabilidad.entity.ConCuentas;
import contabilidad.entity.ConCuentasFlujo;
import contabilidad.entity.ConCuentasFlujoPK;
import contabilidad.entity.ConCuentasPK;
import contabilidad.entity.ConDetalle;
import contabilidad.entity.ConEstructura;
import contabilidad.entity.ConTipo;
import contabilidad.entity.ConTipoPK;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import validaciones.Validacion;

/**
 *
 * @author jack
 */
public class ConversionesContabilidad {

    // <editor-fold defaultstate="collapsed" desc="CONVERSIONES DE TIPO CONTABLE">
    public static ConTipo convertirConTipoTO_ConTipo(ConTipoTO conTipoTO) {
        ConTipo conTipo = new ConTipo();
        conTipo.setConTipoPK(new ConTipoPK(conTipoTO.getEmpCodigo(), conTipoTO.getTipCodigo()));
        conTipo.setTipDetalle(conTipoTO.getTipDetalle());
        conTipo.setTipInactivo(conTipoTO.getTipInactivo());
        conTipo.setUsrCodigo(conTipoTO.getUsrInsertaTipo());
        conTipo.setUsrEmpresa(conTipoTO.getEmpCodigo());
        conTipo.setUsrFechaInserta(Validacion.fechaString_Date(conTipoTO.getFechaInsertaTipo()));
        return conTipo;
    }

    public static List<ConTipoTO> convertirListaConTipo_ListaConTipoTO(List datos) {
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
                dato5 = array[5].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[6].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            lista.add(new ConTipoTO(dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONVERSIONES DE CUENTA CONTABLE">
    public static ConCuentas convertirConCuentasTO_ConCuentas(ConCuentasTO conCuentasTO) {
        ConCuentas conCuentas = new ConCuentas();
        conCuentas.setConCuentasPK(new ConCuentasPK(conCuentasTO.getEmpCodigo(), conCuentasTO.getCuentaCodigo()));
        conCuentas.setCtaDetalle(conCuentasTO.getCuentaDetalle());
        conCuentas.setCtaActivo(conCuentasTO.getCuentaActivo());
        conCuentas.setUsrCodigo(conCuentasTO.getUsrInsertaCuenta());
        conCuentas.setUsrEmpresa(conCuentasTO.getEmpCodigo());
        conCuentas.setUsrFechaInserta(Validacion.fecha(conCuentasTO.getUsrFechaInsertaCuenta(), "yyyy-MM-dd"));
        return conCuentas;
    }

    public static ConCuentasFlujo convertirConCuentasFlujoTO_ConCuentasFlujo(ConCuentasFlujoTO conCuentasFlujoTO) {
        ConCuentasFlujo conCuentasFlujo = new ConCuentasFlujo();
        conCuentasFlujo.setConCuentasFlujoPK(new ConCuentasFlujoPK(conCuentasFlujoTO.getFluCodigo(), conCuentasFlujoTO.getCuentaCodigo()));
        conCuentasFlujo.setFluDetalle(conCuentasFlujoTO.getCuentaDetalle());
        conCuentasFlujo.setFluActivo(conCuentasFlujoTO.getCuentaActivo());
        conCuentasFlujo.setUsrCodigo(conCuentasFlujoTO.getUsrInsertaCuenta());
        conCuentasFlujo.setUsrEmpresa(conCuentasFlujoTO.getFluCodigo());
        conCuentasFlujo.setUsrFechaInserta(Validacion.fecha(conCuentasFlujoTO.getUsrFechaInsertaCuenta(), "yyyy-MM-dd"));
        return conCuentasFlujo;
    }

    public static contabilidad.entity.ConCuentasFlujoDetalle convertirConCuentasFlujoDetalleTO_ConCuentasFlujoDetalle(contabilidad.TO.ConCuentasFlujoDetalleTO conCuentasFlujoDetalleTO) {
        contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalle = new contabilidad.entity.ConCuentasFlujoDetalle();
        conCuentasFlujoDetalle.setConCuentasFlujoDetallePK(new contabilidad.entity.ConCuentasFlujoDetallePK(conCuentasFlujoDetalleTO.getFluEmpresa(), conCuentasFlujoDetalleTO.getCtaCodigo(), conCuentasFlujoDetalleTO.getDetDebitoCredito()));
        conCuentasFlujoDetalle.setConCuentas(new ConCuentas(new ConCuentasPK(conCuentasFlujoDetalleTO.getCtaEmpresa(), conCuentasFlujoDetalleTO.getCtaCodigo())));
        conCuentasFlujoDetalle.setConCuentasFlujo(new ConCuentasFlujo(new ConCuentasFlujoPK(conCuentasFlujoDetalleTO.getFluEmpresa(), conCuentasFlujoDetalleTO.getFluCodigo())));
        conCuentasFlujoDetalle.setDetCuentaFlujo(conCuentasFlujoDetalleTO.getDetCuentaFlujo());
        conCuentasFlujoDetalle.setUsrCodigo(conCuentasFlujoDetalleTO.getUsrCodigo());
        conCuentasFlujoDetalle.setUsrEmpresa(conCuentasFlujoDetalleTO.getUsrEmpresa());
        conCuentasFlujoDetalle.setUsrFechaInserta(Validacion.fecha(conCuentasFlujoDetalleTO.getUsrFechaInserta(), "yyyy-MM-dd"));
        return conCuentasFlujoDetalle;
    }

    public static List<ConCuentasTO> convertirListaConCuenta_ListaConCuentaTO(List datos) {
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
            lista.add(new ConCuentasTO(dato1, dato2));
        }
        return lista;
    }

    public static List<ConCuentasTO> convertirListaConCuentas_ListaConCuentasTO(List datos) {
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
                dato4 = Boolean.valueOf(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new ConCuentasTO(dato1, dato2, dato3, dato4, "", ""));
        }
        return lista;
    }

    public static List<contabilidad.TO.ConCuentasFlujoTO> convertirListaConCuentasFlujo_ListaConCuentasFlujoTO(List datos) {
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
                dato4 = Boolean.valueOf(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new ConCuentasFlujoTO(dato1, dato2, dato3, dato4, "", ""));
        }
        return lista;
    }

    public static List<contabilidad.TO.ConCuentasFlujoDetalleTO> convertirListaConCuentasFlujoDetalle_ListaConCuentasFlujoDetalleTO(List datos) {
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
            char dato3;
            try {
                dato3 = array[2].toString().charAt(0);
            } catch (Exception e) {
                dato3 = 'A';
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
            contabilidad.TO.ConCuentasFlujoDetalleTO nuevo = new contabilidad.TO.ConCuentasFlujoDetalleTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11);
            nuevo.setDetalleContable(dato12);
            nuevo.setDetalleFlujo(dato13);
            lista.add(nuevo);
        }
        return lista;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONVERSIONES DE INSERCION DE CONTABLE">
    public static ConContable convertirConContableTO_ConContable(ConContableTO conContableTO) {
        ConContable conContable = new ConContable();
        conContable.setConContablePK(new ConContablePK(conContableTO.getEmpCodigo(),
                conContableTO.getPerCodigo(), conContableTO.getTipCodigo(),
                conContableTO.getConNumero()));
        conContable.setConFecha(Validacion.fecha(conContableTO.getConFecha(), "yyyy-MM-dd"));
        conContable.setConPendiente(conContableTO.getConPendiente());
        conContable.setConBloqueado(conContableTO.getConBloqueado());
        conContable.setConAnulado(conContableTO.getConAnulado());
        conContable.setConGenerado(conContableTO.getConGenerado());
//        conContable.setConDctoOrigen(conContableTO.getConDocOrigen());
        conContable.setConConcepto(conContableTO.getConConcepto());
        conContable.setConDetalle(conContableTO.getConDetalle());
        conContable.setConObservaciones(conContableTO.getConObservaciones());
        conContable.setUsrCodigo(conContableTO.getUsrInsertaContable());
        conContable.setUsrEmpresa(conContableTO.getEmpCodigo());
        conContable.setUsrFechaInserta(Validacion.fechaString_Date(conContableTO.getUsrFechaInsertaContable()));
        return conContable;
    }

    public static ConContable convertirConContable_ConContable(ConContable conContableAux) {
        ConContable conContable = new ConContable();
        conContable.setConContablePK(conContableAux.getConContablePK());
        conContable.setConFecha(conContableAux.getConFecha());
        conContable.setConPendiente(conContableAux.getConPendiente());
        conContable.setConBloqueado(conContableAux.getConBloqueado());
        conContable.setConAnulado(conContableAux.getConAnulado());
        conContable.setConGenerado(conContableAux.getConGenerado());
        conContable.setConConcepto(conContableAux.getConConcepto());
        conContable.setConDetalle(conContableAux.getConDetalle());
        conContable.setConObservaciones(conContableAux.getConObservaciones());
        conContable.setUsrCodigo(conContableAux.getUsrCodigo());
        conContable.setUsrEmpresa(conContableAux.getUsrEmpresa());
        conContable.setUsrFechaInserta(conContableAux.getUsrFechaInserta());
        return conContable;
    }

    public static ConDetalle convertirConDetalle_ConDetalle(ConDetalle conDetalleAux) {
        ConDetalle conDetalle = new ConDetalle();
        conDetalle.setDetSecuencia(conDetalleAux.getDetSecuencia());
        conDetalle.setSecCodigo(conDetalleAux.getSecCodigo());
        conDetalle.setSecEmpresa(conDetalleAux.getSecEmpresa());
        conDetalle.setPisEmpresa(conDetalleAux.getPisEmpresa());
        conDetalle.setPisNumero(conDetalleAux.getPisNumero());
        conDetalle.setPisSector(conDetalleAux.getSecCodigo());
        conDetalle.setDetDocumento(conDetalleAux.getDetDocumento());
        conDetalle.setDetDebitoCredito(conDetalleAux.getDetDebitoCredito());
        conDetalle.setDetValor(conDetalleAux.getDetValor());
        conDetalle.setDetGenerado(conDetalleAux.getDetGenerado());
        conDetalle.setDetReferencia(conDetalleAux.getDetReferencia());
        conDetalle.setDetObservaciones(conDetalleAux.getDetObservaciones());
        conDetalle.setDetOrden(conDetalleAux.getDetOrden());
        return conDetalle;
    }

    public static ConDetalle convertirConDetalleTO_ConDetalle(ConDetalleTO conDetalleTO) {
        ConDetalle conDetalle = new ConDetalle();
        conDetalle.setDetSecuencia(conDetalleTO.getDetSecuencia() == 0 ? 0 : conDetalleTO.getDetSecuencia());
        conDetalle.setDetDocumento(conDetalleTO.getDetDocumento());
        conDetalle.setDetDebitoCredito(conDetalleTO.getDetDebitoCredito());
        conDetalle.setDetValor(conDetalleTO.getDetValor());
        conDetalle.setDetSaldo(BigDecimal.ZERO);
        conDetalle.setDetGenerado(conDetalleTO.getDetGenerado());
        conDetalle.setDetReferencia(conDetalleTO.getDetReferencia());
        conDetalle.setDetObservaciones(conDetalleTO.getDetObservaciones());
        conDetalle.setDetOrden(conDetalleTO.getDetOrden());
        conDetalle.setSecEmpresa(conDetalleTO.getEmpCodigo());
        conDetalle.setSecCodigo(conDetalleTO.getSecCodigo());
        conDetalle.setPisEmpresa(conDetalleTO.getEmpCodigo());
        conDetalle.setPisSector(conDetalleTO.getPisSector());
        conDetalle.setPisNumero(conDetalleTO.getPisNumero());
        return conDetalle;
    }

    public static ConDetalle convertirConFunContabilizarDetalleTO_ConDetalle(ConFunContabilizarComprasDetalleTO conDetalleTO) {
        ConDetalle conDetalle = new ConDetalle();
        conDetalle.setDetSecuencia(new Integer( conDetalleTO.getDetSecuencia() == 0 ? "0" : conDetalleTO.getDetSecuencia().toString()));
        conDetalle.setDetDocumento(conDetalleTO.getDetDocumento());
        conDetalle.setDetDebitoCredito(conDetalleTO.getDetDebitoCredito());
        conDetalle.setDetValor(conDetalleTO.getDetValor());
        conDetalle.setDetSaldo(conDetalleTO.getDetSaldo());
        conDetalle.setDetGenerado(conDetalleTO.getDetGenerado());
        conDetalle.setDetReferencia(conDetalleTO.getDetReferencia());
        conDetalle.setDetObservaciones(conDetalleTO.getDetObservaciones());
        conDetalle.setDetOrden(conDetalleTO.getDetOrden());
        conDetalle.setSecEmpresa(conDetalleTO.getSecEmpresa());
        conDetalle.setSecCodigo(conDetalleTO.getSecCodigo());
        conDetalle.setPisEmpresa(conDetalleTO.getPisEmpresa());
        conDetalle.setPisSector(conDetalleTO.getPisSector());
        conDetalle.setPisNumero(conDetalleTO.getPisNumero());
        conDetalle.setConContable(new ConContable(new ConContablePK(
                conDetalleTO.getConEmpresa(),
                conDetalleTO.getConPeriodo(), 
                conDetalleTO.getConTipo(),
                conDetalleTO.getConNumero())));
        System.out.println("conDetalleTO.getCtaEmpresa()   "+conDetalleTO.getCtaEmpresa());
        System.out.println("conDetalleTO.getCtaCodigo()   "+conDetalleTO.getCtaCodigo());
        conDetalle.setConCuentas(new ConCuentas(new ConCuentasPK(conDetalleTO.getCtaEmpresa(), conDetalleTO.getCtaCodigo())));
        return conDetalle;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="CONVERSIONES DE ESTRUCTURA CONTABLE">
    public static ConEstructura convertirConEstructuraTO_ConEstructura(ConEstructuraTO conEstructuraTO) {
        ConEstructura conEstructura = new ConEstructura();
        conEstructura.setEmpCodigo(conEstructuraTO.getEmpCodigo());
        conEstructura.setEstGrupo1(conEstructuraTO.getEstGrupo1());
        conEstructura.setEstGrupo2(conEstructuraTO.getEstGrupo2());
        conEstructura.setEstGrupo3(conEstructuraTO.getEstGrupo3());
        conEstructura.setEstGrupo4(conEstructuraTO.getEstGrupo4());
        conEstructura.setEstGrupo5(conEstructuraTO.getEstGrupo5());
        conEstructura.setEstGrupo6(conEstructuraTO.getEstGrupo6());

        return conEstructura;
    }

    public static List<ConEstructuraTO> convertirListaConEstructura_ListaConEstructuraTO(List datos) {
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
            Short dato2;
            try {
                dato2 = new Short(array[1].toString());
            } catch (Exception e) {
                dato2 = null;
            }
            Short dato3;
            try {
                dato3 = new Short(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            Short dato4;
            try {
                dato4 = new Short(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            Short dato5;
            try {
                dato5 = new Short(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            Short dato6;
            try {
                dato6 = new Short(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            Short dato7;
            try {
                dato7 = new Short(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new ConEstructuraTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static List<contabilidad.TO.ConEstructuraFlujoTO> convertirListaConEstructuraFlujo_ListaConEstructuraFlujoTO(List datos) {
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
            Short dato2;
            try {
                dato2 = new Short(array[1].toString());
            } catch (Exception e) {
                dato2 = null;
            }
            Short dato3;
            try {
                dato3 = new Short(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            Short dato4;
            try {
                dato4 = new Short(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            Short dato5;
            try {
                dato5 = new Short(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            Short dato6;
            try {
                dato6 = new Short(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            Short dato7;
            try {
                dato7 = new Short(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new contabilidad.TO.ConEstructuraFlujoTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static List<ListaConContableTO> convertirListaBusquedaConContable_ListaBusquedaConContableTO(List datos) {
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
            lista.add(new ListaConContableTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11));
        }
        return lista;
    }

    public static java.util.List<contabilidad.TO.InvListaConsultaConsumosTO> convertirInvListaConsultaConsumosPendientes_InvListaConsultaConsumosTO(java.util.List datos) {
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


            lista.add(new contabilidad.TO.InvListaConsultaConsumosTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static List<ConContableTO> convertirListaConContable_ListaConContableTO(List datos) {
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
            lista.add(new ConContableTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14));
        }
        return lista;
    }
//    public static List<ConDetalleTO> convertirListaConDetalle_ListaConDetalleTO(List datos) {
//        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
//        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
//            Object obj = i$.next();
//            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
//            String dato1;
//            try {
//                dato1 = array[0].toString();
//            } catch (Exception e) {
//                dato1 = null;
//            }
//            String dato2;
//            try {
//                dato2 = array[1].toString();
//            } catch (Exception e) {
//                dato2 = null;
//            }
//            String dato3;
//            try {
//                dato3 = array[2].toString();
//            } catch (Exception e) {
//                dato3 = null;
//            }
//            String dato4;
//            try {
//                dato4 = array[3].toString();
//            } catch (Exception e) {
//                dato4 = null;
//            }
//            Integer dato5;
//            try {
//                dato5 = new Integer(array[4].toString());
//            } catch (Exception e) {
//                dato5 = null;
//            }
//            String dato6;
//            try {
//                dato6 = array[5].toString();
//            } catch (Exception e) {
//                dato6 = null;
//            }
//            String dato7;
//            try {
//                dato7 = array[6].toString();
//            } catch (Exception e) {
//                dato7 = null;
//            }
//            String dato8;
//            try {
//                dato8 = array[7].toString();
//            } catch (Exception e) {
//                dato8 = null;
//            }
//            String dato9;
//            try {
//                dato9 = array[8].toString();
//            } catch (Exception e) {
//                dato9 = null;
//            }
//            Character dato10;
//            try {
//                dato10 = new Character(array[9].toString().charAt(0));
//            } catch (Exception e) {
//                dato10 = null;
//            }
//            BigDecimal dato11;
//            try {
//                dato11 = new BigDecimal(array[10].toString());
//            } catch (Exception e) {
//                dato11 = null;
//            }
//            Boolean dato12;
//            try {
//                dato12 = Boolean.valueOf(array[11].toString());
//            } catch (Exception e) {
//                dato12 = null;
//            }
//            String dato13;
//            try {
//                dato13 = array[11].toString();
//            } catch (Exception e) {
//                dato13 = null;
//            }
//            Integer dato14;
//            try {
//                dato14 = Integer.valueOf(array[11].toString());
//            } catch (Exception e) {
//                dato14 = null;
//            }
//            lista.add(new ConDetalleTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14));
//        }
//        return lista;
//    }

    public static List<ConDetalleTablaTO> convertirListaConDetalleTabla_ListaConDetalleTablaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String ctaCodigo;
            try {
                ctaCodigo = array[0].toString();
            } catch (Exception e) {
                ctaCodigo = null;
            }
            String ctaDetalle;
            try {
                ctaDetalle = array[1].toString();
            } catch (Exception e) {
                ctaDetalle = null;
            }
            String secCodigo;
            try {
                secCodigo = array[2].toString();
            } catch (Exception e) {
                secCodigo = null;
            }
            String pisNumero;
            try {
                pisNumero = array[3].toString();
            } catch (Exception e) {
                pisNumero = null;
            }
            String detDocumento;
            try {
                detDocumento = array[4].toString();
            } catch (Exception e) {
                detDocumento = null;
            }
            Character detDebitoCredito;
            try {
                detDebitoCredito = array[5].toString().charAt(0);
            } catch (Exception e) {
                detDebitoCredito = null;
            }

            java.math.BigDecimal detValor;
            try {
                detValor = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                detValor = null;
            }
            String detObservaciones;
            try {
                detObservaciones = array[7].toString();
            } catch (Exception e) {
                detObservaciones = null;
            }
            Integer detSecuencia;
            try {
                detSecuencia = new Integer(array[8].toString());
            } catch (Exception e) {
                detSecuencia = null;
            }
            Boolean detGenerado;
            try {
                detGenerado = Boolean.parseBoolean(array[9].toString());
            } catch (Exception e) {
                detGenerado = null;
            }
            String det_referencia;
            try {
                det_referencia = array[10].toString();
            } catch (Exception e) {
                det_referencia = null;
            }

            lista.add(new ConDetalleTablaTO(ctaCodigo, ctaDetalle, secCodigo, pisNumero, detDocumento, detDebitoCredito, detValor, detObservaciones, detSecuencia, detGenerado, det_referencia));
        }
        return lista;
    }

    public static List<contabilidad.TO.ConBalanceGeneralComparativoTO> convertirListaConBalanceGeneralComparativo_ListaConBalanceGeneralComparativoTO(List datos) {
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
            BigDecimal dato4;
            try {
                dato4 = new BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new contabilidad.TO.ConBalanceGeneralComparativoTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static List<contabilidad.TO.ConFunBalanceResultadosNecTO> convertirConFunBalanceResultadosNec_ConFunBalanceResultadosNecTOs(List datos) {
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
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            BigDecimal dato8;
            try {
                dato8 = new BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            lista.add(new contabilidad.TO.ConFunBalanceResultadosNecTO(dato1,
                    dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }

    public static List<contabilidad.TO.ConFunBalanceGeneralNecTO> convertirConFunBalanceGeneralNec_ConFunBalanceGeneralNecTOs(List datos) {
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
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            BigDecimal dato8;
            try {
                dato8 = new BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            lista.add(new contabilidad.TO.ConFunBalanceGeneralNecTO(dato1,
                    dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }

    public static List<ConBalanceGeneralTO> convertirListaConBalanceGeneral_ListaConBalanceGeneralTO(List datos) {
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
            lista.add(new ConBalanceGeneralTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static List<ConBalanceComprobacionTO> convertirListaConBalanceComprobacion_ListaConBalanceComprobacionTO(List datos) {
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
            lista.add(new ConBalanceComprobacionTO(dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }

    public static List<ConBalanceResultadoTO> convertirListaConBalanceResultado_ListaConBalanceResultadoTO(List datos) {
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
            lista.add(new ConBalanceResultadoTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static List<ConMayorAuxiliarTO> convertirListaConMayorAuxiliar_ListaConMayorAuxiliarTO(List datos) {
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
            Integer dato3;
            try {
                dato3 = new Integer(array[2].toString());
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
                dato8 = null;
            }
            BigDecimal dato9;
            try {
                dato9 = new BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            BigDecimal dato10;
            try {
                dato10 = new BigDecimal(array[9].toString());
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
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            Integer dato14;
            try {
                dato14 = new Integer(array[13].toString());
            } catch (Exception e) {
                dato14 = null;
            }
            lista.add(new ConMayorAuxiliarTO(dato1, dato2, dato3, dato4, dato5,
                    dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13,
                    dato14));
        }
        return lista;
    }

    public static List<ConMayorAuxiliarTO> convertirListaConMayorAuxiliarMultiple_ListaConMayorAuxiliarMultipleTO(List datos) {
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
            Integer dato3;
            try {
                dato3 = new Integer(array[2].toString());
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
                dato8 = null;
            }
            BigDecimal dato9;
            try {
                dato9 = new BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            BigDecimal dato10;
            try {
                dato10 = new BigDecimal(array[9].toString());
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
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            Integer dato14;
            try {
                dato14 = new Integer(array[13].toString());
            } catch (Exception e) {
                dato14 = null;
            }
            lista.add(new ConMayorAuxiliarTO(dato1, dato2, dato3, dato4, dato5,
                    dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13,
                    dato14));
        }
        return lista;
    }

    public static List<ConMayorGeneralTO> convertirListaConMayorGeneral_ListaConMayorGeneralTO(List datos) {
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
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            BigDecimal dato8;
            try {
                dato8 = new BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            lista.add(new ConMayorGeneralTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }

    public static List<ConDiarioAuxiliarTO> convertirListaConDiarioAuxiliar_ListaDiarioAuxiliarTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            Integer dato1;
            try {
                dato1 = new Integer(array[0].toString());
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
            BigDecimal dato8;
            try {
                dato8 = new BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            lista.add(new ConDiarioAuxiliarTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9));
        }
        return lista;
    }

    // </editor-fold>
    public static List<contabilidad.TO.ConNumeracionTO> convertirListaConNumeracion_ListaConNumeracionTO(List datos) {
        List lista = new ArrayList(1);
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
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
            Integer dato4;
            try {
                dato4 = Integer.parseInt(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new contabilidad.TO.ConNumeracionTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    // <editor-fold defaultstate="collapsed" desc="CONSULTAS">
    public static java.util.List<contabilidad.TO.ConListaBalanceResultadosVsInventarioTO> convertirConListaBalanceResultadosVsInventario_ConListaBalanceResultadosVsInventarioTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
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

            lista.add(new contabilidad.TO.ConListaBalanceResultadosVsInventarioTO(
                    dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static java.util.List<contabilidad.TO.ConBalanceResultadosMensualizadosTO> convertirConListaBalanceResultadoMensualizado_ConListaBalanceResultadoMensualizado(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
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
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new contabilidad.TO.ConBalanceResultadosMensualizadosTO(
                    dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static java.util.List<contabilidad.TO.ConFunContablesVerificacionesTO> convertirConFunContablesVerificaciones_ConFunContablesVerificacionesTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
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
            Boolean dato5;
            try {
                dato5 = Boolean.parseBoolean(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            Boolean dato6;
            try {
                dato6 = Boolean.parseBoolean(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            Boolean dato7;
            try {
                dato7 = Boolean.parseBoolean(array[6].toString());
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
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            lista.add(new contabilidad.TO.ConFunContablesVerificacionesTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10));
        }
        return lista;
    }
    // </editor-fold>

    public static java.util.List<contabilidad.TO.ConFunContabilizarTransferenciasTO> convertirConFunContabilizarTransferenciasTO_ConFunContabilizarTransferenciasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
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
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            lista.add(new contabilidad.TO.ConFunContabilizarTransferenciasTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }

    public static List<ConDetalleTO> convertirConDetalle_ConDetalleTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String con_empresa;
            try {
                con_empresa = array[0].toString();
            } catch (Exception e) {
                con_empresa = null;
            }
            String con_periodo;
            try {
                con_periodo = array[1].toString();
            } catch (Exception e) {
                con_periodo = null;
            }
            String con_tipo;
            try {
                con_tipo = array[2].toString();
            } catch (Exception e) {
                con_tipo = null;
            }
            String con_numero;
            try {
                con_numero = array[3].toString();
            } catch (Exception e) {
                con_numero = null;
            }
            Integer det_secuencia;
            try {
                det_secuencia = Integer.parseInt(array[4].toString());
            } catch (Exception e) {
                det_secuencia = null;
            }
            String cta_codigo;
            try {
                cta_codigo = array[5].toString();
            } catch (Exception e) {
                cta_codigo = null;
            }

            String sec_codigo;
            try {
                sec_codigo = array[6].toString();
            } catch (Exception e) {
                sec_codigo = null;
            }
            String pis_sector;
            try {
                pis_sector = array[7].toString();
            } catch (Exception e) {
                pis_sector = null;
            }
            String pis_numero;
            try {
                pis_numero = array[8].toString();
            } catch (Exception e) {
                pis_numero = null;
            }
            String det_documento;
            try {
                det_documento = array[9].toString();
            } catch (Exception e) {
                det_documento = null;
            }
            Character det_debito_credito;
            try {
                det_debito_credito = array[10].toString().charAt(0);
            } catch (Exception e) {
                det_debito_credito = null;
            }
            BigDecimal det_valor;
            try {
                det_valor = new BigDecimal(array[11].toString());
            } catch (Exception e) {
                det_valor = null;
            }
            Boolean det_generado;
            try {
                det_generado = Boolean.parseBoolean(array[12].toString());
            } catch (Exception e) {
                det_generado = null;
            }
            String det_referencia;
            try {
                det_referencia = array[13].toString();
            } catch (Exception e) {
                det_referencia = null;
            }
            String det_observaciones;
            try {
                det_observaciones = array[14].toString();
            } catch (Exception e) {
                det_observaciones = null;
            }
            Integer det_orden;
            try {
                det_orden = Integer.parseInt(array[15].toString());
            } catch (Exception e) {
                det_orden = null;
            }
            lista.add(new ConDetalleTO(con_empresa, con_periodo, con_tipo, con_numero, det_secuencia, cta_codigo, sec_codigo, pis_sector, pis_numero, det_documento, det_debito_credito, det_valor, det_generado, det_referencia, det_observaciones, det_orden, new BigDecimal("0.00")));
        }
        return lista;
    }

    /*
     * public static contabilidad.entity.ConCuentasFlujo
     * convertirConCuentasFlujoTO_ConCuentasFlujo(contabilidad.TO.ConCuentasFlujoTO
     * conCuentasFlujoTO) { contabilidad.entity.ConCuentasFlujo conCuentasFlujo
     * = new contabilidad.entity.ConCuentasFlujo();
     * conCuentasFlujo.setConCuentasFlujoPK(new
     * contabilidad.entity.ConCuentasFlujoPK(conCuentasFlujoTO.getCtaEmpresa(),
     * conCuentasFlujoTO.getCtaCodigo()));
     * conCuentasFlujo.setUsrCodigo(conCuentasFlujoTO.getUsrInsertaCuenta());
     * conCuentasFlujo.setUsrEmpresa(conCuentasFlujoTO.getUsrEmpresa());
     * conCuentasFlujo.setUsrFechaInserta(validaciones.Validacion.fecha(conCuentasFlujoTO.getUsrFechaInsertaCuenta(),
     * "yyyy-MM-dd HH:mm:ss")); return conCuentasFlujo; }
     */
    public static List<ConBalanceResultadoCierreTO> convertirConBalanceResultadoCierre_ConBalanceResultadoCierreTO(List datos) {
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
            Character dato2;
            try {
                dato2 = array[1].toString().charAt(0);
            } catch (Exception e) {
                dato2 = null;
            }
            java.math.BigDecimal dato3;
            try {
                dato3 = new java.math.BigDecimal(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            Integer dato4;
            try {
                dato4 = Integer.parseInt(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }

            lista.add(new ConBalanceResultadoCierreTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static List<ConCuentasTO> convertirConCuentas_ConCuentasTO(List datos) {
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


            lista.add(new ConCuentasTO(dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }

    public static List<CarCuentasPorPagarCobrarSaldoAnticiposTO> convertirCuentasPorPagarCobrarSaldoAnticipos_CuentasPorCobrarSaldoAnticiposTO(List datos) {
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

            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
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

            lista.add(new CarCuentasPorPagarCobrarSaldoAnticiposTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }

    public static java.util.List<contabilidad.TO.ConFunContablesVerificacionesComprasTO> convertirConFunContablesVerificacionesCompras_ConFunContablesVerificacionesComprasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //private String contabilidadFecha;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            // private String contabilidadSecuencial;
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            //private String inventarioFecha;
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            // private String inventarioSecuencial;
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            // private BigDecimal inventarioMonto;
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            //  private String inventario_observacion;
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            lista.add(new contabilidad.TO.ConFunContablesVerificacionesComprasTO(
                    dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }

    public static java.util.List<contabilidad.TO.ConFunContabilizarComprasDetalleTO> convertirgetConFunContabilizarComprasDetalle_ConFunContabilizarComprasDetalleTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion

        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();

            Long detSecuencia;
            try {
                detSecuencia = Long.parseLong(array[0].toString());
            } catch (Exception e) {
                detSecuencia = null;
            }

            String dertDocumento;
            try {
                dertDocumento = array[1].toString();
            } catch (Exception e) {
                dertDocumento = null;
            }

            char detDebitoCredito;
            try {
                detDebitoCredito = array[2].toString().charAt(0);
            } catch (Exception e) {
                detDebitoCredito = ' ';
            }

            java.math.BigDecimal detValor;
            try {
                detValor = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                detValor = null;
            }
            java.math.BigDecimal detSaldo;
            try {
                detSaldo = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                detSaldo = null;
            }
            //  private String inventario_observacion;
            Boolean detGenerado;
            try {
                detGenerado = Boolean.parseBoolean(array[5].toString());
            } catch (Exception e) {
                detGenerado = null;
            }
            String detReferencia;
            try {
                detReferencia = array[6].toString();
            } catch (Exception e) {
                detReferencia = null;
            }
            String detObservaciones;
            try {
                detObservaciones = array[7].toString();
            } catch (Exception e) {
                detObservaciones = null;
            }
            Integer detOrden;
            try {
                detOrden = Integer.parseInt(array[8].toString());
            } catch (Exception e) {
                detOrden = null;
            }
            String secEmpresa;
            try {
                secEmpresa = array[9].toString();
            } catch (Exception e) {
                secEmpresa = null;
            }
            String secCodigo;
            try {
                secCodigo = array[10].toString();
            } catch (Exception e) {
                secCodigo = null;
            }
            String pisEmpresa;
            try {
                pisEmpresa = array[11].toString();
            } catch (Exception e) {
                pisEmpresa = null;
            }
            String pisSector;
            try {
                pisSector = array[12].toString();
            } catch (Exception e) {
                pisSector = null;
            }
            String pisNumero;
            try {
                pisNumero = array[13].toString();
            } catch (Exception e) {
                pisNumero = null;
            }
            String conEmpresa;
            try {
                conEmpresa = array[14].toString();
            } catch (Exception e) {
                conEmpresa = null;
            }
            String conPeriodo;
            try {
                conPeriodo = array[15].toString();
            } catch (Exception e) {
                conPeriodo = null;
            }
            String conTipo;
            try {
                conTipo = array[16].toString();
            } catch (Exception e) {
                conTipo = null;
            }
            String conNumero;
            try {
                conNumero = array[17].toString();
            } catch (Exception e) {
                conNumero = null;
            }
            String ctaEmpresa;
            try {
                ctaEmpresa = array[18].toString();
            } catch (Exception e) {
                ctaEmpresa = null;
            }
            String ctaCodigo;
            try {
                ctaCodigo = array[19].toString();
            } catch (Exception e) {
                ctaCodigo = null;
            }
            lista.add(new contabilidad.TO.ConFunContabilizarComprasDetalleTO(
                    detSecuencia,
                    dertDocumento,
                    detDebitoCredito,
                    detValor,
                    detSaldo,
                    detGenerado,
                    detReferencia,
                    detObservaciones,
                    detOrden,
                    secEmpresa,
                    secCodigo,
                    pisEmpresa,
                    pisSector,
                    pisNumero,
                    conEmpresa,
                    conPeriodo,
                    conTipo,
                    conNumero,
                    ctaEmpresa,
                    ctaCodigo));
        }
        return lista;
    }

    public static java.util.List<contabilidad.TO.PersonaTO> convertirFunPerson_FunPersonaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //private String contabilidadFecha;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }

            lista.add(new contabilidad.TO.PersonaTO(dato1));
        }
        return lista;
    }
}
