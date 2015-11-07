/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxPorcentajeiva;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxPorcentajeivaFacadeLocal {

    void create(AnxPorcentajeiva anxPorcentajeiva);

    void edit(AnxPorcentajeiva anxPorcentajeiva);

    void remove(AnxPorcentajeiva anxPorcentajeiva);

    AnxPorcentajeiva find(Object id);

    List<AnxPorcentajeiva> findAll();

    List<AnxPorcentajeiva> findRange(int[] range);

    int count();
    
}
