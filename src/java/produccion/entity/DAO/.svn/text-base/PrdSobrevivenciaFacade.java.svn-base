/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import produccion.entity.PrdSobrevivencia;

/**
 *
 * @author developer1
 */
@Stateless
public class PrdSobrevivenciaFacade extends AbstractFacade<PrdSobrevivencia> implements PrdSobrevivenciaFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrdSobrevivenciaFacade() {
        super(PrdSobrevivencia.class);
    }
    
}
