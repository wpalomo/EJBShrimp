/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cartera.DAO;

import contabilidad.DAO.OperacionesContabilidadDAOTransaccionLocal;
import contabilidad.entity.ConContable;
import contabilidad.entity.ConDetalle;
import contabilidad.entity.ConNumeracion;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import sistema.DAO.OperacionesSistemaDAOLocal;
import sistema.TO.SisErrorTO;
import sistemaWeb.entity.SisSuceso;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesCarDAOTransaccion implements OperacionesCarDAOTransaccionLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @EJB
    OperacionesCarDAOTransaccionLocal operacionesCarDAOTransaccionLocal;
    @EJB
    OperacionesCarDAOLocal operacionesCarDAOLocal;
    @EJB
    OperacionesContabilidadDAOTransaccionLocal operacionesContabilidadDAOTransaccionLocal;

    @PersistenceContext (type = PersistenceContextType.TRANSACTION, unitName = "EJBShrimpPU")
    private EntityManager em;

    public SisErrorTO sisErrorTO = null;

    // <editor-fold defaultstate="collapsed" desc="PAGOS-COBROS">
    /**
     * @autor misayo
     * Metodo para ingresar Prestamo
     * @param rhPrestamo
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    public Boolean insertarTransaccionCarteraPagos(
            cartera.entity.CarPagos carPagos, 
            java.util.List<cartera.entity.CarPagosDetalleCompras> carPagosDetalleCompras, 
            java.util.List<cartera.entity.CarPagosDetalleForma> carPagosDetalleFormas, 
            java.util.List<cartera.entity.CarPagosDetalleAnticipos> carPagosDetalleAnticiposes, 
            ConContable conContable,
            java.util.List <ConDetalle> listaConDetalle, 
            SisSuceso sisSuceso, 
            ConNumeracion conNumeracion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
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
                null, 
                false, 
                null, 
                carPagos, 
                carPagosDetalleAnticiposes, 
                carPagosDetalleCompras, 
                carPagosDetalleFormas, 
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
    /**
     * @autor misayo
     * Metodo para ingresar Prestamo
     * @param rhPrestamo
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    public Boolean insertarTransaccionCarteraCobros(
            cartera.entity.CarCobros carCobros, 
            java.util.List<cartera.entity.CarCobrosDetalleVentas> carCobrosDetalleVentas, 
            java.util.List<cartera.entity.CarCobrosDetalleForma> carCobrosDetalleFormas,
            java.util.List<cartera.entity.CarCobrosDetalleAnticipos> carCobrosDetalleAnticiposes, 
            contabilidad.entity.ConContable conContable, 
            java.util.List<contabilidad.entity.ConDetalle> listaConDetalle, 
            sistemaWeb.entity.SisSuceso sisSuceso, 
            contabilidad.entity.ConNumeracion conNumeracion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
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
                null, 
                false, 
                null, 
                null, 
                null, 
                null, 
                null, 
                null, 
                carCobros, 
                carCobrosDetalleAnticiposes, 
                carCobrosDetalleVentas, 
                carCobrosDetalleFormas, 
                null, 
                null, 
                null, 
                null,
                sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PAGOSFORMA">
    /**
     * @autor misayo
     * Metodo para ingresar, modificar o eliminar FormaPago
     * @param carPagosForma
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionCarFormaPago(cartera.entity.CarPagosForma carPagosForma, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception{
        if (accion == 'I')
            em.persist(carPagosForma);
        if (accion == 'M')
            em.merge(carPagosForma);
        if (accion == 'E')
            em.remove(em.merge(carPagosForma));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    /**
     * @autor misayo
     * Metodo para ingresar, modificar o eliminar FormaPago
     * @param carCobrosForma
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionCarFormaCobro(cartera.entity.CarCobrosForma carCobrosForma, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception{
        if (accion == 'I')
            em.persist(carCobrosForma);
        if (accion == 'M')
            em.merge(carCobrosForma);
        if (accion == 'E')
            em.remove(em.merge(carCobrosForma));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>
}