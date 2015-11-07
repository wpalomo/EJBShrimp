/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhPrestamo;

/**
 *
 * @author fconza
 */
@Local
public interface RhPrestamoFacadeLocal {

    void create(RhPrestamo rhPrestamo);

    void edit(RhPrestamo rhPrestamo);

    void remove(RhPrestamo rhPrestamo);

    RhPrestamo find(Object id);

    List<RhPrestamo> findAll();

    List<RhPrestamo> findRange(int[] range);

    int count();
    
}
