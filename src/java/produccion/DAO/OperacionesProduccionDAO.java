/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.DAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import produccion.TO.*;
import produccion.entity.*;
import produccion.entity.DAO.*;
import produccion.helper.ConversionesProduccion;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesProduccionDAO implements OperacionesProduccionDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "EJBShrimpPU")
    EntityManager em;
    @EJB
    PrdSectorFacadeLocal prdSectorFacadeLocal;
    @EJB
    PrdPiscinaFacadeLocal prdPiscinaFacadeLocal;
    @EJB
    PrdVehiculosFacadeLocal prdVehiculosFacadeLocal;
    @EJB
    PrdGrameajeFacadeLocal prdGrameajeFacadeLocal;
    @EJB
    PrdCorridaFacadeLocal prdCorridaFacadeLocal;
    @EJB
    PrdSobrevivenciaFacadeLocal prdSobrevivenciaFacadeLocal;
    @EJB
    PrdLiquidacionMotivoFacadeLocal prdLiquidacionMotivoFacadeLocal;
    @EJB
    PrdLiquidacionTallaFacadeLocal prdLiquidacionTallaFacadeLocal;
    @EJB
    PrdLiquidacionProductoFacadeLocal prdLiquidacionProductoFacadeLocal;
    @EJB
    PrdLiquidacionFacadeLocal prdLiquidacionFacadeLocal;

