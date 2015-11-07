/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.DAO;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;
import rrhh.TO.*;
import rrhh.entity.*;

/**
 *
 * @author misael
 */
@Local
public interface OperacionesRRHHDAOLocal {

    RhCategoria buscarCategoria(String empCodigo, String catNombre) throws Exception;

    RhEmpleado buscarEmpleado(String empCodigo, String empId) throws Exception;

    RhFormaPago buscarFormaPago(Integer fpSecuencia) throws Exception;

    RhFormaPagoBeneficiosSociales buscarFormaPagoBeneficioSocial(Integer fpSecuencia) throws Exception;

    RhBonoConcepto buscarBonoConcepto(Integer bcSecuencia) throws Exception;

    rrhh.entity.RhRol buscarRol(java.lang.Integer secuencial) throws java.lang.Exception;

    rrhh.entity.RhAnticipoMotivo buscarAnticipoMotivo(String empresa, String detalle) throws Exception;

    boolean eliminarRhCategoria(RhCategoriaTO rhCategoriaTO) throws Exception;

    RhCategoriaTO getCategoria(String empCodigo, String catNombre) throws Exception;

    List<RhComboCategoriaTO> getComboCategoria(String empresa) throws Exception;

    RhCtaIessTO buscarCtaRhIess(String empCodigo, String empId) throws Exception;

    String getRhEmpleadoApellidosNombres(String empresa, String id) throws Exception;

    boolean repetidoRhEmpleado(java.lang.String empresa, java.lang.String id, java.lang.String apellidos, java.lang.String nombres) throws java.lang.Exception;

    boolean eliminarRhEmpleado(RhEmpleadoTO rhEmpleadoTO) throws Exception;

    List<RhEmpleadoTO> getListaEmpleado(String empresa, String buscar, boolean estado) throws Exception;

    List<RhListaEmpleadoTO> getListaConsultaEmpleado(String empresa, String buscar, Boolean interno, boolean estado) throws Exception;

    RhEmpleadoRolTO getEmpleadoRolTO(String empresa, String empId) throws Exception;

    boolean getRhEmpleadoAfiliacion(String empresa, String empId) throws Exception;

    boolean getRhEmpleadoRetencion(String empresa, String empId) throws Exception;

    List<RhListaEmpleadoLoteTO> getListaEmpleadoLote(
            String empCodigo,
            String catNombre,
            String sector,
            String fechaHasta,
            String antMotivo) throws Exception;

    List<RhFunPlantillaSueldosLoteTO> getFunPlantillaSueldosLote(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String categoria,
            String sector) throws Exception;
    
    List<RhFunPlantillaSueldosLotePreliminarTO> getFunPlantillaSueldosLotePreliminar(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String categoria,
            String sector) throws Exception;

