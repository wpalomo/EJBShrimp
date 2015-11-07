/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.business;

import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import rrhh.TO.*;
import rrhh.reporte.*;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author misael
 */
@Local
public interface OperacionesRRHHBusinessLocal {

    java.lang.String accionRhCategoria(
            rrhh.TO.RhCategoriaTO rhCategoriaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    RhCategoriaTO getRhCategoriaTO(
            String empCodigo,
            String catNombre) throws Exception;

    List<RhComboCategoriaTO> getComboRhCategoriaTO(String empresa) throws Exception;

    String insertarRhEmpleado(
            RhEmpleadoTO rhEmpleadoTO,
            java.util.List<RhEmpleadoDescuentosFijosTO> ListarhEmpleadoDescuentosFijosTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String guardarImagenEmpleado(byte[] imagen, String nombre) throws Exception;

    String eliminarImagenEmpleado(String nombre) throws Exception;

    byte[] obtenerImagenEmpleado(String nombre) throws Exception;

    String modificarRhEmpleado(
            RhEmpleadoTO rhEmpleadoTO,
            List<RhEmpleadoDescuentosFijosTO> listaModificar,
            List<RhEmpleadoDescuentosFijosTO> listaEliminar,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String eliminarRhEmpleado(
            RhEmpleadoTO rhEmpleadoTO,
            List<RhEmpleadoDescuentosFijosTO> listaEliminar,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    List<RhEmpleadoTO> getListaRhEmpleadoTO(
            String empresa,
            String buscar,
            boolean estado) throws Exception;

    List<RhListaEmpleadoTO> getListaConsultaEmpleadoTO(
            String empresa,
            String buscar,
            Boolean interno,
            boolean estado) throws Exception;

    List<RhListaEmpleadoLoteTO> getListaEmpleadoLoteTO(
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

    java.util.List<rrhh.TO.RhFunPlantillaRolesTO> getRhFunPlantillaRolesTO(
            java.lang.String empresa,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta,
            java.lang.String categoria,
            java.lang.String sector) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunListadoEmpleadosTO> getRhFunListadoEmpleadosTO(
            java.lang.String empresa,
            java.lang.String provincia,
            java.lang.String canton,
            java.lang.String sector,
            java.lang.String categoria,
            boolean estado) throws java.lang.Exception;

    java.lang.String accionRhAvisosEntrada(
            rrhh.TO.RhAvisoEntradaTO rhAvisoEntradaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String accionRhFormaPago(
            rrhh.TO.RhFormaPagoTO rhFormaPagoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    List<RhListaFormaPagoTO> getListaFormaPagoTO(String empresa) throws Exception;

    List<RhComboFormaPagoTO> getComboFormaPagoTO(String empresa) throws Exception;

    java.lang.String accionRhFormaPagoBeneficioSocial(
            rrhh.TO.RhFormaPagoBeneficioSocialTO rhFormaPagoBeneficioSocialTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    List<RhListaFormaPagoBeneficioSocialTO> getListaFormaPagoBeneficioSocialTO(String empresa) throws Exception;

    List<RhComboFormaPagoBeneficioSocialTO> getComboFormaPagoBeneficioSocialTO(String empresa) throws Exception;

    RhContableTO insertarRhAnticipoConContable(
            RhAnticipoCabeceraTO rhAnticipoCabeceraTO,
            List<RhAnticipoDetalleTO> rhAnticipoDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    RhContableTO insertarRhPrestamoConContable(
            RhPrestamoTO rhPrestamoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    RhContableTO insertarRhViaticoConContable(
            RhViaticoTO rhViaticoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    RhContableTO insertarRhBonoConContable(
            RhBonoCabeceraTO rhBonoCabeceraTO,
            List<RhBonoDetalleTO> rhBonoDetalleTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    RhContableTO insertarRhVacacionesConContable(
            RhVacacionesTO rhVacacionesTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    RhContableTO insertarRhSalarioDignoContable(
            rrhh.TO.RhSalarioDignoTO rhSalarioDignoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    boolean insertarRhBonoConcepto(
            RhBonoConceptoTO rhBonoConceptoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean modificarRhBonoConcepto(
            RhBonoConceptoTO rhBonoConceptoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean eliminarRhBonoConcepto(
            RhBonoConceptoTO rhBonoConceptoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    List<RhListaBonoConceptoTO> getListaBonoConceptoTO(String empresa) throws Exception;

    List<RhComboBonoConceptoTO> getComboBonoConceptoTO(String empresa) throws Exception;

    RhParametrosTO getRhParametros(String fechaHasta) throws Exception;

    boolean getRhEmpleadoRetencion(String empCodigo, String empId) throws Exception;

    RhCtaIessTO buscarCtaRhIess(String empCodigo, String empId) throws Exception;

    RhCancelarBeneficioSocialTO getRhCancelarBeneficioSocialTO(String empCodigo, String empId) throws Exception;

    java.math.BigDecimal getRhValorImpuestoRenta(
            String empCodigo,
            String empId,
            String fechaHasta,
            Integer diasLaborados,
            java.math.BigDecimal rolIngresos) throws Exception;

    RhContableTO insertarRhRolLoteConContable(
            java.util.List<RhFunPlantillaSueldosLoteTO> RhFunPlantillaSueldosLoteTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    RhContableTO insertarRhRolConContable(
            RhRolEmpleadoTO rhRolEmpleadoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    List<RhListaRolSaldoEmpleadoDetalladoTO> getRhRolSaldoEmpleadoDetalladoTO(
            String empCodigo,
            String empId,
            String fechaDesde,
            String fechaHasta) throws Exception;

    RhRolSueldoEmpleadoTO getRhRolSueldoEmpleadoTO(
            String empCodigo,
            String empId) throws Exception;

    java.math.BigDecimal getRhRolSaldoPrestamo(
            String empCodigo,
            String empId,
            String fechaDesde,
            String fechaHasta) throws Exception;

    java.util.List<rrhh.TO.RhAnulacionesTO> getRhAnulacionesTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String tipo,
            java.lang.String numero) throws Exception;

    java.util.List<java.lang.String> anularReversarRhConContable(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String tipo,
            java.lang.String numero,
            java.lang.String usuario,
            java.lang.String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    List<RhListaDetalleAnticiposTO> getRhDetalleAnticiposTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empCategoria,
            String empId,
            String formaPago) throws Exception;

    java.util.List<rrhh.TO.RhListaDetalleAnticiposLoteTO> getRhDetalleAnticiposLoteTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String tipo,
            java.lang.String numero) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhListaDetalleBonosLoteTO> getRhDetalleBonosLoteTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String tipo,
            java.lang.String numero) throws java.lang.Exception;

    List<RhListaDetalleAnticiposPrestamosTO> getRhDetalleAnticiposPrestamosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empCategoria,
            String empId) throws Exception;

    List<RhListaDetallePrestamosTO> getRhDetallePrestamosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empCategoria,
            String empId) throws Exception;

    List<RhListaDetalleBonosTO> getRhDetalleBonosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empCategoria,
            String empId,
            String estadoDeducible) throws Exception;

    List<RhListaDetalleViaticosTO> getRhDetalleViaticosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empCategoria,
            String empId) throws Exception;

    List<RhListaDetalleRolesTO> getRhDetalleRolesTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String sector,
            String empCategoria,
            String empId) throws Exception;

    List<RhDetalleVacionesPagadasGozadasTO> getRhDetalleVacacionesPagadasGozadasTO(
            String empCodigo,
            String empId,
            String sector,
            String fechaDesde,
            String fechaHasta,
            String tipo) throws Exception;

    List<RhListaConsolidadoAnticiposPrestamosTO> getRhConsolidadoAnticiposPrestamosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empCategoria,
            String empId) throws Exception;

    List<RhListaConsolidadoBonosViaticosTO> getRhConsolidadoBonosViaticosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta) throws Exception;

    List<RhListaConsolidadoRolesTO> getRhConsolidadoRolesTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String sector,
            String empCategoria,
            String empId) throws Exception;

    List<RhListaSaldoConsolidadoAnticiposPrestamosTO> getRhSaldoConsolidadoAnticiposPrestamosTO(
            String empCodigo,
            String fechaHasta) throws Exception;

    List<RhListaSaldoConsolidadoBonosViaticosTO> getRhSaldoConsolidadoBonosViaticosTO(
            String empCodigo,
            String fechaHasta) throws Exception;

    List<RhListaSaldoConsolidadoSueldosPorPagarTO> getRhSaldoConsolidadoSueldosPorPagarTO(
            String empCodigo,
            String fechaHasta) throws Exception;

    List<RhListaSaldoIndividualAnticiposPrestamosTO> getRhSaldoIndividualAnticiposPrestamosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empId,
            String tipo) throws Exception;

    rrhh.TO.RhContableTO insertarRhListaProvisionesConContable(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String sector,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhListaProvisionesTO> getRhListaProvisionesTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String sector,
            java.lang.String status) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhListaProvisionesTO> getRhListaProvisionesComprobanteContableTO(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String tipo,
            java.lang.String numero) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhXiiiSueldoPeriodoTO> getRhComboXiiiSueldoPeriodoTO() throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunXiiiSueldoCalcularTO> getRhFunCalcularXiiiSueldo(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunXiiiSueldoConsultarTO> getRhFunConsultarXiiiSueldo(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception;

    rrhh.TO.RhContableTO insertarRhXiiiSueldoConContable(
            java.lang.String empresa,
            java.lang.String periodoXiii,
            java.lang.String formaPago,
            java.lang.String documento,
            java.lang.String observaciones,
            java.util.List<rrhh.TO.RhFunXiiiSueldoCalcularTO> rhFunXiiiSueldoCalcularTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhXivSueldoPeriodoTO> getRhComboXivSueldoPeriodoTO() throws java.lang.Exception;

    java.util.List<rrhh.TO.RhUtilidadesPeriodoTO> getRhComboUtilidadesPeriodoTO(java.lang.String empresa) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunXivSueldoCalcularTO> getRhFunCalcularXivSueldo(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunUtilidadesCalcularTO> getRhFunCalcularUtilidades(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.Integer totalDias,
            java.lang.Integer totalCargas,
            java.math.BigDecimal totalPagar) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunXivSueldoConsultarTO> getRhFunConsultarXivSueldo(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunUtilidadesConsultarTO> getRhFunConsultarUtilidades(
            java.lang.String empresa,
            java.lang.String sector,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception;

    rrhh.TO.RhContableTO insertarRhXivSueldoConContable(
            java.lang.String empresa,
            java.lang.String periodoXiv,
            java.lang.String formaPago,
            java.lang.String documento,
            java.lang.String observaciones,
            java.util.List<rrhh.TO.RhFunXivSueldoCalcularTO> rhFunXivSueldoCalcularTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    rrhh.TO.RhContableTO insertarRhUtilidadesConContable(
            java.lang.String empresa,
            java.lang.String periodoXiv,
            java.lang.String formaPago,
            java.lang.String documento,
            java.lang.String observaciones,
            java.util.List<rrhh.TO.RhFunUtilidadesTO> rhFunUtilidadesCalcularTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    java.util.List<rrhh.TO.RhFormulario107PeriodoFiscalTO> getRhFormulario107PeriodoFiscalComboTO() throws java.lang.Exception;

    rrhh.TO.RhFormulario107TO getRhFormulario107ConsultaTO(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String empleadoID) throws java.lang.Exception;

    rrhh.TO.RhFormulario107TO getRhFormulario107TO(
            java.lang.String empresa,
            java.lang.String anio,
            java.lang.String empleadoID) throws java.lang.Exception;

    java.lang.String insertarRhFormulario107TO(
            rrhh.TO.RhFormulario107TO rhFormulario107TO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.math.BigDecimal getValorRecalculadoIR(
            java.math.BigDecimal valor,
            java.lang.String desde,
            java.lang.String hasta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoXiiis(
            java.lang.String empresa,
            java.lang.String fecha,
            java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoXivs(
            java.lang.String empresa,
            java.lang.String fecha,
            java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoAnticipos(
            java.lang.String empresa,
            java.lang.String fecha,
            java.lang.String cuenta,
            String tipoPreAviso,
            String servicio) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoPichinchaTO> getRhFunPreavisoAnticiposPichincha(
            java.lang.String empresa,
            java.lang.String fecha,
            java.lang.String cuenta,
            String tipo) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoPrestamos(
            java.lang.String empresa,
            java.lang.String fecha,
            java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoSueldos(
            java.lang.String empresa,
            java.lang.String fecha,
            java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhFunFormulario107TO> getRhFunFormulario107(
            String empresa,
            String desde,
            String hasta,
            Character status) throws Exception;

    java.util.List<rrhh.TO.RhFunFormulario107_2013TO> getRhFunFormulario107_2013(
            java.lang.String empresa,
            java.lang.String desde,
            java.lang.String hasta,
            Character status) throws Exception;

    boolean getSwInactivaEmpleado(
            java.lang.String empresa,
            java.lang.String empleado) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoVacaciones(
            java.lang.String empresa,
            java.lang.String fecha,
            java.lang.String cuenta) throws java.lang.Exception;

    helper.RetornoTO getConsolidadoIngresosTabulado(
            java.lang.String empresa,
            java.lang.String codigoSector,
            java.lang.String fechaInicio,
            java.lang.String fechaFin,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<rrhh.TO.RhEmpleadoDescuentosFijosTO> getRhEmpleadoDescuentosFijosTO(
            String empresa,
            String empresaID) throws Exception;

    java.util.List<rrhh.entity.RhEmpleadoDescuentosFijos> getRhEmpleadoDescuentosFijos(
            String empresa,
            String empresaID) throws Exception;

    helper.RetornoTO getProvisionPorFechas(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String agrupacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String accionRhAnticipoMotivo(
            rrhh.TO.RhAnticipoMotivoTO rhAnticipoMotivoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    List<RhAnticipoMotivoTO> getListaRhAnticipoMotivoTablaTO(String empresa) throws Exception;

    List<RhAnticipoMotivoTO> getListaRhAnticipoMotivoTOTablaTO(
            String empresa,
            String codigo) throws Exception;

    rrhh.TO.RhAnticipoMotivoTO getRhAnticipoMotivoTO(
            String empresa,
            String detalle) throws Exception;

    rrhh.entity.RhAnticipoMotivo getRhAnticipoMotivo(
            String empresa,
            String codigo) throws Exception;

    java.lang.String accionRhXiiiSueldoPeriodo(
            rrhh.TO.RhXiiiSueldoPeriodoTO rhXiiiSueldoPeriodoTO,
            java.lang.String codigoEmpresa,
            java.lang.String codigoUsuario,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String accionRhXivSueldoPeriodo(
            rrhh.TO.RhXivSueldoPeriodoTO rhXivSueldoPeriodoTO,
            java.lang.String codigoEmpresa,
            java.lang.String codigoUsuario,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String accionRhUtilidadesPeriodo(
            rrhh.TO.RhUtilidadesPeriodoTO rhUtilidadesPeriodoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    JasperPrint generarReporteConsolidadoAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            java.lang.String fechaDesde,
            java.lang.String fechaHasta,
            List<RhListaConsolidadoAnticiposPrestamosTO> listaConsolidadoAnticiposPrestamosTO) throws Exception ;
    
    JasperPrint generarReporteListaDetalleVacaionesPagadas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String desde, String hasta,
            String empSector, List<RhDetalleVacionesPagadasGozadasTO> listaDetalleVacacionesPagadasGozadasTO) throws Exception;

    JasperPrint generarReporteDetalleAnticipos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empId,
            String empCodigo, String empCategoria, String fechaDesde,
            String fechaHasta,
            List<RhListaDetalleAnticiposTO> listaDetalleAnticiposTO) throws Exception;

    JasperPrint generarReporteDetalleAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empCodigo,
            String fechaDesde, String fechaHasta, String empCategoria,
            String empId,
            List<RhListaDetalleAnticiposPrestamosTO> listaDetalleAnticiposPrestamosTO) throws Exception;

    JasperPrint generarReporteDetallePrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empCodigo, String fechaDesde,
            String fechaHasta, String empCategoria, String empId,
            List<RhListaDetallePrestamosTO> listaDetallePrestamosTO) throws Exception;

    JasperPrint generarReporteDetalleBonos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaDetalleBonosTO> listaDetalleBonosTO) throws Exception;

    JasperPrint generarReporteDetalleBonosLote(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String periodo, String tipo, String numero,
            List<RhListaDetalleBonosLoteTO> listaDetalleBonosLoteTO) throws Exception;

    JasperPrint generarReporteDetalleViaticos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaDetalleViaticosTO> listaDetalleViaticosTO) throws Exception;

    JasperPrint generarReporteConsolidadoBonosViatico(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta,
            List<RhListaConsolidadoBonosViaticosTO> listaConsolidadoBonosViaticosTO) throws Exception;

    JasperPrint generarReporteListadoRolesPago(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaDetalleRolesTO> listaDetalleRolesTO) throws Exception;

    JasperPrint generarReporteConsolidadoRoles(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde,
            String fechaHasta, String empCategoria,
            String nombreEmpleado,
            List<RhListaConsolidadoRolesTO> listaConsolidadoRolesTO) throws Exception;

    JasperPrint generarReporteSaldoIndividualAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta, String empId,
            List<RhListaSaldoIndividualAnticiposPrestamosTO> listaSaldoIndividualAnticiposPrestamosTO) throws Exception;

    JasperPrint generarReporteSaldoConsolidadoAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoAnticiposPrestamosTO> listaSaldoConsolidadoAnticiposPrestamosTO) throws Exception;

    JasperPrint generarReporteSaldoConsolidadoBonosViaticos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoBonosViaticosTO> listaSaldoConsolidadoBonosViaticosTO) throws Exception;

    JasperPrint generarReporteSaldoConsolidadoSueldosPorPagar(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoSueldosPorPagarTO> listaSaldoConsolidadoSueldosPorPagarTO) throws Exception;

    JasperPrint generarReporteXiiiSueldoConsulta(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta,
            String fechaMaxima,
            List<RhFunXiiiSueldoConsultarTO> rhFunXiiiSueldoConsultarTO) throws Exception;

    JasperPrint generarReporteXivSueldoConsulta(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta,
            String fechaMaxima,
            List<RhFunXivSueldoConsultarTO> rhFunXivSueldoConsultarTO) throws Exception;

    JasperPrint generarReporteUtilidadesPreCalculo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta,
            String fechaMaxima,
            List<RhFunUtilidadesCalcularTO> rhFunUtilidadesCalcularTOs) throws Exception;

    JasperPrint generarReporteProvisionesComprobanteContable(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String periodo, String tipo, String numero,
            List<RhListaProvisionesTO> listaProvisionesTO) throws Exception;

    JasperPrint generarReporteFormulario107(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaEntrega, String rucEmpleador, String razonSocial,
            String rucContador, RhFormulario107TO rhFormulario107TOGuardar) throws Exception;

    JasperPrint generarReporteAnticipo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteAnticipoOprestamo> rhReporteAnticipoOprestamos) throws Exception;

    JasperPrint generarReporteConsultaAnticiposLote(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteConsultaAnticiposLote> lista) throws Exception;

    JasperPrint generarReportePrestamoVista(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteAnticipoOprestamo> lista) throws Exception;

    JasperPrint generarReporteRol(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReportesRol> lista) throws Exception;

    JasperPrint generarReporteEmpleado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteEmpleado> listReporteEmpleado) throws Exception;

    public JasperPrint generarReporteRol2(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, 
            List<AuxiliarReporteDetalleRoles> lista);
    
}
