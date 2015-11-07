/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhViatico;

/**
 *
 * @author fconza
 */
@Local
public interface RhViaticoFacadeLocal {

    void create(RhViatico rhViatico);

    void edit(RhViatico rhViatico);

    void remove(RhViatico rhViatico);

    RhViatico find(Object id);

    List<RhViatico> findAll();

    List<RhViatico> findRange(int[] range);

    int count();
    
}
