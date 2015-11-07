/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConCuentas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fconza
 */
@Stateless
public class ConCuentasFacade extends AbstractFacade<ConCuentas> implements ConCuentasFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConCuentasFacade() {
        super(ConCuentas.class);
    }
    
}
