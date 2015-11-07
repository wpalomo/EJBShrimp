/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import produccion.entity.PrdResumenCorrida;

/**
 *
 * @author developer1
 */
@Stateless
public class PrdResumenCorridaFacade extends AbstractFacade<PrdResumenCorrida> implements PrdResumenCorridaFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrdResumenCorridaFacade() {
        super(PrdResumenCorrida.class);
    }
    
}
