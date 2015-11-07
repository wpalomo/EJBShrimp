/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhEmpleado;

/**
 *
 * @author fconza
 */
@Local
public interface RhEmpleadoFacadeLocal {

    void create(RhEmpleado rhEmpleado);

    void edit(RhEmpleado rhEmpleado);

    void remove(RhEmpleado rhEmpleado);

    RhEmpleado find(Object id);

    List<RhEmpleado> findAll();

    List<RhEmpleado> findRange(int[] range);

    int count();
    
}
