/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProductoCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProductoCategoriaFacadeLocal {

    void create(InvProductoCategoria invProductoCategoria);

    void edit(InvProductoCategoria invProductoCategoria);

    void remove(InvProductoCategoria invProductoCategoria);

    InvProductoCategoria find(Object id);

    List<InvProductoCategoria> findAll();

    List<InvProductoCategoria> findRange(int[] range);

    int count();
    
}
