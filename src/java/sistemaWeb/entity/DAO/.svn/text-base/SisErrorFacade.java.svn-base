/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistemaWeb.entity.SisError;

/**
 *
 * @author developer1
 */
@Stateless
public class SisErrorFacade extends AbstractFacade<SisError> implements SisErrorFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisErrorFacade() {
        super(SisError.class);
    }
    
}
