/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConCuentasFlujo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface ConCuentasFlujoFacadeLocal {

    void create(ConCuentasFlujo conCuentasFlujo);

    void edit(ConCuentasFlujo conCuentasFlujo);

    void remove(ConCuentasFlujo conCuentasFlujo);

    ConCuentasFlujo find(Object id);

    List<ConCuentasFlujo> findAll();

    List<ConCuentasFlujo> findRange(int[] range);

    int count();
    
}
