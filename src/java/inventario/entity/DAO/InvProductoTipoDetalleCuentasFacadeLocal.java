/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProductoTipoDetalleCuentas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProductoTipoDetalleCuentasFacadeLocal {

    void create(InvProductoTipoDetalleCuentas invProductoTipoDetalleCuentas);

    void edit(InvProductoTipoDetalleCuentas invProductoTipoDetalleCuentas);

    void remove(InvProductoTipoDetalleCuentas invProductoTipoDetalleCuentas);

    InvProductoTipoDetalleCuentas find(Object id);

    List<InvProductoTipoDetalleCuentas> findAll();

    List<InvProductoTipoDetalleCuentas> findRange(int[] range);

    int count();
    
}
