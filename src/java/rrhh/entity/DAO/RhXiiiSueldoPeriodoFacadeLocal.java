/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhXiiiSueldoPeriodo;

/**
 *
 * @author fconza
 */
@Local
public interface RhXiiiSueldoPeriodoFacadeLocal {

    void create(RhXiiiSueldoPeriodo rhXiiiSueldoPeriodo);

    void edit(RhXiiiSueldoPeriodo rhXiiiSueldoPeriodo);

    void remove(RhXiiiSueldoPeriodo rhXiiiSueldoPeriodo);

    RhXiiiSueldoPeriodo find(Object id);

    List<RhXiiiSueldoPeriodo> findAll();

    List<RhXiiiSueldoPeriodo> findRange(int[] range);

    int count();
    
}
