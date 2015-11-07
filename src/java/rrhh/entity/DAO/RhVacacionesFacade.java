/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhVacaciones;

/**
 *
 * @author fconza
 */
@Stateless
public class RhVacacionesFacade extends AbstractFacade<RhVacaciones> implements RhVacacionesFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhVacacionesFacade() {
        super(RhVacaciones.class);
    }
    
}
