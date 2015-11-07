/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface ConDetalleFacadeLocal {

    void create(ConDetalle conDetalle);

    void edit(ConDetalle conDetalle);

    void remove(ConDetalle conDetalle);

    ConDetalle find(Object id);

    List<ConDetalle> findAll();

    List<ConDetalle> findRange(int[] range);

    int count();
    
}
