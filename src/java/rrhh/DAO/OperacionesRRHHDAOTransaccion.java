/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.DAO;

import contabilidad.DAO.OperacionesContabilidadDAOTransaccionLocal;
import contabilidad.entity.ConContable;
import contabilidad.entity.ConDetalle;
import contabilidad.entity.ConNumeracion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import rrhh.entity.RhAnticipo;
import rrhh.entity.RhBono;
import rrhh.entity.RhBonoConcepto;
import rrhh.entity.RhEmpleado;
import rrhh.entity.RhEmpleadoDescuentosFijos;
import rrhh.entity.RhPrestamo;
import rrhh.entity.RhRol;
import rrhh.entity.RhSalarioDigno;
import rrhh.entity.RhVacaciones;
import rrhh.entity.RhViatico;
import rrhh.helper.ConversionesRRHH;
import sistema.DAO.OperacionesSistemaDAOLocal;
import sistema.TO.SisErrorTO;
import sistemaWeb.entity.SisSuceso;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesRRHHDAOTransaccion implements OperacionesRRHHDAOTransaccionLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @EJB
    OperacionesContabilidadDAOTransaccionLocal operacionesContabilidadDAOTransaccionLocal;

    @PersistenceContext (type = PersistenceContextType.TRANSACTION, unitName = "EJBShrimpPU")
    private EntityManager em;

    public SisErrorTO sisErrorTO = null;

    // <editor-fold defaultstate="collapsed" desc="CATEGORIA">
    /**
     * @autor misayo
     * Metodo para ingresar, modificar o eliminar Categoria
     * @param rhCategoria
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionRhCategoria(rrhh.entity.RhCategoria rhCategoria, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception{
        if (accion == 'I')
            em.persist(rhCategoria);
        if (accion == 'M')
            em.merge(rhCategoria);
        if (accion == 'E')
            em.remove(em.merge(rhCategoria));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="EMPLEADO">
    /**
     * @autor misayo
     * Metodo para ingresar Empleado
     * @param rhEmpleado
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarRhEmpleado(RhEmpleado rhEmpleado, SisSuceso sisSuceso, java.util.List<RhEmpleadoDescuentosFijos> ListRhEmpleadoDescuentosFijos) throws Exception{
        em.persist(rhEmpleado);
        em.persist(sisSuceso);
        for (RhEmpleadoDescuentosFijos rhEmpleadoDescuentosFijos : ListRhEmpleadoDescuentosFijos) {
            em.persist(rhEmpleadoDescuentosFijos);
        }
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean modificarRhEmpleado(RhEmpleado rhEmpleado, SisSuceso sisSuceso,List<RhEmpleadoDescuentosFijos> listaModificar,List<RhEmpleadoDescuentosFijos> listaEliminar) throws Exception {
        em.merge(rhEmpleado);
        if(listaModificar!=null && !listaModificar.isEmpty()){
            for (RhEmpleadoDescuentosFijos rhEmpleadoDescuentosFijos : listaModificar) {
                rhEmpleadoDescuentosFijos.setRhEmpleado(rhEmpleado);
                em.merge(rhEmpleadoDescuentosFijos);
            }
        }
        
        if(listaEliminar!=null && !listaEliminar.isEmpty()){
            for (RhEmpleadoDescuentosFijos rhEmpleadoDescuentosFijos : listaEliminar) {
                rhEmpleadoDescuentosFijos.setRhEmpleado(rhEmpleado);
                em.remove(em.merge(rhEmpleadoDescuentosFijos));
            }
        }
//            em.flush();
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean eliminarRhEmpleado(RhEmpleado rhEmpleado, SisSuceso sisSuceso, List<RhEmpleadoDescuentosFijos> lista) throws Exception {
        if(lista!=null && !lista.isEmpty()){
            for (RhEmpleadoDescuentosFijos rhEmpleadoDescuentosFijos : lista) {
                rhEmpleadoDescuentosFijos.setRhEmpleado(rhEmpleado);
                em.remove(em.merge(rhEmpleadoDescuentosFijos));
            }
        }
        em.remove(em.merge(rhEmpleado));
//            em.flush();
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    /**
     * @autor misayo
     * Metodo para ingresar, modificar o eliminar AvisoEntrada
     * @param rhEmpleado
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionRhAvisoEntrada(rrhh.entity.RhEmpleado rhEmpleado, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        em.merge(rhEmpleado);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMAPAGO">
    /**
     * @autor misayo
     * Metodo para ingresar, modificar o eliminar FormaPago
     * @param rhFormaPago
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionRhFormaPago(rrhh.entity.RhFormaPago rhFormaPago, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception{
        if (accion == 'I')
            em.persist(rhFormaPago);
        if (accion == 'M')
            em.merge(rhFormaPago);
        if (accion == 'E')
            em.remove(em.merge(rhFormaPago));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="FORMAPAGOBENEFICIOSOCIAL">
    /**
     * @autor misayo
     * Metodo para ingresar, modificar o eliminar FormaPagoBeneficioSocial
     * @param rhFormaPagoBeneficioSocial
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionRhFormaPagoBeneficioSocial(rrhh.entity.RhFormaPagoBeneficiosSociales rhFormaPagoBeneficioSocial, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception{
        if (accion == 'I')
            em.persist(rhFormaPagoBeneficioSocial);
        if (accion == 'M')
            em.merge(rhFormaPagoBeneficioSocial);
        if (accion == 'E')
            em.remove(em.merge(rhFormaPagoBeneficioSocial));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ANTICIPO">
    /**
     * @autor misayo
     * Metodo para ingresar Anticipo
     * @param rhAnticipos
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    public boolean insertarRhAnticipo(
            java.util.List<RhAnticipo> rhAnticipos, 
            ConContable conContable, 
            java.util.List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                conContable, 
                listaConDetalle, 
                sisSuceso, 
                conNumeracion, 
                rhAnticipos, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                false, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PRESTAMO">
    /**
     * @autor misayo
     * Metodo para ingresar Prestamo
     * @param rhPrestamo
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    public boolean insertarRhPrestamo(
            RhPrestamo rhPrestamo, 
            ConContable conContable, 
            java.util.List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                conContable, 
                listaConDetalle, 
                sisSuceso, 
                conNumeracion, 
                null, 
                rhPrestamo, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                false, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                sisInfoTO);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="VACACIONES">
    /**
     * @autor misayo
     * Metodo para ingresar Vacaciones
     * @param rhVacaciones
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    public boolean insertarRhVacaciones(
            RhVacaciones rhVacaciones, 
            ConContable conContable, 
            java.util.List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                conContable, listaConDetalle, sisSuceso, 
                conNumeracion, 
                null, 
                null, 
                rhVacaciones, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                false, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                sisInfoTO);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Salario Digno">
    /**
     * @autor charly
     * Metodo para ingresar Vacaciones 
     * @param rhSalariodigno
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    public boolean insertarRhSalarioDigno(
            RhSalarioDigno rhSalarioDigno, 
            ConContable conContable, 
            java.util.List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                conContable, 
                listaConDetalle, 
                sisSuceso, 
                conNumeracion, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null,
                rhSalarioDigno,
                false, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null,
                null, 
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VIATICO">
    /**
     * @autor misayo
     * Metodo para ingresar Viatico
     * @param rhViatico
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    public boolean insertarRhViatico(
            RhViatico rhViatico, 
            ConContable conContable, 
            java.util.List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                conContable, 
                listaConDetalle, 
                sisSuceso, 
                conNumeracion, 
                null, 
                null, 
                null, 
                rhViatico, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                false, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BONO">
    /**
     * @autor misayo
     * Metodo para ingresar Viatico
     * @param rhBonos
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    public boolean insertarRhBono(
            java.util.List<RhBono> rhBonos, 
            ConContable conContable,
            java.util.List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                conContable, 
                listaConDetalle, 
                sisSuceso, 
                conNumeracion, 
                null, 
                null, 
                null, 
                null, 
                rhBonos, 
                null, 
                null, 
                null, 
                null, 
                null,
                false, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BONO CONCEPTO">
    /**
     * @autor misayo
     * Metodo para ingresar BonoConcepto
     * @param rhBonoConcepto
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarRhBonoConcepto(RhBonoConcepto rhBonoConcepto, SisSuceso sisSuceso) throws Exception{
        em.persist(rhBonoConcepto);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean modificarRhBonoConcepto(RhBonoConcepto rhBonoConcepto, SisSuceso sisSuceso) throws Exception {
        em.merge(rhBonoConcepto);
        em.flush();
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean eliminarRhBonoConcepto(RhBonoConcepto rhBonoConcepto, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(rhBonoConcepto));
        em.flush();
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ROL">
    /**
     * @autor misayo
     * Metodo para ingresar Viatico
     * @param rhRol
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    public boolean insertarRhRol(
            java.util.List<RhRol> rhRoles, 
            RhEmpleado rhEmpleado, 
            ConContable conContable, 
            java.util.List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesContabilidadDAOTransaccionLocal.insertarTransaccionContable(
                conContable, listaConDetalle, sisSuceso, conNumeracion, null, null, 
                null, 
                null, 
                null, 
                rhRoles, 
                null, 
                null, 
                null, 
                null,
                false, 
                rhEmpleado, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                sisInfoTO);
    }
    // </editor-fold>
    
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarRhFormulario107(rrhh.entity.RhFormulario107 rhFormulario107, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(rhFormulario107);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // <editor-fold defaultstate="collapsed" desc="ANTICIPOMOTIVO">
    /**
     * @autor misayo
     * Metodo para ingresar, modificar o eliminar AnticipoMotivo
     * @param RhAnticipoMotivo
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionRhAnticipoMotivo(rrhh.entity.RhAnticipoMotivo rhAnticipoMotivo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        if (accion == 'I')
            em.persist(rhAnticipoMotivo);
        if (accion == 'M')
            em.merge(rhAnticipoMotivo);
        if (accion == 'E')
            em.remove(em.merge(rhAnticipoMotivo));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    
   
    
    // </editor-fold>
    
    
     // <editor-fold defaultstate="collapsed" desc="SALARIO DIGNO">
    /**
     * @autor CHARLY
     * Metodo para ingresar, modificar o eliminar AnticipoMotivo
     * @param RhSalariodigno
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionRhSalarioDigno (rrhh.entity.RhSalarioDigno rhSalarioDigno, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        if (accion == 'I')
            em.persist(rhSalarioDigno);
        if (accion == 'M')
            em.merge(rhSalarioDigno);
        if (accion == 'E')
            em.remove(em.merge(rhSalarioDigno));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    
    // </editor-fold>
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionRhXiiiSueldoPeriodo(rrhh.entity.RhXiiiSueldoPeriodo xiiiSueldoPeriodo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        if (accion == 'I')
            em.persist(xiiiSueldoPeriodo);
        if (accion == 'M'){
            em.merge(xiiiSueldoPeriodo);
        }
        if (accion == 'E')
            em.remove(em.merge(xiiiSueldoPeriodo));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionRhXivSueldoPeriodo(rrhh.entity.RhXivSueldoPeriodo xivSueldoPeriodo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        if (accion == 'I')
            em.persist(xivSueldoPeriodo);
        if (accion == 'M')
            em.merge(xivSueldoPeriodo);
        if (accion == 'E')
            em.remove(em.merge(xivSueldoPeriodo));
        //em.persist(sisSuceso);
        em.flush();
        return true;
    }
    
    
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionRhUtilidadesPeriodo(rrhh.entity.RhUtilidadesPeriodo rhUtilidadesPeriodo, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        if (accion == 'I')
            em.persist(rhUtilidadesPeriodo);
        if (accion == 'M')
            em.merge(rhUtilidadesPeriodo);
        if (accion == 'E')
            em.remove(em.merge(rhUtilidadesPeriodo));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
}