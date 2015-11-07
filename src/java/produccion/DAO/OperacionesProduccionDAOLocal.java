/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produccion.DAO;

import java.util.List;
import javax.ejb.Local;
import produccion.TO.*;
import produccion.entity.*;

/**
 *
 * @author misael
 */
@Local
public interface OperacionesProduccionDAOLocal {
    PrdSector buscarSector(String empCodigo, String secCodigo) throws Exception;
    PrdPiscina buscarPiscina(String empCodigo, String secCodigo, String pisNumero) throws Exception;
    public PrdVehiculos buscarVehiculos(String empCodigo, String secCodigo, String pisNumero) throws Exception;
    PrdCorrida buscarCorrida(String empCodigo, String secCodigo, String pisNumero, String numCorrida) throws Exception;
    PrdGrameaje buscarGrameaje(String empCodigo, String secCodigo, String pisNumero, String fecha) throws Exception;
    PrdSobrevivencia buscarSobrevivencia(int codSobrevivencia) throws Exception;

    boolean eliminarPrdSector(PrdSectorTO prdSectorTO) throws Exception;
    List<PrdListaSectorTO> getListaSector(String empresa, boolean activo) throws Exception;

    boolean eliminarPrdPiscina(PrdPiscinaTO prdPiscinaTO) throws Exception;
    List<PrdListaPiscinaTO> getListaPiscina(String empresa, String sector) throws Exception;
    List<PrdListaPiscinaComboTO> getListaPiscina(String empresa,boolean activo) throws Exception;
    List<PrdListaPiscinaTO> getListaPiscinaBusqueda(String empresa, String sector, String fecha) throws Exception;
    List<PrdComboPiscinaTO> getComboPiscina(String empresa, String sector) throws Exception;

    boolean eliminarPrdCorrida(PrdCorridaTO prdCorridaTO) throws Exception;
    List<PrdListaCorridaTO> getListaCorrida(String empresa, String sector, String piscina) throws Exception;
    List<PrdListaCorridaTO> getListaCorrida(
            String empresa, 
            String sector, 
            String piscina, 
            String corrida) throws Exception;
    
    PrdFunAnalisisVentasTO getPrdFunAnalisisVentasTO(
            String empresa, 
            String sector, 
            String piscina, 
            String fechaDesde, 
            String fechaHasta) throws Exception;
    
    java.util.List<produccion.TO.PrdListaCostosDetalleCorridaTO> getPrdListaCostosDetalleCorridaTO(java.lang.String empresa, java.lang.String sector, java.lang.String piscina, java.lang.String desde, java.lang.String hasta, java.lang.String agrupadoPor) throws java.lang.Exception;
    List<PrdComboCorridaTO> getComboPrdCorrida(String empresa, String sector, String piscina) throws Exception;

    List<PrdResumenCorridaTO> getListaResumenCorridaTO(String empresa, String sector, String desde, String hasta, String tipoResumen) throws Exception;
    String consultarFechaMaxMin(String empresa, String tipoResumen) throws Exception;

    List<PrdListaSobrevivenciaTO> getListaSobrevivencia(String empresa, String sector) throws Exception;

    boolean getIsFechaGrameajeSuperior(String empresa, String sector, String numPiscina, String fecha) throws Exception;
    List<produccion.TO.PrdListadoGrameajeTO> getPrdListadoGrameajeTO(String empresa, String sector, String piscina, String desde, String hasta) throws Exception;

    java.util.List<produccion.TO.PrdCostoDetalleFechaTO> getPrdListadoCostoDetalleFechaTO(java.lang.String empresa, java.lang.String secCodigo, java.lang.String desde, java.lang.String hasta, java.lang.String agrupadoPor) throws java.lang.Exception;

    java.util.List<produccion.entity.PrdCorrida> buscarTodasCorrida(String empresa) throws Exception;

