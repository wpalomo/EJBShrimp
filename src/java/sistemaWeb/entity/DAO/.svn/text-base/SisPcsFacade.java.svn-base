/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistemaWeb.entity.SisPcs;

/**
 *
 * @author developer1
 */
@Stateless
public class SisPcsFacade extends AbstractFacade<SisPcs> implements SisPcsFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisPcsFacade() {
        super(SisPcs.class);
    }
    
}
