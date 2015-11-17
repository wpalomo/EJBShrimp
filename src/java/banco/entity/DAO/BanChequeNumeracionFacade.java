/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity.DAO;

import banco.entity.BanBanco;
import banco.entity.BanChequeNumeracion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer2
 */
@Stateless
public class BanChequeNumeracionFacade extends AbstractFacade<BanChequeNumeracion> implements BanChequeNumeracionFacadeLocal {

    @PersistenceContext(unitName = "EJBShrimpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BanChequeNumeracionFacade() {
        super(BanChequeNumeracion.class);
    }
}
