/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistemaWeb.entity.SisUsuarioDetalle;

/**
 *
 * @author developer1
 */
@Stateless
public class SisUsuarioDetalleFacade extends AbstractFacade<SisUsuarioDetalle> implements SisUsuarioDetalleFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisUsuarioDetalleFacade() {
        super(SisUsuarioDetalle.class);
    }
    
}
