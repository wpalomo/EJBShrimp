/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConContable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface ConContableFacadeLocal {

    void create(ConContable conContable);

    void edit(ConContable conContable);

    void remove(ConContable conContable);

    ConContable find(Object id);

    List<ConContable> findAll();

    List<ConContable> findRange(int[] range);

    int count();
    
}
