/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhBono;

/**
 *
 * @author fconza
 */
@Stateless
public class RhBonoFacade extends AbstractFacade<RhBono> implements RhBonoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhBonoFacade() {
        super(RhBono.class);
    }
    
}
