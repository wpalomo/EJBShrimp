/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import produccion.entity.PrdLiquidacionDetalle;

/**
 *
 * @author developer1
 */
@Stateless
public class PrdLiquidacionDetalleFacade extends AbstractFacade<PrdLiquidacionDetalle> implements PrdLiquidacionDetalleFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrdLiquidacionDetalleFacade() {
        super(PrdLiquidacionDetalle.class);
    }
    
}
