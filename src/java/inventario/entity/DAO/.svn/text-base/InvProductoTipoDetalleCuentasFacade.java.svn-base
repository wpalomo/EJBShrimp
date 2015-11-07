/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProductoTipoDetalleCuentas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer1
 */
@Stateless
public class InvProductoTipoDetalleCuentasFacade extends AbstractFacade<InvProductoTipoDetalleCuentas> implements InvProductoTipoDetalleCuentasFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvProductoTipoDetalleCuentasFacade() {
        super(InvProductoTipoDetalleCuentas.class);
    }
    
}
