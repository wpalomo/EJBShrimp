/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhFormulario107;

/**
 *
 * @author fconza
 */
@Stateless
public class RhFormulario107Facade extends AbstractFacade<RhFormulario107> implements RhFormulario107FacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhFormulario107Facade() {
        super(RhFormulario107.class);
    }
    
}
