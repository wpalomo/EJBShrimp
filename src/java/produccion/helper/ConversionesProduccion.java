/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import produccion.TO.*;
import produccion.entity.*;
import validaciones.Validacion;

/**
 *
 * @author misael
 */
public class ConversionesProduccion {

    private static java.math.BigDecimal cero = new java.math.BigDecimal("0.00");

    // <editor-fold defaultstate="collapsed" desc="SECTOR">
    public static PrdSector convertirPrdSectorTO_PrdSector(PrdSectorTO prdSectorTO) throws Exception {
        PrdSector prdSector = new PrdSector();
        prdSector.setPrdSectorPK(new PrdSectorPK(
                prdSectorTO.getSecEmpresa(),
                prdSectorTO.getSecCodigo()));
        prdSector.setSecNombre(prdSectorTO.getSecNombre());
        prdSector.setSecLatitud(prdSectorTO.getSecLatitud());
        prdSector.setSecLongitud(prdSectorTO.getSecLongitud());
        prdSector.setSecActivo(prdSectorTO.getSecActivo());
        prdSector.setUsrEmpresa(prdSectorTO.getUsrEmpresa());
        prdSector.setUsrCodigo(prdSectorTO.getUsrCodigo());
        prdSector.setUsrFechaInserta(Validacion.fechaString_Date(prdSectorTO.getUsrFechaInsertaSector()));
        return prdSector;
    }

