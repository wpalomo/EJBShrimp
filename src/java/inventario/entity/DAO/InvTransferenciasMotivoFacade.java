/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvTransferenciasMotivo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer1
 */
//--
@Stateless
public class InvTransferenciasMotivoFacade extends AbstractFacade<InvTransferenciasMotivo> implements InvTransferenciasMotivoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvTransferenciasMotivoFacade() {
        super(InvTransferenciasMotivo.class);
    }
    
}
