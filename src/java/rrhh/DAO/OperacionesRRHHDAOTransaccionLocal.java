/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.DAO;

import contabilidad.entity.ConContable;
import contabilidad.entity.ConDetalle;
import contabilidad.entity.ConNumeracion;
import java.util.List;
import javax.ejb.Local;
import rrhh.entity.*;
import sistemaWeb.entity.SisSuceso;

/**
 *
 * @author misael
 */
@Local
public interface OperacionesRRHHDAOTransaccionLocal {

    java.lang.Boolean accionRhCategoria(rrhh.entity.RhCategoria rhCategoria, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception;

    boolean insertarRhEmpleado(RhEmpleado rhEmpleado, SisSuceso sisSuceso, java.util.List<RhEmpleadoDescuentosFijos> ListRhEmpleadoDescuentosFijos) throws Exception;
    boolean modificarRhEmpleado(RhEmpleado rhEmpleado, SisSuceso sisSuceso,List<RhEmpleadoDescuentosFijos> listaModificar,List<RhEmpleadoDescuentosFijos> listaEliminar) throws Exception;
    boolean eliminarRhEmpleado(RhEmpleado rhEmpleado, SisSuceso sisSuceso, List<RhEmpleadoDescuentosFijos> lista) throws Exception;

    java.lang.Boolean accionRhAvisoEntrada(rrhh.entity.RhEmpleado rhEmpleado, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    
    java.lang.Boolean accionRhFormaPago(rrhh.entity.RhFormaPago rhFormaPago, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    
    java.lang.Boolean accionRhFormaPagoBeneficioSocial(rrhh.entity.RhFormaPagoBeneficiosSociales rhFormaPagoBeneficioSocial, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;

    boolean insertarRhAnticipo(
            List<RhAnticipo> rhAnticipo, 
            ConContable conContable, 
            List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean insertarRhPrestamo(
            RhPrestamo rhPrestamo, 
            ConContable conContable, 
            List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    
    boolean insertarRhVacaciones(
            RhVacaciones rhVacaciones, 
            ConContable conContable, 
            List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    
    boolean insertarRhSalarioDigno(
            RhSalarioDigno rhSalarioDigno, 
            ConContable conContable, 
            java.util.List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean insertarRhViatico(
            RhViatico rhViatico, 
            ConContable conContable, 
            List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean insertarRhBono(
            java.util.List<RhBono> rhBonos, 
            ConContable conContable, 
            List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean insertarRhBonoConcepto(RhBonoConcepto rhBonoConcepto, SisSuceso sisSuceso) throws Exception;
    boolean modificarRhBonoConcepto(RhBonoConcepto rhBonoConcepto, SisSuceso sisSuceso) throws Exception;
    boolean eliminarRhBonoConcepto(RhBonoConcepto rhBonoConcepto, SisSuceso sisSuceso) throws Exception;

    boolean insertarRhRol(
            java.util.List<RhRol> rhRoles, 
            RhEmpleado rhEmpleado, 
            ConContable conContable, 
            java.util.List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean insertarRhFormulario107(rrhh.entity.RhFormulario107 rhFormulario107, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception;
    
    java.lang.Boolean accionRhSalarioDigno (rrhh.entity.RhSalarioDigno rhSalarioDigno, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    
    java.lang.Boolean accionRhAnticipoMotivo(rrhh.entity.RhAnticipoMotivo rhAnticipoMotivo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionRhXiiiSueldoPeriodo(rrhh.entity.RhXiiiSueldoPeriodo xiiiSueldoPeriodo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionRhXivSueldoPeriodo(rrhh.entity.RhXivSueldoPeriodo xivSueldoPeriodo,sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionRhUtilidadesPeriodo(rrhh.entity.RhUtilidadesPeriodo rhUtilidadesPeriodo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    
}
