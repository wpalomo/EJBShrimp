/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxCompraFormaPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxCompraFormaPagoFacadeLocal {

    void create(AnxCompraFormaPago anxCompraFormaPago);

    void edit(AnxCompraFormaPago anxCompraFormaPago);

    void remove(AnxCompraFormaPago anxCompraFormaPago);

    AnxCompraFormaPago find(Object id);

    List<AnxCompraFormaPago> findAll();

    List<AnxCompraFormaPago> findRange(int[] range);

    int count();
    
}
