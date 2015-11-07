/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhXivSueldoPeriodo;

/**
 *
 * @author fconza
 */
@Stateless
public class RhXivSueldoPeriodoFacade extends AbstractFacade<RhXivSueldoPeriodo> implements RhXivSueldoPeriodoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhXivSueldoPeriodoFacade() {
        super(RhXivSueldoPeriodo.class);
    }
    
}