    java.util.List<produccion.entity.PrdCorrida> buscarTodasCorridaPorFecha(String empresa, String fecha) throws Exception;

    void ponerCorridaFalse(String empresa) throws Exception;

    java.util.List<produccion.TO.CostoDetalleMultipleCorridaTO> getCostoDetalleMultipleCorridaTO(String empresa, String hasta, java.lang.String agrupadoPor) throws Exception;

    produccion.TO.PrdCorridaTO getPrdCorridaTO(String empresa, String sector, String piscina, String fecha) throws Exception;

    produccion.TO.PrdGrameajeTO getPrdGrameajeTO(String empresa, String sector, String piscina, String fecha) throws Exception;
    produccion.TO.PrdGrameajeTO getPrdGrameajeTO(String empresa, String sector, String piscina, String desde, String hasta) throws Exception;

    java.util.List<produccion.TO.MultiplePiscinaCorrida> getCostoDetallePersonalizado(String empresa, String sector, String fecha);

    java.util.List<produccion.TO.PrdCostoPorFechaProrrateadoTO> getCostoPorFechaProrrateado(String empresa, String codigoSector, String fechaInicio, String fechaFin, java.lang.String agrupadoPor) throws Exception;

    java.util.List<produccion.TO.PrdFunCostosPorFechaSimpleTO> getPrdFunCostosPorFechaSimpleTO(
            String codigoSector, 
            String fechaInicio, 
            String fechaFin, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<produccion.TO.PrdCostoPorPiscinaSemanalTO> getCostoPorPorPiscinaSemanal(java.lang.String empresa, java.lang.String codigoSector, java.lang.String numeroPiscina, java.lang.String fechaInicio, java.lang.String fechaFin, java.lang.String agrupadoPor) throws java.lang.Exception;

    java.util.List<produccion.TO.PrdConsumoPorFechaDesglosadoTO> getConsumoPorFechaDesglosado(java.lang.String empresa, java.lang.String codigoSector, java.lang.String fechaInicio, java.lang.String fechaFin) throws java.lang.Exception;

    java.util.List<produccion.TO.PrdConsumoProductoEnProcesoTO> getConsumoProductosProceso(java.lang.String empresa, java.lang.String fecha) throws java.lang.Exception;

    java.util.List<produccion.TO.PrdConsumoMultiplePiscinaTO> getConsumoMultiplePiscina(java.lang.String empresa) throws java.lang.Exception;
    
    java.util.List<produccion.TO.PrdConsumosTO> getPrdConsumosFechaTO(String empresa, String sector, String fechaDesde, String fechaHasta) throws Exception;
    java.util.List<produccion.TO.PrdConsumosTO> getPrdConsumosPiscinaTO(java.lang.String empresa, java.lang.String sector, java.lang.String piscina, java.lang.String fechaDesde, java.lang.String fechaHasta) throws java.lang.Exception;

    java.util.List<produccion.TO.PrdConsumosPorPiscinaPeriodoTO> getConsumoPorPiscinaPeriodo(java.lang.String empresa, java.lang.String codigoSector, java.lang.String numeroPiscina, java.lang.String fechaInicio, java.lang.String fechaFin, java.lang.String periodo) throws java.lang.Exception;

    java.util.List<produccion.TO.PrdListaSectorConHectareajeTO> getListaSectorConHectareaje(java.lang.String empresa, java.lang.String fecha) throws java.lang.Exception;

    java.util.List<produccion.TO.PrdResumenFinancieroTO> getPrdResumenFinancieroTO(java.lang.String empresa, java.lang.String secCodigo, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception;
    
    java.util.List<produccion.TO.PrdResumenPescaTO> getResumenPesca(String empresa, String codigoSector, String fechaInicio, String fechaFin) throws Exception;
    
    java.util.List<produccion.TO.PrdResumenSiembraTO> getResumenSiembra(String empresa, String codigoSector, String fechaInicio, String fechaFin) throws Exception;
    
    PrdLiquidacionMotivoTO getPrdLiquidacionMotivoTO(String empresa, PrdLiquidacionMotivoTablaTO prdLiquidacionMotivoTablaTO) throws Exception;
    
    produccion.entity.PrdLiquidacionMotivo getPrdLiquidacionMotivo(String empresa, String codigo) throws Exception;
    
    List<produccion.TO.PrdLiquidacionMotivoTablaTO> getListaPrdLiquidacionMotivoTablaTO(String empresa) throws Exception;
    
    PrdLiquidacionTallaTO getPrdLiquidacionTallaTO(String empresa, PrdLiquidacionTallaTablaTO prdLiquidacionTallaTablaTO) throws Exception;
    
    produccion.entity.PrdLiquidacionTalla getPrdLiquidacionTalla(String empresa, String codigo) throws Exception;
    
    List<produccion.TO.PrdLiquidacionTallaTablaTO> getListaPrdLiquidacionTallaTablaTO(String empresa) throws Exception;
    
    List<produccion.TO.PrdLiquidacionTallaTablaTO> getListaPrdLiquidacionTallaTablaTO(String empresa,String codigo) throws Exception;
    
    PrdLiquidacionProductoTO getPrdLiquidacionProductoTO(String empresa, PrdLiquidacionProductoTablaTO prdLiquidacionProductoTablaTO) throws Exception;
    
    produccion.entity.PrdLiquidacionProducto getPrdLiquidacionProducto(String empresa, String codigo) throws Exception;
    
    List<produccion.TO.PrdLiquidacionProductoTablaTO> getListaPrdLiquidacionProductoTablaTO(String empresa) throws Exception;
    
    List<produccion.TO.PrdLiquidacionProductoTablaTO> getListaPrdLiquidacionProductoTablaTO(String empresa, String codigo) throws Exception;
    
    produccion.entity.PrdLiquidacion buscarPrdLiquidacion(String numEmpresa, String numMotivo, String numSecuencia) throws Exception;
    
    int buscarConteoUltimaNumeracionLiquidacion(String empCodigo, String motCodigo) throws Exception;
    
    Boolean comprobarPrdLiquidacionMotivo(String empresa, String motCodigo) throws Exception;
    
    produccion.entity.PrdLiquidacionProducto buscarPrdLiquidacionProducto(String empresa, String codigoProducto) throws Exception;
    
    produccion.entity.PrdLiquidacionTalla buscarPrdLiquidacionTalla(String empresa, String codigo) throws Exception;
    
    java.util.List<produccion.TO.PrdLiquidacionMotivoComboTO> getListaLiquidacionMotivoComboTO(String empresa, boolean filtrarInactivos) throws Exception;
    
    java.util.List<produccion.TO.PrdListaConsultaLiquidacionTO> getListaPrdConsultaLiquidacion(String empresa, String sector, String piscina, String busqueda) throws Exception;
    
    produccion.TO.PrdEstadoCCCVT getEstadoCCCVT(String empresa, String motivoTipo, String numero) throws Exception;
    
    produccion.TO.PrdLiquidacionCabeceraTO getPrdLiquidacionCabeceraTO(String empresa, String motivo, String numeroLiquidacion) throws Exception;
    
    java.util.List<produccion.TO.PrdListaDetalleLiquidacionTO> getListaPrdLiquidacionDetalleTO(String empresa, String motivo, String numero) throws Exception;
    
    java.util.List<produccion.TO.PrdListaFunAnalisisPesosTO> getFunAnalisisPesos(String empresa, String sector, String fecha) throws Exception;
    
    List<String> getFunFechaSemanas(String empresa, String sector, String fecha) throws Exception;
    
    Boolean comprobarPrdBalanceado(String empresa, String codigoPrincipal) throws Exception;
    java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> getListaConsultaGrameajePromedioPorPiscinaTOs(String empresa, String sector) throws Exception ;
}
