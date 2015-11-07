/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProductoTipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProductoTipoFacadeLocal {

    void create(InvProductoTipo invProductoTipo);

    void edit(InvProductoTipo invProductoTipo);

    void remove(InvProductoTipo invProductoTipo);

    InvProductoTipo find(Object id);

    List<InvProductoTipo> findAll();

    List<InvProductoTipo> findRange(int[] range);

    int count();
    
}
