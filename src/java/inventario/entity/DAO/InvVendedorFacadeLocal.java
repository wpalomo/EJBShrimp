/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvVendedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvVendedorFacadeLocal {

    void create(InvVendedor invVendedor);

    void edit(InvVendedor invVendedor);

    void remove(InvVendedor invVendedor);

    InvVendedor find(Object id);

    List<InvVendedor> findAll();

    List<InvVendedor> findRange(int[] range);

    int count();
    
}
