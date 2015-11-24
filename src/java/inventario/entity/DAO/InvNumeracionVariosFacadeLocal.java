/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvNumeracionVarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvNumeracionVariosFacadeLocal {

    void create(InvNumeracionVarios invNumeracionVarios);

    void edit(InvNumeracionVarios invNumeracionVarios);

    void remove(InvNumeracionVarios invNumeracionVarios);

    InvNumeracionVarios find(Object id);

    List<InvNumeracionVarios> findAll();

    List<InvNumeracionVarios> findRange(int[] range);

    int count();
    
}
