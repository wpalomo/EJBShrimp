/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvVentasDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvVentasDetalleFacadeLocal {

    void create(InvVentasDetalle invVentasDetalle);

    void edit(InvVentasDetalle invVentasDetalle);

    void remove(InvVentasDetalle invVentasDetalle);

    InvVentasDetalle find(Object id);

    List<InvVentasDetalle> findAll();

    List<InvVentasDetalle> findRange(int[] range);

    int count();
    
}
