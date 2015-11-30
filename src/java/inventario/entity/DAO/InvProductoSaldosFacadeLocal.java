/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProductoSaldos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProductoSaldosFacadeLocal {

    void create(InvProductoSaldos invProductoSaldos);

    void edit(InvProductoSaldos invProductoSaldos);

    void remove(InvProductoSaldos invProductoSaldos);

    InvProductoSaldos find(Object id);

    List<InvProductoSaldos> findAll();

    List<InvProductoSaldos> findRange(int[] range);

    int count();
    
}
