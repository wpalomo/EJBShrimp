/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarPagosDetalleAnticipos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer2
 */
@Stateless
public class CarPagosDetalleAnticiposFacade extends AbstractFacade<CarPagosDetalleAnticipos> implements CarPagosDetalleAnticiposFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarPagosDetalleAnticiposFacade() {
        super(CarPagosDetalleAnticipos.class);
    }
    
}