    public static List<PrdListaSectorTO> convertirListaPrdSector_ListaPrdSectorTO(List datos) {
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
            Boolean dato5;
            try {
                dato5 = Boolean.valueOf(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new PrdListaSectorTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PISCINA">
    public static PrdPiscina convertirPrdPiscinaTO_PrdPiscina(PrdPiscinaTO prdPiscinaTO) {
        PrdPiscina prdPiscina = new PrdPiscina();
        prdPiscina.setPrdPiscinaPK(new PrdPiscinaPK(
                prdPiscinaTO.getPisEmpresa(),
                prdPiscinaTO.getSecCodigo(),
                prdPiscinaTO.getPisNumero()));
        prdPiscina.setPisNombre(prdPiscinaTO.getPisNombre());
        prdPiscina.setPisHectareaje(prdPiscinaTO.getPisHectareaje());
        prdPiscina.setPisActiva(prdPiscinaTO.getPisActiva());
        prdPiscina.setUsrEmpresa(prdPiscinaTO.getUsrEmpresa());
        prdPiscina.setUsrCodigo(prdPiscinaTO.getUsrCodigo());
        prdPiscina.setUsrFechaInserta(Validacion.fechaString_Date(prdPiscinaTO.getUsrFechaInsertaPiscina()));
        return prdPiscina;
    }

    public static List<PrdListaPiscinaTO> convertirListaPrdPiscina_ListaPrdPiscinaTO(List datos) {
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
                dato3 = BigDecimal.valueOf(Double.valueOf(array[2].toString())).add(cero);
            } catch (Exception e) {
                dato3 = cero;
            }
            Boolean dato4;
            try {
                dato4 = Boolean.valueOf(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new PrdListaPiscinaTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static List<PrdListaPiscinaComboTO> convertirListaPrdPiscinaCombo_ListaPrdPiscinaComboTO(List datos) {
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
            lista.add(new PrdListaPiscinaComboTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static List<PrdComboPiscinaTO> convertirComboPrdPiscina_ComboPrdPiscinaTO(List datos) {
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
            lista.add(new PrdComboPiscinaTO(dato1, dato2, dato3));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CORRIDA">
    public static PrdCorrida convertirPrdCorridaTO_PrdCorrida(PrdCorridaTO prdCorridaTO) {
        PrdCorrida prdCorrida = new PrdCorrida();
        prdCorrida.setPrdCorridaPK(new PrdCorridaPK(
                prdCorridaTO.getCorEmpresa(),
                prdCorridaTO.getCorSector(),
                prdCorridaTO.getCorPiscina(),
                prdCorridaTO.getCorNumero()));
        prdCorrida.setCorHectareas(prdCorridaTO.getCorHectareas());
        prdCorrida.setCorFechaDesde(Validacion.fecha(prdCorridaTO.getCorFechaDesde(), "yyyy-MM-dd"));
        prdCorrida.setCorFechaSiembra(Validacion.fecha(prdCorridaTO.getCorFechaSiembra(), "yyyy-MM-dd"));
        prdCorrida.setCorFechaPesca(Validacion.fecha(prdCorridaTO.getCorFechaPesca(), "yyyy-MM-dd"));
        prdCorrida.setCorFechaHasta(Validacion.fecha(prdCorridaTO.getCorFechaHasta(), "yyyy-MM-dd"));
        prdCorrida.setCorLaboratorio(prdCorridaTO.getCorLaboratorio());
        prdCorrida.setCorNauplio(prdCorridaTO.getCorNauplio());
        prdCorrida.setCorPellet(prdCorridaTO.getCorPellet());
        prdCorrida.setCorObservaciones(prdCorridaTO.getCorObservaciones());
        prdCorrida.setCorActiva(prdCorridaTO.getCorActiva());
        prdCorrida.setUsrCodigo(prdCorridaTO.getUsrCodigo());
        prdCorrida.setUsrEmpresa(prdCorridaTO.getUsrEmpresa());
        prdCorrida.setUsrFechaInserta(Validacion.fechaString_Date(prdCorridaTO.getUsrFechaInsertaCorrida()));

        /*
         * forma simplificada de escribir una sentencia IF THEN ELSE, la cual se
         * hace con los simbolos ? y : . Por ejemplo: IF (valor==A) THEN
         * respuesta=B ELSE respuesta=C se puede simplificar como: respuesta =
         * (valor==A) ? B : C
         */

        prdCorrida.setCorNumeroLarvas((prdCorridaTO.getCorNumeroLarvas() == 0)
                ? null : prdCorridaTO.getCorNumeroLarvas());

        prdCorrida.setCorBiomasa((prdCorridaTO.getCorBiomasa().compareTo(BigDecimal.ZERO) == 0)
                ? null : prdCorridaTO.getCorBiomasa());

        prdCorrida.setCorValorVenta((prdCorridaTO.getCorValorVenta().compareTo(BigDecimal.ZERO) == 0)
                ? null : prdCorridaTO.getCorValorVenta());

        return prdCorrida;
    }

    public static List<PrdListaCorridaTO> convertirListaPrdCorrida_ListaPrdCorridaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String corNumero;
            try {
                corNumero = array[0].toString();
            } catch (Exception e) {
                corNumero = null;
            }
            String corFechaDesde;
            try {
                corFechaDesde = array[1].toString();
            } catch (Exception e) {
                corFechaDesde = null;
            }
            BigDecimal corHectareas;
            try {
                corHectareas = new BigDecimal(array[2].toString());
            } catch (Exception e) {
                corHectareas = null;
            }
            Integer corNumeroLarvas;
            try {
                corNumeroLarvas = Integer.valueOf(array[3].toString());
            } catch (Exception e) {
                corNumeroLarvas = null;
            }
            String corLaboratorio;
            try {
                corLaboratorio = array[4].toString();
            } catch (Exception e) {
                corLaboratorio = null;
            }
            String corNauplio;
            try {
                corNauplio = array[5].toString();
            } catch (Exception e) {
                corNauplio = null;
            }
            Short corPellet;
            try {
                corPellet = new Short(array[6].toString());
            } catch (Exception e) {
                corPellet = null;
            }
            String corFechaSiembra;
            try {
                corFechaSiembra = array[7].toString();
            } catch (Exception e) {
                corFechaSiembra = null;
            }
            BigDecimal corBiomasa;
            try {
                corBiomasa = new BigDecimal(array[8].toString());
            } catch (Exception e) {
                corBiomasa = null;
            }
            BigDecimal corValorVenta;
            try {
                corValorVenta = new BigDecimal(array[9].toString());
            } catch (Exception e) {
                corValorVenta = null;
            }
            String corObservaciones;
            try {
                corObservaciones = array[10].toString();
            } catch (Exception e) {
                corObservaciones = null;
            }
            String corFechaPesca;
            try {
                corFechaPesca = array[11].toString();
            } catch (Exception e) {
                corFechaPesca = null;
            }
            String corFechaHasta;
            try {
                corFechaHasta = array[12].toString();
            } catch (Exception e) {
                corFechaHasta = null;
            }
            Boolean corActiva;
            try {
                corActiva = Boolean.valueOf(array[13].toString());
            } catch (Exception e) {
                corActiva = null;
            }
            lista.add(new PrdListaCorridaTO(
                    corNumero,
                    corFechaDesde,
                    corHectareas,
                    corNumeroLarvas,
                    corLaboratorio,
                    corNauplio,
                    corPellet,
                    corFechaSiembra,
                    corBiomasa,
                    corValorVenta,
                    corObservaciones,
                    corFechaPesca,
                    corFechaHasta,
                    corActiva));
        }
        return lista;
    }

    public static PrdFunAnalisisVentasTO convertirPrdFunAnalisisVentas_PrdFunAnalisisVentasTO(List datos) {
        PrdFunAnalisisVentasTO prdFunAnalisisVentasTO = null;
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String rc_empresa;
            try {
                rc_empresa = array[0].toString();
            } catch (Exception e) {
                rc_empresa = null;
            }
            String rc_sector;
            try {
                rc_sector = array[1].toString();
            } catch (Exception e) {
                rc_sector = null;
            }
            String rc_piscina;
            try {
                rc_piscina = array[2].toString();
            } catch (Exception e) {
                rc_piscina = null;
            }
            String rc_corrida;
            try {
                rc_corrida = array[3].toString();
            } catch (Exception e) {
                rc_corrida = null;
            }
            String rc_fecha_siembra;
            try {
                rc_fecha_siembra = array[4].toString();
            } catch (Exception e) {
                rc_fecha_siembra = null;
            }
            String rc_fecha_pesca;
            try {
                rc_fecha_pesca = array[5].toString();
            } catch (Exception e) {
                rc_fecha_pesca = null;
            }
            BigDecimal rc_edad;
            try {
                rc_edad = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                rc_edad = null;
            }
            BigDecimal rc_hectareaje;
            try {
                rc_hectareaje = new BigDecimal(array[7].toString());
            } catch (Exception e) {
                rc_hectareaje = null;
            }
            BigDecimal rc_numero_lavas;
            try {
                rc_numero_lavas = new BigDecimal(array[8].toString());
            } catch (Exception e) {
                rc_numero_lavas = null;
            }
            BigDecimal rc_densidad;
            try {
                rc_densidad = new BigDecimal(array[9].toString());
            } catch (Exception e) {
                rc_densidad = null;
            }
            BigDecimal rc_talla_promedio;
            try {
                rc_talla_promedio = new BigDecimal(array[10].toString());
            } catch (Exception e) {
                rc_talla_promedio = null;
            }
            String rc_laboratorio;
            try {
                rc_laboratorio = array[11].toString();
            } catch (Exception e) {
                rc_laboratorio = null;
            }
            String rc_nauplio;
            try {
                rc_nauplio = array[12].toString();
            } catch (Exception e) {
                rc_nauplio = null;
            }
            BigDecimal rc_biomasa_proyectada;
            try {
                rc_biomasa_proyectada = new BigDecimal(array[13].toString());
            } catch (Exception e) {
                rc_biomasa_proyectada = null;
            }
            BigDecimal rc_biomasa_real;
            try {
                rc_biomasa_real = new BigDecimal(array[14].toString());
            } catch (Exception e) {
                rc_biomasa_real = null;
            }
            BigDecimal rc_balanceado;
            try {
                rc_balanceado = new BigDecimal(array[15].toString());
            } catch (Exception e) {
                rc_balanceado = null;
            }
            BigDecimal rc_converion;
            try {
                rc_converion = new BigDecimal(array[16].toString());
            } catch (Exception e) {
                rc_converion = null;
            }
            BigDecimal rc_sobrevivencia;
            try {
                rc_sobrevivencia = new BigDecimal(array[17].toString());
            } catch (Exception e) {
                rc_sobrevivencia = null;
            }
            BigDecimal rc_valor_venta;
            try {
                rc_valor_venta = new BigDecimal(array[18].toString());
            } catch (Exception e) {
                rc_valor_venta = null;
            }
            BigDecimal rc_costo_total;
            try {
                rc_costo_total = new BigDecimal(array[19].toString());
            } catch (Exception e) {
                rc_costo_total = null;
            }
            BigDecimal rc_directo;
            try {
                rc_directo = new BigDecimal(array[20].toString());
            } catch (Exception e) {
                rc_directo = null;
            }
            BigDecimal rc_indirecto;
            try {
                rc_indirecto = new BigDecimal(array[21].toString());
            } catch (Exception e) {
                rc_indirecto = null;
            }
            BigDecimal rc_resultado;
            try {
                rc_resultado = new BigDecimal(array[22].toString());
            } catch (Exception e) {
                rc_resultado = null;
            }
            prdFunAnalisisVentasTO = new PrdFunAnalisisVentasTO();
            prdFunAnalisisVentasTO.setRc_empresa(rc_empresa);
            prdFunAnalisisVentasTO.setRc_sector(rc_sector);
            prdFunAnalisisVentasTO.setRc_piscina(rc_piscina);
            prdFunAnalisisVentasTO.setRc_corrida(rc_corrida);
            prdFunAnalisisVentasTO.setRc_fecha_siembra(rc_fecha_siembra);
            prdFunAnalisisVentasTO.setRc_fecha_pesca(rc_fecha_pesca);
            prdFunAnalisisVentasTO.setRc_edad(rc_edad);
            prdFunAnalisisVentasTO.setRc_hectareaje(rc_hectareaje);
            prdFunAnalisisVentasTO.setRc_numero_lavas(rc_numero_lavas);
            prdFunAnalisisVentasTO.setRc_densidad(rc_densidad);
            prdFunAnalisisVentasTO.setRc_talla_promedio(rc_talla_promedio);
            prdFunAnalisisVentasTO.setRc_laboratorio(rc_laboratorio);
            prdFunAnalisisVentasTO.setRc_nauplio(rc_nauplio);
            prdFunAnalisisVentasTO.setRc_biomasa_proyectada(rc_biomasa_proyectada);
            prdFunAnalisisVentasTO.setRc_biomasa_real(rc_biomasa_real);
            prdFunAnalisisVentasTO.setRc_balanceado(rc_balanceado);
            prdFunAnalisisVentasTO.setRc_converion(rc_converion);
            prdFunAnalisisVentasTO.setRc_sobrevivencia(rc_sobrevivencia);
            prdFunAnalisisVentasTO.setRc_valor_venta(rc_valor_venta);
            prdFunAnalisisVentasTO.setRc_costo_total(rc_costo_total);
            prdFunAnalisisVentasTO.setRc_directo(rc_directo);
            prdFunAnalisisVentasTO.setRc_indirecto(rc_indirecto);
            prdFunAnalisisVentasTO.setRc_resultado(rc_resultado);
        }
        return prdFunAnalisisVentasTO;
    }

    public static List<produccion.TO.PrdListaCostosDetalleCorridaTO> convertirListaCostosDetalleCorrida_ListaCostosDetalleCorridaTO(List datos) {
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

            lista.add(new produccion.TO.PrdListaCostosDetalleCorridaTO(
                    dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }

    public static List<PrdComboCorridaTO> convertirComboPrdCorrida_ComboPrdCorridaTO(List datos) {
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
            BigDecimal dato2;
            try {
                dato2 = new BigDecimal(array[1].toString());
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
            lista.add(new PrdComboCorridaTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VEHICULOS">
    public static PrdVehiculos convertirPrdVehiculosTO_PrdVehiculos(PrdVehiculosTO prdVehiculosTO) {
        PrdVehiculos prdVehiculos = new PrdVehiculos();
        prdVehiculos.setPrdVehiculosPK(new PrdVehiculosPK(
                prdVehiculosTO.getVehEmpresa(),
                prdVehiculosTO.getVehEstablecimiento(),
                prdVehiculosTO.getVehPlaca()));
        prdVehiculos.setVehMarca(prdVehiculosTO.getVehMarca());
        prdVehiculos.setVehModelo(prdVehiculosTO.getVehModelo());
        prdVehiculos.setVehColor(prdVehiculosTO.getVehColor());
        prdVehiculos.setVehAnio(prdVehiculosTO.getVehAnio());
        prdVehiculos.setVehMotor(prdVehiculosTO.getVehMotor());
        prdVehiculos.setVehChasis(prdVehiculosTO.getVehChasis());
        prdVehiculos.setVehOrigen(prdVehiculosTO.getVehOrigen());
        prdVehiculos.setVehTipo(prdVehiculosTO.getVehTipo());
        prdVehiculos.setVehTonelaje(prdVehiculosTO.getVehTonelaje());
        prdVehiculos.setVehCilindraje(prdVehiculosTO.getVehCilindraje());
        prdVehiculos.setVehCombustible(prdVehiculosTO.getVehCombustible());
        prdVehiculos.setVehTipoServicio(prdVehiculosTO.getVehTipoServicio());
        prdVehiculos.setVehObservaciones(prdVehiculosTO.getVehObservaciones());
        prdVehiculos.setVehCompraValor(prdVehiculosTO.getVehCompraValor());
        prdVehiculos.setVehCompraComision(prdVehiculosTO.getVehVentaComision());
        prdVehiculos.setVehCompraMultasCtg(prdVehiculosTO.getVehCompraMultasCtg());
        prdVehiculos.setVehCompraMultasAnt(prdVehiculosTO.getVehCompraMultasAnt());
        prdVehiculos.setVehVentaValor(prdVehiculosTO.getVehVentaValor());
        prdVehiculos.setVehVentaComision(prdVehiculosTO.getVehVentaComision());
        prdVehiculos.setVehMatriculadoANombreDe(prdVehiculosTO.getVehMatriculadoANombreDe());
        prdVehiculos.setVehProveedorId(prdVehiculosTO.getVehProveedorId());
        prdVehiculos.setVehProveedorNombre(prdVehiculosTO.getVehProveedorNombre());
        prdVehiculos.setVehProveedorDireccion(prdVehiculosTO.getVehProveedorDireccion());
        prdVehiculos.setVehProveedorTelefono(prdVehiculosTO.getVehProveedorTelefono());
        prdVehiculos.setVehClienteId(prdVehiculosTO.getVehClienteId());
        prdVehiculos.setVehClienteNombre(prdVehiculosTO.getVehClienteNombre());
        prdVehiculos.setVehClienteDireccion(prdVehiculosTO.getVehClienteDireccion());
        prdVehiculos.setVehClienteTelefono(prdVehiculosTO.getVehClienteTelefono());
        prdVehiculos.setVehPrimerTraspasoId(prdVehiculosTO.getVehPrimerTraspasoId());
        prdVehiculos.setVehPrimerTraspasoNombre(prdVehiculosTO.getVehPrimerTraspasoNombre());
        prdVehiculos.setVehPrimerTraspasoDireccion(prdVehiculosTO.getVehPrimerTraspasoDireccion());
        prdVehiculos.setVehPrimerTraspasoTelefono(prdVehiculosTO.getVehPrimerTraspasoTelefono());
        prdVehiculos.setVehSegundoTraspasoId(prdVehiculosTO.getVehSegundoTraspasoId());
        prdVehiculos.setVehSegundoTraspasoNombre(prdVehiculosTO.getVehSegundoTraspasoNombre());
        prdVehiculos.setVehSegundoTraspasoDireccion(prdVehiculosTO.getVehSegundoTraspasoDireccion());
        prdVehiculos.setVehSegundoTraspasoTelefono(prdVehiculosTO.getVehSegundoTraspasoTelefono());
        return prdVehiculos;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="LISTA CON RESUMEN DE CORRIDAS">
    public static List<PrdResumenCorridaTO> convertirListaPrdResumenCorrida_ListaPrdResumenCorridaTO(List datos) {
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
            BigDecimal dato12;
            try {
                dato12 = new BigDecimal(array[11].toString());
            } catch (Exception e) {
                dato12 = null;
            }
            BigDecimal dato13;
            try {
                dato13 = new BigDecimal(array[12].toString());
            } catch (Exception e) {
                dato13 = null;
            }
            BigDecimal dato14;
            try {
                dato14 = new BigDecimal(array[13].toString());
            } catch (Exception e) {
                dato14 = null;
            }
            BigDecimal dato15;
            try {
                dato15 = new BigDecimal(array[14].toString());
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
            BigDecimal dato18;
            try {
                dato18 = new BigDecimal(array[17].toString());
            } catch (Exception e) {
                dato18 = null;
            }
            BigDecimal dato19;
            try {
                dato19 = new BigDecimal(array[18].toString());
            } catch (Exception e) {
                dato19 = null;
            }
            BigDecimal dato20;
            try {
                dato20 = new BigDecimal(array[19].toString());
            } catch (Exception e) {
                dato20 = null;
            }
            BigDecimal dato21;
            try {
                dato21 = new BigDecimal(array[20].toString());
            } catch (Exception e) {
                dato21 = null;
            }
            BigDecimal dato22;
            try {
                dato22 = new BigDecimal(array[21].toString());
            } catch (Exception e) {
                dato22 = null;
            }
            BigDecimal dato23;
            try {
                dato23 = new BigDecimal(array[22].toString());
            } catch (Exception e) {
                dato23 = null;
            }
            BigDecimal dato24;
            try {
                dato24 = new BigDecimal(array[23].toString());
            } catch (Exception e) {
                dato24 = null;
            }
            BigDecimal dato25;
            try {
                dato25 = new BigDecimal(array[24].toString());
            } catch (Exception e) {
                dato25 = null;
            }
            BigDecimal dato26;
            try {
                dato26 = new BigDecimal(array[25].toString());
            } catch (Exception e) {
                dato26 = null;
            }
            String dato27;
            try {
                dato27 = array[26].toString();
            } catch (Exception e) {
                dato27 = null;
            }
            BigDecimal dato28;
            try {
                dato28 = new BigDecimal(array[27].toString());
            } catch (Exception e) {
                dato28 = null;
            }
            BigDecimal dato29;
            try {
                dato29 = new BigDecimal(array[28].toString());
            } catch (Exception e) {
                dato29 = null;
            }
            BigDecimal dato30;
            try {
                dato30 = new BigDecimal(array[29].toString());
            } catch (Exception e) {
                dato30 = null;
            }
            BigDecimal dato31;
            try {
                dato31 = new BigDecimal(array[30].toString());
            } catch (Exception e) {
                dato31 = null;
            }
            BigDecimal dato32;
            try {
                dato32 = new BigDecimal(array[31].toString());
            } catch (Exception e) {
                dato32 = null;
            }
            BigDecimal dato33;
            try {
                dato33 = new BigDecimal(array[32].toString());
            } catch (Exception e) {
                dato33 = null;
            }
            BigDecimal dato34;
            try {
                dato34 = new BigDecimal(array[33].toString());
            } catch (Exception e) {
                dato34 = null;
            }
            BigDecimal dato35;
            try {
                dato35 = new BigDecimal(array[34].toString());
            } catch (Exception e) {
                dato35 = null;
            }
            BigDecimal dato36;
            try {
                dato36 = new BigDecimal(array[35].toString());
            } catch (Exception e) {
                dato36 = null;
            }
            BigDecimal dato37;
            try {
                dato37 = new BigDecimal(array[36].toString());
            } catch (Exception e) {
                dato37 = null;
            }
            BigDecimal dato38;
            try {
                dato38 = new BigDecimal(array[37].toString());
            } catch (Exception e) {
                dato38 = null;
            }
            BigDecimal dato39;
            try {
                dato39 = new BigDecimal(array[38].toString());
            } catch (Exception e) {
                dato39 = null;
            }
            BigDecimal dato40;
            try {
                dato40 = new BigDecimal(array[39].toString());
            } catch (Exception e) {
                dato40 = null;
            }
            BigDecimal dato41;
            try {
                dato41 = new BigDecimal(array[40].toString());
            } catch (Exception e) {
                dato41 = null;
            }
            lista.add(new PrdResumenCorridaTO(dato1, dato2, dato3, dato4, dato5,
                    dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13,
                    dato14, dato15, dato16, dato17, dato18, dato19, dato20, dato21,
                    dato22, dato23, dato24, dato25, dato26, dato27, dato28, dato29,
                    dato30, dato31, dato32, dato33, dato34, dato35, dato36, dato37,
                    dato38, dato39, dato40, dato41));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SOBREVIVENCIA">
    public static PrdSobrevivencia convertirPrdSobrevivenciaTO_PrdSobrevivencia(PrdSobrevivenciaTO prdSobrevivenciaTO) {
        PrdSobrevivencia prdSobrevivencia = new PrdSobrevivencia();
        prdSobrevivencia.setSobCodigo(prdSobrevivenciaTO.getSobCodigo());
//        prdSobrevivencia.setPrdSector(new PrdSector(
//                prdSobrevivenciaTO.getSecEmpresa(),
//                prdSobrevivenciaTO.getSecCodigo()));
        prdSobrevivencia.setSobDiasDesde(prdSobrevivenciaTO.getSobDiasDesde());
        prdSobrevivencia.setSobDiasHasta(prdSobrevivenciaTO.getSobDiasHasta());
        prdSobrevivencia.setSobSobrevivencia(prdSobrevivenciaTO.getSobSobrevivencia());
        prdSobrevivencia.setSobAlimentacion(prdSobrevivenciaTO.getSobAlimentacion());
        prdSobrevivencia.setUsrEmpresa(prdSobrevivenciaTO.getUsrEmpresa());
        prdSobrevivencia.setUsrCodigo(prdSobrevivenciaTO.getUsrCodigo());
        prdSobrevivencia.setUsrFechaInserta(Validacion.fechaString_Date(prdSobrevivenciaTO.getUsrFechaInsertaSobrevivencia()));
        return prdSobrevivencia;
    }

    public static List<PrdListaSobrevivenciaTO> convertirListaPrdSobrevivencia_ListaPrdSobrevivenciaTO(List datos) {
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
            Integer dato2;
            try {
                dato2 = Integer.valueOf(array[1].toString());
            } catch (Exception e) {
                dato2 = null;
            }
            Integer dato3;
            try {
                dato3 = Integer.valueOf(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            BigDecimal dato4;
            try {
                dato4 = BigDecimal.valueOf(Double.valueOf(array[3].toString()));
            } catch (Exception e) {
                dato4 = null;
            }
            BigDecimal dato5;
            try {
                dato5 = BigDecimal.valueOf(Double.valueOf(array[4].toString()));
            } catch (Exception e) {
                dato5 = null;
            }

            lista.add(new PrdListaSobrevivenciaTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GRAMEAJE">
    public static PrdGrameaje convertirPrdGrameajeTO_PrdGrameaje(PrdGrameajeTO prdGrameajeTO) {
        PrdGrameaje prdGrameaje = new PrdGrameaje();
        prdGrameaje.setPrdGrameajePK(new PrdGrameajePK(prdGrameajeTO.getGraEmpresa(),
                prdGrameajeTO.getGraSector(), prdGrameajeTO.getGraPiscina(),
                Validacion.fecha(prdGrameajeTO.getGraFecha(), "yyyy-MM-dd")));
        prdGrameaje.setGraTgrande(prdGrameajeTO.getGraTGrande());
        prdGrameaje.setGraTmediano(prdGrameajeTO.getGraTMediano());
        prdGrameaje.setGraTpequeno(prdGrameajeTO.getGraTPequeno());
        prdGrameaje.setGraTpromedio(prdGrameajeTO.getGraTPromedio());
        prdGrameaje.setGraItgrande(prdGrameajeTO.getGraItGrande());
        prdGrameaje.setGraItmediano(prdGrameajeTO.getGraItMediano());
        prdGrameaje.setGraItpequeno(prdGrameajeTO.getGraItPequeno());
        prdGrameaje.setGraIpromedio(prdGrameajeTO.getGraItPromedio());
        prdGrameaje.setGraBiomasa(prdGrameajeTO.getGraBiomasa());
        prdGrameaje.setGraSobrevivencia(prdGrameajeTO.getGraSobrevivencia());
        prdGrameaje.setGraAlimentacion(prdGrameajeTO.getGraAlimentacion());
        prdGrameaje.setGraLibrasBalanceado(prdGrameajeTO.getGraLibrasBalanceado());
        prdGrameaje.setGraCostoDirecto(prdGrameajeTO.getGraCostoDirecto());
        prdGrameaje.setGraCostoIndirecto(prdGrameajeTO.getGraCostoIndirecto());
        prdGrameaje.setGraComentario(prdGrameajeTO.getGraComentario());
        prdGrameaje.setGraAnulado(prdGrameajeTO.getGraAnulado());
        prdGrameaje.setUsrEmpresa(prdGrameajeTO.getUsrEmpresa());
        prdGrameaje.setUsrCodigo(prdGrameajeTO.getUsrCodigo());
        prdGrameaje.setUsrFechaInserta(Validacion.fechaString_Date(prdGrameajeTO.getUsrFechaInsertaGrameaje()));
        return prdGrameaje;
    }

    public static PrdGrameaje convertirPrdGrameaje_PrdGrameaje(PrdGrameaje prdGrameajeAux) {
        if (prdGrameajeAux != null) {
            PrdGrameaje prdGrameaje = new PrdGrameaje();
            prdGrameaje.setPrdGrameajePK(prdGrameajeAux.getPrdGrameajePK());
            prdGrameaje.setGraTgrande(prdGrameajeAux.getGraTgrande());
            prdGrameaje.setGraTmediano(prdGrameajeAux.getGraTmediano());
            prdGrameaje.setGraTpequeno(prdGrameajeAux.getGraTpequeno());
            prdGrameaje.setGraTpromedio(prdGrameajeAux.getGraTpromedio());
            prdGrameaje.setGraItgrande(prdGrameajeAux.getGraItgrande());
            prdGrameaje.setGraItmediano(prdGrameajeAux.getGraItmediano());
            prdGrameaje.setGraItpequeno(prdGrameajeAux.getGraItpequeno());
            prdGrameaje.setGraIpromedio(prdGrameajeAux.getGraIpromedio());
            prdGrameaje.setGraBiomasa(prdGrameajeAux.getGraBiomasa());
            prdGrameaje.setGraSobrevivencia(prdGrameajeAux.getGraSobrevivencia());
            prdGrameaje.setGraAlimentacion(prdGrameajeAux.getGraAlimentacion());
            prdGrameaje.setGraLibrasBalanceado(prdGrameajeAux.getGraLibrasBalanceado());
            prdGrameaje.setGraCostoDirecto(prdGrameajeAux.getGraCostoDirecto());
            prdGrameaje.setGraCostoIndirecto(prdGrameajeAux.getGraCostoIndirecto());
            prdGrameaje.setGraComentario(prdGrameajeAux.getGraComentario());
            prdGrameaje.setGraAnulado(prdGrameajeAux.getGraAnulado());
            prdGrameaje.setUsrEmpresa(prdGrameajeAux.getUsrEmpresa());
            prdGrameaje.setUsrCodigo(prdGrameajeAux.getUsrCodigo());
            prdGrameaje.setUsrFechaInserta(prdGrameajeAux.getUsrFechaInserta());
            return prdGrameaje;
        } else {
            return null;
        }

    }

    public static List<PrdListadoGrameajeTO> convertirPrdListadoGrameaje_PrdListadoGrameajeTO(List datos) {
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
            BigDecimal dato2;
            try {
                dato2 = new BigDecimal(array[1].toString());
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
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            lista.add(new PrdListadoGrameajeTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }

    // </editor-fold>
//    public static PrdLiquidacion convertirPrdLiquidacionLotesValorizada(LiquidacionLotesValorizadaTO liquidacionLotesValorizadaTO) {
//        PrdLiquidacion prdLiquidacion = new PrdLiquidacion();
//        prdLiquidacion.setPrdLiquidacionPK(new PrdLiquidacionPK(liquidacionLotesValorizadaTO.getLiqEmpresa(),
//                liquidacionLotesValorizadaTO.getLiqCliente(), liquidacionLotesValorizadaTO.getLiqNumero()));
//
//        prdLiquidacion.setLiqLibrasEnviadas(liquidacionLotesValorizadaTO.getLiqLibrasEnviadas());
//        prdLiquidacion.setLiqLibrasRecibidas(liquidacionLotesValorizadaTO.getLiqLibrasRecibidas());
//        prdLiquidacion.setLiqLibrasBasura(liquidacionLotesValorizadaTO.getLiqLibrasBasura());
//        prdLiquidacion.setLiqLibrasParaCabeza(liquidacionLotesValorizadaTO.getLiqLibrasParaCabeza());
//        prdLiquidacion.setLiqLibrasParaCola(liquidacionLotesValorizadaTO.getLiqLibrasParaCola());
//        prdLiquidacion.setLiqEnteroClaseAT10Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT10Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT20Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT20Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT30Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT30Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT30a50Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT30a50Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT40Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT40Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT50a70Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT50a70Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT60Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT60Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT70Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT70Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT80Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT80Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT100Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT100Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT120Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT120Cantidad());
//        prdLiquidacion.setLiqEnteroClaseAT10Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT10Libras());
//        prdLiquidacion.setLiqEnteroClaseAT20Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT20Libras());
//        prdLiquidacion.setLiqEnteroClaseAT30Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT30Libras());
//        prdLiquidacion.setLiqEnteroClaseAT30a50Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT30a50Libras());
//        prdLiquidacion.setLiqEnteroClaseAT40Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT40Libras());
//        prdLiquidacion.setLiqEnteroClaseAT50Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT50Libras());
//        prdLiquidacion.setLiqEnteroClaseAT50a70Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT50a70Libras());
//        prdLiquidacion.setLiqEnteroClaseAT60Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT60Libras());
//        prdLiquidacion.setLiqEnteroClaseAT70Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT70Libras());
//        prdLiquidacion.setLiqEnteroClaseAT80Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT80Libras());
//        prdLiquidacion.setLiqEnteroClaseAT100Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT100Libras());
//        prdLiquidacion.setLiqEnteroClaseAT120Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT120Libras());
//        prdLiquidacion.setLiqEnteroClaseAT10Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT10Valor());
//        prdLiquidacion.setLiqEnteroClaseAT20Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT20Valor());
//        prdLiquidacion.setLiqEnteroClaseAT30Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT30Valor());
//        prdLiquidacion.setLiqEnteroClaseAT30a50Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT30a50Valor());
//        prdLiquidacion.setLiqEnteroClaseAT40Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT40Valor());
//        prdLiquidacion.setLiqEnteroClaseAT50Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT50Valor());
//        prdLiquidacion.setLiqEnteroClaseAT50a70Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT50a70Valor());
//        prdLiquidacion.setLiqEnteroClaseAT60Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT60Valor());
//        prdLiquidacion.setLiqEnteroClaseAT70Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT70Valor());
//        prdLiquidacion.setLiqEnteroClaseAT80Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT80Valor());
//        prdLiquidacion.setLiqEnteroClaseAT100Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT100Valor());
//        prdLiquidacion.setLiqEnteroClaseAT120Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseAT120Valor());
//        prdLiquidacion.setLiqEnteroClaseBT10Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT10Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT20Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT20Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT30Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT30Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT30a50Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT30a50Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT40Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT40Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT50Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT50Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT50a70Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT50a70Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT60Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT60Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT70Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT70Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT100Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT100Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT120Cantidad(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT120Cantidad());
//        prdLiquidacion.setLiqEnteroClaseBT10Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT10Libras());
//        prdLiquidacion.setLiqEnteroClaseBT20Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT20Libras());
//        prdLiquidacion.setLiqEnteroClaseBT30Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT30Libras());
//        prdLiquidacion.setLiqEnteroClaseBT30a50Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT30a50Libras());
//        prdLiquidacion.setLiqEnteroClaseBT40Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT40Libras());
//        prdLiquidacion.setLiqEnteroClaseBT50Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT50Libras());
//        prdLiquidacion.setLiqEnteroClaseBT50a70Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT50a70Libras());
//        prdLiquidacion.setLiqEnteroClaseBT60Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT60Libras());
//        prdLiquidacion.setLiqEnteroClaseBT70Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT70Libras());
//        prdLiquidacion.setLiqEnteroClaseBT80Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT80Libras());
//        prdLiquidacion.setLiqEnteroClaseBT100Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT100Libras());
//        prdLiquidacion.setLiqEnteroClaseBT120Libras(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT120Libras());
//        prdLiquidacion.setLiqEnteroClaseBT10Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT10Valor());
//        prdLiquidacion.setLiqEnteroClaseBT20Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT20Valor());
//        prdLiquidacion.setLiqEnteroClaseBT30Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT30Valor());
//        prdLiquidacion.setLiqEnteroClaseBT30a50Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT30a50Valor());
//        prdLiquidacion.setLiqEnteroClaseBT40Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT40Valor());
//        prdLiquidacion.setLiqEnteroClaseBT50Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT50Valor());
//        prdLiquidacion.setLiqEnteroClaseBT50a70Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT50a70Valor());
//        prdLiquidacion.setLiqEnteroClaseBT60Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT60Valor());
//        prdLiquidacion.setLiqEnteroClaseBT70Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT70Valor());
//        prdLiquidacion.setLiqEnteroClaseBT80Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT80Valor());
//        prdLiquidacion.setLiqEnteroClaseBT100Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT100Valor());
//        prdLiquidacion.setLiqEnteroClaseBT120Valor(liquidacionLotesValorizadaTO.getLiqEnteroClaseBT120Valor());
//        prdLiquidacion.setLiqEnteroOtrasClasificacionesValor(liquidacionLotesValorizadaTO.getLiqEnteroOtrasClasificacionesValor());
//        prdLiquidacion.setLiqEnteroOtrasClasificacionesLibras(liquidacionLotesValorizadaTO.getLiqEnteroOtrasClasificacionesLibras());
//        prdLiquidacion.setLiqEnteroOtrasClasificacionesCantidad(liquidacionLotesValorizadaTO.getLiqEnteroOtrasClasificacionesCantidad());
//        prdLiquidacion.setLiqColaClaseAT16Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT16Cantidad());
//        prdLiquidacion.setLiqColaClaseAT21Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT21Cantidad());
//        prdLiquidacion.setLiqColaClaseAT26Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT26Cantidad());
//        prdLiquidacion.setLiqColaClaseAT31Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT31Cantidad());
//        prdLiquidacion.setLiqColaClaseAT36Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT36Cantidad());
//        prdLiquidacion.setLiqColaClaseAT41Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT41Cantidad());
//        prdLiquidacion.setLiqColaClaseAT51Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT51Cantidad());
//        prdLiquidacion.setLiqColaClaseAT61Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT61Cantidad());
//        prdLiquidacion.setLiqColaClaseAT71Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT71Cantidad());
//        prdLiquidacion.setLiqColaClaseAT91Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT91Cantidad());
//        prdLiquidacion.setLiqColaClaseAT110Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT110Cantidad());
//        prdLiquidacion.setLiqColaClaseAT131Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT131Cantidad());
//        prdLiquidacion.setLiqColaClaseAT150Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT150Cantidad());
//        prdLiquidacion.setLiqColaClaseAT200Cantidad(liquidacionLotesValorizadaTO.getLiqColaClaseAT200Cantidad());
//        prdLiquidacion.setLiqColaClaseAT16Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT16Libras());
//        prdLiquidacion.setLiqColaClaseAT21Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT21Libras());
//        prdLiquidacion.setLiqColaClaseAT26Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT26Libras());
//        prdLiquidacion.setLiqColaClaseAT31Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT31Libras());
//        prdLiquidacion.setLiqColaClaseAT36Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT36Libras());
//        prdLiquidacion.setLiqColaClaseAT41Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT41Libras());
//        prdLiquidacion.setLiqColaClaseAT51Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT51Libras());
//        prdLiquidacion.setLiqColaClaseAT61Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT61Libras());
//        prdLiquidacion.setLiqColaClaseAT71Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT71Libras());
//        prdLiquidacion.setLiqColaClaseAT91Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT91Libras());
//        prdLiquidacion.setLiqColaClaseAT110Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT110Libras());
//        prdLiquidacion.setLiqColaClaseAT131Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT131Libras());
//        prdLiquidacion.setLiqColaClaseAT150Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT150Libras());
//        prdLiquidacion.setLiqColaClaseAT200Libras(liquidacionLotesValorizadaTO.getLiqColaClaseAT200Libras());
//        prdLiquidacion.setLiqColaClaseAT16Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT16Valor());
//        prdLiquidacion.setLiqColaClaseAT21Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT21Valor());
//        prdLiquidacion.setLiqColaClaseAT26Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT26Valor());
//        prdLiquidacion.setLiqColaClaseAT31Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT31Valor());
//        prdLiquidacion.setLiqColaClaseAT36Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT36Valor());
//        prdLiquidacion.setLiqColaClaseAT41Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT41Valor());
//        prdLiquidacion.setLiqColaClaseAT51Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT51Valor());
//        prdLiquidacion.setLiqColaClaseAT61Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT61Valor());
//        prdLiquidacion.setLiqColaClaseAT71Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT71Valor());
//        prdLiquidacion.setLiqColaClaseAT91Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT91Valor());
//        prdLiquidacion.setLiqColaClaseAT110Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT110Valor());
//        prdLiquidacion.setLiqColaClaseAT131Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT131Valor());
//        prdLiquidacion.setLiqColaClaseAT150Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT150Valor());
//        prdLiquidacion.setLiqColaClaseAT200Valor(liquidacionLotesValorizadaTO.getLiqColaClaseAT200Valor());
//        prdLiquidacion.setLiqColaOtrasClasificacionesValor(liquidacionLotesValorizadaTO.getLiqColaOtrasClasificacionesValor());
//        prdLiquidacion.setLiqColaOtrasClasificacionesLibras(liquidacionLotesValorizadaTO.getLiqColaOtrasClasificacionesLibras());
//        prdLiquidacion.setLiqColaOtrasClasificacionesCantidad(liquidacionLotesValorizadaTO.getLiqColaOtrasClasificacionesCantidad());
//        prdLiquidacion.setLiqPendiente(liquidacionLotesValorizadaTO.getLiqPendiente());
//        prdLiquidacion.setUsrEmpresa(liquidacionLotesValorizadaTO.getUsrEmpresa());
//        prdLiquidacion.setUsrCodigo(liquidacionLotesValorizadaTO.getUsrCodigo());
//        prdLiquidacion.setUsrFechaInserta(Validacion.fechaString_Date(liquidacionLotesValorizadaTO.getUsrFechaInserta()));
//        prdLiquidacion.setCliEmpresa(liquidacionLotesValorizadaTO.getCliEmpresa());
//        prdLiquidacion.setCliCodigo(liquidacionLotesValorizadaTO.getCliCodigo());
//
//        return prdLiquidacion;
//    }
    public static List<PrdCostoDetalleFechaTO> convertirPrdListadoCostoDetalleFecha_PrdListadoCostoDetalleFechaTO(List datos) {
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
            lista.add(new PrdCostoDetalleFechaTO(dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }

    public static List<PrdCorrida> convertirPrdCorrida(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String empresa;
            try {
                empresa = array[0].toString();
            } catch (Exception e) {
                empresa = null;
            }
            String sector;
            try {
                sector = array[1].toString();
            } catch (Exception e) {
                sector = null;
            }
            String piscina;
            try {
                piscina = array[2].toString();
            } catch (Exception e) {
                piscina = null;
            }
            String corridaNumero;
            try {
                corridaNumero = array[3].toString();
            } catch (Exception e) {
                corridaNumero = null;
            }
            BigDecimal hectarea;
            try {
                hectarea = new BigDecimal(array[4].toString());
            } catch (Exception e) {
                hectarea = null;
            }
            Date desde;
            try {
                desde = java.sql.Date.valueOf(array[5].toString());
            } catch (Exception e) {
                desde = null;
            }
            Date siembra;
            try {
                siembra = java.sql.Date.valueOf(array[6].toString());
            } catch (Exception e) {
                siembra = null;
            }
            Date pesca;
            try {
                pesca = java.sql.Date.valueOf(array[7].toString());
            } catch (Exception e) {
                pesca = null;
            }
            Date hasta;
            try {
                hasta = java.sql.Date.valueOf(array[8].toString());
            } catch (Exception e) {
                hasta = null;
            }
            Integer numeroLarvas;
            try {
                numeroLarvas = Integer.parseInt(array[9].toString());
            } catch (Exception e) {
                numeroLarvas = null;
            }
            String laboratorio;
            try {
                laboratorio = array[10].toString();
            } catch (Exception e) {
                laboratorio = null;
            }
            String nauplio;
            try {
                nauplio = array[11].toString();
            } catch (Exception e) {
                nauplio = null;
            }
            Short pellet;
            try {
                pellet = new Short(array[12].toString());
            } catch (Exception e) {
                pellet = null;
            }
            BigDecimal biomasa;
            try {
                biomasa = new BigDecimal(array[13].toString());
            } catch (Exception e) {
                biomasa = null;
            }
            BigDecimal valorVenta;
            try {
                valorVenta = new BigDecimal(array[14].toString());
            } catch (Exception e) {
                valorVenta = null;
            }
            String corObservaciones;
            try {
                corObservaciones = array[15].toString();
            } catch (Exception e) {
                corObservaciones = null;
            }
            Boolean activa;
            try {
                activa = Boolean.parseBoolean(array[16].toString());
            } catch (Exception e) {
                activa = null;
            }
            String pisEmpresa;
            try {
                pisEmpresa = array[17].toString();
            } catch (Exception e) {
                pisEmpresa = null;
            }
            String pisSector;
            try {
                pisSector = array[18].toString();
            } catch (Exception e) {
                pisSector = null;
            }
            String pisNumero;
            try {
                pisNumero = array[19].toString();
            } catch (Exception e) {
                pisNumero = null;
            }
            String usrEmpresa;
            try {
                usrEmpresa = array[20].toString();
            } catch (Exception e) {
                usrEmpresa = null;
            }
            String usrCodigo;
            try {
                usrCodigo = array[21].toString();
            } catch (Exception e) {
                usrCodigo = null;
            }
            Date usrFecha;
            try {
                usrFecha = validaciones.Validacion.fechaString_Date(array[22].toString());
            } catch (Exception e) {
                usrFecha = null;
            }
            PrdCorridaPK prdCorridaPK = new PrdCorridaPK(empresa, sector, piscina, corridaNumero);
            PrdCorrida prdCorrida = new PrdCorrida();
            prdCorrida.setCorActiva(activa);
            prdCorrida.setCorObservaciones(corObservaciones);
            prdCorrida.setCorBiomasa(biomasa);
            prdCorrida.setCorFechaDesde(desde);
            prdCorrida.setCorFechaHasta(hasta);
            prdCorrida.setCorFechaPesca(pesca);
            prdCorrida.setCorFechaSiembra(siembra);
            prdCorrida.setCorHectareas(hectarea);
            prdCorrida.setCorLaboratorio(laboratorio);
            prdCorrida.setCorNauplio(nauplio);
            prdCorrida.setCorPellet(pellet);
            prdCorrida.setCorNumeroLarvas(numeroLarvas);
            prdCorrida.setCorValorVenta(valorVenta);
            prdCorrida.setUsrCodigo(usrCodigo);
            prdCorrida.setUsrEmpresa(usrEmpresa);
            prdCorrida.setUsrFechaInserta(usrFecha);
            prdCorrida.setPrdCorridaPK(prdCorridaPK);
            lista.add(prdCorrida);
        }
        return lista;
    }

    public static List<CostoDetalleMultipleCorridaTO> convertirCostoDetalleMultipleCorrida_CostoDetalleMultipleCorridaTO(List datos) {
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
            BigDecimal dato8;
            try {
                dato8 = new BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            BigDecimal dato9;
            try {
                dato9 = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            lista.add(new CostoDetalleMultipleCorridaTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9));
        }
        return lista;
    }

    public static produccion.TO.PrdCorridaTO convertirPrdCorrida_PrdCorridaTO(java.util.List datos) {
        produccion.TO.PrdCorridaTO prdCorridaTO = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String empresa;
            try {
                empresa = array[0].toString();
            } catch (Exception e) {
                empresa = null;
            }
            String sector;
            try {
                sector = array[1].toString();
            } catch (Exception e) {
                sector = null;
            }
            String piscina;
            try {
                piscina = array[2].toString();
            } catch (Exception e) {
                piscina = null;
            }
            String corridaNumero;
            try {
                corridaNumero = array[3].toString();
            } catch (Exception e) {
                corridaNumero = null;
            }
            BigDecimal hectarea;
            try {
                hectarea = new BigDecimal(array[4].toString());
            } catch (Exception e) {
                hectarea = null;
            }
            String desde;
            try {
                desde = validaciones.Validacion.fecha(java.sql.Date.valueOf(array[5].toString()), "yyyy-MM-dd");
            } catch (Exception e) {
                desde = null;
            }
            String siembra;
            try {
                siembra = validaciones.Validacion.fecha(java.sql.Date.valueOf(array[6].toString()), "yyyy-MM-dd");
            } catch (Exception e) {
                siembra = null;
            }
            String pesca;
            try {
                pesca = validaciones.Validacion.fecha(java.sql.Date.valueOf(array[7].toString()), "yyyy-MM-dd");
            } catch (Exception e) {
                pesca = null;
            }
            String hasta;
            try {
                hasta = validaciones.Validacion.fecha(java.sql.Date.valueOf(array[8].toString()), "yyyy-MM-dd");
            } catch (Exception e) {
                hasta = null;
            }
            Integer numeroLarvas;
            try {
                numeroLarvas = Integer.parseInt(array[9].toString());
            } catch (Exception e) {
                numeroLarvas = null;
            }
            String laboratorio;
            try {
                laboratorio = array[10].toString();
            } catch (Exception e) {
                laboratorio = null;
            }
            String nauplio;
            try {
                nauplio = array[11].toString();
            } catch (Exception e) {
                nauplio = null;
            }
            Short pellet;
            try {
                pellet = new Short(array[12].toString());
            } catch (Exception e) {
                pellet = null;
            }
            BigDecimal biomasa;
            try {
                biomasa = new BigDecimal(array[13].toString());
            } catch (Exception e) {
                biomasa = null;
            }
            BigDecimal valorVenta;
            try {
                valorVenta = new BigDecimal(array[14].toString());
            } catch (Exception e) {
                valorVenta = null;
            }
            String corObservaciones;
            try {
                corObservaciones = array[15].toString();
            } catch (Exception e) {
                corObservaciones = null;
            }
            Boolean activa;
            try {
                activa = Boolean.parseBoolean(array[16].toString());
            } catch (Exception e) {
                activa = null;
            }
            String pisEmpresa;
            try {
                pisEmpresa = array[17].toString();
            } catch (Exception e) {
                pisEmpresa = null;
            }
            String pisSector;
            try {
                pisSector = array[18].toString();
            } catch (Exception e) {
                pisSector = null;
            }
            String pisNumero;
            try {
                pisNumero = array[19].toString();
            } catch (Exception e) {
                pisNumero = null;
            }
            String usrEmpresa;
            try {
                usrEmpresa = array[20].toString();
            } catch (Exception e) {
                usrEmpresa = null;
            }
            String usrCodigo;
            try {
                usrCodigo = array[21].toString();
            } catch (Exception e) {
                usrCodigo = null;
            }
            String usrFecha;
            try {
                usrFecha = validaciones.Validacion.fecha(validaciones.Validacion.fechaString_Date(array[22].toString()), "yyyy-MM-dd");
            } catch (Exception e) {
                usrFecha = null;
            }


            if (datos.isEmpty()) {
                prdCorridaTO = null;
            } else {
                prdCorridaTO = new produccion.TO.PrdCorridaTO();
                prdCorridaTO.setCorEmpresa(empresa);
                prdCorridaTO.setCorSector(sector);
                prdCorridaTO.setCorPiscina(piscina);
                prdCorridaTO.setCorNumero(corridaNumero);
                prdCorridaTO.setCorHectareas(hectarea);
                prdCorridaTO.setCorFechaDesde(desde);
                prdCorridaTO.setCorFechaSiembra(siembra);
                prdCorridaTO.setCorFechaPesca(pesca);
                prdCorridaTO.setCorFechaHasta(hasta);
                prdCorridaTO.setCorNumeroLarvas(numeroLarvas);
                prdCorridaTO.setCorLaboratorio(laboratorio);
                prdCorridaTO.setCorNauplio(nauplio);
                prdCorridaTO.setCorPellet(pellet);
                prdCorridaTO.setCorBiomasa(biomasa);
                prdCorridaTO.setCorValorVenta(valorVenta);
                prdCorridaTO.setCorObservaciones(corObservaciones);
                prdCorridaTO.setCorActiva(activa);
                prdCorridaTO.setPisEmpresa(pisEmpresa);
                prdCorridaTO.setPisSector(pisSector);
                prdCorridaTO.setPisNumero(pisNumero);
                prdCorridaTO.setUsrEmpresa(usrEmpresa);
                prdCorridaTO.setUsrCodigo(usrCodigo);
                prdCorridaTO.setUsrFechaInsertaCorrida(usrFecha);
            }
//            new inventario.TO.InvCompraCabeceraTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18);
        }
        return prdCorridaTO;
    }

    public static produccion.TO.PrdGrameajeTO convertirPrdGrameaje_PrdGrameajeTO(java.util.List datos) {
        produccion.TO.PrdGrameajeTO prdGrameajeTO = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String empresa;
            try {
                empresa = array[0].toString();
            } catch (Exception e) {
                empresa = null;
            }
            String sector;
            try {
                sector = array[1].toString();
            } catch (Exception e) {
                sector = null;
            }
            String piscina;
            try {
                piscina = array[2].toString();
            } catch (Exception e) {
                piscina = null;
            }
            String fecha;
            try {
                fecha = validaciones.Validacion.fecha(java.sql.Date.valueOf(array[3].toString()), "yyyy-MM-dd");
            } catch (Exception e) {
                fecha = null;
            }
            BigDecimal graTgrande;
            try {
                graTgrande = new BigDecimal(array[4].toString());
            } catch (Exception e) {
                graTgrande = null;
            }
            BigDecimal graTmediano;
            try {
                graTmediano = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                graTmediano = null;
            }
            BigDecimal graTpequeno;
            try {
                graTpequeno = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                graTpequeno = null;
            }
            BigDecimal graTpromedio;
            try {
                graTpromedio = new BigDecimal(array[7].toString());
            } catch (Exception e) {
                graTpromedio = null;
            }
            BigDecimal graItGrande;
            try {
                graItGrande = new BigDecimal(array[8].toString());
            } catch (Exception e) {
                graItGrande = null;
            }
            BigDecimal graItMediano;
            try {
                graItMediano = new BigDecimal(array[9].toString());
            } catch (Exception e) {
                graItMediano = null;
            }
            BigDecimal graItPequeno;
            try {
                graItPequeno = new BigDecimal(array[10].toString());
            } catch (Exception e) {
                graItPequeno = null;
            }
            BigDecimal graItPromedio;
            try {
                graItPromedio = new BigDecimal(array[11].toString());
            } catch (Exception e) {
                graItPromedio = null;
            }
            BigDecimal graBiomasa;
            try {
                graBiomasa = new BigDecimal(array[12].toString());
            } catch (Exception e) {
                graBiomasa = null;
            }
            BigDecimal graSobrevivencia;
            try {
                graSobrevivencia = new BigDecimal(array[13].toString());
            } catch (Exception e) {
                graSobrevivencia = null;
            }
            BigDecimal graAlimentacion;
            try {
                graAlimentacion = new BigDecimal(array[14].toString());
            } catch (Exception e) {
                graAlimentacion = null;
            }
            BigDecimal graLibrasBalanceado;
            try {
                graLibrasBalanceado = new BigDecimal(array[15].toString());
            } catch (Exception e) {
                graLibrasBalanceado = null;
            }
            BigDecimal graCostoDirecto;
            try {
                graCostoDirecto = new BigDecimal(array[16].toString());
            } catch (Exception e) {
                graCostoDirecto = null;
            }
            BigDecimal graCostoIndirecto;
            try {
                graCostoIndirecto = new BigDecimal(array[17].toString());
            } catch (Exception e) {
                graCostoIndirecto = null;
            }
            String graComentario;
            try {
                graComentario = array[18].toString();
            } catch (Exception e) {
                graComentario = null;
            }
            Boolean anulado;
            try {
                anulado = Boolean.parseBoolean(array[19].toString());
            } catch (Exception e) {
                anulado = null;
            }
            String pisEmpresa;
            try {
                pisEmpresa = array[20].toString();
            } catch (Exception e) {
                pisEmpresa = null;
            }
            String pisSector;
            try {
                pisSector = array[21].toString();
            } catch (Exception e) {
                pisSector = null;
            }
            String pisNumero;
            try {
                pisNumero = array[22].toString();
            } catch (Exception e) {
                pisNumero = null;
            }
            String usrEmpresa;
            try {
                usrEmpresa = array[23].toString();
            } catch (Exception e) {
                usrEmpresa = null;
            }
            String usrCodigo;
            try {
                usrCodigo = array[24].toString();
            } catch (Exception e) {
                usrCodigo = null;
            }
            String usrFecha;
            try {
                usrFecha = validaciones.Validacion.fecha(validaciones.Validacion.fechaString_Date(array[25].toString()), "yyyy-MM-dd");
            } catch (Exception e) {
                usrFecha = null;
            }


            if (datos.isEmpty()) {
                prdGrameajeTO = null;
            } else {
                prdGrameajeTO = new produccion.TO.PrdGrameajeTO();
                prdGrameajeTO.setGraEmpresa(empresa);
                prdGrameajeTO.setGraSector(sector);
                prdGrameajeTO.setGraPiscina(piscina);
                prdGrameajeTO.setGraFecha(fecha);
                prdGrameajeTO.setGraTGrande(graTgrande);
                prdGrameajeTO.setGraTMediano(graTmediano);
                prdGrameajeTO.setGraTPequeno(graTpequeno);
                prdGrameajeTO.setGraTPromedio(graTpromedio);
                prdGrameajeTO.setGraItGrande(graItGrande);
                prdGrameajeTO.setGraItMediano(graItMediano);
                prdGrameajeTO.setGraItPequeno(graItPequeno);
                prdGrameajeTO.setGraItPromedio(graItPromedio);
                prdGrameajeTO.setGraBiomasa(graBiomasa);
                prdGrameajeTO.setGraSobrevivencia(graSobrevivencia);
                prdGrameajeTO.setGraAlimentacion(graAlimentacion);
                prdGrameajeTO.setGraLibrasBalanceado(graLibrasBalanceado);
                prdGrameajeTO.setGraCostoDirecto(graCostoDirecto);
                prdGrameajeTO.setGraCostoIndirecto(graCostoIndirecto);
                prdGrameajeTO.setGraComentario(graComentario);


                prdGrameajeTO.setGraAnulado(anulado);
                prdGrameajeTO.setPisEmpresa(pisEmpresa);
                prdGrameajeTO.setPisSector(pisSector);
                prdGrameajeTO.setPisNumero(pisNumero);
                prdGrameajeTO.setUsrEmpresa(usrEmpresa);
                prdGrameajeTO.setUsrCodigo(usrCodigo);
                prdGrameajeTO.setUsrFechaInsertaGrameaje(usrFecha);
            }
//            new inventario.TO.InvCompraCabeceraTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18);
        }
        return prdGrameajeTO;
    }

    public static List<produccion.TO.MultiplePiscinaCorrida> convertirMultiplePiscinaCorrida_MultiplePiscinaCorridaPersonalizadoTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[1].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[2].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[3].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[4].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[5].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new produccion.TO.MultiplePiscinaCorrida(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdCostoPorFechaProrrateadoTO> convertirPrdCostoPorFechaProrrateadoTO_PrdCostoPorFechaProrrateadoTO(java.util.List datos) {
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new produccion.TO.PrdCostoPorFechaProrrateadoTO(
                    dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdFunCostosPorFechaSimpleTO> convertirPrdFunCostosPorFechaSimple_PrdFunCostosPorFechaSimpleTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String costo_sector;
            try {
                costo_sector = array[0].toString();
            } catch (Exception e) {
                costo_sector = null;
            }
            String costo_piscina;
            try {
                costo_piscina = array[1].toString();
            } catch (Exception e) {
                costo_piscina = null;
            }
            String costo_corrida;
            try {
                costo_corrida = array[2].toString();
            } catch (Exception e) {
                costo_corrida = null;
            }
            java.math.BigDecimal costo_total;
            try {
                costo_total = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                costo_total = null;
            }
            lista.add(new produccion.TO.PrdFunCostosPorFechaSimpleTO(
                    costo_sector, costo_piscina, costo_corrida, costo_total));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdCostoPorPiscinaSemanalTO> convertirPrdCostoPorPiscinaSemanalTO_PrdCostoPorPiscinaSemanalTO(java.util.List datos) {
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new produccion.TO.PrdCostoPorPiscinaSemanalTO(
                    dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdConsumoPorFechaDesglosadoTO> convertirPrdConsumoPorFechaDesglosadoTO_PrdConsumoPorFechaDesglosadoTO(java.util.List datos) {
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new produccion.TO.PrdConsumoPorFechaDesglosadoTO(
                    dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdConsumoProductoEnProcesoTO> convertirPrdConsumoProductoEnProcesoTO_PrdConsumoProductoEnProcesoTO(java.util.List datos) {
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new produccion.TO.PrdConsumoProductoEnProcesoTO(
                    dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdConsumoMultiplePiscinaTO> convertirPrdConsumoMultiplePiscinaTO_PrdConsumoMultiplePiscinaTO(java.util.List datos) {
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new produccion.TO.PrdConsumoMultiplePiscinaTO(
                    dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdConsumosTO> convertirPrdConsumos_PrdConsumosTO(java.util.List datos) {
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
            lista.add(new produccion.TO.PrdConsumosTO(
                    dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdConsumosPorPiscinaPeriodoTO> convertirPrdConsumosPorPiscinaPeriodoTO_PrdConsumosPorPiscinaPeriodoTO(java.util.List datos) {
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new produccion.TO.PrdConsumosPorPiscinaPeriodoTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static List<PrdListaSectorConHectareajeTO> convertirListaPrdSectorConHectareaje_ListaPrdSectorConHectareajeTO(List datos) {
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
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new PrdListaSectorConHectareajeTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static List<produccion.TO.PrdResumenFinancieroTO> convertirPrdResumenFinanciero_PrdResumenFinancieroTO(List datos) {
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
            lista.add(new produccion.TO.PrdResumenFinancieroTO(dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdResumenPescaTO> convertirPrdResumenPesca_PrdResumenPescaTO(java.util.List datos) {
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
            Integer dato11;
            try {
                dato11 = new Integer(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            Integer dato12;
            try {
                dato12 = new Integer(array[11].toString());
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
            java.math.BigDecimal dato18;
            try {
                dato18 = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                dato18 = null;
            }
            java.math.BigDecimal dato19;
            try {
                dato19 = new java.math.BigDecimal(array[18].toString());
            } catch (Exception e) {
                dato19 = null;
            }
            java.math.BigDecimal dato20;
            try {
                dato20 = new java.math.BigDecimal(array[19].toString());
            } catch (Exception e) {
                dato20 = null;
            }
            String dato21;
            try {
                dato21 = array[20].toString();
            } catch (Exception e) {
                dato21 = null;
            }
            String dato22;
            try {
                dato22 = array[21].toString();
            } catch (Exception e) {
                dato22 = null;
            }
            java.math.BigDecimal dato23;
            try {
                dato23 = new java.math.BigDecimal(array[22].toString());
            } catch (Exception e) {
                dato23 = null;
            }
            lista.add(new produccion.TO.PrdResumenPescaTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18, dato19, dato20, dato21, dato22, dato23));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdResumenSiembraTO> convertirPrdResumenSiembra_PrdResumenSiembraTO(java.util.List datos) {
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
            Integer dato11;
            try {
                dato11 = new Integer(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            Integer dato12;
            try {
                dato12 = new Integer(array[11].toString());
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
            java.math.BigDecimal dato18;
            try {
                dato18 = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                dato18 = null;
            }
            java.math.BigDecimal dato19;
            try {
                dato19 = new java.math.BigDecimal(array[18].toString());
            } catch (Exception e) {
                dato19 = null;
            }
            java.math.BigDecimal dato20;
            try {
                dato20 = new java.math.BigDecimal(array[19].toString());
            } catch (Exception e) {
                dato20 = null;
            }
            String dato21;
            try {
                dato21 = array[20].toString();
            } catch (Exception e) {
                dato21 = null;
            }
            String dato22;
            try {
                dato22 = array[21].toString();
            } catch (Exception e) {
                dato22 = null;
            }
            java.math.BigDecimal dato23;
            try {
                dato23 = new java.math.BigDecimal(array[22].toString());
            } catch (Exception e) {
                dato23 = null;
            }
            lista.add(new produccion.TO.PrdResumenSiembraTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18, dato19, dato20, dato21, dato22, dato23));
        }
        return lista;
    }

    public static produccion.TO.PrdLiquidacionMotivoTO convertirPrdLiquidacionMotivo_PrdLiquidacionMotivoTO(produccion.entity.PrdLiquidacionMotivo prdLiquidacionMotivo) {
        produccion.TO.PrdLiquidacionMotivoTO prdLiquidacionMotivoTO = new produccion.TO.PrdLiquidacionMotivoTO();
        prdLiquidacionMotivoTO.setLmEmpresa(prdLiquidacionMotivo.getPrdLiquidacionMotivoPK().getLmEmpresa());
        prdLiquidacionMotivoTO.setLmCodigo(prdLiquidacionMotivo.getPrdLiquidacionMotivoPK().getLmCodigo());
        prdLiquidacionMotivoTO.setLmDetalle(prdLiquidacionMotivo.getLmDetalle());
        prdLiquidacionMotivoTO.setLmInactivo(prdLiquidacionMotivo.getLmInactivo());
        prdLiquidacionMotivoTO.setUsrCodigo(prdLiquidacionMotivo.getUsrCodigo());
        prdLiquidacionMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(prdLiquidacionMotivo.getUsrFechaInserta(), "yyyy-MM-dd"));
        return prdLiquidacionMotivoTO;
    }

    public static produccion.entity.PrdLiquidacionMotivo convertirPrdLiquidacionMotivoTO_PrdLiquidacionMotivo(produccion.TO.PrdLiquidacionMotivoTO prdLiquidacionMotivoTO) {
        produccion.entity.PrdLiquidacionMotivo prdLiquidacionMotivo = new produccion.entity.PrdLiquidacionMotivo();
        prdLiquidacionMotivo.setPrdLiquidacionMotivoPK(new produccion.entity.PrdLiquidacionMotivoPK(prdLiquidacionMotivoTO.getLmEmpresa(), prdLiquidacionMotivoTO.getLmCodigo()));
        prdLiquidacionMotivo.setLmDetalle(prdLiquidacionMotivoTO.getLmDetalle());
        prdLiquidacionMotivo.setLmInactivo(prdLiquidacionMotivoTO.getLmInactivo());
        prdLiquidacionMotivo.setUsrEmpresa(prdLiquidacionMotivoTO.getLmEmpresa());
        prdLiquidacionMotivo.setUsrCodigo(prdLiquidacionMotivoTO.getUsrCodigo());
        prdLiquidacionMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(prdLiquidacionMotivoTO.getUsrFechaInserta()));
        return prdLiquidacionMotivo;
    }

    public static produccion.entity.PrdLiquidacionTalla convertirPrdLiquidacionTallaTO_PrdLiquidacionTalla(produccion.TO.PrdLiquidacionTallaTO prdLiquidacionTallaTO) {
        produccion.entity.PrdLiquidacionTalla prdLiquidacionTalla = new produccion.entity.PrdLiquidacionTalla();
        prdLiquidacionTalla.setPrdLiquidacionTallaPK(new produccion.entity.PrdLiquidacionTallaPK(prdLiquidacionTallaTO.getTallaEmpresa(), prdLiquidacionTallaTO.getTallaCodigo()));
        prdLiquidacionTalla.setTallaDetalle(prdLiquidacionTallaTO.getTallaDetalle());
        prdLiquidacionTalla.setTallaInactivo(prdLiquidacionTallaTO.getTallaInactivo());
        prdLiquidacionTalla.setUsrEmpresa(prdLiquidacionTallaTO.getTallaEmpresa());
        prdLiquidacionTalla.setUsrCodigo(prdLiquidacionTallaTO.getUsrCodigo());
        prdLiquidacionTalla.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(prdLiquidacionTallaTO.getUsrFechaInserta()));
        return prdLiquidacionTalla;
    }

    public static produccion.TO.PrdLiquidacionTallaTO convertirPrdLiquidacionTalla_PrdLiquidacionTallaTO(produccion.entity.PrdLiquidacionTalla prdLiquidacionTalla) {
        produccion.TO.PrdLiquidacionTallaTO prdLiquidacionMotivoTO = new produccion.TO.PrdLiquidacionTallaTO();
        prdLiquidacionMotivoTO.setTallaEmpresa(prdLiquidacionTalla.getPrdLiquidacionTallaPK().getTallaEmpresa());
        prdLiquidacionMotivoTO.setTallaCodigo(prdLiquidacionTalla.getPrdLiquidacionTallaPK().getTallaCodigo());
        prdLiquidacionMotivoTO.setTallaDetalle(prdLiquidacionTalla.getTallaDetalle());
        prdLiquidacionMotivoTO.setTallaInactivo(prdLiquidacionTalla.getTallaInactivo());
        prdLiquidacionMotivoTO.setUsrCodigo(prdLiquidacionTalla.getUsrCodigo());
        prdLiquidacionMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(prdLiquidacionTalla.getUsrFechaInserta(), "yyyy-MM-dd"));
        return prdLiquidacionMotivoTO;
    }

    public static java.util.List<produccion.TO.PrdLiquidacionMotivoTablaTO> convertirListaPrdLiquidacionMotivo_ListaPrdLiquidacionMotivoTO(java.util.List datos) {
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

            lista.add(new produccion.TO.PrdLiquidacionMotivoTablaTO(dato1, dato2));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdLiquidacionTallaTablaTO> convertirListaPrdLiquidacionTalla_ListaPrdLiquidacionTallaTO(java.util.List datos) {
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

            lista.add(new produccion.TO.PrdLiquidacionTallaTablaTO(dato1, dato2));
        }
        return lista;
    }

    public static produccion.TO.PrdLiquidacionProductoTO convertirPrdLiquidacionProducto_PrdLiquidacionProductoTO(produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto) {
        produccion.TO.PrdLiquidacionProductoTO prdLiquidacionProductoTO = new produccion.TO.PrdLiquidacionProductoTO();
        prdLiquidacionProductoTO.setProdEmpresa(prdLiquidacionProducto.getPrdLiquidacionProductoPK().getProdEmpresa());
        prdLiquidacionProductoTO.setProdCodigo(prdLiquidacionProducto.getPrdLiquidacionProductoPK().getProdCodigo());
        prdLiquidacionProductoTO.setProdDetalle(prdLiquidacionProducto.getProdDetalle());
        prdLiquidacionProductoTO.setProdTipo(prdLiquidacionProducto.getProdTipo());
        prdLiquidacionProductoTO.setProdClase(prdLiquidacionProducto.getProdClase());
        prdLiquidacionProductoTO.setProdInactivo(prdLiquidacionProducto.getProdInactivo());
        prdLiquidacionProductoTO.setUsrCodigo(prdLiquidacionProducto.getUsrCodigo());
        prdLiquidacionProductoTO.setUsrFechaInserta(validaciones.Validacion.fecha(prdLiquidacionProducto.getUsrFechaInserta(), "yyyy-MM-dd"));
        return prdLiquidacionProductoTO;
    }

    public static produccion.entity.PrdLiquidacionProducto convertirPrdLiquidacionProductoTO_PrdLiquidacionProducto(produccion.TO.PrdLiquidacionProductoTO prdLiquidacionProductoTO) {
        produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto = new produccion.entity.PrdLiquidacionProducto();
        prdLiquidacionProducto.setPrdLiquidacionProductoPK(new produccion.entity.PrdLiquidacionProductoPK(prdLiquidacionProductoTO.getProdEmpresa(), prdLiquidacionProductoTO.getProdCodigo()));
        prdLiquidacionProducto.setProdDetalle(prdLiquidacionProductoTO.getProdDetalle());
        prdLiquidacionProducto.setProdTipo(prdLiquidacionProductoTO.getProdTipo());
        prdLiquidacionProducto.setProdClase(prdLiquidacionProductoTO.getProdClase());
        prdLiquidacionProducto.setProdInactivo(prdLiquidacionProductoTO.getProdInactivo());
        prdLiquidacionProducto.setUsrEmpresa(prdLiquidacionProductoTO.getProdEmpresa());
        prdLiquidacionProducto.setUsrCodigo(prdLiquidacionProductoTO.getUsrCodigo());
        prdLiquidacionProducto.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(prdLiquidacionProductoTO.getUsrFechaInserta()));
        return prdLiquidacionProducto;
    }

    public static java.util.List<produccion.TO.PrdLiquidacionProductoTablaTO> convertirListaPrdLiquidacionProducto_ListaPrdLiquidacionProductoTO(java.util.List datos) {
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
            Character dato4;
            try {
                dato4 = array[3].toString().charAt(0);
            } catch (Exception e) {
                dato4 = new Character(' ');
            }

            lista.add(new produccion.TO.PrdLiquidacionProductoTablaTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdListaDetalleLiquidacionTO> convertirPrdListaLiquidacionDetalle_PrdListaLiquidacionDetalleTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
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
            char dato3;
            try {
                dato3 = array[2].toString().charAt(0);
            } catch (Exception e) {
                dato3 = ' ';
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = java.math.BigDecimal.ZERO;
            }
            Integer dato8;
            try {
                dato8 = Integer.parseInt(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            lista.add(new produccion.TO.PrdListaDetalleLiquidacionTO(dato1, dato8, dato5, dato2, dato3, dato4, dato6, dato7));
        }
        return lista;
    }

    public static produccion.entity.PrdLiquidacionDetalle convertirPrdLiquidacionDetalleTO_PrdLiquidacionDetalle(produccion.TO.PrdLiquidacionDetalleTO prdLiquidacionDetalleTO) {
        produccion.entity.PrdLiquidacionDetalle prdLiquidacionDetalle = new produccion.entity.PrdLiquidacionDetalle();
        prdLiquidacionDetalle.setDetSecuencial(prdLiquidacionDetalleTO.getDetSecuencial());
        prdLiquidacionDetalle.setDetLibras(prdLiquidacionDetalleTO.getDetLibras());
        prdLiquidacionDetalle.setDetPrecio(prdLiquidacionDetalleTO.getDetPrecio());
        prdLiquidacionDetalle.setDetOrden(prdLiquidacionDetalleTO.getDetOrden());
        return prdLiquidacionDetalle;
    }

    public static produccion.entity.PrdLiquidacionProducto convertirPrdLiquidacionProducto_PrdLiquidacionProducto(produccion.entity.PrdLiquidacionProducto prdLiquidacionProductoOrigen) {
        produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto = new produccion.entity.PrdLiquidacionProducto();
        prdLiquidacionProducto.setPrdLiquidacionProductoPK(new produccion.entity.PrdLiquidacionProductoPK(prdLiquidacionProductoOrigen.getPrdLiquidacionProductoPK().getProdEmpresa(), prdLiquidacionProductoOrigen.getPrdLiquidacionProductoPK().getProdCodigo()));
        prdLiquidacionProducto.setProdClase(prdLiquidacionProductoOrigen.getProdClase());
        prdLiquidacionProducto.setProdTipo(prdLiquidacionProductoOrigen.getProdTipo());
        prdLiquidacionProducto.setProdInactivo(prdLiquidacionProductoOrigen.getProdInactivo());
        prdLiquidacionProducto.setProdDetalle(prdLiquidacionProductoOrigen.getProdDetalle());

        prdLiquidacionProducto.setUsrEmpresa(prdLiquidacionProductoOrigen.getUsrEmpresa());
        prdLiquidacionProducto.setUsrCodigo(prdLiquidacionProductoOrigen.getUsrCodigo());
        prdLiquidacionProducto.setUsrFechaInserta(prdLiquidacionProductoOrigen.getUsrFechaInserta());
        return prdLiquidacionProducto;
    }

    public static produccion.entity.PrdLiquidacion convertirPrdLiquidacionTO_PrdLiquidacion(produccion.TO.PrdLiquidacionTO prdLiquidacionTO) {
        produccion.entity.PrdLiquidacion prdLiquidacion = new produccion.entity.PrdLiquidacion();
        prdLiquidacion.setPrdLiquidacionPK(new produccion.entity.PrdLiquidacionPK(prdLiquidacionTO.getLiqEmpresa(), prdLiquidacionTO.getLiqMotivo(), prdLiquidacionTO.getLiqNumero()));
        prdLiquidacion.setPrdPiscina(new PrdPiscina(
                prdLiquidacionTO.getPisEmpresa(),
                prdLiquidacionTO.getPisSector(),
                prdLiquidacionTO.getPisNumero()));

        prdLiquidacion.setLiqAnimalesCosechados(prdLiquidacionTO.getLiqAnimalesCosechados());
        prdLiquidacion.setLiqAnulado(prdLiquidacionTO.isLiqAnulado());
        prdLiquidacion.setLiqFecha(validaciones.Validacion.fecha(prdLiquidacionTO.getLiqFecha(), "yyyy-MM-dd"));
//        invCompras.setProvCodigo(invComprasTO.getProvCodigo());
        prdLiquidacion.setLiqLibrasBasura(prdLiquidacionTO.getLiqLibrasBasura());
        prdLiquidacion.setLiqLibrasCola(prdLiquidacionTO.getLiqLibrasCola());
        prdLiquidacion.setLiqLibrasColaProcesadas(prdLiquidacionTO.getLiqLibrasColaProcesadas());
        prdLiquidacion.setLiqLibrasEntero(prdLiquidacionTO.getLiqLibrasEntero());
        prdLiquidacion.setLiqLibrasEnviadas(prdLiquidacionTO.getLiqLibrasEnviadas());
        prdLiquidacion.setLiqLibrasNetas(prdLiquidacionTO.getLiqLibrasNetas());
        prdLiquidacion.setLiqLibrasRecibidas(prdLiquidacionTO.getLiqLibrasRecibidas());
        prdLiquidacion.setLiqLibrasRetiradas(prdLiquidacionTO.getLiqLibrasRetiradas());
        prdLiquidacion.setLiqLote(prdLiquidacionTO.getLiqLote());
        prdLiquidacion.setLiqPendiente(prdLiquidacionTO.isLiqPendiente());
        prdLiquidacion.setLiqTotalMonto(prdLiquidacionTO.getLiqTotalMonto());

        /*
         * prdLiquidacion.setCliCodigo(prdLiquidacionTO.getCliCodigo());
         * prdLiquidacion.setCliEmpresa(prdLiquidacionTO.getCliEmpresa());
         */

        prdLiquidacion.setUsrEmpresa(prdLiquidacionTO.getUsrEmpresa());
        prdLiquidacion.setUsrCodigo(prdLiquidacionTO.getUsrCodigo());
        prdLiquidacion.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(prdLiquidacionTO.getUsrFechaInserta()));
        return prdLiquidacion;
    }

    public static inventario.entity.InvProformasDetalle convertirInvProformasDetalleTO_InvProformasDetalle(
            inventario.TO.InvProformasDetalleTO invProformasDetalleTO) {
        inventario.entity.InvProformasDetalle invProformasDetalle = new inventario.entity.InvProformasDetalle();
        invProformasDetalle.setDetSecuencial(invProformasDetalleTO.getDetSecuencia());
        invProformasDetalle.setDetOrden(invProformasDetalleTO.getDetOrden());
        invProformasDetalle.setDetCantidad(invProformasDetalleTO.getDetCantidad());
        invProformasDetalle.setDetPrecio(invProformasDetalleTO.getDetPrecio());

//        invVentasDetalle.setDetValorPromedio(new java.math.BigDecimal("0.00"));
//        invVentasDetalle.setDetValorUltimaCompra(new java.math.BigDecimal("0.00"));

        invProformasDetalle.setDetPorcentajeDescuento(invProformasDetalleTO.getDetPorcentajeDescuento());
//        invVentasDetalle.setBodEmpresa(invVentasDetalleTO.getBodEmpresa());
        invProformasDetalle.setProNombre(invProformasDetalleTO.getProNombre());
        return invProformasDetalle;
    }

    public static java.util.List<produccion.TO.PrdLiquidacionMotivoComboTO> convertirListaLiquidacionMotivoCombo_ListaLiquidacionMotivoComboTO(java.util.List datos) {
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

            lista.add(new produccion.TO.PrdLiquidacionMotivoComboTO(dato1, dato2));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdListaConsultaLiquidacionTO> convertirPrdListaConsultaLiquidacion_PrdListaConsultaLiquidacionTO(java.util.List datos) {
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
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = java.math.BigDecimal.ZERO;
            }
            BigDecimal dato10;
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = java.math.BigDecimal.ZERO;
            }
            BigDecimal dato11;
            try {
                dato11 = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = java.math.BigDecimal.ZERO;
            }
            BigDecimal dato12;
            try {
                dato12 = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                dato12 = java.math.BigDecimal.ZERO;
            }
            BigDecimal dato13;
            try {
                dato13 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                dato13 = java.math.BigDecimal.ZERO;
            }
            BigDecimal dato14;
            try {
                dato14 = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                dato14 = java.math.BigDecimal.ZERO;
            }
            BigDecimal dato15;
            try {
                dato15 = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                dato15 = java.math.BigDecimal.ZERO;
            }
            BigDecimal dato16;
            try {
                dato16 = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                dato16 = java.math.BigDecimal.ZERO;
            }
            BigDecimal dato17;
            try {
                dato17 = new java.math.BigDecimal(array[16].toString());
            } catch (Exception e) {
                dato17 = java.math.BigDecimal.ZERO;
            }
            BigDecimal dato18;
            try {
                dato18 = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                dato18 = java.math.BigDecimal.ZERO;
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
            lista.add(new produccion.TO.PrdListaConsultaLiquidacionTO(dato1, dato2, dato3, dato4, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18, dato19, dato20, dato7, dato8, dato5, dato6));
        }
        return lista;
    }

    /*
     * private String apSector;//character(7), private String
     * apPiscina;//character(7),
     *
     * private BigDecimal apCorrida;//numeric(6,2), private BigDecimal
     * apHectareas;//numeric(6,2), private BigDecimal apDensidad;//numeric(6,2),
     * private BigDecimal apRaleo;//numeric(6,2), private BigDecimal
     * apSobrevivencia;//numeric(6,2), private BigDecimal apEdad;//numeric(6,2),
     * private BigDecimal apPesoIdeal;//numeric(6,2), private BigDecimal
     * apPesoSobreIdeal;//numeric(6,2), private BigDecimal
     * apPesoPromedioActual;// numeric(6,2), private BigDecimal
     * apPesoPromedioTallaGrande; //numeric(6,2),
     *
     */
    /*
     * private BigDecimal apPesoPromedioTallaPequeno;//numeric(6,2), private
     * BigDecimal apPesoIncrementoTallaGrandeSemana4;//numeric(6,2), private
     * BigDecimal apPesoIncrementoTallaPequenoSemana4;// numeric(6,2), private
     * BigDecimal apPesoIncrementoTallaGrandeSemana3;//numeric(6,2), private
     * BigDecimal apPesoIncrementoTallaPequenoSemana3;// numeric(6,2), private
     * BigDecimal apPesoIncrementoTallaGrandeSemana2;// numeric(6,2), private
     * BigDecimal apPesoIncrementoTallaPequenoSemana2;// numeric(6,2), private
     * BigDecimal apPesoIncrementoTallaGrandeSemana1;// numeric(6,2), private
     * BigDecimal apPesoIncrementoTallaPequenoSemana1;// numeric(6,2), private
     * BigDecimal apPesoIncrementoPromedio; // numeric(6,2),
     *
     *//*
     * private BigDecimal apBalanceadoCantidadSacos; //numeric(6,2), private
     * String apBalanceadoTipo;// character(50), private BigDecimal
     * apBalanceadoProporcion; //numeric(6,2), private String apLaboratorio;//
     * character(25), private String apNauplio;// character(25),
     */

    public static java.util.List<produccion.TO.PrdListaFunAnalisisPesosTO> convertirPrdListaFunAnalisisPesos_PrdListaFunAnalisisPesosTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();


            Object[] array = ((java.util.List) obj).toArray();
            String ap_sector;
            try {
                ap_sector = array[0].toString();
            } catch (Exception e) {
                ap_sector = null;
            }
            String ap_piscina;
            try {
                ap_piscina = array[1].toString();
            } catch (Exception e) {
                ap_piscina = null;
            }

            ///
            String ap_corrida;
            try {
                ap_corrida = array[2].toString();
            } catch (Exception e) {
                ap_corrida = null;
            }

            BigDecimal ap_hectareas;
            try {
                ap_hectareas = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                ap_hectareas = java.math.BigDecimal.ZERO;
            }
            String ap_fecha_siembra;
            try {
                ap_fecha_siembra = array[4].toString();
            } catch (Exception e) {
                ap_fecha_siembra = null;
            }
            String ap_forma_siembra;
            try {
                ap_forma_siembra = array[5].toString();
            } catch (Exception e) {
                ap_forma_siembra = null;
            }
            BigDecimal ap_densidad_metro_cuadrado;
            try {
                ap_densidad_metro_cuadrado = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                ap_densidad_metro_cuadrado = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_sobrevivencia_metro_cuadrado;
            try {
                ap_sobrevivencia_metro_cuadrado = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                ap_sobrevivencia_metro_cuadrado = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_raleo;
            try {
                ap_raleo = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                ap_raleo = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_edad;
            try {
                ap_edad = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                ap_edad = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_peso_ideal;
            try {
                ap_peso_ideal = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                ap_peso_ideal = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_peso_sobre_ideal;
            try {
                ap_peso_sobre_ideal = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                ap_peso_sobre_ideal = java.math.BigDecimal.ZERO;
            }
            ////
            BigDecimal ap_peso_promedio_actual;
            try {
                ap_peso_promedio_actual = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                ap_peso_promedio_actual = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_peso_incremento_semana_4;
            try {
                ap_peso_incremento_semana_4 = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                ap_peso_incremento_semana_4 = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_peso_incremento_semana_3;
            try {
                ap_peso_incremento_semana_3 = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                ap_peso_incremento_semana_3 = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_peso_incremento_semana_2;
            try {
                ap_peso_incremento_semana_2 = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                ap_peso_incremento_semana_2 = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_peso_incremento_semana_1;
            try {
                ap_peso_incremento_semana_1 = new java.math.BigDecimal(array[16].toString());
            } catch (Exception e) {
                ap_peso_incremento_semana_1 = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_peso_incremento_promedio;
            try {
                ap_peso_incremento_promedio = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                ap_peso_incremento_promedio = java.math.BigDecimal.ZERO;
            }
            ///
            String ap_balanceado_tipo;
            try {
                ap_balanceado_tipo = array[18].toString();
            } catch (Exception e) {
                ap_balanceado_tipo = null;
            }
            BigDecimal ap_balanceado_sacos;
            try {
                ap_balanceado_sacos = new java.math.BigDecimal(array[19].toString());
            } catch (Exception e) {
                ap_balanceado_sacos = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_balanceado_kilos_hectarea;
            try {
                ap_balanceado_kilos_hectarea = new java.math.BigDecimal(array[20].toString());
            } catch (Exception e) {
                ap_balanceado_kilos_hectarea = java.math.BigDecimal.ZERO;
            }
            BigDecimal ap_balanceado_acumulado;
            try {
                ap_balanceado_acumulado = new java.math.BigDecimal(array[21].toString());
            } catch (Exception e) {
                ap_balanceado_acumulado = java.math.BigDecimal.ZERO;
            }
            ////

            BigDecimal ap_biomasa_proyectada;
            try {
                ap_biomasa_proyectada = new java.math.BigDecimal(array[22].toString());
            } catch (Exception e) {
                ap_biomasa_proyectada = java.math.BigDecimal.ZERO;
            }

            BigDecimal ap_conversion_alimenticia;
            try {
                ap_conversion_alimenticia = new java.math.BigDecimal(array[23].toString());
            } catch (Exception e) {
                ap_conversion_alimenticia = java.math.BigDecimal.ZERO;;
            }

            String ap_laboratorio;
            try {
                ap_laboratorio = array[24].toString();
            } catch (Exception e) {
                ap_laboratorio = null;
            }

            String ap_nauplio;
            try {
                ap_nauplio = array[25].toString();
            } catch (Exception e) {
                ap_nauplio = null;
            }



            lista.add(new produccion.TO.PrdListaFunAnalisisPesosTO(
                    ap_sector,
                    ap_piscina,
                    ap_corrida,
                    ap_hectareas,
                    ap_fecha_siembra,
                    ap_forma_siembra,
                    ap_densidad_metro_cuadrado,
                    ap_sobrevivencia_metro_cuadrado,
                    ap_raleo,
                    ap_edad,
                    ap_peso_ideal,
                    ap_peso_sobre_ideal,
                    ap_peso_promedio_actual,
                    ap_peso_incremento_semana_4,
                    ap_peso_incremento_semana_3,
                    ap_peso_incremento_semana_2,
                    ap_peso_incremento_semana_1,
                    ap_peso_incremento_promedio,
                    ap_balanceado_tipo,
                    ap_balanceado_sacos,
                    ap_balanceado_kilos_hectarea,
                    ap_balanceado_acumulado,
                    ap_biomasa_proyectada,
                    ap_conversion_alimenticia,
                    ap_laboratorio,
                    ap_nauplio));
        }
        return lista;
    }

    public static java.util.List<produccion.TO.PrdListaFunAnalisisPesosComplementoTO> convertirPrdListaFunAnalisisPesosComplemento_PrdListaFunAnalisisPesosComplementoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();


            Object[] array = ((java.util.List) obj).toArray();
            String ap_sector;
            try {
                ap_sector = array[0].toString();
            } catch (Exception e) {
                ap_sector = null;
            }
            String ap_piscina;
            try {
                ap_piscina = array[1].toString();
            } catch (Exception e) {
                ap_piscina = null;
            }

            String ap_corrida;
            try {
                ap_corrida = array[2].toString();
            } catch (Exception e) {
                ap_corrida = null;
            }

            String ap_fecha;
            try {
                ap_fecha = array[3].toString();
            } catch (Exception e) {
                ap_fecha = null;
            }

            BigDecimal ap_incremento;
            try {
                ap_incremento = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                ap_incremento = java.math.BigDecimal.ZERO;
            }




            lista.add(new produccion.TO.PrdListaFunAnalisisPesosComplementoTO(
                    ap_sector,
                    ap_piscina,
                    ap_corrida,
                    ap_fecha,
                    ap_incremento));
        }
        return lista;
    }

    public static produccion.TO.PrdEstadoCCCVT convertirPrdEstadoCCVTConsulta_PrdEstadoCCVT(java.util.List datos) {
        produccion.TO.PrdEstadoCCCVT prdEstadoCCVT = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            Boolean dato1;
            try {
                dato1 = Boolean.parseBoolean(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            Boolean dato2;
            try {
                dato2 = Boolean.parseBoolean(array[1].toString());
            } catch (Exception e) {
                dato2 = null;
            }

            if (datos.isEmpty()) {
                prdEstadoCCVT = null;
            } else {
                prdEstadoCCVT = new produccion.TO.PrdEstadoCCCVT(dato1, dato2);
            }
        }
        return prdEstadoCCVT;
    }
    //gra_fecha java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> 

    public static java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> convertirPrdListaConsultaGrameajePromedioPorPiscina_PrdListaConsultaGrameajePromedioPorPiscinaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String gra_fecha;
            try {
                gra_fecha = array[0].toString();
            } catch (Exception e) {
                gra_fecha = null;
            }
            String gra_piscina;
            try {
                gra_piscina = array[1].toString();
            } catch (Exception e) {
                gra_piscina = null;
            }
            String cor_fecha_siembra;
            try {
                cor_fecha_siembra = array[2].toString();
            } catch (Exception e) {
                cor_fecha_siembra = null;
            }
            String gra_edad;
            try {
                gra_edad = array[3].toString();
            } catch (Exception e) {
                gra_edad = null;
            }
            String gra_tpromedio;
            try {
                gra_tpromedio = array[4].toString();
            } catch (Exception e) {
                gra_tpromedio = null;
            }
            lista.add(new produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO(
                    gra_fecha,
                    gra_piscina,
                    cor_fecha_siembra,
                    gra_edad,
                    gra_tpromedio));
        }
        return lista;
    }

    public static produccion.TO.PrdLiquidacionCabeceraTO convertirPrdLiquidacionCabecera_PrdLiquidacionCabeceraTO(java.util.List datos) {
        produccion.TO.PrdLiquidacionCabeceraTO prdLiquidacionCabeceraTO = null;
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
            java.math.BigDecimal dato3;
            try {
                dato3 = new java.math.BigDecimal(array[2].toString());
            } catch (Exception e) {
                dato3 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = java.math.BigDecimal.ZERO;
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
            java.math.BigDecimal dato12;
            try {
                dato12 = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                dato12 = java.math.BigDecimal.ZERO;
            }
            Boolean dato13;
            try {
                dato13 = Boolean.parseBoolean(array[12].toString());
            } catch (Exception e) {
                dato13 = null;
            }
            Boolean dato14;
            try {
                dato14 = Boolean.parseBoolean(array[13].toString());
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
            String dato20;
            try {
                dato20 = array[19].toString();
            } catch (Exception e) {
                dato20 = null;
            }
            String dato21;
            try {
                dato21 = array[20].toString();
            } catch (Exception e) {
                dato21 = null;
            }
            String dato22;
            try {
                dato22 = array[21].toString();
            } catch (Exception e) {
                dato22 = null;
            }

            if (datos.isEmpty()) {
                prdLiquidacionCabeceraTO = null;
            } else {
                prdLiquidacionCabeceraTO = new produccion.TO.PrdLiquidacionCabeceraTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18, dato19, dato20, dato21, dato22);
            }
        }
        return prdLiquidacionCabeceraTO;
    }
    
    public static List<String> convertirFechaSemanas(java.util.List datos) {
        List<String> listaFecha = new ArrayList();
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            listaFecha.add(dato1);
        }
        return listaFecha;
    }
}