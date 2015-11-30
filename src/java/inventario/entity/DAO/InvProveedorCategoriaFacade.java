/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProveedorCategoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer1
 */

//-

@Stateless
public class InvProveedorCategoriaFacade extends AbstractFacade<InvProveedorCategoria> implements InvProveedorCategoriaFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvProveedorCategoriaFacade() {
        super(InvProveedorCategoria.class);
    }
    
}
