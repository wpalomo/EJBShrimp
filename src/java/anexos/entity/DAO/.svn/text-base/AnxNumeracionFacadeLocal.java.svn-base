/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxNumeracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxNumeracionFacadeLocal {

    void create(AnxNumeracion anxNumeracion);

    void edit(AnxNumeracion anxNumeracion);

    void remove(AnxNumeracion anxNumeracion);

    AnxNumeracion find(Object id);

    List<AnxNumeracion> findAll();

    List<AnxNumeracion> findRange(int[] range);

    int count();
    
}
