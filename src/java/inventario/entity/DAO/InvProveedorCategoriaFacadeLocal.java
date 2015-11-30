/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProveedorCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProveedorCategoriaFacadeLocal {

    void create(InvProveedorCategoria invProveedorCategoria);

    void edit(InvProveedorCategoria invProveedorCategoria);

    void remove(InvProveedorCategoria invProveedorCategoria);

    InvProveedorCategoria find(Object id);

    List<InvProveedorCategoria> findAll();

    List<InvProveedorCategoria> findRange(int[] range);

    int count();
    
}
