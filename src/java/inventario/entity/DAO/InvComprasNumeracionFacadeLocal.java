/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvComprasNumeracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvComprasNumeracionFacadeLocal {

    void create(InvComprasNumeracion invComprasNumeracion);

    void edit(InvComprasNumeracion invComprasNumeracion);

    void remove(InvComprasNumeracion invComprasNumeracion);

    InvComprasNumeracion find(Object id);

    List<InvComprasNumeracion> findAll();

    List<InvComprasNumeracion> findRange(int[] range);

    int count();
    
}
