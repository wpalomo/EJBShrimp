/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProductoMedida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProductoMedidaFacadeLocal {

    void create(InvProductoMedida invProductoMedida);

    void edit(InvProductoMedida invProductoMedida);

    void remove(InvProductoMedida invProductoMedida);

    InvProductoMedida find(Object id);

    List<InvProductoMedida> findAll();

    List<InvProductoMedida> findRange(int[] range);

    int count();
    
}
