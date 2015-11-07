/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity.DAO;

import banco.entity.BanBanco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface BanBancoFacadeLocal {

    void create(BanBanco banBanco);

    void edit(BanBanco banBanco);

    void remove(BanBanco banBanco);

    BanBanco find(Object id);

    List<BanBanco> findAll();

    List<BanBanco> findRange(int[] range);

    int count();
    
}
