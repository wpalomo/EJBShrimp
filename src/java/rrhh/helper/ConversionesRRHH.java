/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.text.StyledEditorKit;
import rrhh.TO.*;
import rrhh.entity.*;
import validaciones.Validacion;

/**
 *
 * @author misael
 */
public class ConversionesRRHH {
    // <editor-fold defaultstate="collapsed" desc="CATEGORIA">

    public static RhCategoria convertirRhCategoriaTO_RhCategoria(RhCategoriaTO rhCategoriaTO) throws Exception {
        RhCategoria rhCategoria = new RhCategoria();
        rhCategoria.setRhCategoriaPK(new RhCategoriaPK(
                rhCategoriaTO.getEmpCodigo(),
                rhCategoriaTO.getCatNombre()));
        rhCategoria.setCtaAnticipos(rhCategoriaTO.getCtaAnticipos());
        rhCategoria.setCtaPrestamos(rhCategoriaTO.getCtaPrestamos());
        rhCategoria.setCtaPorPagarBonos(rhCategoriaTO.getCtaPorPagarBonos());
        rhCategoria.setCtaPorPagarSueldo(rhCategoriaTO.getCtaPorPagarSueldo());
        rhCategoria.setCtaPorPagarImpuestoRenta(rhCategoriaTO.getCtaPorPagarImpuestoRenta());
        rhCategoria.setCtaPorPagarUtilidades(rhCategoriaTO.getCtaPorPagarUtilidades());
        rhCategoria.setCtaGastoBonos(rhCategoriaTO.getCtaGastoBonos());
        rhCategoria.setCtaGastoBonosNd(rhCategoriaTO.getCtaGastoBonosNd());
        rhCategoria.setCtaGastoBonoFijo(rhCategoriaTO.getCtaGastoBonoFijo());
        rhCategoria.setCtaGastoBonoFijoNd(rhCategoriaTO.getCtaGastoBonoFijoNd());
        rhCategoria.setCtaGastoOtrosIngresos(rhCategoriaTO.getCtaGastoOtrosIngresos());
        rhCategoria.setCtaGastoOtrosIngresosNd(rhCategoriaTO.getCtaGastoOtrosIngresosNd());
        rhCategoria.setCtaGastoSueldos(rhCategoriaTO.getCtaGastoSueldos());
        rhCategoria.setCtaAportepersonal(rhCategoriaTO.getCtaAportepersonal());
        rhCategoria.setCtaAportepatronal(rhCategoriaTO.getCtaAportepatronal());
        rhCategoria.setCtaIece(rhCategoriaTO.getCtaIece());
        rhCategoria.setCtaSecap(rhCategoriaTO.getCtaSecap());
        rhCategoria.setCtaXiii(rhCategoriaTO.getCtaXiii());
        rhCategoria.setCtaXiv(rhCategoriaTO.getCtaXiv());
        rhCategoria.setCtaFondoreserva(rhCategoriaTO.getCtaFondoreserva());
        rhCategoria.setCtaVacaciones(rhCategoriaTO.getCtaVacaciones());
        rhCategoria.setCtaDesahucio(rhCategoriaTO.getCtaDesahucio());
        rhCategoria.setCtaGastoAporteindividual(rhCategoriaTO.getCtaGastoAporteindividual());
        rhCategoria.setCtaGastoAportepatronal(rhCategoriaTO.getCtaGastoAportepatronal());
        rhCategoria.setCtaGastoIece(rhCategoriaTO.getCtaGastoIece());
        rhCategoria.setCtaGastoSecap(rhCategoriaTO.getCtaGastoSecap());
        rhCategoria.setCtaGastoXiii(rhCategoriaTO.getCtaGastoXiii());
        rhCategoria.setCtaGastoXiv(rhCategoriaTO.getCtaGastoXiv());
        rhCategoria.setCtaGastoFondoreserva(rhCategoriaTO.getCtaGastoFondoreserva());
        rhCategoria.setCtaGastoVacaciones(rhCategoriaTO.getCtaGastoVacaciones());
        rhCategoria.setCtaGastoSalarioDigno(rhCategoriaTO.getCtaGastoSalarioDigno());
        rhCategoria.setCtaGastoLiquidacionBono(rhCategoriaTO.getCtaGastoBonoLiquidacion());
        rhCategoria.setCtaGastoDesahucio(rhCategoriaTO.getCtaGastoDesahucio());
        rhCategoria.setCtaGastoDesahucioIntempestivo(rhCategoriaTO.getCtaGastoDesahucioIntempestivo());
        rhCategoria.setTipEmpresa(rhCategoriaTO.getEmpCodigo());
        rhCategoria.setTipCodigo(rhCategoriaTO.getTipCodigo());
        rhCategoria.setUsrEmpresa(rhCategoriaTO.getEmpCodigo());
        rhCategoria.setUsrCodigo(rhCategoriaTO.getUsrInsertaCategoria());
        rhCategoria.setUsrFechaInserta(Validacion.fechaString_Date(rhCategoriaTO.getUsrFechaInsertaCategoria()));
        return rhCategoria;
    }
    
    public static RhCtaIessTO convertirCtaRhIess_CtaRhIessTO(List datos) {
        RhCtaIessTO rhCtaIessTO = new RhCtaIessTO();
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
                dato7 = null;
            }
            rhCtaIessTO.setCtaAportepersonal(dato1);
            rhCtaIessTO.setEmpFechaAfiliacionIess(dato2);
            rhCtaIessTO.setEmpFechaPrimerIngreso(dato3);
            rhCtaIessTO.setEmpFechaPrimerSalida(dato4);
            rhCtaIessTO.setEmpFechaUltimoIngreso(dato5);
            rhCtaIessTO.setEmpFechaUltimoSalida(dato6);
            rhCtaIessTO.setEmpExtensionCoberturaIess(dato7);
        }
        return rhCtaIessTO;
    }
    
    private static String obtenerDatoString(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e) {
            return null;
        }
    }
    
    private static BigDecimal obtenerDatoBigDecimal(Object obj) {
        try {
            return new BigDecimal(obj.toString());
        } catch (Exception e) {
            return null;
        }
    }
    
    private static Integer obtenerDatoInteger(Object obj) {
        try {
            return Integer.parseInt(obj.toString());
        } catch (Exception e) {
            return null;
        }
    }
    
    private static Boolean obtenerDatoBoolean(Object obj) {
        try {
            return Boolean.parseBoolean(obj.toString());
        } catch (Exception e) {
            return null;
        }
    }
    
    public static RhCategoriaTO convertirRhCategoria_RhCategoriaTO(List datos) {
        RhCategoriaTO rhCategoriaTO = new RhCategoriaTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((List) obj).toArray(); //Object[] array = (Object[]) obj;
            String dato1 = obtenerDatoString(array[0]);
            String dato2 = obtenerDatoString(array[1]);
            String dato3 = obtenerDatoString(array[2]);
            String dato4 = obtenerDatoString(array[3]);
            String dato5 = obtenerDatoString(array[4]);
            String dato6 = obtenerDatoString(array[5]);
            String dato7 = obtenerDatoString(array[6]);
            String dato8 = obtenerDatoString(array[7]);
            String dato9 = obtenerDatoString(array[8]);
            String dato10 = obtenerDatoString(array[9]);
            String dato11 = obtenerDatoString(array[10]);
            String dato12 = obtenerDatoString(array[11]);
            String dato13 = obtenerDatoString(array[12]);
            String dato14 = obtenerDatoString(array[13]);
            String dato15 = obtenerDatoString(array[14]);
            String dato16 = obtenerDatoString(array[15]);
            String dato17 = obtenerDatoString(array[16]);
            String dato18 = obtenerDatoString(array[17]);
            String dato19 = obtenerDatoString(array[18]);
            String dato20 = obtenerDatoString(array[19]);
            String dato21 = obtenerDatoString(array[20]);
            String dato22 = obtenerDatoString(array[21]);
            String dato23 = obtenerDatoString(array[22]);
            String dato24 = obtenerDatoString(array[23]);
            String dato25 = obtenerDatoString(array[24]);
            String dato26 = obtenerDatoString(array[25]);
            String dato27 = obtenerDatoString(array[26]);
            String dato28 = obtenerDatoString(array[27]);
            String dato29 = obtenerDatoString(array[28]);
            String dato30 = obtenerDatoString(array[29]);
            String dato31 = obtenerDatoString(array[30]);
            String dato32 = obtenerDatoString(array[31]);
            String dato33 = obtenerDatoString(array[32]);
            String dato34 = obtenerDatoString(array[33]);
            String dato35 = obtenerDatoString(array[34]);
            
            rhCategoriaTO.setCtaAnticipos(dato1);
            rhCategoriaTO.setCtaPrestamos(dato2);
            rhCategoriaTO.setCtaPorPagarBonos(dato3);
            rhCategoriaTO.setCtaPorPagarSueldo(dato4);
            rhCategoriaTO.setCtaPorPagarImpuestoRenta(dato5);
            rhCategoriaTO.setCtaPorPagarUtilidades(dato6);
            rhCategoriaTO.setCtaGastoBonos(dato7);
            rhCategoriaTO.setCtaGastoBonosNd(dato8);
            rhCategoriaTO.setCtaGastoBonoFijo(dato9);
            rhCategoriaTO.setCtaGastoBonoFijoNd(dato10);
            rhCategoriaTO.setCtaGastoOtrosIngresos(dato11);
            rhCategoriaTO.setCtaGastoOtrosIngresosNd(dato12);
            rhCategoriaTO.setCtaGastoSueldos(dato13);
            rhCategoriaTO.setCtaAportepersonal(dato14);
            rhCategoriaTO.setCtaAportepatronal(dato15);
            rhCategoriaTO.setCtaIece(dato16);
            rhCategoriaTO.setCtaSecap(dato17);
            rhCategoriaTO.setCtaXiii(dato18);
            rhCategoriaTO.setCtaXiv(dato19);
            rhCategoriaTO.setCtaFondoreserva(dato20);
            rhCategoriaTO.setCtaVacaciones(dato21);
            rhCategoriaTO.setCtaDesahucio(dato22);
            rhCategoriaTO.setCtaGastoAporteindividual(dato23);
            rhCategoriaTO.setCtaGastoAportepatronal(dato24);
            rhCategoriaTO.setCtaGastoIece(dato25);
            rhCategoriaTO.setCtaGastoSecap(dato26);
            rhCategoriaTO.setCtaGastoXiii(dato27);
            rhCategoriaTO.setCtaGastoXiv(dato28);
            rhCategoriaTO.setCtaGastoFondoreserva(dato29);
            rhCategoriaTO.setCtaGastoVacaciones(dato30);
            rhCategoriaTO.setCtaGastoSalarioDigno(dato31);
            rhCategoriaTO.setCtaGastoDesahucio(dato32);
            rhCategoriaTO.setCtaGastoDesahucioIntempestivo(dato33);
            rhCategoriaTO.setTipCodigo(dato34);
            rhCategoriaTO.setCtaGastoBonoLiquidacion(dato35);
        }
        return rhCategoriaTO;
    }
    
    public static List<RhComboCategoriaTO> convertirComboRhCategoria_ComboRhCategoriaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
