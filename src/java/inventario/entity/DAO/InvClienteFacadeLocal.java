/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvCliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvClienteFacadeLocal {

    void create(InvCliente invCliente);

    void edit(InvCliente invCliente);

    void remove(InvCliente invCliente);

    InvCliente find(Object id);

    List<InvCliente> findAll();

    List<InvCliente> findRange(int[] range);

    int count();
    
}
