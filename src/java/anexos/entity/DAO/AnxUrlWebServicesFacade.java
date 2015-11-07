/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxUrlWebServices;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fconza
 */
@Stateless
public class AnxUrlWebServicesFacade extends AbstractFacade<AnxUrlWebServices> implements AnxUrlWebServicesFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnxUrlWebServicesFacade() {
        super(AnxUrlWebServices.class);
    }
    
}
