/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConCuentasFlujoDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fconza
 */
@Stateless
public class ConCuentasFlujoDetalleFacade extends AbstractFacade<ConCuentasFlujoDetalle> implements ConCuentasFlujoDetalleFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConCuentasFlujoDetalleFacade() {
        super(ConCuentasFlujoDetalle.class);
    }
    
}
