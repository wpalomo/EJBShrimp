/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProformasNumeracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProformasNumeracionFacadeLocal {

    void create(InvProformasNumeracion invProformasNumeracion);

    void edit(InvProformasNumeracion invProformasNumeracion);

    void remove(InvProformasNumeracion invProformasNumeracion);

    InvProformasNumeracion find(Object id);

    List<InvProformasNumeracion> findAll();

    List<InvProformasNumeracion> findRange(int[] range);

    int count();
    
}
