/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhEmpleadoDescuentosFijos;

/**
 *
 * @author fconza
 */
@Local
public interface RhEmpleadoDescuentosFijosFacadeLocal {

    void create(RhEmpleadoDescuentosFijos rhEmpleadoDescuentosFijos);

    void edit(RhEmpleadoDescuentosFijos rhEmpleadoDescuentosFijos);

    void remove(RhEmpleadoDescuentosFijos rhEmpleadoDescuentosFijos);

    RhEmpleadoDescuentosFijos find(Object id);

    List<RhEmpleadoDescuentosFijos> findAll();

    List<RhEmpleadoDescuentosFijos> findRange(int[] range);

    int count();
    
}
