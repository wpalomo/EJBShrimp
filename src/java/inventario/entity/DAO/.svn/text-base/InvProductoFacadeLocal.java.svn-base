/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProductoFacadeLocal {

    void create(InvProducto invProducto);

    void edit(InvProducto invProducto);

    void remove(InvProducto invProducto);

    InvProducto find(Object id);

    List<InvProducto> findAll();

    List<InvProducto> findRange(int[] range);

    int count();
    
}
