/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.entity.DAO;

import caja.entity.CajCaja;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer1
 */
@Stateless
public class CajCajaFacade extends AbstractFacade<CajCaja> implements CajCajaFacadeLocal {
    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CajCajaFacade() {
        super(CajCaja.class);
    }
    
}
