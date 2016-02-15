/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabilidad.DAO;

import contabilidad.TO.ConCuentasFlujoTO;
import contabilidad.TO.ConCuentasTO;
import contabilidad.TO.ConEstructuraTO;
import contabilidad.TO.ConTipoTO;
import contabilidad.entity.ConContable;
import contabilidad.entity.ConCuentas;
import contabilidad.entity.ConTipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesContabilidadDAOLocal {
    ConTipo buscarTipo(
            String codEmpresa, 
            String codTipo) throws Exception;
//    ConTipo buscarTipo(String codEmpresa, String codTipo) throws Exception;
    ConCuentas buscarCuentas(
            String codEmpresa, 
            String codCuenta) throws Exception;
     Boolean swCobrosAnticiposEliminar(
            String codEmpresa, 
            String periodo,
            String tipo,
            String numeroContable) throws Exception;
    contabilidad.entity.ConCuentasFlujoDetalle buscarCuentasFlujoDetalle(
            String codEmpresa, 
            String codCuenta, 
            char detCreditoDebito) throws Exception;
    ConContable buscarContable(
            String codEmpresa, 
            String perCodigo, 
            String tipCodigo, 
            String conNumero) throws Exception;
    Boolean buscarTipoContable(
            String empCodigo, 
            String tipCodigo) throws Exception;
    String buscarContableTrasferencia(
            String empCodigo, 
            String tipCodigo, 
            String concepto, 
            String fecha,
            String conSector) throws Exception;
    List<contabilidad.TO.ConContableTO> listaContableTrasferenciaPorPeriodoFecha(
            String empCodigo, 
            String contipo,
            String concepto , 
            String fechaDesde, 
            String fechaHasta,
            String conSector) throws Exception;
    java.util.List<contabilidad.TO.InvListaConsultaConsumosTO> getListaInvConsultaConsumosPendientes(
            String empCodigo, 
            String fechaDesde, 
            String fechaHasta) throws Exception;
    int buscarConteoNumeracionEliminarTipo(
            String empCodigo, 
            String tipCodigo) throws Exception;
    int buscarConteoDetalleEliminarCuenta(
            String empCodigo, 
            String cuentaCodigo) throws Exception;
    int buscarConteoUltimaNumeracion(
            String empCodigo, 
            String perCodigo, 
            String tipCodigo) throws Exception;
    List<ConTipoTO> getListaConTipoTO(
            String empresa) throws Exception;
    List<ConTipoTO> getListaConTipoRrhhTO(
            String empresa) throws Exception;
    List<ConTipoTO> getListaConTipoCarteraTO(
            String empresa) throws Exception;
    List<ConTipoTO> getListaConTipoCarteraAnticiposTO(
            String empresa) throws Exception;
    List<ConCuentasTO> getListaConCuentasTO(
            String empresa) throws Exception;
    List<ConCuentasTO> getRangoCuentasTO(
            String empresa, 
            String codigoCuentaDesde, 
            String codigoCuentaHasta, 
            int largoCuenta) throws Exception;
    List<ConCuentasFlujoTO> getListaConCuentasFlujoTO(
            String empresa) throws Exception;
    List<contabilidad.TO.ConCuentasFlujoDetalleTO> getListaConCuentasFlujoDetalleTO(
            String empresa) throws Exception;
    List<ConCuentasTO> getListaBuscarConCuentasTO(
            String empresa, 
            String buscar, 
            String ctaGrupo) throws Exception;
    List<contabilidad.TO.ConCuentasFlujoTO> getListaBuscarConCuentasFlujoTO(
            String empresa) throws Exception;
    List<contabilidad.TO.ConCuentasFlujoDetalleTO> getListaBuscarConCuentasFlujoDetalleTO(
            String empresa, 
            String buscar) throws Exception;
    List<ConEstructuraTO> getListaConEstructuraTO(
            String empresa) throws Exception;
    List<contabilidad.TO.ConEstructuraFlujoTO> getListaConEstructuraFlujoTO(
            String empresa) throws Exception;
    List<contabilidad.TO.ListaConContableTO> getListaBusquedaConContableTO(
            String empresa, 
            String perCodigo, 
            String tipCodigo, 
            String busqueda,
            String nRegistros) throws Exception;
    List<contabilidad.TO.ConContableTO> getListaConContableTO(
            String empresa, 
            String perCodigo, 
            String tipCodigo, 
            String numContable) throws Exception;
    List<contabilidad.TO.ConDetalleTablaTO> getListaConDetalleTO(
            String empresa, 
            String perCodigo, 
            String tipCodigo, 
            String numContable) throws Exception;
    java.lang.Boolean buscarConDetallesActivosBiologicos(
            java.lang.String empresa) throws java.lang.Exception;
    java.util.List<contabilidad.TO.ConFunBalanceResultadosNecTO> getConFunBalanceResultadosNecTO(
            java.lang.String empresa, 
            java.lang.String sector, 
            java.lang.String fechaDesde, 
            java.lang.String fechaHasta, 
            java.lang.Integer columnasEstadosFinancieros, 
            java.lang.Boolean ocultarDetalle) throws java.lang.Exception;
    java.util.List<contabilidad.TO.ConBalanceResultadoTO> getConFunBalanceFlujoEfectivo(
            java.lang.String empresa, 
            java.lang.String sector, 
            java.lang.String fechaDesde, 
            java.lang.String fechaHasta) throws java.lang.Exception;
    java.util.List<contabilidad.TO.ConFunBalanceGeneralNecTO> getConFunBalanceGeneralNecTO(
            java.lang.String empresa, 
            java.lang.String sector, 
            java.lang.String fecha, 
            java.lang.Boolean ocultar, 
            java.lang.Boolean ocultarDetalle, 
            java.lang.Boolean validacionCtaModulo,
            java.lang.Integer columnasEstadosFinancieros) throws java.lang.Exception;
    java.util.List<contabilidad.TO.ConBalanceGeneralTO> getFunBalanceGeneralTO(
            String empresa, 
            String secCodigo, 
            String fecha, 
            Boolean ocultar) throws Exception;
    java.util.List<contabilidad.TO.ConBalanceGeneralTO> getFunCuentasSobregiradasTO(
            String empresa, 
            String secCodigo, 
            String fecha) throws Exception;
    java.util.List<contabilidad.TO.ConBalanceGeneralComparativoTO> getFunBalanceGeneralComparativoTO(
            String empresa, 
            String secCodigo, 
            String fechaAnterior, 
            String fechaActual, 
            Boolean ocultar) throws Exception;
    java.util.List<contabilidad.TO.ConBalanceComprobacionTO> getListaBalanceComprobacionTO(
            String empresa, 
            String codigoSector, 
            String fechaInicio, 
            String fechaFin, 
            java.lang.Boolean ocultarDetalle) throws Exception;
    java.util.List<contabilidad.TO.ConBalanceResultadoTO> getListaBalanceResultadoTO(
            String empresa, 
            String codigoSector, 
            String fechaInicio, 
            String fechaFin, 
            java.lang.Boolean ocultarDetalle) throws Exception;
    java.util.List<contabilidad.TO.ConMayorAuxiliarTO> getListaMayorAuxiliarTO(
            String empresa, 
            String codigoCuenta, 
            String fechaInicio, 
            String fechaFin, 
            String sector) throws Exception;
    java.util.List<contabilidad.TO.ConMayorGeneralTO> getListaMayorGeneralTO(
            String empresa, 
            String codigoSector, 
            String codigoCuenta, 
            String fechaFin) throws Exception;
    java.util.List<contabilidad.TO.ConDiarioAuxiliarTO> getListaDiarioAuxiliarTO(
            String empresa, 
            String codigoTipo, 
            String fechaInicio, 
            String fechaFin) throws Exception;
    contabilidad.entity.ConDetalle buscarDetalleContable(
            Long codDetalle) throws Exception;
    String buscarTipoContablePorMotivoCompra(
            String empresa, 
            String codigoMotivo) throws Exception;
    String buscarTipoContablePorMotivoVenta(
            String empresa, 
            String codigoMotivo) throws Exception;
    java.util.List<contabilidad.TO.ConNumeracionTO> getListaConNumeracionTO(
            String empresa, 
            String periodo, 
            String tipo) throws Exception;
    java.util.List<contabilidad.TO.ConListaBalanceResultadosVsInventarioTO> getConListaBalanceResultadosVsInventarioTO(
            java.lang.String empresa, 
            java.lang.String desde, 
            java.lang.String hasta, 
            String sector) throws java.lang.Exception;
    java.util.List<contabilidad.TO.ConBalanceResultadosMensualizadosTO> getBalanceResultadoMensualizado(
            String empresa, 
            String codigoSector, 
            String fechaInicio, 
            String fechaFin) throws Exception;
    java.util.List<contabilidad.TO.ConFunContablesVerificacionesTO> getFunContablesVerificacionesTO(
            java.lang.String empresa) throws java.lang.Exception;
    java.util.List<contabilidad.TO.ConFunContabilizarTransferenciasTO> getFunContabilizarTransferencias(
            String empresa, 
            String codigoSector, 
            String fechaInicio, 
            String fechaFin, 
            String parametro) throws Exception;
    List<contabilidad.TO.ConDetalleTO> getConDetalleTO(
            String empresa, 
            String perCodigo, 
            String tipCodigo, 
            String numContable) throws Exception;
    contabilidad.entity.ConCuentasFlujo buscarCuentasFlujo(
            String codEmpresa, 
            String codTipo) throws Exception;
    List<contabilidad.TO.ConBalanceResultadoCierreTO> getfun_balance_resultados_cierre(
            String empresa, 
            String sector, 
            String fecha) throws Exception;
   ConCuentas buscarCuentas2(
           String empresa, 
           String cuenta) throws Exception;
   List<ConCuentasFlujoTO> getListaBuscarConCuentasFlujoTO(
           String empresa, 
           String buscar) throws Exception;
  
   java.util.List<contabilidad.TO.ConFunContablesVerificacionesComprasTO> getConFunContablesVerificacionesComprasTOs (
           java.lang.String empresa, 
           java.lang.String fechaInicio, 
           java.lang.String fechaFin)throws Exception;
  java.util.List<contabilidad.TO.PersonaTO> getFunPersonaTOs(String empresa, String busquedad) throws Exception;
  java.util.List<contabilidad.TO.ConFunContabilizarComprasDetalleTO> getConFunContabilizarComprasDetalle(
          String empresa, 
          String periodo, 
          String motivo, 
          String numeroCompra,
          String validar) throws Exception;
  List<contabilidad.TO.ConFunContabilizarComprasDetalleTO> getConDetalleEliminarTO(String empresa,
            String perCodigo, String tipCodigo, String numContable) throws Exception;
}
