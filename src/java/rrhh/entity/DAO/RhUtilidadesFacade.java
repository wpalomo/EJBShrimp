/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhUtilidades;

/**
 *
 * @author fconza
 */
@Stateless
public class RhUtilidadesFacade extends AbstractFacade<RhUtilidades> implements RhUtilidadesFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhUtilidadesFacade() {
        super(RhUtilidades.class);
    }
    
}
