/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxNumeracion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fconza
 */
@Stateless
public class AnxNumeracionFacade extends AbstractFacade<AnxNumeracion> implements AnxNumeracionFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnxNumeracionFacade() {
        super(AnxNumeracion.class);
    }
    
}
