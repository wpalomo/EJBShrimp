/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhUtilidades;

/**
 *
 * @author fconza
 */
@Local
public interface RhUtilidadesFacadeLocal {

    void create(RhUtilidades rhUtilidades);

    void edit(RhUtilidades rhUtilidades);

    void remove(RhUtilidades rhUtilidades);

    RhUtilidades find(Object id);

    List<RhUtilidades> findAll();

    List<RhUtilidades> findRange(int[] range);

    int count();
    
}