//            String obj = (String)i$.next();
//            String[] array = (String[]) obj;
            String dato1;
            try {
                dato1 = obj.toString().trim();
                if (dato1.charAt(0) == '[') {
                    dato1 = dato1.substring(1);
                }
                if (dato1.charAt(dato1.length() - 1) == ']') {
                    dato1 = dato1.substring(0, dato1.length() - 1);
                }
            } catch (Exception e) {
                dato1 = null;
            }
            lista.add(new RhComboCategoriaTO(dato1));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="EMPLEADO">
    public static RhEmpleado convertirRhEmpleado_RhEmpleado(RhEmpleado rhEmpleadoAux) throws Exception {
        rrhh.entity.RhEmpleado rhEmpleado = new rrhh.entity.RhEmpleado();
        rhEmpleado.setCatEmpresa(rhEmpleadoAux.getCatEmpresa());
        rhEmpleado.setCatNombre(rhEmpleadoAux.getCatNombre());
        rhEmpleado.setEmpAlimentacion(rhEmpleadoAux.getEmpAlimentacion());
        rhEmpleado.setEmpApellidos(rhEmpleadoAux.getEmpApellidos());
        rhEmpleado.setEmpCargasFamiliares(rhEmpleadoAux.getEmpCargasFamiliares());
        rhEmpleado.setEmpCargo(rhEmpleadoAux.getEmpCargo());
        rhEmpleado.setEmpCodigoAfiliacionIess(rhEmpleadoAux.getEmpCodigoAfiliacionIess());
        rhEmpleado.setEmpCodigoCargo(rhEmpleadoAux.getEmpCodigoCargo());
        rhEmpleado.setEmpDiasDescanso(rhEmpleadoAux.getEmpDiasDescanso());
        rhEmpleado.setEmpDiasTrabajados(rhEmpleadoAux.getEmpDiasTrabajados());
        rhEmpleado.setEmpDomicilio(rhEmpleadoAux.getEmpDomicilio());
        rhEmpleado.setEmpCorreoElectronico(rhEmpleadoAux.getEmpCorreoElectronico());
        rhEmpleado.setEmpEducacion(rhEmpleadoAux.getEmpEducacion());
        rhEmpleado.setEmpEstadoCivil(rhEmpleadoAux.getEmpEstadoCivil());
        rhEmpleado.setEmpFechaAfiliacionIess(rhEmpleadoAux.getEmpFechaAfiliacionIess());
        rhEmpleado.setEmpFechaNacimiento(rhEmpleadoAux.getEmpFechaNacimiento());
        rhEmpleado.setEmpFechaPrimerIngreso(rhEmpleadoAux.getEmpFechaPrimerIngreso());
        rhEmpleado.setEmpFechaPrimeraSalida(rhEmpleadoAux.getEmpFechaPrimeraSalida());
        rhEmpleado.setEmpFechaUltimaSalida(rhEmpleadoAux.getEmpFechaUltimaSalida());
        rhEmpleado.setEmpFechaUltimoIngreso(rhEmpleadoAux.getEmpFechaUltimoIngreso());
        rhEmpleado.setEmpMotivoSalida(rhEmpleadoAux.getEmpMotivoSalida());
        rhEmpleado.setEmpFormaPago(rhEmpleadoAux.getEmpFormaPago());
        rhEmpleado.setEmpGenero(rhEmpleadoAux.getEmpGenero());
        rhEmpleado.setEmpInactivo(rhEmpleadoAux.getEmpInactivo());
        rhEmpleado.setEmpLugarNacimiento(rhEmpleadoAux.getEmpLugarNacimiento());
        rhEmpleado.setEmpResidenciaTipo(rhEmpleadoAux.getEmpResidenciaTipo());
        rhEmpleado.setEmpResidenciaPais(rhEmpleadoAux.getEmpResidenciaPais());
        rhEmpleado.setEmpConvenio(rhEmpleadoAux.getEmpConvenio());
        rhEmpleado.setEmpNombres(rhEmpleadoAux.getEmpNombres());
        rhEmpleado.setEmpProvincia(rhEmpleadoAux.getEmpProvincia());
        rhEmpleado.setEmpCanton(rhEmpleadoAux.getEmpCanton());
        rhEmpleado.setEmpNumero(rhEmpleadoAux.getEmpNumero());
        rhEmpleado.setEmpRetencion(rhEmpleadoAux.getEmpRetencion());
        rhEmpleado.setEmpSalud(rhEmpleadoAux.getEmpSalud());
        rhEmpleado.setEmpSueldoIess(rhEmpleadoAux.getEmpSueldoIess());
        rhEmpleado.setEmpSueldoOtraCompania(rhEmpleadoAux.getEmpSueldoOtraCompania());
        rhEmpleado.setEmpBonoFijo(rhEmpleadoAux.getEmpBonoFijo());
        rhEmpleado.setEmpBonoFijoNd(rhEmpleadoAux.getEmpBonoFijoNd());
        rhEmpleado.setEmpOtrosIngresos(rhEmpleadoAux.getEmpOtrosIngresos());
        rhEmpleado.setEmpOtrosIngresosNd(rhEmpleadoAux.getEmpOtrosIngresosNd());
        rhEmpleado.setEmpCancelarXiiiSueldoMensualmente(rhEmpleadoAux.getEmpCancelarXiiiSueldoMensualmente());
        rhEmpleado.setEmpCancelarXivSueldoMensualmente(rhEmpleadoAux.getEmpCancelarXivSueldoMensualmente());
        rhEmpleado.setEmpCancelarFondoReservaMensualmente(rhEmpleadoAux.getEmpCancelarFondoReservaMensualmente());
        rhEmpleado.setEmpRebajaDiscapacidad(rhEmpleadoAux.getEmpRebajaDiscapacidad());
        rhEmpleado.setEmpRebajaTerceraEdad(rhEmpleadoAux.getEmpRebajaTerceraEdad());
        rhEmpleado.setEmpOtrasDeducciones(rhEmpleadoAux.getEmpOtrasDeducciones());
        rhEmpleado.setEmpOtrasRebajas(rhEmpleadoAux.getEmpOtrasRebajas());
        rhEmpleado.setEmpTelefono(rhEmpleadoAux.getEmpTelefono());
        rhEmpleado.setEmpTipoId(rhEmpleadoAux.getEmpTipoId());
        rhEmpleado.setEmpUtilidades(rhEmpleadoAux.getEmpUtilidades());
        rhEmpleado.setEmpExtensionCoberturaIess(rhEmpleadoAux.getEmpExtensionCoberturaIess());
        rhEmpleado.setEmpObservaciones(rhEmpleadoAux.getEmpObservaciones());
        rhEmpleado.setEmpDiscapacidadTipo(rhEmpleadoAux.getEmpDiscapacidadTipo());
        rhEmpleado.setEmpDiscapacidadPorcentaje(rhEmpleadoAux.getEmpDiscapacidadPorcentaje());
        rhEmpleado.setEmpDiscapacidadIdTipo(rhEmpleadoAux.getEmpDiscapacidadIdTipo());
        rhEmpleado.setEmpDiscapacidadIdNumero(rhEmpleadoAux.getEmpDiscapacidadIdNumero());
        rhEmpleado.setEmpBanco(rhEmpleadoAux.getEmpBanco());
        rhEmpleado.setEmpCuentaTipo(rhEmpleadoAux.getEmpCuentaTipo());
        rhEmpleado.setEmpCuentaNumero(rhEmpleadoAux.getEmpCuentaNumero());
        rhEmpleado.setEmpVestuario(rhEmpleadoAux.getEmpVestuario());
        rhEmpleado.setEmpVivienda(rhEmpleadoAux.getEmpVivienda());
        rhEmpleado.setRhAnticipoList(rhEmpleadoAux.getRhAnticipoList());
        rhEmpleado.setRhBonoList(rhEmpleadoAux.getRhBonoList());
        rhEmpleado.setRhEmpleadoPK(rhEmpleadoAux.getRhEmpleadoPK());
        rhEmpleado.setRhPrestamoList(rhEmpleadoAux.getRhPrestamoList());
        rhEmpleado.setRhRolList(rhEmpleadoAux.getRhRolList());
        rhEmpleado.setRhViaticoList(rhEmpleadoAux.getRhViaticoList());
        rhEmpleado.setSecCodigo(rhEmpleadoAux.getSecCodigo());
        rhEmpleado.setSecEmpresa(rhEmpleadoAux.getSecEmpresa());
        rhEmpleado.setUsrCodigo(rhEmpleadoAux.getUsrCodigo());
        rhEmpleado.setUsrEmpresa(rhEmpleadoAux.getUsrEmpresa());
        rhEmpleado.setUsrFechaInserta(rhEmpleadoAux.getUsrFechaInserta());
        rhEmpleado.setEmpSalarioNeto(rhEmpleadoAux.getEmpSalarioNeto());
        return rhEmpleado;
    }
    
    public static RhEmpleado convertirRhEmpleadoTO_RhEmpleado(RhEmpleadoTO rhEmpleadoTO) throws Exception {
        RhEmpleado rhEmpleado = new RhEmpleado();
        rhEmpleado.setRhEmpleadoPK(new RhEmpleadoPK(
                rhEmpleadoTO.getEmpCodigo(),
                rhEmpleadoTO.getEmpId()));
        rhEmpleado.setCatEmpresa(rhEmpleadoTO.getEmpCodigo());
        rhEmpleado.setCatNombre(rhEmpleadoTO.getCatNombre());
        rhEmpleado.setEmpResidenciaTipo(rhEmpleadoTO.getEmpResidenciaTipo());
        rhEmpleado.setEmpResidenciaPais(rhEmpleadoTO.getEmpResidenciaPais());
        rhEmpleado.setEmpConvenio(rhEmpleadoTO.getEmpConvenio());
        rhEmpleado.setEmpTipoId(rhEmpleadoTO.getEmpTipoId());
        rhEmpleado.setEmpApellidos(rhEmpleadoTO.getEmpApellidos());
        rhEmpleado.setEmpNombres(rhEmpleadoTO.getEmpNombres());
        rhEmpleado.setEmpGenero(rhEmpleadoTO.getEmpGenero());
        rhEmpleado.setEmpLugarNacimiento(rhEmpleadoTO.getEmpLugarNacimiento());
        rhEmpleado.setEmpFechaNacimiento(Validacion.fecha(rhEmpleadoTO.getEmpFechaNacimiento(), "yyyy-MM-dd"));
        rhEmpleado.setEmpEstadoCivil(rhEmpleadoTO.getEmpEstadoCivil());
        rhEmpleado.setEmpCargasFamiliares(rhEmpleadoTO.getEmpCargasFamiliares());
        rhEmpleado.setEmpProvincia(rhEmpleadoTO.getEmpProvincia());
        rhEmpleado.setEmpCanton(rhEmpleadoTO.getEmpCanton());
        rhEmpleado.setEmpDomicilio(rhEmpleadoTO.getEmpDomicilio());
        rhEmpleado.setEmpNumero(rhEmpleadoTO.getEmpNumero());
        rhEmpleado.setEmpTelefono(rhEmpleadoTO.getEmpTelefono());
        rhEmpleado.setSecEmpresa(rhEmpleadoTO.getEmpCodigo());
        rhEmpleado.setEmpCorreoElectronico(rhEmpleadoTO.getEmpEmail());
        rhEmpleado.setSecCodigo(rhEmpleadoTO.getSecCodigo());
        rhEmpleado.setEmpFechaPrimerIngreso(Validacion.fecha(rhEmpleadoTO.getEmpFechaPrimerIngreso(), "yyyy-MM-dd"));
        rhEmpleado.setEmpFechaPrimeraSalida(Validacion.fecha(rhEmpleadoTO.getEmpFechaPrimeraSalida(), "yyyy-MM-dd"));
        rhEmpleado.setEmpMotivoSalida(rhEmpleadoTO.getEmpMotivoSalida());
        rhEmpleado.setEmpFechaUltimoIngreso(Validacion.fecha(rhEmpleadoTO.getEmpFechaUltimoIngreso(), "yyyy-MM-dd"));
        rhEmpleado.setEmpFechaUltimaSalida(Validacion.fecha(rhEmpleadoTO.getEmpFechaUltimaSalida(), "yyyy-MM-dd"));
        rhEmpleado.setEmpFechaAfiliacionIess(Validacion.fecha(rhEmpleadoTO.getEmpFechaAfiliacionIess(), "yyyy-MM-dd"));
        rhEmpleado.setEmpCodigoAfiliacionIess(rhEmpleadoTO.getEmpCodigoAfiliacionIess());
        rhEmpleado.setEmpCodigoCargo(rhEmpleadoTO.getEmpCodigoCargo());
        rhEmpleado.setEmpCargo(rhEmpleadoTO.getEmpCargo());
        rhEmpleado.setEmpSueldoIess(rhEmpleadoTO.getEmpSueldoIess());
        rhEmpleado.setEmpFormaPago(rhEmpleadoTO.getEmpFormaPago());
        rhEmpleado.setEmpDiasTrabajados(rhEmpleadoTO.getEmpDiasTrabajados());
        rhEmpleado.setEmpDiasDescanso(rhEmpleadoTO.getEmpDiasDescanso());
        rhEmpleado.setEmpBonoFijo(rhEmpleadoTO.getEmpBonoFijo());
        rhEmpleado.setEmpBonoFijoNd(rhEmpleadoTO.getEmpBonoFijoNd());
        rhEmpleado.setEmpOtrosIngresos(rhEmpleadoTO.getEmpOtrosIngresos());
        rhEmpleado.setEmpOtrosIngresosNd(rhEmpleadoTO.getEmpOtrosIngresosNd());
        rhEmpleado.setEmpCancelarXiiiSueldoMensualmente(rhEmpleadoTO.getEmpCancelarXiiiSueldoMensualmente());
        rhEmpleado.setEmpCancelarXivSueldoMensualmente(rhEmpleadoTO.getEmpCancelarXivSueldoMensualmente());
        rhEmpleado.setEmpCancelarFondoReservaMensualmente(rhEmpleadoTO.getEmpCancelarFondoReservaMensualmente());
        rhEmpleado.setEmpRebajaDiscapacidad(rhEmpleadoTO.getEmpRebajaDiscapacidad());
        rhEmpleado.setEmpRebajaTerceraEdad(rhEmpleadoTO.getEmpRebajaTerceraEdad());
        rhEmpleado.setEmpOtrasDeducciones(rhEmpleadoTO.getEmpOtrasDeducciones());
        rhEmpleado.setEmpOtrasRebajas(rhEmpleadoTO.getEmpOtrasRebajas());
        rhEmpleado.setEmpRetencion(rhEmpleadoTO.getEmpRetencion());
        rhEmpleado.setEmpEducacion(rhEmpleadoTO.getEmpEducacion());
        rhEmpleado.setEmpAlimentacion(rhEmpleadoTO.getEmpAlimentacion());
        rhEmpleado.setEmpSalud(rhEmpleadoTO.getEmpSalud());
        rhEmpleado.setEmpVivienda(rhEmpleadoTO.getEmpVivienda());
        rhEmpleado.setEmpVestuario(rhEmpleadoTO.getEmpVestuario());
        rhEmpleado.setEmpSueldoOtraCompania(rhEmpleadoTO.getEmpSueldoOtraCompania());
        rhEmpleado.setEmpUtilidades(rhEmpleadoTO.getEmpUtilidades());
        rhEmpleado.setEmpExtensionCoberturaIess(rhEmpleadoTO.getEmpExtensionCoberturaIess());
        rhEmpleado.setEmpObservaciones(rhEmpleadoTO.getEmpObservaciones());
        rhEmpleado.setEmpDiscapacidadTipo(rhEmpleadoTO.getEmpDiscapacidadTipo());
        rhEmpleado.setEmpDiscapacidadPorcentaje(rhEmpleadoTO.getEmpDiscapacidadPorcentaje());
        rhEmpleado.setEmpDiscapacidadIdTipo(rhEmpleadoTO.getEmpDiscapacidadIdTipo());
        rhEmpleado.setEmpDiscapacidadIdNumero(rhEmpleadoTO.getEmpDiscapacidadIdNumero());
        rhEmpleado.setEmpBanco(rhEmpleadoTO.getEmpBanco());
        rhEmpleado.setEmpCuentaTipo(rhEmpleadoTO.getEmpCuentaTipo());
        rhEmpleado.setEmpCuentaNumero(rhEmpleadoTO.getEmpCuentaNumero());
        rhEmpleado.setEmpInactivo(rhEmpleadoTO.getEmpInactivo());
        
        rhEmpleado.setUsrEmpresa(rhEmpleadoTO.getEmpCodigo());
        rhEmpleado.setUsrCodigo(rhEmpleadoTO.getUsrInsertaEmpleado());
        rhEmpleado.setUsrFechaInserta(Validacion.fechaString_Date(rhEmpleadoTO.getUsrFechaInsertaEmpleado()));
        rhEmpleado.setEmpSalarioNeto(rhEmpleadoTO.getEmpSalarioNeto());
        return rhEmpleado;
    }
    
    public static RhEmpleadoTO convertirRhEmpleado_RhEmpleadoTO(rrhh.entity.RhEmpleado rhEmpleado) {
        rrhh.TO.RhEmpleadoTO rhEmpleadoTO = new rrhh.TO.RhEmpleadoTO();
        rhEmpleadoTO.setEmpCodigo(rhEmpleado.getRhEmpleadoPK().getEmpEmpresa());
        rhEmpleadoTO.setEmpResidenciaTipo(rhEmpleado.getEmpResidenciaTipo());
        rhEmpleadoTO.setEmpResidenciaPais(rhEmpleado.getEmpResidenciaPais());
        rhEmpleadoTO.setEmpConvenio(rhEmpleado.getEmpConvenio());
        rhEmpleadoTO.setEmpTipoId(rhEmpleado.getEmpTipoId());
        rhEmpleadoTO.setEmpId(rhEmpleado.getRhEmpleadoPK().getEmpId());
        rhEmpleadoTO.setEmpApellidos(rhEmpleado.getEmpApellidos());
        rhEmpleadoTO.setEmpNombres(rhEmpleado.getEmpNombres());
        rhEmpleadoTO.setEmpGenero(rhEmpleado.getEmpGenero());
        rhEmpleadoTO.setEmpLugarNacimiento(rhEmpleado.getEmpLugarNacimiento());
        rhEmpleadoTO.setEmpFechaNacimiento(validaciones.Validacion.fecha(rhEmpleado.getEmpFechaNacimiento(), "yyyy-MM-dd"));
        rhEmpleadoTO.setEmpEstadoCivil(rhEmpleado.getEmpEstadoCivil());
        rhEmpleadoTO.setEmpCargasFamiliares(rhEmpleado.getEmpCargasFamiliares());
        rhEmpleadoTO.setEmpProvincia(rhEmpleado.getEmpProvincia());
        rhEmpleadoTO.setEmpCanton(rhEmpleado.getEmpCanton());
        rhEmpleadoTO.setEmpDomicilio(rhEmpleado.getEmpDomicilio());
        rhEmpleadoTO.setEmpNumero(rhEmpleado.getEmpNumero());
        rhEmpleadoTO.setEmpTelefono(rhEmpleado.getEmpTelefono());
        rhEmpleadoTO.setSecCodigo(rhEmpleado.getSecCodigo());
        rhEmpleadoTO.setEmpEmail(rhEmpleado.getEmpCorreoElectronico());
        rhEmpleadoTO.setEmpFechaPrimerIngreso(validaciones.Validacion.fecha(rhEmpleado.getEmpFechaPrimerIngreso(), "yyyy-MM-dd"));
        rhEmpleadoTO.setEmpFechaPrimeraSalida(validaciones.Validacion.fecha(rhEmpleado.getEmpFechaPrimeraSalida(), "yyyy-MM-dd"));
        rhEmpleadoTO.setEmpFechaUltimoIngreso(validaciones.Validacion.fecha(rhEmpleado.getEmpFechaUltimoIngreso(), "yyyy-MM-dd"));
        rhEmpleadoTO.setEmpFechaUltimaSalida(validaciones.Validacion.fecha(rhEmpleado.getEmpFechaUltimaSalida(), "yyyy-MM-dd"));
        rhEmpleadoTO.setEmpMotivoSalida(rhEmpleado.getEmpMotivoSalida());
        rhEmpleadoTO.setEmpFechaAfiliacionIess(validaciones.Validacion.fecha(rhEmpleado.getEmpFechaAfiliacionIess(), "yyyy-MM-dd"));
        rhEmpleadoTO.setEmpCodigoAfiliacionIess(rhEmpleado.getEmpCodigoAfiliacionIess());
        rhEmpleadoTO.setEmpCodigoCargo(rhEmpleado.getEmpCodigoCargo());
        rhEmpleadoTO.setEmpCargo(rhEmpleado.getEmpCargo());
        rhEmpleadoTO.setEmpSueldoIess(rhEmpleado.getEmpSueldoIess());
        rhEmpleadoTO.setEmpFormaPago(rhEmpleado.getEmpFormaPago());
        rhEmpleadoTO.setEmpDiasTrabajados(rhEmpleado.getEmpDiasTrabajados());
        rhEmpleadoTO.setEmpDiasDescanso(rhEmpleado.getEmpDiasDescanso());
        rhEmpleadoTO.setEmpBonoFijo(rhEmpleado.getEmpBonoFijo());
        rhEmpleadoTO.setEmpBonoFijoNd(rhEmpleado.getEmpBonoFijoNd());
        rhEmpleadoTO.setEmpOtrosIngresos(rhEmpleado.getEmpOtrosIngresos());
        rhEmpleadoTO.setEmpOtrosIngresosNd(rhEmpleado.getEmpOtrosIngresosNd());
        rhEmpleadoTO.setEmpCancelarXiiiSueldoMensualmente(rhEmpleado.getEmpCancelarXiiiSueldoMensualmente());
        rhEmpleadoTO.setEmpCancelarXivSueldoMensualmente(rhEmpleado.getEmpCancelarXivSueldoMensualmente());
        rhEmpleadoTO.setEmpCancelarFondoReservaMensualmente(rhEmpleado.getEmpCancelarFondoReservaMensualmente());
        rhEmpleadoTO.setEmpRebajaDiscapacidad(rhEmpleado.getEmpRebajaDiscapacidad());
        rhEmpleadoTO.setEmpRebajaTerceraEdad(rhEmpleado.getEmpRebajaTerceraEdad());
        rhEmpleadoTO.setEmpOtrasDeducciones(rhEmpleado.getEmpOtrasDeducciones());
        rhEmpleadoTO.setEmpOtrasRebajas(rhEmpleado.getEmpOtrasRebajas());
        rhEmpleadoTO.setEmpRetencion(rhEmpleado.getEmpRetencion());
        rhEmpleadoTO.setEmpEducacion(rhEmpleado.getEmpEducacion());
        rhEmpleadoTO.setEmpAlimentacion(rhEmpleado.getEmpAlimentacion());
        rhEmpleadoTO.setEmpSalud(rhEmpleado.getEmpSalud());
        rhEmpleadoTO.setEmpVivienda(rhEmpleado.getEmpVivienda());
        rhEmpleadoTO.setEmpVestuario(rhEmpleado.getEmpVestuario());
        rhEmpleadoTO.setEmpSueldoOtraCompania(rhEmpleado.getEmpSueldoOtraCompania());
        rhEmpleadoTO.setEmpUtilidades(rhEmpleado.getEmpUtilidades());
        rhEmpleadoTO.setEmpExtensionCoberturaIess(rhEmpleado.getEmpExtensionCoberturaIess());
        rhEmpleadoTO.setEmpObservaciones(rhEmpleado.getEmpObservaciones());
        rhEmpleadoTO.setEmpDiscapacidadTipo(rhEmpleado.getEmpDiscapacidadTipo());
        rhEmpleadoTO.setEmpDiscapacidadPorcentaje(rhEmpleado.getEmpDiscapacidadPorcentaje());
        rhEmpleadoTO.setEmpDiscapacidadIdTipo(rhEmpleado.getEmpDiscapacidadIdTipo());
        rhEmpleadoTO.setEmpDiscapacidadIdNumero(rhEmpleado.getEmpDiscapacidadIdNumero());
        rhEmpleadoTO.setEmpBanco(rhEmpleadoTO.getEmpBanco());
        rhEmpleadoTO.setEmpCuentaTipo(rhEmpleadoTO.getEmpCuentaTipo());
        rhEmpleadoTO.setEmpCuentaNumero(rhEmpleadoTO.getEmpCuentaNumero());
        rhEmpleadoTO.setEmpInactivo(rhEmpleado.getEmpInactivo());
        rhEmpleadoTO.setCatNombre(rhEmpleado.getCatNombre());
        rhEmpleadoTO.setUsrInsertaEmpleado(rhEmpleado.getUsrCodigo());
        rhEmpleadoTO.setUsrFechaInsertaEmpleado(validaciones.Validacion.fecha(rhEmpleado.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
        rhEmpleadoTO.setEmpSalarioNeto(rhEmpleado.getEmpSalarioNeto());
        return rhEmpleadoTO;
    }
    
    public static List<RhEmpleadoTO> convertirListaRhEmpleado_ListaRhEmpleadoTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String empResidenciaTipo = obtenerDatoString(array[0]);
            String dato2 = obtenerDatoString(array[1]);
            String dato3 = obtenerDatoString(array[2]);
            Character dato4 = obtenerDatoString(array[3]).charAt(0);
            String dato5 = obtenerDatoString(array[4]);
            String dato6 = obtenerDatoString(array[5]);
            String dato7 = obtenerDatoString(array[6]);
            Character dato8 = obtenerDatoString(array[7]).charAt(0);
            String dato9 = obtenerDatoString(array[8]);
            String dato10 = obtenerDatoString(array[9]);
            String dato11 = obtenerDatoString(array[10]);
            Integer dato12 = Integer.valueOf(obtenerDatoString(array[11]));
            String dato13 = obtenerDatoString(array[12]);
            String dato14 = obtenerDatoString(array[13]);
            String dato15 = obtenerDatoString(array[14]);
            String dato16 = obtenerDatoString(array[15]);
            String dato17 = obtenerDatoString(array[16]);
            String dato18 = obtenerDatoString(array[17]);
            String dato19 = obtenerDatoString(array[18]);
            String dato20 = obtenerDatoString(array[19]);
            String dato21 = obtenerDatoString(array[20]);
            String dato22 = obtenerDatoString(array[21]);
            String dato23 = obtenerDatoString(array[22]);
            String dato24 = obtenerDatoString(array[23]);
            String dato25 = obtenerDatoString(array[24]);
            String dato26 = obtenerDatoString(array[25]);
            String dato27 = obtenerDatoString(array[26]);
            BigDecimal dato28 = new BigDecimal(obtenerDatoString(array[27]));
            String dato29 = obtenerDatoString(array[28]);
            Integer dato30 = Integer.valueOf(obtenerDatoString(array[29]));
            Integer dato31 = Integer.valueOf(obtenerDatoString(array[30]));
            BigDecimal dato32 = new BigDecimal(obtenerDatoString(array[31]));
            BigDecimal dato33 = new BigDecimal(obtenerDatoString(array[32]));
            Boolean dato34 = Boolean.valueOf(obtenerDatoString(array[33]));
            Boolean dato35 = Boolean.valueOf(obtenerDatoString(array[34]));
            Boolean dato36 = Boolean.valueOf(obtenerDatoString(array[35]));
            Boolean dato37 = Boolean.valueOf(obtenerDatoString(array[36]));
            BigDecimal dato38 = new BigDecimal(obtenerDatoString(array[37]));
            BigDecimal dato39 = new BigDecimal(obtenerDatoString(array[38]));
            BigDecimal dato40 = new BigDecimal(obtenerDatoString(array[39]));
            BigDecimal dato41 = new BigDecimal(obtenerDatoString(array[40]));
            BigDecimal dato42 = new BigDecimal(obtenerDatoString(array[41]));
            BigDecimal dato43 = new BigDecimal(obtenerDatoString(array[42]));
            BigDecimal dato44 = new BigDecimal(obtenerDatoString(array[43]));
            BigDecimal dato45 = new BigDecimal(obtenerDatoString(array[44]));
            BigDecimal dato46 = new BigDecimal(obtenerDatoString(array[45]));
            BigDecimal dato47 = new BigDecimal(obtenerDatoString(array[46]));
            BigDecimal dato48 = new BigDecimal(obtenerDatoString(array[47]));
            BigDecimal dato49 = new BigDecimal(obtenerDatoString(array[48]));
            BigDecimal dato50 = new BigDecimal(obtenerDatoString(array[49]));
            Boolean dato51 = Boolean.valueOf(obtenerDatoString(array[50]));
            String dato52 = obtenerDatoString(array[51]);
            String dato53 = obtenerDatoString(array[52]);
            Short dato54 = Short.valueOf(obtenerDatoString(array[53]));
            Character dato55 = obtenerDatoString(array[54]).charAt(0);
            String dato56 = obtenerDatoString(array[55]);
            String empBanco = obtenerDatoString(array[56]);
            String empCuentaTipo = obtenerDatoString(array[57]);
            String empCuentaNumero = obtenerDatoString(array[58]);
            Boolean empInactivo = Boolean.valueOf(obtenerDatoString(array[59]));
            String catNombre = obtenerDatoString(array[60]);
            Boolean empSalarioNeto = Boolean.valueOf(obtenerDatoString(array[61]));
            String empEmail = obtenerDatoString(array[62]);
            
            lista.add(new RhEmpleadoTO(null, empResidenciaTipo, dato2, dato3, dato4, dato5,
                    dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13,
                    dato14, dato15, dato16, dato17, empEmail, dato18, dato19, dato20,
                    dato21, dato22, dato23, dato24, dato25, dato26, dato27,
                    dato28, dato29, dato30, dato31, dato32, dato33, dato34,
                    dato35, dato36, dato37, dato38, dato39, empSalarioNeto, dato40, dato41,
                    dato42, dato43, dato44, dato45, dato46, dato47, dato48,
                    dato49, dato50, dato51, dato52, dato53, dato54, dato55,
                    dato56, empBanco, empCuentaTipo, empCuentaNumero, empInactivo, catNombre, null, null));
        }
        return lista;
    }
    
    public static List<RhListaEmpleadoTO> convertirListaConsultaRhEmpleado_ListaConsultaRhEmpleadoTO(List datos) {
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
            lista.add(new RhListaEmpleadoTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }
    
    public static List<RhListaEmpleadoLoteTO> convertirListaConsultaRhEmpleadoLote_ListaConsultaRhEmpleadoLoteTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String prCategoria;
            try {
                prCategoria = array[0].toString();
            } catch (Exception e) {
                prCategoria = null;
            }
            String prSector;
            try {
                prSector = array[1].toString();
            } catch (Exception e) {
                prSector = null;
            }
            String prId;
            try {
                prId = array[2].toString();
            } catch (Exception e) {
                prId = null;
            }
            String prNombres;
            try {
                prNombres = array[3].toString();
            } catch (Exception e) {
                prNombres = null;
            }
            String prCargo;
            try {
                prCargo = array[4].toString();
            } catch (Exception e) {
                prCargo = null;
            }
            BigDecimal prSueldo;
            try {
                prSueldo = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                prSueldo = null;
            }
            BigDecimal prValor;
            try {
                prValor = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                prValor = null;
            }
            Boolean prAfiliado;
            try {
                prAfiliado = Boolean.parseBoolean(array[7].toString());
            } catch (Exception e) {
                prAfiliado = null;
            }
            lista.add(new RhListaEmpleadoLoteTO(prCategoria, prSector, prId, prNombres, prCargo, prSueldo, prValor, prAfiliado));
        }
        return lista;
    }
    
    public static List<RhFunPlantillaSueldosLoteTO> convertirRhFunPlantillaSueldosLote_RhFunPlantillaSueldosLoteTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String prCategoria;
            try {
                prCategoria = array[0].toString();
            } catch (Exception e) {
                prCategoria = null;
            }
            String prId;
            try {
                prId = array[1].toString();
            } catch (Exception e) {
                prId = null;
            }
            String prNombres;
            try {
                prNombres = array[2].toString();
            } catch (Exception e) {
                prNombres = null;
            }
            String prCargo;
            try {
                prCargo = array[3].toString();
            } catch (Exception e) {
                prCargo = null;
            }
            String prSector;
            try {
                prSector = array[4].toString();
            } catch (Exception e) {
                prSector = null;
            }
            String prDesde;
            try {
                prDesde = array[5].toString();
            } catch (Exception e) {
                prDesde = null;
            }
            String prHasta;
            try {
                prHasta = array[6].toString();
            } catch (Exception e) {
                prHasta = null;
            }
            String rolFechaUltimoSueldo;
            try {
                rolFechaUltimoSueldo = array[7].toString();
            } catch (Exception e) {
                rolFechaUltimoSueldo = null;
            }
            Integer rolDiasLaboradosReales;
            try {
                rolDiasLaboradosReales = Integer.valueOf(array[8].toString());
            } catch (Exception e) {
                rolDiasLaboradosReales = null;
            }
            Integer rolDiasFaltasReales;
            try {
                rolDiasFaltasReales = Integer.valueOf(array[9].toString());
            } catch (Exception e) {
                rolDiasFaltasReales = null;
            }
            Integer rolDiasExtrasReales;
            try {
                rolDiasExtrasReales = Integer.valueOf(array[10].toString());
            } catch (Exception e) {
                rolDiasExtrasReales = null;
            }
            Integer rolDiasDescansoReales;
            try {
                rolDiasDescansoReales = Integer.valueOf(array[11].toString());
            } catch (Exception e) {
                rolDiasDescansoReales = null;
            }
            Integer rolDiasPagadosReales;
            try {
                rolDiasPagadosReales = Integer.valueOf(array[12].toString());
            } catch (Exception e) {
                rolDiasPagadosReales = null;
            }
            Integer rolDiasPermisoMedico;
            try {
                rolDiasPermisoMedico = Integer.valueOf(array[13].toString());
            } catch (Exception e) {
                rolDiasPermisoMedico = null;
            }
            BigDecimal rolSaldoAnterior;
            try {
                rolSaldoAnterior = new BigDecimal(array[14].toString());
            } catch (Exception e) {
                rolSaldoAnterior = null;
            }
            BigDecimal rolIngresos;
            try {
                rolIngresos = new BigDecimal(array[15].toString());
            } catch (Exception e) {
                rolIngresos = null;
            }
            BigDecimal rolBonos;
            try {
                rolBonos = new BigDecimal(array[16].toString());
            } catch (Exception e) {
                rolBonos = null;
            }
            BigDecimal rolBonosnd;
            try {
                rolBonosnd = new BigDecimal(array[17].toString());
            } catch (Exception e) {
                rolBonosnd = null;
            }
            BigDecimal rolBonoFijo;
            try {
                rolBonoFijo = new BigDecimal(array[18].toString());
            } catch (Exception e) {
                rolBonoFijo = null;
            }
            BigDecimal rolBonoFijoNd;
            try {
                rolBonoFijoNd = new BigDecimal(array[19].toString());
            } catch (Exception e) {
                rolBonoFijoNd = null;
            }
            BigDecimal rolOtrosIngresos;
            try {
                rolOtrosIngresos = new BigDecimal(array[20].toString());
            } catch (Exception e) {
                rolOtrosIngresos = null;
            }
            BigDecimal rolOtrosIngresosNd;
            try {
                rolOtrosIngresosNd = new BigDecimal(array[21].toString());
            } catch (Exception e) {
                rolOtrosIngresosNd = null;
            }
            BigDecimal rolViaticos;
            try {
                rolViaticos = new BigDecimal(array[22].toString());
            } catch (Exception e) {
                rolViaticos = null;
            }
            BigDecimal rolLiqFondoReserva;
            try {
                rolLiqFondoReserva = new BigDecimal(array[23].toString());
            } catch (Exception e) {
                rolLiqFondoReserva = null;
            }
            BigDecimal rolLiqXiii;
            try {
                rolLiqXiii = new BigDecimal(array[24].toString());
            } catch (Exception e) {
                rolLiqXiii = null;
            }
            BigDecimal rolLiqXiv;
            try {
                rolLiqXiv = new BigDecimal(array[25].toString());
            } catch (Exception e) {
                rolLiqXiv = null;
            }
            BigDecimal rolLiqVacaciones;
            try {
                rolLiqVacaciones = new BigDecimal(array[26].toString());
            } catch (Exception e) {
                rolLiqVacaciones = null;
            }
            BigDecimal rolLiqSalarioDigno;
            try {
                rolLiqSalarioDigno = new BigDecimal(array[27].toString());
            } catch (Exception e) {
                rolLiqSalarioDigno = null;
            }
            BigDecimal rolLiqDesahucio;
            try {
                rolLiqDesahucio = new BigDecimal(array[28].toString());
            } catch (Exception e) {
                rolLiqDesahucio = null;
            }
            BigDecimal rolLiqDesahucioIntempestivo;
            try {
                rolLiqDesahucioIntempestivo = new BigDecimal(array[29].toString());
            } catch (Exception e) {
                rolLiqDesahucioIntempestivo = null;
            }
            BigDecimal rolAnticipos;
            try {
                rolAnticipos = new BigDecimal(array[30].toString());
            } catch (Exception e) {
                rolAnticipos = null;
            }
            BigDecimal rolPrestamos;
            try {
                rolPrestamos = new BigDecimal(array[31].toString());
            } catch (Exception e) {
                rolPrestamos = null;
            }
            BigDecimal rolIess;
            try {
                rolIess = new BigDecimal(array[32].toString());
            } catch (Exception e) {
                rolIess = null;
            }
            BigDecimal rolRetencionFuente;
            try {
                rolRetencionFuente = new BigDecimal(array[33].toString());
            } catch (Exception e) {
                rolRetencionFuente = null;
            }
            BigDecimal rolDescuentoPermisoMedico;
            try {
                rolDescuentoPermisoMedico = new BigDecimal(array[34].toString());
            } catch (Exception e) {
                rolDescuentoPermisoMedico = null;
            }
            BigDecimal rolTotal;
            try {
                rolTotal = new BigDecimal(array[35].toString());
            } catch (Exception e) {
                rolTotal = null;
            }
            BigDecimal rolAportePatronal;
            try {
                rolAportePatronal = new BigDecimal(array[36].toString());
            } catch (Exception e) {
                rolAportePatronal = null;
            }
            BigDecimal rolIece;
            try {
                rolIece = new BigDecimal(array[37].toString());
            } catch (Exception e) {
                rolIece = null;
            }
            BigDecimal rolSecap;
            try {
                rolSecap = new BigDecimal(array[38].toString());
            } catch (Exception e) {
                rolSecap = null;
            }
            BigDecimal rolXiii;
            try {
                rolXiii = new BigDecimal(array[39].toString());
            } catch (Exception e) {
                rolXiii = null;
            }
            BigDecimal rolXiv;
            try {
                rolXiv = new BigDecimal(array[40].toString());
            } catch (Exception e) {
                rolXiv = null;
            }
            BigDecimal rolFondoReserva;
            try {
                rolFondoReserva = new BigDecimal(array[41].toString());
            } catch (Exception e) {
                rolFondoReserva = null;
            }
            BigDecimal rolVacaciones;
            try {
                rolVacaciones = new BigDecimal(array[42].toString());
            } catch (Exception e) {
                rolVacaciones = null;
            }
            BigDecimal rolDesahucio;
            try {
                rolDesahucio = new BigDecimal(array[43].toString());
            } catch (Exception e) {
                rolDesahucio = null;
            }
            Boolean rolReversado;
            try {
                rolReversado = Boolean.parseBoolean(array[44].toString());
            } catch (Exception e) {
                rolReversado = null;
            }
            BigDecimal empSueldo;
            try {
                empSueldo = new BigDecimal(array[45].toString());
            } catch (Exception e) {
                empSueldo = null;
            }
            BigDecimal empBonoFijo;
            try {
                empBonoFijo = new BigDecimal(array[46].toString());
            } catch (Exception e) {
                empBonoFijo = null;
            }
            BigDecimal empBonoFijoNd;
            try {
                empBonoFijoNd = new BigDecimal(array[47].toString());
            } catch (Exception e) {
                empBonoFijoNd = null;
            }
            BigDecimal empOtrosIngresos;
            try {
                empOtrosIngresos = new BigDecimal(array[48].toString());
            } catch (Exception e) {
                empOtrosIngresos = null;
            }
            BigDecimal empOtrosIngresosNd;
            try {
                empOtrosIngresosNd = new BigDecimal(array[49].toString());
            } catch (Exception e) {
                empOtrosIngresosNd = null;
            }
            Integer empDiasLaborados;
            try {
                empDiasLaborados = Integer.valueOf(array[50].toString());
            } catch (Exception e) {
                empDiasLaborados = null;
            }
            Integer empDiasDescanso;
            try {
                empDiasDescanso = Integer.valueOf(array[51].toString());
            } catch (Exception e) {
                empDiasDescanso = null;
            }
            Boolean empCancelarXiiiSueldoMensualmente;
            try {
                empCancelarXiiiSueldoMensualmente = Boolean.parseBoolean(array[52].toString());
            } catch (Exception e) {
                empCancelarXiiiSueldoMensualmente = null;
            }
            Boolean empCancelarXivSueldoMensualmente;
            try {
                empCancelarXivSueldoMensualmente = Boolean.parseBoolean(array[53].toString());
            } catch (Exception e) {
                empCancelarXivSueldoMensualmente = null;
            }
            Boolean empCancelarFondoReservaMensualmente;
            try {
                empCancelarFondoReservaMensualmente = Boolean.parseBoolean(array[54].toString());
            } catch (Exception e) {
                empCancelarFondoReservaMensualmente = null;
            }
            String rolFormaPago;
            try {
                rolFormaPago = array[55].toString();
            } catch (Exception e) {
                rolFormaPago = null;
            }
            lista.add(new RhFunPlantillaSueldosLoteTO(
                    prCategoria,
                    prId,
                    prNombres,
                    prCargo,
                    prSector,
                    prDesde,
                    prHasta,
                    rolFechaUltimoSueldo,
                    rolDiasLaboradosReales,
                    rolDiasFaltasReales,
                    rolDiasExtrasReales,
                    rolDiasDescansoReales,
                    rolDiasPagadosReales,
                    rolDiasPermisoMedico,
                    rolSaldoAnterior,
                    rolIngresos,
                    rolBonos,
                    rolBonosnd,
                    rolBonoFijo,
                    rolBonoFijoNd,
                    rolOtrosIngresos,
                    rolOtrosIngresosNd,
                    rolViaticos,
                    rolLiqFondoReserva,
                    rolLiqXiii,
                    rolLiqXiv,
                    rolLiqVacaciones,
                    rolLiqSalarioDigno,
                    rolLiqDesahucio,
                    rolLiqDesahucioIntempestivo,
                    rolAnticipos,
                    rolPrestamos,
                    rolIess,
                    rolRetencionFuente,
                    rolDescuentoPermisoMedico,
                    rolTotal,
                    rolAportePatronal,
                    rolIece,
                    rolSecap,
                    rolXiii,
                    rolXiv,
                    rolFondoReserva,
                    rolVacaciones,
                    rolDesahucio,
                    rolReversado,
                    empSueldo,
                    empBonoFijo,
                    empBonoFijoNd,
                    empOtrosIngresos,
                    empOtrosIngresosNd,
                    empDiasLaborados,
                    empDiasDescanso,
                    empCancelarXiiiSueldoMensualmente,
                    empCancelarXivSueldoMensualmente,
                    empCancelarFondoReservaMensualmente,
                    rolFormaPago,
                    null));
        }
        return lista;
    }
    
    public static List<RhFunPlantillaSueldosLotePreliminarTO> convertirRhFunPlantillaSueldosLotePreliminar_RhFunPlantillaSueldosLotePreliminarTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            



            
            String prCategoria;
            try {
                prCategoria = array[0].toString();
            } catch (Exception e) {
                prCategoria = null;
            }
            String prId;
            try {
                prId = array[1].toString();
            } catch (Exception e) {
                prId = null;
            }
            String prNombres;
            try {
                prNombres = array[2].toString();
            } catch (Exception e) {
                prNombres = null;
            }
            String prCargo;
            try {
                prCargo = array[3].toString();
            } catch (Exception e) {
                prCargo = null;
            }
            String prSector;
            try {
                prSector = array[4].toString();
            } catch (Exception e) {
                prSector = null;
            }
            String prDesde;
            try {
                prDesde = array[5].toString();
            } catch (Exception e) {
                prDesde = null;
            }
            String prHasta;
            try {
                prHasta = array[6].toString();
            } catch (Exception e) {
                prHasta = null;
            }
             
            String prFechaUltimoSueldo;
            try {
                prFechaUltimoSueldo = array[7].toString();
            } catch (Exception e) {
                prFechaUltimoSueldo = null;
            }
            Integer prDiasLaboradosReales;
            try {
                prDiasLaboradosReales = Integer.valueOf(array[8].toString());
            } catch (Exception e) {
                prDiasLaboradosReales = null;
            }
            Integer prDiasFaltasReales;
            try {
                prDiasFaltasReales = Integer.valueOf(array[9].toString());
            } catch (Exception e) {
                prDiasFaltasReales = null;
            }
            Integer prDiasExtrasReales;
            try {
                prDiasExtrasReales = Integer.valueOf(array[10].toString());
            } catch (Exception e) {
                prDiasExtrasReales = null;
            }
            Integer prDiasDescansoReales;
            try {
                prDiasDescansoReales = Integer.valueOf(array[11].toString());
            } catch (Exception e) {
                prDiasDescansoReales = null;
            }
            Integer prDiasPagadosReales;
            try {
                prDiasPagadosReales = Integer.valueOf(array[12].toString());
            } catch (Exception e) {
                prDiasPagadosReales = null;
            }
            Integer prDiasPermisoMedico;
            try {
                prDiasPermisoMedico = Integer.valueOf(array[13].toString());
            } catch (Exception e) {
                prDiasPermisoMedico = null;
            }
                     
            
            
            BigDecimal rolSaldoAnterior;
            try {
                rolSaldoAnterior = new BigDecimal(array[14].toString());
            } catch (Exception e) {
                rolSaldoAnterior = null;
            }
            BigDecimal rolIngresos;
            try {
                rolIngresos = new BigDecimal(array[15].toString());
            } catch (Exception e) {
                rolIngresos = null;
            }
            BigDecimal rolBonos;
            try {
                rolBonos = new BigDecimal(array[16].toString());
            } catch (Exception e) {
                rolBonos = null;
            }
            BigDecimal rolBonosnd;
            try {
                rolBonosnd = new BigDecimal(array[17].toString());
            } catch (Exception e) {
                rolBonosnd = null;
            }
            BigDecimal rolBonoFijo;
            try {
                rolBonoFijo = new BigDecimal(array[18].toString());
            } catch (Exception e) {
                rolBonoFijo = null;
            }
            
            
            BigDecimal rolBonoFijoNd;
            try {
                rolBonoFijoNd = new BigDecimal(array[19].toString());
            } catch (Exception e) {
                rolBonoFijoNd = null;
            }
            BigDecimal rolOtrosIngresos;
            try {
                rolOtrosIngresos = new BigDecimal(array[20].toString());
            } catch (Exception e) {
                rolOtrosIngresos = null;
            }
            BigDecimal rolOtrosIngresosNd;
            try {
                rolOtrosIngresosNd = new BigDecimal(array[21].toString());
            } catch (Exception e) {
                rolOtrosIngresosNd = null;
            }
            BigDecimal rolAnticipos;
            try {
                rolAnticipos = new BigDecimal(array[22].toString());
            } catch (Exception e) {
                rolAnticipos = null;
            }
            BigDecimal rolPrestamos;
            try {
                rolPrestamos = new BigDecimal(array[23].toString());
            } catch (Exception e) {
                rolPrestamos = null;
            }
            BigDecimal rolIess;
            try {
                rolIess = new BigDecimal(array[24].toString());
            } catch (Exception e) {
                rolIess = null;
            }
           
            BigDecimal rolRetencionFuente;
            try {
                rolRetencionFuente = new BigDecimal(array[25].toString());
            } catch (Exception e) {
                rolRetencionFuente = null;
            }
            BigDecimal rolDescuentoPermisoMedico;
            try {
                rolDescuentoPermisoMedico = new BigDecimal(array[26].toString());
            } catch (Exception e) {
                rolDescuentoPermisoMedico = null;
            }
            BigDecimal rolTotal;
            try {
                rolTotal = new BigDecimal(array[27].toString());
            } catch (Exception e) {
                rolTotal = null;
            }

            BigDecimal rolAportePAtronal;
            try {
                rolAportePAtronal = new BigDecimal(array[28].toString());
            } catch (Exception e) {
                rolAportePAtronal = null;
            }
            BigDecimal rolIece;
            try {
                rolIece = new BigDecimal(array[29].toString());
            } catch (Exception e) {
                rolIece = null;
            }
            BigDecimal rolSecap;
            try {
                rolSecap = new BigDecimal(array[30].toString());
            } catch (Exception e) {
                rolSecap = null;
            }
            BigDecimal rolXiii;
            try {
                rolXiii = new BigDecimal(array[31].toString());
            } catch (Exception e) {
                rolXiii = null;
            }
            

            
            BigDecimal rolXiv;
            try {
                rolXiv = new BigDecimal(array[32].toString());
            } catch (Exception e) {
                rolXiv = null;
            }
            BigDecimal rolFondoReserva;
            try {
                rolFondoReserva = new BigDecimal(array[33].toString());
            } catch (Exception e) {
                rolFondoReserva = null;
            }
            BigDecimal rolVacaciones;
            try {
                rolVacaciones = new BigDecimal(array[34].toString());
            } catch (Exception e) {
                rolVacaciones = null;
            }
            BigDecimal rolDesahucio;
            try {
                rolDesahucio = new BigDecimal(array[35].toString());
            } catch (Exception e) {
                rolDesahucio = null;
            }

            Boolean prReversado;
            try {
                prReversado = Boolean.parseBoolean(array[36].toString());
            } catch (Exception e) {
                prReversado = null;
            }
            BigDecimal empSueldo;
            try {
                empSueldo = new BigDecimal(array[37].toString());
            } catch (Exception e) {
                empSueldo = null;
            }
            BigDecimal empBonoFijo;
            try {
                empBonoFijo = new BigDecimal(array[38].toString());
            } catch (Exception e) {
                empBonoFijo = null;
            }
            BigDecimal empBonoFijoNd;
            try {
                empBonoFijoNd = new BigDecimal(array[39].toString());
            } catch (Exception e) {
                empBonoFijoNd = null;
            }
            BigDecimal empOtrosIngresos;
            try {
                empOtrosIngresos = new BigDecimal(array[40].toString());
            } catch (Exception e) {
                empOtrosIngresos = null;
            }
            BigDecimal empOtrosingresosNd;
            try {
                empOtrosingresosNd = new BigDecimal(array[41].toString());
            } catch (Exception e) {
                empOtrosingresosNd = null;
            }
            Integer empDiasLaborados;
            try {
                empDiasLaborados = Integer.valueOf(array[42].toString());
            } catch (Exception e) {
                empDiasLaborados = null;
            }

            Integer empDiasDescanso;
            try {
                empDiasDescanso = Integer.valueOf(array[43].toString());
            } catch (Exception e) {
                empDiasDescanso = null;
            }
                   
            Boolean empCancelarXiiiSueldoMensualmente;
            try {
                empCancelarXiiiSueldoMensualmente = Boolean.parseBoolean(array[44].toString());
            } catch (Exception e) {
                empCancelarXiiiSueldoMensualmente = null;
            }
            Boolean empCancelarXivSueldoMensualmente;
            try {
                empCancelarXivSueldoMensualmente = Boolean.parseBoolean(array[45].toString());
            } catch (Exception e) {
                empCancelarXivSueldoMensualmente = null;
            }
            Boolean empCancelarFondoReservaMensualmente;
            try {
                empCancelarFondoReservaMensualmente = Boolean.parseBoolean(array[46].toString());
            } catch (Exception e) {
                empCancelarFondoReservaMensualmente = null;
            }
            String rolFormaPago;
            try {
                rolFormaPago = array[55].toString();
            } catch (Exception e) {
                rolFormaPago = null;
            }
            lista.add(new  RhFunPlantillaSueldosLotePreliminarTO(
                    prCategoria, 
                    prId, 
                    prNombres, 
                    prCargo, 
                    prSector, 
                    prDesde, 
                    prHasta, 
                    prFechaUltimoSueldo, 
                    prDiasLaboradosReales, 
                    prDiasFaltasReales, 
                    prDiasExtrasReales, 
                    prDiasDescansoReales, 
                    prDiasPagadosReales, 
                    prDiasPermisoMedico, 
                    rolSaldoAnterior, 
                    rolIngresos, 
                    rolBonos, 
                    rolBonosnd, 
                    rolBonoFijo, 
                    rolBonoFijoNd, 
                    rolOtrosIngresos, 
                    rolOtrosIngresosNd, 
                    rolAnticipos, 
                    rolPrestamos, 
                    rolIess, 
                    rolRetencionFuente, 
                    rolDescuentoPermisoMedico, 
                    rolTotal, 
                    rolAportePAtronal, 
                    rolIece, 
                    rolSecap, 
                    rolXiii, 
                    rolXiv, 
                    rolFondoReserva, 
                    rolVacaciones, 
                    rolDesahucio, 
                    prReversado, 
                    empSueldo, 
                    empBonoFijo, 
                    empBonoFijoNd, 
                    empOtrosIngresos, 
                    empOtrosingresosNd, 
                    empDiasLaborados, 
                    empDiasDescanso, 
                    empCancelarXiiiSueldoMensualmente, 
                    empCancelarXivSueldoMensualmente, 
                    empCancelarFondoReservaMensualmente, 
                    rolFormaPago));
            
           
        }
        return lista;
    }
    
    public static List<RhFunPlantillaRolesTO> convertirRhFunPlantillaRoles_RhFunPlantillaRolesTO(List datos) {
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
                dato7 = Boolean.parseBoolean(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            Boolean dato8;
            try {
                dato8 = Boolean.parseBoolean(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            Boolean dato9;
            try {
                dato9 = Boolean.parseBoolean(array[8].toString());
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
            BigDecimal dato15;
            try {
                dato15 = new BigDecimal(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }
            BigDecimal dato16;
            try {
                dato16 = new BigDecimal(array[15].toString());
            } catch (Exception e) {
                dato16 = null;
            }
            BigDecimal dato17;
            try {
                dato17 = new BigDecimal(array[16].toString());
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
            lista.add(new RhFunPlantillaRolesTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12,
                    dato13, dato14, dato15, dato16, dato17, dato18, dato19,
                    dato20));
        }
        return lista;
    }
    
    public static RhEmpleadoRolTO convertirRhEmpleado_RhEmpleadoRolTO(List datos) {
//        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        RhEmpleadoRolTO rhEmpleadoRolTO = new RhEmpleadoRolTO();
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
            BigDecimal dato3;
            try {
                dato3 = new BigDecimal(array[2].toString());
            } catch (Exception e) {
//                dato3 = null;
                dato3 = BigDecimal.ZERO;
            }
            Boolean dato4;
            try {
                dato4 = Boolean.valueOf(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            BigDecimal dato5;
            try {
                dato5 = new BigDecimal(array[4].toString());
            } catch (Exception e) {
//                dato5 = null;
                dato5 = BigDecimal.ZERO;
            }
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
            } catch (Exception e) {
//                dato6 = null;
                dato6 = BigDecimal.ZERO;
            }
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
//                dato7 = null;
                dato7 = BigDecimal.ZERO;
            }
            BigDecimal dato8;
            try {
                dato8 = new BigDecimal(array[7].toString());
            } catch (Exception e) {
//                dato8 = null;
                dato8 = BigDecimal.ZERO;
            }
            BigDecimal dato9;
            try {
                dato9 = new BigDecimal(array[8].toString());
            } catch (Exception e) {
//                dato9 = null;
                dato9 = BigDecimal.ZERO;
            }
            BigDecimal dato10;
            try {
                dato10 = new BigDecimal(array[9].toString());
            } catch (Exception e) {
//                dato10 = null;
                dato10 = BigDecimal.ZERO;
            }
            BigDecimal dato11;
            try {
                dato11 = new BigDecimal(array[10].toString());
            } catch (Exception e) {
//                dato11 = null;
                dato11 = BigDecimal.ZERO;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
//                dato11 = null;
                dato12 = null;
            }
            
            rhEmpleadoRolTO.setEmpDiasTrabajados(dato1);
            rhEmpleadoRolTO.setEmpDiasDescanso(dato2);
            rhEmpleadoRolTO.setEmpSueldoIess(dato3);
            rhEmpleadoRolTO.setEmpRetencion(dato4);
            rhEmpleadoRolTO.setEmpUtilidades(dato5);
            rhEmpleadoRolTO.setEmpSueldoOtraCompania(dato6);
            rhEmpleadoRolTO.setEmpEducacion(dato7);
            rhEmpleadoRolTO.setEmpAlimentacion(dato8);
            rhEmpleadoRolTO.setEmpSalud(dato9);
            rhEmpleadoRolTO.setEmpVivienda(dato10);
            rhEmpleadoRolTO.setEmpVestuario(dato11);
            rhEmpleadoRolTO.setCatNombre(dato12);
        }
        return rhEmpleadoRolTO;
    }
    
    public static java.util.List<rrhh.TO.RhFunListadoEmpleadosTO> convertirRhFunListadoEmpleados_RhFunListadoEmpleadosTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
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
            Character dato6;
            try {
                dato6 = array[5].toString().charAt(0);
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
            Integer dato9;
            try {
                dato9 = new Integer(array[8].toString());
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
            String dato25;
            try {
                dato25 = array[24].toString();
            } catch (Exception e) {
                dato25 = null;
            }
            java.math.BigDecimal dato26;
            try {
                dato26 = new java.math.BigDecimal(array[25].toString());
            } catch (Exception e) {
                dato26 = null;
            }
            String dato27;
            try {
                dato27 = array[26].toString();
            } catch (Exception e) {
                dato27 = null;
            }
            Integer dato28;
            try {
                dato28 = new Integer(array[27].toString());
            } catch (Exception e) {
                dato28 = null;
            }
            Integer dato29;
            try {
                dato29 = new Integer(array[28].toString());
            } catch (Exception e) {
                dato29 = null;
            }
            java.math.BigDecimal dato30;
            try {
                dato30 = new java.math.BigDecimal(array[29].toString());
            } catch (Exception e) {
                dato30 = null;
            }
            Boolean dato31;
            try {
                dato31 = Boolean.valueOf(array[30].toString());
            } catch (Exception e) {
                dato31 = null;
            }
            Boolean dato32;
            try {
                dato32 = Boolean.valueOf(array[31].toString());
            } catch (Exception e) {
                dato32 = null;
            }
            java.math.BigDecimal dato33;
            try {
                dato33 = new java.math.BigDecimal(array[32].toString());
            } catch (Exception e) {
                dato33 = null;
            }
            java.math.BigDecimal dato34;
            try {
                dato34 = new java.math.BigDecimal(array[33].toString());
            } catch (Exception e) {
                dato34 = null;
            }
            java.math.BigDecimal dato35;
            try {
                dato35 = new java.math.BigDecimal(array[34].toString());
            } catch (Exception e) {
                dato35 = null;
            }
            java.math.BigDecimal dato36;
            try {
                dato36 = new java.math.BigDecimal(array[35].toString());
            } catch (Exception e) {
                dato36 = null;
            }
            java.math.BigDecimal dato37;
            try {
                dato37 = new java.math.BigDecimal(array[36].toString());
            } catch (Exception e) {
                dato37 = null;
            }
            java.math.BigDecimal dato38;
            try {
                dato38 = new java.math.BigDecimal(array[37].toString());
            } catch (Exception e) {
                dato38 = null;
            }
            java.math.BigDecimal dato39;
            try {
                dato39 = new java.math.BigDecimal(array[38].toString());
            } catch (Exception e) {
                dato39 = null;
            }
            String dato40;
            try {
                dato40 = array[39].toString();
            } catch (Exception e) {
                dato40 = null;
            }
            String dato41;
            try {
                dato41 = array[40].toString();
            } catch (Exception e) {
                dato41 = null;
            }
            String dato42;
            try {
                dato42 = array[41].toString();
            } catch (Exception e) {
                dato42 = null;
            }
            Boolean dato43;
            try {
                dato43 = Boolean.valueOf(array[42].toString());
            } catch (Exception e) {
                dato43 = null;
            }
            lista.add(new rrhh.TO.RhFunListadoEmpleadosTO(dato1, dato2, dato3,
                    dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11,
                    dato12, dato13, dato14, dato15, dato16, dato17, dato18,
                    dato19, dato20, dato21, dato22, dato23, dato24, dato25,
                    dato26, dato27, dato28, dato29, dato30, dato31, dato32,
                    dato33, dato34, dato35, dato36, dato37, dato38, dato39,
                    dato40, dato41, dato42, dato43));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMA PAGO">
    public static RhFormaPago convertirRhFormaPagoTO_RhFormaPago(RhFormaPagoTO rhFormaPagoTO) throws Exception {
        rrhh.entity.RhFormaPago rhFormaPago = new rrhh.entity.RhFormaPago();
        rhFormaPago.setFpSecuencial(rhFormaPagoTO.getFpSecuencial());
        rhFormaPago.setFpDetalle(rhFormaPagoTO.getFpDetalle());
        rhFormaPago.setFpInactivo(rhFormaPagoTO.getFpInactivo());
        rhFormaPago.setSecEmpresa(rhFormaPagoTO.getUsrEmpresa());
        rhFormaPago.setSecCodigo(rhFormaPagoTO.getSecCodigo());
        rhFormaPago.setCtaEmpresa(rhFormaPagoTO.getUsrEmpresa());
        rhFormaPago.setCtaCodigo(rhFormaPagoTO.getCtaCodigo());
        rhFormaPago.setUsrEmpresa(rhFormaPagoTO.getUsrEmpresa());
        rhFormaPago.setUsrCodigo(rhFormaPagoTO.getUsrCodigo());
        rhFormaPago.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(rhFormaPagoTO.getUsrFechaInserta()));
        return rhFormaPago;
    }
    
    public static List<RhListaFormaPagoTO> convertirListaRhFormaPago_ListaRhFormaPagoTO(List datos) {
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
            Boolean dato5;
            try {
                dato5 = Boolean.valueOf(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new RhListaFormaPagoTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }
    
    public static List<RhComboFormaPagoTO> convertirRhComboFormaPago_RhComboFormaPagoTO(List datos) {
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
            Boolean dato3;
            try {
                dato3 = Boolean.parseBoolean(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            lista.add(new RhComboFormaPagoTO(dato1, dato2, dato3));
        }
        return lista;
    }
    
    public static RhCtaFormaPagoTO convertirRhCtaFormaPago_RhCtaFormaPagoTO(List datos) {
        RhCtaFormaPagoTO rhCtaFormaPagoTO = new RhCtaFormaPagoTO();//interface que extiende de array list, recibe parametros de dimencion
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
            rhCtaFormaPagoTO.setCtaCodigo(dato1);
            rhCtaFormaPagoTO.setSecCodigo(dato2);
        }
        return rhCtaFormaPagoTO;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMA PAGO BENEFICIO SOCIAL">
    public static RhFormaPagoBeneficiosSociales convertirRhFormaPagoBeneficioSocialTO_RhFormaPagoBeneficioSocial(RhFormaPagoBeneficioSocialTO rhFormaPagoBeneficioSocialTO) throws Exception {
        rrhh.entity.RhFormaPagoBeneficiosSociales rhFormaPagoBeneficiosSociales = new rrhh.entity.RhFormaPagoBeneficiosSociales();
        rhFormaPagoBeneficiosSociales.setFpSecuencial(rhFormaPagoBeneficioSocialTO.getFpSecuencial());
        rhFormaPagoBeneficiosSociales.setFpDetalle(rhFormaPagoBeneficioSocialTO.getFpDetalle());
        rhFormaPagoBeneficiosSociales.setFpCodigoMinisterial(rhFormaPagoBeneficioSocialTO.getFpCodigoMinisterial());
        rhFormaPagoBeneficiosSociales.setFpInactivo(rhFormaPagoBeneficioSocialTO.getFpInactivo());
        rhFormaPagoBeneficiosSociales.setSecEmpresa(rhFormaPagoBeneficioSocialTO.getUsrEmpresa());
        rhFormaPagoBeneficiosSociales.setSecCodigo(rhFormaPagoBeneficioSocialTO.getSecCodigo());
        rhFormaPagoBeneficiosSociales.setCtaEmpresa(rhFormaPagoBeneficioSocialTO.getUsrEmpresa());
        rhFormaPagoBeneficiosSociales.setCtaCodigo(rhFormaPagoBeneficioSocialTO.getCtaCodigo());
        rhFormaPagoBeneficiosSociales.setUsrEmpresa(rhFormaPagoBeneficioSocialTO.getUsrEmpresa());
        rhFormaPagoBeneficiosSociales.setUsrCodigo(rhFormaPagoBeneficioSocialTO.getUsrCodigo());
        rhFormaPagoBeneficiosSociales.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(rhFormaPagoBeneficioSocialTO.getUsrFechaInserta()));
        return rhFormaPagoBeneficiosSociales;
    }
    
    public static List<RhListaFormaPagoBeneficioSocialTO> convertirListaRhFormaPagoBeneficioSocial_ListaRhFormaPagoBeneficioSocialTO(List datos) {
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
            lista.add(new RhListaFormaPagoBeneficioSocialTO(dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }
    
    public static List<RhComboFormaPagoBeneficioSocialTO> convertirRhComboFormaPagoBeneficioSocial_RhComboFormaPagoBeneficioSocialTO(List datos) {
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
            lista.add(new RhComboFormaPagoBeneficioSocialTO(dato1, dato2, dato3));
        }
        return lista;
    }
    
    public static RhCtaFormaPagoBeneficioSocialTO convertirRhCtaFormaPagoBeneficioSocial_RhCtaFormaPagoBeneficioSocialTO(List datos) {
        RhCtaFormaPagoBeneficioSocialTO rhCtaFormaPagoBeneficioSocialTO = new RhCtaFormaPagoBeneficioSocialTO();//interface que extiende de array list, recibe parametros de dimencion
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
            rhCtaFormaPagoBeneficioSocialTO.setCtaCodigo(dato1);
            rhCtaFormaPagoBeneficioSocialTO.setSecCodigo(dato2);
            rhCtaFormaPagoBeneficioSocialTO.setFpCodigoMinisterial(dato3);
        }
        return rhCtaFormaPagoBeneficioSocialTO;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ANTICIPO">
    public static List<RhAnticipoTO> convertirRhAnticipo_RhAnticipoTO(List datos) throws Exception {
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
            BigDecimal dato2;
            try {
                dato2 = new BigDecimal(array[1].toString());
            } catch (Exception e) {
                dato2 = BigDecimal.ZERO;
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
            lista.add(new RhAnticipoTO(null, null, null, null, dato6, dato5, null, null, dato2, dato3, null, null, dato4, null, dato1));
        }
        return lista;
    }
    
    public static RhAnticipo convertirRhAnticipoTO_RhAnticipo(RhAnticipoTO rhAnticipoTO) throws Exception {
        RhAnticipo rhAnticipo = new RhAnticipo();
        rhAnticipo.setAntSecuencial(rhAnticipoTO.getAntSecuencial());
        rhAnticipo.setConEmpresa(rhAnticipoTO.getEmpCodigo());
        rhAnticipo.setConPeriodo(rhAnticipoTO.getPerCodigo());
        rhAnticipo.setConTipo(rhAnticipoTO.getTipCodigo());
        rhAnticipo.setConNumero(rhAnticipoTO.getConNumero());
        rhAnticipo.setSecEmpresa(rhAnticipoTO.getEmpCodigo());
        rhAnticipo.setSecCodigo(rhAnticipoTO.getSecCodigo());
        rhAnticipo.setAntReversado(rhAnticipoTO.getReversar());
//        rhAnticipo.setRhEmpleado(new RhEmpleado(
//                rhAnticipoTO.getEmpCodigo(),
//                rhAnticipoTO.getEmpId()));
        rhAnticipo.setAntValor(rhAnticipoTO.getReversar() ? rhAnticipoTO.getAntValor().negate() : rhAnticipoTO.getAntValor());
        rhAnticipo.setAntFormaPago(rhAnticipoTO.getAntFormasPago());
        return rhAnticipo;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PRESTAMO">
    public static List<RhPrestamoTO> convertirRhPrestamo_RhPrestamoTO(List datos) throws Exception {
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
            BigDecimal dato2;
            try {
                dato2 = new BigDecimal(array[1].toString());
            } catch (Exception e) {
                dato2 = BigDecimal.ZERO;
            }
            Integer dato3;
            try {
                dato3 = Integer.valueOf(array[2].toString());
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
            lista.add(new RhPrestamoTO(null, null, null, null, dato7, dato6, null, null, dato3, dato2, dato4, null, null, dato5, null, dato1));
        }
        return lista;
    }
    
    public static RhPrestamo convertirRhPrestamoTO_RhPrestamo(RhPrestamoTO rhPrestamoTO) throws Exception {
        RhPrestamo rhPrestamo = new RhPrestamo();
        rhPrestamo.setPreSecuencial(rhPrestamoTO.getPreSecuencial());
        rhPrestamo.setConEmpresa(rhPrestamoTO.getEmpCodigo());
        rhPrestamo.setConPeriodo(rhPrestamoTO.getPerCodigo());
        rhPrestamo.setConTipo(rhPrestamoTO.getTipCodigo());
        rhPrestamo.setConNumero(rhPrestamoTO.getConNumero());
        rhPrestamo.setSecEmpresa(rhPrestamoTO.getEmpCodigo());
        rhPrestamo.setSecCodigo(rhPrestamoTO.getSecCodigo());
        rhPrestamo.setPreReversado(rhPrestamoTO.getReversar());
        rhPrestamo.setRhEmpleado(new RhEmpleado(
                rhPrestamoTO.getEmpCodigo(),
                rhPrestamoTO.getEmpId()));
        rhPrestamo.setPreNumeroPagos(Short.valueOf(String.valueOf(rhPrestamoTO.getPreNumeroPagos())));
        rhPrestamo.setPreValor(rhPrestamoTO.getReversar() ? rhPrestamoTO.getPreValor().negate() : rhPrestamoTO.getPreValor());
        rhPrestamo.setPreFormaPago(rhPrestamoTO.getPreFormasPago());
        return rhPrestamo;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VACACIONES">
    public static List<RhVacacionesTO> convertirRhVacaciones_RhVacacionesTO(List datos) throws Exception {
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
            BigDecimal dato4;
            try {
                dato4 = new BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = BigDecimal.ZERO;
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
            lista.add(new RhVacacionesTO(null, dato7, null, dato8, dato2, dato3, dato9, dato10, dato11, dato4, dato5, null, null, null, null, null, null, dato6, null, dato1));
        }
        return lista;
    }
    
    public static RhVacaciones convertirRhVacacionesTO_RhVacaciones(RhVacacionesTO rhVacacionesTO) throws Exception {
        RhVacaciones rhVacaciones = new RhVacaciones();
        rhVacaciones.setVacSecuencial(rhVacacionesTO.getVacSecuencial());
        rhVacaciones.setVacDesde(validaciones.Validacion.fecha(rhVacacionesTO.getVacDesde(), "yyyy-MM-dd"));
        rhVacaciones.setVacHasta(validaciones.Validacion.fecha(rhVacacionesTO.getVacHasta(), "yyyy-MM-dd"));
        rhVacaciones.setVacValor(rhVacacionesTO.getVacValor());
        rhVacaciones.setVacFormaPago(rhVacacionesTO.getVacFormaPago());
        rhVacaciones.setVacReversado(rhVacacionesTO.getReversar());
        rhVacaciones.setRhEmpleado(new RhEmpleado(
                rhVacacionesTO.getEmpEmpresa(),
                rhVacacionesTO.getEmpId()));
        rhVacaciones.setVacGozadas(rhVacacionesTO.getVacGozadas());
        rhVacaciones.setVacGozadasDesde(validaciones.Validacion.fecha(rhVacacionesTO.getVacGozadasDesde(), "yyyy-MM-dd"));
        rhVacaciones.setVacGozadasHasta(validaciones.Validacion.fecha(rhVacacionesTO.getVacGozadasHasta(), "yyyy-MM-dd"));
        rhVacaciones.setSecEmpresa(rhVacacionesTO.getEmpEmpresa());
        rhVacaciones.setSecCodigo(rhVacacionesTO.getSecCodigo());
        rhVacaciones.setConEmpresa(rhVacacionesTO.getEmpEmpresa());
        rhVacaciones.setConPeriodo(rhVacacionesTO.getConPeriodo());
        rhVacaciones.setConTipo(rhVacacionesTO.getConTipo());
        rhVacaciones.setConNumero(rhVacacionesTO.getConNumero());
        return rhVacaciones;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VIATICO">
    public static List<RhViaticoTO> convertirRhViatico_RhViaticoTO(List datos) throws Exception {
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
            BigDecimal dato2;
            try {
                dato2 = new BigDecimal(array[1].toString());
            } catch (Exception e) {
                dato2 = BigDecimal.ZERO;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.valueOf(array[2].toString());
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
            lista.add(new RhViaticoTO(null, null, null, null, dato5, dato4, null, null, dato2, null, dato3, null, dato1));
        }
        return lista;
    }
    
    public static RhViatico convertirRhViaticoTO_RhViatico(RhViaticoTO rhViaticoTO) throws Exception {
        RhViatico rhViatico = new RhViatico();
        rhViatico.setViaSecuencial(rhViaticoTO.getViaSecuencial());
        rhViatico.setConEmpresa(rhViaticoTO.getEmpCodigo());
        rhViatico.setConPeriodo(rhViaticoTO.getPerCodigo());
        rhViatico.setConTipo(rhViaticoTO.getTipCodigo());
        rhViatico.setConNumero(rhViaticoTO.getConNumero());
        rhViatico.setSecEmpresa(rhViaticoTO.getEmpCodigo());
        rhViatico.setSecCodigo(rhViaticoTO.getSecCodigo());
        rhViatico.setViaReversado(rhViaticoTO.getReversar());
        rhViatico.setRhEmpleado(new RhEmpleado(
                rhViaticoTO.getEmpCodigo(),
                rhViaticoTO.getEmpId()));
        rhViatico.setViaValor(rhViaticoTO.getReversar() ? rhViaticoTO.getViaValor().negate() : rhViaticoTO.getViaValor());
        return rhViatico;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BONO">
    public static List<RhBonoTO> convertirRhBono_RhBonoTO(List datos) throws Exception {
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
            Integer dato3;
            try {
                dato3 = Integer.valueOf(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            BigDecimal dato4;
            try {
                dato4 = new BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = BigDecimal.ZERO;
            }
            BigDecimal dato5;
            try {
                dato5 = new BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = BigDecimal.ZERO;
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
            Boolean dato8;
            try {
                dato8 = Boolean.valueOf(array[7].toString());
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
            lista.add(new RhBonoTO(null, null, null, null, dato10, dato11, dato9,
                    null, null, dato2, dato6, dato7, dato3, dato4, dato5, null,
                    dato8, null, dato1));
        }
        return lista;
    }
    
    public static RhBono convertirRhBonoTO_RhBono(RhBonoTO rhBonoTO) throws Exception {
        RhBono rhBono = new RhBono();
        rhBono.setBonoSecuencial(rhBonoTO.getBonoSecuencial());
        rhBono.setConEmpresa(rhBonoTO.getEmpCodigo());
        rhBono.setConPeriodo(rhBonoTO.getPerCodigo());
        rhBono.setConTipo(rhBonoTO.getTipCodigo());
        rhBono.setConNumero(rhBonoTO.getConNumero());
        rhBono.setSecEmpresa(rhBonoTO.getEmpCodigo());
        rhBono.setSecCodigo(rhBonoTO.getSecCodigo());
        rhBono.setBonoReversado(rhBonoTO.getReversar());
//        rhBono.setRhEmpleado(new RhEmpleado(
//                rhBonoTO.getEmpCodigo(),
//                rhBonoTO.getEmpId()));
        rhBono.setPisNumero(rhBonoTO.getPisNumero());
        rhBono.setBonoConcepto(rhBonoTO.getBonoConcepto());
        rhBono.setBonoDeducible(rhBonoTO.getBonoDeducible());
        rhBono.setBonoObservacion(rhBonoTO.getBonoObservacion());
        rhBono.setBonoCantidad(Short.valueOf(String.valueOf(rhBonoTO.getBonoCantidad())));
        rhBono.setBonoPrecio(rhBonoTO.getBonoPrecio());
        rhBono.setBonoValor(rhBonoTO.getReversar() ? rhBonoTO.getBonoValor().negate() : rhBonoTO.getBonoValor());
        return rhBono;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BONO CONCEPTO">
    public static RhBonoConcepto convertirRhBonoConceptoTO_RhBonoConcepto(RhBonoConceptoTO rhBonoConceptoTO) throws Exception {
        RhBonoConcepto rhBonoConcepto = new RhBonoConcepto();
        
        rhBonoConcepto.setBcSecuencial(rhBonoConceptoTO.getBcSecuencia());
        rhBonoConcepto.setBcDetalle(rhBonoConceptoTO.getBcDetalle());
        rhBonoConcepto.setBcValor(rhBonoConceptoTO.getBcValor());
        rhBonoConcepto.setBcValorFijo(rhBonoConceptoTO.getBcValorFijo());
        rhBonoConcepto.setBcInactivo(rhBonoConceptoTO.getBcInactivo());
        
        rhBonoConcepto.setUsrEmpresa(rhBonoConceptoTO.getEmpCodigo());
        rhBonoConcepto.setUsrCodigo(rhBonoConceptoTO.getUsrInsertaBonoConcepto());
        rhBonoConcepto.setUsrFechaInserta(Validacion.fechaString_Date(rhBonoConceptoTO.getUsrFechaInsertaBonoConcepto()));
        return rhBonoConcepto;
    }
    
    public static List<RhListaBonoConceptoTO> convertirListaRhBonoConcepto_ListaRhBonoConceptoTO(List datos) {
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
            BigDecimal dato3;
            try {
                dato3 = new BigDecimal(array[2].toString());
            } catch (Exception e) {
//                dato3 = null;
                dato3 = BigDecimal.ZERO;
            }
            Boolean dato4;
            try {
                dato4 = Boolean.valueOf(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            Boolean dato5;
            try {
                dato5 = Boolean.valueOf(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new RhListaBonoConceptoTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }
    
    public static List<RhComboBonoConceptoTO> convertirRhComboBonoConcepto_RhComboBonoConceptoTO(List datos) {
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
//                dato2 = null;
                dato2 = BigDecimal.ZERO;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.valueOf(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            lista.add(new RhComboBonoConceptoTO(dato1, dato2, dato3));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ROL">
    public static List<rrhh.TO.RhRolBDTO> convertirRhRol_RhRolBDTO(List datos) throws Exception {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            Integer rolSecuencial = obtenerDatoInteger(array[0]);
            String rolDesde = obtenerDatoString(array[1]);
            String rolHasta = obtenerDatoString(array[2]);
            String rolFechaUltimoSueldo = obtenerDatoString(array[3]);
            Integer rolDiasLaboradosReales = obtenerDatoInteger(array[4]);
            Integer rolDiasFaltasReales = obtenerDatoInteger(array[5]);
            Integer rolDiasExtrasReales = obtenerDatoInteger(array[6]);
            Integer rolDiasDescansoReales = obtenerDatoInteger(array[7]);
            Integer rolDiasPagadosReales = obtenerDatoInteger(array[8]);
            Integer rolDiasPermisoMedico = obtenerDatoInteger(array[9]);
            BigDecimal rolSaldoAnterior = obtenerDatoBigDecimal(array[10]);
            BigDecimal rolIngresos = obtenerDatoBigDecimal(array[11]);
            BigDecimal rolBonos = obtenerDatoBigDecimal(array[12]);
            BigDecimal rolBonosnd = obtenerDatoBigDecimal(array[13]);
            BigDecimal rolBonoFijo = obtenerDatoBigDecimal(array[14]);
            BigDecimal rolBonoFijoNd = obtenerDatoBigDecimal(array[15]);
            BigDecimal rolOtrosIngresos = obtenerDatoBigDecimal(array[16]);
            BigDecimal rolOtrosIngresosNd = obtenerDatoBigDecimal(array[17]);
            BigDecimal rolViaticos = obtenerDatoBigDecimal(array[18]);
            BigDecimal rolLiqFondoReserva = obtenerDatoBigDecimal(array[19]);
            BigDecimal rolLiqXiii = obtenerDatoBigDecimal(array[20]);
            BigDecimal rolLiqXiv = obtenerDatoBigDecimal(array[21]);
            BigDecimal rolLiqVacaciones = obtenerDatoBigDecimal(array[22]);
            BigDecimal rolLiqSalarioDigno = obtenerDatoBigDecimal(array[23]);
            BigDecimal rolLiqDesahucio = obtenerDatoBigDecimal(array[24]);
            BigDecimal rolLiqDesahucioIntempestivo = obtenerDatoBigDecimal(array[25]);
            BigDecimal rolLiqBonificacion = obtenerDatoBigDecimal(array[26]);
            BigDecimal rolAnticipos = obtenerDatoBigDecimal(array[27]);
            BigDecimal rolPrestamos = obtenerDatoBigDecimal(array[28]);
            BigDecimal rolIess = obtenerDatoBigDecimal(array[29]);
            BigDecimal rolRetencionFuente = obtenerDatoBigDecimal(array[30]);
            BigDecimal rolDescuentoPermisoMedico = obtenerDatoBigDecimal(array[31]);
            BigDecimal rolTotal = obtenerDatoBigDecimal(array[32]);
            String rolFormaPago = obtenerDatoString(array[33]);
            BigDecimal rolAportePatronal = obtenerDatoBigDecimal(array[34]);
            BigDecimal rolIece = obtenerDatoBigDecimal(array[35]);
            BigDecimal rolSecap = obtenerDatoBigDecimal(array[36]);
            BigDecimal rolXiii = obtenerDatoBigDecimal(array[37]);
            BigDecimal rolXiv = obtenerDatoBigDecimal(array[38]);
            BigDecimal rolFondoReserva = obtenerDatoBigDecimal(array[39]);
            BigDecimal rolVacaciones = obtenerDatoBigDecimal(array[40]);
            BigDecimal rolDesahucio = obtenerDatoBigDecimal(array[41]);
            Boolean rolReversado = obtenerDatoBoolean(array[42]);
            String empId = obtenerDatoString(array[43]);
            String empCargo = obtenerDatoString(array[44]);
            BigDecimal empSueldo = obtenerDatoBigDecimal(array[45]);
            BigDecimal empBonoFijo = obtenerDatoBigDecimal(array[46]);
            BigDecimal empBonoFijoNd = obtenerDatoBigDecimal(array[47]);
            BigDecimal empOtrosIngresos = obtenerDatoBigDecimal(array[48]);
            BigDecimal empOtrosIngresosNd = obtenerDatoBigDecimal(array[49]);
            Integer empDiasLaborados = obtenerDatoInteger(array[50]);
            Integer empDiasDescanso = obtenerDatoInteger(array[51]);
            Boolean empCancelarXiiiSueldoMensualmente = obtenerDatoBoolean(array[52]);
            Boolean empCancelarXivSueldoMensualmente = obtenerDatoBoolean(array[53]);
            Boolean empCancelarFondoReservaMensualmente = obtenerDatoBoolean(array[54]);
            String secCodigo = obtenerDatoString(array[55]);
            String conProvisionPeriodo = obtenerDatoString(array[56]);
            String conProvisionTipo = obtenerDatoString(array[57]);
            String conProvisionNumero = obtenerDatoString(array[58]);
            
            lista.add(new rrhh.TO.RhRolBDTO(rolSecuencial, rolDesde, rolHasta, rolFechaUltimoSueldo,
                    rolDiasLaboradosReales, rolDiasFaltasReales, rolDiasExtrasReales, rolDiasDescansoReales, rolDiasPagadosReales, rolDiasPermisoMedico, rolSaldoAnterior, rolIngresos, rolBonos, rolBonosnd, rolBonoFijo, rolBonoFijoNd, rolOtrosIngresos, rolOtrosIngresosNd, rolViaticos, rolLiqFondoReserva, rolLiqXiii, rolLiqXiv, rolLiqVacaciones, rolLiqSalarioDigno, rolLiqDesahucio,
                    rolLiqDesahucioIntempestivo, rolLiqBonificacion, rolAnticipos, rolPrestamos, rolIess, rolRetencionFuente, rolDescuentoPermisoMedico, rolTotal, rolFormaPago, rolAportePatronal, rolIece, rolSecap, rolXiii, rolXiv, rolFondoReserva, rolVacaciones, rolDesahucio, rolReversado, empId, empCargo, empSueldo, empBonoFijo, empBonoFijoNd, empOtrosIngresos, empOtrosIngresosNd,
                    empDiasLaborados, empDiasDescanso, empCancelarXiiiSueldoMensualmente, empCancelarXivSueldoMensualmente, empCancelarFondoReservaMensualmente, secCodigo, conProvisionPeriodo, conProvisionTipo, conProvisionNumero));
        }
        return lista;
    }
    
    public static RhRolSueldoEmpleadoTO convertirRhRolSueldoEmpleado_RhRolSueldoEmpleadoTO(List datos) {
        RhRolSueldoEmpleadoTO rhRolSueldoEmpleadoTO = new RhRolSueldoEmpleadoTO();
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
//                dato3 = null;
                dato3 = BigDecimal.ZERO;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            rhRolSueldoEmpleadoTO.setEmpCargo(dato1);
            rhRolSueldoEmpleadoTO.setEmpFormaPago(dato2);
            rhRolSueldoEmpleadoTO.setEmpSueldoReal(dato3);
            rhRolSueldoEmpleadoTO.setRolFechaUltimoSueldo(dato4);
        }
        return rhRolSueldoEmpleadoTO;
    }
    
    public static RhCancelarBeneficioSocialTO convertirRhCancelarBeneficioSocial_RhCancelarBeneficioSocialTO(List datos) {
        RhCancelarBeneficioSocialTO rhCancelarBeneficioSocialTO = new RhCancelarBeneficioSocialTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            Boolean dato1;
            try {
                dato1 = Boolean.valueOf(array[0].toString());
            } catch (Exception e) {
                dato1 = false;
            }
            Boolean dato2;
            try {
                dato2 = Boolean.valueOf(array[1].toString());
            } catch (Exception e) {
                dato2 = false;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.valueOf(array[2].toString());
            } catch (Exception e) {
                dato3 = false;
            }
            rhCancelarBeneficioSocialTO.setEmpCancelarXiiiSueldoMensualmente(dato1);
            rhCancelarBeneficioSocialTO.setEmpCancelarXivSueldoMensualmente(dato2);
            rhCancelarBeneficioSocialTO.setEmpCancelarFondoReservaMensualmente(dato3);
        }
        return rhCancelarBeneficioSocialTO;
    }
    
    public static RhRolSaldoEmpleadoTO convertirRhRolSaldoEmpleado_RhRolSaldoEmpleadoTO(List datos) {
        RhRolSaldoEmpleadoTO rhRolSaldoEmpleadoTO = new RhRolSaldoEmpleadoTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            BigDecimal dato1;
            try {
                dato1 = new BigDecimal(array[0].toString());
            } catch (Exception e) {
//                dato1 = null;
                dato1 = BigDecimal.ZERO;
            }
            BigDecimal dato2;
            try {
                dato2 = new BigDecimal(array[1].toString());
            } catch (Exception e) {
//                dato2 = null;
                dato2 = BigDecimal.ZERO;
            }
            BigDecimal dato3;
            try {
                dato3 = new BigDecimal(array[2].toString());
            } catch (Exception e) {
//                dato3 = null;
                dato3 = BigDecimal.ZERO;
            }
            BigDecimal dato4;
            try {
                dato4 = new BigDecimal(array[3].toString());
            } catch (Exception e) {
//                dato4 = null;
                dato4 = BigDecimal.ZERO;
            }
            BigDecimal dato5;
            try {
                dato5 = new BigDecimal(array[4].toString());
            } catch (Exception e) {
//                dato5 = null;
                dato5 = BigDecimal.ZERO;
            }
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
            } catch (Exception e) {
//                dato6 = null;
                dato6 = BigDecimal.ZERO;
            }
            rhRolSaldoEmpleadoTO.setSaldoAnterior(dato1);
            rhRolSaldoEmpleadoTO.setSaldoAnticipo(dato2);
            rhRolSaldoEmpleadoTO.setSaldoPrestamo(dato3);
            rhRolSaldoEmpleadoTO.setSaldoBono(dato4);
            rhRolSaldoEmpleadoTO.setSaldoBonond(dato5);
            rhRolSaldoEmpleadoTO.setSaldoViaticos(dato6);
        }
        return rhRolSaldoEmpleadoTO;
    }
    
    public static List<RhListaRolSaldoEmpleadoDetalladoTO> convertirRhRolSaldoEmpleadoDetallado_RhRolSaldoEmpleadoDetalladoTO(List datos) {
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
//                dato6 = null;
                dato6 = BigDecimal.ZERO;
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
            lista.add(new RhListaRolSaldoEmpleadoDetalladoTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }
    
    public static RhRol convertirRhFunPlantillaSueldosLoteTO_RhRol(
            rrhh.TO.RhFunPlantillaSueldosLoteTO rhFunPlantillaSueldosLoteTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        RhRol rhRol = new RhRol();
        rhRol.setRolSecuencial(null);//(rhFunPlantillaSueldosLoteTO.getRolSecuencial());
        rhRol.setConEmpresa(sisInfoTO.getInfEmpresa());
        rhRol.setConPeriodo(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getPerCodigo());
        rhRol.setConTipo(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getTipCodigo());
        rhRol.setConNumero(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().getConNumero());
        rhRol.setSecEmpresa(sisInfoTO.getInfEmpresa());
        rhRol.setSecCodigo(rhFunPlantillaSueldosLoteTO.getPrSector());
        rhRol.setRolReversado(rhFunPlantillaSueldosLoteTO.getRhRolesLoteValoresTO().isRolReversado());
        rhRol.setRhEmpleado(new RhEmpleado(
                sisInfoTO.getInfEmpresa(),
                rhFunPlantillaSueldosLoteTO.getPrId()));
        rhRol.setEmpCargo(rhFunPlantillaSueldosLoteTO.getPrCargo());
        rhRol.setRolFechaUltimoSueldo(Validacion.fecha(rhFunPlantillaSueldosLoteTO.getRolFechaUltimoSueldo(), "yyyy-MM-dd"));
        rhRol.setRolDesde(Validacion.fecha(rhFunPlantillaSueldosLoteTO.getPrDesde(), "yyyy-MM-dd"));
        rhRol.setRolHasta(Validacion.fecha(rhFunPlantillaSueldosLoteTO.getPrHasta(), "yyyy-MM-dd"));
        rhRol.setRolDiasLaboradosReales(Short.valueOf(String.valueOf(rhFunPlantillaSueldosLoteTO.getRolDiasLaboradosReales())));
        rhRol.setRolDiasFaltasReales(Short.valueOf(String.valueOf(rhFunPlantillaSueldosLoteTO.getRolDiasFaltasReales())));
        rhRol.setRolDiasExtrasReales(Short.valueOf(String.valueOf(rhFunPlantillaSueldosLoteTO.getRolDiasExtrasReales())));
        rhRol.setRolDiasDescansoReales(Short.valueOf(String.valueOf(rhFunPlantillaSueldosLoteTO.getRolDiasDescansoReales())));
        rhRol.setRolDiasPagadosReales(Short.valueOf(String.valueOf(rhFunPlantillaSueldosLoteTO.getRolDiasPagadosReales())));
        rhRol.setRolDiasPermisoMedico(Short.valueOf(String.valueOf(rhFunPlantillaSueldosLoteTO.getRolDiasPermisoMedico())));
        rhRol.setEmpSueldo(rhFunPlantillaSueldosLoteTO.getEmpSueldo());
        rhRol.setEmpDiasLaborados(Short.valueOf(String.valueOf(rhFunPlantillaSueldosLoteTO.getEmpDiasLaborados())));
        rhRol.setEmpDiasDescanso(Short.valueOf(String.valueOf(rhFunPlantillaSueldosLoteTO.getEmpDiasDescanso())));
        rhRol.setEmpCancelarXiiiSueldoMensualmente(rhFunPlantillaSueldosLoteTO.isEmpCancelarXiiiSueldoMensualmente());
        rhRol.setEmpCancelarXivSueldoMensualmente(rhFunPlantillaSueldosLoteTO.isEmpCancelarXivSueldoMensualmente());
        rhRol.setEmpCancelarFondoReservaMensualmente(rhFunPlantillaSueldosLoteTO.isEmpCancelarFondoReservaMensualmente());
        rhRol.setRolSaldoAnterior(rhFunPlantillaSueldosLoteTO.getRolSaldoAnterior());
        rhRol.setRolIngresos(rhFunPlantillaSueldosLoteTO.getRolIngresos());
        rhRol.setRolBonos(rhFunPlantillaSueldosLoteTO.getRolBonos());
        rhRol.setRolBonosnd(rhFunPlantillaSueldosLoteTO.getRolBonosnd());
        rhRol.setRolBonoFijo(rhFunPlantillaSueldosLoteTO.getRolBonoFijo());
        rhRol.setRolBonoFijoNd(rhFunPlantillaSueldosLoteTO.getRolBonoFijoNd());
        rhRol.setEmpBonoFijo(rhFunPlantillaSueldosLoteTO.getEmpBonoFijo());
        rhRol.setEmpBonoFijoNd(rhFunPlantillaSueldosLoteTO.getEmpBonoFijoNd());
        rhRol.setRolViaticos(rhFunPlantillaSueldosLoteTO.getRolViaticos());
        rhRol.setRolLiqFondoReserva(rhFunPlantillaSueldosLoteTO.getRolLiqFondoReserva());
        rhRol.setRolLiqXiii(rhFunPlantillaSueldosLoteTO.getRolLiqXiii());
        rhRol.setRolLiqXiv(rhFunPlantillaSueldosLoteTO.getRolLiqXiv());
        rhRol.setRolLiqVacaciones(rhFunPlantillaSueldosLoteTO.getRolLiqVacaciones());
        rhRol.setRolLiqSalarioDigno(rhFunPlantillaSueldosLoteTO.getRolLiqSalarioDigno());
        rhRol.setRolLiqDesahucio(rhFunPlantillaSueldosLoteTO.getRolLiqDesahucio());
        rhRol.setRolLiqDesahucioIntempestivo(rhFunPlantillaSueldosLoteTO.getRolLiqDesahucioIntempestivo());
        rhRol.setRolAnticipos(rhFunPlantillaSueldosLoteTO.getRolAnticipos());
        rhRol.setRolPrestamos(rhFunPlantillaSueldosLoteTO.getRolPrestamos());
        rhRol.setRolIess(rhFunPlantillaSueldosLoteTO.getRolIess());
        rhRol.setRolRetencionFuente(rhFunPlantillaSueldosLoteTO.getRolRetencionFuente());
        rhRol.setRolDescuentoPermisoMedico(rhFunPlantillaSueldosLoteTO.getRolDescuentoPermisoMedico());
        rhRol.setRolTotal(rhFunPlantillaSueldosLoteTO.getRolTotal());
        rhRol.setRolFormaPago(rhFunPlantillaSueldosLoteTO.getRolFormaPago());
        rhRol.setRolAportePatronal(rhFunPlantillaSueldosLoteTO.getRolAportePatronal());
        rhRol.setRolIece(rhFunPlantillaSueldosLoteTO.getRolIece());
        rhRol.setRolSecap(rhFunPlantillaSueldosLoteTO.getRolSecap());
        rhRol.setRolXiii(rhFunPlantillaSueldosLoteTO.getRolXiii());
        rhRol.setRolXiv(rhFunPlantillaSueldosLoteTO.getRolXiv());
        rhRol.setRolFondoReserva(rhFunPlantillaSueldosLoteTO.getRolFondoReserva());
        rhRol.setRolVacaciones(rhFunPlantillaSueldosLoteTO.getRolVacaciones());
        rhRol.setRolDesahucio(rhFunPlantillaSueldosLoteTO.getRolDesahucio());
        rhRol.setConProvisionEmpresa(sisInfoTO.getInfEmpresa());
        rhRol.setConProvisionPeriodo(null);//(rhFunPlantillaSueldosLoteTO.getRolProvisionPeriodo());
        rhRol.setConProvisionTipo(null);//(rhFunPlantillaSueldosLoteTO.getRolProvisionTipo());
        rhRol.setConProvisionNumero(null);//(rhFunPlantillaSueldosLoteTO.getRolProvisionNumero());
        rhRol.setRolOtrosIngresos(rhFunPlantillaSueldosLoteTO.getRolOtrosIngresos());
        rhRol.setRolOtrosIngresosNd(rhFunPlantillaSueldosLoteTO.getRolOtrosIngresosNd());
        rhRol.setEmpOtrosIngresos(rhFunPlantillaSueldosLoteTO.getEmpOtrosIngresos());
        rhRol.setEmpOtrosIngresosNd(rhFunPlantillaSueldosLoteTO.getEmpOtrosIngresosNd());
        return rhRol;
    }
    
    public static RhRol convertirRhRolTO_RhRol(RhRolTO rhRolTO) throws Exception {
        RhRol rhRol = new RhRol();
        rhRol.setRolSecuencial(rhRolTO.getRolSecuencial());
        rhRol.setConEmpresa(rhRolTO.getEmpCodigo());
        rhRol.setConPeriodo(rhRolTO.getPerCodigo());
        rhRol.setConTipo(rhRolTO.getTipCodigo());
        rhRol.setConNumero(rhRolTO.getConNumero());
        rhRol.setSecEmpresa(rhRolTO.getEmpCodigo());
        rhRol.setSecCodigo(rhRolTO.getSecCodigo());
        rhRol.setRolReversado(rhRolTO.getReversar());
        rhRol.setRhEmpleado(new RhEmpleado(
                rhRolTO.getEmpCodigo(),
                rhRolTO.getEmpId()));
        rhRol.setEmpCargo(rhRolTO.getEmpCargo());
        rhRol.setRolFechaUltimoSueldo(Validacion.fecha(rhRolTO.getRolFechaUltimoSueldo(), "yyyy-MM-dd"));
        rhRol.setRolDesde(Validacion.fecha(rhRolTO.getRolDesde(), "yyyy-MM-dd"));
        rhRol.setRolHasta(Validacion.fecha(rhRolTO.getRolHasta(), "yyyy-MM-dd"));
        rhRol.setRolDiasLaboradosReales(Short.valueOf(String.valueOf(rhRolTO.getRolDiasLaboradosReales())));
        rhRol.setRolDiasFaltasReales(Short.valueOf(String.valueOf(rhRolTO.getRolDiasFaltasReales())));
        rhRol.setRolDiasExtrasReales(Short.valueOf(String.valueOf(0)));
        rhRol.setRolDiasDescansoReales(Short.valueOf(String.valueOf(rhRolTO.getRolDiasDescansoReales())));
        rhRol.setRolDiasPagadosReales(Short.valueOf(String.valueOf(rhRolTO.getRolDiasPagadosReales())));
        rhRol.setRolDiasPermisoMedico(Short.valueOf(String.valueOf(rhRolTO.getRolDiasPermisoMedico())));
        rhRol.setEmpSueldo(rhRolTO.getEmpSueldo());
        rhRol.setEmpDiasLaborados(Short.valueOf(String.valueOf(rhRolTO.getEmpDiasLaborados())));
        rhRol.setEmpDiasDescanso(Short.valueOf(String.valueOf(rhRolTO.getEmpDiasDescanso())));
        rhRol.setEmpCancelarXiiiSueldoMensualmente(rhRolTO.getEmpCancelarXiiiSueldoMensualmente());
        rhRol.setEmpCancelarXivSueldoMensualmente(rhRolTO.getEmpCancelarXivSueldoMensualmente());
        rhRol.setEmpCancelarFondoReservaMensualmente(rhRolTO.getEmpCancelarFondoReservaMensualmente());
        rhRol.setRolSaldoAnterior(rhRolTO.getRolSaldoAnterior());
        rhRol.setRolIngresos(rhRolTO.getRolIngresos());
        rhRol.setRolBonos(rhRolTO.getRolBonos());
        rhRol.setRolBonosnd(rhRolTO.getRolBonosnd());
        rhRol.setRolBonoFijo(rhRolTO.getRolBonosFijo());
        rhRol.setRolBonoFijoNd(rhRolTO.getRolBonosFijoNd());
        rhRol.setEmpBonoFijo(rhRolTO.getEmpBonosFijo());
        rhRol.setEmpBonoFijoNd(rhRolTO.getEmpBonosFijoNd());
        rhRol.setRolViaticos(rhRolTO.getRolViaticos());
        rhRol.setRolLiqFondoReserva(rhRolTO.getRolLiqFondoReserva());
        rhRol.setRolLiqXiii(rhRolTO.getRolLiqXiii());
        rhRol.setRolLiqXiv(rhRolTO.getRolLiqXiv());
        rhRol.setRolLiqVacaciones(rhRolTO.getRolLiqVacaciones());
        rhRol.setRolLiqSalarioDigno(rhRolTO.getRolLiqSalarioDigno());
        rhRol.setRolLiqDesahucio(rhRolTO.getRolLiqDesahucio());
        rhRol.setRolLiqDesahucioIntempestivo(rhRolTO.getRolLiqDesahucioIntempestivo());
        rhRol.setRolLiqBonificacion(rhRolTO.getRolLiqBonificacion());
        rhRol.setRolAnticipos(rhRolTO.getRolAnticipos());
        rhRol.setRolPrestamos(rhRolTO.getRolPrestamos());
        rhRol.setRolIess(rhRolTO.getRolIess());
        rhRol.setRolRetencionFuente(rhRolTO.getRolRetencionFuente());
        rhRol.setRolDescuentoPermisoMedico(rhRolTO.getRolDescuentoPermisoMedico());
        rhRol.setRolTotal(rhRolTO.getRolTotal());
        rhRol.setRolFormaPago(rhRolTO.getRolFormaPago());
        rhRol.setRolAportePatronal(rhRolTO.getRolAportePatronal());
        rhRol.setRolIece(rhRolTO.getRolIece());
        rhRol.setRolSecap(rhRolTO.getRolSecap());
        rhRol.setRolXiii(rhRolTO.getRolXiii());
        rhRol.setRolXiv(rhRolTO.getRolXiv());
        rhRol.setRolFondoReserva(rhRolTO.getRolFondoReserva());
        rhRol.setRolVacaciones(rhRolTO.getRolVacaciones());
        rhRol.setRolDesahucio(rhRolTO.getRolDesahucio());
        rhRol.setConProvisionEmpresa(rhRolTO.getRolProvisionEmpresa());
        rhRol.setConProvisionPeriodo(rhRolTO.getRolProvisionPeriodo());
        rhRol.setConProvisionTipo(rhRolTO.getRolProvisionTipo());
        rhRol.setConProvisionNumero(rhRolTO.getRolProvisionNumero());
        rhRol.setRolOtrosIngresos(rhRolTO.getRolOtrosIngresos());
        rhRol.setRolOtrosIngresosNd(rhRolTO.getRolOtrosIngresosNd());
        rhRol.setEmpOtrosIngresos(rhRolTO.getEmpOtrosIngresos());
        rhRol.setEmpOtrosIngresosNd(rhRolTO.getEmpOtrosIngresosNd());
        rhRol.setEmpSalarioNeto(rhRolTO.getEmpSalarioNeto());
        return rhRol;
    }
    
    public static RhRol convertirRhRol_RhRol(RhRol rhRolAux) throws Exception {
        RhRol rhRol = new RhRol();
        rhRol.setRolSecuencial(rhRolAux.getRolSecuencial());
        rhRol.setConEmpresa(rhRolAux.getConEmpresa());
        rhRol.setConPeriodo(rhRolAux.getConPeriodo());
        rhRol.setConTipo(rhRolAux.getConTipo());
        rhRol.setConNumero(rhRolAux.getConNumero());
        rhRol.setSecEmpresa(rhRolAux.getSecEmpresa());
        rhRol.setSecCodigo(rhRolAux.getSecCodigo());
        rhRol.setRolReversado(rhRolAux.getRolReversado());
//        rhRol.setRhEmpleado(new RhEmpleado(
//                rhRolAux.getEmpCodigo(),
//                rhRolAux.getEmpId()));
        rhRol.setEmpCargo(rhRolAux.getEmpCargo());
        rhRol.setRolFechaUltimoSueldo(rhRolAux.getRolFechaUltimoSueldo());
        rhRol.setRolDesde(rhRolAux.getRolDesde());
        rhRol.setRolHasta(rhRolAux.getRolHasta());
        rhRol.setRolDiasLaboradosReales(rhRolAux.getRolDiasLaboradosReales());
        rhRol.setRolDiasFaltasReales(rhRolAux.getRolDiasFaltasReales());
        rhRol.setRolDiasExtrasReales(rhRolAux.getRolDiasExtrasReales());
        rhRol.setRolDiasDescansoReales(rhRolAux.getRolDiasDescansoReales());
        rhRol.setRolDiasPagadosReales(rhRolAux.getRolDiasPagadosReales());
        rhRol.setRolDiasPermisoMedico(rhRolAux.getRolDiasPermisoMedico());
        rhRol.setEmpSueldo(rhRolAux.getEmpSueldo());
        rhRol.setEmpDiasLaborados(rhRolAux.getEmpDiasLaborados());
        rhRol.setEmpDiasDescanso(rhRolAux.getEmpDiasDescanso());
        rhRol.setEmpCancelarXiiiSueldoMensualmente(rhRolAux.getEmpCancelarXiiiSueldoMensualmente());
        rhRol.setEmpCancelarXivSueldoMensualmente(rhRolAux.getEmpCancelarXivSueldoMensualmente());
        rhRol.setEmpCancelarFondoReservaMensualmente(rhRolAux.getEmpCancelarFondoReservaMensualmente());
        rhRol.setRolSaldoAnterior(rhRolAux.getRolSaldoAnterior());
        rhRol.setRolIngresos(rhRolAux.getRolIngresos());
        rhRol.setRolBonos(rhRolAux.getRolBonos());
        rhRol.setRolBonosnd(rhRolAux.getRolBonosnd());
        rhRol.setRolBonoFijo(rhRolAux.getRolBonoFijo());
        rhRol.setRolBonoFijoNd(rhRolAux.getRolBonoFijoNd());
        rhRol.setEmpBonoFijo(rhRolAux.getEmpBonoFijo());
        rhRol.setEmpBonoFijoNd(rhRolAux.getEmpBonoFijoNd());
        rhRol.setRolViaticos(rhRolAux.getRolViaticos());
        rhRol.setRolLiqFondoReserva(rhRolAux.getRolLiqFondoReserva());
        rhRol.setRolLiqXiii(rhRolAux.getRolLiqXiii());
        rhRol.setRolLiqXiv(rhRolAux.getRolLiqXiv());
        rhRol.setRolLiqVacaciones(rhRolAux.getRolLiqVacaciones());
        rhRol.setRolLiqSalarioDigno(rhRolAux.getRolLiqSalarioDigno());
        rhRol.setRolLiqDesahucio(rhRolAux.getRolLiqDesahucio());
        rhRol.setRolLiqDesahucioIntempestivo(rhRolAux.getRolLiqDesahucioIntempestivo());
        rhRol.setRolAnticipos(rhRolAux.getRolAnticipos());
        rhRol.setRolPrestamos(rhRolAux.getRolPrestamos());
        rhRol.setRolIess(rhRolAux.getRolIess());
        rhRol.setRolRetencionFuente(rhRolAux.getRolRetencionFuente());
        rhRol.setRolDescuentoPermisoMedico(rhRolAux.getRolDescuentoPermisoMedico());
        rhRol.setRolTotal(rhRolAux.getRolTotal());
        rhRol.setRolFormaPago(rhRolAux.getRolFormaPago());
        rhRol.setRolAportePatronal(rhRolAux.getRolAportePatronal());
        rhRol.setRolIece(rhRolAux.getRolIece());
        rhRol.setRolSecap(rhRolAux.getRolSecap());
        rhRol.setRolXiii(rhRolAux.getRolXiii());
        rhRol.setRolXiv(rhRolAux.getRolXiv());
        rhRol.setRolFondoReserva(rhRolAux.getRolFondoReserva());
        rhRol.setRolVacaciones(rhRolAux.getRolVacaciones());
        rhRol.setRolDesahucio(rhRolAux.getRolDesahucio());
        rhRol.setConProvisionEmpresa(rhRolAux.getConProvisionEmpresa());
        rhRol.setConProvisionPeriodo(rhRolAux.getConProvisionPeriodo());
        rhRol.setConProvisionTipo(rhRolAux.getConProvisionTipo());
        rhRol.setConProvisionNumero(rhRolAux.getConProvisionNumero());
        rhRol.setRolOtrosIngresos(rhRolAux.getRolOtrosIngresos());
        rhRol.setRolOtrosIngresosNd(rhRolAux.getRolOtrosIngresosNd());
        rhRol.setEmpOtrosIngresos(rhRolAux.getEmpOtrosIngresos());
        rhRol.setEmpOtrosIngresosNd(rhRolAux.getEmpOtrosIngresosNd());
        return rhRol;
    }
    
    public static RhRol convertirRhRolBDTO_RhRol(rrhh.TO.RhRolBDTO rhRolTO) throws Exception {
        RhRol rhRol = new RhRol();
        rhRol.setRolSecuencial(rhRolTO.getRolSecuencial());
//          rhRol.setConEmpresa(rhRolTO.getEmpCodigo());
//        rhRol.setConPeriodo(rhRolTO.getPerCodigo());
//        rhRol.setConTipo(rhRolTO.getTipCodigo());
//        rhRol.setConNumero(rhRolTO.getConNumero());
//        rhRol.setSecEmpresa(rhRolTO.getEmpCodigo());
        rhRol.setSecCodigo(rhRolTO.getSecCodigo());
        rhRol.setRolReversado(rhRolTO.getRolReversado());
//        rhRol.setRhEmpleado(new RhEmpleado(
//                rhRolTO.getEmpCodigo(),
//                rhRolTO.getEmpId()));
        rhRol.setEmpCargo(rhRolTO.getEmpCargo());
        rhRol.setRolFechaUltimoSueldo(Validacion.fecha(rhRolTO.getRolFechaUltimoSueldo(), "yyyy-MM-dd"));
        rhRol.setRolDesde(Validacion.fecha(rhRolTO.getRolDesde(), "yyyy-MM-dd"));
        rhRol.setRolHasta(Validacion.fecha(rhRolTO.getRolHasta(), "yyyy-MM-dd"));
        rhRol.setRolDiasLaboradosReales(Short.valueOf(String.valueOf(rhRolTO.getRolDiasLaboradosReales())));
        rhRol.setRolDiasFaltasReales(Short.valueOf(String.valueOf(rhRolTO.getRolDiasFaltasReales())));
        rhRol.setRolDiasExtrasReales(Short.valueOf(String.valueOf(rhRolTO.getRolDiasExtrasReales())));
        rhRol.setRolDiasDescansoReales(Short.valueOf(String.valueOf(rhRolTO.getRolDiasDescansoReales())));
        rhRol.setRolDiasPagadosReales(Short.valueOf(String.valueOf(rhRolTO.getRolDiasPagadosReales())));
        rhRol.setRolDiasPermisoMedico(Short.valueOf(String.valueOf(rhRolTO.getRolDiasPermisoMedico())));
        rhRol.setEmpSueldo(rhRolTO.getEmpSueldo());
        rhRol.setEmpDiasLaborados(Short.valueOf(String.valueOf(rhRolTO.getEmpDiasLaborados())));
        rhRol.setEmpDiasDescanso(Short.valueOf(String.valueOf(rhRolTO.getEmpDiasDescanso())));
        rhRol.setEmpCancelarXiiiSueldoMensualmente(rhRolTO.getEmpCancelarXiiiSueldoMensualmente());
        rhRol.setEmpCancelarXivSueldoMensualmente(rhRolTO.getEmpCancelarXivSueldoMensualmente());
        rhRol.setEmpCancelarFondoReservaMensualmente(rhRolTO.getEmpCancelarFondoReservaMensualmente());
        rhRol.setRolSaldoAnterior(rhRolTO.getRolSaldoAnterior());
        rhRol.setRolIngresos(rhRolTO.getRolIngresos());
        rhRol.setRolBonos(rhRolTO.getRolBonos());
        rhRol.setRolBonosnd(rhRolTO.getRolBonosnd());
        rhRol.setRolBonoFijo(rhRolTO.getRolBonoFijo());
        rhRol.setRolBonoFijoNd(rhRolTO.getRolBonoFijoNd());
        rhRol.setEmpBonoFijo(rhRolTO.getEmpBonoFijo());
        rhRol.setEmpBonoFijoNd(rhRolTO.getEmpBonoFijoNd());
        rhRol.setRolViaticos(rhRolTO.getRolViaticos());
        rhRol.setRolLiqFondoReserva(rhRolTO.getRolLiqFondoReserva());
        rhRol.setRolLiqXiii(rhRolTO.getRolLiqXiii());
        rhRol.setRolLiqXiv(rhRolTO.getRolLiqXiv());
        rhRol.setRolLiqVacaciones(rhRolTO.getRolLiqVacaciones());
        rhRol.setRolLiqSalarioDigno(rhRolTO.getRolLiqSalarioDigno());
        rhRol.setRolLiqDesahucio(rhRolTO.getRolLiqDesahucio());
        rhRol.setRolLiqDesahucioIntempestivo(rhRolTO.getRolLiqDesahucioIntempestivo());
        rhRol.setRolLiqBonificacion(rhRolTO.getRolLiqBonificacion());
        rhRol.setRolAnticipos(rhRolTO.getRolAnticipos());
        rhRol.setRolPrestamos(rhRolTO.getRolPrestamos());
        rhRol.setRolIess(rhRolTO.getRolIess());
        rhRol.setRolRetencionFuente(rhRolTO.getRolRetencionFuente());
        rhRol.setRolDescuentoPermisoMedico(rhRolTO.getRolDescuentoPermisoMedico());
        rhRol.setRolTotal(rhRolTO.getRolTotal());
        rhRol.setRolFormaPago(rhRolTO.getRolFormaPago());
        rhRol.setRolAportePatronal(rhRolTO.getRolAportePatronal());
        rhRol.setRolIece(rhRolTO.getRolIece());
        rhRol.setRolSecap(rhRolTO.getRolSecap());
        rhRol.setRolXiii(rhRolTO.getRolXiii());
        rhRol.setRolXiv(rhRolTO.getRolXiv());
        rhRol.setRolFondoReserva(rhRolTO.getRolFondoReserva());
        rhRol.setRolVacaciones(rhRolTO.getRolVacaciones());
        rhRol.setRolDesahucio(rhRolTO.getRolDesahucio());
//        rhRol.setConProvisionEmpresa(rhRolTO.getConProvisionEmpresa());
        rhRol.setConProvisionPeriodo(rhRolTO.getConProvisionPeriodo());
        rhRol.setConProvisionTipo(rhRolTO.getConProvisionTipo());
        rhRol.setConProvisionNumero(rhRolTO.getConProvisionNumero());
        rhRol.setRolOtrosIngresos(rhRolTO.getRolOtrosIngresos());
        rhRol.setRolOtrosIngresosNd(rhRolTO.getRolOtrosIngresosNd());
        rhRol.setEmpOtrosIngresos(rhRolTO.getEmpOtrosIngresos());
        rhRol.setEmpOtrosIngresosNd(rhRolTO.getEmpOtrosIngresosNd());
        return rhRol;
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ANULACIONES">
    public static List<RhAnulacionesTO> convertirRhAnulaciones_RhAnulacionesTO(List datos) {
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
            Boolean dato11;
            try {
                dato11 = Boolean.valueOf(array[10].toString());
            } catch (Exception e) {
                dato11 = false;
            }
            lista.add(new RhAnulacionesTO(dato1, dato2, dato3,
                    dato4, dato5, dato6, dato7, dato8, dato9,
                    dato10, dato11));
        }
        return lista;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DETALLES">
    public static List<RhListaDetalleAnticiposTO> convertirRhDetalleAnticipos_DetalleAnticiposTO(List datos) {
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
            BigDecimal dato5;
            try {
                dato5 = new BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
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
            String dato9;
            try {
                dato9 = array[8].toString();
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
            lista.add(new RhListaDetalleAnticiposTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11));
        }
        return lista;
    }
    
    public static List<RhListaDetalleAnticiposLoteTO> convertirRhListaDetalleAnticiposLote_RhListaDetalleAnticiposLoteTO(List datos) {
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
            lista.add(new RhListaDetalleAnticiposLoteTO(dato1, dato2, dato3,
                    dato4, dato5, dato6, dato7));
        }
        return lista;
    }
    
    public static List<RhListaDetalleBonosLoteTO> convertirRhListaDetalleBonosLote_RhListaDetalleBonosLoteTO(List datos) {
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
            lista.add(new RhListaDetalleBonosLoteTO(dato1, dato2, dato3,
                    dato4, dato5, dato6, dato7));
        }
        return lista;
    }
    
    public static List<RhListaDetalleAnticiposPrestamosTO> convertirRhDetalleAnticiposPrestamos_DetalleAnticiposPrestamosTO(List datos) {
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
            Boolean dato7;
            try {
                dato7 = Boolean.valueOf(array[6].toString());
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
            Boolean dato11;
            try {
                dato11 = Boolean.valueOf(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            lista.add(new RhListaDetalleAnticiposPrestamosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12));
        }
        return lista;
    }
    
    public static List<RhListaDetallePrestamosTO> convertirRhDetallePrestamos_DetallePrestamosTO(List datos) {
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
            BigDecimal dato5;
            try {
                dato5 = new BigDecimal(array[4].toString());
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
            lista.add(new RhListaDetallePrestamosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9));
        }
        return lista;
    }
    
    public static List<RhListaDetalleBonosTO> convertirRhDetalleBonos_DetalleBonosTO(List datos) {
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
            lista.add(new RhListaDetalleBonosTO(
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
                    dato13));
        }
        return lista;
    }
    
    public static List<RhListaDetalleViaticosTO> convertirRhDetalleViaticos_DetalleViaticosTO(List datos) {
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
            BigDecimal dato5;
            try {
                dato5 = new BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
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
            Boolean dato8;
            try {
                dato8 = Boolean.valueOf(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            lista.add(new RhListaDetalleViaticosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9));
        }
        return lista;
    }
    
    public static List<RhListaDetalleRolesTO> convertirRhDetalleRoles_DetalleRolesTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String dato1 = obtenerDatoString(array[0]);
            String dato2 = obtenerDatoString(array[1]);
            String dato3 = obtenerDatoString(array[2]);
            String dato4 = obtenerDatoString(array[3]);
            String dato5 = obtenerDatoString(array[4]);
            BigDecimal dato6 = obtenerDatoBigDecimal(array[5]);
            Integer dato7 = obtenerDatoInteger(array[6]);
            Integer dato8 = obtenerDatoInteger(array[7]);
            Integer dato9 = obtenerDatoInteger(array[8]);
            Integer dato10 = obtenerDatoInteger(array[9]);
            Integer dato11 = obtenerDatoInteger(array[10]);
            Integer dato12 = obtenerDatoInteger(array[11]);
            BigDecimal dato13 = obtenerDatoBigDecimal(array[12]);
            BigDecimal dato14 = obtenerDatoBigDecimal(array[13]);
            BigDecimal dato15 = obtenerDatoBigDecimal(array[14]);
            BigDecimal dato16 = obtenerDatoBigDecimal(array[15]);
            BigDecimal dato17 = obtenerDatoBigDecimal(array[16]);
            BigDecimal dato18 = obtenerDatoBigDecimal(array[17]);
            BigDecimal dato19 = obtenerDatoBigDecimal(array[18]);
            BigDecimal dato20 = obtenerDatoBigDecimal(array[19]);
            BigDecimal dato21 = obtenerDatoBigDecimal(array[20]);
            BigDecimal dato22 = obtenerDatoBigDecimal(array[21]);
            Boolean dato23 = Boolean.parseBoolean(obtenerDatoString(array[22]) == null ? "False" : obtenerDatoString(array[22]));
            BigDecimal dato24 = obtenerDatoBigDecimal(array[23]);
            BigDecimal dato25 = obtenerDatoBigDecimal(array[24]);
            BigDecimal dato26 = obtenerDatoBigDecimal(array[25]);
            BigDecimal dato27 = obtenerDatoBigDecimal(array[26]);
            BigDecimal dato28 = obtenerDatoBigDecimal(array[27]);
            BigDecimal dato29 = obtenerDatoBigDecimal(array[28]);
            BigDecimal dato30 = obtenerDatoBigDecimal(array[29]);
            BigDecimal dato31 = obtenerDatoBigDecimal(array[30]);
            BigDecimal dato32 = obtenerDatoBigDecimal(array[31]);
            BigDecimal dato33 = obtenerDatoBigDecimal(array[32]);
            BigDecimal dato34 = obtenerDatoBigDecimal(array[33]);
            BigDecimal dato35 = obtenerDatoBigDecimal(array[34]);
            BigDecimal dato36 = obtenerDatoBigDecimal(array[35]);
            BigDecimal dato37 = obtenerDatoBigDecimal(array[36]);
            BigDecimal dato38 = obtenerDatoBigDecimal(array[37]);
            BigDecimal dato39 = obtenerDatoBigDecimal(array[38]);
            String dato40 = obtenerDatoString(array[39]);
            String dato41 = obtenerDatoString(array[40]);
            String dato42 = obtenerDatoString(array[41]);
            String dato43 = obtenerDatoString(array[42]);
            String dato44 = obtenerDatoString(array[43]);
            
            lista.add(new RhListaDetalleRolesTO(dato1, dato2, dato3, dato4, dato5,
                    dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13,
                    dato14, dato15, dato16, dato17, dato18, dato19, dato20, dato21,
                    dato22, dato23, dato24, dato25, dato26, dato27, dato28, dato29,
                    dato30, dato31, dato32, dato33, dato34, dato35, dato36, dato37,
                    dato38, dato39, dato40, dato41, dato42, dato43, dato44));
        }
        return lista;
    }
    
    public static List<RhDetalleVacionesPagadasGozadasTO> convertirRhDetalleVacionesPagadasGozadas_DetalleVacionesPagadasGozadasTO(List datos) {
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
            
            lista.add(new RhDetalleVacionesPagadasGozadasTO(dato1, dato2, dato3, dato4, dato5,
                    dato6, dato7, dato8, dato9));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONSOLIDADOS">
    public static List<RhListaConsolidadoAnticiposPrestamosTO> convertirRhConsolidadoAnticiposPrestamos_ConsolidadoAnticiposPrestamosTO(List datos) {
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
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new RhListaConsolidadoAnticiposPrestamosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }
    
    public static List<RhListaConsolidadoBonosViaticosTO> convertirRhConsolidadoBonosViaticos_ConsolidadoBonosViaticosTO(List datos) {
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
                dato9 = new BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            lista.add(new RhListaConsolidadoBonosViaticosTO(dato1, dato2, dato3,
                    dato4, dato5, dato6, dato7, dato8, dato9, dato10));
        }
        return lista;
    }
    
    public static List<RhListaConsolidadoRolesTO> convertirRhConsolidadoRoles_ConsolidadoRolesTO(List datos) {
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
            BigDecimal dato11;
            try {
                dato11 = new BigDecimal(array[10].toString());
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
            BigDecimal dato16;
            try {
                dato16 = new BigDecimal(array[15].toString());
            } catch (Exception e) {
                dato16 = null;
            }
            BigDecimal dato17;
            try {
                dato17 = new BigDecimal(array[16].toString());
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
            BigDecimal dato27;
            try {
                dato27 = new BigDecimal(array[26].toString());
            } catch (Exception e) {
                dato27 = null;
            }
            BigDecimal dato28;
            try {
                dato28 = new BigDecimal(array[27].toString());
            } catch (Exception e) {
                dato28 = null;
            }
            lista.add(new RhListaConsolidadoRolesTO(dato1, dato2, dato3, dato4, dato5,
                    dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13,
                    dato14, dato15, dato16, dato17, dato18, dato19, dato20, dato21,
                    dato22, dato23, dato24, dato25, dato26, dato27, dato28));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SALDOS CONSOLIDADOS">
    public static List<RhListaSaldoConsolidadoAnticiposPrestamosTO> convertirRhSaldoConsolidadoAnticiposPrestamos_SaldoConsolidadoAnticiposPrestamosTO(List datos) {
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
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new RhListaSaldoConsolidadoAnticiposPrestamosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }
    
    public static List<RhListaSaldoConsolidadoBonosViaticosTO> convertirRhSaldoConsolidadoBonosViaticos_SaldoConsolidadoBonosViaticosTO(List datos) {
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
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new RhListaSaldoConsolidadoBonosViaticosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }
    
    public static List<RhListaSaldoConsolidadoSueldosPorPagarTO> convertirRhSaldoConsolidadoSueldosPorPagar_SaldoConsolidadoSueldosPorPagarTO(List datos) {
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
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new RhListaSaldoConsolidadoSueldosPorPagarTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }
    
    public static List<RhListaSaldoIndividualAnticiposPrestamosTO> convertirRhSaldoIndividualAnticiposPrestamos_SaldoIndividualAnticiposPrestamosTO(List datos) {
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
            lista.add(new RhListaSaldoIndividualAnticiposPrestamosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PROVISIONES">
    public static List<RhListaProvisionesTO> convertirRhListaProvisiones_RhListaProvisionesTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String provCategoria;
            try {
                provCategoria = array[0].toString();
            } catch (Exception e) {
                provCategoria = null;
            }
            String provId;
            try {
                provId = array[1].toString();
            } catch (Exception e) {
                provId = null;
            }
            String provNombres;
            try {
                provNombres = array[2].toString();
            } catch (Exception e) {
                provNombres = null;
            }
            BigDecimal provSueldo;
            try {
                provSueldo = new BigDecimal(array[3].toString());
            } catch (Exception e) {
                provSueldo = null;
            }
            BigDecimal provDiasPagados;
            try {
                provDiasPagados = new BigDecimal(array[4].toString());
            } catch (Exception e) {
                provDiasPagados = null;
            }
            BigDecimal provAporteIndividual;
            try {
                provAporteIndividual = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                provAporteIndividual = null;
            }
            BigDecimal provAportePatronal;
            try {
                provAportePatronal = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                provAportePatronal = null;
            }
            BigDecimal provIece;
            try {
                provIece = new BigDecimal(array[7].toString());
            } catch (Exception e) {
                provIece = null;
            }
            BigDecimal provSecap;
            try {
                provSecap = new BigDecimal(array[8].toString());
            } catch (Exception e) {
                provSecap = null;
            }
            BigDecimal provXiii;
            try {
                provXiii = new BigDecimal(array[9].toString());
            } catch (Exception e) {
                provXiii = null;
            }
            BigDecimal provXiv;
            try {
                provXiv = new BigDecimal(array[10].toString());
            } catch (Exception e) {
                provXiv = null;
            }
            BigDecimal provFondoReserva;
            try {
                provFondoReserva = new BigDecimal(array[11].toString());
            } catch (Exception e) {
                provFondoReserva = null;
            }
            BigDecimal provVacaciones;
            try {
                provVacaciones = new BigDecimal(array[12].toString());
            } catch (Exception e) {
                provVacaciones = null;
            }
            BigDecimal provDesahucio;
            try {
                provDesahucio = new BigDecimal(array[13].toString());
            } catch (Exception e) {
                provDesahucio = null;
            }
            Integer provSecuencial;
            try {
                provSecuencial = Integer.valueOf(array[14].toString());
            } catch (Exception e) {
                provSecuencial = null;
            }
            String provContableRol;
            try {
                provContableRol = array[15].toString();
            } catch (Exception e) {
                provContableRol = null;
            }
            String provContableProvision;
            try {
                provContableProvision = array[16].toString();
            } catch (Exception e) {
                provContableProvision = null;
            }
            lista.add(new RhListaProvisionesTO(
                    provCategoria,
                    provId,
                    provNombres,
                    provSueldo,
                    provDiasPagados,
                    provAporteIndividual,
                    provAportePatronal,
                    provIece,
                    provSecap,
                    provXiii,
                    provXiv,
                    provFondoReserva,
                    provVacaciones,
                    provDesahucio,
                    provSecuencial,
                    provContableRol,
                    provContableProvision));
        }
        return lista;
    }
    
    public static RhCategoriaProvisionesTO convertirRhCategoriaProvisionesTO_RhCategoriaProvisionesTO(List datos) {
        RhCategoriaProvisionesTO rhCategoriaProvisionesTO = new RhCategoriaProvisionesTO();
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
            rhCategoriaProvisionesTO.setCtaAportepatronal(dato1);
            rhCategoriaProvisionesTO.setCtaIece(dato2);
            rhCategoriaProvisionesTO.setCtaSecap(dato3);
            rhCategoriaProvisionesTO.setCtaXiii(dato4);
            rhCategoriaProvisionesTO.setCtaXiv(dato5);
            rhCategoriaProvisionesTO.setCtaFondoreserva(dato6);
            rhCategoriaProvisionesTO.setCtaVacaciones(dato7);
            rhCategoriaProvisionesTO.setCtaDesahucio(dato8);
            rhCategoriaProvisionesTO.setCtaGastoAportepatronal(dato9);
            rhCategoriaProvisionesTO.setCtaGastoIece(dato10);
            rhCategoriaProvisionesTO.setCtaGastoSecap(dato11);
            rhCategoriaProvisionesTO.setCtaGastoXiii(dato12);
            rhCategoriaProvisionesTO.setCtaGastoXiv(dato13);
            rhCategoriaProvisionesTO.setCtaGastoFondoreserva(dato14);
            rhCategoriaProvisionesTO.setCtaGastoVacaciones(dato15);
            rhCategoriaProvisionesTO.setCtaGastoDesahucio(dato16);
        }
        return rhCategoriaProvisionesTO;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PARAMETROS">
    public static RhParametrosTO convertirRhParametros_RhParametrosTO(List datos) {
        RhParametrosTO rhParametrosTO = new RhParametrosTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            BigDecimal dato1;
            try {
                dato1 = new BigDecimal(array[0].toString());
            } catch (Exception e) {
//                dato1 = null;
                dato1 = BigDecimal.ZERO;
            }
            BigDecimal dato2;
            try {
                dato2 = new BigDecimal(array[1].toString());
            } catch (Exception e) {
//                dato2 = null;
                dato2 = BigDecimal.ZERO;
            }
            BigDecimal dato3;
            try {
                dato3 = new BigDecimal(array[2].toString());
            } catch (Exception e) {
//                dato3 = null;
                dato3 = BigDecimal.ZERO;
            }
            BigDecimal dato4;
            try {
                dato4 = new BigDecimal(array[3].toString());
            } catch (Exception e) {
//                dato4 = null;
                dato4 = BigDecimal.ZERO;
            }
            BigDecimal dato5;
            try {
                dato5 = new BigDecimal(array[4].toString());
            } catch (Exception e) {
//                dato5 = null;
                dato5 = BigDecimal.ZERO;
            }
            BigDecimal dato6;
            try {
                dato6 = new BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = BigDecimal.ZERO;
            }
            rhParametrosTO.setParIessPorcentajeAporteIndividual(dato1);
            rhParametrosTO.setParIessPorcentajeAporteExtendido(dato6);
            rhParametrosTO.setParIessPorcentajeAportePatronal(dato2);
            rhParametrosTO.setParIessPorcentajeIece(dato3);
            rhParametrosTO.setParIessPorcentajeSecap(dato4);
            rhParametrosTO.setParSalarioMinimoVital(dato5);
        }
        return rhParametrosTO;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="XIII">
    public static RhXiiiSueldoPeriodoTO convertirRhXIIISueldoPeriodo_RhXIIISueldoPeriodoTO(List datos) {
        RhXiiiSueldoPeriodoTO rhComboXIIISueldoPeriodoTO = null;
        if (!datos.isEmpty()) {
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
                Integer dato5;
                try {
                    dato5 = Integer.valueOf(array[4].toString());
                } catch (Exception e) {
                    dato5 = null;
                }
                rhComboXIIISueldoPeriodoTO = new RhXiiiSueldoPeriodoTO(dato1, dato2, dato3, dato4, dato5);
            }
        }
        return rhComboXIIISueldoPeriodoTO;
    }
    
    public static List<RhXiiiSueldoPeriodoTO> convertirRhXiiiSueldoPeriodo_RhXiiiSueldoPeriodoTO(List datos) {
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
            Integer dato5;
            try {
                dato5 = Integer.valueOf(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new RhXiiiSueldoPeriodoTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }
    
    public static List<RhFunXiiiSueldoCalcularTO> convertirRhFunCalcularXiiiSueldo_RhFunCalcularXiiiSueldoTO(List datos) {
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
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            Integer dato8;
            try {
                dato8 = Integer.valueOf(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            BigDecimal dato9;
            try {
                dato9 = new BigDecimal(array[8].toString());
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
            lista.add(new RhFunXiiiSueldoCalcularTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12));
        }
        return lista;
    }
    
    public static List<RhFunXiiiSueldoConsultarTO> convertirRhFunConsultarXiiiSueldo_RhFunConsultarXiiiSueldoTO(List datos) {
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
            Character dato6;
            try {
                dato6 = array[5].toString().charAt(0);
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
                dato9 = null;
            }
            Short dato10;
            try {
                dato10 = new Short(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            BigDecimal dato11;
            try {
                dato11 = new BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            Character dato12;
            try {
                dato12 = array[11].toString().charAt(0);
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
            lista.add(new RhFunXiiiSueldoConsultarTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12,
                    dato13, dato14, dato15));
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="XIV">
    public static RhXivSueldoPeriodoTO convertirRhXivSueldoPeriodo_RhXivSueldoPeriodoTO(List datos) {
        RhXivSueldoPeriodoTO rhComboXivSueldoPeriodoTO = null;
        if (!datos.isEmpty()) {
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
                Integer dato5;
                try {
                    dato5 = Integer.valueOf(array[4].toString());
                } catch (Exception e) {
                    dato5 = null;
                }
                rhComboXivSueldoPeriodoTO = new RhXivSueldoPeriodoTO(dato1, dato2, dato3, dato4, dato5);
            }
        }
        return rhComboXivSueldoPeriodoTO;
    }
    
    public static RhUtilidadesPeriodoTO convertirRHUtilidadesPeriodo_RHUtilidadesPeriodoTO(List datos) {
        RhUtilidadesPeriodoTO rhComboUtilidadesPeriodoTO = null;
        if (!datos.isEmpty()) {
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
                Integer dato5;
                try {
                    dato5 = Integer.valueOf(array[4].toString());
                } catch (Exception e) {
                    dato5 = null;
                }
                Integer dato6;
                try {
                    dato6 = Integer.valueOf(array[5].toString());
                } catch (Exception e) {
                    dato6 = null;
                }
                BigDecimal dato7;
                try {
                    dato7 = new BigDecimal(array[6].toString());
                } catch (Exception e) {
                    dato7 = null;
                }
                rhComboUtilidadesPeriodoTO = new RhUtilidadesPeriodoTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7);
            }
        }
        return rhComboUtilidadesPeriodoTO;
    }
    
    public static rrhh.entity.RhUtilidadesPeriodo convertirRhUtilidadesPeriodoTO_RhUtilidadesPeriodo(rrhh.TO.RhUtilidadesPeriodoTO rhUtilidadesPeriodoTO) {
        rrhh.entity.RhUtilidadesPeriodo rhUtilidadesPeriodo = new rrhh.entity.RhUtilidadesPeriodo();
        rhUtilidadesPeriodo.setRhUtilidadesPeriodoPK(
                new rrhh.entity.RhUtilidadesPeriodoPK(
                rhUtilidadesPeriodoTO.getUtiEmpresa(),
                rhUtilidadesPeriodoTO.getUtiDescripcion()));
        rhUtilidadesPeriodo.setUtiDesde(validaciones.Validacion.fecha(rhUtilidadesPeriodoTO.getUtiDesde(), "yyyy-MM-dd"));
        rhUtilidadesPeriodo.setUtiHasta(validaciones.Validacion.fecha(rhUtilidadesPeriodoTO.getUtiHasta(), "yyyy-MM-dd"));
        rhUtilidadesPeriodo.setUtiFechaMaximaPago(validaciones.Validacion.fecha(rhUtilidadesPeriodoTO.getUtiFechaMaximaPago(), "yyyy-MM-dd"));
        rhUtilidadesPeriodo.setUtiTotalDias(new Long(rhUtilidadesPeriodoTO.getUtiTotalDias()));
        rhUtilidadesPeriodo.setUtiTotalCargas(new Long(rhUtilidadesPeriodoTO.getUtiTotalCargas()));
        rhUtilidadesPeriodo.setUtiTotalPagar(rhUtilidadesPeriodoTO.getUtiTotalPagar());
        return rhUtilidadesPeriodo;
    }
    
    public static List<RhXivSueldoPeriodoTO> convertirRhXIVSueldoPeriodo_RhXIVSueldoPeriodoTO(List datos) {
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
            Integer dato5;
            try {
                dato5 = Integer.valueOf(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new RhXivSueldoPeriodoTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }
    
    public static List<RhUtilidadesPeriodoTO> convertirRhUtilidadesPeriodo_RhUtilidadesPeriodoTO(List datos) {
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
            Integer dato5;
            try {
                dato5 = Integer.valueOf(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            Integer dato6;
            try {
                dato6 = Integer.valueOf(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new RhUtilidadesPeriodoTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }
    
    public static List<RhFunUtilidadesCalcularTO> convertirRhFunCalculartUilidades_RhFunCalcularUtilidadesTO(List datos) {
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
            Integer dato8;
            try {
                dato8 = Integer.valueOf(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            Integer dato9;
            try {
                dato9 = Integer.valueOf(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            BigDecimal dato10;
            try {
                dato10 = new BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            BigDecimal dato11;
            try {
                dato11 = new BigDecimal(array[10].toString());
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
            BigDecimal dato16;
            try {
                dato16 = new BigDecimal(array[15].toString());
            } catch (Exception e) {
                dato16 = null;
            }
            BigDecimal dato17;
            try {
                dato17 = new BigDecimal(array[16].toString());
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
            String dato23;
            try {
                dato23 = array[22].toString();
            } catch (Exception e) {
                dato23 = null;
            }
            
            lista.add(new RhFunUtilidadesCalcularTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18, dato19, dato20, dato21, dato22, dato23));
        }
        return lista;
    }
    
    public static List<RhFunXivSueldoCalcularTO> convertirRhFunCalcularXivSueldo_RhFunCalcularXivSueldoTO(List datos) {
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
            BigDecimal dato7;
            try {
                dato7 = new BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            Integer dato8;
            try {
                dato8 = Integer.valueOf(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            BigDecimal dato9;
            try {
                dato9 = new BigDecimal(array[8].toString());
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
            lista.add(new RhFunXivSueldoCalcularTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12));
        }
        return lista;
    }
    
    public static List<RhFunXivSueldoConsultarTO> convertirRhFunConsultarXivSueldo_RhFunConsultarXivSueldoTO(List datos) {
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
            Character dato6;
            try {
                dato6 = array[5].toString().charAt(0);
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
                dato9 = null;
            }
            Short dato10;
            try {
                dato10 = new Short(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            BigDecimal dato11;
            try {
                dato11 = new BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            Character dato12;
            try {
                dato12 = array[11].toString().charAt(0);
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
            lista.add(new RhFunXivSueldoConsultarTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12,
                    dato13, dato14, dato15));
        }
        return lista;
    }
    
    public static List<RhFunUtilidadesConsultarTO> convertirRhFunConsultarUtilidades_RhFunConsultarUtilidadesTO(List datos) {
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
            Character dato6;
            try {
                dato6 = array[5].toString().charAt(0);
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
                dato9 = null;
            }
            Short dato10;
            try {
                dato10 = new Short(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            BigDecimal dato11;
            try {
                dato11 = new BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            Character dato12;
            try {
                dato12 = array[11].toString().charAt(0);
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
            lista.add(new RhFunUtilidadesConsultarTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12,
                    dato13, dato14, dato15));
        }
        return lista;
    }
    // </editor-fold>

    public static rrhh.TO.RhFormulario107TO convertirRhFormulario107_RhFormulario107TO(List datos) {
        rrhh.TO.RhFormulario107TO rhFormulario107TO = null;
        if (!datos.isEmpty()) {
            for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
                Object obj = i$.next();
                Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
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
                Character dato9;
                try {
                    dato9 = array[8].toString().charAt(0);
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
                java.math.BigDecimal dato21;
                try {
                    dato21 = new java.math.BigDecimal(array[20].toString());
                } catch (Exception e) {
                    dato21 = null;
                }
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
                java.math.BigDecimal dato29;
                try {
                    dato29 = new java.math.BigDecimal(array[28].toString());
                } catch (Exception e) {
                    dato29 = null;
                }
                java.math.BigDecimal dato30;
                try {
                    dato30 = new java.math.BigDecimal(array[29].toString());
                } catch (Exception e) {
                    dato30 = null;
                }
                java.math.BigDecimal dato31;
                try {
                    dato31 = new java.math.BigDecimal(array[30].toString());
                } catch (Exception e) {
                    dato31 = null;
                }
                java.math.BigDecimal dato32;
                try {
                    dato32 = new java.math.BigDecimal(array[31].toString());
                } catch (Exception e) {
                    dato32 = null;
                }
                java.math.BigDecimal dato33;
                try {
                    dato33 = new java.math.BigDecimal(array[32].toString());
                } catch (Exception e) {
                    dato33 = null;
                }
                java.math.BigDecimal dato34;
                try {
                    dato34 = new java.math.BigDecimal(array[33].toString());
                } catch (Exception e) {
                    dato34 = null;
                }
                Short dato35;
                try {
                    dato35 = Short.parseShort(array[34].toString());
                } catch (Exception e) {
                    dato35 = null;
                }
                java.math.BigDecimal dato36;
                try {
                    dato36 = new java.math.BigDecimal(array[35].toString());
                } catch (Exception e) {
                    dato36 = null;
                }
                String dato37;
                try {
                    dato37 = array[36].toString();
                } catch (Exception e) {
                    dato37 = null;
                }
                rhFormulario107TO = new rrhh.TO.RhFormulario107TO(null, null, dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10,
                        dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18, dato19, dato20, dato21, dato22, dato23, dato24,
                        dato25, dato26, dato27, dato28, dato29, dato30, dato31, dato32, dato33, dato34, dato35, dato36, dato37, null, null, null);
            }
        }
        return rhFormulario107TO;
    }
    
    public static rrhh.TO.RhFormulario107PeriodoFiscalTO convertirRhFormulario107PeriodoFiscal_RhFormulario107PeriodoFiscalTO(List datos) {
        rrhh.TO.RhFormulario107PeriodoFiscalTO rhFormulario107PeriodoFiscalTO = null;
        if (!datos.isEmpty()) {
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
                rhFormulario107PeriodoFiscalTO = new rrhh.TO.RhFormulario107PeriodoFiscalTO(dato1, dato2, dato3, dato4);
            }
        }
        return rhFormulario107PeriodoFiscalTO;
    }
    
    public static List<rrhh.TO.RhFormulario107PeriodoFiscalTO> convertirRhFormulario107PeriodoFiscalCombo_RhFormulario107PeriodoFiscalComboTO(List datos) {
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
            lista.add(new rrhh.TO.RhFormulario107PeriodoFiscalTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }
    
    public static rrhh.TO.RhFormulario107TO convertirRhFormulario107_RhFormulario107TO(rrhh.entity.RhFormulario107 rhFormulario107) throws Exception {
        rrhh.TO.RhFormulario107TO rhFormulario107TO;
        if (rhFormulario107 != null) {
            rhFormulario107TO = new rrhh.TO.RhFormulario107TO();
            rhFormulario107TO.setF107Empresa(rhFormulario107.getRhFormulario107PK().getF107Empresa());
            rhFormulario107TO.setF107Anio(rhFormulario107.getRhFormulario107PK().getF107Anio());
            rhFormulario107TO.setF107Tipo(rhFormulario107.getF107Tipo());
            rhFormulario107TO.setF107Id(rhFormulario107.getRhFormulario107PK().getF107Id());
            rhFormulario107TO.setF107Nombres(rhFormulario107.getF107Nombres());
            rhFormulario107TO.setF107Direccion(rhFormulario107.getF107Direccion());
            rhFormulario107TO.setF107Numero(rhFormulario107.getF107Direccion());
            rhFormulario107TO.setF107Canton(rhFormulario107.getF107Canton());
            rhFormulario107TO.setF107Provincia(rhFormulario107.getF107Provincia());
            rhFormulario107TO.setF107Telefono(rhFormulario107.getF107Telefono());
            rhFormulario107TO.setF107SalarioNeto(rhFormulario107.getF107SalarioNeto());
            rhFormulario107TO.setF107Sueldo(rhFormulario107.getF107Sueldo());
            rhFormulario107TO.setF107Bonos(rhFormulario107.getF107Bonos());
            rhFormulario107TO.setF107XiiiSueldo(rhFormulario107.getF107XiiiSueldo());
            rhFormulario107TO.setF107XivSueldo(rhFormulario107.getF107XivSueldo());
            rhFormulario107TO.setF107FondoReserva(rhFormulario107.getF107FondoReserva());
            rhFormulario107TO.setF107SalarioDigno(rhFormulario107.getF107SalarioDigno());
            rhFormulario107TO.setF107Utilidades(rhFormulario107.getF107Utilidades());
            rhFormulario107TO.setF107Desahucio(rhFormulario107.getF107Desahucio());
            rhFormulario107TO.setF107Iess(rhFormulario107.getF107Iess());
            rhFormulario107TO.setF107Vivienda(rhFormulario107.getF107Vivienda());
            rhFormulario107TO.setF107Salud(rhFormulario107.getF107Salud());
            rhFormulario107TO.setF107Educacion(rhFormulario107.getF107Educacion());
            rhFormulario107TO.setF107Alimentacion(rhFormulario107.getF107Alimentacion());
            rhFormulario107TO.setF107Vestuario(rhFormulario107.getF107Vestuario());
            rhFormulario107TO.setF107RebajaDiscapacitado(rhFormulario107.getF107RebajaDiscapacitado());
            rhFormulario107TO.setF107RebajaTerceraEdad(rhFormulario107.getF107RebajaTerceraEdad());
            rhFormulario107TO.setF107ImpuestoAsumido(rhFormulario107.getF107ImpuestoAsumido());
            rhFormulario107TO.setF107Subtotal(rhFormulario107.getF107Subtotal());
            rhFormulario107TO.setF107MesesTrabajados(rhFormulario107.getF107MesesTrabajados());
            rhFormulario107TO.setF107OtrosIngresos(rhFormulario107.getF107OtrosIngresos());
            rhFormulario107TO.setF107OtrasDeducciones(rhFormulario107.getF107OtrasDeducciones());
            rhFormulario107TO.setF107OtrasRebajas(rhFormulario107.getF107OtrasRebajas());
            rhFormulario107TO.setF107BaseImponible(rhFormulario107.getF107BaseImponible());
            rhFormulario107TO.setF107ImpuestoCausado(rhFormulario107.getF107ImpuestoCausado());
            rhFormulario107TO.setF107ValorRetenido(rhFormulario107.getF107ValorRetenido());
            rhFormulario107TO.setF107NumeroRetenciones(rhFormulario107.getF107NumeroRetenciones());
            rhFormulario107TO.setF107Impuesto(rhFormulario107.getF107Impuesto());
            rhFormulario107TO.setF107AnioConsulta(rhFormulario107.getRhFormulario107PK().getF107Anio());
            rhFormulario107TO.setUsrEmpresa(rhFormulario107.getUsrEmpresa());
            rhFormulario107TO.setUsrCodigo(rhFormulario107.getUsrCodigo());
            rhFormulario107TO.setUsrFechaInserta(validaciones.Validacion.fecha(rhFormulario107.getUsrFechaInserta(), "yyyy-MM-dd"));
        } else {
            rhFormulario107TO = null;
        }
        return rhFormulario107TO;
    }
    
    public static rrhh.entity.RhFormulario107 convertirRhFormulario107TO_RhFormulario107(rrhh.TO.RhFormulario107TO rhFormulario107TO) throws Exception {
        rrhh.entity.RhFormulario107 rhFormulario107;
        
        rhFormulario107 = new rrhh.entity.RhFormulario107();
        
        rhFormulario107.setRhFormulario107PK(new rrhh.entity.RhFormulario107PK(rhFormulario107TO.getF107Empresa(), rhFormulario107TO.getF107Anio(), rhFormulario107TO.getF107Id().trim()));
        
        rhFormulario107.setF107Tipo(rhFormulario107TO.getF107Tipo());
        
        rhFormulario107.setF107Nombres(rhFormulario107TO.getF107Nombres());
        rhFormulario107.setF107Direccion(rhFormulario107TO.getF107Direccion());
//        rhFormulario107.setF107Numero(rhFormulario107TO.getF107Numero());
        rhFormulario107.setF107Canton(rhFormulario107TO.getF107Canton());
        rhFormulario107.setF107Provincia(rhFormulario107TO.getF107Provincia());
        rhFormulario107.setF107Telefono(rhFormulario107TO.getF107Telefono());
        rhFormulario107.setF107SalarioNeto(rhFormulario107TO.getF107SalarioNeto());
        rhFormulario107.setF107Sueldo(rhFormulario107TO.getF107Sueldo());
        rhFormulario107.setF107Bonos(rhFormulario107TO.getF107Bonos());
        rhFormulario107.setF107XiiiSueldo(rhFormulario107TO.getF107XiiiSueldo());
        rhFormulario107.setF107XivSueldo(rhFormulario107TO.getF107XivSueldo());
        rhFormulario107.setF107FondoReserva(rhFormulario107TO.getF107FondoReserva());
        rhFormulario107.setF107SalarioDigno(rhFormulario107TO.getF107SalarioDigno());
        rhFormulario107.setF107Utilidades(rhFormulario107TO.getF107Utilidades());
        rhFormulario107.setF107Desahucio(rhFormulario107TO.getF107Desahucio());
        rhFormulario107.setF107Iess(rhFormulario107TO.getF107Iess());
        rhFormulario107.setF107Vivienda(rhFormulario107TO.getF107Vivienda());
        rhFormulario107.setF107Salud(rhFormulario107TO.getF107Salud());
        rhFormulario107.setF107Educacion(rhFormulario107TO.getF107Educacion());
        rhFormulario107.setF107Alimentacion(rhFormulario107TO.getF107Alimentacion());
        rhFormulario107.setF107Vestuario(rhFormulario107TO.getF107Vestuario());
        rhFormulario107.setF107RebajaDiscapacitado(rhFormulario107TO.getF107RebajaDiscapacitado());
        rhFormulario107.setF107RebajaTerceraEdad(rhFormulario107TO.getF107RebajaTerceraEdad());
        rhFormulario107.setF107ImpuestoAsumido(rhFormulario107TO.getF107ImpuestoAsumido());
        rhFormulario107.setF107Subtotal(rhFormulario107TO.getF107Subtotal());
        rhFormulario107.setF107MesesTrabajados(rhFormulario107TO.getF107MesesTrabajados());
        rhFormulario107.setF107OtrosIngresos(rhFormulario107TO.getF107OtrosIngresos());
        rhFormulario107.setF107OtrasDeducciones(rhFormulario107TO.getF107OtrasDeducciones());
        rhFormulario107.setF107OtrasRebajas(rhFormulario107TO.getF107OtrasRebajas());
        rhFormulario107.setF107BaseImponible(rhFormulario107TO.getF107BaseImponible());
        rhFormulario107.setF107ImpuestoCausado(rhFormulario107TO.getF107ImpuestoCausado());
        rhFormulario107.setF107ValorRetenido(rhFormulario107TO.getF107ValorRetenido());
        rhFormulario107.setF107NumeroRetenciones(rhFormulario107TO.getF107NumeroRetenciones());
        rhFormulario107.setF107Impuesto(rhFormulario107TO.getF107Impuesto());
        rhFormulario107.setUsrEmpresa(rhFormulario107TO.getUsrEmpresa());
        rhFormulario107.setUsrCodigo(rhFormulario107TO.getUsrCodigo());
        rhFormulario107.setUsrFechaInserta(validaciones.Validacion.fecha(rhFormulario107TO.getUsrFechaInserta(), "yyyy-MM-dd"));
        
        return rhFormulario107;
    }
    
    public static List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> convertirRhPreavisoAnticipos_RhPreavisoAnticiposTO(List datos) {
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
            lista.add(new rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO(dato1, dato2, dato3, dato4, dato5, dato6,
                    dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14,
                    dato15, dato16, dato17));
        }
        
        //Esto es para agregar a la ultima fila de la lista la fecha de generacion de archivoPreavisoAnticipo
        //Y no se lo toma en cuenta en la tabla ni en el excel, sino en el label de fecha de generación
        if (lista.size() > 0) {
            
            lista.add(new rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO(
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
                    ""));
        }
        
        return lista;
    }
    
    public static List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoPichinchaTO> convertirRhPreavisoAnticiposPichincha_RhPreavisoAnticiposPichinchaTO(List datos) {
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
            
            lista.add(new rrhh.TO.RhPreavisoAnticiposPrestamosSueldoPichinchaTO(dato1, dato2, dato3, dato4, dato5, dato6,
                    dato7, dato8, dato9, dato10, dato11, dato12, dato13));
        }
        /*
         * if (lista.size() > 0){
         *
         * lista.add(new rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO(
         * validaciones.Validacion.fechaSistema("yyyy"),
         * validaciones.Validacion.fechaSistema("MM"),
         * validaciones.Validacion.fechaSistema("dd"),
         * validaciones.Validacion.fechaSistema("dd-MM-yyyy HH:mm:ss"), "", "",
         * "", "", "", "", "", "", "", "", "", "", "")); }
         */
        
        return lista;
    }
    
    public static List<rrhh.TO.RhFunFormulario107TO> convertirRhFunFormulario107_RhFunFormulario107TO(List datos) {
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
            java.math.BigDecimal dato12;
            try {
                dato12 = new java.math.BigDecimal(array[11].toString());
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
            java.math.BigDecimal dato21;
            try {
                dato21 = new java.math.BigDecimal(array[20].toString());
            } catch (Exception e) {
                dato21 = null;
            }
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
            Boolean dato28;
            try {
                dato28 = Boolean.valueOf(array[27].toString());
            } catch (Exception e) {
                dato28 = null;
            }
            lista.add(new rrhh.TO.RhFunFormulario107TO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8,
                    dato9, dato10, dato11, dato12, dato13, dato14, dato15,
                    dato16, dato17, dato18, dato19, dato20, dato21, dato22,
                    dato23, dato24, dato25, dato26, dato27, dato28));
        }
        return lista;
    }
    
    public static List<rrhh.TO.RhFunFormulario107_2013TO> convertirRhFunFormulario107_2013_RhFunFormulario107_2013TO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String dato1;//private String f107Tipo;//(f107_tipo character(1),
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;//private String f107Id; //f107_id character(10),
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;//private String f107Apellidos;//f107_apellidos character(50),
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;//private String f107Nombres;//f107_nombres       character(50),
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;// private String f107Establecimiento;//f107_establecimiento character(3),
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;// private String f107ResidenciaTipo; //        f107_residencia_tipo character(2),
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;//private String f107ResidenciaPais;//f107_residencia_pais character(3),
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;// private String f107Convenio;//f107_convenio        character(2),
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;// private String f107DiscapacidadTipo;//f107_discapacidad_tipo character(2),
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            java.math.BigDecimal dato10;//private BigDecimal f107DiscapacidadPorcentaje;//f107_discapacidad_porcentaje numeric(3,0),
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            //---------------------------
            String dato11;//private String f107DiscapacidadIdTipo;//f107_discapacidad_id_tipo character(1),
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;//private String f107DiscapacidadIdNumero;//f107_discapacidad_id_numero character(10),
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            java.math.BigDecimal dato13;//private BigDecimal f107Sueldo;//f107_sueldo        numeric(12,2),
            try {
                dato13 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                dato13 = null;
            }
            java.math.BigDecimal dato14;//private BigDecimal f107Bonos;//f107_bonos         numeric(12,2),
            try {
                dato14 = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                dato14 = null;
            }
            java.math.BigDecimal dato15;// private BigDecimal f107Utilidades;//f107_utilidades    numeric(12,2),
            try {
                dato15 = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }
            java.math.BigDecimal dato16;// private BigDecimal f107SueldoOtrosEmpleadores;//f107_sueldo_otros_empleadores numeric(12,2),
            try {
                dato16 = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                dato16 = null;
            }
            java.math.BigDecimal dato17;//  private BigDecimal f107ImpuestoAsumido;//f107_impuesto_asumido     numeric(12,2),
            try {
                dato17 = new java.math.BigDecimal(array[16].toString());
            } catch (Exception e) {
                dato17 = null;
            }
            java.math.BigDecimal dato18;//  private BigDecimal f107XiiiSueldo;//f107_xiii_sueldo   numeric(12,2),
            try {
                dato18 = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                dato18 = null;
            }
            java.math.BigDecimal dato19;// private BigDecimal f107XivSueldo;
            try {
                dato19 = new java.math.BigDecimal(array[18].toString());// private BigDecimal f107XivSueldo;//f107_xiv_sueldo    numeric(12,2),
            } catch (Exception e) {
                dato19 = null;
            }
            java.math.BigDecimal dato20;// private BigDecimal f107FondoReserva;//f107_fondo_reserva numeric(12,2),
            try {
                dato20 = new java.math.BigDecimal(array[19].toString());// private BigDecimal f107XivSueldo;//f107_xiv_sueldo    numeric(12,2),
            } catch (Exception e) {
                dato20 = null;
            }
            ///------------------------------------
            java.math.BigDecimal dato21;//private BigDecimal f107SalarioDigno;//f107_salario_digno numeric(12,2),
            try {
                dato21 = new java.math.BigDecimal(array[20].toString());
            } catch (Exception e) {
                dato21 = null;
            }
            
            java.math.BigDecimal dato22;//private BigDecimal f107Desahucio;       //f107_desahucio     numeric(12,2),
            try {
                dato22 = new java.math.BigDecimal(array[21].toString());
            } catch (Exception e) {
                dato22 = null;
            }
            java.math.BigDecimal dato23;//private BigDecimal f107Subtotal;     // f107_subtotal             numeric(12,2),
            try {
                dato23 = new java.math.BigDecimal(array[22].toString());
            } catch (Exception e) {
                dato23 = null;
            }
            String dato24;//private String f107SalarioNeto;      //f107_salario_neto  character(1),
            try {
                dato24 = array[23].toString();
            } catch (Exception e) {
                dato24 = null;
            }
            java.math.BigDecimal dato25;// private BigDecimal f107Iess;  //f107_iess          numeric(12,2),
            try {
                dato25 = new java.math.BigDecimal(array[24].toString());
            } catch (Exception e) {
                dato25 = null;
            }
            java.math.BigDecimal dato26;// private BigDecimal f107IessOtrosEmpleadores;       //f107_iess_otros_empleadores numeric(12,2),
            try {
                dato26 = new java.math.BigDecimal(array[25].toString());
            } catch (Exception e) {
                dato26 = null;
            }
            java.math.BigDecimal dato27;// private BigDecimal f107Vivienda;      //f107_vivienda      numeric(12,2),
            try {
                dato27 = new java.math.BigDecimal(array[26].toString());
            } catch (Exception e) {
                dato27 = null;
            }
            java.math.BigDecimal dato28;//private BigDecimal f107Salud;   //f107_salud         numeric(12,2),
            try {
                dato28 = new java.math.BigDecimal(array[27].toString());
            } catch (Exception e) {
                dato28 = null;
            }
            java.math.BigDecimal dato29;// private BigDecimal f107Educacion;       //f107_educacion     numeric(12,2),
            try {
                dato29 = new java.math.BigDecimal(array[28].toString());
            } catch (Exception e) {
                dato29 = null;
            }
            java.math.BigDecimal dato30;//private BigDecimal f107Alimentacion;      //f107_alimentacion  numeric(12,2),
            try {
                dato30 = new java.math.BigDecimal(array[29].toString());
            } catch (Exception e) {
                dato30 = null;
            }
            //-------------------------------------------

            java.math.BigDecimal dato31;// private BigDecimal f107Vestuario ;    //f107_vestuario     numeric(12,2),
            try {
                dato31 = new java.math.BigDecimal(array[30].toString());
            } catch (Exception e) {
                dato31 = null;
            }
            java.math.BigDecimal dato32;// private BigDecimal f107RebajaDiscapacitado;       //f107_rebaja_discapacitado numeric(12,2),
            try {
                dato32 = new java.math.BigDecimal(array[31].toString());
            } catch (Exception e) {
                dato32 = null;
            }
            java.math.BigDecimal dato33;// private BigDecimal f107RebajaTerceraEdad;       //f107_rebaja_tercera_edad  numeric(12,2),
            try {
                dato33 = new java.math.BigDecimal(array[32].toString());
            } catch (Exception e) {
                dato33 = null;
            }
            java.math.BigDecimal dato34;// private BigDecimal f107BaseImponible;       //f107_base_imponible       numeric(12,2),
            try {
                dato34 = new java.math.BigDecimal(array[33].toString());
            } catch (Exception e) {
                dato34 = null;
            }
            java.math.BigDecimal dato35;//private BigDecimal f107ImpuestoCausado;       //f107_impuesto_causado     numeric(12,2),
            try {
                dato35 = new java.math.BigDecimal(array[34].toString());
            } catch (Exception e) {
                dato35 = null;
            }
            java.math.BigDecimal dato36;// private BigDecimal f107ImpuestoAsumidoOtrosEmpleadores;//        f107_impuesto_asumido_otros_empleadores numeric(12,2),
            try {
                dato36 = new java.math.BigDecimal(array[35].toString());
            } catch (Exception e) {
                dato36 = null;
            }
            java.math.BigDecimal dato37;//private BigDecimal f107ImpuestoAsumidoEsteEmpleador;     // f107_impuesto_asumido_este_empleador numeric(12,2),
            try {
                dato37 = new java.math.BigDecimal(array[36].toString());
            } catch (Exception e) {
                dato37 = null;
            }
            java.math.BigDecimal dato38;// private BigDecimal f107ValorRetenid;      //f107_valor_retenido       numeric(12,2),
            try {
                dato38 = new java.math.BigDecimal(array[37].toString());
            } catch (Exception e) {
                dato38 = null;
            }
            
            Boolean dato39;//   private Boolean f107EmpleadoInactivo;      //f107_empleado_inactivo   boolean);
            try {
                dato39 = Boolean.valueOf(array[38].toString());
            } catch (Exception e) {
                dato39 = null;
            }
            lista.add(new rrhh.TO.RhFunFormulario107_2013TO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8,
                    dato9, dato10, dato11, dato12, dato13, dato14, dato15,
                    dato16, dato17, dato18, dato19, dato20, dato21, dato22,
                    dato23, dato24, dato25, dato26, dato27, dato28, dato29,
                    dato30, dato31, dato32, dato33, dato34, dato35, dato36,
                    dato37, dato38, dato39));
        }
        return lista;
    }
    
    public static List<RhPersonaTO> convertirListaRhPersona_ListaRhPersonaTO(List datos) {
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
                dato2 = array[1].toString().toString();
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
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            Boolean dato8;
            try {
                dato8 = Boolean.valueOf(array[7].toString());
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
            Date dato12;
            try {
                dato12 = java.sql.Date.valueOf(array[11].toString());
            } catch (Exception e) {
                dato12 = null;
            }
            
            lista.add(new RhPersonaTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12));
        }
        return lista;
    }
    
    public static java.util.List<rrhh.TO.RhConsolidadoIngresosTabuladoTO> convertirRhConsolidadoIngresosTabulado_RhConsolidadoIngresosTabuladoTO(java.util.List datos) {
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
            
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            lista.add(new rrhh.TO.RhConsolidadoIngresosTabuladoTO(
                    dato5, dato1, dato2, dato3, dato4, dato6));
        }
        return lista;
    }
    
    public static java.util.List<rrhh.TO.RhAnticipoMotivoTO> convertirRhAnticipoMotivo_RhAnticipoMotivoTO(java.util.List datos) {
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
            Boolean dato3;
            try {
                dato3 = Boolean.valueOf(array[2].toString());
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
            
            lista.add(new rrhh.TO.RhAnticipoMotivoTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }
    
    public static java.util.List<rrhh.TO.RhEmpleadoDescuentosFijosTO> convertirRhEmpleadoDescuentosFijos_RhEmpleadoDescuentosFijosTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;

            Integer dato1;
            try {
                dato1 = Integer.valueOf(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            BigDecimal dato2;
            try {
                dato2 = new BigDecimal(array[1].toString());
            } catch (Exception e) {
//                dato22 = null;
                dato2 = BigDecimal.ZERO;
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
            lista.add(new rrhh.TO.RhEmpleadoDescuentosFijosTO(
                    dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }
    
    public static RhEmpleadoDescuentosFijos convertirRhEmpleadoDescuentosFijosTO_RhEmpleadoDescuentosFijos(RhEmpleadoDescuentosFijosTO rhEmpleadoDescuentosFijosTO) throws Exception {
        RhEmpleadoDescuentosFijos obj = new RhEmpleadoDescuentosFijos();
        obj.setDescSecuencial(rhEmpleadoDescuentosFijosTO.getDescSecuencial());
        obj.setDescValor(rhEmpleadoDescuentosFijosTO.getDescValor());
        obj.setRhAnticipoMotivo(new RhAnticipoMotivo(new RhAnticipoMotivoPK(rhEmpleadoDescuentosFijosTO.getMot_empresa(), rhEmpleadoDescuentosFijosTO.getMot_detalle())));
        obj.setRhEmpleado(new RhEmpleado(new RhEmpleadoPK(rhEmpleadoDescuentosFijosTO.getEmp_empresa(), rhEmpleadoDescuentosFijosTO.getEmp_id())));
        return obj;
    }
    
    public static java.util.List<rrhh.TO.RhProvisionFechasTO> convertirRhProvisionFechas_RhProvisionFechasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
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
                dato3 = array[0].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new rrhh.TO.RhProvisionFechasTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }
    
    public static RhAnticipoMotivoTO convertirRhAnticipoMotivo_RhAnticipoMotivoTO(RhAnticipoMotivo rhAnticipoMotivo) throws Exception {
        RhAnticipoMotivoTO obj = new RhAnticipoMotivoTO(
                rhAnticipoMotivo.getRhAnticipoMotivoPK().getMotEmpresa(),
                rhAnticipoMotivo.getRhAnticipoMotivoPK().getMotDetalle(),
                rhAnticipoMotivo.getMotInactivo(),
                rhAnticipoMotivo.getSecCodigo(),
                rhAnticipoMotivo.getCtaCodigo(),
                rhAnticipoMotivo.getUsrEmpresa(),
                rhAnticipoMotivo.getUsrCodigo(),
                rhAnticipoMotivo.getUsrEmpresa());
        return obj;
    }
    
    public static java.util.List<rrhh.TO.RhAnticipoMotivoTO> convertirListaRhAnticipoMotivo_ListaRhAnticipoMotivoTablaTO(java.util.List datos) {
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
            Boolean dato3;
            try {
                dato3 = Boolean.valueOf(array[2].toString());
            } catch (Exception e) {
                dato3 = false;
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
            lista.add(new rrhh.TO.RhAnticipoMotivoTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }
    
    public static RhAnticipoMotivo convertirRhAnticipoMotivoTO_RhAnticipoMotivo(RhAnticipoMotivoTO rhAnticipoMotivoTO) throws Exception {
        RhAnticipoMotivo obj = new RhAnticipoMotivo();
        obj.setRhAnticipoMotivoPK(new RhAnticipoMotivoPK(
                rhAnticipoMotivoTO.getMotEmpresa(),
                rhAnticipoMotivoTO.getMotDetalle()));
        obj.setMotInactivo(rhAnticipoMotivoTO.isMotInactivo());
        obj.setSecEmpresa(rhAnticipoMotivoTO.getMotEmpresa());
        obj.setSecCodigo(rhAnticipoMotivoTO.getSecCodigo());
        obj.setCtaEmpresa(rhAnticipoMotivoTO.getMotEmpresa());
        obj.setCtaCodigo(rhAnticipoMotivoTO.getCtaCodigo());
        obj.setUsrEmpresa(rhAnticipoMotivoTO.getUsrEmpresa());
        obj.setUsrCodigo(rhAnticipoMotivoTO.getUsrCodigo());
        obj.setUsrFechaInserta(Validacion.fechaString_Date(rhAnticipoMotivoTO.getUsrFechaInserta()));
        return obj;
    }
    
    public static rrhh.entity.RhXiiiSueldoPeriodo convertirRhXiiiSueldoPeriodoTO_RhXiiiSueldoPeriodo(rrhh.TO.RhXiiiSueldoPeriodoTO rhXiiiSueldoPeriodoTO) {
        rrhh.entity.RhXiiiSueldoPeriodo RhXiiiSueldoPeriodo = new rrhh.entity.RhXiiiSueldoPeriodo();
        RhXiiiSueldoPeriodo.setXiiiSecuencial(rhXiiiSueldoPeriodoTO.getPeriodoSecuencial());
        RhXiiiSueldoPeriodo.setXiiiDescripcion(rhXiiiSueldoPeriodoTO.getXiiiDescripcion());
        RhXiiiSueldoPeriodo.setXiiiDesde(validaciones.Validacion.fecha(rhXiiiSueldoPeriodoTO.getXiiiDesde(), "yyyy-MM-dd"));
        RhXiiiSueldoPeriodo.setXiiiHasta(validaciones.Validacion.fecha(rhXiiiSueldoPeriodoTO.getXiiiHasta(), "yyyy-MM-dd"));
        RhXiiiSueldoPeriodo.setXiiiFechaMaximaPago(validaciones.Validacion.fecha(rhXiiiSueldoPeriodoTO.getXiiiFechaMaximaPago(), "yyyy-MM-dd"));
        return RhXiiiSueldoPeriodo;
    }
    
    public static rrhh.entity.RhXivSueldoPeriodo convertirRhXivSueldoPeriodoTO_RhXivSueldoPeriodo(rrhh.TO.RhXivSueldoPeriodoTO rhXivSueldoPeriodoTO) {
        rrhh.entity.RhXivSueldoPeriodo rhXivSueldoPeriodo = new rrhh.entity.RhXivSueldoPeriodo();
        rhXivSueldoPeriodo.setXivSecuencial(rhXivSueldoPeriodoTO.getPeriodoSecuencial());
        rhXivSueldoPeriodo.setXivDescripcion(rhXivSueldoPeriodoTO.getXivDescripcion());
        rhXivSueldoPeriodo.setXivDesde(validaciones.Validacion.fecha(rhXivSueldoPeriodoTO.getXivDesde(), "yyyy-MM-dd"));
        rhXivSueldoPeriodo.setXivHasta(validaciones.Validacion.fecha(rhXivSueldoPeriodoTO.getXivHasta(), "yyyy-MM-dd"));
        rhXivSueldoPeriodo.setXivFechaMaximaPago(validaciones.Validacion.fecha(rhXivSueldoPeriodoTO.getXivFechaMaximaPago(), "yyyy-MM-dd"));
        return rhXivSueldoPeriodo;
    }
    /*
     *
     *
     *
     *
     *
     * sec_empresa character(7) NOT NULL, sec_codigo character(7) NOT NULL,
     * con_empresa character(7) NOT NULL, con_periodo character(7) NOT NULL,
     * con_tipo character(7) NOT NULL, con_numero character(7) NOT NULL,
     */
    
    public static rrhh.entity.RhSalarioDigno convertirRhSalarioDignoTO_RhSalarioDigno(rrhh.TO.RhSalarioDignoTO rhSalarioDignoTO) {
        rrhh.entity.RhEmpleado rhEmpleado = new rrhh.entity.RhEmpleado(new rrhh.entity.RhEmpleadoPK(
                rhSalarioDignoTO.getEmpEmpresa(),
                rhSalarioDignoTO.getEmpId()));
        
        rrhh.entity.RhSalarioDigno rhSalarioDigno = new rrhh.entity.RhSalarioDigno();
        rhSalarioDigno.setSdigSecuencial(rhSalarioDignoTO.getSdigSecuencial());
        rhSalarioDigno.setSdigDesde(validaciones.Validacion.fecha(rhSalarioDignoTO.getSdigDesde(), "yyyy-MM-dd"));
        rhSalarioDigno.setSdigHasta(validaciones.Validacion.fecha(rhSalarioDignoTO.getSdigHasta(), "yyyy-MM-dd"));
        rhSalarioDigno.setSdigValor(rhSalarioDignoTO.getSdigValor());
        rhSalarioDigno.setSdigFormaPago(rhSalarioDignoTO.getSdigFormaPago());
        rhSalarioDigno.setSdigReversado(rhSalarioDignoTO.getSdigReversado());
        rhSalarioDigno.setRhEmpleado(rhEmpleado);
        rhSalarioDigno.setSecEmpresa(rhSalarioDignoTO.getEmpEmpresa());
        rhSalarioDigno.setSecCodigo(rhSalarioDignoTO.getSecCodigo());
        rhSalarioDigno.setConEmpresa(rhSalarioDignoTO.getConEmpresa());
        rhSalarioDigno.setConPeriodo(rhSalarioDignoTO.getConPeriodo());
        rhSalarioDigno.setConTipo(rhSalarioDignoTO.getConTipo());
        rhSalarioDigno.setConNumero(rhSalarioDignoTO.getConNumero());
        return rhSalarioDigno;
    }
}
