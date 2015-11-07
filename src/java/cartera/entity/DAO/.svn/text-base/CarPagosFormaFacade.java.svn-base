/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarPagosForma;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer2
 */
@Stateless
public class CarPagosFormaFacade extends AbstractFacade<CarPagosForma> implements CarPagosFormaFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarPagosFormaFacade() {
        super(CarPagosForma.class);
    }
    
}
