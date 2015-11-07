/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhParametros;

/**
 *
 * @author fconza
 */
@Stateless
public class RhParametrosFacade extends AbstractFacade<RhParametros> implements RhParametrosFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhParametrosFacade() {
        super(RhParametros.class);
    }
    
}
