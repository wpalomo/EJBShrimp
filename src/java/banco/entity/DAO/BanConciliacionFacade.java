/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity.DAO;

import banco.entity.BanConciliacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer2
 */
@Stateless
public class BanConciliacionFacade extends AbstractFacade<BanConciliacion> implements BanConciliacionFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BanConciliacionFacade() {
        super(BanConciliacion.class);
    }
    
}
