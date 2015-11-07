/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProveedorFacadeLocal {

    void create(InvProveedor invProveedor);

    void edit(InvProveedor invProveedor);

    void remove(InvProveedor invProveedor);

    InvProveedor find(Object id);

    List<InvProveedor> findAll();

    List<InvProveedor> findRange(int[] range);

    int count();
    
}
