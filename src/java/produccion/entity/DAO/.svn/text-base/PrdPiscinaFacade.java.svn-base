/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import produccion.entity.PrdPiscina;

/**
 *
 * @author developer1
 */
@Stateless
public class PrdPiscinaFacade extends AbstractFacade<PrdPiscina> implements PrdPiscinaFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrdPiscinaFacade() {
        super(PrdPiscina.class);
    }
    
}
