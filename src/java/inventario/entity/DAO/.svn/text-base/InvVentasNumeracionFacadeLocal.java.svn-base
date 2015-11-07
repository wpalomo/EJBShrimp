/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvVentasNumeracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvVentasNumeracionFacadeLocal {

    void create(InvVentasNumeracion invVentasNumeracion);

    void edit(InvVentasNumeracion invVentasNumeracion);

    void remove(InvVentasNumeracion invVentasNumeracion);

    InvVentasNumeracion find(Object id);

    List<InvVentasNumeracion> findAll();

    List<InvVentasNumeracion> findRange(int[] range);

    int count();
    
}
