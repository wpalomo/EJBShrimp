/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.facade;

import java.util.List;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import produccion.TO.*;
import produccion.business.OperacionesProduccionBusinessLocal;
import produccion.reporte.GenerarReporteProduccionLocal;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesProduccionFacade implements OperacionesProduccionFacadeRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @javax.ejb.EJB
    OperacionesProduccionBusinessLocal operacionesBusinessLocal;
    //@javax.ejb.Transa
    @javax.ejb.EJB
    GenerarReporteProduccionLocal generarReporteProduccionLocal;

    // <editor-fold defaultstate="collapsed" desc="SECTOR">
    @Override
    public boolean insertarPrdSector(
            PrdSectorTO prdSectorTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.insertarPrdSector(prdSectorTO, sisInfoTO);
    }

    @Override
    public boolean modificarPrdSector(
            PrdSectorTO prdSectorTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.modificarPrdSector(prdSectorTO, sisInfoTO);
    }

    @Override
    public boolean eliminarPrdSector(
            PrdSectorTO prdSectorTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.eliminarPrdSector(prdSectorTO, sisInfoTO);
    }

    @Override
    public List<PrdListaSectorTO> getListaSectorTO(String empresa, boolean activo) throws Exception {
        return operacionesBusinessLocal.getListaSectorTO(empresa, activo);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PISCINA">
    @Override
    public boolean insertarPrdPiscina(
            PrdPiscinaTO prdPiscinaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.insertarPrdPiscina(prdPiscinaTO, sisInfoTO);
    }

    @Override
    public boolean modificarPrdPiscina(
            PrdPiscinaTO prdPiscinaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.modificarPrdPiscina(prdPiscinaTO, sisInfoTO);
    }

    @Override
    public boolean eliminarPrdPiscina(
            PrdPiscinaTO prdPiscinaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.eliminarPrdPiscina(prdPiscinaTO, sisInfoTO);
    }

    @Override
    public List<PrdListaPiscinaTO> getListaPiscinaTO(
            String empresa,
            String sector) throws Exception {
        return operacionesBusinessLocal.getListaPiscinaTO(empresa, sector);
    }

    @Override
    public List<PrdListaPiscinaComboTO> getListaPiscinaTO(
            String empresa,
            boolean activo) throws Exception {
        return operacionesBusinessLocal.getListaPiscinaTO(empresa, activo);
    }

    @Override
    public List<PrdListaPiscinaTO> getListaPiscinaTOBusqueda(
            String empresa,
            String sector,
            String fecha) throws Exception {
        return operacionesBusinessLocal.getListaPiscinaTOBusqueda(empresa, sector, fecha);
    }

    @Override
    public List<PrdComboPiscinaTO> getComboPrdPiscinaTO(
            String empresa,
            String sector) throws Exception {
        return operacionesBusinessLocal.getComboPiscinaTO(empresa, sector);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CORRIDA">
    @Override
    public String accionPrdCorrida(
            PrdCorridaTO prdCorridaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.accionPrdCorrida(prdCorridaTO, accion, sisInfoTO);
    }

    @Override
    public List<PrdListaCorridaTO> getListaCorridaTO(
            String empresa,
            String sector,
            String piscina) throws Exception {
        return operacionesBusinessLocal.getListaCorridaTO(empresa, sector, piscina);
    }

    @Override
    public List<PrdListaCorridaTO> getListaCorridaTO(
            String empresa,
            String sector,
            String piscina,
            String corrida) throws Exception {
        return operacionesBusinessLocal.getListaCorridaTO(empresa, sector, piscina, corrida);
    }

    @Override
    public PrdFunAnalisisVentasTO getPrdFunAnalisisVentasTO(
            String empresa,
            String sector,
            String piscina,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesBusinessLocal.getPrdFunAnalisisVentasTO(empresa, sector, piscina, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<produccion.TO.PrdListaCostosDetalleCorridaTO> getPrdListaCostosDetalleCorridaTO(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String piscina,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String agrupadoPor) throws java.lang.Exception {
        return operacionesBusinessLocal.getPrdListaCostosDetalleCorridaTO(empresa, sector, piscina, desde, hasta, agrupadoPor);
    }

    @Override
    public List<PrdComboCorridaTO> getComboPrdCorridaTO(
            String empresa,
            String sector,
            String piscina) throws Exception {
        return operacionesBusinessLocal.getComboPrdCorridaTO(empresa, sector, piscina);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS RESUMEN CORRIDA">

    @Override
    public List<PrdResumenCorridaTO> getListaResumenCorridaTO(
            String empresa,
            String sector,
            String desde,
            String hasta,
            String tipoResumen) throws Exception {
        return operacionesBusinessLocal.getListaResumenCorridaTO(empresa, sector, desde, hasta, tipoResumen);
    }

    @Override
    public String consultarFechaMaxMin(
            String empresa,
            String tipoResumen) throws Exception {
        return operacionesBusinessLocal.consultarFechaMaxMin(empresa, tipoResumen);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SOBREVIVENCIA">
    @Override
    public boolean insertarPrdSobrevivencia(
            PrdSobrevivenciaTO prdSobrevivenciaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.insertarPrdSobrevivencia(prdSobrevivenciaTO, sisInfoTO);
    }

    @Override
    public boolean modificarPrdSobrevivencia(
            PrdSobrevivenciaTO prdSobrevivenciaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.modificarPrdSobrevivencia(prdSobrevivenciaTO, sisInfoTO);
    }

    @Override
    public boolean eliminarPrdSobrevivencia(
            PrdSobrevivenciaTO prdSobrevivenciaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.eliminarPrdSobrevivencia(prdSobrevivenciaTO, sisInfoTO);
    }

    @Override
    public List<PrdListaSobrevivenciaTO> getListaSobrevivenciaTO(
            String empresa,
            String sector) throws Exception {
        return operacionesBusinessLocal.getListaSobrevivenciaTO(empresa, sector);
    }
    // </editor-fold>

    @Override
    public boolean getIsFechaGrameajeSuperior(
            String empresa,
            String sector,
            String numPiscina,
            String fecha) throws Exception {
        return operacionesBusinessLocal.getIsFechaGrameajeSuperior(empresa, sector, numPiscina, fecha);
    }

    @Override
    public boolean insertarPrdGrameaje(
            PrdGrameajeTO prdGrameajeTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.insertarPrdGrameaje(prdGrameajeTO, sisInfoTO);
    }

    @Override
    public String eliminarPrdGrameaje(
            produccion.TO.PrdGrameajeTO prdGrameajeTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.eliminarPrdGrameaje(prdGrameajeTO, sisInfoTO);
    }

    @Override
    public List<produccion.TO.PrdListadoGrameajeTO> getPrdListadoGrameajeTO(
            String empresa,
            String sector,
            String piscina,
            String desde,
            String hasta) throws Exception {
        return operacionesBusinessLocal.getPrdListadoGrameajeTO(empresa, sector, piscina, desde, hasta);
    }

    @Override
    public List<produccion.TO.PrdCostoDetalleFechaTO> getPrdListadoCostoDetalleFechaTO(
            String empresa,
            java.lang.String secCodigo,
            String desde,
            String hasta,
            java.lang.String agrupadoPor) throws Exception {
        return operacionesBusinessLocal.getPrdListadoCostoDetalleFechaTO(empresa, secCodigo, desde, hasta, agrupadoPor);
    }

    @Override
    public boolean insertarPrdLiquidacionLotesValorizada(LiquidacionLotesValorizadaTO liquidacionLotesValorizadaTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.insertarPrdLiquidacionLotesValorizada(liquidacionLotesValorizadaTO, sisInfoTO);
    }

    @Override
    public helper.RetornoTO modificarBooleanoCorrida(
            String empresa,
            java.util.List<produccion.TO.MultiplePiscinaCorrida> multiplePiscinaCorrida,
            String usuario,
            String hasta,
            String proceso,
            java.lang.String agrupadoPor,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.modificarBooleanoCorrida(empresa, multiplePiscinaCorrida, usuario, hasta, proceso, agrupadoPor, sisInfoTO);
    }

    @Override
    public produccion.TO.PrdCorridaTO getPrdCorridaTO(
            String empresa,
            String sector,
            String piscina,
            String fecha) throws Exception {
        return operacionesBusinessLocal.getPrdCorridaTO(empresa, sector, piscina, fecha);
    }

    @Override
    public produccion.TO.PrdGrameajeTO getPrdGrameajeTO(
            String empresa,
            String sector,
            String piscina,
            String fecha) throws Exception {
        return operacionesBusinessLocal.getPrdGrameajeTO(empresa, sector, piscina, fecha);
    }

    @Override
    public produccion.TO.PrdGrameajeTO getPrdGrameajeTO(
            String empresa,
            String sector,
            String piscina,
            String desde,
            String hasta) throws Exception {
        return operacionesBusinessLocal.getPrdGrameajeTO(empresa, sector, piscina, desde, hasta);
    }

    @Override
    public java.util.List<produccion.TO.MultiplePiscinaCorrida> getCostoDetallePersonalizado(
            String empresa,
            String sector,
            String fecha) {
        return operacionesBusinessLocal.getCostoDetallePersonalizado(empresa, sector, fecha);
    }

    @Override
    public helper.RetornoTO getCostoPorFechaProrrateado(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            java.lang.String agrupadoPor,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.getCostoPorFechaProrrateado(empresa, codigoSector, fechaInicio, fechaFin, usuario, agrupadoPor, sisInfoTO);
    }

    @Override
    public java.util.List<produccion.TO.PrdFunCostosPorFechaSimpleTO> getPrdFunCostosPorFechaSimpleTO(
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.getPrdFunCostosPorFechaSimpleTO(codigoSector, fechaInicio, fechaFin, sisInfoTO);
    }

    @Override
    public helper.RetornoTO getCostoPorPiscinaSemanal(
            String empresa,
            String codigoSector,
            String numeroPiscina,
            String fechaInicio,
            String fechaFin,
            String usuario,
            java.lang.String agrupadoPor,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.getCostoPorPiscinaSemanal(empresa, codigoSector, numeroPiscina, fechaInicio, fechaFin, usuario, agrupadoPor, sisInfoTO);
    }

    @Override
    public helper.RetornoTO getConsumoPorFechaDesglosado(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.getConsumoPorFechaDesglosado(empresa, codigoSector, fechaInicio, fechaFin, usuario, sisInfoTO);
    }

    @Override
    public helper.RetornoTO getConsumoProductosProceso(
            java.lang.String empresa,
            java.lang.String fecha,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesBusinessLocal.getConsumoProductosProceso(empresa, fecha, usuario, sisInfoTO);
    }

    @Override
    public java.util.List<produccion.TO.PrdConsumosTO> getPrdConsumosFechaTO(
            String empresa,
            String sector,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesBusinessLocal.getPrdConsumosFechaTO(empresa, sector, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<produccion.TO.PrdConsumosTO> getPrdConsumosPiscinaTO(
            String empresa,
            String sector,
            java.lang.String piscina,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesBusinessLocal.getPrdConsumosPiscinaTO(empresa, sector, piscina, fechaDesde, fechaHasta);
    }

    @Override
    public helper.RetornoTO getConsumoPorPiscinaPeriodo(
            String empresa,
            String codigoSector,
            String numeroPiscina,
            String fechaInicio,
            String fechaFin,
            String periodo,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.getConsumoPorPiscinaPeriodo(empresa, codigoSector, numeroPiscina, fechaInicio, fechaFin, periodo, usuario, sisInfoTO);
    }

    @Override
    public java.util.List<produccion.TO.PrdListaSectorConHectareajeTO> getListaSectorConHectareaje(
            java.lang.String empresa,
            java.lang.String fecha) throws java.lang.Exception {
        return operacionesBusinessLocal.getListaSectorConHectareaje(empresa, fecha);
    }

    @Override
    public List<produccion.TO.PrdResumenFinancieroTO> getPrdResumenFinancieroTO(
            String empresa,
            java.lang.String secCodigo,
            String desde,
            String hasta) throws Exception {
        return operacionesBusinessLocal.getPrdResumenFinancieroTO(empresa, secCodigo, desde, hasta);
    }

    @Override
    public helper.RetornoTO getResumenPesca(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.getResumenPesca(empresa, codigoSector, fechaInicio, fechaFin, usuario, sisInfoTO);
    }

    @Override
    public helper.RetornoTO getResumenSiembra(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.getResumenSiembra(empresa, codigoSector, fechaInicio, fechaFin, usuario, sisInfoTO);
    }

    public PrdLiquidacionMotivoTO getPrdLiquidacionMotivoTO(
            String empresa,
            PrdLiquidacionMotivoTablaTO prdLiquidacionMotivoTablaTO) throws Exception {
        return operacionesBusinessLocal.getPrdLiquidacionMotivoTO(empresa, prdLiquidacionMotivoTablaTO);
    }

    public List<PrdLiquidacionMotivoTablaTO> getListaPrdLiquidacionMotivoTablaTO(
            String empresa) throws Exception {
        return operacionesBusinessLocal.getListaPrdLiquidacionMotivoTablaTO(empresa);
    }

    public String insertarPrdLiquidacionMotivoTO(
            PrdLiquidacionMotivoTO prdLiquidacionMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.insertarPrdLiquidacionMotivoTO(prdLiquidacionMotivoTO, sisInfoTO);
    }

    public String modificarPrdLiquidacionMotivoTO(
            PrdLiquidacionMotivoTO prdLiquidacionMotivoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.modificarPrdLiquidacionMotivoTO(prdLiquidacionMotivoTO, sisInfoTO);
    }

    public PrdLiquidacionTallaTO getPrdLiquidacionTallaTO(
            String empresa,
            PrdLiquidacionTallaTablaTO prdLiquidacionTallaTablaTO) throws Exception {
        return operacionesBusinessLocal.getPrdLiquidacionTallaTO(empresa, prdLiquidacionTallaTablaTO);
    }

    public List<PrdLiquidacionTallaTablaTO> getListaPrdLiquidacionTallaTablaTO(String empresa) throws Exception {
        return operacionesBusinessLocal.getListaPrdLiquidacionTallaTablaTO(empresa);
    }

    public List<PrdLiquidacionTallaTablaTO> getListaPrdLiquidacionTallaTablaTO(
            String empresa,
            String codigo) throws Exception {
        return operacionesBusinessLocal.getListaPrdLiquidacionTallaTablaTO(empresa, codigo);
    }

    public String insertarPrdLiquidacionTallaTO(
            PrdLiquidacionTallaTO prdLiquidacionTallaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.insertarPrdLiquidacionTallaTO(prdLiquidacionTallaTO, sisInfoTO);
    }

    public String modificarPrdLiquidacionTallaTO(
            PrdLiquidacionTallaTO prdLiquidacionTallaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.modificarPrdLiquidacionTallaTO(prdLiquidacionTallaTO,
                sisInfoTO);
    }

    public PrdLiquidacionProductoTO getPrdLiquidacionProductoTO(String empresa, PrdLiquidacionProductoTablaTO prdLiquidacionProductoTablaTO) throws Exception {
        return operacionesBusinessLocal.getPrdLiquidacionProductoTO(empresa, prdLiquidacionProductoTablaTO);
    }

    public List<PrdLiquidacionProductoTablaTO> getListaPrdLiquidacionProductoTablaTO(String empresa) throws Exception {
        return operacionesBusinessLocal.getListaPrdLiquidacionProductoTablaTO(empresa);
    }

    public List<PrdLiquidacionProductoTablaTO> getListaPrdLiquidacionProductoTablaTO(String empresa, String codigo) throws Exception {
        return operacionesBusinessLocal.getListaPrdLiquidacionProductoTablaTO(empresa, codigo);
    }

    public String insertarPrdLiquidacionProductoTO(
            PrdLiquidacionProductoTO prdLiquidacionProductoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.insertarPrdLiquidacionProductoTO(prdLiquidacionProductoTO, sisInfoTO);
    }

    public String modificarPrdLiquidacionProductoTO(
            PrdLiquidacionProductoTO prdLiquidacionProductoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.modificarPrdLiquidacionProductoTO(prdLiquidacionProductoTO, sisInfoTO);
    }

    public String insertarPrdLiquidacionTO(
            produccion.TO.PrdLiquidacionTO prdLiquidacionTO,
            java.util.List<produccion.TO.PrdLiquidacionDetalleTO> listaPrdLiquidacionDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.insertarPrdLiquidacionTO(prdLiquidacionTO, listaPrdLiquidacionDetalleTO, sisInfoTO);
    }

    public String modificarPrdLiquidacionTO(
            produccion.TO.PrdLiquidacionTO prdLiquidacionTO,
            java.util.List<produccion.TO.PrdLiquidacionDetalleTO> listaPrdLiquidacionDetalleTO,
            java.util.List<produccion.TO.PrdLiquidacionDetalleTO> listaPrdLiquidacionEliminarDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.modificarPrdLiquidacionTO(prdLiquidacionTO, listaPrdLiquidacionDetalleTO, listaPrdLiquidacionEliminarDetalleTO, sisInfoTO);
    }

    @Override
    public java.util.List<produccion.TO.PrdLiquidacionMotivoComboTO> getListaLiquidacionMotivoComboTO(
            String empresa,
            boolean filtrarInactivos) throws Exception {
        return operacionesBusinessLocal.getListaLiquidacionMotivoComboTO(empresa, filtrarInactivos);
    }

    @Override
    public java.util.List<produccion.TO.PrdListaConsultaLiquidacionTO> getListaPrdConsultaLiquidacion(String empresa, String sector, String piscina, String busqueda) throws Exception {
        return operacionesBusinessLocal.getListaPrdConsultaLiquidacion(empresa, sector, piscina, busqueda);
    }

    @Override
    public produccion.TO.PrdEstadoCCCVT getEstadoCCCVT(String empresa, String motivoTipo, String numero) throws Exception {
        return operacionesBusinessLocal.getEstadoCCCVT(empresa, motivoTipo, numero);
    }

    @Override
    public produccion.TO.PrdLiquidacionCabeceraTO getPrdLiquidacionCabeceraTO(String empresa, String motivo, String numeroLiquidacion) throws Exception {
        return operacionesBusinessLocal.getPrdLiquidacionCabeceraTO(empresa, motivo, numeroLiquidacion);
    }

    @Override
    public java.util.List<produccion.TO.PrdListaFunAnalisisPesosTO> getFunAnalisisPesos(String empresa, String sector, String fecha) throws Exception {
        return operacionesBusinessLocal.getFunAnalisisPesos(empresa, sector, fecha);
    }
    
    @Override
    public List<String> getFunFechaSemanas(String empresa, String sector, String fecha) throws Exception {
        return operacionesBusinessLocal.getFunFechaSemanas(empresa, sector, fecha);
    }

    @Override
    public java.util.List<produccion.TO.PrdListaDetalleLiquidacionTO> getListaPrdLiquidacionDetalleTO(String empresa, String motivo, String numero) throws Exception {
        return operacionesBusinessLocal.getListaPrdLiquidacionDetalleTO(empresa, motivo, numero);
    }

    @Override
    public java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> getListaConsultaGrameajePromedioPorPiscinaTOs(String empresa, String sector) throws Exception {
        return operacionesBusinessLocal.getListaConsultaGrameajePromedioPorPiscinaTOs(empresa, sector);
    }

    @Override
    public helper.RetornoTO getConsultaGrameajePromedioPorPiscina(
            String empresa,
            String sector,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBusinessLocal.getConsultaGrameajePromedioPorPiscina(empresa, sector, sisInfoTO);
    }

    @Override
    public JasperPrint generarReporteListadoGramaje(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String codigoSector, String codigoPiscina, String codigoCorrida, String fechaDesde, String fechaHasta,
            List<PrdListadoGrameajeTO> prdListadoGrameajeTO) throws Exception {
        return operacionesBusinessLocal.generarReporteListadoGramaje(sisUsuarioEmpresaTO,
                codigoSector, codigoPiscina, codigoCorrida, fechaDesde, fechaHasta,
                prdListadoGrameajeTO);

    }

    @Override
    public JasperPrint generarReporteListadoFunAnalisisPesos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String codigoSector, String fechaHasta,
            List<PrdListaFunAnalisisPesosTO> prdListaFunAnalisisPesosTO) throws Exception {
        return operacionesBusinessLocal.generarReporteListadoFunAnalisisPesos(
                sisUsuarioEmpresaTO, codigoSector, fechaHasta, prdListaFunAnalisisPesosTO);
    }

    @Override
    public JasperPrint generarReporteConsumoFecha(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String secCodigo, String fechaDesde,
            String fechaHasta,
            List<PrdConsumosTO> prdConsumosTO) throws Exception {
        return operacionesBusinessLocal.generarReporteConsumoFecha(
                sisUsuarioEmpresaTO, secCodigo, fechaDesde,
                fechaHasta, prdConsumosTO);
    }

    @Override
    public JasperPrint generarReporteConsumoPiscina(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String codigoSector, String codigoPiscina, String numeroCorrida,
            String hectareas, Integer numLarvas, String fechaDesde,
            String fechaHasta, List<PrdConsumosTO> prdConsumosTO) throws Exception {
        return operacionesBusinessLocal.generarReporteConsumoPiscina(
                sisUsuarioEmpresaTO, codigoSector, codigoPiscina, numeroCorrida,
                hectareas, numLarvas, fechaDesde, fechaHasta, prdConsumosTO);
    }

    @Override
    public JasperPrint generarReporteEconomicoPorFechas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta,
            List<PrdCostoDetalleFechaTO> listaPrdCostoDetalleFechaTO) throws Exception {
        return operacionesBusinessLocal.generarReporteEconomicoPorFechas(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                listaPrdCostoDetalleFechaTO);
    }

    @Override
    public JasperPrint generarReporteEconomicoPorPiscinas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String codigoSector, String codigoPiscina,
            String codigoCorrida, String hectareas, Integer numLarvas,
            String fechaDesde, String fechaHasta,
            List<PrdListaCostosDetalleCorridaTO> prdListaCostosDetalleCorridaTO) throws Exception {
        return operacionesBusinessLocal.generarReporteEconomicoPorPiscinas(
                sisUsuarioEmpresaTO, codigoSector, codigoPiscina, codigoCorrida,
                hectareas, numLarvas, fechaDesde, fechaHasta,
                prdListaCostosDetalleCorridaTO);
    }

    @Override
    public JasperPrint generarReporteResumenSiembra(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            Object[][] datos) throws Exception {
        return operacionesBusinessLocal.generarReporteResumenSiembra(
                sisUsuarioEmpresaTO, datos);
    }

    @Override
    public JasperPrint generarReporteResumenSiembra(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<PrdResumenCorridaTO> listaPrdListaResumenCorridaTO) throws Exception {
        return operacionesBusinessLocal.generarReporteResumenSiembra(
                sisUsuarioEmpresaTO, listaPrdListaResumenCorridaTO);
    }

    @Override
    public JasperPrint generarResumenPesca(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<PrdResumenCorridaTO> listaPrdListaResumenCorridaTO) throws Exception {
        return operacionesBusinessLocal.generarResumenPesca(
                sisUsuarioEmpresaTO, listaPrdListaResumenCorridaTO);
    }

    @Override
    public JasperPrint generarReporteResumenPescaEconomico(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, Object[][] datos) throws Exception {
        return operacionesBusinessLocal.generarReporteResumenPescaEconomico(
                sisUsuarioEmpresaTO, datos);
    }
}