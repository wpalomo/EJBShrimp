/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhXivSueldo;

/**
 *
 * @author fconza
 */
@Local
public interface RhXivSueldoFacadeLocal {

    void create(RhXivSueldo rhXivSueldo);

    void edit(RhXivSueldo rhXivSueldo);

    void remove(RhXivSueldo rhXivSueldo);

    RhXivSueldo find(Object id);

    List<RhXivSueldo> findAll();

    List<RhXivSueldo> findRange(int[] range);

    int count();
    
}
