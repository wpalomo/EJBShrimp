/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistemaWeb.entity.SisPermiso;

/**
 *
 * @author developer1
 */
@Stateless
public class SisPermisoFacade extends AbstractFacade<SisPermiso> implements SisPermisoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisPermisoFacade() {
        super(SisPermiso.class);
    }
    
}
