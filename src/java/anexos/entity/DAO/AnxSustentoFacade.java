/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxSustento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fconza
 */
@Stateless
public class AnxSustentoFacade extends AbstractFacade<AnxSustento> implements AnxSustentoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnxSustentoFacade() {
        super(AnxSustento.class);
    }
    
}
