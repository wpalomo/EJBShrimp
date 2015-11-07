/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarCobrosDetalleVentas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer2
 */
@Stateless
public class CarCobrosDetalleVentasFacade extends AbstractFacade<CarCobrosDetalleVentas> implements CarCobrosDetalleVentasFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarCobrosDetalleVentasFacade() {
        super(CarCobrosDetalleVentas.class);
    }
    
}
