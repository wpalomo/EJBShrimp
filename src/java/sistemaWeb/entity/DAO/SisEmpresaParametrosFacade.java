/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistemaWeb.entity.SisEmpresaParametros;

/**
 *
 * @author developer1
 */
@Stateless
public class SisEmpresaParametrosFacade extends AbstractFacade<SisEmpresaParametros> implements SisEmpresaParametrosFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisEmpresaParametrosFacade() {
        super(SisEmpresaParametros.class);
    }
    
}
