/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.facade;

import java.util.List;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import rrhh.TO.*;
import rrhh.business.OperacionesRRHHBusinessLocal;
import rrhh.entity.RhEmpleadoDescuentosFijos;
import rrhh.reporte.*;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesRRHHFacade implements OperacionesRRHHFacadeRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @javax.ejb.EJB
    OperacionesRRHHBusinessLocal operacionesRRHHBusinessLocal;

    // <editor-fold defaultstate="collapsed" desc="CATEGORIA">
    @Override
    public String accionRhCategoria(
            rrhh.TO.RhCategoriaTO rhCategoriaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.accionRhCategoria(
                rhCategoriaTO,
                accion,
                sisInfoTO);
    }

    @Override
    public RhCategoriaTO getRhCategoriaTO(String empCodigo, String catNombre) throws Exception {
        return operacionesRRHHBusinessLocal.getRhCategoriaTO(empCodigo, catNombre);
    }

    @Override
    public List<RhComboCategoriaTO> getComboRhCategoriaTO(String empresa) throws Exception {
        return operacionesRRHHBusinessLocal.getComboRhCategoriaTO(empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="EMPLEADO">
    @Override
    public String insertarRhEmpleado(
            RhEmpleadoTO rhEmpleadoTO,
            java.util.List<RhEmpleadoDescuentosFijosTO> ListarhEmpleadoDescuentosFijosTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhEmpleado(
                rhEmpleadoTO,
                ListarhEmpleadoDescuentosFijosTO,
                sisInfoTO);
    }

    @Override
    public String guardarImagenEmpleado(byte[] imagen, String nombre) throws Exception {
        return operacionesRRHHBusinessLocal.guardarImagenEmpleado(imagen, nombre);
    }

    @Override
    public String eliminarImagenEmpleado(String nombre) throws Exception {
        return operacionesRRHHBusinessLocal.eliminarImagenEmpleado(nombre);
    }

    @Override
    public byte[] obtenerImagenEmpleado(String nombre) throws Exception {
        return operacionesRRHHBusinessLocal.obtenerImagenEmpleado(nombre);
    }

    @Override
    public String modificarRhEmpleado(
            RhEmpleadoTO rhEmpleadoTO,
            List<RhEmpleadoDescuentosFijosTO> listaModificar,
            List<RhEmpleadoDescuentosFijosTO> listaEliminar,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.modificarRhEmpleado(
                rhEmpleadoTO,
                listaModificar,
                listaEliminar,
                sisInfoTO);
    }

    @Override
    public String eliminarRhEmpleado(
            RhEmpleadoTO rhEmpleadoTO,
            List<RhEmpleadoDescuentosFijosTO> listaEliminar,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.eliminarRhEmpleado(
                rhEmpleadoTO,
                listaEliminar,
                sisInfoTO);
    }

    @Override
    public List<RhEmpleadoTO> getListaRhEmpleadoTO(String empresa, String buscar, boolean estado) throws Exception {
//        java.util.Date inicio = new java.util.Date();
        List<RhEmpleadoTO> a = operacionesRRHHBusinessLocal.getListaRhEmpleadoTO(empresa, buscar, estado);
//        java.util.Date fin = new java.util.Date();
        return a;
    }

    @Override
    public java.util.List<rrhh.TO.RhFunListadoEmpleadosTO> getRhFunListadoEmpleadosTO(java.lang.String empresa, java.lang.String provincia, java.lang.String canton, java.lang.String sector, java.lang.String categoria, boolean estado) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhFunListadoEmpleadosTO(empresa, provincia, canton, sector, categoria, estado);
    }

    @Override
    public List<RhListaEmpleadoTO> getListaConsultaEmpleadoTO(String empresa, String buscar, Boolean interno, boolean estado) throws Exception {
        return operacionesRRHHBusinessLocal.getListaConsultaEmpleadoTO(empresa, buscar, interno, estado);
    }

    @Override
    public List<RhListaEmpleadoLoteTO> getListaEmpleadoLoteTO(
            String empCodigo,
            String catNombre,
            String sector,
            String fechaHasta,
            String antMotivo) throws Exception {
        return operacionesRRHHBusinessLocal.getListaEmpleadoLoteTO(
                empCodigo,
                catNombre,
                sector,
                fechaHasta,
                antMotivo);
    }

    @Override
    public List<RhFunPlantillaSueldosLoteTO> getFunPlantillaSueldosLote(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String categoria,
            String sector) throws Exception {
        return operacionesRRHHBusinessLocal.getFunPlantillaSueldosLote(
                empCodigo,
                fechaDesde,
                fechaHasta,
                categoria,
                sector);
    }
    @Override
    public List<RhFunPlantillaSueldosLotePreliminarTO> getFunPlantillaSueldosLotePreliminar(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String categoria,
            String sector) throws Exception {
        return operacionesRRHHBusinessLocal.getFunPlantillaSueldosLotePreliminar(
                empCodigo,
                fechaDesde,
                fechaHasta,
                categoria,
                sector);
    }

    @Override
    public java.util.List<rrhh.TO.RhFunPlantillaRolesTO> getRhFunPlantillaRolesTO(java.lang.String empresa, java.lang.String fechaDesde, java.lang.String fechaHasta, java.lang.String categoria, java.lang.String sector) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhFunPlantillaRolesTO(empresa, fechaDesde, fechaHasta, categoria, sector);
    }

    @Override
    public java.lang.String accionRhAvisosEntrada(
            rrhh.TO.RhAvisoEntradaTO rhAvisoEntradaTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.accionRhAvisosEntrada(
                rhAvisoEntradaTO,
                accion,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMAPAGO">
    @Override
    public java.lang.String accionRhFormaPago(
            RhFormaPagoTO rhFormaPagoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.accionRhFormaPago(
                rhFormaPagoTO,
                accion,
                sisInfoTO);
    }

    @Override
    public List<RhListaFormaPagoTO> getListaRhFormaPagoTO(String empresa) throws Exception {
        return operacionesRRHHBusinessLocal.getListaFormaPagoTO(empresa);
    }

    @Override
    public List<RhComboFormaPagoTO> getComboRhFormaPagoTO(String empresa) throws Exception {
        return operacionesRRHHBusinessLocal.getComboFormaPagoTO(empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMAPAGOBENEFICIOSOCIAL">
    @Override
    public java.lang.String accionRhFormaPagoBeneficioSocial(
            rrhh.TO.RhFormaPagoBeneficioSocialTO rhFormaPagoBeneficioSocialTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.accionRhFormaPagoBeneficioSocial(
                rhFormaPagoBeneficioSocialTO,
                accion,
                sisInfoTO);
    }

    @Override
    public List<RhListaFormaPagoBeneficioSocialTO> getListaRhFormaPagoBeneficioSocialTO(String empresa) throws Exception {
        return operacionesRRHHBusinessLocal.getListaFormaPagoBeneficioSocialTO(empresa);
    }

    @Override
    public List<RhComboFormaPagoBeneficioSocialTO> getComboRhFormaPagoBeneficioSocialTO(String empresa) throws Exception {
        return operacionesRRHHBusinessLocal.getComboFormaPagoBeneficioSocialTO(empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ANTICIPO">
    @Override
    public RhContableTO insertarRhAnticipoConContable(
            RhAnticipoCabeceraTO rhAnticipoCabeceraTO,
            List<RhAnticipoDetalleTO> rhAnticipoDetalleTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhAnticipoConContable(
                rhAnticipoCabeceraTO,
                rhAnticipoDetalleTO,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PRESTAMO">
    @Override
    public RhContableTO insertarRhPrestamoConContable(
            RhPrestamoTO rhPrestamoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhPrestamoConContable(
                rhPrestamoTO,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VACACIONES">
    @Override
    public RhContableTO insertarRhVacacionesConContable(
            RhVacacionesTO rhVacacionesTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhVacacionesConContable(
                rhVacacionesTO,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SALARIO DIGNO">
    @Override
    public RhContableTO insertarRhSalarioDignoContable(
            RhSalarioDignoTO rhSalarioDignoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhSalarioDignoContable(
                rhSalarioDignoTO,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VIATICO">
    @Override
    public RhContableTO insertarRhViaticoConContable(
            RhViaticoTO rhViaticoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhViaticoConContable(
                rhViaticoTO,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BONO">
    @Override
    public RhContableTO insertarRhBonoConContable(
            RhBonoCabeceraTO rhBonoCabeceraTO,
            List<RhBonoDetalleTO> rhBonoDetalleTOs,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhBonoConContable(
                rhBonoCabeceraTO,
                rhBonoDetalleTOs,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BONO CONCEPTO">
    @Override
    public boolean insertarRhBonoConcepto(
            RhBonoConceptoTO rhBonoConceptoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhBonoConcepto(
                rhBonoConceptoTO,
                sisInfoTO);
    }

    @Override
    public boolean modificarRhBonoConcepto(
            RhBonoConceptoTO rhBonoConceptoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.modificarRhBonoConcepto(
                rhBonoConceptoTO,
                sisInfoTO);
    }

    @Override
    public boolean eliminarRhBonoConcepto(
            RhBonoConceptoTO rhBonoConceptoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.eliminarRhBonoConcepto(
                rhBonoConceptoTO,
                sisInfoTO);
    }

    @Override
    public List<RhListaBonoConceptoTO> getListaRhBonoConceptoTO(String empresa) throws Exception {
        return operacionesRRHHBusinessLocal.getListaBonoConceptoTO(empresa);
    }

    @Override
    public List<RhComboBonoConceptoTO> getComboRhBonoConceptoTO(String empresa) throws Exception {
        return operacionesRRHHBusinessLocal.getComboBonoConceptoTO(empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ROL">
    @Override
    public RhParametrosTO getRhParametros(String fechaHasta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhParametros(fechaHasta);
    }

    @Override
    public boolean getRhEmpleadoRetencion(String empCodigo, String empId) throws Exception {
        return operacionesRRHHBusinessLocal.getRhEmpleadoRetencion(empCodigo, empId);
    }

    @Override
    public RhCtaIessTO buscarCtaRhIess(String empCodigo, String empId) throws Exception {
        return operacionesRRHHBusinessLocal.buscarCtaRhIess(empCodigo, empId);
    }

    @Override
    public RhCancelarBeneficioSocialTO getRhCancelarBeneficioSocialTO(String empCodigo, String empId) throws Exception {
        return operacionesRRHHBusinessLocal.getRhCancelarBeneficioSocialTO(empCodigo, empId);
    }

    @Override
    public java.math.BigDecimal getRhValorImpuestoRenta(
            String empCodigo,
            String empId,
            String fechaHasta,
            Integer diasLaborados,
            java.math.BigDecimal rolIngresos) throws Exception {
        return operacionesRRHHBusinessLocal.getRhValorImpuestoRenta(
                empCodigo,
                empId,
                fechaHasta,
                diasLaborados,
                rolIngresos);
    }

    @Override
    public RhContableTO insertarRhRolConContable(
            RhRolEmpleadoTO rhRolEmpleadoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhRolConContable(
                rhRolEmpleadoTO,
                sisInfoTO);
    }

    @Override
    public List<RhListaRolSaldoEmpleadoDetalladoTO> getRhRolSaldoEmpleadoDetalladoTO(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhRolSaldoEmpleadoDetalladoTO(empCodigo, empId, fechaDesde, fechaHasta);
    }

    @Override
    public RhRolSueldoEmpleadoTO getRhRolSueldoEmpleadoTO(String empCodigo, String empId) throws Exception {
        return operacionesRRHHBusinessLocal.getRhRolSueldoEmpleadoTO(empCodigo, empId);
    }

    @Override
    public java.math.BigDecimal getRhRolSaldoPrestamo(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhRolSaldoPrestamo(empCodigo, empId, fechaDesde, fechaHasta);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ANULACIONES">
    public java.util.List<rrhh.TO.RhAnulacionesTO> getRhAnulacionesTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws Exception {
        return operacionesRRHHBusinessLocal.getRhAnulacionesTO(empresa, periodo, tipo, numero);
    }

    public java.util.List<java.lang.String> anularReversarRhConContable(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String tipo,
            java.lang.String numero,
            java.lang.String usuario,
            java.lang.String accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.anularReversarRhConContable(
                empresa,
                periodo,
                tipo,
                numero,
                usuario,
                accion,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DETALLES">
    @Override
    public List<RhListaDetalleAnticiposTO> getRhDetalleAnticiposTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId, String formaPago) throws Exception {
        return operacionesRRHHBusinessLocal.getRhDetalleAnticiposTO(empCodigo, fechaDesde, fechaHasta, empCategoria, empId, formaPago);
    }

    @Override
    public java.util.List<rrhh.TO.RhListaDetalleAnticiposLoteTO> getRhDetalleAnticiposLoteTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhDetalleAnticiposLoteTO(empresa, periodo, tipo, numero);
    }

    @Override
    public java.util.List<rrhh.TO.RhListaDetalleBonosLoteTO> getRhDetalleBonosLoteTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhDetalleBonosLoteTO(empresa, periodo, tipo, numero);
    }

    @Override
    public List<RhListaDetalleAnticiposPrestamosTO> getRhDetalleAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        return operacionesRRHHBusinessLocal.getRhDetalleAnticiposPrestamosTO(empCodigo, fechaDesde, fechaHasta, empCategoria, empId);
    }

    @Override
    public List<RhListaDetallePrestamosTO> getRhDetallePrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        return operacionesRRHHBusinessLocal.getRhDetallePrestamosTO(empCodigo, fechaDesde, fechaHasta, empCategoria, empId);
    }

    @Override
    public List<RhListaDetalleBonosTO> getRhDetalleBonosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empCategoria,
            String empId,
            String estadoDeducible) throws Exception {
        return operacionesRRHHBusinessLocal.getRhDetalleBonosTO(
                empCodigo,
                fechaDesde,
                fechaHasta,
                empCategoria,
                empId,
                estadoDeducible);
    }

    @Override
    public List<RhListaDetalleViaticosTO> getRhDetalleViaticosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        return operacionesRRHHBusinessLocal.getRhDetalleViaticosTO(empCodigo, fechaDesde, fechaHasta, empCategoria, empId);
    }

    @Override
    public List<RhListaDetalleRolesTO> getRhDetalleRolesTO(String empCodigo, String fechaDesde, String fechaHasta, String sector, String empCategoria, String empId) throws Exception {
        return operacionesRRHHBusinessLocal.getRhDetalleRolesTO(empCodigo, fechaDesde, fechaHasta, sector, empCategoria, empId);
    }

    @Override
    public List<RhDetalleVacionesPagadasGozadasTO> getRhDetalleVacacionesPagadasGozadasTO(String empCodigo, String empId, String sector, String fechaDesde, String fechaHasta, String tipo) throws Exception {
        return operacionesRRHHBusinessLocal.getRhDetalleVacacionesPagadasGozadasTO(empCodigo, empId, sector, fechaDesde, fechaHasta, tipo);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONSOLIDADOS">
    @Override
    public List<RhListaConsolidadoAnticiposPrestamosTO> getRhConsolidadoAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        return operacionesRRHHBusinessLocal.getRhConsolidadoAnticiposPrestamosTO(empCodigo, fechaDesde, fechaHasta, empCategoria, empId);
    }

    @Override
    public List<RhListaConsolidadoBonosViaticosTO> getRhConsolidadoBonosViaticosTO(String empCodigo, String fechaDesde, String fechaHasta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhConsolidadoBonosViaticosTO(empCodigo, fechaDesde, fechaHasta);
    }

    @Override
    public List<RhListaConsolidadoRolesTO> getRhConsolidadoRolesTO(String empCodigo, String fechaDesde, String fechaHasta, String sector, String empCategoria, String empId) throws Exception {
        return operacionesRRHHBusinessLocal.getRhConsolidadoRolesTO(empCodigo, fechaDesde, fechaHasta, sector, empCategoria, empId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SALDOS CONSOLIDADOS">
    @Override
    public List<RhListaSaldoConsolidadoAnticiposPrestamosTO> getRhSaldoConsolidadoAnticiposPrestamosTO(String empCodigo, String fechaHasta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhSaldoConsolidadoAnticiposPrestamosTO(empCodigo, fechaHasta);
    }

    @Override
    public List<RhListaSaldoConsolidadoBonosViaticosTO> getRhSaldoConsolidadoBonosViaticosTO(String empCodigo, String fechaHasta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhSaldoConsolidadoBonosViaticosTO(empCodigo, fechaHasta);
    }

    @Override
    public List<RhListaSaldoConsolidadoSueldosPorPagarTO> getRhSaldoConsolidadoSueldosPorPagarTO(String empCodigo, String fechaHasta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhSaldoConsolidadoSueldosPorPagarTO(empCodigo, fechaHasta);
    }

    @Override
    public List<RhListaSaldoIndividualAnticiposPrestamosTO> getRhSaldoIndividualAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empId, String tipo) throws Exception {
        return operacionesRRHHBusinessLocal.getRhSaldoIndividualAnticiposPrestamosTO(empCodigo, fechaDesde, fechaHasta, empId, tipo);
    }
    // </editor-fold>

    @Override
    public RhContableTO insertarRhListaProvisionesConContable(
            java.lang.String empresa,
            java.lang.String periodo,
            java.lang.String sector,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhListaProvisionesConContable(
                empresa,
                periodo,
                sector,
                usuario,
                sisInfoTO);
    }

    @Override
    public java.util.List<rrhh.TO.RhListaProvisionesTO> getRhListaProvisionesTO(java.lang.String empresa, java.lang.String periodo, java.lang.String sector, java.lang.String status) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhListaProvisionesTO(empresa, periodo, sector, status);
    }

    @Override
    public java.util.List<rrhh.TO.RhListaProvisionesTO> getRhListaProvisionesComprobanteContableTO(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhListaProvisionesComprobanteContableTO(empresa, periodo, tipo, numero);
    }

    // <editor-fold defaultstate="collapsed" desc="XIII">
    public java.util.List<rrhh.TO.RhXiiiSueldoPeriodoTO> getRhComboXiiiSueldoPeriodoTO() throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhComboXiiiSueldoPeriodoTO();
    }

    public java.util.List<rrhh.TO.RhFunXiiiSueldoCalcularTO> getRhFunCalcularXiiiSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhFunCalcularXiiiSueldo(empresa, sector, desde, hasta);
    }

    public java.util.List<rrhh.TO.RhFunXiiiSueldoConsultarTO> getRhFunConsultarXiiiSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhFunConsultarXiiiSueldo(empresa, sector, desde, hasta);
    }

    public rrhh.TO.RhContableTO insertarRhXiiiSueldoConContable(
            java.lang.String empresa,
            java.lang.String periodoXiii,
            java.lang.String formaPago,
            java.lang.String documento,
            java.lang.String observaciones,
            java.util.List<rrhh.TO.RhFunXiiiSueldoCalcularTO> rhFunXiiiSueldoCalcularTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.insertarRhXiiiSueldoConContable(
                empresa,
                periodoXiii,
                formaPago,
                documento,
                observaciones,
                rhFunXiiiSueldoCalcularTOs,
                usuario,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="XIV">
    public java.util.List<rrhh.TO.RhXivSueldoPeriodoTO> getRhComboXivSueldoPeriodoTO() throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhComboXivSueldoPeriodoTO();
    }

    public java.util.List<rrhh.TO.RhUtilidadesPeriodoTO> getRhComboUtilidadesTO(java.lang.String empresa) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhComboUtilidadesPeriodoTO(empresa);
    }

    public java.util.List<rrhh.TO.RhFunXivSueldoCalcularTO> getRhFunCalcularXivSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhFunCalcularXivSueldo(empresa, sector, desde, hasta);
    }

    public java.util.List<rrhh.TO.RhFunUtilidadesCalcularTO> getRhFunCalcularUtilidades(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta, java.lang.Integer totalDias, java.lang.Integer totalCargas, java.math.BigDecimal totalPagar) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhFunCalcularUtilidades(empresa, sector, desde, hasta, totalDias, totalCargas, totalPagar);
    }

    public java.util.List<rrhh.TO.RhFunXivSueldoConsultarTO> getRhFunConsultarXivSueldo(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhFunConsultarXivSueldo(empresa, sector, desde, hasta);
    }

    public java.util.List<rrhh.TO.RhFunUtilidadesConsultarTO> getRhFunConsultarUtilidades(java.lang.String empresa, java.lang.String sector, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getRhFunConsultarUtilidades(empresa, sector, desde, hasta);
    }

    public rrhh.TO.RhContableTO insertarRhXivSueldoConContable(
            java.lang.String empresa,
            java.lang.String periodoXiv,
            java.lang.String formaPago,
            java.lang.String documento,
            java.lang.String observaciones,
            java.util.List<rrhh.TO.RhFunXivSueldoCalcularTO> rhFunXivSueldoCalcularTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.insertarRhXivSueldoConContable(
                empresa,
                periodoXiv,
                formaPago,
                documento,
                observaciones,
                rhFunXivSueldoCalcularTOs,
                usuario,
                sisInfoTO);
    }

    public rrhh.TO.RhContableTO insertarRhUtilidadesConContable(
            java.lang.String empresa,
            java.lang.String periodoXiv,
            java.lang.String formaPago,
            java.lang.String documento,
            java.lang.String observaciones,
            java.util.List<rrhh.TO.RhFunUtilidadesTO> rhFunUtilidadesCalcularTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.insertarRhUtilidadesConContable(
                empresa,
                periodoXiv,
                formaPago,
                documento,
                observaciones,
                rhFunUtilidadesCalcularTOs,
                usuario,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMULARIO 107">
    /**
     * @autor Jack Krauser
     *
     * @param empresa La empresa
     * @param desde Una fecha
     * <code>desde</code> con formato
     * <code>yyyy-MM-dd</code>
     * @param hasta Una fecha
     * <code>hasta</code> con formato
     * <code>yyyy-MM-dd</code>
     * @param empleadoID La cedula o pasaporte del empleado a consultar
     * @return Datos del empleado para ser llenado en el formulario en el lado
     * del cliente
     * @throws Exception Cualquier error inesperado
     */
    public rrhh.TO.RhFormulario107TO getRhFormulario107ConsultaTO(String empresa, String desde, String hasta, String empleadoID) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFormulario107ConsultaTO(empresa, desde, hasta, empleadoID);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa La empresa
     * @param anio El año del ejercicio fiscal
     * @param empleadoID La cedula o pasaporte del empleado a consultar
     * @return Datos del empleado para ser llenado en el formulario en el lado
     * del cliente para poder ser impreso
     * @throws Exception Cualquier error inesperado
     */
    public rrhh.TO.RhFormulario107TO getRhFormulario107TO(String empresa, String anio, String empleadoID) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFormulario107TO(empresa, anio, empleadoID);
    }

    /**
     * @autor Jack Krauser
     *
     * @param rrhh.TO.RhFormulario107TO El objeto que viene formado desde el
     * Cliente
     * @return Mensaje que expresa el exito de la transaccion
     * @throws Exception Cualquier error inesperado
     */
    public String insertarRhFormulario107TO(
            rrhh.TO.RhFormulario107TO rhFormulario107TO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.insertarRhFormulario107TO(
                rhFormulario107TO,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PERIODO FISCAL FORMULARIO 107">
    /**
     * @autor Jack Krauser
     *
     * @return Periodo Fiscal en forma de Lista para un combo
     * @throws Exception Cualquier error inesperado
     */
    public java.util.List<rrhh.TO.RhFormulario107PeriodoFiscalTO> getRhFormulario107PeriodoFiscalComboTO() throws Exception {
        return operacionesRRHHBusinessLocal.getRhFormulario107PeriodoFiscalComboTO();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="RECALCULO IR">
    /**
     *
     * @param valor El valor sobre el cual se va a recalcular el IR (impuesto a
     * la renta)
     * @param desde La fecha desde del periodo fiscal
     * @param hasta La fecha desde del periodo fiscal
     * @return un BigDecimal con el valor recalculado del IR
     * @throws Exception Cualquier error inesperado
     */
    public java.math.BigDecimal getValorRecalculadoIR(java.math.BigDecimal valor, java.lang.String desde, java.lang.String hasta) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getValorRecalculadoIR(valor, desde, hasta);
    }
    // </editor-fold>

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Xiiis Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoXiiis(String empresa, String fecha, String cuenta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFunPreavisoXiiis(empresa, fecha, cuenta);
    }

    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoXivs(String empresa, String fecha, String cuenta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFunPreavisoXivs(empresa, fecha, cuenta);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Anticipos Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoAnticipos(
            String empresa,
            String fecha,
            String cuenta,
            String tipoPreAviso,
            String servicio) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFunPreavisoAnticipos(
                empresa,
                fecha,
                cuenta,
                tipoPreAviso,
                servicio);
    }

    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoPichinchaTO> getRhFunPreavisoAnticiposPichincha(String empresa, String fecha, String cuenta, String tipo) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFunPreavisoAnticiposPichincha(empresa, fecha, cuenta, tipo);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Prestamos Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoPrestamos(String empresa, String fecha, String cuenta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFunPreavisoPrestamos(empresa, fecha, cuenta);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Sueldos Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoSueldos(String empresa, String fecha, String cuenta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFunPreavisoSueldos(empresa, fecha, cuenta);
    }

    @Override
    public java.util.List<rrhh.TO.RhFunFormulario107TO> getRhFunFormulario107(String empresa, String desde, String hasta, Character status) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFunFormulario107(empresa, desde, hasta, status);
    }

    @Override
    public java.util.List<rrhh.TO.RhFunFormulario107_2013TO> getRhFunFormulario107_2013(String empresa, String desde, String hasta, Character status) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFunFormulario107_2013(empresa, desde, hasta, status);
    }

    @Override
    public boolean getSwInactivaEmpleado(java.lang.String empresa, java.lang.String empleado) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.getSwInactivaEmpleado(empresa, empleado);
    }

    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoVacaciones(String empresa, String fecha, String cuenta) throws Exception {
        return operacionesRRHHBusinessLocal.getRhFunPreavisoVacaciones(empresa, fecha, cuenta);
    }

    public helper.RetornoTO getConsolidadoIngresosTabulado(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.getConsolidadoIngresosTabulado(
                empresa,
                codigoSector,
                fechaInicio,
                fechaFin,
                usuario,
                sisInfoTO);
    }

    public List<RhEmpleadoDescuentosFijosTO> getRhEmpleadoDescuentosFijosTO(String empresa, String empresaID) throws Exception {
        return operacionesRRHHBusinessLocal.getRhEmpleadoDescuentosFijosTO(empresa, empresaID);
    }

    public List<RhEmpleadoDescuentosFijos> getRhEmpleadoDescuentosFijos(String empresa, String empresaID) throws Exception {
        return operacionesRRHHBusinessLocal.getRhEmpleadoDescuentosFijos(empresa, empresaID);
    }

    public helper.RetornoTO getProvisionPorFechas(
            String empresa,
            String codigoSector,
            String fechaInicio,
            String fechaFin,
            String agrupacion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.getProvisionPorFechas(
                empresa,
                codigoSector,
                fechaInicio,
                fechaFin,
                agrupacion,
                sisInfoTO);
    }

    public String accionRhAnticipoMotivo(
            rrhh.TO.RhAnticipoMotivoTO rhAnticipoMotivoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesRRHHBusinessLocal.accionRhAnticipoMotivo(
                rhAnticipoMotivoTO,
                accion,
                sisInfoTO);
    }

    public List<RhAnticipoMotivoTO> getListaRhAnticipoMotivoTablaTO(String empresa) throws Exception {
        return operacionesRRHHBusinessLocal.getListaRhAnticipoMotivoTablaTO(empresa);
    }

    public List<RhAnticipoMotivoTO> getListaRhAnticipoMotivoTOTablaTO(String empresa, String codigo) throws Exception {
        return operacionesRRHHBusinessLocal.getListaRhAnticipoMotivoTOTablaTO(empresa, codigo);
    }

    public rrhh.TO.RhAnticipoMotivoTO getRhAnticipoMotivoTO(String empresa, String detalle) throws Exception {
        return operacionesRRHHBusinessLocal.getRhAnticipoMotivoTO(empresa, detalle);
    }

    public rrhh.entity.RhAnticipoMotivo getRhAnticipoMotivo(String empresa, String codigo) throws Exception {
        return operacionesRRHHBusinessLocal.getRhAnticipoMotivo(empresa, codigo);
    }

    /**
     * @autor charly
     *
     * @param empresa
     * @return ingreso de los XIII sueldo, XIV Sueldo
     * @throws Exception Cualquier error inesperado
     */
    public String accionRhXiiiSueldoPeriodo(
            rrhh.TO.RhXiiiSueldoPeriodoTO rhXiiiSueldoPeriodoTO,
            String codigoEmpresa,
            String codigoUsuario,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.accionRhXiiiSueldoPeriodo(
                rhXiiiSueldoPeriodoTO,
                codigoEmpresa,
                codigoUsuario,
                accion,
                sisInfoTO);
    }

    public String accionRhXivSueldoPeriodo(
            rrhh.TO.RhXivSueldoPeriodoTO rhXivSueldoPeriodoTO,
            String codigoEmpresa,
            String codigoUsuario,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.accionRhXivSueldoPeriodo(
                rhXivSueldoPeriodoTO,
                codigoEmpresa,
                codigoUsuario,
                accion,
                sisInfoTO);
    }

    public String accionRhUtilidadesPeriodo(
            rrhh.TO.RhUtilidadesPeriodoTO rhUtilidadesPeriodoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesRRHHBusinessLocal.accionRhUtilidadesPeriodo(
                rhUtilidadesPeriodoTO,
                accion,
                sisInfoTO);

    }

//    public JasperPrint generarReporteListadoChequeEmisionVencimientoCobrarNumero(
//    SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String cuenta, String desde, String hasta, String tipo,
//            List<BanListaChequeTO> listBanListaChequeTO) throws Exception {
//        return operacionesBancoBusinessLocal.generarReporteListadoChequeEmisionVencimientoCobrarNumero(sisUsuarioEmpresaTO, cuenta, desde, hasta, tipo, listBanListaChequeTO);
//    }
    public JasperPrint generarReporteConsolidadoAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde,
            String fechaHasta,
            List<RhListaConsolidadoAnticiposPrestamosTO> listaConsolidadoAnticiposPrestamosTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteConsolidadoAnticiposPrestamos(
                sisUsuarioEmpresaTO, 
                fechaDesde, 
                fechaHasta, 
                listaConsolidadoAnticiposPrestamosTO);
    }

    public JasperPrint generarReporteListaDetalleVacaionesPagadas(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String desde, String hasta,
            String empSector, List<RhDetalleVacionesPagadasGozadasTO> listaDetalleVacacionesPagadasGozadasTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteListaDetalleVacaionesPagadas(
                sisUsuarioEmpresaTO, desde, hasta, empSector, listaDetalleVacacionesPagadasGozadasTO);
    }

    public JasperPrint generarReporteDetalleAnticipos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empId,
            String empCodigo, String empCategoria, String fechaDesde,
            String fechaHasta,
            List<RhListaDetalleAnticiposTO> listaDetalleAnticiposTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteDetalleAnticipos(
                sisUsuarioEmpresaTO, empId, empCodigo, empCategoria, fechaDesde,
                fechaHasta, listaDetalleAnticiposTO);
    }

    public JasperPrint generarReporteDetalleAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empCodigo,
            String fechaDesde, String fechaHasta, String empCategoria,
            String empId,
            List<RhListaDetalleAnticiposPrestamosTO> listaDetalleAnticiposPrestamosTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteDetalleAnticiposPrestamos(
                sisUsuarioEmpresaTO, empCodigo, fechaDesde, fechaHasta, empCategoria,
                empId, listaDetalleAnticiposPrestamosTO);
    }

    public JasperPrint generarReporteDetallePrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String empCodigo, String fechaDesde,
            String fechaHasta, String empCategoria, String empId,
            List<RhListaDetallePrestamosTO> listaDetallePrestamosTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteDetallePrestamos(
                sisUsuarioEmpresaTO, empCodigo, fechaDesde, fechaHasta, empCategoria, empId,
                listaDetallePrestamosTO);
    }

    public JasperPrint generarReporteDetalleBonos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String empCategoria, String nombreEmpleado,
            List<RhListaDetalleBonosTO> listaDetalleBonosTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteDetalleBonos(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                empCategoria, nombreEmpleado, listaDetalleBonosTO);
    }

    public JasperPrint generarReporteDetalleBonosLote(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String periodo, String tipo, String numero,
            List<RhListaDetalleBonosLoteTO> listaDetalleBonosLoteTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteDetalleBonosLote(
                sisUsuarioEmpresaTO, periodo, tipo,
                numero, listaDetalleBonosLoteTO);
    }

    public JasperPrint generarReporteDetalleViaticos(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaDetalleViaticosTO> listaDetalleViaticosTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteDetalleViaticos(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                empCategoria, nombreEmpleado, listaDetalleViaticosTO);
    }

    public JasperPrint generarReporteConsolidadoBonosViatico(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta,
            List<RhListaConsolidadoBonosViaticosTO> listaConsolidadoBonosViaticosTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteConsolidadoBonosViatico(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                listaConsolidadoBonosViaticosTO);
    }

    public JasperPrint generarReporteListadoRolesPago(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaDesde, String fechaHasta, String empCategoria, String nombreEmpleado,
            List<RhListaDetalleRolesTO> listaDetalleRolesTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteListadoRolesPago(sisUsuarioEmpresaTO,
                fechaDesde, fechaHasta, empCategoria, nombreEmpleado, listaDetalleRolesTO);
    }

    public JasperPrint generarReporteConsolidadoRoles(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String empCategoria, String nombreEmpleado,
            List<RhListaConsolidadoRolesTO> listaConsolidadoRolesTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteConsolidadoRoles(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                empCategoria, nombreEmpleado, listaConsolidadoRolesTO);
    }

    public JasperPrint generarReporteSaldoIndividualAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaDesde, String fechaHasta,
            String empId,
            List<RhListaSaldoIndividualAnticiposPrestamosTO> listaSaldoIndividualAnticiposPrestamosTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteSaldoIndividualAnticiposPrestamos(
                sisUsuarioEmpresaTO, fechaDesde, fechaHasta,
                empId, listaSaldoIndividualAnticiposPrestamosTO);
    }

    public JasperPrint generarReporteSaldoConsolidadoAnticiposPrestamos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoAnticiposPrestamosTO> listaSaldoConsolidadoAnticiposPrestamosTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteSaldoConsolidadoAnticiposPrestamos(
                sisUsuarioEmpresaTO, fechaHasta,
                listaSaldoConsolidadoAnticiposPrestamosTO);
    }

    public JasperPrint generarReporteSaldoConsolidadoBonosViaticos(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoBonosViaticosTO> listaSaldoConsolidadoBonosViaticosTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteSaldoConsolidadoBonosViaticos(
                sisUsuarioEmpresaTO, fechaHasta, listaSaldoConsolidadoBonosViaticosTO);
    }

    public JasperPrint generarReporteSaldoConsolidadoSueldosPorPagar(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String fechaHasta,
            List<RhListaSaldoConsolidadoSueldosPorPagarTO> listaSaldoConsolidadoSueldosPorPagarTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteSaldoConsolidadoSueldosPorPagar(
                sisUsuarioEmpresaTO, fechaHasta,
                listaSaldoConsolidadoSueldosPorPagarTO);
    }

    public JasperPrint generarReporteXiiiSueldoConsulta(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String sector, String periodo,
            String fechaDesde, String fechaHasta, String fechaMaxima,
            List<RhFunXiiiSueldoConsultarTO> rhFunXiiiSueldoConsultarTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteXiiiSueldoConsulta(
                sisUsuarioEmpresaTO, sector, periodo, fechaDesde,
                fechaHasta, fechaMaxima, rhFunXiiiSueldoConsultarTO);
    }

    public JasperPrint generarReporteXivSueldoConsulta(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta,
            String fechaMaxima,
            List<RhFunXivSueldoConsultarTO> rhFunXivSueldoConsultarTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteXivSueldoConsulta(
                sisUsuarioEmpresaTO, sector, periodo, fechaDesde,
                fechaHasta, fechaMaxima, rhFunXivSueldoConsultarTO);
    }

    public JasperPrint generarReporteUtilidadesPreCalculo(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String sector, String periodo, String fechaDesde, String fechaHasta,
            String fechaMaxima,
            List<RhFunUtilidadesCalcularTO> rhFunUtilidadesCalcularTOs) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteUtilidadesPreCalculo(
                sisUsuarioEmpresaTO, sector, periodo, fechaDesde,
                fechaHasta, fechaMaxima, rhFunUtilidadesCalcularTOs);
    }

    public JasperPrint generarReporteProvisionesComprobanteContable(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String periodo, String tipo,
            String numero, List<RhListaProvisionesTO> listaProvisionesTO) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteProvisionesComprobanteContable(
                sisUsuarioEmpresaTO, periodo, tipo, numero, listaProvisionesTO);
    }

    public JasperPrint generarReporteFormulario107(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            String fechaEntrega, String rucEmpleador, String razonSocial, String rucContador,
            RhFormulario107TO rhFormulario107TOGuardar) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteFormulario107(sisUsuarioEmpresaTO,
                fechaEntrega, rucEmpleador, razonSocial, rucContador, rhFormulario107TOGuardar);
    }

    public JasperPrint generarReporteAnticipo(
            SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteAnticipoOprestamo> rhReporteAnticipoOprestamos) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteAnticipo(
                sisUsuarioEmpresaTO, rhReporteAnticipoOprestamos);
    }

    public JasperPrint generarReporteConsultaAnticiposLote(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteConsultaAnticiposLote> lista) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteConsultaAnticiposLote(
                sisUsuarioEmpresaTO, lista);
    }

    public JasperPrint generarReportePrestamoVista(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteAnticipoOprestamo> lista) throws Exception {
        return operacionesRRHHBusinessLocal.generarReportePrestamoVista(sisUsuarioEmpresaTO, lista);
    }

    public JasperPrint generarReporteRol(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReportesRol> lista) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteRol(sisUsuarioEmpresaTO, lista);
    }

    public JasperPrint generarReporteEmpleado(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<ReporteEmpleado> listReporteEmpleado) throws Exception {
        return operacionesRRHHBusinessLocal.generarReporteEmpleado(sisUsuarioEmpresaTO,
                listReporteEmpleado);
    }

    public JasperPrint generarReporteRol2(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            List<AuxiliarReporteDetalleRoles> lista) {
        return operacionesRRHHBusinessLocal.generarReporteRol2(sisUsuarioEmpresaTO, lista);
    }
}
