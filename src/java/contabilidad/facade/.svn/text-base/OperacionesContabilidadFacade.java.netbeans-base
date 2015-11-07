/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.facade;

import contabilidad.TO.*;
import contabilidad.business.OperacionesContabilidadBusinessLocal;
import contabilidad.reporte.GenerarReporteContabilidadLocal;
import inventario.reporte.ReporteCompraDetalle;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesContabilidadFacade implements OperacionesContabilidadFacadeRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    OperacionesContabilidadBusinessLocal operacionesContabilidadBusinessLocal;
    @EJB
    GenerarReporteContabilidadLocal generarReporteContabilidadLocal;

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA OBTENER TIPOS, CUENTAS">
    @Override
    public List<ConTipoTO> getListaConTipoTO(
            String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConTipoTO(empresa);
    }

    @Override
    public List<ConTipoTO> getListaConTipoRrhhTO(
            String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConTipoRrhhTO(empresa);
    }

    @Override
    public List<ConTipoTO> getListaConTipoCarteraTO(
            String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConTipoCarteraTO(empresa);
    }

    @Override
    public List<ConTipoTO> getListaConTipoCarteraAnticiposTO(
            String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConTipoCarteraAnticiposTO(empresa);
    }

    @Override
    public List<ConCuentasTO> getListaConCuentasTO(
            String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConCuentasTO(empresa);
    }

    @Override
    public List<ConCuentasTO> getRangoCuentasTO(
            String empresa,
            String codigoCuentaDesde,
            String codigoCuentaHasta,
            int largoCuenta,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.getRangoCuentasTO(empresa, codigoCuentaDesde, codigoCuentaHasta, largoCuenta, usuario, sisInfoTO);
    }

    @Override
    public List<ConCuentasFlujoTO> getListaConCuentasFlujoTO(
            String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConCuentasFlujoTO(empresa);
    }

    @Override
    public List<contabilidad.TO.ConCuentasFlujoDetalleTO> getListaConCuentasFlujoDetalleTO(
            String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConCuentasFlujoDetalleTO(empresa);
    }

    @Override
    public List<ConCuentasTO> getListaBuscarConCuentasTO(
            String empresa,
            String buscar,
            String ctaGrupo) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaBuscarConCuentasTO(empresa, buscar, ctaGrupo);
    }

    @Override
    public List<contabilidad.TO.ConCuentasFlujoTO> getListaBuscarConCuentasFlujoTO(
            String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaBuscarConCuentasFlujoTO(empresa);
    }

    @Override
    public List<contabilidad.TO.ConCuentasFlujoDetalleTO> getListaBuscarConCuentasFlujoDetalleTO(
            String empresa,
            String buscar) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaBuscarConCuentasFlujoDetalleTO(empresa, buscar);
    }

    @Override
    public List<ConEstructuraTO> getListaConEstructuraTO(
            String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConEstructuraTO(empresa);
    }

    @Override
    public List<contabilidad.TO.ConEstructuraFlujoTO> getListaConEstructuraFlujoTO(
            String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConEstructuraFlujoTO(empresa);
    }

    @Override
    public List<contabilidad.TO.ListaConContableTO> getListaBusquedaConContableTO(
            String empresa,
            String perCodigo,
            String tipCodigo,
            String busqueda,
            String nRegistros) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaBusquedaConContableTO(empresa, perCodigo, tipCodigo, busqueda, nRegistros);
    }

    @Override
    public List<contabilidad.TO.ConContableTO> getListaConContableTO(
            String empresa,
            String perCodigo,
            String tipCodigo,
            String numContable) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConContableTO(empresa, perCodigo, tipCodigo, numContable);
    }

    @Override
    public List<contabilidad.TO.ConDetalleTablaTO> getListaConDetalleTO(
            String empresa,
            String perCodigo,
            String tipCodigo,
            String numContable) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConDetalleTO(empresa, perCodigo, tipCodigo, numContable);
    }

    @Override
    public java.lang.Boolean buscarConDetallesActivosBiologicos(java.lang.String empresa) throws java.lang.Exception {
        return operacionesContabilidadBusinessLocal.buscarConDetallesActivosBiologicos(empresa);
    }

    @Override
    public java.util.List<contabilidad.TO.ConFunBalanceResultadosNecTO> getConFunBalanceResultadosNecTO(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta,
            java.lang.Integer columnasEstadosFinancieros,
            Boolean ocultarDetalle) throws java.lang.Exception {
        return operacionesContabilidadBusinessLocal.getConFunBalanceResultadosNecTO(empresa, sector, fechaDesde, fechaHasta, columnasEstadosFinancieros, ocultarDetalle);
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceResultadoTO> getConFunBalanceFlujoEfectivo(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws java.lang.Exception {
        return operacionesContabilidadBusinessLocal.getConFunBalanceFlujoEfectivo(empresa, sector, fechaDesde, fechaHasta);
    }

    @Override
    public java.util.List<contabilidad.TO.ConFunBalanceGeneralNecTO> getConFunBalanceGeneralNecTO(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String fecha,
            java.lang.Boolean ocultar,
            java.lang.Boolean ocultarDetalle,
            java.lang.Integer columnasEstadosFinancieros) throws java.lang.Exception {
        return operacionesContabilidadBusinessLocal.getConFunBalanceGeneralNecTO(empresa, sector, fecha, ocultar, ocultarDetalle, columnasEstadosFinancieros);
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceGeneralTO> getFunBalanceGeneralTO(
            String empresa,
            String secCodigo,
            String fecha,
            Boolean ocultar) throws Exception {
        return operacionesContabilidadBusinessLocal.getFunBalanceGeneralTO(empresa, secCodigo, fecha, ocultar);
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceGeneralTO> getFunCuentasSobregiradasTO(
            String empresa,
            String secCodigo,
            String fecha) throws Exception {
        return operacionesContabilidadBusinessLocal.getFunCuentasSobregiradasTO(empresa, secCodigo, fecha);
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceGeneralComparativoTO> getFunBalanceGeneralComparativoTO(
            String empresa,
            String secCodigo,
            String fechaAnterior,
            String fechaActual,
            Boolean ocultar) throws Exception {
        return operacionesContabilidadBusinessLocal.getFunBalanceGeneralComparativoTO(empresa, secCodigo, fechaAnterior, fechaActual, ocultar);
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceComprobacionTO> getListaBalanceComprobacionTO(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            Boolean ocultarDetalle) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaBalanceComprobacionTO(empresa, codigoSector, fechaInicio, fechaFin, ocultarDetalle);
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceResultadoTO> getListaBalanceResultadoTO(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            Boolean ocultarDetalle) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaBalanceResultadoTO(empresa, codigoSector, fechaInicio, fechaFin, ocultarDetalle);
    }

    @Override
    public List<contabilidad.TO.ConMayorAuxiliarTO> getListaMayorAuxiliarTO(
            String empresa,
            String codigoCuenta,
            String fechaInicio,
            String fechaFin,
            String sector) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaMayorAuxiliarTO(empresa, codigoCuenta, fechaInicio, fechaFin, sector);
    }

    @Override
    public List<contabilidad.TO.ConMayorAuxiliarTO> getListaMayorAuxiliarMultipleTO(
            String empresa,
            String codigoCuentaDesde,
            String codigoCuentaHasta,
            String fechaInicio,
            String fechaFin,
            String sector,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaMayorAuxiliarMultipleTO(empresa, codigoCuentaDesde, codigoCuentaHasta, fechaInicio, fechaFin, sector, usuario, sisInfoTO);
    }

    @Override
    public List<contabilidad.TO.ConMayorGeneralTO> getListaMayorGeneralTO(
            String empresa,
            String codigoSector,
            String codigoCuenta,
            String fechaFin) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaMayorGeneralTO(empresa, codigoSector, codigoCuenta, fechaFin);
    }

    @Override
    public List<contabilidad.TO.ConDiarioAuxiliarTO> getListaDiarioAuxiliarTO(
            String empresa,
            String codigoTipo,
            String fechaInicio,
            String fechaFin) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaDiarioAuxiliarTO(empresa, codigoTipo, fechaInicio, fechaFin);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA TIPOS">

    @Override
    public boolean insertarConTipo(
            ConTipoTO conTipoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.insertarConTipo(conTipoTO, sisInfoTO);
    }

    @Override
    public boolean modificarConTipo(
            ConTipoTO conTipoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.modificarConTipo(conTipoTO, sisInfoTO);
    }

    @Override
    public boolean eliminarConTipo(
            ConTipoTO conTipoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.eliminarConTipo(conTipoTO, sisInfoTO);
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA PLAN DE CUENTAS">

    @Override
    public int buscarConteoDetalleEliminarCuenta(
            String empCodigo,
            String cuentaCodigo) throws Exception {
        return operacionesContabilidadBusinessLocal.buscarConteoDetalleEliminarCuenta(empCodigo, cuentaCodigo);
    }

    @Override
    public boolean insertarConCuenta(
            ConCuentasTO conCuentasTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.insertarConCuenta(conCuentasTO, sisInfoTO);
    }

    @Override
    public boolean insertarConCuentaFlujo(
            ConCuentasFlujoTO conCuentasFlujoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.insertarConCuentaFlujo(conCuentasFlujoTO, sisInfoTO);
    }

    @Override
    public boolean insertarConCuentaFlujoDetalle(
            contabilidad.TO.ConCuentasFlujoDetalleTO conCuentasFlujoDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.insertarConCuentaFlujoDetalle(conCuentasFlujoDetalleTO, sisInfoTO);
    }

    @Override
    public boolean modificarConCuenta(
            ConCuentasTO conCuentasTO,
            String codigoCambiarLlave,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.modificarConCuenta(conCuentasTO, codigoCambiarLlave, sisInfoTO);
    }

    @Override
    public boolean modificarConCuentaFlujo(
            ConCuentasFlujoTO conCuentasFlujoTO,
            String codigoCambiarLlave,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.modificarConCuentaFlujo(conCuentasFlujoTO, codigoCambiarLlave, sisInfoTO);
    }

    @Override
    public boolean modificarConCuentaFlujoDetalle(
            contabilidad.TO.ConCuentasFlujoDetalleTO conCuentasFlujoDetalleTO,
            String codigoCambiarLlave,
            char formaPagoAnterior, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.modificarConCuentaFlujoDetalle(conCuentasFlujoDetalleTO, codigoCambiarLlave, formaPagoAnterior, sisInfoTO);
    }

    @Override
    public String eliminarConCuentaFlujoDetalle(
            ConCuentasFlujoDetalleTO conCuentasFlujoDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.eliminarConCuentaFlujoDetalle(conCuentasFlujoDetalleTO, sisInfoTO);
    }// </editor-fold>

    @Override
    public String eliminarConCuenta(
            ConCuentasTO conCuentasTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.eliminarConCuenta(conCuentasTO, sisInfoTO);
    }// </editor-fold>

    @Override
    public String eliminarConCuentaFlujo(
            ConCuentasFlujoTO conCuentasFlujoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.eliminarConCuentaFlujo(conCuentasFlujoTO, sisInfoTO);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA TIPOS">
    @Override
    public inventario.TO.MensajeTO insertarConContable(
            ConContableTO conContableTO,
            List<ConDetalleTO> listaConDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.insertarConContable(conContableTO, listaConDetalleTO, sisInfoTO);
    }

    @Override
    public String modificarConContable(
            contabilidad.TO.ConContableTO conContableTO,
            java.util.List<contabilidad.TO.ConDetalleTO> listaConDetalleTO,
            java.util.List<contabilidad.TO.ConDetalleTO> listaConDetalleEliminarTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesContabilidadBusinessLocal.modificarConContable(conContableTO, listaConDetalleTO, listaConDetalleEliminarTO, sisInfoTO);
    }

    @Override
    public String anularReversarConContable(
            String empresa,
            String periodo,
            String tipo,
            String numero,
            String usuario,
            java.lang.String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesContabilidadBusinessLocal.anularReversarConContable(empresa, periodo, tipo, numero, usuario, accion, sisInfoTO);
    }

    @Override
    public java.util.List<contabilidad.TO.ConNumeracionTO> getListaConNumeracionTO(
            String empresa,
            String periodo,
            String tipo) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaConNumeracionTO(empresa, periodo, tipo);
    }

    @Override
    public contabilidad.entity.ConDetalle buscarDetalleContable(Long codDetalle) throws Exception {
        return operacionesContabilidadBusinessLocal.buscarDetalleContable(codDetalle);
    }

    public List<ConDetalleTO> buscarConContable(
            String codEmpresa,
            String perCodigo,
            String tipCodigo,
            String conNumero) throws Exception {
        return operacionesContabilidadBusinessLocal.buscarConContable(codEmpresa, perCodigo, tipCodigo, conNumero);
    }

    @Override
    public String modificarConDetalleTO(
            Long secuencial,
            String usuario,
            String empresa,
            String documento,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.modificarConDetalleTO(secuencial, usuario, empresa, documento, sisInfoTO);
    }
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS">

    @Override
    public java.util.List<contabilidad.TO.ConListaBalanceResultadosVsInventarioTO> getConListaBalanceResultadosVsInventarioTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            String sector) throws java.lang.Exception {
        return operacionesContabilidadBusinessLocal.getConListaBalanceResultadosVsInventarioTO(empresa, desde, hasta, sector);
    }

    @Override
    public helper.RetornoTO getBalanceResultadoMensualizado(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.getBalanceResultadoMensualizado(empresa, codigoSector, fechaInicio, fechaFin, usuario, sisInfoTO);
    }
    // </editor-fold>

    @Override
    public String desbloquearConContable(
            String empresa,
            String periodo,
            String tipo,
            String numero,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.desbloquearConContable(empresa, periodo, tipo, numero, usuario, sisInfoTO);
    }

    @Override
    public String restaurarConContable(
            String empresa,
            String periodo,
            String tipo,
            String numero,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.restaurarConContable(empresa, periodo, tipo, numero, usuario, sisInfoTO);
    }

    @Override
    public java.util.List<contabilidad.TO.ConFunContablesVerificacionesTO> getFunContablesVerificacionesTO(String empresa) throws Exception {
        return operacionesContabilidadBusinessLocal.getFunContablesVerificacionesTO(empresa);
    }

    @Override
    public helper.RetornoTO getFunContabilizarTransferencias(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            String parametro,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadBusinessLocal.getFunContabilizarTransferencias(empresa, codigoSector, fechaInicio, fechaFin, usuario, parametro, sisInfoTO);
    }

    @Override
    public inventario.TO.MensajeTO getListaInvConsultaConsumosPendientes(
            String empCodigo,
            String fechaDesde,
            String fechaHasta) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaInvConsultaConsumosPendientes(empCodigo, fechaDesde, fechaHasta);
    }

    @Override
    public inventario.TO.MensajeTO insertarConContableAgrupado(
            List<ConContableTO> conContableTO,
            List<List<ConDetalleTO>> listaConDetalleTO,
            String fechaDesde,
            String fechaHasta,
            sistema.TO.SisInfoTO sisInfoTO,
            String conSector) throws Exception {
        return operacionesContabilidadBusinessLocal.insertarConContableAgrupado(conContableTO, listaConDetalleTO, fechaDesde, fechaHasta, sisInfoTO, conSector);
    }

    @Override
    public inventario.TO.MensajeTO insertarConContableCierreCuentas(
            ConContableTO conContableTO,
            String centroProduccion,
            String conNumero_Contable,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return this.operacionesContabilidadBusinessLocal.insertarConContableCierreCuentas(conContableTO, centroProduccion, conNumero_Contable, sisInfoTO);
    }

    @Override
    public List<ConCuentasFlujoTO> getListaBuscarConCuentasFlujoTO(
            String empresa,
            String buscar) throws Exception {
        return operacionesContabilidadBusinessLocal.getListaBuscarConCuentasFlujoTO(empresa, buscar);
    }

    @Override
    public java.util.List<contabilidad.TO.ConFunContablesVerificacionesComprasTO> getConFunContablesVerificacionesComprasTOs(
            java.lang.String empresa,
            java.lang.String fechaInicio,
            java.lang.String fechaFin) throws Exception {
        return operacionesContabilidadBusinessLocal.getConFunContablesVerificacionesComprasTOs(empresa, fechaInicio, fechaFin);
    }

    @Override
    public JasperPrint generarReporteContableDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, List<ConContableReporteTO> listConContableReporteTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteContableDetalle(sisUsuarioEmpresaTO, listConContableReporteTO);
    }

    @Override
    public JasperPrint generarReporteMayorAuxiliar(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String cuentaContable,  String cuentaContablePadre,List<ConMayorAuxiliarTO> listConMayorAuxiliarTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteMayorAuxiliar(sisUsuarioEmpresaTO, fechaDesde, fechaHasta, cuentaContable, cuentaContablePadre, listConMayorAuxiliarTO);
    }

    @Override
    public JasperPrint generarReporteMayorGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            String cuentaContable, Object[][] datos) throws Exception {//List<ConMayorGeneralTO> listConMayorGeneralTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteMayorGeneral(
                sisUsuarioEmpresaTO, fechaHasta, cuentaContable, datos);//listConMayorGeneralTO);
    }

    @Override
    public JasperPrint generarReporteDiarioAuxiliar(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String codigoTipo, List<ConDiarioAuxiliarTO> listConDiarioAuxiliarTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteDiarioAuxiliar(sisUsuarioEmpresaTO, fechaDesde, fechaHasta, codigoTipo, listConDiarioAuxiliarTO);
    }

    @Override
    public JasperPrint generarReporteBalanceComprobacion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, List<ConBalanceComprobacionTO> listConBalanceComprobacionTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteBalanceComprobacion(sisUsuarioEmpresaTO, fechaDesde, fechaHasta, listConBalanceComprobacionTO);
    }

    @Override
    public JasperPrint generarReporteBalanceGeneral(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            String codigoSector, List<ConFunBalanceGeneralNecTO> listConFunBalanceGeneralNecTO, List<ConBalanceGeneralTO> listConBalanceGeneralTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteBalanceGeneral(sisUsuarioEmpresaTO, fechaHasta, codigoSector, listConFunBalanceGeneralNecTO, listConBalanceGeneralTO);
    }

    @Override
    public JasperPrint generarReporteBalanceGeneralComparativo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaAnterior, String fechaActual,
            String codigoSector, List<ConBalanceGeneralComparativoTO> listConBalanceGeneralComparativoTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteBalanceGeneralComparativo(sisUsuarioEmpresaTO, fechaAnterior, fechaActual, codigoSector, listConBalanceGeneralComparativoTO);
    }

    @Override
    public JasperPrint generarReporteBalanceResultado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String codigoSector, Integer columnasEstadosFinancieros, List<ConFunBalanceResultadosNecTO> listConFunBalanceResultadosNecTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteBalanceResultado(sisUsuarioEmpresaTO, fechaDesde, fechaHasta, codigoSector, columnasEstadosFinancieros, listConFunBalanceResultadosNecTO);
    }

    @Override
    public JasperPrint generarReporteContablesVerificacionesCompras(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<ConFunContablesVerificacionesComprasTO> listConFunContablesVerificacionesComprasTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteContablesVerificacionesCompras(sisUsuarioEmpresaTO, fechaDesde, fechaHasta, listConFunContablesVerificacionesComprasTO);
    }

    @Override
    public JasperPrint generarReporteConListaBalanceResultadosVsInventario(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            List<ConListaBalanceResultadosVsInventarioTO> listConListaBalanceResultadosVsInventarioTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteConListaBalanceResultadosVsInventario(sisUsuarioEmpresaTO, fechaDesde, fechaHasta, listConListaBalanceResultadosVsInventarioTO);
    }

    @Override
    public JasperPrint generarReporteContablesVerificacionesErrores(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ConFunContablesVerificacionesTO> listConFunContablesVerificacionesTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteContablesVerificacionesErrores(sisUsuarioEmpresaTO, listConFunContablesVerificacionesTO);
    }

    @Override
    public JasperPrint generarReporteMayorGeneral(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            String cuentaContable, List<ConMayorGeneralTO> listConMayorGeneralTO) throws Exception {
        return generarReporteContabilidadLocal.generarReporteMayorGeneral(
                sisUsuarioEmpresaTO, fechaHasta, cuentaContable, listConMayorGeneralTO);
    }
    
    @Override
     public java.util.List<contabilidad.TO.PersonaTO> getFunPersonaTOs(String empresa, String busquedad) throws Exception {
        return operacionesContabilidadBusinessLocal.getFunPersonaTOs(empresa, busquedad);
    }
    @Override
    public JasperPrint generarReporteCompraContableDetalle(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<ReporteCompraDetalle> reporteCompraDetalles, 
            List<ConContableReporteTO> list) throws Exception 
    {
        return operacionesContabilidadBusinessLocal.generarReporteCompraContableDetalle(
                sisUsuarioEmpresaTO, reporteCompraDetalles, list);
    }
}