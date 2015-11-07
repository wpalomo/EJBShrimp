/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarPagosAnticipos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer2
 */
@Stateless
public class CarPagosAnticiposFacade extends AbstractFacade<CarPagosAnticipos> implements CarPagosAnticiposFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarPagosAnticiposFacade() {
        super(CarPagosAnticipos.class);
    }
    
}
