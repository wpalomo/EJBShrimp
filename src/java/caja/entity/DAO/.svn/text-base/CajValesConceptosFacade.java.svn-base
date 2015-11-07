/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.entity.DAO;

import caja.entity.CajValesConceptos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer1
 */
@Stateless
public class CajValesConceptosFacade extends AbstractFacade<CajValesConceptos> implements CajValesConceptosFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CajValesConceptosFacade() {
        super(CajValesConceptos.class);
    }
    
}
