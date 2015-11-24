/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvComprasDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvComprasDetalleFacadeLocal {

    void create(InvComprasDetalle invComprasDetalle);

    void edit(InvComprasDetalle invComprasDetalle);

    void remove(InvComprasDetalle invComprasDetalle);

    InvComprasDetalle find(Object id);

    List<InvComprasDetalle> findAll();

    List<InvComprasDetalle> findRange(int[] range);

    int count();
    
}
