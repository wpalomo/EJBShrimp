/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConCuentas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface ConCuentasFacadeLocal {

    void create(ConCuentas conCuentas);

    void edit(ConCuentas conCuentas);

    void remove(ConCuentas conCuentas);

    ConCuentas find(Object id);

    List<ConCuentas> findAll();

    List<ConCuentas> findRange(int[] range);

    int count();
    
}
