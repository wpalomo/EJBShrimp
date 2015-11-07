/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.entity.RhAnticipoMotivo;

/**
 *
 * @author fconza
 */
@Stateless
public class RhAnticipoMotivoFacade extends AbstractFacade<RhAnticipoMotivo> implements RhAnticipoMotivoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhAnticipoMotivoFacade() {
        super(RhAnticipoMotivo.class);
    }
    
}
