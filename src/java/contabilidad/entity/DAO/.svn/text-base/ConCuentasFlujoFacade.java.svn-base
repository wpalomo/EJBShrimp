/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConCuentasFlujo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fconza
 */
@Stateless
public class ConCuentasFlujoFacade extends AbstractFacade<ConCuentasFlujo> implements ConCuentasFlujoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConCuentasFlujoFacade() {
        super(ConCuentasFlujo.class);
    }
    
}
