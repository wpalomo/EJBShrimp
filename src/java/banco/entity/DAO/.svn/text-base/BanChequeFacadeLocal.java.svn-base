/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity.DAO;

import banco.entity.BanCheque;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface BanChequeFacadeLocal {

    void create(BanCheque banCheque);

    void edit(BanCheque banCheque);

    void remove(BanCheque banCheque);

    BanCheque find(Object id);

    List<BanCheque> findAll();

    List<BanCheque> findRange(int[] range);

    int count();
    
}
