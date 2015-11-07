/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import produccion.entity.PrdGrameaje;

/**
 *
 * @author developer1
 */
@Stateless
public class PrdGrameajeFacade extends AbstractFacade<PrdGrameaje> implements PrdGrameajeFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrdGrameajeFacade() {
        super(PrdGrameaje.class);
    }
    
}
