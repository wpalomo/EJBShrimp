/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxProvincias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxProvinciasFacadeLocal {

    void create(AnxProvincias anxProvincias);

    void edit(AnxProvincias anxProvincias);

    void remove(AnxProvincias anxProvincias);

    AnxProvincias find(Object id);

    List<AnxProvincias> findAll();

    List<AnxProvincias> findRange(int[] range);

    int count();
    
}
