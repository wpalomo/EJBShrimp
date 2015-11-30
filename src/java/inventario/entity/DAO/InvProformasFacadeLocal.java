/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProformas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProformasFacadeLocal {

    void create(InvProformas invProformas);

    void edit(InvProformas invProformas);

    void remove(InvProformas invProformas);

    InvProformas find(Object id);

    List<InvProformas> findAll();

    List<InvProformas> findRange(int[] range);

    int count();
    
}
