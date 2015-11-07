/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhUtilidadesPeriodo;

/**
 *
 * @author fconza
 */
@Local
public interface RhUtilidadesPeriodoFacadeLocal {

    void create(RhUtilidadesPeriodo rhUtilidadesPeriodo);

    void edit(RhUtilidadesPeriodo rhUtilidadesPeriodo);

    void remove(RhUtilidadesPeriodo rhUtilidadesPeriodo);

    RhUtilidadesPeriodo find(Object id);

    List<RhUtilidadesPeriodo> findAll();

    List<RhUtilidadesPeriodo> findRange(int[] range);

    int count();
    
}
