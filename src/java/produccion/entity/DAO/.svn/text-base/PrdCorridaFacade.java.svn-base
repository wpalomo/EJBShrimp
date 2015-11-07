/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import produccion.entity.PrdCorrida;

/**
 *
 * @author developer1
 */
@Stateless
public class PrdCorridaFacade extends AbstractFacade<PrdCorrida> implements PrdCorridaFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrdCorridaFacade() {
        super(PrdCorrida.class);
    }
    
}
