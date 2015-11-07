/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistemaWeb.entity.SisEmpresa;

/**
 *
 * @author developer1
 */
@Stateless
public class SisEmpresaFacade extends AbstractFacade<SisEmpresa> implements SisEmpresaFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisEmpresaFacade() {
        super(SisEmpresa.class);
    }
    
}