    java.util.List<rrhh.TO.RhFunPlantillaRolesTO> getRhFunPlantillaRolesTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta, java.lang.String categoria, java.lang.String sector) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunListadoEmpleadosTO> getRhFunListadoEmpleadosTO(java.lang.String empresa, java.lang.String provincia, java.lang.String canton, java.lang.String sector, java.lang.String categoria, boolean estado) throws java.lang.Exception;

    java.lang.Boolean buscarRhFormaPago(java.lang.String ctaContable, java.lang.String empresa) throws java.lang.Exception;

    List<RhListaFormaPagoTO> getListaFormaPago(String empresa) throws Exception;

    List<RhComboFormaPagoTO> getComboFormaPago(String empresa) throws Exception;

    RhCtaFormaPagoTO buscarCtaRhFormaPago(String empCodigo, String fpDetalle) throws Exception;

    RhCtaFormaPagoTO buscarCtaRhAnticipoMotivo(String empCodigo, String fpDetalle) throws Exception;

    java.lang.Boolean buscarRhFormaPagoBeneficioSocial(java.lang.String ctaContable, java.lang.String empresa) throws java.lang.Exception;

    List<RhListaFormaPagoBeneficioSocialTO> getListaFormaPagoBeneficioSocial(String empresa) throws Exception;

    List<RhComboFormaPagoBeneficioSocialTO> getComboFormaPagoBeneficioSocial(String empresa) throws Exception;

    RhCtaFormaPagoBeneficioSocialTO buscarCtaRhFormaPagoBeneficioSocial(String empCodigo, String fpDetalle) throws Exception;

    List<rrhh.TO.RhAnticipoTO> getRhAnticipo(String empresa, String periodo, String numero) throws Exception;

    String buscarCtaRhAnticipo(String empCodigo, String empId) throws Exception;

    List<rrhh.TO.RhPrestamoTO> getRhPrestamo(String empresa, String periodo, String numero) throws Exception;

    String buscarCtaRhPrestamo(String empCodigo, String empId) throws Exception;

    List<rrhh.TO.RhVacacionesTO> getRhVacaciones(String empresa, String periodo, String numero) throws Exception;

    String buscarFechaRhVacaciones(String empCodigo, String empId) throws Exception;

    List<rrhh.TO.RhViaticoTO> getRhViatico(String empresa, String periodo, String numero) throws Exception;

    String buscarCtaRhGastoViaticos(String empCodigo, String empId) throws Exception;

    String buscarCtaRhPorPagarViaticos(String empCodigo, String empId) throws Exception;

    String buscarCtaRhPorPagarImpuestoRenta(String empCodigo, String empId) throws Exception;

    String buscarCtaRhPorPagarUtilidades(String empCodigo, String empId) throws Exception;

    List<rrhh.TO.RhBonoTO> getRhBono(String empresa, String periodo, String numero) throws Exception;

    boolean eliminarRhBonoConcepto(RhBonoConceptoTO rhBonoConceptoTO) throws Exception;

    List<RhListaBonoConceptoTO> getListaBonoConcepto(String empresa) throws Exception;

    List<RhComboBonoConceptoTO> getComboBonoConcepto(String empresa) throws Exception;

    String buscarCtaRhPorPagarBonos(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoBonosND(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoBonos(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoBonoFijoND(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoBonoFijo(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoOtrosIngresosND(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoOtrosIngresos(String empCodigo, String empId) throws Exception;

    String buscarFechaRhRol(String empCodigo, String empId) throws Exception;

    RhCancelarBeneficioSocialTO getRhCancelarBeneficioSocialTO(String empresa, String empleadoId) throws Exception;

    RhRolSueldoEmpleadoTO getRhRolSueldoEmpleado(String empCodigo, String empId) throws Exception;

    RhRolSaldoEmpleadoTO getRhRolSaldoEmpleado(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception;

    List<RhListaRolSaldoEmpleadoDetalladoTO> getRhRolSaldoEmpleadoDetallado(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception;

    java.math.BigDecimal getRhRolSaldoPrestamo(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception;

    List<RhAnulacionesTO> getRhAnulacionesTO(String empresa, String periodo, String tipo, String numero) throws Exception;

    List<RhListaDetalleAnticiposTO> getRhDetalleAnticiposTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId, String formaPago) throws Exception;

    java.util.List<rrhh.TO.RhListaDetalleAnticiposLoteTO> getRhDetalleAnticiposLoteTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhListaDetalleBonosLoteTO> getRhDetalleBonosLoteTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws java.lang.Exception;

    List<RhListaDetalleAnticiposPrestamosTO> getRhDetalleAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception;

    List<RhListaDetallePrestamosTO> getRhDetallePrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception;

    List<RhListaDetalleBonosTO> getRhDetalleBonosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empCategoria,
            String empId,
            String estadoDeducible) throws Exception;

    List<RhListaDetalleViaticosTO> getRhDetalleViaticosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception;

    List<RhListaDetalleRolesTO> getRhDetalleRolesTO(String empCodigo, String fechaDesde, String fechaHasta, String sector, String empCategoria, String empId) throws Exception;

    List<RhDetalleVacionesPagadasGozadasTO> getRhDetalleVacacionesPagadasGozadasTO(String empCodigo, String empId, String sector, String fechaDesde, String fechaHasta, String tipo) throws Exception;

    List<RhListaConsolidadoAnticiposPrestamosTO> getRhConsolidadoAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception;

    List<RhListaConsolidadoBonosViaticosTO> getRhConsolidadoBonosViaticosTO(String empCodigo, String fechaDesde, String fechaHasta) throws Exception;

    List<RhListaConsolidadoRolesTO> getRhConsolidadoRolesTO(String empCodigo, String fechaDesde, String fechaHasta, String sector, String empCategoria, String empId) throws Exception;

    List<RhListaSaldoConsolidadoAnticiposPrestamosTO> getRhSaldoConsolidadoAnticiposPrestamosTO(String empCodigo, String fechaHasta) throws Exception;

    List<RhListaSaldoConsolidadoBonosViaticosTO> getRhSaldoConsolidadoBonosViaticosTO(String empCodigo, String fechaHasta) throws Exception;

    List<RhListaSaldoConsolidadoSueldosPorPagarTO> getRhSaldoConsolidadoSueldosPorPagarTO(String empCodigo, String fechaHasta) throws Exception;

    List<RhListaSaldoIndividualAnticiposPrestamosTO> getRhSaldoIndividualAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empId, String tipo) throws Exception;

    java.util.List<rrhh.TO.RhListaProvisionesTO> getRhListaProvisionesTO(java.lang.String empresa, java.lang.String periodo, java.lang.String sector, java.lang.String status) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhListaProvisionesTO> getRhListaProvisionesComprobanteContableTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws java.lang.Exception;

    rrhh.TO.RhCategoriaProvisionesTO getRhCategoriaProvisionesTO(java.lang.String empresa, java.lang.String categoria) throws java.lang.Exception;

    List<rrhh.TO.RhRolBDTO> getRhRol(String empresa, String periodo, String numero) throws Exception;

    String buscarCategoriaTipo(String empCodigo, String empId, String catNombre) throws Exception;

    java.math.BigDecimal getRhValorImpuestoRenta(String empCodigo, String empId, String fechaHasta, Integer diasLaborados, java.math.BigDecimal rolIngresos) throws Exception;

    String buscarCtaRhPorPagarSueldos(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoSueldos(String empCodigo, String empId) throws Exception;

    public String buscarCtaRhSalarioNeto(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoXiii(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoXiv(String empCodigo, String empId) throws Exception;

    String buscarCtaRhFondoReserva(String empCodigo, String empId) throws Exception;

    String buscarCtaRhLiquidacionBonificacion(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoFondoReserva(String empCodigo, String empId) throws Exception;

    String buscarCtaRhXiii(String empCodigo, String empId) throws Exception;

    String buscarCtaRhXiiiCategoria(String empresa, String categoria) throws Exception;

    String buscarCtaRhXiv(String empCodigo, String empId) throws Exception;

    String buscarCtaRhXivCategoria(String empresa, String categoria) throws Exception;

    String buscarCtaRhVacaciones(String empCodigo, String empId) throws Exception;

    String buscarCtaRhSalarioDigno(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoSalarioDigno(String empCodigo, String empId) throws Exception;

    String buscarCtaRhDesahucio(String empCodigo, String empId) throws Exception;

    String buscarCtaRhGastoDesahucioIntempestivo(String empCodigo, String empId) throws Exception;

    RhParametrosTO getRhParametros(String fechaHasta) throws Exception;

    java.util.List<rrhh.TO.RhXiiiSueldoPeriodoTO> getRhComboXiiiSueldoPeriodoTO() throws java.lang.Exception;

    rrhh.TO.RhXiiiSueldoPeriodoTO buscarRhXiiiSueldoPeriodoTO(java.lang.String descripcion) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunXiiiSueldoCalcularTO> getRhFunCalcularXiiiSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunXiiiSueldoConsultarTO> getRhFunConsultarXiiiSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhXivSueldoPeriodoTO> getRhComboXivSueldoPeriodoTO() throws java.lang.Exception;

    java.util.List<rrhh.TO.RhUtilidadesPeriodoTO> getRhComboUtilidadesPeriodoTO(java.lang.String empresa) throws Exception;

    rrhh.TO.RhXivSueldoPeriodoTO buscarRhXivSueldoPeriodoTO(java.lang.String descripcion) throws java.lang.Exception;

    rrhh.TO.RhUtilidadesPeriodoTO buscarRhUtilidadesPeriodoTO(String descripcion) throws Exception;

    java.util.List<rrhh.TO.RhFunXivSueldoCalcularTO> getRhFunCalcularXivSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunUtilidadesCalcularTO> getRhFunCalcularUtilidades(String empresa, String sector, String desde, String hasta, Integer totalDias, Integer totalCargas, BigDecimal totalPagar) throws Exception;

    java.util.List<rrhh.TO.RhFunXivSueldoConsultarTO> getRhFunConsultarXivSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunUtilidadesConsultarTO> getRhFunConsultarUtilidades(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFormulario107PeriodoFiscalTO> getRhFormulario107PeriodoFiscalComboTO() throws java.lang.Exception;

    rrhh.TO.RhFormulario107TO getRhFormulario107ConsultaTO(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, java.lang.String empleadoID) throws java.lang.Exception;

    rrhh.TO.RhFormulario107TO getRhFormulario107TO(java.lang.String empresa, java.lang.String anio, java.lang.String empleadoID) throws java.lang.Exception;

    rrhh.entity.RhFormulario107 getRhFormulario107(java.lang.String empresa, java.lang.String anio, java.lang.String empleadoID) throws java.lang.Exception;

    java.math.BigDecimal getValorRecalculadoIR(java.math.BigDecimal valor, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoXiiis(java.lang.String empresa, java.lang.String fecha, java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoXivs(java.lang.String empresa, java.lang.String fecha, java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoAnticipos(
            java.lang.String empresa,
            java.lang.String fecha,
            java.lang.String cuenta,
            String tipoPreAviso,
            String servicio) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoPichinchaTO> getRhFunPreavisoAnticiposPichincha(java.lang.String empresa, java.lang.String fecha, java.lang.String cuenta, String tipo) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoPrestamos(java.lang.String empresa, java.lang.String fecha, java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoSueldos(java.lang.String empresa, java.lang.String fecha, java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunFormulario107TO> getRhFunFormulario107(String empresa, String desde, String hasta, Character status) throws Exception;

    java.util.List<rrhh.TO.RhFunFormulario107_2013TO> getRhFunFormulario107_2013(java.lang.String empresa, java.lang.String desde, java.lang.String hasta, Character status) throws Exception;

    boolean getSwInactivaEmpleado(java.lang.String empresa, java.lang.String empleado) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoVacaciones(java.lang.String empresa, java.lang.String fecha, java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhConsolidadoIngresosTabuladoTO> getConsolidadoIngresosTabulado(String empresa, String codigoSector, String fechaInicio, String fechaFin) throws Exception;

    rrhh.entity.RhEmpleadoDescuentosFijos getRhEmpleadoDescuentosFijos(Integer secuencial) throws Exception;

    java.util.List<rrhh.TO.RhEmpleadoDescuentosFijosTO> getRhEmpleadoDescuentosFijosTO(String empresa, String empresaID) throws Exception;

    java.util.List<rrhh.entity.RhEmpleadoDescuentosFijos> getRhEmpleadoDescuentosFijos(String empresa, String empresaID) throws Exception;

    java.util.List<rrhh.TO.RhProvisionFechasTO> getProvisionPorFechas(String empresa, String codigoSector, String fechaInicio, String fechaFin, String agrupacion) throws Exception;

    java.lang.Boolean buscarRhAnticipoMotivo(String empresa, String detalle) throws java.lang.Exception;

    java.lang.Boolean comprobarEliminarRhAnticipoMotivo(String empresa, String detalle) throws java.lang.Exception;

    List<RhAnticipoMotivoTO> getListaRhAnticipoMotivoTablaTO(String empresa) throws Exception;

    List<RhAnticipoMotivoTO> getListaRhAnticipoMotivoTOTablaTO(String empresa, String codigo) throws Exception;

    rrhh.TO.RhAnticipoMotivoTO getRhAnticipoMotivoTO(String empresa, String detalle) throws Exception;

    rrhh.entity.RhAnticipoMotivo getRhAnticipoMotivo(String empresa, String codigo) throws Exception;

    boolean comprobarRhXiiiSueldoPeriodoTO(String descripcion) throws Exception;

    boolean comprobarRhXivSueldoPeriodoTO(String descripcion) throws Exception;

    rrhh.entity.RhXiiiSueldoPeriodo buscarRhXiiiSueldoPeriodo(Integer secucenciaPeriodo) throws Exception;

    rrhh.entity.RhXivSueldoPeriodo buscarRhXivSueldoPeriodo(Integer secucenciaPeriodo) throws Exception;

    boolean comprobarRhUtilidadesPeriodo(String utiEmpresa, String utiDescripcion) throws Exception;
}
