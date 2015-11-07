/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConNumeracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface ConNumeracionFacadeLocal {

    void create(ConNumeracion conNumeracion);

    void edit(ConNumeracion conNumeracion);

    void remove(ConNumeracion conNumeracion);

    ConNumeracion find(Object id);

    List<ConNumeracion> findAll();

    List<ConNumeracion> findRange(int[] range);

    int count();
    
}
