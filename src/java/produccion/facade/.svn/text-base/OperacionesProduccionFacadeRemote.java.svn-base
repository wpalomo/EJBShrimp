/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produccion.facade;

import java.util.List;
import javax.ejb.Remote;
import net.sf.jasperreports.engine.JasperPrint;
import produccion.TO.*;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author misael
 */
@Remote
public interface OperacionesProduccionFacadeRemote {

    boolean insertarPrdSector(
            PrdSectorTO prdSectorTO, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    boolean modificarPrdSector(
            PrdSectorTO prdSectorTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    boolean eliminarPrdSector(
            PrdSectorTO prdSectorTO, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    List<PrdListaSectorTO> getListaSectorTO(
            String empresa, 
            boolean activo) throws Exception;
    boolean insertarPrdPiscina(
            PrdPiscinaTO prdPiscinaTO, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    boolean modificarPrdPiscina(
            PrdPiscinaTO prdPiscinaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    boolean eliminarPrdPiscina(
            PrdPiscinaTO prdPiscinaTO, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    List<PrdListaPiscinaTO> getListaPiscinaTO(
            String empresa, 
            String sector) throws Exception;
    List<PrdListaPiscinaComboTO> getListaPiscinaTO(
            String empresa,
            boolean activo) throws Exception;
    List<PrdListaPiscinaTO> getListaPiscinaTOBusqueda(
            String empresa, 
            String sector, 
            String fecha) throws Exception;
    List<PrdComboPiscinaTO> getComboPrdPiscinaTO(
            String empresa, 
            String sector) throws Exception;
    List<PrdComboCorridaTO> getComboPrdCorridaTO(
            String empresa, 
            String sector, 
            String piscina) throws Exception;
    java.lang.String accionPrdCorrida(
            produccion.TO.PrdCorridaTO prdCorridaTO, 
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;
    List<PrdListaCorridaTO> getListaCorridaTO(
            String empresa, 
            String sector, 
            String piscina) throws Exception;
    List<PrdListaCorridaTO> getListaCorridaTO(
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
    java.util.List<produccion.TO.PrdListaCostosDetalleCorridaTO> getPrdListaCostosDetalleCorridaTO(
            java.lang.String empresa, 
            java.lang.String sector, 
            java.lang.String piscina, 
            java.lang.String desde, 
            java.lang.String hasta, 
            java.lang.String agrupadoPor) throws java.lang.Exception;
    List<PrdResumenCorridaTO> getListaResumenCorridaTO(
            String empresa, 
            String sector, 
            String desde, 
            String hasta, 
            String tipoResumen) throws Exception;
    String consultarFechaMaxMin(
            String empresa, 
            String tipoResumen) throws Exception;
    boolean insertarPrdSobrevivencia(
            PrdSobrevivenciaTO prdSobrevivenciaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    boolean modificarPrdSobrevivencia(
            PrdSobrevivenciaTO prdSobrevivenciaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    boolean eliminarPrdSobrevivencia(
            PrdSobrevivenciaTO prdSobrevivenciaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    List<PrdListaSobrevivenciaTO> getListaSobrevivenciaTO(
            String empresa, 
            String sector) throws Exception;
    boolean getIsFechaGrameajeSuperior(
            String empresa, 
            String sector,
            String numPiscina, 
            String fecha) throws Exception;
    boolean insertarPrdGrameaje(
            PrdGrameajeTO prdGrameajeTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    String eliminarPrdGrameaje(
            produccion.TO.PrdGrameajeTO prdGrameajeTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    List<produccion.TO.PrdListadoGrameajeTO> getPrdListadoGrameajeTO(
            String empresa, 
            String sector, 
            String piscina, 
            String desde, 
            String hasta) throws Exception;
    java.util.List<produccion.TO.PrdCostoDetalleFechaTO> getPrdListadoCostoDetalleFechaTO(
            java.lang.String empresa, 
            java.lang.String secCodigo, 
            java.lang.String desde, 
            java.lang.String hasta, 
            java.lang.String agrupadoPor) throws java.lang.Exception;
    public boolean insertarPrdLiquidacionLotesValorizada(
            LiquidacionLotesValorizadaTO liquidacionLotesValorizadaTO, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    helper.RetornoTO modificarBooleanoCorrida(
            String empresa, 
            java.util.List<produccion.TO.MultiplePiscinaCorrida> multiplePiscinaCorrida, 
            String usuario, 
            String hasta, 
            String proceso, 
            java.lang.String agrupadoPor,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    produccion.TO.PrdCorridaTO getPrdCorridaTO(
            String empresa, 
            String sector, 
            String piscina, 
            String fecha) throws Exception;
    produccion.TO.PrdGrameajeTO getPrdGrameajeTO(
            String empresa, 
            String sector, 
            String piscina, 
            String fecha) throws Exception;
    produccion.TO.PrdGrameajeTO getPrdGrameajeTO(
            String empresa, 
            String sector, 
            String piscina, 
            String desde,
            String hasta) throws Exception;
    java.util.List<produccion.TO.MultiplePiscinaCorrida> getCostoDetallePersonalizado(
            String empresa, 
            String sector, 
            String fecha);
    helper.RetornoTO getCostoPorFechaProrrateado(
            java.lang.String empresa, 
            java.lang.String codigoSector, 
            java.lang.String fechaInicio, 
            java.lang.String fechaFin, 
            java.lang.String usuario, 
            java.lang.String agrupadoPor,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;
    java.util.List<produccion.TO.PrdFunCostosPorFechaSimpleTO> getPrdFunCostosPorFechaSimpleTO(
            String codigoSector, 
            String fechaInicio, 
            String fechaFin, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    helper.RetornoTO getCostoPorPiscinaSemanal(
            java.lang.String empresa, 
            java.lang.String codigoSector, 
            java.lang.String numeroPiscina, 
            java.lang.String fechaInicio,
            java.lang.String fechaFin, 
            java.lang.String usuario, 
            java.lang.String agrupadoPor,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;
    helper.RetornoTO getConsumoPorFechaDesglosado(
            java.lang.String empresa, 
            java.lang.String codigoSector, 
            java.lang.String fechaInicio, 
            java.lang.String fechaFin, 
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;
    helper.RetornoTO getConsumoProductosProceso(
            java.lang.String empresa, 
            java.lang.String fecha, 
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;
    java.util.List<produccion.TO.PrdConsumosTO> getPrdConsumosFechaTO(
            String empresa, 
            String sector, 
            String fechaDesde, 
            String fechaHasta) throws Exception;
    java.util.List<produccion.TO.PrdConsumosTO> getPrdConsumosPiscinaTO(
            java.lang.String empresa, 
            java.lang.String sector, 
            java.lang.String piscina, 
            java.lang.String fechaDesde, 
            java.lang.String fechaHasta) throws java.lang.Exception;
    helper.RetornoTO getConsumoPorPiscinaPeriodo(
            java.lang.String empresa, 
            java.lang.String codigoSector, 
            java.lang.String numeroPiscina, 
            java.lang.String fechaInicio, 
            java.lang.String fechaFin, 
            java.lang.String periodo, 
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;
    java.util.List<produccion.TO.PrdListaSectorConHectareajeTO> getListaSectorConHectareaje(
            java.lang.String empresa, 
            java.lang.String fecha) throws java.lang.Exception;
    java.util.List<produccion.TO.PrdResumenFinancieroTO> getPrdResumenFinancieroTO(
            java.lang.String empresa, 
            java.lang.String secCodigo, 
            java.lang.String desde, 
            java.lang.String hasta) throws java.lang.Exception;
    helper.RetornoTO getResumenPesca(
            String empresa, 
            String codigoSector, 
            String fechaInicio, 
            String fechaFin, 
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    helper.RetornoTO getResumenSiembra(
            String empresa, 
            String codigoSector, 
            String fechaInicio, 
            String fechaFin, 
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    produccion.TO.PrdLiquidacionMotivoTO getPrdLiquidacionMotivoTO(
            String empresa, 
            produccion.TO.PrdLiquidacionMotivoTablaTO prdLiquidacionMotivoTablaTO) throws Exception;
    java.util.List<produccion.TO.PrdLiquidacionMotivoTablaTO> getListaPrdLiquidacionMotivoTablaTO(
            String empresa) throws Exception;
    String insertarPrdLiquidacionMotivoTO(
            produccion.TO.PrdLiquidacionMotivoTO prdLiquidacionMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    String modificarPrdLiquidacionMotivoTO(
            produccion.TO.PrdLiquidacionMotivoTO prdLiquidacionMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    produccion.TO.PrdLiquidacionTallaTO getPrdLiquidacionTallaTO(
            String empresa, 
            produccion.TO.PrdLiquidacionTallaTablaTO prdLiquidacionTallaTablaTO) throws Exception;
    java.util.List<produccion.TO.PrdLiquidacionTallaTablaTO> getListaPrdLiquidacionTallaTablaTO(
            String empresa) throws Exception;
    java.util.List<produccion.TO.PrdLiquidacionTallaTablaTO> getListaPrdLiquidacionTallaTablaTO(
            String empresa,
            String codigo) throws Exception;
    String insertarPrdLiquidacionTallaTO(
            produccion.TO.PrdLiquidacionTallaTO prdLiquidacionTallaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    String modificarPrdLiquidacionTallaTO(
            produccion.TO.PrdLiquidacionTallaTO prdLiquidacionTallaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    produccion.TO.PrdLiquidacionProductoTO getPrdLiquidacionProductoTO(
            String empresa, 
            produccion.TO.PrdLiquidacionProductoTablaTO prdLiquidacionProductoTablaTO) throws Exception;
    java.util.List<produccion.TO.PrdLiquidacionProductoTablaTO> getListaPrdLiquidacionProductoTablaTO(
            String empresa) throws Exception;
    java.util.List<produccion.TO.PrdLiquidacionProductoTablaTO> getListaPrdLiquidacionProductoTablaTO(
            String empresa,
            String codigo) throws Exception;
    String insertarPrdLiquidacionProductoTO(
            produccion.TO.PrdLiquidacionProductoTO prdLiquidacionProductoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    String modificarPrdLiquidacionProductoTO(
            produccion.TO.PrdLiquidacionProductoTO prdLiquidacionProductoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    String insertarPrdLiquidacionTO(
            produccion.TO.PrdLiquidacionTO prdLiquidacionTO,
            java.util.List<produccion.TO.PrdLiquidacionDetalleTO> listaPrdLiquidacionDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    String modificarPrdLiquidacionTO(
            produccion.TO.PrdLiquidacionTO prdLiquidacionTO,
            java.util.List<produccion.TO.PrdLiquidacionDetalleTO> listaPrdLiquidacionDetalleTO,
            java.util.List<produccion.TO.PrdLiquidacionDetalleTO> listaPrdLiquidacionEliminarDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    java.util.List<produccion.TO.PrdLiquidacionMotivoComboTO> getListaLiquidacionMotivoComboTO(
            String empresa, 
            boolean filtrarInactivos) throws Exception;
    java.util.List<produccion.TO.PrdListaConsultaLiquidacionTO> getListaPrdConsultaLiquidacion(
            String empresa, 
            String sector, 
            String piscina, 
            String busqueda) throws Exception;
    produccion.TO.PrdEstadoCCCVT getEstadoCCCVT(
            String empresa, 
            String motivoTipo, 
            String numero) throws Exception;
    produccion.TO.PrdLiquidacionCabeceraTO getPrdLiquidacionCabeceraTO(
            String empresa, 
            String motivo, 
            String numeroLiquidacion) throws Exception;
    java.util.List<produccion.TO.PrdListaFunAnalisisPesosTO> getFunAnalisisPesos(
            String empresa, 
            String sector, 
            String fecha) throws Exception;
    List<String> getFunFechaSemanas(
            String empresa, 
            String sector, 
            String fecha) throws Exception;
    java.util.List<produccion.TO.PrdListaDetalleLiquidacionTO> getListaPrdLiquidacionDetalleTO(
            String empresa, 
            String motivo, 
            String numero) throws Exception;
    java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> getListaConsultaGrameajePromedioPorPiscinaTOs(
            String empresa, 
            String sector) throws Exception;
    helper.RetornoTO getConsultaGrameajePromedioPorPiscina(
            String empresa, 
            String sector,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    JasperPrint generarReporteListadoGramaje(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String codigoSector, String codigoPiscina, String codigoCorrida, String fechaDesde, 
            String fechaHasta, List<PrdListadoGrameajeTO> prdListadoGrameajeTO) throws Exception;

    JasperPrint generarReporteListadoFunAnalisisPesos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String codigoSector, String fechaHasta, 
            List<PrdListaFunAnalisisPesosTO> prdListaFunAnalisisPesosTO) throws Exception;

    JasperPrint generarReporteConsumoFecha(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String secCodigo, String fechaDesde, 
            String fechaHasta, 
            List<PrdConsumosTO> prdConsumosTO)throws Exception;

    JasperPrint generarReporteConsumoPiscina(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            String codigoSector, String codigoPiscina, 
            String numeroCorrida, String hectareas, 
            Integer numLarvas, String fechaDesde, 
            String fechaHasta, List<PrdConsumosTO> prdConsumosTO)throws Exception;

    JasperPrint generarReporteEconomicoPorFechas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, 
            String fechaHasta, 
            List<PrdCostoDetalleFechaTO> listaPrdCostoDetalleFechaTO)throws Exception;

    JasperPrint generarReporteEconomicoPorPiscinas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String codigoSector, 
            String codigoPiscina, String codigoCorrida, String hectareas, 
            Integer numLarvas, String fechaDesde, String fechaHasta, 
            List<PrdListaCostosDetalleCorridaTO> prdListaCostosDetalleCorridaTO)throws Exception;

    JasperPrint generarReporteResumenSiembra(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            Object[][] datos)throws Exception;

    JasperPrint generarReporteResumenSiembra(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<PrdResumenCorridaTO> listaPrdListaResumenCorridaTO)throws Exception;

    JasperPrint generarResumenPesca(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<PrdResumenCorridaTO> listaPrdListaResumenCorridaTO)throws Exception;

    JasperPrint generarReporteResumenPescaEconomico(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, Object[][] datos)throws Exception;

   
}