//    private boolean comprobar;
    // <editor-fold defaultstate="collapsed" desc="BUSCAR ENTIDADES">
    @Override
    public PrdSector buscarSector(String empCodigo, String secCodigo) throws Exception {
        return prdSectorFacadeLocal.find(new PrdSectorPK(empCodigo, secCodigo));
    }

    @Override
    public PrdPiscina buscarPiscina(String empCodigo, String secCodigo, String pisNumero) throws Exception {
        return prdPiscinaFacadeLocal.find(new PrdPiscinaPK(empCodigo, secCodigo, pisNumero));
    }

    @Override
    public PrdVehiculos buscarVehiculos(String empCodigo, String secCodigo, String pisNumero) throws Exception {
        return prdVehiculosFacadeLocal.find(new PrdVehiculosPK(empCodigo, secCodigo, pisNumero));
    }

    @Override
    public PrdGrameaje buscarGrameaje(String empCodigo, String secCodigo, String pisNumero, String fecha) throws Exception {
        return prdGrameajeFacadeLocal.find(new PrdGrameajePK(empCodigo, secCodigo, pisNumero, validaciones.Validacion.fecha(fecha, "yyyy-MM-dd")));
    }

    @Override
    public PrdCorrida buscarCorrida(String empCodigo, String secCodigo, String pisNumero, String numCorrida) throws Exception {
        return prdCorridaFacadeLocal.find(new PrdCorridaPK(empCodigo, secCodigo, pisNumero, numCorrida));
    }

    @Override
    public void ponerCorridaFalse(String empresa) throws Exception {
        em.createNativeQuery("UPDATE produccion.prd_corrida SET cor_activa = FALSE WHERE cor_empresa = '" + empresa + "'");
    }

    @Override
    public java.util.List<PrdCorrida> buscarTodasCorrida(String empresa) throws Exception {
        java.util.List<PrdCorrida> prdCorridas = ConversionesProduccion.convertirPrdCorrida(
                em.createNativeQuery("SELECT * FROM produccion.prd_corrida WHERE cor_empresa = '" + empresa + "'").getResultList());
        for (int i = 0; i < prdCorridas.size(); i++) {
            prdCorridas.get(i).setPrdPiscina(buscarPiscina(
                    prdCorridas.get(i).getPrdCorridaPK().getCorEmpresa(),
                    prdCorridas.get(i).getPrdCorridaPK().getCorSector(),
                    prdCorridas.get(i).getPrdCorridaPK().getCorPiscina()));
        }
        return prdCorridas;
//        return prdCorridaFacadeLocal.findAll();
    }

    @Override
    public java.util.List<PrdCorrida> buscarTodasCorridaPorFecha(String empresa, String fecha) throws Exception {
        java.util.List<PrdCorrida> prdCorridas = ConversionesProduccion.convertirPrdCorrida(
                em.createNativeQuery("SELECT * FROM produccion.prd_corrida WHERE cor_empresa = ('" + empresa + "') AND "
                + "(('" + fecha + "' >= prd_corrida.cor_fecha_desde AND '" + fecha + "' <= prd_corrida.cor_fecha_hasta) OR "
                + "('" + fecha + "' >= prd_corrida.cor_fecha_desde AND prd_corrida.cor_fecha_hasta IS NULL)) ORDER BY 1, 2, 3").getResultList());
        for (int i = 0; i < prdCorridas.size(); i++) {
            prdCorridas.get(i).setPrdPiscina(buscarPiscina(
                    prdCorridas.get(i).getPrdCorridaPK().getCorEmpresa(),
                    prdCorridas.get(i).getPrdCorridaPK().getCorSector(),
                    prdCorridas.get(i).getPrdCorridaPK().getCorPiscina()));
        }
        return prdCorridas;
//        return prdCorridaFacadeLocal.findAll();
    }

    @Override
    public PrdSobrevivencia buscarSobrevivencia(int codSobrevivencia) throws Exception {
        return prdSobrevivenciaFacadeLocal.find(codSobrevivencia);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SECTOR">
    /**
     * @autor misayo
     *
     * @param prdSectorTO Objeto TO
     * @return false si esta relacionado con otras tablas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean eliminarPrdSector(PrdSectorTO prdSectorTO) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM "
                + "produccion.fun_eliminar_produccion('S', ('" + prdSectorTO.getSecEmpresa()
                + "'), ('" + prdSectorTO.getSecCodigo() + "'), null, null)").getResultList(), 0)[0].toString());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de periodos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<PrdListaSectorTO> getListaSector(String empresa, boolean activo) throws Exception {
        if (activo) {
            return ConversionesProduccion.convertirListaPrdSector_ListaPrdSectorTO(em.createNativeQuery("SELECT sec_codigo, sec_nombre, sec_latitud, "
                    + "sec_longitud, sec_activo FROM produccion.prd_sector "
                    + "WHERE sec_empresa = ('" + empresa + "') ORDER BY sec_codigo").getResultList());
        } else {
            return ConversionesProduccion.convertirListaPrdSector_ListaPrdSectorTO(em.createNativeQuery("SELECT sec_codigo, sec_nombre, sec_latitud, "
                    + "sec_longitud, sec_activo FROM produccion.prd_sector "
                    + "WHERE sec_empresa = ('" + empresa + "') AND sec_activo ORDER BY sec_codigo").getResultList());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PISCINA">
    /**
     * @autor misayo
     *
     * @param prdPiscinaTO Objeto TO
     * @return false si esta relacionado con otras tablas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean eliminarPrdPiscina(PrdPiscinaTO prdPiscinaTO) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM "
                + "produccion.fun_eliminar_produccion('P', ('" + prdPiscinaTO.getPisEmpresa() + "'), ('" + prdPiscinaTO.getPisSector() + "'), ('"
                + prdPiscinaTO.getPisNumero() + "'), null)").getResultList(), 0)[0].toString());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de piscinas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<PrdListaPiscinaTO> getListaPiscina(String empresa, String sector) throws Exception {
        return ConversionesProduccion.convertirListaPrdPiscina_ListaPrdPiscinaTO(em.createNativeQuery("SELECT pis_numero, pis_nombre, pis_hectareaje, "
                + "pis_activa FROM produccion.prd_piscina "
                + "WHERE pis_empresa = ('" + empresa + "') AND pis_sector = ('" + sector + "') ORDER BY pis_numero").getResultList());
    }

    @Override
    public List<PrdListaPiscinaComboTO> getListaPiscina(String empresa, boolean activo) throws Exception {
        if (activo) {
            return ConversionesProduccion.convertirListaPrdPiscinaCombo_ListaPrdPiscinaComboTO(em.createNativeQuery("SELECT pis_numero, pis_nombre, pis_sector "
                    + "FROM produccion.prd_piscina "
                    + "WHERE pis_empresa = ('" + empresa + "') AND pis_activa  ORDER BY pis_numero").getResultList());
        } else {
            return ConversionesProduccion.convertirListaPrdPiscinaCombo_ListaPrdPiscinaComboTO(em.createNativeQuery("SELECT pis_numero, pis_nombre, pis_sector "
                    + "FROM produccion.prd_piscina "
                    + "WHERE pis_empresa = ('" + empresa + "')  ORDER BY pis_numero").getResultList());
        }
    }

    @Override
    public List<PrdListaPiscinaTO> getListaPiscinaBusqueda(String empresa, String sector, String fecha) throws Exception {
        return ConversionesProduccion.convertirListaPrdPiscina_ListaPrdPiscinaTO(em.createNativeQuery("SELECT prd_piscina.pis_numero, prd_piscina.pis_nombre, prd_piscina.pis_hectareaje, prd_piscina.pis_activa "
                + "FROM produccion.prd_piscina INNER JOIN produccion.prd_corrida ON prd_corrida.cor_empresa = prd_piscina.pis_empresa AND "
                + "prd_corrida.cor_sector  = prd_piscina.pis_sector AND prd_corrida.cor_piscina = prd_piscina.pis_numero AND "
                + "(('" + fecha + "' >= prd_corrida.cor_fecha_desde AND '" + fecha + "' <= prd_corrida.cor_fecha_hasta) OR "
                + "('" + fecha + "' >= prd_corrida.cor_fecha_desde AND prd_corrida.cor_fecha_hasta IS NULL)) "
                + "WHERE prd_piscina.pis_empresa = ('" + empresa + "') AND prd_piscina.pis_sector = ('" + sector + "') "
                + "ORDER BY prd_piscina.pis_numero").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de piscinas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<PrdComboPiscinaTO> getComboPiscina(String empresa, String sector) throws Exception {
        return ConversionesProduccion.convertirComboPrdPiscina_ComboPrdPiscinaTO(em.createNativeQuery("SELECT pis_numero, pis_nombre, pis_hectareaje "
                + "FROM produccion.prd_piscina "
                + "WHERE (pis_empresa = '" + empresa + "') AND (pis_sector = '" + sector + "') "
                + "AND pis_activa ORDER BY pis_numero").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CORRIDA">
    /**
     * @autor misayo
     *
     * @param prdCorridaTO Objeto TO
     * @return false si esta relacionado con otras tablas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean eliminarPrdCorrida(PrdCorridaTO prdCorridaTO) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM "
                + "produccion.fun_eliminar_produccion('C', ('" + prdCorridaTO.getCorEmpresa() + "'), ('" + prdCorridaTO.getCorSector() + "'), ('"
                + prdCorridaTO.getPisNumero() + "'), ('" + prdCorridaTO.getCorNumero()
                + "'))").getResultList(), 0)[0].toString());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param sector
     * @param piscina
     * @return lista de corridas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<PrdListaCorridaTO> getListaCorrida(String empresa, String sector, String piscina) throws Exception {
        return ConversionesProduccion.convertirListaPrdCorrida_ListaPrdCorridaTO(em.createNativeQuery("SELECT cor_numero, cor_fecha_desde, cor_hectareas, "
                + "cor_numero_larvas, cor_laboratorio, cor_nauplio, "
                + "cor_pellet, cor_fecha_siembra, cor_biomasa, "
                + "cor_valor_venta, cor_observaciones, cor_fecha_pesca, "
                + "cor_fecha_hasta, cor_activa "
                + "FROM produccion.prd_corrida "
                + "WHERE cor_empresa = ('" + empresa + "') AND "
                + "cor_sector = ('" + sector + "') AND "
                + "cor_piscina = ('" + piscina + "') ORDER BY cor_numero").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param sector
     * @param piscina
     * @return lista de corridas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<PrdListaCorridaTO> getListaCorrida(
            String empresa,
            String sector,
            String piscina,
            String corrida) throws Exception {
        return ConversionesProduccion.convertirListaPrdCorrida_ListaPrdCorridaTO(em.createNativeQuery("SELECT cor_numero, cor_fecha_desde, cor_hectareas, "
                + "cor_numero_larvas, cor_laboratorio, cor_nauplio, "
                + "cor_pellet, cor_fecha_siembra, cor_biomasa, "
                + "cor_valor_venta, cor_fecha_pesca, "
                + "cor_fecha_hasta, cor_activa "
                + "FROM produccion.prd_corrida "
                + "WHERE cor_empresa = ('" + empresa + "') AND "
                + "cor_sector = ('" + sector + "') AND "
                + "cor_piscina = ('" + piscina + "') AND "
                + "cor_numero =  ('" + corrida + "')").getResultList());
    }

    @Override
    public PrdFunAnalisisVentasTO getPrdFunAnalisisVentasTO(
            String empresa,
            String sector,
            String piscina,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return ConversionesProduccion.convertirPrdFunAnalisisVentas_PrdFunAnalisisVentasTO(em.createNativeQuery("SELECT * FROM produccion.fun_analisis_ventas("
                + "'" + empresa + "', "
                + "'" + sector + "', "
                + "'PESCA', "
                + "'" + fechaDesde + "', "
                + "'" + fechaHasta + "') "
                + "WHERE rc_piscina = '" + piscina + "';").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param sector
     * @param piscina
     * @return prdListaCostosDetalleCorridaTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<produccion.TO.PrdListaCostosDetalleCorridaTO> getPrdListaCostosDetalleCorridaTO(String empresa, String sector, String piscina, String desde, String hasta, java.lang.String agrupadoPor) throws Exception {
        agrupadoPor = agrupadoPor == null ? agrupadoPor : "'" + agrupadoPor + "'";
        return ConversionesProduccion.convertirListaCostosDetalleCorrida_ListaCostosDetalleCorridaTO(em.createNativeQuery("SELECT * FROM produccion.fun_costos_detalle_corrida("
                + "'" + empresa + "', "
                + "'" + sector + "', "
                + "'" + piscina + "', " + desde + ", " + hasta + ", " + agrupadoPor + ");").getResultList());
    }

    /**
     * @autor jack
     *
     * @param empresa
     * @param sector
     * @param piscina
     * @return lista de corridas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<PrdComboCorridaTO> getComboPrdCorrida(String empresa, String sector, String piscina) throws Exception {
        return ConversionesProduccion.convertirComboPrdCorrida_ComboPrdCorridaTO(em.createNativeQuery("SELECT cor_numero, cor_hectareas, cor_numero_larvas, "
                + "SUBSTRING(cor_fecha_desde::TEXT, 1, 10), SUBSTRING(cor_fecha_hasta::TEXT, 1, 10) FROM "
                + "produccion.prd_corrida WHERE (cor_empresa = '" + empresa + "') AND (cor_sector = '" + sector + "') AND "
                + "(cor_piscina = '" + piscina + "') ORDER BY cor_numero").getResultList());
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="RESUMEN CORRIDA">
    /**
     * @autor Jack Krauser Metodo que obtiene un resumen de las corridas
     *
     * @param empresa
     * @param desde Fecha desde
     * @param hasta Fecha hasta
     * @param tipoResumen Tipo de Resumen que se quiere consultar
     * @return lista de resumen de corridas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<PrdResumenCorridaTO> getListaResumenCorridaTO(String empresa, String sector, String desde, String hasta, String tipoResumen) throws Exception {
        java.util.List<PrdResumenCorridaTO> prdResumenCorridaTOs = new java.util.ArrayList();
        if (tipoResumen.equals("SIEMBRA")) {
            prdResumenCorridaTOs = ConversionesProduccion.convertirListaPrdResumenCorrida_ListaPrdResumenCorridaTO(
                    em.createNativeQuery("SELECT * FROM produccion.fun_resumen_corrida ('" + empresa + "', " + sector + ", "
                    + "'SIEMBRA', " + desde + ", " + hasta + ")").getResultList());
        } else {
            prdResumenCorridaTOs = ConversionesProduccion.convertirListaPrdResumenCorrida_ListaPrdResumenCorridaTO(
                    em.createNativeQuery("SELECT * FROM produccion.fun_resumen_corrida('" + empresa + "', " + sector + ", "
                    + "'PESCA', " + desde + ", " + hasta + ")").getResultList());
        }
        return prdResumenCorridaTOs;
    }

    @Override
    public String consultarFechaMaxMin(String empresa, String tipoResumen) throws Exception {
        String fecha = "";
//        List lista = null;
        Object[] array = null;
//        empresa = "UT";
        if (tipoResumen.equals("SIEMBRA")) {
            array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("select substring((min(cor_fecha_desde))::text, 1, 10) minimo, "
                    + "substring((max(cor_fecha_desde))::text, 1,"
                    + " 10) maximo from produccion.prd_corrida where cor_empresa ="
                    + " ('" + empresa + "') and cor_fecha_hasta is null").getResultList(), 0);
        } else {
            array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                    "SELECT SUBSTRING(min(cor_fecha_hasta)::TEXT, 1, 10) minimo, "
                    + "SUBSTRING(max(cor_fecha_hasta)::TEXT, 1, 10) maximo "
                    + "FROM produccion.prd_corrida "
                    + "WHERE cor_empresa = ('" + empresa + "') AND cor_fecha_pesca IS NOT NULL;").getResultList(), 0);
        }

        fecha = (array[0] != null && array[1] != null) ? array[0].toString() + " , " + array[1].toString() : "";
        //fecha = lista.get(0).toString();

        return fecha;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SOBREVIVENCIA">
    /**
     * @autor Nelsys
     *
     * @param empresa
     * @param sector
     * @return lista de sobrevivencia
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<PrdListaSobrevivenciaTO> getListaSobrevivencia(String empresa, String sector) throws Exception {
        /*
         * this.sobCodigo = sobCodigo; this.sobDiasDesde = sobDiasDesde;
         * this.sobDiasHasta = sobDiasHasta; this.sobSobrevivencia =
         * sobSobrevivencia;
         */
        return ConversionesProduccion.convertirListaPrdSobrevivencia_ListaPrdSobrevivenciaTO(em.createNativeQuery("SELECT sob_codigo, sob_dias_desde, sob_dias_hasta, sob_sobrevivencia, sob_alimentacion "
                + "FROM produccion.prd_sobrevivencia WHERE sec_empresa = ('" + empresa + "') AND "
                + "sec_codigo = ('" + sector + "') ORDER BY sob_dias_desde").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GRAMEAJE">
    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @param sector
     * @return lista de sobrevivencia
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean getIsFechaGrameajeSuperior(String empresa, String sector, String numPiscina, String fecha) throws Exception {
        Date fechaCliente = validaciones.Validacion.fecha(fecha, "yyyy-MM-dd");
        String fechaConsulta = (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("select CASE WHEN max(gra_fecha) "
                + "IS NULL THEN '' ELSE max(gra_fecha)::TEXT END from produccion.prd_grameaje "
                + "where TRIM(BOTH ' ' FROM gra_empresa) || TRIM(BOTH ' ' FROM gra_sector) || "
                + "TRIM(BOTH ' ' FROM gra_piscina) = ('" + empresa + sector + numPiscina + "')").
                getResultList(), 0)[0].toString());        
//        String fechaConsulta = (((List) em.createNativeQuery("select substring(max(gra_fecha)::text, 1, 10) from "
//                + "produccion.prd_grameaje where TRIM(BOTH ' ' FROM gra_empresa) "
//                + "|| TRIM(BOTH ' ' FROM gra_sector) || TRIM(BOTH ' ' FROM "
//                + "gra_piscina) = ('" + empresa + sector + numPiscina + "')").
//                getResultList().get(0)).get(0).toString());

        boolean retorno = false;
        if (fechaConsulta.trim().isEmpty()) {
            retorno = true;
        } else {
            Date fechaBD = validaciones.Validacion.fecha(fechaConsulta, "yyyy-MM-dd");
            retorno = (fechaCliente.getTime() > fechaBD.getTime()) ? true : false;            
        }



//        Date fechaBD = validaciones.Validacion.fecha(fechaConsulta);
        
        return retorno;
    }

    @Override
    public List<produccion.TO.PrdListadoGrameajeTO> getPrdListadoGrameajeTO(String empresa, String sector, String piscina, String desde, String hasta) throws Exception {
        String sql = "SELECT * FROM produccion.fun_listado_grameaje('" + empresa + "', '" + sector + "', "
                + "'" + piscina + "', " + desde + ", " + hasta + ")";
        return ConversionesProduccion.convertirPrdListadoGrameaje_PrdListadoGrameajeTO(em.createNativeQuery(sql).getResultList());
    }

    // </editor-fold>
    @Override
    public List<produccion.TO.PrdCostoDetalleFechaTO> getPrdListadoCostoDetalleFechaTO(String empresa, java.lang.String secCodigo, String desde, String hasta, java.lang.String agrupadoPor) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        agrupadoPor = agrupadoPor == null ? agrupadoPor : "'" + agrupadoPor + "'";
        return ConversionesProduccion.convertirPrdListadoCostoDetalleFecha_PrdListadoCostoDetalleFechaTO(em.createNativeQuery("SELECT * FROM produccion.fun_costos_detalle_por_fecha("
                + "'" + empresa + "', '" + secCodigo + "', " + desde + ", " + hasta + ", " + agrupadoPor + ")").getResultList());
    }

    @Override
    public List<produccion.TO.CostoDetalleMultipleCorridaTO> getCostoDetalleMultipleCorridaTO(String empresa, String hasta, java.lang.String agrupadoPor) throws Exception {
        agrupadoPor = agrupadoPor == null ? agrupadoPor : "'" + agrupadoPor + "'";
        return ConversionesProduccion.convertirCostoDetalleMultipleCorrida_CostoDetalleMultipleCorridaTO(em.createNativeQuery("SELECT * FROM produccion.fun_costos_productos_proceso('" + empresa + "', " + hasta + ", " + agrupadoPor + ")").getResultList());
//                createNativeQuery("SELECT * FROM produccion.fun_costos_detalle_multiple_corrida('" + empresa + "')").getResultList());
    }

    @Override
    public produccion.TO.PrdCorridaTO getPrdCorridaTO(String empresa, String sector, String piscina, String fecha) throws Exception {
        return ConversionesProduccion.convertirPrdCorrida_PrdCorridaTO(em.createNativeQuery("SELECT * FROM produccion.prd_corrida WHERE cor_empresa = ('" + empresa + "') AND "
                + "cor_sector = ('" + sector + "') AND cor_piscina = ('" + piscina + "') AND "
                + "(('" + fecha + "' >= prd_corrida.cor_fecha_desde AND '" + fecha + "' <= prd_corrida.cor_fecha_hasta) OR "
                + "('" + fecha + "' >= prd_corrida.cor_fecha_desde AND prd_corrida.cor_fecha_hasta IS NULL)) ORDER BY cor_numero").getResultList());

    }

    @Override
    public produccion.TO.PrdGrameajeTO getPrdGrameajeTO(String empresa, String sector, String piscina, String fecha) throws Exception {
        fecha = fecha == null ? fecha : "'" + fecha + "'";
        return ConversionesProduccion.convertirPrdGrameaje_PrdGrameajeTO(em.createNativeQuery("SELECT * FROM produccion.prd_grameaje "
                + "WHERE (gra_empresa = '" + empresa + "' "
                + "AND gra_sector = '" + sector + "' "
                + "AND gra_piscina = '" + piscina + "' "
                + "AND gra_fecha = " + fecha + ");").getResultList());
    }

    @Override
    public produccion.TO.PrdGrameajeTO getPrdGrameajeTO(String empresa, String sector, String piscina, String desde, String hasta) throws Exception {
        return ConversionesProduccion.convertirPrdGrameaje_PrdGrameajeTO(em.createNativeQuery("SELECT * FROM produccion.prd_grameaje WHERE gra_empresa = '" + empresa + "' "
                + "AND gra_sector = '" + sector + "' AND "
                + "gra_piscina = '" + piscina + "' AND ((gra_fecha >= " + desde + " AND gra_fecha <= " + hasta + ") "
                + "OR (gra_fecha >= " + desde + " AND " + hasta + " IS NULL)) AND "
                + "(NOT gra_anulado OR gra_anulado IS NULL) ORDER BY gra_fecha DESC LIMIT 1").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.MultiplePiscinaCorrida> getCostoDetallePersonalizado(String empresa, String sector, String fecha) {
        sector = sector.trim().isEmpty() ? null : "'" + sector + "'";
        return ConversionesProduccion.convertirMultiplePiscinaCorrida_MultiplePiscinaCorridaPersonalizadoTO(em.createNativeQuery("SELECT cor_empresa, cor_sector, cor_piscina, cor_numero, cor_fecha_desde, cor_fecha_hasta"
                + " FROM produccion.prd_corrida WHERE cor_empresa = ('" + empresa + "') AND CASE WHEN " + sector + " IS NULL THEN TRUE ELSE cor_sector = (" + sector + ") END AND "
                + "(('" + fecha + "' >= prd_corrida.cor_fecha_desde AND '" + fecha + "' <= prd_corrida.cor_fecha_hasta) OR "
                + "('" + fecha + "' >= prd_corrida.cor_fecha_desde AND prd_corrida.cor_fecha_hasta IS NULL)) ORDER BY 1,2,3,4;").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdCostoPorFechaProrrateadoTO> getCostoPorFechaProrrateado(String empresa, String codigoSector, String fechaInicio, String fechaFin, java.lang.String agrupadoPor) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";
        agrupadoPor = agrupadoPor == null ? agrupadoPor : "'" + agrupadoPor + "'";
        return produccion.helper.ConversionesProduccion.convertirPrdCostoPorFechaProrrateadoTO_PrdCostoPorFechaProrrateadoTO(em.createNativeQuery(
                "SELECT * FROM produccion.fun_costos_por_fecha_prorrateado('" + empresa + "',"
                + "" + codigoSector + ", " + fechaInicio + ", " + fechaFin + ", " + agrupadoPor + ")").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdFunCostosPorFechaSimpleTO> getPrdFunCostosPorFechaSimpleTO(
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";
        return produccion.helper.ConversionesProduccion.convertirPrdFunCostosPorFechaSimple_PrdFunCostosPorFechaSimpleTO(
                em.createNativeQuery(
                "SELECT * FROM produccion.fun_costos_por_fecha_simple('"
                + sisInfoTO.getInfEmpresa() + "', "
                + codigoSector + ", "
                + fechaInicio + ", "
                + fechaFin + ")").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdCostoPorPiscinaSemanalTO> getCostoPorPorPiscinaSemanal(String empresa, String codigoSector, String numeroPiscina, String fechaInicio, String fechaFin, java.lang.String agrupadoPor) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";
        numeroPiscina = numeroPiscina.isEmpty() ? null : "'" + numeroPiscina + "'";
        agrupadoPor = agrupadoPor == null ? agrupadoPor : "'" + agrupadoPor + "'";

        return produccion.helper.ConversionesProduccion.convertirPrdCostoPorPiscinaSemanalTO_PrdCostoPorPiscinaSemanalTO(em.createNativeQuery(
                "SELECT * FROM produccion.fun_costos_por_piscina_semanal('" + empresa + "', " + codigoSector + ", "
                + numeroPiscina + ", " + fechaInicio + ", " + fechaFin + ", " + agrupadoPor + ")").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdConsumoPorFechaDesglosadoTO> getConsumoPorFechaDesglosado(String empresa, String codigoSector, String fechaInicio, String fechaFin) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";
        return produccion.helper.ConversionesProduccion.convertirPrdConsumoPorFechaDesglosadoTO_PrdConsumoPorFechaDesglosadoTO(em.createNativeQuery(
                "SELECT * FROM produccion.fun_consumos_por_fecha_desglosado('" + empresa + "', " + codigoSector + ", " + fechaInicio + ", " + fechaFin + ")").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdConsumoProductoEnProcesoTO> getConsumoProductosProceso(String empresa, String fecha) throws Exception {
        fecha = fecha.isEmpty() ? null : fecha;
        return produccion.helper.ConversionesProduccion.convertirPrdConsumoProductoEnProcesoTO_PrdConsumoProductoEnProcesoTO(em.createNativeQuery(
                "SELECT * FROM produccion.fun_consumos_productos_proceso('" + empresa + "', " + fecha + ")").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdConsumoMultiplePiscinaTO> getConsumoMultiplePiscina(String empresa) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirPrdConsumoMultiplePiscinaTO_PrdConsumoMultiplePiscinaTO(em.createNativeQuery(
                "SELECT * FROM produccion.fun_consumos_multiple_piscinas('" + empresa + "')").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdConsumosTO> getPrdConsumosFechaTO(String empresa, String sector, String fechaDesde, String fechaHasta) throws Exception {
        sector = sector == null ? null : "'" + sector + "'";
        fechaDesde = fechaDesde == null ? null : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? null : "'" + fechaHasta + "'";
        return produccion.helper.ConversionesProduccion.convertirPrdConsumos_PrdConsumosTO(em.createNativeQuery(
                "SELECT * FROM produccion.fun_consumos_por_fecha("
                + "'" + empresa + "', "
                + sector + ", "
                + fechaDesde + ", "
                + fechaHasta + ")").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdConsumosTO> getPrdConsumosPiscinaTO(String empresa, String sector, String piscina, String fechaDesde, String fechaHasta) throws Exception {
        sector = sector == null ? null : "'" + sector + "'";
        piscina = piscina == null ? null : "'" + piscina + "'";
        fechaDesde = fechaDesde == null ? null : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? null : "'" + fechaHasta + "'";
        return produccion.helper.ConversionesProduccion.convertirPrdConsumos_PrdConsumosTO(em.createNativeQuery(
                "SELECT * FROM produccion.fun_consumos_por_piscina("
                + "'" + empresa + "', "
                + sector + ", "
                + piscina + ", "
                + fechaDesde + ", "
                + fechaHasta + ")").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdConsumosPorPiscinaPeriodoTO> getConsumoPorPiscinaPeriodo(String empresa, String codigoSector, String numeroPiscina, String fechaInicio, String fechaFin, String periodo) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";
        numeroPiscina = numeroPiscina.isEmpty() ? null : "'" + numeroPiscina + "'";

        String sql = "SELECT * FROM produccion.fun_consumos_por_piscina_periodo('" + empresa + "', " + codigoSector + ", "
                + numeroPiscina + ", " + fechaInicio + ", " + fechaFin + ", '" + periodo + "')";
        
        return produccion.helper.ConversionesProduccion.convertirPrdConsumosPorPiscinaPeriodoTO_PrdConsumosPorPiscinaPeriodoTO(em.createNativeQuery(
                "SELECT * FROM produccion.fun_consumos_por_piscina_periodo('" + empresa + "', " + codigoSector + ", "
                + numeroPiscina + ", " + fechaInicio + ", " + fechaFin + ", '" + periodo + "')").getResultList());
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de periodos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<PrdListaSectorConHectareajeTO> getListaSectorConHectareaje(String empresa, String fecha) throws Exception {
        return ConversionesProduccion.convertirListaPrdSectorConHectareaje_ListaPrdSectorConHectareajeTO(em.createNativeQuery("SELECT prd_piscina.sec_codigo, prd_sector.sec_nombre, inv_bodega.bod_codigo, inv_bodega.bod_nombre, SUM(prd_piscina.pis_hectareaje) sec_hectareaje "
                + "FROM inventario.inv_bodega INNER JOIN produccion.prd_sector INNER JOIN produccion.prd_piscina INNER JOIN produccion.prd_corrida "
                + "ON prd_piscina.pis_empresa = prd_corrida.cor_empresa AND prd_piscina.pis_sector  = prd_corrida.cor_sector AND "
                + "prd_piscina.pis_numero  = prd_corrida.cor_piscina AND (('" + fecha + "' >= prd_corrida.cor_fecha_desde "
                + "AND '" + fecha + "' <= prd_corrida.cor_fecha_hasta) OR ('" + fecha + "' >= prd_corrida.cor_fecha_desde AND prd_corrida.cor_fecha_hasta IS NULL)) "
                + "ON prd_sector.sec_empresa = prd_piscina.sec_empresa AND prd_sector.sec_codigo = prd_piscina.sec_codigo "
                + "ON inv_bodega.sec_empresa = prd_sector.sec_empresa AND inv_bodega.sec_codigo = prd_sector.sec_codigo "
                + "WHERE prd_piscina.pis_empresa = ('" + empresa + "') GROUP BY prd_piscina.sec_empresa, prd_piscina.sec_codigo, prd_sector.sec_nombre, "
                + "inv_bodega.bod_codigo, inv_bodega.bod_nombre ORDER BY prd_piscina.sec_empresa, prd_piscina.sec_codigo").getResultList());
    }

    @Override
    public List<produccion.TO.PrdResumenFinancieroTO> getPrdResumenFinancieroTO(String empresa, java.lang.String secCodigo, String desde, String hasta) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        return ConversionesProduccion.convertirPrdResumenFinanciero_PrdResumenFinancieroTO(em.createNativeQuery("SELECT * FROM produccion.fun_resumen_financiero("
                + "'" + empresa + "', '" + secCodigo + "', " + desde + ", " + hasta + ")").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdResumenPescaTO> getResumenPesca(String empresa, String codigoSector, String fechaInicio, String fechaFin) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
//        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";

        return produccion.helper.ConversionesProduccion.convertirPrdResumenPesca_PrdResumenPescaTO(em.createNativeQuery(
                "SELECT * FROM produccion.fun_resumen_corrida_new('" + empresa + "', " + codigoSector + ", 'PESCA', " + fechaInicio + ", " + fechaFin + ")").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdResumenSiembraTO> getResumenSiembra(String empresa, String codigoSector, String fechaInicio, String fechaFin) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
//        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";

        return produccion.helper.ConversionesProduccion.convertirPrdResumenSiembra_PrdResumenSiembraTO(em.createNativeQuery(
                "SELECT * FROM produccion.fun_resumen_corrida_new('" + empresa + "', " + codigoSector + ", 'SIEMBRA', " + fechaInicio + ", " + fechaFin + ")").getResultList());
    }

    public PrdLiquidacionMotivoTO getPrdLiquidacionMotivoTO(String empresa, PrdLiquidacionMotivoTablaTO prdLiquidacionMotivoTablaTO) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirPrdLiquidacionMotivo_PrdLiquidacionMotivoTO(prdLiquidacionMotivoFacadeLocal.find(new produccion.entity.PrdLiquidacionMotivoPK(empresa, prdLiquidacionMotivoTablaTO.getLmCodigo())));
    }

    public produccion.entity.PrdLiquidacionMotivo getPrdLiquidacionMotivo(String empresa, String codigo) throws Exception {
        return prdLiquidacionMotivoFacadeLocal.find(new produccion.entity.PrdLiquidacionMotivoPK(empresa, codigo));
    }

    public List<produccion.TO.PrdLiquidacionMotivoTablaTO> getListaPrdLiquidacionMotivoTablaTO(String empresa) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirListaPrdLiquidacionMotivo_ListaPrdLiquidacionMotivoTO(
                em.createNativeQuery("SELECT lm_codigo, lm_detalle FROM produccion.prd_liquidacion_motivo "
                + "WHERE lm_empresa = ('" + empresa + "') ORDER BY lm_codigo").
                getResultList());
    }

    public produccion.TO.PrdLiquidacionTallaTO getPrdLiquidacionTallaTO(String empresa, produccion.TO.PrdLiquidacionTallaTablaTO liquidacionTallaTablaTO) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirPrdLiquidacionTalla_PrdLiquidacionTallaTO(prdLiquidacionTallaFacadeLocal.find(new produccion.entity.PrdLiquidacionTallaPK(empresa, liquidacionTallaTablaTO.getTallaCodigo())));
    }

    public produccion.entity.PrdLiquidacionTalla getPrdLiquidacionTalla(String empresa, String codigo) throws Exception {
        return prdLiquidacionTallaFacadeLocal.find(new produccion.entity.PrdLiquidacionTallaPK(empresa, codigo));
    }

    public List<produccion.TO.PrdLiquidacionTallaTablaTO> getListaPrdLiquidacionTallaTablaTO(String empresa) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirListaPrdLiquidacionTalla_ListaPrdLiquidacionTallaTO(
                em.createNativeQuery("SELECT talla_codigo, talla_detalle FROM produccion.prd_liquidacion_talla "
                + "WHERE talla_empresa = ('" + empresa + "') ORDER BY talla_codigo").
                getResultList());
    }

    public List<produccion.TO.PrdLiquidacionTallaTablaTO> getListaPrdLiquidacionTallaTablaTO(String empresa, String codigo) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirListaPrdLiquidacionTalla_ListaPrdLiquidacionTallaTO(
                em.createNativeQuery("SELECT talla_codigo, talla_detalle FROM produccion.prd_liquidacion_talla "
                + "WHERE talla_empresa = ('" + empresa + "') AND ((talla_codigo LIKE '%" + codigo + "%') OR (talla_detalle LIKE '%" + codigo + "%')) ORDER BY talla_codigo").
                getResultList());
    }

    public produccion.TO.PrdLiquidacionProductoTO getPrdLiquidacionProductoTO(String empresa, produccion.TO.PrdLiquidacionProductoTablaTO liquidacionProductoTablaTO) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirPrdLiquidacionProducto_PrdLiquidacionProductoTO(prdLiquidacionProductoFacadeLocal.find(new produccion.entity.PrdLiquidacionProductoPK(empresa, liquidacionProductoTablaTO.getProdCodigo())));
    }

    public produccion.entity.PrdLiquidacionProducto getPrdLiquidacionProducto(String empresa, String codigo) throws Exception {
        return prdLiquidacionProductoFacadeLocal.find(new produccion.entity.PrdLiquidacionProductoPK(empresa, codigo));
    }

    public List<produccion.TO.PrdLiquidacionProductoTablaTO> getListaPrdLiquidacionProductoTablaTO(String empresa) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirListaPrdLiquidacionProducto_ListaPrdLiquidacionProductoTO(
                em.createNativeQuery("SELECT prod_codigo, prod_detalle, prod_tipo, prod_clase FROM produccion.prd_liquidacion_Producto "
                + "WHERE prod_empresa = ('" + empresa + "') AND prod_inactivo = ('f') ORDER BY prod_codigo").
                getResultList());
    }

    public List<produccion.TO.PrdLiquidacionProductoTablaTO> getListaPrdLiquidacionProductoTablaTO(String empresa, String codigo) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirListaPrdLiquidacionProducto_ListaPrdLiquidacionProductoTO(
                em.createNativeQuery("SELECT prod_codigo, prod_detalle, prod_tipo, prod_clase FROM produccion.prd_liquidacion_Producto "
                + "WHERE prod_empresa = ('" + empresa + "' ) AND prod_inactivo = 'f' AND ((prod_codigo LIKE '%" + codigo + "%') OR (prod_detalle LIKE '%" + codigo + "%'))  ORDER BY prod_codigo").
                getResultList());
    }

    public produccion.entity.PrdLiquidacion buscarPrdLiquidacion(String numEmpresa, String numMotivo, String numSecuencia) throws Exception {
        return prdLiquidacionFacadeLocal.find(new produccion.entity.PrdLiquidacionPK(numEmpresa, numMotivo, numSecuencia));
    }

    public int buscarConteoUltimaNumeracionLiquidacion(String empCodigo, String motCodigo) throws Exception {
        try {
            return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT num_secuencia FROM produccion.prd_liquidacion_numeracion "
                    + "WHERE num_empresa = ('" + empCodigo + "') AND num_motivo = ('" + motCodigo + "') ").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public Boolean comprobarPrdLiquidacionMotivo(String empresa, String motCodigo) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) FROM produccion.prd_liquidacion_motivo "
                + "WHERE lm_empresa = ('" + empresa + "') AND lm_codigo = ('" + motCodigo + "')").
                getResultList(), 0)[0].toString()) == 0) ? false : true;
    }

    public produccion.entity.PrdLiquidacionProducto buscarPrdLiquidacionProducto(String empresa, String codigoProducto) throws Exception {
        produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto = prdLiquidacionProductoFacadeLocal.find(new produccion.entity.PrdLiquidacionProductoPK(empresa, codigoProducto));
        return prdLiquidacionProducto != null ? produccion.helper.ConversionesProduccion.convertirPrdLiquidacionProducto_PrdLiquidacionProducto(prdLiquidacionProducto) : null;
    }

    public produccion.entity.PrdLiquidacionTalla buscarPrdLiquidacionTalla(String empresa, String codigo) throws Exception {
        return prdLiquidacionTallaFacadeLocal.find(new produccion.entity.PrdLiquidacionTallaPK(empresa, codigo));
    }

    public java.util.List<produccion.TO.PrdLiquidacionMotivoComboTO> getListaLiquidacionMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception {
        if (filtrarInactivos) {
            return produccion.helper.ConversionesProduccion.convertirListaLiquidacionMotivoCombo_ListaLiquidacionMotivoComboTO(em.createNativeQuery("SELECT lm_codigo, lm_detalle FROM produccion.prd_liquidacion_motivo "
                    + "WHERE lm_empresa = ('" + empresa + "') AND NOT lm_inactivo ORDER BY lm_codigo").getResultList());
        } else {
            return produccion.helper.ConversionesProduccion.convertirListaLiquidacionMotivoCombo_ListaLiquidacionMotivoComboTO(em.createNativeQuery("SELECT lm_codigo, lm_detalle FROM produccion.prd_liquidacion_motivo "
                    + "WHERE lm_empresa = ('" + empresa + "') ORDER BY lm_codigo").getResultList());
        }
    }

    public java.util.List<produccion.TO.PrdListaConsultaLiquidacionTO> getListaPrdConsultaLiquidacion(String empresa, String sector, String piscina, String busqueda) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirPrdListaConsultaLiquidacion_PrdListaConsultaLiquidacionTO(em.createNativeQuery("SELECT * FROM produccion.fun_liquidacion_listado('" + empresa + "', '" + sector + "', '" + piscina + "', '" + busqueda + "')").getResultList());
    }

    public produccion.TO.PrdEstadoCCCVT getEstadoCCCVT(String empresa, String motivoTipo, String numero) throws Exception {
        produccion.TO.PrdEstadoCCCVT prdEstadoCCVT = null;
        prdEstadoCCVT = produccion.helper.ConversionesProduccion.convertirPrdEstadoCCVTConsulta_PrdEstadoCCVT(em.createNativeQuery("SELECT liq_pendiente, liq_anulado FROM produccion.prd_liquidacion WHERE "
                + "liq_empresa = '" + empresa + "' AND liq_motivo = '" + motivoTipo + "' AND liq_numero = '" + numero + "'").getResultList());
        return prdEstadoCCVT;
    }

    public produccion.TO.PrdLiquidacionCabeceraTO getPrdLiquidacionCabeceraTO(String empresa, String motivo, String numeroLiquidacion) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirPrdLiquidacionCabecera_PrdLiquidacionCabeceraTO(em.createNativeQuery("SELECT liq_lote, SUBSTRING(liq_fecha::TEXT, 1, 10), liq_libras_enviadas, "
                + "liq_libras_recibidas, liq_libras_basura, liq_libras_retiradas, "
                + "liq_libras_netas, liq_libras_entero, liq_libras_cola, "
                + "liq_libras_cola_procesadas, liq_animales_cosechados, "
                + "liq_total_monto, liq_pendiente, liq_anulado, cli_empresa, "
                + "cli_codigo, pis_empresa, pis_sector, pis_numero, "
                + "usr_empresa, usr_codigo, usr_fecha_inserta "
                + "FROM produccion.prd_liquidacion "
                + "WHERE (prd_liquidacion.liq_empresa = '" + empresa + "') AND prd_liquidacion.liq_motivo = ('" + motivo + "') "
                + "AND prd_liquidacion.liq_numero = ('" + numeroLiquidacion + "')").getResultList());
    }

    public List<PrdListaDetalleLiquidacionTO> getListaPrdLiquidacionDetalleTO(String empresa, String motivo, String numero) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirPrdListaLiquidacionDetalle_PrdListaLiquidacionDetalleTO(em.createNativeQuery("SELECT * FROM produccion.fun_liquidacion_detalle('" + empresa
                + "', '" + motivo + "', '" + numero + "')").getResultList());
    }

    public Boolean comprobarPrdBalanceado(String empresa, String codigoPrincipal) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT COUNT(*) FROM inventario.inv_producto_medida "
                + "WHERE med_empresa = ('" + empresa + "') AND med_codigo = ('" + codigoPrincipal + "')").
                getResultList(), 0)[0].toString()) == 0) ? false : true;
    }

    public List<produccion.TO.PrdListaFunAnalisisPesosTO> getFunAnalisisPesos(String empresa, String sector, String fechaHasta) throws Exception {
        String sql ="SELECT * "
                + "FROM produccion.fun_analisis_pesos('" + empresa + "', '" + sector + "', " + fechaHasta + " )"; 
        List<PrdListaFunAnalisisPesosTO> lista = produccion.helper.ConversionesProduccion.convertirPrdListaFunAnalisisPesos_PrdListaFunAnalisisPesosTO(em.createNativeQuery(
                sql).getResultList());
        List<PrdListaFunAnalisisPesosComplementoTO> listaComplemento = produccion.helper.ConversionesProduccion.convertirPrdListaFunAnalisisPesosComplemento_PrdListaFunAnalisisPesosComplementoTO(em.createNativeQuery(
                "SELECT * "
                + "FROM produccion.fun_analisis_pesos_complemento('" + empresa + "', '" + sector + "', " + fechaHasta + " )").getResultList());

    
        String fechaAuxiliar = "";
        Integer ncolumnas = 0;
        String piscina = "";


        for (PrdListaFunAnalisisPesosComplementoTO prdPesoComplemento :
                listaComplemento) {

            if (!fechaAuxiliar.equals(prdPesoComplemento.getApFecha())) {
                if (fechaAuxiliar.equals("Inc. Promedio")) {
                    ncolumnas = 5;
                } else {
                    ncolumnas++;
                }
            }

            for (PrdListaFunAnalisisPesosTO prdPeso : lista) {
                if (prdPeso.getApSector().equals(prdPesoComplemento.getApSector())
                        && prdPeso.getApPiscina().equals(prdPesoComplemento.getApPiscina())
                        && prdPeso.getApCorrida().equals(prdPesoComplemento.getApCorrida())) {
                    if (ncolumnas == 1) {
                        prdPeso.setApPesoIncrementoSemana4(prdPesoComplemento.getApIncremento());
                    } else if (ncolumnas == 2) {
                        prdPeso.setApPesoIncrementoSemana3(prdPesoComplemento.getApIncremento());
                    } else if (ncolumnas == 3) {
                        prdPeso.setApPesoIncrementoSemana2(prdPesoComplemento.getApIncremento());
                    } else if (ncolumnas == 4) {
                        prdPeso.setApPesoIncrementoSemana1(prdPesoComplemento.getApIncremento());
                    } else if (ncolumnas == 5) {
                        prdPeso.setApPesoIncrementoPromedio(prdPesoComplemento.getApIncremento());
                    }
                    break;
                }
            }
            fechaAuxiliar = prdPesoComplemento.getApFecha();
        }
        return lista;
    }

    public List<String> getFunFechaSemanas(String empresa, String sector, String fechaHasta) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirFechaSemanas(em.createNativeQuery(
                "SELECT ap_fecha "
                + "FROM produccion.fun_analisis_pesos_complemento('" + empresa + "', '" + sector + "', " + fechaHasta + " ) WHERE ap_fecha!='Inc. Promedio' GROUP BY ap_fecha ORDER BY  ap_fecha DESC").getResultList());
    }

    @Override
    public java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> getListaConsultaGrameajePromedioPorPiscinaTOs(String empresa, String sector) throws Exception {
        return produccion.helper.ConversionesProduccion.convertirPrdListaConsultaGrameajePromedioPorPiscina_PrdListaConsultaGrameajePromedioPorPiscinaTO(em.createNativeQuery("SELECT gra_fecha, gra_piscina, cor_fecha_siembra, (current_date - "
                + "cor_fecha_siembra + 1) AS gra_edad, gra_tpromedio "
                + "   FROM produccion.prd_corrida INNER JOIN produccion.prd_grameaje "
                + "     ON prd_corrida.pis_empresa = prd_grameaje.pis_empresa AND "
                + "        prd_corrida.pis_sector = prd_grameaje.pis_sector AND "
                + "        prd_corrida.pis_numero = prd_grameaje.pis_numero AND "
                + "      ((gra_fecha >= prd_corrida.cor_fecha_desde AND gra_fecha <= "
                + "prd_corrida.cor_fecha_hasta) OR "
                + "       (gra_fecha >= prd_corrida.cor_fecha_desde AND "
                + "prd_corrida.cor_fecha_hasta IS NULL)) "
                + "   WHERE gra_empresa='" + empresa + "' AND "
                + "         gra_sector='" + sector + "' AND "
                + "         prd_corrida.cor_fecha_hasta IS NULL "
                + "   ORDER BY 1,2;").getResultList());
    }
}