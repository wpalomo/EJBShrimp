/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhXiiiSueldoPeriodo;

/**
 *
 * @author fconza
 */
@Stateless
public class RhXiiiSueldoPeriodoFacade extends AbstractFacade<RhXiiiSueldoPeriodo> implements RhXiiiSueldoPeriodoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhXiiiSueldoPeriodoFacade() {
        super(RhXiiiSueldoPeriodo.class);
    }
    
}
