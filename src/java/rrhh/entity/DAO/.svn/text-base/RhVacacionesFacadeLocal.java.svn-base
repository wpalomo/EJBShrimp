/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhVacaciones;

/**
 *
 * @author fconza
 */
@Local
public interface RhVacacionesFacadeLocal {

    void create(RhVacaciones rhVacaciones);

    void edit(RhVacaciones rhVacaciones);

    void remove(RhVacaciones rhVacaciones);

    RhVacaciones find(Object id);

    List<RhVacaciones> findAll();

    List<RhVacaciones> findRange(int[] range);

    int count();
    
}
