/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvConsumosMotivoAnulacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer1
 */
@Stateless
public class InvConsumosMotivoAnulacionFacade extends AbstractFacade<InvConsumosMotivoAnulacion> implements InvConsumosMotivoAnulacionFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvConsumosMotivoAnulacionFacade() {
        super(InvConsumosMotivoAnulacion.class);
    }
    
}
