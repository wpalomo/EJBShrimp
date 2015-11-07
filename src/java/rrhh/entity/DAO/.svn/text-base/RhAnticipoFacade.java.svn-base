/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhAnticipo;

/**
 *
 * @author fconza
 */
@Stateless
public class RhAnticipoFacade extends AbstractFacade<RhAnticipo> implements RhAnticipoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhAnticipoFacade() {
        super(RhAnticipo.class);
    }
    
}
