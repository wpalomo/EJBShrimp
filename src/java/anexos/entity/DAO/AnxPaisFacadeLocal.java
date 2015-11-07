/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxPais;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxPaisFacadeLocal {

    void create(AnxPais anxPais);

    void edit(AnxPais anxPais);

    void remove(AnxPais anxPais);

    AnxPais find(Object id);

    List<AnxPais> findAll();

    List<AnxPais> findRange(int[] range);

    int count();
    
}
