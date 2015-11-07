/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity.DAO;

import banco.entity.BanCaja;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer2
 */
@Stateless
public class BanCajaFacade extends AbstractFacade<BanCaja> implements BanCajaFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BanCajaFacade() {
        super(BanCaja.class);
    }
    
}
