/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import produccion.entity.PrdLiquidacion;

/**
 *
 * @author developer1
 */
@Stateless
public class PrdLiquidacionFacade extends AbstractFacade<PrdLiquidacion> implements PrdLiquidacionFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrdLiquidacionFacade() {
        super(PrdLiquidacion.class);
    }
    
}
