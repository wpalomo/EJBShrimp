/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhCategoria;

/**
 *
 * @author fconza
 */
@Stateless
public class RhCategoriaFacade extends AbstractFacade<RhCategoria> implements RhCategoriaFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhCategoriaFacade() {
        super(RhCategoria.class);
    }
    
}
