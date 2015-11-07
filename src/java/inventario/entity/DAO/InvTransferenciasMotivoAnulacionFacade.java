/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvTransferenciasMotivoAnulacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer1
 */
@Stateless
public class InvTransferenciasMotivoAnulacionFacade extends AbstractFacade<InvTransferenciasMotivoAnulacion> implements InvTransferenciasMotivoAnulacionFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvTransferenciasMotivoAnulacionFacade() {
        super(InvTransferenciasMotivoAnulacion.class);
    }
    
}
