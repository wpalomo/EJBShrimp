/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProductoMarca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProductoMarcaFacadeLocal {

    void create(InvProductoMarca invProductoMarca);

    void edit(InvProductoMarca invProductoMarca);

    void remove(InvProductoMarca invProductoMarca);

    InvProductoMarca find(Object id);

    List<InvProductoMarca> findAll();

    List<InvProductoMarca> findRange(int[] range);

    int count();
    
}
