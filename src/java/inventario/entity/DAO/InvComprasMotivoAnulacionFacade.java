/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvComprasMotivoAnulacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author developer1
 */
@Stateless
public class InvComprasMotivoAnulacionFacade extends AbstractFacade<InvComprasMotivoAnulacion> implements InvComprasMotivoAnulacionFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvComprasMotivoAnulacionFacade() {
        super(InvComprasMotivoAnulacion.class);
    }
    
}
