/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConEstructura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface ConEstructuraFacadeLocal {

    void create(ConEstructura conEstructura);

    void edit(ConEstructura conEstructura);

    void remove(ConEstructura conEstructura);

    ConEstructura find(Object id);

    List<ConEstructura> findAll();

    List<ConEstructura> findRange(int[] range);

    int count();
    
}
