/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvVentas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvVentasFacadeLocal {

    void create(InvVentas invVentas);

    void edit(InvVentas invVentas);

    void remove(InvVentas invVentas);

    InvVentas find(Object id);

    List<InvVentas> findAll();

    List<InvVentas> findRange(int[] range);

    int count();
    
}
