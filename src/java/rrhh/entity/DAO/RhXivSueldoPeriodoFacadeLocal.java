/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhXivSueldoPeriodo;

/**
 *
 * @author fconza
 */
@Local
public interface RhXivSueldoPeriodoFacadeLocal {

    void create(RhXivSueldoPeriodo rhXivSueldoPeriodo);

    void edit(RhXivSueldoPeriodo rhXivSueldoPeriodo);

    void remove(RhXivSueldoPeriodo rhXivSueldoPeriodo);

    RhXivSueldoPeriodo find(Object id);

    List<RhXivSueldoPeriodo> findAll();

    List<RhXivSueldoPeriodo> findRange(int[] range);

    int count();
    
}
