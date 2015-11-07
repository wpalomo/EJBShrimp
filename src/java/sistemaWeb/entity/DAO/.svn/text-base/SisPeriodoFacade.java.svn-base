/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistemaWeb.entity.SisPeriodo;

/**
 *
 * @author developer1
 */
@Stateless
public class SisPeriodoFacade extends AbstractFacade<SisPeriodo> implements SisPeriodoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisPeriodoFacade() {
        super(SisPeriodo.class);
    }
    
}
