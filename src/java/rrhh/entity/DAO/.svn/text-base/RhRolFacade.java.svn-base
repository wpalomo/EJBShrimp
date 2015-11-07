/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhRol;

/**
 *
 * @author fconza
 */
@Stateless
public class RhRolFacade extends AbstractFacade<RhRol> implements RhRolFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhRolFacade() {
        super(RhRol.class);
    }
    
}
