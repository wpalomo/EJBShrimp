/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistemaWeb.entity.SisGrupo;

/**
 *
 * @author developer1
 */
@Stateless
public class SisGrupoFacade extends AbstractFacade<SisGrupo> implements SisGrupoFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisGrupoFacade() {
        super(SisGrupo.class);
    }
    
}
