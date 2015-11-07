/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxCuentascontables;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fconza
 */
@Stateless
public class AnxCuentascontablesFacade extends AbstractFacade<AnxCuentascontables> implements AnxCuentascontablesFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnxCuentascontablesFacade() {
        super(AnxCuentascontables.class);
    }
    
}
