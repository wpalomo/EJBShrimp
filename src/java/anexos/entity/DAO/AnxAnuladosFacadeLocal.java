/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxAnulados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxAnuladosFacadeLocal {

    void create(AnxAnulados anxAnulados);

    void edit(AnxAnulados anxAnulados);

    void remove(AnxAnulados anxAnulados);

    AnxAnulados find(Object id);

    List<AnxAnulados> findAll();

    List<AnxAnulados> findRange(int[] range);

    int count();
    
}
