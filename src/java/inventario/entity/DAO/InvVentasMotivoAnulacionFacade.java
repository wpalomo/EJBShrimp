/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvVentasMotivoAnulacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer1
 */
@Stateless
public class InvVentasMotivoAnulacionFacade extends AbstractFacade<InvVentasMotivoAnulacion> implements InvVentasMotivoAnulacionFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvVentasMotivoAnulacionFacade() {
        super(InvVentasMotivoAnulacion.class);
    }
    
}
