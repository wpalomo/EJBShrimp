/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhBono;

/**
 *
 * @author fconza
 */
@Local
public interface RhBonoFacadeLocal {

    void create(RhBono rhBono);

    void edit(RhBono rhBono);

    void remove(RhBono rhBono);

    RhBono find(Object id);

    List<RhBono> findAll();

    List<RhBono> findRange(int[] range);

    int count();
    
}
