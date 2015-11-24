/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProformasDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProformasDetalleFacadeLocal {

    void create(InvProformasDetalle invProformasDetalle);

    void edit(InvProformasDetalle invProformasDetalle);

    void remove(InvProformasDetalle invProformasDetalle);

    InvProformasDetalle find(Object id);

    List<InvProformasDetalle> findAll();

    List<InvProformasDetalle> findRange(int[] range);

    int count();
    
}
