/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxCompraReembolso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fconza
 */
@Stateless
public class AnxCompraReembolsoFacade extends AbstractFacade<AnxCompraReembolso> implements AnxCompraReembolsoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnxCompraReembolsoFacade() {
        super(AnxCompraReembolso.class);
    }
    
}
