/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvConsumosDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvConsumosDetalleFacadeLocal {

    void create(InvConsumosDetalle invConsumosDetalle);

    void edit(InvConsumosDetalle invConsumosDetalle);

    void remove(InvConsumosDetalle invConsumosDetalle);

    InvConsumosDetalle find(Object id);

    List<InvConsumosDetalle> findAll();

    List<InvConsumosDetalle> findRange(int[] range);

    int count();
    
}
