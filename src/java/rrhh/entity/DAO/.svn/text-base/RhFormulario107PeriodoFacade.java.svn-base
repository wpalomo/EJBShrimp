/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhFormulario107Periodo;

/**
 *
 * @author fconza
 */
@Stateless
public class RhFormulario107PeriodoFacade extends AbstractFacade<RhFormulario107Periodo> implements RhFormulario107PeriodoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhFormulario107PeriodoFacade() {
        super(RhFormulario107Periodo.class);
    }
    
}
