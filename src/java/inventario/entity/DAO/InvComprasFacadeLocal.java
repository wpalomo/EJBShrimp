/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvCompras;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvComprasFacadeLocal {

    void create(InvCompras invCompras);

    void edit(InvCompras invCompras);

    void remove(InvCompras invCompras);

    InvCompras find(Object id);

    List<InvCompras> findAll();

    List<InvCompras> findRange(int[] range);

    int count();
    
}
