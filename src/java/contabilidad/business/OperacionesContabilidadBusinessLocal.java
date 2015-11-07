/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.business;

import contabilidad.TO.*;
import contabilidad.entity.ConContable;
import inventario.reporte.ReporteCompraDetalle;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesContabilidadBusinessLocal {

    ///// METODOS PARA OBTENER LISTAS DE TIPOS, CUENTAS
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
            int largoCuenta,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

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
            Boolean ocultarDetalle) throws java.lang.Exception;

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

    List<contabilidad.TO.ConMayorAuxiliarTO> getListaMayorAuxiliarMultipleTO(
            String empresa,
            String codigoCuentaDesde,
            String codigoCuentaHasta,
            String fechaInicio,
            String fechaFin,
            String sector,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

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

    contabilidad.TO.ConContableConDetalle buscarConContableConDetalle(
            java.lang.Long detSecuencia) throws java.lang.Exception;
    ///// METODOS PARA TIPO CONTABLE

    boolean insertarConTipo(
            ConTipoTO conTipoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean modificarConTipo(
            ConTipoTO conTipoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean eliminarConTipo(
            ConTipoTO conTipoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    ///// METODOS PARA PLAN CUENTAS

    int buscarConteoDetalleEliminarCuenta(
            String empCodigo,
            String cuentaCodigo) throws Exception;

    boolean insertarConCuenta(
            ConCuentasTO conCuentasTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean insertarConCuentaFlujo(
            ConCuentasFlujoTO conCuentasFlujoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean insertarConCuentaFlujoDetalle(
            contabilidad.TO.ConCuentasFlujoDetalleTO conCuentasFlujoDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean modificarConCuenta(
            ConCuentasTO conCuentasTO,
            String codigoCambiarLlave,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean modificarConCuentaFlujo(
            ConCuentasFlujoTO conCuentasFlujoTO,
            String codigoCambiarLlave,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean modificarConCuentaFlujoDetalle(
            contabilidad.TO.ConCuentasFlujoDetalleTO conCuentasFlujoDetalleTO,
            String codigoCambiarLlave,
            char formaPagoAnterior,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String eliminarConCuentaFlujoDetalle(
            ConCuentasFlujoDetalleTO conCuentasTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String eliminarConCuenta(
            ConCuentasTO conCuentasTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String eliminarConCuentaFlujo(
            ConCuentasFlujoTO conCuentasFlujoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    ///// METODOS PARA INSERTAR CONTABLE

    inventario.TO.MensajeTO insertarConContable(
            ConContableTO conContableTO,
            List<ConDetalleTO> listaConDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String modificarConContable(
            ConContableTO conContableTO,
            List<ConDetalleTO> listaConDetalleTO,
            List<ConDetalleTO> listaConDetalleEliminarTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String anularReversarConContable(
            String empresa,
            String periodo,
            String tipo,
            String numero,
            String usuario,
            java.lang.String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<contabilidad.TO.ConNumeracionTO> getListaConNumeracionTO(
            String empresa,
            String periodo,
            String tipo) throws Exception;

    contabilidad.entity.ConDetalle buscarDetalleContable(
            Long codDetalle) throws Exception;

    List<ConDetalleTO> buscarConContable(
            String codEmpresa,
            String perCodigo,
            String tipCodigo,
            String conNumero) throws Exception;

    String modificarConDetalleTO(
            Long secuencial,
            String usuario,
            String empresa,
            String documento,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<contabilidad.TO.ConListaBalanceResultadosVsInventarioTO> getConListaBalanceResultadosVsInventarioTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            String sector) throws java.lang.Exception;

    helper.RetornoTO getBalanceResultadoMensualizado(
            java.lang.String empresa,
            java.lang.String codigoSector,
            java.lang.String fechaInicio,
            java.lang.String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String desbloquearConContable(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String tipo,
            java.lang.String numero,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<contabilidad.TO.ConFunContablesVerificacionesTO> getFunContablesVerificacionesTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.lang.String restaurarConContable(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String tipo,
            java.lang.String numero,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    helper.RetornoTO getFunContabilizarTransferencias(
            java.lang.String empresa,
            java.lang.String codigoSector,
            java.lang.String fechaInicio,
            java.lang.String fechaFin,
            java.lang.String usuario,
            java.lang.String parametro,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    inventario.TO.MensajeTO insertarConContableAgrupado(
            List<ConContableTO> conContableTO,
            List<List<ConDetalleTO>> listaConDetalleTO,
            String fechaDesde,
            String fechaHasta,
            sistema.TO.SisInfoTO sisInfoTO,
            String conSector) throws Exception;

    inventario.TO.MensajeTO getListaInvConsultaConsumosPendientes(
            String empCodigo,
            String fechaDesde,
            String fechaHasta) throws Exception;

    inventario.TO.MensajeTO insertarConContableCierreCuentas(
            ConContableTO conContableTO,
            String centroProduccion,
            String conNumero_Contable,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    List<ConCuentasFlujoTO> getListaBuscarConCuentasFlujoTO(
            String empresa,
            String buscar) throws Exception;

    java.util.List<contabilidad.TO.ConFunContablesVerificacionesComprasTO> getConFunContablesVerificacionesComprasTOs(
            java.lang.String empresa,
            java.lang.String fechaInicio,
            java.lang.String fechaFin) throws Exception;

    java.util.List<contabilidad.TO.PersonaTO> getFunPersonaTOs(
            String empresa,
            String busquedad) throws Exception;

    JasperPrint generarReporteCompraContableDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteCompraDetalle> reporteCompraDetalles,
            List<ConContableReporteTO> list) throws Exception;
}
