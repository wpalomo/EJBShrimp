/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity.DAO;

import banco.entity.BanCaja;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface BanCajaFacadeLocal {

    void create(BanCaja banCaja);

    void edit(BanCaja banCaja);

    void remove(BanCaja banCaja);

    BanCaja find(Object id);

    List<BanCaja> findAll();

    List<BanCaja> findRange(int[] range);

    int count();
    
}
