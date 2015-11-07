/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxVentaFacadeLocal {

    void create(AnxVenta anxVenta);

    void edit(AnxVenta anxVenta);

    void remove(AnxVenta anxVenta);

    AnxVenta find(Object id);

    List<AnxVenta> findAll();

    List<AnxVenta> findRange(int[] range);

    int count();
    
}
