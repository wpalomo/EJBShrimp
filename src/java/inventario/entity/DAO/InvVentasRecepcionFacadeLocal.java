/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvVentasRecepcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvVentasRecepcionFacadeLocal {

    void create(InvVentasRecepcion invVentasRecepcion);

    void edit(InvVentasRecepcion invVentasRecepcion);

    void remove(InvVentasRecepcion invVentasRecepcion);

    InvVentasRecepcion find(Object id);

    List<InvVentasRecepcion> findAll();

    List<InvVentasRecepcion> findRange(int[] range);

    int count();
    
}
