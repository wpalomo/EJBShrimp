/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvComprasRecepcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvComprasRecepcionFacadeLocal {

    void create(InvComprasRecepcion invComprasRecepcion);

    void edit(InvComprasRecepcion invComprasRecepcion);

    void remove(InvComprasRecepcion invComprasRecepcion);

    InvComprasRecepcion find(Object id);

    List<InvComprasRecepcion> findAll();

    List<InvComprasRecepcion> findRange(int[] range);

    int count();
    
}
