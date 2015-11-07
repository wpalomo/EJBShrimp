/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvVendedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer1
 */
@Stateless
public class InvVendedorFacade extends AbstractFacade<InvVendedor> implements InvVendedorFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvVendedorFacade() {
        super(InvVendedor.class);
    }
    
}
